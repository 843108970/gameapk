package com.android.volley;

public final class d implements p {

    /* renamed from: a  reason: collision with root package name */
    public static final int f471a = 2500;

    /* renamed from: b  reason: collision with root package name */
    public static final int f472b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final float f473c = 1.0f;
    private int d;
    private int e;
    private final int f;
    private final float g;

    public d() {
        this(f471a, 1, 1.0f);
    }

    public d(int i, int i2, float f2) {
        this.d = i;
        this.f = i2;
        this.g = f2;
    }

    private float c() {
        return this.g;
    }

    private boolean d() {
        return this.e <= this.f;
    }

    public final int a() {
        return this.d;
    }

    public final void a(s sVar) throws s {
        boolean z = true;
        this.e++;
        this.d = (int) (((float) this.d) + (((float) this.d) * this.g));
        if (this.e > this.f) {
            z = false;
        }
        if (!z) {
            throw sVar;
        }
    }

    public final int b() {
        return this.e;
    }
}
