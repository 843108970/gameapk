package android.support.v4.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {
    private static final int MIN_DELAY = 500;
    private static final int MIN_SHOW_TIME = 500;
    private final Runnable mDelayedHide;
    private final Runnable mDelayedShow;
    boolean mDismissed;
    boolean mPostedHide;
    boolean mPostedShow;
    long mStartTime;

    public ContentLoadingProgressBar(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public ContentLoadingProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mStartTime = -1;
        this.mPostedHide = false;
        this.mPostedShow = false;
        this.mDismissed = false;
        this.mDelayedHide = new Runnable() {
            public void run() {
                ContentLoadingProgressBar.this.mPostedHide = false;
                ContentLoadingProgressBar.this.mStartTime = -1;
                ContentLoadingProgressBar.this.setVisibility(8);
            }
        };
        this.mDelayedShow = new Runnable() {
            public void run() {
                ContentLoadingProgressBar.this.mPostedShow = false;
                if (!ContentLoadingProgressBar.this.mDismissed) {
                    ContentLoadingProgressBar.this.mStartTime = System.currentTimeMillis();
                    ContentLoadingProgressBar.this.setVisibility(0);
                }
            }
        };
    }

    private void removeCallbacks() {
        removeCallbacks(this.mDelayedHide);
        removeCallbacks(this.mDelayedShow);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void hide() {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 1
            r10.mDismissed = r0     // Catch:{ all -> 0x003b }
            java.lang.Runnable r1 = r10.mDelayedShow     // Catch:{ all -> 0x003b }
            r10.removeCallbacks(r1)     // Catch:{ all -> 0x003b }
            r1 = 0
            r10.mPostedShow = r1     // Catch:{ all -> 0x003b }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x003b }
            long r3 = r10.mStartTime     // Catch:{ all -> 0x003b }
            r5 = 0
            long r5 = r1 - r3
            r1 = 500(0x1f4, double:2.47E-321)
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x0034
            long r3 = r10.mStartTime     // Catch:{ all -> 0x003b }
            r7 = -1
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0024
            goto L_0x0034
        L_0x0024:
            boolean r3 = r10.mPostedHide     // Catch:{ all -> 0x003b }
            if (r3 != 0) goto L_0x0032
            java.lang.Runnable r3 = r10.mDelayedHide     // Catch:{ all -> 0x003b }
            r4 = 0
            long r7 = r1 - r5
            r10.postDelayed(r3, r7)     // Catch:{ all -> 0x003b }
            r10.mPostedHide = r0     // Catch:{ all -> 0x003b }
        L_0x0032:
            monitor-exit(r10)
            return
        L_0x0034:
            r0 = 8
            r10.setVisibility(r0)     // Catch:{ all -> 0x003b }
            monitor-exit(r10)
            return
        L_0x003b:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.ContentLoadingProgressBar.hide():void");
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks();
    }

    public synchronized void show() {
        this.mStartTime = -1;
        this.mDismissed = false;
        removeCallbacks(this.mDelayedHide);
        this.mPostedHide = false;
        if (!this.mPostedShow) {
            postDelayed(this.mDelayedShow, 500);
            this.mPostedShow = true;
        }
    }
}
