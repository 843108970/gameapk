package com.google.a.g;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

public final class b extends s {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f3190a = {'A', 'B', 'C', 'D'};

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f3191b = {'T', 'N', '*', 'E'};

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f3192c = {IOUtils.DIR_SEPARATOR_UNIX, ':', '+', FilenameUtils.EXTENSION_SEPARATOR};
    private static final char d = f3190a[0];

    /* JADX WARNING: Removed duplicated region for block: B:19:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean[] a(java.lang.String r11) {
        /*
            r10 = this;
            int r0 = r11.length()
            r1 = 0
            r2 = 1
            r3 = 2
            if (r0 >= r3) goto L_0x0020
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x000e:
            char r3 = d
            r0.append(r3)
            r0.append(r11)
            char r11 = d
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            goto L_0x0081
        L_0x0020:
            char r0 = r11.charAt(r1)
            char r0 = java.lang.Character.toUpperCase(r0)
            int r3 = r11.length()
            int r3 = r3 - r2
            char r3 = r11.charAt(r3)
            char r3 = java.lang.Character.toUpperCase(r3)
            char[] r4 = f3190a
            boolean r4 = com.google.a.g.a.a(r4, r0)
            char[] r5 = f3190a
            boolean r5 = com.google.a.g.a.a(r5, r3)
            char[] r6 = f3191b
            boolean r0 = com.google.a.g.a.a(r6, r0)
            char[] r6 = f3191b
            boolean r3 = com.google.a.g.a.a(r6, r3)
            if (r4 == 0) goto L_0x0061
            if (r5 != 0) goto L_0x0081
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Invalid start/end guards: "
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        L_0x0061:
            if (r0 == 0) goto L_0x0075
            if (r3 != 0) goto L_0x0081
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Invalid start/end guards: "
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        L_0x0075:
            if (r5 != 0) goto L_0x0158
            if (r3 == 0) goto L_0x007b
            goto L_0x0158
        L_0x007b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x000e
        L_0x0081:
            r0 = 20
            r0 = 1
            r3 = 20
        L_0x0086:
            int r4 = r11.length()
            int r4 = r4 - r2
            if (r0 >= r4) goto L_0x00d9
            char r4 = r11.charAt(r0)
            boolean r4 = java.lang.Character.isDigit(r4)
            if (r4 != 0) goto L_0x00d4
            char r4 = r11.charAt(r0)
            r5 = 45
            if (r4 == r5) goto L_0x00d4
            char r4 = r11.charAt(r0)
            r5 = 36
            if (r4 != r5) goto L_0x00a8
            goto L_0x00d4
        L_0x00a8:
            char[] r4 = f3192c
            char r5 = r11.charAt(r0)
            boolean r4 = com.google.a.g.a.a(r4, r5)
            if (r4 == 0) goto L_0x00b7
            int r3 = r3 + 10
            goto L_0x00d6
        L_0x00b7:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Cannot encode : '"
            r2.<init>(r3)
            char r11 = r11.charAt(r0)
            r2.append(r11)
            r11 = 39
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            r1.<init>(r11)
            throw r1
        L_0x00d4:
            int r3 = r3 + 9
        L_0x00d6:
            int r0 = r0 + 1
            goto L_0x0086
        L_0x00d9:
            int r0 = r11.length()
            int r0 = r0 - r2
            int r3 = r3 + r0
            boolean[] r0 = new boolean[r3]
            r3 = 0
            r4 = 0
        L_0x00e3:
            int r5 = r11.length()
            if (r3 >= r5) goto L_0x0157
            char r5 = r11.charAt(r3)
            char r5 = java.lang.Character.toUpperCase(r5)
            if (r3 == 0) goto L_0x00fa
            int r6 = r11.length()
            int r6 = r6 - r2
            if (r3 != r6) goto L_0x0116
        L_0x00fa:
            r6 = 42
            if (r5 == r6) goto L_0x0114
            r6 = 69
            if (r5 == r6) goto L_0x0111
            r6 = 78
            if (r5 == r6) goto L_0x010e
            r6 = 84
            if (r5 == r6) goto L_0x010b
            goto L_0x0116
        L_0x010b:
            r5 = 65
            goto L_0x0116
        L_0x010e:
            r5 = 66
            goto L_0x0116
        L_0x0111:
            r5 = 68
            goto L_0x0116
        L_0x0114:
            r5 = 67
        L_0x0116:
            r6 = 0
        L_0x0117:
            char[] r7 = com.google.a.g.a.f3148a
            int r7 = r7.length
            if (r6 >= r7) goto L_0x012a
            char[] r7 = com.google.a.g.a.f3148a
            char r7 = r7[r6]
            if (r5 != r7) goto L_0x0127
            int[] r5 = com.google.a.g.a.f3149b
            r5 = r5[r6]
            goto L_0x012b
        L_0x0127:
            int r6 = r6 + 1
            goto L_0x0117
        L_0x012a:
            r5 = 0
        L_0x012b:
            r6 = r4
            r4 = 0
            r7 = 1
        L_0x012e:
            r8 = 0
        L_0x012f:
            r9 = 7
            if (r4 >= r9) goto L_0x0148
            r0[r6] = r7
            int r6 = r6 + 1
            int r9 = 6 - r4
            int r9 = r5 >> r9
            r9 = r9 & r2
            if (r9 == 0) goto L_0x0143
            if (r8 != r2) goto L_0x0140
            goto L_0x0143
        L_0x0140:
            int r8 = r8 + 1
            goto L_0x012f
        L_0x0143:
            r7 = r7 ^ 1
            int r4 = r4 + 1
            goto L_0x012e
        L_0x0148:
            int r4 = r11.length()
            int r4 = r4 - r2
            if (r3 >= r4) goto L_0x0153
            r0[r6] = r1
            int r6 = r6 + 1
        L_0x0153:
            r4 = r6
            int r3 = r3 + 1
            goto L_0x00e3
        L_0x0157:
            return r0
        L_0x0158:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Invalid start/end guards: "
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.g.b.a(java.lang.String):boolean[]");
    }
}
