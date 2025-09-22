package com.cyjh.elfin.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class RootRelatedEntity implements Parcelable {
    public static final Parcelable.Creator<RootRelatedEntity> CREATOR = new Parcelable.Creator<RootRelatedEntity>() {
        public final RootRelatedEntity createFromParcel(Parcel parcel) {
            return new RootRelatedEntity(parcel);
        }

        public final RootRelatedEntity[] newArray(int i) {
            return new RootRelatedEntity[i];
        }
    };
    public String Code;
    public RootRelatedData Data;
    public String Msg;

    public static class RootRelatedData implements Parcelable {
        public static final Parcelable.Creator<RootRelatedData> CREATOR = new Parcelable.Creator<RootRelatedData>() {
            public final RootRelatedData createFromParcel(Parcel parcel) {
                return new RootRelatedData(parcel);
            }

            public final RootRelatedData[] newArray(int i) {
                return new RootRelatedData[i];
            }
        };
        public String Id;
        public String Image;
        public String PackageName;
        public String Path;
        public String ScriptName;
        public String Type;

        protected RootRelatedData(Parcel parcel) {
            this.Id = parcel.readString();
            this.Type = parcel.readString();
            this.Image = parcel.readString();
            this.Path = parcel.readString();
            this.PackageName = parcel.readString();
            this.ScriptName = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.Id);
            parcel.writeString(this.Type);
            parcel.writeString(this.Image);
            parcel.writeString(this.Path);
            parcel.writeString(this.PackageName);
            parcel.writeString(this.ScriptName);
        }
    }

    protected RootRelatedEntity(Parcel parcel) {
        this.Code = parcel.readString();
        this.Msg = parcel.readString();
        this.Data = (RootRelatedData) parcel.readParcelable(RootRelatedData.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Code);
        parcel.writeString(this.Msg);
        parcel.writeParcelable(this.Data, i);
    }
}
