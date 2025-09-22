package com.cyjh.http.bean.request;

import android.os.Parcel;
import android.os.Parcelable;

public class NoticeDetailsRequestParams extends BaseRequestValueInfo {
    public static final Parcelable.Creator<NoticeDetailsRequestParams> CREATOR = new Parcelable.Creator<NoticeDetailsRequestParams>() {
        public final NoticeDetailsRequestParams createFromParcel(Parcel parcel) {
            return new NoticeDetailsRequestParams(parcel);
        }

        public final NoticeDetailsRequestParams[] newArray(int i) {
            return new NoticeDetailsRequestParams[i];
        }
    };
    public long NoticeId;

    protected NoticeDetailsRequestParams(Parcel parcel) {
        super(parcel);
        this.NoticeId = parcel.readLong();
    }

    public NoticeDetailsRequestParams(BaseRequestValueInfo baseRequestValueInfo) {
        super(baseRequestValueInfo);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NoticeDetailsRequestParams{NoticeId=" + this.NoticeId + ", TemplateFileId=" + this.TemplateFileId + ", TemplateVersion='" + this.TemplateVersion + '\'' + ", AppId=" + this.AppId + ", AppVersion='" + this.AppVersion + '\'' + ", DeviceId='" + this.DeviceId + '\'' + ", ClientTimestamp=" + this.ClientTimestamp + ", IsRedFinger=" + this.IsRedFinger + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.NoticeId);
    }
}
