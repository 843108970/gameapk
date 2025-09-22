package com.elfin.engin.a;

import android.content.Context;

public final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private a f2892a;

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final c f2893a = new c((byte) 0);

        private a() {
        }
    }

    private c() {
        try {
            this.f2892a = (a) Class.forName("com.cyjh.root.c").newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        }
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    private static c e() {
        return a.f2893a;
    }

    public final void a() {
    }

    public final void a(Context context) {
        this.f2892a.a(context);
    }

    public final void a(com.cyjh.common.f.a<String> aVar) {
        this.f2892a.a(aVar);
    }

    public final Context b() {
        return this.f2892a.b();
    }

    public final b c() {
        return this.f2892a.c();
    }

    public final void d() {
    }
}
