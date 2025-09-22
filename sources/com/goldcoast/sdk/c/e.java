package com.goldcoast.sdk.c;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static Method f2941a;

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f2942b = Pattern.compile("[\\w%+,./=_-]+");

    static {
        try {
            Method method = Class.forName("android.os.FileUtils").getMethod("setPermissions", new Class[]{String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE});
            f2941a = method;
            method.setAccessible(true);
        } catch (Exception unused) {
        }
    }

    public static int a(File file) {
        try {
            return ((Integer) f2941a.invoke((Object) null, new Object[]{file.getAbsolutePath(), 493, -1, -1})).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int a(String str, int i) {
        try {
            return ((Integer) f2941a.invoke((Object) null, new Object[]{str, Integer.valueOf(i), -1, -1})).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    public static void a(String[] strArr, File file) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            StringBuilder sb = new StringBuilder("#!/system/bin/sh\n");
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                sb.append(String.format("%s\n", new Object[]{strArr[i]}));
            }
            fileWriter.write(sb.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean a(File file, File file2) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            boolean a2 = a((InputStream) fileInputStream, file2);
            fileInputStream.close();
            return a2;
        } catch (IOException unused) {
            return false;
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x003e A[SYNTHETIC, Splitter:B:23:0x003e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(java.io.InputStream r3, java.io.File r4) {
        /*
            boolean r0 = r4.exists()
            if (r0 == 0) goto L_0x0009
            r4.delete()
        L_0x0009:
            r4.createNewFile()     // Catch:{ IOException -> 0x000d }
            goto L_0x0011
        L_0x000d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0011:
            r0 = 0
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0037 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0037 }
            r4 = 4096(0x1000, float:5.74E-42)
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x0035 }
        L_0x001c:
            int r0 = r3.read(r4)     // Catch:{ Exception -> 0x0035 }
            if (r0 < 0) goto L_0x0026
            r2.write(r4, r1, r0)     // Catch:{ Exception -> 0x0035 }
            goto L_0x001c
        L_0x0026:
            r2.flush()     // Catch:{ Exception -> 0x0035 }
            java.io.FileDescriptor r3 = r2.getFD()     // Catch:{ Exception -> 0x0035 }
            r3.sync()     // Catch:{ Exception -> 0x0035 }
            r2.close()     // Catch:{ Exception -> 0x0035 }
            r3 = 1
            return r3
        L_0x0035:
            r3 = move-exception
            goto L_0x0039
        L_0x0037:
            r3 = move-exception
            r2 = r0
        L_0x0039:
            r3.printStackTrace()
            if (r2 == 0) goto L_0x0046
            r2.close()     // Catch:{ IOException -> 0x0042 }
            return r1
        L_0x0042:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0046:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.goldcoast.sdk.c.e.a(java.io.InputStream, java.io.File):boolean");
    }
}
