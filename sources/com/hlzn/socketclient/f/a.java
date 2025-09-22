package com.hlzn.socketclient.f;

import android.support.v4.media.session.PlaybackStateCompat;
import com.umeng.commonsdk.proguard.bg;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

public final class a {
    public static int a(String str) {
        String upperCase = str.toUpperCase();
        int length = upperCase.length();
        int i = 0;
        for (int i2 = length; i2 > 0; i2--) {
            char charAt = upperCase.charAt(i2 - 1);
            i = (int) (((double) i) + (Math.pow(16.0d, (double) (length - i2)) * ((double) ((charAt < '0' || charAt > '9') ? charAt - '7' : charAt - '0'))));
        }
        return i;
    }

    private static int a(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << bg.n);
    }

    private static long a(InputStream inputStream, long j) {
        byte[] bArr = new byte[2048];
        if (j <= 0) {
            return 0;
        }
        long j2 = j;
        int i = 0;
        while (j2 > 0) {
            try {
                i = inputStream.read(bArr, 0, (int) Math.min(PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH, j2));
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (i < 0) {
                break;
            }
            j2 -= (long) i;
        }
        return j - j2;
    }

    public static String a(byte[] bArr) {
        StringBuilder sb;
        if (bArr == null) {
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        }
        String str = "";
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb = new StringBuilder();
                sb.append(str);
                str = "0";
            } else {
                sb = new StringBuilder();
            }
            sb.append(str);
            sb.append(hexString);
            str = sb.toString();
        }
        return str.toUpperCase();
    }

    public static byte[] a(int i) {
        byte[] bArr = new byte[4];
        bArr[3] = (byte) ((i >> 24) & 255);
        bArr[2] = (byte) ((i >> 16) & 255);
        bArr[1] = (byte) ((i >> 8) & 255);
        bArr[0] = (byte) (i & 255);
        return bArr;
    }

    private static byte[] a(int i, ByteOrder byteOrder) {
        byte[] bArr = new byte[4];
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            bArr[3] = (byte) ((i >> 24) & 255);
            bArr[2] = (byte) ((i >> 16) & 255);
            bArr[1] = (byte) ((i >> 8) & 255);
            bArr[0] = (byte) (i & 255);
            return bArr;
        }
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        return bArr;
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[(bArr.length + bArr2.length + bArr3.length)];
        System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr4, bArr.length, bArr2.length);
        System.arraycopy(bArr3, 0, bArr4, bArr.length + bArr2.length, bArr3.length);
        return bArr4;
    }

    private static int b(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << bg.n) | ((bArr[i + 2] & 255) << 8);
    }

    public static byte[] b(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255)};
    }

    private static byte[] b(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public static byte[] b(byte[] bArr) {
        if (bArr.length <= 0) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            bArr2[i] = bArr[length];
            i++;
        }
        return bArr2;
    }

    private static int c(String str) {
        int length = str.length();
        int i = 0;
        for (int i2 = length; i2 > 0; i2--) {
            i = (int) (((double) i) + (Math.pow(2.0d, (double) (length - i2)) * ((double) (str.charAt(i2 - 1) - '0'))));
        }
        return i;
    }

    private static String c(byte... bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            String binaryString = Integer.toBinaryString(b2 | 256);
            int length = binaryString.length();
            stringBuffer.append(binaryString.substring(length - 8, length));
        }
        return stringBuffer.toString();
    }

    private static byte[] c(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    private static String d(String str) {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(charArray[(bytes[i] & 240) >> 4]);
            sb.append(charArray[bytes[i] & bg.m]);
            sb.append(' ');
        }
        return sb.toString().trim();
    }

    private static String d(byte[] bArr) {
        String str = "";
        for (int i = 0; i < bArr.length; i++) {
            str = str + ((char) bArr[i]);
        }
        return str;
    }

    private static String e(String str) {
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((("0123456789ABCDEF".indexOf(charArray[i2]) * 16) + "0123456789ABCDEF".indexOf(charArray[i2 + 1])) & 255);
        }
        return new String(bArr);
    }
}
