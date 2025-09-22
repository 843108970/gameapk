package com.cyjh.http.bean.response;

import android.os.Parcel;
import android.os.Parcelable;

public class FlySettingInfo implements Parcelable {
    public static final Parcelable.Creator<FlySettingInfo> CREATOR = new Parcelable.Creator<FlySettingInfo>() {
        public final FlySettingInfo createFromParcel(Parcel parcel) {
            return new FlySettingInfo(parcel);
        }

        public final FlySettingInfo[] newArray(int i) {
            return new FlySettingInfo[i];
        }
    };
    public int Active;
    public int AdType;
    public String FlyKey;
    public double Probability;

    protected FlySettingInfo(Parcel parcel) {
        this.AdType = parcel.readInt();
        this.FlyKey = parcel.readString();
        this.Active = parcel.readInt();
        this.Probability = parcel.readDouble();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.AdType);
        parcel.writeString(this.FlyKey);
        parcel.writeInt(this.Active);
        parcel.writeDouble(this.Probability);
    }
}
