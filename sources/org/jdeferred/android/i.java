package org.jdeferred.android;

import android.os.AsyncTask;
import java.util.concurrent.CancellationException;
import org.jdeferred.a.d;
import org.jdeferred.e;
import org.jdeferred.p;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class i<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {

    /* renamed from: a  reason: collision with root package name */
    protected final Logger f4393a;

    /* renamed from: b  reason: collision with root package name */
    final d<Result, Throwable, Progress> f4394b;

    /* renamed from: c  reason: collision with root package name */
    final int f4395c;
    private Throwable d;

    public i() {
        this.f4393a = LoggerFactory.getLogger(i.class);
        this.f4394b = new d<>();
        this.f4395c = e.a.DEFAULT$273301ba;
    }

    private i(int i) {
        this.f4393a = LoggerFactory.getLogger(i.class);
        this.f4394b = new d<>();
        this.f4395c = i;
    }

    private void a(Progress progress) {
        publishProgress(new Object[]{progress});
    }

    private p<Result, Throwable, Progress> b() {
        return this.f4394b;
    }

    private int c() {
        return this.f4395c;
    }

    /* access modifiers changed from: protected */
    public abstract Result a() throws Exception;

    /* access modifiers changed from: protected */
    public final Result doInBackground(Params... paramsArr) {
        try {
            return a();
        } catch (Throwable th) {
            this.d = th;
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final void onCancelled() {
        this.f4394b.b(new CancellationException());
    }

    /* access modifiers changed from: protected */
    public final void onCancelled(Result result) {
        this.f4394b.b(new CancellationException());
    }

    /* access modifiers changed from: protected */
    public final void onPostExecute(Result result) {
        if (this.d != null) {
            this.f4394b.b(this.d);
        } else {
            this.f4394b.a(result);
        }
    }

    /* access modifiers changed from: protected */
    public final void onProgressUpdate(Progress... progressArr) {
        if (progressArr == null || progressArr.length == 0) {
            this.f4394b.c(null);
        } else if (progressArr.length > 0) {
            this.f4393a.warn("There were multiple progress values.  Only the first one was used!");
            this.f4394b.c(progressArr[0]);
        }
    }
}
