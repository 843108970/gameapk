package com.alibaba.sdk.android.oss.model;

public class PartETag {
    private String eTag;
    private int partNumber;

    public PartETag(int i, String str) {
        setPartNumber(i);
        setETag(str);
    }

    public String getETag() {
        return this.eTag;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public void setPartNumber(int i) {
        this.partNumber = i;
    }
}
