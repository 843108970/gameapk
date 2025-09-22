package com.cyjh.feedback.lib.b;

import android.content.Context;
import android.os.Bundle;
import com.cyjh.feedback.lib.base.a;
import com.cyjh.feedback.libraryfeedbackinfo.R;

public final class c extends a {
    public c(Context context) {
        super(context, R.style.Theme_Dialog);
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_loading);
        a(0.3f);
        a(1.0f, 1.0f);
    }
}
