package com.cyjh.http.e;

import com.cyjh.common.a.a;
import com.cyjh.common.util.b;
import com.cyjh.common.util.h;
import com.cyjh.common.util.z;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public final class c {
    public static String a(String str) {
        try {
            String f = a.f();
            byte[] bytes = str.getBytes("utf-8");
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(a.a.a.a.b(f.getBytes())));
            Signature instance = Signature.getInstance(z.f1795b);
            instance.initSign(generatePrivate);
            instance.update(bytes);
            return b.a(instance.sign());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(String str, int i) {
        return (str.startsWith(com.cyjh.common.b.a.f1622b) || str.startsWith(com.cyjh.common.b.a.d)) ? a.f1618a[i] : str.startsWith("http://api") ? a.d[i] : a.f1620c[i];
    }

    public static String a(String str, String str2, int i) {
        try {
            return h.b(str2, a(str, i).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean a(String str, String str2) {
        try {
            String e = a.e();
            byte[] bytes = str.getBytes();
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(a.a.a.a.b(e.getBytes())));
            Signature instance = Signature.getInstance(z.f1795b);
            instance.initVerify(generatePublic);
            instance.update(bytes);
            return instance.verify(a.a.a.a.b(str2.getBytes()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static String b(String str, String str2, int i) throws Exception {
        return h.a(str2, a(str, i).getBytes());
    }
}
