package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.os.Environment;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class s extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3936a = "utdid";

    /* renamed from: b  reason: collision with root package name */
    private static final String f3937b = "android.permission.WRITE_EXTERNAL_STORAGE";

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f3938c = Pattern.compile("UTDID\">([^<]+)");
    private Context d;

    public s(Context context) {
        super(f3936a);
        this.d = context;
    }

    private String b(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = f3938c.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private String g() {
        FileInputStream fileInputStream;
        File h = h();
        if (h == null || !h.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(h);
            String b2 = b(HelperUtils.readStreamToString(fileInputStream));
            HelperUtils.safeClose((InputStream) fileInputStream);
            return b2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (Throwable th) {
            HelperUtils.safeClose((InputStream) fileInputStream);
            throw th;
        }
    }

    private File h() {
        if (DeviceConfig.checkPermission(this.d, f3937b) && Environment.getExternalStorageState().equals("mounted")) {
            try {
                return new File(Environment.getExternalStorageDirectory().getCanonicalPath(), ".UTSystemConfig/Global/Alvin2.xml");
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public String f() {
        try {
            return (String) Class.forName("com.ut.device.UTDevice").getMethod("getUtdid", new Class[]{Context.class}).invoke((Object) null, new Object[]{this.d});
        } catch (Exception unused) {
            return g();
        }
    }
}
