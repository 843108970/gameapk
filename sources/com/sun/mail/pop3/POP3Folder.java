package com.sun.mail.pop3;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.FolderNotFoundException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.MethodNotSupportedException;

public class POP3Folder extends Folder {
    private boolean doneUidl = false;
    private boolean exists = false;
    private Vector message_cache;
    private String name;
    private boolean opened = false;
    private Protocol port;
    private int size;
    private int total;

    POP3Folder(POP3Store pOP3Store, String str) {
        super(pOP3Store);
        this.name = str;
        if (str.equalsIgnoreCase("INBOX")) {
            this.exists = true;
        }
    }

    public void appendMessages(Message[] messageArr) throws MessagingException {
        throw new MethodNotSupportedException("Append not supported");
    }

    /* access modifiers changed from: package-private */
    public void checkClosed() throws IllegalStateException {
        if (this.opened) {
            throw new IllegalStateException("Folder is Open");
        }
    }

    /* access modifiers changed from: package-private */
    public void checkOpen() throws IllegalStateException {
        if (!this.opened) {
            throw new IllegalStateException("Folder is not Open");
        }
    }

    /* access modifiers changed from: package-private */
    public void checkReadable() throws IllegalStateException {
        if (!this.opened || !(this.mode == 1 || this.mode == 2)) {
            throw new IllegalStateException("Folder is not Readable");
        }
    }

    /* access modifiers changed from: package-private */
    public void checkWritable() throws IllegalStateException {
        if (!this.opened || this.mode != 2) {
            throw new IllegalStateException("Folder is not Writable");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0062, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r5.port = null;
        ((com.sun.mail.pop3.POP3Store) r5.store).closePort(r5);
        r5.message_cache = null;
        r5.opened = false;
        notifyConnectionListeners(3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0073, code lost:
        throw r6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0062 A[ExcHandler: all (r6v4 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:4:0x0007] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void close(boolean r6) throws javax.mail.MessagingException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.checkOpen()     // Catch:{ all -> 0x0086 }
            r0 = 3
            r1 = 0
            r2 = 0
            javax.mail.Store r3 = r5.store     // Catch:{ IOException -> 0x0074, all -> 0x0062 }
            com.sun.mail.pop3.POP3Store r3 = (com.sun.mail.pop3.POP3Store) r3     // Catch:{ IOException -> 0x0074, all -> 0x0062 }
            boolean r3 = r3.rsetBeforeQuit     // Catch:{ IOException -> 0x0074, all -> 0x0062 }
            if (r3 == 0) goto L_0x0014
            com.sun.mail.pop3.Protocol r3 = r5.port     // Catch:{ IOException -> 0x0074, all -> 0x0062 }
            r3.rset()     // Catch:{ IOException -> 0x0074, all -> 0x0062 }
        L_0x0014:
            if (r6 == 0) goto L_0x004b
            int r6 = r5.mode     // Catch:{ IOException -> 0x0074, all -> 0x0062 }
            r3 = 2
            if (r6 != r3) goto L_0x004b
            r6 = 0
        L_0x001c:
            java.util.Vector r3 = r5.message_cache     // Catch:{ IOException -> 0x0074, all -> 0x0062 }
            int r3 = r3.size()     // Catch:{ IOException -> 0x0074, all -> 0x0062 }
            if (r6 < r3) goto L_0x0025
            goto L_0x004b
        L_0x0025:
            java.util.Vector r3 = r5.message_cache     // Catch:{ IOException -> 0x0074, all -> 0x0062 }
            java.lang.Object r3 = r3.elementAt(r6)     // Catch:{ IOException -> 0x0074, all -> 0x0062 }
            com.sun.mail.pop3.POP3Message r3 = (com.sun.mail.pop3.POP3Message) r3     // Catch:{ IOException -> 0x0074, all -> 0x0062 }
            if (r3 == 0) goto L_0x0048
            javax.mail.Flags$Flag r4 = javax.mail.Flags.Flag.DELETED     // Catch:{ IOException -> 0x0074, all -> 0x0062 }
            boolean r3 = r3.isSet(r4)     // Catch:{ IOException -> 0x0074, all -> 0x0062 }
            if (r3 == 0) goto L_0x0048
            com.sun.mail.pop3.Protocol r3 = r5.port     // Catch:{ IOException -> 0x003f, all -> 0x0062 }
            int r4 = r6 + 1
            r3.dele(r4)     // Catch:{ IOException -> 0x003f, all -> 0x0062 }
            goto L_0x0048
        L_0x003f:
            r6 = move-exception
            javax.mail.MessagingException r3 = new javax.mail.MessagingException     // Catch:{ IOException -> 0x0074, all -> 0x0062 }
            java.lang.String r4 = "Exception deleting messages during close"
            r3.<init>(r4, r6)     // Catch:{ IOException -> 0x0074, all -> 0x0062 }
            throw r3     // Catch:{ IOException -> 0x0074, all -> 0x0062 }
        L_0x0048:
            int r6 = r6 + 1
            goto L_0x001c
        L_0x004b:
            com.sun.mail.pop3.Protocol r6 = r5.port     // Catch:{ IOException -> 0x0074, all -> 0x0062 }
            r6.quit()     // Catch:{ IOException -> 0x0074, all -> 0x0062 }
            r5.port = r2     // Catch:{ all -> 0x0086 }
            javax.mail.Store r6 = r5.store     // Catch:{ all -> 0x0086 }
            com.sun.mail.pop3.POP3Store r6 = (com.sun.mail.pop3.POP3Store) r6     // Catch:{ all -> 0x0086 }
            r6.closePort(r5)     // Catch:{ all -> 0x0086 }
            r5.message_cache = r2     // Catch:{ all -> 0x0086 }
            r5.opened = r1     // Catch:{ all -> 0x0086 }
            r5.notifyConnectionListeners(r0)     // Catch:{ all -> 0x0086 }
            monitor-exit(r5)
            return
        L_0x0062:
            r6 = move-exception
            r5.port = r2     // Catch:{ all -> 0x0086 }
            javax.mail.Store r3 = r5.store     // Catch:{ all -> 0x0086 }
            com.sun.mail.pop3.POP3Store r3 = (com.sun.mail.pop3.POP3Store) r3     // Catch:{ all -> 0x0086 }
            r3.closePort(r5)     // Catch:{ all -> 0x0086 }
            r5.message_cache = r2     // Catch:{ all -> 0x0086 }
            r5.opened = r1     // Catch:{ all -> 0x0086 }
            r5.notifyConnectionListeners(r0)     // Catch:{ all -> 0x0086 }
            throw r6     // Catch:{ all -> 0x0086 }
        L_0x0074:
            r5.port = r2     // Catch:{ all -> 0x0086 }
            javax.mail.Store r6 = r5.store     // Catch:{ all -> 0x0086 }
            com.sun.mail.pop3.POP3Store r6 = (com.sun.mail.pop3.POP3Store) r6     // Catch:{ all -> 0x0086 }
            r6.closePort(r5)     // Catch:{ all -> 0x0086 }
            r5.message_cache = r2     // Catch:{ all -> 0x0086 }
            r5.opened = r1     // Catch:{ all -> 0x0086 }
            r5.notifyConnectionListeners(r0)     // Catch:{ all -> 0x0086 }
            monitor-exit(r5)
            return
        L_0x0086:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.POP3Folder.close(boolean):void");
    }

    public boolean create(int i) throws MessagingException {
        return false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.sun.mail.pop3.POP3Message createMessage(javax.mail.Folder r4, int r5) throws javax.mail.MessagingException {
        /*
            r3 = this;
            javax.mail.Store r4 = r3.store
            com.sun.mail.pop3.POP3Store r4 = (com.sun.mail.pop3.POP3Store) r4
            java.lang.reflect.Constructor r4 = r4.messageConstructor
            if (r4 == 0) goto L_0x001d
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x001d }
            r1 = 0
            r0[r1] = r3     // Catch:{ Exception -> 0x001d }
            r1 = 1
            java.lang.Integer r2 = new java.lang.Integer     // Catch:{ Exception -> 0x001d }
            r2.<init>(r5)     // Catch:{ Exception -> 0x001d }
            r0[r1] = r2     // Catch:{ Exception -> 0x001d }
            java.lang.Object r4 = r4.newInstance(r0)     // Catch:{ Exception -> 0x001d }
            com.sun.mail.pop3.POP3Message r4 = (com.sun.mail.pop3.POP3Message) r4     // Catch:{ Exception -> 0x001d }
            goto L_0x001e
        L_0x001d:
            r4 = 0
        L_0x001e:
            if (r4 != 0) goto L_0x0025
            com.sun.mail.pop3.POP3Message r4 = new com.sun.mail.pop3.POP3Message
            r4.<init>(r3, r5)
        L_0x0025:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.POP3Folder.createMessage(javax.mail.Folder, int):com.sun.mail.pop3.POP3Message");
    }

    public boolean delete(boolean z) throws MessagingException {
        throw new MethodNotSupportedException(RequestParameters.SUBRESOURCE_DELETE);
    }

    public boolean exists() {
        return this.exists;
    }

    public Message[] expunge() throws MessagingException {
        throw new MethodNotSupportedException("Expunge not supported");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0071, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void fetch(javax.mail.Message[] r6, javax.mail.FetchProfile r7) throws javax.mail.MessagingException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.checkReadable()     // Catch:{ all -> 0x0072 }
            boolean r0 = r5.doneUidl     // Catch:{ all -> 0x0072 }
            r1 = 0
            if (r0 != 0) goto L_0x0055
            javax.mail.UIDFolder$FetchProfileItem r0 = javax.mail.UIDFolder.FetchProfileItem.UID     // Catch:{ all -> 0x0072 }
            boolean r0 = r7.contains((javax.mail.FetchProfile.Item) r0)     // Catch:{ all -> 0x0072 }
            if (r0 == 0) goto L_0x0055
            java.util.Vector r0 = r5.message_cache     // Catch:{ all -> 0x0072 }
            int r0 = r0.size()     // Catch:{ all -> 0x0072 }
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch:{ all -> 0x0072 }
            com.sun.mail.pop3.Protocol r2 = r5.port     // Catch:{ EOFException -> 0x0047, IOException -> 0x003e }
            boolean r2 = r2.uidl((java.lang.String[]) r0)     // Catch:{ EOFException -> 0x0047, IOException -> 0x003e }
            if (r2 != 0) goto L_0x0023
            monitor-exit(r5)
            return
        L_0x0023:
            r2 = 0
        L_0x0024:
            int r3 = r0.length     // Catch:{ all -> 0x0072 }
            if (r2 < r3) goto L_0x002b
            r0 = 1
            r5.doneUidl = r0     // Catch:{ all -> 0x0072 }
            goto L_0x0055
        L_0x002b:
            r3 = r0[r2]     // Catch:{ all -> 0x0072 }
            if (r3 == 0) goto L_0x003b
            int r3 = r2 + 1
            javax.mail.Message r3 = r5.getMessage(r3)     // Catch:{ all -> 0x0072 }
            com.sun.mail.pop3.POP3Message r3 = (com.sun.mail.pop3.POP3Message) r3     // Catch:{ all -> 0x0072 }
            r4 = r0[r2]     // Catch:{ all -> 0x0072 }
            r3.uid = r4     // Catch:{ all -> 0x0072 }
        L_0x003b:
            int r2 = r2 + 1
            goto L_0x0024
        L_0x003e:
            r6 = move-exception
            javax.mail.MessagingException r7 = new javax.mail.MessagingException     // Catch:{ all -> 0x0072 }
            java.lang.String r0 = "error getting UIDL"
            r7.<init>(r0, r6)     // Catch:{ all -> 0x0072 }
            throw r7     // Catch:{ all -> 0x0072 }
        L_0x0047:
            r6 = move-exception
            r5.close(r1)     // Catch:{ all -> 0x0072 }
            javax.mail.FolderClosedException r7 = new javax.mail.FolderClosedException     // Catch:{ all -> 0x0072 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0072 }
            r7.<init>(r5, r6)     // Catch:{ all -> 0x0072 }
            throw r7     // Catch:{ all -> 0x0072 }
        L_0x0055:
            javax.mail.FetchProfile$Item r0 = javax.mail.FetchProfile.Item.ENVELOPE     // Catch:{ all -> 0x0072 }
            boolean r7 = r7.contains((javax.mail.FetchProfile.Item) r0)     // Catch:{ all -> 0x0072 }
            if (r7 == 0) goto L_0x0070
        L_0x005d:
            int r7 = r6.length     // Catch:{ all -> 0x0072 }
            if (r1 < r7) goto L_0x0061
            goto L_0x0070
        L_0x0061:
            r7 = r6[r1]     // Catch:{ MessageRemovedException -> 0x006d }
            com.sun.mail.pop3.POP3Message r7 = (com.sun.mail.pop3.POP3Message) r7     // Catch:{ MessageRemovedException -> 0x006d }
            java.lang.String r0 = ""
            r7.getHeader(r0)     // Catch:{ MessageRemovedException -> 0x006d }
            r7.getSize()     // Catch:{ MessageRemovedException -> 0x006d }
        L_0x006d:
            int r1 = r1 + 1
            goto L_0x005d
        L_0x0070:
            monitor-exit(r5)
            return
        L_0x0072:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.POP3Folder.fetch(javax.mail.Message[], javax.mail.FetchProfile):void");
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        close(false);
    }

    public Folder getFolder(String str) throws MessagingException {
        throw new MessagingException("not a directory");
    }

    public String getFullName() {
        return this.name;
    }

    public synchronized Message getMessage(int i) throws MessagingException {
        POP3Message pOP3Message;
        checkOpen();
        int i2 = i - 1;
        pOP3Message = (POP3Message) this.message_cache.elementAt(i2);
        if (pOP3Message == null) {
            pOP3Message = createMessage(this, i);
            this.message_cache.setElementAt(pOP3Message, i2);
        }
        return pOP3Message;
    }

    public synchronized int getMessageCount() throws MessagingException {
        if (!this.opened) {
            return -1;
        }
        checkReadable();
        return this.total;
    }

    public String getName() {
        return this.name;
    }

    public Folder getParent() {
        return new DefaultFolder((POP3Store) this.store);
    }

    public Flags getPermanentFlags() {
        return new Flags();
    }

    /* access modifiers changed from: package-private */
    public Protocol getProtocol() throws MessagingException {
        checkOpen();
        return this.port;
    }

    public char getSeparator() {
        return 0;
    }

    public synchronized int getSize() throws MessagingException {
        checkOpen();
        return this.size;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:8|9|(1:11)(4:17|18|(2:22|56)|53)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:26|27|(0)|(0)|37|38) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        if (r2 == null) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0045, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x005e, code lost:
        if (r2 == null) goto L_0x0061;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0057 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0014 */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004f A[SYNTHETIC, Splitter:B:31:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0054 A[SYNTHETIC, Splitter:B:35:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x005b A[SYNTHETIC, Splitter:B:43:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0014 A[LOOP:0: B:8:0x0014->B:53:0x0014, LOOP_START, SYNTHETIC, Splitter:B:8:0x0014] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int[] getSizes() throws javax.mail.MessagingException {
        /*
            r6 = this;
            monitor-enter(r6)
            r6.checkOpen()     // Catch:{ all -> 0x0063 }
            int r0 = r6.total     // Catch:{ all -> 0x0063 }
            int[] r0 = new int[r0]     // Catch:{ all -> 0x0063 }
            r1 = 0
            com.sun.mail.pop3.Protocol r2 = r6.port     // Catch:{ IOException -> 0x0058, all -> 0x004a }
            java.io.InputStream r2 = r2.list()     // Catch:{ IOException -> 0x0058, all -> 0x004a }
            com.sun.mail.util.LineInputStream r3 = new com.sun.mail.util.LineInputStream     // Catch:{ IOException -> 0x0059, all -> 0x0047 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x0059, all -> 0x0047 }
        L_0x0014:
            java.lang.String r1 = r3.readLine()     // Catch:{ IOException -> 0x0045, all -> 0x0043 }
            if (r1 != 0) goto L_0x0023
            r3.close()     // Catch:{ IOException -> 0x001d }
        L_0x001d:
            if (r2 == 0) goto L_0x0061
        L_0x001f:
            r2.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0061
        L_0x0023:
            java.util.StringTokenizer r4 = new java.util.StringTokenizer     // Catch:{ Exception -> 0x0014 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x0014 }
            java.lang.String r1 = r4.nextToken()     // Catch:{ Exception -> 0x0014 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x0014 }
            java.lang.String r4 = r4.nextToken()     // Catch:{ Exception -> 0x0014 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x0014 }
            if (r1 <= 0) goto L_0x0014
            int r5 = r6.total     // Catch:{ Exception -> 0x0014 }
            if (r1 > r5) goto L_0x0014
            int r1 = r1 + -1
            r0[r1] = r4     // Catch:{ Exception -> 0x0014 }
            goto L_0x0014
        L_0x0043:
            r0 = move-exception
            goto L_0x004d
        L_0x0045:
            r1 = r3
            goto L_0x0059
        L_0x0047:
            r0 = move-exception
            r3 = r1
            goto L_0x004d
        L_0x004a:
            r0 = move-exception
            r2 = r1
            r3 = r2
        L_0x004d:
            if (r3 == 0) goto L_0x0052
            r3.close()     // Catch:{ IOException -> 0x0052 }
        L_0x0052:
            if (r2 == 0) goto L_0x0057
            r2.close()     // Catch:{ IOException -> 0x0057 }
        L_0x0057:
            throw r0     // Catch:{ all -> 0x0063 }
        L_0x0058:
            r2 = r1
        L_0x0059:
            if (r1 == 0) goto L_0x005e
            r1.close()     // Catch:{ IOException -> 0x005e }
        L_0x005e:
            if (r2 == 0) goto L_0x0061
            goto L_0x001f
        L_0x0061:
            monitor-exit(r6)
            return r0
        L_0x0063:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.POP3Folder.getSizes():int[]");
    }

    public int getType() {
        return 1;
    }

    public synchronized String getUID(Message message) throws MessagingException {
        POP3Message pOP3Message;
        checkOpen();
        pOP3Message = (POP3Message) message;
        try {
            if (pOP3Message.uid == "UNKNOWN") {
                pOP3Message.uid = this.port.uidl(pOP3Message.getMessageNumber());
            }
        } catch (EOFException e) {
            close(false);
            throw new FolderClosedException(this, e.toString());
        } catch (IOException e2) {
            throw new MessagingException("error getting UIDL", e2);
        }
        return pOP3Message.uid;
    }

    public boolean hasNewMessages() throws MessagingException {
        return false;
    }

    public boolean isOpen() {
        if (!this.opened) {
            return false;
        }
        if (this.store.isConnected()) {
            return true;
        }
        try {
            close(false);
        } catch (MessagingException unused) {
        }
        return false;
    }

    public Folder[] list(String str) throws MessagingException {
        throw new MessagingException("not a directory");
    }

    public synchronized InputStream listCommand() throws MessagingException, IOException {
        checkOpen();
        return this.port.list();
    }

    /* access modifiers changed from: protected */
    public void notifyMessageChangedListeners(int i, Message message) {
        super.notifyMessageChangedListeners(i, message);
    }

    public synchronized void open(int i) throws MessagingException {
        POP3Store pOP3Store;
        checkClosed();
        if (!this.exists) {
            throw new FolderNotFoundException((Folder) this, "folder is not INBOX");
        }
        try {
            this.port = ((POP3Store) this.store).getPort(this);
            Status stat = this.port.stat();
            this.total = stat.total;
            this.size = stat.size;
            this.mode = i;
            this.opened = true;
            this.message_cache = new Vector(this.total);
            this.message_cache.setSize(this.total);
            this.doneUidl = false;
            notifyConnectionListeners(1);
        } catch (IOException unused) {
            this.port = null;
            pOP3Store = (POP3Store) this.store;
        } catch (IOException e) {
            if (this.port != null) {
                this.port.quit();
            }
            this.port = null;
            pOP3Store = (POP3Store) this.store;
        } catch (Throwable th) {
            this.port = null;
            ((POP3Store) this.store).closePort(this);
            throw th;
        }
        return;
        pOP3Store.closePort(this);
        throw new MessagingException("Open failed", e);
    }

    public boolean renameTo(Folder folder) throws MessagingException {
        throw new MethodNotSupportedException("renameTo");
    }
}
