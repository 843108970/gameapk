package b.a.k;

import c.f;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    static final String f230a = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";

    /* renamed from: b  reason: collision with root package name */
    static final int f231b = 128;

    /* renamed from: c  reason: collision with root package name */
    static final int f232c = 64;
    static final int d = 32;
    static final int e = 16;
    static final int f = 15;
    static final int g = 8;
    static final int h = 128;
    static final int i = 127;
    static final int j = 0;
    static final int k = 1;
    static final int l = 2;
    static final int m = 8;
    static final int n = 9;
    static final int o = 10;
    static final long p = 125;
    static final long q = 123;
    static final int r = 126;
    static final long s = 65535;
    static final int t = 127;
    static final int u = 1001;
    static final int v = 1002;
    static final int w = 1005;
    static final int x = 1006;

    private b() {
        throw new AssertionError("No instances.");
    }

    static String a(int i2) {
        StringBuilder sb;
        if (i2 < 1000 || i2 >= 5000) {
            sb = new StringBuilder("Code must be in range [1000,5000): ");
            sb.append(i2);
        } else if ((i2 < 1004 || i2 > 1006) && (i2 < 1012 || i2 > 2999)) {
            return null;
        } else {
            sb = new StringBuilder("Code ");
            sb.append(i2);
            sb.append(" is reserved and may not be used.");
        }
        return sb.toString();
    }

    private static String a(String str) {
        return f.encodeUtf8(str + f230a).sha1().base64();
    }

    static void a(byte[] bArr, long j2, byte[] bArr2, long j3) {
        int length = bArr2.length;
        int i2 = 0;
        while (((long) i2) < j2) {
            bArr[i2] = (byte) (bArr2[(int) (j3 % ((long) length))] ^ bArr[i2]);
            i2++;
            j3++;
        }
    }

    static void b(int i2) {
        String a2 = a(i2);
        if (a2 != null) {
            throw new IllegalArgumentException(a2);
        }
    }
}
