package com.umeng.commonsdk.proguard;

public class ba extends ag {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3741a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f3742b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3743c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    private static final long h = 1;
    protected int g = 0;

    public ba() {
    }

    public ba(int i) {
        this.g = i;
    }

    public ba(int i, String str) {
        super(str);
        this.g = i;
    }

    public ba(int i, String str, Throwable th) {
        super(str, th);
        this.g = i;
    }

    public ba(int i, Throwable th) {
        super(th);
        this.g = i;
    }

    public ba(String str) {
        super(str);
    }

    public ba(String str, Throwable th) {
        super(str, th);
    }

    public ba(Throwable th) {
        super(th);
    }

    public int a() {
        return this.g;
    }
}
