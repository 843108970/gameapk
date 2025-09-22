package com.bumptech.glide.c;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

public interface b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f916a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f917b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f918c = 2;
    public static final int d = 3;
    public static final int e = 0;

    public interface a {
        @NonNull
        Bitmap a(int i, int i2, @NonNull Bitmap.Config config);

        void a(@NonNull Bitmap bitmap);

        void a(@NonNull byte[] bArr);

        void a(@NonNull int[] iArr);

        @NonNull
        byte[] a(int i);

        @NonNull
        int[] b(int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.bumptech.glide.c.b$b  reason: collision with other inner class name */
    public @interface C0009b {
    }

    int a();

    int a(int i);

    int a(@Nullable InputStream inputStream, int i);

    int a(@Nullable byte[] bArr);

    void a(@NonNull Bitmap.Config config);

    void a(@NonNull d dVar, @NonNull ByteBuffer byteBuffer);

    void a(@NonNull d dVar, @NonNull ByteBuffer byteBuffer, int i);

    void a(@NonNull d dVar, @NonNull byte[] bArr);

    int b();

    @NonNull
    ByteBuffer c();

    int d();

    void e();

    int f();

    int g();

    int h();

    void i();

    @Deprecated
    int j();

    int k();

    int l();

    int m();

    @Nullable
    Bitmap n();

    void o();
}
