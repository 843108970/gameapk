package com.cyjh.mobileanjian.ipc.uip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.view.GravityCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import com.cyjh.mqsdk.R;
import java.util.ArrayList;
import java.util.List;
import mobi.oneway.export.d.e;

@TargetApi(14)
public final class b extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private int f2691a;

    /* renamed from: b  reason: collision with root package name */
    private final List<List<View>> f2692b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Integer> f2693c;
    private final List<Integer> d;

    public static class a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f2694a = -1;

        public a(int i, int i2) {
            super(i, i2);
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlowLayout_Layout);
            try {
                this.f2694a = obtainStyledAttributes.getInt(R.styleable.FlowLayout_Layout_android_layout_gravity, -1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public b(Context context) {
        this(context, (byte) 0);
    }

    private b(Context context, byte b2) {
        this(context, 0);
    }

    private b(Context context, char c2) {
        super(context, (AttributeSet) null, 0);
        this.f2691a = (b() ? GravityCompat.START : 3) | 48;
        this.f2692b = new ArrayList();
        this.f2693c = new ArrayList();
        this.d = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.FlowLayout, 0, 0);
        try {
            int i = obtainStyledAttributes.getInt(R.styleable.FlowLayout_android_gravity, -1);
            if (i > 0) {
                setGravity(i);
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private static a a() {
        return new a(-1, -1);
    }

    private a a(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    private static a a(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    private static boolean b() {
        return Build.VERSION.SDK_INT >= 14;
    }

    /* access modifiers changed from: protected */
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof a);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a(-1, -1);
    }

    public final /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public final int getGravity() {
        return this.f2691a;
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        List list;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        b bVar = this;
        bVar.f2692b.clear();
        bVar.f2693c.clear();
        bVar.d.clear();
        int width = getWidth();
        int height = getHeight();
        int paddingTop = getPaddingTop();
        ArrayList arrayList = new ArrayList();
        int i11 = bVar.f2691a & 7;
        float f = i11 != 1 ? i11 != 5 ? 0.0f : 1.0f : 0.5f;
        int i12 = paddingTop;
        ArrayList arrayList2 = arrayList;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            i5 = 8;
            if (i13 >= getChildCount()) {
                break;
            }
            View childAt = bVar.getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth() + aVar.leftMargin + aVar.rightMargin;
                int measuredHeight = childAt.getMeasuredHeight() + aVar.bottomMargin + aVar.topMargin;
                if (i15 + measuredWidth > width) {
                    bVar.f2693c.add(Integer.valueOf(i14));
                    bVar.f2692b.add(arrayList2);
                    bVar.d.add(Integer.valueOf(((int) (((float) (width - i15)) * f)) + getPaddingLeft()));
                    i12 += i14;
                    arrayList2 = new ArrayList();
                    i14 = 0;
                    i15 = 0;
                }
                i15 += measuredWidth;
                i14 = Math.max(i14, measuredHeight);
                arrayList2.add(childAt);
            }
            i13++;
        }
        bVar.f2693c.add(Integer.valueOf(i14));
        bVar.f2692b.add(arrayList2);
        bVar.d.add(Integer.valueOf(((int) (((float) (width - i15)) * f)) + getPaddingLeft()));
        int i16 = i12 + i14;
        int i17 = bVar.f2691a & 112;
        int i18 = i17 != 16 ? i17 != 80 ? 0 : height - i16 : (height - i16) / 2;
        int size = bVar.f2692b.size();
        int paddingTop2 = getPaddingTop();
        int i19 = 0;
        while (i19 < size) {
            int intValue = bVar.f2693c.get(i19).intValue();
            List list2 = bVar.f2692b.get(i19);
            int intValue2 = bVar.d.get(i19).intValue();
            int size2 = list2.size();
            int i20 = intValue2;
            int i21 = 0;
            while (i21 < size2) {
                View view = (View) list2.get(i21);
                if (view.getVisibility() != i5) {
                    a aVar2 = (a) view.getLayoutParams();
                    if (aVar2.height == -1) {
                        if (aVar2.width == -1) {
                            i10 = i15;
                        } else if (aVar2.width >= 0) {
                            i10 = aVar2.width;
                        } else {
                            i10 = i15;
                            i9 = Integer.MIN_VALUE;
                            view.measure(View.MeasureSpec.makeMeasureSpec(i10, i9), View.MeasureSpec.makeMeasureSpec((intValue - aVar2.topMargin) - aVar2.bottomMargin, e.e));
                        }
                        i9 = e.e;
                        view.measure(View.MeasureSpec.makeMeasureSpec(i10, i9), View.MeasureSpec.makeMeasureSpec((intValue - aVar2.topMargin) - aVar2.bottomMargin, e.e));
                    }
                    int measuredWidth2 = view.getMeasuredWidth();
                    int measuredHeight2 = view.getMeasuredHeight();
                    if (Gravity.isVertical(aVar2.f2694a)) {
                        int i22 = aVar2.f2694a;
                        if (i22 != 80) {
                            switch (i22) {
                                case 16:
                                case 17:
                                    i8 = (((intValue - measuredHeight2) - aVar2.topMargin) - aVar2.bottomMargin) / 2;
                                    break;
                            }
                        } else {
                            i8 = ((intValue - measuredHeight2) - aVar2.topMargin) - aVar2.bottomMargin;
                        }
                        i7 = size;
                        i6 = i15;
                        list = list2;
                        view.layout(aVar2.leftMargin + i20, aVar2.topMargin + paddingTop2 + i8 + i18, i20 + measuredWidth2 + aVar2.leftMargin, measuredHeight2 + paddingTop2 + aVar2.topMargin + i8 + i18);
                        i20 += measuredWidth2 + aVar2.leftMargin + aVar2.rightMargin;
                    }
                    i8 = 0;
                    i7 = size;
                    i6 = i15;
                    list = list2;
                    view.layout(aVar2.leftMargin + i20, aVar2.topMargin + paddingTop2 + i8 + i18, i20 + measuredWidth2 + aVar2.leftMargin, measuredHeight2 + paddingTop2 + aVar2.topMargin + i8 + i18);
                    i20 += measuredWidth2 + aVar2.leftMargin + aVar2.rightMargin;
                } else {
                    i7 = size;
                    i6 = i15;
                    list = list2;
                }
                i21++;
                size = i7;
                i15 = i6;
                list2 = list;
                i5 = 8;
            }
            int i23 = size;
            int i24 = i15;
            paddingTop2 += intValue;
            i19++;
            bVar = this;
            i5 = 8;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r21, int r22) {
        /*
            r20 = this;
            r6 = r20
            super.onMeasure(r21, r22)
            int r0 = android.view.View.MeasureSpec.getSize(r21)
            int r1 = r20.getPaddingLeft()
            int r0 = r0 - r1
            int r1 = r20.getPaddingRight()
            int r7 = r0 - r1
            int r8 = android.view.View.MeasureSpec.getSize(r22)
            int r9 = android.view.View.MeasureSpec.getMode(r21)
            int r10 = android.view.View.MeasureSpec.getMode(r22)
            int r0 = r20.getPaddingTop()
            int r1 = r20.getPaddingBottom()
            int r0 = r0 + r1
            int r11 = r20.getChildCount()
            r16 = r0
            r5 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x0033:
            r4 = 1073741824(0x40000000, float:2.0)
            if (r13 >= r11) goto L_0x00ed
            android.view.View r3 = r6.getChildAt(r13)
            int r0 = r11 + -1
            if (r13 != r0) goto L_0x0043
            r0 = 1
            r17 = 1
            goto L_0x0045
        L_0x0043:
            r17 = 0
        L_0x0045:
            int r0 = r3.getVisibility()
            r1 = 8
            if (r0 != r1) goto L_0x005a
            if (r17 == 0) goto L_0x0056
            int r0 = java.lang.Math.max(r14, r15)
            int r16 = r16 + r5
            r14 = r0
        L_0x0056:
            r18 = r8
            goto L_0x00e7
        L_0x005a:
            r0 = r6
            r1 = r3
            r2 = r21
            r12 = r3
            r3 = r15
            r18 = r8
            r8 = 1073741824(0x40000000, float:2.0)
            r4 = r22
            r8 = r5
            r5 = r16
            r0.measureChildWithMargins(r1, r2, r3, r4, r5)
            android.view.ViewGroup$LayoutParams r0 = r12.getLayoutParams()
            com.cyjh.mobileanjian.ipc.uip.b$a r0 = (com.cyjh.mobileanjian.ipc.uip.b.a) r0
            int r1 = r0.width
            r2 = -1
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != r2) goto L_0x0084
            int r1 = r0.leftMargin
            int r2 = r0.rightMargin
            int r1 = r1 + r2
            int r1 = r7 - r1
        L_0x0080:
            r2 = r1
            r1 = 1073741824(0x40000000, float:2.0)
            goto L_0x008e
        L_0x0084:
            int r1 = r0.width
            if (r1 < 0) goto L_0x008b
            int r1 = r0.width
            goto L_0x0080
        L_0x008b:
            r2 = r7
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x008e:
            int r4 = r0.height
            if (r4 < 0) goto L_0x0097
            int r3 = r0.height
            r4 = 1073741824(0x40000000, float:2.0)
            goto L_0x00a0
        L_0x0097:
            if (r10 != 0) goto L_0x009c
            r3 = 0
            r4 = 0
            goto L_0x00a0
        L_0x009c:
            r3 = r18
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00a0:
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r4)
            r12.measure(r1, r2)
            int r1 = r12.getMeasuredWidth()
            int r2 = r0.leftMargin
            int r1 = r1 + r2
            int r2 = r0.rightMargin
            int r1 = r1 + r2
            int r2 = r15 + r1
            if (r2 <= r7) goto L_0x00cc
            int r14 = java.lang.Math.max(r14, r15)
            int r16 = r16 + r8
            int r2 = r12.getMeasuredHeight()
            int r3 = r0.topMargin
            int r2 = r2 + r3
            int r0 = r0.bottomMargin
            int r2 = r2 + r0
            r15 = r1
            r0 = r2
            goto L_0x00db
        L_0x00cc:
            int r1 = r12.getMeasuredHeight()
            int r3 = r0.topMargin
            int r1 = r1 + r3
            int r0 = r0.bottomMargin
            int r1 = r1 + r0
            int r0 = java.lang.Math.max(r8, r1)
            r15 = r2
        L_0x00db:
            if (r17 == 0) goto L_0x00e6
            int r1 = java.lang.Math.max(r14, r15)
            int r16 = r16 + r0
            r5 = r0
            r14 = r1
            goto L_0x00e7
        L_0x00e6:
            r5 = r0
        L_0x00e7:
            int r13 = r13 + 1
            r8 = r18
            goto L_0x0033
        L_0x00ed:
            r18 = r8
            int r0 = r20.getPaddingLeft()
            int r1 = r20.getPaddingRight()
            int r0 = r0 + r1
            int r0 = r0 + r14
            r1 = 1073741824(0x40000000, float:2.0)
            if (r9 != r1) goto L_0x00fe
            r0 = r7
        L_0x00fe:
            if (r10 != r1) goto L_0x0103
            r1 = r18
            goto L_0x0105
        L_0x0103:
            r1 = r16
        L_0x0105:
            r6.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.uip.b.onMeasure(int, int):void");
    }

    @TargetApi(14)
    public final void setGravity(int i) {
        if (this.f2691a != i) {
            if ((8388615 & i) == 0) {
                i |= b() ? GravityCompat.START : 3;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.f2691a = i;
            requestLayout();
        }
    }
}
