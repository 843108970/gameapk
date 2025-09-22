package com.sun.activation.registries;

import android.support.v4.os.EnvironmentCompat;

public class MailcapTokenizer {
    public static final int EOI_TOKEN = 5;
    public static final int EQUALS_TOKEN = 61;
    public static final int SEMICOLON_TOKEN = 59;
    public static final int SLASH_TOKEN = 47;
    public static final int START_TOKEN = 1;
    public static final int STRING_TOKEN = 2;
    public static final int UNKNOWN_TOKEN = 0;
    private char autoquoteChar;
    private int currentToken;
    private String currentTokenValue;
    private String data;
    private int dataIndex = 0;
    private int dataLength;
    private boolean isAutoquoting;

    public MailcapTokenizer(String str) {
        this.data = str;
        this.dataLength = str.length();
        this.currentToken = 1;
        this.currentTokenValue = "";
        this.isAutoquoting = false;
        this.autoquoteChar = ';';
    }

    private static String fixEscapeSequences(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.ensureCapacity(length);
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == '\\' && i < length - 1) {
                i++;
                charAt = str.charAt(i);
            }
            stringBuffer.append(charAt);
            i++;
        }
        return stringBuffer.toString();
    }

    private static boolean isControlChar(char c2) {
        return Character.isISOControl(c2);
    }

    private static boolean isSpecialChar(char c2) {
        if (c2 == '\"' || c2 == ',' || c2 == '/') {
            return true;
        }
        switch (c2) {
            case '(':
            case ')':
                return true;
            default:
                switch (c2) {
                    case ':':
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                    case '?':
                    case '@':
                        return true;
                    default:
                        switch (c2) {
                            case '[':
                            case '\\':
                            case ']':
                                return true;
                            default:
                                return false;
                        }
                }
        }
    }

    private static boolean isStringTokenChar(char c2) {
        return !isSpecialChar(c2) && !isControlChar(c2) && !isWhiteSpaceChar(c2);
    }

    private static boolean isWhiteSpaceChar(char c2) {
        return Character.isWhitespace(c2);
    }

    public static String nameForToken(int i) {
        if (i == 5) {
            return "EOI";
        }
        if (i == 47) {
            return "'/'";
        }
        if (i == 59) {
            return "';'";
        }
        if (i == 61) {
            return "'='";
        }
        switch (i) {
            case 0:
                return EnvironmentCompat.MEDIA_UNKNOWN;
            case 1:
                return "start";
            case 2:
                return "string";
            default:
                return "really unknown";
        }
    }

    private void processAutoquoteToken() {
        int i = this.dataIndex;
        boolean z = false;
        while (this.dataIndex < this.dataLength && !z) {
            if (this.data.charAt(this.dataIndex) != this.autoquoteChar) {
                this.dataIndex++;
            } else {
                z = true;
            }
        }
        this.currentToken = 2;
        this.currentTokenValue = fixEscapeSequences(this.data.substring(i, this.dataIndex));
    }

    private void processStringToken() {
        int i = this.dataIndex;
        while (this.dataIndex < this.dataLength && isStringTokenChar(this.data.charAt(this.dataIndex))) {
            this.dataIndex++;
        }
        this.currentToken = 2;
        this.currentTokenValue = this.data.substring(i, this.dataIndex);
    }

    public int getCurrentToken() {
        return this.currentToken;
    }

    public String getCurrentTokenValue() {
        return this.currentTokenValue;
    }

    public int nextToken() {
        Character ch;
        if (this.dataIndex < this.dataLength) {
            while (this.dataIndex < this.dataLength && isWhiteSpaceChar(this.data.charAt(this.dataIndex))) {
                this.dataIndex++;
            }
            if (this.dataIndex < this.dataLength) {
                char charAt = this.data.charAt(this.dataIndex);
                if (this.isAutoquoting) {
                    if (charAt == ';' || charAt == '=') {
                        this.currentToken = charAt;
                        ch = new Character(charAt);
                    } else {
                        processAutoquoteToken();
                        return this.currentToken;
                    }
                } else if (isStringTokenChar(charAt)) {
                    processStringToken();
                    return this.currentToken;
                } else if (charAt == '/' || charAt == ';' || charAt == '=') {
                    this.currentToken = charAt;
                    ch = new Character(charAt);
                } else {
                    this.currentToken = 0;
                    ch = new Character(charAt);
                }
                this.currentTokenValue = ch.toString();
                this.dataIndex++;
                return this.currentToken;
            }
        }
        this.currentToken = 5;
        this.currentTokenValue = null;
        return this.currentToken;
    }

    public void setIsAutoquoting(boolean z) {
        this.isAutoquoting = z;
    }
}
