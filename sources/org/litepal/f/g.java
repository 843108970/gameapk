package org.litepal.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import org.litepal.LitePalApplication;
import org.litepal.e.a;
import org.litepal.f;
import org.litepal.g.b;

final class g extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4825a = "LitePalHelper";

    private g(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
    }

    g(String str, int i) {
        this(LitePalApplication.a(), str, i);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        f.a(sQLiteDatabase);
        f.d();
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        String str;
        f.b(sQLiteDatabase);
        String str2 = a.a().f;
        SharedPreferences.Editor edit = LitePalApplication.a().getSharedPreferences("litepal_prefs", 0).edit();
        if (TextUtils.isEmpty(str2)) {
            str = "litepal_version";
        } else {
            if (str2.endsWith(b.a.f4831a)) {
                str2 = str2.replace(b.a.f4831a, "");
            }
            str = "litepal_version_" + str2;
        }
        edit.putInt(str, i2);
        edit.apply();
        f.d();
    }
}
