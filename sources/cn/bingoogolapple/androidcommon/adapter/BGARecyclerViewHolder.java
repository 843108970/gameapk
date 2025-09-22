package cn.bingoogolapple.androidcommon.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class BGARecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    protected Context f442a = this.e.getContext();

    /* renamed from: b  reason: collision with root package name */
    protected f f443b;

    /* renamed from: c  reason: collision with root package name */
    protected g f444c;
    protected h d;
    protected RecyclerView e;

    public BGARecyclerViewHolder(RecyclerView recyclerView, View view, f fVar, g gVar) {
        super(view);
        this.e = recyclerView;
        this.f443b = fVar;
        this.f444c = gVar;
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        this.d = new h(this.e, this.itemView);
        this.d.a(this);
    }

    public final h a() {
        return this.d;
    }

    public void onClick(View view) {
        if (view.getId() == this.itemView.getId() && this.f443b != null) {
            this.f443b.a(getAdapterPosition());
        }
    }

    public boolean onLongClick(View view) {
        if (view.getId() != this.itemView.getId() || this.f444c == null) {
            return false;
        }
        g gVar = this.f444c;
        getAdapterPosition();
        return gVar.a();
    }
}
