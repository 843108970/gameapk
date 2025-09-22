package com.cyjh.elfin.ui.a;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.o;
import com.cyjh.elfin.receiver.NetStateReceiver;
import com.cyjh.http.bean.response.VersionUpdateInfo;
import com.cyjh.http.e.b;
import com.ywfzjbcy.R;
import java.io.File;
import java.util.concurrent.Executors;

public class h extends a implements View.OnClickListener {
    private static final int S = 500;
    private static final int T = 1000;
    private static final int U = 1001;
    private static final int V = 1002;
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public static String f2120a = "h";
    private Button K;
    private Button L;
    private LinearLayout M;
    private LinearLayout N;
    /* access modifiers changed from: private */
    public VersionUpdateInfo O;
    private boolean P;
    private String Q;
    private String R;
    /* access modifiers changed from: private */
    public boolean W;
    /* access modifiers changed from: private */
    public boolean X;
    /* access modifiers changed from: private */
    public Handler Y = new Handler(new i(this));

    /* renamed from: b  reason: collision with root package name */
    TextView f2121b;

    /* renamed from: c  reason: collision with root package name */
    Button f2122c;
    ProgressBar e;
    boolean f;
    Context g;
    protected NetStateReceiver.a h;
    /* access modifiers changed from: package-private */
    public boolean i = true;
    b.a j = new b.a() {
        public final void a(int i) {
            String b2 = h.f2120a;
            ad.c(b2, "onDownloading --> progress=" + i);
            Message obtain = Message.obtain();
            obtain.obj = Integer.valueOf(i);
            obtain.what = 1001;
            h.this.Y.sendMessage(obtain);
        }

        public final void a(File file) {
            String b2 = h.f2120a;
            ad.c(b2, "onDownloadSuccess --> file=" + file.getName());
            Message obtain = Message.obtain();
            obtain.obj = file;
            obtain.what = 1000;
            h.this.Y.sendMessage(obtain);
        }

        public final void a(Exception exc) {
            String b2 = h.f2120a;
            ad.c(b2, "onDownloadFailed --> exception=" + exc.getMessage());
            h.this.Y.sendEmptyMessage(1002);
        }
    };
    private TextView k;
    private TextView l;
    private Button m;

    private class a extends AsyncTask<String, Void, Void> {
        private a() {
        }

        /* synthetic */ a(h hVar, byte b2) {
            this();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public Void doInBackground(String... strArr) {
            try {
                boolean unused = h.this.W = true;
                File file = new File(strArr[0]);
                b.a().a(h.this.O.UpdateUrl, file.getParentFile().getAbsolutePath(), file.getName(), h.this.O.PackageSize, h.this.j);
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public final void onPreExecute() {
            super.onPreExecute();
        }
    }

    public h(Context context, VersionUpdateInfo versionUpdateInfo, boolean z) {
        super(context);
        Window window;
        int i2;
        this.P = z;
        this.g = context;
        if (this.P) {
            if (Build.VERSION.SDK_INT >= 26) {
                window = getWindow();
                i2 = 2038;
            } else if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 24) {
                window = getWindow();
                i2 = 2002;
            } else {
                window = getWindow();
                i2 = 2005;
            }
            window.setType(i2);
        }
        this.O = versionUpdateInfo;
    }

    private /* synthetic */ boolean a(Message message) {
        switch (message.what) {
            case 1000:
                File file = (File) message.obj;
                if (this.f) {
                    return false;
                }
                ad.c(f2120a, "afterDownloadSuccess --> 1 ");
                d(file);
                this.f2122c.setText("安装");
                this.f2122c.setOnClickListener(new j(this, file));
                return false;
            case 1001:
                int intValue = ((Integer) message.obj).intValue();
                TextView textView = this.f2121b;
                textView.setText(intValue + "%");
                this.e.setProgress(intValue);
                return false;
            case 1002:
                this.i = true;
                a();
                return false;
            default:
                return false;
        }
    }

    private void b(File file) {
        if (!this.f) {
            ad.c(f2120a, "afterDownloadSuccess --> 1 ");
            d(file);
            this.f2122c.setText("安装");
            this.f2122c.setOnClickListener(new j(this, file));
        }
    }

    private void c() {
        this.k = (TextView) findViewById(R.id.update_dialog_textview_size);
        this.l = (TextView) findViewById(R.id.update_dialog_textview_updatecontent);
        this.f2121b = (TextView) findViewById(R.id.update_dialog_textview_downloadprogress);
        this.m = (Button) findViewById(R.id.update_dialog_button_forceupdate);
        this.K = (Button) findViewById(R.id.update_dialog_button_updatenow);
        this.L = (Button) findViewById(R.id.update_dialog_button_nexttime);
        this.f2122c = (Button) findViewById(R.id.update_dialog_button_cancel);
        this.e = (ProgressBar) findViewById(R.id.update_dialog_progressBar);
        this.M = (LinearLayout) findViewById(R.id.update_dialog_linearlayout_update);
        this.N = (LinearLayout) findViewById(R.id.update_dialog_linearlayout_download);
        this.m.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.f2122c.setOnClickListener(this);
        a();
        this.k.setText(o.a((long) this.O.PackageSize));
        this.k.setVisibility(0);
        this.l.setText(this.O.UpdateContent);
    }

    private /* synthetic */ void c(File file) {
        try {
            dismiss();
            com.cyjh.common.util.a.a(this.g, file);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void d() {
        this.h = new NetStateReceiver.a() {
            public final void a() {
                ad.c(h.f2120a, "onNetConnected --> ");
                if (h.this.W && h.this.X) {
                    h.this.e();
                }
            }

            public final void b() {
                ad.c(h.f2120a, "onNetDisConnect --> ");
                boolean unused = h.this.X = true;
                boolean unused2 = h.this.i = true;
            }
        };
        NetStateReceiver.a(this.g);
        NetStateReceiver.a(this.h);
    }

    /* access modifiers changed from: private */
    public void e() {
        if (this.i) {
            this.i = false;
            setCanceledOnTouchOutside(false);
            setCancelable(false);
            this.N.setVisibility(0);
            this.M.setVisibility(8);
            this.m.setVisibility(8);
            new a(this, (byte) 0).executeOnExecutor(Executors.newCachedThreadPool(), new String[]{Environment.getExternalStorageDirectory() + File.separator + getContext().getPackageName() + ".apk"});
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.N.setVisibility(8);
        if (this.O.UpdateType == 1) {
            this.M.setVisibility(8);
            this.f2122c.setVisibility(8);
            this.m.setVisibility(0);
            setCancelable(false);
            setCanceledOnTouchOutside(false);
            return;
        }
        this.M.setVisibility(0);
        this.m.setVisibility(8);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void d(File file) {
        new Handler().postDelayed(new k(this, file), 500);
    }

    public void dismiss() {
        super.dismiss();
        ad.c(f2120a, "dismiss -->");
        NetStateReceiver.b(this.g);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.update_dialog_button_cancel /*2131755532*/:
                this.f = true;
                NetStateReceiver.b(this.g);
                b a2 = b.a();
                if (a2.f2526c != null) {
                    a2.f2526c.c();
                }
                dismiss();
                return;
            case R.id.update_dialog_button_forceupdate /*2131755533*/:
            case R.id.update_dialog_button_updatenow /*2131755536*/:
                e();
                return;
            case R.id.update_dialog_button_nexttime /*2131755535*/:
                dismiss();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.update_dialog);
        a(0.9f, 0.6f);
        this.k = (TextView) findViewById(R.id.update_dialog_textview_size);
        this.l = (TextView) findViewById(R.id.update_dialog_textview_updatecontent);
        this.f2121b = (TextView) findViewById(R.id.update_dialog_textview_downloadprogress);
        this.m = (Button) findViewById(R.id.update_dialog_button_forceupdate);
        this.K = (Button) findViewById(R.id.update_dialog_button_updatenow);
        this.L = (Button) findViewById(R.id.update_dialog_button_nexttime);
        this.f2122c = (Button) findViewById(R.id.update_dialog_button_cancel);
        this.e = (ProgressBar) findViewById(R.id.update_dialog_progressBar);
        this.M = (LinearLayout) findViewById(R.id.update_dialog_linearlayout_update);
        this.N = (LinearLayout) findViewById(R.id.update_dialog_linearlayout_download);
        this.m.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.f2122c.setOnClickListener(this);
        a();
        this.k.setText(o.a((long) this.O.PackageSize));
        this.k.setVisibility(0);
        this.l.setText(this.O.UpdateContent);
        this.h = new NetStateReceiver.a() {
            public final void a() {
                ad.c(h.f2120a, "onNetConnected --> ");
                if (h.this.W && h.this.X) {
                    h.this.e();
                }
            }

            public final void b() {
                ad.c(h.f2120a, "onNetDisConnect --> ");
                boolean unused = h.this.X = true;
                boolean unused2 = h.this.i = true;
            }
        };
        NetStateReceiver.a(this.g);
        NetStateReceiver.a(this.h);
    }

    public void show() {
        super.show();
    }
}
