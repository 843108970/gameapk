package com.iflytek.voiceads.conn;

import android.view.View;

public abstract class BaseDataRef {
    public abstract void downloadApp();

    public abstract int getActionType();

    public abstract String getAdSourceMark();

    public abstract String getBrand();

    public abstract String getContent();

    public abstract String getCtatext();

    public abstract String getDesc();

    public abstract String getIconUrl();

    public abstract String getImgUrl();

    public abstract String getRequestID();

    public abstract int getTemplateID();

    public abstract String getTitle();

    public abstract boolean isExposured();

    public abstract boolean onClick(View view);

    public abstract boolean onExposure(View view);

    public abstract void showIntroduce();
}
