package com.android.volley.toolbox;

import com.android.volley.l;
import com.android.volley.toolbox.g;
import com.github.kevinsawicki.http.HttpRequest;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.entity.BasicHttpEntity;

public final class j implements i {

    /* renamed from: a  reason: collision with root package name */
    private static final String f537a = "Content-Type";

    /* renamed from: b  reason: collision with root package name */
    private final a f538b;

    /* renamed from: c  reason: collision with root package name */
    private final SSLSocketFactory f539c;

    public interface a {
        String a();
    }

    public j() {
        this((byte) 0);
    }

    private j(byte b2) {
        this(0);
    }

    private j(char c2) {
        this.f538b = null;
        this.f539c = null;
    }

    private static HttpURLConnection a(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    private HttpURLConnection a(URL url, l<?> lVar) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        int i = lVar.i();
        httpURLConnection.setConnectTimeout(i);
        httpURLConnection.setReadTimeout(i);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        if ("https".equals(url.getProtocol()) && this.f539c != null) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.f539c);
        }
        return httpURLConnection;
    }

    private static HttpEntity a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException unused) {
            inputStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(inputStream);
        basicHttpEntity.setContentLength((long) httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    private static void a(HttpURLConnection httpURLConnection, l<?> lVar) throws IOException, com.android.volley.a {
        switch (lVar.f486a) {
            case -1:
                byte[] d = lVar.d();
                if (d != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.addRequestProperty("Content-Type", lVar.c());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(d);
                    dataOutputStream.close();
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod(HttpRequest.METHOD_GET);
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                b(httpURLConnection, lVar);
                return;
            case 2:
                httpURLConnection.setRequestMethod(HttpRequest.METHOD_PUT);
                b(httpURLConnection, lVar);
                return;
            case 3:
                httpURLConnection.setRequestMethod(HttpRequest.METHOD_DELETE);
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod(HttpRequest.METHOD_OPTIONS);
                return;
            case 6:
                httpURLConnection.setRequestMethod(HttpRequest.METHOD_TRACE);
                return;
            case 7:
                httpURLConnection.setRequestMethod(g.a.f536a);
                b(httpURLConnection, lVar);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static void b(HttpURLConnection httpURLConnection, l<?> lVar) throws IOException, com.android.volley.a {
        byte[] g = lVar.g();
        if (g != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", lVar.f());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(g);
            dataOutputStream.close();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a6, code lost:
        r8.setRequestMethod(r0);
        b(r8, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00af, code lost:
        r8.setRequestMethod(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d9, code lost:
        r7 = new org.apache.http.ProtocolVersion("HTTP", 1, 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e5, code lost:
        if (r8.getResponseCode() != -1) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ee, code lost:
        throw new java.io.IOException("Could not retrieve response code from HttpUrlConnection.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ef, code lost:
        r7 = new org.apache.http.message.BasicHttpResponse(new org.apache.http.message.BasicStatusLine(r7, r8.getResponseCode(), r8.getResponseMessage()));
        r7.setEntity(a(r8));
        r8 = r8.getHeaderFields().entrySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0118, code lost:
        if (r8.hasNext() == false) goto L_0x0141;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x011a, code lost:
        r0 = (java.util.Map.Entry) r8.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0124, code lost:
        if (r0.getKey() == null) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0126, code lost:
        r7.addHeader(new org.apache.http.message.BasicHeader((java.lang.String) r0.getKey(), (java.lang.String) ((java.util.List) r0.getValue()).get(0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0141, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.apache.http.HttpResponse a(com.android.volley.l<?> r7, java.util.Map<java.lang.String, java.lang.String> r8) throws java.io.IOException, com.android.volley.a {
        /*
            r6 = this;
            java.lang.String r0 = r7.f487b
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.Map r2 = r7.b()
            r1.putAll(r2)
            r1.putAll(r8)
            com.android.volley.toolbox.j$a r8 = r6.f538b
            if (r8 == 0) goto L_0x0031
            com.android.volley.toolbox.j$a r8 = r6.f538b
            java.lang.String r8 = r8.a()
            if (r8 != 0) goto L_0x0032
            java.io.IOException r7 = new java.io.IOException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r1 = "URL blocked by rewriter: "
            r8.<init>(r1)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x0031:
            r8 = r0
        L_0x0032:
            java.net.URL r0 = new java.net.URL
            r0.<init>(r8)
            java.net.URLConnection r8 = r0.openConnection()
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8
            int r2 = r7.i()
            r8.setConnectTimeout(r2)
            r8.setReadTimeout(r2)
            r2 = 0
            r8.setUseCaches(r2)
            r3 = 1
            r8.setDoInput(r3)
            java.lang.String r4 = "https"
            java.lang.String r0 = r0.getProtocol()
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0067
            javax.net.ssl.SSLSocketFactory r0 = r6.f539c
            if (r0 == 0) goto L_0x0067
            r0 = r8
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0
            javax.net.ssl.SSLSocketFactory r4 = r6.f539c
            r0.setSSLSocketFactory(r4)
        L_0x0067:
            java.util.Set r0 = r1.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x006f:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0085
            java.lang.Object r4 = r0.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r1.get(r4)
            java.lang.String r5 = (java.lang.String) r5
            r8.addRequestProperty(r4, r5)
            goto L_0x006f
        L_0x0085:
            int r0 = r7.f486a
            switch(r0) {
                case -1: goto L_0x00b3;
                case 0: goto L_0x00ad;
                case 1: goto L_0x00a4;
                case 2: goto L_0x00a1;
                case 3: goto L_0x009e;
                case 4: goto L_0x009b;
                case 5: goto L_0x0098;
                case 6: goto L_0x0095;
                case 7: goto L_0x0092;
                default: goto L_0x008a;
            }
        L_0x008a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Unknown method type."
            r7.<init>(r8)
            throw r7
        L_0x0092:
            java.lang.String r0 = "PATCH"
            goto L_0x00a6
        L_0x0095:
            java.lang.String r7 = "TRACE"
            goto L_0x00af
        L_0x0098:
            java.lang.String r7 = "OPTIONS"
            goto L_0x00af
        L_0x009b:
            java.lang.String r7 = "HEAD"
            goto L_0x00af
        L_0x009e:
            java.lang.String r7 = "DELETE"
            goto L_0x00af
        L_0x00a1:
            java.lang.String r0 = "PUT"
            goto L_0x00a6
        L_0x00a4:
            java.lang.String r0 = "POST"
        L_0x00a6:
            r8.setRequestMethod(r0)
            b(r8, r7)
            goto L_0x00d9
        L_0x00ad:
            java.lang.String r7 = "GET"
        L_0x00af:
            r8.setRequestMethod(r7)
            goto L_0x00d9
        L_0x00b3:
            byte[] r0 = r7.d()
            if (r0 == 0) goto L_0x00d9
            r8.setDoOutput(r3)
            java.lang.String r1 = "POST"
            r8.setRequestMethod(r1)
            java.lang.String r1 = "Content-Type"
            java.lang.String r7 = r7.c()
            r8.addRequestProperty(r1, r7)
            java.io.DataOutputStream r7 = new java.io.DataOutputStream
            java.io.OutputStream r1 = r8.getOutputStream()
            r7.<init>(r1)
            r7.write(r0)
            r7.close()
        L_0x00d9:
            org.apache.http.ProtocolVersion r7 = new org.apache.http.ProtocolVersion
            java.lang.String r0 = "HTTP"
            r7.<init>(r0, r3, r3)
            int r0 = r8.getResponseCode()
            r1 = -1
            if (r0 != r1) goto L_0x00ef
            java.io.IOException r7 = new java.io.IOException
            java.lang.String r8 = "Could not retrieve response code from HttpUrlConnection."
            r7.<init>(r8)
            throw r7
        L_0x00ef:
            org.apache.http.message.BasicStatusLine r0 = new org.apache.http.message.BasicStatusLine
            int r1 = r8.getResponseCode()
            java.lang.String r3 = r8.getResponseMessage()
            r0.<init>(r7, r1, r3)
            org.apache.http.message.BasicHttpResponse r7 = new org.apache.http.message.BasicHttpResponse
            r7.<init>(r0)
            org.apache.http.HttpEntity r0 = a((java.net.HttpURLConnection) r8)
            r7.setEntity(r0)
            java.util.Map r8 = r8.getHeaderFields()
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x0114:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x0141
            java.lang.Object r0 = r8.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            if (r1 == 0) goto L_0x0114
            org.apache.http.message.BasicHeader r1 = new org.apache.http.message.BasicHeader
            java.lang.Object r3 = r0.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r0 = r0.getValue()
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            r1.<init>(r3, r0)
            r7.addHeader(r1)
            goto L_0x0114
        L_0x0141:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.j.a(com.android.volley.l, java.util.Map):org.apache.http.HttpResponse");
    }
}
