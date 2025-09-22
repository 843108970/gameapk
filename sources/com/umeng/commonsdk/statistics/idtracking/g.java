package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.proguard.aj;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.d;
import com.umeng.commonsdk.statistics.proto.e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3909a = "ImprintHandler";

    /* renamed from: b  reason: collision with root package name */
    private static Object f3910b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static final String f3911c = ".imprint";
    private static final byte[] d = "pbl0".getBytes();
    private static g h;
    private static Context i;
    private d e;
    private a f = new a();
    private com.umeng.commonsdk.statistics.proto.d g = null;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, String> f3912a = new HashMap();

        a() {
        }

        a(com.umeng.commonsdk.statistics.proto.d dVar) {
            a(dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0065, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0067, code lost:
            return;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private synchronized void b(com.umeng.commonsdk.statistics.proto.d r7) {
            /*
                r6 = this;
                monitor-enter(r6)
                if (r7 == 0) goto L_0x0066
                boolean r0 = r7.e()     // Catch:{ Throwable -> 0x0064, all -> 0x0061 }
                if (r0 != 0) goto L_0x000a
                goto L_0x0066
            L_0x000a:
                java.util.Map r7 = r7.c()     // Catch:{ Throwable -> 0x0064, all -> 0x0061 }
                java.util.Set r0 = r7.keySet()     // Catch:{ Throwable -> 0x0064, all -> 0x0061 }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ Throwable -> 0x0064, all -> 0x0061 }
            L_0x0016:
                boolean r1 = r0.hasNext()     // Catch:{ Throwable -> 0x0064, all -> 0x0061 }
                if (r1 == 0) goto L_0x005f
                java.lang.Object r1 = r0.next()     // Catch:{ Throwable -> 0x0064, all -> 0x0061 }
                java.lang.String r1 = (java.lang.String) r1     // Catch:{ Throwable -> 0x0064, all -> 0x0061 }
                boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x0064, all -> 0x0061 }
                if (r2 != 0) goto L_0x0016
                java.lang.Object r2 = r7.get(r1)     // Catch:{ Throwable -> 0x0064, all -> 0x0061 }
                com.umeng.commonsdk.statistics.proto.e r2 = (com.umeng.commonsdk.statistics.proto.e) r2     // Catch:{ Throwable -> 0x0064, all -> 0x0061 }
                if (r2 == 0) goto L_0x0016
                java.lang.String r2 = r2.b()     // Catch:{ Throwable -> 0x0064, all -> 0x0061 }
                boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Throwable -> 0x0064, all -> 0x0061 }
                if (r3 != 0) goto L_0x0016
                java.util.Map<java.lang.String, java.lang.String> r3 = r6.f3912a     // Catch:{ Throwable -> 0x0064, all -> 0x0061 }
                r3.put(r1, r2)     // Catch:{ Throwable -> 0x0064, all -> 0x0061 }
                boolean r3 = com.umeng.commonsdk.statistics.b.f     // Catch:{ Throwable -> 0x0064, all -> 0x0061 }
                if (r3 == 0) goto L_0x0016
                java.lang.String r3 = "ImprintHandler"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0064, all -> 0x0061 }
                java.lang.String r5 = "imKey is "
                r4.<init>(r5)     // Catch:{ Throwable -> 0x0064, all -> 0x0061 }
                r4.append(r1)     // Catch:{ Throwable -> 0x0064, all -> 0x0061 }
                java.lang.String r1 = ", imValue is "
                r4.append(r1)     // Catch:{ Throwable -> 0x0064, all -> 0x0061 }
                r4.append(r2)     // Catch:{ Throwable -> 0x0064, all -> 0x0061 }
                java.lang.String r1 = r4.toString()     // Catch:{ Throwable -> 0x0064, all -> 0x0061 }
                android.util.Log.i(r3, r1)     // Catch:{ Throwable -> 0x0064, all -> 0x0061 }
                goto L_0x0016
            L_0x005f:
                monitor-exit(r6)
                return
            L_0x0061:
                r7 = move-exception
                monitor-exit(r6)
                throw r7
            L_0x0064:
                monitor-exit(r6)
                return
            L_0x0066:
                monitor-exit(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.g.a.b(com.umeng.commonsdk.statistics.proto.d):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
            return r3;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized java.lang.String a(java.lang.String r2, java.lang.String r3) {
            /*
                r1 = this;
                monitor-enter(r1)
                boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0024 }
                if (r0 != 0) goto L_0x0022
                java.util.Map<java.lang.String, java.lang.String> r0 = r1.f3912a     // Catch:{ all -> 0x0024 }
                int r0 = r0.size()     // Catch:{ all -> 0x0024 }
                if (r0 > 0) goto L_0x0010
                goto L_0x0022
            L_0x0010:
                java.util.Map<java.lang.String, java.lang.String> r0 = r1.f3912a     // Catch:{ all -> 0x0024 }
                java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x0024 }
                java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0024 }
                boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0024 }
                if (r0 != 0) goto L_0x0020
                monitor-exit(r1)
                return r2
            L_0x0020:
                monitor-exit(r1)
                return r3
            L_0x0022:
                monitor-exit(r1)
                return r3
            L_0x0024:
                r2 = move-exception
                monitor-exit(r1)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.g.a.a(java.lang.String, java.lang.String):java.lang.String");
        }

        public void a(com.umeng.commonsdk.statistics.proto.d dVar) {
            if (dVar != null) {
                b(dVar);
            }
        }

        public synchronized void a(String str) {
            if (this.f3912a != null && this.f3912a.size() > 0 && !TextUtils.isEmpty(str) && this.f3912a.containsKey(str)) {
                this.f3912a.remove(str);
            }
        }
    }

    private g(Context context) {
        i = context.getApplicationContext();
    }

    public static synchronized g a(Context context) {
        g gVar;
        synchronized (g.class) {
            if (h == null) {
                g gVar2 = new g(context);
                h = gVar2;
                gVar2.e();
            }
            gVar = h;
        }
        return gVar;
    }

    private com.umeng.commonsdk.statistics.proto.d a(com.umeng.commonsdk.statistics.proto.d dVar, com.umeng.commonsdk.statistics.proto.d dVar2) {
        if (dVar2 == null) {
            return dVar;
        }
        Map<String, e> c2 = dVar.c();
        for (Map.Entry next : dVar2.c().entrySet()) {
            if (((e) next.getValue()).d()) {
                c2.put(next.getKey(), next.getValue());
            } else {
                String str = (String) next.getKey();
                c2.remove(str);
                this.f.a(str);
            }
        }
        dVar.a(dVar2.f());
        dVar.a(a(dVar));
        return dVar;
    }

    private boolean a(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    private boolean c(com.umeng.commonsdk.statistics.proto.d dVar) {
        if (!dVar.i().equals(a(dVar))) {
            return false;
        }
        for (e next : dVar.c().values()) {
            byte[] reverseHexString = DataHelper.reverseHexString(next.h());
            byte[] a2 = a(next);
            int i2 = 0;
            while (true) {
                if (i2 < 4) {
                    if (reverseHexString[i2] != a2[i2]) {
                        return false;
                    }
                    i2++;
                }
            }
        }
        return true;
    }

    private com.umeng.commonsdk.statistics.proto.d d(com.umeng.commonsdk.statistics.proto.d dVar) {
        Map<String, e> c2 = dVar.c();
        ArrayList<String> arrayList = new ArrayList<>(c2.size() / 2);
        for (Map.Entry next : c2.entrySet()) {
            if (!((e) next.getValue()).d()) {
                arrayList.add(next.getKey());
            }
        }
        for (String remove : arrayList) {
            c2.remove(remove);
        }
        return dVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0038 A[SYNTHETIC, Splitter:B:24:0x0038] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e() {
        /*
            r5 = this;
            java.io.File r0 = new java.io.File
            android.content.Context r1 = i
            java.io.File r1 = r1.getFilesDir()
            java.lang.String r2 = ".imprint"
            r0.<init>(r1, r2)
            java.lang.Object r1 = f3910b
            monitor-enter(r1)
            boolean r0 = r0.exists()     // Catch:{ all -> 0x005b }
            if (r0 != 0) goto L_0x0018
            monitor-exit(r1)     // Catch:{ all -> 0x005b }
            return
        L_0x0018:
            r0 = 0
            android.content.Context r2 = i     // Catch:{ Exception -> 0x002e, all -> 0x002c }
            java.lang.String r3 = ".imprint"
            java.io.FileInputStream r2 = r2.openFileInput(r3)     // Catch:{ Exception -> 0x002e, all -> 0x002c }
            byte[] r3 = com.umeng.commonsdk.statistics.common.HelperUtils.readStreamToByteArray(r2)     // Catch:{ Exception -> 0x002a }
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose((java.io.InputStream) r2)     // Catch:{ all -> 0x005b }
            r0 = r3
            goto L_0x0036
        L_0x002a:
            r3 = move-exception
            goto L_0x0030
        L_0x002c:
            r2 = move-exception
            goto L_0x0057
        L_0x002e:
            r3 = move-exception
            r2 = r0
        L_0x0030:
            r3.printStackTrace()     // Catch:{ all -> 0x0053 }
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose((java.io.InputStream) r2)     // Catch:{ all -> 0x005b }
        L_0x0036:
            if (r0 == 0) goto L_0x0051
            com.umeng.commonsdk.statistics.proto.d r2 = new com.umeng.commonsdk.statistics.proto.d     // Catch:{ Exception -> 0x004d }
            r2.<init>()     // Catch:{ Exception -> 0x004d }
            com.umeng.commonsdk.proguard.ad r3 = new com.umeng.commonsdk.proguard.ad     // Catch:{ Exception -> 0x004d }
            r3.<init>()     // Catch:{ Exception -> 0x004d }
            r3.a((com.umeng.commonsdk.proguard.aa) r2, (byte[]) r0)     // Catch:{ Exception -> 0x004d }
            r5.g = r2     // Catch:{ Exception -> 0x004d }
            com.umeng.commonsdk.statistics.idtracking.g$a r0 = r5.f     // Catch:{ Exception -> 0x004d }
            r0.a((com.umeng.commonsdk.statistics.proto.d) r2)     // Catch:{ Exception -> 0x004d }
            goto L_0x0051
        L_0x004d:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x005b }
        L_0x0051:
            monitor-exit(r1)     // Catch:{ all -> 0x005b }
            return
        L_0x0053:
            r0 = move-exception
            r4 = r2
            r2 = r0
            r0 = r4
        L_0x0057:
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose((java.io.InputStream) r0)     // Catch:{ all -> 0x005b }
            throw r2     // Catch:{ all -> 0x005b }
        L_0x005b:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x005b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.g.e():void");
    }

    public synchronized com.umeng.commonsdk.statistics.proto.d a() {
        return this.g;
    }

    public String a(com.umeng.commonsdk.statistics.proto.d dVar) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : new TreeMap(dVar.c()).entrySet()) {
            sb.append((String) entry.getKey());
            if (((e) entry.getValue()).d()) {
                sb.append(((e) entry.getValue()).b());
            }
            sb.append(((e) entry.getValue()).e());
            sb.append(((e) entry.getValue()).h());
        }
        sb.append(dVar.f3974b);
        return HelperUtils.MD5(sb.toString()).toLowerCase(Locale.US);
    }

    public void a(d dVar) {
        this.e = dVar;
    }

    public byte[] a(e eVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order((ByteOrder) null);
        allocate.putLong(eVar.e());
        byte[] array = allocate.array();
        byte[] bArr = d;
        byte[] bArr2 = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr2[i2] = (byte) (array[i2] ^ bArr[i2]);
        }
        return bArr2;
    }

    public a b() {
        return this.f;
    }

    public void b(com.umeng.commonsdk.statistics.proto.d dVar) {
        boolean z;
        if (dVar == null) {
            if (b.f) {
                MLog.d("Imprint is null");
            }
        } else if (c(dVar)) {
            if (b.f) {
                MLog.d("Imprint is ok");
            }
            synchronized (this) {
                com.umeng.commonsdk.statistics.proto.d dVar2 = this.g;
                String str = null;
                String i2 = dVar2 == null ? null : dVar2.i();
                com.umeng.commonsdk.statistics.proto.d d2 = dVar2 == null ? d(dVar) : a(dVar2, dVar);
                this.g = d2;
                if (d2 != null) {
                    str = d2.i();
                }
                z = !a(i2, str);
            }
            if (this.g != null) {
                boolean z2 = b.f;
                if (z) {
                    this.f.a(this.g);
                    if (this.e != null) {
                        this.e.onImprintChanged(this.f);
                    }
                }
            }
        } else if (b.f) {
            MLog.e("Imprint is not valid");
        }
    }

    public void c() {
        if (this.g != null) {
            try {
                synchronized (f3910b) {
                    byte[] a2 = new aj().a(this.g);
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(i.getFilesDir(), f3911c));
                    try {
                        fileOutputStream.write(a2);
                        fileOutputStream.flush();
                    } finally {
                        HelperUtils.safeClose((OutputStream) fileOutputStream);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean d() {
        return new File(i.getFilesDir(), f3911c).delete();
    }
}
