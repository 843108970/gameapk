package com.cyjh.common.util;

import android.util.Base64;
import android.util.Log;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1782a = "RSA";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1783b = "RSA/ECB/NoPadding";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1784c = "1";
    public static final String d = "2";
    public static final int e = 2048;
    public static final String f = "MANUTD is the greatest club in the world";

    private static String a(PrivateKey privateKey, byte[] bArr) {
        try {
            Cipher instance = Cipher.getInstance(f1783b);
            instance.init(2, privateKey);
            return new String(instance.doFinal(bArr));
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static KeyPair a() throws Exception {
        KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
        instance.initialize(2048);
        return instance.generateKeyPair();
    }

    private static PublicKey a(byte[] bArr) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static RSAPublicKey a(String str) throws Exception {
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NoSuchAlgorithmException unused) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused2) {
            throw new Exception("公钥非法");
        } catch (NullPointerException unused3) {
            throw new Exception("公钥数据为空");
        }
    }

    private static byte[] a(PublicKey publicKey, byte[] bArr) {
        try {
            Cipher instance = Cipher.getInstance(f1783b);
            instance.init(1, publicKey);
            return instance.doFinal(bArr);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String b(PublicKey publicKey, byte[] bArr) {
        try {
            Cipher instance = Cipher.getInstance(f1783b);
            instance.init(2, publicKey);
            return new String(instance.doFinal(bArr));
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static PublicKey b(byte[] bArr) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new PKCS8EncodedKeySpec(bArr));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static Map<String, byte[]> b() {
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
            instance.initialize(2048);
            KeyPair generateKeyPair = instance.generateKeyPair();
            RSAPublicKey rSAPublicKey = (RSAPublicKey) generateKeyPair.getPublic();
            RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) generateKeyPair.getPrivate();
            HashMap hashMap = new HashMap();
            hashMap.put("1", rSAPublicKey.getEncoded());
            hashMap.put("2", rSAPrivateKey.getEncoded());
            Log.e("ffff", "fuck.1...     " + Base64.encodeToString(rSAPublicKey.getEncoded(), 2));
            Log.e("ffff", "fuck.2...     " + Base64.encodeToString(rSAPrivateKey.getEncoded(), 2));
            return hashMap;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
