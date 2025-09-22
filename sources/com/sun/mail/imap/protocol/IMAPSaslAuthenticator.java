package com.sun.mail.imap.protocol;

import java.io.PrintStream;
import java.util.Properties;

public class IMAPSaslAuthenticator implements SaslAuthenticator {
    /* access modifiers changed from: private */
    public boolean debug;
    private String host;
    private String name;
    /* access modifiers changed from: private */
    public PrintStream out;
    private IMAPProtocol pr;
    private Properties props;

    public IMAPSaslAuthenticator(IMAPProtocol iMAPProtocol, String str, Properties properties, boolean z, PrintStream printStream, String str2) {
        this.pr = iMAPProtocol;
        this.name = str;
        this.props = properties;
        this.debug = z;
        this.out = printStream;
        this.host = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e0, code lost:
        return r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean authenticate(java.lang.String[] r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22) throws com.sun.mail.iap.ProtocolException {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            com.sun.mail.imap.protocol.IMAPProtocol r8 = r1.pr
            monitor-enter(r8)
            java.util.Vector r9 = new java.util.Vector     // Catch:{ all -> 0x0213 }
            r9.<init>()     // Catch:{ all -> 0x0213 }
            boolean r3 = r1.debug     // Catch:{ all -> 0x0213 }
            r10 = 0
            if (r3 == 0) goto L_0x003a
            java.io.PrintStream r3 = r1.out     // Catch:{ all -> 0x0213 }
            java.lang.String r4 = "IMAP SASL DEBUG: Mechanisms:"
            r3.print(r4)     // Catch:{ all -> 0x0213 }
            r3 = 0
        L_0x0019:
            int r4 = r2.length     // Catch:{ all -> 0x0213 }
            if (r3 < r4) goto L_0x0022
            java.io.PrintStream r3 = r1.out     // Catch:{ all -> 0x0213 }
            r3.println()     // Catch:{ all -> 0x0213 }
            goto L_0x003a
        L_0x0022:
            java.io.PrintStream r4 = r1.out     // Catch:{ all -> 0x0213 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0213 }
            java.lang.String r6 = " "
            r5.<init>(r6)     // Catch:{ all -> 0x0213 }
            r6 = r2[r3]     // Catch:{ all -> 0x0213 }
            r5.append(r6)     // Catch:{ all -> 0x0213 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0213 }
            r4.print(r5)     // Catch:{ all -> 0x0213 }
            int r3 = r3 + 1
            goto L_0x0019
        L_0x003a:
            com.sun.mail.imap.protocol.IMAPSaslAuthenticator$1 r7 = new com.sun.mail.imap.protocol.IMAPSaslAuthenticator$1     // Catch:{ all -> 0x0213 }
            r3 = r19
            r4 = r21
            r5 = r22
            r7.<init>(r4, r5, r3)     // Catch:{ all -> 0x0213 }
            java.lang.String r4 = r1.name     // Catch:{ SaslException -> 0x01f7 }
            java.lang.String r5 = r1.host     // Catch:{ SaslException -> 0x01f7 }
            java.util.Properties r6 = r1.props     // Catch:{ SaslException -> 0x01f7 }
            r3 = r20
            javax.security.sasl.SaslClient r2 = javax.security.sasl.Sasl.createSaslClient(r2, r3, r4, r5, r6, r7)     // Catch:{ SaslException -> 0x01f7 }
            if (r2 != 0) goto L_0x0060
            boolean r2 = r1.debug     // Catch:{ all -> 0x0213 }
            if (r2 == 0) goto L_0x005e
            java.io.PrintStream r2 = r1.out     // Catch:{ all -> 0x0213 }
            java.lang.String r3 = "IMAP SASL DEBUG: No SASL support"
            r2.println(r3)     // Catch:{ all -> 0x0213 }
        L_0x005e:
            monitor-exit(r8)     // Catch:{ all -> 0x0213 }
            return r10
        L_0x0060:
            boolean r3 = r1.debug     // Catch:{ all -> 0x0213 }
            if (r3 == 0) goto L_0x007b
            java.io.PrintStream r3 = r1.out     // Catch:{ all -> 0x0213 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0213 }
            java.lang.String r5 = "IMAP SASL DEBUG: SASL client "
            r4.<init>(r5)     // Catch:{ all -> 0x0213 }
            java.lang.String r5 = r2.getMechanismName()     // Catch:{ all -> 0x0213 }
            r4.append(r5)     // Catch:{ all -> 0x0213 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0213 }
            r3.println(r4)     // Catch:{ all -> 0x0213 }
        L_0x007b:
            com.sun.mail.imap.protocol.IMAPProtocol r3 = r1.pr     // Catch:{ Exception -> 0x01db }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01db }
            java.lang.String r5 = "AUTHENTICATE "
            r4.<init>(r5)     // Catch:{ Exception -> 0x01db }
            java.lang.String r5 = r2.getMechanismName()     // Catch:{ Exception -> 0x01db }
            r4.append(r5)     // Catch:{ Exception -> 0x01db }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x01db }
            r5 = 0
            java.lang.String r3 = r3.writeCommand(r4, r5)     // Catch:{ Exception -> 0x01db }
            com.sun.mail.imap.protocol.IMAPProtocol r4 = r1.pr     // Catch:{ all -> 0x0213 }
            java.io.OutputStream r4 = r4.getIMAPOutputStream()     // Catch:{ all -> 0x0213 }
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0213 }
            r6.<init>()     // Catch:{ all -> 0x0213 }
            r7 = 2
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x0213 }
            r7 = {13, 10} // fill-array     // Catch:{ all -> 0x0213 }
            java.lang.String r11 = r2.getMechanismName()     // Catch:{ all -> 0x0213 }
            java.lang.String r12 = "XGWTRUSTEDAPP"
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0213 }
            r12 = 1
            r14 = r5
            r13 = 0
        L_0x00b2:
            if (r13 == 0) goto L_0x00fb
            boolean r3 = r2.isComplete()     // Catch:{ all -> 0x0213 }
            if (r3 == 0) goto L_0x00e1
            java.lang.String r3 = "javax.security.sasl.qop"
            java.lang.Object r2 = r2.getNegotiatedProperty(r3)     // Catch:{ all -> 0x0213 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0213 }
            if (r2 == 0) goto L_0x00e1
            java.lang.String r3 = "auth-int"
            boolean r3 = r2.equalsIgnoreCase(r3)     // Catch:{ all -> 0x0213 }
            if (r3 != 0) goto L_0x00d4
            java.lang.String r3 = "auth-conf"
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ all -> 0x0213 }
            if (r2 == 0) goto L_0x00e1
        L_0x00d4:
            boolean r2 = r1.debug     // Catch:{ all -> 0x0213 }
            if (r2 == 0) goto L_0x00df
            java.io.PrintStream r2 = r1.out     // Catch:{ all -> 0x0213 }
            java.lang.String r3 = "IMAP SASL DEBUG: Mechanism requires integrity or confidentiality"
            r2.println(r3)     // Catch:{ all -> 0x0213 }
        L_0x00df:
            monitor-exit(r8)     // Catch:{ all -> 0x0213 }
            return r10
        L_0x00e1:
            int r2 = r9.size()     // Catch:{ all -> 0x0213 }
            com.sun.mail.iap.Response[] r2 = new com.sun.mail.iap.Response[r2]     // Catch:{ all -> 0x0213 }
            r9.copyInto(r2)     // Catch:{ all -> 0x0213 }
            com.sun.mail.imap.protocol.IMAPProtocol r3 = r1.pr     // Catch:{ all -> 0x0213 }
            r3.notifyResponseHandlers(r2)     // Catch:{ all -> 0x0213 }
            com.sun.mail.imap.protocol.IMAPProtocol r2 = r1.pr     // Catch:{ all -> 0x0213 }
            r2.handleResult(r14)     // Catch:{ all -> 0x0213 }
            com.sun.mail.imap.protocol.IMAPProtocol r2 = r1.pr     // Catch:{ all -> 0x0213 }
            r2.setCapabilities(r14)     // Catch:{ all -> 0x0213 }
            monitor-exit(r8)     // Catch:{ all -> 0x0213 }
            return r12
        L_0x00fb:
            com.sun.mail.imap.protocol.IMAPProtocol r14 = r1.pr     // Catch:{ Exception -> 0x01c8 }
            com.sun.mail.iap.Response r14 = r14.readResponse()     // Catch:{ Exception -> 0x01c8 }
            boolean r15 = r14.isContinuation()     // Catch:{ Exception -> 0x01c8 }
            if (r15 == 0) goto L_0x01a4
            boolean r15 = r2.isComplete()     // Catch:{ Exception -> 0x01c8 }
            if (r15 != 0) goto L_0x0148
            com.sun.mail.iap.ByteArray r15 = r14.readByteArray()     // Catch:{ Exception -> 0x01c8 }
            byte[] r15 = r15.getNewBytes()     // Catch:{ Exception -> 0x01c8 }
            int r5 = r15.length     // Catch:{ Exception -> 0x01c8 }
            if (r5 <= 0) goto L_0x011c
            byte[] r15 = com.sun.mail.util.BASE64DecoderStream.decode(r15)     // Catch:{ Exception -> 0x01c8 }
        L_0x011c:
            boolean r5 = r1.debug     // Catch:{ Exception -> 0x01c8 }
            if (r5 == 0) goto L_0x0141
            java.io.PrintStream r5 = r1.out     // Catch:{ Exception -> 0x01c8 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01c8 }
            java.lang.String r10 = "IMAP SASL DEBUG: challenge: "
            r12.<init>(r10)     // Catch:{ Exception -> 0x01c8 }
            int r10 = r15.length     // Catch:{ Exception -> 0x01c8 }
            r16 = r13
            r13 = 0
            java.lang.String r10 = com.sun.mail.util.ASCIIUtility.toString(r15, r13, r10)     // Catch:{ Exception -> 0x01c8 }
            r12.append(r10)     // Catch:{ Exception -> 0x01c8 }
            java.lang.String r10 = " :"
            r12.append(r10)     // Catch:{ Exception -> 0x01c8 }
            java.lang.String r10 = r12.toString()     // Catch:{ Exception -> 0x01c8 }
            r5.println(r10)     // Catch:{ Exception -> 0x01c8 }
            goto L_0x0143
        L_0x0141:
            r16 = r13
        L_0x0143:
            byte[] r5 = r2.evaluateChallenge(r15)     // Catch:{ Exception -> 0x01c8 }
            goto L_0x014b
        L_0x0148:
            r16 = r13
            r5 = 0
        L_0x014b:
            if (r5 != 0) goto L_0x0162
            boolean r5 = r1.debug     // Catch:{ Exception -> 0x01c8 }
            if (r5 == 0) goto L_0x0158
            java.io.PrintStream r5 = r1.out     // Catch:{ Exception -> 0x01c8 }
            java.lang.String r10 = "IMAP SASL DEBUG: no response"
            r5.println(r10)     // Catch:{ Exception -> 0x01c8 }
        L_0x0158:
            r4.write(r7)     // Catch:{ Exception -> 0x01c8 }
            r4.flush()     // Catch:{ Exception -> 0x01c8 }
        L_0x015e:
            r6.reset()     // Catch:{ Exception -> 0x01c8 }
            goto L_0x01c1
        L_0x0162:
            boolean r10 = r1.debug     // Catch:{ Exception -> 0x01c8 }
            if (r10 == 0) goto L_0x0184
            java.io.PrintStream r10 = r1.out     // Catch:{ Exception -> 0x01c8 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01c8 }
            java.lang.String r13 = "IMAP SASL DEBUG: response: "
            r12.<init>(r13)     // Catch:{ Exception -> 0x01c8 }
            int r13 = r5.length     // Catch:{ Exception -> 0x01c8 }
            r15 = 0
            java.lang.String r13 = com.sun.mail.util.ASCIIUtility.toString(r5, r15, r13)     // Catch:{ Exception -> 0x01c8 }
            r12.append(r13)     // Catch:{ Exception -> 0x01c8 }
            java.lang.String r13 = " :"
            r12.append(r13)     // Catch:{ Exception -> 0x01c8 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x01c8 }
            r10.println(r12)     // Catch:{ Exception -> 0x01c8 }
        L_0x0184:
            byte[] r5 = com.sun.mail.util.BASE64EncoderStream.encode(r5)     // Catch:{ Exception -> 0x01c8 }
            if (r11 == 0) goto L_0x0193
            java.lang.String r10 = "XGWTRUSTEDAPP "
            byte[] r10 = r10.getBytes()     // Catch:{ Exception -> 0x01c8 }
            r6.write(r10)     // Catch:{ Exception -> 0x01c8 }
        L_0x0193:
            r6.write(r5)     // Catch:{ Exception -> 0x01c8 }
            r6.write(r7)     // Catch:{ Exception -> 0x01c8 }
            byte[] r5 = r6.toByteArray()     // Catch:{ Exception -> 0x01c8 }
            r4.write(r5)     // Catch:{ Exception -> 0x01c8 }
            r4.flush()     // Catch:{ Exception -> 0x01c8 }
            goto L_0x015e
        L_0x01a4:
            r16 = r13
            boolean r5 = r14.isTagged()     // Catch:{ Exception -> 0x01c8 }
            if (r5 == 0) goto L_0x01b7
            java.lang.String r5 = r14.getTag()     // Catch:{ Exception -> 0x01c8 }
            boolean r5 = r5.equals(r3)     // Catch:{ Exception -> 0x01c8 }
            if (r5 == 0) goto L_0x01b7
            goto L_0x01d5
        L_0x01b7:
            boolean r5 = r14.isBYE()     // Catch:{ Exception -> 0x01c8 }
            if (r5 == 0) goto L_0x01be
            goto L_0x01d5
        L_0x01be:
            r9.addElement(r14)     // Catch:{ Exception -> 0x01c8 }
        L_0x01c1:
            r13 = r16
            r5 = 0
            r10 = 0
            r12 = 1
            goto L_0x00b2
        L_0x01c8:
            r0 = move-exception
            r5 = r0
            boolean r10 = r1.debug     // Catch:{ all -> 0x0213 }
            if (r10 == 0) goto L_0x01d1
            r5.printStackTrace()     // Catch:{ all -> 0x0213 }
        L_0x01d1:
            com.sun.mail.iap.Response r14 = com.sun.mail.iap.Response.byeResponse(r5)     // Catch:{ all -> 0x0213 }
        L_0x01d5:
            r5 = 0
            r10 = 0
            r12 = 1
            r13 = 1
            goto L_0x00b2
        L_0x01db:
            r0 = move-exception
            r2 = r0
            boolean r3 = r1.debug     // Catch:{ all -> 0x0213 }
            if (r3 == 0) goto L_0x01f4
            java.io.PrintStream r3 = r1.out     // Catch:{ all -> 0x0213 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0213 }
            java.lang.String r5 = "IMAP SASL DEBUG: AUTHENTICATE Exception: "
            r4.<init>(r5)     // Catch:{ all -> 0x0213 }
            r4.append(r2)     // Catch:{ all -> 0x0213 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0213 }
            r3.println(r2)     // Catch:{ all -> 0x0213 }
        L_0x01f4:
            monitor-exit(r8)     // Catch:{ all -> 0x0213 }
            r2 = 0
            return r2
        L_0x01f7:
            r0 = move-exception
            r2 = r0
            boolean r3 = r1.debug     // Catch:{ all -> 0x0213 }
            if (r3 == 0) goto L_0x0210
            java.io.PrintStream r3 = r1.out     // Catch:{ all -> 0x0213 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0213 }
            java.lang.String r5 = "IMAP SASL DEBUG: Failed to create SASL client: "
            r4.<init>(r5)     // Catch:{ all -> 0x0213 }
            r4.append(r2)     // Catch:{ all -> 0x0213 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0213 }
            r3.println(r2)     // Catch:{ all -> 0x0213 }
        L_0x0210:
            monitor-exit(r8)     // Catch:{ all -> 0x0213 }
            r2 = 0
            return r2
        L_0x0213:
            r0 = move-exception
            r2 = r0
            monitor-exit(r8)     // Catch:{ all -> 0x0213 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.protocol.IMAPSaslAuthenticator.authenticate(java.lang.String[], java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}
