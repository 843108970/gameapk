package com.iflytek.voiceads.listener;

import com.iflytek.voiceads.config.AdError;
import com.iflytek.voiceads.conn.VideoDataRef;

public interface IFLYVideoListener extends DialogListener {
    void onAdClick();

    void onAdFailed(AdError adError);

    void onAdLoaded(VideoDataRef videoDataRef);

    void onAdPlayError();

    void onVideoCached();

    void onVideoComplete();

    void onVideoReplay();

    void onVideoStart();
}
