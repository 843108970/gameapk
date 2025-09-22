package c;

import android.support.v4.media.session.PlaybackStateCompat;
import com.umeng.commonsdk.amap.UMAmapConfig;
import com.umeng.commonsdk.proguard.bg;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.io.IOUtils;

public final class c implements d, e, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    static final int f385a = 65533;
    private static final byte[] d = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    u f386b;

    /* renamed from: c  reason: collision with root package name */
    public long f387c;

    private c A() {
        return this;
    }

    private List<Integer> B() {
        if (this.f386b == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(this.f386b.e - this.f386b.d));
        u uVar = this.f386b;
        while (true) {
            uVar = uVar.h;
            if (uVar == this.f386b) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(uVar.e - uVar.d));
        }
    }

    private f C() {
        return c("MD5");
    }

    private f D() {
        return c("SHA-1");
    }

    private f E() {
        return c("SHA-256");
    }

    private f F() {
        return c("SHA-512");
    }

    private f G() {
        if (this.f387c > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f387c);
        }
        int i = (int) this.f387c;
        return i == 0 ? f.EMPTY : new w(this, i);
    }

    private c a(InputStream inputStream) throws IOException {
        a(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    private c a(InputStream inputStream, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        a(inputStream, j, false);
        return this;
    }

    private c a(OutputStream outputStream) throws IOException {
        long j = this.f387c;
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        ab.a(this.f387c, 0, j);
        if (j != 0) {
            u uVar = this.f386b;
            long j2 = 0;
            while (j2 >= ((long) (uVar.e - uVar.d))) {
                uVar = uVar.h;
                j2 -= (long) (uVar.e - uVar.d);
            }
            while (j > 0) {
                int i = (int) (((long) uVar.d) + j2);
                int min = (int) Math.min((long) (uVar.e - i), j);
                outputStream.write(uVar.f432c, i, min);
                uVar = uVar.h;
                j2 = 0;
                j -= (long) min;
            }
        }
        return this;
    }

    private c a(OutputStream outputStream, long j) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        ab.a(this.f387c, 0, j);
        u uVar = this.f386b;
        while (j > 0) {
            int min = (int) Math.min(j, (long) (uVar.e - uVar.d));
            outputStream.write(uVar.f432c, uVar.d, min);
            uVar.d += min;
            long j2 = (long) min;
            this.f387c -= j2;
            long j3 = j - j2;
            if (uVar.d == uVar.e) {
                u a2 = uVar.a();
                this.f386b = a2;
                v.a(uVar);
                uVar = a2;
            }
            j = j3;
        }
        return this;
    }

    private c a(OutputStream outputStream, long j, long j2) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        ab.a(this.f387c, 0, j2);
        if (j2 == 0) {
            return this;
        }
        u uVar = this.f386b;
        while (j >= ((long) (uVar.e - uVar.d))) {
            uVar = uVar.h;
            j -= (long) (uVar.e - uVar.d);
        }
        while (j2 > 0) {
            int i = (int) (((long) uVar.d) + j);
            int min = (int) Math.min((long) (uVar.e - i), j2);
            outputStream.write(uVar.f432c, i, min);
            uVar = uVar.h;
            j = 0;
            j2 -= (long) min;
        }
        return this;
    }

    private f a(String str, f fVar) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(fVar.toByteArray(), str));
            if (this.f386b != null) {
                instance.update(this.f386b.f432c, this.f386b.d, this.f386b.e - this.f386b.d);
                u uVar = this.f386b;
                while (true) {
                    uVar = uVar.h;
                    if (uVar == this.f386b) {
                        break;
                    }
                    instance.update(uVar.f432c, uVar.d, uVar.e - uVar.d);
                }
            }
            return f.of(instance.doFinal());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void a(InputStream inputStream, long j, boolean z) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (true) {
            if (j > 0 || z) {
                u g = g(1);
                int read = inputStream.read(g.f432c, g.e, (int) Math.min(j, (long) (8192 - g.e)));
                if (read != -1) {
                    g.e += read;
                    long j2 = (long) read;
                    this.f387c += j2;
                    j -= j2;
                } else if (!z) {
                    throw new EOFException();
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private static boolean a(u uVar, int i, f fVar, int i2, int i3) {
        int i4 = uVar.e;
        byte[] bArr = uVar.f432c;
        while (i2 < i3) {
            if (i == i4) {
                uVar = uVar.h;
                byte[] bArr2 = uVar.f432c;
                int i5 = uVar.d;
                bArr = bArr2;
                i = i5;
                i4 = uVar.e;
            }
            if (bArr[i] != fVar.getByte(i2)) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    private c b(OutputStream outputStream) throws IOException {
        long j = this.f387c;
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        ab.a(this.f387c, 0, j);
        u uVar = this.f386b;
        while (j > 0) {
            int min = (int) Math.min(j, (long) (uVar.e - uVar.d));
            outputStream.write(uVar.f432c, uVar.d, min);
            uVar.d += min;
            long j2 = (long) min;
            this.f387c -= j2;
            long j3 = j - j2;
            if (uVar.d == uVar.e) {
                u a2 = uVar.a();
                this.f386b = a2;
                v.a(uVar);
                uVar = a2;
            }
            j = j3;
        }
        return this;
    }

    private f c(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            if (this.f386b != null) {
                instance.update(this.f386b.f432c, this.f386b.d, this.f386b.e - this.f386b.d);
                u uVar = this.f386b;
                while (true) {
                    uVar = uVar.h;
                    if (uVar == this.f386b) {
                        break;
                    }
                    instance.update(uVar.f432c, uVar.d, uVar.e - uVar.d);
                }
            }
            return f.of(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private f f(f fVar) {
        return a("HmacSHA1", fVar);
    }

    private f g(f fVar) {
        return a("HmacSHA256", fVar);
    }

    private f h(f fVar) {
        return a("HmacSHA512", fVar);
    }

    private f n(int i) {
        return i == 0 ? f.EMPTY : new w(this, i);
    }

    private long z() {
        return this.f387c;
    }

    public final int a(q qVar) {
        u uVar = this.f386b;
        if (uVar == null) {
            return qVar.indexOf(f.EMPTY);
        }
        f[] fVarArr = qVar.f414a;
        int length = fVarArr.length;
        int i = 0;
        while (i < length) {
            f fVar = fVarArr[i];
            if (this.f387c < ((long) fVar.size()) || !a(uVar, uVar.d, fVar, 0, fVar.size())) {
                i++;
            } else {
                try {
                    h((long) fVar.size());
                    return i;
                } catch (EOFException e) {
                    throw new AssertionError(e);
                }
            }
        }
        return -1;
    }

    public final int a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public final int a(byte[] bArr, int i, int i2) {
        ab.a((long) bArr.length, (long) i, (long) i2);
        u uVar = this.f386b;
        if (uVar == null) {
            return -1;
        }
        int min = Math.min(i2, uVar.e - uVar.d);
        System.arraycopy(uVar.f432c, uVar.d, bArr, i, min);
        uVar.d += min;
        this.f387c -= (long) min;
        if (uVar.d == uVar.e) {
            this.f386b = uVar.a();
            v.a(uVar);
        }
        return min;
    }

    public final long a(byte b2) {
        return a(b2, 0, Long.MAX_VALUE);
    }

    public final long a(byte b2, long j) {
        return a(b2, j, Long.MAX_VALUE);
    }

    public final long a(byte b2, long j, long j2) {
        u uVar;
        long j3;
        long j4 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.f387c), Long.valueOf(j), Long.valueOf(j2)}));
        }
        long j5 = j2 > this.f387c ? this.f387c : j2;
        if (j == j5 || (uVar = this.f386b) == null) {
            return -1;
        }
        if (this.f387c - j >= j) {
            while (true) {
                long j6 = j3 + ((long) (uVar.e - uVar.d));
                if (j6 >= j) {
                    break;
                }
                uVar = uVar.h;
                j4 = j6;
            }
        } else {
            j3 = this.f387c;
            while (j3 > j) {
                uVar = uVar.i;
                j3 -= (long) (uVar.e - uVar.d);
            }
        }
        long j7 = j;
        while (j3 < j5) {
            byte[] bArr = uVar.f432c;
            int min = (int) Math.min((long) uVar.e, (((long) uVar.d) + j5) - j3);
            for (int i = (int) ((((long) uVar.d) + j7) - j3); i < min; i++) {
                if (bArr[i] == b2) {
                    return ((long) (i - uVar.d)) + j3;
                }
            }
            byte b3 = b2;
            uVar = uVar.h;
            j7 = j3 + ((long) (uVar.e - uVar.d));
            j3 = j7;
        }
        return -1;
    }

    public final long a(f fVar, long j) throws IOException {
        long j2;
        f fVar2 = fVar;
        if (fVar.size() == 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long j3 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        u uVar = this.f386b;
        long j4 = -1;
        if (uVar == null) {
            return -1;
        }
        if (this.f387c - j >= j) {
            while (true) {
                long j5 = j2 + ((long) (uVar.e - uVar.d));
                if (j5 >= j) {
                    break;
                }
                uVar = uVar.h;
                j3 = j5;
            }
        } else {
            j2 = this.f387c;
            while (j2 > j) {
                uVar = uVar.i;
                j2 -= (long) (uVar.e - uVar.d);
            }
        }
        byte b2 = fVar2.getByte(0);
        int size = fVar.size();
        long j6 = (this.f387c - ((long) size)) + 1;
        long j7 = j;
        while (j2 < j6) {
            byte[] bArr = uVar.f432c;
            int min = (int) Math.min((long) uVar.e, (((long) uVar.d) + j6) - j2);
            for (int i = (int) ((((long) uVar.d) + j7) - j2); i < min; i++) {
                if (bArr[i] != b2) {
                    f fVar3 = fVar;
                } else if (a(uVar, i + 1, fVar, 1, size)) {
                    return ((long) (i - uVar.d)) + j2;
                }
            }
            j7 = j2 + ((long) (uVar.e - uVar.d));
            uVar = uVar.h;
            j2 = j7;
            f fVar4 = fVar;
            j4 = -1;
        }
        return j4;
    }

    public final long a(x xVar) throws IOException {
        long j = this.f387c;
        if (j > 0) {
            xVar.a(this, j);
        }
        return j;
    }

    public final long a(y yVar) throws IOException {
        if (yVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = yVar.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    public final c a() {
        return this;
    }

    /* renamed from: a */
    public final c m(int i) {
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
                        l(63);
                        return this;
                    }
                } else if (i <= 1114111) {
                    l((i >> 18) | 240);
                    i2 = ((i >> 12) & 63) | 128;
                } else {
                    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
                }
                l(i2);
                i3 = ((i >> 6) & 63) | 128;
            }
            l(i3);
            i = (i & 63) | 128;
        }
        l(i);
        return this;
    }

    public final c a(c cVar, long j, long j2) {
        if (cVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        ab.a(this.f387c, j, j2);
        if (j2 == 0) {
            return this;
        }
        cVar.f387c += j2;
        u uVar = this.f386b;
        while (j >= ((long) (uVar.e - uVar.d))) {
            uVar = uVar.h;
            j -= (long) (uVar.e - uVar.d);
        }
        while (j2 > 0) {
            u uVar2 = new u(uVar);
            uVar2.d = (int) (((long) uVar2.d) + j);
            uVar2.e = Math.min(uVar2.d + ((int) j2), uVar2.e);
            if (cVar.f386b == null) {
                uVar2.i = uVar2;
                uVar2.h = uVar2;
                cVar.f386b = uVar2;
            } else {
                cVar.f386b.i.a(uVar2);
            }
            long j3 = j2 - ((long) (uVar2.e - uVar2.d));
            uVar = uVar.h;
            j = 0;
            j2 = j3;
        }
        return this;
    }

    /* renamed from: a */
    public final c e(f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        fVar.write(this);
        return this;
    }

    /* renamed from: a */
    public final c b(String str) {
        return b(str, 0, str.length());
    }

    /* renamed from: a */
    public final c b(String str, int i, int i2) {
        int i3;
        char charAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else {
            while (i < i2) {
                char charAt2 = str.charAt(i);
                if (charAt2 < 128) {
                    u g = g(1);
                    byte[] bArr = g.f432c;
                    int i4 = g.e - i;
                    int min = Math.min(i2, 8192 - i4);
                    int i5 = i + 1;
                    bArr[i + i4] = (byte) charAt2;
                    while (true) {
                        i = i5;
                        if (i >= min || (charAt = str.charAt(i)) >= 128) {
                            int i6 = (i4 + i) - g.e;
                            g.e += i6;
                            this.f387c += (long) i6;
                        } else {
                            i5 = i + 1;
                            bArr[i + i4] = (byte) charAt;
                        }
                    }
                    int i62 = (i4 + i) - g.e;
                    g.e += i62;
                    this.f387c += (long) i62;
                } else {
                    if (charAt2 < 2048) {
                        i3 = (charAt2 >> 6) | 192;
                    } else if (charAt2 < 55296 || charAt2 > 57343) {
                        l((charAt2 >> 12) | 224);
                        i3 = ((charAt2 >> 6) & 63) | 128;
                    } else {
                        int i7 = i + 1;
                        char charAt3 = i7 < i2 ? str.charAt(i7) : 0;
                        if (charAt2 > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            l(63);
                            i = i7;
                        } else {
                            int i8 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + IOUtils.DIR_SEPARATOR;
                            l((i8 >> 18) | 240);
                            l(((i8 >> 12) & 63) | 128);
                            l(((i8 >> 6) & 63) | 128);
                            l((i8 & 63) | 128);
                            i += 2;
                        }
                    }
                    l(i3);
                    l((int) (charAt2 & '?') | 128);
                    i++;
                }
            }
            return this;
        }
    }

    /* renamed from: a */
    public final c b(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(ab.f382a)) {
            return b(str, i, i2);
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return c(bytes, 0, bytes.length);
        }
    }

    /* renamed from: a */
    public final c b(String str, Charset charset) {
        return b(str, 0, str.length(), charset);
    }

    public final d a(y yVar, long j) throws IOException {
        while (j > 0) {
            long read = yVar.read(this, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
        }
        return this;
    }

    public final String a(long j, Charset charset) throws EOFException {
        ab.a(this.f387c, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            u uVar = this.f386b;
            if (((long) uVar.d) + j > ((long) uVar.e)) {
                return new String(g(j), charset);
            }
            String str = new String(uVar.f432c, uVar.d, (int) j, charset);
            uVar.d = (int) (((long) uVar.d) + j);
            this.f387c -= j;
            if (uVar.d == uVar.e) {
                this.f386b = uVar.a();
                v.a(uVar);
            }
            return str;
        }
    }

    public final String a(Charset charset) {
        try {
            return a(this.f387c, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final void a(long j) throws EOFException {
        if (this.f387c < j) {
            throw new EOFException();
        }
    }

    public final void a(c cVar, long j) {
        u uVar;
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (cVar == this) {
            throw new IllegalArgumentException("source == this");
        } else {
            ab.a(cVar.f387c, 0, j);
            while (j > 0) {
                int i = 0;
                if (j < ((long) (cVar.f386b.e - cVar.f386b.d))) {
                    u uVar2 = this.f386b != null ? this.f386b.i : null;
                    if (uVar2 != null && uVar2.g) {
                        if ((j + ((long) uVar2.e)) - ((long) (uVar2.f ? 0 : uVar2.d)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            cVar.f386b.a(uVar2, (int) j);
                            cVar.f387c -= j;
                            this.f387c += j;
                            return;
                        }
                    }
                    u uVar3 = cVar.f386b;
                    int i2 = (int) j;
                    if (i2 <= 0 || i2 > uVar3.e - uVar3.d) {
                        throw new IllegalArgumentException();
                    }
                    if (i2 >= 1024) {
                        uVar = new u(uVar3);
                    } else {
                        uVar = v.a();
                        System.arraycopy(uVar3.f432c, uVar3.d, uVar.f432c, 0, i2);
                    }
                    uVar.e = uVar.d + i2;
                    uVar3.d += i2;
                    uVar3.i.a(uVar);
                    cVar.f386b = uVar;
                }
                u uVar4 = cVar.f386b;
                long j2 = (long) (uVar4.e - uVar4.d);
                cVar.f386b = uVar4.a();
                if (this.f386b == null) {
                    this.f386b = uVar4;
                    u uVar5 = this.f386b;
                    u uVar6 = this.f386b;
                    u uVar7 = this.f386b;
                    uVar6.i = uVar7;
                    uVar5.h = uVar7;
                } else {
                    u a2 = this.f386b.i.a(uVar4);
                    if (a2.i == a2) {
                        throw new IllegalStateException();
                    } else if (a2.i.g) {
                        int i3 = a2.e - a2.d;
                        int i4 = 8192 - a2.i.e;
                        if (!a2.i.f) {
                            i = a2.i.d;
                        }
                        if (i3 <= i4 + i) {
                            a2.a(a2.i, i3);
                            a2.a();
                            v.a(a2);
                        }
                    }
                }
                cVar.f387c -= j2;
                this.f387c += j2;
                j -= j2;
            }
        }
    }

    public final boolean a(f fVar, int i) {
        if (i < 0 || this.f387c - 0 < ((long) i) || fVar.size() - 0 < i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (c(((long) i2) + 0) != fVar.getByte(i2 + 0)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final int b(q qVar) {
        u uVar = this.f386b;
        f[] fVarArr = qVar.f414a;
        int length = fVarArr.length;
        int i = 0;
        while (i < length) {
            f fVar = fVarArr[i];
            int min = (int) Math.min(this.f387c, (long) fVar.size());
            if (min == 0 || a(uVar, uVar.d, fVar, 0, min)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public final long b(f fVar) throws IOException {
        return a(fVar, 0);
    }

    public final long b(f fVar, long j) {
        long j2;
        int i;
        long j3 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        u uVar = this.f386b;
        if (uVar == null) {
            return -1;
        }
        if (this.f387c - j >= j) {
            while (true) {
                long j4 = j2 + ((long) (uVar.e - uVar.d));
                if (j4 >= j) {
                    break;
                }
                uVar = uVar.h;
                j3 = j4;
            }
        } else {
            j2 = this.f387c;
            while (j2 > j) {
                uVar = uVar.i;
                j2 -= (long) (uVar.e - uVar.d);
            }
        }
        if (fVar.size() == 2) {
            byte b2 = fVar.getByte(0);
            byte b3 = fVar.getByte(1);
            while (j2 < this.f387c) {
                byte[] bArr = uVar.f432c;
                i = (int) ((((long) uVar.d) + j) - j2);
                int i2 = uVar.e;
                while (i < i2) {
                    byte b4 = bArr[i];
                    if (!(b4 == b2 || b4 == b3)) {
                        i++;
                    }
                }
                uVar = uVar.h;
                j = j2 + ((long) (uVar.e - uVar.d));
                j2 = j;
            }
            return -1;
        }
        byte[] internalArray = fVar.internalArray();
        while (j2 < this.f387c) {
            byte[] bArr2 = uVar.f432c;
            int i3 = (int) ((((long) uVar.d) + j) - j2);
            int i4 = uVar.e;
            while (i < i4) {
                byte b5 = bArr2[i];
                int length = internalArray.length;
                int i5 = 0;
                while (i5 < length) {
                    if (b5 != internalArray[i5]) {
                        i5++;
                    }
                }
                i3 = i + 1;
            }
            uVar = uVar.h;
            j = j2 + ((long) (uVar.e - uVar.d));
            j2 = j;
        }
        return -1;
        return ((long) (i - uVar.d)) + j2;
    }

    /* renamed from: b */
    public final c l(int i) {
        u g = g(1);
        byte[] bArr = g.f432c;
        int i2 = g.e;
        g.e = i2 + 1;
        bArr[i2] = (byte) i;
        this.f387c++;
        return this;
    }

    /* renamed from: b */
    public final c c(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = (long) i2;
        ab.a((long) bArr.length, (long) i, j);
        int i3 = i2 + i;
        while (i < i3) {
            u g = g(1);
            int min = Math.min(i3 - i, 8192 - g.e);
            System.arraycopy(bArr, i, g.f432c, g.e, min);
            i += min;
            g.e += min;
        }
        this.f387c += j;
        return this;
    }

    public final OutputStream b() {
        return new OutputStream() {
            public final void close() {
            }

            public final void flush() {
            }

            public final String toString() {
                return c.this + ".outputStream()";
            }

            public final void write(int i) {
                c.this.l((int) (byte) i);
            }

            public final void write(byte[] bArr, int i, int i2) {
                c.this.c(bArr, i, i2);
            }
        };
    }

    public final void b(c cVar, long j) throws EOFException {
        if (this.f387c < j) {
            cVar.a(this, this.f387c);
            throw new EOFException();
        } else {
            cVar.a(this, j);
        }
    }

    public final void b(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a2 = a(bArr, i, bArr.length - i);
            if (a2 == -1) {
                throw new EOFException();
            }
            i += a2;
        }
    }

    public final boolean b(long j) {
        return this.f387c >= j;
    }

    public final byte c(long j) {
        ab.a(this.f387c, j, 1);
        u uVar = this.f386b;
        while (true) {
            long j2 = (long) (uVar.e - uVar.d);
            if (j < j2) {
                return uVar.f432c[uVar.d + ((int) j)];
            }
            uVar = uVar.h;
            j -= j2;
        }
    }

    public final long c(f fVar) {
        return b(fVar, 0);
    }

    /* renamed from: c */
    public final c k(int i) {
        u g = g(2);
        byte[] bArr = g.f432c;
        int i2 = g.e;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        g.e = i3 + 1;
        this.f387c += 2;
        return this;
    }

    /* renamed from: c */
    public final c d(byte[] bArr) {
        if (bArr != null) {
            return c(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public final d c() {
        return this;
    }

    public final void close() {
    }

    /* renamed from: d */
    public final c j(int i) {
        return k((int) ab.a((short) i));
    }

    public final f d(long j) throws EOFException {
        return new f(g(j));
    }

    public final boolean d() {
        return this.f387c == 0;
    }

    public final boolean d(f fVar) {
        return a(fVar, fVar.size());
    }

    /* renamed from: e */
    public final c i(int i) {
        u g = g(4);
        byte[] bArr = g.f432c;
        int i2 = g.e;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        g.e = i5 + 1;
        this.f387c += 4;
        return this;
    }

    public final InputStream e() {
        return new InputStream() {
            public final int available() {
                return (int) Math.min(c.this.f387c, 2147483647L);
            }

            public final void close() {
            }

            public final int read() {
                if (c.this.f387c > 0) {
                    return c.this.g() & 255;
                }
                return -1;
            }

            public final int read(byte[] bArr, int i, int i2) {
                return c.this.a(bArr, i, i2);
            }

            public final String toString() {
                return c.this + ".inputStream()";
            }
        };
    }

    public final String e(long j) throws EOFException {
        return a(j, ab.f382a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f387c != cVar.f387c) {
            return false;
        }
        long j = 0;
        if (this.f387c == 0) {
            return true;
        }
        u uVar = this.f386b;
        u uVar2 = cVar.f386b;
        int i = uVar.d;
        int i2 = uVar2.d;
        while (j < this.f387c) {
            long min = (long) Math.min(uVar.e - i, uVar2.e - i2);
            int i3 = i2;
            int i4 = i;
            int i5 = 0;
            while (((long) i5) < min) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                if (uVar.f432c[i4] != uVar2.f432c[i3]) {
                    return false;
                }
                i5++;
                i4 = i6;
                i3 = i7;
            }
            if (i4 == uVar.e) {
                uVar = uVar.h;
                i = uVar.d;
            } else {
                i = i4;
            }
            if (i3 == uVar2.e) {
                uVar2 = uVar2.h;
                i2 = uVar2.d;
            } else {
                i2 = i3;
            }
            j += min;
        }
        return true;
    }

    public final long f() {
        long j = this.f387c;
        if (j == 0) {
            return 0;
        }
        u uVar = this.f386b.i;
        return (uVar.e >= 8192 || !uVar.g) ? j : j - ((long) (uVar.e - uVar.d));
    }

    /* renamed from: f */
    public final c h(int i) {
        return i(ab.a(i));
    }

    /* access modifiers changed from: package-private */
    public final String f(long j) throws EOFException {
        String e;
        long j2 = 1;
        if (j > 0) {
            long j3 = j - 1;
            if (c(j3) == 13) {
                e = e(j3);
                j2 = 2;
                h(j2);
                return e;
            }
        }
        e = e(j);
        h(j2);
        return e;
    }

    public final void flush() {
    }

    public final byte g() {
        if (this.f387c == 0) {
            throw new IllegalStateException("size == 0");
        }
        u uVar = this.f386b;
        int i = uVar.d;
        int i2 = uVar.e;
        int i3 = i + 1;
        byte b2 = uVar.f432c[i];
        this.f387c--;
        if (i3 == i2) {
            this.f386b = uVar.a();
            v.a(uVar);
            return b2;
        }
        uVar.d = i3;
        return b2;
    }

    /* access modifiers changed from: package-private */
    public final u g(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        } else if (this.f386b == null) {
            this.f386b = v.a();
            u uVar = this.f386b;
            u uVar2 = this.f386b;
            u uVar3 = this.f386b;
            uVar2.i = uVar3;
            uVar.h = uVar3;
            return uVar3;
        } else {
            u uVar4 = this.f386b.i;
            return (uVar4.e + i > 8192 || !uVar4.g) ? uVar4.a(v.a()) : uVar4;
        }
    }

    public final byte[] g(long j) throws EOFException {
        ab.a(this.f387c, 0, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[((int) j)];
        b(bArr);
        return bArr;
    }

    public final short h() {
        if (this.f387c < 2) {
            throw new IllegalStateException("size < 2: " + this.f387c);
        }
        u uVar = this.f386b;
        int i = uVar.d;
        int i2 = uVar.e;
        if (i2 - i < 2) {
            return (short) (((g() & 255) << 8) | (g() & 255));
        }
        byte[] bArr = uVar.f432c;
        int i3 = i + 1;
        int i4 = i3 + 1;
        byte b2 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.f387c -= 2;
        if (i4 == i2) {
            this.f386b = uVar.a();
            v.a(uVar);
        } else {
            uVar.d = i4;
        }
        return (short) b2;
    }

    public final void h(long j) throws EOFException {
        while (j > 0) {
            if (this.f386b == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, (long) (this.f386b.e - this.f386b.d));
            long j2 = (long) min;
            this.f387c -= j2;
            long j3 = j - j2;
            this.f386b.d += min;
            if (this.f386b.d == this.f386b.e) {
                u uVar = this.f386b;
                this.f386b = uVar.a();
                v.a(uVar);
            }
            j = j3;
        }
    }

    public final int hashCode() {
        u uVar = this.f386b;
        if (uVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = uVar.e;
            for (int i3 = uVar.d; i3 < i2; i3++) {
                i = (i * 31) + uVar.f432c[i3];
            }
            uVar = uVar.h;
        } while (uVar != this.f386b);
        return i;
    }

    public final int i() {
        if (this.f387c < 4) {
            throw new IllegalStateException("size < 4: " + this.f387c);
        }
        u uVar = this.f386b;
        int i = uVar.d;
        int i2 = uVar.e;
        if (i2 - i < 4) {
            return ((g() & 255) << 24) | ((g() & 255) << bg.n) | ((g() & 255) << 8) | (g() & 255);
        }
        byte[] bArr = uVar.f432c;
        int i3 = i + 1;
        int i4 = i3 + 1;
        byte b2 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << bg.n);
        int i5 = i4 + 1;
        byte b3 = b2 | ((bArr[i4] & 255) << 8);
        int i6 = i5 + 1;
        byte b4 = b3 | (bArr[i5] & 255);
        this.f387c -= 4;
        if (i6 == i2) {
            this.f386b = uVar.a();
            v.a(uVar);
            return b4;
        }
        uVar.d = i6;
        return b4;
    }

    /* renamed from: i */
    public final c p(long j) {
        u g = g(8);
        byte[] bArr = g.f432c;
        int i = g.e;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 48) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j >>> 40) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((j >>> 32) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((j >>> 24) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((j >>> 16) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((j >>> 8) & 255));
        bArr[i8] = (byte) ((int) (j & 255));
        g.e = i8 + 1;
        this.f387c += 8;
        return this;
    }

    public final long j() {
        if (this.f387c < 8) {
            throw new IllegalStateException("size < 8: " + this.f387c);
        }
        u uVar = this.f386b;
        int i = uVar.d;
        int i2 = uVar.e;
        if (i2 - i < 8) {
            return ((((long) i()) & 4294967295L) << 32) | (((long) i()) & 4294967295L);
        }
        byte[] bArr = uVar.f432c;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        int i8 = i7 + 1;
        int i9 = i8 + 1;
        int i10 = i9 + 1;
        long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i3]) & 255) << 48) | ((((long) bArr[i4]) & 255) << 40) | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16) | ((((long) bArr[i8]) & 255) << 8) | (((long) bArr[i9]) & 255);
        this.f387c -= 8;
        if (i10 == i2) {
            this.f386b = uVar.a();
            v.a(uVar);
            return j;
        }
        uVar.d = i10;
        return j;
    }

    /* renamed from: j */
    public final c o(long j) {
        return p(ab.a(j));
    }

    /* renamed from: k */
    public final c n(long j) {
        if (j == 0) {
            return l(48);
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
        u g = g(i);
        byte[] bArr = g.f432c;
        int i2 = g.e + i;
        while (j != 0) {
            i2--;
            bArr[i2] = d[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        g.e += i;
        this.f387c += (long) i;
        return this;
    }

    public final short k() {
        return ab.a(h());
    }

    public final int l() {
        return ab.a(i());
    }

    /* renamed from: l */
    public final c m(long j) {
        if (j == 0) {
            return l(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        u g = g(numberOfTrailingZeros);
        byte[] bArr = g.f432c;
        int i = g.e;
        for (int i2 = (g.e + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = d[(int) (j & 15)];
            j >>>= 4;
        }
        g.e += numberOfTrailingZeros;
        this.f387c += (long) numberOfTrailingZeros;
        return this;
    }

    public final long m() {
        return ab.a(j());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b3, code lost:
        if (r10 != r11) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b5, code lost:
        r8 = r17;
        r0.f386b = r8.a();
        c.v.a(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c1, code lost:
        r17.d = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c5, code lost:
        if (r4 != false) goto L_0x00cb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long n() {
        /*
            r19 = this;
            r0 = r19
            long r1 = r0.f387c
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0012
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            throw r1
        L_0x0012:
            r1 = -7
            r5 = 0
            r6 = r3
            r3 = 0
            r4 = 0
        L_0x0018:
            c.u r8 = r0.f386b
            byte[] r9 = r8.f432c
            int r10 = r8.d
            int r11 = r8.e
        L_0x0020:
            r12 = 1
            if (r10 >= r11) goto L_0x00b1
            byte r13 = r9[r10]
            r14 = 48
            if (r13 < r14) goto L_0x007c
            r15 = 57
            if (r13 > r15) goto L_0x007c
            int r14 = r14 - r13
            r15 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r12 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r12 < 0) goto L_0x0052
            int r12 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r12 != 0) goto L_0x0045
            r17 = r8
            r18 = r9
            long r8 = (long) r14
            int r12 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r12 >= 0) goto L_0x0049
            goto L_0x0052
        L_0x0045:
            r17 = r8
            r18 = r9
        L_0x0049:
            r8 = 10
            long r6 = r6 * r8
            long r8 = (long) r14
            long r12 = r6 + r8
            r6 = r12
            goto L_0x008c
        L_0x0052:
            c.c r1 = new c.c
            r1.<init>()
            c.c r1 = r1.n((long) r6)
            c.c r1 = r1.l((int) r13)
            if (r3 != 0) goto L_0x0064
            r1.g()
        L_0x0064:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Number too large: "
            r3.<init>(r4)
            java.lang.String r1 = r1.q()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x007c:
            r17 = r8
            r18 = r9
            r8 = 45
            if (r13 != r8) goto L_0x0095
            if (r5 != 0) goto L_0x0095
            r8 = 1
            long r13 = r1 - r8
            r1 = r13
            r3 = 1
        L_0x008c:
            int r10 = r10 + 1
            int r5 = r5 + 1
            r8 = r17
            r9 = r18
            goto L_0x0020
        L_0x0095:
            if (r5 != 0) goto L_0x00af
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.<init>(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r13)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x00af:
            r4 = 1
            goto L_0x00b3
        L_0x00b1:
            r17 = r8
        L_0x00b3:
            if (r10 != r11) goto L_0x00c1
            r8 = r17
            c.u r9 = r8.a()
            r0.f386b = r9
            c.v.a(r8)
            goto L_0x00c5
        L_0x00c1:
            r8 = r17
            r8.d = r10
        L_0x00c5:
            if (r4 != 0) goto L_0x00cb
            c.u r8 = r0.f386b
            if (r8 != 0) goto L_0x0018
        L_0x00cb:
            long r1 = r0.f387c
            long r4 = (long) r5
            long r8 = r1 - r4
            r0.f387c = r8
            if (r3 == 0) goto L_0x00d5
            return r6
        L_0x00d5:
            long r1 = -r6
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.n():long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0097, code lost:
        if (r9 != r10) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0099, code lost:
        r0.f386b = r7.a();
        c.v.a(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a3, code lost:
        r7.d = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a5, code lost:
        if (r2 != false) goto L_0x00ab;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long o() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.f387c
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
            c.u r7 = r0.f386b
            byte[] r8 = r7.f432c
            int r9 = r7.d
            int r10 = r7.e
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
            c.c r1 = new c.c
            r1.<init>()
            c.c r1 = r1.m((long) r5)
            c.c r1 = r1.l((int) r11)
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Number too large: "
            r3.<init>(r4)
            java.lang.String r1 = r1.q()
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
            c.u r8 = r7.a()
            r0.f386b = r8
            c.v.a(r7)
            goto L_0x00a5
        L_0x00a3:
            r7.d = r9
        L_0x00a5:
            if (r2 != 0) goto L_0x00ab
            c.u r7 = r0.f386b
            if (r7 != 0) goto L_0x0015
        L_0x00ab:
            long r2 = r0.f387c
            long r7 = (long) r1
            long r9 = r2 - r7
            r0.f387c = r9
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.o():long");
    }

    public final f p() {
        return new f(v());
    }

    public final String q() {
        try {
            return a(this.f387c, ab.f382a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Nullable
    public final String r() throws EOFException {
        long a2 = a((byte) 10);
        if (a2 != -1) {
            return f(a2);
        }
        if (this.f387c != 0) {
            return e(this.f387c);
        }
        return null;
    }

    public final long read(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f387c == 0) {
            return -1;
        } else {
            if (j > this.f387c) {
                j = this.f387c;
            }
            cVar.a(this, j);
            return j;
        }
    }

    public final String s() throws EOFException {
        return t();
    }

    public final String t() throws EOFException {
        long a2 = a((byte) 10, 0, Long.MAX_VALUE);
        if (a2 != -1) {
            return f(a2);
        }
        if (Long.MAX_VALUE < this.f387c && c(9223372036854775806L) == 13 && c(Long.MAX_VALUE) == 10) {
            return f(Long.MAX_VALUE);
        }
        c cVar = new c();
        a(cVar, 0, Math.min(32, this.f387c));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f387c, Long.MAX_VALUE) + " content=" + cVar.p().hex() + 8230);
    }

    public final z timeout() {
        return z.f436c;
    }

    public final String toString() {
        if (this.f387c > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f387c);
        }
        int i = (int) this.f387c;
        return (i == 0 ? f.EMPTY : new w(this, i)).toString();
    }

    public final int u() throws EOFException {
        byte b2;
        int i;
        byte b3;
        if (this.f387c == 0) {
            throw new EOFException();
        }
        byte c2 = c(0);
        int i2 = 1;
        if ((c2 & 128) == 0) {
            b3 = c2 & Byte.MAX_VALUE;
            i = 1;
            b2 = 0;
        } else if ((c2 & 224) == 192) {
            b3 = c2 & 31;
            i = 2;
            b2 = 128;
        } else if ((c2 & 240) == 224) {
            b3 = c2 & bg.m;
            i = 3;
            b2 = 2048;
        } else if ((c2 & 248) == 240) {
            b3 = c2 & 7;
            i = 4;
            b2 = 65536;
        } else {
            h(1);
            return f385a;
        }
        long j = (long) i;
        if (this.f387c < j) {
            throw new EOFException("size < " + i + ": " + this.f387c + " (to read code point prefixed 0x" + Integer.toHexString(c2) + ")");
        }
        while (i2 < i) {
            long j2 = (long) i2;
            byte c3 = c(j2);
            if ((c3 & 192) == 128) {
                b3 = (b3 << 6) | (c3 & 63);
                i2++;
            } else {
                h(j2);
                return f385a;
            }
        }
        h(j);
        return b3 > 1114111 ? f385a : ((b3 < 55296 || b3 > 57343) && b3 >= b2) ? b3 : f385a;
    }

    public final byte[] v() {
        try {
            return g(this.f387c);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final void w() {
        try {
            h(this.f387c);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: x */
    public final c clone() {
        c cVar = new c();
        if (this.f387c == 0) {
            return cVar;
        }
        cVar.f386b = new u(this.f386b);
        u uVar = cVar.f386b;
        u uVar2 = cVar.f386b;
        u uVar3 = cVar.f386b;
        uVar2.i = uVar3;
        uVar.h = uVar3;
        u uVar4 = this.f386b;
        while (true) {
            uVar4 = uVar4.h;
            if (uVar4 != this.f386b) {
                cVar.f386b.i.a(new u(uVar4));
            } else {
                cVar.f387c = this.f387c;
                return cVar;
            }
        }
    }

    public final /* bridge */ /* synthetic */ d y() throws IOException {
        return this;
    }
}
