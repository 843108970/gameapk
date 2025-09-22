package com.b.b;

import android.support.v4.media.session.PlaybackStateCompat;

final class u {

    /* renamed from: a  reason: collision with root package name */
    static t f882a;

    /* renamed from: b  reason: collision with root package name */
    static long f883b;

    private u() {
    }

    static t a() {
        synchronized (u.class) {
            if (f882a == null) {
                return new t();
            }
            t tVar = f882a;
            f882a = tVar.f;
            tVar.f = null;
            f883b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return tVar;
        }
    }

    static void a(t tVar) {
        if (tVar.f != null || tVar.g != null) {
            throw new IllegalArgumentException();
        } else if (!tVar.d) {
            synchronized (u.class) {
                if (f883b + PlaybackStateCompat.ACTION_PLAY_FROM_URI <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    f883b += PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    tVar.f = f882a;
                    tVar.f881c = 0;
                    tVar.f880b = 0;
                    f882a = tVar;
                }
            }
        }
    }
}
