package com.android.volley;

import java.util.Collections;
import java.util.Map;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final int f483a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f484b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f485c;
    public final boolean d;
    public final long e;

    private i(int i, byte[] bArr, Map<String, String> map, boolean z) {
        this(i, bArr, map, z, 0);
    }

    public i(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this.f483a = i;
        this.f484b = bArr;
        this.f485c = map;
        this.d = z;
        this.e = j;
    }

    private i(byte[] bArr) {
        this(200, bArr, Collections.emptyMap(), false, 0);
    }

    public i(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0);
    }
}
