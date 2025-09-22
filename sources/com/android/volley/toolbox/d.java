package com.android.volley.toolbox;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    protected static final Comparator<byte[]> f524a = new Comparator<byte[]>() {
        private static int a(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((byte[]) obj).length - ((byte[]) obj2).length;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private List<byte[]> f525b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    private List<byte[]> f526c = new ArrayList(64);
    private int d = 0;
    private final int e;

    public d(int i) {
        this.e = i;
    }

    private synchronized void a() {
        while (this.d > this.e) {
            byte[] remove = this.f525b.remove(0);
            this.f526c.remove(remove);
            this.d -= remove.length;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(byte[] r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x002e
            int r0 = r3.length     // Catch:{ all -> 0x002b }
            int r1 = r2.e     // Catch:{ all -> 0x002b }
            if (r0 <= r1) goto L_0x0009
            goto L_0x002e
        L_0x0009:
            java.util.List<byte[]> r0 = r2.f525b     // Catch:{ all -> 0x002b }
            r0.add(r3)     // Catch:{ all -> 0x002b }
            java.util.List<byte[]> r0 = r2.f526c     // Catch:{ all -> 0x002b }
            java.util.Comparator<byte[]> r1 = f524a     // Catch:{ all -> 0x002b }
            int r0 = java.util.Collections.binarySearch(r0, r3, r1)     // Catch:{ all -> 0x002b }
            if (r0 >= 0) goto L_0x001b
            int r0 = -r0
            int r0 = r0 + -1
        L_0x001b:
            java.util.List<byte[]> r1 = r2.f526c     // Catch:{ all -> 0x002b }
            r1.add(r0, r3)     // Catch:{ all -> 0x002b }
            int r0 = r2.d     // Catch:{ all -> 0x002b }
            int r3 = r3.length     // Catch:{ all -> 0x002b }
            int r0 = r0 + r3
            r2.d = r0     // Catch:{ all -> 0x002b }
            r2.a()     // Catch:{ all -> 0x002b }
            monitor-exit(r2)
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x002e:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.d.a(byte[]):void");
    }

    public final synchronized byte[] a(int i) {
        for (int i2 = 0; i2 < this.f526c.size(); i2++) {
            byte[] bArr = this.f526c.get(i2);
            if (bArr.length >= i) {
                this.d -= bArr.length;
                this.f526c.remove(i2);
                this.f525b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }
}
