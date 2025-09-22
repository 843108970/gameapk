package com.google.a.g.a.a.a;

final class m {

    /* renamed from: a  reason: collision with root package name */
    int f3160a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f3161b = a.NUMERIC$1376b33b;

    private enum a {
        ;
        
        public static final int ALPHA$1376b33b = 2;
        public static final int ISO_IEC_646$1376b33b = 3;
        public static final int NUMERIC$1376b33b = 1;

        static {
            $VALUES$3d17980a = new int[]{NUMERIC$1376b33b, ALPHA$1376b33b, ISO_IEC_646$1376b33b};
        }

        public static int[] values$3fa6840b() {
            return (int[]) $VALUES$3d17980a.clone();
        }
    }

    m() {
    }

    private int a() {
        return this.f3160a;
    }

    private void b(int i) {
        this.f3160a = i;
    }

    private boolean b() {
        return this.f3161b == a.ALPHA$1376b33b;
    }

    private boolean c() {
        return this.f3161b == a.NUMERIC$1376b33b;
    }

    private boolean d() {
        return this.f3161b == a.ISO_IEC_646$1376b33b;
    }

    private void e() {
        this.f3161b = a.NUMERIC$1376b33b;
    }

    private void f() {
        this.f3161b = a.ALPHA$1376b33b;
    }

    private void g() {
        this.f3161b = a.ISO_IEC_646$1376b33b;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i) {
        this.f3160a += i;
    }
}
