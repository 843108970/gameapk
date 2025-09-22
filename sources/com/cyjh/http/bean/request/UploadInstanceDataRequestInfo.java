package com.cyjh.http.bean.request;

import android.os.Parcel;
import android.os.Parcelable;

public class UploadInstanceDataRequestInfo extends BaseRequestValueInfo {
    public static final Parcelable.Creator<UploadInstanceDataRequestInfo> CREATOR = new Parcelable.Creator<UploadInstanceDataRequestInfo>() {
        public final UploadInstanceDataRequestInfo createFromParcel(Parcel parcel) {
            return new UploadInstanceDataRequestInfo(parcel);
        }

        public final UploadInstanceDataRequestInfo[] newArray(int i) {
            return new UploadInstanceDataRequestInfo[i];
        }
    };
    public String InstanceData;
    public String ScriptId;

    protected UploadInstanceDataRequestInfo(Parcel parcel) {
        super(parcel);
        this.ScriptId = parcel.readString();
        this.InstanceData = parcel.readString();
    }

    public UploadInstanceDataRequestInfo(BaseRequestValueInfo baseRequestValueInfo) {
        super(baseRequestValueInfo);
    }

    public static Parcelable.Creator<UploadInstanceDataRequestInfo> getCREATOR() {
        return CREATOR;
    }

    public int describeContents() {
        return 0;
    }

    public String getInstanceData() {
        return this.InstanceData;
    }

    public String getScriptId() {
        return this.ScriptId;
    }

    public void setInstanceData(String str) {
        this.InstanceData = str;
    }

    public void setScriptId(String str) {
        this.ScriptId = str;
    }

    public String toString() {
        return "EditProjectNumberRequestInfo{TemplateFileId=" + this.TemplateFileId + ", TemplateVersion='" + this.TemplateVersion + '\'' + ", AppId=" + this.AppId + ", AppVersion='" + this.AppVersion + '\'' + ", DeviceId='" + this.DeviceId + '\'' + ", ClientTimestamp=" + this.ClientTimestamp + ", IsRedFinger=" + this.IsRedFinger + ", DeviceCode='" + this.DeviceCode + '\'' + ", AppInfo='" + this.AppInfo + '\'' + ", ScriptId='" + this.ScriptId + '\'' + ", InstanceData='" + this.InstanceData + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.ScriptId);
        parcel.writeString(this.InstanceData);
    }
}
