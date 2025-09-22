package com.iflytek.voiceads.listener;

import com.iflytek.voiceads.config.AdError;

public interface IFLYAdListener extends DialogListener {
    void onAdClick();

    void onAdClose();

    void onAdExposure();

    void onAdFailed(AdError adError);

    void onAdReceive();
}
