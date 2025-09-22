package org.jdeferred;

public interface p<D, F, P> {

    public enum a {
        ;
        
        public static final int PENDING$173726b0 = 1;
        public static final int REJECTED$173726b0 = 2;
        public static final int RESOLVED$173726b0 = 3;

        static {
            $VALUES$2629dad5 = new int[]{PENDING$173726b0, REJECTED$173726b0, RESOLVED$173726b0};
        }

        public static int[] values$390417ea() {
            return (int[]) $VALUES$2629dad5.clone();
        }
    }

    p<D, F, P> a(a<D, F> aVar);

    p<D, F, P> a(g<D> gVar);

    p<D, F, P> a(g<D> gVar, j<F> jVar);

    p<D, F, P> a(g<D> gVar, j<F> jVar, m<P> mVar);

    <D_OUT, F_OUT, P_OUT> p<D_OUT, F_OUT, P_OUT> a(h<D, D_OUT> hVar);

    <D_OUT, F_OUT, P_OUT> p<D_OUT, F_OUT, P_OUT> a(h<D, D_OUT> hVar, k<F, F_OUT> kVar);

    <D_OUT, F_OUT, P_OUT> p<D_OUT, F_OUT, P_OUT> a(h<D, D_OUT> hVar, k<F, F_OUT> kVar, n<P, P_OUT> nVar);

    <D_OUT, F_OUT, P_OUT> p<D_OUT, F_OUT, P_OUT> a(i<D, D_OUT, F_OUT, P_OUT> iVar);

    <D_OUT, F_OUT, P_OUT> p<D_OUT, F_OUT, P_OUT> a(i<D, D_OUT, F_OUT, P_OUT> iVar, l<F, D_OUT, F_OUT, P_OUT> lVar);

    <D_OUT, F_OUT, P_OUT> p<D_OUT, F_OUT, P_OUT> a(i<D, D_OUT, F_OUT, P_OUT> iVar, l<F, D_OUT, F_OUT, P_OUT> lVar, o<P, D_OUT, F_OUT, P_OUT> oVar);

    p<D, F, P> a(j<F> jVar);

    p<D, F, P> a(m<P> mVar);

    void a(long j) throws InterruptedException;

    int b();

    p<D, F, P> b(g<D> gVar);

    boolean c();

    boolean d();

    boolean e();

    void f() throws InterruptedException;
}
