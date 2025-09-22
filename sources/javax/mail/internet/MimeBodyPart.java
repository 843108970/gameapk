package javax.mail.internet;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.lidroid.xutils.http.client.multipart.MIME;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.FolderClosedIOException;
import com.sun.mail.util.LineOutputStream;
import com.sun.mail.util.MessageRemovedIOException;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Vector;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.FolderClosedException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.HeaderTokenizer;
import org.litepal.g.b;

public class MimeBodyPart extends BodyPart implements MimePart {
    static boolean cacheMultipart = true;
    private static boolean decodeFileName = false;
    private static boolean encodeFileName = false;
    private static boolean setContentTypeFileName = true;
    private static boolean setDefaultTextCharset = true;
    private Object cachedContent;
    protected byte[] content;
    protected InputStream contentStream;
    protected DataHandler dh;
    protected InternetHeaders headers;

    static {
        try {
            String property = System.getProperty("mail.mime.setdefaulttextcharset");
            boolean z = true;
            setDefaultTextCharset = property == null || !property.equalsIgnoreCase("false");
            String property2 = System.getProperty("mail.mime.setcontenttypefilename");
            setContentTypeFileName = property2 == null || !property2.equalsIgnoreCase("false");
            String property3 = System.getProperty("mail.mime.encodefilename");
            encodeFileName = property3 != null && !property3.equalsIgnoreCase("false");
            String property4 = System.getProperty("mail.mime.decodefilename");
            decodeFileName = property4 != null && !property4.equalsIgnoreCase("false");
            String property5 = System.getProperty("mail.mime.cachemultipart");
            if (property5 != null && property5.equalsIgnoreCase("false")) {
                z = false;
            }
            cacheMultipart = z;
        } catch (SecurityException unused) {
        }
    }

    public MimeBodyPart() {
        this.headers = new InternetHeaders();
    }

    public MimeBodyPart(InputStream inputStream) throws MessagingException {
        if (!(inputStream instanceof ByteArrayInputStream) && !(inputStream instanceof BufferedInputStream) && !(inputStream instanceof SharedInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        this.headers = new InternetHeaders(inputStream);
        if (inputStream instanceof SharedInputStream) {
            SharedInputStream sharedInputStream = (SharedInputStream) inputStream;
            this.contentStream = sharedInputStream.newStream(sharedInputStream.getPosition(), -1);
            return;
        }
        try {
            this.content = ASCIIUtility.getBytes(inputStream);
        } catch (IOException e) {
            throw new MessagingException("Error reading input stream", e);
        }
    }

    public MimeBodyPart(InternetHeaders internetHeaders, byte[] bArr) throws MessagingException {
        this.headers = internetHeaders;
        this.content = bArr;
    }

    static String[] getContentLanguage(MimePart mimePart) throws MessagingException {
        String header = mimePart.getHeader("Content-Language", (String) null);
        if (header == null) {
            return null;
        }
        HeaderTokenizer headerTokenizer = new HeaderTokenizer(header, HeaderTokenizer.MIME);
        Vector vector = new Vector();
        while (true) {
            HeaderTokenizer.Token next = headerTokenizer.next();
            int type = next.getType();
            if (type == -4) {
                break;
            } else if (type == -1) {
                vector.addElement(next.getValue());
            }
        }
        if (vector.size() == 0) {
            return null;
        }
        String[] strArr = new String[vector.size()];
        vector.copyInto(strArr);
        return strArr;
    }

    static String getDescription(MimePart mimePart) throws MessagingException {
        String header = mimePart.getHeader("Content-Description", (String) null);
        if (header == null) {
            return null;
        }
        try {
            return MimeUtility.decodeText(MimeUtility.unfold(header));
        } catch (UnsupportedEncodingException unused) {
            return header;
        }
    }

    static String getDisposition(MimePart mimePart) throws MessagingException {
        String header = mimePart.getHeader("Content-Disposition", (String) null);
        if (header == null) {
            return null;
        }
        return new ContentDisposition(header).getDisposition();
    }

    static String getEncoding(MimePart mimePart) throws MessagingException {
        HeaderTokenizer.Token next;
        int type;
        String header = mimePart.getHeader(MIME.CONTENT_TRANSFER_ENC, (String) null);
        if (header == null) {
            return null;
        }
        String trim = header.trim();
        if (trim.equalsIgnoreCase("7bit") || trim.equalsIgnoreCase(MIME.ENC_8BIT) || trim.equalsIgnoreCase("quoted-printable") || trim.equalsIgnoreCase(MIME.ENC_BINARY) || trim.equalsIgnoreCase("base64")) {
            return trim;
        }
        HeaderTokenizer headerTokenizer = new HeaderTokenizer(trim, HeaderTokenizer.MIME);
        do {
            next = headerTokenizer.next();
            type = next.getType();
            if (type == -4) {
                return trim;
            }
        } while (type != -1);
        return next.getValue();
    }

    static String getFileName(MimePart mimePart) throws MessagingException {
        String str;
        String header;
        String header2 = mimePart.getHeader("Content-Disposition", (String) null);
        String parameter = header2 != null ? new ContentDisposition(header2).getParameter("filename") : null;
        if (parameter == null && (header = mimePart.getHeader("Content-Type", (String) null)) != null) {
            try {
                str = new ContentType(header).getParameter(b.c.f4838b);
            } catch (ParseException unused) {
            }
            if (decodeFileName || str == null) {
                return str;
            }
            try {
                return MimeUtility.decodeText(str);
            } catch (UnsupportedEncodingException e) {
                throw new MessagingException("Can't decode filename", e);
            }
        }
        str = parameter;
        if (decodeFileName) {
        }
        return str;
    }

    static void invalidateContentHeaders(MimePart mimePart) throws MessagingException {
        mimePart.removeHeader("Content-Type");
        mimePart.removeHeader(MIME.CONTENT_TRANSFER_ENC);
    }

    static boolean isMimeType(MimePart mimePart, String str) throws MessagingException {
        try {
            return new ContentType(mimePart.getContentType()).match(str);
        } catch (ParseException unused) {
            return mimePart.getContentType().equalsIgnoreCase(str);
        }
    }

    static void setContentLanguage(MimePart mimePart, String[] strArr) throws MessagingException {
        StringBuffer stringBuffer = new StringBuffer(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            stringBuffer.append(',');
            stringBuffer.append(strArr[i]);
        }
        mimePart.setHeader("Content-Language", stringBuffer.toString());
    }

    static void setDescription(MimePart mimePart, String str, String str2) throws MessagingException {
        if (str == null) {
            mimePart.removeHeader("Content-Description");
            return;
        }
        try {
            mimePart.setHeader("Content-Description", MimeUtility.fold(21, MimeUtility.encodeText(str, str2, (String) null)));
        } catch (UnsupportedEncodingException e) {
            throw new MessagingException("Encoding error", e);
        }
    }

    static void setDisposition(MimePart mimePart, String str) throws MessagingException {
        if (str == null) {
            mimePart.removeHeader("Content-Disposition");
            return;
        }
        String header = mimePart.getHeader("Content-Disposition", (String) null);
        if (header != null) {
            ContentDisposition contentDisposition = new ContentDisposition(header);
            contentDisposition.setDisposition(str);
            str = contentDisposition.toString();
        }
        mimePart.setHeader("Content-Disposition", str);
    }

    static void setEncoding(MimePart mimePart, String str) throws MessagingException {
        mimePart.setHeader(MIME.CONTENT_TRANSFER_ENC, str);
    }

    static void setFileName(MimePart mimePart, String str) throws MessagingException {
        String header;
        if (encodeFileName && str != null) {
            try {
                str = MimeUtility.encodeText(str);
            } catch (UnsupportedEncodingException e) {
                throw new MessagingException("Can't encode filename", e);
            }
        }
        String header2 = mimePart.getHeader("Content-Disposition", (String) null);
        if (header2 == null) {
            header2 = "attachment";
        }
        ContentDisposition contentDisposition = new ContentDisposition(header2);
        contentDisposition.setParameter("filename", str);
        mimePart.setHeader("Content-Disposition", contentDisposition.toString());
        if (setContentTypeFileName && (header = mimePart.getHeader("Content-Type", (String) null)) != null) {
            try {
                ContentType contentType = new ContentType(header);
                contentType.setParameter(b.c.f4838b, str);
                mimePart.setHeader("Content-Type", contentType.toString());
            } catch (ParseException unused) {
            }
        }
    }

    static void setText(MimePart mimePart, String str, String str2, String str3) throws MessagingException {
        if (str2 == null) {
            str2 = MimeUtility.checkAscii(str) != 1 ? MimeUtility.getDefaultMIMECharset() : "us-ascii";
        }
        mimePart.setContent(str, "text/" + str3 + "; charset=" + MimeUtility.quote(str2, HeaderTokenizer.MIME));
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049 A[Catch:{ IOException -> 0x00ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f A[Catch:{ IOException -> 0x00ee }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void updateHeaders(javax.mail.internet.MimePart r7) throws javax.mail.MessagingException {
        /*
            javax.activation.DataHandler r0 = r7.getDataHandler()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.String r1 = r0.getContentType()     // Catch:{ IOException -> 0x00ee }
            java.lang.String r2 = "Content-Type"
            java.lang.String[] r2 = r7.getHeader(r2)     // Catch:{ IOException -> 0x00ee }
            r3 = 0
            r4 = 1
            if (r2 != 0) goto L_0x0017
            r2 = 1
            goto L_0x0018
        L_0x0017:
            r2 = 0
        L_0x0018:
            javax.mail.internet.ContentType r5 = new javax.mail.internet.ContentType     // Catch:{ IOException -> 0x00ee }
            r5.<init>(r1)     // Catch:{ IOException -> 0x00ee }
            java.lang.String r6 = "multipart/*"
            boolean r6 = r5.match((java.lang.String) r6)     // Catch:{ IOException -> 0x00ee }
            if (r6 == 0) goto L_0x0078
            boolean r3 = r7 instanceof javax.mail.internet.MimeBodyPart     // Catch:{ IOException -> 0x00ee }
            if (r3 == 0) goto L_0x0038
            r3 = r7
            javax.mail.internet.MimeBodyPart r3 = (javax.mail.internet.MimeBodyPart) r3     // Catch:{ IOException -> 0x00ee }
            java.lang.Object r6 = r3.cachedContent     // Catch:{ IOException -> 0x00ee }
            if (r6 == 0) goto L_0x0033
            java.lang.Object r3 = r3.cachedContent     // Catch:{ IOException -> 0x00ee }
            goto L_0x0045
        L_0x0033:
            java.lang.Object r3 = r0.getContent()     // Catch:{ IOException -> 0x00ee }
            goto L_0x0045
        L_0x0038:
            boolean r3 = r7 instanceof javax.mail.internet.MimeMessage     // Catch:{ IOException -> 0x00ee }
            if (r3 == 0) goto L_0x0033
            r3 = r7
            javax.mail.internet.MimeMessage r3 = (javax.mail.internet.MimeMessage) r3     // Catch:{ IOException -> 0x00ee }
            java.lang.Object r6 = r3.cachedContent     // Catch:{ IOException -> 0x00ee }
            if (r6 == 0) goto L_0x0033
            java.lang.Object r3 = r3.cachedContent     // Catch:{ IOException -> 0x00ee }
        L_0x0045:
            boolean r6 = r3 instanceof javax.mail.internet.MimeMultipart     // Catch:{ IOException -> 0x00ee }
            if (r6 == 0) goto L_0x004f
            javax.mail.internet.MimeMultipart r3 = (javax.mail.internet.MimeMultipart) r3     // Catch:{ IOException -> 0x00ee }
            r3.updateHeaders()     // Catch:{ IOException -> 0x00ee }
            goto L_0x0082
        L_0x004f:
            javax.mail.MessagingException r7 = new javax.mail.MessagingException     // Catch:{ IOException -> 0x00ee }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ee }
            java.lang.String r2 = "MIME part of type \""
            r0.<init>(r2)     // Catch:{ IOException -> 0x00ee }
            r0.append(r1)     // Catch:{ IOException -> 0x00ee }
            java.lang.String r1 = "\" contains object of type "
            r0.append(r1)     // Catch:{ IOException -> 0x00ee }
            java.lang.Class r1 = r3.getClass()     // Catch:{ IOException -> 0x00ee }
            java.lang.String r1 = r1.getName()     // Catch:{ IOException -> 0x00ee }
            r0.append(r1)     // Catch:{ IOException -> 0x00ee }
            java.lang.String r1 = " instead of MimeMultipart"
            r0.append(r1)     // Catch:{ IOException -> 0x00ee }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x00ee }
            r7.<init>(r0)     // Catch:{ IOException -> 0x00ee }
            throw r7     // Catch:{ IOException -> 0x00ee }
        L_0x0078:
            java.lang.String r6 = "message/rfc822"
            boolean r6 = r5.match((java.lang.String) r6)     // Catch:{ IOException -> 0x00ee }
            if (r6 == 0) goto L_0x0081
            goto L_0x0082
        L_0x0081:
            r4 = 0
        L_0x0082:
            if (r4 != 0) goto L_0x00c7
            java.lang.String r3 = "Content-Transfer-Encoding"
            java.lang.String[] r3 = r7.getHeader(r3)     // Catch:{ IOException -> 0x00ee }
            if (r3 != 0) goto L_0x0093
            java.lang.String r0 = javax.mail.internet.MimeUtility.getEncoding((javax.activation.DataHandler) r0)     // Catch:{ IOException -> 0x00ee }
            setEncoding(r7, r0)     // Catch:{ IOException -> 0x00ee }
        L_0x0093:
            if (r2 == 0) goto L_0x00c7
            boolean r0 = setDefaultTextCharset     // Catch:{ IOException -> 0x00ee }
            if (r0 == 0) goto L_0x00c7
            java.lang.String r0 = "text/*"
            boolean r0 = r5.match((java.lang.String) r0)     // Catch:{ IOException -> 0x00ee }
            if (r0 == 0) goto L_0x00c7
            java.lang.String r0 = "charset"
            java.lang.String r0 = r5.getParameter(r0)     // Catch:{ IOException -> 0x00ee }
            if (r0 != 0) goto L_0x00c7
            java.lang.String r0 = r7.getEncoding()     // Catch:{ IOException -> 0x00ee }
            if (r0 == 0) goto L_0x00ba
            java.lang.String r1 = "7bit"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ IOException -> 0x00ee }
            if (r0 == 0) goto L_0x00ba
            java.lang.String r0 = "us-ascii"
            goto L_0x00be
        L_0x00ba:
            java.lang.String r0 = javax.mail.internet.MimeUtility.getDefaultMIMECharset()     // Catch:{ IOException -> 0x00ee }
        L_0x00be:
            java.lang.String r1 = "charset"
            r5.setParameter(r1, r0)     // Catch:{ IOException -> 0x00ee }
            java.lang.String r1 = r5.toString()     // Catch:{ IOException -> 0x00ee }
        L_0x00c7:
            if (r2 == 0) goto L_0x00ed
            java.lang.String r0 = "Content-Disposition"
            r2 = 0
            java.lang.String r0 = r7.getHeader(r0, r2)     // Catch:{ IOException -> 0x00ee }
            if (r0 == 0) goto L_0x00e8
            javax.mail.internet.ContentDisposition r2 = new javax.mail.internet.ContentDisposition     // Catch:{ IOException -> 0x00ee }
            r2.<init>(r0)     // Catch:{ IOException -> 0x00ee }
            java.lang.String r0 = "filename"
            java.lang.String r0 = r2.getParameter(r0)     // Catch:{ IOException -> 0x00ee }
            if (r0 == 0) goto L_0x00e8
            java.lang.String r1 = "name"
            r5.setParameter(r1, r0)     // Catch:{ IOException -> 0x00ee }
            java.lang.String r1 = r5.toString()     // Catch:{ IOException -> 0x00ee }
        L_0x00e8:
            java.lang.String r0 = "Content-Type"
            r7.setHeader(r0, r1)     // Catch:{ IOException -> 0x00ee }
        L_0x00ed:
            return
        L_0x00ee:
            r7 = move-exception
            javax.mail.MessagingException r0 = new javax.mail.MessagingException
            java.lang.String r1 = "IOException updating headers"
            r0.<init>(r1, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeBodyPart.updateHeaders(javax.mail.internet.MimePart):void");
    }

    static void writeTo(MimePart mimePart, OutputStream outputStream, String[] strArr) throws IOException, MessagingException {
        LineOutputStream lineOutputStream = outputStream instanceof LineOutputStream ? (LineOutputStream) outputStream : new LineOutputStream(outputStream);
        Enumeration nonMatchingHeaderLines = mimePart.getNonMatchingHeaderLines(strArr);
        while (nonMatchingHeaderLines.hasMoreElements()) {
            lineOutputStream.writeln((String) nonMatchingHeaderLines.nextElement());
        }
        lineOutputStream.writeln();
        OutputStream encode = MimeUtility.encode(outputStream, mimePart.getEncoding());
        mimePart.getDataHandler().writeTo(encode);
        encode.flush();
    }

    public void addHeader(String str, String str2) throws MessagingException {
        this.headers.addHeader(str, str2);
    }

    public void addHeaderLine(String str) throws MessagingException {
        this.headers.addHeaderLine(str);
    }

    public void attachFile(File file) throws IOException, MessagingException {
        FileDataSource fileDataSource = new FileDataSource(file);
        setDataHandler(new DataHandler((DataSource) fileDataSource));
        setFileName(fileDataSource.getName());
    }

    public void attachFile(String str) throws IOException, MessagingException {
        attachFile(new File(str));
    }

    public Enumeration getAllHeaderLines() throws MessagingException {
        return this.headers.getAllHeaderLines();
    }

    public Enumeration getAllHeaders() throws MessagingException {
        return this.headers.getAllHeaders();
    }

    public Object getContent() throws IOException, MessagingException {
        if (this.cachedContent != null) {
            return this.cachedContent;
        }
        try {
            Object content2 = getDataHandler().getContent();
            if (cacheMultipart && (((content2 instanceof Multipart) || (content2 instanceof Message)) && !(this.content == null && this.contentStream == null))) {
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
        return getContentLanguage(this);
    }

    public String getContentMD5() throws MessagingException {
        return getHeader(HttpHeaders.CONTENT_MD5, (String) null);
    }

    public InputStream getContentStream() throws MessagingException {
        if (this.contentStream != null) {
            return ((SharedInputStream) this.contentStream).newStream(0, -1);
        }
        if (this.content != null) {
            return new ByteArrayInputStream(this.content);
        }
        throw new MessagingException("No content");
    }

    public String getContentType() throws MessagingException {
        String header = getHeader("Content-Type", (String) null);
        return header == null ? "text/plain" : header;
    }

    public DataHandler getDataHandler() throws MessagingException {
        if (this.dh == null) {
            this.dh = new DataHandler((DataSource) new MimePartDataSource(this));
        }
        return this.dh;
    }

    public String getDescription() throws MessagingException {
        return getDescription(this);
    }

    public String getDisposition() throws MessagingException {
        return getDisposition(this);
    }

    public String getEncoding() throws MessagingException {
        return getEncoding(this);
    }

    public String getFileName() throws MessagingException {
        return getFileName(this);
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

    public Enumeration getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        return this.headers.getNonMatchingHeaderLines(strArr);
    }

    public Enumeration getNonMatchingHeaders(String[] strArr) throws MessagingException {
        return this.headers.getNonMatchingHeaders(strArr);
    }

    public InputStream getRawInputStream() throws MessagingException {
        return getContentStream();
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

    public boolean isMimeType(String str) throws MessagingException {
        return isMimeType(this, str);
    }

    public void removeHeader(String str) throws MessagingException {
        this.headers.removeHeader(str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:6|7|(2:8|(1:33)(3:16|17|18))|(2:11|12)|13|14|34) */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001e */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0032 A[SYNTHETIC, Splitter:B:25:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0037 A[SYNTHETIC, Splitter:B:29:0x0037] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveFile(java.io.File r6) throws java.io.IOException, javax.mail.MessagingException {
        /*
            r5 = this;
            r0 = 0
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x002e }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x002e }
            r2.<init>(r6)     // Catch:{ all -> 0x002e }
            r1.<init>(r2)     // Catch:{ all -> 0x002e }
            java.io.InputStream r6 = r5.getInputStream()     // Catch:{ all -> 0x002c }
            r0 = 8192(0x2000, float:1.14794E-41)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0027 }
        L_0x0013:
            int r2 = r6.read(r0)     // Catch:{ all -> 0x0027 }
            if (r2 > 0) goto L_0x0022
            if (r6 == 0) goto L_0x001e
            r6.close()     // Catch:{ IOException -> 0x001e }
        L_0x001e:
            r1.close()     // Catch:{ IOException -> 0x0021 }
        L_0x0021:
            return
        L_0x0022:
            r3 = 0
            r1.write(r0, r3, r2)     // Catch:{ all -> 0x0027 }
            goto L_0x0013
        L_0x0027:
            r0 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
            goto L_0x0030
        L_0x002c:
            r6 = move-exception
            goto L_0x0030
        L_0x002e:
            r6 = move-exception
            r1 = r0
        L_0x0030:
            if (r0 == 0) goto L_0x0035
            r0.close()     // Catch:{ IOException -> 0x0035 }
        L_0x0035:
            if (r1 == 0) goto L_0x003a
            r1.close()     // Catch:{ IOException -> 0x003a }
        L_0x003a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeBodyPart.saveFile(java.io.File):void");
    }

    public void saveFile(String str) throws IOException, MessagingException {
        saveFile(new File(str));
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
        setContentLanguage(this, strArr);
    }

    public void setContentMD5(String str) throws MessagingException {
        setHeader(HttpHeaders.CONTENT_MD5, str);
    }

    public void setDataHandler(DataHandler dataHandler) throws MessagingException {
        this.dh = dataHandler;
        this.cachedContent = null;
        invalidateContentHeaders(this);
    }

    public void setDescription(String str) throws MessagingException {
        setDescription(str, (String) null);
    }

    public void setDescription(String str, String str2) throws MessagingException {
        setDescription(this, str, str2);
    }

    public void setDisposition(String str) throws MessagingException {
        setDisposition(this, str);
    }

    public void setFileName(String str) throws MessagingException {
        setFileName(this, str);
    }

    public void setHeader(String str, String str2) throws MessagingException {
        this.headers.setHeader(str, str2);
    }

    public void setText(String str) throws MessagingException {
        setText(str, (String) null);
    }

    public void setText(String str, String str2) throws MessagingException {
        setText(this, str, str2, "plain");
    }

    public void setText(String str, String str2, String str3) throws MessagingException {
        setText(this, str, str2, str3);
    }

    public void updateHeaders() throws MessagingException {
        updateHeaders(this);
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

    public void writeTo(OutputStream outputStream) throws IOException, MessagingException {
        writeTo(this, outputStream, (String[]) null);
    }
}
