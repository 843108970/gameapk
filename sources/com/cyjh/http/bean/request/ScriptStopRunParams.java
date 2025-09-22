package com.cyjh.http.bean.request;

import android.os.Parcel;
import android.os.Parcelable;

public class ScriptStopRunParams extends BaseRequestValueInfo {
    public static final Parcelable.Creator<ScriptStopRunParams> CREATOR = new Parcelable.Creator<ScriptStopRunParams>() {
        public final ScriptStopRunParams createFromParcel(Parcel parcel) {
            return new ScriptStopRunParams(parcel);
        }

        public final ScriptStopRunParams[] newArray(int i) {
            return new ScriptStopRunParams[i];
        }
    };
    public String RunGuid;

    protected ScriptStopRunParams(Parcel parcel) {
        super(parcel);
        this.RunGuid = parcel.readString();
    }

    public ScriptStopRunParams(BaseRequestValueInfo baseRequestValueInfo) {
        super(baseRequestValueInfo);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ScriptStopRunParams{RunGuid='" + this.RunGuid + '\'' + ", TemplateFileId=" + this.TemplateFileId + ", TemplateVersion='" + this.TemplateVersion + '\'' + ", AppId=" + this.AppId + ", AppVersion='" + this.AppVersion + '\'' + ", DeviceId='" + this.DeviceId + '\'' + ", ClientTimestamp=" + this.ClientTimestamp + ", IsRedFinger=" + this.IsRedFinger + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.RunGuid);
    }
}
