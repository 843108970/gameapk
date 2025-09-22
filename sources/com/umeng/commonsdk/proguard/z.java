package com.umeng.commonsdk.proguard;

import org.litepal.g.b;

public class z extends ag {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3838a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f3839b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3840c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    private static final be j = new be("TApplicationException");
    private static final au k = new au("message", (byte) 11, 1);
    private static final au l = new au(b.c.f4839c, (byte) 8, 2);
    private static final long m = 1;
    protected int i = 0;

    public z() {
    }

    public z(int i2) {
        this.i = i2;
    }

    public z(int i2, String str) {
        super(str);
        this.i = i2;
    }

    public z(String str) {
        super(str);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.umeng.commonsdk.proguard.z a(com.umeng.commonsdk.proguard.az r5) throws com.umeng.commonsdk.proguard.ag {
        /*
            r5.j()
            r0 = 0
            r1 = 0
        L_0x0005:
            com.umeng.commonsdk.proguard.au r2 = r5.l()
            byte r3 = r2.f3725b
            if (r3 == 0) goto L_0x0031
            short r3 = r2.f3726c
            switch(r3) {
                case 1: goto L_0x0023;
                case 2: goto L_0x0018;
                default: goto L_0x0012;
            }
        L_0x0012:
            byte r2 = r2.f3725b
            com.umeng.commonsdk.proguard.bc.a((com.umeng.commonsdk.proguard.az) r5, (byte) r2)
            goto L_0x002d
        L_0x0018:
            byte r3 = r2.f3725b
            r4 = 8
            if (r3 != r4) goto L_0x0012
            int r1 = r5.w()
            goto L_0x002d
        L_0x0023:
            byte r3 = r2.f3725b
            r4 = 11
            if (r3 != r4) goto L_0x0012
            java.lang.String r0 = r5.z()
        L_0x002d:
            r5.m()
            goto L_0x0005
        L_0x0031:
            r5.k()
            com.umeng.commonsdk.proguard.z r5 = new com.umeng.commonsdk.proguard.z
            r5.<init>(r1, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.proguard.z.a(com.umeng.commonsdk.proguard.az):com.umeng.commonsdk.proguard.z");
    }

    public int a() {
        return this.i;
    }

    public void b(az azVar) throws ag {
        azVar.a(j);
        if (getMessage() != null) {
            azVar.a(k);
            azVar.a(getMessage());
            azVar.c();
        }
        azVar.a(l);
        azVar.a(this.i);
        azVar.c();
        azVar.d();
        azVar.b();
    }
}
