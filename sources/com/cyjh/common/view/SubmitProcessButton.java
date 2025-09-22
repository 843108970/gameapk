package com.cyjh.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

public class SubmitProcessButton extends ProcessButton {
    public SubmitProcessButton(Context context) {
        super(context);
    }

    public SubmitProcessButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SubmitProcessButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a(Canvas canvas) {
        getProgressDrawable().setBounds(0, 0, (int) (((float) getMeasuredWidth()) * (((float) getProgress()) / ((float) getMaxProgress()))), getMeasuredHeight());
        getProgressDrawable().draw(canvas);
    }
}
