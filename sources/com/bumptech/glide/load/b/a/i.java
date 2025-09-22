package com.bumptech.glide.load.b.a;

public final class i implements a<int[]> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1029a = "IntegerArrayPool";

    private static int a(int[] iArr) {
        return iArr.length;
    }

    private static int[] b(int i) {
        return new int[i];
    }

    public final /* bridge */ /* synthetic */ int a(Object obj) {
        return ((int[]) obj).length;
    }

    public final /* bridge */ /* synthetic */ Object a(int i) {
        return new int[i];
    }

    public final String a() {
        return f1029a;
    }

    public final int b() {
        return 4;
    }
}
