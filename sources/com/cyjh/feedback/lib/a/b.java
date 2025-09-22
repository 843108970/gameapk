package com.cyjh.feedback.lib.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.cyjh.feedback.lib.e.c;
import com.cyjh.feedback.libraryfeedbackinfo.R;
import java.util.ArrayList;
import java.util.List;

public final class b extends BaseAdapter {
    private static final int d = 4;
    private static final int e = 1;

    /* renamed from: a  reason: collision with root package name */
    public List<String> f2380a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public a f2381b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f2382c;

    public interface a {
        void a(int i);
    }

    /* renamed from: com.cyjh.feedback.lib.a.b$b  reason: collision with other inner class name */
    class C0035b {

        /* renamed from: a  reason: collision with root package name */
        ImageView f2385a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f2386b;

        C0035b() {
        }
    }

    public b(Context context) {
        this.f2382c = LayoutInflater.from(context);
        this.f2380a = null;
    }

    private void a(a aVar) {
        this.f2381b = aVar;
    }

    private void a(List<String> list) {
        this.f2380a = list;
    }

    public final int getCount() {
        if (this.f2380a == null) {
            return 1;
        }
        if (this.f2380a.size() < 4) {
            return this.f2380a.size() + 1;
        }
        return 4;
    }

    public final Object getItem(int i) {
        if (this.f2380a == null || this.f2380a.size() <= 0) {
            return null;
        }
        return this.f2380a.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        C0035b bVar;
        if (view == null) {
            view = this.f2382c.inflate(R.layout.grid_view_item, viewGroup, false);
            bVar = new C0035b();
            bVar.f2385a = (ImageView) view.findViewById(R.id.id_iv_grid_item);
            bVar.f2386b = (ImageView) view.findViewById(R.id.id_img_delete_select);
            view.setTag(bVar);
        } else {
            bVar = (C0035b) view.getTag();
        }
        bVar.f2385a.setImageResource(R.mipmap.img_add_img_select);
        bVar.f2386b.setVisibility(4);
        if (this.f2380a != null && i < getCount() - 1) {
            c.a().a(this.f2380a.get(i), bVar.f2385a);
            bVar.f2386b.setVisibility(0);
        }
        if (this.f2380a != null && this.f2380a.size() == 4) {
            c.a().a(this.f2380a.get(i), bVar.f2385a);
            bVar.f2386b.setVisibility(0);
        }
        bVar.f2386b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.f2380a.remove(b.this.f2380a.get(i));
                b.this.notifyDataSetChanged();
                if (b.this.f2381b != null) {
                    b.this.f2381b.a(b.this.f2380a.size());
                }
            }
        });
        return view;
    }
}
