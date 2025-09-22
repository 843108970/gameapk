package com.elfin.engin.b;

import android.content.Context;
import android.util.Log;
import android.widget.LinearLayout;
import com.cyjh.mobileanjian.ipc.uip.IUipJsonParser;
import com.cyjh.mobileanjian.ipc.uip.UipHelper;
import com.cyjh.mqm.MiscUtilities;
import com.elfin.engin.b.a.a;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;

public final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private Context f2898a;

    /* renamed from: b  reason: collision with root package name */
    private File f2899b;

    /* renamed from: c  reason: collision with root package name */
    private File f2900c;
    private UipHelper d;

    public c(Context context, String str, String str2) {
        this.f2899b = new File(str);
        this.f2900c = new File(str2);
        this.f2898a = context;
        this.d = new UipHelper(context);
        Log.e("a111111", "ScriptUipModel " + str);
    }

    private void a(File file) throws JSONException {
        if (file != null && file.exists() && !file.isDirectory() && file.length() != 0) {
            try {
                this.d.configViewFromJson(FileUtils.readFileToString(file, "UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String b(File file) throws Exception {
        if (file == null || file.isDirectory()) {
            return null;
        }
        this.d.saveToConfigFile(file.getAbsolutePath());
        return FileUtils.readFileToString(file, "UTF-8");
    }

    public final LinearLayout a() throws Exception {
        if (!this.f2899b.exists()) {
            return new LinearLayout(this.f2898a);
        }
        return this.d.parseLayoutFromJson(new MiscUtilities().LoadUIFile(this.f2899b.getAbsolutePath(), true), (IUipJsonParser) null);
    }

    public final void a(String str) {
    }

    public final String b() {
        if (this.d != null) {
            return this.d.saveConfigToJson();
        }
        return null;
    }

    public final void b(String str) {
        if (this.d != null) {
            this.d.configViewFromJson(str);
        }
    }

    public final void c() throws JSONException {
        try {
            File file = this.f2900c;
            if (file != null && file.exists() && !file.isDirectory() && file.length() != 0) {
                try {
                    this.d.configViewFromJson(FileUtils.readFileToString(file, "UTF-8"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final String d() throws Exception {
        File file;
        if (!this.f2899b.exists() || (file = this.f2900c) == null || file.isDirectory()) {
            return null;
        }
        this.d.saveToConfigFile(file.getAbsolutePath());
        return FileUtils.readFileToString(file, "UTF-8");
    }
}
