package com.sun.mail.imap;

import com.sun.mail.iap.BadCommandException;
import com.sun.mail.iap.CommandFailedException;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.iap.ResponseHandler;
import com.sun.mail.imap.Utility;
import com.sun.mail.imap.protocol.FetchResponse;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.imap.protocol.IMAPResponse;
import com.sun.mail.imap.protocol.ListInfo;
import com.sun.mail.imap.protocol.MessageSet;
import com.sun.mail.imap.protocol.Status;
import com.sun.mail.imap.protocol.UID;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.Vector;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.FolderNotFoundException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.Quota;
import javax.mail.StoreClosedException;
import javax.mail.UIDFolder;
import javax.mail.search.FlagTerm;
import org.apache.commons.io.IOUtils;

public class IMAPFolder extends Folder implements ResponseHandler, UIDFolder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ABORTING = 2;
    private static final int IDLE = 1;
    private static final int RUNNING = 0;
    protected static final char UNKNOWN_SEPARATOR = '￿';
    protected String[] attributes;
    protected Flags availableFlags;
    private Status cachedStatus;
    private long cachedStatusTime;
    private boolean connectionPoolDebug;
    private boolean debug;
    private boolean doExpungeNotification;
    protected boolean exists;
    protected String fullName;
    /* access modifiers changed from: private */
    public int idleState;
    protected boolean isNamespace;
    protected Vector messageCache;
    protected Object messageCacheLock;
    protected String name;
    private boolean opened;
    private PrintStream out;
    protected Flags permanentFlags;
    protected IMAPProtocol protocol;
    private int realTotal;
    private boolean reallyClosed;
    private int recent;
    protected char separator;
    private int total;
    protected int type;
    protected Hashtable uidTable;
    private long uidnext;
    private long uidvalidity;

    public static class FetchProfileItem extends FetchProfile.Item {
        public static final FetchProfileItem HEADERS = new FetchProfileItem("HEADERS");
        public static final FetchProfileItem SIZE = new FetchProfileItem("SIZE");

        protected FetchProfileItem(String str) {
            super(str);
        }
    }

    public interface ProtocolCommand {
        Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException;
    }

    protected IMAPFolder(ListInfo listInfo, IMAPStore iMAPStore) {
        this(listInfo.name, listInfo.separator, iMAPStore);
        if (listInfo.hasInferiors) {
            this.type |= 2;
        }
        if (listInfo.canOpen) {
            this.type |= 1;
        }
        this.exists = true;
        this.attributes = listInfo.attrs;
    }

    protected IMAPFolder(String str, char c2, IMAPStore iMAPStore) {
        super(iMAPStore);
        int indexOf;
        this.exists = false;
        this.isNamespace = false;
        this.opened = false;
        this.reallyClosed = true;
        this.idleState = 0;
        this.total = -1;
        this.recent = -1;
        this.realTotal = -1;
        this.uidvalidity = -1;
        this.uidnext = -1;
        this.doExpungeNotification = true;
        this.cachedStatus = null;
        this.cachedStatusTime = 0;
        this.debug = false;
        if (str == null) {
            throw new NullPointerException("Folder name is null");
        }
        this.fullName = str;
        this.separator = c2;
        this.messageCacheLock = new Object();
        this.debug = iMAPStore.getSession().getDebug();
        this.connectionPoolDebug = iMAPStore.getConnectionPoolDebug();
        this.out = iMAPStore.getSession().getDebugOut();
        if (this.out == null) {
            this.out = System.out;
        }
        this.isNamespace = false;
        if (c2 != 65535 && c2 != 0 && (indexOf = this.fullName.indexOf(c2)) > 0 && indexOf == this.fullName.length() - 1) {
            this.fullName = this.fullName.substring(0, indexOf);
            this.isNamespace = true;
        }
    }

    protected IMAPFolder(String str, char c2, IMAPStore iMAPStore, boolean z) {
        this(str, c2, iMAPStore);
        this.isNamespace = z;
    }

    private void checkClosed() {
        if (this.opened) {
            throw new IllegalStateException("This operation is not allowed on an open folder");
        }
    }

    private void checkExists() throws MessagingException {
        if (!this.exists && !exists()) {
            throw new FolderNotFoundException((Folder) this, String.valueOf(this.fullName) + " not found");
        }
    }

    private void checkFlags(Flags flags) throws MessagingException {
        if (this.mode != 2) {
            throw new IllegalStateException("Cannot change flags on READ_ONLY folder: " + this.fullName);
        }
    }

    private void checkOpened() throws FolderClosedException {
        if (this.opened) {
            return;
        }
        if (this.reallyClosed) {
            throw new IllegalStateException("This operation is not allowed on a closed folder");
        }
        throw new FolderClosedException(this, "Lost folder connection to server");
    }

    private void checkRange(int i) throws MessagingException {
        if (i <= 0) {
            throw new IndexOutOfBoundsException();
        } else if (i > this.total) {
            synchronized (this.messageCacheLock) {
                try {
                    keepConnectionAlive(false);
                } catch (ConnectionException e) {
                    throw new FolderClosedException(this, e.getMessage());
                } catch (ProtocolException e2) {
                    throw new MessagingException(e2.getMessage(), e2);
                }
            }
            if (i > this.total) {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    private void cleanup(boolean z) {
        releaseProtocol(z);
        this.protocol = null;
        this.messageCache = null;
        this.uidTable = null;
        this.exists = false;
        this.attributes = null;
        this.opened = false;
        this.idleState = 0;
        notifyConnectionListeners(3);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:36|37|38|39|(1:41)) */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0098, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x007e */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0082 A[Catch:{ ProtocolException -> 0x009b, all -> 0x0099 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void close(boolean r4, boolean r5) throws javax.mail.MessagingException {
        /*
            r3 = this;
            java.lang.Object r0 = r3.messageCacheLock
            monitor-enter(r0)
            boolean r1 = r3.opened     // Catch:{ all -> 0x00ae }
            if (r1 != 0) goto L_0x0013
            boolean r1 = r3.reallyClosed     // Catch:{ all -> 0x00ae }
            if (r1 == 0) goto L_0x0013
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00ae }
            java.lang.String r5 = "This operation is not allowed on a closed folder"
            r4.<init>(r5)     // Catch:{ all -> 0x00ae }
            throw r4     // Catch:{ all -> 0x00ae }
        L_0x0013:
            r1 = 1
            r3.reallyClosed = r1     // Catch:{ all -> 0x00ae }
            boolean r2 = r3.opened     // Catch:{ all -> 0x00ae }
            if (r2 != 0) goto L_0x001c
            monitor-exit(r0)     // Catch:{ all -> 0x00ae }
            return
        L_0x001c:
            r3.waitIfIdle()     // Catch:{ ProtocolException -> 0x009b }
            if (r5 == 0) goto L_0x0049
            boolean r4 = r3.debug     // Catch:{ ProtocolException -> 0x009b }
            if (r4 == 0) goto L_0x003f
            java.io.PrintStream r4 = r3.out     // Catch:{ ProtocolException -> 0x009b }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ ProtocolException -> 0x009b }
            java.lang.String r2 = "DEBUG: forcing folder "
            r5.<init>(r2)     // Catch:{ ProtocolException -> 0x009b }
            java.lang.String r2 = r3.fullName     // Catch:{ ProtocolException -> 0x009b }
            r5.append(r2)     // Catch:{ ProtocolException -> 0x009b }
            java.lang.String r2 = " to close"
            r5.append(r2)     // Catch:{ ProtocolException -> 0x009b }
            java.lang.String r5 = r5.toString()     // Catch:{ ProtocolException -> 0x009b }
            r4.println(r5)     // Catch:{ ProtocolException -> 0x009b }
        L_0x003f:
            com.sun.mail.imap.protocol.IMAPProtocol r4 = r3.protocol     // Catch:{ ProtocolException -> 0x009b }
            if (r4 == 0) goto L_0x0090
            com.sun.mail.imap.protocol.IMAPProtocol r4 = r3.protocol     // Catch:{ ProtocolException -> 0x009b }
            r4.disconnect()     // Catch:{ ProtocolException -> 0x009b }
            goto L_0x0090
        L_0x0049:
            javax.mail.Store r5 = r3.store     // Catch:{ ProtocolException -> 0x009b }
            com.sun.mail.imap.IMAPStore r5 = (com.sun.mail.imap.IMAPStore) r5     // Catch:{ ProtocolException -> 0x009b }
            boolean r5 = r5.isConnectionPoolFull()     // Catch:{ ProtocolException -> 0x009b }
            if (r5 == 0) goto L_0x006f
            boolean r5 = r3.debug     // Catch:{ ProtocolException -> 0x009b }
            if (r5 == 0) goto L_0x005e
            java.io.PrintStream r5 = r3.out     // Catch:{ ProtocolException -> 0x009b }
            java.lang.String r2 = "DEBUG: pool is full, not adding an Authenticated connection"
            r5.println(r2)     // Catch:{ ProtocolException -> 0x009b }
        L_0x005e:
            if (r4 == 0) goto L_0x0065
            com.sun.mail.imap.protocol.IMAPProtocol r4 = r3.protocol     // Catch:{ ProtocolException -> 0x009b }
            r4.close()     // Catch:{ ProtocolException -> 0x009b }
        L_0x0065:
            com.sun.mail.imap.protocol.IMAPProtocol r4 = r3.protocol     // Catch:{ ProtocolException -> 0x009b }
            if (r4 == 0) goto L_0x0090
            com.sun.mail.imap.protocol.IMAPProtocol r4 = r3.protocol     // Catch:{ ProtocolException -> 0x009b }
            r4.logout()     // Catch:{ ProtocolException -> 0x009b }
            goto L_0x0090
        L_0x006f:
            if (r4 != 0) goto L_0x0087
            int r4 = r3.mode     // Catch:{ ProtocolException -> 0x009b }
            r5 = 2
            if (r4 != r5) goto L_0x0087
            com.sun.mail.imap.protocol.IMAPProtocol r4 = r3.protocol     // Catch:{ ProtocolException -> 0x007e }
            java.lang.String r5 = r3.fullName     // Catch:{ ProtocolException -> 0x007e }
            r4.examine(r5)     // Catch:{ ProtocolException -> 0x007e }
            goto L_0x0087
        L_0x007e:
            com.sun.mail.imap.protocol.IMAPProtocol r4 = r3.protocol     // Catch:{ ProtocolException -> 0x009b }
            if (r4 == 0) goto L_0x0087
            com.sun.mail.imap.protocol.IMAPProtocol r4 = r3.protocol     // Catch:{ ProtocolException -> 0x009b }
            r4.disconnect()     // Catch:{ ProtocolException -> 0x009b }
        L_0x0087:
            com.sun.mail.imap.protocol.IMAPProtocol r4 = r3.protocol     // Catch:{ ProtocolException -> 0x009b }
            if (r4 == 0) goto L_0x0090
            com.sun.mail.imap.protocol.IMAPProtocol r4 = r3.protocol     // Catch:{ ProtocolException -> 0x009b }
            r4.close()     // Catch:{ ProtocolException -> 0x009b }
        L_0x0090:
            boolean r4 = r3.opened     // Catch:{ all -> 0x00ae }
            if (r4 == 0) goto L_0x0097
            r3.cleanup(r1)     // Catch:{ all -> 0x00ae }
        L_0x0097:
            monitor-exit(r0)     // Catch:{ all -> 0x00ae }
            return
        L_0x0099:
            r4 = move-exception
            goto L_0x00a6
        L_0x009b:
            r4 = move-exception
            javax.mail.MessagingException r5 = new javax.mail.MessagingException     // Catch:{ all -> 0x0099 }
            java.lang.String r2 = r4.getMessage()     // Catch:{ all -> 0x0099 }
            r5.<init>(r2, r4)     // Catch:{ all -> 0x0099 }
            throw r5     // Catch:{ all -> 0x0099 }
        L_0x00a6:
            boolean r5 = r3.opened     // Catch:{ all -> 0x00ae }
            if (r5 == 0) goto L_0x00ad
            r3.cleanup(r1)     // Catch:{ all -> 0x00ae }
        L_0x00ad:
            throw r4     // Catch:{ all -> 0x00ae }
        L_0x00ae:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00ae }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.close(boolean, boolean):void");
    }

    private synchronized Folder[] doList(final String str, final boolean z) throws MessagingException {
        checkExists();
        int i = 0;
        if (!isDirectory()) {
            return new Folder[0];
        }
        final char separator2 = getSeparator();
        ListInfo[] listInfoArr = (ListInfo[]) doCommandIgnoreFailure(new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                if (z) {
                    return iMAPProtocol.lsub("", String.valueOf(IMAPFolder.this.fullName) + separator2 + str);
                }
                return iMAPProtocol.list("", String.valueOf(IMAPFolder.this.fullName) + separator2 + str);
            }
        });
        if (listInfoArr == null) {
            return new Folder[0];
        }
        if (listInfoArr.length > 0) {
            String str2 = listInfoArr[0].name;
            if (str2.equals(String.valueOf(this.fullName) + separator2)) {
                i = 1;
            }
        }
        IMAPFolder[] iMAPFolderArr = new IMAPFolder[(listInfoArr.length - i)];
        for (int i2 = i; i2 < listInfoArr.length; i2++) {
            iMAPFolderArr[i2 - i] = new IMAPFolder(listInfoArr[i2], (IMAPStore) this.store);
        }
        return iMAPFolderArr;
    }

    private int findName(ListInfo[] listInfoArr, String str) {
        int i = 0;
        while (i < listInfoArr.length && !listInfoArr[i].name.equals(str)) {
            i++;
        }
        if (i >= listInfoArr.length) {
            return 0;
        }
        return i;
    }

    private IMAPProtocol getProtocol() throws ProtocolException {
        waitIfIdle();
        return this.protocol;
    }

    /* access modifiers changed from: private */
    public Status getStatus() throws ProtocolException {
        IMAPProtocol iMAPProtocol;
        int statusCacheTimeout = ((IMAPStore) this.store).getStatusCacheTimeout();
        if (statusCacheTimeout > 0 && this.cachedStatus != null && System.currentTimeMillis() - this.cachedStatusTime < ((long) statusCacheTimeout)) {
            return this.cachedStatus;
        }
        try {
            iMAPProtocol = getStoreProtocol();
            try {
                Status status = iMAPProtocol.status(this.fullName, (String[]) null);
                if (statusCacheTimeout > 0) {
                    this.cachedStatus = status;
                    this.cachedStatusTime = System.currentTimeMillis();
                }
                releaseStoreProtocol(iMAPProtocol);
                return status;
            } catch (Throwable th) {
                th = th;
                releaseStoreProtocol(iMAPProtocol);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            iMAPProtocol = null;
            releaseStoreProtocol(iMAPProtocol);
            throw th;
        }
    }

    private boolean isDirectory() {
        return (this.type & 2) != 0;
    }

    private void keepConnectionAlive(boolean z) throws ProtocolException {
        Throwable th;
        IMAPProtocol iMAPProtocol;
        if (System.currentTimeMillis() - this.protocol.getTimestamp() > 1000) {
            waitIfIdle();
            this.protocol.noop();
        }
        if (z && ((IMAPStore) this.store).hasSeparateStoreConnection()) {
            try {
                iMAPProtocol = ((IMAPStore) this.store).getStoreProtocol();
                try {
                    if (System.currentTimeMillis() - iMAPProtocol.getTimestamp() > 1000) {
                        iMAPProtocol.noop();
                    }
                    ((IMAPStore) this.store).releaseStoreProtocol(iMAPProtocol);
                } catch (Throwable th2) {
                    th = th2;
                    ((IMAPStore) this.store).releaseStoreProtocol(iMAPProtocol);
                    throw th;
                }
            } catch (Throwable th3) {
                iMAPProtocol = null;
                th = th3;
                ((IMAPStore) this.store).releaseStoreProtocol(iMAPProtocol);
                throw th;
            }
        }
    }

    private void releaseProtocol(boolean z) {
        if (this.protocol != null) {
            this.protocol.removeResponseHandler(this);
            if (z) {
                ((IMAPStore) this.store).releaseProtocol(this, this.protocol);
            } else {
                ((IMAPStore) this.store).releaseProtocol(this, (IMAPProtocol) null);
            }
        }
    }

    private void setACL(final ACL acl, final char c2) throws MessagingException {
        doOptionalCommand("ACL not supported", new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                iMAPProtocol.setACL(IMAPFolder.this.fullName, c2, acl);
                return null;
            }
        });
    }

    private synchronized void throwClosedException(ConnectionException connectionException) throws FolderClosedException, StoreClosedException {
        if ((this.protocol == null || connectionException.getProtocol() != this.protocol) && (this.protocol != null || this.reallyClosed)) {
            throw new StoreClosedException(this.store, connectionException.getMessage());
        }
        throw new FolderClosedException(this, connectionException.getMessage());
    }

    public void addACL(ACL acl) throws MessagingException {
        setACL(acl, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: javax.mail.internet.MimeMessage[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized javax.mail.Message[] addMessages(javax.mail.Message[] r9) throws javax.mail.MessagingException {
        /*
            r8 = this;
            monitor-enter(r8)
            r8.checkOpened()     // Catch:{ all -> 0x0028 }
            int r0 = r9.length     // Catch:{ all -> 0x0028 }
            javax.mail.internet.MimeMessage[] r0 = new javax.mail.internet.MimeMessage[r0]     // Catch:{ all -> 0x0028 }
            com.sun.mail.imap.AppendUID[] r9 = r8.appendUIDMessages(r9)     // Catch:{ all -> 0x0028 }
            r1 = 0
        L_0x000c:
            int r2 = r9.length     // Catch:{ all -> 0x0028 }
            if (r1 < r2) goto L_0x0011
            monitor-exit(r8)
            return r0
        L_0x0011:
            r2 = r9[r1]     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x0025
            long r3 = r2.uidvalidity     // Catch:{ all -> 0x0028 }
            long r5 = r8.uidvalidity     // Catch:{ all -> 0x0028 }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0025
            long r2 = r2.uid     // Catch:{ MessagingException -> 0x0025 }
            javax.mail.Message r2 = r8.getMessageByUID(r2)     // Catch:{ MessagingException -> 0x0025 }
            r0[r1] = r2     // Catch:{ MessagingException -> 0x0025 }
        L_0x0025:
            int r1 = r1 + 1
            goto L_0x000c
        L_0x0028:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.addMessages(javax.mail.Message[]):javax.mail.Message[]");
    }

    public void addRights(ACL acl) throws MessagingException {
        setACL(acl, '+');
    }

    public synchronized void appendMessages(Message[] messageArr) throws MessagingException {
        checkExists();
        int appendBufferSize = ((IMAPStore) this.store).getAppendBufferSize();
        for (Message message : messageArr) {
            try {
                final MessageLiteral messageLiteral = new MessageLiteral(message, message.getSize() > appendBufferSize ? 0 : appendBufferSize);
                final Date receivedDate = message.getReceivedDate();
                if (receivedDate == null) {
                    receivedDate = message.getSentDate();
                }
                final Flags flags = message.getFlags();
                doCommand(new ProtocolCommand() {
                    public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                        iMAPProtocol.append(IMAPFolder.this.fullName, flags, receivedDate, messageLiteral);
                        return null;
                    }
                });
            } catch (IOException e) {
                throw new MessagingException("IOException while appending messages", e);
            } catch (MessageRemovedException unused) {
            }
        }
    }

    public synchronized AppendUID[] appendUIDMessages(Message[] messageArr) throws MessagingException {
        AppendUID[] appendUIDArr;
        checkExists();
        int appendBufferSize = ((IMAPStore) this.store).getAppendBufferSize();
        appendUIDArr = new AppendUID[messageArr.length];
        for (int i = 0; i < messageArr.length; i++) {
            Message message = messageArr[i];
            try {
                final MessageLiteral messageLiteral = new MessageLiteral(message, message.getSize() > appendBufferSize ? 0 : appendBufferSize);
                final Date receivedDate = message.getReceivedDate();
                if (receivedDate == null) {
                    receivedDate = message.getSentDate();
                }
                final Flags flags = message.getFlags();
                appendUIDArr[i] = (AppendUID) doCommand(new ProtocolCommand() {
                    public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                        return iMAPProtocol.appenduid(IMAPFolder.this.fullName, flags, receivedDate, messageLiteral);
                    }
                });
            } catch (IOException e) {
                throw new MessagingException("IOException while appending messages", e);
            } catch (MessageRemovedException unused) {
            }
        }
        return appendUIDArr;
    }

    public synchronized void close(boolean z) throws MessagingException {
        close(z, false);
    }

    public synchronized void copyMessages(Message[] messageArr, Folder folder) throws MessagingException {
        checkOpened();
        if (messageArr.length != 0) {
            if (folder.getStore() == this.store) {
                synchronized (this.messageCacheLock) {
                    try {
                        IMAPProtocol protocol2 = getProtocol();
                        MessageSet[] messageSet = Utility.toMessageSet(messageArr, (Utility.Condition) null);
                        if (messageSet == null) {
                            throw new MessageRemovedException("Messages have been removed");
                        }
                        protocol2.copy(messageSet, folder.getFullName());
                    } catch (CommandFailedException e) {
                        if (e.getMessage().indexOf("TRYCREATE") != -1) {
                            throw new FolderNotFoundException(folder, String.valueOf(folder.getFullName()) + " does not exist");
                        }
                        throw new MessagingException(e.getMessage(), e);
                    } catch (ConnectionException e2) {
                        throw new FolderClosedException(this, e2.getMessage());
                    } catch (ProtocolException e3) {
                        throw new MessagingException(e3.getMessage(), e3);
                    }
                }
                return;
            }
            super.copyMessages(messageArr, folder);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0026, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean create(final int r4) throws javax.mail.MessagingException {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = r4 & 1
            r1 = 0
            if (r0 != 0) goto L_0x000d
            char r0 = r3.getSeparator()     // Catch:{ all -> 0x000b }
            goto L_0x000e
        L_0x000b:
            r4 = move-exception
            goto L_0x0027
        L_0x000d:
            r0 = 0
        L_0x000e:
            com.sun.mail.imap.IMAPFolder$6 r2 = new com.sun.mail.imap.IMAPFolder$6     // Catch:{ all -> 0x000b }
            r2.<init>(r4, r0)     // Catch:{ all -> 0x000b }
            java.lang.Object r4 = r3.doCommandIgnoreFailure(r2)     // Catch:{ all -> 0x000b }
            if (r4 != 0) goto L_0x001b
            monitor-exit(r3)
            return r1
        L_0x001b:
            boolean r4 = r3.exists()     // Catch:{ all -> 0x000b }
            if (r4 == 0) goto L_0x0025
            r0 = 1
            r3.notifyFolderListeners(r0)     // Catch:{ all -> 0x000b }
        L_0x0025:
            monitor-exit(r3)
            return r4
        L_0x0027:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.create(int):boolean");
    }

    public synchronized boolean delete(boolean z) throws MessagingException {
        checkClosed();
        if (z) {
            Folder[] list = list();
            for (Folder delete : list) {
                delete.delete(z);
            }
        }
        if (doCommandIgnoreFailure(new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                iMAPProtocol.delete(IMAPFolder.this.fullName);
                return Boolean.TRUE;
            }
        }) == null) {
            return false;
        }
        this.exists = false;
        this.attributes = null;
        notifyFolderListeners(2);
        return true;
    }

    public Object doCommand(ProtocolCommand protocolCommand) throws MessagingException {
        try {
            return doProtocolCommand(protocolCommand);
        } catch (ConnectionException e) {
            throwClosedException(e);
            return null;
        } catch (ProtocolException e2) {
            throw new MessagingException(e2.getMessage(), e2);
        }
    }

    public Object doCommandIgnoreFailure(ProtocolCommand protocolCommand) throws MessagingException {
        try {
            return doProtocolCommand(protocolCommand);
        } catch (CommandFailedException unused) {
            return null;
        } catch (ConnectionException e) {
            throwClosedException(e);
            return null;
        } catch (ProtocolException e2) {
            throw new MessagingException(e2.getMessage(), e2);
        }
    }

    public Object doOptionalCommand(String str, ProtocolCommand protocolCommand) throws MessagingException {
        try {
            return doProtocolCommand(protocolCommand);
        } catch (BadCommandException e) {
            throw new MessagingException(str, e);
        } catch (ConnectionException e2) {
            throwClosedException(e2);
            return null;
        } catch (ProtocolException e3) {
            throw new MessagingException(e3.getMessage(), e3);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0021, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r1 = getStoreProtocol();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r3 = r3.doCommand(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x002a, code lost:
        releaseStoreProtocol(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x002d, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x002e, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x002f, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0031, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0032, code lost:
        releaseStoreProtocol(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0035, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object doProtocolCommand(com.sun.mail.imap.IMAPFolder.ProtocolCommand r3) throws com.sun.mail.iap.ProtocolException {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.opened     // Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x0020
            javax.mail.Store r0 = r2.store     // Catch:{ all -> 0x0036 }
            com.sun.mail.imap.IMAPStore r0 = (com.sun.mail.imap.IMAPStore) r0     // Catch:{ all -> 0x0036 }
            boolean r0 = r0.hasSeparateStoreConnection()     // Catch:{ all -> 0x0036 }
            if (r0 != 0) goto L_0x0020
            java.lang.Object r0 = r2.messageCacheLock     // Catch:{ all -> 0x0036 }
            monitor-enter(r0)     // Catch:{ all -> 0x0036 }
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r2.getProtocol()     // Catch:{ all -> 0x001d }
            java.lang.Object r3 = r3.doCommand(r1)     // Catch:{ all -> 0x001d }
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            monitor-exit(r2)     // Catch:{ all -> 0x0036 }
            return r3
        L_0x001d:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            throw r3     // Catch:{ all -> 0x0036 }
        L_0x0020:
            monitor-exit(r2)     // Catch:{ all -> 0x0036 }
            r0 = 0
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r2.getStoreProtocol()     // Catch:{ all -> 0x0031 }
            java.lang.Object r3 = r3.doCommand(r1)     // Catch:{ all -> 0x002e }
            r2.releaseStoreProtocol(r1)
            return r3
        L_0x002e:
            r3 = move-exception
            r0 = r1
            goto L_0x0032
        L_0x0031:
            r3 = move-exception
        L_0x0032:
            r2.releaseStoreProtocol(r0)
            throw r3
        L_0x0036:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0036 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.doProtocolCommand(com.sun.mail.imap.IMAPFolder$ProtocolCommand):java.lang.Object");
    }

    public synchronized boolean exists() throws MessagingException {
        final String str;
        if (!this.isNamespace || this.separator == 0) {
            str = this.fullName;
        } else {
            str = String.valueOf(this.fullName) + this.separator;
        }
        ListInfo[] listInfoArr = (ListInfo[]) doCommand(new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                return iMAPProtocol.list("", str);
            }
        });
        if (listInfoArr != null) {
            int findName = findName(listInfoArr, str);
            this.fullName = listInfoArr[findName].name;
            this.separator = listInfoArr[findName].separator;
            int length = this.fullName.length();
            if (this.separator != 0 && length > 0) {
                int i = length - 1;
                if (this.fullName.charAt(i) == this.separator) {
                    this.fullName = this.fullName.substring(0, i);
                }
            }
            this.type = 0;
            if (listInfoArr[findName].hasInferiors) {
                this.type |= 2;
            }
            if (listInfoArr[findName].canOpen) {
                this.type |= 1;
            }
            this.exists = true;
            this.attributes = listInfoArr[findName].attrs;
        } else {
            this.exists = this.opened;
            this.attributes = null;
        }
        return this.exists;
    }

    public synchronized Message[] expunge() throws MessagingException {
        return expunge((Message[]) null);
    }

    public synchronized Message[] expunge(Message[] messageArr) throws MessagingException {
        Message[] messageArr2;
        checkOpened();
        Vector vector = new Vector();
        if (messageArr != null) {
            FetchProfile fetchProfile = new FetchProfile();
            fetchProfile.add((FetchProfile.Item) UIDFolder.FetchProfileItem.UID);
            fetch(messageArr, fetchProfile);
        }
        synchronized (this.messageCacheLock) {
            int i = 0;
            this.doExpungeNotification = false;
            try {
                IMAPProtocol protocol2 = getProtocol();
                if (messageArr != null) {
                    protocol2.uidexpunge(Utility.toUIDSet(messageArr));
                } else {
                    protocol2.expunge();
                }
                this.doExpungeNotification = true;
                while (i < this.messageCache.size()) {
                    IMAPMessage iMAPMessage = (IMAPMessage) this.messageCache.elementAt(i);
                    if (iMAPMessage.isExpunged()) {
                        vector.addElement(iMAPMessage);
                        this.messageCache.removeElementAt(i);
                        if (this.uidTable != null) {
                            long uid = iMAPMessage.getUID();
                            if (uid != -1) {
                                this.uidTable.remove(new Long(uid));
                            }
                        }
                    } else {
                        iMAPMessage.setMessageNumber(iMAPMessage.getSequenceNumber());
                        i++;
                    }
                }
            } catch (CommandFailedException e) {
                if (this.mode != 2) {
                    throw new IllegalStateException("Cannot expunge READ_ONLY folder: " + this.fullName);
                }
                throw new MessagingException(e.getMessage(), e);
            } catch (ConnectionException e2) {
                throw new FolderClosedException(this, e2.getMessage());
            } catch (ProtocolException e3) {
                throw new MessagingException(e3.getMessage(), e3);
            } catch (Throwable th) {
                this.doExpungeNotification = true;
                throw th;
            }
        }
        this.total = this.messageCache.size();
        messageArr2 = new Message[vector.size()];
        vector.copyInto(messageArr2);
        if (messageArr2.length > 0) {
            notifyMessageRemovedListeners(true, messageArr2);
        }
        return messageArr2;
    }

    public synchronized void fetch(Message[] messageArr, FetchProfile fetchProfile) throws MessagingException {
        checkOpened();
        IMAPMessage.fetch(this, messageArr, fetchProfile);
    }

    public synchronized void forceClose() throws MessagingException {
        close(false, true);
    }

    public ACL[] getACL() throws MessagingException {
        return (ACL[]) doOptionalCommand("ACL not supported", new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                return iMAPProtocol.getACL(IMAPFolder.this.fullName);
            }
        });
    }

    public String[] getAttributes() throws MessagingException {
        if (this.attributes == null) {
            exists();
        }
        return (String[]) this.attributes.clone();
    }

    public synchronized int getDeletedMessageCount() throws MessagingException {
        int length;
        if (!this.opened) {
            checkExists();
            return -1;
        }
        Flags flags = new Flags();
        flags.add(Flags.Flag.DELETED);
        try {
            synchronized (this.messageCacheLock) {
                length = getProtocol().search(new FlagTerm(flags, true)).length;
            }
            return length;
        } catch (ConnectionException e) {
            throw new FolderClosedException(this, e.getMessage());
        } catch (ProtocolException e2) {
            throw new MessagingException(e2.getMessage(), e2);
        }
    }

    public Folder getFolder(String str) throws MessagingException {
        if (this.attributes == null || isDirectory()) {
            char separator2 = getSeparator();
            return new IMAPFolder(String.valueOf(this.fullName) + separator2 + str, separator2, (IMAPStore) this.store);
        }
        throw new MessagingException("Cannot contain subfolders");
    }

    public synchronized String getFullName() {
        return this.fullName;
    }

    public synchronized Message getMessage(int i) throws MessagingException {
        checkOpened();
        checkRange(i);
        return (Message) this.messageCache.elementAt(i - 1);
    }

    /* access modifiers changed from: package-private */
    public IMAPMessage getMessageBySeqNumber(int i) {
        for (int i2 = i - 1; i2 < this.total; i2++) {
            IMAPMessage iMAPMessage = (IMAPMessage) this.messageCache.elementAt(i2);
            if (iMAPMessage.getSequenceNumber() == i) {
                return iMAPMessage;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0047, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized javax.mail.Message getMessageByUID(long r5) throws javax.mail.MessagingException {
        /*
            r4 = this;
            monitor-enter(r4)
            r4.checkOpened()     // Catch:{ all -> 0x0061 }
            r0 = 0
            java.lang.Object r1 = r4.messageCacheLock     // Catch:{ ConnectionException -> 0x0056, ProtocolException -> 0x004b }
            monitor-enter(r1)     // Catch:{ ConnectionException -> 0x0056, ProtocolException -> 0x004b }
            java.lang.Long r2 = new java.lang.Long     // Catch:{ all -> 0x0048 }
            r2.<init>(r5)     // Catch:{ all -> 0x0048 }
            java.util.Hashtable r3 = r4.uidTable     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x001e
            java.util.Hashtable r0 = r4.uidTable     // Catch:{ all -> 0x0048 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x0048 }
            com.sun.mail.imap.IMAPMessage r0 = (com.sun.mail.imap.IMAPMessage) r0     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x0025
            monitor-exit(r1)     // Catch:{ all -> 0x0048 }
            monitor-exit(r4)
            return r0
        L_0x001e:
            java.util.Hashtable r3 = new java.util.Hashtable     // Catch:{ all -> 0x0048 }
            r3.<init>()     // Catch:{ all -> 0x0048 }
            r4.uidTable = r3     // Catch:{ all -> 0x0048 }
        L_0x0025:
            com.sun.mail.imap.protocol.IMAPProtocol r3 = r4.getProtocol()     // Catch:{ all -> 0x0048 }
            com.sun.mail.imap.protocol.UID r5 = r3.fetchSequenceNumber(r5)     // Catch:{ all -> 0x0048 }
            if (r5 == 0) goto L_0x0045
            int r6 = r5.seqnum     // Catch:{ all -> 0x0048 }
            int r3 = r4.total     // Catch:{ all -> 0x0048 }
            if (r6 > r3) goto L_0x0045
            int r6 = r5.seqnum     // Catch:{ all -> 0x0048 }
            com.sun.mail.imap.IMAPMessage r0 = r4.getMessageBySeqNumber(r6)     // Catch:{ all -> 0x0048 }
            long r5 = r5.uid     // Catch:{ all -> 0x0048 }
            r0.setUID(r5)     // Catch:{ all -> 0x0048 }
            java.util.Hashtable r5 = r4.uidTable     // Catch:{ all -> 0x0048 }
            r5.put(r2, r0)     // Catch:{ all -> 0x0048 }
        L_0x0045:
            monitor-exit(r1)     // Catch:{ all -> 0x0048 }
            monitor-exit(r4)
            return r0
        L_0x0048:
            r5 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0048 }
            throw r5     // Catch:{ ConnectionException -> 0x0056, ProtocolException -> 0x004b }
        L_0x004b:
            r5 = move-exception
            javax.mail.MessagingException r6 = new javax.mail.MessagingException     // Catch:{ all -> 0x0061 }
            java.lang.String r0 = r5.getMessage()     // Catch:{ all -> 0x0061 }
            r6.<init>(r0, r5)     // Catch:{ all -> 0x0061 }
            throw r6     // Catch:{ all -> 0x0061 }
        L_0x0056:
            r5 = move-exception
            javax.mail.FolderClosedException r6 = new javax.mail.FolderClosedException     // Catch:{ all -> 0x0061 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x0061 }
            r6.<init>(r4, r5)     // Catch:{ all -> 0x0061 }
            throw r6     // Catch:{ all -> 0x0061 }
        L_0x0061:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.getMessageByUID(long):javax.mail.Message");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        throw new javax.mail.MessagingException(r0.getMessage(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        throw new javax.mail.StoreClosedException(r5.store, r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r1 = getStoreProtocol();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0 = r1.examine(r5.fullName);
        r1.close();
        r0 = r0.total;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        releaseStoreProtocol(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003c, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0041, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0042, code lost:
        r4 = r1;
        r1 = null;
        r0 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0046, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0047, code lost:
        r4 = r1;
        r1 = null;
        r0 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0053, code lost:
        throw new javax.mail.MessagingException(r0.getMessage(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        releaseStoreProtocol(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0057, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0066, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0070, code lost:
        throw new javax.mail.MessagingException(r1.getMessage(), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0071, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x007b, code lost:
        throw new javax.mail.FolderClosedException(r5, r1.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:5:0x0008, B:41:0x005c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int getMessageCount() throws javax.mail.MessagingException {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.opened     // Catch:{ all -> 0x007e }
            if (r0 != 0) goto L_0x0058
            r5.checkExists()     // Catch:{ all -> 0x007e }
            com.sun.mail.imap.protocol.Status r0 = r5.getStatus()     // Catch:{ BadCommandException -> 0x0028, ConnectionException -> 0x001b, ProtocolException -> 0x0010 }
            int r0 = r0.total     // Catch:{ BadCommandException -> 0x0028, ConnectionException -> 0x001b, ProtocolException -> 0x0010 }
            monitor-exit(r5)
            return r0
        L_0x0010:
            r0 = move-exception
            javax.mail.MessagingException r1 = new javax.mail.MessagingException     // Catch:{ all -> 0x007e }
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x007e }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x007e }
            throw r1     // Catch:{ all -> 0x007e }
        L_0x001b:
            r0 = move-exception
            javax.mail.StoreClosedException r1 = new javax.mail.StoreClosedException     // Catch:{ all -> 0x007e }
            javax.mail.Store r2 = r5.store     // Catch:{ all -> 0x007e }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x007e }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x007e }
            throw r1     // Catch:{ all -> 0x007e }
        L_0x0028:
            r0 = 0
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r5.getStoreProtocol()     // Catch:{ ProtocolException -> 0x0046, all -> 0x0041 }
            java.lang.String r0 = r5.fullName     // Catch:{ ProtocolException -> 0x003f }
            com.sun.mail.imap.protocol.MailboxInfo r0 = r1.examine(r0)     // Catch:{ ProtocolException -> 0x003f }
            r1.close()     // Catch:{ ProtocolException -> 0x003f }
            int r0 = r0.total     // Catch:{ ProtocolException -> 0x003f }
            r5.releaseStoreProtocol(r1)     // Catch:{ all -> 0x007e }
            monitor-exit(r5)
            return r0
        L_0x003d:
            r0 = move-exception
            goto L_0x0054
        L_0x003f:
            r0 = move-exception
            goto L_0x004a
        L_0x0041:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0054
        L_0x0046:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x004a:
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x003d }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x003d }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x003d }
            throw r2     // Catch:{ all -> 0x003d }
        L_0x0054:
            r5.releaseStoreProtocol(r1)     // Catch:{ all -> 0x007e }
            throw r0     // Catch:{ all -> 0x007e }
        L_0x0058:
            java.lang.Object r0 = r5.messageCacheLock     // Catch:{ all -> 0x007e }
            monitor-enter(r0)     // Catch:{ all -> 0x007e }
            r1 = 1
            r5.keepConnectionAlive(r1)     // Catch:{ ConnectionException -> 0x0071, ProtocolException -> 0x0066 }
            int r1 = r5.total     // Catch:{ ConnectionException -> 0x0071, ProtocolException -> 0x0066 }
            monitor-exit(r0)     // Catch:{ all -> 0x0064 }
            monitor-exit(r5)
            return r1
        L_0x0064:
            r1 = move-exception
            goto L_0x007c
        L_0x0066:
            r1 = move-exception
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x0064 }
            java.lang.String r3 = r1.getMessage()     // Catch:{ all -> 0x0064 }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x0064 }
            throw r2     // Catch:{ all -> 0x0064 }
        L_0x0071:
            r1 = move-exception
            javax.mail.FolderClosedException r2 = new javax.mail.FolderClosedException     // Catch:{ all -> 0x0064 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0064 }
            r2.<init>(r5, r1)     // Catch:{ all -> 0x0064 }
            throw r2     // Catch:{ all -> 0x0064 }
        L_0x007c:
            monitor-exit(r0)     // Catch:{ all -> 0x0064 }
            throw r1     // Catch:{ all -> 0x007e }
        L_0x007e:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.getMessageCount():int");
    }

    public synchronized Message[] getMessagesByUID(long j, long j2) throws MessagingException {
        Message[] messageArr;
        checkOpened();
        try {
            synchronized (this.messageCacheLock) {
                if (this.uidTable == null) {
                    this.uidTable = new Hashtable();
                }
                UID[] fetchSequenceNumbers = getProtocol().fetchSequenceNumbers(j, j2);
                messageArr = new Message[fetchSequenceNumbers.length];
                for (int i = 0; i < fetchSequenceNumbers.length; i++) {
                    IMAPMessage messageBySeqNumber = getMessageBySeqNumber(fetchSequenceNumbers[i].seqnum);
                    messageBySeqNumber.setUID(fetchSequenceNumbers[i].uid);
                    messageArr[i] = messageBySeqNumber;
                    this.uidTable.put(new Long(fetchSequenceNumbers[i].uid), messageBySeqNumber);
                }
            }
        } catch (ConnectionException e) {
            throw new FolderClosedException(this, e.getMessage());
        } catch (ProtocolException e2) {
            throw new MessagingException(e2.getMessage(), e2);
        }
        return messageArr;
    }

    public synchronized Message[] getMessagesByUID(long[] jArr) throws MessagingException {
        long[] jArr2;
        Message[] messageArr;
        checkOpened();
        try {
            synchronized (this.messageCacheLock) {
                if (this.uidTable != null) {
                    Vector vector = new Vector();
                    for (long l : jArr) {
                        Hashtable hashtable = this.uidTable;
                        Long l2 = new Long(l);
                        if (!hashtable.containsKey(l2)) {
                            vector.addElement(l2);
                        }
                    }
                    int size = vector.size();
                    jArr2 = new long[size];
                    for (int i = 0; i < size; i++) {
                        jArr2[i] = ((Long) vector.elementAt(i)).longValue();
                    }
                } else {
                    this.uidTable = new Hashtable();
                    jArr2 = jArr;
                }
                if (jArr2.length > 0) {
                    UID[] fetchSequenceNumbers = getProtocol().fetchSequenceNumbers(jArr2);
                    for (int i2 = 0; i2 < fetchSequenceNumbers.length; i2++) {
                        IMAPMessage messageBySeqNumber = getMessageBySeqNumber(fetchSequenceNumbers[i2].seqnum);
                        messageBySeqNumber.setUID(fetchSequenceNumbers[i2].uid);
                        this.uidTable.put(new Long(fetchSequenceNumbers[i2].uid), messageBySeqNumber);
                    }
                }
                messageArr = new Message[jArr.length];
                for (int i3 = 0; i3 < jArr.length; i3++) {
                    messageArr[i3] = (Message) this.uidTable.get(new Long(jArr[i3]));
                }
            }
        } catch (ConnectionException e) {
            throw new FolderClosedException(this, e.getMessage());
        } catch (ProtocolException e2) {
            throw new MessagingException(e2.getMessage(), e2);
        }
        return messageArr;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:1|2|(2:4|5)|6|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0019 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String getName() {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = r3.name     // Catch:{ all -> 0x001d }
            if (r0 != 0) goto L_0x0019
            java.lang.String r0 = r3.fullName     // Catch:{ MessagingException -> 0x0019 }
            java.lang.String r1 = r3.fullName     // Catch:{ MessagingException -> 0x0019 }
            char r2 = r3.getSeparator()     // Catch:{ MessagingException -> 0x0019 }
            int r1 = r1.lastIndexOf(r2)     // Catch:{ MessagingException -> 0x0019 }
            int r1 = r1 + 1
            java.lang.String r0 = r0.substring(r1)     // Catch:{ MessagingException -> 0x0019 }
            r3.name = r0     // Catch:{ MessagingException -> 0x0019 }
        L_0x0019:
            java.lang.String r0 = r3.name     // Catch:{ all -> 0x001d }
            monitor-exit(r3)
            return r0
        L_0x001d:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.getName():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        throw new javax.mail.MessagingException(r0.getMessage(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        throw new javax.mail.StoreClosedException(r5.store, r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r1 = getStoreProtocol();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0 = r1.examine(r5.fullName);
        r1.close();
        r0 = r0.recent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        releaseStoreProtocol(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003c, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0041, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0042, code lost:
        r4 = r1;
        r1 = null;
        r0 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0046, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0047, code lost:
        r4 = r1;
        r1 = null;
        r0 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0053, code lost:
        throw new javax.mail.MessagingException(r0.getMessage(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        releaseStoreProtocol(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0057, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0066, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0070, code lost:
        throw new javax.mail.MessagingException(r1.getMessage(), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0071, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x007b, code lost:
        throw new javax.mail.FolderClosedException(r5, r1.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:5:0x0008, B:41:0x005c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int getNewMessageCount() throws javax.mail.MessagingException {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.opened     // Catch:{ all -> 0x007e }
            if (r0 != 0) goto L_0x0058
            r5.checkExists()     // Catch:{ all -> 0x007e }
            com.sun.mail.imap.protocol.Status r0 = r5.getStatus()     // Catch:{ BadCommandException -> 0x0028, ConnectionException -> 0x001b, ProtocolException -> 0x0010 }
            int r0 = r0.recent     // Catch:{ BadCommandException -> 0x0028, ConnectionException -> 0x001b, ProtocolException -> 0x0010 }
            monitor-exit(r5)
            return r0
        L_0x0010:
            r0 = move-exception
            javax.mail.MessagingException r1 = new javax.mail.MessagingException     // Catch:{ all -> 0x007e }
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x007e }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x007e }
            throw r1     // Catch:{ all -> 0x007e }
        L_0x001b:
            r0 = move-exception
            javax.mail.StoreClosedException r1 = new javax.mail.StoreClosedException     // Catch:{ all -> 0x007e }
            javax.mail.Store r2 = r5.store     // Catch:{ all -> 0x007e }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x007e }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x007e }
            throw r1     // Catch:{ all -> 0x007e }
        L_0x0028:
            r0 = 0
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r5.getStoreProtocol()     // Catch:{ ProtocolException -> 0x0046, all -> 0x0041 }
            java.lang.String r0 = r5.fullName     // Catch:{ ProtocolException -> 0x003f }
            com.sun.mail.imap.protocol.MailboxInfo r0 = r1.examine(r0)     // Catch:{ ProtocolException -> 0x003f }
            r1.close()     // Catch:{ ProtocolException -> 0x003f }
            int r0 = r0.recent     // Catch:{ ProtocolException -> 0x003f }
            r5.releaseStoreProtocol(r1)     // Catch:{ all -> 0x007e }
            monitor-exit(r5)
            return r0
        L_0x003d:
            r0 = move-exception
            goto L_0x0054
        L_0x003f:
            r0 = move-exception
            goto L_0x004a
        L_0x0041:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0054
        L_0x0046:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x004a:
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x003d }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x003d }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x003d }
            throw r2     // Catch:{ all -> 0x003d }
        L_0x0054:
            r5.releaseStoreProtocol(r1)     // Catch:{ all -> 0x007e }
            throw r0     // Catch:{ all -> 0x007e }
        L_0x0058:
            java.lang.Object r0 = r5.messageCacheLock     // Catch:{ all -> 0x007e }
            monitor-enter(r0)     // Catch:{ all -> 0x007e }
            r1 = 1
            r5.keepConnectionAlive(r1)     // Catch:{ ConnectionException -> 0x0071, ProtocolException -> 0x0066 }
            int r1 = r5.recent     // Catch:{ ConnectionException -> 0x0071, ProtocolException -> 0x0066 }
            monitor-exit(r0)     // Catch:{ all -> 0x0064 }
            monitor-exit(r5)
            return r1
        L_0x0064:
            r1 = move-exception
            goto L_0x007c
        L_0x0066:
            r1 = move-exception
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x0064 }
            java.lang.String r3 = r1.getMessage()     // Catch:{ all -> 0x0064 }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x0064 }
            throw r2     // Catch:{ all -> 0x0064 }
        L_0x0071:
            r1 = move-exception
            javax.mail.FolderClosedException r2 = new javax.mail.FolderClosedException     // Catch:{ all -> 0x0064 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0064 }
            r2.<init>(r5, r1)     // Catch:{ all -> 0x0064 }
            throw r2     // Catch:{ all -> 0x0064 }
        L_0x007c:
            monitor-exit(r0)     // Catch:{ all -> 0x0064 }
            throw r1     // Catch:{ all -> 0x007e }
        L_0x007e:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.getNewMessageCount():int");
    }

    public synchronized Folder getParent() throws MessagingException {
        char separator2 = getSeparator();
        int lastIndexOf = this.fullName.lastIndexOf(separator2);
        if (lastIndexOf != -1) {
            return new IMAPFolder(this.fullName.substring(0, lastIndexOf), separator2, (IMAPStore) this.store);
        }
        return new DefaultFolder((IMAPStore) this.store);
    }

    public synchronized Flags getPermanentFlags() {
        return (Flags) this.permanentFlags.clone();
    }

    public Quota[] getQuota() throws MessagingException {
        return (Quota[]) doOptionalCommand("QUOTA not supported", new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                return iMAPProtocol.getQuotaRoot(IMAPFolder.this.fullName);
            }
        });
    }

    public synchronized char getSeparator() throws MessagingException {
        if (this.separator == 65535) {
            ListInfo[] listInfoArr = (ListInfo[]) doCommand(new ProtocolCommand() {
                public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                    String str;
                    String str2;
                    if (iMAPProtocol.isREV1()) {
                        str = IMAPFolder.this.fullName;
                        str2 = "";
                    } else {
                        str = "";
                        str2 = IMAPFolder.this.fullName;
                    }
                    return iMAPProtocol.list(str, str2);
                }
            });
            if (listInfoArr != null) {
                this.separator = listInfoArr[0].separator;
            } else {
                this.separator = IOUtils.DIR_SEPARATOR_UNIX;
            }
        }
        return this.separator;
    }

    /* access modifiers changed from: protected */
    public synchronized IMAPProtocol getStoreProtocol() throws ProtocolException {
        if (this.connectionPoolDebug) {
            this.out.println("DEBUG: getStoreProtocol() - borrowing a connection");
        }
        return ((IMAPStore) this.store).getStoreProtocol();
    }

    public synchronized int getType() throws MessagingException {
        if (!this.opened) {
            checkExists();
        } else if (this.attributes == null) {
            exists();
        }
        return this.type;
    }

    public synchronized long getUID(Message message) throws MessagingException {
        if (message.getFolder() != this) {
            throw new NoSuchElementException("Message does not belong to this folder");
        }
        checkOpened();
        IMAPMessage iMAPMessage = (IMAPMessage) message;
        long uid = iMAPMessage.getUID();
        if (uid != -1) {
            return uid;
        }
        synchronized (this.messageCacheLock) {
            try {
                IMAPProtocol protocol2 = getProtocol();
                iMAPMessage.checkExpunged();
                UID fetchUID = protocol2.fetchUID(iMAPMessage.getSequenceNumber());
                if (fetchUID != null) {
                    uid = fetchUID.uid;
                    iMAPMessage.setUID(uid);
                    if (this.uidTable == null) {
                        this.uidTable = new Hashtable();
                    }
                    this.uidTable.put(new Long(uid), iMAPMessage);
                }
            } catch (ConnectionException e) {
                throw new FolderClosedException(this, e.getMessage());
            } catch (ProtocolException e2) {
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
        return uid;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:36:0x0048=Splitter:B:36:0x0048, B:23:0x002e=Splitter:B:23:0x002e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized long getUIDNext() throws javax.mail.MessagingException {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.opened     // Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x0009
            long r0 = r5.uidnext     // Catch:{ all -> 0x0055 }
            monitor-exit(r5)
            return r0
        L_0x0009:
            r0 = 0
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r5.getStoreProtocol()     // Catch:{ BadCommandException -> 0x0044, ConnectionException -> 0x0038, ProtocolException -> 0x002a, all -> 0x0025 }
            java.lang.String r2 = "UIDNEXT"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch:{ BadCommandException -> 0x0023, ConnectionException -> 0x0021, ProtocolException -> 0x001f }
            java.lang.String r3 = r5.fullName     // Catch:{ BadCommandException -> 0x0023, ConnectionException -> 0x0021, ProtocolException -> 0x001f }
            com.sun.mail.imap.protocol.Status r2 = r1.status(r3, r2)     // Catch:{ BadCommandException -> 0x0023, ConnectionException -> 0x0021, ProtocolException -> 0x001f }
            r5.releaseStoreProtocol(r1)     // Catch:{ all -> 0x0055 }
            r0 = r2
            goto L_0x0040
        L_0x001f:
            r0 = move-exception
            goto L_0x002e
        L_0x0021:
            r2 = move-exception
            goto L_0x003a
        L_0x0023:
            r0 = move-exception
            goto L_0x0048
        L_0x0025:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0051
        L_0x002a:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x002e:
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x0050 }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x0050 }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0050 }
            throw r2     // Catch:{ all -> 0x0050 }
        L_0x0038:
            r2 = move-exception
            r1 = r0
        L_0x003a:
            r5.throwClosedException(r2)     // Catch:{ all -> 0x0050 }
            r5.releaseStoreProtocol(r1)     // Catch:{ all -> 0x0055 }
        L_0x0040:
            long r0 = r0.uidnext     // Catch:{ all -> 0x0055 }
            monitor-exit(r5)
            return r0
        L_0x0044:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0048:
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x0050 }
            java.lang.String r3 = "Cannot obtain UIDNext"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0050 }
            throw r2     // Catch:{ all -> 0x0050 }
        L_0x0050:
            r0 = move-exception
        L_0x0051:
            r5.releaseStoreProtocol(r1)     // Catch:{ all -> 0x0055 }
            throw r0     // Catch:{ all -> 0x0055 }
        L_0x0055:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.getUIDNext():long");
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:36:0x0048=Splitter:B:36:0x0048, B:23:0x002e=Splitter:B:23:0x002e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized long getUIDValidity() throws javax.mail.MessagingException {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.opened     // Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x0009
            long r0 = r5.uidvalidity     // Catch:{ all -> 0x0055 }
            monitor-exit(r5)
            return r0
        L_0x0009:
            r0 = 0
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r5.getStoreProtocol()     // Catch:{ BadCommandException -> 0x0044, ConnectionException -> 0x0038, ProtocolException -> 0x002a, all -> 0x0025 }
            java.lang.String r2 = "UIDVALIDITY"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch:{ BadCommandException -> 0x0023, ConnectionException -> 0x0021, ProtocolException -> 0x001f }
            java.lang.String r3 = r5.fullName     // Catch:{ BadCommandException -> 0x0023, ConnectionException -> 0x0021, ProtocolException -> 0x001f }
            com.sun.mail.imap.protocol.Status r2 = r1.status(r3, r2)     // Catch:{ BadCommandException -> 0x0023, ConnectionException -> 0x0021, ProtocolException -> 0x001f }
            r5.releaseStoreProtocol(r1)     // Catch:{ all -> 0x0055 }
            r0 = r2
            goto L_0x0040
        L_0x001f:
            r0 = move-exception
            goto L_0x002e
        L_0x0021:
            r2 = move-exception
            goto L_0x003a
        L_0x0023:
            r0 = move-exception
            goto L_0x0048
        L_0x0025:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0051
        L_0x002a:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x002e:
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x0050 }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x0050 }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0050 }
            throw r2     // Catch:{ all -> 0x0050 }
        L_0x0038:
            r2 = move-exception
            r1 = r0
        L_0x003a:
            r5.throwClosedException(r2)     // Catch:{ all -> 0x0050 }
            r5.releaseStoreProtocol(r1)     // Catch:{ all -> 0x0055 }
        L_0x0040:
            long r0 = r0.uidvalidity     // Catch:{ all -> 0x0055 }
            monitor-exit(r5)
            return r0
        L_0x0044:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0048:
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x0050 }
            java.lang.String r3 = "Cannot obtain UIDValidity"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0050 }
            throw r2     // Catch:{ all -> 0x0050 }
        L_0x0050:
            r0 = move-exception
        L_0x0051:
            r5.releaseStoreProtocol(r1)     // Catch:{ all -> 0x0055 }
            throw r0     // Catch:{ all -> 0x0055 }
        L_0x0055:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.getUIDValidity():long");
    }

    public synchronized int getUnreadMessageCount() throws MessagingException {
        int length;
        if (!this.opened) {
            checkExists();
            try {
                return getStatus().unseen;
            } catch (BadCommandException unused) {
                return -1;
            } catch (ConnectionException e) {
                throw new StoreClosedException(this.store, e.getMessage());
            } catch (ProtocolException e2) {
                throw new MessagingException(e2.getMessage(), e2);
            }
        } else {
            Flags flags = new Flags();
            flags.add(Flags.Flag.SEEN);
            try {
                synchronized (this.messageCacheLock) {
                    length = getProtocol().search(new FlagTerm(flags, false)).length;
                }
                return length;
            } catch (ConnectionException e3) {
                throw new FolderClosedException(this, e3.getMessage());
            } catch (ProtocolException e4) {
                throw new MessagingException(e4.getMessage(), e4);
            }
        }
    }

    public void handleResponse(Response response) {
        IMAPMessage messageBySeqNumber;
        if (response.isOK() || response.isNO() || response.isBAD() || response.isBYE()) {
            ((IMAPStore) this.store).handleResponseCode(response);
        }
        if (response.isBYE()) {
            if (this.opened) {
                cleanup(false);
            }
        } else if (response.isOK() || !response.isUnTagged()) {
        } else {
            if (!(response instanceof IMAPResponse)) {
                this.out.println("UNEXPECTED RESPONSE : " + response.toString());
                this.out.println("CONTACT javamail@sun.com");
                return;
            }
            IMAPResponse iMAPResponse = (IMAPResponse) response;
            if (iMAPResponse.keyEquals("EXISTS")) {
                int number = iMAPResponse.getNumber();
                if (number > this.realTotal) {
                    int i = number - this.realTotal;
                    Message[] messageArr = new Message[i];
                    for (int i2 = 0; i2 < i; i2++) {
                        int i3 = this.total + 1;
                        this.total = i3;
                        int i4 = this.realTotal + 1;
                        this.realTotal = i4;
                        IMAPMessage iMAPMessage = new IMAPMessage(this, i3, i4);
                        messageArr[i2] = iMAPMessage;
                        this.messageCache.addElement(iMAPMessage);
                    }
                    notifyMessageAddedListeners(messageArr);
                }
            } else if (iMAPResponse.keyEquals("EXPUNGE")) {
                IMAPMessage messageBySeqNumber2 = getMessageBySeqNumber(iMAPResponse.getNumber());
                messageBySeqNumber2.setExpunged(true);
                for (int messageNumber = messageBySeqNumber2.getMessageNumber(); messageNumber < this.total; messageNumber++) {
                    IMAPMessage iMAPMessage2 = (IMAPMessage) this.messageCache.elementAt(messageNumber);
                    if (!iMAPMessage2.isExpunged()) {
                        iMAPMessage2.setSequenceNumber(iMAPMessage2.getSequenceNumber() - 1);
                    }
                }
                this.realTotal--;
                if (this.doExpungeNotification) {
                    notifyMessageRemovedListeners(false, new Message[]{messageBySeqNumber2});
                }
            } else if (iMAPResponse.keyEquals("FETCH")) {
                FetchResponse fetchResponse = (FetchResponse) iMAPResponse;
                Flags flags = (Flags) fetchResponse.getItem(Flags.class);
                if (flags != null && (messageBySeqNumber = getMessageBySeqNumber(fetchResponse.getNumber())) != null) {
                    messageBySeqNumber._setFlags(flags);
                    notifyMessageChangedListeners(1, messageBySeqNumber);
                }
            } else if (iMAPResponse.keyEquals("RECENT")) {
                this.recent = iMAPResponse.getNumber();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void handleResponses(Response[] responseArr) {
        for (int i = 0; i < responseArr.length; i++) {
            if (responseArr[i] != null) {
                handleResponse(responseArr[i]);
            }
        }
    }

    public synchronized boolean hasNewMessages() throws MessagingException {
        boolean z = false;
        if (this.opened) {
            synchronized (this.messageCacheLock) {
                try {
                    keepConnectionAlive(true);
                    if (this.recent > 0) {
                        z = true;
                    }
                } catch (ConnectionException e) {
                    throw new FolderClosedException(this, e.getMessage());
                } catch (ProtocolException e2) {
                    throw new MessagingException(e2.getMessage(), e2);
                }
            }
            return z;
        }
        checkExists();
        Boolean bool = (Boolean) doCommandIgnoreFailure(new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                ListInfo[] list = iMAPProtocol.list("", IMAPFolder.this.fullName);
                if (list != null) {
                    if (list[0].changeState == 1) {
                        return Boolean.TRUE;
                    }
                    if (list[0].changeState == 2) {
                        return Boolean.FALSE;
                    }
                }
                return IMAPFolder.this.getStatus().recent > 0 ? Boolean.TRUE : Boolean.FALSE;
            }
        });
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        if (r0 == null) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        if (r3.protocol == null) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        if (r3.protocol.processIdleResponse(r0) != false) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0032, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0036, code lost:
        r3.idleState = 0;
        r3.messageCacheLock.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003e, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003f, code lost:
        r0 = ((com.sun.mail.imap.IMAPStore) r3.store).getMinIdleTime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
        if (r0 <= 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        java.lang.Thread.sleep((long) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0050, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x005a, code lost:
        throw new javax.mail.MessagingException(r0.getMessage(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x005c, code lost:
        throwClosedException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        r0 = r3.protocol.readIdleResponse();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r1 = r3.messageCacheLock;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void idle() throws javax.mail.MessagingException {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.checkOpened()     // Catch:{ all -> 0x0060 }
            java.lang.String r0 = "IDLE not supported"
            com.sun.mail.imap.IMAPFolder$19 r1 = new com.sun.mail.imap.IMAPFolder$19     // Catch:{ all -> 0x0060 }
            r1.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.Object r0 = r3.doOptionalCommand(r0, r1)     // Catch:{ all -> 0x0060 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0060 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0060 }
            if (r0 != 0) goto L_0x0019
            monitor-exit(r3)     // Catch:{ all -> 0x0060 }
            return
        L_0x0019:
            monitor-exit(r3)     // Catch:{ all -> 0x0060 }
        L_0x001a:
            com.sun.mail.imap.protocol.IMAPProtocol r0 = r3.protocol
            com.sun.mail.iap.Response r0 = r0.readIdleResponse()
            java.lang.Object r1 = r3.messageCacheLock     // Catch:{ ConnectionException -> 0x005b, ProtocolException -> 0x0050 }
            monitor-enter(r1)     // Catch:{ ConnectionException -> 0x005b, ProtocolException -> 0x0050 }
            if (r0 == 0) goto L_0x0036
            com.sun.mail.imap.protocol.IMAPProtocol r2 = r3.protocol     // Catch:{ all -> 0x0034 }
            if (r2 == 0) goto L_0x0036
            com.sun.mail.imap.protocol.IMAPProtocol r2 = r3.protocol     // Catch:{ all -> 0x0034 }
            boolean r0 = r2.processIdleResponse(r0)     // Catch:{ all -> 0x0034 }
            if (r0 != 0) goto L_0x0032
            goto L_0x0036
        L_0x0032:
            monitor-exit(r1)     // Catch:{ all -> 0x0034 }
            goto L_0x001a
        L_0x0034:
            r0 = move-exception
            goto L_0x004e
        L_0x0036:
            r0 = 0
            r3.idleState = r0     // Catch:{ all -> 0x0034 }
            java.lang.Object r0 = r3.messageCacheLock     // Catch:{ all -> 0x0034 }
            r0.notifyAll()     // Catch:{ all -> 0x0034 }
            monitor-exit(r1)     // Catch:{ all -> 0x0034 }
            javax.mail.Store r0 = r3.store
            com.sun.mail.imap.IMAPStore r0 = (com.sun.mail.imap.IMAPStore) r0
            int r0 = r0.getMinIdleTime()
            if (r0 <= 0) goto L_0x004d
            long r0 = (long) r0
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x004d }
        L_0x004d:
            return
        L_0x004e:
            monitor-exit(r1)     // Catch:{ all -> 0x0034 }
            throw r0     // Catch:{ ConnectionException -> 0x005b, ProtocolException -> 0x0050 }
        L_0x0050:
            r0 = move-exception
            javax.mail.MessagingException r1 = new javax.mail.MessagingException
            java.lang.String r2 = r0.getMessage()
            r1.<init>(r2, r0)
            throw r1
        L_0x005b:
            r0 = move-exception
            r3.throwClosedException(r0)
            goto L_0x001a
        L_0x0060:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0060 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.idle():void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:4|5|(3:7|8|9)|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x000c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean isOpen() {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.Object r0 = r2.messageCacheLock     // Catch:{ all -> 0x0014 }
            monitor-enter(r0)     // Catch:{ all -> 0x0014 }
            boolean r1 = r2.opened     // Catch:{ all -> 0x0011 }
            if (r1 == 0) goto L_0x000c
            r1 = 0
            r2.keepConnectionAlive(r1)     // Catch:{ ProtocolException -> 0x000c }
        L_0x000c:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            boolean r0 = r2.opened     // Catch:{ all -> 0x0014 }
            monitor-exit(r2)
            return r0
        L_0x0011:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r1     // Catch:{ all -> 0x0014 }
        L_0x0014:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.isOpen():boolean");
    }

    public synchronized boolean isSubscribed() {
        final String str;
        ListInfo[] listInfoArr = null;
        if (!this.isNamespace || this.separator == 0) {
            str = this.fullName;
        } else {
            str = String.valueOf(this.fullName) + this.separator;
        }
        try {
            listInfoArr = (ListInfo[]) doProtocolCommand(new ProtocolCommand() {
                public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                    return iMAPProtocol.lsub("", str);
                }
            });
        } catch (ProtocolException unused) {
        }
        if (listInfoArr == null) {
            return false;
        }
        return listInfoArr[findName(listInfoArr, str)].canOpen;
    }

    public Folder[] list(String str) throws MessagingException {
        return doList(str, false);
    }

    public Rights[] listRights(final String str) throws MessagingException {
        return (Rights[]) doOptionalCommand("ACL not supported", new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                return iMAPProtocol.listRights(IMAPFolder.this.fullName, str);
            }
        });
    }

    public Folder[] listSubscribed(String str) throws MessagingException {
        return doList(str, true);
    }

    public Rights myRights() throws MessagingException {
        return (Rights) doOptionalCommand("ACL not supported", new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                return iMAPProtocol.myRights(IMAPFolder.this.fullName);
            }
        });
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized void open(int r8) throws javax.mail.MessagingException {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.checkClosed()     // Catch:{ all -> 0x00eb }
            javax.mail.Store r0 = r7.store     // Catch:{ all -> 0x00eb }
            com.sun.mail.imap.IMAPStore r0 = (com.sun.mail.imap.IMAPStore) r0     // Catch:{ all -> 0x00eb }
            com.sun.mail.imap.protocol.IMAPProtocol r0 = r0.getProtocol(r7)     // Catch:{ all -> 0x00eb }
            r7.protocol = r0     // Catch:{ all -> 0x00eb }
            java.lang.Object r0 = r7.messageCacheLock     // Catch:{ all -> 0x00eb }
            monitor-enter(r0)     // Catch:{ all -> 0x00eb }
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r7.protocol     // Catch:{ all -> 0x00e8 }
            r1.addResponseHandler(r7)     // Catch:{ all -> 0x00e8 }
            r1 = 0
            r2 = 0
            r3 = 1
            if (r8 != r3) goto L_0x002a
            com.sun.mail.imap.protocol.IMAPProtocol r4 = r7.protocol     // Catch:{ CommandFailedException -> 0x0027, ProtocolException -> 0x0024 }
            java.lang.String r5 = r7.fullName     // Catch:{ CommandFailedException -> 0x0027, ProtocolException -> 0x0024 }
            com.sun.mail.imap.protocol.MailboxInfo r4 = r4.examine(r5)     // Catch:{ CommandFailedException -> 0x0027, ProtocolException -> 0x0024 }
            goto L_0x0032
        L_0x0024:
            r8 = move-exception
            goto L_0x00a7
        L_0x0027:
            r8 = move-exception
            goto L_0x00bb
        L_0x002a:
            com.sun.mail.imap.protocol.IMAPProtocol r4 = r7.protocol     // Catch:{ CommandFailedException -> 0x0027, ProtocolException -> 0x0024 }
            java.lang.String r5 = r7.fullName     // Catch:{ CommandFailedException -> 0x0027, ProtocolException -> 0x0024 }
            com.sun.mail.imap.protocol.MailboxInfo r4 = r4.select(r5)     // Catch:{ CommandFailedException -> 0x0027, ProtocolException -> 0x0024 }
        L_0x0032:
            int r5 = r4.mode     // Catch:{ all -> 0x00e8 }
            if (r5 == r8) goto L_0x0068
            r5 = 2
            if (r8 != r5) goto L_0x0047
            int r8 = r4.mode     // Catch:{ all -> 0x00e8 }
            if (r8 != r3) goto L_0x0047
            javax.mail.Store r8 = r7.store     // Catch:{ all -> 0x00e8 }
            com.sun.mail.imap.IMAPStore r8 = (com.sun.mail.imap.IMAPStore) r8     // Catch:{ all -> 0x00e8 }
            boolean r8 = r8.allowReadOnlySelect()     // Catch:{ all -> 0x00e8 }
            if (r8 != 0) goto L_0x0068
        L_0x0047:
            com.sun.mail.imap.protocol.IMAPProtocol r8 = r7.protocol     // Catch:{ ProtocolException -> 0x0050 }
            r8.close()     // Catch:{ ProtocolException -> 0x0050 }
            r7.releaseProtocol(r3)     // Catch:{ ProtocolException -> 0x0050 }
            goto L_0x005e
        L_0x0050:
            com.sun.mail.imap.protocol.IMAPProtocol r8 = r7.protocol     // Catch:{ ProtocolException -> 0x0055, all -> 0x0059 }
            r8.logout()     // Catch:{ ProtocolException -> 0x0055, all -> 0x0059 }
        L_0x0055:
            r7.releaseProtocol(r2)     // Catch:{ all -> 0x005e }
            goto L_0x005e
        L_0x0059:
            r8 = move-exception
            r7.releaseProtocol(r2)     // Catch:{ all -> 0x005e }
            throw r8     // Catch:{ all -> 0x005e }
        L_0x005e:
            r7.protocol = r1     // Catch:{ all -> 0x00e8 }
            javax.mail.ReadOnlyFolderException r8 = new javax.mail.ReadOnlyFolderException     // Catch:{ all -> 0x00e8 }
            java.lang.String r1 = "Cannot open in desired mode"
            r8.<init>(r7, r1)     // Catch:{ all -> 0x00e8 }
            throw r8     // Catch:{ all -> 0x00e8 }
        L_0x0068:
            r7.opened = r3     // Catch:{ all -> 0x00e8 }
            r7.reallyClosed = r2     // Catch:{ all -> 0x00e8 }
            int r8 = r4.mode     // Catch:{ all -> 0x00e8 }
            r7.mode = r8     // Catch:{ all -> 0x00e8 }
            javax.mail.Flags r8 = r4.availableFlags     // Catch:{ all -> 0x00e8 }
            r7.availableFlags = r8     // Catch:{ all -> 0x00e8 }
            javax.mail.Flags r8 = r4.permanentFlags     // Catch:{ all -> 0x00e8 }
            r7.permanentFlags = r8     // Catch:{ all -> 0x00e8 }
            int r8 = r4.total     // Catch:{ all -> 0x00e8 }
            r7.realTotal = r8     // Catch:{ all -> 0x00e8 }
            r7.total = r8     // Catch:{ all -> 0x00e8 }
            int r8 = r4.recent     // Catch:{ all -> 0x00e8 }
            r7.recent = r8     // Catch:{ all -> 0x00e8 }
            long r5 = r4.uidvalidity     // Catch:{ all -> 0x00e8 }
            r7.uidvalidity = r5     // Catch:{ all -> 0x00e8 }
            long r4 = r4.uidnext     // Catch:{ all -> 0x00e8 }
            r7.uidnext = r4     // Catch:{ all -> 0x00e8 }
            java.util.Vector r8 = new java.util.Vector     // Catch:{ all -> 0x00e8 }
            int r4 = r7.total     // Catch:{ all -> 0x00e8 }
            r8.<init>(r4)     // Catch:{ all -> 0x00e8 }
            r7.messageCache = r8     // Catch:{ all -> 0x00e8 }
        L_0x0093:
            int r8 = r7.total     // Catch:{ all -> 0x00e8 }
            if (r2 < r8) goto L_0x009a
            monitor-exit(r0)     // Catch:{ all -> 0x00e8 }
            r8 = r1
            goto L_0x00c1
        L_0x009a:
            java.util.Vector r8 = r7.messageCache     // Catch:{ all -> 0x00e8 }
            com.sun.mail.imap.IMAPMessage r4 = new com.sun.mail.imap.IMAPMessage     // Catch:{ all -> 0x00e8 }
            int r2 = r2 + 1
            r4.<init>(r7, r2, r2)     // Catch:{ all -> 0x00e8 }
            r8.addElement(r4)     // Catch:{ all -> 0x00e8 }
            goto L_0x0093
        L_0x00a7:
            com.sun.mail.imap.protocol.IMAPProtocol r3 = r7.protocol     // Catch:{ ProtocolException -> 0x00ac }
            r3.logout()     // Catch:{ ProtocolException -> 0x00ac }
        L_0x00ac:
            r7.releaseProtocol(r2)     // Catch:{ all -> 0x00e8 }
            r7.protocol = r1     // Catch:{ all -> 0x00e8 }
            javax.mail.MessagingException r1 = new javax.mail.MessagingException     // Catch:{ all -> 0x00e8 }
            java.lang.String r2 = r8.getMessage()     // Catch:{ all -> 0x00e8 }
            r1.<init>(r2, r8)     // Catch:{ all -> 0x00e8 }
            throw r1     // Catch:{ all -> 0x00e8 }
        L_0x00bb:
            r7.releaseProtocol(r3)     // Catch:{ all -> 0x00e8 }
            r7.protocol = r1     // Catch:{ all -> 0x00e8 }
            monitor-exit(r0)     // Catch:{ all -> 0x00e8 }
        L_0x00c1:
            if (r8 == 0) goto L_0x00dd
            r7.checkExists()     // Catch:{ all -> 0x00eb }
            int r0 = r7.type     // Catch:{ all -> 0x00eb }
            r0 = r0 & r3
            if (r0 != 0) goto L_0x00d3
            javax.mail.MessagingException r8 = new javax.mail.MessagingException     // Catch:{ all -> 0x00eb }
            java.lang.String r0 = "folder cannot contain messages"
            r8.<init>(r0)     // Catch:{ all -> 0x00eb }
            throw r8     // Catch:{ all -> 0x00eb }
        L_0x00d3:
            javax.mail.MessagingException r0 = new javax.mail.MessagingException     // Catch:{ all -> 0x00eb }
            java.lang.String r1 = r8.getMessage()     // Catch:{ all -> 0x00eb }
            r0.<init>(r1, r8)     // Catch:{ all -> 0x00eb }
            throw r0     // Catch:{ all -> 0x00eb }
        L_0x00dd:
            r7.exists = r3     // Catch:{ all -> 0x00eb }
            r7.attributes = r1     // Catch:{ all -> 0x00eb }
            r7.type = r3     // Catch:{ all -> 0x00eb }
            r7.notifyConnectionListeners(r3)     // Catch:{ all -> 0x00eb }
            monitor-exit(r7)
            return
        L_0x00e8:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00e8 }
            throw r8     // Catch:{ all -> 0x00eb }
        L_0x00eb:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.open(int):void");
    }

    /* access modifiers changed from: protected */
    public synchronized void releaseStoreProtocol(IMAPProtocol iMAPProtocol) {
        if (iMAPProtocol != this.protocol) {
            ((IMAPStore) this.store).releaseStoreProtocol(iMAPProtocol);
        }
    }

    public void removeACL(final String str) throws MessagingException {
        doOptionalCommand("ACL not supported", new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                iMAPProtocol.deleteACL(IMAPFolder.this.fullName, str);
                return null;
            }
        });
    }

    public void removeRights(ACL acl) throws MessagingException {
        setACL(acl, '-');
    }

    public synchronized boolean renameTo(final Folder folder) throws MessagingException {
        checkClosed();
        checkExists();
        if (folder.getStore() != this.store) {
            throw new MessagingException("Can't rename across Stores");
        } else if (doCommandIgnoreFailure(new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                iMAPProtocol.rename(IMAPFolder.this.fullName, folder.getFullName());
                return Boolean.TRUE;
            }
        }) == null) {
            return false;
        } else {
            this.exists = false;
            this.attributes = null;
            notifyFolderRenamedListeners(folder);
            return true;
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized javax.mail.Message[] search(javax.mail.search.SearchTerm r6) throws javax.mail.MessagingException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.checkOpened()     // Catch:{ all -> 0x004d }
            r0 = 0
            java.lang.Object r1 = r5.messageCacheLock     // Catch:{ CommandFailedException -> 0x0047, SearchException -> 0x0041, ConnectionException -> 0x0036, ProtocolException -> 0x002b }
            monitor-enter(r1)     // Catch:{ CommandFailedException -> 0x0047, SearchException -> 0x0041, ConnectionException -> 0x0036, ProtocolException -> 0x002b }
            com.sun.mail.imap.protocol.IMAPProtocol r2 = r5.getProtocol()     // Catch:{ all -> 0x0028 }
            int[] r2 = r2.search(r6)     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x0025
            int r0 = r2.length     // Catch:{ all -> 0x0028 }
            com.sun.mail.imap.IMAPMessage[] r0 = new com.sun.mail.imap.IMAPMessage[r0]     // Catch:{ all -> 0x0028 }
            r3 = 0
        L_0x0016:
            int r4 = r2.length     // Catch:{ all -> 0x0028 }
            if (r3 < r4) goto L_0x001a
            goto L_0x0025
        L_0x001a:
            r4 = r2[r3]     // Catch:{ all -> 0x0028 }
            com.sun.mail.imap.IMAPMessage r4 = r5.getMessageBySeqNumber(r4)     // Catch:{ all -> 0x0028 }
            r0[r3] = r4     // Catch:{ all -> 0x0028 }
            int r3 = r3 + 1
            goto L_0x0016
        L_0x0025:
            monitor-exit(r1)     // Catch:{ all -> 0x0028 }
            monitor-exit(r5)
            return r0
        L_0x0028:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0028 }
            throw r0     // Catch:{ CommandFailedException -> 0x0047, SearchException -> 0x0041, ConnectionException -> 0x0036, ProtocolException -> 0x002b }
        L_0x002b:
            r6 = move-exception
            javax.mail.MessagingException r0 = new javax.mail.MessagingException     // Catch:{ all -> 0x004d }
            java.lang.String r1 = r6.getMessage()     // Catch:{ all -> 0x004d }
            r0.<init>(r1, r6)     // Catch:{ all -> 0x004d }
            throw r0     // Catch:{ all -> 0x004d }
        L_0x0036:
            r6 = move-exception
            javax.mail.FolderClosedException r0 = new javax.mail.FolderClosedException     // Catch:{ all -> 0x004d }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x004d }
            r0.<init>(r5, r6)     // Catch:{ all -> 0x004d }
            throw r0     // Catch:{ all -> 0x004d }
        L_0x0041:
            javax.mail.Message[] r6 = super.search(r6)     // Catch:{ all -> 0x004d }
            monitor-exit(r5)
            return r6
        L_0x0047:
            javax.mail.Message[] r6 = super.search(r6)     // Catch:{ all -> 0x004d }
            monitor-exit(r5)
            return r6
        L_0x004d:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.search(javax.mail.search.SearchTerm):javax.mail.Message[]");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized javax.mail.Message[] search(javax.mail.search.SearchTerm r6, javax.mail.Message[] r7) throws javax.mail.MessagingException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.checkOpened()     // Catch:{ all -> 0x0060 }
            int r0 = r7.length     // Catch:{ all -> 0x0060 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r5)
            return r7
        L_0x0009:
            java.lang.Object r0 = r5.messageCacheLock     // Catch:{ CommandFailedException -> 0x005a, SearchException -> 0x0054, ConnectionException -> 0x0049, ProtocolException -> 0x003e }
            monitor-enter(r0)     // Catch:{ CommandFailedException -> 0x005a, SearchException -> 0x0054, ConnectionException -> 0x0049, ProtocolException -> 0x003e }
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r5.getProtocol()     // Catch:{ all -> 0x003b }
            r2 = 0
            com.sun.mail.imap.protocol.MessageSet[] r3 = com.sun.mail.imap.Utility.toMessageSet(r7, r2)     // Catch:{ all -> 0x003b }
            if (r3 != 0) goto L_0x001f
            javax.mail.MessageRemovedException r1 = new javax.mail.MessageRemovedException     // Catch:{ all -> 0x003b }
            java.lang.String r2 = "Messages have been removed"
            r1.<init>(r2)     // Catch:{ all -> 0x003b }
            throw r1     // Catch:{ all -> 0x003b }
        L_0x001f:
            int[] r1 = r1.search((com.sun.mail.imap.protocol.MessageSet[]) r3, (javax.mail.search.SearchTerm) r6)     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x0038
            int r2 = r1.length     // Catch:{ all -> 0x003b }
            com.sun.mail.imap.IMAPMessage[] r2 = new com.sun.mail.imap.IMAPMessage[r2]     // Catch:{ all -> 0x003b }
            r3 = 0
        L_0x0029:
            int r4 = r1.length     // Catch:{ all -> 0x003b }
            if (r3 < r4) goto L_0x002d
            goto L_0x0038
        L_0x002d:
            r4 = r1[r3]     // Catch:{ all -> 0x003b }
            com.sun.mail.imap.IMAPMessage r4 = r5.getMessageBySeqNumber(r4)     // Catch:{ all -> 0x003b }
            r2[r3] = r4     // Catch:{ all -> 0x003b }
            int r3 = r3 + 1
            goto L_0x0029
        L_0x0038:
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            monitor-exit(r5)
            return r2
        L_0x003b:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            throw r1     // Catch:{ CommandFailedException -> 0x005a, SearchException -> 0x0054, ConnectionException -> 0x0049, ProtocolException -> 0x003e }
        L_0x003e:
            r6 = move-exception
            javax.mail.MessagingException r7 = new javax.mail.MessagingException     // Catch:{ all -> 0x0060 }
            java.lang.String r0 = r6.getMessage()     // Catch:{ all -> 0x0060 }
            r7.<init>(r0, r6)     // Catch:{ all -> 0x0060 }
            throw r7     // Catch:{ all -> 0x0060 }
        L_0x0049:
            r6 = move-exception
            javax.mail.FolderClosedException r7 = new javax.mail.FolderClosedException     // Catch:{ all -> 0x0060 }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0060 }
            r7.<init>(r5, r6)     // Catch:{ all -> 0x0060 }
            throw r7     // Catch:{ all -> 0x0060 }
        L_0x0054:
            javax.mail.Message[] r6 = super.search(r6, r7)     // Catch:{ all -> 0x0060 }
            monitor-exit(r5)
            return r6
        L_0x005a:
            javax.mail.Message[] r6 = super.search(r6, r7)     // Catch:{ all -> 0x0060 }
            monitor-exit(r5)
            return r6
        L_0x0060:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.search(javax.mail.search.SearchTerm, javax.mail.Message[]):javax.mail.Message[]");
    }

    public synchronized void setFlags(Message[] messageArr, Flags flags, boolean z) throws MessagingException {
        checkOpened();
        checkFlags(flags);
        if (messageArr.length != 0) {
            synchronized (this.messageCacheLock) {
                try {
                    IMAPProtocol protocol2 = getProtocol();
                    MessageSet[] messageSet = Utility.toMessageSet(messageArr, (Utility.Condition) null);
                    if (messageSet == null) {
                        throw new MessageRemovedException("Messages have been removed");
                    }
                    protocol2.storeFlags(messageSet, flags, z);
                } catch (ConnectionException e) {
                    throw new FolderClosedException(this, e.getMessage());
                } catch (ProtocolException e2) {
                    throw new MessagingException(e2.getMessage(), e2);
                }
            }
        }
    }

    public void setQuota(final Quota quota) throws MessagingException {
        doOptionalCommand("QUOTA not supported", new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                iMAPProtocol.setQuota(quota);
                return null;
            }
        });
    }

    public synchronized void setSubscribed(final boolean z) throws MessagingException {
        doCommandIgnoreFailure(new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                if (z) {
                    iMAPProtocol.subscribe(IMAPFolder.this.fullName);
                    return null;
                }
                iMAPProtocol.unsubscribe(IMAPFolder.this.fullName);
                return null;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void waitIfIdle() throws ProtocolException {
        while (this.idleState != 0) {
            if (this.idleState == 1) {
                this.protocol.idleAbort();
                this.idleState = 2;
            }
            try {
                this.messageCacheLock.wait();
            } catch (InterruptedException unused) {
            }
        }
    }
}
