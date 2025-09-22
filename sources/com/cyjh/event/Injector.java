package com.cyjh.event;

import android.app.Instrumentation;
import android.bluetooth.BluetoothAdapter;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.media.MediaScannerConnection;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.cyjh.event.accessibility.Cservice;
import com.cyjh.mobileanjian.ipc.interfaces.OnScriptListener;
import com.cyjh.mobileanjian.ipc.ui.b;
import com.cyjh.mobileanjian.ipc.ui.c;
import com.cyjh.mobileanjian.ipc.ui.i;
import com.cyjh.mobileanjian.ipc.utils.d;
import com.cyjh.mobileanjian.ipc.view.ExToast;
import com.cyjh.mq.d.g;
import com.cyjh.mq.sdk.MqRunner;
import com.cyjh.mq.sdk.MqRunnerLite;
import com.github.kevinsawicki.http.HttpRequest;
import com.google.a.i.a.f;
import com.google.a.w;
import com.google.protobuf.ByteString;
import com.googlecode.tesseract.android.TessBaseAPI;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.json.JSONArray;
import org.json.JSONObject;

public final class Injector {
    private static MotionEvent.PointerCoords[] A = null;

    /* renamed from: a  reason: collision with root package name */
    private static final String f2349a = "Injector";

    /* renamed from: b  reason: collision with root package name */
    private static Instrumentation f2350b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Context f2351c = null;
    private static ExToast d = null;
    private static com.cyjh.mobileanjian.ipc.a e = null;
    private static i f = null;
    private static TessBaseAPI g = null;
    private static boolean h = false;
    private static boolean i = false;
    private static Handler j = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Injector.a((b) message.obj);
                    return;
                case 2:
                    new com.cyjh.mobileanjian.ipc.ui.b(Injector.f2351c, ((b) message.obj).d, ((b) message.obj).f2365a, new b.a() {
                        public final void a(int i) {
                            Injector.setSyncReturnValue(i, "");
                        }
                    }).a();
                    return;
                case 3:
                    new c(Injector.f2351c, ((b) message.obj).d, new c.a() {
                        public final void a(String str) {
                            Injector.setSyncReturnValue(0, str);
                        }
                    }).a();
                    return;
                case 4:
                    Injector.d((b) message.obj);
                    return;
                case 5:
                    Injector.b();
                    return;
                case 6:
                    Injector.a();
                    return;
                case 7:
                    Injector.a((byte[]) message.obj);
                    return;
                case 8:
                    b bVar = (b) message.obj;
                    if (MqRunnerLite.getInstance().d) {
                        if (MqRunnerLite.getInstance().f2790c != null) {
                            MqRunnerLite.getInstance().f2790c.onCallback(bVar.f2365a, bVar.d);
                        }
                        if (MqRunnerLite.getInstance().f2789b != null) {
                            MqRunnerLite.getInstance().f2789b.callback(bVar.f2365a, bVar.d);
                            return;
                        }
                        return;
                    }
                    MqRunner.getInstance();
                    return;
                case 9:
                    Injector.e((b) message.obj);
                    return;
                default:
                    return;
            }
        }
    };
    private static final float k = 0.0f;
    private static final float l = -1.5707964f;
    private static final float m = -3.1415927f;
    private static final float n = 1.5707964f;
    private static boolean o = false;
    private static int p = 0;
    private static String q = null;
    private static final int r = 1;
    private static final int s = 2;
    private static final String t = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.64 Safari/537.11";
    private static final int u = 5;
    private static final int v = 1;
    private static final int w = 2;
    private static final int x = 3;
    private static a[] y;
    private static MotionEvent.PointerProperties[] z;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2352a;

        /* renamed from: b  reason: collision with root package name */
        public int f2353b;

        /* renamed from: c  reason: collision with root package name */
        public float f2354c;
        public float d;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    interface b {

        /* renamed from: a  reason: collision with root package name */
        public static final int f2355a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f2356b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f2357c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        public static final int g = 7;
        public static final int h = 8;
        public static final int i = 9;
    }

    private Injector() {
    }

    public static void AddContact(String str, String str2, String str3) {
        d.a(f2351c, str, str2, str3);
    }

    public static void ClearAllPhotos() {
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/anjian/";
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
        String str2 = "_data like \"" + str + "%\"";
        f2351c.getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, str2, (String[]) null);
        f2351c.getContentResolver().delete(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, str2, (String[]) null);
    }

    public static void ClearCaches(String str) {
    }

    public static void ClearContacts() {
        d.a(f2351c);
    }

    public static void DeleteContact(String str) {
        d.a(f2351c, str);
    }

    public static void FloatEventThreadExit() {
        c.e();
        Log.e(f2349a, "FloatEventThreadExit: ");
    }

    public static void FreeupMemory() {
        e.e();
    }

    public static String GetAndroidVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String GetAppPath(String str) {
        try {
            return f2351c.getPackageManager().getApplicationInfo(str, 0).sourceDir;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String GetDeviceID() {
        Context applicationContext = com.cyjh.mq.a.a.g.getApplicationContext();
        String deviceId = ((TelephonyManager) applicationContext.getSystemService("phone")).getDeviceId();
        if (deviceId == null || deviceId.equals("")) {
            deviceId = g.a(applicationContext);
        }
        return TextUtils.isEmpty(deviceId) ? g.a(com.cyjh.mq.a.a.g.getApplicationContext()) : deviceId;
    }

    public static String GetDeviceName() {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null && !TextUtils.isEmpty(defaultAdapter.getName())) {
                return defaultAdapter.getName();
            }
        } catch (Exception unused) {
        }
        return Build.MODEL;
    }

    public static int GetDisplayDpi() {
        return f2351c.getResources().getDisplayMetrics().densityDpi;
    }

    public static byte[] GetFloatEvent() {
        Log.e(f2349a, "GetFloatEvent: ");
        ByteString d2 = c.d();
        if (d2 == null) {
            return null;
        }
        return d2.toByteArray();
    }

    public static String GetForegroundPackage() {
        return MqRunnerLite.getInstance().e != null ? MqRunnerLite.getInstance().e.getForegroundPackage() : "";
    }

    public static String GetFullUiElement() {
        return "";
    }

    public static String GetNetType() {
        return e.i();
    }

    public static String GetRunningApp() {
        return MqRunnerLite.getInstance().e.getRunningPackages();
    }

    public static int GetScreenRotation() {
        return ((WindowManager) com.cyjh.mq.a.a.g.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    public static String GetSdcardDir() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static float GetTapRotation() {
        switch (GetScreenRotation()) {
            case 0:
                Log.e(f2349a, "Tap Tap ROTATION_0");
                return 0.0f;
            case 1:
                Log.e(f2349a, "Tap Tap ROTATION_90");
                return l;
            case 2:
                Log.e(f2349a, "Tap Tap ROTATION_180");
                return m;
            case 3:
                Log.e(f2349a, "Tap Tap ROTATION_270");
                return n;
            default:
                return 0.0f;
        }
    }

    public static String GetUiElement() {
        return "";
    }

    public static byte[] GetUiEvent() {
        return c.b();
    }

    public static boolean GetVPNStatus() {
        try {
            Iterator<T> it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (networkInterface.isUp()) {
                    String name = networkInterface.getName();
                    Log.e("GetVPNStatus", "GetVPNStatus name:" + networkInterface.getName());
                    if (name.contains("tun") || name.contains("ppp") || name.contains("pptp")) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String GetVersion() {
        return "10_1661";
    }

    public static String GetWebViewElement(String str) {
        return "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002c A[SYNTHETIC, Splitter:B:17:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0084 A[SYNTHETIC, Splitter:B:32:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a3 A[SYNTHETIC, Splitter:B:41:0x00a3] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String ImageQRDeCode(java.lang.String r12) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.google.a.e r1 = com.google.a.e.CHARACTER_SET
            java.lang.String r2 = "utf-8"
            r0.put(r1, r2)
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0025, all -> 0x0022 }
            r2.<init>(r12)     // Catch:{ Exception -> 0x0025, all -> 0x0022 }
            android.graphics.Bitmap r12 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch:{ Exception -> 0x0020 }
            r2.close()     // Catch:{ IOException -> 0x001a }
            goto L_0x001e
        L_0x001a:
            r2 = move-exception
            r2.printStackTrace()
        L_0x001e:
            r2 = r12
            goto L_0x0035
        L_0x0020:
            r12 = move-exception
            goto L_0x0027
        L_0x0022:
            r12 = move-exception
            goto L_0x00a1
        L_0x0025:
            r12 = move-exception
            r2 = r1
        L_0x0027:
            r12.printStackTrace()     // Catch:{ all -> 0x009f }
            if (r2 == 0) goto L_0x0034
            r2.close()     // Catch:{ IOException -> 0x0030 }
            goto L_0x0034
        L_0x0030:
            r12 = move-exception
            r12.printStackTrace()
        L_0x0034:
            r2 = r1
        L_0x0035:
            int r12 = r2.getWidth()     // Catch:{ Exception -> 0x007d }
            int r10 = r2.getHeight()     // Catch:{ Exception -> 0x007d }
            int r3 = r12 * r10
            int[] r11 = new int[r3]     // Catch:{ Exception -> 0x007d }
            r4 = 0
            r6 = 0
            r7 = 0
            r3 = r11
            r5 = r12
            r8 = r12
            r9 = r10
            r2.getPixels(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x007d }
            com.google.a.o r2 = new com.google.a.o     // Catch:{ Exception -> 0x007d }
            r2.<init>(r12, r10, r11)     // Catch:{ Exception -> 0x007d }
            com.google.a.k r12 = new com.google.a.k     // Catch:{ Exception -> 0x007b }
            r12.<init>()     // Catch:{ Exception -> 0x007b }
            com.google.a.c r3 = new com.google.a.c     // Catch:{ Exception -> 0x007b }
            com.google.a.c.j r4 = new com.google.a.c.j     // Catch:{ Exception -> 0x007b }
            r4.<init>(r2)     // Catch:{ Exception -> 0x007b }
            r3.<init>(r4)     // Catch:{ Exception -> 0x007b }
            com.google.a.r r12 = r12.a(r3, r0)     // Catch:{ Exception -> 0x007b }
            java.lang.String r3 = "RootIpcFramework"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007b }
            java.lang.String r5 = "syncDecodeQRCode: result is:"
            r4.<init>(r5)     // Catch:{ Exception -> 0x007b }
            java.lang.String r5 = r12.f3353a     // Catch:{ Exception -> 0x007b }
            r4.append(r5)     // Catch:{ Exception -> 0x007b }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x007b }
            android.util.Log.i(r3, r4)     // Catch:{ Exception -> 0x007b }
            java.lang.String r12 = r12.f3353a     // Catch:{ Exception -> 0x007b }
            return r12
        L_0x007b:
            r12 = move-exception
            goto L_0x007f
        L_0x007d:
            r12 = move-exception
            r2 = r1
        L_0x007f:
            r12.printStackTrace()
            if (r2 == 0) goto L_0x009e
            com.google.a.k r12 = new com.google.a.k     // Catch:{ Throwable -> 0x009a }
            r12.<init>()     // Catch:{ Throwable -> 0x009a }
            com.google.a.c r3 = new com.google.a.c     // Catch:{ Throwable -> 0x009a }
            com.google.a.c.h r4 = new com.google.a.c.h     // Catch:{ Throwable -> 0x009a }
            r4.<init>(r2)     // Catch:{ Throwable -> 0x009a }
            r3.<init>(r4)     // Catch:{ Throwable -> 0x009a }
            com.google.a.r r12 = r12.a(r3, r0)     // Catch:{ Throwable -> 0x009a }
            java.lang.String r12 = r12.f3353a     // Catch:{ Throwable -> 0x009a }
            return r12
        L_0x009a:
            r12 = move-exception
            r12.printStackTrace()
        L_0x009e:
            return r1
        L_0x009f:
            r12 = move-exception
            r1 = r2
        L_0x00a1:
            if (r1 == 0) goto L_0x00ab
            r1.close()     // Catch:{ IOException -> 0x00a7 }
            goto L_0x00ab
        L_0x00a7:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00ab:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.event.Injector.ImageQRDeCode(java.lang.String):java.lang.String");
    }

    public static void ImageQREnCode(String str, String str2, int i2) {
        com.google.a.c.b bVar;
        com.google.a.i.b bVar2 = new com.google.a.i.b();
        HashMap hashMap = new HashMap();
        hashMap.put(com.google.a.g.CHARACTER_SET, "utf-8");
        hashMap.put(com.google.a.g.ERROR_CORRECTION, f.M);
        hashMap.put(com.google.a.g.MARGIN, 2);
        try {
            bVar = bVar2.a(str2, com.google.a.a.QR_CODE, 400, 400, hashMap);
        } catch (w e2) {
            e2.printStackTrace();
            bVar = null;
        }
        int[] iArr = new int[160000];
        for (int i3 = 0; i3 < 400; i3++) {
            for (int i4 = 0; i4 < 400; i4++) {
                if (bVar.a(i3, i4)) {
                    iArr[(i3 * 400) + i4] = -16777216;
                } else {
                    iArr[(i3 * 400) + i4] = -1;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr, 400, 400, Bitmap.Config.RGB_565);
        if (createBitmap != null) {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                createBitmap.compress(str.endsWith(".png") ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException e3) {
                Log.e("RootIpcFramework", "ImageQREnCode IOException" + e3.toString());
            }
        }
    }

    public static int InjectWebViewElement(String str, String str2) {
        return 0;
    }

    public static void InsertImageToGallery(String str, int i2) {
        File file = new File(str);
        if (file.exists()) {
            if (i2 == 1) {
                String str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/anjian/";
                File file2 = new File(str2);
                if (!file2.exists()) {
                    file2.mkdir();
                }
                File file3 = new File(str2 + file.getName());
                if (file3.exists()) {
                    file3.delete();
                }
                try {
                    FileUtils.copyFile(file, file3);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                file = file3;
            }
            if (Build.VERSION.SDK_INT < 29) {
                try {
                    MediaStore.Images.Media.insertImage(f2351c.getContentResolver(), file.getAbsolutePath(), file.getName(), (String) null);
                } catch (FileNotFoundException e3) {
                    e3.printStackTrace();
                }
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put("_display_name", file.getName());
                contentValues.put("mime_type", "image/jpeg");
                contentValues.put("relative_path", Environment.DIRECTORY_DCIM);
                ContentResolver contentResolver = f2351c.getContentResolver();
                Uri insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                if (insert == null) {
                    Log.e("InsertImageToGallery", "图片保存失败:" + str + "|" + file.getName());
                    return;
                }
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    OutputStream openOutputStream = contentResolver.openOutputStream(insert);
                    android.os.FileUtils.copy(bufferedInputStream, openOutputStream);
                    bufferedInputStream.close();
                    openOutputStream.close();
                    file.delete();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            if (Build.VERSION.SDK_INT >= 19) {
                MediaScannerConnection.scanFile(f2351c, new String[]{file.getAbsolutePath()}, (String[]) null, (MediaScannerConnection.OnScanCompletedListener) null);
                return;
            }
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.fromFile(file));
            f2351c.sendBroadcast(intent);
        }
    }

    public static void InsertVideoToGallery(String str) {
        File file = new File(str);
        if (file.exists()) {
            String str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/anjian/";
            File file2 = new File(str2);
            if (!file2.exists()) {
                file2.mkdir();
            }
            File file3 = new File(str2 + file.getName());
            if (file3.exists()) {
                file3.delete();
            }
            try {
                FileUtils.copyFile(file, file3);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            long currentTimeMillis = System.currentTimeMillis();
            ContentResolver contentResolver = f2351c.getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", file3.getName());
            contentValues.put("_display_name", file3.getName());
            contentValues.put("mime_type", "video/3gp");
            contentValues.put("datetaken", Long.valueOf(currentTimeMillis));
            contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
            contentValues.put("date_added", Long.valueOf(currentTimeMillis));
            contentValues.put("_data", file3.getAbsolutePath());
            contentValues.put("_size", Long.valueOf(file3.length()));
            f2351c.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues)));
        }
    }

    public static boolean Is64Bit() {
        Class<?> cls;
        Method declaredMethod;
        Object invoke;
        Method declaredMethod2;
        try {
            if (Build.VERSION.SDK_INT < 21 || (cls = Class.forName("dalvik.system.VMRuntime")) == null || (declaredMethod = cls.getDeclaredMethod("getRuntime", new Class[0])) == null || (invoke = declaredMethod.invoke((Object) null, new Object[0])) == null || (declaredMethod2 = cls.getDeclaredMethod("is64Bit", new Class[0])) == null) {
                return false;
            }
            Object invoke2 = declaredMethod2.invoke(invoke, new Object[0]);
            if (invoke2 instanceof Boolean) {
                return ((Boolean) invoke2).booleanValue();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean IsRoot() {
        String str = System.getenv("PATH");
        new ArrayList();
        for (String file : str.split(":")) {
            File file2 = new File(file, "su");
            if (file2.exists() && file2.canExecute()) {
                return true;
            }
        }
        return false;
    }

    public static void KeepScreen(boolean z2) {
        e.b(z2 ? 10 : 0);
    }

    public static void KeyDown(int i2) {
        try {
            e().sendKeySync(new KeyEvent(0, i2));
        } catch (Throwable th) {
            th.toString();
        }
    }

    public static void KeyPress(int i2) {
        if (i) {
            KeyPressAB(i2);
        } else if (MqRunnerLite.getInstance().e != null) {
            MqRunnerLite.getInstance().e.keyPress(i2);
        }
    }

    public static void KeyPressAB(int i2) {
        int i3;
        if (Cservice.a()) {
            Cservice cservice = Cservice.f2360a;
            Context context = f2351c;
            if (Build.VERSION.SDK_INT >= 16) {
                if (i2 != 26) {
                    switch (i2) {
                        case 3:
                            i3 = 2;
                            break;
                        case 4:
                            i3 = 1;
                            break;
                        default:
                            if (!Cservice.a(i2).isEmpty()) {
                                cservice.a(Cservice.a(i2), context);
                                return;
                            }
                            return;
                    }
                } else {
                    i3 = 6;
                }
                cservice.performGlobalAction(i3);
            }
        }
    }

    public static void KeyUp(int i2) {
        try {
            e().sendKeySync(new KeyEvent(1, i2));
        } catch (Throwable th) {
            th.toString();
        }
    }

    public static void KillApp(String str) {
        if (MqRunnerLite.getInstance().e != null) {
            MqRunnerLite.getInstance().e.killApp(str);
        }
    }

    public static void LockScreen() {
        e.g();
    }

    public static void MoveZoomIn(float f2, float f3, float f4, float f5, int i2) {
        Log.e("RootIpcFramework", "MoveZoomIn");
        float f6 = (f2 + f4) / 2.0f;
        float f7 = (f3 + f5) / 2.0f;
        TouchDown(10123, f6, f7);
        TouchDown(10124, f6, f7);
        int i3 = i2 / 11;
        if (i3 < 10) {
            i3 = 10;
        }
        float f8 = (f2 - f6) / 11.0f;
        float f9 = (f3 - f7) / 11.0f;
        float f10 = (f4 - f6) / 11.0f;
        float f11 = (f5 - f7) / 11.0f;
        try {
            Thread.sleep(20);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        float f12 = f6;
        float f13 = f7;
        float f14 = f13;
        float f15 = f12;
        for (int i4 = 0; i4 < 11; i4++) {
            f15 += f8;
            f13 += f9;
            f12 += f10;
            f14 += f11;
            TouchMoveEvent(10123, f15, f13, 0);
            TouchMoveEvent(10124, f12, f14, 0);
            try {
                Thread.sleep((long) i3);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        TouchUp(10123);
        TouchUp(10124);
    }

    public static void MoveZoomOut(float f2, float f3, float f4, float f5, int i2) {
        Log.e("RootIpcFramework", "MoveZoomOut");
        float f6 = (f2 + f4) / 2.0f;
        float f7 = (f3 + f5) / 2.0f;
        TouchDown(10125, f2, f3);
        TouchDown(10126, f4, f5);
        int i3 = i2 / 11;
        if (i3 < 10) {
            i3 = 10;
        }
        float f8 = (f6 - f2) / 11.0f;
        float f9 = (f7 - f3) / 11.0f;
        float f10 = (f6 - f4) / 11.0f;
        float f11 = (f7 - f5) / 11.0f;
        try {
            Thread.sleep(20);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        float f12 = f5;
        float f13 = f4;
        float f14 = f3;
        float f15 = f2;
        for (int i4 = 0; i4 < 11; i4++) {
            f15 += f8;
            f14 += f9;
            f13 += f10;
            f12 += f11;
            TouchMoveEvent(10125, f15, f14, 0);
            TouchMoveEvent(10126, f13, f12, 0);
            try {
                Thread.sleep((long) i3);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        TouchUp(10125);
        TouchUp(10126);
    }

    public static void NotifyApp(String str) {
        if (MqRunnerLite.getInstance().f != null) {
            MqRunnerLite.getInstance().f.callback(str);
        }
    }

    public static String OcrText(byte[] bArr, int i2, int i3, int i4) {
        Log.e("TAG", "GetOrcText: width=" + i3 + " hight=" + i4 + " size=" + i2);
        if (!h) {
            h = initTessBass();
        }
        if (!h) {
            return "";
        }
        int i5 = i2 / 4;
        int[] iArr = new int[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            for (int i7 = 0; i7 < 4; i7++) {
                iArr[i6] = iArr[i6] + ((bArr[(i6 * 4) + i7] & 255) << ((3 - i7) * 8));
            }
        }
        g.a(Bitmap.createBitmap(iArr, i3, i4, Bitmap.Config.ARGB_8888));
        return g.a();
    }

    public static void OnElfCallback(int i2, String str) {
        b bVar = new b();
        bVar.f2365a = i2;
        bVar.d = str;
        a(8, bVar);
    }

    public static void OnPause() {
        j.sendEmptyMessage(6);
    }

    public static void OnResponse(int i2, String str) {
        b bVar = new b();
        bVar.f2365a = i2;
        bVar.d = str;
        a(8, bVar);
    }

    public static void OnResume() {
        j.sendEmptyMessage(5);
    }

    public static void PlaySound(String str) {
        com.cyjh.mobileanjian.ipc.a.c(str);
    }

    public static void RandomTap(float f2, float f3, int i2, String str) {
        float f4 = f2;
        float f5 = f3;
        int i3 = i2;
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            StringBuilder sb = new StringBuilder("RandomTap：x=");
            sb.append(f4);
            sb.append(",y = ");
            sb.append(f5);
            sb.append(",random = ");
            sb.append(i3);
            double d2 = (double) i3;
            float random = f4 + ((float) ((int) ((Math.random() * d2) - ((double) (i3 / 2)))));
            float random2 = f5 + ((float) ((int) ((Math.random() * d2) - ((double) (i3 / 2)))));
            StringBuilder sb2 = new StringBuilder("RandomTap：realX=");
            sb2.append(random);
            sb2.append(",realY = ");
            sb2.append(random2);
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            pointerCoords.x = random;
            pointerCoords.y = random2;
            pointerCoords.orientation = GetTapRotation();
            MotionEvent.PointerCoords pointerCoords2 = pointerCoords;
            float f6 = random2;
            float f7 = random;
            e().sendPointerSync(MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 1, new int[]{0}, new MotionEvent.PointerCoords[]{pointerCoords}, 0, 0.0f, 0.0f, 0, 0, 0, 0));
            try {
                Thread.sleep(50);
            } catch (Exception unused) {
            }
            e().sendPointerSync(MotionEvent.obtain(uptimeMillis, uptimeMillis, 1, 1, new int[]{0}, new MotionEvent.PointerCoords[]{pointerCoords2}, 0, 0.0f, 0.0f, 0, 0, 0, 0));
            new com.cyjh.mobileanjian.ipc.view.b(f2351c).a((int) f7, (int) f6, str);
        } catch (Throwable th) {
            th.toString();
        }
    }

    public static void RandomsTap(float f2, float f3, int i2, String str) {
        float f4;
        float f5 = f2;
        float f6 = f3;
        int i3 = i2;
        StringBuilder sb = new StringBuilder("RandomsTap：x=");
        sb.append(f5);
        sb.append(",y = ");
        sb.append(f6);
        sb.append(",random = ");
        sb.append(i3);
        double d2 = (double) i3;
        double d3 = (double) (i3 / 2);
        float random = f5 + ((float) ((int) ((Math.random() * d2) - d3)));
        float random2 = f6 + ((float) ((int) ((Math.random() * d2) - d3)));
        StringBuilder sb2 = new StringBuilder("RandomTap：x2=");
        sb2.append(random);
        sb2.append(",y2 = ");
        sb2.append(random2);
        long uptimeMillis = SystemClock.uptimeMillis();
        e().sendPointerSync(MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, f5, f6, 0));
        try {
            long uptimeMillis2 = SystemClock.uptimeMillis();
            f4 = random;
            try {
                e().sendPointerSync(MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 2, random, random2, 0));
                Thread.sleep(20);
            } catch (InterruptedException e2) {
                e = e2;
            }
        } catch (InterruptedException e3) {
            e = e3;
            f4 = random;
            e.printStackTrace();
            long uptimeMillis3 = SystemClock.uptimeMillis();
            e().sendPointerSync(MotionEvent.obtain(uptimeMillis3, uptimeMillis3, 1, f4, random2, 0));
            new com.cyjh.mobileanjian.ipc.view.b(f2351c).a((int) f4, (int) random2, str);
        }
        long uptimeMillis32 = SystemClock.uptimeMillis();
        e().sendPointerSync(MotionEvent.obtain(uptimeMillis32, uptimeMillis32, 1, f4, random2, 0));
        new com.cyjh.mobileanjian.ipc.view.b(f2351c).a((int) f4, (int) random2, str);
    }

    public static void RunApp(String str, String str2) {
        if (MqRunnerLite.getInstance().e != null) {
            MqRunnerLite.getInstance().e.launchApp(str);
        }
    }

    public static void SaveSnapShot(int[] iArr, int i2, int i3, int i4, String str, int i5) {
        Bitmap createBitmap = Bitmap.createBitmap(iArr, i3, i4, Bitmap.Config.ARGB_8888);
        if (createBitmap != null) {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                createBitmap.compress(Bitmap.CompressFormat.JPEG, i5, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException e2) {
                Log.e("RootIpcFramework", "SaveSnapShot IOException" + e2.toString());
            }
        }
    }

    public static boolean SendSimpleEmail(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str6)) {
            return false;
        }
        SimpleEmail simpleEmail = new SimpleEmail();
        simpleEmail.setHostName(str);
        simpleEmail.setSmtpPort(465);
        simpleEmail.setAuthentication(str2, str3);
        simpleEmail.setSSLOnConnect(true);
        try {
            simpleEmail.setFrom(str2);
            simpleEmail.setSubject(str4);
            simpleEmail.setMsg(str5);
            for (String trim : str6.split(";")) {
                simpleEmail.addTo(trim.trim());
            }
            simpleEmail.send();
            return true;
        } catch (EmailException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static byte[] SendUiRequest(byte[] bArr) {
        j.obtainMessage(7, bArr).sendToTarget();
        return c.a();
    }

    public static int SetAirplaneMode(boolean z2) {
        return -1;
    }

    public static void SetAutoLockTime(int i2) {
        e.c(i2);
    }

    public static void SetBTEnable(boolean z2) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (z2) {
            defaultAdapter.enable();
        } else {
            defaultAdapter.disable();
        }
    }

    public static void SetBacklightLevel(int i2) {
        if (i2 > 100) {
            i2 = 100;
        }
        e.d(i2);
    }

    public static void SetCaptureScreenMode(int i2) {
        if (i2 == 1) {
            com.cyjh.mq.d.c.a(f2351c);
        }
    }

    public static void SetCellularDataEnable(boolean z2) {
        ConnectivityManager connectivityManager = (ConnectivityManager) f2351c.getSystemService("connectivity");
        try {
            connectivityManager.getClass().getMethod("setMobileDataEnabled", new Class[]{Boolean.TYPE}).invoke(connectivityManager, new Object[]{Boolean.valueOf(z2)});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void SetControlBarPos(float f2, int i2, int i3) {
        b bVar = new b();
        bVar.e = f2;
        bVar.f2365a = i2;
        bVar.f2366b = i3;
        a(4, bVar);
    }

    public static void SetControlBarVisiable(boolean z2) {
        b bVar = new b();
        bVar.f2365a = z2 ? 1 : 0;
        a(9, bVar);
    }

    public static void SetIsAccessibility(boolean z2) {
        i = z2;
    }

    public static void SetRotationLockEnable(boolean z2) {
        Settings.System.putInt(f2351c.getContentResolver(), "accelerometer_rotation", z2 ^ true ? 1 : 0);
    }

    public static void SetVPNEnable(boolean z2) {
        e.k();
    }

    public static void SetVolumeLevel(int i2) {
        if (i2 > 100) {
            i2 = 100;
        }
        e.e(i2);
    }

    public static void SetWifiEnable(boolean z2) {
        ((WifiManager) f2351c.getSystemService("wifi")).setWifiEnabled(z2);
    }

    public static String ShowInputDialog(String str, int i2, int i3) {
        o = false;
        b bVar = new b();
        bVar.f2365a = i2;
        bVar.f2366b = i3;
        bVar.d = str;
        a(3, bVar);
        while (!o) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        new StringBuilder("InputDialog typed text: ").append(q);
        return q;
    }

    public static void ShowMessage(String str, int i2, int i3, int i4) {
        b bVar = new b();
        bVar.f2365a = i3;
        bVar.f2366b = i4;
        bVar.f2367c = i2;
        bVar.d = str;
        a(1, bVar);
    }

    public static int ShowMsgBox(String str, int i2, int i3, int i4) {
        o = false;
        b bVar = new b();
        bVar.f2365a = i2;
        bVar.f2366b = i3;
        bVar.f2367c = i4;
        bVar.d = str;
        a(2, bVar);
        while (!o) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        return p;
    }

    public static void SpecialFunction(int i2, String str) {
        StringBuilder sb = new StringBuilder("SpecialFunction   ");
        sb.append(i2);
        sb.append(", ");
        sb.append(str);
        if (MqRunnerLite.getInstance().e != null) {
            MqRunnerLite.getInstance().e.doSpecialFuction(i2, str);
        }
    }

    public static void StopPlay() {
        com.cyjh.mobileanjian.ipc.a.f();
    }

    public static void StopScript() {
    }

    public static void Swipe(float f2, float f3, float f4, float f5, int i2) {
        if (i) {
            SwipeAB(f2, f3, f4, f5, i2);
            return;
        }
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            e().sendPointerSync(MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, f2, f3, 0));
            int i3 = i2 / 11;
            for (int i4 = 1; i4 <= 11; i4++) {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                float f6 = ((float) i4) / 11.0f;
                e().sendPointerSync(MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 2, ((f4 - f2) * f6) + f2, ((f5 - f3) * f6) + f3, 0));
                if (i3 != 0) {
                    Thread.sleep((long) i3);
                }
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.toString();
            return;
        }
        long uptimeMillis3 = SystemClock.uptimeMillis();
        e().sendPointerSync(MotionEvent.obtain(uptimeMillis3, uptimeMillis3, 1, f4, f5, 0));
    }

    @RequiresApi(api = 24)
    public static void SwipeAB(float f2, float f3, float f4, float f5, int i2) {
        if (i2 <= 10) {
            i2 = 10;
        }
        Log.e(f2349a, "SwipeABSwipeABSwipeAB1");
        if (Cservice.a()) {
            Log.e(f2349a, "SwipeABSwipeABSwipeAB2");
            Cservice cservice = Cservice.f2360a;
            Path path = new Path();
            path.moveTo((float) ((int) f2), (float) ((int) f3));
            path.lineTo((float) ((int) f4), (float) ((int) f5));
            cservice.a(path, (long) i2);
        }
    }

    public static void Tap(float f2, float f3, int i2) {
        float f4 = f2;
        float f5 = f3;
        int i3 = i2;
        StringBuilder sb = new StringBuilder("Tap1：x=");
        sb.append(f4);
        sb.append(",y = ");
        sb.append(f5);
        sb.append(",delay = ");
        sb.append(i3);
        if (i) {
            TapAB(f2, f3, i2);
            return;
        }
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            pointerCoords.x = f4;
            pointerCoords.y = f5;
            pointerCoords.orientation = GetTapRotation();
            e().sendPointerSync(MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 1, new int[]{0}, new MotionEvent.PointerCoords[]{pointerCoords}, 0, 0.0f, 0.0f, 0, 0, 0, 0));
            StringBuilder sb2 = new StringBuilder("Tap2 ：x=");
            sb2.append(f4);
            sb2.append(",y = ");
            sb2.append(f5);
            sb2.append(",delay = ");
            sb2.append(i3);
            if (i3 != 0) {
                try {
                    Thread.sleep((long) i3);
                } catch (Exception unused) {
                }
            }
            e().sendPointerSync(MotionEvent.obtain(uptimeMillis, uptimeMillis, 1, 1, new int[]{0}, new MotionEvent.PointerCoords[]{pointerCoords}, 0, 0.0f, 0.0f, 0, 0, 0, 0));
            StringBuilder sb3 = new StringBuilder("Tap3 ：x=");
            sb3.append(f4);
            sb3.append(",y = ");
            sb3.append(f5);
            sb3.append(",delay = ");
            sb3.append(i3);
        } catch (Throwable th) {
            th.toString();
        }
    }

    @RequiresApi(api = 24)
    public static void TapAB(float f2, float f3, int i2) {
        if (i2 <= 10) {
            i2 = 10;
        }
        StringBuilder sb = new StringBuilder("TapAB (");
        sb.append(f2);
        sb.append(",");
        sb.append(f3);
        sb.append(")");
        if (Cservice.a()) {
            StringBuilder sb2 = new StringBuilder("TapAB (");
            sb2.append(f2);
            sb2.append(",");
            sb2.append(f3);
            sb2.append(")");
            Cservice.f2360a.a((int) f2, (int) f3, i2);
        }
    }

    public static void TouchDown(int i2, float f2, float f3) {
        try {
            if (y == null) {
                y = new a[5];
                for (int i3 = 0; i3 < 5; i3++) {
                    a aVar = new a((byte) 0);
                    aVar.f2352a = true;
                    aVar.f2353b = 0;
                    aVar.f2354c = 0.0f;
                    aVar.d = 0.0f;
                    y[i3] = aVar;
                }
            }
            if (g() < 5) {
                a(i2, f2, f3);
                long uptimeMillis = SystemClock.uptimeMillis();
                int a2 = a(i2, 1);
                int g2 = g();
                h();
                e().sendPointerSync(MotionEvent.obtain(uptimeMillis, uptimeMillis, a2, g2, z, A, 0, 0, 0.0f, 0.0f, 0, 0, 0, 0));
            }
        } catch (Throwable th) {
            th.toString();
        }
    }

    public static void TouchMove(int i2, float f2, float f3, int i3) {
        a b2;
        int i4 = i2;
        int i5 = i3;
        try {
            if (y != null && (b2 = b(i2)) != null) {
                float f4 = b2.f2354c;
                float f5 = b2.d;
                int i6 = 11;
                if (i5 <= 200) {
                    float f6 = f4 - f2;
                    float f7 = f5 - f3;
                    double sqrt = Math.sqrt((double) ((f6 * f6) + (f7 * f7)));
                    double min = (double) Math.min(com.cyjh.mq.a.a.g.getApplicationContext().getResources().getDisplayMetrics().widthPixels, com.cyjh.mq.a.a.g.getApplicationContext().getResources().getDisplayMetrics().heightPixels);
                    if (!(2.0d * sqrt > min)) {
                        i6 = ((int) ((sqrt * 20.0d) / min)) + 1;
                    }
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                for (int i7 = 1; i7 <= i6; i7++) {
                    long uptimeMillis2 = SystemClock.uptimeMillis();
                    float f8 = ((float) i7) / ((float) i6);
                    a(i4, ((f2 - f4) * f8) + f4, ((f3 - f5) * f8) + f5);
                    int a2 = a(i4, 2);
                    int g2 = g();
                    h();
                    e().sendPointerSync(MotionEvent.obtain(uptimeMillis2, uptimeMillis2, a2, g2, z, A, 0, 0, 0.0f, 0.0f, 0, 0, 0, 0));
                    if (i5 != 0) {
                        long uptimeMillis3 = (((long) i5) - (SystemClock.uptimeMillis() - uptimeMillis)) / ((long) ((i6 + 1) - i7));
                        if (uptimeMillis3 >= 10) {
                            Thread.sleep(uptimeMillis3);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.toString();
        }
    }

    public static void TouchMoveEvent(int i2, float f2, float f3, int i3) {
        int i4 = i3;
        try {
            if (y != null && b(i2) != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                a(i2, f2, f3);
                int a2 = a(i2, 2);
                int g2 = g();
                h();
                if (i4 > 10) {
                    Thread.sleep((long) (i4 - 15));
                }
                e().sendPointerSync(MotionEvent.obtain(uptimeMillis, uptimeMillis, a2, g2, z, A, 0, 0, 0.0f, 0.0f, 0, 0, 0, 0));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void TouchUp(int i2) {
        int i3 = i2;
        try {
            if (y != null && b(i2) != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                int a2 = a(i3, 3);
                int g2 = g();
                h();
                e().sendPointerSync(MotionEvent.obtain(uptimeMillis, uptimeMillis, a2, g2, z, A, 0, 0, 0.0f, 0.0f, 0, 0, 0, 0));
                for (int i4 = 0; i4 < 5; i4++) {
                    if (i3 == y[i4].f2353b) {
                        y[i4].f2352a = true;
                        y[i4].f2353b = 0;
                        y[i4].f2354c = 0.0f;
                        y[i4].d = 0.0f;
                    }
                }
            }
        } catch (Throwable th) {
            th.toString();
        }
    }

    public static void TracePrint(String str) {
    }

    public static int UninstallApp(String str, String str2) {
        return -1;
    }

    public static void UnlockScreen() {
        e.h();
    }

    public static String UrlRequest(int i2, String str, String str2, int i3) {
        if (i3 <= 0) {
            i3 = 5;
        }
        if (i2 == 1) {
            try {
                int i4 = i3 * 1000;
                String body = HttpRequest.get((CharSequence) a(str)).connectTimeout(i4).readTimeout(i4).useCaches(false).body();
                return body == null ? "" : body;
            } catch (HttpRequest.HttpRequestException unused) {
                return "";
            }
        } else if (i2 != 2) {
            return "";
        } else {
            int i5 = i3 * 1000;
            String body2 = new HttpRequest((CharSequence) str, "POST").header("User-Agent", t).followRedirects(false).connectTimeout(i5).readTimeout(i5).useCaches(false).send((CharSequence) str2).body();
            return body2 == null ? "" : body2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:77:0x01fb A[SYNTHETIC, Splitter:B:77:0x01fb] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0200 A[Catch:{ IOException -> 0x01c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x021b A[SYNTHETIC, Splitter:B:86:0x021b] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0224 A[Catch:{ IOException -> 0x021f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String UrlRequestEx(int r17, java.lang.String r18) {
        /*
            r1 = r17
            r2 = r18
            java.lang.String r3 = "RootIpcFramework"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "UrlRequestEx: type="
            r4.<init>(r5)
            r4.append(r1)
            java.lang.String r5 = " postData:"
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r3, r4)
            java.lang.String r3 = ""
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            r5.<init>(r2)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.lang.String r2 = "url"
            java.lang.String r2 = r5.getString(r2)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.lang.String r6 = "data"
            java.lang.String r6 = r5.getString(r6)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.lang.String r7 = "code"
            java.lang.String r7 = r5.getString(r7)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.lang.String r8 = "setcookie"
            java.lang.String r8 = r5.getString(r8)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.lang.String r9 = "cookie"
            java.lang.String r9 = r5.getString(r9)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            if (r7 == 0) goto L_0x004c
            boolean r10 = r7.isEmpty()     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            if (r10 == 0) goto L_0x004e
        L_0x004c:
            java.lang.String r7 = "UTF-8"
        L_0x004e:
            java.lang.String r10 = "http"
            boolean r10 = r2.contains(r10)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            if (r10 != 0) goto L_0x0064
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.lang.String r11 = "http://"
            r10.<init>(r11)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            r10.append(r2)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.lang.String r2 = r10.toString()     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
        L_0x0064:
            java.net.URL r10 = new java.net.URL     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            r10.<init>(r2)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.net.URLConnection r2 = r10.openConnection()     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            r10 = 10000(0x2710, float:1.4013E-41)
            r2.setConnectTimeout(r10)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            r2.setReadTimeout(r10)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.lang.String r10 = "header"
            java.lang.Object r10 = r5.get(r10)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            boolean r10 = r10 instanceof org.json.JSONArray     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            r11 = 0
            if (r10 == 0) goto L_0x00c6
            java.lang.String r10 = "RootIpcFramework"
            java.lang.String r12 = "jsonObject: is JSONArray"
            android.util.Log.e(r10, r12)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.lang.String r10 = "header"
            org.json.JSONArray r5 = r5.getJSONArray(r10)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            org.json.JSONObject r5 = r5.getJSONObject(r11)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.util.Iterator r10 = r5.keys()     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
        L_0x0097:
            boolean r12 = r10.hasNext()     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            if (r12 == 0) goto L_0x00c6
            java.lang.Object r12 = r10.next()     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.lang.String r13 = r5.getString(r12)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.lang.String r14 = "RootIpcFramework"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.lang.String r4 = "UrlRequestEx: key="
            r15.<init>(r4)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            r15.append(r12)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.lang.String r4 = "value="
            r15.append(r4)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            r15.append(r13)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.lang.String r4 = r15.toString()     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            android.util.Log.e(r14, r4)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            r2.setRequestProperty(r12, r13)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            goto L_0x0097
        L_0x00c6:
            boolean r4 = r9.isEmpty()     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            if (r4 != 0) goto L_0x00d1
            java.lang.String r4 = "Cookie"
            r2.setRequestProperty(r4, r9)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
        L_0x00d1:
            r4 = 2
            r5 = 200(0xc8, float:2.8E-43)
            r9 = 1
            if (r1 != r4) goto L_0x0127
            r2.setDoOutput(r9)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            r2.setDoInput(r9)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            r2.connect()     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.io.PrintWriter r4 = new java.io.PrintWriter     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.io.OutputStreamWriter r1 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.io.OutputStream r9 = r2.getOutputStream()     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            r1.<init>(r9, r7)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            r4.print(r6)     // Catch:{ Exception -> 0x0122, all -> 0x011d }
            r4.flush()     // Catch:{ Exception -> 0x0122, all -> 0x011d }
            int r1 = r2.getResponseCode()     // Catch:{ Exception -> 0x0122, all -> 0x011d }
            if (r1 != r5) goto L_0x010e
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0122, all -> 0x011d }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0122, all -> 0x011d }
            java.io.InputStream r9 = r2.getInputStream()     // Catch:{ Exception -> 0x0122, all -> 0x011d }
            r6.<init>(r9, r7)     // Catch:{ Exception -> 0x0122, all -> 0x011d }
            r1.<init>(r6)     // Catch:{ Exception -> 0x0122, all -> 0x011d }
        L_0x0108:
            r16 = r4
            r4 = r1
            r1 = r16
            goto L_0x0153
        L_0x010e:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0122, all -> 0x011d }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0122, all -> 0x011d }
            java.io.InputStream r9 = r2.getErrorStream()     // Catch:{ Exception -> 0x0122, all -> 0x011d }
            r6.<init>(r9, r7)     // Catch:{ Exception -> 0x0122, all -> 0x011d }
            r1.<init>(r6)     // Catch:{ Exception -> 0x0122, all -> 0x011d }
            goto L_0x0108
        L_0x011d:
            r0 = move-exception
            r1 = r0
            r2 = 0
            goto L_0x0219
        L_0x0122:
            r0 = move-exception
            r1 = r0
            r2 = 0
            goto L_0x01df
        L_0x0127:
            if (r1 != r9) goto L_0x0151
            r2.connect()     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            int r1 = r2.getResponseCode()     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            if (r1 != r5) goto L_0x0142
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.io.InputStream r6 = r2.getInputStream()     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            r1.<init>(r6, r7)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
        L_0x0140:
            r1 = 0
            goto L_0x0153
        L_0x0142:
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            java.io.InputStream r6 = r2.getErrorStream()     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            r1.<init>(r6, r7)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x01db, all -> 0x01d6 }
            goto L_0x0140
        L_0x0151:
            r1 = 0
            r4 = 0
        L_0x0153:
            java.lang.String r6 = r4.readLine()     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
            if (r6 == 0) goto L_0x016a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
            r7.<init>()     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
            r7.append(r3)     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
            r7.append(r6)     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
            java.lang.String r6 = r7.toString()     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
            r3 = r6
            goto L_0x0153
        L_0x016a:
            int r6 = r2.getResponseCode()     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
            if (r6 == r5) goto L_0x0189
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
            r5.<init>()     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
            int r6 = r2.getResponseCode()     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
            r5.append(r6)     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
            java.lang.String r6 = " "
            r5.append(r6)     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
            r5.append(r3)     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
            r3 = r5
        L_0x0189:
            java.lang.String r5 = "Set-Cookie"
            java.lang.String r2 = r2.getHeaderField(r5)     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
            if (r2 == 0) goto L_0x01ba
            boolean r5 = r2.isEmpty()     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
            if (r5 != 0) goto L_0x01ba
            boolean r5 = r8.isEmpty()     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
            if (r5 != 0) goto L_0x01ba
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
            r5.<init>(r8)     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
            boolean r6 = r5.exists()     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
            if (r6 != 0) goto L_0x01ab
            r5.createNewFile()     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
        L_0x01ab:
            java.io.FileWriter r6 = new java.io.FileWriter     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
            java.lang.String r5 = r5.getName()     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
            r6.<init>(r5, r11)     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
            r6.write(r2)     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
            r6.close()     // Catch:{ Exception -> 0x01d1, all -> 0x01cd }
        L_0x01ba:
            if (r1 == 0) goto L_0x01c3
            r1.close()     // Catch:{ IOException -> 0x01c0 }
            goto L_0x01c3
        L_0x01c0:
            r0 = move-exception
            r1 = r0
            goto L_0x01c9
        L_0x01c3:
            if (r4 == 0) goto L_0x0203
            r4.close()     // Catch:{ IOException -> 0x01c0 }
            goto L_0x0203
        L_0x01c9:
            r1.printStackTrace()
            goto L_0x0203
        L_0x01cd:
            r0 = move-exception
            r2 = r4
            r4 = r1
            goto L_0x0218
        L_0x01d1:
            r0 = move-exception
            r2 = r4
            r4 = r1
            r1 = r0
            goto L_0x01df
        L_0x01d6:
            r0 = move-exception
            r1 = r0
            r2 = 0
            r4 = 0
            goto L_0x0219
        L_0x01db:
            r0 = move-exception
            r1 = r0
            r2 = 0
            r4 = 0
        L_0x01df:
            java.lang.String r5 = "RootIpcFramework"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0217 }
            java.lang.String r7 = "UrlRequestEx: Exception:"
            r6.<init>(r7)     // Catch:{ all -> 0x0217 }
            java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x0217 }
            r6.append(r7)     // Catch:{ all -> 0x0217 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0217 }
            android.util.Log.e(r5, r6)     // Catch:{ all -> 0x0217 }
            r1.printStackTrace()     // Catch:{ all -> 0x0217 }
            if (r4 == 0) goto L_0x01fe
            r4.close()     // Catch:{ IOException -> 0x01c0 }
        L_0x01fe:
            if (r2 == 0) goto L_0x0203
            r2.close()     // Catch:{ IOException -> 0x01c0 }
        L_0x0203:
            java.lang.String r1 = "RootIpcFramework"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "UrlRequestEx: result:"
            r2.<init>(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2)
            return r3
        L_0x0217:
            r0 = move-exception
        L_0x0218:
            r1 = r0
        L_0x0219:
            if (r4 == 0) goto L_0x0222
            r4.close()     // Catch:{ IOException -> 0x021f }
            goto L_0x0222
        L_0x021f:
            r0 = move-exception
            r2 = r0
            goto L_0x0228
        L_0x0222:
            if (r2 == 0) goto L_0x022b
            r2.close()     // Catch:{ IOException -> 0x021f }
            goto L_0x022b
        L_0x0228:
            r2.printStackTrace()
        L_0x022b:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.event.Injector.UrlRequestEx(int, java.lang.String):java.lang.String");
    }

    public static void Vibrate(int i2) {
        e.a(i2);
    }

    private static final float a(float f2, float f3, float f4) {
        return ((f3 - f2) * f4) + f2;
    }

    private static int a(int i2, int i3) {
        int g2 = g();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i5 < 5) {
                if (!y[i5].f2352a && y[i5].f2353b == i2) {
                    break;
                }
                i5++;
            } else {
                i5 = -1;
                break;
            }
        }
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            if (!y[i7].f2352a) {
                i6++;
            }
        }
        switch (i3) {
            case 1:
                if (1 != g2) {
                    i4 = (i6 * 256) + 5;
                    break;
                }
                break;
            case 2:
                if (1 != g2) {
                    i4 = (i6 * 256) + 2;
                    break;
                } else {
                    i4 = 2;
                    break;
                }
            case 3:
                if (1 != g2) {
                    i4 = (i6 * 256) + 6;
                    break;
                } else {
                    i4 = 1;
                    break;
                }
        }
        StringBuilder sb = new StringBuilder("injector>>>>>>touchType:");
        sb.append(i3);
        sb.append("action:");
        sb.append(i4);
        sb.append("---pointerNum:");
        sb.append(g2);
        sb.append("---pointerId:");
        sb.append(i6);
        return i4;
    }

    private static String a(String str) {
        try {
            Matcher matcher = Pattern.compile("[\\u4e00-\\u9fa5]").matcher(str);
            while (matcher.find()) {
                String group = matcher.group();
                str = str.replaceAll(group, URLEncoder.encode(group, "UTF-8"));
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        return str;
    }

    static /* synthetic */ void a() {
        OnScriptListener onScriptListener = MqRunnerLite.getInstance().f2788a;
        if (onScriptListener != null) {
            onScriptListener.onPause();
        }
    }

    private static void a(int i2) {
        for (int i3 = 0; i3 < 5; i3++) {
            if (i2 == y[i3].f2353b) {
                y[i3].f2352a = true;
                y[i3].f2353b = 0;
                y[i3].f2354c = 0.0f;
                y[i3].d = 0.0f;
            }
        }
    }

    private static void a(int i2, float f2, float f3) {
        a aVar;
        int i3 = 0;
        while (true) {
            if (i3 < 5) {
                if (!y[i3].f2352a && y[i3].f2353b == i2) {
                    y[i3].f2353b = i2;
                    y[i3].f2354c = f2;
                    y[i3].d = f3;
                    aVar = y[i3];
                    break;
                }
                i3++;
            } else {
                int i4 = 0;
                while (i4 < 5) {
                    if (y[i4].f2352a) {
                        y[i4].f2353b = i2;
                        y[i4].f2354c = f2;
                        y[i4].d = f3;
                        aVar = y[i4];
                    } else {
                        i4++;
                    }
                }
                return;
            }
        }
        aVar.f2352a = false;
    }

    private static void a(int i2, b bVar) {
        StringBuilder sb = new StringBuilder("sendToTargetHandler ");
        sb.append(i2);
        sb.append("         ");
        sb.append(bVar);
        j.obtainMessage(i2, bVar).sendToTarget();
    }

    static /* synthetic */ void a(b bVar) {
        if (d == null) {
            d = new ExToast(f2351c);
        }
        d.show(bVar.d, bVar.f2365a, bVar.f2366b, bVar.f2367c);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x0601, code lost:
        r0.a(r1, r9);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(byte[] r9) {
        /*
            com.google.protobuf.ByteString r9 = com.google.protobuf.ByteString.copyFrom((byte[]) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$CommandToUi r9 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.CommandToUi.parseFrom((com.google.protobuf.ByteString) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 == 0) goto L_0x0988
            com.cyjh.mobileanjian.ipc.ui.i r0 = f     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r7 = r9.getControlId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$CommandToUi$Command_Type r1 = r9.getCommand()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r3 = "command: "
            r2.<init>(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.append(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int[] r2 = com.cyjh.mobileanjian.ipc.ui.i.AnonymousClass3.f2641a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r1 = r1.ordinal()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r2[r1]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = 2
            r3 = 3
            r8 = 1
            r4 = 0
            switch(r1) {
                case 1: goto L_0x0979;
                case 2: goto L_0x0967;
                case 3: goto L_0x091d;
                case 4: goto L_0x08aa;
                case 5: goto L_0x08a5;
                case 6: goto L_0x089f;
                case 7: goto L_0x089a;
                case 8: goto L_0x0878;
                case 9: goto L_0x084b;
                case 10: goto L_0x07ee;
                case 11: goto L_0x0789;
                case 12: goto L_0x0759;
                case 13: goto L_0x0725;
                case 14: goto L_0x06e6;
                case 15: goto L_0x06af;
                case 16: goto L_0x0676;
                case 17: goto L_0x063e;
                case 18: goto L_0x0606;
                case 19: goto L_0x05cf;
                case 20: goto L_0x0593;
                case 21: goto L_0x0578;
                case 22: goto L_0x0554;
                case 23: goto L_0x054e;
                case 24: goto L_0x054e;
                case 25: goto L_0x054e;
                case 26: goto L_0x054e;
                case 27: goto L_0x054e;
                case 28: goto L_0x054e;
                case 29: goto L_0x054e;
                case 30: goto L_0x054e;
                case 31: goto L_0x054e;
                case 32: goto L_0x054e;
                case 33: goto L_0x054e;
                case 34: goto L_0x0518;
                case 35: goto L_0x0514;
                case 36: goto L_0x0510;
                case 37: goto L_0x04ce;
                case 38: goto L_0x03e1;
                case 39: goto L_0x0320;
                case 40: goto L_0x0287;
                case 41: goto L_0x0283;
                case 42: goto L_0x021b;
                case 43: goto L_0x01bb;
                case 44: goto L_0x00df;
                case 45: goto L_0x0985;
                case 46: goto L_0x00a2;
                case 47: goto L_0x0985;
                case 48: goto L_0x002f;
                default: goto L_0x002d;
            }     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x002d:
            goto L_0x0985
        L_0x002f:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 != 0) goto L_0x003b
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x003b:
            java.lang.String r1 = r9.getControlId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r2[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r0 = r0.b((java.lang.String) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r0 != 0) goto L_0x004f
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x004f:
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$Padding_Var r9 = r9.getPadding()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r2 = "padding: "
            r1.<init>(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r9.getLeft()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.append(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r2 = "padding: "
            r1.<init>(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r9.getTop()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.append(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r2 = "padding: "
            r1.<init>(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r9.getRight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.append(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r2 = "padding: "
            r1.<init>(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r9.getBottom()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.append(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r1 = r9.getLeft()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r9.getTop()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r9.getRight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = r9.getBottom()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.setPadding(r1, r2, r3, r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x00a2:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 != 0) goto L_0x00ae
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x00ae:
            java.lang.String r1 = r9.getControlId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r2[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r0 = r0.b((java.lang.String) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r0 != 0) goto L_0x00c2
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x00c2:
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.LinearLayout$LayoutParams r1 = (android.widget.LinearLayout.LayoutParams) r1     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = r9.getAlignType()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.gravity = r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.setLayoutParams(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r0 = "set gravity ok; "
            r9.<init>(r0)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9.append(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x00df:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r5 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r5]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 != 0) goto L_0x00eb
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x00eb:
            java.lang.String r1 = r9.getControlId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r5 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r6 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r5 = r5[r6]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r5 = r5.get(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r5 != 0) goto L_0x00ff
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x00ff:
            int[] r5 = com.cyjh.mobileanjian.ipc.ui.i.AnonymousClass3.f2642b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r6 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r7 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r6 = r6[r7]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r6 = r6.get(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r6 = (com.cyjh.mobileanjian.ipc.ui.m) r6     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r6 = r6.ordinal()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r5 = r5[r6]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            switch(r5) {
                case 1: goto L_0x0150;
                case 2: goto L_0x0150;
                case 3: goto L_0x0150;
                case 4: goto L_0x013f;
                case 5: goto L_0x011a;
                default: goto L_0x0116;
            }     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x0116:
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x011a:
            com.cyjh.mobileanjian.ipc.ui.k[] r5 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r5[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r0 = r0.b((java.lang.String) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.RadioGroup r0 = (android.widget.RadioGroup) r0     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = r9.getItemIndex()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r9 = r0.findViewById(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.RadioButton r9 = (android.widget.RadioButton) r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 != 0) goto L_0x0136
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0136:
            android.text.TextPaint r9 = r9.getPaint()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x013a:
            int r9 = r9.getColor()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0161
        L_0x013f:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r9 = r9.b((java.lang.String) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.CheckBox r9 = (android.widget.CheckBox) r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.text.TextPaint r9 = r9.getPaint()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x013a
        L_0x0150:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r9 = r9.b((java.lang.String) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.TextView r9 = (android.widget.TextView) r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.text.TextPaint r9 = r9.getPaint()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x013a
        L_0x0161:
            java.lang.String r0 = "%02X%02X%02X"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r5 = android.graphics.Color.blue(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r3[r4] = r5     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r4 = android.graphics.Color.green(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r3[r8] = r4     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = android.graphics.Color.red(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r3[r2] = r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = java.lang.String.format(r0, r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.newBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = r0.setControlId(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.STRING     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = r0.setType(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r0.setStringValue(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar r9 = r9.build()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.RSP_MSG     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r9 = r0.addVarTable((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r9 = r9.build()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.google.protobuf.ByteString r9 = r9.toByteString()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.event.c.a(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x01bb:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r1 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r1]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 != 0) goto L_0x01c7
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x01c7:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r9 = r9.b((java.lang.String) r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 != 0) goto L_0x01d7
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x01d7:
            int r9 = r9.getVisibility()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 == 0) goto L_0x01e4
            r0 = 4
            if (r9 == r0) goto L_0x01e7
            r0 = 8
            if (r9 == r0) goto L_0x01e6
        L_0x01e4:
            r2 = 1
            goto L_0x01e7
        L_0x01e6:
            r2 = 3
        L_0x01e7:
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.newBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r9.setControlId(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.INT     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r9.setType(r0)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r9.setIntValue(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar r9 = r9.build()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.RSP_MSG     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r9 = r0.addVarTable((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r9 = r9.build()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.google.protobuf.ByteString r9 = r9.toByteString()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.event.c.a(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x021b:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r1 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r1]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 != 0) goto L_0x0227
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0227:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r1 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r1]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r9 = r9.b((java.lang.String) r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 != 0) goto L_0x0237
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0237:
            boolean r1 = r9.isEnabled()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r2 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r2[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.EDIT_TEXT     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r0 != r2) goto L_0x024f
            android.widget.EditText r9 = (android.widget.EditText) r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            boolean r1 = r9.isFocusable()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x024f:
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.newBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r9.setControlId(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.BOOL     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r9.setType(r0)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r9.setBoolValue(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar r9 = r9.build()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.RSP_MSG     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r9 = r0.addVarTable((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r9 = r9.build()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.google.protobuf.ByteString r9 = r9.toByteString()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.event.c.a(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0283:
            r0.e((java.lang.String) r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0287:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 != 0) goto L_0x0293
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0293:
            java.lang.String r1 = r9.getControlId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r2 = r2.b((java.lang.String) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r2 != 0) goto L_0x02a7
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x02a7:
            java.lang.String r9 = r9.getColor()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r3 = "^#*([0-9A-Fa-f]{6})|([0-9A-Fa-f]{3})"
            boolean r3 = r9.matches(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r3 != 0) goto L_0x02be
            int r9 = com.cyjh.mqsdk.R.string.ui_show_invalid_color_value     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a((int) r9, (java.lang.Object[]) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x02be:
            java.lang.String r3 = "#"
            boolean r3 = r9.startsWith(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r3 != 0) goto L_0x02d4
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r4 = "#"
            r3.<init>(r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r3.append(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r3.toString()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x02d4:
            int r9 = android.graphics.Color.parseColor(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = com.cyjh.mobileanjian.ipc.utils.c.a(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r3 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r4 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r3 = r3[r4]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r4 = com.cyjh.mobileanjian.ipc.ui.m.BUTTON     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r3 != r4) goto L_0x030b
            android.graphics.drawable.GradientDrawable r1 = new android.graphics.drawable.GradientDrawable     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.setColor(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = r0.b()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            float r9 = (float) r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.setCornerRadius(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = 16
            if (r9 < r0) goto L_0x0304
            r2.setBackground(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0307
        L_0x0304:
            r2.setBackgroundDrawable(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x0307:
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x030b:
            java.util.HashMap[] r3 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r3[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r1 = com.cyjh.mobileanjian.ipc.ui.m.SPINNER     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r0 == r1) goto L_0x031c
            r2.setBackgroundColor(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x031c:
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0320:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 != 0) goto L_0x032c
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x032c:
            java.lang.String r1 = r9.getControlId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r2 = r9.getColor()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r3 = "^#*([0-9A-Fa-f]{6})|([0-9A-Fa-f]{3})"
            boolean r3 = r2.matches(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r3 != 0) goto L_0x0347
            int r9 = com.cyjh.mqsdk.R.string.ui_show_invalid_color_value     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a((int) r9, (java.lang.Object[]) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0347:
            java.lang.String r3 = "#"
            boolean r3 = r2.startsWith(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r3 != 0) goto L_0x035d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r5 = "#"
            r3.<init>(r5)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r3.append(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r2 = r3.toString()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x035d:
            int r2 = android.graphics.Color.parseColor(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = com.cyjh.mobileanjian.ipc.utils.c.a(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r3 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r3 == 0) goto L_0x0381
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.intValue()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9.a((int) r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x03dd
        L_0x0381:
            com.cyjh.mobileanjian.ipc.ui.k[] r3 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r5 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r3 = r3[r5]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r3 = r3.b((java.lang.String) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r3 != 0) goto L_0x0391
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0391:
            int[] r5 = com.cyjh.mobileanjian.ipc.ui.i.AnonymousClass3.f2642b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r6 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r6[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r0 = (com.cyjh.mobileanjian.ipc.ui.m) r0     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.ordinal()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r5[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            switch(r0) {
                case 1: goto L_0x03d8;
                case 2: goto L_0x03d8;
                case 3: goto L_0x03d8;
                case 4: goto L_0x03d2;
                case 5: goto L_0x03bc;
                case 6: goto L_0x03ac;
                default: goto L_0x03a8;
            }     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x03a8:
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x03ac:
            android.widget.Spinner r3 = (android.widget.Spinner) r3     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = r9.getItemIndex()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r3.getCount()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 < r0) goto L_0x03dd
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x03bc:
            android.widget.RadioGroup r3 = (android.widget.RadioGroup) r3     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = r9.getItemIndex()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r9 = r3.findViewById(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.RadioButton r9 = (android.widget.RadioButton) r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 != 0) goto L_0x03ce
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x03ce:
            r9.setTextColor(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x03dd
        L_0x03d2:
            android.widget.CheckBox r3 = (android.widget.CheckBox) r3     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r3.setTextColor(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x03dd
        L_0x03d8:
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r3.setTextColor(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x03dd:
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x03e1:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 != 0) goto L_0x03ed
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x03ed:
            java.lang.String r1 = r9.getControlId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r2 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r2 != 0) goto L_0x0401
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0401:
            int[] r2 = com.cyjh.mobileanjian.ipc.ui.i.AnonymousClass3.f2642b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r3 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r5 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r3 = r3[r5]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r3 = (com.cyjh.mobileanjian.ipc.ui.m) r3     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r3.ordinal()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            switch(r2) {
                case 1: goto L_0x0489;
                case 2: goto L_0x0489;
                case 3: goto L_0x0489;
                case 4: goto L_0x0478;
                case 5: goto L_0x0453;
                case 6: goto L_0x041c;
                default: goto L_0x0418;
            }     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x0418:
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x041c:
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r2[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r0 = r0.b((java.lang.String) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.Spinner r0 = (android.widget.Spinner) r0     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r9.getItemIndex()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.getCount()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r2 < r3) goto L_0x0436
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0436:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r3 = "Spinner Get pos: "
            r2.<init>(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r9.getItemIndex()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r3 = r0.getItemAtPosition(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.append(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = r9.getItemIndex()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r9 = r0.getItemAtPosition(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x049a
        L_0x0453:
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r2[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r0 = r0.b((java.lang.String) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.RadioGroup r0 = (android.widget.RadioGroup) r0     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = r9.getItemIndex()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r9 = r0.findViewById(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.RadioButton r9 = (android.widget.RadioButton) r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 != 0) goto L_0x046f
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x046f:
            java.lang.CharSequence r9 = r9.getText()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x0473:
            java.lang.String r9 = r9.toString()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x049a
        L_0x0478:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r9 = r9.b((java.lang.String) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.CheckBox r9 = (android.widget.CheckBox) r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.CharSequence r9 = r9.getText()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0473
        L_0x0489:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r9 = r9.b((java.lang.String) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.TextView r9 = (android.widget.TextView) r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.CharSequence r9 = r9.getText()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0473
        L_0x049a:
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.newBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = r0.setControlId(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.STRING     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = r0.setType(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r0.setStringValue(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar r9 = r9.build()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.RSP_MSG     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r9 = r0.addVarTable((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r9 = r9.build()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.google.protobuf.ByteString r9 = r9.toByteString()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.event.c.a(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x04ce:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 != 0) goto L_0x04da
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x04da:
            java.lang.String r1 = r9.getControlId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9.getText()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r2 = r2.b((java.lang.String) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r2 != 0) goto L_0x04f1
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x04f1:
            java.util.HashMap[] r3 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r3[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r1 = com.cyjh.mobileanjian.ipc.ui.m.EDIT_TEXT     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r0 == r1) goto L_0x0503
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0503:
            android.widget.EditText r2 = (android.widget.EditText) r2     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = r9.getEditInputType()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.setInputType(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0510:
            r0.b((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.CommandToUi) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0514:
            r0.c((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.CommandToUi) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0518:
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r9 = r9.get(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 == 0) goto L_0x0525
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x0525:
            java.util.HashMap[] r9 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r1 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r1]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r9 = r9.get(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 != 0) goto L_0x0536
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x0536:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r9 = r9.b((java.lang.String) r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.ViewGroup$LayoutParams r0 = r9.getLayoutParams()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = -1
            r0.width = r1     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9.setLayoutParams(r0)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x054e:
            boolean r8 = r0.a((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.CommandToUi) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x0554:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 == 0) goto L_0x0985
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.a()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r2 = r9.getControlId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r3 = r9.getParentId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r9.getText()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            boolean r8 = r1.a((int) r0, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x0578:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 == 0) goto L_0x0985
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r1[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r1 = r9.getControlId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = r9.getHeight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a((java.lang.String) r1, (int) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x0593:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 == 0) goto L_0x0985
            com.cyjh.mobileanjian.ipc.ui.g r1 = r0.f2636c     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.List r2 = r9.getItemTextList()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r9.getDefaultItemIndex()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9.getWidth()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9.getHeight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.Spinner r1 = r1.a((java.lang.String) r7, (java.util.List<java.lang.String>) r2, (int) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r2 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.SPINNER     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.put(r7, r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r9.getParentId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.a((android.view.View) r1, (java.lang.String) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.setOnItemSelectedListener(r0)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x05cf:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 == 0) goto L_0x0985
            com.cyjh.mobileanjian.ipc.ui.g r1 = r0.f2636c     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r9.getWidth()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r9.getHeight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r4 = r9.getUrl()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.webkit.WebView r1 = r1.a((java.lang.String) r7, (int) r2, (int) r3, (java.lang.String) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r2 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.WEB_VIEW     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.put(r7, r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r2[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r9.getParentId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x0601:
            r0.a((android.view.View) r1, (java.lang.String) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x0606:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 == 0) goto L_0x0985
            com.cyjh.mobileanjian.ipc.ui.g r1 = r0.f2636c     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.a()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r4 = r9.getWidth()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r5 = r9.getHeight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r6 = r9.getPath()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r3 = r7
            android.widget.ImageView r1 = r1.a((int) r2, (java.lang.String) r3, (int) r4, (int) r5, (java.lang.String) r6)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r2 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.IMAGE_VIEW     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.put(r7, r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.setOnClickListener(r0)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r2[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r9.getParentId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0601
        L_0x063e:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 == 0) goto L_0x0985
            com.cyjh.mobileanjian.ipc.ui.g r1 = r0.f2636c     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r3 = r9.getText()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r4 = r9.getWidth()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r5 = r9.getHeight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            boolean r6 = r9.getDefaultCheckStatus()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r7
            android.widget.CheckBox r1 = r1.a((java.lang.String) r2, (java.lang.String) r3, (int) r4, (int) r5, (boolean) r6)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r2 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.CHECK_BOX     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.put(r7, r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r2[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r9.getParentId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0601
        L_0x0676:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 == 0) goto L_0x0985
            com.cyjh.mobileanjian.ipc.ui.g r1 = r0.f2636c     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.List r3 = r9.getItemTextList()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r4 = r9.getDefaultItemIndex()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r5 = r9.getWidth()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r6 = r9.getHeight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r7
            android.widget.RadioGroup r1 = r1.a((java.lang.String) r2, (java.util.List<java.lang.String>) r3, (int) r4, (int) r5, (int) r6)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r2 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.RADIIO_GROUP     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.put(r7, r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r2[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r9.getParentId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0601
        L_0x06af:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 == 0) goto L_0x0985
            com.cyjh.mobileanjian.ipc.ui.g r1 = r0.f2636c     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r2 = r9.getText()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r9.getWidth()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r4 = r9.getHeight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.Button r1 = r1.b(r7, r2, r3, r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r2 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.BUTTON     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.put(r7, r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.setOnClickListener(r0)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r2[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r9.getParentId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0601
        L_0x06e6:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 == 0) goto L_0x0985
            com.cyjh.mobileanjian.ipc.ui.g r1 = r0.f2636c     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r2 = r9.getText()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r9.getWidth()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r4 = r9.getHeight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.EditText r1 = r1.d(r7, r2, r3, r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r2 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.EDIT_TEXT     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.put(r7, r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r9.getParentId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.a((android.view.View) r1, (java.lang.String) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i$a r9 = new com.cyjh.mobileanjian.ipc.ui.i$a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9.<init>(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.addTextChangedListener(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x0725:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 == 0) goto L_0x0985
            com.cyjh.mobileanjian.ipc.ui.g r1 = r0.f2636c     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r2 = r9.getText()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r9.getWidth()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r4 = r9.getHeight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.TextView r1 = r1.a((java.lang.String) r7, (java.lang.String) r2, (int) r3, (int) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r2 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.TEXT_VIEW     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.put(r7, r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r2[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r9.getParentId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0601
        L_0x0759:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 == 0) goto L_0x0985
            com.cyjh.mobileanjian.ipc.ui.g r1 = r0.f2636c     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r9.getWidth()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r9.getHeight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.LinearLayout r1 = r1.b(r7, r2, r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r2 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.LINE     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.put(r7, r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r2[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r9.getParentId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0601
        L_0x0789:
            java.lang.String r1 = r9.getControlId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r9.getColor()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r2 != 0) goto L_0x07a6
            int r9 = com.cyjh.mqsdk.R.string.ui_show_not_found_ui     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2[r4] = r1     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a((int) r9, (java.lang.Object[]) r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x07a6:
            java.lang.String r2 = "^#*([0-9A-Fa-f]{6})|([0-9A-Fa-f]{3})"
            boolean r2 = r9.matches(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r2 != 0) goto L_0x07b9
            int r9 = com.cyjh.mqsdk.R.string.ui_show_invalid_color_value     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a((int) r9, (java.lang.Object[]) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x07b9:
            java.lang.String r2 = "#"
            boolean r2 = r9.startsWith(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r2 != 0) goto L_0x07cf
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r3 = "#"
            r2.<init>(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.append(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r2.toString()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x07cf:
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r1 = r1.intValue()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = android.graphics.Color.parseColor(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = com.cyjh.mobileanjian.ipc.utils.c.a(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r0[r1]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.b((int) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x07ee:
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r9 = r9.get(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 != 0) goto L_0x0803
            int r9 = com.cyjh.mqsdk.R.string.ui_show_not_found_ui     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object[] r1 = new java.lang.Object[r8]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1[r4] = r7     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a((int) r9, (java.lang.Object[]) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0803:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.intValue()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r9.a()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.newBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = r0.setControlId(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.STRING     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = r0.setType(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r0.setStringValue(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar r9 = r9.build()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.RSP_MSG     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r9 = r0.addVarTable((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r9 = r9.build()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.google.protobuf.ByteString r9 = r9.toByteString()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.event.c.a(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x084b:
            java.lang.String r9 = r9.getText()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r1 = r1.get(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 != 0) goto L_0x0863
            int r9 = com.cyjh.mqsdk.R.string.ui_show_not_found_ui     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object[] r1 = new java.lang.Object[r8]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1[r4] = r7     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a((int) r9, (java.lang.Object[]) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r8 = 0
            goto L_0x0985
        L_0x0863:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.intValue()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r1[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a((java.lang.String) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x0878:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 == 0) goto L_0x0985
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r0 = r9.getParentId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r9.getWidth()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = r9.getHeight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.a((java.lang.String) r7, (java.lang.String) r0, (int) r2, (int) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x089a:
            r0.c()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x089f:
            boolean r8 = r0.d((java.lang.String) r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x08a5:
            com.cyjh.mobileanjian.ipc.ui.i.c((java.lang.String) r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x08aa:
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r9 = r9.get(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 != 0) goto L_0x08bf
            int r9 = com.cyjh.mqsdk.R.string.ui_show_not_found_ui     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object[] r1 = new java.lang.Object[r8]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1[r4] = r7     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a((int) r9, (java.lang.Object[]) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x08bf:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r1 = r1.get(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r1 = r1.intValue()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r1]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            boolean r9 = r9.f2658c     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 == 0) goto L_0x08d7
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x08d7:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.intValue()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9.c()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Builder r9 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlEvent.newBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Builder r9 = r9.setControlId(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Event_Type r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlEvent.Event_Type.ON_SHOW     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Builder r9 = r9.setType(r0)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent r9 = r9.build()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.EVENT     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r9 = r0.setEvent((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlEvent) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r9 = r9.build()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.google.protobuf.ByteString r9 = r9.toByteString()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.event.c.b(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x091d:
            int r1 = r9.getWidth()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = r9.getHeight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r2 + r8
            r0.f2635b = r2     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.g r4 = r0.f2636c     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k r9 = r4.a((java.lang.String) r7, (int) r1, (int) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2[r3] = r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r1 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9.put(r7, r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r9 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r1 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9[r1] = r2     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r1 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r1]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i$1 r1 = new com.cyjh.mobileanjian.ipc.ui.i$1     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.<init>(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9.f2657b = r1     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r1 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r1]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i$2 r1 = new com.cyjh.mobileanjian.ipc.ui.i$2     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.<init>(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9.f2656a = r1     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x0967:
            java.lang.String r9 = r9.getPath()     // Catch:{ IOException -> 0x0974, JSONException -> 0x096f }
            r0.b((java.lang.String) r9)     // Catch:{ IOException -> 0x0974, JSONException -> 0x096f }
            goto L_0x0985
        L_0x096f:
            r9 = move-exception
        L_0x0970:
            r9.printStackTrace()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x0974:
            r9 = move-exception
        L_0x0975:
            r9.printStackTrace()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x0979:
            java.lang.String r9 = r9.getPath()     // Catch:{ JSONException -> 0x0983, IOException -> 0x0981 }
            r0.a((java.lang.String) r9)     // Catch:{ JSONException -> 0x0983, IOException -> 0x0981 }
            goto L_0x0985
        L_0x0981:
            r9 = move-exception
            goto L_0x0975
        L_0x0983:
            r9 = move-exception
            goto L_0x0970
        L_0x0985:
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x0988:
            return
        L_0x0989:
            r9 = move-exception
            r9.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.event.Injector.a(byte[]):void");
    }

    private static a b(int i2) {
        for (int i3 = 0; i3 < 5; i3++) {
            if (!y[i3].f2352a && y[i3].f2353b == i2) {
                return y[i3];
            }
        }
        return null;
    }

    static /* synthetic */ void b() {
        OnScriptListener onScriptListener = MqRunnerLite.getInstance().f2788a;
        if (onScriptListener != null) {
            onScriptListener.onResume();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x0601, code lost:
        r0.a(r1, r9);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(byte[] r9) {
        /*
            com.google.protobuf.ByteString r9 = com.google.protobuf.ByteString.copyFrom((byte[]) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$CommandToUi r9 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.CommandToUi.parseFrom((com.google.protobuf.ByteString) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 == 0) goto L_0x0988
            com.cyjh.mobileanjian.ipc.ui.i r0 = f     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r7 = r9.getControlId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$CommandToUi$Command_Type r1 = r9.getCommand()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r3 = "command: "
            r2.<init>(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.append(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int[] r2 = com.cyjh.mobileanjian.ipc.ui.i.AnonymousClass3.f2641a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r1 = r1.ordinal()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r2[r1]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = 2
            r3 = 3
            r8 = 1
            r4 = 0
            switch(r1) {
                case 1: goto L_0x0979;
                case 2: goto L_0x0967;
                case 3: goto L_0x091d;
                case 4: goto L_0x08aa;
                case 5: goto L_0x08a5;
                case 6: goto L_0x089f;
                case 7: goto L_0x089a;
                case 8: goto L_0x0878;
                case 9: goto L_0x084b;
                case 10: goto L_0x07ee;
                case 11: goto L_0x0789;
                case 12: goto L_0x0759;
                case 13: goto L_0x0725;
                case 14: goto L_0x06e6;
                case 15: goto L_0x06af;
                case 16: goto L_0x0676;
                case 17: goto L_0x063e;
                case 18: goto L_0x0606;
                case 19: goto L_0x05cf;
                case 20: goto L_0x0593;
                case 21: goto L_0x0578;
                case 22: goto L_0x0554;
                case 23: goto L_0x054e;
                case 24: goto L_0x054e;
                case 25: goto L_0x054e;
                case 26: goto L_0x054e;
                case 27: goto L_0x054e;
                case 28: goto L_0x054e;
                case 29: goto L_0x054e;
                case 30: goto L_0x054e;
                case 31: goto L_0x054e;
                case 32: goto L_0x054e;
                case 33: goto L_0x054e;
                case 34: goto L_0x0518;
                case 35: goto L_0x0514;
                case 36: goto L_0x0510;
                case 37: goto L_0x04ce;
                case 38: goto L_0x03e1;
                case 39: goto L_0x0320;
                case 40: goto L_0x0287;
                case 41: goto L_0x0283;
                case 42: goto L_0x021b;
                case 43: goto L_0x01bb;
                case 44: goto L_0x00df;
                case 45: goto L_0x0985;
                case 46: goto L_0x00a2;
                case 47: goto L_0x0985;
                case 48: goto L_0x002f;
                default: goto L_0x002d;
            }     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x002d:
            goto L_0x0985
        L_0x002f:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 != 0) goto L_0x003b
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x003b:
            java.lang.String r1 = r9.getControlId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r2[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r0 = r0.b((java.lang.String) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r0 != 0) goto L_0x004f
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x004f:
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$Padding_Var r9 = r9.getPadding()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r2 = "padding: "
            r1.<init>(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r9.getLeft()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.append(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r2 = "padding: "
            r1.<init>(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r9.getTop()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.append(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r2 = "padding: "
            r1.<init>(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r9.getRight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.append(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r2 = "padding: "
            r1.<init>(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r9.getBottom()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.append(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r1 = r9.getLeft()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r9.getTop()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r9.getRight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = r9.getBottom()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.setPadding(r1, r2, r3, r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x00a2:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 != 0) goto L_0x00ae
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x00ae:
            java.lang.String r1 = r9.getControlId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r2[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r0 = r0.b((java.lang.String) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r0 != 0) goto L_0x00c2
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x00c2:
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.LinearLayout$LayoutParams r1 = (android.widget.LinearLayout.LayoutParams) r1     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = r9.getAlignType()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.gravity = r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.setLayoutParams(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r0 = "set gravity ok; "
            r9.<init>(r0)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9.append(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x00df:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r5 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r5]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 != 0) goto L_0x00eb
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x00eb:
            java.lang.String r1 = r9.getControlId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r5 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r6 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r5 = r5[r6]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r5 = r5.get(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r5 != 0) goto L_0x00ff
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x00ff:
            int[] r5 = com.cyjh.mobileanjian.ipc.ui.i.AnonymousClass3.f2642b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r6 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r7 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r6 = r6[r7]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r6 = r6.get(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r6 = (com.cyjh.mobileanjian.ipc.ui.m) r6     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r6 = r6.ordinal()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r5 = r5[r6]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            switch(r5) {
                case 1: goto L_0x0150;
                case 2: goto L_0x0150;
                case 3: goto L_0x0150;
                case 4: goto L_0x013f;
                case 5: goto L_0x011a;
                default: goto L_0x0116;
            }     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x0116:
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x011a:
            com.cyjh.mobileanjian.ipc.ui.k[] r5 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r5[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r0 = r0.b((java.lang.String) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.RadioGroup r0 = (android.widget.RadioGroup) r0     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = r9.getItemIndex()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r9 = r0.findViewById(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.RadioButton r9 = (android.widget.RadioButton) r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 != 0) goto L_0x0136
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0136:
            android.text.TextPaint r9 = r9.getPaint()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x013a:
            int r9 = r9.getColor()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0161
        L_0x013f:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r9 = r9.b((java.lang.String) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.CheckBox r9 = (android.widget.CheckBox) r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.text.TextPaint r9 = r9.getPaint()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x013a
        L_0x0150:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r9 = r9.b((java.lang.String) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.TextView r9 = (android.widget.TextView) r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.text.TextPaint r9 = r9.getPaint()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x013a
        L_0x0161:
            java.lang.String r0 = "%02X%02X%02X"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r5 = android.graphics.Color.blue(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r3[r4] = r5     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r4 = android.graphics.Color.green(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r3[r8] = r4     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = android.graphics.Color.red(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r3[r2] = r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = java.lang.String.format(r0, r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.newBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = r0.setControlId(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.STRING     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = r0.setType(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r0.setStringValue(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar r9 = r9.build()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.RSP_MSG     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r9 = r0.addVarTable((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r9 = r9.build()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.google.protobuf.ByteString r9 = r9.toByteString()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.event.c.a(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x01bb:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r1 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r1]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 != 0) goto L_0x01c7
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x01c7:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r9 = r9.b((java.lang.String) r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 != 0) goto L_0x01d7
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x01d7:
            int r9 = r9.getVisibility()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 == 0) goto L_0x01e4
            r0 = 4
            if (r9 == r0) goto L_0x01e7
            r0 = 8
            if (r9 == r0) goto L_0x01e6
        L_0x01e4:
            r2 = 1
            goto L_0x01e7
        L_0x01e6:
            r2 = 3
        L_0x01e7:
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.newBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r9.setControlId(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.INT     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r9.setType(r0)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r9.setIntValue(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar r9 = r9.build()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.RSP_MSG     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r9 = r0.addVarTable((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r9 = r9.build()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.google.protobuf.ByteString r9 = r9.toByteString()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.event.c.a(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x021b:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r1 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r1]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 != 0) goto L_0x0227
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0227:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r1 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r1]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r9 = r9.b((java.lang.String) r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 != 0) goto L_0x0237
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0237:
            boolean r1 = r9.isEnabled()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r2 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r2[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.EDIT_TEXT     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r0 != r2) goto L_0x024f
            android.widget.EditText r9 = (android.widget.EditText) r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            boolean r1 = r9.isFocusable()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x024f:
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.newBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r9.setControlId(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.BOOL     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r9.setType(r0)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r9.setBoolValue(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar r9 = r9.build()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.RSP_MSG     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r9 = r0.addVarTable((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r9 = r9.build()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.google.protobuf.ByteString r9 = r9.toByteString()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.event.c.a(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0283:
            r0.e((java.lang.String) r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0287:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 != 0) goto L_0x0293
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0293:
            java.lang.String r1 = r9.getControlId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r2 = r2.b((java.lang.String) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r2 != 0) goto L_0x02a7
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x02a7:
            java.lang.String r9 = r9.getColor()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r3 = "^#*([0-9A-Fa-f]{6})|([0-9A-Fa-f]{3})"
            boolean r3 = r9.matches(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r3 != 0) goto L_0x02be
            int r9 = com.cyjh.mqsdk.R.string.ui_show_invalid_color_value     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a((int) r9, (java.lang.Object[]) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x02be:
            java.lang.String r3 = "#"
            boolean r3 = r9.startsWith(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r3 != 0) goto L_0x02d4
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r4 = "#"
            r3.<init>(r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r3.append(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r3.toString()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x02d4:
            int r9 = android.graphics.Color.parseColor(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = com.cyjh.mobileanjian.ipc.utils.c.a(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r3 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r4 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r3 = r3[r4]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r4 = com.cyjh.mobileanjian.ipc.ui.m.BUTTON     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r3 != r4) goto L_0x030b
            android.graphics.drawable.GradientDrawable r1 = new android.graphics.drawable.GradientDrawable     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.setColor(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = r0.b()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            float r9 = (float) r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.setCornerRadius(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = 16
            if (r9 < r0) goto L_0x0304
            r2.setBackground(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0307
        L_0x0304:
            r2.setBackgroundDrawable(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x0307:
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x030b:
            java.util.HashMap[] r3 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r3[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r1 = com.cyjh.mobileanjian.ipc.ui.m.SPINNER     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r0 == r1) goto L_0x031c
            r2.setBackgroundColor(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x031c:
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0320:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 != 0) goto L_0x032c
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x032c:
            java.lang.String r1 = r9.getControlId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r2 = r9.getColor()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r3 = "^#*([0-9A-Fa-f]{6})|([0-9A-Fa-f]{3})"
            boolean r3 = r2.matches(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r3 != 0) goto L_0x0347
            int r9 = com.cyjh.mqsdk.R.string.ui_show_invalid_color_value     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a((int) r9, (java.lang.Object[]) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0347:
            java.lang.String r3 = "#"
            boolean r3 = r2.startsWith(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r3 != 0) goto L_0x035d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r5 = "#"
            r3.<init>(r5)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r3.append(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r2 = r3.toString()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x035d:
            int r2 = android.graphics.Color.parseColor(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = com.cyjh.mobileanjian.ipc.utils.c.a(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r3 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r3 == 0) goto L_0x0381
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.intValue()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9.a((int) r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x03dd
        L_0x0381:
            com.cyjh.mobileanjian.ipc.ui.k[] r3 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r5 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r3 = r3[r5]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r3 = r3.b((java.lang.String) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r3 != 0) goto L_0x0391
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0391:
            int[] r5 = com.cyjh.mobileanjian.ipc.ui.i.AnonymousClass3.f2642b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r6 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r6[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r0 = (com.cyjh.mobileanjian.ipc.ui.m) r0     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.ordinal()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r5[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            switch(r0) {
                case 1: goto L_0x03d8;
                case 2: goto L_0x03d8;
                case 3: goto L_0x03d8;
                case 4: goto L_0x03d2;
                case 5: goto L_0x03bc;
                case 6: goto L_0x03ac;
                default: goto L_0x03a8;
            }     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x03a8:
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x03ac:
            android.widget.Spinner r3 = (android.widget.Spinner) r3     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = r9.getItemIndex()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r3.getCount()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 < r0) goto L_0x03dd
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x03bc:
            android.widget.RadioGroup r3 = (android.widget.RadioGroup) r3     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = r9.getItemIndex()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r9 = r3.findViewById(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.RadioButton r9 = (android.widget.RadioButton) r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 != 0) goto L_0x03ce
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x03ce:
            r9.setTextColor(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x03dd
        L_0x03d2:
            android.widget.CheckBox r3 = (android.widget.CheckBox) r3     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r3.setTextColor(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x03dd
        L_0x03d8:
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r3.setTextColor(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x03dd:
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x03e1:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 != 0) goto L_0x03ed
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x03ed:
            java.lang.String r1 = r9.getControlId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r2 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r2 != 0) goto L_0x0401
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0401:
            int[] r2 = com.cyjh.mobileanjian.ipc.ui.i.AnonymousClass3.f2642b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r3 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r5 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r3 = r3[r5]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r3 = (com.cyjh.mobileanjian.ipc.ui.m) r3     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r3.ordinal()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            switch(r2) {
                case 1: goto L_0x0489;
                case 2: goto L_0x0489;
                case 3: goto L_0x0489;
                case 4: goto L_0x0478;
                case 5: goto L_0x0453;
                case 6: goto L_0x041c;
                default: goto L_0x0418;
            }     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x0418:
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x041c:
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r2[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r0 = r0.b((java.lang.String) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.Spinner r0 = (android.widget.Spinner) r0     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r9.getItemIndex()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.getCount()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r2 < r3) goto L_0x0436
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0436:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r3 = "Spinner Get pos: "
            r2.<init>(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r9.getItemIndex()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r3 = r0.getItemAtPosition(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.append(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = r9.getItemIndex()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r9 = r0.getItemAtPosition(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x049a
        L_0x0453:
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r2[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r0 = r0.b((java.lang.String) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.RadioGroup r0 = (android.widget.RadioGroup) r0     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = r9.getItemIndex()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r9 = r0.findViewById(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.RadioButton r9 = (android.widget.RadioButton) r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 != 0) goto L_0x046f
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x046f:
            java.lang.CharSequence r9 = r9.getText()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x0473:
            java.lang.String r9 = r9.toString()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x049a
        L_0x0478:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r9 = r9.b((java.lang.String) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.CheckBox r9 = (android.widget.CheckBox) r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.CharSequence r9 = r9.getText()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0473
        L_0x0489:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r9 = r9.b((java.lang.String) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.TextView r9 = (android.widget.TextView) r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.CharSequence r9 = r9.getText()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0473
        L_0x049a:
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.newBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = r0.setControlId(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.STRING     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = r0.setType(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r0.setStringValue(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar r9 = r9.build()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.RSP_MSG     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r9 = r0.addVarTable((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r9 = r9.build()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.google.protobuf.ByteString r9 = r9.toByteString()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.event.c.a(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x04ce:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 != 0) goto L_0x04da
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x04da:
            java.lang.String r1 = r9.getControlId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9.getText()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r2 = r2.b((java.lang.String) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r2 != 0) goto L_0x04f1
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x04f1:
            java.util.HashMap[] r3 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r3[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r1 = com.cyjh.mobileanjian.ipc.ui.m.EDIT_TEXT     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r0 == r1) goto L_0x0503
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0503:
            android.widget.EditText r2 = (android.widget.EditText) r2     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = r9.getEditInputType()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.setInputType(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0510:
            r0.b((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.CommandToUi) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0514:
            r0.c((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.CommandToUi) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0518:
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r9 = r9.get(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 == 0) goto L_0x0525
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x0525:
            java.util.HashMap[] r9 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r1 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r1]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r9 = r9.get(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 != 0) goto L_0x0536
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x0536:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.View r9 = r9.b((java.lang.String) r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.view.ViewGroup$LayoutParams r0 = r9.getLayoutParams()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = -1
            r0.width = r1     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9.setLayoutParams(r0)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x054e:
            boolean r8 = r0.a((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.CommandToUi) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x0554:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 == 0) goto L_0x0985
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.a()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r2 = r9.getControlId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r3 = r9.getParentId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r9.getText()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            boolean r8 = r1.a((int) r0, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x0578:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 == 0) goto L_0x0985
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r1[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r1 = r9.getControlId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = r9.getHeight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a((java.lang.String) r1, (int) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x0593:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 == 0) goto L_0x0985
            com.cyjh.mobileanjian.ipc.ui.g r1 = r0.f2636c     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.List r2 = r9.getItemTextList()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r9.getDefaultItemIndex()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9.getWidth()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9.getHeight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.Spinner r1 = r1.a((java.lang.String) r7, (java.util.List<java.lang.String>) r2, (int) r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r2 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.SPINNER     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.put(r7, r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r9.getParentId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.a((android.view.View) r1, (java.lang.String) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.setOnItemSelectedListener(r0)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x05cf:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 == 0) goto L_0x0985
            com.cyjh.mobileanjian.ipc.ui.g r1 = r0.f2636c     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r9.getWidth()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r9.getHeight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r4 = r9.getUrl()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.webkit.WebView r1 = r1.a((java.lang.String) r7, (int) r2, (int) r3, (java.lang.String) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r2 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.WEB_VIEW     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.put(r7, r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r2[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r9.getParentId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x0601:
            r0.a((android.view.View) r1, (java.lang.String) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x0606:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 == 0) goto L_0x0985
            com.cyjh.mobileanjian.ipc.ui.g r1 = r0.f2636c     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.a()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r4 = r9.getWidth()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r5 = r9.getHeight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r6 = r9.getPath()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r3 = r7
            android.widget.ImageView r1 = r1.a((int) r2, (java.lang.String) r3, (int) r4, (int) r5, (java.lang.String) r6)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r2 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.IMAGE_VIEW     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.put(r7, r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.setOnClickListener(r0)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r2[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r9.getParentId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0601
        L_0x063e:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 == 0) goto L_0x0985
            com.cyjh.mobileanjian.ipc.ui.g r1 = r0.f2636c     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r3 = r9.getText()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r4 = r9.getWidth()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r5 = r9.getHeight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            boolean r6 = r9.getDefaultCheckStatus()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r7
            android.widget.CheckBox r1 = r1.a((java.lang.String) r2, (java.lang.String) r3, (int) r4, (int) r5, (boolean) r6)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r2 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.CHECK_BOX     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.put(r7, r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r2[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r9.getParentId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0601
        L_0x0676:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 == 0) goto L_0x0985
            com.cyjh.mobileanjian.ipc.ui.g r1 = r0.f2636c     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.List r3 = r9.getItemTextList()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r4 = r9.getDefaultItemIndex()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r5 = r9.getWidth()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r6 = r9.getHeight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r7
            android.widget.RadioGroup r1 = r1.a((java.lang.String) r2, (java.util.List<java.lang.String>) r3, (int) r4, (int) r5, (int) r6)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r2 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.RADIIO_GROUP     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.put(r7, r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r2[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r9.getParentId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0601
        L_0x06af:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 == 0) goto L_0x0985
            com.cyjh.mobileanjian.ipc.ui.g r1 = r0.f2636c     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r2 = r9.getText()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r9.getWidth()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r4 = r9.getHeight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.Button r1 = r1.b(r7, r2, r3, r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r2 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.BUTTON     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.put(r7, r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.setOnClickListener(r0)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r2[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r9.getParentId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0601
        L_0x06e6:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 == 0) goto L_0x0985
            com.cyjh.mobileanjian.ipc.ui.g r1 = r0.f2636c     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r2 = r9.getText()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r9.getWidth()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r4 = r9.getHeight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.EditText r1 = r1.d(r7, r2, r3, r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r2 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.EDIT_TEXT     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.put(r7, r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r9.getParentId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.a((android.view.View) r1, (java.lang.String) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i$a r9 = new com.cyjh.mobileanjian.ipc.ui.i$a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9.<init>(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.addTextChangedListener(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x0725:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 == 0) goto L_0x0985
            com.cyjh.mobileanjian.ipc.ui.g r1 = r0.f2636c     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r2 = r9.getText()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r9.getWidth()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r4 = r9.getHeight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.TextView r1 = r1.a((java.lang.String) r7, (java.lang.String) r2, (int) r3, (int) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r2 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.TEXT_VIEW     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.put(r7, r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r2[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r9.getParentId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0601
        L_0x0759:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 == 0) goto L_0x0985
            com.cyjh.mobileanjian.ipc.ui.g r1 = r0.f2636c     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r9.getWidth()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r9.getHeight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            android.widget.LinearLayout r1 = r1.b(r7, r2, r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r2 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2 = r2[r3]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.LINE     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.put(r7, r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r2[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r9.getParentId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0601
        L_0x0789:
            java.lang.String r1 = r9.getControlId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r9.getColor()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r2 != 0) goto L_0x07a6
            int r9 = com.cyjh.mqsdk.R.string.ui_show_not_found_ui     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2[r4] = r1     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a((int) r9, (java.lang.Object[]) r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x07a6:
            java.lang.String r2 = "^#*([0-9A-Fa-f]{6})|([0-9A-Fa-f]{3})"
            boolean r2 = r9.matches(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r2 != 0) goto L_0x07b9
            int r9 = com.cyjh.mqsdk.R.string.ui_show_invalid_color_value     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a((int) r9, (java.lang.Object[]) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x07b9:
            java.lang.String r2 = "#"
            boolean r2 = r9.startsWith(r2)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r2 != 0) goto L_0x07cf
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r3 = "#"
            r2.<init>(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.append(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r2.toString()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x07cf:
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r1 = r1.intValue()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = android.graphics.Color.parseColor(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = com.cyjh.mobileanjian.ipc.utils.c.a(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r0[r1]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.b((int) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x07ee:
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r9 = r9.get(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 != 0) goto L_0x0803
            int r9 = com.cyjh.mqsdk.R.string.ui_show_not_found_ui     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object[] r1 = new java.lang.Object[r8]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1[r4] = r7     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a((int) r9, (java.lang.Object[]) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x0803:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.intValue()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r9 = r9.a()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.newBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = r0.setControlId(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.STRING     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = r0.setType(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r0.setStringValue(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar r9 = r9.build()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.RSP_MSG     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r9 = r0.addVarTable((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r9 = r9.build()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.google.protobuf.ByteString r9 = r9.toByteString()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.event.c.a(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x084b:
            java.lang.String r9 = r9.getText()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r1 = r1.get(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 != 0) goto L_0x0863
            int r9 = com.cyjh.mqsdk.R.string.ui_show_not_found_ui     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object[] r1 = new java.lang.Object[r8]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1[r4] = r7     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a((int) r9, (java.lang.Object[]) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r8 = 0
            goto L_0x0985
        L_0x0863:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.intValue()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0 = r1[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a((java.lang.String) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x0878:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r1 == 0) goto L_0x0985
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1 = r1[r2]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.String r0 = r9.getParentId()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r9.getWidth()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = r9.getHeight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.a((java.lang.String) r7, (java.lang.String) r0, (int) r2, (int) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x089a:
            r0.c()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x089f:
            boolean r8 = r0.d((java.lang.String) r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x08a5:
            com.cyjh.mobileanjian.ipc.ui.i.c((java.lang.String) r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x08aa:
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r9 = r9.get(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 != 0) goto L_0x08bf
            int r9 = com.cyjh.mqsdk.R.string.ui_show_not_found_ui     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object[] r1 = new java.lang.Object[r8]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1[r4] = r7     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r0.a((int) r9, (java.lang.Object[]) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x08bf:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r1 = r1.get(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r1 = r1.intValue()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r1]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            boolean r9 = r9.f2658c     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            if (r9 == 0) goto L_0x08d7
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x08d7:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r0 = r0.intValue()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r0]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9.c()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Builder r9 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlEvent.newBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Builder r9 = r9.setControlId(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Event_Type r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlEvent.Event_Type.ON_SHOW     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Builder r9 = r9.setType(r0)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent r9 = r9.build()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.EVENT     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r9 = r0.setEvent((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlEvent) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r9 = r9.build()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.google.protobuf.ByteString r9 = r9.toByteString()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.event.c.b(r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            return
        L_0x091d:
            int r1 = r9.getWidth()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r9 = r9.getHeight()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r2 = r2 + r8
            r0.f2635b = r2     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r3 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.g r4 = r0.f2636c     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k r9 = r4.a((java.lang.String) r7, (int) r1, (int) r9)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2[r3] = r9     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r0.d     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r1 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9.put(r7, r1)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap[] r9 = r0.e     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r1 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r2.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9[r1] = r2     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r1 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r1]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i$1 r1 = new com.cyjh.mobileanjian.ipc.ui.i$1     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.<init>(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9.f2657b = r1     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r0.f2634a     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            int r1 = r0.f2635b     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9 = r9[r1]     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            com.cyjh.mobileanjian.ipc.ui.i$2 r1 = new com.cyjh.mobileanjian.ipc.ui.i$2     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r1.<init>(r7)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            r9.f2656a = r1     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x0967:
            java.lang.String r9 = r9.getPath()     // Catch:{ IOException -> 0x0974, JSONException -> 0x096f }
            r0.b((java.lang.String) r9)     // Catch:{ IOException -> 0x0974, JSONException -> 0x096f }
            goto L_0x0985
        L_0x096f:
            r9 = move-exception
        L_0x0970:
            r9.printStackTrace()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x0974:
            r9 = move-exception
        L_0x0975:
            r9.printStackTrace()     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
            goto L_0x0985
        L_0x0979:
            java.lang.String r9 = r9.getPath()     // Catch:{ JSONException -> 0x0983, IOException -> 0x0981 }
            r0.a((java.lang.String) r9)     // Catch:{ JSONException -> 0x0983, IOException -> 0x0981 }
            goto L_0x0985
        L_0x0981:
            r9 = move-exception
            goto L_0x0975
        L_0x0983:
            r9 = move-exception
            goto L_0x0970
        L_0x0985:
            com.cyjh.mobileanjian.ipc.ui.i.a((boolean) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0989 }
        L_0x0988:
            return
        L_0x0989:
            r9 = move-exception
            r9.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.event.Injector.b(byte[]):void");
    }

    private static int c(int i2) {
        for (int i3 = 0; i3 < 5; i3++) {
            if (!y[i3].f2352a && y[i3].f2353b == i2) {
                return i3;
            }
        }
        return -1;
    }

    private static void c() {
        OnScriptListener onScriptListener = MqRunnerLite.getInstance().f2788a;
        if (onScriptListener != null) {
            onScriptListener.onResume();
        }
    }

    private static int d(int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (!y[i4].f2352a) {
                i3++;
            }
        }
        return i3;
    }

    private static void d() {
        OnScriptListener onScriptListener = MqRunnerLite.getInstance().f2788a;
        if (onScriptListener != null) {
            onScriptListener.onPause();
        }
    }

    static /* synthetic */ void d(b bVar) {
        OnScriptListener onScriptListener = MqRunnerLite.getInstance().f2788a;
        if (onScriptListener != null) {
            onScriptListener.onUpdateControlBarPos(bVar.e, bVar.f2365a, bVar.f2366b);
        }
    }

    public static void dispatchGestureMoveAB(String str) {
        int i2;
        Exception e2;
        Path path = new Path();
        try {
            JSONObject jSONObject = new JSONObject(str);
            i2 = jSONObject.getInt("duration");
            try {
                if (jSONObject.get("points") instanceof JSONArray) {
                    JSONArray jSONArray = jSONObject.getJSONArray("points");
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        int intValue = ((Integer) jSONArray.getJSONObject(i3).get("x")).intValue();
                        int intValue2 = ((Integer) jSONArray.getJSONObject(i3).get("y")).intValue();
                        if (i3 == 0) {
                            path.moveTo((float) intValue, (float) intValue2);
                        } else {
                            path.lineTo((float) intValue, (float) intValue2);
                        }
                        StringBuilder sb = new StringBuilder("x:");
                        sb.append(intValue);
                        sb.append("y:");
                        sb.append(intValue2);
                    }
                }
            } catch (Exception e3) {
                e2 = e3;
                new StringBuilder("dispatchGestureMove: Exception:").append(e2.toString());
                e2.printStackTrace();
                Cservice.f2360a.a(path, (long) i2);
            }
        } catch (Exception e4) {
            e2 = e4;
            i2 = 0;
            new StringBuilder("dispatchGestureMove: Exception:").append(e2.toString());
            e2.printStackTrace();
            Cservice.f2360a.a(path, (long) i2);
        }
        Cservice.f2360a.a(path, (long) i2);
    }

    private static Instrumentation e() {
        if (f2350b == null) {
            f2350b = new Instrumentation();
        }
        return f2350b;
    }

    static /* synthetic */ void e(b bVar) {
        OnScriptListener onScriptListener = MqRunnerLite.getInstance().f2788a;
        if (onScriptListener != null) {
            onScriptListener.onSetControlBarVisiable(bVar.f2365a);
        }
    }

    private static void f() {
        if (y == null) {
            y = new a[5];
            for (int i2 = 0; i2 < 5; i2++) {
                a aVar = new a((byte) 0);
                aVar.f2352a = true;
                aVar.f2353b = 0;
                aVar.f2354c = 0.0f;
                aVar.d = 0.0f;
                y[i2] = aVar;
            }
        }
    }

    private static void f(b bVar) {
        if (d == null) {
            d = new ExToast(f2351c);
        }
        d.show(bVar.d, bVar.f2365a, bVar.f2366b, bVar.f2367c);
    }

    private static int g() {
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            if (!y[i3].f2352a) {
                i2++;
            }
        }
        return i2;
    }

    private static void g(b bVar) {
        new com.cyjh.mobileanjian.ipc.ui.b(f2351c, bVar.d, bVar.f2365a, new b.a() {
            public final void a(int i) {
                Injector.setSyncReturnValue(i, "");
            }
        }).a();
    }

    private static void h() {
        int g2 = g();
        if (g2 != 0) {
            z = new MotionEvent.PointerProperties[g2];
            A = new MotionEvent.PointerCoords[g2];
            int i2 = 0;
            for (int i3 = 0; i3 < 5; i3++) {
                if (!y[i3].f2352a) {
                    if (i2 < g2) {
                        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
                        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
                        pointerProperties.id = i3;
                        pointerCoords.x = y[i3].f2354c;
                        pointerCoords.y = y[i3].d;
                        pointerCoords.orientation = GetTapRotation();
                        z[i2] = pointerProperties;
                        A[i2] = pointerCoords;
                    }
                    i2++;
                }
            }
        }
    }

    private static void h(b bVar) {
        new c(f2351c, bVar.d, new c.a() {
            public final void a(String str) {
                Injector.setSyncReturnValue(0, str);
            }
        }).a();
    }

    private static void i(b bVar) {
        OnScriptListener onScriptListener = MqRunnerLite.getInstance().f2788a;
        if (onScriptListener != null) {
            onScriptListener.onUpdateControlBarPos(bVar.e, bVar.f2365a, bVar.f2366b);
        }
    }

    public static void init(Context context) {
        if (context == null) {
            throw new NullPointerException("Context is null...");
        }
        f2351c = context.getApplicationContext();
        e = new com.cyjh.mobileanjian.ipc.a(f2351c);
        f = new i(f2351c);
        h = initTessBass();
    }

    public static boolean initTessBass() {
        File file = new File(f2351c.getFilesDir().getAbsolutePath() + "/tessdata/", com.cyjh.common.b.a.aQ);
        File file2 = new File(f2351c.getFilesDir().getAbsolutePath() + "/tessdata/", com.cyjh.common.b.a.aP);
        if (!file.exists() || !file2.exists()) {
            return false;
        }
        g = new TessBaseAPI();
        boolean a2 = g.a(f2351c.getFilesDir().getAbsolutePath(), "chi_sim+eng");
        Log.i("MqmHandler", "initTessBass: init ret=" + a2);
        return a2;
    }

    private static void j(b bVar) {
        OnScriptListener onScriptListener = MqRunnerLite.getInstance().f2788a;
        if (onScriptListener != null) {
            onScriptListener.onSetControlBarVisiable(bVar.f2365a);
        }
    }

    public static void release() {
        com.cyjh.mobileanjian.ipc.a.f();
        e.a();
        i iVar = f;
        iVar.c();
        iVar.f2635b = 0;
        iVar.f = 1;
        for (int i2 = 0; i2 < 32; i2++) {
            iVar.f2634a[i2] = null;
            if (iVar.e[i2] != null) {
                iVar.e[i2].clear();
            }
        }
        releasePointerInfoArray();
    }

    public static void releasePointerInfoArray() {
        y = null;
    }

    public static void sendText(String str, int i2) {
        if (i) {
            sendTextAB(str);
        } else if (MqRunnerLite.getInstance().e != null) {
            MqRunnerLite.getInstance().e.inputText(str);
        }
    }

    public static void sendTextAB(String str) {
        if (Cservice.a()) {
            Cservice.f2360a.a(str, f2351c);
        }
    }

    public static void setSyncReturnValue(int i2, String str) {
        p = i2;
        q = str;
        o = true;
    }

    public static void switchToIm(String str) {
    }
}
