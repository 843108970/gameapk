package com.cyjh.mobileanjian.screencap;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

public class ForScreenShotActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public static final int f2739a = 32896;

    /* renamed from: b  reason: collision with root package name */
    private static final String f2740b = "ForScreenShotActivity";

    private void a() {
        if (Build.VERSION.SDK_INT >= 21) {
            startActivityForResult(((MediaProjectionManager) getSystemService("media_projection")).createScreenCaptureIntent(), f2739a);
            return;
        }
        Log.e(f2740b, "The API version is too low,required is >= 21.");
        finish();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 32896) {
            if (i2 != -1 || intent == null) {
                a();
                setResult(0);
                return;
            }
            setResult(-1);
            ScreenShoterV3.getInstance().init(this, intent);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setDimAmount(0.0f);
        a();
    }
}
