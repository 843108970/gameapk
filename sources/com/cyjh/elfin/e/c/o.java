package com.cyjh.elfin.e.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.n;
import com.cyjh.elfin.a.a;
import com.cyjh.elfin.a.b;
import com.cyjh.elfin.entity.Script;
import com.google.protobuf.ByteString;
import com.ywfzjbcy.R;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class o {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1943a = "o";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1944b = "script_version";

    /* renamed from: c  reason: collision with root package name */
    private static long f1945c;

    public static Bitmap a(int i, int i2, ByteString byteString) {
        Bitmap bitmap;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            try {
                bitmap.copyPixelsFromBuffer(ByteBuffer.wrap(byteString.toByteArray()));
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                return bitmap;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return bitmap;
            }
        } catch (Exception e2) {
            e = e2;
            bitmap = null;
            e.printStackTrace();
            return bitmap;
        }
    }

    public static String a(Context context) {
        try {
            return context.getFilesDir() + File.separator + b.au;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(Context context, boolean z) {
        return n.a(n.b(z ? a(context) : context.getFilesDir().getAbsolutePath(), a.r), "GBK");
    }

    public static boolean a() {
        if ((System.currentTimeMillis() - f1945c) / 1000 <= ((long) b.av)) {
            return false;
        }
        f1945c = System.currentTimeMillis();
        return true;
    }

    public static String b(Context context) {
        return n.b(n.b(context.getFilesDir().getAbsolutePath(), a.t));
    }

    public static String b(Context context, boolean z) {
        if (!z) {
            return l.a(context, a.u);
        }
        return l.a(new File(a(context) + File.separator + a.u));
    }

    public static int c(Context context) {
        String b2 = b(context, false);
        String b3 = b(context, true);
        try {
            Long l = 0L;
            if (!TextUtils.isEmpty(b2)) {
                l = Long.valueOf(Long.parseLong(b2));
            }
            Long l2 = 0L;
            if (!TextUtils.isEmpty(b3)) {
                l2 = Long.valueOf(Long.parseLong(b3));
            }
            if (l2.longValue() > l.longValue()) {
                return 1;
            }
            if (l2.longValue() < l.longValue()) {
                return -1;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean c(Context context, boolean z) {
        String e = e(context, z);
        String str = f1943a;
        ad.c(str, "isValidAppId --> scriptAppId=" + e);
        return context.getString(R.string.elfin_appid).equals(e);
    }

    private static String d(Context context, boolean z) {
        Script a2;
        if (z) {
            try {
                a2 = l.a((InputStream) new FileInputStream(new File(a(context) + File.separator + a.o)));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            a2 = l.a(context.getAssets().open(a.o));
        }
        return a2.getId();
    }

    private static boolean d(Context context) {
        String d = d(context, false);
        String d2 = d(context, true);
        String str = f1943a;
        ad.c(str, "localScriptId=" + d + ",sdcardScriptId=" + d2);
        return d.equals(d2);
    }

    private static String e(Context context, boolean z) {
        Script a2;
        if (z) {
            try {
                a2 = l.a((InputStream) new FileInputStream(new File(a(context) + File.separator + a.o)));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            a2 = l.a(context.getAssets().open(a.o));
        }
        return a2.getSelId();
    }
}
