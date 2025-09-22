package com.cyjh.elfin.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class BestResolution implements Parcelable {
    public static final Parcelable.Creator<BestResolution> CREATOR = new Parcelable.Creator<BestResolution>() {
        public final BestResolution createFromParcel(Parcel parcel) {
            return new BestResolution(parcel.readInt(), parcel.readInt());
        }

        public final BestResolution[] newArray(int i) {
            return new BestResolution[i];
        }
    };
    private int X;
    private int Y;

    public BestResolution() {
    }

    public BestResolution(int i, int i2) {
        this.X = i;
        this.Y = i2;
    }

    public int describeContents() {
        return 0;
    }

    public int getX() {
        return this.X;
    }

    public int getY() {
        return this.Y;
    }

    public void setX(int i) {
        this.X = i;
    }

    public void setY(int i) {
        this.Y = i;
    }

    public String toString() {
        return this.X + "X" + this.Y;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.X);
        parcel.writeInt(this.Y);
    }
}
