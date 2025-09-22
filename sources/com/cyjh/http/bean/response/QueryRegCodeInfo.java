package com.cyjh.http.bean.response;

import android.os.Parcel;
import android.os.Parcelable;

public class QueryRegCodeInfo implements Parcelable {
    public static final Parcelable.Creator<QueryRegCodeInfo> CREATOR = new Parcelable.Creator<QueryRegCodeInfo>() {
        public final QueryRegCodeInfo createFromParcel(Parcel parcel) {
            return new QueryRegCodeInfo(parcel);
        }

        public final QueryRegCodeInfo[] newArray(int i) {
            return new QueryRegCodeInfo[i];
        }
    };
    public long ClientTimestamp;
    public int IsSuperposeConfirm;
    public long ServerTimestamp;

    public QueryRegCodeInfo() {
    }

    protected QueryRegCodeInfo(Parcel parcel) {
        this.IsSuperposeConfirm = parcel.readInt();
        this.ClientTimestamp = parcel.readLong();
        this.ServerTimestamp = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.IsSuperposeConfirm);
        parcel.writeLong(this.ClientTimestamp);
        parcel.writeLong(this.ServerTimestamp);
    }
}
