package com.google.a.d.a;

import com.google.a.h;

public final class e {
    private static final e[] h = {new e(1, 10, 10, 8, 8, new b(5, new a(1, 3, (byte) 0), (byte) 0)), new e(2, 12, 12, 10, 10, new b(7, new a(1, 5, (byte) 0), (byte) 0)), new e(3, 14, 14, 12, 12, new b(10, new a(1, 8, (byte) 0), (byte) 0)), new e(4, 16, 16, 14, 14, new b(12, new a(1, 12, (byte) 0), (byte) 0)), new e(5, 18, 18, 16, 16, new b(14, new a(1, 18, (byte) 0), (byte) 0)), new e(6, 20, 20, 18, 18, new b(18, new a(1, 22, (byte) 0), (byte) 0)), new e(7, 22, 22, 20, 20, new b(20, new a(1, 30, (byte) 0), (byte) 0)), new e(8, 24, 24, 22, 22, new b(24, new a(1, 36, (byte) 0), (byte) 0)), new e(9, 26, 26, 24, 24, new b(28, new a(1, 44, (byte) 0), (byte) 0)), new e(10, 32, 32, 14, 14, new b(36, new a(1, 62, (byte) 0), (byte) 0)), new e(11, 36, 36, 16, 16, new b(42, new a(1, 86, (byte) 0), (byte) 0)), new e(12, 40, 40, 18, 18, new b(48, new a(1, 114, (byte) 0), (byte) 0)), new e(13, 44, 44, 20, 20, new b(56, new a(1, 144, (byte) 0), (byte) 0)), new e(14, 48, 48, 22, 22, new b(68, new a(1, 174, (byte) 0), (byte) 0)), new e(15, 52, 52, 24, 24, new b(42, new a(2, 102, (byte) 0), (byte) 0)), new e(16, 64, 64, 14, 14, new b(56, new a(2, 140, (byte) 0), (byte) 0)), new e(17, 72, 72, 16, 16, new b(36, new a(4, 92, (byte) 0), (byte) 0)), new e(18, 80, 80, 18, 18, new b(48, new a(4, 114, (byte) 0), (byte) 0)), new e(19, 88, 88, 20, 20, new b(56, new a(4, 144, (byte) 0), (byte) 0)), new e(20, 96, 96, 22, 22, new b(68, new a(4, 174, (byte) 0), (byte) 0)), new e(21, 104, 104, 24, 24, new b(56, new a(6, 136, (byte) 0), (byte) 0)), new e(22, 120, 120, 18, 18, new b(68, new a(6, 175, (byte) 0), (byte) 0)), new e(23, 132, 132, 20, 20, new b(62, new a(8, 163, (byte) 0), (byte) 0)), new e(24, 144, 144, 22, 22, new b(new a(8, 156, (byte) 0), new a(2, 155, (byte) 0), (byte) 0)), new e(25, 8, 18, 6, 16, new b(7, new a(1, 5, (byte) 0), (byte) 0)), new e(26, 8, 32, 6, 14, new b(11, new a(1, 10, (byte) 0), (byte) 0)), new e(27, 12, 26, 10, 24, new b(14, new a(1, 16, (byte) 0), (byte) 0)), new e(28, 12, 36, 10, 16, new b(18, new a(1, 22, (byte) 0), (byte) 0)), new e(29, 16, 36, 14, 16, new b(24, new a(1, 32, (byte) 0), (byte) 0)), new e(30, 16, 48, 14, 22, new b(28, new a(1, 49, (byte) 0), (byte) 0))};

    /* renamed from: a  reason: collision with root package name */
    final int f3101a;

    /* renamed from: b  reason: collision with root package name */
    final int f3102b;

    /* renamed from: c  reason: collision with root package name */
    final int f3103c;
    final int d;
    final int e;
    final b f;
    final int g;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final int f3104a;

        /* renamed from: b  reason: collision with root package name */
        final int f3105b;

        private a(int i, int i2) {
            this.f3104a = i;
            this.f3105b = i2;
        }

        /* synthetic */ a(int i, int i2, byte b2) {
            this(i, i2);
        }

        private int a() {
            return this.f3104a;
        }

        private int b() {
            return this.f3105b;
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final int f3106a;

        /* renamed from: b  reason: collision with root package name */
        final a[] f3107b;

        private b(int i, a aVar) {
            this.f3106a = i;
            this.f3107b = new a[]{aVar};
        }

        /* synthetic */ b(int i, a aVar, byte b2) {
            this(i, aVar);
        }

        private b(a aVar, a aVar2) {
            this.f3106a = 62;
            this.f3107b = new a[]{aVar, aVar2};
        }

        /* synthetic */ b(a aVar, a aVar2, byte b2) {
            this(aVar, aVar2);
        }

        private int a() {
            return this.f3106a;
        }

        private a[] b() {
            return this.f3107b;
        }
    }

    private e(int i, int i2, int i3, int i4, int i5, b bVar) {
        this.f3101a = i;
        this.f3102b = i2;
        this.f3103c = i3;
        this.d = i4;
        this.e = i5;
        this.f = bVar;
        int i6 = bVar.f3106a;
        int i7 = 0;
        for (a aVar : bVar.f3107b) {
            i7 += aVar.f3104a * (aVar.f3105b + i6);
        }
        this.g = i7;
    }

    private int a() {
        return this.f3101a;
    }

    public static e a(int i, int i2) throws h {
        if ((i & 1) == 0 && (i2 & 1) == 0) {
            for (e eVar : h) {
                if (eVar.f3102b == i && eVar.f3103c == i2) {
                    return eVar;
                }
            }
            throw h.getFormatInstance();
        }
        throw h.getFormatInstance();
    }

    private int b() {
        return this.f3102b;
    }

    private int c() {
        return this.f3103c;
    }

    private int d() {
        return this.d;
    }

    private int e() {
        return this.e;
    }

    private int f() {
        return this.g;
    }

    private b g() {
        return this.f;
    }

    private static e[] h() {
        return new e[]{new e(1, 10, 10, 8, 8, new b(5, new a(1, 3, (byte) 0), (byte) 0)), new e(2, 12, 12, 10, 10, new b(7, new a(1, 5, (byte) 0), (byte) 0)), new e(3, 14, 14, 12, 12, new b(10, new a(1, 8, (byte) 0), (byte) 0)), new e(4, 16, 16, 14, 14, new b(12, new a(1, 12, (byte) 0), (byte) 0)), new e(5, 18, 18, 16, 16, new b(14, new a(1, 18, (byte) 0), (byte) 0)), new e(6, 20, 20, 18, 18, new b(18, new a(1, 22, (byte) 0), (byte) 0)), new e(7, 22, 22, 20, 20, new b(20, new a(1, 30, (byte) 0), (byte) 0)), new e(8, 24, 24, 22, 22, new b(24, new a(1, 36, (byte) 0), (byte) 0)), new e(9, 26, 26, 24, 24, new b(28, new a(1, 44, (byte) 0), (byte) 0)), new e(10, 32, 32, 14, 14, new b(36, new a(1, 62, (byte) 0), (byte) 0)), new e(11, 36, 36, 16, 16, new b(42, new a(1, 86, (byte) 0), (byte) 0)), new e(12, 40, 40, 18, 18, new b(48, new a(1, 114, (byte) 0), (byte) 0)), new e(13, 44, 44, 20, 20, new b(56, new a(1, 144, (byte) 0), (byte) 0)), new e(14, 48, 48, 22, 22, new b(68, new a(1, 174, (byte) 0), (byte) 0)), new e(15, 52, 52, 24, 24, new b(42, new a(2, 102, (byte) 0), (byte) 0)), new e(16, 64, 64, 14, 14, new b(56, new a(2, 140, (byte) 0), (byte) 0)), new e(17, 72, 72, 16, 16, new b(36, new a(4, 92, (byte) 0), (byte) 0)), new e(18, 80, 80, 18, 18, new b(48, new a(4, 114, (byte) 0), (byte) 0)), new e(19, 88, 88, 20, 20, new b(56, new a(4, 144, (byte) 0), (byte) 0)), new e(20, 96, 96, 22, 22, new b(68, new a(4, 174, (byte) 0), (byte) 0)), new e(21, 104, 104, 24, 24, new b(56, new a(6, 136, (byte) 0), (byte) 0)), new e(22, 120, 120, 18, 18, new b(68, new a(6, 175, (byte) 0), (byte) 0)), new e(23, 132, 132, 20, 20, new b(62, new a(8, 163, (byte) 0), (byte) 0)), new e(24, 144, 144, 22, 22, new b(new a(8, 156, (byte) 0), new a(2, 155, (byte) 0), (byte) 0)), new e(25, 8, 18, 6, 16, new b(7, new a(1, 5, (byte) 0), (byte) 0)), new e(26, 8, 32, 6, 14, new b(11, new a(1, 10, (byte) 0), (byte) 0)), new e(27, 12, 26, 10, 24, new b(14, new a(1, 16, (byte) 0), (byte) 0)), new e(28, 12, 36, 10, 16, new b(18, new a(1, 22, (byte) 0), (byte) 0)), new e(29, 16, 36, 14, 16, new b(24, new a(1, 32, (byte) 0), (byte) 0)), new e(30, 16, 48, 14, 22, new b(28, new a(1, 49, (byte) 0), (byte) 0))};
    }

    public final String toString() {
        return String.valueOf(this.f3101a);
    }
}
