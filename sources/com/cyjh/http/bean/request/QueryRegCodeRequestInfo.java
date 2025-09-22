package com.cyjh.http.bean.request;

import android.os.Parcel;
import android.os.Parcelable;

public class QueryRegCodeRequestInfo extends BaseRequestValueInfo {
    public static final Parcelable.Creator<QueryRegCodeRequestInfo> CREATOR = new Parcelable.Creator<QueryRegCodeRequestInfo>() {
        public final QueryRegCodeRequestInfo createFromParcel(Parcel parcel) {
            return new QueryRegCodeRequestInfo(parcel);
        }

        public final QueryRegCodeRequestInfo[] newArray(int i) {
            return new QueryRegCodeRequestInfo[i];
        }
    };
    public String OldRegCode;
    public String RegCode;

    protected QueryRegCodeRequestInfo(Parcel parcel) {
        super(parcel);
        this.RegCode = parcel.readString();
        this.OldRegCode = parcel.readString();
    }

    public QueryRegCodeRequestInfo(BaseRequestValueInfo baseRequestValueInfo) {
        super(baseRequestValueInfo);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.RegCode);
        parcel.writeString(this.OldRegCode);
    }
}
