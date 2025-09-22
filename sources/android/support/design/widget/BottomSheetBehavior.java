package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.design.R;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.math.MathUtils;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    int mActivePointerId;
    private BottomSheetCallback mCallback;
    private final ViewDragHelper.Callback mDragCallback = new ViewDragHelper.Callback() {
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return view.getLeft();
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return MathUtils.clamp(i, BottomSheetBehavior.this.mMinOffset, BottomSheetBehavior.this.mHideable ? BottomSheetBehavior.this.mParentHeight : BottomSheetBehavior.this.mMaxOffset);
        }

        public int getViewVerticalDragRange(View view) {
            return (BottomSheetBehavior.this.mHideable ? BottomSheetBehavior.this.mParentHeight : BottomSheetBehavior.this.mMaxOffset) - BottomSheetBehavior.this.mMinOffset;
        }

        public void onViewDragStateChanged(int i) {
            if (i == 1) {
                BottomSheetBehavior.this.setStateInternal(1);
            }
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.dispatchOnSlide(i2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
            if (java.lang.Math.abs(r5 - r3.this$0.mMinOffset) < java.lang.Math.abs(r5 - r3.this$0.mMaxOffset)) goto L_0x0007;
         */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0062  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onViewReleased(android.view.View r4, float r5, float r6) {
            /*
                r3 = this;
                r5 = 0
                int r0 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
                r1 = 4
                r2 = 3
                if (r0 >= 0) goto L_0x000d
            L_0x0007:
                android.support.design.widget.BottomSheetBehavior r5 = android.support.design.widget.BottomSheetBehavior.this
                int r5 = r5.mMinOffset
                r1 = 3
                goto L_0x0043
            L_0x000d:
                android.support.design.widget.BottomSheetBehavior r0 = android.support.design.widget.BottomSheetBehavior.this
                boolean r0 = r0.mHideable
                if (r0 == 0) goto L_0x0021
                android.support.design.widget.BottomSheetBehavior r0 = android.support.design.widget.BottomSheetBehavior.this
                boolean r0 = r0.shouldHide(r4, r6)
                if (r0 == 0) goto L_0x0021
                android.support.design.widget.BottomSheetBehavior r5 = android.support.design.widget.BottomSheetBehavior.this
                int r5 = r5.mParentHeight
                r1 = 5
                goto L_0x0043
            L_0x0021:
                int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
                if (r5 != 0) goto L_0x003f
                int r5 = r4.getTop()
                android.support.design.widget.BottomSheetBehavior r6 = android.support.design.widget.BottomSheetBehavior.this
                int r6 = r6.mMinOffset
                int r6 = r5 - r6
                int r6 = java.lang.Math.abs(r6)
                android.support.design.widget.BottomSheetBehavior r0 = android.support.design.widget.BottomSheetBehavior.this
                int r0 = r0.mMaxOffset
                int r5 = r5 - r0
                int r5 = java.lang.Math.abs(r5)
                if (r6 >= r5) goto L_0x003f
                goto L_0x0007
            L_0x003f:
                android.support.design.widget.BottomSheetBehavior r5 = android.support.design.widget.BottomSheetBehavior.this
                int r5 = r5.mMaxOffset
            L_0x0043:
                android.support.design.widget.BottomSheetBehavior r6 = android.support.design.widget.BottomSheetBehavior.this
                android.support.v4.widget.ViewDragHelper r6 = r6.mViewDragHelper
                int r0 = r4.getLeft()
                boolean r5 = r6.settleCapturedViewAt(r0, r5)
                if (r5 == 0) goto L_0x0062
                android.support.design.widget.BottomSheetBehavior r5 = android.support.design.widget.BottomSheetBehavior.this
                r6 = 2
                r5.setStateInternal(r6)
                android.support.design.widget.BottomSheetBehavior$SettleRunnable r5 = new android.support.design.widget.BottomSheetBehavior$SettleRunnable
                android.support.design.widget.BottomSheetBehavior r6 = android.support.design.widget.BottomSheetBehavior.this
                r5.<init>(r4, r1)
                android.support.v4.view.ViewCompat.postOnAnimation(r4, r5)
                return
            L_0x0062:
                android.support.design.widget.BottomSheetBehavior r4 = android.support.design.widget.BottomSheetBehavior.this
                r4.setStateInternal(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.BottomSheetBehavior.AnonymousClass2.onViewReleased(android.view.View, float, float):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
            r6 = (android.view.View) r4.this$0.mNestedScrollingChildRef.get();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean tryCaptureView(android.view.View r5, int r6) {
            /*
                r4 = this;
                android.support.design.widget.BottomSheetBehavior r0 = android.support.design.widget.BottomSheetBehavior.this
                int r0 = r0.mState
                r1 = 1
                r2 = 0
                if (r0 != r1) goto L_0x0009
                return r2
            L_0x0009:
                android.support.design.widget.BottomSheetBehavior r0 = android.support.design.widget.BottomSheetBehavior.this
                boolean r0 = r0.mTouchingScrollingChild
                if (r0 == 0) goto L_0x0010
                return r2
            L_0x0010:
                android.support.design.widget.BottomSheetBehavior r0 = android.support.design.widget.BottomSheetBehavior.this
                int r0 = r0.mState
                r3 = 3
                if (r0 != r3) goto L_0x0031
                android.support.design.widget.BottomSheetBehavior r0 = android.support.design.widget.BottomSheetBehavior.this
                int r0 = r0.mActivePointerId
                if (r0 != r6) goto L_0x0031
                android.support.design.widget.BottomSheetBehavior r6 = android.support.design.widget.BottomSheetBehavior.this
                java.lang.ref.WeakReference<android.view.View> r6 = r6.mNestedScrollingChildRef
                java.lang.Object r6 = r6.get()
                android.view.View r6 = (android.view.View) r6
                if (r6 == 0) goto L_0x0031
                r0 = -1
                boolean r6 = r6.canScrollVertically(r0)
                if (r6 == 0) goto L_0x0031
                return r2
            L_0x0031:
                android.support.design.widget.BottomSheetBehavior r6 = android.support.design.widget.BottomSheetBehavior.this
                java.lang.ref.WeakReference<V> r6 = r6.mViewRef
                if (r6 == 0) goto L_0x0042
                android.support.design.widget.BottomSheetBehavior r6 = android.support.design.widget.BottomSheetBehavior.this
                java.lang.ref.WeakReference<V> r6 = r6.mViewRef
                java.lang.Object r6 = r6.get()
                if (r6 != r5) goto L_0x0042
                return r1
            L_0x0042:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.BottomSheetBehavior.AnonymousClass2.tryCaptureView(android.view.View, int):boolean");
        }
    };
    boolean mHideable;
    private boolean mIgnoreEvents;
    private int mInitialY;
    private int mLastNestedScrollDy;
    int mMaxOffset;
    private float mMaximumVelocity;
    int mMinOffset;
    private boolean mNestedScrolled;
    WeakReference<View> mNestedScrollingChildRef;
    int mParentHeight;
    private int mPeekHeight;
    private boolean mPeekHeightAuto;
    private int mPeekHeightMin;
    private boolean mSkipCollapsed;
    int mState = 4;
    boolean mTouchingScrollingChild;
    private VelocityTracker mVelocityTracker;
    ViewDragHelper mViewDragHelper;
    WeakReference<V> mViewRef;

    public static abstract class BottomSheetCallback {
        public abstract void onSlide(@NonNull View view, float f);

        public abstract void onStateChanged(@NonNull View view, int i);
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        final int state;

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.state = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
        }
    }

    private class SettleRunnable implements Runnable {
        private final int mTargetState;
        private final View mView;

        SettleRunnable(View view, int i) {
            this.mView = view;
            this.mTargetState = i;
        }

        public void run() {
            if (BottomSheetBehavior.this.mViewDragHelper == null || !BottomSheetBehavior.this.mViewDragHelper.continueSettling(true)) {
                BottomSheetBehavior.this.setStateInternal(this.mTargetState);
            } else {
                ViewCompat.postOnAnimation(this.mView, this);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public BottomSheetBehavior() {
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        setPeekHeight((peekValue == null || peekValue.data != -1) ? obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1) : peekValue.data);
        setHideable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.mMaximumVelocity = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public static <V extends View> BottomSheetBehavior<V> from(V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
        if (behavior instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) behavior;
        }
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    private float getYVelocity() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
        return this.mVelocityTracker.getYVelocity(this.mActivePointerId);
    }

    private void reset() {
        this.mActivePointerId = -1;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnSlide(int i) {
        View view = (View) this.mViewRef.get();
        if (view != null && this.mCallback != null) {
            if (i > this.mMaxOffset) {
                this.mCallback.onSlide(view, ((float) (this.mMaxOffset - i)) / ((float) (this.mParentHeight - this.mMaxOffset)));
            } else {
                this.mCallback.onSlide(view, ((float) (this.mMaxOffset - i)) / ((float) (this.mMaxOffset - this.mMinOffset)));
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public View findScrollingChild(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i));
            if (findScrollingChild != null) {
                return findScrollingChild;
            }
        }
        return null;
    }

    public final int getPeekHeight() {
        if (this.mPeekHeightAuto) {
            return -1;
        }
        return this.mPeekHeight;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public int getPeekHeightMin() {
        return this.mPeekHeightMin;
    }

    public boolean getSkipCollapsed() {
        return this.mSkipCollapsed;
    }

    public final int getState() {
        return this.mState;
    }

    public boolean isHideable() {
        return this.mHideable;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            this.mIgnoreEvents = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            reset();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (actionMasked != 3) {
            switch (actionMasked) {
                case 0:
                    int x = (int) motionEvent.getX();
                    this.mInitialY = (int) motionEvent.getY();
                    View view = this.mNestedScrollingChildRef != null ? (View) this.mNestedScrollingChildRef.get() : null;
                    if (view != null && coordinatorLayout.isPointInChildBounds(view, x, this.mInitialY)) {
                        this.mActivePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.mTouchingScrollingChild = true;
                    }
                    this.mIgnoreEvents = this.mActivePointerId == -1 && !coordinatorLayout.isPointInChildBounds(v, x, this.mInitialY);
                    break;
                case 1:
                    break;
            }
        }
        this.mTouchingScrollingChild = false;
        this.mActivePointerId = -1;
        if (this.mIgnoreEvents) {
            this.mIgnoreEvents = false;
            return false;
        }
        if (!this.mIgnoreEvents && this.mViewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        View view2 = (View) this.mNestedScrollingChildRef.get();
        return actionMasked == 2 && view2 != null && !this.mIgnoreEvents && this.mState != 1 && !coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) && Math.abs(((float) this.mInitialY) - motionEvent.getY()) > ((float) this.mViewDragHelper.getTouchSlop());
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onLayoutChild(android.support.design.widget.CoordinatorLayout r6, V r7, int r8) {
        /*
            r5 = this;
            boolean r0 = android.support.v4.view.ViewCompat.getFitsSystemWindows(r6)
            r1 = 1
            if (r0 == 0) goto L_0x0010
            boolean r0 = android.support.v4.view.ViewCompat.getFitsSystemWindows(r7)
            if (r0 != 0) goto L_0x0010
            android.support.v4.view.ViewCompat.setFitsSystemWindows(r7, r1)
        L_0x0010:
            int r0 = r7.getTop()
            r6.onLayoutChild(r7, r8)
            int r8 = r6.getHeight()
            r5.mParentHeight = r8
            boolean r8 = r5.mPeekHeightAuto
            if (r8 == 0) goto L_0x0043
            int r8 = r5.mPeekHeightMin
            if (r8 != 0) goto L_0x0031
            android.content.res.Resources r8 = r6.getResources()
            int r2 = android.support.design.R.dimen.design_bottom_sheet_peek_height_min
            int r8 = r8.getDimensionPixelSize(r2)
            r5.mPeekHeightMin = r8
        L_0x0031:
            int r8 = r5.mPeekHeightMin
            int r2 = r5.mParentHeight
            int r3 = r6.getWidth()
            int r3 = r3 * 9
            int r3 = r3 / 16
            int r2 = r2 - r3
            int r8 = java.lang.Math.max(r8, r2)
            goto L_0x0045
        L_0x0043:
            int r8 = r5.mPeekHeight
        L_0x0045:
            r2 = 0
            int r3 = r5.mParentHeight
            int r4 = r7.getHeight()
            int r3 = r3 - r4
            int r2 = java.lang.Math.max(r2, r3)
            r5.mMinOffset = r2
            int r2 = r5.mParentHeight
            int r2 = r2 - r8
            int r8 = r5.mMinOffset
            int r8 = java.lang.Math.max(r2, r8)
            r5.mMaxOffset = r8
            int r8 = r5.mState
            r2 = 3
            if (r8 != r2) goto L_0x0069
            int r8 = r5.mMinOffset
        L_0x0065:
            android.support.v4.view.ViewCompat.offsetTopAndBottom(r7, r8)
            goto L_0x008e
        L_0x0069:
            boolean r8 = r5.mHideable
            if (r8 == 0) goto L_0x0075
            int r8 = r5.mState
            r2 = 5
            if (r8 != r2) goto L_0x0075
            int r8 = r5.mParentHeight
            goto L_0x0065
        L_0x0075:
            int r8 = r5.mState
            r2 = 4
            if (r8 != r2) goto L_0x007d
            int r8 = r5.mMaxOffset
            goto L_0x0065
        L_0x007d:
            int r8 = r5.mState
            if (r8 == r1) goto L_0x0086
            int r8 = r5.mState
            r2 = 2
            if (r8 != r2) goto L_0x008e
        L_0x0086:
            int r8 = r7.getTop()
            int r0 = r0 - r8
            android.support.v4.view.ViewCompat.offsetTopAndBottom(r7, r0)
        L_0x008e:
            android.support.v4.widget.ViewDragHelper r8 = r5.mViewDragHelper
            if (r8 != 0) goto L_0x009a
            android.support.v4.widget.ViewDragHelper$Callback r8 = r5.mDragCallback
            android.support.v4.widget.ViewDragHelper r6 = android.support.v4.widget.ViewDragHelper.create(r6, r8)
            r5.mViewDragHelper = r6
        L_0x009a:
            java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference
            r6.<init>(r7)
            r5.mViewRef = r6
            java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference
            android.view.View r7 = r5.findScrollingChild(r7)
            r6.<init>(r7)
            r5.mNestedScrollingChildRef = r6
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.BottomSheetBehavior.onLayoutChild(android.support.design.widget.CoordinatorLayout, android.view.View, int):boolean");
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        if (view == this.mNestedScrollingChildRef.get()) {
            return this.mState != 3 || super.onNestedPreFling(coordinatorLayout, v, view, f, f2);
        }
        return false;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        int i3;
        if (view == ((View) this.mNestedScrollingChildRef.get())) {
            int top = v.getTop();
            int i4 = top - i2;
            if (i2 <= 0) {
                if (i2 < 0 && !view.canScrollVertically(-1)) {
                    if (i4 <= this.mMaxOffset || this.mHideable) {
                        iArr[1] = i2;
                        ViewCompat.offsetTopAndBottom(v, -i2);
                        setStateInternal(1);
                    } else {
                        iArr[1] = top - this.mMaxOffset;
                        ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                        i3 = 4;
                    }
                }
                dispatchOnSlide(v.getTop());
                this.mLastNestedScrollDy = i2;
                this.mNestedScrolled = true;
            } else if (i4 < this.mMinOffset) {
                iArr[1] = top - this.mMinOffset;
                ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                i3 = 3;
            } else {
                iArr[1] = i2;
                ViewCompat.offsetTopAndBottom(v, -i2);
                setStateInternal(1);
                dispatchOnSlide(v.getTop());
                this.mLastNestedScrollDy = i2;
                this.mNestedScrolled = true;
            }
            setStateInternal(i3);
            dispatchOnSlide(v.getTop());
            this.mLastNestedScrollDy = i2;
            this.mNestedScrolled = true;
        }
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        this.mState = (savedState.state == 1 || savedState.state == 2) ? 4 : savedState.state;
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), this.mState);
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        this.mLastNestedScrollDy = 0;
        this.mNestedScrolled = false;
        return (i & 2) != 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004f, code lost:
        if (java.lang.Math.abs(r4 - r3.mMinOffset) < java.lang.Math.abs(r4 - r3.mMaxOffset)) goto L_0x0023;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStopNestedScroll(android.support.design.widget.CoordinatorLayout r4, V r5, android.view.View r6) {
        /*
            r3 = this;
            int r4 = r5.getTop()
            int r0 = r3.mMinOffset
            r1 = 3
            if (r4 != r0) goto L_0x000d
            r3.setStateInternal(r1)
            return
        L_0x000d:
            java.lang.ref.WeakReference<android.view.View> r4 = r3.mNestedScrollingChildRef
            if (r4 == 0) goto L_0x0074
            java.lang.ref.WeakReference<android.view.View> r4 = r3.mNestedScrollingChildRef
            java.lang.Object r4 = r4.get()
            if (r6 != r4) goto L_0x0074
            boolean r4 = r3.mNestedScrolled
            if (r4 != 0) goto L_0x001e
            return
        L_0x001e:
            int r4 = r3.mLastNestedScrollDy
            r6 = 4
            if (r4 <= 0) goto L_0x0026
        L_0x0023:
            int r4 = r3.mMinOffset
            goto L_0x0055
        L_0x0026:
            boolean r4 = r3.mHideable
            if (r4 == 0) goto L_0x0038
            float r4 = r3.getYVelocity()
            boolean r4 = r3.shouldHide(r5, r4)
            if (r4 == 0) goto L_0x0038
            int r4 = r3.mParentHeight
            r1 = 5
            goto L_0x0055
        L_0x0038:
            int r4 = r3.mLastNestedScrollDy
            if (r4 != 0) goto L_0x0052
            int r4 = r5.getTop()
            int r0 = r3.mMinOffset
            int r0 = r4 - r0
            int r0 = java.lang.Math.abs(r0)
            int r2 = r3.mMaxOffset
            int r4 = r4 - r2
            int r4 = java.lang.Math.abs(r4)
            if (r0 >= r4) goto L_0x0052
            goto L_0x0023
        L_0x0052:
            int r4 = r3.mMaxOffset
            r1 = 4
        L_0x0055:
            android.support.v4.widget.ViewDragHelper r6 = r3.mViewDragHelper
            int r0 = r5.getLeft()
            boolean r4 = r6.smoothSlideViewTo(r5, r0, r4)
            if (r4 == 0) goto L_0x006e
            r4 = 2
            r3.setStateInternal(r4)
            android.support.design.widget.BottomSheetBehavior$SettleRunnable r4 = new android.support.design.widget.BottomSheetBehavior$SettleRunnable
            r4.<init>(r5, r1)
            android.support.v4.view.ViewCompat.postOnAnimation(r5, r4)
            goto L_0x0071
        L_0x006e:
            r3.setStateInternal(r1)
        L_0x0071:
            r4 = 0
            r3.mNestedScrolled = r4
        L_0x0074:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.BottomSheetBehavior.onStopNestedScroll(android.support.design.widget.CoordinatorLayout, android.view.View, android.view.View):void");
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.mState == 1 && actionMasked == 0) {
            return true;
        }
        if (this.mViewDragHelper != null) {
            this.mViewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (actionMasked == 2 && !this.mIgnoreEvents && Math.abs(((float) this.mInitialY) - motionEvent.getY()) > ((float) this.mViewDragHelper.getTouchSlop())) {
            this.mViewDragHelper.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.mIgnoreEvents;
    }

    public void setBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        this.mCallback = bottomSheetCallback;
    }

    public void setHideable(boolean z) {
        this.mHideable = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setPeekHeight(int r4) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r4 != r2) goto L_0x000c
            boolean r4 = r3.mPeekHeightAuto
            if (r4 != 0) goto L_0x0015
            r3.mPeekHeightAuto = r0
            goto L_0x0024
        L_0x000c:
            boolean r2 = r3.mPeekHeightAuto
            if (r2 != 0) goto L_0x0017
            int r2 = r3.mPeekHeight
            if (r2 == r4) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r0 = 0
            goto L_0x0024
        L_0x0017:
            r3.mPeekHeightAuto = r1
            int r1 = java.lang.Math.max(r1, r4)
            r3.mPeekHeight = r1
            int r1 = r3.mParentHeight
            int r1 = r1 - r4
            r3.mMaxOffset = r1
        L_0x0024:
            if (r0 == 0) goto L_0x003c
            int r4 = r3.mState
            r0 = 4
            if (r4 != r0) goto L_0x003c
            java.lang.ref.WeakReference<V> r4 = r3.mViewRef
            if (r4 == 0) goto L_0x003c
            java.lang.ref.WeakReference<V> r4 = r3.mViewRef
            java.lang.Object r4 = r4.get()
            android.view.View r4 = (android.view.View) r4
            if (r4 == 0) goto L_0x003c
            r4.requestLayout()
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.BottomSheetBehavior.setPeekHeight(int):void");
    }

    public void setSkipCollapsed(boolean z) {
        this.mSkipCollapsed = z;
    }

    public final void setState(final int i) {
        if (i != this.mState) {
            if (this.mViewRef != null) {
                final View view = (View) this.mViewRef.get();
                if (view != null) {
                    ViewParent parent = view.getParent();
                    if (parent == null || !parent.isLayoutRequested() || !ViewCompat.isAttachedToWindow(view)) {
                        startSettlingAnimation(view, i);
                    } else {
                        view.post(new Runnable() {
                            public void run() {
                                BottomSheetBehavior.this.startSettlingAnimation(view, i);
                            }
                        });
                    }
                }
            } else if (i == 4 || i == 3 || (this.mHideable && i == 5)) {
                this.mState = i;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setStateInternal(int i) {
        if (this.mState != i) {
            this.mState = i;
            View view = (View) this.mViewRef.get();
            if (view != null && this.mCallback != null) {
                this.mCallback.onStateChanged(view, i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean shouldHide(View view, float f) {
        if (this.mSkipCollapsed) {
            return true;
        }
        return view.getTop() >= this.mMaxOffset && Math.abs((((float) view.getTop()) + (f * 0.1f)) - ((float) this.mMaxOffset)) / ((float) this.mPeekHeight) > HIDE_THRESHOLD;
    }

    /* access modifiers changed from: package-private */
    public void startSettlingAnimation(View view, int i) {
        int i2;
        if (i == 4) {
            i2 = this.mMaxOffset;
        } else if (i == 3) {
            i2 = this.mMinOffset;
        } else if (!this.mHideable || i != 5) {
            throw new IllegalArgumentException("Illegal state argument: " + i);
        } else {
            i2 = this.mParentHeight;
        }
        if (this.mViewDragHelper.smoothSlideViewTo(view, view.getLeft(), i2)) {
            setStateInternal(2);
            ViewCompat.postOnAnimation(view, new SettleRunnable(view, i));
            return;
        }
        setStateInternal(i);
    }
}
