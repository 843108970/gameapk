package com.cyjh.elfin.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import com.cyjh.common.base.activity.BaseActivity;
import com.cyjh.common.util.o;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.e.c.g;
import com.cyjh.elfin.entity.ScriptLog;
import com.cyjh.elfin.ui.view.customview.TitleView;
import com.umeng.analytics.MobclickAgent;
import com.ywfzjbcy.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ScriptLogActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public TitleView f2165b;

    /* renamed from: c  reason: collision with root package name */
    private ListView f2166c;
    /* access modifiers changed from: private */
    public Button d;
    /* access modifiers changed from: private */
    public Button e;
    /* access modifiers changed from: private */
    public ArrayList<ScriptLog> f;
    /* access modifiers changed from: private */
    public com.cyjh.elfin.ui.adpter.a g;
    /* access modifiers changed from: private */
    public boolean h = false;

    private class a implements TitleView.a {
        private a() {
        }

        /* synthetic */ a(ScriptLogActivity scriptLogActivity, byte b2) {
            this();
        }

        public final void a() {
            ScriptLogActivity.this.finish();
        }
    }

    private class b implements TitleView.b {
        private b() {
        }

        /* synthetic */ b(ScriptLogActivity scriptLogActivity, byte b2) {
            this();
        }

        public final void a() {
            TitleView d;
            int i;
            boolean unused = ScriptLogActivity.this.h = !ScriptLogActivity.this.h;
            if (ScriptLogActivity.this.h) {
                ScriptLogActivity.this.d.setVisibility(0);
                ScriptLogActivity.this.e.setVisibility(0);
                d = ScriptLogActivity.this.f2165b;
                i = R.drawable.ic_cancel;
            } else {
                ScriptLogActivity.this.d.setVisibility(8);
                ScriptLogActivity.this.e.setVisibility(8);
                d = ScriptLogActivity.this.f2165b;
                i = R.drawable.ic_manage;
            }
            d.setRightImage(i);
            Iterator it = ScriptLogActivity.this.f.iterator();
            while (it.hasNext()) {
                ((ScriptLog) it.next()).setSelect(false);
            }
            ScriptLogActivity.this.g.f2240a = ScriptLogActivity.this.h;
            ScriptLogActivity.this.g.notifyDataSetChanged();
        }
    }

    private void b() {
        this.f2165b = (TitleView) findViewById(R.id.titleview_scriptlog);
        this.f2165b.setTitleText((int) R.string.scriptlog);
        this.f2165b.setleftImage(R.drawable.ic_back);
        this.f2165b.setOnLeftImageViewListener(new a(this, (byte) 0));
        this.f2165b.setRightImage(R.drawable.ic_manage);
        this.f2165b.setOnRightImageViewListener(new b(this, (byte) 0));
        this.f2166c = (ListView) findViewById(R.id.listview_scriptlog);
        this.f2166c.setOnItemClickListener(this);
        File[] listFiles = new File(AppContext.a().f1856c).listFiles(new o.a(com.cyjh.elfin.a.a.E));
        this.f = new ArrayList<>();
        if (listFiles != null) {
            Arrays.sort(listFiles, new g());
            for (File file : listFiles) {
                ScriptLog scriptLog = new ScriptLog();
                scriptLog.setSize(o.a(file.length()));
                scriptLog.setName(file.getName());
                scriptLog.setFile(file);
                this.f.add(scriptLog);
            }
        }
        this.g = new com.cyjh.elfin.ui.adpter.a(this, this.f);
        this.f2166c.setAdapter(this.g);
        this.d = (Button) findViewById(R.id.btn_scriptlog_removeall);
        this.e = (Button) findViewById(R.id.btn_scriptlog_selectall);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
    }

    private void c() {
        this.f2165b = (TitleView) findViewById(R.id.titleview_scriptlog);
        this.f2165b.setTitleText((int) R.string.scriptlog);
        this.f2165b.setleftImage(R.drawable.ic_back);
        this.f2165b.setOnLeftImageViewListener(new a(this, (byte) 0));
        this.f2165b.setRightImage(R.drawable.ic_manage);
        this.f2165b.setOnRightImageViewListener(new b(this, (byte) 0));
    }

    private void d() {
        this.f2166c = (ListView) findViewById(R.id.listview_scriptlog);
        this.f2166c.setOnItemClickListener(this);
        File[] listFiles = new File(AppContext.a().f1856c).listFiles(new o.a(com.cyjh.elfin.a.a.E));
        this.f = new ArrayList<>();
        if (listFiles != null) {
            Arrays.sort(listFiles, new g());
            for (File file : listFiles) {
                ScriptLog scriptLog = new ScriptLog();
                scriptLog.setSize(o.a(file.length()));
                scriptLog.setName(file.getName());
                scriptLog.setFile(file);
                this.f.add(scriptLog);
            }
        }
        this.g = new com.cyjh.elfin.ui.adpter.a(this, this.f);
        this.f2166c.setAdapter(this.g);
    }

    private void e() {
        File[] listFiles = new File(AppContext.a().f1856c).listFiles(new o.a(com.cyjh.elfin.a.a.E));
        this.f = new ArrayList<>();
        if (listFiles != null) {
            Arrays.sort(listFiles, new g());
            for (File file : listFiles) {
                ScriptLog scriptLog = new ScriptLog();
                scriptLog.setSize(o.a(file.length()));
                scriptLog.setName(file.getName());
                scriptLog.setFile(file);
                this.f.add(scriptLog);
            }
        }
    }

    private void f() {
        boolean z;
        Iterator<ScriptLog> it = this.f.iterator();
        while (true) {
            z = false;
            if (it.hasNext()) {
                if (it.next().isSelect()) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z) {
            AppContext.a().a(R.string.scriptlog_unselect);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ScriptLog> it2 = this.f.iterator();
        while (it2.hasNext()) {
            ScriptLog next = it2.next();
            if (next.isSelect() && next.getFile().delete()) {
                arrayList.add(next);
            }
        }
        this.f.removeAll(arrayList);
        this.g.notifyDataSetChanged();
    }

    public void onClick(View view) {
        boolean z = true;
        switch (view.getId()) {
            case R.id.btn_scriptlog_removeall /*2131755236*/:
                Iterator<ScriptLog> it = this.f.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                    } else if (it.next().isSelect()) {
                    }
                }
                if (!z) {
                    AppContext.a().a(R.string.scriptlog_unselect);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<ScriptLog> it2 = this.f.iterator();
                while (it2.hasNext()) {
                    ScriptLog next = it2.next();
                    if (next.isSelect() && next.getFile().delete()) {
                        arrayList.add(next);
                    }
                }
                this.f.removeAll(arrayList);
                this.g.notifyDataSetChanged();
                return;
            case R.id.btn_scriptlog_selectall /*2131755237*/:
                Iterator<ScriptLog> it3 = this.f.iterator();
                while (it3.hasNext()) {
                    it3.next().setSelect(true);
                }
                this.g.notifyDataSetChanged();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_scriptlog);
        this.f2165b = (TitleView) findViewById(R.id.titleview_scriptlog);
        this.f2165b.setTitleText((int) R.string.scriptlog);
        this.f2165b.setleftImage(R.drawable.ic_back);
        this.f2165b.setOnLeftImageViewListener(new a(this, (byte) 0));
        this.f2165b.setRightImage(R.drawable.ic_manage);
        this.f2165b.setOnRightImageViewListener(new b(this, (byte) 0));
        this.f2166c = (ListView) findViewById(R.id.listview_scriptlog);
        this.f2166c.setOnItemClickListener(this);
        File[] listFiles = new File(AppContext.a().f1856c).listFiles(new o.a(com.cyjh.elfin.a.a.E));
        this.f = new ArrayList<>();
        if (listFiles != null) {
            Arrays.sort(listFiles, new g());
            for (File file : listFiles) {
                ScriptLog scriptLog = new ScriptLog();
                scriptLog.setSize(o.a(file.length()));
                scriptLog.setName(file.getName());
                scriptLog.setFile(file);
                this.f.add(scriptLog);
            }
        }
        this.g = new com.cyjh.elfin.ui.adpter.a(this, this.f);
        this.f2166c.setAdapter(this.g);
        this.d = (Button) findViewById(R.id.btn_scriptlog_removeall);
        this.e = (Button) findViewById(R.id.btn_scriptlog_selectall);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!this.h) {
            Intent intent = new Intent(this, ScriptLogDetailActivity.class);
            intent.putExtra(com.cyjh.elfin.a.a.F, false);
            intent.putExtra(com.cyjh.elfin.a.a.G, this.f.get(i));
            startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(ScriptLogActivity.class.getCanonicalName());
        MobclickAgent.onPause(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(ScriptLogActivity.class.getCanonicalName());
        MobclickAgent.onResume(this);
    }
}
