package com.bumptech.glide.load.c;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.util.f;
import com.bumptech.glide.util.k;
import java.util.Queue;

public final class m<A, B> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f1240a = 250;

    /* renamed from: b  reason: collision with root package name */
    private final f<a<A>, B> f1241b;

    @VisibleForTesting
    static final class a<A> {

        /* renamed from: a  reason: collision with root package name */
        private static final Queue<a<?>> f1243a = k.a(0);

        /* renamed from: b  reason: collision with root package name */
        private int f1244b;

        /* renamed from: c  reason: collision with root package name */
        private int f1245c;
        private A d;

        private a() {
        }

        static <A> a<A> a(A a2, int i, int i2) {
            a<A> poll;
            synchronized (f1243a) {
                poll = f1243a.poll();
            }
            if (poll == null) {
                poll = new a<>();
            }
            poll.d = a2;
            poll.f1245c = i;
            poll.f1244b = i2;
            return poll;
        }

        private void b(A a2, int i, int i2) {
            this.d = a2;
            this.f1245c = i;
            this.f1244b = i2;
        }

        public final void a() {
            synchronized (f1243a) {
                f1243a.offer(this);
            }
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f1245c == aVar.f1245c && this.f1244b == aVar.f1244b && this.d.equals(aVar.d);
            }
        }

        public final int hashCode() {
            return (((this.f1244b * 31) + this.f1245c) * 31) + this.d.hashCode();
        }
    }

    public m() {
        this(250);
    }

    public m(long j) {
        this.f1241b = new f<a<A>, B>(j) {
            private static void a(@NonNull a<A> aVar) {
                aVar.a();
            }

            /* access modifiers changed from: protected */
            public final /* bridge */ /* synthetic */ void a(@NonNull Object obj, @Nullable Object obj2) {
                ((a) obj).a();
            }
        };
    }

    private void a() {
        this.f1241b.c();
    }

    @Nullable
    public final B a(A a2, int i, int i2) {
        a a3 = a.a(a2, i, i2);
        B b2 = this.f1241b.b(a3);
        a3.a();
        return b2;
    }

    public final void a(A a2, int i, int i2, B b2) {
        this.f1241b.b(a.a(a2, i, i2), b2);
    }
}
