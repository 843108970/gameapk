package mobi.oneway.export.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.Window;
import mobi.oneway.export.AdShowActivity;

public class BasePluginActivity extends Activity implements IActivityInterface {
    protected AdShowActivity hostActivity;
    boolean isPluginMode = false;

    public void attach(AdShowActivity adShowActivity) {
        this.hostActivity = adShowActivity;
        this.isPluginMode = true;
    }

    public Activity getActivity() {
        return this.isPluginMode ? this.hostActivity : this;
    }

    public Context getContext() {
        return this.isPluginMode ? this.hostActivity.getBaseContext() : getBaseContext();
    }

    public Activity getHostActivity() {
        return this.hostActivity;
    }

    public Intent getIntent() {
        return this.isPluginMode ? this.hostActivity.getIntent() : super.getIntent();
    }

    public Looper getMainLooper() {
        return this.isPluginMode ? this.hostActivity.getMainLooper() : super.getMainLooper();
    }

    public Resources getResources() {
        return this.isPluginMode ? this.hostActivity.getResources() : super.getResources();
    }

    public Window getWindow() {
        return this.isPluginMode ? this.hostActivity.getWindow() : super.getWindow();
    }

    public void onCreate(Bundle bundle) {
        if (!this.isPluginMode) {
            super.onCreate(bundle);
        }
    }

    public void onDestroy() {
        if (!this.isPluginMode) {
            super.onDestroy();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.isPluginMode ? this.hostActivity.onKeyDownInHost(i, keyEvent) : super.onKeyDown(i, keyEvent);
    }

    public void onPause() {
        if (!this.isPluginMode) {
            super.onPause();
        }
    }

    public void onRestart() {
        if (!this.isPluginMode) {
            super.onRestart();
        }
    }

    public void onResume() {
        if (!this.isPluginMode) {
            super.onResume();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (!this.isPluginMode) {
            super.onSaveInstanceState(bundle);
        }
    }

    public void onStart() {
        if (!this.isPluginMode) {
            super.onStart();
        }
    }

    public void onStop() {
        if (!this.isPluginMode) {
            super.onStop();
        }
    }
}
