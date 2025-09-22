package com.android.volley;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class t {

    /* renamed from: a  reason: collision with root package name */
    public static String f503a = "Volley";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f504b = Log.isLoggable("Volley", 2);

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final boolean f505a = t.f504b;

        /* renamed from: b  reason: collision with root package name */
        private static final long f506b = 0;

        /* renamed from: c  reason: collision with root package name */
        private final List<C0007a> f507c = new ArrayList();
        private boolean d = false;

        /* renamed from: com.android.volley.t$a$a  reason: collision with other inner class name */
        private static class C0007a {

            /* renamed from: a  reason: collision with root package name */
            public final String f508a;

            /* renamed from: b  reason: collision with root package name */
            public final long f509b;

            /* renamed from: c  reason: collision with root package name */
            public final long f510c;

            public C0007a(String str, long j, long j2) {
                this.f508a = str;
                this.f509b = j;
                this.f510c = j2;
            }
        }

        a() {
        }

        private long a() {
            if (this.f507c.size() == 0) {
                return 0;
            }
            return this.f507c.get(this.f507c.size() - 1).f510c - this.f507c.get(0).f510c;
        }

        public final synchronized void a(String str) {
            long j;
            this.d = true;
            if (this.f507c.size() == 0) {
                j = 0;
            } else {
                j = this.f507c.get(this.f507c.size() - 1).f510c - this.f507c.get(0).f510c;
            }
            if (j > 0) {
                long j2 = this.f507c.get(0).f510c;
                t.b("(%-4d ms) %s", Long.valueOf(j), str);
                for (C0007a next : this.f507c) {
                    long j3 = next.f510c;
                    t.b("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(next.f509b), next.f508a);
                    j2 = j3;
                }
            }
        }

        public final synchronized void a(String str, long j) {
            if (this.d) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f507c.add(new C0007a(str, j, SystemClock.elapsedRealtime()));
        }

        /* access modifiers changed from: protected */
        public final void finalize() throws Throwable {
            if (!this.d) {
                a("Request on the loose");
                t.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }
    }

    private static void a(String str) {
        b("Changing log tag to %s", str);
        f503a = str;
        f504b = Log.isLoggable(str, 2);
    }

    public static void a(String str, Object... objArr) {
        if (f504b) {
            Log.v(f503a, e(str, objArr));
        }
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(f503a, e(str, objArr), th);
    }

    public static void b(String str, Object... objArr) {
        Log.d(f503a, e(str, objArr));
    }

    private static void b(Throwable th, String str, Object... objArr) {
        Log.wtf(f503a, e(str, objArr), th);
    }

    public static void c(String str, Object... objArr) {
        Log.e(f503a, e(str, objArr));
    }

    public static void d(String str, Object... objArr) {
        Log.wtf(f503a, e(str, objArr));
    }

    private static String e(String str, Object... objArr) {
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str2 = "<unknown>";
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                break;
            } else if (!stackTrace[i].getClass().equals(t.class)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }
}
