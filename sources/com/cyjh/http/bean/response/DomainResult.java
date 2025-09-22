package com.cyjh.http.bean.response;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class DomainResult implements Parcelable {
    public static final Parcelable.Creator<DomainResult> CREATOR = new Parcelable.Creator<DomainResult>() {
        public final DomainResult createFromParcel(Parcel parcel) {
            return new DomainResult(parcel);
        }

        public final DomainResult[] newArray(int i) {
            return new DomainResult[i];
        }
    };
    private String[] ApiDescKeys;
    private String ApiVersionV;
    private String App2DomainName;
    private String App3DomainName;
    private String AppDomainName;
    private String[] AuthDescKeys;
    private List<PhoneConfig> PhoneConfig;
    private int RedFingerSwitch;

    public DomainResult() {
    }

    protected DomainResult(Parcel parcel) {
        this.AppDomainName = parcel.readString();
        this.App2DomainName = parcel.readString();
        this.App3DomainName = parcel.readString();
        this.RedFingerSwitch = parcel.readInt();
        this.PhoneConfig = parcel.createTypedArrayList(PhoneConfig.CREATOR);
        this.ApiVersionV = parcel.readString();
        this.AuthDescKeys = parcel.createStringArray();
        this.ApiDescKeys = parcel.createStringArray();
    }

    public int describeContents() {
        return 0;
    }

    public String[] getApiDescKeys() {
        return this.ApiDescKeys;
    }

    public String getApiVersionV() {
        return this.ApiVersionV;
    }

    public String getApp2DomainName() {
        return this.App2DomainName;
    }

    public String getApp3DomainName() {
        return this.App3DomainName;
    }

    public String getAppDomainName() {
        return this.AppDomainName;
    }

    public String[] getAuthDescKeys() {
        return this.AuthDescKeys;
    }

    public List<PhoneConfig> getPhoneConfig() {
        return this.PhoneConfig;
    }

    public int getRedFingerSwitch() {
        return this.RedFingerSwitch;
    }

    public void setApiDescKeys(String[] strArr) {
        this.ApiDescKeys = strArr;
    }

    public void setApiVersionV(String str) {
        this.ApiVersionV = str;
    }

    public void setApp2DomainName(String str) {
        this.App2DomainName = str;
    }

    public void setApp3DomainName(String str) {
        this.App3DomainName = str;
    }

    public void setAppDomainName(String str) {
        this.AppDomainName = str;
    }

    public void setAuthDescKeys(String[] strArr) {
        this.AuthDescKeys = strArr;
    }

    public void setPhoneConfig(List<PhoneConfig> list) {
        this.PhoneConfig = list;
    }

    public void setRedFingerSwitch(int i) {
        this.RedFingerSwitch = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.AppDomainName);
        parcel.writeString(this.App2DomainName);
        parcel.writeString(this.App3DomainName);
        parcel.writeInt(this.RedFingerSwitch);
        parcel.writeTypedList(this.PhoneConfig);
        parcel.writeString(this.ApiVersionV);
        parcel.writeStringArray(this.AuthDescKeys);
        parcel.writeStringArray(this.ApiDescKeys);
    }
}
