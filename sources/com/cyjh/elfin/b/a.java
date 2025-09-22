package com.cyjh.elfin.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class a extends SQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    private static final String f1847b = "create table Message(id integer primary key autoincrement,number text,title text,time text,content text,description text,type text)";

    /* renamed from: a  reason: collision with root package name */
    private Context f1848a;

    public a(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.f1848a = context;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(f1847b);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
