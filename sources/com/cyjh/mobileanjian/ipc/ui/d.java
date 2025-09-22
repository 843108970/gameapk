package com.cyjh.mobileanjian.ipc.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.cyjh.mobileanjian.ipc.ui.SlidingTabLayout;

final class d extends LinearLayout {

    /* renamed from: c  reason: collision with root package name */
    private static final int f2610c = 0;
    private static final byte d = 38;
    private static final int e = 3;
    private static final int f = -13388315;

    /* renamed from: a  reason: collision with root package name */
    SlidingTabLayout.c f2611a;

    /* renamed from: b  reason: collision with root package name */
    final a f2612b;
    private final int g;
    private final Paint h;
    private final int i;
    private final Paint j;
    private int k;
    private float l;

    private static class a implements SlidingTabLayout.c {

        /* renamed from: a  reason: collision with root package name */
        int[] f2613a;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        private void a(int... iArr) {
            this.f2613a = iArr;
        }

        public final int a(int i) {
            return this.f2613a[i % this.f2613a.length];
        }
    }

    d(Context context) {
        this(context, (byte) 0);
    }

    private d(Context context, byte b2) {
        super(context, (AttributeSet) null);
        setWillNotDraw(false);
        float f2 = getResources().getDisplayMetrics().density;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842800, typedValue, true);
        int i2 = typedValue.data;
        int argb = Color.argb(38, Color.red(i2), Color.green(i2), Color.blue(i2));
        this.f2612b = new a((byte) 0);
        a aVar = this.f2612b;
        aVar.f2613a = new int[]{f};
        this.g = (int) (0.0f * f2);
        this.h = new Paint();
        this.h.setColor(argb);
        this.i = (int) (f2 * 3.0f);
        this.j = new Paint();
    }

    private static int a(int i2) {
        return Color.argb(38, Color.red(i2), Color.green(i2), Color.blue(i2));
    }

    private static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.rgb((int) ((((float) Color.red(i2)) * f2) + (((float) Color.red(i3)) * f3)), (int) ((((float) Color.green(i2)) * f2) + (((float) Color.green(i3)) * f3)), (int) ((((float) Color.blue(i2)) * f2) + (((float) Color.blue(i3)) * f3)));
    }

    private void a(SlidingTabLayout.c cVar) {
        this.f2611a = cVar;
        invalidate();
    }

    private void a(int... iArr) {
        this.f2611a = null;
        this.f2612b.f2613a = iArr;
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, float f2) {
        this.k = i2;
        this.l = f2;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        int height = getHeight();
        int childCount = getChildCount();
        SlidingTabLayout.c cVar = this.f2611a != null ? this.f2611a : this.f2612b;
        if (childCount > 0) {
            View childAt = getChildAt(this.k);
            int left = childAt.getLeft();
            int right = childAt.getRight();
            int a2 = cVar.a(this.k);
            if (this.l > 0.0f && this.k < getChildCount() - 1) {
                int a3 = cVar.a(this.k + 1);
                if (a2 != a3) {
                    float f2 = this.l;
                    float f3 = 1.0f - f2;
                    a2 = Color.rgb((int) ((((float) Color.red(a3)) * f2) + (((float) Color.red(a2)) * f3)), (int) ((((float) Color.green(a3)) * f2) + (((float) Color.green(a2)) * f3)), (int) ((((float) Color.blue(a3)) * f2) + (((float) Color.blue(a2)) * f3)));
                }
                View childAt2 = getChildAt(this.k + 1);
                left = (int) ((this.l * ((float) childAt2.getLeft())) + ((1.0f - this.l) * ((float) left)));
                right = (int) ((this.l * ((float) childAt2.getRight())) + ((1.0f - this.l) * ((float) right)));
            }
            this.j.setColor(a2);
            canvas.drawRect((float) left, (float) (height - this.i), (float) right, (float) height, this.j);
        }
        canvas.drawRect(0.0f, (float) (height - this.g), (float) getWidth(), (float) height, this.h);
    }
}
