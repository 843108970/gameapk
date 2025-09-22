package com.cyjh.elfin.e.c;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.proguard.v;
import java.io.BufferedInputStream;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private a f1911a;

    public interface a {
        void a();
    }

    private class b implements SensorEventListener {

        /* renamed from: a  reason: collision with root package name */
        SensorManager f1912a;

        b(SensorManager sensorManager) {
            this.f1912a = sensorManager;
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            this.f1912a.unregisterListener(this);
            this.f1912a = null;
        }
    }

    private static class c {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final e f1914a = new e((byte) 0);

        private c() {
        }
    }

    private e() {
    }

    /* synthetic */ e(byte b2) {
        this();
    }

    private static e a() {
        return c.f1914a;
    }

    private static String a(BufferedInputStream bufferedInputStream) {
        int read;
        byte[] bArr = new byte[512];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb.append(new String(bArr, 0, read));
                    continue;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (read >= 512);
        return sb.toString();
    }

    private static String a(String str) {
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean a(Context context) {
        return a(context, 4);
    }

    private boolean a(Context context, int i) {
        SensorManager sensorManager;
        Sensor defaultSensor;
        if (context == null || (sensorManager = (SensorManager) context.getSystemService(v.W)) == null || (defaultSensor = sensorManager.getDefaultSensor(i)) == null) {
            return false;
        }
        sensorManager.registerListener(new b(sensorManager), defaultSensor, 3);
        return true;
    }

    private static String b() {
        return b("cat /proc/cpuinfo");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.io.BufferedOutputStream} */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.io.BufferedOutputStream] */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005d A[SYNTHETIC, Splitter:B:32:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0067 A[SYNTHETIC, Splitter:B:37:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x007a A[SYNTHETIC, Splitter:B:49:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0084 A[SYNTHETIC, Splitter:B:54:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b(java.lang.String r5) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0075, all -> 0x0058 }
            java.lang.String r2 = "sh"
            java.lang.Process r1 = r1.exec(r2)     // Catch:{ Exception -> 0x0075, all -> 0x0058 }
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0056, all -> 0x0053 }
            java.io.OutputStream r3 = r1.getOutputStream()     // Catch:{ Exception -> 0x0056, all -> 0x0053 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0056, all -> 0x0053 }
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0051, all -> 0x004f }
            java.io.InputStream r4 = r1.getInputStream()     // Catch:{ Exception -> 0x0051, all -> 0x004f }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0051, all -> 0x004f }
            byte[] r5 = r5.getBytes()     // Catch:{ Exception -> 0x0078, all -> 0x004c }
            r2.write(r5)     // Catch:{ Exception -> 0x0078, all -> 0x004c }
            r5 = 10
            r2.write(r5)     // Catch:{ Exception -> 0x0078, all -> 0x004c }
            r2.flush()     // Catch:{ Exception -> 0x0078, all -> 0x004c }
            r2.close()     // Catch:{ Exception -> 0x0078, all -> 0x004c }
            r1.waitFor()     // Catch:{ Exception -> 0x0078, all -> 0x004c }
            java.lang.String r5 = a((java.io.BufferedInputStream) r3)     // Catch:{ Exception -> 0x0078, all -> 0x004c }
            r2.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x003e:
            r3.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0046:
            if (r1 == 0) goto L_0x004b
            r1.destroy()
        L_0x004b:
            return r5
        L_0x004c:
            r5 = move-exception
            r0 = r3
            goto L_0x005b
        L_0x004f:
            r5 = move-exception
            goto L_0x005b
        L_0x0051:
            r3 = r0
            goto L_0x0078
        L_0x0053:
            r5 = move-exception
            r2 = r0
            goto L_0x005b
        L_0x0056:
            r2 = r0
            goto L_0x0077
        L_0x0058:
            r5 = move-exception
            r1 = r0
            r2 = r1
        L_0x005b:
            if (r2 == 0) goto L_0x0065
            r2.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0065
        L_0x0061:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0065:
            if (r0 == 0) goto L_0x006f
            r0.close()     // Catch:{ IOException -> 0x006b }
            goto L_0x006f
        L_0x006b:
            r0 = move-exception
            r0.printStackTrace()
        L_0x006f:
            if (r1 == 0) goto L_0x0074
            r1.destroy()
        L_0x0074:
            throw r5
        L_0x0075:
            r1 = r0
            r2 = r1
        L_0x0077:
            r3 = r2
        L_0x0078:
            if (r2 == 0) goto L_0x0082
            r2.close()     // Catch:{ IOException -> 0x007e }
            goto L_0x0082
        L_0x007e:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0082:
            if (r3 == 0) goto L_0x008c
            r3.close()     // Catch:{ IOException -> 0x0088 }
            goto L_0x008c
        L_0x0088:
            r5 = move-exception
            r5.printStackTrace()
        L_0x008c:
            if (r1 == 0) goto L_0x0091
            r1.destroy()
        L_0x0091:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.elfin.e.c.e.b(java.lang.String):java.lang.String");
    }

    private boolean b(Context context) {
        return a(context, 5);
    }

    private static boolean c() {
        String b2 = b("cat /proc/self/cgroup");
        return b2 == null || b2.length() == 0;
    }

    private boolean d() {
        this.f1911a = null;
        String a2 = a("gsm.version.baseband");
        int i = TextUtils.isEmpty(a2) | (a2 != null && a2.contains("1.0.0.0")) ? 1 : 0;
        String a3 = a("ro.build.flavor");
        if (TextUtils.isEmpty(a3) || (a3.contains("vbox") || a3.contains("sdk_gphone"))) {
            i++;
        }
        String a4 = a("ro.product.board");
        if (TextUtils.isEmpty(a4) || (a4.contains(com.cyjh.elfin.a.b.f1842b) || a4.contains("goldfish"))) {
            i++;
        }
        String a5 = a("ro.board.platform");
        if (TextUtils.isEmpty(a5) || a5.contains(com.cyjh.elfin.a.b.f1842b)) {
            i++;
        }
        if (!TextUtils.isEmpty(a4) && !TextUtils.isEmpty(a5) && !a4.equals(a5)) {
            i++;
        }
        String b2 = b("cat /proc/self/cgroup");
        if (TextUtils.isEmpty(b2)) {
            i++;
        }
        if (this.f1911a != null) {
            StringBuffer stringBuffer = new StringBuffer("ceshi start|");
            stringBuffer.append(a2);
            stringBuffer.append("|");
            stringBuffer.append(a3);
            stringBuffer.append("|");
            stringBuffer.append(a4);
            stringBuffer.append("|");
            stringBuffer.append(a5);
            stringBuffer.append("|");
            stringBuffer.append(b2);
            stringBuffer.append("|end");
            this.f1911a = null;
        }
        return i > 2;
    }

    private boolean e() {
        this.f1911a = null;
        String a2 = a("gsm.version.baseband");
        int i = TextUtils.isEmpty(a2) | (a2 != null && a2.contains("1.0.0.0")) ? 1 : 0;
        String a3 = a("ro.build.flavor");
        if (TextUtils.isEmpty(a3) || (a3.contains("vbox") || a3.contains("sdk_gphone"))) {
            i++;
        }
        String a4 = a("ro.product.board");
        if (TextUtils.isEmpty(a4) || (a4.contains(com.cyjh.elfin.a.b.f1842b) || a4.contains("goldfish"))) {
            i++;
        }
        String a5 = a("ro.board.platform");
        if (TextUtils.isEmpty(a5) || a5.contains(com.cyjh.elfin.a.b.f1842b)) {
            i++;
        }
        if (!TextUtils.isEmpty(a4) && !TextUtils.isEmpty(a5) && !a4.equals(a5)) {
            i++;
        }
        String b2 = b("cat /proc/self/cgroup");
        if (TextUtils.isEmpty(b2)) {
            i++;
        }
        if (this.f1911a != null) {
            StringBuffer stringBuffer = new StringBuffer("ceshi start|");
            stringBuffer.append(a2);
            stringBuffer.append("|");
            stringBuffer.append(a3);
            stringBuffer.append("|");
            stringBuffer.append(a4);
            stringBuffer.append("|");
            stringBuffer.append(a5);
            stringBuffer.append("|");
            stringBuffer.append(b2);
            stringBuffer.append("|end");
            this.f1911a = null;
        }
        return i > 2;
    }

    @Deprecated
    private static String f() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("-\nBOARD-");
        stringBuffer.append(Build.BOARD);
        stringBuffer.append("\nBOOTLOADER-");
        stringBuffer.append(Build.BOOTLOADER);
        stringBuffer.append("\nBRAND-");
        stringBuffer.append(Build.BRAND);
        stringBuffer.append("\nDEVICE-");
        stringBuffer.append(Build.DEVICE);
        stringBuffer.append("\nHARDWARE-");
        stringBuffer.append(Build.HARDWARE);
        stringBuffer.append("\nMODEL-");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("\nPRODUCT-");
        stringBuffer.append(Build.PRODUCT);
        return stringBuffer.toString();
    }
}
