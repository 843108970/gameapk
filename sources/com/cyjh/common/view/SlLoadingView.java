package com.cyjh.common.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.cyjh.common.R;

public class SlLoadingView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    protected Animation f1837a;

    public SlLoadingView(Context context) {
        super(context);
        a();
    }

    public SlLoadingView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public SlLoadingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.f1837a = AnimationUtils.loadAnimation(getContext(), R.anim.downing_animation);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setAnimation(this.f1837a);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearAnimation();
    }
}
