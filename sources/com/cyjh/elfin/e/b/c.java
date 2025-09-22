package com.cyjh.elfin.e.b;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.n;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.e.c.o;
import com.cyjh.elfin.floatingwindowprocess.service.a;
import com.cyjh.mobileanjian.ipc.interfaces.OnScreenShotCallback;
import com.cyjh.mq.sdk.MqRunner;
import com.google.protobuf.ByteString;

public final class c extends AsyncTask<Void, Void, String> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1900a = "MyAsyncTask";

    private String a() {
        final String absolutePath = n.a(AppContext.a().getPackageName(), "screen_capture.png").getAbsolutePath();
        MqRunner.getInstance().a((OnScreenShotCallback) new OnScreenShotCallback() {
            public final void onScreenShotDone(String str, ByteString byteString) {
                a a2;
                String str2;
                int intValue = Integer.valueOf(str).intValue();
                int i = 65535 & intValue;
                int i2 = intValue >> 16;
                ad.c(c.f1900a, "onScreenShotDone -->　width=" + i2 + ",height = " + i);
                Bitmap a3 = o.a(i2, i, byteString);
                if (a3 != null) {
                    n.a(a3, r3);
                    a2 = a.a();
                    str2 = r3;
                } else {
                    a2 = a.a();
                    str2 = "";
                }
                a2.a(6, 1003, str2);
            }

            public final void onScreenShotFailed(int i) {
                a.a().a(6, 1003, "");
            }
        });
        return absolutePath;
    }

    private static void b() {
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        final String absolutePath = n.a(AppContext.a().getPackageName(), "screen_capture.png").getAbsolutePath();
        MqRunner.getInstance().a((OnScreenShotCallback) new OnScreenShotCallback() {
            public final void onScreenShotDone(String str, ByteString byteString) {
                a a2;
                String str2;
                int intValue = Integer.valueOf(str).intValue();
                int i = 65535 & intValue;
                int i2 = intValue >> 16;
                ad.c(c.f1900a, "onScreenShotDone -->　width=" + i2 + ",height = " + i);
                Bitmap a3 = o.a(i2, i, byteString);
                if (a3 != null) {
                    n.a(a3, absolutePath);
                    a2 = a.a();
                    str2 = absolutePath;
                } else {
                    a2 = a.a();
                    str2 = "";
                }
                a2.a(6, 1003, str2);
            }

            public final void onScreenShotFailed(int i) {
                a.a().a(6, 1003, "");
            }
        });
        return absolutePath;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
    }
}
