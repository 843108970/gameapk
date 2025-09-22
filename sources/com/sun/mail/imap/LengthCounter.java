package com.sun.mail.imap;

import java.io.IOException;
import java.io.OutputStream;

class LengthCounter extends OutputStream {
    private byte[] buf = new byte[8192];
    private int maxsize;
    private int size = 0;

    public LengthCounter(int i) {
        this.maxsize = i;
    }

    public byte[] getBytes() {
        return this.buf;
    }

    public int getSize() {
        return this.size;
    }

    public void write(int i) {
        int i2 = this.size + 1;
        if (this.buf != null) {
            if (i2 <= this.maxsize || this.maxsize < 0) {
                if (i2 > this.buf.length) {
                    byte[] bArr = new byte[Math.max(this.buf.length << 1, i2)];
                    System.arraycopy(this.buf, 0, bArr, 0, this.size);
                    this.buf = bArr;
                }
                this.buf[this.size] = (byte) i;
            } else {
                this.buf = null;
            }
        }
        this.size = i2;
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        int i3;
        if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 != 0) {
            int i4 = this.size + i2;
            if (this.buf != null) {
                if (i4 <= this.maxsize || this.maxsize < 0) {
                    if (i4 > this.buf.length) {
                        byte[] bArr2 = new byte[Math.max(this.buf.length << 1, i4)];
                        System.arraycopy(this.buf, 0, bArr2, 0, this.size);
                        this.buf = bArr2;
                    }
                    System.arraycopy(bArr, i, this.buf, this.size, i2);
                } else {
                    this.buf = null;
                }
            }
            this.size = i4;
        }
    }
}
