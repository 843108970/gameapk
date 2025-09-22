package b.a.d;

import b.aa;
import b.ae;
import java.io.IOException;
import java.net.ProtocolException;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final int f90a = 307;

    /* renamed from: b  reason: collision with root package name */
    public static final int f91b = 308;

    /* renamed from: c  reason: collision with root package name */
    public static final int f92c = 100;
    public final aa d;
    public final int e;
    public final String f;

    public k(aa aaVar, int i, String str) {
        this.d = aaVar;
        this.e = i;
        this.f = str;
    }

    private static k a(ae aeVar) {
        return new k(aeVar.f261b, aeVar.f262c, aeVar.d);
    }

    public static k a(String str) throws IOException {
        aa aaVar;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                aaVar = aa.HTTP_1_0;
            } else if (charAt == 1) {
                aaVar = aa.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            aaVar = aa.HTTP_1_0;
            i = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        int i2 = i + 3;
        if (str.length() < i2) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int parseInt = Integer.parseInt(str.substring(i, i2));
            String str2 = "";
            if (str.length() > i2) {
                if (str.charAt(i2) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                str2 = str.substring(i + 4);
            }
            return new k(aaVar, parseInt, str2);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.d == aa.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.e);
        if (this.f != null) {
            sb.append(' ');
            sb.append(this.f);
        }
        return sb.toString();
    }
}
