package cn.bingoogolapple.androidcommon.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    protected View f448a;

    /* renamed from: b  reason: collision with root package name */
    protected h f449b;

    b(ViewGroup viewGroup, int i) {
        this.f448a = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
        this.f448a.setTag(this);
        this.f449b = new h(viewGroup, this.f448a);
    }

    private static b a(View view, ViewGroup viewGroup, int i) {
        return view == null ? new b(viewGroup, i) : (b) view.getTag();
    }

    public final h a() {
        return this.f449b;
    }

    public final View b() {
        return this.f448a;
    }
}
