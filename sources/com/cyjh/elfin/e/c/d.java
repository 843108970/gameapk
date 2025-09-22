package com.cyjh.elfin.e.c;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.hardware.SensorManager;
import android.os.Environment;
import android.text.TextUtils;
import com.umeng.commonsdk.proguard.v;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
    private static String a(Context context, String str) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
        if (packageArchiveInfo != null) {
            return packageArchiveInfo.packageName;
        }
        return null;
    }

    private static List<String> a(JSONArray jSONArray) {
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

    private static boolean a() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter == null || TextUtils.isEmpty(defaultAdapter.getName());
    }

    private static boolean a(Context context) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean z = defaultAdapter == null || TextUtils.isEmpty(defaultAdapter.getName());
        boolean booleanValue = (((SensorManager) context.getSystemService(v.W)).getDefaultSensor(5) == null).booleanValue();
        String c2 = c();
        return z || booleanValue || (c2.contains("intel") || c2.contains("amd"));
    }

    private static boolean a(String str, boolean z) {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return false;
        }
        try {
            File file = new File(Environment.getExternalStorageDirectory().getPath(), "elfinParams.txt");
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file, z);
            fileOutputStream.write(str.getBytes("UTF-8"));
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static Boolean b(Context context) {
        return Boolean.valueOf(((SensorManager) context.getSystemService(v.W)).getDefaultSensor(5) == null);
    }

    private static boolean b() {
        String c2 = c();
        return c2.contains("intel") || c2.contains("amd");
    }

    private static boolean b(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String c() {
        try {
            Process start = new ProcessBuilder(new String[]{"/system/bin/cat", "/proc/cpuinfo"}).start();
            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream(), "utf-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuffer.append(readLine);
                } else {
                    bufferedReader.close();
                    return stringBuffer.toString().toLowerCase();
                }
            }
        } catch (IOException unused) {
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        r2 = r0.getDeviceId();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String c(android.content.Context r2) {
        /*
            java.lang.String r0 = "phone"
            java.lang.Object r0 = r2.getSystemService(r0)     // Catch:{ Exception -> 0x001c }
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch:{ Exception -> 0x001c }
            java.lang.String r1 = "android.permission.READ_PHONE_STATE"
            int r2 = android.support.v4.app.ActivityCompat.checkSelfPermission(r2, r1)     // Catch:{ Exception -> 0x001c }
            if (r2 == 0) goto L_0x0013
            java.lang.String r2 = ""
            return r2
        L_0x0013:
            java.lang.String r2 = r0.getDeviceId()     // Catch:{ Exception -> 0x001c }
            if (r2 != 0) goto L_0x001b
            java.lang.String r2 = ""
        L_0x001b:
            return r2
        L_0x001c:
            r2 = move-exception
            r2.printStackTrace()
            java.lang.String r2 = ""
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.elfin.e.c.d.c(android.content.Context):java.lang.String");
    }

    private static boolean d() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    private static String e() {
        String str;
        Exception e;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://pv.sohu.com/cityjson?ie=utf-8").openConnection();
            if (httpURLConnection.getResponseCode() != 200) {
                return "0.0.0.0";
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            StringBuilder sb = new StringBuilder();
            while (true) {
                str = bufferedReader.readLine();
                if (str == null) {
                    break;
                }
                try {
                    sb.append(str + "\n");
                    String str2 = str;
                } catch (Exception e2) {
                    e = e2;
                }
            }
            inputStream.close();
            String substring = sb.substring(sb.indexOf("{"), sb.indexOf("}") + 1);
            if (substring != null) {
                try {
                    return new JSONObject(substring).optString("cip");
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            return str;
        } catch (Exception e4) {
            str = "0.0.0.0";
            e = e4;
            e.printStackTrace();
            return str;
        }
    }
}
