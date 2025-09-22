package org.a;

public abstract class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final b<Object> f4267a = new b<>((byte) 0);

    private static final class a<T> extends c<T> {

        /* renamed from: b  reason: collision with root package name */
        private final T f4268b;

        /* renamed from: c  reason: collision with root package name */
        private final g f4269c;

        private a(T t, g gVar) {
            super((byte) 0);
            this.f4268b = t;
            this.f4269c = gVar;
        }

        /* synthetic */ a(Object obj, g gVar, byte b2) {
            this(obj, gVar);
        }

        public final <U> c<U> a(C0066c<? super T, U> cVar) {
            return cVar.a();
        }

        public final boolean a(k<T> kVar, String str) {
            if (kVar.a(this.f4268b)) {
                return true;
            }
            this.f4269c.a(str);
            kVar.a(this.f4268b, this.f4269c);
            return false;
        }
    }

    private static final class b<T> extends c<T> {
        private b() {
            super((byte) 0);
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final <U> c<U> a(C0066c<? super T, U> cVar) {
            return c.f4267a;
        }

        public final boolean a(k<T> kVar, String str) {
            return false;
        }
    }

    /* renamed from: org.a.c$c  reason: collision with other inner class name */
    public interface C0066c<I, O> {
        c<O> a();
    }

    private c() {
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    private static <T> c<T> a() {
        return f4267a;
    }

    private static <T> c<T> a(T t, g gVar) {
        return new a(t, gVar, (byte) 0);
    }

    private boolean a(k<T> kVar) {
        return a(kVar, "");
    }

    private <U> c<U> b(C0066c<? super T, U> cVar) {
        return a(cVar);
    }

    public abstract <U> c<U> a(C0066c<? super T, U> cVar);

    public abstract boolean a(k<T> kVar, String str);
}
