package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

class e {

    /* renamed from: b  reason: collision with root package name */
    private static SQLiteOpenHelper f3605b;
    private static Context d;

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f3606a;

    /* renamed from: c  reason: collision with root package name */
    private SQLiteDatabase f3607c;

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final e f3608a = new e();

        private a() {
        }
    }

    private e() {
        this.f3606a = new AtomicInteger();
    }

    public static e a(Context context) {
        if (d == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            d = applicationContext;
            f3605b = d.a(applicationContext);
        }
        return a.f3608a;
    }

    public synchronized SQLiteDatabase a() {
        if (this.f3606a.incrementAndGet() == 1) {
            this.f3607c = f3605b.getWritableDatabase();
        }
        return this.f3607c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0014, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b() {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicInteger r0 = r1.f3606a     // Catch:{ Throwable -> 0x0013, all -> 0x0010 }
            int r0 = r0.decrementAndGet()     // Catch:{ Throwable -> 0x0013, all -> 0x0010 }
            if (r0 != 0) goto L_0x000e
            android.database.sqlite.SQLiteDatabase r0 = r1.f3607c     // Catch:{ Throwable -> 0x0013, all -> 0x0010 }
            r0.close()     // Catch:{ Throwable -> 0x0013, all -> 0x0010 }
        L_0x000e:
            monitor-exit(r1)
            return
        L_0x0010:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        L_0x0013:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.e.b():void");
    }
}
