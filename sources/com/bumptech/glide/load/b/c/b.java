package com.bumptech.glide.load.b.c;

import android.os.Build;
import android.os.StrictMode;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1100a = "GlideRuntimeCompat";

    /* renamed from: b  reason: collision with root package name */
    private static final String f1101b = "cpu[0-9]+";

    /* renamed from: c  reason: collision with root package name */
    private static final String f1102c = "/sys/devices/system/cpu/";

    private b() {
    }

    /* JADX INFO: finally extract failed */
    static int a() {
        File[] fileArr;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            File file = new File(f1102c);
            final Pattern compile = Pattern.compile(f1101b);
            fileArr = file.listFiles(new FilenameFilter() {
                public final boolean accept(File file, String str) {
                    return compile.matcher(str).matches();
                }
            });
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
        return Math.max(1, fileArr != null ? fileArr.length : 0);
    }

    private static int b() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        return Build.VERSION.SDK_INT < 17 ? Math.max(a(), availableProcessors) : availableProcessors;
    }
}
