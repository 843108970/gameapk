package com.google.a.d.c;

import com.cyjh.mobileanjian.ipc.share.proto.UiMessage;
import com.google.a.f;

public class k {

    /* renamed from: a  reason: collision with root package name */
    static final k[] f3125a;
    private static k[] g;

    /* renamed from: b  reason: collision with root package name */
    final int f3126b;

    /* renamed from: c  reason: collision with root package name */
    final int f3127c;
    public final int d;
    public final int e;
    final int f;
    private final boolean h;
    private final int i;
    private final int j;

    static {
        k[] kVarArr = {new k(false, 3, 5, 8, 8, 1), new k(false, 5, 7, 10, 10, 1), new k(true, 5, 7, 16, 6, 1), new k(false, 8, 10, 12, 12, 1), new k(true, 10, 11, 14, 6, 2), new k(false, 12, 12, 14, 14, 1), new k(true, 16, 14, 24, 10, 1), new k(false, 18, 14, 16, 16, 1), new k(false, 22, 18, 18, 18, 1), new k(true, 22, 18, 16, 10, 2), new k(false, 30, 20, 20, 20, 1), new k(true, 32, 24, 16, 14, 2), new k(false, 36, 24, 22, 22, 1), new k(false, 44, 28, 24, 24, 1), new k(true, 49, 28, 22, 14, 2), new k(false, 62, 36, 14, 14, 4), new k(false, 86, 42, 16, 16, 4), new k(false, 114, 48, 18, 18, 4), new k(false, 144, 56, 20, 20, 4), new k(false, 174, 68, 22, 22, 4), new k(false, UiMessage.CommandToUi.Command_Type.SET_RADIO_GROUP_VALUE, 84, 24, 24, 4, 102, 42), new k(false, 280, 112, 14, 14, 16, 140, 56), new k(false, 368, 144, 16, 16, 16, 92, 36), new k(false, 456, 192, 18, 18, 16, 114, 48), new k(false, 576, 224, 20, 20, 16, 144, 56), new k(false, 696, 272, 22, 22, 16, 174, 68), new k(false, 816, 336, 24, 24, 16, 136, 56), new k(false, 1050, UiMessage.CommandToUi.Command_Type.GET_VALUE_VALUE, 18, 18, 36, 175, 68), new k(false, 1304, 496, 20, 20, 36, 163, 62), new d()};
        f3125a = kVarArr;
        g = kVarArr;
    }

    private k(boolean z, int i2, int i3, int i4, int i5, int i6) {
        this(z, i2, i3, i4, i5, i6, i2, i3);
    }

    k(boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.h = z;
        this.f3126b = i2;
        this.f3127c = i3;
        this.d = i4;
        this.e = i5;
        this.i = i6;
        this.j = i7;
        this.f = i8;
    }

    private static k a(int i2, l lVar) {
        return a(i2, lVar, true);
    }

    public static k a(int i2, l lVar, f fVar, f fVar2, boolean z) {
        for (k kVar : g) {
            if ((lVar != l.FORCE_SQUARE || !kVar.h) && ((lVar != l.FORCE_RECTANGLE || kVar.h) && ((fVar == null || (kVar.d() >= fVar.f3139a && kVar.e() >= fVar.f3140b)) && ((fVar2 == null || (kVar.d() <= fVar2.f3139a && kVar.e() <= fVar2.f3140b)) && i2 <= kVar.f3126b)))) {
                return kVar;
            }
        }
        if (!z) {
            return null;
        }
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(i2)));
    }

    private static k a(int i2, l lVar, boolean z) {
        return a(i2, lVar, (f) null, (f) null, z);
    }

    private static k a(int i2, boolean z, boolean z2) {
        return a(i2, z ? l.FORCE_NONE : l.FORCE_SQUARE, z2);
    }

    private static void a(k[] kVarArr) {
        g = kVarArr;
    }

    private static k b(int i2) {
        return a(i2, l.FORCE_NONE, true);
    }

    private int f() {
        int i2 = this.i;
        if (i2 == 4) {
            return 2;
        }
        if (i2 == 16) {
            return 4;
        }
        if (i2 == 36) {
            return 6;
        }
        switch (i2) {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                throw new IllegalStateException("Cannot handle this number of data regions");
        }
    }

    private int g() {
        int i2 = this.i;
        if (i2 == 4) {
            return 2;
        }
        if (i2 == 16) {
            return 4;
        }
        if (i2 == 36) {
            return 6;
        }
        switch (i2) {
            case 1:
            case 2:
                return 1;
            default:
                throw new IllegalStateException("Cannot handle this number of data regions");
        }
    }

    private int h() {
        return this.f3126b + this.f3127c;
    }

    private int i() {
        return this.f3126b;
    }

    private int j() {
        return this.f3127c;
    }

    private int k() {
        return this.f;
    }

    public int a() {
        return this.f3126b / this.j;
    }

    public int a(int i2) {
        return this.j;
    }

    public final int b() {
        return f() * this.d;
    }

    public final int c() {
        return g() * this.e;
    }

    public final int d() {
        return b() + (f() << 1);
    }

    public final int e() {
        return c() + (g() << 1);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.h ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.d);
        sb.append('x');
        sb.append(this.e);
        sb.append(", symbol size ");
        sb.append(d());
        sb.append('x');
        sb.append(e());
        sb.append(", symbol data size ");
        sb.append(b());
        sb.append('x');
        sb.append(c());
        sb.append(", codewords ");
        sb.append(this.f3126b);
        sb.append('+');
        sb.append(this.f3127c);
        return sb.toString();
    }
}
