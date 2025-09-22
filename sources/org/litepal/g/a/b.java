package org.litepal.g.a;

import android.text.TextUtils;
import com.umeng.commonsdk.proguard.bg;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f4829a = "LitePalKey";

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f4830b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return a.a(f4829a, str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static char[] a(byte[] bArr) {
        char[] cArr = f4830b;
        int length = bArr.length;
        char[] cArr2 = new char[(length << 1)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr2[i] = cArr[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr2[i3] = cArr[bArr[i2] & bg.m];
        }
        return cArr2;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return a.b(f4829a, str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes(Charset.defaultCharset()));
            return new String(a(instance.digest()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}
