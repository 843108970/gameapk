package com.sun.mail.imap;

import com.cyjh.common.util.s;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.imap.protocol.BODY;
import com.sun.mail.imap.protocol.BODYSTRUCTURE;
import com.sun.mail.imap.protocol.ENVELOPE;
import com.sun.mail.imap.protocol.FetchResponse;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.imap.protocol.INTERNALDATE;
import com.sun.mail.imap.protocol.Item;
import com.sun.mail.imap.protocol.RFC822DATA;
import com.sun.mail.imap.protocol.RFC822SIZE;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.IllegalWriteException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import org.litepal.g.b;

public class IMAPMessage extends MimeMessage {
    private static String EnvelopeCmd = "ENVELOPE INTERNALDATE RFC822.SIZE";
    protected BODYSTRUCTURE bs;
    private String description;
    protected ENVELOPE envelope;
    private boolean headersLoaded = false;
    private Hashtable loadedHeaders;
    private boolean peek;
    private Date receivedDate;
    protected String sectionId;
    private int seqnum;
    /* access modifiers changed from: private */
    public int size = -1;
    private String subject;
    private String type;
    private long uid = -1;

    protected IMAPMessage(IMAPFolder iMAPFolder, int i, int i2) {
        super((Folder) iMAPFolder, i);
        this.seqnum = i2;
        this.flags = null;
    }

    protected IMAPMessage(Session session) {
        super(session);
    }

    /* access modifiers changed from: private */
    public BODYSTRUCTURE _getBodyStructure() {
        return this.bs;
    }

    /* access modifiers changed from: private */
    public ENVELOPE _getEnvelope() {
        return this.envelope;
    }

    /* access modifiers changed from: private */
    public Flags _getFlags() {
        return this.flags;
    }

    private InternetAddress[] aaclone(InternetAddress[] internetAddressArr) {
        if (internetAddressArr == null) {
            return null;
        }
        return (InternetAddress[]) internetAddressArr.clone();
    }

    /* access modifiers changed from: private */
    public synchronized boolean areHeadersLoaded() {
        return this.headersLoaded;
    }

    private static String craftHeaderCmd(IMAPProtocol iMAPProtocol, String[] strArr) {
        StringBuffer stringBuffer = iMAPProtocol.isREV1() ? new StringBuffer("BODY.PEEK[HEADER.FIELDS (") : new StringBuffer("RFC822.HEADER.LINES (");
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(s.a.f1696a);
            }
            stringBuffer.append(strArr[i]);
        }
        stringBuffer.append(iMAPProtocol.isREV1() ? ")]" : ")");
        return stringBuffer.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: com.sun.mail.imap.protocol.FetchResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: com.sun.mail.imap.protocol.FetchResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: com.sun.mail.imap.protocol.FetchResponse} */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00ee, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01de A[Catch:{ ConnectionException -> 0x0203, CommandFailedException -> 0x00d6, ProtocolException -> 0x00ca, all -> 0x020f }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01e3 A[Catch:{ ConnectionException -> 0x0203, CommandFailedException -> 0x00d6, ProtocolException -> 0x00ca, all -> 0x020f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void fetch(com.sun.mail.imap.IMAPFolder r17, javax.mail.Message[] r18, javax.mail.FetchProfile r19) throws javax.mail.MessagingException {
        /*
            r1 = r17
            r2 = r19
            java.lang.StringBuffer r3 = new java.lang.StringBuffer
            r3.<init>()
            javax.mail.FetchProfile$Item r4 = javax.mail.FetchProfile.Item.ENVELOPE
            boolean r4 = r2.contains((javax.mail.FetchProfile.Item) r4)
            if (r4 == 0) goto L_0x0018
            java.lang.String r4 = EnvelopeCmd
            r3.append(r4)
            r4 = 0
            goto L_0x0019
        L_0x0018:
            r4 = 1
        L_0x0019:
            javax.mail.FetchProfile$Item r7 = javax.mail.FetchProfile.Item.FLAGS
            boolean r7 = r2.contains((javax.mail.FetchProfile.Item) r7)
            if (r7 == 0) goto L_0x002c
            if (r4 == 0) goto L_0x0026
            java.lang.String r4 = "FLAGS"
            goto L_0x0028
        L_0x0026:
            java.lang.String r4 = " FLAGS"
        L_0x0028:
            r3.append(r4)
            r4 = 0
        L_0x002c:
            javax.mail.FetchProfile$Item r7 = javax.mail.FetchProfile.Item.CONTENT_INFO
            boolean r7 = r2.contains((javax.mail.FetchProfile.Item) r7)
            if (r7 == 0) goto L_0x003f
            if (r4 == 0) goto L_0x0039
            java.lang.String r4 = "BODYSTRUCTURE"
            goto L_0x003b
        L_0x0039:
            java.lang.String r4 = " BODYSTRUCTURE"
        L_0x003b:
            r3.append(r4)
            r4 = 0
        L_0x003f:
            javax.mail.UIDFolder$FetchProfileItem r7 = javax.mail.UIDFolder.FetchProfileItem.UID
            boolean r7 = r2.contains((javax.mail.FetchProfile.Item) r7)
            if (r7 == 0) goto L_0x0052
            if (r4 == 0) goto L_0x004c
            java.lang.String r4 = "UID"
            goto L_0x004e
        L_0x004c:
            java.lang.String r4 = " UID"
        L_0x004e:
            r3.append(r4)
            r4 = 0
        L_0x0052:
            com.sun.mail.imap.IMAPFolder$FetchProfileItem r7 = com.sun.mail.imap.IMAPFolder.FetchProfileItem.HEADERS
            boolean r7 = r2.contains((javax.mail.FetchProfile.Item) r7)
            if (r7 == 0) goto L_0x0078
            com.sun.mail.imap.protocol.IMAPProtocol r7 = r1.protocol
            boolean r7 = r7.isREV1()
            if (r7 == 0) goto L_0x006d
            if (r4 == 0) goto L_0x0067
            java.lang.String r4 = "BODY.PEEK[HEADER]"
            goto L_0x0069
        L_0x0067:
            java.lang.String r4 = " BODY.PEEK[HEADER]"
        L_0x0069:
            r3.append(r4)
            goto L_0x0075
        L_0x006d:
            if (r4 == 0) goto L_0x0072
            java.lang.String r4 = "RFC822.HEADER"
            goto L_0x0069
        L_0x0072:
            java.lang.String r4 = " RFC822.HEADER"
            goto L_0x0069
        L_0x0075:
            r4 = 0
            r7 = 1
            goto L_0x0079
        L_0x0078:
            r7 = 0
        L_0x0079:
            com.sun.mail.imap.IMAPFolder$FetchProfileItem r8 = com.sun.mail.imap.IMAPFolder.FetchProfileItem.SIZE
            boolean r8 = r2.contains((javax.mail.FetchProfile.Item) r8)
            if (r8 == 0) goto L_0x008c
            if (r4 == 0) goto L_0x0086
            java.lang.String r4 = "RFC822.SIZE"
            goto L_0x0088
        L_0x0086:
            java.lang.String r4 = " RFC822.SIZE"
        L_0x0088:
            r3.append(r4)
            r4 = 0
        L_0x008c:
            r8 = 0
            if (r7 != 0) goto L_0x00a7
            java.lang.String[] r9 = r19.getHeaderNames()
            int r10 = r9.length
            if (r10 <= 0) goto L_0x00a8
            if (r4 != 0) goto L_0x009d
            java.lang.String r4 = " "
            r3.append(r4)
        L_0x009d:
            com.sun.mail.imap.protocol.IMAPProtocol r4 = r1.protocol
            java.lang.String r4 = craftHeaderCmd(r4, r9)
            r3.append(r4)
            goto L_0x00a8
        L_0x00a7:
            r9 = r8
        L_0x00a8:
            com.sun.mail.imap.IMAPMessage$1FetchProfileCondition r4 = new com.sun.mail.imap.IMAPMessage$1FetchProfileCondition
            r4.<init>(r2)
            java.lang.Object r10 = r1.messageCacheLock
            monitor-enter(r10)
            r11 = r18
            com.sun.mail.imap.protocol.MessageSet[] r4 = com.sun.mail.imap.Utility.toMessageSet(r11, r4)     // Catch:{ all -> 0x020f }
            if (r4 != 0) goto L_0x00ba
            monitor-exit(r10)     // Catch:{ all -> 0x020f }
            return
        L_0x00ba:
            java.util.Vector r11 = new java.util.Vector     // Catch:{ all -> 0x020f }
            r11.<init>()     // Catch:{ all -> 0x020f }
            com.sun.mail.imap.protocol.IMAPProtocol r12 = r1.protocol     // Catch:{ ConnectionException -> 0x0203, CommandFailedException -> 0x00d6, ProtocolException -> 0x00ca }
            java.lang.String r3 = r3.toString()     // Catch:{ ConnectionException -> 0x0203, CommandFailedException -> 0x00d6, ProtocolException -> 0x00ca }
            com.sun.mail.iap.Response[] r3 = r12.fetch((com.sun.mail.imap.protocol.MessageSet[]) r4, (java.lang.String) r3)     // Catch:{ ConnectionException -> 0x0203, CommandFailedException -> 0x00d6, ProtocolException -> 0x00ca }
            goto L_0x00d7
        L_0x00ca:
            r0 = move-exception
            r1 = r0
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x020f }
            java.lang.String r3 = r1.getMessage()     // Catch:{ all -> 0x020f }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x020f }
            throw r2     // Catch:{ all -> 0x020f }
        L_0x00d6:
            r3 = r8
        L_0x00d7:
            if (r3 != 0) goto L_0x00db
            monitor-exit(r10)     // Catch:{ all -> 0x020f }
            return
        L_0x00db:
            r4 = 0
        L_0x00dc:
            int r8 = r3.length     // Catch:{ all -> 0x020f }
            if (r4 < r8) goto L_0x00ef
            int r2 = r11.size()     // Catch:{ all -> 0x020f }
            if (r2 == 0) goto L_0x00ed
            com.sun.mail.iap.Response[] r2 = new com.sun.mail.iap.Response[r2]     // Catch:{ all -> 0x020f }
            r11.copyInto(r2)     // Catch:{ all -> 0x020f }
            r1.handleResponses(r2)     // Catch:{ all -> 0x020f }
        L_0x00ed:
            monitor-exit(r10)     // Catch:{ all -> 0x020f }
            return
        L_0x00ef:
            r8 = r3[r4]     // Catch:{ all -> 0x020f }
            if (r8 == 0) goto L_0x01f8
            r8 = r3[r4]     // Catch:{ all -> 0x020f }
            boolean r8 = r8 instanceof com.sun.mail.imap.protocol.FetchResponse     // Catch:{ all -> 0x020f }
            if (r8 != 0) goto L_0x0100
            r8 = r3[r4]     // Catch:{ all -> 0x020f }
        L_0x00fb:
            r11.addElement(r8)     // Catch:{ all -> 0x020f }
            goto L_0x01f8
        L_0x0100:
            r8 = r3[r4]     // Catch:{ all -> 0x020f }
            com.sun.mail.imap.protocol.FetchResponse r8 = (com.sun.mail.imap.protocol.FetchResponse) r8     // Catch:{ all -> 0x020f }
            int r12 = r8.getNumber()     // Catch:{ all -> 0x020f }
            com.sun.mail.imap.IMAPMessage r12 = r1.getMessageBySeqNumber(r12)     // Catch:{ all -> 0x020f }
            int r13 = r8.getItemCount()     // Catch:{ all -> 0x020f }
            r14 = 0
            r15 = 0
        L_0x0112:
            if (r14 < r13) goto L_0x0117
            if (r15 == 0) goto L_0x01f8
            goto L_0x00fb
        L_0x0117:
            com.sun.mail.imap.protocol.Item r6 = r8.getItem((int) r14)     // Catch:{ all -> 0x020f }
            boolean r5 = r6 instanceof javax.mail.Flags     // Catch:{ all -> 0x020f }
            if (r5 == 0) goto L_0x0135
            javax.mail.FetchProfile$Item r5 = javax.mail.FetchProfile.Item.FLAGS     // Catch:{ all -> 0x020f }
            boolean r5 = r2.contains((javax.mail.FetchProfile.Item) r5)     // Catch:{ all -> 0x020f }
            if (r5 == 0) goto L_0x012f
            if (r12 != 0) goto L_0x012a
            goto L_0x012f
        L_0x012a:
            javax.mail.Flags r6 = (javax.mail.Flags) r6     // Catch:{ all -> 0x020f }
            r12.flags = r6     // Catch:{ all -> 0x020f }
            goto L_0x013d
        L_0x012f:
            r16 = r3
            r2 = 1
            r15 = 1
            goto L_0x01e8
        L_0x0135:
            boolean r5 = r6 instanceof com.sun.mail.imap.protocol.ENVELOPE     // Catch:{ all -> 0x020f }
            if (r5 == 0) goto L_0x0142
            com.sun.mail.imap.protocol.ENVELOPE r6 = (com.sun.mail.imap.protocol.ENVELOPE) r6     // Catch:{ all -> 0x020f }
            r12.envelope = r6     // Catch:{ all -> 0x020f }
        L_0x013d:
            r16 = r3
        L_0x013f:
            r2 = 1
            goto L_0x01e8
        L_0x0142:
            boolean r5 = r6 instanceof com.sun.mail.imap.protocol.INTERNALDATE     // Catch:{ all -> 0x020f }
            if (r5 == 0) goto L_0x014f
            com.sun.mail.imap.protocol.INTERNALDATE r6 = (com.sun.mail.imap.protocol.INTERNALDATE) r6     // Catch:{ all -> 0x020f }
            java.util.Date r5 = r6.getDate()     // Catch:{ all -> 0x020f }
            r12.receivedDate = r5     // Catch:{ all -> 0x020f }
            goto L_0x013d
        L_0x014f:
            boolean r5 = r6 instanceof com.sun.mail.imap.protocol.RFC822SIZE     // Catch:{ all -> 0x020f }
            if (r5 == 0) goto L_0x015a
            com.sun.mail.imap.protocol.RFC822SIZE r6 = (com.sun.mail.imap.protocol.RFC822SIZE) r6     // Catch:{ all -> 0x020f }
            int r5 = r6.size     // Catch:{ all -> 0x020f }
            r12.size = r5     // Catch:{ all -> 0x020f }
            goto L_0x013d
        L_0x015a:
            boolean r5 = r6 instanceof com.sun.mail.imap.protocol.BODYSTRUCTURE     // Catch:{ all -> 0x020f }
            if (r5 == 0) goto L_0x0163
            com.sun.mail.imap.protocol.BODYSTRUCTURE r6 = (com.sun.mail.imap.protocol.BODYSTRUCTURE) r6     // Catch:{ all -> 0x020f }
            r12.bs = r6     // Catch:{ all -> 0x020f }
            goto L_0x013d
        L_0x0163:
            boolean r5 = r6 instanceof com.sun.mail.imap.protocol.UID     // Catch:{ all -> 0x020f }
            if (r5 == 0) goto L_0x0187
            com.sun.mail.imap.protocol.UID r6 = (com.sun.mail.imap.protocol.UID) r6     // Catch:{ all -> 0x020f }
            r16 = r3
            long r2 = r6.uid     // Catch:{ all -> 0x020f }
            r12.uid = r2     // Catch:{ all -> 0x020f }
            java.util.Hashtable r2 = r1.uidTable     // Catch:{ all -> 0x020f }
            if (r2 != 0) goto L_0x017a
            java.util.Hashtable r2 = new java.util.Hashtable     // Catch:{ all -> 0x020f }
            r2.<init>()     // Catch:{ all -> 0x020f }
            r1.uidTable = r2     // Catch:{ all -> 0x020f }
        L_0x017a:
            java.util.Hashtable r2 = r1.uidTable     // Catch:{ all -> 0x020f }
            java.lang.Long r3 = new java.lang.Long     // Catch:{ all -> 0x020f }
            long r5 = r6.uid     // Catch:{ all -> 0x020f }
            r3.<init>(r5)     // Catch:{ all -> 0x020f }
            r2.put(r3, r12)     // Catch:{ all -> 0x020f }
            goto L_0x013f
        L_0x0187:
            r16 = r3
            boolean r2 = r6 instanceof com.sun.mail.imap.protocol.RFC822DATA     // Catch:{ all -> 0x020f }
            if (r2 != 0) goto L_0x0191
            boolean r2 = r6 instanceof com.sun.mail.imap.protocol.BODY     // Catch:{ all -> 0x020f }
            if (r2 == 0) goto L_0x013f
        L_0x0191:
            boolean r2 = r6 instanceof com.sun.mail.imap.protocol.RFC822DATA     // Catch:{ all -> 0x020f }
            if (r2 == 0) goto L_0x019c
            com.sun.mail.imap.protocol.RFC822DATA r6 = (com.sun.mail.imap.protocol.RFC822DATA) r6     // Catch:{ all -> 0x020f }
            java.io.ByteArrayInputStream r2 = r6.getByteArrayInputStream()     // Catch:{ all -> 0x020f }
            goto L_0x01a2
        L_0x019c:
            com.sun.mail.imap.protocol.BODY r6 = (com.sun.mail.imap.protocol.BODY) r6     // Catch:{ all -> 0x020f }
            java.io.ByteArrayInputStream r2 = r6.getByteArrayInputStream()     // Catch:{ all -> 0x020f }
        L_0x01a2:
            javax.mail.internet.InternetHeaders r3 = new javax.mail.internet.InternetHeaders     // Catch:{ all -> 0x020f }
            r3.<init>()     // Catch:{ all -> 0x020f }
            r3.load(r2)     // Catch:{ all -> 0x020f }
            javax.mail.internet.InternetHeaders r2 = r12.headers     // Catch:{ all -> 0x020f }
            if (r2 == 0) goto L_0x01da
            if (r7 == 0) goto L_0x01b1
            goto L_0x01da
        L_0x01b1:
            java.util.Enumeration r2 = r3.getAllHeaders()     // Catch:{ all -> 0x020f }
        L_0x01b5:
            boolean r3 = r2.hasMoreElements()     // Catch:{ all -> 0x020f }
            if (r3 != 0) goto L_0x01bc
            goto L_0x01dc
        L_0x01bc:
            java.lang.Object r3 = r2.nextElement()     // Catch:{ all -> 0x020f }
            javax.mail.Header r3 = (javax.mail.Header) r3     // Catch:{ all -> 0x020f }
            java.lang.String r5 = r3.getName()     // Catch:{ all -> 0x020f }
            boolean r5 = r12.isHeaderLoaded(r5)     // Catch:{ all -> 0x020f }
            if (r5 != 0) goto L_0x01b5
            javax.mail.internet.InternetHeaders r5 = r12.headers     // Catch:{ all -> 0x020f }
            java.lang.String r6 = r3.getName()     // Catch:{ all -> 0x020f }
            java.lang.String r3 = r3.getValue()     // Catch:{ all -> 0x020f }
            r5.addHeader(r6, r3)     // Catch:{ all -> 0x020f }
            goto L_0x01b5
        L_0x01da:
            r12.headers = r3     // Catch:{ all -> 0x020f }
        L_0x01dc:
            if (r7 == 0) goto L_0x01e3
            r2 = 1
            r12.setHeadersLoaded(r2)     // Catch:{ all -> 0x020f }
            goto L_0x01e8
        L_0x01e3:
            r2 = 1
            r3 = 0
        L_0x01e5:
            int r5 = r9.length     // Catch:{ all -> 0x020f }
            if (r3 < r5) goto L_0x01f0
        L_0x01e8:
            int r14 = r14 + 1
            r3 = r16
            r2 = r19
            goto L_0x0112
        L_0x01f0:
            r5 = r9[r3]     // Catch:{ all -> 0x020f }
            r12.setHeaderLoaded(r5)     // Catch:{ all -> 0x020f }
            int r3 = r3 + 1
            goto L_0x01e5
        L_0x01f8:
            r16 = r3
            r2 = 1
            int r4 = r4 + 1
            r3 = r16
            r2 = r19
            goto L_0x00dc
        L_0x0203:
            r0 = move-exception
            r2 = r0
            javax.mail.FolderClosedException r3 = new javax.mail.FolderClosedException     // Catch:{ all -> 0x020f }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x020f }
            r3.<init>(r1, r2)     // Catch:{ all -> 0x020f }
            throw r3     // Catch:{ all -> 0x020f }
        L_0x020f:
            r0 = move-exception
            r1 = r0
            monitor-exit(r10)     // Catch:{ all -> 0x020f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPMessage.fetch(com.sun.mail.imap.IMAPFolder, javax.mail.Message[], javax.mail.FetchProfile):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0007, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean isHeaderLoaded(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.headersLoaded     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x0008
            r3 = 1
        L_0x0006:
            monitor-exit(r2)
            return r3
        L_0x0008:
            java.util.Hashtable r0 = r2.loadedHeaders     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x001a
            java.util.Hashtable r0 = r2.loadedHeaders     // Catch:{ all -> 0x001c }
            java.util.Locale r1 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x001c }
            java.lang.String r3 = r3.toUpperCase(r1)     // Catch:{ all -> 0x001c }
            boolean r3 = r0.containsKey(r3)     // Catch:{ all -> 0x001c }
            monitor-exit(r2)
            return r3
        L_0x001a:
            r3 = 0
            goto L_0x0006
        L_0x001c:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPMessage.isHeaderLoaded(java.lang.String):boolean");
    }

    private synchronized void loadBODYSTRUCTURE() throws MessagingException {
        if (this.bs == null) {
            synchronized (getMessageCacheLock()) {
                try {
                    IMAPProtocol protocol = getProtocol();
                    checkExpunged();
                    this.bs = protocol.fetchBodyStructure(getSequenceNumber());
                    if (this.bs == null) {
                        forceCheckExpunged();
                        throw new MessagingException("Unable to load BODYSTRUCTURE");
                    }
                } catch (ConnectionException e) {
                    throw new FolderClosedException(this.folder, e.getMessage());
                } catch (ProtocolException e2) {
                    forceCheckExpunged();
                    throw new MessagingException(e2.getMessage(), e2);
                }
            }
        }
    }

    private synchronized void loadEnvelope() throws MessagingException {
        if (this.envelope == null) {
            synchronized (getMessageCacheLock()) {
                try {
                    IMAPProtocol protocol = getProtocol();
                    checkExpunged();
                    int sequenceNumber = getSequenceNumber();
                    Response[] fetch = protocol.fetch(sequenceNumber, EnvelopeCmd);
                    for (int i = 0; i < fetch.length; i++) {
                        if (fetch[i] != null && (fetch[i] instanceof FetchResponse) && ((FetchResponse) fetch[i]).getNumber() == sequenceNumber) {
                            FetchResponse fetchResponse = (FetchResponse) fetch[i];
                            int itemCount = fetchResponse.getItemCount();
                            for (int i2 = 0; i2 < itemCount; i2++) {
                                Item item = fetchResponse.getItem(i2);
                                if (item instanceof ENVELOPE) {
                                    this.envelope = (ENVELOPE) item;
                                } else if (item instanceof INTERNALDATE) {
                                    this.receivedDate = ((INTERNALDATE) item).getDate();
                                } else if (item instanceof RFC822SIZE) {
                                    this.size = ((RFC822SIZE) item).size;
                                }
                            }
                        }
                    }
                    protocol.notifyResponseHandlers(fetch);
                    protocol.handleResult(fetch[fetch.length - 1]);
                } catch (ConnectionException e) {
                    throw new FolderClosedException(this.folder, e.getMessage());
                } catch (ProtocolException e2) {
                    forceCheckExpunged();
                    throw new MessagingException(e2.getMessage(), e2);
                }
            }
            if (this.envelope == null) {
                throw new MessagingException("Failed to load IMAP envelope");
            }
        }
    }

    private synchronized void loadFlags() throws MessagingException {
        if (this.flags == null) {
            synchronized (getMessageCacheLock()) {
                try {
                    IMAPProtocol protocol = getProtocol();
                    checkExpunged();
                    this.flags = protocol.fetchFlags(getSequenceNumber());
                } catch (ConnectionException e) {
                    throw new FolderClosedException(this.folder, e.getMessage());
                } catch (ProtocolException e2) {
                    forceCheckExpunged();
                    throw new MessagingException(e2.getMessage(), e2);
                }
            }
        }
    }

    private synchronized void loadHeaders() throws MessagingException {
        if (!this.headersLoaded) {
            ByteArrayInputStream byteArrayInputStream = null;
            synchronized (getMessageCacheLock()) {
                try {
                    IMAPProtocol protocol = getProtocol();
                    checkExpunged();
                    if (protocol.isREV1()) {
                        BODY peekBody = protocol.peekBody(getSequenceNumber(), toSection("HEADER"));
                        if (peekBody != null) {
                            byteArrayInputStream = peekBody.getByteArrayInputStream();
                        }
                    } else {
                        RFC822DATA fetchRFC822 = protocol.fetchRFC822(getSequenceNumber(), "HEADER");
                        if (fetchRFC822 != null) {
                            byteArrayInputStream = fetchRFC822.getByteArrayInputStream();
                        }
                    }
                } catch (ConnectionException e) {
                    throw new FolderClosedException(this.folder, e.getMessage());
                } catch (ProtocolException e2) {
                    forceCheckExpunged();
                    throw new MessagingException(e2.getMessage(), e2);
                }
            }
            if (byteArrayInputStream == null) {
                throw new MessagingException("Cannot load header");
            }
            this.headers = new InternetHeaders(byteArrayInputStream);
            this.headersLoaded = true;
        }
    }

    private synchronized void setHeaderLoaded(String str) {
        if (this.loadedHeaders == null) {
            this.loadedHeaders = new Hashtable(1);
        }
        this.loadedHeaders.put(str.toUpperCase(Locale.ENGLISH), str);
    }

    private synchronized void setHeadersLoaded(boolean z) {
        this.headersLoaded = z;
    }

    private String toSection(String str) {
        if (this.sectionId == null) {
            return str;
        }
        return String.valueOf(this.sectionId) + "." + str;
    }

    /* access modifiers changed from: package-private */
    public Session _getSession() {
        return this.session;
    }

    /* access modifiers changed from: package-private */
    public void _setFlags(Flags flags) {
        this.flags = flags;
    }

    public void addFrom(Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void addHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void addHeaderLine(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void addRecipients(Message.RecipientType recipientType, Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    /* access modifiers changed from: protected */
    public void checkExpunged() throws MessageRemovedException {
        if (this.expunged) {
            throw new MessageRemovedException();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000f */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void forceCheckExpunged() throws javax.mail.MessageRemovedException, javax.mail.FolderClosedException {
        /*
            r4 = this;
            java.lang.Object r0 = r4.getMessageCacheLock()
            monitor-enter(r0)
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r4.getProtocol()     // Catch:{ ConnectionException -> 0x001b, ProtocolException -> 0x000f }
            r1.noop()     // Catch:{ ConnectionException -> 0x001b, ProtocolException -> 0x000f }
            goto L_0x000f
        L_0x000d:
            r1 = move-exception
            goto L_0x0028
        L_0x000f:
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
            boolean r0 = r4.expunged
            if (r0 == 0) goto L_0x001a
            javax.mail.MessageRemovedException r0 = new javax.mail.MessageRemovedException
            r0.<init>()
            throw r0
        L_0x001a:
            return
        L_0x001b:
            r1 = move-exception
            javax.mail.FolderClosedException r2 = new javax.mail.FolderClosedException     // Catch:{ all -> 0x000d }
            javax.mail.Folder r3 = r4.folder     // Catch:{ all -> 0x000d }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x000d }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x000d }
            throw r2     // Catch:{ all -> 0x000d }
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPMessage.forceCheckExpunged():void");
    }

    public Enumeration getAllHeaderLines() throws MessagingException {
        checkExpunged();
        loadHeaders();
        return super.getAllHeaderLines();
    }

    public Enumeration getAllHeaders() throws MessagingException {
        checkExpunged();
        loadHeaders();
        return super.getAllHeaders();
    }

    public String getContentID() throws MessagingException {
        checkExpunged();
        loadBODYSTRUCTURE();
        return this.bs.id;
    }

    public String[] getContentLanguage() throws MessagingException {
        checkExpunged();
        loadBODYSTRUCTURE();
        if (this.bs.language != null) {
            return (String[]) this.bs.language.clone();
        }
        return null;
    }

    public String getContentMD5() throws MessagingException {
        checkExpunged();
        loadBODYSTRUCTURE();
        return this.bs.md5;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0071, code lost:
        if (r0 != null) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007a, code lost:
        throw new javax.mail.MessagingException("No content");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007b, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.InputStream getContentStream() throws javax.mail.MessagingException {
        /*
            r6 = this;
            boolean r0 = r6.getPeek()
            java.lang.Object r1 = r6.getMessageCacheLock()
            monitor-enter(r1)
            com.sun.mail.imap.protocol.IMAPProtocol r2 = r6.getProtocol()     // Catch:{ ConnectionException -> 0x008c, ProtocolException -> 0x007e }
            r6.checkExpunged()     // Catch:{ ConnectionException -> 0x008c, ProtocolException -> 0x007e }
            boolean r3 = r2.isREV1()     // Catch:{ ConnectionException -> 0x008c, ProtocolException -> 0x007e }
            if (r3 == 0) goto L_0x0032
            int r3 = r6.getFetchBlockSize()     // Catch:{ ConnectionException -> 0x008c, ProtocolException -> 0x007e }
            r4 = -1
            if (r3 == r4) goto L_0x0032
            com.sun.mail.imap.IMAPInputStream r2 = new com.sun.mail.imap.IMAPInputStream     // Catch:{ ConnectionException -> 0x008c, ProtocolException -> 0x007e }
            java.lang.String r3 = "TEXT"
            java.lang.String r3 = r6.toSection(r3)     // Catch:{ ConnectionException -> 0x008c, ProtocolException -> 0x007e }
            com.sun.mail.imap.protocol.BODYSTRUCTURE r5 = r6.bs     // Catch:{ ConnectionException -> 0x008c, ProtocolException -> 0x007e }
            if (r5 == 0) goto L_0x002d
            com.sun.mail.imap.protocol.BODYSTRUCTURE r4 = r6.bs     // Catch:{ ConnectionException -> 0x008c, ProtocolException -> 0x007e }
            int r4 = r4.size     // Catch:{ ConnectionException -> 0x008c, ProtocolException -> 0x007e }
        L_0x002d:
            r2.<init>(r6, r3, r4, r0)     // Catch:{ ConnectionException -> 0x008c, ProtocolException -> 0x007e }
            monitor-exit(r1)     // Catch:{ all -> 0x007c }
            return r2
        L_0x0032:
            boolean r3 = r2.isREV1()     // Catch:{ ConnectionException -> 0x008c, ProtocolException -> 0x007e }
            if (r3 == 0) goto L_0x005e
            if (r0 == 0) goto L_0x0049
            int r0 = r6.getSequenceNumber()     // Catch:{ ConnectionException -> 0x008c, ProtocolException -> 0x007e }
            java.lang.String r3 = "TEXT"
            java.lang.String r3 = r6.toSection(r3)     // Catch:{ ConnectionException -> 0x008c, ProtocolException -> 0x007e }
            com.sun.mail.imap.protocol.BODY r0 = r2.peekBody(r0, r3)     // Catch:{ ConnectionException -> 0x008c, ProtocolException -> 0x007e }
            goto L_0x0057
        L_0x0049:
            int r0 = r6.getSequenceNumber()     // Catch:{ ConnectionException -> 0x008c, ProtocolException -> 0x007e }
            java.lang.String r3 = "TEXT"
            java.lang.String r3 = r6.toSection(r3)     // Catch:{ ConnectionException -> 0x008c, ProtocolException -> 0x007e }
            com.sun.mail.imap.protocol.BODY r0 = r2.fetchBody(r0, r3)     // Catch:{ ConnectionException -> 0x008c, ProtocolException -> 0x007e }
        L_0x0057:
            if (r0 == 0) goto L_0x006f
            java.io.ByteArrayInputStream r0 = r0.getByteArrayInputStream()     // Catch:{ ConnectionException -> 0x008c, ProtocolException -> 0x007e }
            goto L_0x0070
        L_0x005e:
            int r0 = r6.getSequenceNumber()     // Catch:{ ConnectionException -> 0x008c, ProtocolException -> 0x007e }
            java.lang.String r3 = "TEXT"
            com.sun.mail.imap.protocol.RFC822DATA r0 = r2.fetchRFC822(r0, r3)     // Catch:{ ConnectionException -> 0x008c, ProtocolException -> 0x007e }
            if (r0 == 0) goto L_0x006f
            java.io.ByteArrayInputStream r0 = r0.getByteArrayInputStream()     // Catch:{ ConnectionException -> 0x008c, ProtocolException -> 0x007e }
            goto L_0x0070
        L_0x006f:
            r0 = 0
        L_0x0070:
            monitor-exit(r1)     // Catch:{ all -> 0x007c }
            if (r0 != 0) goto L_0x007b
            javax.mail.MessagingException r0 = new javax.mail.MessagingException
            java.lang.String r1 = "No content"
            r0.<init>(r1)
            throw r0
        L_0x007b:
            return r0
        L_0x007c:
            r0 = move-exception
            goto L_0x0099
        L_0x007e:
            r0 = move-exception
            r6.forceCheckExpunged()     // Catch:{ all -> 0x007c }
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x007c }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x007c }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x007c }
            throw r2     // Catch:{ all -> 0x007c }
        L_0x008c:
            r0 = move-exception
            javax.mail.FolderClosedException r2 = new javax.mail.FolderClosedException     // Catch:{ all -> 0x007c }
            javax.mail.Folder r3 = r6.folder     // Catch:{ all -> 0x007c }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x007c }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x007c }
            throw r2     // Catch:{ all -> 0x007c }
        L_0x0099:
            monitor-exit(r1)     // Catch:{ all -> 0x007c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPMessage.getContentStream():java.io.InputStream");
    }

    public String getContentType() throws MessagingException {
        checkExpunged();
        if (this.type == null) {
            loadBODYSTRUCTURE();
            this.type = new ContentType(this.bs.type, this.bs.subtype, this.bs.cParams).toString();
        }
        return this.type;
    }

    public synchronized DataHandler getDataHandler() throws MessagingException {
        DataHandler dataHandler;
        String str;
        checkExpunged();
        if (this.dh == null) {
            loadBODYSTRUCTURE();
            if (this.type == null) {
                this.type = new ContentType(this.bs.type, this.bs.subtype, this.bs.cParams).toString();
            }
            if (this.bs.isMulti()) {
                dataHandler = new DataHandler((DataSource) new IMAPMultipartDataSource(this, this.bs.bodies, this.sectionId, this));
            } else if (this.bs.isNested() && isREV1()) {
                BODYSTRUCTURE bodystructure = this.bs.bodies[0];
                ENVELOPE envelope2 = this.bs.envelope;
                if (this.sectionId == null) {
                    str = "1";
                } else {
                    str = String.valueOf(this.sectionId) + ".1";
                }
                dataHandler = new DataHandler(new IMAPNestedMessage(this, bodystructure, envelope2, str), this.type);
            }
            this.dh = dataHandler;
        }
        return super.getDataHandler();
    }

    public String getDescription() throws MessagingException {
        checkExpunged();
        if (this.description != null) {
            return this.description;
        }
        loadBODYSTRUCTURE();
        if (this.bs.description == null) {
            return null;
        }
        try {
            this.description = MimeUtility.decodeText(this.bs.description);
        } catch (UnsupportedEncodingException unused) {
            this.description = this.bs.description;
        }
        return this.description;
    }

    public String getDisposition() throws MessagingException {
        checkExpunged();
        loadBODYSTRUCTURE();
        return this.bs.disposition;
    }

    public String getEncoding() throws MessagingException {
        checkExpunged();
        loadBODYSTRUCTURE();
        return this.bs.encoding;
    }

    /* access modifiers changed from: protected */
    public int getFetchBlockSize() {
        return ((IMAPStore) this.folder.getStore()).getFetchBlockSize();
    }

    public String getFileName() throws MessagingException {
        checkExpunged();
        loadBODYSTRUCTURE();
        String str = this.bs.dParams != null ? this.bs.dParams.get("filename") : null;
        return (str != null || this.bs.cParams == null) ? str : this.bs.cParams.get(b.c.f4838b);
    }

    public synchronized Flags getFlags() throws MessagingException {
        checkExpunged();
        loadFlags();
        return super.getFlags();
    }

    public Address[] getFrom() throws MessagingException {
        checkExpunged();
        loadEnvelope();
        return aaclone(this.envelope.from);
    }

    public String getHeader(String str, String str2) throws MessagingException {
        checkExpunged();
        if (getHeader(str) == null) {
            return null;
        }
        return this.headers.getHeader(str, str2);
    }

    public String[] getHeader(String str) throws MessagingException {
        ByteArrayInputStream byteArrayInputStream;
        checkExpunged();
        if (!isHeaderLoaded(str)) {
            synchronized (getMessageCacheLock()) {
                try {
                    IMAPProtocol protocol = getProtocol();
                    checkExpunged();
                    if (protocol.isREV1()) {
                        BODY peekBody = protocol.peekBody(getSequenceNumber(), toSection("HEADER.FIELDS (" + str + ")"));
                        if (peekBody != null) {
                            byteArrayInputStream = peekBody.getByteArrayInputStream();
                        }
                    } else {
                        RFC822DATA fetchRFC822 = protocol.fetchRFC822(getSequenceNumber(), "HEADER.LINES (" + str + ")");
                        if (fetchRFC822 != null) {
                            byteArrayInputStream = fetchRFC822.getByteArrayInputStream();
                        }
                    }
                    byteArrayInputStream = null;
                } catch (ConnectionException e) {
                    throw new FolderClosedException(this.folder, e.getMessage());
                } catch (ProtocolException e2) {
                    forceCheckExpunged();
                    throw new MessagingException(e2.getMessage(), e2);
                }
            }
            if (byteArrayInputStream == null) {
                return null;
            }
            if (this.headers == null) {
                this.headers = new InternetHeaders();
            }
            this.headers.load(byteArrayInputStream);
            setHeaderLoaded(str);
        }
        return this.headers.getHeader(str);
    }

    public String getInReplyTo() throws MessagingException {
        checkExpunged();
        loadEnvelope();
        return this.envelope.inReplyTo;
    }

    public int getLineCount() throws MessagingException {
        checkExpunged();
        loadBODYSTRUCTURE();
        return this.bs.lines;
    }

    public Enumeration getMatchingHeaderLines(String[] strArr) throws MessagingException {
        checkExpunged();
        loadHeaders();
        return super.getMatchingHeaderLines(strArr);
    }

    public Enumeration getMatchingHeaders(String[] strArr) throws MessagingException {
        checkExpunged();
        loadHeaders();
        return super.getMatchingHeaders(strArr);
    }

    /* access modifiers changed from: protected */
    public Object getMessageCacheLock() {
        return ((IMAPFolder) this.folder).messageCacheLock;
    }

    public String getMessageID() throws MessagingException {
        checkExpunged();
        loadEnvelope();
        return this.envelope.messageId;
    }

    public Enumeration getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        checkExpunged();
        loadHeaders();
        return super.getNonMatchingHeaderLines(strArr);
    }

    public Enumeration getNonMatchingHeaders(String[] strArr) throws MessagingException {
        checkExpunged();
        loadHeaders();
        return super.getNonMatchingHeaders(strArr);
    }

    public synchronized boolean getPeek() {
        return this.peek;
    }

    /* access modifiers changed from: protected */
    public IMAPProtocol getProtocol() throws ProtocolException, FolderClosedException {
        ((IMAPFolder) this.folder).waitIfIdle();
        IMAPProtocol iMAPProtocol = ((IMAPFolder) this.folder).protocol;
        if (iMAPProtocol != null) {
            return iMAPProtocol;
        }
        throw new FolderClosedException(this.folder);
    }

    public Date getReceivedDate() throws MessagingException {
        checkExpunged();
        loadEnvelope();
        if (this.receivedDate == null) {
            return null;
        }
        return new Date(this.receivedDate.getTime());
    }

    public Address[] getRecipients(Message.RecipientType recipientType) throws MessagingException {
        InternetAddress[] internetAddressArr;
        checkExpunged();
        loadEnvelope();
        if (recipientType == Message.RecipientType.TO) {
            internetAddressArr = this.envelope.to;
        } else if (recipientType == Message.RecipientType.CC) {
            internetAddressArr = this.envelope.cc;
        } else if (recipientType != Message.RecipientType.BCC) {
            return super.getRecipients(recipientType);
        } else {
            internetAddressArr = this.envelope.bcc;
        }
        return aaclone(internetAddressArr);
    }

    public Address[] getReplyTo() throws MessagingException {
        checkExpunged();
        loadEnvelope();
        return aaclone(this.envelope.replyTo);
    }

    public Address getSender() throws MessagingException {
        checkExpunged();
        loadEnvelope();
        if (this.envelope.sender != null) {
            return this.envelope.sender[0];
        }
        return null;
    }

    public Date getSentDate() throws MessagingException {
        checkExpunged();
        loadEnvelope();
        if (this.envelope.date == null) {
            return null;
        }
        return new Date(this.envelope.date.getTime());
    }

    /* access modifiers changed from: protected */
    public int getSequenceNumber() {
        return this.seqnum;
    }

    public int getSize() throws MessagingException {
        checkExpunged();
        if (this.size == -1) {
            loadEnvelope();
        }
        return this.size;
    }

    public String getSubject() throws MessagingException {
        checkExpunged();
        if (this.subject != null) {
            return this.subject;
        }
        loadEnvelope();
        if (this.envelope.subject == null) {
            return null;
        }
        try {
            this.subject = MimeUtility.decodeText(this.envelope.subject);
        } catch (UnsupportedEncodingException unused) {
            this.subject = this.envelope.subject;
        }
        return this.subject;
    }

    /* access modifiers changed from: protected */
    public long getUID() {
        return this.uid;
    }

    public synchronized void invalidateHeaders() {
        this.headersLoaded = false;
        this.loadedHeaders = null;
        this.envelope = null;
        this.bs = null;
        this.receivedDate = null;
        this.size = -1;
        this.type = null;
        this.subject = null;
        this.description = null;
    }

    /* access modifiers changed from: protected */
    public boolean isREV1() throws FolderClosedException {
        IMAPProtocol iMAPProtocol = ((IMAPFolder) this.folder).protocol;
        if (iMAPProtocol != null) {
            return iMAPProtocol.isREV1();
        }
        throw new FolderClosedException(this.folder);
    }

    public synchronized boolean isSet(Flags.Flag flag) throws MessagingException {
        checkExpunged();
        loadFlags();
        return super.isSet(flag);
    }

    public void removeHeader(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void setContentID(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void setContentLanguage(String[] strArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void setContentMD5(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void setDataHandler(DataHandler dataHandler) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void setDescription(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void setDisposition(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    /* access modifiers changed from: protected */
    public void setExpunged(boolean z) {
        super.setExpunged(z);
        this.seqnum = -1;
    }

    public void setFileName(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public synchronized void setFlags(Flags flags, boolean z) throws MessagingException {
        synchronized (getMessageCacheLock()) {
            try {
                IMAPProtocol protocol = getProtocol();
                checkExpunged();
                protocol.storeFlags(getSequenceNumber(), flags, z);
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException e2) {
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
    }

    public void setFrom(Address address) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void setHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    /* access modifiers changed from: protected */
    public void setMessageNumber(int i) {
        super.setMessageNumber(i);
    }

    public synchronized void setPeek(boolean z) {
        this.peek = z;
    }

    public void setRecipients(Message.RecipientType recipientType, Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void setReplyTo(Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void setSender(Address address) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void setSentDate(Date date) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    /* access modifiers changed from: protected */
    public void setSequenceNumber(int i) {
        this.seqnum = i;
    }

    public void setSubject(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    /* access modifiers changed from: protected */
    public void setUID(long j) {
        this.uid = j;
    }

    public void writeTo(OutputStream outputStream) throws IOException, MessagingException {
        ByteArrayInputStream byteArrayInputStream;
        boolean peek2 = getPeek();
        synchronized (getMessageCacheLock()) {
            try {
                IMAPProtocol protocol = getProtocol();
                checkExpunged();
                byteArrayInputStream = null;
                if (protocol.isREV1()) {
                    BODY peekBody = peek2 ? protocol.peekBody(getSequenceNumber(), this.sectionId) : protocol.fetchBody(getSequenceNumber(), this.sectionId);
                    if (peekBody != null) {
                        byteArrayInputStream = peekBody.getByteArrayInputStream();
                    }
                } else {
                    RFC822DATA fetchRFC822 = protocol.fetchRFC822(getSequenceNumber(), (String) null);
                    if (fetchRFC822 != null) {
                        byteArrayInputStream = fetchRFC822.getByteArrayInputStream();
                    }
                }
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException e2) {
                forceCheckExpunged();
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
        if (byteArrayInputStream == null) {
            throw new MessagingException("No content");
        }
        byte[] bArr = new byte[1024];
        while (true) {
            int read = byteArrayInputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
