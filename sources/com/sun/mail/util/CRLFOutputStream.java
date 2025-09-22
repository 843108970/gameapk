package com.sun.mail.util;

import com.umeng.commonsdk.proguard.bg;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CRLFOutputStream extends FilterOutputStream {
    private static final byte[] newline = {bg.k, 10};
    protected boolean atBOL = true;
    protected int lastb = -1;

    public CRLFOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        if (r2.lastb != 13) goto L_0x0004;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(int r3) throws java.io.IOException {
        /*
            r2 = this;
            r0 = 13
            if (r3 != r0) goto L_0x0008
        L_0x0004:
            r2.writeln()
            goto L_0x0019
        L_0x0008:
            r1 = 10
            if (r3 != r1) goto L_0x0011
            int r1 = r2.lastb
            if (r1 == r0) goto L_0x0019
            goto L_0x0004
        L_0x0011:
            java.io.OutputStream r0 = r2.out
            r0.write(r3)
            r0 = 0
            r2.atBOL = r0
        L_0x0019:
            r2.lastb = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.CRLFOutputStream.write(int):void");
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (r4.lastb != 13) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(byte[] r5, int r6, int r7) throws java.io.IOException {
        /*
            r4 = this;
            int r7 = r7 + r6
            r0 = r6
        L_0x0002:
            if (r6 < r7) goto L_0x0010
            int r7 = r7 - r0
            if (r7 <= 0) goto L_0x000f
            java.io.OutputStream r6 = r4.out
            r6.write(r5, r0, r7)
            r5 = 0
            r4.atBOL = r5
        L_0x000f:
            return
        L_0x0010:
            byte r1 = r5[r6]
            r2 = 13
            if (r1 != r2) goto L_0x0021
        L_0x0016:
            java.io.OutputStream r1 = r4.out
            int r2 = r6 - r0
            r1.write(r5, r0, r2)
            r4.writeln()
            goto L_0x002c
        L_0x0021:
            byte r1 = r5[r6]
            r3 = 10
            if (r1 != r3) goto L_0x002e
            int r1 = r4.lastb
            if (r1 == r2) goto L_0x002c
            goto L_0x0016
        L_0x002c:
            int r0 = r6 + 1
        L_0x002e:
            byte r1 = r5[r6]
            r4.lastb = r1
            int r6 = r6 + 1
            goto L_0x0002
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.CRLFOutputStream.write(byte[], int, int):void");
    }

    public void writeln() throws IOException {
        this.out.write(newline);
        this.atBOL = true;
    }
}
