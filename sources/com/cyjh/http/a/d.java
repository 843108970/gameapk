package com.cyjh.http.a;

import android.content.Context;
import android.os.AsyncTask;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.ak;
import com.cyjh.common.util.n;
import com.cyjh.http.e.b;
import java.io.File;
import java.util.concurrent.Executors;

public class d {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static String f2464c = "d";
    private static d d;

    /* renamed from: a  reason: collision with root package name */
    public Context f2465a;

    /* renamed from: b  reason: collision with root package name */
    b.a f2466b = new b.a() {
        public final void a(int i) {
        }

        public final void a(File file) {
            String c2 = d.f2464c;
            ad.c(c2, "onDownloadSuccess --> file=" + file.getName());
            new a(file).executeOnExecutor(Executors.newCachedThreadPool(), new Void[0]);
        }

        public final void a(Exception exc) {
            String c2 = d.f2464c;
            ad.c(c2, "onDownloadFailed --> exception=" + exc.getMessage());
            if (d.this.e != null) {
                d.this.e.c();
            }
        }
    };
    /* access modifiers changed from: private */
    public c e;

    private class a extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: b  reason: collision with root package name */
        private File f2469b;

        public a(File file) {
            this.f2469b = file;
        }

        private Boolean a() {
            boolean a2 = ak.a(this.f2469b, n.a(d.this.f2465a, com.cyjh.common.b.a.aO));
            n.c(this.f2469b);
            String c2 = d.f2464c;
            ad.c(c2, "DeleteZipTask doInBackground --> result=" + a2);
            return Boolean.valueOf(a2);
        }

        private void a(Boolean bool) {
            super.onPostExecute(bool);
            if (d.this.e == null) {
                return;
            }
            if (bool.booleanValue()) {
                d.this.e.b();
            } else {
                d.this.e.c();
            }
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            boolean a2 = ak.a(this.f2469b, n.a(d.this.f2465a, com.cyjh.common.b.a.aO));
            n.c(this.f2469b);
            String c2 = d.f2464c;
            ad.c(c2, "DeleteZipTask doInBackground --> result=" + a2);
            return Boolean.valueOf(a2);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            Boolean bool = (Boolean) obj;
            super.onPostExecute(bool);
            if (d.this.e == null) {
                return;
            }
            if (bool.booleanValue()) {
                d.this.e.b();
            } else {
                d.this.e.c();
            }
        }
    }

    private class b extends AsyncTask<String, Void, Void> {

        /* renamed from: b  reason: collision with root package name */
        private Context f2471b;

        public b(Context context) {
            this.f2471b = context;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public Void doInBackground(String... strArr) {
            try {
                File a2 = n.a(this.f2471b, com.cyjh.common.b.a.aO);
                File file = new File(a2, com.cyjh.common.b.a.aP);
                File file2 = new File(a2, com.cyjh.common.b.a.aP);
                n.c(file);
                n.c(file2);
                String substring = strArr[0].substring(strArr[0].lastIndexOf("/"));
                File a3 = n.a(strArr[1], substring);
                String c2 = d.f2464c;
                ad.c(c2, "LibraryDownloadTask doInBackground --> zipName=" + substring + ", file path = " + a3.getAbsolutePath());
                com.cyjh.http.e.b.a().a(strArr[0], a3.getParentFile().getAbsolutePath(), a3.getName(), -1, d.this.f2466b);
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public interface c {
        void a();

        void b();

        void c();
    }

    private d() {
    }

    public static d a() {
        if (d == null) {
            synchronized (d.class) {
                if (d == null) {
                    d = new d();
                }
            }
        }
        return d;
    }

    private d a(Context context) {
        this.f2465a = context;
        return this;
    }

    private void a(String str) {
        if (!b()) {
            String str2 = this.f2465a.getPackageName() + File.separator + com.cyjh.common.b.a.aO;
            ad.c(f2464c, "libraryDownloadTask --> path=" + str2);
            new b(this.f2465a).executeOnExecutor(Executors.newCachedThreadPool(), new String[]{str, str2});
        } else if (this.e != null) {
            this.e.a();
        }
    }

    public final void a(String str, c cVar) {
        ad.c(f2464c, "download --> url=" + str);
        this.e = cVar;
        if (!b()) {
            String str2 = this.f2465a.getPackageName() + File.separator + com.cyjh.common.b.a.aO;
            ad.c(f2464c, "libraryDownloadTask --> path=" + str2);
            new b(this.f2465a).executeOnExecutor(Executors.newCachedThreadPool(), new String[]{str, str2});
        } else if (this.e != null) {
            this.e.a();
        }
    }

    public final boolean b() {
        String str = this.f2465a.getFilesDir() + File.separator + com.cyjh.common.b.a.aO;
        File file = new File(str, com.cyjh.common.b.a.aP);
        File file2 = new File(str, com.cyjh.common.b.a.aQ);
        return file.exists() && file.length() > 0 && file2.exists() && file2.length() > 0;
    }
}
