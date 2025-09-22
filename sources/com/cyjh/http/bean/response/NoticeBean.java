package com.cyjh.http.bean.response;

import android.os.Parcel;
import android.os.Parcelable;

public class NoticeBean implements Parcelable {
    public static final Parcelable.Creator<NoticeBean> CREATOR = new Parcelable.Creator<NoticeBean>() {
        public final NoticeBean createFromParcel(Parcel parcel) {
            return new NoticeBean(parcel);
        }

        public final NoticeBean[] newArray(int i) {
            return new NoticeBean[i];
        }
    };
    public long ClientTimestamp;
    public int DescriptionType;
    public int IsShowNoticeBar;
    public String NoticeContent;
    public String NoticeDescription;
    public long NoticeId;
    public long NoticeTime;
    public String NoticeTitle;
    public long ServerTimestamp;

    public NoticeBean() {
    }

    protected NoticeBean(Parcel parcel) {
        this.NoticeTitle = parcel.readString();
        this.NoticeDescription = parcel.readString();
        this.NoticeId = parcel.readLong();
        this.DescriptionType = parcel.readInt();
        this.NoticeTime = parcel.readLong();
        this.NoticeContent = parcel.readString();
        this.IsShowNoticeBar = parcel.readInt();
        this.ClientTimestamp = parcel.readLong();
        this.ServerTimestamp = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.NoticeTitle);
        parcel.writeString(this.NoticeDescription);
        parcel.writeLong(this.NoticeId);
        parcel.writeInt(this.DescriptionType);
        parcel.writeLong(this.NoticeTime);
        parcel.writeString(this.NoticeContent);
        parcel.writeInt(this.IsShowNoticeBar);
        parcel.writeLong(this.ClientTimestamp);
        parcel.writeLong(this.ServerTimestamp);
    }
}
