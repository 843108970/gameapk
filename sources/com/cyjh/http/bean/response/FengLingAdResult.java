package com.cyjh.http.bean.response;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class FengLingAdResult implements Parcelable {
    public static final Parcelable.Creator<FengLingAdResult> CREATOR = new Parcelable.Creator<FengLingAdResult>() {
        public final FengLingAdResult createFromParcel(Parcel parcel) {
            return new FengLingAdResult(parcel);
        }

        public final FengLingAdResult[] newArray(int i) {
            return new FengLingAdResult[i];
        }
    };
    List<FengLingAdInfo> ads;
    private String callRequestId;
    private int code;
    private String msg;
    private String requestId;

    public FengLingAdResult() {
    }

    protected FengLingAdResult(Parcel parcel) {
        this.code = parcel.readInt();
        this.msg = parcel.readString();
        this.requestId = parcel.readString();
        this.callRequestId = parcel.readString();
        this.ads = parcel.createTypedArrayList(FengLingAdInfo.CREATOR);
    }

    public static Parcelable.Creator<FengLingAdResult> getCREATOR() {
        return CREATOR;
    }

    public int describeContents() {
        return 0;
    }

    public List<FengLingAdInfo> getAds() {
        return this.ads;
    }

    public String getCallRequestId() {
        return this.callRequestId;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setAds(List<FengLingAdInfo> list) {
        this.ads = list;
    }

    public void setCallRequestId(String str) {
        this.callRequestId = str;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.code);
        parcel.writeString(this.msg);
        parcel.writeString(this.requestId);
        parcel.writeString(this.callRequestId);
        parcel.writeTypedList(this.ads);
    }
}
