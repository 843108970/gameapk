package com.ime.input;

import android.inputmethodservice.InputMethodService;
import android.view.inputmethod.InputConnection;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    private static a f3524b;

    /* renamed from: a  reason: collision with root package name */
    public InputMethodService f3525a = null;

    private a() {
    }

    public static a a() {
        if (f3524b == null) {
            f3524b = new a();
        }
        return f3524b;
    }

    private void a(InputMethodService inputMethodService) {
        this.f3525a = inputMethodService;
    }

    private void a(String str) {
        InputConnection currentInputConnection;
        if (this.f3525a != null && (currentInputConnection = this.f3525a.getCurrentInputConnection()) != null) {
            currentInputConnection.commitText(str, str.length());
        }
    }

    private void b() {
        this.f3525a = null;
    }

    private void b(String str) {
        if (this.f3525a != null) {
            this.f3525a.switchInputMethod(str);
        }
    }
}
