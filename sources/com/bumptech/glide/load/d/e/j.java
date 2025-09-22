package com.bumptech.glide.load.d.e;

import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.k;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class j implements k<InputStream, c> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1371a = "StreamGifDecoder";

    /* renamed from: b  reason: collision with root package name */
    private final List<ImageHeaderParser> f1372b;

    /* renamed from: c  reason: collision with root package name */
    private final k<ByteBuffer, c> f1373c;
    private final b d;

    public j(List<ImageHeaderParser> list, k<ByteBuffer, c> kVar, b bVar) {
        this.f1372b = list;
        this.f1373c = kVar;
        this.d = bVar;
    }

    private u<c> a(@NonNull InputStream inputStream, int i, int i2, @NonNull com.bumptech.glide.load.j jVar) throws IOException {
        byte[] a2 = a(inputStream);
        if (a2 == null) {
            return null;
        }
        return this.f1373c.a(ByteBuffer.wrap(a2), i, i2, jVar);
    }

    private boolean a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.j jVar) throws IOException {
        return !((Boolean) jVar.a(i.f1370b)).booleanValue() && f.a(this.f1372b, inputStream, this.d) == ImageHeaderParser.ImageType.GIF;
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            if (!Log.isLoggable(f1371a, 5)) {
                return null;
            }
            Log.w(f1371a, "Error reading data from stream", e);
            return null;
        }
    }

    public final /* synthetic */ u a(@NonNull Object obj, int i, int i2, @NonNull com.bumptech.glide.load.j jVar) throws IOException {
        byte[] a2 = a((InputStream) obj);
        if (a2 == null) {
            return null;
        }
        return this.f1373c.a(ByteBuffer.wrap(a2), i, i2, jVar);
    }

    public final /* synthetic */ boolean a(@NonNull Object obj, @NonNull com.bumptech.glide.load.j jVar) throws IOException {
        return !((Boolean) jVar.a(i.f1370b)).booleanValue() && f.a(this.f1372b, (InputStream) obj, this.d) == ImageHeaderParser.ImageType.GIF;
    }
}
