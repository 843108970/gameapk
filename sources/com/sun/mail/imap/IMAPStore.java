package com.sun.mail.imap;

import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.iap.ResponseHandler;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.imap.protocol.Namespaces;
import java.io.PrintStream;
import java.util.Vector;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.QuotaAwareStore;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;

public class IMAPStore extends Store implements ResponseHandler, QuotaAwareStore {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int RESPONSE = 1000;
    private int appendBufferSize;
    private String authorizationID;
    private int blksize;
    private volatile boolean connected;
    private int defaultPort;
    private boolean disableAuthLogin;
    private boolean disableAuthPlain;
    private boolean enableImapEvents;
    private boolean enableSASL;
    private boolean enableStartTLS;
    private boolean forcePasswordRefresh;
    private String host;
    private boolean isSSL;
    private int minIdleTime;
    private String name;
    private Namespaces namespaces;
    private PrintStream out;
    private String password;
    private ConnectionPool pool;
    private int port;
    private String proxyAuthUser;
    private String[] saslMechanisms;
    private String saslRealm;
    private int statusCacheTimeout;
    private String user;

    static class ConnectionPool {
        private static final int ABORTING = 2;
        private static final int IDLE = 1;
        private static final int RUNNING = 0;
        /* access modifiers changed from: private */
        public Vector authenticatedConnections = new Vector();
        /* access modifiers changed from: private */
        public long clientTimeoutInterval = 45000;
        /* access modifiers changed from: private */
        public boolean debug = false;
        /* access modifiers changed from: private */
        public Vector folders;
        /* access modifiers changed from: private */
        public IMAPProtocol idleProtocol;
        /* access modifiers changed from: private */
        public int idleState = 0;
        /* access modifiers changed from: private */
        public long lastTimePruned;
        /* access modifiers changed from: private */
        public int poolSize = 1;
        /* access modifiers changed from: private */
        public long pruningInterval = 60000;
        /* access modifiers changed from: private */
        public boolean separateStoreConnection = false;
        /* access modifiers changed from: private */
        public long serverTimeoutInterval = 1800000;
        /* access modifiers changed from: private */
        public boolean storeConnectionInUse = false;

        ConnectionPool() {
        }
    }

    public IMAPStore(Session session, URLName uRLName) {
        this(session, uRLName, "imap", 143, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x034c  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x037a  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0387  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0405  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0439  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0479  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x04a3  */
    /* JADX WARNING: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01aa A[SYNTHETIC, Splitter:B:42:0x01aa] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01ef A[SYNTHETIC, Splitter:B:52:0x01ef] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0235 A[SYNTHETIC, Splitter:B:62:0x0235] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x02b0  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02f0  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x031e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected IMAPStore(javax.mail.Session r4, javax.mail.URLName r5, java.lang.String r6, int r7, boolean r8) {
        /*
            r3 = this;
            r3.<init>(r4, r5)
            java.lang.String r0 = "imap"
            r3.name = r0
            r0 = 143(0x8f, float:2.0E-43)
            r3.defaultPort = r0
            r0 = 0
            r3.isSSL = r0
            r1 = -1
            r3.port = r1
            r2 = 16384(0x4000, float:2.2959E-41)
            r3.blksize = r2
            r2 = 1000(0x3e8, float:1.401E-42)
            r3.statusCacheTimeout = r2
            r3.appendBufferSize = r1
            r2 = 10
            r3.minIdleTime = r2
            r3.disableAuthLogin = r0
            r3.disableAuthPlain = r0
            r3.enableStartTLS = r0
            r3.enableSASL = r0
            r3.forcePasswordRefresh = r0
            r3.enableImapEvents = r0
            r3.connected = r0
            com.sun.mail.imap.IMAPStore$ConnectionPool r0 = new com.sun.mail.imap.IMAPStore$ConnectionPool
            r0.<init>()
            r3.pool = r0
            if (r5 == 0) goto L_0x003a
            java.lang.String r6 = r5.getProtocol()
        L_0x003a:
            r3.name = r6
            r3.defaultPort = r7
            r3.isSSL = r8
            com.sun.mail.imap.IMAPStore$ConnectionPool r5 = r3.pool
            long r7 = java.lang.System.currentTimeMillis()
            r5.lastTimePruned = r7
            boolean r5 = r4.getDebug()
            r3.debug = r5
            java.io.PrintStream r5 = r4.getDebugOut()
            r3.out = r5
            java.io.PrintStream r5 = r3.out
            if (r5 != 0) goto L_0x005d
            java.io.PrintStream r5 = java.lang.System.out
            r3.out = r5
        L_0x005d:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "mail."
            r5.<init>(r7)
            r5.append(r6)
            java.lang.String r7 = ".connectionpool.debug"
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            r7 = 1
            if (r5 == 0) goto L_0x0084
            java.lang.String r8 = "true"
            boolean r5 = r5.equalsIgnoreCase(r8)
            if (r5 == 0) goto L_0x0084
            com.sun.mail.imap.IMAPStore$ConnectionPool r5 = r3.pool
            r5.debug = r7
        L_0x0084:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "mail."
            r5.<init>(r8)
            r5.append(r6)
            java.lang.String r8 = ".partialfetch"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            if (r5 == 0) goto L_0x00b3
            java.lang.String r8 = "false"
            boolean r5 = r5.equalsIgnoreCase(r8)
            if (r5 == 0) goto L_0x00b3
            r3.blksize = r1
            boolean r5 = r3.debug
            if (r5 == 0) goto L_0x00e9
            java.io.PrintStream r5 = r3.out
            java.lang.String r8 = "DEBUG: mail.imap.partialfetch: false"
        L_0x00af:
            r5.println(r8)
            goto L_0x00e9
        L_0x00b3:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "mail."
            r5.<init>(r8)
            r5.append(r6)
            java.lang.String r8 = ".fetchsize"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            if (r5 == 0) goto L_0x00d2
            int r5 = java.lang.Integer.parseInt(r5)
            r3.blksize = r5
        L_0x00d2:
            boolean r5 = r3.debug
            if (r5 == 0) goto L_0x00e9
            java.io.PrintStream r5 = r3.out
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "DEBUG: mail.imap.fetchsize: "
            r8.<init>(r0)
            int r0 = r3.blksize
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            goto L_0x00af
        L_0x00e9:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "mail."
            r5.<init>(r8)
            r5.append(r6)
            java.lang.String r8 = ".statuscachetimeout"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            if (r5 == 0) goto L_0x0121
            int r5 = java.lang.Integer.parseInt(r5)
            r3.statusCacheTimeout = r5
            boolean r5 = r3.debug
            if (r5 == 0) goto L_0x0121
            java.io.PrintStream r5 = r3.out
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "DEBUG: mail.imap.statuscachetimeout: "
            r8.<init>(r0)
            int r0 = r3.statusCacheTimeout
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r5.println(r8)
        L_0x0121:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "mail."
            r5.<init>(r8)
            r5.append(r6)
            java.lang.String r8 = ".appendbuffersize"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            if (r5 == 0) goto L_0x0159
            int r5 = java.lang.Integer.parseInt(r5)
            r3.appendBufferSize = r5
            boolean r5 = r3.debug
            if (r5 == 0) goto L_0x0159
            java.io.PrintStream r5 = r3.out
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "DEBUG: mail.imap.appendbuffersize: "
            r8.<init>(r0)
            int r0 = r3.appendBufferSize
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r5.println(r8)
        L_0x0159:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "mail."
            r5.<init>(r8)
            r5.append(r6)
            java.lang.String r8 = ".minidletime"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            if (r5 == 0) goto L_0x0191
            int r5 = java.lang.Integer.parseInt(r5)
            r3.minIdleTime = r5
            boolean r5 = r3.debug
            if (r5 == 0) goto L_0x0191
            java.io.PrintStream r5 = r3.out
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "DEBUG: mail.imap.minidletime: "
            r8.<init>(r0)
            int r0 = r3.minIdleTime
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r5.println(r8)
        L_0x0191:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "mail."
            r5.<init>(r8)
            r5.append(r6)
            java.lang.String r8 = ".connectionpoolsize"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            if (r5 == 0) goto L_0x01d6
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ NumberFormatException -> 0x01b5 }
            if (r5 <= 0) goto L_0x01b5
            com.sun.mail.imap.IMAPStore$ConnectionPool r8 = r3.pool     // Catch:{ NumberFormatException -> 0x01b5 }
            r8.poolSize = r5     // Catch:{ NumberFormatException -> 0x01b5 }
        L_0x01b5:
            com.sun.mail.imap.IMAPStore$ConnectionPool r5 = r3.pool
            boolean r5 = r5.debug
            if (r5 == 0) goto L_0x01d6
            java.io.PrintStream r5 = r3.out
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "DEBUG: mail.imap.connectionpoolsize: "
            r8.<init>(r0)
            com.sun.mail.imap.IMAPStore$ConnectionPool r0 = r3.pool
            int r0 = r0.poolSize
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r5.println(r8)
        L_0x01d6:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "mail."
            r5.<init>(r8)
            r5.append(r6)
            java.lang.String r8 = ".connectionpooltimeout"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            if (r5 == 0) goto L_0x021c
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ NumberFormatException -> 0x01fb }
            if (r5 <= 0) goto L_0x01fb
            com.sun.mail.imap.IMAPStore$ConnectionPool r8 = r3.pool     // Catch:{ NumberFormatException -> 0x01fb }
            long r0 = (long) r5     // Catch:{ NumberFormatException -> 0x01fb }
            r8.clientTimeoutInterval = r0     // Catch:{ NumberFormatException -> 0x01fb }
        L_0x01fb:
            com.sun.mail.imap.IMAPStore$ConnectionPool r5 = r3.pool
            boolean r5 = r5.debug
            if (r5 == 0) goto L_0x021c
            java.io.PrintStream r5 = r3.out
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "DEBUG: mail.imap.connectionpooltimeout: "
            r8.<init>(r0)
            com.sun.mail.imap.IMAPStore$ConnectionPool r0 = r3.pool
            long r0 = r0.clientTimeoutInterval
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r5.println(r8)
        L_0x021c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "mail."
            r5.<init>(r8)
            r5.append(r6)
            java.lang.String r8 = ".servertimeout"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            if (r5 == 0) goto L_0x0262
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ NumberFormatException -> 0x0241 }
            if (r5 <= 0) goto L_0x0241
            com.sun.mail.imap.IMAPStore$ConnectionPool r8 = r3.pool     // Catch:{ NumberFormatException -> 0x0241 }
            long r0 = (long) r5     // Catch:{ NumberFormatException -> 0x0241 }
            r8.serverTimeoutInterval = r0     // Catch:{ NumberFormatException -> 0x0241 }
        L_0x0241:
            com.sun.mail.imap.IMAPStore$ConnectionPool r5 = r3.pool
            boolean r5 = r5.debug
            if (r5 == 0) goto L_0x0262
            java.io.PrintStream r5 = r3.out
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "DEBUG: mail.imap.servertimeout: "
            r8.<init>(r0)
            com.sun.mail.imap.IMAPStore$ConnectionPool r0 = r3.pool
            long r0 = r0.serverTimeoutInterval
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r5.println(r8)
        L_0x0262:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "mail."
            r5.<init>(r8)
            r5.append(r6)
            java.lang.String r8 = ".separatestoreconnection"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            if (r5 == 0) goto L_0x0297
            java.lang.String r8 = "true"
            boolean r5 = r5.equalsIgnoreCase(r8)
            if (r5 == 0) goto L_0x0297
            com.sun.mail.imap.IMAPStore$ConnectionPool r5 = r3.pool
            boolean r5 = r5.debug
            if (r5 == 0) goto L_0x0292
            java.io.PrintStream r5 = r3.out
            java.lang.String r8 = "DEBUG: dedicate a store connection"
            r5.println(r8)
        L_0x0292:
            com.sun.mail.imap.IMAPStore$ConnectionPool r5 = r3.pool
            r5.separateStoreConnection = r7
        L_0x0297:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "mail."
            r5.<init>(r8)
            r5.append(r6)
            java.lang.String r8 = ".proxyauth.user"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            if (r5 == 0) goto L_0x02cb
            r3.proxyAuthUser = r5
            boolean r5 = r3.debug
            if (r5 == 0) goto L_0x02cb
            java.io.PrintStream r5 = r3.out
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "DEBUG: mail.imap.proxyauth.user: "
            r8.<init>(r0)
            java.lang.String r0 = r3.proxyAuthUser
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r5.println(r8)
        L_0x02cb:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "mail."
            r5.<init>(r8)
            r5.append(r6)
            java.lang.String r8 = ".auth.login.disable"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            if (r5 == 0) goto L_0x02f9
            java.lang.String r8 = "true"
            boolean r5 = r5.equalsIgnoreCase(r8)
            if (r5 == 0) goto L_0x02f9
            boolean r5 = r3.debug
            if (r5 == 0) goto L_0x02f7
            java.io.PrintStream r5 = r3.out
            java.lang.String r8 = "DEBUG: disable AUTH=LOGIN"
            r5.println(r8)
        L_0x02f7:
            r3.disableAuthLogin = r7
        L_0x02f9:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "mail."
            r5.<init>(r8)
            r5.append(r6)
            java.lang.String r8 = ".auth.plain.disable"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            if (r5 == 0) goto L_0x0327
            java.lang.String r8 = "true"
            boolean r5 = r5.equalsIgnoreCase(r8)
            if (r5 == 0) goto L_0x0327
            boolean r5 = r3.debug
            if (r5 == 0) goto L_0x0325
            java.io.PrintStream r5 = r3.out
            java.lang.String r8 = "DEBUG: disable AUTH=PLAIN"
            r5.println(r8)
        L_0x0325:
            r3.disableAuthPlain = r7
        L_0x0327:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "mail."
            r5.<init>(r8)
            r5.append(r6)
            java.lang.String r8 = ".starttls.enable"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            if (r5 == 0) goto L_0x0355
            java.lang.String r8 = "true"
            boolean r5 = r5.equalsIgnoreCase(r8)
            if (r5 == 0) goto L_0x0355
            boolean r5 = r3.debug
            if (r5 == 0) goto L_0x0353
            java.io.PrintStream r5 = r3.out
            java.lang.String r8 = "DEBUG: enable STARTTLS"
            r5.println(r8)
        L_0x0353:
            r3.enableStartTLS = r7
        L_0x0355:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "mail."
            r5.<init>(r8)
            r5.append(r6)
            java.lang.String r8 = ".sasl.enable"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            if (r5 == 0) goto L_0x0383
            java.lang.String r8 = "true"
            boolean r5 = r5.equalsIgnoreCase(r8)
            if (r5 == 0) goto L_0x0383
            boolean r5 = r3.debug
            if (r5 == 0) goto L_0x0381
            java.io.PrintStream r5 = r3.out
            java.lang.String r8 = "DEBUG: enable SASL"
            r5.println(r8)
        L_0x0381:
            r3.enableSASL = r7
        L_0x0383:
            boolean r5 = r3.enableSASL
            if (r5 == 0) goto L_0x03ec
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "mail."
            r5.<init>(r8)
            r5.append(r6)
            java.lang.String r8 = ".sasl.mechanisms"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            if (r5 == 0) goto L_0x03ec
            int r8 = r5.length()
            if (r8 <= 0) goto L_0x03ec
            boolean r8 = r3.debug
            if (r8 == 0) goto L_0x03bd
            java.io.PrintStream r8 = r3.out
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "DEBUG: SASL mechanisms allowed: "
            r0.<init>(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r8.println(r0)
        L_0x03bd:
            java.util.Vector r8 = new java.util.Vector
            r0 = 5
            r8.<init>(r0)
            java.util.StringTokenizer r0 = new java.util.StringTokenizer
            java.lang.String r1 = " ,"
            r0.<init>(r5, r1)
        L_0x03ca:
            boolean r5 = r0.hasMoreTokens()
            if (r5 != 0) goto L_0x03de
            int r5 = r8.size()
            java.lang.String[] r5 = new java.lang.String[r5]
            r3.saslMechanisms = r5
            java.lang.String[] r5 = r3.saslMechanisms
            r8.copyInto(r5)
            goto L_0x03ec
        L_0x03de:
            java.lang.String r5 = r0.nextToken()
            int r1 = r5.length()
            if (r1 <= 0) goto L_0x03ca
            r8.addElement(r5)
            goto L_0x03ca
        L_0x03ec:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "mail."
            r5.<init>(r8)
            r5.append(r6)
            java.lang.String r8 = ".sasl.authorizationid"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            if (r5 == 0) goto L_0x0420
            r3.authorizationID = r5
            boolean r5 = r3.debug
            if (r5 == 0) goto L_0x0420
            java.io.PrintStream r5 = r3.out
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "DEBUG: mail.imap.sasl.authorizationid: "
            r8.<init>(r0)
            java.lang.String r0 = r3.authorizationID
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r5.println(r8)
        L_0x0420:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "mail."
            r5.<init>(r8)
            r5.append(r6)
            java.lang.String r8 = ".sasl.realm"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            if (r5 == 0) goto L_0x0454
            r3.saslRealm = r5
            boolean r5 = r3.debug
            if (r5 == 0) goto L_0x0454
            java.io.PrintStream r5 = r3.out
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "DEBUG: mail.imap.sasl.realm: "
            r8.<init>(r0)
            java.lang.String r0 = r3.saslRealm
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r5.println(r8)
        L_0x0454:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "mail."
            r5.<init>(r8)
            r5.append(r6)
            java.lang.String r8 = ".forcepasswordrefresh"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            if (r5 == 0) goto L_0x0482
            java.lang.String r8 = "true"
            boolean r5 = r5.equalsIgnoreCase(r8)
            if (r5 == 0) goto L_0x0482
            boolean r5 = r3.debug
            if (r5 == 0) goto L_0x0480
            java.io.PrintStream r5 = r3.out
            java.lang.String r8 = "DEBUG: enable forcePasswordRefresh"
            r5.println(r8)
        L_0x0480:
            r3.forcePasswordRefresh = r7
        L_0x0482:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "mail."
            r5.<init>(r8)
            r5.append(r6)
            java.lang.String r6 = ".enableimapevents"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r4 = r4.getProperty(r5)
            if (r4 == 0) goto L_0x04b0
            java.lang.String r5 = "true"
            boolean r4 = r4.equalsIgnoreCase(r5)
            if (r4 == 0) goto L_0x04b0
            boolean r4 = r3.debug
            if (r4 == 0) goto L_0x04ae
            java.io.PrintStream r4 = r3.out
            java.lang.String r5 = "DEBUG: enable IMAP events"
            r4.println(r5)
        L_0x04ae:
            r3.enableImapEvents = r7
        L_0x04b0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.<init>(javax.mail.Session, javax.mail.URLName, java.lang.String, int, boolean):void");
    }

    private void checkConnected() {
        if (!this.connected) {
            super.setConnected(false);
            throw new IllegalStateException("Not connected");
        }
    }

    private void cleanup() {
        cleanup(false);
    }

    private void cleanup(boolean z) {
        boolean z2;
        if (this.debug) {
            this.out.println("DEBUG: IMAPStore cleanup, force " + z);
        }
        Vector vector = null;
        while (true) {
            synchronized (this.pool) {
                if (this.pool.folders != null) {
                    vector = this.pool.folders;
                    this.pool.folders = null;
                    z2 = false;
                } else {
                    z2 = true;
                }
            }
            if (!z2) {
                int size = vector.size();
                for (int i = 0; i < size; i++) {
                    IMAPFolder iMAPFolder = (IMAPFolder) vector.elementAt(i);
                    if (z) {
                        try {
                            if (this.debug) {
                                this.out.println("DEBUG: force folder to close");
                            }
                            iMAPFolder.forceClose();
                        } catch (IllegalStateException | MessagingException unused) {
                        }
                    } else {
                        if (this.debug) {
                            this.out.println("DEBUG: close folder");
                        }
                        iMAPFolder.close(false);
                    }
                }
            } else {
                synchronized (this.pool) {
                    emptyConnectionPool(z);
                }
                this.connected = false;
                notifyConnectionListeners(3);
                if (this.debug) {
                    this.out.println("DEBUG: IMAPStore cleanup done");
                    return;
                }
                return;
            }
        }
        while (true) {
        }
    }

    private void emptyConnectionPool(boolean z) {
        synchronized (this.pool) {
            for (int size = this.pool.authenticatedConnections.size() - 1; size >= 0; size--) {
                try {
                    IMAPProtocol iMAPProtocol = (IMAPProtocol) this.pool.authenticatedConnections.elementAt(size);
                    iMAPProtocol.removeResponseHandler(this);
                    if (z) {
                        iMAPProtocol.disconnect();
                    } else {
                        iMAPProtocol.logout();
                    }
                } catch (ProtocolException unused) {
                }
            }
            this.pool.authenticatedConnections.removeAllElements();
        }
        if (this.pool.debug) {
            this.out.println("DEBUG: removed all authenticated connections");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        if (r1 == null) goto L_0x0018;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.sun.mail.imap.protocol.Namespaces getNamespaces() throws javax.mail.MessagingException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.checkConnected()     // Catch:{ all -> 0x0058 }
            r0 = 0
            com.sun.mail.imap.protocol.Namespaces r1 = r5.namespaces     // Catch:{ all -> 0x0058 }
            if (r1 != 0) goto L_0x0054
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r5.getStoreProtocol()     // Catch:{ BadCommandException -> 0x004e, ConnectionException -> 0x0037, ProtocolException -> 0x0029, all -> 0x0024 }
            com.sun.mail.imap.protocol.Namespaces r0 = r1.namespace()     // Catch:{ BadCommandException -> 0x0022, ConnectionException -> 0x0020, ProtocolException -> 0x001e }
            r5.namespaces = r0     // Catch:{ BadCommandException -> 0x0022, ConnectionException -> 0x0020, ProtocolException -> 0x001e }
            r5.releaseStoreProtocol(r1)     // Catch:{ all -> 0x0058 }
            if (r1 != 0) goto L_0x0054
        L_0x0018:
            r5.cleanup()     // Catch:{ all -> 0x0058 }
            goto L_0x0054
        L_0x001c:
            r0 = move-exception
            goto L_0x0045
        L_0x001e:
            r0 = move-exception
            goto L_0x002d
        L_0x0020:
            r0 = move-exception
            goto L_0x003b
        L_0x0022:
            r0 = r1
            goto L_0x004e
        L_0x0024:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0045
        L_0x0029:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x002d:
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x001c }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x001c }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x001c }
            throw r2     // Catch:{ all -> 0x001c }
        L_0x0037:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x003b:
            javax.mail.StoreClosedException r2 = new javax.mail.StoreClosedException     // Catch:{ all -> 0x001c }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x001c }
            r2.<init>(r5, r0)     // Catch:{ all -> 0x001c }
            throw r2     // Catch:{ all -> 0x001c }
        L_0x0045:
            r5.releaseStoreProtocol(r1)     // Catch:{ all -> 0x0058 }
            if (r1 != 0) goto L_0x004d
            r5.cleanup()     // Catch:{ all -> 0x0058 }
        L_0x004d:
            throw r0     // Catch:{ all -> 0x0058 }
        L_0x004e:
            r5.releaseStoreProtocol(r0)     // Catch:{ all -> 0x0058 }
            if (r0 != 0) goto L_0x0054
            goto L_0x0018
        L_0x0054:
            com.sun.mail.imap.protocol.Namespaces r0 = r5.namespaces     // Catch:{ all -> 0x0058 }
            monitor-exit(r5)
            return r0
        L_0x0058:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.getNamespaces():com.sun.mail.imap.protocol.Namespaces");
    }

    private void login(IMAPProtocol iMAPProtocol, String str, String str2) throws ProtocolException {
        if (this.enableStartTLS && iMAPProtocol.hasCapability("STARTTLS")) {
            iMAPProtocol.startTLS();
            iMAPProtocol.capability();
        }
        if (!iMAPProtocol.isAuthenticated()) {
            iMAPProtocol.getCapabilities().put("__PRELOGIN__", "");
            String str3 = this.authorizationID != null ? this.authorizationID : this.proxyAuthUser != null ? this.proxyAuthUser : str;
            if (this.enableSASL) {
                iMAPProtocol.sasllogin(this.saslMechanisms, this.saslRealm, str3, str, str2);
            }
            if (!iMAPProtocol.isAuthenticated()) {
                if (iMAPProtocol.hasCapability("AUTH=PLAIN") && !this.disableAuthPlain) {
                    iMAPProtocol.authplain(str3, str, str2);
                } else if ((iMAPProtocol.hasCapability("AUTH-LOGIN") || iMAPProtocol.hasCapability("AUTH=LOGIN")) && !this.disableAuthLogin) {
                    iMAPProtocol.authlogin(str, str2);
                } else if (!iMAPProtocol.hasCapability("LOGINDISABLED")) {
                    iMAPProtocol.login(str, str2);
                } else {
                    throw new ProtocolException("No login methods supported!");
                }
            }
            if (this.proxyAuthUser != null) {
                iMAPProtocol.proxyauth(this.proxyAuthUser);
            }
            if (iMAPProtocol.hasCapability("__PRELOGIN__")) {
                try {
                    iMAPProtocol.capability();
                } catch (ConnectionException e) {
                    throw e;
                } catch (ProtocolException unused) {
                }
            }
        }
    }

    private Folder[] namespaceToFolders(Namespaces.Namespace[] namespaceArr, String str) {
        Folder[] folderArr = new Folder[namespaceArr.length];
        for (int i = 0; i < folderArr.length; i++) {
            String str2 = namespaceArr[i].prefix;
            if (str == null) {
                int length = str2.length();
                if (length > 0) {
                    int i2 = length - 1;
                    if (str2.charAt(i2) == namespaceArr[i].delimiter) {
                        str2 = str2.substring(0, i2);
                    }
                }
            } else {
                str2 = String.valueOf(str2) + str;
            }
            folderArr[i] = new IMAPFolder(str2, namespaceArr[i].delimiter, this, str == null);
        }
        return folderArr;
    }

    private void timeoutConnections() {
        synchronized (this.pool) {
            if (System.currentTimeMillis() - this.pool.lastTimePruned > this.pool.pruningInterval && this.pool.authenticatedConnections.size() > 1) {
                if (this.pool.debug) {
                    this.out.println("DEBUG: checking for connections to prune: " + (System.currentTimeMillis() - this.pool.lastTimePruned));
                    this.out.println("DEBUG: clientTimeoutInterval: " + this.pool.clientTimeoutInterval);
                }
                for (int size = this.pool.authenticatedConnections.size() - 1; size > 0; size--) {
                    IMAPProtocol iMAPProtocol = (IMAPProtocol) this.pool.authenticatedConnections.elementAt(size);
                    if (this.pool.debug) {
                        this.out.println("DEBUG: protocol last used: " + (System.currentTimeMillis() - iMAPProtocol.getTimestamp()));
                    }
                    if (System.currentTimeMillis() - iMAPProtocol.getTimestamp() > this.pool.clientTimeoutInterval) {
                        if (this.pool.debug) {
                            this.out.println("DEBUG: authenticated connection timed out");
                            this.out.println("DEBUG: logging out the connection");
                        }
                        iMAPProtocol.removeResponseHandler(this);
                        this.pool.authenticatedConnections.removeElementAt(size);
                        try {
                            iMAPProtocol.logout();
                        } catch (ProtocolException unused) {
                        }
                    }
                }
                this.pool.lastTimePruned = System.currentTimeMillis();
            }
        }
    }

    private void waitIfIdle() throws ProtocolException {
        while (this.pool.idleState != 0) {
            if (this.pool.idleState == 1) {
                this.pool.idleProtocol.idleAbort();
                this.pool.idleState = 2;
            }
            try {
                this.pool.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean allowReadOnlySelect() {
        Session session = this.session;
        String property = session.getProperty("mail." + this.name + ".allowreadonlyselect");
        return property != null && property.equalsIgnoreCase("true");
    }

    public synchronized void close() throws MessagingException {
        IMAPProtocol iMAPProtocol;
        boolean isEmpty;
        if (super.isConnected()) {
            iMAPProtocol = null;
            try {
                synchronized (this.pool) {
                    isEmpty = this.pool.authenticatedConnections.isEmpty();
                }
                if (isEmpty) {
                    if (this.pool.debug) {
                        this.out.println("DEBUG: close() - no connections ");
                    }
                    cleanup();
                    releaseStoreProtocol((IMAPProtocol) null);
                    return;
                }
                IMAPProtocol storeProtocol = getStoreProtocol();
                try {
                    synchronized (this.pool) {
                        this.pool.authenticatedConnections.removeElement(storeProtocol);
                    }
                    storeProtocol.logout();
                    releaseStoreProtocol(storeProtocol);
                    return;
                } catch (ProtocolException e) {
                    IMAPProtocol iMAPProtocol2 = storeProtocol;
                    e = e;
                    iMAPProtocol = iMAPProtocol2;
                } catch (Throwable th) {
                    IMAPProtocol iMAPProtocol3 = storeProtocol;
                    th = th;
                    iMAPProtocol = iMAPProtocol3;
                    releaseStoreProtocol(iMAPProtocol);
                    throw th;
                }
            } catch (ProtocolException e2) {
                e = e2;
            }
        } else {
            return;
        }
        try {
            cleanup();
            throw new MessagingException(e.getMessage(), e);
        } catch (Throwable th2) {
            th = th2;
            releaseStoreProtocol(iMAPProtocol);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        close();
    }

    /* access modifiers changed from: package-private */
    public int getAppendBufferSize() {
        return this.appendBufferSize;
    }

    /* access modifiers changed from: package-private */
    public boolean getConnectionPoolDebug() {
        return this.pool.debug;
    }

    public synchronized Folder getDefaultFolder() throws MessagingException {
        checkConnected();
        return new DefaultFolder(this);
    }

    /* access modifiers changed from: package-private */
    public int getFetchBlockSize() {
        return this.blksize;
    }

    public synchronized Folder getFolder(String str) throws MessagingException {
        checkConnected();
        return new IMAPFolder(str, 65535, this);
    }

    public synchronized Folder getFolder(URLName uRLName) throws MessagingException {
        checkConnected();
        return new IMAPFolder(uRLName.getFile(), 65535, this);
    }

    /* access modifiers changed from: package-private */
    public int getMinIdleTime() {
        return this.minIdleTime;
    }

    public Folder[] getPersonalNamespaces() throws MessagingException {
        Namespaces namespaces2 = getNamespaces();
        return (namespaces2 == null || namespaces2.personal == null) ? super.getPersonalNamespaces() : namespaceToFolders(namespaces2.personal, (String) null);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:22|23|24|25|26) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0081 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0087 */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f3 A[SYNTHETIC, Splitter:B:57:0x00f3] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.sun.mail.imap.protocol.IMAPProtocol getProtocol(com.sun.mail.imap.IMAPFolder r13) throws javax.mail.MessagingException {
        /*
            r12 = this;
            r0 = 0
        L_0x0001:
            r1 = r0
        L_0x0002:
            if (r1 == 0) goto L_0x0005
            return r1
        L_0x0005:
            com.sun.mail.imap.IMAPStore$ConnectionPool r2 = r12.pool
            monitor-enter(r2)
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r12.pool     // Catch:{ all -> 0x011f }
            java.util.Vector r3 = r3.authenticatedConnections     // Catch:{ all -> 0x011f }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x011f }
            if (r3 != 0) goto L_0x008f
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r12.pool     // Catch:{ all -> 0x011f }
            java.util.Vector r3 = r3.authenticatedConnections     // Catch:{ all -> 0x011f }
            int r3 = r3.size()     // Catch:{ all -> 0x011f }
            r4 = 1
            if (r3 != r4) goto L_0x0032
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r12.pool     // Catch:{ all -> 0x011f }
            boolean r3 = r3.separateStoreConnection     // Catch:{ all -> 0x011f }
            if (r3 != 0) goto L_0x008f
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r12.pool     // Catch:{ all -> 0x011f }
            boolean r3 = r3.storeConnectionInUse     // Catch:{ all -> 0x011f }
            if (r3 == 0) goto L_0x0032
            goto L_0x008f
        L_0x0032:
            boolean r1 = r12.debug     // Catch:{ all -> 0x011f }
            if (r1 == 0) goto L_0x0053
            java.io.PrintStream r1 = r12.out     // Catch:{ all -> 0x011f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x011f }
            java.lang.String r4 = "DEBUG: connection available -- size: "
            r3.<init>(r4)     // Catch:{ all -> 0x011f }
            com.sun.mail.imap.IMAPStore$ConnectionPool r4 = r12.pool     // Catch:{ all -> 0x011f }
            java.util.Vector r4 = r4.authenticatedConnections     // Catch:{ all -> 0x011f }
            int r4 = r4.size()     // Catch:{ all -> 0x011f }
            r3.append(r4)     // Catch:{ all -> 0x011f }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x011f }
            r1.println(r3)     // Catch:{ all -> 0x011f }
        L_0x0053:
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r12.pool     // Catch:{ all -> 0x011f }
            java.util.Vector r1 = r1.authenticatedConnections     // Catch:{ all -> 0x011f }
            java.lang.Object r1 = r1.lastElement()     // Catch:{ all -> 0x011f }
            com.sun.mail.imap.protocol.IMAPProtocol r1 = (com.sun.mail.imap.protocol.IMAPProtocol) r1     // Catch:{ all -> 0x011f }
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r12.pool     // Catch:{ all -> 0x011f }
            java.util.Vector r3 = r3.authenticatedConnections     // Catch:{ all -> 0x011f }
            r3.removeElement(r1)     // Catch:{ all -> 0x011f }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x011f }
            long r5 = r1.getTimestamp()     // Catch:{ all -> 0x011f }
            r7 = 0
            long r7 = r3 - r5
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r12.pool     // Catch:{ all -> 0x011f }
            long r3 = r3.serverTimeoutInterval     // Catch:{ all -> 0x011f }
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x008a
            r1.noop()     // Catch:{ ProtocolException -> 0x0081 }
            goto L_0x008a
        L_0x0081:
            r1.removeResponseHandler(r12)     // Catch:{ all -> 0x0087 }
            r1.disconnect()     // Catch:{ all -> 0x0087 }
        L_0x0087:
            monitor-exit(r2)     // Catch:{ all -> 0x011f }
            goto L_0x0001
        L_0x008a:
            r1.removeResponseHandler(r12)     // Catch:{ all -> 0x011f }
            goto L_0x00fc
        L_0x008f:
            boolean r3 = r12.debug     // Catch:{ all -> 0x011f }
            if (r3 == 0) goto L_0x009a
            java.io.PrintStream r3 = r12.out     // Catch:{ all -> 0x011f }
            java.lang.String r4 = "DEBUG: no connections in the pool, creating a new one"
            r3.println(r4)     // Catch:{ all -> 0x011f }
        L_0x009a:
            boolean r3 = r12.forcePasswordRefresh     // Catch:{ Exception -> 0x00eb }
            if (r3 == 0) goto L_0x00c2
            java.lang.String r3 = r12.host     // Catch:{ UnknownHostException -> 0x00a6 }
            java.net.InetAddress r3 = java.net.InetAddress.getByName(r3)     // Catch:{ UnknownHostException -> 0x00a6 }
            r4 = r3
            goto L_0x00a7
        L_0x00a6:
            r4 = r0
        L_0x00a7:
            javax.mail.Session r3 = r12.session     // Catch:{ Exception -> 0x00eb }
            int r5 = r12.port     // Catch:{ Exception -> 0x00eb }
            java.lang.String r6 = r12.name     // Catch:{ Exception -> 0x00eb }
            r7 = 0
            java.lang.String r8 = r12.user     // Catch:{ Exception -> 0x00eb }
            javax.mail.PasswordAuthentication r3 = r3.requestPasswordAuthentication(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00eb }
            if (r3 == 0) goto L_0x00c2
            java.lang.String r4 = r3.getUserName()     // Catch:{ Exception -> 0x00eb }
            r12.user = r4     // Catch:{ Exception -> 0x00eb }
            java.lang.String r3 = r3.getPassword()     // Catch:{ Exception -> 0x00eb }
            r12.password = r3     // Catch:{ Exception -> 0x00eb }
        L_0x00c2:
            com.sun.mail.imap.protocol.IMAPProtocol r11 = new com.sun.mail.imap.protocol.IMAPProtocol     // Catch:{ Exception -> 0x00eb }
            java.lang.String r4 = r12.name     // Catch:{ Exception -> 0x00eb }
            java.lang.String r5 = r12.host     // Catch:{ Exception -> 0x00eb }
            int r6 = r12.port     // Catch:{ Exception -> 0x00eb }
            javax.mail.Session r3 = r12.session     // Catch:{ Exception -> 0x00eb }
            boolean r7 = r3.getDebug()     // Catch:{ Exception -> 0x00eb }
            javax.mail.Session r3 = r12.session     // Catch:{ Exception -> 0x00eb }
            java.io.PrintStream r8 = r3.getDebugOut()     // Catch:{ Exception -> 0x00eb }
            javax.mail.Session r3 = r12.session     // Catch:{ Exception -> 0x00eb }
            java.util.Properties r9 = r3.getProperties()     // Catch:{ Exception -> 0x00eb }
            boolean r10 = r12.isSSL     // Catch:{ Exception -> 0x00eb }
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00eb }
            java.lang.String r1 = r12.user     // Catch:{ Exception -> 0x00ea }
            java.lang.String r3 = r12.password     // Catch:{ Exception -> 0x00ea }
            r12.login(r11, r1, r3)     // Catch:{ Exception -> 0x00ea }
            goto L_0x00f1
        L_0x00ea:
            r1 = r11
        L_0x00eb:
            if (r1 == 0) goto L_0x00f0
            r1.disconnect()     // Catch:{ Exception -> 0x00f0 }
        L_0x00f0:
            r11 = r0
        L_0x00f1:
            if (r11 != 0) goto L_0x00fb
            javax.mail.MessagingException r13 = new javax.mail.MessagingException     // Catch:{ all -> 0x011f }
            java.lang.String r0 = "connection failure"
            r13.<init>(r0)     // Catch:{ all -> 0x011f }
            throw r13     // Catch:{ all -> 0x011f }
        L_0x00fb:
            r1 = r11
        L_0x00fc:
            r12.timeoutConnections()     // Catch:{ all -> 0x011f }
            if (r13 == 0) goto L_0x011c
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r12.pool     // Catch:{ all -> 0x011f }
            java.util.Vector r3 = r3.folders     // Catch:{ all -> 0x011f }
            if (r3 != 0) goto L_0x0113
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r12.pool     // Catch:{ all -> 0x011f }
            java.util.Vector r4 = new java.util.Vector     // Catch:{ all -> 0x011f }
            r4.<init>()     // Catch:{ all -> 0x011f }
            r3.folders = r4     // Catch:{ all -> 0x011f }
        L_0x0113:
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r12.pool     // Catch:{ all -> 0x011f }
            java.util.Vector r3 = r3.folders     // Catch:{ all -> 0x011f }
            r3.addElement(r13)     // Catch:{ all -> 0x011f }
        L_0x011c:
            monitor-exit(r2)     // Catch:{ all -> 0x011f }
            goto L_0x0002
        L_0x011f:
            r13 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x011f }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.getProtocol(com.sun.mail.imap.IMAPFolder):com.sun.mail.imap.protocol.IMAPProtocol");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized javax.mail.Quota[] getQuota(java.lang.String r4) throws javax.mail.MessagingException {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.checkConnected()     // Catch:{ all -> 0x004d }
            r0 = 0
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r3.getStoreProtocol()     // Catch:{ BadCommandException -> 0x003b, ConnectionException -> 0x0030, ProtocolException -> 0x0025 }
            javax.mail.Quota[] r4 = r1.getQuotaRoot(r4)     // Catch:{ BadCommandException -> 0x0020, ConnectionException -> 0x001d, ProtocolException -> 0x001a, all -> 0x0017 }
            r3.releaseStoreProtocol(r1)     // Catch:{ all -> 0x004d }
            if (r1 != 0) goto L_0x0015
            r3.cleanup()     // Catch:{ all -> 0x004d }
        L_0x0015:
            monitor-exit(r3)
            return r4
        L_0x0017:
            r4 = move-exception
            r0 = r1
            goto L_0x0044
        L_0x001a:
            r4 = move-exception
            r0 = r1
            goto L_0x0026
        L_0x001d:
            r4 = move-exception
            r0 = r1
            goto L_0x0031
        L_0x0020:
            r4 = move-exception
            r0 = r1
            goto L_0x003c
        L_0x0023:
            r4 = move-exception
            goto L_0x0044
        L_0x0025:
            r4 = move-exception
        L_0x0026:
            javax.mail.MessagingException r1 = new javax.mail.MessagingException     // Catch:{ all -> 0x0023 }
            java.lang.String r2 = r4.getMessage()     // Catch:{ all -> 0x0023 }
            r1.<init>(r2, r4)     // Catch:{ all -> 0x0023 }
            throw r1     // Catch:{ all -> 0x0023 }
        L_0x0030:
            r4 = move-exception
        L_0x0031:
            javax.mail.StoreClosedException r1 = new javax.mail.StoreClosedException     // Catch:{ all -> 0x0023 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0023 }
            r1.<init>(r3, r4)     // Catch:{ all -> 0x0023 }
            throw r1     // Catch:{ all -> 0x0023 }
        L_0x003b:
            r4 = move-exception
        L_0x003c:
            javax.mail.MessagingException r1 = new javax.mail.MessagingException     // Catch:{ all -> 0x0023 }
            java.lang.String r2 = "QUOTA not supported"
            r1.<init>(r2, r4)     // Catch:{ all -> 0x0023 }
            throw r1     // Catch:{ all -> 0x0023 }
        L_0x0044:
            r3.releaseStoreProtocol(r0)     // Catch:{ all -> 0x004d }
            if (r0 != 0) goto L_0x004c
            r3.cleanup()     // Catch:{ all -> 0x004d }
        L_0x004c:
            throw r4     // Catch:{ all -> 0x004d }
        L_0x004d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.getQuota(java.lang.String):javax.mail.Quota[]");
    }

    /* access modifiers changed from: package-private */
    public Session getSession() {
        return this.session;
    }

    public Folder[] getSharedNamespaces() throws MessagingException {
        Namespaces namespaces2 = getNamespaces();
        return (namespaces2 == null || namespaces2.shared == null) ? super.getSharedNamespaces() : namespaceToFolders(namespaces2.shared, (String) null);
    }

    /* access modifiers changed from: package-private */
    public int getStatusCacheTimeout() {
        return this.statusCacheTimeout;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: com.sun.mail.imap.protocol.IMAPProtocol} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057 A[SYNTHETIC, Splitter:B:24:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.sun.mail.imap.protocol.IMAPProtocol getStoreProtocol() throws com.sun.mail.iap.ProtocolException {
        /*
            r12 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            if (r1 == 0) goto L_0x0005
            return r1
        L_0x0005:
            com.sun.mail.imap.IMAPStore$ConnectionPool r2 = r12.pool
            monitor-enter(r2)
            r12.waitIfIdle()     // Catch:{ all -> 0x00c9 }
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r12.pool     // Catch:{ all -> 0x00c9 }
            java.util.Vector r3 = r3.authenticatedConnections     // Catch:{ all -> 0x00c9 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x00c9 }
            if (r3 == 0) goto L_0x006c
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r12.pool     // Catch:{ all -> 0x00c9 }
            boolean r3 = r3.debug     // Catch:{ all -> 0x00c9 }
            if (r3 == 0) goto L_0x0026
            java.io.PrintStream r3 = r12.out     // Catch:{ all -> 0x00c9 }
            java.lang.String r4 = "DEBUG: getStoreProtocol() - no connections in the pool, creating a new one"
            r3.println(r4)     // Catch:{ all -> 0x00c9 }
        L_0x0026:
            com.sun.mail.imap.protocol.IMAPProtocol r11 = new com.sun.mail.imap.protocol.IMAPProtocol     // Catch:{ Exception -> 0x004f }
            java.lang.String r4 = r12.name     // Catch:{ Exception -> 0x004f }
            java.lang.String r5 = r12.host     // Catch:{ Exception -> 0x004f }
            int r6 = r12.port     // Catch:{ Exception -> 0x004f }
            javax.mail.Session r3 = r12.session     // Catch:{ Exception -> 0x004f }
            boolean r7 = r3.getDebug()     // Catch:{ Exception -> 0x004f }
            javax.mail.Session r3 = r12.session     // Catch:{ Exception -> 0x004f }
            java.io.PrintStream r8 = r3.getDebugOut()     // Catch:{ Exception -> 0x004f }
            javax.mail.Session r3 = r12.session     // Catch:{ Exception -> 0x004f }
            java.util.Properties r9 = r3.getProperties()     // Catch:{ Exception -> 0x004f }
            boolean r10 = r12.isSSL     // Catch:{ Exception -> 0x004f }
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x004f }
            java.lang.String r1 = r12.user     // Catch:{ Exception -> 0x004e }
            java.lang.String r3 = r12.password     // Catch:{ Exception -> 0x004e }
            r12.login(r11, r1, r3)     // Catch:{ Exception -> 0x004e }
            goto L_0x0055
        L_0x004e:
            r1 = r11
        L_0x004f:
            if (r1 == 0) goto L_0x0054
            r1.logout()     // Catch:{ Exception -> 0x0054 }
        L_0x0054:
            r11 = r0
        L_0x0055:
            if (r11 != 0) goto L_0x005f
            com.sun.mail.iap.ConnectionException r0 = new com.sun.mail.iap.ConnectionException     // Catch:{ all -> 0x00c9 }
            java.lang.String r1 = "failed to create new store connection"
            r0.<init>(r1)     // Catch:{ all -> 0x00c9 }
            throw r0     // Catch:{ all -> 0x00c9 }
        L_0x005f:
            r11.addResponseHandler(r12)     // Catch:{ all -> 0x00c9 }
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r12.pool     // Catch:{ all -> 0x00c9 }
            java.util.Vector r1 = r1.authenticatedConnections     // Catch:{ all -> 0x00c9 }
            r1.addElement(r11)     // Catch:{ all -> 0x00c9 }
            goto L_0x009e
        L_0x006c:
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r12.pool     // Catch:{ all -> 0x00c9 }
            boolean r1 = r1.debug     // Catch:{ all -> 0x00c9 }
            if (r1 == 0) goto L_0x0091
            java.io.PrintStream r1 = r12.out     // Catch:{ all -> 0x00c9 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c9 }
            java.lang.String r4 = "DEBUG: getStoreProtocol() - connection available -- size: "
            r3.<init>(r4)     // Catch:{ all -> 0x00c9 }
            com.sun.mail.imap.IMAPStore$ConnectionPool r4 = r12.pool     // Catch:{ all -> 0x00c9 }
            java.util.Vector r4 = r4.authenticatedConnections     // Catch:{ all -> 0x00c9 }
            int r4 = r4.size()     // Catch:{ all -> 0x00c9 }
            r3.append(r4)     // Catch:{ all -> 0x00c9 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00c9 }
            r1.println(r3)     // Catch:{ all -> 0x00c9 }
        L_0x0091:
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r12.pool     // Catch:{ all -> 0x00c9 }
            java.util.Vector r1 = r1.authenticatedConnections     // Catch:{ all -> 0x00c9 }
            java.lang.Object r1 = r1.firstElement()     // Catch:{ all -> 0x00c9 }
            r11 = r1
            com.sun.mail.imap.protocol.IMAPProtocol r11 = (com.sun.mail.imap.protocol.IMAPProtocol) r11     // Catch:{ all -> 0x00c9 }
        L_0x009e:
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r12.pool     // Catch:{ all -> 0x00c9 }
            boolean r1 = r1.storeConnectionInUse     // Catch:{ all -> 0x00c9 }
            if (r1 == 0) goto L_0x00ad
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r12.pool     // Catch:{ InterruptedException -> 0x00ab }
            r1.wait()     // Catch:{ InterruptedException -> 0x00ab }
        L_0x00ab:
            r1 = r0
            goto L_0x00c3
        L_0x00ad:
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r12.pool     // Catch:{ all -> 0x00c9 }
            r3 = 1
            r1.storeConnectionInUse = r3     // Catch:{ all -> 0x00c9 }
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r12.pool     // Catch:{ all -> 0x00c9 }
            boolean r1 = r1.debug     // Catch:{ all -> 0x00c9 }
            if (r1 == 0) goto L_0x00c2
            java.io.PrintStream r1 = r12.out     // Catch:{ all -> 0x00c9 }
            java.lang.String r3 = "DEBUG: getStoreProtocol() -- storeConnectionInUse"
            r1.println(r3)     // Catch:{ all -> 0x00c9 }
        L_0x00c2:
            r1 = r11
        L_0x00c3:
            r12.timeoutConnections()     // Catch:{ all -> 0x00c9 }
            monitor-exit(r2)     // Catch:{ all -> 0x00c9 }
            goto L_0x0002
        L_0x00c9:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00c9 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.getStoreProtocol():com.sun.mail.imap.protocol.IMAPProtocol");
    }

    public Folder[] getUserNamespaces(String str) throws MessagingException {
        Namespaces namespaces2 = getNamespaces();
        return (namespaces2 == null || namespaces2.otherUsers == null) ? super.getUserNamespaces(str) : namespaceToFolders(namespaces2.otherUsers, str);
    }

    public void handleResponse(Response response) {
        if (response.isOK() || response.isNO() || response.isBAD() || response.isBYE()) {
            handleResponseCode(response);
        }
        if (response.isBYE()) {
            if (this.debug) {
                this.out.println("DEBUG: IMAPStore connection dead");
            }
            if (this.connected) {
                cleanup(response.isSynthetic());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void handleResponseCode(Response response) {
        String rest = response.getRest();
        boolean z = false;
        if (rest.startsWith("[")) {
            int indexOf = rest.indexOf(93);
            if (indexOf > 0 && rest.substring(0, indexOf + 1).equalsIgnoreCase("[ALERT]")) {
                z = true;
            }
            rest = rest.substring(indexOf + 1).trim();
        }
        if (z) {
            notifyStoreListeners(1, rest);
        } else if (response.isUnTagged() && rest.length() > 0) {
            notifyStoreListeners(2, rest);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x001a A[SYNTHETIC, Splitter:B:17:0x001a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean hasCapability(java.lang.String r4) throws javax.mail.MessagingException {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r3.getStoreProtocol()     // Catch:{ ProtocolException -> 0x0017 }
            boolean r4 = r1.hasCapability(r4)     // Catch:{ ProtocolException -> 0x0012, all -> 0x000f }
            r3.releaseStoreProtocol(r1)     // Catch:{ all -> 0x002b }
            monitor-exit(r3)
            return r4
        L_0x000f:
            r4 = move-exception
            r0 = r1
            goto L_0x0027
        L_0x0012:
            r4 = move-exception
            r0 = r1
            goto L_0x0018
        L_0x0015:
            r4 = move-exception
            goto L_0x0027
        L_0x0017:
            r4 = move-exception
        L_0x0018:
            if (r0 != 0) goto L_0x001d
            r3.cleanup()     // Catch:{ all -> 0x0015 }
        L_0x001d:
            javax.mail.MessagingException r1 = new javax.mail.MessagingException     // Catch:{ all -> 0x0015 }
            java.lang.String r2 = r4.getMessage()     // Catch:{ all -> 0x0015 }
            r1.<init>(r2, r4)     // Catch:{ all -> 0x0015 }
            throw r1     // Catch:{ all -> 0x0015 }
        L_0x0027:
            r3.releaseStoreProtocol(r0)     // Catch:{ all -> 0x002b }
            throw r4     // Catch:{ all -> 0x002b }
        L_0x002b:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.hasCapability(java.lang.String):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean hasSeparateStoreConnection() {
        return this.pool.separateStoreConnection;
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public void idle() throws javax.mail.MessagingException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.checkConnected()     // Catch:{ all -> 0x00da }
            monitor-exit(r5)     // Catch:{ all -> 0x00da }
            r0 = 0
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r5.pool     // Catch:{ BadCommandException -> 0x00ba, ConnectionException -> 0x00ae, ProtocolException -> 0x00a2, all -> 0x009f }
            monitor-enter(r1)     // Catch:{ BadCommandException -> 0x00ba, ConnectionException -> 0x00ae, ProtocolException -> 0x00a2, all -> 0x009f }
            com.sun.mail.imap.protocol.IMAPProtocol r2 = r5.getStoreProtocol()     // Catch:{ all -> 0x0095 }
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r5.pool     // Catch:{ all -> 0x0093 }
            int r3 = r3.idleState     // Catch:{ all -> 0x0093 }
            if (r3 != 0) goto L_0x0078
            r2.idleStart()     // Catch:{ all -> 0x0093 }
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r5.pool     // Catch:{ all -> 0x0093 }
            r4 = 1
            r3.idleState = r4     // Catch:{ all -> 0x0093 }
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r5.pool     // Catch:{ all -> 0x0093 }
            r3.idleProtocol = r2     // Catch:{ all -> 0x0093 }
            monitor-exit(r1)     // Catch:{ all -> 0x0093 }
        L_0x0024:
            com.sun.mail.iap.Response r1 = r2.readIdleResponse()     // Catch:{ BadCommandException -> 0x009d, ConnectionException -> 0x009b, ProtocolException -> 0x0099 }
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r5.pool     // Catch:{ BadCommandException -> 0x009d, ConnectionException -> 0x009b, ProtocolException -> 0x0099 }
            monitor-enter(r3)     // Catch:{ BadCommandException -> 0x009d, ConnectionException -> 0x009b, ProtocolException -> 0x0099 }
            if (r1 == 0) goto L_0x004b
            boolean r4 = r2.processIdleResponse(r1)     // Catch:{ all -> 0x0049 }
            if (r4 != 0) goto L_0x0034
            goto L_0x004b
        L_0x0034:
            monitor-exit(r3)     // Catch:{ all -> 0x0049 }
            boolean r3 = r5.enableImapEvents     // Catch:{ BadCommandException -> 0x009d, ConnectionException -> 0x009b, ProtocolException -> 0x0099 }
            if (r3 == 0) goto L_0x0024
            boolean r3 = r1.isUnTagged()     // Catch:{ BadCommandException -> 0x009d, ConnectionException -> 0x009b, ProtocolException -> 0x0099 }
            if (r3 == 0) goto L_0x0024
            r3 = 1000(0x3e8, float:1.401E-42)
            java.lang.String r1 = r1.toString()     // Catch:{ BadCommandException -> 0x009d, ConnectionException -> 0x009b, ProtocolException -> 0x0099 }
            r5.notifyStoreListeners(r3, r1)     // Catch:{ BadCommandException -> 0x009d, ConnectionException -> 0x009b, ProtocolException -> 0x0099 }
            goto L_0x0024
        L_0x0049:
            r1 = move-exception
            goto L_0x0076
        L_0x004b:
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r5.pool     // Catch:{ all -> 0x0049 }
            r4 = 0
            r1.idleState = r4     // Catch:{ all -> 0x0049 }
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r5.pool     // Catch:{ all -> 0x0049 }
            r1.notifyAll()     // Catch:{ all -> 0x0049 }
            monitor-exit(r3)     // Catch:{ all -> 0x0049 }
            int r1 = r5.getMinIdleTime()     // Catch:{ BadCommandException -> 0x009d, ConnectionException -> 0x009b, ProtocolException -> 0x0099 }
            if (r1 <= 0) goto L_0x0061
            long r3 = (long) r1
            java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x0061 }
        L_0x0061:
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r5.pool
            monitor-enter(r1)
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r5.pool     // Catch:{ all -> 0x0073 }
            r3.idleProtocol = r0     // Catch:{ all -> 0x0073 }
            monitor-exit(r1)     // Catch:{ all -> 0x0073 }
            r5.releaseStoreProtocol(r2)
            if (r2 != 0) goto L_0x0072
            r5.cleanup()
        L_0x0072:
            return
        L_0x0073:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0073 }
            throw r0
        L_0x0076:
            monitor-exit(r3)     // Catch:{ all -> 0x0049 }
            throw r1     // Catch:{ BadCommandException -> 0x009d, ConnectionException -> 0x009b, ProtocolException -> 0x0099 }
        L_0x0078:
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r5.pool     // Catch:{ InterruptedException -> 0x007d }
            r3.wait()     // Catch:{ InterruptedException -> 0x007d }
        L_0x007d:
            monitor-exit(r1)     // Catch:{ all -> 0x0093 }
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r5.pool
            monitor-enter(r3)
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r5.pool     // Catch:{ all -> 0x0090 }
            r1.idleProtocol = r0     // Catch:{ all -> 0x0090 }
            monitor-exit(r3)     // Catch:{ all -> 0x0090 }
            r5.releaseStoreProtocol(r2)
            if (r2 != 0) goto L_0x008f
            r5.cleanup()
        L_0x008f:
            return
        L_0x0090:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0090 }
            throw r0
        L_0x0093:
            r3 = move-exception
            goto L_0x0097
        L_0x0095:
            r3 = move-exception
            r2 = r0
        L_0x0097:
            monitor-exit(r1)     // Catch:{ all -> 0x0093 }
            throw r3     // Catch:{ BadCommandException -> 0x009d, ConnectionException -> 0x009b, ProtocolException -> 0x0099 }
        L_0x0099:
            r1 = move-exception
            goto L_0x00a4
        L_0x009b:
            r1 = move-exception
            goto L_0x00b0
        L_0x009d:
            r1 = move-exception
            goto L_0x00bc
        L_0x009f:
            r1 = move-exception
            r2 = r0
            goto L_0x00c5
        L_0x00a2:
            r1 = move-exception
            r2 = r0
        L_0x00a4:
            javax.mail.MessagingException r3 = new javax.mail.MessagingException     // Catch:{ all -> 0x00c4 }
            java.lang.String r4 = r1.getMessage()     // Catch:{ all -> 0x00c4 }
            r3.<init>(r4, r1)     // Catch:{ all -> 0x00c4 }
            throw r3     // Catch:{ all -> 0x00c4 }
        L_0x00ae:
            r1 = move-exception
            r2 = r0
        L_0x00b0:
            javax.mail.StoreClosedException r3 = new javax.mail.StoreClosedException     // Catch:{ all -> 0x00c4 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x00c4 }
            r3.<init>(r5, r1)     // Catch:{ all -> 0x00c4 }
            throw r3     // Catch:{ all -> 0x00c4 }
        L_0x00ba:
            r1 = move-exception
            r2 = r0
        L_0x00bc:
            javax.mail.MessagingException r3 = new javax.mail.MessagingException     // Catch:{ all -> 0x00c4 }
            java.lang.String r4 = "IDLE not supported"
            r3.<init>(r4, r1)     // Catch:{ all -> 0x00c4 }
            throw r3     // Catch:{ all -> 0x00c4 }
        L_0x00c4:
            r1 = move-exception
        L_0x00c5:
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r5.pool
            monitor-enter(r3)
            com.sun.mail.imap.IMAPStore$ConnectionPool r4 = r5.pool     // Catch:{ all -> 0x00d7 }
            r4.idleProtocol = r0     // Catch:{ all -> 0x00d7 }
            monitor-exit(r3)     // Catch:{ all -> 0x00d7 }
            r5.releaseStoreProtocol(r2)
            if (r2 != 0) goto L_0x00d6
            r5.cleanup()
        L_0x00d6:
            throw r1
        L_0x00d7:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00d7 }
            throw r0
        L_0x00da:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00da }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.idle():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0022 A[SYNTHETIC, Splitter:B:21:0x0022] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean isConnected() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.connected     // Catch:{ all -> 0x0033 }
            if (r0 != 0) goto L_0x000b
            r0 = 0
            super.setConnected(r0)     // Catch:{ all -> 0x0033 }
            monitor-exit(r3)
            return r0
        L_0x000b:
            r0 = 0
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r3.getStoreProtocol()     // Catch:{ ProtocolException -> 0x0020 }
            r1.noop()     // Catch:{ ProtocolException -> 0x001c, all -> 0x0017 }
            r3.releaseStoreProtocol(r1)     // Catch:{ all -> 0x0033 }
            goto L_0x002d
        L_0x0017:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
            goto L_0x0026
        L_0x001c:
            r0 = r1
            goto L_0x0020
        L_0x001e:
            r1 = move-exception
            goto L_0x0026
        L_0x0020:
            if (r0 != 0) goto L_0x002a
            r3.cleanup()     // Catch:{ all -> 0x001e }
            goto L_0x002a
        L_0x0026:
            r3.releaseStoreProtocol(r0)     // Catch:{ all -> 0x0033 }
            throw r1     // Catch:{ all -> 0x0033 }
        L_0x002a:
            r3.releaseStoreProtocol(r0)     // Catch:{ all -> 0x0033 }
        L_0x002d:
            boolean r0 = super.isConnected()     // Catch:{ all -> 0x0033 }
            monitor-exit(r3)
            return r0
        L_0x0033:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.isConnected():boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean isConnectionPoolFull() {
        boolean z;
        synchronized (this.pool) {
            if (this.pool.debug) {
                PrintStream printStream = this.out;
                printStream.println("DEBUG: current size: " + this.pool.authenticatedConnections.size() + "   pool size: " + this.pool.poolSize);
            }
            z = this.pool.authenticatedConnections.size() >= this.pool.poolSize;
        }
        return z;
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
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    protected synchronized boolean protocolConnect(java.lang.String r11, int r12, java.lang.String r13, java.lang.String r14) throws javax.mail.MessagingException {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 0
            if (r11 == 0) goto L_0x00df
            if (r14 == 0) goto L_0x00df
            if (r13 != 0) goto L_0x000a
            goto L_0x00df
        L_0x000a:
            r1 = -1
            if (r12 == r1) goto L_0x0010
        L_0x000d:
            r10.port = r12     // Catch:{ all -> 0x0110 }
            goto L_0x0032
        L_0x0010:
            javax.mail.Session r12 = r10.session     // Catch:{ all -> 0x0110 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = "mail."
            r2.<init>(r3)     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = r10.name     // Catch:{ all -> 0x0110 }
            r2.append(r3)     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = ".port"
            r2.append(r3)     // Catch:{ all -> 0x0110 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0110 }
            java.lang.String r12 = r12.getProperty(r2)     // Catch:{ all -> 0x0110 }
            if (r12 == 0) goto L_0x0032
            int r12 = java.lang.Integer.parseInt(r12)     // Catch:{ all -> 0x0110 }
            goto L_0x000d
        L_0x0032:
            int r12 = r10.port     // Catch:{ all -> 0x0110 }
            if (r12 != r1) goto L_0x003a
            int r12 = r10.defaultPort     // Catch:{ all -> 0x0110 }
            r10.port = r12     // Catch:{ all -> 0x0110 }
        L_0x003a:
            com.sun.mail.imap.IMAPStore$ConnectionPool r12 = r10.pool     // Catch:{ CommandFailedException -> 0x00ca, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            monitor-enter(r12)     // Catch:{ CommandFailedException -> 0x00ca, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r10.pool     // Catch:{ all -> 0x00b1 }
            java.util.Vector r1 = r1.authenticatedConnections     // Catch:{ all -> 0x00b1 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00b1 }
            monitor-exit(r12)     // Catch:{ all -> 0x00b1 }
            if (r1 == 0) goto L_0x00ac
            com.sun.mail.imap.protocol.IMAPProtocol r12 = new com.sun.mail.imap.protocol.IMAPProtocol     // Catch:{ CommandFailedException -> 0x00ca, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            java.lang.String r3 = r10.name     // Catch:{ CommandFailedException -> 0x00ca, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            int r5 = r10.port     // Catch:{ CommandFailedException -> 0x00ca, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            javax.mail.Session r1 = r10.session     // Catch:{ CommandFailedException -> 0x00ca, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            boolean r6 = r1.getDebug()     // Catch:{ CommandFailedException -> 0x00ca, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            javax.mail.Session r1 = r10.session     // Catch:{ CommandFailedException -> 0x00ca, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            java.io.PrintStream r7 = r1.getDebugOut()     // Catch:{ CommandFailedException -> 0x00ca, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            javax.mail.Session r1 = r10.session     // Catch:{ CommandFailedException -> 0x00ca, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            java.util.Properties r8 = r1.getProperties()     // Catch:{ CommandFailedException -> 0x00ca, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            boolean r9 = r10.isSSL     // Catch:{ CommandFailedException -> 0x00ca, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            r2 = r12
            r4 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ CommandFailedException -> 0x00ca, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            boolean r0 = r10.debug     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            if (r0 == 0) goto L_0x008d
            java.io.PrintStream r0 = r10.out     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            java.lang.String r2 = "DEBUG: protocolConnect login, host="
            r1.<init>(r2)     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            r1.append(r11)     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            java.lang.String r2 = ", user="
            r1.append(r2)     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            r1.append(r13)     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            java.lang.String r2 = ", password=<non-null>"
            r1.append(r2)     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            java.lang.String r1 = r1.toString()     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            r0.println(r1)     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
        L_0x008d:
            r10.login(r12, r13, r14)     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            r12.addResponseHandler(r10)     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            r10.host = r11     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            r10.user = r13     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            r10.password = r14     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            com.sun.mail.imap.IMAPStore$ConnectionPool r11 = r10.pool     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            monitor-enter(r11)     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
            com.sun.mail.imap.IMAPStore$ConnectionPool r13 = r10.pool     // Catch:{ all -> 0x00a7 }
            java.util.Vector r13 = r13.authenticatedConnections     // Catch:{ all -> 0x00a7 }
            r13.addElement(r12)     // Catch:{ all -> 0x00a7 }
            monitor-exit(r11)     // Catch:{ all -> 0x00a7 }
            goto L_0x00ac
        L_0x00a7:
            r13 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x00a7 }
            throw r13     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
        L_0x00aa:
            r11 = move-exception
            goto L_0x00cc
        L_0x00ac:
            r11 = 1
            r10.connected = r11     // Catch:{ all -> 0x0110 }
            monitor-exit(r10)
            return r11
        L_0x00b1:
            r11 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x00b1 }
            throw r11     // Catch:{ CommandFailedException -> 0x00ca, ProtocolException -> 0x00bf, IOException -> 0x00b4 }
        L_0x00b4:
            r11 = move-exception
            javax.mail.MessagingException r12 = new javax.mail.MessagingException     // Catch:{ all -> 0x0110 }
            java.lang.String r13 = r11.getMessage()     // Catch:{ all -> 0x0110 }
            r12.<init>(r13, r11)     // Catch:{ all -> 0x0110 }
            throw r12     // Catch:{ all -> 0x0110 }
        L_0x00bf:
            r11 = move-exception
            javax.mail.MessagingException r12 = new javax.mail.MessagingException     // Catch:{ all -> 0x0110 }
            java.lang.String r13 = r11.getMessage()     // Catch:{ all -> 0x0110 }
            r12.<init>(r13, r11)     // Catch:{ all -> 0x0110 }
            throw r12     // Catch:{ all -> 0x0110 }
        L_0x00ca:
            r11 = move-exception
            r12 = r0
        L_0x00cc:
            if (r12 == 0) goto L_0x00d1
            r12.disconnect()     // Catch:{ all -> 0x0110 }
        L_0x00d1:
            javax.mail.AuthenticationFailedException r12 = new javax.mail.AuthenticationFailedException     // Catch:{ all -> 0x0110 }
            com.sun.mail.iap.Response r11 = r11.getResponse()     // Catch:{ all -> 0x0110 }
            java.lang.String r11 = r11.getRest()     // Catch:{ all -> 0x0110 }
            r12.<init>(r11)     // Catch:{ all -> 0x0110 }
            throw r12     // Catch:{ all -> 0x0110 }
        L_0x00df:
            boolean r12 = r10.debug     // Catch:{ all -> 0x0110 }
            if (r12 == 0) goto L_0x010d
            java.io.PrintStream r12 = r10.out     // Catch:{ all -> 0x0110 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0110 }
            java.lang.String r1 = "DEBUG: protocolConnect returning false, host="
            r0.<init>(r1)     // Catch:{ all -> 0x0110 }
            r0.append(r11)     // Catch:{ all -> 0x0110 }
            java.lang.String r11 = ", user="
            r0.append(r11)     // Catch:{ all -> 0x0110 }
            r0.append(r13)     // Catch:{ all -> 0x0110 }
            java.lang.String r11 = ", password="
            r0.append(r11)     // Catch:{ all -> 0x0110 }
            if (r14 == 0) goto L_0x0101
            java.lang.String r11 = "<non-null>"
            goto L_0x0103
        L_0x0101:
            java.lang.String r11 = "<null>"
        L_0x0103:
            r0.append(r11)     // Catch:{ all -> 0x0110 }
            java.lang.String r11 = r0.toString()     // Catch:{ all -> 0x0110 }
            r12.println(r11)     // Catch:{ all -> 0x0110 }
        L_0x010d:
            r11 = 0
            monitor-exit(r10)
            return r11
        L_0x0110:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.protocolConnect(java.lang.String, int, java.lang.String, java.lang.String):boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:(3:3|4|(2:6|(1:8))(4:9|(1:11)|12|13))|15|16|(1:18)|19|20) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x004a */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void releaseProtocol(com.sun.mail.imap.IMAPFolder r4, com.sun.mail.imap.protocol.IMAPProtocol r5) {
        /*
            r3 = this;
            com.sun.mail.imap.IMAPStore$ConnectionPool r0 = r3.pool
            monitor-enter(r0)
            if (r5 == 0) goto L_0x004a
            boolean r1 = r3.isConnectionPoolFull()     // Catch:{ all -> 0x0048 }
            if (r1 != 0) goto L_0x0039
            r5.addResponseHandler(r3)     // Catch:{ all -> 0x0048 }
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r3.pool     // Catch:{ all -> 0x0048 }
            java.util.Vector r1 = r1.authenticatedConnections     // Catch:{ all -> 0x0048 }
            r1.addElement(r5)     // Catch:{ all -> 0x0048 }
            boolean r5 = r3.debug     // Catch:{ all -> 0x0048 }
            if (r5 == 0) goto L_0x004a
            java.io.PrintStream r5 = r3.out     // Catch:{ all -> 0x0048 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0048 }
            java.lang.String r2 = "DEBUG: added an Authenticated connection -- size: "
            r1.<init>(r2)     // Catch:{ all -> 0x0048 }
            com.sun.mail.imap.IMAPStore$ConnectionPool r2 = r3.pool     // Catch:{ all -> 0x0048 }
            java.util.Vector r2 = r2.authenticatedConnections     // Catch:{ all -> 0x0048 }
            int r2 = r2.size()     // Catch:{ all -> 0x0048 }
            r1.append(r2)     // Catch:{ all -> 0x0048 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0048 }
            r5.println(r1)     // Catch:{ all -> 0x0048 }
            goto L_0x004a
        L_0x0039:
            boolean r1 = r3.debug     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x0044
            java.io.PrintStream r1 = r3.out     // Catch:{ all -> 0x0048 }
            java.lang.String r2 = "DEBUG: pool is full, not adding an Authenticated connection"
            r1.println(r2)     // Catch:{ all -> 0x0048 }
        L_0x0044:
            r5.logout()     // Catch:{ ProtocolException -> 0x004a }
            goto L_0x004a
        L_0x0048:
            r4 = move-exception
            goto L_0x0060
        L_0x004a:
            com.sun.mail.imap.IMAPStore$ConnectionPool r5 = r3.pool     // Catch:{ all -> 0x0048 }
            java.util.Vector r5 = r5.folders     // Catch:{ all -> 0x0048 }
            if (r5 == 0) goto L_0x005b
            com.sun.mail.imap.IMAPStore$ConnectionPool r5 = r3.pool     // Catch:{ all -> 0x0048 }
            java.util.Vector r5 = r5.folders     // Catch:{ all -> 0x0048 }
            r5.removeElement(r4)     // Catch:{ all -> 0x0048 }
        L_0x005b:
            r3.timeoutConnections()     // Catch:{ all -> 0x0048 }
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x0060:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.releaseProtocol(com.sun.mail.imap.IMAPFolder, com.sun.mail.imap.protocol.IMAPProtocol):void");
    }

    /* access modifiers changed from: package-private */
    public void releaseStoreProtocol(IMAPProtocol iMAPProtocol) {
        if (iMAPProtocol != null) {
            synchronized (this.pool) {
                this.pool.storeConnectionInUse = false;
                this.pool.notifyAll();
                if (this.pool.debug) {
                    this.out.println("DEBUG: releaseStoreProtocol()");
                }
                timeoutConnections();
            }
        }
    }

    public synchronized void setPassword(String str) {
        this.password = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setQuota(javax.mail.Quota r4) throws javax.mail.MessagingException {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.checkConnected()     // Catch:{ all -> 0x004c }
            r0 = 0
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r3.getStoreProtocol()     // Catch:{ BadCommandException -> 0x003a, ConnectionException -> 0x002f, ProtocolException -> 0x0024 }
            r1.setQuota(r4)     // Catch:{ BadCommandException -> 0x001f, ConnectionException -> 0x001c, ProtocolException -> 0x0019, all -> 0x0016 }
            r3.releaseStoreProtocol(r1)     // Catch:{ all -> 0x004c }
            if (r1 != 0) goto L_0x0014
            r3.cleanup()     // Catch:{ all -> 0x004c }
        L_0x0014:
            monitor-exit(r3)
            return
        L_0x0016:
            r4 = move-exception
            r0 = r1
            goto L_0x0043
        L_0x0019:
            r4 = move-exception
            r0 = r1
            goto L_0x0025
        L_0x001c:
            r4 = move-exception
            r0 = r1
            goto L_0x0030
        L_0x001f:
            r4 = move-exception
            r0 = r1
            goto L_0x003b
        L_0x0022:
            r4 = move-exception
            goto L_0x0043
        L_0x0024:
            r4 = move-exception
        L_0x0025:
            javax.mail.MessagingException r1 = new javax.mail.MessagingException     // Catch:{ all -> 0x0022 }
            java.lang.String r2 = r4.getMessage()     // Catch:{ all -> 0x0022 }
            r1.<init>(r2, r4)     // Catch:{ all -> 0x0022 }
            throw r1     // Catch:{ all -> 0x0022 }
        L_0x002f:
            r4 = move-exception
        L_0x0030:
            javax.mail.StoreClosedException r1 = new javax.mail.StoreClosedException     // Catch:{ all -> 0x0022 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0022 }
            r1.<init>(r3, r4)     // Catch:{ all -> 0x0022 }
            throw r1     // Catch:{ all -> 0x0022 }
        L_0x003a:
            r4 = move-exception
        L_0x003b:
            javax.mail.MessagingException r1 = new javax.mail.MessagingException     // Catch:{ all -> 0x0022 }
            java.lang.String r2 = "QUOTA not supported"
            r1.<init>(r2, r4)     // Catch:{ all -> 0x0022 }
            throw r1     // Catch:{ all -> 0x0022 }
        L_0x0043:
            r3.releaseStoreProtocol(r0)     // Catch:{ all -> 0x004c }
            if (r0 != 0) goto L_0x004b
            r3.cleanup()     // Catch:{ all -> 0x004c }
        L_0x004b:
            throw r4     // Catch:{ all -> 0x004c }
        L_0x004c:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.setQuota(javax.mail.Quota):void");
    }

    public synchronized void setUsername(String str) {
        this.user = str;
    }
}
