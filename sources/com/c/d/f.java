package com.c.d;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.view.View;
import android.widget.ProgressBar;
import com.c.a;
import com.cyjh.elfin.a.b;

public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    ProgressBar f1571a;

    /* renamed from: b  reason: collision with root package name */
    ProgressDialog f1572b;

    /* renamed from: c  reason: collision with root package name */
    Activity f1573c;
    boolean d;
    int e;
    int f;
    private View g;
    private String h;

    public f(Object obj) {
        if (obj instanceof ProgressBar) {
            this.f1571a = (ProgressBar) obj;
        } else if (obj instanceof ProgressDialog) {
            this.f1572b = (ProgressDialog) obj;
        } else if (obj instanceof Activity) {
            this.f1573c = (Activity) obj;
        } else if (obj instanceof View) {
            this.g = (View) obj;
        }
    }

    private void a(int i) {
        if (i <= 0) {
            this.d = true;
            i = b.ak;
        }
        this.e = i;
        if (this.f1571a != null) {
            this.f1571a.setProgress(0);
            this.f1571a.setMax(i);
        }
        if (this.f1572b != null) {
            this.f1572b.setProgress(0);
            this.f1572b.setMax(i);
        }
    }

    private static void a(Object obj, String str, boolean z) {
        if (obj == null) {
            return;
        }
        if (obj instanceof View) {
            View view = (View) obj;
            ProgressBar progressBar = obj instanceof ProgressBar ? (ProgressBar) obj : null;
            if (z) {
                view.setTag(d.y, str);
                view.setVisibility(0);
                if (progressBar != null) {
                    progressBar.setProgress(0);
                    progressBar.setMax(100);
                    return;
                }
                return;
            }
            Object tag = view.getTag(d.y);
            if (tag == null || tag.equals(str)) {
                view.setTag(d.y, (Object) null);
                if (progressBar != null && progressBar.isIndeterminate()) {
                    view.setVisibility(8);
                }
            }
        } else if (obj instanceof Dialog) {
            Dialog dialog = (Dialog) obj;
            a aVar = new a(dialog.getContext());
            if (z) {
                aVar.a(dialog);
            } else {
                aVar.b(dialog);
            }
        } else if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            activity.setProgressBarIndeterminateVisibility(z);
            activity.setProgressBarVisibility(z);
            if (z) {
                activity.setProgress(0);
            }
        }
    }

    private void a(String str) {
        a();
        if (this.f1572b != null) {
            new a(this.f1572b.getContext()).a((Dialog) this.f1572b);
        }
        if (this.f1573c != null) {
            this.f1573c.setProgressBarIndeterminateVisibility(true);
            this.f1573c.setProgressBarVisibility(true);
        }
        if (this.f1571a != null) {
            this.f1571a.setTag(d.y, str);
            this.f1571a.setVisibility(0);
        }
        if (this.g != null) {
            this.g.setTag(d.y, str);
            this.g.setVisibility(0);
        }
    }

    private void b() {
        if (this.f1571a != null) {
            this.f1571a.setProgress(this.f1571a.getMax());
        }
        if (this.f1572b != null) {
            this.f1572b.setProgress(this.f1572b.getMax());
        }
        if (this.f1573c != null) {
            this.f1573c.setProgress(9999);
        }
    }

    private void b(int i) {
        int i2;
        int i3 = 1;
        if (this.f1571a != null) {
            this.f1571a.incrementProgressBy(this.d ? 1 : i);
        }
        if (this.f1572b != null) {
            ProgressDialog progressDialog = this.f1572b;
            if (!this.d) {
                i3 = i;
            }
            progressDialog.incrementProgressBy(i3);
        }
        if (this.f1573c != null) {
            if (this.d) {
                i2 = this.f;
                this.f = i2 + 1;
            } else {
                this.f += i;
                i2 = (this.f * b.ak) / this.e;
            }
            if (i2 > 9999) {
                i2 = 9999;
            }
            this.f1573c.setProgress(i2);
        }
    }

    private void b(String str) {
        if (a.b()) {
            c(str);
            return;
        }
        this.h = str;
        a.a((Runnable) this);
    }

    private void c(String str) {
        if (this.f1572b != null) {
            new a(this.f1572b.getContext()).b((Dialog) this.f1572b);
        }
        if (this.f1573c != null) {
            this.f1573c.setProgressBarIndeterminateVisibility(false);
            this.f1573c.setProgressBarVisibility(false);
        }
        if (this.f1571a != null) {
            this.f1571a.setTag(d.y, str);
            this.f1571a.setVisibility(0);
        }
        View view = this.f1571a;
        if (view == null) {
            view = this.g;
        }
        if (view != null) {
            Object tag = view.getTag(d.y);
            if (tag == null || tag.equals(str)) {
                view.setTag(d.y, (Object) null);
                if (this.f1571a != null && this.f1571a.isIndeterminate()) {
                    view.setVisibility(8);
                }
            }
        }
    }

    public final void a() {
        if (this.f1571a != null) {
            this.f1571a.setProgress(0);
            this.f1571a.setMax(b.ak);
        }
        if (this.f1572b != null) {
            this.f1572b.setProgress(0);
            this.f1572b.setMax(b.ak);
        }
        if (this.f1573c != null) {
            this.f1573c.setProgress(0);
        }
        this.d = false;
        this.f = 0;
        this.e = b.ak;
    }

    public final void run() {
        c(this.h);
    }
}
