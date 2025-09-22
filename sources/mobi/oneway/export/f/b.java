package mobi.oneway.export.f;

import java.util.HashMap;
import java.util.Map;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, Long> f4188a = new HashMap();

    public static long a(int i, String str, String str2) {
        Long l = f4188a.get(i + "-" + str + str2);
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }

    public static void a(int i, String str, String str2, long j) {
        f4188a.put(i + "-" + str + str2, Long.valueOf(j));
    }
}
