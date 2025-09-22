package com.b.a.a.e;

import com.b.a.a.c;
import com.b.b.i;
import java.io.IOException;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    static final i f677a = i.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b  reason: collision with root package name */
    static final String[] f678b = new String[64];

    /* renamed from: c  reason: collision with root package name */
    static final String[] f679c = new String[256];
    private static final String[] d = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    static {
        for (int i = 0; i < f679c.length; i++) {
            f679c[i] = c.a("%8s", Integer.toBinaryString(i)).replace(' ', '0');
        }
        f678b[0] = "";
        f678b[1] = "END_STREAM";
        int[] iArr = {1};
        f678b[8] = "PADDED";
        for (int i2 = 0; i2 <= 0; i2++) {
            int i3 = iArr[i2];
            f678b[i3 | 8] = f678b[i3] + "|PADDED";
        }
        f678b[4] = "END_HEADERS";
        f678b[32] = "PRIORITY";
        f678b[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i4 = 0; i4 < 3; i4++) {
            int i5 = iArr2[i4];
            for (int i6 = 0; i6 <= 0; i6++) {
                int i7 = iArr[i6];
                String[] strArr = f678b;
                int i8 = i7 | i5;
                strArr[i8] = f678b[i7] + '|' + f678b[i5];
                f678b[i8 | 8] = f678b[i7] + '|' + f678b[i5] + "|PADDED";
            }
        }
        for (int i9 = 0; i9 < f678b.length; i9++) {
            if (f678b[i9] == null) {
                f678b[i9] = f679c[i9];
            }
        }
    }

    private g() {
    }

    static IllegalArgumentException a(String str, Object... objArr) {
        throw new IllegalArgumentException(c.a(str, objArr));
    }

    static String a(boolean z, int i, int i2, byte b2, byte b3) {
        String str;
        String str2;
        String str3;
        String a2 = b2 < d.length ? d[b2] : c.a("0x%02x", Byte.valueOf(b2));
        if (b3 != 0) {
            switch (b2) {
                case 2:
                case 3:
                case 7:
                case 8:
                    str = f679c[b3];
                    break;
                case 4:
                case 6:
                    if (b3 != 1) {
                        str = f679c[b3];
                        break;
                    } else {
                        str = "ACK";
                        break;
                    }
                default:
                    String str4 = b3 < f678b.length ? f678b[b3] : f679c[b3];
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
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = a2;
        objArr[4] = str;
        return c.a("%s 0x%08x %5d %-13s %s", objArr);
    }

    static IOException b(String str, Object... objArr) {
        throw new IOException(c.a(str, objArr));
    }
}
