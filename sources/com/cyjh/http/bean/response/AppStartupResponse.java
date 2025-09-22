package com.cyjh.http.bean.response;

import android.os.Parcel;
import android.os.Parcelable;

public class AppStartupResponse implements Parcelable {
    public static final Parcelable.Creator<AppStartupResponse> CREATOR = new Parcelable.Creator<AppStartupResponse>() {
        public final AppStartupResponse createFromParcel(Parcel parcel) {
            return new AppStartupResponse(parcel);
        }

        public final AppStartupResponse[] newArray(int i) {
            return new AppStartupResponse[i];
        }
    };
    public AppRelatedInfo AppInfo;
    public AuthorRelatedInfo AuthorInfo;
    public long ClientTimestamp;
    public long ServerTimestamp;

    protected AppStartupResponse(Parcel parcel) {
        this.ClientTimestamp = parcel.readLong();
        this.ServerTimestamp = parcel.readLong();
        this.AuthorInfo = (AuthorRelatedInfo) parcel.readParcelable(AuthorRelatedInfo.class.getClassLoader());
        this.AppInfo = (AppRelatedInfo) parcel.readParcelable(AppRelatedInfo.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.ClientTimestamp);
        parcel.writeLong(this.ServerTimestamp);
        parcel.writeParcelable(this.AuthorInfo, i);
        parcel.writeParcelable(this.AppInfo, i);
    }
}
