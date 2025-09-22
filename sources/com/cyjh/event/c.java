package com.cyjh.event;

import com.google.protobuf.ByteString;
import java.util.concurrent.ArrayBlockingQueue;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static ArrayBlockingQueue<ByteString> f2368a = new ArrayBlockingQueue<>(16);

    /* renamed from: b  reason: collision with root package name */
    private static ArrayBlockingQueue<ByteString> f2369b = new ArrayBlockingQueue<>(1024);

    /* renamed from: c  reason: collision with root package name */
    private static ArrayBlockingQueue<ByteString> f2370c = new ArrayBlockingQueue<>(1024);

    public static void a(ByteString byteString) {
        try {
            f2368a.put(byteString);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static byte[] a() {
        try {
            return f2368a.take().toByteArray();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void b(ByteString byteString) {
        try {
            f2369b.put(byteString);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static byte[] b() {
        try {
            return f2369b.take().toByteArray();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void c() {
        f2369b.clear();
        f2370c.clear();
    }

    private static void c(ByteString byteString) {
        try {
            f2370c.put(byteString);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static ByteString d() {
        try {
            return f2370c.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void e() {
        try {
            f2370c.put(ByteString.copyFrom("floatEventThreadExit".getBytes()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void f() {
        f2370c.clear();
    }
}
