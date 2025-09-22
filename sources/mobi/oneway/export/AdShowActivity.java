package mobi.oneway.export;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import mobi.oneway.export.a.a;
import mobi.oneway.export.e.c;
import mobi.oneway.export.enums.PluginErrorType;
import mobi.oneway.export.g.g;
import mobi.oneway.export.plugin.IActivityInterface;

public class AdShowActivity extends Activity {
    IActivityInterface iActivityInterface = null;
    Class pluginActivityClass = null;

    public AdShowActivity() {
        try {
            this.pluginActivityClass = b.a(a.k);
            this.iActivityInterface = (IActivityInterface) this.pluginActivityClass.newInstance();
            this.iActivityInterface.attach(this);
        } catch (Exception e) {
            c.a(PluginErrorType.shell_error_reflectClass, g.a((Throwable) e));
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (this.iActivityInterface != null) {
            this.iActivityInterface.onCreate(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.iActivityInterface != null) {
            this.iActivityInterface.onDestroy();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.iActivityInterface != null ? this.iActivityInterface.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyDownInHost(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (this.iActivityInterface != null) {
            this.iActivityInterface.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.iActivityInterface != null) {
            this.iActivityInterface.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.iActivityInterface != null) {
            this.iActivityInterface.onSaveInstanceState(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        if (this.iActivityInterface != null) {
            this.iActivityInterface.onStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (this.iActivityInterface != null) {
            this.iActivityInterface.onStop();
        }
    }
}
