package net.grandcentrix.tray.provider;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Process;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;
import android.util.Log;
import java.util.List;
import net.grandcentrix.tray.R;
import net.grandcentrix.tray.core.TrayLog;
import net.grandcentrix.tray.core.TrayRuntimeException;

class TrayContract {
    static String sAuthority;

    public interface InternalPreferences extends Preferences {
        public static final String BASE_PATH = "internal_preferences";
    }

    public interface Preferences {
        public static final String BASE_PATH = "preferences";

        public interface Columns extends BaseColumns {
            public static final String CREATED = "CREATED";
            public static final String ID = "_id";
            public static final String KEY = "KEY";
            public static final String MIGRATED_KEY = "MIGRATED_KEY";
            public static final String MODULE = "MODULE";
            public static final String UPDATED = "UPDATED";
            public static final String VALUE = "VALUE";
        }
    }

    TrayContract() {
    }

    private static void checkOldWayToSetAuthority(@NonNull Context context) {
        if (!"legacyTrayAuthority".equals(context.getString(R.string.tray__authority))) {
            Log.e("Tray", "Deprecated way of defining the Tray authority detected\n#########################################\n#########################################\n#########################################\nDon't set the authority with `tray__authority` in your build.gradle.\nTo change the default authority override it inside the AndroidManifest\nSee https://github.com/grandcentrix/tray/wiki/Custom-Authority for instructions\n#########################################\n#########################################\n#########################################\n");
        }
    }

    @NonNull
    public static Uri generateContentUri(@NonNull Context context) {
        return generateContentUri(context, Preferences.BASE_PATH);
    }

    @NonNull
    private static Uri generateContentUri(@NonNull Context context, String str) {
        String authority = getAuthority(context);
        return Uri.withAppendedPath(Uri.parse("content://" + authority), str);
    }

    @NonNull
    static Uri generateInternalContentUri(@NonNull Context context) {
        return generateContentUri(context, InternalPreferences.BASE_PATH);
    }

    @NonNull
    private static synchronized String getAuthority(@NonNull Context context) {
        synchronized (TrayContract.class) {
            if (sAuthority != null) {
                String str = sAuthority;
                return str;
            }
            checkOldWayToSetAuthority(context);
            List<ProviderInfo> queryContentProviders = context.getPackageManager().queryContentProviders(context.getPackageName(), Process.myUid(), 0);
            if (queryContentProviders != null) {
                for (ProviderInfo next : queryContentProviders) {
                    if (next.name.equals(TrayContentProvider.class.getName())) {
                        sAuthority = next.authority;
                        TrayLog.v("found authority: " + sAuthority);
                        String str2 = sAuthority;
                        return str2;
                    }
                }
            }
            throw new TrayRuntimeException("Internal tray error. Could not find the provider authority. Please fill an issue at https://github.com/grandcentrix/tray/issues");
        }
    }
}
