package com.cyjh.http.bean.request;

import android.os.Parcel;
import android.os.Parcelable;

public class EditProjectNumberRequestInfo extends BaseRequestValueInfo {
    public static final Parcelable.Creator<EditProjectNumberRequestInfo> CREATOR = new Parcelable.Creator<EditProjectNumberRequestInfo>() {
        public final EditProjectNumberRequestInfo createFromParcel(Parcel parcel) {
            return new EditProjectNumberRequestInfo(parcel);
        }

        public final EditProjectNumberRequestInfo[] newArray(int i) {
            return new EditProjectNumberRequestInfo[i];
        }
    };
    public String ScriptId;
    public String ScriptSettings;
    public String ScriptUI;
    public String ScriptVersion;
    public String StudioProjectKey;

    protected EditProjectNumberRequestInfo(Parcel parcel) {
        super(parcel);
        this.ScriptId = parcel.readString();
        this.StudioProjectKey = parcel.readString();
        this.ScriptVersion = parcel.readString();
        this.ScriptSettings = parcel.readString();
        this.ScriptUI = parcel.readString();
    }

    public EditProjectNumberRequestInfo(BaseRequestValueInfo baseRequestValueInfo) {
        super(baseRequestValueInfo);
    }

    public static Parcelable.Creator<EditProjectNumberRequestInfo> getCREATOR() {
        return CREATOR;
    }

    public int describeContents() {
        return 0;
    }

    public String getScriptId() {
        return this.ScriptId;
    }

    public String getScriptSettings() {
        return this.ScriptSettings;
    }

    public String getScriptUI() {
        return this.ScriptUI;
    }

    public String getScriptVersion() {
        return this.ScriptVersion;
    }

    public String getStudioProjectKey() {
        return this.StudioProjectKey;
    }

    public void setScriptId(String str) {
        this.ScriptId = str;
    }

    public void setScriptSettings(String str) {
        this.ScriptSettings = str;
    }

    public void setScriptUI(String str) {
        this.ScriptUI = str;
    }

    public void setScriptVersion(String str) {
        this.ScriptVersion = str;
    }

    public void setStudioProjectKey(String str) {
        this.StudioProjectKey = str;
    }

    public String toString() {
        return "EditProjectNumberRequestInfo{TemplateFileId=" + this.TemplateFileId + ", TemplateVersion='" + this.TemplateVersion + '\'' + ", AppId=" + this.AppId + ", AppVersion='" + this.AppVersion + '\'' + ", DeviceId='" + this.DeviceId + '\'' + ", ClientTimestamp=" + this.ClientTimestamp + ", IsRedFinger=" + this.IsRedFinger + ", DeviceCode='" + this.DeviceCode + '\'' + ", AppInfo='" + this.AppInfo + '\'' + ", ScriptId='" + this.ScriptId + '\'' + ", StudioProjectKey='" + this.StudioProjectKey + '\'' + ", ScriptVersion='" + this.ScriptVersion + '\'' + ", ScriptSettings='" + this.ScriptSettings + '\'' + ", ScriptUI='" + this.ScriptUI + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.ScriptId);
        parcel.writeString(this.StudioProjectKey);
        parcel.writeString(this.ScriptVersion);
        parcel.writeString(this.ScriptSettings);
        parcel.writeString(this.ScriptUI);
    }
}
