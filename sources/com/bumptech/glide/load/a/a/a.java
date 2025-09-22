package com.bumptech.glide.load.a.a;

import java.io.File;

final class a {
    a() {
    }

    private static File a(String str) {
        return new File(str);
    }

    private static boolean a(File file) {
        return file.exists();
    }

    private static long b(File file) {
        return file.length();
    }
}
