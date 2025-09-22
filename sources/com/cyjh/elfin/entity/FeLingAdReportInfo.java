package com.cyjh.elfin.entity;

import org.litepal.b.e;

public class FeLingAdReportInfo extends e {
    public String adPid;
    public String apkPageName;
    public int postState;
    public int state;
    public int type;
    private String url;

    public FeLingAdReportInfo(String str, String str2, int i, int i2, int i3) {
        this.adPid = str;
        this.url = str2;
        this.type = i;
        this.state = i2;
        this.postState = i3;
    }

    public String getAdPid() {
        return this.adPid;
    }

    public String getApkPageName() {
        return this.apkPageName;
    }

    public int getPostState() {
        return this.postState;
    }

    public int getState() {
        return this.state;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setAdPid(String str) {
        this.adPid = str;
    }

    public void setApkPageName(String str) {
        this.apkPageName = str;
    }

    public void setPostState(int i) {
        this.postState = i;
    }

    public void setState(int i) {
        this.state = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
