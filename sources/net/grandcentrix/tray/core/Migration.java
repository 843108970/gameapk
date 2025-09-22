package net.grandcentrix.tray.core;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public interface Migration<T> {
    @Nullable
    Object getData();

    @NonNull
    String getPreviousKey();

    @NonNull
    String getTrayKey();

    void onPostMigrate(@Nullable T t);

    boolean shouldMigrate();
}
