package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.proguard.v;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import java.io.File;

public class j extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3917a = "oldumid";

    /* renamed from: b  reason: collision with root package name */
    private Context f3918b;

    /* renamed from: c  reason: collision with root package name */
    private String f3919c = null;
    private String d = null;

    public j(Context context) {
        super(f3917a);
        this.f3918b = context;
    }

    private void b(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    private void j() {
        try {
            b("/data/local/tmp/.um");
            HelperUtils.writeFile(new File("/data/local/tmp/.um/sysid.dat"), this.d);
        } catch (Throwable unused) {
        }
    }

    private void k() {
        try {
            b("/sdcard/Android/obj/.um");
            HelperUtils.writeFile(new File("/sdcard/Android/obj/.um/sysid.dat"), this.d);
        } catch (Throwable unused) {
        }
    }

    private void l() {
        try {
            b("/sdcard/Android/data/.um");
            HelperUtils.writeFile(new File("/sdcard/Android/data/.um/sysid.dat"), this.d);
        } catch (Throwable unused) {
        }
    }

    public String f() {
        return this.f3919c;
    }

    public boolean g() {
        return h();
    }

    public boolean h() {
        this.d = UMEnvelopeBuild.imprintProperty(this.f3918b, v.e, (String) null);
        if (TextUtils.isEmpty(this.d)) {
            return false;
        }
        this.d = DataHelper.encryptBySHA1(this.d);
        String readFile = HelperUtils.readFile(new File("/sdcard/Android/data/.um/sysid.dat"));
        String readFile2 = HelperUtils.readFile(new File("/sdcard/Android/obj/.um/sysid.dat"));
        String readFile3 = HelperUtils.readFile(new File("/data/local/tmp/.um/sysid.dat"));
        if (TextUtils.isEmpty(readFile)) {
            l();
        } else if (!this.d.equals(readFile)) {
            this.f3919c = readFile;
            return true;
        }
        if (TextUtils.isEmpty(readFile2)) {
            k();
        } else if (!this.d.equals(readFile2)) {
            this.f3919c = readFile2;
            return true;
        }
        if (TextUtils.isEmpty(readFile3)) {
            j();
            return false;
        } else if (this.d.equals(readFile3)) {
            return false;
        } else {
            this.f3919c = readFile3;
            return true;
        }
    }

    public void i() {
        try {
            l();
            k();
            j();
        } catch (Exception unused) {
        }
    }
}
