package com.cyjh.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

public class GenerateProcessButton extends ProcessButton {
    public GenerateProcessButton(Context context) {
        super(context);
    }

    public GenerateProcessButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GenerateProcessButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a(Canvas canvas) {
        getProgressDrawable().setBounds(0, 0, getMeasuredWidth(), (int) (((float) getMeasuredHeight()) * (((float) getProgress()) / ((float) getMaxProgress()))));
        getProgressDrawable().draw(canvas);
    }
}
