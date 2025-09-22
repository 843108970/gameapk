package com.cyjh.elfin.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class ResultResponse implements Parcelable {
    public static final Parcelable.Creator<ResultResponse> CREATOR = new Parcelable.Creator<ResultResponse>() {
        public final ResultResponse createFromParcel(Parcel parcel) {
            return new ResultResponse(parcel);
        }

        public final ResultResponse[] newArray(int i) {
            return new ResultResponse[i];
        }
    };
    public String Code;
    public String Msg;

    public ResultResponse() {
    }

    protected ResultResponse(Parcel parcel) {
        this.Code = parcel.readString();
        this.Msg = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Code);
        parcel.writeString(this.Msg);
    }
}
