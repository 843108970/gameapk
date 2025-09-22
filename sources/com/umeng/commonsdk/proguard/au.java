package com.umeng.commonsdk.proguard;

public class au {

    /* renamed from: a  reason: collision with root package name */
    public final String f3724a;

    /* renamed from: b  reason: collision with root package name */
    public final byte f3725b;

    /* renamed from: c  reason: collision with root package name */
    public final short f3726c;

    public au() {
        this("", (byte) 0, 0);
    }

    public au(String str, byte b2, short s) {
        this.f3724a = str;
        this.f3725b = b2;
        this.f3726c = s;
    }

    public boolean a(au auVar) {
        return this.f3725b == auVar.f3725b && this.f3726c == auVar.f3726c;
    }

    public String toString() {
        return "<TField name:'" + this.f3724a + "' type:" + this.f3725b + " field-id:" + this.f3726c + ">";
    }
}
