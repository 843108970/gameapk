package javax.activation;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import org.apache.commons.io.IOUtils;

public class MimeTypeParameterList {
    private static final String TSPECIALS = "()<>@,;:/[]?=\\\"";
    private Hashtable parameters = new Hashtable();

    public MimeTypeParameterList() {
    }

    public MimeTypeParameterList(String str) throws MimeTypeParseException {
        parse(str);
    }

    private static boolean isTokenChar(char c2) {
        return c2 > ' ' && c2 < 127 && TSPECIALS.indexOf(c2) < 0;
    }

    private static String quote(String str) {
        int length = str.length();
        boolean z = false;
        for (int i = 0; i < length && !z; i++) {
            z = !isTokenChar(str.charAt(i));
        }
        if (!z) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.ensureCapacity((int) (((double) length) * 1.5d));
        stringBuffer.append('\"');
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '\\' || charAt == '\"') {
                stringBuffer.append(IOUtils.DIR_SEPARATOR_WINDOWS);
            }
            stringBuffer.append(charAt);
        }
        stringBuffer.append('\"');
        return stringBuffer.toString();
    }

    private static int skipWhiteSpace(String str, int i) {
        int length = str.length();
        while (i < length && Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        return i;
    }

    private static String unquote(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.ensureCapacity(length);
        boolean z = false;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (!z && charAt != '\\') {
                stringBuffer.append(charAt);
            } else if (z) {
                stringBuffer.append(charAt);
                z = false;
            } else {
                z = true;
            }
        }
        return stringBuffer.toString();
    }

    public String get(String str) {
        return (String) this.parameters.get(str.trim().toLowerCase(Locale.ENGLISH));
    }

    public Enumeration getNames() {
        return this.parameters.keys();
    }

    public boolean isEmpty() {
        return this.parameters.isEmpty();
    }

    /* access modifiers changed from: protected */
    public void parse(String str) throws MimeTypeParseException {
        int length;
        int i;
        String str2;
        if (str != null && (length = str.length()) > 0) {
            int skipWhiteSpace = skipWhiteSpace(str, 0);
            while (skipWhiteSpace < length && str.charAt(skipWhiteSpace) == ';') {
                int skipWhiteSpace2 = skipWhiteSpace(str, skipWhiteSpace + 1);
                if (skipWhiteSpace2 < length) {
                    int i2 = skipWhiteSpace2;
                    while (i2 < length && isTokenChar(str.charAt(i2))) {
                        i2++;
                    }
                    String lowerCase = str.substring(skipWhiteSpace2, i2).toLowerCase(Locale.ENGLISH);
                    int skipWhiteSpace3 = skipWhiteSpace(str, i2);
                    if (skipWhiteSpace3 >= length || str.charAt(skipWhiteSpace3) != '=') {
                        throw new MimeTypeParseException("Couldn't find the '=' that separates a parameter name from its value.");
                    }
                    int skipWhiteSpace4 = skipWhiteSpace(str, skipWhiteSpace3 + 1);
                    if (skipWhiteSpace4 >= length) {
                        throw new MimeTypeParseException("Couldn't find a value for parameter named " + lowerCase);
                    }
                    char charAt = str.charAt(skipWhiteSpace4);
                    if (charAt == '\"') {
                        int i3 = skipWhiteSpace4 + 1;
                        if (i3 >= length) {
                            throw new MimeTypeParseException("Encountered unterminated quoted parameter value.");
                        }
                        char c2 = charAt;
                        int i4 = i3;
                        while (i4 < length) {
                            c2 = str.charAt(i4);
                            if (c2 == '\"') {
                                break;
                            }
                            if (c2 == '\\') {
                                i4++;
                            }
                            i4++;
                        }
                        if (c2 != '\"') {
                            throw new MimeTypeParseException("Encountered unterminated quoted parameter value.");
                        }
                        str2 = unquote(str.substring(i3, i4));
                        i = i4 + 1;
                    } else if (isTokenChar(charAt)) {
                        i = skipWhiteSpace4;
                        while (i < length && isTokenChar(str.charAt(i))) {
                            i++;
                        }
                        str2 = str.substring(skipWhiteSpace4, i);
                    } else {
                        throw new MimeTypeParseException("Unexpected character encountered at index " + skipWhiteSpace4);
                    }
                    this.parameters.put(lowerCase, str2);
                    skipWhiteSpace = skipWhiteSpace(str, i);
                } else {
                    return;
                }
            }
            if (skipWhiteSpace < length) {
                throw new MimeTypeParseException("More characters encountered in input than expected.");
            }
        }
    }

    public void remove(String str) {
        this.parameters.remove(str.trim().toLowerCase(Locale.ENGLISH));
    }

    public void set(String str, String str2) {
        this.parameters.put(str.trim().toLowerCase(Locale.ENGLISH), str2);
    }

    public int size() {
        return this.parameters.size();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.ensureCapacity(this.parameters.size() * 16);
        Enumeration keys = this.parameters.keys();
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            stringBuffer.append("; ");
            stringBuffer.append(str);
            stringBuffer.append('=');
            stringBuffer.append(quote((String) this.parameters.get(str)));
        }
        return stringBuffer.toString();
    }
}
