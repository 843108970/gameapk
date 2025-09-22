package mobi.oneway.export.c;

import java.io.File;
import mobi.oneway.export.a.a;
import mobi.oneway.export.d.f;
import mobi.oneway.export.g.h;

public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private File f4145a;

    public b(File file) {
        this.f4145a = file;
    }

    public void run() {
        try {
            new f(a.e, a.f4101c).a(h.i(this.f4145a)).c("POST").n();
            this.f4145a.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
