package com.cyjh.http.bean.request;

import android.os.Parcel;
import android.os.Parcelable;

public class DomainNameRequestParamsInfo extends BaseRequestValueInfo {
    public static final Parcelable.Creator<DomainNameRequestParamsInfo> CREATOR = new Parcelable.Creator<DomainNameRequestParamsInfo>() {
        public final DomainNameRequestParamsInfo createFromParcel(Parcel parcel) {
            return new DomainNameRequestParamsInfo(parcel);
        }

        public final DomainNameRequestParamsInfo[] newArray(int i) {
            return new DomainNameRequestParamsInfo[i];
        }
    };
    private final int ANDROID_DEVICE = 1;
    public int DeviceType = 1;

    protected DomainNameRequestParamsInfo(Parcel parcel) {
        super(parcel);
        this.DeviceType = parcel.readInt();
    }

    public DomainNameRequestParamsInfo(BaseRequestValueInfo baseRequestValueInfo) {
        super(baseRequestValueInfo);
    }

    public int describeContents() {
        return 0;
    }

    public int getDeviceType() {
        return this.DeviceType;
    }

    public void setDeviceType(int i) {
        this.DeviceType = i;
    }

    public String toString() {
        return "DomainNameRequestParamsInfo{DeviceType=" + this.DeviceType + ", TemplateFileId=" + this.TemplateFileId + ", TemplateVersion='" + this.TemplateVersion + '\'' + ", AppId=" + this.AppId + ", AppVersion='" + this.AppVersion + '\'' + ", DeviceId='" + this.DeviceId + '\'' + ", ClientTimestamp=" + this.ClientTimestamp + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.DeviceType);
    }
}
