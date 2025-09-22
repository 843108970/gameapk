package com.umeng.commonsdk.proguard;

import java.io.Serializable;

public class an implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f3703a;

    /* renamed from: b  reason: collision with root package name */
    public final byte f3704b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3705c;
    private final boolean d;

    public an(byte b2) {
        this(b2, false);
    }

    public an(byte b2, String str) {
        this.f3704b = b2;
        this.f3703a = true;
        this.f3705c = str;
        this.d = false;
    }

    public an(byte b2, boolean z) {
        this.f3704b = b2;
        this.f3703a = false;
        this.f3705c = null;
        this.d = z;
    }

    public boolean a() {
        return this.f3703a;
    }

    public String b() {
        return this.f3705c;
    }

    public boolean c() {
        return this.f3704b == 12;
    }

    public boolean d() {
        return this.f3704b == 15 || this.f3704b == 13 || this.f3704b == 14;
    }

    public boolean e() {
        return this.d;
    }
}
