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

public class IFLYBannerAd extends AdLayout {
    private static Class<?> cIFLYBannerAdImpl = null;
    private static IFLYBannerAd iFLYBannerAdImpl = null;
    private static boolean isClassLoaded = false;

    protected IFLYBannerAd(Context context) {
        super(context);
    }

    public static IFLYBannerAd createBannerAd(Context context, String str) {
        String str2;
        StringBuilder sb;
        try {
            if (!isClassLoaded) {
                cIFLYBannerAdImpl = a.a(context, "com.iflytek.voiceads.IFLYBannerAdImpl");
                isClassLoaded = true;
            }
            IFLYBannerAd iFLYBannerAd = (IFLYBannerAd) cIFLYBannerAdImpl.getMethod("createBannerAd", new Class[]{Context.class, String.class}).invoke((Object) null, new Object[]{context, str});
            iFLYBannerAdImpl = iFLYBannerAd;
            return iFLYBannerAd;
        } catch (NoSuchMethodException e) {
            sb = new StringBuilder("banner:");
            str2 = e.getMessage();
            sb.append(str2);
            SDKLogger.e(sb.toString());
            return new IFLYBannerAd(context);
        } catch (IllegalAccessException e2) {
            sb = new StringBuilder("banner:");
            str2 = e2.getMessage();
            sb.append(str2);
            SDKLogger.e(sb.toString());
            return new IFLYBannerAd(context);
        } catch (InvocationTargetException e3) {
            sb = new StringBuilder("banner:");
            str2 = e3.getMessage();
            sb.append(str2);
            SDKLogger.e(sb.toString());
            return new IFLYBannerAd(context);
        } catch (ClassNotFoundException e4) {
            sb = new StringBuilder("banner:");
            str2 = e4.getMessage();
            sb.append(str2);
            SDKLogger.e(sb.toString());
            return new IFLYBannerAd(context);
        }
    }

    public void loadAd(IFLYAdListener iFLYAdListener) {
        if (iFLYBannerAdImpl == null) {
            SDKLogger.d(SDKConstants.ERROR_INFO_DEX_FILE);
            if (iFLYAdListener != null) {
                iFLYAdListener.onAdFailed(new AdError(ErrorCode.ERROR_INVALID_REQUEST));
                return;
            }
            return;
        }
        iFLYBannerAdImpl.loadAd(iFLYAdListener);
    }

    public void setParameter(String str, Object obj) {
        if (iFLYBannerAdImpl == null) {
            SDKLogger.d(SDKConstants.ERROR_INFO_DEX_FILE);
        } else {
            iFLYBannerAdImpl.setParameter(str, obj);
        }
    }

    public void showAd() {
        if (iFLYBannerAdImpl == null) {
            SDKLogger.d(SDKConstants.ERROR_INFO_DEX_FILE);
        } else {
            iFLYBannerAdImpl.showAd();
        }
    }
}
