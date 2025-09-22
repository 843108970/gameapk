package com.cyjh.http.bean.response;

import android.os.Parcel;
import android.os.Parcelable;

public class BackgroundSetAdInfo implements Parcelable {
    public static final Parcelable.Creator<BackgroundSetAdInfo> CREATOR = new Parcelable.Creator<BackgroundSetAdInfo>() {
        public final BackgroundSetAdInfo createFromParcel(Parcel parcel) {
            return new BackgroundSetAdInfo(parcel);
        }

        public final BackgroundSetAdInfo[] newArray(int i) {
            return new BackgroundSetAdInfo[i];
        }
    };
    public int AdType;
    public long Id;
    public String ImageUrl;
    public String LinkUrl;
    public int OpenMethod;
    public double Probability;
    public int Sequence;
    public String Title;

    public BackgroundSetAdInfo() {
    }

    protected BackgroundSetAdInfo(Parcel parcel) {
        this.Title = parcel.readString();
        this.AdType = parcel.readInt();
        this.Id = parcel.readLong();
        this.ImageUrl = parcel.readString();
        this.LinkUrl = parcel.readString();
        this.OpenMethod = parcel.readInt();
        this.Sequence = parcel.readInt();
        this.Probability = parcel.readDouble();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Title);
        parcel.writeInt(this.AdType);
        parcel.writeLong(this.Id);
        parcel.writeString(this.ImageUrl);
        parcel.writeString(this.LinkUrl);
        parcel.writeInt(this.OpenMethod);
        parcel.writeInt(this.Sequence);
        parcel.writeDouble(this.Probability);
    }
}
