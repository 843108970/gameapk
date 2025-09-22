package com.hlzn.socketclient.f;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3455a = "g";

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return str.substring(str.indexOf("{"), str.lastIndexOf("}"));
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    private static byte[] a(InputStream inputStream) throws Exception {
        d.b(f3455a, "readInputStream --> ");
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                d.b(f3455a, "readInputStream --> 1");
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static byte[] a(InputStream inputStream, int i) throws Exception {
        d.b(f3455a, "readInputStream --> ");
        byte[] bArr = new byte[i];
        int read = inputStream.read(bArr);
        int i2 = read;
        while (read < i && i2 >= 0) {
            i2 = inputStream.read(bArr, i2, i - i2);
            if (i2 > 0) {
                read += i2;
            }
        }
        if (read < 0) {
            return new byte[0];
        }
        if (read >= i) {
            return bArr;
        }
        byte[] bArr2 = new byte[read];
        System.arraycopy(bArr, 0, bArr2, 0, read);
        return bArr2;
    }
}
