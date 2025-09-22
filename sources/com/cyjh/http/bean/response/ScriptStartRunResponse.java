package com.cyjh.http.bean.response;

import android.os.Parcel;
import android.os.Parcelable;

public class ScriptStartRunResponse implements Parcelable {
    public static final Parcelable.Creator<ScriptStartRunResponse> CREATOR = new Parcelable.Creator<ScriptStartRunResponse>() {
        public final ScriptStartRunResponse createFromParcel(Parcel parcel) {
            return new ScriptStartRunResponse(parcel);
        }

        public final ScriptStartRunResponse[] newArray(int i) {
            return new ScriptStartRunResponse[i];
        }
    };
    public static long sClientTime;
    public int Code;
    public ScriptStartRunInfo Data;
    public String Message;

    protected ScriptStartRunResponse(Parcel parcel) {
        this.Code = parcel.readInt();
        this.Message = parcel.readString();
        this.Data = (ScriptStartRunInfo) parcel.readParcelable(ScriptStartRunInfo.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ScriptStartRunResponse{Code=" + this.Code + ", Message='" + this.Message + '\'' + ", Data=" + this.Data.toString() + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.Code);
        parcel.writeString(this.Message);
        parcel.writeParcelable(this.Data, i);
    }
}
