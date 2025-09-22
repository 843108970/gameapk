package net.grandcentrix.tray.core;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import net.grandcentrix.tray.core.TrayStorage;

public abstract class AbstractTrayPreference<T extends TrayStorage> extends Preferences<TrayItem, T> {
    protected AbstractTrayPreference(@NonNull T t, int i) {
        super(t, i);
    }

    private void throwForNullValue(@Nullable String str, Class<?> cls, @NonNull String str2) throws WrongTypeException {
        if (str == null) {
            throw new WrongTypeException("The value for key <" + str2 + "> is null. You obviously saved this value as String and try to access it with type " + cls.getSimpleName() + " which cannot be null.  Always use getString(key, defaultValue) when accessing data you saved with put(String).");
        }
    }

    /* access modifiers changed from: protected */
    public void annex(T t) {
        ((TrayStorage) getStorage()).annex(t);
        TrayLog.v("annexed " + t + " to " + this);
    }

    public boolean getBoolean(@NonNull String str) throws ItemNotFoundException {
        return Boolean.parseBoolean(getString(str));
    }

    public boolean getBoolean(@NonNull String str, boolean z) {
        try {
            return getBoolean(str);
        } catch (ItemNotFoundException unused) {
            return z;
        }
    }

    public float getFloat(@NonNull String str) throws ItemNotFoundException {
        String string = getString(str);
        throwForNullValue(string, Float.class, str);
        try {
            return Float.parseFloat(string);
        } catch (NumberFormatException e) {
            throw new WrongTypeException((Throwable) e);
        }
    }

    public float getFloat(@NonNull String str, float f) {
        try {
            return getFloat(str);
        } catch (ItemNotFoundException unused) {
            return f;
        }
    }

    public int getInt(@NonNull String str) throws ItemNotFoundException {
        String string = getString(str);
        throwForNullValue(string, Integer.class, str);
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new WrongTypeException((Throwable) e);
        }
    }

    public int getInt(@NonNull String str, int i) {
        try {
            return getInt(str);
        } catch (ItemNotFoundException unused) {
            return i;
        }
    }

    public long getLong(@NonNull String str) throws ItemNotFoundException {
        String string = getString(str);
        throwForNullValue(string, Long.class, str);
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException e) {
            throw new WrongTypeException((Throwable) e);
        }
    }

    public long getLong(@NonNull String str, long j) {
        try {
            return getLong(str);
        } catch (ItemNotFoundException unused) {
            return j;
        }
    }

    public String getName() {
        return ((TrayStorage) getStorage()).getModuleName();
    }

    public String getString(@NonNull String str) throws ItemNotFoundException {
        TrayItem trayItem = (TrayItem) getPref(str);
        if (trayItem != null) {
            return trayItem.value();
        }
        throw new ItemNotFoundException("Value for Key <%s> not found", str);
    }

    @Nullable
    public String getString(@NonNull String str, String str2) {
        try {
            return getString(str);
        } catch (ItemNotFoundException unused) {
            return str2;
        }
    }

    public void registerOnTrayPreferenceChangeListener(@NonNull OnTrayPreferenceChangeListener onTrayPreferenceChangeListener) {
        ((TrayStorage) getStorage()).registerOnTrayPreferenceChangeListener(onTrayPreferenceChangeListener);
    }

    public String toString() {
        return getClass().getSimpleName() + "(@" + Integer.toHexString(hashCode()) + "){name=" + getName() + "}";
    }

    public void unregisterOnTrayPreferenceChangeListener(@NonNull OnTrayPreferenceChangeListener onTrayPreferenceChangeListener) {
        ((TrayStorage) getStorage()).unregisterOnTrayPreferenceChangeListener(onTrayPreferenceChangeListener);
    }
}
