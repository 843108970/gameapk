package com.cyjh.mobileanjian.ipc.stuff;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;
import com.goldcoast.sdk.domain.AnalyseResult;

public class AnalyseResultWrapper {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static Context f2584a;

    /* renamed from: b  reason: collision with root package name */
    private static Handler f2585b = new Handler() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            String string = message.getData().getString("result");
            int i = message.getData().getInt(NotificationCompat.CATEGORY_STATUS);
            Log.i("MyApp", string);
            if (i == 1) {
                Toast.makeText(AnalyseResultWrapper.f2584a, string, 0).show();
            }
        }
    };

    static /* synthetic */ void a(String str, int i) {
        if (f2585b != null) {
            Message obtainMessage = f2585b.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putString("result", str);
            bundle.putInt(NotificationCompat.CATEGORY_STATUS, i);
            obtainMessage.setData(bundle);
            f2585b.sendMessage(obtainMessage);
        }
    }

    private static void b(String str, int i) {
        if (f2585b != null) {
            Message obtainMessage = f2585b.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putString("result", str);
            bundle.putInt(NotificationCompat.CATEGORY_STATUS, i);
            obtainMessage.setData(bundle);
            f2585b.sendMessage(obtainMessage);
        }
    }

    public static AnalyseResult resultBuilder(Context context) {
        f2584a = context;
        return new AnalyseResult() {
            public final void onException(String str) {
                AnalyseResultWrapper.a(str, 3);
            }

            public final void onFailed(String str) {
                AnalyseResultWrapper.a(str, 1);
            }

            public final void onProgress(String str) {
                AnalyseResultWrapper.a(str, 2);
            }

            public final void onSuccess(String str) {
                AnalyseResultWrapper.a(str, 0);
            }
        };
    }

    public static AnalyseResult resultBuilder(Context context, Handler handler) {
        f2584a = context;
        f2585b = null;
        f2585b = handler;
        return resultBuilder(context);
    }
}
