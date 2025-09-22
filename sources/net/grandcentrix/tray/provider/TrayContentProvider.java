package net.grandcentrix.tray.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.ContentObserver;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import java.util.Date;
import net.grandcentrix.tray.core.TrayLog;
import net.grandcentrix.tray.provider.TrayContract;

public class TrayContentProvider extends ContentProvider {
    private static final int ALL_PREFERENCE = 30;
    private static final int INTERNAL_ALL_PREFERENCE = 130;
    private static final int INTERNAL_MODULE_PREFERENCE = 120;
    private static final int INTERNAL_SINGLE_PREFERENCE = 110;
    private static final int MODULE_PREFERENCE = 20;
    private static final int SINGLE_PREFERENCE = 10;
    private static UriMatcher sURIMatcher;
    TrayDBHelper mDeviceDbHelper;
    TrayDBHelper mUserDbHelper;

    static void setAuthority(String str) {
        UriMatcher uriMatcher = new UriMatcher(-1);
        sURIMatcher = uriMatcher;
        uriMatcher.addURI(str, TrayContract.Preferences.BASE_PATH, 30);
        sURIMatcher.addURI(str, "preferences/*", 20);
        sURIMatcher.addURI(str, "preferences/*/*", 10);
        sURIMatcher.addURI(str, TrayContract.InternalPreferences.BASE_PATH, INTERNAL_ALL_PREFERENCE);
        sURIMatcher.addURI(str, "internal_preferences/*", INTERNAL_MODULE_PREFERENCE);
        sURIMatcher.addURI(str, "internal_preferences/*/*", 110);
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        setAuthority(providerInfo.authority);
        TrayLog.v("TrayContentProvider registered for authority: " + providerInfo.authority);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0099  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int delete(android.net.Uri r6, java.lang.String r7, java.lang.String[] r8) {
        /*
            r5 = this;
            android.content.UriMatcher r0 = sURIMatcher
            int r0 = r0.match(r6)
            r1 = 10
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x0034
            r1 = 20
            if (r0 == r1) goto L_0x004d
            r1 = 30
            if (r0 == r1) goto L_0x0065
            r1 = 110(0x6e, float:1.54E-43)
            if (r0 == r1) goto L_0x0034
            r1 = 120(0x78, float:1.68E-43)
            if (r0 == r1) goto L_0x004d
            r1 = 130(0x82, float:1.82E-43)
            if (r0 == r1) goto L_0x0065
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "Delete is not supported for Uri: "
            r8.<init>(r0)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r7.<init>(r6)
            throw r7
        L_0x0034:
            java.lang.String r0 = "KEY = ?"
            java.lang.String r7 = net.grandcentrix.tray.provider.SqliteHelper.extendSelection(r7, r0)
            java.lang.String[] r0 = new java.lang.String[r3]
            java.util.List r1 = r6.getPathSegments()
            r4 = 2
            java.lang.Object r1 = r1.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            r0[r2] = r1
            java.lang.String[] r8 = net.grandcentrix.tray.provider.SqliteHelper.extendSelectionArgs((java.lang.String[]) r8, (java.lang.String[]) r0)
        L_0x004d:
            java.lang.String r0 = "MODULE = ?"
            java.lang.String r7 = net.grandcentrix.tray.provider.SqliteHelper.extendSelection(r7, r0)
            java.lang.String[] r0 = new java.lang.String[r3]
            java.util.List r1 = r6.getPathSegments()
            java.lang.Object r1 = r1.get(r3)
            java.lang.String r1 = (java.lang.String) r1
            r0[r2] = r1
            java.lang.String[] r8 = net.grandcentrix.tray.provider.SqliteHelper.extendSelectionArgs((java.lang.String[]) r8, (java.lang.String[]) r0)
        L_0x0065:
            java.lang.String r0 = "backup"
            java.lang.String r0 = r6.getQueryParameter(r0)
            if (r0 != 0) goto L_0x008b
            net.grandcentrix.tray.provider.TrayDBHelper r0 = r5.mDeviceDbHelper
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()
            java.lang.String r1 = r5.getTable(r6)
            int r0 = r0.delete(r1, r7, r8)
            net.grandcentrix.tray.provider.TrayDBHelper r1 = r5.mUserDbHelper
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()
            java.lang.String r2 = r5.getTable(r6)
            int r7 = r1.delete(r2, r7, r8)
            int r0 = r0 + r7
            goto L_0x0097
        L_0x008b:
            android.database.sqlite.SQLiteDatabase r0 = r5.getWritableDatabase(r6)
            java.lang.String r1 = r5.getTable(r6)
            int r0 = r0.delete(r1, r7, r8)
        L_0x0097:
            if (r0 <= 0) goto L_0x00a5
            android.content.Context r7 = r5.getContext()
            android.content.ContentResolver r7 = r7.getContentResolver()
            r8 = 0
            r7.notifyChange(r6, r8)
        L_0x00a5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.grandcentrix.tray.provider.TrayContentProvider.delete(android.net.Uri, java.lang.String, java.lang.String[]):int");
    }

    public SQLiteDatabase getReadableDatabase(Uri uri) {
        return (shouldBackup(uri) ? this.mUserDbHelper : this.mDeviceDbHelper).getReadableDatabase();
    }

    public String getTable(Uri uri) {
        if (uri == null) {
            return null;
        }
        int match = sURIMatcher.match(uri);
        return (match == 110 || match == INTERNAL_MODULE_PREFERENCE || match == INTERNAL_ALL_PREFERENCE) ? TrayDBHelper.INTERNAL_TABLE_NAME : TrayDBHelper.TABLE_NAME;
    }

    public String getType(Uri uri) {
        return null;
    }

    public SQLiteDatabase getWritableDatabase(Uri uri) {
        return (shouldBackup(uri) ? this.mUserDbHelper : this.mDeviceDbHelper).getWritableDatabase();
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        String str;
        Date date = new Date();
        int match = sURIMatcher.match(uri);
        if (match == 10 || match == 110) {
            contentValues.put("CREATED", Long.valueOf(date.getTime()));
            contentValues.put("UPDATED", Long.valueOf(date.getTime()));
            contentValues.put("MODULE", uri.getPathSegments().get(1));
            contentValues.put("KEY", uri.getPathSegments().get(2));
            int insertOrUpdate = insertOrUpdate(getWritableDatabase(uri), getTable(uri), "MODULE = ?AND KEY = ?", new String[]{contentValues.getAsString("MODULE"), contentValues.getAsString("KEY")}, contentValues, new String[]{"CREATED"});
            if (insertOrUpdate >= 0) {
                getContext().getContentResolver().notifyChange(uri, (ContentObserver) null);
                return uri;
            }
            if (insertOrUpdate == -1) {
                str = "Couldn't update or insert data. Uri: " + uri;
            } else {
                str = "unknown SQLite error";
            }
            TrayLog.w(str);
            return null;
        }
        throw new IllegalArgumentException("Insert is not supported for Uri: " + uri);
    }

    public int insertOrUpdate(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr, ContentValues contentValues, String[] strArr2) {
        return SqliteHelper.insertOrUpdate(sQLiteDatabase, str, str2, strArr, contentValues, strArr2);
    }

    public boolean onCreate() {
        this.mUserDbHelper = new TrayDBHelper(getContext(), true);
        this.mDeviceDbHelper = new TrayDBHelper(getContext(), false);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.database.Cursor query(android.net.Uri r15, java.lang.String[] r16, java.lang.String r17, java.lang.String[] r18, java.lang.String r19) {
        /*
            r14 = this;
            r0 = r14
            r1 = r15
            android.database.sqlite.SQLiteQueryBuilder r10 = new android.database.sqlite.SQLiteQueryBuilder
            r10.<init>()
            android.content.UriMatcher r2 = sURIMatcher
            int r2 = r2.match(r1)
            r11 = 1
            r12 = 2
            r3 = 110(0x6e, float:1.54E-43)
            r4 = 10
            if (r2 == r4) goto L_0x003b
            r5 = 20
            if (r2 == r5) goto L_0x005a
            r5 = 30
            if (r2 == r5) goto L_0x0082
            if (r2 == r3) goto L_0x003b
            r5 = 120(0x78, float:1.68E-43)
            if (r2 == r5) goto L_0x005a
            r3 = 130(0x82, float:1.82E-43)
            if (r2 == r3) goto L_0x0082
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Query is not supported for Uri: "
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x003b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "KEY = "
            r5.<init>(r6)
            java.util.List r6 = r1.getPathSegments()
            java.lang.Object r6 = r6.get(r12)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r6 = android.database.DatabaseUtils.sqlEscapeString(r6)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r10.appendWhere(r5)
        L_0x005a:
            if (r2 == r4) goto L_0x005e
            if (r2 != r3) goto L_0x0063
        L_0x005e:
            java.lang.String r2 = " AND "
            r10.appendWhere(r2)
        L_0x0063:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "MODULE = "
            r2.<init>(r3)
            java.util.List r3 = r1.getPathSegments()
            java.lang.Object r3 = r3.get(r11)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = android.database.DatabaseUtils.sqlEscapeString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r10.appendWhere(r2)
        L_0x0082:
            java.lang.String r2 = r0.getTable(r1)
            r10.setTables(r2)
            java.lang.String r2 = "backup"
            java.lang.String r2 = r1.getQueryParameter(r2)
            if (r2 != 0) goto L_0x00be
            net.grandcentrix.tray.provider.TrayDBHelper r2 = r0.mUserDbHelper
            android.database.sqlite.SQLiteDatabase r3 = r2.getReadableDatabase()
            r7 = 0
            r8 = 0
            r2 = r10
            r4 = r16
            r5 = r17
            r6 = r18
            r9 = r19
            android.database.Cursor r13 = r2.query(r3, r4, r5, r6, r7, r8, r9)
            net.grandcentrix.tray.provider.TrayDBHelper r2 = r0.mDeviceDbHelper
            android.database.sqlite.SQLiteDatabase r3 = r2.getReadableDatabase()
            r2 = r10
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)
            android.database.MergeCursor r3 = new android.database.MergeCursor
            android.database.Cursor[] r4 = new android.database.Cursor[r12]
            r5 = 0
            r4[r5] = r13
            r4[r11] = r2
            r3.<init>(r4)
            goto L_0x00d1
        L_0x00be:
            android.database.sqlite.SQLiteDatabase r3 = r0.getReadableDatabase(r1)
            r7 = 0
            r8 = 0
            r2 = r10
            r4 = r16
            r5 = r17
            r6 = r18
            r9 = r19
            android.database.Cursor r3 = r2.query(r3, r4, r5, r6, r7, r8, r9)
        L_0x00d1:
            if (r3 == 0) goto L_0x00de
            android.content.Context r2 = r0.getContext()
            android.content.ContentResolver r2 = r2.getContentResolver()
            r3.setNotificationUri(r2, r1)
        L_0x00de:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.grandcentrix.tray.provider.TrayContentProvider.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    /* access modifiers changed from: package-private */
    public boolean shouldBackup(@NonNull Uri uri) {
        return !"false".equals(uri.getQueryParameter("backup"));
    }

    public void shutdown() {
        this.mUserDbHelper.close();
        this.mDeviceDbHelper.close();
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("not implemented");
    }
}
