package com.cyjh.elfin.ui.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.cyjh.common.base.activity.BaseActivity;
import com.cyjh.common.util.o;
import com.cyjh.elfin.entity.ScriptLog;
import com.cyjh.elfin.ui.view.customview.TitleView;
import com.umeng.analytics.MobclickAgent;
import com.ywfzjbcy.R;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;

public class ScriptLogDetailActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private TitleView f2169b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public TextView f2170c;
    private Button d;
    /* access modifiers changed from: private */
    public ScriptLog e;
    private boolean f;

    private class a implements TitleView.a {
        private a() {
        }

        /* synthetic */ a(ScriptLogDetailActivity scriptLogDetailActivity, byte b2) {
            this();
        }

        public final void a() {
            ScriptLogDetailActivity.this.finish();
        }
    }

    private class b extends AsyncTask<File, Integer, String> {
        private b() {
        }

        /* synthetic */ b(ScriptLogDetailActivity scriptLogDetailActivity, byte b2) {
            this();
        }

        private String a() {
            try {
                return o.a(ScriptLogDetailActivity.this.e.getFile(), 0);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        private void a(String str) {
            super.onPostExecute(str);
            ScriptLogDetailActivity.this.f2170c.setText(str);
            ScriptLogDetailActivity.this.f1624a.dismiss();
        }

        private void a(Integer... numArr) {
            super.onProgressUpdate(numArr);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return a();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            String str = (String) obj;
            super.onPostExecute(str);
            ScriptLogDetailActivity.this.f2170c.setText(str);
            ScriptLogDetailActivity.this.f1624a.dismiss();
        }

        /* access modifiers changed from: protected */
        public final void onPreExecute() {
            super.onPreExecute();
            ScriptLogDetailActivity.a(ScriptLogDetailActivity.this, ScriptLogDetailActivity.this);
        }

        /* access modifiers changed from: protected */
        public final /* bridge */ /* synthetic */ void onProgressUpdate(Object[] objArr) {
            super.onProgressUpdate((Integer[]) objArr);
        }
    }

    static /* synthetic */ void a(ScriptLogDetailActivity scriptLogDetailActivity, Context context) {
        scriptLogDetailActivity.f1624a = new ProgressDialog(context);
        scriptLogDetailActivity.f1624a.setTitle(context.getString(R.string.scriptlogdetail_progressdialog_title));
        scriptLogDetailActivity.f1624a.setProgressStyle(0);
        scriptLogDetailActivity.f1624a.setMessage(context.getString(R.string.scriptlogdetail_progressdialog_content));
        scriptLogDetailActivity.f1624a.setCanceledOnTouchOutside(false);
        scriptLogDetailActivity.f1624a.show();
    }

    private void b() {
        Intent intent = getIntent();
        this.f = intent.getBooleanExtra(com.cyjh.elfin.a.a.F, false);
        this.e = (ScriptLog) intent.getParcelableExtra(com.cyjh.elfin.a.a.G);
    }

    private void c() {
        this.f2169b = (TitleView) findViewById(R.id.titleview_scriptlogdetail);
        this.f2169b.setTitleText(this.e.getName());
        this.f2169b.setVisibilityRightImage(4);
        this.f2169b.setleftImage(R.drawable.ic_back);
        this.f2169b.setOnLeftImageViewListener(new a(this, (byte) 0));
        this.f2169b.setTitleSize(18);
        this.d = (Button) findViewById(R.id.btn_scriptlogdetail_showmore);
        if (this.f) {
            this.d.setVisibility(0);
            this.d.setOnClickListener(this);
        } else {
            this.d.setVisibility(8);
        }
        this.f2170c = (TextView) findViewById(R.id.tv_scriptlogdetail_scriptlog);
        new b(this, (byte) 0).executeOnExecutor(Executors.newCachedThreadPool(), new File[]{this.e.getFile()});
    }

    private void d() {
        this.f2169b = (TitleView) findViewById(R.id.titleview_scriptlogdetail);
        this.f2169b.setTitleText(this.e.getName());
        this.f2169b.setVisibilityRightImage(4);
        this.f2169b.setleftImage(R.drawable.ic_back);
        this.f2169b.setOnLeftImageViewListener(new a(this, (byte) 0));
        this.f2169b.setTitleSize(18);
    }

    private void e() {
        this.d = (Button) findViewById(R.id.btn_scriptlogdetail_showmore);
        if (this.f) {
            this.d.setVisibility(0);
            this.d.setOnClickListener(this);
            return;
        }
        this.d.setVisibility(8);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_scriptlogdetail_showmore) {
            startActivity(new Intent(this, ScriptLogActivity.class));
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_scriptlogdetail);
        Intent intent = getIntent();
        this.f = intent.getBooleanExtra(com.cyjh.elfin.a.a.F, false);
        this.e = (ScriptLog) intent.getParcelableExtra(com.cyjh.elfin.a.a.G);
        this.f2169b = (TitleView) findViewById(R.id.titleview_scriptlogdetail);
        this.f2169b.setTitleText(this.e.getName());
        this.f2169b.setVisibilityRightImage(4);
        this.f2169b.setleftImage(R.drawable.ic_back);
        this.f2169b.setOnLeftImageViewListener(new a(this, (byte) 0));
        this.f2169b.setTitleSize(18);
        this.d = (Button) findViewById(R.id.btn_scriptlogdetail_showmore);
        if (this.f) {
            this.d.setVisibility(0);
            this.d.setOnClickListener(this);
        } else {
            this.d.setVisibility(8);
        }
        this.f2170c = (TextView) findViewById(R.id.tv_scriptlogdetail_scriptlog);
        new b(this, (byte) 0).executeOnExecutor(Executors.newCachedThreadPool(), new File[]{this.e.getFile()});
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(ScriptLogDetailActivity.class.getCanonicalName());
        MobclickAgent.onPause(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(ScriptLogDetailActivity.class.getCanonicalName());
        MobclickAgent.onResume(this);
    }
}
