package com.b.a.a;

import android.support.v4.media.session.PlaybackStateCompat;
import com.b.a.ac;
import com.b.a.aq;
import com.b.a.au;
import com.b.b.f;
import com.b.b.h;
import com.b.b.i;
import com.b.b.x;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Array;
import java.net.IDN;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f603a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f604b = new String[0];

    /* renamed from: c  reason: collision with root package name */
    public static final au f605c = au.a(f603a);
    public static final aq d = aq.a(f603a);
    public static final Charset e = Charset.forName("UTF-8");
    public static final TimeZone f = TimeZone.getTimeZone("GMT");
    private static final i g = i.b("efbbbf");
    private static final i h = i.b("feff");
    private static final i i = i.b("fffe");
    private static final i j = i.b("0000ffff");
    private static final i k = i.b("ffff0000");
    private static final Charset l = Charset.forName("UTF-16BE");
    private static final Charset m = Charset.forName("UTF-16LE");
    private static final Charset n = Charset.forName("UTF-32BE");
    private static final Charset o = Charset.forName("UTF-32LE");
    private static final Pattern p = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

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

    public static <T> int a(T[] tArr, T t) {
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (a((Object) tArr[i2], (Object) t)) {
                return i2;
            }
        }
        return -1;
    }

    public static String a(ac acVar, boolean z) {
        String str;
        if (acVar.f().contains(":")) {
            str = "[" + acVar.f() + "]";
        } else {
            str = acVar.f();
        }
        if (!z && acVar.g() == ac.a(acVar.b())) {
            return str;
        }
        return str + ":" + acVar.g();
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

    public static Charset a(h hVar, Charset charset) {
        if (hVar.b(g)) {
            hVar.f((long) g.g());
            return e;
        } else if (hVar.b(h)) {
            hVar.f((long) h.g());
            return l;
        } else if (hVar.b(i)) {
            hVar.f((long) i.g());
            return m;
        } else if (hVar.b(j)) {
            hVar.f((long) j.g());
            return n;
        } else if (!hVar.b(k)) {
            return charset;
        } else {
            hVar.f((long) k.g());
            return o;
        }
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory a(String str, boolean z) {
        return new d(str, z);
    }

    public static void a(long j2, long j3) {
        if ((j3 | 0) < 0 || 0 > j2 || j2 - 0 < j3) {
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

    public static boolean a(x xVar, int i2, TimeUnit timeUnit) {
        long nanoTime = System.nanoTime();
        long d2 = xVar.a().c_() ? xVar.a().d() - nanoTime : Long.MAX_VALUE;
        xVar.a().a(nanoTime + Math.min(d2, timeUnit.toNanos((long) i2)));
        try {
            f fVar = new f();
            while (xVar.a(fVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                fVar.o();
            }
            if (d2 == Long.MAX_VALUE) {
                xVar.a().e_();
                return true;
            }
            xVar.a().a(nanoTime + d2);
            return true;
        } catch (InterruptedIOException unused) {
            if (d2 == Long.MAX_VALUE) {
                xVar.a().e_();
                return false;
            }
            xVar.a().a(nanoTime + d2);
            return false;
        } catch (Throwable th) {
            if (d2 == Long.MAX_VALUE) {
                xVar.a().e_();
            } else {
                xVar.a().a(nanoTime + d2);
            }
            throw th;
        }
    }

    public static boolean a(x xVar, TimeUnit timeUnit) {
        try {
            return a(xVar, 100, timeUnit);
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

    public static <T> T[] a(Class<T> cls, T[] tArr, T[] tArr2) {
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            int length = tArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                T t2 = tArr2[i2];
                if (t.equals(t2)) {
                    arrayList.add(t2);
                    break;
                }
                i2++;
            }
        }
        return arrayList.toArray((Object[]) Array.newInstance(cls, arrayList.size()));
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

    public static String c(String str, int i2, int i3) {
        int a2 = a(str, i2, i3);
        return str.substring(a2, b(str, a2, i3));
    }

    public static boolean c(String str) {
        return p.matcher(str).matches();
    }
}
