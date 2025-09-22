package org.junit.d;

import java.io.File;
import java.io.IOException;

public final class j extends e {

    /* renamed from: a  reason: collision with root package name */
    private final File f4548a;

    /* renamed from: b  reason: collision with root package name */
    private File f4549b;

    public j() {
        this((byte) 0);
    }

    private j(byte b2) {
        this.f4548a = null;
    }

    private static File a(File file) throws IOException {
        File createTempFile = File.createTempFile("junit", "", file);
        createTempFile.delete();
        createTempFile.mkdir();
        return createTempFile;
    }

    private File a(String str) throws IOException {
        File file = new File(f(), str);
        if (file.createNewFile()) {
            return file;
        }
        throw new IOException("a file with the name '" + str + "' already exists in the test folder");
    }

    private File a(String... strArr) throws IOException {
        File f = f();
        int i = 0;
        while (i <= 0) {
            String str = strArr[0];
            if (new File(str).getParent() != null) {
                throw new IOException("Folder name cannot consist of multiple path components separated by a file separator. Please use newFolder('MyParentFolder','MyFolder') to create hierarchies of folders");
            }
            File file = new File(f, str);
            if (!file.mkdir()) {
                boolean z = true;
                if (strArr.length - 1 != 0) {
                    z = false;
                }
                if (z) {
                    throw new IOException("a folder with the name '" + str + "' already exists");
                }
            }
            i++;
            f = file;
        }
        return f;
    }

    private static boolean a(int i, String[] strArr) {
        return i == strArr.length - 1;
    }

    private File b(String str) throws IOException {
        String[] strArr = {str};
        File f = f();
        int i = 0;
        while (i <= 0) {
            String str2 = strArr[0];
            if (new File(str2).getParent() != null) {
                throw new IOException("Folder name cannot consist of multiple path components separated by a file separator. Please use newFolder('MyParentFolder','MyFolder') to create hierarchies of folders");
            }
            File file = new File(f, str2);
            if (!file.mkdir()) {
                throw new IOException("a folder with the name '" + str2 + "' already exists");
            }
            i++;
            f = file;
        }
        return f;
    }

    private void b(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File b2 : listFiles) {
                b(b2);
            }
        }
        file.delete();
    }

    private void c() throws IOException {
        this.f4549b = a(this.f4548a);
    }

    private static void c(String str) throws IOException {
        if (new File(str).getParent() != null) {
            throw new IOException("Folder name cannot consist of multiple path components separated by a file separator. Please use newFolder('MyParentFolder','MyFolder') to create hierarchies of folders");
        }
    }

    private File d() throws IOException {
        return File.createTempFile("junit", (String) null, f());
    }

    private File e() throws IOException {
        return a(f());
    }

    private File f() {
        if (this.f4549b != null) {
            return this.f4549b;
        }
        throw new IllegalStateException("the temporary folder has not yet been created");
    }

    private void g() {
        if (this.f4549b != null) {
            b(this.f4549b);
        }
    }

    /* access modifiers changed from: protected */
    public final void a() throws Throwable {
        this.f4549b = a(this.f4548a);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        if (this.f4549b != null) {
            b(this.f4549b);
        }
    }
}
