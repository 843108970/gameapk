package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.cyjh.common.util.s;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.proguard.e;
import com.umeng.commonsdk.proguard.v;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.common.MLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.microedition.khronos.opengles.GL10;
import org.slf4j.Marker;

public class UMUtils {
    public static final int DEFAULT_TIMEZONE = 8;
    private static final String KEY_APP_KEY = "appkey";
    private static final String KEY_CHANNEL = "channel";
    private static final String KEY_LAST_APP_KEY = "last_appkey";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String KEY_SHARED_PREFERENCES_NAME = "umeng_common_config";
    public static final String MOBILE_NETWORK = "2G/3G";
    private static final String SD_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final String TAG = "UMUtils";
    public static final String UNKNOW = "";
    public static final String WIFI = "Wi-Fi";
    private static final Pattern pattern = Pattern.compile("UTDID\">([^<]+)");

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003e, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        return r8.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004b, code lost:
        if (com.umeng.commonsdk.statistics.b.f != false) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004d, code lost:
        android.util.Log.e(TAG, "MD5 e is " + r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0060, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003e A[ExcHandler: Throwable (r8v4 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:3:0x0004] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String MD5(java.lang.String r8) {
        /*
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            byte[] r1 = r8.getBytes()     // Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
            java.lang.String r2 = "MD5"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
            r2.reset()     // Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
            r2.update(r1)     // Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
            byte[] r1 = r2.digest()     // Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
            r2.<init>()     // Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
            r3 = 0
            r4 = 0
        L_0x001f:
            int r5 = r1.length     // Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
            if (r4 >= r5) goto L_0x0039
            java.lang.String r5 = "%02X"
            r6 = 1
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
            byte r7 = r1[r4]     // Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
            java.lang.Byte r7 = java.lang.Byte.valueOf(r7)     // Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
            r6[r3] = r7     // Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
            java.lang.String r5 = java.lang.String.format(r5, r6)     // Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
            r2.append(r5)     // Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
            int r4 = r4 + 1
            goto L_0x001f
        L_0x0039:
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
            return r1
        L_0x003e:
            r8 = move-exception
            goto L_0x0049
        L_0x0040:
            java.lang.String r1 = "[^[a-z][A-Z][0-9][.][_]]"
            java.lang.String r2 = ""
            java.lang.String r8 = r8.replaceAll(r1, r2)     // Catch:{ Exception -> 0x0061, Throwable -> 0x003e }
            return r8
        L_0x0049:
            boolean r1 = com.umeng.commonsdk.statistics.b.f
            if (r1 == 0) goto L_0x0060
            java.lang.String r1 = "UMUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "MD5 e is "
            r2.<init>(r3)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            android.util.Log.e(r1, r8)
        L_0x0060:
            return r0
        L_0x0061:
            r8 = move-exception
            boolean r1 = com.umeng.commonsdk.statistics.b.f
            if (r1 == 0) goto L_0x0079
            java.lang.String r1 = "UMUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "MD5 e is "
            r2.<init>(r3)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            android.util.Log.e(r1, r8)
        L_0x0079:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.MD5(java.lang.String):java.lang.String");
    }

    private static String byte2HexFormatted(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i]);
            int length = hexString.length();
            if (length == 1) {
                hexString = "0" + hexString;
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase());
            if (i < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    private static String bytes2Hex(byte[] bArr) {
        String str = "";
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                str = str + "0";
            }
            str = str + hexString;
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean checkPermission(android.content.Context r6, java.lang.String r7) {
        /*
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            r3 = 1
            if (r1 < r2) goto L_0x0033
            java.lang.String r1 = "android.content.Context"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x002e }
            java.lang.String r2 = "checkSelfPermission"
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x002e }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r0] = r5     // Catch:{ Exception -> 0x002e }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch:{ Exception -> 0x002e }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x002e }
            r2[r0] = r7     // Catch:{ Exception -> 0x002e }
            java.lang.Object r7 = r1.invoke(r6, r2)     // Catch:{ Exception -> 0x002e }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ Exception -> 0x002e }
            int r7 = r7.intValue()     // Catch:{ Exception -> 0x002e }
            if (r7 != 0) goto L_0x0042
            goto L_0x0041
        L_0x002e:
            r7 = move-exception
            com.umeng.commonsdk.proguard.e.a(r6, r7)
            return r0
        L_0x0033:
            android.content.pm.PackageManager r1 = r6.getPackageManager()
            java.lang.String r6 = r6.getPackageName()
            int r6 = r1.checkPermission(r7, r6)
            if (r6 != 0) goto L_0x0042
        L_0x0041:
            r0 = 1
        L_0x0042:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.checkPermission(android.content.Context, java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        if (com.umeng.commonsdk.statistics.b.f != false) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        android.util.Log.e(TAG, "encrypt by SHA1 e is " + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018 A[ExcHandler: Throwable (r4v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0001] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String encryptBySHA1(java.lang.String r4) {
        /*
            r0 = 0
            byte[] r4 = r4.getBytes()     // Catch:{ Exception -> 0x0031, Throwable -> 0x0018 }
            java.lang.String r1 = "SHA1"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ Exception -> 0x0017, Throwable -> 0x0018 }
            r1.update(r4)     // Catch:{ Exception -> 0x0017, Throwable -> 0x0018 }
            byte[] r4 = r1.digest()     // Catch:{ Exception -> 0x0017, Throwable -> 0x0018 }
            java.lang.String r4 = bytes2Hex(r4)     // Catch:{ Exception -> 0x0017, Throwable -> 0x0018 }
            return r4
        L_0x0017:
            return r0
        L_0x0018:
            r4 = move-exception
            boolean r1 = com.umeng.commonsdk.statistics.b.f
            if (r1 == 0) goto L_0x0030
            java.lang.String r1 = "UMUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "encrypt by SHA1 e is "
            r2.<init>(r3)
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            android.util.Log.e(r1, r4)
        L_0x0030:
            return r0
        L_0x0031:
            r4 = move-exception
            boolean r1 = com.umeng.commonsdk.statistics.b.f
            if (r1 == 0) goto L_0x0049
            java.lang.String r1 = "UMUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "encrypt by SHA1 e is "
            r2.<init>(r3)
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            android.util.Log.e(r1, r4)
        L_0x0049:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.encryptBySHA1(java.lang.String):java.lang.String");
    }

    public static String getAppMD5Signature(Context context) {
        PackageInfo packageInfo;
        CertificateFactory certificateFactory;
        X509Certificate x509Certificate;
        if (context == null) {
            return null;
        }
        try {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                packageInfo = null;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(packageInfo.signatures[0].toByteArray());
            try {
                certificateFactory = CertificateFactory.getInstance("X509");
            } catch (CertificateException e2) {
                e2.printStackTrace();
                certificateFactory = null;
            }
            try {
                x509Certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
            } catch (CertificateException e3) {
                e3.printStackTrace();
                x509Certificate = null;
            }
            try {
                return byte2HexFormatted(MessageDigest.getInstance("MD5").digest(x509Certificate.getEncoded()));
            } catch (NoSuchAlgorithmException e4) {
                e4.printStackTrace();
                return null;
            } catch (CertificateEncodingException e5) {
                e5.printStackTrace();
                return null;
            }
        } catch (Exception e6) {
            if (b.f) {
                Log.e(TAG, "get app MD5 signature e is " + e6);
            }
            e.a(context, e6);
            return null;
        } catch (Throwable th) {
            if (b.f) {
                Log.e(TAG, "get app MD5 signature e is " + th);
            }
            e.a(context, th);
            return null;
        }
    }

    public static String getAppName(Context context) {
        Throwable th;
        StringBuilder sb;
        String str;
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Exception e) {
            th = e;
            if (b.f) {
                str = TAG;
                sb = new StringBuilder("get app name e is ");
                sb.append(th);
                Log.e(str, sb.toString());
            }
            e.a(context, th);
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (b.f) {
                str = TAG;
                sb = new StringBuilder("get app name e is ");
                sb.append(th);
                Log.e(str, sb.toString());
            }
            e.a(context, th);
            return null;
        }
    }

    public static String getAppVersinoCode(Context context, String str) {
        if (context == null || str == null) {
            return "";
        }
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(str, 0).versionCode);
        } catch (Exception e) {
            if (!b.f) {
                return "";
            }
            Log.e(TAG, "get app version code e is " + e);
            return "";
        } catch (Throwable th) {
            if (!b.f) {
                return "";
            }
            Log.e(TAG, "get app version code e is " + th);
            return "";
        }
    }

    public static String getAppVersionCode(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (Exception e) {
            if (!b.f) {
                return "";
            }
            Log.e(TAG, "get app version code e is " + e);
            return "";
        } catch (Throwable th) {
            if (!b.f) {
                return "";
            }
            Log.e(TAG, "get app version code e is " + th);
            return "";
        }
    }

    public static String getAppVersionName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            if (!b.f) {
                return "";
            }
            Log.e(TAG, "get app version name e is " + e);
            return "";
        } catch (Throwable th) {
            if (!b.f) {
                return "";
            }
            Log.e(TAG, "get app version name e is " + th);
            return "";
        }
    }

    public static String getAppVersionName(Context context, String str) {
        String str2;
        StringBuilder sb;
        if (context == null || str == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            th = e;
            if (b.f) {
                str2 = TAG;
                sb = new StringBuilder("get app version name e is ");
                sb.append(th);
                Log.e(str2, sb.toString());
            }
            e.a(context, th);
            return "";
        } catch (Throwable th) {
            th = th;
            if (b.f) {
                str2 = TAG;
                sb = new StringBuilder("get app version name e is ");
                sb.append(th);
                Log.e(str2, sb.toString());
            }
            e.a(context, th);
            return "";
        }
    }

    public static synchronized String getAppkey(Context context) {
        synchronized (UMUtils.class) {
            if (context == null) {
                return null;
            }
            try {
                SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("umeng_common_config", 0);
                if (sharedPreferences == null) {
                    return null;
                }
                String string = sharedPreferences.getString("appkey", (String) null);
                return string;
            } catch (Exception e) {
                if (b.f) {
                    Log.e(TAG, "get app key e is " + e);
                }
                e.a(context, e);
                return null;
            } catch (Throwable th) {
                if (b.f) {
                    Log.e(TAG, "get app key e is " + th);
                }
                e.a(context, th);
                return null;
            }
        }
    }

    public static String getAppkeyByXML(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return null;
            }
            String string = applicationInfo.metaData.getString("UMENG_APPKEY");
            if (string != null) {
                return string.trim();
            }
            MLog.e(b.f3868c, "getAppkey failed. the applicationinfo is null!");
            return null;
        } catch (Throwable th) {
            MLog.e(b.f3868c, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.", th);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002d A[SYNTHETIC, Splitter:B:17:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0038 A[SYNTHETIC, Splitter:B:24:0x0038] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Properties getBuildProp() {
        /*
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0027 }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x0027 }
            java.io.File r4 = android.os.Environment.getRootDirectory()     // Catch:{ IOException -> 0x0027 }
            java.lang.String r5 = "build.prop"
            r3.<init>(r4, r5)     // Catch:{ IOException -> 0x0027 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0027 }
            r0.load(r2)     // Catch:{ IOException -> 0x0020, all -> 0x001d }
            r2.close()     // Catch:{ IOException -> 0x0031 }
            return r0
        L_0x001d:
            r0 = move-exception
            r1 = r2
            goto L_0x0036
        L_0x0020:
            r1 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
            goto L_0x0028
        L_0x0025:
            r0 = move-exception
            goto L_0x0036
        L_0x0027:
            r2 = move-exception
        L_0x0028:
            r2.printStackTrace()     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x0035
            r1.close()     // Catch:{ IOException -> 0x0031 }
            return r0
        L_0x0031:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0035:
            return r0
        L_0x0036:
            if (r1 == 0) goto L_0x0040
            r1.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x0040
        L_0x003c:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0040:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.getBuildProp():java.util.Properties");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0045 A[Catch:{ Exception -> 0x003d, Throwable -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a A[Catch:{ Exception -> 0x003d, Throwable -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006b A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getCPU() {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x003f }
            java.lang.String r2 = "/proc/cpuinfo"
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x003f }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0021 }
            r3 = 1024(0x400, float:1.435E-42)
            r2.<init>(r1, r3)     // Catch:{ IOException -> 0x0021 }
            java.lang.String r3 = r2.readLine()     // Catch:{ IOException -> 0x0021 }
            r2.close()     // Catch:{ IOException -> 0x001d, FileNotFoundException -> 0x001a }
            r1.close()     // Catch:{ IOException -> 0x001d, FileNotFoundException -> 0x001a }
            goto L_0x0058
        L_0x001a:
            r0 = move-exception
            r1 = r0
            goto L_0x0041
        L_0x001d:
            r0 = move-exception
            r1 = r0
            r0 = r3
            goto L_0x0022
        L_0x0021:
            r1 = move-exception
        L_0x0022:
            boolean r2 = com.umeng.commonsdk.statistics.b.f     // Catch:{ FileNotFoundException -> 0x003f }
            if (r2 == 0) goto L_0x0039
            java.lang.String r2 = "UMUtils"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x003f }
            java.lang.String r4 = "Could not read from file /proc/cpuinfo, e is "
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x003f }
            r3.append(r1)     // Catch:{ FileNotFoundException -> 0x003f }
            java.lang.String r1 = r3.toString()     // Catch:{ FileNotFoundException -> 0x003f }
            android.util.Log.e(r2, r1)     // Catch:{ FileNotFoundException -> 0x003f }
        L_0x0039:
            r3 = r0
            goto L_0x0058
        L_0x003b:
            r0 = move-exception
            goto L_0x006e
        L_0x003d:
            r0 = move-exception
            goto L_0x0088
        L_0x003f:
            r1 = move-exception
            r3 = r0
        L_0x0041:
            boolean r0 = com.umeng.commonsdk.statistics.b.f     // Catch:{ Exception -> 0x003d, Throwable -> 0x003b }
            if (r0 == 0) goto L_0x0058
            java.lang.String r0 = "UMUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003d, Throwable -> 0x003b }
            java.lang.String r4 = "Could not read from file /proc/cpuinfo, e is "
            r2.<init>(r4)     // Catch:{ Exception -> 0x003d, Throwable -> 0x003b }
            r2.append(r1)     // Catch:{ Exception -> 0x003d, Throwable -> 0x003b }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x003d, Throwable -> 0x003b }
            android.util.Log.e(r0, r1)     // Catch:{ Exception -> 0x003d, Throwable -> 0x003b }
        L_0x0058:
            if (r3 == 0) goto L_0x006b
            r0 = 58
            int r0 = r3.indexOf(r0)     // Catch:{ Exception -> 0x003d, Throwable -> 0x003b }
            int r0 = r0 + 1
            java.lang.String r0 = r3.substring(r0)     // Catch:{ Exception -> 0x003d, Throwable -> 0x003b }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x003d, Throwable -> 0x003b }
            return r0
        L_0x006b:
            java.lang.String r0 = ""
            return r0
        L_0x006e:
            boolean r1 = com.umeng.commonsdk.statistics.b.f
            if (r1 == 0) goto L_0x0085
            java.lang.String r1 = "UMUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "get cpu e is "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.util.Log.e(r1, r0)
        L_0x0085:
            java.lang.String r0 = ""
            return r0
        L_0x0088:
            boolean r1 = com.umeng.commonsdk.statistics.b.f
            if (r1 == 0) goto L_0x009f
            java.lang.String r1 = "UMUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "get cpu e is "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.util.Log.e(r1, r0)
        L_0x009f:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.getCPU():java.lang.String");
    }

    public static String getChannel(Context context) {
        if (context == null) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("umeng_common_config", 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString("channel", (String) null);
            }
            return null;
        } catch (Exception e) {
            if (b.f) {
                Log.e(TAG, "get channel e is " + e);
            }
            e.a(context, e);
            return null;
        } catch (Throwable th) {
            if (b.f) {
                Log.e(TAG, "get channel e is " + th);
            }
            e.a(context, th);
            return null;
        }
    }

    public static String getChannelByXML(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return null;
            }
            String string = applicationInfo.metaData.getString("UMENG_CHANNEL");
            if (string != null) {
                return string.trim();
            }
            MLog.e(b.f3868c, "getChannel failed. the applicationinfo is null!");
            return null;
        } catch (Throwable th) {
            MLog.e(b.f3868c, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.", th);
            return null;
        }
    }

    public static String getDeviceToken(Context context) {
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            Class<?> cls = Class.forName("com.umeng.message.MessageSharedPrefs");
            if (cls == null || (method = cls.getMethod("getInstance", new Class[]{Context.class})) == null || (invoke = method.invoke(cls, new Object[]{applicationContext})) == null || (method2 = cls.getMethod("getDeviceToken", new Class[0])) == null || (invoke2 = method2.invoke(invoke, new Object[0])) == null || !(invoke2 instanceof String)) {
                return null;
            }
            return (String) invoke2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getDeviceType(Context context) {
        if (context == null) {
            return "Phone";
        }
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3 ? "Tablet" : "Phone";
        } catch (Exception e) {
            if (b.f) {
                Log.e(TAG, "get device type e is " + e);
            }
            e.a(context, e);
            return null;
        } catch (Throwable th) {
            if (b.f) {
                Log.e(TAG, "get device type e is " + th);
            }
            e.a(context, th);
            return null;
        }
    }

    public static String getDisplayResolution(Context context) {
        String str;
        StringBuilder sb;
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            return String.valueOf(i2) + Marker.ANY_MARKER + String.valueOf(i);
        } catch (Exception e) {
            th = e;
            if (b.f) {
                str = TAG;
                sb = new StringBuilder("get display resolution e is ");
                sb.append(th);
                Log.e(str, sb.toString());
            }
            e.a(context, th);
            return "";
        } catch (Throwable th) {
            th = th;
            if (b.f) {
                str = TAG;
                sb = new StringBuilder("get display resolution e is ");
                sb.append(th);
                Log.e(str, sb.toString());
            }
            e.a(context, th);
            return "";
        }
    }

    private static File getFile(Context context) {
        if (context != null && checkPermission(context, SD_PERMISSION) && Environment.getExternalStorageState().equals("mounted")) {
            try {
                return new File(Environment.getExternalStorageDirectory().getCanonicalPath(), ".UTSystemConfig/Global/Alvin2.xml");
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
        if (com.umeng.commonsdk.statistics.b.f != false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0047, code lost:
        android.util.Log.e(TAG, "get file MD5 e is " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005b, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005e, code lost:
        if (com.umeng.commonsdk.statistics.b.f != false) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0060, code lost:
        android.util.Log.e(TAG, "get file MD5 e is " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0073, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0042 A[ExcHandler: Throwable (r7v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0003] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFileMD5(java.io.File r7) {
        /*
            r0 = 1024(0x400, float:1.435E-42)
            r1 = 0
            byte[] r2 = new byte[r0]     // Catch:{ Exception -> 0x005b, Throwable -> 0x0042 }
            boolean r3 = r7.isFile()     // Catch:{ Exception -> 0x003d, Throwable -> 0x0042 }
            if (r3 != 0) goto L_0x000e
            java.lang.String r7 = ""
            return r7
        L_0x000e:
            java.lang.String r3 = "MD5"
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r3)     // Catch:{ Exception -> 0x003d, Throwable -> 0x0042 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x003d, Throwable -> 0x0042 }
            r4.<init>(r7)     // Catch:{ Exception -> 0x003d, Throwable -> 0x0042 }
        L_0x0019:
            r7 = 0
            int r5 = r4.read(r2, r7, r0)     // Catch:{ Exception -> 0x003d, Throwable -> 0x0042 }
            r6 = -1
            if (r5 == r6) goto L_0x0025
            r3.update(r2, r7, r5)     // Catch:{ Exception -> 0x003d, Throwable -> 0x0042 }
            goto L_0x0019
        L_0x0025:
            r4.close()     // Catch:{ Exception -> 0x003d, Throwable -> 0x0042 }
            java.math.BigInteger r0 = new java.math.BigInteger     // Catch:{ Exception -> 0x005b, Throwable -> 0x0042 }
            byte[] r2 = r3.digest()     // Catch:{ Exception -> 0x005b, Throwable -> 0x0042 }
            r3 = 1
            r0.<init>(r3, r2)     // Catch:{ Exception -> 0x005b, Throwable -> 0x0042 }
            java.lang.String r2 = "%1$032x"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x005b, Throwable -> 0x0042 }
            r3[r7] = r0     // Catch:{ Exception -> 0x005b, Throwable -> 0x0042 }
            java.lang.String r7 = java.lang.String.format(r2, r3)     // Catch:{ Exception -> 0x005b, Throwable -> 0x0042 }
            return r7
        L_0x003d:
            r7 = move-exception
            r7.printStackTrace()     // Catch:{ Exception -> 0x005b, Throwable -> 0x0042 }
            return r1
        L_0x0042:
            r7 = move-exception
            boolean r0 = com.umeng.commonsdk.statistics.b.f
            if (r0 == 0) goto L_0x005a
            java.lang.String r0 = "UMUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "get file MD5 e is "
            r2.<init>(r3)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            android.util.Log.e(r0, r7)
        L_0x005a:
            return r1
        L_0x005b:
            r7 = move-exception
            boolean r0 = com.umeng.commonsdk.statistics.b.f
            if (r0 == 0) goto L_0x0073
            java.lang.String r0 = "UMUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "get file MD5 e is "
            r2.<init>(r3)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            android.util.Log.e(r0, r7)
        L_0x0073:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.getFileMD5(java.io.File):java.lang.String");
    }

    private static String getFlymeVersion(Properties properties) {
        try {
            String lowerCase = properties.getProperty("ro.build.display.id").toLowerCase(Locale.getDefault());
            if (lowerCase.contains("flyme os")) {
                return lowerCase.split(s.a.f1696a)[2];
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String[] getGPU(GL10 gl10) {
        try {
            return new String[]{gl10.glGetString(7936), gl10.glGetString(7937)};
        } catch (Exception e) {
            if (b.f) {
                Log.e(TAG, "Could not read gpu infor, e is " + e);
            }
            return new String[0];
        } catch (Throwable th) {
            if (b.f) {
                Log.e(TAG, "Could not read gpu infor, e is " + th);
            }
            return new String[0];
        }
    }

    public static String getImsi(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                return telephonyManager.getSubscriberId();
            }
            return null;
        } catch (Exception e) {
            if (b.f) {
                Log.e(TAG, "get imei e is " + e);
            }
            e.a(context, e);
            return null;
        } catch (Throwable th) {
            if (b.f) {
                Log.e(TAG, "get imei e is " + th);
            }
            e.a(context, th);
            return null;
        }
    }

    public static String getLastAppkey(Context context) {
        if (context == null) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("umeng_common_config", 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString(KEY_LAST_APP_KEY, (String) null);
            }
            return null;
        } catch (Exception e) {
            if (b.f) {
                Log.e(TAG, "get last app key e is " + e);
            }
            e.a(context, e);
            return null;
        } catch (Throwable th) {
            if (b.f) {
                Log.e(TAG, "get last app key e is " + th);
            }
            e.a(context, th);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
        if (com.umeng.commonsdk.statistics.b.f != false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
        android.util.Log.e(TAG, "get locale e is " + r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004f, code lost:
        com.umeng.commonsdk.proguard.e.a(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0052, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0053, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        if (com.umeng.commonsdk.statistics.b.f != false) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
        android.util.Log.e(TAG, "get locale e is " + r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006b, code lost:
        com.umeng.commonsdk.proguard.e.a(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006e, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0016, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0016 A[ExcHandler: Throwable (r1v6 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:3:0x0004] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Locale getLocale(android.content.Context r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.content.res.Configuration r1 = new android.content.res.Configuration     // Catch:{ Exception -> 0x0018, Throwable -> 0x0016 }
            r1.<init>()     // Catch:{ Exception -> 0x0018, Throwable -> 0x0016 }
            r1.setToDefaults()     // Catch:{ Exception -> 0x0018, Throwable -> 0x0016 }
            android.content.ContentResolver r2 = r5.getContentResolver()     // Catch:{ Exception -> 0x0018, Throwable -> 0x0016 }
            android.provider.Settings.System.getConfiguration(r2, r1)     // Catch:{ Exception -> 0x0018, Throwable -> 0x0016 }
            java.util.Locale r1 = r1.locale     // Catch:{ Exception -> 0x0018, Throwable -> 0x0016 }
            goto L_0x0031
        L_0x0016:
            r1 = move-exception
            goto L_0x0038
        L_0x0018:
            r1 = move-exception
            boolean r2 = com.umeng.commonsdk.statistics.b.f     // Catch:{ Exception -> 0x0053, Throwable -> 0x0016 }
            if (r2 == 0) goto L_0x0030
            java.lang.String r2 = "UMUtils"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0053, Throwable -> 0x0016 }
            java.lang.String r4 = "fail to read user config locale, e is "
            r3.<init>(r4)     // Catch:{ Exception -> 0x0053, Throwable -> 0x0016 }
            r3.append(r1)     // Catch:{ Exception -> 0x0053, Throwable -> 0x0016 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0053, Throwable -> 0x0016 }
            android.util.Log.e(r2, r1)     // Catch:{ Exception -> 0x0053, Throwable -> 0x0016 }
        L_0x0030:
            r1 = r0
        L_0x0031:
            if (r1 != 0) goto L_0x0037
            java.util.Locale r1 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0053, Throwable -> 0x0016 }
        L_0x0037:
            return r1
        L_0x0038:
            boolean r2 = com.umeng.commonsdk.statistics.b.f
            if (r2 == 0) goto L_0x004f
            java.lang.String r2 = "UMUtils"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "get locale e is "
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r2, r3)
        L_0x004f:
            com.umeng.commonsdk.proguard.e.a(r5, r1)
            return r0
        L_0x0053:
            r1 = move-exception
            boolean r2 = com.umeng.commonsdk.statistics.b.f
            if (r2 == 0) goto L_0x006b
            java.lang.String r2 = "UMUtils"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "get locale e is "
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r2, r3)
        L_0x006b:
            com.umeng.commonsdk.proguard.e.a(r5, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.getLocale(android.content.Context):java.util.Locale");
    }

    public static String getMac(Context context) {
        if (context == null) {
            return null;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                return wifiManager.getConnectionInfo().getMacAddress();
            }
            if (!b.f) {
                return "";
            }
            Log.e(TAG, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
            return "";
        } catch (Exception e) {
            if (b.f) {
                Log.e(TAG, "get mac e is " + e);
            }
            e.a(context, e);
            return null;
        } catch (Throwable th) {
            if (b.f) {
                Log.e(TAG, "get mac e is " + th);
            }
            e.a(context, th);
            return null;
        }
    }

    public static String[] getNetworkAccessMode(Context context) {
        Throwable th;
        StringBuilder sb;
        String str;
        String[] strArr = {"", ""};
        if (context == null) {
            return strArr;
        }
        try {
            if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                strArr[0] = "";
                return strArr;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                strArr[0] = "";
                return strArr;
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo == null || networkInfo.getState() != NetworkInfo.State.CONNECTED) {
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                if (networkInfo2 != null && networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
                    strArr[0] = "2G/3G";
                    strArr[1] = networkInfo2.getSubtypeName();
                    return strArr;
                }
                return strArr;
            }
            strArr[0] = "Wi-Fi";
            return strArr;
        } catch (Exception e) {
            th = e;
            if (b.f) {
                str = TAG;
                sb = new StringBuilder("get network access mode e is ");
                sb.append(th);
                Log.e(str, sb.toString());
            }
            e.a(context, th);
            return strArr;
        } catch (Throwable th2) {
            th = th2;
            if (b.f) {
                str = TAG;
                sb = new StringBuilder("get network access mode e is ");
                sb.append(th);
                Log.e(str, sb.toString());
            }
            e.a(context, th);
            return strArr;
        }
    }

    public static String getNetworkOperatorName(Context context) {
        String str;
        StringBuilder sb;
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) ? telephonyManager.getNetworkOperatorName() : "";
        } catch (Exception e) {
            th = e;
            if (b.f) {
                str = TAG;
                sb = new StringBuilder("get network operator e is ");
                sb.append(th);
                Log.e(str, sb.toString());
            }
            e.a(context, th);
            return "";
        } catch (Throwable th) {
            th = th;
            if (b.f) {
                str = TAG;
                sb = new StringBuilder("get network operator e is ");
                sb.append(th);
                Log.e(str, sb.toString());
            }
            e.a(context, th);
            return "";
        }
    }

    public static String getOperator(Context context) {
        Throwable th;
        StringBuilder sb;
        String str;
        if (context == null) {
            return "Unknown";
        }
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
        } catch (Exception e) {
            th = e;
            if (b.f) {
                str = TAG;
                sb = new StringBuilder("get get operator e is ");
                sb.append(th);
                Log.e(str, sb.toString());
            }
            e.a(context, th);
            return "Unknown";
        } catch (Throwable th2) {
            th = th2;
            if (b.f) {
                str = TAG;
                sb = new StringBuilder("get get operator e is ");
                sb.append(th);
                Log.e(str, sb.toString());
            }
            e.a(context, th);
            return "Unknown";
        }
    }

    public static String getRegisteredOperator(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                return telephonyManager.getNetworkOperator();
            }
            return null;
        } catch (Exception e) {
            if (b.f) {
                Log.e(TAG, "get registered operator e is " + e);
            }
            e.a(context, e);
            return null;
        } catch (Throwable th) {
            if (b.f) {
                Log.e(TAG, "get registered operator e is " + th);
            }
            e.a(context, th);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0035, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0038, code lost:
        if (com.umeng.commonsdk.statistics.b.f != false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003a, code lost:
        android.util.Log.e(TAG, "get sub os name e is " + r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004d, code lost:
        com.umeng.commonsdk.proguard.e.a(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0050, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0051, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0054, code lost:
        if (com.umeng.commonsdk.statistics.b.f != false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0056, code lost:
        android.util.Log.e(TAG, "get sub os name e is " + r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0069, code lost:
        com.umeng.commonsdk.proguard.e.a(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006c, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0035 A[ExcHandler: Throwable (r1v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:3:0x0004] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getSubOSName(android.content.Context r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.util.Properties r1 = getBuildProp()     // Catch:{ Exception -> 0x0051, Throwable -> 0x0035 }
            java.lang.String r2 = "ro.miui.ui.version.name"
            java.lang.String r2 = r1.getProperty(r2)     // Catch:{ Exception -> 0x0030, Throwable -> 0x0035 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0030, Throwable -> 0x0035 }
            if (r3 == 0) goto L_0x002d
            boolean r3 = isFlyMe()     // Catch:{ Exception -> 0x0030, Throwable -> 0x0035 }
            if (r3 == 0) goto L_0x001e
            java.lang.String r1 = "Flyme"
        L_0x001c:
            r0 = r1
            return r0
        L_0x001e:
            java.lang.String r1 = getYunOSVersion(r1)     // Catch:{ Exception -> 0x0030, Throwable -> 0x0035 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0030, Throwable -> 0x0035 }
            if (r1 != 0) goto L_0x002b
            java.lang.String r1 = "YunOS"
            goto L_0x001c
        L_0x002b:
            r0 = r2
            return r0
        L_0x002d:
            java.lang.String r1 = "MIUI"
            goto L_0x001c
        L_0x0030:
            r1 = move-exception
            com.umeng.commonsdk.proguard.e.a(r5, r1)     // Catch:{ Exception -> 0x0051, Throwable -> 0x0035 }
            return r0
        L_0x0035:
            r1 = move-exception
            boolean r2 = com.umeng.commonsdk.statistics.b.f
            if (r2 == 0) goto L_0x004d
            java.lang.String r2 = "UMUtils"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "get sub os name e is "
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r2, r3)
        L_0x004d:
            com.umeng.commonsdk.proguard.e.a(r5, r1)
            return r0
        L_0x0051:
            r1 = move-exception
            boolean r2 = com.umeng.commonsdk.statistics.b.f
            if (r2 == 0) goto L_0x0069
            java.lang.String r2 = "UMUtils"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "get sub os name e is "
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r2, r3)
        L_0x0069:
            com.umeng.commonsdk.proguard.e.a(r5, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.getSubOSName(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0026, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        com.umeng.commonsdk.proguard.e.a(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002b, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x002c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x002f, code lost:
        if (com.umeng.commonsdk.statistics.b.f != false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0031, code lost:
        android.util.Log.e(TAG, "get sub os version e is " + r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0044, code lost:
        com.umeng.commonsdk.proguard.e.a(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0047, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0048, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004b, code lost:
        if (com.umeng.commonsdk.statistics.b.f != false) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004d, code lost:
        android.util.Log.e(TAG, "get sub os version e is " + r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0060, code lost:
        com.umeng.commonsdk.proguard.e.a(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0063, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x002c A[ExcHandler: Throwable (r1v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:3:0x0004] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getSubOSVersion(android.content.Context r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.util.Properties r1 = getBuildProp()     // Catch:{ Exception -> 0x0048, Throwable -> 0x002c }
            java.lang.String r2 = "ro.miui.ui.version.name"
            java.lang.String r2 = r1.getProperty(r2)     // Catch:{ Exception -> 0x0026, Throwable -> 0x002c }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0026, Throwable -> 0x002c }
            if (r3 == 0) goto L_0x0024
            boolean r3 = isFlyMe()     // Catch:{ Exception -> 0x0026, Throwable -> 0x002c }
            if (r3 == 0) goto L_0x001f
            java.lang.String r1 = getFlymeVersion(r1)     // Catch:{ Exception -> 0x0024, Throwable -> 0x002c }
            return r1
        L_0x001f:
            java.lang.String r1 = getYunOSVersion(r1)     // Catch:{ Exception -> 0x0024, Throwable -> 0x002c }
            return r1
        L_0x0024:
            r1 = r2
            return r1
        L_0x0026:
            r1 = move-exception
            com.umeng.commonsdk.proguard.e.a(r5, r1)     // Catch:{ Exception -> 0x0048, Throwable -> 0x002c }
            r1 = r0
            return r1
        L_0x002c:
            r1 = move-exception
            boolean r2 = com.umeng.commonsdk.statistics.b.f
            if (r2 == 0) goto L_0x0044
            java.lang.String r2 = "UMUtils"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "get sub os version e is "
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r2, r3)
        L_0x0044:
            com.umeng.commonsdk.proguard.e.a(r5, r1)
            return r0
        L_0x0048:
            r1 = move-exception
            boolean r2 = com.umeng.commonsdk.statistics.b.f
            if (r2 == 0) goto L_0x0060
            java.lang.String r2 = "UMUtils"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "get sub os version e is "
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r2, r3)
        L_0x0060:
            com.umeng.commonsdk.proguard.e.a(r5, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.getSubOSVersion(android.content.Context):java.lang.String");
    }

    public static String getUMId(Context context) {
        if (context != null) {
            try {
                return UMEnvelopeBuild.imprintProperty(context.getApplicationContext(), v.e, (String) null);
            } catch (Exception e) {
                e.a(context, e);
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        if (com.umeng.commonsdk.statistics.b.f != false) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        android.util.Log.e(TAG, "get utiid e is " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0045, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        if (com.umeng.commonsdk.statistics.b.f != false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        android.util.Log.e(TAG, "get utiid e is " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0029 */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0027 A[ExcHandler: Throwable (r7v4 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:4:0x0006] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getUTDID(android.content.Context r7) {
        /*
            r0 = 0
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "com.ut.device.UTDevice"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x0029, Throwable -> 0x0027 }
            java.lang.String r2 = "getUtdid"
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0029, Throwable -> 0x0027 }
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            r6 = 0
            r4[r6] = r5     // Catch:{ Exception -> 0x0029, Throwable -> 0x0027 }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch:{ Exception -> 0x0029, Throwable -> 0x0027 }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0029, Throwable -> 0x0027 }
            android.content.Context r3 = r7.getApplicationContext()     // Catch:{ Exception -> 0x0029, Throwable -> 0x0027 }
            r2[r6] = r3     // Catch:{ Exception -> 0x0029, Throwable -> 0x0027 }
            java.lang.Object r1 = r1.invoke(r0, r2)     // Catch:{ Exception -> 0x0029, Throwable -> 0x0027 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0029, Throwable -> 0x0027 }
            return r1
        L_0x0027:
            r7 = move-exception
            goto L_0x002e
        L_0x0029:
            java.lang.String r7 = readUTDId(r7)     // Catch:{ Exception -> 0x0046, Throwable -> 0x0027 }
            return r7
        L_0x002e:
            boolean r1 = com.umeng.commonsdk.statistics.b.f
            if (r1 == 0) goto L_0x0045
            java.lang.String r1 = "UMUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "get utiid e is "
            r2.<init>(r3)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            android.util.Log.e(r1, r7)
        L_0x0045:
            return r0
        L_0x0046:
            r7 = move-exception
            boolean r1 = com.umeng.commonsdk.statistics.b.f
            if (r1 == 0) goto L_0x005e
            java.lang.String r1 = "UMUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "get utiid e is "
            r2.<init>(r3)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            android.util.Log.e(r1, r7)
        L_0x005e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.getUTDID(android.content.Context):java.lang.String");
    }

    private static String getYunOSVersion(Properties properties) {
        String property = properties.getProperty("ro.yunos.version");
        if (!TextUtils.isEmpty(property)) {
            return property;
        }
        return null;
    }

    public static boolean isDebug(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            e.a(context, e);
            return false;
        }
    }

    private static boolean isFlyMe() {
        try {
            Build.class.getMethod("hasSmartBar", new Class[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isSdCardWrittenable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    private static String parseId(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private static String readStreamToString(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[1024];
        StringWriter stringWriter = new StringWriter();
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (-1 == read) {
                return stringWriter.toString();
            }
            stringWriter.write(cArr, 0, read);
        }
    }

    private static String readUTDId(Context context) {
        File file;
        FileInputStream fileInputStream;
        if (context == null || (file = getFile(context)) == null || !file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            String parseId = parseId(readStreamToString(fileInputStream));
            safeClose(fileInputStream);
            return parseId;
        } catch (Exception unused) {
            return null;
        } catch (Throwable th) {
            safeClose(fileInputStream);
            throw th;
        }
    }

    private static void safeClose(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0063, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void setAppkey(android.content.Context r4, java.lang.String r5) {
        /*
            java.lang.Class<com.umeng.commonsdk.utils.UMUtils> r0 = com.umeng.commonsdk.utils.UMUtils.class
            monitor-enter(r0)
            if (r4 == 0) goto L_0x0062
            if (r5 != 0) goto L_0x0008
            goto L_0x0062
        L_0x0008:
            android.content.Context r1 = r4.getApplicationContext()     // Catch:{ Exception -> 0x0043, Throwable -> 0x0026 }
            java.lang.String r2 = "umeng_common_config"
            r3 = 0
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)     // Catch:{ Exception -> 0x0043, Throwable -> 0x0026 }
            if (r1 == 0) goto L_0x0022
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ Exception -> 0x0043, Throwable -> 0x0026 }
            java.lang.String r2 = "appkey"
            android.content.SharedPreferences$Editor r5 = r1.putString(r2, r5)     // Catch:{ Exception -> 0x0043, Throwable -> 0x0026 }
            r5.commit()     // Catch:{ Exception -> 0x0043, Throwable -> 0x0026 }
        L_0x0022:
            monitor-exit(r0)
            return
        L_0x0024:
            r4 = move-exception
            goto L_0x0060
        L_0x0026:
            r5 = move-exception
            boolean r1 = com.umeng.commonsdk.statistics.b.f     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x003e
            java.lang.String r1 = "UMUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0024 }
            java.lang.String r3 = "set app key e is "
            r2.<init>(r3)     // Catch:{ all -> 0x0024 }
            r2.append(r5)     // Catch:{ all -> 0x0024 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0024 }
            android.util.Log.e(r1, r2)     // Catch:{ all -> 0x0024 }
        L_0x003e:
            com.umeng.commonsdk.proguard.e.a(r4, r5)     // Catch:{ all -> 0x0024 }
            monitor-exit(r0)
            return
        L_0x0043:
            r5 = move-exception
            boolean r1 = com.umeng.commonsdk.statistics.b.f     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x005b
            java.lang.String r1 = "UMUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0024 }
            java.lang.String r3 = "set app key e is "
            r2.<init>(r3)     // Catch:{ all -> 0x0024 }
            r2.append(r5)     // Catch:{ all -> 0x0024 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0024 }
            android.util.Log.e(r1, r2)     // Catch:{ all -> 0x0024 }
        L_0x005b:
            com.umeng.commonsdk.proguard.e.a(r4, r5)     // Catch:{ all -> 0x0024 }
            monitor-exit(r0)
            return
        L_0x0060:
            monitor-exit(r0)
            throw r4
        L_0x0062:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.setAppkey(android.content.Context, java.lang.String):void");
    }

    public static void setChannel(Context context, String str) {
        if (context != null && str != null) {
            try {
                SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("umeng_common_config", 0);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putString("channel", str).commit();
                }
            } catch (Exception e) {
                if (b.f) {
                    Log.e(TAG, "set channel e is " + e);
                }
                e.a(context, e);
            } catch (Throwable th) {
                if (b.f) {
                    Log.e(TAG, "set channel e is " + th);
                }
                e.a(context, th);
            }
        }
    }

    public static void setLastAppkey(Context context, String str) {
        if (context != null && str != null) {
            try {
                SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("umeng_common_config", 0);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putString(KEY_LAST_APP_KEY, str).commit();
                }
            } catch (Exception e) {
                if (b.f) {
                    Log.e(TAG, "set last app key e is " + e);
                }
                e.a(context, e);
            } catch (Throwable th) {
                if (b.f) {
                    Log.e(TAG, "set last app key e is " + th);
                }
                e.a(context, th);
            }
        }
    }
}
