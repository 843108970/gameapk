package org.jdeferred.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class g<V> implements Callable<V> {

    /* renamed from: a  reason: collision with root package name */
    private final Future<V> f4376a;

    private g(Future<V> future) {
        this.f4376a = future;
    }

    public final V call() throws Exception {
        try {
            return this.f4376a.get();
        } catch (InterruptedException e) {
            throw e;
        } catch (ExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                throw ((Exception) e2.getCause());
            }
            throw e2;
        }
    }
}
