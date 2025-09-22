package com.bumptech.glide.request.a;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.request.a.f;

public final class d implements f<Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f1447a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f1448b;

    public d(int i, boolean z) {
        this.f1447a = i;
        this.f1448b = z;
    }

    private boolean a(Drawable drawable, f.a aVar) {
        Drawable currentDrawable = aVar.getCurrentDrawable();
        if (currentDrawable == null) {
            currentDrawable = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{currentDrawable, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f1448b);
        transitionDrawable.startTransition(this.f1447a);
        aVar.setDrawable(transitionDrawable);
        return true;
    }

    public final /* synthetic */ boolean a(Object obj, f.a aVar) {
        Drawable drawable = (Drawable) obj;
        Drawable currentDrawable = aVar.getCurrentDrawable();
        if (currentDrawable == null) {
            currentDrawable = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{currentDrawable, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f1448b);
        transitionDrawable.startTransition(this.f1447a);
        aVar.setDrawable(transitionDrawable);
        return true;
    }
}
