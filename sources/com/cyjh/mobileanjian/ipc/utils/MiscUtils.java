package com.cyjh.mobileanjian.ipc.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class MiscUtils {
    public static boolean hasClass(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String parseId(String str) {
        try {
            return new JSONObject(FileUtils.file2Text(str, "GBK")).getString("id");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String parseScriptName(String str) {
        try {
            return new JSONObject(FileUtils.file2Text(str, "GBK")).getString("Name");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x007b A[SYNTHETIC, Splitter:B:26:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0081 A[SYNTHETIC, Splitter:B:30:0x0081] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String sendGet(java.lang.String r3, java.lang.String r4) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0075 }
            r2.<init>()     // Catch:{ Exception -> 0x0075 }
            r2.append(r3)     // Catch:{ Exception -> 0x0075 }
            java.lang.String r3 = "?"
            r2.append(r3)     // Catch:{ Exception -> 0x0075 }
            if (r4 != 0) goto L_0x0014
            java.lang.String r4 = ""
        L_0x0014:
            r2.append(r4)     // Catch:{ Exception -> 0x0075 }
            java.lang.String r3 = r2.toString()     // Catch:{ Exception -> 0x0075 }
            java.net.URL r4 = new java.net.URL     // Catch:{ Exception -> 0x0075 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0075 }
            java.net.URLConnection r3 = r4.openConnection()     // Catch:{ Exception -> 0x0075 }
            java.lang.String r4 = "accept"
            java.lang.String r2 = "*/*"
            r3.setRequestProperty(r4, r2)     // Catch:{ Exception -> 0x0075 }
            java.lang.String r4 = "connection"
            java.lang.String r2 = "Keep-Alive"
            r3.setRequestProperty(r4, r2)     // Catch:{ Exception -> 0x0075 }
            java.lang.String r4 = "user-agent"
            java.lang.String r2 = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)"
            r3.setRequestProperty(r4, r2)     // Catch:{ Exception -> 0x0075 }
            r3.connect()     // Catch:{ Exception -> 0x0075 }
            r3.getHeaderFields()     // Catch:{ Exception -> 0x0075 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0075 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0075 }
            java.io.InputStream r3 = r3.getInputStream()     // Catch:{ Exception -> 0x0075 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0075 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x0075 }
        L_0x004d:
            java.lang.String r3 = r4.readLine()     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            if (r3 == 0) goto L_0x0064
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            r1.<init>()     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            r1.append(r0)     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            r1.append(r3)     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            java.lang.String r3 = r1.toString()     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            r0 = r3
            goto L_0x004d
        L_0x0064:
            r4.close()     // Catch:{ Exception -> 0x0068 }
            return r0
        L_0x0068:
            r3 = move-exception
            r3.printStackTrace()
            return r0
        L_0x006d:
            r3 = move-exception
            r1 = r4
            goto L_0x007f
        L_0x0070:
            r3 = move-exception
            r1 = r4
            goto L_0x0076
        L_0x0073:
            r3 = move-exception
            goto L_0x007f
        L_0x0075:
            r3 = move-exception
        L_0x0076:
            r3.printStackTrace()     // Catch:{ all -> 0x0073 }
            if (r1 == 0) goto L_0x007e
            r1.close()     // Catch:{ Exception -> 0x0068 }
        L_0x007e:
            return r0
        L_0x007f:
            if (r1 == 0) goto L_0x0089
            r1.close()     // Catch:{ Exception -> 0x0085 }
            goto L_0x0089
        L_0x0085:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0089:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.utils.MiscUtils.sendGet(java.lang.String, java.lang.String):java.lang.String");
    }
}
