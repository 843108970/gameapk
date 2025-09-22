package com.google.a.c.b;

import com.cyjh.mobileanjian.ipc.share.proto.UiMessage;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f3064a = new a(4201, 4096, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final a f3065b = new a(1033, 1024, 1);

    /* renamed from: c  reason: collision with root package name */
    public static final a f3066c = new a(67, 64, 1);
    public static final a d = new a(19, 16, 1);
    public static final a e = new a(285, 256, 0);
    public static final a f;
    public static final a g;
    public static final a h = f3066c;
    final int[] i;
    final b j;
    final b k;
    final int l;
    final int m;
    private final int[] n;
    private final int o;

    static {
        a aVar = new a(UiMessage.CommandToUi.Command_Type.SET_ENABLED_VALUE, 256, 1);
        f = aVar;
        g = aVar;
    }

    private a(int i2, int i3, int i4) {
        this.o = i2;
        this.l = i3;
        this.m = i4;
        this.i = new int[i3];
        this.n = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.i[i6] = i5;
            i5 <<= 1;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.n[this.i[i7]] = i7;
        }
        this.j = new b(this, new int[]{0});
        this.k = new b(this, new int[]{1});
    }

    private b a() {
        return this.j;
    }

    static int b(int i2, int i3) {
        return i2 ^ i3;
    }

    private b b() {
        return this.k;
    }

    private int c() {
        return this.l;
    }

    private int c(int i2) {
        return this.i[i2];
    }

    private int d() {
        return this.m;
    }

    /* access modifiers changed from: package-private */
    public final int a(int i2) {
        if (i2 != 0) {
            return this.n[i2];
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public final b a(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        } else if (i3 == 0) {
            return this.j;
        } else {
            int[] iArr = new int[(i2 + 1)];
            iArr[0] = i3;
            return new b(this, iArr);
        }
    }

    /* access modifiers changed from: package-private */
    public final int b(int i2) {
        if (i2 != 0) {
            return this.i[(this.l - this.n[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    /* access modifiers changed from: package-private */
    public final int c(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        return this.i[(this.n[i2] + this.n[i3]) % (this.l - 1)];
    }

    public final String toString() {
        return "GF(0x" + Integer.toHexString(this.o) + ',' + this.l + ')';
    }
}
