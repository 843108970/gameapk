package mobi.oneway.export.g;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Cipher> f4208a = new ConcurrentHashMap();

    private static String a(String str, int i, boolean z) {
        char[] charArray = str.toCharArray();
        char[] cArr = new char[i];
        boolean z2 = !z;
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = charArray[(i2 * 2) + (z2 ? 1 : 0)];
        }
        return String.valueOf(cArr);
    }

    public static String a(String str, String str2, String str3) {
        String[] a2 = a(str2, str3);
        return c(str, a2[0], a2[1]);
    }

    private static Cipher a(String str, String str2, int i) {
        String str3 = str + ":" + str2 + ":" + i;
        Cipher cipher = f4208a.get(str3);
        if (cipher != null) {
            return cipher;
        }
        SecretKeySpec a2 = a(str);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(i, a2, new IvParameterSpec(str2.getBytes("utf-8")));
        f4208a.put(str3, instance);
        return instance;
    }

    private static SecretKeySpec a(String str) {
        byte[] bytes = str.getBytes("utf-8");
        byte[] bArr = new byte[16];
        int i = 0;
        while (i < bytes.length && i < 16) {
            bArr[i] = bytes[i];
            i++;
        }
        return new SecretKeySpec(bArr, "AES");
    }

    private static boolean a(int i) {
        return (i & 1) == 1;
    }

    private static String[] a(String str, String str2) {
        char charAt = str.charAt(2);
        char charAt2 = str2.charAt(5);
        String a2 = a(str2, 8, a((int) charAt));
        String a3 = a(str, 8, a((int) charAt2));
        return new String[]{a2 + a3, a3 + a2};
    }

    public static String b(String str, String str2, String str3) {
        String[] a2 = a(str2, str3);
        return d(str, a2[0], a2[1]);
    }

    private static String c(String str, String str2, String str3) {
        return new String(b.a(a(str2, str3, 1).doFinal(str.getBytes("utf-8"))), "utf-8");
    }

    private static String d(String str, String str2, String str3) {
        return new String(a(str2, str3, 2).doFinal(b.b(str.getBytes("utf-8"))));
    }
}
