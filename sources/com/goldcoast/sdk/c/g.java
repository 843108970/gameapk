package com.goldcoast.sdk.c;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static g f2943a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Context f2944b = null;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f2945c = false;

    private g() {
    }

    public static g a() {
        if (f2943a == null) {
            f2943a = new g();
        }
        return f2943a;
    }

    public static void a(Context context) {
        f2944b = context;
    }

    public static void a(String str) {
        if (f2945c) {
            Log.i("GOLD_COAST", str);
        }
    }

    public static void b(String str) {
        try {
            FileWriter fileWriter = new FileWriter(new File(f2944b.getFilesDir().getAbsolutePath() + File.separator + "dump"), true);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
