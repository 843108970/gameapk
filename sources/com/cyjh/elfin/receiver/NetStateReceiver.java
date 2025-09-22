package com.cyjh.elfin.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.x;
import java.util.ArrayList;

public class NetStateReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2065a = "android.net.conn.CONNECTIVITY_CHANGE";

    /* renamed from: b  reason: collision with root package name */
    private static final String f2066b = "NetStateReceiver";

    /* renamed from: c  reason: collision with root package name */
    private static boolean f2067c = false;
    private static int d;
    private static ArrayList<a> e = new ArrayList<>();
    private static BroadcastReceiver f;

    public interface a {
        void a();

        void b();
    }

    private static BroadcastReceiver a() {
        if (f == null) {
            synchronized (NetStateReceiver.class) {
                if (f == null) {
                    f = new NetStateReceiver();
                }
            }
        }
        return f;
    }

    public static void a(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(f2065a);
        context.getApplicationContext().registerReceiver(a(), intentFilter);
    }

    public static void a(a aVar) {
        if (e == null) {
            e = new ArrayList<>();
        }
        e.add(aVar);
    }

    public static void b(Context context) {
        if (f != null) {
            try {
                context.getApplicationContext().unregisterReceiver(f);
            } catch (Exception unused) {
            }
        }
    }

    private static void b(a aVar) {
        if (e != null && e.contains(aVar)) {
            e.remove(aVar);
        }
    }

    private static boolean b() {
        return f2067c;
    }

    private static int c() {
        return d;
    }

    private static void c(Context context) {
        Intent intent = new Intent();
        intent.setAction(f2065a);
        context.sendBroadcast(intent);
    }

    private static void d() {
        if (!e.isEmpty()) {
            int size = e.size();
            for (int i = 0; i < size; i++) {
                a aVar = e.get(i);
                if (aVar != null) {
                    if (f2067c) {
                        aVar.a();
                    } else {
                        aVar.b();
                    }
                }
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        f = this;
        if (intent.getAction().equalsIgnoreCase(f2065a)) {
            if (!x.a(context)) {
                ad.b(getClass().getName(), "<--- network disconnected --->");
                f2067c = false;
            } else {
                ad.b(getClass().getName(), "<--- network connected --->");
                f2067c = true;
                d = x.b(context);
            }
            if (!e.isEmpty()) {
                int size = e.size();
                for (int i = 0; i < size; i++) {
                    a aVar = e.get(i);
                    if (aVar != null) {
                        if (f2067c) {
                            aVar.a();
                        } else {
                            aVar.b();
                        }
                    }
                }
            }
        }
    }
}
