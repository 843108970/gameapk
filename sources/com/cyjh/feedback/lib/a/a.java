package com.cyjh.feedback.lib.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import com.cyjh.feedback.lib.e.c;
import com.cyjh.feedback.libraryfeedbackinfo.R;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Set<String> f2371a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public C0034a f2372b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Context f2373c;
    private LayoutInflater d;
    private List<String> e;

    /* renamed from: com.cyjh.feedback.lib.a.a$a  reason: collision with other inner class name */
    public interface C0034a {
        void a(int i);
    }

    class b {

        /* renamed from: a  reason: collision with root package name */
        ImageView f2377a;

        /* renamed from: b  reason: collision with root package name */
        ImageButton f2378b;

        b() {
        }
    }

    public a(Context context, List<String> list) {
        this.f2373c = context;
        this.d = LayoutInflater.from(context);
        this.e = list;
    }

    private Set<String> a() {
        return this.f2371a;
    }

    private void a(C0034a aVar) {
        this.f2372b = aVar;
    }

    public final int getCount() {
        return this.e.size();
    }

    public final Object getItem(int i) {
        return this.e.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        final b bVar;
        if (view == null) {
            bVar = new b();
            view2 = this.d.inflate(R.layout.image_adapter_item, viewGroup, false);
            bVar.f2378b = (ImageButton) view2.findViewById(R.id.id_img_select_grid_item);
            bVar.f2377a = (ImageView) view2.findViewById(R.id.id_img_grid_item);
            view2.setTag(bVar);
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        bVar.f2377a.setImageResource(R.mipmap.pictures_no);
        final String str = this.e.get(i);
        c.a(c.C0037c.FILO$789f335a).a(str, bVar.f2377a);
        bVar.f2377a.setColorFilter((ColorFilter) null);
        bVar.f2378b.setVisibility(4);
        if (this.f2371a.contains(str)) {
            bVar.f2377a.setColorFilter(Color.parseColor("#77000000"));
            bVar.f2378b.setVisibility(0);
        }
        bVar.f2377a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ImageButton imageButton;
                int i;
                Context a2;
                Context a3;
                int i2;
                if ((new File(str).length() / 1024) - PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH > 0) {
                    a2 = a.this.f2373c;
                    a3 = a.this.f2373c;
                    i2 = R.string.img_content_too_large;
                } else {
                    if (a.this.f2371a.contains(str)) {
                        a.this.f2371a.remove(str);
                        bVar.f2377a.setColorFilter((ColorFilter) null);
                        imageButton = bVar.f2378b;
                        i = 4;
                    } else if (a.this.f2371a.size() > 3) {
                        a2 = a.this.f2373c;
                        a3 = a.this.f2373c;
                        i2 = R.string.img_count_more;
                    } else {
                        a.this.f2371a.add(str);
                        bVar.f2377a.setColorFilter(Color.parseColor("#77000000"));
                        imageButton = bVar.f2378b;
                        i = 0;
                    }
                    imageButton.setVisibility(i);
                    if (a.this.f2372b != null) {
                        a.this.f2372b.a(a.this.f2371a.size());
                        return;
                    }
                    return;
                }
                Toast.makeText(a2, a3.getString(i2), 1).show();
            }
        });
        return view2;
    }
}
