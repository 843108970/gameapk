package com.iflytek.voiceads.listener;

import com.iflytek.voiceads.config.AdError;
import com.iflytek.voiceads.conn.NativeDataRef;

public interface IFLYNativeListener extends DialogListener {
    void onAdFailed(AdError adError);

    void onAdLoaded(NativeDataRef nativeDataRef);
}
