package com.sun.mail.pop3;

import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import javax.mail.AuthenticationFailedException;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;

public class POP3Store extends Store {
    private int defaultPort;
    boolean disableTop;
    boolean forgetTopHeaders;
    private String host;
    private boolean isSSL;
    Constructor messageConstructor;
    private String name;
    private String passwd;
    private Protocol port;
    private int portNum;
    private POP3Folder portOwner;
    boolean rsetBeforeQuit;
    private String user;

    public POP3Store(Session session, URLName uRLName) {
        this(session, uRLName, "pop3", 110, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r6 = java.lang.Class.forName(r5);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x00db */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public POP3Store(javax.mail.Session r4, javax.mail.URLName r5, java.lang.String r6, int r7, boolean r8) {
        /*
            r3 = this;
            r3.<init>(r4, r5)
            java.lang.String r0 = "pop3"
            r3.name = r0
            r0 = 110(0x6e, float:1.54E-43)
            r3.defaultPort = r0
            r0 = 0
            r3.isSSL = r0
            r1 = 0
            r3.port = r1
            r3.portOwner = r1
            r3.host = r1
            r2 = -1
            r3.portNum = r2
            r3.user = r1
            r3.passwd = r1
            r3.rsetBeforeQuit = r0
            r3.disableTop = r0
            r3.forgetTopHeaders = r0
            r3.messageConstructor = r1
            if (r5 == 0) goto L_0x002a
            java.lang.String r6 = r5.getProtocol()
        L_0x002a:
            r3.name = r6
            r3.defaultPort = r7
            r3.isSSL = r8
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "mail."
            r5.<init>(r7)
            r5.append(r6)
            java.lang.String r7 = ".rsetbeforequit"
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            r7 = 1
            if (r5 == 0) goto L_0x0054
            java.lang.String r8 = "true"
            boolean r5 = r5.equalsIgnoreCase(r8)
            if (r5 == 0) goto L_0x0054
            r3.rsetBeforeQuit = r7
        L_0x0054:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "mail."
            r5.<init>(r8)
            r5.append(r6)
            java.lang.String r8 = ".disabletop"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            if (r5 == 0) goto L_0x0077
            java.lang.String r8 = "true"
            boolean r5 = r5.equalsIgnoreCase(r8)
            if (r5 == 0) goto L_0x0077
            r3.disableTop = r7
        L_0x0077:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "mail."
            r5.<init>(r8)
            r5.append(r6)
            java.lang.String r8 = ".forgettopheaders"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            if (r5 == 0) goto L_0x009a
            java.lang.String r8 = "true"
            boolean r5 = r5.equalsIgnoreCase(r8)
            if (r5 == 0) goto L_0x009a
            r3.forgetTopHeaders = r7
        L_0x009a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "mail."
            r5.<init>(r8)
            r5.append(r6)
            java.lang.String r6 = ".message.class"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            if (r5 == 0) goto L_0x010d
            boolean r6 = r4.getDebug()
            if (r6 == 0) goto L_0x00ce
            java.io.PrintStream r6 = r4.getDebugOut()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r1 = "DEBUG: POP3 message class: "
            r8.<init>(r1)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            r6.println(r8)
        L_0x00ce:
            java.lang.Class r6 = r3.getClass()     // Catch:{ Exception -> 0x00f1 }
            java.lang.ClassLoader r6 = r6.getClassLoader()     // Catch:{ Exception -> 0x00f1 }
            java.lang.Class r6 = r6.loadClass(r5)     // Catch:{ ClassNotFoundException -> 0x00db }
            goto L_0x00df
        L_0x00db:
            java.lang.Class r6 = java.lang.Class.forName(r5)     // Catch:{ Exception -> 0x00f1 }
        L_0x00df:
            r5 = 2
            java.lang.Class[] r5 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x00f1 }
            java.lang.Class<javax.mail.Folder> r8 = javax.mail.Folder.class
            r5[r0] = r8     // Catch:{ Exception -> 0x00f1 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x00f1 }
            r5[r7] = r8     // Catch:{ Exception -> 0x00f1 }
            java.lang.reflect.Constructor r5 = r6.getConstructor(r5)     // Catch:{ Exception -> 0x00f1 }
            r3.messageConstructor = r5     // Catch:{ Exception -> 0x00f1 }
            return
        L_0x00f1:
            r5 = move-exception
            boolean r6 = r4.getDebug()
            if (r6 == 0) goto L_0x010d
            java.io.PrintStream r4 = r4.getDebugOut()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "DEBUG: failed to load POP3 message class: "
            r6.<init>(r7)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            r4.println(r5)
        L_0x010d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.POP3Store.<init>(javax.mail.Session, javax.mail.URLName, java.lang.String, int, boolean):void");
    }

    private void checkConnected() throws MessagingException {
        if (!super.isConnected()) {
            throw new MessagingException("Not connected");
        }
    }

    public synchronized void close() throws MessagingException {
        try {
            if (this.port != null) {
                this.port.quit();
            }
            this.port = null;
            super.close();
        } catch (IOException unused) {
            this.port = null;
            super.close();
        } catch (Throwable th) {
            this.port = null;
            super.close();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void closePort(POP3Folder pOP3Folder) {
        if (this.portOwner == pOP3Folder) {
            this.port = null;
            this.portOwner = null;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        if (this.port != null) {
            close();
        }
    }

    public Folder getDefaultFolder() throws MessagingException {
        checkConnected();
        return new DefaultFolder(this);
    }

    public Folder getFolder(String str) throws MessagingException {
        checkConnected();
        return new POP3Folder(this, str);
    }

    public Folder getFolder(URLName uRLName) throws MessagingException {
        checkConnected();
        return new POP3Folder(this, uRLName.getFile());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0061, code lost:
        return r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x004a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.sun.mail.pop3.Protocol getPort(com.sun.mail.pop3.POP3Folder r10) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            com.sun.mail.pop3.Protocol r0 = r9.port     // Catch:{ all -> 0x0062 }
            if (r0 == 0) goto L_0x000f
            com.sun.mail.pop3.POP3Folder r0 = r9.portOwner     // Catch:{ all -> 0x0062 }
            if (r0 != 0) goto L_0x000f
            r9.portOwner = r10     // Catch:{ all -> 0x0062 }
            com.sun.mail.pop3.Protocol r10 = r9.port     // Catch:{ all -> 0x0062 }
            monitor-exit(r9)
            return r10
        L_0x000f:
            com.sun.mail.pop3.Protocol r8 = new com.sun.mail.pop3.Protocol     // Catch:{ all -> 0x0062 }
            java.lang.String r1 = r9.host     // Catch:{ all -> 0x0062 }
            int r2 = r9.portNum     // Catch:{ all -> 0x0062 }
            javax.mail.Session r0 = r9.session     // Catch:{ all -> 0x0062 }
            boolean r3 = r0.getDebug()     // Catch:{ all -> 0x0062 }
            javax.mail.Session r0 = r9.session     // Catch:{ all -> 0x0062 }
            java.io.PrintStream r4 = r0.getDebugOut()     // Catch:{ all -> 0x0062 }
            javax.mail.Session r0 = r9.session     // Catch:{ all -> 0x0062 }
            java.util.Properties r5 = r0.getProperties()     // Catch:{ all -> 0x0062 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0062 }
            java.lang.String r6 = "mail."
            r0.<init>(r6)     // Catch:{ all -> 0x0062 }
            java.lang.String r6 = r9.name     // Catch:{ all -> 0x0062 }
            r0.append(r6)     // Catch:{ all -> 0x0062 }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x0062 }
            boolean r7 = r9.isSSL     // Catch:{ all -> 0x0062 }
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0062 }
            java.lang.String r0 = r9.user     // Catch:{ all -> 0x0062 }
            java.lang.String r1 = r9.passwd     // Catch:{ all -> 0x0062 }
            java.lang.String r0 = r8.login(r0, r1)     // Catch:{ all -> 0x0062 }
            if (r0 == 0) goto L_0x0050
            r8.quit()     // Catch:{ IOException -> 0x004a }
        L_0x004a:
            java.io.EOFException r10 = new java.io.EOFException     // Catch:{ all -> 0x0062 }
            r10.<init>(r0)     // Catch:{ all -> 0x0062 }
            throw r10     // Catch:{ all -> 0x0062 }
        L_0x0050:
            com.sun.mail.pop3.Protocol r0 = r9.port     // Catch:{ all -> 0x0062 }
            if (r0 != 0) goto L_0x005a
            if (r10 == 0) goto L_0x005a
            r9.port = r8     // Catch:{ all -> 0x0062 }
            r9.portOwner = r10     // Catch:{ all -> 0x0062 }
        L_0x005a:
            com.sun.mail.pop3.POP3Folder r0 = r9.portOwner     // Catch:{ all -> 0x0062 }
            if (r0 != 0) goto L_0x0060
            r9.portOwner = r10     // Catch:{ all -> 0x0062 }
        L_0x0060:
            monitor-exit(r9)
            return r8
        L_0x0062:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.POP3Store.getPort(com.sun.mail.pop3.POP3Folder):com.sun.mail.pop3.Protocol");
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
    public synchronized boolean isConnected() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = super.isConnected()     // Catch:{ all -> 0x002a }
            r1 = 0
            if (r0 != 0) goto L_0x000a
            monitor-exit(r2)
            return r1
        L_0x000a:
            monitor-enter(r2)     // Catch:{ all -> 0x002a }
            com.sun.mail.pop3.Protocol r0 = r2.port     // Catch:{ IOException -> 0x0022 }
            if (r0 != 0) goto L_0x0017
            r0 = 0
            com.sun.mail.pop3.Protocol r0 = r2.getPort(r0)     // Catch:{ IOException -> 0x0022 }
            r2.port = r0     // Catch:{ IOException -> 0x0022 }
            goto L_0x001c
        L_0x0017:
            com.sun.mail.pop3.Protocol r0 = r2.port     // Catch:{ IOException -> 0x0022 }
            r0.noop()     // Catch:{ IOException -> 0x0022 }
        L_0x001c:
            monitor-exit(r2)     // Catch:{ all -> 0x0020 }
            r0 = 1
            monitor-exit(r2)
            return r0
        L_0x0020:
            r0 = move-exception
            goto L_0x0028
        L_0x0022:
            super.close()     // Catch:{ MessagingException -> 0x0025 }
        L_0x0025:
            monitor-exit(r2)     // Catch:{ all -> 0x0020 }
            monitor-exit(r2)
            return r1
        L_0x0028:
            monitor-exit(r2)     // Catch:{ all -> 0x0020 }
            throw r0     // Catch:{ all -> 0x002a }
        L_0x002a:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.POP3Store.isConnected():boolean");
    }

    /* access modifiers changed from: protected */
    public synchronized boolean protocolConnect(String str, int i, String str2, String str3) throws MessagingException {
        boolean z;
        if (str == null || str3 == null || str2 == null) {
            z = false;
        } else {
            if (i == -1) {
                try {
                    Session session = this.session;
                    String property = session.getProperty("mail." + this.name + ".port");
                    if (property != null) {
                        i = Integer.parseInt(property);
                    }
                } catch (EOFException e) {
                    throw new AuthenticationFailedException(e.getMessage());
                } catch (IOException e2) {
                    throw new MessagingException("Connect failed", e2);
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (i == -1) {
                i = this.defaultPort;
            }
            this.host = str;
            this.portNum = i;
            this.user = str2;
            this.passwd = str3;
            this.port = getPort((POP3Folder) null);
            z = true;
        }
        return z;
    }
}
