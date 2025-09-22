package com.didi.virtualapk.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;

class PluginContext extends ContextWrapper {
    private final LoadedPlugin mPlugin;

    public PluginContext(LoadedPlugin loadedPlugin) {
        super(loadedPlugin.getPluginManager().getHostContext());
        this.mPlugin = loadedPlugin;
    }

    public PluginContext(LoadedPlugin loadedPlugin, Context context) {
        super(context);
        this.mPlugin = loadedPlugin;
    }

    private Context getHostContext() {
        return getBaseContext();
    }

    public Context getApplicationContext() {
        return this.mPlugin.getApplication();
    }

    public AssetManager getAssets() {
        return this.mPlugin.getAssets();
    }

    public ClassLoader getClassLoader() {
        return this.mPlugin.getClassLoader();
    }

    public ContentResolver getContentResolver() {
        return new PluginContentResolver(getHostContext());
    }

    public PackageManager getPackageManager() {
        return this.mPlugin.getPackageManager();
    }

    public Resources getResources() {
        return this.mPlugin.getResources();
    }

    public Object getSystemService(String str) {
        return (!str.equals("clipboard") && !str.equals("notification")) ? super.getSystemService(str) : getHostContext().getSystemService(str);
    }

    public Resources.Theme getTheme() {
        return this.mPlugin.getTheme();
    }

    public void startActivity(Intent intent) {
        this.mPlugin.getPluginManager().getComponentsHandler().transformIntentToExplicitAsNeeded(intent);
        super.startActivity(intent);
    }
}
