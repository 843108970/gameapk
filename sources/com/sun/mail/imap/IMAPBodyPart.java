package com.sun.mail.imap;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.lidroid.xutils.http.client.multipart.MIME;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.protocol.BODY;
import com.sun.mail.imap.protocol.BODYSTRUCTURE;
import com.sun.mail.imap.protocol.IMAPProtocol;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.FolderClosedException;
import javax.mail.IllegalWriteException;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeUtility;
import org.litepal.g.b;

public class IMAPBodyPart extends MimeBodyPart {
    private BODYSTRUCTURE bs;
    private String description;
    private boolean headersLoaded = false;
    private IMAPMessage message;
    private String sectionId;
    private String type;

    protected IMAPBodyPart(BODYSTRUCTURE bodystructure, String str, IMAPMessage iMAPMessage) {
        this.bs = bodystructure;
        this.sectionId = str;
        this.message = iMAPMessage;
        this.type = new ContentType(bodystructure.type, bodystructure.subtype, bodystructure.cParams).toString();
    }

    private synchronized void loadHeaders() throws MessagingException {
        if (!this.headersLoaded) {
            if (this.headers == null) {
                this.headers = new InternetHeaders();
            }
            synchronized (this.message.getMessageCacheLock()) {
                try {
                    IMAPProtocol protocol = this.message.getProtocol();
                    this.message.checkExpunged();
                    if (protocol.isREV1()) {
                        int sequenceNumber = this.message.getSequenceNumber();
                        BODY peekBody = protocol.peekBody(sequenceNumber, String.valueOf(this.sectionId) + ".MIME");
                        if (peekBody == null) {
                            throw new MessagingException("Failed to fetch headers");
                        }
                        ByteArrayInputStream byteArrayInputStream = peekBody.getByteArrayInputStream();
                        if (byteArrayInputStream == null) {
                            throw new MessagingException("Failed to fetch headers");
                        }
                        this.headers.load(byteArrayInputStream);
                    } else {
                        this.headers.addHeader("Content-Type", this.type);
                        this.headers.addHeader(MIME.CONTENT_TRANSFER_ENC, this.bs.encoding);
                        if (this.bs.description != null) {
                            this.headers.addHeader("Content-Description", this.bs.description);
                        }
                        if (this.bs.id != null) {
                            this.headers.addHeader("Content-ID", this.bs.id);
                        }
                        if (this.bs.md5 != null) {
                            this.headers.addHeader(HttpHeaders.CONTENT_MD5, this.bs.md5);
                        }
                    }
                } catch (ConnectionException e) {
                    throw new FolderClosedException(this.message.getFolder(), e.getMessage());
                } catch (ProtocolException e2) {
                    throw new MessagingException(e2.getMessage(), e2);
                }
            }
            this.headersLoaded = true;
        }
    }

    public void addHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    public void addHeaderLine(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    public Enumeration getAllHeaderLines() throws MessagingException {
        loadHeaders();
        return super.getAllHeaderLines();
    }

    public Enumeration getAllHeaders() throws MessagingException {
        loadHeaders();
        return super.getAllHeaders();
    }

    public String getContentID() throws MessagingException {
        return this.bs.id;
    }

    public String getContentMD5() throws MessagingException {
        return this.bs.md5;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
        if (r0 != null) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005d, code lost:
        throw new javax.mail.MessagingException("No content");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.InputStream getContentStream() throws javax.mail.MessagingException {
        /*
            r6 = this;
            com.sun.mail.imap.IMAPMessage r0 = r6.message
            boolean r0 = r0.getPeek()
            com.sun.mail.imap.IMAPMessage r1 = r6.message
            java.lang.Object r1 = r1.getMessageCacheLock()
            monitor-enter(r1)
            com.sun.mail.imap.IMAPMessage r2 = r6.message     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            com.sun.mail.imap.protocol.IMAPProtocol r2 = r2.getProtocol()     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            com.sun.mail.imap.IMAPMessage r3 = r6.message     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            r3.checkExpunged()     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            boolean r3 = r2.isREV1()     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            if (r3 == 0) goto L_0x0036
            com.sun.mail.imap.IMAPMessage r3 = r6.message     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            int r3 = r3.getFetchBlockSize()     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            r4 = -1
            if (r3 == r4) goto L_0x0036
            com.sun.mail.imap.IMAPInputStream r2 = new com.sun.mail.imap.IMAPInputStream     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            com.sun.mail.imap.IMAPMessage r3 = r6.message     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            java.lang.String r4 = r6.sectionId     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            com.sun.mail.imap.protocol.BODYSTRUCTURE r5 = r6.bs     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            int r5 = r5.size     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            r2.<init>(r3, r4, r5, r0)     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            monitor-exit(r1)     // Catch:{ all -> 0x005f }
            return r2
        L_0x0036:
            com.sun.mail.imap.IMAPMessage r3 = r6.message     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            int r3 = r3.getSequenceNumber()     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            if (r0 == 0) goto L_0x0045
            java.lang.String r0 = r6.sectionId     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            com.sun.mail.imap.protocol.BODY r0 = r2.peekBody(r3, r0)     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            goto L_0x004b
        L_0x0045:
            java.lang.String r0 = r6.sectionId     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            com.sun.mail.imap.protocol.BODY r0 = r2.fetchBody(r3, r0)     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
        L_0x004b:
            if (r0 == 0) goto L_0x0052
            java.io.ByteArrayInputStream r0 = r0.getByteArrayInputStream()     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            goto L_0x0053
        L_0x0052:
            r0 = 0
        L_0x0053:
            monitor-exit(r1)     // Catch:{ all -> 0x005f }
            if (r0 != 0) goto L_0x005e
            javax.mail.MessagingException r0 = new javax.mail.MessagingException
            java.lang.String r1 = "No content"
            r0.<init>(r1)
            throw r0
        L_0x005e:
            return r0
        L_0x005f:
            r0 = move-exception
            goto L_0x007d
        L_0x0061:
            r0 = move-exception
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x005f }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x005f }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x005f }
            throw r2     // Catch:{ all -> 0x005f }
        L_0x006c:
            r0 = move-exception
            javax.mail.FolderClosedException r2 = new javax.mail.FolderClosedException     // Catch:{ all -> 0x005f }
            com.sun.mail.imap.IMAPMessage r3 = r6.message     // Catch:{ all -> 0x005f }
            javax.mail.Folder r3 = r3.getFolder()     // Catch:{ all -> 0x005f }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x005f }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x005f }
            throw r2     // Catch:{ all -> 0x005f }
        L_0x007d:
            monitor-exit(r1)     // Catch:{ all -> 0x005f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPBodyPart.getContentStream():java.io.InputStream");
    }

    public String getContentType() throws MessagingException {
        return this.type;
    }

    public synchronized DataHandler getDataHandler() throws MessagingException {
        DataHandler dataHandler;
        if (this.dh == null) {
            if (this.bs.isMulti()) {
                dataHandler = new DataHandler((DataSource) new IMAPMultipartDataSource(this, this.bs.bodies, this.sectionId, this.message));
            } else if (this.bs.isNested() && this.message.isREV1()) {
                dataHandler = new DataHandler(new IMAPNestedMessage(this.message, this.bs.bodies[0], this.bs.envelope, this.sectionId), this.type);
            }
            this.dh = dataHandler;
        }
        return super.getDataHandler();
    }

    public String getDescription() throws MessagingException {
        if (this.description != null) {
            return this.description;
        }
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
        return this.bs.disposition;
    }

    public String getEncoding() throws MessagingException {
        return this.bs.encoding;
    }

    public String getFileName() throws MessagingException {
        String str = this.bs.dParams != null ? this.bs.dParams.get("filename") : null;
        return (str != null || this.bs.cParams == null) ? str : this.bs.cParams.get(b.c.f4838b);
    }

    public String[] getHeader(String str) throws MessagingException {
        loadHeaders();
        return super.getHeader(str);
    }

    public int getLineCount() throws MessagingException {
        return this.bs.lines;
    }

    public Enumeration getMatchingHeaderLines(String[] strArr) throws MessagingException {
        loadHeaders();
        return super.getMatchingHeaderLines(strArr);
    }

    public Enumeration getMatchingHeaders(String[] strArr) throws MessagingException {
        loadHeaders();
        return super.getMatchingHeaders(strArr);
    }

    public Enumeration getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        loadHeaders();
        return super.getNonMatchingHeaderLines(strArr);
    }

    public Enumeration getNonMatchingHeaders(String[] strArr) throws MessagingException {
        loadHeaders();
        return super.getNonMatchingHeaders(strArr);
    }

    public int getSize() throws MessagingException {
        return this.bs.size;
    }

    public void removeHeader(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    public void setContent(Object obj, String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    public void setContent(Multipart multipart) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    public void setContentMD5(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    public void setDataHandler(DataHandler dataHandler) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    public void setDescription(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    public void setDisposition(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    public void setFileName(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    public void setHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    /* access modifiers changed from: protected */
    public void updateHeaders() {
    }
}
