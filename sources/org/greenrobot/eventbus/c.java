package org.greenrobot.eventbus;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f4301a = "EventBus";

    /* renamed from: b  reason: collision with root package name */
    static volatile c f4302b;
    private static final d d = new d();
    private static final Map<Class<?>, List<Class<?>>> e = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final ExecutorService f4303c;
    private final Map<Class<?>, CopyOnWriteArrayList<n>> f;
    private final Map<Object, List<Class<?>>> g;
    private final Map<Class<?>, Object> h;
    private final ThreadLocal<b> i;
    private final f j;
    private final b k;
    private final a l;
    private final m m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private final boolean s;
    private final int t;

    interface a {
        void a();
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final List<Object> f4306a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        boolean f4307b;

        /* renamed from: c  reason: collision with root package name */
        boolean f4308c;
        n d;
        Object e;
        boolean f;

        b() {
        }
    }

    public c() {
        this(d);
    }

    c(d dVar) {
        this.i = new ThreadLocal<b>() {
            private static b a() {
                return new b();
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object initialValue() {
                return new b();
            }
        };
        this.f = new HashMap();
        this.g = new HashMap();
        this.h = new ConcurrentHashMap();
        this.j = new f(this, Looper.getMainLooper());
        this.k = new b(this);
        this.l = new a(this);
        this.t = dVar.k != null ? dVar.k.size() : 0;
        this.m = new m(dVar.k, dVar.h, dVar.g);
        this.o = dVar.f4309a;
        this.p = dVar.f4310b;
        this.q = dVar.f4311c;
        this.r = dVar.d;
        this.n = dVar.e;
        this.s = dVar.f;
        this.f4303c = dVar.i;
    }

    private <T> T a(Class<T> cls) {
        T cast;
        synchronized (this.h) {
            cast = cls.cast(this.h.get(cls));
        }
        return cast;
    }

    public static c a() {
        if (f4302b == null) {
            synchronized (c.class) {
                if (f4302b == null) {
                    f4302b = new c();
                }
            }
        }
        return f4302b;
    }

    private void a(Object obj, Class<?> cls) {
        List list = this.f.get(cls);
        if (list != null) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                n nVar = (n) list.get(i2);
                if (nVar.f4334a == obj) {
                    nVar.f4336c = false;
                    list.remove(i2);
                    i2--;
                    size--;
                }
                i2++;
            }
        }
    }

    private void a(Object obj, b bVar) throws Error {
        boolean z;
        Class<?> cls = obj.getClass();
        if (this.s) {
            List<Class<?>> d2 = d(cls);
            int size = d2.size();
            z = false;
            for (int i2 = 0; i2 < size; i2++) {
                z |= a(obj, bVar, d2.get(i2));
            }
        } else {
            z = a(obj, bVar, cls);
        }
        if (!z) {
            if (this.p) {
                String str = f4301a;
                Log.d(str, "No subscribers registered for event " + cls);
            }
            if (this.r && cls != g.class && cls != k.class) {
                c((Object) new g(this, obj));
            }
        }
    }

    private void a(Object obj, l lVar) {
        Class<?> cls = lVar.f4327c;
        n nVar = new n(obj, lVar);
        CopyOnWriteArrayList copyOnWriteArrayList = this.f.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.f.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(nVar)) {
            throw new e("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 > size) {
                break;
            } else if (i2 == size || lVar.d > ((n) copyOnWriteArrayList.get(i2)).f4335b.d) {
                copyOnWriteArrayList.add(i2, nVar);
            } else {
                i2++;
            }
        }
        copyOnWriteArrayList.add(i2, nVar);
        List list = this.g.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.g.put(obj, list);
        }
        list.add(cls);
        if (!lVar.e) {
            return;
        }
        if (this.s) {
            for (Map.Entry next : this.h.entrySet()) {
                if (cls.isAssignableFrom((Class) next.getKey())) {
                    a(nVar, next.getValue());
                }
            }
            return;
        }
        a(nVar, this.h.get(cls));
    }

    private static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, (Class<?>[]) cls.getInterfaces());
            }
        }
    }

    private void a(n nVar, Object obj) {
        if (obj != null) {
            a(nVar, obj, Looper.getMainLooper() == Looper.myLooper());
        }
    }

    private void a(n nVar, Object obj, Throwable th) {
        if (obj instanceof k) {
            if (this.o) {
                String str = f4301a;
                Log.e(str, "SubscriberExceptionEvent subscriber " + nVar.f4334a.getClass() + " threw an exception", th);
                k kVar = (k) obj;
                String str2 = f4301a;
                Log.e(str2, "Initial event " + kVar.f4324c + " caused exception in " + kVar.d, kVar.f4323b);
            }
        } else if (this.n) {
            throw new e("Invoking subscriber failed", th);
        } else {
            if (this.o) {
                String str3 = f4301a;
                Log.e(str3, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + nVar.f4334a.getClass(), th);
            }
            if (this.q) {
                c((Object) new k(this, th, obj, nVar.f4334a));
            }
        }
    }

    private void a(n nVar, Object obj, boolean z) {
        switch (nVar.f4335b.f4326b) {
            case POSTING:
                b(nVar, obj);
                return;
            case MAIN:
                if (z) {
                    b(nVar, obj);
                    return;
                }
                f fVar = this.j;
                h a2 = h.a(nVar, obj);
                synchronized (fVar) {
                    fVar.f4312a.a(a2);
                    if (!fVar.f4313b) {
                        fVar.f4313b = true;
                        if (!fVar.sendMessage(fVar.obtainMessage())) {
                            throw new e("Could not send handler message");
                        }
                    }
                }
                return;
            case BACKGROUND:
                if (z) {
                    b bVar = this.k;
                    h a3 = h.a(nVar, obj);
                    synchronized (bVar) {
                        bVar.f4298a.a(a3);
                        if (!bVar.f4300c) {
                            bVar.f4300c = true;
                            bVar.f4299b.f4303c.execute(bVar);
                        }
                    }
                    return;
                }
                b(nVar, obj);
                return;
            case ASYNC:
                a aVar = this.l;
                aVar.f4289a.a(h.a(nVar, obj));
                aVar.f4290b.f4303c.execute(aVar);
                return;
            default:
                throw new IllegalStateException("Unknown thread mode: " + nVar.f4335b.f4326b);
        }
    }

    private boolean a(Object obj, b bVar, Class<?> cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            n nVar = (n) it.next();
            bVar.e = obj;
            bVar.d = nVar;
            try {
                a(nVar, obj, bVar.f4308c);
                if (bVar.f) {
                    return true;
                }
            } finally {
                bVar.e = null;
                bVar.d = null;
                bVar.f = false;
            }
        }
        return true;
    }

    private <T> T b(Class<T> cls) {
        T cast;
        synchronized (this.h) {
            cast = cls.cast(this.h.remove(cls));
        }
        return cast;
    }

    private static d b() {
        return new d();
    }

    private void b(n nVar, Object obj) {
        try {
            nVar.f4335b.f4325a.invoke(nVar.f4334a, new Object[]{obj});
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (obj instanceof k) {
                if (this.o) {
                    String str = f4301a;
                    Log.e(str, "SubscriberExceptionEvent subscriber " + nVar.f4334a.getClass() + " threw an exception", cause);
                    k kVar = (k) obj;
                    String str2 = f4301a;
                    Log.e(str2, "Initial event " + kVar.f4324c + " caused exception in " + kVar.d, kVar.f4323b);
                }
            } else if (this.n) {
                throw new e("Invoking subscriber failed", cause);
            } else {
                if (this.o) {
                    String str3 = f4301a;
                    Log.e(str3, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + nVar.f4334a.getClass(), cause);
                }
                if (this.q) {
                    c((Object) new k(this, cause, obj, nVar.f4334a));
                }
            }
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException("Unexpected exception", e3);
        }
    }

    private static void c() {
        m.b();
        e.clear();
    }

    private boolean c(Class<?> cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        List<Class<?>> d2 = d(cls);
        if (d2 != null) {
            int size = d2.size();
            for (int i2 = 0; i2 < size; i2++) {
                Class cls2 = d2.get(i2);
                synchronized (this) {
                    copyOnWriteArrayList = this.f.get(cls2);
                }
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static List<Class<?>> d(Class<?> cls) {
        List<Class<?>> list;
        synchronized (e) {
            list = e.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a(list, (Class<?>[]) cls2.getInterfaces());
                }
                e.put(cls, list);
            }
        }
        return list;
    }

    private void d() {
        synchronized (this.h) {
            this.h.clear();
        }
    }

    private synchronized boolean d(Object obj) {
        return this.g.containsKey(obj);
    }

    private ExecutorService e() {
        return this.f4303c;
    }

    private void e(Object obj) {
        b bVar = this.i.get();
        if (!bVar.f4307b) {
            throw new e("This method may only be called from inside event handling methods on the posting thread");
        } else if (obj == null) {
            throw new e("Event may not be null");
        } else if (bVar.e != obj) {
            throw new e("Only the currently handled event may be aborted");
        } else if (bVar.d.f4335b.f4326b != ThreadMode.POSTING) {
            throw new e(" event handlers may only abort the incoming event");
        } else {
            bVar.f = true;
        }
    }

    private void f(Object obj) {
        synchronized (this.h) {
            this.h.put(obj.getClass(), obj);
        }
        c(obj);
    }

    private boolean g(Object obj) {
        synchronized (this.h) {
            Class<?> cls = obj.getClass();
            if (!obj.equals(this.h.get(cls))) {
                return false;
            }
            this.h.remove(cls);
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        if (r2.f == r3.a()) goto L_0x0074;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Class r0 = r10.getClass()
            org.greenrobot.eventbus.m r1 = r9.m
            java.util.Map<java.lang.Class<?>, java.util.List<org.greenrobot.eventbus.l>> r2 = org.greenrobot.eventbus.m.f4328a
            java.lang.Object r2 = r2.get(r0)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x0012
            goto L_0x00c3
        L_0x0012:
            boolean r2 = r1.f4330c
            if (r2 == 0) goto L_0x002f
            org.greenrobot.eventbus.m$a r2 = org.greenrobot.eventbus.m.a()
            r2.a(r0)
        L_0x001d:
            java.lang.Class<?> r3 = r2.f
            if (r3 == 0) goto L_0x0028
            r1.b((org.greenrobot.eventbus.m.a) r2)
            r2.a()
            goto L_0x001d
        L_0x0028:
            java.util.List r1 = org.greenrobot.eventbus.m.a((org.greenrobot.eventbus.m.a) r2)
            r2 = r1
            goto L_0x009f
        L_0x002f:
            org.greenrobot.eventbus.m$a r2 = org.greenrobot.eventbus.m.a()
            r2.a(r0)
        L_0x0036:
            java.lang.Class<?> r3 = r2.f
            if (r3 == 0) goto L_0x0028
            org.greenrobot.eventbus.a.c r3 = r2.h
            if (r3 == 0) goto L_0x0055
            org.greenrobot.eventbus.a.c r3 = r2.h
            org.greenrobot.eventbus.a.c r3 = r3.b()
            if (r3 == 0) goto L_0x0055
            org.greenrobot.eventbus.a.c r3 = r2.h
            org.greenrobot.eventbus.a.c r3 = r3.b()
            java.lang.Class<?> r4 = r2.f
            java.lang.Class r5 = r3.a()
            if (r4 != r5) goto L_0x0055
            goto L_0x0074
        L_0x0055:
            java.util.List<org.greenrobot.eventbus.a.d> r3 = r1.f4329b
            if (r3 == 0) goto L_0x0073
            java.util.List<org.greenrobot.eventbus.a.d> r3 = r1.f4329b
            java.util.Iterator r3 = r3.iterator()
        L_0x005f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0073
            java.lang.Object r4 = r3.next()
            org.greenrobot.eventbus.a.d r4 = (org.greenrobot.eventbus.a.d) r4
            org.greenrobot.eventbus.a.c r4 = r4.a()
            if (r4 == 0) goto L_0x005f
            r3 = r4
            goto L_0x0074
        L_0x0073:
            r3 = 0
        L_0x0074:
            r2.h = r3
            org.greenrobot.eventbus.a.c r3 = r2.h
            if (r3 == 0) goto L_0x0098
            org.greenrobot.eventbus.a.c r3 = r2.h
            org.greenrobot.eventbus.l[] r3 = r3.d()
            int r4 = r3.length
            r5 = 0
        L_0x0082:
            if (r5 >= r4) goto L_0x009b
            r6 = r3[r5]
            java.lang.reflect.Method r7 = r6.f4325a
            java.lang.Class<?> r8 = r6.f4327c
            boolean r7 = r2.a(r7, r8)
            if (r7 == 0) goto L_0x0095
            java.util.List<org.greenrobot.eventbus.l> r7 = r2.f4331a
            r7.add(r6)
        L_0x0095:
            int r5 = r5 + 1
            goto L_0x0082
        L_0x0098:
            r1.b((org.greenrobot.eventbus.m.a) r2)
        L_0x009b:
            r2.a()
            goto L_0x0036
        L_0x009f:
            boolean r1 = r2.isEmpty()
            if (r1 == 0) goto L_0x00be
            org.greenrobot.eventbus.e r10 = new org.greenrobot.eventbus.e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Subscriber "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = " and its super classes have no public methods with the @Subscribe annotation"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r10.<init>((java.lang.String) r0)
            throw r10
        L_0x00be:
            java.util.Map<java.lang.Class<?>, java.util.List<org.greenrobot.eventbus.l>> r1 = org.greenrobot.eventbus.m.f4328a
            r1.put(r0, r2)
        L_0x00c3:
            monitor-enter(r9)
            java.util.Iterator r0 = r2.iterator()     // Catch:{ all -> 0x00da }
        L_0x00c8:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x00da }
            if (r1 == 0) goto L_0x00d8
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x00da }
            org.greenrobot.eventbus.l r1 = (org.greenrobot.eventbus.l) r1     // Catch:{ all -> 0x00da }
            r9.a((java.lang.Object) r10, (org.greenrobot.eventbus.l) r1)     // Catch:{ all -> 0x00da }
            goto L_0x00c8
        L_0x00d8:
            monitor-exit(r9)     // Catch:{ all -> 0x00da }
            return
        L_0x00da:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x00da }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.c.a(java.lang.Object):void");
    }

    /* access modifiers changed from: package-private */
    public final void a(h hVar) {
        Object obj = hVar.f4317a;
        n nVar = hVar.f4318b;
        h.a(hVar);
        if (nVar.f4336c) {
            b(nVar, obj);
        }
    }

    public final synchronized void b(Object obj) {
        List<Class> list = this.g.get(obj);
        if (list != null) {
            for (Class cls : list) {
                List list2 = this.f.get(cls);
                if (list2 != null) {
                    int size = list2.size();
                    int i2 = 0;
                    while (i2 < size) {
                        n nVar = (n) list2.get(i2);
                        if (nVar.f4334a == obj) {
                            nVar.f4336c = false;
                            list2.remove(i2);
                            i2--;
                            size--;
                        }
                        i2++;
                    }
                }
            }
            this.g.remove(obj);
            return;
        }
        Log.w(f4301a, "Subscriber to unregister was not registered before: " + obj.getClass());
    }

    public final void c(Object obj) {
        boolean z;
        b bVar = this.i.get();
        List<Object> list = bVar.f4306a;
        list.add(obj);
        if (!bVar.f4307b) {
            bVar.f4308c = Looper.getMainLooper() == Looper.myLooper();
            bVar.f4307b = true;
            if (bVar.f) {
                throw new e("Internal error. Abort state was not reset");
            }
            while (!list.isEmpty()) {
                try {
                    Object remove = list.remove(0);
                    Class<?> cls = remove.getClass();
                    if (this.s) {
                        List<Class<?>> d2 = d(cls);
                        int size = d2.size();
                        z = false;
                        for (int i2 = 0; i2 < size; i2++) {
                            z |= a(remove, bVar, d2.get(i2));
                        }
                    } else {
                        z = a(remove, bVar, cls);
                    }
                    if (!z) {
                        if (this.p) {
                            String str = f4301a;
                            Log.d(str, "No subscribers registered for event " + cls);
                        }
                        if (!(!this.r || cls == g.class || cls == k.class)) {
                            c((Object) new g(this, remove));
                        }
                    }
                } finally {
                    bVar.f4307b = false;
                    bVar.f4308c = false;
                }
            }
        }
    }

    public String toString() {
        return "EventBus[indexCount=" + this.t + ", eventInheritance=" + this.s + "]";
    }
}
