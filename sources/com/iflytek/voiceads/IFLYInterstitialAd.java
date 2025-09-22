package com.iflytek.voiceads;

import android.content.Context;
import com.iflytek.voiceads.config.AdError;
import com.iflytek.voiceads.config.ErrorCode;
import com.iflytek.voiceads.config.SDKConstants;
import com.iflytek.voiceads.config.SDKLogger;
import com.iflytek.voiceads.dex.a;
import com.iflytek.voiceads.listener.IFLYAdListener;
import com.iflytek.voiceads.view.AdLayout;
import java.lang.reflect.InvocationTargetException;

public class IFLYInterstitialAd extends AdLayout {
    private static Class<?> cIFLYInterstitialAdImpl = null;
    private static IFLYInterstitialAd iFLYInterstitialAdImpl = null;
    private static boolean isClassLoaded = false;

    protected IFLYInterstitialAd(Context context) {
        super(context);
    }

    public static IFLYInterstitialAd createInterstitialAd(Context context, String str) {
        String str2;
        StringBuilder sb;
        try {
            if (!isClassLoaded) {
                cIFLYInterstitialAdImpl = a.a(context, "com.iflytek.voiceads.IFLYInterstitialAdImpl");
                isClassLoaded = true;
            }
            IFLYInterstitialAd iFLYInterstitialAd = (IFLYInterstitialAd) cIFLYInterstitialAdImpl.getMethod("createInterstitialAd", new Class[]{Context.class, String.class}).invoke((Object) null, new Object[]{context, str});
            iFLYInterstitialAdImpl = iFLYInterstitialAd;
            return iFLYInterstitialAd;
        } catch (NoSuchMethodException e) {
            sb = new StringBuilder("inter:");
            str2 = e.getMessage();
            sb.append(str2);
            SDKLogger.e(sb.toString());
            return new IFLYInterstitialAd(context);
        } catch (IllegalAccessException e2) {
            sb = new StringBuilder("inter:");
            str2 = e2.getMessage();
            sb.append(str2);
            SDKLogger.e(sb.toString());
            return new IFLYInterstitialAd(context);
        } catch (InvocationTargetException e3) {
            sb = new StringBuilder("inter:");
            str2 = e3.getMessage();
            sb.append(str2);
            SDKLogger.e(sb.toString());
            return new IFLYInterstitialAd(context);
        } catch (ClassNotFoundException e4) {
            sb = new StringBuilder("inter:");
            str2 = e4.getMessage();
            sb.append(str2);
            SDKLogger.e(sb.toString());
            return new IFLYInterstitialAd(context);
        }
    }

    public void loadAd(IFLYAdListener iFLYAdListener) {
        if (iFLYInterstitialAdImpl == null) {
            SDKLogger.d(SDKConstants.ERROR_INFO_DEX_FILE);
            if (iFLYAdListener != null) {
                iFLYAdListener.onAdFailed(new AdError(ErrorCode.ERROR_INVALID_REQUEST));
                return;
            }
            return;
        }
        iFLYInterstitialAdImpl.loadAd(iFLYAdListener);
    }

    public void setParameter(String str, Object obj) {
        if (iFLYInterstitialAdImpl == null) {
            SDKLogger.d(SDKConstants.ERROR_INFO_DEX_FILE);
        } else {
            iFLYInterstitialAdImpl.setParameter(str, obj);
        }
    }

    public void showAd() {
        if (iFLYInterstitialAdImpl == null) {
            SDKLogger.d(SDKConstants.ERROR_INFO_DEX_FILE);
        } else {
            iFLYInterstitialAdImpl.showAd();
        }
    }
}
