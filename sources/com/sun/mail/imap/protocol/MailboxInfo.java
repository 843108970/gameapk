package com.sun.mail.imap.protocol;

import javax.mail.Flags;

public class MailboxInfo {
    public Flags availableFlags = null;
    public int first = -1;
    public int mode;
    public Flags permanentFlags = null;
    public int recent = -1;
    public int total = -1;
    public long uidnext = -1;
    public long uidvalidity = -1;

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MailboxInfo(com.sun.mail.iap.Response[] r7) throws com.sun.mail.iap.ParsingException {
        /*
            r6 = this;
            r6.<init>()
            r0 = 0
            r6.availableFlags = r0
            r6.permanentFlags = r0
            r1 = -1
            r6.total = r1
            r6.recent = r1
            r6.first = r1
            r1 = -1
            r6.uidvalidity = r1
            r6.uidnext = r1
            r1 = 0
            r2 = 0
        L_0x0017:
            int r3 = r7.length
            if (r2 < r3) goto L_0x0034
            javax.mail.Flags r7 = r6.permanentFlags
            if (r7 != 0) goto L_0x0033
            javax.mail.Flags r7 = r6.availableFlags
            if (r7 == 0) goto L_0x002c
            javax.mail.Flags r7 = new javax.mail.Flags
            javax.mail.Flags r0 = r6.availableFlags
            r7.<init>((javax.mail.Flags) r0)
            r6.permanentFlags = r7
            return
        L_0x002c:
            javax.mail.Flags r7 = new javax.mail.Flags
            r7.<init>()
            r6.permanentFlags = r7
        L_0x0033:
            return
        L_0x0034:
            r3 = r7[r2]
            if (r3 == 0) goto L_0x00da
            r3 = r7[r2]
            boolean r3 = r3 instanceof com.sun.mail.imap.protocol.IMAPResponse
            if (r3 == 0) goto L_0x00da
            r3 = r7[r2]
            com.sun.mail.imap.protocol.IMAPResponse r3 = (com.sun.mail.imap.protocol.IMAPResponse) r3
            java.lang.String r4 = "EXISTS"
            boolean r4 = r3.keyEquals(r4)
            if (r4 == 0) goto L_0x0054
            int r3 = r3.getNumber()
            r6.total = r3
            r7[r2] = r0
            goto L_0x00da
        L_0x0054:
            java.lang.String r4 = "RECENT"
            boolean r4 = r3.keyEquals(r4)
            if (r4 == 0) goto L_0x0066
            int r3 = r3.getNumber()
            r6.recent = r3
            r7[r2] = r0
            goto L_0x00da
        L_0x0066:
            java.lang.String r4 = "FLAGS"
            boolean r4 = r3.keyEquals(r4)
            if (r4 == 0) goto L_0x0078
            com.sun.mail.imap.protocol.FLAGS r4 = new com.sun.mail.imap.protocol.FLAGS
            r4.<init>(r3)
            r6.availableFlags = r4
            r7[r2] = r0
            goto L_0x00da
        L_0x0078:
            boolean r4 = r3.isUnTagged()
            if (r4 == 0) goto L_0x00da
            boolean r4 = r3.isOK()
            if (r4 == 0) goto L_0x00da
            r3.skipSpaces()
            byte r4 = r3.readByte()
            r5 = 91
            if (r4 != r5) goto L_0x00d7
            java.lang.String r4 = r3.readAtom()
            java.lang.String r5 = "UNSEEN"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x00a2
            int r4 = r3.readNumber()
            r6.first = r4
            goto L_0x00cf
        L_0x00a2:
            java.lang.String r5 = "UIDVALIDITY"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x00b1
            long r4 = r3.readLong()
            r6.uidvalidity = r4
            goto L_0x00cf
        L_0x00b1:
            java.lang.String r5 = "PERMANENTFLAGS"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x00c1
            com.sun.mail.imap.protocol.FLAGS r4 = new com.sun.mail.imap.protocol.FLAGS
            r4.<init>(r3)
            r6.permanentFlags = r4
            goto L_0x00cf
        L_0x00c1:
            java.lang.String r5 = "UIDNEXT"
            boolean r4 = r4.equalsIgnoreCase(r5)
            if (r4 == 0) goto L_0x00d1
            long r4 = r3.readLong()
            r6.uidnext = r4
        L_0x00cf:
            r4 = 1
            goto L_0x00d2
        L_0x00d1:
            r4 = 0
        L_0x00d2:
            if (r4 == 0) goto L_0x00d7
            r7[r2] = r0
            goto L_0x00da
        L_0x00d7:
            r3.reset()
        L_0x00da:
            int r2 = r2 + 1
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.protocol.MailboxInfo.<init>(com.sun.mail.iap.Response[]):void");
    }
}
