package com.google.a.c.b;

import java.util.ArrayList;
import java.util.List;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final a f3070a;

    /* renamed from: b  reason: collision with root package name */
    private final List<b> f3071b = new ArrayList();

    public d(a aVar) {
        this.f3070a = aVar;
        this.f3071b.add(new b(aVar, new int[]{1}));
    }

    private b a(int i) {
        if (i >= this.f3071b.size()) {
            b bVar = this.f3071b.get(this.f3071b.size() - 1);
            for (int size = this.f3071b.size(); size <= i; size++) {
                bVar = bVar.b(new b(this.f3070a, new int[]{1, this.f3070a.i[(size - 1) + this.f3070a.m]}));
                this.f3071b.add(bVar);
            }
        }
        return this.f3071b.get(i);
    }

    public final void a(int[] iArr, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        b a2 = a(i);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] iArr3 = new b(this.f3070a, iArr2).a(i, 1).c(a2)[1].f3067a;
        int length2 = i - iArr3.length;
        for (int i2 = 0; i2 < length2; i2++) {
            iArr[length + i2] = 0;
        }
        System.arraycopy(iArr3, 0, iArr, length + length2, iArr3.length);
    }
}
