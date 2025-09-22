package com.google.a.d.c;

import com.google.a.f;
import java.nio.charset.StandardCharsets;

final class h {

    /* renamed from: a  reason: collision with root package name */
    final String f3116a;

    /* renamed from: b  reason: collision with root package name */
    l f3117b;

    /* renamed from: c  reason: collision with root package name */
    f f3118c;
    f d;
    final StringBuilder e;
    int f;
    int g;
    k h;
    int i;

    h(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        int i2 = 0;
        while (i2 < length) {
            char c2 = (char) (bytes[i2] & 255);
            if (c2 != '?' || str.charAt(i2) == '?') {
                sb.append(c2);
                i2++;
            } else {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
        }
        this.f3116a = sb.toString();
        this.f3117b = l.FORCE_NONE;
        this.e = new StringBuilder(str.length());
        this.g = -1;
    }

    private void a(l lVar) {
        this.f3117b = lVar;
    }

    private void a(f fVar, f fVar2) {
        this.f3118c = fVar;
        this.d = fVar2;
    }

    private void b(int i2) {
        this.g = i2;
    }

    private String e() {
        return this.f3116a;
    }

    private void f() {
        this.i = 2;
    }

    private char g() {
        return this.f3116a.charAt(this.f);
    }

    private StringBuilder h() {
        return this.e;
    }

    private int i() {
        return this.e.length();
    }

    private int j() {
        return this.g;
    }

    private void k() {
        this.g = -1;
    }

    private int l() {
        return this.f3116a.length() - this.i;
    }

    private k m() {
        return this.h;
    }

    private void n() {
        this.h = null;
    }

    public final char a() {
        return this.f3116a.charAt(this.f);
    }

    public final void a(char c2) {
        this.e.append(c2);
    }

    public final void a(int i2) {
        if (this.h == null || i2 > this.h.f3126b) {
            this.h = k.a(i2, this.f3117b, this.f3118c, this.d, true);
        }
    }

    public final void a(String str) {
        this.e.append(str);
    }

    public final boolean b() {
        return this.f < l();
    }

    public final int c() {
        return l() - this.f;
    }

    public final void d() {
        a(this.e.length());
    }
}
