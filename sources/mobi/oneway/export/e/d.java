package mobi.oneway.export.e;

public class d extends Thread {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f4174a;

    /* renamed from: b  reason: collision with root package name */
    private long f4175b = 5000;

    /* renamed from: c  reason: collision with root package name */
    private long f4176c;
    private boolean d = false;

    public interface a {
        void timeout();
    }

    public d(a aVar, long j) {
        this.f4174a = aVar;
        if (j != 0) {
            this.f4175b = j;
        }
    }

    public void run() {
        super.run();
        this.f4176c = System.currentTimeMillis();
        while (!b.a().d() && !this.d) {
            if (System.currentTimeMillis() - this.f4176c > this.f4175b) {
                this.d = true;
                if (this.f4174a != null) {
                    b.a().c(new Runnable() {
                        public void run() {
                            d.this.f4174a.timeout();
                        }
                    });
                }
            }
        }
    }
}
