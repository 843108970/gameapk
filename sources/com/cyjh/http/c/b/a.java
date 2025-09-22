package com.cyjh.http.c.b;

import android.content.Context;
import com.cyjh.http.bean.request.UpdateRequestInfo;
import com.cyjh.http.bean.response.VersionUpdateInfo;
import com.cyjh.http.c.a.b;
import com.cyjh.http.c.c.d;
import com.cyjh.http.c.d.j;
import com.cyjh.http.d.b.c;

public final class a implements b, j {

    /* renamed from: a  reason: collision with root package name */
    public static final int f2479a = 2;

    /* renamed from: b  reason: collision with root package name */
    public static final int f2480b = 3;
    private static a e;

    /* renamed from: c  reason: collision with root package name */
    public C0039a f2481c;
    private d d;

    /* renamed from: com.cyjh.http.c.b.a$a  reason: collision with other inner class name */
    public interface C0039a {
        void a(VersionUpdateInfo versionUpdateInfo);

        void b(VersionUpdateInfo versionUpdateInfo);

        void c(VersionUpdateInfo versionUpdateInfo);
    }

    private a() {
    }

    public static a a() {
        if (e == null) {
            e = new a();
        }
        return e;
    }

    private a a(C0039a aVar) {
        this.f2481c = aVar;
        return this;
    }

    private void a(boolean z, Context context) {
        this.d = new d(context, this, z);
        this.d.a(context);
    }

    public final void a(VersionUpdateInfo versionUpdateInfo) {
        if (this.f2481c != null) {
            this.f2481c.a(versionUpdateInfo);
        }
    }

    public final void a(boolean z, Context context, UpdateRequestInfo updateRequestInfo) {
        this.d = new d(context, this, z, updateRequestInfo);
        this.d.a(context);
    }

    public final void b() {
        this.f2481c.a((VersionUpdateInfo) null);
    }

    public final void b(VersionUpdateInfo versionUpdateInfo) {
        if (this.f2481c != null) {
            this.f2481c.b(versionUpdateInfo);
        }
    }

    public final void c() {
        this.f2481c.a((VersionUpdateInfo) null);
    }

    public final void c(VersionUpdateInfo versionUpdateInfo) {
        if (this.f2481c != null) {
            this.f2481c.c(versionUpdateInfo);
        }
    }

    public final void d() {
        if (this.d != null) {
            c.a().a((Object) this.d.getClass().getCanonicalName());
        }
    }
}
