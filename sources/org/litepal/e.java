package org.litepal;

import java.util.List;
import org.litepal.e.b;
import org.litepal.e.d;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    int f4726a;

    /* renamed from: b  reason: collision with root package name */
    String f4727b;

    /* renamed from: c  reason: collision with root package name */
    String f4728c;
    private boolean d = false;
    private List<String> e;

    private e(String str, int i) {
        this.f4727b = str;
        this.f4726a = i;
    }

    private static e a(String str) {
        b a2 = d.a();
        e eVar = new e(str, a2.f4732a);
        eVar.f4728c = a2.d;
        eVar.e = a2.a();
        return eVar;
    }

    private void a(List<String> list) {
        this.e = list;
    }

    private void a(boolean z) {
        this.d = z;
    }

    private int b() {
        return this.f4726a;
    }

    private void b(String str) {
        this.f4728c = str;
    }

    private String c() {
        return this.f4727b;
    }

    private void c(String str) {
        a().add(str);
    }

    private String d() {
        return this.f4728c;
    }

    private boolean e() {
        return this.d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
        if (r2.e.isEmpty() != false) goto L_0x000b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> a() {
        /*
            r2 = this;
            java.util.List<java.lang.String> r0 = r2.e
            if (r0 != 0) goto L_0x0013
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r2.e = r0
        L_0x000b:
            java.util.List<java.lang.String> r0 = r2.e
            java.lang.String r1 = "org.litepal.model.Table_Schema"
            r0.add(r1)
            goto L_0x001c
        L_0x0013:
            java.util.List<java.lang.String> r0 = r2.e
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x001c
            goto L_0x000b
        L_0x001c:
            java.util.List<java.lang.String> r0 = r2.e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.e.a():java.util.List");
    }
}
