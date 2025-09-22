package mobi.oneway.export;

import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import mobi.oneway.export.a.a;
import mobi.oneway.export.a.d;
import mobi.oneway.export.e.c;
import mobi.oneway.export.enums.PluginErrorType;
import mobi.oneway.export.g.g;
import mobi.oneway.export.g.h;
import mobi.oneway.export.g.j;
import mobi.oneway.export.g.m;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static ClassLoader f4106a;

    public static Class a(String str) {
        try {
            return a().loadClass(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static ClassLoader a() {
        try {
            if (f4106a == null) {
                e();
                f4106a = d.a() ? b.class.getClassLoader() : new DexClassLoader(b(), c(), (String) null, b.class.getClassLoader());
            }
            return f4106a;
        } catch (Exception e) {
            c.a(PluginErrorType.shell_error_classloader, g.a((Throwable) e));
            return null;
        }
    }

    private static String b() {
        if (mobi.oneway.export.a.b.a() == null) {
            return "";
        }
        return mobi.oneway.export.a.b.a().getDir("plugin", 0).getPath() + File.separator + a.j;
    }

    private static String c() {
        return mobi.oneway.export.a.b.a() != null ? mobi.oneway.export.a.b.a().getDir(a.h, 0).getPath() : "";
    }

    private static String d() {
        return mobi.oneway.export.a.b.a() != null ? mobi.oneway.export.a.b.a().getDir("plugin", 0).getPath() : "";
    }

    private static void e() {
        InputStream inputStream;
        IOException e;
        if (mobi.oneway.export.a.b.a() == null) {
            m.d("context is null,please invoke OnewaySdk.init method first");
            return;
        }
        f();
        if (!h.a(b())) {
            try {
                inputStream = mobi.oneway.export.a.b.a().getAssets().open(mobi.oneway.export.a.c.a() + File.separator + mobi.oneway.export.a.c.b());
                try {
                    byte[] bArr = new byte[inputStream.available()];
                    inputStream.read(bArr);
                    h.a(new File(b()), bArr);
                    j.a(inputStream);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        m.d("load local default OnewaySdk failed");
                        c.a(PluginErrorType.shell_error_assetsIo, g.a((Throwable) e));
                        j.a(inputStream);
                    } catch (Throwable th) {
                        th = th;
                        j.a(inputStream);
                        throw th;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                inputStream = null;
                m.d("load local default OnewaySdk failed");
                c.a(PluginErrorType.shell_error_assetsIo, g.a((Throwable) e));
                j.a(inputStream);
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
                j.a(inputStream);
                throw th;
            }
        }
    }

    private static void f() {
        File[] listFiles;
        File file = new File(d());
        if (h.e(file) && (listFiles = file.listFiles(new FileFilter() {
            public final boolean accept(File file) {
                return file.getName().startsWith("OnewaySdk");
            }
        })) != null) {
            for (File file2 : listFiles) {
                if (!file2.getName().equals(a.j)) {
                    h.j(file2);
                }
            }
        }
    }
}
