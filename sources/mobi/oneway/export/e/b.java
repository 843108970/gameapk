package mobi.oneway.export.e;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static List<Runnable> f4170a;

    /* renamed from: c  reason: collision with root package name */
    private static b f4171c;
    private static Handler d = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f4172b;

    private b() {
    }

    public static b a() {
        if (f4171c == null) {
            f4171c = new b();
        }
        return f4171c;
    }

    private static void e() {
        if (f4170a != null) {
            for (Runnable post : f4170a) {
                d.post(post);
            }
            f4170a.clear();
        }
    }

    private void f() {
        if (f4170a == null) {
            f4170a = new ArrayList();
        }
    }

    public void a(Runnable runnable) {
        try {
            if (this.f4172b) {
                d.post(runnable);
                return;
            }
            f();
            f4170a.add(runnable);
        } catch (Exception unused) {
        }
    }

    public void b() {
        this.f4172b = false;
        f();
    }

    public void b(Runnable runnable) {
        try {
            f4170a.remove(runnable);
        } catch (Exception unused) {
        }
    }

    public void c() {
        this.f4172b = true;
        e();
    }

    public void c(Runnable runnable) {
        d.post(runnable);
    }

    public boolean d() {
        return this.f4172b;
    }
}
