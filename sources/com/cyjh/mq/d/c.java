package com.cyjh.mq.d;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import com.cyjh.mq.d.f;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2778a = "ModifyCaptureModeHelper";

    private static String a() {
        return Build.VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS[0] : Build.CPU_ABI;
    }

    public static void a(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            b(context, "x86");
            b(context, "x86_64");
            return;
        }
        String str = "injectModifyCaptureMode/LowerThanAndroid9/" + "x86" + "/";
        a(context, str + "inject7", "data/local/tmp/a");
        a(context, str + "libzygote.so", "data/local/tmp/c");
        a(context, str + "libyafa.so", "data/local/tmp/libyafa.so");
        a(context, "injectModifyCaptureMode/LowerThanAndroid9/hookzygote.apk", "data/local/tmp/hookzygote.apk");
        ArrayList arrayList = new ArrayList();
        arrayList.add("mkdir -p /data/local/plugs/");
        arrayList.add("cp -r /sdcard/data/local/tmp/* /data/local/tmp/");
        arrayList.add("chmod 777 /data/local/tmp/*");
        arrayList.add("/data/local/tmp/a zygote /data/local/tmp/c c d d");
        f.a a2 = f.a((List<String>) arrayList);
        Log.i(f2778a, "/data/local/tmp/a zygote /data/local/tmp/c c d d result=" + a2.f2783b);
    }

    private static void a(Context context, String str) {
        String str2 = "injectModifyCaptureMode/LowerThanAndroid9/" + str + "/";
        a(context, str2 + "inject7", "data/local/tmp/a");
        a(context, str2 + "libzygote.so", "data/local/tmp/c");
        a(context, str2 + "libyafa.so", "data/local/tmp/libyafa.so");
        a(context, "injectModifyCaptureMode/LowerThanAndroid9/hookzygote.apk", "data/local/tmp/hookzygote.apk");
        ArrayList arrayList = new ArrayList();
        arrayList.add("mkdir -p /data/local/plugs/");
        arrayList.add("cp -r /sdcard/data/local/tmp/* /data/local/tmp/");
        arrayList.add("chmod 777 /data/local/tmp/*");
        arrayList.add("/data/local/tmp/a zygote /data/local/tmp/c c d d");
        f.a a2 = f.a((List<String>) arrayList);
        Log.i(f2778a, "/data/local/tmp/a zygote /data/local/tmp/c c d d result=" + a2.f2783b);
    }

    private static void a(Context context, String str, String str2) {
        try {
            String[] list = context.getAssets().list(str);
            if (list.length > 0) {
                File file = new File(Environment.getExternalStorageDirectory(), str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                for (String str3 : list) {
                    if (!str.equals("")) {
                        a(context, str + File.separator + str3, str2 + File.separator + str3);
                    } else {
                        a(context, str3, str2 + File.separator + str3);
                    }
                }
                return;
            }
            File file2 = new File(Environment.getExternalStorageDirectory(), str2);
            InputStream open = context.getAssets().open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    open.close();
                    fileOutputStream.close();
                    Log.i(f2778a, "copy success srcPath " + str + " dstPath =" + str2);
                    return;
                }
            }
        } catch (Exception e) {
            Log.i(f2778a, "copy fail srcPath =" + str + " dstPath =" + str2);
            e.printStackTrace();
        }
    }

    private static void b(Context context, String str) {
        String str2 = "injectModifyCaptureMode/HigherThanAndroid9/" + str + "/";
        a(context, str2 + "inject9", "data/local/tmp/inject9");
        a(context, str2 + "libzygote.so", "data/local/tmp/libzygote.so");
        a(context, str2 + "libyafa.so", "data/local/tmp/libyafa.so");
        a(context, "injectModifyCaptureMode/HigherThanAndroid9/hookzygote.apk", "data/local/tmp/hookzygote.apk");
        ArrayList arrayList = new ArrayList();
        arrayList.add("mkdir -p /data/local/plugs/");
        arrayList.add("cp -r /sdcard/data/local/tmp/* /data/local/tmp/");
        arrayList.add("chmod 777 /data/local/tmp/*");
        arrayList.add("/data/local/tmp/inject9 --libpath /data/local/tmp/libzygote.so");
        f.a a2 = f.a((List<String>) arrayList);
        Log.i(f2778a, "/data/local/tmp/inject9 --libpath /data/local/tmp/libzygote.so result=" + a2.f2783b);
    }
}
