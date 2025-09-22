package com.bumptech.glide.load.b.a;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.util.k;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

@RequiresApi(19)
public final class o implements l {

    /* renamed from: a  reason: collision with root package name */
    private static final int f1039a = 8;

    /* renamed from: b  reason: collision with root package name */
    private static final Bitmap.Config[] f1040b;

    /* renamed from: c  reason: collision with root package name */
    private static final Bitmap.Config[] f1041c;
    private static final Bitmap.Config[] d = {Bitmap.Config.RGB_565};
    private static final Bitmap.Config[] e = {Bitmap.Config.ARGB_4444};
    private static final Bitmap.Config[] f = {Bitmap.Config.ALPHA_8};
    private final b g = new b();
    private final h<a, Bitmap> h = new h<>();
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> i = new HashMap();

    /* renamed from: com.bumptech.glide.load.b.a.o$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1042a = new int[Bitmap.Config.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1042a = r0
                int[] r0 = f1042a     // Catch:{ NoSuchFieldError -> 0x0014 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f1042a     // Catch:{ NoSuchFieldError -> 0x001f }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f1042a     // Catch:{ NoSuchFieldError -> 0x002a }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f1042a     // Catch:{ NoSuchFieldError -> 0x0035 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.a.o.AnonymousClass1.<clinit>():void");
        }
    }

    @VisibleForTesting
    static final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        int f1043a;

        /* renamed from: b  reason: collision with root package name */
        private final b f1044b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap.Config f1045c;

        public a(b bVar) {
            this.f1044b = bVar;
        }

        @VisibleForTesting
        private a(b bVar, int i, Bitmap.Config config) {
            this(bVar);
            a(i, config);
        }

        public final void a() {
            this.f1044b.a(this);
        }

        public final void a(int i, Bitmap.Config config) {
            this.f1043a = i;
            this.f1045c = config;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f1043a == aVar.f1043a && k.a((Object) this.f1045c, (Object) aVar.f1045c);
            }
        }

        public final int hashCode() {
            return (this.f1043a * 31) + (this.f1045c != null ? this.f1045c.hashCode() : 0);
        }

        public final String toString() {
            return o.a(this.f1043a, this.f1045c);
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

        public final a a(int i, Bitmap.Config config) {
            a aVar = (a) b();
            aVar.a(i, config);
            return aVar;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f1040b = configArr;
        f1041c = configArr;
    }

    static String a(int i2, Bitmap.Config config) {
        return "[" + i2 + "](" + config + ")";
    }

    private NavigableMap<Integer, Integer> a(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.i.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.i.put(config, treeMap);
        return treeMap;
    }

    private void a(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> a2 = a(bitmap.getConfig());
        Integer num2 = (Integer) a2.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + b(bitmap) + ", this: " + this);
        } else if (num2.intValue() == 1) {
            a2.remove(num);
        } else {
            a2.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private a b(int i2, Bitmap.Config config) {
        Bitmap.Config[] configArr;
        a a2 = this.g.a(i2, config);
        int i3 = 0;
        if (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(config)) {
            switch (AnonymousClass1.f1042a[config.ordinal()]) {
                case 1:
                    configArr = f1040b;
                    break;
                case 2:
                    configArr = d;
                    break;
                case 3:
                    configArr = e;
                    break;
                case 4:
                    configArr = f;
                    break;
                default:
                    configArr = new Bitmap.Config[]{config};
                    break;
            }
        } else {
            configArr = f1041c;
        }
        int length = configArr.length;
        while (true) {
            if (i3 < length) {
                Bitmap.Config config2 = configArr[i3];
                Integer ceilingKey = a(config2).ceilingKey(Integer.valueOf(i2));
                if (ceilingKey == null || ceilingKey.intValue() > i2 * 8) {
                    i3++;
                } else if (ceilingKey.intValue() != i2 || (config2 != null ? !config2.equals(config) : config != null)) {
                    this.g.a(a2);
                    return this.g.a(ceilingKey.intValue(), config2);
                }
            }
        }
        return a2;
    }

    private static Bitmap.Config[] b(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f1041c;
        }
        switch (AnonymousClass1.f1042a[config.ordinal()]) {
            case 1:
                return f1040b;
            case 2:
                return d;
            case 3:
                return e;
            case 4:
                return f;
            default:
                return new Bitmap.Config[]{config};
        }
    }

    @Nullable
    public final Bitmap a() {
        Bitmap a2 = this.h.a();
        if (a2 != null) {
            a(Integer.valueOf(k.a(a2)), a2);
        }
        return a2;
    }

    @Nullable
    public final Bitmap a(int i2, int i3, Bitmap.Config config) {
        Bitmap.Config[] configArr;
        int a2 = k.a(i2, i3, config);
        a a3 = this.g.a(a2, config);
        int i4 = 0;
        if (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(config)) {
            switch (AnonymousClass1.f1042a[config.ordinal()]) {
                case 1:
                    configArr = f1040b;
                    break;
                case 2:
                    configArr = d;
                    break;
                case 3:
                    configArr = e;
                    break;
                case 4:
                    configArr = f;
                    break;
                default:
                    configArr = new Bitmap.Config[]{config};
                    break;
            }
        } else {
            configArr = f1041c;
        }
        int length = configArr.length;
        while (true) {
            if (i4 < length) {
                Bitmap.Config config2 = configArr[i4];
                Integer ceilingKey = a(config2).ceilingKey(Integer.valueOf(a2));
                if (ceilingKey == null || ceilingKey.intValue() > a2 * 8) {
                    i4++;
                } else if (ceilingKey.intValue() != a2 || (config2 != null ? !config2.equals(config) : config != null)) {
                    this.g.a(a3);
                    a3 = this.g.a(ceilingKey.intValue(), config2);
                }
            }
        }
        Bitmap a4 = this.h.a(a3);
        if (a4 != null) {
            a(Integer.valueOf(a3.f1043a), a4);
            a4.reconfigure(i2, i3, a4.getConfig() != null ? a4.getConfig() : Bitmap.Config.ARGB_8888);
        }
        return a4;
    }

    public final void a(Bitmap bitmap) {
        a a2 = this.g.a(k.a(bitmap), bitmap.getConfig());
        this.h.a(a2, bitmap);
        NavigableMap<Integer, Integer> a3 = a(bitmap.getConfig());
        Integer num = (Integer) a3.get(Integer.valueOf(a2.f1043a));
        Integer valueOf = Integer.valueOf(a2.f1043a);
        int i2 = 1;
        if (num != null) {
            i2 = 1 + num.intValue();
        }
        a3.put(valueOf, Integer.valueOf(i2));
    }

    public final String b(int i2, int i3, Bitmap.Config config) {
        return a(k.a(i2, i3, config), config);
    }

    public final String b(Bitmap bitmap) {
        return a(k.a(bitmap), bitmap.getConfig());
    }

    public final int c(Bitmap bitmap) {
        return k.a(bitmap);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SizeConfigStrategy{groupedMap=");
        sb.append(this.h);
        sb.append(", sortedSizes=(");
        for (Map.Entry next : this.i.entrySet()) {
            sb.append(next.getKey());
            sb.append('[');
            sb.append(next.getValue());
            sb.append("], ");
        }
        if (!this.i.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }
}
