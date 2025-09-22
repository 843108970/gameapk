package com.cyjh.http.bean.request;

import android.os.Parcel;
import android.os.Parcelable;

public class RecommendGameListParams extends BaseRequestValueInfo implements Parcelable {
    public static final Parcelable.Creator<RecommendGameListParams> CREATOR = new Parcelable.Creator<RecommendGameListParams>() {
        public final RecommendGameListParams createFromParcel(Parcel parcel) {
            return new RecommendGameListParams(parcel);
        }

        public final RecommendGameListParams[] newArray(int i) {
            return new RecommendGameListParams[i];
        }
    };
    public int CurrentPage;
    public int PageSize;

    protected RecommendGameListParams(Parcel parcel) {
        super(parcel);
        this.CurrentPage = parcel.readInt();
        this.PageSize = parcel.readInt();
    }

    public RecommendGameListParams(BaseRequestValueInfo baseRequestValueInfo) {
        super(baseRequestValueInfo);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "RecommendGameListParams{TemplateFileId=" + this.TemplateFileId + ", CurrentPage=" + this.CurrentPage + ", PageSize=" + this.PageSize + ", TemplateVersion='" + this.TemplateVersion + '\'' + ", AppId=" + this.AppId + ", AppVersion='" + this.AppVersion + '\'' + ", DeviceId='" + this.DeviceId + '\'' + ", ClientTimestamp=" + this.ClientTimestamp + ", IsRedFinger=" + this.IsRedFinger + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.CurrentPage);
        parcel.writeInt(this.PageSize);
    }
}
