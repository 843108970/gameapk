package org.litepal.g.a;

import android.util.Base64;
import android.util.Log;
import com.umeng.commonsdk.proguard.bg;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f4826a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final String f4827b = "AESCrypt";

    /* renamed from: c  reason: collision with root package name */
    private static final String f4828c = "AES/CBC/PKCS7Padding";
    private static final String d = "UTF-8";
    private static final String e = "SHA-256";
    private static final byte[] f = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    private a() {
    }

    public static String a(String str, String str2) throws GeneralSecurityException {
        try {
            SecretKeySpec a2 = a(str);
            c("message", str2);
            byte[] bArr = f;
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher instance = Cipher.getInstance(f4828c);
            instance.init(1, a2, new IvParameterSpec(bArr));
            byte[] doFinal = instance.doFinal(bytes);
            a("cipherText", doFinal);
            String encodeToString = Base64.encodeToString(doFinal, 2);
            c("Base64.NO_WRAP", encodeToString);
            return encodeToString;
        } catch (UnsupportedEncodingException e2) {
            if (f4826a) {
                Log.e(f4827b, "UnsupportedEncodingException ", e2);
            }
            throw new GeneralSecurityException(e2);
        }
    }

    private static String a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i] & 255;
            int i2 = i * 2;
            cArr2[i2] = cArr[b2 >>> 4];
            cArr2[i2 + 1] = cArr[b2 & bg.m];
        }
        return new String(cArr2);
    }

    private static SecretKeySpec a(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest instance = MessageDigest.getInstance(e);
        byte[] bytes = str.getBytes("UTF-8");
        instance.update(bytes, 0, bytes.length);
        byte[] digest = instance.digest();
        a("SHA-256 key ", digest);
        return new SecretKeySpec(digest, "AES");
    }

    private static void a(String str, byte[] bArr) {
        if (f4826a) {
            Log.d(f4827b, str + "[" + bArr.length + "] [" + a(bArr) + "]");
        }
    }

    private static byte[] a(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher instance = Cipher.getInstance(f4828c);
        instance.init(1, secretKeySpec, new IvParameterSpec(bArr));
        byte[] doFinal = instance.doFinal(bArr2);
        a("cipherText", doFinal);
        return doFinal;
    }

    public static String b(String str, String str2) throws GeneralSecurityException {
        try {
            SecretKeySpec a2 = a(str);
            c("base64EncodedCipherText", str2);
            byte[] decode = Base64.decode(str2, 2);
            a("decodedCipherText", decode);
            byte[] bArr = f;
            Cipher instance = Cipher.getInstance(f4828c);
            instance.init(2, a2, new IvParameterSpec(bArr));
            byte[] doFinal = instance.doFinal(decode);
            a("decryptedBytes", doFinal);
            a("decryptedBytes", doFinal);
            String str3 = new String(doFinal, "UTF-8");
            c("message", str3);
            return str3;
        } catch (UnsupportedEncodingException e2) {
            if (f4826a) {
                Log.e(f4827b, "UnsupportedEncodingException ", e2);
            }
            throw new GeneralSecurityException(e2);
        }
    }

    private static byte[] b(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher instance = Cipher.getInstance(f4828c);
        instance.init(2, secretKeySpec, new IvParameterSpec(bArr));
        byte[] doFinal = instance.doFinal(bArr2);
        a("decryptedBytes", doFinal);
        return doFinal;
    }

    private static void c(String str, String str2) {
        if (f4826a) {
            Log.d(f4827b, str + "[" + str2.length() + "] [" + str2 + "]");
        }
    }
}
