package b.a.g;

import c.p;
import c.x;
import c.y;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f181a = new a() {
        public final y a(File file) throws FileNotFoundException {
            return p.a(file);
        }

        public final void a(File file, File file2) throws IOException {
            d(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }

        public final x b(File file) throws FileNotFoundException {
            try {
                return p.b(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return p.b(file);
            }
        }

        public final x c(File file) throws FileNotFoundException {
            try {
                return p.c(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return p.c(file);
            }
        }

        public final void d(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete " + file);
            }
        }

        public final boolean e(File file) {
            return file.exists();
        }

        public final long f(File file) {
            return file.length();
        }

        public final void g(File file) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                throw new IOException("not a readable directory: " + file);
            }
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    g(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete " + file2);
                }
            }
        }
    };

    y a(File file) throws FileNotFoundException;

    void a(File file, File file2) throws IOException;

    x b(File file) throws FileNotFoundException;

    x c(File file) throws FileNotFoundException;

    void d(File file) throws IOException;

    boolean e(File file);

    long f(File file);

    void g(File file) throws IOException;
}
