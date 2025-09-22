package com.cyjh.http.bean.response;

import android.os.Parcel;
import android.os.Parcelable;

public class RegCodeStatusInfo implements Parcelable {
    public static final Parcelable.Creator<RegCodeStatusInfo> CREATOR = new Parcelable.Creator<RegCodeStatusInfo>() {
        public final RegCodeStatusInfo createFromParcel(Parcel parcel) {
            return new RegCodeStatusInfo(parcel);
        }

        public final RegCodeStatusInfo[] newArray(int i) {
            return new RegCodeStatusInfo[i];
        }
    };
    public String regCode;
    public int status;

    public RegCodeStatusInfo() {
    }

    protected RegCodeStatusInfo(Parcel parcel) {
        this.regCode = parcel.readString();
        this.status = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "RegCodeStatusInfo{regCode='" + this.regCode + '\'' + ", status=" + this.status + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.regCode);
        parcel.writeInt(this.status);
    }
}
