package com.cyjh.elfin.floatingwindowprocess.c;

public class b {

    /* renamed from: c  reason: collision with root package name */
    private static b f2007c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f2008a = false;

    /* renamed from: b  reason: collision with root package name */
    public a f2009b;

    public interface a {
        void a();

        void b();
    }

    public static b a() {
        if (f2007c == null) {
            synchronized (b.class) {
                if (f2007c == null) {
                    f2007c = new b();
                }
            }
        }
        return f2007c;
    }

    private void a(int i) {
        if (i == 2) {
            this.f2008a = true;
            if (this.f2009b != null) {
                this.f2009b.a();
            }
        } else if (i == 1) {
            this.f2008a = false;
            if (this.f2009b != null) {
                this.f2009b.b();
            }
        }
    }

    private void a(a aVar) {
        this.f2009b = aVar;
    }

    private boolean b() {
        return this.f2008a;
    }

    private void c() {
        this.f2009b = null;
    }
}
