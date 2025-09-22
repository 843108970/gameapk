package org.litepal;

import java.util.List;
import org.litepal.b.a.d;
import org.litepal.b.e;
import org.litepal.b.i;
import org.litepal.g.a;
import org.litepal.g.c;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String[] f4642a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f4643b;

    /* renamed from: c  reason: collision with root package name */
    public String f4644c;
    public String d;
    public String e;

    private double a(Class<?> cls, String str) {
        return a(a.a(cls.getSimpleName()), str);
    }

    private <T> T a(Class<?> cls, String str, Class<T> cls2) {
        return a(a.a(cls.getSimpleName()), str, cls2);
    }

    private <T> List<T> a(Class<T> cls) {
        return a(cls, false);
    }

    private b a(int i) {
        this.d = String.valueOf(i);
        return this;
    }

    private b a(String... strArr) {
        this.f4642a = strArr;
        return this;
    }

    private org.litepal.b.a.b b(Class<?> cls, final String str) {
        final String a2 = a.a(c.a(cls.getName()));
        final org.litepal.b.a.b bVar = new org.litepal.b.a.b();
        bVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final double a2 = b.this.a(r3, r4);
                    if (r0.f4686b != null) {
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

    private org.litepal.b.a.b b(final String str, final String str2) {
        final org.litepal.b.a.b bVar = new org.litepal.b.a.b();
        bVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final double a2 = b.this.a(str, str2);
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

    private <T> d<T> b(Class<?> cls, String str, Class<T> cls2) {
        final String a2 = a.a(c.a(cls.getName()));
        d<T> dVar = new d<>();
        final String str2 = str;
        final Class<T> cls3 = cls2;
        final d<T> dVar2 = dVar;
        dVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final Object a2 = b.this.a(r2, r3, r4);
                    if (r5.f4688b != null) {
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

    private <T> org.litepal.b.a.e<T> b(final Class<T> cls) {
        final org.litepal.b.a.e<T> eVar = new org.litepal.b.a.e<>();
        eVar.f4685a = new Runnable() {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f4646b = false;

            public final void run() {
                synchronized (e.class) {
                    final List a2 = b.this.a(r3, this.f4646b);
                    if (r0.f4689b != null) {
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

    private b b(int i) {
        this.e = String.valueOf(i);
        return this;
    }

    private b b(String str) {
        this.f4644c = str;
        return this;
    }

    private b b(String... strArr) {
        this.f4643b = strArr;
        return this;
    }

    private <T> T c(Class<?> cls, String str, Class<T> cls2) {
        return b(a.a(cls.getSimpleName()), str, cls2);
    }

    private org.litepal.b.a.c c(final String str) {
        final org.litepal.b.a.c cVar = new org.litepal.b.a.c();
        cVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final int a2 = b.this.a(r3);
                    if (r0.f4687b != null) {
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

    private <T> org.litepal.b.a.e<T> c(final Class<T> cls) {
        final org.litepal.b.a.e<T> eVar = new org.litepal.b.a.e<>();
        eVar.f4685a = new Runnable() {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f4646b = false;

            public final void run() {
                synchronized (e.class) {
                    final List a2 = b.this.a(cls, this.f4646b);
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

    private <T> T d(Class<T> cls) {
        return b(cls, false);
    }

    private <T> d<T> d(Class<?> cls, String str, Class<T> cls2) {
        final String a2 = a.a(c.a(cls.getName()));
        d<T> dVar = new d<>();
        final String str2 = str;
        final Class<T> cls3 = cls2;
        final d<T> dVar2 = dVar;
        dVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final Object b2 = b.this.b(r2, r3, r4);
                    if (r5.f4688b != null) {
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

    private <T> d<T> d(String str, String str2, Class<T> cls) {
        d<T> dVar = new d<>();
        final String str3 = str;
        final String str4 = str2;
        final Class<T> cls2 = cls;
        final d<T> dVar2 = dVar;
        dVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final Object a2 = b.this.a(str3, str4, cls2);
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

    private <T> T e(Class<?> cls, String str, Class<T> cls2) {
        return c(a.a(cls.getSimpleName()), str, cls2);
    }

    private <T> d<T> e(final Class<T> cls) {
        final d<T> dVar = new d<>();
        dVar.f4685a = new Runnable() {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f4651b = false;

            public final void run() {
                synchronized (e.class) {
                    final Object b2 = b.this.b(r3, this.f4651b);
                    if (r0.f4688b != null) {
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

    private <T> d<T> e(String str, String str2, Class<T> cls) {
        d<T> dVar = new d<>();
        final String str3 = str;
        final String str4 = str2;
        final Class<T> cls2 = cls;
        final d<T> dVar2 = dVar;
        dVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final Object b2 = b.this.b(str3, str4, cls2);
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

    private <T> d<T> f(final Class<T> cls) {
        final d<T> dVar = new d<>();
        dVar.f4685a = new Runnable() {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f4651b = false;

            public final void run() {
                synchronized (e.class) {
                    final Object b2 = b.this.b(cls, this.f4651b);
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

    private <T> d<T> f(Class<?> cls, String str, Class<T> cls2) {
        final String a2 = a.a(c.a(cls.getName()));
        d<T> dVar = new d<>();
        final String str2 = str;
        final Class<T> cls3 = cls2;
        final d<T> dVar2 = dVar;
        dVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final Object c2 = b.this.c(r2, r3, r4);
                    if (r5.f4688b != null) {
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

    private <T> d<T> f(String str, String str2, Class<T> cls) {
        d<T> dVar = new d<>();
        final String str3 = str;
        final String str4 = str2;
        final Class<T> cls2 = cls;
        final d<T> dVar2 = dVar;
        dVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final Object c2 = b.this.c(str3, str4, cls2);
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

    private <T> T g(Class<T> cls) {
        return c(cls, false);
    }

    private <T> d<T> h(final Class<T> cls) {
        final d<T> dVar = new d<>();
        dVar.f4685a = new Runnable() {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f4656b = false;

            public final void run() {
                synchronized (e.class) {
                    final Object c2 = b.this.c(r3, this.f4656b);
                    if (r0.f4688b != null) {
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

    private <T> d<T> i(final Class<T> cls) {
        final d<T> dVar = new d<>();
        dVar.f4685a = new Runnable() {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f4656b = false;

            public final void run() {
                synchronized (e.class) {
                    final Object c2 = b.this.c(cls, this.f4656b);
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

    private int j(Class<?> cls) {
        return a(a.a(cls.getSimpleName()));
    }

    private org.litepal.b.a.c k(Class<?> cls) {
        final String a2 = a.a(c.a(cls.getName()));
        final org.litepal.b.a.c cVar = new org.litepal.b.a.c();
        cVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final int a2 = b.this.a(a2);
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

    public final double a(String str, String str2) {
        double a2;
        synchronized (e.class) {
            a2 = new i(org.litepal.f.c.a()).a(str, str2, this.f4643b);
        }
        return a2;
    }

    public final int a(String str) {
        int a2;
        synchronized (e.class) {
            a2 = new i(org.litepal.f.c.a()).a(str, this.f4643b);
        }
        return a2;
    }

    public final <T> T a(String str, String str2, Class<T> cls) {
        T a2;
        synchronized (e.class) {
            a2 = new i(org.litepal.f.c.a()).a(str, str2, this.f4643b, cls);
        }
        return a2;
    }

    public final <T> List<T> a(Class<T> cls, boolean z) {
        String str;
        List<T> a2;
        synchronized (e.class) {
            i iVar = new i(org.litepal.f.c.a());
            if (this.e == null) {
                str = this.d;
            } else {
                if (this.d == null) {
                    this.d = "0";
                }
                str = this.e + "," + this.d;
            }
            a2 = iVar.a(cls, this.f4642a, this.f4643b, this.f4644c, str, z);
        }
        return a2;
    }

    public final <T> T b(Class<T> cls, boolean z) {
        synchronized (e.class) {
            List<T> a2 = a(cls, z);
            if (a2.size() <= 0) {
                return null;
            }
            T t = a2.get(0);
            return t;
        }
    }

    public final <T> T b(String str, String str2, Class<T> cls) {
        T b2;
        synchronized (e.class) {
            b2 = new i(org.litepal.f.c.a()).b(str, str2, this.f4643b, cls);
        }
        return b2;
    }

    public final <T> T c(Class<T> cls, boolean z) {
        synchronized (e.class) {
            List<T> a2 = a(cls, z);
            int size = a2.size();
            if (size <= 0) {
                return null;
            }
            T t = a2.get(size - 1);
            return t;
        }
    }

    public final <T> T c(String str, String str2, Class<T> cls) {
        T c2;
        synchronized (e.class) {
            c2 = new i(org.litepal.f.c.a()).c(str, str2, this.f4643b, cls);
        }
        return c2;
    }
}
