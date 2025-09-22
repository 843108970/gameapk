package com.iflytek.voiceads;

import android.content.Context;
import android.view.ViewGroup;
import com.iflytek.voiceads.config.AdError;
import com.iflytek.voiceads.config.ErrorCode;
import com.iflytek.voiceads.config.SDKConstants;
import com.iflytek.voiceads.config.SDKLogger;
import com.iflytek.voiceads.listener.IFLYVideoListener;

public class IFLYVideoAd extends IFLYBaseAd {
    public static final int FULLSCREEN_VIDEO_AD = 1;
    public static final int LANDSCAPE = 0;
    public static final int NATIVE_VIDEO_AD = 0;
    public static final int PORTRAIT = 1;
    private IFLYVideoAd iFLYVideoAdImpl;
    private IFLYVideoListener listener;

    public IFLYVideoAd() {
    }

    public IFLYVideoAd(Context context, String str, int i, IFLYVideoListener iFLYVideoListener) {
        initIFLYBaseAdImpl(context);
        this.listener = iFLYVideoListener;
        this.iFLYVideoAdImpl = getVideoAd(context, str, i, iFLYVideoListener);
    }

    public boolean backPressed() {
        if (this.iFLYVideoAdImpl != null) {
            return this.iFLYVideoAdImpl.backPressed();
        }
        SDKLogger.d(SDKConstants.ERROR_INFO_DEX_FILE);
        return false;
    }

    public void cacheVideo() {
        if (this.iFLYVideoAdImpl == null) {
            SDKLogger.d(SDKConstants.ERROR_INFO_DEX_FILE);
        } else {
            this.iFLYVideoAdImpl.cacheVideo();
        }
    }

    public ViewGroup getVideoView() {
        if (this.iFLYVideoAdImpl != null) {
            return this.iFLYVideoAdImpl.getVideoView();
        }
        SDKLogger.d(SDKConstants.ERROR_INFO_DEX_FILE);
        return null;
    }

    public boolean isPlaying() {
        if (this.iFLYVideoAdImpl != null) {
            return this.iFLYVideoAdImpl.isPlaying();
        }
        SDKLogger.d(SDKConstants.ERROR_INFO_DEX_FILE);
        return false;
    }

    public void loadAd() {
        if (this.iFLYVideoAdImpl == null) {
            SDKLogger.d(SDKConstants.ERROR_INFO_DEX_FILE);
            if (this.listener != null) {
                this.listener.onAdFailed(new AdError(ErrorCode.ERROR_INVALID_REQUEST));
                return;
            }
            return;
        }
        this.iFLYVideoAdImpl.loadAd();
    }

    public void onPause() {
        if (this.iFLYVideoAdImpl == null) {
            SDKLogger.d(SDKConstants.ERROR_INFO_DEX_FILE);
        } else {
            this.iFLYVideoAdImpl.onPause();
        }
    }

    public void onResume() {
        if (this.iFLYVideoAdImpl == null) {
            SDKLogger.d(SDKConstants.ERROR_INFO_DEX_FILE);
        } else {
            this.iFLYVideoAdImpl.onResume();
        }
    }

    public void release() {
        if (this.iFLYVideoAdImpl == null) {
            SDKLogger.d(SDKConstants.ERROR_INFO_DEX_FILE);
        } else {
            this.iFLYVideoAdImpl.release();
        }
    }

    public void setDirectJump(boolean z) {
        if (this.iFLYVideoAdImpl == null) {
            SDKLogger.d(SDKConstants.ERROR_INFO_DEX_FILE);
        } else {
            this.iFLYVideoAdImpl.setDirectJump(z);
        }
    }

    public void setParameter(String str, Object obj) {
        if (this.iFLYVideoAdImpl == null) {
            SDKLogger.d(SDKConstants.ERROR_INFO_DEX_FILE);
        } else {
            this.iFLYVideoAdImpl.setParameter(str, obj);
        }
    }

    public void setVolume(boolean z) {
        if (this.iFLYVideoAdImpl == null) {
            SDKLogger.d(SDKConstants.ERROR_INFO_DEX_FILE);
        } else {
            this.iFLYVideoAdImpl.setVolume(z);
        }
    }

    public void setWifiTip(boolean z) {
        if (this.iFLYVideoAdImpl == null) {
            SDKLogger.d(SDKConstants.ERROR_INFO_DEX_FILE);
        } else {
            this.iFLYVideoAdImpl.setWifiTip(z);
        }
    }

    public void showAd(Object... objArr) {
        if (this.iFLYVideoAdImpl == null) {
            SDKLogger.d(SDKConstants.ERROR_INFO_DEX_FILE);
        } else {
            this.iFLYVideoAdImpl.showAd(objArr);
        }
    }

    public void skipAd() {
        if (this.iFLYVideoAdImpl == null) {
            SDKLogger.d(SDKConstants.ERROR_INFO_DEX_FILE);
        } else {
            this.iFLYVideoAdImpl.skipAd();
        }
    }

    public void startPlay() {
        if (this.iFLYVideoAdImpl == null) {
            SDKLogger.d(SDKConstants.ERROR_INFO_DEX_FILE);
        } else {
            this.iFLYVideoAdImpl.startPlay();
        }
    }

    public void videoDownScroll() {
        if (this.iFLYVideoAdImpl == null) {
            SDKLogger.d(SDKConstants.ERROR_INFO_DEX_FILE);
        } else {
            this.iFLYVideoAdImpl.videoDownScroll();
        }
    }

    public void videoUpScroll() {
        if (this.iFLYVideoAdImpl == null) {
            SDKLogger.d(SDKConstants.ERROR_INFO_DEX_FILE);
        } else {
            this.iFLYVideoAdImpl.videoUpScroll();
        }
    }
}
