package a.a.a;

import java.io.IOException;
import java.io.InputStream;

public final class b extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private InputStream f0a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f1b;

    /* renamed from: c  reason: collision with root package name */
    private int f2c = 0;
    private boolean d = false;

    public b(InputStream inputStream) {
        this.f0a = inputStream;
    }

    private void a() throws IOException {
        int i;
        char[] cArr = new char[4];
        int i2 = 0;
        do {
            int read = this.f0a.read();
            i = 1;
            if (read != -1) {
                char c2 = (char) read;
                if (d.f6a.indexOf(c2) != -1 || c2 == d.f7b) {
                    cArr[i2] = c2;
                    i2++;
                    continue;
                } else if (!(c2 == 13 || c2 == 10)) {
                    throw new IOException("Bad base64 stream");
                }
            } else if (i2 != 0) {
                throw new IOException("Bad base64 stream");
            } else {
                this.f1b = new int[0];
                this.d = true;
                return;
            }
        } while (i2 < 4);
        boolean z = false;
        for (int i3 = 0; i3 < 4; i3++) {
            if (cArr[i3] != d.f7b) {
                if (z) {
                    throw new IOException("Bad base64 stream");
                }
            } else if (!z) {
                z = true;
            }
        }
        if (cArr[3] != d.f7b) {
            i = 3;
        } else if (this.f0a.read() != -1) {
            throw new IOException("Bad base64 stream");
        } else {
            this.d = true;
            if (cArr[2] != d.f7b) {
                i = 2;
            }
        }
        int i4 = 0;
        for (int i5 = 0; i5 < 4; i5++) {
            if (cArr[i5] != d.f7b) {
                i4 |= d.f6a.indexOf(cArr[i5]) << ((3 - i5) * 6);
            }
        }
        this.f1b = new int[i];
        for (int i6 = 0; i6 < i; i6++) {
            this.f1b[i6] = (i4 >>> ((2 - i6) * 8)) & 255;
        }
    }

    public final void close() throws IOException {
        this.f0a.close();
    }

    public final int read() throws IOException {
        if (this.f1b == null || this.f2c == this.f1b.length) {
            if (this.d) {
                return -1;
            }
            char[] cArr = new char[4];
            int i = 0;
            while (true) {
                int read = this.f0a.read();
                int i2 = 1;
                if (read != -1) {
                    char c2 = (char) read;
                    if (d.f6a.indexOf(c2) != -1 || c2 == d.f7b) {
                        cArr[i] = c2;
                        i++;
                        continue;
                    } else if (!(c2 == 13 || c2 == 10)) {
                        throw new IOException("Bad base64 stream");
                    }
                    if (i >= 4) {
                        boolean z = false;
                        for (int i3 = 0; i3 < 4; i3++) {
                            if (cArr[i3] != d.f7b) {
                                if (z) {
                                    throw new IOException("Bad base64 stream");
                                }
                            } else if (!z) {
                                z = true;
                            }
                        }
                        if (cArr[3] != d.f7b) {
                            i2 = 3;
                        } else if (this.f0a.read() != -1) {
                            throw new IOException("Bad base64 stream");
                        } else {
                            this.d = true;
                            if (cArr[2] != d.f7b) {
                                i2 = 2;
                            }
                        }
                        int i4 = 0;
                        for (int i5 = 0; i5 < 4; i5++) {
                            if (cArr[i5] != d.f7b) {
                                i4 |= d.f6a.indexOf(cArr[i5]) << ((3 - i5) * 6);
                            }
                        }
                        this.f1b = new int[i2];
                        for (int i6 = 0; i6 < i2; i6++) {
                            this.f1b[i6] = (i4 >>> ((2 - i6) * 8)) & 255;
                        }
                    }
                } else if (i != 0) {
                    throw new IOException("Bad base64 stream");
                } else {
                    this.f1b = new int[0];
                    this.d = true;
                }
            }
            if (this.f1b.length == 0) {
                this.f1b = null;
                return -1;
            }
            this.f2c = 0;
        }
        int[] iArr = this.f1b;
        int i7 = this.f2c;
        this.f2c = i7 + 1;
        return iArr[i7];
    }
}
