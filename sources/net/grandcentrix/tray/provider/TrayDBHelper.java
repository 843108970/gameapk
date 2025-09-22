package net.grandcentrix.tray.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import net.grandcentrix.tray.core.TrayLog;

public class TrayDBHelper extends SQLiteOpenHelper {
    public static final String CREATED = "CREATED";
    public static final String DATABASE_NAME = "tray.db";
    public static final String DATABASE_NAME_NO_BACKUP = "tray_backup_excluded.db";
    static final int DATABASE_VERSION = 2;
    public static final String INTERNAL_TABLE_NAME = "TrayInternal";
    public static final String KEY = "KEY";
    public static final String MIGRATED_KEY = "MIGRATED_KEY";
    public static final String MODULE = "MODULE";
    public static final String TABLE_NAME = "TrayPreferences";
    public static final String UPDATED = "UPDATED";
    public static final String V1_PREFERENCES_CREATE = "CREATE TABLE TrayPreferences ( _id INTEGER PRIMARY KEY, KEY TEXT NOT NULL, VALUE TEXT, MODULE TEXT, CREATED INT DEFAULT 0, UPDATED INT DEFAULT 0, UNIQUE (MODULE, KEY));";
    public static final String V2_ALTER_PREFERENCES_TABLE = "ALTER TABLE TrayPreferences ADD COLUMN MIGRATED_KEY TEXT";
    public static final String V2_CREATE_INTERNAL_TRAY_TABLE = "CREATE TABLE TrayInternal ( _id INTEGER PRIMARY KEY, KEY TEXT NOT NULL, VALUE TEXT, MODULE TEXT, CREATED INT DEFAULT 0, UPDATED INT DEFAULT 0, MIGRATED_KEY TEXT, UNIQUE (MODULE, KEY));";
    public static final String VALUE = "VALUE";
    private final int mCreateVersion;
    private final boolean mWithBackup;

    public TrayDBHelper(Context context) {
        this(context, true);
    }

    TrayDBHelper(Context context, String str, boolean z, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.mWithBackup = z;
        this.mCreateVersion = i;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrayDBHelper(Context context, boolean z) {
        super(context, z ? DATABASE_NAME : DATABASE_NAME_NO_BACKUP, (SQLiteDatabase.CursorFactory) null, 2);
        this.mWithBackup = z;
        this.mCreateVersion = 2;
    }

    private void createV1(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(V1_PREFERENCES_CREATE);
    }

    @NonNull
    private String logTag() {
        StringBuilder sb = new StringBuilder("tray internal db (");
        sb.append(this.mWithBackup ? "backup" : "no backup");
        sb.append("): ");
        return sb.toString();
    }

    private void upgradeToV2(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(V2_ALTER_PREFERENCES_TABLE);
        sQLiteDatabase.execSQL(V2_CREATE_INTERNAL_TRAY_TABLE);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        TrayLog.v(logTag() + "onCreate with version " + this.mCreateVersion);
        createV1(sQLiteDatabase);
        TrayLog.v(logTag() + "created database version 1");
        if (this.mCreateVersion > 1) {
            onUpgrade(sQLiteDatabase, 1, this.mCreateVersion);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        TrayLog.v(logTag() + "upgrading Database from version " + i + " to version " + i2);
        if (i2 > 2) {
            throw new IllegalStateException("onUpgrade doesn't support the upgrade to version " + i2);
        } else if (i != 1) {
            throw new IllegalArgumentException("onUpgrade() with oldVersion <= 0 is useless");
        } else {
            upgradeToV2(sQLiteDatabase);
            TrayLog.v(logTag() + "upgraded Database to version 2");
        }
    }
}
