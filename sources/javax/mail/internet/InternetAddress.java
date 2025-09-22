package javax.mail.internet;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Locale;
import javax.mail.Address;
import javax.mail.Session;
import org.apache.commons.io.IOUtils;
import org.apache.commons.mail.EmailConstants;

public class InternetAddress extends Address implements Cloneable {
    private static final String rfc822phrase = HeaderTokenizer.RFC822.replace(' ', 0).replace(9, 0);
    private static final long serialVersionUID = -7507595530758302903L;
    private static final String specialsNoDot = "()<>,;:\\\"[]@";
    private static final String specialsNoDotNoAt = "()<>,;:\\\"[]";
    protected String address;
    protected String encodedPersonal;
    protected String personal;

    public InternetAddress() {
    }

    public InternetAddress(String str) throws AddressException {
        InternetAddress[] parse = parse(str, true);
        if (parse.length != 1) {
            throw new AddressException("Illegal address", str);
        }
        this.address = parse[0].address;
        this.personal = parse[0].personal;
        this.encodedPersonal = parse[0].encodedPersonal;
    }

    public InternetAddress(String str, String str2) throws UnsupportedEncodingException {
        this(str, str2, (String) null);
    }

    public InternetAddress(String str, String str2, String str3) throws UnsupportedEncodingException {
        this.address = str;
        setPersonal(str2, str3);
    }

    public InternetAddress(String str, boolean z) throws AddressException {
        this(str);
        if (z) {
            checkAddress(this.address, true, true);
        }
    }

    private static void checkAddress(String str, boolean z, boolean z2) throws AddressException {
        String str2;
        String str3;
        if (str.indexOf(34) < 0) {
            int i = 0;
            if (z) {
                while (true) {
                    int indexOfAny = indexOfAny(str, ",:", i);
                    if (indexOfAny < 0) {
                        break;
                    } else if (str.charAt(i) != '@') {
                        throw new AddressException("Illegal route-addr", str);
                    } else if (str.charAt(indexOfAny) == ':') {
                        i = indexOfAny + 1;
                        break;
                    } else {
                        i = indexOfAny + 1;
                    }
                }
            }
            int indexOf = str.indexOf(64, i);
            if (indexOf >= 0) {
                if (indexOf == i) {
                    throw new AddressException("Missing local name", str);
                } else if (indexOf == str.length() - 1) {
                    throw new AddressException("Missing domain", str);
                } else {
                    str2 = str.substring(i, indexOf);
                    str3 = str.substring(indexOf + 1);
                }
            } else if (z2) {
                throw new AddressException("Missing final '@domain'", str);
            } else {
                str3 = null;
                str2 = str;
            }
            if (indexOfAny(str, " \t\n\r") >= 0) {
                throw new AddressException("Illegal whitespace in address", str);
            } else if (indexOfAny(str2, specialsNoDot) >= 0) {
                throw new AddressException("Illegal character in local name", str);
            } else if (str3 != null && str3.indexOf(91) < 0 && indexOfAny(str3, specialsNoDot) >= 0) {
                throw new AddressException("Illegal character in domain", str);
            }
        }
    }

    public static InternetAddress getLocalAddress(Session session) {
        String str;
        String str2;
        String str3;
        InetAddress localHost;
        if (session == null) {
            try {
                str2 = System.getProperty("user.name");
                str = InetAddress.getLocalHost().getHostName();
                str3 = null;
            } catch (SecurityException | UnknownHostException | AddressException unused) {
            }
        } else {
            str3 = session.getProperty(EmailConstants.MAIL_FROM);
            if (str3 == null) {
                str2 = session.getProperty("mail.user");
                if (str2 == null || str2.length() == 0) {
                    str2 = session.getProperty("user.name");
                }
                if (str2 == null || str2.length() == 0) {
                    str2 = System.getProperty("user.name");
                }
                str = session.getProperty("mail.host");
                if ((str == null || str.length() == 0) && (localHost = InetAddress.getLocalHost()) != null) {
                    str = localHost.getHostName();
                }
            } else {
                str = null;
                str2 = null;
            }
        }
        if (!(str3 != null || str2 == null || str2.length() == 0 || str == null || str.length() == 0)) {
            str3 = String.valueOf(str2) + "@" + str;
        }
        if (str3 != null) {
            return new InternetAddress(str3);
        }
        return null;
    }

    private static int indexOfAny(String str, String str2) {
        return indexOfAny(str, str2, 0);
    }

    private static int indexOfAny(String str, String str2, int i) {
        try {
            int length = str.length();
            while (i < length) {
                if (str2.indexOf(str.charAt(i)) >= 0) {
                    return i;
                }
                i++;
            }
            return -1;
        } catch (StringIndexOutOfBoundsException unused) {
            return -1;
        }
    }

    private boolean isSimple() {
        return this.address == null || indexOfAny(this.address, specialsNoDotNoAt) < 0;
    }

    private static int lengthOfFirstSegment(String str) {
        int indexOf = str.indexOf(IOUtils.LINE_SEPARATOR_WINDOWS);
        return indexOf != -1 ? indexOf : str.length();
    }

    private static int lengthOfLastSegment(String str, int i) {
        int lastIndexOf = str.lastIndexOf(IOUtils.LINE_SEPARATOR_WINDOWS);
        return lastIndexOf != -1 ? (str.length() - lastIndexOf) - 2 : str.length() + i;
    }

    public static InternetAddress[] parse(String str) throws AddressException {
        return parse(str, true);
    }

    public static InternetAddress[] parse(String str, boolean z) throws AddressException {
        return parse(str, z, false);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0214, code lost:
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0218, code lost:
        r7 = r7 + 1;
        r5 = false;
        r6 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008d, code lost:
        if (r7 < r3) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0094, code lost:
        switch(r0.charAt(r7)) {
            case 92: goto L_0x00a5;
            case 93: goto L_0x0098;
            default: goto L_0x0097;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0098, code lost:
        if (r7 < r3) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a1, code lost:
        throw new javax.mail.internet.AddressException("Missing ']'", r0, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a5, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x013a, code lost:
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0148, code lost:
        r11 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x020b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static javax.mail.internet.InternetAddress[] parse(java.lang.String r18, boolean r19, boolean r20) throws javax.mail.internet.AddressException {
        /*
            r0 = r18
            int r3 = r18.length()
            java.util.Vector r4 = new java.util.Vector
            r4.<init>()
            r5 = 0
            r6 = -1
            r7 = 0
            r8 = -1
            r9 = -1
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = -1
            r14 = -1
        L_0x0015:
            if (r7 < r3) goto L_0x0077
            if (r8 < 0) goto L_0x006d
            if (r9 != r6) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r7 = r9
        L_0x001d:
            java.lang.String r3 = r0.substring(r8, r7)
            java.lang.String r3 = r3.trim()
            if (r12 != 0) goto L_0x004b
            if (r19 != 0) goto L_0x004b
            if (r20 == 0) goto L_0x002c
            goto L_0x004b
        L_0x002c:
            java.util.StringTokenizer r6 = new java.util.StringTokenizer
            r6.<init>(r3)
        L_0x0031:
            boolean r0 = r6.hasMoreTokens()
            if (r0 != 0) goto L_0x0038
            goto L_0x006d
        L_0x0038:
            java.lang.String r0 = r6.nextToken()
            checkAddress(r0, r5, r5)
            javax.mail.internet.InternetAddress r1 = new javax.mail.internet.InternetAddress
            r1.<init>()
            r1.setAddress(r0)
            r4.addElement(r1)
            goto L_0x0031
        L_0x004b:
            if (r19 != 0) goto L_0x004f
            if (r20 != 0) goto L_0x0052
        L_0x004f:
            checkAddress(r3, r11, r5)
        L_0x0052:
            javax.mail.internet.InternetAddress r1 = new javax.mail.internet.InternetAddress
            r1.<init>()
            r1.setAddress(r3)
            if (r13 < 0) goto L_0x006a
            java.lang.String r0 = r0.substring(r13, r14)
            java.lang.String r0 = r0.trim()
            java.lang.String r0 = unquote(r0)
            r1.encodedPersonal = r0
        L_0x006a:
            r4.addElement(r1)
        L_0x006d:
            int r0 = r4.size()
            javax.mail.internet.InternetAddress[] r0 = new javax.mail.internet.InternetAddress[r0]
            r4.copyInto(r0)
            return r0
        L_0x0077:
            char r15 = r0.charAt(r7)
            r5 = 34
            r6 = 92
            r16 = 1
            switch(r15) {
                case 9: goto L_0x0216;
                case 10: goto L_0x0216;
                case 13: goto L_0x0216;
                case 32: goto L_0x0216;
                case 34: goto L_0x01ef;
                case 40: goto L_0x01b4;
                case 41: goto L_0x01ac;
                case 44: goto L_0x013c;
                case 58: goto L_0x012b;
                case 59: goto L_0x0100;
                case 60: goto L_0x00b0;
                case 62: goto L_0x00a8;
                case 91: goto L_0x008b;
                default: goto L_0x0084;
            }
        L_0x0084:
            r5 = -1
            r15 = 0
            if (r8 != r5) goto L_0x0218
            r8 = r7
            goto L_0x0218
        L_0x008b:
            int r7 = r7 + 1
            if (r7 < r3) goto L_0x0090
            goto L_0x0098
        L_0x0090:
            char r5 = r0.charAt(r7)
            switch(r5) {
                case 92: goto L_0x00a5;
                case 93: goto L_0x0098;
                default: goto L_0x0097;
            }
        L_0x0097:
            goto L_0x008b
        L_0x0098:
            if (r7 < r3) goto L_0x00a2
            javax.mail.internet.AddressException r1 = new javax.mail.internet.AddressException
            java.lang.String r2 = "Missing ']'"
            r1.<init>(r2, r0, r7)
            throw r1
        L_0x00a2:
            r5 = -1
            goto L_0x013a
        L_0x00a5:
            int r7 = r7 + 1
            goto L_0x008b
        L_0x00a8:
            javax.mail.internet.AddressException r1 = new javax.mail.internet.AddressException
            java.lang.String r2 = "Missing '<'"
            r1.<init>(r2, r0, r7)
            throw r1
        L_0x00b0:
            if (r11 == 0) goto L_0x00ba
            javax.mail.internet.AddressException r1 = new javax.mail.internet.AddressException
            java.lang.String r2 = "Extra route-addr"
            r1.<init>(r2, r0, r7)
            throw r1
        L_0x00ba:
            if (r10 != 0) goto L_0x00c3
            if (r8 < 0) goto L_0x00bf
            r14 = r7
        L_0x00bf:
            int r9 = r7 + 1
            r11 = r8
            goto L_0x00c5
        L_0x00c3:
            r9 = r8
            r11 = r13
        L_0x00c5:
            r15 = r14
            r8 = 0
        L_0x00c7:
            int r7 = r7 + 1
            if (r7 < r3) goto L_0x00cc
            goto L_0x00df
        L_0x00cc:
            char r12 = r0.charAt(r7)
            if (r12 == r5) goto L_0x00fd
            r13 = 62
            if (r12 == r13) goto L_0x00dc
            if (r12 == r6) goto L_0x00d9
            goto L_0x00c7
        L_0x00d9:
            int r7 = r7 + 1
            goto L_0x00c7
        L_0x00dc:
            if (r8 == 0) goto L_0x00df
            goto L_0x00c7
        L_0x00df:
            if (r7 < r3) goto L_0x00f3
            if (r8 == 0) goto L_0x00eb
            javax.mail.internet.AddressException r1 = new javax.mail.internet.AddressException
            java.lang.String r2 = "Missing '\"'"
            r1.<init>(r2, r0, r7)
            throw r1
        L_0x00eb:
            javax.mail.internet.AddressException r1 = new javax.mail.internet.AddressException
            java.lang.String r2 = "Missing '>'"
            r1.<init>(r2, r0, r7)
            throw r1
        L_0x00f3:
            r8 = r9
            r13 = r11
            r14 = r15
            r5 = -1
            r11 = 1
            r12 = 1
            r15 = 0
            r9 = r7
            goto L_0x0218
        L_0x00fd:
            r8 = r8 ^ 1
            goto L_0x00c7
        L_0x0100:
            r5 = -1
            if (r8 != r5) goto L_0x0104
            r8 = r7
        L_0x0104:
            if (r10 != 0) goto L_0x010e
            javax.mail.internet.AddressException r1 = new javax.mail.internet.AddressException
            java.lang.String r2 = "Illegal semicolon, not in group"
            r1.<init>(r2, r0, r7)
            throw r1
        L_0x010e:
            if (r8 != r5) goto L_0x0111
            r8 = r7
        L_0x0111:
            javax.mail.internet.InternetAddress r5 = new javax.mail.internet.InternetAddress
            r5.<init>()
            int r6 = r7 + 1
            java.lang.String r6 = r0.substring(r8, r6)
            java.lang.String r6 = r6.trim()
            r5.setAddress(r6)
            r4.addElement(r5)
            r5 = -1
            r8 = -1
            r9 = -1
            r10 = 0
            goto L_0x0148
        L_0x012b:
            if (r10 == 0) goto L_0x0135
            javax.mail.internet.AddressException r1 = new javax.mail.internet.AddressException
            java.lang.String r2 = "Nested group"
            r1.<init>(r2, r0, r7)
            throw r1
        L_0x0135:
            r5 = -1
            if (r8 != r5) goto L_0x0139
            r8 = r7
        L_0x0139:
            r10 = 1
        L_0x013a:
            r12 = 1
            goto L_0x0143
        L_0x013c:
            r5 = -1
            if (r8 != r5) goto L_0x0146
            r8 = -1
            r9 = -1
            r11 = 0
            r12 = 0
        L_0x0143:
            r15 = 0
            goto L_0x0218
        L_0x0146:
            if (r10 == 0) goto L_0x014a
        L_0x0148:
            r11 = 0
            goto L_0x0143
        L_0x014a:
            if (r9 != r5) goto L_0x014d
            r9 = r7
        L_0x014d:
            java.lang.String r5 = r0.substring(r8, r9)
            java.lang.String r5 = r5.trim()
            if (r12 != 0) goto L_0x017d
            if (r19 != 0) goto L_0x017d
            if (r20 == 0) goto L_0x015c
            goto L_0x017d
        L_0x015c:
            java.util.StringTokenizer r6 = new java.util.StringTokenizer
            r6.<init>(r5)
        L_0x0161:
            boolean r5 = r6.hasMoreTokens()
            if (r5 != 0) goto L_0x0169
            r15 = 0
            goto L_0x01a5
        L_0x0169:
            java.lang.String r5 = r6.nextToken()
            r8 = 0
            checkAddress(r5, r8, r8)
            javax.mail.internet.InternetAddress r8 = new javax.mail.internet.InternetAddress
            r8.<init>()
            r8.setAddress(r5)
            r4.addElement(r8)
            goto L_0x0161
        L_0x017d:
            if (r19 != 0) goto L_0x0184
            if (r20 != 0) goto L_0x0182
            goto L_0x0184
        L_0x0182:
            r15 = 0
            goto L_0x0188
        L_0x0184:
            r15 = 0
            checkAddress(r5, r11, r15)
        L_0x0188:
            javax.mail.internet.InternetAddress r6 = new javax.mail.internet.InternetAddress
            r6.<init>()
            r6.setAddress(r5)
            if (r13 < 0) goto L_0x01a2
            java.lang.String r5 = r0.substring(r13, r14)
            java.lang.String r5 = r5.trim()
            java.lang.String r5 = unquote(r5)
            r6.encodedPersonal = r5
            r13 = -1
            r14 = -1
        L_0x01a2:
            r4.addElement(r6)
        L_0x01a5:
            r5 = -1
            r8 = -1
            r9 = -1
            r11 = 0
            r12 = 0
            goto L_0x0218
        L_0x01ac:
            javax.mail.internet.AddressException r1 = new javax.mail.internet.AddressException
            java.lang.String r2 = "Missing '('"
            r1.<init>(r2, r0, r7)
            throw r1
        L_0x01b4:
            r15 = 0
            if (r8 < 0) goto L_0x01bc
            r5 = -1
            if (r9 != r5) goto L_0x01bd
            r9 = r7
            goto L_0x01bd
        L_0x01bc:
            r5 = -1
        L_0x01bd:
            if (r13 != r5) goto L_0x01c1
            int r13 = r7 + 1
        L_0x01c1:
            int r7 = r7 + 1
            r5 = 1
        L_0x01c4:
            if (r7 >= r3) goto L_0x01de
            if (r5 > 0) goto L_0x01c9
            goto L_0x01de
        L_0x01c9:
            char r12 = r0.charAt(r7)
            if (r12 == r6) goto L_0x01d9
            switch(r12) {
                case 40: goto L_0x01d6;
                case 41: goto L_0x01d3;
                default: goto L_0x01d2;
            }
        L_0x01d2:
            goto L_0x01db
        L_0x01d3:
            int r5 = r5 + -1
            goto L_0x01db
        L_0x01d6:
            int r5 = r5 + 1
            goto L_0x01db
        L_0x01d9:
            int r7 = r7 + 1
        L_0x01db:
            int r7 = r7 + 1
            goto L_0x01c4
        L_0x01de:
            if (r5 <= 0) goto L_0x01e8
            javax.mail.internet.AddressException r1 = new javax.mail.internet.AddressException
            java.lang.String r2 = "Missing ')'"
            r1.<init>(r2, r0, r7)
            throw r1
        L_0x01e8:
            int r7 = r7 + -1
            r5 = -1
            if (r14 != r5) goto L_0x0214
            r14 = r7
            goto L_0x0214
        L_0x01ef:
            r5 = -1
            r15 = 0
            if (r8 != r5) goto L_0x01f4
            r8 = r7
        L_0x01f4:
            int r7 = r7 + 1
        L_0x01f6:
            if (r7 < r3) goto L_0x01f9
            goto L_0x0209
        L_0x01f9:
            char r5 = r0.charAt(r7)
            r12 = 34
            if (r5 == r12) goto L_0x0209
            if (r5 == r6) goto L_0x0204
            goto L_0x0206
        L_0x0204:
            int r7 = r7 + 1
        L_0x0206:
            int r7 = r7 + 1
            goto L_0x01f6
        L_0x0209:
            if (r7 < r3) goto L_0x0213
            javax.mail.internet.AddressException r1 = new javax.mail.internet.AddressException
            java.lang.String r2 = "Missing '\"'"
            r1.<init>(r2, r0, r7)
            throw r1
        L_0x0213:
            r5 = -1
        L_0x0214:
            r12 = 1
            goto L_0x0218
        L_0x0216:
            r15 = 0
            r5 = -1
        L_0x0218:
            int r7 = r7 + 1
            r5 = 0
            r6 = -1
            goto L_0x0015
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.InternetAddress.parse(java.lang.String, boolean, boolean):javax.mail.internet.InternetAddress[]");
    }

    public static InternetAddress[] parseHeader(String str, boolean z) throws AddressException {
        return parse(str, z, true);
    }

    private static String quotePhrase(String str) {
        int length = str.length();
        boolean z = false;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\"' || charAt == '\\') {
                StringBuffer stringBuffer = new StringBuffer(length + 3);
                stringBuffer.append('\"');
                for (int i2 = 0; i2 < length; i2++) {
                    char charAt2 = str.charAt(i2);
                    if (charAt2 == '\"' || charAt2 == '\\') {
                        stringBuffer.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                    }
                    stringBuffer.append(charAt2);
                }
                stringBuffer.append('\"');
                return stringBuffer.toString();
            }
            if ((charAt < ' ' && charAt != 13 && charAt != 10 && charAt != 9) || charAt >= 127 || rfc822phrase.indexOf(charAt) >= 0) {
                z = true;
            }
        }
        if (!z) {
            return str;
        }
        StringBuffer stringBuffer2 = new StringBuffer(length + 2);
        stringBuffer2.append('\"');
        stringBuffer2.append(str);
        stringBuffer2.append('\"');
        return stringBuffer2.toString();
    }

    public static String toString(Address[] addressArr) {
        return toString(addressArr, 0);
    }

    public static String toString(Address[] addressArr, int i) {
        if (addressArr == null || addressArr.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < addressArr.length; i2++) {
            if (i2 != 0) {
                stringBuffer.append(", ");
                i += 2;
            }
            String address2 = addressArr[i2].toString();
            if (lengthOfFirstSegment(address2) + i > 76) {
                stringBuffer.append("\r\n\t");
                i = 8;
            }
            stringBuffer.append(address2);
            i = lengthOfLastSegment(address2, i);
        }
        return stringBuffer.toString();
    }

    private static String unquote(String str) {
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1);
            if (str.indexOf(92) >= 0) {
                StringBuffer stringBuffer = new StringBuffer(str.length());
                int i = 0;
                while (i < str.length()) {
                    char charAt = str.charAt(i);
                    if (charAt == '\\' && i < str.length() - 1) {
                        i++;
                        charAt = str.charAt(i);
                    }
                    stringBuffer.append(charAt);
                    i++;
                }
                return stringBuffer.toString();
            }
        }
        return str;
    }

    public Object clone() {
        try {
            return (InternetAddress) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof InternetAddress)) {
            return false;
        }
        String address2 = ((InternetAddress) obj).getAddress();
        if (address2 == this.address) {
            return true;
        }
        return this.address != null && this.address.equalsIgnoreCase(address2);
    }

    public String getAddress() {
        return this.address;
    }

    public InternetAddress[] getGroup(boolean z) throws AddressException {
        int indexOf;
        String address2 = getAddress();
        if (address2.endsWith(";") && (indexOf = address2.indexOf(58)) >= 0) {
            return parseHeader(address2.substring(indexOf + 1, address2.length() - 1), z);
        }
        return null;
    }

    public String getPersonal() {
        if (this.personal != null) {
            return this.personal;
        }
        if (this.encodedPersonal == null) {
            return null;
        }
        try {
            this.personal = MimeUtility.decodeText(this.encodedPersonal);
            return this.personal;
        } catch (Exception unused) {
            return this.encodedPersonal;
        }
    }

    public String getType() {
        return "rfc822";
    }

    public int hashCode() {
        if (this.address == null) {
            return 0;
        }
        return this.address.toLowerCase(Locale.ENGLISH).hashCode();
    }

    public boolean isGroup() {
        return this.address != null && this.address.endsWith(";") && this.address.indexOf(58) > 0;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setPersonal(String str) throws UnsupportedEncodingException {
        this.personal = str;
        this.encodedPersonal = str != null ? MimeUtility.encodeWord(str) : null;
    }

    public void setPersonal(String str, String str2) throws UnsupportedEncodingException {
        this.personal = str;
        if (str != null) {
            this.encodedPersonal = MimeUtility.encodeWord(str, str2, (String) null);
        } else {
            this.encodedPersonal = null;
        }
    }

    public String toString() {
        StringBuilder sb;
        if (this.encodedPersonal == null && this.personal != null) {
            try {
                this.encodedPersonal = MimeUtility.encodeWord(this.personal);
            } catch (UnsupportedEncodingException unused) {
            }
        }
        if (this.encodedPersonal != null) {
            sb = new StringBuilder(String.valueOf(quotePhrase(this.encodedPersonal)));
            sb.append(" <");
        } else if (isGroup() || isSimple()) {
            return this.address;
        } else {
            sb = new StringBuilder("<");
        }
        sb.append(this.address);
        sb.append(">");
        return sb.toString();
    }

    public String toUnicodeString() {
        String personal2 = getPersonal();
        if (personal2 != null) {
            return String.valueOf(quotePhrase(personal2)) + " <" + this.address + ">";
        } else if (isGroup() || isSimple()) {
            return this.address;
        } else {
            return "<" + this.address + ">";
        }
    }

    public void validate() throws AddressException {
        checkAddress(getAddress(), true, true);
    }
}
