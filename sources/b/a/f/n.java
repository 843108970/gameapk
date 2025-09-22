package b.a.f;

import android.support.v7.widget.ActivityChooserView;
import java.util.Arrays;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    static final int f178a = 65535;

    /* renamed from: b  reason: collision with root package name */
    static final int f179b = 1;

    /* renamed from: c  reason: collision with root package name */
    static final int f180c = 2;
    static final int d = 4;
    static final int e = 5;
    static final int f = 6;
    static final int g = 7;
    static final int h = 10;
    int i;
    final int[] j = new int[10];

    private boolean a(boolean z) {
        return ((this.i & 4) != 0 ? this.j[2] : z ? 1 : 0) == 1;
    }

    private int b(int i2) {
        return this.j[i2];
    }

    private int c(int i2) {
        return (this.i & 32) != 0 ? this.j[5] : i2;
    }

    private void c() {
        this.i = 0;
        Arrays.fill(this.j, 0);
    }

    private int d() {
        return Integer.bitCount(this.i);
    }

    private int d(int i2) {
        return (this.i & 64) != 0 ? this.j[6] : i2;
    }

    private int e() {
        return (this.i & 16) != 0 ? this.j[4] : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        if ((this.i & 2) != 0) {
            return this.j[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final n a(int i2, int i3) {
        if (i2 >= this.j.length) {
            return this;
        }
        this.i = (1 << i2) | this.i;
        this.j[i2] = i3;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void a(n nVar) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (nVar.a(i2)) {
                a(i2, nVar.j[i2]);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(int i2) {
        return ((1 << i2) & this.i) != 0;
    }

    public final int b() {
        if ((this.i & 128) != 0) {
            return this.j[7];
        }
        return 65535;
    }
}
