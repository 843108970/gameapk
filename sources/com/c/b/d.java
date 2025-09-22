package com.c.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.view.View;
import android.widget.ImageView;
import com.c.d.a;
import com.c.d.b;
import com.c.d.c;
import com.c.d.g;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.http.HttpHost;

public final class d extends a<Bitmap, d> {
    private static int A = 20;
    private static int B = 2500;
    private static int C = 160000;
    private static int D = 1000000;
    private static boolean E = false;
    private static Map<String, Bitmap> F = null;
    private static Map<String, Bitmap> G = null;
    private static Map<String, Bitmap> H = null;
    private static HashMap<String, WeakHashMap<ImageView, d>> I = new HashMap<>();
    private static Bitmap R = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
    private static Bitmap S = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
    private static final int T = 300;
    private static int z = 20;
    private WeakReference<ImageView> J;
    private int K;
    private Bitmap L;
    private int M;
    private boolean N = true;
    private float O = Float.MAX_VALUE;
    private boolean P;
    private boolean Q;
    public int u;
    public int v;
    public File w;
    public Bitmap x;
    public float y;

    public d() {
        this.f1538b = Bitmap.class;
        ((d) ((d) b(true)).a(true)).f1539c = "";
    }

    private static int a(int i, int i2) {
        int i3 = 1;
        for (int i4 = 0; i4 < 10 && i >= i2 * 2; i4++) {
            i /= 2;
            i3 *= 2;
        }
        return i3;
    }

    public static Bitmap a(Context context, int i) {
        String num = Integer.toString(i);
        Bitmap a2 = a(num, 0, 0);
        if (a2 == null && (a2 = BitmapFactory.decodeResource(context.getResources(), i)) != null) {
            a(num, 0, 0, a2, false);
        }
        return a2;
    }

    private static Bitmap a(Bitmap bitmap, int i) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        float f = (float) i;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    private static Bitmap a(View view, Bitmap bitmap, int i) {
        int i2;
        if (bitmap != null && bitmap.getWidth() == 1 && bitmap.getHeight() == 1 && bitmap != R) {
            bitmap = null;
        }
        if (bitmap != null) {
            i2 = 0;
        } else if (i == -2) {
            i2 = 8;
        } else if (i != -1) {
            return bitmap;
        } else {
            i2 = 4;
        }
        view.setVisibility(i2);
        return bitmap;
    }

    private static Bitmap a(String str, int i, int i2) {
        String b2 = b(str, i, i2);
        Bitmap bitmap = h().get(b2);
        if (bitmap == null) {
            bitmap = i().get(b2);
        }
        if (bitmap != null) {
            return bitmap;
        }
        Bitmap bitmap2 = j().get(b2);
        if (bitmap2 == null || a.t != 200) {
            return bitmap2;
        }
        H = null;
        return null;
    }

    private static Bitmap a(String str, Bitmap bitmap) {
        int i;
        if (bitmap == null) {
            return null;
        }
        try {
            i = new ExifInterface(str).getAttributeInt("Orientation", 1);
        } catch (Exception e) {
            a.a((Throwable) e);
            i = 1;
        }
        if (i <= 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
        matrix.postScale(-1.0f, 1.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        a.b((Object) "before", (Object) String.valueOf(bitmap.getWidth()) + ":" + bitmap.getHeight());
        a.b((Object) "after", (Object) String.valueOf(createBitmap.getWidth()) + ":" + createBitmap.getHeight());
        if (bitmap == createBitmap) {
            return createBitmap;
        }
        bitmap.recycle();
        return createBitmap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        r3 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002a A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x0012] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap a(java.lang.String r3, android.graphics.BitmapFactory.Options r4, boolean r5) {
        /*
            if (r4 != 0) goto L_0x0007
            android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options
            r4.<init>()
        L_0x0007:
            r0 = 1
            r4.inInputShareable = r0
            r4.inPurgeable = r0
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0033 }
            r1.<init>(r3)     // Catch:{ IOException -> 0x0033 }
            java.io.FileDescriptor r2 = r1.getFD()     // Catch:{ IOException -> 0x002d, all -> 0x002a }
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeFileDescriptor(r2, r0, r4)     // Catch:{ IOException -> 0x002d, all -> 0x002a }
            if (r4 == 0) goto L_0x0025
            if (r5 == 0) goto L_0x0025
            android.graphics.Bitmap r3 = a((java.lang.String) r3, (android.graphics.Bitmap) r4)     // Catch:{ IOException -> 0x0023, all -> 0x002a }
            goto L_0x0026
        L_0x0023:
            r3 = move-exception
            goto L_0x002f
        L_0x0025:
            r3 = r4
        L_0x0026:
            com.c.d.a.a((java.io.Closeable) r1)
            return r3
        L_0x002a:
            r3 = move-exception
            r0 = r1
            goto L_0x003d
        L_0x002d:
            r3 = move-exception
            r4 = r0
        L_0x002f:
            r0 = r1
            goto L_0x0035
        L_0x0031:
            r3 = move-exception
            goto L_0x003d
        L_0x0033:
            r3 = move-exception
            r4 = r0
        L_0x0035:
            com.c.d.a.b((java.lang.Throwable) r3)     // Catch:{ all -> 0x0031 }
            com.c.d.a.a((java.io.Closeable) r0)
            r3 = r4
            return r3
        L_0x003d:
            com.c.d.a.a((java.io.Closeable) r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.d.a(java.lang.String, android.graphics.BitmapFactory$Options, boolean):android.graphics.Bitmap");
    }

    private Bitmap a(String str, byte[] bArr) {
        return a(str, bArr, this.u, this.N, this.M, this.Q);
    }

    private static Bitmap a(String str, byte[] bArr, int i, boolean z2, int i2, boolean z3) {
        BitmapFactory.Options options;
        Bitmap bitmap;
        if (str == null && bArr == null) {
            return null;
        }
        if (i > 0) {
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = true;
            a(str, bArr, options2, z3);
            int i3 = options2.outWidth;
            if (!z2) {
                i3 = Math.max(i3, options2.outHeight);
            }
            int a2 = a(i3, i);
            options = new BitmapFactory.Options();
            options.inSampleSize = a2;
        } else {
            options = null;
        }
        try {
            bitmap = a(str, bArr, options, z3);
        } catch (OutOfMemoryError e) {
            g();
            a.b((Throwable) e);
            bitmap = null;
        }
        if (i2 <= 0) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        float f = (float) i2;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    private static Bitmap a(String str, byte[] bArr, BitmapFactory.Options options, boolean z2) {
        Bitmap a2 = str != null ? a(str, options, z2) : bArr != null ? BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options) : null;
        if (a2 == null && options != null && !options.inJustDecodeBounds) {
            a.b((Object) "decode image failed", (Object) str);
        }
        return a2;
    }

    private static Drawable a(ImageView imageView, Bitmap bitmap, float f, float f2) {
        return f > 0.0f ? new g(imageView.getResources(), bitmap, imageView, f, f2) : new BitmapDrawable(imageView.getResources(), bitmap);
    }

    private d a(float f) {
        this.y = f;
        return this;
    }

    private d a(int i) {
        this.u = i;
        return this;
    }

    private d a(Bitmap bitmap) {
        this.L = bitmap;
        return this;
    }

    private d a(File file) {
        this.w = file;
        return this;
    }

    public static void a(Activity activity, Context context, ImageView imageView, String str, Object obj, com.c.a.a aVar, e eVar, HttpHost httpHost) {
        e eVar2 = eVar;
        a(activity, context, imageView, str, eVar2.f1546a, eVar2.f1547b, eVar2.e, eVar2.f, eVar2.f1548c, eVar2.g, eVar2.h, eVar2.j, obj, aVar, eVar2.d, eVar2.i, httpHost);
    }

    public static void a(Activity activity, Context context, ImageView imageView, String str, boolean z2, boolean z3, int i, int i2, Bitmap bitmap, int i3, float f, float f2, Object obj, com.c.a.a aVar, int i4, int i5, HttpHost httpHost) {
        Activity activity2 = activity;
        ImageView imageView2 = imageView;
        String str2 = str;
        boolean z4 = z2;
        int i6 = i;
        Object obj2 = obj;
        int i7 = i5;
        Bitmap a2 = z4 ? a(str2, i6, i7) : null;
        if (a2 != null) {
            imageView2.setTag(com.c.d.d.y, str2);
            c.a(obj2, str2, false);
            a(imageView2, a2, bitmap, i2, i3, f, f2, 4);
            return;
        }
        d dVar = new d();
        dVar.f1539c = str2;
        d dVar2 = (d) ((d) dVar.a(imageView2).b(z4)).a(z3);
        dVar2.u = i6;
        dVar2.v = i2;
        dVar2.L = bitmap;
        dVar2.K = i3;
        dVar2.y = f;
        dVar2.O = f2;
        d dVar3 = (d) ((d) dVar2.a(obj2)).a(aVar);
        dVar3.j = i4;
        d dVar4 = dVar3;
        dVar4.M = i7;
        dVar4.d = null;
        if (httpHost != null) {
            dVar.a(httpHost.getHostName(), httpHost.getPort());
        }
        if (activity2 != null) {
            dVar.a(activity2);
        } else {
            dVar.a(context);
        }
    }

    private void a(ImageView imageView, Bitmap bitmap) {
        a(imageView, bitmap, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0038, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003b, code lost:
        if (r11 == 3) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003e, code lost:
        if (r11 == 1) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0041, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0042, code lost:
        if (r7 == false) goto L_0x0075;
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0044, code lost:
        if (r6 != null) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0046, code lost:
        r6 = new android.view.animation.AlphaAnimation(0.0f, 1.0f);
        r6.setInterpolator(new android.view.animation.DecelerateInterpolator());
        r6.setDuration(300);
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005c, code lost:
        r5 = new android.graphics.drawable.TransitionDrawable(new android.graphics.drawable.Drawable[]{a(r4, r6, r9, r10), r5});
        r5.setCrossFadeEnabled(true);
        r5.startTransition(T);
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0075, code lost:
        if (r8 <= 0) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0077, code lost:
        r6 = android.view.animation.AnimationUtils.loadAnimation(r4.getContext(), r8);
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0080, code lost:
        r6 = null;
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0081, code lost:
        r4.setImageDrawable(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0084, code lost:
        if (r6 == null) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0086, code lost:
        r6.setStartTime(android.view.animation.AnimationUtils.currentAnimationTimeMillis());
        r4.startAnimation(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0090, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0091, code lost:
        r4.setAnimation((android.view.animation.Animation) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0094, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.widget.ImageView r4, android.graphics.Bitmap r5, android.graphics.Bitmap r6, int r7, int r8, float r9, float r10, int r11) {
        /*
            r0 = 0
            r1 = 1
            if (r5 == 0) goto L_0x0015
            int r2 = r5.getWidth()
            if (r2 != r1) goto L_0x0015
            int r2 = r5.getHeight()
            if (r2 != r1) goto L_0x0015
            android.graphics.Bitmap r2 = R
            if (r5 == r2) goto L_0x0015
            r5 = r0
        L_0x0015:
            r2 = 0
            if (r5 == 0) goto L_0x001c
            r4.setVisibility(r2)
            goto L_0x002a
        L_0x001c:
            r3 = -2
            if (r7 != r3) goto L_0x0025
            r7 = 8
        L_0x0021:
            r4.setVisibility(r7)
            goto L_0x002a
        L_0x0025:
            r3 = -1
            if (r7 != r3) goto L_0x002a
            r7 = 4
            goto L_0x0021
        L_0x002a:
            if (r5 != 0) goto L_0x0030
            r4.setImageBitmap(r0)
            return
        L_0x0030:
            android.graphics.drawable.Drawable r5 = a((android.widget.ImageView) r4, (android.graphics.Bitmap) r5, (float) r9, (float) r10)
            switch(r8) {
                case -3: goto L_0x003a;
                case -2: goto L_0x003e;
                case -1: goto L_0x0038;
                default: goto L_0x0037;
            }
        L_0x0037:
            goto L_0x0041
        L_0x0038:
            r7 = 1
            goto L_0x0042
        L_0x003a:
            r7 = 3
            if (r11 != r7) goto L_0x003e
            goto L_0x0038
        L_0x003e:
            if (r11 != r1) goto L_0x0041
            goto L_0x0038
        L_0x0041:
            r7 = 0
        L_0x0042:
            if (r7 == 0) goto L_0x0075
            if (r6 != 0) goto L_0x005c
            android.view.animation.AlphaAnimation r6 = new android.view.animation.AlphaAnimation
            r7 = 0
            r8 = 1065353216(0x3f800000, float:1.0)
            r6.<init>(r7, r8)
            android.view.animation.DecelerateInterpolator r7 = new android.view.animation.DecelerateInterpolator
            r7.<init>()
            r6.setInterpolator(r7)
            r7 = 300(0x12c, double:1.48E-321)
            r6.setDuration(r7)
            goto L_0x0081
        L_0x005c:
            android.graphics.drawable.Drawable r6 = a((android.widget.ImageView) r4, (android.graphics.Bitmap) r6, (float) r9, (float) r10)
            r7 = 2
            android.graphics.drawable.Drawable[] r7 = new android.graphics.drawable.Drawable[r7]
            r7[r2] = r6
            r7[r1] = r5
            android.graphics.drawable.TransitionDrawable r5 = new android.graphics.drawable.TransitionDrawable
            r5.<init>(r7)
            r5.setCrossFadeEnabled(r1)
            r6 = 300(0x12c, float:4.2E-43)
            r5.startTransition(r6)
            goto L_0x0080
        L_0x0075:
            if (r8 <= 0) goto L_0x0080
            android.content.Context r6 = r4.getContext()
            android.view.animation.Animation r6 = android.view.animation.AnimationUtils.loadAnimation(r6, r8)
            goto L_0x0081
        L_0x0080:
            r6 = r0
        L_0x0081:
            r4.setImageDrawable(r5)
            if (r6 == 0) goto L_0x0091
            long r7 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
            r6.setStartTime(r7)
            r4.startAnimation(r6)
            return
        L_0x0091:
            r4.setAnimation(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.d.a(android.widget.ImageView, android.graphics.Bitmap, android.graphics.Bitmap, int, int, float, float, int):void");
    }

    private void a(ImageView imageView, Bitmap bitmap, boolean z2) {
        Drawable a2;
        if (bitmap == null) {
            a2 = null;
        } else if (z2) {
            a2 = a(imageView, bitmap, this.y, this.O);
        } else if (this.m != null) {
            a(imageView, bitmap, this.L, this.v, this.K, this.y, this.O, this.m.r);
            return;
        } else {
            return;
        }
        imageView.setImageDrawable(a2);
    }

    private static void a(d dVar, String str, ImageView imageView, Bitmap bitmap) {
        if (imageView != null && dVar != null) {
            if (str.equals(imageView.getTag(com.c.d.d.y))) {
                dVar.a(imageView, bitmap, false);
            }
            dVar.c(false);
        }
    }

    private static void a(String str, int i, int i2, Bitmap bitmap, boolean z2) {
        if (bitmap != null) {
            Map<String, Bitmap> j = z2 ? j() : bitmap.getWidth() * bitmap.getHeight() <= B ? i() : h();
            if (i > 0 || i2 > 0) {
                j.put(b(str, i, i2), bitmap);
                if (!j.containsKey(str)) {
                    j.put(str, (Object) null);
                    return;
                }
                return;
            }
            j.put(str, bitmap);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, Bitmap bitmap, c cVar) {
        ImageView imageView = (ImageView) this.J.get();
        WeakHashMap remove = I.remove(str);
        if (remove == null || !remove.containsKey(imageView)) {
            a(this, str, imageView, bitmap);
        }
        if (remove != null) {
            for (ImageView imageView2 : remove.keySet()) {
                d dVar = (d) remove.get(imageView2);
                dVar.m = cVar;
                a(dVar, str, imageView2, bitmap);
            }
        }
    }

    private void a(String str, ImageView imageView) {
        if (!str.equals(imageView.getTag(com.c.d.d.y)) || this.L != null) {
            imageView.setTag(com.c.d.d.y, str);
            if (this.L == null || b(imageView.getContext())) {
                a(imageView, (Bitmap) null, true);
            } else {
                a(imageView, this.L, true);
            }
        }
    }

    private Bitmap b(File file) {
        return a(file.getAbsolutePath(), (byte[]) null);
    }

    private Bitmap b(byte[] bArr, c cVar) {
        File file = cVar.m;
        Bitmap a2 = a(file != null ? file.getAbsolutePath() : null, bArr);
        if (a2 == null) {
            if (this.v > 0) {
                View view = (View) this.J.get();
                if (view != null) {
                    String num = Integer.toString(this.v);
                    Bitmap g = b(num);
                    if (g == null) {
                        a2 = BitmapFactory.decodeResource(view.getResources(), this.v);
                        if (a2 != null) {
                            b(num, a2);
                        }
                    } else {
                        a2 = g;
                    }
                } else {
                    a2 = null;
                }
            } else if (this.v == -2 || this.v == -1) {
                a2 = S;
            } else if (this.v == -3) {
                a2 = this.L;
            }
            if (cVar.i != 200) {
                this.P = true;
            }
            if (cVar.r == 1 && file != null) {
                a.a((Object) "invalid bm from net");
                file.delete();
            }
        }
        return a2;
    }

    private d b(float f) {
        this.O = f;
        return this;
    }

    private d b(int i) {
        this.v = i;
        return this;
    }

    private d b(Bitmap bitmap) {
        this.x = bitmap;
        return this;
    }

    private static String b(String str, int i, int i2) {
        if (i > 0) {
            str = String.valueOf(str) + "#" + i;
        }
        if (i2 <= 0) {
            return str;
        }
        return String.valueOf(str) + "#" + i2;
    }

    /* access modifiers changed from: private */
    public void b(String str, Bitmap bitmap) {
        a(str, this.u, this.M, bitmap, this.P);
    }

    private void b(String str, ImageView imageView) {
        HashMap<String, WeakHashMap<ImageView, d>> hashMap;
        WeakHashMap weakHashMap;
        WeakHashMap weakHashMap2 = I.get(str);
        if (weakHashMap2 == null) {
            if (I.containsKey(str)) {
                weakHashMap = new WeakHashMap();
                weakHashMap.put(imageView, this);
                hashMap = I;
            } else {
                hashMap = I;
                weakHashMap = null;
            }
            hashMap.put(str, weakHashMap);
            return;
        }
        weakHashMap2.put(imageView, this);
    }

    private static boolean b(int i, int i2) {
        switch (i) {
            case -3:
                if (i2 == 3) {
                    return true;
                }
                break;
            case -2:
                break;
            case -1:
                return true;
            default:
                return false;
        }
        return i2 == 1;
    }

    public static Bitmap c(String str) {
        return a(str, (byte[]) null, 0, true, 0, false);
    }

    private d c(int i) {
        this.K = i;
        return this;
    }

    private d d(int i) {
        this.M = i;
        return this;
    }

    private d d(boolean z2) {
        this.Q = z2;
        return this;
    }

    protected static void d() {
        I.clear();
    }

    public static boolean d(String str) {
        return h().containsKey(str) || i().containsKey(str) || j().containsKey(str);
    }

    private Bitmap e() {
        View view = (View) this.J.get();
        if (view == null) {
            return null;
        }
        String num = Integer.toString(this.v);
        Bitmap g = b(num);
        if (g != null) {
            return g;
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(view.getResources(), this.v);
        if (decodeResource == null) {
            return decodeResource;
        }
        b(num, decodeResource);
        return decodeResource;
    }

    public static Bitmap e(String str) {
        return a(str, 0, 0);
    }

    private static Matrix e(int i) {
        Matrix matrix = new Matrix();
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return matrix;
            case 3:
                matrix.setRotate(180.0f);
                return matrix;
            case 4:
                matrix.setRotate(180.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                return matrix;
            case 7:
                matrix.setRotate(-90.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                return matrix;
            default:
                return matrix;
        }
        matrix.postScale(-1.0f, 1.0f);
        return matrix;
    }

    private static void e(boolean z2) {
        E = z2;
    }

    private static Bitmap f() {
        return R;
    }

    private static void f(int i) {
        z = i;
        g();
    }

    private static void f(String str) {
        I.remove(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public Bitmap b(String str) {
        if (this.x != null) {
            return this.x;
        }
        if (!this.o) {
            return null;
        }
        return a(str, this.u, this.M);
    }

    private static void g() {
        G = null;
        F = null;
        H = null;
    }

    private static void g(int i) {
        A = i;
        g();
    }

    private static Map<String, Bitmap> h() {
        if (G == null) {
            G = Collections.synchronizedMap(new b(A, C, D));
        }
        return G;
    }

    private static void h(int i) {
        C = i;
        g();
    }

    private static Map<String, Bitmap> i() {
        if (F == null) {
            F = Collections.synchronizedMap(new b(z, B, 250000));
        }
        return F;
    }

    private static void i(int i) {
        B = i;
        g();
    }

    private static Map<String, Bitmap> j() {
        if (H == null) {
            H = Collections.synchronizedMap(new b(100, C, 250000));
        }
        return H;
    }

    private static void j(int i) {
        D = i;
        g();
    }

    public final d a(ImageView imageView) {
        this.J = new WeakReference<>(imageView);
        return this;
    }

    /* access modifiers changed from: protected */
    public final File a(File file, String str) {
        return (this.w == null || !this.w.exists()) ? super.a(file, str) : this.w;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object a(File file, c cVar) {
        return a(file.getAbsolutePath(), (byte[]) null);
    }

    public final /* synthetic */ Object a(byte[] bArr, c cVar) {
        File file = cVar.m;
        Bitmap a2 = a(file != null ? file.getAbsolutePath() : null, bArr);
        if (a2 == null) {
            if (this.v > 0) {
                View view = (View) this.J.get();
                if (view != null) {
                    String num = Integer.toString(this.v);
                    Bitmap g = b(num);
                    if (g == null) {
                        a2 = BitmapFactory.decodeResource(view.getResources(), this.v);
                        if (a2 != null) {
                            b(num, a2);
                        }
                    } else {
                        a2 = g;
                    }
                } else {
                    a2 = null;
                }
            } else if (this.v == -2 || this.v == -1) {
                a2 = S;
            } else if (this.v == -3) {
                a2 = this.L;
            }
            if (cVar.i != 200) {
                this.P = true;
            }
            if (cVar.r == 1 && file != null) {
                a.a((Object) "invalid bm from net");
                file.delete();
            }
        }
        return a2;
    }

    public final void a(Context context) {
        String str = this.f1539c;
        ImageView imageView = (ImageView) this.J.get();
        Bitmap bitmap = null;
        if (str == null) {
            c(false);
            a(imageView, (Bitmap) null, false);
            return;
        }
        Bitmap g = b(str);
        if (g != null) {
            imageView.setTag(com.c.d.d.y, str);
            c cVar = new c();
            cVar.r = 4;
            this.m = cVar.a();
            a(str, g, this.m);
            return;
        }
        if (!str.equals(imageView.getTag(com.c.d.d.y)) || this.L != null) {
            imageView.setTag(com.c.d.d.y, str);
            if (this.L != null && !b(imageView.getContext())) {
                bitmap = this.L;
            }
            a(imageView, bitmap, true);
        }
        if (!I.containsKey(str)) {
            b(str, imageView);
            super.a(imageView.getContext());
            return;
        }
        c(true);
        b(str, imageView);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void a(String str) {
        I.remove(str);
    }

    /* access modifiers changed from: protected */
    public final boolean b() {
        return !E;
    }
}
