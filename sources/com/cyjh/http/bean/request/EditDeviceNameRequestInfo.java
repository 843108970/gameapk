package com.cyjh.http.bean.request;

import android.os.Parcel;
import android.os.Parcelable;

public class EditDeviceNameRequestInfo extends BaseRequestValueInfo {
    public static final Parcelable.Creator<EditDeviceNameRequestInfo> CREATOR = new Parcelable.Creator<EditDeviceNameRequestInfo>() {
        public final EditDeviceNameRequestInfo createFromParcel(Parcel parcel) {
            return new EditDeviceNameRequestInfo(parcel);
        }

        public final EditDeviceNameRequestInfo[] newArray(int i) {
            return new EditDeviceNameRequestInfo[i];
        }
    };
    public String DeviceName;
    public String ScriptId;

    protected EditDeviceNameRequestInfo(Parcel parcel) {
        super(parcel);
        this.ScriptId = parcel.readString();
        this.DeviceName = parcel.readString();
    }

    public EditDeviceNameRequestInfo(BaseRequestValueInfo baseRequestValueInfo) {
        super(baseRequestValueInfo);
    }

    public static Parcelable.Creator<EditDeviceNameRequestInfo> getCREATOR() {
        return CREATOR;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "EditDeviceNameRequestInfo{TemplateFileId=" + this.TemplateFileId + ", TemplateVersion='" + this.TemplateVersion + '\'' + ", AppId=" + this.AppId + ", AppVersion='" + this.AppVersion + '\'' + ", DeviceId='" + this.DeviceId + '\'' + ", ClientTimestamp=" + this.ClientTimestamp + ", IsRedFinger=" + this.IsRedFinger + ", DeviceCode='" + this.DeviceCode + '\'' + ", AppInfo='" + this.AppInfo + '\'' + ", ScriptId='" + this.ScriptId + '\'' + ", DeviceName='" + this.DeviceName + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.ScriptId);
        parcel.writeString(this.DeviceName);
    }
}
