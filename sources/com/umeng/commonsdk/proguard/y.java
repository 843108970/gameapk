package com.umeng.commonsdk.proguard;

import com.cyjh.common.util.s;

public class y {

    /* renamed from: a  reason: collision with root package name */
    private short[] f3836a;

    /* renamed from: b  reason: collision with root package name */
    private int f3837b = -1;

    public y(int i) {
        this.f3836a = new short[i];
    }

    private void d() {
        short[] sArr = new short[(this.f3836a.length * 2)];
        System.arraycopy(this.f3836a, 0, sArr, 0, this.f3836a.length);
        this.f3836a = sArr;
    }

    public short a() {
        short[] sArr = this.f3836a;
        int i = this.f3837b;
        this.f3837b = i - 1;
        return sArr[i];
    }

    public void a(short s) {
        if (this.f3836a.length == this.f3837b + 1) {
            d();
        }
        short[] sArr = this.f3836a;
        int i = this.f3837b + 1;
        this.f3837b = i;
        sArr[i] = s;
    }

    public short b() {
        return this.f3836a[this.f3837b];
    }

    public void c() {
        this.f3837b = -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ShortStack vector:[");
        for (int i = 0; i < this.f3836a.length; i++) {
            if (i != 0) {
                sb.append(s.a.f1696a);
            }
            if (i == this.f3837b) {
                sb.append(">>");
            }
            sb.append(this.f3836a[i]);
            if (i == this.f3837b) {
                sb.append("<<");
            }
        }
        sb.append("]>");
        return sb.toString();
    }
}
