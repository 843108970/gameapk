package mobi.oneway.export.c;

import android.content.Context;
import java.io.File;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import mobi.oneway.export.g.g;
import mobi.oneway.export.g.h;
import mobi.oneway.export.g.k;
import mobi.oneway.export.g.o;
import mobi.oneway.export.g.s;
import org.json.JSONObject;

class a {

    /* renamed from: a  reason: collision with root package name */
    private File f4143a;

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f4144b = Executors.newFixedThreadPool(5);

    public a(Context context) {
        this.f4143a = context.getDir(mobi.oneway.export.a.a.i, 0);
        b();
    }

    private void b() {
        File[] listFiles;
        if (this.f4143a != null && (listFiles = this.f4143a.listFiles()) != null && listFiles.length != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            for (File file : listFiles) {
                if (currentTimeMillis - file.lastModified() >= 604800000) {
                    file.delete();
                }
            }
        }
    }

    public void a() {
        File[] listFiles;
        if (this.f4143a != null && (listFiles = this.f4143a.listFiles()) != null && listFiles.length != 0) {
            for (File bVar : listFiles) {
                this.f4144b.execute(new b(bVar));
            }
        }
    }

    public void a(Throwable th) {
        if (this.f4143a != null) {
            try {
                String a2 = g.a(th);
                File file = this.f4143a;
                File file2 = new File(file, System.currentTimeMillis() + ".txt");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("createTime", s.b(new Date()));
                jSONObject.put("info", a2);
                k.a(jSONObject, o.a());
                k.a(jSONObject, o.b());
                h.b(file2, jSONObject.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
