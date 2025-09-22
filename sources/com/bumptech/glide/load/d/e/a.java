package com.bumptech.glide.load.d.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.c.b;
import com.bumptech.glide.c.d;
import com.bumptech.glide.c.e;
import com.bumptech.glide.c.g;
import com.bumptech.glide.f;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.k;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

public final class a implements k<ByteBuffer, c> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1347a = "BufferGifDecoder";

    /* renamed from: b  reason: collision with root package name */
    private static final C0020a f1348b = new C0020a();

    /* renamed from: c  reason: collision with root package name */
    private static final b f1349c = new b();
    private final Context d;
    private final List<ImageHeaderParser> e;
    private final b f;
    private final C0020a g;
    private final b h;

    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.d.e.a$a  reason: collision with other inner class name */
    static class C0020a {
        C0020a() {
        }

        private static com.bumptech.glide.c.b a(b.a aVar, d dVar, ByteBuffer byteBuffer, int i) {
            return new g(aVar, dVar, byteBuffer, i);
        }
    }

    @VisibleForTesting
    static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<e> f1350a = com.bumptech.glide.util.k.a(0);

        b() {
        }

        /* access modifiers changed from: package-private */
        public final synchronized e a(ByteBuffer byteBuffer) {
            e poll;
            poll = this.f1350a.poll();
            if (poll == null) {
                poll = new e();
            }
            return poll.a(byteBuffer);
        }

        /* access modifiers changed from: package-private */
        public final synchronized void a(e eVar) {
            eVar.f927c = null;
            eVar.d = null;
            this.f1350a.offer(eVar);
        }
    }

    private a(Context context) {
        this(context, f.b(context).f950c.a(), f.b(context).f948a, f.b(context).d);
    }

    public a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.b.a.e eVar, com.bumptech.glide.load.b.a.b bVar) {
        this(context, list, eVar, bVar, f1349c, f1348b);
    }

    @VisibleForTesting
    private a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.b.a.e eVar, com.bumptech.glide.load.b.a.b bVar, b bVar2, C0020a aVar) {
        this.d = context.getApplicationContext();
        this.e = list;
        this.g = aVar;
        this.h = new b(eVar, bVar);
        this.f = bVar2;
    }

    private static int a(d dVar, int i, int i2) {
        int min = Math.min(dVar.i / i2, dVar.h / i);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable(f1347a, 2) && max > 1) {
            Log.v(f1347a, "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + dVar.h + "x" + dVar.i + "]");
        }
        return max;
    }

    @Nullable
    private e a(ByteBuffer byteBuffer, int i, int i2, e eVar, j jVar) {
        int i3 = i;
        int i4 = i2;
        long a2 = com.bumptech.glide.util.e.a();
        try {
            d a3 = eVar.a();
            if (a3.e > 0) {
                if (a3.d == 0) {
                    Bitmap.Config config = jVar.a(i.f1369a) == com.bumptech.glide.load.b.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                    int min = Math.min(a3.i / i4, a3.h / i3);
                    int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
                    if (Log.isLoggable(f1347a, 2) && max > 1) {
                        Log.v(f1347a, "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i3 + "x" + i4 + "], actual dimens: [" + a3.h + "x" + a3.i + "]");
                    }
                    g gVar = new g(this.h, a3, byteBuffer, max);
                    gVar.a(config);
                    gVar.e();
                    Bitmap n = gVar.n();
                    if (n == null) {
                        if (Log.isLoggable(f1347a, 2)) {
                            Log.v(f1347a, "Decoded GIF from stream in " + com.bumptech.glide.util.e.a(a2));
                        }
                        return null;
                    }
                    e eVar2 = new e(new c(this.d, gVar, com.bumptech.glide.load.d.b.a(), i3, i4, n, (byte) 0));
                    if (Log.isLoggable(f1347a, 2)) {
                        Log.v(f1347a, "Decoded GIF from stream in " + com.bumptech.glide.util.e.a(a2));
                    }
                    return eVar2;
                }
            }
            if (Log.isLoggable(f1347a, 2)) {
                Log.v(f1347a, "Decoded GIF from stream in " + com.bumptech.glide.util.e.a(a2));
            }
            return null;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (Log.isLoggable(f1347a, 2)) {
                Log.v(f1347a, "Decoded GIF from stream in " + com.bumptech.glide.util.e.a(a2));
            }
            throw th2;
        }
    }

    /* access modifiers changed from: private */
    public e a(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull j jVar) {
        e a2 = this.f.a(byteBuffer);
        try {
            return a(byteBuffer, i, i2, a2, jVar);
        } finally {
            this.f.a(a2);
        }
    }

    private boolean a(@NonNull ByteBuffer byteBuffer, @NonNull j jVar) throws IOException {
        ImageHeaderParser.ImageType imageType;
        if (!((Boolean) jVar.a(i.f1370b)).booleanValue()) {
            List<ImageHeaderParser> list = this.e;
            if (byteBuffer != null) {
                int size = list.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    imageType = list.get(i).a(byteBuffer);
                    if (imageType != ImageHeaderParser.ImageType.UNKNOWN) {
                        break;
                    }
                    i++;
                }
            }
            imageType = ImageHeaderParser.ImageType.UNKNOWN;
            if (imageType == ImageHeaderParser.ImageType.GIF) {
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ boolean a(@NonNull Object obj, @NonNull j jVar) throws IOException {
        ImageHeaderParser.ImageType imageType;
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        if (!((Boolean) jVar.a(i.f1370b)).booleanValue()) {
            List<ImageHeaderParser> list = this.e;
            if (byteBuffer != null) {
                int size = list.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    imageType = list.get(i).a(byteBuffer);
                    if (imageType != ImageHeaderParser.ImageType.UNKNOWN) {
                        break;
                    }
                    i++;
                }
            }
            imageType = ImageHeaderParser.ImageType.UNKNOWN;
            if (imageType == ImageHeaderParser.ImageType.GIF) {
                return true;
            }
        }
        return false;
    }
}
