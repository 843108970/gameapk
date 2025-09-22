package com.cyjh.elfin.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class BindRegCodeResponse implements Parcelable {
    public static final Parcelable.Creator<BindRegCodeResponse> CREATOR = new Parcelable.Creator<BindRegCodeResponse>() {
        public final BindRegCodeResponse createFromParcel(Parcel parcel) {
            return new BindRegCodeResponse(parcel);
        }

        public final BindRegCodeResponse[] newArray(int i) {
            return new BindRegCodeResponse[i];
        }
    };
    public int Code;
    public RegCodeTimeInfo Data;
    public String Message;

    public static class RegCodeTimeInfo implements Parcelable {
        public static final Parcelable.Creator<RegCodeTimeInfo> CREATOR = new Parcelable.Creator<RegCodeTimeInfo>() {
            public final RegCodeTimeInfo createFromParcel(Parcel parcel) {
                return new RegCodeTimeInfo(parcel);
            }

            public final RegCodeTimeInfo[] newArray(int i) {
                return new RegCodeTimeInfo[i];
            }
        };
        public long ClientTimestamp;
        public long ExpireTime;
        public long ServerTimestamp;

        protected RegCodeTimeInfo(Parcel parcel) {
            this.ClientTimestamp = parcel.readLong();
            this.ServerTimestamp = parcel.readLong();
            this.ExpireTime = parcel.readLong();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.ClientTimestamp);
            parcel.writeLong(this.ServerTimestamp);
            parcel.writeLong(this.ExpireTime);
        }
    }

    protected BindRegCodeResponse(Parcel parcel) {
        this.Code = parcel.readInt();
        this.Message = parcel.readString();
        this.Data = (RegCodeTimeInfo) parcel.readParcelable(RegCodeTimeInfo.class.getClassLoader());
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
