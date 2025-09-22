package net.grandcentrix.tray.provider;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.cyjh.common.util.s;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import net.grandcentrix.tray.core.OnTrayPreferenceChangeListener;
import net.grandcentrix.tray.core.TrayException;
import net.grandcentrix.tray.core.TrayItem;
import net.grandcentrix.tray.core.TrayLog;
import net.grandcentrix.tray.core.TrayRuntimeException;
import net.grandcentrix.tray.core.TrayStorage;

public class ContentProviderStorage extends TrayStorage {
    public static final String VERSION = "version";
    /* access modifiers changed from: private */
    public final Context mContext;
    WeakHashMap<OnTrayPreferenceChangeListener, Handler> mListeners = new WeakHashMap<>();
    TrayContentObserver mObserver;
    HandlerThread mObserverThread;
    /* access modifiers changed from: private */
    public final TrayProviderHelper mProviderHelper;
    /* access modifiers changed from: private */
    public volatile boolean mRegisteredContentObserver = false;
    /* access modifiers changed from: private */
    public final TrayUri mTrayUri;

    class TrayContentObserver extends ContentObserver {
        public TrayContentObserver(Handler handler) {
            super(handler);
        }

        public void onChange(boolean z) {
            onChange(z, (Uri) null);
        }

        public void onChange(boolean z, Uri uri) {
            if (uri == null) {
                uri = ContentProviderStorage.this.mTrayUri.builder().setModule(ContentProviderStorage.this.getModuleName()).build();
            }
            final List<TrayItem> queryProviderSafe = ContentProviderStorage.this.mProviderHelper.queryProviderSafe(uri);
            for (Map.Entry entry : new HashSet(ContentProviderStorage.this.mListeners.entrySet())) {
                final OnTrayPreferenceChangeListener onTrayPreferenceChangeListener = (OnTrayPreferenceChangeListener) entry.getKey();
                Handler handler = (Handler) entry.getValue();
                if (handler != null) {
                    handler.post(new Runnable() {
                        public void run() {
                            onTrayPreferenceChangeListener.onTrayPreferenceChanged(queryProviderSafe);
                        }
                    });
                } else {
                    onTrayPreferenceChangeListener.onTrayPreferenceChanged(queryProviderSafe);
                }
            }
        }
    }

    public ContentProviderStorage(@NonNull Context context, @NonNull String str, @NonNull TrayStorage.Type type) {
        super(str, type);
        this.mContext = context.getApplicationContext();
        this.mTrayUri = new TrayUri(this.mContext);
        this.mProviderHelper = new TrayProviderHelper(this.mContext);
    }

    public void annex(TrayStorage trayStorage) {
        for (TrayItem put : trayStorage.getAll()) {
            put(put);
        }
        trayStorage.wipe();
    }

    public boolean clear() {
        return this.mProviderHelper.remove(this.mTrayUri.builder().setModule(getModuleName()).setType(getType()).build());
    }

    @Nullable
    public TrayItem get(@NonNull String str) {
        List<TrayItem> queryProviderSafe = this.mProviderHelper.queryProviderSafe(this.mTrayUri.builder().setType(getType()).setModule(getModuleName()).setKey(str).build());
        int size = queryProviderSafe.size();
        if (size > 1) {
            TrayLog.w("found more than one item for key '" + str + "' in module " + getModuleName() + ". This can be caused by using the same name for a device and user specific preference.");
            for (int i = 0; i < queryProviderSafe.size(); i++) {
                TrayLog.d("item #" + i + s.a.f1696a + queryProviderSafe.get(i));
            }
        }
        if (size > 0) {
            return queryProviderSafe.get(0);
        }
        return null;
    }

    @NonNull
    public Collection<TrayItem> getAll() {
        return this.mProviderHelper.queryProviderSafe(this.mTrayUri.builder().setType(getType()).setModule(getModuleName()).build());
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getVersion() throws TrayException {
        List<TrayItem> queryProvider = this.mProviderHelper.queryProvider(this.mTrayUri.builder().setInternal(true).setType(getType()).setModule(getModuleName()).setKey(VERSION).build());
        if (queryProvider.size() == 0) {
            return 0;
        }
        return Integer.valueOf(queryProvider.get(0).value()).intValue();
    }

    public boolean put(@NonNull String str, @Nullable Object obj) {
        return put(str, (String) null, obj);
    }

    public boolean put(@NonNull String str, @Nullable String str2, @Nullable Object obj) {
        if (getType() == TrayStorage.Type.UNDEFINED) {
            throw new TrayRuntimeException("writing data into a storage with type UNDEFINED is forbidden. Only Read and delete is allowed.");
        }
        return this.mProviderHelper.persist(this.mTrayUri.builder().setType(getType()).setModule(getModuleName()).setKey(str).build(), obj == null ? null : String.valueOf(obj), str2);
    }

    public boolean put(TrayItem trayItem) {
        return put(trayItem.key(), trayItem.migratedKey(), trayItem.value());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        return;
     */
    @android.annotation.TargetApi(16)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void registerOnTrayPreferenceChangeListener(@android.support.annotation.NonNull net.grandcentrix.tray.core.OnTrayPreferenceChangeListener r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 != 0) goto L_0x0005
            monitor-exit(r2)
            return
        L_0x0005:
            r0 = 0
            android.os.Looper r1 = android.os.Looper.myLooper()     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x0011
            android.os.Handler r0 = new android.os.Handler     // Catch:{ all -> 0x003a }
            r0.<init>(r1)     // Catch:{ all -> 0x003a }
        L_0x0011:
            java.util.WeakHashMap<net.grandcentrix.tray.core.OnTrayPreferenceChangeListener, android.os.Handler> r1 = r2.mListeners     // Catch:{ all -> 0x003a }
            r1.put(r3, r0)     // Catch:{ all -> 0x003a }
            java.util.WeakHashMap<net.grandcentrix.tray.core.OnTrayPreferenceChangeListener, android.os.Handler> r3 = r2.mListeners     // Catch:{ all -> 0x003a }
            java.util.Set r3 = r3.keySet()     // Catch:{ all -> 0x003a }
            int r3 = r3.size()     // Catch:{ all -> 0x003a }
            r0 = 1
            if (r3 != r0) goto L_0x0038
            net.grandcentrix.tray.provider.ContentProviderStorage$1 r3 = new net.grandcentrix.tray.provider.ContentProviderStorage$1     // Catch:{ all -> 0x003a }
            java.lang.String r0 = "observer"
            r3.<init>(r0)     // Catch:{ all -> 0x003a }
            r2.mObserverThread = r3     // Catch:{ all -> 0x003a }
            android.os.HandlerThread r3 = r2.mObserverThread     // Catch:{ all -> 0x003a }
            r3.start()     // Catch:{ all -> 0x003a }
        L_0x0031:
            boolean r3 = r2.mRegisteredContentObserver     // Catch:{ all -> 0x003a }
            if (r3 == 0) goto L_0x0031
            r3 = 0
            r2.mRegisteredContentObserver = r3     // Catch:{ all -> 0x003a }
        L_0x0038:
            monitor-exit(r2)
            return
        L_0x003a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.grandcentrix.tray.provider.ContentProviderStorage.registerOnTrayPreferenceChangeListener(net.grandcentrix.tray.core.OnTrayPreferenceChangeListener):void");
    }

    public boolean remove(@NonNull String str) {
        if (str == null) {
            throw new IllegalArgumentException("null is not valid. use clear or wipe to delete all preferences");
        }
        return this.mProviderHelper.removeAndCount(this.mTrayUri.builder().setType(getType()).setModule(getModuleName()).setKey(str).build()) > 0;
    }

    public boolean setVersion(int i) {
        if (getType() == TrayStorage.Type.UNDEFINED) {
            throw new TrayRuntimeException("writing data into a storage with type UNDEFINED is forbidden. Only Read and delete is allowed.");
        }
        return this.mProviderHelper.persist(this.mTrayUri.builder().setInternal(true).setType(getType()).setModule(getModuleName()).setKey(VERSION).build(), String.valueOf(i));
    }

    public void unregisterOnTrayPreferenceChangeListener(@NonNull OnTrayPreferenceChangeListener onTrayPreferenceChangeListener) {
        if (onTrayPreferenceChangeListener != null) {
            this.mListeners.remove(onTrayPreferenceChangeListener);
            if (this.mListeners.size() == 0) {
                this.mContext.getContentResolver().unregisterContentObserver(this.mObserver);
                this.mObserver = null;
                this.mObserverThread.quit();
                this.mObserverThread = null;
            }
        }
    }

    public boolean wipe() {
        if (!clear()) {
            return false;
        }
        return this.mProviderHelper.remove(this.mTrayUri.builder().setInternal(true).setType(getType()).setModule(getModuleName()).build());
    }
}
