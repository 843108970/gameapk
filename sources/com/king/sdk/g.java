package com.king.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public abstract class g extends Binder implements IDFEE16B42C8B2890D8FF2860AF5562B1 {
    private static final String DESCRIPTOR = "com.king.sdk.IDFEE16B42C8B2890D8FF2860AF5562B1";
    static final int TRANSACTION_on088201B3F7D8B2CA1DF5D6AD12CB0C1F = 4;
    static final int TRANSACTION_on0D923A4B87763BA40F853B570EF75D94 = 6;
    static final int TRANSACTION_on19C45B0F9674B131C4BF67981B1CC455 = 7;
    static final int TRANSACTION_on1DC022CD78BE5580705D060873AAEB16 = 9;
    static final int TRANSACTION_on369D7B24CF0870337D9962B9BB11E924 = 3;
    static final int TRANSACTION_on46FE18C9ADFE18C2BC0D43B003F41A66 = 2;
    static final int TRANSACTION_on96EC25C9716D6EFFB8DD7648F16E4FA2 = 1;
    static final int TRANSACTION_onACF4B25418AE4E2D8376A85BD6F0FC17 = 8;
    static final int TRANSACTION_onB9504A9B1263E0D14DFE18C2167427BC = 5;

    public g() {
        attachInterface(this, DESCRIPTOR);
    }

    public static IDFEE16B42C8B2890D8FF2860AF5562B1 asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        return (queryLocalInterface == null || !(queryLocalInterface instanceof IDFEE16B42C8B2890D8FF2860AF5562B1)) ? new h(iBinder) : (IDFEE16B42C8B2890D8FF2860AF5562B1) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: android.content.Intent} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) {
        /*
            r3 = this;
            r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
            r1 = 1
            if (r4 == r0) goto L_0x00f5
            r0 = 0
            r2 = 0
            switch(r4) {
                case 1: goto L_0x00ca;
                case 2: goto L_0x00b3;
                case 3: goto L_0x00a7;
                case 4: goto L_0x0093;
                case 5: goto L_0x0077;
                case 6: goto L_0x0063;
                case 7: goto L_0x004f;
                case 8: goto L_0x003b;
                case 9: goto L_0x0010;
                default: goto L_0x000b;
            }
        L_0x000b:
            boolean r4 = super.onTransact(r4, r5, r6, r7)
            return r4
        L_0x0010:
            java.lang.String r4 = "com.king.sdk.IDFEE16B42C8B2890D8FF2860AF5562B1"
            r5.enforceInterface(r4)
            int r4 = r5.readInt()
            if (r4 == 0) goto L_0x0024
            android.os.Parcelable$Creator r4 = android.content.Intent.CREATOR
            java.lang.Object r4 = r4.createFromParcel(r5)
            r0 = r4
            android.content.Intent r0 = (android.content.Intent) r0
        L_0x0024:
            boolean r4 = r3.on1DC022CD78BE5580705D060873AAEB16(r0)
            r6.writeNoException()
            r6.writeInt(r4)
            if (r0 == 0) goto L_0x0037
            r6.writeInt(r1)
            r0.writeToParcel(r6, r1)
            return r1
        L_0x0037:
            r6.writeInt(r2)
            return r1
        L_0x003b:
            java.lang.String r4 = "com.king.sdk.IDFEE16B42C8B2890D8FF2860AF5562B1"
            r5.enforceInterface(r4)
            java.lang.String r4 = r5.readString()
            java.lang.String r5 = r5.readString()
            r3.onACF4B25418AE4E2D8376A85BD6F0FC17(r4, r5)
            r6.writeNoException()
            return r1
        L_0x004f:
            java.lang.String r4 = "com.king.sdk.IDFEE16B42C8B2890D8FF2860AF5562B1"
            r5.enforceInterface(r4)
            java.lang.String r4 = r5.readString()
            int r5 = r5.readInt()
            r3.on19C45B0F9674B131C4BF67981B1CC455(r4, r5)
            r6.writeNoException()
            return r1
        L_0x0063:
            java.lang.String r4 = "com.king.sdk.IDFEE16B42C8B2890D8FF2860AF5562B1"
            r5.enforceInterface(r4)
            int r4 = r5.readInt()
            int r5 = r5.readInt()
            r3.on0D923A4B87763BA40F853B570EF75D94(r4, r5)
            r6.writeNoException()
            return r1
        L_0x0077:
            java.lang.String r4 = "com.king.sdk.IDFEE16B42C8B2890D8FF2860AF5562B1"
            r5.enforceInterface(r4)
            java.lang.String r4 = r5.readString()
            java.lang.String r7 = r5.readString()
            int r0 = r5.readInt()
            int r5 = r5.readInt()
            r3.onB9504A9B1263E0D14DFE18C2167427BC(r4, r7, r0, r5)
            r6.writeNoException()
            return r1
        L_0x0093:
            java.lang.String r4 = "com.king.sdk.IDFEE16B42C8B2890D8FF2860AF5562B1"
            r5.enforceInterface(r4)
            java.lang.String r4 = r5.readString()
            int r5 = r5.readInt()
            r3.on088201B3F7D8B2CA1DF5D6AD12CB0C1F(r4, r5)
            r6.writeNoException()
            return r1
        L_0x00a7:
            java.lang.String r4 = "com.king.sdk.IDFEE16B42C8B2890D8FF2860AF5562B1"
            r5.enforceInterface(r4)
            r3.on369D7B24CF0870337D9962B9BB11E924()
            r6.writeNoException()
            return r1
        L_0x00b3:
            java.lang.String r4 = "com.king.sdk.IDFEE16B42C8B2890D8FF2860AF5562B1"
            r5.enforceInterface(r4)
            java.lang.String r4 = r5.readString()
            int r5 = r5.readInt()
            if (r5 == 0) goto L_0x00c3
            r2 = 1
        L_0x00c3:
            r3.on46FE18C9ADFE18C2BC0D43B003F41A66(r4, r2)
            r6.writeNoException()
            return r1
        L_0x00ca:
            java.lang.String r4 = "com.king.sdk.IDFEE16B42C8B2890D8FF2860AF5562B1"
            r5.enforceInterface(r4)
            int r4 = r5.readInt()
            if (r4 == 0) goto L_0x00de
            android.os.Parcelable$Creator r4 = android.content.Intent.CREATOR
            java.lang.Object r4 = r4.createFromParcel(r5)
            r0 = r4
            android.content.Intent r0 = (android.content.Intent) r0
        L_0x00de:
            boolean r4 = r3.on96EC25C9716D6EFFB8DD7648F16E4FA2(r0)
            r6.writeNoException()
            r6.writeInt(r4)
            if (r0 == 0) goto L_0x00f1
            r6.writeInt(r1)
            r0.writeToParcel(r6, r1)
            return r1
        L_0x00f1:
            r6.writeInt(r2)
            return r1
        L_0x00f5:
            java.lang.String r4 = "com.king.sdk.IDFEE16B42C8B2890D8FF2860AF5562B1"
            r6.writeString(r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.king.sdk.g.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
