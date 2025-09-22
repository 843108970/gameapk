package com.cyjh.common.util;

import a.a.a.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final int f1667a = 1024;

    public static String a(byte[] bArr) throws Exception {
        return new String(a.a(bArr));
    }

    private static void a(String str, String str2) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a.b(str2.getBytes()));
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = byteArrayInputStream.read(bArr);
            if (read != -1) {
                fileOutputStream.write(bArr, 0, read);
                fileOutputStream.flush();
            } else {
                fileOutputStream.close();
                byteArrayInputStream.close();
                return;
            }
        }
    }

    private static void a(byte[] bArr, String str) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = byteArrayInputStream.read(bArr2);
            if (read != -1) {
                fileOutputStream.write(bArr2, 0, read);
                fileOutputStream.flush();
            } else {
                fileOutputStream.close();
                byteArrayInputStream.close();
                return;
            }
        }
    }

    private static byte[] a(String str) throws Exception {
        return a.b(str.getBytes());
    }

    private static String b(String str) throws Exception {
        byte[] bArr = new byte[0];
        File file = new File(str);
        if (file.exists()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(2048);
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr2);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
                byteArrayOutputStream.flush();
            }
            byteArrayOutputStream.close();
            fileInputStream.close();
            bArr = byteArrayOutputStream.toByteArray();
        }
        return a(bArr);
    }

    private static byte[] c(String str) throws Exception {
        byte[] bArr = new byte[0];
        File file = new File(str);
        if (!file.exists()) {
            return bArr;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(2048);
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = fileInputStream.read(bArr2);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
                byteArrayOutputStream.flush();
            } else {
                byteArrayOutputStream.close();
                fileInputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
