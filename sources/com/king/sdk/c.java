package com.king.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public abstract class c extends Binder implements b {
    public static b a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.king.sdk.I2FABB9840C76199A1E170A7C19698595");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new d(iBinder) : (b) queryLocalInterface;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: android.accounts.Account} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: android.accounts.Account} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: android.accounts.Account} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: android.content.ComponentName} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: android.app.Notification} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: type inference failed for: r2v20 */
    /* JADX WARNING: type inference failed for: r2v23 */
    /* JADX WARNING: type inference failed for: r2v24 */
    /* JADX WARNING: type inference failed for: r2v25 */
    /* JADX WARNING: type inference failed for: r2v26 */
    /* JADX WARNING: type inference failed for: r2v27 */
    /* JADX WARNING: type inference failed for: r2v28 */
    /* JADX WARNING: type inference failed for: r2v29 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTransact(int r11, android.os.Parcel r12, android.os.Parcel r13, int r14) {
        /*
            r10 = this;
            r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
            r1 = 1
            if (r11 == r0) goto L_0x0307
            r0 = 0
            r2 = 0
            switch(r11) {
                case 1: goto L_0x02e8;
                case 2: goto L_0x02bd;
                case 3: goto L_0x0292;
                case 4: goto L_0x0282;
                case 5: goto L_0x026a;
                case 6: goto L_0x0252;
                case 7: goto L_0x023a;
                case 8: goto L_0x0217;
                case 9: goto L_0x0200;
                case 10: goto L_0x01f0;
                case 11: goto L_0x01e0;
                case 12: goto L_0x01c3;
                case 13: goto L_0x01ab;
                case 14: goto L_0x0197;
                case 15: goto L_0x0187;
                case 16: goto L_0x0177;
                case 17: goto L_0x0167;
                case 18: goto L_0x014b;
                case 19: goto L_0x013b;
                case 20: goto L_0x012b;
                case 21: goto L_0x0117;
                case 22: goto L_0x0103;
                case 23: goto L_0x00ef;
                case 24: goto L_0x00c8;
                case 25: goto L_0x00b8;
                case 26: goto L_0x00a8;
                case 27: goto L_0x006a;
                case 28: goto L_0x0052;
                case 29: goto L_0x0010;
                default: goto L_0x000b;
            }
        L_0x000b:
            boolean r11 = super.onTransact(r11, r12, r13, r14)
            return r11
        L_0x0010:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            java.lang.String r4 = r12.readString()
            java.lang.String r5 = r12.readString()
            int r6 = r12.readInt()
            byte[] r7 = r12.createByteArray()
            int r11 = r12.readInt()
            if (r11 == 0) goto L_0x0035
            android.os.Parcelable$Creator r11 = android.app.PendingIntent.CREATOR
            java.lang.Object r11 = r11.createFromParcel(r12)
            android.app.PendingIntent r11 = (android.app.PendingIntent) r11
            r8 = r11
            goto L_0x0036
        L_0x0035:
            r8 = r2
        L_0x0036:
            int r11 = r12.readInt()
            if (r11 == 0) goto L_0x0045
            android.os.Parcelable$Creator r11 = android.app.PendingIntent.CREATOR
            java.lang.Object r11 = r11.createFromParcel(r12)
            r2 = r11
            android.app.PendingIntent r2 = (android.app.PendingIntent) r2
        L_0x0045:
            r9 = r2
            r3 = r10
            boolean r11 = r3.a(r4, r5, r6, r7, r8, r9)
            r13.writeNoException()
            r13.writeInt(r11)
            return r1
        L_0x0052:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            java.lang.String r11 = r12.readString()
            java.lang.String r12 = r12.readString()
            boolean r11 = r10.a((java.lang.String) r11, (java.lang.String) r12)
            r13.writeNoException()
            r13.writeInt(r11)
            return r1
        L_0x006a:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            java.lang.String r4 = r12.readString()
            java.lang.String r5 = r12.readString()
            java.lang.String r6 = r12.readString()
            int r11 = r12.readInt()
            if (r11 == 0) goto L_0x008b
            android.os.Parcelable$Creator r11 = android.app.PendingIntent.CREATOR
            java.lang.Object r11 = r11.createFromParcel(r12)
            android.app.PendingIntent r11 = (android.app.PendingIntent) r11
            r7 = r11
            goto L_0x008c
        L_0x008b:
            r7 = r2
        L_0x008c:
            int r11 = r12.readInt()
            if (r11 == 0) goto L_0x009b
            android.os.Parcelable$Creator r11 = android.app.PendingIntent.CREATOR
            java.lang.Object r11 = r11.createFromParcel(r12)
            r2 = r11
            android.app.PendingIntent r2 = (android.app.PendingIntent) r2
        L_0x009b:
            r8 = r2
            r3 = r10
            boolean r11 = r3.a(r4, r5, r6, r7, r8)
            r13.writeNoException()
            r13.writeInt(r11)
            return r1
        L_0x00a8:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            java.lang.String r11 = r12.readString()
            r10.e(r11)
            r13.writeNoException()
            return r1
        L_0x00b8:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            java.lang.String r11 = r10.g()
            r13.writeNoException()
            r13.writeString(r11)
            return r1
        L_0x00c8:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            java.lang.String r11 = r12.readString()
            int r14 = r12.readInt()
            java.lang.String r0 = r12.readString()
            int r3 = r12.readInt()
            if (r3 == 0) goto L_0x00e8
            android.os.Parcelable$Creator r2 = android.app.Notification.CREATOR
            java.lang.Object r12 = r2.createFromParcel(r12)
            r2 = r12
            android.app.Notification r2 = (android.app.Notification) r2
        L_0x00e8:
            r10.a((java.lang.String) r11, (int) r14, (java.lang.String) r0, (android.app.Notification) r2)
            r13.writeNoException()
            return r1
        L_0x00ef:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            android.os.IBinder r11 = r12.readStrongBinder()
            com.king.sdk.IDFEE16B42C8B2890D8FF2860AF5562B1 r11 = com.king.sdk.g.asInterface(r11)
            r10.b((com.king.sdk.IDFEE16B42C8B2890D8FF2860AF5562B1) r11)
            r13.writeNoException()
            return r1
        L_0x0103:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            android.os.IBinder r11 = r12.readStrongBinder()
            com.king.sdk.IDFEE16B42C8B2890D8FF2860AF5562B1 r11 = com.king.sdk.g.asInterface(r11)
            r10.a((com.king.sdk.IDFEE16B42C8B2890D8FF2860AF5562B1) r11)
            r13.writeNoException()
            return r1
        L_0x0117:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            java.lang.String r11 = r12.readString()
            boolean r11 = r10.d(r11)
            r13.writeNoException()
            r13.writeInt(r11)
            return r1
        L_0x012b:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            java.lang.String r11 = r10.f()
            r13.writeNoException()
            r13.writeString(r11)
            return r1
        L_0x013b:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            int r11 = r10.e()
            r13.writeNoException()
            r13.writeInt(r11)
            return r1
        L_0x014b:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            java.lang.String[] r11 = r12.createStringArray()
            int r14 = r12.readInt()
            java.lang.String r0 = r12.readString()
            java.lang.String r12 = r12.readString()
            r10.a((java.lang.String[]) r11, (int) r14, (java.lang.String) r0, (java.lang.String) r12)
            r13.writeNoException()
            return r1
        L_0x0167:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            java.lang.String r11 = r10.d()
            r13.writeNoException()
            r13.writeString(r11)
            return r1
        L_0x0177:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            java.lang.String r11 = r10.c()
            r13.writeNoException()
            r13.writeString(r11)
            return r1
        L_0x0187:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            java.lang.String r11 = r12.readString()
            r10.c(r11)
            r13.writeNoException()
            return r1
        L_0x0197:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            java.lang.String r11 = r12.readString()
            android.os.IBinder r11 = r10.b((java.lang.String) r11)
            r13.writeNoException()
            r13.writeStrongBinder(r11)
            return r1
        L_0x01ab:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            int r11 = r12.readInt()
            int r14 = r12.readInt()
            java.lang.String r12 = r12.readString()
            r10.a((int) r11, (int) r14, (java.lang.String) r12)
            r13.writeNoException()
            return r1
        L_0x01c3:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            java.lang.String r11 = r12.readString()
            android.content.Intent r11 = r10.a((java.lang.String) r11)
            r13.writeNoException()
            if (r11 == 0) goto L_0x01dc
            r13.writeInt(r1)
            r11.writeToParcel(r13, r1)
            return r1
        L_0x01dc:
            r13.writeInt(r0)
            return r1
        L_0x01e0:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            int r11 = r12.readInt()
            r10.a((int) r11)
            r13.writeNoException()
            return r1
        L_0x01f0:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            byte[] r11 = r10.b()
            r13.writeNoException()
            r13.writeByteArray(r11)
            return r1
        L_0x0200:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            java.lang.String r11 = r12.readString()
            int r12 = r12.readInt()
            if (r12 == 0) goto L_0x0210
            r0 = 1
        L_0x0210:
            r10.a((java.lang.String) r11, (boolean) r0)
            r13.writeNoException()
            return r1
        L_0x0217:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            int r11 = r12.readInt()
            if (r11 == 0) goto L_0x022b
            android.os.Parcelable$Creator r11 = android.content.ComponentName.CREATOR
            java.lang.Object r11 = r11.createFromParcel(r12)
            r2 = r11
            android.content.ComponentName r2 = (android.content.ComponentName) r2
        L_0x022b:
            int r11 = r12.readInt()
            int r12 = r12.readInt()
            r10.a((android.content.ComponentName) r2, (int) r11, (int) r12)
            r13.writeNoException()
            return r1
        L_0x023a:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            java.lang.String r11 = r12.readString()
            int r14 = r12.readInt()
            int r12 = r12.readInt()
            r10.a((java.lang.String) r11, (int) r14, (int) r12)
            r13.writeNoException()
            return r1
        L_0x0252:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            java.lang.String r11 = r12.readString()
            android.os.IBinder r14 = r12.readStrongBinder()
            int r12 = r12.readInt()
            r10.a((java.lang.String) r11, (android.os.IBinder) r14, (int) r12)
            r13.writeNoException()
            return r1
        L_0x026a:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            java.lang.String r11 = r12.readString()
            java.lang.String r14 = r12.readString()
            int r12 = r12.readInt()
            r10.a((java.lang.String) r11, (java.lang.String) r14, (int) r12)
            r13.writeNoException()
            return r1
        L_0x0282:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            int r11 = r10.a()
            r13.writeNoException()
            r13.writeInt(r11)
            return r1
        L_0x0292:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            int r11 = r12.readInt()
            if (r11 == 0) goto L_0x02a6
            android.os.Parcelable$Creator r11 = android.accounts.Account.CREATOR
            java.lang.Object r11 = r11.createFromParcel(r12)
            r2 = r11
            android.accounts.Account r2 = (android.accounts.Account) r2
        L_0x02a6:
            java.lang.String r11 = r12.readString()
            java.lang.String r14 = r12.readString()
            java.lang.String r12 = r12.readString()
            int r11 = r10.b(r2, r11, r14, r12)
            r13.writeNoException()
            r13.writeInt(r11)
            return r1
        L_0x02bd:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            int r11 = r12.readInt()
            if (r11 == 0) goto L_0x02d1
            android.os.Parcelable$Creator r11 = android.accounts.Account.CREATOR
            java.lang.Object r11 = r11.createFromParcel(r12)
            r2 = r11
            android.accounts.Account r2 = (android.accounts.Account) r2
        L_0x02d1:
            java.lang.String r11 = r12.readString()
            java.lang.String r14 = r12.readString()
            java.lang.String r12 = r12.readString()
            int r11 = r10.a((android.accounts.Account) r2, (java.lang.String) r11, (java.lang.String) r14, (java.lang.String) r12)
            r13.writeNoException()
            r13.writeInt(r11)
            return r1
        L_0x02e8:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r12.enforceInterface(r11)
            int r11 = r12.readInt()
            if (r11 == 0) goto L_0x02fc
            android.os.Parcelable$Creator r11 = android.accounts.Account.CREATOR
            java.lang.Object r11 = r11.createFromParcel(r12)
            r2 = r11
            android.accounts.Account r2 = (android.accounts.Account) r2
        L_0x02fc:
            java.lang.String r11 = r10.a((android.accounts.Account) r2)
            r13.writeNoException()
            r13.writeString(r11)
            return r1
        L_0x0307:
            java.lang.String r11 = "com.king.sdk.I2FABB9840C76199A1E170A7C19698595"
            r13.writeString(r11)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.king.sdk.c.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
