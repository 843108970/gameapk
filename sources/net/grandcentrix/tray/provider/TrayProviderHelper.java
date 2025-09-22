package net.grandcentrix.tray.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.grandcentrix.tray.core.AbstractTrayPreference;
import net.grandcentrix.tray.core.TrayException;
import net.grandcentrix.tray.core.TrayItem;

public class TrayProviderHelper {
    private final Context mContext;
    private final TrayUri mTrayUri;

    public TrayProviderHelper(@NonNull Context context) {
        this.mContext = context;
        this.mTrayUri = new TrayUri(context);
    }

    @NonNull
    static TrayItem cursorToTrayItem(Cursor cursor) {
        return new TrayItem(cursor.getString(cursor.getColumnIndexOrThrow("MODULE")), cursor.getString(cursor.getColumnIndexOrThrow("KEY")), cursor.getString(cursor.getColumnIndexOrThrow("MIGRATED_KEY")), cursor.getString(cursor.getColumnIndexOrThrow("VALUE")), new Date(cursor.getLong(cursor.getColumnIndexOrThrow("CREATED"))), new Date(cursor.getLong(cursor.getColumnIndexOrThrow("UPDATED"))));
    }

    public boolean clear() {
        try {
            this.mContext.getContentResolver().delete(this.mTrayUri.get(), (String) null, (String[]) null);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean clearBut(AbstractTrayPreference... abstractTrayPreferenceArr) {
        String str = null;
        String[] strArr = new String[0];
        for (AbstractTrayPreference abstractTrayPreference : abstractTrayPreferenceArr) {
            if (abstractTrayPreference != null) {
                String name = abstractTrayPreference.getName();
                str = SqliteHelper.extendSelection(str, "MODULE != ?");
                strArr = SqliteHelper.extendSelectionArgs(strArr, new String[]{name});
            }
        }
        try {
            this.mContext.getContentResolver().delete(this.mTrayUri.get(), str, strArr);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @NonNull
    public List<TrayItem> getAll() {
        return queryProviderSafe(this.mTrayUri.get());
    }

    public boolean persist(@NonNull Uri uri, @Nullable String str) {
        return persist(uri, str, (String) null);
    }

    public boolean persist(@NonNull Uri uri, @Nullable String str, @Nullable String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("VALUE", str);
        contentValues.put("MIGRATED_KEY", str2);
        try {
            return this.mContext.getContentResolver().insert(uri, contentValues) != null;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean persist(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        return persist(str, str2, (String) null, str3);
    }

    public boolean persist(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4) {
        return persist(this.mTrayUri.builder().setModule(str).setKey(str2).build(), str4, str3);
    }

    @NonNull
    public List<TrayItem> queryProvider(@NonNull Uri uri) throws TrayException {
        try {
            Cursor query = this.mContext.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
            if (query == null) {
                throw new TrayException("could not access stored data with uri " + uri);
            }
            ArrayList arrayList = new ArrayList();
            for (boolean moveToFirst = query.moveToFirst(); moveToFirst; moveToFirst = query.moveToNext()) {
                arrayList.add(cursorToTrayItem(query));
            }
            query.close();
            return arrayList;
        } catch (Throwable th) {
            throw new TrayException("Hard error accessing the ContentProvider", th);
        }
    }

    @NonNull
    public List<TrayItem> queryProviderSafe(@NonNull Uri uri) {
        try {
            return queryProvider(uri);
        } catch (TrayException unused) {
            return new ArrayList();
        }
    }

    public boolean remove(Uri uri) {
        try {
            this.mContext.getContentResolver().delete(uri, (String) null, (String[]) null);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public int removeAndCount(Uri uri) {
        try {
            return this.mContext.getContentResolver().delete(uri, (String) null, (String[]) null);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public boolean wipe() {
        if (!clear()) {
            return false;
        }
        try {
            return this.mContext.getContentResolver().delete(this.mTrayUri.getInternal(), (String) null, (String[]) null) > 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
