package cn.bingoogolapple.androidcommon.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

public final class h implements View.OnClickListener, View.OnLongClickListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    protected final SparseArray<View> f450a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    protected d f451b;

    /* renamed from: c  reason: collision with root package name */
    protected e f452c;
    protected c d;
    protected View e;
    protected Context f;
    protected int g;
    protected BGARecyclerViewHolder h;
    protected RecyclerView i;
    protected ViewGroup j;
    protected Object k;

    public h(RecyclerView recyclerView, View view) {
        this.i = recyclerView;
        this.e = view;
        this.f = view.getContext();
    }

    public h(ViewGroup viewGroup, View view) {
        this.j = viewGroup;
        this.e = view;
        this.f = view.getContext();
    }

    private BGARecyclerViewHolder a() {
        return this.h;
    }

    private h a(@IdRes int i2, @StringRes int i3) {
        ((TextView) b(i2)).setText(i3);
        return this;
    }

    private h a(@IdRes int i2, int i3, Object obj) {
        b(i2).setTag(i3, obj);
        return this;
    }

    private h a(@IdRes int i2, Bitmap bitmap) {
        ((ImageView) b(i2)).setImageBitmap(bitmap);
        return this;
    }

    private h a(@IdRes int i2, Drawable drawable) {
        ((ImageView) b(i2)).setImageDrawable(drawable);
        return this;
    }

    private h a(@IdRes int i2, Object obj) {
        b(i2).setTag(obj);
        return this;
    }

    private h a(@IdRes int i2, String str) {
        ((TextView) b(i2)).setText(Html.fromHtml(str));
        return this;
    }

    private h a(@IdRes int i2, boolean z) {
        ((Checkable) b(i2)).setChecked(z);
        return this;
    }

    private void a(Object obj) {
        this.k = obj;
    }

    private int b() {
        return this.h != null ? this.h.getAdapterPosition() : this.g;
    }

    private h b(@IdRes int i2, int i3) {
        b(i2).setVisibility(i3);
        return this;
    }

    private View c() {
        return this.e;
    }

    private h c(@IdRes int i2, @ColorRes int i3) {
        ((TextView) b(i2)).setTextColor(this.f.getResources().getColor(i3));
        return this;
    }

    private void c(@IdRes int i2) {
        b(i2).setOnClickListener(this);
    }

    private h d(@IdRes int i2, int i3) {
        ((TextView) b(i2)).setTextColor(i3);
        return this;
    }

    private Object d() {
        return this.k;
    }

    private void d(@IdRes int i2) {
        b(i2).setOnLongClickListener(this);
    }

    private h e(@IdRes int i2, int i3) {
        b(i2).setBackgroundResource(i3);
        return this;
    }

    private void e(@IdRes int i2) {
        if (b(i2) instanceof CompoundButton) {
            ((CompoundButton) b(i2)).setOnCheckedChangeListener(this);
        }
    }

    private ImageView f(@IdRes int i2) {
        return (ImageView) b(i2);
    }

    private h f(@IdRes int i2, int i3) {
        b(i2).setBackgroundColor(i3);
        return this;
    }

    private TextView g(@IdRes int i2) {
        return (TextView) b(i2);
    }

    private h g(@IdRes int i2, @ColorRes int i3) {
        b(i2).setBackgroundColor(this.f.getResources().getColor(i3));
        return this;
    }

    private h h(@IdRes int i2, @DrawableRes int i3) {
        ((ImageView) b(i2)).setImageResource(i3);
        return this;
    }

    public final h a(@IdRes int i2, CharSequence charSequence) {
        ((TextView) b(i2)).setText(charSequence);
        return this;
    }

    public final void a(int i2) {
        this.g = i2;
    }

    public final void a(BGARecyclerViewHolder bGARecyclerViewHolder) {
        this.h = bGARecyclerViewHolder;
    }

    public final void a(c cVar) {
        this.d = cVar;
    }

    public final void a(d dVar) {
        this.f451b = dVar;
    }

    public final void a(e eVar) {
        this.f452c = eVar;
    }

    public final <T extends View> T b(@IdRes int i2) {
        T t = (View) this.f450a.get(i2);
        if (t != null) {
            return t;
        }
        T findViewById = this.e.findViewById(i2);
        this.f450a.put(i2, findViewById);
        return findViewById;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (this.d == null) {
            return;
        }
        if (this.i != null) {
            b();
        } else if (this.j != null) {
            b();
        }
    }

    public final void onClick(View view) {
        if (this.f451b == null) {
            return;
        }
        if (this.i != null) {
            b();
        } else if (this.j != null) {
            b();
        }
    }

    public final boolean onLongClick(View view) {
        if (this.f452c == null) {
            return false;
        }
        if (this.i == null && this.j == null) {
            return false;
        }
        e eVar = this.f452c;
        b();
        return eVar.a();
    }
}
