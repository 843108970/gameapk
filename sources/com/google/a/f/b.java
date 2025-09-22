package com.google.a.f;

import com.google.a.c;
import com.google.a.e;
import com.google.a.m;
import com.google.a.p;
import com.google.a.q;
import com.google.a.r;
import com.google.a.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private static final int f3145a = 100;

    /* renamed from: b  reason: collision with root package name */
    private static final int f3146b = 4;

    /* renamed from: c  reason: collision with root package name */
    private final p f3147c;

    private b(p pVar) {
        this.f3147c = pVar;
    }

    private static r a(r rVar, int i, int i2) {
        t[] tVarArr = rVar.d;
        if (tVarArr == null) {
            return rVar;
        }
        t[] tVarArr2 = new t[tVarArr.length];
        for (int i3 = 0; i3 < tVarArr.length; i3++) {
            t tVar = tVarArr[i3];
            if (tVar != null) {
                tVarArr2[i3] = new t(tVar.f3356a + ((float) i), tVar.f3357b + ((float) i2));
            }
        }
        r rVar2 = new r(rVar.f3353a, rVar.f3354b, rVar.f3355c, tVarArr2, rVar.e, rVar.g);
        rVar2.a(rVar.f);
        return rVar2;
    }

    private void a(c cVar, Map<e, ?> map, List<r> list, int i, int i2, int i3) {
        boolean z;
        List<r> list2;
        float f;
        float f2;
        int i4;
        float f3;
        t[] tVarArr;
        r rVar;
        int i5 = i;
        c cVar2 = cVar;
        int i6 = i2;
        int i7 = i3;
        while (i7 <= 4) {
            try {
                Map<e, ?> map2 = map;
                r a2 = this.f3147c.a(cVar2, map2);
                Iterator<r> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().f3353a.equals(a2.f3353a)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    t[] tVarArr2 = a2.d;
                    if (tVarArr2 == null) {
                        list2 = list;
                        rVar = a2;
                    } else {
                        t[] tVarArr3 = new t[tVarArr2.length];
                        for (int i8 = 0; i8 < tVarArr2.length; i8++) {
                            t tVar = tVarArr2[i8];
                            if (tVar != null) {
                                tVarArr3[i8] = new t(tVar.f3356a + ((float) i5), tVar.f3357b + ((float) i6));
                            }
                        }
                        rVar = new r(a2.f3353a, a2.f3354b, a2.f3355c, tVarArr3, a2.e, a2.g);
                        rVar.a(a2.f);
                        list2 = list;
                    }
                    list2.add(rVar);
                } else {
                    list2 = list;
                }
                t[] tVarArr4 = a2.d;
                if (tVarArr4 != null && tVarArr4.length != 0) {
                    int a3 = cVar2.a();
                    int b2 = cVar2.b();
                    int length = tVarArr4.length;
                    float f4 = 0.0f;
                    float f5 = (float) b2;
                    float f6 = 0.0f;
                    float f7 = (float) a3;
                    int i9 = 0;
                    while (i9 < length) {
                        t tVar2 = tVarArr4[i9];
                        if (tVar2 != null) {
                            tVarArr = tVarArr4;
                            float f8 = tVar2.f3356a;
                            float f9 = tVar2.f3357b;
                            if (f8 < f7) {
                                f7 = f8;
                            }
                            if (f9 < f5) {
                                f5 = f9;
                            }
                            if (f8 <= f6) {
                                f8 = f6;
                            }
                            if (f9 > f4) {
                                f6 = f8;
                                f4 = f9;
                            } else {
                                f6 = f8;
                            }
                        } else {
                            tVarArr = tVarArr4;
                        }
                        i9++;
                        tVarArr4 = tVarArr;
                    }
                    if (f7 > 100.0f) {
                        f2 = f4;
                        i4 = i;
                        f = f6;
                        f3 = f5;
                        a(cVar2.a(0, 0, (int) f7, b2), map2, list2, i4, i6, i7 + 1);
                    } else {
                        f2 = f4;
                        f = f6;
                        f3 = f5;
                        i4 = i;
                    }
                    if (f3 > 100.0f) {
                        a(cVar2.a(0, 0, a3, (int) f3), map2, list2, i4, i6, i7 + 1);
                    }
                    float f10 = f;
                    if (f10 < ((float) (a3 - 100))) {
                        int i10 = (int) f10;
                        a(cVar2.a(i10, 0, a3 - i10, b2), map2, list2, i4 + i10, i6, i7 + 1);
                    }
                    float f11 = f2;
                    if (f11 < ((float) (b2 - 100))) {
                        int i11 = (int) f11;
                        cVar2 = cVar2.a(0, i11, a3, b2 - i11);
                        i6 += i11;
                        i7++;
                        i5 = i4;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } catch (q unused) {
                return;
            }
        }
    }

    public final r[] a_(c cVar) throws m {
        return b(cVar);
    }

    public final r[] b(c cVar) throws m {
        ArrayList arrayList = new ArrayList();
        a(cVar, (Map<e, ?>) null, arrayList, 0, 0, 0);
        if (!arrayList.isEmpty()) {
            return (r[]) arrayList.toArray(new r[arrayList.size()]);
        }
        throw m.getNotFoundInstance();
    }
}
