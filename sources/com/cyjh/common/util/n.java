package com.cyjh.common.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import org.apache.commons.io.IOUtils;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1682a = "n";

    public static File a(Context context, String str) {
        File file;
        try {
            file = new File(context.getFilesDir() + File.separator + str);
            try {
                if (!file.exists()) {
                    file.mkdirs();
                    return file;
                }
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return file;
            }
        } catch (Exception e2) {
            e = e2;
            file = null;
            e.printStackTrace();
            return file;
        }
        return file;
    }

    public static File a(File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
                return file;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

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

    public static String a(Bitmap bitmap, String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(File file, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str = "utf-8";
        }
        StringBuilder sb = new StringBuilder();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), str);
            while (true) {
                int read = inputStreamReader.read();
                if (read == -1) {
                    break;
                }
                sb.append((char) read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        String sb2 = sb.toString();
        int indexOf = sb2.indexOf(IOUtils.LINE_SEPARATOR_WINDOWS);
        int indexOf2 = sb2.indexOf("\r");
        if (indexOf != -1) {
            str2 = IOUtils.LINE_SEPARATOR_WINDOWS;
        } else if (indexOf2 == -1) {
            return sb2;
        } else {
            str2 = "\r";
        }
        return sb2.replaceAll(str2, "\n");
    }

    public static String a(String str) {
        try {
            return new String(str.getBytes("UTF-8"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String a(String str, String str2, String str3) {
        if (str == null || str.length() == 0) {
            String str4 = f1682a;
            ad.c(str4, "convertEncodingFormat --> str=" + str + ",formatFrom=" + str2 + ",formatTo=" + str3);
            return str;
        }
        try {
            return new String(str.getBytes(str2), str3);
        } catch (UnsupportedEncodingException e) {
            String str5 = f1682a;
            ad.c(str5, "convertEncodingFormat --> str=" + str + ",ex=" + e.getMessage());
            e.printStackTrace();
            return str;
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    private static void a(FileInputStream fileInputStream, FileOutputStream fileOutputStream) {
        try {
            byte[] bArr = new byte[102400];
            while (true) {
                int read = fileInputStream.read(bArr, 0, 102400);
                if (read == -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void a(String str, String str2, boolean z) {
        try {
            File file = new File(str);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
                file = new File(str);
            }
            FileWriter fileWriter = new FileWriter(file, z);
            if (str2 != null && !"".equals(str2)) {
                fileWriter.write(str2);
                fileWriter.flush();
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean a(File file, String str, String str2) {
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

    public static File b(String str, String str2) {
        File file = null;
        try {
            File file2 = new File(str);
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

    public static String b(File file) {
        return a(file, (String) null);
    }

    public static String b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        String sb2 = sb.toString();
        try {
            return str.substring(str.lastIndexOf("/"));
        } catch (Exception e) {
            e.printStackTrace();
            return sb2;
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

    public static boolean b(File file, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = "UTF-8";
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), str2));
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Bitmap c(String str) {
        try {
            return BitmapFactory.decodeStream(new FileInputStream(str));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void c(String str, String str2) {
        try {
            String str3 = f1682a;
            ad.c(str3, "copyFile --> targetFileAbsolutePath=" + str + ",toPath=" + str2);
            File file = new File(str);
            File file2 = new File(str2);
            if (!file2.isFile()) {
                file2.mkdirs();
            }
            a(new FileInputStream(file), new FileOutputStream(file2));
        } catch (Exception e) {
            e.printStackTrace();
            String str4 = f1682a;
            ad.c(str4, "copyFile --> ex=" + e.getMessage());
        }
    }

    public static boolean c(File file) {
        String str;
        String str2;
        if (!file.exists() || !file.isFile()) {
            str = f1682a;
            str2 = "deleteSingleFile --> 文件不存在！ ";
        } else if (file.delete()) {
            ad.c(f1682a, "deleteSingleFile --> 删除单个文件成功！");
            return true;
        } else {
            str = f1682a;
            str2 = "deleteSingleFile --> 删除单个文件失败！";
        }
        ad.c(str, str2);
        return false;
    }

    private static boolean c(File file, String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static File d(String str) {
        File file;
        try {
            file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + str);
            try {
                if (!file.exists()) {
                    file.mkdirs();
                    return file;
                }
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return file;
            }
        } catch (Exception e2) {
            e = e2;
            file = null;
            e.printStackTrace();
            return file;
        }
        return file;
    }

    public static String d(File file) {
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    instance.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return a(instance.digest());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean e(String str) {
        String str2;
        StringBuilder sb;
        String str3;
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            str2 = f1682a;
            sb = new StringBuilder("deleteSingleFile --> 删除单个文件失败: ");
            sb.append(str);
            str3 = "不存在！";
        } else if (file.delete()) {
            String str4 = f1682a;
            ad.c(str4, "deleteSingleFile --> 删除单个文件 " + str + "成功！");
            return true;
        } else {
            str2 = f1682a;
            sb = new StringBuilder("deleteSingleFile --> 删除单个文件 ");
            sb.append(str);
            str3 = "失败！";
        }
        sb.append(str3);
        ad.c(str2, sb.toString());
        return false;
    }

    private static boolean f(String str) {
        String str2;
        String str3;
        try {
            if (str.endsWith(File.separator)) {
                str = str + File.separator;
            }
            File file = new File(str);
            if (!file.exists() || !file.isDirectory()) {
                return false;
            }
            File[] listFiles = file.listFiles();
            for (File absolutePath : listFiles) {
                String absolutePath2 = absolutePath.getAbsolutePath();
                File file2 = new File(absolutePath2);
                if (!file2.exists() || !file2.isFile()) {
                    str2 = f1682a;
                    str3 = "deleteSingleFile --> 删除单个文件失败: " + absolutePath2 + "不存在！";
                } else if (file2.delete()) {
                    str2 = f1682a;
                    str3 = "deleteSingleFile --> 删除单个文件 " + absolutePath2 + "成功！";
                } else {
                    str2 = f1682a;
                    str3 = "deleteSingleFile --> 删除单个文件 " + absolutePath2 + "失败！";
                }
                ad.c(str2, str3);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean g(String str) {
        try {
            return new File(str).exists();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
