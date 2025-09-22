package com.umeng.commonsdk.proguard;

public class bo extends ag {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3756a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f3757b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3758c = 2;
    public static final int d = 3;
    public static final int e = 4;
    private static final long g = 1;
    protected int f = 0;

    public bo() {
    }

    public bo(int i) {
        this.f = i;
    }

    public bo(int i, String str) {
        super(str);
        this.f = i;
    }

    public bo(int i, String str, Throwable th) {
        super(str, th);
        this.f = i;
    }

    public bo(int i, Throwable th) {
        super(th);
        this.f = i;
    }

    public bo(String str) {
        super(str);
    }

    public bo(String str, Throwable th) {
        super(str, th);
    }

    public bo(Throwable th) {
        super(th);
    }

    public int a() {
        return this.f;
    }
}
