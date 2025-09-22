package b.a.d;

import android.support.v7.widget.ActivityChooserView;
import b.a.c;
import b.ac;
import b.ae;
import b.h;
import b.m;
import b.n;
import b.u;
import b.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Marker;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f79a = "([^ \"=]*)";

    /* renamed from: b  reason: collision with root package name */
    private static final String f80b = "\"([^\"]*)\"";

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f81c = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    private e() {
    }

    public static int a(String str, int i) {
        while (i < str.length() && ((r0 = str.charAt(i)) == ' ' || r0 == 9)) {
            i++;
        }
        return i;
    }

    public static int a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static long a(ae aeVar) {
        return a(aeVar.f);
    }

    public static long a(u uVar) {
        return a(uVar.a("Content-Length"));
    }

    private static long a(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private static u a(u uVar, u uVar2) {
        Set<String> c2 = c(uVar2);
        if (c2.isEmpty()) {
            return new u.a().a();
        }
        u.a aVar = new u.a();
        int length = uVar.f350a.length / 2;
        for (int i = 0; i < length; i++) {
            String a2 = uVar.a(i);
            if (c2.contains(a2)) {
                aVar.a(a2, uVar.b(i));
            }
        }
        return aVar.a();
    }

    public static List<h> a(u uVar, String str) {
        ArrayList arrayList = new ArrayList();
        for (String next : uVar.b(str)) {
            int indexOf = next.indexOf(32);
            if (indexOf != -1) {
                Matcher matcher = f81c.matcher(next);
                int i = indexOf;
                while (true) {
                    if (!matcher.find(i)) {
                        break;
                    }
                    if (next.regionMatches(true, matcher.start(1), "realm", 0, 5)) {
                        String substring = next.substring(0, indexOf);
                        String group = matcher.group(3);
                        if (group != null) {
                            arrayList.add(new h(substring, group));
                            break;
                        }
                    }
                    i = matcher.end();
                }
            }
        }
        return arrayList;
    }

    public static void a(n nVar, v vVar, u uVar) {
        if (nVar != n.f335a && !m.a(vVar, uVar).isEmpty()) {
            nVar.a();
        }
    }

    public static boolean a(ae aeVar, u uVar, ac acVar) {
        for (String next : c(aeVar.f)) {
            if (!c.a((Object) uVar.b(next), (Object) acVar.f249c.b(next))) {
                return false;
            }
        }
        return true;
    }

    public static int b(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static boolean b(ae aeVar) {
        return c(aeVar.f).contains(Marker.ANY_MARKER);
    }

    private static boolean b(u uVar) {
        return c(uVar).contains(Marker.ANY_MARKER);
    }

    public static u c(ae aeVar) {
        u uVar = aeVar.h.f260a.f249c;
        Set<String> c2 = c(aeVar.f);
        if (c2.isEmpty()) {
            return new u.a().a();
        }
        u.a aVar = new u.a();
        int length = uVar.f350a.length / 2;
        for (int i = 0; i < length; i++) {
            String a2 = uVar.a(i);
            if (c2.contains(a2)) {
                aVar.a(a2, uVar.b(i));
            }
        }
        return aVar.a();
    }

    private static Set<String> c(u uVar) {
        Set<String> emptySet = Collections.emptySet();
        int length = uVar.f350a.length / 2;
        Set<String> set = emptySet;
        for (int i = 0; i < length; i++) {
            if ("Vary".equalsIgnoreCase(uVar.a(i))) {
                String b2 = uVar.b(i);
                if (set.isEmpty()) {
                    set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
                }
                for (String trim : b2.split(",")) {
                    set.add(trim.trim());
                }
            }
        }
        return set;
    }

    public static boolean d(ae aeVar) {
        if (aeVar.f260a.f248b.equals("HEAD")) {
            return false;
        }
        int i = aeVar.f262c;
        return (((i >= 100 && i < 200) || i == 204 || i == 304) && a(aeVar.f) == -1 && !"chunked".equalsIgnoreCase(aeVar.a("Transfer-Encoding"))) ? false : true;
    }

    private static Set<String> e(ae aeVar) {
        return c(aeVar.f);
    }
}
