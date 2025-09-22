package javax.mail.internet;

import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.LineOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.MessageAware;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.MultipartDataSource;

public class MimeMultipart extends Multipart {
    private static boolean bmparse = true;
    private static boolean ignoreMissingBoundaryParameter = true;
    private static boolean ignoreMissingEndBoundary = true;
    private boolean complete;
    protected DataSource ds;
    protected boolean parsed;
    private String preamble;

    static {
        try {
            String property = System.getProperty("mail.mime.multipart.ignoremissingendboundary");
            boolean z = true;
            ignoreMissingEndBoundary = property == null || !property.equalsIgnoreCase("false");
            String property2 = System.getProperty("mail.mime.multipart.ignoremissingboundaryparameter");
            ignoreMissingBoundaryParameter = property2 == null || !property2.equalsIgnoreCase("false");
            String property3 = System.getProperty("mail.mime.multipart.bmparse");
            if (property3 != null && property3.equalsIgnoreCase("false")) {
                z = false;
            }
            bmparse = z;
        } catch (SecurityException unused) {
        }
    }

    public MimeMultipart() {
        this("mixed");
    }

    public MimeMultipart(String str) {
        this.ds = null;
        this.parsed = true;
        this.complete = true;
        this.preamble = null;
        String uniqueBoundaryValue = UniqueValue.getUniqueBoundaryValue();
        ContentType contentType = new ContentType("multipart", str, (ParameterList) null);
        contentType.setParameter("boundary", uniqueBoundaryValue);
        this.contentType = contentType.toString();
    }

    public MimeMultipart(DataSource dataSource) throws MessagingException {
        this.ds = null;
        this.parsed = true;
        this.complete = true;
        this.preamble = null;
        if (dataSource instanceof MessageAware) {
            setParent(((MessageAware) dataSource).getMessageContext().getPart());
        }
        if (dataSource instanceof MultipartDataSource) {
            setMultipartDataSource((MultipartDataSource) dataSource);
            return;
        }
        this.parsed = false;
        this.ds = dataSource;
        this.contentType = dataSource.getContentType();
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v37, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v16, resolved type: boolean} */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x014b, code lost:
        r26 = true;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:218:0x0378 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:76:0x00ec */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0193 A[Catch:{ Exception -> 0x0379, IOException -> 0x036b, all -> 0x0368, all -> 0x0383 }] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x019b A[Catch:{ Exception -> 0x0379, IOException -> 0x036b, all -> 0x0368, all -> 0x0383 }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01aa A[Catch:{ Exception -> 0x0379, IOException -> 0x036b, all -> 0x0368, all -> 0x0383 }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01b4 A[Catch:{ Exception -> 0x0379, IOException -> 0x036b, all -> 0x0368, all -> 0x0383 }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01c2 A[Catch:{ Exception -> 0x0379, IOException -> 0x036b, all -> 0x0368, all -> 0x0383 }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01ca A[Catch:{ Exception -> 0x0379, IOException -> 0x036b, all -> 0x0368, all -> 0x0383 }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01d4 A[Catch:{ Exception -> 0x0379, IOException -> 0x036b, all -> 0x0368, all -> 0x0383 }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0244 A[Catch:{ Exception -> 0x0379, IOException -> 0x036b, all -> 0x0368, all -> 0x0383 }] */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x00db A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x01ef A[EDGE_INSN: B:250:0x01ef->B:151:0x01ef ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void parsebm() throws javax.mail.MessagingException {
        /*
            r33 = this;
            r1 = r33
            monitor-enter(r33)
            boolean r2 = r1.parsed     // Catch:{ all -> 0x0383 }
            if (r2 == 0) goto L_0x0009
            monitor-exit(r33)
            return
        L_0x0009:
            javax.activation.DataSource r2 = r1.ds     // Catch:{ Exception -> 0x0379 }
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ Exception -> 0x0379 }
            boolean r3 = r2 instanceof java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0379 }
            if (r3 != 0) goto L_0x0021
            boolean r3 = r2 instanceof java.io.BufferedInputStream     // Catch:{ Exception -> 0x0379 }
            if (r3 != 0) goto L_0x0021
            boolean r3 = r2 instanceof javax.mail.internet.SharedInputStream     // Catch:{ Exception -> 0x0379 }
            if (r3 != 0) goto L_0x0021
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0379 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0379 }
            r2 = r3
        L_0x0021:
            boolean r3 = r2 instanceof javax.mail.internet.SharedInputStream     // Catch:{ all -> 0x0383 }
            if (r3 == 0) goto L_0x0029
            r3 = r2
            javax.mail.internet.SharedInputStream r3 = (javax.mail.internet.SharedInputStream) r3     // Catch:{ all -> 0x0383 }
            goto L_0x002a
        L_0x0029:
            r3 = 0
        L_0x002a:
            javax.mail.internet.ContentType r5 = new javax.mail.internet.ContentType     // Catch:{ all -> 0x0383 }
            java.lang.String r6 = r1.contentType     // Catch:{ all -> 0x0383 }
            r5.<init>(r6)     // Catch:{ all -> 0x0383 }
            java.lang.String r6 = "boundary"
            java.lang.String r5 = r5.getParameter(r6)     // Catch:{ all -> 0x0383 }
            if (r5 == 0) goto L_0x0048
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0383 }
            java.lang.String r7 = "--"
            r6.<init>(r7)     // Catch:{ all -> 0x0383 }
            r6.append(r5)     // Catch:{ all -> 0x0383 }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x0383 }
            goto L_0x0055
        L_0x0048:
            boolean r5 = ignoreMissingBoundaryParameter     // Catch:{ all -> 0x0383 }
            if (r5 != 0) goto L_0x0054
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x0383 }
            java.lang.String r3 = "Missing boundary parameter"
            r2.<init>(r3)     // Catch:{ all -> 0x0383 }
            throw r2     // Catch:{ all -> 0x0383 }
        L_0x0054:
            r5 = 0
        L_0x0055:
            com.sun.mail.util.LineInputStream r6 = new com.sun.mail.util.LineInputStream     // Catch:{ IOException -> 0x036b }
            r6.<init>(r2)     // Catch:{ IOException -> 0x036b }
            r7 = 0
            r8 = 0
        L_0x005c:
            java.lang.String r9 = r6.readLine()     // Catch:{ IOException -> 0x036b }
            r10 = 9
            r11 = 32
            r13 = 0
            r14 = 1
            if (r9 != 0) goto L_0x006a
            r4 = r9
            goto L_0x0098
        L_0x006a:
            int r15 = r9.length()     // Catch:{ IOException -> 0x036b }
            int r15 = r15 - r14
        L_0x006f:
            if (r15 >= 0) goto L_0x0072
            goto L_0x007c
        L_0x0072:
            char r4 = r9.charAt(r15)     // Catch:{ IOException -> 0x036b }
            if (r4 == r11) goto L_0x0355
            if (r4 != r10) goto L_0x007c
            goto L_0x0355
        L_0x007c:
            int r15 = r15 + 1
            java.lang.String r4 = r9.substring(r13, r15)     // Catch:{ IOException -> 0x036b }
            if (r5 == 0) goto L_0x008f
            boolean r9 = r4.equals(r5)     // Catch:{ IOException -> 0x036b }
            if (r9 == 0) goto L_0x008b
            goto L_0x0098
        L_0x008b:
            r24 = r6
            goto L_0x0329
        L_0x008f:
            java.lang.String r9 = "--"
            boolean r9 = r4.startsWith(r9)     // Catch:{ IOException -> 0x036b }
            if (r9 == 0) goto L_0x008b
            r5 = r4
        L_0x0098:
            if (r4 != 0) goto L_0x00a2
            javax.mail.MessagingException r3 = new javax.mail.MessagingException     // Catch:{ IOException -> 0x036b }
            java.lang.String r4 = "Missing start boundary"
            r3.<init>(r4)     // Catch:{ IOException -> 0x036b }
            throw r3     // Catch:{ IOException -> 0x036b }
        L_0x00a2:
            if (r7 == 0) goto L_0x00aa
            java.lang.String r4 = r7.toString()     // Catch:{ IOException -> 0x036b }
            r1.preamble = r4     // Catch:{ IOException -> 0x036b }
        L_0x00aa:
            byte[] r4 = com.sun.mail.util.ASCIIUtility.getBytes((java.lang.String) r5)     // Catch:{ IOException -> 0x036b }
            int r5 = r4.length     // Catch:{ IOException -> 0x036b }
            r7 = 256(0x100, float:3.59E-43)
            int[] r7 = new int[r7]     // Catch:{ IOException -> 0x036b }
            r8 = 0
        L_0x00b4:
            if (r8 < r5) goto L_0x030b
            int[] r8 = new int[r5]     // Catch:{ IOException -> 0x036b }
            r9 = r5
        L_0x00b9:
            if (r9 > 0) goto L_0x02d3
            int r9 = r5 + -1
            r8[r9] = r14     // Catch:{ IOException -> 0x036b }
            r16 = 0
            r18 = r16
            r15 = 0
        L_0x00c4:
            if (r15 == 0) goto L_0x00c7
            goto L_0x00e9
        L_0x00c7:
            if (r3 == 0) goto L_0x00f4
            long r16 = r3.getPosition()     // Catch:{ IOException -> 0x036b }
        L_0x00cd:
            java.lang.String r10 = r6.readLine()     // Catch:{ IOException -> 0x036b }
            if (r10 == 0) goto L_0x00d9
            int r20 = r10.length()     // Catch:{ IOException -> 0x036b }
            if (r20 > 0) goto L_0x00cd
        L_0x00d9:
            if (r10 != 0) goto L_0x00f0
            boolean r3 = ignoreMissingEndBoundary     // Catch:{ IOException -> 0x036b }
            if (r3 != 0) goto L_0x00e7
            javax.mail.MessagingException r3 = new javax.mail.MessagingException     // Catch:{ IOException -> 0x036b }
            java.lang.String r4 = "missing multipart end boundary"
            r3.<init>(r4)     // Catch:{ IOException -> 0x036b }
            throw r3     // Catch:{ IOException -> 0x036b }
        L_0x00e7:
            r1.complete = r13     // Catch:{ IOException -> 0x036b }
        L_0x00e9:
            r2.close()     // Catch:{ IOException -> 0x00ec }
        L_0x00ec:
            r1.parsed = r14     // Catch:{ all -> 0x0383 }
            monitor-exit(r33)
            return
        L_0x00f0:
            r21 = r16
            r10 = 0
            goto L_0x00fa
        L_0x00f4:
            javax.mail.internet.InternetHeaders r10 = r1.createInternetHeaders(r2)     // Catch:{ IOException -> 0x036b }
            r21 = r16
        L_0x00fa:
            boolean r16 = r2.markSupported()     // Catch:{ IOException -> 0x036b }
            if (r16 != 0) goto L_0x0108
            javax.mail.MessagingException r3 = new javax.mail.MessagingException     // Catch:{ IOException -> 0x036b }
            java.lang.String r4 = "Stream doesn't support mark"
            r3.<init>(r4)     // Catch:{ IOException -> 0x036b }
            throw r3     // Catch:{ IOException -> 0x036b }
        L_0x0108:
            if (r3 != 0) goto L_0x0110
            java.io.ByteArrayOutputStream r11 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x036b }
            r11.<init>()     // Catch:{ IOException -> 0x036b }
            goto L_0x0115
        L_0x0110:
            long r18 = r3.getPosition()     // Catch:{ IOException -> 0x036b }
            r11 = 0
        L_0x0115:
            byte[] r14 = new byte[r5]     // Catch:{ IOException -> 0x036b }
            byte[] r12 = new byte[r5]     // Catch:{ IOException -> 0x036b }
            r16 = 1
            r23 = 0
        L_0x011d:
            int r13 = r5 + 4
            int r13 = r13 + 1000
            r2.mark(r13)     // Catch:{ IOException -> 0x036b }
            r24 = r6
            r13 = 0
            int r6 = readFully(r2, r14, r13, r5)     // Catch:{ IOException -> 0x036b }
            if (r6 >= r5) goto L_0x014f
            boolean r13 = ignoreMissingEndBoundary     // Catch:{ IOException -> 0x036b }
            if (r13 != 0) goto L_0x0139
            javax.mail.MessagingException r3 = new javax.mail.MessagingException     // Catch:{ IOException -> 0x036b }
            java.lang.String r4 = "missing multipart end boundary"
            r3.<init>(r4)     // Catch:{ IOException -> 0x036b }
            throw r3     // Catch:{ IOException -> 0x036b }
        L_0x0139:
            if (r3 == 0) goto L_0x013f
            long r18 = r3.getPosition()     // Catch:{ IOException -> 0x036b }
        L_0x013f:
            r13 = 0
            r1.complete = r13     // Catch:{ IOException -> 0x036b }
            r27 = r8
            r25 = r9
            r8 = r18
            r15 = r23
            r13 = 0
        L_0x014b:
            r26 = 1
            goto L_0x01f3
        L_0x014f:
            r13 = r9
        L_0x0150:
            if (r13 >= 0) goto L_0x0157
            r25 = r9
            r26 = r15
            goto L_0x0168
        L_0x0157:
            r25 = r9
            byte r9 = r14[r13]     // Catch:{ IOException -> 0x036b }
            r26 = r15
            byte r15 = r4[r13]     // Catch:{ IOException -> 0x036b }
            if (r9 != r15) goto L_0x0168
            int r13 = r13 + -1
            r9 = r25
            r15 = r26
            goto L_0x0150
        L_0x0168:
            if (r13 >= 0) goto L_0x025e
            r9 = 13
            if (r16 != 0) goto L_0x018e
            r15 = r23
            int r23 = r15 + -1
            byte r13 = r12[r23]     // Catch:{ IOException -> 0x036b }
            if (r13 == r9) goto L_0x017b
            r9 = 10
            if (r13 != r9) goto L_0x0190
            goto L_0x017d
        L_0x017b:
            r9 = 10
        L_0x017d:
            if (r13 != r9) goto L_0x018c
            r9 = 2
            if (r15 < r9) goto L_0x018c
            int r23 = r15 + -2
            byte r9 = r12[r23]     // Catch:{ IOException -> 0x036b }
            r13 = 13
            if (r9 != r13) goto L_0x018c
            r13 = 2
            goto L_0x0191
        L_0x018c:
            r13 = 1
            goto L_0x0191
        L_0x018e:
            r15 = r23
        L_0x0190:
            r13 = 0
        L_0x0191:
            if (r16 != 0) goto L_0x0199
            if (r13 <= 0) goto L_0x0196
            goto L_0x0199
        L_0x0196:
            r27 = r8
            goto L_0x01e6
        L_0x0199:
            if (r3 == 0) goto L_0x01aa
            long r16 = r3.getPosition()     // Catch:{ IOException -> 0x036b }
            r27 = r8
            long r8 = (long) r5     // Catch:{ IOException -> 0x036b }
            long r18 = r16 - r8
            long r8 = (long) r13     // Catch:{ IOException -> 0x036b }
            long r16 = r18 - r8
            r18 = r16
            goto L_0x01ac
        L_0x01aa:
            r27 = r8
        L_0x01ac:
            int r8 = r2.read()     // Catch:{ IOException -> 0x036b }
            r9 = 45
            if (r8 != r9) goto L_0x01c2
            r28 = r8
            int r8 = r2.read()     // Catch:{ IOException -> 0x036b }
            if (r8 != r9) goto L_0x01c4
            r8 = 1
            r1.complete = r8     // Catch:{ IOException -> 0x036b }
            r8 = r18
            goto L_0x014b
        L_0x01c2:
            r28 = r8
        L_0x01c4:
            r8 = r28
        L_0x01c6:
            r9 = 32
            if (r8 == r9) goto L_0x0244
            r29 = r13
            r13 = 9
            if (r8 == r13) goto L_0x023f
            r9 = 10
            if (r8 == r9) goto L_0x01ef
            r13 = 13
            if (r8 != r13) goto L_0x01e6
            r8 = 1
            r2.mark(r8)     // Catch:{ IOException -> 0x036b }
            int r8 = r2.read()     // Catch:{ IOException -> 0x036b }
            if (r8 == r9) goto L_0x01ef
            r2.reset()     // Catch:{ IOException -> 0x036b }
            goto L_0x01ef
        L_0x01e6:
            r30 = r4
            r31 = r5
            r4 = r21
            r13 = 0
            goto L_0x0268
        L_0x01ef:
            r8 = r18
            r13 = r29
        L_0x01f3:
            if (r3 == 0) goto L_0x0204
            r30 = r4
            r31 = r5
            r4 = r21
            java.io.InputStream r6 = r3.newStream(r4, r8)     // Catch:{ IOException -> 0x036b }
            javax.mail.internet.MimeBodyPart r6 = r1.createMimeBodyPart(r6)     // Catch:{ IOException -> 0x036b }
            goto L_0x0224
        L_0x0204:
            r30 = r4
            r31 = r5
            r4 = r21
            int r13 = r15 - r13
            if (r13 <= 0) goto L_0x0212
            r15 = 0
            r11.write(r12, r15, r13)     // Catch:{ IOException -> 0x036b }
        L_0x0212:
            boolean r12 = r1.complete     // Catch:{ IOException -> 0x036b }
            if (r12 != 0) goto L_0x021c
            if (r6 <= 0) goto L_0x021c
            r12 = 0
            r11.write(r14, r12, r6)     // Catch:{ IOException -> 0x036b }
        L_0x021c:
            byte[] r6 = r11.toByteArray()     // Catch:{ IOException -> 0x036b }
            javax.mail.internet.MimeBodyPart r6 = r1.createMimeBodyPart(r10, r6)     // Catch:{ IOException -> 0x036b }
        L_0x0224:
            super.addBodyPart(r6)     // Catch:{ IOException -> 0x036b }
            r16 = r4
            r18 = r8
            r6 = r24
            r9 = r25
            r15 = r26
            r8 = r27
            r4 = r30
            r5 = r31
            r10 = 9
            r11 = 32
            r13 = 0
            r14 = 1
            goto L_0x00c4
        L_0x023f:
            r30 = r4
            r31 = r5
            goto L_0x024a
        L_0x0244:
            r30 = r4
            r31 = r5
            r29 = r13
        L_0x024a:
            r4 = r21
            r9 = 10
            r13 = 13
            int r8 = r2.read()     // Catch:{ IOException -> 0x036b }
            r21 = r4
            r13 = r29
            r4 = r30
            r5 = r31
            goto L_0x01c6
        L_0x025e:
            r30 = r4
            r31 = r5
            r27 = r8
            r4 = r21
            r15 = r23
        L_0x0268:
            int r6 = r13 + 1
            byte r8 = r14[r13]     // Catch:{ IOException -> 0x036b }
            r8 = r8 & 127(0x7f, float:1.78E-43)
            r8 = r7[r8]     // Catch:{ IOException -> 0x036b }
            int r6 = r6 - r8
            r8 = r27[r13]     // Catch:{ IOException -> 0x036b }
            int r6 = java.lang.Math.max(r6, r8)     // Catch:{ IOException -> 0x036b }
            r8 = 2
            if (r6 >= r8) goto L_0x02a7
            if (r3 != 0) goto L_0x0285
            r6 = 1
            if (r15 <= r6) goto L_0x0285
            int r6 = r15 + -1
            r8 = 0
            r11.write(r12, r8, r6)     // Catch:{ IOException -> 0x036b }
        L_0x0285:
            r2.reset()     // Catch:{ IOException -> 0x036b }
            r8 = 1
            r1.skipFully(r2, r8)     // Catch:{ IOException -> 0x036b }
            if (r15 <= 0) goto L_0x029e
            int r23 = r15 + -1
            byte r6 = r12[r23]     // Catch:{ IOException -> 0x036b }
            r8 = 0
            r12[r8] = r6     // Catch:{ IOException -> 0x036b }
            byte r6 = r14[r8]     // Catch:{ IOException -> 0x036b }
            r13 = 1
            r12[r13] = r6     // Catch:{ IOException -> 0x036b }
            r23 = 2
            goto L_0x02c0
        L_0x029e:
            r6 = 0
            r13 = 1
            byte r8 = r14[r6]     // Catch:{ IOException -> 0x036b }
            r12[r6] = r8     // Catch:{ IOException -> 0x036b }
            r23 = 1
            goto L_0x02c0
        L_0x02a7:
            r13 = 1
            if (r15 <= 0) goto L_0x02b1
            if (r3 != 0) goto L_0x02b1
            r8 = 0
            r11.write(r12, r8, r15)     // Catch:{ IOException -> 0x036b }
            goto L_0x02b2
        L_0x02b1:
            r8 = 0
        L_0x02b2:
            r2.reset()     // Catch:{ IOException -> 0x036b }
            long r8 = (long) r6     // Catch:{ IOException -> 0x036b }
            r1.skipFully(r2, r8)     // Catch:{ IOException -> 0x036b }
            r23 = r6
            r32 = r14
            r14 = r12
            r12 = r32
        L_0x02c0:
            r21 = r4
            r6 = r24
            r9 = r25
            r15 = r26
            r8 = r27
            r4 = r30
            r5 = r31
            r13 = 0
            r16 = 0
            goto L_0x011d
        L_0x02d3:
            r30 = r4
            r31 = r5
            r24 = r6
            r27 = r8
            r4 = 32
            r13 = 1
            int r5 = r31 + -1
        L_0x02e0:
            if (r5 >= r9) goto L_0x02ea
        L_0x02e2:
            if (r5 > 0) goto L_0x02e5
            goto L_0x02f9
        L_0x02e5:
            int r5 = r5 + -1
            r27[r5] = r9     // Catch:{ IOException -> 0x036b }
            goto L_0x02e2
        L_0x02ea:
            byte r6 = r30[r5]     // Catch:{ IOException -> 0x036b }
            int r8 = r5 - r9
            byte r8 = r30[r8]     // Catch:{ IOException -> 0x036b }
            if (r6 != r8) goto L_0x02f9
            int r6 = r5 + -1
            r27[r6] = r9     // Catch:{ IOException -> 0x036b }
            int r5 = r5 + -1
            goto L_0x02e0
        L_0x02f9:
            int r9 = r9 + -1
            r6 = r24
            r8 = r27
            r4 = r30
            r5 = r31
            r10 = 9
            r11 = 32
            r13 = 0
            r14 = 1
            goto L_0x00b9
        L_0x030b:
            r30 = r4
            r31 = r5
            r24 = r6
            r4 = 32
            r6 = 0
            r13 = 1
            byte r5 = r30[r8]     // Catch:{ IOException -> 0x036b }
            int r8 = r8 + 1
            r7[r5] = r8     // Catch:{ IOException -> 0x036b }
            r6 = r24
            r4 = r30
            r5 = r31
            r10 = 9
            r11 = 32
            r13 = 0
            r14 = 1
            goto L_0x00b4
        L_0x0329:
            int r6 = r4.length()     // Catch:{ IOException -> 0x036b }
            if (r6 <= 0) goto L_0x0351
            if (r8 != 0) goto L_0x033d
            java.lang.String r6 = "line.separator"
            java.lang.String r8 = "\n"
            java.lang.String r6 = java.lang.System.getProperty(r6, r8)     // Catch:{ SecurityException -> 0x033a }
            goto L_0x033c
        L_0x033a:
            java.lang.String r6 = "\n"
        L_0x033c:
            r8 = r6
        L_0x033d:
            if (r7 != 0) goto L_0x034b
            java.lang.StringBuffer r6 = new java.lang.StringBuffer     // Catch:{ IOException -> 0x036b }
            int r7 = r4.length()     // Catch:{ IOException -> 0x036b }
            r10 = 2
            int r7 = r7 + r10
            r6.<init>(r7)     // Catch:{ IOException -> 0x036b }
            r7 = r6
        L_0x034b:
            r7.append(r4)     // Catch:{ IOException -> 0x036b }
            r7.append(r8)     // Catch:{ IOException -> 0x036b }
        L_0x0351:
            r6 = r24
            goto L_0x005c
        L_0x0355:
            r24 = r6
            r4 = 32
            r6 = 0
            r10 = 2
            r13 = 1
            int r15 = r15 + -1
            r6 = r24
            r10 = 9
            r11 = 32
            r13 = 0
            r14 = 1
            goto L_0x006f
        L_0x0368:
            r0 = move-exception
            r3 = r0
            goto L_0x0375
        L_0x036b:
            r0 = move-exception
            r3 = r0
            javax.mail.MessagingException r4 = new javax.mail.MessagingException     // Catch:{ all -> 0x0368 }
            java.lang.String r5 = "IO Error"
            r4.<init>(r5, r3)     // Catch:{ all -> 0x0368 }
            throw r4     // Catch:{ all -> 0x0368 }
        L_0x0375:
            r2.close()     // Catch:{ IOException -> 0x0378 }
        L_0x0378:
            throw r3     // Catch:{ all -> 0x0383 }
        L_0x0379:
            r0 = move-exception
            r2 = r0
            javax.mail.MessagingException r3 = new javax.mail.MessagingException     // Catch:{ all -> 0x0383 }
            java.lang.String r4 = "No inputstream from datasource"
            r3.<init>(r4, r2)     // Catch:{ all -> 0x0383 }
            throw r3     // Catch:{ all -> 0x0383 }
        L_0x0383:
            r0 = move-exception
            r2 = r0
            monitor-exit(r33)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeMultipart.parsebm():void");
    }

    private static int readFully(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        while (i2 > 0) {
            int read = inputStream.read(bArr, i, i2);
            if (read <= 0) {
                break;
            }
            i += read;
            i3 += read;
            i2 -= read;
        }
        if (i3 > 0) {
            return i3;
        }
        return -1;
    }

    private void skipFully(InputStream inputStream, long j) throws IOException {
        while (j > 0) {
            long skip = inputStream.skip(j);
            if (skip <= 0) {
                throw new EOFException("can't skip");
            }
            j -= skip;
        }
    }

    public synchronized void addBodyPart(BodyPart bodyPart) throws MessagingException {
        parse();
        super.addBodyPart(bodyPart);
    }

    public synchronized void addBodyPart(BodyPart bodyPart, int i) throws MessagingException {
        parse();
        super.addBodyPart(bodyPart, i);
    }

    /* access modifiers changed from: protected */
    public InternetHeaders createInternetHeaders(InputStream inputStream) throws MessagingException {
        return new InternetHeaders(inputStream);
    }

    /* access modifiers changed from: protected */
    public MimeBodyPart createMimeBodyPart(InputStream inputStream) throws MessagingException {
        return new MimeBodyPart(inputStream);
    }

    /* access modifiers changed from: protected */
    public MimeBodyPart createMimeBodyPart(InternetHeaders internetHeaders, byte[] bArr) throws MessagingException {
        return new MimeBodyPart(internetHeaders, bArr);
    }

    public synchronized BodyPart getBodyPart(int i) throws MessagingException {
        parse();
        return super.getBodyPart(i);
    }

    public synchronized BodyPart getBodyPart(String str) throws MessagingException {
        parse();
        int count = getCount();
        for (int i = 0; i < count; i++) {
            MimeBodyPart mimeBodyPart = (MimeBodyPart) getBodyPart(i);
            String contentID = mimeBodyPart.getContentID();
            if (contentID != null && contentID.equals(str)) {
                return mimeBodyPart;
            }
        }
        return null;
    }

    public synchronized int getCount() throws MessagingException {
        parse();
        return super.getCount();
    }

    public synchronized String getPreamble() throws MessagingException {
        parse();
        return this.preamble;
    }

    public synchronized boolean isComplete() throws MessagingException {
        parse();
        return this.complete;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:181:0x024c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x00e1 */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01bb A[Catch:{ Exception -> 0x024d, IOException -> 0x023f, all -> 0x023c, all -> 0x0257 }] */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x00d0 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0187 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void parse() throws javax.mail.MessagingException {
        /*
            r25 = this;
            r1 = r25
            monitor-enter(r25)
            boolean r2 = r1.parsed     // Catch:{ all -> 0x0257 }
            if (r2 == 0) goto L_0x0009
            monitor-exit(r25)
            return
        L_0x0009:
            boolean r2 = bmparse     // Catch:{ all -> 0x0257 }
            if (r2 == 0) goto L_0x0012
            r25.parsebm()     // Catch:{ all -> 0x0257 }
            monitor-exit(r25)
            return
        L_0x0012:
            javax.activation.DataSource r2 = r1.ds     // Catch:{ Exception -> 0x024d }
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ Exception -> 0x024d }
            boolean r3 = r2 instanceof java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x024d }
            if (r3 != 0) goto L_0x002a
            boolean r3 = r2 instanceof java.io.BufferedInputStream     // Catch:{ Exception -> 0x024d }
            if (r3 != 0) goto L_0x002a
            boolean r3 = r2 instanceof javax.mail.internet.SharedInputStream     // Catch:{ Exception -> 0x024d }
            if (r3 != 0) goto L_0x002a
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x024d }
            r3.<init>(r2)     // Catch:{ Exception -> 0x024d }
            r2 = r3
        L_0x002a:
            boolean r3 = r2 instanceof javax.mail.internet.SharedInputStream     // Catch:{ all -> 0x0257 }
            if (r3 == 0) goto L_0x0032
            r3 = r2
            javax.mail.internet.SharedInputStream r3 = (javax.mail.internet.SharedInputStream) r3     // Catch:{ all -> 0x0257 }
            goto L_0x0033
        L_0x0032:
            r3 = 0
        L_0x0033:
            javax.mail.internet.ContentType r5 = new javax.mail.internet.ContentType     // Catch:{ all -> 0x0257 }
            java.lang.String r6 = r1.contentType     // Catch:{ all -> 0x0257 }
            r5.<init>(r6)     // Catch:{ all -> 0x0257 }
            java.lang.String r6 = "boundary"
            java.lang.String r5 = r5.getParameter(r6)     // Catch:{ all -> 0x0257 }
            if (r5 == 0) goto L_0x0051
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0257 }
            java.lang.String r7 = "--"
            r6.<init>(r7)     // Catch:{ all -> 0x0257 }
            r6.append(r5)     // Catch:{ all -> 0x0257 }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x0257 }
            goto L_0x005e
        L_0x0051:
            boolean r5 = ignoreMissingBoundaryParameter     // Catch:{ all -> 0x0257 }
            if (r5 != 0) goto L_0x005d
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x0257 }
            java.lang.String r3 = "Missing boundary parameter"
            r2.<init>(r3)     // Catch:{ all -> 0x0257 }
            throw r2     // Catch:{ all -> 0x0257 }
        L_0x005d:
            r5 = 0
        L_0x005e:
            com.sun.mail.util.LineInputStream r6 = new com.sun.mail.util.LineInputStream     // Catch:{ IOException -> 0x023f }
            r6.<init>(r2)     // Catch:{ IOException -> 0x023f }
            r7 = 0
            r8 = 0
        L_0x0065:
            java.lang.String r9 = r6.readLine()     // Catch:{ IOException -> 0x023f }
            r10 = 9
            r11 = 32
            r12 = 0
            r13 = 1
            if (r9 != 0) goto L_0x0072
            goto L_0x009c
        L_0x0072:
            int r14 = r9.length()     // Catch:{ IOException -> 0x023f }
            int r14 = r14 - r13
        L_0x0077:
            if (r14 >= 0) goto L_0x007a
            goto L_0x0084
        L_0x007a:
            char r15 = r9.charAt(r14)     // Catch:{ IOException -> 0x023f }
            if (r15 == r11) goto L_0x0231
            if (r15 != r10) goto L_0x0084
            goto L_0x0231
        L_0x0084:
            int r14 = r14 + 1
            java.lang.String r9 = r9.substring(r12, r14)     // Catch:{ IOException -> 0x023f }
            if (r5 == 0) goto L_0x0093
            boolean r14 = r9.equals(r5)     // Catch:{ IOException -> 0x023f }
            if (r14 == 0) goto L_0x0207
            goto L_0x009c
        L_0x0093:
            java.lang.String r14 = "--"
            boolean r14 = r9.startsWith(r14)     // Catch:{ IOException -> 0x023f }
            if (r14 == 0) goto L_0x0207
            r5 = r9
        L_0x009c:
            if (r9 != 0) goto L_0x00a6
            javax.mail.MessagingException r3 = new javax.mail.MessagingException     // Catch:{ IOException -> 0x023f }
            java.lang.String r4 = "Missing start boundary"
            r3.<init>(r4)     // Catch:{ IOException -> 0x023f }
            throw r3     // Catch:{ IOException -> 0x023f }
        L_0x00a6:
            if (r7 == 0) goto L_0x00ae
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x023f }
            r1.preamble = r7     // Catch:{ IOException -> 0x023f }
        L_0x00ae:
            byte[] r5 = com.sun.mail.util.ASCIIUtility.getBytes((java.lang.String) r5)     // Catch:{ IOException -> 0x023f }
            int r7 = r5.length     // Catch:{ IOException -> 0x023f }
            r8 = 0
            r14 = r8
            r16 = r14
            r8 = 0
        L_0x00b9:
            if (r8 == 0) goto L_0x00bc
            goto L_0x00de
        L_0x00bc:
            if (r3 == 0) goto L_0x00e7
            long r14 = r3.getPosition()     // Catch:{ IOException -> 0x023f }
        L_0x00c2:
            java.lang.String r9 = r6.readLine()     // Catch:{ IOException -> 0x023f }
            if (r9 == 0) goto L_0x00ce
            int r18 = r9.length()     // Catch:{ IOException -> 0x023f }
            if (r18 > 0) goto L_0x00c2
        L_0x00ce:
            if (r9 != 0) goto L_0x00e5
            boolean r3 = ignoreMissingEndBoundary     // Catch:{ IOException -> 0x023f }
            if (r3 != 0) goto L_0x00dc
            javax.mail.MessagingException r3 = new javax.mail.MessagingException     // Catch:{ IOException -> 0x023f }
            java.lang.String r4 = "missing multipart end boundary"
            r3.<init>(r4)     // Catch:{ IOException -> 0x023f }
            throw r3     // Catch:{ IOException -> 0x023f }
        L_0x00dc:
            r1.complete = r12     // Catch:{ IOException -> 0x023f }
        L_0x00de:
            r2.close()     // Catch:{ IOException -> 0x00e1 }
        L_0x00e1:
            r1.parsed = r13     // Catch:{ all -> 0x0257 }
            monitor-exit(r25)
            return
        L_0x00e5:
            r9 = 0
            goto L_0x00eb
        L_0x00e7:
            javax.mail.internet.InternetHeaders r9 = r1.createInternetHeaders(r2)     // Catch:{ IOException -> 0x023f }
        L_0x00eb:
            boolean r18 = r2.markSupported()     // Catch:{ IOException -> 0x023f }
            if (r18 != 0) goto L_0x00f9
            javax.mail.MessagingException r3 = new javax.mail.MessagingException     // Catch:{ IOException -> 0x023f }
            java.lang.String r4 = "Stream doesn't support mark"
            r3.<init>(r4)     // Catch:{ IOException -> 0x023f }
            throw r3     // Catch:{ IOException -> 0x023f }
        L_0x00f9:
            if (r3 != 0) goto L_0x0101
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x023f }
            r4.<init>()     // Catch:{ IOException -> 0x023f }
            goto L_0x0106
        L_0x0101:
            long r16 = r3.getPosition()     // Catch:{ IOException -> 0x023f }
            r4 = 0
        L_0x0106:
            r22 = r16
            r12 = -1
            r16 = 1
            r21 = -1
        L_0x010d:
            if (r16 == 0) goto L_0x017c
            int r10 = r7 + 4
            int r10 = r10 + 1000
            r2.mark(r10)     // Catch:{ IOException -> 0x023f }
            r10 = 0
        L_0x0117:
            if (r10 < r7) goto L_0x011a
            goto L_0x012a
        L_0x011a:
            int r11 = r2.read()     // Catch:{ IOException -> 0x023f }
            byte r13 = r5[r10]     // Catch:{ IOException -> 0x023f }
            r13 = r13 & 255(0xff, float:3.57E-43)
            if (r11 != r13) goto L_0x012a
            int r10 = r10 + 1
            r11 = 32
            r13 = 1
            goto L_0x0117
        L_0x012a:
            if (r10 != r7) goto L_0x0163
            int r10 = r2.read()     // Catch:{ IOException -> 0x023f }
            r11 = 45
            if (r10 != r11) goto L_0x013f
            int r13 = r2.read()     // Catch:{ IOException -> 0x023f }
            if (r13 != r11) goto L_0x013f
            r11 = 1
            r1.complete = r11     // Catch:{ IOException -> 0x023f }
            r8 = 1
            goto L_0x015c
        L_0x013f:
            r11 = 32
            if (r10 == r11) goto L_0x015e
            r13 = 9
            if (r10 == r13) goto L_0x015e
            r11 = 10
            if (r10 == r11) goto L_0x015c
            r13 = 13
            if (r10 != r13) goto L_0x0163
            r10 = 1
            r2.mark(r10)     // Catch:{ IOException -> 0x023f }
            int r10 = r2.read()     // Catch:{ IOException -> 0x023f }
            if (r10 == r11) goto L_0x015c
            r2.reset()     // Catch:{ IOException -> 0x023f }
        L_0x015c:
            r13 = 0
            goto L_0x0197
        L_0x015e:
            int r10 = r2.read()     // Catch:{ IOException -> 0x023f }
            goto L_0x013f
        L_0x0163:
            r2.reset()     // Catch:{ IOException -> 0x023f }
            if (r4 == 0) goto L_0x017c
            r10 = -1
            if (r12 == r10) goto L_0x0179
            r4.write(r12)     // Catch:{ IOException -> 0x023f }
            r11 = r21
            if (r11 == r10) goto L_0x0175
            r4.write(r11)     // Catch:{ IOException -> 0x023f }
        L_0x0175:
            r12 = -1
            r21 = -1
            goto L_0x0181
        L_0x0179:
            r11 = r21
            goto L_0x017f
        L_0x017c:
            r11 = r21
            r10 = -1
        L_0x017f:
            r21 = r11
        L_0x0181:
            int r11 = r2.read()     // Catch:{ IOException -> 0x023f }
            if (r11 >= 0) goto L_0x01bb
            boolean r8 = ignoreMissingEndBoundary     // Catch:{ IOException -> 0x023f }
            if (r8 != 0) goto L_0x0193
            javax.mail.MessagingException r3 = new javax.mail.MessagingException     // Catch:{ IOException -> 0x023f }
            java.lang.String r4 = "missing multipart end boundary"
            r3.<init>(r4)     // Catch:{ IOException -> 0x023f }
            throw r3     // Catch:{ IOException -> 0x023f }
        L_0x0193:
            r13 = 0
            r1.complete = r13     // Catch:{ IOException -> 0x023f }
            r8 = 1
        L_0x0197:
            if (r3 == 0) goto L_0x01a4
            r10 = r22
            java.io.InputStream r4 = r3.newStream(r14, r10)     // Catch:{ IOException -> 0x023f }
            javax.mail.internet.MimeBodyPart r4 = r1.createMimeBodyPart(r4)     // Catch:{ IOException -> 0x023f }
            goto L_0x01ae
        L_0x01a4:
            r10 = r22
            byte[] r4 = r4.toByteArray()     // Catch:{ IOException -> 0x023f }
            javax.mail.internet.MimeBodyPart r4 = r1.createMimeBodyPart(r9, r4)     // Catch:{ IOException -> 0x023f }
        L_0x01ae:
            super.addBodyPart(r4)     // Catch:{ IOException -> 0x023f }
            r16 = r10
            r10 = 9
            r11 = 32
            r12 = 0
            r13 = 1
            goto L_0x00b9
        L_0x01bb:
            r16 = r22
            r10 = 13
            r13 = 0
            if (r11 == r10) goto L_0x01d5
            r10 = 10
            if (r11 != r10) goto L_0x01c7
            goto L_0x01d5
        L_0x01c7:
            if (r4 == 0) goto L_0x01cc
            r4.write(r11)     // Catch:{ IOException -> 0x023f }
        L_0x01cc:
            r22 = r16
            r11 = 32
            r13 = 1
            r16 = 0
            goto L_0x010d
        L_0x01d5:
            if (r3 == 0) goto L_0x01e0
            long r16 = r3.getPosition()     // Catch:{ IOException -> 0x023f }
            r19 = 1
            long r22 = r16 - r19
            goto L_0x01e2
        L_0x01e0:
            r22 = r16
        L_0x01e2:
            r10 = 13
            if (r11 != r10) goto L_0x01ff
            r10 = 1
            r2.mark(r10)     // Catch:{ IOException -> 0x023f }
            int r12 = r2.read()     // Catch:{ IOException -> 0x023f }
            r10 = 10
            if (r12 != r10) goto L_0x01fc
            r21 = r12
            r13 = 1
            r16 = 1
            r12 = r11
            r11 = 32
            goto L_0x010d
        L_0x01fc:
            r2.reset()     // Catch:{ IOException -> 0x023f }
        L_0x01ff:
            r12 = r11
            r11 = 32
            r13 = 1
            r16 = 1
            goto L_0x010d
        L_0x0207:
            int r4 = r9.length()     // Catch:{ IOException -> 0x023f }
            if (r4 <= 0) goto L_0x0065
            if (r8 != 0) goto L_0x021b
            java.lang.String r4 = "line.separator"
            java.lang.String r8 = "\n"
            java.lang.String r4 = java.lang.System.getProperty(r4, r8)     // Catch:{ SecurityException -> 0x0218 }
            goto L_0x021a
        L_0x0218:
            java.lang.String r4 = "\n"
        L_0x021a:
            r8 = r4
        L_0x021b:
            if (r7 != 0) goto L_0x0229
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch:{ IOException -> 0x023f }
            int r7 = r9.length()     // Catch:{ IOException -> 0x023f }
            int r7 = r7 + 2
            r4.<init>(r7)     // Catch:{ IOException -> 0x023f }
            r7 = r4
        L_0x0229:
            r7.append(r9)     // Catch:{ IOException -> 0x023f }
            r7.append(r8)     // Catch:{ IOException -> 0x023f }
            goto L_0x0065
        L_0x0231:
            r13 = 0
            int r14 = r14 + -1
            r10 = 9
            r11 = 32
            r12 = 0
            r13 = 1
            goto L_0x0077
        L_0x023c:
            r0 = move-exception
            r3 = r0
            goto L_0x0249
        L_0x023f:
            r0 = move-exception
            r3 = r0
            javax.mail.MessagingException r4 = new javax.mail.MessagingException     // Catch:{ all -> 0x023c }
            java.lang.String r5 = "IO Error"
            r4.<init>(r5, r3)     // Catch:{ all -> 0x023c }
            throw r4     // Catch:{ all -> 0x023c }
        L_0x0249:
            r2.close()     // Catch:{ IOException -> 0x024c }
        L_0x024c:
            throw r3     // Catch:{ all -> 0x0257 }
        L_0x024d:
            r0 = move-exception
            r2 = r0
            javax.mail.MessagingException r3 = new javax.mail.MessagingException     // Catch:{ all -> 0x0257 }
            java.lang.String r4 = "No inputstream from datasource"
            r3.<init>(r4, r2)     // Catch:{ all -> 0x0257 }
            throw r3     // Catch:{ all -> 0x0257 }
        L_0x0257:
            r0 = move-exception
            r2 = r0
            monitor-exit(r25)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeMultipart.parse():void");
    }

    public void removeBodyPart(int i) throws MessagingException {
        parse();
        super.removeBodyPart(i);
    }

    public boolean removeBodyPart(BodyPart bodyPart) throws MessagingException {
        parse();
        return super.removeBodyPart(bodyPart);
    }

    public synchronized void setPreamble(String str) throws MessagingException {
        this.preamble = str;
    }

    public synchronized void setSubType(String str) throws MessagingException {
        ContentType contentType = new ContentType(this.contentType);
        contentType.setSubType(str);
        this.contentType = contentType.toString();
    }

    /* access modifiers changed from: protected */
    public void updateHeaders() throws MessagingException {
        for (int i = 0; i < this.parts.size(); i++) {
            ((MimeBodyPart) this.parts.elementAt(i)).updateHeaders();
        }
    }

    public synchronized void writeTo(OutputStream outputStream) throws IOException, MessagingException {
        parse();
        String str = "--" + new ContentType(this.contentType).getParameter("boundary");
        LineOutputStream lineOutputStream = new LineOutputStream(outputStream);
        if (this.preamble != null) {
            byte[] bytes = ASCIIUtility.getBytes(this.preamble);
            lineOutputStream.write(bytes);
            if (!(bytes.length <= 0 || bytes[bytes.length - 1] == 13 || bytes[bytes.length - 1] == 10)) {
                lineOutputStream.writeln();
            }
        }
        for (int i = 0; i < this.parts.size(); i++) {
            lineOutputStream.writeln(str);
            ((MimeBodyPart) this.parts.elementAt(i)).writeTo(outputStream);
            lineOutputStream.writeln();
        }
        lineOutputStream.writeln(String.valueOf(str) + "--");
    }
}
