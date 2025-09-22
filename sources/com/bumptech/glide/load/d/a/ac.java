package com.bumptech.glide.load.d.a;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.k;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class ac<T> implements k<T, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public static final long f1288a = -1;
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    static final int f1289b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final i<Long> f1290c = i.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new i.a<Long>() {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f1291a = ByteBuffer.allocate(8);

        private void a(@NonNull byte[] bArr, @NonNull Long l, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f1291a) {
                this.f1291a.position(0);
                messageDigest.update(this.f1291a.putLong(l.longValue()).array());
            }
        }

        public final /* synthetic */ void a(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
            Long l = (Long) obj;
            messageDigest.update(bArr);
            synchronized (this.f1291a) {
                this.f1291a.position(0);
                messageDigest.update(this.f1291a.putLong(l.longValue()).array());
            }
        }
    });
    public static final i<Integer> d = i.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new i.a<Integer>() {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f1292a = ByteBuffer.allocate(4);

        private void a(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num != null) {
                messageDigest.update(bArr);
                synchronized (this.f1292a) {
                    this.f1292a.position(0);
                    messageDigest.update(this.f1292a.putInt(num.intValue()).array());
                }
            }
        }

        public final /* synthetic */ void a(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
            Integer num = (Integer) obj;
            if (num != null) {
                messageDigest.update(bArr);
                synchronized (this.f1292a) {
                    this.f1292a.position(0);
                    messageDigest.update(this.f1292a.putInt(num.intValue()).array());
                }
            }
        }
    });
    private static final String e = "VideoDecoder";
    private static final b f = new b();
    private final c<T> g;
    private final e h;
    private final b i;

    private static final class a implements c<AssetFileDescriptor> {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        private static void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        public final /* synthetic */ void a(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
            AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) obj;
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    @VisibleForTesting
    static class b {
        b() {
        }

        private static MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    @VisibleForTesting
    interface c<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    static final class d implements c<ParcelFileDescriptor> {
        d() {
        }

        private static void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }

        public final /* synthetic */ void a(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
            mediaMetadataRetriever.setDataSource(((ParcelFileDescriptor) obj).getFileDescriptor());
        }
    }

    ac(e eVar, c<T> cVar) {
        this(eVar, cVar, f);
    }

    @VisibleForTesting
    private ac(e eVar, c<T> cVar, b bVar) {
        this.h = eVar;
        this.g = cVar;
        this.i = bVar;
    }

    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i2) {
        return mediaMetadataRetriever.getFrameAtTime(j, i2);
    }

    @Nullable
    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i2, int i3, int i4, n nVar) {
        Bitmap b2 = (Build.VERSION.SDK_INT < 27 || i3 == Integer.MIN_VALUE || i4 == Integer.MIN_VALUE || nVar == n.f) ? null : b(mediaMetadataRetriever, j, i2, i3, i4, nVar);
        return b2 == null ? mediaMetadataRetriever.getFrameAtTime(j, i2) : b2;
    }

    public static k<AssetFileDescriptor, Bitmap> a(e eVar) {
        return new ac(eVar, new a((byte) 0));
    }

    @TargetApi(27)
    private static Bitmap b(MediaMetadataRetriever mediaMetadataRetriever, long j, int i2, int i3, int i4, n nVar) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                int i5 = parseInt2;
                parseInt2 = parseInt;
                parseInt = i5;
            }
            float a2 = nVar.a(parseInt, parseInt2, i3, i4);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i2, Math.round(((float) parseInt) * a2), Math.round(a2 * ((float) parseInt2)));
        } catch (Throwable th) {
            if (!Log.isLoggable(e, 3)) {
                return null;
            }
            Log.d(e, "Exception trying to decode frame on oreo+", th);
            return null;
        }
    }

    public static k<ParcelFileDescriptor, Bitmap> b(e eVar) {
        return new ac(eVar, new d());
    }

    public final u<Bitmap> a(@NonNull T t, int i2, int i3, @NonNull j jVar) throws IOException {
        long longValue = ((Long) jVar.a(f1290c)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) jVar.a(d);
            if (num == null) {
                num = 2;
            }
            n nVar = (n) jVar.a(n.h);
            if (nVar == null) {
                nVar = n.g;
            }
            n nVar2 = nVar;
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                this.g.a(mediaMetadataRetriever, t);
                int intValue = num.intValue();
                Bitmap bitmap = null;
                if (!(Build.VERSION.SDK_INT < 27 || i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE || nVar2 == n.f)) {
                    bitmap = b(mediaMetadataRetriever, longValue, intValue, i2, i3, nVar2);
                }
                if (bitmap == null) {
                    bitmap = mediaMetadataRetriever.getFrameAtTime(longValue, intValue);
                }
                mediaMetadataRetriever.release();
                return f.a(bitmap, this.h);
            } catch (RuntimeException e2) {
                throw new IOException(e2);
            } catch (Throwable th) {
                mediaMetadataRetriever.release();
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
    }

    public final boolean a(@NonNull T t, @NonNull j jVar) {
        return true;
    }
}
