package com.cyjh.elfin.entity;

import android.text.TextUtils;
import android.util.Log;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.http.bean.response.BackgroundSetAdInfo;
import com.cyjh.http.bean.response.BuyRegCodeConfigInfo;
import com.cyjh.http.bean.response.FlySettingInfo;
import com.cyjh.http.bean.response.RecommendSettingInfo;
import com.cyjh.http.bean.response.ScriptStartRunInfo;
import java.util.ArrayList;
import java.util.List;

public class ParamsWrap {
    private static final int ILFY_KEY_LENGTH = 32;
    private static final String TAG = "ParamsWrap";
    private static ParamsWrap sParamsWrap;
    private String ScriptEncryptKey;
    public int dailyTryTimes;
    public String engineToken;
    public String feedbackTips;
    public List<BackgroundSetAdInfo> mAdInfos;
    public List<BuyRegCodeConfigInfo> mBuyRegCodeConfigInfos;
    public AppContext mContext;
    public List<FlySettingInfo> mFlySettingInfos;
    public List<RecommendSettingInfo> mRecommendSettingInfos;
    public ScriptStartRunInfo mStartRunResponseInfo;
    public int onceTryMinute;
    public int unbindDeductHours;

    private ParamsWrap() {
    }

    private void cleanCollect() {
        this.mFlySettingInfos = null;
        this.mAdInfos = null;
        this.mRecommendSettingInfos = null;
    }

    public static ParamsWrap getParamsWrap() {
        if (sParamsWrap == null) {
            synchronized (ParamsWrap.class) {
                if (sParamsWrap == null) {
                    sParamsWrap = new ParamsWrap();
                }
            }
        }
        return sParamsWrap;
    }

    public void cleanData() {
        cleanCollect();
        this.mContext = null;
        sParamsWrap = null;
    }

    public void crateCollect() {
        this.mBuyRegCodeConfigInfos = new ArrayList();
        this.mFlySettingInfos = new ArrayList();
        this.mRecommendSettingInfos = new ArrayList();
        this.mAdInfos = new ArrayList();
    }

    public String getScriptEncryptKey() {
        return TextUtils.isEmpty(this.ScriptEncryptKey) ? "" : this.ScriptEncryptKey;
    }

    public void init(AppContext appContext) {
        this.mContext = appContext;
    }

    public void setScriptEncryptKey(String str) {
        Log.i("SplashModel", "scriptEncryptKey:" + str, new Exception());
        this.ScriptEncryptKey = str;
    }
}
