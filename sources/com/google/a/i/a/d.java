package com.google.a.i.a;

import com.google.a.c.c;
import com.google.a.c.e;
import com.google.a.c.l;
import com.google.a.h;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f3300a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    private static final int f3301b = 1;

    private d() {
    }

    private static char a(int i) throws h {
        if (i < f3300a.length) {
            return f3300a[i];
        }
        throw h.getFormatInstance();
    }

    private static int a(c cVar) throws h {
        int a2 = cVar.a(8);
        if ((a2 & 128) == 0) {
            return a2 & 127;
        }
        if ((a2 & 192) == 128) {
            return cVar.a(8) | ((a2 & 63) << 8);
        }
        if ((a2 & 224) == 192) {
            return cVar.a(16) | ((a2 & 31) << 16);
        }
        throw h.getFormatInstance();
    }

    static e a(byte[] bArr, j jVar, f fVar, Map<com.google.a.e, ?> map) throws h {
        h hVar;
        int i;
        int a2;
        int i2;
        j jVar2 = jVar;
        byte[] bArr2 = bArr;
        c cVar = new c(bArr2);
        StringBuilder sb = new StringBuilder(50);
        int i3 = 1;
        ArrayList arrayList = new ArrayList(1);
        com.google.a.c.d dVar = null;
        boolean z = false;
        int i4 = -1;
        int i5 = -1;
        while (true) {
            try {
                h forBits = cVar.a() < 4 ? h.TERMINATOR : h.forBits(cVar.a(4));
                switch (forBits) {
                    case TERMINATOR:
                        break;
                    case FNC1_FIRST_POSITION:
                    case FNC1_SECOND_POSITION:
                        hVar = forBits;
                        z = true;
                        break;
                    case STRUCTURED_APPEND:
                        if (cVar.a() >= 16) {
                            i4 = cVar.a(8);
                            i5 = cVar.a(8);
                            break;
                        } else {
                            throw h.getFormatInstance();
                        }
                    case ECI:
                        int a3 = cVar.a(8);
                        if ((a3 & 128) == 0) {
                            i = a3 & 127;
                        } else {
                            if ((a3 & 192) == 128) {
                                a2 = cVar.a(8);
                                i2 = (a3 & 63) << 8;
                            } else if ((a3 & 224) == 192) {
                                a2 = cVar.a(16);
                                i2 = (a3 & 31) << 16;
                            } else {
                                throw h.getFormatInstance();
                            }
                            i = i2 | a2;
                        }
                        dVar = com.google.a.c.d.getCharacterSetECIByValue(i);
                        if (dVar == null) {
                            throw h.getFormatInstance();
                        }
                        break;
                    case HANZI:
                        int a4 = cVar.a(4);
                        int a5 = cVar.a(forBits.getCharacterCountBits(jVar2));
                        if (a4 == i3) {
                            a(cVar, sb, a5);
                            break;
                        }
                        break;
                    default:
                        int a6 = cVar.a(forBits.getCharacterCountBits(jVar2));
                        switch (forBits) {
                            case NUMERIC:
                                hVar = forBits;
                                c(cVar, sb, a6);
                                break;
                            case ALPHANUMERIC:
                                hVar = forBits;
                                a(cVar, sb, a6, z);
                                break;
                            case BYTE:
                                hVar = forBits;
                                a(cVar, sb, a6, dVar, arrayList, map);
                                break;
                            case KANJI:
                                b(cVar, sb, a6);
                                break;
                            default:
                                throw h.getFormatInstance();
                        }
                }
                hVar = forBits;
                if (hVar == h.TERMINATOR) {
                    return new e(bArr2, sb.toString(), arrayList.isEmpty() ? null : arrayList, fVar == null ? null : fVar.toString(), i4, i5);
                }
                i3 = 1;
            } catch (IllegalArgumentException unused) {
                throw h.getFormatInstance();
            }
        }
    }

    private static void a(c cVar, StringBuilder sb, int i) throws h {
        if (i * 13 > cVar.a()) {
            throw h.getFormatInstance();
        }
        byte[] bArr = new byte[(i * 2)];
        int i2 = 0;
        while (i > 0) {
            int a2 = cVar.a(13);
            int i3 = (a2 % 96) | ((a2 / 96) << 8);
            int i4 = i3 + (i3 < 959 ? 41377 : 42657);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i2 += 2;
            i--;
        }
        try {
            sb.append(new String(bArr, l.f3087b));
        } catch (UnsupportedEncodingException unused) {
            throw h.getFormatInstance();
        }
    }

    private static void a(c cVar, StringBuilder sb, int i, com.google.a.c.d dVar, Collection<byte[]> collection, Map<com.google.a.e, ?> map) throws h {
        if ((i << 3) > cVar.a()) {
            throw h.getFormatInstance();
        }
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) cVar.a(8);
        }
        try {
            sb.append(new String(bArr, dVar == null ? l.a(bArr, map) : dVar.name()));
            collection.add(bArr);
        } catch (UnsupportedEncodingException unused) {
            throw h.getFormatInstance();
        }
    }

    private static void a(c cVar, StringBuilder sb, int i, boolean z) throws h {
        while (i > 1) {
            if (cVar.a() < 11) {
                throw h.getFormatInstance();
            }
            int a2 = cVar.a(11);
            sb.append(a(a2 / 45));
            sb.append(a(a2 % 45));
            i -= 2;
        }
        if (i == 1) {
            if (cVar.a() < 6) {
                throw h.getFormatInstance();
            }
            sb.append(a(cVar.a(6)));
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i2 = length + 1;
                        if (sb.charAt(i2) == '%') {
                            sb.deleteCharAt(i2);
                        }
                    }
                    sb.setCharAt(length, 29);
                }
            }
        }
    }

    private static void b(c cVar, StringBuilder sb, int i) throws h {
        if (i * 13 > cVar.a()) {
            throw h.getFormatInstance();
        }
        byte[] bArr = new byte[(i * 2)];
        int i2 = 0;
        while (i > 0) {
            int a2 = cVar.a(13);
            int i3 = (a2 % 192) | ((a2 / 192) << 8);
            int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i2 += 2;
            i--;
        }
        try {
            sb.append(new String(bArr, l.f3086a));
        } catch (UnsupportedEncodingException unused) {
            throw h.getFormatInstance();
        }
    }

    private static void c(c cVar, StringBuilder sb, int i) throws h {
        while (i >= 3) {
            if (cVar.a() < 10) {
                throw h.getFormatInstance();
            }
            int a2 = cVar.a(10);
            if (a2 >= 1000) {
                throw h.getFormatInstance();
            }
            sb.append(a(a2 / 100));
            sb.append(a((a2 / 10) % 10));
            sb.append(a(a2 % 10));
            i -= 3;
        }
        if (i == 2) {
            if (cVar.a() < 7) {
                throw h.getFormatInstance();
            }
            int a3 = cVar.a(7);
            if (a3 >= 100) {
                throw h.getFormatInstance();
            }
            sb.append(a(a3 / 10));
            sb.append(a(a3 % 10));
        } else if (i != 1) {
        } else {
            if (cVar.a() < 4) {
                throw h.getFormatInstance();
            }
            int a4 = cVar.a(4);
            if (a4 >= 10) {
                throw h.getFormatInstance();
            }
            sb.append(a(a4));
        }
    }
}
