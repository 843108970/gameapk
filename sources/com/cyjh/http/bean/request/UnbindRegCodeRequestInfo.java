package com.cyjh.http.bean.request;

import android.os.Parcel;
import android.os.Parcelable;

public class UnbindRegCodeRequestInfo extends BaseRequestValueInfo {
    public static final Parcelable.Creator<UnbindRegCodeRequestInfo> CREATOR = new Parcelable.Creator<UnbindRegCodeRequestInfo>() {
        public final UnbindRegCodeRequestInfo createFromParcel(Parcel parcel) {
            return new UnbindRegCodeRequestInfo(parcel);
        }

        public final UnbindRegCodeRequestInfo[] newArray(int i) {
            return new UnbindRegCodeRequestInfo[i];
        }
    };
    public String RegCode;

    protected UnbindRegCodeRequestInfo(Parcel parcel) {
        super(parcel);
        this.RegCode = parcel.readString();
    }

    public UnbindRegCodeRequestInfo(BaseRequestValueInfo baseRequestValueInfo) {
        super(baseRequestValueInfo);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.RegCode);
    }
}
