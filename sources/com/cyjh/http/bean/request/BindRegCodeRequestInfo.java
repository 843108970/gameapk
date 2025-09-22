package com.cyjh.http.bean.request;

import android.os.Parcel;
import android.os.Parcelable;

public class BindRegCodeRequestInfo extends BaseRequestValueInfo {
    public static final Parcelable.Creator<BindRegCodeRequestInfo> CREATOR = new Parcelable.Creator<BindRegCodeRequestInfo>() {
        public final BindRegCodeRequestInfo createFromParcel(Parcel parcel) {
            return new BindRegCodeRequestInfo(parcel);
        }

        public final BindRegCodeRequestInfo[] newArray(int i) {
            return new BindRegCodeRequestInfo[i];
        }
    };
    public int IsSuperpose;
    public String OldRegCode;
    public String RegCode;

    protected BindRegCodeRequestInfo(Parcel parcel) {
        super(parcel);
        this.RegCode = parcel.readString();
        this.OldRegCode = parcel.readString();
        this.IsSuperpose = parcel.readInt();
    }

    public BindRegCodeRequestInfo(BaseRequestValueInfo baseRequestValueInfo) {
        super(baseRequestValueInfo);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.RegCode);
        parcel.writeString(this.OldRegCode);
        parcel.writeInt(this.IsSuperpose);
    }
}
