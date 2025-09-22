package com.cyjh.http.bean.request;

import android.os.Parcel;
import android.os.Parcelable;

public class UpdateRequestInfo extends BaseRequestValueInfo {
    public static final Parcelable.Creator<UpdateRequestInfo> CREATOR = new Parcelable.Creator<UpdateRequestInfo>() {
        public final UpdateRequestInfo createFromParcel(Parcel parcel) {
            return new UpdateRequestInfo(parcel);
        }

        public final UpdateRequestInfo[] newArray(int i) {
            return new UpdateRequestInfo[i];
        }
    };
    public String DeviceName;
    public int IsScriptHotUpgrade;
    public String ScriptId;
    public int ScriptVersion;

    public UpdateRequestInfo() {
    }

    protected UpdateRequestInfo(Parcel parcel) {
        super(parcel);
        this.ScriptId = parcel.readString();
        this.DeviceName = parcel.readString();
        this.ScriptVersion = parcel.readInt();
        this.IsScriptHotUpgrade = parcel.readInt();
    }

    public UpdateRequestInfo(BaseRequestValueInfo baseRequestValueInfo) {
        super(baseRequestValueInfo);
    }

    public static Parcelable.Creator<UpdateRequestInfo> getCREATOR() {
        return CREATOR;
    }

    public int describeContents() {
        return 0;
    }

    public String getDeviceName() {
        return this.DeviceName;
    }

    public int getIsScriptHotUpgrade() {
        return this.IsScriptHotUpgrade;
    }

    public String getScriptId() {
        return this.ScriptId;
    }

    public int getScriptVersion() {
        return this.ScriptVersion;
    }

    public void setDeviceName(String str) {
        this.DeviceName = str;
    }

    public void setIsScriptHotUpgrade(int i) {
        this.IsScriptHotUpgrade = i;
    }

    public void setScriptId(String str) {
        this.ScriptId = str;
    }

    public void setScriptVersion(int i) {
        this.ScriptVersion = i;
    }

    public String toString() {
        return "UpdateRequestInfo{TemplateFileId=" + this.TemplateFileId + ", TemplateVersion='" + this.TemplateVersion + '\'' + ", AppId=" + this.AppId + ", AppVersion='" + this.AppVersion + '\'' + ", DeviceId='" + this.DeviceId + '\'' + ", ClientTimestamp=" + this.ClientTimestamp + ", IsRedFinger=" + this.IsRedFinger + ", DeviceCode='" + this.DeviceCode + '\'' + ", AppInfo='" + this.AppInfo + '\'' + ", ScriptId='" + this.ScriptId + '\'' + ", DeviceName='" + this.DeviceName + '\'' + ", ScriptVersion='" + this.ScriptVersion + '\'' + ", IsScriptHotUpgrade='" + this.IsScriptHotUpgrade + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.ScriptId);
        parcel.writeString(this.DeviceName);
        parcel.writeInt(this.ScriptVersion);
        parcel.writeInt(this.IsScriptHotUpgrade);
    }
}
