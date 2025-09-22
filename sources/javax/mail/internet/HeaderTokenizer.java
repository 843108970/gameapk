package javax.mail.internet;

public class HeaderTokenizer {
    private static final Token EOFToken = new Token(-4, (String) null);
    public static final String MIME = "()<>@,;:\\\"\t []/?=";
    public static final String RFC822 = "()<>@,;:\\\"\t .[]";
    private int currentPos;
    private String delimiters;
    private int maxPos;
    private int nextPos;
    private int peekPos;
    private boolean skipComments;
    private String string;

    public static class Token {
        public static final int ATOM = -1;
        public static final int COMMENT = -3;
        public static final int EOF = -4;
        public static final int QUOTEDSTRING = -2;
        private int type;
        private String value;

        public Token(int i, String str) {
            this.type = i;
            this.value = str;
        }

        public int getType() {
            return this.type;
        }

        public String getValue() {
            return this.value;
        }
    }

    public HeaderTokenizer(String str) {
        this(str, RFC822);
    }

    public HeaderTokenizer(String str, String str2) {
        this(str, str2, true);
    }

    public HeaderTokenizer(String str, String str2, boolean z) {
        this.string = str == null ? "" : str;
        this.skipComments = z;
        this.delimiters = str2;
        this.peekPos = 0;
        this.nextPos = 0;
        this.currentPos = 0;
        this.maxPos = this.string.length();
    }

    private static String filterToken(String str, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = false;
        boolean z2 = false;
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != 10 || !z) {
                if (z2) {
                    stringBuffer.append(charAt);
                    z = false;
                    z2 = false;
                } else if (charAt == '\\') {
                    z = false;
                    z2 = true;
                } else if (charAt == 13) {
                    z = true;
                } else {
                    stringBuffer.append(charAt);
                }
                i++;
            }
            z = false;
            i++;
        }
        return stringBuffer.toString();
    }

    private Token getNext() throws ParseException {
        if (this.currentPos >= this.maxPos) {
            return EOFToken;
        }
        if (skipWhiteSpace() == -4) {
            return EOFToken;
        }
        boolean z = false;
        while (true) {
            char charAt = this.string.charAt(this.currentPos);
            if (charAt == '(') {
                int i = this.currentPos + 1;
                this.currentPos = i;
                boolean z2 = z;
                int i2 = 1;
                while (i2 > 0 && this.currentPos < this.maxPos) {
                    char charAt2 = this.string.charAt(this.currentPos);
                    if (charAt2 == '\\') {
                        this.currentPos++;
                    } else if (charAt2 != 13) {
                        if (charAt2 == '(') {
                            i2++;
                        } else if (charAt2 == ')') {
                            i2--;
                        }
                        this.currentPos++;
                    }
                    z2 = true;
                    this.currentPos++;
                }
                if (i2 != 0) {
                    throw new ParseException("Unbalanced comments");
                } else if (!this.skipComments) {
                    return new Token(-3, z2 ? filterToken(this.string, i, this.currentPos - 1) : this.string.substring(i, this.currentPos - 1));
                } else if (skipWhiteSpace() == -4) {
                    return EOFToken;
                } else {
                    z = z2;
                }
            } else if (charAt == '\"') {
                int i3 = this.currentPos + 1;
                this.currentPos = i3;
                while (this.currentPos < this.maxPos) {
                    char charAt3 = this.string.charAt(this.currentPos);
                    if (charAt3 == '\\') {
                        this.currentPos++;
                    } else if (charAt3 != 13) {
                        if (charAt3 == '\"') {
                            this.currentPos++;
                            return new Token(-2, z ? filterToken(this.string, i3, this.currentPos - 1) : this.string.substring(i3, this.currentPos - 1));
                        }
                        this.currentPos++;
                    }
                    z = true;
                    this.currentPos++;
                }
                throw new ParseException("Unbalanced quoted string");
            } else if (charAt < ' ' || charAt >= 127 || this.delimiters.indexOf(charAt) >= 0) {
                this.currentPos++;
                return new Token(charAt, new String(new char[]{charAt}));
            } else {
                int i4 = this.currentPos;
                while (this.currentPos < this.maxPos && (r3 = this.string.charAt(this.currentPos)) >= ' ' && r3 < 127 && r3 != '(' && r3 != ' ' && r3 != '\"' && this.delimiters.indexOf(r3) < 0) {
                    this.currentPos++;
                }
                return new Token(-1, this.string.substring(i4, this.currentPos));
            }
        }
    }

    private int skipWhiteSpace() {
        while (this.currentPos < this.maxPos) {
            char charAt = this.string.charAt(this.currentPos);
            if (charAt != ' ' && charAt != 9 && charAt != 13 && charAt != 10) {
                return this.currentPos;
            }
            this.currentPos++;
        }
        return -4;
    }

    public String getRemainder() {
        return this.string.substring(this.nextPos);
    }

    public Token next() throws ParseException {
        this.currentPos = this.nextPos;
        Token next = getNext();
        int i = this.currentPos;
        this.peekPos = i;
        this.nextPos = i;
        return next;
    }

    public Token peek() throws ParseException {
        this.currentPos = this.peekPos;
        Token next = getNext();
        this.peekPos = this.currentPos;
        return next;
    }
}
