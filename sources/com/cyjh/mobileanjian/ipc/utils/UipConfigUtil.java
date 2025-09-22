package com.cyjh.mobileanjian.ipc.utils;

import android.text.TextUtils;
import android.util.JsonReader;
import com.cyjh.mqm.MiscUtilities;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

public class UipConfigUtil {
    private static String a(String str) {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                jsonReader.beginObject();
                if (jsonReader.nextName().startsWith("界面")) {
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        jsonReader.nextName();
                        a(jsonReader, jSONObject);
                    }
                    jsonReader.endObject();
                }
                jsonReader.endObject();
                jsonReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.util.JsonReader r4, org.json.JSONObject r5) {
        /*
            r4.beginObject()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
        L_0x0003:
            boolean r0 = r4.hasNext()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            if (r0 == 0) goto L_0x00d7
            java.lang.String r0 = r4.nextName()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            java.lang.String r1 = "水平布局"
            boolean r1 = r0.equals(r1)     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            if (r1 == 0) goto L_0x0019
            a(r4, r5)     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            goto L_0x0003
        L_0x0019:
            java.lang.String r1 = "多选框"
            boolean r1 = r0.equals(r1)     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L_0x0057
            r4.beginObject()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
        L_0x0026:
            boolean r0 = r4.hasNext()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            if (r0 == 0) goto L_0x004e
            java.lang.String r0 = r4.nextName()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            java.lang.String r1 = "名称"
            boolean r1 = r0.equals(r1)     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            if (r1 == 0) goto L_0x003d
            java.lang.String r3 = r4.nextString()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            goto L_0x0026
        L_0x003d:
            java.lang.String r1 = "选中"
            boolean r0 = r0.equals(r1)     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            if (r0 == 0) goto L_0x004a
            boolean r2 = r4.nextBoolean()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            goto L_0x0026
        L_0x004a:
            r4.skipValue()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            goto L_0x0026
        L_0x004e:
            r4.endObject()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            if (r3 == 0) goto L_0x0003
            r5.put(r3, r2)     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            goto L_0x0003
        L_0x0057:
            java.lang.String r1 = "输入框"
            boolean r1 = r0.equals(r1)     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            if (r1 == 0) goto L_0x0095
            r4.beginObject()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            r0 = r3
        L_0x0063:
            boolean r1 = r4.hasNext()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            if (r1 == 0) goto L_0x008b
            java.lang.String r1 = r4.nextName()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            java.lang.String r2 = "名称"
            boolean r2 = r1.equals(r2)     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            if (r2 == 0) goto L_0x007a
            java.lang.String r3 = r4.nextString()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            goto L_0x0063
        L_0x007a:
            java.lang.String r2 = "初始文本"
            boolean r1 = r1.equals(r2)     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            if (r1 == 0) goto L_0x0087
            java.lang.String r0 = r4.nextString()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            goto L_0x0063
        L_0x0087:
            r4.skipValue()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            goto L_0x0063
        L_0x008b:
            r4.endObject()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            if (r3 == 0) goto L_0x0003
            r5.put(r3, r0)     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            goto L_0x0003
        L_0x0095:
            java.lang.String r1 = "下拉框"
            boolean r0 = r0.equals(r1)     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            if (r0 == 0) goto L_0x00d2
            r4.beginObject()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
        L_0x00a0:
            boolean r0 = r4.hasNext()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            if (r0 == 0) goto L_0x00c8
            java.lang.String r0 = r4.nextName()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            java.lang.String r1 = "名称"
            boolean r1 = r0.equals(r1)     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            if (r1 == 0) goto L_0x00b7
            java.lang.String r3 = r4.nextString()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            goto L_0x00a0
        L_0x00b7:
            java.lang.String r1 = "初始选项"
            boolean r0 = r0.equals(r1)     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            if (r0 == 0) goto L_0x00c4
            int r2 = r4.nextInt()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            goto L_0x00a0
        L_0x00c4:
            r4.skipValue()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            goto L_0x00a0
        L_0x00c8:
            r4.endObject()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            if (r3 == 0) goto L_0x0003
            r5.put(r3, r2)     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            goto L_0x0003
        L_0x00d2:
            r4.skipValue()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            goto L_0x0003
        L_0x00d7:
            r4.endObject()     // Catch:{ IOException -> 0x00e0, JSONException -> 0x00db }
            return
        L_0x00db:
            r4 = move-exception
            r4.printStackTrace()
            return
        L_0x00e0:
            r4 = move-exception
            r4.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.utils.UipConfigUtil.a(android.util.JsonReader, org.json.JSONObject):void");
    }

    public static void saveToConfigFile(String str, File file) {
        try {
            FileUtils.writeStringToFile(file, a(new MiscUtilities().LoadUIFile(str, true)));
            file.setReadable(true, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
