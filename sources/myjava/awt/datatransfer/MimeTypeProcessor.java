package myjava.awt.datatransfer;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

final class MimeTypeProcessor {
    private static MimeTypeProcessor instance;

    static final class MimeType implements Serializable, Cloneable {
        private static final long serialVersionUID = -6693571907475992044L;
        /* access modifiers changed from: private */
        public Hashtable<String, String> parameters;
        /* access modifiers changed from: private */
        public String primaryType;
        /* access modifiers changed from: private */
        public String subType;
        /* access modifiers changed from: private */
        public Hashtable<String, Object> systemParameters;

        MimeType() {
            this.primaryType = null;
            this.subType = null;
            this.parameters = null;
            this.systemParameters = null;
        }

        MimeType(String str, String str2) {
            this.primaryType = str;
            this.subType = str2;
            this.parameters = new Hashtable<>();
            this.systemParameters = new Hashtable<>();
        }

        /* access modifiers changed from: package-private */
        public final void addParameter(String str, String str2) {
            if (str2 != null) {
                if (str2.charAt(0) == '\"' && str2.charAt(str2.length() - 1) == '\"') {
                    str2 = str2.substring(1, str2.length() - 2);
                }
                if (str2.length() != 0) {
                    this.parameters.put(str, str2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void addSystemParameter(String str, Object obj) {
            this.systemParameters.put(str, obj);
        }

        public final Object clone() {
            MimeType mimeType = new MimeType(this.primaryType, this.subType);
            mimeType.parameters = (Hashtable) this.parameters.clone();
            mimeType.systemParameters = (Hashtable) this.systemParameters.clone();
            return mimeType;
        }

        /* access modifiers changed from: package-private */
        public final boolean equals(MimeType mimeType) {
            if (mimeType == null) {
                return false;
            }
            return getFullType().equals(mimeType.getFullType());
        }

        /* access modifiers changed from: package-private */
        public final String getFullType() {
            return String.valueOf(this.primaryType) + "/" + this.subType;
        }

        /* access modifiers changed from: package-private */
        public final String getParameter(String str) {
            return this.parameters.get(str);
        }

        /* access modifiers changed from: package-private */
        public final String getPrimaryType() {
            return this.primaryType;
        }

        /* access modifiers changed from: package-private */
        public final String getSubType() {
            return this.subType;
        }

        /* access modifiers changed from: package-private */
        public final Object getSystemParameter(String str) {
            return this.systemParameters.get(str);
        }

        /* access modifiers changed from: package-private */
        public final void removeParameter(String str) {
            this.parameters.remove(str);
        }
    }

    private static final class StringPosition {
        int i;

        private StringPosition() {
            this.i = 0;
        }

        /* synthetic */ StringPosition(StringPosition stringPosition) {
            this();
        }
    }

    private MimeTypeProcessor() {
    }

    static String assemble(MimeType mimeType) {
        StringBuilder sb = new StringBuilder();
        sb.append(mimeType.getFullType());
        Enumeration keys = mimeType.parameters.keys();
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            sb.append("; ");
            sb.append(str);
            sb.append("=\"");
            sb.append((String) mimeType.parameters.get(str));
            sb.append('\"');
        }
        return sb.toString();
    }

    private static int getNextMeaningfulIndex(String str, int i) {
        while (i < str.length() && !isMeaningfulChar(str.charAt(i))) {
            i++;
        }
        return i;
    }

    private static boolean isMeaningfulChar(char c2) {
        return c2 >= '!' && c2 <= '~';
    }

    private static boolean isTSpecialChar(char c2) {
        return c2 == '(' || c2 == ')' || c2 == '[' || c2 == ']' || c2 == '<' || c2 == '>' || c2 == '@' || c2 == ',' || c2 == ';' || c2 == ':' || c2 == '\\' || c2 == '\"' || c2 == '/' || c2 == '?' || c2 == '=';
    }

    static MimeType parse(String str) {
        if (instance == null) {
            instance = new MimeTypeProcessor();
        }
        MimeType mimeType = new MimeType();
        if (str != null) {
            StringPosition stringPosition = new StringPosition((StringPosition) null);
            retrieveType(str, mimeType, stringPosition);
            retrieveParams(str, mimeType, stringPosition);
        }
        return mimeType;
    }

    private static void retrieveParam(String str, MimeType mimeType, StringPosition stringPosition) {
        String lowerCase = retrieveToken(str, stringPosition).toLowerCase();
        stringPosition.i = getNextMeaningfulIndex(str, stringPosition.i);
        if (stringPosition.i >= str.length() || str.charAt(stringPosition.i) != '=') {
            throw new IllegalArgumentException();
        }
        stringPosition.i++;
        stringPosition.i = getNextMeaningfulIndex(str, stringPosition.i);
        if (stringPosition.i >= str.length()) {
            throw new IllegalArgumentException();
        }
        mimeType.parameters.put(lowerCase, str.charAt(stringPosition.i) == '\"' ? retrieveQuoted(str, stringPosition) : retrieveToken(str, stringPosition));
    }

    private static void retrieveParams(String str, MimeType mimeType, StringPosition stringPosition) {
        mimeType.parameters = new Hashtable();
        mimeType.systemParameters = new Hashtable();
        while (true) {
            stringPosition.i = getNextMeaningfulIndex(str, stringPosition.i);
            if (stringPosition.i < str.length()) {
                if (str.charAt(stringPosition.i) != ';') {
                    throw new IllegalArgumentException();
                }
                stringPosition.i++;
                retrieveParam(str, mimeType, stringPosition);
            } else {
                return;
            }
        }
    }

    private static String retrieveQuoted(String str, StringPosition stringPosition) {
        StringBuilder sb = new StringBuilder();
        stringPosition.i++;
        boolean z = true;
        do {
            if (str.charAt(stringPosition.i) != '\"' || !z) {
                int i = stringPosition.i;
                stringPosition.i = i + 1;
                char charAt = str.charAt(i);
                if (!z) {
                    z = true;
                } else if (charAt == '\\') {
                    z = false;
                }
                if (z) {
                    sb.append(charAt);
                }
            } else {
                stringPosition.i++;
                return sb.toString();
            }
        } while (stringPosition.i != str.length());
        throw new IllegalArgumentException();
    }

    private static String retrieveToken(String str, StringPosition stringPosition) {
        StringBuilder sb = new StringBuilder();
        stringPosition.i = getNextMeaningfulIndex(str, stringPosition.i);
        if (stringPosition.i >= str.length() || isTSpecialChar(str.charAt(stringPosition.i))) {
            throw new IllegalArgumentException();
        }
        do {
            int i = stringPosition.i;
            stringPosition.i = i + 1;
            sb.append(str.charAt(i));
            if (stringPosition.i >= str.length() || !isMeaningfulChar(str.charAt(stringPosition.i)) || isTSpecialChar(str.charAt(stringPosition.i))) {
            }
            int i2 = stringPosition.i;
            stringPosition.i = i2 + 1;
            sb.append(str.charAt(i2));
            break;
        } while (isTSpecialChar(str.charAt(stringPosition.i)));
        return sb.toString();
    }

    private static void retrieveType(String str, MimeType mimeType, StringPosition stringPosition) {
        mimeType.primaryType = retrieveToken(str, stringPosition).toLowerCase();
        stringPosition.i = getNextMeaningfulIndex(str, stringPosition.i);
        if (stringPosition.i >= str.length() || str.charAt(stringPosition.i) != '/') {
            throw new IllegalArgumentException();
        }
        stringPosition.i++;
        mimeType.subType = retrieveToken(str, stringPosition).toLowerCase();
    }
}
