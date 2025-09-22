package com.lidroid.xutils.http.client.multipart.content;

import com.lidroid.xutils.http.client.multipart.MultipartEntity;

public abstract class AbstractContentBody implements ContentBody {
    protected MultipartEntity.CallBackInfo callBackInfo = MultipartEntity.CallBackInfo.DEFAULT;
    private final String mediaType;
    private final String mimeType;
    private final String subType;

    public AbstractContentBody(String str) {
        String str2;
        if (str == null) {
            throw new IllegalArgumentException("MIME type may not be null");
        }
        this.mimeType = str;
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            this.mediaType = str.substring(0, indexOf);
            str2 = str.substring(indexOf + 1);
        } else {
            this.mediaType = str;
            str2 = null;
        }
        this.subType = str2;
    }

    public String getMediaType() {
        return this.mediaType;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getSubType() {
        return this.subType;
    }

    public void setCallBackInfo(MultipartEntity.CallBackInfo callBackInfo2) {
        this.callBackInfo = callBackInfo2;
    }
}
