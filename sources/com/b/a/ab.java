package com.b.a;

import com.b.a.a.c;
import java.util.ArrayList;
import java.util.List;

public final class ab {

    /* renamed from: a  reason: collision with root package name */
    final List<String> f748a = new ArrayList(20);

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
                throw new NullPointerException("value == null");
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

    public final aa a() {
        return new aa(this);
    }

    public final ab a(String str) {
        int i = 0;
        while (i < this.f748a.size()) {
            if (str.equalsIgnoreCase(this.f748a.get(i))) {
                this.f748a.remove(i);
                this.f748a.remove(i);
                i -= 2;
            }
            i += 2;
        }
        return this;
    }

    public final ab a(String str, String str2) {
        d(str, str2);
        return b(str, str2);
    }

    /* access modifiers changed from: package-private */
    public final ab b(String str, String str2) {
        this.f748a.add(str);
        this.f748a.add(str2.trim());
        return this;
    }

    public final ab c(String str, String str2) {
        d(str, str2);
        a(str);
        b(str, str2);
        return this;
    }
}
