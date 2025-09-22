package com.bumptech.glide.load.b.b;

import android.util.Log;
import com.bumptech.glide.b.a;
import com.bumptech.glide.load.b.b.a;
import com.bumptech.glide.load.b.b.c;
import com.bumptech.glide.load.g;
import java.io.File;
import java.io.IOException;

public final class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1066a = "DiskLruCacheWrapper";

    /* renamed from: b  reason: collision with root package name */
    private static final int f1067b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f1068c = 1;
    private static e d;
    private final m e;
    private final File f;
    private final long g;
    private final c h = new c();
    private a i;

    @Deprecated
    e(File file, long j) {
        this.f = file;
        this.g = j;
        this.e = new m();
    }

    @Deprecated
    private static synchronized a a(File file, long j) {
        e eVar;
        synchronized (e.class) {
            if (d == null) {
                d = new e(file, j);
            }
            eVar = d;
        }
        return eVar;
    }

    private synchronized a b() throws IOException {
        if (this.i == null) {
            this.i = a.a(this.f, this.g);
        }
        return this.i;
    }

    private static a b(File file, long j) {
        return new e(file, j);
    }

    private synchronized void c() {
        this.i = null;
    }

    public final File a(g gVar) {
        String a2 = this.e.a(gVar);
        if (Log.isLoggable(f1066a, 2)) {
            Log.v(f1066a, "Get: Obtained: " + a2 + " for for Key: " + gVar);
        }
        try {
            a.d a3 = b().a(a2);
            if (a3 != null) {
                return a3.f903a[0];
            }
        } catch (IOException e2) {
            if (Log.isLoggable(f1066a, 5)) {
                Log.w(f1066a, "Unable to get from disk cache", e2);
            }
        }
        return null;
    }

    public final synchronized void a() {
        try {
            b().a();
            c();
        } catch (IOException e2) {
            try {
                if (Log.isLoggable(f1066a, 5)) {
                    Log.w(f1066a, "Unable to clear disk cache or disk cache cleared externally", e2);
                }
                c();
            } catch (Throwable th) {
                c();
                throw th;
            }
        }
    }

    public final void a(g gVar, a.b bVar) {
        c.a aVar;
        a.b a2;
        String a3 = this.e.a(gVar);
        c cVar = this.h;
        synchronized (cVar) {
            aVar = cVar.f1056a.get(a3);
            if (aVar == null) {
                aVar = cVar.f1057b.a();
                cVar.f1056a.put(a3, aVar);
            }
            aVar.f1059b++;
        }
        aVar.f1058a.lock();
        try {
            if (Log.isLoggable(f1066a, 2)) {
                Log.v(f1066a, "Put: Obtained: " + a3 + " for for Key: " + gVar);
            }
            try {
                com.bumptech.glide.b.a b2 = b();
                if (b2.a(a3) == null) {
                    a2 = b2.a(a3, -1);
                    if (a2 == null) {
                        throw new IllegalStateException("Had two simultaneous puts for: " + a3);
                    }
                    if (bVar.a(a2.a(0))) {
                        com.bumptech.glide.b.a.this.a(a2, true);
                        a2.f899c = true;
                    }
                    a2.b();
                }
            } catch (IOException e2) {
                if (Log.isLoggable(f1066a, 5)) {
                    Log.w(f1066a, "Unable to put to disk cache", e2);
                }
            } catch (Throwable th) {
                a2.b();
                throw th;
            }
        } finally {
            this.h.a(a3);
        }
    }

    public final void b(g gVar) {
        try {
            b().b(this.e.a(gVar));
        } catch (IOException e2) {
            if (Log.isLoggable(f1066a, 5)) {
                Log.w(f1066a, "Unable to delete from disk cache", e2);
            }
        }
    }
}
