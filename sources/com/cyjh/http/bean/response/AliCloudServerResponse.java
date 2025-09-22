package com.cyjh.http.bean.response;

import android.os.Parcel;
import android.os.Parcelable;

public class AliCloudServerResponse implements Parcelable {
    public static final Parcelable.Creator<AliCloudServerResponse> CREATOR = new Parcelable.Creator<AliCloudServerResponse>() {
        public final AliCloudServerResponse createFromParcel(Parcel parcel) {
            return new AliCloudServerResponse(parcel);
        }

        public final AliCloudServerResponse[] newArray(int i) {
            return new AliCloudServerResponse[i];
        }
    };
    public String AliCloundAccessKeyId;
    public String AliCloundAccessKeySecret;
    public Long AliCloundExpireTime;
    public String AliCloundSecurityToken;
    public long ClientTimestamp;
    public String OssBucket;
    public String OssEndpoint;
    public String OssStoragePath;
    public String OssStudioScreenshotPathF;
    public long ServerTimestamp;

    protected AliCloudServerResponse(Parcel parcel) {
        this.AliCloundAccessKeyId = parcel.readString();
        this.AliCloundAccessKeySecret = parcel.readString();
        this.AliCloundSecurityToken = parcel.readString();
        this.AliCloundExpireTime = parcel.readByte() == 0 ? null : Long.valueOf(parcel.readLong());
        this.OssEndpoint = parcel.readString();
        this.OssBucket = parcel.readString();
        this.OssStoragePath = parcel.readString();
        this.OssStudioScreenshotPathF = parcel.readString();
        this.ClientTimestamp = parcel.readLong();
        this.ServerTimestamp = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.AliCloundAccessKeyId);
        parcel.writeString(this.AliCloundAccessKeySecret);
        parcel.writeString(this.AliCloundSecurityToken);
        if (this.AliCloundExpireTime == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(this.AliCloundExpireTime.longValue());
        }
        parcel.writeString(this.OssEndpoint);
        parcel.writeString(this.OssBucket);
        parcel.writeString(this.OssStoragePath);
        parcel.writeString(this.OssStudioScreenshotPathF);
        parcel.writeLong(this.ClientTimestamp);
        parcel.writeLong(this.ServerTimestamp);
    }
}
