package com.sun.mail.smtp;

import com.sun.mail.util.CRLFOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class SMTPOutputStream extends CRLFOutputStream {
    public SMTPOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void ensureAtBOL() throws IOException {
        if (!this.atBOL) {
            super.writeln();
        }
    }

    public void flush() {
    }

    public void write(int i) throws IOException {
        if ((this.lastb == 10 || this.lastb == 13 || this.lastb == -1) && i == 46) {
            this.out.write(46);
        }
        super.write(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r2v3, types: [byte] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(byte[] r5, int r6, int r7) throws java.io.IOException {
        /*
            r4 = this;
            int r0 = r4.lastb
            r1 = 10
            r2 = -1
            if (r0 != r2) goto L_0x000a
            r0 = 10
            goto L_0x000c
        L_0x000a:
            int r0 = r4.lastb
        L_0x000c:
            int r7 = r7 + r6
            r2 = r0
            r0 = r6
        L_0x000f:
            if (r6 < r7) goto L_0x0018
            int r7 = r7 - r0
            if (r7 <= 0) goto L_0x0017
            super.write(r5, r0, r7)
        L_0x0017:
            return
        L_0x0018:
            if (r2 == r1) goto L_0x001e
            r3 = 13
            if (r2 != r3) goto L_0x002f
        L_0x001e:
            byte r2 = r5[r6]
            r3 = 46
            if (r2 != r3) goto L_0x002f
            int r2 = r6 - r0
            super.write(r5, r0, r2)
            java.io.OutputStream r0 = r4.out
            r0.write(r3)
            r0 = r6
        L_0x002f:
            byte r2 = r5[r6]
            int r6 = r6 + 1
            goto L_0x000f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.smtp.SMTPOutputStream.write(byte[], int, int):void");
    }
}
