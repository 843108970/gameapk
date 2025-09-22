package b.b;

import b.a.h.e;
import b.aa;
import b.ac;
import b.ad;
import b.ae;
import b.af;
import b.j;
import b.u;
import b.w;
import b.x;
import c.c;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.concurrent.TimeUnit;

public final class a implements w {

    /* renamed from: a  reason: collision with root package name */
    private static final Charset f276a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    private final b f277b;

    /* renamed from: c  reason: collision with root package name */
    private volatile int f278c;

    /* renamed from: b.b.a$a  reason: collision with other inner class name */
    public enum C0003a {
        ;
        
        public static final int BASIC$2dc28571 = 2;
        public static final int BODY$2dc28571 = 4;
        public static final int HEADERS$2dc28571 = 3;
        public static final int NONE$2dc28571 = 1;

        static {
            $VALUES$fd1e174 = new int[]{NONE$2dc28571, BASIC$2dc28571, HEADERS$2dc28571, BODY$2dc28571};
        }

        public static int[] values$1f221b6b() {
            return (int[]) $VALUES$fd1e174.clone();
        }
    }

    public interface b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f279a = new b() {
            public final void a(String str) {
                e.b().a(4, str, (Throwable) null);
            }
        };

        void a(String str);
    }

    public a() {
        this(b.f279a);
    }

    private a(b bVar) {
        this.f278c = C0003a.NONE$2dc28571;
        this.f277b = bVar;
    }

    private int a() {
        return this.f278c;
    }

    private a a(int i) {
        if (i == 0) {
            throw new NullPointerException("level == null. Use Level.NONE instead.");
        }
        this.f278c = i;
        return this;
    }

    private static boolean a(u uVar) {
        String a2 = uVar.a("Content-Encoding");
        return a2 != null && !a2.equalsIgnoreCase("identity");
    }

    private static boolean a(c cVar) {
        try {
            c cVar2 = new c();
            cVar.a(cVar2, 0, cVar.f387c < 64 ? cVar.f387c : 64);
            for (int i = 0; i < 16 && !cVar2.d(); i++) {
                int u = cVar2.u();
                if (Character.isISOControl(u) && !Character.isWhitespace(u)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public final ae intercept(w.a aVar) throws IOException {
        String str;
        String str2;
        String str3;
        b bVar;
        String str4;
        StringBuilder sb;
        b bVar2;
        w.a aVar2 = aVar;
        int i = this.f278c;
        ac a2 = aVar.a();
        if (i == C0003a.NONE$2dc28571) {
            return aVar2.a(a2);
        }
        boolean z = true;
        boolean z2 = i == C0003a.BODY$2dc28571;
        boolean z3 = z2 || i == C0003a.HEADERS$2dc28571;
        ad adVar = a2.d;
        if (adVar == null) {
            z = false;
        }
        j b2 = aVar.b();
        String str5 = "--> " + a2.f248b + ' ' + a2.f247a + ' ' + (b2 != null ? b2.d() : aa.HTTP_1_1);
        if (!z3 && z) {
            str5 = str5 + " (" + adVar.contentLength() + "-byte body)";
        }
        this.f277b.a(str5);
        if (z3) {
            if (z) {
                if (adVar.contentType() != null) {
                    this.f277b.a("Content-Type: " + adVar.contentType());
                }
                if (adVar.contentLength() != -1) {
                    this.f277b.a("Content-Length: " + adVar.contentLength());
                }
            }
            u uVar = a2.f249c;
            int length = uVar.f350a.length / 2;
            for (int i2 = 0; i2 < length; i2++) {
                String a3 = uVar.a(i2);
                if (!"Content-Type".equalsIgnoreCase(a3) && !"Content-Length".equalsIgnoreCase(a3)) {
                    this.f277b.a(a3 + ": " + uVar.b(i2));
                }
            }
            if (!z2 || !z) {
                bVar2 = this.f277b;
                sb = new StringBuilder("--> END ");
                str4 = a2.f248b;
            } else if (a(a2.f249c)) {
                bVar2 = this.f277b;
                sb = new StringBuilder("--> END ");
                sb.append(a2.f248b);
                str4 = " (encoded body omitted)";
            } else {
                c cVar = new c();
                adVar.writeTo(cVar);
                Charset charset = f276a;
                x contentType = adVar.contentType();
                if (contentType != null) {
                    charset = contentType.a(f276a);
                }
                this.f277b.a("");
                if (a(cVar)) {
                    this.f277b.a(cVar.a(charset));
                    bVar2 = this.f277b;
                    sb = new StringBuilder("--> END ");
                    sb.append(a2.f248b);
                    sb.append(" (");
                    sb.append(adVar.contentLength());
                    str4 = "-byte body)";
                } else {
                    bVar2 = this.f277b;
                    sb = new StringBuilder("--> END ");
                    sb.append(a2.f248b);
                    sb.append(" (binary ");
                    sb.append(adVar.contentLength());
                    str4 = "-byte body omitted)";
                }
            }
            sb.append(str4);
            bVar2.a(sb.toString());
        }
        long nanoTime = System.nanoTime();
        try {
            ae a4 = aVar2.a(a2);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            af afVar = a4.g;
            long contentLength = afVar.contentLength();
            if (contentLength != -1) {
                str = contentLength + "-byte";
            } else {
                str = "unknown-length";
            }
            b bVar3 = this.f277b;
            StringBuilder sb2 = new StringBuilder("<-- ");
            sb2.append(a4.f262c);
            sb2.append(' ');
            sb2.append(a4.d);
            sb2.append(' ');
            sb2.append(a4.f260a.f247a);
            sb2.append(" (");
            sb2.append(millis);
            sb2.append("ms");
            if (!z3) {
                str2 = ", " + str + " body";
            } else {
                str2 = "";
            }
            sb2.append(str2);
            sb2.append(')');
            bVar3.a(sb2.toString());
            if (z3) {
                u uVar2 = a4.f;
                int length2 = uVar2.f350a.length / 2;
                for (int i3 = 0; i3 < length2; i3++) {
                    this.f277b.a(uVar2.a(i3) + ": " + uVar2.b(i3));
                }
                if (!z2 || !b.a.d.e.d(a4)) {
                    bVar = this.f277b;
                    str3 = "<-- END HTTP";
                } else if (a(a4.f)) {
                    bVar = this.f277b;
                    str3 = "<-- END HTTP (encoded body omitted)";
                } else {
                    c.e source = afVar.source();
                    source.b(Long.MAX_VALUE);
                    c a5 = source.a();
                    Charset charset2 = f276a;
                    x contentType2 = afVar.contentType();
                    if (contentType2 != null) {
                        try {
                            charset2 = contentType2.a(f276a);
                        } catch (UnsupportedCharsetException unused) {
                            this.f277b.a("");
                            this.f277b.a("Couldn't decode the response body; charset is likely malformed.");
                            this.f277b.a("<-- END HTTP");
                            return a4;
                        }
                    }
                    if (!a(a5)) {
                        this.f277b.a("");
                        this.f277b.a("<-- END HTTP (binary " + a5.f387c + "-byte body omitted)");
                        return a4;
                    }
                    if (contentLength != 0) {
                        this.f277b.a("");
                        this.f277b.a(a5.clone().a(charset2));
                    }
                    this.f277b.a("<-- END HTTP (" + a5.f387c + "-byte body)");
                    return a4;
                }
                bVar.a(str3);
            }
            return a4;
        } catch (Exception e) {
            this.f277b.a("<-- HTTP FAILED: " + e);
            throw e;
        }
    }
}
