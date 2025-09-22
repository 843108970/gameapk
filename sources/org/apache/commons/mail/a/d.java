package org.apache.commons.mail.a;

import java.io.File;
import java.io.IOException;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

public final class d extends a {

    /* renamed from: b  reason: collision with root package name */
    private final File f4284b;

    public d() {
        this.f4284b = new File(".");
    }

    private d(File file) {
        this.f4284b = file;
    }

    private d(File file, boolean z) {
        super(z);
        this.f4284b = file;
    }

    private File a() {
        return this.f4284b;
    }

    public final DataSource resolve(String str) throws IOException {
        return resolve(str, this.f4281a);
    }

    public final DataSource resolve(String str, boolean z) throws IOException {
        if (str.startsWith("cid:")) {
            return null;
        }
        File file = new File(str);
        if (!file.isAbsolute()) {
            file = this.f4284b != null ? new File(this.f4284b, str) : new File(str);
        }
        if (file.exists()) {
            return new FileDataSource(file);
        }
        if (z) {
            return null;
        }
        throw new IOException("Cant resolve the following file resource :" + file.getAbsolutePath());
    }
}
