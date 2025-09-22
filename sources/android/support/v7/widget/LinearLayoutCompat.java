package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import mobi.oneway.export.d.e;

public class LinearLayoutCompat extends ViewGroup {
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = -1;
            this.weight = 0.0f;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2);
            this.gravity = -1;
            this.weight = f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LinearLayoutCompat_Layout);
            this.weight = obtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.gravity = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
            this.weight = layoutParams.weight;
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = -1;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(Context context) {
        this(context, (AttributeSet) null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.LinearLayoutCompat, i, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = obtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(obtainStyledAttributes.getDrawable(R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    private void forceUniformHeight(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), e.e);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i4 = layoutParams.width;
                    layoutParams.width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i2, 0, makeMeasureSpec, 0);
                    layoutParams.width = i4;
                }
            }
        }
    }

    private void forceUniformWidth(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), e.e);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: package-private */
    public void drawDividersHorizontal(Canvas canvas) {
        int i;
        int left;
        int i2;
        int virtualChildCount = getVirtualChildCount();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i3 = 0; i3 < virtualChildCount; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i3))) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                drawVerticalDivider(canvas, isLayoutRtl ? virtualChildAt.getRight() + layoutParams.rightMargin : (virtualChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerWidth);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                if (isLayoutRtl) {
                    left = virtualChildAt2.getLeft();
                    i2 = layoutParams2.leftMargin;
                } else {
                    i = virtualChildAt2.getRight() + layoutParams2.rightMargin;
                    drawVerticalDivider(canvas, i);
                }
            } else if (isLayoutRtl) {
                i = getPaddingLeft();
                drawVerticalDivider(canvas, i);
            } else {
                left = getWidth();
                i2 = getPaddingRight();
            }
            i = (left - i2) - this.mDividerWidth;
            drawVerticalDivider(canvas, i);
        }
    }

    /* access modifiers changed from: package-private */
    public void drawDividersVertical(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View virtualChildAt = getVirtualChildAt(i);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i))) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LayoutParams) virtualChildAt.getLayoutParams()).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            drawHorizontalDivider(canvas, virtualChildAt2 == null ? (getHeight() - getPaddingBottom()) - this.mDividerHeight : virtualChildAt2.getBottom() + ((LayoutParams) virtualChildAt2.getLayoutParams()).bottomMargin);
        }
    }

    /* access modifiers changed from: package-private */
    public void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    /* access modifiers changed from: package-private */
    public void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -2);
        }
        if (this.mOrientation == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getBaseline() {
        int i;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.mBaselineAlignedChildIndex) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.mBaselineAlignedChildIndex);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i2 = this.mBaselineChildTop;
            if (this.mOrientation == 1 && (i = this.mGravity & 112) != 48) {
                if (i == 16) {
                    i2 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
                } else if (i == 80) {
                    i2 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                }
            }
            return i2 + ((LayoutParams) childAt.getLayoutParams()).topMargin + baseline;
        } else if (this.mBaselineAlignedChildIndex == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    /* access modifiers changed from: package-private */
    public int getChildrenSkipCount(View view, int i) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    /* access modifiers changed from: package-private */
    public int getLocationOffset(View view) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getNextLocationOffset(View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    /* access modifiers changed from: package-private */
    public View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    /* access modifiers changed from: package-private */
    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            return (this.mShowDividers & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.mShowDividers & 4) != 0;
        }
        if ((this.mShowDividers & 2) != 0) {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void layoutHorizontal(int r28, int r29, int r30, int r31) {
        /*
            r27 = this;
            r6 = r27
            boolean r2 = android.support.v7.widget.ViewUtils.isLayoutRtl(r27)
            int r7 = r27.getPaddingTop()
            int r3 = r31 - r29
            int r4 = r27.getPaddingBottom()
            int r8 = r3 - r4
            int r3 = r3 - r7
            int r4 = r27.getPaddingBottom()
            int r9 = r3 - r4
            int r10 = r27.getVirtualChildCount()
            int r3 = r6.mGravity
            r4 = 8388615(0x800007, float:1.1754953E-38)
            r3 = r3 & r4
            int r4 = r6.mGravity
            r11 = r4 & 112(0x70, float:1.57E-43)
            boolean r12 = r6.mBaselineAligned
            int[] r13 = r6.mMaxAscent
            int[] r14 = r6.mMaxDescent
            int r4 = android.support.v4.view.ViewCompat.getLayoutDirection(r27)
            int r3 = android.support.v4.view.GravityCompat.getAbsoluteGravity(r3, r4)
            r15 = 2
            r5 = 1
            if (r3 == r5) goto L_0x004e
            r4 = 5
            if (r3 == r4) goto L_0x0041
            int r0 = r27.getPaddingLeft()
            goto L_0x0059
        L_0x0041:
            int r3 = r27.getPaddingLeft()
            int r3 = r3 + r30
            int r3 = r3 - r28
            int r0 = r6.mTotalLength
            int r0 = r3 - r0
            goto L_0x0059
        L_0x004e:
            int r3 = r27.getPaddingLeft()
            int r0 = r30 - r28
            int r1 = r6.mTotalLength
            int r0 = r0 - r1
            int r0 = r0 / r15
            int r0 = r0 + r3
        L_0x0059:
            r1 = 0
            if (r2 == 0) goto L_0x0063
            int r2 = r10 + -1
            r17 = r2
            r16 = -1
            goto L_0x0067
        L_0x0063:
            r16 = 1
            r17 = 0
        L_0x0067:
            r3 = 0
        L_0x0068:
            if (r3 >= r10) goto L_0x014a
            int r1 = r16 * r3
            int r2 = r17 + r1
            android.view.View r1 = r6.getVirtualChildAt(r2)
            if (r1 != 0) goto L_0x0085
            int r1 = r6.measureNullChild(r2)
            int r0 = r0 + r1
        L_0x0079:
            r26 = r7
            r23 = r10
            r24 = r11
            r18 = 1
            r20 = -1
            goto L_0x013e
        L_0x0085:
            int r5 = r1.getVisibility()
            r15 = 8
            if (r5 == r15) goto L_0x013a
            int r15 = r1.getMeasuredWidth()
            int r5 = r1.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r20 = r1.getLayoutParams()
            r4 = r20
            android.support.v7.widget.LinearLayoutCompat$LayoutParams r4 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r4
            if (r12 == 0) goto L_0x00ad
            r22 = r3
            int r3 = r4.height
            r23 = r10
            r10 = -1
            if (r3 == r10) goto L_0x00b1
            int r3 = r1.getBaseline()
            goto L_0x00b2
        L_0x00ad:
            r22 = r3
            r23 = r10
        L_0x00b1:
            r3 = -1
        L_0x00b2:
            int r10 = r4.gravity
            if (r10 >= 0) goto L_0x00b7
            r10 = r11
        L_0x00b7:
            r10 = r10 & 112(0x70, float:1.57E-43)
            r24 = r11
            r11 = 16
            if (r10 == r11) goto L_0x00f6
            r11 = 48
            if (r10 == r11) goto L_0x00e3
            r11 = 80
            if (r10 == r11) goto L_0x00cc
            r3 = r7
            r11 = -1
        L_0x00c9:
            r18 = 1
            goto L_0x0104
        L_0x00cc:
            int r10 = r8 - r5
            int r11 = r4.bottomMargin
            int r10 = r10 - r11
            r11 = -1
            if (r3 == r11) goto L_0x00e1
            int r20 = r1.getMeasuredHeight()
            int r20 = r20 - r3
            r3 = 2
            r21 = r14[r3]
            int r21 = r21 - r20
            int r10 = r10 - r21
        L_0x00e1:
            r3 = r10
            goto L_0x00c9
        L_0x00e3:
            r11 = -1
            int r10 = r4.topMargin
            int r10 = r10 + r7
            if (r3 == r11) goto L_0x00f2
            r18 = 1
            r20 = r13[r18]
            int r20 = r20 - r3
            int r10 = r10 + r20
            goto L_0x00f4
        L_0x00f2:
            r18 = 1
        L_0x00f4:
            r3 = r10
            goto L_0x0104
        L_0x00f6:
            r11 = -1
            r18 = 1
            int r3 = r9 - r5
            r10 = 2
            int r3 = r3 / r10
            int r3 = r3 + r7
            int r10 = r4.topMargin
            int r3 = r3 + r10
            int r10 = r4.bottomMargin
            int r3 = r3 - r10
        L_0x0104:
            boolean r10 = r6.hasDividerBeforeChildAt(r2)
            if (r10 == 0) goto L_0x010d
            int r10 = r6.mDividerWidth
            int r0 = r0 + r10
        L_0x010d:
            int r10 = r4.leftMargin
            int r10 = r10 + r0
            int r0 = r6.getLocationOffset(r1)
            int r19 = r10 + r0
            r0 = r6
            r25 = r1
            r11 = r2
            r2 = r19
            r19 = r22
            r26 = r7
            r20 = -1
            r7 = r4
            r4 = r15
            r0.setChildFrame(r1, r2, r3, r4, r5)
            int r0 = r7.rightMargin
            int r15 = r15 + r0
            r0 = r25
            int r1 = r6.getNextLocationOffset(r0)
            int r15 = r15 + r1
            int r10 = r10 + r15
            int r0 = r6.getChildrenSkipCount(r0, r11)
            int r3 = r19 + r0
            r0 = r10
            goto L_0x013e
        L_0x013a:
            r19 = r3
            goto L_0x0079
        L_0x013e:
            int r3 = r3 + 1
            r10 = r23
            r11 = r24
            r7 = r26
            r5 = 1
            r15 = 2
            goto L_0x0068
        L_0x014a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutCompat.layoutHorizontal(int, int, int, int):void");
    }

    /* access modifiers changed from: package-private */
    public void layoutVertical(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int paddingLeft = getPaddingLeft();
        int i7 = i3 - i;
        int paddingRight = i7 - getPaddingRight();
        int paddingRight2 = (i7 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i8 = this.mGravity & 112;
        int i9 = this.mGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int paddingTop = i8 != 16 ? i8 != 80 ? getPaddingTop() : ((getPaddingTop() + i4) - i2) - this.mTotalLength : (((i4 - i2) - this.mTotalLength) / 2) + getPaddingTop();
        int i10 = 0;
        while (i10 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i10);
            if (virtualChildAt == null) {
                paddingTop += measureNullChild(i10);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                int i11 = layoutParams.gravity;
                if (i11 < 0) {
                    i11 = i9;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i11, ViewCompat.getLayoutDirection(this)) & 7;
                if (absoluteGravity == 1) {
                    i5 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + layoutParams.leftMargin;
                    i6 = i5 - layoutParams.rightMargin;
                } else if (absoluteGravity != 5) {
                    i6 = layoutParams.leftMargin + paddingLeft;
                } else {
                    i5 = paddingRight - measuredWidth;
                    i6 = i5 - layoutParams.rightMargin;
                }
                int i12 = i6;
                if (hasDividerBeforeChildAt(i10)) {
                    paddingTop += this.mDividerHeight;
                }
                int i13 = paddingTop + layoutParams.topMargin;
                setChildFrame(virtualChildAt, i12, i13 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                i10 += getChildrenSkipCount(virtualChildAt, i10);
                paddingTop = i13 + measuredHeight + layoutParams.bottomMargin + getNextLocationOffset(virtualChildAt);
            }
            i10++;
        }
    }

    /* access modifiers changed from: package-private */
    public void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0445  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0448  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void measureHorizontal(int r43, int r44) {
        /*
            r42 = this;
            r7 = r42
            r8 = r43
            r9 = r44
            r10 = 0
            r7.mTotalLength = r10
            int r11 = r42.getVirtualChildCount()
            int r12 = android.view.View.MeasureSpec.getMode(r43)
            int r13 = android.view.View.MeasureSpec.getMode(r44)
            int[] r0 = r7.mMaxAscent
            r14 = 4
            if (r0 == 0) goto L_0x001e
            int[] r0 = r7.mMaxDescent
            if (r0 != 0) goto L_0x0026
        L_0x001e:
            int[] r0 = new int[r14]
            r7.mMaxAscent = r0
            int[] r0 = new int[r14]
            r7.mMaxDescent = r0
        L_0x0026:
            int[] r15 = r7.mMaxAscent
            int[] r6 = r7.mMaxDescent
            r16 = 3
            r5 = -1
            r15[r16] = r5
            r17 = 2
            r15[r17] = r5
            r18 = 1
            r15[r18] = r5
            r15[r10] = r5
            r6[r16] = r5
            r6[r17] = r5
            r6[r18] = r5
            r6[r10] = r5
            boolean r4 = r7.mBaselineAligned
            boolean r3 = r7.mUseLargestChild
            r2 = 1073741824(0x40000000, float:2.0)
            if (r12 != r2) goto L_0x004c
            r19 = 1
            goto L_0x004e
        L_0x004c:
            r19 = 0
        L_0x004e:
            r20 = 0
            r0 = 0
            r1 = 0
            r14 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 1
            r27 = 0
        L_0x0061:
            r28 = r6
            r5 = 8
            if (r1 >= r11) goto L_0x020a
            android.view.View r6 = r7.getVirtualChildAt(r1)
            if (r6 != 0) goto L_0x0081
            int r5 = r7.mTotalLength
            int r6 = r7.measureNullChild(r1)
            int r5 = r5 + r6
            r7.mTotalLength = r5
            r30 = r0
            r0 = r1
            r31 = r3
            r35 = r4
            r1 = 1073741824(0x40000000, float:2.0)
            goto L_0x01f5
        L_0x0081:
            int r10 = r6.getVisibility()
            if (r10 == r5) goto L_0x01db
            boolean r5 = r7.hasDividerBeforeChildAt(r1)
            if (r5 == 0) goto L_0x0094
            int r5 = r7.mTotalLength
            int r10 = r7.mDividerWidth
            int r5 = r5 + r10
            r7.mTotalLength = r5
        L_0x0094:
            android.view.ViewGroup$LayoutParams r5 = r6.getLayoutParams()
            r10 = r5
            android.support.v7.widget.LinearLayoutCompat$LayoutParams r10 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r10
            float r5 = r10.weight
            float r30 = r0 + r5
            if (r12 != r2) goto L_0x00e9
            int r0 = r10.width
            if (r0 != 0) goto L_0x00e9
            float r0 = r10.weight
            int r0 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r0 <= 0) goto L_0x00e9
            if (r19 == 0) goto L_0x00b8
            int r0 = r7.mTotalLength
            int r5 = r10.leftMargin
            int r2 = r10.rightMargin
            int r5 = r5 + r2
            int r0 = r0 + r5
        L_0x00b5:
            r7.mTotalLength = r0
            goto L_0x00c5
        L_0x00b8:
            int r0 = r7.mTotalLength
            int r2 = r10.leftMargin
            int r2 = r2 + r0
            int r5 = r10.rightMargin
            int r2 = r2 + r5
            int r0 = java.lang.Math.max(r0, r2)
            goto L_0x00b5
        L_0x00c5:
            if (r4 == 0) goto L_0x00da
            r0 = 0
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r0)
            r6.measure(r2, r2)
            r33 = r1
            r31 = r3
            r35 = r4
            r8 = r6
            r29 = -2
            goto L_0x015b
        L_0x00da:
            r33 = r1
            r31 = r3
            r35 = r4
            r8 = r6
            r1 = 1073741824(0x40000000, float:2.0)
            r22 = 1
            r29 = -2
            goto L_0x015d
        L_0x00e9:
            int r0 = r10.width
            if (r0 != 0) goto L_0x00f8
            float r0 = r10.weight
            int r0 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r0 <= 0) goto L_0x00f8
            r5 = -2
            r10.width = r5
            r2 = 0
            goto L_0x00fb
        L_0x00f8:
            r5 = -2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00fb:
            int r0 = (r30 > r20 ? 1 : (r30 == r20 ? 0 : -1))
            if (r0 != 0) goto L_0x0104
            int r0 = r7.mTotalLength
            r29 = r0
            goto L_0x0106
        L_0x0104:
            r29 = 0
        L_0x0106:
            r32 = 0
            r0 = r7
            r33 = r1
            r1 = r6
            r34 = r2
            r2 = r33
            r31 = r3
            r3 = r8
            r35 = r4
            r4 = r29
            r8 = -1
            r29 = -2
            r5 = r9
            r8 = r6
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r32
            r0.measureChildBeforeLayout(r1, r2, r3, r4, r5, r6)
            r0 = r34
            if (r0 == r9) goto L_0x0129
            r10.width = r0
        L_0x0129:
            int r0 = r8.getMeasuredWidth()
            if (r19 == 0) goto L_0x0140
            int r1 = r7.mTotalLength
            int r2 = r10.leftMargin
            int r2 = r2 + r0
            int r3 = r10.rightMargin
            int r2 = r2 + r3
            int r3 = r7.getNextLocationOffset(r8)
            int r2 = r2 + r3
            int r1 = r1 + r2
        L_0x013d:
            r7.mTotalLength = r1
            goto L_0x0154
        L_0x0140:
            int r1 = r7.mTotalLength
            int r2 = r1 + r0
            int r3 = r10.leftMargin
            int r2 = r2 + r3
            int r3 = r10.rightMargin
            int r2 = r2 + r3
            int r3 = r7.getNextLocationOffset(r8)
            int r2 = r2 + r3
            int r1 = java.lang.Math.max(r1, r2)
            goto L_0x013d
        L_0x0154:
            if (r31 == 0) goto L_0x015b
            int r0 = java.lang.Math.max(r0, r14)
            r14 = r0
        L_0x015b:
            r1 = 1073741824(0x40000000, float:2.0)
        L_0x015d:
            if (r13 == r1) goto L_0x0168
            int r0 = r10.height
            r2 = -1
            if (r0 != r2) goto L_0x0168
            r0 = 1
            r27 = 1
            goto L_0x0169
        L_0x0168:
            r0 = 0
        L_0x0169:
            int r2 = r10.topMargin
            int r3 = r10.bottomMargin
            int r2 = r2 + r3
            int r3 = r8.getMeasuredHeight()
            int r3 = r3 + r2
            int r4 = r8.getMeasuredState()
            r6 = r25
            int r25 = android.view.View.combineMeasuredStates(r6, r4)
            if (r35 == 0) goto L_0x01a9
            int r4 = r8.getBaseline()
            r5 = -1
            if (r4 == r5) goto L_0x01a9
            int r5 = r10.gravity
            if (r5 >= 0) goto L_0x018d
            int r5 = r7.mGravity
            goto L_0x018f
        L_0x018d:
            int r5 = r10.gravity
        L_0x018f:
            r5 = r5 & 112(0x70, float:1.57E-43)
            r6 = 4
            int r5 = r5 >> r6
            r5 = r5 & -2
            int r5 = r5 >> 1
            r6 = r15[r5]
            int r6 = java.lang.Math.max(r6, r4)
            r15[r5] = r6
            r6 = r28[r5]
            int r4 = r3 - r4
            int r4 = java.lang.Math.max(r6, r4)
            r28[r5] = r4
        L_0x01a9:
            r4 = r21
            int r21 = java.lang.Math.max(r4, r3)
            if (r26 == 0) goto L_0x01b9
            int r4 = r10.height
            r5 = -1
            if (r4 != r5) goto L_0x01b9
            r26 = 1
            goto L_0x01bb
        L_0x01b9:
            r26 = 0
        L_0x01bb:
            float r4 = r10.weight
            int r4 = (r4 > r20 ? 1 : (r4 == r20 ? 0 : -1))
            if (r4 <= 0) goto L_0x01cd
            if (r0 == 0) goto L_0x01c6
        L_0x01c3:
            r10 = r24
            goto L_0x01c8
        L_0x01c6:
            r2 = r3
            goto L_0x01c3
        L_0x01c8:
            int r24 = java.lang.Math.max(r10, r2)
            goto L_0x01ee
        L_0x01cd:
            r10 = r24
            if (r0 == 0) goto L_0x01d2
            r3 = r2
        L_0x01d2:
            r2 = r23
            int r23 = java.lang.Math.max(r2, r3)
            r24 = r10
            goto L_0x01ee
        L_0x01db:
            r33 = r1
            r31 = r3
            r35 = r4
            r8 = r6
            r4 = r21
            r2 = r23
            r10 = r24
            r6 = r25
            r1 = 1073741824(0x40000000, float:2.0)
            r30 = r0
        L_0x01ee:
            r10 = r33
            int r0 = r7.getChildrenSkipCount(r8, r10)
            int r0 = r0 + r10
        L_0x01f5:
            int r0 = r0 + 1
            r1 = r0
            r6 = r28
            r0 = r30
            r3 = r31
            r4 = r35
            r2 = 1073741824(0x40000000, float:2.0)
            r5 = -1
            r8 = r43
            r9 = r44
            r10 = 0
            goto L_0x0061
        L_0x020a:
            r31 = r3
            r35 = r4
            r4 = r21
            r2 = r23
            r10 = r24
            r6 = r25
            r1 = 1073741824(0x40000000, float:2.0)
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r29 = -2
            int r3 = r7.mTotalLength
            if (r3 <= 0) goto L_0x022d
            boolean r3 = r7.hasDividerBeforeChildAt(r11)
            if (r3 == 0) goto L_0x022d
            int r3 = r7.mTotalLength
            int r8 = r7.mDividerWidth
            int r3 = r3 + r8
            r7.mTotalLength = r3
        L_0x022d:
            r3 = r15[r18]
            r8 = -1
            if (r3 != r8) goto L_0x023f
            r3 = 0
            r1 = r15[r3]
            if (r1 != r8) goto L_0x023f
            r1 = r15[r17]
            if (r1 != r8) goto L_0x023f
            r1 = r15[r16]
            if (r1 == r8) goto L_0x026f
        L_0x023f:
            r1 = r15[r16]
            r3 = 0
            r8 = r15[r3]
            r5 = r15[r18]
            r9 = r15[r17]
            int r5 = java.lang.Math.max(r5, r9)
            int r5 = java.lang.Math.max(r8, r5)
            int r1 = java.lang.Math.max(r1, r5)
            r5 = r28[r16]
            r8 = r28[r3]
            r3 = r28[r18]
            r9 = r28[r17]
            int r3 = java.lang.Math.max(r3, r9)
            int r3 = java.lang.Math.max(r8, r3)
            int r3 = java.lang.Math.max(r5, r3)
            int r1 = r1 + r3
            int r21 = java.lang.Math.max(r4, r1)
            r4 = r21
        L_0x026f:
            if (r31 == 0) goto L_0x02d0
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r12 == r1) goto L_0x0277
            if (r12 != 0) goto L_0x02d0
        L_0x0277:
            r1 = 0
            r7.mTotalLength = r1
            r1 = 0
        L_0x027b:
            if (r1 >= r11) goto L_0x02d0
            android.view.View r3 = r7.getVirtualChildAt(r1)
            if (r3 != 0) goto L_0x028d
            int r3 = r7.mTotalLength
            int r5 = r7.measureNullChild(r1)
            int r3 = r3 + r5
            r7.mTotalLength = r3
            goto L_0x029a
        L_0x028d:
            int r5 = r3.getVisibility()
            r8 = 8
            if (r5 != r8) goto L_0x029d
            int r3 = r7.getChildrenSkipCount(r3, r1)
            int r1 = r1 + r3
        L_0x029a:
            r36 = r1
            goto L_0x02cd
        L_0x029d:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            android.support.v7.widget.LinearLayoutCompat$LayoutParams r5 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r5
            if (r19 == 0) goto L_0x02b6
            int r8 = r7.mTotalLength
            int r9 = r5.leftMargin
            int r9 = r9 + r14
            int r5 = r5.rightMargin
            int r9 = r9 + r5
            int r3 = r7.getNextLocationOffset(r3)
            int r9 = r9 + r3
            int r8 = r8 + r9
            r7.mTotalLength = r8
            goto L_0x029a
        L_0x02b6:
            int r8 = r7.mTotalLength
            int r9 = r8 + r14
            r36 = r1
            int r1 = r5.leftMargin
            int r9 = r9 + r1
            int r1 = r5.rightMargin
            int r9 = r9 + r1
            int r1 = r7.getNextLocationOffset(r3)
            int r9 = r9 + r1
            int r1 = java.lang.Math.max(r8, r9)
            r7.mTotalLength = r1
        L_0x02cd:
            int r1 = r36 + 1
            goto L_0x027b
        L_0x02d0:
            int r1 = r7.mTotalLength
            int r3 = r42.getPaddingLeft()
            int r5 = r42.getPaddingRight()
            int r3 = r3 + r5
            int r1 = r1 + r3
            r7.mTotalLength = r1
            int r1 = r7.mTotalLength
            int r3 = r42.getSuggestedMinimumWidth()
            int r1 = java.lang.Math.max(r1, r3)
            r3 = r43
            r5 = 0
            r8 = -1
            int r1 = android.view.View.resolveSizeAndState(r1, r3, r5)
            r5 = 16777215(0xffffff, float:2.3509886E-38)
            r5 = r5 & r1
            int r9 = r7.mTotalLength
            int r5 = r5 - r9
            if (r22 != 0) goto L_0x033f
            if (r5 == 0) goto L_0x0300
            int r21 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r21 <= 0) goto L_0x0300
            goto L_0x033f
        L_0x0300:
            int r0 = java.lang.Math.max(r2, r10)
            if (r31 == 0) goto L_0x033b
            r2 = 1073741824(0x40000000, float:2.0)
            if (r12 == r2) goto L_0x033b
            r2 = 0
        L_0x030b:
            if (r2 >= r11) goto L_0x033b
            android.view.View r5 = r7.getVirtualChildAt(r2)
            if (r5 == 0) goto L_0x0338
            int r8 = r5.getVisibility()
            r10 = 8
            if (r8 == r10) goto L_0x0338
            android.view.ViewGroup$LayoutParams r8 = r5.getLayoutParams()
            android.support.v7.widget.LinearLayoutCompat$LayoutParams r8 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r8
            float r8 = r8.weight
            int r8 = (r8 > r20 ? 1 : (r8 == r20 ? 0 : -1))
            if (r8 <= 0) goto L_0x0338
            r8 = 1073741824(0x40000000, float:2.0)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r8)
            int r12 = r5.getMeasuredHeight()
            int r12 = android.view.View.MeasureSpec.makeMeasureSpec(r12, r8)
            r5.measure(r10, r12)
        L_0x0338:
            int r2 = r2 + 1
            goto L_0x030b
        L_0x033b:
            r5 = r44
            goto L_0x04ce
        L_0x033f:
            float r4 = r7.mWeightSum
            int r4 = (r4 > r20 ? 1 : (r4 == r20 ? 0 : -1))
            if (r4 <= 0) goto L_0x0347
            float r0 = r7.mWeightSum
        L_0x0347:
            r15[r16] = r8
            r15[r17] = r8
            r15[r18] = r8
            r4 = 0
            r15[r4] = r8
            r28[r16] = r8
            r28[r17] = r8
            r28[r18] = r8
            r28[r4] = r8
            r7.mTotalLength = r4
            r4 = r2
            r10 = -1
            r2 = r0
            r0 = 0
        L_0x035e:
            if (r0 >= r11) goto L_0x0476
            android.view.View r14 = r7.getVirtualChildAt(r0)
            if (r14 == 0) goto L_0x046b
            int r8 = r14.getVisibility()
            r9 = 8
            if (r8 == r9) goto L_0x046b
            android.view.ViewGroup$LayoutParams r8 = r14.getLayoutParams()
            android.support.v7.widget.LinearLayoutCompat$LayoutParams r8 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r8
            float r9 = r8.weight
            int r21 = (r9 > r20 ? 1 : (r9 == r20 ? 0 : -1))
            if (r21 <= 0) goto L_0x03cd
            float r3 = (float) r5
            float r3 = r3 * r9
            float r3 = r3 / r2
            int r3 = (int) r3
            float r2 = r2 - r9
            int r5 = r5 - r3
            int r9 = r42.getPaddingTop()
            int r21 = r42.getPaddingBottom()
            int r9 = r9 + r21
            r37 = r2
            int r2 = r8.topMargin
            int r9 = r9 + r2
            int r2 = r8.bottomMargin
            int r9 = r9 + r2
            int r2 = r8.height
            r38 = r5
            r5 = r44
            int r2 = getChildMeasureSpec(r5, r9, r2)
            int r9 = r8.width
            if (r9 != 0) goto L_0x03ab
            r9 = 1073741824(0x40000000, float:2.0)
            if (r12 == r9) goto L_0x03a6
            goto L_0x03ab
        L_0x03a6:
            if (r3 <= 0) goto L_0x03a9
            goto L_0x03b4
        L_0x03a9:
            r3 = 0
            goto L_0x03b4
        L_0x03ab:
            int r9 = r14.getMeasuredWidth()
            int r9 = r9 + r3
            if (r9 >= 0) goto L_0x03b3
            r9 = 0
        L_0x03b3:
            r3 = r9
        L_0x03b4:
            r9 = 1073741824(0x40000000, float:2.0)
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r9)
            r14.measure(r3, r2)
            int r2 = r14.getMeasuredState()
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r2 = r2 & r3
            int r6 = android.view.View.combineMeasuredStates(r6, r2)
            r2 = r37
            r3 = r38
            goto L_0x03d0
        L_0x03cd:
            r3 = r5
            r5 = r44
        L_0x03d0:
            if (r19 == 0) goto L_0x03f1
            int r9 = r7.mTotalLength
            int r21 = r14.getMeasuredWidth()
            r39 = r2
            int r2 = r8.leftMargin
            int r21 = r21 + r2
            int r2 = r8.rightMargin
            int r21 = r21 + r2
            int r2 = r7.getNextLocationOffset(r14)
            int r21 = r21 + r2
            int r9 = r9 + r21
            r7.mTotalLength = r9
            r40 = r3
        L_0x03ee:
            r2 = 1073741824(0x40000000, float:2.0)
            goto L_0x040e
        L_0x03f1:
            r39 = r2
            int r2 = r7.mTotalLength
            int r9 = r14.getMeasuredWidth()
            int r9 = r9 + r2
            r40 = r3
            int r3 = r8.leftMargin
            int r9 = r9 + r3
            int r3 = r8.rightMargin
            int r9 = r9 + r3
            int r3 = r7.getNextLocationOffset(r14)
            int r9 = r9 + r3
            int r2 = java.lang.Math.max(r2, r9)
            r7.mTotalLength = r2
            goto L_0x03ee
        L_0x040e:
            if (r13 == r2) goto L_0x0417
            int r2 = r8.height
            r3 = -1
            if (r2 != r3) goto L_0x0417
            r2 = 1
            goto L_0x0418
        L_0x0417:
            r2 = 0
        L_0x0418:
            int r3 = r8.topMargin
            int r9 = r8.bottomMargin
            int r3 = r3 + r9
            int r9 = r14.getMeasuredHeight()
            int r9 = r9 + r3
            int r10 = java.lang.Math.max(r10, r9)
            if (r2 == 0) goto L_0x0429
            goto L_0x042a
        L_0x0429:
            r3 = r9
        L_0x042a:
            int r2 = java.lang.Math.max(r4, r3)
            if (r26 == 0) goto L_0x0437
            int r3 = r8.height
            r4 = -1
            if (r3 != r4) goto L_0x0438
            r3 = 1
            goto L_0x0439
        L_0x0437:
            r4 = -1
        L_0x0438:
            r3 = 0
        L_0x0439:
            if (r35 == 0) goto L_0x0463
            int r14 = r14.getBaseline()
            if (r14 == r4) goto L_0x0463
            int r4 = r8.gravity
            if (r4 >= 0) goto L_0x0448
            int r4 = r7.mGravity
            goto L_0x044a
        L_0x0448:
            int r4 = r8.gravity
        L_0x044a:
            r4 = r4 & 112(0x70, float:1.57E-43)
            r8 = 4
            int r4 = r4 >> r8
            r4 = r4 & -2
            int r4 = r4 >> 1
            r8 = r15[r4]
            int r8 = java.lang.Math.max(r8, r14)
            r15[r4] = r8
            r8 = r28[r4]
            int r9 = r9 - r14
            int r8 = java.lang.Math.max(r8, r9)
            r28[r4] = r8
        L_0x0463:
            r4 = r2
            r26 = r3
            r2 = r39
            r3 = r40
            goto L_0x046e
        L_0x046b:
            r3 = r5
            r5 = r44
        L_0x046e:
            int r0 = r0 + 1
            r5 = r3
            r3 = r43
            r8 = -1
            goto L_0x035e
        L_0x0476:
            r5 = r44
            int r0 = r7.mTotalLength
            int r2 = r42.getPaddingLeft()
            int r3 = r42.getPaddingRight()
            int r2 = r2 + r3
            int r0 = r0 + r2
            r7.mTotalLength = r0
            r0 = r15[r18]
            r2 = -1
            if (r0 != r2) goto L_0x049b
            r0 = 0
            r3 = r15[r0]
            if (r3 != r2) goto L_0x049b
            r0 = r15[r17]
            if (r0 != r2) goto L_0x049b
            r0 = r15[r16]
            if (r0 == r2) goto L_0x0499
            goto L_0x049b
        L_0x0499:
            r0 = r10
            goto L_0x04c9
        L_0x049b:
            r0 = r15[r16]
            r2 = 0
            r3 = r15[r2]
            r8 = r15[r18]
            r9 = r15[r17]
            int r8 = java.lang.Math.max(r8, r9)
            int r3 = java.lang.Math.max(r3, r8)
            int r0 = java.lang.Math.max(r0, r3)
            r3 = r28[r16]
            r2 = r28[r2]
            r8 = r28[r18]
            r9 = r28[r17]
            int r8 = java.lang.Math.max(r8, r9)
            int r2 = java.lang.Math.max(r2, r8)
            int r2 = java.lang.Math.max(r3, r2)
            int r0 = r0 + r2
            int r0 = java.lang.Math.max(r10, r0)
        L_0x04c9:
            r41 = r4
            r4 = r0
            r0 = r41
        L_0x04ce:
            if (r26 != 0) goto L_0x04d5
            r2 = 1073741824(0x40000000, float:2.0)
            if (r13 == r2) goto L_0x04d5
            goto L_0x04d6
        L_0x04d5:
            r0 = r4
        L_0x04d6:
            int r2 = r42.getPaddingTop()
            int r3 = r42.getPaddingBottom()
            int r2 = r2 + r3
            int r0 = r0 + r2
            int r2 = r42.getSuggestedMinimumHeight()
            int r0 = java.lang.Math.max(r0, r2)
            r2 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r2 = r2 & r6
            r1 = r1 | r2
            int r2 = r6 << 16
            int r0 = android.view.View.resolveSizeAndState(r0, r5, r2)
            r7.setMeasuredDimension(r1, r0)
            if (r27 == 0) goto L_0x04fc
            r0 = r43
            r7.forceUniformHeight(r11, r0)
        L_0x04fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutCompat.measureHorizontal(int, int):void");
    }

    /* access modifiers changed from: package-private */
    public int measureNullChild(int i) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0327  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0332  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0334  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void measureVertical(int r41, int r42) {
        /*
            r40 = this;
            r7 = r40
            r8 = r41
            r9 = r42
            r10 = 0
            r7.mTotalLength = r10
            int r11 = r40.getVirtualChildCount()
            int r12 = android.view.View.MeasureSpec.getMode(r41)
            int r13 = android.view.View.MeasureSpec.getMode(r42)
            int r14 = r7.mBaselineAlignedChildIndex
            boolean r15 = r7.mUseLargestChild
            r16 = 0
            r17 = 1
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r18 = 0
            r19 = 0
            r20 = 1
        L_0x002a:
            r10 = 8
            r22 = r4
            if (r6 >= r11) goto L_0x019a
            android.view.View r4 = r7.getVirtualChildAt(r6)
            if (r4 != 0) goto L_0x0047
            int r4 = r7.mTotalLength
            int r10 = r7.measureNullChild(r6)
            int r4 = r4 + r10
            r7.mTotalLength = r4
            r31 = r11
            r28 = r13
            r4 = r22
            goto L_0x0190
        L_0x0047:
            r24 = r1
            int r1 = r4.getVisibility()
            if (r1 == r10) goto L_0x0173
            boolean r1 = r7.hasDividerBeforeChildAt(r6)
            if (r1 == 0) goto L_0x005c
            int r1 = r7.mTotalLength
            int r10 = r7.mDividerHeight
            int r1 = r1 + r10
            r7.mTotalLength = r1
        L_0x005c:
            android.view.ViewGroup$LayoutParams r1 = r4.getLayoutParams()
            r10 = r1
            android.support.v7.widget.LinearLayoutCompat$LayoutParams r10 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r10
            float r1 = r10.weight
            float r25 = r0 + r1
            r1 = 1073741824(0x40000000, float:2.0)
            if (r13 != r1) goto L_0x0097
            int r0 = r10.height
            if (r0 != 0) goto L_0x0097
            float r0 = r10.weight
            int r0 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x0097
            int r0 = r7.mTotalLength
            int r1 = r10.topMargin
            int r1 = r1 + r0
            r26 = r2
            int r2 = r10.bottomMargin
            int r1 = r1 + r2
            int r0 = java.lang.Math.max(r0, r1)
            r7.mTotalLength = r0
            r8 = r4
            r34 = r5
            r31 = r11
            r28 = r13
            r32 = r22
            r33 = r24
            r30 = r26
            r18 = 1
            r13 = r6
            goto L_0x0104
        L_0x0097:
            r26 = r2
            int r0 = r10.height
            if (r0 != 0) goto L_0x00a8
            float r0 = r10.weight
            int r0 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a8
            r0 = -2
            r10.height = r0
            r2 = 0
            goto L_0x00aa
        L_0x00a8:
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00aa:
            r23 = 0
            int r0 = (r25 > r16 ? 1 : (r25 == r16 ? 0 : -1))
            if (r0 != 0) goto L_0x00b5
            int r0 = r7.mTotalLength
            r27 = r0
            goto L_0x00b7
        L_0x00b5:
            r27 = 0
        L_0x00b7:
            r0 = r7
            r28 = r13
            r13 = r24
            r24 = 1073741824(0x40000000, float:2.0)
            r1 = r4
            r29 = r2
            r30 = r26
            r2 = r6
            r31 = r11
            r11 = r3
            r3 = r8
            r8 = r4
            r33 = r13
            r32 = r22
            r13 = 1073741824(0x40000000, float:2.0)
            r4 = r23
            r34 = r5
            r5 = r9
            r13 = r6
            r6 = r27
            r0.measureChildBeforeLayout(r1, r2, r3, r4, r5, r6)
            r0 = r29
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r1) goto L_0x00e2
            r10.height = r0
        L_0x00e2:
            int r0 = r8.getMeasuredHeight()
            int r1 = r7.mTotalLength
            int r2 = r1 + r0
            int r3 = r10.topMargin
            int r2 = r2 + r3
            int r3 = r10.bottomMargin
            int r2 = r2 + r3
            int r3 = r7.getNextLocationOffset(r8)
            int r2 = r2 + r3
            int r1 = java.lang.Math.max(r1, r2)
            r7.mTotalLength = r1
            if (r15 == 0) goto L_0x0103
            int r0 = java.lang.Math.max(r0, r11)
            r3 = r0
            goto L_0x0104
        L_0x0103:
            r3 = r11
        L_0x0104:
            if (r14 < 0) goto L_0x010e
            int r6 = r13 + 1
            if (r14 != r6) goto L_0x010e
            int r0 = r7.mTotalLength
            r7.mBaselineChildTop = r0
        L_0x010e:
            if (r13 >= r14) goto L_0x011e
            float r0 = r10.weight
            int r0 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x011e
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex."
            r0.<init>(r1)
            throw r0
        L_0x011e:
            r0 = 1073741824(0x40000000, float:2.0)
            if (r12 == r0) goto L_0x012b
            int r0 = r10.width
            r1 = -1
            if (r0 != r1) goto L_0x012b
            r0 = 1
            r19 = 1
            goto L_0x012c
        L_0x012b:
            r0 = 0
        L_0x012c:
            int r1 = r10.leftMargin
            int r2 = r10.rightMargin
            int r1 = r1 + r2
            int r2 = r8.getMeasuredWidth()
            int r2 = r2 + r1
            r4 = r30
            int r4 = java.lang.Math.max(r4, r2)
            int r5 = r8.getMeasuredState()
            r6 = r33
            int r5 = android.view.View.combineMeasuredStates(r6, r5)
            if (r20 == 0) goto L_0x0150
            int r6 = r10.width
            r11 = -1
            if (r6 != r11) goto L_0x0150
            r20 = 1
            goto L_0x0152
        L_0x0150:
            r20 = 0
        L_0x0152:
            float r6 = r10.weight
            int r6 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r6 <= 0) goto L_0x0167
            if (r0 == 0) goto L_0x015d
        L_0x015a:
            r10 = r32
            goto L_0x015f
        L_0x015d:
            r1 = r2
            goto L_0x015a
        L_0x015f:
            int r0 = java.lang.Math.max(r10, r1)
            r10 = r0
            r0 = r34
            goto L_0x0184
        L_0x0167:
            r10 = r32
            if (r0 == 0) goto L_0x016c
            r2 = r1
        L_0x016c:
            r1 = r34
            int r0 = java.lang.Math.max(r1, r2)
            goto L_0x0184
        L_0x0173:
            r8 = r4
            r1 = r5
            r31 = r11
            r28 = r13
            r10 = r22
            r4 = r2
            r11 = r3
            r13 = r6
            r6 = r24
            r25 = r0
            r0 = r1
            r5 = r6
        L_0x0184:
            int r1 = r7.getChildrenSkipCount(r8, r13)
            int r6 = r13 + r1
            r2 = r4
            r1 = r5
            r4 = r10
            r5 = r0
            r0 = r25
        L_0x0190:
            int r6 = r6 + 1
            r13 = r28
            r11 = r31
            r8 = r41
            goto L_0x002a
        L_0x019a:
            r6 = r1
            r4 = r2
            r1 = r5
            r31 = r11
            r28 = r13
            r2 = r22
            r11 = r3
            int r3 = r7.mTotalLength
            if (r3 <= 0) goto L_0x01b8
            r3 = r31
            boolean r5 = r7.hasDividerBeforeChildAt(r3)
            if (r5 == 0) goto L_0x01ba
            int r5 = r7.mTotalLength
            int r8 = r7.mDividerHeight
            int r5 = r5 + r8
            r7.mTotalLength = r5
            goto L_0x01ba
        L_0x01b8:
            r3 = r31
        L_0x01ba:
            if (r15 == 0) goto L_0x0213
            r5 = r28
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r8) goto L_0x01c8
            if (r5 != 0) goto L_0x01c5
            goto L_0x01c8
        L_0x01c5:
            r35 = r4
            goto L_0x0217
        L_0x01c8:
            r8 = 0
            r7.mTotalLength = r8
            r8 = 0
        L_0x01cc:
            if (r8 >= r3) goto L_0x01c5
            android.view.View r13 = r7.getVirtualChildAt(r8)
            if (r13 != 0) goto L_0x01de
            int r13 = r7.mTotalLength
            int r14 = r7.measureNullChild(r8)
            int r13 = r13 + r14
            r7.mTotalLength = r13
            goto L_0x01e9
        L_0x01de:
            int r14 = r13.getVisibility()
            if (r14 != r10) goto L_0x01ec
            int r13 = r7.getChildrenSkipCount(r13, r8)
            int r8 = r8 + r13
        L_0x01e9:
            r35 = r4
            goto L_0x020c
        L_0x01ec:
            android.view.ViewGroup$LayoutParams r14 = r13.getLayoutParams()
            android.support.v7.widget.LinearLayoutCompat$LayoutParams r14 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r14
            int r10 = r7.mTotalLength
            int r21 = r10 + r11
            r35 = r4
            int r4 = r14.topMargin
            int r21 = r21 + r4
            int r4 = r14.bottomMargin
            int r21 = r21 + r4
            int r4 = r7.getNextLocationOffset(r13)
            int r4 = r21 + r4
            int r4 = java.lang.Math.max(r10, r4)
            r7.mTotalLength = r4
        L_0x020c:
            int r8 = r8 + 1
            r4 = r35
            r10 = 8
            goto L_0x01cc
        L_0x0213:
            r35 = r4
            r5 = r28
        L_0x0217:
            int r4 = r7.mTotalLength
            int r8 = r40.getPaddingTop()
            int r10 = r40.getPaddingBottom()
            int r8 = r8 + r10
            int r4 = r4 + r8
            r7.mTotalLength = r4
            int r4 = r7.mTotalLength
            int r8 = r40.getSuggestedMinimumHeight()
            int r4 = java.lang.Math.max(r4, r8)
            r8 = 0
            int r4 = android.view.View.resolveSizeAndState(r4, r9, r8)
            r8 = 16777215(0xffffff, float:2.3509886E-38)
            r8 = r8 & r4
            int r10 = r7.mTotalLength
            int r8 = r8 - r10
            if (r18 != 0) goto L_0x0283
            if (r8 == 0) goto L_0x0244
            int r10 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r10 <= 0) goto L_0x0244
            goto L_0x0283
        L_0x0244:
            int r0 = java.lang.Math.max(r1, r2)
            if (r15 == 0) goto L_0x027f
            r1 = 1073741824(0x40000000, float:2.0)
            if (r5 == r1) goto L_0x027f
            r1 = 0
        L_0x024f:
            if (r1 >= r3) goto L_0x027f
            android.view.View r2 = r7.getVirtualChildAt(r1)
            if (r2 == 0) goto L_0x027c
            int r5 = r2.getVisibility()
            r8 = 8
            if (r5 == r8) goto L_0x027c
            android.view.ViewGroup$LayoutParams r5 = r2.getLayoutParams()
            android.support.v7.widget.LinearLayoutCompat$LayoutParams r5 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r5
            float r5 = r5.weight
            int r5 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            if (r5 <= 0) goto L_0x027c
            int r5 = r2.getMeasuredWidth()
            r8 = 1073741824(0x40000000, float:2.0)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r8)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r8)
            r2.measure(r5, r10)
        L_0x027c:
            int r1 = r1 + 1
            goto L_0x024f
        L_0x027f:
            r11 = r41
            goto L_0x0376
        L_0x0283:
            float r2 = r7.mWeightSum
            int r2 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r2 <= 0) goto L_0x028b
            float r0 = r7.mWeightSum
        L_0x028b:
            r2 = 0
            r7.mTotalLength = r2
            r11 = r0
            r10 = r8
            r0 = 0
            r8 = r1
            r1 = r35
        L_0x0294:
            if (r0 >= r3) goto L_0x0363
            android.view.View r13 = r7.getVirtualChildAt(r0)
            int r14 = r13.getVisibility()
            r15 = 8
            if (r14 == r15) goto L_0x0355
            android.view.ViewGroup$LayoutParams r14 = r13.getLayoutParams()
            android.support.v7.widget.LinearLayoutCompat$LayoutParams r14 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r14
            float r2 = r14.weight
            int r18 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r18 <= 0) goto L_0x02fe
            float r15 = (float) r10
            float r15 = r15 * r2
            float r15 = r15 / r11
            int r15 = (int) r15
            float r11 = r11 - r2
            int r10 = r10 - r15
            int r2 = r40.getPaddingLeft()
            int r18 = r40.getPaddingRight()
            int r2 = r2 + r18
            r36 = r10
            int r10 = r14.leftMargin
            int r2 = r2 + r10
            int r10 = r14.rightMargin
            int r2 = r2 + r10
            int r10 = r14.width
            r37 = r11
            r11 = r41
            int r2 = getChildMeasureSpec(r11, r2, r10)
            int r10 = r14.height
            if (r10 != 0) goto L_0x02e1
            r10 = 1073741824(0x40000000, float:2.0)
            if (r5 == r10) goto L_0x02da
            goto L_0x02e1
        L_0x02da:
            if (r15 <= 0) goto L_0x02dd
            goto L_0x02ea
        L_0x02dd:
            r10 = 1073741824(0x40000000, float:2.0)
            r15 = 0
            goto L_0x02ec
        L_0x02e1:
            int r10 = r13.getMeasuredHeight()
            int r10 = r10 + r15
            if (r10 >= 0) goto L_0x02e9
            r10 = 0
        L_0x02e9:
            r15 = r10
        L_0x02ea:
            r10 = 1073741824(0x40000000, float:2.0)
        L_0x02ec:
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r10)
            r13.measure(r2, r15)
            int r2 = r13.getMeasuredState()
            r2 = r2 & -256(0xffffffffffffff00, float:NaN)
            int r6 = android.view.View.combineMeasuredStates(r6, r2)
            goto L_0x0305
        L_0x02fe:
            r2 = r11
            r11 = r41
            r37 = r2
            r36 = r10
        L_0x0305:
            int r2 = r14.leftMargin
            int r10 = r14.rightMargin
            int r2 = r2 + r10
            int r10 = r13.getMeasuredWidth()
            int r10 = r10 + r2
            int r1 = java.lang.Math.max(r1, r10)
            r15 = 1073741824(0x40000000, float:2.0)
            if (r12 == r15) goto L_0x0320
            int r15 = r14.width
            r38 = r1
            r1 = -1
            if (r15 != r1) goto L_0x0323
            r15 = 1
            goto L_0x0324
        L_0x0320:
            r38 = r1
            r1 = -1
        L_0x0323:
            r15 = 0
        L_0x0324:
            if (r15 == 0) goto L_0x0327
            goto L_0x0328
        L_0x0327:
            r2 = r10
        L_0x0328:
            int r2 = java.lang.Math.max(r8, r2)
            if (r20 == 0) goto L_0x0334
            int r8 = r14.width
            if (r8 != r1) goto L_0x0334
            r8 = 1
            goto L_0x0335
        L_0x0334:
            r8 = 0
        L_0x0335:
            int r10 = r7.mTotalLength
            int r15 = r13.getMeasuredHeight()
            int r15 = r15 + r10
            int r1 = r14.topMargin
            int r15 = r15 + r1
            int r1 = r14.bottomMargin
            int r15 = r15 + r1
            int r1 = r7.getNextLocationOffset(r13)
            int r15 = r15 + r1
            int r1 = java.lang.Math.max(r10, r15)
            r7.mTotalLength = r1
            r20 = r8
            r10 = r36
            r1 = r38
            r8 = r2
            goto L_0x035c
        L_0x0355:
            r35 = r1
            r2 = r11
            r11 = r41
            r37 = r2
        L_0x035c:
            int r0 = r0 + 1
            r11 = r37
            r2 = 0
            goto L_0x0294
        L_0x0363:
            r35 = r1
            r11 = r41
            int r0 = r7.mTotalLength
            int r1 = r40.getPaddingTop()
            int r2 = r40.getPaddingBottom()
            int r1 = r1 + r2
            int r0 = r0 + r1
            r7.mTotalLength = r0
            r0 = r8
        L_0x0376:
            if (r20 != 0) goto L_0x037d
            r1 = 1073741824(0x40000000, float:2.0)
            if (r12 == r1) goto L_0x037d
            goto L_0x037f
        L_0x037d:
            r0 = r35
        L_0x037f:
            int r1 = r40.getPaddingLeft()
            int r2 = r40.getPaddingRight()
            int r1 = r1 + r2
            int r0 = r0 + r1
            int r1 = r40.getSuggestedMinimumWidth()
            int r0 = java.lang.Math.max(r0, r1)
            int r0 = android.view.View.resolveSizeAndState(r0, r11, r6)
            r7.setMeasuredDimension(r0, r4)
            if (r19 == 0) goto L_0x039d
            r7.forceUniformWidth(r3, r9)
        L_0x039d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutCompat.measureVertical(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.mDivider != null) {
            if (this.mOrientation == 1) {
                drawDividersVertical(canvas);
            } else {
                drawDividersHorizontal(canvas);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mOrientation == 1) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.mBaselineAlignedChildIndex = i;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.mDivider) {
            this.mDivider = drawable;
            boolean z = false;
            if (drawable != null) {
                this.mDividerWidth = drawable.getIntrinsicWidth();
                this.mDividerHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerWidth = 0;
                this.mDividerHeight = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            if ((8388615 & i) == 0) {
                i |= GravityCompat.START;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if ((8388615 & this.mGravity) != i2) {
            this.mGravity = i2 | (this.mGravity & -8388616);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.mGravity & 112) != i2) {
            this.mGravity = i2 | (this.mGravity & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
