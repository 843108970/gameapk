package com.b.a.a.e;

import android.support.v7.widget.ActivityChooserView;

public final class al {

    /* renamed from: a  reason: collision with root package name */
    private int f660a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f661b = new int[10];

    /* access modifiers changed from: package-private */
    public final int a() {
        return Integer.bitCount(this.f660a);
    }

    /* access modifiers changed from: package-private */
    public final al a(int i, int i2) {
        if (i >= this.f661b.length) {
            return this;
        }
        this.f660a = (1 << i) | this.f660a;
        this.f661b[i] = i2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(int i) {
        return ((1 << i) & this.f660a) != 0;
    }

    /* access modifiers changed from: package-private */
    public final int b() {
        if ((this.f660a & 2) != 0) {
            return this.f661b[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final int b(int i) {
        return this.f661b[i];
    }

    /* access modifiers changed from: package-private */
    public final int c() {
        return (this.f660a & 16) != 0 ? this.f661b[4] : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    /* access modifiers changed from: package-private */
    public final int c(int i) {
        return (this.f660a & 32) != 0 ? this.f661b[5] : i;
    }

    /* access modifiers changed from: package-private */
    public final int d() {
        if ((this.f660a & 128) != 0) {
            return this.f661b[7];
        }
        return 65535;
    }
}
