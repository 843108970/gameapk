package com.lidroid.xutils.bitmap.download;

import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.util.IOUtils;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.util.OtherUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class DefaultDownloader extends Downloader {
    public long downloadToStream(String str, OutputStream outputStream, BitmapUtils.BitmapLoadTask<?> bitmapLoadTask) {
        Throwable th;
        Throwable th2;
        long j;
        long j2;
        String str2 = str;
        BitmapUtils.BitmapLoadTask<?> bitmapLoadTask2 = bitmapLoadTask;
        if (bitmapLoadTask2 == null || bitmapLoadTask.isCancelled() || bitmapLoadTask.getTargetContainer() == null) {
            return -1;
        }
        BufferedInputStream bufferedInputStream = null;
        OtherUtils.trustAllHttpsURLConnection();
        long j3 = 0;
        try {
            if (str2.startsWith("/")) {
                FileInputStream fileInputStream = new FileInputStream(str2);
                j2 = (long) fileInputStream.available();
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream);
                try {
                    bufferedInputStream = bufferedInputStream2;
                    j = System.currentTimeMillis() + getDefaultExpiry();
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream = bufferedInputStream2;
                    th = th;
                    IOUtils.closeQuietly((Closeable) bufferedInputStream);
                    throw th;
                }
            } else if (str2.startsWith("assets/")) {
                InputStream open = getContext().getAssets().open(str2.substring(7, str.length()));
                j2 = (long) open.available();
                j = Long.MAX_VALUE;
                bufferedInputStream = new BufferedInputStream(open);
            } else {
                URLConnection openConnection = new URL(str2).openConnection();
                openConnection.setConnectTimeout(getDefaultConnectTimeout());
                openConnection.setReadTimeout(getDefaultReadTimeout());
                BufferedInputStream bufferedInputStream3 = new BufferedInputStream(openConnection.getInputStream());
                try {
                    long expiration = openConnection.getExpiration();
                    long currentTimeMillis = expiration < System.currentTimeMillis() ? System.currentTimeMillis() + getDefaultExpiry() : expiration;
                    j2 = (long) openConnection.getContentLength();
                    bufferedInputStream = bufferedInputStream3;
                    j = currentTimeMillis;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedInputStream = bufferedInputStream3;
                    IOUtils.closeQuietly((Closeable) bufferedInputStream);
                    throw th;
                }
            }
            if (!bitmapLoadTask.isCancelled()) {
                if (bitmapLoadTask.getTargetContainer() != null) {
                    byte[] bArr = new byte[4096];
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            bufferedOutputStream.flush();
                            IOUtils.closeQuietly((Closeable) bufferedInputStream);
                            return j;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                        long j4 = j3 + ((long) read);
                        if (bitmapLoadTask.isCancelled()) {
                            break;
                        } else if (bitmapLoadTask.getTargetContainer() == null) {
                            break;
                        } else {
                            bitmapLoadTask2.updateProgress(j2, j4);
                            j3 = j4;
                        }
                    }
                }
            }
            IOUtils.closeQuietly((Closeable) bufferedInputStream);
            return -1;
        } catch (Throwable th5) {
            th = th5;
            th2 = th;
            LogUtils.e(th2.getMessage(), th2);
            IOUtils.closeQuietly((Closeable) bufferedInputStream);
            return -1;
        }
    }
}
