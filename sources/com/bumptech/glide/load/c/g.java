package com.bumptech.glide.load.c;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.bumptech.glide.util.i;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

public class g implements com.bumptech.glide.load.g {
    private static final String e = "@#&=*+-_.,:!?()/~'%;$";

    /* renamed from: c  reason: collision with root package name */
    public final h f1227c;
    @Nullable
    public URL d;
    @Nullable
    private final URL f;
    @Nullable
    private final String g;
    @Nullable
    private String h;
    @Nullable
    private volatile byte[] i;
    private int j;

    public g(String str) {
        this(str, h.f1229b);
    }

    public g(String str, h hVar) {
        this.f = null;
        this.g = i.a(str);
        this.f1227c = (h) i.a(hVar, "Argument must not be null");
    }

    public g(URL url) {
        this(url, h.f1229b);
    }

    private g(URL url, h hVar) {
        this.f = (URL) i.a(url, "Argument must not be null");
        this.g = null;
        this.f1227c = (h) i.a(hVar, "Argument must not be null");
    }

    private URL b() throws MalformedURLException {
        if (this.d == null) {
            this.d = new URL(a());
        }
        return this.d;
    }

    private URL c() throws MalformedURLException {
        if (this.d == null) {
            this.d = new URL(a());
        }
        return this.d;
    }

    private String d() {
        return a();
    }

    private Map<String, String> e() {
        return this.f1227c.a();
    }

    private String f() {
        return this.g != null ? this.g : ((URL) i.a(this.f, "Argument must not be null")).toString();
    }

    private byte[] g() {
        if (this.i == null) {
            this.i = f().getBytes(f1387b);
        }
        return this.i;
    }

    public final String a() {
        if (TextUtils.isEmpty(this.h)) {
            String str = this.g;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) i.a(this.f, "Argument must not be null")).toString();
            }
            this.h = Uri.encode(str, e);
        }
        return this.h;
    }

    public final void a(@NonNull MessageDigest messageDigest) {
        if (this.i == null) {
            this.i = f().getBytes(f1387b);
        }
        messageDigest.update(this.i);
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            return f().equals(gVar.f()) && this.f1227c.equals(gVar.f1227c);
        }
    }

    public int hashCode() {
        if (this.j == 0) {
            this.j = f().hashCode();
            this.j = (this.j * 31) + this.f1227c.hashCode();
        }
        return this.j;
    }

    public String toString() {
        return f();
    }
}
