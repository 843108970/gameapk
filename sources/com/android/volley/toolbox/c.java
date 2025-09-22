package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.b;
import com.android.volley.f;
import com.android.volley.l;
import com.android.volley.p;
import com.android.volley.q;
import com.android.volley.s;
import com.android.volley.t;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

public final class c implements f {

    /* renamed from: a  reason: collision with root package name */
    protected static final boolean f521a = t.f504b;
    private static int d = 3000;
    private static int e = 4096;

    /* renamed from: b  reason: collision with root package name */
    protected final i f522b;

    /* renamed from: c  reason: collision with root package name */
    protected final d f523c;

    public c(i iVar) {
        this(iVar, new d(e));
    }

    private c(i iVar, d dVar) {
        this.f522b = iVar;
        this.f523c = dVar;
    }

    private static Map<String, String> a(Header[] headerArr) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }

    private static void a(long j, l<?> lVar, byte[] bArr, StatusLine statusLine) {
        if (f521a || j > ((long) d)) {
            Object[] objArr = new Object[5];
            objArr[0] = lVar;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(lVar.j.b());
            t.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    private static void a(String str, l<?> lVar, s sVar) throws s {
        p pVar = lVar.j;
        int i = lVar.i();
        try {
            pVar.a(sVar);
            lVar.a(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(i)}));
        } catch (s e2) {
            lVar.a(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(i)}));
            throw e2;
        }
    }

    private static void a(String str, String str2, long j) {
        t.a("HTTP ERROR(%s) %d ms to fetch %s", str, Long.valueOf(SystemClock.elapsedRealtime() - j), str2);
    }

    private static void a(Map<String, String> map, b.a aVar) {
        if (aVar != null) {
            if (aVar.f464b != null) {
                map.put("If-None-Match", aVar.f464b);
            }
            if (aVar.d > 0) {
                map.put("If-Modified-Since", DateUtils.formatDate(new Date(aVar.d)));
            }
        }
    }

    private byte[] a(HttpEntity httpEntity) throws IOException, q {
        q qVar = new q(this.f523c, (int) httpEntity.getContentLength());
        byte[] bArr = null;
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new q();
            }
            byte[] a2 = this.f523c.a(1024);
            while (true) {
                try {
                    int read = content.read(a2);
                    if (read == -1) {
                        break;
                    }
                    qVar.write(a2, 0, read);
                } catch (Throwable th) {
                    th = th;
                    bArr = a2;
                    try {
                        httpEntity.consumeContent();
                    } catch (IOException unused) {
                        t.a("Error occured when calling consumingContent", new Object[0]);
                    }
                    this.f523c.a(bArr);
                    qVar.close();
                    throw th;
                }
            }
            byte[] byteArray = qVar.toByteArray();
            try {
                httpEntity.consumeContent();
            } catch (IOException unused2) {
                t.a("Error occured when calling consumingContent", new Object[0]);
            }
            this.f523c.a(a2);
            qVar.close();
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            httpEntity.consumeContent();
            this.f523c.a(bArr);
            qVar.close();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01ab, code lost:
        r5 = "socket";
        r6 = new com.android.volley.r();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01b2, code lost:
        a(r5, r2, (com.android.volley.s) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008f, code lost:
        r5 = r0;
        r14 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0091, code lost:
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b8, code lost:
        if (r9 > ((long) d)) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00bb, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00bc, code lost:
        r13 = r5;
        r14 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0117, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x011b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x011c, code lost:
        r22 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0124, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0125, code lost:
        r5 = r0;
        r14 = r12;
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x012e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x012f, code lost:
        r22 = r10;
        r14 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0133, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0134, code lost:
        r14 = r5;
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0136, code lost:
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x013a, code lost:
        r5 = r10.getStatusLine().getStatusCode();
        com.android.volley.t.c("Unexpected response code %d for %s", java.lang.Integer.valueOf(r5), r2.f487b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0153, code lost:
        if (r13 != null) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0155, code lost:
        r11 = new com.android.volley.i(r5, r13, r14, false, android.os.SystemClock.elapsedRealtime() - r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0165, code lost:
        if (r5 == 401) goto L_0x0172;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0171, code lost:
        throw new com.android.volley.q(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0172, code lost:
        a("auth", r2, (com.android.volley.s) new com.android.volley.a(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0184, code lost:
        throw new com.android.volley.h((com.android.volley.i) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x018a, code lost:
        throw new com.android.volley.j(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x018b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01a2, code lost:
        throw new java.lang.RuntimeException("Bad URL " + r2.f487b, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01a3, code lost:
        r5 = "connection";
        r6 = new com.android.volley.r();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:101:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:2:0x000f] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0185 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x018b A[ExcHandler: MalformedURLException (r0v0 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:33:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:99:? A[ExcHandler: ConnectTimeoutException (unused org.apache.http.conn.ConnectTimeoutException), SYNTHETIC, Splitter:B:2:0x000f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.android.volley.i a(com.android.volley.l<?> r24) throws com.android.volley.s {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            long r3 = android.os.SystemClock.elapsedRealtime()
        L_0x0008:
            java.util.Map r5 = java.util.Collections.emptyMap()
            r6 = 2
            r7 = 1
            r8 = 0
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0133 }
            r10.<init>()     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0133 }
            com.android.volley.b$a r11 = r2.k     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0133 }
            if (r11 == 0) goto L_0x003b
            java.lang.String r12 = r11.f464b     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0133 }
            if (r12 == 0) goto L_0x0023
            java.lang.String r12 = "If-None-Match"
            java.lang.String r13 = r11.f464b     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0133 }
            r10.put(r12, r13)     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0133 }
        L_0x0023:
            long r12 = r11.d     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0133 }
            r14 = 0
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 <= 0) goto L_0x003b
            java.util.Date r12 = new java.util.Date     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0133 }
            long r13 = r11.d     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0133 }
            r12.<init>(r13)     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0133 }
            java.lang.String r11 = "If-Modified-Since"
            java.lang.String r12 = org.apache.http.impl.cookie.DateUtils.formatDate(r12)     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0133 }
            r10.put(r11, r12)     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0133 }
        L_0x003b:
            com.android.volley.toolbox.i r11 = r1.f522b     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0133 }
            org.apache.http.HttpResponse r10 = r11.a(r2, r10)     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0133 }
            org.apache.http.StatusLine r11 = r10.getStatusLine()     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x012e }
            int r13 = r11.getStatusCode()     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x012e }
            org.apache.http.Header[] r12 = r10.getAllHeaders()     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x012e }
            java.util.Map r12 = a((org.apache.http.Header[]) r12)     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x012e }
            r5 = 304(0x130, float:4.26E-43)
            if (r13 != r5) goto L_0x0094
            com.android.volley.b$a r5 = r2.k     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x008e }
            if (r5 != 0) goto L_0x006f
            com.android.volley.i r5 = new com.android.volley.i     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x008e }
            r15 = 304(0x130, float:4.26E-43)
            r16 = 0
            r18 = 1
            long r13 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x008e }
            r11 = 0
            long r19 = r13 - r3
            r14 = r5
            r17 = r12
            r14.<init>(r15, r16, r17, r18, r19)     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x008e }
            return r5
        L_0x006f:
            java.util.Map<java.lang.String, java.lang.String> r11 = r5.g     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x008e }
            r11.putAll(r12)     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x008e }
            com.android.volley.i r11 = new com.android.volley.i     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x008e }
            r14 = 304(0x130, float:4.26E-43)
            byte[] r15 = r5.f463a     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x008e }
            java.util.Map<java.lang.String, java.lang.String> r5 = r5.g     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x008e }
            r17 = 1
            long r18 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x008e }
            r13 = 0
            long r20 = r18 - r3
            r13 = r11
            r16 = r5
            r18 = r20
            r13.<init>(r14, r15, r16, r17, r18)     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x008e }
            return r11
        L_0x008e:
            r0 = move-exception
            r5 = r0
            r14 = r12
        L_0x0091:
            r13 = 0
            goto L_0x0138
        L_0x0094:
            org.apache.http.HttpEntity r5 = r10.getEntity()     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0124 }
            if (r5 == 0) goto L_0x00a3
            org.apache.http.HttpEntity r5 = r10.getEntity()     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x008e }
            byte[] r5 = r1.a((org.apache.http.HttpEntity) r5)     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x008e }
            goto L_0x00a5
        L_0x00a3:
            byte[] r5 = new byte[r8]     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0124 }
        L_0x00a5:
            long r14 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x011b }
            r16 = 0
            r22 = r10
            long r9 = r14 - r3
            boolean r14 = f521a     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0119 }
            if (r14 != 0) goto L_0x00c0
            int r14 = d     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x00bb }
            long r14 = (long) r14
            int r16 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r16 <= 0) goto L_0x00f4
            goto L_0x00c0
        L_0x00bb:
            r0 = move-exception
            r13 = r5
            r14 = r12
            goto L_0x0121
        L_0x00c0:
            java.lang.String r14 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]"
            r15 = 5
            java.lang.Object[] r15 = new java.lang.Object[r15]     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0119 }
            r15[r8] = r2     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0119 }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0119 }
            r15[r7] = r9     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0119 }
            if (r5 == 0) goto L_0x00d5
            int r9 = r5.length     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x00bb }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x00bb }
            goto L_0x00d7
        L_0x00d5:
            java.lang.String r9 = "null"
        L_0x00d7:
            r15[r6] = r9     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0119 }
            r9 = 3
            int r10 = r11.getStatusCode()     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0119 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0119 }
            r15[r9] = r10     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0119 }
            r9 = 4
            com.android.volley.p r10 = r2.j     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0119 }
            int r10 = r10.b()     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0119 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0119 }
            r15[r9] = r10     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0119 }
            com.android.volley.t.b(r14, r15)     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0119 }
        L_0x00f4:
            r9 = 200(0xc8, float:2.8E-43)
            if (r13 < r9) goto L_0x0110
            r9 = 299(0x12b, float:4.19E-43)
            if (r13 <= r9) goto L_0x00fd
            goto L_0x0110
        L_0x00fd:
            com.android.volley.i r9 = new com.android.volley.i     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0119 }
            r16 = 0
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0119 }
            r14 = 0
            long r17 = r10 - r3
            r10 = r12
            r12 = r9
            r14 = r5
            r15 = r10
            r12.<init>(r13, r14, r15, r16, r17)     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0117 }
            return r9
        L_0x0110:
            r10 = r12
            java.io.IOException r9 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0117 }
            r9.<init>()     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0117 }
            throw r9     // Catch:{ SocketTimeoutException -> 0x01ab, ConnectTimeoutException -> 0x01a3, MalformedURLException -> 0x018b, IOException -> 0x0117 }
        L_0x0117:
            r0 = move-exception
            goto L_0x011f
        L_0x0119:
            r0 = move-exception
            goto L_0x011e
        L_0x011b:
            r0 = move-exception
            r22 = r10
        L_0x011e:
            r10 = r12
        L_0x011f:
            r13 = r5
            r14 = r10
        L_0x0121:
            r10 = r22
            goto L_0x0137
        L_0x0124:
            r0 = move-exception
            r22 = r10
            r10 = r12
            r5 = r0
            r14 = r10
            r10 = r22
            goto L_0x0091
        L_0x012e:
            r0 = move-exception
            r22 = r10
            r14 = r5
            goto L_0x0136
        L_0x0133:
            r0 = move-exception
            r14 = r5
            r10 = 0
        L_0x0136:
            r13 = 0
        L_0x0137:
            r5 = r0
        L_0x0138:
            if (r10 == 0) goto L_0x0185
            org.apache.http.StatusLine r5 = r10.getStatusLine()
            int r5 = r5.getStatusCode()
            java.lang.String r9 = "Unexpected response code %d for %s"
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.Integer r10 = java.lang.Integer.valueOf(r5)
            r6[r8] = r10
            java.lang.String r8 = r2.f487b
            r6[r7] = r8
            com.android.volley.t.c(r9, r6)
            if (r13 == 0) goto L_0x017e
            com.android.volley.i r6 = new com.android.volley.i
            r15 = 0
            long r7 = android.os.SystemClock.elapsedRealtime()
            long r16 = r7 - r3
            r11 = r6
            r12 = r5
            r11.<init>(r12, r13, r14, r15, r16)
            r7 = 401(0x191, float:5.62E-43)
            if (r5 == r7) goto L_0x0172
            r7 = 403(0x193, float:5.65E-43)
            if (r5 != r7) goto L_0x016c
            goto L_0x0172
        L_0x016c:
            com.android.volley.q r2 = new com.android.volley.q
            r2.<init>(r6)
            throw r2
        L_0x0172:
            java.lang.String r5 = "auth"
            com.android.volley.a r7 = new com.android.volley.a
            r7.<init>((com.android.volley.i) r6)
            a((java.lang.String) r5, (com.android.volley.l<?>) r2, (com.android.volley.s) r7)
            goto L_0x0008
        L_0x017e:
            com.android.volley.h r2 = new com.android.volley.h
            r3 = 0
            r2.<init>((com.android.volley.i) r3)
            throw r2
        L_0x0185:
            com.android.volley.j r2 = new com.android.volley.j
            r2.<init>(r5)
            throw r2
        L_0x018b:
            r0 = move-exception
            r3 = r0
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Bad URL "
            r5.<init>(r6)
            java.lang.String r2 = r2.f487b
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r4.<init>(r2, r3)
            throw r4
        L_0x01a3:
            java.lang.String r5 = "connection"
            com.android.volley.r r6 = new com.android.volley.r
            r6.<init>()
            goto L_0x01b2
        L_0x01ab:
            java.lang.String r5 = "socket"
            com.android.volley.r r6 = new com.android.volley.r
            r6.<init>()
        L_0x01b2:
            a((java.lang.String) r5, (com.android.volley.l<?>) r2, (com.android.volley.s) r6)
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.c.a(com.android.volley.l):com.android.volley.i");
    }
}
