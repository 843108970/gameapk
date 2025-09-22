package org.jdeferred;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.jdeferred.b.b;
import org.jdeferred.b.c;

public interface e {

    public enum a {
        ;
        
        public static final int AUTO$273301ba = 2;
        public static final int DEFAULT$273301ba = 1;
        public static final int MANAUL$273301ba = 3;

        static {
            $VALUES$713c767f = new int[]{DEFAULT$273301ba, AUTO$273301ba, MANAUL$273301ba};
        }

        public static int[] values$2fa9be00() {
            return (int[]) $VALUES$713c767f.clone();
        }
    }

    p<Void, Throwable, Void> a(Runnable runnable);

    <D> p<D, Throwable, Void> a(Callable<D> callable);

    <D> p<D, Throwable, Void> a(Future<D> future);

    <D, P> p<D, Throwable, P> a(c<D, P> cVar);

    <D, P> p<D, Throwable, P> a(d<D, P> dVar);

    <P> p<Void, Throwable, P> a(f<P> fVar);

    <D, F, P> p<D, F, P> a(p<D, F, P> pVar);

    p<c, org.jdeferred.b.e, b> a(Runnable... runnableArr);

    p<c, org.jdeferred.b.e, b> a(Callable<?>... callableArr);

    p<c, org.jdeferred.b.e, b> a(Future<?>... futureArr);

    p<c, org.jdeferred.b.e, b> a(c<?, ?>... cVarArr);

    p<c, org.jdeferred.b.e, b> a(d<?, ?>... dVarArr);

    p<c, org.jdeferred.b.e, b> a(f<?>... fVarArr);

    p<c, org.jdeferred.b.e, b> a(p... pVarArr);
}
