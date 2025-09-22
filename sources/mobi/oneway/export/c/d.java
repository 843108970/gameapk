package mobi.oneway.export.c;

import android.support.annotation.NonNull;
import java.lang.Thread;

public class d implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f4147a = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: b  reason: collision with root package name */
    private a f4148b;

    public d(a aVar) {
        this.f4148b = aVar;
    }

    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
        this.f4148b.a(th);
        if (this.f4147a != null) {
            this.f4147a.uncaughtException(thread, th);
        }
    }
}
