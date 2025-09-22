package com.umeng.commonsdk.statistics.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

public class a {

    /* renamed from: com.umeng.commonsdk.statistics.common.a$a  reason: collision with other inner class name */
    private static final class C0056a {

        /* renamed from: a  reason: collision with root package name */
        private final String f3872a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f3873b;

        C0056a(String str, boolean z) {
            this.f3872a = str;
            this.f3873b = z;
        }

        /* access modifiers changed from: private */
        public String b() {
            return this.f3872a;
        }

        public final boolean a() {
            return this.f3873b;
        }
    }

    private static final class b implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        boolean f3874a;

        /* renamed from: b  reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f3875b;

        private b() {
            this.f3874a = false;
            this.f3875b = new LinkedBlockingQueue<>(1);
        }

        public final IBinder a() throws InterruptedException {
            if (this.f3874a) {
                throw new IllegalStateException();
            }
            this.f3874a = true;
            return this.f3875b.take();
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f3875b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    private static final class c implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f3876a;

        public c(IBinder iBinder) {
            this.f3876a = iBinder;
        }

        public final String a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f3876a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final boolean a(boolean z) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z ? 1 : 0);
                boolean z2 = false;
                this.f3876a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    z2 = true;
                }
                return z2;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final IBinder asBinder() {
            return this.f3876a;
        }
    }

    public static String a(Context context) {
        try {
            C0056a b2 = b(context);
            if (b2 == null) {
                return null;
            }
            return b2.b();
        } catch (Exception unused) {
            return null;
        }
    }

    private static C0056a b(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            b bVar = new b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, bVar, 1)) {
                try {
                    c cVar = new c(bVar.a());
                    C0056a aVar = new C0056a(cVar.a(), cVar.a(true));
                    context.unbindService(bVar);
                    return aVar;
                } catch (Exception e) {
                    throw e;
                } catch (Throwable th) {
                    context.unbindService(bVar);
                    throw th;
                }
            } else {
                throw new IOException("Google Play connection failed");
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
