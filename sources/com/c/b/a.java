package com.c.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import com.c.a.d;
import com.c.d.c;
import com.c.d.f;
import com.c.d.i;
import com.cyjh.common.util.s;
import com.cyjh.mobileanjian.ipc.share.proto.UiMessage;
import com.github.kevinsawicki.http.HttpRequest;
import com.umeng.analytics.pro.b;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HttpContext;
import org.xmlpull.v1.XmlPullParser;

public abstract class a<T, K> implements Runnable {
    private static h M = null;
    private static final Class<?>[] O = {String.class, Object.class, c.class};
    private static ExecutorService Q = null;
    private static SocketFactory R = null;
    private static DefaultHttpClient S = null;
    private static g T = null;
    private static final String V = "\r\n";
    private static final String W = "--";
    private static final String X = "*****";

    /* renamed from: a  reason: collision with root package name */
    public static int f1537a = 30000;
    static int t = 200;
    private static String u = null;
    private static int v = 4;
    private static boolean w = true;
    private static boolean x = true;
    private static boolean y = false;
    private Object A;
    private String B;
    private WeakReference<Object> C;
    private File D;
    private boolean E;
    private int F = 0;
    private boolean G = true;
    private String H = "UTF-8";
    private WeakReference<Activity> I;
    private HttpUriRequest J;
    private boolean K = true;
    private int L = 0;
    private HttpHost N;
    private boolean P;
    private boolean U;

    /* renamed from: b  reason: collision with root package name */
    public Class<T> f1538b;

    /* renamed from: c  reason: collision with root package name */
    public String f1539c;
    String d;
    protected Map<String, Object> e;
    protected Map<String, String> f;
    protected Map<String, String> g;
    public h h;
    protected T i;
    public int j = 0;
    public File k;
    protected com.c.a.a l;
    protected c m;
    protected boolean n;
    protected boolean o;
    public long p;
    public int q = 4;
    public boolean r;
    public boolean s;
    private Reference<Object> z;

    private T A() {
        return this.i;
    }

    private c B() {
        return this.m;
    }

    private String C() {
        return this.H;
    }

    private void D() {
        this.U = true;
        if (this.J != null && !this.J.isAborted()) {
            this.J.abort();
        }
    }

    private String E() {
        if (this.g == null || this.g.size() == 0) {
            return null;
        }
        Iterator<String> it = this.g.keySet().iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            String next = it.next();
            sb.append(next);
            sb.append("=");
            sb.append(this.g.get(next));
            if (it.hasNext()) {
                sb.append("; ");
            }
        }
        return sb.toString();
    }

    private K a(long j2) {
        this.p = j2;
        return this;
    }

    private K a(Activity activity, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 5 && str.startsWith("g.")) {
            this.l = new d(activity, str, str2);
        }
        return this;
    }

    private K a(Dialog dialog) {
        return a((Object) dialog);
    }

    private K a(View view) {
        return a((Object) view);
    }

    private K a(File file) {
        this.k = file;
        return this;
    }

    private K a(Class<T> cls) {
        this.f1538b = cls;
        return this;
    }

    private K a(String str, int i2, String str2, String str3) {
        a(str, i2);
        byte[] bytes = (String.valueOf(str2) + ":" + str3).getBytes();
        StringBuilder sb = new StringBuilder("Basic ");
        sb.append(new String(com.c.d.a.a(bytes, bytes.length)));
        String sb2 = sb.toString();
        com.c.d.a.b((Object) "proxy auth", (Object) sb2);
        return a(HttpRequest.HEADER_PROXY_AUTHORIZATION, sb2);
    }

    private static String a(Uri uri) {
        String str = String.valueOf(uri.getScheme()) + "://" + uri.getAuthority() + uri.getPath();
        String fragment = uri.getFragment();
        if (fragment == null) {
            return str;
        }
        return String.valueOf(str) + "#" + fragment;
    }

    private static String a(HttpEntity httpEntity) {
        Header contentEncoding;
        if (httpEntity == null || (contentEncoding = httpEntity.getContentEncoding()) == null) {
            return null;
        }
        return contentEncoding.getValue();
    }

    private static String a(byte[] bArr, String str, c cVar) {
        String str2;
        String str3 = null;
        try {
            if (!"utf-8".equalsIgnoreCase(str)) {
                return new String(bArr, str);
            }
            String h2 = h(cVar.a("Content-Type"));
            com.c.d.a.b((Object) "parsing header", (Object) h2);
            if (h2 != null) {
                return new String(bArr, h2);
            }
            str2 = new String(bArr, "utf-8");
            try {
                Matcher matcher = Pattern.compile("<meta [^>]*http-equiv[^>]*\"Content-Type\"[^>]*>", 2).matcher(str2);
                if (matcher.find()) {
                    str3 = h(matcher.group());
                }
                com.c.d.a.b((Object) "parsing needed", (Object) str3);
                if (str3 != null && !"utf-8".equalsIgnoreCase(str3)) {
                    com.c.d.a.b((Object) "correction needed", (Object) str3);
                    String str4 = new String(bArr, str3);
                    try {
                        cVar.l = str4.getBytes("utf-8");
                        return str4;
                    } catch (Exception e2) {
                        e = e2;
                        str2 = str4;
                        com.c.d.a.b((Throwable) e);
                        return str2;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                com.c.d.a.b((Throwable) e);
                return str2;
            }
            return str2;
        } catch (Exception e4) {
            e = e4;
            str2 = null;
            com.c.d.a.b((Throwable) e);
            return str2;
        }
    }

    private static HttpResponse a(HttpUriRequest httpUriRequest, DefaultHttpClient defaultHttpClient, HttpContext httpContext) throws ClientProtocolException, IOException {
        if (!httpUriRequest.getURI().getAuthority().contains("_")) {
            return defaultHttpClient.execute(httpUriRequest, httpContext);
        }
        URL url = httpUriRequest.getURI().toURL();
        return defaultHttpClient.execute(url.getPort() == -1 ? new HttpHost(url.getHost(), 80, url.getProtocol()) : new HttpHost(url.getHost(), url.getPort(), url.getProtocol()), httpUriRequest, httpContext);
    }

    private static void a(int i2) {
        f1537a = i2;
    }

    private static void a(g gVar) {
        T = gVar;
    }

    private static void a(h hVar) {
        M = hVar;
    }

    private static void a(DataOutputStream dataOutputStream, String str, Object obj) throws IOException {
        if (obj != null) {
            if (obj instanceof File) {
                File file = (File) obj;
                a(dataOutputStream, str, file.getName(), (InputStream) new FileInputStream(file));
            } else if (obj instanceof byte[]) {
                a(dataOutputStream, str, str, (InputStream) new ByteArrayInputStream((byte[]) obj));
            } else if (obj instanceof InputStream) {
                a(dataOutputStream, str, str, (InputStream) obj);
            } else {
                String obj2 = obj.toString();
                dataOutputStream.writeBytes("--*****\r\n");
                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str + "\"");
                dataOutputStream.writeBytes("\r\n");
                dataOutputStream.writeBytes("\r\n");
                dataOutputStream.write(obj2.getBytes("UTF-8"));
                dataOutputStream.writeBytes("\r\n");
            }
        }
    }

    private static void a(DataOutputStream dataOutputStream, String str, String str2) throws IOException {
        dataOutputStream.writeBytes("--*****\r\n");
        dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str + "\"");
        dataOutputStream.writeBytes("\r\n");
        dataOutputStream.writeBytes("\r\n");
        dataOutputStream.write(str2.getBytes("UTF-8"));
        dataOutputStream.writeBytes("\r\n");
    }

    private static void a(DataOutputStream dataOutputStream, String str, String str2, InputStream inputStream) throws IOException {
        dataOutputStream.writeBytes("--*****\r\n");
        dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n");
        dataOutputStream.writeBytes("Content-Type: application/octet-stream");
        dataOutputStream.writeBytes("\r\n");
        dataOutputStream.writeBytes("Content-Transfer-Encoding: binary");
        dataOutputStream.writeBytes("\r\n");
        dataOutputStream.writeBytes("\r\n");
        com.c.d.a.a(inputStream, (OutputStream) dataOutputStream);
        dataOutputStream.writeBytes("\r\n");
    }

    private static void a(File file, byte[] bArr) {
        if (file != null && bArr != null) {
            com.c.d.a.a(file, bArr);
        }
    }

    private void a(InputStream inputStream, OutputStream outputStream, int i2) throws IOException {
        f fVar = null;
        Object obj = this.C != null ? this.C.get() : null;
        if (obj != null) {
            fVar = new f(obj);
        }
        com.c.d.a.a(inputStream, outputStream, i2, fVar);
    }

    private void a(InputStream inputStream, OutputStream outputStream, int i2, File file, File file2) throws IOException {
        if (file2 == null) {
            a(inputStream, outputStream, i2);
            return;
        }
        try {
            a(inputStream, outputStream, i2);
            inputStream.close();
            outputStream.close();
            file.renameTo(file2);
        } catch (IOException e2) {
            com.c.d.a.a((Object) "copy failed, deleting files");
            file.delete();
            file2.delete();
            com.c.d.a.a((Closeable) inputStream);
            com.c.d.a.a((Closeable) outputStream);
            throw e2;
        }
    }

    private static void a(Runnable runnable) {
        if (Q == null) {
            Q = Executors.newFixedThreadPool(v);
        }
        Q.execute(runnable);
    }

    private void a(String str, c cVar) throws IOException {
        com.c.d.a.b((Object) "get", (Object) str);
        String j2 = j(str);
        a((HttpUriRequest) new HttpGet(j2), j2, cVar);
    }

    private void a(String str, Map<String, Object> map, c cVar) throws ClientProtocolException, IOException {
        com.c.d.a.b((Object) "post", (Object) str);
        a(str, (HttpEntityEnclosingRequestBase) new HttpPost(str), map, cVar);
    }

    private void a(String str, HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, Map<String, Object> map, c cVar) throws ClientProtocolException, IOException {
        HttpEntity httpEntity;
        httpEntityEnclosingRequestBase.getParams().setBooleanParameter("http.protocol.expect-continue", false);
        Object obj = map.get(com.c.d.d.P);
        if (obj instanceof HttpEntity) {
            httpEntity = (HttpEntity) obj;
        } else {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry next : map.entrySet()) {
                Object value = next.getValue();
                if (value != null) {
                    arrayList.add(new BasicNameValuePair((String) next.getKey(), value.toString()));
                }
            }
            httpEntity = new UrlEncodedFormEntity(arrayList, "UTF-8");
        }
        if (this.f != null && !this.f.containsKey("Content-Type")) {
            this.f.put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        }
        httpEntityEnclosingRequestBase.setEntity(httpEntity);
        a((HttpUriRequest) httpEntityEnclosingRequestBase, str, cVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:127:0x027d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x027e, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0280, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0281, code lost:
        r9 = r7;
        r10 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x027d A[ExcHandler: all (r0v5 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:120:0x0265] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02af  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0128  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.apache.http.client.methods.HttpUriRequest r19, java.lang.String r20, com.c.b.c r21) throws org.apache.http.client.ClientProtocolException, java.io.IOException {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            r3 = r21
            org.apache.http.impl.client.DefaultHttpClient r4 = S
            if (r4 == 0) goto L_0x000e
            boolean r4 = x
            if (r4 != 0) goto L_0x0069
        L_0x000e:
            java.lang.String r4 = "creating http client"
            com.c.d.a.a((java.lang.Object) r4)
            org.apache.http.params.BasicHttpParams r4 = new org.apache.http.params.BasicHttpParams
            r4.<init>()
            int r5 = f1537a
            org.apache.http.params.HttpConnectionParams.setConnectionTimeout(r4, r5)
            int r5 = f1537a
            org.apache.http.params.HttpConnectionParams.setSoTimeout(r4, r5)
            org.apache.http.conn.params.ConnPerRouteBean r5 = new org.apache.http.conn.params.ConnPerRouteBean
            r6 = 25
            r5.<init>(r6)
            org.apache.http.conn.params.ConnManagerParams.setMaxConnectionsPerRoute(r4, r5)
            r5 = 8192(0x2000, float:1.14794E-41)
            org.apache.http.params.HttpConnectionParams.setSocketBufferSize(r4, r5)
            org.apache.http.conn.scheme.SchemeRegistry r5 = new org.apache.http.conn.scheme.SchemeRegistry
            r5.<init>()
            org.apache.http.conn.scheme.Scheme r6 = new org.apache.http.conn.scheme.Scheme
            java.lang.String r7 = "http"
            org.apache.http.conn.scheme.PlainSocketFactory r8 = org.apache.http.conn.scheme.PlainSocketFactory.getSocketFactory()
            r9 = 80
            r6.<init>(r7, r8, r9)
            r5.register(r6)
            org.apache.http.conn.scheme.Scheme r6 = new org.apache.http.conn.scheme.Scheme
            java.lang.String r7 = "https"
            org.apache.http.conn.scheme.SocketFactory r8 = R
            if (r8 != 0) goto L_0x0053
            org.apache.http.conn.ssl.SSLSocketFactory r8 = org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory()
            goto L_0x0055
        L_0x0053:
            org.apache.http.conn.scheme.SocketFactory r8 = R
        L_0x0055:
            r9 = 443(0x1bb, float:6.21E-43)
            r6.<init>(r7, r8, r9)
            r5.register(r6)
            org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager r6 = new org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager
            r6.<init>(r4, r5)
            org.apache.http.impl.client.DefaultHttpClient r5 = new org.apache.http.impl.client.DefaultHttpClient
            r5.<init>(r6, r4)
            S = r5
        L_0x0069:
            org.apache.http.impl.client.DefaultHttpClient r4 = S
            java.lang.String r5 = u
            if (r5 == 0) goto L_0x0077
            java.lang.String r5 = "User-Agent"
            java.lang.String r6 = u
        L_0x0073:
            r2.addHeader(r5, r6)
            goto L_0x0084
        L_0x0077:
            java.lang.String r5 = u
            if (r5 != 0) goto L_0x0084
            boolean r5 = w
            if (r5 == 0) goto L_0x0084
            java.lang.String r5 = "User-Agent"
            java.lang.String r6 = "gzip"
            goto L_0x0073
        L_0x0084:
            java.util.Map<java.lang.String, java.lang.String> r5 = r1.f
            if (r5 == 0) goto L_0x00ab
            java.util.Map<java.lang.String, java.lang.String> r5 = r1.f
            java.util.Set r5 = r5.keySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0092:
            boolean r6 = r5.hasNext()
            if (r6 != 0) goto L_0x0099
            goto L_0x00ab
        L_0x0099:
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            java.util.Map<java.lang.String, java.lang.String> r7 = r1.f
            java.lang.Object r7 = r7.get(r6)
            java.lang.String r7 = (java.lang.String) r7
            r2.addHeader(r6, r7)
            goto L_0x0092
        L_0x00ab:
            boolean r5 = w
            if (r5 == 0) goto L_0x00c4
            java.util.Map<java.lang.String, java.lang.String> r5 = r1.f
            if (r5 == 0) goto L_0x00bd
            java.util.Map<java.lang.String, java.lang.String> r5 = r1.f
            java.lang.String r6 = "Accept-Encoding"
            boolean r5 = r5.containsKey(r6)
            if (r5 != 0) goto L_0x00c4
        L_0x00bd:
            java.lang.String r5 = "Accept-Encoding"
            java.lang.String r6 = "gzip"
            r2.addHeader(r5, r6)
        L_0x00c4:
            com.c.a.a r5 = r1.l
            if (r5 == 0) goto L_0x00cd
            com.c.a.a r5 = r1.l
            r5.a((com.c.b.a<?, ?>) r1, (org.apache.http.HttpRequest) r2)
        L_0x00cd:
            java.lang.String r5 = r18.E()
            if (r5 == 0) goto L_0x00d8
            java.lang.String r6 = "Cookie"
            r2.addHeader(r6, r5)
        L_0x00d8:
            org.apache.http.params.HttpParams r5 = r19.getParams()
            org.apache.http.HttpHost r6 = r1.N
            if (r6 == 0) goto L_0x00e7
            java.lang.String r6 = "http.route.default-proxy"
            org.apache.http.HttpHost r7 = r1.N
            r5.setParameter(r6, r7)
        L_0x00e7:
            int r6 = r1.F
            if (r6 <= 0) goto L_0x0101
            java.lang.String r6 = "http.connection.timeout"
            int r7 = r1.F
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r5.setParameter(r6, r7)
            java.lang.String r6 = "http.socket.timeout"
            int r7 = r1.F
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r5.setParameter(r6, r7)
        L_0x0101:
            boolean r6 = r1.G
            if (r6 != 0) goto L_0x010b
            java.lang.String r6 = "http.protocol.handle-redirects"
            r7 = 0
            r5.setBooleanParameter(r6, r7)
        L_0x010b:
            org.apache.http.protocol.BasicHttpContext r6 = new org.apache.http.protocol.BasicHttpContext
            r6.<init>()
            org.apache.http.impl.client.BasicCookieStore r7 = new org.apache.http.impl.client.BasicCookieStore
            r7.<init>()
            java.lang.String r8 = "http.cookie-store"
            r6.setAttribute(r8, r7)
            r1.J = r2
            boolean r7 = r1.U
            if (r7 == 0) goto L_0x0128
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Aborted"
            r2.<init>(r3)
            throw r2
        L_0x0128:
            boolean r7 = y
            if (r7 == 0) goto L_0x0134
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Simulated Error"
            r2.<init>(r3)
            throw r2
        L_0x0134:
            r7 = 0
            org.apache.http.HttpResponse r8 = a((org.apache.http.client.methods.HttpUriRequest) r2, (org.apache.http.impl.client.DefaultHttpClient) r4, (org.apache.http.protocol.HttpContext) r6)     // Catch:{ HttpHostConnectException -> 0x013a }
            goto L_0x014d
        L_0x013a:
            r0 = move-exception
            org.apache.http.HttpHost r8 = r1.N
            if (r8 == 0) goto L_0x02d7
            java.lang.String r8 = "proxy failed, retrying without proxy"
            com.c.d.a.a((java.lang.Object) r8)
            java.lang.String r8 = "http.route.default-proxy"
            r5.setParameter(r8, r7)
            org.apache.http.HttpResponse r8 = a((org.apache.http.client.methods.HttpUriRequest) r2, (org.apache.http.impl.client.DefaultHttpClient) r4, (org.apache.http.protocol.HttpContext) r6)
        L_0x014d:
            org.apache.http.StatusLine r2 = r8.getStatusLine()
            int r2 = r2.getStatusCode()
            org.apache.http.StatusLine r5 = r8.getStatusLine()
            java.lang.String r5 = r5.getReasonPhrase()
            org.apache.http.HttpEntity r9 = r8.getEntity()
            r10 = 200(0xc8, float:2.8E-43)
            if (r2 < r10) goto L_0x025f
            r10 = 300(0x12c, float:4.2E-43)
            if (r2 < r10) goto L_0x016b
            goto L_0x025f
        L_0x016b:
            java.lang.String r10 = "http.target_host"
            java.lang.Object r10 = r6.getAttribute(r10)
            org.apache.http.HttpHost r10 = (org.apache.http.HttpHost) r10
            java.lang.String r11 = "http.request"
            java.lang.Object r11 = r6.getAttribute(r11)
            org.apache.http.client.methods.HttpUriRequest r11 = (org.apache.http.client.methods.HttpUriRequest) r11
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r10 = r10.toURI()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r12.<init>(r10)
            java.net.URI r10 = r11.getURI()
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            r11 = 32
            r12 = 65536(0x10000, float:9.18355E-41)
            long r13 = r9.getContentLength()
            int r13 = (int) r13
            int r12 = java.lang.Math.min(r12, r13)
            int r11 = java.lang.Math.max(r11, r12)
            java.io.File r12 = r18.q()     // Catch:{ all -> 0x0254 }
            if (r12 != 0) goto L_0x01b6
            com.c.d.e r13 = new com.c.d.e     // Catch:{ all -> 0x01b1 }
            r13.<init>(r11)     // Catch:{ all -> 0x01b1 }
            r11 = r7
            goto L_0x01de
        L_0x01b1:
            r0 = move-exception
            r2 = r0
            r13 = r7
            goto L_0x0258
        L_0x01b6:
            java.io.File r11 = new java.io.File     // Catch:{ all -> 0x0254 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0254 }
            java.lang.String r14 = r12.getAbsolutePath()     // Catch:{ all -> 0x0254 }
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ all -> 0x0254 }
            r13.<init>(r14)     // Catch:{ all -> 0x0254 }
            java.lang.String r14 = ".tmp"
            r13.append(r14)     // Catch:{ all -> 0x0254 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0254 }
            r11.<init>(r13)     // Catch:{ all -> 0x0254 }
            r11.createNewFile()     // Catch:{ all -> 0x0254 }
            java.io.BufferedOutputStream r13 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0254 }
            java.io.FileOutputStream r14 = new java.io.FileOutputStream     // Catch:{ all -> 0x0254 }
            r14.<init>(r11)     // Catch:{ all -> 0x0254 }
            r13.<init>(r14)     // Catch:{ all -> 0x0254 }
        L_0x01de:
            java.io.InputStream r14 = r9.getContent()     // Catch:{ all -> 0x0250 }
            java.lang.String r15 = "gzip"
            java.lang.String r7 = a((org.apache.http.HttpEntity) r9)     // Catch:{ all -> 0x024c }
            boolean r7 = r15.equalsIgnoreCase(r7)     // Catch:{ all -> 0x024c }
            if (r7 == 0) goto L_0x01f4
            java.util.zip.GZIPInputStream r7 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x024c }
            r7.<init>(r14)     // Catch:{ all -> 0x024c }
            goto L_0x01f5
        L_0x01f4:
            r7 = r14
        L_0x01f5:
            long r14 = r9.getContentLength()     // Catch:{ all -> 0x0249 }
            int r9 = (int) r14     // Catch:{ all -> 0x0249 }
            if (r12 != 0) goto L_0x0200
            r1.a((java.io.InputStream) r7, (java.io.OutputStream) r13, (int) r9)     // Catch:{ all -> 0x0249 }
            goto L_0x020c
        L_0x0200:
            r1.a((java.io.InputStream) r7, (java.io.OutputStream) r13, (int) r9)     // Catch:{ IOException -> 0x0235 }
            r7.close()     // Catch:{ IOException -> 0x0235 }
            r13.close()     // Catch:{ IOException -> 0x0235 }
            r11.renameTo(r12)     // Catch:{ IOException -> 0x0235 }
        L_0x020c:
            if (r12 != 0) goto L_0x0216
            r9 = r13
            com.c.d.e r9 = (com.c.d.e) r9     // Catch:{ all -> 0x0249 }
            byte[] r9 = r9.toByteArray()     // Catch:{ all -> 0x0249 }
            goto L_0x022b
        L_0x0216:
            boolean r9 = r12.exists()     // Catch:{ all -> 0x0249 }
            if (r9 == 0) goto L_0x0229
            long r14 = r12.length()     // Catch:{ all -> 0x0249 }
            r16 = 0
            int r9 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r9 != 0) goto L_0x0227
            goto L_0x0229
        L_0x0227:
            r9 = 0
            goto L_0x022b
        L_0x0229:
            r9 = 0
            r12 = 0
        L_0x022b:
            com.c.d.a.a((java.io.Closeable) r7)
            com.c.d.a.a((java.io.Closeable) r13)
            r7 = r10
            r10 = 0
            goto L_0x02a4
        L_0x0235:
            r0 = move-exception
            r2 = r0
            java.lang.String r3 = "copy failed, deleting files"
            com.c.d.a.a((java.lang.Object) r3)     // Catch:{ all -> 0x0249 }
            r11.delete()     // Catch:{ all -> 0x0249 }
            r12.delete()     // Catch:{ all -> 0x0249 }
            com.c.d.a.a((java.io.Closeable) r7)     // Catch:{ all -> 0x0249 }
            com.c.d.a.a((java.io.Closeable) r13)     // Catch:{ all -> 0x0249 }
            throw r2     // Catch:{ all -> 0x0249 }
        L_0x0249:
            r0 = move-exception
            r2 = r0
            goto L_0x0258
        L_0x024c:
            r0 = move-exception
            r2 = r0
            r7 = r14
            goto L_0x0258
        L_0x0250:
            r0 = move-exception
            r2 = r0
            r7 = 0
            goto L_0x0258
        L_0x0254:
            r0 = move-exception
            r2 = r0
            r7 = 0
            r13 = 0
        L_0x0258:
            com.c.d.a.a((java.io.Closeable) r7)
            com.c.d.a.a((java.io.Closeable) r13)
            throw r2
        L_0x025f:
            if (r9 == 0) goto L_0x029b
            java.io.InputStream r7 = r9.getContent()     // Catch:{ Exception -> 0x0289, all -> 0x0285 }
            java.lang.String r9 = a((org.apache.http.HttpEntity) r9)     // Catch:{ Exception -> 0x0280, all -> 0x027d }
            byte[] r9 = a((java.lang.String) r9, (java.io.InputStream) r7)     // Catch:{ Exception -> 0x0280, all -> 0x027d }
            java.lang.String r10 = new java.lang.String     // Catch:{ Exception -> 0x0280, all -> 0x027d }
            java.lang.String r11 = "UTF-8"
            r10.<init>(r9, r11)     // Catch:{ Exception -> 0x0280, all -> 0x027d }
            java.lang.String r9 = "error"
            com.c.d.a.b((java.lang.Object) r9, (java.lang.Object) r10)     // Catch:{ Exception -> 0x027a, all -> 0x027d }
            goto L_0x029d
        L_0x027a:
            r0 = move-exception
            r9 = r7
            goto L_0x0283
        L_0x027d:
            r0 = move-exception
            r2 = r0
            goto L_0x0297
        L_0x0280:
            r0 = move-exception
            r9 = r7
            r10 = 0
        L_0x0283:
            r7 = r0
            goto L_0x028d
        L_0x0285:
            r0 = move-exception
            r2 = r0
            r7 = 0
            goto L_0x0297
        L_0x0289:
            r0 = move-exception
            r7 = r0
            r9 = 0
            r10 = 0
        L_0x028d:
            com.c.d.a.a((java.lang.Throwable) r7)     // Catch:{ all -> 0x0294 }
            com.c.d.a.a((java.io.Closeable) r9)
            goto L_0x02a0
        L_0x0294:
            r0 = move-exception
            r2 = r0
            r7 = r9
        L_0x0297:
            com.c.d.a.a((java.io.Closeable) r7)
            throw r2
        L_0x029b:
            r7 = 0
            r10 = 0
        L_0x029d:
            com.c.d.a.a((java.io.Closeable) r7)
        L_0x02a0:
            r7 = r20
            r9 = 0
            r12 = 0
        L_0x02a4:
            java.lang.String r11 = "response"
            java.lang.Integer r13 = java.lang.Integer.valueOf(r2)
            com.c.d.a.b((java.lang.Object) r11, (java.lang.Object) r13)
            if (r9 == 0) goto L_0x02b9
            int r11 = r9.length
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r13 = r20
            com.c.d.a.b((java.lang.Object) r11, (java.lang.Object) r13)
        L_0x02b9:
            r3.i = r2
            r3.j = r5
            r3.w = r10
            r3.k = r7
            java.util.Date r2 = new java.util.Date
            r2.<init>()
            r3.n = r2
            r3.l = r9
            r3.m = r12
            r3.p = r4
            r3.x = r6
            org.apache.http.Header[] r2 = r8.getAllHeaders()
            r3.y = r2
            return
        L_0x02d7:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.a.a(org.apache.http.client.methods.HttpUriRequest, java.lang.String, com.c.b.c):void");
    }

    private static void a(SocketFactory socketFactory) {
        R = socketFactory;
        S = null;
    }

    private static byte[] a(String str, InputStream inputStream) throws IOException {
        return com.c.d.a.a(HttpRequest.ENCODING_GZIP.equalsIgnoreCase(str) ? new GZIPInputStream(inputStream) : inputStream);
    }

    private static File b(File file) throws IOException {
        File file2 = new File(String.valueOf(file.getAbsolutePath()) + ".tmp");
        file2.createNewFile();
        return file2;
    }

    private K b(int i2) {
        this.q = i2;
        return this;
    }

    private K b(h hVar) {
        this.h = hVar;
        return this;
    }

    private K b(String str, String str2) {
        if (this.g == null) {
            this.g = new HashMap();
        }
        this.g.put(str, str2);
        return this;
    }

    private K b(Map<String, String> map) {
        this.f = map;
        return this;
    }

    private static Map<String, Object> b(Uri uri) {
        HashMap hashMap = new HashMap();
        for (String split : uri.getQuery().split("&")) {
            String[] split2 = split.split("=");
            if (split2.length >= 2) {
                hashMap.put(split2[0], split2[1]);
            } else if (split2.length == 1) {
                hashMap.put(split2[0], "");
            }
        }
        return hashMap;
    }

    private void b(String str, c cVar) throws IOException {
        com.c.d.a.b((Object) "get", (Object) str);
        String j2 = j(str);
        a((HttpUriRequest) new HttpDelete(j2), j2, cVar);
    }

    private void b(String str, Map<String, Object> map, c cVar) throws ClientProtocolException, IOException {
        com.c.d.a.b((Object) "put", (Object) str);
        a(str, (HttpEntityEnclosingRequestBase) new HttpPut(str), map, cVar);
    }

    private K c(int i2) {
        this.F = i2;
        return this;
    }

    private K c(Map<String, String> map) {
        this.g = map;
        return this;
    }

    private static String c(String str, String str2) {
        byte[] bytes = (String.valueOf(str) + ":" + str2).getBytes();
        return "Basic " + new String(com.c.d.a.a(bytes, bytes.length));
    }

    public static void c() {
        if (Q != null) {
            Q.shutdownNow();
            Q = null;
        }
        d.d();
    }

    private void c(Context context) {
        T b2 = b(this.f1539c);
        if (b2 != null) {
            this.i = b2;
            c cVar = this.m;
            cVar.r = 4;
            cVar.a();
            a();
            return;
        }
        this.D = com.c.d.a.a(context, this.j);
        if (Q == null) {
            Q = Executors.newFixedThreadPool(v);
        }
        Q.execute(this);
    }

    private static void c(String str) {
        u = str;
    }

    private void c(String str, Map<String, Object> map, c cVar) throws IOException {
        Proxy proxy;
        String str2;
        byte[] bArr;
        com.c.d.a.b((Object) "multipart", (Object) str);
        URL url = new URL(str);
        if (this.N != null) {
            com.c.d.a.b((Object) "proxy", (Object) this.N);
            proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.N.getHostName(), this.N.getPort()));
        } else {
            proxy = T != null ? T.b() : null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) (proxy == null ? url.openConnection() : url.openConnection(proxy));
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setConnectTimeout(f1537a * 4);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;charset=utf-8;boundary=*****");
        if (this.f != null) {
            for (String next : this.f.keySet()) {
                httpURLConnection.setRequestProperty(next, this.f.get(next));
            }
        }
        String E2 = E();
        if (E2 != null) {
            httpURLConnection.setRequestProperty("Cookie", E2);
        }
        if (this.l != null) {
            this.l.a((a<?, ?>) this, httpURLConnection);
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        for (Map.Entry next2 : map.entrySet()) {
            String str3 = (String) next2.getKey();
            Object value = next2.getValue();
            if (value != null) {
                if (value instanceof File) {
                    File file = (File) value;
                    a(dataOutputStream, str3, file.getName(), (InputStream) new FileInputStream(file));
                } else if (value instanceof byte[]) {
                    a(dataOutputStream, str3, str3, (InputStream) new ByteArrayInputStream((byte[]) value));
                } else if (value instanceof InputStream) {
                    a(dataOutputStream, str3, str3, (InputStream) value);
                } else {
                    String obj = value.toString();
                    dataOutputStream.writeBytes("--*****\r\n");
                    dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str3 + "\"");
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.write(obj.getBytes("UTF-8"));
                    dataOutputStream.writeBytes("\r\n");
                }
            }
        }
        dataOutputStream.writeBytes("--*****--\r\n");
        dataOutputStream.flush();
        dataOutputStream.close();
        httpURLConnection.connect();
        int responseCode = httpURLConnection.getResponseCode();
        String responseMessage = httpURLConnection.getResponseMessage();
        String contentEncoding = httpURLConnection.getContentEncoding();
        if (responseCode < 200 || responseCode >= 300) {
            str2 = new String(a(contentEncoding, httpURLConnection.getErrorStream()), "UTF-8");
            com.c.d.a.b((Object) b.J, (Object) str2);
            bArr = null;
        } else {
            bArr = a(contentEncoding, httpURLConnection.getInputStream());
            str2 = null;
        }
        com.c.d.a.b((Object) "response", (Object) Integer.valueOf(responseCode));
        if (bArr != null) {
            com.c.d.a.b((Object) Integer.valueOf(bArr.length), (Object) str);
        }
        cVar.i = responseCode;
        cVar.j = responseMessage;
        cVar.k = str;
        cVar.n = new Date();
        cVar.l = bArr;
        cVar.w = str2;
        cVar.p = null;
    }

    private K d() {
        return this;
    }

    private K d(int i2) {
        this.L = i2;
        return this;
    }

    private K d(String str) {
        this.f1539c = str;
        return this;
    }

    private static void d(boolean z2) {
        w = z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean d(java.util.Map<java.lang.String, java.lang.Object> r2) {
        /*
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0008:
            boolean r0 = r2.hasNext()
            if (r0 != 0) goto L_0x0010
            r2 = 0
            return r2
        L_0x0010:
            java.lang.Object r0 = r2.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getValue()
            java.lang.Object r0 = r0.getKey()
            com.c.d.a.b((java.lang.Object) r0, (java.lang.Object) r1)
            boolean r0 = r1 instanceof java.io.File
            if (r0 != 0) goto L_0x002d
            boolean r0 = r1 instanceof byte[]
            if (r0 != 0) goto L_0x002d
            boolean r0 = r1 instanceof java.io.InputStream
            if (r0 == 0) goto L_0x0008
        L_0x002d:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.a.d(java.util.Map):boolean");
    }

    private K e(int i2) {
        this.j = i2;
        return this;
    }

    private K e(String str) {
        this.d = str;
        return this;
    }

    private void e() {
        this.z = null;
        this.A = null;
        this.C = null;
        this.J = null;
        this.h = null;
        this.l = null;
        this.I = null;
    }

    private static void e(boolean z2) {
        y = z2;
    }

    private Class<T> f() {
        return this.f1538b;
    }

    private K f(String str) {
        this.H = str;
        return this;
    }

    private K f(boolean z2) {
        this.G = z2;
        return this;
    }

    private void f(int i2) throws IOException {
        if (i2 <= 1) {
            s();
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            try {
                s();
                return;
            } catch (IOException e2) {
                if (i3 == i2 - 1) {
                    throw e2;
                }
                i3++;
            }
        }
    }

    private K g(boolean z2) {
        this.E = z2;
        return this;
    }

    private static String g(String str) {
        Matcher matcher = Pattern.compile("<meta [^>]*http-equiv[^>]*\"Content-Type\"[^>]*>", 2).matcher(str);
        if (!matcher.find()) {
            return null;
        }
        return h(matcher.group());
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g() {
        /*
            r1 = this;
            boolean r0 = r1.s
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            r1.notifyAll()     // Catch:{ Exception -> 0x000c }
            goto L_0x000c
        L_0x000a:
            r0 = move-exception
            goto L_0x000e
        L_0x000c:
            monitor-exit(r1)     // Catch:{ all -> 0x000a }
            return
        L_0x000e:
            monitor-exit(r1)     // Catch:{ all -> 0x000a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.a.g():void");
    }

    private static void g(int i2) {
        v = Math.max(1, Math.min(25, i2));
        Q = null;
        com.c.d.a.b((Object) "setting network limit", (Object) Integer.valueOf(v));
    }

    private K h(boolean z2) {
        this.K = z2;
        return this;
    }

    private static String h(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(HttpRequest.PARAM_CHARSET)) == -1) {
            return null;
        }
        int indexOf2 = str.indexOf(";", indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        return str.substring(indexOf + 7, indexOf2).replaceAll("[^\\w-]", "");
    }

    private void h() {
        if (com.c.d.a.b()) {
            throw new IllegalStateException("Cannot block UI thread.");
        } else if (!this.r) {
            try {
                synchronized (this) {
                    this.s = true;
                    wait((long) (f1537a + com.hlzn.socketclient.b.a.t));
                }
            } catch (Exception unused) {
            }
        }
    }

    private static T i() {
        return null;
    }

    private String i(String str) {
        if (this.d != null) {
            str = this.d;
        }
        return this.l != null ? this.l.a(str) : str;
    }

    private static void i(boolean z2) {
        x = z2;
        S = null;
    }

    private static String j(String str) {
        return str.replaceAll(s.a.f1696a, "%20").replaceAll("\\|", "%7C");
    }

    private boolean j() {
        if (this.I == null) {
            return true;
        }
        Activity activity = (Activity) this.I.get();
        return activity != null && !activity.isFinishing();
    }

    private void k() {
        byte[] bArr;
        File a2;
        if (!this.E && this.n && (a2 = a(this.D, l())) != null) {
            this.m.r = 3;
            this.i = a(a2, this.m);
            if (this.i != null) {
                c cVar = this.m;
                cVar.n = new Date(a2.lastModified());
                cVar.a();
            }
        }
        if (this.i == null) {
            this.i = null;
            if (this.i != null) {
                c cVar2 = this.m;
                cVar2.r = 2;
                cVar2.a();
            }
        }
        if (this.i != null) {
            return;
        }
        if (this.f1539c == null) {
            c cVar3 = this.m;
            cVar3.i = c.f;
            cVar3.a();
            return;
        }
        try {
            f(this.L + 1);
            if (this.l != null && this.l.a((a<?, ?>) this, this.m) && !this.P) {
                com.c.d.a.b((Object) "reauth needed", (Object) this.m.j);
                this.P = true;
                if (this.l.b((a<?, ?>) this)) {
                    s();
                } else {
                    this.m.v = true;
                    return;
                }
            }
            bArr = this.m.l;
        } catch (IOException e2) {
            com.c.d.a.a((Object) "IOException");
            String message = e2.getMessage();
            if (message != null && message.contains("No authentication challenges found")) {
                c cVar4 = this.m;
                cVar4.i = UiMessage.CommandToUi.Command_Type.GET_ENABLED_VALUE;
                cVar4.j = message;
                bArr = null;
                this.i = a(bArr, this.m);
                c cVar5 = this.m;
                cVar5.i = c.h;
                cVar5.j = "transform error";
                t = this.m.i;
                this.m.a();
            }
            c cVar6 = this.m;
            cVar6.i = c.f;
            cVar6.j = "network error";
            bArr = null;
            this.i = a(bArr, this.m);
            c cVar52 = this.m;
            cVar52.i = c.h;
            cVar52.j = "transform error";
            t = this.m.i;
            this.m.a();
        } catch (Exception e3) {
            com.c.d.a.a((Throwable) e3);
            c cVar62 = this.m;
            cVar62.i = c.f;
            cVar62.j = "network error";
            bArr = null;
            this.i = a(bArr, this.m);
            c cVar522 = this.m;
            cVar522.i = c.h;
            cVar522.j = "transform error";
            t = this.m.i;
            this.m.a();
        }
        try {
            this.i = a(bArr, this.m);
        } catch (Exception e4) {
            com.c.d.a.a((Throwable) e4);
        }
        if (this.i == null && bArr != null) {
            c cVar5222 = this.m;
            cVar5222.i = c.h;
            cVar5222.j = "transform error";
        }
        t = this.m.i;
        this.m.a();
    }

    private String l() {
        return this.l != null ? this.l.b(this.f1539c) : this.f1539c;
    }

    private void m() {
        File a2 = a(this.D, l());
        if (a2 != null) {
            this.m.r = 3;
            this.i = a(a2, this.m);
            if (this.i != null) {
                c cVar = this.m;
                cVar.n = new Date(a2.lastModified());
                cVar.a();
            }
        }
    }

    private void n() {
        this.i = null;
        if (this.i != null) {
            c cVar = this.m;
            cVar.r = 2;
            cVar.a();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005e, code lost:
        com.c.d.a.a((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005d A[ExcHandler: Exception (r2v3 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:6:0x000f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void o() {
        /*
            r7 = this;
            java.lang.String r0 = r7.f1539c
            r1 = -101(0xffffffffffffff9b, float:NaN)
            if (r0 != 0) goto L_0x000e
            com.c.b.c r0 = r7.m
            r0.i = r1
        L_0x000a:
            r0.a()
            return
        L_0x000e:
            r0 = 0
            int r2 = r7.L     // Catch:{ IOException -> 0x006a, Exception -> 0x005d }
            r3 = 1
            int r2 = r2 + r3
            if (r2 > r3) goto L_0x0019
            r7.s()     // Catch:{ IOException -> 0x006a, Exception -> 0x005d }
            goto L_0x0020
        L_0x0019:
            r4 = 0
        L_0x001a:
            if (r4 < r2) goto L_0x001d
            goto L_0x0020
        L_0x001d:
            r7.s()     // Catch:{ IOException -> 0x0054, Exception -> 0x005d }
        L_0x0020:
            com.c.a.a r2 = r7.l     // Catch:{ IOException -> 0x006a, Exception -> 0x005d }
            if (r2 == 0) goto L_0x004e
            com.c.a.a r2 = r7.l     // Catch:{ IOException -> 0x006a, Exception -> 0x005d }
            com.c.b.c r4 = r7.m     // Catch:{ IOException -> 0x006a, Exception -> 0x005d }
            boolean r2 = r2.a((com.c.b.a<?, ?>) r7, (com.c.b.c) r4)     // Catch:{ IOException -> 0x006a, Exception -> 0x005d }
            if (r2 == 0) goto L_0x004e
            boolean r2 = r7.P     // Catch:{ IOException -> 0x006a, Exception -> 0x005d }
            if (r2 != 0) goto L_0x004e
            java.lang.String r2 = "reauth needed"
            com.c.b.c r4 = r7.m     // Catch:{ IOException -> 0x006a, Exception -> 0x005d }
            java.lang.String r4 = r4.j     // Catch:{ IOException -> 0x006a, Exception -> 0x005d }
            com.c.d.a.b((java.lang.Object) r2, (java.lang.Object) r4)     // Catch:{ IOException -> 0x006a, Exception -> 0x005d }
            r7.P = r3     // Catch:{ IOException -> 0x006a, Exception -> 0x005d }
            com.c.a.a r2 = r7.l     // Catch:{ IOException -> 0x006a, Exception -> 0x005d }
            boolean r2 = r2.b((com.c.b.a<?, ?>) r7)     // Catch:{ IOException -> 0x006a, Exception -> 0x005d }
            if (r2 == 0) goto L_0x0049
            r7.s()     // Catch:{ IOException -> 0x006a, Exception -> 0x005d }
            goto L_0x004e
        L_0x0049:
            com.c.b.c r2 = r7.m     // Catch:{ IOException -> 0x006a, Exception -> 0x005d }
            r2.v = r3     // Catch:{ IOException -> 0x006a, Exception -> 0x005d }
            return
        L_0x004e:
            com.c.b.c r2 = r7.m     // Catch:{ IOException -> 0x006a, Exception -> 0x005d }
            byte[] r2 = r2.l     // Catch:{ IOException -> 0x006a, Exception -> 0x005d }
            r0 = r2
            goto L_0x0086
        L_0x0054:
            r5 = move-exception
            int r6 = r2 + -1
            if (r4 != r6) goto L_0x005a
            throw r5     // Catch:{ IOException -> 0x006a, Exception -> 0x005d }
        L_0x005a:
            int r4 = r4 + 1
            goto L_0x001a
        L_0x005d:
            r2 = move-exception
            com.c.d.a.a((java.lang.Throwable) r2)
        L_0x0061:
            com.c.b.c r2 = r7.m
            r2.i = r1
            java.lang.String r1 = "network error"
            r2.j = r1
            goto L_0x0086
        L_0x006a:
            r2 = move-exception
            java.lang.String r3 = "IOException"
            com.c.d.a.a((java.lang.Object) r3)
            java.lang.String r2 = r2.getMessage()
            if (r2 == 0) goto L_0x0061
            java.lang.String r3 = "No authentication challenges found"
            boolean r3 = r2.contains(r3)
            if (r3 == 0) goto L_0x0061
            com.c.b.c r1 = r7.m
            r3 = 401(0x191, float:5.62E-43)
            r1.i = r3
            r1.j = r2
        L_0x0086:
            com.c.b.c r1 = r7.m     // Catch:{ Exception -> 0x008f }
            java.lang.Object r1 = r7.a((byte[]) r0, (com.c.b.c) r1)     // Catch:{ Exception -> 0x008f }
            r7.i = r1     // Catch:{ Exception -> 0x008f }
            goto L_0x0093
        L_0x008f:
            r1 = move-exception
            com.c.d.a.a((java.lang.Throwable) r1)
        L_0x0093:
            T r1 = r7.i
            if (r1 != 0) goto L_0x00a3
            if (r0 == 0) goto L_0x00a3
            com.c.b.c r0 = r7.m
            r1 = -103(0xffffffffffffff99, float:NaN)
            r0.i = r1
            java.lang.String r1 = "transform error"
            r0.j = r1
        L_0x00a3:
            com.c.b.c r0 = r7.m
            int r0 = r0.i
            t = r0
            com.c.b.c r0 = r7.m
            goto L_0x000a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.a.o():void");
    }

    private File p() {
        return com.c.d.a.a(this.D, l());
    }

    private File q() {
        File file;
        if (!b()) {
            file = null;
        } else if (this.k != null) {
            file = this.k;
        } else if (this.n) {
            file = p();
        } else {
            File c2 = com.c.d.a.c();
            if (c2 == null) {
                c2 = this.D;
            }
            file = com.c.d.a.a(c2, this.f1539c);
        }
        if (file == null || file.exists()) {
            return file;
        }
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
            return file;
        } catch (Exception e2) {
            com.c.d.a.b((Throwable) e2);
            return null;
        }
    }

    private void r() {
        if (this.i != null && this.n) {
            byte[] bArr = this.m.l;
            if (bArr != null) {
                try {
                    if (this.m.r == 1) {
                        File p2 = p();
                        if (!this.m.u) {
                            if (p2 != null) {
                                if (bArr != null) {
                                    com.c.d.a.a(p2, bArr);
                                }
                            }
                        } else if (p2.exists()) {
                            p2.delete();
                        }
                    }
                } catch (Exception e2) {
                    com.c.d.a.a((Throwable) e2);
                }
            }
            this.m.l = null;
        } else if (this.m.i == -103) {
            File p3 = p();
            if (p3.exists()) {
                p3.delete();
                com.c.d.a.a((Object) "invalidated cache due to transform error");
            }
        }
    }

    private void s() throws IOException {
        String str = this.f1539c;
        Map<String, Object> map = this.e;
        if (map == null && str.length() > 2000) {
            Uri parse = Uri.parse(str);
            String str2 = String.valueOf(parse.getScheme()) + "://" + parse.getAuthority() + parse.getPath();
            String fragment = parse.getFragment();
            if (fragment != null) {
                str2 = String.valueOf(str2) + "#" + fragment;
            }
            String str3 = str2;
            map = b(parse);
            str = str3;
        }
        if (this.d != null) {
            str = this.d;
        }
        if (this.l != null) {
            str = this.l.a(str);
        }
        if (2 == this.q) {
            c cVar = this.m;
            com.c.d.a.b((Object) "get", (Object) str);
            String j2 = j(str);
            a((HttpUriRequest) new HttpDelete(j2), j2, cVar);
        } else if (3 == this.q) {
            c cVar2 = this.m;
            com.c.d.a.b((Object) "put", (Object) str);
            a(str, (HttpEntityEnclosingRequestBase) new HttpPut(str), map, cVar2);
        } else {
            if (1 == this.q && map == null) {
                map = new HashMap<>();
            }
            if (map == null) {
                c cVar3 = this.m;
                com.c.d.a.b((Object) "get", (Object) str);
                String j3 = j(str);
                a((HttpUriRequest) new HttpGet(j3), j3, cVar3);
            } else if (d(map)) {
                c(str, map, this.m);
            } else {
                c cVar4 = this.m;
                com.c.d.a.b((Object) "post", (Object) str);
                a(str, (HttpEntityEnclosingRequestBase) new HttpPost(str), map, cVar4);
            }
        }
    }

    private void t() {
        if (this.f1539c != null && this.o) {
            b(this.f1539c, this.i);
        }
        a();
        this.z = null;
        this.A = null;
        this.C = null;
        this.J = null;
        this.h = null;
        this.l = null;
        this.I = null;
    }

    private static int u() {
        if (Q instanceof ThreadPoolExecutor) {
            return ((ThreadPoolExecutor) Q).getActiveCount();
        }
        return 0;
    }

    private static DefaultHttpClient v() {
        if (S == null || !x) {
            com.c.d.a.a((Object) "creating http client");
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, f1537a);
            HttpConnectionParams.setSoTimeout(basicHttpParams, f1537a);
            ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(25));
            HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme("https", R == null ? SSLSocketFactory.getSocketFactory() : R, 443));
            S = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        }
        return S;
    }

    private String w() {
        return this.f1539c;
    }

    private Object x() {
        if (this.A != null) {
            return this.A;
        }
        if (this.z == null) {
            return null;
        }
        return this.z.get();
    }

    private String y() {
        return this.B;
    }

    private static int z() {
        return t;
    }

    /* access modifiers changed from: protected */
    public File a(File file, String str) {
        if (this.p < 0) {
            return null;
        }
        File b2 = com.c.d.a.b(file, str);
        if (b2 == null || this.p == 0 || System.currentTimeMillis() - b2.lastModified() <= this.p) {
            return b2;
        }
        return null;
    }

    public final K a(com.c.a.a aVar) {
        this.l = aVar;
        return this;
    }

    /* access modifiers changed from: protected */
    public T a(File file, c cVar) {
        byte[] bArr;
        try {
            if (b()) {
                cVar.m = file;
                bArr = null;
            } else {
                bArr = com.c.d.a.a((InputStream) new FileInputStream(file));
            }
            return a(bArr, cVar);
        } catch (Exception e2) {
            com.c.d.a.a((Throwable) e2);
            return null;
        }
    }

    public final K a(Object obj) {
        if (obj != null) {
            this.C = new WeakReference<>(obj);
        }
        return this;
    }

    public final K a(Object obj, String str) {
        this.z = new WeakReference(obj);
        this.B = str;
        this.A = null;
        return this;
    }

    public final K a(String str, int i2) {
        this.N = new HttpHost(str, i2);
        return this;
    }

    public final K a(String str, Object obj) {
        if (this.e == null) {
            this.e = new HashMap();
        }
        this.e.put(str, obj);
        return this;
    }

    public final K a(String str, String str2) {
        if (this.f == null) {
            this.f = new HashMap();
        }
        this.f.put(str, str2);
        return this;
    }

    public final K a(Map<String, ?> map) {
        this.e = map;
        return this;
    }

    public final K a(boolean z2) {
        this.n = z2;
        return this;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [T, byte[]] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T a(byte[] r4, com.c.b.c r5) {
        /*
            r3 = this;
            java.lang.Class<T> r0 = r3.f1538b
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.io.File r0 = r5.m
            if (r4 == 0) goto L_0x00b6
            java.lang.Class<T> r0 = r3.f1538b
            java.lang.Class<android.graphics.Bitmap> r2 = android.graphics.Bitmap.class
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x001b
            r5 = 0
            int r0 = r4.length
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeByteArray(r4, r5, r0)
            return r4
        L_0x001b:
            java.lang.Class<T> r0 = r3.f1538b
            java.lang.Class<org.json.JSONObject> r2 = org.json.JSONObject.class
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0044
            java.lang.String r5 = new java.lang.String     // Catch:{ Exception -> 0x003a }
            java.lang.String r0 = r3.H     // Catch:{ Exception -> 0x003a }
            r5.<init>(r4, r0)     // Catch:{ Exception -> 0x003a }
            org.json.JSONTokener r4 = new org.json.JSONTokener     // Catch:{ Exception -> 0x0038 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0038 }
            java.lang.Object r4 = r4.nextValue()     // Catch:{ Exception -> 0x0038 }
            org.json.JSONObject r4 = (org.json.JSONObject) r4     // Catch:{ Exception -> 0x0038 }
            return r4
        L_0x0038:
            r4 = move-exception
            goto L_0x003c
        L_0x003a:
            r4 = move-exception
            r5 = r1
        L_0x003c:
            com.c.d.a.a((java.lang.Throwable) r4)
            com.c.d.a.a((java.lang.Object) r5)
            r4 = r1
            return r4
        L_0x0044:
            java.lang.Class<T> r0 = r3.f1538b
            java.lang.Class<org.json.JSONArray> r2 = org.json.JSONArray.class
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0067
            java.lang.String r5 = new java.lang.String     // Catch:{ Exception -> 0x0061 }
            java.lang.String r0 = r3.H     // Catch:{ Exception -> 0x0061 }
            r5.<init>(r4, r0)     // Catch:{ Exception -> 0x0061 }
            org.json.JSONTokener r4 = new org.json.JSONTokener     // Catch:{ Exception -> 0x0061 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0061 }
            java.lang.Object r4 = r4.nextValue()     // Catch:{ Exception -> 0x0061 }
            org.json.JSONArray r4 = (org.json.JSONArray) r4     // Catch:{ Exception -> 0x0061 }
            return r4
        L_0x0061:
            r4 = move-exception
            com.c.d.a.a((java.lang.Throwable) r4)
            r4 = r1
            return r4
        L_0x0067:
            java.lang.Class<T> r0 = r3.f1538b
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0095
            int r0 = r5.r
            r2 = 1
            if (r0 != r2) goto L_0x0082
            java.lang.String r0 = "network"
            com.c.d.a.a((java.lang.Object) r0)
            java.lang.String r0 = r3.H
            java.lang.String r1 = a((byte[]) r4, (java.lang.String) r0, (com.c.b.c) r5)
            return r1
        L_0x0082:
            java.lang.String r5 = "file"
            com.c.d.a.a((java.lang.Object) r5)
            java.lang.String r5 = new java.lang.String     // Catch:{ Exception -> 0x0090 }
            java.lang.String r0 = r3.H     // Catch:{ Exception -> 0x0090 }
            r5.<init>(r4, r0)     // Catch:{ Exception -> 0x0090 }
            r1 = r5
            return r1
        L_0x0090:
            r4 = move-exception
            com.c.d.a.a((java.lang.Throwable) r4)
            return r1
        L_0x0095:
            java.lang.Class<T> r5 = r3.f1538b
            java.lang.Class<byte[]> r0 = byte[].class
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00a0
            return r4
        L_0x00a0:
            com.c.b.h r4 = r3.h
            if (r4 == 0) goto L_0x00ab
            com.c.b.h r4 = r3.h
            java.lang.Object r4 = r4.a()
            return r4
        L_0x00ab:
            com.c.b.h r4 = M
            if (r4 == 0) goto L_0x0115
            com.c.b.h r4 = M
            java.lang.Object r4 = r4.a()
            return r4
        L_0x00b6:
            if (r0 == 0) goto L_0x0115
            java.lang.Class<T> r4 = r3.f1538b
            java.lang.Class<java.io.File> r2 = java.io.File.class
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L_0x00c3
            return r0
        L_0x00c3:
            java.lang.Class<T> r4 = r3.f1538b
            java.lang.Class<com.c.d.i> r2 = com.c.d.i.class
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L_0x00df
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00da }
            r4.<init>(r0)     // Catch:{ Exception -> 0x00da }
            com.c.d.i r0 = new com.c.d.i     // Catch:{ Exception -> 0x00da }
            r0.<init>((java.io.InputStream) r4)     // Catch:{ Exception -> 0x00da }
            r5.z = r4     // Catch:{ Exception -> 0x00da }
            return r0
        L_0x00da:
            r4 = move-exception
            com.c.d.a.b((java.lang.Throwable) r4)
            return r1
        L_0x00df:
            java.lang.Class<T> r4 = r3.f1538b
            java.lang.Class<org.xmlpull.v1.XmlPullParser> r2 = org.xmlpull.v1.XmlPullParser.class
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L_0x00ff
            org.xmlpull.v1.XmlPullParser r4 = android.util.Xml.newPullParser()
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00fa }
            r2.<init>(r0)     // Catch:{ Exception -> 0x00fa }
            java.lang.String r0 = r3.H     // Catch:{ Exception -> 0x00fa }
            r4.setInput(r2, r0)     // Catch:{ Exception -> 0x00fa }
            r5.z = r2     // Catch:{ Exception -> 0x00fa }
            return r4
        L_0x00fa:
            r4 = move-exception
            com.c.d.a.b((java.lang.Throwable) r4)
            return r1
        L_0x00ff:
            java.lang.Class<T> r4 = r3.f1538b
            java.lang.Class<java.io.InputStream> r2 = java.io.InputStream.class
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L_0x0115
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0111 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0111 }
            r5.z = r4     // Catch:{ Exception -> 0x0111 }
            return r4
        L_0x0111:
            r4 = move-exception
            com.c.d.a.b((java.lang.Throwable) r4)
        L_0x0115:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.a.a(byte[], com.c.b.c):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r2 = (android.app.Activity) r12.I.get();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00e2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r12 = this;
            r0 = 0
            r12.c((boolean) r0)
            r1 = 1
            r12.r = r1
            java.lang.ref.WeakReference<android.app.Activity> r2 = r12.I
            if (r2 == 0) goto L_0x001d
            java.lang.ref.WeakReference<android.app.Activity> r2 = r12.I
            java.lang.Object r2 = r2.get()
            android.app.Activity r2 = (android.app.Activity) r2
            if (r2 == 0) goto L_0x001b
            boolean r2 = r2.isFinishing()
            if (r2 == 0) goto L_0x001d
        L_0x001b:
            r2 = 0
            goto L_0x001e
        L_0x001d:
            r2 = 1
        L_0x001e:
            r3 = 0
            if (r2 == 0) goto L_0x0075
            java.lang.String r2 = r12.B
            if (r2 == 0) goto L_0x0066
            java.lang.Object r2 = r12.A
            if (r2 == 0) goto L_0x002d
            java.lang.Object r2 = r12.A
        L_0x002b:
            r4 = r2
            goto L_0x003a
        L_0x002d:
            java.lang.ref.Reference<java.lang.Object> r2 = r12.z
            if (r2 != 0) goto L_0x0033
            r4 = r3
            goto L_0x003a
        L_0x0033:
            java.lang.ref.Reference<java.lang.Object> r2 = r12.z
            java.lang.Object r2 = r2.get()
            goto L_0x002b
        L_0x003a:
            r2 = 3
            java.lang.Class[] r8 = new java.lang.Class[r2]
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r8[r0] = r5
            java.lang.Class<T> r5 = r12.f1538b
            r8[r1] = r5
            java.lang.Class<com.c.b.c> r5 = com.c.b.c.class
            r6 = 2
            r8[r6] = r5
            java.lang.String r5 = r12.B
            r7 = 1
            r9 = 1
            java.lang.Class<?>[] r10 = O
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r11 = r12.f1539c
            r2[r0] = r11
            T r0 = r12.i
            r2[r1] = r0
            com.c.b.c r0 = r12.m
            r2[r6] = r0
            r6 = r7
            r7 = r9
            r9 = r10
            r10 = r2
            com.c.d.a.a(r4, r5, r6, r7, r8, r9, r10)
            goto L_0x007a
        L_0x0066:
            java.lang.String r0 = r12.f1539c     // Catch:{ Exception -> 0x0070 }
            T r2 = r12.i     // Catch:{ Exception -> 0x0070 }
            com.c.b.c r4 = r12.m     // Catch:{ Exception -> 0x0070 }
            r12.a((java.lang.String) r0, r2, (com.c.b.c) r4)     // Catch:{ Exception -> 0x0070 }
            goto L_0x007a
        L_0x0070:
            r0 = move-exception
            com.c.d.a.b((java.lang.Throwable) r0)
            goto L_0x007a
        L_0x0075:
            java.lang.String r0 = r12.f1539c
            r12.a((java.lang.String) r0)
        L_0x007a:
            T r0 = r12.i
            if (r0 == 0) goto L_0x00b4
            boolean r0 = r12.n
            if (r0 == 0) goto L_0x00b4
            com.c.b.c r0 = r12.m
            byte[] r0 = r0.l
            if (r0 == 0) goto L_0x00af
            com.c.b.c r2 = r12.m     // Catch:{ Exception -> 0x00ab }
            int r2 = r2.r     // Catch:{ Exception -> 0x00ab }
            if (r2 != r1) goto L_0x00af
            java.io.File r1 = r12.p()     // Catch:{ Exception -> 0x00ab }
            com.c.b.c r2 = r12.m     // Catch:{ Exception -> 0x00ab }
            boolean r2 = r2.u     // Catch:{ Exception -> 0x00ab }
            if (r2 != 0) goto L_0x00a1
            if (r1 == 0) goto L_0x00af
            if (r0 != 0) goto L_0x009d
            goto L_0x00af
        L_0x009d:
            com.c.d.a.a((java.io.File) r1, (byte[]) r0)     // Catch:{ Exception -> 0x00ab }
            goto L_0x00af
        L_0x00a1:
            boolean r0 = r1.exists()     // Catch:{ Exception -> 0x00ab }
            if (r0 == 0) goto L_0x00af
            r1.delete()     // Catch:{ Exception -> 0x00ab }
            goto L_0x00af
        L_0x00ab:
            r0 = move-exception
            com.c.d.a.a((java.lang.Throwable) r0)
        L_0x00af:
            com.c.b.c r0 = r12.m
            r0.l = r3
            goto L_0x00ce
        L_0x00b4:
            com.c.b.c r0 = r12.m
            int r0 = r0.i
            r1 = -103(0xffffffffffffff99, float:NaN)
            if (r0 != r1) goto L_0x00ce
            java.io.File r0 = r12.p()
            boolean r1 = r0.exists()
            if (r1 == 0) goto L_0x00ce
            r0.delete()
            java.lang.String r0 = "invalidated cache due to transform error"
            com.c.d.a.a((java.lang.Object) r0)
        L_0x00ce:
            boolean r0 = r12.s
            if (r0 != 0) goto L_0x00d7
            com.c.b.c r0 = r12.m
            r0.b()
        L_0x00d7:
            boolean r0 = r12.s
            if (r0 == 0) goto L_0x00e6
            monitor-enter(r12)
            r12.notifyAll()     // Catch:{ Exception -> 0x00e2 }
            goto L_0x00e2
        L_0x00e0:
            r0 = move-exception
            goto L_0x00e4
        L_0x00e2:
            monitor-exit(r12)     // Catch:{ all -> 0x00e0 }
            goto L_0x00e6
        L_0x00e4:
            monitor-exit(r12)     // Catch:{ all -> 0x00e0 }
            throw r0
        L_0x00e6:
            com.c.d.a.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.a.a():void");
    }

    public final void a(int i2, String str) {
        if (this.m != null) {
            c cVar = this.m;
            cVar.i = i2;
            cVar.j = str;
            cVar.a();
            if (this.K) {
                com.c.d.a.a((Runnable) this);
            } else {
                t();
            }
        }
    }

    public final void a(Activity activity) {
        if (activity.isFinishing()) {
            com.c.d.a.a((Object) "Warning", (Object) "Possible memory leak. Calling ajax with a terminated activity.");
        }
        if (this.f1538b == null) {
            com.c.d.a.a((Object) "Warning", (Object) "type() is not called with response type.");
            return;
        }
        this.I = new WeakReference<>(activity);
        a((Context) activity);
    }

    public void a(Context context) {
        if (this.m == null) {
            this.m = new c();
            c cVar = this.m;
            cVar.k = this.f1539c;
            cVar.o = this.E;
        } else if (this.m.t) {
            c cVar2 = this.m;
            cVar2.q = System.currentTimeMillis() - cVar2.s;
            cVar2.t = false;
            cVar2.b();
            this.i = null;
        }
        c(true);
        if (this.l == null || this.l.a()) {
            T b2 = b(this.f1539c);
            if (b2 != null) {
                this.i = b2;
                c cVar3 = this.m;
                cVar3.r = 4;
                cVar3.a();
                a();
                return;
            }
            this.D = com.c.d.a.a(context, this.j);
            if (Q == null) {
                Q = Executors.newFixedThreadPool(v);
            }
            Q.execute(this);
            return;
        }
        com.c.d.a.b((Object) "auth needed", (Object) this.f1539c);
        this.l.a((a<?, ?>) this);
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
    }

    public void a(String str, T t2, c cVar) {
    }

    public final K b(Object obj, String str) {
        this.A = obj;
        this.B = str;
        this.z = null;
        return this;
    }

    /* access modifiers changed from: protected */
    public T b(String str) {
        return null;
    }

    public final K b(boolean z2) {
        this.o = z2;
        return this;
    }

    /* access modifiers changed from: protected */
    public void b(String str, T t2) {
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return File.class.equals(this.f1538b) || XmlPullParser.class.equals(this.f1538b) || InputStream.class.equals(this.f1538b) || i.class.equals(this.f1538b);
    }

    /* access modifiers changed from: protected */
    public final boolean b(Context context) {
        return this.n && com.c.d.a.b(com.c.d.a.a(context, this.j), this.f1539c) != null;
    }

    /* access modifiers changed from: protected */
    public final void c(final boolean z2) {
        final Object obj = this.C == null ? null : this.C.get();
        if (obj == null) {
            return;
        }
        if (com.c.d.a.b()) {
            c.a(obj, this.f1539c, z2);
        } else {
            com.c.d.a.a((Runnable) new Runnable() {
                public final void run() {
                    c.a(obj, a.this.f1539c, z2);
                }
            });
        }
    }

    public void run() {
        File a2;
        if (!this.m.t) {
            try {
                if (!this.E && this.n && (a2 = a(this.D, l())) != null) {
                    this.m.r = 3;
                    this.i = a(a2, this.m);
                    if (this.i != null) {
                        c cVar = this.m;
                        cVar.n = new Date(a2.lastModified());
                        cVar.a();
                    }
                }
                if (this.i == null) {
                    this.i = null;
                    if (this.i != null) {
                        c cVar2 = this.m;
                        cVar2.r = 2;
                        cVar2.a();
                    }
                }
                if (this.i == null) {
                    o();
                }
            } catch (Throwable th) {
                com.c.d.a.a(th);
                c cVar3 = this.m;
                cVar3.i = c.f;
                cVar3.a();
            }
            if (this.m.v) {
                return;
            }
            if (this.K) {
                com.c.d.a.a((Runnable) this);
            } else {
                t();
            }
        } else {
            t();
        }
    }
}
