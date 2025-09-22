package com.cyjh.http.bean.response;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class NoticeListBean implements Parcelable {
    public static final Parcelable.Creator<NoticeListBean> CREATOR = new Parcelable.Creator<NoticeListBean>() {
        public final NoticeListBean createFromParcel(Parcel parcel) {
            return new NoticeListBean(parcel);
        }

        public final NoticeListBean[] newArray(int i) {
            return new NoticeListBean[i];
        }
    };
    public List<NoticeBean> NoticeList;

    protected NoticeListBean(Parcel parcel) {
        this.NoticeList = parcel.createTypedArrayList(NoticeBean.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.NoticeList);
    }
}
