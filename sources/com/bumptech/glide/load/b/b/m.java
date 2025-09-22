package com.bumptech.glide.load.b.b;

import android.support.annotation.NonNull;
import android.support.v4.util.Pools;
import com.bumptech.glide.load.g;
import com.bumptech.glide.util.a.a;
import com.bumptech.glide.util.a.c;
import com.bumptech.glide.util.f;
import com.bumptech.glide.util.i;
import com.bumptech.glide.util.k;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    private final f<g, String> f1084a = new f<>(1000);

    /* renamed from: b  reason: collision with root package name */
    private final Pools.Pool<a> f1085b = com.bumptech.glide.util.a.a.a(10, new a.C0023a<a>() {
        private static a b() {
            try {
                return new a(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

        public final /* synthetic */ Object a() {
            return b();
        }
    });

    private static final class a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final MessageDigest f1087a;

        /* renamed from: b  reason: collision with root package name */
        private final c f1088b = new c.b();

        a(MessageDigest messageDigest) {
            this.f1087a = messageDigest;
        }

        @NonNull
        public final c g_() {
            return this.f1088b;
        }
    }

    private String b(g gVar) {
        a aVar = (a) i.a(this.f1085b.acquire(), "Argument must not be null");
        try {
            gVar.a(aVar.f1087a);
            return k.a(aVar.f1087a.digest());
        } finally {
            this.f1085b.release(aVar);
        }
    }

    public final String a(g gVar) {
        String b2;
        synchronized (this.f1084a) {
            b2 = this.f1084a.b(gVar);
        }
        if (b2 == null) {
            b2 = b(gVar);
        }
        synchronized (this.f1084a) {
            this.f1084a.b(gVar, b2);
        }
        return b2;
    }
}
