package com.cyjh.elfin.e.c;

import java.io.File;
import java.util.Comparator;

public final class g implements Comparator<File> {
    private static int a(File file, File file2) {
        return Long.valueOf(file2.lastModified()).compareTo(Long.valueOf(file.lastModified()));
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return Long.valueOf(((File) obj2).lastModified()).compareTo(Long.valueOf(((File) obj).lastModified()));
    }
}
