package com.bumptech.glide.request.target;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.o;
import com.bumptech.glide.request.a.f;

public final class PreloadTarget<Z> extends SimpleTarget<Z> {
    private static final Handler HANDLER = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((PreloadTarget) message.obj).clear();
            return true;
        }
    });
    private static final int MESSAGE_CLEAR = 1;
    private final o requestManager;

    private PreloadTarget(o oVar, int i, int i2) {
        super(i, i2);
        this.requestManager = oVar;
    }

    public static <Z> PreloadTarget<Z> obtain(o oVar, int i, int i2) {
        return new PreloadTarget<>(oVar, i, i2);
    }

    /* access modifiers changed from: package-private */
    public final void clear() {
        this.requestManager.a((Target<?>) this);
    }

    public final void onResourceReady(@NonNull Z z, @Nullable f<? super Z> fVar) {
        HANDLER.obtainMessage(1, this).sendToTarget();
    }
}
