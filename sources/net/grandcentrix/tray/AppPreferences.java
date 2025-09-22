package net.grandcentrix.tray;

import android.content.Context;

public class AppPreferences extends TrayPreferences {
    private static final int VERSION = 1;

    public AppPreferences(Context context) {
        super(context, context.getPackageName(), 1);
    }
}
