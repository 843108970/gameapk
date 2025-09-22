package com.cyjh.http.bean.response;

import android.os.Parcel;
import android.os.Parcelable;

public class ScriptStartRunInfo implements Parcelable {
    public static final Parcelable.Creator<ScriptStartRunInfo> CREATOR = new Parcelable.Creator<ScriptStartRunInfo>() {
        public final ScriptStartRunInfo createFromParcel(Parcel parcel) {
            return new ScriptStartRunInfo(parcel);
        }

        public final ScriptStartRunInfo[] newArray(int i) {
            return new ScriptStartRunInfo[i];
        }
    };
    public long ClientTimestamp;
    public int DailyTryTimes;
    public String ExpireTime;
    public int OnceTryMinute;
    public String RunGuid;
    public String ScriptEncryptKey;
    public long ServerTimestamp;

    protected ScriptStartRunInfo(Parcel parcel) {
        this.ClientTimestamp = parcel.readLong();
        this.ServerTimestamp = parcel.readLong();
        this.DailyTryTimes = parcel.readInt();
        this.OnceTryMinute = parcel.readInt();
        this.ExpireTime = parcel.readString();
        this.RunGuid = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ScriptStartRunInfo{ClientTimestamp=" + this.ClientTimestamp + ", ServerTimestamp=" + this.ServerTimestamp + ", DailyTryTimes=" + this.DailyTryTimes + ", OnceTryMinute=" + this.OnceTryMinute + ", ExpireTime='" + this.ExpireTime + '\'' + ", RunGuid='" + this.RunGuid + '\'' + ", ScriptEncryptKey='" + this.ScriptEncryptKey + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.ClientTimestamp);
        parcel.writeLong(this.ServerTimestamp);
        parcel.writeInt(this.DailyTryTimes);
        parcel.writeInt(this.OnceTryMinute);
        parcel.writeString(this.ExpireTime);
        parcel.writeString(this.RunGuid);
    }
}
