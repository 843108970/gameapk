package com.cyjh.http.bean.request;

import android.os.Parcel;
import android.os.Parcelable;

public class DdyStatisticsData implements Parcelable {
    public static final Parcelable.Creator<DdyStatisticsData> CREATOR = new Parcelable.Creator<DdyStatisticsData>() {
        public final DdyStatisticsData createFromParcel(Parcel parcel) {
            return new DdyStatisticsData(parcel);
        }

        public final DdyStatisticsData[] newArray(int i) {
            return new DdyStatisticsData[i];
        }
    };
    public static final String DAILY_STATISTICS = "Statistics/Daily";
    public DdyStatisticsRequestParamsInfo data;
    public String type;

    protected DdyStatisticsData(Parcel parcel) {
        this.type = parcel.readString();
        this.data = (DdyStatisticsRequestParamsInfo) parcel.readParcelable(DdyStatisticsRequestParamsInfo.class.getClassLoader());
    }

    public DdyStatisticsData(String str, DdyStatisticsRequestParamsInfo ddyStatisticsRequestParamsInfo) {
        this.type = str;
        this.data = ddyStatisticsRequestParamsInfo;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.type);
        parcel.writeParcelable(this.data, i);
    }
}
