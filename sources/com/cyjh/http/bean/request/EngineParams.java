package com.cyjh.http.bean.request;

import android.os.Parcel;
import android.os.Parcelable;

public class EngineParams extends BaseRequestValueInfo implements Parcelable {
    public static final Parcelable.Creator<EngineParams> CREATOR = new Parcelable.Creator<EngineParams>() {
        public final EngineParams createFromParcel(Parcel parcel) {
            return new EngineParams(parcel);
        }

        public final EngineParams[] newArray(int i) {
            return new EngineParams[i];
        }
    };
    public String BaseURL;
    public String PackageName;
    public String PayAppId;
    public boolean ScriptType;
    public String[] authDesKeys;

    protected EngineParams(Parcel parcel) {
        super(parcel);
        this.PackageName = parcel.readString();
        this.BaseURL = parcel.readString();
        this.PayAppId = parcel.readString();
        this.ScriptType = parcel.readByte() != 0;
        this.authDesKeys = parcel.createStringArray();
    }

    public EngineParams(BaseRequestValueInfo baseRequestValueInfo) {
        super(baseRequestValueInfo);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.PackageName);
        parcel.writeString(this.BaseURL);
        parcel.writeString(this.PayAppId);
        parcel.writeByte(this.ScriptType ? (byte) 1 : 0);
        parcel.writeStringArray(this.authDesKeys);
    }
}
