package com.sun.mail.imap;

import com.sun.mail.iap.ByteArray;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.protocol.BODY;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.util.FolderClosedIOException;
import com.sun.mail.util.MessageRemovedIOException;
import java.io.IOException;
import java.io.InputStream;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.MessagingException;

public class IMAPInputStream extends InputStream {
    private static final int slop = 64;
    private int blksize;
    private byte[] buf;
    private int bufcount;
    private int bufpos;
    private int max;
    private IMAPMessage msg;
    private boolean peek;
    private int pos = 0;
    private ByteArray readbuf;
    private String section;

    public IMAPInputStream(IMAPMessage iMAPMessage, String str, int i, boolean z) {
        this.msg = iMAPMessage;
        this.section = str;
        this.max = i;
        this.peek = z;
        this.blksize = iMAPMessage.getFetchBlockSize();
    }

    private void checkSeen() {
        if (!this.peek) {
            try {
                Folder folder = this.msg.getFolder();
                if (folder != null && folder.getMode() != 1 && !this.msg.isSet(Flags.Flag.SEEN)) {
                    this.msg.setFlag(Flags.Flag.SEEN, true);
                }
            } catch (MessagingException unused) {
            }
        }
    }

    private void fill() throws IOException {
        ByteArray byteArray;
        if (this.max == -1 || this.pos < this.max) {
            if (this.readbuf == null) {
                this.readbuf = new ByteArray(this.blksize + 64);
            }
            synchronized (this.msg.getMessageCacheLock()) {
                try {
                    IMAPProtocol protocol = this.msg.getProtocol();
                    if (this.msg.isExpunged()) {
                        throw new MessageRemovedIOException("No content for expunged message");
                    }
                    int sequenceNumber = this.msg.getSequenceNumber();
                    int i = (this.max == -1 || this.pos + this.blksize <= this.max) ? this.blksize : this.max - this.pos;
                    BODY peekBody = this.peek ? protocol.peekBody(sequenceNumber, this.section, this.pos, i, this.readbuf) : protocol.fetchBody(sequenceNumber, this.section, this.pos, i, this.readbuf);
                    if (peekBody != null) {
                        byteArray = peekBody.getByteArray();
                        if (byteArray == null) {
                        }
                    }
                    forceCheckExpunged();
                    throw new IOException("No content");
                } catch (ProtocolException e) {
                    forceCheckExpunged();
                    throw new IOException(e.getMessage());
                } catch (FolderClosedException e2) {
                    throw new FolderClosedIOException(e2.getFolder(), e2.getMessage());
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.pos == 0) {
                checkSeen();
            }
            this.buf = byteArray.getBytes();
            this.bufpos = byteArray.getStart();
            int count = byteArray.getCount();
            this.bufcount = this.bufpos + count;
            this.pos += count;
            return;
        }
        if (this.pos == 0) {
            checkSeen();
        }
        this.readbuf = null;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0013 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void forceCheckExpunged() throws com.sun.mail.util.MessageRemovedIOException, com.sun.mail.util.FolderClosedIOException {
        /*
            r4 = this;
            com.sun.mail.imap.IMAPMessage r0 = r4.msg
            java.lang.Object r0 = r0.getMessageCacheLock()
            monitor-enter(r0)
            com.sun.mail.imap.IMAPMessage r1 = r4.msg     // Catch:{ ConnectionException -> 0x0032, FolderClosedException -> 0x0023, ProtocolException -> 0x0013 }
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r1.getProtocol()     // Catch:{ ConnectionException -> 0x0032, FolderClosedException -> 0x0023, ProtocolException -> 0x0013 }
            r1.noop()     // Catch:{ ConnectionException -> 0x0032, FolderClosedException -> 0x0023, ProtocolException -> 0x0013 }
            goto L_0x0013
        L_0x0011:
            r1 = move-exception
            goto L_0x0043
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            com.sun.mail.imap.IMAPMessage r0 = r4.msg
            boolean r0 = r0.isExpunged()
            if (r0 == 0) goto L_0x0022
            com.sun.mail.util.MessageRemovedIOException r0 = new com.sun.mail.util.MessageRemovedIOException
            r0.<init>()
            throw r0
        L_0x0022:
            return
        L_0x0023:
            r1 = move-exception
            com.sun.mail.util.FolderClosedIOException r2 = new com.sun.mail.util.FolderClosedIOException     // Catch:{ all -> 0x0011 }
            javax.mail.Folder r3 = r1.getFolder()     // Catch:{ all -> 0x0011 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0011 }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x0011 }
            throw r2     // Catch:{ all -> 0x0011 }
        L_0x0032:
            r1 = move-exception
            com.sun.mail.util.FolderClosedIOException r2 = new com.sun.mail.util.FolderClosedIOException     // Catch:{ all -> 0x0011 }
            com.sun.mail.imap.IMAPMessage r3 = r4.msg     // Catch:{ all -> 0x0011 }
            javax.mail.Folder r3 = r3.getFolder()     // Catch:{ all -> 0x0011 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0011 }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x0011 }
            throw r2     // Catch:{ all -> 0x0011 }
        L_0x0043:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPInputStream.forceCheckExpunged():void");
    }

    public synchronized int available() throws IOException {
        return this.bufcount - this.bufpos;
    }

    public synchronized int read() throws IOException {
        byte b2;
        if (this.bufpos >= this.bufcount) {
            fill();
            if (this.bufpos >= this.bufcount) {
                b2 = -1;
            }
        }
        byte[] bArr = this.buf;
        int i = this.bufpos;
        this.bufpos = i + 1;
        b2 = bArr[i] & 255;
        return b2;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.bufcount - this.bufpos;
        if (i3 <= 0) {
            fill();
            i3 = this.bufcount - this.bufpos;
            if (i3 <= 0) {
                return -1;
            }
        }
        if (i3 < i2) {
            i2 = i3;
        }
        System.arraycopy(this.buf, this.bufpos, bArr, i, i2);
        this.bufpos += i2;
        return i2;
    }
}
