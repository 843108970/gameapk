package c;

import java.util.AbstractList;
import java.util.RandomAccess;

public final class q extends AbstractList<f> implements RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    final f[] f414a;

    private q(f[] fVarArr) {
        this.f414a = fVarArr;
    }

    private f a(int i) {
        return this.f414a[i];
    }

    private static q a(f... fVarArr) {
        return new q((f[]) fVarArr.clone());
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return this.f414a[i];
    }

    public final int size() {
        return this.f414a.length;
    }
}
