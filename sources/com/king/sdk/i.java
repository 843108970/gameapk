package com.king.sdk;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.king.sdk.a.a;

public final class i {

    /* renamed from: b  reason: collision with root package name */
    private static i f3532b;

    /* renamed from: a  reason: collision with root package name */
    private b f3533a;

    private i(b bVar) {
        this.f3533a = bVar;
    }

    public static synchronized i a(Context context) {
        b a2;
        synchronized (i.class) {
            if (f3532b != null) {
                i iVar = f3532b;
                return iVar;
            }
            b a3 = a.a();
            if (a3 != null) {
                f3532b = new i(a3);
            } else {
                Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("GET_KING_SERVICE"));
                if (!(registerReceiver == null || (a2 = c.a(a.a(registerReceiver, "GET_KING_SERVICE"))) == null)) {
                    f3532b = new i(a2);
                }
            }
            i iVar2 = f3532b;
            return iVar2;
        }
    }

    public final void a(IDFEE16B42C8B2890D8FF2860AF5562B1 idfee16b42c8b2890d8ff2860af5562b1) {
        try {
            this.f3533a.a(idfee16b42c8b2890d8ff2860af5562b1);
        } catch (Exception unused) {
        }
    }

    public final void a(KingListener kingListener) {
        try {
            this.f3533a.b((IDFEE16B42C8B2890D8FF2860AF5562B1) kingListener);
        } catch (Exception unused) {
        }
    }

    public final void a(String[] strArr, int i, String str, String str2) {
        try {
            this.f3533a.a(strArr, i, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final boolean a(String str, int i, byte[] bArr) {
        try {
            return this.f3533a.a(str, (String) null, i, bArr, (PendingIntent) null, (PendingIntent) null);
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean a(String str, String str2) {
        try {
            return this.f3533a.a(str, (String) null, str2, (PendingIntent) null, (PendingIntent) null);
        } catch (Exception unused) {
            return false;
        }
    }
}
