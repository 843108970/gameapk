package mobi.oneway.export.d;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class c extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    private final SSLSocketFactory f4152a;

    public class a extends SSLSocket {

        /* renamed from: a  reason: collision with root package name */
        protected final SSLSocket f4153a;

        a(SSLSocket sSLSocket) {
            this.f4153a = sSLSocket;
        }

        public void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
            this.f4153a.addHandshakeCompletedListener(handshakeCompletedListener);
        }

        public void bind(SocketAddress socketAddress) {
            this.f4153a.bind(socketAddress);
        }

        public synchronized void close() {
            this.f4153a.close();
        }

        public void connect(SocketAddress socketAddress) {
            this.f4153a.connect(socketAddress);
        }

        public void connect(SocketAddress socketAddress, int i) {
            this.f4153a.connect(socketAddress, i);
        }

        public boolean equals(Object obj) {
            return this.f4153a.equals(obj);
        }

        public SocketChannel getChannel() {
            return this.f4153a.getChannel();
        }

        public boolean getEnableSessionCreation() {
            return this.f4153a.getEnableSessionCreation();
        }

        public String[] getEnabledCipherSuites() {
            return this.f4153a.getEnabledCipherSuites();
        }

        public String[] getEnabledProtocols() {
            return this.f4153a.getEnabledProtocols();
        }

        public InetAddress getInetAddress() {
            return this.f4153a.getInetAddress();
        }

        public InputStream getInputStream() {
            return this.f4153a.getInputStream();
        }

        public boolean getKeepAlive() {
            return this.f4153a.getKeepAlive();
        }

        public InetAddress getLocalAddress() {
            return this.f4153a.getLocalAddress();
        }

        public int getLocalPort() {
            return this.f4153a.getLocalPort();
        }

        public SocketAddress getLocalSocketAddress() {
            return this.f4153a.getLocalSocketAddress();
        }

        public boolean getNeedClientAuth() {
            return this.f4153a.getNeedClientAuth();
        }

        public boolean getOOBInline() {
            return this.f4153a.getOOBInline();
        }

        public OutputStream getOutputStream() {
            return this.f4153a.getOutputStream();
        }

        public int getPort() {
            return this.f4153a.getPort();
        }

        public synchronized int getReceiveBufferSize() {
            return this.f4153a.getReceiveBufferSize();
        }

        public SocketAddress getRemoteSocketAddress() {
            return this.f4153a.getRemoteSocketAddress();
        }

        public boolean getReuseAddress() {
            return this.f4153a.getReuseAddress();
        }

        public synchronized int getSendBufferSize() {
            return this.f4153a.getSendBufferSize();
        }

        public SSLSession getSession() {
            return this.f4153a.getSession();
        }

        public int getSoLinger() {
            return this.f4153a.getSoLinger();
        }

        public synchronized int getSoTimeout() {
            return this.f4153a.getSoTimeout();
        }

        public String[] getSupportedCipherSuites() {
            return this.f4153a.getSupportedCipherSuites();
        }

        public String[] getSupportedProtocols() {
            return this.f4153a.getSupportedProtocols();
        }

        public boolean getTcpNoDelay() {
            return this.f4153a.getTcpNoDelay();
        }

        public int getTrafficClass() {
            return this.f4153a.getTrafficClass();
        }

        public boolean getUseClientMode() {
            return this.f4153a.getUseClientMode();
        }

        public boolean getWantClientAuth() {
            return this.f4153a.getWantClientAuth();
        }

        public boolean isBound() {
            return this.f4153a.isBound();
        }

        public boolean isClosed() {
            return this.f4153a.isClosed();
        }

        public boolean isConnected() {
            return this.f4153a.isConnected();
        }

        public boolean isInputShutdown() {
            return this.f4153a.isInputShutdown();
        }

        public boolean isOutputShutdown() {
            return this.f4153a.isOutputShutdown();
        }

        public void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
            this.f4153a.removeHandshakeCompletedListener(handshakeCompletedListener);
        }

        public void sendUrgentData(int i) {
            this.f4153a.sendUrgentData(i);
        }

        public void setEnableSessionCreation(boolean z) {
            this.f4153a.setEnableSessionCreation(z);
        }

        public void setEnabledCipherSuites(String[] strArr) {
            this.f4153a.setEnabledCipherSuites(strArr);
        }

        public void setEnabledProtocols(String[] strArr) {
            this.f4153a.setEnabledProtocols(strArr);
        }

        public void setKeepAlive(boolean z) {
            this.f4153a.setKeepAlive(z);
        }

        public void setNeedClientAuth(boolean z) {
            this.f4153a.setNeedClientAuth(z);
        }

        public void setOOBInline(boolean z) {
            this.f4153a.setOOBInline(z);
        }

        public void setPerformancePreferences(int i, int i2, int i3) {
            this.f4153a.setPerformancePreferences(i, i2, i3);
        }

        public synchronized void setReceiveBufferSize(int i) {
            this.f4153a.setReceiveBufferSize(i);
        }

        public void setReuseAddress(boolean z) {
            this.f4153a.setReuseAddress(z);
        }

        public synchronized void setSendBufferSize(int i) {
            this.f4153a.setSendBufferSize(i);
        }

        public void setSoLinger(boolean z, int i) {
            this.f4153a.setSoLinger(z, i);
        }

        public synchronized void setSoTimeout(int i) {
            this.f4153a.setSoTimeout(i);
        }

        public void setTcpNoDelay(boolean z) {
            this.f4153a.setTcpNoDelay(z);
        }

        public void setTrafficClass(int i) {
            this.f4153a.setTrafficClass(i);
        }

        public void setUseClientMode(boolean z) {
            this.f4153a.setUseClientMode(z);
        }

        public void setWantClientAuth(boolean z) {
            this.f4153a.setWantClientAuth(z);
        }

        public void shutdownInput() {
            this.f4153a.shutdownInput();
        }

        public void shutdownOutput() {
            this.f4153a.shutdownOutput();
        }

        public void startHandshake() {
            this.f4153a.startHandshake();
        }

        public String toString() {
            return this.f4153a.toString();
        }
    }

    private class b extends a {
        private b(SSLSocket sSLSocket) {
            super(sSLSocket);
        }

        public void setEnabledProtocols(String[] strArr) {
            PrintStream printStream;
            String str;
            if (strArr != null && strArr.length == 1 && "SSLv3".equals(strArr[0])) {
                ArrayList arrayList = new ArrayList(Arrays.asList(this.f4153a.getEnabledProtocols()));
                if (arrayList.size() > 1) {
                    arrayList.remove("SSLv3");
                    printStream = System.out;
                    str = "Removed SSLv3 from enabled protocols";
                } else {
                    printStream = System.out;
                    str = "SSL stuck with protocol available for " + String.valueOf(arrayList);
                }
                printStream.println(str);
                strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            super.setEnabledProtocols(strArr);
        }
    }

    public c() {
        this.f4152a = HttpsURLConnection.getDefaultSSLSocketFactory();
    }

    public c(SSLSocketFactory sSLSocketFactory) {
        this.f4152a = sSLSocketFactory;
    }

    private Socket a(Socket socket) {
        return socket instanceof SSLSocket ? new b((SSLSocket) socket) : socket;
    }

    public Socket createSocket(String str, int i) {
        return a(this.f4152a.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return a(this.f4152a.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) {
        return a(this.f4152a.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return a(this.f4152a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return a(this.f4152a.createSocket(socket, str, i, z));
    }

    public String[] getDefaultCipherSuites() {
        return this.f4152a.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.f4152a.getSupportedCipherSuites();
    }
}
