package com.b.b;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;

final class b implements w {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f847a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f848b;

    b(a aVar, w wVar) {
        this.f848b = aVar;
        this.f847a = wVar;
    }

    public final y a() {
        return this.f848b;
    }

    public final void a_(f fVar, long j) {
        aa.a(fVar.f855b, 0, j);
        while (true) {
            long j2 = 0;
            if (j > 0) {
                t tVar = fVar.f854a;
                while (true) {
                    if (j2 >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                        break;
                    }
                    long j3 = j2 + ((long) (fVar.f854a.f881c - fVar.f854a.f880b));
                    if (j3 >= j) {
                        j2 = j;
                        break;
                    }
                    j2 = j3;
                }
                this.f848b.c();
                try {
                    this.f847a.a_(fVar, j2);
                    this.f848b.a(true);
                    j -= j2;
                } catch (IOException e) {
                    throw this.f848b.b(e);
                } catch (Throwable th) {
                    this.f848b.a(false);
                    throw th;
                }
            } else {
                return;
            }
        }
    }

    public final void close() {
        this.f848b.c();
        try {
            this.f847a.close();
            this.f848b.a(true);
        } catch (IOException e) {
            throw this.f848b.b(e);
        } catch (Throwable th) {
            this.f848b.a(false);
            throw th;
        }
    }

    public final void flush() {
        this.f848b.c();
        try {
            this.f847a.flush();
            this.f848b.a(true);
        } catch (IOException e) {
            throw this.f848b.b(e);
        } catch (Throwable th) {
            this.f848b.a(false);
            throw th;
        }
    }

    public final String toString() {
        return "AsyncTimeout.sink(" + this.f847a + ")";
    }
}
