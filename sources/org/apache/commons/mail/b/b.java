package org.apache.commons.mail.b;

import java.io.InputStream;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

public final class b {
    private b() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static javax.mail.internet.MimeMessage a(javax.mail.Session r2, java.io.File r3) throws javax.mail.MessagingException, java.io.IOException {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0011 }
            r1.<init>(r3)     // Catch:{ all -> 0x0011 }
            javax.mail.internet.MimeMessage r2 = a((javax.mail.Session) r2, (java.io.InputStream) r1)     // Catch:{ all -> 0x000e }
            r1.close()
            return r2
        L_0x000e:
            r2 = move-exception
            r0 = r1
            goto L_0x0012
        L_0x0011:
            r2 = move-exception
        L_0x0012:
            if (r0 == 0) goto L_0x0017
            r0.close()
        L_0x0017:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.mail.b.b.a(javax.mail.Session, java.io.File):javax.mail.internet.MimeMessage");
    }

    private static MimeMessage a(Session session, InputStream inputStream) throws MessagingException {
        return new MimeMessage(session, inputStream);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static javax.mail.internet.MimeMessage a(javax.mail.Session r2, java.lang.String r3) throws javax.mail.MessagingException, java.io.IOException {
        /*
            r0 = 0
            byte[] r3 = r3.getBytes()     // Catch:{ all -> 0x0015 }
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0015 }
            r1.<init>(r3)     // Catch:{ all -> 0x0015 }
            javax.mail.internet.MimeMessage r2 = a((javax.mail.Session) r2, (java.io.InputStream) r1)     // Catch:{ all -> 0x0012 }
            r1.close()
            return r2
        L_0x0012:
            r2 = move-exception
            r0 = r1
            goto L_0x0016
        L_0x0015:
            r2 = move-exception
        L_0x0016:
            if (r0 == 0) goto L_0x001b
            r0.close()
        L_0x001b:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.mail.b.b.a(javax.mail.Session, java.lang.String):javax.mail.internet.MimeMessage");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0015  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static javax.mail.internet.MimeMessage a(javax.mail.Session r2, byte[] r3) throws javax.mail.MessagingException, java.io.IOException {
        /*
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0012 }
            r1.<init>(r3)     // Catch:{ all -> 0x0012 }
            javax.mail.internet.MimeMessage r3 = new javax.mail.internet.MimeMessage     // Catch:{ all -> 0x000f }
            r3.<init>((javax.mail.Session) r2, (java.io.InputStream) r1)     // Catch:{ all -> 0x000f }
            r1.close()
            return r3
        L_0x000f:
            r2 = move-exception
            r0 = r1
            goto L_0x0013
        L_0x0012:
            r2 = move-exception
        L_0x0013:
            if (r0 == 0) goto L_0x0018
            r0.close()
        L_0x0018:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.mail.b.b.a(javax.mail.Session, byte[]):javax.mail.internet.MimeMessage");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042 A[SYNTHETIC, Splitter:B:16:0x0042] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(javax.mail.internet.MimeMessage r3, java.io.File r4) throws javax.mail.MessagingException, java.io.IOException {
        /*
            r0 = 0
            java.io.File r1 = r4.getParentFile()     // Catch:{ all -> 0x003f }
            boolean r1 = r1.exists()     // Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x002d
            java.io.File r1 = r4.getParentFile()     // Catch:{ all -> 0x003f }
            boolean r1 = r1.mkdirs()     // Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x002d
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x003f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x003f }
            java.lang.String r2 = "Failed to create the following parent directories: "
            r1.<init>(r2)     // Catch:{ all -> 0x003f }
            java.io.File r4 = r4.getParentFile()     // Catch:{ all -> 0x003f }
            r1.append(r4)     // Catch:{ all -> 0x003f }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x003f }
            r3.<init>(r4)     // Catch:{ all -> 0x003f }
            throw r3     // Catch:{ all -> 0x003f }
        L_0x002d:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x003f }
            r1.<init>(r4)     // Catch:{ all -> 0x003f }
            r3.writeTo(r1)     // Catch:{ all -> 0x003c }
            r1.flush()     // Catch:{ all -> 0x003c }
            r1.close()     // Catch:{ all -> 0x003c }
            return
        L_0x003c:
            r3 = move-exception
            r0 = r1
            goto L_0x0040
        L_0x003f:
            r3 = move-exception
        L_0x0040:
            if (r0 == 0) goto L_0x004a
            r0.close()     // Catch:{ Exception -> 0x0046 }
            goto L_0x004a
        L_0x0046:
            r4 = move-exception
            r4.printStackTrace()
        L_0x004a:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.mail.b.b.a(javax.mail.internet.MimeMessage, java.io.File):void");
    }
}
