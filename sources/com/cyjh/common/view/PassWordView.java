package com.cyjh.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import org.slf4j.Marker;

public class PassWordView extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f1818a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Handler f1819b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1820c;
    private boolean d;
    /* access modifiers changed from: private */
    public boolean e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private int m;
    private int n;
    private String o;
    private Context p;
    private String q;
    private int r;
    private int s;

    public PassWordView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PassWordView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PassWordView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.d = false;
        this.j = 0;
        this.k = 0;
        this.l = true;
        this.m = 40;
        this.n = 40;
        this.o = "";
        this.q = Marker.ANY_MARKER;
        this.r = 18;
        this.s = 4;
        this.p = context;
        this.f1818a = new Paint();
        this.f1818a.setAntiAlias(true);
        this.f1818a.setStrokeWidth((float) this.s);
        this.f1818a.setPathEffect(new CornerPathEffect(1.0f));
    }

    private void a(Canvas canvas) {
        if (this.f1820c) {
            this.f1818a.setColor(ContextCompat.getColor(this.p, this.i));
            this.f1818a.setStyle(Paint.Style.FILL);
            switch (this.k) {
                case 0:
                    canvas.drawCircle((float) (getMeasuredWidth() / 2), (float) (getMeasuredHeight() / 2), 8.0f, this.f1818a);
                    return;
                case 1:
                    this.f1818a.setTextSize((float) ((getMeasuredWidth() / 2) + 10));
                    float measureText = this.f1818a.measureText(this.q);
                    float measuredHeight = (((float) (getMeasuredHeight() / 2)) - ((this.f1818a.descent() + this.f1818a.ascent()) / 2.0f)) + (measureText / 3.0f);
                    canvas.drawText(this.q, ((float) (getMeasuredWidth() / 2)) - (measureText / 2.0f), measuredHeight, this.f1818a);
                    return;
                case 2:
                    this.f1818a.setTextSize((float) this.r);
                    float measureText2 = this.f1818a.measureText(this.o);
                    float measuredHeight2 = (((float) (getMeasuredHeight() / 2)) - ((this.f1818a.descent() + this.f1818a.ascent()) / 2.0f)) + (measureText2 / 5.0f);
                    canvas.drawText(this.o, ((float) (getMeasuredWidth() / 2)) - (measureText2 / 2.0f), measuredHeight2, this.f1818a);
                    return;
                default:
                    return;
            }
        }
    }

    private void b(Canvas canvas) {
        if (this.e && this.l) {
            int measuredWidth = (getMeasuredWidth() / 2) - 10;
            if (measuredWidth < 0) {
                measuredWidth = getMeasuredWidth() / 2;
            }
            this.f1818a.setStyle(Paint.Style.FILL);
            this.f1818a.setColor(ContextCompat.getColor(this.p, this.h));
            int i2 = measuredWidth / 2;
            canvas.drawLine((float) (getMeasuredWidth() / 2), (float) ((getMeasuredHeight() / 2) - i2), (float) (getMeasuredWidth() / 2), (float) ((getMeasuredHeight() / 2) + i2), this.f1818a);
        }
    }

    private void c(Canvas canvas) {
        Paint paint;
        Context context;
        int i2;
        if (this.d) {
            paint = this.f1818a;
            context = this.p;
            i2 = this.f;
        } else {
            paint = this.f1818a;
            context = this.p;
            i2 = this.g;
        }
        paint.setColor(ContextCompat.getColor(context, i2));
        this.f1818a.setStyle(Paint.Style.STROKE);
        switch (this.j) {
            case 1:
                canvas.drawCircle((float) (getMeasuredWidth() / 2), (float) (getMeasuredHeight() / 2), (float) ((getMeasuredWidth() / 2) - 5), this.f1818a);
                return;
            case 2:
                canvas.drawLine(0.0f, (float) getMeasuredHeight(), (float) getMeasuredWidth(), (float) getMeasuredHeight(), this.f1818a);
                return;
            default:
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight()), 6.0f, 6.0f, this.f1818a);
                return;
        }
    }

    public final void a() {
        this.d = true;
        this.f1820c = false;
        if (this.f1819b == null) {
            this.f1819b = new Handler();
        }
        this.f1819b.removeCallbacksAndMessages((Object) null);
        if (!this.l) {
            invalidate();
        } else {
            this.f1819b.post(new Runnable() {
                public final void run() {
                    boolean unused = PassWordView.this.e = !PassWordView.this.e;
                    PassWordView.this.invalidate();
                    PassWordView.this.f1819b.postDelayed(this, 800);
                }
            });
        }
    }

    public final void a(boolean z) {
        if (this.f1819b != null) {
            this.f1819b.removeCallbacksAndMessages((Object) null);
        }
        if (z) {
            this.d = true;
            this.f1820c = true;
        } else {
            this.d = false;
            this.f1820c = false;
        }
        this.e = false;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1819b != null) {
            this.f1819b.removeCallbacksAndMessages((Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Paint paint;
        Context context;
        int i2;
        if (this.d) {
            paint = this.f1818a;
            context = this.p;
            i2 = this.f;
        } else {
            paint = this.f1818a;
            context = this.p;
            i2 = this.g;
        }
        paint.setColor(ContextCompat.getColor(context, i2));
        this.f1818a.setStyle(Paint.Style.STROKE);
        switch (this.j) {
            case 1:
                canvas.drawCircle((float) (getMeasuredWidth() / 2), (float) (getMeasuredHeight() / 2), (float) ((getMeasuredWidth() / 2) - 5), this.f1818a);
                break;
            case 2:
                canvas.drawLine(0.0f, (float) getMeasuredHeight(), (float) getMeasuredWidth(), (float) getMeasuredHeight(), this.f1818a);
                break;
            default:
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight()), 6.0f, 6.0f, this.f1818a);
                break;
        }
        if (this.e && this.l) {
            int measuredWidth = (getMeasuredWidth() / 2) - 10;
            if (measuredWidth < 0) {
                measuredWidth = getMeasuredWidth() / 2;
            }
            this.f1818a.setStyle(Paint.Style.FILL);
            this.f1818a.setColor(ContextCompat.getColor(this.p, this.h));
            int i3 = measuredWidth / 2;
            canvas.drawLine((float) (getMeasuredWidth() / 2), (float) ((getMeasuredHeight() / 2) - i3), (float) (getMeasuredWidth() / 2), (float) ((getMeasuredHeight() / 2) + i3), this.f1818a);
        }
        if (this.f1820c) {
            this.f1818a.setColor(ContextCompat.getColor(this.p, this.i));
            this.f1818a.setStyle(Paint.Style.FILL);
            switch (this.k) {
                case 0:
                    canvas.drawCircle((float) (getMeasuredWidth() / 2), (float) (getMeasuredHeight() / 2), 8.0f, this.f1818a);
                    return;
                case 1:
                    this.f1818a.setTextSize((float) ((getMeasuredWidth() / 2) + 10));
                    float measureText = this.f1818a.measureText(this.q);
                    canvas.drawText(this.q, ((float) (getMeasuredWidth() / 2)) - (measureText / 2.0f), (((float) (getMeasuredHeight() / 2)) - ((this.f1818a.descent() + this.f1818a.ascent()) / 2.0f)) + (measureText / 3.0f), this.f1818a);
                    return;
                case 2:
                    this.f1818a.setTextSize((float) this.r);
                    float measureText2 = this.f1818a.measureText(this.o);
                    canvas.drawText(this.o, ((float) (getMeasuredWidth() / 2)) - (measureText2 / 2.0f), (((float) (getMeasuredHeight() / 2)) - ((this.f1818a.descent() + this.f1818a.ascent()) / 2.0f)) + (measureText2 / 5.0f), this.f1818a);
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824) {
            int i4 = this.m;
            size = mode == Integer.MIN_VALUE ? Math.min(i4, size) : i4;
        }
        if (mode2 != 1073741824) {
            int i5 = this.n;
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(i5, size2) : i5;
        }
        setMeasuredDimension(size, size2);
    }

    public void setDrawTxtContent(String str) {
        this.q = str;
    }

    public void setInputState(boolean z) {
        this.d = z;
    }

    public void setInputStateColor(int i2) {
        this.f = i2;
    }

    public void setInputStateTextColor(int i2) {
        this.i = i2;
    }

    public void setNoinputColor(int i2) {
        this.g = i2;
    }

    public void setRemindLineColor(int i2) {
        this.h = i2;
    }

    public void setmBoxDrawType(int i2) {
        this.j = i2;
    }

    public void setmDrawBoxLineSize(int i2) {
        this.s = i2;
    }

    public void setmDrawTxtSize(int i2) {
        this.r = i2;
    }

    public void setmIsShowRemindLine(boolean z) {
        this.l = z;
    }

    public void setmPassText(String str) {
        this.o = str;
    }

    public void setmShowPassType(int i2) {
        this.k = i2;
    }
}
