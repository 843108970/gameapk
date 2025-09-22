package com.android.volley;

import android.content.Intent;

public final class a extends s {
    private Intent mResolutionIntent;

    public a() {
    }

    public a(Intent intent) {
        this.mResolutionIntent = intent;
    }

    public a(i iVar) {
        super(iVar);
    }

    public a(String str) {
        super(str);
    }

    public a(String str, Exception exc) {
        super(str, exc);
    }

    public final String getMessage() {
        return this.mResolutionIntent != null ? "User needs to (re)enter credentials." : super.getMessage();
    }

    public final Intent getResolutionIntent() {
        return this.mResolutionIntent;
    }
}
