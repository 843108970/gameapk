package com.elf.studio.enity;

import android.os.Parcel;
import android.os.Parcelable;

public class IMResultInfo implements Parcelable {
    public static final Parcelable.Creator<IMResultInfo> CREATOR = new Parcelable.Creator<IMResultInfo>() {
        private static IMResultInfo a(Parcel parcel) {
            return new IMResultInfo(parcel);
        }

        private static IMResultInfo[] a(int i) {
            return new IMResultInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IMResultInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IMResultInfo[i];
        }
    };
    public String IMServerHost;
    public int IMServerPort;
    public String IMToken;

    public IMResultInfo() {
    }

    protected IMResultInfo(Parcel parcel) {
        this.IMServerHost = parcel.readString();
        this.IMServerPort = parcel.readInt();
        this.IMToken = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "IMResultInfo{IMServerHost='" + this.IMServerHost + '\'' + ", IMServerPort='" + this.IMServerPort + '\'' + ", IMToken='" + this.IMToken + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.IMServerHost);
        parcel.writeInt(this.IMServerPort);
        parcel.writeString(this.IMToken);
    }
}
