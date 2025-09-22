package com.sun.mail.imap.protocol;

import android.support.v7.widget.ActivityChooserView;
import com.github.kevinsawicki.http.HttpRequest;
import com.sun.mail.iap.Argument;
import com.sun.mail.iap.BadCommandException;
import com.sun.mail.iap.ByteArray;
import com.sun.mail.iap.CommandFailedException;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.Literal;
import com.sun.mail.iap.LiteralException;
import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.Protocol;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.imap.ACL;
import com.sun.mail.imap.AppendUID;
import com.sun.mail.imap.Rights;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64EncoderStream;
import com.umeng.commonsdk.proguard.bg;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import javax.mail.Flags;
import javax.mail.Quota;
import javax.mail.internet.MimeUtility;
import javax.mail.search.SearchException;
import javax.mail.search.SearchTerm;
import org.slf4j.Marker;

public class IMAPProtocol extends Protocol {
    private static final byte[] CRLF = {bg.k, 10};
    private static final byte[] DONE = {68, 79, 78, 69, bg.k, 10};
    private boolean authenticated;
    private List authmechs = null;
    private ByteArray ba;
    private Map capabilities = null;
    private boolean connected = false;
    private String idleTag;
    private String name;
    private boolean rev1 = false;
    private SaslAuthenticator saslAuthenticator;
    private String[] searchCharsets;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public IMAPProtocol(java.lang.String r12, java.lang.String r13, int r14, boolean r15, java.io.PrintStream r16, java.util.Properties r17, boolean r18) throws java.io.IOException, com.sun.mail.iap.ProtocolException {
        /*
            r11 = this;
            r9 = r11
            r10 = r12
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "mail."
            r1.<init>(r2)
            r1.append(r10)
            java.lang.String r7 = r1.toString()
            r1 = r9
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r8 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r1 = 0
            r9.connected = r1
            r9.rev1 = r1
            r2 = 0
            r9.capabilities = r2
            r9.authmechs = r2
            r9.name = r10     // Catch:{ all -> 0x005c }
            java.util.Map r2 = r9.capabilities     // Catch:{ all -> 0x005c }
            if (r2 != 0) goto L_0x0030
            r9.capability()     // Catch:{ all -> 0x005c }
        L_0x0030:
            java.lang.String r2 = "IMAP4rev1"
            boolean r2 = r9.hasCapability(r2)     // Catch:{ all -> 0x005c }
            r3 = 1
            if (r2 == 0) goto L_0x003b
            r9.rev1 = r3     // Catch:{ all -> 0x005c }
        L_0x003b:
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ all -> 0x005c }
            r9.searchCharsets = r2     // Catch:{ all -> 0x005c }
            java.lang.String[] r2 = r9.searchCharsets     // Catch:{ all -> 0x005c }
            java.lang.String r4 = "UTF-8"
            r2[r1] = r4     // Catch:{ all -> 0x005c }
            java.lang.String[] r1 = r9.searchCharsets     // Catch:{ all -> 0x005c }
            java.lang.String r2 = javax.mail.internet.MimeUtility.getDefaultJavaCharset()     // Catch:{ all -> 0x005c }
            java.lang.String r2 = javax.mail.internet.MimeUtility.mimeCharset(r2)     // Catch:{ all -> 0x005c }
            r1[r3] = r2     // Catch:{ all -> 0x005c }
            r9.connected = r3     // Catch:{ all -> 0x005c }
            boolean r1 = r9.connected
            if (r1 != 0) goto L_0x005b
            r9.disconnect()
        L_0x005b:
            return
        L_0x005c:
            r0 = move-exception
            r1 = r0
            boolean r2 = r9.connected
            if (r2 != 0) goto L_0x0065
            r9.disconnect()
        L_0x0065:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.protocol.IMAPProtocol.<init>(java.lang.String, java.lang.String, int, boolean, java.io.PrintStream, java.util.Properties, boolean):void");
    }

    private void copy(String str, String str2) throws ProtocolException {
        String encode = BASE64MailboxEncoder.encode(str2);
        Argument argument = new Argument();
        argument.writeAtom(str);
        argument.writeString(encode);
        simpleCommand("COPY", argument);
    }

    private String createFlagList(Flags flags) {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("(");
        Flags.Flag[] systemFlags = flags.getSystemFlags();
        boolean z = true;
        for (Flags.Flag flag : systemFlags) {
            if (flag == Flags.Flag.ANSWERED) {
                str = "\\Answered";
            } else if (flag == Flags.Flag.DELETED) {
                str = "\\Deleted";
            } else if (flag == Flags.Flag.DRAFT) {
                str = "\\Draft";
            } else if (flag == Flags.Flag.FLAGGED) {
                str = "\\Flagged";
            } else if (flag == Flags.Flag.RECENT) {
                str = "\\Recent";
            } else if (flag == Flags.Flag.SEEN) {
                str = "\\Seen";
            }
            if (z) {
                z = false;
            } else {
                stringBuffer.append(' ');
            }
            stringBuffer.append(str);
        }
        String[] userFlags = flags.getUserFlags();
        for (String append : userFlags) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append(' ');
            }
            stringBuffer.append(append);
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    private ListInfo[] doList(String str, String str2, String str3) throws ProtocolException {
        String encode = BASE64MailboxEncoder.encode(str2);
        String encode2 = BASE64MailboxEncoder.encode(str3);
        Argument argument = new Argument();
        argument.writeString(encode);
        argument.writeString(encode2);
        Response[] command = command(str, argument);
        Response response = command[command.length - 1];
        ListInfo[] listInfoArr = null;
        if (response.isOK()) {
            Vector vector = new Vector(1);
            int length = command.length;
            for (int i = 0; i < length; i++) {
                if (command[i] instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) command[i];
                    if (iMAPResponse.keyEquals(str)) {
                        vector.addElement(new ListInfo(iMAPResponse));
                        command[i] = null;
                    }
                }
            }
            if (vector.size() > 0) {
                listInfoArr = new ListInfo[vector.size()];
                vector.copyInto(listInfoArr);
            }
        }
        notifyResponseHandlers(command);
        handleResult(response);
        return listInfoArr;
    }

    private Response[] fetch(String str, String str2, boolean z) throws ProtocolException {
        StringBuilder sb = z ? new StringBuilder("UID FETCH ") : new StringBuilder("FETCH ");
        sb.append(str);
        sb.append(" (");
        sb.append(str2);
        sb.append(")");
        return command(sb.toString(), (Argument) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.sun.mail.imap.AppendUID getAppendUID(com.sun.mail.iap.Response r5) {
        /*
            r4 = this;
            boolean r0 = r5.isOK()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            byte r0 = r5.readByte()
            if (r0 <= 0) goto L_0x0012
            r2 = 91
            if (r0 != r2) goto L_0x0008
        L_0x0012:
            if (r0 != 0) goto L_0x0015
            return r1
        L_0x0015:
            java.lang.String r0 = r5.readAtom()
            java.lang.String r2 = "APPENDUID"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 != 0) goto L_0x0022
            return r1
        L_0x0022:
            long r0 = r5.readLong()
            long r2 = r5.readLong()
            com.sun.mail.imap.AppendUID r5 = new com.sun.mail.imap.AppendUID
            r5.<init>(r0, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.protocol.IMAPProtocol.getAppendUID(com.sun.mail.iap.Response):com.sun.mail.imap.AppendUID");
    }

    private int[] issueSearch(String str, SearchTerm searchTerm, String str2) throws ProtocolException, SearchException, IOException {
        String str3;
        int[] iArr = null;
        Argument generateSequence = SearchSequence.generateSequence(searchTerm, str2 == null ? null : MimeUtility.javaCharset(str2));
        generateSequence.writeAtom(str);
        if (str2 == null) {
            str3 = "SEARCH";
        } else {
            str3 = "SEARCH CHARSET " + str2;
        }
        Response[] command = command(str3, generateSequence);
        Response response = command[command.length - 1];
        if (response.isOK()) {
            Vector vector = new Vector();
            int length = command.length;
            for (int i = 0; i < length; i++) {
                if (command[i] instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) command[i];
                    if (iMAPResponse.keyEquals("SEARCH")) {
                        while (true) {
                            int readNumber = iMAPResponse.readNumber();
                            if (readNumber == -1) {
                                break;
                            }
                            vector.addElement(new Integer(readNumber));
                        }
                        command[i] = null;
                    }
                }
            }
            int size = vector.size();
            int[] iArr2 = new int[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr2[i2] = ((Integer) vector.elementAt(i2)).intValue();
            }
            iArr = iArr2;
        }
        notifyResponseHandlers(command);
        handleResult(response);
        return iArr;
    }

    private Quota parseQuota(Response response) throws ParsingException {
        Quota quota = new Quota(response.readAtomString());
        response.skipSpaces();
        if (response.readByte() != 40) {
            throw new ParsingException("parse error in QUOTA");
        }
        Vector vector = new Vector();
        while (response.peekByte() != 41) {
            String readAtom = response.readAtom();
            if (readAtom != null) {
                vector.addElement(new Quota.Resource(readAtom, response.readLong(), response.readLong()));
            }
        }
        response.readByte();
        quota.resources = new Quota.Resource[vector.size()];
        vector.copyInto(quota.resources);
        return quota;
    }

    private int[] search(String str, SearchTerm searchTerm) throws ProtocolException, SearchException {
        if (SearchSequence.isAscii(searchTerm)) {
            try {
                return issueSearch(str, searchTerm, (String) null);
            } catch (IOException unused) {
            }
        }
        int i = 0;
        while (i < this.searchCharsets.length) {
            if (this.searchCharsets[i] != null) {
                try {
                    return issueSearch(str, searchTerm, this.searchCharsets[i]);
                } catch (CommandFailedException unused2) {
                    this.searchCharsets[i] = null;
                } catch (IOException unused3) {
                } catch (ProtocolException e) {
                    throw e;
                } catch (SearchException e2) {
                    throw e2;
                }
            } else {
                i++;
            }
        }
        throw new SearchException("Search failed");
    }

    private void storeFlags(String str, Flags flags, boolean z) throws ProtocolException {
        StringBuilder sb;
        String str2;
        if (z) {
            sb = new StringBuilder("STORE ");
            sb.append(str);
            str2 = " +FLAGS ";
        } else {
            sb = new StringBuilder("STORE ");
            sb.append(str);
            str2 = " -FLAGS ";
        }
        sb.append(str2);
        sb.append(createFlagList(flags));
        Response[] command = command(sb.toString(), (Argument) null);
        notifyResponseHandlers(command);
        handleResult(command[command.length - 1]);
    }

    public void append(String str, Flags flags, Date date, Literal literal) throws ProtocolException {
        appenduid(str, flags, date, literal, false);
    }

    public AppendUID appenduid(String str, Flags flags, Date date, Literal literal) throws ProtocolException {
        return appenduid(str, flags, date, literal, true);
    }

    public AppendUID appenduid(String str, Flags flags, Date date, Literal literal, boolean z) throws ProtocolException {
        Flags flags2;
        String encode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(encode);
        if (flags != null) {
            if (flags.contains(Flags.Flag.RECENT)) {
                flags2 = new Flags(flags);
                flags2.remove(Flags.Flag.RECENT);
            } else {
                flags2 = flags;
            }
            argument.writeAtom(createFlagList(flags2));
        }
        if (date != null) {
            argument.writeString(INTERNALDATE.format(date));
        }
        argument.writeBytes(literal);
        Response[] command = command("APPEND", argument);
        notifyResponseHandlers(command);
        handleResult(command[command.length - 1]);
        if (z) {
            return getAppendUID(command[command.length - 1]);
        }
        return null;
    }

    public synchronized void authlogin(String str, String str2) throws ProtocolException {
        Response response;
        String str3;
        boolean z;
        boolean z2;
        String str4;
        Vector vector = new Vector();
        try {
            str3 = writeCommand("AUTHENTICATE LOGIN", (Argument) null);
            response = null;
            z = false;
        } catch (Exception e) {
            response = Response.byeResponse(e);
            str3 = null;
            z = true;
        }
        OutputStream outputStream = getOutputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BASE64EncoderStream bASE64EncoderStream = new BASE64EncoderStream(byteArrayOutputStream, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        Response response2 = response;
        boolean z3 = true;
        while (!z) {
            try {
                response2 = readResponse();
                if (response2.isContinuation()) {
                    if (z3) {
                        str4 = str;
                        z2 = false;
                    } else {
                        z2 = z3;
                        str4 = str2;
                    }
                    try {
                        bASE64EncoderStream.write(ASCIIUtility.getBytes(str4));
                        bASE64EncoderStream.flush();
                        byteArrayOutputStream.write(CRLF);
                        outputStream.write(byteArrayOutputStream.toByteArray());
                        outputStream.flush();
                        byteArrayOutputStream.reset();
                        z3 = z2;
                    } catch (Exception e2) {
                        e = e2;
                        z3 = z2;
                        response2 = Response.byeResponse(e);
                        z = true;
                    }
                } else if (response2.isTagged() && response2.getTag().equals(str3)) {
                    z = true;
                } else if (response2.isBYE()) {
                    z = true;
                } else {
                    vector.addElement(response2);
                }
            } catch (Exception e3) {
                e = e3;
                response2 = Response.byeResponse(e);
                z = true;
            }
        }
        Response[] responseArr = new Response[vector.size()];
        vector.copyInto(responseArr);
        notifyResponseHandlers(responseArr);
        handleResult(response2);
        setCapabilities(response2);
        this.authenticated = true;
    }

    public synchronized void authplain(String str, String str2, String str3) throws ProtocolException {
        Response response;
        Response response2;
        Vector vector = new Vector();
        boolean z = false;
        String str4 = null;
        try {
            response = null;
            str4 = writeCommand("AUTHENTICATE PLAIN", (Argument) null);
        } catch (Exception e) {
            response = Response.byeResponse(e);
            z = true;
        }
        OutputStream outputStream = getOutputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BASE64EncoderStream bASE64EncoderStream = new BASE64EncoderStream(byteArrayOutputStream, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        while (!z) {
            try {
                response2 = readResponse();
                if (response2.isContinuation()) {
                    bASE64EncoderStream.write(ASCIIUtility.getBytes(String.valueOf(str) + "\u0000" + str2 + "\u0000" + str3));
                    bASE64EncoderStream.flush();
                    byteArrayOutputStream.write(CRLF);
                    outputStream.write(byteArrayOutputStream.toByteArray());
                    outputStream.flush();
                    byteArrayOutputStream.reset();
                } else if (response2.isTagged() && response2.getTag().equals(str4)) {
                    z = true;
                } else if (response2.isBYE()) {
                    z = true;
                } else {
                    vector.addElement(response2);
                }
            } catch (Exception e2) {
                response2 = Response.byeResponse(e2);
            }
        }
        Response[] responseArr = new Response[vector.size()];
        vector.copyInto(responseArr);
        notifyResponseHandlers(responseArr);
        handleResult(response);
        setCapabilities(response);
        this.authenticated = true;
    }

    public void capability() throws ProtocolException {
        Response[] command = command("CAPABILITY", (Argument) null);
        if (!command[command.length - 1].isOK()) {
            throw new ProtocolException(command[command.length - 1].toString());
        }
        this.capabilities = new HashMap(10);
        this.authmechs = new ArrayList(5);
        int length = command.length;
        for (int i = 0; i < length; i++) {
            if (command[i] instanceof IMAPResponse) {
                IMAPResponse iMAPResponse = (IMAPResponse) command[i];
                if (iMAPResponse.keyEquals("CAPABILITY")) {
                    parseCapabilities(iMAPResponse);
                }
            }
        }
    }

    public void check() throws ProtocolException {
        simpleCommand("CHECK", (Argument) null);
    }

    public void close() throws ProtocolException {
        simpleCommand("CLOSE", (Argument) null);
    }

    public void copy(int i, int i2, String str) throws ProtocolException {
        copy(String.valueOf(String.valueOf(i)) + ":" + String.valueOf(i2), str);
    }

    public void copy(MessageSet[] messageSetArr, String str) throws ProtocolException {
        copy(MessageSet.toString(messageSetArr), str);
    }

    public void create(String str) throws ProtocolException {
        String encode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(encode);
        simpleCommand("CREATE", argument);
    }

    public void delete(String str) throws ProtocolException {
        String encode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(encode);
        simpleCommand(HttpRequest.METHOD_DELETE, argument);
    }

    public void deleteACL(String str, String str2) throws ProtocolException {
        if (!hasCapability("ACL")) {
            throw new BadCommandException("ACL not supported");
        }
        String encode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(encode);
        argument.writeString(str2);
        Response[] command = command("DELETEACL", argument);
        Response response = command[command.length - 1];
        notifyResponseHandlers(command);
        handleResult(response);
    }

    public void disconnect() {
        super.disconnect();
        this.authenticated = false;
    }

    public MailboxInfo examine(String str) throws ProtocolException {
        String encode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(encode);
        Response[] command = command("EXAMINE", argument);
        MailboxInfo mailboxInfo = new MailboxInfo(command);
        mailboxInfo.mode = 1;
        notifyResponseHandlers(command);
        handleResult(command[command.length - 1]);
        return mailboxInfo;
    }

    public void expunge() throws ProtocolException {
        simpleCommand("EXPUNGE", (Argument) null);
    }

    public Response[] fetch(int i, int i2, String str) throws ProtocolException {
        return fetch(String.valueOf(String.valueOf(i)) + ":" + String.valueOf(i2), str, false);
    }

    public Response[] fetch(int i, String str) throws ProtocolException {
        return fetch(String.valueOf(i), str, false);
    }

    public Response[] fetch(MessageSet[] messageSetArr, String str) throws ProtocolException {
        return fetch(MessageSet.toString(messageSetArr), str, false);
    }

    public BODY fetchBody(int i, String str) throws ProtocolException {
        return fetchBody(i, str, false);
    }

    public BODY fetchBody(int i, String str, int i2, int i3) throws ProtocolException {
        return fetchBody(i, str, i2, i3, false, (ByteArray) null);
    }

    public BODY fetchBody(int i, String str, int i2, int i3, ByteArray byteArray) throws ProtocolException {
        return fetchBody(i, str, i2, i3, false, byteArray);
    }

    /* access modifiers changed from: protected */
    public BODY fetchBody(int i, String str, int i2, int i3, boolean z, ByteArray byteArray) throws ProtocolException {
        String str2;
        this.ba = byteArray;
        StringBuilder sb = new StringBuilder(String.valueOf(z ? "BODY.PEEK[" : "BODY["));
        if (str == null) {
            str2 = "]<";
        } else {
            str2 = String.valueOf(str) + "]<";
        }
        sb.append(str2);
        sb.append(String.valueOf(i2));
        sb.append(".");
        sb.append(String.valueOf(i3));
        sb.append(">");
        Response[] fetch = fetch(i, sb.toString());
        notifyResponseHandlers(fetch);
        Response response = fetch[fetch.length - 1];
        if (response.isOK()) {
            return (BODY) FetchResponse.getItem(fetch, i, BODY.class);
        }
        if (response.isNO()) {
            return null;
        }
        handleResult(response);
        return null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.sun.mail.imap.protocol.BODY fetchBody(int r2, java.lang.String r3, boolean r4) throws com.sun.mail.iap.ProtocolException {
        /*
            r1 = this;
            if (r4 == 0) goto L_0x002c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r0 = "BODY.PEEK["
            r4.<init>(r0)
            if (r3 != 0) goto L_0x000e
        L_0x000b:
            java.lang.String r3 = "]"
            goto L_0x0020
        L_0x000e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r0.<init>(r3)
        L_0x0017:
            java.lang.String r3 = "]"
            r0.append(r3)
            java.lang.String r3 = r0.toString()
        L_0x0020:
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.sun.mail.iap.Response[] r3 = r1.fetch((int) r2, (java.lang.String) r3)
            goto L_0x0040
        L_0x002c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r0 = "BODY["
            r4.<init>(r0)
            if (r3 != 0) goto L_0x0036
            goto L_0x000b
        L_0x0036:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r0.<init>(r3)
            goto L_0x0017
        L_0x0040:
            r1.notifyResponseHandlers(r3)
            int r4 = r3.length
            int r4 = r4 + -1
            r4 = r3[r4]
            boolean r0 = r4.isOK()
            if (r0 == 0) goto L_0x0057
            java.lang.Class<com.sun.mail.imap.protocol.BODY> r4 = com.sun.mail.imap.protocol.BODY.class
            com.sun.mail.imap.protocol.Item r2 = com.sun.mail.imap.protocol.FetchResponse.getItem(r3, r2, r4)
            com.sun.mail.imap.protocol.BODY r2 = (com.sun.mail.imap.protocol.BODY) r2
            return r2
        L_0x0057:
            boolean r2 = r4.isNO()
            r3 = 0
            if (r2 == 0) goto L_0x005f
            return r3
        L_0x005f:
            r1.handleResult(r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.protocol.IMAPProtocol.fetchBody(int, java.lang.String, boolean):com.sun.mail.imap.protocol.BODY");
    }

    public BODYSTRUCTURE fetchBodyStructure(int i) throws ProtocolException {
        Response[] fetch = fetch(i, "BODYSTRUCTURE");
        notifyResponseHandlers(fetch);
        Response response = fetch[fetch.length - 1];
        if (response.isOK()) {
            return (BODYSTRUCTURE) FetchResponse.getItem(fetch, i, BODYSTRUCTURE.class);
        }
        if (response.isNO()) {
            return null;
        }
        handleResult(response);
        return null;
    }

    public Flags fetchFlags(int i) throws ProtocolException {
        Response[] fetch = fetch(i, "FLAGS");
        int length = fetch.length;
        int i2 = 0;
        Flags flags = null;
        while (true) {
            if (i2 < length) {
                if (fetch[i2] != null && (fetch[i2] instanceof FetchResponse) && ((FetchResponse) fetch[i2]).getNumber() == i && (flags = (Flags) ((FetchResponse) fetch[i2]).getItem(Flags.class)) != null) {
                    fetch[i2] = null;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        notifyResponseHandlers(fetch);
        handleResult(fetch[fetch.length - 1]);
        return flags;
    }

    public RFC822DATA fetchRFC822(int i, String str) throws ProtocolException {
        String str2;
        if (str == null) {
            str2 = "RFC822";
        } else {
            str2 = "RFC822." + str;
        }
        Response[] fetch = fetch(i, str2);
        notifyResponseHandlers(fetch);
        Response response = fetch[fetch.length - 1];
        if (response.isOK()) {
            return (RFC822DATA) FetchResponse.getItem(fetch, i, RFC822DATA.class);
        }
        if (response.isNO()) {
            return null;
        }
        handleResult(response);
        return null;
    }

    public UID fetchSequenceNumber(long j) throws ProtocolException {
        Response[] fetch = fetch(String.valueOf(j), "UID", true);
        int length = fetch.length;
        UID uid = null;
        for (int i = 0; i < length; i++) {
            if (!(fetch[i] == null || !(fetch[i] instanceof FetchResponse) || (uid = (UID) ((FetchResponse) fetch[i]).getItem(UID.class)) == null)) {
                if (uid.uid == j) {
                    break;
                }
                uid = null;
            }
        }
        notifyResponseHandlers(fetch);
        handleResult(fetch[fetch.length - 1]);
        return uid;
    }

    public UID[] fetchSequenceNumbers(long j, long j2) throws ProtocolException {
        UID uid;
        StringBuilder sb = new StringBuilder(String.valueOf(String.valueOf(j)));
        sb.append(":");
        sb.append(j2 == -1 ? Marker.ANY_MARKER : String.valueOf(j2));
        Response[] fetch = fetch(sb.toString(), "UID", true);
        Vector vector = new Vector();
        int length = fetch.length;
        for (int i = 0; i < length; i++) {
            if (!(fetch[i] == null || !(fetch[i] instanceof FetchResponse) || (uid = (UID) ((FetchResponse) fetch[i]).getItem(UID.class)) == null)) {
                vector.addElement(uid);
            }
        }
        notifyResponseHandlers(fetch);
        handleResult(fetch[fetch.length - 1]);
        UID[] uidArr = new UID[vector.size()];
        vector.copyInto(uidArr);
        return uidArr;
    }

    public UID[] fetchSequenceNumbers(long[] jArr) throws ProtocolException {
        UID uid;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < jArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append(String.valueOf(jArr[i]));
        }
        Response[] fetch = fetch(stringBuffer.toString(), "UID", true);
        Vector vector = new Vector();
        int length = fetch.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (!(fetch[i2] == null || !(fetch[i2] instanceof FetchResponse) || (uid = (UID) ((FetchResponse) fetch[i2]).getItem(UID.class)) == null)) {
                vector.addElement(uid);
            }
        }
        notifyResponseHandlers(fetch);
        handleResult(fetch[fetch.length - 1]);
        UID[] uidArr = new UID[vector.size()];
        vector.copyInto(uidArr);
        return uidArr;
    }

    public UID fetchUID(int i) throws ProtocolException {
        Response[] fetch = fetch(i, "UID");
        notifyResponseHandlers(fetch);
        Response response = fetch[fetch.length - 1];
        if (response.isOK()) {
            return (UID) FetchResponse.getItem(fetch, i, UID.class);
        }
        if (response.isNO()) {
            return null;
        }
        handleResult(response);
        return null;
    }

    public ACL[] getACL(String str) throws ProtocolException {
        String readAtomString;
        if (!hasCapability("ACL")) {
            throw new BadCommandException("ACL not supported");
        }
        String encode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(encode);
        Response[] command = command("GETACL", argument);
        Response response = command[command.length - 1];
        Vector vector = new Vector();
        if (response.isOK()) {
            int length = command.length;
            for (int i = 0; i < length; i++) {
                if (command[i] instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) command[i];
                    if (iMAPResponse.keyEquals("ACL")) {
                        iMAPResponse.readAtomString();
                        while (true) {
                            String readAtomString2 = iMAPResponse.readAtomString();
                            if (!(readAtomString2 == null || (readAtomString = iMAPResponse.readAtomString()) == null)) {
                                vector.addElement(new ACL(readAtomString2, new Rights(readAtomString)));
                            }
                        }
                        command[i] = null;
                    }
                }
            }
        }
        notifyResponseHandlers(command);
        handleResult(response);
        ACL[] aclArr = new ACL[vector.size()];
        vector.copyInto(aclArr);
        return aclArr;
    }

    public Map getCapabilities() {
        return this.capabilities;
    }

    /* access modifiers changed from: package-private */
    public OutputStream getIMAPOutputStream() {
        return getOutputStream();
    }

    public Quota[] getQuota(String str) throws ProtocolException {
        if (!hasCapability("QUOTA")) {
            throw new BadCommandException("QUOTA not supported");
        }
        Argument argument = new Argument();
        argument.writeString(str);
        Response[] command = command("GETQUOTA", argument);
        Vector vector = new Vector();
        Response response = command[command.length - 1];
        if (response.isOK()) {
            int length = command.length;
            for (int i = 0; i < length; i++) {
                if (command[i] instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) command[i];
                    if (iMAPResponse.keyEquals("QUOTA")) {
                        vector.addElement(parseQuota(iMAPResponse));
                        command[i] = null;
                    }
                }
            }
        }
        notifyResponseHandlers(command);
        handleResult(response);
        Quota[] quotaArr = new Quota[vector.size()];
        vector.copyInto(quotaArr);
        return quotaArr;
    }

    public Quota[] getQuotaRoot(String str) throws ProtocolException {
        if (!hasCapability("QUOTA")) {
            throw new BadCommandException("GETQUOTAROOT not supported");
        }
        String encode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(encode);
        Response[] command = command("GETQUOTAROOT", argument);
        Response response = command[command.length - 1];
        Hashtable hashtable = new Hashtable();
        int i = 0;
        if (response.isOK()) {
            int length = command.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (command[i2] instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) command[i2];
                    if (iMAPResponse.keyEquals("QUOTAROOT")) {
                        iMAPResponse.readAtomString();
                        while (true) {
                            String readAtomString = iMAPResponse.readAtomString();
                            if (readAtomString == null) {
                                break;
                            }
                            hashtable.put(readAtomString, new Quota(readAtomString));
                        }
                        command[i2] = null;
                    } else if (iMAPResponse.keyEquals("QUOTA")) {
                        Quota parseQuota = parseQuota(iMAPResponse);
                        hashtable.get(parseQuota.quotaRoot);
                        hashtable.put(parseQuota.quotaRoot, parseQuota);
                        command[i2] = null;
                    }
                }
            }
        }
        notifyResponseHandlers(command);
        handleResult(response);
        Quota[] quotaArr = new Quota[hashtable.size()];
        Enumeration elements = hashtable.elements();
        while (elements.hasMoreElements()) {
            quotaArr[i] = (Quota) elements.nextElement();
            i++;
        }
        return quotaArr;
    }

    /* access modifiers changed from: protected */
    public ByteArray getResponseBuffer() {
        ByteArray byteArray = this.ba;
        this.ba = null;
        return byteArray;
    }

    public boolean hasCapability(String str) {
        return this.capabilities.containsKey(str.toUpperCase(Locale.ENGLISH));
    }

    public void idleAbort() throws ProtocolException {
        OutputStream outputStream = getOutputStream();
        try {
            outputStream.write(DONE);
            outputStream.flush();
        } catch (IOException unused) {
        }
    }

    public synchronized void idleStart() throws ProtocolException {
        Response response;
        if (!hasCapability("IDLE")) {
            throw new BadCommandException("IDLE not supported");
        }
        try {
            this.idleTag = writeCommand("IDLE", (Argument) null);
            response = readResponse();
        } catch (LiteralException e) {
            response = e.getResponse();
        } catch (Exception e2) {
            response = Response.byeResponse(e2);
        }
        if (!response.isContinuation()) {
            handleResult(response);
        }
    }

    public boolean isAuthenticated() {
        return this.authenticated;
    }

    public boolean isREV1() {
        return this.rev1;
    }

    public ListInfo[] list(String str, String str2) throws ProtocolException {
        return doList("LIST", str, str2);
    }

    public Rights[] listRights(String str, String str2) throws ProtocolException {
        if (!hasCapability("ACL")) {
            throw new BadCommandException("ACL not supported");
        }
        String encode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(encode);
        argument.writeString(str2);
        Response[] command = command("LISTRIGHTS", argument);
        Response response = command[command.length - 1];
        Vector vector = new Vector();
        if (response.isOK()) {
            int length = command.length;
            for (int i = 0; i < length; i++) {
                if (command[i] instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) command[i];
                    if (iMAPResponse.keyEquals("LISTRIGHTS")) {
                        iMAPResponse.readAtomString();
                        iMAPResponse.readAtomString();
                        while (true) {
                            String readAtomString = iMAPResponse.readAtomString();
                            if (readAtomString == null) {
                                break;
                            }
                            vector.addElement(new Rights(readAtomString));
                        }
                        command[i] = null;
                    }
                }
            }
        }
        notifyResponseHandlers(command);
        handleResult(response);
        Rights[] rightsArr = new Rights[vector.size()];
        vector.copyInto(rightsArr);
        return rightsArr;
    }

    public void login(String str, String str2) throws ProtocolException {
        Argument argument = new Argument();
        argument.writeString(str);
        argument.writeString(str2);
        Response[] command = command("LOGIN", argument);
        notifyResponseHandlers(command);
        handleResult(command[command.length - 1]);
        setCapabilities(command[command.length - 1]);
        this.authenticated = true;
    }

    public void logout() throws ProtocolException {
        Response[] command = command("LOGOUT", (Argument) null);
        this.authenticated = false;
        notifyResponseHandlers(command);
        disconnect();
    }

    public ListInfo[] lsub(String str, String str2) throws ProtocolException {
        return doList("LSUB", str, str2);
    }

    public Rights myRights(String str) throws ProtocolException {
        if (!hasCapability("ACL")) {
            throw new BadCommandException("ACL not supported");
        }
        String encode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(encode);
        Response[] command = command("MYRIGHTS", argument);
        Response response = command[command.length - 1];
        Rights rights = null;
        if (response.isOK()) {
            int length = command.length;
            Rights rights2 = null;
            for (int i = 0; i < length; i++) {
                if (command[i] instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) command[i];
                    if (iMAPResponse.keyEquals("MYRIGHTS")) {
                        iMAPResponse.readAtomString();
                        String readAtomString = iMAPResponse.readAtomString();
                        if (rights2 == null) {
                            rights2 = new Rights(readAtomString);
                        }
                        command[i] = null;
                    }
                }
            }
            rights = rights2;
        }
        notifyResponseHandlers(command);
        handleResult(response);
        return rights;
    }

    public Namespaces namespace() throws ProtocolException {
        if (!hasCapability("NAMESPACE")) {
            throw new BadCommandException("NAMESPACE not supported");
        }
        Namespaces namespaces = null;
        Response[] command = command("NAMESPACE", (Argument) null);
        Response response = command[command.length - 1];
        if (response.isOK()) {
            int length = command.length;
            Namespaces namespaces2 = null;
            for (int i = 0; i < length; i++) {
                if (command[i] instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) command[i];
                    if (iMAPResponse.keyEquals("NAMESPACE")) {
                        if (namespaces2 == null) {
                            namespaces2 = new Namespaces(iMAPResponse);
                        }
                        command[i] = null;
                    }
                }
            }
            namespaces = namespaces2;
        }
        notifyResponseHandlers(command);
        handleResult(response);
        return namespaces;
    }

    public void noop() throws ProtocolException {
        if (this.debug) {
            this.out.println("IMAP DEBUG: IMAPProtocol noop");
        }
        simpleCommand("NOOP", (Argument) null);
    }

    /* access modifiers changed from: protected */
    public void parseCapabilities(Response response) {
        while (true) {
            String readAtom = response.readAtom(']');
            if (readAtom != null) {
                if (readAtom.length() != 0) {
                    this.capabilities.put(readAtom.toUpperCase(Locale.ENGLISH), readAtom);
                    if (readAtom.regionMatches(true, 0, "AUTH=", 0, 5)) {
                        this.authmechs.add(readAtom.substring(5));
                        if (this.debug) {
                            PrintStream printStream = this.out;
                            printStream.println("IMAP DEBUG: AUTH: " + readAtom.substring(5));
                        }
                    }
                } else if (response.peekByte() != 93) {
                    response.skipToken();
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public BODY peekBody(int i, String str) throws ProtocolException {
        return fetchBody(i, str, true);
    }

    public BODY peekBody(int i, String str, int i2, int i3) throws ProtocolException {
        return fetchBody(i, str, i2, i3, true, (ByteArray) null);
    }

    public BODY peekBody(int i, String str, int i2, int i3, ByteArray byteArray) throws ProtocolException {
        return fetchBody(i, str, i2, i3, true, byteArray);
    }

    /* access modifiers changed from: protected */
    public void processGreeting(Response response) throws ProtocolException {
        super.processGreeting(response);
        if (response.isOK()) {
            setCapabilities(response);
        } else if (((IMAPResponse) response).keyEquals("PREAUTH")) {
            this.authenticated = true;
            setCapabilities(response);
        } else {
            throw new ConnectionException(this, response);
        }
    }

    public boolean processIdleResponse(Response response) throws ProtocolException {
        notifyResponseHandlers(new Response[]{response});
        boolean isBYE = response.isBYE();
        if (response.isTagged() && response.getTag().equals(this.idleTag)) {
            isBYE = true;
        }
        if (isBYE) {
            this.idleTag = null;
        }
        handleResult(response);
        return !isBYE;
    }

    public void proxyauth(String str) throws ProtocolException {
        Argument argument = new Argument();
        argument.writeString(str);
        simpleCommand("PROXYAUTH", argument);
    }

    public synchronized Response readIdleResponse() {
        Response response;
        if (this.idleTag == null) {
            return null;
        }
        try {
            response = readResponse();
        } catch (ProtocolException | IOException e) {
            response = Response.byeResponse(e);
        }
        return response;
    }

    public Response readResponse() throws IOException, ProtocolException {
        return IMAPResponse.readResponse(this);
    }

    public void rename(String str, String str2) throws ProtocolException {
        String encode = BASE64MailboxEncoder.encode(str);
        String encode2 = BASE64MailboxEncoder.encode(str2);
        Argument argument = new Argument();
        argument.writeString(encode);
        argument.writeString(encode2);
        simpleCommand("RENAME", argument);
    }

    public void sasllogin(String[] strArr, String str, String str2, String str3, String str4) throws ProtocolException {
        List list;
        if (this.saslAuthenticator == null) {
            try {
                Constructor<?> constructor = Class.forName("com.sun.mail.imap.protocol.IMAPSaslAuthenticator").getConstructor(new Class[]{IMAPProtocol.class, String.class, Properties.class, Boolean.TYPE, PrintStream.class, String.class});
                Object[] objArr = new Object[6];
                objArr[0] = this;
                objArr[1] = this.name;
                objArr[2] = this.props;
                objArr[3] = this.debug ? Boolean.TRUE : Boolean.FALSE;
                objArr[4] = this.out;
                objArr[5] = this.host;
                this.saslAuthenticator = (SaslAuthenticator) constructor.newInstance(objArr);
            } catch (Exception e) {
                if (this.debug) {
                    PrintStream printStream = this.out;
                    printStream.println("IMAP DEBUG: Can't load SASL authenticator: " + e);
                    return;
                }
                return;
            }
        }
        if (strArr == null || strArr.length <= 0) {
            list = this.authmechs;
        } else {
            list = new ArrayList(strArr.length);
            for (int i = 0; i < strArr.length; i++) {
                if (this.authmechs.contains(strArr[i])) {
                    list.add(strArr[i]);
                }
            }
        }
        if (this.saslAuthenticator.authenticate((String[]) list.toArray(new String[list.size()]), str, str2, str3, str4)) {
            this.authenticated = true;
        }
    }

    public int[] search(SearchTerm searchTerm) throws ProtocolException, SearchException {
        return search("ALL", searchTerm);
    }

    public int[] search(MessageSet[] messageSetArr, SearchTerm searchTerm) throws ProtocolException, SearchException {
        return search(MessageSet.toString(messageSetArr), searchTerm);
    }

    public MailboxInfo select(String str) throws ProtocolException {
        String encode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(encode);
        Response[] command = command("SELECT", argument);
        MailboxInfo mailboxInfo = new MailboxInfo(command);
        notifyResponseHandlers(command);
        Response response = command[command.length - 1];
        if (response.isOK()) {
            if (response.toString().indexOf("READ-ONLY") != -1) {
                mailboxInfo.mode = 1;
            } else {
                mailboxInfo.mode = 2;
            }
        }
        handleResult(response);
        return mailboxInfo;
    }

    public void setACL(String str, char c2, ACL acl) throws ProtocolException {
        if (!hasCapability("ACL")) {
            throw new BadCommandException("ACL not supported");
        }
        String encode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(encode);
        argument.writeString(acl.getName());
        String rights = acl.getRights().toString();
        if (c2 == '+' || c2 == '-') {
            rights = String.valueOf(c2) + rights;
        }
        argument.writeString(rights);
        Response[] command = command("SETACL", argument);
        Response response = command[command.length - 1];
        notifyResponseHandlers(command);
        handleResult(response);
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    protected void setCapabilities(com.sun.mail.iap.Response r3) {
        /*
            r2 = this;
        L_0x0000:
            byte r0 = r3.readByte()
            if (r0 <= 0) goto L_0x000a
            r1 = 91
            if (r0 != r1) goto L_0x0000
        L_0x000a:
            if (r0 != 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.String r0 = r3.readAtom()
            java.lang.String r1 = "CAPABILITY"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L_0x001a
            return
        L_0x001a:
            java.util.HashMap r0 = new java.util.HashMap
            r1 = 10
            r0.<init>(r1)
            r2.capabilities = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 5
            r0.<init>(r1)
            r2.authmechs = r0
            r2.parseCapabilities(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.protocol.IMAPProtocol.setCapabilities(com.sun.mail.iap.Response):void");
    }

    public void setQuota(Quota quota) throws ProtocolException {
        if (!hasCapability("QUOTA")) {
            throw new BadCommandException("QUOTA not supported");
        }
        Argument argument = new Argument();
        argument.writeString(quota.quotaRoot);
        Argument argument2 = new Argument();
        if (quota.resources != null) {
            for (int i = 0; i < quota.resources.length; i++) {
                argument2.writeAtom(quota.resources[i].name);
                argument2.writeNumber(quota.resources[i].limit);
            }
        }
        argument.writeArgument(argument2);
        Response[] command = command("SETQUOTA", argument);
        Response response = command[command.length - 1];
        notifyResponseHandlers(command);
        handleResult(response);
    }

    public void startTLS() throws ProtocolException {
        try {
            super.startTLS("STARTTLS");
        } catch (ProtocolException e) {
            throw e;
        } catch (Exception e2) {
            notifyResponseHandlers(new Response[]{Response.byeResponse(e2)});
            disconnect();
        }
    }

    public Status status(String str, String[] strArr) throws ProtocolException {
        if (isREV1() || hasCapability("IMAP4SUNVERSION")) {
            String encode = BASE64MailboxEncoder.encode(str);
            Argument argument = new Argument();
            argument.writeString(encode);
            Argument argument2 = new Argument();
            if (strArr == null) {
                strArr = Status.standardItems;
            }
            for (String writeAtom : strArr) {
                argument2.writeAtom(writeAtom);
            }
            argument.writeArgument(argument2);
            Response[] command = command("STATUS", argument);
            Response response = command[command.length - 1];
            Status status = null;
            if (response.isOK()) {
                int length = command.length;
                Status status2 = null;
                for (int i = 0; i < length; i++) {
                    if (command[i] instanceof IMAPResponse) {
                        IMAPResponse iMAPResponse = (IMAPResponse) command[i];
                        if (iMAPResponse.keyEquals("STATUS")) {
                            if (status2 == null) {
                                status2 = new Status(iMAPResponse);
                            } else {
                                Status.add(status2, new Status(iMAPResponse));
                            }
                            command[i] = null;
                        }
                    }
                }
                status = status2;
            }
            notifyResponseHandlers(command);
            handleResult(response);
            return status;
        }
        throw new BadCommandException("STATUS not supported");
    }

    public void storeFlags(int i, int i2, Flags flags, boolean z) throws ProtocolException {
        storeFlags(String.valueOf(String.valueOf(i)) + ":" + String.valueOf(i2), flags, z);
    }

    public void storeFlags(int i, Flags flags, boolean z) throws ProtocolException {
        storeFlags(String.valueOf(i), flags, z);
    }

    public void storeFlags(MessageSet[] messageSetArr, Flags flags, boolean z) throws ProtocolException {
        storeFlags(MessageSet.toString(messageSetArr), flags, z);
    }

    public void subscribe(String str) throws ProtocolException {
        Argument argument = new Argument();
        argument.writeString(BASE64MailboxEncoder.encode(str));
        simpleCommand("SUBSCRIBE", argument);
    }

    /* access modifiers changed from: protected */
    public boolean supportsNonSyncLiterals() {
        return hasCapability("LITERAL+");
    }

    public void uidexpunge(UIDSet[] uIDSetArr) throws ProtocolException {
        if (!hasCapability("UIDPLUS")) {
            throw new BadCommandException("UID EXPUNGE not supported");
        }
        simpleCommand("UID EXPUNGE " + UIDSet.toString(uIDSetArr), (Argument) null);
    }

    public void unsubscribe(String str) throws ProtocolException {
        Argument argument = new Argument();
        argument.writeString(BASE64MailboxEncoder.encode(str));
        simpleCommand("UNSUBSCRIBE", argument);
    }
}
