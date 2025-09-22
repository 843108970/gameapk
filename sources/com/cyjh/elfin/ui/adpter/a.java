package com.cyjh.elfin.ui.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyjh.elfin.entity.ScriptLog;
import com.ywfzjbcy.R;
import java.util.ArrayList;

public final class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2240a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<ScriptLog> f2241b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f2242c;

    /* renamed from: com.cyjh.elfin.ui.adpter.a$a  reason: collision with other inner class name */
    private class C0032a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private int f2244b;

        public C0032a(int i) {
            this.f2244b = i;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ((ScriptLog) a.this.f2241b.get(this.f2244b)).setSelect(z);
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        TextView f2245a;

        /* renamed from: b  reason: collision with root package name */
        TextView f2246b;

        /* renamed from: c  reason: collision with root package name */
        CheckBox f2247c;
        ImageView d;

        b() {
        }
    }

    public a(Context context, ArrayList<ScriptLog> arrayList) {
        this.f2241b = arrayList;
        this.f2242c = LayoutInflater.from(context);
    }

    private void a(boolean z) {
        this.f2240a = z;
    }

    private boolean a() {
        return this.f2240a;
    }

    public final int getCount() {
        return this.f2241b.size();
    }

    public final Object getItem(int i) {
        return this.f2241b.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = this.f2242c.inflate(R.layout.litview_item_scriptlog, (ViewGroup) null);
            bVar = new b();
            bVar.f2245a = (TextView) view.findViewById(R.id.tv_listviewitem_scriptlog_size);
            bVar.f2246b = (TextView) view.findViewById(R.id.tv_listviewitem_scriptlog_name);
            bVar.f2247c = (CheckBox) view.findViewById(R.id.cb_listviewitem_scriptlog_select);
            bVar.d = (ImageView) view.findViewById(R.id.img_listviewitem_scriptlog_select);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        ScriptLog scriptLog = this.f2241b.get(i);
        if (this.f2240a) {
            bVar.f2247c.setVisibility(0);
            bVar.d.setVisibility(8);
        } else {
            bVar.f2247c.setVisibility(8);
            bVar.d.setVisibility(0);
        }
        bVar.f2245a.setText(scriptLog.getSize());
        bVar.f2246b.setText(scriptLog.getName());
        bVar.f2247c.setOnCheckedChangeListener(new C0032a(i));
        bVar.f2247c.setChecked(scriptLog.isSelect());
        return view;
    }
}
