package com.cyjh.elfin.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class FileVersion implements Parcelable {
    public static final Parcelable.Creator<FileVersion> CREATOR = new Parcelable.Creator<FileVersion>() {
        public final FileVersion createFromParcel(Parcel parcel) {
            return new FileVersion(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        public final FileVersion[] newArray(int i) {
            return new FileVersion[i];
        }
    };
    int atc;
    int mq;
    int prop;
    int rtd;
    int ui;

    public FileVersion() {
    }

    public FileVersion(int i, int i2, int i3, int i4, int i5) {
        this.atc = i;
        this.mq = i2;
        this.prop = i3;
        this.ui = i4;
        this.rtd = i5;
    }

    public int describeContents() {
        return 0;
    }

    public int getAtc() {
        return this.atc;
    }

    public int getMq() {
        return this.mq;
    }

    public int getProp() {
        return this.prop;
    }

    public int getRtd() {
        return this.rtd;
    }

    public int getUi() {
        return this.ui;
    }

    public void setAtc(int i) {
        this.atc = i;
    }

    public void setMq(int i) {
        this.mq = i;
    }

    public void setProp(int i) {
        this.prop = i;
    }

    public void setRtd(int i) {
        this.rtd = i;
    }

    public void setUI(int i) {
        this.ui = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.atc);
        parcel.writeInt(this.mq);
        parcel.writeInt(this.prop);
        parcel.writeInt(this.ui);
        parcel.writeInt(this.rtd);
    }
}
