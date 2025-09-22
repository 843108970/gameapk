package com.iflytek.voiceads.dex;

import com.github.kevinsawicki.http.HttpRequest;
import com.hlzn.socketclient.b.a;
import com.iflytek.voiceads.config.SDKLogger;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3518a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f3519b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f3520c;

    e(String str, String str2, String str3) {
        this.f3518a = str;
        this.f3519b = str2;
        this.f3520c = str3;
    }

    public final void run() {
        FileOutputStream fileOutputStream;
        SDKLogger.d("downloading new version:" + this.f3518a);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f3519b).openConnection();
            httpURLConnection.setReadTimeout(a.t);
            httpURLConnection.setConnectTimeout(a.t);
            httpURLConnection.setRequestMethod(HttpRequest.METHOD_GET);
            InputStream inputStream = null;
            if (httpURLConnection.getResponseCode() == 200) {
                inputStream = httpURLConnection.getInputStream();
                fileOutputStream = new FileOutputStream(this.f3520c + this.f3518a);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read < 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                SDKLogger.d("download " + this.f3518a + " completed, it will be loaded next time");
            } else {
                fileOutputStream = null;
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (IOException e) {
            SDKLogger.e("downloadRemote thread:" + e.getMessage());
        }
    }
}
