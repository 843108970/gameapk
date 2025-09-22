package com.cyjh.http.bean.response;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class AppRelatedInfo implements Parcelable {
    public static final Parcelable.Creator<AppRelatedInfo> CREATOR = new Parcelable.Creator<AppRelatedInfo>() {
        public final AppRelatedInfo createFromParcel(Parcel parcel) {
            return new AppRelatedInfo(parcel);
        }

        public final AppRelatedInfo[] newArray(int i) {
            return new AppRelatedInfo[i];
        }
    };
    public int Active;
    public List<BuyRegCodeConfigInfo> BuyRegCodeConfig;
    public int DailyTryTimes;
    public String FeedbackTips;
    public List<FlySettingInfo> FlySetting;
    public int OnceTryMinute;
    public List<RecommendSettingInfo> RecommendSetting;
    public String ScriptKey;
    public int UnbindDeductHours;

    public AppRelatedInfo() {
    }

    protected AppRelatedInfo(Parcel parcel) {
        this.Active = parcel.readInt();
        this.DailyTryTimes = parcel.readInt();
        this.OnceTryMinute = parcel.readInt();
        this.FeedbackTips = parcel.readString();
        this.BuyRegCodeConfig = parcel.createTypedArrayList(BuyRegCodeConfigInfo.CREATOR);
        this.FlySetting = parcel.createTypedArrayList(FlySettingInfo.CREATOR);
        this.RecommendSetting = parcel.createTypedArrayList(RecommendSettingInfo.CREATOR);
        this.ScriptKey = parcel.readString();
        this.UnbindDeductHours = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.Active);
        parcel.writeInt(this.DailyTryTimes);
        parcel.writeInt(this.OnceTryMinute);
        parcel.writeString(this.FeedbackTips);
        parcel.writeTypedList(this.BuyRegCodeConfig);
        parcel.writeTypedList(this.FlySetting);
        parcel.writeTypedList(this.RecommendSetting);
        parcel.writeString(this.ScriptKey);
        parcel.writeInt(this.UnbindDeductHours);
    }
}
