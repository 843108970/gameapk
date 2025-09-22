package junit.runner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.NumberFormat;
import java.util.Properties;
import junit.b.b;
import junit.b.i;
import junit.b.l;
import junit.b.n;

public abstract class a implements l {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4043a = "suite";

    /* renamed from: b  reason: collision with root package name */
    static int f4044b = a("maxmessage", f4044b);

    /* renamed from: c  reason: collision with root package name */
    static boolean f4045c = true;
    private static Properties e;
    boolean d = true;

    private static int a(String str, int i) {
        String property = d().getProperty(str);
        if (property == null) {
            return i;
        }
        try {
            return Integer.parseInt(property);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    private static String a(long j) {
        return NumberFormat.getInstance().format(((double) j) / 1000.0d);
    }

    private static String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return d(stringWriter.toString());
    }

    private String a(String[] strArr) {
        String str = null;
        int i = 0;
        while (i < strArr.length) {
            if (strArr[i].equals("-noloading")) {
                this.d = false;
            } else if (strArr[i].equals("-nofilterstack")) {
                f4045c = false;
            } else if (strArr[i].equals("-c")) {
                i++;
                if (strArr.length > i) {
                    str = b(strArr[i]);
                } else {
                    System.out.println("Missing Test class name");
                }
            } else {
                str = strArr[i];
            }
            i++;
        }
        return str;
    }

    private static void a(String str, String str2) {
        d().put(str, str2);
    }

    private static void a(Properties properties) {
        e = properties;
    }

    public static String b(String str) {
        return str.startsWith("Default package for") ? str.substring(str.lastIndexOf(".") + 1) : str;
    }

    public static String d(String str) {
        if (!d().getProperty("filterstack").equals("true") || !f4045c) {
            return str;
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return stringWriter.toString();
                }
                if (!h(readLine)) {
                    printWriter.println(readLine);
                }
            } catch (Exception unused) {
                return str;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0045 A[SYNTHETIC, Splitter:B:15:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004b A[SYNTHETIC, Splitter:B:21:0x004b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Properties d() {
        /*
            java.util.Properties r0 = e
            if (r0 != 0) goto L_0x004e
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            e = r0
            java.lang.String r1 = "loading"
            java.lang.String r2 = "true"
            r0.put(r1, r2)
            java.util.Properties r0 = e
            java.lang.String r1 = "filterstack"
            java.lang.String r2 = "true"
            r0.put(r1, r2)
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0049, all -> 0x003f }
            java.io.File r2 = i()     // Catch:{ IOException -> 0x0049, all -> 0x003f }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0049, all -> 0x003f }
            java.util.Properties r0 = new java.util.Properties     // Catch:{ IOException -> 0x003d, all -> 0x003b }
            java.util.Properties r2 = d()     // Catch:{ IOException -> 0x003d, all -> 0x003b }
            r0.<init>(r2)     // Catch:{ IOException -> 0x003d, all -> 0x003b }
            e = r0     // Catch:{ IOException -> 0x003d, all -> 0x003b }
            java.util.Properties r0 = d()     // Catch:{ IOException -> 0x003d, all -> 0x003b }
            r0.load(r1)     // Catch:{ IOException -> 0x003d, all -> 0x003b }
            r1.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x004e
        L_0x003b:
            r0 = move-exception
            goto L_0x0043
        L_0x003d:
            r0 = r1
            goto L_0x0049
        L_0x003f:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L_0x0043:
            if (r1 == 0) goto L_0x0048
            r1.close()     // Catch:{ IOException -> 0x0048 }
        L_0x0048:
            throw r0
        L_0x0049:
            if (r0 == 0) goto L_0x004e
            r0.close()     // Catch:{ IOException -> 0x004e }
        L_0x004e:
            java.util.Properties r0 = e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: junit.runner.a.d():java.util.Properties");
    }

    private static String e(String str) {
        if (f4044b == -1 || str.length() <= f4044b) {
            return str;
        }
        return str.substring(0, f4044b) + "...";
    }

    private static void e() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(i());
        try {
            d().store(fileOutputStream, "");
        } finally {
            fileOutputStream.close();
        }
    }

    private static Class<?> f(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    private void f() {
        this.d = false;
    }

    private static String g(String str) {
        return d().getProperty(str);
    }

    private static void g() {
    }

    private boolean h() {
        return d().getProperty("loading").equals("true") && this.d;
    }

    private static boolean h(String str) {
        String[] strArr = {"junit.framework.TestCase", "junit.framework.TestResult", "junit.framework.TestSuite", "junit.framework.Assert.", "junit.swingui.TestRunner", "junit.awtui.TestRunner", "junit.textui.TestRunner", "java.lang.reflect.Method.invoke("};
        for (int i = 0; i < 8; i++) {
            if (str.indexOf(strArr[i]) > 0) {
                return true;
            }
        }
        return false;
    }

    private static File i() {
        return new File(System.getProperty("user.home"), "junit.properties");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a A[SYNTHETIC, Splitter:B:14:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0030 A[SYNTHETIC, Splitter:B:20:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void j() {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x002e, all -> 0x0024 }
            java.io.File r2 = i()     // Catch:{ IOException -> 0x002e, all -> 0x0024 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x002e, all -> 0x0024 }
            java.util.Properties r0 = new java.util.Properties     // Catch:{ IOException -> 0x0022, all -> 0x0020 }
            java.util.Properties r2 = d()     // Catch:{ IOException -> 0x0022, all -> 0x0020 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x0022, all -> 0x0020 }
            e = r0     // Catch:{ IOException -> 0x0022, all -> 0x0020 }
            java.util.Properties r0 = d()     // Catch:{ IOException -> 0x0022, all -> 0x0020 }
            r0.load(r1)     // Catch:{ IOException -> 0x0022, all -> 0x0020 }
            r1.close()     // Catch:{ IOException -> 0x001f }
        L_0x001f:
            return
        L_0x0020:
            r0 = move-exception
            goto L_0x0028
        L_0x0022:
            r0 = r1
            goto L_0x002e
        L_0x0024:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L_0x0028:
            if (r1 == 0) goto L_0x002d
            r1.close()     // Catch:{ IOException -> 0x002d }
        L_0x002d:
            throw r0
        L_0x002e:
            if (r0 == 0) goto L_0x0034
            r0.close()     // Catch:{ IOException -> 0x0034 }
            return
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: junit.runner.a.j():void");
    }

    private static boolean k() {
        return !d().getProperty("filterstack").equals("true") || !f4045c;
    }

    public final i a(String str) {
        StringBuilder sb;
        String str2;
        String sb2;
        if (str.length() <= 0) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(str);
            try {
                Method method = cls.getMethod(f4043a, new Class[0]);
                if (!Modifier.isStatic(method.getModifiers())) {
                    sb2 = "Suite() method must be static";
                    c(sb2);
                    return null;
                }
                try {
                    i iVar = (i) method.invoke((Object) null, new Object[0]);
                    if (iVar == null) {
                    }
                    return iVar;
                } catch (InvocationTargetException e2) {
                    sb = new StringBuilder("Failed to invoke suite():");
                    str2 = e2.getTargetException().toString();
                    sb.append(str2);
                    sb2 = sb.toString();
                    c(sb2);
                    return null;
                } catch (IllegalAccessException e3) {
                    sb = new StringBuilder("Failed to invoke suite():");
                    str2 = e3.toString();
                    sb.append(str2);
                    sb2 = sb.toString();
                    c(sb2);
                    return null;
                }
            } catch (Exception unused) {
                return new n(cls);
            }
        } catch (ClassNotFoundException e4) {
            String message = e4.getMessage();
            if (message != null) {
                str = message;
            }
            sb = new StringBuilder("Class not found \"");
            sb.append(str);
            str2 = "\"";
            sb.append(str2);
            sb2 = sb.toString();
            c(sb2);
            return null;
        } catch (Exception e5) {
            sb = new StringBuilder("Error: ");
            str2 = e5.toString();
            sb.append(str2);
            sb2 = sb.toString();
            c(sb2);
            return null;
        }
    }

    public abstract void a();

    public final synchronized void a(i iVar) {
        iVar.toString();
    }

    public final synchronized void a(i iVar, Throwable th) {
    }

    public final synchronized void a(i iVar, b bVar) {
    }

    public abstract void b();

    public final synchronized void b(i iVar) {
        iVar.toString();
    }

    public abstract void c();

    public abstract void c(String str);
}
