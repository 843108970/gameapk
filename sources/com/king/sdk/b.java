package com.king.sdk;

import android.accounts.Account;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;

public interface b extends IInterface {
    int a();

    int a(Account account, String str, String str2, String str3);

    Intent a(String str);

    String a(Account account);

    void a(int i);

    void a(int i, int i2, String str);

    void a(ComponentName componentName, int i, int i2);

    void a(IDFEE16B42C8B2890D8FF2860AF5562B1 idfee16b42c8b2890d8ff2860af5562b1);

    void a(String str, int i, int i2);

    void a(String str, int i, String str2, Notification notification);

    void a(String str, IBinder iBinder, int i);

    void a(String str, String str2, int i);

    void a(String str, boolean z);

    void a(String[] strArr, int i, String str, String str2);

    boolean a(String str, String str2);

    boolean a(String str, String str2, int i, byte[] bArr, PendingIntent pendingIntent, PendingIntent pendingIntent2);

    boolean a(String str, String str2, String str3, PendingIntent pendingIntent, PendingIntent pendingIntent2);

    int b(Account account, String str, String str2, String str3);

    IBinder b(String str);

    void b(IDFEE16B42C8B2890D8FF2860AF5562B1 idfee16b42c8b2890d8ff2860af5562b1);

    byte[] b();

    String c();

    void c(String str);

    String d();

    boolean d(String str);

    int e();

    void e(String str);

    String f();

    String g();
}
