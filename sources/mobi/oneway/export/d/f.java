package mobi.oneway.export.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.github.kevinsawicki.http.HttpRequest;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import mobi.oneway.export.g.j;
import org.json.JSONArray;
import org.json.JSONObject;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4159a = "POST";

    /* renamed from: b  reason: collision with root package name */
    public static final String f4160b = "HEAD";

    /* renamed from: c  reason: collision with root package name */
    public static final String f4161c = "Content-Type";
    public static final String d = "application/json";
    private static final int e = 15000;
    private String f;
    private String g;
    private String h;
    private final Map<String, String> i = new HashMap();
    private final Map<String, String> j = new HashMap();
    private int k = e;
    private int l = e;
    private boolean m = false;
    private File n;
    private boolean o = false;
    private volatile boolean p = false;
    private boolean q = false;
    private long r;
    private long s;
    private boolean t = false;
    private String[] u;
    private String v;
    private int w;

    public interface a {
        void a(int i, int i2, b bVar);

        void b(int i, int i2, b bVar);
    }

    public interface b {
        void a(Throwable th, b bVar);

        void a(b bVar);
    }

    private static class c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public static final int f4162a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static final int f4163b = 1;

        /* renamed from: c  reason: collision with root package name */
        private b f4164c;

        public c(b bVar) {
            super(Looper.getMainLooper());
            this.f4164c = bVar;
        }

        public void handleMessage(Message message) {
            if (message.what == 0) {
                this.f4164c.a((b) message.obj);
                return;
            }
            b bVar = (b) message.obj;
            this.f4164c.a(bVar.m(), bVar);
        }
    }

    public f(String str) {
        b(str);
        this.r = System.currentTimeMillis();
    }

    public f(String[] strArr, String str) {
        this.u = strArr;
        this.v = str;
        this.w = 0;
        this.r = System.currentTimeMillis();
    }

    private int a(HttpURLConnection httpURLConnection, OutputStream outputStream, b bVar) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        int read;
        Thread currentThread = Thread.currentThread();
        try {
            httpURLConnection.getContentLength();
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            try {
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getResponseCode() == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream());
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = null;
                j.a(outputStream, bufferedInputStream, bufferedOutputStream);
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                int i2 = 0;
                while (!e() && !currentThread.isInterrupted() && (read = bufferedInputStream.read(bArr)) != -1) {
                    bufferedOutputStream.write(bArr, 0, read);
                    i2 += read;
                    bufferedOutputStream.flush();
                }
                bufferedOutputStream.flush();
                if (!e() && currentThread.isInterrupted()) {
                    d();
                }
                j.a(outputStream, bufferedInputStream, bufferedOutputStream);
                return i2;
            } catch (Throwable th2) {
                th = th2;
                j.a(outputStream, bufferedInputStream, bufferedOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
            bufferedInputStream = null;
            j.a(outputStream, bufferedInputStream, bufferedOutputStream);
            throw th;
        }
    }

    public static String a(Map<String, String> map, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (String next : map.keySet()) {
            String str = map.get(next);
            if (str != null) {
                if (z) {
                    next = d(next);
                    str = d(str);
                }
                sb.append(next);
                sb.append('=');
                sb.append(str);
                sb.append('&');
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void a(HttpURLConnection httpURLConnection) {
        PrintWriter printWriter;
        String h2;
        if ("POST".equals(g())) {
            try {
                httpURLConnection.setDoOutput(true);
                printWriter = new PrintWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
                try {
                    if (!TextUtils.isEmpty(this.h)) {
                        h2 = this.h;
                    } else {
                        if (!TextUtils.isEmpty(h())) {
                            h2 = h();
                        }
                        printWriter.flush();
                        j.a(printWriter);
                    }
                    printWriter.write(h2);
                    printWriter.flush();
                    j.a(printWriter);
                } catch (Throwable th) {
                    th = th;
                    j.a(printWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                printWriter = null;
                j.a(printWriter);
                throw th;
            }
        }
    }

    private boolean c(int i2) {
        return i2 >= 200 && i2 < 300;
    }

    private static String d(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    private boolean o() {
        return this.n != null;
    }

    private boolean p() {
        return this.u != null && this.u.length > 0 && this.w < this.u.length - 1;
    }

    private HttpURLConnection q() {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(f()).openConnection();
        httpURLConnection.setInstanceFollowRedirects(this.m);
        httpURLConnection.setConnectTimeout(i());
        httpURLConnection.setReadTimeout(j());
        httpURLConnection.setRequestMethod(g());
        httpURLConnection.setRequestProperty(HttpRequest.HEADER_ACCEPT_ENCODING, "");
        if (!this.j.isEmpty()) {
            for (String next : this.j.keySet()) {
                httpURLConnection.setRequestProperty(next, this.j.get(next));
            }
        }
        if (URLUtil.isHttpsUrl(this.f)) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            httpsURLConnection.setHostnameVerifier(d.b());
            httpsURLConnection.setSSLSocketFactory(d.a());
        }
        return httpURLConnection;
    }

    private void r() {
        if (this.g == null) {
            this.g = HttpRequest.METHOD_GET;
        }
        this.g = this.g.toUpperCase();
        if (j() <= 0) {
            throw new IllegalArgumentException("read timeout=" + j() + " is <= 0.");
        } else if (this.k <= 0) {
            throw new IllegalArgumentException("connect timeout=" + i() + " is <= 0.");
        } else {
            if (this.u != null && this.u.length > 0 && !TextUtils.isEmpty(this.v)) {
                this.f = this.u[this.w] + this.v;
            }
            if (!this.i.isEmpty()) {
                String a2 = a(this.i, true);
                if (!"POST".equals(this.g) || !TextUtils.isEmpty(this.h)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f);
                    sb.append(this.f.indexOf("?") > 0 ? "&" : "?");
                    this.f = sb.toString();
                    this.f += a2;
                    return;
                }
                this.h = a2;
            }
        }
    }

    public f a(int i2) {
        this.k = i2;
        return this;
    }

    public f a(int i2, int i3) {
        a(i2);
        b(i3);
        return this;
    }

    public f a(File file) {
        return a(file, false);
    }

    public f a(File file, boolean z) {
        this.n = file;
        this.o = z;
        if (z) {
            a(HttpHeaders.RANGE, "bytes=" + file.length() + "-");
        }
        return this;
    }

    public f a(String str) {
        this.h = str;
        a("Content-Type", "application/json");
        return this;
    }

    public f a(String str, Object obj) {
        if (obj == null) {
            return this;
        }
        this.i.put(str, String.valueOf(obj));
        return this;
    }

    public f a(String str, String str2) {
        this.j.put(str, str2);
        return this;
    }

    public f a(Map<String, String> map) {
        if (map != null && map.size() > 0) {
            this.j.putAll(map);
        }
        return this;
    }

    public f a(JSONArray jSONArray) {
        this.h = jSONArray.toString();
        a("Content-Type", "application/json");
        return this;
    }

    public f a(JSONObject jSONObject) {
        this.h = jSONObject.toString();
        a("Content-Type", "application/json");
        return this;
    }

    public f a(boolean z) {
        this.q = z;
        return this;
    }

    public boolean a() {
        return this.q;
    }

    public f b(int i2) {
        this.l = i2;
        return this;
    }

    public f b(Map<String, String> map) {
        if (map != null && map.size() > 0) {
            this.i.putAll(map);
        }
        return this;
    }

    public f b(boolean z) {
        this.t = z;
        return this;
    }

    public void b(String str) {
        this.f = str;
    }

    public boolean b() {
        return this.t;
    }

    public Map<String, String> c() {
        return this.i;
    }

    public f c(String str) {
        this.g = str;
        return this;
    }

    public f c(boolean z) {
        this.m = z;
        return this;
    }

    public void d() {
        this.p = true;
    }

    public boolean e() {
        return this.p;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public String h() {
        return new URL(this.f).getQuery();
    }

    public int i() {
        return this.k;
    }

    public int j() {
        return this.l;
    }

    public String k() {
        return n().d();
    }

    public byte[] l() {
        return n().c();
    }

    public JSONObject m() {
        return new JSONObject(k());
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00aa A[Catch:{ all -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b8 A[SYNTHETIC, Splitter:B:35:0x00b8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public mobi.oneway.export.d.b n() {
        /*
            r7 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r7.s = r0
            mobi.oneway.export.d.b r0 = new mobi.oneway.export.d.b
            r0.<init>(r7)
            r1 = 0
            r7.r()     // Catch:{ IOException -> 0x00a3 }
            java.net.HttpURLConnection r2 = r7.q()     // Catch:{ IOException -> 0x00a3 }
            r7.a((java.net.HttpURLConnection) r2)     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            int r3 = r2.getResponseCode()     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            r0.a((int) r3)     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            java.util.Map r4 = r2.getHeaderFields()     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            r0.a((java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r4)     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            int r4 = r2.getContentLength()     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            long r5 = (long) r4     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            r0.a((long) r5)     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            boolean r5 = r7.q     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            if (r5 != 0) goto L_0x007d
            boolean r5 = r7.o()     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            if (r5 == 0) goto L_0x0051
            java.io.File r4 = r7.n     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            r0.a((java.io.File) r4)     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            java.io.File r4 = r7.n     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            java.lang.String r4 = r4.getParent()     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            mobi.oneway.export.g.h.c((java.lang.String) r4, (java.lang.String) r1)     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            java.io.File r4 = r7.n     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            boolean r5 = r7.o     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            r1.<init>(r4, r5)     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            r7.a(r2, r1, r0)     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            goto L_0x007d
        L_0x0051:
            r1 = 2097152(0x200000, float:2.938736E-39)
            if (r4 <= r1) goto L_0x006e
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            java.lang.String r3 = "Body is too large to load in memory: contentLength = "
            r1.<init>(r3)     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            r1.append(r4)     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            java.lang.String r3 = " B"
            r1.append(r3)     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            r0.<init>(r1)     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            throw r0     // Catch:{ IOException -> 0x009d, all -> 0x009b }
        L_0x006e:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            r1.<init>()     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            r7.a(r2, r1, r0)     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            byte[] r1 = r1.toByteArray()     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            r0.a((byte[]) r1)     // Catch:{ IOException -> 0x009d, all -> 0x009b }
        L_0x007d:
            boolean r1 = r7.p()     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            if (r1 == 0) goto L_0x0097
            boolean r1 = r7.c((int) r3)     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            if (r1 != 0) goto L_0x0097
            int r0 = r7.w     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            int r0 = r0 + 1
            r7.w = r0     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            mobi.oneway.export.d.b r0 = r7.n()     // Catch:{ IOException -> 0x009d, all -> 0x009b }
            mobi.oneway.export.g.j.a((java.net.HttpURLConnection) r2)
            return r0
        L_0x0097:
            mobi.oneway.export.g.j.a((java.net.HttpURLConnection) r2)
            return r0
        L_0x009b:
            r0 = move-exception
            goto L_0x00b9
        L_0x009d:
            r0 = move-exception
            r1 = r2
            goto L_0x00a4
        L_0x00a0:
            r0 = move-exception
            r2 = r1
            goto L_0x00b9
        L_0x00a3:
            r0 = move-exception
        L_0x00a4:
            boolean r2 = r7.p()     // Catch:{ all -> 0x00a0 }
            if (r2 == 0) goto L_0x00b8
            int r0 = r7.w     // Catch:{ all -> 0x00a0 }
            int r0 = r0 + 1
            r7.w = r0     // Catch:{ all -> 0x00a0 }
            mobi.oneway.export.d.b r0 = r7.n()     // Catch:{ all -> 0x00a0 }
            mobi.oneway.export.g.j.a((java.net.HttpURLConnection) r1)
            return r0
        L_0x00b8:
            throw r0     // Catch:{ all -> 0x00a0 }
        L_0x00b9:
            mobi.oneway.export.g.j.a((java.net.HttpURLConnection) r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: mobi.oneway.export.d.f.n():mobi.oneway.export.d.b");
    }
}
