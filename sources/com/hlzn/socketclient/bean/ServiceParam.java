package com.hlzn.socketclient.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ServiceParam implements Parcelable {
    public static final Parcelable.Creator<ServiceParam> CREATOR = new Parcelable.Creator<ServiceParam>() {
        private static ServiceParam a(Parcel parcel) {
            return new ServiceParam(parcel);
        }

        private static ServiceParam[] a(int i) {
            return new ServiceParam[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ServiceParam(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ServiceParam[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static final int f3430a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f3431b = -1;

    /* renamed from: c  reason: collision with root package name */
    public String f3432c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public int h = -1;
    public String i;
    public int j = -1;
    public String k;
    public int l = -1;
    public String m;
    public int n = -1;
    public String o;
    public int p = -1;
    public String q;
    public int r = -1;
    public String s;
    public int t = -1;
    public String u;

    public ServiceParam() {
    }

    protected ServiceParam(Parcel parcel) {
        this.f3432c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readByte() != 0;
        this.h = parcel.readInt();
        this.i = parcel.readString();
        this.j = parcel.readInt();
        this.k = parcel.readString();
        this.l = parcel.readInt();
        this.m = parcel.readString();
        this.n = parcel.readInt();
        this.o = parcel.readString();
        this.p = parcel.readInt();
        this.q = parcel.readString();
        this.r = parcel.readInt();
        this.s = parcel.readString();
        this.t = parcel.readInt();
        this.u = parcel.readString();
    }

    private String a() {
        return this.f3432c;
    }

    private void a(int i2) {
        this.h = i2;
    }

    private void a(String str) {
        this.f3432c = str;
    }

    private void a(boolean z) {
        this.g = z;
    }

    private String b() {
        return this.d;
    }

    private void b(int i2) {
        this.j = i2;
    }

    private void b(String str) {
        this.d = str;
    }

    private String c() {
        return this.e;
    }

    private void c(int i2) {
        this.l = i2;
    }

    private void c(String str) {
        this.e = str;
    }

    private String d() {
        return this.f;
    }

    private void d(int i2) {
        this.n = i2;
    }

    private void d(String str) {
        this.f = str;
    }

    private void e(int i2) {
        this.p = i2;
    }

    private void e(String str) {
        this.i = str;
    }

    private boolean e() {
        return this.g;
    }

    private int f() {
        return this.h;
    }

    private void f(int i2) {
        this.r = i2;
    }

    private void f(String str) {
        this.k = str;
    }

    private String g() {
        return this.i;
    }

    private void g(int i2) {
        this.t = i2;
    }

    private void g(String str) {
        this.m = str;
    }

    private int h() {
        return this.j;
    }

    private void h(String str) {
        this.o = str;
    }

    private String i() {
        return this.k;
    }

    private void i(String str) {
        this.q = str;
    }

    private int j() {
        return this.l;
    }

    private void j(String str) {
        this.s = str;
    }

    private String k() {
        return this.m;
    }

    private void k(String str) {
        this.u = str;
    }

    private int l() {
        return this.n;
    }

    private String m() {
        return this.o;
    }

    private int n() {
        return this.p;
    }

    private String o() {
        return this.q;
    }

    private int p() {
        return this.r;
    }

    private String q() {
        return this.s;
    }

    private int r() {
        return this.t;
    }

    private String s() {
        return this.u;
    }

    private static Parcelable.Creator<ServiceParam> t() {
        return CREATOR;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f3432c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeByte(this.g ? (byte) 1 : 0);
        parcel.writeInt(this.h);
        parcel.writeString(this.i);
        parcel.writeInt(this.j);
        parcel.writeString(this.k);
        parcel.writeInt(this.l);
        parcel.writeString(this.m);
        parcel.writeInt(this.n);
        parcel.writeString(this.o);
        parcel.writeInt(this.p);
        parcel.writeString(this.q);
        parcel.writeInt(this.r);
        parcel.writeString(this.s);
        parcel.writeInt(this.t);
        parcel.writeString(this.u);
    }
}
