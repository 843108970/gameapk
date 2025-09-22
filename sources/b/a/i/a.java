package b.a.i;

import b.a.c;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Marker;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f201a = "publicsuffixes.gz";

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f202b = {42};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f203c = new String[0];
    private static final String[] d = {Marker.ANY_MARKER};
    private static final byte e = 33;
    private static final a f = new a();
    private final AtomicBoolean g = new AtomicBoolean(false);
    private final CountDownLatch h = new CountDownLatch(1);
    private byte[] i;
    private byte[] j;

    public static a a() {
        return f;
    }

    private static String a(byte[] bArr, byte[][] bArr2, int i2) {
        int i3;
        byte b2;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 >= 0 && bArr[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i3 = i7 + i8;
                if (bArr[i3] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i3 - i7;
            int i10 = i2;
            boolean z = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z) {
                    z = false;
                    b2 = 46;
                } else {
                    b2 = bArr2[i10][i11] & 255;
                }
                i4 = b2 - (bArr[i7 + i12] & 255);
                if (i4 != 0) {
                    break;
                }
                i12++;
                i11++;
                if (i12 != i9) {
                    if (bArr2[i10].length == i11) {
                        if (i10 == bArr2.length - 1) {
                            break;
                        }
                        i10++;
                        z = true;
                        i11 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr2[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new String(bArr, i7, i9, c.e);
                        }
                    }
                }
                i5 = i3 + 1;
            }
            length = i7 - 1;
        }
        return null;
    }

    private void a(byte[] bArr, byte[] bArr2) {
        this.i = bArr;
        this.j = bArr2;
        this.g.set(true);
        this.h.countDown();
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private java.lang.String[] a(java.lang.String[] r9) {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.g
            boolean r0 = r0.get()
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x006a
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.g
            boolean r0 = r0.compareAndSet(r1, r3)
            if (r0 == 0) goto L_0x006a
            java.lang.Class<b.a.i.a> r0 = b.a.i.a.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.lang.String r4 = "publicsuffixes.gz"
            java.io.InputStream r0 = r0.getResourceAsStream(r4)
            if (r0 == 0) goto L_0x0059
            c.l r4 = new c.l
            c.y r0 = c.p.a((java.io.InputStream) r0)
            r4.<init>(r0)
            c.e r0 = c.p.a((c.y) r4)
            int r4 = r0.i()     // Catch:{ IOException -> 0x0046 }
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x0046 }
            r0.b((byte[]) r4)     // Catch:{ IOException -> 0x0046 }
            int r5 = r0.i()     // Catch:{ IOException -> 0x0046 }
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x0046 }
            r0.b((byte[]) r5)     // Catch:{ IOException -> 0x0046 }
            b.a.c.a((java.io.Closeable) r0)
            goto L_0x005b
        L_0x0044:
            r9 = move-exception
            goto L_0x0055
        L_0x0046:
            r4 = move-exception
            b.a.h.e r5 = b.a.h.e.b()     // Catch:{ all -> 0x0044 }
            r6 = 5
            java.lang.String r7 = "Failed to read public suffix list"
            r5.a((int) r6, (java.lang.String) r7, (java.lang.Throwable) r4)     // Catch:{ all -> 0x0044 }
            b.a.c.a((java.io.Closeable) r0)
            goto L_0x0059
        L_0x0055:
            b.a.c.a((java.io.Closeable) r0)
            throw r9
        L_0x0059:
            r4 = r2
            r5 = r4
        L_0x005b:
            monitor-enter(r8)
            r8.i = r4     // Catch:{ all -> 0x0067 }
            r8.j = r5     // Catch:{ all -> 0x0067 }
            monitor-exit(r8)     // Catch:{ all -> 0x0067 }
            java.util.concurrent.CountDownLatch r0 = r8.h
            r0.countDown()
            goto L_0x006f
        L_0x0067:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0067 }
            throw r9
        L_0x006a:
            java.util.concurrent.CountDownLatch r0 = r8.h     // Catch:{ InterruptedException -> 0x006f }
            r0.await()     // Catch:{ InterruptedException -> 0x006f }
        L_0x006f:
            monitor-enter(r8)
            byte[] r0 = r8.i     // Catch:{ all -> 0x010e }
            if (r0 != 0) goto L_0x007c
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x010e }
            java.lang.String r0 = "Unable to load publicsuffixes.gz resource from the classpath."
            r9.<init>(r0)     // Catch:{ all -> 0x010e }
            throw r9     // Catch:{ all -> 0x010e }
        L_0x007c:
            monitor-exit(r8)     // Catch:{ all -> 0x010e }
            int r0 = r9.length
            byte[][] r0 = new byte[r0][]
            r4 = 0
        L_0x0081:
            int r5 = r9.length
            if (r4 >= r5) goto L_0x0091
            r5 = r9[r4]
            java.nio.charset.Charset r6 = b.a.c.e
            byte[] r5 = r5.getBytes(r6)
            r0[r4] = r5
            int r4 = r4 + 1
            goto L_0x0081
        L_0x0091:
            r9 = 0
        L_0x0092:
            int r4 = r0.length
            if (r9 >= r4) goto L_0x00a1
            byte[] r4 = r8.i
            java.lang.String r4 = a(r4, r0, r9)
            if (r4 == 0) goto L_0x009e
            goto L_0x00a2
        L_0x009e:
            int r9 = r9 + 1
            goto L_0x0092
        L_0x00a1:
            r4 = r2
        L_0x00a2:
            int r9 = r0.length
            if (r9 <= r3) goto L_0x00c0
            java.lang.Object r9 = r0.clone()
            byte[][] r9 = (byte[][]) r9
            r5 = 0
        L_0x00ac:
            int r6 = r9.length
            int r6 = r6 - r3
            if (r5 >= r6) goto L_0x00c0
            byte[] r6 = f202b
            r9[r5] = r6
            byte[] r6 = r8.i
            java.lang.String r6 = a(r6, r9, r5)
            if (r6 == 0) goto L_0x00bd
            goto L_0x00c1
        L_0x00bd:
            int r5 = r5 + 1
            goto L_0x00ac
        L_0x00c0:
            r6 = r2
        L_0x00c1:
            if (r6 == 0) goto L_0x00d3
        L_0x00c3:
            int r9 = r0.length
            int r9 = r9 - r3
            if (r1 >= r9) goto L_0x00d3
            byte[] r9 = r8.j
            java.lang.String r9 = a(r9, r0, r1)
            if (r9 == 0) goto L_0x00d0
            goto L_0x00d4
        L_0x00d0:
            int r1 = r1 + 1
            goto L_0x00c3
        L_0x00d3:
            r9 = r2
        L_0x00d4:
            if (r9 == 0) goto L_0x00eb
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "!"
            r0.<init>(r1)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            java.lang.String r0 = "\\."
            java.lang.String[] r9 = r9.split(r0)
            return r9
        L_0x00eb:
            if (r4 != 0) goto L_0x00f2
            if (r6 != 0) goto L_0x00f2
            java.lang.String[] r9 = d
            return r9
        L_0x00f2:
            if (r4 == 0) goto L_0x00fb
            java.lang.String r9 = "\\."
            java.lang.String[] r9 = r4.split(r9)
            goto L_0x00fd
        L_0x00fb:
            java.lang.String[] r9 = f203c
        L_0x00fd:
            if (r6 == 0) goto L_0x0106
            java.lang.String r0 = "\\."
            java.lang.String[] r0 = r6.split(r0)
            goto L_0x0108
        L_0x0106:
            java.lang.String[] r0 = f203c
        L_0x0108:
            int r1 = r9.length
            int r2 = r0.length
            if (r1 <= r2) goto L_0x010d
            return r9
        L_0x010d:
            return r0
        L_0x010e:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x010e }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.i.a.a(java.lang.String[]):java.lang.String[]");
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
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private void b() {
        /*
            r6 = this;
            java.lang.Class<b.a.i.a> r0 = b.a.i.a.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.lang.String r1 = "publicsuffixes.gz"
            java.io.InputStream r0 = r0.getResourceAsStream(r1)
            r1 = 0
            if (r0 == 0) goto L_0x0048
            c.l r2 = new c.l
            c.y r0 = c.p.a((java.io.InputStream) r0)
            r2.<init>(r0)
            c.e r0 = c.p.a((c.y) r2)
            int r2 = r0.i()     // Catch:{ IOException -> 0x0035 }
            byte[] r2 = new byte[r2]     // Catch:{ IOException -> 0x0035 }
            r0.b((byte[]) r2)     // Catch:{ IOException -> 0x0035 }
            int r3 = r0.i()     // Catch:{ IOException -> 0x0035 }
            byte[] r3 = new byte[r3]     // Catch:{ IOException -> 0x0035 }
            r0.b((byte[]) r3)     // Catch:{ IOException -> 0x0035 }
            b.a.c.a((java.io.Closeable) r0)
            r1 = r2
            goto L_0x0049
        L_0x0033:
            r1 = move-exception
            goto L_0x0044
        L_0x0035:
            r2 = move-exception
            b.a.h.e r3 = b.a.h.e.b()     // Catch:{ all -> 0x0033 }
            r4 = 5
            java.lang.String r5 = "Failed to read public suffix list"
            r3.a((int) r4, (java.lang.String) r5, (java.lang.Throwable) r2)     // Catch:{ all -> 0x0033 }
            b.a.c.a((java.io.Closeable) r0)
            goto L_0x0048
        L_0x0044:
            b.a.c.a((java.io.Closeable) r0)
            throw r1
        L_0x0048:
            r3 = r1
        L_0x0049:
            monitor-enter(r6)
            r6.i = r1     // Catch:{ all -> 0x0055 }
            r6.j = r3     // Catch:{ all -> 0x0055 }
            monitor-exit(r6)     // Catch:{ all -> 0x0055 }
            java.util.concurrent.CountDownLatch r0 = r6.h
            r0.countDown()
            return
        L_0x0055:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0055 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.i.a.b():void");
    }

    public final String a(String str) {
        int length;
        int length2;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] split = IDN.toUnicode(str).split("\\.");
        String[] a2 = a(split);
        if (split.length == a2.length && a2[0].charAt(0) != '!') {
            return null;
        }
        if (a2[0].charAt(0) == '!') {
            length = split.length;
            length2 = a2.length;
        } else {
            length = split.length;
            length2 = a2.length + 1;
        }
        StringBuilder sb = new StringBuilder();
        String[] split2 = str.split("\\.");
        for (int i2 = length - length2; i2 < split2.length; i2++) {
            sb.append(split2[i2]);
            sb.append(FilenameUtils.EXTENSION_SEPARATOR);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
