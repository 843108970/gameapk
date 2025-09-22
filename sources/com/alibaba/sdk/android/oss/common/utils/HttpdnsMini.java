package com.alibaba.sdk.android.oss.common.utils;

import com.alibaba.sdk.android.oss.common.OSSLog;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpdnsMini {
    private static final String ACCOUNT_ID = "181345";
    private static final int EMPTY_RESULT_HOST_TTL = 30;
    private static final int MAX_HOLD_HOST_NUM = 100;
    private static final int MAX_THREAD_NUM = 5;
    private static final int RESOLVE_TIMEOUT_IN_SEC = 10;
    private static final String SERVER_IP = "203.107.1.1";
    private static final String TAG = "HttpDnsMini";
    private static HttpdnsMini instance;
    /* access modifiers changed from: private */
    public ConcurrentMap<String, HostObject> hostManager = new ConcurrentHashMap();
    private ExecutorService pool = Executors.newFixedThreadPool(5);

    class HostObject {
        private String hostName;
        private String ip;
        private long queryTime;
        private long ttl;

        HostObject() {
        }

        public String getHostName() {
            return this.hostName;
        }

        public String getIp() {
            return this.ip;
        }

        public long getQueryTime() {
            return this.queryTime;
        }

        public long getTtl() {
            return this.ttl;
        }

        public boolean isExpired() {
            return getQueryTime() + this.ttl < System.currentTimeMillis() / 1000;
        }

        public boolean isStillAvailable() {
            return (getQueryTime() + this.ttl) + 600 > System.currentTimeMillis() / 1000;
        }

        public void setHostName(String str) {
            this.hostName = str;
        }

        public void setIp(String str) {
            this.ip = str;
        }

        public void setQueryTime(long j) {
            this.queryTime = j;
        }

        public void setTtl(long j) {
            this.ttl = j;
        }

        public String toString() {
            return "[hostName=" + getHostName() + ", ip=" + this.ip + ", ttl=" + getTtl() + ", queryTime=" + this.queryTime + "]";
        }
    }

    class QueryHostTask implements Callable<String> {
        private boolean hasRetryed = false;
        private String hostName;

        public QueryHostTask(String str) {
            this.hostName = str;
        }

        /* JADX WARNING: Removed duplicated region for block: B:44:0x0132 A[Catch:{ all -> 0x014f }] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x013a A[SYNTHETIC, Splitter:B:46:0x013a] */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0146  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x014e A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x0152 A[SYNTHETIC, Splitter:B:57:0x0152] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String call() {
            /*
                r10 = this;
                java.lang.String r0 = "203.107.1.1"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "http://"
                r1.<init>(r2)
                r1.append(r0)
                java.lang.String r0 = "/181345/d?host="
                r1.append(r0)
                java.lang.String r0 = r10.hostName
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "[httpdnsmini] - buildUrl: "
                r1.<init>(r2)
                r1.append(r0)
                java.lang.String r1 = r1.toString()
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug(r1)
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x0129, all -> 0x0124 }
                r2.<init>(r0)     // Catch:{ Exception -> 0x0129, all -> 0x0124 }
                java.net.URLConnection r0 = r2.openConnection()     // Catch:{ Exception -> 0x0129, all -> 0x0124 }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x0129, all -> 0x0124 }
                r2 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r2)     // Catch:{ Exception -> 0x0129, all -> 0x0124 }
                r0.setReadTimeout(r2)     // Catch:{ Exception -> 0x0129, all -> 0x0124 }
                int r2 = r0.getResponseCode()     // Catch:{ Exception -> 0x0129, all -> 0x0124 }
                r3 = 200(0xc8, float:2.8E-43)
                if (r2 == r3) goto L_0x005f
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0129, all -> 0x0124 }
                java.lang.String r3 = "[httpdnsmini] - responseCodeNot 200, but: "
                r2.<init>(r3)     // Catch:{ Exception -> 0x0129, all -> 0x0124 }
                int r0 = r0.getResponseCode()     // Catch:{ Exception -> 0x0129, all -> 0x0124 }
                r2.append(r0)     // Catch:{ Exception -> 0x0129, all -> 0x0124 }
                java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0129, all -> 0x0124 }
                com.alibaba.sdk.android.oss.common.OSSLog.logError(r0)     // Catch:{ Exception -> 0x0129, all -> 0x0124 }
                r0 = r1
                goto L_0x011c
            L_0x005f:
                java.io.InputStream r0 = r0.getInputStream()     // Catch:{ Exception -> 0x0129, all -> 0x0124 }
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0122 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0122 }
                java.lang.String r4 = "UTF-8"
                r3.<init>(r0, r4)     // Catch:{ Exception -> 0x0122 }
                r2.<init>(r3)     // Catch:{ Exception -> 0x0122 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0122 }
                r3.<init>()     // Catch:{ Exception -> 0x0122 }
            L_0x0074:
                java.lang.String r4 = r2.readLine()     // Catch:{ Exception -> 0x0122 }
                if (r4 == 0) goto L_0x007e
                r3.append(r4)     // Catch:{ Exception -> 0x0122 }
                goto L_0x0074
            L_0x007e:
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0122 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0122 }
                r2.<init>(r3)     // Catch:{ Exception -> 0x0122 }
                java.lang.String r3 = "host"
                java.lang.String r3 = r2.getString(r3)     // Catch:{ Exception -> 0x0122 }
                java.lang.String r4 = "ttl"
                long r4 = r2.getLong(r4)     // Catch:{ Exception -> 0x0122 }
                java.lang.String r6 = "ips"
                org.json.JSONArray r2 = r2.getJSONArray(r6)     // Catch:{ Exception -> 0x0122 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0122 }
                java.lang.String r7 = "[httpdnsmini] - ips:"
                r6.<init>(r7)     // Catch:{ Exception -> 0x0122 }
                java.lang.String r7 = r2.toString()     // Catch:{ Exception -> 0x0122 }
                r6.append(r7)     // Catch:{ Exception -> 0x0122 }
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0122 }
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug(r6)     // Catch:{ Exception -> 0x0122 }
                if (r3 == 0) goto L_0x011c
                if (r2 == 0) goto L_0x011c
                int r6 = r2.length()     // Catch:{ Exception -> 0x0122 }
                if (r6 <= 0) goto L_0x011c
                r6 = 0
                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r8 != 0) goto L_0x00c0
                r4 = 30
            L_0x00c0:
                com.alibaba.sdk.android.oss.common.utils.HttpdnsMini$HostObject r6 = new com.alibaba.sdk.android.oss.common.utils.HttpdnsMini$HostObject     // Catch:{ Exception -> 0x0122 }
                com.alibaba.sdk.android.oss.common.utils.HttpdnsMini r7 = com.alibaba.sdk.android.oss.common.utils.HttpdnsMini.this     // Catch:{ Exception -> 0x0122 }
                r6.<init>()     // Catch:{ Exception -> 0x0122 }
                if (r2 != 0) goto L_0x00cb
                r2 = r1
                goto L_0x00d0
            L_0x00cb:
                r7 = 0
                java.lang.String r2 = r2.getString(r7)     // Catch:{ Exception -> 0x0122 }
            L_0x00d0:
                r6.setHostName(r3)     // Catch:{ Exception -> 0x0122 }
                r6.setTtl(r4)     // Catch:{ Exception -> 0x0122 }
                r6.setIp(r2)     // Catch:{ Exception -> 0x0122 }
                long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0122 }
                r7 = 1000(0x3e8, double:4.94E-321)
                long r3 = r3 / r7
                r6.setQueryTime(r3)     // Catch:{ Exception -> 0x0122 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0122 }
                java.lang.String r4 = "[httpdnsmini] - resolve result:"
                r3.<init>(r4)     // Catch:{ Exception -> 0x0122 }
                java.lang.String r4 = r6.toString()     // Catch:{ Exception -> 0x0122 }
                r3.append(r4)     // Catch:{ Exception -> 0x0122 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0122 }
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug(r3)     // Catch:{ Exception -> 0x0122 }
                com.alibaba.sdk.android.oss.common.utils.HttpdnsMini r3 = com.alibaba.sdk.android.oss.common.utils.HttpdnsMini.this     // Catch:{ Exception -> 0x0122 }
                java.util.concurrent.ConcurrentMap r3 = r3.hostManager     // Catch:{ Exception -> 0x0122 }
                int r3 = r3.size()     // Catch:{ Exception -> 0x0122 }
                r4 = 100
                if (r3 >= r4) goto L_0x0111
                com.alibaba.sdk.android.oss.common.utils.HttpdnsMini r3 = com.alibaba.sdk.android.oss.common.utils.HttpdnsMini.this     // Catch:{ Exception -> 0x0122 }
                java.util.concurrent.ConcurrentMap r3 = r3.hostManager     // Catch:{ Exception -> 0x0122 }
                java.lang.String r4 = r10.hostName     // Catch:{ Exception -> 0x0122 }
                r3.put(r4, r6)     // Catch:{ Exception -> 0x0122 }
            L_0x0111:
                if (r0 == 0) goto L_0x011b
                r0.close()     // Catch:{ IOException -> 0x0117 }
                return r2
            L_0x0117:
                r0 = move-exception
                r0.printStackTrace()
            L_0x011b:
                return r2
            L_0x011c:
                if (r0 == 0) goto L_0x0142
                r0.close()     // Catch:{ IOException -> 0x013e }
                goto L_0x0142
            L_0x0122:
                r2 = move-exception
                goto L_0x012c
            L_0x0124:
                r0 = move-exception
                r9 = r1
                r1 = r0
                r0 = r9
                goto L_0x0150
            L_0x0129:
                r0 = move-exception
                r2 = r0
                r0 = r1
            L_0x012c:
                boolean r3 = com.alibaba.sdk.android.oss.common.OSSLog.isEnableLog()     // Catch:{ all -> 0x014f }
                if (r3 == 0) goto L_0x0138
                r2.printStackTrace()     // Catch:{ all -> 0x014f }
                com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(r2)     // Catch:{ all -> 0x014f }
            L_0x0138:
                if (r0 == 0) goto L_0x0142
                r0.close()     // Catch:{ IOException -> 0x013e }
                goto L_0x0142
            L_0x013e:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0142:
                boolean r0 = r10.hasRetryed
                if (r0 != 0) goto L_0x014e
                r0 = 1
                r10.hasRetryed = r0
                java.lang.String r0 = r10.call()
                return r0
            L_0x014e:
                return r1
            L_0x014f:
                r1 = move-exception
            L_0x0150:
                if (r0 == 0) goto L_0x015a
                r0.close()     // Catch:{ IOException -> 0x0156 }
                goto L_0x015a
            L_0x0156:
                r0 = move-exception
                r0.printStackTrace()
            L_0x015a:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.common.utils.HttpdnsMini.QueryHostTask.call():java.lang.String");
        }
    }

    private HttpdnsMini() {
    }

    public static HttpdnsMini getInstance() {
        if (instance == null) {
            synchronized (HttpdnsMini.class) {
                if (instance == null) {
                    instance = new HttpdnsMini();
                }
            }
        }
        return instance;
    }

    public String getIpByHostAsync(String str) {
        HostObject hostObject = (HostObject) this.hostManager.get(str);
        if (hostObject == null || hostObject.isExpired()) {
            OSSLog.logDebug("[httpdnsmini] - refresh host: " + str);
            this.pool.submit(new QueryHostTask(str));
        }
        if (hostObject == null || !hostObject.isStillAvailable()) {
            return null;
        }
        return hostObject.getIp();
    }
}
