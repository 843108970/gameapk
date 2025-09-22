package com.cyjh.elfin.e.c;

import android.content.Context;
import android.util.JsonReader;
import com.cyjh.elfin.entity.BestResolution;
import com.cyjh.elfin.entity.FileVersion;
import com.cyjh.elfin.entity.Script;
import com.cyjh.elfin.entity.ScriptInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1925a = "BestResolution";

    /* renamed from: b  reason: collision with root package name */
    private static final String f1926b = "X";

    /* renamed from: c  reason: collision with root package name */
    private static final String f1927c = "Y";
    private static final String d = "ChangeFileList";
    private static final String e = "Description";
    private static final String f = "FileVersion";
    private static final String g = "Name";
    private static final String h = "id";
    private static final String i = "ScriptVersion";
    private static final String j = "AppID";
    private static final String k = "Version";
    private static final String l = "SelID";
    private static final String m = ".mq";
    private static final String n = ".atc";
    private static final String o = ".prop";
    private static final String p = ".rtd";
    private static final String q = ".ui";

    private static BestResolution a(JsonReader jsonReader) throws IOException {
        BestResolution bestResolution = new BestResolution();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals(f1926b)) {
                bestResolution.setX(jsonReader.nextInt());
            } else if (nextName.equals(f1927c)) {
                bestResolution.setY(jsonReader.nextInt());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return bestResolution;
    }

    public static Script a(InputStream inputStream) throws IOException {
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, "GBK"));
        jsonReader.beginObject();
        Script script = new Script();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals(j)) {
                script.setAppId(jsonReader.nextString());
            } else if (nextName.equals(f1925a)) {
                script.setBestResolution(a(jsonReader));
            } else if (nextName.equals(d)) {
                script.setChangeFileList(jsonReader.nextInt());
            } else if (nextName.equals(e)) {
                script.setDescription(jsonReader.nextString());
            } else if (nextName.equals(f)) {
                script.setFileVersion(b(jsonReader));
            } else if (nextName.equals(g)) {
                script.setName(jsonReader.nextString());
            } else if (nextName.equals("id")) {
                script.setId(jsonReader.nextString());
            } else if (nextName.equals(l)) {
                script.setSelId(jsonReader.nextString());
            } else if (nextName.equals(k)) {
                script.setVersion(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return script;
    }

    public static String a(Context context, String str) {
        ScriptInfo scriptInfo = new ScriptInfo();
        try {
            JsonReader jsonReader = new JsonReader(new InputStreamReader(context.getAssets().open(str), "GBK"));
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (i.equals(jsonReader.nextName())) {
                    scriptInfo.setScriptVersion(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return scriptInfo.getScriptVersion();
    }

    public static String a(File file) {
        ScriptInfo scriptInfo = new ScriptInfo();
        try {
            JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(file), "GBK"));
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (i.equals(jsonReader.nextName())) {
                    scriptInfo.setScriptVersion(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return scriptInfo.getScriptVersion();
    }

    private static FileVersion b(JsonReader jsonReader) throws IOException {
        FileVersion fileVersion = new FileVersion();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals(".atc")) {
                fileVersion.setAtc(jsonReader.nextInt());
            } else if (nextName.equals(".mq")) {
                fileVersion.setMq(jsonReader.nextInt());
            } else if (nextName.equals(".prop")) {
                fileVersion.setProp(jsonReader.nextInt());
            } else if (nextName.equals(".ui")) {
                fileVersion.setUI(jsonReader.nextInt());
            } else if (nextName.equals(".rtd")) {
                fileVersion.setRtd(jsonReader.nextInt());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return fileVersion;
    }
}
