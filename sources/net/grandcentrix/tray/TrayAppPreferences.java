package net.grandcentrix.tray;

import android.content.Context;

@Deprecated
public class TrayAppPreferences extends TrayPreferences {
    private static final int VERSION = 1;

    public TrayAppPreferences(Context context) {
        super(context, context.getPackageName(), 1);
    }
}
