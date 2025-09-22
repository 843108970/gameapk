package c;

import com.umeng.commonsdk.proguard.bg;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class f implements Serializable, Comparable<f> {
    public static final f EMPTY = of(new byte[0]);
    static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final long serialVersionUID = 1;
    final byte[] data;
    transient int hashCode;
    transient String utf8;

    f(byte[] bArr) {
        this.data = bArr;
    }

    static int codePointIndexToCharIndex(String str, int i) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    @Nullable
    public static f decodeBase64(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] a2 = b.a(str);
        if (a2 != null) {
            return new f(a2);
        }
        return null;
    }

    public static f decodeHex(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        } else {
            byte[] bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < bArr.length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((decodeHexDigit(str.charAt(i2)) << 4) + decodeHexDigit(str.charAt(i2 + 1)));
            }
            return of(bArr);
        }
    }

    private static int decodeHexDigit(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: " + c2);
            }
        }
        return (c2 - c3) + 10;
    }

    private f digest(String str) {
        try {
            return of(MessageDigest.getInstance(str).digest(this.data));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static f encodeString(String str, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        } else if (charset != null) {
            return new f(str.getBytes(charset));
        } else {
            throw new IllegalArgumentException("charset == null");
        }
    }

    public static f encodeUtf8(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        f fVar = new f(str.getBytes(ab.f382a));
        fVar.utf8 = str;
        return fVar;
    }

    private f hmac(String str, f fVar) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(fVar.toByteArray(), str));
            return of(instance.doFinal(this.data));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static f of(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("data == null");
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return new f(bArr);
    }

    public static f of(byte... bArr) {
        if (bArr != null) {
            return new f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static f of(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        ab.a((long) bArr.length, (long) i, (long) i2);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new f(bArr2);
    }

    public static f read(InputStream inputStream, int i) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + i);
        } else {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    throw new EOFException();
                }
                i2 += read;
            }
            return new f(bArr);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        f read = read(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = f.class.getDeclaredField("data");
            declaredField.setAccessible(true);
            declaredField.set(this, read.data);
        } catch (NoSuchFieldException unused) {
            throw new AssertionError();
        } catch (IllegalAccessException unused2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.data).asReadOnlyBuffer();
    }

    public String base64() {
        return b.a(this.data);
    }

    public String base64Url() {
        return b.b(this.data);
    }

    public int compareTo(f fVar) {
        int size = size();
        int size2 = fVar.size();
        int min = Math.min(size, size2);
        for (int i = 0; i < min; i++) {
            byte b2 = getByte(i) & 255;
            byte b3 = fVar.getByte(i) & 255;
            if (b2 != b3) {
                return b2 < b3 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public final boolean endsWith(f fVar) {
        return rangeEquals(size() - fVar.size(), fVar, 0, fVar.size());
    }

    public final boolean endsWith(byte[] bArr) {
        return rangeEquals(size() - bArr.length, bArr, 0, bArr.length);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return fVar.size() == this.data.length && fVar.rangeEquals(0, this.data, 0, this.data.length);
        }
    }

    public byte getByte(int i) {
        return this.data[i];
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode2 = Arrays.hashCode(this.data);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public String hex() {
        char[] cArr = new char[(this.data.length * 2)];
        int i = 0;
        for (byte b2 : this.data) {
            int i2 = i + 1;
            cArr[i] = HEX_DIGITS[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = HEX_DIGITS[b2 & bg.m];
        }
        return new String(cArr);
    }

    public f hmacSha1(f fVar) {
        return hmac("HmacSHA1", fVar);
    }

    public f hmacSha256(f fVar) {
        return hmac("HmacSHA256", fVar);
    }

    public f hmacSha512(f fVar) {
        return hmac("HmacSHA512", fVar);
    }

    public final int indexOf(f fVar) {
        return indexOf(fVar.internalArray(), 0);
    }

    public final int indexOf(f fVar, int i) {
        return indexOf(fVar.internalArray(), i);
    }

    public final int indexOf(byte[] bArr) {
        return indexOf(bArr, 0);
    }

    public int indexOf(byte[] bArr, int i) {
        int length = this.data.length - bArr.length;
        for (int max = Math.max(i, 0); max <= length; max++) {
            if (ab.a(this.data, max, bArr, 0, bArr.length)) {
                return max;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public byte[] internalArray() {
        return this.data;
    }

    public final int lastIndexOf(f fVar) {
        return lastIndexOf(fVar.internalArray(), size());
    }

    public final int lastIndexOf(f fVar, int i) {
        return lastIndexOf(fVar.internalArray(), i);
    }

    public final int lastIndexOf(byte[] bArr) {
        return lastIndexOf(bArr, size());
    }

    public int lastIndexOf(byte[] bArr, int i) {
        for (int min = Math.min(i, this.data.length - bArr.length); min >= 0; min--) {
            if (ab.a(this.data, min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public f md5() {
        return digest("MD5");
    }

    public boolean rangeEquals(int i, f fVar, int i2, int i3) {
        return fVar.rangeEquals(i2, this.data, i, i3);
    }

    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        return i >= 0 && i <= this.data.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && ab.a(this.data, i, bArr, i2, i3);
    }

    public f sha1() {
        return digest("SHA-1");
    }

    public f sha256() {
        return digest("SHA-256");
    }

    public f sha512() {
        return digest("SHA-512");
    }

    public int size() {
        return this.data.length;
    }

    public final boolean startsWith(f fVar) {
        return rangeEquals(0, fVar, 0, fVar.size());
    }

    public final boolean startsWith(byte[] bArr) {
        return rangeEquals(0, bArr, 0, bArr.length);
    }

    public String string(Charset charset) {
        if (charset != null) {
            return new String(this.data, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public f substring(int i) {
        return substring(i, this.data.length);
    }

    public f substring(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        } else if (i2 > this.data.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.data.length + ")");
        } else {
            int i3 = i2 - i;
            if (i3 < 0) {
                throw new IllegalArgumentException("endIndex < beginIndex");
            } else if (i == 0 && i2 == this.data.length) {
                return this;
            } else {
                byte[] bArr = new byte[i3];
                System.arraycopy(this.data, i, bArr, 0, i3);
                return new f(bArr);
            }
        }
    }

    public f toAsciiLowercase() {
        int i = 0;
        while (i < this.data.length) {
            byte b2 = this.data[i];
            if (b2 < 65 || b2 > 90) {
                i++;
            } else {
                byte[] bArr = (byte[]) this.data.clone();
                bArr[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < bArr.length; i2++) {
                    byte b3 = bArr[i2];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr[i2] = (byte) (b3 + 32);
                    }
                }
                return new f(bArr);
            }
        }
        return this;
    }

    public f toAsciiUppercase() {
        int i = 0;
        while (i < this.data.length) {
            byte b2 = this.data[i];
            if (b2 < 97 || b2 > 122) {
                i++;
            } else {
                byte[] bArr = (byte[]) this.data.clone();
                bArr[i] = (byte) (b2 - 32);
                for (int i2 = i + 1; i2 < bArr.length; i2++) {
                    byte b3 = bArr[i2];
                    if (b3 >= 97 && b3 <= 122) {
                        bArr[i2] = (byte) (b3 - 32);
                    }
                }
                return new f(bArr);
            }
        }
        return this;
    }

    public byte[] toByteArray() {
        return (byte[]) this.data.clone();
    }

    public String toString() {
        String replace;
        StringBuilder sb;
        StringBuilder sb2;
        String str;
        if (this.data.length == 0) {
            return "[size=0]";
        }
        String utf82 = utf8();
        int codePointIndexToCharIndex = codePointIndexToCharIndex(utf82, 64);
        if (codePointIndexToCharIndex != -1) {
            replace = utf82.substring(0, codePointIndexToCharIndex).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (codePointIndexToCharIndex < utf82.length()) {
                sb2 = new StringBuilder("[size=");
                sb2.append(this.data.length);
                sb2.append(" text=");
                sb2.append(replace);
                str = "…]";
                sb2.append(str);
                return sb2.toString();
            }
            sb = new StringBuilder("[text=");
        } else if (this.data.length <= 64) {
            sb = new StringBuilder("[hex=");
            replace = hex();
        } else {
            sb2 = new StringBuilder("[size=");
            sb2.append(this.data.length);
            sb2.append(" hex=");
            replace = substring(0, 64).hex();
            sb2.append(replace);
            str = "…]";
            sb2.append(str);
            return sb2.toString();
        }
        sb2.append(replace);
        str = "]";
        sb2.append(str);
        return sb2.toString();
    }

    public String utf8() {
        String str = this.utf8;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.data, ab.f382a);
        this.utf8 = str2;
        return str2;
    }

    /* access modifiers changed from: package-private */
    public void write(c cVar) {
        cVar.c(this.data, 0, this.data.length);
    }

    public void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        outputStream.write(this.data);
    }
}
