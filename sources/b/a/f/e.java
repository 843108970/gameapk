package b.a.f;

import b.a.c;
import c.f;
import java.io.IOException;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    static final f f116a = f.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b  reason: collision with root package name */
    static final int f117b = 16384;

    /* renamed from: c  reason: collision with root package name */
    static final byte f118c = 0;
    static final byte d = 1;
    static final byte e = 2;
    static final byte f = 3;
    static final byte g = 4;
    static final byte h = 5;
    static final byte i = 6;
    static final byte j = 7;
    static final byte k = 8;
    static final byte l = 9;
    static final byte m = 0;
    static final byte n = 1;
    static final byte o = 1;
    static final byte p = 4;
    static final byte q = 4;
    static final byte r = 8;
    static final byte s = 32;
    static final byte t = 32;
    static final String[] u = new String[64];
    static final String[] v = new String[256];
    private static final String[] w = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    static {
        for (int i2 = 0; i2 < v.length; i2++) {
            v[i2] = c.a("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
        }
        u[0] = "";
        u[1] = "END_STREAM";
        int[] iArr = {1};
        u[8] = "PADDED";
        for (int i3 = 0; i3 <= 0; i3++) {
            int i4 = iArr[i3];
            u[i4 | 8] = u[i4] + "|PADDED";
        }
        u[4] = "END_HEADERS";
        u[32] = "PRIORITY";
        u[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 <= 0; i7++) {
                int i8 = iArr[i7];
                String[] strArr = u;
                int i9 = i8 | i6;
                strArr[i9] = u[i8] + '|' + u[i6];
                u[i9 | 8] = u[i8] + '|' + u[i6] + "|PADDED";
            }
        }
        for (int i10 = 0; i10 < u.length; i10++) {
            if (u[i10] == null) {
                u[i10] = v[i10];
            }
        }
    }

    private e() {
    }

    static IllegalArgumentException a(String str, Object... objArr) {
        throw new IllegalArgumentException(c.a(str, objArr));
    }

    private static String a(byte b2, byte b3) {
        if (b3 == 0) {
            return "";
        }
        switch (b2) {
            case 2:
            case 3:
            case 7:
            case 8:
                return v[b3];
            case 4:
            case 6:
                return b3 == 1 ? "ACK" : v[b3];
            default:
                String str = b3 < u.length ? u[b3] : v[b3];
                return (b2 != 5 || (b3 & 4) == 0) ? (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED") : str.replace("HEADERS", "PUSH_PROMISE");
        }
    }

    static String a(boolean z, int i2, int i3, byte b2, byte b3) {
        String str;
        String str2;
        String str3;
        String a2 = b2 < w.length ? w[b2] : c.a("0x%02x", Byte.valueOf(b2));
        if (b3 != 0) {
            switch (b2) {
                case 2:
                case 3:
                case 7:
                case 8:
                    str = v[b3];
                    break;
                case 4:
                case 6:
                    if (b3 != 1) {
                        str = v[b3];
                        break;
                    } else {
                        str = "ACK";
                        break;
                    }
                default:
                    String str4 = b3 < u.length ? u[b3] : v[b3];
                    if (b2 == 5 && (b3 & 4) != 0) {
                        str2 = "HEADERS";
                        str3 = "PUSH_PROMISE";
                    } else if (b2 != 0 || (b3 & 32) == 0) {
                        str = str4;
                        break;
                    } else {
                        str2 = "PRIORITY";
                        str3 = "COMPRESSED";
                    }
                    str = str4.replace(str2, str3);
                    break;
            }
        } else {
            str = "";
        }
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = a2;
        objArr[4] = str;
        return c.a("%s 0x%08x %5d %-13s %s", objArr);
    }

    static IOException b(String str, Object... objArr) throws IOException {
        throw new IOException(c.a(str, objArr));
    }
}
