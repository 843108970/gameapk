package com.cyjh.elfin.ui.activity;

import android.app.AlertDialog;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.load.b.i;
import com.bumptech.glide.request.g;
import com.cyjh.common.base.activity.BaseModelActivity;
import com.cyjh.common.util.ag;
import com.cyjh.common.util.q;
import com.cyjh.common.util.x;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.e.c.k;
import com.cyjh.elfin.services.PhoneStateService;
import com.cyjh.elfin.ui.activity.guide.RecognitionGuideActivity;
import com.cyjh.elfin.ui.model.SplashModel;
import com.cyjh.http.bean.response.PhoneConfig;
import com.elfin.ad.activity.FullScreenTwoAdActivity;
import com.elfin.engin.a.c;
import com.ywfzjbcy.R;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SplashActivity extends BaseModelActivity<SplashModel> implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    public static final int f2181c = 8;
    private static final String f = "SplashActivity";
    private static final int h = 1;
    int d = 0;
    a e;
    private String[] g = {"android.permission.INTERNET", "android.permission.READ_PHONE_STATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.CALL_PHONE", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.SEND_SMS", "android.permission.READ_SMS", "android.permission.READ_CONTACTS", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.CAMERA"};
    /* access modifiers changed from: private */
    public ImageView i;
    /* access modifiers changed from: private */
    public TextView j;
    private LinearLayout k;
    /* access modifiers changed from: private */
    public TextView l;
    private com.elfin.ad.e.b m;
    private com.elfin.ad.c.a<String> n = new com.elfin.ad.c.a<String>() {
        private void c(String str) {
            SplashActivity.a(SplashActivity.this, str);
        }

        public final void a() {
            SplashActivity.this.l.setVisibility(0);
        }

        public final /* bridge */ /* synthetic */ void a(Object obj) {
            SplashActivity.a(SplashActivity.this, (String) obj);
        }

        public final void a(String str) {
        }

        public final void b() {
            SplashActivity splashActivity = SplashActivity.this;
            if (splashActivity.e != null) {
                splashActivity.e.cancel();
                splashActivity.d = 0;
                splashActivity.e = null;
            }
            splashActivity.e = new a(splashActivity, (byte) 0);
            splashActivity.e.start();
            SplashActivity.this.i.setOnClickListener(SplashActivity.this);
            SplashActivity.this.i.setVisibility(0);
            AndroidViewModel unused = SplashActivity.this.f1628b;
        }

        public final void b(String str) {
            if (!TextUtils.isEmpty(str)) {
                SplashActivity.this.j.setText(String.format(SplashActivity.this.getString(R.string.ad_source_mark), new Object[]{str}));
                SplashActivity.this.j.setVisibility(0);
            }
        }
    };

    private class a extends com.cyjh.common.c.a {
        private a() {
            super(8);
        }

        /* synthetic */ a(SplashActivity splashActivity, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final void a(int i) {
            SplashActivity.h(SplashActivity.this);
        }

        public final void onFinish() {
            SplashActivity.i(SplashActivity.this);
        }
    }

    private class b extends com.cyjh.elfin.ui.b.a {
        private b() {
        }

        /* synthetic */ b(SplashActivity splashActivity, byte b2) {
            this();
        }

        public final void a() {
            SplashActivity.this.f();
        }

        public final void b() {
            SplashActivity.this.stopService(new Intent(SplashActivity.this, PhoneStateService.class));
            com.elfin.engin.d.a((Context) SplashActivity.this);
            com.cyjh.common.g.a.a();
            com.cyjh.common.g.a.b();
        }
    }

    private class c extends AsyncTask<String, String, String> {
        private c() {
        }

        /* synthetic */ c(SplashActivity splashActivity, byte b2) {
            this();
        }

        private static String a() {
            String a2 = SplashActivity.a(com.cyjh.elfin.a.i);
            Log.i("ping", a2);
            return a2;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            String a2 = SplashActivity.a(com.cyjh.elfin.a.i);
            Log.i("ping", a2);
            return a2;
        }
    }

    private class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        private AlertDialog f2189b;

        private d(AlertDialog alertDialog) {
            this.f2189b = alertDialog;
        }

        /* synthetic */ d(SplashActivity splashActivity, AlertDialog alertDialog, byte b2) {
            this(alertDialog);
        }

        public final void onClick(View view) {
            this.f2189b.dismiss();
            ((SplashModel) SplashActivity.this.f1628b).b();
        }
    }

    public static String a(String str) {
        try {
            Runtime runtime = Runtime.getRuntime();
            Process exec = runtime.exec("ping -c 3 -w 100 " + str);
            int waitFor = exec.waitFor();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(readLine);
            }
            return waitFor == 0 ? "success" : "faild";
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        } catch (InterruptedException e3) {
            e3.printStackTrace();
            return "";
        }
    }

    private void a(int i2, String str) {
        com.cyjh.elfin.ui.a.b.a();
        b bVar = new b(this, (byte) 0);
        AlertDialog a2 = com.cyjh.elfin.ui.a.b.a((Context) this, (int) R.layout.dialog_version_inspection);
        a2.setCancelable(false);
        a2.show();
        ((TextView) a2.findViewById(R.id.id_tv_message)).setText(str);
        bVar.f2248b = a2;
        bVar.f2249c = i2;
        ((TextView) a2.findViewById(R.id.id_tv_known)).setOnClickListener(bVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x018e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.cyjh.elfin.ui.activity.SplashActivity r7) {
        /*
            com.cyjh.elfin.base.AppContext r0 = com.cyjh.elfin.base.AppContext.a()
            java.io.File r1 = new java.io.File
            java.lang.String r0 = r0.f1856c
            r1.<init>(r0)
            boolean r0 = r1.exists()
            if (r0 != 0) goto L_0x0014
            r1.mkdirs()
        L_0x0014:
            com.cyjh.elfin.base.AppContext r0 = com.cyjh.elfin.base.AppContext.a()
            android.bluetooth.BluetoothAdapter r1 = android.bluetooth.BluetoothAdapter.getDefaultAdapter()
            r2 = 1
            if (r1 != 0) goto L_0x0021
            r1 = 1
            goto L_0x003c
        L_0x0021:
            java.lang.String r1 = r1.getName()
            java.lang.String r3 = "zzz"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "notHasBlueTooth:"
            r4.<init>(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            android.util.Log.e(r3, r4)
            boolean r1 = android.text.TextUtils.isEmpty(r1)
        L_0x003c:
            r3 = 0
            if (r1 != 0) goto L_0x0152
            java.lang.String r1 = "sensor"
            java.lang.Object r1 = r7.getSystemService(r1)
            android.hardware.SensorManager r1 = (android.hardware.SensorManager) r1
            if (r1 == 0) goto L_0x0058
            r4 = 5
            android.hardware.Sensor r1 = r1.getDefaultSensor(r4)
            if (r1 != 0) goto L_0x0052
            r1 = 1
            goto L_0x0053
        L_0x0052:
            r1 = 0
        L_0x0053:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x005c
        L_0x0058:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r3)
        L_0x005c:
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0152
            java.lang.String r1 = "tel:123456"
            android.content.Intent r4 = new android.content.Intent
            r4.<init>()
            android.net.Uri r1 = android.net.Uri.parse(r1)
            r4.setData(r1)
            java.lang.String r1 = "android.intent.action.DIAL"
            r4.setAction(r1)
            android.content.pm.PackageManager r1 = r7.getPackageManager()
            android.content.ComponentName r1 = r4.resolveActivity(r1)
            if (r1 == 0) goto L_0x0081
            r1 = 1
            goto L_0x0082
        L_0x0081:
            r1 = 0
        L_0x0082:
            java.lang.String r4 = android.os.Build.FINGERPRINT
            java.lang.String r5 = "generic"
            boolean r4 = r4.startsWith(r5)
            if (r4 != 0) goto L_0x011f
            java.lang.String r4 = android.os.Build.FINGERPRINT
            java.lang.String r4 = r4.toLowerCase()
            java.lang.String r5 = "vbox"
            boolean r4 = r4.contains(r5)
            if (r4 != 0) goto L_0x011f
            java.lang.String r4 = android.os.Build.FINGERPRINT
            java.lang.String r4 = r4.toLowerCase()
            java.lang.String r5 = "test-keys"
            boolean r4 = r4.contains(r5)
            if (r4 != 0) goto L_0x011f
            java.lang.String r4 = android.os.Build.MODEL
            java.lang.String r5 = "google_sdk"
            boolean r4 = r4.contains(r5)
            if (r4 != 0) goto L_0x011f
            java.lang.String r4 = android.os.Build.MODEL
            java.lang.String r5 = "Emulator"
            boolean r4 = r4.contains(r5)
            if (r4 != 0) goto L_0x011f
            java.lang.String r4 = android.os.Build.SERIAL
            java.lang.String r5 = "unknown"
            boolean r4 = r4.equalsIgnoreCase(r5)
            if (r4 != 0) goto L_0x011f
            java.lang.String r4 = android.os.Build.SERIAL
            java.lang.String r5 = "android"
            boolean r4 = r4.equalsIgnoreCase(r5)
            if (r4 != 0) goto L_0x011f
            java.lang.String r4 = android.os.Build.MODEL
            java.lang.String r5 = "Android SDK built for x86"
            boolean r4 = r4.contains(r5)
            if (r4 != 0) goto L_0x011f
            java.lang.String r4 = android.os.Build.MANUFACTURER
            java.lang.String r5 = "Genymotion"
            boolean r4 = r4.contains(r5)
            if (r4 != 0) goto L_0x011f
            java.lang.String r4 = android.os.Build.BRAND
            java.lang.String r5 = "generic"
            boolean r4 = r4.startsWith(r5)
            if (r4 == 0) goto L_0x00f8
            java.lang.String r4 = android.os.Build.DEVICE
            java.lang.String r5 = "generic"
            boolean r4 = r4.startsWith(r5)
            if (r4 != 0) goto L_0x011f
        L_0x00f8:
            java.lang.String r4 = "google_sdk"
            java.lang.String r5 = android.os.Build.PRODUCT
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x011f
            java.lang.String r4 = "android"
            java.lang.String r5 = "phone"
            java.lang.Object r5 = r7.getSystemService(r5)
            android.telephony.TelephonyManager r5 = (android.telephony.TelephonyManager) r5
            java.lang.String r5 = r5.getNetworkOperatorName()
            java.lang.String r5 = r5.toLowerCase()
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x011f
            if (r1 != 0) goto L_0x011d
            goto L_0x011f
        L_0x011d:
            r1 = 0
            goto L_0x0120
        L_0x011f:
            r1 = 1
        L_0x0120:
            if (r1 != 0) goto L_0x0152
            java.lang.String r1 = com.cyjh.common.util.j.a()
            java.lang.String r4 = "zzz"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "EmulatorUtils--checkIsNotRealPhone--"
            r5.<init>(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            android.util.Log.e(r4, r5)
            java.lang.String r4 = "intel"
            boolean r4 = r1.contains(r4)
            if (r4 != 0) goto L_0x014c
            java.lang.String r4 = "amd"
            boolean r1 = r1.contains(r4)
            if (r1 == 0) goto L_0x014a
            goto L_0x014c
        L_0x014a:
            r1 = 0
            goto L_0x014d
        L_0x014c:
            r1 = 1
        L_0x014d:
            if (r1 == 0) goto L_0x0150
            goto L_0x0152
        L_0x0150:
            r1 = 0
            goto L_0x0153
        L_0x0152:
            r1 = 1
        L_0x0153:
            r0.h = r1
            android.content.Intent r0 = r7.getIntent()
            java.lang.String r1 = "type"
            java.lang.String r0 = r0.getStringExtra(r1)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x016c
            com.cyjh.elfin.base.AppContext r0 = com.cyjh.elfin.base.AppContext.a()
            r0.m = r2
            goto L_0x017c
        L_0x016c:
            com.cyjh.elfin.base.AppContext r0 = com.cyjh.elfin.base.AppContext.a()
            android.content.Intent r1 = r7.getIntent()
            java.lang.String r4 = "sIsBooted"
            boolean r1 = r1.getBooleanExtra(r4, r3)
            r0.m = r1
        L_0x017c:
            android.arch.lifecycle.AndroidViewModel r0 = r7.f1628b
            com.cyjh.elfin.ui.model.SplashModel r0 = (com.cyjh.elfin.ui.model.SplashModel) r0
            android.app.Application r1 = r0.getApplication()
            boolean r1 = com.cyjh.common.util.x.a(r1)
            if (r1 == 0) goto L_0x018e
            r0.a()
            goto L_0x0199
        L_0x018e:
            android.arch.lifecycle.MutableLiveData<com.cyjh.elfin.ui.model.SplashModel$a> r0 = r0.i
            com.cyjh.elfin.ui.model.SplashModel$a r1 = new com.cyjh.elfin.ui.model.SplashModel$a
            r4 = -1
            r1.<init>(r4)
            r0.postValue(r1)
        L_0x0199:
            com.cyjh.elfin.e.c.k.a((int) r2)
            com.cyjh.elfin.ui.activity.SplashActivity$c r0 = new com.cyjh.elfin.ui.activity.SplashActivity$c
            r0.<init>(r7, r3)
            java.util.concurrent.ExecutorService r7 = java.util.concurrent.Executors.newCachedThreadPool()
            java.lang.String[] r1 = new java.lang.String[r3]
            r0.executeOnExecutor(r7, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.elfin.ui.activity.SplashActivity.a(com.cyjh.elfin.ui.activity.SplashActivity):void");
    }

    static /* synthetic */ void a(SplashActivity splashActivity, String str) {
        if (str.endsWith(".gif")) {
            g a2 = q.a();
            a2.b(i.f1144c);
            q.a((Context) splashActivity, str, splashActivity.i, a2);
        } else {
            g a3 = q.a();
            a3.b(i.f1143b);
            q.b(splashActivity, str, splashActivity.i, a3);
        }
        splashActivity.m.b();
    }

    private /* synthetic */ void a(SplashModel.a aVar) {
        if (aVar == null) {
            ag.b((Context) getApplication(), (int) R.string.response_data_null);
            return;
        }
        switch (aVar.f2302a) {
            case -1:
                com.cyjh.elfin.ui.a.b.a();
                AlertDialog a2 = com.cyjh.elfin.ui.a.b.a((Context) getApplication(), (int) R.layout.dialog_network_inspection);
                a2.setCancelable(false);
                a2.show();
                ((TextView) a2.findViewById(R.id.id_tv_reset)).setOnClickListener(new d(this, a2, (byte) 0));
                ((TextView) a2.findViewById(R.id.id_tv_setting)).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        SplashActivity.this.startActivity(new Intent("android.settings.DATA_ROAMING_SETTINGS"));
                    }
                });
                return;
            case 0:
                int i2 = aVar.f2304c;
                String str = aVar.f2303b;
                com.cyjh.elfin.ui.a.b.a();
                b bVar = new b(this, (byte) 0);
                AlertDialog a3 = com.cyjh.elfin.ui.a.b.a((Context) this, (int) R.layout.dialog_version_inspection);
                a3.setCancelable(false);
                a3.show();
                ((TextView) a3.findViewById(R.id.id_tv_message)).setText(str);
                bVar.f2248b = a3;
                bVar.f2249c = i2;
                ((TextView) a3.findViewById(R.id.id_tv_known)).setOnClickListener(bVar);
                return;
            case 1:
                f();
                return;
            default:
                return;
        }
    }

    private /* synthetic */ void a(PhoneConfig phoneConfig) {
        if (phoneConfig != null) {
            RecognitionGuideActivity.a(this, phoneConfig);
            finish();
        }
    }

    private void b(String str) {
        if (str.endsWith(".gif")) {
            g a2 = q.a();
            a2.b(i.f1144c);
            q.a((Context) this, str, this.i, a2);
        } else {
            g a3 = q.a();
            a3.b(i.f1143b);
            q.b(this, str, this.i, a3);
        }
        this.m.b();
    }

    private void g() {
        if (this.e != null) {
            this.e.cancel();
            this.d = 0;
            this.e = null;
        }
        this.e = new a(this, (byte) 0);
        this.e.start();
    }

    static /* synthetic */ int h(SplashActivity splashActivity) {
        int i2 = splashActivity.d;
        splashActivity.d = i2 + 1;
        return i2;
    }

    private void h() {
        com.cyjh.elfin.ui.a.b.a();
        AlertDialog a2 = com.cyjh.elfin.ui.a.b.a((Context) getApplication(), (int) R.layout.dialog_network_inspection);
        a2.setCancelable(false);
        a2.show();
        ((TextView) a2.findViewById(R.id.id_tv_reset)).setOnClickListener(new d(this, a2, (byte) 0));
        ((TextView) a2.findViewById(R.id.id_tv_setting)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SplashActivity.this.startActivity(new Intent("android.settings.DATA_ROAMING_SETTINGS"));
            }
        });
    }

    private void i() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.g) {
            if (ContextCompat.checkSelfPermission(this, str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            j();
        } else {
            ActivityCompat.requestPermissions(this, (String[]) arrayList.toArray(new String[0]), 1);
        }
    }

    static /* synthetic */ void i(SplashActivity splashActivity) {
        Intent intent = new Intent(splashActivity, FullScreenTwoAdActivity.class);
        intent.addFlags(268435456);
        splashActivity.startActivity(intent);
        splashActivity.finish();
    }

    private void j() {
        c.a.f2893a.a((com.cyjh.common.f.a<String>) new com.cyjh.common.f.a<String>() {
            private void b() {
                SplashActivity.a(SplashActivity.this);
            }

            public final void a() {
                SplashActivity.a(SplashActivity.this);
            }

            public final /* bridge */ /* synthetic */ void a(Object obj) {
                SplashActivity.a(SplashActivity.this);
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x018e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void k() {
        /*
            r7 = this;
            com.cyjh.elfin.base.AppContext r0 = com.cyjh.elfin.base.AppContext.a()
            java.io.File r1 = new java.io.File
            java.lang.String r0 = r0.f1856c
            r1.<init>(r0)
            boolean r0 = r1.exists()
            if (r0 != 0) goto L_0x0014
            r1.mkdirs()
        L_0x0014:
            com.cyjh.elfin.base.AppContext r0 = com.cyjh.elfin.base.AppContext.a()
            android.bluetooth.BluetoothAdapter r1 = android.bluetooth.BluetoothAdapter.getDefaultAdapter()
            r2 = 1
            if (r1 != 0) goto L_0x0021
            r1 = 1
            goto L_0x003c
        L_0x0021:
            java.lang.String r1 = r1.getName()
            java.lang.String r3 = "zzz"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "notHasBlueTooth:"
            r4.<init>(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            android.util.Log.e(r3, r4)
            boolean r1 = android.text.TextUtils.isEmpty(r1)
        L_0x003c:
            r3 = 0
            if (r1 != 0) goto L_0x0152
            java.lang.String r1 = "sensor"
            java.lang.Object r1 = r7.getSystemService(r1)
            android.hardware.SensorManager r1 = (android.hardware.SensorManager) r1
            if (r1 == 0) goto L_0x0058
            r4 = 5
            android.hardware.Sensor r1 = r1.getDefaultSensor(r4)
            if (r1 != 0) goto L_0x0052
            r1 = 1
            goto L_0x0053
        L_0x0052:
            r1 = 0
        L_0x0053:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x005c
        L_0x0058:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r3)
        L_0x005c:
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0152
            java.lang.String r1 = "tel:123456"
            android.content.Intent r4 = new android.content.Intent
            r4.<init>()
            android.net.Uri r1 = android.net.Uri.parse(r1)
            r4.setData(r1)
            java.lang.String r1 = "android.intent.action.DIAL"
            r4.setAction(r1)
            android.content.pm.PackageManager r1 = r7.getPackageManager()
            android.content.ComponentName r1 = r4.resolveActivity(r1)
            if (r1 == 0) goto L_0x0081
            r1 = 1
            goto L_0x0082
        L_0x0081:
            r1 = 0
        L_0x0082:
            java.lang.String r4 = android.os.Build.FINGERPRINT
            java.lang.String r5 = "generic"
            boolean r4 = r4.startsWith(r5)
            if (r4 != 0) goto L_0x011f
            java.lang.String r4 = android.os.Build.FINGERPRINT
            java.lang.String r4 = r4.toLowerCase()
            java.lang.String r5 = "vbox"
            boolean r4 = r4.contains(r5)
            if (r4 != 0) goto L_0x011f
            java.lang.String r4 = android.os.Build.FINGERPRINT
            java.lang.String r4 = r4.toLowerCase()
            java.lang.String r5 = "test-keys"
            boolean r4 = r4.contains(r5)
            if (r4 != 0) goto L_0x011f
            java.lang.String r4 = android.os.Build.MODEL
            java.lang.String r5 = "google_sdk"
            boolean r4 = r4.contains(r5)
            if (r4 != 0) goto L_0x011f
            java.lang.String r4 = android.os.Build.MODEL
            java.lang.String r5 = "Emulator"
            boolean r4 = r4.contains(r5)
            if (r4 != 0) goto L_0x011f
            java.lang.String r4 = android.os.Build.SERIAL
            java.lang.String r5 = "unknown"
            boolean r4 = r4.equalsIgnoreCase(r5)
            if (r4 != 0) goto L_0x011f
            java.lang.String r4 = android.os.Build.SERIAL
            java.lang.String r5 = "android"
            boolean r4 = r4.equalsIgnoreCase(r5)
            if (r4 != 0) goto L_0x011f
            java.lang.String r4 = android.os.Build.MODEL
            java.lang.String r5 = "Android SDK built for x86"
            boolean r4 = r4.contains(r5)
            if (r4 != 0) goto L_0x011f
            java.lang.String r4 = android.os.Build.MANUFACTURER
            java.lang.String r5 = "Genymotion"
            boolean r4 = r4.contains(r5)
            if (r4 != 0) goto L_0x011f
            java.lang.String r4 = android.os.Build.BRAND
            java.lang.String r5 = "generic"
            boolean r4 = r4.startsWith(r5)
            if (r4 == 0) goto L_0x00f8
            java.lang.String r4 = android.os.Build.DEVICE
            java.lang.String r5 = "generic"
            boolean r4 = r4.startsWith(r5)
            if (r4 != 0) goto L_0x011f
        L_0x00f8:
            java.lang.String r4 = "google_sdk"
            java.lang.String r5 = android.os.Build.PRODUCT
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x011f
            java.lang.String r4 = "android"
            java.lang.String r5 = "phone"
            java.lang.Object r5 = r7.getSystemService(r5)
            android.telephony.TelephonyManager r5 = (android.telephony.TelephonyManager) r5
            java.lang.String r5 = r5.getNetworkOperatorName()
            java.lang.String r5 = r5.toLowerCase()
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x011f
            if (r1 != 0) goto L_0x011d
            goto L_0x011f
        L_0x011d:
            r1 = 0
            goto L_0x0120
        L_0x011f:
            r1 = 1
        L_0x0120:
            if (r1 != 0) goto L_0x0152
            java.lang.String r1 = com.cyjh.common.util.j.a()
            java.lang.String r4 = "zzz"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "EmulatorUtils--checkIsNotRealPhone--"
            r5.<init>(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            android.util.Log.e(r4, r5)
            java.lang.String r4 = "intel"
            boolean r4 = r1.contains(r4)
            if (r4 != 0) goto L_0x014c
            java.lang.String r4 = "amd"
            boolean r1 = r1.contains(r4)
            if (r1 == 0) goto L_0x014a
            goto L_0x014c
        L_0x014a:
            r1 = 0
            goto L_0x014d
        L_0x014c:
            r1 = 1
        L_0x014d:
            if (r1 == 0) goto L_0x0150
            goto L_0x0152
        L_0x0150:
            r1 = 0
            goto L_0x0153
        L_0x0152:
            r1 = 1
        L_0x0153:
            r0.h = r1
            android.content.Intent r0 = r7.getIntent()
            java.lang.String r1 = "type"
            java.lang.String r0 = r0.getStringExtra(r1)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x016c
            com.cyjh.elfin.base.AppContext r0 = com.cyjh.elfin.base.AppContext.a()
            r0.m = r2
            goto L_0x017c
        L_0x016c:
            com.cyjh.elfin.base.AppContext r0 = com.cyjh.elfin.base.AppContext.a()
            android.content.Intent r1 = r7.getIntent()
            java.lang.String r4 = "sIsBooted"
            boolean r1 = r1.getBooleanExtra(r4, r3)
            r0.m = r1
        L_0x017c:
            android.arch.lifecycle.AndroidViewModel r0 = r7.f1628b
            com.cyjh.elfin.ui.model.SplashModel r0 = (com.cyjh.elfin.ui.model.SplashModel) r0
            android.app.Application r1 = r0.getApplication()
            boolean r1 = com.cyjh.common.util.x.a(r1)
            if (r1 == 0) goto L_0x018e
            r0.a()
            goto L_0x0199
        L_0x018e:
            android.arch.lifecycle.MutableLiveData<com.cyjh.elfin.ui.model.SplashModel$a> r0 = r0.i
            com.cyjh.elfin.ui.model.SplashModel$a r1 = new com.cyjh.elfin.ui.model.SplashModel$a
            r4 = -1
            r1.<init>(r4)
            r0.postValue(r1)
        L_0x0199:
            com.cyjh.elfin.e.c.k.a((int) r2)
            com.cyjh.elfin.ui.activity.SplashActivity$c r0 = new com.cyjh.elfin.ui.activity.SplashActivity$c
            r0.<init>(r7, r3)
            java.util.concurrent.ExecutorService r1 = java.util.concurrent.Executors.newCachedThreadPool()
            java.lang.String[] r2 = new java.lang.String[r3]
            r0.executeOnExecutor(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.elfin.ui.activity.SplashActivity.k():void");
    }

    private void l() {
        SplashModel splashModel = (SplashModel) this.f1628b;
        if (x.a(splashModel.getApplication())) {
            splashModel.a();
        } else {
            splashModel.i.postValue(new SplashModel.a(-1));
        }
        k.a(1);
    }

    private void m() {
        Intent intent = new Intent(this, FullScreenTwoAdActivity.class);
        intent.addFlags(268435456);
        startActivity(intent);
        finish();
    }

    private void n() {
        this.m.a(1, (com.elfin.ad.c.a) this.n);
    }

    private void o() {
        if (this.e != null) {
            this.e.cancel();
            this.d = 0;
            this.e = null;
        }
    }

    /* access modifiers changed from: protected */
    public final Class<SplashModel> b() {
        return SplashModel.class;
    }

    /* access modifiers changed from: protected */
    public final void c() {
        ((SplashModel) this.f1628b).i.observe(this, new c(this));
        ((SplashModel) this.f1628b).j.observe(this, new d(this));
        this.m = new com.elfin.ad.e.b(this, this.i);
    }

    /* access modifiers changed from: protected */
    public final void d() {
        this.i = (ImageView) findViewById(R.id.iv_splash_ad_fullscreen);
        this.j = (TextView) findViewById(R.id.tv_splash_ad_mark);
        this.k = (LinearLayout) findViewById(R.id.id_ll_dot);
        this.l = (TextView) findViewById(R.id.tv_close_ad);
    }

    /* access modifiers changed from: protected */
    public final int e() {
        return R.layout.activity_splash2;
    }

    /* access modifiers changed from: package-private */
    public final void f() {
        if (!com.elfin.ad.e.a.a().b()) {
            this.m.a(1, (com.elfin.ad.c.a) this.n);
            return;
        }
        Intent intent = new Intent(this, ElfinFreeActivity.class);
        intent.addFlags(268435456);
        startActivity(intent);
        finish();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_close_ad) {
            com.elfin.ad.e.b bVar = this.m;
            if (bVar.d < 4) {
                bVar.c();
            } else {
                com.elfin.ad.e.b.a(bVar.j);
            }
        } else if (id == R.id.iv_splash_ad_fullscreen) {
            this.m.c();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isTaskRoot()) {
            finish();
        } else if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            for (String str : this.g) {
                if (ContextCompat.checkSelfPermission(this, str) != 0) {
                    arrayList.add(str);
                }
            }
            if (arrayList.isEmpty()) {
                j();
            } else {
                ActivityCompat.requestPermissions(this, (String[]) arrayList.toArray(new String[0]), 1);
            }
        } else {
            j();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.m != null) {
            this.m.e();
            this.m = null;
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return i2 == 4;
    }

    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        boolean z = true;
        for (int i3 : iArr) {
            if (i3 == -1) {
                z = false;
            }
        }
        if (z) {
            j();
            return;
        }
        ag.a((Context) AppContext.a(), "获取权限失败");
        finish();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.m != null) {
            com.elfin.ad.e.b bVar = this.m;
            if (bVar.f2866a) {
                com.elfin.ad.e.b.a(bVar.j);
            }
        }
    }
}
