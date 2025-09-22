package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.transition.AnimatorUtilsApi14;
import android.support.transition.Transition;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class Visibility extends Transition {
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    private static final String PROPNAME_PARENT = "android:visibility:parent";
    private static final String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
    static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    private static final String[] sTransitionProperties = {PROPNAME_VISIBILITY, PROPNAME_PARENT};
    private int mMode = 3;

    private static class DisappearListener extends AnimatorListenerAdapter implements AnimatorUtilsApi14.AnimatorPauseListenerCompat, Transition.TransitionListener {
        boolean mCanceled = false;
        private final int mFinalVisibility;
        private boolean mLayoutSuppressed;
        private final ViewGroup mParent;
        private final boolean mSuppressLayout;
        private final View mView;

        DisappearListener(View view, int i, boolean z) {
            this.mView = view;
            this.mFinalVisibility = i;
            this.mParent = (ViewGroup) view.getParent();
            this.mSuppressLayout = z;
            suppressLayout(true);
        }

        private void hideViewWhenNotCanceled() {
            if (!this.mCanceled) {
                ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
                if (this.mParent != null) {
                    this.mParent.invalidate();
                }
            }
            suppressLayout(false);
        }

        private void suppressLayout(boolean z) {
            if (this.mSuppressLayout && this.mLayoutSuppressed != z && this.mParent != null) {
                this.mLayoutSuppressed = z;
                ViewGroupUtils.suppressLayout(this.mParent, z);
            }
        }

        public void onAnimationCancel(Animator animator) {
            this.mCanceled = true;
        }

        public void onAnimationEnd(Animator animator) {
            hideViewWhenNotCanceled();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.mCanceled) {
                ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationResume(Animator animator) {
            if (!this.mCanceled) {
                ViewUtils.setTransitionVisibility(this.mView, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onTransitionCancel(@NonNull Transition transition) {
        }

        public void onTransitionEnd(@NonNull Transition transition) {
            hideViewWhenNotCanceled();
            transition.removeListener(this);
        }

        public void onTransitionPause(@NonNull Transition transition) {
            suppressLayout(false);
        }

        public void onTransitionResume(@NonNull Transition transition) {
            suppressLayout(true);
        }

        public void onTransitionStart(@NonNull Transition transition) {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    private static class VisibilityInfo {
        ViewGroup mEndParent;
        int mEndVisibility;
        boolean mFadeIn;
        ViewGroup mStartParent;
        int mStartVisibility;
        boolean mVisibilityChange;

        private VisibilityInfo() {
        }
    }

    public Visibility() {
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.VISIBILITY_TRANSITION);
        int namedInt = TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (namedInt != 0) {
            setMode(namedInt);
        }
    }

    private void captureValues(TransitionValues transitionValues) {
        transitionValues.values.put(PROPNAME_VISIBILITY, Integer.valueOf(transitionValues.view.getVisibility()));
        transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put(PROPNAME_SCREEN_LOCATION, iArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0083, code lost:
        if (r0.mEndVisibility == 0) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008d, code lost:
        if (r0.mStartParent == null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x009f, code lost:
        if (r0.mStartVisibility == 0) goto L_0x00a1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.support.transition.Visibility.VisibilityInfo getVisibilityChangeInfo(android.support.transition.TransitionValues r7, android.support.transition.TransitionValues r8) {
        /*
            r6 = this;
            android.support.transition.Visibility$VisibilityInfo r0 = new android.support.transition.Visibility$VisibilityInfo
            r1 = 0
            r0.<init>()
            r2 = 0
            r0.mVisibilityChange = r2
            r0.mFadeIn = r2
            r3 = -1
            if (r7 == 0) goto L_0x0035
            java.util.Map<java.lang.String, java.lang.Object> r4 = r7.values
            java.lang.String r5 = "android:visibility:visibility"
            boolean r4 = r4.containsKey(r5)
            if (r4 == 0) goto L_0x0035
            java.util.Map<java.lang.String, java.lang.Object> r4 = r7.values
            java.lang.String r5 = "android:visibility:visibility"
            java.lang.Object r4 = r4.get(r5)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            r0.mStartVisibility = r4
            java.util.Map<java.lang.String, java.lang.Object> r4 = r7.values
            java.lang.String r5 = "android:visibility:parent"
            java.lang.Object r4 = r4.get(r5)
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            r0.mStartParent = r4
            goto L_0x0039
        L_0x0035:
            r0.mStartVisibility = r3
            r0.mStartParent = r1
        L_0x0039:
            if (r8 == 0) goto L_0x0060
            java.util.Map<java.lang.String, java.lang.Object> r4 = r8.values
            java.lang.String r5 = "android:visibility:visibility"
            boolean r4 = r4.containsKey(r5)
            if (r4 == 0) goto L_0x0060
            java.util.Map<java.lang.String, java.lang.Object> r1 = r8.values
            java.lang.String r3 = "android:visibility:visibility"
            java.lang.Object r1 = r1.get(r3)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r0.mEndVisibility = r1
            java.util.Map<java.lang.String, java.lang.Object> r1 = r8.values
            java.lang.String r3 = "android:visibility:parent"
            java.lang.Object r1 = r1.get(r3)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            goto L_0x0062
        L_0x0060:
            r0.mEndVisibility = r3
        L_0x0062:
            r0.mEndParent = r1
            r1 = 1
            if (r7 == 0) goto L_0x0090
            if (r8 == 0) goto L_0x0090
            int r7 = r0.mStartVisibility
            int r8 = r0.mEndVisibility
            if (r7 != r8) goto L_0x0076
            android.view.ViewGroup r7 = r0.mStartParent
            android.view.ViewGroup r8 = r0.mEndParent
            if (r7 != r8) goto L_0x0076
            return r0
        L_0x0076:
            int r7 = r0.mStartVisibility
            int r8 = r0.mEndVisibility
            if (r7 == r8) goto L_0x0086
            int r7 = r0.mStartVisibility
            if (r7 != 0) goto L_0x0081
            goto L_0x00a1
        L_0x0081:
            int r7 = r0.mEndVisibility
            if (r7 != 0) goto L_0x00a4
            goto L_0x0096
        L_0x0086:
            android.view.ViewGroup r7 = r0.mEndParent
            if (r7 != 0) goto L_0x008b
            goto L_0x00a1
        L_0x008b:
            android.view.ViewGroup r7 = r0.mStartParent
            if (r7 != 0) goto L_0x00a4
            goto L_0x0096
        L_0x0090:
            if (r7 != 0) goto L_0x009b
            int r7 = r0.mEndVisibility
            if (r7 != 0) goto L_0x009b
        L_0x0096:
            r0.mFadeIn = r1
        L_0x0098:
            r0.mVisibilityChange = r1
            return r0
        L_0x009b:
            if (r8 != 0) goto L_0x00a4
            int r7 = r0.mStartVisibility
            if (r7 != 0) goto L_0x00a4
        L_0x00a1:
            r0.mFadeIn = r2
            goto L_0x0098
        L_0x00a4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.Visibility.getVisibilityChangeInfo(android.support.transition.TransitionValues, android.support.transition.TransitionValues):android.support.transition.Visibility$VisibilityInfo");
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (!visibilityChangeInfo.mVisibilityChange) {
            return null;
        }
        if (visibilityChangeInfo.mStartParent == null && visibilityChangeInfo.mEndParent == null) {
            return null;
        }
        if (visibilityChangeInfo.mFadeIn) {
            return onAppear(viewGroup, transitionValues, visibilityChangeInfo.mStartVisibility, transitionValues2, visibilityChangeInfo.mEndVisibility);
        }
        return onDisappear(viewGroup, transitionValues, visibilityChangeInfo.mStartVisibility, transitionValues2, visibilityChangeInfo.mEndVisibility);
    }

    public int getMode() {
        return this.mMode;
    }

    @Nullable
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues != null && transitionValues2 != null && transitionValues2.values.containsKey(PROPNAME_VISIBILITY) != transitionValues.values.containsKey(PROPNAME_VISIBILITY)) {
            return false;
        }
        VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        return visibilityChangeInfo.mVisibilityChange && (visibilityChangeInfo.mStartVisibility == 0 || visibilityChangeInfo.mEndVisibility == 0);
    }

    public boolean isVisible(TransitionValues transitionValues) {
        if (transitionValues == null) {
            return false;
        }
        return ((Integer) transitionValues.values.get(PROPNAME_VISIBILITY)).intValue() == 0 && ((View) transitionValues.values.get(PROPNAME_PARENT)) != null;
    }

    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        if ((this.mMode & 1) != 1 || transitionValues2 == null) {
            return null;
        }
        if (transitionValues == null) {
            View view = (View) transitionValues2.view.getParent();
            if (getVisibilityChangeInfo(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).mVisibilityChange) {
                return null;
            }
        }
        return onAppear(viewGroup, transitionValues2.view, transitionValues, transitionValues2);
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0075 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00dc A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator onDisappear(android.view.ViewGroup r7, android.support.transition.TransitionValues r8, int r9, android.support.transition.TransitionValues r10, int r11) {
        /*
            r6 = this;
            int r9 = r6.mMode
            r0 = 2
            r9 = r9 & r0
            r1 = 0
            if (r9 == r0) goto L_0x0008
            return r1
        L_0x0008:
            if (r8 == 0) goto L_0x000d
            android.view.View r9 = r8.view
            goto L_0x000e
        L_0x000d:
            r9 = r1
        L_0x000e:
            if (r10 == 0) goto L_0x0013
            android.view.View r2 = r10.view
            goto L_0x0014
        L_0x0013:
            r2 = r1
        L_0x0014:
            r3 = 1
            if (r2 == 0) goto L_0x0026
            android.view.ViewParent r4 = r2.getParent()
            if (r4 != 0) goto L_0x001e
            goto L_0x0026
        L_0x001e:
            r4 = 4
            if (r11 != r4) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            if (r9 != r2) goto L_0x0029
        L_0x0024:
            r9 = r1
            goto L_0x0072
        L_0x0026:
            if (r2 == 0) goto L_0x002b
            r9 = r2
        L_0x0029:
            r2 = r1
            goto L_0x0072
        L_0x002b:
            if (r9 == 0) goto L_0x0070
            android.view.ViewParent r2 = r9.getParent()
            if (r2 == 0) goto L_0x0029
            android.view.ViewParent r2 = r9.getParent()
            boolean r2 = r2 instanceof android.view.View
            if (r2 == 0) goto L_0x0070
            android.view.ViewParent r2 = r9.getParent()
            android.view.View r2 = (android.view.View) r2
            android.support.transition.TransitionValues r4 = r6.getTransitionValues(r2, r3)
            android.support.transition.TransitionValues r5 = r6.getMatchedTransitionValues(r2, r3)
            android.support.transition.Visibility$VisibilityInfo r4 = r6.getVisibilityChangeInfo(r4, r5)
            boolean r4 = r4.mVisibilityChange
            if (r4 != 0) goto L_0x0056
            android.view.View r9 = android.support.transition.TransitionUtils.copyViewImage(r7, r9, r2)
            goto L_0x0029
        L_0x0056:
            android.view.ViewParent r4 = r2.getParent()
            if (r4 != 0) goto L_0x006e
            int r2 = r2.getId()
            r4 = -1
            if (r2 == r4) goto L_0x006e
            android.view.View r2 = r7.findViewById(r2)
            if (r2 == 0) goto L_0x006e
            boolean r2 = r6.mCanRemoveViews
            if (r2 == 0) goto L_0x006e
            goto L_0x0029
        L_0x006e:
            r9 = r1
            goto L_0x0029
        L_0x0070:
            r9 = r1
            r2 = r9
        L_0x0072:
            r4 = 0
            if (r9 == 0) goto L_0x00ba
            if (r8 == 0) goto L_0x00ba
            java.util.Map<java.lang.String, java.lang.Object> r11 = r8.values
            java.lang.String r1 = "android:visibility:screenLocation"
            java.lang.Object r11 = r11.get(r1)
            int[] r11 = (int[]) r11
            r1 = r11[r4]
            r11 = r11[r3]
            int[] r0 = new int[r0]
            r7.getLocationOnScreen(r0)
            r2 = r0[r4]
            int r1 = r1 - r2
            int r2 = r9.getLeft()
            int r1 = r1 - r2
            r9.offsetLeftAndRight(r1)
            r0 = r0[r3]
            int r11 = r11 - r0
            int r0 = r9.getTop()
            int r11 = r11 - r0
            r9.offsetTopAndBottom(r11)
            android.support.transition.ViewGroupOverlayImpl r11 = android.support.transition.ViewGroupUtils.getOverlay(r7)
            r11.add(r9)
            android.animation.Animator r7 = r6.onDisappear(r7, r9, r8, r10)
            if (r7 != 0) goto L_0x00b1
            r11.remove(r9)
            return r7
        L_0x00b1:
            android.support.transition.Visibility$1 r8 = new android.support.transition.Visibility$1
            r8.<init>(r11, r9)
            r7.addListener(r8)
            return r7
        L_0x00ba:
            if (r2 == 0) goto L_0x00dc
            int r9 = r2.getVisibility()
            android.support.transition.ViewUtils.setTransitionVisibility(r2, r4)
            android.animation.Animator r7 = r6.onDisappear(r7, r2, r8, r10)
            if (r7 == 0) goto L_0x00d8
            android.support.transition.Visibility$DisappearListener r8 = new android.support.transition.Visibility$DisappearListener
            r8.<init>(r2, r11, r3)
            r7.addListener(r8)
            android.support.transition.AnimatorUtils.addPauseListener(r7, r8)
            r6.addListener(r8)
            return r7
        L_0x00d8:
            android.support.transition.ViewUtils.setTransitionVisibility(r2, r9)
            return r7
        L_0x00dc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.Visibility.onDisappear(android.view.ViewGroup, android.support.transition.TransitionValues, int, android.support.transition.TransitionValues, int):android.animation.Animator");
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public void setMode(int i) {
        if ((i & -4) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.mMode = i;
    }
}
