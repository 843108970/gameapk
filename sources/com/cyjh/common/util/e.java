package com.cyjh.common.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.cyjh.common.b.a;
import com.google.a.c.l;
import com.lidroid.xutils.util.CharsetUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1669a = "e";

    /* renamed from: b  reason: collision with root package name */
    private static int f1670b = 1000;

    public static File a(String str, String str2) {
        File file = null;
        try {
            File file2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(file2, str2);
            try {
                if (file3.exists()) {
                    return file3;
                }
                file3.createNewFile();
                return file3;
            } catch (IOException e) {
                file = file3;
                e = e;
                e.printStackTrace();
                return file;
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            return file;
        }
    }

    public static String a() {
        return n.b(a(a.aF, a.aN));
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0040 A[SYNTHETIC, Splitter:B:20:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004d A[SYNTHETIC, Splitter:B:29:0x004d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(int r5) {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Throwable -> 0x0039, all -> 0x0037 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ Throwable -> 0x0039, all -> 0x0037 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0039, all -> 0x0037 }
            java.lang.String r4 = "/proc/"
            r3.<init>(r4)     // Catch:{ Throwable -> 0x0039, all -> 0x0037 }
            r3.append(r5)     // Catch:{ Throwable -> 0x0039, all -> 0x0037 }
            java.lang.String r5 = "/cmdline"
            r3.append(r5)     // Catch:{ Throwable -> 0x0039, all -> 0x0037 }
            java.lang.String r5 = r3.toString()     // Catch:{ Throwable -> 0x0039, all -> 0x0037 }
            r2.<init>(r5)     // Catch:{ Throwable -> 0x0039, all -> 0x0037 }
            r1.<init>(r2)     // Catch:{ Throwable -> 0x0039, all -> 0x0037 }
            java.lang.String r5 = r1.readLine()     // Catch:{ Throwable -> 0x0035 }
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Throwable -> 0x0035 }
            if (r2 != 0) goto L_0x002c
            java.lang.String r5 = r5.trim()     // Catch:{ Throwable -> 0x0035 }
        L_0x002c:
            r1.close()     // Catch:{ IOException -> 0x0030 }
            return r5
        L_0x0030:
            r0 = move-exception
            r0.printStackTrace()
            return r5
        L_0x0035:
            r5 = move-exception
            goto L_0x003b
        L_0x0037:
            r5 = move-exception
            goto L_0x004b
        L_0x0039:
            r5 = move-exception
            r1 = r0
        L_0x003b:
            r5.printStackTrace()     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x0048
            r1.close()     // Catch:{ IOException -> 0x0044 }
            return r0
        L_0x0044:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0048:
            return r0
        L_0x0049:
            r5 = move-exception
            r0 = r1
        L_0x004b:
            if (r0 == 0) goto L_0x0055
            r0.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0055:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.common.util.e.a(int):java.lang.String");
    }

    public static String a(Context context) {
        String str = null;
        try {
            File i = i(context);
            if (i.exists()) {
                str = a(i);
            }
            if (str == null) {
                String str2 = Build.BRAND + UUID.randomUUID().toString().substring(0, 8);
                try {
                    a(i, str2, false);
                    return str2;
                } catch (Exception e) {
                    e = e;
                    str = str2;
                    e.printStackTrace();
                    return str;
                }
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return str;
        }
        return str;
    }

    private static String a(File file) {
        try {
            ArrayList arrayList = new ArrayList();
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList.add(readLine);
            }
            fileInputStream.close();
            if (arrayList.size() > 0) {
                return (String) arrayList.get(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String a(String str) {
        try {
            if (str.equals(new String(str.getBytes(l.f3087b), l.f3087b))) {
                return l.f3087b;
            }
        } catch (Exception unused) {
        }
        try {
            if (str.equals(new String(str.getBytes(CharsetUtils.DEFAULT_ENCODING_CHARSET), CharsetUtils.DEFAULT_ENCODING_CHARSET))) {
                return CharsetUtils.DEFAULT_ENCODING_CHARSET;
            }
        } catch (Exception unused2) {
        }
        try {
            if (str.equals(new String(str.getBytes("UTF-8"), "UTF-8"))) {
                return "UTF-8";
            }
        } catch (Exception unused3) {
        }
        try {
            return str.equals(new String(str.getBytes("GBK"), "GBK")) ? "GBK" : "";
        } catch (Exception unused4) {
            return "";
        }
    }

    public static List<String> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    arrayList.add((String) jSONArray.get(i));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    private static void a(Activity activity, int i) {
        BitmapFactory.decodeResource(activity.getResources(), i);
        activity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
    }

    public static void a(Context context, boolean z) {
        boolean z2;
        String packageName = context.getPackageName();
        String a2 = a();
        Log.i("jason", "operateElfinPackageNames --> isAdd=" + z + ",elfinFreePackageNames=" + a2);
        if (!z) {
            String str = "," + packageName;
            String str2 = packageName + ",";
            if (!TextUtils.isEmpty(a2)) {
                if (a2.contains(str)) {
                    a2 = a2.replace(str, "");
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (a2.contains(str2)) {
                    a2 = a2.replace(str2, "");
                    z2 = true;
                }
                if (a2.contains(packageName)) {
                    a2 = a2.replace(packageName, "");
                    z2 = true;
                }
                if (z2) {
                    Log.i("jason", "operateElfinPackageNames --> hasReplace=true, result=" + a2);
                    a(a2, false);
                }
            }
        } else if (TextUtils.isEmpty(a2)) {
            a(packageName, true);
        } else if (!a2.contains(packageName)) {
            a("," + packageName, true);
        }
    }

    private static void a(File file, String str, boolean z) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            try {
                FileWriter fileWriter = new FileWriter(file, z);
                fileWriter.write(str);
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(String str, boolean z) {
        File a2 = a(a.aF, a.aN);
        if (z) {
            n.b(a2, str, "UTF-8");
        } else {
            n.a(a2, str, "UTF-8");
        }
    }

    public static boolean a(Context context, String str) {
        try {
            a(i(context), str, false);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            InputStream open = context.getAssets().open(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    open.close();
                    fileOutputStream.close();
                    return true;
                }
            }
        } catch (Exception e) {
            String str3 = f1669a;
            ad.c(str3, "copyAssetsFile --> e =" + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    private static boolean a(Bitmap bitmap, String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static File b(Context context) {
        return e() ? new File(Environment.getExternalStorageDirectory(), ".elfinError") : new File(context.getFilesDir(), ".elfinError");
    }

    public static String b() {
        String str;
        String a2 = com.cyjh.common.a.a.a();
        String b2 = af.a().b();
        if (!TextUtils.isEmpty(b2)) {
            try {
                if (Long.valueOf(Long.parseLong(b2)).longValue() >= Long.valueOf(Long.parseLong(a2)).longValue()) {
                    str = b2;
                    ad.b("saveVersion ", "ownVersion:" + a2 + " saveVersion:" + b2 + "  get appVersion:" + str);
                    return str;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        str = a2;
        ad.b("saveVersion ", "ownVersion:" + a2 + " saveVersion:" + b2 + "  get appVersion:" + str);
        return str;
    }

    private static String b(String str) {
        return str == null ? "" : str;
    }

    private static String b(String str, String str2) {
        if (TextUtils.isEmpty((CharSequence) null)) {
            str2 = "UTF-8";
        }
        try {
            return Base64.encodeToString(str.getBytes(str2), 2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static void b(File file, String str, boolean z) {
        try {
            FileWriter fileWriter = new FileWriter(file, z);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Point c(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    private static String c() {
        return UUID.randomUUID().toString();
    }

    private static String c(String str) {
        return b(str, (String) null);
    }

    private static String c(String str, String str2) {
        if (TextUtils.isEmpty((CharSequence) null)) {
            str2 = "UTF-8";
        }
        try {
            return new String(Base64.decode(str, 2), str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String d() {
        return Build.VERSION.RELEASE;
    }

    private static String d(String str) {
        return c(str, (String) null);
    }

    private static boolean d(Context context) {
        try {
            File file = e() ? new File(Environment.getExternalStorageDirectory(), ".userMark") : new File(context.getFilesDir(), ".userMark");
            if (file.exists()) {
                return false;
            }
            file.createNewFile();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static File e(Context context) {
        return e() ? new File(Environment.getExternalStorageDirectory(), ".userMark") : new File(context.getFilesDir(), ".userMark");
    }

    private static String e(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i != charArray.length - 1) {
                stringBuffer.append(charArray[i]);
                stringBuffer.append(",");
            } else {
                stringBuffer.append(charArray[i]);
            }
        }
        return stringBuffer.toString();
    }

    private static boolean e() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    private static boolean f(Context context) {
        try {
            File file = new File(context.getFilesDir(), ".stopScriptTips");
            if (file.exists()) {
                return false;
            }
            file.createNewFile();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    private static File g(Context context) {
        return e() ? new File(Environment.getExternalStorageDirectory(), ".deviceInfo") : new File(context.getFilesDir(), ".deviceInfo");
    }

    private static String h(Context context) {
        String str = null;
        try {
            File file = e() ? new File(Environment.getExternalStorageDirectory(), ".deviceInfo") : new File(context.getFilesDir(), ".deviceInfo");
            if (file.exists()) {
                str = a(file);
            }
            if (str == null) {
                String uuid = UUID.randomUUID().toString();
                try {
                    a(file, uuid, true);
                    return uuid;
                } catch (Exception e) {
                    e = e;
                    str = uuid;
                    e.printStackTrace();
                    return str;
                }
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return str;
        }
        return str;
    }

    private static File i(Context context) {
        return e() ? new File(Environment.getExternalStorageDirectory(), ".elfinDevice") : new File(context.getFilesDir(), ".elfinDevice");
    }

    private static File j(Context context) {
        return e() ? new File(Environment.getExternalStorageDirectory(), "elfinParams.txt") : new File(context.getFilesDir(), "elfinParams.txt");
    }

    @RequiresApi(api = 21)
    private static MediaProjectionManager k(Context context) {
        MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) context.getSystemService("media_projection");
        ((Activity) context).startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), f1670b);
        return mediaProjectionManager;
    }

    private static int l(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    private static int m(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private static int n(Context context) {
        return (int) context.getResources().getDisplayMetrics().density;
    }
}
