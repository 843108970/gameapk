package mobi.oneway.export.g;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class h {
    private static long a(long j) {
        return Math.round(((double) j) / 1024.0d);
    }

    public static long a(File file) {
        if (f(file)) {
            return -1;
        }
        try {
            return a(file.getFreeSpace());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String a(Context context, String str, String str2) {
        InputStream inputStream = null;
        try {
            InputStream open = context.getAssets().open(str);
            try {
                String c2 = t.c(open, str2);
                j.a(open);
                return c2;
            } catch (Throwable th) {
                th = th;
                inputStream = open;
                j.a(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            j.a(inputStream);
            throw th;
        }
    }

    public static String a(String str, String str2) {
        byte[] h = h(new File(str));
        return str2 == null ? new String(h) : new String(h, str2);
    }

    public static List<String> a(File file, String str) {
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(t.b(new FileInputStream(file), str));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        arrayList.add(readLine);
                    } else {
                        j.a(bufferedReader2);
                        return arrayList;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    j.a(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            j.a(bufferedReader);
            throw th;
        }
    }

    public static boolean a() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static boolean a(File file, byte[] bArr) {
        if (file == null || bArr == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            c(file.getParent(), (String) null);
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
            try {
                bufferedOutputStream2.write(bArr);
                bufferedOutputStream2.flush();
                j.a(bufferedOutputStream2);
                return true;
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = bufferedOutputStream2;
                j.a(bufferedOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            j.a(bufferedOutputStream);
            throw th;
        }
    }

    public static boolean a(String str) {
        return e(new File(str));
    }

    public static boolean a(String str, Object obj) {
        return obj != null && b(new File(str), obj.toString());
    }

    private static long b(long j) {
        return Math.round((((double) j) / 1024.0d) / 1024.0d);
    }

    public static long b(File file) {
        if (f(file)) {
            return -1;
        }
        try {
            return a(file.getTotalSpace());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String b(String str) {
        return i(new File(str));
    }

    public static String b(String str, String str2) {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(t.b(new FileInputStream(str), str2));
            try {
                String readLine = bufferedReader2.readLine();
                j.a(bufferedReader2);
                return readLine;
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                j.a(bufferedReader);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            j.a(bufferedReader);
            throw th;
        }
    }

    public static boolean b(File file, String str) {
        return a(file, str.getBytes());
    }

    public static File c(File file, String str) {
        if (file == null) {
            return null;
        }
        return c(file.getAbsolutePath(), str);
    }

    public static File c(String str, String str2) {
        if (str == null) {
            return null;
        }
        File file = TextUtils.isEmpty(str2) ? new File(str) : new File(str, str2);
        if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
            return null;
        }
        return file;
    }

    public static String c(String str) {
        return b(str, (String) null);
    }

    public static boolean c(File file) {
        return e(file) && file.isFile();
    }

    public static List<String> d(String str) {
        return a(new File(str), (String) null);
    }

    public static boolean d(File file) {
        return e(file) && file.isDirectory();
    }

    public static boolean d(String str, String str2) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str2);
                try {
                    t.a((InputStream) fileInputStream, (OutputStream) fileOutputStream2);
                    j.a(fileInputStream, fileOutputStream2);
                    return true;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    j.a(fileInputStream, fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                j.a(fileInputStream, fileOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            j.a(fileInputStream, fileOutputStream);
            throw th;
        }
    }

    public static boolean e(File file) {
        return file != null && file.exists();
    }

    public static boolean e(String str) {
        return !TextUtils.isEmpty(str) && j(new File(str));
    }

    public static boolean f(File file) {
        return !e(file);
    }

    public static boolean f(String str) {
        try {
            Runtime.getRuntime().exec("chmod 777 " + str);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean g(File file) {
        return e(file) && file.canRead();
    }

    public static byte[] h(File file) {
        BufferedInputStream bufferedInputStream;
        ByteArrayOutputStream byteArrayOutputStream = null;
        if (file == null) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(bufferedInputStream.available());
                try {
                    t.a((InputStream) bufferedInputStream, (OutputStream) byteArrayOutputStream2);
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    j.a(bufferedInputStream, byteArrayOutputStream2);
                    return byteArray;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    th = th2;
                    j.a(bufferedInputStream, byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                j.a(bufferedInputStream, byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = null;
            j.a(bufferedInputStream, byteArrayOutputStream);
            throw th;
        }
    }

    public static String i(File file) {
        return a(file.getAbsolutePath(), (String) null);
    }

    public static boolean j(File file) {
        if (file == null) {
            return false;
        }
        boolean z = true;
        if (!file.exists()) {
            return true;
        }
        if (file.isFile()) {
            try {
                return file.delete();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            Stack stack = new Stack();
            stack.push(file);
            while (!stack.isEmpty()) {
                File[] listFiles = ((File) stack.peek()).listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    boolean z2 = z;
                    for (File file2 : listFiles) {
                        if (!file2.isFile()) {
                            stack.push(file2);
                        } else if (!file2.delete()) {
                            z2 = false;
                        }
                    }
                    z = z2;
                } else if (!((File) stack.pop()).delete()) {
                    z = false;
                }
            }
            return z;
        }
    }

    public static boolean k(File file) {
        return file != null && file.isDirectory() && file.canRead() && file.canWrite() && file.canExecute();
    }

    public static boolean l(File file) {
        return file != null && f(file.getAbsolutePath());
    }
}
