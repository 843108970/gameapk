package org.greenrobot.eventbus.util;

import android.app.Activity;
import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.c;

public final class a {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public final Constructor<?> f4348a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public final c f4349b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public final Object f4350c;
    private final Executor d;

    /* renamed from: org.greenrobot.eventbus.util.a$a  reason: collision with other inner class name */
    public static class C0067a {

        /* renamed from: a  reason: collision with root package name */
        private Executor f4353a;

        /* renamed from: b  reason: collision with root package name */
        private Class<?> f4354b;

        /* renamed from: c  reason: collision with root package name */
        private c f4355c;

        private C0067a() {
        }

        /* synthetic */ C0067a(byte b2) {
            this();
        }

        private C0067a a(Class<?> cls) {
            this.f4354b = cls;
            return this;
        }

        private C0067a a(Executor executor) {
            this.f4353a = executor;
            return this;
        }

        private C0067a a(c cVar) {
            this.f4355c = cVar;
            return this;
        }

        private a a() {
            return a((Object) null);
        }

        private a a(Activity activity) {
            return a((Object) activity.getClass());
        }

        public final a a(Object obj) {
            if (this.f4355c == null) {
                this.f4355c = c.a();
            }
            if (this.f4353a == null) {
                this.f4353a = Executors.newCachedThreadPool();
            }
            if (this.f4354b == null) {
                this.f4354b = f.class;
            }
            return new a(this.f4353a, this.f4355c, this.f4354b, obj, (byte) 0);
        }
    }

    public interface b {
        void a() throws Exception;
    }

    private a(Executor executor, c cVar, Class<?> cls, Object obj) {
        this.d = executor;
        this.f4349b = cVar;
        this.f4350c = obj;
        try {
            this.f4348a = cls.getConstructor(new Class[]{Throwable.class});
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Failure event class must have a constructor with one parameter of type Throwable", e);
        }
    }

    /* synthetic */ a(Executor executor, c cVar, Class cls, Object obj, byte b2) {
        this(executor, cVar, cls, obj);
    }

    private static C0067a a() {
        return new C0067a((byte) 0);
    }

    private void a(final b bVar) {
        this.d.execute(new Runnable() {
            public final void run() {
            }
        });
    }

    private static a b() {
        return new C0067a((byte) 0).a((Object) null);
    }
}
