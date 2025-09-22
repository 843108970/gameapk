package mobi.oneway.export.g;

import android.util.Log;
import org.apache.commons.io.IOUtils;

public class m {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4226a = "OnewaySdk";

    /* renamed from: b  reason: collision with root package name */
    private static boolean f4227b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f4228c = false;

    private static class a extends Exception {
        a(String str) {
            super(str);
        }

        public String toString() {
            String str;
            String str2;
            String str3;
            StackTraceElement[] stackTrace = getStackTrace();
            StringBuilder sb = new StringBuilder();
            int i = 1;
            while (i < 4 && i < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                boolean isNativeMethod = stackTraceElement.isNativeMethod();
                String a2 = s.a(stackTraceElement.getClassName());
                int lineNumber = stackTraceElement.getLineNumber();
                String fileName = stackTraceElement.getFileName();
                String methodName = stackTraceElement.getMethodName();
                if (i == 1) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(a2);
                    sb2.append(".");
                    sb2.append(methodName);
                    if (isNativeMethod) {
                        str3 = "(Native)";
                    } else if (fileName != null) {
                        str3 = "(" + fileName + ":" + lineNumber + ")";
                    } else {
                        str3 = "(UnSrc)";
                    }
                    sb2.append(str3);
                    str = sb2.toString();
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(a2);
                    sb3.append(".");
                    sb3.append(methodName);
                    if (isNativeMethod) {
                        str2 = "(Native)";
                    } else {
                        str2 = "(" + lineNumber + ")";
                    }
                    sb3.append(str2);
                    str = sb3.toString();
                }
                sb.append("[");
                sb.append(str);
                sb.append("]");
                if (i < 3) {
                    sb.append("->");
                }
                i++;
            }
            return sb + IOUtils.LINE_SEPARATOR_WINDOWS + getMessage();
        }
    }

    public static void a(Object obj) {
        if (f4228c) {
            Log.v("OnewaySdk-", String.valueOf(obj));
        }
    }

    public static void a(String str) {
        if (f4227b) {
            Log.d(f4226a, new a(str).toString());
        }
    }

    public static void a(String str, Throwable th) {
        Log.e(f4226a, str, th);
    }

    public static void a(boolean z) {
        f4227b = z;
    }

    public static void a(Object... objArr) {
        if (f4227b) {
            Log.v(f4226a, new a(s.a(objArr)).toString());
        }
    }

    public static boolean a() {
        return f4227b;
    }

    public static void b(String str) {
        if (f4227b) {
            Log.i(f4226a, new a(str).toString());
        }
    }

    public static void b(boolean z) {
        f4228c = z;
    }

    public static boolean b() {
        return f4228c;
    }

    public static void c(String str) {
        String str2;
        if (!f4227b) {
            str2 = f4226a;
        } else {
            str2 = f4226a;
            str = new a(str).toString();
        }
        Log.w(str2, str);
    }

    public static void d(String str) {
        Log.e(f4226a, new a(str).toString());
    }
}
