package com.cyjh.http.bean.response;

import android.os.Parcel;
import android.os.Parcelable;

public class RecommendGameImageUrlInfo implements Parcelable {
    public static final Parcelable.Creator<RecommendGameImageUrlInfo> CREATOR = new Parcelable.Creator<RecommendGameImageUrlInfo>() {
        public final RecommendGameImageUrlInfo createFromParcel(Parcel parcel) {
            return new RecommendGameImageUrlInfo(parcel);
        }

        public final RecommendGameImageUrlInfo[] newArray(int i) {
            return new RecommendGameImageUrlInfo[i];
        }
    };
    public long Id;
    public String ImageTitle;
    public String ImageUrl;
    public int Sequence;

    protected RecommendGameImageUrlInfo(Parcel parcel) {
        this.Id = parcel.readLong();
        this.ImageTitle = parcel.readString();
        this.ImageUrl = parcel.readString();
        this.Sequence = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.Id);
        parcel.writeString(this.ImageTitle);
        parcel.writeString(this.ImageUrl);
        parcel.writeInt(this.Sequence);
    }
}
