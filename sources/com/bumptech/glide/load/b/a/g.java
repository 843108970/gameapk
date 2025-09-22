package com.bumptech.glide.load.b.a;

public final class g implements a<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1023a = "ByteArrayPool";

    private static int a(byte[] bArr) {
        return bArr.length;
    }

    private static byte[] b(int i) {
        return new byte[i];
    }

    public final /* bridge */ /* synthetic */ int a(Object obj) {
        return ((byte[]) obj).length;
    }

    public final /* bridge */ /* synthetic */ Object a(int i) {
        return new byte[i];
    }

    public final String a() {
        return f1023a;
    }

    public final int b() {
        return 1;
    }
}
