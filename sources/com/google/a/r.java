package com.google.a;

import java.util.EnumMap;
import java.util.Map;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public final String f3353a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f3354b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3355c;
    public t[] d;
    public final a e;
    public Map<s, Object> f;
    public final long g;

    public r(String str, byte[] bArr, int i, t[] tVarArr, a aVar, long j) {
        this.f3353a = str;
        this.f3354b = bArr;
        this.f3355c = i;
        this.d = tVarArr;
        this.e = aVar;
        this.f = null;
        this.g = j;
    }

    public r(String str, byte[] bArr, t[] tVarArr, a aVar) {
        this(str, bArr, tVarArr, aVar, System.currentTimeMillis());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private r(String str, byte[] bArr, t[] tVarArr, a aVar, long j) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, tVarArr, aVar, j);
    }

    private String a() {
        return this.f3353a;
    }

    private void a(t[] tVarArr) {
        t[] tVarArr2 = this.d;
        if (tVarArr2 == null) {
            this.d = tVarArr;
        } else if (tVarArr != null && tVarArr.length > 0) {
            t[] tVarArr3 = new t[(tVarArr2.length + tVarArr.length)];
            System.arraycopy(tVarArr2, 0, tVarArr3, 0, tVarArr2.length);
            System.arraycopy(tVarArr, 0, tVarArr3, tVarArr2.length, tVarArr.length);
            this.d = tVarArr3;
        }
    }

    private byte[] b() {
        return this.f3354b;
    }

    private int c() {
        return this.f3355c;
    }

    private t[] d() {
        return this.d;
    }

    private a e() {
        return this.e;
    }

    private Map<s, Object> f() {
        return this.f;
    }

    private long g() {
        return this.g;
    }

    public final void a(s sVar, Object obj) {
        if (this.f == null) {
            this.f = new EnumMap(s.class);
        }
        this.f.put(sVar, obj);
    }

    public final void a(Map<s, Object> map) {
        if (map == null) {
            return;
        }
        if (this.f == null) {
            this.f = map;
        } else {
            this.f.putAll(map);
        }
    }

    public final String toString() {
        return this.f3353a;
    }
}
