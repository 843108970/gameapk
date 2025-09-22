package com.google.protobuf;

import com.cyjh.common.util.s;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;
import com.umeng.commonsdk.proguard.bg;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;

public final class TextFormat {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type = null;
    private static final int BUFFER_SIZE = 4096;
    private static final Printer DEFAULT_PRINTER = new Printer((Printer) null);
    private static final Printer SINGLE_LINE_PRINTER = new Printer((Printer) null).setSingleLineMode(true);
    private static final Printer UNICODE_PRINTER = new Printer((Printer) null).setEscapeNonAscii(false);

    static class InvalidEscapeSequenceException extends IOException {
        private static final long serialVersionUID = -8164033650142593304L;

        InvalidEscapeSequenceException(String str) {
            super(str);
        }
    }

    public static class ParseException extends IOException {
        private static final long serialVersionUID = 3196188060225107702L;
        private final int column;
        private final int line;

        public ParseException(int i, int i2, String str) {
            super(String.valueOf(Integer.toString(i)) + ":" + i2 + ": " + str);
            this.line = i;
            this.column = i2;
        }

        public ParseException(String str) {
            this(-1, -1, str);
        }

        public int getColumn() {
            return this.column;
        }

        public int getLine() {
            return this.line;
        }
    }

    private static final class Printer {
        private static /* synthetic */ int[] $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type;
        boolean escapeNonAscii;
        boolean singleLineMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(38:3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|(2:38|39)|40|42) */
        /* JADX WARNING: Can't wrap try/catch for region: R(39:3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0029 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0045 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0061 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x006a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0074 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x007e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0088 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00a6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x00b0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0016 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0020 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static /* synthetic */ int[] $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type() {
            /*
                int[] r0 = $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type
                if (r0 == 0) goto L_0x0005
                return r0
            L_0x0005:
                com.google.protobuf.Descriptors$FieldDescriptor$Type[] r0 = com.google.protobuf.Descriptors.FieldDescriptor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.BOOL     // Catch:{ NoSuchFieldError -> 0x0016 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.BYTES     // Catch:{ NoSuchFieldError -> 0x0020 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0020 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0020 }
            L_0x0020:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0029 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0029 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0029 }
            L_0x0029:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.ENUM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.FIXED32     // Catch:{ NoSuchFieldError -> 0x003c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.FIXED64     // Catch:{ NoSuchFieldError -> 0x0045 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0045 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0045 }
            L_0x0045:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.FLOAT     // Catch:{ NoSuchFieldError -> 0x004e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.GROUP     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.INT32     // Catch:{ NoSuchFieldError -> 0x0061 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0061 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0061 }
            L_0x0061:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.INT64     // Catch:{ NoSuchFieldError -> 0x006a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006a }
            L_0x006a:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0074 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0074 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0074 }
            L_0x0074:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.SFIXED32     // Catch:{ NoSuchFieldError -> 0x007e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0088 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0088 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0088 }
            L_0x0088:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.SINT32     // Catch:{ NoSuchFieldError -> 0x0092 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0092 }
            L_0x0092:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.SINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.STRING     // Catch:{ NoSuchFieldError -> 0x00a6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a6 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a6 }
            L_0x00a6:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.UINT32     // Catch:{ NoSuchFieldError -> 0x00b0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b0 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b0 }
            L_0x00b0:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.UINT64     // Catch:{ NoSuchFieldError -> 0x00b9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b9 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b9 }
            L_0x00b9:
                $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type = r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.TextFormat.Printer.$SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type():int[]");
        }

        private Printer() {
            this.singleLineMode = false;
            this.escapeNonAscii = true;
        }

        /* synthetic */ Printer(Printer printer) {
            this();
        }

        /* access modifiers changed from: private */
        public void print(MessageOrBuilder messageOrBuilder, TextGenerator textGenerator) throws IOException {
            for (Map.Entry next : messageOrBuilder.getAllFields().entrySet()) {
                printField((Descriptors.FieldDescriptor) next.getKey(), next.getValue(), textGenerator);
            }
            printUnknownFields(messageOrBuilder.getUnknownFields(), textGenerator);
        }

        /* access modifiers changed from: private */
        public void printField(Descriptors.FieldDescriptor fieldDescriptor, Object obj, TextGenerator textGenerator) throws IOException {
            if (fieldDescriptor.isRepeated()) {
                for (Object printSingleField : (List) obj) {
                    printSingleField(fieldDescriptor, printSingleField, textGenerator);
                }
                return;
            }
            printSingleField(fieldDescriptor, obj, textGenerator);
        }

        /* access modifiers changed from: private */
        public void printFieldValue(Descriptors.FieldDescriptor fieldDescriptor, Object obj, TextGenerator textGenerator) throws IOException {
            String d;
            String str;
            switch ($SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type()[fieldDescriptor.getType().ordinal()]) {
                case 1:
                    d = ((Double) obj).toString();
                    break;
                case 2:
                    d = ((Float) obj).toString();
                    break;
                case 3:
                case 16:
                case 18:
                    d = ((Long) obj).toString();
                    break;
                case 4:
                case 6:
                    d = TextFormat.unsignedToString(((Long) obj).longValue());
                    break;
                case 5:
                case 15:
                case 17:
                    d = ((Integer) obj).toString();
                    break;
                case 7:
                case 13:
                    d = TextFormat.unsignedToString(((Integer) obj).intValue());
                    break;
                case 8:
                    d = ((Boolean) obj).toString();
                    break;
                case 9:
                    textGenerator.print("\"");
                    if (!this.escapeNonAscii) {
                        str = (String) obj;
                        break;
                    } else {
                        str = TextFormat.escapeText((String) obj);
                        break;
                    }
                case 10:
                case 11:
                    print((Message) obj, textGenerator);
                    return;
                case 12:
                    textGenerator.print("\"");
                    str = TextFormat.escapeBytes((ByteString) obj);
                    break;
                case 14:
                    d = ((Descriptors.EnumValueDescriptor) obj).getName();
                    break;
                default:
                    return;
            }
            textGenerator.print(str);
            d = "\"";
            textGenerator.print(d);
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x0085  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0095  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void printSingleField(com.google.protobuf.Descriptors.FieldDescriptor r3, java.lang.Object r4, com.google.protobuf.TextFormat.TextGenerator r5) throws java.io.IOException {
            /*
                r2 = this;
                boolean r0 = r3.isExtension()
                if (r0 == 0) goto L_0x0044
                java.lang.String r0 = "["
                r5.print(r0)
                com.google.protobuf.Descriptors$Descriptor r0 = r3.getContainingType()
                com.google.protobuf.DescriptorProtos$MessageOptions r0 = r0.getOptions()
                boolean r0 = r0.getMessageSetWireFormat()
                if (r0 == 0) goto L_0x003a
                com.google.protobuf.Descriptors$FieldDescriptor$Type r0 = r3.getType()
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.MESSAGE
                if (r0 != r1) goto L_0x003a
                boolean r0 = r3.isOptional()
                if (r0 == 0) goto L_0x003a
                com.google.protobuf.Descriptors$Descriptor r0 = r3.getExtensionScope()
                com.google.protobuf.Descriptors$Descriptor r1 = r3.getMessageType()
                if (r0 != r1) goto L_0x003a
                com.google.protobuf.Descriptors$Descriptor r0 = r3.getMessageType()
                java.lang.String r0 = r0.getFullName()
                goto L_0x003e
            L_0x003a:
                java.lang.String r0 = r3.getFullName()
            L_0x003e:
                r5.print(r0)
                java.lang.String r0 = "]"
                goto L_0x0054
            L_0x0044:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r0 = r3.getType()
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.GROUP
                if (r0 != r1) goto L_0x0058
                com.google.protobuf.Descriptors$Descriptor r0 = r3.getMessageType()
                java.lang.String r0 = r0.getName()
            L_0x0054:
                r5.print(r0)
                goto L_0x005d
            L_0x0058:
                java.lang.String r0 = r3.getName()
                goto L_0x0054
            L_0x005d:
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r0 = r3.getJavaType()
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r1 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE
                if (r0 != r1) goto L_0x0075
                boolean r0 = r2.singleLineMode
                if (r0 == 0) goto L_0x006c
                java.lang.String r0 = " { "
                goto L_0x0077
            L_0x006c:
                java.lang.String r0 = " {\n"
                r5.print(r0)
                r5.indent()
                goto L_0x007a
            L_0x0075:
                java.lang.String r0 = ": "
            L_0x0077:
                r5.print(r0)
            L_0x007a:
                r2.printFieldValue(r3, r4, r5)
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r3 = r3.getJavaType()
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r4 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE
                if (r3 != r4) goto L_0x0095
                boolean r3 = r2.singleLineMode
                if (r3 == 0) goto L_0x008f
                java.lang.String r3 = "} "
            L_0x008b:
                r5.print(r3)
                return
            L_0x008f:
                r5.outdent()
                java.lang.String r3 = "}\n"
                goto L_0x008b
            L_0x0095:
                boolean r3 = r2.singleLineMode
                if (r3 == 0) goto L_0x009c
                java.lang.String r3 = " "
                goto L_0x008b
            L_0x009c:
                java.lang.String r3 = "\n"
                goto L_0x008b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.TextFormat.Printer.printSingleField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object, com.google.protobuf.TextFormat$TextGenerator):void");
        }

        private void printUnknownField(int i, int i2, List<?> list, TextGenerator textGenerator) throws IOException {
            for (Object next : list) {
                textGenerator.print(String.valueOf(i));
                textGenerator.print(": ");
                TextFormat.printUnknownFieldValue(i2, (Object) next, textGenerator);
                textGenerator.print(this.singleLineMode ? s.a.f1696a : "\n");
            }
        }

        /* access modifiers changed from: private */
        public void printUnknownFields(UnknownFieldSet unknownFieldSet, TextGenerator textGenerator) throws IOException {
            String str;
            for (Map.Entry next : unknownFieldSet.asMap().entrySet()) {
                int intValue = ((Integer) next.getKey()).intValue();
                UnknownFieldSet.Field field = (UnknownFieldSet.Field) next.getValue();
                printUnknownField(intValue, 0, field.getVarintList(), textGenerator);
                printUnknownField(intValue, 5, field.getFixed32List(), textGenerator);
                printUnknownField(intValue, 1, field.getFixed64List(), textGenerator);
                printUnknownField(intValue, 2, field.getLengthDelimitedList(), textGenerator);
                for (UnknownFieldSet next2 : field.getGroupList()) {
                    textGenerator.print(((Integer) next.getKey()).toString());
                    if (this.singleLineMode) {
                        textGenerator.print(" { ");
                    } else {
                        textGenerator.print(" {\n");
                        textGenerator.indent();
                    }
                    printUnknownFields(next2, textGenerator);
                    if (this.singleLineMode) {
                        str = "} ";
                    } else {
                        textGenerator.outdent();
                        str = "}\n";
                    }
                    textGenerator.print(str);
                }
            }
        }

        /* access modifiers changed from: private */
        public Printer setEscapeNonAscii(boolean z) {
            this.escapeNonAscii = z;
            return this;
        }

        /* access modifiers changed from: private */
        public Printer setSingleLineMode(boolean z) {
            this.singleLineMode = z;
            return this;
        }
    }

    private static final class TextGenerator {
        private boolean atStartOfLine;
        private final StringBuilder indent;
        private final Appendable output;

        private TextGenerator(Appendable appendable) {
            this.indent = new StringBuilder();
            this.atStartOfLine = true;
            this.output = appendable;
        }

        /* synthetic */ TextGenerator(Appendable appendable, TextGenerator textGenerator) {
            this(appendable);
        }

        private void write(CharSequence charSequence, int i) throws IOException {
            if (i != 0) {
                if (this.atStartOfLine) {
                    this.atStartOfLine = false;
                    this.output.append(this.indent);
                }
                this.output.append(charSequence);
            }
        }

        public final void indent() {
            this.indent.append("  ");
        }

        public final void outdent() {
            int length = this.indent.length();
            if (length == 0) {
                throw new IllegalArgumentException(" Outdent() without matching Indent().");
            }
            this.indent.delete(length - 2, length);
        }

        public final void print(CharSequence charSequence) throws IOException {
            int length = charSequence.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (charSequence.charAt(i2) == 10) {
                    write(charSequence.subSequence(i, length), (i2 - i) + 1);
                    i = i2 + 1;
                    this.atStartOfLine = true;
                }
            }
            write(charSequence.subSequence(i, length), length - i);
        }
    }

    private static final class Tokenizer {
        private static final Pattern DOUBLE_INFINITY = Pattern.compile("-?inf(inity)?", 2);
        private static final Pattern FLOAT_INFINITY = Pattern.compile("-?inf(inity)?f?", 2);
        private static final Pattern FLOAT_NAN = Pattern.compile("nanf?", 2);
        private static final Pattern TOKEN = Pattern.compile("[a-zA-Z_][0-9a-zA-Z_+-]*+|[.]?[0-9+-][0-9a-zA-Z_.+-]*+|\"([^\"\n\\\\]|\\\\.)*+(\"|\\\\?$)|'([^'\n\\\\]|\\\\.)*+('|\\\\?$)", 8);
        private static final Pattern WHITESPACE = Pattern.compile("(\\s|(#.*$))++", 8);
        private int column;
        private String currentToken;
        private int line;
        private final Matcher matcher;
        private int pos;
        private int previousColumn;
        private int previousLine;
        private final CharSequence text;

        private Tokenizer(CharSequence charSequence) {
            this.pos = 0;
            this.line = 0;
            this.column = 0;
            this.previousLine = 0;
            this.previousColumn = 0;
            this.text = charSequence;
            this.matcher = WHITESPACE.matcher(charSequence);
            skipWhitespace();
            nextToken();
        }

        /* synthetic */ Tokenizer(CharSequence charSequence, Tokenizer tokenizer) {
            this(charSequence);
        }

        private void consumeByteString(List<ByteString> list) throws ParseException {
            char c2 = 0;
            if (this.currentToken.length() > 0) {
                c2 = this.currentToken.charAt(0);
            }
            if (c2 != '\"' && c2 != '\'') {
                throw parseException("Expected string.");
            } else if (this.currentToken.length() < 2 || this.currentToken.charAt(this.currentToken.length() - 1) != c2) {
                throw parseException("String missing ending quote.");
            } else {
                try {
                    ByteString unescapeBytes = TextFormat.unescapeBytes(this.currentToken.substring(1, this.currentToken.length() - 1));
                    nextToken();
                    list.add(unescapeBytes);
                } catch (InvalidEscapeSequenceException e) {
                    throw parseException(e.getMessage());
                }
            }
        }

        private ParseException floatParseException(NumberFormatException numberFormatException) {
            return parseException("Couldn't parse number: " + numberFormatException.getMessage());
        }

        private ParseException integerParseException(NumberFormatException numberFormatException) {
            return parseException("Couldn't parse integer: " + numberFormatException.getMessage());
        }

        private void skipWhitespace() {
            this.matcher.usePattern(WHITESPACE);
            if (this.matcher.lookingAt()) {
                this.matcher.region(this.matcher.end(), this.matcher.regionEnd());
            }
        }

        public final boolean atEnd() {
            return this.currentToken.length() == 0;
        }

        public final void consume(String str) throws ParseException {
            if (!tryConsume(str)) {
                throw parseException("Expected \"" + str + "\".");
            }
        }

        public final boolean consumeBoolean() throws ParseException {
            if (this.currentToken.equals("true") || this.currentToken.equals("t") || this.currentToken.equals("1")) {
                nextToken();
                return true;
            } else if (this.currentToken.equals("false") || this.currentToken.equals("f") || this.currentToken.equals("0")) {
                nextToken();
                return false;
            } else {
                throw parseException("Expected \"true\" or \"false\".");
            }
        }

        public final ByteString consumeByteString() throws ParseException {
            ArrayList arrayList = new ArrayList();
            while (true) {
                consumeByteString(arrayList);
                if (!this.currentToken.startsWith("'") && !this.currentToken.startsWith("\"")) {
                    return ByteString.copyFrom((Iterable<ByteString>) arrayList);
                }
            }
        }

        public final double consumeDouble() throws ParseException {
            if (DOUBLE_INFINITY.matcher(this.currentToken).matches()) {
                boolean startsWith = this.currentToken.startsWith("-");
                nextToken();
                return startsWith ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
            } else if (this.currentToken.equalsIgnoreCase("nan")) {
                nextToken();
                return Double.NaN;
            } else {
                try {
                    double parseDouble = Double.parseDouble(this.currentToken);
                    nextToken();
                    return parseDouble;
                } catch (NumberFormatException e) {
                    throw floatParseException(e);
                }
            }
        }

        public final float consumeFloat() throws ParseException {
            if (FLOAT_INFINITY.matcher(this.currentToken).matches()) {
                boolean startsWith = this.currentToken.startsWith("-");
                nextToken();
                return startsWith ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
            } else if (FLOAT_NAN.matcher(this.currentToken).matches()) {
                nextToken();
                return Float.NaN;
            } else {
                try {
                    float parseFloat = Float.parseFloat(this.currentToken);
                    nextToken();
                    return parseFloat;
                } catch (NumberFormatException e) {
                    throw floatParseException(e);
                }
            }
        }

        public final String consumeIdentifier() throws ParseException {
            for (int i = 0; i < this.currentToken.length(); i++) {
                char charAt = this.currentToken.charAt(i);
                if (('a' > charAt || charAt > 'z') && (('A' > charAt || charAt > 'Z') && !(('0' <= charAt && charAt <= '9') || charAt == '_' || charAt == '.'))) {
                    throw parseException("Expected identifier.");
                }
            }
            String str = this.currentToken;
            nextToken();
            return str;
        }

        public final int consumeInt32() throws ParseException {
            try {
                int parseInt32 = TextFormat.parseInt32(this.currentToken);
                nextToken();
                return parseInt32;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public final long consumeInt64() throws ParseException {
            try {
                long parseInt64 = TextFormat.parseInt64(this.currentToken);
                nextToken();
                return parseInt64;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public final String consumeString() throws ParseException {
            return consumeByteString().toStringUtf8();
        }

        public final int consumeUInt32() throws ParseException {
            try {
                int parseUInt32 = TextFormat.parseUInt32(this.currentToken);
                nextToken();
                return parseUInt32;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public final long consumeUInt64() throws ParseException {
            try {
                long parseUInt64 = TextFormat.parseUInt64(this.currentToken);
                nextToken();
                return parseUInt64;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public final boolean lookingAtInteger() {
            if (this.currentToken.length() == 0) {
                return false;
            }
            char charAt = this.currentToken.charAt(0);
            return ('0' <= charAt && charAt <= '9') || charAt == '-' || charAt == '+';
        }

        public final void nextToken() {
            Matcher matcher2;
            int i;
            int i2;
            this.previousLine = this.line;
            this.previousColumn = this.column;
            while (this.pos < this.matcher.regionStart()) {
                if (this.text.charAt(this.pos) == 10) {
                    this.line++;
                    i2 = 0;
                } else {
                    i2 = this.column + 1;
                }
                this.column = i2;
                this.pos++;
            }
            if (this.matcher.regionStart() == this.matcher.regionEnd()) {
                this.currentToken = "";
                return;
            }
            this.matcher.usePattern(TOKEN);
            if (this.matcher.lookingAt()) {
                this.currentToken = this.matcher.group();
                matcher2 = this.matcher;
                i = this.matcher.end();
            } else {
                this.currentToken = String.valueOf(this.text.charAt(this.pos));
                matcher2 = this.matcher;
                i = this.pos + 1;
            }
            matcher2.region(i, this.matcher.regionEnd());
            skipWhitespace();
        }

        public final ParseException parseException(String str) {
            return new ParseException(this.line + 1, this.column + 1, str);
        }

        public final ParseException parseExceptionPreviousToken(String str) {
            return new ParseException(this.previousLine + 1, this.previousColumn + 1, str);
        }

        public final boolean tryConsume(String str) {
            if (!this.currentToken.equals(str)) {
                return false;
            }
            nextToken();
            return true;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(38:3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|(2:38|39)|40|42) */
    /* JADX WARNING: Can't wrap try/catch for region: R(39:3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|42) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0029 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0033 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0045 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x004e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0058 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0061 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x006a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0074 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x007e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0088 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0092 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x009c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00a6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x00b0 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0016 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0020 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ int[] $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type() {
        /*
            int[] r0 = $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            com.google.protobuf.Descriptors$FieldDescriptor$Type[] r0 = com.google.protobuf.Descriptors.FieldDescriptor.Type.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.BOOL     // Catch:{ NoSuchFieldError -> 0x0016 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0016 }
            r2 = 8
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
        L_0x0016:
            com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.BYTES     // Catch:{ NoSuchFieldError -> 0x0020 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0020 }
            r2 = 12
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0020 }
        L_0x0020:
            com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0029 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0029 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0029 }
        L_0x0029:
            com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.ENUM     // Catch:{ NoSuchFieldError -> 0x0033 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
            r2 = 14
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
        L_0x0033:
            com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.FIXED32     // Catch:{ NoSuchFieldError -> 0x003c }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
            r2 = 7
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003c }
        L_0x003c:
            com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.FIXED64     // Catch:{ NoSuchFieldError -> 0x0045 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0045 }
            r2 = 6
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0045 }
        L_0x0045:
            com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.FLOAT     // Catch:{ NoSuchFieldError -> 0x004e }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
        L_0x004e:
            com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.GROUP     // Catch:{ NoSuchFieldError -> 0x0058 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
            r2 = 10
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
        L_0x0058:
            com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.INT32     // Catch:{ NoSuchFieldError -> 0x0061 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0061 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0061 }
        L_0x0061:
            com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.INT64     // Catch:{ NoSuchFieldError -> 0x006a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006a }
        L_0x006a:
            com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0074 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0074 }
            r2 = 11
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0074 }
        L_0x0074:
            com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.SFIXED32     // Catch:{ NoSuchFieldError -> 0x007e }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
            r2 = 15
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007e }
        L_0x007e:
            com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0088 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0088 }
            r2 = 16
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0088 }
        L_0x0088:
            com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.SINT32     // Catch:{ NoSuchFieldError -> 0x0092 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
            r2 = 17
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0092 }
        L_0x0092:
            com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.SINT64     // Catch:{ NoSuchFieldError -> 0x009c }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
            r2 = 18
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
        L_0x009c:
            com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.STRING     // Catch:{ NoSuchFieldError -> 0x00a6 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a6 }
            r2 = 9
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a6 }
        L_0x00a6:
            com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.UINT32     // Catch:{ NoSuchFieldError -> 0x00b0 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b0 }
            r2 = 13
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b0 }
        L_0x00b0:
            com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.UINT64     // Catch:{ NoSuchFieldError -> 0x00b9 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b9 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b9 }
        L_0x00b9:
            $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.TextFormat.$SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type():int[]");
    }

    private TextFormat() {
    }

    private static int digitValue(byte b2) {
        if (48 <= b2 && b2 <= 57) {
            return b2 - 48;
        }
        return ((97 > b2 || b2 > 122) ? b2 - 65 : b2 - 97) + 10;
    }

    static String escapeBytes(ByteString byteString) {
        String str;
        StringBuilder sb = new StringBuilder(byteString.size());
        for (int i = 0; i < byteString.size(); i++) {
            int byteAt = byteString.byteAt(i);
            if (byteAt == 34) {
                str = "\\\"";
            } else if (byteAt == 39) {
                str = "\\'";
            } else if (byteAt != 92) {
                switch (byteAt) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (byteAt < 32) {
                            sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                            sb.append((char) (((byteAt >>> 6) & 3) + 48));
                            sb.append((char) (((byteAt >>> 3) & 7) + 48));
                            byteAt = (byteAt & 7) + 48;
                        }
                        sb.append((char) byteAt);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    static String escapeText(String str) {
        return escapeBytes(ByteString.copyFromUtf8(str));
    }

    private static boolean isHex(byte b2) {
        if (48 <= b2 && b2 <= 57) {
            return true;
        }
        if (97 > b2 || b2 > 102) {
            return 65 <= b2 && b2 <= 70;
        }
        return true;
    }

    private static boolean isOctal(byte b2) {
        return 48 <= b2 && b2 <= 55;
    }

    public static void merge(CharSequence charSequence, ExtensionRegistry extensionRegistry, Message.Builder builder) throws ParseException {
        Tokenizer tokenizer = new Tokenizer(charSequence, (Tokenizer) null);
        while (!tokenizer.atEnd()) {
            mergeField(tokenizer, extensionRegistry, builder);
        }
    }

    public static void merge(CharSequence charSequence, Message.Builder builder) throws ParseException {
        merge(charSequence, ExtensionRegistry.getEmptyRegistry(), builder);
    }

    public static void merge(Readable readable, ExtensionRegistry extensionRegistry, Message.Builder builder) throws IOException {
        merge((CharSequence) toStringBuilder(readable), extensionRegistry, builder);
    }

    public static void merge(Readable readable, Message.Builder builder) throws IOException {
        merge(readable, ExtensionRegistry.getEmptyRegistry(), builder);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01db, code lost:
        r3 = java.lang.Integer.valueOf(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01e9, code lost:
        r3 = java.lang.Long.valueOf(r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void mergeField(com.google.protobuf.TextFormat.Tokenizer r7, com.google.protobuf.ExtensionRegistry r8, com.google.protobuf.Message.Builder r9) throws com.google.protobuf.TextFormat.ParseException {
        /*
            com.google.protobuf.Descriptors$Descriptor r0 = r9.getDescriptorForType()
            java.lang.String r1 = "["
            boolean r1 = r7.tryConsume(r1)
            r2 = 46
            r3 = 0
            if (r1 == 0) goto L_0x0081
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = r7.consumeIdentifier()
            r1.<init>(r4)
        L_0x0018:
            java.lang.String r4 = "."
            boolean r4 = r7.tryConsume(r4)
            if (r4 != 0) goto L_0x0076
            java.lang.String r4 = r1.toString()
            com.google.protobuf.ExtensionRegistry$ExtensionInfo r4 = r8.findExtensionByName(r4)
            if (r4 != 0) goto L_0x0042
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Extension \""
            r8.<init>(r9)
            r8.append(r1)
            java.lang.String r9 = "\" not found in the ExtensionRegistry."
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            com.google.protobuf.TextFormat$ParseException r7 = r7.parseExceptionPreviousToken(r8)
            throw r7
        L_0x0042:
            com.google.protobuf.Descriptors$FieldDescriptor r5 = r4.descriptor
            com.google.protobuf.Descriptors$Descriptor r5 = r5.getContainingType()
            if (r5 == r0) goto L_0x006e
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Extension \""
            r8.<init>(r9)
            r8.append(r1)
            java.lang.String r9 = "\" does not extend message type \""
            r8.append(r9)
            java.lang.String r9 = r0.getFullName()
            r8.append(r9)
            java.lang.String r9 = "\"."
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            com.google.protobuf.TextFormat$ParseException r7 = r7.parseExceptionPreviousToken(r8)
            throw r7
        L_0x006e:
            java.lang.String r0 = "]"
            r7.consume(r0)
            com.google.protobuf.Descriptors$FieldDescriptor r0 = r4.descriptor
            goto L_0x00e1
        L_0x0076:
            r1.append(r2)
            java.lang.String r4 = r7.consumeIdentifier()
            r1.append(r4)
            goto L_0x0018
        L_0x0081:
            java.lang.String r1 = r7.consumeIdentifier()
            com.google.protobuf.Descriptors$FieldDescriptor r4 = r0.findFieldByName(r1)
            if (r4 != 0) goto L_0x00a0
            java.util.Locale r4 = java.util.Locale.US
            java.lang.String r4 = r1.toLowerCase(r4)
            com.google.protobuf.Descriptors$FieldDescriptor r4 = r0.findFieldByName(r4)
            if (r4 == 0) goto L_0x00a0
            com.google.protobuf.Descriptors$FieldDescriptor$Type r5 = r4.getType()
            com.google.protobuf.Descriptors$FieldDescriptor$Type r6 = com.google.protobuf.Descriptors.FieldDescriptor.Type.GROUP
            if (r5 == r6) goto L_0x00a0
            r4 = r3
        L_0x00a0:
            if (r4 == 0) goto L_0x00b9
            com.google.protobuf.Descriptors$FieldDescriptor$Type r5 = r4.getType()
            com.google.protobuf.Descriptors$FieldDescriptor$Type r6 = com.google.protobuf.Descriptors.FieldDescriptor.Type.GROUP
            if (r5 != r6) goto L_0x00b9
            com.google.protobuf.Descriptors$Descriptor r5 = r4.getMessageType()
            java.lang.String r5 = r5.getName()
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x00b9
            r4 = r3
        L_0x00b9:
            if (r4 != 0) goto L_0x00df
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Message type \""
            r8.<init>(r9)
            java.lang.String r9 = r0.getFullName()
            r8.append(r9)
            java.lang.String r9 = "\" has no field named \""
            r8.append(r9)
            r8.append(r1)
            java.lang.String r9 = "\"."
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            com.google.protobuf.TextFormat$ParseException r7 = r7.parseExceptionPreviousToken(r8)
            throw r7
        L_0x00df:
            r0 = r4
            r4 = r3
        L_0x00e1:
            com.google.protobuf.Descriptors$FieldDescriptor$JavaType r1 = r0.getJavaType()
            com.google.protobuf.Descriptors$FieldDescriptor$JavaType r5 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE
            if (r1 != r5) goto L_0x013b
            java.lang.String r1 = ":"
            r7.tryConsume(r1)
            java.lang.String r1 = "<"
            boolean r1 = r7.tryConsume(r1)
            if (r1 == 0) goto L_0x00f9
            java.lang.String r1 = ">"
            goto L_0x0100
        L_0x00f9:
            java.lang.String r1 = "{"
            r7.consume(r1)
            java.lang.String r1 = "}"
        L_0x0100:
            if (r4 != 0) goto L_0x0107
            com.google.protobuf.Message$Builder r2 = r9.newBuilderForField(r0)
            goto L_0x010d
        L_0x0107:
            com.google.protobuf.Message r2 = r4.defaultInstance
            com.google.protobuf.Message$Builder r2 = r2.newBuilderForType()
        L_0x010d:
            boolean r3 = r7.tryConsume(r1)
            if (r3 == 0) goto L_0x0119
            com.google.protobuf.Message r3 = r2.buildPartial()
            goto L_0x01ff
        L_0x0119:
            boolean r3 = r7.atEnd()
            if (r3 == 0) goto L_0x0137
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Expected \""
            r8.<init>(r9)
            r8.append(r1)
            java.lang.String r9 = "\"."
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            com.google.protobuf.TextFormat$ParseException r7 = r7.parseException(r8)
            throw r7
        L_0x0137:
            mergeField(r7, r8, r2)
            goto L_0x010d
        L_0x013b:
            java.lang.String r8 = ":"
            r7.consume(r8)
            int[] r8 = $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type()
            com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = r0.getType()
            int r1 = r1.ordinal()
            r8 = r8[r1]
            switch(r8) {
                case 1: goto L_0x01f7;
                case 2: goto L_0x01ee;
                case 3: goto L_0x01e5;
                case 4: goto L_0x01e0;
                case 5: goto L_0x01d7;
                case 6: goto L_0x01e0;
                case 7: goto L_0x01d2;
                case 8: goto L_0x01c9;
                case 9: goto L_0x01c4;
                case 10: goto L_0x01bc;
                case 11: goto L_0x01bc;
                case 12: goto L_0x01b7;
                case 13: goto L_0x01d2;
                case 14: goto L_0x0153;
                case 15: goto L_0x01d7;
                case 16: goto L_0x01e5;
                case 17: goto L_0x01d7;
                case 18: goto L_0x01e5;
                default: goto L_0x0151;
            }
        L_0x0151:
            goto L_0x01ff
        L_0x0153:
            com.google.protobuf.Descriptors$EnumDescriptor r8 = r0.getEnumType()
            boolean r1 = r7.lookingAtInteger()
            if (r1 == 0) goto L_0x0189
            int r1 = r7.consumeInt32()
            com.google.protobuf.Descriptors$EnumValueDescriptor r3 = r8.findValueByNumber((int) r1)
            if (r3 != 0) goto L_0x01ff
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "Enum type \""
            r9.<init>(r0)
            java.lang.String r8 = r8.getFullName()
            r9.append(r8)
            java.lang.String r8 = "\" has no value with number "
            r9.append(r8)
            r9.append(r1)
            r9.append(r2)
            java.lang.String r8 = r9.toString()
            com.google.protobuf.TextFormat$ParseException r7 = r7.parseExceptionPreviousToken(r8)
            throw r7
        L_0x0189:
            java.lang.String r1 = r7.consumeIdentifier()
            com.google.protobuf.Descriptors$EnumValueDescriptor r3 = r8.findValueByName(r1)
            if (r3 != 0) goto L_0x01ff
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "Enum type \""
            r9.<init>(r0)
            java.lang.String r8 = r8.getFullName()
            r9.append(r8)
            java.lang.String r8 = "\" has no value named \""
            r9.append(r8)
            r9.append(r1)
            java.lang.String r8 = "\"."
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            com.google.protobuf.TextFormat$ParseException r7 = r7.parseExceptionPreviousToken(r8)
            throw r7
        L_0x01b7:
            com.google.protobuf.ByteString r3 = r7.consumeByteString()
            goto L_0x01ff
        L_0x01bc:
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            java.lang.String r8 = "Can't get here."
            r7.<init>(r8)
            throw r7
        L_0x01c4:
            java.lang.String r3 = r7.consumeString()
            goto L_0x01ff
        L_0x01c9:
            boolean r7 = r7.consumeBoolean()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r7)
            goto L_0x01ff
        L_0x01d2:
            int r7 = r7.consumeUInt32()
            goto L_0x01db
        L_0x01d7:
            int r7 = r7.consumeInt32()
        L_0x01db:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            goto L_0x01ff
        L_0x01e0:
            long r7 = r7.consumeUInt64()
            goto L_0x01e9
        L_0x01e5:
            long r7 = r7.consumeInt64()
        L_0x01e9:
            java.lang.Long r3 = java.lang.Long.valueOf(r7)
            goto L_0x01ff
        L_0x01ee:
            float r7 = r7.consumeFloat()
            java.lang.Float r3 = java.lang.Float.valueOf(r7)
            goto L_0x01ff
        L_0x01f7:
            double r7 = r7.consumeDouble()
            java.lang.Double r3 = java.lang.Double.valueOf(r7)
        L_0x01ff:
            boolean r7 = r0.isRepeated()
            if (r7 == 0) goto L_0x0209
            r9.addRepeatedField(r0, r3)
            return
        L_0x0209:
            r9.setField(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.TextFormat.mergeField(com.google.protobuf.TextFormat$Tokenizer, com.google.protobuf.ExtensionRegistry, com.google.protobuf.Message$Builder):void");
    }

    static int parseInt32(String str) throws NumberFormatException {
        return (int) parseInteger(str, true, false);
    }

    static long parseInt64(String str) throws NumberFormatException {
        return parseInteger(str, true, true);
    }

    private static long parseInteger(String str, boolean z, boolean z2) throws NumberFormatException {
        int i = 0;
        boolean z3 = true;
        if (!str.startsWith("-", 0)) {
            z3 = false;
        } else if (!z) {
            throw new NumberFormatException("Number must be positive: " + str);
        } else {
            i = 1;
        }
        int i2 = 10;
        if (str.startsWith("0x", i)) {
            i += 2;
            i2 = 16;
        } else if (str.startsWith("0", i)) {
            i2 = 8;
        }
        String substring = str.substring(i);
        if (substring.length() < 16) {
            long parseLong = Long.parseLong(substring, i2);
            if (z3) {
                parseLong = -parseLong;
            }
            if (z2) {
                return parseLong;
            }
            if (z) {
                if (parseLong <= 2147483647L && parseLong >= -2147483648L) {
                    return parseLong;
                }
                throw new NumberFormatException("Number out of range for 32-bit signed integer: " + str);
            } else if (parseLong < 4294967296L && parseLong >= 0) {
                return parseLong;
            } else {
                throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + str);
            }
        } else {
            BigInteger bigInteger = new BigInteger(substring, i2);
            if (z3) {
                bigInteger = bigInteger.negate();
            }
            if (!z2) {
                if (z) {
                    if (bigInteger.bitLength() > 31) {
                        throw new NumberFormatException("Number out of range for 32-bit signed integer: " + str);
                    }
                } else if (bigInteger.bitLength() > 32) {
                    throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + str);
                }
            } else if (z) {
                if (bigInteger.bitLength() > 63) {
                    throw new NumberFormatException("Number out of range for 64-bit signed integer: " + str);
                }
            } else if (bigInteger.bitLength() > 64) {
                throw new NumberFormatException("Number out of range for 64-bit unsigned integer: " + str);
            }
            return bigInteger.longValue();
        }
    }

    static int parseUInt32(String str) throws NumberFormatException {
        return (int) parseInteger(str, false, false);
    }

    static long parseUInt64(String str) throws NumberFormatException {
        return parseInteger(str, false, true);
    }

    public static void print(MessageOrBuilder messageOrBuilder, Appendable appendable) throws IOException {
        DEFAULT_PRINTER.print(messageOrBuilder, new TextGenerator(appendable, (TextGenerator) null));
    }

    public static void print(UnknownFieldSet unknownFieldSet, Appendable appendable) throws IOException {
        DEFAULT_PRINTER.printUnknownFields(unknownFieldSet, new TextGenerator(appendable, (TextGenerator) null));
    }

    public static void printField(Descriptors.FieldDescriptor fieldDescriptor, Object obj, Appendable appendable) throws IOException {
        DEFAULT_PRINTER.printField(fieldDescriptor, obj, new TextGenerator(appendable, (TextGenerator) null));
    }

    public static String printFieldToString(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
        try {
            StringBuilder sb = new StringBuilder();
            printField(fieldDescriptor, obj, sb);
            return sb.toString();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void printFieldValue(Descriptors.FieldDescriptor fieldDescriptor, Object obj, Appendable appendable) throws IOException {
        DEFAULT_PRINTER.printFieldValue(fieldDescriptor, obj, new TextGenerator(appendable, (TextGenerator) null));
    }

    public static String printToString(MessageOrBuilder messageOrBuilder) {
        try {
            StringBuilder sb = new StringBuilder();
            print(messageOrBuilder, (Appendable) sb);
            return sb.toString();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String printToString(UnknownFieldSet unknownFieldSet) {
        try {
            StringBuilder sb = new StringBuilder();
            print(unknownFieldSet, (Appendable) sb);
            return sb.toString();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String printToUnicodeString(MessageOrBuilder messageOrBuilder) {
        try {
            StringBuilder sb = new StringBuilder();
            UNICODE_PRINTER.print(messageOrBuilder, new TextGenerator(sb, (TextGenerator) null));
            return sb.toString();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String printToUnicodeString(UnknownFieldSet unknownFieldSet) {
        try {
            StringBuilder sb = new StringBuilder();
            UNICODE_PRINTER.printUnknownFields(unknownFieldSet, new TextGenerator(sb, (TextGenerator) null));
            return sb.toString();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: private */
    public static void printUnknownFieldValue(int i, Object obj, TextGenerator textGenerator) throws IOException {
        int tagWireType = WireFormat.getTagWireType(i);
        if (tagWireType != 5) {
            switch (tagWireType) {
                case 0:
                    textGenerator.print(unsignedToString(((Long) obj).longValue()));
                    return;
                case 1:
                    textGenerator.print(String.format((Locale) null, "0x%016x", new Object[]{(Long) obj}));
                    return;
                case 2:
                    textGenerator.print("\"");
                    textGenerator.print(escapeBytes((ByteString) obj));
                    textGenerator.print("\"");
                    return;
                case 3:
                    DEFAULT_PRINTER.printUnknownFields((UnknownFieldSet) obj, textGenerator);
                    return;
                default:
                    throw new IllegalArgumentException("Bad tag: " + i);
            }
        } else {
            textGenerator.print(String.format((Locale) null, "0x%08x", new Object[]{(Integer) obj}));
        }
    }

    public static void printUnknownFieldValue(int i, Object obj, Appendable appendable) throws IOException {
        printUnknownFieldValue(i, obj, new TextGenerator(appendable, (TextGenerator) null));
    }

    public static String shortDebugString(MessageOrBuilder messageOrBuilder) {
        try {
            StringBuilder sb = new StringBuilder();
            SINGLE_LINE_PRINTER.print(messageOrBuilder, new TextGenerator(sb, (TextGenerator) null));
            return sb.toString().trim();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String shortDebugString(UnknownFieldSet unknownFieldSet) {
        try {
            StringBuilder sb = new StringBuilder();
            SINGLE_LINE_PRINTER.printUnknownFields(unknownFieldSet, new TextGenerator(sb, (TextGenerator) null));
            return sb.toString().trim();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private static StringBuilder toStringBuilder(Readable readable) throws IOException {
        StringBuilder sb = new StringBuilder();
        CharBuffer allocate = CharBuffer.allocate(4096);
        while (true) {
            int read = readable.read(allocate);
            if (read == -1) {
                return sb;
            }
            allocate.flip();
            sb.append(allocate, 0, read);
        }
    }

    static ByteString unescapeBytes(CharSequence charSequence) throws InvalidEscapeSequenceException {
        int i;
        int i2;
        int i3;
        ByteString copyFromUtf8 = ByteString.copyFromUtf8(charSequence.toString());
        byte[] bArr = new byte[copyFromUtf8.size()];
        int i4 = 0;
        int i5 = 0;
        while (i < copyFromUtf8.size()) {
            byte byteAt = copyFromUtf8.byteAt(i);
            if (byteAt == 92) {
                i++;
                if (i < copyFromUtf8.size()) {
                    byte byteAt2 = copyFromUtf8.byteAt(i);
                    if (isOctal(byteAt2)) {
                        int digitValue = digitValue(byteAt2);
                        int i6 = i + 1;
                        if (i6 < copyFromUtf8.size() && isOctal(copyFromUtf8.byteAt(i6))) {
                            digitValue = (digitValue * 8) + digitValue(copyFromUtf8.byteAt(i6));
                            i = i6;
                        }
                        int i7 = i + 1;
                        if (i7 < copyFromUtf8.size() && isOctal(copyFromUtf8.byteAt(i7))) {
                            digitValue = (digitValue * 8) + digitValue(copyFromUtf8.byteAt(i7));
                            i = i7;
                        }
                        i2 = i5 + 1;
                        bArr[i5] = (byte) digitValue;
                    } else {
                        if (byteAt2 == 34) {
                            i3 = i5 + 1;
                            bArr[i5] = 34;
                        } else if (byteAt2 == 39) {
                            i3 = i5 + 1;
                            bArr[i5] = 39;
                        } else if (byteAt2 == 92) {
                            i3 = i5 + 1;
                            bArr[i5] = 92;
                        } else if (byteAt2 == 102) {
                            i3 = i5 + 1;
                            bArr[i5] = 12;
                        } else if (byteAt2 == 110) {
                            i3 = i5 + 1;
                            bArr[i5] = 10;
                        } else if (byteAt2 == 114) {
                            i3 = i5 + 1;
                            bArr[i5] = bg.k;
                        } else if (byteAt2 == 116) {
                            i3 = i5 + 1;
                            bArr[i5] = 9;
                        } else if (byteAt2 == 118) {
                            i3 = i5 + 1;
                            bArr[i5] = 11;
                        } else if (byteAt2 != 120) {
                            switch (byteAt2) {
                                case 97:
                                    i3 = i5 + 1;
                                    bArr[i5] = 7;
                                    break;
                                case 98:
                                    i3 = i5 + 1;
                                    bArr[i5] = 8;
                                    break;
                                default:
                                    throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\" + ((char) byteAt2) + '\'');
                            }
                        } else {
                            i++;
                            if (i >= copyFromUtf8.size() || !isHex(copyFromUtf8.byteAt(i))) {
                                throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
                            }
                            int digitValue2 = digitValue(copyFromUtf8.byteAt(i));
                            int i8 = i + 1;
                            if (i8 < copyFromUtf8.size() && isHex(copyFromUtf8.byteAt(i8))) {
                                digitValue2 = (digitValue2 * 16) + digitValue(copyFromUtf8.byteAt(i8));
                                i = i8;
                            }
                            i2 = i5 + 1;
                            bArr[i5] = (byte) digitValue2;
                        }
                        i5 = i3;
                        i4 = i + 1;
                    }
                } else {
                    throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
                }
            } else {
                i2 = i5 + 1;
                bArr[i5] = byteAt;
            }
            i5 = i2;
            i4 = i + 1;
        }
        return ByteString.copyFrom(bArr, 0, i5);
    }

    static String unescapeText(String str) throws InvalidEscapeSequenceException {
        return unescapeBytes(str).toStringUtf8();
    }

    /* access modifiers changed from: private */
    public static String unsignedToString(int i) {
        return i >= 0 ? Integer.toString(i) : Long.toString(((long) i) & 4294967295L);
    }

    /* access modifiers changed from: private */
    public static String unsignedToString(long j) {
        return j >= 0 ? Long.toString(j) : BigInteger.valueOf(j & Long.MAX_VALUE).setBit(63).toString();
    }
}
