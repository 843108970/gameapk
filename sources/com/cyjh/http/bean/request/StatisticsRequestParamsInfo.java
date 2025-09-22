package com.cyjh.http.bean.request;

import android.os.Parcel;
import android.os.Parcelable;

public class StatisticsRequestParamsInfo extends BaseRequestValueInfo {
    public static final Parcelable.Creator<StatisticsRequestParamsInfo> CREATOR = new Parcelable.Creator<StatisticsRequestParamsInfo>() {
        public final StatisticsRequestParamsInfo createFromParcel(Parcel parcel) {
            return new StatisticsRequestParamsInfo(parcel);
        }

        public final StatisticsRequestParamsInfo[] newArray(int i) {
            return new StatisticsRequestParamsInfo[i];
        }
    };
    public int Action;
    public int BussinessId;
    public int CloudPhoneType;
    public long RelationId;

    protected StatisticsRequestParamsInfo(Parcel parcel) {
        super(parcel);
        this.BussinessId = parcel.readInt();
        this.Action = parcel.readInt();
        this.CloudPhoneType = parcel.readInt();
        this.RelationId = parcel.readLong();
    }

    public StatisticsRequestParamsInfo(BaseRequestValueInfo baseRequestValueInfo) {
        super(baseRequestValueInfo);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "StatisticsRequestParamsInfo{BussinessId=" + this.BussinessId + ", Action=" + this.Action + ", TemplateFileId=" + this.TemplateFileId + ", RelationId=" + this.RelationId + ", CloudPhoneType=" + this.CloudPhoneType + ", TemplateVersion='" + this.TemplateVersion + '\'' + ", AppId=" + this.AppId + ", AppVersion='" + this.AppVersion + '\'' + ", DeviceId='" + this.DeviceId + '\'' + ", ClientTimestamp=" + this.ClientTimestamp + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.BussinessId);
        parcel.writeInt(this.Action);
        parcel.writeInt(this.CloudPhoneType);
        parcel.writeLong(this.RelationId);
    }
}
