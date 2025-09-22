package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

public class t extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3939a = "uuid";
    private static final String e = "yosuid";
    private static final String f = "23346339";

    /* renamed from: b  reason: collision with root package name */
    private Context f3940b = null;

    /* renamed from: c  reason: collision with root package name */
    private String f3941c = null;
    private String d = null;

    public t(Context context) {
        super("uuid");
        this.f3940b = context;
        this.f3941c = null;
        this.d = null;
    }

    public static String a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{str, str2});
        } catch (Exception e2) {
            e2.printStackTrace();
            return str2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00cf, code lost:
        r7 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e7, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e8, code lost:
        r5 = r1;
        r1 = r7;
        r7 = r2;
        r2 = r0;
        r0 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x011b, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x011c, code lost:
        r3 = null;
        r7 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x011f, code lost:
        r1 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0120, code lost:
        r3 = null;
        r7 = r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x016a A[SYNTHETIC, Splitter:B:101:0x016a] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0174 A[SYNTHETIC, Splitter:B:106:0x0174] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e7 A[ExcHandler: all (r7v30 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r1 r3 
      PHI: (r1v25 java.io.InputStream) = (r1v27 java.io.InputStream), (r1v27 java.io.InputStream), (r1v31 java.io.InputStream) binds: [B:36:0x00e3, B:37:?, B:23:0x00b9] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r3v18 java.io.BufferedReader) = (r3v19 java.io.BufferedReader), (r3v19 java.io.BufferedReader), (r3v25 java.io.BufferedReader) binds: [B:36:0x00e3, B:37:?, B:23:0x00b9] A[DONT_GENERATE, DONT_INLINE], Splitter:B:23:0x00b9] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0102 A[SYNTHETIC, Splitter:B:48:0x0102] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x010c A[SYNTHETIC, Splitter:B:53:0x010c] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x011b A[ExcHandler: all (th java.lang.Throwable), Splitter:B:15:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x013b A[SYNTHETIC, Splitter:B:78:0x013b] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0145 A[SYNTHETIC, Splitter:B:83:0x0145] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x014f A[SYNTHETIC, Splitter:B:88:0x014f] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0160 A[SYNTHETIC, Splitter:B:96:0x0160] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String b(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r7 = "ro.yunos.openuuid"
            java.lang.String r0 = ""
            java.lang.String r7 = a(r7, r0)
            r6.d = r7
            java.lang.String r7 = r6.d
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0015
            java.lang.String r7 = r6.d
            return r7
        L_0x0015:
            java.lang.String r7 = "ro.aliyun.clouduuid"
            java.lang.String r0 = ""
            java.lang.String r7 = a(r7, r0)
            r6.f3941c = r7
            java.lang.String r7 = r6.f3941c
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x0031
            java.lang.String r7 = "ro.sys.aliyun.clouduuid"
            java.lang.String r0 = ""
            java.lang.String r7 = a(r7, r0)
            r6.f3941c = r7
        L_0x0031:
            java.lang.String r7 = r6.f3941c
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0182
            r7 = 0
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x0131, all -> 0x012b }
            java.lang.String r1 = "https://cmnsguider.yunos.com:443/genDeviceToken"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0131, all -> 0x012b }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x0131, all -> 0x012b }
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch:{ Exception -> 0x0131, all -> 0x012b }
            r1 = 30000(0x7530, float:4.2039E-41)
            r0.setConnectTimeout(r1)     // Catch:{ Exception -> 0x0127, all -> 0x0123 }
            r0.setReadTimeout(r1)     // Catch:{ Exception -> 0x0127, all -> 0x0123 }
            java.lang.String r1 = "POST"
            r0.setRequestMethod(r1)     // Catch:{ Exception -> 0x0127, all -> 0x0123 }
            r1 = 1
            r0.setDoInput(r1)     // Catch:{ Exception -> 0x0127, all -> 0x0123 }
            r0.setDoOutput(r1)     // Catch:{ Exception -> 0x0127, all -> 0x0123 }
            r1 = 0
            r0.setUseCaches(r1)     // Catch:{ Exception -> 0x0127, all -> 0x0123 }
            java.lang.String r1 = "Content-Type"
            java.lang.String r2 = "application/x-www-form-urlencoded"
            r0.setRequestProperty(r1, r2)     // Catch:{ Exception -> 0x0127, all -> 0x0123 }
            com.umeng.commonsdk.statistics.idtracking.t$1 r1 = new com.umeng.commonsdk.statistics.idtracking.t$1     // Catch:{ Exception -> 0x0127, all -> 0x0123 }
            r1.<init>()     // Catch:{ Exception -> 0x0127, all -> 0x0123 }
            r0.setHostnameVerifier(r1)     // Catch:{ Exception -> 0x0127, all -> 0x0123 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0127, all -> 0x0123 }
            java.lang.String r2 = "appKey="
            r1.<init>(r2)     // Catch:{ Exception -> 0x0127, all -> 0x0123 }
            java.lang.String r2 = "23338940"
            java.lang.String r3 = "UTF-8"
            java.lang.String r2 = java.net.URLEncoder.encode(r2, r3)     // Catch:{ Exception -> 0x0127, all -> 0x0123 }
            r1.append(r2)     // Catch:{ Exception -> 0x0127, all -> 0x0123 }
            java.lang.String r2 = "&uuid="
            r1.append(r2)     // Catch:{ Exception -> 0x0127, all -> 0x0123 }
            java.lang.String r2 = "FC1FE84794417B1BEF276234F6FB4E63"
            java.lang.String r3 = "UTF-8"
            java.lang.String r2 = java.net.URLEncoder.encode(r2, r3)     // Catch:{ Exception -> 0x0127, all -> 0x0123 }
            r1.append(r2)     // Catch:{ Exception -> 0x0127, all -> 0x0123 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0127, all -> 0x0123 }
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x0127, all -> 0x0123 }
            java.io.OutputStream r3 = r0.getOutputStream()     // Catch:{ Exception -> 0x0127, all -> 0x0123 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0127, all -> 0x0123 }
            r2.writeBytes(r1)     // Catch:{ Exception -> 0x011f, all -> 0x011b }
            r2.flush()     // Catch:{ Exception -> 0x011f, all -> 0x011b }
            int r1 = r0.getResponseCode()     // Catch:{ Exception -> 0x011f, all -> 0x011b }
            r3 = 200(0xc8, float:2.8E-43)
            if (r1 != r3) goto L_0x00f6
            java.io.InputStream r1 = r0.getInputStream()     // Catch:{ Exception -> 0x00df, all -> 0x011b }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00da, all -> 0x00d1 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00da, all -> 0x00d1 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x00da, all -> 0x00d1 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00da, all -> 0x00d1 }
            java.lang.StringBuffer r7 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x00cf, all -> 0x00e7 }
            r7.<init>()     // Catch:{ Exception -> 0x00cf, all -> 0x00e7 }
        L_0x00be:
            java.lang.String r4 = r3.readLine()     // Catch:{ Exception -> 0x00cf, all -> 0x00e7 }
            if (r4 == 0) goto L_0x00c8
            r7.append(r4)     // Catch:{ Exception -> 0x00cf, all -> 0x00e7 }
            goto L_0x00be
        L_0x00c8:
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00cf, all -> 0x00e7 }
            r6.d = r7     // Catch:{ Exception -> 0x00cf, all -> 0x00e7 }
            goto L_0x00f8
        L_0x00cf:
            r7 = move-exception
            goto L_0x00e3
        L_0x00d1:
            r3 = move-exception
            r5 = r3
            r3 = r7
            r7 = r2
            r2 = r0
            r0 = r1
            r1 = r5
            goto L_0x015e
        L_0x00da:
            r3 = move-exception
            r5 = r3
            r3 = r7
            r7 = r5
            goto L_0x00e3
        L_0x00df:
            r1 = move-exception
            r3 = r7
            r7 = r1
            r1 = r3
        L_0x00e3:
            r7.printStackTrace()     // Catch:{ Exception -> 0x00ef, all -> 0x00e7 }
            goto L_0x00f8
        L_0x00e7:
            r7 = move-exception
            r5 = r1
            r1 = r7
            r7 = r2
            r2 = r0
            r0 = r5
            goto L_0x015e
        L_0x00ef:
            r7 = move-exception
            r5 = r1
            r1 = r7
            r7 = r2
            r2 = r0
            r0 = r5
            goto L_0x0136
        L_0x00f6:
            r1 = r7
            r3 = r1
        L_0x00f8:
            r2.close()     // Catch:{ Exception -> 0x00fc }
            goto L_0x0100
        L_0x00fc:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0100:
            if (r3 == 0) goto L_0x010a
            r3.close()     // Catch:{ Exception -> 0x0106 }
            goto L_0x010a
        L_0x0106:
            r7 = move-exception
            r7.printStackTrace()
        L_0x010a:
            if (r1 == 0) goto L_0x0114
            r1.close()     // Catch:{ Exception -> 0x0110 }
            goto L_0x0114
        L_0x0110:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0114:
            if (r0 == 0) goto L_0x0182
            r0.disconnect()
            goto L_0x0182
        L_0x011b:
            r1 = move-exception
            r3 = r7
            r7 = r2
            goto L_0x0125
        L_0x011f:
            r1 = move-exception
            r3 = r7
            r7 = r2
            goto L_0x0129
        L_0x0123:
            r1 = move-exception
            r3 = r7
        L_0x0125:
            r2 = r0
            goto L_0x012f
        L_0x0127:
            r1 = move-exception
            r3 = r7
        L_0x0129:
            r2 = r0
            goto L_0x0135
        L_0x012b:
            r0 = move-exception
            r2 = r7
            r3 = r2
            r1 = r0
        L_0x012f:
            r0 = r3
            goto L_0x015e
        L_0x0131:
            r0 = move-exception
            r2 = r7
            r3 = r2
            r1 = r0
        L_0x0135:
            r0 = r3
        L_0x0136:
            r1.printStackTrace()     // Catch:{ all -> 0x015d }
            if (r7 == 0) goto L_0x0143
            r7.close()     // Catch:{ Exception -> 0x013f }
            goto L_0x0143
        L_0x013f:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0143:
            if (r3 == 0) goto L_0x014d
            r3.close()     // Catch:{ Exception -> 0x0149 }
            goto L_0x014d
        L_0x0149:
            r7 = move-exception
            r7.printStackTrace()
        L_0x014d:
            if (r0 == 0) goto L_0x0157
            r0.close()     // Catch:{ Exception -> 0x0153 }
            goto L_0x0157
        L_0x0153:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0157:
            if (r2 == 0) goto L_0x0182
            r2.disconnect()
            goto L_0x0182
        L_0x015d:
            r1 = move-exception
        L_0x015e:
            if (r7 == 0) goto L_0x0168
            r7.close()     // Catch:{ Exception -> 0x0164 }
            goto L_0x0168
        L_0x0164:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0168:
            if (r3 == 0) goto L_0x0172
            r3.close()     // Catch:{ Exception -> 0x016e }
            goto L_0x0172
        L_0x016e:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0172:
            if (r0 == 0) goto L_0x017c
            r0.close()     // Catch:{ Exception -> 0x0178 }
            goto L_0x017c
        L_0x0178:
            r7 = move-exception
            r7.printStackTrace()
        L_0x017c:
            if (r2 == 0) goto L_0x0181
            r2.disconnect()
        L_0x0181:
            throw r1
        L_0x0182:
            java.lang.String r7 = r6.d
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.t.b(java.lang.String):java.lang.String");
    }

    public String f() {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        try {
            if (TextUtils.isEmpty(a("ro.yunos.version", "")) || this.f3940b == null || (sharedPreferences = PreferenceWrapper.getDefault(this.f3940b)) == null) {
                return null;
            }
            String string = sharedPreferences.getString(e, "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            this.d = b(f);
            if (!(TextUtils.isEmpty(this.d) || this.f3940b == null || sharedPreferences == null || (edit = sharedPreferences.edit()) == null)) {
                edit.putString(e, this.d).commit();
            }
            return this.d;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
