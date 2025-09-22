package com.cyjh.common.util;

import android.widget.Toast;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    private static String f1785a;

    /* renamed from: b  reason: collision with root package name */
    private static Toast f1786b;

    /* renamed from: c  reason: collision with root package name */
    private static long f1787c;
    private static long d;

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002d, code lost:
        if ((d - f1787c) > 0) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r4, java.lang.String r5) {
        /*
            android.widget.Toast r0 = f1786b
            if (r0 != 0) goto L_0x0015
            r0 = 0
            android.widget.Toast r4 = android.widget.Toast.makeText(r4, r5, r0)
            f1786b = r4
            r4.show()
            long r4 = java.lang.System.currentTimeMillis()
            f1787c = r4
            goto L_0x003c
        L_0x0015:
            long r0 = java.lang.System.currentTimeMillis()
            d = r0
            java.lang.String r4 = f1785a
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x0030
            long r4 = d
            long r0 = f1787c
            long r2 = r4 - r0
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x003c
            goto L_0x0037
        L_0x0030:
            f1785a = r5
            android.widget.Toast r4 = f1786b
            r4.setText(r5)
        L_0x0037:
            android.widget.Toast r4 = f1786b
            r4.show()
        L_0x003c:
            long r4 = d
            f1787c = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.common.util.w.a(android.content.Context, java.lang.String):void");
    }
}
