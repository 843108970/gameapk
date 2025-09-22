package org.litepal.e;

import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public int f4732a;

    /* renamed from: b  reason: collision with root package name */
    public String f4733b;

    /* renamed from: c  reason: collision with root package name */
    String f4734c;
    public String d;
    private List<String> e;

    private void a(int i) {
        this.f4732a = i;
    }

    private void a(String str) {
        this.f4733b = str;
    }

    private void a(List<String> list) {
        this.e = list;
    }

    private int b() {
        return this.f4732a;
    }

    private void b(String str) {
        this.d = str;
    }

    private String c() {
        return this.f4733b;
    }

    private void c(String str) {
        a().add(str);
    }

    private String d() {
        return this.d;
    }

    private void d(String str) {
        this.f4734c = str;
    }

    private String e() {
        return this.f4734c;
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
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.e.b.a():java.util.List");
    }
}
