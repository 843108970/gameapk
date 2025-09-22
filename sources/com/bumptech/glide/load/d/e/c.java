package com.bumptech.glide.load.d.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.view.Gravity;
import com.bumptech.glide.c.b;
import com.bumptech.glide.f;
import com.bumptech.glide.load.d.e.g;
import com.bumptech.glide.load.m;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.i;
import com.bumptech.glide.util.k;
import java.nio.ByteBuffer;

public class c extends Drawable implements Animatable, g.b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f1353a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f1354b = 0;
    private static final int e = 119;

    /* renamed from: c  reason: collision with root package name */
    final a f1355c;
    boolean d;
    private boolean f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private boolean k;
    private Paint l;
    private Rect m;

    static final class a extends Drawable.ConstantState {
        @VisibleForTesting

        /* renamed from: a  reason: collision with root package name */
        final g f1356a;

        a(g gVar) {
            this.f1356a = gVar;
        }

        public final int getChangingConfigurations() {
            return 0;
        }

        @NonNull
        public final Drawable newDrawable() {
            return new c(this);
        }

        @NonNull
        public final Drawable newDrawable(Resources resources) {
            return newDrawable();
        }
    }

    @Deprecated
    private c(Context context, b bVar, m<Bitmap> mVar, int i2, int i3, Bitmap bitmap) {
        this(context, bVar, mVar, i2, i3, bitmap, (byte) 0);
    }

    public c(Context context, b bVar, m<Bitmap> mVar, int i2, int i3, Bitmap bitmap, byte b2) {
        this(new a(new g(f.b(context), bVar, i2, i3, mVar, bitmap)));
    }

    c(a aVar) {
        this.h = true;
        this.j = -1;
        this.f1355c = (a) i.a(aVar, "Argument must not be null");
    }

    @VisibleForTesting
    private c(g gVar, Paint paint) {
        this(new a(gVar));
        this.l = paint;
    }

    private void a(int i2) {
        if (i2 <= 0 && i2 != -1 && i2 != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        } else if (i2 == 0) {
            int l2 = this.f1355c.f1356a.f1359a.l();
            if (l2 == 0) {
                l2 = -1;
            }
            this.j = l2;
        } else {
            this.j = i2;
        }
    }

    private void a(m<Bitmap> mVar, Bitmap bitmap) {
        this.f1355c.f1356a.a(mVar, bitmap);
    }

    private void a(boolean z) {
        this.f = z;
    }

    private int d() {
        g gVar = this.f1355c.f1356a;
        return gVar.f1359a.m() + k.a(gVar.b().getWidth(), gVar.b().getHeight(), gVar.b().getConfig());
    }

    private m<Bitmap> e() {
        return this.f1355c.f1356a.j;
    }

    private int f() {
        return this.f1355c.f1356a.a();
    }

    private int g() {
        g gVar = this.f1355c.f1356a;
        if (gVar.f != null) {
            return gVar.f.f1362a;
        }
        return -1;
    }

    private void h() {
        this.i = 0;
    }

    private void i() {
        i.a(!this.f, "You cannot restart a currently running animation.");
        g gVar = this.f1355c.f1356a;
        i.a(!gVar.d, "Can't restart a running animation");
        gVar.e = true;
        if (gVar.k != null) {
            gVar.f1361c.a((Target<?>) gVar.k);
            gVar.k = null;
        }
        start();
    }

    private void j() {
        i.a(!this.d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f1355c.f1356a.a() != 1) {
            if (!this.f) {
                this.f = true;
                g gVar = this.f1355c.f1356a;
                if (gVar.g) {
                    throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
                } else if (gVar.f1360b.contains(this)) {
                    throw new IllegalStateException("Cannot subscribe twice in a row");
                } else {
                    boolean isEmpty = gVar.f1360b.isEmpty();
                    gVar.f1360b.add(this);
                    if (isEmpty && !gVar.d) {
                        gVar.d = true;
                        gVar.g = false;
                        gVar.c();
                    }
                }
            } else {
                return;
            }
        }
        invalidateSelf();
    }

    private void k() {
        this.f = false;
        g gVar = this.f1355c.f1356a;
        gVar.f1360b.remove(this);
        if (gVar.f1360b.isEmpty()) {
            gVar.d = false;
        }
    }

    private Rect l() {
        if (this.m == null) {
            this.m = new Rect();
        }
        return this.m;
    }

    private Paint m() {
        if (this.l == null) {
            this.l = new Paint(2);
        }
        return this.l;
    }

    private Drawable.Callback n() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private void o() {
        this.d = true;
        g gVar = this.f1355c.f1356a;
        gVar.f1360b.clear();
        gVar.d();
        gVar.d = false;
        if (gVar.f != null) {
            gVar.f1361c.a((Target<?>) gVar.f);
            gVar.f = null;
        }
        if (gVar.h != null) {
            gVar.f1361c.a((Target<?>) gVar.h);
            gVar.h = null;
        }
        if (gVar.k != null) {
            gVar.f1361c.a((Target<?>) gVar.k);
            gVar.k = null;
        }
        gVar.f1359a.o();
        gVar.g = true;
    }

    private boolean p() {
        return this.d;
    }

    public final Bitmap a() {
        return this.f1355c.f1356a.i;
    }

    public final ByteBuffer b() {
        return this.f1355c.f1356a.f1359a.c().asReadOnlyBuffer();
    }

    public final void c() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        if (callback == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        g gVar = this.f1355c.f1356a;
        if ((gVar.f != null ? gVar.f.f1362a : -1) == this.f1355c.f1356a.a() - 1) {
            this.i++;
        }
        if (this.j != -1 && this.i >= this.j) {
            stop();
        }
    }

    public void draw(@NonNull Canvas canvas) {
        if (!this.d) {
            if (this.k) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), l());
                this.k = false;
            }
            canvas.drawBitmap(this.f1355c.f1356a.b(), (Rect) null, l(), m());
        }
    }

    public Drawable.ConstantState getConstantState() {
        return this.f1355c;
    }

    public int getIntrinsicHeight() {
        return this.f1355c.f1356a.b().getHeight();
    }

    public int getIntrinsicWidth() {
        return this.f1355c.f1356a.b().getWidth();
    }

    public int getOpacity() {
        return -2;
    }

    public boolean isRunning() {
        return this.f;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.k = true;
    }

    public void setAlpha(int i2) {
        m().setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        m().setColorFilter(colorFilter);
    }

    public boolean setVisible(boolean z, boolean z2) {
        i.a(!this.d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.h = z;
        if (!z) {
            k();
        } else if (this.g) {
            j();
        }
        return super.setVisible(z, z2);
    }

    public void start() {
        this.g = true;
        this.i = 0;
        if (this.h) {
            j();
        }
    }

    public void stop() {
        this.g = false;
        k();
    }
}
