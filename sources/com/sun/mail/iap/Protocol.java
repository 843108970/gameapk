package com.sun.mail.iap;

import com.cyjh.common.util.s;
import com.sun.mail.util.SocketFetcher;
import com.sun.mail.util.TraceInputStream;
import com.sun.mail.util.TraceOutputStream;
import com.umeng.commonsdk.proguard.bg;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Properties;
import java.util.Vector;

public class Protocol {
    private static final byte[] CRLF = {bg.k, 10};
    private boolean connected;
    protected boolean debug;
    private volatile Vector handlers;
    protected String host;
    private volatile ResponseInputStream input;
    protected PrintStream out;
    private volatile DataOutputStream output;
    protected String prefix;
    protected Properties props;
    protected boolean quote;
    private Socket socket;
    private int tagCounter;
    private volatile long timestamp;
    private TraceInputStream traceInput;
    private TraceOutputStream traceOutput;

    public Protocol(InputStream inputStream, OutputStream outputStream, boolean z) throws IOException {
        this.connected = false;
        this.tagCounter = 0;
        this.handlers = null;
        this.host = "localhost";
        this.debug = z;
        this.quote = false;
        this.out = System.out;
        this.traceInput = new TraceInputStream(inputStream, System.out);
        this.traceInput.setTrace(z);
        this.traceInput.setQuote(this.quote);
        this.input = new ResponseInputStream(this.traceInput);
        this.traceOutput = new TraceOutputStream(outputStream, System.out);
        this.traceOutput.setTrace(z);
        this.traceOutput.setQuote(this.quote);
        this.output = new DataOutputStream(new BufferedOutputStream(this.traceOutput));
        this.timestamp = System.currentTimeMillis();
    }

    public Protocol(String str, int i, boolean z, PrintStream printStream, Properties properties, String str2, boolean z2) throws IOException, ProtocolException {
        boolean z3 = false;
        this.connected = false;
        this.tagCounter = 0;
        this.handlers = null;
        try {
            this.host = str;
            this.debug = z;
            this.out = printStream;
            this.props = properties;
            this.prefix = str2;
            this.socket = SocketFetcher.getSocket(str, i, properties, str2, z2);
            String property = properties.getProperty("mail.debug.quote");
            if (property != null && property.equalsIgnoreCase("true")) {
                z3 = true;
            }
            this.quote = z3;
            initStreams(printStream);
            processGreeting(readResponse());
            this.timestamp = System.currentTimeMillis();
            this.connected = true;
        } finally {
            if (!this.connected) {
                disconnect();
            }
        }
    }

    private void initStreams(PrintStream printStream) throws IOException {
        this.traceInput = new TraceInputStream(this.socket.getInputStream(), printStream);
        this.traceInput.setTrace(this.debug);
        this.traceInput.setQuote(this.quote);
        this.input = new ResponseInputStream(this.traceInput);
        this.traceOutput = new TraceOutputStream(this.socket.getOutputStream(), printStream);
        this.traceOutput.setTrace(this.debug);
        this.traceOutput.setQuote(this.quote);
        this.output = new DataOutputStream(new BufferedOutputStream(this.traceOutput));
    }

    public synchronized void addResponseHandler(ResponseHandler responseHandler) {
        if (this.handlers == null) {
            this.handlers = new Vector();
        }
        this.handlers.addElement(responseHandler);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0031 A[SYNTHETIC, Splitter:B:19:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0020 A[SYNTHETIC] */
    public synchronized com.sun.mail.iap.Response[] command(java.lang.String r5, com.sun.mail.iap.Argument r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.Vector r0 = new java.util.Vector     // Catch:{ all -> 0x0056 }
            r0.<init>()     // Catch:{ all -> 0x0056 }
            r1 = 0
            r2 = 0
            r3 = 1
            java.lang.String r5 = r4.writeCommand(r5, r6)     // Catch:{ LiteralException -> 0x0015, Exception -> 0x000f }
            r2 = r5
            goto L_0x001e
        L_0x000f:
            r5 = move-exception
            com.sun.mail.iap.Response r5 = com.sun.mail.iap.Response.byeResponse(r5)     // Catch:{ all -> 0x0056 }
            goto L_0x001a
        L_0x0015:
            r5 = move-exception
            com.sun.mail.iap.Response r5 = r5.getResponse()     // Catch:{ all -> 0x0056 }
        L_0x001a:
            r0.addElement(r5)     // Catch:{ all -> 0x0056 }
        L_0x001d:
            r1 = 1
        L_0x001e:
            if (r1 == 0) goto L_0x0031
            int r5 = r0.size()     // Catch:{ all -> 0x0056 }
            com.sun.mail.iap.Response[] r5 = new com.sun.mail.iap.Response[r5]     // Catch:{ all -> 0x0056 }
            r0.copyInto(r5)     // Catch:{ all -> 0x0056 }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0056 }
            r4.timestamp = r0     // Catch:{ all -> 0x0056 }
            monitor-exit(r4)
            return r5
        L_0x0031:
            com.sun.mail.iap.Response r5 = r4.readResponse()     // Catch:{ IOException -> 0x0036, ProtocolException -> 0x001e }
            goto L_0x003b
        L_0x0036:
            r5 = move-exception
            com.sun.mail.iap.Response r5 = com.sun.mail.iap.Response.byeResponse(r5)     // Catch:{ all -> 0x0056 }
        L_0x003b:
            r0.addElement(r5)     // Catch:{ all -> 0x0056 }
            boolean r6 = r5.isBYE()     // Catch:{ all -> 0x0056 }
            if (r6 == 0) goto L_0x0045
            r1 = 1
        L_0x0045:
            boolean r6 = r5.isTagged()     // Catch:{ all -> 0x0056 }
            if (r6 == 0) goto L_0x001e
            java.lang.String r5 = r5.getTag()     // Catch:{ all -> 0x0056 }
            boolean r5 = r5.equals(r2)     // Catch:{ all -> 0x0056 }
            if (r5 == 0) goto L_0x001e
            goto L_0x001d
        L_0x0056:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.iap.Protocol.command(java.lang.String, com.sun.mail.iap.Argument):com.sun.mail.iap.Response[]");
    }

    public synchronized void disconnect() {
        if (this.socket != null) {
            try {
                this.socket.close();
            } catch (IOException unused) {
            }
            this.socket = null;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        disconnect();
    }

    /* access modifiers changed from: protected */
    public ResponseInputStream getInputStream() {
        return this.input;
    }

    /* access modifiers changed from: protected */
    public OutputStream getOutputStream() {
        return this.output;
    }

    public ByteArray getResponseBuffer() {
        return null;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void handleResult(Response response) throws ProtocolException {
        if (!response.isOK()) {
            if (response.isNO()) {
                throw new CommandFailedException(response);
            } else if (response.isBAD()) {
                throw new BadCommandException(response);
            } else if (response.isBYE()) {
                disconnect();
                throw new ConnectionException(this, response);
            }
        }
    }

    public void notifyResponseHandlers(Response[] responseArr) {
        if (this.handlers != null) {
            for (Response response : responseArr) {
                if (response != null) {
                    int size = this.handlers.size();
                    if (size != 0) {
                        Object[] objArr = new Object[size];
                        this.handlers.copyInto(objArr);
                        for (int i = 0; i < size; i++) {
                            ((ResponseHandler) objArr[i]).handleResponse(response);
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void processGreeting(Response response) throws ProtocolException {
        if (response.isBYE()) {
            throw new ConnectionException(this, response);
        }
    }

    public Response readResponse() throws IOException, ProtocolException {
        return new Response(this);
    }

    public synchronized void removeResponseHandler(ResponseHandler responseHandler) {
        if (this.handlers != null) {
            this.handlers.removeElement(responseHandler);
        }
    }

    public void simpleCommand(String str, Argument argument) throws ProtocolException {
        Response[] command = command(str, argument);
        notifyResponseHandlers(command);
        handleResult(command[command.length - 1]);
    }

    public synchronized void startTLS(String str) throws IOException, ProtocolException {
        simpleCommand(str, (Argument) null);
        this.socket = SocketFetcher.startTLS(this.socket, this.props, this.prefix);
        initStreams(this.out);
    }

    public synchronized boolean supportsNonSyncLiterals() {
        return false;
    }

    public String writeCommand(String str, Argument argument) throws IOException, ProtocolException {
        StringBuilder sb = new StringBuilder("A");
        int i = this.tagCounter;
        this.tagCounter = i + 1;
        sb.append(Integer.toString(i, 10));
        String sb2 = sb.toString();
        DataOutputStream dataOutputStream = this.output;
        dataOutputStream.writeBytes(String.valueOf(sb2) + s.a.f1696a + str);
        if (argument != null) {
            this.output.write(32);
            argument.write(this);
        }
        this.output.write(CRLF);
        this.output.flush();
        return sb2;
    }
}
