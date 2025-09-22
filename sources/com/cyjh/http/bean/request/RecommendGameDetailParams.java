package com.cyjh.http.bean.request;

import android.os.Parcel;
import android.os.Parcelable;

public class RecommendGameDetailParams extends BaseRequestValueInfo implements Parcelable {
    public static final Parcelable.Creator<RecommendGameDetailParams> CREATOR = new Parcelable.Creator<RecommendGameDetailParams>() {
        public final RecommendGameDetailParams createFromParcel(Parcel parcel) {
            return new RecommendGameDetailParams(parcel);
        }

        public final RecommendGameDetailParams[] newArray(int i) {
            return new RecommendGameDetailParams[i];
        }
    };
    public long GameId;

    protected RecommendGameDetailParams(Parcel parcel) {
        super(parcel);
        this.GameId = parcel.readLong();
    }

    public RecommendGameDetailParams(BaseRequestValueInfo baseRequestValueInfo) {
        super(baseRequestValueInfo);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "RecommendGameDetailParams{TemplateFileId=" + this.TemplateFileId + ", GameId=" + this.GameId + ", TemplateVersion='" + this.TemplateVersion + '\'' + ", AppId=" + this.AppId + ", AppVersion='" + this.AppVersion + '\'' + ", DeviceId='" + this.DeviceId + '\'' + ", ClientTimestamp=" + this.ClientTimestamp + ", IsRedFinger=" + this.IsRedFinger + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.GameId);
    }
}
