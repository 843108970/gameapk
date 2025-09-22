package com.goldcoast.sdk.c;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;

public final class c {

    /* renamed from: c  reason: collision with root package name */
    private static c f2936c;
    private static Context d;

    /* renamed from: a  reason: collision with root package name */
    private String f2937a = d.getFilesDir().getAbsolutePath();

    /* renamed from: b  reason: collision with root package name */
    private String f2938b = "noend.ini";

    private c() {
        File file = new File(this.f2937a);
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        File file2 = new File(this.f2937a, this.f2938b);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static c a(Context context) {
        if (f2936c == null) {
            d = context;
            f2936c = new c();
        }
        return f2936c;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(this.f2937a, this.f2938b)));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public final void a(String str) {
        try {
            FileWriter fileWriter = new FileWriter(new File(this.f2937a, this.f2938b));
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final void b(String str) {
        String a2 = a();
        if (!TextUtils.isEmpty(a2)) {
            try {
                JSONArray jSONArray = new JSONArray(a2);
                if (jSONArray.length() > 0) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (!str.equals(jSONArray.get(i).toString())) {
                            jSONArray2.put(jSONArray.get(i).toString());
                        }
                    }
                    if (jSONArray2.length() > 0) {
                        a(jSONArray2.toString());
                    } else {
                        a("");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public final boolean c(String str) {
        String a2 = a();
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(a2);
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (str.equals(jSONArray.get(i).toString())) {
                        return true;
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }
}
