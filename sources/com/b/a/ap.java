package com.b.a;

import com.b.a.a.c.g;
import com.github.kevinsawicki.http.HttpRequest;

public final class ap {

    /* renamed from: a  reason: collision with root package name */
    ac f778a;

    /* renamed from: b  reason: collision with root package name */
    String f779b;

    /* renamed from: c  reason: collision with root package name */
    ab f780c;
    aq d;
    Object e;

    public ap() {
        this.f779b = HttpRequest.METHOD_GET;
        this.f780c = new ab();
    }

    ap(ao aoVar) {
        this.f778a = aoVar.f775a;
        this.f779b = aoVar.f776b;
        this.d = aoVar.d;
        this.e = aoVar.e;
        this.f780c = aoVar.f777c.b();
    }

    public final ao a() {
        if (this.f778a != null) {
            return new ao(this);
        }
        throw new IllegalStateException("url == null");
    }

    public final ap a(aa aaVar) {
        this.f780c = aaVar.b();
        return this;
    }

    public final ap a(ac acVar) {
        if (acVar == null) {
            throw new NullPointerException("url == null");
        }
        this.f778a = acVar;
        return this;
    }

    public final ap a(aq aqVar) {
        return a("POST", aqVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.b.a.ap a(java.lang.String r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x000a
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r0 = "url == null"
            r8.<init>(r0)
            throw r8
        L_0x000a:
            r2 = 1
            r3 = 0
            java.lang.String r4 = "ws:"
            r5 = 0
            r6 = 3
            r1 = r8
            boolean r0 = r1.regionMatches(r2, r3, r4, r5, r6)
            if (r0 == 0) goto L_0x002b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "http:"
            r0.<init>(r1)
            r1 = 3
        L_0x001f:
            java.lang.String r8 = r8.substring(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            goto L_0x0041
        L_0x002b:
            r1 = 1
            r2 = 0
            java.lang.String r3 = "wss:"
            r4 = 0
            r5 = 4
            r0 = r8
            boolean r0 = r0.regionMatches(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0041
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "https:"
            r0.<init>(r1)
            r1 = 4
            goto L_0x001f
        L_0x0041:
            com.b.a.ac r0 = com.b.a.ac.e(r8)
            if (r0 != 0) goto L_0x005b
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "unexpected url: "
            r1.<init>(r2)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        L_0x005b:
            com.b.a.ap r8 = r7.a((com.b.a.ac) r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.ap.a(java.lang.String):com.b.a.ap");
    }

    public final ap a(String str, aq aqVar) {
        if (str == null) {
            throw new NullPointerException("method == null");
        } else if (str.length() == 0) {
            throw new IllegalArgumentException("method.length() == 0");
        } else if (aqVar != null && !g.b(str)) {
            throw new IllegalArgumentException("method " + str + " must not have a request body.");
        } else if (aqVar != null || !g.a(str)) {
            this.f779b = str;
            this.d = aqVar;
            return this;
        } else {
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        }
    }

    public final ap a(String str, String str2) {
        this.f780c.c(str, str2);
        return this;
    }

    public final ap b(String str) {
        this.f780c.a(str);
        return this;
    }
}
