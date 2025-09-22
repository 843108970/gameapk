package com.umeng.commonsdk.framework;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.umeng.commonsdk.proguard.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3664a = "last_successful_build_time";

    /* renamed from: b  reason: collision with root package name */
    private static Object f3665b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static String f3666c = "envelope";
    private static String d;
    private static Object e = new Object();

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004f A[SYNTHETIC, Splitter:B:26:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005b A[SYNTHETIC, Splitter:B:34:0x005b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(android.content.Context r5, java.lang.String r6, byte[] r7) {
        /*
            r0 = 101(0x65, float:1.42E-43)
            if (r7 != 0) goto L_0x0005
            return r0
        L_0x0005:
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = h(r5)
            r2.append(r3)
            java.lang.String r3 = "/"
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            java.lang.Object r2 = e
            monitor-enter(r2)
            r3 = 0
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0049 }
            r4.<init>(r1)     // Catch:{ IOException -> 0x0049 }
            r4.write(r7)     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            r4.close()     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            com.umeng.commonsdk.statistics.internal.a r7 = com.umeng.commonsdk.statistics.internal.a.a((android.content.Context) r5)     // Catch:{ all -> 0x005f }
            boolean r6 = r7.a((java.lang.String) r6)     // Catch:{ all -> 0x005f }
            if (r6 == 0) goto L_0x003e
            j(r5)     // Catch:{ all -> 0x005f }
        L_0x003e:
            r5 = 0
            monitor-exit(r2)     // Catch:{ all -> 0x005f }
            return r5
        L_0x0041:
            r6 = move-exception
            r3 = r4
            goto L_0x0059
        L_0x0044:
            r6 = move-exception
            r3 = r4
            goto L_0x004a
        L_0x0047:
            r6 = move-exception
            goto L_0x0059
        L_0x0049:
            r6 = move-exception
        L_0x004a:
            com.umeng.commonsdk.proguard.e.a(r5, r6)     // Catch:{ all -> 0x0047 }
            if (r3 == 0) goto L_0x0057
            r3.close()     // Catch:{ Throwable -> 0x0053 }
            goto L_0x0057
        L_0x0053:
            r6 = move-exception
            com.umeng.commonsdk.proguard.e.a(r5, r6)     // Catch:{ all -> 0x005f }
        L_0x0057:
            monitor-exit(r2)     // Catch:{ all -> 0x005f }
            return r0
        L_0x0059:
            if (r3 == 0) goto L_0x0065
            r3.close()     // Catch:{ Throwable -> 0x0061 }
            goto L_0x0065
        L_0x005f:
            r5 = move-exception
            goto L_0x0066
        L_0x0061:
            r7 = move-exception
            com.umeng.commonsdk.proguard.e.a(r5, r7)     // Catch:{ all -> 0x005f }
        L_0x0065:
            throw r6     // Catch:{ all -> 0x005f }
        L_0x0066:
            monitor-exit(r2)     // Catch:{ all -> 0x005f }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.b.a(android.content.Context, java.lang.String, byte[]):int");
    }

    private static long a(long j, long j2) {
        return (j < j2 ? j2 - j : j - j2) / 86400000;
    }

    public static String a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (!(activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null || runningAppProcesses.size() <= 0)) {
                for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                    if (next.pid == myPid) {
                        return next.processName;
                    }
                }
            }
        } catch (Throwable th) {
            e.a(context.getApplicationContext(), th);
        }
        return "";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r6, com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType r7) {
        /*
            java.lang.String r0 = "a"
            com.umeng.commonsdk.framework.UMLogDataProtocol$UMBusinessType r1 = com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_DPLUS
            if (r7 != r1) goto L_0x0009
            java.lang.String r0 = "d"
            goto L_0x000f
        L_0x0009:
            com.umeng.commonsdk.framework.UMLogDataProtocol$UMBusinessType r1 = com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_INTERNAL
            if (r7 != r1) goto L_0x000f
            java.lang.String r0 = "i"
        L_0x000f:
            java.io.File r7 = new java.io.File
            java.lang.String r1 = h(r6)
            r7.<init>(r1)
            java.lang.Object r1 = e
            monitor-enter(r1)
            r2 = 0
            java.io.File[] r7 = r7.listFiles()     // Catch:{ Throwable -> 0x0040 }
            if (r7 == 0) goto L_0x003c
            int r3 = r7.length     // Catch:{ Throwable -> 0x0040 }
            if (r3 != 0) goto L_0x0026
            goto L_0x003c
        L_0x0026:
            int r3 = r7.length     // Catch:{ Throwable -> 0x0040 }
            r4 = 0
        L_0x0028:
            if (r4 >= r3) goto L_0x0044
            r5 = r7[r4]     // Catch:{ Throwable -> 0x0040 }
            java.lang.String r5 = r5.getName()     // Catch:{ Throwable -> 0x0040 }
            boolean r5 = r5.startsWith(r0)     // Catch:{ Throwable -> 0x0040 }
            if (r5 == 0) goto L_0x0039
            monitor-exit(r1)     // Catch:{ all -> 0x003e }
            r6 = 1
            return r6
        L_0x0039:
            int r4 = r4 + 1
            goto L_0x0028
        L_0x003c:
            monitor-exit(r1)     // Catch:{ all -> 0x003e }
            return r2
        L_0x003e:
            r6 = move-exception
            goto L_0x0046
        L_0x0040:
            r7 = move-exception
            com.umeng.commonsdk.proguard.e.a(r6, r7)     // Catch:{ all -> 0x003e }
        L_0x0044:
            monitor-exit(r1)     // Catch:{ all -> 0x003e }
            return r2
        L_0x0046:
            monitor-exit(r1)     // Catch:{ all -> 0x003e }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.b.a(android.content.Context, com.umeng.commonsdk.framework.UMLogDataProtocol$UMBusinessType):boolean");
    }

    private static boolean a(Context context, String str) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", new Class[]{String.class}).invoke(context, new Object[]{str})).intValue() == 0) {
                        return true;
                    }
                } catch (Throwable th) {
                    e.a(applicationContext, th);
                    return false;
                }
            } else if (applicationContext.getPackageManager().checkPermission(str, applicationContext.getPackageName()) == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(File file) {
        Context a2 = c.a();
        synchronized (e) {
            if (file != null) {
                try {
                    if (file.exists()) {
                        boolean delete = file.delete();
                        return delete;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
    }

    public static byte[] a(String str) throws IOException {
        FileChannel fileChannel;
        IOException e2;
        byte[] bArr;
        Context a2 = c.a();
        synchronized (e) {
            try {
                fileChannel = new RandomAccessFile(str, "r").getChannel();
                try {
                    MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size()).load();
                    System.out.println(load.isLoaded());
                    bArr = new byte[((int) fileChannel.size())];
                    if (load.remaining() > 0) {
                        load.get(bArr, 0, load.remaining());
                    }
                    try {
                        fileChannel.close();
                    } catch (Throwable th) {
                        e.a(a2, th);
                    }
                } catch (IOException e3) {
                    e2 = e3;
                    try {
                        e.a(a2, e2);
                        throw e2;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            fileChannel.close();
                        } catch (Throwable th3) {
                            e.a(a2, th3);
                        }
                        throw th;
                    }
                }
            } catch (IOException e4) {
                e2 = e4;
                fileChannel = null;
                e.a(a2, e2);
                throw e2;
            } catch (Throwable th4) {
                th = th4;
                fileChannel = null;
                fileChannel.close();
                throw th;
            }
        }
        return bArr;
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            if (!a(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnectedOrConnecting();
        } catch (Throwable th) {
            e.a(context.getApplicationContext(), th);
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int c(android.content.Context r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x0027
            java.io.File r1 = new java.io.File     // Catch:{ Throwable -> 0x0023 }
            java.lang.String r2 = h(r4)     // Catch:{ Throwable -> 0x0023 }
            r1.<init>(r2)     // Catch:{ Throwable -> 0x0023 }
            java.lang.Object r2 = e     // Catch:{ Throwable -> 0x0023 }
            monitor-enter(r2)     // Catch:{ Throwable -> 0x0023 }
            boolean r3 = r1.isDirectory()     // Catch:{ all -> 0x0020 }
            if (r3 == 0) goto L_0x001e
            java.lang.String[] r1 = r1.list()     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x001e
            int r1 = r1.length     // Catch:{ all -> 0x0020 }
            monitor-exit(r2)     // Catch:{ all -> 0x0020 }
            return r1
        L_0x001e:
            monitor-exit(r2)     // Catch:{ all -> 0x0020 }
            return r0
        L_0x0020:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0020 }
            throw r1     // Catch:{ Throwable -> 0x0023 }
        L_0x0023:
            r1 = move-exception
            com.umeng.commonsdk.proguard.e.a(r4, r1)
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.b.c(android.content.Context):int");
    }

    /* access modifiers changed from: private */
    public static String c(String str) {
        Context a2 = c.a();
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf(95) + 1;
        try {
            return str.substring(indexOf, str.indexOf(95, indexOf));
        } catch (IndexOutOfBoundsException e2) {
            e.a(a2, e2);
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0055, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void d(final android.content.Context r6) {
        /*
            java.io.File r0 = new java.io.File
            java.lang.String r1 = h(r6)
            r0.<init>(r1)
            java.lang.Object r1 = e
            monitor-enter(r1)
            java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x0054
            int r2 = r0.length     // Catch:{ all -> 0x0056 }
            r3 = 100
            if (r2 > r3) goto L_0x0018
            goto L_0x0054
        L_0x0018:
            com.umeng.commonsdk.framework.b$1 r2 = new com.umeng.commonsdk.framework.b$1     // Catch:{ all -> 0x0056 }
            r2.<init>(r6)     // Catch:{ all -> 0x0056 }
            java.util.Arrays.sort(r0, r2)     // Catch:{ all -> 0x0056 }
            int r2 = r0.length     // Catch:{ all -> 0x0056 }
            if (r2 <= r3) goto L_0x0052
            java.lang.String r2 = "--->>> biger than 10"
            com.umeng.commonsdk.statistics.common.e.b((java.lang.String) r2)     // Catch:{ Throwable -> 0x004e }
            r2 = 0
        L_0x0029:
            int r4 = r0.length     // Catch:{ Throwable -> 0x004e }
            int r4 = r4 - r3
            if (r2 >= r4) goto L_0x0052
            r4 = r0[r2]     // Catch:{ Throwable -> 0x004e }
            boolean r4 = r4.delete()     // Catch:{ Throwable -> 0x004e }
            if (r4 != 0) goto L_0x004b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x004e }
            java.lang.String r5 = "--->>> remove ["
            r4.<init>(r5)     // Catch:{ Throwable -> 0x004e }
            r4.append(r2)     // Catch:{ Throwable -> 0x004e }
            java.lang.String r5 = "] file fail."
            r4.append(r5)     // Catch:{ Throwable -> 0x004e }
            java.lang.String r4 = r4.toString()     // Catch:{ Throwable -> 0x004e }
            com.umeng.commonsdk.statistics.common.e.b((java.lang.String) r4)     // Catch:{ Throwable -> 0x004e }
        L_0x004b:
            int r2 = r2 + 1
            goto L_0x0029
        L_0x004e:
            r0 = move-exception
            com.umeng.commonsdk.proguard.e.a(r6, r0)     // Catch:{ all -> 0x0056 }
        L_0x0052:
            monitor-exit(r1)     // Catch:{ all -> 0x0056 }
            return
        L_0x0054:
            monitor-exit(r1)     // Catch:{ all -> 0x0056 }
            return
        L_0x0056:
            r6 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0056 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.b.d(android.content.Context):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File e(final android.content.Context r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.File r1 = new java.io.File
            java.lang.String r2 = h(r4)
            r1.<init>(r2)
            java.lang.Object r2 = e
            monitor-enter(r2)
            java.io.File[] r1 = r1.listFiles()     // Catch:{ all -> 0x0029 }
            if (r1 == 0) goto L_0x0027
            int r3 = r1.length     // Catch:{ all -> 0x0029 }
            if (r3 != 0) goto L_0x001a
            goto L_0x0027
        L_0x001a:
            com.umeng.commonsdk.framework.b$2 r0 = new com.umeng.commonsdk.framework.b$2     // Catch:{ all -> 0x0029 }
            r0.<init>(r4)     // Catch:{ all -> 0x0029 }
            java.util.Arrays.sort(r1, r0)     // Catch:{ all -> 0x0029 }
            r4 = 0
            r4 = r1[r4]     // Catch:{ all -> 0x0029 }
            monitor-exit(r2)     // Catch:{ all -> 0x0029 }
            return r4
        L_0x0027:
            monitor-exit(r2)     // Catch:{ all -> 0x0029 }
            return r0
        L_0x0029:
            r4 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0029 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.b.e(android.content.Context):java.io.File");
    }

    public static void f(Context context) {
        if (context != null) {
            try {
                String g = g(context);
                if (!TextUtils.isEmpty(g) && !g.equals(f3666c)) {
                    File file = new File(context.getFilesDir().getAbsolutePath() + "/." + g);
                    if (file.exists()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles == null || listFiles.length == 0) {
                            try {
                                if (file.isDirectory()) {
                                    file.delete();
                                }
                            } catch (Throwable th) {
                                e.a(context, th);
                            }
                        } else {
                            String h = h(context);
                            for (int i = 0; i < listFiles.length; i++) {
                                File file2 = listFiles[i];
                                file2.renameTo(new File(h + "/" + listFiles[i].getName()));
                            }
                            if (file.isDirectory()) {
                                file.delete();
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                e.a(context, th2);
            }
        }
    }

    public static String g(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                com.umeng.commonsdk.statistics.common.e.b("--->>> getEnvelopeDir: can't get process name, use default envelope directory.");
                return f3666c;
            } else if (runningAppProcesses.size() == 0) {
                return f3666c;
            } else {
                try {
                    for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                        if (next.pid == Process.myPid()) {
                            String replace = next.processName.replace(':', '_');
                            com.umeng.commonsdk.statistics.common.e.b("--->>> getEnvelopeDir: use current process name as envelope directory.");
                            return replace;
                        }
                    }
                } catch (Throwable th) {
                    e.a(context, th);
                }
            }
        }
        return f3666c;
    }

    public static String h(Context context) {
        String str;
        synchronized (e) {
            try {
                if (d == null) {
                    d = context.getFilesDir().getAbsolutePath() + "/." + f3666c;
                }
                File file = new File(d);
                if (!file.exists() && !file.mkdir()) {
                    com.umeng.commonsdk.statistics.common.e.b("--->>> Create Envelope Directory failed!!!");
                }
            } catch (Throwable th) {
                e.a(context, th);
            }
            str = d;
        }
        return str;
    }

    public static long i(Context context) {
        long j;
        synchronized (f3665b) {
            j = PreferenceWrapper.getDefault(context).getLong(f3664a, 0);
        }
        return j;
    }

    private static void j(Context context) {
        synchronized (f3665b) {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong(f3664a, System.currentTimeMillis()).commit();
        }
    }
}
