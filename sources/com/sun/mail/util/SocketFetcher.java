package com.sun.mail.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;

public class SocketFetcher {
    private SocketFetcher() {
    }

    private static void configureSSLSocket(Socket socket, Properties properties, String str) {
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            String property = properties.getProperty(String.valueOf(str) + ".ssl.protocols", (String) null);
            sSLSocket.setEnabledProtocols(property != null ? stringArray(property) : new String[]{"TLSv1"});
            String property2 = properties.getProperty(String.valueOf(str) + ".ssl.ciphersuites", (String) null);
            if (property2 != null) {
                sSLSocket.setEnabledCipherSuites(stringArray(property2));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.net.Socket createSocket(java.net.InetAddress r0, int r1, java.lang.String r2, int r3, int r4, javax.net.SocketFactory r5, boolean r6) throws java.io.IOException {
        /*
            if (r5 == 0) goto L_0x0007
        L_0x0002:
            java.net.Socket r5 = r5.createSocket()
            goto L_0x0013
        L_0x0007:
            if (r6 == 0) goto L_0x000e
            javax.net.SocketFactory r5 = javax.net.ssl.SSLSocketFactory.getDefault()
            goto L_0x0002
        L_0x000e:
            java.net.Socket r5 = new java.net.Socket
            r5.<init>()
        L_0x0013:
            if (r0 == 0) goto L_0x001d
            java.net.InetSocketAddress r6 = new java.net.InetSocketAddress
            r6.<init>(r0, r1)
            r5.bind(r6)
        L_0x001d:
            if (r4 < 0) goto L_0x0028
            java.net.InetSocketAddress r0 = new java.net.InetSocketAddress
            r0.<init>(r2, r3)
            r5.connect(r0, r4)
            return r5
        L_0x0028:
            java.net.InetSocketAddress r0 = new java.net.InetSocketAddress
            r0.<init>(r2, r3)
            r5.connect(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.SocketFetcher.createSocket(java.net.InetAddress, int, java.lang.String, int, int, javax.net.SocketFactory, boolean):java.net.Socket");
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

    public static Socket getSocket(String str, int i, Properties properties, String str2) throws IOException {
        return getSocket(str, i, properties, str2, false);
    }

    /* JADX WARNING: type inference failed for: r1v7, types: [java.lang.Throwable] */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e7, code lost:
        r6 = r0;
        r4 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0105, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0106, code lost:
        r6 = r0;
        r7 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0115, code lost:
        if ((r6 instanceof java.lang.reflect.InvocationTargetException) != false) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0117, code lost:
        r1 = ((java.lang.reflect.InvocationTargetException) r6).getTargetException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0120, code lost:
        if ((r1 instanceof java.lang.Exception) != false) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0122, code lost:
        r6 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0127, code lost:
        if ((r6 instanceof java.io.IOException) != false) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x012b, code lost:
        throw ((java.io.IOException) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x012c, code lost:
        r1 = new java.io.IOException("Couldn't connect using \"" + r4 + "\" socket factory to host, port: " + r19 + ", " + r7 + "; Exception: " + r6);
        r1.initCause(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x015c, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0181, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0183, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0080 A[SYNTHETIC, Splitter:B:18:0x0080] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c9 A[Catch:{ SocketTimeoutException -> 0x0181, Exception -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0172 A[SYNTHETIC, Splitter:B:71:0x0172] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0181 A[ExcHandler: SocketTimeoutException (r0v0 'e' java.net.SocketTimeoutException A[CUSTOM_DECLARE]), Splitter:B:30:0x00c3] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.net.Socket getSocket(java.lang.String r19, int r20, java.util.Properties r21, java.lang.String r22, boolean r23) throws java.io.IOException {
        /*
            if (r22 != 0) goto L_0x0006
            java.lang.String r1 = "socket"
            r2 = r1
            goto L_0x0008
        L_0x0006:
            r2 = r22
        L_0x0008:
            if (r21 != 0) goto L_0x0010
            java.util.Properties r1 = new java.util.Properties
            r1.<init>()
            goto L_0x0012
        L_0x0010:
            r1 = r21
        L_0x0012:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r2)
            r3.<init>(r4)
            java.lang.String r4 = ".connectiontimeout"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r4 = 0
            java.lang.String r3 = r1.getProperty(r3, r4)
            r5 = -1
            if (r3 == 0) goto L_0x0031
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x0031 }
            goto L_0x0032
        L_0x0031:
            r3 = -1
        L_0x0032:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = java.lang.String.valueOf(r2)
            r6.<init>(r7)
            java.lang.String r7 = ".timeout"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r13 = r1.getProperty(r6, r4)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = java.lang.String.valueOf(r2)
            r6.<init>(r7)
            java.lang.String r7 = ".localaddress"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r1.getProperty(r6, r4)
            if (r6 == 0) goto L_0x0066
            java.net.InetAddress r6 = java.net.InetAddress.getByName(r6)
            r14 = r6
            goto L_0x0067
        L_0x0066:
            r14 = r4
        L_0x0067:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = java.lang.String.valueOf(r2)
            r6.<init>(r7)
            java.lang.String r7 = ".localport"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r1.getProperty(r6, r4)
            r7 = 0
            if (r6 == 0) goto L_0x0086
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ NumberFormatException -> 0x0086 }
            r15 = r6
            goto L_0x0087
        L_0x0086:
            r15 = 0
        L_0x0087:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = java.lang.String.valueOf(r2)
            r6.<init>(r8)
            java.lang.String r8 = ".socketFactory.fallback"
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r1.getProperty(r6, r4)
            if (r6 == 0) goto L_0x00aa
            java.lang.String r8 = "false"
            boolean r6 = r6.equalsIgnoreCase(r8)
            if (r6 == 0) goto L_0x00aa
            r16 = 0
            goto L_0x00ad
        L_0x00aa:
            r7 = 1
            r16 = 1
        L_0x00ad:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = java.lang.String.valueOf(r2)
            r6.<init>(r7)
            java.lang.String r7 = ".socketFactory.class"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r12 = r1.getProperty(r6, r4)
            javax.net.SocketFactory r11 = getSocketFactory(r12)     // Catch:{ SocketTimeoutException -> 0x0181, Exception -> 0x010d }
            if (r11 == 0) goto L_0x010a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x0181, Exception -> 0x010d }
            java.lang.String r7 = java.lang.String.valueOf(r2)     // Catch:{ SocketTimeoutException -> 0x0181, Exception -> 0x010d }
            r6.<init>(r7)     // Catch:{ SocketTimeoutException -> 0x0181, Exception -> 0x010d }
            java.lang.String r7 = ".socketFactory.port"
            r6.append(r7)     // Catch:{ SocketTimeoutException -> 0x0181, Exception -> 0x010d }
            java.lang.String r6 = r6.toString()     // Catch:{ SocketTimeoutException -> 0x0181, Exception -> 0x010d }
            java.lang.String r6 = r1.getProperty(r6, r4)     // Catch:{ SocketTimeoutException -> 0x0181, Exception -> 0x010d }
            if (r6 == 0) goto L_0x00ea
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ NumberFormatException -> 0x00ea, SocketTimeoutException -> 0x0181, Exception -> 0x00e6 }
            goto L_0x00eb
        L_0x00e6:
            r0 = move-exception
            r6 = r0
            r4 = r12
            goto L_0x0110
        L_0x00ea:
            r6 = -1
        L_0x00eb:
            if (r6 != r5) goto L_0x00f0
            r17 = r20
            goto L_0x00f2
        L_0x00f0:
            r17 = r6
        L_0x00f2:
            r6 = r14
            r7 = r15
            r8 = r19
            r9 = r17
            r10 = r3
            r4 = r12
            r12 = r23
            java.net.Socket r6 = createSocket(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ SocketTimeoutException -> 0x0181, Exception -> 0x0105 }
            r4 = r19
            r18 = r6
            goto L_0x015f
        L_0x0105:
            r0 = move-exception
            r6 = r0
            r7 = r17
            goto L_0x0111
        L_0x010a:
            r4 = r19
            goto L_0x015d
        L_0x010d:
            r0 = move-exception
            r4 = r12
            r6 = r0
        L_0x0110:
            r7 = -1
        L_0x0111:
            if (r16 != 0) goto L_0x010a
            boolean r1 = r6 instanceof java.lang.reflect.InvocationTargetException
            if (r1 == 0) goto L_0x0125
            r1 = r6
            java.lang.reflect.InvocationTargetException r1 = (java.lang.reflect.InvocationTargetException) r1
            java.lang.Throwable r1 = r1.getTargetException()
            boolean r2 = r1 instanceof java.lang.Exception
            if (r2 == 0) goto L_0x0125
            r6 = r1
            java.lang.Exception r6 = (java.lang.Exception) r6
        L_0x0125:
            boolean r1 = r6 instanceof java.io.IOException
            if (r1 == 0) goto L_0x012c
            java.io.IOException r6 = (java.io.IOException) r6
            throw r6
        L_0x012c:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Couldn't connect using \""
            r2.<init>(r3)
            r2.append(r4)
            java.lang.String r3 = "\" socket factory to host, port: "
            r2.append(r3)
            r4 = r19
            r2.append(r4)
            java.lang.String r3 = ", "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r3 = "; Exception: "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            r1.initCause(r6)
            throw r1
        L_0x015d:
            r18 = 0
        L_0x015f:
            if (r18 != 0) goto L_0x016e
            r11 = 0
            r6 = r14
            r7 = r15
            r8 = r4
            r9 = r20
            r10 = r3
            r12 = r23
            java.net.Socket r18 = createSocket(r6, r7, r8, r9, r10, r11, r12)
        L_0x016e:
            r3 = r18
            if (r13 == 0) goto L_0x0177
            int r4 = java.lang.Integer.parseInt(r13)     // Catch:{ NumberFormatException -> 0x0177 }
            goto L_0x0178
        L_0x0177:
            r4 = -1
        L_0x0178:
            if (r4 < 0) goto L_0x017d
            r3.setSoTimeout(r4)
        L_0x017d:
            configureSSLSocket(r3, r1, r2)
            return r3
        L_0x0181:
            r0 = move-exception
            r1 = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.SocketFetcher.getSocket(java.lang.String, int, java.util.Properties, java.lang.String, boolean):java.net.Socket");
    }

    private static SocketFactory getSocketFactory(String str) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?> cls = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        ClassLoader contextClassLoader = getContextClassLoader();
        if (contextClassLoader != null) {
            try {
                cls = contextClassLoader.loadClass(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        if (cls == null) {
            cls = Class.forName(str);
        }
        return (SocketFactory) cls.getMethod("getDefault", new Class[0]).invoke(new Object(), new Object[0]);
    }

    public static Socket startTLS(Socket socket) throws IOException {
        return startTLS(socket, new Properties(), "socket");
    }

    /* JADX WARNING: type inference failed for: r5v6, types: [java.lang.Throwable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.net.Socket startTLS(java.net.Socket r4, java.util.Properties r5, java.lang.String r6) throws java.io.IOException {
        /*
            java.net.InetAddress r0 = r4.getInetAddress()
            java.lang.String r0 = r0.getHostName()
            int r1 = r4.getPort()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003e }
            java.lang.String r3 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x003e }
            r2.<init>(r3)     // Catch:{ Exception -> 0x003e }
            java.lang.String r3 = ".socketFactory.class"
            r2.append(r3)     // Catch:{ Exception -> 0x003e }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x003e }
            r3 = 0
            java.lang.String r2 = r5.getProperty(r2, r3)     // Catch:{ Exception -> 0x003e }
            javax.net.SocketFactory r2 = getSocketFactory(r2)     // Catch:{ Exception -> 0x003e }
            if (r2 == 0) goto L_0x0030
            boolean r3 = r2 instanceof javax.net.ssl.SSLSocketFactory     // Catch:{ Exception -> 0x003e }
            if (r3 == 0) goto L_0x0030
        L_0x002d:
            javax.net.ssl.SSLSocketFactory r2 = (javax.net.ssl.SSLSocketFactory) r2     // Catch:{ Exception -> 0x003e }
            goto L_0x0035
        L_0x0030:
            javax.net.SocketFactory r2 = javax.net.ssl.SSLSocketFactory.getDefault()     // Catch:{ Exception -> 0x003e }
            goto L_0x002d
        L_0x0035:
            r3 = 1
            java.net.Socket r4 = r2.createSocket(r4, r0, r1, r3)     // Catch:{ Exception -> 0x003e }
            configureSSLSocket(r4, r5, r6)     // Catch:{ Exception -> 0x003e }
            return r4
        L_0x003e:
            r4 = move-exception
            boolean r5 = r4 instanceof java.lang.reflect.InvocationTargetException
            if (r5 == 0) goto L_0x0051
            r5 = r4
            java.lang.reflect.InvocationTargetException r5 = (java.lang.reflect.InvocationTargetException) r5
            java.lang.Throwable r5 = r5.getTargetException()
            boolean r6 = r5 instanceof java.lang.Exception
            if (r6 == 0) goto L_0x0051
            r4 = r5
            java.lang.Exception r4 = (java.lang.Exception) r4
        L_0x0051:
            boolean r5 = r4 instanceof java.io.IOException
            if (r5 == 0) goto L_0x0058
            java.io.IOException r4 = (java.io.IOException) r4
            throw r4
        L_0x0058:
            java.io.IOException r5 = new java.io.IOException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r2 = "Exception in startTLS: host "
            r6.<init>(r2)
            r6.append(r0)
            java.lang.String r0 = ", port "
            r6.append(r0)
            r6.append(r1)
            java.lang.String r0 = "; Exception: "
            r6.append(r0)
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            r5.initCause(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.SocketFetcher.startTLS(java.net.Socket, java.util.Properties, java.lang.String):java.net.Socket");
    }

    private static String[] stringArray(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
