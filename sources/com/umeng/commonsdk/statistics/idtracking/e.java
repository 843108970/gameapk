package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.proguard.aa;
import com.umeng.commonsdk.proguard.ad;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.proto.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final long f3902a = 86400000;

    /* renamed from: b  reason: collision with root package name */
    public static e f3903b;
    private static Object j = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final String f3904c = "umeng_it.cache";
    private File d;
    private c e = null;
    private long f;
    private long g;
    private Set<a> h = new HashSet();
    private a i = null;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f3905a;

        /* renamed from: b  reason: collision with root package name */
        private Set<String> f3906b = new HashSet();

        public a(Context context) {
            this.f3905a = context;
        }

        public synchronized void a() {
            if (!this.f3906b.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (String append : this.f3906b) {
                    sb.append(append);
                    sb.append(',');
                }
                sb.deleteCharAt(sb.length() - 1);
                PreferenceWrapper.getDefault(this.f3905a).edit().putString("invld_id", sb.toString()).commit();
            }
        }

        public synchronized boolean a(String str) {
            return !this.f3906b.contains(str);
        }

        public synchronized void b() {
            String[] split;
            String string = PreferenceWrapper.getDefault(this.f3905a).getString("invld_id", (String) null);
            if (!TextUtils.isEmpty(string) && (split = string.split(",")) != null) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f3906b.add(str);
                    }
                }
            }
        }

        public synchronized void b(String str) {
            this.f3906b.add(str);
        }

        public void c(String str) {
            this.f3906b.remove(str);
        }
    }

    e(Context context) {
        this.d = new File(context.getFilesDir(), "umeng_it.cache");
        this.g = 86400000;
        this.i = new a(context);
        this.i.b();
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (f3903b == null) {
                e eVar2 = new e(context);
                f3903b = eVar2;
                eVar2.a((a) new f(context));
                f3903b.a((a) new b(context));
                f3903b.a((a) new s(context));
                f3903b.a((a) new d(context));
                f3903b.a((a) new c(context));
                f3903b.a((a) new h(context));
                f3903b.a((a) new k());
                f3903b.a((a) new t(context));
                r rVar = new r(context);
                if (!TextUtils.isEmpty(rVar.f())) {
                    f3903b.a((a) rVar);
                }
                j jVar = new j(context);
                if (jVar.g()) {
                    f3903b.a((a) jVar);
                    f3903b.a((a) new i(context));
                    jVar.i();
                }
                f3903b.a((a) new q(context));
                f3903b.a((a) new n(context));
                f3903b.a((a) new p(context));
                f3903b.a((a) new o(context));
                f3903b.a((a) new m(context));
                f3903b.a((a) new l(context));
                f3903b.e();
            }
            eVar = f3903b;
        }
        return eVar;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private void a(com.umeng.commonsdk.statistics.proto.c r3) {
        /*
            r2 = this;
            java.lang.Object r0 = j
            monitor-enter(r0)
            if (r3 == 0) goto L_0x0021
            monitor-enter(r2)     // Catch:{ Exception -> 0x001d }
            com.umeng.commonsdk.proguard.aj r1 = new com.umeng.commonsdk.proguard.aj     // Catch:{ all -> 0x0018 }
            r1.<init>()     // Catch:{ all -> 0x0018 }
            byte[] r3 = r1.a(r3)     // Catch:{ all -> 0x0018 }
            monitor-exit(r2)     // Catch:{ all -> 0x0018 }
            if (r3 == 0) goto L_0x0021
            java.io.File r1 = r2.d     // Catch:{ Exception -> 0x001d }
            com.umeng.commonsdk.statistics.common.HelperUtils.writeFile((java.io.File) r1, (byte[]) r3)     // Catch:{ Exception -> 0x001d }
            goto L_0x0021
        L_0x0018:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0018 }
            throw r3     // Catch:{ Exception -> 0x001d }
        L_0x001b:
            r3 = move-exception
            goto L_0x0023
        L_0x001d:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x001b }
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            return
        L_0x0023:
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.e.a(com.umeng.commonsdk.statistics.proto.c):void");
    }

    private boolean a(a aVar) {
        if (this.i.a(aVar.b())) {
            return this.h.add(aVar);
        }
        if (!b.f) {
            return false;
        }
        MLog.w("invalid domain: " + aVar.b());
        return false;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private synchronized void g() {
        /*
            r7 = this;
            monitor-enter(r7)
            com.umeng.commonsdk.statistics.proto.c r0 = new com.umeng.commonsdk.statistics.proto.c     // Catch:{ all -> 0x0060 }
            r0.<init>()     // Catch:{ all -> 0x0060 }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x0060 }
            r1.<init>()     // Catch:{ all -> 0x0060 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0060 }
            r2.<init>()     // Catch:{ all -> 0x0060 }
            java.util.Set<com.umeng.commonsdk.statistics.idtracking.a> r3 = r7.h     // Catch:{ all -> 0x0060 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0060 }
        L_0x0016:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0060 }
            if (r4 == 0) goto L_0x0051
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0060 }
            com.umeng.commonsdk.statistics.idtracking.a r4 = (com.umeng.commonsdk.statistics.idtracking.a) r4     // Catch:{ all -> 0x0060 }
            boolean r5 = r4.c()     // Catch:{ all -> 0x0060 }
            if (r5 == 0) goto L_0x0016
            com.umeng.commonsdk.statistics.proto.b r5 = r4.d()     // Catch:{ all -> 0x0060 }
            if (r5 == 0) goto L_0x0039
            java.lang.String r5 = r4.b()     // Catch:{ all -> 0x0060 }
            com.umeng.commonsdk.statistics.proto.b r6 = r4.d()     // Catch:{ all -> 0x0060 }
            r1.put(r5, r6)     // Catch:{ all -> 0x0060 }
        L_0x0039:
            java.util.List r5 = r4.e()     // Catch:{ all -> 0x0060 }
            if (r5 == 0) goto L_0x0016
            java.util.List r5 = r4.e()     // Catch:{ all -> 0x0060 }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0060 }
            if (r5 != 0) goto L_0x0016
            java.util.List r4 = r4.e()     // Catch:{ all -> 0x0060 }
            r2.addAll(r4)     // Catch:{ all -> 0x0060 }
            goto L_0x0016
        L_0x0051:
            r0.a((java.util.List<com.umeng.commonsdk.statistics.proto.a>) r2)     // Catch:{ all -> 0x0060 }
            r0.a((java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.b>) r1)     // Catch:{ all -> 0x0060 }
            monitor-enter(r7)     // Catch:{ all -> 0x0060 }
            r7.e = r0     // Catch:{ all -> 0x005d }
            monitor-exit(r7)     // Catch:{ all -> 0x005d }
            monitor-exit(r7)
            return
        L_0x005d:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x005d }
            throw r0     // Catch:{ all -> 0x0060 }
        L_0x0060:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.e.g():void");
    }

    private c h() {
        FileInputStream fileInputStream;
        synchronized (j) {
            if (!this.d.exists()) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(this.d);
                try {
                    byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(fileInputStream);
                    c cVar = new c();
                    new ad().a((aa) cVar, readStreamToByteArray);
                    HelperUtils.safeClose((InputStream) fileInputStream);
                    return cVar;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        HelperUtils.safeClose((InputStream) fileInputStream);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        HelperUtils.safeClose((InputStream) fileInputStream);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
                e.printStackTrace();
                HelperUtils.safeClose((InputStream) fileInputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                HelperUtils.safeClose((InputStream) fileInputStream);
                throw th;
            }
        }
    }

    public synchronized void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f >= this.g) {
            boolean z = false;
            for (a next : this.h) {
                if (next.c() && next.a()) {
                    z = true;
                    if (!next.c()) {
                        this.i.b(next.b());
                    }
                }
            }
            if (z) {
                g();
                this.i.a();
                f();
            }
            this.f = currentTimeMillis;
        }
    }

    public void a(long j2) {
        this.g = j2;
    }

    public synchronized c b() {
        return this.e;
    }

    public String c() {
        return null;
    }

    public synchronized void d() {
        boolean z = false;
        for (a next : this.h) {
            if (next.c() && next.e() != null && !next.e().isEmpty()) {
                next.a((List<com.umeng.commonsdk.statistics.proto.a>) null);
                z = true;
            }
        }
        if (z) {
            this.e.b(false);
            f();
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized void e() {
        /*
            r4 = this;
            monitor-enter(r4)
            com.umeng.commonsdk.statistics.proto.c r0 = r4.h()     // Catch:{ all -> 0x0057 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r4)
            return
        L_0x0009:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0057 }
            java.util.Set<com.umeng.commonsdk.statistics.idtracking.a> r2 = r4.h     // Catch:{ all -> 0x0057 }
            int r2 = r2.size()     // Catch:{ all -> 0x0057 }
            r1.<init>(r2)     // Catch:{ all -> 0x0057 }
            monitor-enter(r4)     // Catch:{ all -> 0x0057 }
            r4.e = r0     // Catch:{ all -> 0x0054 }
            java.util.Set<com.umeng.commonsdk.statistics.idtracking.a> r0 = r4.h     // Catch:{ all -> 0x0054 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0054 }
        L_0x001d:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x0054 }
            if (r2 == 0) goto L_0x0038
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x0054 }
            com.umeng.commonsdk.statistics.idtracking.a r2 = (com.umeng.commonsdk.statistics.idtracking.a) r2     // Catch:{ all -> 0x0054 }
            com.umeng.commonsdk.statistics.proto.c r3 = r4.e     // Catch:{ all -> 0x0054 }
            r2.a((com.umeng.commonsdk.statistics.proto.c) r3)     // Catch:{ all -> 0x0054 }
            boolean r3 = r2.c()     // Catch:{ all -> 0x0054 }
            if (r3 != 0) goto L_0x001d
            r1.add(r2)     // Catch:{ all -> 0x0054 }
            goto L_0x001d
        L_0x0038:
            java.util.Iterator r0 = r1.iterator()     // Catch:{ all -> 0x0054 }
        L_0x003c:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0054 }
            if (r1 == 0) goto L_0x004e
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0054 }
            com.umeng.commonsdk.statistics.idtracking.a r1 = (com.umeng.commonsdk.statistics.idtracking.a) r1     // Catch:{ all -> 0x0054 }
            java.util.Set<com.umeng.commonsdk.statistics.idtracking.a> r2 = r4.h     // Catch:{ all -> 0x0054 }
            r2.remove(r1)     // Catch:{ all -> 0x0054 }
            goto L_0x003c
        L_0x004e:
            monitor-exit(r4)     // Catch:{ all -> 0x0054 }
            r4.g()     // Catch:{ all -> 0x0057 }
            monitor-exit(r4)
            return
        L_0x0054:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0054 }
            throw r0     // Catch:{ all -> 0x0057 }
        L_0x0057:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.e.e():void");
    }

    public synchronized void f() {
        if (this.e != null) {
            a(this.e);
        }
    }
}
