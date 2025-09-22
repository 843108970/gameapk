package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class ViewPropertyAnimatorCompat {
    static final int LISTENER_TAG_ID = 2113929216;
    private static final String TAG = "ViewAnimatorCompat";
    Runnable mEndAction = null;
    int mOldLayerType = -1;
    Runnable mStartAction = null;
    private WeakReference<View> mView;

    static class ViewPropertyAnimatorListenerApi14 implements ViewPropertyAnimatorListener {
        boolean mAnimEndCalled;
        ViewPropertyAnimatorCompat mVpa;

        ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
            this.mVpa = viewPropertyAnimatorCompat;
        }

        public void onAnimationCancel(View view) {
            Object tag = view.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationCancel(view);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.support.v4.view.ViewPropertyAnimatorListener} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onAnimationEnd(android.view.View r4) {
            /*
                r3 = this;
                android.support.v4.view.ViewPropertyAnimatorCompat r0 = r3.mVpa
                int r0 = r0.mOldLayerType
                r1 = 0
                if (r0 < 0) goto L_0x0013
                android.support.v4.view.ViewPropertyAnimatorCompat r0 = r3.mVpa
                int r0 = r0.mOldLayerType
                r4.setLayerType(r0, r1)
                android.support.v4.view.ViewPropertyAnimatorCompat r0 = r3.mVpa
                r2 = -1
                r0.mOldLayerType = r2
            L_0x0013:
                int r0 = android.os.Build.VERSION.SDK_INT
                r2 = 16
                if (r0 >= r2) goto L_0x001d
                boolean r0 = r3.mAnimEndCalled
                if (r0 != 0) goto L_0x0043
            L_0x001d:
                android.support.v4.view.ViewPropertyAnimatorCompat r0 = r3.mVpa
                java.lang.Runnable r0 = r0.mEndAction
                if (r0 == 0) goto L_0x002e
                android.support.v4.view.ViewPropertyAnimatorCompat r0 = r3.mVpa
                java.lang.Runnable r0 = r0.mEndAction
                android.support.v4.view.ViewPropertyAnimatorCompat r2 = r3.mVpa
                r2.mEndAction = r1
                r0.run()
            L_0x002e:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r2 = r0 instanceof android.support.v4.view.ViewPropertyAnimatorListener
                if (r2 == 0) goto L_0x003b
                r1 = r0
                android.support.v4.view.ViewPropertyAnimatorListener r1 = (android.support.v4.view.ViewPropertyAnimatorListener) r1
            L_0x003b:
                if (r1 == 0) goto L_0x0040
                r1.onAnimationEnd(r4)
            L_0x0040:
                r4 = 1
                r3.mAnimEndCalled = r4
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorListenerApi14.onAnimationEnd(android.view.View):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.support.v4.view.ViewPropertyAnimatorListener} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onAnimationStart(android.view.View r4) {
            /*
                r3 = this;
                r0 = 0
                r3.mAnimEndCalled = r0
                android.support.v4.view.ViewPropertyAnimatorCompat r0 = r3.mVpa
                int r0 = r0.mOldLayerType
                r1 = 0
                if (r0 < 0) goto L_0x000e
                r0 = 2
                r4.setLayerType(r0, r1)
            L_0x000e:
                android.support.v4.view.ViewPropertyAnimatorCompat r0 = r3.mVpa
                java.lang.Runnable r0 = r0.mStartAction
                if (r0 == 0) goto L_0x001f
                android.support.v4.view.ViewPropertyAnimatorCompat r0 = r3.mVpa
                java.lang.Runnable r0 = r0.mStartAction
                android.support.v4.view.ViewPropertyAnimatorCompat r2 = r3.mVpa
                r2.mStartAction = r1
                r0.run()
            L_0x001f:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r2 = r0 instanceof android.support.v4.view.ViewPropertyAnimatorListener
                if (r2 == 0) goto L_0x002c
                r1 = r0
                android.support.v4.view.ViewPropertyAnimatorListener r1 = (android.support.v4.view.ViewPropertyAnimatorListener) r1
            L_0x002c:
                if (r1 == 0) goto L_0x0031
                r1.onAnimationStart(r4)
            L_0x0031:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorListenerApi14.onAnimationStart(android.view.View):void");
        }
    }

    ViewPropertyAnimatorCompat(View view) {
        this.mView = new WeakReference<>(view);
    }

    private void setListenerInternal(final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationCancel(view);
                }

                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationEnd(view);
                }

                public void onAnimationStart(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationStart(view);
                }
            });
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    public final ViewPropertyAnimatorCompat alpha(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat alphaBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().alphaBy(f);
        }
        return this;
    }

    public final void cancel() {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final long getDuration() {
        View view = (View) this.mView.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    public final Interpolator getInterpolator() {
        View view = (View) this.mView.get();
        if (view == null || Build.VERSION.SDK_INT < 18) {
            return null;
        }
        return (Interpolator) view.animate().getInterpolator();
    }

    public final long getStartDelay() {
        View view = (View) this.mView.get();
        if (view != null) {
            return view.animate().getStartDelay();
        }
        return 0;
    }

    public final ViewPropertyAnimatorCompat rotation(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().rotation(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat rotationBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().rotationBy(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat rotationX(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().rotationX(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat rotationXBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().rotationXBy(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat rotationY(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().rotationY(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat rotationYBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().rotationYBy(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat scaleX(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().scaleX(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat scaleXBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().scaleXBy(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat scaleY(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().scaleY(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat scaleYBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().scaleYBy(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat setDuration(long j) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat setInterpolator(Interpolator interpolator) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = (View) this.mView.get();
        if (view == null) {
            return this;
        }
        if (Build.VERSION.SDK_INT < 16) {
            view.setTag(LISTENER_TAG_ID, viewPropertyAnimatorListener);
            viewPropertyAnimatorListener = new ViewPropertyAnimatorListenerApi14(this);
        }
        setListenerInternal(view, viewPropertyAnimatorListener);
        return this;
    }

    public final ViewPropertyAnimatorCompat setStartDelay(long j) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat setUpdateListener(final ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        final View view = (View) this.mView.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            AnonymousClass2 r1 = null;
            if (viewPropertyAnimatorUpdateListener != null) {
                r1 = new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        viewPropertyAnimatorUpdateListener.onAnimationUpdate(view);
                    }
                };
            }
            view.animate().setUpdateListener(r1);
        }
        return this;
    }

    public final void start() {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public final ViewPropertyAnimatorCompat translationX(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().translationX(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat translationXBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().translationXBy(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat translationY(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat translationYBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().translationYBy(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat translationZ(float f) {
        View view = (View) this.mView.get();
        if (view != null && Build.VERSION.SDK_INT >= 21) {
            view.animate().translationZ(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat translationZBy(float f) {
        View view = (View) this.mView.get();
        if (view != null && Build.VERSION.SDK_INT >= 21) {
            view.animate().translationZBy(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat withEndAction(Runnable runnable) {
        View view = (View) this.mView.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view.animate().withEndAction(runnable);
                return this;
            }
            setListenerInternal(view, new ViewPropertyAnimatorListenerApi14(this));
            this.mEndAction = runnable;
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat withLayer() {
        View view = (View) this.mView.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view.animate().withLayer();
                return this;
            }
            this.mOldLayerType = view.getLayerType();
            setListenerInternal(view, new ViewPropertyAnimatorListenerApi14(this));
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat withStartAction(Runnable runnable) {
        View view = (View) this.mView.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view.animate().withStartAction(runnable);
                return this;
            }
            setListenerInternal(view, new ViewPropertyAnimatorListenerApi14(this));
            this.mStartAction = runnable;
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat x(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().x(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat xBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().xBy(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat y(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().y(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat yBy(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().yBy(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat z(float f) {
        View view = (View) this.mView.get();
        if (view != null && Build.VERSION.SDK_INT >= 21) {
            view.animate().z(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat zBy(float f) {
        View view = (View) this.mView.get();
        if (view != null && Build.VERSION.SDK_INT >= 21) {
            view.animate().zBy(f);
        }
        return this;
    }
}
