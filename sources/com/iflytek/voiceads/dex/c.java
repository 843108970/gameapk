package com.iflytek.voiceads.dex;

import android.content.Context;
import android.content.SharedPreferences;
import com.iflytek.voiceads.config.SDKLogger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class c {
    public static String a(Context context, String str) {
        String c2 = c(context, str);
        String d = d(context, str);
        String str2 = context.getFilesDir().getAbsolutePath() + File.separator;
        if (b(c2, str) > b(d, str)) {
            a(context, str2 + c2, c2);
        } else {
            c2 = d;
        }
        a(context, str2, str, c2);
        return c2;
    }

    private static String a(String[] strArr, String str) {
        int i = 0;
        if (strArr != null) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : strArr) {
                if (b(str2, str) > 0) {
                    arrayList.add(Integer.valueOf(b(str2, str)));
                }
            }
            if (arrayList.size() > 0) {
                Collections.sort(arrayList);
                i = ((Integer) arrayList.get(arrayList.size() - 1)).intValue();
            }
        }
        return "AdDex." + str + "." + i + ".dex";
    }

    private static void a(Context context, String str, String str2) {
        SDKLogger.d("copyDexFile");
        try {
            InputStream open = context.getAssets().open(str2);
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    open.close();
                    return;
                }
            }
        } catch (IOException e) {
            SDKLogger.e("copyDexFile:" + e.getMessage());
        }
    }

    private static void a(Context context, String str, String str2, String str3) {
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferences = context.getSharedPreferences("FLY_AD_SHARED", 0);
        if (currentTimeMillis - sharedPreferences.getLong("checkUpdateTime", 0) < 86400000) {
            SDKLogger.d("less than 24h");
            return;
        }
        sharedPreferences.edit().putLong("checkUpdateTime", currentTimeMillis).apply();
        new Thread(new d("https://api.voiceads.cn/hotUpdate/?ver=" + str2, str2, str3, str)).start();
    }

    /* access modifiers changed from: private */
    public static int b(String str, String str2) {
        if (!Pattern.matches("^AdDex." + str2 + "(\\.[0-9]{1,})\\.dex$", str)) {
            return -1;
        }
        return Integer.valueOf(str.split("\\.")[3]).intValue();
    }

    public static String b(Context context, String str) {
        for (File file : context.getFilesDir().listFiles()) {
            if (b(file.getName(), str) != -1) {
                SDKLogger.d("delete " + file.getName());
                file.delete();
            }
        }
        String c2 = c(context, str);
        String str2 = context.getFilesDir().getAbsolutePath() + File.separator;
        a(context, str2 + c2, c2);
        a(context, str2, str, c2);
        return c2;
    }

    /* access modifiers changed from: private */
    public static void b(String str, String str2, String str3) {
        new Thread(new e(str2, str3, str)).start();
    }

    private static String c(Context context, String str) {
        String[] strArr;
        try {
            strArr = context.getAssets().list("");
        } catch (IOException e) {
            e.printStackTrace();
            strArr = null;
        }
        return a(strArr, str);
    }

    private static String d(Context context, String str) {
        return a(new File(context.getFilesDir().getAbsolutePath() + File.separator).list(), str);
    }
}
