package mobi.oneway.export.g;

import java.io.IOException;
import java.io.InputStream;

public class c extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private InputStream f4209a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f4210b;

    /* renamed from: c  reason: collision with root package name */
    private int f4211c = 0;
    private boolean d = false;

    public c(InputStream inputStream) {
        this.f4209a = inputStream;
    }

    private void a() {
        int i;
        char[] cArr = new char[4];
        int i2 = 0;
        do {
            int read = this.f4209a.read();
            i = 1;
            if (read != -1) {
                char c2 = (char) read;
                if (q.f4229a.indexOf(c2) != -1 || c2 == q.f4230b) {
                    cArr[i2] = c2;
                    i2++;
                    continue;
                } else if (!(c2 == 13 || c2 == 10)) {
                    throw new IOException("Bad base64 stream");
                }
            } else if (i2 != 0) {
                throw new IOException("Bad base64 stream");
            } else {
                this.f4210b = new int[0];
                this.d = true;
                return;
            }
        } while (i2 < 4);
        boolean z = false;
        for (int i3 = 0; i3 < 4; i3++) {
            if (cArr[i3] != q.f4230b) {
                if (z) {
                    throw new IOException("Bad base64 stream");
                }
            } else if (!z) {
                z = true;
            }
        }
        if (cArr[3] != q.f4230b) {
            i = 3;
        } else if (this.f4209a.read() != -1) {
            throw new IOException("Bad base64 stream");
        } else {
            this.d = true;
            if (cArr[2] != q.f4230b) {
                i = 2;
            }
        }
        int i4 = 0;
        for (int i5 = 0; i5 < 4; i5++) {
            if (cArr[i5] != q.f4230b) {
                i4 |= q.f4229a.indexOf(cArr[i5]) << ((3 - i5) * 6);
            }
        }
        this.f4210b = new int[i];
        for (int i6 = 0; i6 < i; i6++) {
            this.f4210b[i6] = (i4 >>> ((2 - i6) * 8)) & 255;
        }
    }

    public void close() {
        this.f4209a.close();
    }

    public int read() {
        if (this.f4210b != null && this.f4211c != this.f4210b.length) {
            int[] iArr = this.f4210b;
            int i = this.f4211c;
            this.f4211c = i + 1;
            return iArr[i];
        } else if (this.d) {
            return -1;
        } else {
            a();
            if (this.f4210b.length == 0) {
                this.f4210b = null;
                return -1;
            }
            this.f4211c = 0;
            int[] iArr2 = this.f4210b;
            int i2 = this.f4211c;
            this.f4211c = i2 + 1;
            return iArr2[i2];
        }
    }
}
