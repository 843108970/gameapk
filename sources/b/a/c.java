package b.a;

import android.support.v4.media.session.PlaybackStateCompat;
import b.ad;
import b.af;
import b.v;
import b.x;
import c.e;
import c.f;
import c.y;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f51a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f52b = new String[0];

    /* renamed from: c  reason: collision with root package name */
    public static final af f53c = af.create((x) null, f51a);
    public static final ad d = ad.create((x) null, f51a);
    public static final Charset e = Charset.forName("UTF-8");
    public static final TimeZone f = TimeZone.getTimeZone("GMT");
    public static final Comparator<String> g = new Comparator<String>() {
        private static int a(String str, String str2) {
            return str.compareTo(str2);
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((String) obj).compareTo((String) obj2);
        }
    };
    private static final f h = f.decodeHex("efbbbf");
    private static final f i = f.decodeHex("feff");
    private static final f j = f.decodeHex("fffe");
    private static final f k = f.decodeHex("0000ffff");
    private static final f l = f.decodeHex("ffff0000");
    private static final Charset m = Charset.forName("UTF-16BE");
    private static final Charset n = Charset.forName("UTF-16LE");
    private static final Charset o = Charset.forName("UTF-32BE");
    private static final Charset p = Charset.forName("UTF-32LE");
    private static final Pattern q = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private c() {
    }

    public static int a(String str, int i2, int i3) {
        while (i2 < i3) {
            switch (str.charAt(i2)) {
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    i2++;
                default:
                    return i2;
            }
        }
        return i3;
    }

    public static int a(String str, int i2, int i3, char c2) {
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int a(String str, int i2, int i3, String str2) {
        while (i2 < i3) {
            if (str2.indexOf(str.charAt(i2)) != -1) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], str) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static String a(v vVar, boolean z) {
        String str;
        if (vVar.l.contains(":")) {
            str = "[" + vVar.l + "]";
        } else {
            str = vVar.l;
        }
        if (!z && vVar.m == v.a(vVar.k)) {
            return str;
        }
        return str + ":" + vVar.m;
    }

    public static String a(String str) {
        boolean z;
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            int i2 = 0;
            while (true) {
                z = true;
                if (i2 >= lowerCase.length()) {
                    z = false;
                    break;
                }
                char charAt = lowerCase.charAt(i2);
                if (charAt <= 31) {
                    break;
                } else if (charAt >= 127) {
                    break;
                } else if (" #%/:?@[\\]".indexOf(charAt) != -1) {
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Charset a(e eVar, Charset charset) throws IOException {
        if (eVar.d(h)) {
            eVar.h((long) h.size());
            return e;
        } else if (eVar.d(i)) {
            eVar.h((long) i.size());
            return m;
        } else if (eVar.d(j)) {
            eVar.h((long) j.size());
            return n;
        } else if (eVar.d(k)) {
            eVar.h((long) k.size());
            return o;
        } else if (!eVar.d(l)) {
            return charset;
        } else {
            eVar.h((long) l.size());
            return p;
        }
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory a(final String str, final boolean z) {
        return new ThreadFactory() {
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public static void a(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    private static void a(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!a(e2)) {
                    throw e2;
                }
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(y yVar, int i2, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long c2 = yVar.timeout().m_() ? yVar.timeout().c() - nanoTime : Long.MAX_VALUE;
        yVar.timeout().a(nanoTime + Math.min(c2, timeUnit.toNanos((long) i2)));
        try {
            c.c cVar = new c.c();
            while (yVar.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                cVar.w();
            }
            if (c2 == Long.MAX_VALUE) {
                yVar.timeout().n_();
                return true;
            }
            yVar.timeout().a(nanoTime + c2);
            return true;
        } catch (InterruptedIOException unused) {
            if (c2 == Long.MAX_VALUE) {
                yVar.timeout().n_();
                return false;
            }
            yVar.timeout().a(nanoTime + c2);
            return false;
        } catch (Throwable th) {
            if (c2 == Long.MAX_VALUE) {
                yVar.timeout().n_();
            } else {
                yVar.timeout().a(nanoTime + c2);
            }
            throw th;
        }
    }

    public static boolean a(y yVar, TimeUnit timeUnit) {
        try {
            return a(yVar, 100, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static String[] a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i2]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i2++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] a(String[] strArr, String str) {
        String[] strArr2 = new String[(strArr.length + 1)];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    public static int b(String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int b(String str, int i2, int i3) {
        int i4 = i3 - 1;
        while (i4 >= i2) {
            switch (str.charAt(i4)) {
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    i4--;
                default:
                    return i4 + 1;
            }
        }
        return i2;
    }

    public static boolean b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        for (String str : strArr) {
            for (String compare : strArr2) {
                if (comparator.compare(str, compare) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String c(String str, int i2, int i3) {
        int a2 = a(str, i2, i3);
        return str.substring(a2, b(str, a2, i3));
    }

    public static boolean c(String str) {
        return q.matcher(str).matches();
    }

    private static String d(String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt <= 31 || codePointAt >= 127) {
                c.c cVar = new c.c();
                cVar.b(str, 0, i2);
                while (i2 < length) {
                    int codePointAt2 = str.codePointAt(i2);
                    cVar.m((codePointAt2 <= 31 || codePointAt2 >= 127) ? 63 : codePointAt2);
                    i2 += Character.charCount(codePointAt2);
                }
                return cVar.q();
            }
            i2 += Character.charCount(codePointAt);
        }
        return str;
    }

    private static boolean e(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }
}
