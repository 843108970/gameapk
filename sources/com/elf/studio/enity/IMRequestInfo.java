package com.elf.studio.enity;

import android.os.Parcel;
import android.os.Parcelable;
import com.cyjh.http.bean.request.BaseRequestValueInfo;

public class IMRequestInfo extends BaseRequestValueInfo {
    public static final Parcelable.Creator<IMRequestInfo> CREATOR = new Parcelable.Creator<IMRequestInfo>() {
        private static IMRequestInfo a(Parcel parcel) {
            return new IMRequestInfo(parcel);
        }

        private static IMRequestInfo[] a(int i) {
            return new IMRequestInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IMRequestInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IMRequestInfo[i];
        }
    };
    public String ScriptId;

    public IMRequestInfo() {
    }

    protected IMRequestInfo(Parcel parcel) {
        super(parcel);
        this.ScriptId = parcel.readString();
    }

    public IMRequestInfo(BaseRequestValueInfo baseRequestValueInfo) {
        super(baseRequestValueInfo);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UpdateRequestInfo{TemplateFileId=" + this.TemplateFileId + ", TemplateVersion='" + this.TemplateVersion + '\'' + ", AppId=" + this.AppId + ", AppVersion='" + this.AppVersion + '\'' + ", DeviceId='" + this.DeviceId + '\'' + ", ClientTimestamp=" + this.ClientTimestamp + ", IsRedFinger=" + this.IsRedFinger + ", DeviceCode='" + this.DeviceCode + '\'' + ", AppInfo='" + this.AppInfo + '\'' + ", ScriptId='" + this.ScriptId + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.ScriptId);
    }
}
