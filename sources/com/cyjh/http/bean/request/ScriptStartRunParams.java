package com.cyjh.http.bean.request;

import android.os.Parcel;
import android.os.Parcelable;

public class ScriptStartRunParams extends BaseRequestValueInfo {
    public static final Parcelable.Creator<ScriptStartRunParams> CREATOR = new Parcelable.Creator<ScriptStartRunParams>() {
        public final ScriptStartRunParams createFromParcel(Parcel parcel) {
            return new ScriptStartRunParams(parcel);
        }

        public final ScriptStartRunParams[] newArray(int i) {
            return new ScriptStartRunParams[i];
        }
    };
    public String RegCode;
    public String ScriptId;

    protected ScriptStartRunParams(Parcel parcel) {
        super(parcel);
        this.RegCode = parcel.readString();
    }

    public ScriptStartRunParams(BaseRequestValueInfo baseRequestValueInfo) {
        super(baseRequestValueInfo);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ScriptStartRunParams{TemplateFileId=" + this.TemplateFileId + ", TemplateVersion='" + this.TemplateVersion + '\'' + ", AppId=" + this.AppId + ", AppVersion='" + this.AppVersion + '\'' + ", DeviceId='" + this.DeviceId + '\'' + ", ClientTimestamp=" + this.ClientTimestamp + ", IsRedFinger=" + this.IsRedFinger + ", DeviceCode='" + this.DeviceCode + '\'' + ", AppInfo='" + this.AppInfo + '\'' + ", V='" + this.V + '\'' + ", RegCode='" + this.RegCode + '\'' + ", ScriptId='" + this.ScriptId + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.RegCode);
    }
}
