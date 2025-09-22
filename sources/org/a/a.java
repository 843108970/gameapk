package org.a;

import java.util.Arrays;
import java.util.Iterator;
import org.a.b.d;

public abstract class a implements g {
    private <T> g a(String str, String str2, String str3, Iterator<T> it) {
        return b(str, str2, str3, (Iterator<? extends m>) new d(it));
    }

    private static String b(Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Exception unused) {
            return obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode());
        }
    }

    private g b(String str, String str2, String str3, Iterator<? extends m> it) {
        b(str);
        boolean z = false;
        while (it.hasNext()) {
            if (z) {
                b(str2);
            }
            a((m) it.next());
            z = true;
        }
        b(str3);
        return this;
    }

    private void b(char c2) {
        String str;
        if (c2 == 13) {
            str = "\\r";
        } else if (c2 != '\"') {
            switch (c2) {
                case 9:
                    str = "\\t";
                    break;
                case 10:
                    str = "\\n";
                    break;
                default:
                    a(c2);
                    return;
            }
        } else {
            str = "\\\"";
        }
        b(str);
    }

    private void c(String str) {
        a('\"');
        for (int i = 0; i < str.length(); i++) {
            b(str.charAt(i));
        }
        a('\"');
    }

    public final g a(Object obj) {
        String str;
        if (obj == null) {
            str = "null";
        } else {
            if (obj instanceof String) {
                String str2 = (String) obj;
                a('\"');
                for (int i = 0; i < str2.length(); i++) {
                    b(str2.charAt(i));
                }
            } else if (obj instanceof Character) {
                a('\"');
                b(((Character) obj).charValue());
            } else if (obj instanceof Short) {
                a('<');
                b(b(obj));
                str = "s>";
            } else if (obj instanceof Long) {
                a('<');
                b(b(obj));
                str = "L>";
            } else if (obj instanceof Float) {
                a('<');
                b(b(obj));
                str = "F>";
            } else if (obj.getClass().isArray()) {
                a("[", ", ", "]", new org.a.b.a(obj));
                return this;
            } else {
                a('<');
                b(b(obj));
                a('>');
                return this;
            }
            a('\"');
            return this;
        }
        b(str);
        return this;
    }

    public final g a(String str) {
        b(str);
        return this;
    }

    public final <T> g a(String str, String str2, String str3, Iterable<T> iterable) {
        return a(str, str2, str3, iterable.iterator());
    }

    public final <T> g a(String str, String str2, String str3, T... tArr) {
        return a(str, str2, str3, Arrays.asList(tArr).iterator());
    }

    public final g a(m mVar) {
        mVar.describeTo(this);
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract void a(char c2);

    public final g b(String str, String str2, String str3, Iterable<? extends m> iterable) {
        return b(str, str2, str3, iterable.iterator());
    }

    /* access modifiers changed from: protected */
    public void b(String str) {
        for (int i = 0; i < str.length(); i++) {
            a(str.charAt(i));
        }
    }
}
