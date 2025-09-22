package com.cyjh.http.bean.request;

import android.os.Parcel;
import android.os.Parcelable;

public class ChannelRequestInfo extends BaseRequestValueInfo {
    public static final Parcelable.Creator<ChannelRequestInfo> CREATOR = new Parcelable.Creator<ChannelRequestInfo>() {
        public final ChannelRequestInfo createFromParcel(Parcel parcel) {
            return new ChannelRequestInfo(parcel);
        }

        public final ChannelRequestInfo[] newArray(int i) {
            return new ChannelRequestInfo[i];
        }
    };
    public String PackageName;
    public String Version;

    protected ChannelRequestInfo(Parcel parcel) {
        super(parcel);
        this.PackageName = parcel.readString();
        this.Version = parcel.readString();
    }

    public ChannelRequestInfo(BaseRequestValueInfo baseRequestValueInfo) {
        super(baseRequestValueInfo);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.PackageName);
        parcel.writeString(this.Version);
    }
}
