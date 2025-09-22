package com.cyjh.feedback.lib.b;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import com.cyjh.feedback.libraryfeedbackinfo.R;

public final class a extends com.cyjh.feedback.lib.base.a {
    public a(Context context) {
        super(context, R.style.Theme_Dialog);
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_feedback_commit);
        a(0.5f);
        a(1.0f, 1.0f);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        dismiss();
        return true;
    }
}
