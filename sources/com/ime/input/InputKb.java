package com.ime.input;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.KeyboardView;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;

public class InputKb extends InputMethodService {

    /* renamed from: b  reason: collision with root package name */
    public static Handler f3521b;

    /* renamed from: a  reason: collision with root package name */
    EditorInfo f3522a;

    /* renamed from: c  reason: collision with root package name */
    private KeyboardView f3523c;

    public void onCreate() {
        super.onCreate();
        Log.i("InputKb", "InputKb - onCreate()");
        a.a().f3525a = this;
    }

    public View onCreateInputView() {
        return this.f3523c;
    }

    public void onDestroy() {
        super.onDestroy();
        a.a().f3525a = null;
    }

    public boolean onEvaluateFullscreenMode() {
        if (!(getResources().getConfiguration().orientation != 2 || this.f3522a == null || (this.f3522a.imeOptions & 268435456) == 0)) {
        }
        return false;
    }

    public void onFinishInputView(boolean z) {
        super.onFinishInputView(z);
    }
}
