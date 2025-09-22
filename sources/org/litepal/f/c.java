package org.litepal.f;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import java.io.File;
import org.litepal.LitePalApplication;
import org.litepal.c.d;
import org.litepal.e.a;
import org.litepal.g.b;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static g f4824a;

    public static synchronized SQLiteDatabase a() {
        String str;
        SQLiteDatabase writableDatabase;
        synchronized (c.class) {
            a a2 = a.a();
            if (TextUtils.isEmpty(a2.f4730b)) {
                a.b();
                if (TextUtils.isEmpty(a2.f4730b)) {
                    throw new d(d.DBNAME_IS_EMPTY_OR_NOT_DEFINED);
                }
            }
            if (!a2.f4730b.endsWith(b.a.f4831a)) {
                a2.f4730b += b.a.f4831a;
            }
            if (a2.f4729a <= 0) {
                throw new d(d.VERSION_OF_DATABASE_LESS_THAN_ONE);
            }
            int i = a2.f4729a;
            String str2 = a2.f;
            SharedPreferences sharedPreferences = LitePalApplication.a().getSharedPreferences("litepal_prefs", 0);
            if (TextUtils.isEmpty(str2)) {
                str = "litepal_version";
            } else {
                if (str2.endsWith(b.a.f4831a)) {
                    str2 = str2.replace(b.a.f4831a, "");
                }
                str = "litepal_version_" + str2;
            }
            if (i < sharedPreferences.getInt(str, 0)) {
                throw new d(d.VERSION_IS_EARLIER_THAN_CURRENT);
            }
            if (TextUtils.isEmpty(a2.f4731c)) {
                a2.f4731c = b.a.f4833c;
            } else if (!a2.f4731c.equals(b.a.f4832b) && !a2.f4731c.equals(b.a.f4833c) && !a2.f4731c.equals(b.a.d)) {
                throw new d(a2.f4731c + d.CASES_VALUE_IS_INVALID);
            }
            if (f4824a == null) {
                String str3 = a2.f4730b;
                if ("external".equalsIgnoreCase(a2.d)) {
                    str3 = LitePalApplication.a().getExternalFilesDir("") + com.umeng.analytics.pro.c.f3569b + str3;
                } else if (!com.umeng.commonsdk.framework.c.d.equalsIgnoreCase(a2.d) && !TextUtils.isEmpty(a2.d)) {
                    String replace = (Environment.getExternalStorageDirectory().getPath() + "/" + a2.d).replace("//", "/");
                    if (!org.litepal.g.a.a("android.support.v4.content.ContextCompat", "checkSelfPermission") || ContextCompat.checkSelfPermission(LitePalApplication.a(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                        File file = new File(replace);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        str3 = replace + "/" + str3;
                    } else {
                        throw new org.litepal.c.b(String.format(org.litepal.c.b.EXTERNAL_STORAGE_PERMISSION_DENIED, new Object[]{replace}));
                    }
                }
                f4824a = new g(str3, a2.f4729a);
            }
            writableDatabase = f4824a.getWritableDatabase();
        }
        return writableDatabase;
    }

    public static void b() {
        if (f4824a != null) {
            f4824a.getWritableDatabase().close();
            f4824a = null;
        }
    }

    private static SQLiteDatabase c() {
        return a();
    }

    private static g d() {
        String str;
        a a2 = a.a();
        if (TextUtils.isEmpty(a2.f4730b)) {
            a.b();
            if (TextUtils.isEmpty(a2.f4730b)) {
                throw new d(d.DBNAME_IS_EMPTY_OR_NOT_DEFINED);
            }
        }
        if (!a2.f4730b.endsWith(b.a.f4831a)) {
            a2.f4730b += b.a.f4831a;
        }
        if (a2.f4729a <= 0) {
            throw new d(d.VERSION_OF_DATABASE_LESS_THAN_ONE);
        }
        int i = a2.f4729a;
        String str2 = a2.f;
        SharedPreferences sharedPreferences = LitePalApplication.a().getSharedPreferences("litepal_prefs", 0);
        if (TextUtils.isEmpty(str2)) {
            str = "litepal_version";
        } else {
            if (str2.endsWith(b.a.f4831a)) {
                str2 = str2.replace(b.a.f4831a, "");
            }
            str = "litepal_version_" + str2;
        }
        if (i < sharedPreferences.getInt(str, 0)) {
            throw new d(d.VERSION_IS_EARLIER_THAN_CURRENT);
        }
        if (TextUtils.isEmpty(a2.f4731c)) {
            a2.f4731c = b.a.f4833c;
        } else if (!a2.f4731c.equals(b.a.f4832b) && !a2.f4731c.equals(b.a.f4833c) && !a2.f4731c.equals(b.a.d)) {
            throw new d(a2.f4731c + d.CASES_VALUE_IS_INVALID);
        }
        if (f4824a == null) {
            String str3 = a2.f4730b;
            if ("external".equalsIgnoreCase(a2.d)) {
                str3 = LitePalApplication.a().getExternalFilesDir("") + com.umeng.analytics.pro.c.f3569b + str3;
            } else if (!com.umeng.commonsdk.framework.c.d.equalsIgnoreCase(a2.d) && !TextUtils.isEmpty(a2.d)) {
                String replace = (Environment.getExternalStorageDirectory().getPath() + "/" + a2.d).replace("//", "/");
                if (!org.litepal.g.a.a("android.support.v4.content.ContextCompat", "checkSelfPermission") || ContextCompat.checkSelfPermission(LitePalApplication.a(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                    File file = new File(replace);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    str3 = replace + "/" + str3;
                } else {
                    throw new org.litepal.c.b(String.format(org.litepal.c.b.EXTERNAL_STORAGE_PERMISSION_DENIED, new Object[]{replace}));
                }
            }
            f4824a = new g(str3, a2.f4729a);
        }
        return f4824a;
    }
}
