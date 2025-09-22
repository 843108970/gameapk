package com.iflytek.collector.a.a;

import android.text.TextUtils;
import com.iflytek.voiceads.config.SDKLogger;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONObject;

public class g extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private int f3500a = com.hlzn.socketclient.b.a.r;

    /* renamed from: b  reason: collision with root package name */
    private a f3501b = null;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f3502c = false;
    private URL d = null;
    private ArrayList<byte[]> e = new ArrayList<>();
    private Object f = null;
    private int g = 0;

    public interface a {
        void a(g gVar, byte[] bArr);

        void a(Exception exc);
    }

    public static URL a(String str, String str2) throws MalformedURLException {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!str.endsWith("?")) {
                str = str + "?";
            }
            str = str + str2;
        }
        SDKLogger.d("Collector", "url:" + str);
        return new URL(str);
    }

    private void a(Exception exc) {
        if (this.f3501b != null && !this.f3502c) {
            this.f3501b.a(exc);
        }
    }

    public static boolean a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.has("rsp") && jSONObject.getJSONObject("rsp").getInt("code") != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    private byte[] a(InputStream inputStream) throws IOException {
        int read;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        byte[] bArr = new byte[1024];
        while (!this.f3502c && (read = bufferedInputStream.read(bArr, 0, 1024)) != -1) {
            byteArrayOutputStream.write(bArr, 0, read);
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x006a A[SYNTHETIC, Splitter:B:31:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006f A[Catch:{ Exception -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0077 A[SYNTHETIC, Splitter:B:39:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007c A[Catch:{ Exception -> 0x007f }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
            r7 = this;
            r0 = 0
            java.net.URL r1 = r7.d     // Catch:{ Exception -> 0x005f, all -> 0x005b }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x005f, all -> 0x005b }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x005f, all -> 0x005b }
            int r2 = r7.f3500a     // Catch:{ Exception -> 0x0059 }
            r1.setConnectTimeout(r2)     // Catch:{ Exception -> 0x0059 }
            int r2 = r7.f3500a     // Catch:{ Exception -> 0x0059 }
            r1.setReadTimeout(r2)     // Catch:{ Exception -> 0x0059 }
            java.lang.String r2 = "GET"
            r1.setRequestMethod(r2)     // Catch:{ Exception -> 0x0059 }
            int r2 = r1.getResponseCode()     // Catch:{ Exception -> 0x0059 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r3 != r2) goto L_0x0037
            java.io.InputStream r2 = r1.getInputStream()     // Catch:{ Exception -> 0x0059 }
            byte[] r0 = r7.a((java.io.InputStream) r2)     // Catch:{ Exception -> 0x0032, all -> 0x002d }
            r7.b((byte[]) r0)     // Catch:{ Exception -> 0x0032, all -> 0x002d }
            r0 = r2
            goto L_0x004d
        L_0x002d:
            r0 = move-exception
            r6 = r2
            r2 = r0
            r0 = r6
            goto L_0x0075
        L_0x0032:
            r0 = move-exception
            r6 = r2
            r2 = r0
            r0 = r6
            goto L_0x0062
        L_0x0037:
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ Exception -> 0x0059 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0059 }
            java.lang.String r5 = "HttpRequest Failed: "
            r4.<init>(r5)     // Catch:{ Exception -> 0x0059 }
            r4.append(r2)     // Catch:{ Exception -> 0x0059 }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x0059 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0059 }
            r7.a((java.lang.Exception) r3)     // Catch:{ Exception -> 0x0059 }
        L_0x004d:
            if (r0 == 0) goto L_0x0052
            r0.close()     // Catch:{ Exception -> 0x0058 }
        L_0x0052:
            if (r1 == 0) goto L_0x0058
            r1.disconnect()     // Catch:{ Exception -> 0x0058 }
            return
        L_0x0058:
            return
        L_0x0059:
            r2 = move-exception
            goto L_0x0062
        L_0x005b:
            r1 = move-exception
            r2 = r1
            r1 = r0
            goto L_0x0075
        L_0x005f:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L_0x0062:
            r2.printStackTrace()     // Catch:{ all -> 0x0074 }
            r7.a((java.lang.Exception) r2)     // Catch:{ all -> 0x0074 }
            if (r0 == 0) goto L_0x006d
            r0.close()     // Catch:{ Exception -> 0x0073 }
        L_0x006d:
            if (r1 == 0) goto L_0x0073
            r1.disconnect()     // Catch:{ Exception -> 0x0073 }
            return
        L_0x0073:
            return
        L_0x0074:
            r2 = move-exception
        L_0x0075:
            if (r0 == 0) goto L_0x007a
            r0.close()     // Catch:{ Exception -> 0x007f }
        L_0x007a:
            if (r1 == 0) goto L_0x007f
            r1.disconnect()     // Catch:{ Exception -> 0x007f }
        L_0x007f:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.collector.a.a.g.b():void");
    }

    private void b(byte[] bArr) {
        if (this.f3501b != null && !this.f3502c) {
            this.f3501b.a(this, bArr);
        }
    }

    private int c() {
        int i = 0;
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            i += this.e.get(i2).length;
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ba A[SYNTHETIC, Splitter:B:36:0x00ba] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bf A[Catch:{ Exception -> 0x00c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c7 A[SYNTHETIC, Splitter:B:44:0x00c7] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cc A[Catch:{ Exception -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r7 = this;
            r0 = 0
            java.net.URL r1 = r7.d     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            r2 = 1
            r1.setDoOutput(r2)     // Catch:{ Exception -> 0x00ae }
            r1.setDoInput(r2)     // Catch:{ Exception -> 0x00ae }
            r2 = 0
            r1.setUseCaches(r2)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r2 = "POST"
            r1.setRequestMethod(r2)     // Catch:{ Exception -> 0x00ae }
            int r2 = r7.f3500a     // Catch:{ Exception -> 0x00ae }
            r1.setConnectTimeout(r2)     // Catch:{ Exception -> 0x00ae }
            int r2 = r7.f3500a     // Catch:{ Exception -> 0x00ae }
            r1.setReadTimeout(r2)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r2 = "Content-length"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ae }
            r3.<init>()     // Catch:{ Exception -> 0x00ae }
            int r4 = r7.c()     // Catch:{ Exception -> 0x00ae }
            r3.append(r4)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00ae }
            r1.setRequestProperty(r2, r3)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r2 = "Connection"
            java.lang.String r3 = "Keep-Alive"
            r1.setRequestProperty(r2, r3)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r2 = "Charset"
            java.lang.String r3 = "utf-8"
            r1.setRequestProperty(r2, r3)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "application/x-gzip"
            r1.setRequestProperty(r2, r3)     // Catch:{ Exception -> 0x00ae }
            java.io.OutputStream r2 = r1.getOutputStream()     // Catch:{ Exception -> 0x00ae }
            java.util.ArrayList<byte[]> r3 = r7.e     // Catch:{ Exception -> 0x00ae }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x00ae }
        L_0x0057:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x00ae }
            if (r4 == 0) goto L_0x0067
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x00ae }
            byte[] r4 = (byte[]) r4     // Catch:{ Exception -> 0x00ae }
            r2.write(r4)     // Catch:{ Exception -> 0x00ae }
            goto L_0x0057
        L_0x0067:
            r2.flush()     // Catch:{ Exception -> 0x00ae }
            r2.close()     // Catch:{ Exception -> 0x00ae }
            int r2 = r1.getResponseCode()     // Catch:{ Exception -> 0x00ae }
            r3 = 200(0xc8, float:2.8E-43)
            if (r3 != r2) goto L_0x008c
            java.io.InputStream r2 = r1.getInputStream()     // Catch:{ Exception -> 0x00ae }
            byte[] r0 = r7.a((java.io.InputStream) r2)     // Catch:{ Exception -> 0x0087, all -> 0x0082 }
            r7.b((byte[]) r0)     // Catch:{ Exception -> 0x0087, all -> 0x0082 }
            r0 = r2
            goto L_0x00a2
        L_0x0082:
            r0 = move-exception
            r6 = r2
            r2 = r0
            r0 = r6
            goto L_0x00c5
        L_0x0087:
            r0 = move-exception
            r6 = r2
            r2 = r0
            r0 = r6
            goto L_0x00b5
        L_0x008c:
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ Exception -> 0x00ae }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ae }
            java.lang.String r5 = "Http Request Failed: "
            r4.<init>(r5)     // Catch:{ Exception -> 0x00ae }
            r4.append(r2)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x00ae }
            r3.<init>(r2)     // Catch:{ Exception -> 0x00ae }
            r7.a((java.lang.Exception) r3)     // Catch:{ Exception -> 0x00ae }
        L_0x00a2:
            if (r0 == 0) goto L_0x00a7
            r0.close()     // Catch:{ Exception -> 0x00ad }
        L_0x00a7:
            if (r1 == 0) goto L_0x00ad
            r1.disconnect()     // Catch:{ Exception -> 0x00ad }
            return
        L_0x00ad:
            return
        L_0x00ae:
            r2 = move-exception
            goto L_0x00b5
        L_0x00b0:
            r2 = move-exception
            r1 = r0
            goto L_0x00c5
        L_0x00b3:
            r2 = move-exception
            r1 = r0
        L_0x00b5:
            r7.a((java.lang.Exception) r2)     // Catch:{ all -> 0x00c4 }
            if (r0 == 0) goto L_0x00bd
            r0.close()     // Catch:{ Exception -> 0x00c3 }
        L_0x00bd:
            if (r1 == 0) goto L_0x00c3
            r1.disconnect()     // Catch:{ Exception -> 0x00c3 }
            return
        L_0x00c3:
            return
        L_0x00c4:
            r2 = move-exception
        L_0x00c5:
            if (r0 == 0) goto L_0x00ca
            r0.close()     // Catch:{ Exception -> 0x00cf }
        L_0x00ca:
            if (r1 == 0) goto L_0x00cf
            r1.disconnect()     // Catch:{ Exception -> 0x00cf }
        L_0x00cf:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.collector.a.a.g.a():void");
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(a aVar) {
        this.f3501b = aVar;
    }

    public void a(String str, String str2, byte[] bArr) {
        this.e.clear();
        a(bArr);
        try {
            this.d = a(str, str2);
        } catch (MalformedURLException e2) {
            SDKLogger.e("Collector", "url error:" + e2);
        }
    }

    public void a(byte[] bArr) {
        if (bArr != null) {
            this.e.add(bArr);
        }
    }

    public void b(int i) {
        this.f3500a = i;
    }

    public void b(a aVar) {
        this.f3501b = aVar;
        start();
    }

    public void run() {
        if (this.g == 1) {
            a();
        } else {
            b();
        }
    }
}
