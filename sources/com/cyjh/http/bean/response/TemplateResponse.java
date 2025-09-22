package com.cyjh.http.bean.response;

import android.os.Parcel;
import android.os.Parcelable;

public class TemplateResponse implements Parcelable {
    public static final Parcelable.Creator<TemplateResponse> CREATOR = new Parcelable.Creator<TemplateResponse>() {
        public final TemplateResponse createFromParcel(Parcel parcel) {
            return new TemplateResponse(parcel);
        }

        public final TemplateResponse[] newArray(int i) {
            return new TemplateResponse[i];
        }
    };
    public long ClientTimestamp;
    public int HeartbeatIntervalSecond;
    public int HeartbeatInvalidTimes;
    public String Remark;
    public long ServerTimestamp;
    public int Status;
    public int TemplateType;

    public TemplateResponse() {
    }

    protected TemplateResponse(Parcel parcel) {
        this.TemplateType = parcel.readInt();
        this.Status = parcel.readInt();
        this.Remark = parcel.readString();
        this.HeartbeatIntervalSecond = parcel.readInt();
        this.HeartbeatInvalidTimes = parcel.readInt();
        this.ClientTimestamp = parcel.readLong();
        this.ServerTimestamp = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.TemplateType);
        parcel.writeInt(this.Status);
        parcel.writeString(this.Remark);
        parcel.writeInt(this.HeartbeatIntervalSecond);
        parcel.writeInt(this.HeartbeatInvalidTimes);
        parcel.writeLong(this.ClientTimestamp);
        parcel.writeLong(this.ServerTimestamp);
    }
}
