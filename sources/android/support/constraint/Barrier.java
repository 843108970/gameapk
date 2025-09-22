package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class Barrier extends ConstraintHelper {
    public static final int BOTTOM = 3;
    public static final int END = 6;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int START = 5;
    public static final int TOP = 2;
    private android.support.constraint.solver.widgets.Barrier mBarrier;
    private int mIndicatedType;
    private int mResolvedType;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setVisibility(8);
    }

    public boolean allowsGoneWidget() {
        return this.mBarrier.allowsGoneWidget();
    }

    public int getType() {
        return this.mIndicatedType;
    }

    /* access modifiers changed from: protected */
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.mBarrier = new android.support.constraint.solver.widgets.Barrier();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.mBarrier.setAllowsGoneWidget(obtainStyledAttributes.getBoolean(index, true));
                }
            }
        }
        this.mHelperWidget = this.mBarrier;
        validateParams();
    }

    public void setAllowsGoneWidget(boolean z) {
        this.mBarrier.setAllowsGoneWidget(z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        if (r5.mIndicatedType == 6) goto L_0x0012;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
        if (r5.mIndicatedType == 6) goto L_0x0019;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
        if (r5.mIndicatedType == 6) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setType(int r6) {
        /*
            r5 = this;
            r5.mIndicatedType = r6
            r5.mResolvedType = r6
            int r6 = android.os.Build.VERSION.SDK_INT
            r0 = 6
            r1 = 5
            r2 = 0
            r3 = 1
            r4 = 17
            if (r6 >= r4) goto L_0x001c
            int r6 = r5.mIndicatedType
            if (r6 != r1) goto L_0x0015
        L_0x0012:
            r5.mResolvedType = r2
            goto L_0x0043
        L_0x0015:
            int r6 = r5.mIndicatedType
            if (r6 != r0) goto L_0x0043
        L_0x0019:
            r5.mResolvedType = r3
            goto L_0x0043
        L_0x001c:
            android.content.res.Resources r6 = r5.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            int r6 = r6.getLayoutDirection()
            if (r3 != r6) goto L_0x002c
            r6 = 1
            goto L_0x002d
        L_0x002c:
            r6 = 0
        L_0x002d:
            if (r6 == 0) goto L_0x0039
            int r6 = r5.mIndicatedType
            if (r6 != r1) goto L_0x0034
            goto L_0x0019
        L_0x0034:
            int r6 = r5.mIndicatedType
            if (r6 != r0) goto L_0x0043
            goto L_0x0012
        L_0x0039:
            int r6 = r5.mIndicatedType
            if (r6 != r1) goto L_0x003e
            goto L_0x0012
        L_0x003e:
            int r6 = r5.mIndicatedType
            if (r6 != r0) goto L_0x0043
            goto L_0x0019
        L_0x0043:
            android.support.constraint.solver.widgets.Barrier r6 = r5.mBarrier
            int r0 = r5.mResolvedType
            r6.setBarrierType(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.Barrier.setType(int):void");
    }
}
