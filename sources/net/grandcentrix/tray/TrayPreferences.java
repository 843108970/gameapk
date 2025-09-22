package net.grandcentrix.tray;

import android.content.Context;
import android.support.annotation.NonNull;
import net.grandcentrix.tray.core.AbstractTrayPreference;
import net.grandcentrix.tray.core.TrayStorage;
import net.grandcentrix.tray.provider.ContentProviderStorage;

public class TrayPreferences extends AbstractTrayPreference<ContentProviderStorage> {
    public TrayPreferences(@NonNull Context context, @NonNull String str, int i) {
        this(context, str, i, TrayStorage.Type.USER);
    }

    public TrayPreferences(@NonNull Context context, @NonNull String str, int i, TrayStorage.Type type) {
        super(new ContentProviderStorage(context, str, type), i);
    }

    public void annexModule(String str) {
        annexModule(str, TrayStorage.Type.UNDEFINED);
    }

    public void annexModule(String str, TrayStorage.Type type) {
        super.annex(new ContentProviderStorage(getContext(), str, type));
    }

    /* access modifiers changed from: protected */
    public Context getContext() {
        return ((ContentProviderStorage) getStorage()).getContext();
    }
}
