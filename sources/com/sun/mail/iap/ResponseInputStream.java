package com.sun.mail.iap;

import com.sun.mail.util.ASCIIUtility;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResponseInputStream {
    private static final int incrementSlop = 16;
    private static final int maxIncrement = 262144;
    private static final int minIncrement = 256;
    private BufferedInputStream bin;

    public ResponseInputStream(InputStream inputStream) {
        this.bin = new BufferedInputStream(inputStream, 2048);
    }

    public ByteArray readResponse() throws IOException {
        return readResponse((ByteArray) null);
    }

    public ByteArray readResponse(ByteArray byteArray) throws IOException {
        int i;
        byte[] bArr;
        if (byteArray == null) {
            byteArray = new ByteArray(new byte[128], 0, 128);
        }
        byte[] bytes = byteArray.getBytes();
        int i2 = 0;
        while (true) {
            byte[] bArr2 = bytes;
            i = i2;
            boolean z = false;
            int i3 = 0;
            while (!z && (i3 = this.bin.read()) != -1) {
                if (i3 == 10 && i > 0 && bArr2[i - 1] == 13) {
                    z = true;
                }
                if (i >= bArr2.length) {
                    int length = bArr2.length;
                    if (length > 262144) {
                        length = 262144;
                    }
                    byteArray.grow(length);
                    bArr2 = byteArray.getBytes();
                }
                bArr2[i] = (byte) i3;
                i++;
            }
            if (i3 != -1) {
                if (i < 5) {
                    break;
                }
                int i4 = i - 3;
                if (bArr2[i4] != 125) {
                    break;
                }
                int i5 = i - 4;
                while (i5 >= 0 && bArr2[i5] != 123) {
                    i5--;
                }
                if (i5 < 0) {
                    break;
                }
                try {
                    int parseInt = ASCIIUtility.parseInt(bArr2, i5 + 1, i4);
                    if (parseInt > 0) {
                        int length2 = bArr2.length - i;
                        int i6 = parseInt + 16;
                        if (i6 > length2) {
                            int i7 = i6 - length2;
                            int i8 = 256;
                            if (256 <= i7) {
                                i8 = i7;
                            }
                            byteArray.grow(i8);
                            bArr = byteArray.getBytes();
                        } else {
                            bArr = bArr2;
                        }
                        while (parseInt > 0) {
                            int read = this.bin.read(bArr, i, parseInt);
                            parseInt -= read;
                            i += read;
                        }
                        bytes = bArr;
                        i2 = i;
                    } else {
                        i2 = i;
                        bytes = bArr2;
                    }
                } catch (NumberFormatException unused) {
                }
            } else {
                throw new IOException();
            }
        }
        byteArray.setCount(i);
        return byteArray;
    }
}
