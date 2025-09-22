package com.cyjh.common.util;

import android.util.Base64;
import com.umeng.commonsdk.proguard.bg;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    static AlgorithmParameterSpec f1671a;

    /* renamed from: b  reason: collision with root package name */
    private static byte[] f1672b = {bg.k, 24, 46, 110, 38, 102, 12, 36};

    /* renamed from: c  reason: collision with root package name */
    private static byte[] f1673c = {32, 47, 11, Byte.MIN_VALUE, 29, 77, 105, 21};
    private static Key d;

    private static String a(String str) throws Exception {
        a(f1672b, f1673c);
        Cipher instance = Cipher.getInstance("DES/ECB/NoPadding");
        instance.init(1, d);
        byte[] bytes = str.getBytes("utf-8");
        if (bytes.length % 8 != 0) {
            byte[] bArr = new byte[((bytes.length + 8) - (bytes.length % 8))];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            bytes = bArr;
        }
        return Base64.encodeToString(instance.doFinal(bytes), 0);
    }

    public static String a(String str, byte[] bArr) throws Exception {
        a(bArr, f1673c);
        Cipher instance = Cipher.getInstance("DES/ECB/NoPadding");
        instance.init(1, d);
        byte[] bytes = str.getBytes("utf-8");
        if (bytes.length % 8 != 0) {
            byte[] bArr2 = new byte[((bytes.length + 8) - (bytes.length % 8))];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            bytes = bArr2;
        }
        return Base64.encodeToString(instance.doFinal(bytes), 2);
    }

    private static void a(byte[] bArr, byte[] bArr2) {
        try {
            DESKeySpec dESKeySpec = new DESKeySpec(bArr);
            f1671a = new IvParameterSpec(bArr2);
            d = SecretKeyFactory.getInstance("DES").generateSecret(dESKeySpec);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        } catch (InvalidKeySpecException e3) {
            e3.printStackTrace();
        }
    }

    private static String b(String str) throws Exception {
        a(f1672b, f1673c);
        Cipher instance = Cipher.getInstance("DES/ECB/NoPadding");
        instance.init(2, d);
        return new String(instance.doFinal(Base64.decode(str, 1)), "UTF-8").trim();
    }

    public static String b(String str, byte[] bArr) throws Exception {
        a(bArr, f1673c);
        Cipher instance = Cipher.getInstance("DES/ECB/NoPadding");
        instance.init(2, d);
        return new String(instance.doFinal(Base64.decode(str, 1)), "UTF-8").trim();
    }

    private static String c(String str, byte[] bArr) throws Exception {
        a(bArr, f1673c);
        Cipher instance = Cipher.getInstance("DES/ECB/NoPadding");
        instance.init(1, d);
        byte[] bytes = str.getBytes("utf-8");
        if (bytes.length % 8 != 0) {
            byte[] bArr2 = new byte[((bytes.length + 8) - (bytes.length % 8))];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            bytes = bArr2;
        }
        return Base64.encodeToString(instance.doFinal(bytes), 2);
    }
}
