package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.MLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class k {
    public static long a(JSONArray jSONArray) {
        return (long) jSONArray.toString().getBytes().length;
    }

    public static long a(JSONObject jSONObject) {
        return (long) jSONObject.toString().getBytes().length;
    }

    private static JSONObject a(Context context, long j) {
        JSONObject jSONObject;
        try {
            MLog.e("splitAnalyticsData========");
            jSONObject = i.a(context).b(true);
            if (jSONObject != null) {
                try {
                    if (jSONObject.length() > 0 && a(jSONObject) > j) {
                        String str = null;
                        boolean z = false;
                        if (jSONObject.has(b.n)) {
                            JSONObject jSONObject2 = jSONObject.getJSONArray(b.n).getJSONObject(0);
                            if (jSONObject2 != null) {
                                str = jSONObject2.getString("id");
                                jSONObject2.remove(b.t);
                                jSONObject2.remove(b.s);
                                JSONArray jSONArray = new JSONArray();
                                jSONArray.put(jSONObject2);
                                jSONObject.put(b.n, jSONArray);
                            }
                            z = true;
                        }
                        if (jSONObject.has(b.N)) {
                            jSONObject.remove(b.N);
                        }
                        if (jSONObject.has(b.O)) {
                            jSONObject.remove(b.O);
                        }
                        if (jSONObject.has(b.J)) {
                            jSONObject.remove(b.J);
                        }
                        g.a(context).a(z, str);
                        return jSONObject;
                    }
                } catch (Throwable th) {
                    th = th;
                    MLog.e(th);
                    return jSONObject;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            jSONObject = new JSONObject();
            MLog.e(th);
            return jSONObject;
        }
        return jSONObject;
    }

    public static JSONObject a(Context context, long j, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3 = new JSONObject();
        try {
            g.a(context).a();
            JSONObject jSONObject4 = new JSONObject();
            long j2 = 0;
            if (jSONObject.has("header")) {
                jSONObject4 = jSONObject.getJSONObject("header");
                if (jSONObject4 == null || jSONObject4.length() <= 0) {
                    jSONObject4 = null;
                } else {
                    j2 = j - a(jSONObject4);
                }
            }
            if (jSONObject.has(b.W) && (jSONObject2 = jSONObject.getJSONObject(b.W)) != null && jSONObject2.length() > 0) {
                a(context, j2, jSONObject2, jSONObject3);
                if (jSONObject3.length() <= 0) {
                    b(context, j2, jSONObject2, jSONObject3);
                }
                if (jSONObject3.length() > 0 && jSONObject4 != null) {
                    jSONObject3.put("header", jSONObject4);
                }
            }
        } catch (Throwable unused) {
        }
        return jSONObject3;
    }

    private static void a(Context context, long j, JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            if (jSONObject.has("dplus")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("dplus");
                if (jSONObject3 != null && jSONObject3.length() > 0 && a(jSONObject3) > j) {
                    jSONObject3 = b(context, j, jSONObject3);
                }
                if (jSONObject3.length() > 0) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("dplus", jSONObject3);
                    jSONObject2.put(b.W, jSONObject4);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static JSONObject b(Context context, long j, JSONObject jSONObject) {
        JSONArray jSONArray;
        String str;
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (jSONObject.has(b.ac)) {
                jSONArray = jSONObject.getJSONArray(b.ac);
                if (a(jSONArray) > j) {
                    jSONObject.remove(b.ac);
                    g.a(context).a(4);
                    return b(context, j, jSONObject);
                }
                str = b.ac;
            } else if (jSONObject.has(b.Y)) {
                jSONArray = jSONObject.getJSONArray(b.Y);
                if (a(jSONArray) > j) {
                    jSONObject.remove(b.Y);
                    g.a(context).a(0);
                    return b(context, j, jSONObject);
                }
                str = b.Y;
            } else {
                if (jSONObject.has(b.ah)) {
                    jSONArray = jSONObject.getJSONArray(b.ah);
                    if (a(jSONArray) > j) {
                        jSONObject.remove(b.ah);
                        g.a(context).a(1);
                        return b(context, j, jSONObject);
                    }
                    str = b.ah;
                }
                return jSONObject2;
            }
            jSONObject2.put(str, jSONArray);
            return jSONObject2;
        } catch (Throwable unused) {
        }
    }

    private static void b(Context context, long j, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3;
        try {
            if (jSONObject.has("analytics") && (jSONObject3 = jSONObject.getJSONObject("analytics")) != null && jSONObject3.length() > 0) {
                if (a(jSONObject3) > j) {
                    jSONObject3 = a(context, j);
                }
                if (jSONObject3.length() > 0) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("analytics", jSONObject3);
                    jSONObject2.put(b.W, jSONObject4);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
