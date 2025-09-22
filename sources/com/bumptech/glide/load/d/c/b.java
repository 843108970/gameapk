package com.bumptech.glide.load.d.c;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.b.q;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.d.e.c;
import com.bumptech.glide.util.i;

public abstract class b<T extends Drawable> implements q, u<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final T f1343a;

    public b(T t) {
        this.f1343a = (Drawable) i.a(t, "Argument must not be null");
    }

    @NonNull
    private T f() {
        Drawable.ConstantState constantState = this.f1343a.getConstantState();
        return constantState == null ? this.f1343a : constantState.newDrawable();
    }

    @NonNull
    public final /* synthetic */ Object b() {
        Drawable.ConstantState constantState = this.f1343a.getConstantState();
        return constantState == null ? this.f1343a : constantState.newDrawable();
    }

    public void e() {
        if (this.f1343a instanceof BitmapDrawable) {
            ((BitmapDrawable) this.f1343a).getBitmap().prepareToDraw();
        } else if (this.f1343a instanceof c) {
            ((c) this.f1343a).a().prepareToDraw();
        }
    }
}
