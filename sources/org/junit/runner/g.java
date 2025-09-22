package org.junit.runner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.b.c;
import org.junit.b.d.b;
import org.junit.e.a.e;
import org.junit.runner.e;

class g {

    /* renamed from: a  reason: collision with root package name */
    final List<Class<?>> f4634a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    final List<Throwable> f4635b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f4636c = new ArrayList();

    public static class a extends Exception {
        private static final long serialVersionUID = 1;

        public a(String str) {
            super(str);
        }
    }

    g() {
    }

    private List<String> a() {
        return Collections.unmodifiableList(this.f4636c);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
        r8 = a(r8, r2, r8.length);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.junit.runner.g a(java.lang.String[] r8) {
        /*
            org.junit.runner.g r0 = new org.junit.runner.g
            r0.<init>()
            r1 = 0
            r2 = 0
        L_0x0007:
            int r3 = r8.length
            if (r2 == r3) goto L_0x0095
            r3 = r8[r2]
            java.lang.String r4 = "--"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x001d
            int r2 = r2 + 1
        L_0x0016:
            int r1 = r8.length
            java.lang.String[] r8 = a(r8, r2, r1)
            goto L_0x0097
        L_0x001d:
            java.lang.String r4 = "--"
            boolean r4 = r3.startsWith(r4)
            if (r4 == 0) goto L_0x0016
            java.lang.String r4 = "--filter="
            boolean r4 = r3.startsWith(r4)
            if (r4 != 0) goto L_0x0054
            java.lang.String r4 = "--filter"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0036
            goto L_0x0054
        L_0x0036:
            java.util.List<java.lang.Throwable> r4 = r0.f4635b
            org.junit.runner.g$a r5 = new org.junit.runner.g$a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "JUnit knows nothing about the "
            r6.<init>(r7)
            r6.append(r3)
            java.lang.String r3 = " option"
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            r5.<init>(r3)
            r4.add(r5)
            goto L_0x0091
        L_0x0054:
            java.lang.String r4 = "--filter"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0080
            int r2 = r2 + 1
            int r4 = r8.length
            if (r2 >= r4) goto L_0x0064
            r3 = r8[r2]
            goto L_0x008c
        L_0x0064:
            java.util.List<java.lang.Throwable> r8 = r0.f4635b
            org.junit.runner.g$a r2 = new org.junit.runner.g$a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r3 = " value not specified"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r2.<init>(r3)
            r8.add(r2)
            goto L_0x0095
        L_0x0080:
            r4 = 61
            int r4 = r3.indexOf(r4)
            int r4 = r4 + 1
            java.lang.String r3 = r3.substring(r4)
        L_0x008c:
            java.util.List<java.lang.String> r4 = r0.f4636c
            r4.add(r3)
        L_0x0091:
            int r2 = r2 + 1
            goto L_0x0007
        L_0x0095:
            java.lang.String[] r8 = new java.lang.String[r1]
        L_0x0097:
            r0.d(r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.runner.g.a(java.lang.String[]):org.junit.runner.g");
    }

    static h a(Throwable th) {
        return h.a((k) new b(g.class, th));
    }

    private h a(a aVar) {
        return this.f4635b.isEmpty() ? a(h.a(aVar, (Class<?>[]) (Class[]) this.f4634a.toArray(new Class[this.f4634a.size()]))) : a((Throwable) new e(this.f4635b));
    }

    private static String[] a(String[] strArr, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        while (i != i2) {
            arrayList.add(strArr[i]);
            i++;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private List<Class<?>> b() {
        return Collections.unmodifiableList(this.f4634a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0090, code lost:
        r8 = new java.lang.String[0];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.lang.String[] r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            int r2 = r8.length
            if (r1 == r2) goto L_0x0090
            r2 = r8[r1]
            java.lang.String r3 = "--"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0018
            int r1 = r1 + 1
        L_0x0011:
            int r0 = r8.length
            java.lang.String[] r8 = a(r8, r1, r0)
            goto L_0x0092
        L_0x0018:
            java.lang.String r3 = "--"
            boolean r3 = r2.startsWith(r3)
            if (r3 == 0) goto L_0x0011
            java.lang.String r3 = "--filter="
            boolean r3 = r2.startsWith(r3)
            if (r3 != 0) goto L_0x004f
            java.lang.String r3 = "--filter"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0031
            goto L_0x004f
        L_0x0031:
            java.util.List<java.lang.Throwable> r3 = r7.f4635b
            org.junit.runner.g$a r4 = new org.junit.runner.g$a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "JUnit knows nothing about the "
            r5.<init>(r6)
            r5.append(r2)
            java.lang.String r2 = " option"
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r4.<init>(r2)
            r3.add(r4)
            goto L_0x008c
        L_0x004f:
            java.lang.String r3 = "--filter"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x007b
            int r1 = r1 + 1
            int r3 = r8.length
            if (r1 >= r3) goto L_0x005f
            r2 = r8[r1]
            goto L_0x0087
        L_0x005f:
            java.util.List<java.lang.Throwable> r8 = r7.f4635b
            org.junit.runner.g$a r1 = new org.junit.runner.g$a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r2 = " value not specified"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            r8.add(r1)
            goto L_0x0090
        L_0x007b:
            r3 = 61
            int r3 = r2.indexOf(r3)
            int r3 = r3 + 1
            java.lang.String r2 = r2.substring(r3)
        L_0x0087:
            java.util.List<java.lang.String> r3 = r7.f4636c
            r3.add(r2)
        L_0x008c:
            int r1 = r1 + 1
            goto L_0x0002
        L_0x0090:
            java.lang.String[] r8 = new java.lang.String[r0]
        L_0x0092:
            r7.d(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.runner.g.b(java.lang.String[]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0091, code lost:
        return new java.lang.String[0];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String[] c(java.lang.String... r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            int r2 = r8.length
            if (r1 == r2) goto L_0x008f
            r2 = r8[r1]
            java.lang.String r3 = "--"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0017
            int r1 = r1 + 1
        L_0x0011:
            int r0 = r8.length
            java.lang.String[] r8 = a(r8, r1, r0)
            return r8
        L_0x0017:
            java.lang.String r3 = "--"
            boolean r3 = r2.startsWith(r3)
            if (r3 == 0) goto L_0x0011
            java.lang.String r3 = "--filter="
            boolean r3 = r2.startsWith(r3)
            if (r3 != 0) goto L_0x004e
            java.lang.String r3 = "--filter"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0030
            goto L_0x004e
        L_0x0030:
            java.util.List<java.lang.Throwable> r3 = r7.f4635b
            org.junit.runner.g$a r4 = new org.junit.runner.g$a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "JUnit knows nothing about the "
            r5.<init>(r6)
            r5.append(r2)
            java.lang.String r2 = " option"
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r4.<init>(r2)
            r3.add(r4)
            goto L_0x008b
        L_0x004e:
            java.lang.String r3 = "--filter"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x007a
            int r1 = r1 + 1
            int r3 = r8.length
            if (r1 >= r3) goto L_0x005e
            r2 = r8[r1]
            goto L_0x0086
        L_0x005e:
            java.util.List<java.lang.Throwable> r8 = r7.f4635b
            org.junit.runner.g$a r1 = new org.junit.runner.g$a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r2 = " value not specified"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            r8.add(r1)
            goto L_0x008f
        L_0x007a:
            r3 = 61
            int r3 = r2.indexOf(r3)
            int r3 = r3 + 1
            java.lang.String r2 = r2.substring(r3)
        L_0x0086:
            java.util.List<java.lang.String> r3 = r7.f4636c
            r3.add(r2)
        L_0x008b:
            int r1 = r1 + 1
            goto L_0x0002
        L_0x008f:
            java.lang.String[] r8 = new java.lang.String[r0]
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.runner.g.c(java.lang.String[]):java.lang.String[]");
    }

    private void d(String[] strArr) {
        for (String str : strArr) {
            try {
                this.f4634a.add(c.a(str));
            } catch (ClassNotFoundException e) {
                this.f4635b.add(new IllegalArgumentException("Could not find class [" + str + "]", e));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final h a(h hVar) {
        String[] strArr;
        try {
            for (String next : this.f4636c) {
                c b2 = hVar.a().b();
                if (next.contains("=")) {
                    strArr = next.split("=", 2);
                } else {
                    strArr = new String[]{next, ""};
                }
                String str = strArr[0];
                hVar = hVar.a(d.a(str).a(new f(b2, strArr[1])));
            }
            return hVar;
        } catch (e.a e) {
            return a((Throwable) e);
        }
    }
}
