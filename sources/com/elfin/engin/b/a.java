package com.elfin.engin.b;

import android.content.Context;
import android.util.Log;
import com.cyjh.common.util.s;
import java.io.File;

public final class a {
    private static com.elfin.engin.b.a.a a(Context context, String str, String str2, String str3) {
        Log.e("a111111", "getScriptModel " + str2 + s.a.f1696a + str + s.a.f1696a + str3);
        File file = new File(str2);
        return (str2 == null || !file.exists() || file.length() <= 0) ? new b(context, str, str3) : new c(context, str2, str3);
    }
}
