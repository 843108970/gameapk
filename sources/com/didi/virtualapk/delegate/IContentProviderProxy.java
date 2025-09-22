package com.didi.virtualapk.delegate;

import android.content.Context;
import android.content.IContentProvider;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class IContentProviderProxy implements InvocationHandler {
    private static final String TAG = "VA.IContentProviderProxy";
    private IContentProvider mBase;
    private Context mContext;

    private IContentProviderProxy(Context context, IContentProvider iContentProvider) {
        this.mBase = iContentProvider;
        this.mContext = context;
    }

    private Bundle getBundleParameter(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        for (int i = 0; i < objArr.length; i++) {
            if (objArr[i] instanceof Bundle) {
                return objArr[i];
            }
        }
        return null;
    }

    public static IContentProvider newInstance(Context context, IContentProvider iContentProvider) {
        return (IContentProvider) Proxy.newProxyInstance(iContentProvider.getClass().getClassLoader(), new Class[]{IContentProvider.class}, new IContentProviderProxy(context, iContentProvider));
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void wrapperUri(java.lang.reflect.Method r7, java.lang.Object[] r8) {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            if (r8 == 0) goto L_0x0016
            r2 = 0
        L_0x0005:
            int r3 = r8.length
            if (r2 >= r3) goto L_0x0016
            r3 = r8[r2]
            boolean r3 = r3 instanceof android.net.Uri
            if (r3 == 0) goto L_0x0013
            r3 = r8[r2]
            android.net.Uri r3 = (android.net.Uri) r3
            goto L_0x0018
        L_0x0013:
            int r2 = r2 + 1
            goto L_0x0005
        L_0x0016:
            r3 = r0
            r2 = 0
        L_0x0018:
            java.lang.String r4 = r7.getName()
            java.lang.String r5 = "call"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0036
            android.os.Bundle r0 = r6.getBundleParameter(r8)
            if (r0 == 0) goto L_0x0036
            java.lang.String r4 = "wrapper_uri"
            java.lang.String r4 = r0.getString(r4)
            if (r4 == 0) goto L_0x0036
            android.net.Uri r3 = android.net.Uri.parse(r4)
        L_0x0036:
            if (r3 != 0) goto L_0x0039
            return
        L_0x0039:
            android.content.Context r4 = r6.mContext
            com.didi.virtualapk.PluginManager r4 = com.didi.virtualapk.PluginManager.getInstance(r4)
            java.lang.String r5 = r3.getAuthority()
            android.content.pm.ProviderInfo r1 = r4.resolveContentProvider(r5, r1)
            if (r1 == 0) goto L_0x006b
            java.lang.String r1 = r1.packageName
            com.didi.virtualapk.internal.LoadedPlugin r1 = r4.getLoadedPlugin((java.lang.String) r1)
            android.net.Uri r1 = com.didi.virtualapk.internal.PluginContentResolver.wrapperUri(r1, r3)
            java.lang.String r7 = r7.getName()
            java.lang.String r3 = "call"
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x0069
            java.lang.String r7 = "wrapper_uri"
            java.lang.String r8 = r1.toString()
            r0.putString(r7, r8)
            return
        L_0x0069:
            r8[r2] = r1
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.virtualapk.delegate.IContentProviderProxy.wrapperUri(java.lang.reflect.Method, java.lang.Object[]):void");
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        Log.v(TAG, method.toGenericString() + " : " + Arrays.toString(objArr));
        wrapperUri(method, objArr);
        try {
            return method.invoke(this.mBase, objArr);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }
}
