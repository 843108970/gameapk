package b.a.j;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Marker;

public final class d implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public static final d f209a = new d();

    /* renamed from: b  reason: collision with root package name */
    private static final int f210b = 2;

    /* renamed from: c  reason: collision with root package name */
    private static final int f211c = 7;

    private d() {
    }

    public static List<String> a(X509Certificate x509Certificate) {
        List<String> a2 = a(x509Certificate, 7);
        List<String> a3 = a(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(a2.size() + a3.size());
        arrayList.addAll(a2);
        arrayList.addAll(a3);
        return arrayList;
    }

    private static List<String> a(X509Certificate x509Certificate, int i) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List next : subjectAlternativeNames) {
                if (!(next == null || next.size() < 2 || (num = (Integer) next.get(0)) == null || num.intValue() != i || (str = (String) next.get(1)) == null)) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    private static boolean a(String str, String str2) {
        if (str == null || str.length() == 0 || str.startsWith(".") || str.endsWith("..") || str2 == null || str2.length() == 0 || str2.startsWith(".") || str2.endsWith("..")) {
            return false;
        }
        if (!str.endsWith(".")) {
            str = str + FilenameUtils.EXTENSION_SEPARATOR;
        }
        if (!str2.endsWith(".")) {
            str2 = str2 + FilenameUtils.EXTENSION_SEPARATOR;
        }
        String lowerCase = str2.toLowerCase(Locale.US);
        if (!lowerCase.contains(Marker.ANY_MARKER)) {
            return str.equals(lowerCase);
        }
        if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
            return false;
        }
        String substring = lowerCase.substring(1);
        if (!str.endsWith(substring)) {
            return false;
        }
        int length = str.length() - substring.length();
        return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r10, java.security.cert.X509Certificate r11) {
        /*
            boolean r0 = b.a.c.c(r10)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0025
            r0 = 7
            java.util.List r11 = a((java.security.cert.X509Certificate) r11, (int) r0)
            int r0 = r11.size()
            r3 = 0
        L_0x0012:
            if (r3 >= r0) goto L_0x0024
            java.lang.Object r4 = r11.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            boolean r4 = r10.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0021
            return r2
        L_0x0021:
            int r3 = r3 + 1
            goto L_0x0012
        L_0x0024:
            return r1
        L_0x0025:
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r10 = r10.toLowerCase(r0)
            r0 = 2
            java.util.List r0 = a((java.security.cert.X509Certificate) r11, (int) r0)
            int r3 = r0.size()
            r4 = 0
            r5 = 0
        L_0x0036:
            if (r4 >= r3) goto L_0x0049
            java.lang.Object r5 = r0.get(r4)
            java.lang.String r5 = (java.lang.String) r5
            boolean r5 = a((java.lang.String) r10, (java.lang.String) r5)
            if (r5 == 0) goto L_0x0045
            return r2
        L_0x0045:
            int r4 = r4 + 1
            r5 = 1
            goto L_0x0036
        L_0x0049:
            if (r5 != 0) goto L_0x017a
            javax.security.auth.x500.X500Principal r11 = r11.getSubjectX500Principal()
            b.a.j.c r0 = new b.a.j.c
            r0.<init>(r11)
            java.lang.String r11 = "cn"
            r0.f208c = r1
            r0.d = r1
            r0.e = r1
            r0.f = r1
            java.lang.String r3 = r0.f206a
            char[] r3 = r3.toCharArray()
            r0.g = r3
            java.lang.String r3 = r0.a()
            r4 = 0
            if (r3 != 0) goto L_0x006f
            goto L_0x011e
        L_0x006f:
            java.lang.String r5 = ""
            int r6 = r0.f208c
            int r7 = r0.f207b
            if (r6 != r7) goto L_0x0079
            goto L_0x011e
        L_0x0079:
            char[] r6 = r0.g
            int r7 = r0.f208c
            char r6 = r6[r7]
            switch(r6) {
                case 34: goto L_0x008e;
                case 35: goto L_0x0088;
                case 43: goto L_0x0110;
                case 44: goto L_0x0110;
                case 59: goto L_0x0110;
                default: goto L_0x0082;
            }
        L_0x0082:
            java.lang.String r5 = r0.c()
            goto L_0x0110
        L_0x0088:
            java.lang.String r5 = r0.b()
            goto L_0x0110
        L_0x008e:
            int r5 = r0.f208c
            int r5 = r5 + r2
            r0.f208c = r5
            int r5 = r0.f208c
            r0.d = r5
            int r5 = r0.d
        L_0x0099:
            r0.e = r5
            int r5 = r0.f208c
            int r6 = r0.f207b
            if (r5 != r6) goto L_0x00b7
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r1 = "Unexpected end of DN: "
            r11.<init>(r1)
            java.lang.String r0 = r0.f206a
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x00b7:
            char[] r5 = r0.g
            int r6 = r0.f208c
            char r5 = r5[r6]
            r6 = 34
            if (r5 != r6) goto L_0x00e6
        L_0x00c1:
            int r5 = r0.f208c
            int r5 = r5 + r2
            r0.f208c = r5
            int r5 = r0.f208c
            int r6 = r0.f207b
            if (r5 >= r6) goto L_0x00d7
            char[] r5 = r0.g
            int r6 = r0.f208c
            char r5 = r5[r6]
            r6 = 32
            if (r5 != r6) goto L_0x00d7
            goto L_0x00c1
        L_0x00d7:
            java.lang.String r5 = new java.lang.String
            char[] r6 = r0.g
            int r7 = r0.d
            int r8 = r0.e
            int r9 = r0.d
            int r8 = r8 - r9
            r5.<init>(r6, r7, r8)
            goto L_0x0110
        L_0x00e6:
            char[] r5 = r0.g
            int r6 = r0.f208c
            char r5 = r5[r6]
            r6 = 92
            if (r5 != r6) goto L_0x00fb
            char[] r5 = r0.g
            int r6 = r0.e
            char r7 = r0.d()
            r5[r6] = r7
            goto L_0x0107
        L_0x00fb:
            char[] r5 = r0.g
            int r6 = r0.e
            char[] r7 = r0.g
            int r8 = r0.f208c
            char r7 = r7[r8]
            r5[r6] = r7
        L_0x0107:
            int r5 = r0.f208c
            int r5 = r5 + r2
            r0.f208c = r5
            int r5 = r0.e
            int r5 = r5 + r2
            goto L_0x0099
        L_0x0110:
            boolean r3 = r11.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0118
            r4 = r5
            goto L_0x011e
        L_0x0118:
            int r3 = r0.f208c
            int r5 = r0.f207b
            if (r3 < r5) goto L_0x0125
        L_0x011e:
            if (r4 == 0) goto L_0x017a
            boolean r10 = a((java.lang.String) r10, (java.lang.String) r4)
            return r10
        L_0x0125:
            char[] r3 = r0.g
            int r5 = r0.f208c
            char r3 = r3[r5]
            r5 = 44
            if (r3 == r5) goto L_0x0159
            char[] r3 = r0.g
            int r5 = r0.f208c
            char r3 = r3[r5]
            r5 = 59
            if (r3 == r5) goto L_0x0159
            char[] r3 = r0.g
            int r5 = r0.f208c
            char r3 = r3[r5]
            r5 = 43
            if (r3 == r5) goto L_0x0159
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r1 = "Malformed DN: "
            r11.<init>(r1)
            java.lang.String r0 = r0.f206a
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x0159:
            int r3 = r0.f208c
            int r3 = r3 + r2
            r0.f208c = r3
            java.lang.String r3 = r0.a()
            if (r3 != 0) goto L_0x006f
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r1 = "Malformed DN: "
            r11.<init>(r1)
            java.lang.String r0 = r0.f206a
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x017a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.j.d.a(java.lang.String, java.security.cert.X509Certificate):boolean");
    }

    private static boolean b(String str, X509Certificate x509Certificate) {
        List<String> a2 = a(x509Certificate, 7);
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(a2.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean c(java.lang.String r10, java.security.cert.X509Certificate r11) {
        /*
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r10 = r10.toLowerCase(r0)
            r0 = 2
            java.util.List r0 = a((java.security.cert.X509Certificate) r11, (int) r0)
            int r1 = r0.size()
            r2 = 0
            r3 = 1
            r4 = 0
            r5 = 0
        L_0x0013:
            if (r4 >= r1) goto L_0x0026
            java.lang.Object r5 = r0.get(r4)
            java.lang.String r5 = (java.lang.String) r5
            boolean r5 = a((java.lang.String) r10, (java.lang.String) r5)
            if (r5 == 0) goto L_0x0022
            return r3
        L_0x0022:
            int r4 = r4 + 1
            r5 = 1
            goto L_0x0013
        L_0x0026:
            if (r5 != 0) goto L_0x0157
            javax.security.auth.x500.X500Principal r11 = r11.getSubjectX500Principal()
            b.a.j.c r0 = new b.a.j.c
            r0.<init>(r11)
            java.lang.String r11 = "cn"
            r0.f208c = r2
            r0.d = r2
            r0.e = r2
            r0.f = r2
            java.lang.String r1 = r0.f206a
            char[] r1 = r1.toCharArray()
            r0.g = r1
            java.lang.String r1 = r0.a()
            r4 = 0
            if (r1 != 0) goto L_0x004c
            goto L_0x00fb
        L_0x004c:
            java.lang.String r5 = ""
            int r6 = r0.f208c
            int r7 = r0.f207b
            if (r6 != r7) goto L_0x0056
            goto L_0x00fb
        L_0x0056:
            char[] r6 = r0.g
            int r7 = r0.f208c
            char r6 = r6[r7]
            switch(r6) {
                case 34: goto L_0x006b;
                case 35: goto L_0x0065;
                case 43: goto L_0x00ed;
                case 44: goto L_0x00ed;
                case 59: goto L_0x00ed;
                default: goto L_0x005f;
            }
        L_0x005f:
            java.lang.String r5 = r0.c()
            goto L_0x00ed
        L_0x0065:
            java.lang.String r5 = r0.b()
            goto L_0x00ed
        L_0x006b:
            int r5 = r0.f208c
            int r5 = r5 + r3
            r0.f208c = r5
            int r5 = r0.f208c
            r0.d = r5
            int r5 = r0.d
        L_0x0076:
            r0.e = r5
            int r5 = r0.f208c
            int r6 = r0.f207b
            if (r5 != r6) goto L_0x0094
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r1 = "Unexpected end of DN: "
            r11.<init>(r1)
            java.lang.String r0 = r0.f206a
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x0094:
            char[] r5 = r0.g
            int r6 = r0.f208c
            char r5 = r5[r6]
            r6 = 34
            if (r5 != r6) goto L_0x00c3
        L_0x009e:
            int r5 = r0.f208c
            int r5 = r5 + r3
            r0.f208c = r5
            int r5 = r0.f208c
            int r6 = r0.f207b
            if (r5 >= r6) goto L_0x00b4
            char[] r5 = r0.g
            int r6 = r0.f208c
            char r5 = r5[r6]
            r6 = 32
            if (r5 != r6) goto L_0x00b4
            goto L_0x009e
        L_0x00b4:
            java.lang.String r5 = new java.lang.String
            char[] r6 = r0.g
            int r7 = r0.d
            int r8 = r0.e
            int r9 = r0.d
            int r8 = r8 - r9
            r5.<init>(r6, r7, r8)
            goto L_0x00ed
        L_0x00c3:
            char[] r5 = r0.g
            int r6 = r0.f208c
            char r5 = r5[r6]
            r6 = 92
            if (r5 != r6) goto L_0x00d8
            char[] r5 = r0.g
            int r6 = r0.e
            char r7 = r0.d()
            r5[r6] = r7
            goto L_0x00e4
        L_0x00d8:
            char[] r5 = r0.g
            int r6 = r0.e
            char[] r7 = r0.g
            int r8 = r0.f208c
            char r7 = r7[r8]
            r5[r6] = r7
        L_0x00e4:
            int r5 = r0.f208c
            int r5 = r5 + r3
            r0.f208c = r5
            int r5 = r0.e
            int r5 = r5 + r3
            goto L_0x0076
        L_0x00ed:
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x00f5
            r4 = r5
            goto L_0x00fb
        L_0x00f5:
            int r1 = r0.f208c
            int r5 = r0.f207b
            if (r1 < r5) goto L_0x0102
        L_0x00fb:
            if (r4 == 0) goto L_0x0157
            boolean r10 = a((java.lang.String) r10, (java.lang.String) r4)
            return r10
        L_0x0102:
            char[] r1 = r0.g
            int r5 = r0.f208c
            char r1 = r1[r5]
            r5 = 44
            if (r1 == r5) goto L_0x0136
            char[] r1 = r0.g
            int r5 = r0.f208c
            char r1 = r1[r5]
            r5 = 59
            if (r1 == r5) goto L_0x0136
            char[] r1 = r0.g
            int r5 = r0.f208c
            char r1 = r1[r5]
            r5 = 43
            if (r1 == r5) goto L_0x0136
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r1 = "Malformed DN: "
            r11.<init>(r1)
            java.lang.String r0 = r0.f206a
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x0136:
            int r1 = r0.f208c
            int r1 = r1 + r3
            r0.f208c = r1
            java.lang.String r1 = r0.a()
            if (r1 != 0) goto L_0x004c
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r1 = "Malformed DN: "
            r11.<init>(r1)
            java.lang.String r0 = r0.f206a
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x0157:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.j.d.c(java.lang.String, java.security.cert.X509Certificate):boolean");
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            return a(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }
}
