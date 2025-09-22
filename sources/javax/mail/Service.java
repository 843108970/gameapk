package javax.mail;

import java.util.Vector;
import javax.mail.event.ConnectionEvent;
import javax.mail.event.ConnectionListener;
import javax.mail.event.MailEvent;

public abstract class Service {
    private boolean connected = false;
    private Vector connectionListeners = null;
    protected boolean debug = false;
    private EventQueue q;
    private Object qLock = new Object();
    protected Session session;
    protected URLName url = null;

    static class TerminatorEvent extends MailEvent {
        private static final long serialVersionUID = 5542172141759168416L;

        TerminatorEvent() {
            super(new Object());
        }

        public void dispatch(Object obj) {
            Thread.currentThread().interrupt();
        }
    }

    protected Service(Session session2, URLName uRLName) {
        this.session = session2;
        this.url = uRLName;
        this.debug = session2.getDebug();
    }

    private void terminateQueue() {
        synchronized (this.qLock) {
            if (this.q != null) {
                Vector vector = new Vector();
                vector.setSize(1);
                this.q.enqueue(new TerminatorEvent(), vector);
                this.q = null;
            }
        }
    }

    public synchronized void addConnectionListener(ConnectionListener connectionListener) {
        if (this.connectionListeners == null) {
            this.connectionListeners = new Vector();
        }
        this.connectionListeners.addElement(connectionListener);
    }

    public synchronized void close() throws MessagingException {
        setConnected(false);
        notifyConnectionListeners(3);
    }

    public void connect() throws MessagingException {
        connect((String) null, (String) null, (String) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x010c, code lost:
        if (r2.equals(r5.getUserName()) != false) goto L_0x00ff;
     */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0127 A[SYNTHETIC, Splitter:B:70:0x0127] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0148 A[Catch:{ SecurityException -> 0x00bf, all -> 0x0179 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0151 A[Catch:{ SecurityException -> 0x00bf, all -> 0x0179 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void connect(java.lang.String r20, int r21, java.lang.String r22, java.lang.String r23) throws javax.mail.MessagingException {
        /*
            r19 = this;
            r1 = r19
            r2 = r22
            monitor-enter(r19)
            boolean r4 = r19.isConnected()     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x0013
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0179 }
            java.lang.String r3 = "already connected"
            r2.<init>(r3)     // Catch:{ all -> 0x0179 }
            throw r2     // Catch:{ all -> 0x0179 }
        L_0x0013:
            javax.mail.URLName r4 = r1.url     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x0060
            javax.mail.URLName r4 = r1.url     // Catch:{ all -> 0x0179 }
            java.lang.String r4 = r4.getProtocol()     // Catch:{ all -> 0x0179 }
            if (r20 != 0) goto L_0x0026
            javax.mail.URLName r6 = r1.url     // Catch:{ all -> 0x0179 }
            java.lang.String r6 = r6.getHost()     // Catch:{ all -> 0x0179 }
            goto L_0x0028
        L_0x0026:
            r6 = r20
        L_0x0028:
            r7 = -1
            r8 = r21
            if (r8 != r7) goto L_0x0034
            javax.mail.URLName r7 = r1.url     // Catch:{ all -> 0x0179 }
            int r7 = r7.getPort()     // Catch:{ all -> 0x0179 }
            goto L_0x0035
        L_0x0034:
            r7 = r8
        L_0x0035:
            if (r2 != 0) goto L_0x0046
            javax.mail.URLName r2 = r1.url     // Catch:{ all -> 0x0179 }
            java.lang.String r2 = r2.getUsername()     // Catch:{ all -> 0x0179 }
            if (r23 != 0) goto L_0x0057
            javax.mail.URLName r3 = r1.url     // Catch:{ all -> 0x0179 }
        L_0x0041:
            java.lang.String r3 = r3.getPassword()     // Catch:{ all -> 0x0179 }
            goto L_0x0059
        L_0x0046:
            if (r23 != 0) goto L_0x0057
            javax.mail.URLName r8 = r1.url     // Catch:{ all -> 0x0179 }
            java.lang.String r8 = r8.getUsername()     // Catch:{ all -> 0x0179 }
            boolean r8 = r2.equals(r8)     // Catch:{ all -> 0x0179 }
            if (r8 == 0) goto L_0x0057
            javax.mail.URLName r3 = r1.url     // Catch:{ all -> 0x0179 }
            goto L_0x0041
        L_0x0057:
            r3 = r23
        L_0x0059:
            javax.mail.URLName r8 = r1.url     // Catch:{ all -> 0x0179 }
            java.lang.String r8 = r8.getFile()     // Catch:{ all -> 0x0179 }
            goto L_0x0069
        L_0x0060:
            r8 = r21
            r6 = r20
            r3 = r23
            r7 = r8
            r4 = 0
            r8 = 0
        L_0x0069:
            if (r4 == 0) goto L_0x00a1
            if (r6 != 0) goto L_0x0086
            javax.mail.Session r6 = r1.session     // Catch:{ all -> 0x0179 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0179 }
            java.lang.String r10 = "mail."
            r9.<init>(r10)     // Catch:{ all -> 0x0179 }
            r9.append(r4)     // Catch:{ all -> 0x0179 }
            java.lang.String r10 = ".host"
            r9.append(r10)     // Catch:{ all -> 0x0179 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0179 }
            java.lang.String r6 = r6.getProperty(r9)     // Catch:{ all -> 0x0179 }
        L_0x0086:
            if (r2 != 0) goto L_0x00a1
            javax.mail.Session r2 = r1.session     // Catch:{ all -> 0x0179 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0179 }
            java.lang.String r10 = "mail."
            r9.<init>(r10)     // Catch:{ all -> 0x0179 }
            r9.append(r4)     // Catch:{ all -> 0x0179 }
            java.lang.String r10 = ".user"
            r9.append(r10)     // Catch:{ all -> 0x0179 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0179 }
            java.lang.String r2 = r2.getProperty(r9)     // Catch:{ all -> 0x0179 }
        L_0x00a1:
            if (r6 != 0) goto L_0x00ab
            javax.mail.Session r6 = r1.session     // Catch:{ all -> 0x0179 }
            java.lang.String r9 = "mail.host"
            java.lang.String r6 = r6.getProperty(r9)     // Catch:{ all -> 0x0179 }
        L_0x00ab:
            if (r2 != 0) goto L_0x00b5
            javax.mail.Session r2 = r1.session     // Catch:{ all -> 0x0179 }
            java.lang.String r9 = "mail.user"
            java.lang.String r2 = r2.getProperty(r9)     // Catch:{ all -> 0x0179 }
        L_0x00b5:
            if (r2 != 0) goto L_0x00ce
            java.lang.String r9 = "user.name"
            java.lang.String r9 = java.lang.System.getProperty(r9)     // Catch:{ SecurityException -> 0x00bf }
            r2 = r9
            goto L_0x00ce
        L_0x00bf:
            r0 = move-exception
            r9 = r0
            boolean r10 = r1.debug     // Catch:{ all -> 0x0179 }
            if (r10 == 0) goto L_0x00ce
            javax.mail.Session r10 = r1.session     // Catch:{ all -> 0x0179 }
            java.io.PrintStream r10 = r10.getDebugOut()     // Catch:{ all -> 0x0179 }
            r9.printStackTrace(r10)     // Catch:{ all -> 0x0179 }
        L_0x00ce:
            r16 = 0
            r15 = 1
            if (r3 != 0) goto L_0x0114
            javax.mail.URLName r9 = r1.url     // Catch:{ all -> 0x0179 }
            if (r9 == 0) goto L_0x0114
            javax.mail.URLName r14 = new javax.mail.URLName     // Catch:{ all -> 0x0179 }
            r17 = 0
            r9 = r14
            r10 = r4
            r11 = r6
            r12 = r7
            r13 = r8
            r5 = r14
            r14 = r2
            r18 = r3
            r3 = 1
            r15 = r17
            r9.<init>(r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x0179 }
            r1.setURLName(r5)     // Catch:{ all -> 0x0179 }
            javax.mail.Session r5 = r1.session     // Catch:{ all -> 0x0179 }
            javax.mail.URLName r9 = r19.getURLName()     // Catch:{ all -> 0x0179 }
            javax.mail.PasswordAuthentication r5 = r5.getPasswordAuthentication(r9)     // Catch:{ all -> 0x0179 }
            if (r5 == 0) goto L_0x010f
            if (r2 != 0) goto L_0x0104
            java.lang.String r2 = r5.getUserName()     // Catch:{ all -> 0x0179 }
        L_0x00ff:
            java.lang.String r5 = r5.getPassword()     // Catch:{ all -> 0x0179 }
            goto L_0x0119
        L_0x0104:
            java.lang.String r9 = r5.getUserName()     // Catch:{ all -> 0x0179 }
            boolean r9 = r2.equals(r9)     // Catch:{ all -> 0x0179 }
            if (r9 == 0) goto L_0x0117
            goto L_0x00ff
        L_0x010f:
            r5 = r18
            r17 = 1
            goto L_0x011b
        L_0x0114:
            r18 = r3
            r3 = 1
        L_0x0117:
            r5 = r18
        L_0x0119:
            r17 = 0
        L_0x011b:
            boolean r9 = r1.protocolConnect(r6, r7, r2, r5)     // Catch:{ AuthenticationFailedException -> 0x0123 }
            r16 = r9
            r15 = 0
            goto L_0x0125
        L_0x0123:
            r0 = move-exception
            r15 = r0
        L_0x0125:
            if (r16 != 0) goto L_0x0146
            java.net.InetAddress r9 = java.net.InetAddress.getByName(r6)     // Catch:{ UnknownHostException -> 0x012d }
            r10 = r9
            goto L_0x012e
        L_0x012d:
            r10 = 0
        L_0x012e:
            javax.mail.Session r9 = r1.session     // Catch:{ all -> 0x0179 }
            r13 = 0
            r11 = r7
            r12 = r4
            r14 = r2
            javax.mail.PasswordAuthentication r9 = r9.requestPasswordAuthentication(r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0179 }
            if (r9 == 0) goto L_0x0146
            java.lang.String r2 = r9.getUserName()     // Catch:{ all -> 0x0179 }
            java.lang.String r5 = r9.getPassword()     // Catch:{ all -> 0x0179 }
            boolean r16 = r1.protocolConnect(r6, r7, r2, r5)     // Catch:{ all -> 0x0179 }
        L_0x0146:
            if (r16 != 0) goto L_0x0151
            if (r15 == 0) goto L_0x014b
            throw r15     // Catch:{ all -> 0x0179 }
        L_0x014b:
            javax.mail.AuthenticationFailedException r2 = new javax.mail.AuthenticationFailedException     // Catch:{ all -> 0x0179 }
            r2.<init>()     // Catch:{ all -> 0x0179 }
            throw r2     // Catch:{ all -> 0x0179 }
        L_0x0151:
            javax.mail.URLName r15 = new javax.mail.URLName     // Catch:{ all -> 0x0179 }
            r9 = r15
            r10 = r4
            r11 = r6
            r12 = r7
            r13 = r8
            r14 = r2
            r4 = r15
            r15 = r5
            r9.<init>(r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x0179 }
            r1.setURLName(r4)     // Catch:{ all -> 0x0179 }
            if (r17 == 0) goto L_0x0171
            javax.mail.Session r4 = r1.session     // Catch:{ all -> 0x0179 }
            javax.mail.URLName r6 = r19.getURLName()     // Catch:{ all -> 0x0179 }
            javax.mail.PasswordAuthentication r7 = new javax.mail.PasswordAuthentication     // Catch:{ all -> 0x0179 }
            r7.<init>(r2, r5)     // Catch:{ all -> 0x0179 }
            r4.setPasswordAuthentication(r6, r7)     // Catch:{ all -> 0x0179 }
        L_0x0171:
            r1.setConnected(r3)     // Catch:{ all -> 0x0179 }
            r1.notifyConnectionListeners(r3)     // Catch:{ all -> 0x0179 }
            monitor-exit(r19)
            return
        L_0x0179:
            r0 = move-exception
            r2 = r0
            monitor-exit(r19)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.Service.connect(java.lang.String, int, java.lang.String, java.lang.String):void");
    }

    public void connect(String str, String str2) throws MessagingException {
        connect((String) null, str, str2);
    }

    public void connect(String str, String str2, String str3) throws MessagingException {
        connect(str, -1, str2, str3);
    }

    public void finalize() throws Throwable {
        super.finalize();
        terminateQueue();
    }

    public synchronized URLName getURLName() {
        if (this.url == null || (this.url.getPassword() == null && this.url.getFile() == null)) {
            return this.url;
        }
        return new URLName(this.url.getProtocol(), this.url.getHost(), this.url.getPort(), (String) null, this.url.getUsername(), (String) null);
    }

    public synchronized boolean isConnected() {
        return this.connected;
    }

    /* access modifiers changed from: protected */
    public synchronized void notifyConnectionListeners(int i) {
        if (this.connectionListeners != null) {
            queueEvent(new ConnectionEvent(this, i), this.connectionListeners);
        }
        if (i == 3) {
            terminateQueue();
        }
    }

    public boolean protocolConnect(String str, int i, String str2, String str3) throws MessagingException {
        return false;
    }

    /* access modifiers changed from: protected */
    public void queueEvent(MailEvent mailEvent, Vector vector) {
        synchronized (this.qLock) {
            if (this.q == null) {
                this.q = new EventQueue();
            }
        }
        this.q.enqueue(mailEvent, (Vector) vector.clone());
    }

    public synchronized void removeConnectionListener(ConnectionListener connectionListener) {
        if (this.connectionListeners != null) {
            this.connectionListeners.removeElement(connectionListener);
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void setConnected(boolean z) {
        this.connected = z;
    }

    /* access modifiers changed from: protected */
    public synchronized void setURLName(URLName uRLName) {
        this.url = uRLName;
    }

    public String toString() {
        URLName uRLName = getURLName();
        return uRLName != null ? uRLName.toString() : super.toString();
    }
}
