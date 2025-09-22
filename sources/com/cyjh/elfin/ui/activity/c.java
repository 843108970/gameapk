package com.cyjh.elfin.ui.activity;

import android.app.AlertDialog;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.cyjh.common.util.ag;
import com.cyjh.elfin.ui.a.b;
import com.cyjh.elfin.ui.activity.SplashActivity;
import com.cyjh.elfin.ui.model.SplashModel;
import com.ywfzjbcy.R;

final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    private final SplashActivity f2208a;

    c(SplashActivity splashActivity) {
        this.f2208a = splashActivity;
    }

    public final void onChanged(Object obj) {
        SplashActivity splashActivity = this.f2208a;
        SplashModel.a aVar = (SplashModel.a) obj;
        if (aVar == null) {
            ag.b((Context) splashActivity.getApplication(), (int) R.string.response_data_null);
            return;
        }
        switch (aVar.f2302a) {
            case -1:
                b.a();
                AlertDialog a2 = b.a((Context) splashActivity.getApplication(), (int) R.layout.dialog_network_inspection);
                a2.setCancelable(false);
                a2.show();
                ((TextView) a2.findViewById(R.id.id_tv_reset)).setOnClickListener(new SplashActivity.d(splashActivity, a2, (byte) 0));
                ((TextView) a2.findViewById(R.id.id_tv_setting)).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        SplashActivity.this.startActivity(new Intent("android.settings.DATA_ROAMING_SETTINGS"));
                    }
                });
                return;
            case 0:
                int i = aVar.f2304c;
                String str = aVar.f2303b;
                b.a();
                SplashActivity.b bVar = new SplashActivity.b(splashActivity, (byte) 0);
                AlertDialog a3 = b.a((Context) splashActivity, (int) R.layout.dialog_version_inspection);
                a3.setCancelable(false);
                a3.show();
                ((TextView) a3.findViewById(R.id.id_tv_message)).setText(str);
                bVar.f2248b = a3;
                bVar.f2249c = i;
                ((TextView) a3.findViewById(R.id.id_tv_known)).setOnClickListener(bVar);
                return;
            case 1:
                splashActivity.f();
                return;
            default:
                return;
        }
    }
}
