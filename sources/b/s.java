package b;

import b.a.c;
import c.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public final class s extends ad {

    /* renamed from: a  reason: collision with root package name */
    private static final x f342a = x.a("application/x-www-form-urlencoded");

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f343b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f344c;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f345a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final List<String> f346b = new ArrayList();

        private a a(String str, String str2) {
            this.f345a.add(v.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            this.f346b.add(v.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            return this;
        }

        private s a() {
            return new s(this.f345a, this.f346b);
        }

        private a b(String str, String str2) {
            this.f345a.add(v.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            this.f346b.add(v.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            return this;
        }
    }

    s(List<String> list, List<String> list2) {
        this.f343b = c.a(list);
        this.f344c = c.a(list2);
    }

    private int a() {
        return this.f343b.size();
    }

    private long a(@Nullable d dVar, boolean z) {
        c.c cVar = z ? new c.c() : dVar.a();
        int size = this.f343b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                cVar.l(38);
            }
            cVar.b(this.f343b.get(i));
            cVar.l(61);
            cVar.b(this.f344c.get(i));
        }
        if (!z) {
            return 0;
        }
        long j = cVar.f387c;
        cVar.w();
        return j;
    }

    private String a(int i) {
        return this.f343b.get(i);
    }

    private String b(int i) {
        return v.a(this.f343b.get(i), true);
    }

    private String c(int i) {
        return this.f344c.get(i);
    }

    private String d(int i) {
        return v.a(this.f344c.get(i), true);
    }

    public final long contentLength() {
        return a((d) null, true);
    }

    public final x contentType() {
        return f342a;
    }

    public final void writeTo(d dVar) throws IOException {
        a(dVar, false);
    }
}
