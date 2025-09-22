package com.cyjh.common.util.toast;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

class KeyboardUtils$1 extends ResultReceiver {
    KeyboardUtils$1(Handler handler) {
        super(handler);
    }

    /* access modifiers changed from: protected */
    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1 || i == 3) {
            g.a();
        }
    }
}
