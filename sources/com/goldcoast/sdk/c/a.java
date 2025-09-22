package com.goldcoast.sdk.c;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f2934a = "";

    public static String a(String str) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            int blockSize = instance.getBlockSize();
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            if (length % blockSize != 0) {
                length += blockSize - (length % blockSize);
            }
            byte[] bArr = new byte[length];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            if (f2934a.equals("")) {
                f2934a = new String(Base64.decode("Y2NiOWRmN2IyYjA5M2E2Yw==\n".getBytes(), 0));
            }
            instance.init(1, new SecretKeySpec(f2934a.getBytes("UTF-8"), "AES"), new IvParameterSpec(f2934a.getBytes()));
            return Base64.encodeToString(instance.doFinal(bArr), 4).trim();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b(String str) {
        if (f2934a.equals("")) {
            f2934a = new String(Base64.decode("Y2NiOWRmN2IyYjA5M2E2Yw==\n".getBytes(), 0));
        }
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, new SecretKeySpec(f2934a.getBytes("UTF-8"), "AES"), new IvParameterSpec(f2934a.getBytes()));
            return new String(instance.doFinal(Base64.decode(str, 4)), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
