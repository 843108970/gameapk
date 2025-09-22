package com.c.d;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.cyjh.elfin.a.b;
import com.umeng.commonsdk.proguard.bg;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Thread;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.IOUtils;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1558a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1559b = false;

    /* renamed from: c  reason: collision with root package name */
    private static Object f1560c = null;
    private static Thread.UncaughtExceptionHandler d = null;
    private static Map<String, Long> e = new HashMap();
    private static Handler f = null;
    private static final int g = 4096;
    private static ScheduledExecutorService h;
    private static File i;
    private static File j;
    private static Context k;
    private static final char[] l = new char[64];
    private static final byte[] m = new byte[128];

    static {
        char c2 = 'A';
        int i2 = 0;
        while (c2 <= 'Z') {
            l[i2] = c2;
            c2 = (char) (c2 + 1);
            i2++;
        }
        char c3 = 'a';
        while (c3 <= 'z') {
            l[i2] = c3;
            c3 = (char) (c3 + 1);
            i2++;
        }
        char c4 = '0';
        while (c4 <= '9') {
            l[i2] = c4;
            c4 = (char) (c4 + 1);
            i2++;
        }
        l[i2] = '+';
        l[i2 + 1] = IOUtils.DIR_SEPARATOR_UNIX;
        for (int i3 = 0; i3 < m.length; i3++) {
            m[i3] = -1;
        }
        for (int i4 = 0; i4 < 64; i4++) {
            m[l[i4]] = (byte) i4;
        }
    }

    public static int a(Context context, float f2) {
        return (int) TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
    }

    private static long a(String str, long j2) {
        Long l2 = e.get(str);
        if (l2 == null) {
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis() - l2.longValue();
        if (j2 == 0 || currentTimeMillis > j2) {
            b((Object) str, (Object) Long.valueOf(currentTimeMillis));
        }
        return currentTimeMillis;
    }

    private static File a(Context context) {
        if (i == null) {
            File file = new File(context.getCacheDir(), "aquery");
            i = file;
            file.mkdirs();
        }
        return i;
    }

    public static File a(Context context, int i2) {
        if (i2 != 1) {
            return a(context);
        }
        if (j != null) {
            return j;
        }
        File file = new File(a(context), "persistent");
        j = file;
        file.mkdirs();
        return j;
    }

    public static File a(File file, String str) {
        if (str == null) {
            return null;
        }
        return str.startsWith(File.separator) ? new File(str) : new File(file, new BigInteger(a(str.getBytes())).abs().toString(36));
    }

    public static Object a(Object obj, String str, boolean z, boolean z2, Class<?>[] clsArr, Class<?>[] clsArr2, Object... objArr) {
        try {
            return a(obj, str, z, clsArr, clsArr2, objArr);
        } catch (Exception e2) {
            if (z2) {
                b((Throwable) e2);
                return null;
            }
            a((Throwable) e2);
            return null;
        }
    }

    public static Object a(Object obj, String str, boolean z, boolean z2, Class<?>[] clsArr, Object... objArr) {
        return a(obj, str, z, z2, clsArr, (Class<?>[]) null, objArr);
    }

    private static Object a(Object obj, String str, boolean z, Class<?>[] clsArr, Class<?>[] clsArr2, Object... objArr) throws Exception {
        if (obj == null || str == null) {
            return null;
        }
        if (clsArr == null) {
            try {
                clsArr = new Class[0];
            } catch (NoSuchMethodException unused) {
                if (z) {
                    if (clsArr2 != null) {
                        return obj.getClass().getMethod(str, clsArr2).invoke(obj, objArr);
                    }
                    try {
                        return obj.getClass().getMethod(str, new Class[0]).invoke(obj, new Object[0]);
                    } catch (NoSuchMethodException unused2) {
                        return null;
                    }
                }
                return null;
            }
        }
        return obj.getClass().getMethod(str, clsArr).invoke(obj, objArr);
    }

    public static void a() {
        if (f1559b && f1560c != null) {
            synchronized (f1560c) {
                f1560c.notifyAll();
            }
        }
    }

    private static void a(long j2) {
        if (f1559b) {
            if (f1560c == null) {
                f1560c = new Object();
            }
            synchronized (f1560c) {
                try {
                    f1560c.wait(j2);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private static void a(Application application) {
        k = application.getApplicationContext();
    }

    public static void a(SharedPreferences.Editor editor) {
        if (com.c.a.Q >= 9) {
            a((Object) editor, "apply", false, true, (Class<?>[]) null, (Object[]) null);
        } else {
            editor.commit();
        }
    }

    private static void a(View view, float f2) {
        if (f2 == 1.0f) {
            view.clearAnimation();
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f2);
        alphaAnimation.setDuration(0);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    public static void a(View view, boolean z) {
        if ((z ? 0.5f : 1.0f) == 1.0f) {
            view.clearAnimation();
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.5f);
        alphaAnimation.setDuration(0);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    private static void a(File file) {
        i = file;
        if (file != null) {
            i.mkdirs();
        }
    }

    public static void a(File file, long j2, long j3) {
        try {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                Arrays.sort(listFiles, new c());
                int length = listFiles.length;
                boolean z = false;
                long j4 = 0;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    long length2 = j4 + listFiles[i2].length();
                    if (length2 > j2) {
                        z = true;
                        break;
                    } else {
                        i2++;
                        j4 = length2;
                    }
                }
                if (z) {
                    b(listFiles, j3);
                }
                File c2 = c();
                if (c2 != null && c2.exists()) {
                    b(c2.listFiles(), 0);
                }
            }
        } catch (Exception e2) {
            b((Throwable) e2);
        }
    }

    public static void a(File file, byte[] bArr) {
        g().schedule(new c().a(1, file, bArr), 0, TimeUnit.MILLISECONDS);
    }

    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        a(inputStream, outputStream, 0, (f) null);
    }

    public static void a(InputStream inputStream, OutputStream outputStream, int i2, f fVar) throws IOException {
        int i3;
        if (fVar != null) {
            fVar.a();
            if (i2 <= 0) {
                fVar.d = true;
                i2 = b.ak;
            }
            fVar.e = i2;
            if (fVar.f1571a != null) {
                fVar.f1571a.setProgress(0);
                fVar.f1571a.setMax(i2);
            }
            if (fVar.f1572b != null) {
                fVar.f1572b.setProgress(0);
                fVar.f1572b.setMax(i2);
            }
        }
        byte[] bArr = new byte[4096];
        int i4 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                i4++;
                if (f1558a && i4 > 2) {
                    a((Object) "simulating internet error");
                    throw new IOException();
                } else if (fVar != null) {
                    if (fVar.f1571a != null) {
                        fVar.f1571a.incrementProgressBy(fVar.d ? 1 : read);
                    }
                    if (fVar.f1572b != null) {
                        fVar.f1572b.incrementProgressBy(fVar.d ? 1 : read);
                    }
                    if (fVar.f1573c != null) {
                        if (fVar.d) {
                            i3 = fVar.f;
                            fVar.f = i3 + 1;
                        } else {
                            fVar.f += read;
                            i3 = (fVar.f * b.ak) / fVar.e;
                        }
                        if (i3 > 9999) {
                            i3 = 9999;
                        }
                        fVar.f1573c.setProgress(i3);
                    }
                }
            } else if (fVar != null) {
                if (fVar.f1571a != null) {
                    fVar.f1571a.setProgress(fVar.f1571a.getMax());
                }
                if (fVar.f1572b != null) {
                    fVar.f1572b.setProgress(fVar.f1572b.getMax());
                }
                if (fVar.f1573c != null) {
                    fVar.f1573c.setProgress(9999);
                    return;
                }
                return;
            } else {
                return;
            }
        }
    }

    public static void a(Object obj) {
        if (f1559b) {
            Log.w("AQuery", String.valueOf(obj));
        }
    }

    public static void a(Object obj, Object obj2) {
        Log.w("AQuery", obj + ":" + obj2);
    }

    private static void a(final Object obj, final String str) {
        final Class[] clsArr = new Class[0];
        final Object[] objArr = new Object[0];
        a((Runnable) new Runnable() {
            public final void run() {
                a.a(r1, r2, false, true, (Class<?>[]) r3, r4);
            }
        });
    }

    private static void a(final Object obj, final String str, final Class<?>[] clsArr, final Object... objArr) {
        a((Runnable) new Runnable() {
            public final void run() {
                a.a(obj, str, false, true, (Class<?>[]) clsArr, objArr);
            }
        });
    }

    public static void a(Runnable runnable) {
        f().post(runnable);
    }

    private static void a(Runnable runnable, long j2) {
        f().postDelayed(runnable, j2);
    }

    private static void a(String str) {
        e.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    private static void a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        d = uncaughtExceptionHandler;
    }

    public static void a(Throwable th) {
        if (f1559b) {
            Log.w("AQuery", Log.getStackTraceString(th));
        }
    }

    private static void a(boolean z) {
        f1559b = z;
    }

    private static boolean a(File[] fileArr, long j2) {
        int length = fileArr.length;
        long j3 = 0;
        int i2 = 0;
        while (i2 < length) {
            long length2 = j3 + fileArr[i2].length();
            if (length2 > j2) {
                return true;
            }
            i2++;
            j3 = length2;
        }
        return false;
    }

    public static byte[] a(InputStream inputStream) {
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            a(inputStream, (OutputStream) byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            b((Throwable) e2);
            bArr = null;
        }
        a((Closeable) inputStream);
        return bArr;
    }

    private static byte[] a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException e2) {
            b((Throwable) e2);
            return null;
        }
    }

    public static char[] a(byte[] bArr, int i2) {
        int i3;
        byte b2;
        int i4;
        byte b3;
        int i5 = ((i2 * 4) + 2) / 3;
        char[] cArr = new char[(((i2 + 2) / 3) * 4)];
        int i6 = i2 + 0;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i6) {
            int i9 = i7 + 1;
            byte b4 = bArr[i7] & 255;
            if (i9 < i6) {
                i3 = i9 + 1;
                b2 = bArr[i9] & 255;
            } else {
                i3 = i9;
                b2 = 0;
            }
            if (i3 < i6) {
                i4 = i3 + 1;
                b3 = bArr[i3] & 255;
            } else {
                i4 = i3;
                b3 = 0;
            }
            int i10 = b4 >>> 2;
            int i11 = ((b4 & 3) << 4) | (b2 >>> 4);
            int i12 = ((b2 & bg.m) << 2) | (b3 >>> 6);
            byte b5 = b3 & 63;
            int i13 = i8 + 1;
            cArr[i8] = l[i10];
            int i14 = i13 + 1;
            cArr[i13] = l[i11];
            char c2 = '=';
            cArr[i14] = i14 < i5 ? l[i12] : '=';
            int i15 = i14 + 1;
            if (i15 < i5) {
                c2 = l[b5];
            }
            cArr[i15] = c2;
            i8 = i15 + 1;
            i7 = i4;
        }
        return cArr;
    }

    private static float b(Context context, float f2) {
        return f2 / (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f);
    }

    public static File b(File file, String str) {
        File a2 = a(file, str);
        if (a2 == null || !a2.exists() || a2.length() == 0) {
            return null;
        }
        return a2;
    }

    private static String b(String str) {
        return new BigInteger(a(str.getBytes())).abs().toString(36);
    }

    private static void b(Context context) {
        try {
            File a2 = a(context);
            g().schedule(new c().a(2, a2, 3000000L, 2000000L), 0, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            b((Throwable) e2);
        }
    }

    private static void b(File file) {
        file.setLastModified(System.currentTimeMillis());
    }

    public static void b(File file, byte[] bArr) {
        if (file != null) {
            try {
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (Exception e2) {
                        b((Object) "file create fail", (Object) file);
                        b((Throwable) e2);
                    }
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(bArr);
                fileOutputStream.close();
            } catch (Exception e3) {
                try {
                    b((Throwable) e3);
                } catch (Exception e4) {
                    b((Throwable) e4);
                }
            }
        }
    }

    public static void b(Object obj, Object obj2) {
        if (f1559b) {
            Log.w("AQuery", obj + ":" + obj2);
        }
    }

    private static void b(final Object obj, final String str) {
        final Class[] clsArr = new Class[0];
        final Object[] objArr = new Object[0];
        final AnonymousClass3 r3 = new Runnable() {
            public final void run() {
                a.a(r1, r2, false, true, (Class<?>[]) r3, r4);
            }
        };
        new AsyncTask<Void, Void, String>() {
            private String a() {
                try {
                    r1.run();
                    return null;
                } catch (Exception e) {
                    a.b((Throwable) e);
                    return null;
                }
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object... objArr) {
                return a();
            }
        }.execute(new Void[0]);
    }

    private static void b(final Object obj, final String str, final Class<?>[] clsArr, final Object... objArr) {
        final AnonymousClass3 r0 = new Runnable() {
            public final void run() {
                a.a(obj, str, false, true, (Class<?>[]) clsArr, objArr);
            }
        };
        new AsyncTask<Void, Void, String>() {
            private String a() {
                try {
                    r1.run();
                    return null;
                } catch (Exception e) {
                    a.b((Throwable) e);
                    return null;
                }
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object... objArr) {
                return a();
            }
        }.execute(new Void[0]);
    }

    private static void b(final Runnable runnable) {
        new AsyncTask<Void, Void, String>() {
            private String a() {
                try {
                    runnable.run();
                    return null;
                } catch (Exception e) {
                    a.b((Throwable) e);
                    return null;
                }
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object... objArr) {
                return a();
            }
        }.execute(new Void[0]);
    }

    public static void b(Throwable th) {
        try {
            a((Object) "reporting", (Object) Log.getStackTraceString(th));
            if (d != null) {
                d.uncaughtException(Thread.currentThread(), th);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void b(File[] fileArr, long j2) {
        long j3 = 0;
        int i2 = 0;
        for (File file : fileArr) {
            if (file.isFile()) {
                long length = j3 + file.length();
                if (length >= j2) {
                    file.delete();
                    i2++;
                }
                j3 = length;
            }
        }
        b((Object) "deleted", (Object) Integer.valueOf(i2));
    }

    public static boolean b() {
        return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
    }

    public static File c() {
        File file = new File(Environment.getExternalStorageDirectory(), "aquery/temp");
        file.mkdirs();
        if (!file.exists() || !file.canWrite()) {
            return null;
        }
        return file;
    }

    private static File c(File file, String str) {
        return new File(file, str);
    }

    private static String c(String str) {
        return new BigInteger(a(str.getBytes())).abs().toString(36);
    }

    private static void c(Context context) {
        try {
            File a2 = a(context);
            g().schedule(new c().a(2, a2, 3000000L, 2000000L), 0, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            b((Throwable) e2);
        }
    }

    private static void c(File file, byte[] bArr) {
        try {
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e2) {
                    b((Object) "file create fail", (Object) file);
                    b((Throwable) e2);
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } catch (Exception e3) {
            b((Throwable) e3);
        }
    }

    private static void c(Runnable runnable) {
        f().removeCallbacks(runnable);
    }

    private static File d(File file, String str) {
        File b2 = b(file, str);
        if (b2 != null) {
            b2.setLastModified(System.currentTimeMillis());
        }
        return b2;
    }

    private static boolean d() {
        return f1559b;
    }

    private static void e() {
        if (!b()) {
            b((Throwable) new IllegalStateException("Not UI Thread"));
        }
    }

    private static Handler f() {
        if (f == null) {
            f = new Handler(Looper.getMainLooper());
        }
        return f;
    }

    private static ScheduledExecutorService g() {
        if (h == null) {
            h = Executors.newSingleThreadScheduledExecutor();
        }
        return h;
    }

    private static Context h() {
        if (k == null) {
            a((Object) "warn", (Object) "getContext with null");
            a((Throwable) new IllegalStateException());
        }
        return k;
    }
}
