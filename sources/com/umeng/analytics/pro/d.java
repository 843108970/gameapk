package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.c;

class d extends SQLiteOpenHelper {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static Context f3602b;

    /* renamed from: a  reason: collision with root package name */
    private String f3603a;

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final d f3604a = new d(d.f3602b, f.b(d.f3602b), c.f3570c, (SQLiteDatabase.CursorFactory) null, 1);

        private a() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private d(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, TextUtils.isEmpty(str) ? c.f3570c : str, cursorFactory, i);
        this.f3603a = null;
        a();
    }

    private d(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(new a(context, str), str2, cursorFactory, i);
    }

    public static d a(Context context) {
        if (f3602b == null) {
            f3602b = context.getApplicationContext();
        }
        return a.f3604a;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f3603a = "create table if not exists __dp(id INTEGER primary key autoincrement, __id INTEGER, __ii TEXT, __ty INTEGER, __ve TEXT, __io TEXT)";
            sQLiteDatabase.execSQL(this.f3603a);
        } catch (SQLException unused) {
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f3603a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER)";
            sQLiteDatabase.execSQL(this.f3603a);
        } catch (SQLException unused) {
        }
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f3603a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER)";
            sQLiteDatabase.execSQL(this.f3603a);
        } catch (SQLException unused) {
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f3603a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT)";
            sQLiteDatabase.execSQL(this.f3603a);
        } catch (SQLException unused) {
        }
    }

    public void a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!f.a(c.e.f3595a, writableDatabase)) {
                d(writableDatabase);
            }
            if (!f.a(c.d.f3588a, writableDatabase)) {
                c(writableDatabase);
            }
            if (!f.a(c.C0054c.f3581a, writableDatabase)) {
                b(writableDatabase);
            }
            if (!f.a(c.a.f3571a, writableDatabase)) {
                a(writableDatabase);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0022 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.database.sqlite.SQLiteDatabase r2) {
        /*
            r1 = this;
            r2.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0022, Throwable -> 0x001b }
            r1.d(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0022, Throwable -> 0x001b }
            r1.c(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0022, Throwable -> 0x001b }
            r1.b(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0022, Throwable -> 0x001b }
            r1.a((android.database.sqlite.SQLiteDatabase) r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0022, Throwable -> 0x001b }
            r2.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0022, Throwable -> 0x001b }
            if (r2 == 0) goto L_0x0018
            r2.endTransaction()     // Catch:{ Throwable -> 0x0018 }
            return
        L_0x0018:
            return
        L_0x0019:
            r0 = move-exception
            goto L_0x002e
        L_0x001b:
            if (r2 == 0) goto L_0x0021
            r2.endTransaction()     // Catch:{ Throwable -> 0x0021 }
            return
        L_0x0021:
            return
        L_0x0022:
            android.content.Context r0 = f3602b     // Catch:{ all -> 0x0019 }
            com.umeng.analytics.pro.f.a((android.content.Context) r0)     // Catch:{ all -> 0x0019 }
            if (r2 == 0) goto L_0x002d
            r2.endTransaction()     // Catch:{ Throwable -> 0x002d }
            return
        L_0x002d:
            return
        L_0x002e:
            if (r2 == 0) goto L_0x0033
            r2.endTransaction()     // Catch:{ Throwable -> 0x0033 }
        L_0x0033:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.d.onCreate(android.database.sqlite.SQLiteDatabase):void");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
