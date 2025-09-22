package net.grandcentrix.tray.core;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.cyjh.common.util.s;
import java.util.Collection;
import net.grandcentrix.tray.core.PreferenceStorage;

public abstract class Preferences<T, S extends PreferenceStorage<T>> implements PreferenceAccessor<T> {
    private boolean mChangeVersionSucceeded = false;
    @NonNull
    private S mStorage;
    private int mVersion;

    public Preferences(@NonNull S s, int i) {
        this.mStorage = s;
        this.mVersion = i;
        isVersionChangeChecked();
    }

    static boolean isDataTypeSupported(Object obj) {
        return (obj instanceof Integer) || (obj instanceof String) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Boolean) || obj == null;
    }

    private boolean putData(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            return getStorage().put(str, obj);
        }
        throw new IllegalArgumentException("Preference key value cannot be empty.");
    }

    /* access modifiers changed from: package-private */
    public synchronized void changeVersion(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Version must be >= 1, was " + i);
        }
        try {
            int version = getStorage().getVersion();
            if (version != i) {
                if (version == 0) {
                    TrayLog.v("create " + this + " with initial version 0");
                    onCreate(i);
                } else if (version > i) {
                    TrayLog.v("downgrading " + this + "from " + version + " to " + i);
                    onDowngrade(version, i);
                } else {
                    TrayLog.v("upgrading " + this + " from " + version + " to " + i);
                    onUpgrade(version, i);
                }
                getStorage().setVersion(i);
            }
            this.mChangeVersionSucceeded = true;
        } catch (TrayException e) {
            e.printStackTrace();
            TrayLog.v("could not change the version, retrying with the next interaction");
        }
    }

    public boolean clear() {
        boolean clear = this.mStorage.clear();
        StringBuilder sb = new StringBuilder("cleared ");
        sb.append(clear ? "successful" : "failed");
        sb.append(s.a.f1696a);
        sb.append(this);
        TrayLog.v(sb.toString());
        return clear;
    }

    public boolean contains(String str) {
        return getPref(str) != null;
    }

    public Collection<T> getAll() {
        return this.mStorage.getAll();
    }

    @Nullable
    public T getPref(@NonNull String str) {
        return this.mStorage.get(str);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public S getStorage() {
        return this.mStorage;
    }

    public int getVersion() throws TrayException {
        return this.mStorage.getVersion();
    }

    /* access modifiers changed from: package-private */
    public boolean isVersionChangeChecked() {
        if (!this.mChangeVersionSucceeded) {
            changeVersion(this.mVersion);
        }
        return this.mChangeVersionSucceeded;
    }

    @SafeVarargs
    public final void migrate(Migration<T>... migrationArr) {
        Object obj;
        for (Migration<T> migration : migrationArr) {
            if (!migration.shouldMigrate()) {
                TrayLog.v("not migrating " + migration + " into " + this);
            } else {
                Object data = migration.getData();
                if (!isDataTypeSupported(data)) {
                    TrayLog.w("could not migrate '" + migration.getPreviousKey() + "' into " + this + " because the data type " + data.getClass().getSimpleName() + " is invalid");
                    obj = null;
                } else {
                    String trayKey = migration.getTrayKey();
                    String previousKey = migration.getPreviousKey();
                    getStorage().put(trayKey, previousKey, data);
                    TrayLog.v("migrated '" + previousKey + "'='" + data + "' into " + this + " (now: '" + trayKey + "'='" + data + "')");
                    obj = getStorage().get(trayKey);
                }
                migration.onPostMigrate(obj);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(int i) {
    }

    /* access modifiers changed from: protected */
    public void onDowngrade(int i, int i2) {
        throw new IllegalStateException("Can't downgrade " + this + " from version " + i + " to " + i2);
    }

    /* access modifiers changed from: protected */
    public void onUpgrade(int i, int i2) {
        throw new IllegalStateException("Can't upgrade database from version " + i + " to " + i2 + ", not implemented.");
    }

    public boolean put(@NonNull String str, float f) {
        if (!isVersionChangeChecked()) {
            return false;
        }
        TrayLog.v("put '" + str + "=" + f + "' into " + this);
        return putData(str, Float.valueOf(f));
    }

    public boolean put(@NonNull String str, int i) {
        if (!isVersionChangeChecked()) {
            return false;
        }
        TrayLog.v("put '" + str + "=" + i + "' into " + this);
        return putData(str, Integer.valueOf(i));
    }

    public boolean put(@NonNull String str, long j) {
        if (!isVersionChangeChecked()) {
            return false;
        }
        TrayLog.v("put '" + str + "=" + j + "' into " + this);
        return putData(str, Long.valueOf(j));
    }

    public boolean put(@NonNull String str, String str2) {
        if (!isVersionChangeChecked()) {
            return false;
        }
        TrayLog.v("put '" + str + "=\"" + str2 + "\"' into " + this);
        return putData(str, str2);
    }

    public boolean put(@NonNull String str, boolean z) {
        if (!isVersionChangeChecked()) {
            return false;
        }
        TrayLog.v("put '" + str + "=" + z + "' into " + this);
        return putData(str, Boolean.valueOf(z));
    }

    public boolean remove(@NonNull String str) {
        if (!isVersionChangeChecked()) {
            return false;
        }
        TrayLog.v("removed key '" + str + "' from " + this);
        return getStorage().remove(str);
    }

    public boolean wipe() {
        boolean wipe = this.mStorage.wipe();
        StringBuilder sb = new StringBuilder("wipe ");
        sb.append(wipe ? "successful" : "failed");
        sb.append(s.a.f1696a);
        sb.append(this);
        TrayLog.v(sb.toString());
        return wipe;
    }
}
