package com.cyjh.common.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.cyjh.common.R;

public class ActionProcessButton extends ProcessButton {

    /* renamed from: a  reason: collision with root package name */
    private b f1797a;

    /* renamed from: b  reason: collision with root package name */
    private a f1798b;

    /* renamed from: c  reason: collision with root package name */
    private int f1799c;
    private int d;
    private int e;
    private int f;

    public enum a {
        PROGRESS,
        ENDLESS
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        static final Interpolator f1801a = new AccelerateDecelerateInterpolator();
        private static final int m = -1291845632;
        private static final int n = Integer.MIN_VALUE;
        private static final int o = 1291845632;
        private static final int p = 436207616;
        private static final int q = 2000;
        private static final int r = 1000;

        /* renamed from: b  reason: collision with root package name */
        final RectF f1802b = new RectF();

        /* renamed from: c  reason: collision with root package name */
        float f1803c;
        long d;
        long e;
        boolean f;
        int g;
        int h;
        int i;
        int j;
        View k;
        Rect l = new Rect();
        private final Paint s = new Paint();

        public b(View view) {
            this.k = view;
            this.g = m;
            this.h = Integer.MIN_VALUE;
            this.i = o;
            this.j = p;
        }

        private void a() {
            if (!this.f) {
                this.f1803c = 0.0f;
                this.d = AnimationUtils.currentAnimationTimeMillis();
                this.f = true;
                this.k.postInvalidate();
            }
        }

        private void a(int i2, int i3, int i4) {
            this.l.left = 0;
            this.l.top = i2;
            this.l.right = i3;
            this.l.bottom = i4;
        }

        private void a(int i2, int i3, int i4, int i5) {
            this.g = i2;
            this.h = i3;
            this.i = i4;
            this.j = i5;
        }

        private void a(Canvas canvas) {
            boolean z;
            long j2;
            int i2;
            Canvas canvas2 = canvas;
            int width = this.l.width();
            int height = this.l.height();
            int i3 = width / 2;
            int i4 = height / 2;
            int save = canvas.save();
            canvas2.clipRect(this.l);
            if (this.f || this.e > 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                long j3 = (currentAnimationTimeMillis - this.d) / 2000;
                float f2 = ((float) ((currentAnimationTimeMillis - this.d) % 2000)) / 20.0f;
                if (this.f) {
                    j2 = 0;
                    z = false;
                } else if (currentAnimationTimeMillis - this.e >= 1000) {
                    this.e = 0;
                    return;
                } else {
                    float f3 = (float) i3;
                    float interpolation = f1801a.getInterpolation((((float) ((currentAnimationTimeMillis - this.e) % 1000)) / 10.0f) / 100.0f) * f3;
                    this.f1802b.set(f3 - interpolation, 0.0f, f3 + interpolation, (float) height);
                    canvas2.saveLayerAlpha(this.f1802b, 0, 0);
                    j2 = 0;
                    z = true;
                }
                if (j3 != j2) {
                    if (f2 >= 0.0f && f2 < 25.0f) {
                        i2 = this.j;
                        canvas2.drawColor(i2);
                        a(canvas2, (float) i3, (float) i4, this.g, ((f2 + 25.0f) * 2.0f) / 100.0f);
                        a(canvas2, (float) i3, (float) i4, this.h, (f2 * 2.0f) / 100.0f);
                        a(canvas2, (float) i3, (float) i4, this.i, ((f2 - 25.0f) * 2.0f) / 100.0f);
                        a(canvas2, (float) i3, (float) i4, this.j, ((f2 - 50.0f) * 2.0f) / 100.0f);
                        a(canvas2, (float) i3, (float) i4, this.g, ((f2 - 75.0f) * 2.0f) / 100.0f);
                        canvas2.restoreToCount(save);
                        int save2 = canvas.save();
                        canvas2.clipRect(this.l);
                        a(canvas2, i3, i4);
                        save = save2;
                        ViewCompat.postInvalidateOnAnimation(this.k);
                    } else if (f2 < 25.0f || f2 >= 50.0f) {
                        i2 = (f2 < 50.0f || f2 >= 75.0f) ? this.i : this.h;
                        canvas2.drawColor(i2);
                        if (f2 >= 0.0f && f2 <= 25.0f) {
                            a(canvas2, (float) i3, (float) i4, this.g, ((f2 + 25.0f) * 2.0f) / 100.0f);
                        }
                        if (f2 >= 0.0f && f2 <= 50.0f) {
                            a(canvas2, (float) i3, (float) i4, this.h, (f2 * 2.0f) / 100.0f);
                        }
                        if (f2 >= 25.0f && f2 <= 75.0f) {
                            a(canvas2, (float) i3, (float) i4, this.i, ((f2 - 25.0f) * 2.0f) / 100.0f);
                        }
                        if (f2 >= 50.0f && f2 <= 100.0f) {
                            a(canvas2, (float) i3, (float) i4, this.j, ((f2 - 50.0f) * 2.0f) / 100.0f);
                        }
                        if (f2 >= 75.0f && f2 <= 100.0f) {
                            a(canvas2, (float) i3, (float) i4, this.g, ((f2 - 75.0f) * 2.0f) / 100.0f);
                        }
                        if (this.f1803c > 0.0f && z) {
                            canvas2.restoreToCount(save);
                            int save22 = canvas.save();
                            canvas2.clipRect(this.l);
                            a(canvas2, i3, i4);
                            save = save22;
                        }
                        ViewCompat.postInvalidateOnAnimation(this.k);
                    }
                }
                i2 = this.g;
                canvas2.drawColor(i2);
                a(canvas2, (float) i3, (float) i4, this.g, ((f2 + 25.0f) * 2.0f) / 100.0f);
                a(canvas2, (float) i3, (float) i4, this.h, (f2 * 2.0f) / 100.0f);
                a(canvas2, (float) i3, (float) i4, this.i, ((f2 - 25.0f) * 2.0f) / 100.0f);
                a(canvas2, (float) i3, (float) i4, this.j, ((f2 - 50.0f) * 2.0f) / 100.0f);
                a(canvas2, (float) i3, (float) i4, this.g, ((f2 - 75.0f) * 2.0f) / 100.0f);
                canvas2.restoreToCount(save);
                int save222 = canvas.save();
                canvas2.clipRect(this.l);
                a(canvas2, i3, i4);
                save = save222;
                ViewCompat.postInvalidateOnAnimation(this.k);
            } else if (this.f1803c > 0.0f && ((double) this.f1803c) <= 1.0d) {
                a(canvas2, i3, i4);
            }
            canvas2.restoreToCount(save);
        }

        /* access modifiers changed from: package-private */
        public final void a(Canvas canvas, float f2, float f3, int i2, float f4) {
            this.s.setColor(i2);
            canvas.save();
            canvas.translate(f2, f3);
            float interpolation = f1801a.getInterpolation(f4);
            canvas.scale(interpolation, interpolation);
            canvas.drawCircle(0.0f, 0.0f, f2, this.s);
            canvas.restore();
        }

        /* access modifiers changed from: package-private */
        public final void a(Canvas canvas, int i2, int i3) {
            this.s.setColor(this.g);
            float f2 = (float) i2;
            canvas.drawCircle(f2, (float) i3, this.f1803c * f2, this.s);
        }
    }

    public ActionProcessButton(Context context) {
        super(context);
        a(context);
    }

    public ActionProcessButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ActionProcessButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a() {
        int measuredHeight = (int) (((double) getMeasuredHeight()) - ((double) b(R.dimen.layer_padding)));
        b bVar = this.f1797a;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight2 = getMeasuredHeight();
        bVar.l.left = 0;
        bVar.l.top = measuredHeight;
        bVar.l.right = measuredWidth;
        bVar.l.bottom = measuredHeight2;
    }

    private void a(int i, int i2, int i3, int i4) {
        this.f1799c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
    }

    private void a(Context context) {
        Resources resources = context.getResources();
        this.f1798b = a.ENDLESS;
        this.f1799c = resources.getColor(R.color.holo_blue_bright);
        this.d = resources.getColor(R.color.holo_green_light);
        this.e = resources.getColor(R.color.holo_orange_light);
        this.f = resources.getColor(R.color.holo_red_light);
    }

    private void b(Canvas canvas) {
        float measuredWidth = ((float) getMeasuredWidth()) * (((float) getProgress()) / ((float) getMaxProgress()));
        getProgressDrawable().setBounds(0, (int) (((double) getMeasuredHeight()) - (((double) getMeasuredHeight()) * 0.05d)), (int) measuredWidth, getMeasuredHeight());
        getProgressDrawable().draw(canvas);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0193 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(android.graphics.Canvas r25) {
        /*
            r24 = this;
            r0 = r24
            r7 = r25
            com.cyjh.common.view.ActionProcessButton$b r1 = r0.f1797a
            r2 = 1
            r8 = 0
            if (r1 != 0) goto L_0x003b
            com.cyjh.common.view.ActionProcessButton$b r1 = new com.cyjh.common.view.ActionProcessButton$b
            r1.<init>(r0)
            r0.f1797a = r1
            r24.a()
            com.cyjh.common.view.ActionProcessButton$b r1 = r0.f1797a
            int r3 = r0.f1799c
            int r4 = r0.d
            int r5 = r0.e
            int r6 = r0.f
            r1.g = r3
            r1.h = r4
            r1.i = r5
            r1.j = r6
            com.cyjh.common.view.ActionProcessButton$b r1 = r0.f1797a
            boolean r3 = r1.f
            if (r3 != 0) goto L_0x003b
            r1.f1803c = r8
            long r3 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
            r1.d = r3
            r1.f = r2
            android.view.View r1 = r1.k
            r1.postInvalidate()
        L_0x003b:
            int r1 = r24.getProgress()
            if (r1 <= 0) goto L_0x01b2
            com.cyjh.common.view.ActionProcessButton$b r9 = r0.f1797a
            android.graphics.Rect r1 = r9.l
            int r1 = r1.width()
            android.graphics.Rect r3 = r9.l
            int r3 = r3.height()
            int r10 = r1 / 2
            int r11 = r3 / 2
            int r12 = r25.save()
            android.graphics.Rect r1 = r9.l
            r7.clipRect(r1)
            boolean r1 = r9.f
            r4 = 0
            if (r1 != 0) goto L_0x007d
            long r13 = r9.e
            int r1 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x0069
            goto L_0x007d
        L_0x0069:
            float r1 = r9.f1803c
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x01af
            float r1 = r9.f1803c
            double r1 = (double) r1
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x01af
            r9.a((android.graphics.Canvas) r7, (int) r10, (int) r11)
            goto L_0x01af
        L_0x007d:
            long r13 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
            r16 = r3
            long r2 = r9.d
            long r17 = r13 - r2
            r1 = 2000(0x7d0, double:9.88E-321)
            long r4 = r17 % r1
            r19 = r11
            r20 = r12
            long r11 = r9.d
            long r17 = r13 - r11
            long r17 = r17 / r1
            float r1 = (float) r4
            r2 = 1101004800(0x41a00000, float:20.0)
            float r11 = r1 / r2
            boolean r1 = r9.f
            r2 = 0
            r12 = 1120403456(0x42c80000, float:100.0)
            if (r1 != 0) goto L_0x00d8
            long r3 = r9.e
            long r5 = r13 - r3
            r3 = 1000(0x3e8, double:4.94E-321)
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x00b0
            r5 = 0
            r9.e = r5
            return
        L_0x00b0:
            long r5 = r9.e
            long r21 = r13 - r5
            long r3 = r21 % r3
            float r1 = (float) r3
            r3 = 1092616192(0x41200000, float:10.0)
            float r1 = r1 / r3
            float r1 = r1 / r12
            float r3 = (float) r10
            android.view.animation.Interpolator r4 = com.cyjh.common.view.ActionProcessButton.b.f1801a
            float r1 = r4.getInterpolation(r1)
            float r1 = r1 * r3
            android.graphics.RectF r4 = r9.f1802b
            float r5 = r3 - r1
            float r3 = r3 + r1
            r1 = r16
            float r1 = (float) r1
            r4.set(r5, r8, r3, r1)
            android.graphics.RectF r1 = r9.f1802b
            r7.saveLayerAlpha(r1, r2, r2)
            r1 = 0
            r15 = 1
            goto L_0x00db
        L_0x00d8:
            r1 = 0
            r15 = 0
        L_0x00db:
            int r3 = (r17 > r1 ? 1 : (r17 == r1 ? 0 : -1))
            r13 = 1117126656(0x42960000, float:75.0)
            r14 = 1112014848(0x42480000, float:50.0)
            r16 = 1103626240(0x41c80000, float:25.0)
            if (r3 != 0) goto L_0x00eb
        L_0x00e5:
            int r1 = r9.g
        L_0x00e7:
            r7.drawColor(r1)
            goto L_0x010d
        L_0x00eb:
            int r1 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r1 < 0) goto L_0x00f6
            int r1 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r1 >= 0) goto L_0x00f6
            int r1 = r9.j
            goto L_0x00e7
        L_0x00f6:
            int r1 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r1 < 0) goto L_0x00ff
            int r1 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r1 >= 0) goto L_0x00ff
            goto L_0x00e5
        L_0x00ff:
            int r1 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r1 < 0) goto L_0x010a
            int r1 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r1 >= 0) goto L_0x010a
            int r1 = r9.h
            goto L_0x00e7
        L_0x010a:
            int r1 = r9.i
            goto L_0x00e7
        L_0x010d:
            int r1 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            r17 = 1073741824(0x40000000, float:2.0)
            if (r1 < 0) goto L_0x012e
            int r1 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r1 > 0) goto L_0x012e
            float r1 = r11 + r16
            float r1 = r1 * r17
            float r6 = r1 / r12
            float r3 = (float) r10
            r5 = r19
            float r4 = (float) r5
            int r2 = r9.g
            r1 = r9
            r18 = r2
            r2 = r7
            r13 = r5
            r5 = r18
            r1.a(r2, r3, r4, r5, r6)
            goto L_0x0130
        L_0x012e:
            r13 = r19
        L_0x0130:
            int r1 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r1 < 0) goto L_0x0145
            int r1 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r1 > 0) goto L_0x0145
            float r1 = r11 * r17
            float r6 = r1 / r12
            float r3 = (float) r10
            float r4 = (float) r13
            int r5 = r9.h
            r1 = r9
            r2 = r7
            r1.a(r2, r3, r4, r5, r6)
        L_0x0145:
            int r1 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r1 < 0) goto L_0x015e
            r1 = 1117126656(0x42960000, float:75.0)
            int r2 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r2 > 0) goto L_0x015e
            float r1 = r11 - r16
            float r1 = r1 * r17
            float r6 = r1 / r12
            float r3 = (float) r10
            float r4 = (float) r13
            int r5 = r9.i
            r1 = r9
            r2 = r7
            r1.a(r2, r3, r4, r5, r6)
        L_0x015e:
            int r1 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r1 < 0) goto L_0x0175
            int r1 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            if (r1 > 0) goto L_0x0175
            float r1 = r11 - r14
            float r1 = r1 * r17
            float r6 = r1 / r12
            float r3 = (float) r10
            float r4 = (float) r13
            int r5 = r9.j
            r1 = r9
            r2 = r7
            r1.a(r2, r3, r4, r5, r6)
        L_0x0175:
            r1 = 1117126656(0x42960000, float:75.0)
            int r2 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r2 < 0) goto L_0x018d
            int r2 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            if (r2 > 0) goto L_0x018d
            float r11 = r11 - r1
            float r11 = r11 * r17
            float r6 = r11 / r12
            float r3 = (float) r10
            float r4 = (float) r13
            int r5 = r9.g
            r1 = r9
            r2 = r7
            r1.a(r2, r3, r4, r5, r6)
        L_0x018d:
            float r1 = r9.f1803c
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x01a7
            if (r15 == 0) goto L_0x01a7
            r1 = r20
            r7.restoreToCount(r1)
            int r1 = r25.save()
            android.graphics.Rect r2 = r9.l
            r7.clipRect(r2)
            r9.a((android.graphics.Canvas) r7, (int) r10, (int) r13)
            goto L_0x01a9
        L_0x01a7:
            r1 = r20
        L_0x01a9:
            r12 = r1
            android.view.View r1 = r9.k
            android.support.v4.view.ViewCompat.postInvalidateOnAnimation(r1)
        L_0x01af:
            r7.restoreToCount(r12)
        L_0x01b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.common.view.ActionProcessButton.c(android.graphics.Canvas):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01eb A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.graphics.Canvas r25) {
        /*
            r24 = this;
            r0 = r24
            r7 = r25
            android.graphics.drawable.Drawable r1 = r24.getBackground()
            android.graphics.drawable.StateListDrawable r2 = r24.getNormalDrawable()
            if (r1 == r2) goto L_0x0015
            android.graphics.drawable.StateListDrawable r1 = r24.getNormalDrawable()
            r0.setBackgroundDrawable(r1)
        L_0x0015:
            int[] r1 = com.cyjh.common.view.ActionProcessButton.AnonymousClass1.f1800a
            com.cyjh.common.view.ActionProcessButton$a r2 = r0.f1798b
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 0
            switch(r1) {
                case 1: goto L_0x005d;
                case 2: goto L_0x0024;
                default: goto L_0x0023;
            }
        L_0x0023:
            return
        L_0x0024:
            int r1 = r24.getProgress()
            float r1 = (float) r1
            int r3 = r24.getMaxProgress()
            float r3 = (float) r3
            float r1 = r1 / r3
            int r3 = r24.getMeasuredWidth()
            float r3 = (float) r3
            float r3 = r3 * r1
            int r1 = r24.getMeasuredHeight()
            double r4 = (double) r1
            int r1 = r24.getMeasuredHeight()
            double r8 = (double) r1
            r10 = 4587366580439587226(0x3fa999999999999a, double:0.05)
            double r8 = r8 * r10
            double r4 = r4 - r8
            int r1 = (int) r4
            android.graphics.drawable.GradientDrawable r4 = r24.getProgressDrawable()
            int r3 = (int) r3
            int r5 = r24.getMeasuredHeight()
            r4.setBounds(r2, r1, r3, r5)
            android.graphics.drawable.GradientDrawable r1 = r24.getProgressDrawable()
            r1.draw(r7)
            return
        L_0x005d:
            com.cyjh.common.view.ActionProcessButton$b r1 = r0.f1797a
            r3 = 1
            r8 = 0
            if (r1 != 0) goto L_0x0094
            com.cyjh.common.view.ActionProcessButton$b r1 = new com.cyjh.common.view.ActionProcessButton$b
            r1.<init>(r0)
            r0.f1797a = r1
            r24.a()
            com.cyjh.common.view.ActionProcessButton$b r1 = r0.f1797a
            int r4 = r0.f1799c
            int r5 = r0.d
            int r6 = r0.e
            int r9 = r0.f
            r1.g = r4
            r1.h = r5
            r1.i = r6
            r1.j = r9
            com.cyjh.common.view.ActionProcessButton$b r1 = r0.f1797a
            boolean r4 = r1.f
            if (r4 != 0) goto L_0x0094
            r1.f1803c = r8
            long r4 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
            r1.d = r4
            r1.f = r3
            android.view.View r1 = r1.k
            r1.postInvalidate()
        L_0x0094:
            int r1 = r24.getProgress()
            if (r1 <= 0) goto L_0x020a
            com.cyjh.common.view.ActionProcessButton$b r9 = r0.f1797a
            android.graphics.Rect r1 = r9.l
            int r1 = r1.width()
            android.graphics.Rect r4 = r9.l
            int r4 = r4.height()
            int r10 = r1 / 2
            int r11 = r4 / 2
            int r12 = r25.save()
            android.graphics.Rect r1 = r9.l
            r7.clipRect(r1)
            boolean r1 = r9.f
            r5 = 0
            if (r1 != 0) goto L_0x00d6
            long r13 = r9.e
            int r1 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x00c2
            goto L_0x00d6
        L_0x00c2:
            float r1 = r9.f1803c
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x0207
            float r1 = r9.f1803c
            double r1 = (double) r1
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0207
            r9.a((android.graphics.Canvas) r7, (int) r10, (int) r11)
            goto L_0x0207
        L_0x00d6:
            long r13 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
            long r2 = r9.d
            long r17 = r13 - r2
            r1 = 2000(0x7d0, double:9.88E-321)
            long r5 = r17 % r1
            r19 = r11
            r20 = r12
            long r11 = r9.d
            long r17 = r13 - r11
            long r17 = r17 / r1
            float r1 = (float) r5
            r2 = 1101004800(0x41a00000, float:20.0)
            float r11 = r1 / r2
            boolean r1 = r9.f
            r12 = 1120403456(0x42c80000, float:100.0)
            if (r1 != 0) goto L_0x012e
            long r1 = r9.e
            long r5 = r13 - r1
            r1 = 1000(0x3e8, double:4.94E-321)
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 < 0) goto L_0x0106
            r5 = 0
            r9.e = r5
            return
        L_0x0106:
            long r5 = r9.e
            long r21 = r13 - r5
            long r1 = r21 % r1
            float r1 = (float) r1
            r2 = 1092616192(0x41200000, float:10.0)
            float r1 = r1 / r2
            float r1 = r1 / r12
            float r2 = (float) r10
            android.view.animation.Interpolator r3 = com.cyjh.common.view.ActionProcessButton.b.f1801a
            float r1 = r3.getInterpolation(r1)
            float r1 = r1 * r2
            android.graphics.RectF r3 = r9.f1802b
            float r5 = r2 - r1
            float r2 = r2 + r1
            float r1 = (float) r4
            r3.set(r5, r8, r2, r1)
            android.graphics.RectF r1 = r9.f1802b
            r2 = 0
            r7.saveLayerAlpha(r1, r2, r2)
            r1 = 0
            r16 = 1
            goto L_0x0133
        L_0x012e:
            r2 = 0
            r1 = 0
            r16 = 0
        L_0x0133:
            int r3 = (r17 > r1 ? 1 : (r17 == r1 ? 0 : -1))
            r13 = 1117126656(0x42960000, float:75.0)
            r14 = 1112014848(0x42480000, float:50.0)
            r15 = 1103626240(0x41c80000, float:25.0)
            if (r3 != 0) goto L_0x0143
        L_0x013d:
            int r1 = r9.g
        L_0x013f:
            r7.drawColor(r1)
            goto L_0x0165
        L_0x0143:
            int r1 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r1 < 0) goto L_0x014e
            int r1 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r1 >= 0) goto L_0x014e
            int r1 = r9.j
            goto L_0x013f
        L_0x014e:
            int r1 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r1 < 0) goto L_0x0157
            int r1 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r1 >= 0) goto L_0x0157
            goto L_0x013d
        L_0x0157:
            int r1 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r1 < 0) goto L_0x0162
            int r1 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r1 >= 0) goto L_0x0162
            int r1 = r9.h
            goto L_0x013f
        L_0x0162:
            int r1 = r9.i
            goto L_0x013f
        L_0x0165:
            int r1 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            r17 = 1073741824(0x40000000, float:2.0)
            if (r1 < 0) goto L_0x0186
            int r1 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r1 > 0) goto L_0x0186
            float r1 = r11 + r15
            float r1 = r1 * r17
            float r6 = r1 / r12
            float r3 = (float) r10
            r5 = r19
            float r4 = (float) r5
            int r2 = r9.g
            r1 = r9
            r18 = r2
            r2 = r7
            r13 = r5
            r5 = r18
            r1.a(r2, r3, r4, r5, r6)
            goto L_0x0188
        L_0x0186:
            r13 = r19
        L_0x0188:
            int r1 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r1 < 0) goto L_0x019d
            int r1 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r1 > 0) goto L_0x019d
            float r1 = r11 * r17
            float r6 = r1 / r12
            float r3 = (float) r10
            float r4 = (float) r13
            int r5 = r9.h
            r1 = r9
            r2 = r7
            r1.a(r2, r3, r4, r5, r6)
        L_0x019d:
            int r1 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r1 < 0) goto L_0x01b6
            r1 = 1117126656(0x42960000, float:75.0)
            int r2 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r2 > 0) goto L_0x01b6
            float r1 = r11 - r15
            float r1 = r1 * r17
            float r6 = r1 / r12
            float r3 = (float) r10
            float r4 = (float) r13
            int r5 = r9.i
            r1 = r9
            r2 = r7
            r1.a(r2, r3, r4, r5, r6)
        L_0x01b6:
            int r1 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r1 < 0) goto L_0x01cd
            int r1 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            if (r1 > 0) goto L_0x01cd
            float r1 = r11 - r14
            float r1 = r1 * r17
            float r6 = r1 / r12
            float r3 = (float) r10
            float r4 = (float) r13
            int r5 = r9.j
            r1 = r9
            r2 = r7
            r1.a(r2, r3, r4, r5, r6)
        L_0x01cd:
            r1 = 1117126656(0x42960000, float:75.0)
            int r2 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r2 < 0) goto L_0x01e5
            int r2 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            if (r2 > 0) goto L_0x01e5
            float r11 = r11 - r1
            float r11 = r11 * r17
            float r6 = r11 / r12
            float r3 = (float) r10
            float r4 = (float) r13
            int r5 = r9.g
            r1 = r9
            r2 = r7
            r1.a(r2, r3, r4, r5, r6)
        L_0x01e5:
            float r1 = r9.f1803c
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x01ff
            if (r16 == 0) goto L_0x01ff
            r1 = r20
            r7.restoreToCount(r1)
            int r1 = r25.save()
            android.graphics.Rect r2 = r9.l
            r7.clipRect(r2)
            r9.a((android.graphics.Canvas) r7, (int) r10, (int) r13)
            goto L_0x0201
        L_0x01ff:
            r1 = r20
        L_0x0201:
            r12 = r1
            android.view.View r1 = r9.k
            android.support.v4.view.ViewCompat.postInvalidateOnAnimation(r1)
        L_0x0207:
            r7.restoreToCount(r12)
        L_0x020a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.common.view.ActionProcessButton.a(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f1797a != null) {
            a();
        }
    }

    public void setMode(a aVar) {
        this.f1798b = aVar;
    }
}
