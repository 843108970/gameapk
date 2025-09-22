package com.king.sdk;

import android.os.Binder;
import android.os.Parcel;

public abstract class f extends Binder implements e {
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            parcel.enforceInterface("com.king.sdk.IBA2159EDE8B5B1B06F70D35A9630B683");
            parcel.readInt();
            c.a(parcel.readStrongBinder());
            parcel2.writeNoException();
            return true;
        } else if (i != 1598968902) {
            return super.onTransact(i, parcel, parcel2, i2);
        } else {
            parcel2.writeString("com.king.sdk.IBA2159EDE8B5B1B06F70D35A9630B683");
            return true;
        }
    }
}
