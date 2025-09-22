package com.b.a;

import com.b.a.a.c;
import com.b.b.f;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public final class ad {

    /* renamed from: a  reason: collision with root package name */
    String f752a;

    /* renamed from: b  reason: collision with root package name */
    String f753b = "";

    /* renamed from: c  reason: collision with root package name */
    String f754c = "";
    String d;
    int e = -1;
    final List<String> f = new ArrayList();
    List<String> g;
    String h;

    public ad() {
        this.f.add("");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e4 A[SYNTHETIC] */
    private void a(java.lang.String r12, int r13, int r14) {
        /*
            r11 = this;
            if (r13 != r14) goto L_0x0003
            return
        L_0x0003:
            char r0 = r12.charAt(r13)
            r1 = 47
            r2 = 1
            if (r0 == r1) goto L_0x0020
            r1 = 92
            if (r0 != r1) goto L_0x0011
            goto L_0x0020
        L_0x0011:
            java.util.List<java.lang.String> r0 = r11.f
            java.util.List<java.lang.String> r1 = r11.f
            int r1 = r1.size()
            int r1 = r1 - r2
            java.lang.String r3 = ""
            r0.set(r1, r3)
            goto L_0x002e
        L_0x0020:
            java.util.List<java.lang.String> r0 = r11.f
            r0.clear()
            java.util.List<java.lang.String> r0 = r11.f
            java.lang.String r1 = ""
            r0.add(r1)
        L_0x002c:
            int r13 = r13 + 1
        L_0x002e:
            r4 = r13
            if (r4 >= r14) goto L_0x00e4
            java.lang.String r13 = "/\\"
            int r13 = com.b.a.a.c.a((java.lang.String) r12, (int) r4, (int) r14, (java.lang.String) r13)
            r0 = 0
            if (r13 >= r14) goto L_0x003c
            r1 = 1
            goto L_0x003d
        L_0x003c:
            r1 = 0
        L_0x003d:
            java.lang.String r6 = " \"<>^`{}|/\\?#"
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 1
            r3 = r12
            r5 = r13
            java.lang.String r3 = com.b.a.ac.a(r3, r4, r5, r6, r7, r8, r9, r10)
            java.lang.String r4 = "."
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x005c
            java.lang.String r4 = "%2e"
            boolean r4 = r3.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x005a
            goto L_0x005c
        L_0x005a:
            r4 = 0
            goto L_0x005d
        L_0x005c:
            r4 = 1
        L_0x005d:
            if (r4 != 0) goto L_0x00e0
            java.lang.String r4 = ".."
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x007f
            java.lang.String r4 = "%2e."
            boolean r4 = r3.equalsIgnoreCase(r4)
            if (r4 != 0) goto L_0x007f
            java.lang.String r4 = ".%2e"
            boolean r4 = r3.equalsIgnoreCase(r4)
            if (r4 != 0) goto L_0x007f
            java.lang.String r4 = "%2e%2e"
            boolean r4 = r3.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0080
        L_0x007f:
            r0 = 1
        L_0x0080:
            if (r0 == 0) goto L_0x00b6
            java.util.List<java.lang.String> r0 = r11.f
            java.util.List<java.lang.String> r3 = r11.f
            int r3 = r3.size()
            int r3 = r3 - r2
            java.lang.Object r0 = r0.remove(r3)
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x00ae
            java.util.List<java.lang.String> r0 = r11.f
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00ae
            java.util.List<java.lang.String> r0 = r11.f
            java.util.List<java.lang.String> r3 = r11.f
            int r3 = r3.size()
            int r3 = r3 - r2
            java.lang.String r4 = ""
            r0.set(r3, r4)
            goto L_0x00e0
        L_0x00ae:
            java.util.List<java.lang.String> r0 = r11.f
            java.lang.String r3 = ""
            r0.add(r3)
            goto L_0x00e0
        L_0x00b6:
            java.util.List<java.lang.String> r0 = r11.f
            java.util.List<java.lang.String> r4 = r11.f
            int r4 = r4.size()
            int r4 = r4 - r2
            java.lang.Object r0 = r0.get(r4)
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x00d8
            java.util.List<java.lang.String> r0 = r11.f
            java.util.List<java.lang.String> r4 = r11.f
            int r4 = r4.size()
            int r4 = r4 - r2
            r0.set(r4, r3)
            goto L_0x00dd
        L_0x00d8:
            java.util.List<java.lang.String> r0 = r11.f
            r0.add(r3)
        L_0x00dd:
            if (r1 == 0) goto L_0x00e0
            goto L_0x00ae
        L_0x00e0:
            if (r1 == 0) goto L_0x002e
            goto L_0x002c
        L_0x00e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.ad.a(java.lang.String, int, int):void");
    }

    private static int b(String str, int i, int i2) {
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

    private static String c(String str, int i, int i2) {
        int i3 = 0;
        String a2 = ac.a(str, i, i2, false);
        if (!a2.contains(":")) {
            return c.a(a2);
        }
        InetAddress d2 = (!a2.startsWith("[") || !a2.endsWith("]")) ? d(a2, 0, a2.length()) : d(a2, 1, a2.length() - 1);
        if (d2 == null) {
            return null;
        }
        byte[] address = d2.getAddress();
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
                if (i8 > i5) {
                    i6 = i4;
                    i5 = i8;
                }
                i4 = i7 + 2;
            }
            f fVar = new f();
            while (i3 < address.length) {
                if (i3 == i6) {
                    fVar.h(58);
                    i3 += i5;
                    if (i3 == 16) {
                        fVar.h(58);
                    }
                } else {
                    if (i3 > 0) {
                        fVar.h(58);
                    }
                    fVar.i((long) (((address[i3] & 255) << 8) | (address[i3 + 1] & 255)));
                    i3 += 2;
                }
            }
            return fVar.l();
        }
        throw new AssertionError();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0097, code lost:
        r5 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.net.InetAddress d(java.lang.String r17, int r18, int r19) {
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
            int r4 = com.b.a.ac.a((char) r4)
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
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.ad.d(java.lang.String, int, int):java.net.InetAddress");
    }

    private static int e(String str, int i, int i2) {
        try {
            int parseInt = Integer.parseInt(ac.a(str, i, i2, "", false, false, false, true));
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        } catch (NumberFormatException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.e != -1 ? this.e : ac.a(this.f752a);
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
    public final int a(com.b.a.ac r23, java.lang.String r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r9 = r24
            int r2 = r24.length()
            r8 = 0
            int r10 = com.b.a.a.c.a((java.lang.String) r9, (int) r8, (int) r2)
            int r2 = r24.length()
            int r11 = com.b.a.a.c.b(r9, r10, r2)
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
            r0.f752a = r2
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
            r0.f752a = r2
            int r10 = r10 + 5
            goto L_0x0092
        L_0x0089:
            int r1 = com.b.a.ae.f757c
            return r1
        L_0x008c:
            if (r1 == 0) goto L_0x020e
            java.lang.String r2 = r1.f749a
            r0.f752a = r2
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
            java.lang.String r2 = r1.f749a
            java.lang.String r4 = r0.f752a
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x00ba
            goto L_0x00ee
        L_0x00ba:
            java.lang.String r2 = r23.d()
            r0.f753b = r2
            java.lang.String r2 = r23.e()
            r0.f754c = r2
            java.lang.String r2 = r1.f750b
            r0.d = r2
            int r2 = r1.f751c
            r0.e = r2
            java.util.List<java.lang.String> r2 = r0.f
            r2.clear()
            java.util.List<java.lang.String> r2 = r0.f
            java.util.List r3 = r23.i()
            r2.addAll(r3)
            if (r10 == r11) goto L_0x00e4
            char r2 = r9.charAt(r10)
            if (r2 != r6) goto L_0x00eb
        L_0x00e4:
            java.lang.String r1 = r23.j()
            r0.b(r1)
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
            int r8 = com.b.a.a.c.a((java.lang.String) r9, (int) r2, (int) r11, (java.lang.String) r1)
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
            int r5 = com.b.a.a.c.a((java.lang.String) r9, (int) r2, (int) r8, (char) r12)
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
            java.lang.String r1 = com.b.a.ac.a(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r13 == 0) goto L_0x0148
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r0.f753b
            r2.append(r3)
            java.lang.String r3 = "%40"
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
        L_0x0148:
            r0.f753b = r1
            if (r12 == r15) goto L_0x015d
            int r2 = r12 + 1
            java.lang.String r4 = " \"':;<=>@[]^`{}|/\\?#"
            r5 = 1
            r6 = 0
            r7 = 0
            r8 = 1
            r1 = r9
            r3 = r15
            java.lang.String r1 = com.b.a.ac.a(r1, r2, r3, r4, r5, r6, r7, r8)
            r0.f754c = r1
            r10 = 1
        L_0x015d:
            r13 = 1
            goto L_0x0186
        L_0x015f:
            r15 = r8
            r17 = 92
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r1 = r0.f754c
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
            java.lang.String r1 = com.b.a.ac.a(r1, r2, r3, r4, r5, r6, r7, r8)
            r12.append(r1)
            java.lang.String r1 = r12.toString()
            r0.f754c = r1
        L_0x0186:
            int r2 = r15 + 1
            r6 = 35
            r7 = 92
            r12 = 58
            r15 = 47
            goto L_0x00f2
        L_0x0192:
            r15 = r8
            int r1 = b(r9, r2, r15)
            int r3 = r1 + 1
            if (r3 >= r15) goto L_0x01ae
            java.lang.String r1 = c(r9, r2, r1)
            r0.d = r1
            int r1 = e(r9, r3, r15)
            r0.e = r1
            int r1 = r0.e
            if (r1 != r14) goto L_0x01bc
            int r1 = com.b.a.ae.d
            return r1
        L_0x01ae:
            java.lang.String r1 = c(r9, r2, r1)
            r0.d = r1
            java.lang.String r1 = r0.f752a
            int r1 = com.b.a.ac.a((java.lang.String) r1)
            r0.e = r1
        L_0x01bc:
            java.lang.String r1 = r0.d
            if (r1 != 0) goto L_0x01c3
            int r1 = com.b.a.ae.e
            return r1
        L_0x01c3:
            java.lang.String r1 = "?#"
            int r1 = com.b.a.a.c.a((java.lang.String) r9, (int) r15, (int) r11, (java.lang.String) r1)
            r0.a(r9, r15, r1)
            if (r1 >= r11) goto L_0x01f1
            char r2 = r9.charAt(r1)
            r3 = 63
            if (r2 != r3) goto L_0x01f1
            r2 = 35
            int r10 = com.b.a.a.c.a((java.lang.String) r9, (int) r1, (int) r11, (char) r2)
            int r2 = r1 + 1
            java.lang.String r4 = " \"'<>#"
            r5 = 1
            r6 = 0
            r7 = 1
            r8 = 1
            r1 = r9
            r3 = r10
            java.lang.String r1 = com.b.a.ac.a(r1, r2, r3, r4, r5, r6, r7, r8)
            java.util.List r1 = com.b.a.ac.b(r1)
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
            java.lang.String r1 = com.b.a.ac.a(r1, r2, r3, r4, r5, r6, r7, r8)
            r0.h = r1
        L_0x020b:
            int r1 = com.b.a.ae.f755a
            return r1
        L_0x020e:
            int r1 = com.b.a.ae.f756b
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.ad.a(com.b.a.ac, java.lang.String):int");
    }

    public final ad a(String str) {
        if (str == null) {
            throw new NullPointerException("host == null");
        }
        String c2 = c(str, 0, str.length());
        if (c2 == null) {
            throw new IllegalArgumentException("unexpected host: " + str);
        }
        this.d = c2;
        return this;
    }

    public final ac b() {
        if (this.f752a == null) {
            throw new IllegalStateException("scheme == null");
        } else if (this.d != null) {
            return new ac(this);
        } else {
            throw new IllegalStateException("host == null");
        }
    }

    public final ad b(String str) {
        this.g = str != null ? ac.b(ac.a(str, " \"'<>#", true, false, true, true)) : null;
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f752a);
        sb.append("://");
        if (!this.f753b.isEmpty() || !this.f754c.isEmpty()) {
            sb.append(this.f753b);
            if (!this.f754c.isEmpty()) {
                sb.append(':');
                sb.append(this.f754c);
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
        if (a2 != ac.a(this.f752a)) {
            sb.append(':');
            sb.append(a2);
        }
        ac.a(sb, this.f);
        if (this.g != null) {
            sb.append('?');
            ac.b(sb, this.g);
        }
        if (this.h != null) {
            sb.append('#');
            sb.append(this.h);
        }
        return sb.toString();
    }
}
