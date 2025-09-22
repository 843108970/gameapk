package com.b.b;

import com.umeng.commonsdk.proguard.bg;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class i implements Serializable, Comparable<i> {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f856a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b  reason: collision with root package name */
    public static final i f857b = a(new byte[0]);

    /* renamed from: c  reason: collision with root package name */
    final byte[] f858c;
    transient int d;
    transient String e;

    i(byte[] bArr) {
        this.f858c = bArr;
    }

    private static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: " + c2);
            }
        }
        return (c2 - c3) + 10;
    }

    public static i a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        i iVar = new i(str.getBytes(aa.f846a));
        iVar.e = str;
        return iVar;
    }

    public static i a(byte... bArr) {
        if (bArr != null) {
            return new i((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static i b(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((a(str.charAt(i2)) << 4) + a(str.charAt(i2 + 1)));
        }
        return a(bArr);
    }

    private i c(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.f858c));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public byte a(int i) {
        return this.f858c[i];
    }

    public i a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        } else if (i2 > this.f858c.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.f858c.length + ")");
        } else {
            int i3 = i2 - i;
            if (i3 < 0) {
                throw new IllegalArgumentException("endIndex < beginIndex");
            } else if (i == 0 && i2 == this.f858c.length) {
                return this;
            } else {
                byte[] bArr = new byte[i3];
                System.arraycopy(this.f858c, i, bArr, 0, i3);
                return new i(bArr);
            }
        }
    }

    public String a() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f858c, aa.f846a);
        this.e = str2;
        return str2;
    }

    /* access modifiers changed from: package-private */
    public void a(f fVar) {
        fVar.b(this.f858c, 0, this.f858c.length);
    }

    public boolean a(int i, i iVar, int i2, int i3) {
        return iVar.a(0, this.f858c, 0, i3);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        return i >= 0 && i <= this.f858c.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && aa.a(this.f858c, i, bArr, i2, i3);
    }

    public String b() {
        return e.a(this.f858c);
    }

    public i c() {
        return c("SHA-1");
    }

    public /* synthetic */ int compareTo(Object obj) {
        i iVar = (i) obj;
        int g = g();
        int g2 = iVar.g();
        int min = Math.min(g, g2);
        for (int i = 0; i < min; i++) {
            byte a2 = a(i) & 255;
            byte a3 = iVar.a(i) & 255;
            if (a2 != a3) {
                return a2 < a3 ? -1 : 1;
            }
        }
        if (g == g2) {
            return 0;
        }
        return g < g2 ? -1 : 1;
    }

    public i d() {
        return c("SHA-256");
    }

    public String e() {
        char[] cArr = new char[(this.f858c.length * 2)];
        int i = 0;
        for (byte b2 : this.f858c) {
            int i2 = i + 1;
            cArr[i] = f856a[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = f856a[b2 & bg.m];
        }
        return new String(cArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            return iVar.g() == this.f858c.length && iVar.a(0, this.f858c, 0, this.f858c.length);
        }
    }

    public i f() {
        int i = 0;
        while (i < this.f858c.length) {
            byte b2 = this.f858c[i];
            if (b2 < 65 || b2 > 90) {
                i++;
            } else {
                byte[] bArr = (byte[]) this.f858c.clone();
                bArr[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < bArr.length; i2++) {
                    byte b3 = bArr[i2];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr[i2] = (byte) (b3 + 32);
                    }
                }
                return new i(bArr);
            }
        }
        return this;
    }

    public int g() {
        return this.f858c.length;
    }

    public byte[] h() {
        return (byte[]) this.f858c.clone();
    }

    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f858c);
        this.d = hashCode;
        return hashCode;
    }

    public String toString() {
        String replace;
        StringBuilder sb;
        StringBuilder sb2;
        String str;
        if (this.f858c.length == 0) {
            return "[size=0]";
        }
        String a2 = a();
        int length = a2.length();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                i = a2.length();
                break;
            } else if (i2 == 64) {
                break;
            } else {
                int codePointAt = a2.codePointAt(i);
                if ((!Character.isISOControl(codePointAt) || codePointAt == 10 || codePointAt == 13) && codePointAt != 65533) {
                    i2++;
                    i += Character.charCount(codePointAt);
                }
            }
        }
        i = -1;
        if (i != -1) {
            replace = a2.substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (i < a2.length()) {
                sb2 = new StringBuilder("[size=");
                sb2.append(this.f858c.length);
                sb2.append(" text=");
                sb2.append(replace);
                str = "…]";
                sb2.append(str);
                return sb2.toString();
            }
            sb = new StringBuilder("[text=");
        } else if (this.f858c.length <= 64) {
            sb = new StringBuilder("[hex=");
            replace = e();
        } else {
            sb2 = new StringBuilder("[size=");
            sb2.append(this.f858c.length);
            sb2.append(" hex=");
            replace = a(0, 64).e();
            sb2.append(replace);
            str = "…]";
            sb2.append(str);
            return sb2.toString();
        }
        sb2.append(replace);
        str = "]";
        sb2.append(str);
        return sb2.toString();
    }
}
