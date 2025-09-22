package com.cyjh.http.bean.request;

import android.os.Parcel;
import android.os.Parcelable;

public class DeviceInfo implements Parcelable {
    public static final Parcelable.Creator<DeviceInfo> CREATOR = new Parcelable.Creator<DeviceInfo>() {
        public final DeviceInfo createFromParcel(Parcel parcel) {
            return new DeviceInfo(parcel);
        }

        public final DeviceInfo[] newArray(int i) {
            return new DeviceInfo[i];
        }
    };
    public String DeviceCode;
    public String DeviceId;

    public DeviceInfo() {
    }

    protected DeviceInfo(Parcel parcel) {
        this.DeviceCode = parcel.readString();
        this.DeviceId = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.DeviceCode);
        parcel.writeString(this.DeviceId);
    }
}
