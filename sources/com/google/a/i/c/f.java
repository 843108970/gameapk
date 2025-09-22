package com.google.a.i.c;

import com.google.a.i.a.h;
import com.google.a.i.a.j;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3343a = 8;

    /* renamed from: b  reason: collision with root package name */
    h f3344b;

    /* renamed from: c  reason: collision with root package name */
    com.google.a.i.a.f f3345c;
    j d;
    int e = -1;
    public b f;

    private h a() {
        return this.f3344b;
    }

    private void a(int i) {
        this.e = i;
    }

    private void a(com.google.a.i.a.f fVar) {
        this.f3345c = fVar;
    }

    private void a(h hVar) {
        this.f3344b = hVar;
    }

    private void a(j jVar) {
        this.d = jVar;
    }

    private void a(b bVar) {
        this.f = bVar;
    }

    private com.google.a.i.a.f b() {
        return this.f3345c;
    }

    private static boolean b(int i) {
        return i >= 0 && i < 8;
    }

    private j c() {
        return this.d;
    }

    private int d() {
        return this.e;
    }

    private b e() {
        return this.f;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f3344b);
        sb.append("\n ecLevel: ");
        sb.append(this.f3345c);
        sb.append("\n version: ");
        sb.append(this.d);
        sb.append("\n maskPattern: ");
        sb.append(this.e);
        if (this.f == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f);
        }
        sb.append(">>\n");
        return sb.toString();
    }
}
