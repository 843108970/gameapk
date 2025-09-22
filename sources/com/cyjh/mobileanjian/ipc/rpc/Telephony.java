package com.cyjh.mobileanjian.ipc.rpc;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.SmsManager;

public class Telephony {

    /* renamed from: a  reason: collision with root package name */
    private static Context f2573a;

    public static void dialNumber(String str, String str2) {
        Intent intent;
        if (str2.equals("1")) {
            intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + str));
        } else {
            intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
        }
        intent.addFlags(268435456);
        f2573a.startActivity(intent);
    }

    public static void init(Context context) {
        f2573a = context;
    }

    public static void sendSMS(String str, String str2) {
        SmsManager smsManager = SmsManager.getDefault();
        if (smsManager != null) {
            smsManager.sendTextMessage(str, (String) null, str2, (PendingIntent) null, (PendingIntent) null);
        }
    }
}
