package org.apache.commons.io.filefilter;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import org.apache.commons.io.IOUtils;

public class MagicNumberFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = -547733176983104172L;
    private final long byteOffset;
    private final byte[] magicNumbers;

    public MagicNumberFileFilter(String str) {
        this(str, 0);
    }

    public MagicNumberFileFilter(String str, long j) {
        if (str == null) {
            throw new IllegalArgumentException("The magic number cannot be null");
        } else if (str.isEmpty()) {
            throw new IllegalArgumentException("The magic number must contain at least one byte");
        } else if (j < 0) {
            throw new IllegalArgumentException("The offset cannot be negative");
        } else {
            this.magicNumbers = str.getBytes(Charset.defaultCharset());
            this.byteOffset = j;
        }
    }

    public MagicNumberFileFilter(byte[] bArr) {
        this(bArr, 0);
    }

    public MagicNumberFileFilter(byte[] bArr, long j) {
        if (bArr == null) {
            throw new IllegalArgumentException("The magic number cannot be null");
        } else if (bArr.length == 0) {
            throw new IllegalArgumentException("The magic number must contain at least one byte");
        } else if (j < 0) {
            throw new IllegalArgumentException("The offset cannot be negative");
        } else {
            this.magicNumbers = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.magicNumbers, 0, bArr.length);
            this.byteOffset = j;
        }
    }

    public boolean accept(File file) {
        RandomAccessFile randomAccessFile;
        byte[] bArr;
        if (file != null && file.isFile() && file.canRead()) {
            RandomAccessFile randomAccessFile2 = null;
            try {
                bArr = new byte[this.magicNumbers.length];
                randomAccessFile = new RandomAccessFile(file, "r");
            } catch (IOException unused) {
                IOUtils.closeQuietly((Closeable) randomAccessFile2);
                return false;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = null;
                IOUtils.closeQuietly((Closeable) randomAccessFile);
                throw th;
            }
            try {
                randomAccessFile.seek(this.byteOffset);
                if (randomAccessFile.read(bArr) != this.magicNumbers.length) {
                    IOUtils.closeQuietly((Closeable) randomAccessFile);
                    return false;
                }
                boolean equals = Arrays.equals(this.magicNumbers, bArr);
                IOUtils.closeQuietly((Closeable) randomAccessFile);
                return equals;
            } catch (IOException unused2) {
                randomAccessFile2 = randomAccessFile;
                IOUtils.closeQuietly((Closeable) randomAccessFile2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuietly((Closeable) randomAccessFile);
                throw th;
            }
        }
        return false;
    }

    public String toString() {
        return super.toString() + "(" + new String(this.magicNumbers, Charset.defaultCharset()) + "," + this.byteOffset + ")";
    }
}
