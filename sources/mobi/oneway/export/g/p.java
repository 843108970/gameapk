package mobi.oneway.export.g;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

public class p {
    public static String a(File file) {
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA-256");
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read != -1) {
                        instance.update(bArr, 0, read);
                    } else {
                        String b2 = b(instance.digest());
                        j.a(bufferedInputStream);
                        return b2;
                    }
                }
            } catch (Throwable th) {
                th = th;
                j.a(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
            j.a(bufferedInputStream);
            throw th;
        }
    }

    public static String a(String str) {
        return a(str.getBytes("utf-8"));
    }

    public static String a(byte[] bArr) {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        instance.update(bArr, 0, bArr.length);
        return b(instance.digest());
    }

    private static String b(byte[] bArr) {
        String str = "";
        for (byte b2 : bArr) {
            byte b3 = b2 & 255;
            if (b3 <= 15) {
                str = str + "0";
            }
            str = str + Integer.toHexString(b3);
        }
        return str;
    }
}
