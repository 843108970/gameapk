package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import org.apache.commons.io.FilenameUtils;

public class JsonReader implements Closeable {
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final char[] buffer = new char[1024];
    private final Reader in;
    private boolean lenient = false;
    private int limit = 0;
    private int lineNumber = 0;
    private int lineStart = 0;
    private int[] pathIndices;
    private String[] pathNames;
    int peeked = 0;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int pos = 0;
    private int[] stack = new int[32];
    private int stackSize = 0;

    static {
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() {
            public final void promoteNameToValue(JsonReader jsonReader) throws IOException {
                if (jsonReader instanceof JsonTreeReader) {
                    ((JsonTreeReader) jsonReader).promoteNameToValue();
                    return;
                }
                int i = jsonReader.peeked;
                if (i == 0) {
                    i = jsonReader.doPeek();
                }
                if (i == 13) {
                    jsonReader.peeked = 9;
                } else if (i == 12) {
                    jsonReader.peeked = 8;
                } else if (i == 14) {
                    jsonReader.peeked = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + jsonReader.peek() + jsonReader.locationString());
                }
            }
        };
    }

    public JsonReader(Reader reader) {
        int[] iArr = this.stack;
        int i = this.stackSize;
        this.stackSize = i + 1;
        iArr[i] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.in = reader;
    }

    private void checkLenient() throws IOException {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void consumeNonExecutePrefix() throws IOException {
        nextNonWhitespace(true);
        this.pos--;
        if (this.pos + NON_EXECUTE_PREFIX.length <= this.limit || fillBuffer(NON_EXECUTE_PREFIX.length)) {
            int i = 0;
            while (i < NON_EXECUTE_PREFIX.length) {
                if (this.buffer[this.pos + i] == NON_EXECUTE_PREFIX[i]) {
                    i++;
                } else {
                    return;
                }
            }
            this.pos += NON_EXECUTE_PREFIX.length;
        }
    }

    private boolean fillBuffer(int i) throws IOException {
        char[] cArr = this.buffer;
        this.lineStart -= this.pos;
        if (this.limit != this.pos) {
            this.limit -= this.pos;
            System.arraycopy(cArr, this.pos, cArr, 0, this.limit);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            int read = this.in.read(cArr, this.limit, cArr.length - this.limit);
            if (read == -1) {
                return false;
            }
            this.limit += read;
            if (this.lineNumber == 0 && this.lineStart == 0 && this.limit > 0 && cArr[0] == 65279) {
                this.pos++;
                this.lineStart++;
                i++;
            }
        } while (this.limit < i);
        return true;
    }

    private boolean isLiteral(char c2) throws IOException {
        switch (c2) {
            case 9:
            case 10:
            case 12:
            case 13:
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
                return false;
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
                checkLenient();
                return false;
            default:
                return true;
        }
    }

    /* access modifiers changed from: private */
    public String locationString() {
        return " at line " + (this.lineNumber + 1) + " column " + ((this.pos - this.lineStart) + 1) + " path " + getPath();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        if (r1 != '/') goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0052, code lost:
        r7.pos = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0055, code lost:
        if (r4 != r2) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0057, code lost:
        r7.pos--;
        r2 = fillBuffer(2);
        r7.pos++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0065, code lost:
        if (r2 != false) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0067, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0068, code lost:
        checkLenient();
        r2 = r0[r7.pos];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0071, code lost:
        if (r2 == '*') goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0073, code lost:
        if (r2 == '/') goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0075, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0076, code lost:
        r7.pos++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007c, code lost:
        r7.pos++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0087, code lost:
        if (skipTo("*/") != false) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008f, code lost:
        throw syntaxError("Unterminated comment");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0097, code lost:
        if (r1 != '#') goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0099, code lost:
        r7.pos = r4;
        checkLenient();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a3, code lost:
        r7.pos = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a5, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int nextNonWhitespace(boolean r8) throws java.io.IOException {
        /*
            r7 = this;
            char[] r0 = r7.buffer
        L_0x0002:
            int r1 = r7.pos
        L_0x0004:
            int r2 = r7.limit
        L_0x0006:
            r3 = 1
            if (r1 != r2) goto L_0x0032
            r7.pos = r1
            boolean r1 = r7.fillBuffer(r3)
            if (r1 == 0) goto L_0x0016
            int r1 = r7.pos
            int r2 = r7.limit
            goto L_0x0032
        L_0x0016:
            if (r8 == 0) goto L_0x0030
            java.io.EOFException r8 = new java.io.EOFException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "End of input"
            r0.<init>(r1)
            java.lang.String r1 = r7.locationString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L_0x0030:
            r8 = -1
            return r8
        L_0x0032:
            int r4 = r1 + 1
            char r1 = r0[r1]
            r5 = 10
            if (r1 != r5) goto L_0x0042
            int r1 = r7.lineNumber
            int r1 = r1 + r3
            r7.lineNumber = r1
            r7.lineStart = r4
            goto L_0x00a6
        L_0x0042:
            r5 = 32
            if (r1 == r5) goto L_0x00a6
            r5 = 13
            if (r1 == r5) goto L_0x00a6
            r5 = 9
            if (r1 == r5) goto L_0x00a6
            r5 = 47
            if (r1 != r5) goto L_0x0095
            r7.pos = r4
            r6 = 2
            if (r4 != r2) goto L_0x0068
            int r2 = r7.pos
            int r2 = r2 - r3
            r7.pos = r2
            boolean r2 = r7.fillBuffer(r6)
            int r4 = r7.pos
            int r4 = r4 + r3
            r7.pos = r4
            if (r2 != 0) goto L_0x0068
            return r1
        L_0x0068:
            r7.checkLenient()
            int r2 = r7.pos
            char r2 = r0[r2]
            r4 = 42
            if (r2 == r4) goto L_0x007c
            if (r2 == r5) goto L_0x0076
            return r1
        L_0x0076:
            int r1 = r7.pos
            int r1 = r1 + r3
            r7.pos = r1
            goto L_0x009e
        L_0x007c:
            int r1 = r7.pos
            int r1 = r1 + r3
            r7.pos = r1
            java.lang.String r1 = "*/"
            boolean r1 = r7.skipTo(r1)
            if (r1 != 0) goto L_0x0090
            java.lang.String r8 = "Unterminated comment"
            java.io.IOException r8 = r7.syntaxError(r8)
            throw r8
        L_0x0090:
            int r1 = r7.pos
            int r1 = r1 + r6
            goto L_0x0004
        L_0x0095:
            r2 = 35
            if (r1 != r2) goto L_0x00a3
            r7.pos = r4
            r7.checkLenient()
        L_0x009e:
            r7.skipToEndOfLine()
            goto L_0x0002
        L_0x00a3:
            r7.pos = r4
            return r1
        L_0x00a6:
            r1 = r4
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.nextNonWhitespace(boolean):int");
    }

    private String nextQuotedValue(char c2) throws IOException {
        char[] cArr = this.buffer;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i = this.pos;
            int i2 = this.limit;
            int i3 = i;
            while (true) {
                if (i3 < i2) {
                    int i4 = i3 + 1;
                    char c3 = cArr[i3];
                    if (c3 == c2) {
                        this.pos = i4;
                        sb.append(cArr, i, (i4 - i) - 1);
                        return sb.toString();
                    } else if (c3 == '\\') {
                        this.pos = i4;
                        sb.append(cArr, i, (i4 - i) - 1);
                        sb.append(readEscapeCharacter());
                        break;
                    } else {
                        if (c3 == 10) {
                            this.lineNumber++;
                            this.lineStart = i4;
                        }
                        i3 = i4;
                    }
                } else {
                    sb.append(cArr, i, i3 - i);
                    this.pos = i3;
                    if (!fillBuffer(1)) {
                        throw syntaxError("Unterminated string");
                    }
                }
            }
        }
    }

    private String nextUnquotedValue() throws IOException {
        int i;
        String str;
        int i2 = 0;
        StringBuilder sb = null;
        while (true) {
            i = 0;
            while (true) {
                if (this.pos + i < this.limit) {
                    switch (this.buffer[this.pos + i]) {
                        case 9:
                        case 10:
                        case 12:
                        case 13:
                        case ' ':
                        case ',':
                        case ':':
                        case '[':
                        case ']':
                        case '{':
                        case '}':
                            break;
                        case '#':
                        case '/':
                        case ';':
                        case '=':
                        case '\\':
                            checkLenient();
                            break;
                        default:
                            i++;
                            break;
                    }
                } else if (i >= this.buffer.length) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    sb.append(this.buffer, this.pos, i);
                    this.pos += i;
                    if (!fillBuffer(1)) {
                    }
                } else if (fillBuffer(i + 1)) {
                }
            }
        }
        i2 = i;
        if (sb == null) {
            str = new String(this.buffer, this.pos, i2);
        } else {
            sb.append(this.buffer, this.pos, i2);
            str = sb.toString();
        }
        this.pos += i2;
        return str;
    }

    private int peekKeyword() throws IOException {
        int i;
        String str;
        String str2;
        char c2 = this.buffer[this.pos];
        if (c2 == 't' || c2 == 'T') {
            str2 = "true";
            str = "TRUE";
            i = 5;
        } else if (c2 == 'f' || c2 == 'F') {
            str2 = "false";
            str = "FALSE";
            i = 6;
        } else if (c2 != 'n' && c2 != 'N') {
            return 0;
        } else {
            str2 = "null";
            str = "NULL";
            i = 7;
        }
        int length = str2.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.pos + i2 >= this.limit && !fillBuffer(i2 + 1)) {
                return 0;
            }
            char c3 = this.buffer[this.pos + i2];
            if (c3 != str2.charAt(i2) && c3 != str.charAt(i2)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || fillBuffer(length + 1)) && isLiteral(this.buffer[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.peeked = i;
        return i;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int peekNumber() throws java.io.IOException {
        /*
            r21 = this;
            r0 = r21
            char[] r1 = r0.buffer
            int r2 = r0.pos
            int r3 = r0.limit
            r6 = 1
            r7 = 0
            r8 = r3
            r3 = 0
            r9 = 0
            r10 = 1
            r11 = 0
            r13 = 0
        L_0x0011:
            int r14 = r2 + r3
            r15 = 2
            if (r14 != r8) goto L_0x0026
            int r2 = r1.length
            if (r3 != r2) goto L_0x001a
            return r7
        L_0x001a:
            int r2 = r3 + 1
            boolean r2 = r0.fillBuffer(r2)
            if (r2 == 0) goto L_0x009d
            int r2 = r0.pos
            int r8 = r0.limit
        L_0x0026:
            int r14 = r2 + r3
            char r14 = r1[r14]
            r7 = 43
            r4 = 3
            r5 = 5
            if (r14 == r7) goto L_0x00ea
            r7 = 69
            if (r14 == r7) goto L_0x00de
            r7 = 101(0x65, float:1.42E-43)
            if (r14 == r7) goto L_0x00de
            switch(r14) {
                case 45: goto L_0x00d1;
                case 46: goto L_0x00c9;
                default: goto L_0x003b;
            }
        L_0x003b:
            r7 = 48
            if (r14 < r7) goto L_0x0095
            r7 = 57
            if (r14 <= r7) goto L_0x0044
            goto L_0x0095
        L_0x0044:
            if (r9 == r6) goto L_0x008b
            if (r9 != 0) goto L_0x0049
            goto L_0x008b
        L_0x0049:
            if (r9 != r15) goto L_0x0076
            r18 = 0
            int r4 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r4 != 0) goto L_0x0053
            r4 = 0
            return r4
        L_0x0053:
            r4 = 10
            long r4 = r4 * r11
            int r14 = r14 + -48
            long r14 = (long) r14
            long r16 = r4 - r14
            r4 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r7 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r7 > 0) goto L_0x0070
            int r7 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r7 != 0) goto L_0x006e
            int r4 = (r16 > r11 ? 1 : (r16 == r11 ? 0 : -1))
            if (r4 >= 0) goto L_0x006e
            goto L_0x0070
        L_0x006e:
            r4 = 0
            goto L_0x0071
        L_0x0070:
            r4 = 1
        L_0x0071:
            r4 = r4 & r10
            r10 = r4
            r11 = r16
            goto L_0x0084
        L_0x0076:
            r18 = 0
            if (r9 != r4) goto L_0x007e
            r7 = 0
            r9 = 4
            goto L_0x00f1
        L_0x007e:
            if (r9 == r5) goto L_0x0087
            r4 = 6
            if (r9 != r4) goto L_0x0084
            goto L_0x0087
        L_0x0084:
            r7 = 0
            goto L_0x00f1
        L_0x0087:
            r7 = 0
            r9 = 7
            goto L_0x00f1
        L_0x008b:
            r18 = 0
            int r14 = r14 + -48
            int r4 = -r14
            long r4 = (long) r4
            r11 = r4
            r7 = 0
            r9 = 2
            goto L_0x00f1
        L_0x0095:
            boolean r1 = r0.isLiteral(r14)
            if (r1 == 0) goto L_0x009d
            r1 = 0
            return r1
        L_0x009d:
            if (r9 != r15) goto L_0x00b9
            if (r10 == 0) goto L_0x00b9
            r1 = -9223372036854775808
            int r4 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r4 != 0) goto L_0x00a9
            if (r13 == 0) goto L_0x00b9
        L_0x00a9:
            if (r13 == 0) goto L_0x00ac
            goto L_0x00ad
        L_0x00ac:
            long r11 = -r11
        L_0x00ad:
            r0.peekedLong = r11
            int r1 = r0.pos
            int r1 = r1 + r3
            r0.pos = r1
            r1 = 15
        L_0x00b6:
            r0.peeked = r1
            return r1
        L_0x00b9:
            if (r9 == r15) goto L_0x00c4
            r1 = 4
            if (r9 == r1) goto L_0x00c4
            r1 = 7
            if (r9 != r1) goto L_0x00c2
            goto L_0x00c4
        L_0x00c2:
            r7 = 0
            return r7
        L_0x00c4:
            r0.peekedNumberLength = r3
            r1 = 16
            goto L_0x00b6
        L_0x00c9:
            r7 = 0
            r18 = 0
            if (r9 != r15) goto L_0x00d0
            r9 = 3
            goto L_0x00f1
        L_0x00d0:
            return r7
        L_0x00d1:
            r4 = 6
            r7 = 0
            r18 = 0
            if (r9 != 0) goto L_0x00da
            r9 = 1
            r13 = 1
            goto L_0x00f1
        L_0x00da:
            if (r9 != r5) goto L_0x00dd
            goto L_0x00f0
        L_0x00dd:
            return r7
        L_0x00de:
            r7 = 0
            r18 = 0
            if (r9 == r15) goto L_0x00e8
            r4 = 4
            if (r9 != r4) goto L_0x00e7
            goto L_0x00e8
        L_0x00e7:
            return r7
        L_0x00e8:
            r9 = 5
            goto L_0x00f1
        L_0x00ea:
            r4 = 6
            r7 = 0
            r18 = 0
            if (r9 != r5) goto L_0x00f5
        L_0x00f0:
            r9 = 6
        L_0x00f1:
            int r3 = r3 + 1
            goto L_0x0011
        L_0x00f5:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.peekNumber():int");
    }

    private void push(int i) {
        if (this.stackSize == this.stack.length) {
            int[] iArr = new int[(this.stackSize * 2)];
            int[] iArr2 = new int[(this.stackSize * 2)];
            String[] strArr = new String[(this.stackSize * 2)];
            System.arraycopy(this.stack, 0, iArr, 0, this.stackSize);
            System.arraycopy(this.pathIndices, 0, iArr2, 0, this.stackSize);
            System.arraycopy(this.pathNames, 0, strArr, 0, this.stackSize);
            this.stack = iArr;
            this.pathIndices = iArr2;
            this.pathNames = strArr;
        }
        int[] iArr3 = this.stack;
        int i2 = this.stackSize;
        this.stackSize = i2 + 1;
        iArr3[i2] = i;
    }

    private char readEscapeCharacter() throws IOException {
        int i;
        int i2;
        if (this.pos != this.limit || fillBuffer(1)) {
            char[] cArr = this.buffer;
            int i3 = this.pos;
            this.pos = i3 + 1;
            char c2 = cArr[i3];
            if (c2 == 10) {
                this.lineNumber++;
                this.lineStart = this.pos;
            } else if (!(c2 == '\"' || c2 == '\'' || c2 == '/' || c2 == '\\')) {
                if (c2 == 'b') {
                    return 8;
                }
                if (c2 == 'f') {
                    return 12;
                }
                if (c2 == 'n') {
                    return 10;
                }
                if (c2 == 'r') {
                    return 13;
                }
                switch (c2) {
                    case 't':
                        return 9;
                    case 'u':
                        if (this.pos + 4 <= this.limit || fillBuffer(4)) {
                            char c3 = 0;
                            int i4 = this.pos;
                            int i5 = i4 + 4;
                            while (i4 < i5) {
                                char c4 = this.buffer[i4];
                                char c5 = (char) (c3 << 4);
                                if (c4 < '0' || c4 > '9') {
                                    if (c4 >= 'a' && c4 <= 'f') {
                                        i = c4 - 'a';
                                    } else if (c4 < 'A' || c4 > 'F') {
                                        throw new NumberFormatException("\\u" + new String(this.buffer, this.pos, 4));
                                    } else {
                                        i = c4 - 'A';
                                    }
                                    i2 = i + 10;
                                } else {
                                    i2 = c4 - '0';
                                }
                                c3 = (char) (c5 + i2);
                                i4++;
                            }
                            this.pos += 4;
                            return c3;
                        }
                        throw syntaxError("Unterminated escape sequence");
                    default:
                        throw syntaxError("Invalid escape sequence");
                }
            }
            return c2;
        }
        throw syntaxError("Unterminated escape sequence");
    }

    private void skipQuotedValue(char c2) throws IOException {
        char[] cArr = this.buffer;
        while (true) {
            int i = this.pos;
            int i2 = this.limit;
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    char c3 = cArr[i];
                    if (c3 == c2) {
                        this.pos = i3;
                        return;
                    } else if (c3 == '\\') {
                        this.pos = i3;
                        readEscapeCharacter();
                        break;
                    } else {
                        if (c3 == 10) {
                            this.lineNumber++;
                            this.lineStart = i3;
                        }
                        i = i3;
                    }
                } else {
                    this.pos = i;
                    if (!fillBuffer(1)) {
                        throw syntaxError("Unterminated string");
                    }
                }
            }
        }
    }

    private boolean skipTo(String str) throws IOException {
        while (true) {
            int i = 0;
            if (this.pos + str.length() > this.limit && !fillBuffer(str.length())) {
                return false;
            }
            if (this.buffer[this.pos] == 10) {
                this.lineNumber++;
                this.lineStart = this.pos + 1;
            } else {
                while (i < str.length()) {
                    if (this.buffer[this.pos + i] == str.charAt(i)) {
                        i++;
                    }
                }
                return true;
            }
            this.pos++;
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c2;
        do {
            if (this.pos < this.limit || fillBuffer(1)) {
                char[] cArr = this.buffer;
                int i = this.pos;
                this.pos = i + 1;
                c2 = cArr[i];
                if (c2 == 10) {
                    this.lineNumber++;
                    this.lineStart = this.pos;
                    return;
                }
            } else {
                return;
            }
        } while (c2 != 13);
    }

    private void skipUnquotedValue() throws IOException {
        do {
            int i = 0;
            while (this.pos + i < this.limit) {
                switch (this.buffer[this.pos + i]) {
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        checkLenient();
                        break;
                    default:
                        i++;
                }
                this.pos += i;
                return;
            }
            this.pos += i;
        } while (fillBuffer(1));
    }

    private IOException syntaxError(String str) throws IOException {
        throw new MalformedJsonException(str + locationString());
    }

    public void beginArray() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 3) {
            push(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + locationString());
    }

    public void beginObject() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 1) {
            push(3);
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + locationString());
    }

    public void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.in.close();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x011c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int doPeek() throws java.io.IOException {
        /*
            r15 = this;
            int[] r0 = r15.stack
            int r1 = r15.stackSize
            r2 = 1
            int r1 = r1 - r2
            r0 = r0[r1]
            r1 = 39
            r3 = 34
            r4 = 8
            r5 = 3
            r6 = 93
            r7 = 7
            r8 = 59
            r9 = 44
            r10 = 4
            r11 = 2
            if (r0 != r2) goto L_0x0023
            int[] r12 = r15.stack
            int r13 = r15.stackSize
            int r13 = r13 - r2
            r12[r13] = r11
            goto L_0x00b2
        L_0x0023:
            if (r0 != r11) goto L_0x003e
            int r12 = r15.nextNonWhitespace(r2)
            if (r12 == r9) goto L_0x00b2
            if (r12 == r8) goto L_0x0039
            if (r12 == r6) goto L_0x0036
            java.lang.String r0 = "Unterminated array"
            java.io.IOException r0 = r15.syntaxError(r0)
            throw r0
        L_0x0036:
            r15.peeked = r10
            return r10
        L_0x0039:
            r15.checkLenient()
            goto L_0x00b2
        L_0x003e:
            r12 = 5
            if (r0 == r5) goto L_0x0120
            if (r0 != r12) goto L_0x0045
            goto L_0x0120
        L_0x0045:
            if (r0 != r10) goto L_0x0080
            int[] r13 = r15.stack
            int r14 = r15.stackSize
            int r14 = r14 - r2
            r13[r14] = r12
            int r12 = r15.nextNonWhitespace(r2)
            r13 = 58
            if (r12 == r13) goto L_0x00b2
            r13 = 61
            if (r12 == r13) goto L_0x0061
            java.lang.String r0 = "Expected ':'"
            java.io.IOException r0 = r15.syntaxError(r0)
            throw r0
        L_0x0061:
            r15.checkLenient()
            int r12 = r15.pos
            int r13 = r15.limit
            if (r12 < r13) goto L_0x0070
            boolean r12 = r15.fillBuffer(r2)
            if (r12 == 0) goto L_0x00b2
        L_0x0070:
            char[] r12 = r15.buffer
            int r13 = r15.pos
            char r12 = r12[r13]
            r13 = 62
            if (r12 != r13) goto L_0x00b2
            int r12 = r15.pos
            int r12 = r12 + r2
        L_0x007d:
            r15.pos = r12
            goto L_0x00b2
        L_0x0080:
            r12 = 6
            if (r0 != r12) goto L_0x0092
            boolean r12 = r15.lenient
            if (r12 == 0) goto L_0x008a
            r15.consumeNonExecutePrefix()
        L_0x008a:
            int[] r12 = r15.stack
            int r13 = r15.stackSize
            int r13 = r13 - r2
            r12[r13] = r7
            goto L_0x00b2
        L_0x0092:
            if (r0 != r7) goto L_0x00a8
            r12 = 0
            int r12 = r15.nextNonWhitespace(r12)
            r13 = -1
            if (r12 != r13) goto L_0x00a1
            r0 = 17
        L_0x009e:
            r15.peeked = r0
            return r0
        L_0x00a1:
            r15.checkLenient()
            int r12 = r15.pos
            int r12 = r12 - r2
            goto L_0x007d
        L_0x00a8:
            if (r0 != r4) goto L_0x00b2
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "JsonReader is closed"
            r0.<init>(r1)
            throw r0
        L_0x00b2:
            int r12 = r15.nextNonWhitespace(r2)
            if (r12 == r3) goto L_0x011c
            if (r12 == r1) goto L_0x0116
            if (r12 == r9) goto L_0x00ff
            if (r12 == r8) goto L_0x00ff
            r1 = 91
            if (r12 == r1) goto L_0x00fc
            if (r12 == r6) goto L_0x00f7
            r0 = 123(0x7b, float:1.72E-43)
            if (r12 == r0) goto L_0x00f4
            int r0 = r15.pos
            int r0 = r0 - r2
            r15.pos = r0
            int r0 = r15.peekKeyword()
            if (r0 == 0) goto L_0x00d4
            return r0
        L_0x00d4:
            int r0 = r15.peekNumber()
            if (r0 == 0) goto L_0x00db
            return r0
        L_0x00db:
            char[] r0 = r15.buffer
            int r1 = r15.pos
            char r0 = r0[r1]
            boolean r0 = r15.isLiteral(r0)
            if (r0 != 0) goto L_0x00ee
            java.lang.String r0 = "Expected value"
            java.io.IOException r0 = r15.syntaxError(r0)
            throw r0
        L_0x00ee:
            r15.checkLenient()
            r0 = 10
            goto L_0x009e
        L_0x00f4:
            r15.peeked = r2
            return r2
        L_0x00f7:
            if (r0 != r2) goto L_0x00ff
            r15.peeked = r10
            return r10
        L_0x00fc:
            r15.peeked = r5
            return r5
        L_0x00ff:
            if (r0 == r2) goto L_0x010b
            if (r0 != r11) goto L_0x0104
            goto L_0x010b
        L_0x0104:
            java.lang.String r0 = "Unexpected value"
            java.io.IOException r0 = r15.syntaxError(r0)
            throw r0
        L_0x010b:
            r15.checkLenient()
            int r0 = r15.pos
            int r0 = r0 - r2
            r15.pos = r0
            r15.peeked = r7
            return r7
        L_0x0116:
            r15.checkLenient()
            r15.peeked = r4
            return r4
        L_0x011c:
            r0 = 9
            goto L_0x009e
        L_0x0120:
            int[] r4 = r15.stack
            int r5 = r15.stackSize
            int r5 = r5 - r2
            r4[r5] = r10
            r4 = 125(0x7d, float:1.75E-43)
            if (r0 != r12) goto L_0x0142
            int r5 = r15.nextNonWhitespace(r2)
            if (r5 == r9) goto L_0x0142
            if (r5 == r8) goto L_0x013f
            if (r5 == r4) goto L_0x013c
            java.lang.String r0 = "Unterminated object"
            java.io.IOException r0 = r15.syntaxError(r0)
            throw r0
        L_0x013c:
            r15.peeked = r11
            return r11
        L_0x013f:
            r15.checkLenient()
        L_0x0142:
            int r5 = r15.nextNonWhitespace(r2)
            if (r5 == r3) goto L_0x0179
            if (r5 == r1) goto L_0x0172
            if (r5 == r4) goto L_0x0166
            r15.checkLenient()
            int r0 = r15.pos
            int r0 = r0 - r2
            r15.pos = r0
            char r0 = (char) r5
            boolean r0 = r15.isLiteral(r0)
            if (r0 == 0) goto L_0x015f
            r0 = 14
            goto L_0x009e
        L_0x015f:
            java.lang.String r0 = "Expected name"
            java.io.IOException r0 = r15.syntaxError(r0)
            throw r0
        L_0x0166:
            if (r0 == r12) goto L_0x016b
            r15.peeked = r11
            return r11
        L_0x016b:
            java.lang.String r0 = "Expected name"
            java.io.IOException r0 = r15.syntaxError(r0)
            throw r0
        L_0x0172:
            r15.checkLenient()
            r0 = 12
            goto L_0x009e
        L_0x0179:
            r0 = 13
            goto L_0x009e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.doPeek():int");
    }

    public void endArray() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 4) {
            this.stackSize--;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + peek() + locationString());
    }

    public void endObject() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 2) {
            this.stackSize--;
            this.pathNames[this.stackSize] = null;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + peek() + locationString());
    }

    public String getPath() {
        StringBuilder sb = new StringBuilder("$");
        int i = this.stackSize;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.stack[i2]) {
                case 1:
                case 2:
                    sb.append('[');
                    sb.append(this.pathIndices[i2]);
                    sb.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append(FilenameUtils.EXTENSION_SEPARATOR);
                    if (this.pathNames[i2] == null) {
                        break;
                    } else {
                        sb.append(this.pathNames[i2]);
                        break;
                    }
            }
        }
        return sb.toString();
    }

    public boolean hasNext() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    public boolean nextBoolean() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + peek() + locationString());
        }
    }

    public double nextDouble() throws IOException {
        String nextQuotedValue;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.peekedLong;
        }
        if (i == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            if (i == 8 || i == 9) {
                nextQuotedValue = nextQuotedValue(i == 8 ? '\'' : '\"');
            } else if (i == 10) {
                nextQuotedValue = nextUnquotedValue();
            } else if (i != 11) {
                throw new IllegalStateException("Expected a double but was " + peek() + locationString());
            }
            this.peekedString = nextQuotedValue;
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        if (this.lenient || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        }
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + locationString());
    }

    public int nextInt() throws IOException {
        String nextQuotedValue;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 15) {
            int i2 = (int) this.peekedLong;
            if (this.peekedLong != ((long) i2)) {
                throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
            }
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                nextQuotedValue = nextUnquotedValue();
            } else {
                nextQuotedValue = nextQuotedValue(i == 8 ? '\'' : '\"');
            }
            this.peekedString = nextQuotedValue;
            try {
                int parseInt = Integer.parseInt(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i4 = this.stackSize - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + peek() + locationString());
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        int i5 = (int) parseDouble;
        if (((double) i5) != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr3 = this.pathIndices;
        int i6 = this.stackSize - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    public long nextLong() throws IOException {
        String nextQuotedValue;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.peekedLong;
        }
        if (i == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                nextQuotedValue = nextUnquotedValue();
            } else {
                nextQuotedValue = nextQuotedValue(i == 8 ? '\'' : '\"');
            }
            this.peekedString = nextQuotedValue;
            try {
                long parseLong = Long.parseLong(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i3 = this.stackSize - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + peek() + locationString());
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        long j = (long) parseDouble;
        if (((double) j) != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr3 = this.pathIndices;
        int i4 = this.stackSize - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j;
    }

    public String nextName() throws IOException {
        String str;
        char c2;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 14) {
            str = nextUnquotedValue();
        } else {
            if (i == 12) {
                c2 = '\'';
            } else if (i == 13) {
                c2 = '\"';
            } else {
                throw new IllegalStateException("Expected a name but was " + peek() + locationString());
            }
            str = nextQuotedValue(c2);
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = str;
        return str;
    }

    public void nextNull() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 7) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + peek() + locationString());
    }

    public String nextString() throws IOException {
        String str;
        char c2;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 10) {
            str = nextUnquotedValue();
        } else {
            if (i == 8) {
                c2 = '\'';
            } else if (i == 9) {
                c2 = '\"';
            } else if (i == 11) {
                str = this.peekedString;
                this.peekedString = null;
            } else if (i == 15) {
                str = Long.toString(this.peekedLong);
            } else if (i == 16) {
                str = new String(this.buffer, this.pos, this.peekedNumberLength);
                this.pos += this.peekedNumberLength;
            } else {
                throw new IllegalStateException("Expected a string but was " + peek() + locationString());
            }
            str = nextQuotedValue(c2);
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i2 = this.stackSize - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public JsonToken peek() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        switch (i) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void setLenient(boolean z) {
        this.lenient = z;
    }

    public void skipValue() throws IOException {
        char c2;
        int i = 0;
        do {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 3) {
                push(1);
            } else if (i2 == 1) {
                push(3);
            } else if (i2 == 4 || i2 == 2) {
                this.stackSize--;
                i--;
                this.peeked = 0;
            } else if (i2 == 14 || i2 == 10) {
                skipUnquotedValue();
                this.peeked = 0;
            } else {
                if (i2 == 8 || i2 == 12) {
                    c2 = '\'';
                } else if (i2 == 9 || i2 == 13) {
                    c2 = '\"';
                } else {
                    if (i2 == 16) {
                        this.pos += this.peekedNumberLength;
                    }
                    this.peeked = 0;
                }
                skipQuotedValue(c2);
                this.peeked = 0;
            }
            i++;
            this.peeked = 0;
        } while (i != 0);
        int[] iArr = this.pathIndices;
        int i3 = this.stackSize - 1;
        iArr[i3] = iArr[i3] + 1;
        this.pathNames[this.stackSize - 1] = "null";
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }
}
