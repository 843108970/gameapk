package com.cyjh.http.bean.response;

import android.os.Parcel;
import android.os.Parcelable;

public class RegCodeInfoResponse implements Parcelable {
    public static final Parcelable.Creator<RegCodeInfoResponse> CREATOR = new Parcelable.Creator<RegCodeInfoResponse>() {
        public final RegCodeInfoResponse createFromParcel(Parcel parcel) {
            return new RegCodeInfoResponse(parcel);
        }

        public final RegCodeInfoResponse[] newArray(int i) {
            return new RegCodeInfoResponse[i];
        }
    };
    public int Code;
    public QueryRegCodeInfo Data;
    public String Message;

    public RegCodeInfoResponse() {
    }

    public RegCodeInfoResponse(int i, String str) {
        this.Code = i;
        this.Message = str;
    }

    protected RegCodeInfoResponse(Parcel parcel) {
        this.Code = parcel.readInt();
        this.Message = parcel.readString();
        this.Data = (QueryRegCodeInfo) parcel.readParcelable(QueryRegCodeInfo.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.Code);
        parcel.writeString(this.Message);
        parcel.writeParcelable(this.Data, i);
    }
}
