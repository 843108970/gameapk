package com.cyjh.mobileanjian.ipc;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.PowerManager;
import android.os.Vibrator;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final String f2533c = "NO NETWORK";
    public static final String d = "WiFi";
    public static final String e = "2G";
    public static final String f = "3G";
    public static final String g = "4G";
    private static MediaPlayer k = new MediaPlayer();

    /* renamed from: a  reason: collision with root package name */
    public Context f2534a = null;

    /* renamed from: b  reason: collision with root package name */
    public com.ime.input.a f2535b;
    private PowerManager.WakeLock h;
    private PowerManager.WakeLock i;
    private KeyguardManager.KeyguardLock j;

    public a(Context context) {
        this.f2534a = context;
        this.h = ((PowerManager) this.f2534a.getSystemService("power")).newWakeLock(6, "fzcyjh");
        this.h.setReferenceCounted(false);
        this.f2535b = com.ime.input.a.a();
        this.j = ((KeyguardManager) this.f2534a.getSystemService("keyguard")).newKeyguardLock("unlock");
        this.i = ((PowerManager) this.f2534a.getSystemService("power")).newWakeLock(268435462, "lock_unlock_screen");
    }

    private void a(boolean z) {
        Settings.System.putInt(this.f2534a.getContentResolver(), "airplane_mode_on", z ? 1 : 0);
        Intent intent = new Intent("android.intent.action.AIRPLANE_MODE");
        intent.putExtra("state", z);
        this.f2534a.sendBroadcast(intent);
    }

    private void b(boolean z) {
        Settings.System.putInt(this.f2534a.getContentResolver(), "accelerometer_rotation", z ^ true ? 1 : 0);
    }

    public static void c(String str) {
        if (k == null) {
            k = new MediaPlayer();
        }
        f();
        try {
            k.reset();
            k.setDataSource(str);
            k.prepare();
            k.start();
        } catch (IOException e2) {
            e2.printStackTrace();
            k.release();
            k = null;
        }
    }

    private void e(String str) {
        InputConnection currentInputConnection;
        com.ime.input.a aVar = this.f2535b;
        if (aVar.f3525a != null && (currentInputConnection = aVar.f3525a.getCurrentInputConnection()) != null) {
            currentInputConnection.commitText(str, str.length());
        }
    }

    public static void f() {
        if (k != null && k.isPlaying()) {
            k.stop();
        }
    }

    private static void f(int i2) {
        if (i2 > 0) {
            d a2 = d.a();
            a2.a("kill " + i2);
        }
    }

    private void l() {
        this.h = ((PowerManager) this.f2534a.getSystemService("power")).newWakeLock(6, "fzcyjh");
        this.h.setReferenceCounted(false);
    }

    private boolean m() {
        try {
            return ((Vibrator) this.f2534a.getSystemService("vibrator")).hasVibrator();
        } catch (Throwable unused) {
            return false;
        }
    }

    private List<String> n() {
        ArrayList arrayList = new ArrayList();
        for (InputMethodInfo id : ((InputMethodManager) this.f2534a.getSystemService("input_method")).getInputMethodList()) {
            arrayList.add(id.getId());
        }
        return arrayList;
    }

    public final void a() {
        ((Vibrator) this.f2534a.getSystemService("vibrator")).cancel();
    }

    public final void a(int i2) {
        if (m()) {
            a();
            ((Vibrator) this.f2534a.getSystemService("vibrator")).vibrate((long) i2);
        }
    }

    public final boolean a(String str) {
        if (str == null || str.trim().equals("")) {
            return false;
        }
        try {
            Intent launchIntentForPackage = this.f2534a.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            launchIntentForPackage.setFlags(270532608);
            launchIntentForPackage.setPackage((String) null);
            this.f2534a.startActivity(launchIntentForPackage);
            StringBuilder sb = new StringBuilder("runApp(");
            sb.append(str);
            sb.append(") OK.");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final String b() {
        String string = Settings.Secure.getString(this.f2534a.getContentResolver(), "default_input_method");
        if (!string.contains("com.cyjh")) {
            return string;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (InputMethodInfo id : ((InputMethodManager) this.f2534a.getSystemService("input_method")).getInputMethodList()) {
            arrayList.add(id.getId());
        }
        for (String str : arrayList) {
            if (!str.contains("com.cyjh")) {
                return str;
            }
        }
        return string;
    }

    public final void b(int i2) {
        if (i2 > 0) {
            this.h.acquire();
        } else if (this.h != null) {
            this.h.release();
        }
    }

    public final boolean b(String str) {
        boolean z = false;
        if (str != null) {
            if (str.trim().equals("")) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) this.f2534a.getSystemService("activity")).getRunningAppProcesses()) {
                if (next.processName.equals(str)) {
                    int i2 = next.pid;
                    if (i2 > 0) {
                        d a2 = d.a();
                        a2.a("kill " + i2);
                    }
                    z = true;
                }
            }
        }
        return z;
    }

    public final String c() {
        WifiInfo connectionInfo = ((WifiManager) this.f2534a.getSystemService("wifi")).getConnectionInfo();
        return connectionInfo == null ? "" : connectionInfo.getMacAddress();
    }

    public final void c(int i2) {
        Settings.System.putInt(this.f2534a.getContentResolver(), "screen_off_timeout", i2 * 1000);
    }

    @SuppressLint({"MissingPermission"})
    public final String d() {
        String str = null;
        try {
            str = Build.VERSION.SDK_INT >= 29 ? Settings.System.getString(this.f2534a.getContentResolver(), com.cyjh.common.b.a.aM) : ((TelephonyManager) this.f2534a.getSystemService("phone")).getDeviceId();
            if (str == null || str.equals("")) {
                str = c();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return (str == null || str.equals("")) ? c() : str;
    }

    public final String d(String str) {
        try {
            return this.f2534a.getPackageManager().getApplicationInfo(str, 0).sourceDir;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final void d(int i2) {
        Settings.System.putInt(this.f2534a.getContentResolver(), "screen_brightness", (int) (((double) (i2 * 255)) / 100.0d));
    }

    public final void e() {
        String packageName = this.f2534a.getPackageName();
        ActivityManager activityManager = (ActivityManager) this.f2534a.getSystemService("activity");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (int i2 = 0; i2 < runningAppProcesses.size(); i2++) {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i2);
                if (!runningAppProcessInfo.processName.contains(packageName) && runningAppProcessInfo.importance > 200) {
                    String[] strArr = runningAppProcessInfo.pkgList;
                    for (String killBackgroundProcesses : strArr) {
                        activityManager.killBackgroundProcesses(killBackgroundProcesses);
                    }
                }
            }
        }
    }

    public final void e(int i2) {
        AudioManager audioManager = (AudioManager) this.f2534a.getSystemService("audio");
        audioManager.setStreamVolume(4, (int) (((double) (audioManager.getStreamMaxVolume(4) * i2)) / 100.0d), 8);
        audioManager.setStreamVolume(3, (int) (((double) (audioManager.getStreamMaxVolume(3) * i2)) / 100.0d), 8);
        audioManager.setStreamVolume(5, (int) (((double) (audioManager.getStreamMaxVolume(5) * i2)) / 100.0d), 8);
        audioManager.setStreamVolume(2, (int) (((double) (audioManager.getStreamMaxVolume(2) * i2)) / 100.0d), 8);
        audioManager.setStreamVolume(1, (int) (((double) (audioManager.getStreamMaxVolume(1) * i2)) / 100.0d), 8);
        audioManager.setStreamVolume(0, (int) (((double) (audioManager.getStreamMaxVolume(0) * i2)) / 100.0d), 8);
        audioManager.setStreamVolume(8, (int) (((double) (i2 * audioManager.getStreamMaxVolume(8))) / 100.0d), 8);
    }

    public final void g() {
        ((DevicePolicyManager) this.f2534a.getSystemService("device_policy")).lockNow();
        this.j.reenableKeyguard();
    }

    public final void h() {
        this.j.disableKeyguard();
        this.i.acquire();
        this.i.release();
    }

    public final String i() {
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f2534a.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return f2533c;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
            return d;
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo2 == null) {
            return f2533c;
        }
        NetworkInfo.State state2 = networkInfo2.getState();
        String subtypeName = networkInfo2.getSubtypeName();
        if (state2 == null) {
            return f2533c;
        }
        if (state2 != NetworkInfo.State.CONNECTED && state2 != NetworkInfo.State.CONNECTING) {
            return f2533c;
        }
        switch (activeNetworkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return e;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return f;
            case 13:
                return g;
            default:
                return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? f : e;
        }
    }

    public final String j() {
        try {
            return this.f2534a.getFilesDir().getAbsolutePath();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final void k() {
        Intent intent = new Intent("android.net.vpn.SETTINGS");
        intent.setFlags(268435456);
        this.f2534a.startActivity(intent);
    }
}
