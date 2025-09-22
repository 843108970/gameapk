package com.google.a.g;

import com.google.a.c;
import com.google.a.c.a;
import com.google.a.d;
import com.google.a.e;
import com.google.a.h;
import com.google.a.m;
import com.google.a.p;
import com.google.a.q;
import com.google.a.s;
import com.google.a.t;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public abstract class r implements p {
    protected static float a(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = (float) i;
        float f3 = f2 / ((float) i2);
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f6 = ((float) iArr2[i4]) * f3;
            float f7 = (float) i5;
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }

    protected static void a(a aVar, int i, int[] iArr) throws m {
        int length = iArr.length;
        Arrays.fill(iArr, 0, length, 0);
        int i2 = aVar.f3055b;
        if (i >= i2) {
            throw m.getNotFoundInstance();
        }
        boolean z = !aVar.a(i);
        int i3 = 0;
        while (i < i2) {
            if (aVar.a(i) == z) {
                i3++;
                if (i3 == length) {
                    break;
                }
                iArr[i3] = 1;
                z = !z;
            } else {
                iArr[i3] = iArr[i3] + 1;
            }
            i++;
        }
        if (i3 == length) {
            return;
        }
        if (i3 != length - 1 || i != i2) {
            throw m.getNotFoundInstance();
        }
    }

    private com.google.a.r b(c cVar, Map<e, ?> map) throws m {
        int i;
        int i2;
        int i3;
        int i4;
        Map<e, ?> map2 = map;
        int a2 = cVar.a();
        int b2 = cVar.b();
        a aVar = new a(a2);
        int i5 = 1;
        boolean z = map2 != null && map2.containsKey(e.TRY_HARDER);
        int max = Math.max(1, b2 >> (z ? 8 : 5));
        int i6 = z ? b2 : 15;
        int i7 = b2 / 2;
        EnumMap enumMap = map2;
        int i8 = 0;
        while (i8 < i6) {
            int i9 = i8 + 1;
            int i10 = i9 / 2;
            if (!((i8 & 1) == 0)) {
                i10 = -i10;
            }
            int i11 = (i10 * max) + i7;
            if (i11 < 0 || i11 >= b2) {
                break;
            }
            try {
                a a3 = cVar.f3052a.a(i11, aVar);
                int i12 = 0;
                while (i12 < 2) {
                    if (i12 == i5) {
                        a3.c();
                        if (enumMap != null && enumMap.containsKey(e.NEED_RESULT_POINT_CALLBACK)) {
                            EnumMap enumMap2 = new EnumMap(e.class);
                            enumMap2.putAll(enumMap);
                            enumMap2.remove(e.NEED_RESULT_POINT_CALLBACK);
                            enumMap = enumMap2;
                        }
                    }
                    try {
                        com.google.a.r a4 = a(i11, a3, enumMap);
                        if (i12 == i5) {
                            a4.a(s.ORIENTATION, 180);
                            t[] tVarArr = a4.d;
                            if (tVarArr != null) {
                                float f = (float) a2;
                                i4 = a2;
                                try {
                                    i3 = b2;
                                    try {
                                        tVarArr[0] = new t((f - tVarArr[0].f3356a) - 1.0f, tVarArr[0].f3357b);
                                        try {
                                            tVarArr[1] = new t((f - tVarArr[1].f3356a) - 1.0f, tVarArr[1].f3357b);
                                        } catch (q unused) {
                                            continue;
                                        }
                                    } catch (q unused2) {
                                        i12++;
                                        a2 = i4;
                                        b2 = i3;
                                        c cVar2 = cVar;
                                        i5 = 1;
                                    }
                                } catch (q unused3) {
                                    i3 = b2;
                                    i12++;
                                    a2 = i4;
                                    b2 = i3;
                                    c cVar22 = cVar;
                                    i5 = 1;
                                }
                            }
                        }
                        return a4;
                    } catch (q unused4) {
                        i4 = a2;
                        i3 = b2;
                        i12++;
                        a2 = i4;
                        b2 = i3;
                        c cVar222 = cVar;
                        i5 = 1;
                    }
                }
                i2 = a2;
                i = b2;
                aVar = a3;
            } catch (m unused5) {
                i2 = a2;
                i = b2;
            }
            i8 = i9;
            a2 = i2;
            b2 = i;
            i5 = 1;
        }
        throw m.getNotFoundInstance();
    }

    protected static void b(a aVar, int i, int[] iArr) throws m {
        int length = iArr.length;
        boolean a2 = aVar.a(i);
        while (i > 0 && length >= 0) {
            i--;
            if (aVar.a(i) != a2) {
                length--;
                a2 = !a2;
            }
        }
        if (length >= 0) {
            throw m.getNotFoundInstance();
        }
        a(aVar, i + 1, iArr);
    }

    public abstract com.google.a.r a(int i, a aVar, Map<e, ?> map) throws m, d, h;

    public com.google.a.r a(c cVar) throws m, h {
        return a(cVar, (Map<e, ?>) null);
    }

    public com.google.a.r a(c cVar, Map<e, ?> map) throws m, h {
        try {
            return b(cVar, map);
        } catch (m e) {
            if (!(map != null && map.containsKey(e.TRY_HARDER)) || !cVar.f3052a.f3002a.c()) {
                throw e;
            }
            c cVar2 = new c(cVar.f3052a.a(cVar.f3052a.f3002a.e()));
            com.google.a.r b2 = b(cVar2, map);
            Map<s, Object> map2 = b2.f;
            int i = 270;
            if (map2 != null && map2.containsKey(s.ORIENTATION)) {
                i = (((Integer) map2.get(s.ORIENTATION)).intValue() + 270) % 360;
            }
            b2.a(s.ORIENTATION, Integer.valueOf(i));
            t[] tVarArr = b2.d;
            if (tVarArr != null) {
                int b3 = cVar2.b();
                for (int i2 = 0; i2 < tVarArr.length; i2++) {
                    tVarArr[i2] = new t((((float) b3) - tVarArr[i2].f3357b) - 1.0f, tVarArr[i2].f3356a);
                }
            }
            return b2;
        }
    }

    public void a() {
    }
}
