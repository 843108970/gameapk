package com.cyjh.common.util;

import a.a.a.a;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public final class z {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1794a = "RSA";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1795b = "SHA256withRSA";

    /* renamed from: c  reason: collision with root package name */
    private static final String f1796c = "RSAPublicKey";
    private static final String d = "RSAPrivateKey";
    private static final int e = 117;
    private static final int f = 128;

    private static String a(byte[] bArr, String str) throws Exception {
        PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(a.b(str.getBytes())));
        Signature instance = Signature.getInstance(f1795b);
        instance.initSign(generatePrivate);
        instance.update(bArr);
        return b.a(instance.sign());
    }

    private static boolean a(byte[] bArr, String str, String str2) throws Exception {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(a.b(str.getBytes())));
        Signature instance = Signature.getInstance(f1795b);
        instance.initVerify(generatePublic);
        instance.update(bArr);
        return instance.verify(a.b(str2.getBytes()));
    }
}
