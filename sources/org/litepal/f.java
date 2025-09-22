package org.litepal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;
import java.util.Collection;
import java.util.List;
import org.litepal.b.a.d;
import org.litepal.b.a.g;
import org.litepal.b.e;
import org.litepal.b.i;
import org.litepal.b.j;
import org.litepal.b.k;
import org.litepal.f.a.a;
import org.litepal.g.b;
import org.litepal.g.c;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f4126a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private static a f4127b;

    public static double a(Class<?> cls, String str) {
        return a(org.litepal.g.a.a(c.a(cls.getName())), str);
    }

    public static double a(String str, String str2) {
        double a2;
        synchronized (e.class) {
            a2 = new b().a(str, str2);
        }
        return a2;
    }

    public static int a(Class<?> cls) {
        return d(org.litepal.g.a.a(c.a(cls.getName())));
    }

    public static int a(Class<?> cls, ContentValues contentValues, long j) {
        int a2;
        synchronized (e.class) {
            a2 = new k(org.litepal.f.c.a()).a(cls, j, contentValues);
        }
        return a2;
    }

    public static int a(Class<?> cls, ContentValues contentValues, String... strArr) {
        return a(org.litepal.g.a.a(c.a(cls.getName())), contentValues, strArr);
    }

    public static int a(Class<?> cls, String... strArr) {
        int a2;
        synchronized (e.class) {
            a2 = new org.litepal.b.c(org.litepal.f.c.a()).a(cls, strArr);
        }
        return a2;
    }

    public static int a(String str, ContentValues contentValues, String... strArr) {
        int a2;
        synchronized (e.class) {
            k kVar = new k(org.litepal.f.c.a());
            org.litepal.g.a.a(strArr);
            if (strArr != null && strArr.length > 0) {
                strArr[0] = c.e(strArr[0]);
            }
            k.a(contentValues);
            a2 = kVar.a(str, contentValues, strArr);
        }
        return a2;
    }

    public static int a(String str, String... strArr) {
        int a2;
        synchronized (e.class) {
            a2 = new org.litepal.b.c(org.litepal.f.c.a()).a(str, strArr);
        }
        return a2;
    }

    public static Handler a() {
        return f4126a;
    }

    public static <T> T a(Class<T> cls, long j) {
        return a(cls, j, false);
    }

    public static <T> T a(Class<T> cls, long j, boolean z) {
        T a2;
        synchronized (e.class) {
            a2 = new i(org.litepal.f.c.a()).a(cls, j, z);
        }
        return a2;
    }

    public static <T> T a(Class<?> cls, String str, Class<T> cls2) {
        return a(org.litepal.g.a.a(c.a(cls.getName())), str, cls2);
    }

    public static <T> T a(Class<T> cls, boolean z) {
        T a2;
        synchronized (e.class) {
            a2 = new i(org.litepal.f.c.a()).a(cls, z);
        }
        return a2;
    }

    public static <T> T a(String str, String str2, Class<T> cls) {
        T a2;
        synchronized (e.class) {
            a2 = new b().a(str, str2, cls);
        }
        return a2;
    }

    public static <T> List<T> a(Class<T> cls, boolean z, long... jArr) {
        List<T> a2;
        synchronized (e.class) {
            a2 = new i(org.litepal.f.c.a()).a(cls, z, jArr);
        }
        return a2;
    }

    public static <T> List<T> a(Class<T> cls, long... jArr) {
        return a(cls, false, jArr);
    }

    public static b a(int i) {
        b bVar = new b();
        bVar.d = String.valueOf(i);
        return bVar;
    }

    public static b a(String... strArr) {
        b bVar = new b();
        bVar.f4642a = strArr;
        return bVar;
    }

    public static void a(Context context) {
        LitePalApplication.f4125a = context;
    }

    public static <T extends e> void a(Collection<T> collection) {
        synchronized (e.class) {
            SQLiteDatabase a2 = org.litepal.f.c.a();
            a2.beginTransaction();
            try {
                new j(a2).b(collection);
                a2.setTransactionSuccessful();
                a2.endTransaction();
            } catch (Exception e) {
                throw new org.litepal.c.e(e.getMessage(), e);
            } catch (Throwable th) {
                a2.endTransaction();
                throw th;
            }
        }
    }

    public static void a(e eVar) {
        synchronized (e.class) {
            org.litepal.e.a a2 = org.litepal.e.a.a();
            a2.f4730b = eVar.f4727b;
            a2.f4729a = eVar.f4726a;
            a2.d = eVar.f4728c;
            a2.e = eVar.a();
            if (!g(eVar.f4727b)) {
                a2.f = eVar.f4727b;
                a2.f4731c = b.a.f4833c;
            }
            org.litepal.f.c.b();
        }
    }

    public static void a(a aVar) {
        f4127b = aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003d, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007a, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r4) {
        /*
            java.lang.Class<org.litepal.b.e> r0 = org.litepal.b.e.class
            monitor-enter(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x007e }
            if (r1 != 0) goto L_0x007b
            java.lang.String r1 = ".db"
            boolean r1 = r4.endsWith(r1)     // Catch:{ all -> 0x007e }
            if (r1 != 0) goto L_0x0022
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x007e }
            r1.<init>()     // Catch:{ all -> 0x007e }
            r1.append(r4)     // Catch:{ all -> 0x007e }
            java.lang.String r4 = ".db"
            r1.append(r4)     // Catch:{ all -> 0x007e }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x007e }
        L_0x0022:
            android.content.Context r1 = org.litepal.LitePalApplication.a()     // Catch:{ all -> 0x007e }
            java.io.File r1 = r1.getDatabasePath(r4)     // Catch:{ all -> 0x007e }
            boolean r2 = r1.exists()     // Catch:{ all -> 0x007e }
            if (r2 == 0) goto L_0x003e
            boolean r1 = r1.delete()     // Catch:{ all -> 0x007e }
            if (r1 == 0) goto L_0x003c
            f((java.lang.String) r4)     // Catch:{ all -> 0x007e }
            org.litepal.f.c.b()     // Catch:{ all -> 0x007e }
        L_0x003c:
            monitor-exit(r0)     // Catch:{ all -> 0x007e }
            return r1
        L_0x003e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x007e }
            r1.<init>()     // Catch:{ all -> 0x007e }
            android.content.Context r2 = org.litepal.LitePalApplication.a()     // Catch:{ all -> 0x007e }
            java.lang.String r3 = ""
            java.io.File r2 = r2.getExternalFilesDir(r3)     // Catch:{ all -> 0x007e }
            r1.append(r2)     // Catch:{ all -> 0x007e }
            java.lang.String r2 = "/databases/"
            r1.append(r2)     // Catch:{ all -> 0x007e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x007e }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x007e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x007e }
            r3.<init>()     // Catch:{ all -> 0x007e }
            r3.append(r1)     // Catch:{ all -> 0x007e }
            r3.append(r4)     // Catch:{ all -> 0x007e }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x007e }
            r2.<init>(r1)     // Catch:{ all -> 0x007e }
            boolean r1 = r2.delete()     // Catch:{ all -> 0x007e }
            if (r1 == 0) goto L_0x0079
            f((java.lang.String) r4)     // Catch:{ all -> 0x007e }
            org.litepal.f.c.b()     // Catch:{ all -> 0x007e }
        L_0x0079:
            monitor-exit(r0)     // Catch:{ all -> 0x007e }
            return r1
        L_0x007b:
            r4 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x007e }
            return r4
        L_0x007e:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007e }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.f.a(java.lang.String):boolean");
    }

    public static SQLiteDatabase b() {
        SQLiteDatabase a2;
        synchronized (e.class) {
            a2 = org.litepal.f.c.a();
        }
        return a2;
    }

    public static org.litepal.b.a.b b(Class<?> cls, String str) {
        return b(org.litepal.g.a.a(c.a(cls.getName())), str);
    }

    public static org.litepal.b.a.b b(final String str, final String str2) {
        final org.litepal.b.a.b bVar = new org.litepal.b.a.b();
        bVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final double a2 = f.a(str, str2);
                    if (bVar.f4686b != null) {
                        f.a().post(new Runnable() {
                            public final void run() {
                            }
                        });
                    }
                }
            }
        };
        return bVar;
    }

    public static org.litepal.b.a.c b(Class<?> cls) {
        return e(org.litepal.g.a.a(c.a(cls.getName())));
    }

    public static <T> d<T> b(Class<T> cls, long j) {
        return b(cls, j, false);
    }

    public static <T> d<T> b(Class<T> cls, long j, boolean z) {
        d<T> dVar = new d<>();
        final Class<T> cls2 = cls;
        final long j2 = j;
        final boolean z2 = z;
        final d<T> dVar2 = dVar;
        dVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final Object a2 = f.a(cls2, j2, z2);
                    if (dVar2.f4688b != null) {
                        f.a().post(new Runnable() {
                            public final void run() {
                            }
                        });
                    }
                }
            }
        };
        return dVar;
    }

    public static <T> d<T> b(Class<?> cls, String str, Class<T> cls2) {
        return b(org.litepal.g.a.a(c.a(cls.getName())), str, cls2);
    }

    public static <T> d<T> b(final Class<T> cls, final boolean z) {
        final d<T> dVar = new d<>();
        dVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final Object a2 = f.a(cls, z);
                    if (dVar.f4688b != null) {
                        f.a().post(new Runnable() {
                            public final void run() {
                            }
                        });
                    }
                }
            }
        };
        return dVar;
    }

    public static <T> d<T> b(final String str, final String str2, final Class<T> cls) {
        final d<T> dVar = new d<>();
        dVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final Object a2 = f.a(str, str2, cls);
                    if (dVar.f4688b != null) {
                        f.a().post(new Runnable() {
                            public final void run() {
                            }
                        });
                    }
                }
            }
        };
        return dVar;
    }

    public static <T> org.litepal.b.a.e<T> b(final Class<T> cls, final boolean z, final long... jArr) {
        final org.litepal.b.a.e<T> eVar = new org.litepal.b.a.e<>();
        eVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final List a2 = f.a(cls, z, jArr);
                    if (eVar.f4689b != null) {
                        f.a().post(new Runnable() {
                            public final void run() {
                            }
                        });
                    }
                }
            }
        };
        return eVar;
    }

    public static <T> org.litepal.b.a.e<T> b(Class<T> cls, long... jArr) {
        return b(cls, false, jArr);
    }

    public static <T extends e> org.litepal.b.a.f b(final Collection<T> collection) {
        final org.litepal.b.a.f fVar = new org.litepal.b.a.f();
        fVar.f4685a = new Runnable() {
            public final void run() {
                final boolean z;
                synchronized (e.class) {
                    try {
                        f.a(collection);
                        z = true;
                    } catch (Exception unused) {
                        z = false;
                    }
                    if (fVar.f4690b != null) {
                        f.a().post(new Runnable() {
                            public final void run() {
                            }
                        });
                    }
                }
            }
        };
        return fVar;
    }

    public static g b(Class<?> cls, ContentValues contentValues, long j) {
        g gVar = new g();
        final Class<?> cls2 = cls;
        final ContentValues contentValues2 = contentValues;
        final long j2 = j;
        final g gVar2 = gVar;
        gVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final int a2 = f.a((Class<?>) cls2, contentValues2, j2);
                    if (gVar2.f4691b != null) {
                        f.a().post(new Runnable() {
                            public final void run() {
                            }
                        });
                    }
                }
            }
        };
        return gVar;
    }

    public static g b(Class<?> cls, ContentValues contentValues, String... strArr) {
        return b(org.litepal.g.a.a(c.a(cls.getName())), contentValues, strArr);
    }

    public static g b(final Class<?> cls, final String... strArr) {
        final g gVar = new g();
        gVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final int a2 = f.a((Class<?>) cls, strArr);
                    if (gVar.f4691b != null) {
                        f.a().post(new Runnable() {
                            public final void run() {
                            }
                        });
                    }
                }
            }
        };
        return gVar;
    }

    public static g b(final String str, final ContentValues contentValues, final String... strArr) {
        final g gVar = new g();
        gVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final int a2 = f.a(str, contentValues, strArr);
                    if (gVar.f4691b != null) {
                        f.a().post(new Runnable() {
                            public final void run() {
                            }
                        });
                    }
                }
            }
        };
        return gVar;
    }

    public static g b(final String str, final String... strArr) {
        final g gVar = new g();
        gVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final int a2 = f.a(str, strArr);
                    if (gVar.f4691b != null) {
                        f.a().post(new Runnable() {
                            public final void run() {
                            }
                        });
                    }
                }
            }
        };
        return gVar;
    }

    public static b b(int i) {
        b bVar = new b();
        bVar.e = String.valueOf(i);
        return bVar;
    }

    public static b b(String... strArr) {
        b bVar = new b();
        bVar.f4643b = strArr;
        return bVar;
    }

    public static void b(String str) {
        org.litepal.g.a.b.f4829a = str;
    }

    public static int c(Class<?> cls, long j) {
        int a2;
        synchronized (e.class) {
            SQLiteDatabase a3 = org.litepal.f.c.a();
            a3.beginTransaction();
            try {
                a2 = new org.litepal.b.c(a3).a(cls, j);
                a3.setTransactionSuccessful();
            } finally {
                a3.endTransaction();
            }
        }
        return a2;
    }

    public static Cursor c(String... strArr) {
        synchronized (e.class) {
            org.litepal.g.a.a(strArr);
            String[] strArr2 = null;
            if (strArr == null) {
                return null;
            }
            if (strArr.length <= 0) {
                return null;
            }
            if (strArr.length != 1) {
                strArr2 = new String[(strArr.length - 1)];
                System.arraycopy(strArr, 1, strArr2, 0, strArr.length - 1);
            }
            Cursor rawQuery = org.litepal.f.c.a().rawQuery(strArr[0], strArr2);
            return rawQuery;
        }
    }

    public static <T> T c(Class<T> cls) {
        return a(cls, false);
    }

    public static <T> T c(Class<?> cls, String str, Class<T> cls2) {
        return c(org.litepal.g.a.a(c.a(cls.getName())), str, cls2);
    }

    public static <T> T c(Class<T> cls, boolean z) {
        T b2;
        synchronized (e.class) {
            b2 = new i(org.litepal.f.c.a()).b(cls, z);
        }
        return b2;
    }

    public static <T> T c(String str, String str2, Class<T> cls) {
        T b2;
        synchronized (e.class) {
            b2 = new b().b(str, str2, cls);
        }
        return b2;
    }

    public static b c(String str) {
        b bVar = new b();
        bVar.f4644c = str;
        return bVar;
    }

    public static void c() {
        synchronized (e.class) {
            org.litepal.e.a.c();
            org.litepal.f.c.b();
        }
    }

    public static <T extends e> void c(Collection<T> collection) {
        for (T clearSavedState : collection) {
            clearSavedState.clearSavedState();
        }
    }

    public static <T> boolean c(Class<T> cls, String... strArr) {
        return strArr != null && b(strArr).a(org.litepal.g.a.a(cls.getSimpleName())) > 0;
    }

    public static int d(String str) {
        int a2;
        synchronized (e.class) {
            a2 = new b().a(str);
        }
        return a2;
    }

    public static <T> d<T> d(Class<T> cls) {
        return b(cls, false);
    }

    public static <T> d<T> d(Class<?> cls, String str, Class<T> cls2) {
        return d(org.litepal.g.a.a(c.a(cls.getName())), str, cls2);
    }

    public static <T> d<T> d(final Class<T> cls, final boolean z) {
        final d<T> dVar = new d<>();
        dVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final Object c2 = f.c(cls, z);
                    if (dVar.f4688b != null) {
                        f.a().post(new Runnable() {
                            public final void run() {
                            }
                        });
                    }
                }
            }
        };
        return dVar;
    }

    public static <T> d<T> d(final String str, final String str2, final Class<T> cls) {
        final d<T> dVar = new d<>();
        dVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final Object c2 = f.c(str, str2, cls);
                    if (dVar.f4688b != null) {
                        f.a().post(new Runnable() {
                            public final void run() {
                            }
                        });
                    }
                }
            }
        };
        return dVar;
    }

    public static g d(final Class<?> cls, final long j) {
        final g gVar = new g();
        gVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final int c2 = f.c((Class<?>) cls, j);
                    if (gVar.f4691b != null) {
                        f.a().post(new Runnable() {
                            public final void run() {
                            }
                        });
                    }
                }
            }
        };
        return gVar;
    }

    public static a d() {
        return f4127b;
    }

    public static <T> T e(Class<T> cls) {
        return c(cls, false);
    }

    public static <T> T e(Class<?> cls, String str, Class<T> cls2) {
        return e(org.litepal.g.a.a(c.a(cls.getName())), str, cls2);
    }

    public static <T> T e(String str, String str2, Class<T> cls) {
        T c2;
        synchronized (e.class) {
            c2 = new b().c(str, str2, cls);
        }
        return c2;
    }

    public static org.litepal.b.a.c e(final String str) {
        final org.litepal.b.a.c cVar = new org.litepal.b.a.c();
        cVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final int d = f.d(str);
                    if (cVar.f4687b != null) {
                        f.a().post(new Runnable() {
                            public final void run() {
                            }
                        });
                    }
                }
            }
        };
        return cVar;
    }

    public static <T> d<T> f(Class<T> cls) {
        return d(cls, false);
    }

    public static <T> d<T> f(Class<?> cls, String str, Class<T> cls2) {
        return f(org.litepal.g.a.a(c.a(cls.getName())), str, cls2);
    }

    public static <T> d<T> f(final String str, final String str2, final Class<T> cls) {
        final d<T> dVar = new d<>();
        dVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final Object e = f.e(str, str2, cls);
                    if (dVar.f4688b != null) {
                        f.a().post(new Runnable() {
                            public final void run() {
                            }
                        });
                    }
                }
            }
        };
        return dVar;
    }

    private static void f(String str) {
        if (g(str)) {
            org.litepal.g.e.a((String) null);
        } else {
            org.litepal.g.e.a(str);
        }
    }

    private static boolean g(String str) {
        if (!org.litepal.g.a.a()) {
            return false;
        }
        if (!str.endsWith(b.a.f4831a)) {
            str = str + b.a.f4831a;
        }
        String str2 = org.litepal.e.d.a().f4733b;
        if (!str2.endsWith(b.a.f4831a)) {
            str2 = str2 + b.a.f4831a;
        }
        return str.equalsIgnoreCase(str2);
    }
}
