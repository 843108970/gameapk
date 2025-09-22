package com.sun.mail.smtp;

import android.support.v7.widget.helper.ItemTouchHelper;
import com.cyjh.common.util.s;
import com.lidroid.xutils.http.client.multipart.MIME;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.SocketFetcher;
import com.sun.mail.util.TraceInputStream;
import com.sun.mail.util.TraceOutputStream;
import com.umeng.commonsdk.proguard.bg;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimePart;
import javax.mail.internet.ParseException;

public class SMTPTransport extends Transport {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte[] CRLF = {bg.k, 10};
    private static final String UNKNOWN = "UNKNOWN";
    private static char[] hexchar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String[] ignoreList = {"Bcc", "Content-Length"};
    private Address[] addresses;
    private SMTPOutputStream dataStream;
    private int defaultPort;
    private MessagingException exception;
    private Hashtable extMap;
    private Address[] invalidAddr;
    private boolean isSSL;
    private int lastReturnCode;
    private String lastServerResponse;
    private LineInputStream lineInputStream;
    private String localHostName;
    private DigestMD5 md5support;
    private MimeMessage message;
    private String name;
    private PrintStream out;
    private boolean quitWait;
    private boolean reportSuccess;
    private String saslRealm;
    private boolean sendPartiallyFailed;
    private BufferedInputStream serverInput;
    private OutputStream serverOutput;
    private Socket serverSocket;
    private boolean useRset;
    private boolean useStartTLS;
    private Address[] validSentAddr;
    private Address[] validUnsentAddr;

    public SMTPTransport(Session session, URLName uRLName) {
        this(session, uRLName, "smtp", 25, false);
    }

    protected SMTPTransport(Session session, URLName uRLName, String str, int i, boolean z) {
        super(session, uRLName);
        this.name = "smtp";
        this.defaultPort = 25;
        this.isSSL = false;
        this.sendPartiallyFailed = false;
        this.quitWait = false;
        this.saslRealm = UNKNOWN;
        str = uRLName != null ? uRLName.getProtocol() : str;
        this.name = str;
        this.defaultPort = i;
        this.isSSL = z;
        this.out = session.getDebugOut();
        String property = session.getProperty("mail." + str + ".quitwait");
        boolean z2 = true;
        this.quitWait = property == null || property.equalsIgnoreCase("true");
        String property2 = session.getProperty("mail." + str + ".reportsuccess");
        this.reportSuccess = property2 != null && property2.equalsIgnoreCase("true");
        String property3 = session.getProperty("mail." + str + ".starttls.enable");
        this.useStartTLS = property3 != null && property3.equalsIgnoreCase("true");
        String property4 = session.getProperty("mail." + str + ".userset");
        this.useRset = (property4 == null || !property4.equalsIgnoreCase("true")) ? false : z2;
    }

    private void closeConnection() throws MessagingException {
        try {
            if (this.serverSocket != null) {
                this.serverSocket.close();
            }
            this.serverSocket = null;
            this.serverOutput = null;
            this.serverInput = null;
            this.lineInputStream = null;
            if (super.isConnected()) {
                super.close();
            }
        } catch (IOException e) {
            throw new MessagingException("Server Close Failed", e);
        } catch (Throwable th) {
            this.serverSocket = null;
            this.serverOutput = null;
            this.serverInput = null;
            this.lineInputStream = null;
            if (super.isConnected()) {
                super.close();
            }
            throw th;
        }
    }

    private boolean convertTo8Bit(MimePart mimePart) {
        int i = 0;
        try {
            if (mimePart.isMimeType("text/*")) {
                String encoding = mimePart.getEncoding();
                if (encoding != null && ((encoding.equalsIgnoreCase("quoted-printable") || encoding.equalsIgnoreCase("base64")) && is8Bit(mimePart.getInputStream()))) {
                    mimePart.setContent(mimePart.getContent(), mimePart.getContentType());
                    mimePart.setHeader(MIME.CONTENT_TRANSFER_ENC, MIME.ENC_8BIT);
                    return true;
                }
            } else if (mimePart.isMimeType("multipart/*")) {
                MimeMultipart mimeMultipart = (MimeMultipart) mimePart.getContent();
                int count = mimeMultipart.getCount();
                boolean z = false;
                while (i < count) {
                    try {
                        if (convertTo8Bit((MimePart) mimeMultipart.getBodyPart(i))) {
                            z = true;
                        }
                        i++;
                    } catch (IOException | MessagingException unused) {
                    }
                }
                return z;
            }
        } catch (IOException | MessagingException unused2) {
        }
        return false;
    }

    private void expandGroups() {
        Vector vector = null;
        for (int i = 0; i < this.addresses.length; i++) {
            InternetAddress internetAddress = (InternetAddress) this.addresses[i];
            if (internetAddress.isGroup()) {
                if (vector == null) {
                    Vector vector2 = new Vector();
                    for (int i2 = 0; i2 < i; i2++) {
                        vector2.addElement(this.addresses[i2]);
                    }
                    vector = vector2;
                }
                try {
                    InternetAddress[] group = internetAddress.getGroup(true);
                    if (group != null) {
                        for (InternetAddress addElement : group) {
                            vector.addElement(addElement);
                        }
                    } else {
                        vector.addElement(internetAddress);
                    }
                } catch (ParseException unused) {
                }
            } else {
                if (vector == null) {
                }
                vector.addElement(internetAddress);
            }
        }
        if (vector != null) {
            InternetAddress[] internetAddressArr = new InternetAddress[vector.size()];
            vector.copyInto(internetAddressArr);
            this.addresses = internetAddressArr;
        }
    }

    private synchronized DigestMD5 getMD5() {
        if (this.md5support == null) {
            this.md5support = new DigestMD5(this.debug ? this.out : null);
        }
        return this.md5support;
    }

    private void initStreams() throws IOException {
        Properties properties = this.session.getProperties();
        PrintStream debugOut = this.session.getDebugOut();
        boolean debug = this.session.getDebug();
        String property = properties.getProperty("mail.debug.quote");
        boolean z = property != null && property.equalsIgnoreCase("true");
        TraceInputStream traceInputStream = new TraceInputStream(this.serverSocket.getInputStream(), debugOut);
        traceInputStream.setTrace(debug);
        traceInputStream.setQuote(z);
        TraceOutputStream traceOutputStream = new TraceOutputStream(this.serverSocket.getOutputStream(), debugOut);
        traceOutputStream.setTrace(debug);
        traceOutputStream.setQuote(z);
        this.serverOutput = new BufferedOutputStream(traceOutputStream);
        this.serverInput = new BufferedInputStream(traceInputStream);
        this.lineInputStream = new LineInputStream(this.serverInput);
    }

    private boolean is8Bit(InputStream inputStream) {
        boolean z = false;
        int i = 0;
        while (true) {
            try {
                int read = inputStream.read();
                if (read < 0) {
                    if (this.debug && z) {
                        this.out.println("DEBUG SMTP: found an 8bit part");
                    }
                    return z;
                }
                int i2 = read & 255;
                if (i2 == 13 || i2 == 10) {
                    i = 0;
                } else if (i2 == 0 || (i = i + 1) > 998) {
                    return false;
                }
                if (i2 > 127) {
                    z = true;
                }
            } catch (IOException unused) {
                return false;
            }
        }
    }

    private boolean isNotLastLine(String str) {
        return str != null && str.length() >= 4 && str.charAt(3) == '-';
    }

    private void issueSendCommand(String str, int i) throws MessagingException {
        sendCommand(str);
        int readServerResponse = readServerResponse();
        if (readServerResponse != i) {
            int length = this.validSentAddr == null ? 0 : this.validSentAddr.length;
            int length2 = this.validUnsentAddr == null ? 0 : this.validUnsentAddr.length;
            Address[] addressArr = new Address[(length + length2)];
            if (length > 0) {
                System.arraycopy(this.validSentAddr, 0, addressArr, 0, length);
            }
            if (length2 > 0) {
                System.arraycopy(this.validUnsentAddr, 0, addressArr, length, length2);
            }
            this.validSentAddr = null;
            this.validUnsentAddr = addressArr;
            if (this.debug) {
                PrintStream printStream = this.out;
                printStream.println("DEBUG SMTP: got response code " + readServerResponse + ", with response: " + this.lastServerResponse);
            }
            String str2 = this.lastServerResponse;
            int i2 = this.lastReturnCode;
            if (this.serverSocket != null) {
                issueCommand("RSET", ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
            }
            this.lastServerResponse = str2;
            this.lastReturnCode = i2;
            throw new SMTPSendFailedException(str, readServerResponse, this.lastServerResponse, this.exception, this.validSentAddr, this.validUnsentAddr, this.invalidAddr);
        }
    }

    private String normalizeAddress(String str) {
        if (str.startsWith("<") || str.endsWith(">")) {
            return str;
        }
        return "<" + str + ">";
    }

    private void openServer() throws MessagingException {
        int i;
        String str;
        IOException e;
        try {
            i = this.serverSocket.getPort();
            try {
                str = this.serverSocket.getInetAddress().getHostName();
                try {
                    if (this.debug) {
                        PrintStream printStream = this.out;
                        printStream.println("DEBUG SMTP: starting protocol to host \"" + str + "\", port " + i);
                    }
                    initStreams();
                    int readServerResponse = readServerResponse();
                    if (readServerResponse != 220) {
                        this.serverSocket.close();
                        this.serverSocket = null;
                        this.serverOutput = null;
                        this.serverInput = null;
                        this.lineInputStream = null;
                        if (this.debug) {
                            PrintStream printStream2 = this.out;
                            printStream2.println("DEBUG SMTP: got bad greeting from host \"" + str + "\", port: " + i + ", response: " + readServerResponse + "\n");
                        }
                        throw new MessagingException("Got bad greeting from SMTP host: " + str + ", port: " + i + ", response: " + readServerResponse);
                    } else if (this.debug) {
                        PrintStream printStream3 = this.out;
                        printStream3.println("DEBUG SMTP: protocol started to host \"" + str + "\", port: " + i + "\n");
                    }
                } catch (IOException e2) {
                    e = e2;
                    throw new MessagingException("Could not start protocol to SMTP host: " + str + ", port: " + i, e);
                }
            } catch (IOException e3) {
                IOException iOException = e3;
                str = UNKNOWN;
                e = iOException;
                throw new MessagingException("Could not start protocol to SMTP host: " + str + ", port: " + i, e);
            }
        } catch (IOException e4) {
            str = UNKNOWN;
            e = e4;
            i = -1;
            throw new MessagingException("Could not start protocol to SMTP host: " + str + ", port: " + i, e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00dd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00de, code lost:
        r4 = r0;
        r0 = r7;
        r7 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00fd, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0111, code lost:
        throw new javax.mail.MessagingException("Unknown SMTP host: " + r6, r7);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00fd A[ExcHandler: UnknownHostException (r7v1 'e' java.net.UnknownHostException A[CUSTOM_DECLARE]), Splitter:B:3:0x0029] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void openServer(java.lang.String r6, int r7) throws javax.mail.MessagingException {
        /*
            r5 = this;
            boolean r0 = r5.debug
            if (r0 == 0) goto L_0x0029
            java.io.PrintStream r0 = r5.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "DEBUG SMTP: trying to connect to host \""
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r2 = "\", port "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = ", isSSL "
            r1.append(r2)
            boolean r2 = r5.isSSL
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.println(r1)
        L_0x0029:
            javax.mail.Session r0 = r5.session     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00dd }
            java.util.Properties r0 = r0.getProperties()     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00dd }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00dd }
            java.lang.String r2 = "mail."
            r1.<init>(r2)     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00dd }
            java.lang.String r2 = r5.name     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00dd }
            r1.append(r2)     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00dd }
            java.lang.String r1 = r1.toString()     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00dd }
            boolean r2 = r5.isSSL     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00dd }
            java.net.Socket r0 = com.sun.mail.util.SocketFetcher.getSocket(r6, r7, r0, r1, r2)     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00dd }
            r5.serverSocket = r0     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00dd }
            java.net.Socket r0 = r5.serverSocket     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00dd }
            int r0 = r0.getPort()     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00dd }
            r5.initStreams()     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            int r7 = r5.readServerResponse()     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            r1 = 220(0xdc, float:3.08E-43)
            if (r7 == r1) goto L_0x00b6
            java.net.Socket r1 = r5.serverSocket     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            r1.close()     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            r1 = 0
            r5.serverSocket = r1     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            r5.serverOutput = r1     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            r5.serverInput = r1     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            r5.lineInputStream = r1     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            boolean r1 = r5.debug     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            if (r1 == 0) goto L_0x0092
            java.io.PrintStream r1 = r5.out     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            java.lang.String r3 = "DEBUG SMTP: could not connect to host \""
            r2.<init>(r3)     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            r2.append(r6)     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            java.lang.String r3 = "\", port: "
            r2.append(r3)     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            r2.append(r0)     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            java.lang.String r3 = ", response: "
            r2.append(r3)     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            r2.append(r7)     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            java.lang.String r3 = "\n"
            r2.append(r3)     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            java.lang.String r2 = r2.toString()     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            r1.println(r2)     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
        L_0x0092:
            javax.mail.MessagingException r1 = new javax.mail.MessagingException     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            java.lang.String r3 = "Could not connect to SMTP host: "
            r2.<init>(r3)     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            r2.append(r6)     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            java.lang.String r3 = ", port: "
            r2.append(r3)     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            r2.append(r0)     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            java.lang.String r3 = ", response: "
            r2.append(r3)     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            r2.append(r7)     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            java.lang.String r7 = r2.toString()     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            r1.<init>(r7)     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            throw r1     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
        L_0x00b6:
            boolean r7 = r5.debug     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            if (r7 == 0) goto L_0x00da
            java.io.PrintStream r7 = r5.out     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            java.lang.String r2 = "DEBUG SMTP: connected to host \""
            r1.<init>(r2)     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            r1.append(r6)     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            java.lang.String r2 = "\", port: "
            r1.append(r2)     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            r1.append(r0)     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            java.lang.String r2 = "\n"
            r1.append(r2)     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            java.lang.String r1 = r1.toString()     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
            r7.println(r1)     // Catch:{ UnknownHostException -> 0x00fd, IOException -> 0x00db }
        L_0x00da:
            return
        L_0x00db:
            r7 = move-exception
            goto L_0x00e1
        L_0x00dd:
            r0 = move-exception
            r4 = r0
            r0 = r7
            r7 = r4
        L_0x00e1:
            javax.mail.MessagingException r1 = new javax.mail.MessagingException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Could not connect to SMTP host: "
            r2.<init>(r3)
            r2.append(r6)
            java.lang.String r6 = ", port: "
            r2.append(r6)
            r2.append(r0)
            java.lang.String r6 = r2.toString()
            r1.<init>(r6, r7)
            throw r1
        L_0x00fd:
            r7 = move-exception
            javax.mail.MessagingException r0 = new javax.mail.MessagingException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unknown SMTP host: "
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.smtp.SMTPTransport.openServer(java.lang.String, int):void");
    }

    private void sendCommand(byte[] bArr) throws MessagingException {
        try {
            this.serverOutput.write(bArr);
            this.serverOutput.write(CRLF);
            this.serverOutput.flush();
        } catch (IOException e) {
            throw new MessagingException("Can't send command to SMTP host", e);
        }
    }

    protected static String xtext(String str) {
        StringBuffer stringBuffer = null;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= 128) {
                throw new IllegalArgumentException("Non-ASCII character in SMTP submitter: " + str);
            }
            if (charAt < '!' || charAt > '~' || charAt == '+' || charAt == '=') {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(str.length() + 4);
                    stringBuffer.append(str.substring(0, i));
                }
                stringBuffer.append('+');
                stringBuffer.append(hexchar[(charAt & 240) >> 4]);
                charAt = hexchar[charAt & 15];
            } else if (stringBuffer == null) {
            }
            stringBuffer.append(charAt);
        }
        return stringBuffer != null ? stringBuffer.toString() : str;
    }

    /* access modifiers changed from: protected */
    public void checkConnected() {
        if (!super.isConnected()) {
            throw new IllegalStateException("Not connected");
        }
    }

    public synchronized void close() throws MessagingException {
        int readServerResponse;
        if (super.isConnected()) {
            try {
                if (this.serverSocket != null) {
                    sendCommand("QUIT");
                    if (!(!this.quitWait || (readServerResponse = readServerResponse()) == 221 || readServerResponse == -1)) {
                        PrintStream printStream = this.out;
                        printStream.println("DEBUG SMTP: QUIT failed with " + readServerResponse);
                    }
                }
            } finally {
                closeConnection();
            }
        }
    }

    public synchronized void connect(Socket socket) throws MessagingException {
        this.serverSocket = socket;
        super.connect();
    }

    /* access modifiers changed from: protected */
    public OutputStream data() throws MessagingException {
        issueSendCommand("DATA", 354);
        this.dataStream = new SMTPOutputStream(this.serverOutput);
        return this.dataStream;
    }

    /* access modifiers changed from: protected */
    public boolean ehlo(String str) throws MessagingException {
        String str2;
        if (str != null) {
            str2 = "EHLO " + str;
        } else {
            str2 = "EHLO";
        }
        sendCommand(str2);
        int readServerResponse = readServerResponse();
        if (readServerResponse == 250) {
            BufferedReader bufferedReader = new BufferedReader(new StringReader(this.lastServerResponse));
            this.extMap = new Hashtable();
            boolean z = true;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (z) {
                        z = false;
                    } else if (readLine.length() >= 5) {
                        String substring = readLine.substring(4);
                        int indexOf = substring.indexOf(32);
                        String str3 = "";
                        if (indexOf > 0) {
                            str3 = substring.substring(indexOf + 1);
                            substring = substring.substring(0, indexOf);
                        }
                        if (this.debug) {
                            this.out.println("DEBUG SMTP: Found extension \"" + substring + "\", arg \"" + str3 + "\"");
                        }
                        this.extMap.put(substring.toUpperCase(Locale.ENGLISH), str3);
                    }
                } catch (IOException unused) {
                }
            }
        }
        return readServerResponse == 250;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        try {
            closeConnection();
        } catch (MessagingException unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void finishData() throws IOException, MessagingException {
        this.dataStream.ensureAtBOL();
        issueSendCommand(".", ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    }

    public String getExtensionParameter(String str) {
        if (this.extMap == null) {
            return null;
        }
        return (String) this.extMap.get(str.toUpperCase(Locale.ENGLISH));
    }

    public synchronized int getLastReturnCode() {
        return this.lastReturnCode;
    }

    public synchronized String getLastServerResponse() {
        return this.lastServerResponse;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0089 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String getLocalHost() {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = r3.localHostName     // Catch:{ UnknownHostException -> 0x0089 }
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = r3.localHostName     // Catch:{ UnknownHostException -> 0x0089 }
            int r0 = r0.length()     // Catch:{ UnknownHostException -> 0x0089 }
            if (r0 > 0) goto L_0x002a
        L_0x000d:
            javax.mail.Session r0 = r3.session     // Catch:{ UnknownHostException -> 0x0089 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0089 }
            java.lang.String r2 = "mail."
            r1.<init>(r2)     // Catch:{ UnknownHostException -> 0x0089 }
            java.lang.String r2 = r3.name     // Catch:{ UnknownHostException -> 0x0089 }
            r1.append(r2)     // Catch:{ UnknownHostException -> 0x0089 }
            java.lang.String r2 = ".localhost"
            r1.append(r2)     // Catch:{ UnknownHostException -> 0x0089 }
            java.lang.String r1 = r1.toString()     // Catch:{ UnknownHostException -> 0x0089 }
            java.lang.String r0 = r0.getProperty(r1)     // Catch:{ UnknownHostException -> 0x0089 }
            r3.localHostName = r0     // Catch:{ UnknownHostException -> 0x0089 }
        L_0x002a:
            java.lang.String r0 = r3.localHostName     // Catch:{ UnknownHostException -> 0x0089 }
            if (r0 == 0) goto L_0x0036
            java.lang.String r0 = r3.localHostName     // Catch:{ UnknownHostException -> 0x0089 }
            int r0 = r0.length()     // Catch:{ UnknownHostException -> 0x0089 }
            if (r0 > 0) goto L_0x0053
        L_0x0036:
            javax.mail.Session r0 = r3.session     // Catch:{ UnknownHostException -> 0x0089 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0089 }
            java.lang.String r2 = "mail."
            r1.<init>(r2)     // Catch:{ UnknownHostException -> 0x0089 }
            java.lang.String r2 = r3.name     // Catch:{ UnknownHostException -> 0x0089 }
            r1.append(r2)     // Catch:{ UnknownHostException -> 0x0089 }
            java.lang.String r2 = ".localaddress"
            r1.append(r2)     // Catch:{ UnknownHostException -> 0x0089 }
            java.lang.String r1 = r1.toString()     // Catch:{ UnknownHostException -> 0x0089 }
            java.lang.String r0 = r0.getProperty(r1)     // Catch:{ UnknownHostException -> 0x0089 }
            r3.localHostName = r0     // Catch:{ UnknownHostException -> 0x0089 }
        L_0x0053:
            java.lang.String r0 = r3.localHostName     // Catch:{ UnknownHostException -> 0x0089 }
            if (r0 == 0) goto L_0x005f
            java.lang.String r0 = r3.localHostName     // Catch:{ UnknownHostException -> 0x0089 }
            int r0 = r0.length()     // Catch:{ UnknownHostException -> 0x0089 }
            if (r0 > 0) goto L_0x0089
        L_0x005f:
            java.net.InetAddress r0 = java.net.InetAddress.getLocalHost()     // Catch:{ UnknownHostException -> 0x0089 }
            java.lang.String r1 = r0.getHostName()     // Catch:{ UnknownHostException -> 0x0089 }
            r3.localHostName = r1     // Catch:{ UnknownHostException -> 0x0089 }
            java.lang.String r1 = r3.localHostName     // Catch:{ UnknownHostException -> 0x0089 }
            if (r1 != 0) goto L_0x0089
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0089 }
            java.lang.String r2 = "["
            r1.<init>(r2)     // Catch:{ UnknownHostException -> 0x0089 }
            java.lang.String r0 = r0.getHostAddress()     // Catch:{ UnknownHostException -> 0x0089 }
            r1.append(r0)     // Catch:{ UnknownHostException -> 0x0089 }
            java.lang.String r0 = "]"
            r1.append(r0)     // Catch:{ UnknownHostException -> 0x0089 }
            java.lang.String r0 = r1.toString()     // Catch:{ UnknownHostException -> 0x0089 }
            r3.localHostName = r0     // Catch:{ UnknownHostException -> 0x0089 }
            goto L_0x0089
        L_0x0087:
            r0 = move-exception
            goto L_0x008d
        L_0x0089:
            java.lang.String r0 = r3.localHostName     // Catch:{ all -> 0x0087 }
            monitor-exit(r3)
            return r0
        L_0x008d:
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.smtp.SMTPTransport.getLocalHost():java.lang.String");
    }

    public synchronized boolean getReportSuccess() {
        return this.reportSuccess;
    }

    public synchronized String getSASLRealm() {
        if (this.saslRealm == UNKNOWN) {
            Session session = this.session;
            this.saslRealm = session.getProperty("mail." + this.name + ".sasl.realm");
            if (this.saslRealm == null) {
                Session session2 = this.session;
                this.saslRealm = session2.getProperty("mail." + this.name + ".saslrealm");
            }
        }
        return this.saslRealm;
    }

    public synchronized boolean getStartTLS() {
        return this.useStartTLS;
    }

    public synchronized boolean getUseRset() {
        return this.useRset;
    }

    /* access modifiers changed from: protected */
    public void helo(String str) throws MessagingException {
        String str2;
        if (str != null) {
            str2 = "HELO " + str;
        } else {
            str2 = "HELO";
        }
        issueCommand(str2, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:25|26|27|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        closeConnection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x002d, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0029 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean isConnected() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = super.isConnected()     // Catch:{ all -> 0x002e }
            r1 = 0
            if (r0 != 0) goto L_0x000a
            monitor-exit(r3)
            return r1
        L_0x000a:
            boolean r0 = r3.useRset     // Catch:{ Exception -> 0x0029 }
            if (r0 == 0) goto L_0x0014
            java.lang.String r0 = "RSET"
        L_0x0010:
            r3.sendCommand((java.lang.String) r0)     // Catch:{ Exception -> 0x0029 }
            goto L_0x0017
        L_0x0014:
            java.lang.String r0 = "NOOP"
            goto L_0x0010
        L_0x0017:
            int r0 = r3.readServerResponse()     // Catch:{ Exception -> 0x0029 }
            if (r0 < 0) goto L_0x0024
            r2 = 421(0x1a5, float:5.9E-43)
            if (r0 == r2) goto L_0x0024
            r0 = 1
            monitor-exit(r3)
            return r0
        L_0x0024:
            r3.closeConnection()     // Catch:{ MessagingException -> 0x0027 }
        L_0x0027:
            monitor-exit(r3)
            return r1
        L_0x0029:
            r3.closeConnection()     // Catch:{ MessagingException -> 0x002c }
        L_0x002c:
            monitor-exit(r3)
            return r1
        L_0x002e:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.smtp.SMTPTransport.isConnected():boolean");
    }

    public synchronized void issueCommand(String str, int i) throws MessagingException {
        sendCommand(str);
        if (readServerResponse() != i) {
            throw new MessagingException(this.lastServerResponse);
        }
    }

    /* access modifiers changed from: protected */
    public void mailFrom() throws MessagingException {
        Address[] from;
        String str = null;
        String envelopeFrom = this.message instanceof SMTPMessage ? ((SMTPMessage) this.message).getEnvelopeFrom() : null;
        if (envelopeFrom == null || envelopeFrom.length() <= 0) {
            envelopeFrom = this.session.getProperty("mail." + this.name + ".from");
        }
        if (envelopeFrom == null || envelopeFrom.length() <= 0) {
            Address localAddress = (this.message == null || (from = this.message.getFrom()) == null || from.length <= 0) ? InternetAddress.getLocalAddress(this.session) : from[0];
            if (localAddress != null) {
                envelopeFrom = ((InternetAddress) localAddress).getAddress();
            } else {
                throw new MessagingException("can't determine local email address");
            }
        }
        String str2 = "MAIL FROM:" + normalizeAddress(envelopeFrom);
        if (supportsExtension("DSN")) {
            String dSNRet = this.message instanceof SMTPMessage ? ((SMTPMessage) this.message).getDSNRet() : null;
            if (dSNRet == null) {
                dSNRet = this.session.getProperty("mail." + this.name + ".dsn.ret");
            }
            if (dSNRet != null) {
                str2 = String.valueOf(str2) + " RET=" + dSNRet;
            }
        }
        if (supportsExtension("AUTH")) {
            String submitter = this.message instanceof SMTPMessage ? ((SMTPMessage) this.message).getSubmitter() : null;
            if (submitter == null) {
                submitter = this.session.getProperty("mail." + this.name + ".submitter");
            }
            if (submitter != null) {
                try {
                    str2 = String.valueOf(str2) + " AUTH=" + xtext(submitter);
                } catch (IllegalArgumentException e) {
                    if (this.debug) {
                        this.out.println("DEBUG SMTP: ignoring invalid submitter: " + submitter + ", Exception: " + e);
                    }
                }
            }
        }
        if (this.message instanceof SMTPMessage) {
            str = ((SMTPMessage) this.message).getMailExtension();
        }
        if (str == null) {
            str = this.session.getProperty("mail." + this.name + ".mailextension");
        }
        if (str != null && str.length() > 0) {
            str2 = String.valueOf(str2) + s.a.f1696a + str;
        }
        issueSendCommand(str2, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01d7 A[Catch:{ all -> 0x01ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0262  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean protocolConnect(java.lang.String r17, int r18, java.lang.String r19, java.lang.String r20) throws javax.mail.MessagingException {
        /*
            r16 = this;
            r1 = r16
            javax.mail.Session r2 = r1.session
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r6 = "mail."
            r3.<init>(r6)
            java.lang.String r6 = r1.name
            r3.append(r6)
            java.lang.String r6 = ".ehlo"
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            java.lang.String r2 = r2.getProperty(r3)
            r8 = 1
            r9 = 0
            if (r2 == 0) goto L_0x002b
            java.lang.String r3 = "false"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x002b
            r2 = 0
            goto L_0x002c
        L_0x002b:
            r2 = 1
        L_0x002c:
            javax.mail.Session r3 = r1.session
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "mail."
            r6.<init>(r7)
            java.lang.String r7 = r1.name
            r6.append(r7)
            java.lang.String r7 = ".auth"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r3 = r3.getProperty(r6)
            if (r3 == 0) goto L_0x0053
            java.lang.String r6 = "true"
            boolean r3 = r3.equalsIgnoreCase(r6)
            if (r3 == 0) goto L_0x0053
            r3 = 1
            goto L_0x0054
        L_0x0053:
            r3 = 0
        L_0x0054:
            boolean r6 = r1.debug
            if (r6 == 0) goto L_0x0073
            java.io.PrintStream r6 = r1.out
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r10 = "DEBUG SMTP: useEhlo "
            r7.<init>(r10)
            r7.append(r2)
            java.lang.String r10 = ", useAuth "
            r7.append(r10)
            r7.append(r3)
            java.lang.String r7 = r7.toString()
            r6.println(r7)
        L_0x0073:
            if (r3 == 0) goto L_0x007a
            if (r19 == 0) goto L_0x0079
            if (r20 != 0) goto L_0x007a
        L_0x0079:
            return r9
        L_0x007a:
            r10 = -1
            r6 = r18
            if (r6 != r10) goto L_0x00a3
            javax.mail.Session r6 = r1.session
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r11 = "mail."
            r7.<init>(r11)
            java.lang.String r11 = r1.name
            r7.append(r11)
            java.lang.String r11 = ".port"
            r7.append(r11)
            java.lang.String r7 = r7.toString()
            java.lang.String r6 = r6.getProperty(r7)
            if (r6 == 0) goto L_0x00a1
            int r6 = java.lang.Integer.parseInt(r6)
            goto L_0x00a3
        L_0x00a1:
            int r6 = r1.defaultPort
        L_0x00a3:
            r7 = r6
            if (r17 == 0) goto L_0x00b0
            int r11 = r17.length()
            if (r11 != 0) goto L_0x00ad
            goto L_0x00b0
        L_0x00ad:
            r6 = r17
            goto L_0x00b2
        L_0x00b0:
            java.lang.String r6 = "localhost"
        L_0x00b2:
            java.net.Socket r11 = r1.serverSocket
            if (r11 == 0) goto L_0x00ba
            r16.openServer()
            goto L_0x00bd
        L_0x00ba:
            r1.openServer(r6, r7)
        L_0x00bd:
            if (r2 == 0) goto L_0x00c8
            java.lang.String r2 = r16.getLocalHost()
            boolean r2 = r1.ehlo(r2)
            goto L_0x00c9
        L_0x00c8:
            r2 = 0
        L_0x00c9:
            if (r2 != 0) goto L_0x00d2
            java.lang.String r2 = r16.getLocalHost()
            r1.helo(r2)
        L_0x00d2:
            boolean r2 = r1.useStartTLS
            if (r2 == 0) goto L_0x00e8
            java.lang.String r2 = "STARTTLS"
            boolean r2 = r1.supportsExtension(r2)
            if (r2 == 0) goto L_0x00e8
            r16.startTLS()
            java.lang.String r2 = r16.getLocalHost()
            r1.ehlo(r2)
        L_0x00e8:
            if (r3 != 0) goto L_0x00ee
            if (r19 == 0) goto L_0x0266
            if (r20 == 0) goto L_0x0266
        L_0x00ee:
            java.lang.String r2 = "AUTH"
            boolean r2 = r1.supportsExtension(r2)
            if (r2 != 0) goto L_0x00fe
            java.lang.String r2 = "AUTH=LOGIN"
            boolean r2 = r1.supportsExtension(r2)
            if (r2 == 0) goto L_0x0266
        L_0x00fe:
            boolean r2 = r1.debug
            if (r2 == 0) goto L_0x0120
            java.io.PrintStream r2 = r1.out
            java.lang.String r3 = "DEBUG SMTP: Attempt to authenticate"
            r2.println(r3)
            java.lang.String r2 = "LOGIN"
            boolean r2 = r1.supportsAuthentication(r2)
            if (r2 != 0) goto L_0x0120
            java.lang.String r2 = "AUTH=LOGIN"
            boolean r2 = r1.supportsExtension(r2)
            if (r2 == 0) goto L_0x0120
            java.io.PrintStream r2 = r1.out
            java.lang.String r3 = "DEBUG SMTP: use AUTH=LOGIN hack"
            r2.println(r3)
        L_0x0120:
            java.lang.String r2 = "LOGIN"
            boolean r2 = r1.supportsAuthentication(r2)
            r3 = 2147483647(0x7fffffff, float:NaN)
            r11 = 334(0x14e, float:4.68E-43)
            r12 = 235(0xeb, float:3.3E-43)
            if (r2 != 0) goto L_0x01fe
            java.lang.String r2 = "AUTH=LOGIN"
            boolean r2 = r1.supportsExtension(r2)
            if (r2 == 0) goto L_0x0139
            goto L_0x01fe
        L_0x0139:
            java.lang.String r2 = "PLAIN"
            boolean r2 = r1.supportsAuthentication(r2)
            if (r2 == 0) goto L_0x0188
            java.lang.String r2 = "AUTH PLAIN"
            int r2 = r1.simpleCommand((java.lang.String) r2)
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0182, all -> 0x0179 }
            r6.<init>()     // Catch:{ IOException -> 0x0182, all -> 0x0179 }
            com.sun.mail.util.BASE64EncoderStream r7 = new com.sun.mail.util.BASE64EncoderStream     // Catch:{ IOException -> 0x0182, all -> 0x0179 }
            r7.<init>(r6, r3)     // Catch:{ IOException -> 0x0182, all -> 0x0179 }
            if (r2 != r11) goto L_0x0173
            r7.write(r9)     // Catch:{ IOException -> 0x0182, all -> 0x0179 }
            byte[] r3 = com.sun.mail.util.ASCIIUtility.getBytes((java.lang.String) r19)     // Catch:{ IOException -> 0x0182, all -> 0x0179 }
            r7.write(r3)     // Catch:{ IOException -> 0x0182, all -> 0x0179 }
            r7.write(r9)     // Catch:{ IOException -> 0x0182, all -> 0x0179 }
            byte[] r3 = com.sun.mail.util.ASCIIUtility.getBytes((java.lang.String) r20)     // Catch:{ IOException -> 0x0182, all -> 0x0179 }
            r7.write(r3)     // Catch:{ IOException -> 0x0182, all -> 0x0179 }
            r7.flush()     // Catch:{ IOException -> 0x0182, all -> 0x0179 }
            byte[] r3 = r6.toByteArray()     // Catch:{ IOException -> 0x0182, all -> 0x0179 }
            int r3 = r1.simpleCommand((byte[]) r3)     // Catch:{ IOException -> 0x0182, all -> 0x0179 }
            r2 = r3
        L_0x0173:
            if (r2 == r12) goto L_0x0266
            r16.closeConnection()
            return r9
        L_0x0179:
            r0 = move-exception
            r3 = r0
            if (r2 == r12) goto L_0x0181
            r16.closeConnection()
            return r9
        L_0x0181:
            throw r3
        L_0x0182:
            if (r2 == r12) goto L_0x0266
            r16.closeConnection()
            return r9
        L_0x0188:
            java.lang.String r2 = "DIGEST-MD5"
            boolean r2 = r1.supportsAuthentication(r2)
            if (r2 == 0) goto L_0x0266
            com.sun.mail.smtp.DigestMD5 r13 = r16.getMD5()
            if (r13 == 0) goto L_0x0266
            java.lang.String r2 = "AUTH DIGEST-MD5"
            int r14 = r1.simpleCommand((java.lang.String) r2)
            if (r14 != r11) goto L_0x01f7
            java.lang.String r7 = r16.getSASLRealm()     // Catch:{ Exception -> 0x01d1 }
            java.lang.String r15 = r1.lastServerResponse     // Catch:{ Exception -> 0x01d1 }
            r2 = r13
            r3 = r6
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r15
            byte[] r2 = r2.authClient(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x01d1 }
            int r2 = r1.simpleCommand((byte[]) r2)     // Catch:{ Exception -> 0x01d1 }
            if (r2 != r11) goto L_0x01cc
            java.lang.String r3 = r1.lastServerResponse     // Catch:{ Exception -> 0x01c9, all -> 0x01c6 }
            boolean r3 = r13.authServer(r3)     // Catch:{ Exception -> 0x01c9, all -> 0x01c6 }
            if (r3 != 0) goto L_0x01bf
            goto L_0x01f8
        L_0x01bf:
            byte[] r3 = new byte[r9]     // Catch:{ Exception -> 0x01c9, all -> 0x01c6 }
            int r10 = r1.simpleCommand((byte[]) r3)     // Catch:{ Exception -> 0x01c9, all -> 0x01c6 }
            goto L_0x01f8
        L_0x01c6:
            r0 = move-exception
            r14 = r2
            goto L_0x01cf
        L_0x01c9:
            r0 = move-exception
            r14 = r2
            goto L_0x01d2
        L_0x01cc:
            r10 = r2
            goto L_0x01f8
        L_0x01ce:
            r0 = move-exception
        L_0x01cf:
            r2 = r0
            goto L_0x01f0
        L_0x01d1:
            r0 = move-exception
        L_0x01d2:
            r2 = r0
            boolean r3 = r1.debug     // Catch:{ all -> 0x01ce }
            if (r3 == 0) goto L_0x01ea
            java.io.PrintStream r3 = r1.out     // Catch:{ all -> 0x01ce }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ce }
            java.lang.String r5 = "DEBUG SMTP: DIGEST-MD5: "
            r4.<init>(r5)     // Catch:{ all -> 0x01ce }
            r4.append(r2)     // Catch:{ all -> 0x01ce }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x01ce }
            r3.println(r2)     // Catch:{ all -> 0x01ce }
        L_0x01ea:
            if (r14 == r12) goto L_0x0266
            r16.closeConnection()
            return r9
        L_0x01f0:
            if (r14 == r12) goto L_0x01f6
            r16.closeConnection()
            return r9
        L_0x01f6:
            throw r2
        L_0x01f7:
            r10 = r14
        L_0x01f8:
            if (r10 == r12) goto L_0x0266
            r16.closeConnection()
            return r9
        L_0x01fe:
            java.lang.String r2 = "AUTH LOGIN"
            int r2 = r1.simpleCommand((java.lang.String) r2)
            r6 = 530(0x212, float:7.43E-43)
            if (r2 != r6) goto L_0x0211
            r16.startTLS()
            java.lang.String r2 = "AUTH LOGIN"
            int r2 = r1.simpleCommand((java.lang.String) r2)
        L_0x0211:
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0260, all -> 0x0256 }
            r6.<init>()     // Catch:{ IOException -> 0x0260, all -> 0x0256 }
            com.sun.mail.util.BASE64EncoderStream r7 = new com.sun.mail.util.BASE64EncoderStream     // Catch:{ IOException -> 0x0260, all -> 0x0256 }
            r7.<init>(r6, r3)     // Catch:{ IOException -> 0x0260, all -> 0x0256 }
            if (r2 != r11) goto L_0x0238
            byte[] r3 = com.sun.mail.util.ASCIIUtility.getBytes((java.lang.String) r19)     // Catch:{ IOException -> 0x0260, all -> 0x0256 }
            r7.write(r3)     // Catch:{ IOException -> 0x0260, all -> 0x0256 }
            r7.flush()     // Catch:{ IOException -> 0x0260, all -> 0x0256 }
            byte[] r3 = r6.toByteArray()     // Catch:{ IOException -> 0x0260, all -> 0x0256 }
            int r3 = r1.simpleCommand((byte[]) r3)     // Catch:{ IOException -> 0x0260, all -> 0x0256 }
            r6.reset()     // Catch:{ IOException -> 0x0236, all -> 0x0234 }
            r2 = r3
            goto L_0x0238
        L_0x0234:
            r0 = move-exception
            goto L_0x0258
        L_0x0236:
            r2 = r3
            goto L_0x0260
        L_0x0238:
            if (r2 != r11) goto L_0x0250
            byte[] r3 = com.sun.mail.util.ASCIIUtility.getBytes((java.lang.String) r20)     // Catch:{ IOException -> 0x0260, all -> 0x0256 }
            r7.write(r3)     // Catch:{ IOException -> 0x0260, all -> 0x0256 }
            r7.flush()     // Catch:{ IOException -> 0x0260, all -> 0x0256 }
            byte[] r3 = r6.toByteArray()     // Catch:{ IOException -> 0x0260, all -> 0x0256 }
            int r3 = r1.simpleCommand((byte[]) r3)     // Catch:{ IOException -> 0x0260, all -> 0x0256 }
            r6.reset()     // Catch:{ IOException -> 0x0236, all -> 0x0234 }
            r2 = r3
        L_0x0250:
            if (r2 == r12) goto L_0x0266
            r16.closeConnection()
            return r9
        L_0x0256:
            r0 = move-exception
            r3 = r2
        L_0x0258:
            r2 = r0
            if (r3 == r12) goto L_0x025f
            r16.closeConnection()
            return r9
        L_0x025f:
            throw r2
        L_0x0260:
            if (r2 == r12) goto L_0x0266
            r16.closeConnection()
            return r9
        L_0x0266:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.smtp.SMTPTransport.protocolConnect(java.lang.String, int, java.lang.String, java.lang.String):boolean");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0228, code lost:
        r7.lastServerResponse = r1;
        r7.lastReturnCode = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x022c, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x029a, code lost:
        if (r14 == null) goto L_0x02f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02d5, code lost:
        if (r5 != false) goto L_0x02d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02d7, code lost:
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x02d8, code lost:
        r2.addElement(r12);
        r8 = new com.sun.mail.smtp.SMTPAddressFailedException(r12, r6, r15, r7.lastServerResponse);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x02e2, code lost:
        if (r14 != null) goto L_0x02e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x02e5, code lost:
        r14.setNextException(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02f7, code lost:
        if (r14 == null) goto L_0x02f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x02f9, code lost:
        r14 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0308, code lost:
        if (r14 == null) goto L_0x02f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x030b, code lost:
        r4 = r4 + 1;
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0203, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0204, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
        close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x020a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x020d, code lost:
        if (r7.debug != false) goto L_0x020f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x020f, code lost:
        r0.printStackTrace(r7.out);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:92:0x0206 */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x022d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void rcptTo() throws javax.mail.MessagingException {
        /*
            r19 = this;
            r7 = r19
            java.util.Vector r1 = new java.util.Vector
            r1.<init>()
            java.util.Vector r2 = new java.util.Vector
            r2.<init>()
            java.util.Vector r3 = new java.util.Vector
            r3.<init>()
            r4 = 0
            r7.invalidAddr = r4
            r7.validUnsentAddr = r4
            r7.validSentAddr = r4
            javax.mail.internet.MimeMessage r5 = r7.message
            boolean r5 = r5 instanceof com.sun.mail.smtp.SMTPMessage
            if (r5 == 0) goto L_0x0027
            javax.mail.internet.MimeMessage r5 = r7.message
            com.sun.mail.smtp.SMTPMessage r5 = (com.sun.mail.smtp.SMTPMessage) r5
            boolean r5 = r5.getSendPartial()
            goto L_0x0028
        L_0x0027:
            r5 = 0
        L_0x0028:
            r8 = 1
            if (r5 != 0) goto L_0x0053
            javax.mail.Session r5 = r7.session
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "mail."
            r9.<init>(r10)
            java.lang.String r10 = r7.name
            r9.append(r10)
            java.lang.String r10 = ".sendpartial"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.String r5 = r5.getProperty(r9)
            if (r5 == 0) goto L_0x0052
            java.lang.String r9 = "true"
            boolean r5 = r5.equalsIgnoreCase(r9)
            if (r5 == 0) goto L_0x0052
            r5 = 1
            goto L_0x0053
        L_0x0052:
            r5 = 0
        L_0x0053:
            boolean r9 = r7.debug
            if (r9 == 0) goto L_0x0060
            if (r5 == 0) goto L_0x0060
            java.io.PrintStream r9 = r7.out
            java.lang.String r10 = "DEBUG SMTP: sendPartial set"
            r9.println(r10)
        L_0x0060:
            java.lang.String r9 = "DSN"
            boolean r9 = r7.supportsExtension(r9)
            if (r9 == 0) goto L_0x009c
            javax.mail.internet.MimeMessage r9 = r7.message
            boolean r9 = r9 instanceof com.sun.mail.smtp.SMTPMessage
            if (r9 == 0) goto L_0x0077
            javax.mail.internet.MimeMessage r9 = r7.message
            com.sun.mail.smtp.SMTPMessage r9 = (com.sun.mail.smtp.SMTPMessage) r9
            java.lang.String r9 = r9.getDSNNotify()
            goto L_0x0078
        L_0x0077:
            r9 = r4
        L_0x0078:
            if (r9 != 0) goto L_0x0095
            javax.mail.Session r9 = r7.session
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "mail."
            r10.<init>(r11)
            java.lang.String r11 = r7.name
            r10.append(r11)
            java.lang.String r11 = ".dsn.notify"
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            java.lang.String r9 = r9.getProperty(r10)
        L_0x0095:
            if (r9 == 0) goto L_0x009a
            r10 = r9
            r9 = 1
            goto L_0x009e
        L_0x009a:
            r10 = r9
            goto L_0x009d
        L_0x009c:
            r10 = r4
        L_0x009d:
            r9 = 0
        L_0x009e:
            r14 = r4
            r4 = 0
            r11 = 0
        L_0x00a1:
            javax.mail.Address[] r12 = r7.addresses
            int r12 = r12.length
            r13 = 250(0xfa, float:3.5E-43)
            if (r4 < r12) goto L_0x022e
            if (r5 == 0) goto L_0x00b1
            int r4 = r1.size()
            if (r4 != 0) goto L_0x00b1
            r11 = 1
        L_0x00b1:
            if (r11 == 0) goto L_0x00fd
            int r4 = r3.size()
            javax.mail.Address[] r4 = new javax.mail.Address[r4]
            r7.invalidAddr = r4
            javax.mail.Address[] r4 = r7.invalidAddr
            r3.copyInto(r4)
            int r3 = r1.size()
            int r4 = r2.size()
            int r3 = r3 + r4
            javax.mail.Address[] r3 = new javax.mail.Address[r3]
            r7.validUnsentAddr = r3
            r3 = 0
            r4 = 0
        L_0x00cf:
            int r5 = r1.size()
            if (r3 < r5) goto L_0x00ed
            r1 = 0
        L_0x00d6:
            int r3 = r2.size()
            if (r1 < r3) goto L_0x00dd
            goto L_0x0140
        L_0x00dd:
            javax.mail.Address[] r3 = r7.validUnsentAddr
            int r5 = r4 + 1
            java.lang.Object r8 = r2.elementAt(r1)
            javax.mail.Address r8 = (javax.mail.Address) r8
            r3[r4] = r8
            int r1 = r1 + 1
            r4 = r5
            goto L_0x00d6
        L_0x00ed:
            javax.mail.Address[] r5 = r7.validUnsentAddr
            int r8 = r4 + 1
            java.lang.Object r9 = r1.elementAt(r3)
            javax.mail.Address r9 = (javax.mail.Address) r9
            r5[r4] = r9
            int r3 = r3 + 1
            r4 = r8
            goto L_0x00cf
        L_0x00fd:
            boolean r4 = r7.reportSuccess
            if (r4 != 0) goto L_0x0115
            if (r5 == 0) goto L_0x0110
            int r4 = r3.size()
            if (r4 > 0) goto L_0x0115
            int r4 = r2.size()
            if (r4 <= 0) goto L_0x0110
            goto L_0x0115
        L_0x0110:
            javax.mail.Address[] r1 = r7.addresses
            r7.validSentAddr = r1
            goto L_0x0140
        L_0x0115:
            r7.sendPartiallyFailed = r8
            r7.exception = r14
            int r4 = r3.size()
            javax.mail.Address[] r4 = new javax.mail.Address[r4]
            r7.invalidAddr = r4
            javax.mail.Address[] r4 = r7.invalidAddr
            r3.copyInto(r4)
            int r3 = r2.size()
            javax.mail.Address[] r3 = new javax.mail.Address[r3]
            r7.validUnsentAddr = r3
            javax.mail.Address[] r3 = r7.validUnsentAddr
            r2.copyInto(r3)
            int r2 = r1.size()
            javax.mail.Address[] r2 = new javax.mail.Address[r2]
            r7.validSentAddr = r2
            javax.mail.Address[] r2 = r7.validSentAddr
            r1.copyInto(r2)
        L_0x0140:
            boolean r1 = r7.debug
            if (r1 == 0) goto L_0x01d7
            javax.mail.Address[] r1 = r7.validSentAddr
            if (r1 == 0) goto L_0x0175
            javax.mail.Address[] r1 = r7.validSentAddr
            int r1 = r1.length
            if (r1 <= 0) goto L_0x0175
            java.io.PrintStream r1 = r7.out
            java.lang.String r2 = "DEBUG SMTP: Verified Addresses"
            r1.println(r2)
            r1 = 0
        L_0x0155:
            javax.mail.Address[] r2 = r7.validSentAddr
            int r2 = r2.length
            if (r1 < r2) goto L_0x015b
            goto L_0x0175
        L_0x015b:
            java.io.PrintStream r2 = r7.out
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "DEBUG SMTP:   "
            r3.<init>(r4)
            javax.mail.Address[] r4 = r7.validSentAddr
            r4 = r4[r1]
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.println(r3)
            int r1 = r1 + 1
            goto L_0x0155
        L_0x0175:
            javax.mail.Address[] r1 = r7.validUnsentAddr
            if (r1 == 0) goto L_0x01a6
            javax.mail.Address[] r1 = r7.validUnsentAddr
            int r1 = r1.length
            if (r1 <= 0) goto L_0x01a6
            java.io.PrintStream r1 = r7.out
            java.lang.String r2 = "DEBUG SMTP: Valid Unsent Addresses"
            r1.println(r2)
            r1 = 0
        L_0x0186:
            javax.mail.Address[] r2 = r7.validUnsentAddr
            int r2 = r2.length
            if (r1 < r2) goto L_0x018c
            goto L_0x01a6
        L_0x018c:
            java.io.PrintStream r2 = r7.out
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "DEBUG SMTP:   "
            r3.<init>(r4)
            javax.mail.Address[] r4 = r7.validUnsentAddr
            r4 = r4[r1]
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.println(r3)
            int r1 = r1 + 1
            goto L_0x0186
        L_0x01a6:
            javax.mail.Address[] r1 = r7.invalidAddr
            if (r1 == 0) goto L_0x01d7
            javax.mail.Address[] r1 = r7.invalidAddr
            int r1 = r1.length
            if (r1 <= 0) goto L_0x01d7
            java.io.PrintStream r1 = r7.out
            java.lang.String r2 = "DEBUG SMTP: Invalid Addresses"
            r1.println(r2)
            r6 = 0
        L_0x01b7:
            javax.mail.Address[] r1 = r7.invalidAddr
            int r1 = r1.length
            if (r6 < r1) goto L_0x01bd
            goto L_0x01d7
        L_0x01bd:
            java.io.PrintStream r1 = r7.out
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "DEBUG SMTP:   "
            r2.<init>(r3)
            javax.mail.Address[] r3 = r7.invalidAddr
            r3 = r3[r6]
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.println(r2)
            int r6 = r6 + 1
            goto L_0x01b7
        L_0x01d7:
            if (r11 == 0) goto L_0x022d
            boolean r1 = r7.debug
            if (r1 == 0) goto L_0x01e4
            java.io.PrintStream r1 = r7.out
            java.lang.String r2 = "DEBUG SMTP: Sending failed because of invalid destination addresses"
            r1.println(r2)
        L_0x01e4:
            r2 = 2
            javax.mail.Address[] r3 = r7.validSentAddr
            javax.mail.Address[] r4 = r7.validUnsentAddr
            javax.mail.Address[] r5 = r7.invalidAddr
            javax.mail.internet.MimeMessage r6 = r7.message
            r1 = r7
            r1.notifyTransportListeners(r2, r3, r4, r5, r6)
            java.lang.String r1 = r7.lastServerResponse
            int r2 = r7.lastReturnCode
            java.net.Socket r3 = r7.serverSocket     // Catch:{ MessagingException -> 0x0206 }
            if (r3 == 0) goto L_0x01fe
            java.lang.String r3 = "RSET"
            r7.issueCommand(r3, r13)     // Catch:{ MessagingException -> 0x0206 }
        L_0x01fe:
            r7.lastServerResponse = r1
            r7.lastReturnCode = r2
            goto L_0x0215
        L_0x0203:
            r0 = move-exception
            r3 = r0
            goto L_0x0228
        L_0x0206:
            r19.close()     // Catch:{ MessagingException -> 0x020a }
            goto L_0x01fe
        L_0x020a:
            r0 = move-exception
            boolean r3 = r7.debug     // Catch:{ all -> 0x0203 }
            if (r3 == 0) goto L_0x01fe
            java.io.PrintStream r3 = r7.out     // Catch:{ all -> 0x0203 }
            r0.printStackTrace(r3)     // Catch:{ all -> 0x0203 }
            goto L_0x01fe
        L_0x0215:
            javax.mail.SendFailedException r1 = new javax.mail.SendFailedException
            java.lang.String r13 = "Invalid Addresses"
            javax.mail.Address[] r15 = r7.validSentAddr
            javax.mail.Address[] r2 = r7.validUnsentAddr
            javax.mail.Address[] r3 = r7.invalidAddr
            r12 = r1
            r16 = r2
            r17 = r3
            r12.<init>(r13, r14, r15, r16, r17)
            throw r1
        L_0x0228:
            r7.lastServerResponse = r1
            r7.lastReturnCode = r2
            throw r3
        L_0x022d:
            return
        L_0x022e:
            javax.mail.Address[] r12 = r7.addresses
            r12 = r12[r4]
            javax.mail.internet.InternetAddress r12 = (javax.mail.internet.InternetAddress) r12
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r6 = "RCPT TO:"
            r15.<init>(r6)
            java.lang.String r6 = r12.getAddress()
            java.lang.String r6 = r7.normalizeAddress(r6)
            r15.append(r6)
            java.lang.String r6 = r15.toString()
            if (r9 == 0) goto L_0x0261
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r15.<init>(r6)
            java.lang.String r6 = " NOTIFY="
            r15.append(r6)
            r15.append(r10)
            java.lang.String r6 = r15.toString()
        L_0x0261:
            r7.sendCommand((java.lang.String) r6)
            int r15 = r19.readServerResponse()
            r8 = 501(0x1f5, float:7.02E-43)
            if (r15 == r8) goto L_0x02fb
            r8 = 503(0x1f7, float:7.05E-43)
            if (r15 == r8) goto L_0x02fb
            switch(r15) {
                case 250: goto L_0x02e9;
                case 251: goto L_0x02e9;
                default: goto L_0x0273;
            }
        L_0x0273:
            switch(r15) {
                case 450: goto L_0x02d5;
                case 451: goto L_0x02d5;
                case 452: goto L_0x02d5;
                default: goto L_0x0276;
            }
        L_0x0276:
            switch(r15) {
                case 550: goto L_0x02fb;
                case 551: goto L_0x02fb;
                case 552: goto L_0x02d5;
                case 553: goto L_0x02fb;
                default: goto L_0x0279;
            }
        L_0x0279:
            r8 = 400(0x190, float:5.6E-43)
            if (r15 < r8) goto L_0x0285
            r8 = 499(0x1f3, float:6.99E-43)
            if (r15 > r8) goto L_0x0285
            r2.addElement(r12)
            goto L_0x0290
        L_0x0285:
            r8 = 500(0x1f4, float:7.0E-43)
            if (r15 < r8) goto L_0x029d
            r8 = 599(0x257, float:8.4E-43)
            if (r15 > r8) goto L_0x029d
            r3.addElement(r12)
        L_0x0290:
            if (r5 != 0) goto L_0x0293
            r11 = 1
        L_0x0293:
            com.sun.mail.smtp.SMTPAddressFailedException r8 = new com.sun.mail.smtp.SMTPAddressFailedException
            java.lang.String r13 = r7.lastServerResponse
            r8.<init>(r12, r6, r15, r13)
            if (r14 != 0) goto L_0x02e5
            goto L_0x02f9
        L_0x029d:
            boolean r1 = r7.debug
            if (r1 == 0) goto L_0x02be
            java.io.PrintStream r1 = r7.out
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "DEBUG SMTP: got response code "
            r2.<init>(r3)
            r2.append(r15)
            java.lang.String r3 = ", with response: "
            r2.append(r3)
            java.lang.String r3 = r7.lastServerResponse
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.println(r2)
        L_0x02be:
            java.lang.String r1 = r7.lastServerResponse
            int r2 = r7.lastReturnCode
            java.net.Socket r3 = r7.serverSocket
            if (r3 == 0) goto L_0x02cb
            java.lang.String r3 = "RSET"
            r7.issueCommand(r3, r13)
        L_0x02cb:
            r7.lastServerResponse = r1
            r7.lastReturnCode = r2
            com.sun.mail.smtp.SMTPAddressFailedException r2 = new com.sun.mail.smtp.SMTPAddressFailedException
            r2.<init>(r12, r6, r15, r1)
            throw r2
        L_0x02d5:
            if (r5 != 0) goto L_0x02d8
            r11 = 1
        L_0x02d8:
            r2.addElement(r12)
            com.sun.mail.smtp.SMTPAddressFailedException r8 = new com.sun.mail.smtp.SMTPAddressFailedException
            java.lang.String r13 = r7.lastServerResponse
            r8.<init>(r12, r6, r15, r13)
            if (r14 != 0) goto L_0x02e5
            goto L_0x02f9
        L_0x02e5:
            r14.setNextException(r8)
            goto L_0x030b
        L_0x02e9:
            r1.addElement(r12)
            boolean r8 = r7.reportSuccess
            if (r8 == 0) goto L_0x030b
            com.sun.mail.smtp.SMTPAddressSucceededException r8 = new com.sun.mail.smtp.SMTPAddressSucceededException
            java.lang.String r13 = r7.lastServerResponse
            r8.<init>(r12, r6, r15, r13)
            if (r14 != 0) goto L_0x02e5
        L_0x02f9:
            r14 = r8
            goto L_0x030b
        L_0x02fb:
            if (r5 != 0) goto L_0x02fe
            r11 = 1
        L_0x02fe:
            r3.addElement(r12)
            com.sun.mail.smtp.SMTPAddressFailedException r8 = new com.sun.mail.smtp.SMTPAddressFailedException
            java.lang.String r13 = r7.lastServerResponse
            r8.<init>(r12, r6, r15, r13)
            if (r14 != 0) goto L_0x02e5
            goto L_0x02f9
        L_0x030b:
            int r4 = r4 + 1
            r8 = 1
            goto L_0x00a1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.smtp.SMTPTransport.rcptTo():void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0061, code lost:
        r1 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0064, code lost:
        if (r6.debug == false) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0066, code lost:
        r1.printStackTrace(r6.out);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0070, code lost:
        r1 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0073, code lost:
        if (r6.debug == false) goto L_0x0076;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:20:0x005d, B:26:0x006c] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x005d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x006c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int readServerResponse() throws javax.mail.MessagingException {
        /*
            r6 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r1 = 100
            r0.<init>(r1)
        L_0x0007:
            r1 = 0
            com.sun.mail.util.LineInputStream r2 = r6.lineInputStream     // Catch:{ IOException -> 0x0095 }
            java.lang.String r2 = r2.readLine()     // Catch:{ IOException -> 0x0095 }
            r3 = -1
            if (r2 != 0) goto L_0x0039
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0095 }
            int r2 = r0.length()     // Catch:{ IOException -> 0x0095 }
            if (r2 != 0) goto L_0x001d
            java.lang.String r0 = "[EOF]"
        L_0x001d:
            r6.lastServerResponse = r0     // Catch:{ IOException -> 0x0095 }
            r6.lastReturnCode = r3     // Catch:{ IOException -> 0x0095 }
            boolean r2 = r6.debug     // Catch:{ IOException -> 0x0095 }
            if (r2 == 0) goto L_0x0038
            java.io.PrintStream r2 = r6.out     // Catch:{ IOException -> 0x0095 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0095 }
            java.lang.String r5 = "DEBUG SMTP: EOF: "
            r4.<init>(r5)     // Catch:{ IOException -> 0x0095 }
            r4.append(r0)     // Catch:{ IOException -> 0x0095 }
            java.lang.String r0 = r4.toString()     // Catch:{ IOException -> 0x0095 }
            r2.println(r0)     // Catch:{ IOException -> 0x0095 }
        L_0x0038:
            return r3
        L_0x0039:
            r0.append(r2)     // Catch:{ IOException -> 0x0095 }
            java.lang.String r4 = "\n"
            r0.append(r4)     // Catch:{ IOException -> 0x0095 }
            boolean r2 = r6.isNotLastLine(r2)     // Catch:{ IOException -> 0x0095 }
            if (r2 != 0) goto L_0x0007
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0095 }
            if (r0 == 0) goto L_0x0076
            int r2 = r0.length()
            r4 = 3
            if (r2 < r4) goto L_0x0076
            java.lang.String r1 = r0.substring(r1, r4)     // Catch:{ NumberFormatException -> 0x006c, StringIndexOutOfBoundsException -> 0x005d }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x006c, StringIndexOutOfBoundsException -> 0x005d }
            goto L_0x0077
        L_0x005d:
            r6.close()     // Catch:{ MessagingException -> 0x0061 }
            goto L_0x0076
        L_0x0061:
            r1 = move-exception
            boolean r2 = r6.debug
            if (r2 == 0) goto L_0x0076
        L_0x0066:
            java.io.PrintStream r2 = r6.out
            r1.printStackTrace(r2)
            goto L_0x0076
        L_0x006c:
            r6.close()     // Catch:{ MessagingException -> 0x0070 }
            goto L_0x0076
        L_0x0070:
            r1 = move-exception
            boolean r2 = r6.debug
            if (r2 == 0) goto L_0x0076
            goto L_0x0066
        L_0x0076:
            r1 = -1
        L_0x0077:
            if (r1 != r3) goto L_0x0090
            boolean r2 = r6.debug
            if (r2 == 0) goto L_0x0090
            java.io.PrintStream r2 = r6.out
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "DEBUG SMTP: bad server response: "
            r3.<init>(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            r2.println(r3)
        L_0x0090:
            r6.lastServerResponse = r0
            r6.lastReturnCode = r1
            return r1
        L_0x0095:
            r0 = move-exception
            boolean r2 = r6.debug
            if (r2 == 0) goto L_0x00ad
            java.io.PrintStream r2 = r6.out
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "DEBUG SMTP: exception reading response: "
            r3.<init>(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            r2.println(r3)
        L_0x00ad:
            java.lang.String r2 = ""
            r6.lastServerResponse = r2
            r6.lastReturnCode = r1
            javax.mail.MessagingException r1 = new javax.mail.MessagingException
            java.lang.String r2 = "Exception reading response"
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.smtp.SMTPTransport.readServerResponse():int");
    }

    /* access modifiers changed from: protected */
    public void sendCommand(String str) throws MessagingException {
        sendCommand(ASCIIUtility.getBytes(str));
    }

    public synchronized void sendMessage(Message message2, Address[] addressArr) throws MessagingException, SendFailedException {
        Message message3 = message2;
        Address[] addressArr2 = addressArr;
        synchronized (this) {
            try {
                checkConnected();
                if (!(message3 instanceof MimeMessage)) {
                    if (this.debug) {
                        this.out.println("DEBUG SMTP: Can only send RFC822 msgs");
                    }
                    throw new MessagingException("SMTP can only send RFC822 messages");
                }
                for (int i = 0; i < addressArr2.length; i++) {
                    if (!(addressArr2[i] instanceof InternetAddress)) {
                        throw new MessagingException(addressArr2[i] + " is not an InternetAddress");
                    }
                }
                this.message = (MimeMessage) message3;
                this.addresses = addressArr2;
                this.validUnsentAddr = addressArr2;
                expandGroups();
                boolean allow8bitMIME = message3 instanceof SMTPMessage ? ((SMTPMessage) message3).getAllow8bitMIME() : false;
                if (!allow8bitMIME) {
                    Session session = this.session;
                    String property = session.getProperty("mail." + this.name + ".allow8bitmime");
                    allow8bitMIME = property != null && property.equalsIgnoreCase("true");
                }
                if (this.debug) {
                    PrintStream printStream = this.out;
                    printStream.println("DEBUG SMTP: use8bit " + allow8bitMIME);
                }
                if (allow8bitMIME && supportsExtension("8BITMIME") && convertTo8Bit(this.message)) {
                    try {
                        this.message.saveChanges();
                    } catch (MessagingException unused) {
                    }
                }
                mailFrom();
                rcptTo();
                this.message.writeTo(data(), ignoreList);
                finishData();
                if (this.sendPartiallyFailed) {
                    if (this.debug) {
                        this.out.println("DEBUG SMTP: Sending partially failed because of invalid destination addresses");
                    }
                    notifyTransportListeners(3, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                    throw new SMTPSendFailedException(".", this.lastReturnCode, this.lastServerResponse, this.exception, this.validSentAddr, this.validUnsentAddr, this.invalidAddr);
                }
                notifyTransportListeners(1, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                this.invalidAddr = null;
                this.validUnsentAddr = null;
                this.validSentAddr = null;
                this.addresses = null;
                this.message = null;
                this.exception = null;
                this.sendPartiallyFailed = false;
            } catch (MessagingException e) {
                MessagingException messagingException = e;
                if (this.debug) {
                    messagingException.printStackTrace(this.out);
                }
                notifyTransportListeners(2, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                throw messagingException;
            } catch (IOException e2) {
                IOException iOException = e2;
                if (this.debug) {
                    iOException.printStackTrace(this.out);
                }
                try {
                    closeConnection();
                } catch (MessagingException unused2) {
                }
                notifyTransportListeners(2, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                throw new MessagingException("IOException while sending message", iOException);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void setLocalHost(String str) {
        this.localHostName = str;
    }

    public synchronized void setReportSuccess(boolean z) {
        this.reportSuccess = z;
    }

    public synchronized void setSASLRealm(String str) {
        this.saslRealm = str;
    }

    public synchronized void setStartTLS(boolean z) {
        this.useStartTLS = z;
    }

    public synchronized void setUseRset(boolean z) {
        this.useRset = z;
    }

    public synchronized int simpleCommand(String str) throws MessagingException {
        sendCommand(str);
        return readServerResponse();
    }

    /* access modifiers changed from: protected */
    public int simpleCommand(byte[] bArr) throws MessagingException {
        sendCommand(bArr);
        return readServerResponse();
    }

    /* access modifiers changed from: protected */
    public void startTLS() throws MessagingException {
        issueCommand("STARTTLS", 220);
        try {
            Socket socket = this.serverSocket;
            Properties properties = this.session.getProperties();
            this.serverSocket = SocketFetcher.startTLS(socket, properties, "mail." + this.name);
            initStreams();
        } catch (IOException e) {
            closeConnection();
            throw new MessagingException("Could not convert socket to TLS", e);
        }
    }

    /* access modifiers changed from: protected */
    public boolean supportsAuthentication(String str) {
        String str2;
        if (this.extMap == null || (str2 = (String) this.extMap.get("AUTH")) == null) {
            return false;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str2);
        while (stringTokenizer.hasMoreTokens()) {
            if (stringTokenizer.nextToken().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean supportsExtension(String str) {
        return (this.extMap == null || this.extMap.get(str.toUpperCase(Locale.ENGLISH)) == null) ? false : true;
    }
}
