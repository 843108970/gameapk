package javax.mail.internet;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.slf4j.Marker;

public class ParameterList {
    private static boolean applehack = false;
    private static boolean decodeParameters = false;
    private static boolean decodeParametersStrict = false;
    private static boolean encodeParameters = false;
    private static final char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private String lastName;
    private Map list;
    private Set multisegmentNames;
    private Map slist;

    private static class MultiValue extends ArrayList {
        String value;

        private MultiValue() {
        }

        /* synthetic */ MultiValue(MultiValue multiValue) {
            this();
        }
    }

    private static class ParamEnum implements Enumeration {
        private Iterator it;

        ParamEnum(Iterator it2) {
            this.it = it2;
        }

        public boolean hasMoreElements() {
            return this.it.hasNext();
        }

        public Object nextElement() {
            return this.it.next();
        }
    }

    private static class ToStringBuffer {
        private StringBuffer sb = new StringBuffer();
        private int used;

        public ToStringBuffer(int i) {
            this.used = i;
        }

        public void addNV(String str, String str2) {
            String access$0 = ParameterList.quote(str2);
            this.sb.append("; ");
            this.used += 2;
            if (this.used + str.length() + access$0.length() + 1 > 76) {
                this.sb.append("\r\n\t");
                this.used = 8;
            }
            StringBuffer stringBuffer = this.sb;
            stringBuffer.append(str);
            stringBuffer.append('=');
            this.used += str.length() + 1;
            if (this.used + access$0.length() > 76) {
                String fold = MimeUtility.fold(this.used, access$0);
                this.sb.append(fold);
                int lastIndexOf = fold.lastIndexOf(10);
                if (lastIndexOf >= 0) {
                    this.used += (fold.length() - lastIndexOf) - 1;
                } else {
                    this.used += fold.length();
                }
            } else {
                this.sb.append(access$0);
                this.used += access$0.length();
            }
        }

        public String toString() {
            return this.sb.toString();
        }
    }

    private static class Value {
        String charset;
        String encodedValue;
        String value;

        private Value() {
        }

        /* synthetic */ Value(Value value2) {
            this();
        }
    }

    static {
        try {
            String property = System.getProperty("mail.mime.encodeparameters");
            boolean z = false;
            encodeParameters = property != null && property.equalsIgnoreCase("true");
            String property2 = System.getProperty("mail.mime.decodeparameters");
            decodeParameters = property2 != null && property2.equalsIgnoreCase("true");
            String property3 = System.getProperty("mail.mime.decodeparameters.strict");
            decodeParametersStrict = property3 != null && property3.equalsIgnoreCase("true");
            String property4 = System.getProperty("mail.mime.applefilenames");
            if (property4 != null && property4.equalsIgnoreCase("true")) {
                z = true;
            }
            applehack = z;
        } catch (SecurityException unused) {
        }
    }

    public ParameterList() {
        this.list = new LinkedHashMap();
        this.lastName = null;
        if (decodeParameters) {
            this.multisegmentNames = new HashSet();
            this.slist = new HashMap();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0125, code lost:
        if (decodeParameters == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0127, code lost:
        combineMultisegmentNames(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ParameterList(java.lang.String r7) throws javax.mail.internet.ParseException {
        /*
            r6 = this;
            r6.<init>()
            javax.mail.internet.HeaderTokenizer r0 = new javax.mail.internet.HeaderTokenizer
            java.lang.String r1 = "()<>@,;:\\\"\t []/?="
            r0.<init>(r7, r1)
        L_0x000a:
            javax.mail.internet.HeaderTokenizer$Token r7 = r0.next()
            int r1 = r7.getType()
            r2 = -4
            if (r1 == r2) goto L_0x0123
            char r3 = (char) r1
            r4 = 59
            r5 = -1
            if (r3 != r4) goto L_0x00bc
            javax.mail.internet.HeaderTokenizer$Token r7 = r0.next()
            int r1 = r7.getType()
            if (r1 == r2) goto L_0x0123
            int r1 = r7.getType()
            if (r1 == r5) goto L_0x0048
            javax.mail.internet.ParseException r0 = new javax.mail.internet.ParseException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected parameter name, got \""
            r1.<init>(r2)
            java.lang.String r7 = r7.getValue()
            r1.append(r7)
            java.lang.String r7 = "\""
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L_0x0048:
            java.lang.String r7 = r7.getValue()
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r7 = r7.toLowerCase(r1)
            javax.mail.internet.HeaderTokenizer$Token r1 = r0.next()
            int r2 = r1.getType()
            char r2 = (char) r2
            r3 = 61
            if (r2 == r3) goto L_0x007c
            javax.mail.internet.ParseException r7 = new javax.mail.internet.ParseException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected '=', got \""
            r0.<init>(r2)
            java.lang.String r1 = r1.getValue()
            r0.append(r1)
            java.lang.String r1 = "\""
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x007c:
            javax.mail.internet.HeaderTokenizer$Token r1 = r0.next()
            int r2 = r1.getType()
            if (r2 == r5) goto L_0x00a6
            r3 = -2
            if (r2 == r3) goto L_0x00a6
            javax.mail.internet.ParseException r7 = new javax.mail.internet.ParseException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected parameter value, got \""
            r0.<init>(r2)
            java.lang.String r1 = r1.getValue()
            r0.append(r1)
            java.lang.String r1 = "\""
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x00a6:
            java.lang.String r1 = r1.getValue()
            r6.lastName = r7
            boolean r2 = decodeParameters
            if (r2 == 0) goto L_0x00b5
            r6.putEncodedName(r7, r1)
            goto L_0x000a
        L_0x00b5:
            java.util.Map r2 = r6.list
            r2.put(r7, r1)
            goto L_0x000a
        L_0x00bc:
            boolean r2 = applehack
            if (r2 == 0) goto L_0x0106
            if (r1 != r5) goto L_0x0106
            java.lang.String r1 = r6.lastName
            if (r1 == 0) goto L_0x0106
            java.lang.String r1 = r6.lastName
            java.lang.String r2 = "name"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00da
            java.lang.String r1 = r6.lastName
            java.lang.String r2 = "filename"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0106
        L_0x00da:
            java.util.Map r1 = r6.list
            java.lang.String r2 = r6.lastName
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r2.<init>(r1)
            java.lang.String r1 = " "
            r2.append(r1)
            java.lang.String r7 = r7.getValue()
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            java.util.Map r1 = r6.list
            java.lang.String r2 = r6.lastName
            r1.put(r2, r7)
            goto L_0x000a
        L_0x0106:
            javax.mail.internet.ParseException r0 = new javax.mail.internet.ParseException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected ';', got \""
            r1.<init>(r2)
            java.lang.String r7 = r7.getValue()
            r1.append(r7)
            java.lang.String r7 = "\""
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L_0x0123:
            boolean r7 = decodeParameters
            if (r7 == 0) goto L_0x012b
            r7 = 0
            r6.combineMultisegmentNames(r7)
        L_0x012b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.ParameterList.<init>(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:82:0x00c5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00d5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00e5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x00f2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x00f2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x00f2 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void combineMultisegmentNames(boolean r13) throws javax.mail.internet.ParseException {
        /*
            r12 = this;
            java.util.Set r0 = r12.multisegmentNames     // Catch:{ all -> 0x0114 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0114 }
        L_0x0006:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0114 }
            if (r1 != 0) goto L_0x0050
            java.util.Map r13 = r12.slist
            int r13 = r13.size()
            if (r13 <= 0) goto L_0x0045
            java.util.Map r13 = r12.slist
            java.util.Collection r13 = r13.values()
            java.util.Iterator r13 = r13.iterator()
        L_0x001e:
            boolean r0 = r13.hasNext()
            if (r0 != 0) goto L_0x002c
            java.util.Map r13 = r12.list
            java.util.Map r0 = r12.slist
            r13.putAll(r0)
            goto L_0x0045
        L_0x002c:
            java.lang.Object r0 = r13.next()
            boolean r1 = r0 instanceof javax.mail.internet.ParameterList.Value
            if (r1 == 0) goto L_0x001e
            javax.mail.internet.ParameterList$Value r0 = (javax.mail.internet.ParameterList.Value) r0
            java.lang.String r1 = r0.encodedValue
            javax.mail.internet.ParameterList$Value r1 = decodeValue(r1)
            java.lang.String r2 = r1.charset
            r0.charset = r2
            java.lang.String r1 = r1.value
            r0.value = r1
            goto L_0x001e
        L_0x0045:
            java.util.Set r13 = r12.multisegmentNames
            r13.clear()
            java.util.Map r13 = r12.slist
            r13.clear()
            return
        L_0x0050:
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0114 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0114 }
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch:{ all -> 0x0114 }
            r2.<init>()     // Catch:{ all -> 0x0114 }
            javax.mail.internet.ParameterList$MultiValue r3 = new javax.mail.internet.ParameterList$MultiValue     // Catch:{ all -> 0x0114 }
            r4 = 0
            r3.<init>(r4)     // Catch:{ all -> 0x0114 }
            r5 = 0
            r6 = r4
        L_0x0063:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0114 }
            java.lang.String r8 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0114 }
            r7.<init>(r8)     // Catch:{ all -> 0x0114 }
            java.lang.String r8 = "*"
            r7.append(r8)     // Catch:{ all -> 0x0114 }
            r7.append(r5)     // Catch:{ all -> 0x0114 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0114 }
            java.util.Map r8 = r12.slist     // Catch:{ all -> 0x0114 }
            java.lang.Object r8 = r8.get(r7)     // Catch:{ all -> 0x0114 }
            if (r8 == 0) goto L_0x00fe
            r3.add(r8)     // Catch:{ all -> 0x0114 }
            boolean r9 = r8 instanceof javax.mail.internet.ParameterList.Value     // Catch:{ all -> 0x0114 }
            if (r9 == 0) goto L_0x00ef
            javax.mail.internet.ParameterList$Value r8 = (javax.mail.internet.ParameterList.Value) r8     // Catch:{ NumberFormatException -> 0x00df, UnsupportedEncodingException -> 0x00cf, StringIndexOutOfBoundsException -> 0x00bf }
            java.lang.String r9 = r8.encodedValue     // Catch:{ NumberFormatException -> 0x00df, UnsupportedEncodingException -> 0x00cf, StringIndexOutOfBoundsException -> 0x00bf }
            if (r5 != 0) goto L_0x00af
            javax.mail.internet.ParameterList$Value r10 = decodeValue(r9)     // Catch:{ NumberFormatException -> 0x00ad, UnsupportedEncodingException -> 0x00ab, StringIndexOutOfBoundsException -> 0x00a9 }
            java.lang.String r11 = r10.charset     // Catch:{ NumberFormatException -> 0x00ad, UnsupportedEncodingException -> 0x00ab, StringIndexOutOfBoundsException -> 0x00a9 }
            r8.charset = r11     // Catch:{ NumberFormatException -> 0x00ad, UnsupportedEncodingException -> 0x00ab, StringIndexOutOfBoundsException -> 0x00a9 }
            java.lang.String r6 = r10.value     // Catch:{ NumberFormatException -> 0x00a5, UnsupportedEncodingException -> 0x00a1, StringIndexOutOfBoundsException -> 0x009d }
            r8.value = r6     // Catch:{ NumberFormatException -> 0x00a5, UnsupportedEncodingException -> 0x00a1, StringIndexOutOfBoundsException -> 0x009d }
            r9 = r6
            r6 = r11
            goto L_0x00f2
        L_0x009d:
            r6 = move-exception
            r8 = r6
            r6 = r11
            goto L_0x00c1
        L_0x00a1:
            r6 = move-exception
            r8 = r6
            r6 = r11
            goto L_0x00d1
        L_0x00a5:
            r6 = move-exception
            r8 = r6
            r6 = r11
            goto L_0x00e1
        L_0x00a9:
            r8 = move-exception
            goto L_0x00c1
        L_0x00ab:
            r8 = move-exception
            goto L_0x00d1
        L_0x00ad:
            r8 = move-exception
            goto L_0x00e1
        L_0x00af:
            if (r6 != 0) goto L_0x00b7
            java.util.Set r8 = r12.multisegmentNames     // Catch:{ NumberFormatException -> 0x00ad, UnsupportedEncodingException -> 0x00ab, StringIndexOutOfBoundsException -> 0x00a9 }
            r8.remove(r1)     // Catch:{ NumberFormatException -> 0x00ad, UnsupportedEncodingException -> 0x00ab, StringIndexOutOfBoundsException -> 0x00a9 }
            goto L_0x00fe
        L_0x00b7:
            java.lang.String r10 = decodeBytes(r9, r6)     // Catch:{ NumberFormatException -> 0x00ad, UnsupportedEncodingException -> 0x00ab, StringIndexOutOfBoundsException -> 0x00a9 }
            r8.value = r10     // Catch:{ NumberFormatException -> 0x00ad, UnsupportedEncodingException -> 0x00ab, StringIndexOutOfBoundsException -> 0x00a9 }
            r9 = r10
            goto L_0x00f2
        L_0x00bf:
            r8 = move-exception
            r9 = r4
        L_0x00c1:
            boolean r10 = decodeParametersStrict     // Catch:{ all -> 0x0114 }
            if (r10 == 0) goto L_0x00f2
            javax.mail.internet.ParseException r0 = new javax.mail.internet.ParseException     // Catch:{ all -> 0x0114 }
            java.lang.String r1 = r8.toString()     // Catch:{ all -> 0x0114 }
            r0.<init>(r1)     // Catch:{ all -> 0x0114 }
            throw r0     // Catch:{ all -> 0x0114 }
        L_0x00cf:
            r8 = move-exception
            r9 = r4
        L_0x00d1:
            boolean r10 = decodeParametersStrict     // Catch:{ all -> 0x0114 }
            if (r10 == 0) goto L_0x00f2
            javax.mail.internet.ParseException r0 = new javax.mail.internet.ParseException     // Catch:{ all -> 0x0114 }
            java.lang.String r1 = r8.toString()     // Catch:{ all -> 0x0114 }
            r0.<init>(r1)     // Catch:{ all -> 0x0114 }
            throw r0     // Catch:{ all -> 0x0114 }
        L_0x00df:
            r8 = move-exception
            r9 = r4
        L_0x00e1:
            boolean r10 = decodeParametersStrict     // Catch:{ all -> 0x0114 }
            if (r10 == 0) goto L_0x00f2
            javax.mail.internet.ParseException r0 = new javax.mail.internet.ParseException     // Catch:{ all -> 0x0114 }
            java.lang.String r1 = r8.toString()     // Catch:{ all -> 0x0114 }
            r0.<init>(r1)     // Catch:{ all -> 0x0114 }
            throw r0     // Catch:{ all -> 0x0114 }
        L_0x00ef:
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0114 }
            r9 = r8
        L_0x00f2:
            r2.append(r9)     // Catch:{ all -> 0x0114 }
            java.util.Map r8 = r12.slist     // Catch:{ all -> 0x0114 }
            r8.remove(r7)     // Catch:{ all -> 0x0114 }
            int r5 = r5 + 1
            goto L_0x0063
        L_0x00fe:
            if (r5 != 0) goto L_0x0107
            java.util.Map r2 = r12.list     // Catch:{ all -> 0x0114 }
            r2.remove(r1)     // Catch:{ all -> 0x0114 }
            goto L_0x0006
        L_0x0107:
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0114 }
            r3.value = r2     // Catch:{ all -> 0x0114 }
            java.util.Map r2 = r12.list     // Catch:{ all -> 0x0114 }
            r2.put(r1, r3)     // Catch:{ all -> 0x0114 }
            goto L_0x0006
        L_0x0114:
            r0 = move-exception
            if (r13 != 0) goto L_0x0118
            goto L_0x015b
        L_0x0118:
            java.util.Map r13 = r12.slist
            int r13 = r13.size()
            if (r13 <= 0) goto L_0x0151
            java.util.Map r13 = r12.slist
            java.util.Collection r13 = r13.values()
            java.util.Iterator r13 = r13.iterator()
        L_0x012a:
            boolean r1 = r13.hasNext()
            if (r1 != 0) goto L_0x0138
            java.util.Map r13 = r12.list
            java.util.Map r1 = r12.slist
            r13.putAll(r1)
            goto L_0x0151
        L_0x0138:
            java.lang.Object r1 = r13.next()
            boolean r2 = r1 instanceof javax.mail.internet.ParameterList.Value
            if (r2 == 0) goto L_0x012a
            javax.mail.internet.ParameterList$Value r1 = (javax.mail.internet.ParameterList.Value) r1
            java.lang.String r2 = r1.encodedValue
            javax.mail.internet.ParameterList$Value r2 = decodeValue(r2)
            java.lang.String r3 = r2.charset
            r1.charset = r3
            java.lang.String r2 = r2.value
            r1.value = r2
            goto L_0x012a
        L_0x0151:
            java.util.Set r13 = r12.multisegmentNames
            r13.clear()
            java.util.Map r13 = r12.slist
            r13.clear()
        L_0x015b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.ParameterList.combineMultisegmentNames(boolean):void");
    }

    private static String decodeBytes(String str, String str2) throws UnsupportedEncodingException {
        byte[] bArr = new byte[str.length()];
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt == '%') {
                charAt = (char) Integer.parseInt(str.substring(i + 1, i + 3), 16);
                i += 2;
            }
            bArr[i2] = (byte) charAt;
            i++;
            i2++;
        }
        return new String(bArr, 0, i2, MimeUtility.javaCharset(str2));
    }

    private static Value decodeValue(String str) throws ParseException {
        Value value = new Value((Value) null);
        value.encodedValue = str;
        value.value = str;
        try {
            int indexOf = str.indexOf(39);
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                int i = indexOf + 1;
                int indexOf2 = str.indexOf(39, i);
                if (indexOf2 >= 0) {
                    str.substring(i, indexOf2);
                    String substring2 = str.substring(indexOf2 + 1);
                    value.charset = substring;
                    value.value = decodeBytes(substring2, substring);
                    return value;
                } else if (!decodeParametersStrict) {
                    return value;
                } else {
                    throw new ParseException("Missing language in encoded value: " + str);
                }
            } else if (!decodeParametersStrict) {
                return value;
            } else {
                throw new ParseException("Missing charset in encoded value: " + str);
            }
        } catch (NumberFormatException e) {
            if (decodeParametersStrict) {
                throw new ParseException(e.toString());
            }
            return value;
        } catch (UnsupportedEncodingException e2) {
            if (decodeParametersStrict) {
                throw new ParseException(e2.toString());
            }
            return value;
        } catch (StringIndexOutOfBoundsException e3) {
            if (decodeParametersStrict) {
                throw new ParseException(e3.toString());
            }
            return value;
        }
    }

    private static Value encodeValue(String str, String str2) {
        if (MimeUtility.checkAscii(str) == 1) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes(MimeUtility.javaCharset(str2));
            StringBuffer stringBuffer = new StringBuffer(bytes.length + str2.length() + 2);
            stringBuffer.append(str2);
            stringBuffer.append("''");
            for (byte b2 : bytes) {
                char c2 = (char) (b2 & 255);
                if (c2 <= ' ' || c2 >= 127 || c2 == '*' || c2 == '\'' || c2 == '%' || HeaderTokenizer.MIME.indexOf(c2) >= 0) {
                    stringBuffer.append('%');
                    stringBuffer.append(hex[c2 >> 4]);
                    c2 = hex[c2 & 15];
                }
                stringBuffer.append(c2);
            }
            Value value = new Value((Value) null);
            value.charset = str2;
            value.value = str;
            value.encodedValue = stringBuffer.toString();
            return value;
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    private void putEncodedName(String str, String str2) throws ParseException {
        Map map;
        Object obj;
        int indexOf = str.indexOf(42);
        if (indexOf < 0) {
            map = this.list;
            obj = str2;
        } else if (indexOf == str.length() - 1) {
            str = str.substring(0, indexOf);
            map = this.list;
            obj = decodeValue(str2);
        } else {
            String substring = str.substring(0, indexOf);
            this.multisegmentNames.add(substring);
            this.list.put(substring, "");
            Object obj2 = str2;
            if (str.endsWith(Marker.ANY_MARKER)) {
                Object value = new Value((Value) null);
                Value value2 = (Value) value;
                value2.encodedValue = str2;
                value2.value = str2;
                str = str.substring(0, str.length() - 1);
                obj2 = value;
            }
            map = this.slist;
            obj = obj2;
        }
        map.put(str, obj);
    }

    /* access modifiers changed from: private */
    public static String quote(String str) {
        return MimeUtility.quote(str, HeaderTokenizer.MIME);
    }

    public String get(String str) {
        Object obj = this.list.get(str.trim().toLowerCase(Locale.ENGLISH));
        return obj instanceof MultiValue ? ((MultiValue) obj).value : obj instanceof Value ? ((Value) obj).value : (String) obj;
    }

    public Enumeration getNames() {
        return new ParamEnum(this.list.keySet().iterator());
    }

    public void remove(String str) {
        this.list.remove(str.trim().toLowerCase(Locale.ENGLISH));
    }

    public void set(String str, String str2) {
        if (str != null || str2 == null || !str2.equals("DONE")) {
            String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
            if (decodeParameters) {
                try {
                    putEncodedName(lowerCase, str2);
                    return;
                } catch (ParseException unused) {
                }
            }
            this.list.put(lowerCase, str2);
        } else if (decodeParameters && this.multisegmentNames.size() > 0) {
            try {
                combineMultisegmentNames(true);
            } catch (ParseException unused2) {
            }
        }
    }

    public void set(String str, String str2, String str3) {
        if (encodeParameters) {
            Value encodeValue = encodeValue(str2, str3);
            if (encodeValue != null) {
                this.list.put(str.trim().toLowerCase(Locale.ENGLISH), encodeValue);
            } else {
                set(str, str2);
            }
        } else {
            set(str, str2);
        }
    }

    public int size() {
        return this.list.size();
    }

    public String toString() {
        return toString(0);
    }

    public String toString(int i) {
        String str;
        String str2;
        String str3;
        ToStringBuffer toStringBuffer = new ToStringBuffer(i);
        for (String str4 : this.list.keySet()) {
            Object obj = this.list.get(str4);
            if (obj instanceof MultiValue) {
                MultiValue multiValue = (MultiValue) obj;
                String str5 = String.valueOf(str4) + Marker.ANY_MARKER;
                for (int i2 = 0; i2 < multiValue.size(); i2++) {
                    Object obj2 = multiValue.get(i2);
                    if (obj2 instanceof Value) {
                        str2 = String.valueOf(str5) + i2 + Marker.ANY_MARKER;
                        str3 = ((Value) obj2).encodedValue;
                    } else {
                        str2 = String.valueOf(str5) + i2;
                        str3 = (String) obj2;
                    }
                    toStringBuffer.addNV(str2, str3);
                }
            } else {
                if (obj instanceof Value) {
                    str4 = String.valueOf(str4) + Marker.ANY_MARKER;
                    str = ((Value) obj).encodedValue;
                } else {
                    str = (String) obj;
                }
                toStringBuffer.addNV(str4, str);
            }
        }
        return toStringBuffer.toString();
    }
}
