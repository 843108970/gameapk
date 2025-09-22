package javax.mail;

import android.support.v4.app.NotificationCompat;
import com.sun.mail.util.LineInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.mail.Provider;

public final class Session {
    private static Session defaultSession;
    /* access modifiers changed from: private */
    public final Properties addressMap = new Properties();
    private final Hashtable authTable = new Hashtable();
    private final Authenticator authenticator;
    private boolean debug = false;
    private PrintStream out;
    private final Properties props;
    private final Vector providers = new Vector();
    private final Hashtable providersByClassName = new Hashtable();
    private final Hashtable providersByProtocol = new Hashtable();

    private Session(Properties properties, Authenticator authenticator2) {
        this.props = properties;
        this.authenticator = authenticator2;
        if (Boolean.valueOf(properties.getProperty("mail.debug")).booleanValue()) {
            this.debug = true;
        }
        if (this.debug) {
            pr("DEBUG: JavaMail version 1.4.1");
        }
        Class<?> cls = authenticator2 != null ? authenticator2.getClass() : getClass();
        loadProviders(cls);
        loadAddressMap(cls);
    }

    private static ClassLoader getContextClassLoader() {
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                try {
                    return Thread.currentThread().getContextClassLoader();
                } catch (SecurityException unused) {
                    return null;
                }
            }
        });
    }

    public static Session getDefaultInstance(Properties properties) {
        return getDefaultInstance(properties, (Authenticator) null);
    }

    public static synchronized Session getDefaultInstance(Properties properties, Authenticator authenticator2) {
        Session session;
        synchronized (Session.class) {
            if (defaultSession == null) {
                defaultSession = new Session(properties, authenticator2);
            } else if (defaultSession.authenticator != authenticator2 && (defaultSession.authenticator == null || authenticator2 == null || defaultSession.authenticator.getClass().getClassLoader() != authenticator2.getClass().getClassLoader())) {
                throw new SecurityException("Access to default session denied");
            }
            session = defaultSession;
        }
        return session;
    }

    public static Session getInstance(Properties properties) {
        return new Session(properties, (Authenticator) null);
    }

    public static Session getInstance(Properties properties, Authenticator authenticator2) {
        return new Session(properties, authenticator2);
    }

    private static InputStream getResourceAsStream(final Class cls, final String str) throws IOException {
        try {
            return (InputStream) AccessController.doPrivileged(new PrivilegedExceptionAction() {
                public Object run() throws IOException {
                    return cls.getResourceAsStream(str);
                }
            });
        } catch (PrivilegedActionException e) {
            throw ((IOException) e.getException());
        }
    }

    private static URL[] getResources(final ClassLoader classLoader, final String str) {
        return (URL[]) AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                try {
                    Vector vector = new Vector();
                    Enumeration<URL> resources = classLoader.getResources(str);
                    while (true) {
                        if (resources == null) {
                            break;
                        } else if (!resources.hasMoreElements()) {
                            break;
                        } else {
                            URL nextElement = resources.nextElement();
                            if (nextElement != null) {
                                vector.addElement(nextElement);
                            }
                        }
                    }
                    if (vector.size() <= 0) {
                        return null;
                    }
                    URL[] urlArr = new URL[vector.size()];
                    try {
                        vector.copyInto(urlArr);
                    } catch (IOException | SecurityException unused) {
                    }
                    return urlArr;
                } catch (IOException | SecurityException unused2) {
                    return null;
                }
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r1 = java.lang.Class.forName(r8.getClassName());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0084, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0087, code lost:
        if (r7.debug != false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0089, code lost:
        r9.printStackTrace(getDebugOut());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0099, code lost:
        throw new javax.mail.NoSuchProviderException(r8.getProtocol());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object getService(javax.mail.Provider r8, javax.mail.URLName r9) throws javax.mail.NoSuchProviderException {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x000a
            javax.mail.NoSuchProviderException r8 = new javax.mail.NoSuchProviderException
            java.lang.String r9 = "null"
            r8.<init>(r9)
            throw r8
        L_0x000a:
            if (r9 != 0) goto L_0x001b
            javax.mail.URLName r9 = new javax.mail.URLName
            java.lang.String r1 = r8.getProtocol()
            r2 = 0
            r3 = -1
            r4 = 0
            r5 = 0
            r6 = 0
            r0 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6)
        L_0x001b:
            javax.mail.Authenticator r0 = r7.authenticator
            if (r0 == 0) goto L_0x002a
            javax.mail.Authenticator r0 = r7.authenticator
            java.lang.Class r0 = r0.getClass()
        L_0x0025:
            java.lang.ClassLoader r0 = r0.getClassLoader()
            goto L_0x002f
        L_0x002a:
            java.lang.Class r0 = r7.getClass()
            goto L_0x0025
        L_0x002f:
            r1 = 0
            java.lang.ClassLoader r2 = getContextClassLoader()     // Catch:{ Exception -> 0x004a }
            if (r2 == 0) goto L_0x003f
            java.lang.String r3 = r8.getClassName()     // Catch:{ ClassNotFoundException -> 0x003f }
            java.lang.Class r2 = r2.loadClass(r3)     // Catch:{ ClassNotFoundException -> 0x003f }
            r1 = r2
        L_0x003f:
            if (r1 != 0) goto L_0x0052
            java.lang.String r1 = r8.getClassName()     // Catch:{ Exception -> 0x004a }
            java.lang.Class r1 = r0.loadClass(r1)     // Catch:{ Exception -> 0x004a }
            goto L_0x0052
        L_0x004a:
            java.lang.String r0 = r8.getClassName()     // Catch:{ Exception -> 0x0084 }
            java.lang.Class r1 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0084 }
        L_0x0052:
            r0 = 2
            java.lang.Class[] r2 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x006e }
            java.lang.Class<javax.mail.Session> r3 = javax.mail.Session.class
            r4 = 0
            r2[r4] = r3     // Catch:{ Exception -> 0x006e }
            java.lang.Class<javax.mail.URLName> r3 = javax.mail.URLName.class
            r5 = 1
            r2[r5] = r3     // Catch:{ Exception -> 0x006e }
            java.lang.reflect.Constructor r1 = r1.getConstructor(r2)     // Catch:{ Exception -> 0x006e }
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x006e }
            r0[r4] = r7     // Catch:{ Exception -> 0x006e }
            r0[r5] = r9     // Catch:{ Exception -> 0x006e }
            java.lang.Object r9 = r1.newInstance(r0)     // Catch:{ Exception -> 0x006e }
            return r9
        L_0x006e:
            r9 = move-exception
            boolean r0 = r7.debug
            if (r0 == 0) goto L_0x007a
            java.io.PrintStream r0 = r7.getDebugOut()
            r9.printStackTrace(r0)
        L_0x007a:
            javax.mail.NoSuchProviderException r9 = new javax.mail.NoSuchProviderException
            java.lang.String r8 = r8.getProtocol()
            r9.<init>(r8)
            throw r9
        L_0x0084:
            r9 = move-exception
            boolean r0 = r7.debug
            if (r0 == 0) goto L_0x0090
            java.io.PrintStream r0 = r7.getDebugOut()
            r9.printStackTrace(r0)
        L_0x0090:
            javax.mail.NoSuchProviderException r9 = new javax.mail.NoSuchProviderException
            java.lang.String r8 = r8.getProtocol()
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.Session.getService(javax.mail.Provider, javax.mail.URLName):java.lang.Object");
    }

    private Store getStore(Provider provider, URLName uRLName) throws NoSuchProviderException {
        if (provider == null || provider.getType() != Provider.Type.STORE) {
            throw new NoSuchProviderException("invalid provider");
        }
        try {
            return (Store) getService(provider, uRLName);
        } catch (ClassCastException unused) {
            throw new NoSuchProviderException("incorrect class");
        }
    }

    private static URL[] getSystemResources(final String str) {
        return (URL[]) AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                try {
                    Vector vector = new Vector();
                    Enumeration<URL> systemResources = ClassLoader.getSystemResources(str);
                    while (true) {
                        if (systemResources == null) {
                            break;
                        } else if (!systemResources.hasMoreElements()) {
                            break;
                        } else {
                            URL nextElement = systemResources.nextElement();
                            if (nextElement != null) {
                                vector.addElement(nextElement);
                            }
                        }
                    }
                    if (vector.size() <= 0) {
                        return null;
                    }
                    URL[] urlArr = new URL[vector.size()];
                    try {
                        vector.copyInto(urlArr);
                    } catch (IOException | SecurityException unused) {
                    }
                    return urlArr;
                } catch (IOException | SecurityException unused2) {
                    return null;
                }
            }
        });
    }

    private Transport getTransport(Provider provider, URLName uRLName) throws NoSuchProviderException {
        if (provider == null || provider.getType() != Provider.Type.TRANSPORT) {
            throw new NoSuchProviderException("invalid provider");
        }
        try {
            return (Transport) getService(provider, uRLName);
        } catch (ClassCastException unused) {
            throw new NoSuchProviderException("incorrect class");
        }
    }

    private void loadAddressMap(Class cls) {
        AnonymousClass2 r0 = new StreamLoader() {
            public void load(InputStream inputStream) throws IOException {
                Session.this.addressMap.load(inputStream);
            }
        };
        loadResource("/META-INF/javamail.default.address.map", cls, r0);
        loadAllResources("META-INF/javamail.address.map", cls, r0);
        try {
            loadFile(String.valueOf(System.getProperty("java.home")) + File.separator + "lib" + File.separator + "javamail.address.map", r0);
        } catch (SecurityException e) {
            if (this.debug) {
                pr("DEBUG: can't get java.home: " + e);
            }
        }
        if (this.addressMap.isEmpty()) {
            if (this.debug) {
                pr("DEBUG: failed to load address map, using defaults");
            }
            this.addressMap.put("rfc822", "smtp");
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x00cb */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0092 A[Catch:{ all -> 0x008b }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ae A[Catch:{ all -> 0x008b }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c8 A[SYNTHETIC, Splitter:B:65:0x00c8] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00c2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00c2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadAllResources(java.lang.String r8, java.lang.Class r9, javax.mail.StreamLoader r10) {
        /*
            r7 = this;
            r0 = 0
            java.lang.ClassLoader r1 = getContextClassLoader()     // Catch:{ Exception -> 0x00cf }
            if (r1 != 0) goto L_0x000b
            java.lang.ClassLoader r1 = r9.getClassLoader()     // Catch:{ Exception -> 0x00cf }
        L_0x000b:
            if (r1 == 0) goto L_0x0012
            java.net.URL[] r1 = getResources(r1, r8)     // Catch:{ Exception -> 0x00cf }
            goto L_0x0016
        L_0x0012:
            java.net.URL[] r1 = getSystemResources(r8)     // Catch:{ Exception -> 0x00cf }
        L_0x0016:
            if (r1 == 0) goto L_0x00e5
            r2 = 0
        L_0x0019:
            int r3 = r1.length     // Catch:{ Exception -> 0x00cc }
            if (r0 < r3) goto L_0x001f
            r0 = r2
            goto L_0x00e5
        L_0x001f:
            r3 = r1[r0]     // Catch:{ Exception -> 0x00cc }
            r4 = 0
            boolean r5 = r7.debug     // Catch:{ Exception -> 0x00cc }
            if (r5 == 0) goto L_0x0037
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cc }
            java.lang.String r6 = "DEBUG: URL "
            r5.<init>(r6)     // Catch:{ Exception -> 0x00cc }
            r5.append(r3)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00cc }
            r7.pr(r5)     // Catch:{ Exception -> 0x00cc }
        L_0x0037:
            r5 = 1
            java.io.InputStream r6 = openStream(r3)     // Catch:{ IOException -> 0x00a9, SecurityException -> 0x008d }
            if (r6 == 0) goto L_0x0070
            r10.load(r6)     // Catch:{ IOException -> 0x006d, SecurityException -> 0x006a, all -> 0x0067 }
            boolean r2 = r7.debug     // Catch:{ IOException -> 0x0062, SecurityException -> 0x005d, all -> 0x0058 }
            if (r2 == 0) goto L_0x0056
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0062, SecurityException -> 0x005d, all -> 0x0058 }
            java.lang.String r4 = "DEBUG: successfully loaded resource: "
            r2.<init>(r4)     // Catch:{ IOException -> 0x0062, SecurityException -> 0x005d, all -> 0x0058 }
            r2.append(r3)     // Catch:{ IOException -> 0x0062, SecurityException -> 0x005d, all -> 0x0058 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0062, SecurityException -> 0x005d, all -> 0x0058 }
            r7.pr(r2)     // Catch:{ IOException -> 0x0062, SecurityException -> 0x005d, all -> 0x0058 }
        L_0x0056:
            r2 = 1
            goto L_0x0085
        L_0x0058:
            r0 = move-exception
            r4 = r6
            r2 = 1
            goto L_0x00c6
        L_0x005d:
            r2 = move-exception
            r3 = r2
            r4 = r6
            r2 = 1
            goto L_0x008e
        L_0x0062:
            r2 = move-exception
            r3 = r2
            r4 = r6
            r2 = 1
            goto L_0x00aa
        L_0x0067:
            r0 = move-exception
            r4 = r6
            goto L_0x00c6
        L_0x006a:
            r3 = move-exception
            r4 = r6
            goto L_0x008e
        L_0x006d:
            r3 = move-exception
            r4 = r6
            goto L_0x00aa
        L_0x0070:
            boolean r4 = r7.debug     // Catch:{ IOException -> 0x006d, SecurityException -> 0x006a, all -> 0x0067 }
            if (r4 == 0) goto L_0x0085
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x006d, SecurityException -> 0x006a, all -> 0x0067 }
            java.lang.String r5 = "DEBUG: not loading resource: "
            r4.<init>(r5)     // Catch:{ IOException -> 0x006d, SecurityException -> 0x006a, all -> 0x0067 }
            r4.append(r3)     // Catch:{ IOException -> 0x006d, SecurityException -> 0x006a, all -> 0x0067 }
            java.lang.String r3 = r4.toString()     // Catch:{ IOException -> 0x006d, SecurityException -> 0x006a, all -> 0x0067 }
            r7.pr(r3)     // Catch:{ IOException -> 0x006d, SecurityException -> 0x006a, all -> 0x0067 }
        L_0x0085:
            if (r6 == 0) goto L_0x00c2
            r6.close()     // Catch:{ IOException -> 0x00c2 }
            goto L_0x00c2
        L_0x008b:
            r0 = move-exception
            goto L_0x00c6
        L_0x008d:
            r3 = move-exception
        L_0x008e:
            boolean r5 = r7.debug     // Catch:{ all -> 0x008b }
            if (r5 == 0) goto L_0x00a3
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x008b }
            java.lang.String r6 = "DEBUG: "
            r5.<init>(r6)     // Catch:{ all -> 0x008b }
            r5.append(r3)     // Catch:{ all -> 0x008b }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x008b }
            r7.pr(r3)     // Catch:{ all -> 0x008b }
        L_0x00a3:
            if (r4 == 0) goto L_0x00c2
        L_0x00a5:
            r4.close()     // Catch:{ IOException -> 0x00c2 }
            goto L_0x00c2
        L_0x00a9:
            r3 = move-exception
        L_0x00aa:
            boolean r5 = r7.debug     // Catch:{ all -> 0x008b }
            if (r5 == 0) goto L_0x00bf
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x008b }
            java.lang.String r6 = "DEBUG: "
            r5.<init>(r6)     // Catch:{ all -> 0x008b }
            r5.append(r3)     // Catch:{ all -> 0x008b }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x008b }
            r7.pr(r3)     // Catch:{ all -> 0x008b }
        L_0x00bf:
            if (r4 == 0) goto L_0x00c2
            goto L_0x00a5
        L_0x00c2:
            int r0 = r0 + 1
            goto L_0x0019
        L_0x00c6:
            if (r4 == 0) goto L_0x00cb
            r4.close()     // Catch:{ IOException -> 0x00cb }
        L_0x00cb:
            throw r0     // Catch:{ Exception -> 0x00cc }
        L_0x00cc:
            r1 = move-exception
            r0 = r2
            goto L_0x00d0
        L_0x00cf:
            r1 = move-exception
        L_0x00d0:
            boolean r2 = r7.debug
            if (r2 == 0) goto L_0x00e5
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "DEBUG: "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r7.pr(r1)
        L_0x00e5:
            if (r0 != 0) goto L_0x0101
            boolean r0 = r7.debug
            if (r0 == 0) goto L_0x00f0
            java.lang.String r0 = "DEBUG: !anyLoaded"
            r7.pr(r0)
        L_0x00f0:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "/"
            r0.<init>(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r7.loadResource(r8, r9, r10)
        L_0x0101:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.Session.loadAllResources(java.lang.String, java.lang.Class, javax.mail.StreamLoader):void");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0037 A[Catch:{ all -> 0x0030 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b A[SYNTHETIC, Splitter:B:23:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0064 A[Catch:{ all -> 0x0030 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0088 A[SYNTHETIC, Splitter:B:32:0x0088] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008e A[SYNTHETIC, Splitter:B:36:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:27:0x0060=Splitter:B:27:0x0060, B:18:0x0033=Splitter:B:18:0x0033} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadFile(java.lang.String r4, javax.mail.StreamLoader r5) {
        /*
            r3 = this;
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x005f, SecurityException -> 0x0032 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x005f, SecurityException -> 0x0032 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x005f, SecurityException -> 0x0032 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x005f, SecurityException -> 0x0032 }
            r5.load(r1)     // Catch:{ IOException -> 0x002d, SecurityException -> 0x002a, all -> 0x0027 }
            boolean r5 = r3.debug     // Catch:{ IOException -> 0x002d, SecurityException -> 0x002a, all -> 0x0027 }
            if (r5 == 0) goto L_0x0023
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x002d, SecurityException -> 0x002a, all -> 0x0027 }
            java.lang.String r0 = "DEBUG: successfully loaded file: "
            r5.<init>(r0)     // Catch:{ IOException -> 0x002d, SecurityException -> 0x002a, all -> 0x0027 }
            r5.append(r4)     // Catch:{ IOException -> 0x002d, SecurityException -> 0x002a, all -> 0x0027 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x002d, SecurityException -> 0x002a, all -> 0x0027 }
            r3.pr(r5)     // Catch:{ IOException -> 0x002d, SecurityException -> 0x002a, all -> 0x0027 }
        L_0x0023:
            r1.close()     // Catch:{ IOException -> 0x008b }
            return
        L_0x0027:
            r4 = move-exception
            r0 = r1
            goto L_0x008c
        L_0x002a:
            r5 = move-exception
            r0 = r1
            goto L_0x0033
        L_0x002d:
            r5 = move-exception
            r0 = r1
            goto L_0x0060
        L_0x0030:
            r4 = move-exception
            goto L_0x008c
        L_0x0032:
            r5 = move-exception
        L_0x0033:
            boolean r1 = r3.debug     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x0059
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
            java.lang.String r2 = "DEBUG: not loading file: "
            r1.<init>(r2)     // Catch:{ all -> 0x0030 }
            r1.append(r4)     // Catch:{ all -> 0x0030 }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x0030 }
            r3.pr(r4)     // Catch:{ all -> 0x0030 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
            java.lang.String r1 = "DEBUG: "
            r4.<init>(r1)     // Catch:{ all -> 0x0030 }
            r4.append(r5)     // Catch:{ all -> 0x0030 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0030 }
            r3.pr(r4)     // Catch:{ all -> 0x0030 }
        L_0x0059:
            if (r0 == 0) goto L_0x008b
            r0.close()     // Catch:{ IOException -> 0x005e }
        L_0x005e:
            return
        L_0x005f:
            r5 = move-exception
        L_0x0060:
            boolean r1 = r3.debug     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x0086
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
            java.lang.String r2 = "DEBUG: not loading file: "
            r1.<init>(r2)     // Catch:{ all -> 0x0030 }
            r1.append(r4)     // Catch:{ all -> 0x0030 }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x0030 }
            r3.pr(r4)     // Catch:{ all -> 0x0030 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
            java.lang.String r1 = "DEBUG: "
            r4.<init>(r1)     // Catch:{ all -> 0x0030 }
            r4.append(r5)     // Catch:{ all -> 0x0030 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0030 }
            r3.pr(r4)     // Catch:{ all -> 0x0030 }
        L_0x0086:
            if (r0 == 0) goto L_0x008b
            r0.close()     // Catch:{  }
        L_0x008b:
            return
        L_0x008c:
            if (r0 == 0) goto L_0x0091
            r0.close()     // Catch:{ IOException -> 0x0091 }
        L_0x0091:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.Session.loadFile(java.lang.String, javax.mail.StreamLoader):void");
    }

    private void loadProviders(Class cls) {
        AnonymousClass1 r0 = new StreamLoader() {
            public void load(InputStream inputStream) throws IOException {
                Session.this.loadProvidersFromStream(inputStream);
            }
        };
        try {
            loadFile(String.valueOf(System.getProperty("java.home")) + File.separator + "lib" + File.separator + "javamail.providers", r0);
        } catch (SecurityException e) {
            if (this.debug) {
                pr("DEBUG: can't get java.home: " + e);
            }
        }
        loadAllResources("META-INF/javamail.providers", cls, r0);
        loadResource("/META-INF/javamail.default.providers", cls, r0);
        if (this.providers.size() == 0) {
            if (this.debug) {
                pr("DEBUG: failed to load any providers, using defaults");
            }
            addProvider(new Provider(Provider.Type.STORE, "imap", "com.sun.mail.imap.IMAPStore", "Sun Microsystems, Inc.", Version.version));
            addProvider(new Provider(Provider.Type.STORE, "imaps", "com.sun.mail.imap.IMAPSSLStore", "Sun Microsystems, Inc.", Version.version));
            addProvider(new Provider(Provider.Type.STORE, "pop3", "com.sun.mail.pop3.POP3Store", "Sun Microsystems, Inc.", Version.version));
            addProvider(new Provider(Provider.Type.STORE, "pop3s", "com.sun.mail.pop3.POP3SSLStore", "Sun Microsystems, Inc.", Version.version));
            addProvider(new Provider(Provider.Type.TRANSPORT, "smtp", "com.sun.mail.smtp.SMTPTransport", "Sun Microsystems, Inc.", Version.version));
            addProvider(new Provider(Provider.Type.TRANSPORT, "smtps", "com.sun.mail.smtp.SMTPSSLTransport", "Sun Microsystems, Inc.", Version.version));
        }
        if (this.debug) {
            pr("DEBUG: Tables of loaded providers");
            pr("DEBUG: Providers Listed By Class Name: " + this.providersByClassName.toString());
            pr("DEBUG: Providers Listed By Protocol: " + this.providersByProtocol.toString());
        }
    }

    /* access modifiers changed from: private */
    public void loadProvidersFromStream(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            LineInputStream lineInputStream = new LineInputStream(inputStream);
            while (true) {
                String readLine = lineInputStream.readLine();
                if (readLine != null) {
                    if (!readLine.startsWith("#")) {
                        StringTokenizer stringTokenizer = new StringTokenizer(readLine, ";");
                        Provider.Type type = null;
                        String str = null;
                        String str2 = null;
                        String str3 = null;
                        String str4 = null;
                        while (stringTokenizer.hasMoreTokens()) {
                            String trim = stringTokenizer.nextToken().trim();
                            int indexOf = trim.indexOf("=");
                            if (trim.startsWith("protocol=")) {
                                str = trim.substring(indexOf + 1);
                            } else if (trim.startsWith("type=")) {
                                String substring = trim.substring(indexOf + 1);
                                if (substring.equalsIgnoreCase("store")) {
                                    type = Provider.Type.STORE;
                                } else if (substring.equalsIgnoreCase(NotificationCompat.CATEGORY_TRANSPORT)) {
                                    type = Provider.Type.TRANSPORT;
                                }
                            } else if (trim.startsWith("class=")) {
                                str2 = trim.substring(indexOf + 1);
                            } else if (trim.startsWith("vendor=")) {
                                str3 = trim.substring(indexOf + 1);
                            } else if (trim.startsWith("version=")) {
                                str4 = trim.substring(indexOf + 1);
                            }
                        }
                        if (type != null && str != null && str2 != null && str.length() > 0 && str2.length() > 0) {
                            addProvider(new Provider(type, str, str2, str3, str4));
                        } else if (this.debug) {
                            pr("DEBUG: Bad provider entry: " + readLine);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003d A[SYNTHETIC, Splitter:B:19:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0049 A[Catch:{ all -> 0x0041 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005c A[SYNTHETIC, Splitter:B:30:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0065 A[Catch:{ all -> 0x0041 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0078 A[SYNTHETIC, Splitter:B:39:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007e A[SYNTHETIC, Splitter:B:43:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:34:0x0061=Splitter:B:34:0x0061, B:25:0x0045=Splitter:B:25:0x0045} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadResource(java.lang.String r2, java.lang.Class r3, javax.mail.StreamLoader r4) {
        /*
            r1 = this;
            r0 = 0
            java.io.InputStream r3 = getResourceAsStream(r3, r2)     // Catch:{ IOException -> 0x0060, SecurityException -> 0x0044 }
            if (r3 == 0) goto L_0x0028
            r4.load(r3)     // Catch:{ IOException -> 0x0025, SecurityException -> 0x0022, all -> 0x0020 }
            boolean r4 = r1.debug     // Catch:{ IOException -> 0x0025, SecurityException -> 0x0022, all -> 0x0020 }
            if (r4 == 0) goto L_0x003b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0025, SecurityException -> 0x0022, all -> 0x0020 }
            java.lang.String r0 = "DEBUG: successfully loaded resource: "
            r4.<init>(r0)     // Catch:{ IOException -> 0x0025, SecurityException -> 0x0022, all -> 0x0020 }
            r4.append(r2)     // Catch:{ IOException -> 0x0025, SecurityException -> 0x0022, all -> 0x0020 }
            java.lang.String r2 = r4.toString()     // Catch:{ IOException -> 0x0025, SecurityException -> 0x0022, all -> 0x0020 }
        L_0x001c:
            r1.pr(r2)     // Catch:{ IOException -> 0x0025, SecurityException -> 0x0022, all -> 0x0020 }
            goto L_0x003b
        L_0x0020:
            r2 = move-exception
            goto L_0x007c
        L_0x0022:
            r2 = move-exception
            r0 = r3
            goto L_0x0045
        L_0x0025:
            r2 = move-exception
            r0 = r3
            goto L_0x0061
        L_0x0028:
            boolean r4 = r1.debug     // Catch:{ IOException -> 0x0025, SecurityException -> 0x0022, all -> 0x0020 }
            if (r4 == 0) goto L_0x003b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0025, SecurityException -> 0x0022, all -> 0x0020 }
            java.lang.String r0 = "DEBUG: not loading resource: "
            r4.<init>(r0)     // Catch:{ IOException -> 0x0025, SecurityException -> 0x0022, all -> 0x0020 }
            r4.append(r2)     // Catch:{ IOException -> 0x0025, SecurityException -> 0x0022, all -> 0x0020 }
            java.lang.String r2 = r4.toString()     // Catch:{ IOException -> 0x0025, SecurityException -> 0x0022, all -> 0x0020 }
            goto L_0x001c
        L_0x003b:
            if (r3 == 0) goto L_0x007b
            r3.close()     // Catch:{ IOException -> 0x007b }
            return
        L_0x0041:
            r2 = move-exception
            r3 = r0
            goto L_0x007c
        L_0x0044:
            r2 = move-exception
        L_0x0045:
            boolean r3 = r1.debug     // Catch:{ all -> 0x0041 }
            if (r3 == 0) goto L_0x005a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0041 }
            java.lang.String r4 = "DEBUG: "
            r3.<init>(r4)     // Catch:{ all -> 0x0041 }
            r3.append(r2)     // Catch:{ all -> 0x0041 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0041 }
            r1.pr(r2)     // Catch:{ all -> 0x0041 }
        L_0x005a:
            if (r0 == 0) goto L_0x007b
            r0.close()     // Catch:{ IOException -> 0x005f }
        L_0x005f:
            return
        L_0x0060:
            r2 = move-exception
        L_0x0061:
            boolean r3 = r1.debug     // Catch:{ all -> 0x0041 }
            if (r3 == 0) goto L_0x0076
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0041 }
            java.lang.String r4 = "DEBUG: "
            r3.<init>(r4)     // Catch:{ all -> 0x0041 }
            r3.append(r2)     // Catch:{ all -> 0x0041 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0041 }
            r1.pr(r2)     // Catch:{ all -> 0x0041 }
        L_0x0076:
            if (r0 == 0) goto L_0x007b
            r0.close()     // Catch:{  }
        L_0x007b:
            return
        L_0x007c:
            if (r3 == 0) goto L_0x0081
            r3.close()     // Catch:{ IOException -> 0x0081 }
        L_0x0081:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.Session.loadResource(java.lang.String, java.lang.Class, javax.mail.StreamLoader):void");
    }

    private static InputStream openStream(final URL url) throws IOException {
        try {
            return (InputStream) AccessController.doPrivileged(new PrivilegedExceptionAction() {
                public Object run() throws IOException {
                    return url.openStream();
                }
            });
        } catch (PrivilegedActionException e) {
            throw ((IOException) e.getException());
        }
    }

    private void pr(String str) {
        getDebugOut().println(str);
    }

    public final synchronized void addProvider(Provider provider) {
        this.providers.addElement(provider);
        this.providersByClassName.put(provider.getClassName(), provider);
        if (!this.providersByProtocol.containsKey(provider.getProtocol())) {
            this.providersByProtocol.put(provider.getProtocol(), provider);
        }
    }

    public final synchronized boolean getDebug() {
        return this.debug;
    }

    public final synchronized PrintStream getDebugOut() {
        if (this.out == null) {
            return System.out;
        }
        return this.out;
    }

    public final Folder getFolder(URLName uRLName) throws MessagingException {
        Store store = getStore(uRLName);
        store.connect();
        return store.getFolder(uRLName);
    }

    public final PasswordAuthentication getPasswordAuthentication(URLName uRLName) {
        return (PasswordAuthentication) this.authTable.get(uRLName);
    }

    public final Properties getProperties() {
        return this.props;
    }

    public final String getProperty(String str) {
        return this.props.getProperty(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized javax.mail.Provider getProvider(java.lang.String r5) throws javax.mail.NoSuchProviderException {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 == 0) goto L_0x008b
            int r0 = r5.length()     // Catch:{ all -> 0x0089 }
            if (r0 > 0) goto L_0x000b
            goto L_0x008b
        L_0x000b:
            r0 = 0
            java.util.Properties r1 = r4.props     // Catch:{ all -> 0x0089 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0089 }
            java.lang.String r3 = "mail."
            r2.<init>(r3)     // Catch:{ all -> 0x0089 }
            r2.append(r5)     // Catch:{ all -> 0x0089 }
            java.lang.String r3 = ".class"
            r2.append(r3)     // Catch:{ all -> 0x0089 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0089 }
            java.lang.String r1 = r1.getProperty(r2)     // Catch:{ all -> 0x0089 }
            if (r1 == 0) goto L_0x004c
            boolean r0 = r4.debug     // Catch:{ all -> 0x0089 }
            if (r0 == 0) goto L_0x0044
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0089 }
            java.lang.String r2 = "DEBUG: mail."
            r0.<init>(r2)     // Catch:{ all -> 0x0089 }
            r0.append(r5)     // Catch:{ all -> 0x0089 }
            java.lang.String r2 = ".class property exists and points to "
            r0.append(r2)     // Catch:{ all -> 0x0089 }
            r0.append(r1)     // Catch:{ all -> 0x0089 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0089 }
            r4.pr(r0)     // Catch:{ all -> 0x0089 }
        L_0x0044:
            java.util.Hashtable r0 = r4.providersByClassName     // Catch:{ all -> 0x0089 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0089 }
            javax.mail.Provider r0 = (javax.mail.Provider) r0     // Catch:{ all -> 0x0089 }
        L_0x004c:
            if (r0 == 0) goto L_0x0050
            monitor-exit(r4)
            return r0
        L_0x0050:
            java.util.Hashtable r0 = r4.providersByProtocol     // Catch:{ all -> 0x0089 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x0089 }
            javax.mail.Provider r0 = (javax.mail.Provider) r0     // Catch:{ all -> 0x0089 }
            if (r0 != 0) goto L_0x006e
            javax.mail.NoSuchProviderException r0 = new javax.mail.NoSuchProviderException     // Catch:{ all -> 0x0089 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0089 }
            java.lang.String r2 = "No provider for "
            r1.<init>(r2)     // Catch:{ all -> 0x0089 }
            r1.append(r5)     // Catch:{ all -> 0x0089 }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x0089 }
            r0.<init>(r5)     // Catch:{ all -> 0x0089 }
            throw r0     // Catch:{ all -> 0x0089 }
        L_0x006e:
            boolean r5 = r4.debug     // Catch:{ all -> 0x0089 }
            if (r5 == 0) goto L_0x0087
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0089 }
            java.lang.String r1 = "DEBUG: getProvider() returning "
            r5.<init>(r1)     // Catch:{ all -> 0x0089 }
            java.lang.String r1 = r0.toString()     // Catch:{ all -> 0x0089 }
            r5.append(r1)     // Catch:{ all -> 0x0089 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0089 }
            r4.pr(r5)     // Catch:{ all -> 0x0089 }
        L_0x0087:
            monitor-exit(r4)
            return r0
        L_0x0089:
            r5 = move-exception
            goto L_0x0093
        L_0x008b:
            javax.mail.NoSuchProviderException r5 = new javax.mail.NoSuchProviderException     // Catch:{ all -> 0x0089 }
            java.lang.String r0 = "Invalid protocol: null"
            r5.<init>(r0)     // Catch:{ all -> 0x0089 }
            throw r5     // Catch:{ all -> 0x0089 }
        L_0x0093:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.Session.getProvider(java.lang.String):javax.mail.Provider");
    }

    public final synchronized Provider[] getProviders() {
        Provider[] providerArr;
        providerArr = new Provider[this.providers.size()];
        this.providers.copyInto(providerArr);
        return providerArr;
    }

    public final Store getStore() throws NoSuchProviderException {
        return getStore(getProperty("mail.store.protocol"));
    }

    public final Store getStore(String str) throws NoSuchProviderException {
        return getStore(new URLName(str, (String) null, -1, (String) null, (String) null, (String) null));
    }

    public final Store getStore(Provider provider) throws NoSuchProviderException {
        return getStore(provider, (URLName) null);
    }

    public final Store getStore(URLName uRLName) throws NoSuchProviderException {
        return getStore(getProvider(uRLName.getProtocol()), uRLName);
    }

    public final Transport getTransport() throws NoSuchProviderException {
        return getTransport(getProperty("mail.transport.protocol"));
    }

    public final Transport getTransport(String str) throws NoSuchProviderException {
        return getTransport(new URLName(str, (String) null, -1, (String) null, (String) null, (String) null));
    }

    public final Transport getTransport(Address address) throws NoSuchProviderException {
        String str = (String) this.addressMap.get(address.getType());
        if (str != null) {
            return getTransport(str);
        }
        throw new NoSuchProviderException("No provider for Address type: " + address.getType());
    }

    public final Transport getTransport(Provider provider) throws NoSuchProviderException {
        return getTransport(provider, (URLName) null);
    }

    public final Transport getTransport(URLName uRLName) throws NoSuchProviderException {
        return getTransport(getProvider(uRLName.getProtocol()), uRLName);
    }

    public final PasswordAuthentication requestPasswordAuthentication(InetAddress inetAddress, int i, String str, String str2, String str3) {
        if (this.authenticator != null) {
            return this.authenticator.requestPasswordAuthentication(inetAddress, i, str, str2, str3);
        }
        return null;
    }

    public final synchronized void setDebug(boolean z) {
        this.debug = z;
        if (z) {
            pr("DEBUG: setDebug: JavaMail version 1.4.1");
        }
    }

    public final synchronized void setDebugOut(PrintStream printStream) {
        this.out = printStream;
    }

    public final void setPasswordAuthentication(URLName uRLName, PasswordAuthentication passwordAuthentication) {
        if (passwordAuthentication == null) {
            this.authTable.remove(uRLName);
        } else {
            this.authTable.put(uRLName, passwordAuthentication);
        }
    }

    public final synchronized void setProtocolForAddress(String str, String str2) {
        if (str2 == null) {
            this.addressMap.remove(str);
        } else {
            this.addressMap.put(str, str2);
        }
    }

    public final synchronized void setProvider(Provider provider) throws NoSuchProviderException {
        if (provider == null) {
            try {
                throw new NoSuchProviderException("Can't set null provider");
            } catch (Throwable th) {
                throw th;
            }
        } else {
            this.providersByProtocol.put(provider.getProtocol(), provider);
            Properties properties = this.props;
            properties.put("mail." + provider.getProtocol() + ".class", provider.getClassName());
        }
    }
}
