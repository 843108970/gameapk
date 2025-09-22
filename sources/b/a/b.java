package b.a;

public abstract class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    protected final String f41b;

    public b(String str, Object... objArr) {
        this.f41b = c.a(str, objArr);
    }

    public abstract void b();

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f41b);
        try {
            b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
