package com.iflytek.voiceads.dex;

import com.github.kevinsawicki.http.HttpRequest;
import com.hlzn.socketclient.b.a;
import com.iflytek.voiceads.config.SDKLogger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3515a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f3516b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f3517c;
    final /* synthetic */ String d;

    d(String str, String str2, String str3, String str4) {
        this.f3515a = str;
        this.f3516b = str2;
        this.f3517c = str3;
        this.d = str4;
    }

    public final void run() {
        InputStream inputStream;
        SDKLogger.d("checking update");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f3515a).openConnection();
            httpURLConnection.setReadTimeout(a.t);
            httpURLConnection.setConnectTimeout(a.t);
            httpURLConnection.setRequestMethod(HttpRequest.METHOD_GET);
            httpURLConnection.setRequestProperty("Charset", "utf-8");
            if (httpURLConnection.getResponseCode() == 200) {
                inputStream = httpURLConnection.getInputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                b bVar = new b(new String(byteArrayOutputStream.toByteArray()));
                if (bVar.b() != null) {
                    if (bVar.a() != null) {
                        if (c.b(bVar.b(), this.f3516b) > c.b(this.f3517c, this.f3516b)) {
                            SDKLogger.d("find new version:" + bVar.b());
                            c.b(this.d, bVar.b(), bVar.a());
                        } else {
                            SDKLogger.d("no new version dex");
                        }
                    }
                }
                SDKLogger.d("no version");
                return;
            }
            inputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            byteArrayOutputStream.close();
        } catch (IOException e) {
            SDKLogger.e("checkDexUpdate thread" + e.getMessage());
        }
    }
}
