package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.android.volley.d;
import com.android.volley.i;
import com.android.volley.k;
import com.android.volley.l;
import com.android.volley.n;
import com.android.volley.t;

public final class l extends com.android.volley.l<Bitmap> {
    private static final int m = 1000;
    private static final int n = 2;
    private static final float o = 2.0f;
    private static final Object v = new Object();
    private final n.b<Bitmap> p;
    private final Bitmap.Config q;
    private final int r;
    private final int s;
    private ImageView.ScaleType t;
    private a u;

    public interface a {
        Bitmap a();

        String b();
    }

    private l(String str, n.b<Bitmap> bVar, int i, int i2, Bitmap.Config config, n.a aVar) {
        this(str, bVar, i, i2, ImageView.ScaleType.CENTER_INSIDE, config, (a) null, aVar);
    }

    private l(String str, n.b<Bitmap> bVar, int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, n.a aVar) {
        this(str, bVar, i, i2, scaleType, config, (a) null, aVar);
    }

    public l(String str, n.b<Bitmap> bVar, int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, a aVar, n.a aVar2) {
        super(0, str, aVar2);
        this.j = new d(1000, 2, o);
        this.p = bVar;
        this.q = config;
        this.r = i;
        this.s = i2;
        this.t = scaleType;
        this.u = aVar;
    }

    private static int a(int i, int i2, int i3, int i4) {
        double min = Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4));
        float f = 1.0f;
        while (true) {
            float f2 = o * f;
            if (((double) f2) > min) {
                return (int) f;
            }
            f = f2;
        }
    }

    private static int a(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        }
        if (i == 0) {
            return (int) (((double) i3) * (((double) i2) / ((double) i4)));
        } else if (i2 == 0) {
            return i;
        } else {
            double d = ((double) i4) / ((double) i3);
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                double d2 = (double) i2;
                return ((double) i) * d < d2 ? (int) (d2 / d) : i;
            }
            double d3 = (double) i2;
            return ((double) i) * d > d3 ? (int) (d3 / d) : i;
        }
    }

    private void a(Bitmap bitmap) {
        this.p.a(bitmap);
    }

    private n<Bitmap> b(i iVar) {
        Bitmap bitmap;
        byte[] bArr = iVar.f484b;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.r == 0 && this.s == 0) {
            options.inPreferredConfig = this.q;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int a2 = a(this.r, this.s, i, i2, this.t);
            int a3 = a(this.s, this.r, i2, i, this.t);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i, i2, a2, a3);
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmap != null && a2 > 0 && a3 > 0 && (bitmap.getWidth() > a2 || bitmap.getHeight() > a3)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, a2, a3, true);
                bitmap.recycle();
                bitmap = createScaledBitmap;
            }
        }
        if (bitmap == null) {
            return n.a(new k(iVar));
        }
        if (this.u != null) {
            bitmap = this.u.a();
        }
        return n.a(bitmap, h.a(iVar));
    }

    /* access modifiers changed from: protected */
    public final n<Bitmap> a(i iVar) {
        Bitmap bitmap;
        n<Bitmap> nVar;
        synchronized (v) {
            try {
                byte[] bArr = iVar.f484b;
                BitmapFactory.Options options = new BitmapFactory.Options();
                if (this.r == 0 && this.s == 0) {
                    options.inPreferredConfig = this.q;
                    bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                } else {
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                    int i = options.outWidth;
                    int i2 = options.outHeight;
                    int a2 = a(this.r, this.s, i, i2, this.t);
                    int a3 = a(this.s, this.r, i2, i, this.t);
                    options.inJustDecodeBounds = false;
                    options.inSampleSize = a(i, i2, a2, a3);
                    bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                    if (bitmap != null && a2 > 0 && a3 > 0 && (bitmap.getWidth() > a2 || bitmap.getHeight() > a3)) {
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, a2, a3, true);
                        bitmap.recycle();
                        bitmap = createScaledBitmap;
                    }
                }
                if (bitmap == null) {
                    nVar = n.a(new k(iVar));
                } else {
                    if (this.u != null) {
                        bitmap = this.u.a();
                    }
                    nVar = n.a(bitmap, h.a(iVar));
                }
            } catch (OutOfMemoryError e) {
                t.c("Caught OOM for %d byte image, url=%s", Integer.valueOf(iVar.f484b.length), this.f487b);
                return n.a(new k((Throwable) e));
            } catch (Throwable th) {
                throw th;
            }
        }
        return nVar;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.p.a((Bitmap) obj);
    }

    public final l.b h() {
        return l.b.LOW;
    }
}
