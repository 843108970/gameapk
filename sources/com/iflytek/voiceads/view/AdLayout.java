package com.iflytek.voiceads.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.iflytek.voiceads.listener.InternalListener;

public abstract class AdLayout extends RelativeLayout {
    private final int DESTROY = 1;
    /* access modifiers changed from: private */
    public boolean hasDestroyed = false;
    /* access modifiers changed from: private */
    public AdLayoutHandler layoutHandler;
    protected InternalListener mInternalListener = new InternalListener() {
        public boolean onAdDestroy() {
            if (AdLayout.this.hasDestroyed) {
                return false;
            }
            boolean unused = AdLayout.this.hasDestroyed = true;
            if (AdLayout.this.layoutHandler != null) {
                AdLayout.this.layoutHandler.sendEmptyMessage(1);
            }
            return true;
        }
    };

    private class AdLayoutHandler extends Handler {
        public AdLayoutHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                AdLayout.this.destroy();
            }
        }
    }

    public AdLayout(Context context) {
        super(context);
        this.layoutHandler = new AdLayoutHandler(context.getMainLooper());
    }

    public synchronized void destroy() {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        removeAllViews();
        setVisibility(8);
    }
}
