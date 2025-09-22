package com.cyjh.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.cyjh.common.R;

public class SLEditTextView extends AppCompatEditText implements TextWatcher, View.OnFocusChangeListener {
    private static final int f = 0;
    private static final int g = 1;
    private static final int h = 2;
    private static final int i = 3;

    /* renamed from: a  reason: collision with root package name */
    private Context f1826a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f1827b;

    /* renamed from: c  reason: collision with root package name */
    private int f1828c;
    private Drawable d;
    private Drawable e;
    private boolean j;

    public SLEditTextView(Context context) {
        super(context);
        a(context);
    }

    public SLEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public SLEditTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void a() {
        this.f1827b = new Paint();
        this.f1827b.setStrokeWidth(3.0f);
        this.f1828c = Color.parseColor("#a9b7b7");
    }

    private void a(Context context) {
        this.f1826a = context;
        setDrawable(context);
        setOnFocusChangeListener(this);
        addTextChangedListener(this);
        a(true);
    }

    private void a(boolean z) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        if (length() <= 0 || !z) {
            drawable = this.e;
            drawable2 = getCompoundDrawables()[1];
            drawable3 = null;
            drawable4 = getCompoundDrawables()[3];
        } else {
            drawable = this.e;
            drawable2 = getCompoundDrawables()[1];
            drawable3 = this.d;
            drawable4 = getCompoundDrawables()[3];
        }
        setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    private void b() {
        setCompoundDrawables(this.e, getCompoundDrawables()[1], (Drawable) null, getCompoundDrawables()[3]);
    }

    public void afterTextChanged(Editable editable) {
        a(true);
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        this.d = null;
        super.finalize();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void onFocusChange(View view, boolean z) {
        this.j = z;
        a(z);
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && ((float) (getWidth() - getCompoundPaddingRight())) < motionEvent.getX() && ((float) (getWidth() - getPaddingRight())) > motionEvent.getX()) {
            setText("");
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setDrawable(Context context) {
        this.d = getCompoundDrawables()[2];
        if (this.d == null) {
            this.d = getResources().getDrawable(R.drawable.icon_clear_edit);
        }
        this.d.setBounds(0, 0, a(context, 25.0f), a(context, 25.0f));
        this.e = getCompoundDrawables()[0];
        if (this.e != null) {
            this.e.setBounds(0, 0, a(context, 28.0f), a(context, 28.0f));
        }
    }
}
