package com.elfin.ad.bean.response;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class FengLingAdInfo implements Parcelable {
    public static final Parcelable.Creator<FengLingAdInfo> CREATOR = new Parcelable.Creator<FengLingAdInfo>() {
        private static FengLingAdInfo a(Parcel parcel) {
            return new FengLingAdInfo(parcel);
        }

        private static FengLingAdInfo[] a(int i) {
            return new FengLingAdInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FengLingAdInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FengLingAdInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f2851a;

    /* renamed from: b  reason: collision with root package name */
    public int f2852b;

    /* renamed from: c  reason: collision with root package name */
    public int f2853c;
    public int d;
    public int e;
    public String f;
    public int g;
    public a h;
    public String i;
    public int j;
    public String k;
    public b l;
    public int m;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f2854a;

        /* renamed from: b  reason: collision with root package name */
        public int f2855b;

        /* renamed from: c  reason: collision with root package name */
        public String f2856c;

        public a() {
        }

        private int a() {
            return this.f2854a;
        }

        private void a(int i) {
            this.f2854a = i;
        }

        private void a(String str) {
            this.f2856c = str;
        }

        private int b() {
            return this.f2855b;
        }

        private void b(int i) {
            this.f2855b = i;
        }

        private String c() {
            return this.f2856c;
        }
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f2857a;

        /* renamed from: b  reason: collision with root package name */
        public List<String> f2858b;

        /* renamed from: c  reason: collision with root package name */
        public List<String> f2859c;
        public List<String> d;
        public List<String> e;

        public b() {
        }

        private int a() {
            return this.f2857a;
        }

        private void a(int i) {
            this.f2857a = i;
        }

        private void a(List<String> list) {
            this.f2858b = list;
        }

        private List<String> b() {
            return this.f2858b;
        }

        private void b(List<String> list) {
            this.f2859c = list;
        }

        private List<String> c() {
            return this.f2859c;
        }

        private void c(List<String> list) {
            this.d = list;
        }

        private List<String> d() {
            return this.d;
        }

        private void d(List<String> list) {
            this.e = list;
        }

        private List<String> e() {
            return this.e;
        }
    }

    public FengLingAdInfo() {
    }

    protected FengLingAdInfo(Parcel parcel) {
        this.f2851a = parcel.readInt();
        this.f2852b = parcel.readInt();
        this.f2853c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readInt();
        this.i = parcel.readString();
        this.j = parcel.readInt();
        this.k = parcel.readString();
        this.m = parcel.readInt();
    }

    private int a() {
        return this.f2851a;
    }

    private void a(int i2) {
        this.f2851a = i2;
    }

    private void a(a aVar) {
        this.h = aVar;
    }

    private void a(b bVar) {
        this.l = bVar;
    }

    private void a(String str) {
        this.f = str;
    }

    private int b() {
        return this.f2852b;
    }

    private void b(int i2) {
        this.f2852b = i2;
    }

    private void b(String str) {
        this.i = str;
    }

    private int c() {
        return this.f2853c;
    }

    private void c(int i2) {
        this.f2853c = i2;
    }

    private void c(String str) {
        this.k = str;
    }

    private int d() {
        return this.d;
    }

    private void d(int i2) {
        this.d = i2;
    }

    private int e() {
        return this.e;
    }

    private void e(int i2) {
        this.e = i2;
    }

    private String f() {
        return this.f;
    }

    private void f(int i2) {
        this.g = i2;
    }

    private int g() {
        return this.g;
    }

    private void g(int i2) {
        this.j = i2;
    }

    private a h() {
        return this.h;
    }

    private void h(int i2) {
        this.m = i2;
    }

    private String i() {
        return this.i;
    }

    private int j() {
        return this.j;
    }

    private String k() {
        return this.k;
    }

    private b l() {
        return this.l;
    }

    private int m() {
        return this.m;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f2851a);
        parcel.writeInt(this.f2852b);
        parcel.writeInt(this.f2853c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g);
        parcel.writeString(this.i);
        parcel.writeInt(this.j);
        parcel.writeString(this.k);
        parcel.writeInt(this.m);
    }
}
