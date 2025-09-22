package com.bumptech.glide.load.d.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.b;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.d.a.n;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import com.bumptech.glide.util.k;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    static final String f1314a = "Downsampler";

    /* renamed from: b  reason: collision with root package name */
    public static final i<b> f1315b = i.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", b.DEFAULT);
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final i<n> f1316c = n.h;
    public static final i<Boolean> d = i.a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", false);
    public static final i<Boolean> e = i.a("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", false);
    static final a f = new a() {
        public final void a() {
        }

        public final void a(e eVar, Bitmap bitmap) {
        }
    };
    private static final String g = "image/vnd.wap.wbmp";
    private static final String h = "image/x-ico";
    private static final Set<String> i = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{g, h})));
    private static final Set<ImageHeaderParser.ImageType> j = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
    private static final Queue<BitmapFactory.Options> k = k.a(0);
    private static final int l = 10485760;
    private final e m;
    private final DisplayMetrics n;
    private final com.bumptech.glide.load.b.a.b o;
    private final List<ImageHeaderParser> p;
    private final t q = t.a();

    public interface a {
        void a();

        void a(e eVar, Bitmap bitmap) throws IOException;
    }

    public o(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, e eVar, com.bumptech.glide.load.b.a.b bVar) {
        this.p = list;
        this.n = (DisplayMetrics) com.bumptech.glide.util.i.a(displayMetrics, "Argument must not be null");
        this.m = (e) com.bumptech.glide.util.i.a(eVar, "Argument must not be null");
        this.o = (com.bumptech.glide.load.b.a.b) com.bumptech.glide.util.i.a(bVar, "Argument must not be null");
    }

    private static int a(double d2) {
        int b2 = b(d2);
        int i2 = (int) ((((double) b2) * d2) + 0.5d);
        return (int) (((d2 / ((double) (((float) i2) / ((float) b2)))) * ((double) i2)) + 0.5d);
    }

    /* JADX WARNING: Removed duplicated region for block: B:115:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02f0  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x02fd  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0310  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x031f  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0327  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x03f5  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0486  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap a(java.io.InputStream r29, android.graphics.BitmapFactory.Options r30, com.bumptech.glide.load.d.a.n r31, com.bumptech.glide.load.b r32, boolean r33, int r34, int r35, boolean r36, com.bumptech.glide.load.d.a.o.a r37) throws java.io.IOException {
        /*
            r28 = this;
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r5 = r32
            r6 = r34
            r7 = r35
            r8 = r37
            long r9 = com.bumptech.glide.util.e.a()
            com.bumptech.glide.load.b.a.e r11 = r1.m
            int[] r11 = a((java.io.InputStream) r2, (android.graphics.BitmapFactory.Options) r3, (com.bumptech.glide.load.d.a.o.a) r8, (com.bumptech.glide.load.b.a.e) r11)
            r12 = 0
            r13 = r11[r12]
            r14 = 1
            r11 = r11[r14]
            java.lang.String r15 = r3.outMimeType
            r12 = -1
            if (r13 == r12) goto L_0x002b
            if (r11 != r12) goto L_0x0028
            goto L_0x002b
        L_0x0028:
            r12 = r33
            goto L_0x002c
        L_0x002b:
            r12 = 0
        L_0x002c:
            java.util.List<com.bumptech.glide.load.ImageHeaderParser> r14 = r1.p
            r16 = r9
            com.bumptech.glide.load.b.a.b r9 = r1.o
            int r9 = com.bumptech.glide.load.f.b(r14, r2, r9)
            int r10 = com.bumptech.glide.load.d.a.z.a((int) r9)
            boolean r14 = com.bumptech.glide.load.d.a.z.b((int) r9)
            r18 = r9
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r6 != r9) goto L_0x0045
            r6 = r13
        L_0x0045:
            if (r7 != r9) goto L_0x0049
            r9 = r11
            goto L_0x004a
        L_0x0049:
            r9 = r7
        L_0x004a:
            java.util.List<com.bumptech.glide.load.ImageHeaderParser> r7 = r1.p
            r19 = r15
            com.bumptech.glide.load.b.a.b r15 = r1.o
            com.bumptech.glide.load.ImageHeaderParser$ImageType r7 = com.bumptech.glide.load.f.a(r7, r2, r15)
            com.bumptech.glide.load.b.a.e r15 = r1.m
            r20 = 1065353216(0x3f800000, float:1.0)
            if (r13 <= 0) goto L_0x024b
            if (r11 > 0) goto L_0x005e
            goto L_0x024b
        L_0x005e:
            r5 = 90
            if (r10 == r5) goto L_0x006c
            r5 = 270(0x10e, float:3.78E-43)
            if (r10 != r5) goto L_0x0067
            goto L_0x006c
        L_0x0067:
            float r5 = r4.a(r13, r11, r6, r9)
            goto L_0x0070
        L_0x006c:
            float r5 = r4.a(r11, r13, r6, r9)
        L_0x0070:
            r10 = 0
            int r10 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r10 > 0) goto L_0x00b6
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r7 = "Cannot scale with factor: "
            r3.<init>(r7)
            r3.append(r5)
            java.lang.String r5 = " from: "
            r3.append(r5)
            r3.append(r4)
            java.lang.String r4 = ", source: ["
            r3.append(r4)
            r3.append(r13)
            java.lang.String r4 = "x"
            r3.append(r4)
            r3.append(r11)
            java.lang.String r4 = "], target: ["
            r3.append(r4)
            r3.append(r6)
            java.lang.String r4 = "x"
            r3.append(r4)
            r3.append(r9)
            java.lang.String r4 = "]"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        L_0x00b6:
            int r10 = r31.a()
            if (r10 != 0) goto L_0x00c4
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Cannot round with null rounding"
            r2.<init>(r3)
            throw r2
        L_0x00c4:
            r21 = r14
            float r14 = (float) r13
            r22 = r12
            float r12 = r5 * r14
            double r1 = (double) r12
            r23 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r1 = r1 + r23
            int r1 = (int) r1
            float r2 = (float) r11
            float r12 = r5 * r2
            r25 = r9
            double r8 = (double) r12
            double r8 = r8 + r23
            int r8 = (int) r8
            int r1 = r13 / r1
            int r8 = r11 / r8
            int r9 = com.bumptech.glide.load.d.a.n.g.MEMORY$3973276c
            if (r10 != r9) goto L_0x00e7
            int r1 = java.lang.Math.max(r1, r8)
            goto L_0x00eb
        L_0x00e7:
            int r1 = java.lang.Math.min(r1, r8)
        L_0x00eb:
            int r8 = android.os.Build.VERSION.SDK_INT
            r9 = 23
            if (r8 > r9) goto L_0x00fd
            java.util.Set<java.lang.String> r8 = i
            java.lang.String r9 = r3.outMimeType
            boolean r8 = r8.contains(r9)
            if (r8 == 0) goto L_0x00fd
            r1 = 1
            goto L_0x0113
        L_0x00fd:
            int r1 = java.lang.Integer.highestOneBit(r1)
            r8 = 1
            int r1 = java.lang.Math.max(r8, r1)
            int r8 = com.bumptech.glide.load.d.a.n.g.MEMORY$3973276c
            if (r10 != r8) goto L_0x0113
            float r8 = (float) r1
            float r9 = r20 / r5
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 >= 0) goto L_0x0113
            int r1 = r1 << 1
        L_0x0113:
            r3.inSampleSize = r1
            com.bumptech.glide.load.ImageHeaderParser$ImageType r8 = com.bumptech.glide.load.ImageHeaderParser.ImageType.JPEG
            if (r7 != r8) goto L_0x013d
            r8 = 8
            int r8 = java.lang.Math.min(r1, r8)
            float r8 = (float) r8
            float r14 = r14 / r8
            double r9 = (double) r14
            double r9 = java.lang.Math.ceil(r9)
            int r9 = (int) r9
            float r2 = r2 / r8
            double r14 = (double) r2
            double r14 = java.lang.Math.ceil(r14)
            int r2 = (int) r14
            int r8 = r1 / 8
            if (r8 <= 0) goto L_0x0134
            int r9 = r9 / r8
            int r2 = r2 / r8
        L_0x0134:
            r10 = r2
            r12 = r9
            r2 = r25
            r8 = r29
            r9 = r37
            goto L_0x0198
        L_0x013d:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r8 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG
            if (r7 == r8) goto L_0x0182
            com.bumptech.glide.load.ImageHeaderParser$ImageType r8 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG_A
            if (r7 != r8) goto L_0x0146
            goto L_0x0182
        L_0x0146:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r8 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP
            if (r7 == r8) goto L_0x016c
            com.bumptech.glide.load.ImageHeaderParser$ImageType r8 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A
            if (r7 != r8) goto L_0x014f
            goto L_0x016c
        L_0x014f:
            int r2 = r13 % r1
            if (r2 != 0) goto L_0x015d
            int r2 = r11 % r1
            if (r2 == 0) goto L_0x0158
            goto L_0x015d
        L_0x0158:
            int r9 = r13 / r1
            int r2 = r11 / r1
            goto L_0x0134
        L_0x015d:
            r8 = r29
            r9 = r37
            int[] r2 = a((java.io.InputStream) r8, (android.graphics.BitmapFactory.Options) r3, (com.bumptech.glide.load.d.a.o.a) r9, (com.bumptech.glide.load.b.a.e) r15)
            r10 = 0
            r12 = r2[r10]
            r10 = 1
            r2 = r2[r10]
            goto L_0x0195
        L_0x016c:
            r8 = r29
            r9 = r37
            int r10 = android.os.Build.VERSION.SDK_INT
            r12 = 24
            if (r10 < r12) goto L_0x0186
            float r10 = (float) r1
            float r14 = r14 / r10
            int r12 = java.lang.Math.round(r14)
            float r2 = r2 / r10
            int r2 = java.lang.Math.round(r2)
            goto L_0x0195
        L_0x0182:
            r8 = r29
            r9 = r37
        L_0x0186:
            float r10 = (float) r1
            float r14 = r14 / r10
            double r14 = (double) r14
            double r14 = java.lang.Math.floor(r14)
            int r12 = (int) r14
            float r2 = r2 / r10
            double r14 = (double) r2
            double r14 = java.lang.Math.floor(r14)
            int r2 = (int) r14
        L_0x0195:
            r10 = r2
            r2 = r25
        L_0x0198:
            float r4 = r4.a(r12, r10, r6, r2)
            double r14 = (double) r4
            int r4 = android.os.Build.VERSION.SDK_INT
            r9 = 19
            if (r4 < r9) goto L_0x01c4
            int r4 = b((double) r14)
            double r8 = (double) r4
            double r8 = r8 * r14
            double r8 = r8 + r23
            int r8 = (int) r8
            float r9 = (float) r8
            float r4 = (float) r4
            float r9 = r9 / r4
            r26 = r5
            double r4 = (double) r9
            double r4 = r14 / r4
            double r8 = (double) r8
            double r4 = r4 * r8
            double r4 = r4 + r23
            int r4 = (int) r4
            r3.inTargetDensity = r4
            int r4 = b((double) r14)
            r3.inDensity = r4
            goto L_0x01c6
        L_0x01c4:
            r26 = r5
        L_0x01c6:
            boolean r4 = a((android.graphics.BitmapFactory.Options) r30)
            if (r4 == 0) goto L_0x01d0
            r4 = 1
            r3.inScaled = r4
            goto L_0x01d5
        L_0x01d0:
            r4 = 0
            r3.inTargetDensity = r4
            r3.inDensity = r4
        L_0x01d5:
            java.lang.String r4 = "Downsampler"
            r5 = 2
            boolean r4 = android.util.Log.isLoggable(r4, r5)
            if (r4 == 0) goto L_0x0247
            java.lang.String r4 = "Downsampler"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "Calculate scaling, source: ["
            r5.<init>(r8)
            r5.append(r13)
            java.lang.String r8 = "x"
            r5.append(r8)
            r5.append(r11)
            java.lang.String r8 = "], target: ["
            r5.append(r8)
            r5.append(r6)
            java.lang.String r8 = "x"
            r5.append(r8)
            r5.append(r2)
            java.lang.String r8 = "], power of two scaled: ["
            r5.append(r8)
            r5.append(r12)
            java.lang.String r8 = "x"
            r5.append(r8)
            r5.append(r10)
            java.lang.String r8 = "], exact scale factor: "
            r5.append(r8)
            r8 = r26
            r5.append(r8)
            java.lang.String r8 = ", power of 2 sample size: "
            r5.append(r8)
            r5.append(r1)
            java.lang.String r1 = ", adjusted scale factor: "
            r5.append(r1)
            r5.append(r14)
            java.lang.String r1 = ", target density: "
            r5.append(r1)
            int r1 = r3.inTargetDensity
            r5.append(r1)
            java.lang.String r1 = ", density: "
            r5.append(r1)
            int r1 = r3.inDensity
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            android.util.Log.v(r4, r1)
        L_0x0247:
            r1 = r28
            r4 = 3
            goto L_0x0283
        L_0x024b:
            r2 = r9
            r22 = r12
            r21 = r14
            java.lang.String r1 = "Downsampler"
            r4 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r4)
            if (r1 == 0) goto L_0x0281
            java.lang.String r1 = "Downsampler"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "Unable to determine dimensions for: "
            r5.<init>(r8)
            r5.append(r7)
            java.lang.String r8 = " with target ["
            r5.append(r8)
            r5.append(r6)
            java.lang.String r8 = "x"
            r5.append(r8)
            r5.append(r2)
            java.lang.String r8 = "]"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r1, r5)
        L_0x0281:
            r1 = r28
        L_0x0283:
            com.bumptech.glide.load.d.a.t r5 = r1.q
            r8 = 26
            if (r22 == 0) goto L_0x02ab
            int r9 = android.os.Build.VERSION.SDK_INT
            if (r9 < r8) goto L_0x02ab
            if (r21 == 0) goto L_0x0290
            goto L_0x02ab
        L_0x0290:
            r9 = 128(0x80, float:1.794E-43)
            if (r6 < r9) goto L_0x029e
            if (r2 < r9) goto L_0x029e
            boolean r5 = r5.b()
            if (r5 == 0) goto L_0x029e
            r12 = 1
            goto L_0x029f
        L_0x029e:
            r12 = 0
        L_0x029f:
            if (r12 == 0) goto L_0x02a9
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.HARDWARE
            r3.inPreferredConfig = r5
            r5 = 0
            r3.inMutable = r5
            goto L_0x02ad
        L_0x02a9:
            r5 = 0
            goto L_0x02ad
        L_0x02ab:
            r5 = 0
            r12 = 0
        L_0x02ad:
            if (r12 != 0) goto L_0x0308
            com.bumptech.glide.load.b r9 = com.bumptech.glide.load.b.PREFER_ARGB_8888
            r4 = r32
            r10 = 3
            if (r4 == r9) goto L_0x0301
            int r9 = android.os.Build.VERSION.SDK_INT
            r12 = 16
            if (r9 != r12) goto L_0x02bd
            goto L_0x0301
        L_0x02bd:
            java.util.List<com.bumptech.glide.load.ImageHeaderParser> r9 = r1.p     // Catch:{ IOException -> 0x02ce }
            com.bumptech.glide.load.b.a.b r12 = r1.o     // Catch:{ IOException -> 0x02ce }
            r14 = r29
            com.bumptech.glide.load.ImageHeaderParser$ImageType r9 = com.bumptech.glide.load.f.a(r9, r14, r12)     // Catch:{ IOException -> 0x02cc }
            boolean r12 = r9.hasAlpha()     // Catch:{ IOException -> 0x02cc }
            goto L_0x02ee
        L_0x02cc:
            r0 = move-exception
            goto L_0x02d1
        L_0x02ce:
            r0 = move-exception
            r14 = r29
        L_0x02d1:
            r9 = r0
            java.lang.String r12 = "Downsampler"
            boolean r10 = android.util.Log.isLoggable(r12, r10)
            if (r10 == 0) goto L_0x02ed
            java.lang.String r10 = "Downsampler"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r15 = "Cannot determine whether the image has alpha or not from header, format "
            r12.<init>(r15)
            r12.append(r4)
            java.lang.String r4 = r12.toString()
            android.util.Log.d(r10, r4, r9)
        L_0x02ed:
            r12 = 0
        L_0x02ee:
            if (r12 == 0) goto L_0x02f3
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888
            goto L_0x02f5
        L_0x02f3:
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.RGB_565
        L_0x02f5:
            r3.inPreferredConfig = r4
            android.graphics.Bitmap$Config r4 = r3.inPreferredConfig
            android.graphics.Bitmap$Config r9 = android.graphics.Bitmap.Config.RGB_565
            if (r4 != r9) goto L_0x030a
            r4 = 1
            r3.inDither = r4
            goto L_0x030a
        L_0x0301:
            r14 = r29
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888
            r3.inPreferredConfig = r4
            goto L_0x030a
        L_0x0308:
            r14 = r29
        L_0x030a:
            int r4 = android.os.Build.VERSION.SDK_INT
            r9 = 19
            if (r4 < r9) goto L_0x0311
            r5 = 1
        L_0x0311:
            int r4 = r3.inSampleSize
            r10 = 0
            r12 = 1
            if (r4 == r12) goto L_0x0319
            if (r5 == 0) goto L_0x03df
        L_0x0319:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r9) goto L_0x031f
            r4 = 1
            goto L_0x0325
        L_0x031f:
            java.util.Set<com.bumptech.glide.load.ImageHeaderParser$ImageType> r4 = j
            boolean r4 = r4.contains(r7)
        L_0x0325:
            if (r4 == 0) goto L_0x03df
            if (r13 < 0) goto L_0x0333
            if (r11 < 0) goto L_0x0333
            if (r36 == 0) goto L_0x0333
            if (r5 == 0) goto L_0x0333
            r9 = r2
            r5 = r6
            goto L_0x03bf
        L_0x0333:
            boolean r2 = a((android.graphics.BitmapFactory.Options) r30)
            if (r2 == 0) goto L_0x0344
            int r2 = r3.inTargetDensity
            float r2 = (float) r2
            int r4 = r3.inDensity
            float r4 = (float) r4
            float r20 = r2 / r4
            r2 = r20
            goto L_0x0346
        L_0x0344:
            r2 = 1065353216(0x3f800000, float:1.0)
        L_0x0346:
            int r4 = r3.inSampleSize
            float r5 = (float) r13
            float r6 = (float) r4
            float r5 = r5 / r6
            double r8 = (double) r5
            double r7 = java.lang.Math.ceil(r8)
            int r5 = (int) r7
            float r7 = (float) r11
            float r7 = r7 / r6
            double r6 = (double) r7
            double r6 = java.lang.Math.ceil(r6)
            int r6 = (int) r6
            float r5 = (float) r5
            float r5 = r5 * r2
            int r5 = java.lang.Math.round(r5)
            float r6 = (float) r6
            float r6 = r6 * r2
            int r9 = java.lang.Math.round(r6)
            java.lang.String r6 = "Downsampler"
            r7 = 2
            boolean r6 = android.util.Log.isLoggable(r6, r7)
            if (r6 == 0) goto L_0x03bf
            java.lang.String r6 = "Downsampler"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Calculated target ["
            r7.<init>(r8)
            r7.append(r5)
            java.lang.String r8 = "x"
            r7.append(r8)
            r7.append(r9)
            java.lang.String r8 = "] for source ["
            r7.append(r8)
            r7.append(r13)
            java.lang.String r8 = "x"
            r7.append(r8)
            r7.append(r11)
            java.lang.String r8 = "], sampleSize: "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r4 = ", targetDensity: "
            r7.append(r4)
            int r4 = r3.inTargetDensity
            r7.append(r4)
            java.lang.String r4 = ", density: "
            r7.append(r4)
            int r4 = r3.inDensity
            r7.append(r4)
            java.lang.String r4 = ", density multiplier: "
            r7.append(r4)
            r7.append(r2)
            java.lang.String r2 = r7.toString()
            android.util.Log.v(r6, r2)
        L_0x03bf:
            if (r5 <= 0) goto L_0x03df
            if (r9 <= 0) goto L_0x03df
            com.bumptech.glide.load.b.a.e r2 = r1.m
            int r4 = android.os.Build.VERSION.SDK_INT
            r6 = 26
            if (r4 < r6) goto L_0x03d4
            android.graphics.Bitmap$Config r4 = r3.inPreferredConfig
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.HARDWARE
            if (r4 == r6) goto L_0x03df
            android.graphics.Bitmap$Config r4 = r3.outConfig
            goto L_0x03d5
        L_0x03d4:
            r4 = r10
        L_0x03d5:
            if (r4 != 0) goto L_0x03d9
            android.graphics.Bitmap$Config r4 = r3.inPreferredConfig
        L_0x03d9:
            android.graphics.Bitmap r2 = r2.b(r5, r9, r4)
            r3.inBitmap = r2
        L_0x03df:
            com.bumptech.glide.load.b.a.e r2 = r1.m
            r4 = r37
            android.graphics.Bitmap r2 = b(r14, r3, r4, r2)
            com.bumptech.glide.load.b.a.e r5 = r1.m
            r4.a(r5, r2)
            java.lang.String r4 = "Downsampler"
            r5 = 2
            boolean r4 = android.util.Log.isLoggable(r4, r5)
            if (r4 == 0) goto L_0x0484
            java.lang.String r4 = "Downsampler"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Decoded "
            r5.<init>(r6)
            java.lang.String r6 = a((android.graphics.Bitmap) r2)
            r5.append(r6)
            java.lang.String r6 = " from ["
            r5.append(r6)
            r5.append(r13)
            java.lang.String r6 = "x"
            r5.append(r6)
            r5.append(r11)
            java.lang.String r6 = "] "
            r5.append(r6)
            r6 = r19
            r5.append(r6)
            java.lang.String r6 = " with inBitmap "
            r5.append(r6)
            android.graphics.Bitmap r6 = r3.inBitmap
            java.lang.String r6 = a((android.graphics.Bitmap) r6)
            r5.append(r6)
            java.lang.String r6 = " for ["
            r5.append(r6)
            r6 = r34
            r5.append(r6)
            java.lang.String r6 = "x"
            r5.append(r6)
            r6 = r35
            r5.append(r6)
            java.lang.String r6 = "], sample size: "
            r5.append(r6)
            int r6 = r3.inSampleSize
            r5.append(r6)
            java.lang.String r6 = ", density: "
            r5.append(r6)
            int r6 = r3.inDensity
            r5.append(r6)
            java.lang.String r6 = ", target density: "
            r5.append(r6)
            int r3 = r3.inTargetDensity
            r5.append(r3)
            java.lang.String r3 = ", thread: "
            r5.append(r3)
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.String r3 = r3.getName()
            r5.append(r3)
            java.lang.String r3 = ", duration: "
            r5.append(r3)
            r6 = r16
            double r6 = com.bumptech.glide.util.e.a(r6)
            r5.append(r6)
            java.lang.String r3 = r5.toString()
            android.util.Log.v(r4, r3)
        L_0x0484:
            if (r2 == 0) goto L_0x04a0
            android.util.DisplayMetrics r3 = r1.n
            int r3 = r3.densityDpi
            r2.setDensity(r3)
            com.bumptech.glide.load.b.a.e r3 = r1.m
            r4 = r18
            android.graphics.Bitmap r10 = com.bumptech.glide.load.d.a.z.a((com.bumptech.glide.load.b.a.e) r3, (android.graphics.Bitmap) r2, (int) r4)
            boolean r3 = r2.equals(r10)
            if (r3 != 0) goto L_0x04a0
            com.bumptech.glide.load.b.a.e r3 = r1.m
            r3.a((android.graphics.Bitmap) r2)
        L_0x04a0:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.d.a.o.a(java.io.InputStream, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.d.a.n, com.bumptech.glide.load.b, boolean, int, int, boolean, com.bumptech.glide.load.d.a.o$a):android.graphics.Bitmap");
    }

    private u<Bitmap> a(InputStream inputStream, int i2, int i3, j jVar) throws IOException {
        return a(inputStream, i2, i3, jVar, f);
    }

    private static IOException a(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + a(options.inBitmap), illegalArgumentException);
    }

    @Nullable
    @TargetApi(19)
    private static String a(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    private static void a(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j2) {
        Log.v(f1314a, "Decoded " + a(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + a(options.inBitmap) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + com.bumptech.glide.util.e.a(j2));
    }

    @TargetApi(26)
    private static void a(BitmapFactory.Options options, e eVar, int i2, int i3) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            config = options.outConfig;
        } else {
            return;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = eVar.b(i2, i3, config);
    }

    private static void a(ImageHeaderParser.ImageType imageType, InputStream inputStream, a aVar, e eVar, n nVar, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) throws IOException {
        int i7;
        int i8;
        int i9;
        ImageHeaderParser.ImageType imageType2 = imageType;
        n nVar2 = nVar;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        BitmapFactory.Options options2 = options;
        if (i11 > 0 && i12 > 0) {
            float a2 = (i10 == 90 || i10 == 270) ? nVar2.a(i12, i11, i13, i14) : nVar2.a(i11, i12, i13, i14);
            if (a2 <= 0.0f) {
                throw new IllegalArgumentException("Cannot scale with factor: " + a2 + " from: " + nVar2 + ", source: [" + i11 + "x" + i12 + "], target: [" + i13 + "x" + i14 + "]");
            }
            int a3 = nVar.a();
            if (a3 == 0) {
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            float f2 = (float) i11;
            float f3 = (float) i12;
            int i15 = i11 / ((int) (((double) (a2 * f2)) + 0.5d));
            int i16 = i12 / ((int) (((double) (a2 * f3)) + 0.5d));
            int max = a3 == n.g.MEMORY$3973276c ? Math.max(i15, i16) : Math.min(i15, i16);
            if (Build.VERSION.SDK_INT > 23 || !i.contains(options2.outMimeType)) {
                int max2 = Math.max(1, Integer.highestOneBit(max));
                i7 = (a3 != n.g.MEMORY$3973276c || ((float) max2) >= 1.0f / a2) ? max2 : max2 << 1;
            } else {
                i7 = 1;
            }
            options2.inSampleSize = i7;
            if (imageType2 == ImageHeaderParser.ImageType.JPEG) {
                float min = (float) Math.min(i7, 8);
                i8 = (int) Math.ceil((double) (f2 / min));
                i9 = (int) Math.ceil((double) (f3 / min));
                int i17 = i7 / 8;
                if (i17 > 0) {
                    i8 /= i17;
                    i9 /= i17;
                }
            } else {
                if (!(imageType2 == ImageHeaderParser.ImageType.PNG || imageType2 == ImageHeaderParser.ImageType.PNG_A)) {
                    if (imageType2 == ImageHeaderParser.ImageType.WEBP || imageType2 == ImageHeaderParser.ImageType.WEBP_A) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            float f4 = (float) i7;
                            i8 = Math.round(f2 / f4);
                            i9 = Math.round(f3 / f4);
                        }
                    } else if (i11 % i7 == 0 && i12 % i7 == 0) {
                        i8 = i11 / i7;
                        i9 = i12 / i7;
                    } else {
                        int[] a4 = a(inputStream, options2, aVar, eVar);
                        i8 = a4[0];
                        i9 = a4[1];
                    }
                }
                float f5 = (float) i7;
                i8 = (int) Math.floor((double) (f2 / f5));
                i9 = (int) Math.floor((double) (f3 / f5));
            }
            double a5 = (double) nVar2.a(i8, i9, i13, i14);
            if (Build.VERSION.SDK_INT >= 19) {
                int b2 = b(a5);
                int i18 = (int) ((((double) b2) * a5) + 0.5d);
                options2.inTargetDensity = (int) (((a5 / ((double) (((float) i18) / ((float) b2)))) * ((double) i18)) + 0.5d);
                options2.inDensity = b(a5);
            }
            if (a(options)) {
                options2.inScaled = true;
            } else {
                options2.inTargetDensity = 0;
                options2.inDensity = 0;
            }
            if (Log.isLoggable(f1314a, 2)) {
                Log.v(f1314a, "Calculate scaling, source: [" + i11 + "x" + i12 + "], target: [" + i13 + "x" + i14 + "], power of two scaled: [" + i8 + "x" + i9 + "], exact scale factor: " + a2 + ", power of 2 sample size: " + i7 + ", adjusted scale factor: " + a5 + ", target density: " + options2.inTargetDensity + ", density: " + options2.inDensity);
            }
        } else if (Log.isLoggable(f1314a, 3)) {
            Log.d(f1314a, "Unable to determine dimensions for: " + imageType2 + " with target [" + i13 + "x" + i14 + "]");
        }
    }

    private void a(InputStream inputStream, b bVar, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        boolean z3;
        boolean z4;
        t tVar = this.q;
        if (!z || Build.VERSION.SDK_INT < 26 || z2) {
            z3 = false;
        } else {
            z3 = i2 >= 128 && i3 >= 128 && tVar.b();
            if (z3) {
                options.inPreferredConfig = Bitmap.Config.HARDWARE;
                options.inMutable = false;
            }
        }
        if (!z3) {
            if (bVar == b.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                return;
            }
            try {
                z4 = f.a(this.p, inputStream, this.o).hasAlpha();
            } catch (IOException e2) {
                if (Log.isLoggable(f1314a, 3)) {
                    Log.d(f1314a, "Cannot determine whether the image has alpha or not from header, format " + bVar, e2);
                }
                z4 = false;
            }
            options.inPreferredConfig = z4 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            if (options.inPreferredConfig == Bitmap.Config.RGB_565) {
                options.inDither = true;
            }
        }
    }

    public static boolean a() {
        return true;
    }

    private static boolean a(BitmapFactory.Options options) {
        return options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity;
    }

    private static boolean a(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return j.contains(imageType);
    }

    private static int[] a(InputStream inputStream, BitmapFactory.Options options, a aVar, e eVar) throws IOException {
        options.inJustDecodeBounds = true;
        b(inputStream, options, aVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static int b(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        throw r5;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x008c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap b(java.io.InputStream r8, android.graphics.BitmapFactory.Options r9, com.bumptech.glide.load.d.a.o.a r10, com.bumptech.glide.load.b.a.e r11) throws java.io.IOException {
        /*
            boolean r0 = r9.inJustDecodeBounds
            if (r0 == 0) goto L_0x000a
            r0 = 10485760(0xa00000, float:1.469368E-38)
            r8.mark(r0)
            goto L_0x000d
        L_0x000a:
            r10.a()
        L_0x000d:
            int r0 = r9.outWidth
            int r1 = r9.outHeight
            java.lang.String r2 = r9.outMimeType
            java.util.concurrent.locks.Lock r3 = com.bumptech.glide.load.d.a.z.a()
            r3.lock()
            r3 = 0
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeStream(r8, r3, r9)     // Catch:{ IllegalArgumentException -> 0x0030 }
            java.util.concurrent.locks.Lock r10 = com.bumptech.glide.load.d.a.z.a()
            r10.unlock()
            boolean r9 = r9.inJustDecodeBounds
            if (r9 == 0) goto L_0x002d
            r8.reset()
        L_0x002d:
            return r4
        L_0x002e:
            r8 = move-exception
            goto L_0x008e
        L_0x0030:
            r4 = move-exception
            java.io.IOException r5 = new java.io.IOException     // Catch:{ all -> 0x002e }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x002e }
            java.lang.String r7 = "Exception decoding bitmap, outWidth: "
            r6.<init>(r7)     // Catch:{ all -> 0x002e }
            r6.append(r0)     // Catch:{ all -> 0x002e }
            java.lang.String r0 = ", outHeight: "
            r6.append(r0)     // Catch:{ all -> 0x002e }
            r6.append(r1)     // Catch:{ all -> 0x002e }
            java.lang.String r0 = ", outMimeType: "
            r6.append(r0)     // Catch:{ all -> 0x002e }
            r6.append(r2)     // Catch:{ all -> 0x002e }
            java.lang.String r0 = ", inBitmap: "
            r6.append(r0)     // Catch:{ all -> 0x002e }
            android.graphics.Bitmap r0 = r9.inBitmap     // Catch:{ all -> 0x002e }
            java.lang.String r0 = a((android.graphics.Bitmap) r0)     // Catch:{ all -> 0x002e }
            r6.append(r0)     // Catch:{ all -> 0x002e }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x002e }
            r5.<init>(r0, r4)     // Catch:{ all -> 0x002e }
            java.lang.String r0 = "Downsampler"
            r1 = 3
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x0072
            java.lang.String r0 = "Downsampler"
            java.lang.String r1 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r1, r5)     // Catch:{ all -> 0x002e }
        L_0x0072:
            android.graphics.Bitmap r0 = r9.inBitmap     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x008d
            r8.reset()     // Catch:{ IOException -> 0x008c }
            android.graphics.Bitmap r0 = r9.inBitmap     // Catch:{ IOException -> 0x008c }
            r11.a((android.graphics.Bitmap) r0)     // Catch:{ IOException -> 0x008c }
            r9.inBitmap = r3     // Catch:{ IOException -> 0x008c }
            android.graphics.Bitmap r8 = b(r8, r9, r10, r11)     // Catch:{ IOException -> 0x008c }
            java.util.concurrent.locks.Lock r9 = com.bumptech.glide.load.d.a.z.a()
            r9.unlock()
            return r8
        L_0x008c:
            throw r5     // Catch:{ all -> 0x002e }
        L_0x008d:
            throw r5     // Catch:{ all -> 0x002e }
        L_0x008e:
            java.util.concurrent.locks.Lock r9 = com.bumptech.glide.load.d.a.z.a()
            r9.unlock()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.d.a.o.b(java.io.InputStream, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.d.a.o$a, com.bumptech.glide.load.b.a.e):android.graphics.Bitmap");
    }

    private static String b(BitmapFactory.Options options) {
        return a(options.inBitmap);
    }

    public static boolean b() {
        return true;
    }

    private static int c(double d2) {
        return (int) (d2 + 0.5d);
    }

    private static synchronized BitmapFactory.Options c() {
        BitmapFactory.Options poll;
        synchronized (o.class) {
            synchronized (k) {
                poll = k.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                d(poll);
            }
        }
        return poll;
    }

    private static void c(BitmapFactory.Options options) {
        d(options);
        synchronized (k) {
            k.offer(options);
        }
    }

    private static void d(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x0302 A[SYNTHETIC, Splitter:B:112:0x0302] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x032e A[Catch:{ IOException -> 0x0348, all -> 0x0324 }] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0384 A[Catch:{ all -> 0x0525 }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0393 A[Catch:{ all -> 0x0525 }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0394 A[Catch:{ all -> 0x0525 }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x039d  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0469  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x04fa A[Catch:{ IOException -> 0x0348, all -> 0x0324 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c5 A[Catch:{ all -> 0x052d }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0106 A[Catch:{ all -> 0x052d }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x020d A[Catch:{ all -> 0x02f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x022e A[Catch:{ all -> 0x02f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0236 A[Catch:{ all -> 0x02f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x023a A[Catch:{ all -> 0x02f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0248 A[Catch:{ all -> 0x02f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.bumptech.glide.load.b.u<android.graphics.Bitmap> a(java.io.InputStream r35, int r36, int r37, com.bumptech.glide.load.j r38, com.bumptech.glide.load.d.a.o.a r39) throws java.io.IOException {
        /*
            r34 = this;
            r1 = r34
            r2 = r35
            r3 = r36
            r4 = r37
            r5 = r38
            r6 = r39
            boolean r7 = r35.markSupported()
            java.lang.String r8 = "You must provide an InputStream that supports mark()"
            com.bumptech.glide.util.i.a((boolean) r7, (java.lang.String) r8)
            com.bumptech.glide.load.b.a.b r7 = r1.o
            java.lang.Class<byte[]> r8 = byte[].class
            r9 = 65536(0x10000, float:9.18355E-41)
            java.lang.Object r7 = r7.a(r9, r8)
            byte[] r7 = (byte[]) r7
            android.graphics.BitmapFactory$Options r8 = c()
            r8.inTempStorage = r7
            com.bumptech.glide.load.i<com.bumptech.glide.load.b> r9 = f1315b
            java.lang.Object r9 = r5.a(r9)
            com.bumptech.glide.load.b r9 = (com.bumptech.glide.load.b) r9
            com.bumptech.glide.load.i<com.bumptech.glide.load.d.a.n> r10 = com.bumptech.glide.load.d.a.n.h
            java.lang.Object r10 = r5.a(r10)
            com.bumptech.glide.load.d.a.n r10 = (com.bumptech.glide.load.d.a.n) r10
            com.bumptech.glide.load.i<java.lang.Boolean> r11 = d
            java.lang.Object r11 = r5.a(r11)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            com.bumptech.glide.load.i<java.lang.Boolean> r12 = e
            java.lang.Object r12 = r5.a(r12)
            r13 = 0
            if (r12 == 0) goto L_0x005c
            com.bumptech.glide.load.i<java.lang.Boolean> r12 = e
            java.lang.Object r5 = r5.a(r12)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x005c
            r5 = 1
            goto L_0x005d
        L_0x005c:
            r5 = 0
        L_0x005d:
            long r14 = com.bumptech.glide.util.e.a()     // Catch:{ all -> 0x0532 }
            com.bumptech.glide.load.b.a.e r12 = r1.m     // Catch:{ all -> 0x0532 }
            int[] r12 = a((java.io.InputStream) r2, (android.graphics.BitmapFactory.Options) r8, (com.bumptech.glide.load.d.a.o.a) r6, (com.bumptech.glide.load.b.a.e) r12)     // Catch:{ all -> 0x0532 }
            r17 = r5
            r5 = r12[r13]     // Catch:{ all -> 0x0532 }
            r16 = 1
            r12 = r12[r16]     // Catch:{ all -> 0x0532 }
            java.lang.String r13 = r8.outMimeType     // Catch:{ all -> 0x0532 }
            r18 = r7
            r7 = -1
            if (r5 == r7) goto L_0x0078
            if (r12 != r7) goto L_0x007a
        L_0x0078:
            r17 = 0
        L_0x007a:
            java.util.List<com.bumptech.glide.load.ImageHeaderParser> r7 = r1.p     // Catch:{ all -> 0x052d }
            r19 = r14
            com.bumptech.glide.load.b.a.b r14 = r1.o     // Catch:{ all -> 0x052d }
            int r7 = com.bumptech.glide.load.f.b(r7, r2, r14)     // Catch:{ all -> 0x052d }
            int r14 = com.bumptech.glide.load.d.a.z.a((int) r7)     // Catch:{ all -> 0x052d }
            boolean r15 = com.bumptech.glide.load.d.a.z.b((int) r7)     // Catch:{ all -> 0x052d }
            r21 = r7
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r3 != r7) goto L_0x0093
            r3 = r5
        L_0x0093:
            if (r4 != r7) goto L_0x0097
            r7 = r12
            goto L_0x0098
        L_0x0097:
            r7 = r4
        L_0x0098:
            java.util.List<com.bumptech.glide.load.ImageHeaderParser> r4 = r1.p     // Catch:{ all -> 0x052d }
            r22 = r13
            com.bumptech.glide.load.b.a.b r13 = r1.o     // Catch:{ all -> 0x052d }
            com.bumptech.glide.load.ImageHeaderParser$ImageType r4 = com.bumptech.glide.load.f.a(r4, r2, r13)     // Catch:{ all -> 0x052d }
            com.bumptech.glide.load.b.a.e r13 = r1.m     // Catch:{ all -> 0x052d }
            r23 = r11
            r24 = 1065353216(0x3f800000, float:1.0)
            if (r5 <= 0) goto L_0x02b9
            if (r12 > 0) goto L_0x00ae
            goto L_0x02b9
        L_0x00ae:
            r11 = 90
            if (r14 == r11) goto L_0x00bc
            r11 = 270(0x10e, float:3.78E-43)
            if (r14 != r11) goto L_0x00b7
            goto L_0x00bc
        L_0x00b7:
            float r11 = r10.a(r5, r12, r3, r7)     // Catch:{ all -> 0x052d }
            goto L_0x00c0
        L_0x00bc:
            float r11 = r10.a(r12, r5, r3, r7)     // Catch:{ all -> 0x052d }
        L_0x00c0:
            r14 = 0
            int r14 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r14 > 0) goto L_0x0106
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x052d }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x052d }
            java.lang.String r6 = "Cannot scale with factor: "
            r4.<init>(r6)     // Catch:{ all -> 0x052d }
            r4.append(r11)     // Catch:{ all -> 0x052d }
            java.lang.String r6 = " from: "
            r4.append(r6)     // Catch:{ all -> 0x052d }
            r4.append(r10)     // Catch:{ all -> 0x052d }
            java.lang.String r6 = ", source: ["
            r4.append(r6)     // Catch:{ all -> 0x052d }
            r4.append(r5)     // Catch:{ all -> 0x052d }
            java.lang.String r5 = "x"
            r4.append(r5)     // Catch:{ all -> 0x052d }
            r4.append(r12)     // Catch:{ all -> 0x052d }
            java.lang.String r5 = "], target: ["
            r4.append(r5)     // Catch:{ all -> 0x052d }
            r4.append(r3)     // Catch:{ all -> 0x052d }
            java.lang.String r3 = "x"
            r4.append(r3)     // Catch:{ all -> 0x052d }
            r4.append(r7)     // Catch:{ all -> 0x052d }
            java.lang.String r3 = "]"
            r4.append(r3)     // Catch:{ all -> 0x052d }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x052d }
            r2.<init>(r3)     // Catch:{ all -> 0x052d }
            throw r2     // Catch:{ all -> 0x052d }
        L_0x0106:
            int r14 = r10.a()     // Catch:{ all -> 0x052d }
            if (r14 != 0) goto L_0x0114
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x052d }
            java.lang.String r3 = "Cannot round with null rounding"
            r2.<init>(r3)     // Catch:{ all -> 0x052d }
            throw r2     // Catch:{ all -> 0x052d }
        L_0x0114:
            r25 = r9
            float r9 = (float) r5
            r26 = r15
            float r15 = r11 * r9
            double r1 = (double) r15
            r27 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r1 = r1 + r27
            int r1 = (int) r1
            float r2 = (float) r12
            float r15 = r11 * r2
            r29 = r7
            double r6 = (double) r15
            double r6 = r6 + r27
            int r6 = (int) r6
            int r1 = r5 / r1
            int r6 = r12 / r6
            int r7 = com.bumptech.glide.load.d.a.n.g.MEMORY$3973276c     // Catch:{ all -> 0x02f2 }
            if (r14 != r7) goto L_0x0137
            int r1 = java.lang.Math.max(r1, r6)     // Catch:{ all -> 0x02f2 }
            goto L_0x013b
        L_0x0137:
            int r1 = java.lang.Math.min(r1, r6)     // Catch:{ all -> 0x02f2 }
        L_0x013b:
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x02f2 }
            r7 = 23
            if (r6 > r7) goto L_0x014d
            java.util.Set<java.lang.String> r6 = i     // Catch:{ all -> 0x02f2 }
            java.lang.String r7 = r8.outMimeType     // Catch:{ all -> 0x02f2 }
            boolean r6 = r6.contains(r7)     // Catch:{ all -> 0x02f2 }
            if (r6 == 0) goto L_0x014d
            r14 = 1
            goto L_0x0165
        L_0x014d:
            int r1 = java.lang.Integer.highestOneBit(r1)     // Catch:{ all -> 0x02f2 }
            r6 = 1
            int r1 = java.lang.Math.max(r6, r1)     // Catch:{ all -> 0x02f2 }
            int r6 = com.bumptech.glide.load.d.a.n.g.MEMORY$3973276c     // Catch:{ all -> 0x02f2 }
            if (r14 != r6) goto L_0x0164
            float r6 = (float) r1     // Catch:{ all -> 0x02f2 }
            float r7 = r24 / r11
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 >= 0) goto L_0x0164
            int r14 = r1 << 1
            goto L_0x0165
        L_0x0164:
            r14 = r1
        L_0x0165:
            r8.inSampleSize = r14     // Catch:{ all -> 0x02f2 }
            com.bumptech.glide.load.ImageHeaderParser$ImageType r1 = com.bumptech.glide.load.ImageHeaderParser.ImageType.JPEG     // Catch:{ all -> 0x02f2 }
            if (r4 != r1) goto L_0x0194
            r1 = 8
            int r1 = java.lang.Math.min(r14, r1)     // Catch:{ all -> 0x02f2 }
            float r1 = (float) r1     // Catch:{ all -> 0x02f2 }
            float r9 = r9 / r1
            double r6 = (double) r9     // Catch:{ all -> 0x02f2 }
            double r6 = java.lang.Math.ceil(r6)     // Catch:{ all -> 0x02f2 }
            int r6 = (int) r6     // Catch:{ all -> 0x02f2 }
            float r2 = r2 / r1
            double r1 = (double) r2     // Catch:{ all -> 0x02f2 }
            double r1 = java.lang.Math.ceil(r1)     // Catch:{ all -> 0x02f2 }
            int r1 = (int) r1     // Catch:{ all -> 0x02f2 }
            int r2 = r14 / 8
            if (r2 <= 0) goto L_0x0186
            int r6 = r6 / r2
            int r1 = r1 / r2
        L_0x0186:
            r2 = r1
            r9 = r6
            r30 = r11
            r31 = r12
            r12 = r29
            r1 = r35
            r6 = r39
            goto L_0x0202
        L_0x0194:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r1 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG     // Catch:{ all -> 0x02f2 }
            if (r4 == r1) goto L_0x01e9
            com.bumptech.glide.load.ImageHeaderParser$ImageType r1 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG_A     // Catch:{ all -> 0x02f2 }
            if (r4 != r1) goto L_0x019d
            goto L_0x01e9
        L_0x019d:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r1 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ all -> 0x02f2 }
            if (r4 == r1) goto L_0x01c3
            com.bumptech.glide.load.ImageHeaderParser$ImageType r1 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A     // Catch:{ all -> 0x02f2 }
            if (r4 != r1) goto L_0x01a6
            goto L_0x01c3
        L_0x01a6:
            int r1 = r5 % r14
            if (r1 != 0) goto L_0x01b4
            int r1 = r12 % r14
            if (r1 == 0) goto L_0x01af
            goto L_0x01b4
        L_0x01af:
            int r6 = r5 / r14
            int r1 = r12 / r14
            goto L_0x0186
        L_0x01b4:
            r1 = r35
            r6 = r39
            int[] r2 = a((java.io.InputStream) r1, (android.graphics.BitmapFactory.Options) r8, (com.bumptech.glide.load.d.a.o.a) r6, (com.bumptech.glide.load.b.a.e) r13)     // Catch:{ all -> 0x02f2 }
            r7 = 0
            r9 = r2[r7]     // Catch:{ all -> 0x02f2 }
            r7 = 1
            r2 = r2[r7]     // Catch:{ all -> 0x02f2 }
            goto L_0x01d8
        L_0x01c3:
            r1 = r35
            r6 = r39
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x02f2 }
            r13 = 24
            if (r7 < r13) goto L_0x01dd
            float r7 = (float) r14     // Catch:{ all -> 0x02f2 }
            float r9 = r9 / r7
            int r9 = java.lang.Math.round(r9)     // Catch:{ all -> 0x02f2 }
            float r2 = r2 / r7
            int r2 = java.lang.Math.round(r2)     // Catch:{ all -> 0x02f2 }
        L_0x01d8:
            r30 = r11
            r31 = r12
            goto L_0x0200
        L_0x01dd:
            float r7 = (float) r14     // Catch:{ all -> 0x02f2 }
            float r9 = r9 / r7
            r30 = r11
            r31 = r12
            double r11 = (double) r9     // Catch:{ all -> 0x02f2 }
            double r11 = java.lang.Math.floor(r11)     // Catch:{ all -> 0x02f2 }
            goto L_0x01f8
        L_0x01e9:
            r30 = r11
            r31 = r12
            r1 = r35
            r6 = r39
            float r7 = (float) r14     // Catch:{ all -> 0x02f2 }
            float r9 = r9 / r7
            double r11 = (double) r9     // Catch:{ all -> 0x02f2 }
            double r11 = java.lang.Math.floor(r11)     // Catch:{ all -> 0x02f2 }
        L_0x01f8:
            int r9 = (int) r11     // Catch:{ all -> 0x02f2 }
            float r2 = r2 / r7
            double r11 = (double) r2     // Catch:{ all -> 0x02f2 }
            double r11 = java.lang.Math.floor(r11)     // Catch:{ all -> 0x02f2 }
            int r2 = (int) r11     // Catch:{ all -> 0x02f2 }
        L_0x0200:
            r12 = r29
        L_0x0202:
            float r7 = r10.a(r9, r2, r3, r12)     // Catch:{ all -> 0x02f2 }
            double r10 = (double) r7     // Catch:{ all -> 0x02f2 }
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x02f2 }
            r13 = 19
            if (r7 < r13) goto L_0x022e
            int r7 = b((double) r10)     // Catch:{ all -> 0x02f2 }
            r32 = r14
            double r13 = (double) r7     // Catch:{ all -> 0x02f2 }
            double r13 = r13 * r10
            double r13 = r13 + r27
            int r13 = (int) r13     // Catch:{ all -> 0x02f2 }
            float r14 = (float) r13     // Catch:{ all -> 0x02f2 }
            float r7 = (float) r7     // Catch:{ all -> 0x02f2 }
            float r14 = r14 / r7
            double r14 = (double) r14     // Catch:{ all -> 0x02f2 }
            double r14 = r10 / r14
            double r6 = (double) r13     // Catch:{ all -> 0x02f2 }
            double r14 = r14 * r6
            double r14 = r14 + r27
            int r6 = (int) r14     // Catch:{ all -> 0x02f2 }
            r8.inTargetDensity = r6     // Catch:{ all -> 0x02f2 }
            int r6 = b((double) r10)     // Catch:{ all -> 0x02f2 }
            r8.inDensity = r6     // Catch:{ all -> 0x02f2 }
            goto L_0x0230
        L_0x022e:
            r32 = r14
        L_0x0230:
            boolean r6 = a((android.graphics.BitmapFactory.Options) r8)     // Catch:{ all -> 0x02f2 }
            if (r6 == 0) goto L_0x023a
            r6 = 1
            r8.inScaled = r6     // Catch:{ all -> 0x02f2 }
            goto L_0x023f
        L_0x023a:
            r6 = 0
            r8.inTargetDensity = r6     // Catch:{ all -> 0x02f2 }
            r8.inDensity = r6     // Catch:{ all -> 0x02f2 }
        L_0x023f:
            java.lang.String r6 = "Downsampler"
            r7 = 2
            boolean r6 = android.util.Log.isLoggable(r6, r7)     // Catch:{ all -> 0x02f2 }
            if (r6 == 0) goto L_0x02b6
            java.lang.String r6 = "Downsampler"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x02f2 }
            java.lang.String r13 = "Calculate scaling, source: ["
            r7.<init>(r13)     // Catch:{ all -> 0x02f2 }
            r7.append(r5)     // Catch:{ all -> 0x02f2 }
            java.lang.String r13 = "x"
            r7.append(r13)     // Catch:{ all -> 0x02f2 }
            r13 = r31
            r7.append(r13)     // Catch:{ all -> 0x02f2 }
            java.lang.String r14 = "], target: ["
            r7.append(r14)     // Catch:{ all -> 0x02f2 }
            r7.append(r3)     // Catch:{ all -> 0x02f2 }
            java.lang.String r14 = "x"
            r7.append(r14)     // Catch:{ all -> 0x02f2 }
            r7.append(r12)     // Catch:{ all -> 0x02f2 }
            java.lang.String r14 = "], power of two scaled: ["
            r7.append(r14)     // Catch:{ all -> 0x02f2 }
            r7.append(r9)     // Catch:{ all -> 0x02f2 }
            java.lang.String r9 = "x"
            r7.append(r9)     // Catch:{ all -> 0x02f2 }
            r7.append(r2)     // Catch:{ all -> 0x02f2 }
            java.lang.String r2 = "], exact scale factor: "
            r7.append(r2)     // Catch:{ all -> 0x02f2 }
            r2 = r30
            r7.append(r2)     // Catch:{ all -> 0x02f2 }
            java.lang.String r2 = ", power of 2 sample size: "
            r7.append(r2)     // Catch:{ all -> 0x02f2 }
            r14 = r32
            r7.append(r14)     // Catch:{ all -> 0x02f2 }
            java.lang.String r2 = ", adjusted scale factor: "
            r7.append(r2)     // Catch:{ all -> 0x02f2 }
            r7.append(r10)     // Catch:{ all -> 0x02f2 }
            java.lang.String r2 = ", target density: "
            r7.append(r2)     // Catch:{ all -> 0x02f2 }
            int r2 = r8.inTargetDensity     // Catch:{ all -> 0x02f2 }
            r7.append(r2)     // Catch:{ all -> 0x02f2 }
            java.lang.String r2 = ", density: "
            r7.append(r2)     // Catch:{ all -> 0x02f2 }
            int r2 = r8.inDensity     // Catch:{ all -> 0x02f2 }
            r7.append(r2)     // Catch:{ all -> 0x02f2 }
            java.lang.String r2 = r7.toString()     // Catch:{ all -> 0x02f2 }
            android.util.Log.v(r6, r2)     // Catch:{ all -> 0x02f2 }
            goto L_0x02fa
        L_0x02b6:
            r13 = r31
            goto L_0x02fa
        L_0x02b9:
            r1 = r2
            r25 = r9
            r13 = r12
            r26 = r15
            r12 = r7
            java.lang.String r2 = "Downsampler"
            r6 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r6)     // Catch:{ all -> 0x0527 }
            if (r2 == 0) goto L_0x02fa
            java.lang.String r2 = "Downsampler"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x02f2 }
            java.lang.String r7 = "Unable to determine dimensions for: "
            r6.<init>(r7)     // Catch:{ all -> 0x02f2 }
            r6.append(r4)     // Catch:{ all -> 0x02f2 }
            java.lang.String r7 = " with target ["
            r6.append(r7)     // Catch:{ all -> 0x02f2 }
            r6.append(r3)     // Catch:{ all -> 0x02f2 }
            java.lang.String r7 = "x"
            r6.append(r7)     // Catch:{ all -> 0x02f2 }
            r6.append(r12)     // Catch:{ all -> 0x02f2 }
            java.lang.String r7 = "]"
            r6.append(r7)     // Catch:{ all -> 0x02f2 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x02f2 }
            android.util.Log.d(r2, r6)     // Catch:{ all -> 0x02f2 }
            goto L_0x02fa
        L_0x02f2:
            r0 = move-exception
            r1 = r0
            r7 = r18
            r2 = r34
            goto L_0x0535
        L_0x02fa:
            r2 = r34
            com.bumptech.glide.load.d.a.t r6 = r2.q     // Catch:{ all -> 0x0525 }
            r7 = 26
            if (r17 == 0) goto L_0x032a
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0324 }
            if (r9 < r7) goto L_0x032a
            if (r26 == 0) goto L_0x0309
            goto L_0x032a
        L_0x0309:
            r9 = 128(0x80, float:1.794E-43)
            if (r3 < r9) goto L_0x0317
            if (r12 < r9) goto L_0x0317
            boolean r6 = r6.b()     // Catch:{ all -> 0x0324 }
            if (r6 == 0) goto L_0x0317
            r6 = 1
            goto L_0x0318
        L_0x0317:
            r6 = 0
        L_0x0318:
            if (r6 == 0) goto L_0x0322
            android.graphics.Bitmap$Config r9 = android.graphics.Bitmap.Config.HARDWARE     // Catch:{ all -> 0x0324 }
            r8.inPreferredConfig = r9     // Catch:{ all -> 0x0324 }
            r9 = 0
            r8.inMutable = r9     // Catch:{ all -> 0x0324 }
            goto L_0x032c
        L_0x0322:
            r9 = 0
            goto L_0x032c
        L_0x0324:
            r0 = move-exception
            r1 = r0
            r7 = r18
            goto L_0x0535
        L_0x032a:
            r9 = 0
            r6 = 0
        L_0x032c:
            if (r6 != 0) goto L_0x037e
            com.bumptech.glide.load.b r6 = com.bumptech.glide.load.b.PREFER_ARGB_8888     // Catch:{ all -> 0x0324 }
            r10 = r25
            if (r10 == r6) goto L_0x037a
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0324 }
            r11 = 16
            if (r6 != r11) goto L_0x033b
            goto L_0x037a
        L_0x033b:
            java.util.List<com.bumptech.glide.load.ImageHeaderParser> r6 = r2.p     // Catch:{ IOException -> 0x0348 }
            com.bumptech.glide.load.b.a.b r11 = r2.o     // Catch:{ IOException -> 0x0348 }
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.f.a(r6, r1, r11)     // Catch:{ IOException -> 0x0348 }
            boolean r6 = r6.hasAlpha()     // Catch:{ IOException -> 0x0348 }
            goto L_0x0367
        L_0x0348:
            r0 = move-exception
            r6 = r0
            java.lang.String r11 = "Downsampler"
            r14 = 3
            boolean r11 = android.util.Log.isLoggable(r11, r14)     // Catch:{ all -> 0x0324 }
            if (r11 == 0) goto L_0x0366
            java.lang.String r11 = "Downsampler"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0324 }
            java.lang.String r15 = "Cannot determine whether the image has alpha or not from header, format "
            r14.<init>(r15)     // Catch:{ all -> 0x0324 }
            r14.append(r10)     // Catch:{ all -> 0x0324 }
            java.lang.String r10 = r14.toString()     // Catch:{ all -> 0x0324 }
            android.util.Log.d(r11, r10, r6)     // Catch:{ all -> 0x0324 }
        L_0x0366:
            r6 = 0
        L_0x0367:
            if (r6 == 0) goto L_0x036c
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x0324 }
            goto L_0x036e
        L_0x036c:
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ all -> 0x0324 }
        L_0x036e:
            r8.inPreferredConfig = r6     // Catch:{ all -> 0x0324 }
            android.graphics.Bitmap$Config r6 = r8.inPreferredConfig     // Catch:{ all -> 0x0324 }
            android.graphics.Bitmap$Config r10 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ all -> 0x0324 }
            if (r6 != r10) goto L_0x037e
            r6 = 1
            r8.inDither = r6     // Catch:{ all -> 0x0324 }
            goto L_0x037e
        L_0x037a:
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x0324 }
            r8.inPreferredConfig = r6     // Catch:{ all -> 0x0324 }
        L_0x037e:
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0525 }
            r10 = 19
            if (r6 < r10) goto L_0x0385
            r9 = 1
        L_0x0385:
            int r6 = r8.inSampleSize     // Catch:{ all -> 0x0525 }
            r10 = 0
            r11 = 1
            if (r6 == r11) goto L_0x038d
            if (r9 == 0) goto L_0x0453
        L_0x038d:
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0525 }
            r14 = 19
            if (r6 < r14) goto L_0x0394
            goto L_0x039b
        L_0x0394:
            java.util.Set<com.bumptech.glide.load.ImageHeaderParser$ImageType> r6 = j     // Catch:{ all -> 0x0525 }
            boolean r14 = r6.contains(r4)     // Catch:{ all -> 0x0525 }
            r11 = r14
        L_0x039b:
            if (r11 == 0) goto L_0x0453
            if (r5 < 0) goto L_0x03a8
            if (r13 < 0) goto L_0x03a8
            if (r23 == 0) goto L_0x03a8
            if (r9 == 0) goto L_0x03a8
            r9 = r12
            goto L_0x0435
        L_0x03a8:
            boolean r3 = a((android.graphics.BitmapFactory.Options) r8)     // Catch:{ all -> 0x0324 }
            if (r3 == 0) goto L_0x03b9
            int r3 = r8.inTargetDensity     // Catch:{ all -> 0x0324 }
            float r3 = (float) r3     // Catch:{ all -> 0x0324 }
            int r4 = r8.inDensity     // Catch:{ all -> 0x0324 }
            float r4 = (float) r4     // Catch:{ all -> 0x0324 }
            float r24 = r3 / r4
            r3 = r24
            goto L_0x03bb
        L_0x03b9:
            r3 = 1065353216(0x3f800000, float:1.0)
        L_0x03bb:
            int r4 = r8.inSampleSize     // Catch:{ all -> 0x0324 }
            float r6 = (float) r5     // Catch:{ all -> 0x0324 }
            float r9 = (float) r4     // Catch:{ all -> 0x0324 }
            float r6 = r6 / r9
            double r11 = (double) r6     // Catch:{ all -> 0x0324 }
            double r11 = java.lang.Math.ceil(r11)     // Catch:{ all -> 0x0324 }
            int r6 = (int) r11     // Catch:{ all -> 0x0324 }
            float r11 = (float) r13     // Catch:{ all -> 0x0324 }
            float r11 = r11 / r9
            double r11 = (double) r11     // Catch:{ all -> 0x0324 }
            double r11 = java.lang.Math.ceil(r11)     // Catch:{ all -> 0x0324 }
            int r9 = (int) r11     // Catch:{ all -> 0x0324 }
            float r6 = (float) r6     // Catch:{ all -> 0x0324 }
            float r6 = r6 * r3
            int r6 = java.lang.Math.round(r6)     // Catch:{ all -> 0x0324 }
            float r9 = (float) r9     // Catch:{ all -> 0x0324 }
            float r9 = r9 * r3
            int r9 = java.lang.Math.round(r9)     // Catch:{ all -> 0x0324 }
            java.lang.String r11 = "Downsampler"
            r12 = 2
            boolean r11 = android.util.Log.isLoggable(r11, r12)     // Catch:{ all -> 0x0324 }
            if (r11 == 0) goto L_0x0434
            java.lang.String r11 = "Downsampler"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0324 }
            java.lang.String r14 = "Calculated target ["
            r12.<init>(r14)     // Catch:{ all -> 0x0324 }
            r12.append(r6)     // Catch:{ all -> 0x0324 }
            java.lang.String r14 = "x"
            r12.append(r14)     // Catch:{ all -> 0x0324 }
            r12.append(r9)     // Catch:{ all -> 0x0324 }
            java.lang.String r14 = "] for source ["
            r12.append(r14)     // Catch:{ all -> 0x0324 }
            r12.append(r5)     // Catch:{ all -> 0x0324 }
            java.lang.String r14 = "x"
            r12.append(r14)     // Catch:{ all -> 0x0324 }
            r12.append(r13)     // Catch:{ all -> 0x0324 }
            java.lang.String r14 = "], sampleSize: "
            r12.append(r14)     // Catch:{ all -> 0x0324 }
            r12.append(r4)     // Catch:{ all -> 0x0324 }
            java.lang.String r4 = ", targetDensity: "
            r12.append(r4)     // Catch:{ all -> 0x0324 }
            int r4 = r8.inTargetDensity     // Catch:{ all -> 0x0324 }
            r12.append(r4)     // Catch:{ all -> 0x0324 }
            java.lang.String r4 = ", density: "
            r12.append(r4)     // Catch:{ all -> 0x0324 }
            int r4 = r8.inDensity     // Catch:{ all -> 0x0324 }
            r12.append(r4)     // Catch:{ all -> 0x0324 }
            java.lang.String r4 = ", density multiplier: "
            r12.append(r4)     // Catch:{ all -> 0x0324 }
            r12.append(r3)     // Catch:{ all -> 0x0324 }
            java.lang.String r3 = r12.toString()     // Catch:{ all -> 0x0324 }
            android.util.Log.v(r11, r3)     // Catch:{ all -> 0x0324 }
        L_0x0434:
            r3 = r6
        L_0x0435:
            if (r3 <= 0) goto L_0x0453
            if (r9 <= 0) goto L_0x0453
            com.bumptech.glide.load.b.a.e r4 = r2.m     // Catch:{ all -> 0x0324 }
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0324 }
            if (r6 < r7) goto L_0x0448
            android.graphics.Bitmap$Config r6 = r8.inPreferredConfig     // Catch:{ all -> 0x0324 }
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.HARDWARE     // Catch:{ all -> 0x0324 }
            if (r6 == r7) goto L_0x0453
            android.graphics.Bitmap$Config r6 = r8.outConfig     // Catch:{ all -> 0x0324 }
            goto L_0x0449
        L_0x0448:
            r6 = r10
        L_0x0449:
            if (r6 != 0) goto L_0x044d
            android.graphics.Bitmap$Config r6 = r8.inPreferredConfig     // Catch:{ all -> 0x0324 }
        L_0x044d:
            android.graphics.Bitmap r3 = r4.b(r3, r9, r6)     // Catch:{ all -> 0x0324 }
            r8.inBitmap = r3     // Catch:{ all -> 0x0324 }
        L_0x0453:
            com.bumptech.glide.load.b.a.e r3 = r2.m     // Catch:{ all -> 0x0525 }
            r4 = r39
            android.graphics.Bitmap r1 = b(r1, r8, r4, r3)     // Catch:{ all -> 0x0525 }
            com.bumptech.glide.load.b.a.e r3 = r2.m     // Catch:{ all -> 0x0525 }
            r4.a(r3, r1)     // Catch:{ all -> 0x0525 }
            java.lang.String r3 = "Downsampler"
            r4 = 2
            boolean r3 = android.util.Log.isLoggable(r3, r4)     // Catch:{ all -> 0x0525 }
            if (r3 == 0) goto L_0x04f8
            java.lang.String r3 = "Downsampler"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0324 }
            java.lang.String r6 = "Decoded "
            r4.<init>(r6)     // Catch:{ all -> 0x0324 }
            java.lang.String r6 = a((android.graphics.Bitmap) r1)     // Catch:{ all -> 0x0324 }
            r4.append(r6)     // Catch:{ all -> 0x0324 }
            java.lang.String r6 = " from ["
            r4.append(r6)     // Catch:{ all -> 0x0324 }
            r4.append(r5)     // Catch:{ all -> 0x0324 }
            java.lang.String r5 = "x"
            r4.append(r5)     // Catch:{ all -> 0x0324 }
            r4.append(r13)     // Catch:{ all -> 0x0324 }
            java.lang.String r5 = "] "
            r4.append(r5)     // Catch:{ all -> 0x0324 }
            r5 = r22
            r4.append(r5)     // Catch:{ all -> 0x0324 }
            java.lang.String r5 = " with inBitmap "
            r4.append(r5)     // Catch:{ all -> 0x0324 }
            android.graphics.Bitmap r5 = r8.inBitmap     // Catch:{ all -> 0x0324 }
            java.lang.String r5 = a((android.graphics.Bitmap) r5)     // Catch:{ all -> 0x0324 }
            r4.append(r5)     // Catch:{ all -> 0x0324 }
            java.lang.String r5 = " for ["
            r4.append(r5)     // Catch:{ all -> 0x0324 }
            r5 = r36
            r4.append(r5)     // Catch:{ all -> 0x0324 }
            java.lang.String r5 = "x"
            r4.append(r5)     // Catch:{ all -> 0x0324 }
            r5 = r37
            r4.append(r5)     // Catch:{ all -> 0x0324 }
            java.lang.String r5 = "], sample size: "
            r4.append(r5)     // Catch:{ all -> 0x0324 }
            int r5 = r8.inSampleSize     // Catch:{ all -> 0x0324 }
            r4.append(r5)     // Catch:{ all -> 0x0324 }
            java.lang.String r5 = ", density: "
            r4.append(r5)     // Catch:{ all -> 0x0324 }
            int r5 = r8.inDensity     // Catch:{ all -> 0x0324 }
            r4.append(r5)     // Catch:{ all -> 0x0324 }
            java.lang.String r5 = ", target density: "
            r4.append(r5)     // Catch:{ all -> 0x0324 }
            int r5 = r8.inTargetDensity     // Catch:{ all -> 0x0324 }
            r4.append(r5)     // Catch:{ all -> 0x0324 }
            java.lang.String r5 = ", thread: "
            r4.append(r5)     // Catch:{ all -> 0x0324 }
            java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0324 }
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x0324 }
            r4.append(r5)     // Catch:{ all -> 0x0324 }
            java.lang.String r5 = ", duration: "
            r4.append(r5)     // Catch:{ all -> 0x0324 }
            r5 = r19
            double r5 = com.bumptech.glide.util.e.a(r5)     // Catch:{ all -> 0x0324 }
            r4.append(r5)     // Catch:{ all -> 0x0324 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0324 }
            android.util.Log.v(r3, r4)     // Catch:{ all -> 0x0324 }
        L_0x04f8:
            if (r1 == 0) goto L_0x0514
            android.util.DisplayMetrics r3 = r2.n     // Catch:{ all -> 0x0324 }
            int r3 = r3.densityDpi     // Catch:{ all -> 0x0324 }
            r1.setDensity(r3)     // Catch:{ all -> 0x0324 }
            com.bumptech.glide.load.b.a.e r3 = r2.m     // Catch:{ all -> 0x0324 }
            r4 = r21
            android.graphics.Bitmap r10 = com.bumptech.glide.load.d.a.z.a((com.bumptech.glide.load.b.a.e) r3, (android.graphics.Bitmap) r1, (int) r4)     // Catch:{ all -> 0x0324 }
            boolean r3 = r1.equals(r10)     // Catch:{ all -> 0x0324 }
            if (r3 != 0) goto L_0x0514
            com.bumptech.glide.load.b.a.e r3 = r2.m     // Catch:{ all -> 0x0324 }
            r3.a((android.graphics.Bitmap) r1)     // Catch:{ all -> 0x0324 }
        L_0x0514:
            com.bumptech.glide.load.b.a.e r1 = r2.m     // Catch:{ all -> 0x0525 }
            com.bumptech.glide.load.d.a.f r1 = com.bumptech.glide.load.d.a.f.a(r10, r1)     // Catch:{ all -> 0x0525 }
            c((android.graphics.BitmapFactory.Options) r8)
            com.bumptech.glide.load.b.a.b r3 = r2.o
            r7 = r18
            r3.b(r7)
            return r1
        L_0x0525:
            r0 = move-exception
            goto L_0x052f
        L_0x0527:
            r0 = move-exception
            r7 = r18
            r2 = r34
            goto L_0x0534
        L_0x052d:
            r0 = move-exception
            r2 = r1
        L_0x052f:
            r7 = r18
            goto L_0x0534
        L_0x0532:
            r0 = move-exception
            r2 = r1
        L_0x0534:
            r1 = r0
        L_0x0535:
            c((android.graphics.BitmapFactory.Options) r8)
            com.bumptech.glide.load.b.a.b r3 = r2.o
            r3.b(r7)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.d.a.o.a(java.io.InputStream, int, int, com.bumptech.glide.load.j, com.bumptech.glide.load.d.a.o$a):com.bumptech.glide.load.b.u");
    }
}
