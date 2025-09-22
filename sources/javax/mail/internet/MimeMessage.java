package javax.mail.internet;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.cyjh.common.util.s;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.FolderClosedIOException;
import com.sun.mail.util.LineOutputStream;
import com.sun.mail.util.MessageRemovedIOException;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.util.SharedByteArrayInputStream;

public class MimeMessage extends Message implements MimePart {
    private static final Flags answeredFlag = new Flags(Flags.Flag.ANSWERED);
    private static MailDateFormat mailDateFormat = new MailDateFormat();
    Object cachedContent;
    protected byte[] content;
    protected InputStream contentStream;
    protected DataHandler dh;
    protected Flags flags;
    protected InternetHeaders headers;
    protected boolean modified;
    protected boolean saved;
    private boolean strict;

    public static class RecipientType extends Message.RecipientType {
        public static final RecipientType NEWSGROUPS = new RecipientType("Newsgroups");
        private static final long serialVersionUID = -5468290701714395543L;

        protected RecipientType(String str) {
            super(str);
        }

        /* access modifiers changed from: protected */
        public Object readResolve() throws ObjectStreamException {
            return this.type.equals("Newsgroups") ? NEWSGROUPS : super.readResolve();
        }
    }

    protected MimeMessage(Folder folder, int i) {
        super(folder, i);
        this.modified = false;
        this.saved = false;
        this.strict = true;
        this.flags = new Flags();
        this.saved = true;
        initStrict();
    }

    protected MimeMessage(Folder folder, InputStream inputStream, int i) throws MessagingException {
        this(folder, i);
        initStrict();
        parse(inputStream);
    }

    protected MimeMessage(Folder folder, InternetHeaders internetHeaders, byte[] bArr, int i) throws MessagingException {
        this(folder, i);
        this.headers = internetHeaders;
        this.content = bArr;
        initStrict();
    }

    public MimeMessage(Session session) {
        super(session);
        this.modified = false;
        this.saved = false;
        this.strict = true;
        this.modified = true;
        this.headers = new InternetHeaders();
        this.flags = new Flags();
        initStrict();
    }

    public MimeMessage(Session session, InputStream inputStream) throws MessagingException {
        super(session);
        this.modified = false;
        this.saved = false;
        this.strict = true;
        this.flags = new Flags();
        initStrict();
        parse(inputStream);
        this.saved = true;
    }

    public MimeMessage(MimeMessage mimeMessage) throws MessagingException {
        super(mimeMessage.session);
        this.modified = false;
        this.saved = false;
        this.strict = true;
        this.flags = mimeMessage.getFlags();
        int size = mimeMessage.getSize();
        ByteArrayOutputStream byteArrayOutputStream = size > 0 ? new ByteArrayOutputStream(size) : new ByteArrayOutputStream();
        try {
            this.strict = mimeMessage.strict;
            mimeMessage.writeTo(byteArrayOutputStream);
            byteArrayOutputStream.close();
            SharedByteArrayInputStream sharedByteArrayInputStream = new SharedByteArrayInputStream(byteArrayOutputStream.toByteArray());
            parse(sharedByteArrayInputStream);
            sharedByteArrayInputStream.close();
            this.saved = true;
        } catch (IOException e) {
            throw new MessagingException("IOException while copying message", e);
        }
    }

    private void addAddressHeader(String str, Address[] addressArr) throws MessagingException {
        String internetAddress = InternetAddress.toString(addressArr);
        if (internetAddress != null) {
            addHeader(str, internetAddress);
        }
    }

    private Address[] eliminateDuplicates(Vector vector, Address[] addressArr) {
        boolean z;
        if (addressArr == null) {
            return null;
        }
        int i = 0;
        for (int i2 = 0; i2 < addressArr.length; i2++) {
            int i3 = 0;
            while (true) {
                if (i3 >= vector.size()) {
                    z = false;
                    break;
                } else if (((InternetAddress) vector.elementAt(i3)).equals(addressArr[i2])) {
                    i++;
                    addressArr[i2] = null;
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                vector.addElement(addressArr[i2]);
            }
        }
        if (i == 0) {
            return addressArr;
        }
        Address[] addressArr2 = addressArr instanceof InternetAddress[] ? new InternetAddress[(addressArr.length - i)] : new Address[(addressArr.length - i)];
        int i4 = 0;
        for (int i5 = 0; i5 < addressArr.length; i5++) {
            if (addressArr[i5] != null) {
                addressArr2[i4] = addressArr[i5];
                i4++;
            }
        }
        return addressArr2;
    }

    private Address[] getAddressHeader(String str) throws MessagingException {
        String header = getHeader(str, ",");
        if (header == null) {
            return null;
        }
        return InternetAddress.parseHeader(header, this.strict);
    }

    private String getHeaderName(Message.RecipientType recipientType) throws MessagingException {
        if (recipientType == Message.RecipientType.TO) {
            return "To";
        }
        if (recipientType == Message.RecipientType.CC) {
            return "Cc";
        }
        if (recipientType == Message.RecipientType.BCC) {
            return "Bcc";
        }
        if (recipientType == RecipientType.NEWSGROUPS) {
            return "Newsgroups";
        }
        throw new MessagingException("Invalid Recipient Type");
    }

    private void initStrict() {
        if (this.session != null) {
            String property = this.session.getProperty("mail.mime.address.strict");
            this.strict = property == null || !property.equalsIgnoreCase("false");
        }
    }

    private void setAddressHeader(String str, Address[] addressArr) throws MessagingException {
        String internetAddress = InternetAddress.toString(addressArr);
        if (internetAddress == null) {
            removeHeader(str);
        } else {
            setHeader(str, internetAddress);
        }
    }

    public void addFrom(Address[] addressArr) throws MessagingException {
        addAddressHeader("From", addressArr);
    }

    public void addHeader(String str, String str2) throws MessagingException {
        this.headers.addHeader(str, str2);
    }

    public void addHeaderLine(String str) throws MessagingException {
        this.headers.addHeaderLine(str);
    }

    public void addRecipients(Message.RecipientType recipientType, String str) throws MessagingException {
        if (recipientType != RecipientType.NEWSGROUPS) {
            addAddressHeader(getHeaderName(recipientType), InternetAddress.parse(str));
        } else if (str != null && str.length() != 0) {
            addHeader("Newsgroups", str);
        }
    }

    public void addRecipients(Message.RecipientType recipientType, Address[] addressArr) throws MessagingException {
        if (recipientType == RecipientType.NEWSGROUPS) {
            String newsAddress = NewsAddress.toString(addressArr);
            if (newsAddress != null) {
                addHeader("Newsgroups", newsAddress);
                return;
            }
            return;
        }
        addAddressHeader(getHeaderName(recipientType), addressArr);
    }

    /* access modifiers changed from: protected */
    public InternetHeaders createInternetHeaders(InputStream inputStream) throws MessagingException {
        return new InternetHeaders(inputStream);
    }

    /* access modifiers changed from: protected */
    public MimeMessage createMimeMessage(Session session) throws MessagingException {
        return new MimeMessage(session);
    }

    public Enumeration getAllHeaderLines() throws MessagingException {
        return this.headers.getAllHeaderLines();
    }

    public Enumeration getAllHeaders() throws MessagingException {
        return this.headers.getAllHeaders();
    }

    public Address[] getAllRecipients() throws MessagingException {
        Address[] allRecipients = super.getAllRecipients();
        Address[] recipients = getRecipients(RecipientType.NEWSGROUPS);
        if (recipients == null) {
            return allRecipients;
        }
        if (allRecipients == null) {
            return recipients;
        }
        Address[] addressArr = new Address[(allRecipients.length + recipients.length)];
        System.arraycopy(allRecipients, 0, addressArr, 0, allRecipients.length);
        System.arraycopy(recipients, 0, addressArr, allRecipients.length, recipients.length);
        return addressArr;
    }

    public Object getContent() throws IOException, MessagingException {
        if (this.cachedContent != null) {
            return this.cachedContent;
        }
        try {
            Object content2 = getDataHandler().getContent();
            if (MimeBodyPart.cacheMultipart && (((content2 instanceof Multipart) || (content2 instanceof Message)) && !(this.content == null && this.contentStream == null))) {
                this.cachedContent = content2;
            }
            return content2;
        } catch (FolderClosedIOException e) {
            throw new FolderClosedException(e.getFolder(), e.getMessage());
        } catch (MessageRemovedIOException e2) {
            throw new MessageRemovedException(e2.getMessage());
        }
    }

    public String getContentID() throws MessagingException {
        return getHeader("Content-Id", (String) null);
    }

    public String[] getContentLanguage() throws MessagingException {
        return MimeBodyPart.getContentLanguage(this);
    }

    public String getContentMD5() throws MessagingException {
        return getHeader(HttpHeaders.CONTENT_MD5, (String) null);
    }

    public InputStream getContentStream() throws MessagingException {
        if (this.contentStream != null) {
            return ((SharedInputStream) this.contentStream).newStream(0, -1);
        }
        if (this.content != null) {
            return new SharedByteArrayInputStream(this.content);
        }
        throw new MessagingException("No content");
    }

    public String getContentType() throws MessagingException {
        String header = getHeader("Content-Type", (String) null);
        return header == null ? "text/plain" : header;
    }

    public synchronized DataHandler getDataHandler() throws MessagingException {
        if (this.dh == null) {
            this.dh = new DataHandler((DataSource) new MimePartDataSource(this));
        }
        return this.dh;
    }

    public String getDescription() throws MessagingException {
        return MimeBodyPart.getDescription(this);
    }

    public String getDisposition() throws MessagingException {
        return MimeBodyPart.getDisposition(this);
    }

    public String getEncoding() throws MessagingException {
        return MimeBodyPart.getEncoding(this);
    }

    public String getFileName() throws MessagingException {
        return MimeBodyPart.getFileName(this);
    }

    public synchronized Flags getFlags() throws MessagingException {
        return (Flags) this.flags.clone();
    }

    public Address[] getFrom() throws MessagingException {
        Address[] addressHeader = getAddressHeader("From");
        return addressHeader == null ? getAddressHeader("Sender") : addressHeader;
    }

    public String getHeader(String str, String str2) throws MessagingException {
        return this.headers.getHeader(str, str2);
    }

    public String[] getHeader(String str) throws MessagingException {
        return this.headers.getHeader(str);
    }

    public InputStream getInputStream() throws IOException, MessagingException {
        return getDataHandler().getInputStream();
    }

    public int getLineCount() throws MessagingException {
        return -1;
    }

    public Enumeration getMatchingHeaderLines(String[] strArr) throws MessagingException {
        return this.headers.getMatchingHeaderLines(strArr);
    }

    public Enumeration getMatchingHeaders(String[] strArr) throws MessagingException {
        return this.headers.getMatchingHeaders(strArr);
    }

    public String getMessageID() throws MessagingException {
        return getHeader("Message-ID", (String) null);
    }

    public Enumeration getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        return this.headers.getNonMatchingHeaderLines(strArr);
    }

    public Enumeration getNonMatchingHeaders(String[] strArr) throws MessagingException {
        return this.headers.getNonMatchingHeaders(strArr);
    }

    public InputStream getRawInputStream() throws MessagingException {
        return getContentStream();
    }

    public Date getReceivedDate() throws MessagingException {
        return null;
    }

    public Address[] getRecipients(Message.RecipientType recipientType) throws MessagingException {
        if (recipientType != RecipientType.NEWSGROUPS) {
            return getAddressHeader(getHeaderName(recipientType));
        }
        String header = getHeader("Newsgroups", ",");
        if (header == null) {
            return null;
        }
        return NewsAddress.parse(header);
    }

    public Address[] getReplyTo() throws MessagingException {
        Address[] addressHeader = getAddressHeader("Reply-To");
        return addressHeader == null ? getFrom() : addressHeader;
    }

    public Address getSender() throws MessagingException {
        Address[] addressHeader = getAddressHeader("Sender");
        if (addressHeader == null || addressHeader.length == 0) {
            return null;
        }
        return addressHeader[0];
    }

    public Date getSentDate() throws MessagingException {
        Date parse;
        String header = getHeader("Date", (String) null);
        if (header != null) {
            try {
                synchronized (mailDateFormat) {
                    parse = mailDateFormat.parse(header);
                }
                return parse;
            } catch (ParseException unused) {
            }
        }
        return null;
    }

    public int getSize() throws MessagingException {
        if (this.content != null) {
            return this.content.length;
        }
        if (this.contentStream == null) {
            return -1;
        }
        try {
            int available = this.contentStream.available();
            if (available > 0) {
                return available;
            }
            return -1;
        } catch (IOException unused) {
            return -1;
        }
    }

    public String getSubject() throws MessagingException {
        String header = getHeader("Subject", (String) null);
        if (header == null) {
            return null;
        }
        try {
            return MimeUtility.decodeText(MimeUtility.unfold(header));
        } catch (UnsupportedEncodingException unused) {
            return header;
        }
    }

    public boolean isMimeType(String str) throws MessagingException {
        return MimeBodyPart.isMimeType(this, str);
    }

    public synchronized boolean isSet(Flags.Flag flag) throws MessagingException {
        return this.flags.contains(flag);
    }

    /* access modifiers changed from: protected */
    public void parse(InputStream inputStream) throws MessagingException {
        if (!(inputStream instanceof ByteArrayInputStream) && !(inputStream instanceof BufferedInputStream) && !(inputStream instanceof SharedInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        this.headers = createInternetHeaders(inputStream);
        if (inputStream instanceof SharedInputStream) {
            SharedInputStream sharedInputStream = (SharedInputStream) inputStream;
            this.contentStream = sharedInputStream.newStream(sharedInputStream.getPosition(), -1);
        } else {
            try {
                this.content = ASCIIUtility.getBytes(inputStream);
            } catch (IOException e) {
                throw new MessagingException("IOException", e);
            }
        }
        this.modified = false;
    }

    public void removeHeader(String str) throws MessagingException {
        this.headers.removeHeader(str);
    }

    public Message reply(boolean z) throws MessagingException {
        MimeMessage createMimeMessage = createMimeMessage(this.session);
        String header = getHeader("Subject", (String) null);
        if (header != null) {
            if (!header.regionMatches(true, 0, "Re: ", 0, 4)) {
                header = "Re: " + header;
            }
            createMimeMessage.setHeader("Subject", header);
        }
        Address[] replyTo = getReplyTo();
        createMimeMessage.setRecipients(Message.RecipientType.TO, replyTo);
        if (z) {
            Vector vector = new Vector();
            InternetAddress localAddress = InternetAddress.getLocalAddress(this.session);
            if (localAddress != null) {
                vector.addElement(localAddress);
            }
            String property = this.session != null ? this.session.getProperty("mail.alternates") : null;
            boolean z2 = false;
            if (property != null) {
                eliminateDuplicates(vector, InternetAddress.parse(property, false));
            }
            String property2 = this.session != null ? this.session.getProperty("mail.replyallcc") : null;
            if (property2 != null && property2.equalsIgnoreCase("true")) {
                z2 = true;
            }
            eliminateDuplicates(vector, replyTo);
            Address[] eliminateDuplicates = eliminateDuplicates(vector, getRecipients(Message.RecipientType.TO));
            if (eliminateDuplicates != null && eliminateDuplicates.length > 0) {
                createMimeMessage.addRecipients(z2 ? Message.RecipientType.CC : Message.RecipientType.TO, eliminateDuplicates);
            }
            Address[] eliminateDuplicates2 = eliminateDuplicates(vector, getRecipients(Message.RecipientType.CC));
            if (eliminateDuplicates2 != null && eliminateDuplicates2.length > 0) {
                createMimeMessage.addRecipients(Message.RecipientType.CC, eliminateDuplicates2);
            }
            Address[] recipients = getRecipients(RecipientType.NEWSGROUPS);
            if (recipients != null && recipients.length > 0) {
                createMimeMessage.setRecipients((Message.RecipientType) RecipientType.NEWSGROUPS, recipients);
            }
        }
        String header2 = getHeader("Message-Id", (String) null);
        if (header2 != null) {
            createMimeMessage.setHeader("In-Reply-To", header2);
        }
        String header3 = getHeader("References", s.a.f1696a);
        if (header3 == null) {
            header3 = getHeader("In-Reply-To", s.a.f1696a);
        }
        if (header2 == null) {
            header2 = header3;
        } else if (header3 != null) {
            header2 = String.valueOf(MimeUtility.unfold(header3)) + s.a.f1696a + header2;
        }
        if (header2 != null) {
            createMimeMessage.setHeader("References", MimeUtility.fold(12, header2));
        }
        try {
            setFlags(answeredFlag, true);
        } catch (MessagingException unused) {
        }
        return createMimeMessage;
    }

    public void saveChanges() throws MessagingException {
        this.modified = true;
        this.saved = true;
        updateHeaders();
    }

    public void setContent(Object obj, String str) throws MessagingException {
        if (obj instanceof Multipart) {
            setContent((Multipart) obj);
        } else {
            setDataHandler(new DataHandler(obj, str));
        }
    }

    public void setContent(Multipart multipart) throws MessagingException {
        setDataHandler(new DataHandler(multipart, multipart.getContentType()));
        multipart.setParent(this);
    }

    public void setContentID(String str) throws MessagingException {
        if (str == null) {
            removeHeader("Content-ID");
        } else {
            setHeader("Content-ID", str);
        }
    }

    public void setContentLanguage(String[] strArr) throws MessagingException {
        MimeBodyPart.setContentLanguage(this, strArr);
    }

    public void setContentMD5(String str) throws MessagingException {
        setHeader(HttpHeaders.CONTENT_MD5, str);
    }

    public synchronized void setDataHandler(DataHandler dataHandler) throws MessagingException {
        this.dh = dataHandler;
        this.cachedContent = null;
        MimeBodyPart.invalidateContentHeaders(this);
    }

    public void setDescription(String str) throws MessagingException {
        setDescription(str, (String) null);
    }

    public void setDescription(String str, String str2) throws MessagingException {
        MimeBodyPart.setDescription(this, str, str2);
    }

    public void setDisposition(String str) throws MessagingException {
        MimeBodyPart.setDisposition(this, str);
    }

    public void setFileName(String str) throws MessagingException {
        MimeBodyPart.setFileName(this, str);
    }

    public synchronized void setFlags(Flags flags2, boolean z) throws MessagingException {
        if (z) {
            this.flags.add(flags2);
        } else {
            this.flags.remove(flags2);
        }
    }

    public void setFrom() throws MessagingException {
        InternetAddress localAddress = InternetAddress.getLocalAddress(this.session);
        if (localAddress != null) {
            setFrom(localAddress);
            return;
        }
        throw new MessagingException("No From address");
    }

    public void setFrom(Address address) throws MessagingException {
        if (address == null) {
            removeHeader("From");
        } else {
            setHeader("From", address.toString());
        }
    }

    public void setHeader(String str, String str2) throws MessagingException {
        this.headers.setHeader(str, str2);
    }

    public void setRecipients(Message.RecipientType recipientType, String str) throws MessagingException {
        if (recipientType != RecipientType.NEWSGROUPS) {
            setAddressHeader(getHeaderName(recipientType), InternetAddress.parse(str));
        } else if (str == null || str.length() == 0) {
            removeHeader("Newsgroups");
        } else {
            setHeader("Newsgroups", str);
        }
    }

    public void setRecipients(Message.RecipientType recipientType, Address[] addressArr) throws MessagingException {
        if (recipientType != RecipientType.NEWSGROUPS) {
            setAddressHeader(getHeaderName(recipientType), addressArr);
        } else if (addressArr == null || addressArr.length == 0) {
            removeHeader("Newsgroups");
        } else {
            setHeader("Newsgroups", NewsAddress.toString(addressArr));
        }
    }

    public void setReplyTo(Address[] addressArr) throws MessagingException {
        setAddressHeader("Reply-To", addressArr);
    }

    public void setSender(Address address) throws MessagingException {
        if (address == null) {
            removeHeader("Sender");
        } else {
            setHeader("Sender", address.toString());
        }
    }

    public void setSentDate(Date date) throws MessagingException {
        if (date == null) {
            removeHeader("Date");
            return;
        }
        synchronized (mailDateFormat) {
            setHeader("Date", mailDateFormat.format(date));
        }
    }

    public void setSubject(String str) throws MessagingException {
        setSubject(str, (String) null);
    }

    public void setSubject(String str, String str2) throws MessagingException {
        if (str == null) {
            removeHeader("Subject");
            return;
        }
        try {
            setHeader("Subject", MimeUtility.fold(9, MimeUtility.encodeText(str, str2, (String) null)));
        } catch (UnsupportedEncodingException e) {
            throw new MessagingException("Encoding error", e);
        }
    }

    public void setText(String str) throws MessagingException {
        setText(str, (String) null);
    }

    public void setText(String str, String str2) throws MessagingException {
        MimeBodyPart.setText(this, str, str2, "plain");
    }

    public void setText(String str, String str2, String str3) throws MessagingException {
        MimeBodyPart.setText(this, str, str2, str3);
    }

    /* access modifiers changed from: protected */
    public void updateHeaders() throws MessagingException {
        MimeBodyPart.updateHeaders(this);
        setHeader("MIME-Version", "1.0");
        updateMessageID();
        if (this.cachedContent != null) {
            this.dh = new DataHandler(this.cachedContent, getContentType());
            this.cachedContent = null;
            this.content = null;
            if (this.contentStream != null) {
                try {
                    this.contentStream.close();
                } catch (IOException unused) {
                }
            }
            this.contentStream = null;
        }
    }

    /* access modifiers changed from: protected */
    public void updateMessageID() throws MessagingException {
        setHeader("Message-ID", "<" + UniqueValue.getUniqueMessageIDValue(this.session) + ">");
    }

    public void writeTo(OutputStream outputStream) throws IOException, MessagingException {
        writeTo(outputStream, (String[]) null);
    }

    public void writeTo(OutputStream outputStream, String[] strArr) throws IOException, MessagingException {
        if (!this.saved) {
            saveChanges();
        }
        if (this.modified) {
            MimeBodyPart.writeTo(this, outputStream, strArr);
            return;
        }
        Enumeration nonMatchingHeaderLines = getNonMatchingHeaderLines(strArr);
        LineOutputStream lineOutputStream = new LineOutputStream(outputStream);
        while (nonMatchingHeaderLines.hasMoreElements()) {
            lineOutputStream.writeln((String) nonMatchingHeaderLines.nextElement());
        }
        lineOutputStream.writeln();
        if (this.content == null) {
            InputStream contentStream2 = getContentStream();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = contentStream2.read(bArr);
                if (read <= 0) {
                    break;
                }
                outputStream.write(bArr, 0, read);
            }
            contentStream2.close();
        } else {
            outputStream.write(this.content);
        }
        outputStream.flush();
    }
}
