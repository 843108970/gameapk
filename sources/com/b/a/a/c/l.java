package com.b.a.a.c;

import com.b.a.al;
import java.net.ProtocolException;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final al f620a;

    /* renamed from: b  reason: collision with root package name */
    public final int f621b;

    /* renamed from: c  reason: collision with root package name */
    public final String f622c;

    private l(al alVar, int i, String str) {
        this.f620a = alVar;
        this.f621b = i;
        this.f622c = str;
    }

    public static l a(String str) {
        al alVar;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                alVar = al.HTTP_1_0;
            } else if (charAt == 1) {
                alVar = al.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            alVar = al.HTTP_1_0;
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
            return new l(alVar, parseInt, str2);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f620a == al.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f621b);
        if (this.f622c != null) {
            sb.append(' ');
            sb.append(this.f622c);
        }
        return sb.toString();
    }
}
