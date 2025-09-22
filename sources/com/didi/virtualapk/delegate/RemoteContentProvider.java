package com.didi.virtualapk.delegate;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.didi.virtualapk.PluginManager;
import com.didi.virtualapk.internal.LoadedPlugin;
import com.didi.virtualapk.utils.RunUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class RemoteContentProvider extends ContentProvider {
    public static final String KEY_PKG = "pkg";
    public static final String KEY_PLUGIN = "plugin";
    public static final String KEY_URI = "uri";
    public static final String KEY_WRAPPER_URI = "wrapper_uri";
    private static final String TAG = "VA.RemoteContentProvider";
    /* access modifiers changed from: private */
    public static Map<String, ContentProvider> sCachedProviders = new HashMap();

    public static String getAuthority(Context context) {
        return context.getPackageName() + ".VirtualAPK.Provider";
    }

    private ContentProvider getContentProvider(Uri uri) {
        final PluginManager instance = PluginManager.getInstance(getContext());
        String authority = Uri.parse(uri.getQueryParameter(KEY_URI)).getAuthority();
        ContentProvider contentProvider = sCachedProviders.get(authority);
        if (contentProvider != null) {
            return contentProvider;
        }
        synchronized (sCachedProviders) {
            if (instance.getLoadedPlugin(uri.getQueryParameter(KEY_PKG)) == null) {
                try {
                    instance.loadPlugin(new File(uri.getQueryParameter("plugin")));
                } catch (Exception e) {
                    Log.w(TAG, e);
                }
            }
            final ProviderInfo resolveContentProvider = instance.resolveContentProvider(authority, 0);
            if (resolveContentProvider == null) {
                return null;
            }
            final Uri uri2 = uri;
            final String str = authority;
            RunUtil.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        LoadedPlugin loadedPlugin = instance.getLoadedPlugin(uri2.getQueryParameter(RemoteContentProvider.KEY_PKG));
                        ContentProvider contentProvider = (ContentProvider) Class.forName(resolveContentProvider.name).newInstance();
                        contentProvider.attachInfo(loadedPlugin.getPluginContext(), resolveContentProvider);
                        RemoteContentProvider.sCachedProviders.put(str, contentProvider);
                    } catch (Exception e) {
                        Log.w(RemoteContentProvider.TAG, e);
                    }
                }
            }, true);
            ContentProvider contentProvider2 = sCachedProviders.get(authority);
            return contentProvider2;
        }
    }

    public static String getUri(Context context) {
        return "content://" + getAuthority(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
        r1 = getContentProvider(r7.get(0).getUri());
     */
    @android.support.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.content.ContentProviderResult[] applyBatch(java.util.ArrayList<android.content.ContentProviderOperation> r7) throws android.content.OperationApplicationException {
        /*
            r6 = this;
            r0 = 0
            java.lang.Class<android.content.ContentProviderOperation> r1 = android.content.ContentProviderOperation.class
            java.lang.String r2 = "mUri"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ Exception -> 0x004d }
            r2 = 1
            r1.setAccessible(r2)     // Catch:{ Exception -> 0x004d }
            java.util.Iterator r2 = r7.iterator()     // Catch:{ Exception -> 0x004d }
        L_0x0011:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x004d }
            if (r3 == 0) goto L_0x002f
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x004d }
            android.content.ContentProviderOperation r3 = (android.content.ContentProviderOperation) r3     // Catch:{ Exception -> 0x004d }
            android.net.Uri r4 = r3.getUri()     // Catch:{ Exception -> 0x004d }
            java.lang.String r5 = "uri"
            java.lang.String r4 = r4.getQueryParameter(r5)     // Catch:{ Exception -> 0x004d }
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x004d }
            r1.set(r3, r4)     // Catch:{ Exception -> 0x004d }
            goto L_0x0011
        L_0x002f:
            int r1 = r7.size()
            if (r1 <= 0) goto L_0x004a
            java.lang.Object r1 = r7.get(r0)
            android.content.ContentProviderOperation r1 = (android.content.ContentProviderOperation) r1
            android.net.Uri r1 = r1.getUri()
            android.content.ContentProvider r1 = r6.getContentProvider(r1)
            if (r1 == 0) goto L_0x004a
            android.content.ContentProviderResult[] r7 = r1.applyBatch(r7)
            return r7
        L_0x004a:
            android.content.ContentProviderResult[] r7 = new android.content.ContentProviderResult[r0]
            return r7
        L_0x004d:
            android.content.ContentProviderResult[] r7 = new android.content.ContentProviderResult[r0]
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.virtualapk.delegate.RemoteContentProvider.applyBatch(java.util.ArrayList):android.content.ContentProviderResult[]");
    }

    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        ContentProvider contentProvider = getContentProvider(uri);
        Uri parse = Uri.parse(uri.getQueryParameter(KEY_URI));
        if (contentProvider != null) {
            return contentProvider.bulkInsert(parse, contentValuesArr);
        }
        return 0;
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        ContentProvider contentProvider;
        Log.d(TAG, "call " + str + " with extras : " + bundle);
        if (bundle == null || bundle.getString(KEY_WRAPPER_URI) == null || (contentProvider = getContentProvider(Uri.parse(bundle.getString(KEY_WRAPPER_URI)))) == null) {
            return null;
        }
        return contentProvider.call(str, str2, bundle);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        ContentProvider contentProvider = getContentProvider(uri);
        Uri parse = Uri.parse(uri.getQueryParameter(KEY_URI));
        if (contentProvider != null) {
            return contentProvider.delete(parse, str, strArr);
        }
        return 0;
    }

    public String getType(Uri uri) {
        ContentProvider contentProvider = getContentProvider(uri);
        Uri parse = Uri.parse(uri.getQueryParameter(KEY_URI));
        if (contentProvider != null) {
            return contentProvider.getType(parse);
        }
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        ContentProvider contentProvider = getContentProvider(uri);
        return contentProvider != null ? contentProvider.insert(Uri.parse(uri.getQueryParameter(KEY_URI)), contentValues) : uri;
    }

    public boolean onCreate() {
        Log.d(TAG, "onCreate, current thread:" + Thread.currentThread().getName());
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        ContentProvider contentProvider = getContentProvider(uri);
        Uri parse = Uri.parse(uri.getQueryParameter(KEY_URI));
        if (contentProvider != null) {
            return contentProvider.query(parse, strArr, str, strArr2, str2);
        }
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        ContentProvider contentProvider = getContentProvider(uri);
        Uri parse = Uri.parse(uri.getQueryParameter(KEY_URI));
        if (contentProvider != null) {
            return contentProvider.update(parse, contentValues, str, strArr);
        }
        return 0;
    }
}
