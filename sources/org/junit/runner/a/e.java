package org.junit.runner.a;

import java.util.Comparator;
import org.junit.runner.c;

public final class e implements Comparator<c> {

    /* renamed from: a  reason: collision with root package name */
    public static final e f4610a = new e(new Comparator<c>() {
        private static int a() {
            return 0;
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return 0;
        }
    });

    /* renamed from: b  reason: collision with root package name */
    private final Comparator<c> f4611b;

    public e(Comparator<c> comparator) {
        this.f4611b = comparator;
    }

    /* renamed from: a */
    public final int compare(c cVar, c cVar2) {
        return this.f4611b.compare(cVar, cVar2);
    }

    public final void a(Object obj) {
        if (obj instanceof d) {
            ((d) obj).a(this);
        }
    }
}
