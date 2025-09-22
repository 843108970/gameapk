package com.umeng.commonsdk.proguard;

import com.umeng.commonsdk.proguard.at;

public class bc {

    /* renamed from: a  reason: collision with root package name */
    private static int f3744a = Integer.MAX_VALUE;

    public static bb a(byte[] bArr, bb bbVar) {
        return bArr[0] > 16 ? new at.a() : (bArr.length <= 1 || (bArr[1] & 128) == 0) ? bbVar : new at.a();
    }

    public static void a(int i) {
        f3744a = i;
    }

    public static void a(az azVar, byte b2) throws ag {
        a(azVar, b2, f3744a);
    }

    public static void a(az azVar, byte b2, int i) throws ag {
        if (i <= 0) {
            throw new ag("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b2) {
            case 2:
                azVar.t();
                return;
            case 3:
                azVar.u();
                return;
            case 4:
                azVar.y();
                return;
            case 6:
                azVar.v();
                return;
            case 8:
                azVar.w();
                return;
            case 10:
                azVar.x();
                return;
            case 11:
                azVar.A();
                return;
            case 12:
                azVar.j();
                while (true) {
                    au l = azVar.l();
                    if (l.f3725b != 0) {
                        a(azVar, l.f3725b, i - 1);
                        azVar.m();
                    } else {
                        azVar.k();
                        return;
                    }
                }
            case 13:
                aw n = azVar.n();
                while (i2 < n.f3731c) {
                    int i3 = i - 1;
                    a(azVar, n.f3729a, i3);
                    a(azVar, n.f3730b, i3);
                    i2++;
                }
                azVar.o();
                return;
            case 14:
                bd r = azVar.r();
                while (i2 < r.f3746b) {
                    a(azVar, r.f3745a, i - 1);
                    i2++;
                }
                azVar.s();
                return;
            case 15:
                av p = azVar.p();
                while (i2 < p.f3728b) {
                    a(azVar, p.f3727a, i - 1);
                    i2++;
                }
                azVar.q();
                return;
            default:
                return;
        }
    }
}
