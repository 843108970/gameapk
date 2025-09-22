package com.b.b;

import android.support.v4.media.session.PlaybackStateCompat;
import com.umeng.commonsdk.amap.UMAmapConfig;
import com.umeng.commonsdk.proguard.bg;
import java.io.EOFException;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;

public final class f implements g, h, Cloneable {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f853c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a  reason: collision with root package name */
    t f854a;

    /* renamed from: b  reason: collision with root package name */
    long f855b;

    private String a(long j, Charset charset) {
        aa.a(this.f855b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            t tVar = this.f854a;
            if (((long) tVar.f880b) + j > ((long) tVar.f881c)) {
                return new String(e(j), charset);
            }
            String str = new String(tVar.f879a, tVar.f880b, (int) j, charset);
            tVar.f880b = (int) (((long) tVar.f880b) + j);
            this.f855b -= j;
            if (tVar.f880b == tVar.f881c) {
                this.f854a = tVar.a();
                u.a(tVar);
            }
            return str;
        }
    }

    private void c(byte[] bArr) {
        int i;
        int i2 = 0;
        while (i2 < bArr.length) {
            int length = bArr.length - i2;
            aa.a((long) bArr.length, (long) i2, (long) length);
            t tVar = this.f854a;
            if (tVar == null) {
                i = -1;
            } else {
                i = Math.min(length, tVar.f881c - tVar.f880b);
                System.arraycopy(tVar.f879a, tVar.f880b, bArr, i2, i);
                tVar.f880b += i;
                this.f855b -= (long) i;
                if (tVar.f880b == tVar.f881c) {
                    this.f854a = tVar.a();
                    u.a(tVar);
                }
            }
            if (i == -1) {
                throw new EOFException();
            }
            i2 += i;
        }
    }

    private String k(long j) {
        return a(j, aa.f846a);
    }

    public final long a(byte b2) {
        return a(b2, 0);
    }

    public final long a(byte b2, long j) {
        long j2;
        long j3 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        t tVar = this.f854a;
        if (tVar == null) {
            return -1;
        }
        if (this.f855b - j >= j) {
            while (true) {
                long j4 = j2 + ((long) (tVar.f881c - tVar.f880b));
                if (j4 >= j) {
                    break;
                }
                tVar = tVar.f;
                j3 = j4;
            }
        } else {
            j2 = this.f855b;
            while (j2 > j) {
                tVar = tVar.g;
                j2 -= (long) (tVar.f881c - tVar.f880b);
            }
        }
        while (j2 < this.f855b) {
            byte[] bArr = tVar.f879a;
            int i = tVar.f881c;
            for (int i2 = (int) ((((long) tVar.f880b) + j) - j2); i2 < i; i2++) {
                if (bArr[i2] == b2) {
                    return ((long) (i2 - tVar.f880b)) + j2;
                }
            }
            tVar = tVar.f;
            j = j2 + ((long) (tVar.f881c - tVar.f880b));
            j2 = j;
        }
        return -1;
    }

    public final long a(f fVar, long j) {
        if (fVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f855b == 0) {
            return -1;
        } else {
            if (j > this.f855b) {
                j = this.f855b;
            }
            fVar.a_(this, j);
            return j;
        }
    }

    public final long a(x xVar) {
        if (xVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long a2 = xVar.a(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (a2 == -1) {
                return j;
            }
            j += a2;
        }
    }

    public final f a(int i) {
        int i2;
        int i3;
        if (i >= 128) {
            if (i < 2048) {
                i3 = (i >> 6) | 192;
            } else {
                if (i < 65536) {
                    if (i < 55296 || i > 57343) {
                        i2 = (i >> 12) | 224;
                    } else {
                        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
                    }
                } else if (i <= 1114111) {
                    h((i >> 18) | 240);
                    i2 = ((i >> 12) & 63) | 128;
                } else {
                    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
                }
                h(i2);
                i3 = ((i >> 6) & 63) | 128;
            }
            h(i3);
            i = (i & 63) | 128;
        }
        h(i);
        return this;
    }

    public final f a(f fVar, long j, long j2) {
        if (fVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        aa.a(this.f855b, j, j2);
        if (j2 == 0) {
            return this;
        }
        fVar.f855b += j2;
        t tVar = this.f854a;
        while (j >= ((long) (tVar.f881c - tVar.f880b))) {
            tVar = tVar.f;
            j -= (long) (tVar.f881c - tVar.f880b);
        }
        while (j2 > 0) {
            t tVar2 = new t(tVar);
            tVar2.f880b = (int) (((long) tVar2.f880b) + j);
            tVar2.f881c = Math.min(tVar2.f880b + ((int) j2), tVar2.f881c);
            if (fVar.f854a == null) {
                tVar2.g = tVar2;
                tVar2.f = tVar2;
                fVar.f854a = tVar2;
            } else {
                fVar.f854a.g.a(tVar2);
            }
            long j3 = j2 - ((long) (tVar2.f881c - tVar2.f880b));
            tVar = tVar.f;
            j = 0;
            j2 = j3;
        }
        return this;
    }

    public final f a(i iVar) {
        if (iVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        iVar.a(this);
        return this;
    }

    /* renamed from: a */
    public final f b(String str) {
        return a(str, 0, str.length());
    }

    public final f a(String str, int i, int i2) {
        int i3;
        char charAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else {
            while (i < i2) {
                char charAt2 = str.charAt(i);
                if (charAt2 < 128) {
                    t e = e(1);
                    byte[] bArr = e.f879a;
                    int i4 = e.f881c - i;
                    int min = Math.min(i2, 8192 - i4);
                    int i5 = i + 1;
                    bArr[i + i4] = (byte) charAt2;
                    while (true) {
                        i = i5;
                        if (i >= min || (charAt = str.charAt(i)) >= 128) {
                            int i6 = (i4 + i) - e.f881c;
                            e.f881c += i6;
                            this.f855b += (long) i6;
                        } else {
                            i5 = i + 1;
                            bArr[i + i4] = (byte) charAt;
                        }
                    }
                    int i62 = (i4 + i) - e.f881c;
                    e.f881c += i62;
                    this.f855b += (long) i62;
                } else {
                    if (charAt2 < 2048) {
                        i3 = (charAt2 >> 6) | 192;
                    } else if (charAt2 < 55296 || charAt2 > 57343) {
                        h((charAt2 >> 12) | 224);
                        i3 = ((charAt2 >> 6) & 63) | 128;
                    } else {
                        int i7 = i + 1;
                        char charAt3 = i7 < i2 ? str.charAt(i7) : 0;
                        if (charAt2 > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            h(63);
                            i = i7;
                        } else {
                            int i8 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + IOUtils.DIR_SEPARATOR;
                            h((i8 >> 18) | 240);
                            h(((i8 >> 12) & 63) | 128);
                            h(((i8 >> 6) & 63) | 128);
                            h((i8 & 63) | 128);
                            i += 2;
                        }
                    }
                    h(i3);
                    h((int) (charAt2 & '?') | 128);
                    i++;
                }
            }
            return this;
        }
    }

    /* renamed from: a */
    public final f b(byte[] bArr) {
        if (bArr != null) {
            return b(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public final f b(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = (long) i2;
        aa.a((long) bArr.length, (long) i, j);
        int i3 = i2 + i;
        while (i < i3) {
            t e = e(1);
            int min = Math.min(i3 - i, 8192 - e.f881c);
            System.arraycopy(bArr, i, e.f879a, e.f881c, min);
            i += min;
            e.f881c += min;
        }
        this.f855b += j;
        return this;
    }

    public final y a() {
        return y.f884b;
    }

    public final String a(Charset charset) {
        try {
            return a(this.f855b, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final void a(long j) {
        if (this.f855b < j) {
            throw new EOFException();
        }
    }

    public final void a_(f fVar, long j) {
        t tVar;
        if (fVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (fVar == this) {
            throw new IllegalArgumentException("source == this");
        } else {
            aa.a(fVar.f855b, 0, j);
            while (j > 0) {
                int i = 0;
                if (j < ((long) (fVar.f854a.f881c - fVar.f854a.f880b))) {
                    t tVar2 = this.f854a != null ? this.f854a.g : null;
                    if (tVar2 != null && tVar2.e) {
                        if ((j + ((long) tVar2.f881c)) - ((long) (tVar2.d ? 0 : tVar2.f880b)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            fVar.f854a.a(tVar2, (int) j);
                            fVar.f855b -= j;
                            this.f855b += j;
                            return;
                        }
                    }
                    t tVar3 = fVar.f854a;
                    int i2 = (int) j;
                    if (i2 <= 0 || i2 > tVar3.f881c - tVar3.f880b) {
                        throw new IllegalArgumentException();
                    }
                    if (i2 >= 1024) {
                        tVar = new t(tVar3);
                    } else {
                        tVar = u.a();
                        System.arraycopy(tVar3.f879a, tVar3.f880b, tVar.f879a, 0, i2);
                    }
                    tVar.f881c = tVar.f880b + i2;
                    tVar3.f880b += i2;
                    tVar3.g.a(tVar);
                    fVar.f854a = tVar;
                }
                t tVar4 = fVar.f854a;
                long j2 = (long) (tVar4.f881c - tVar4.f880b);
                fVar.f854a = tVar4.a();
                if (this.f854a == null) {
                    this.f854a = tVar4;
                    t tVar5 = this.f854a;
                    t tVar6 = this.f854a;
                    t tVar7 = this.f854a;
                    tVar6.g = tVar7;
                    tVar5.f = tVar7;
                } else {
                    t a2 = this.f854a.g.a(tVar4);
                    if (a2.g == a2) {
                        throw new IllegalStateException();
                    } else if (a2.g.e) {
                        int i3 = a2.f881c - a2.f880b;
                        int i4 = 8192 - a2.g.f881c;
                        if (!a2.g.d) {
                            i = a2.g.f880b;
                        }
                        if (i3 <= i4 + i) {
                            a2.a(a2.g, i3);
                            a2.a();
                            u.a(a2);
                        }
                    }
                }
                fVar.f855b -= j2;
                this.f855b += j2;
                j -= j2;
            }
        }
    }

    public final byte b(long j) {
        aa.a(this.f855b, j, 1);
        t tVar = this.f854a;
        while (true) {
            long j2 = (long) (tVar.f881c - tVar.f880b);
            if (j < j2) {
                return tVar.f879a[tVar.f880b + ((int) j)];
            }
            tVar = tVar.f;
            j -= j2;
        }
    }

    public final long b() {
        return this.f855b;
    }

    /* renamed from: b */
    public final f h(int i) {
        t e = e(1);
        byte[] bArr = e.f879a;
        int i2 = e.f881c;
        e.f881c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f855b++;
        return this;
    }

    public final boolean b(i iVar) {
        int g = iVar.g();
        if (g < 0 || this.f855b - 0 < ((long) g) || iVar.g() - 0 < g) {
            return false;
        }
        for (int i = 0; i < g; i++) {
            if (b(((long) i) + 0) != iVar.a(i + 0)) {
                return false;
            }
        }
        return true;
    }

    public final f c() {
        return this;
    }

    /* renamed from: c */
    public final f g(int i) {
        t e = e(2);
        byte[] bArr = e.f879a;
        int i2 = e.f881c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        e.f881c = i3 + 1;
        this.f855b += 2;
        return this;
    }

    public final i c(long j) {
        return new i(e(j));
    }

    public final /* synthetic */ Object clone() {
        f fVar = new f();
        if (this.f855b == 0) {
            return fVar;
        }
        fVar.f854a = new t(this.f854a);
        t tVar = fVar.f854a;
        t tVar2 = fVar.f854a;
        t tVar3 = fVar.f854a;
        tVar2.g = tVar3;
        tVar.f = tVar3;
        t tVar4 = this.f854a;
        while (true) {
            tVar4 = tVar4.f;
            if (tVar4 != this.f854a) {
                fVar.f854a.g.a(new t(tVar4));
            } else {
                fVar.f855b = this.f855b;
                return fVar;
            }
        }
    }

    public final void close() {
    }

    /* renamed from: d */
    public final f f(int i) {
        t e = e(4);
        byte[] bArr = e.f879a;
        int i2 = e.f881c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        e.f881c = i5 + 1;
        this.f855b += 4;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final String d(long j) {
        String k;
        long j2 = 1;
        if (j > 0) {
            long j3 = j - 1;
            if (b(j3) == 13) {
                k = k(j3);
                j2 = 2;
                f(j2);
                return k;
            }
        }
        k = k(j);
        f(j2);
        return k;
    }

    public final boolean d() {
        return this.f855b == 0;
    }

    public final byte e() {
        if (this.f855b == 0) {
            throw new IllegalStateException("size == 0");
        }
        t tVar = this.f854a;
        int i = tVar.f880b;
        int i2 = tVar.f881c;
        int i3 = i + 1;
        byte b2 = tVar.f879a[i];
        this.f855b--;
        if (i3 == i2) {
            this.f854a = tVar.a();
            u.a(tVar);
            return b2;
        }
        tVar.f880b = i3;
        return b2;
    }

    /* access modifiers changed from: package-private */
    public final t e(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        } else if (this.f854a == null) {
            this.f854a = u.a();
            t tVar = this.f854a;
            t tVar2 = this.f854a;
            t tVar3 = this.f854a;
            tVar2.g = tVar3;
            tVar.f = tVar3;
            return tVar3;
        } else {
            t tVar4 = this.f854a.g;
            return (tVar4.f881c + i > 8192 || !tVar4.e) ? tVar4.a(u.a()) : tVar4;
        }
    }

    public final byte[] e(long j) {
        aa.a(this.f855b, 0, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[((int) j)];
        c(bArr);
        return bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f855b != fVar.f855b) {
            return false;
        }
        long j = 0;
        if (this.f855b == 0) {
            return true;
        }
        t tVar = this.f854a;
        t tVar2 = fVar.f854a;
        int i = tVar.f880b;
        int i2 = tVar2.f880b;
        while (j < this.f855b) {
            long min = (long) Math.min(tVar.f881c - i, tVar2.f881c - i2);
            int i3 = i2;
            int i4 = i;
            int i5 = 0;
            while (((long) i5) < min) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                if (tVar.f879a[i4] != tVar2.f879a[i3]) {
                    return false;
                }
                i5++;
                i4 = i6;
                i3 = i7;
            }
            if (i4 == tVar.f881c) {
                tVar = tVar.f;
                i = tVar.f880b;
            } else {
                i = i4;
            }
            if (i3 == tVar2.f881c) {
                tVar2 = tVar2.f;
                i2 = tVar2.f880b;
            } else {
                i2 = i3;
            }
            j += min;
        }
        return true;
    }

    public final short f() {
        if (this.f855b < 2) {
            throw new IllegalStateException("size < 2: " + this.f855b);
        }
        t tVar = this.f854a;
        int i = tVar.f880b;
        int i2 = tVar.f881c;
        if (i2 - i < 2) {
            return (short) (((e() & 255) << 8) | (e() & 255));
        }
        byte[] bArr = tVar.f879a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        byte b2 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.f855b -= 2;
        if (i4 == i2) {
            this.f854a = tVar.a();
            u.a(tVar);
        } else {
            tVar.f880b = i4;
        }
        return (short) b2;
    }

    public final void f(long j) {
        while (j > 0) {
            if (this.f854a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, (long) (this.f854a.f881c - this.f854a.f880b));
            long j2 = (long) min;
            this.f855b -= j2;
            long j3 = j - j2;
            this.f854a.f880b += min;
            if (this.f854a.f880b == this.f854a.f881c) {
                t tVar = this.f854a;
                this.f854a = tVar.a();
                u.a(tVar);
            }
            j = j3;
        }
    }

    public final void flush() {
    }

    public final int g() {
        if (this.f855b < 4) {
            throw new IllegalStateException("size < 4: " + this.f855b);
        }
        t tVar = this.f854a;
        int i = tVar.f880b;
        int i2 = tVar.f881c;
        if (i2 - i < 4) {
            return ((e() & 255) << 24) | ((e() & 255) << bg.n) | ((e() & 255) << 8) | (e() & 255);
        }
        byte[] bArr = tVar.f879a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        byte b2 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << bg.n);
        int i5 = i4 + 1;
        byte b3 = b2 | ((bArr[i4] & 255) << 8);
        int i6 = i5 + 1;
        byte b4 = b3 | (bArr[i5] & 255);
        this.f855b -= 4;
        if (i6 == i2) {
            this.f854a = tVar.a();
            u.a(tVar);
            return b4;
        }
        tVar.f880b = i6;
        return b4;
    }

    /* renamed from: g */
    public final f j(long j) {
        if (j == 0) {
            return h(48);
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= UMAmapConfig.AMAP_CACHE_WRITE_TIME) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        t e = e(i);
        byte[] bArr = e.f879a;
        int i2 = e.f881c + i;
        while (j != 0) {
            i2--;
            bArr[i2] = f853c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        e.f881c += i;
        this.f855b += (long) i;
        return this;
    }

    /* renamed from: h */
    public final f i(long j) {
        if (j == 0) {
            return h(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        t e = e(numberOfTrailingZeros);
        byte[] bArr = e.f879a;
        int i = e.f881c;
        for (int i2 = (e.f881c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f853c[(int) (j & 15)];
            j >>>= 4;
        }
        e.f881c += numberOfTrailingZeros;
        this.f855b += (long) numberOfTrailingZeros;
        return this;
    }

    public final short h() {
        return aa.a(f());
    }

    public final int hashCode() {
        t tVar = this.f854a;
        if (tVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = tVar.f881c;
            for (int i3 = tVar.f880b; i3 < i2; i3++) {
                i = (i * 31) + tVar.f879a[i3];
            }
            tVar = tVar.f;
        } while (tVar != this.f854a);
        return i;
    }

    public final int i() {
        return aa.a(g());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0097, code lost:
        if (r9 != r10) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0099, code lost:
        r0.f854a = r7.a();
        com.b.b.u.a(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a3, code lost:
        r7.f880b = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a5, code lost:
        if (r2 != false) goto L_0x00ab;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long j() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.f855b
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0012
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            throw r1
        L_0x0012:
            r1 = 0
            r5 = r3
            r2 = 0
        L_0x0015:
            com.b.b.t r7 = r0.f854a
            byte[] r8 = r7.f879a
            int r9 = r7.f880b
            int r10 = r7.f881c
        L_0x001d:
            if (r9 >= r10) goto L_0x0097
            byte r11 = r8[r9]
            r12 = 48
            if (r11 < r12) goto L_0x002c
            r12 = 57
            if (r11 > r12) goto L_0x002c
            int r12 = r11 + -48
            goto L_0x0044
        L_0x002c:
            r12 = 97
            if (r11 < r12) goto L_0x0039
            r12 = 102(0x66, float:1.43E-43)
            if (r11 > r12) goto L_0x0039
            int r12 = r11 + -97
        L_0x0036:
            int r12 = r12 + 10
            goto L_0x0044
        L_0x0039:
            r12 = 65
            if (r11 < r12) goto L_0x007c
            r12 = 70
            if (r11 > r12) goto L_0x007c
            int r12 = r11 + -65
            goto L_0x0036
        L_0x0044:
            r13 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r15 = r5 & r13
            int r13 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            if (r13 == 0) goto L_0x0071
            com.b.b.f r1 = new com.b.b.f
            r1.<init>()
            com.b.b.f r1 = r1.i((long) r5)
            com.b.b.f r1 = r1.h((int) r11)
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Number too large: "
            r3.<init>(r4)
            java.lang.String r1 = r1.l()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x0071:
            r11 = 4
            long r5 = r5 << r11
            long r11 = (long) r12
            long r13 = r5 | r11
            int r9 = r9 + 1
            int r1 = r1 + 1
            r5 = r13
            goto L_0x001d
        L_0x007c:
            if (r1 != 0) goto L_0x0096
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Expected leading [0-9a-fA-F] character but was 0x"
            r2.<init>(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r11)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0096:
            r2 = 1
        L_0x0097:
            if (r9 != r10) goto L_0x00a3
            com.b.b.t r8 = r7.a()
            r0.f854a = r8
            com.b.b.u.a(r7)
            goto L_0x00a5
        L_0x00a3:
            r7.f880b = r9
        L_0x00a5:
            if (r2 != 0) goto L_0x00ab
            com.b.b.t r7 = r0.f854a
            if (r7 != 0) goto L_0x0015
        L_0x00ab:
            long r2 = r0.f855b
            long r7 = (long) r1
            long r9 = r2 - r7
            r0.f855b = r9
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.b.f.j():long");
    }

    public final i k() {
        return new i(n());
    }

    public final String l() {
        try {
            return a(this.f855b, aa.f846a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final String m() {
        long a2 = a((byte) 10, 0);
        if (a2 != -1) {
            return d(a2);
        }
        f fVar = new f();
        a(fVar, 0, Math.min(32, this.f855b));
        throw new EOFException("\\n not found: size=" + this.f855b + " content=" + fVar.k().e() + "…");
    }

    public final byte[] n() {
        try {
            return e(this.f855b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final void o() {
        try {
            f(this.f855b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final /* bridge */ /* synthetic */ g p() {
        return this;
    }

    public final String toString() {
        if (this.f855b > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f855b);
        }
        int i = (int) this.f855b;
        return (i == 0 ? i.f857b : new v(this, i)).toString();
    }
}
