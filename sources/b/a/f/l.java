package b.a.f;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class l {

    /* renamed from: a  reason: collision with root package name */
    final CountDownLatch f174a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    long f175b = -1;

    /* renamed from: c  reason: collision with root package name */
    long f176c = -1;

    l() {
    }

    private long a(long j, TimeUnit timeUnit) throws InterruptedException {
        if (this.f174a.await(j, timeUnit)) {
            return this.f176c - this.f175b;
        }
        return -2;
    }

    private void a() {
        if (this.f175b != -1) {
            throw new IllegalStateException();
        }
        this.f175b = System.nanoTime();
    }

    private void b() {
        if (this.f176c != -1 || this.f175b == -1) {
            throw new IllegalStateException();
        }
        this.f176c = System.nanoTime();
        this.f174a.countDown();
    }

    private void c() {
        if (this.f176c != -1 || this.f175b == -1) {
            throw new IllegalStateException();
        }
        this.f176c = this.f175b - 1;
        this.f174a.countDown();
    }

    private long d() throws InterruptedException {
        this.f174a.await();
        return this.f176c - this.f175b;
    }
}
