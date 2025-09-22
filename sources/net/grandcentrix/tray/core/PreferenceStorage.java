package net.grandcentrix.tray.core;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Collection;

public interface PreferenceStorage<T> {
    boolean clear();

    @Nullable
    T get(@NonNull String str);

    @NonNull
    Collection<T> getAll();

    int getVersion() throws TrayException;

    boolean put(T t);

    boolean put(@NonNull String str, @Nullable Object obj);

    boolean put(@NonNull String str, @Nullable String str2, @Nullable Object obj);

    boolean remove(@NonNull String str);

    boolean setVersion(int i);

    boolean wipe();
}
