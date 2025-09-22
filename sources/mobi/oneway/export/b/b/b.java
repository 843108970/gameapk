package mobi.oneway.export.b.b;

import com.umeng.commonsdk.amap.UMAmapConfig;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import mobi.oneway.export.enums.AdType;
import mobi.oneway.export.g.m;

public abstract class b<T> implements d {

    /* renamed from: a  reason: collision with root package name */
    protected T f4137a;

    /* renamed from: b  reason: collision with root package name */
    protected AdType f4138b;

    /* renamed from: c  reason: collision with root package name */
    private long f4139c = UMAmapConfig.AMAP_CACHE_WRITE_TIME;
    private Map<String, Boolean> d;
    private Map<String, Boolean> e;
    private volatile boolean f;
    private Timer g;
    private TimerTask h;
    private boolean i;

    public b(AdType adType, List<String> list, long j) {
        if (j != 0) {
            this.f4139c = j;
        }
        this.f4138b = adType;
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        a(list);
    }

    /* access modifiers changed from: private */
    public void f() {
        m.a((Object) "load ad timeout");
        this.f = true;
        i();
        mobi.oneway.export.e.b.a().c(new Runnable() {
            public void run() {
                if (b.this.g()) {
                    b.this.a(true);
                    b.this.a();
                    return;
                }
                b.this.a(false);
                b.this.a("load ad timeout");
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean g() {
        for (Map.Entry<String, Boolean> value : this.d.entrySet()) {
            if (((Boolean) value.getValue()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    private boolean h() {
        for (Map.Entry<String, Boolean> value : this.e.entrySet()) {
            if (!((Boolean) value.getValue()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    private void i() {
        if (this.h != null) {
            this.h.cancel();
            this.h = null;
        }
        if (this.g != null) {
            this.g.cancel();
            this.g = null;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    public void a(T t) {
        this.f4137a = t;
    }

    /* access modifiers changed from: protected */
    public abstract void a(String str);

    /* access modifiers changed from: protected */
    public void a(List<String> list) {
        if (list != null) {
            for (String next : list) {
                this.d.put(next, false);
                this.e.put(next, false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        this.i = z;
    }

    public boolean b() {
        return this.i;
    }

    public void c() {
        for (Map.Entry<String, Boolean> key : this.d.entrySet()) {
            this.d.put(key.getKey(), false);
        }
        for (Map.Entry<String, Boolean> key2 : this.e.entrySet()) {
            this.e.put(key2.getKey(), false);
        }
        if (this.g == null) {
            this.f = false;
            this.h = new TimerTask() {
                public void run() {
                    b.this.f();
                }
            };
            this.g = new Timer();
            this.g.schedule(this.h, this.f4139c);
        }
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        if (!h() || this.f) {
            return false;
        }
        i();
        a(true);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean e() {
        if (this.f || !h()) {
            return false;
        }
        i();
        if (!g()) {
            return true;
        }
        a(true);
        a();
        return false;
    }

    /* access modifiers changed from: protected */
    public void f(String str) {
        this.d.put(str, true);
        this.e.put(str, true);
    }

    /* access modifiers changed from: protected */
    public void g(String str) {
        this.e.put(str, true);
    }
}
