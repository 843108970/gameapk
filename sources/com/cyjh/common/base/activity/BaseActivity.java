package com.cyjh.common.base.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import com.cyjh.common.R;
import com.cyjh.common.f.c;
import com.cyjh.common.receiver.NetworkStatusReceiver;
import com.cyjh.common.util.ag;
import java.util.ArrayList;
import java.util.Iterator;

public class BaseActivity extends FragmentActivity {

    /* renamed from: a  reason: collision with root package name */
    protected ProgressDialog f1624a;

    /* renamed from: b  reason: collision with root package name */
    private NetworkStatusReceiver f1625b;

    /* renamed from: c  reason: collision with root package name */
    private c f1626c;
    private ArrayList<a> d = new ArrayList<>();

    public interface a {
        boolean a();
    }

    private void a(Context context, int i, int i2) {
        this.f1624a = new ProgressDialog(context);
        this.f1624a.setTitle(context.getString(i));
        this.f1624a.setProgressStyle(0);
        this.f1624a.setMessage(context.getString(i2));
        this.f1624a.setCanceledOnTouchOutside(false);
        this.f1624a.show();
    }

    private void a(a aVar) {
        this.d.add(aVar);
    }

    private void b() {
        this.f1624a.dismiss();
    }

    private void b(a aVar) {
        this.d.remove(aVar);
    }

    protected static void h_() {
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Iterator<a> it = this.d.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        com.cyjh.common.g.a.a();
        com.cyjh.common.g.a.a((Activity) this);
        this.f1626c = new c() {
            public final void a(boolean z) {
                BaseActivity.h_();
                if (!z) {
                    ag.b((Context) BaseActivity.this, R.string.network_off);
                }
            }
        };
        this.f1625b = new NetworkStatusReceiver();
        this.f1625b.f1638a = this.f1626c;
        registerReceiver(this.f1625b, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f1625b);
        com.cyjh.common.g.a.a();
        com.cyjh.common.g.a.b((Activity) this);
    }
}
