package com.cyjh.http.bean.request;

import android.os.Parcel;
import android.os.Parcelable;

public class DdyStatisticsRequestParamsInfo extends BaseRequestValueInfo {
    public static final Parcelable.Creator<DdyStatisticsRequestParamsInfo> CREATOR = new Parcelable.Creator<DdyStatisticsRequestParamsInfo>() {
        public final DdyStatisticsRequestParamsInfo createFromParcel(Parcel parcel) {
            return new DdyStatisticsRequestParamsInfo(parcel);
        }

        public final DdyStatisticsRequestParamsInfo[] newArray(int i) {
            return new DdyStatisticsRequestParamsInfo[i];
        }
    };
    public int IsChargeStatistics;
    public int IsDDYun;

    protected DdyStatisticsRequestParamsInfo(Parcel parcel) {
        super(parcel);
        this.IsDDYun = parcel.readInt();
        this.IsChargeStatistics = parcel.readInt();
    }

    public DdyStatisticsRequestParamsInfo(BaseRequestValueInfo baseRequestValueInfo) {
        super(baseRequestValueInfo);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "StatisticsRequestParamsInfo{IsDDYun=" + this.IsDDYun + "IsChargeStatistics=" + this.IsChargeStatistics + ", TemplateFileId=" + this.TemplateFileId + ", TemplateVersion='" + this.TemplateVersion + '\'' + ", AppId=" + this.AppId + ", AppVersion='" + this.AppVersion + '\'' + ", DeviceId='" + this.DeviceId + '\'' + ", ClientTimestamp=" + this.ClientTimestamp + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.IsDDYun);
        parcel.writeInt(this.IsChargeStatistics);
    }
}
