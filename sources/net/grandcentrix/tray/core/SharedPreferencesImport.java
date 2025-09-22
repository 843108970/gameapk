package net.grandcentrix.tray.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

public class SharedPreferencesImport implements TrayMigration {
    private final SharedPreferences mPreferences;
    private final String mSharedPrefsKey;
    private final String mSharedPrefsName;
    private final String mTrayKey;

    public SharedPreferencesImport(Context context, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        this.mSharedPrefsKey = str2;
        this.mSharedPrefsName = str;
        this.mTrayKey = str3;
        this.mPreferences = context.getSharedPreferences(str, 4);
    }

    static boolean equals(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public Object getData() {
        return this.mPreferences.getAll().get(this.mSharedPrefsKey);
    }

    @NonNull
    public String getPreviousKey() {
        return this.mSharedPrefsKey;
    }

    @NonNull
    public String getTrayKey() {
        return this.mTrayKey;
    }

    public void onPostMigrate(TrayItem trayItem) {
        if (trayItem == null) {
            TrayLog.wtf("migration " + this + " failed, saved data in tray is null");
        } else if (equals(trayItem.value(), getData().toString())) {
            TrayLog.v("removing key '" + this.mSharedPrefsKey + "' from SharedPreferences '" + this.mSharedPrefsName + "'");
            this.mPreferences.edit().remove(this.mSharedPrefsKey).apply();
        }
    }

    public boolean shouldMigrate() {
        if (this.mPreferences.contains(this.mSharedPrefsKey)) {
            return true;
        }
        TrayLog.v("key '" + this.mSharedPrefsKey + "' in SharedPreferences '" + this.mSharedPrefsName + "' not found. skipped import");
        return false;
    }

    public String toString() {
        return "SharedPreferencesImport(@" + Integer.toHexString(hashCode()) + "){sharedPrefsName='" + this.mSharedPrefsName + '\'' + ", sharedPrefsKey='" + this.mSharedPrefsKey + '\'' + ", trayKey='" + this.mTrayKey + '\'' + '}';
    }
}
