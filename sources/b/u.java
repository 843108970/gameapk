package b;

import b.a.c;
import b.a.d.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.annotation.Nullable;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public final String[] f350a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final List<String> f351a = new ArrayList(20);

        private a d(String str) {
            int indexOf = str.indexOf(":");
            if (indexOf != -1) {
                return a(str.substring(0, indexOf).trim(), str.substring(indexOf + 1));
            }
            throw new IllegalArgumentException("Unexpected header: " + str);
        }

        private static void d(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            } else {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt <= ' ' || charAt >= 127) {
                        throw new IllegalArgumentException(c.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                    }
                }
                if (str2 == null) {
                    throw new NullPointerException("value for name " + str + " == null");
                }
                int length2 = str2.length();
                int i2 = 0;
                while (i2 < length2) {
                    char charAt2 = str2.charAt(i2);
                    if ((charAt2 > 31 || charAt2 == 9) && charAt2 < 127) {
                        i2++;
                    } else {
                        throw new IllegalArgumentException(c.a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i2), str, str2));
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final a a(String str) {
            int indexOf = str.indexOf(":", 1);
            return indexOf != -1 ? b(str.substring(0, indexOf), str.substring(indexOf + 1)) : str.startsWith(":") ? b("", str.substring(1)) : b("", str);
        }

        public final a a(String str, String str2) {
            d(str, str2);
            return b(str, str2);
        }

        public final u a() {
            return new u(this);
        }

        public final a b(String str) {
            int i = 0;
            while (i < this.f351a.size()) {
                if (str.equalsIgnoreCase(this.f351a.get(i))) {
                    this.f351a.remove(i);
                    this.f351a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public final a b(String str, String str2) {
            this.f351a.add(str);
            this.f351a.add(str2.trim());
            return this;
        }

        public final a c(String str, String str2) {
            d(str, str2);
            b(str);
            b(str, str2);
            return this;
        }

        public final String c(String str) {
            for (int size = this.f351a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.f351a.get(size))) {
                    return this.f351a.get(size + 1);
                }
            }
            return null;
        }
    }

    u(a aVar) {
        this.f350a = (String[]) aVar.f351a.toArray(new String[aVar.f351a.size()]);
    }

    private u(String[] strArr) {
        this.f350a = strArr;
    }

    private static u a(Map<String, String> map) {
        if (map == null) {
            throw new NullPointerException("headers == null");
        }
        String[] strArr = new String[(map.size() * 2)];
        int i = 0;
        for (Map.Entry next : map.entrySet()) {
            if (next.getKey() == null || next.getValue() == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            String trim = ((String) next.getKey()).trim();
            String trim2 = ((String) next.getValue()).trim();
            if (trim.length() != 0 && trim.indexOf(0) == -1 && trim2.indexOf(0) == -1) {
                strArr[i] = trim;
                strArr[i + 1] = trim2;
                i += 2;
            } else {
                throw new IllegalArgumentException("Unexpected header: " + trim + ": " + trim2);
            }
        }
        return new u(strArr);
    }

    public static u a(String... strArr) {
        String[] strArr2 = (String[]) strArr.clone();
        for (int i = 0; i < strArr2.length; i++) {
            if (strArr2[i] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i] = strArr2[i].trim();
        }
        int i2 = 0;
        while (i2 < strArr2.length) {
            String str = strArr2[i2];
            String str2 = strArr2[i2 + 1];
            if (str.length() != 0 && str.indexOf(0) == -1 && str2.indexOf(0) == -1) {
                i2 += 2;
            } else {
                throw new IllegalArgumentException("Unexpected header: " + str + ": " + str2);
            }
        }
        return new u(strArr2);
    }

    private static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    @Nullable
    private Date c(String str) {
        String a2 = a(str);
        if (a2 != null) {
            return d.a(a2);
        }
        return null;
    }

    private Set<String> d() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int length = this.f350a.length / 2;
        for (int i = 0; i < length; i++) {
            treeSet.add(a(i));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    public final int a() {
        return this.f350a.length / 2;
    }

    public final String a(int i) {
        return this.f350a[i * 2];
    }

    @Nullable
    public final String a(String str) {
        String[] strArr = this.f350a;
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public final a b() {
        a aVar = new a();
        Collections.addAll(aVar.f351a, this.f350a);
        return aVar;
    }

    public final String b(int i) {
        return this.f350a[(i * 2) + 1];
    }

    public final List<String> b(String str) {
        int length = this.f350a.length / 2;
        ArrayList arrayList = null;
        for (int i = 0; i < length; i++) {
            if (str.equalsIgnoreCase(a(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(b(i));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public final Map<String, List<String>> c() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int length = this.f350a.length / 2;
        for (int i = 0; i < length; i++) {
            String lowerCase = a(i).toLowerCase(Locale.US);
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(b(i));
        }
        return treeMap;
    }

    public final boolean equals(@Nullable Object obj) {
        return (obj instanceof u) && Arrays.equals(((u) obj).f350a, this.f350a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f350a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int length = this.f350a.length / 2;
        for (int i = 0; i < length; i++) {
            sb.append(a(i));
            sb.append(": ");
            sb.append(b(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}
