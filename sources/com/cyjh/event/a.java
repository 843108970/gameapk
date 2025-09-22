package com.cyjh.event;

import com.google.protobuf.ByteString;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f2358a = false;

    /* renamed from: b  reason: collision with root package name */
    private static ByteString f2359b;

    private static void a(ByteString byteString) {
        f2359b = byteString;
        f2358a = false;
    }

    public static byte[] a() {
        f2359b = null;
        f2358a = true;
        if (f2359b == null) {
            return null;
        }
        return f2359b.toByteArray();
    }
}
