package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Locale;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f3878a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Context f3879b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f3880c = null;
    private static final String e = "mobclick_agent_user_";
    private static final String f = "mobclick_agent_header_";
    private static final String g = "mobclick_agent_cached_";
    private a d;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f3881a;

        /* renamed from: b  reason: collision with root package name */
        private File f3882b;

        /* renamed from: c  reason: collision with root package name */
        private FilenameFilter f3883c;

        public a(Context context) {
            this(context, ".um");
        }

        public a(Context context, String str) {
            this.f3881a = 10;
            this.f3883c = new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return str.startsWith("um");
                }
            };
            this.f3882b = new File(context.getFilesDir(), str);
            if (!this.f3882b.exists() || !this.f3882b.isDirectory()) {
                this.f3882b.mkdir();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
            r3 = r0[r1];
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(com.umeng.commonsdk.statistics.common.d.b r6) {
            /*
                r5 = this;
                java.io.File r0 = r5.f3882b
                java.io.FilenameFilter r1 = r5.f3883c
                java.io.File[] r0 = r0.listFiles(r1)
                r1 = 0
                if (r0 == 0) goto L_0x0020
                int r2 = r0.length
                r3 = 10
                if (r2 < r3) goto L_0x0020
                java.util.Arrays.sort(r0)
                int r2 = r0.length
                int r2 = r2 - r3
                r3 = 0
            L_0x0016:
                if (r3 >= r2) goto L_0x0020
                r4 = r0[r3]
                r4.delete()
                int r3 = r3 + 1
                goto L_0x0016
            L_0x0020:
                if (r0 == 0) goto L_0x0047
                int r2 = r0.length
                if (r2 <= 0) goto L_0x0047
                java.io.File r2 = r5.f3882b
                r6.a(r2)
                int r2 = r0.length
            L_0x002b:
                if (r1 >= r2) goto L_0x0042
                r3 = r0[r1]     // Catch:{ Throwable -> 0x003a, all -> 0x0038 }
                boolean r3 = r6.b(r3)     // Catch:{ Throwable -> 0x003a, all -> 0x0038 }
                if (r3 == 0) goto L_0x003f
                r3 = r0[r1]
                goto L_0x003c
            L_0x0038:
                r6 = move-exception
                throw r6
            L_0x003a:
                r3 = r0[r1]
            L_0x003c:
                r3.delete()
            L_0x003f:
                int r1 = r1 + 1
                goto L_0x002b
            L_0x0042:
                java.io.File r0 = r5.f3882b
                r6.c(r0)
            L_0x0047:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.d.a.a(com.umeng.commonsdk.statistics.common.d$b):void");
        }

        public void a(byte[] bArr) {
            if (bArr != null && bArr.length != 0) {
                try {
                    HelperUtils.writeFile(new File(this.f3882b, String.format(Locale.US, "um_cache_%d.env", new Object[]{Long.valueOf(System.currentTimeMillis())})), bArr);
                } catch (Exception unused) {
                }
            }
        }

        public boolean a() {
            File[] listFiles = this.f3882b.listFiles();
            return listFiles != null && listFiles.length > 0;
        }

        public void b() {
            File[] listFiles = this.f3882b.listFiles(this.f3883c);
            if (listFiles != null && listFiles.length > 0) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
        }

        public int c() {
            File[] listFiles = this.f3882b.listFiles(this.f3883c);
            if (listFiles == null || listFiles.length <= 0) {
                return 0;
            }
            return listFiles.length;
        }
    }

    public interface b {
        void a(File file);

        boolean b(File file);

        void c(File file);
    }

    public d(Context context) {
        this.d = new a(context);
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            f3879b = context.getApplicationContext();
            f3880c = context.getPackageName();
            if (f3878a == null) {
                f3878a = new d(context);
            }
            dVar = f3878a;
        }
        return dVar;
    }

    private SharedPreferences f() {
        Context context = f3879b;
        return context.getSharedPreferences(e + f3880c, 0);
    }

    public final int a() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3879b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    public final void a(int i) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3879b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i).commit();
        }
    }

    public final void a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3879b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            SharedPreferences.Editor edit = f().edit();
            edit.putString("au_p", str);
            edit.putString("au_u", str2);
            edit.commit();
        }
    }

    public final String b() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3879b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", (String) null);
        }
        return null;
    }

    public final boolean c() {
        return com.umeng.commonsdk.framework.b.c(f3879b) > 0;
    }

    public final String[] d() {
        try {
            SharedPreferences f2 = f();
            String string = f2.getString("au_p", (String) null);
            String string2 = f2.getString("au_u", (String) null);
            if (!(string == null || string2 == null)) {
                return new String[]{string, string2};
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final void e() {
        f().edit().remove("au_p").remove("au_u").commit();
    }
}
