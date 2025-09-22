package com.cyjh.elfin.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class GameSwitchInfo implements Parcelable {
    public static final Parcelable.Creator<GameSwitchInfo> CREATOR = new Parcelable.Creator<GameSwitchInfo>() {
        public final GameSwitchInfo createFromParcel(Parcel parcel) {
            return new GameSwitchInfo(parcel);
        }

        public final GameSwitchInfo[] newArray(int i) {
            return new GameSwitchInfo[i];
        }
    };
    public String Id;
    public String Name;
    public String Path;
    public String Type;

    public GameSwitchInfo() {
    }

    protected GameSwitchInfo(Parcel parcel) {
        this.Id = parcel.readString();
        this.Name = parcel.readString();
        this.Type = parcel.readString();
        this.Path = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "GameSwitchInfo{Id='" + this.Id + '\'' + ", Name='" + this.Name + '\'' + ", Type='" + this.Type + '\'' + ", Path='" + this.Path + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Id);
        parcel.writeString(this.Name);
        parcel.writeString(this.Type);
        parcel.writeString(this.Path);
    }
}
