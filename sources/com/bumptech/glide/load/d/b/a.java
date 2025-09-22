package com.bumptech.glide.load.d.b;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.a.e;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class a implements e<ByteBuffer> {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f1340a;

    /* renamed from: com.bumptech.glide.load.d.b.a$a  reason: collision with other inner class name */
    public static class C0019a implements e.a<ByteBuffer> {
        @NonNull
        private static e<ByteBuffer> a(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }

        @NonNull
        public final /* synthetic */ e a(Object obj) {
            return new a((ByteBuffer) obj);
        }

        @NonNull
        public final Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.f1340a = byteBuffer;
    }

    @NonNull
    private ByteBuffer c() {
        this.f1340a.position(0);
        return this.f1340a;
    }

    @NonNull
    public final /* synthetic */ Object a() throws IOException {
        this.f1340a.position(0);
        return this.f1340a;
    }

    public final void b() {
    }
}
