package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class m {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3639a = "fs_lc_tl";
    private static final String e = "-1";
    private static Context f;

    /* renamed from: b  reason: collision with root package name */
    private final int f3640b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3641c;
    private final int d;
    private JSONObject g;

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final m f3642a = new m();

        private a() {
        }
    }

    private m() {
        this.f3640b = 128;
        this.f3641c = 256;
        this.d = 10;
        this.g = null;
        try {
            if (this.g == null) {
                b(f);
            }
        } catch (Throwable unused) {
        }
    }

    public static m a(Context context) {
        if (f == null && context != null) {
            f = context.getApplicationContext();
        }
        return a.f3642a;
    }

    private JSONObject a(Map<String, Object> map) {
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry next : map.entrySet()) {
                try {
                    String str = (String) next.getKey();
                    if (str != null) {
                        String subStr = HelperUtils.subStr(str, 128);
                        Object value = next.getValue();
                        if (value != null) {
                            int i = 0;
                            if (value.getClass().isArray()) {
                                if (value instanceof int[]) {
                                    int[] iArr = (int[]) value;
                                    jSONArray = new JSONArray();
                                    while (i < iArr.length) {
                                        jSONArray.put(iArr[i]);
                                        i++;
                                    }
                                } else if (value instanceof double[]) {
                                    double[] dArr = (double[]) value;
                                    jSONArray = new JSONArray();
                                    while (i < dArr.length) {
                                        jSONArray.put(dArr[i]);
                                        i++;
                                    }
                                } else if (value instanceof long[]) {
                                    long[] jArr = (long[]) value;
                                    jSONArray = new JSONArray();
                                    while (i < jArr.length) {
                                        jSONArray.put(jArr[i]);
                                        i++;
                                    }
                                } else if (value instanceof float[]) {
                                    float[] fArr = (float[]) value;
                                    jSONArray = new JSONArray();
                                    while (i < fArr.length) {
                                        jSONArray.put((double) fArr[i]);
                                        i++;
                                    }
                                } else if (value instanceof short[]) {
                                    short[] sArr = (short[]) value;
                                    jSONArray = new JSONArray();
                                    while (i < sArr.length) {
                                        jSONArray.put(sArr[i]);
                                        i++;
                                    }
                                }
                            } else if (value instanceof List) {
                                List list = (List) value;
                                jSONArray = new JSONArray();
                                while (i < list.size()) {
                                    Object obj = list.get(i);
                                    if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                                        jSONArray.put(list.get(i));
                                    }
                                    i++;
                                }
                                if (jSONArray.length() > 0) {
                                }
                            } else {
                                if (value instanceof String) {
                                    value = HelperUtils.subStr(value.toString(), 256);
                                } else if (!(value instanceof Long) && !(value instanceof Integer) && !(value instanceof Float) && !(value instanceof Double)) {
                                    if (!(value instanceof Short)) {
                                        MLog.e("The param has not support type. please check !");
                                    }
                                }
                                jSONObject.put(subStr, value);
                            }
                            jSONObject.put(subStr, jSONArray);
                        }
                    }
                } catch (Exception e2) {
                    MLog.e((Throwable) e2);
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void a() {
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f, "track_list", "");
            if (!TextUtils.isEmpty(imprintProperty)) {
                String[] split = imprintProperty.split("!");
                JSONObject jSONObject = new JSONObject();
                int i = 0;
                if (this.g != null) {
                    for (String subStr : split) {
                        String subStr2 = HelperUtils.subStr(subStr, 128);
                        if (this.g.has(subStr2)) {
                            jSONObject.put(subStr2, this.g.get(subStr2));
                        }
                    }
                }
                this.g = new JSONObject();
                if (split.length >= 10) {
                    while (i < 10) {
                        a(split[i], jSONObject);
                        i++;
                    }
                } else {
                    while (i < split.length) {
                        a(split[i], jSONObject);
                        i++;
                    }
                }
                c(f);
            }
        } catch (Exception unused) {
        }
    }

    private void a(String str, JSONObject jSONObject) throws JSONException {
        String subStr = HelperUtils.subStr(str, 128);
        a(subStr, jSONObject.has(subStr) ? ((Boolean) jSONObject.get(subStr)).booleanValue() : false);
    }

    private void a(String str, boolean z) {
        try {
            if (!b.T.equals(str) && !b.R.equals(str) && !"id".equals(str) && !"ts".equals(str) && !this.g.has(str)) {
                this.g.put(str, z);
            }
        } catch (Exception unused) {
        }
    }

    private boolean a(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length > 0 && length <= 128) {
                    return true;
                }
            } catch (Exception unused) {
                return false;
            }
        }
        MLog.e("Event id is empty or too long in tracking Event");
        return false;
    }

    private void b(Context context) {
        try {
            String string = PreferenceWrapper.getDefault(context).getString(f3639a, (String) null);
            if (!TextUtils.isEmpty(string)) {
                this.g = new JSONObject(string);
            }
            a();
        } catch (Exception unused) {
        }
    }

    private boolean b(String str) {
        if (str == null) {
            return true;
        }
        try {
            if (str.trim().getBytes().length <= 256) {
                return true;
            }
            MLog.e("Event label or value is empty or too long in tracking Event");
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean b(Map<String, Object> map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    for (Map.Entry next : map.entrySet()) {
                        if (!a((String) next.getKey())) {
                            MLog.e("map has NULL key. please check!");
                            return false;
                        } else if (next.getValue() == null) {
                            return false;
                        } else {
                            if ((next.getValue() instanceof String) && !b(next.getValue().toString())) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            } catch (Exception unused) {
                return true;
            }
        }
        MLog.e("map is null or empty in onEvent");
        return false;
    }

    private void c(Context context) {
        try {
            if (this.g != null) {
                PreferenceWrapper.getDefault(f).edit().putString(f3639a, this.g.toString()).commit();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0059 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005e A[Catch:{ Throwable -> 0x0092, Throwable -> 0x00cb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.Object r7) {
        /*
            r6 = this;
            com.umeng.analytics.pro.i$d r7 = (com.umeng.analytics.pro.i.d) r7     // Catch:{ Throwable -> 0x00cb }
            java.lang.String r0 = r7.c()     // Catch:{ Throwable -> 0x00cb }
            java.util.Map r1 = r7.a()     // Catch:{ Throwable -> 0x00cb }
            java.lang.String r2 = r7.b()     // Catch:{ Throwable -> 0x00cb }
            long r3 = r7.d()     // Catch:{ Throwable -> 0x00cb }
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Throwable -> 0x00cb }
            if (r7 == 0) goto L_0x0019
            return
        L_0x0019:
            r7 = 128(0x80, float:1.794E-43)
            java.lang.String r7 = com.umeng.commonsdk.statistics.common.HelperUtils.subStr(r0, r7)     // Catch:{ Throwable -> 0x00cb }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Throwable -> 0x00cb }
            r0.<init>()     // Catch:{ Throwable -> 0x00cb }
            java.lang.String r5 = "_$!id"
            r0.put(r5, r7)     // Catch:{ Throwable -> 0x00cb }
            java.lang.String r5 = "_$!ts"
            r0.put(r5, r3)     // Catch:{ Throwable -> 0x00cb }
            com.umeng.analytics.pro.o r3 = com.umeng.analytics.pro.o.a()     // Catch:{ Throwable -> 0x00cb }
            java.lang.String r3 = r3.c()     // Catch:{ Throwable -> 0x00cb }
            java.lang.String r4 = "__ii"
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Throwable -> 0x00cb }
            if (r5 == 0) goto L_0x0040
            java.lang.String r3 = "-1"
        L_0x0040:
            r0.put(r4, r3)     // Catch:{ Throwable -> 0x00cb }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Throwable -> 0x00cb }
            if (r3 != 0) goto L_0x0059
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0059 }
            r3.<init>(r2)     // Catch:{ JSONException -> 0x0059 }
            int r2 = r3.length()     // Catch:{ JSONException -> 0x0059 }
            if (r2 <= 0) goto L_0x0059
            java.lang.String r2 = "_$!sp"
            r0.put(r2, r3)     // Catch:{ JSONException -> 0x0059 }
        L_0x0059:
            r6.a()     // Catch:{ Throwable -> 0x00cb }
            if (r1 == 0) goto L_0x0097
            org.json.JSONObject r1 = r6.a((java.util.Map<java.lang.String, java.lang.Object>) r1)     // Catch:{ Throwable -> 0x00cb }
            int r2 = r1.length()     // Catch:{ Throwable -> 0x00cb }
            if (r2 <= 0) goto L_0x0097
            java.util.Iterator r2 = r1.keys()     // Catch:{ Throwable -> 0x00cb }
        L_0x006c:
            boolean r3 = r2.hasNext()     // Catch:{ Throwable -> 0x00cb }
            if (r3 == 0) goto L_0x0097
            java.lang.Object r3 = r2.next()     // Catch:{ Throwable -> 0x0092 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Throwable -> 0x0092 }
            java.lang.String[] r4 = com.umeng.analytics.pro.b.aq     // Catch:{ Throwable -> 0x0092 }
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ Throwable -> 0x0092 }
            boolean r4 = r4.contains(r3)     // Catch:{ Throwable -> 0x0092 }
            if (r4 != 0) goto L_0x008c
            java.lang.Object r4 = r1.get(r3)     // Catch:{ Throwable -> 0x0092 }
            r0.put(r3, r4)     // Catch:{ Throwable -> 0x0092 }
            goto L_0x006c
        L_0x008c:
            java.lang.String r3 = "the key in map about track interface is invalid.  "
            com.umeng.commonsdk.statistics.common.MLog.e((java.lang.String) r3)     // Catch:{ Throwable -> 0x0092 }
            goto L_0x006c
        L_0x0092:
            r3 = move-exception
            com.umeng.commonsdk.statistics.common.MLog.e((java.lang.Throwable) r3)     // Catch:{ Throwable -> 0x00cb }
            goto L_0x006c
        L_0x0097:
            org.json.JSONObject r1 = r6.g     // Catch:{ Throwable -> 0x00cb }
            if (r1 == 0) goto L_0x00c1
            org.json.JSONObject r1 = r6.g     // Catch:{ Throwable -> 0x00cb }
            boolean r1 = r1.has(r7)     // Catch:{ Throwable -> 0x00cb }
            if (r1 == 0) goto L_0x00c1
            org.json.JSONObject r1 = r6.g     // Catch:{ Throwable -> 0x00cb }
            java.lang.Object r1 = r1.get(r7)     // Catch:{ Throwable -> 0x00cb }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ Throwable -> 0x00cb }
            boolean r1 = r1.booleanValue()     // Catch:{ Throwable -> 0x00cb }
            if (r1 != 0) goto L_0x00c1
            java.lang.String r1 = "$st_fl"
            r2 = 1
            r0.put(r1, r2)     // Catch:{ Throwable -> 0x00cb }
            org.json.JSONObject r1 = r6.g     // Catch:{ Throwable -> 0x00cb }
            r1.put(r7, r2)     // Catch:{ Throwable -> 0x00cb }
            android.content.Context r7 = f     // Catch:{ Throwable -> 0x00cb }
            r6.c(r7)     // Catch:{ Throwable -> 0x00cb }
        L_0x00c1:
            android.content.Context r7 = f     // Catch:{ Throwable -> 0x00cb }
            com.umeng.analytics.pro.i r7 = com.umeng.analytics.pro.i.a((android.content.Context) r7)     // Catch:{ Throwable -> 0x00cb }
            r1 = 0
            r7.a(r0, r1, r1)     // Catch:{ Throwable -> 0x00cb }
        L_0x00cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.m.a(java.lang.Object):void");
    }

    public void a(String str, String str2, long j, int i) {
        try {
            if (a(str) && b(str2)) {
                if (Arrays.asList(b.ap).contains(str)) {
                    MLog.e("the id is valid!");
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", System.currentTimeMillis());
                if (j > 0) {
                    jSONObject.put(b.R, j);
                }
                jSONObject.put("__t", g.f3609a);
                if (str2 == null) {
                    str2 = "";
                }
                jSONObject.put(str, str2);
                String c2 = o.a().c();
                if (TextUtils.isEmpty(c2)) {
                    c2 = e;
                }
                jSONObject.put("__i", c2);
                UMWorkDispatch.sendEvent(f, 4097, CoreProtocol.getInstance(f), jSONObject);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(String str, Map<String, Object> map) {
        try {
            if (a(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put(b.R, 0);
                jSONObject.put("__t", g.f3610b);
                Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
                for (int i = 0; i < 10 && it.hasNext(); i++) {
                    Map.Entry next = it.next();
                    if (!b.T.equals(next.getKey()) && !b.R.equals(next.getKey()) && !"id".equals(next.getKey()) && !"ts".equals(next.getKey())) {
                        Object value = next.getValue();
                        if ((value instanceof String) || (value instanceof Integer) || (value instanceof Long)) {
                            jSONObject.put((String) next.getKey(), value);
                        }
                    }
                }
                String c2 = o.a().c();
                if (TextUtils.isEmpty(c2)) {
                    c2 = e;
                }
                jSONObject.put("__i", c2);
                UMWorkDispatch.sendEvent(f, 4098, CoreProtocol.getInstance(f), jSONObject);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(String str, Map<String, Object> map, long j) {
        try {
            if (!a(str) || !b(map)) {
                return;
            }
            if (Arrays.asList(b.ap).contains(str)) {
                MLog.e("the id is valid!");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", str);
            jSONObject.put("ts", System.currentTimeMillis());
            if (j > 0) {
                jSONObject.put(b.R, j);
            }
            jSONObject.put("__t", g.f3609a);
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            for (int i = 0; i < 10 && it.hasNext(); i++) {
                Map.Entry next = it.next();
                if (!Arrays.asList(b.ap).contains(next.getKey())) {
                    Object value = next.getValue();
                    if ((value instanceof String) || (value instanceof Integer) || (value instanceof Long)) {
                        jSONObject.put((String) next.getKey(), value);
                    }
                } else {
                    MLog.e("the key in map is invalid.  ");
                }
            }
            String c2 = o.a().c();
            if (TextUtils.isEmpty(c2)) {
                c2 = e;
            }
            jSONObject.put("__i", c2);
            UMWorkDispatch.sendEvent(f, 4097, CoreProtocol.getInstance(f), jSONObject);
        } catch (Throwable unused) {
        }
    }

    public void a(List<String> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    a();
                    if (this.g == null) {
                        this.g = new JSONObject();
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            if (this.g != null) {
                                if (this.g.length() >= 5) {
                                    break;
                                }
                            } else {
                                this.g = new JSONObject();
                            }
                            String str = list.get(i);
                            if (!TextUtils.isEmpty(str)) {
                                a(HelperUtils.subStr(str, 128), false);
                            }
                        }
                        c(f);
                    } else if (this.g.length() >= 5) {
                        MLog.d("already setFistLaunchEvent, igone.");
                    } else {
                        int i2 = 0;
                        while (i2 < list.size()) {
                            if (this.g.length() >= 5) {
                                MLog.d(" add setFistLaunchEvent over.");
                                return;
                            } else {
                                a(HelperUtils.subStr(list.get(i2), 128), false);
                                i2++;
                            }
                        }
                        c(f);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
