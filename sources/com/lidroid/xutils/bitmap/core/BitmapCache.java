package com.lidroid.xutils.bitmap.core;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.BitmapGlobalConfig;
import com.lidroid.xutils.bitmap.factory.BitmapFactory;
import com.lidroid.xutils.cache.FileNameGenerator;
import com.lidroid.xutils.cache.LruDiskCache;
import com.lidroid.xutils.cache.LruMemoryCache;
import com.lidroid.xutils.util.IOUtils;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.util.OtherUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BitmapCache {
    private final int DISK_CACHE_INDEX = 0;
    private BitmapGlobalConfig globalConfig;
    private final Object mDiskCacheLock = new Object();
    private LruDiskCache mDiskLruCache;
    private LruMemoryCache<MemoryCacheKey, Bitmap> mMemoryCache;

    private class BitmapMeta {
        public byte[] data;
        public long expiryTimestamp;
        public FileInputStream inputStream;

        private BitmapMeta() {
        }

        /* synthetic */ BitmapMeta(BitmapCache bitmapCache, BitmapMeta bitmapMeta) {
            this();
        }
    }

    public class MemoryCacheKey {
        private String subKey;
        private String uri;

        private MemoryCacheKey(String str, BitmapDisplayConfig bitmapDisplayConfig) {
            this.uri = str;
            this.subKey = bitmapDisplayConfig == null ? null : bitmapDisplayConfig.toString();
        }

        /* synthetic */ MemoryCacheKey(BitmapCache bitmapCache, String str, BitmapDisplayConfig bitmapDisplayConfig, MemoryCacheKey memoryCacheKey) {
            this(str, bitmapDisplayConfig);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MemoryCacheKey)) {
                return false;
            }
            MemoryCacheKey memoryCacheKey = (MemoryCacheKey) obj;
            if (!this.uri.equals(memoryCacheKey.uri)) {
                return false;
            }
            if (this.subKey == null || memoryCacheKey.subKey == null) {
                return true;
            }
            return this.subKey.equals(memoryCacheKey.subKey);
        }

        public int hashCode() {
            return this.uri.hashCode();
        }
    }

    public BitmapCache(BitmapGlobalConfig bitmapGlobalConfig) {
        if (bitmapGlobalConfig == null) {
            throw new IllegalArgumentException("globalConfig may not be null");
        }
        this.globalConfig = bitmapGlobalConfig;
    }

    private Bitmap decodeBitmapMeta(BitmapMeta bitmapMeta, BitmapDisplayConfig bitmapDisplayConfig) throws IOException {
        if (bitmapMeta == null) {
            return null;
        }
        if (bitmapMeta.inputStream != null) {
            return (bitmapDisplayConfig == null || bitmapDisplayConfig.isShowOriginal()) ? BitmapDecoder.decodeFileDescriptor(bitmapMeta.inputStream.getFD()) : BitmapDecoder.decodeSampledBitmapFromDescriptor(bitmapMeta.inputStream.getFD(), bitmapDisplayConfig.getBitmapMaxSize(), bitmapDisplayConfig.getBitmapConfig());
        }
        if (bitmapMeta.data != null) {
            return (bitmapDisplayConfig == null || bitmapDisplayConfig.isShowOriginal()) ? BitmapDecoder.decodeByteArray(bitmapMeta.data) : BitmapDecoder.decodeSampledBitmapFromByteArray(bitmapMeta.data, bitmapDisplayConfig.getBitmapMaxSize(), bitmapDisplayConfig.getBitmapConfig());
        }
        return null;
    }

    private synchronized Bitmap rotateBitmapIfNeeded(String str, BitmapDisplayConfig bitmapDisplayConfig, Bitmap bitmap) {
        Bitmap bitmap2;
        File bitmapFileFromDiskCache;
        if (bitmapDisplayConfig != null) {
            if (bitmapDisplayConfig.isAutoRotation() && (bitmapFileFromDiskCache = getBitmapFileFromDiskCache(str)) != null && bitmapFileFromDiskCache.exists()) {
                try {
                    int i = 0;
                    int attributeInt = new ExifInterface(bitmapFileFromDiskCache.getPath()).getAttributeInt("Orientation", 0);
                    if (attributeInt == 3) {
                        i = 180;
                    } else if (attributeInt == 6) {
                        i = 90;
                    } else if (attributeInt == 8) {
                        i = 270;
                    }
                    if (i != 0) {
                        Matrix matrix = new Matrix();
                        matrix.postRotate((float) i);
                        bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                        bitmap.recycle();
                    }
                } catch (Throwable unused) {
                    return bitmap;
                }
            }
        }
        bitmap2 = bitmap;
        return bitmap2;
    }

    public Bitmap addBitmapToMemoryCache(String str, BitmapDisplayConfig bitmapDisplayConfig, Bitmap bitmap, long j) throws IOException {
        BitmapFactory bitmapFactory;
        if (!(bitmapDisplayConfig == null || (bitmapFactory = bitmapDisplayConfig.getBitmapFactory()) == null)) {
            bitmap = bitmapFactory.cloneNew().createBitmap(bitmap);
        }
        if (!(str == null || bitmap == null || !this.globalConfig.isMemoryCacheEnabled() || this.mMemoryCache == null)) {
            this.mMemoryCache.put(new MemoryCacheKey(this, str, bitmapDisplayConfig, (MemoryCacheKey) null), bitmap, j);
        }
        return bitmap;
    }

    public void clearCache() {
        clearMemoryCache();
        clearDiskCache();
    }

    public void clearCache(String str) {
        clearMemoryCache(str);
        clearDiskCache(str);
    }

    public void clearDiskCache() {
        synchronized (this.mDiskCacheLock) {
            if (this.mDiskLruCache != null && !this.mDiskLruCache.isClosed()) {
                try {
                    this.mDiskLruCache.delete();
                    this.mDiskLruCache.close();
                } catch (Throwable th) {
                    LogUtils.e(th.getMessage(), th);
                }
                this.mDiskLruCache = null;
            }
        }
        initDiskCache();
    }

    public void clearDiskCache(String str) {
        synchronized (this.mDiskCacheLock) {
            if (this.mDiskLruCache != null && !this.mDiskLruCache.isClosed()) {
                try {
                    this.mDiskLruCache.remove(str);
                } catch (Throwable th) {
                    LogUtils.e(th.getMessage(), th);
                }
            }
        }
    }

    public void clearMemoryCache() {
        if (this.mMemoryCache != null) {
            this.mMemoryCache.evictAll();
        }
    }

    public void clearMemoryCache(String str) {
        MemoryCacheKey memoryCacheKey = new MemoryCacheKey(this, str, (BitmapDisplayConfig) null, (MemoryCacheKey) null);
        if (this.mMemoryCache != null) {
            while (this.mMemoryCache.containsKey(memoryCacheKey)) {
                this.mMemoryCache.remove(memoryCacheKey);
            }
        }
    }

    public void close() {
        synchronized (this.mDiskCacheLock) {
            if (this.mDiskLruCache != null) {
                try {
                    if (!this.mDiskLruCache.isClosed()) {
                        this.mDiskLruCache.close();
                    }
                } catch (Throwable th) {
                    LogUtils.e(th.getMessage(), th);
                }
                this.mDiskLruCache = null;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0090, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0091, code lost:
        r6 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00dc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00dd, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00df, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00e0, code lost:
        r1 = r0;
        r5 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00fa, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00fb, code lost:
        r1 = r0;
        r11 = null;
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00ff, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0100, code lost:
        r1 = r0;
        r5 = null;
        r11 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007c A[SYNTHETIC, Splitter:B:36:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ac A[Catch:{ Throwable -> 0x00df, all -> 0x00dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00dc A[ExcHandler: all (r0v4 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r11 r12 
      PHI: (r11v5 com.lidroid.xutils.cache.LruDiskCache$Snapshot) = (r11v6 com.lidroid.xutils.cache.LruDiskCache$Snapshot), (r11v8 com.lidroid.xutils.cache.LruDiskCache$Snapshot), (r11v10 com.lidroid.xutils.cache.LruDiskCache$Snapshot), (r11v10 com.lidroid.xutils.cache.LruDiskCache$Snapshot), (r11v10 com.lidroid.xutils.cache.LruDiskCache$Snapshot) binds: [B:71:0x00e6, B:48:0x009e, B:36:0x007c, B:39:0x0088, B:40:?] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r12v4 java.io.OutputStream) = (r12v6 java.io.OutputStream), (r12v11 java.io.OutputStream), (r12v13 java.io.OutputStream), (r12v13 java.io.OutputStream), (r12v13 java.io.OutputStream) binds: [B:71:0x00e6, B:48:0x009e, B:36:0x007c, B:39:0x0088, B:40:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:36:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00e6 A[SYNTHETIC, Splitter:B:71:0x00e6] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00fa A[ExcHandler: all (r0v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x000e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap downloadBitmap(java.lang.String r17, com.lidroid.xutils.bitmap.BitmapDisplayConfig r18, com.lidroid.xutils.BitmapUtils.BitmapLoadTask<?> r19) {
        /*
            r16 = this;
            r7 = r16
            r2 = r17
            r3 = r18
            r1 = r19
            com.lidroid.xutils.bitmap.core.BitmapCache$BitmapMeta r4 = new com.lidroid.xutils.bitmap.core.BitmapCache$BitmapMeta
            r8 = 0
            r4.<init>(r7, r8)
            com.lidroid.xutils.bitmap.BitmapGlobalConfig r5 = r7.globalConfig     // Catch:{ Throwable -> 0x00ff, all -> 0x00fa }
            boolean r5 = r5.isDiskCacheEnabled()     // Catch:{ Throwable -> 0x00ff, all -> 0x00fa }
            r9 = 0
            if (r5 == 0) goto L_0x00a7
            com.lidroid.xutils.cache.LruDiskCache r5 = r7.mDiskLruCache     // Catch:{ Throwable -> 0x00ff, all -> 0x00fa }
            if (r5 != 0) goto L_0x001f
            r16.initDiskCache()     // Catch:{ Throwable -> 0x00ff, all -> 0x00fa }
        L_0x001f:
            com.lidroid.xutils.cache.LruDiskCache r5 = r7.mDiskLruCache     // Catch:{ Throwable -> 0x00ff, all -> 0x00fa }
            if (r5 == 0) goto L_0x00a7
            com.lidroid.xutils.cache.LruDiskCache r5 = r7.mDiskLruCache     // Catch:{ Throwable -> 0x0099, all -> 0x00fa }
            com.lidroid.xutils.cache.LruDiskCache$Snapshot r5 = r5.get(r2)     // Catch:{ Throwable -> 0x0099, all -> 0x00fa }
            r6 = 0
            if (r5 != 0) goto L_0x0078
            com.lidroid.xutils.cache.LruDiskCache r11 = r7.mDiskLruCache     // Catch:{ Throwable -> 0x0072, all -> 0x006c }
            com.lidroid.xutils.cache.LruDiskCache$Editor r11 = r11.edit(r2)     // Catch:{ Throwable -> 0x0072, all -> 0x006c }
            if (r11 == 0) goto L_0x0078
            java.io.OutputStream r12 = r11.newOutputStream(r6)     // Catch:{ Throwable -> 0x0072, all -> 0x006c }
            com.lidroid.xutils.bitmap.BitmapGlobalConfig r13 = r7.globalConfig     // Catch:{ Throwable -> 0x0068, all -> 0x0063 }
            com.lidroid.xutils.bitmap.download.Downloader r13 = r13.getDownloader()     // Catch:{ Throwable -> 0x0068, all -> 0x0063 }
            long r13 = r13.downloadToStream(r2, r12, r1)     // Catch:{ Throwable -> 0x0068, all -> 0x0063 }
            r4.expiryTimestamp = r13     // Catch:{ Throwable -> 0x0068, all -> 0x0063 }
            long r13 = r4.expiryTimestamp     // Catch:{ Throwable -> 0x0068, all -> 0x0063 }
            int r15 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r15 >= 0) goto L_0x0054
            r11.abort()     // Catch:{ Throwable -> 0x0068, all -> 0x0063 }
            com.lidroid.xutils.util.IOUtils.closeQuietly((java.io.Closeable) r12)
            com.lidroid.xutils.util.IOUtils.closeQuietly((java.io.Closeable) r5)
            return r8
        L_0x0054:
            long r13 = r4.expiryTimestamp     // Catch:{ Throwable -> 0x0068, all -> 0x0063 }
            r11.setEntryExpiryTimestamp(r13)     // Catch:{ Throwable -> 0x0068, all -> 0x0063 }
            r11.commit()     // Catch:{ Throwable -> 0x0068, all -> 0x0063 }
            com.lidroid.xutils.cache.LruDiskCache r11 = r7.mDiskLruCache     // Catch:{ Throwable -> 0x0068, all -> 0x0063 }
            com.lidroid.xutils.cache.LruDiskCache$Snapshot r11 = r11.get(r2)     // Catch:{ Throwable -> 0x0068, all -> 0x0063 }
            goto L_0x007a
        L_0x0063:
            r0 = move-exception
            r1 = r0
            r11 = r5
            goto L_0x0114
        L_0x0068:
            r0 = move-exception
            r11 = r5
            r6 = r8
            goto L_0x0076
        L_0x006c:
            r0 = move-exception
            r1 = r0
            r11 = r5
            r12 = r8
            goto L_0x0114
        L_0x0072:
            r0 = move-exception
            r11 = r5
            r6 = r8
            r12 = r6
        L_0x0076:
            r5 = r0
            goto L_0x009e
        L_0x0078:
            r11 = r5
            r12 = r8
        L_0x007a:
            if (r11 == 0) goto L_0x0097
            java.io.FileInputStream r5 = r11.getInputStream(r6)     // Catch:{ Throwable -> 0x0093, all -> 0x00dc }
            r4.inputStream = r5     // Catch:{ Throwable -> 0x0093, all -> 0x00dc }
            android.graphics.Bitmap r5 = r7.decodeBitmapMeta(r4, r3)     // Catch:{ Throwable -> 0x0093, all -> 0x00dc }
            if (r5 != 0) goto L_0x00aa
            r4.inputStream = r8     // Catch:{ Throwable -> 0x0090, all -> 0x00dc }
            com.lidroid.xutils.cache.LruDiskCache r6 = r7.mDiskLruCache     // Catch:{ Throwable -> 0x0090, all -> 0x00dc }
            r6.remove(r2)     // Catch:{ Throwable -> 0x0090, all -> 0x00dc }
            goto L_0x00aa
        L_0x0090:
            r0 = move-exception
            r6 = r5
            goto L_0x0076
        L_0x0093:
            r0 = move-exception
            r5 = r0
            r6 = r8
            goto L_0x009e
        L_0x0097:
            r5 = r8
            goto L_0x00aa
        L_0x0099:
            r0 = move-exception
            r5 = r0
            r6 = r8
            r11 = r6
            r12 = r11
        L_0x009e:
            java.lang.String r13 = r5.getMessage()     // Catch:{ Throwable -> 0x00df, all -> 0x00dc }
            com.lidroid.xutils.util.LogUtils.e(r13, r5)     // Catch:{ Throwable -> 0x00df, all -> 0x00dc }
            r5 = r6
            goto L_0x00aa
        L_0x00a7:
            r5 = r8
            r11 = r5
            r12 = r11
        L_0x00aa:
            if (r5 != 0) goto L_0x00e3
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ Throwable -> 0x00df, all -> 0x00dc }
            r5.<init>()     // Catch:{ Throwable -> 0x00df, all -> 0x00dc }
            com.lidroid.xutils.bitmap.BitmapGlobalConfig r6 = r7.globalConfig     // Catch:{ Throwable -> 0x00d9 }
            com.lidroid.xutils.bitmap.download.Downloader r6 = r6.getDownloader()     // Catch:{ Throwable -> 0x00d9 }
            long r12 = r6.downloadToStream(r2, r5, r1)     // Catch:{ Throwable -> 0x00d9 }
            r4.expiryTimestamp = r12     // Catch:{ Throwable -> 0x00d9 }
            long r12 = r4.expiryTimestamp     // Catch:{ Throwable -> 0x00d9 }
            int r1 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r1 >= 0) goto L_0x00ca
            com.lidroid.xutils.util.IOUtils.closeQuietly((java.io.Closeable) r5)
            com.lidroid.xutils.util.IOUtils.closeQuietly((java.io.Closeable) r11)
            return r8
        L_0x00ca:
            r1 = r5
            java.io.ByteArrayOutputStream r1 = (java.io.ByteArrayOutputStream) r1     // Catch:{ Throwable -> 0x00d9 }
            byte[] r1 = r1.toByteArray()     // Catch:{ Throwable -> 0x00d9 }
            r4.data = r1     // Catch:{ Throwable -> 0x00d9 }
            android.graphics.Bitmap r1 = r7.decodeBitmapMeta(r4, r3)     // Catch:{ Throwable -> 0x00d9 }
            r12 = r5
            goto L_0x00e4
        L_0x00d9:
            r0 = move-exception
            r1 = r0
            goto L_0x0103
        L_0x00dc:
            r0 = move-exception
            r1 = r0
            goto L_0x0114
        L_0x00df:
            r0 = move-exception
            r1 = r0
            r5 = r12
            goto L_0x0103
        L_0x00e3:
            r1 = r5
        L_0x00e4:
            if (r1 == 0) goto L_0x00f3
            android.graphics.Bitmap r5 = r7.rotateBitmapIfNeeded(r2, r3, r1)     // Catch:{ Throwable -> 0x00df, all -> 0x00dc }
            long r9 = r4.expiryTimestamp     // Catch:{ Throwable -> 0x00df, all -> 0x00dc }
            r1 = r7
            r4 = r5
            r5 = r9
            android.graphics.Bitmap r1 = r1.addBitmapToMemoryCache(r2, r3, r4, r5)     // Catch:{ Throwable -> 0x00df, all -> 0x00dc }
        L_0x00f3:
            com.lidroid.xutils.util.IOUtils.closeQuietly((java.io.Closeable) r12)
            com.lidroid.xutils.util.IOUtils.closeQuietly((java.io.Closeable) r11)
            return r1
        L_0x00fa:
            r0 = move-exception
            r1 = r0
            r11 = r8
            r12 = r11
            goto L_0x0114
        L_0x00ff:
            r0 = move-exception
            r1 = r0
            r5 = r8
            r11 = r5
        L_0x0103:
            java.lang.String r2 = r1.getMessage()     // Catch:{ all -> 0x0111 }
            com.lidroid.xutils.util.LogUtils.e(r2, r1)     // Catch:{ all -> 0x0111 }
            com.lidroid.xutils.util.IOUtils.closeQuietly((java.io.Closeable) r5)
            com.lidroid.xutils.util.IOUtils.closeQuietly((java.io.Closeable) r11)
            return r8
        L_0x0111:
            r0 = move-exception
            r1 = r0
            r12 = r5
        L_0x0114:
            com.lidroid.xutils.util.IOUtils.closeQuietly((java.io.Closeable) r12)
            com.lidroid.xutils.util.IOUtils.closeQuietly((java.io.Closeable) r11)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.bitmap.core.BitmapCache.downloadBitmap(java.lang.String, com.lidroid.xutils.bitmap.BitmapDisplayConfig, com.lidroid.xutils.BitmapUtils$BitmapLoadTask):android.graphics.Bitmap");
    }

    public void flush() {
        synchronized (this.mDiskCacheLock) {
            if (this.mDiskLruCache != null) {
                try {
                    this.mDiskLruCache.flush();
                } catch (Throwable th) {
                    LogUtils.e(th.getMessage(), th);
                }
            }
        }
    }

    public File getBitmapFileFromDiskCache(String str) {
        synchronized (this.mDiskCacheLock) {
            if (this.mDiskLruCache == null) {
                return null;
            }
            File cacheFile = this.mDiskLruCache.getCacheFile(str, 0);
            return cacheFile;
        }
    }

    public Bitmap getBitmapFromDiskCache(String str, BitmapDisplayConfig bitmapDisplayConfig) {
        LruDiskCache.Snapshot snapshot;
        Bitmap bitmap;
        if (str == null || !this.globalConfig.isDiskCacheEnabled()) {
            return null;
        }
        if (this.mDiskLruCache == null) {
            initDiskCache();
        }
        if (this.mDiskLruCache != null) {
            try {
                snapshot = this.mDiskLruCache.get(str);
                if (snapshot != null) {
                    if (bitmapDisplayConfig != null) {
                        try {
                            if (!bitmapDisplayConfig.isShowOriginal()) {
                                bitmap = BitmapDecoder.decodeSampledBitmapFromDescriptor(snapshot.getInputStream(0).getFD(), bitmapDisplayConfig.getBitmapMaxSize(), bitmapDisplayConfig.getBitmapConfig());
                                Bitmap addBitmapToMemoryCache = addBitmapToMemoryCache(str, bitmapDisplayConfig, rotateBitmapIfNeeded(str, bitmapDisplayConfig, bitmap), this.mDiskLruCache.getExpiryTimestamp(str));
                                IOUtils.closeQuietly((Closeable) snapshot);
                                return addBitmapToMemoryCache;
                            }
                        } catch (Throwable th) {
                            th = th;
                            try {
                                LogUtils.e(th.getMessage(), th);
                                IOUtils.closeQuietly((Closeable) snapshot);
                                return null;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    }
                    bitmap = BitmapDecoder.decodeFileDescriptor(snapshot.getInputStream(0).getFD());
                    Bitmap addBitmapToMemoryCache2 = addBitmapToMemoryCache(str, bitmapDisplayConfig, rotateBitmapIfNeeded(str, bitmapDisplayConfig, bitmap), this.mDiskLruCache.getExpiryTimestamp(str));
                    IOUtils.closeQuietly((Closeable) snapshot);
                    return addBitmapToMemoryCache2;
                }
            } catch (Throwable th3) {
                th = th3;
                snapshot = null;
                IOUtils.closeQuietly((Closeable) snapshot);
                throw th;
            }
            IOUtils.closeQuietly((Closeable) snapshot);
            return null;
        }
        return null;
    }

    public Bitmap getBitmapFromMemCache(String str, BitmapDisplayConfig bitmapDisplayConfig) {
        if (this.mMemoryCache == null || !this.globalConfig.isMemoryCacheEnabled()) {
            return null;
        }
        return this.mMemoryCache.get(new MemoryCacheKey(this, str, bitmapDisplayConfig, (MemoryCacheKey) null));
    }

    public void initDiskCache() {
        synchronized (this.mDiskCacheLock) {
            if (this.globalConfig.isDiskCacheEnabled() && (this.mDiskLruCache == null || this.mDiskLruCache.isClosed())) {
                File file = new File(this.globalConfig.getDiskCachePath());
                if (file.exists() || file.mkdirs()) {
                    long availableSpace = OtherUtils.getAvailableSpace(file);
                    long diskCacheSize = (long) this.globalConfig.getDiskCacheSize();
                    if (availableSpace > diskCacheSize) {
                        availableSpace = diskCacheSize;
                    }
                    try {
                        this.mDiskLruCache = LruDiskCache.open(file, 1, 1, availableSpace);
                        this.mDiskLruCache.setFileNameGenerator(this.globalConfig.getFileNameGenerator());
                        LogUtils.d("create disk cache success");
                    } catch (Throwable th) {
                        this.mDiskLruCache = null;
                        LogUtils.e("create disk cache error", th);
                    }
                }
            }
        }
    }

    public void initMemoryCache() {
        if (this.globalConfig.isMemoryCacheEnabled()) {
            if (this.mMemoryCache != null) {
                try {
                    clearMemoryCache();
                } catch (Throwable unused) {
                }
            }
            this.mMemoryCache = new LruMemoryCache<MemoryCacheKey, Bitmap>(this.globalConfig.getMemoryCacheSize()) {
                /* access modifiers changed from: protected */
                public int sizeOf(MemoryCacheKey memoryCacheKey, Bitmap bitmap) {
                    if (bitmap == null) {
                        return 0;
                    }
                    return bitmap.getRowBytes() * bitmap.getHeight();
                }
            };
        }
    }

    public void setDiskCacheFileNameGenerator(FileNameGenerator fileNameGenerator) {
        synchronized (this.mDiskCacheLock) {
            if (!(this.mDiskLruCache == null || fileNameGenerator == null)) {
                this.mDiskLruCache.setFileNameGenerator(fileNameGenerator);
            }
        }
    }

    public void setDiskCacheSize(int i) {
        synchronized (this.mDiskCacheLock) {
            if (this.mDiskLruCache != null) {
                this.mDiskLruCache.setMaxSize((long) i);
            }
        }
    }

    public void setMemoryCacheSize(int i) {
        if (this.mMemoryCache != null) {
            this.mMemoryCache.setMaxSize(i);
        }
    }
}
