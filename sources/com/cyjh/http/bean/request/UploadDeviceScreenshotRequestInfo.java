package com.cyjh.http.bean.request;

import android.os.Parcel;
import android.os.Parcelable;

public class UploadDeviceScreenshotRequestInfo extends BaseRequestValueInfo {
    public static final Parcelable.Creator<UploadDeviceScreenshotRequestInfo> CREATOR = new Parcelable.Creator<UploadDeviceScreenshotRequestInfo>() {
        public final UploadDeviceScreenshotRequestInfo createFromParcel(Parcel parcel) {
            return new UploadDeviceScreenshotRequestInfo(parcel);
        }

        public final UploadDeviceScreenshotRequestInfo[] newArray(int i) {
            return new UploadDeviceScreenshotRequestInfo[i];
        }
    };
    public String ImageOssPath;
    public String ScriptId;

    protected UploadDeviceScreenshotRequestInfo(Parcel parcel) {
        super(parcel);
        this.ScriptId = parcel.readString();
        this.ImageOssPath = parcel.readString();
    }

    public UploadDeviceScreenshotRequestInfo(BaseRequestValueInfo baseRequestValueInfo) {
        super(baseRequestValueInfo);
    }

    public static Parcelable.Creator<UploadDeviceScreenshotRequestInfo> getCREATOR() {
        return CREATOR;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "EditDeviceNameRequestInfo{TemplateFileId=" + this.TemplateFileId + ", TemplateVersion='" + this.TemplateVersion + '\'' + ", AppId=" + this.AppId + ", AppVersion='" + this.AppVersion + '\'' + ", DeviceId='" + this.DeviceId + '\'' + ", ClientTimestamp=" + this.ClientTimestamp + ", IsRedFinger=" + this.IsRedFinger + ", DeviceCode='" + this.DeviceCode + '\'' + ", AppInfo='" + this.AppInfo + '\'' + ", ScriptId='" + this.ScriptId + '\'' + ", ImageOssPath='" + this.ImageOssPath + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.ScriptId);
        parcel.writeString(this.ImageOssPath);
    }
}
