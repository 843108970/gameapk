package mobi.oneway.export.f;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mobi.oneway.export.enums.AdType;
import mobi.oneway.export.f.c;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static List<c> f4194a;

    /* renamed from: b  reason: collision with root package name */
    private static List<g> f4195b;

    /* renamed from: c  reason: collision with root package name */
    private static String f4196c;

    public static String a() {
        return f4196c;
    }

    public static List<a> a(String str, AdType adType) {
        List<a> list;
        if (f4194a != null) {
            Iterator<c> it = f4194a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                c next = it.next();
                if (str.equals(next.a())) {
                    list = a(next.b(), str, adType);
                    break;
                }
            }
        }
        list = null;
        return list == null ? b(str) : list;
    }

    public static List<String> a(List<a> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (a f : list) {
                arrayList.add(f.f());
            }
        }
        return arrayList;
    }

    private static List<a> a(List<c.a> list, String str, AdType adType) {
        ArrayList arrayList = null;
        if (f4194a != null) {
            if (list == null) {
                return null;
            }
            for (c.a next : list) {
                int a2 = next.a();
                g a3 = a(a2);
                if (a3 != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    a aVar = new a(a3, str, a2 == 1 ? str : next.b());
                    if (aVar.d(adType)) {
                        arrayList.add(aVar);
                    }
                }
            }
        }
        return arrayList;
    }

    public static a a(List<a> list, String str) {
        if (list == null) {
            return null;
        }
        Iterator<a> it = list.iterator();
        if (!it.hasNext()) {
            return null;
        }
        a next = it.next();
        if (next.f().equals(str)) {
            return next;
        }
        return null;
    }

    private static g a(int i) {
        if (f4195b == null) {
            return null;
        }
        for (g next : f4195b) {
            if (next.a() == i) {
                return next;
            }
        }
        return null;
    }

    public static void a(String str) {
        f4196c = str;
    }

    public static void a(c cVar) {
        if (f4194a == null) {
            f4194a = new ArrayList();
        }
        f4194a.add(cVar);
    }

    public static void a(g gVar) {
        if (f4195b == null) {
            f4195b = new ArrayList();
        }
        f4195b.add(gVar);
    }

    private static List<a> b(String str) {
        g a2 = a(1);
        if (a2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a(a2, str, str));
        return arrayList;
    }
}
