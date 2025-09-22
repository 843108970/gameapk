package com.googlecode.leptonica.android;

public class Scale {

    /* renamed from: com.googlecode.leptonica.android.Scale$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3390a = new int[a.a().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0011 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                int[] r0 = com.googlecode.leptonica.android.Scale.a.a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3390a = r0
                r0 = 1
                int[] r1 = f3390a     // Catch:{ NoSuchFieldError -> 0x0011 }
                int r2 = com.googlecode.leptonica.android.Scale.a.f3391a     // Catch:{ NoSuchFieldError -> 0x0011 }
                int r2 = r2 - r0
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0011 }
            L_0x0011:
                int[] r1 = f3390a     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r2 = com.googlecode.leptonica.android.Scale.a.f3392b     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r2 = r2 - r0
                r3 = 2
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                int[] r1 = f3390a     // Catch:{ NoSuchFieldError -> 0x0021 }
                int r2 = com.googlecode.leptonica.android.Scale.a.f3393c     // Catch:{ NoSuchFieldError -> 0x0021 }
                int r2 = r2 - r0
                r0 = 3
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.googlecode.leptonica.android.Scale.AnonymousClass1.<clinit>():void");
        }
    }

    public enum a {
        ;
        

        /* renamed from: a  reason: collision with root package name */
        public static final int f3391a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f3392b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f3393c = 3;

        static {
            d = new int[]{f3391a, f3392b, f3393c};
        }

        public static int[] a() {
            return (int[]) d.clone();
        }
    }

    static {
        System.loadLibrary("jpgt");
        System.loadLibrary("pngt");
        System.loadLibrary("lept");
    }

    private static Pix a(Pix pix, float f) {
        return a(pix, f, f);
    }

    private static Pix a(Pix pix, float f, float f2) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        } else if (f <= 0.0f) {
            throw new IllegalArgumentException("X scaling factor must be positive");
        } else if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Y scaling factor must be positive");
        } else {
            long nativeScale = nativeScale(pix.a(), f, f2);
            if (nativeScale != 0) {
                return new Pix(nativeScale);
            }
            throw new RuntimeException("Failed to natively scale pix");
        }
    }

    private static Pix a(Pix pix, int i, int i2, int i3) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        }
        float c2 = ((float) i) / ((float) pix.c());
        float d = ((float) i2) / ((float) pix.d());
        switch (AnonymousClass1.f3390a[i3 - 1]) {
            case 2:
                c2 = Math.min(c2, d);
                break;
            case 3:
                c2 = Math.min(1.0f, Math.min(c2, d));
                break;
            default:
                return a(pix, c2, d);
        }
        d = c2;
        return a(pix, c2, d);
    }

    private static Pix b(Pix pix, float f) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        } else if (f > 0.0f) {
            return new Pix(nativeScaleGeneral(pix.a(), f, f, 0.0f, 0));
        } else {
            throw new IllegalArgumentException("Scaling factor must be positive");
        }
    }

    private static native long nativeScale(long j, float f, float f2);

    private static native long nativeScaleGeneral(long j, float f, float f2, float f3, int i);
}
