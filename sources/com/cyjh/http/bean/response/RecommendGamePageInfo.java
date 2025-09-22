package com.cyjh.http.bean.response;

import android.os.Parcel;
import android.os.Parcelable;

public class RecommendGamePageInfo implements Parcelable {
    public static final Parcelable.Creator<RecommendGamePageInfo> CREATOR = new Parcelable.Creator<RecommendGamePageInfo>() {
        public final RecommendGamePageInfo createFromParcel(Parcel parcel) {
            return new RecommendGamePageInfo(parcel);
        }

        public final RecommendGamePageInfo[] newArray(int i) {
            return new RecommendGamePageInfo[i];
        }
    };
    public int CurrentPage;
    public int DataCount;
    public int IsLastPage;
    public int PageCount;
    public int PageSize;

    protected RecommendGamePageInfo(Parcel parcel) {
        this.CurrentPage = parcel.readInt();
        this.PageSize = parcel.readInt();
        this.PageCount = parcel.readInt();
        this.DataCount = parcel.readInt();
        this.IsLastPage = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.CurrentPage);
        parcel.writeInt(this.PageSize);
        parcel.writeInt(this.PageCount);
        parcel.writeInt(this.DataCount);
        parcel.writeInt(this.IsLastPage);
    }
}
