package com.cyjh.http.bean.response;

import android.os.Parcel;
import android.os.Parcelable;

public class RecommendSettingInfo implements Parcelable {
    public static final Parcelable.Creator<RecommendSettingInfo> CREATOR = new Parcelable.Creator<RecommendSettingInfo>() {
        public final RecommendSettingInfo createFromParcel(Parcel parcel) {
            return new RecommendSettingInfo(parcel);
        }

        public final RecommendSettingInfo[] newArray(int i) {
            return new RecommendSettingInfo[i];
        }
    };
    public int Id;
    public String LinkUrl;
    public String RecommendType;
    public int Sequence;
    public String Title;

    public RecommendSettingInfo() {
    }

    protected RecommendSettingInfo(Parcel parcel) {
        this.Title = parcel.readString();
        this.Id = parcel.readInt();
        this.RecommendType = parcel.readString();
        this.LinkUrl = parcel.readString();
        this.Sequence = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "RecommendSettingInfo{Title='" + this.Title + '\'' + ", Id=" + this.Id + ", RecommendType='" + this.RecommendType + '\'' + ", LinkUrl='" + this.LinkUrl + '\'' + ", Sequence=" + this.Sequence + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Title);
        parcel.writeInt(this.Id);
        parcel.writeString(this.RecommendType);
        parcel.writeString(this.LinkUrl);
        parcel.writeInt(this.Sequence);
    }
}
