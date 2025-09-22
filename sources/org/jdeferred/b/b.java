package org.jdeferred.b;

public class b {

    /* renamed from: a  reason: collision with root package name */
    final int f4406a;

    /* renamed from: b  reason: collision with root package name */
    final int f4407b;

    /* renamed from: c  reason: collision with root package name */
    final int f4408c;

    public b(int i, int i2, int i3) {
        this.f4406a = i;
        this.f4407b = i2;
        this.f4408c = i3;
    }

    private int a() {
        return this.f4406a;
    }

    private int b() {
        return this.f4407b;
    }

    private int c() {
        return this.f4408c;
    }

    public String toString() {
        return "MasterProgress [done=" + this.f4406a + ", fail=" + this.f4407b + ", total=" + this.f4408c + "]";
    }
}
