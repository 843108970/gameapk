package com.lidroid.xutils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import com.lidroid.xutils.bitmap.BitmapCacheListener;
import com.lidroid.xutils.bitmap.BitmapCommonUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.BitmapGlobalConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadCallBack;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;
import com.lidroid.xutils.bitmap.callback.DefaultBitmapLoadCallBack;
import com.lidroid.xutils.bitmap.core.AsyncDrawable;
import com.lidroid.xutils.bitmap.core.BitmapSize;
import com.lidroid.xutils.bitmap.download.Downloader;
import com.lidroid.xutils.cache.FileNameGenerator;
import com.lidroid.xutils.task.PriorityAsyncTask;
import com.lidroid.xutils.task.PriorityExecutor;
import com.lidroid.xutils.task.TaskHandler;
import java.io.File;
import java.lang.ref.WeakReference;

public class BitmapUtils implements TaskHandler {
    /* access modifiers changed from: private */
    public boolean cancelAllTask;
    private Context context;
    private BitmapDisplayConfig defaultDisplayConfig;
    /* access modifiers changed from: private */
    public BitmapGlobalConfig globalConfig;
    /* access modifiers changed from: private */
    public boolean pauseTask;
    /* access modifiers changed from: private */
    public final Object pauseTaskLock;

    public class BitmapLoadTask<T extends View> extends PriorityAsyncTask<Object, Object, Bitmap> {
        private static final int PROGRESS_LOADING = 1;
        private static final int PROGRESS_LOAD_STARTED = 0;
        private final BitmapLoadCallBack<T> callBack;
        private final WeakReference<T> containerReference;
        private final BitmapDisplayConfig displayConfig;
        private BitmapLoadFrom from = BitmapLoadFrom.DISK_CACHE;
        /* access modifiers changed from: private */
        public final String uri;

        public BitmapLoadTask(T t, String str, BitmapDisplayConfig bitmapDisplayConfig, BitmapLoadCallBack<T> bitmapLoadCallBack) {
            if (t == null || str == null || bitmapDisplayConfig == null || bitmapLoadCallBack == null) {
                throw new IllegalArgumentException("args may not be null");
            }
            this.containerReference = new WeakReference<>(t);
            this.callBack = bitmapLoadCallBack;
            this.uri = str;
            this.displayConfig = bitmapDisplayConfig;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
            if (isCancelled() != false) goto L_0x0056;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
            if (getTargetContainer() == null) goto L_0x0056;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
            publishProgress(0);
            r1 = com.lidroid.xutils.BitmapUtils.access$3(r2.this$0).getBitmapCache().getBitmapFromDiskCache(r2.uri, r2.displayConfig);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
            if (r1 != null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x005c, code lost:
            if (isCancelled() != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0062, code lost:
            if (getTargetContainer() == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0064, code lost:
            r1 = com.lidroid.xutils.BitmapUtils.access$3(r2.this$0).getBitmapCache().downloadBitmap(r2.uri, r2.displayConfig, r2);
            r2.from = com.lidroid.xutils.bitmap.callback.BitmapLoadFrom.URI;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
            return r1;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0007 */
        /* JADX WARNING: Removed duplicated region for block: B:2:0x0007 A[LOOP:0: B:2:0x0007->B:29:0x0007, LOOP_START, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.graphics.Bitmap doInBackground(java.lang.Object... r3) {
            /*
                r2 = this;
                com.lidroid.xutils.BitmapUtils r3 = com.lidroid.xutils.BitmapUtils.this
                java.lang.Object r3 = r3.pauseTaskLock
                monitor-enter(r3)
            L_0x0007:
                com.lidroid.xutils.BitmapUtils r0 = com.lidroid.xutils.BitmapUtils.this     // Catch:{ all -> 0x007b }
                boolean r0 = r0.pauseTask     // Catch:{ all -> 0x007b }
                r1 = 0
                if (r0 == 0) goto L_0x002a
                boolean r0 = r2.isCancelled()     // Catch:{ all -> 0x007b }
                if (r0 == 0) goto L_0x0017
                goto L_0x002a
            L_0x0017:
                com.lidroid.xutils.BitmapUtils r0 = com.lidroid.xutils.BitmapUtils.this     // Catch:{ Throwable -> 0x0007 }
                java.lang.Object r0 = r0.pauseTaskLock     // Catch:{ Throwable -> 0x0007 }
                r0.wait()     // Catch:{ Throwable -> 0x0007 }
                com.lidroid.xutils.BitmapUtils r0 = com.lidroid.xutils.BitmapUtils.this     // Catch:{ Throwable -> 0x0007 }
                boolean r0 = r0.cancelAllTask     // Catch:{ Throwable -> 0x0007 }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x007b }
                return r1
            L_0x002a:
                monitor-exit(r3)     // Catch:{ all -> 0x007b }
                boolean r3 = r2.isCancelled()
                if (r3 != 0) goto L_0x0056
                android.view.View r3 = r2.getTargetContainer()
                if (r3 == 0) goto L_0x0056
                r3 = 1
                java.lang.Object[] r3 = new java.lang.Object[r3]
                r0 = 0
                java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
                r3[r0] = r1
                r2.publishProgress(r3)
                com.lidroid.xutils.BitmapUtils r3 = com.lidroid.xutils.BitmapUtils.this
                com.lidroid.xutils.bitmap.BitmapGlobalConfig r3 = r3.globalConfig
                com.lidroid.xutils.bitmap.core.BitmapCache r3 = r3.getBitmapCache()
                java.lang.String r0 = r2.uri
                com.lidroid.xutils.bitmap.BitmapDisplayConfig r1 = r2.displayConfig
                android.graphics.Bitmap r1 = r3.getBitmapFromDiskCache(r0, r1)
            L_0x0056:
                if (r1 != 0) goto L_0x007a
                boolean r3 = r2.isCancelled()
                if (r3 != 0) goto L_0x007a
                android.view.View r3 = r2.getTargetContainer()
                if (r3 == 0) goto L_0x007a
                com.lidroid.xutils.BitmapUtils r3 = com.lidroid.xutils.BitmapUtils.this
                com.lidroid.xutils.bitmap.BitmapGlobalConfig r3 = r3.globalConfig
                com.lidroid.xutils.bitmap.core.BitmapCache r3 = r3.getBitmapCache()
                java.lang.String r0 = r2.uri
                com.lidroid.xutils.bitmap.BitmapDisplayConfig r1 = r2.displayConfig
                android.graphics.Bitmap r1 = r3.downloadBitmap(r0, r1, r2)
                com.lidroid.xutils.bitmap.callback.BitmapLoadFrom r3 = com.lidroid.xutils.bitmap.callback.BitmapLoadFrom.URI
                r2.from = r3
            L_0x007a:
                return r1
            L_0x007b:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x007b }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.BitmapUtils.BitmapLoadTask.doInBackground(java.lang.Object[]):android.graphics.Bitmap");
        }

        public T getTargetContainer() {
            T t = (View) this.containerReference.get();
            if (this == BitmapUtils.getBitmapTaskFromContainer(t, this.callBack)) {
                return t;
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onCancelled(Bitmap bitmap) {
            synchronized (BitmapUtils.this.pauseTaskLock) {
                BitmapUtils.this.pauseTaskLock.notifyAll();
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Bitmap bitmap) {
            View targetContainer = getTargetContainer();
            if (targetContainer == null) {
                return;
            }
            if (bitmap != null) {
                this.callBack.onLoadCompleted(targetContainer, this.uri, bitmap, this.displayConfig, this.from);
                return;
            }
            this.callBack.onLoadFailed(targetContainer, this.uri, this.displayConfig.getLoadFailedDrawable());
        }

        /* access modifiers changed from: protected */
        public void onProgressUpdate(Object... objArr) {
            View targetContainer;
            if (objArr != null && objArr.length != 0 && (targetContainer = getTargetContainer()) != null) {
                switch (objArr[0].intValue()) {
                    case 0:
                        this.callBack.onLoadStarted(targetContainer, this.uri, this.displayConfig);
                        return;
                    case 1:
                        if (objArr.length == 3) {
                            this.callBack.onLoading(targetContainer, this.uri, this.displayConfig, objArr[1].longValue(), objArr[2].longValue());
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        public void updateProgress(long j, long j2) {
            publishProgress(1, Long.valueOf(j), Long.valueOf(j2));
        }
    }

    public BitmapUtils(Context context2) {
        this(context2, (String) null);
    }

    public BitmapUtils(Context context2, String str) {
        this.pauseTask = false;
        this.cancelAllTask = false;
        this.pauseTaskLock = new Object();
        if (context2 == null) {
            throw new IllegalArgumentException("context may not be null");
        }
        this.context = context2.getApplicationContext();
        this.globalConfig = BitmapGlobalConfig.getInstance(this.context, str);
        this.defaultDisplayConfig = new BitmapDisplayConfig();
    }

    public BitmapUtils(Context context2, String str, float f) {
        this(context2, str);
        this.globalConfig.setMemCacheSizePercent(f);
    }

    public BitmapUtils(Context context2, String str, float f, int i) {
        this(context2, str);
        this.globalConfig.setMemCacheSizePercent(f);
        this.globalConfig.setDiskCacheSize(i);
    }

    public BitmapUtils(Context context2, String str, int i) {
        this(context2, str);
        this.globalConfig.setMemoryCacheSize(i);
    }

    public BitmapUtils(Context context2, String str, int i, int i2) {
        this(context2, str);
        this.globalConfig.setMemoryCacheSize(i);
        this.globalConfig.setDiskCacheSize(i2);
    }

    private static <T extends View> boolean bitmapLoadTaskExist(T t, String str, BitmapLoadCallBack<T> bitmapLoadCallBack) {
        BitmapLoadTask<T> bitmapTaskFromContainer = getBitmapTaskFromContainer(t, bitmapLoadCallBack);
        if (bitmapTaskFromContainer == null) {
            return false;
        }
        String access$3 = bitmapTaskFromContainer.uri;
        if (!TextUtils.isEmpty(access$3) && access$3.equals(str)) {
            return true;
        }
        bitmapTaskFromContainer.cancel(true);
        return false;
    }

    /* access modifiers changed from: private */
    public static <T extends View> BitmapLoadTask<T> getBitmapTaskFromContainer(T t, BitmapLoadCallBack<T> bitmapLoadCallBack) {
        if (t == null) {
            return null;
        }
        Drawable drawable = bitmapLoadCallBack.getDrawable(t);
        if (drawable instanceof AsyncDrawable) {
            return ((AsyncDrawable) drawable).getBitmapWorkerTask();
        }
        return null;
    }

    public void cancel() {
        this.pauseTask = true;
        this.cancelAllTask = true;
        synchronized (this.pauseTaskLock) {
            this.pauseTaskLock.notifyAll();
        }
    }

    public void clearCache() {
        this.globalConfig.clearCache();
    }

    public void clearCache(String str) {
        this.globalConfig.clearCache(str);
    }

    public void clearDiskCache() {
        this.globalConfig.clearDiskCache();
    }

    public void clearDiskCache(String str) {
        this.globalConfig.clearDiskCache(str);
    }

    public void clearMemoryCache() {
        this.globalConfig.clearMemoryCache();
    }

    public void clearMemoryCache(String str) {
        this.globalConfig.clearMemoryCache(str);
    }

    public void closeCache() {
        this.globalConfig.closeCache();
    }

    public BitmapUtils configBitmapCacheListener(BitmapCacheListener bitmapCacheListener) {
        this.globalConfig.setBitmapCacheListener(bitmapCacheListener);
        return this;
    }

    public BitmapUtils configDefaultAutoRotation(boolean z) {
        this.defaultDisplayConfig.setAutoRotation(z);
        return this;
    }

    public BitmapUtils configDefaultBitmapConfig(Bitmap.Config config) {
        this.defaultDisplayConfig.setBitmapConfig(config);
        return this;
    }

    public BitmapUtils configDefaultBitmapMaxSize(int i, int i2) {
        this.defaultDisplayConfig.setBitmapMaxSize(new BitmapSize(i, i2));
        return this;
    }

    public BitmapUtils configDefaultBitmapMaxSize(BitmapSize bitmapSize) {
        this.defaultDisplayConfig.setBitmapMaxSize(bitmapSize);
        return this;
    }

    public BitmapUtils configDefaultCacheExpiry(long j) {
        this.globalConfig.setDefaultCacheExpiry(j);
        return this;
    }

    public BitmapUtils configDefaultConnectTimeout(int i) {
        this.globalConfig.setDefaultConnectTimeout(i);
        return this;
    }

    public BitmapUtils configDefaultDisplayConfig(BitmapDisplayConfig bitmapDisplayConfig) {
        this.defaultDisplayConfig = bitmapDisplayConfig;
        return this;
    }

    public BitmapUtils configDefaultImageLoadAnimation(Animation animation) {
        this.defaultDisplayConfig.setAnimation(animation);
        return this;
    }

    public BitmapUtils configDefaultLoadFailedImage(int i) {
        this.defaultDisplayConfig.setLoadFailedDrawable(this.context.getResources().getDrawable(i));
        return this;
    }

    public BitmapUtils configDefaultLoadFailedImage(Bitmap bitmap) {
        this.defaultDisplayConfig.setLoadFailedDrawable(new BitmapDrawable(this.context.getResources(), bitmap));
        return this;
    }

    public BitmapUtils configDefaultLoadFailedImage(Drawable drawable) {
        this.defaultDisplayConfig.setLoadFailedDrawable(drawable);
        return this;
    }

    public BitmapUtils configDefaultLoadingImage(int i) {
        this.defaultDisplayConfig.setLoadingDrawable(this.context.getResources().getDrawable(i));
        return this;
    }

    public BitmapUtils configDefaultLoadingImage(Bitmap bitmap) {
        this.defaultDisplayConfig.setLoadingDrawable(new BitmapDrawable(this.context.getResources(), bitmap));
        return this;
    }

    public BitmapUtils configDefaultLoadingImage(Drawable drawable) {
        this.defaultDisplayConfig.setLoadingDrawable(drawable);
        return this;
    }

    public BitmapUtils configDefaultReadTimeout(int i) {
        this.globalConfig.setDefaultReadTimeout(i);
        return this;
    }

    public BitmapUtils configDefaultShowOriginal(boolean z) {
        this.defaultDisplayConfig.setShowOriginal(z);
        return this;
    }

    public BitmapUtils configDiskCacheEnabled(boolean z) {
        this.globalConfig.setDiskCacheEnabled(z);
        return this;
    }

    public BitmapUtils configDiskCacheFileNameGenerator(FileNameGenerator fileNameGenerator) {
        this.globalConfig.setFileNameGenerator(fileNameGenerator);
        return this;
    }

    public BitmapUtils configDownloader(Downloader downloader) {
        this.globalConfig.setDownloader(downloader);
        return this;
    }

    public BitmapUtils configGlobalConfig(BitmapGlobalConfig bitmapGlobalConfig) {
        this.globalConfig = bitmapGlobalConfig;
        return this;
    }

    public BitmapUtils configMemoryCacheEnabled(boolean z) {
        this.globalConfig.setMemoryCacheEnabled(z);
        return this;
    }

    public BitmapUtils configThreadPoolSize(int i) {
        this.globalConfig.setThreadPoolSize(i);
        return this;
    }

    public <T extends View> void display(T t, String str) {
        display(t, str, (BitmapDisplayConfig) null, (BitmapLoadCallBack) null);
    }

    public <T extends View> void display(T t, String str, BitmapDisplayConfig bitmapDisplayConfig) {
        display(t, str, bitmapDisplayConfig, (BitmapLoadCallBack) null);
    }

    public <T extends View> void display(T t, String str, BitmapDisplayConfig bitmapDisplayConfig, BitmapLoadCallBack<T> bitmapLoadCallBack) {
        if (t != null) {
            if (bitmapLoadCallBack == null) {
                bitmapLoadCallBack = new DefaultBitmapLoadCallBack<>();
            }
            if (bitmapDisplayConfig == null || bitmapDisplayConfig == this.defaultDisplayConfig) {
                bitmapDisplayConfig = this.defaultDisplayConfig.cloneNew();
            }
            BitmapSize bitmapMaxSize = bitmapDisplayConfig.getBitmapMaxSize();
            bitmapDisplayConfig.setBitmapMaxSize(BitmapCommonUtils.optimizeMaxSizeByView(t, bitmapMaxSize.getWidth(), bitmapMaxSize.getHeight()));
            t.clearAnimation();
            if (TextUtils.isEmpty(str)) {
                bitmapLoadCallBack.onLoadFailed(t, str, bitmapDisplayConfig.getLoadFailedDrawable());
                return;
            }
            bitmapLoadCallBack.onPreLoad(t, str, bitmapDisplayConfig);
            Bitmap bitmapFromMemCache = this.globalConfig.getBitmapCache().getBitmapFromMemCache(str, bitmapDisplayConfig);
            if (bitmapFromMemCache != null) {
                bitmapLoadCallBack.onLoadStarted(t, str, bitmapDisplayConfig);
                bitmapLoadCallBack.onLoadCompleted(t, str, bitmapFromMemCache, bitmapDisplayConfig, BitmapLoadFrom.MEMORY_CACHE);
            } else if (!bitmapLoadTaskExist(t, str, bitmapLoadCallBack)) {
                BitmapLoadTask bitmapLoadTask = new BitmapLoadTask(t, str, bitmapDisplayConfig, bitmapLoadCallBack);
                PriorityExecutor bitmapLoadExecutor = this.globalConfig.getBitmapLoadExecutor();
                File bitmapFileFromDiskCache = getBitmapFileFromDiskCache(str);
                if ((bitmapFileFromDiskCache != null && bitmapFileFromDiskCache.exists()) && bitmapLoadExecutor.isBusy()) {
                    bitmapLoadExecutor = this.globalConfig.getDiskCacheExecutor();
                }
                bitmapLoadCallBack.setDrawable(t, new AsyncDrawable(bitmapDisplayConfig.getLoadingDrawable(), bitmapLoadTask));
                bitmapLoadTask.setPriority(bitmapDisplayConfig.getPriority());
                bitmapLoadTask.executeOnExecutor(bitmapLoadExecutor, new Object[0]);
            }
        }
    }

    public <T extends View> void display(T t, String str, BitmapLoadCallBack<T> bitmapLoadCallBack) {
        display(t, str, (BitmapDisplayConfig) null, bitmapLoadCallBack);
    }

    public void flushCache() {
        this.globalConfig.flushCache();
    }

    public File getBitmapFileFromDiskCache(String str) {
        return this.globalConfig.getBitmapCache().getBitmapFileFromDiskCache(str);
    }

    public Bitmap getBitmapFromMemCache(String str, BitmapDisplayConfig bitmapDisplayConfig) {
        if (bitmapDisplayConfig == null) {
            bitmapDisplayConfig = this.defaultDisplayConfig;
        }
        return this.globalConfig.getBitmapCache().getBitmapFromMemCache(str, bitmapDisplayConfig);
    }

    public boolean isCancelled() {
        return this.cancelAllTask;
    }

    public boolean isPaused() {
        return this.pauseTask;
    }

    public void pause() {
        this.pauseTask = true;
        flushCache();
    }

    public void resume() {
        this.pauseTask = false;
        synchronized (this.pauseTaskLock) {
            this.pauseTaskLock.notifyAll();
        }
    }

    public boolean supportCancel() {
        return true;
    }

    public boolean supportPause() {
        return true;
    }

    public boolean supportResume() {
        return true;
    }
}
