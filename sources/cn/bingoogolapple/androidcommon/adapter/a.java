package cn.bingoogolapple.androidcommon.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class a<M> extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    protected final int f445a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f446b;

    /* renamed from: c  reason: collision with root package name */
    protected List<M> f447c = new ArrayList();
    protected d d;
    protected e e;
    protected c f;

    private a(Context context, int i) {
        this.f446b = context;
        this.f445a = i;
    }

    private void a(int i) {
        this.f447c.remove(i);
        notifyDataSetChanged();
    }

    private void a(int i, int i2) {
        Collections.swap(this.f447c, i, i2);
        notifyDataSetChanged();
    }

    private void a(int i, M m) {
        this.f447c.add(i, m);
        notifyDataSetChanged();
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

    private void a(M m) {
        this.f447c.remove(m);
        notifyDataSetChanged();
    }

    private void a(M m, M m2) {
        this.f447c.set(this.f447c.indexOf(m), m2);
        notifyDataSetChanged();
    }

    private void a(List<M> list) {
        if (list != null) {
            this.f447c.addAll(0, list);
            notifyDataSetChanged();
        }
    }

    private static void b() {
    }

    private void b(int i, M m) {
        this.f447c.set(i, m);
        notifyDataSetChanged();
    }

    private void b(M m) {
        a(0, m);
    }

    private void b(List<M> list) {
        if (list != null) {
            this.f447c.addAll(this.f447c.size(), list);
            notifyDataSetChanged();
        }
    }

    private List<M> c() {
        return this.f447c;
    }

    private void c(M m) {
        a(this.f447c.size(), m);
    }

    private void c(List<M> list) {
        if (list != null) {
            this.f447c = list;
        } else {
            this.f447c.clear();
        }
        notifyDataSetChanged();
    }

    private void d() {
        this.f447c.clear();
        notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    public int getCount() {
        return this.f447c.size();
    }

    public M getItem(int i) {
        return this.f447c.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = view == null ? new b(viewGroup, this.f445a) : (b) view.getTag();
        bVar.a().a(i);
        bVar.a().a(this.d);
        bVar.a().a(this.e);
        bVar.a().a(this.f);
        getItem(i);
        return bVar.b();
    }
}
