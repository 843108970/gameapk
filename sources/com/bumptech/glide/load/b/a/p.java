package com.bumptech.glide.load.b.a;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.util.k;
import java.util.NavigableMap;

@RequiresApi(19)
final class p implements l {

    /* renamed from: a  reason: collision with root package name */
    private static final int f1046a = 8;

    /* renamed from: b  reason: collision with root package name */
    private final b f1047b = new b();

    /* renamed from: c  reason: collision with root package name */
    private final h<a, Bitmap> f1048c = new h<>();
    private final NavigableMap<Integer, Integer> d = new n();

    @VisibleForTesting
    static final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        int f1049a;

        /* renamed from: b  reason: collision with root package name */
        private final b f1050b;

        a(b bVar) {
            this.f1050b = bVar;
        }

        private void a(int i) {
            this.f1049a = i;
        }

        public final void a() {
            this.f1050b.a(this);
        }

        public final boolean equals(Object obj) {
            return (obj instanceof a) && this.f1049a == ((a) obj).f1049a;
        }

        public final int hashCode() {
            return this.f1049a;
        }

        public final String toString() {
            return p.a(this.f1049a);
        }
    }

    @VisibleForTesting
    static class b extends d<a> {
        b() {
        }

        private a c() {
            return new a(this);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ m a() {
            return new a(this);
        }

        public final a a(int i) {
            a aVar = (a) super.b();
            aVar.f1049a = i;
            return aVar;
        }
    }

    p() {
    }

    static String a(int i) {
        return "[" + i + "]";
    }

    private void a(Integer num) {
        Integer num2 = (Integer) this.d.get(num);
        if (num2.intValue() == 1) {
            this.d.remove(num);
        } else {
            this.d.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private static String d(Bitmap bitmap) {
        return a(k.a(bitmap));
    }

    @Nullable
    public final Bitmap a() {
        Bitmap a2 = this.f1048c.a();
        if (a2 != null) {
            a(Integer.valueOf(k.a(a2)));
        }
        return a2;
    }

    @Nullable
    public final Bitmap a(int i, int i2, Bitmap.Config config) {
        int a2 = k.a(i, i2, config);
        a a3 = this.f1047b.a(a2);
        Integer ceilingKey = this.d.ceilingKey(Integer.valueOf(a2));
        if (!(ceilingKey == null || ceilingKey.intValue() == a2 || ceilingKey.intValue() > a2 * 8)) {
            this.f1047b.a(a3);
            a3 = this.f1047b.a(ceilingKey.intValue());
        }
        Bitmap a4 = this.f1048c.a(a3);
        if (a4 != null) {
            a4.reconfigure(i, i2, config);
            a(ceilingKey);
        }
        return a4;
    }

    public final void a(Bitmap bitmap) {
        a a2 = this.f1047b.a(k.a(bitmap));
        this.f1048c.a(a2, bitmap);
        Integer num = (Integer) this.d.get(Integer.valueOf(a2.f1049a));
        NavigableMap<Integer, Integer> navigableMap = this.d;
        Integer valueOf = Integer.valueOf(a2.f1049a);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        navigableMap.put(valueOf, Integer.valueOf(i));
    }

    public final String b(int i, int i2, Bitmap.Config config) {
        return a(k.a(i, i2, config));
    }

    public final String b(Bitmap bitmap) {
        return a(k.a(bitmap));
    }

    public final int c(Bitmap bitmap) {
        return k.a(bitmap);
    }

    public final String toString() {
        return "SizeStrategy:\n  " + this.f1048c + "\n  SortedSizes" + this.d;
    }
}
