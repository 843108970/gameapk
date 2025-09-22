package c;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

final class w extends f {
    final transient int[] directory;
    final transient byte[][] segments;

    w(c cVar, int i) {
        super((byte[]) null);
        ab.a(cVar.f387c, 0, (long) i);
        int i2 = 0;
        u uVar = cVar.f386b;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (uVar.e == uVar.d) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += uVar.e - uVar.d;
            i4++;
            uVar = uVar.h;
        }
        this.segments = new byte[i4][];
        this.directory = new int[(i4 * 2)];
        u uVar2 = cVar.f386b;
        int i5 = 0;
        while (i2 < i) {
            this.segments[i5] = uVar2.f432c;
            i2 += uVar2.e - uVar2.d;
            if (i2 > i) {
                i2 = i;
            }
            this.directory[i5] = i2;
            this.directory[this.segments.length + i5] = uVar2.d;
            uVar2.f = true;
            i5++;
            uVar2 = uVar2.h;
        }
    }

    private int segment(int i) {
        int binarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ -1;
    }

    private f toByteString() {
        return new f(toByteArray());
    }

    private Object writeReplace() {
        return toByteString();
    }

    public final ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    public final String base64() {
        return toByteString().base64();
    }

    public final String base64Url() {
        return toByteString().base64Url();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return fVar.size() == size() && rangeEquals(0, fVar, 0, size());
        }
    }

    public final byte getByte(int i) {
        ab.a((long) this.directory[this.segments.length - 1], (long) i, 1);
        int segment = segment(i);
        return this.segments[segment][(i - (segment == 0 ? 0 : this.directory[segment - 1])) + this.directory[this.segments.length + segment]];
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int length = this.segments.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.segments[i2];
            int i5 = this.directory[length + i2];
            int i6 = this.directory[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.hashCode = i4;
        return i4;
    }

    public final String hex() {
        return toByteString().hex();
    }

    public final f hmacSha1(f fVar) {
        return toByteString().hmacSha1(fVar);
    }

    public final f hmacSha256(f fVar) {
        return toByteString().hmacSha256(fVar);
    }

    public final int indexOf(byte[] bArr, int i) {
        return toByteString().indexOf(bArr, i);
    }

    /* access modifiers changed from: package-private */
    public final byte[] internalArray() {
        return toByteArray();
    }

    public final int lastIndexOf(byte[] bArr, int i) {
        return toByteString().lastIndexOf(bArr, i);
    }

    public final f md5() {
        return toByteString().md5();
    }

    public final boolean rangeEquals(int i, f fVar, int i2, int i3) {
        if (i < 0 || i > size() - i3) {
            return false;
        }
        int segment = segment(i);
        while (i3 > 0) {
            int i4 = segment == 0 ? 0 : this.directory[segment - 1];
            int min = Math.min(i3, ((this.directory[segment] - i4) + i4) - i);
            if (!fVar.rangeEquals(i2, this.segments[segment], (i - i4) + this.directory[this.segments.length + segment], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            segment++;
        }
        return true;
    }

    public final boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int segment = segment(i);
        while (i3 > 0) {
            int i4 = segment == 0 ? 0 : this.directory[segment - 1];
            int min = Math.min(i3, ((this.directory[segment] - i4) + i4) - i);
            if (!ab.a(this.segments[segment], (i - i4) + this.directory[this.segments.length + segment], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            segment++;
        }
        return true;
    }

    public final f sha1() {
        return toByteString().sha1();
    }

    public final f sha256() {
        return toByteString().sha256();
    }

    public final int size() {
        return this.directory[this.segments.length - 1];
    }

    public final String string(Charset charset) {
        return toByteString().string(charset);
    }

    public final f substring(int i) {
        return toByteString().substring(i);
    }

    public final f substring(int i, int i2) {
        return toByteString().substring(i, i2);
    }

    public final f toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    public final f toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    public final byte[] toByteArray() {
        byte[] bArr = new byte[this.directory[this.segments.length - 1]];
        int length = this.segments.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = this.directory[length + i];
            int i4 = this.directory[i];
            System.arraycopy(this.segments[i], i3, bArr, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr;
    }

    public final String toString() {
        return toByteString().toString();
    }

    public final String utf8() {
        return toByteString().utf8();
    }

    /* access modifiers changed from: package-private */
    public final void write(c cVar) {
        int length = this.segments.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = this.directory[length + i];
            int i4 = this.directory[i];
            u uVar = new u(this.segments[i], i3, (i3 + i4) - i2);
            if (cVar.f386b == null) {
                uVar.i = uVar;
                uVar.h = uVar;
                cVar.f386b = uVar;
            } else {
                cVar.f386b.i.a(uVar);
            }
            i++;
            i2 = i4;
        }
        cVar.f387c += (long) i2;
    }

    public final void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        int length = this.segments.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = this.directory[length + i];
            int i4 = this.directory[i];
            outputStream.write(this.segments[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
    }
}
