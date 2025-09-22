package com.iflytek.collector.a.a;

import android.util.Base64;
import com.iflytek.voiceads.config.SDKLogger;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class h {
    public static RSAPublicKey a(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (Exception e) {
            SDKLogger.e("loadPublicKey:" + e.getMessage());
            return null;
        }
    }

    public static byte[] a(byte[] bArr, RSAPublicKey rSAPublicKey) throws Exception {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, rSAPublicKey);
        return instance.doFinal(bArr);
    }
}
