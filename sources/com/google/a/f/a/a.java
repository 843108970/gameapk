package com.google.a.f.a;

import com.google.a.c.e;
import com.google.a.c.g;
import com.google.a.f.c;
import com.google.a.i.a.i;
import com.google.a.m;
import com.google.a.q;
import com.google.a.r;
import com.google.a.s;
import com.google.a.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a extends com.google.a.i.a implements c {

    /* renamed from: b  reason: collision with root package name */
    private static final r[] f3142b = new r[0];

    /* renamed from: c  reason: collision with root package name */
    private static final t[] f3143c = new t[0];

    /* renamed from: com.google.a.f.a.a$a  reason: collision with other inner class name */
    private static final class C0051a implements Serializable, Comparator<r> {
        private C0051a() {
        }

        public final int compare(r rVar, r rVar2) {
            return Integer.compare(((Integer) rVar.f.get(s.STRUCTURED_APPEND_SEQUENCE)).intValue(), ((Integer) rVar2.f.get(s.STRUCTURED_APPEND_SEQUENCE)).intValue());
        }
    }

    private static List<r> a(List<r> list) {
        boolean z;
        Iterator<r> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().f.containsKey(s.STRUCTURED_APPEND_SEQUENCE)) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<r> arrayList2 = new ArrayList<>();
        for (r next : list) {
            arrayList.add(next);
            if (next.f.containsKey(s.STRUCTURED_APPEND_SEQUENCE)) {
                arrayList2.add(next);
            }
        }
        Collections.sort(arrayList2, new C0051a());
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int i2 = 0;
        for (r rVar : arrayList2) {
            sb.append(rVar.f3353a);
            i += rVar.f3354b.length;
            if (rVar.f.containsKey(s.BYTE_SEGMENTS)) {
                for (byte[] length : (Iterable) rVar.f.get(s.BYTE_SEGMENTS)) {
                    i2 += length.length;
                }
            }
        }
        byte[] bArr = new byte[i];
        byte[] bArr2 = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        for (r rVar2 : arrayList2) {
            System.arraycopy(rVar2.f3354b, 0, bArr, i3, rVar2.f3354b.length);
            i3 += rVar2.f3354b.length;
            if (rVar2.f.containsKey(s.BYTE_SEGMENTS)) {
                for (byte[] bArr3 : (Iterable) rVar2.f.get(s.BYTE_SEGMENTS)) {
                    System.arraycopy(bArr3, 0, bArr2, i4, bArr3.length);
                    i4 += bArr3.length;
                }
            }
        }
        r rVar3 = new r(sb.toString(), bArr, f3143c, com.google.a.a.QR_CODE);
        if (i2 > 0) {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(bArr2);
            rVar3.a(s.BYTE_SEGMENTS, arrayList3);
        }
        arrayList.add(rVar3);
        return arrayList;
    }

    public final r[] a_(com.google.a.c cVar) throws m {
        return b(cVar);
    }

    public final r[] b(com.google.a.c cVar) throws m {
        ArrayList arrayList = new ArrayList();
        for (g gVar : new com.google.a.f.a.a.a(cVar.c()).a()) {
            try {
                e a2 = this.f3294a.a(gVar.d, (Map<com.google.a.e, ?>) null);
                t[] tVarArr = gVar.e;
                if (a2.h instanceof i) {
                    ((i) a2.h).a(tVarArr);
                }
                r rVar = new r(a2.f3077c, a2.f3075a, tVarArr, com.google.a.a.QR_CODE);
                List<byte[]> list = a2.d;
                if (list != null) {
                    rVar.a(s.BYTE_SEGMENTS, list);
                }
                String str = a2.e;
                if (str != null) {
                    rVar.a(s.ERROR_CORRECTION_LEVEL, str);
                }
                if (a2.a()) {
                    rVar.a(s.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(a2.j));
                    rVar.a(s.STRUCTURED_APPEND_PARITY, Integer.valueOf(a2.i));
                }
                arrayList.add(rVar);
            } catch (q unused) {
            }
        }
        if (arrayList.isEmpty()) {
            return f3142b;
        }
        List<r> a3 = a(arrayList);
        return (r[]) a3.toArray(new r[a3.size()]);
    }
}
