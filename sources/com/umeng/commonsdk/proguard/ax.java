package com.umeng.commonsdk.proguard;

public final class ax {

    /* renamed from: a  reason: collision with root package name */
    public final String f3732a;

    /* renamed from: b  reason: collision with root package name */
    public final byte f3733b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3734c;

    public ax() {
        this("", (byte) 0, 0);
    }

    public ax(String str, byte b2, int i) {
        this.f3732a = str;
        this.f3733b = b2;
        this.f3734c = i;
    }

    public final boolean a(ax axVar) {
        return this.f3732a.equals(axVar.f3732a) && this.f3733b == axVar.f3733b && this.f3734c == axVar.f3734c;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ax) {
            return a((ax) obj);
        }
        return false;
    }

    public final String toString() {
        return "<TMessage name:'" + this.f3732a + "' type: " + this.f3733b + " seqid:" + this.f3734c + ">";
    }
}
