package b;

import b.a.c;
import com.umeng.commonsdk.proguard.bg;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import org.apache.commons.io.IOUtils;
import org.slf4j.Marker;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    static final String f352a = " \"':;<=>@[]^`{}|/\\?#";

    /* renamed from: b  reason: collision with root package name */
    static final String f353b = " \"':;<=>@[]^`{}|/\\?#";

    /* renamed from: c  reason: collision with root package name */
    static final String f354c = " \"<>^`{}|/\\?#";
    static final String d = "[]";
    static final String e = " \"'<>#";
    static final String f = " \"'<>#&=";
    static final String g = "\\^`{|}";
    static final String h = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    static final String i = "";
    static final String j = " \"#<>\\^`{|}";
    private static final char[] o = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final String k;
    public final String l;
    public final int m;
    @Nullable
    public final List<String> n;
    private final String p;
    private final String q;
    private final List<String> r;
    @Nullable
    private final String s;
    private final String t;

    public static final class a {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        String f356a;

        /* renamed from: b  reason: collision with root package name */
        String f357b = "";

        /* renamed from: c  reason: collision with root package name */
        String f358c = "";
        @Nullable
        String d;
        int e = -1;
        final List<String> f = new ArrayList();
        @Nullable
        List<String> g;
        @Nullable
        String h;

        /* renamed from: b.v$a$a  reason: collision with other inner class name */
        enum C0005a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            this.f.add("");
        }

        private a a(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.e = i;
            return this;
        }

        private a a(int i, String str) {
            if (str == null) {
                throw new NullPointerException("pathSegment == null");
            }
            String a2 = v.a(str, 0, str.length(), v.f354c, false, false, false, true);
            if (s(a2) || t(a2)) {
                throw new IllegalArgumentException("unexpected path segment: " + str);
            }
            this.f.set(i, a2);
            return this;
        }

        private a a(String str, @Nullable String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add(v.a(str, v.f, false, false, true, true));
            this.g.add(str2 != null ? v.a(str2, v.f, false, false, true, true) : null);
            return this;
        }

        private a a(String str, boolean z) {
            int i = 0;
            do {
                int a2 = c.a(str, i, str.length(), "/\\");
                a(str, i, a2, a2 < str.length(), z);
                i = a2 + 1;
            } while (i <= str.length());
            return this;
        }

        static String a(String str, int i, int i2) {
            int i3 = 0;
            String a2 = v.a(str, i, i2, false);
            if (!a2.contains(":")) {
                return c.a(a2);
            }
            InetAddress f2 = (!a2.startsWith("[") || !a2.endsWith("]")) ? f(a2, 0, a2.length()) : f(a2, 1, a2.length() - 1);
            if (f2 == null) {
                return null;
            }
            byte[] address = f2.getAddress();
            if (address.length == 16) {
                int i4 = 0;
                int i5 = 0;
                int i6 = -1;
                while (i4 < address.length) {
                    int i7 = i4;
                    while (i7 < 16 && address[i7] == 0 && address[i7 + 1] == 0) {
                        i7 += 2;
                    }
                    int i8 = i7 - i4;
                    if (i8 > i5 && i8 >= 4) {
                        i6 = i4;
                        i5 = i8;
                    }
                    i4 = i7 + 2;
                }
                c.c cVar = new c.c();
                while (i3 < address.length) {
                    if (i3 == i6) {
                        cVar.l(58);
                        i3 += i5;
                        if (i3 == 16) {
                            cVar.l(58);
                        }
                    } else {
                        if (i3 > 0) {
                            cVar.l(58);
                        }
                        cVar.m((long) (((address[i3] & 255) << 8) | (address[i3 + 1] & 255)));
                        i3 += 2;
                    }
                }
                return cVar.q();
            }
            throw new AssertionError();
        }

        private static String a(byte[] bArr) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = -1;
            while (i2 < bArr.length) {
                int i5 = i2;
                while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                    i5 += 2;
                }
                int i6 = i5 - i2;
                if (i6 > i3 && i6 >= 4) {
                    i4 = i2;
                    i3 = i6;
                }
                i2 = i5 + 2;
            }
            c.c cVar = new c.c();
            while (i < bArr.length) {
                if (i == i4) {
                    cVar.l(58);
                    i += i3;
                    if (i == 16) {
                        cVar.l(58);
                    }
                } else {
                    if (i > 0) {
                        cVar.l(58);
                    }
                    cVar.m((long) (((bArr[i] & 255) << 8) | (bArr[i + 1] & 255)));
                    i += 2;
                }
            }
            return cVar.q();
        }

        private void a(String str, int i, int i2, boolean z, boolean z2) {
            String a2 = v.a(str, i, i2, v.f354c, z2, false, false, true);
            if (!s(a2)) {
                if (!t(a2)) {
                    if (this.f.get(this.f.size() - 1).isEmpty()) {
                        this.f.set(this.f.size() - 1, a2);
                    } else {
                        this.f.add(a2);
                    }
                    if (z) {
                        this.f.add("");
                    }
                } else if (!this.f.remove(this.f.size() - 1).isEmpty() || this.f.isEmpty()) {
                    this.f.add("");
                } else {
                    this.f.set(this.f.size() - 1, "");
                }
            }
        }

        private static boolean a(String str, int i, int i2, byte[] bArr, int i3) {
            int i4 = i3;
            while (i < i2) {
                if (i4 == 16) {
                    return false;
                }
                if (i4 != i3) {
                    if (str.charAt(i) != '.') {
                        return false;
                    }
                    i++;
                }
                int i5 = i;
                int i6 = 0;
                while (i5 < i2) {
                    char charAt = str.charAt(i5);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    } else if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + charAt) - 48) > 255) {
                        return false;
                    } else {
                        i5++;
                    }
                }
                if (i5 - i == 0) {
                    return false;
                }
                bArr[i4] = (byte) i6;
                i4++;
                i = i5;
            }
            return i4 == i3 + 4;
        }

        private a b(int i) {
            this.f.remove(i);
            if (this.f.isEmpty()) {
                this.f.add("");
            }
            return this;
        }

        private a b(int i, String str) {
            if (str == null) {
                throw new NullPointerException("encodedPathSegment == null");
            }
            String a2 = v.a(str, 0, str.length(), v.f354c, true, false, false, true);
            this.f.set(i, a2);
            if (!s(a2) && !t(a2)) {
                return this;
            }
            throw new IllegalArgumentException("unexpected path segment: " + str);
        }

        private a b(String str) {
            String str2;
            if (str.equalsIgnoreCase("http")) {
                str2 = "http";
            } else if (str.equalsIgnoreCase("https")) {
                str2 = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            this.f356a = str2;
            return this;
        }

        private a b(String str, @Nullable String str2) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add(v.a(str, v.f, true, false, true, true));
            this.g.add(str2 != null ? v.a(str2, v.f, true, false, true, true) : null);
            return this;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0047 A[SYNTHETIC] */
        private void b(java.lang.String r10, int r11, int r12) {
            /*
                r9 = this;
                if (r11 != r12) goto L_0x0003
                return
            L_0x0003:
                char r0 = r10.charAt(r11)
                r1 = 47
                r2 = 1
                if (r0 == r1) goto L_0x0020
                r1 = 92
                if (r0 != r1) goto L_0x0011
                goto L_0x0020
            L_0x0011:
                java.util.List<java.lang.String> r0 = r9.f
                java.util.List<java.lang.String> r1 = r9.f
                int r1 = r1.size()
                int r1 = r1 - r2
                java.lang.String r3 = ""
                r0.set(r1, r3)
                goto L_0x002e
            L_0x0020:
                java.util.List<java.lang.String> r0 = r9.f
                r0.clear()
                java.util.List<java.lang.String> r0 = r9.f
                java.lang.String r1 = ""
                r0.add(r1)
            L_0x002c:
                int r11 = r11 + 1
            L_0x002e:
                r5 = r11
                if (r5 >= r12) goto L_0x0047
                java.lang.String r11 = "/\\"
                int r11 = b.a.c.a((java.lang.String) r10, (int) r5, (int) r12, (java.lang.String) r11)
                if (r11 >= r12) goto L_0x003b
                r0 = 1
                goto L_0x003c
            L_0x003b:
                r0 = 0
            L_0x003c:
                r8 = 1
                r3 = r9
                r4 = r10
                r6 = r11
                r7 = r0
                r3.a((java.lang.String) r4, (int) r5, (int) r6, (boolean) r7, (boolean) r8)
                if (r0 == 0) goto L_0x002e
                goto L_0x002c
            L_0x0047:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b.v.a.b(java.lang.String, int, int):void");
        }

        private static int c(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                return -1;
            }
            while (true) {
                i++;
                if (i >= i2) {
                    break;
                }
                char charAt2 = str.charAt(i);
                if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                    if (charAt2 == ':') {
                        return i;
                    }
                }
            }
            return -1;
        }

        private a c() {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                this.f.set(i, v.a(this.f.get(i), v.d, true, true, false, true));
            }
            if (this.g != null) {
                int size2 = this.g.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.g.get(i2);
                    if (str != null) {
                        this.g.set(i2, v.a(str, v.g, true, true, true, true));
                    }
                }
            }
            if (this.h != null) {
                this.h = v.a(this.h, v.j, true, true, false, false);
            }
            return this;
        }

        private a c(String str) {
            this.f357b = v.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        private a c(String str, @Nullable String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (this.g != null) {
                p(v.a(str, v.f, false, false, true, true));
            }
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add(v.a(str, v.f, false, false, true, true));
            this.g.add(str2 != null ? v.a(str2, v.f, false, false, true, true) : null);
            return this;
        }

        private static int d(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private a d(String str) {
            if (str == null) {
                throw new NullPointerException("encodedUsername == null");
            }
            this.f357b = v.a(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        private a d(String str, @Nullable String str2) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.g != null) {
                p(v.a(str, v.f, true, false, true, true));
            }
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add(v.a(str, v.f, true, false, true, true));
            this.g.add(str2 != null ? v.a(str2, v.f, true, false, true, true) : null);
            return this;
        }

        private void d() {
            if (!this.f.remove(this.f.size() - 1).isEmpty() || this.f.isEmpty()) {
                this.f.add("");
            } else {
                this.f.set(this.f.size() - 1, "");
            }
        }

        private static int e(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i >= i2) {
                            break;
                        }
                    } while (str.charAt(i) == ']');
                }
                i++;
            }
            return i2;
        }

        private a e(String str) {
            this.f358c = v.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        private a f(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPassword == null");
            }
            this.f358c = v.a(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0097, code lost:
            r5 = 0;
         */
        @javax.annotation.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.net.InetAddress f(java.lang.String r17, int r18, int r19) {
            /*
                r0 = r17
                r1 = r19
                r2 = 16
                byte[] r3 = new byte[r2]
                r4 = -1
                r5 = 0
                r6 = r18
                r7 = 0
                r8 = -1
                r9 = -1
            L_0x000f:
                r10 = 0
                if (r6 >= r1) goto L_0x00d4
                if (r7 != r2) goto L_0x0015
                return r10
            L_0x0015:
                int r11 = r6 + 2
                r12 = 4
                r13 = 255(0xff, float:3.57E-43)
                if (r11 > r1) goto L_0x0033
                java.lang.String r14 = "::"
                r15 = 2
                boolean r14 = r0.regionMatches(r6, r14, r5, r15)
                if (r14 == 0) goto L_0x0033
                if (r8 == r4) goto L_0x0028
                return r10
            L_0x0028:
                int r7 = r7 + 2
                if (r11 != r1) goto L_0x002f
                r8 = r7
                goto L_0x00d4
            L_0x002f:
                r8 = r7
                r9 = r11
                goto L_0x00a2
            L_0x0033:
                if (r7 == 0) goto L_0x00a1
                java.lang.String r11 = ":"
                r14 = 1
                boolean r11 = r0.regionMatches(r6, r11, r5, r14)
                if (r11 == 0) goto L_0x0042
                int r6 = r6 + 1
                goto L_0x00a1
            L_0x0042:
                java.lang.String r11 = "."
                boolean r6 = r0.regionMatches(r6, r11, r5, r14)
                if (r6 == 0) goto L_0x00a0
                int r6 = r7 + -2
                r11 = r6
            L_0x004d:
                if (r9 >= r1) goto L_0x0094
                if (r11 != r2) goto L_0x0052
                goto L_0x009a
            L_0x0052:
                if (r11 == r6) goto L_0x005f
                char r15 = r0.charAt(r9)
                r14 = 46
                if (r15 == r14) goto L_0x005d
                goto L_0x009a
            L_0x005d:
                int r9 = r9 + 1
            L_0x005f:
                r14 = r9
                r15 = 0
            L_0x0061:
                if (r14 >= r1) goto L_0x0082
                char r5 = r0.charAt(r14)
                r2 = 48
                if (r5 < r2) goto L_0x0082
                r4 = 57
                if (r5 > r4) goto L_0x0082
                if (r15 != 0) goto L_0x0074
                if (r9 == r14) goto L_0x0074
                goto L_0x0097
            L_0x0074:
                int r15 = r15 * 10
                int r15 = r15 + r5
                int r15 = r15 - r2
                if (r15 <= r13) goto L_0x007b
                goto L_0x0097
            L_0x007b:
                int r14 = r14 + 1
                r2 = 16
                r4 = -1
                r5 = 0
                goto L_0x0061
            L_0x0082:
                int r2 = r14 - r9
                if (r2 != 0) goto L_0x0087
                goto L_0x0097
            L_0x0087:
                int r2 = r11 + 1
                byte r4 = (byte) r15
                r3[r11] = r4
                r11 = r2
                r9 = r14
                r2 = 16
                r4 = -1
                r5 = 0
                r14 = 1
                goto L_0x004d
            L_0x0094:
                int r6 = r6 + r12
                if (r11 == r6) goto L_0x0099
            L_0x0097:
                r5 = 0
                goto L_0x009a
            L_0x0099:
                r5 = 1
            L_0x009a:
                if (r5 != 0) goto L_0x009d
                return r10
            L_0x009d:
                int r7 = r7 + 2
                goto L_0x00d4
            L_0x00a0:
                return r10
            L_0x00a1:
                r9 = r6
            L_0x00a2:
                r6 = r9
                r2 = 0
            L_0x00a4:
                if (r6 >= r1) goto L_0x00b7
                char r4 = r0.charAt(r6)
                int r4 = b.v.a((char) r4)
                r5 = -1
                if (r4 == r5) goto L_0x00b7
                int r2 = r2 << 4
                int r2 = r2 + r4
                int r6 = r6 + 1
                goto L_0x00a4
            L_0x00b7:
                int r4 = r6 - r9
                if (r4 == 0) goto L_0x00d3
                if (r4 <= r12) goto L_0x00be
                return r10
            L_0x00be:
                int r4 = r7 + 1
                int r5 = r2 >>> 8
                r5 = r5 & r13
                byte r5 = (byte) r5
                r3[r7] = r5
                int r7 = r4 + 1
                r2 = r2 & 255(0xff, float:3.57E-43)
                byte r2 = (byte) r2
                r3[r4] = r2
                r2 = 16
                r4 = -1
                r5 = 0
                goto L_0x000f
            L_0x00d3:
                return r10
            L_0x00d4:
                r0 = 16
                if (r7 == r0) goto L_0x00ea
                r1 = -1
                if (r8 != r1) goto L_0x00dc
                return r10
            L_0x00dc:
                int r1 = r7 - r8
                int r2 = 16 - r1
                java.lang.System.arraycopy(r3, r8, r3, r2, r1)
                int r2 = 16 - r7
                int r2 = r2 + r8
                r0 = 0
                java.util.Arrays.fill(r3, r8, r2, r0)
            L_0x00ea:
                java.net.InetAddress r0 = java.net.InetAddress.getByAddress(r3)     // Catch:{ UnknownHostException -> 0x00ef }
                return r0
            L_0x00ef:
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: b.v.a.f(java.lang.String, int, int):java.net.InetAddress");
        }

        private static int g(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(v.a(str, i, i2, "", false, false, false, true));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }

        private a g(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String a2 = a(str, 0, str.length());
            if (a2 == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.d = a2;
            return this;
        }

        private a h(String str) {
            if (str == null) {
                throw new NullPointerException("pathSegment == null");
            }
            a(str, 0, str.length(), false, false);
            return this;
        }

        private a i(String str) {
            if (str != null) {
                return a(str, false);
            }
            throw new NullPointerException("pathSegments == null");
        }

        private a j(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPathSegment == null");
            }
            a(str, 0, str.length(), false, true);
            return this;
        }

        private a k(String str) {
            if (str != null) {
                return a(str, true);
            }
            throw new NullPointerException("encodedPathSegments == null");
        }

        private a l(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPath == null");
            } else if (!str.startsWith("/")) {
                throw new IllegalArgumentException("unexpected encodedPath: " + str);
            } else {
                b(str, 0, str.length());
                return this;
            }
        }

        private a m(@Nullable String str) {
            this.g = str != null ? v.b(v.a(str, v.e, false, false, true, true)) : null;
            return this;
        }

        private a n(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (this.g == null) {
                return this;
            } else {
                p(v.a(str, v.f, false, false, true, true));
                return this;
            }
        }

        private a o(String str) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            } else if (this.g == null) {
                return this;
            } else {
                p(v.a(str, v.f, true, false, true, true));
                return this;
            }
        }

        private void p(String str) {
            for (int size = this.g.size() - 2; size >= 0; size -= 2) {
                if (str.equals(this.g.get(size))) {
                    this.g.remove(size + 1);
                    this.g.remove(size);
                    if (this.g.isEmpty()) {
                        this.g = null;
                        return;
                    }
                }
            }
        }

        private a q(@Nullable String str) {
            this.h = str != null ? v.a(str, "", false, false, false, false) : null;
            return this;
        }

        private a r(@Nullable String str) {
            this.h = str != null ? v.a(str, "", true, false, false, false) : null;
            return this;
        }

        private static boolean s(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private static boolean t(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        /* access modifiers changed from: package-private */
        public final int a() {
            return this.e != -1 ? this.e : v.a(this.f356a);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0058, code lost:
            if (r7 == ':') goto L_0x005f;
         */
        /* JADX WARNING: Removed duplicated region for block: B:117:0x0192 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:118:0x00f2 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0061  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x008c  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x00fa  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x00ff  */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x010c  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x019b  */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x01ae  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x01c0  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final b.v.a.C0005a a(@javax.annotation.Nullable b.v r23, java.lang.String r24) {
            /*
                r22 = this;
                r0 = r22
                r1 = r23
                r9 = r24
                int r2 = r24.length()
                r8 = 0
                int r10 = b.a.c.a((java.lang.String) r9, (int) r8, (int) r2)
                int r2 = r24.length()
                int r11 = b.a.c.b((java.lang.String) r9, (int) r10, (int) r2)
                int r2 = r11 - r10
                r12 = 58
                r13 = 2
                r14 = -1
                if (r2 < r13) goto L_0x005e
                char r2 = r9.charAt(r10)
                r3 = 90
                r4 = 65
                r5 = 122(0x7a, float:1.71E-43)
                r6 = 97
                if (r2 < r6) goto L_0x002f
                if (r2 <= r5) goto L_0x0034
            L_0x002f:
                if (r2 < r4) goto L_0x005e
                if (r2 <= r3) goto L_0x0034
                goto L_0x005e
            L_0x0034:
                int r2 = r10 + 1
            L_0x0036:
                if (r2 >= r11) goto L_0x005e
                char r7 = r9.charAt(r2)
                if (r7 < r6) goto L_0x0040
                if (r7 <= r5) goto L_0x005b
            L_0x0040:
                if (r7 < r4) goto L_0x0044
                if (r7 <= r3) goto L_0x005b
            L_0x0044:
                r15 = 48
                if (r7 < r15) goto L_0x004c
                r15 = 57
                if (r7 <= r15) goto L_0x005b
            L_0x004c:
                r15 = 43
                if (r7 == r15) goto L_0x005b
                r15 = 45
                if (r7 == r15) goto L_0x005b
                r15 = 46
                if (r7 == r15) goto L_0x005b
                if (r7 != r12) goto L_0x005e
                goto L_0x005f
            L_0x005b:
                int r2 = r2 + 1
                goto L_0x0036
            L_0x005e:
                r2 = -1
            L_0x005f:
                if (r2 == r14) goto L_0x008c
                r3 = 1
                java.lang.String r5 = "https:"
                r6 = 0
                r7 = 6
                r2 = r9
                r4 = r10
                boolean r2 = r2.regionMatches(r3, r4, r5, r6, r7)
                if (r2 == 0) goto L_0x0075
                java.lang.String r2 = "https"
                r0.f356a = r2
                int r10 = r10 + 6
                goto L_0x0092
            L_0x0075:
                r3 = 1
                java.lang.String r5 = "http:"
                r6 = 0
                r7 = 5
                r2 = r9
                r4 = r10
                boolean r2 = r2.regionMatches(r3, r4, r5, r6, r7)
                if (r2 == 0) goto L_0x0089
                java.lang.String r2 = "http"
                r0.f356a = r2
                int r10 = r10 + 5
                goto L_0x0092
            L_0x0089:
                b.v$a$a r1 = b.v.a.C0005a.UNSUPPORTED_SCHEME
                return r1
            L_0x008c:
                if (r1 == 0) goto L_0x020e
                java.lang.String r2 = r1.k
                r0.f356a = r2
            L_0x0092:
                r2 = r10
                r3 = 0
            L_0x0094:
                r15 = 47
                r7 = 92
                if (r2 >= r11) goto L_0x00a7
                char r4 = r9.charAt(r2)
                if (r4 == r7) goto L_0x00a2
                if (r4 != r15) goto L_0x00a7
            L_0x00a2:
                int r3 = r3 + 1
                int r2 = r2 + 1
                goto L_0x0094
            L_0x00a7:
                r6 = 35
                r16 = 1
                if (r3 >= r13) goto L_0x00ee
                if (r1 == 0) goto L_0x00ee
                java.lang.String r2 = r1.k
                java.lang.String r4 = r0.f356a
                boolean r2 = r2.equals(r4)
                if (r2 != 0) goto L_0x00ba
                goto L_0x00ee
            L_0x00ba:
                java.lang.String r2 = r23.c()
                r0.f357b = r2
                java.lang.String r2 = r23.d()
                r0.f358c = r2
                java.lang.String r2 = r1.l
                r0.d = r2
                int r2 = r1.m
                r0.e = r2
                java.util.List<java.lang.String> r2 = r0.f
                r2.clear()
                java.util.List<java.lang.String> r2 = r0.f
                java.util.List r3 = r23.f()
                r2.addAll(r3)
                if (r10 == r11) goto L_0x00e4
                char r2 = r9.charAt(r10)
                if (r2 != r6) goto L_0x00eb
            L_0x00e4:
                java.lang.String r1 = r23.g()
                r0.a((java.lang.String) r1)
            L_0x00eb:
                r15 = r10
                goto L_0x01c3
            L_0x00ee:
                int r10 = r10 + r3
                r2 = r10
                r10 = 0
                r13 = 0
            L_0x00f2:
                java.lang.String r1 = "@/\\?#"
                int r8 = b.a.c.a((java.lang.String) r9, (int) r2, (int) r11, (java.lang.String) r1)
                if (r8 == r11) goto L_0x00ff
                char r1 = r9.charAt(r8)
                goto L_0x0100
            L_0x00ff:
                r1 = -1
            L_0x0100:
                if (r1 == r14) goto L_0x0192
                if (r1 == r6) goto L_0x0192
                if (r1 == r15) goto L_0x0192
                if (r1 == r7) goto L_0x0192
                switch(r1) {
                    case 63: goto L_0x0192;
                    case 64: goto L_0x010c;
                    default: goto L_0x010b;
                }
            L_0x010b:
                goto L_0x00f2
            L_0x010c:
                if (r10 != 0) goto L_0x015f
                int r5 = b.a.c.a((java.lang.String) r9, (int) r2, (int) r8, (char) r12)
                java.lang.String r4 = " \"':;<=>@[]^`{}|/\\?#"
                r17 = 1
                r18 = 0
                r19 = 0
                r20 = 1
                r1 = r9
                r3 = r5
                r12 = r5
                r5 = r17
                r15 = 35
                r6 = r18
                r17 = 92
                r7 = r19
                r15 = r8
                r8 = r20
                java.lang.String r1 = b.v.a(r1, r2, r3, r4, r5, r6, r7, r8)
                if (r13 == 0) goto L_0x0148
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = r0.f357b
                r2.append(r3)
                java.lang.String r3 = "%40"
                r2.append(r3)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
            L_0x0148:
                r0.f357b = r1
                if (r12 == r15) goto L_0x015d
                int r2 = r12 + 1
                java.lang.String r4 = " \"':;<=>@[]^`{}|/\\?#"
                r5 = 1
                r6 = 0
                r7 = 0
                r8 = 1
                r1 = r9
                r3 = r15
                java.lang.String r1 = b.v.a(r1, r2, r3, r4, r5, r6, r7, r8)
                r0.f358c = r1
                r10 = 1
            L_0x015d:
                r13 = 1
                goto L_0x0186
            L_0x015f:
                r15 = r8
                r17 = 92
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r1 = r0.f358c
                r12.append(r1)
                java.lang.String r1 = "%40"
                r12.append(r1)
                java.lang.String r4 = " \"':;<=>@[]^`{}|/\\?#"
                r5 = 1
                r6 = 0
                r7 = 0
                r8 = 1
                r1 = r9
                r3 = r15
                java.lang.String r1 = b.v.a(r1, r2, r3, r4, r5, r6, r7, r8)
                r12.append(r1)
                java.lang.String r1 = r12.toString()
                r0.f358c = r1
            L_0x0186:
                int r2 = r15 + 1
                r6 = 35
                r7 = 92
                r12 = 58
                r15 = 47
                goto L_0x00f2
            L_0x0192:
                r15 = r8
                int r1 = e(r9, r2, r15)
                int r3 = r1 + 1
                if (r3 >= r15) goto L_0x01ae
                java.lang.String r1 = a(r9, r2, r1)
                r0.d = r1
                int r1 = g(r9, r3, r15)
                r0.e = r1
                int r1 = r0.e
                if (r1 != r14) goto L_0x01bc
                b.v$a$a r1 = b.v.a.C0005a.INVALID_PORT
                return r1
            L_0x01ae:
                java.lang.String r1 = a(r9, r2, r1)
                r0.d = r1
                java.lang.String r1 = r0.f356a
                int r1 = b.v.a((java.lang.String) r1)
                r0.e = r1
            L_0x01bc:
                java.lang.String r1 = r0.d
                if (r1 != 0) goto L_0x01c3
                b.v$a$a r1 = b.v.a.C0005a.INVALID_HOST
                return r1
            L_0x01c3:
                java.lang.String r1 = "?#"
                int r1 = b.a.c.a((java.lang.String) r9, (int) r15, (int) r11, (java.lang.String) r1)
                r0.b(r9, r15, r1)
                if (r1 >= r11) goto L_0x01f1
                char r2 = r9.charAt(r1)
                r3 = 63
                if (r2 != r3) goto L_0x01f1
                r2 = 35
                int r10 = b.a.c.a((java.lang.String) r9, (int) r1, (int) r11, (char) r2)
                int r2 = r1 + 1
                java.lang.String r4 = " \"'<>#"
                r5 = 1
                r6 = 0
                r7 = 1
                r8 = 1
                r1 = r9
                r3 = r10
                java.lang.String r1 = b.v.a(r1, r2, r3, r4, r5, r6, r7, r8)
                java.util.List r1 = b.v.b((java.lang.String) r1)
                r0.g = r1
                r1 = r10
            L_0x01f1:
                if (r1 >= r11) goto L_0x020b
                char r2 = r9.charAt(r1)
                r3 = 35
                if (r2 != r3) goto L_0x020b
                int r2 = r1 + 1
                java.lang.String r4 = ""
                r5 = 1
                r6 = 0
                r7 = 0
                r8 = 0
                r1 = r9
                r3 = r11
                java.lang.String r1 = b.v.a(r1, r2, r3, r4, r5, r6, r7, r8)
                r0.h = r1
            L_0x020b:
                b.v$a$a r1 = b.v.a.C0005a.SUCCESS
                return r1
            L_0x020e:
                b.v$a$a r1 = b.v.a.C0005a.MISSING_SCHEME
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: b.v.a.a(b.v, java.lang.String):b.v$a$a");
        }

        public final a a(@Nullable String str) {
            this.g = str != null ? v.b(v.a(str, v.e, true, false, true, true)) : null;
            return this;
        }

        public final v b() {
            if (this.f356a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.d != null) {
                return new v(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f356a);
            sb.append("://");
            if (!this.f357b.isEmpty() || !this.f358c.isEmpty()) {
                sb.append(this.f357b);
                if (!this.f358c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f358c);
                }
                sb.append('@');
            }
            if (this.d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.d);
                sb.append(']');
            } else {
                sb.append(this.d);
            }
            int a2 = a();
            if (a2 != v.a(this.f356a)) {
                sb.append(':');
                sb.append(a2);
            }
            v.a(sb, this.f);
            if (this.g != null) {
                sb.append('?');
                v.b(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }
    }

    v(a aVar) {
        this.k = aVar.f356a;
        this.p = a(aVar.f357b, false);
        this.q = a(aVar.f358c, false);
        this.l = aVar.d;
        this.m = aVar.a();
        this.r = a(aVar.f, false);
        String str = null;
        this.n = aVar.g != null ? a(aVar.g, true) : null;
        this.s = aVar.h != null ? a(aVar.h, false) : str;
        this.t = aVar.toString();
    }

    static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    public static int a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    @Nullable
    private static v a(URI uri) {
        return d(uri.toString());
    }

    @Nullable
    public static v a(URL url) {
        return d(url.toString());
    }

    private String a(int i2) {
        if (this.n != null) {
            return this.n.get(i2 * 2);
        }
        throw new IndexOutOfBoundsException();
    }

    static String a(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        String str3 = str;
        int i4 = i3;
        String str4 = str2;
        int i5 = i2;
        while (i5 < i4) {
            int codePointAt = str3.codePointAt(i5);
            int i6 = 43;
            if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str4.indexOf(codePointAt) != -1 || ((codePointAt == 37 && (!z || (z2 && !a(str3, i5, i4)))) || (codePointAt == 43 && z3)))) {
                c.c cVar = new c.c();
                cVar.b(str3, i2, i5);
                c.c cVar2 = null;
                while (i5 < i4) {
                    int codePointAt2 = str3.codePointAt(i5);
                    if (!z || !(codePointAt2 == 9 || codePointAt2 == 10 || codePointAt2 == 12 || codePointAt2 == 13)) {
                        if (codePointAt2 != i6 || !z3) {
                            if (codePointAt2 >= 32 && codePointAt2 != 127 && (codePointAt2 < 128 || !z4)) {
                                if (str4.indexOf(codePointAt2) == -1 && (codePointAt2 != 37 || (z && (!z2 || a(str3, i5, i4))))) {
                                    cVar.m(codePointAt2);
                                    i5 += Character.charCount(codePointAt2);
                                    i6 = 43;
                                }
                            }
                            if (cVar2 == null) {
                                cVar2 = new c.c();
                            }
                            cVar2.m(codePointAt2);
                            while (!cVar2.d()) {
                                byte g2 = cVar2.g() & 255;
                                cVar.l(37);
                                cVar.l((int) o[(g2 >> 4) & 15]);
                                cVar.l((int) o[g2 & bg.m]);
                            }
                            i5 += Character.charCount(codePointAt2);
                            i6 = 43;
                        } else {
                            cVar.b(z ? Marker.ANY_NON_NULL_MARKER : "%2B");
                        }
                    }
                    i5 += Character.charCount(codePointAt2);
                    i6 = 43;
                }
                return cVar.q();
            }
            i5 += Character.charCount(codePointAt);
        }
        int i7 = i2;
        return str.substring(i2, i3);
    }

    static String a(String str, int i2, int i3, boolean z) {
        int i4;
        int i5 = i2;
        while (i5 < i3) {
            char charAt = str.charAt(i5);
            if (charAt == '%' || (charAt == '+' && z)) {
                c.c cVar = new c.c();
                cVar.b(str, i2, i5);
                while (i5 < i3) {
                    int codePointAt = str.codePointAt(i5);
                    if (codePointAt == 37 && (i4 = i5 + 2) < i3) {
                        int a2 = a(str.charAt(i5 + 1));
                        int a3 = a(str.charAt(i4));
                        if (!(a2 == -1 || a3 == -1)) {
                            cVar.l((a2 << 4) + a3);
                            i5 = i4;
                            i5 += Character.charCount(codePointAt);
                        }
                    } else if (codePointAt == 43 && z) {
                        cVar.l(32);
                        i5 += Character.charCount(codePointAt);
                    }
                    cVar.m(codePointAt);
                    i5 += Character.charCount(codePointAt);
                }
                return cVar.q();
            }
            i5++;
        }
        return str.substring(i2, i3);
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4);
    }

    static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private static List<String> a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = list.get(i2);
            arrayList.add(str != null ? a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static void a(c.c cVar, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        c.c cVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt == 43 && z3) {
                    cVar.b(z ? Marker.ANY_NON_NULL_MARKER : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !a(str, i2, i3)))))) {
                    if (cVar2 == null) {
                        cVar2 = new c.c();
                    }
                    cVar2.m(codePointAt);
                    while (!cVar2.d()) {
                        byte g2 = cVar2.g() & 255;
                        cVar.l(37);
                        cVar.l((int) o[(g2 >> 4) & 15]);
                        cVar.l((int) o[g2 & bg.m]);
                    }
                } else {
                    cVar.m(codePointAt);
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    private static void a(c.c cVar, String str, int i2, int i3, boolean z) {
        int i4;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt == 37 && (i4 = i2 + 2) < i3) {
                int a2 = a(str.charAt(i2 + 1));
                int a3 = a(str.charAt(i4));
                if (!(a2 == -1 || a3 == -1)) {
                    cVar.l((a2 << 4) + a3);
                    i2 = i4;
                    i2 += Character.charCount(codePointAt);
                }
            } else if (codePointAt == 43 && z) {
                cVar.l(32);
                i2 += Character.charCount(codePointAt);
            }
            cVar.m(codePointAt);
            i2 += Character.charCount(codePointAt);
        }
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb.append(list.get(i2));
        }
    }

    private static boolean a(String str, int i2, int i3) {
        int i4 = i2 + 2;
        return i4 < i3 && str.charAt(i2) == '%' && a(str.charAt(i2 + 1)) != -1 && a(str.charAt(i4)) != -1;
    }

    private String b(int i2) {
        if (this.n != null) {
            return this.n.get((i2 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    static List<String> b(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int indexOf = str.indexOf(38, i2);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i2);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i2, indexOf));
                str2 = null;
            } else {
                arrayList.add(str.substring(i2, indexOf2));
                str2 = str.substring(indexOf2 + 1, indexOf);
            }
            arrayList.add(str2);
            i2 = indexOf + 1;
        }
        return arrayList;
    }

    public static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    @Nullable
    public static v d(String str) {
        a aVar = new a();
        if (aVar.a((v) null, str) == a.C0005a.SUCCESS) {
            return aVar.b();
        }
        return null;
    }

    static v e(String str) throws MalformedURLException, UnknownHostException {
        a aVar = new a();
        a.C0005a a2 = aVar.a((v) null, str);
        switch (a2) {
            case SUCCESS:
                return aVar.b();
            case INVALID_HOST:
                throw new UnknownHostException("Invalid host: " + str);
            default:
                throw new MalformedURLException("Invalid URL: " + a2 + " for " + str);
        }
    }

    @Nullable
    private String f(String str) {
        if (this.n == null) {
            return null;
        }
        int size = this.n.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            if (str.equals(this.n.get(i2))) {
                return this.n.get(i2 + 1);
            }
        }
        return null;
    }

    private List<String> g(String str) {
        if (this.n == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = this.n.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            if (str.equals(this.n.get(i2))) {
                arrayList.add(this.n.get(i2 + 1));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Nullable
    private v h(String str) {
        a c2 = c(str);
        if (c2 != null) {
            return c2.b();
        }
        return null;
    }

    private URL i() {
        try {
            return new URL(this.t);
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }

    private String j() {
        return this.k;
    }

    private String k() {
        return this.p;
    }

    private String l() {
        return this.q;
    }

    private String m() {
        return this.l;
    }

    private int n() {
        return this.m;
    }

    private int o() {
        return this.r.size();
    }

    private List<String> p() {
        return this.r;
    }

    @Nullable
    private String q() {
        if (this.n == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        b(sb, this.n);
        return sb.toString();
    }

    private int r() {
        if (this.n != null) {
            return this.n.size() / 2;
        }
        return 0;
    }

    private Set<String> s() {
        if (this.n == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = this.n.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            linkedHashSet.add(this.n.get(i2));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    @Nullable
    private String t() {
        if (this.s == null) {
            return null;
        }
        return this.t.substring(this.t.indexOf(35) + 1);
    }

    @Nullable
    private String u() {
        return this.s;
    }

    private a v() {
        a aVar = new a();
        aVar.f356a = this.k;
        aVar.f357b = c();
        aVar.f358c = d();
        aVar.d = this.l;
        aVar.e = this.m != a(this.k) ? this.m : -1;
        aVar.f.clear();
        aVar.f.addAll(f());
        aVar.a(g());
        aVar.h = this.s == null ? null : this.t.substring(this.t.indexOf(35) + 1);
        return aVar;
    }

    @Nullable
    private String w() {
        if (c.c(this.l)) {
            return null;
        }
        return b.a.i.a.a().a(this.l);
    }

    public final URI a() {
        a aVar = new a();
        aVar.f356a = this.k;
        aVar.f357b = c();
        aVar.f358c = d();
        aVar.d = this.l;
        aVar.e = this.m != a(this.k) ? this.m : -1;
        aVar.f.clear();
        aVar.f.addAll(f());
        aVar.a(g());
        aVar.h = this.s == null ? null : this.t.substring(this.t.indexOf(35) + 1);
        int size = aVar.f.size();
        for (int i2 = 0; i2 < size; i2++) {
            aVar.f.set(i2, a(aVar.f.get(i2), d, true, true, false, true));
        }
        if (aVar.g != null) {
            int size2 = aVar.g.size();
            for (int i3 = 0; i3 < size2; i3++) {
                String str = aVar.g.get(i3);
                if (str != null) {
                    aVar.g.set(i3, a(str, g, true, true, true, true));
                }
            }
        }
        if (aVar.h != null) {
            aVar.h = a(aVar.h, j, true, true, false, false);
        }
        String aVar2 = aVar.toString();
        try {
            return new URI(aVar2);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(aVar2.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public final boolean b() {
        return this.k.equals("https");
    }

    @Nullable
    public final a c(String str) {
        a aVar = new a();
        if (aVar.a(this, str) == a.C0005a.SUCCESS) {
            return aVar;
        }
        return null;
    }

    public final String c() {
        if (this.p.isEmpty()) {
            return "";
        }
        int length = this.k.length() + 3;
        return this.t.substring(length, c.a(this.t, length, this.t.length(), ":@"));
    }

    public final String d() {
        if (this.q.isEmpty()) {
            return "";
        }
        int indexOf = this.t.indexOf(64);
        return this.t.substring(this.t.indexOf(58, this.k.length() + 3) + 1, indexOf);
    }

    public final String e() {
        int indexOf = this.t.indexOf(47, this.k.length() + 3);
        return this.t.substring(indexOf, c.a(this.t, indexOf, this.t.length(), "?#"));
    }

    public final boolean equals(@Nullable Object obj) {
        return (obj instanceof v) && ((v) obj).t.equals(this.t);
    }

    public final List<String> f() {
        int indexOf = this.t.indexOf(47, this.k.length() + 3);
        int a2 = c.a(this.t, indexOf, this.t.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i2 = indexOf + 1;
            int a3 = c.a(this.t, i2, a2, (char) IOUtils.DIR_SEPARATOR_UNIX);
            arrayList.add(this.t.substring(i2, a3));
            indexOf = a3;
        }
        return arrayList;
    }

    @Nullable
    public final String g() {
        if (this.n == null) {
            return null;
        }
        int indexOf = this.t.indexOf(63) + 1;
        return this.t.substring(indexOf, c.a(this.t, indexOf + 1, this.t.length(), '#'));
    }

    public final String h() {
        a c2 = c("/...");
        c2.f357b = a("", " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        c2.f358c = a("", " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        return c2.b().toString();
    }

    public final int hashCode() {
        return this.t.hashCode();
    }

    public final String toString() {
        return this.t;
    }
}
