package cn.bingoogolapple.androidcommon.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ywfzjbcy.R;
import java.util.ArrayList;
import java.util.List;

public abstract class BGARecyclerViewAdapter<M> extends RecyclerView.Adapter<BGARecyclerViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    protected final int f439a = R.layout.adapter_msg_notify;

    /* renamed from: b  reason: collision with root package name */
    protected Context f440b = this.i.getContext();

    /* renamed from: c  reason: collision with root package name */
    protected List<M> f441c = new ArrayList();
    protected d d;
    protected e e;
    protected c f;
    protected f g;
    protected g h;
    protected RecyclerView i;

    public BGARecyclerViewAdapter(RecyclerView recyclerView) {
        this.i = recyclerView;
    }

    private BGARecyclerViewHolder a(ViewGroup viewGroup) {
        BGARecyclerViewHolder bGARecyclerViewHolder = new BGARecyclerViewHolder(this.i, LayoutInflater.from(this.f440b).inflate(this.f439a, viewGroup, false), this.g, this.h);
        bGARecyclerViewHolder.a().a(this.d);
        bGARecyclerViewHolder.a().a(this.e);
        bGARecyclerViewHolder.a().a(this.f);
        bGARecyclerViewHolder.a();
        return bGARecyclerViewHolder;
    }

    private void a(int i2, int i3) {
        this.f441c.add(i3, this.f441c.remove(i2));
        notifyItemMoved(i2, i3);
    }

    private void a(int i2, M m) {
        this.f441c.add(i2, m);
        notifyItemInserted(i2);
    }

    private void a(BGARecyclerViewHolder bGARecyclerViewHolder, int i2) {
        a(bGARecyclerViewHolder.a(), a(i2));
    }

    private void a(c cVar) {
        this.f = cVar;
    }

    private void a(d dVar) {
        this.d = dVar;
    }

    private void a(e eVar) {
        this.e = eVar;
    }

    private void a(g gVar) {
        this.h = gVar;
    }

    private void a(M m) {
        int indexOf = this.f441c.indexOf(m);
        this.f441c.remove(indexOf);
        notifyItemRemoved(indexOf);
    }

    private void a(M m, M m2) {
        int indexOf = this.f441c.indexOf(m);
        this.f441c.set(indexOf, m2);
        notifyItemChanged(indexOf);
    }

    private static void b() {
    }

    private void b(int i2) {
        this.f441c.remove(i2);
        notifyItemRemoved(i2);
    }

    private void b(int i2, M m) {
        this.f441c.set(i2, m);
        notifyItemChanged(i2);
    }

    private void b(M m) {
        a(0, m);
    }

    private void b(List<M> list) {
        if (list != null) {
            this.f441c.addAll(0, list);
            notifyItemRangeInserted(0, list.size());
        }
    }

    private List<M> c() {
        return this.f441c;
    }

    private void c(M m) {
        a(this.f441c.size(), m);
    }

    private void c(List<M> list) {
        if (list != null) {
            this.f441c.addAll(this.f441c.size(), list);
            notifyItemRangeInserted(this.f441c.size(), list.size());
        }
    }

    public final M a(int i2) {
        return this.f441c.get(i2);
    }

    public final void a() {
        this.f441c.clear();
        notifyDataSetChanged();
    }

    public final void a(f fVar) {
        this.g = fVar;
    }

    public abstract void a(h hVar, M m);

    public final void a(List<M> list) {
        if (list != null) {
            this.f441c = list;
        } else {
            this.f441c.clear();
        }
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f441c.size();
    }

    public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        a(((BGARecyclerViewHolder) viewHolder).a(), a(i2));
    }

    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        BGARecyclerViewHolder bGARecyclerViewHolder = new BGARecyclerViewHolder(this.i, LayoutInflater.from(this.f440b).inflate(this.f439a, viewGroup, false), this.g, this.h);
        bGARecyclerViewHolder.a().a(this.d);
        bGARecyclerViewHolder.a().a(this.e);
        bGARecyclerViewHolder.a().a(this.f);
        bGARecyclerViewHolder.a();
        return bGARecyclerViewHolder;
    }
}
