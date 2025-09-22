package com.bumptech.glide.c;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.ActivityChooserView;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    static final int f925a = 2;

    /* renamed from: b  reason: collision with root package name */
    static final int f926b = 10;
    private static final String e = "GifHeaderParser";
    private static final int f = 255;
    private static final int g = 44;
    private static final int h = 33;
    private static final int i = 59;
    private static final int j = 249;
    private static final int k = 255;
    private static final int l = 254;
    private static final int m = 1;
    private static final int n = 28;
    private static final int o = 2;
    private static final int p = 1;
    private static final int q = 128;
    private static final int r = 64;
    private static final int s = 7;
    private static final int t = 128;
    private static final int u = 7;
    private static final int v = 256;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f927c;
    public d d;
    private final byte[] w = new byte[256];
    private int x = 0;

    private e a(@Nullable byte[] bArr) {
        if (bArr != null) {
            a(ByteBuffer.wrap(bArr));
            return this;
        }
        this.f927c = null;
        this.d.d = 2;
        return this;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r10) {
        /*
            r9 = this;
            r0 = 0
            r1 = 1
            r2 = 0
        L_0x0003:
            if (r2 != 0) goto L_0x015c
            boolean r3 = r9.p()
            if (r3 != 0) goto L_0x015c
            com.bumptech.glide.c.d r3 = r9.d
            int r3 = r3.e
            if (r3 > r10) goto L_0x015c
            int r3 = r9.n()
            r4 = 33
            if (r3 == r4) goto L_0x00c9
            r4 = 44
            if (r3 == r4) goto L_0x0028
            r4 = 59
            if (r3 == r4) goto L_0x0026
            com.bumptech.glide.c.d r3 = r9.d
            r3.d = r1
            goto L_0x0003
        L_0x0026:
            r2 = 1
            goto L_0x0003
        L_0x0028:
            com.bumptech.glide.c.d r3 = r9.d
            com.bumptech.glide.c.c r3 = r3.f
            if (r3 != 0) goto L_0x0037
            com.bumptech.glide.c.d r3 = r9.d
            com.bumptech.glide.c.c r4 = new com.bumptech.glide.c.c
            r4.<init>()
            r3.f = r4
        L_0x0037:
            com.bumptech.glide.c.d r3 = r9.d
            com.bumptech.glide.c.c r3 = r3.f
            java.nio.ByteBuffer r4 = r9.f927c
            short r4 = r4.getShort()
            r3.e = r4
            com.bumptech.glide.c.d r3 = r9.d
            com.bumptech.glide.c.c r3 = r3.f
            java.nio.ByteBuffer r4 = r9.f927c
            short r4 = r4.getShort()
            r3.f = r4
            com.bumptech.glide.c.d r3 = r9.d
            com.bumptech.glide.c.c r3 = r3.f
            java.nio.ByteBuffer r4 = r9.f927c
            short r4 = r4.getShort()
            r3.g = r4
            com.bumptech.glide.c.d r3 = r9.d
            com.bumptech.glide.c.c r3 = r3.f
            java.nio.ByteBuffer r4 = r9.f927c
            short r4 = r4.getShort()
            r3.h = r4
            int r3 = r9.n()
            r4 = r3 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0071
            r4 = 1
            goto L_0x0072
        L_0x0071:
            r4 = 0
        L_0x0072:
            r5 = 4611686018427387904(0x4000000000000000, double:2.0)
            r7 = r3 & 7
            int r7 = r7 + r1
            double r7 = (double) r7
            double r5 = java.lang.Math.pow(r5, r7)
            int r5 = (int) r5
            com.bumptech.glide.c.d r6 = r9.d
            com.bumptech.glide.c.c r6 = r6.f
            r3 = r3 & 64
            if (r3 == 0) goto L_0x0087
            r3 = 1
            goto L_0x0088
        L_0x0087:
            r3 = 0
        L_0x0088:
            r6.i = r3
            if (r4 == 0) goto L_0x0097
            com.bumptech.glide.c.d r3 = r9.d
            com.bumptech.glide.c.c r3 = r3.f
            int[] r4 = r9.b(r5)
        L_0x0094:
            r3.o = r4
            goto L_0x009d
        L_0x0097:
            com.bumptech.glide.c.d r3 = r9.d
            com.bumptech.glide.c.c r3 = r3.f
            r4 = 0
            goto L_0x0094
        L_0x009d:
            com.bumptech.glide.c.d r3 = r9.d
            com.bumptech.glide.c.c r3 = r3.f
            java.nio.ByteBuffer r4 = r9.f927c
            int r4 = r4.position()
            r3.n = r4
            r9.n()
            r9.l()
            boolean r3 = r9.p()
            if (r3 != 0) goto L_0x0003
            com.bumptech.glide.c.d r3 = r9.d
            int r4 = r3.e
            int r4 = r4 + r1
            r3.e = r4
            com.bumptech.glide.c.d r3 = r9.d
            java.util.List<com.bumptech.glide.c.c> r3 = r3.g
            com.bumptech.glide.c.d r4 = r9.d
            com.bumptech.glide.c.c r4 = r4.f
            r3.add(r4)
            goto L_0x0003
        L_0x00c9:
            int r3 = r9.n()
            if (r3 == r1) goto L_0x00d6
            r4 = 249(0xf9, float:3.49E-43)
            if (r3 == r4) goto L_0x0104
            switch(r3) {
                case 254: goto L_0x00d6;
                case 255: goto L_0x00db;
                default: goto L_0x00d6;
            }
        L_0x00d6:
            r9.l()
            goto L_0x0003
        L_0x00db:
            r9.m()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = 0
        L_0x00e4:
            r5 = 11
            if (r4 >= r5) goto L_0x00f3
            byte[] r5 = r9.w
            byte r5 = r5[r4]
            char r5 = (char) r5
            r3.append(r5)
            int r4 = r4 + 1
            goto L_0x00e4
        L_0x00f3:
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "NETSCAPE2.0"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00d6
            r9.h()
            goto L_0x0003
        L_0x0104:
            com.bumptech.glide.c.d r3 = r9.d
            com.bumptech.glide.c.c r4 = new com.bumptech.glide.c.c
            r4.<init>()
            r3.f = r4
            r9.n()
            int r3 = r9.n()
            com.bumptech.glide.c.d r4 = r9.d
            com.bumptech.glide.c.c r4 = r4.f
            r5 = r3 & 28
            r6 = 2
            int r5 = r5 >> r6
            r4.k = r5
            com.bumptech.glide.c.d r4 = r9.d
            com.bumptech.glide.c.c r4 = r4.f
            int r4 = r4.k
            if (r4 != 0) goto L_0x012c
            com.bumptech.glide.c.d r4 = r9.d
            com.bumptech.glide.c.c r4 = r4.f
            r4.k = r1
        L_0x012c:
            com.bumptech.glide.c.d r4 = r9.d
            com.bumptech.glide.c.c r4 = r4.f
            r3 = r3 & 1
            if (r3 == 0) goto L_0x0136
            r3 = 1
            goto L_0x0137
        L_0x0136:
            r3 = 0
        L_0x0137:
            r4.j = r3
            java.nio.ByteBuffer r3 = r9.f927c
            short r3 = r3.getShort()
            r4 = 10
            if (r3 >= r6) goto L_0x0145
            r3 = 10
        L_0x0145:
            com.bumptech.glide.c.d r5 = r9.d
            com.bumptech.glide.c.c r5 = r5.f
            int r3 = r3 * 10
            r5.m = r3
            com.bumptech.glide.c.d r3 = r9.d
            com.bumptech.glide.c.c r3 = r3.f
            int r4 = r9.n()
            r3.l = r4
            r9.n()
            goto L_0x0003
        L_0x015c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.c.e.a(int):void");
    }

    private void b() {
        this.f927c = null;
        this.d = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    @android.support.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int[] b(int r10) {
        /*
            r9 = this;
            int r0 = r10 * 3
            byte[] r0 = new byte[r0]
            r1 = 0
            java.nio.ByteBuffer r2 = r9.f927c     // Catch:{ BufferUnderflowException -> 0x0036 }
            r2.get(r0)     // Catch:{ BufferUnderflowException -> 0x0036 }
            r2 = 256(0x100, float:3.59E-43)
            int[] r2 = new int[r2]     // Catch:{ BufferUnderflowException -> 0x0036 }
            r1 = 0
            r3 = 0
        L_0x0010:
            if (r1 >= r10) goto L_0x004d
            int r4 = r3 + 1
            byte r3 = r0[r3]     // Catch:{ BufferUnderflowException -> 0x0034 }
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r5 = r4 + 1
            byte r4 = r0[r4]     // Catch:{ BufferUnderflowException -> 0x0034 }
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r6 = r5 + 1
            byte r5 = r0[r5]     // Catch:{ BufferUnderflowException -> 0x0034 }
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r7 = r1 + 1
            r8 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            int r3 = r3 << 16
            r3 = r3 | r8
            int r4 = r4 << 8
            r3 = r3 | r4
            r3 = r3 | r5
            r2[r1] = r3     // Catch:{ BufferUnderflowException -> 0x0034 }
            r3 = r6
            r1 = r7
            goto L_0x0010
        L_0x0034:
            r10 = move-exception
            goto L_0x0038
        L_0x0036:
            r10 = move-exception
            r2 = r1
        L_0x0038:
            java.lang.String r0 = "GifHeaderParser"
            r1 = 3
            boolean r0 = android.util.Log.isLoggable(r0, r1)
            if (r0 == 0) goto L_0x0048
            java.lang.String r0 = "GifHeaderParser"
            java.lang.String r1 = "Format Error Reading Color Table"
            android.util.Log.d(r0, r1, r10)
        L_0x0048:
            com.bumptech.glide.c.d r10 = r9.d
            r0 = 1
            r10.d = r0
        L_0x004d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.c.e.b(int):int[]");
    }

    private void c() {
        this.f927c = null;
        Arrays.fill(this.w, (byte) 0);
        this.d = new d();
        this.x = 0;
    }

    private boolean d() {
        i();
        if (!p()) {
            a(2);
        }
        return this.d.e > 1;
    }

    private void e() {
        a((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    private void f() {
        n();
        int n2 = n();
        this.d.f.k = (n2 & 28) >> 2;
        boolean z = true;
        if (this.d.f.k == 0) {
            this.d.f.k = 1;
        }
        c cVar = this.d.f;
        if ((n2 & 1) == 0) {
            z = false;
        }
        cVar.j = z;
        short s2 = this.f927c.getShort();
        if (s2 < 2) {
            s2 = 10;
        }
        this.d.f.m = s2 * 10;
        this.d.f.l = n();
        n();
    }

    private void g() {
        c cVar;
        int[] iArr;
        this.d.f.e = this.f927c.getShort();
        this.d.f.f = this.f927c.getShort();
        this.d.f.g = this.f927c.getShort();
        this.d.f.h = this.f927c.getShort();
        int n2 = n();
        boolean z = false;
        boolean z2 = (n2 & 128) != 0;
        int pow = (int) Math.pow(2.0d, (double) ((n2 & 7) + 1));
        c cVar2 = this.d.f;
        if ((n2 & 64) != 0) {
            z = true;
        }
        cVar2.i = z;
        if (z2) {
            cVar = this.d.f;
            iArr = b(pow);
        } else {
            cVar = this.d.f;
            iArr = null;
        }
        cVar.o = iArr;
        this.d.f.n = this.f927c.position();
        n();
        l();
        if (!p()) {
            this.d.e++;
            this.d.g.add(this.d.f);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void h() {
        /*
            r3 = this;
        L_0x0000:
            r3.m()
            byte[] r0 = r3.w
            r1 = 0
            byte r0 = r0[r1]
            r1 = 1
            if (r0 != r1) goto L_0x001f
            byte[] r0 = r3.w
            byte r0 = r0[r1]
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte[] r1 = r3.w
            r2 = 2
            byte r1 = r1[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            com.bumptech.glide.c.d r2 = r3.d
            int r1 = r1 << 8
            r0 = r0 | r1
            r2.o = r0
        L_0x001f:
            int r0 = r3.x
            if (r0 <= 0) goto L_0x0029
            boolean r0 = r3.p()
            if (r0 == 0) goto L_0x0000
        L_0x0029:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.c.e.h():void");
    }

    private void i() {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) n());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.d.d = 1;
            return;
        }
        this.d.h = this.f927c.getShort();
        this.d.i = this.f927c.getShort();
        int n2 = n();
        d dVar = this.d;
        if ((n2 & 128) != 0) {
            z = true;
        }
        dVar.j = z;
        this.d.k = (int) Math.pow(2.0d, (double) ((n2 & 7) + 1));
        this.d.l = n();
        this.d.m = n();
        if (this.d.j && !p()) {
            this.d.f924c = b(this.d.k);
            this.d.n = this.d.f924c[this.d.l];
        }
    }

    private void j() {
        this.d.h = this.f927c.getShort();
        this.d.i = this.f927c.getShort();
        int n2 = n();
        this.d.j = (n2 & 128) != 0;
        this.d.k = (int) Math.pow(2.0d, (double) ((n2 & 7) + 1));
        this.d.l = n();
        this.d.m = n();
    }

    private void k() {
        n();
        l();
    }

    private void l() {
        int n2;
        do {
            n2 = n();
            this.f927c.position(Math.min(this.f927c.position() + n2, this.f927c.limit()));
        } while (n2 > 0);
    }

    private void m() {
        this.x = n();
        if (this.x > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.x) {
                try {
                    i3 = this.x - i2;
                    this.f927c.get(this.w, i2, i3);
                    i2 += i3;
                } catch (Exception e2) {
                    if (Log.isLoggable(e, 3)) {
                        Log.d(e, "Error Reading Block n: " + i2 + " count: " + i3 + " blockSize: " + this.x, e2);
                    }
                    this.d.d = 1;
                    return;
                }
            }
        }
    }

    private int n() {
        try {
            return this.f927c.get() & 255;
        } catch (Exception unused) {
            this.d.d = 1;
            return 0;
        }
    }

    private int o() {
        return this.f927c.getShort();
    }

    private boolean p() {
        return this.d.d != 0;
    }

    @NonNull
    public final d a() {
        if (this.f927c == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (p()) {
            return this.d;
        } else {
            i();
            if (!p()) {
                a((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                if (this.d.e < 0) {
                    this.d.d = 1;
                }
            }
            return this.d;
        }
    }

    public final e a(@NonNull ByteBuffer byteBuffer) {
        this.f927c = null;
        Arrays.fill(this.w, (byte) 0);
        this.d = new d();
        this.x = 0;
        this.f927c = byteBuffer.asReadOnlyBuffer();
        this.f927c.position(0);
        this.f927c.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
}
