package com.lidroid.xutils.bitmap;

import android.widget.AbsListView;
import com.lidroid.xutils.task.TaskHandler;

public class PauseOnScrollListener implements AbsListView.OnScrollListener {
    private final AbsListView.OnScrollListener externalListener;
    private final boolean pauseOnFling;
    private final boolean pauseOnScroll;
    private TaskHandler taskHandler;

    public PauseOnScrollListener(TaskHandler taskHandler2, boolean z, boolean z2) {
        this(taskHandler2, z, z2, (AbsListView.OnScrollListener) null);
    }

    public PauseOnScrollListener(TaskHandler taskHandler2, boolean z, boolean z2, AbsListView.OnScrollListener onScrollListener) {
        this.taskHandler = taskHandler2;
        this.pauseOnScroll = z;
        this.pauseOnFling = z2;
        this.externalListener = onScrollListener;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.externalListener != null) {
            this.externalListener.onScroll(absListView, i, i2, i3);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        if (r1.pauseOnFling != false) goto L_0x000d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        if (r1.pauseOnScroll != false) goto L_0x000d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        r1.taskHandler.pause();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onScrollStateChanged(android.widget.AbsListView r2, int r3) {
        /*
            r1 = this;
            switch(r3) {
                case 0: goto L_0x0013;
                case 1: goto L_0x0009;
                case 2: goto L_0x0004;
                default: goto L_0x0003;
            }
        L_0x0003:
            goto L_0x0018
        L_0x0004:
            boolean r0 = r1.pauseOnFling
            if (r0 == 0) goto L_0x0018
            goto L_0x000d
        L_0x0009:
            boolean r0 = r1.pauseOnScroll
            if (r0 == 0) goto L_0x0018
        L_0x000d:
            com.lidroid.xutils.task.TaskHandler r0 = r1.taskHandler
            r0.pause()
            goto L_0x0018
        L_0x0013:
            com.lidroid.xutils.task.TaskHandler r0 = r1.taskHandler
            r0.resume()
        L_0x0018:
            android.widget.AbsListView$OnScrollListener r0 = r1.externalListener
            if (r0 == 0) goto L_0x0021
            android.widget.AbsListView$OnScrollListener r0 = r1.externalListener
            r0.onScrollStateChanged(r2, r3)
        L_0x0021:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.bitmap.PauseOnScrollListener.onScrollStateChanged(android.widget.AbsListView, int):void");
    }
}
