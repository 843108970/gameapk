package com.bumptech.glide;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.AbsListView;
import com.bumptech.glide.request.a.f;
import com.bumptech.glide.request.target.BaseTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.k;
import java.util.List;
import java.util.Queue;

public final class i<T> implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    private final int f962a;

    /* renamed from: b  reason: collision with root package name */
    private final d f963b;

    /* renamed from: c  reason: collision with root package name */
    private final o f964c;
    private final a<T> d;
    private final b<T> e;
    private int f;
    private int g;
    private int h = -1;
    private int i;
    private boolean j = true;

    public interface a<U> {
        @NonNull
        List<U> a();

        @Nullable
        n<?> b();
    }

    public interface b<T> {
        @Nullable
        int[] a();
    }

    private static final class c extends BaseTarget<Object> {

        /* renamed from: a  reason: collision with root package name */
        int f965a;

        /* renamed from: b  reason: collision with root package name */
        int f966b;

        c() {
        }

        public final void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
            sizeReadyCallback.onSizeReady(this.f966b, this.f965a);
        }

        public final void onResourceReady(@NonNull Object obj, @Nullable f<? super Object> fVar) {
        }

        public final void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
        }
    }

    private static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<c> f967a;

        d(int i) {
            this.f967a = k.a(i);
            for (int i2 = 0; i2 < i; i2++) {
                this.f967a.offer(new c());
            }
        }

        public final c a(int i, int i2) {
            c poll = this.f967a.poll();
            this.f967a.offer(poll);
            poll.f966b = i;
            poll.f965a = i2;
            return poll;
        }
    }

    private i(@NonNull o oVar, @NonNull a<T> aVar, @NonNull b<T> bVar, int i2) {
        this.f964c = oVar;
        this.d = aVar;
        this.e = bVar;
        this.f962a = i2;
        this.f963b = new d(i2 + 1);
    }

    private void a() {
        for (int i2 = 0; i2 < this.f962a; i2++) {
            this.f964c.a((Target<?>) this.f963b.a(0, 0));
        }
    }

    private void a(int i2, int i3) {
        int i4;
        int i5;
        if (i2 < i3) {
            i4 = Math.max(this.f, i2);
            i5 = i3;
        } else {
            i5 = Math.min(this.g, i2);
            i4 = i3;
        }
        int min = Math.min(this.i, i5);
        int min2 = Math.min(this.i, Math.max(0, i4));
        if (i2 < i3) {
            for (int i6 = min2; i6 < min; i6++) {
                a(this.d.a(), true);
            }
        } else {
            for (int i7 = min - 1; i7 >= min2; i7--) {
                a(this.d.a(), false);
            }
        }
        this.g = min2;
        this.f = min;
    }

    private void a(int i2, boolean z) {
        int i3;
        int i4;
        if (this.j != z) {
            this.j = z;
            for (int i5 = 0; i5 < this.f962a; i5++) {
                this.f964c.a((Target<?>) this.f963b.a(0, 0));
            }
        }
        int i6 = (z ? this.f962a : -this.f962a) + i2;
        if (i2 < i6) {
            i3 = Math.max(this.f, i2);
            i4 = i6;
        } else {
            i4 = Math.min(this.g, i2);
            i3 = i6;
        }
        int min = Math.min(this.i, i4);
        int min2 = Math.min(this.i, Math.max(0, i3));
        if (i2 < i6) {
            for (int i7 = min2; i7 < min; i7++) {
                a(this.d.a(), true);
            }
        } else {
            for (int i8 = min - 1; i8 >= min2; i8--) {
                a(this.d.a(), false);
            }
        }
        this.g = min2;
        this.f = min;
    }

    private void a(@Nullable T t) {
        int[] a2;
        n<?> b2;
        if (t != null && (a2 = this.e.a()) != null && (b2 = this.d.b()) != null) {
            b2.a(this.f963b.a(a2[0], a2[1]));
        }
    }

    private void a(List<T> list, boolean z) {
        int size = list.size();
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                a(list.get(i2));
            }
            return;
        }
        for (int i3 = size - 1; i3 >= 0; i3--) {
            a(list.get(i3));
        }
    }

    public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        this.i = i4;
        if (i2 > this.h) {
            a(i3 + i2, true);
        } else if (i2 < this.h) {
            a(i2, false);
        }
        this.h = i2;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i2) {
    }
}
