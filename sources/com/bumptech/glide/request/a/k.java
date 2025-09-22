package com.bumptech.glide.request.a;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.bumptech.glide.request.a.f;

public final class k<R> implements f<R> {

    /* renamed from: a  reason: collision with root package name */
    private final a f1458a;

    interface a {
        Animation a(Context context);
    }

    k(a aVar) {
        this.f1458a = aVar;
    }

    public final boolean a(R r, f.a aVar) {
        View view = aVar.getView();
        if (view == null) {
            return false;
        }
        view.clearAnimation();
        view.startAnimation(this.f1458a.a(view.getContext()));
        return false;
    }
}
