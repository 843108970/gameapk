package com.google.a.c;

import java.util.List;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f3075a;

    /* renamed from: b  reason: collision with root package name */
    public int f3076b;

    /* renamed from: c  reason: collision with root package name */
    public final String f3077c;
    public final List<byte[]> d;
    public final String e;
    public Integer f;
    public Integer g;
    public Object h;
    public final int i;
    public final int j;

    public e(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public e(byte[] bArr, String str, List<byte[]> list, String str2, int i2, int i3) {
        this.f3075a = bArr;
        this.f3076b = bArr == null ? 0 : bArr.length * 8;
        this.f3077c = str;
        this.d = list;
        this.e = str2;
        this.i = i3;
        this.j = i2;
    }

    private void a(int i2) {
        this.f3076b = i2;
    }

    private void a(Integer num) {
        this.f = num;
    }

    private void a(Object obj) {
        this.h = obj;
    }

    private void b(Integer num) {
        this.g = num;
    }

    private byte[] b() {
        return this.f3075a;
    }

    private int c() {
        return this.f3076b;
    }

    private String d() {
        return this.f3077c;
    }

    private List<byte[]> e() {
        return this.d;
    }

    private String f() {
        return this.e;
    }

    private Integer g() {
        return this.f;
    }

    private Integer h() {
        return this.g;
    }

    private Object i() {
        return this.h;
    }

    private int j() {
        return this.i;
    }

    private int k() {
        return this.j;
    }

    public final boolean a() {
        return this.i >= 0 && this.j >= 0;
    }
}
