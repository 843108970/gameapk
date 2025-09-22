package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.CheckResult;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.load.b.i;
import com.bumptech.glide.manager.m;
import com.bumptech.glide.request.a;
import com.bumptech.glide.request.b;
import com.bumptech.glide.request.c;
import com.bumptech.glide.request.d;
import com.bumptech.glide.request.e;
import com.bumptech.glide.request.f;
import com.bumptech.glide.request.g;
import com.bumptech.glide.request.j;
import com.bumptech.glide.request.target.PreloadTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.util.k;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class n<TranscodeType> implements k<n<TranscodeType>>, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    protected static final g f1420a = new g().b(i.f1144c).a(l.LOW).d(true);
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    protected g f1421b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f1422c;
    private final o d;
    private final Class<TranscodeType> e;
    private final g f;
    private final f g;
    private final h h;
    @NonNull
    private p<?, ? super TranscodeType> i;
    @Nullable
    private Object j;
    @Nullable
    private List<f<TranscodeType>> k;
    @Nullable
    private n<TranscodeType> l;
    @Nullable
    private n<TranscodeType> m;
    @Nullable
    private Float n;
    private boolean o;
    private boolean p;
    private boolean q;

    /* renamed from: com.bumptech.glide.n$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1425a = new int[ImageView.ScaleType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0066 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0087 */
        static {
            /*
                com.bumptech.glide.l[] r0 = com.bumptech.glide.l.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1426b = r0
                r0 = 1
                int[] r1 = f1426b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.bumptech.glide.l r2 = com.bumptech.glide.l.LOW     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f1426b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.bumptech.glide.l r3 = com.bumptech.glide.l.NORMAL     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f1426b     // Catch:{ NoSuchFieldError -> 0x002a }
                com.bumptech.glide.l r4 = com.bumptech.glide.l.HIGH     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = f1426b     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.bumptech.glide.l r5 = com.bumptech.glide.l.IMMEDIATE     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                android.widget.ImageView$ScaleType[] r4 = android.widget.ImageView.ScaleType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f1425a = r4
                int[] r4 = f1425a     // Catch:{ NoSuchFieldError -> 0x0048 }
                android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x0048 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0048 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0048 }
            L_0x0048:
                int[] r0 = f1425a     // Catch:{ NoSuchFieldError -> 0x0052 }
                android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                int[] r0 = f1425a     // Catch:{ NoSuchFieldError -> 0x005c }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x005c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                int[] r0 = f1425a     // Catch:{ NoSuchFieldError -> 0x0066 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x0066 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0066 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0066 }
            L_0x0066:
                int[] r0 = f1425a     // Catch:{ NoSuchFieldError -> 0x0071 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r0 = f1425a     // Catch:{ NoSuchFieldError -> 0x007c }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x007c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007c }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007c }
            L_0x007c:
                int[] r0 = f1425a     // Catch:{ NoSuchFieldError -> 0x0087 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                int[] r0 = f1425a     // Catch:{ NoSuchFieldError -> 0x0093 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX     // Catch:{ NoSuchFieldError -> 0x0093 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.n.AnonymousClass2.<clinit>():void");
        }
    }

    protected n(f fVar, o oVar, Class<TranscodeType> cls, Context context) {
        this.o = true;
        this.g = fVar;
        this.d = oVar;
        this.e = cls;
        this.f = oVar.f;
        this.f1422c = context;
        this.i = oVar.b(cls);
        this.f1421b = this.f;
        this.h = fVar.f949b;
    }

    protected n(Class<TranscodeType> cls, n<?> nVar) {
        this(nVar.g, nVar.d, cls, nVar.f1422c);
        this.j = nVar.j;
        this.p = nVar.p;
        this.f1421b = nVar.f1421b;
    }

    @NonNull
    private l a(@NonNull l lVar) {
        switch (lVar) {
            case LOW:
                return l.NORMAL;
            case NORMAL:
                return l.HIGH;
            case HIGH:
            case IMMEDIATE:
                return l.IMMEDIATE;
            default:
                throw new IllegalArgumentException("unknown priority: " + this.f1421b.f1464c);
        }
    }

    @Deprecated
    private b<TranscodeType> a(int i2, int i3) {
        return b(i2, i3);
    }

    private c a(Target<TranscodeType> target, @Nullable f<TranscodeType> fVar, @Nullable d dVar, p<?, ? super TranscodeType> pVar, l lVar, int i2, int i3, g gVar) {
        a aVar;
        a aVar2;
        j jVar;
        l lVar2 = lVar;
        g gVar2 = gVar;
        if (this.m != null) {
            aVar2 = new a(dVar);
            aVar = aVar2;
        } else {
            aVar = null;
            aVar2 = dVar;
        }
        if (this.l != null) {
            if (this.q) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            p<?, ? super TranscodeType> pVar2 = this.l.o ? pVar : this.l.i;
            l a2 = this.l.f1421b.g(8) ? this.l.f1421b.f1464c : a(lVar2);
            int i4 = this.l.f1421b.j;
            int i5 = this.l.f1421b.i;
            if (k.a(i2, i3) && !this.l.f1421b.p()) {
                i4 = gVar2.j;
                i5 = gVar2.i;
            }
            j jVar2 = new j(aVar2);
            c a3 = a(target, fVar, gVar2, (d) jVar2, pVar, lVar2, i2, i3);
            this.q = true;
            c a4 = this.l.a(target, fVar, (d) jVar2, pVar2, a2, i4, i5, this.l.f1421b);
            this.q = false;
            jVar2.a(a3, a4);
            jVar = jVar2;
        } else if (this.n != null) {
            j jVar3 = new j(aVar2);
            f<TranscodeType> fVar2 = fVar;
            j jVar4 = jVar3;
            p<?, ? super TranscodeType> pVar3 = pVar;
            int i6 = i2;
            int i7 = i3;
            jVar3.a(a(target, fVar2, gVar2, (d) jVar4, pVar3, lVar2, i6, i7), a(target, fVar2, gVar.clone().a(this.n.floatValue()), (d) jVar4, pVar3, a(lVar2), i6, i7));
            jVar = jVar3;
        } else {
            jVar = a(target, fVar, gVar2, aVar2, pVar, lVar2, i2, i3);
        }
        c cVar = jVar;
        if (aVar == null) {
            return cVar;
        }
        int i8 = this.m.f1421b.j;
        int i9 = this.m.f1421b.i;
        if (k.a(i2, i3) && !this.m.f1421b.p()) {
            i8 = gVar2.j;
            i9 = gVar2.i;
        }
        a aVar3 = aVar;
        c a5 = this.m.a(target, fVar, (d) aVar, this.m.i, this.m.f1421b.f1464c, i8, i9, this.m.f1421b);
        aVar3.f1435a = cVar;
        aVar3.f1436b = a5;
        return aVar3;
    }

    private c a(Target<TranscodeType> target, f<TranscodeType> fVar, g gVar, d dVar, p<?, ? super TranscodeType> pVar, l lVar, int i2, int i3) {
        return com.bumptech.glide.request.i.a(this.f1422c, this.h, this.j, this.e, gVar, i2, i3, lVar, target, fVar, this.k, dVar, this.h.h, pVar.f1434a);
    }

    private <Y extends Target<TranscodeType>> Y a(@NonNull Y y, @Nullable f<TranscodeType> fVar, @NonNull g gVar) {
        k.a();
        com.bumptech.glide.util.i.a(y, "Argument must not be null");
        if (!this.p) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        g o2 = gVar.o();
        c a2 = a(y, fVar, (d) null, this.i, o2.f1464c, o2.j, o2.i, o2);
        c request = y.getRequest();
        if (a2.a(request)) {
            if (!(!o2.h && request.d())) {
                a2.h();
                if (!((c) com.bumptech.glide.util.i.a(request, "Argument must not be null")).c()) {
                    request.a();
                }
                return y;
            }
        }
        this.d.a((Target<?>) y);
        y.setRequest(a2);
        o oVar = this.d;
        oVar.e.f1419a.add(y);
        m mVar = oVar.d;
        mVar.f1416a.add(a2);
        if (!mVar.f1418c) {
            a2.a();
            return y;
        }
        a2.b();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        mVar.f1417b.add(a2);
        return y;
    }

    private static boolean a(g gVar, c cVar) {
        return !gVar.h && cVar.d();
    }

    @NonNull
    private b<TranscodeType> b(int i2, int i3) {
        final e eVar = new e(this.h.f960b, i2, i3);
        if (k.d()) {
            this.h.f960b.post(new Runnable() {
                public final void run() {
                    if (!eVar.isCancelled()) {
                        n.this.a(eVar, eVar);
                    }
                }
            });
            return eVar;
        }
        a(eVar, eVar);
        return eVar;
    }

    private c b(Target<TranscodeType> target, f<TranscodeType> fVar, @Nullable d dVar, p<?, ? super TranscodeType> pVar, l lVar, int i2, int i3, g gVar) {
        d dVar2 = dVar;
        l lVar2 = lVar;
        g gVar2 = gVar;
        if (this.l != null) {
            if (this.q) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            p<?, ? super TranscodeType> pVar2 = this.l.o ? pVar : this.l.i;
            l a2 = this.l.f1421b.g(8) ? this.l.f1421b.f1464c : a(lVar2);
            int i4 = this.l.f1421b.j;
            int i5 = this.l.f1421b.i;
            if (k.a(i2, i3) && !this.l.f1421b.p()) {
                i4 = gVar2.j;
                i5 = gVar2.i;
            }
            j jVar = new j(dVar2);
            c a3 = a(target, fVar, gVar2, (d) jVar, pVar, lVar2, i2, i3);
            this.q = true;
            j jVar2 = jVar;
            c a4 = this.l.a(target, fVar, (d) jVar, pVar2, a2, i4, i5, this.l.f1421b);
            this.q = false;
            jVar2.a(a3, a4);
            return jVar2;
        } else if (this.n == null) {
            return a(target, fVar, gVar2, dVar2, pVar, lVar2, i2, i3);
        } else {
            j jVar3 = new j(dVar2);
            f<TranscodeType> fVar2 = fVar;
            j jVar4 = jVar3;
            p<?, ? super TranscodeType> pVar3 = pVar;
            int i6 = i2;
            int i7 = i3;
            jVar3.a(a(target, fVar2, gVar2, (d) jVar4, pVar3, lVar2, i6, i7), a(target, fVar2, gVar.clone().a(this.n.floatValue()), (d) jVar4, pVar3, a(lVar2), i6, i7));
            return jVar3;
        }
    }

    private c b(Target<TranscodeType> target, @Nullable f<TranscodeType> fVar, g gVar) {
        return a(target, fVar, (d) null, this.i, gVar.f1464c, gVar.j, gVar.i, gVar);
    }

    @Deprecated
    @CheckResult
    private <Y extends Target<File>> Y b(@NonNull Y y) {
        return d().a(y, (f) null);
    }

    @NonNull
    private n<TranscodeType> c(@Nullable Object obj) {
        this.j = obj;
        this.p = true;
        return this;
    }

    @Deprecated
    @CheckResult
    private b<File> c(int i2, int i3) {
        return d().b(i2, i3);
    }

    @NonNull
    private b<TranscodeType> e() {
        return b(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    private Target<TranscodeType> f() {
        return a(PreloadTarget.obtain(this.d, Integer.MIN_VALUE, Integer.MIN_VALUE), (f) null);
    }

    @CheckResult
    @NonNull
    public n<TranscodeType> a(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.n = Float.valueOf(f2);
        return this;
    }

    @NonNull
    public n<TranscodeType> a(@Nullable n<TranscodeType> nVar) {
        this.m = nVar;
        return this;
    }

    @CheckResult
    @NonNull
    public n<TranscodeType> a(@NonNull p<?, ? super TranscodeType> pVar) {
        this.i = (p) com.bumptech.glide.util.i.a(pVar, "Argument must not be null");
        this.o = false;
        return this;
    }

    @CheckResult
    @NonNull
    public n<TranscodeType> a(@Nullable f<TranscodeType> fVar) {
        this.k = null;
        return b(fVar);
    }

    @CheckResult
    @NonNull
    public n<TranscodeType> a(@NonNull g gVar) {
        com.bumptech.glide.util.i.a(gVar, "Argument must not be null");
        this.f1421b = a().a(gVar);
        return this;
    }

    @CheckResult
    @NonNull
    public n<TranscodeType> a(@Nullable n<TranscodeType>... nVarArr) {
        n<TranscodeType> nVar = null;
        if (nVarArr == null || nVarArr.length == 0) {
            return b((n) null);
        }
        for (int length = nVarArr.length - 1; length >= 0; length--) {
            n<TranscodeType> nVar2 = nVarArr[length];
            if (nVar2 != null) {
                nVar = nVar == null ? nVar2 : nVar2.b(nVar);
            }
        }
        return b(nVar);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final g a() {
        return this.f == this.f1421b ? this.f1421b.clone() : this.f1421b;
    }

    @NonNull
    public final <Y extends Target<TranscodeType>> Y a(@NonNull Y y) {
        return a(y, (f) null);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public final <Y extends Target<TranscodeType>> Y a(@NonNull Y y, @Nullable f<TranscodeType> fVar) {
        return a(y, fVar, a());
    }

    @NonNull
    public final ViewTarget<ImageView, TranscodeType> a(@NonNull ImageView imageView) {
        k.a();
        com.bumptech.glide.util.i.a(imageView, "Argument must not be null");
        g gVar = this.f1421b;
        if (!gVar.g(2048) && gVar.m && imageView.getScaleType() != null) {
            switch (AnonymousClass2.f1425a[imageView.getScaleType().ordinal()]) {
                case 1:
                    gVar = gVar.clone().d();
                    break;
                case 2:
                case 6:
                    gVar = gVar.clone().h();
                    break;
                case 3:
                case 4:
                case 5:
                    gVar = gVar.clone().f();
                    break;
            }
        }
        h hVar = this.h;
        return (ViewTarget) a(hVar.e.buildTarget(imageView, this.e), (f) null, gVar);
    }

    @CheckResult
    /* renamed from: b */
    public n<TranscodeType> clone() {
        try {
            n<TranscodeType> nVar = (n) super.clone();
            nVar.f1421b = nVar.f1421b.clone();
            nVar.i = nVar.i.clone();
            return nVar;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public n<TranscodeType> a(@Nullable Bitmap bitmap) {
        return c(bitmap).a(g.a(i.f1143b));
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public n<TranscodeType> a(@Nullable Drawable drawable) {
        return c(drawable).a(g.a(i.f1143b));
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public n<TranscodeType> a(@Nullable Uri uri) {
        return c(uri);
    }

    @CheckResult
    @NonNull
    public n<TranscodeType> b(@Nullable n<TranscodeType> nVar) {
        this.l = nVar;
        return this;
    }

    @CheckResult
    @NonNull
    public n<TranscodeType> b(@Nullable f<TranscodeType> fVar) {
        if (fVar != null) {
            if (this.k == null) {
                this.k = new ArrayList();
            }
            this.k.add(fVar);
        }
        return this;
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public n<TranscodeType> a(@Nullable File file) {
        return c(file);
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public n<TranscodeType> a(@Nullable @RawRes @DrawableRes Integer num) {
        return c(num).a(g.a(com.bumptech.glide.f.a.a(this.f1422c)));
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public n<TranscodeType> a(@Nullable Object obj) {
        return c(obj);
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public n<TranscodeType> a(@Nullable String str) {
        return c(str);
    }

    @Deprecated
    @CheckResult
    /* renamed from: b */
    public n<TranscodeType> a(@Nullable URL url) {
        return c(url);
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public n<TranscodeType> a(@Nullable byte[] bArr) {
        n<TranscodeType> c2 = c(bArr);
        if (!c2.f1421b.g(4)) {
            c2 = c2.a(g.a(i.f1143b));
        }
        return !c2.f1421b.g(256) ? c2.a(g.a()) : c2;
    }

    @NonNull
    public final Target<TranscodeType> c() {
        return a(PreloadTarget.obtain(this.d, Integer.MIN_VALUE, Integer.MIN_VALUE), (f) null);
    }

    /* access modifiers changed from: protected */
    @CheckResult
    @NonNull
    public n<File> d() {
        return new n(File.class, this).a(f1420a);
    }
}
