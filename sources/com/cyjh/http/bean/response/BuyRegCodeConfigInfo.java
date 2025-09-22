package com.cyjh.http.bean.response;

import android.os.Parcel;
import android.os.Parcelable;

public class BuyRegCodeConfigInfo implements Parcelable {
    public static final Parcelable.Creator<BuyRegCodeConfigInfo> CREATOR = new Parcelable.Creator<BuyRegCodeConfigInfo>() {
        public final BuyRegCodeConfigInfo createFromParcel(Parcel parcel) {
            return new BuyRegCodeConfigInfo(parcel);
        }

        public final BuyRegCodeConfigInfo[] newArray(int i) {
            return new BuyRegCodeConfigInfo[i];
        }
    };
    public String ButtonName;
    public String BuyLinkUrl;

    protected BuyRegCodeConfigInfo(Parcel parcel) {
        this.ButtonName = parcel.readString();
        this.BuyLinkUrl = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.ButtonName);
        parcel.writeString(this.BuyLinkUrl);
    }
}
