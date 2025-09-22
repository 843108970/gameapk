package com.google.a;

import com.google.a.c.a.a;

public class t {

    /* renamed from: a  reason: collision with root package name */
    public final float f3356a;

    /* renamed from: b  reason: collision with root package name */
    public final float f3357b;

    public t(float f, float f2) {
        this.f3356a = f;
        this.f3357b = f2;
    }

    private float a() {
        return this.f3356a;
    }

    public static float a(t tVar, t tVar2) {
        return a.a(tVar.f3356a, tVar.f3357b, tVar2.f3356a, tVar2.f3357b);
    }

    private static float a(t tVar, t tVar2, t tVar3) {
        float f = tVar2.f3356a;
        float f2 = tVar2.f3357b;
        return ((tVar3.f3356a - f) * (tVar.f3357b - f2)) - ((tVar3.f3357b - f2) * (tVar.f3356a - f));
    }

    public static void a(t[] tVarArr) {
        t tVar;
        t tVar2;
        t tVar3;
        float a2 = a(tVarArr[0], tVarArr[1]);
        float a3 = a(tVarArr[1], tVarArr[2]);
        float a4 = a(tVarArr[0], tVarArr[2]);
        if (a3 >= a2 && a3 >= a4) {
            tVar3 = tVarArr[0];
            tVar2 = tVarArr[1];
            tVar = tVarArr[2];
        } else if (a4 < a3 || a4 < a2) {
            tVar3 = tVarArr[2];
            tVar2 = tVarArr[0];
            tVar = tVarArr[1];
        } else {
            tVar3 = tVarArr[1];
            tVar2 = tVarArr[0];
            tVar = tVarArr[2];
        }
        float f = tVar3.f3356a;
        float f2 = tVar3.f3357b;
        if (((tVar.f3356a - f) * (tVar2.f3357b - f2)) - ((tVar.f3357b - f2) * (tVar2.f3356a - f)) < 0.0f) {
            t tVar4 = tVar;
            tVar = tVar2;
            tVar2 = tVar4;
        }
        tVarArr[0] = tVar2;
        tVarArr[1] = tVar3;
        tVarArr[2] = tVar;
    }

    private float b() {
        return this.f3357b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof t) {
            t tVar = (t) obj;
            return this.f3356a == tVar.f3356a && this.f3357b == tVar.f3357b;
        }
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f3356a) * 31) + Float.floatToIntBits(this.f3357b);
    }

    public final String toString() {
        return "(" + this.f3356a + ',' + this.f3357b + ')';
    }
}
