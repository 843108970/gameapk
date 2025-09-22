package com.cyjh.http.bean.response;

import android.os.Parcel;
import android.os.Parcelable;

public class BaseResponseInfo implements Parcelable {
    public static final Parcelable.Creator<BaseResponseInfo> CREATOR = new Parcelable.Creator<BaseResponseInfo>() {
        public final BaseResponseInfo createFromParcel(Parcel parcel) {
            return new BaseResponseInfo(parcel);
        }

        public final BaseResponseInfo[] newArray(int i) {
            return new BaseResponseInfo[i];
        }
    };
    public int Code;
    public String Message;

    public BaseResponseInfo(int i, String str) {
        this.Code = i;
        this.Message = str;
    }

    protected BaseResponseInfo(Parcel parcel) {
        this.Code = parcel.readInt();
        this.Message = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.Code);
        parcel.writeString(this.Message);
    }
}
