package com.b.a.a.f;

import java.io.File;
import java.io.IOException;

final class b implements a {
    b() {
    }

    public final void a(File file) {
        if (!file.delete() && file.exists()) {
            throw new IOException("failed to delete " + file);
        }
    }
}
