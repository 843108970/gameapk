package com.hlzn.socketclient.f;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3451a = "e";

    public static File a(Context context) {
        return a() ? new File(Environment.getExternalStorageDirectory(), ".elfinSocketError") : new File(context.getFilesDir(), ".elfinSocketError");
    }

    private static String a(long j) {
        return new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E", Locale.getDefault()).format(Long.valueOf(j));
    }

    private static boolean a() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(File file) {
        return file != null && file.length() > 1048576;
    }

    public static boolean a(File file, String str) {
        return a(file, new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis())) + "\n" + str + "\n\n", (String) null, true);
    }

    private static boolean a(File file, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = "UTF-8";
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), str2));
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(File file, String str, String str2, boolean z) {
        try {
            if (TextUtils.isEmpty((CharSequence) null)) {
                str2 = "UTF-8";
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, z), str2));
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void b(File file, String str) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean b(File file) {
        String str;
        String str2;
        if (!file.exists() || !file.isFile()) {
            str = f3451a;
            str2 = "deleteSingleFile --> 文件不存在！ ";
        } else if (file.delete()) {
            d.b(f3451a, "deleteSingleFile --> 删除单个文件成功！");
            return true;
        } else {
            str = f3451a;
            str2 = "deleteSingleFile --> 删除单个文件失败！";
        }
        d.b(str, str2);
        return false;
    }
}
