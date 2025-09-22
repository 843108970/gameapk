package c;

import android.support.v4.media.session.PlaybackStateCompat;
import javax.annotation.Nullable;

final class v {

    /* renamed from: a  reason: collision with root package name */
    static final long f433a = 65536;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    static u f434b;

    /* renamed from: c  reason: collision with root package name */
    static long f435c;

    private v() {
    }

    static u a() {
        synchronized (v.class) {
            if (f434b == null) {
                return new u();
            }
            u uVar = f434b;
            f434b = uVar.h;
            uVar.h = null;
            f435c -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return uVar;
        }
    }

    static void a(u uVar) {
        if (uVar.h != null || uVar.i != null) {
            throw new IllegalArgumentException();
        } else if (!uVar.f) {
            synchronized (v.class) {
                if (f435c + PlaybackStateCompat.ACTION_PLAY_FROM_URI <= 65536) {
                    f435c += PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    uVar.h = f434b;
                    uVar.e = 0;
                    uVar.d = 0;
                    f434b = uVar;
                }
            }
        }
    }
}
