package com.bumptech.glide.load.d.a;

import com.bumptech.glide.load.i;

public abstract class n {

    /* renamed from: a  reason: collision with root package name */
    public static final n f1311a = new e();

    /* renamed from: b  reason: collision with root package name */
    public static final n f1312b = new d();

    /* renamed from: c  reason: collision with root package name */
    public static final n f1313c = new a();
    public static final n d = new b();
    public static final n e = new c();
    public static final n f = new f();
    public static final n g = f1312b;
    public static final i<n> h = i.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", g);

    private static class a extends n {
        a() {
        }

        public final float a(int i, int i2, int i3, int i4) {
            int min = Math.min(i2 / i4, i / i3);
            if (min == 0) {
                return 1.0f;
            }
            return 1.0f / ((float) Integer.highestOneBit(min));
        }

        public final int a() {
            return g.QUALITY$3973276c;
        }
    }

    private static class b extends n {
        b() {
        }

        public final float a(int i, int i2, int i3, int i4) {
            int ceil = (int) Math.ceil((double) Math.max(((float) i2) / ((float) i4), ((float) i) / ((float) i3)));
            int i5 = 1;
            int max = Math.max(1, Integer.highestOneBit(ceil));
            if (max >= ceil) {
                i5 = 0;
            }
            return 1.0f / ((float) (max << i5));
        }

        public final int a() {
            return g.MEMORY$3973276c;
        }
    }

    private static class c extends n {
        c() {
        }

        public final float a(int i, int i2, int i3, int i4) {
            return Math.min(1.0f, f1311a.a(i, i2, i3, i4));
        }

        public final int a() {
            return g.QUALITY$3973276c;
        }
    }

    private static class d extends n {
        d() {
        }

        public final float a(int i, int i2, int i3, int i4) {
            return Math.max(((float) i3) / ((float) i), ((float) i4) / ((float) i2));
        }

        public final int a() {
            return g.QUALITY$3973276c;
        }
    }

    private static class e extends n {
        e() {
        }

        public final float a(int i, int i2, int i3, int i4) {
            return Math.min(((float) i3) / ((float) i), ((float) i4) / ((float) i2));
        }

        public final int a() {
            return g.QUALITY$3973276c;
        }
    }

    private static class f extends n {
        f() {
        }

        public final float a(int i, int i2, int i3, int i4) {
            return 1.0f;
        }

        public final int a() {
            return g.QUALITY$3973276c;
        }
    }

    public enum g {
        ;
        
        public static final int MEMORY$3973276c = 1;
        public static final int QUALITY$3973276c = 2;

        static {
            $VALUES$1ef85db1 = new int[]{MEMORY$3973276c, QUALITY$3973276c};
        }

        public static int[] values$5e1fb8b2() {
            return (int[]) $VALUES$1ef85db1.clone();
        }
    }

    public abstract float a(int i, int i2, int i3, int i4);

    public abstract int a();
}
