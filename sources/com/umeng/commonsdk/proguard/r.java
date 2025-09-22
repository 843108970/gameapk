package com.umeng.commonsdk.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import com.umeng.commonsdk.framework.b;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3808a = "info";

    /* renamed from: b  reason: collision with root package name */
    private static final String f3809b = "stat";

    /* renamed from: c  reason: collision with root package name */
    private static boolean f3810c = false;
    private static HandlerThread d = null;
    private static Context e = null;
    /* access modifiers changed from: private */
    public static int f = 0;
    /* access modifiers changed from: private */
    public static int g = 0;
    private static int h = 0;
    /* access modifiers changed from: private */
    public static int i = 1;
    /* access modifiers changed from: private */
    public static long j = 0;
    /* access modifiers changed from: private */
    public static long k = 0;
    private static final int l = 40;
    private static final int m = 50000;
    /* access modifiers changed from: private */
    public static SensorManager n;
    /* access modifiers changed from: private */
    public static ArrayList<float[]> o = new ArrayList<>();
    /* access modifiers changed from: private */
    public static SensorEventListener p = new SensorEventListener() {
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            if (r.g < 15) {
                r.c();
                return;
            }
            if (r.f < 20) {
                r.e();
                r.o.add(sensorEvent.values);
            }
            if (r.f == 20) {
                r.e();
                if (r.i == 1) {
                    long unused = r.j = System.currentTimeMillis();
                }
                if (r.i == 2) {
                    long unused2 = r.k = System.currentTimeMillis();
                }
                r.h();
                r.l();
            }
        }
    };

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f3813a;

        /* renamed from: b  reason: collision with root package name */
        public int f3814b;

        /* renamed from: c  reason: collision with root package name */
        public long f3815c;
    }

    public static List<Sensor> a(Context context) {
        if (context == null) {
            return null;
        }
        return ((SensorManager) context.getSystemService(v.W)).getSensorList(-1);
    }

    public static synchronized boolean a() {
        boolean z;
        synchronized (r.class) {
            z = f3810c;
        }
        return z;
    }

    public static void b(Context context) {
        if (context != null && !a()) {
            f3810c = true;
            e = context.getApplicationContext();
            String a2 = b.a(context);
            String packageName = context.getPackageName();
            if (a2 != null && a2.equals(packageName)) {
                SensorManager sensorManager = (SensorManager) context.getSystemService(v.W);
                n = sensorManager;
                final Sensor defaultSensor = sensorManager.getDefaultSensor(4);
                final Sensor defaultSensor2 = n.getDefaultSensor(1);
                if (defaultSensor != null) {
                    h = 4;
                    n.registerListener(p, defaultSensor, m);
                } else if (defaultSensor2 != null) {
                    h = 1;
                    n.registerListener(p, defaultSensor2, m);
                }
                int nextInt = (new Random().nextInt(3) * 1000) + com.cyjh.elfin.d.b.f1863c;
                HandlerThread handlerThread = new HandlerThread("sensor_thread");
                d = handlerThread;
                handlerThread.start();
                new Handler(d.getLooper()).postDelayed(new Runnable() {
                    public final void run() {
                        int unused = r.f = 0;
                        if (defaultSensor != null) {
                            r.n.registerListener(r.p, defaultSensor, r.m);
                        } else if (defaultSensor2 != null) {
                            r.n.registerListener(r.p, defaultSensor2, r.m);
                        }
                    }
                }, (long) nextInt);
            }
        }
    }

    static /* synthetic */ int c() {
        int i2 = g;
        g = i2 + 1;
        return i2;
    }

    public static JSONArray c(Context context) {
        String string;
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f3808a, 0);
        if (!(sharedPreferences == null || (string = sharedPreferences.getString(f3809b, (String) null)) == null)) {
            try {
                return new JSONArray(string);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static void d(Context context) {
        if (context != null) {
            context.getApplicationContext().getSharedPreferences(f3808a, 0).edit().remove(f3809b).commit();
        }
    }

    static /* synthetic */ int e() {
        int i2 = f;
        f = i2 + 1;
        return i2;
    }

    public static List<a> e(Context context) {
        if (context == null || !DeviceConfig.checkPermission(context, "android.permission.CAMERA")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
                String[] cameraIdList = cameraManager.getCameraIdList();
                for (String cameraCharacteristics : cameraIdList) {
                    Size size = (Size) cameraManager.getCameraCharacteristics(cameraCharacteristics).get(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE);
                    if (size != null) {
                        a aVar = new a();
                        aVar.f3813a = size.getWidth();
                        aVar.f3814b = size.getHeight();
                        aVar.f3815c = System.currentTimeMillis();
                        arrayList.add(aVar);
                    }
                }
            }
        } catch (Exception unused) {
            e.c("camera access exception");
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0073 A[Catch:{ Exception -> 0x009a }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b A[Catch:{ Exception -> 0x009a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void f(android.content.Context r13) {
        /*
            if (r13 != 0) goto L_0x0003
            return
        L_0x0003:
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x009a }
            r0.<init>()     // Catch:{ Exception -> 0x009a }
            r1 = 0
            r2 = 0
        L_0x000a:
            r3 = 2
            if (r2 >= r3) goto L_0x0099
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x009a }
            r4.<init>()     // Catch:{ Exception -> 0x009a }
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ Exception -> 0x009a }
            r5.<init>()     // Catch:{ Exception -> 0x009a }
            r6 = 20
            r7 = 1
            if (r2 != r7) goto L_0x001f
            r8 = 40
            goto L_0x0022
        L_0x001f:
            r6 = 0
            r8 = 20
        L_0x0022:
            if (r6 >= r8) goto L_0x005f
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x009a }
            r9.<init>()     // Catch:{ Exception -> 0x009a }
            java.lang.String r10 = "x"
            java.util.ArrayList<float[]> r11 = o     // Catch:{ Exception -> 0x009a }
            java.lang.Object r11 = r11.get(r6)     // Catch:{ Exception -> 0x009a }
            float[] r11 = (float[]) r11     // Catch:{ Exception -> 0x009a }
            r11 = r11[r1]     // Catch:{ Exception -> 0x009a }
            double r11 = (double) r11     // Catch:{ Exception -> 0x009a }
            r9.put(r10, r11)     // Catch:{ Exception -> 0x009a }
            java.lang.String r10 = "y"
            java.util.ArrayList<float[]> r11 = o     // Catch:{ Exception -> 0x009a }
            java.lang.Object r11 = r11.get(r6)     // Catch:{ Exception -> 0x009a }
            float[] r11 = (float[]) r11     // Catch:{ Exception -> 0x009a }
            r11 = r11[r7]     // Catch:{ Exception -> 0x009a }
            double r11 = (double) r11     // Catch:{ Exception -> 0x009a }
            r9.put(r10, r11)     // Catch:{ Exception -> 0x009a }
            java.lang.String r10 = "z"
            java.util.ArrayList<float[]> r11 = o     // Catch:{ Exception -> 0x009a }
            java.lang.Object r11 = r11.get(r6)     // Catch:{ Exception -> 0x009a }
            float[] r11 = (float[]) r11     // Catch:{ Exception -> 0x009a }
            r11 = r11[r3]     // Catch:{ Exception -> 0x009a }
            double r11 = (double) r11     // Catch:{ Exception -> 0x009a }
            r9.put(r10, r11)     // Catch:{ Exception -> 0x009a }
            r5.put(r9)     // Catch:{ Exception -> 0x009a }
            int r6 = r6 + 1
            goto L_0x0022
        L_0x005f:
            int r3 = h     // Catch:{ Exception -> 0x009a }
            r6 = 4
            if (r3 != r6) goto L_0x006a
            java.lang.String r3 = "g"
        L_0x0066:
            r4.put(r3, r5)     // Catch:{ Exception -> 0x009a }
            goto L_0x0071
        L_0x006a:
            int r3 = h     // Catch:{ Exception -> 0x009a }
            if (r3 != r7) goto L_0x0071
            java.lang.String r3 = "a"
            goto L_0x0066
        L_0x0071:
            if (r2 != 0) goto L_0x007b
            java.lang.String r3 = "ts"
            long r5 = j     // Catch:{ Exception -> 0x009a }
        L_0x0077:
            r4.put(r3, r5)     // Catch:{ Exception -> 0x009a }
            goto L_0x0080
        L_0x007b:
            java.lang.String r3 = "ts"
            long r5 = k     // Catch:{ Exception -> 0x009a }
            goto L_0x0077
        L_0x0080:
            r0.put(r4)     // Catch:{ Exception -> 0x009a }
            r3 = 32776(0x8008, float:4.5929E-41)
            com.umeng.commonsdk.proguard.b r4 = com.umeng.commonsdk.proguard.b.a(r13)     // Catch:{ Exception -> 0x009a }
            com.umeng.commonsdk.proguard.c r4 = r4.a()     // Catch:{ Exception -> 0x009a }
            java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x009a }
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(r13, r3, r4, r5)     // Catch:{ Exception -> 0x009a }
            int r2 = r2 + 1
            goto L_0x000a
        L_0x0099:
            return
        L_0x009a:
            r0 = move-exception
            com.umeng.commonsdk.proguard.e.a(r13, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.proguard.r.f(android.content.Context):void");
    }

    static /* synthetic */ int h() {
        int i2 = i;
        i = i2 + 1;
        return i2;
    }

    /* access modifiers changed from: private */
    public static void l() {
        if (n != null) {
            n.unregisterListener(p);
        }
        if (o.size() == 40) {
            f(e);
            if (o != null) {
                o.clear();
            }
            if (d != null) {
                d.quit();
                d = null;
            }
            e = null;
            f3810c = false;
        }
    }
}
