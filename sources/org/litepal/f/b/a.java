package org.litepal.f.b;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f4812a;

    /* renamed from: b  reason: collision with root package name */
    public String f4813b;

    /* renamed from: c  reason: collision with root package name */
    public String f4814c;
    public int d;

    private String a() {
        return this.f4812a;
    }

    private void a(int i) {
        this.d = i;
    }

    private void a(String str) {
        this.f4812a = str;
    }

    private String b() {
        return this.f4813b;
    }

    private void b(String str) {
        this.f4813b = str;
    }

    private String c() {
        return this.f4814c;
    }

    private void c(String str) {
        this.f4814c = str;
    }

    private int d() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (aVar.f4812a == null || aVar.f4813b == null || aVar.d != this.d || !aVar.f4814c.equals(this.f4814c)) {
            return false;
        }
        if (!aVar.f4812a.equals(this.f4812a) || !aVar.f4813b.equals(this.f4813b) || !aVar.f4814c.equals(this.f4814c)) {
            return aVar.f4812a.equals(this.f4813b) && aVar.f4813b.equals(this.f4812a) && aVar.f4814c.equals(this.f4814c);
        }
        return true;
    }
}
