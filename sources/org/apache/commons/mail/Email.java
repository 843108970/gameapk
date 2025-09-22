package org.apache.commons.mail;

import com.cyjh.common.util.s;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public abstract class Email {
    @Deprecated
    public static final String ATTACHMENTS = "attachments";
    @Deprecated
    public static final String CONTENT_TYPE = "content.type";
    @Deprecated
    public static final String EMAIL_BODY = "email.body";
    @Deprecated
    public static final String EMAIL_SUBJECT = "email.subject";
    @Deprecated
    public static final String FILE_SERVER = "file.server";
    @Deprecated
    public static final String ISO_8859_1 = "iso-8859-1";
    @Deprecated
    public static final String KOI8_R = "koi8-r";
    @Deprecated
    public static final String MAIL_DEBUG = "mail.debug";
    @Deprecated
    public static final String MAIL_HOST = "mail.smtp.host";
    @Deprecated
    public static final String MAIL_PORT = "mail.smtp.port";
    @Deprecated
    public static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
    @Deprecated
    public static final String MAIL_SMTP_CONNECTIONTIMEOUT = "mail.smtp.connectiontimeout";
    @Deprecated
    public static final String MAIL_SMTP_FROM = "mail.smtp.from";
    @Deprecated
    public static final String MAIL_SMTP_PASSWORD = "mail.smtp.password";
    @Deprecated
    public static final String MAIL_SMTP_SOCKET_FACTORY_CLASS = "mail.smtp.socketFactory.class";
    @Deprecated
    public static final String MAIL_SMTP_SOCKET_FACTORY_FALLBACK = "mail.smtp.socketFactory.fallback";
    @Deprecated
    public static final String MAIL_SMTP_SOCKET_FACTORY_PORT = "mail.smtp.socketFactory.port";
    @Deprecated
    public static final String MAIL_SMTP_TIMEOUT = "mail.smtp.timeout";
    @Deprecated
    public static final String MAIL_SMTP_USER = "mail.smtp.user";
    @Deprecated
    public static final String MAIL_TRANSPORT_PROTOCOL = "mail.transport.protocol";
    @Deprecated
    public static final String MAIL_TRANSPORT_TLS = "mail.smtp.starttls.enable";
    @Deprecated
    public static final String RECEIVER_EMAIL = "receiver.email";
    @Deprecated
    public static final String RECEIVER_NAME = "receiver.name";
    @Deprecated
    public static final String SENDER_EMAIL = "sender.email";
    @Deprecated
    public static final String SENDER_NAME = "sender.name";
    @Deprecated
    public static final String SMTP = "smtp";
    @Deprecated
    public static final String TEXT_HTML = "text/html";
    @Deprecated
    public static final String TEXT_PLAIN = "text/plain";
    @Deprecated
    public static final String US_ASCII = "us-ascii";
    protected Authenticator authenticator;
    protected List<InternetAddress> bccList = new ArrayList();
    protected String bounceAddress;
    protected List<InternetAddress> ccList = new ArrayList();
    protected String charset;
    protected Object content;
    protected String contentType;
    protected boolean debug;
    protected MimeMultipart emailBody;
    protected InternetAddress fromAddress;
    protected Map<String, String> headers = new HashMap();
    protected String hostName;
    protected MimeMessage message;
    protected boolean popBeforeSmtp;
    protected String popHost;
    protected String popPassword;
    protected String popUsername;
    protected List<InternetAddress> replyList = new ArrayList();
    private boolean sendPartial;
    protected Date sentDate;
    private Session session;
    protected String smtpPort = "25";
    protected int socketConnectionTimeout = EmailConstants.SOCKET_TIMEOUT_MS;
    protected int socketTimeout = EmailConstants.SOCKET_TIMEOUT_MS;
    @Deprecated
    protected boolean ssl;
    private boolean sslCheckServerIdentity;
    private boolean sslOnConnect;
    protected String sslSmtpPort = "465";
    private boolean startTlsEnabled;
    private boolean startTlsRequired;
    protected String subject;
    @Deprecated
    protected boolean tls;
    protected List<InternetAddress> toList = new ArrayList();

    private void checkSessionAlreadyInitialized() {
        if (this.session != null) {
            throw new IllegalStateException("The mail session is already initialized");
        }
    }

    private String createFoldedHeaderValue(String str, Object obj) {
        if (EmailUtils.isEmpty(str)) {
            throw new IllegalArgumentException("name can not be null or empty");
        } else if (obj == null || EmailUtils.isEmpty(obj.toString())) {
            throw new IllegalArgumentException("value can not be null or empty");
        } else {
            try {
                return MimeUtility.fold(str.length() + 2, MimeUtility.encodeText(obj.toString(), this.charset, (String) null));
            } catch (UnsupportedEncodingException unused) {
                return obj.toString();
            }
        }
    }

    private InternetAddress createInternetAddress(String str, String str2, String str3) throws EmailException {
        try {
            InternetAddress internetAddress = new InternetAddress(str);
            if (EmailUtils.isNotEmpty(str2)) {
                if (EmailUtils.isEmpty(str3)) {
                    internetAddress.setPersonal(str2);
                } else {
                    internetAddress.setPersonal(str2, Charset.forName(str3).name());
                }
            }
            internetAddress.validate();
            return internetAddress;
        } catch (AddressException e) {
            throw new EmailException((Throwable) e);
        } catch (UnsupportedEncodingException e2) {
            throw new EmailException((Throwable) e2);
        }
    }

    public Email addBcc(String str) throws EmailException {
        return addBcc(str, (String) null);
    }

    public Email addBcc(String str, String str2) throws EmailException {
        return addBcc(str, str2, this.charset);
    }

    public Email addBcc(String str, String str2, String str3) throws EmailException {
        this.bccList.add(createInternetAddress(str, str2, str3));
        return this;
    }

    public Email addBcc(String... strArr) throws EmailException {
        if (strArr == null || strArr.length == 0) {
            throw new EmailException("Address List provided was invalid");
        }
        for (String addBcc : strArr) {
            addBcc(addBcc, (String) null);
        }
        return this;
    }

    public Email addCc(String str) throws EmailException {
        return addCc(str, (String) null);
    }

    public Email addCc(String str, String str2) throws EmailException {
        return addCc(str, str2, this.charset);
    }

    public Email addCc(String str, String str2, String str3) throws EmailException {
        this.ccList.add(createInternetAddress(str, str2, str3));
        return this;
    }

    public Email addCc(String... strArr) throws EmailException {
        if (strArr == null || strArr.length == 0) {
            throw new EmailException("Address List provided was invalid");
        }
        for (String addCc : strArr) {
            addCc(addCc, (String) null);
        }
        return this;
    }

    public void addHeader(String str, String str2) {
        if (EmailUtils.isEmpty(str)) {
            throw new IllegalArgumentException("name can not be null or empty");
        } else if (EmailUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("value can not be null or empty");
        } else {
            this.headers.put(str, str2);
        }
    }

    public Email addReplyTo(String str) throws EmailException {
        return addReplyTo(str, (String) null);
    }

    public Email addReplyTo(String str, String str2) throws EmailException {
        return addReplyTo(str, str2, this.charset);
    }

    public Email addReplyTo(String str, String str2, String str3) throws EmailException {
        this.replyList.add(createInternetAddress(str, str2, str3));
        return this;
    }

    public Email addTo(String str) throws EmailException {
        return addTo(str, (String) null);
    }

    public Email addTo(String str, String str2) throws EmailException {
        return addTo(str, str2, this.charset);
    }

    public Email addTo(String str, String str2, String str3) throws EmailException {
        this.toList.add(createInternetAddress(str, str2, str3));
        return this;
    }

    public Email addTo(String... strArr) throws EmailException {
        if (strArr == null || strArr.length == 0) {
            throw new EmailException("Address List provided was invalid");
        }
        for (String addTo : strArr) {
            addTo(addTo, (String) null);
        }
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008a A[Catch:{ MessagingException -> 0x017d }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0092 A[Catch:{ MessagingException -> 0x017d }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c4 A[Catch:{ MessagingException -> 0x017d }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00cc A[Catch:{ MessagingException -> 0x017d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void buildMimeMessage() throws org.apache.commons.mail.EmailException {
        /*
            r4 = this;
            javax.mail.internet.MimeMessage r0 = r4.message
            if (r0 == 0) goto L_0x000c
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "The MimeMessage is already built."
            r0.<init>(r1)
            throw r0
        L_0x000c:
            javax.mail.Session r0 = r4.getMailSession()     // Catch:{ MessagingException -> 0x017d }
            javax.mail.internet.MimeMessage r0 = r4.createMimeMessage(r0)     // Catch:{ MessagingException -> 0x017d }
            r4.message = r0     // Catch:{ MessagingException -> 0x017d }
            java.lang.String r0 = r4.subject     // Catch:{ MessagingException -> 0x017d }
            boolean r0 = org.apache.commons.mail.EmailUtils.isNotEmpty(r0)     // Catch:{ MessagingException -> 0x017d }
            if (r0 == 0) goto L_0x0037
            java.lang.String r0 = r4.charset     // Catch:{ MessagingException -> 0x017d }
            boolean r0 = org.apache.commons.mail.EmailUtils.isNotEmpty(r0)     // Catch:{ MessagingException -> 0x017d }
            if (r0 == 0) goto L_0x0030
            javax.mail.internet.MimeMessage r0 = r4.message     // Catch:{ MessagingException -> 0x017d }
            java.lang.String r1 = r4.subject     // Catch:{ MessagingException -> 0x017d }
            java.lang.String r2 = r4.charset     // Catch:{ MessagingException -> 0x017d }
            r0.setSubject(r1, r2)     // Catch:{ MessagingException -> 0x017d }
            goto L_0x0037
        L_0x0030:
            javax.mail.internet.MimeMessage r0 = r4.message     // Catch:{ MessagingException -> 0x017d }
            java.lang.String r1 = r4.subject     // Catch:{ MessagingException -> 0x017d }
            r0.setSubject(r1)     // Catch:{ MessagingException -> 0x017d }
        L_0x0037:
            java.lang.String r0 = r4.contentType     // Catch:{ MessagingException -> 0x017d }
            r4.updateContentType(r0)     // Catch:{ MessagingException -> 0x017d }
            java.lang.Object r0 = r4.content     // Catch:{ MessagingException -> 0x017d }
            if (r0 == 0) goto L_0x0068
            java.lang.String r0 = "text/plain"
            java.lang.String r1 = r4.contentType     // Catch:{ MessagingException -> 0x017d }
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ MessagingException -> 0x017d }
            if (r0 == 0) goto L_0x005e
            java.lang.Object r0 = r4.content     // Catch:{ MessagingException -> 0x017d }
            boolean r0 = r0 instanceof java.lang.String     // Catch:{ MessagingException -> 0x017d }
            if (r0 == 0) goto L_0x005e
            javax.mail.internet.MimeMessage r0 = r4.message     // Catch:{ MessagingException -> 0x017d }
            java.lang.Object r1 = r4.content     // Catch:{ MessagingException -> 0x017d }
            java.lang.String r1 = r1.toString()     // Catch:{ MessagingException -> 0x017d }
            java.lang.String r2 = r4.charset     // Catch:{ MessagingException -> 0x017d }
            r0.setText(r1, r2)     // Catch:{ MessagingException -> 0x017d }
            goto L_0x0086
        L_0x005e:
            javax.mail.internet.MimeMessage r0 = r4.message     // Catch:{ MessagingException -> 0x017d }
            java.lang.Object r1 = r4.content     // Catch:{ MessagingException -> 0x017d }
            java.lang.String r2 = r4.contentType     // Catch:{ MessagingException -> 0x017d }
        L_0x0064:
            r0.setContent(r1, r2)     // Catch:{ MessagingException -> 0x017d }
            goto L_0x0086
        L_0x0068:
            javax.mail.internet.MimeMultipart r0 = r4.emailBody     // Catch:{ MessagingException -> 0x017d }
            if (r0 == 0) goto L_0x007f
            java.lang.String r0 = r4.contentType     // Catch:{ MessagingException -> 0x017d }
            if (r0 != 0) goto L_0x0078
            javax.mail.internet.MimeMessage r0 = r4.message     // Catch:{ MessagingException -> 0x017d }
            javax.mail.internet.MimeMultipart r1 = r4.emailBody     // Catch:{ MessagingException -> 0x017d }
            r0.setContent(r1)     // Catch:{ MessagingException -> 0x017d }
            goto L_0x0086
        L_0x0078:
            javax.mail.internet.MimeMessage r0 = r4.message     // Catch:{ MessagingException -> 0x017d }
            javax.mail.internet.MimeMultipart r1 = r4.emailBody     // Catch:{ MessagingException -> 0x017d }
            java.lang.String r2 = r4.contentType     // Catch:{ MessagingException -> 0x017d }
            goto L_0x0064
        L_0x007f:
            javax.mail.internet.MimeMessage r0 = r4.message     // Catch:{ MessagingException -> 0x017d }
            java.lang.String r1 = ""
            r0.setText(r1)     // Catch:{ MessagingException -> 0x017d }
        L_0x0086:
            javax.mail.internet.InternetAddress r0 = r4.fromAddress     // Catch:{ MessagingException -> 0x017d }
            if (r0 == 0) goto L_0x0092
            javax.mail.internet.MimeMessage r0 = r4.message     // Catch:{ MessagingException -> 0x017d }
            javax.mail.internet.InternetAddress r1 = r4.fromAddress     // Catch:{ MessagingException -> 0x017d }
            r0.setFrom(r1)     // Catch:{ MessagingException -> 0x017d }
            goto L_0x00ae
        L_0x0092:
            javax.mail.Session r0 = r4.session     // Catch:{ MessagingException -> 0x017d }
            java.lang.String r1 = "mail.smtp.from"
            java.lang.String r0 = r0.getProperty(r1)     // Catch:{ MessagingException -> 0x017d }
            if (r0 != 0) goto L_0x00ae
            javax.mail.Session r0 = r4.session     // Catch:{ MessagingException -> 0x017d }
            java.lang.String r1 = "mail.from"
            java.lang.String r0 = r0.getProperty(r1)     // Catch:{ MessagingException -> 0x017d }
            if (r0 != 0) goto L_0x00ae
            org.apache.commons.mail.EmailException r0 = new org.apache.commons.mail.EmailException     // Catch:{ MessagingException -> 0x017d }
            java.lang.String r1 = "From address required"
            r0.<init>((java.lang.String) r1)     // Catch:{ MessagingException -> 0x017d }
            throw r0     // Catch:{ MessagingException -> 0x017d }
        L_0x00ae:
            java.util.List<javax.mail.internet.InternetAddress> r0 = r4.toList     // Catch:{ MessagingException -> 0x017d }
            int r0 = r0.size()     // Catch:{ MessagingException -> 0x017d }
            java.util.List<javax.mail.internet.InternetAddress> r1 = r4.ccList     // Catch:{ MessagingException -> 0x017d }
            int r1 = r1.size()     // Catch:{ MessagingException -> 0x017d }
            int r0 = r0 + r1
            java.util.List<javax.mail.internet.InternetAddress> r1 = r4.bccList     // Catch:{ MessagingException -> 0x017d }
            int r1 = r1.size()     // Catch:{ MessagingException -> 0x017d }
            int r0 = r0 + r1
            if (r0 != 0) goto L_0x00cc
            org.apache.commons.mail.EmailException r0 = new org.apache.commons.mail.EmailException     // Catch:{ MessagingException -> 0x017d }
            java.lang.String r1 = "At least one receiver address required"
            r0.<init>((java.lang.String) r1)     // Catch:{ MessagingException -> 0x017d }
            throw r0     // Catch:{ MessagingException -> 0x017d }
        L_0x00cc:
            java.util.List<javax.mail.internet.InternetAddress> r0 = r4.toList     // Catch:{ MessagingException -> 0x017d }
            int r0 = r0.size()     // Catch:{ MessagingException -> 0x017d }
            if (r0 <= 0) goto L_0x00e1
            javax.mail.internet.MimeMessage r0 = r4.message     // Catch:{ MessagingException -> 0x017d }
            javax.mail.Message$RecipientType r1 = javax.mail.Message.RecipientType.TO     // Catch:{ MessagingException -> 0x017d }
            java.util.List<javax.mail.internet.InternetAddress> r2 = r4.toList     // Catch:{ MessagingException -> 0x017d }
            javax.mail.internet.InternetAddress[] r2 = r4.toInternetAddressArray(r2)     // Catch:{ MessagingException -> 0x017d }
            r0.setRecipients((javax.mail.Message.RecipientType) r1, (javax.mail.Address[]) r2)     // Catch:{ MessagingException -> 0x017d }
        L_0x00e1:
            java.util.List<javax.mail.internet.InternetAddress> r0 = r4.ccList     // Catch:{ MessagingException -> 0x017d }
            int r0 = r0.size()     // Catch:{ MessagingException -> 0x017d }
            if (r0 <= 0) goto L_0x00f6
            javax.mail.internet.MimeMessage r0 = r4.message     // Catch:{ MessagingException -> 0x017d }
            javax.mail.Message$RecipientType r1 = javax.mail.Message.RecipientType.CC     // Catch:{ MessagingException -> 0x017d }
            java.util.List<javax.mail.internet.InternetAddress> r2 = r4.ccList     // Catch:{ MessagingException -> 0x017d }
            javax.mail.internet.InternetAddress[] r2 = r4.toInternetAddressArray(r2)     // Catch:{ MessagingException -> 0x017d }
            r0.setRecipients((javax.mail.Message.RecipientType) r1, (javax.mail.Address[]) r2)     // Catch:{ MessagingException -> 0x017d }
        L_0x00f6:
            java.util.List<javax.mail.internet.InternetAddress> r0 = r4.bccList     // Catch:{ MessagingException -> 0x017d }
            int r0 = r0.size()     // Catch:{ MessagingException -> 0x017d }
            if (r0 <= 0) goto L_0x010b
            javax.mail.internet.MimeMessage r0 = r4.message     // Catch:{ MessagingException -> 0x017d }
            javax.mail.Message$RecipientType r1 = javax.mail.Message.RecipientType.BCC     // Catch:{ MessagingException -> 0x017d }
            java.util.List<javax.mail.internet.InternetAddress> r2 = r4.bccList     // Catch:{ MessagingException -> 0x017d }
            javax.mail.internet.InternetAddress[] r2 = r4.toInternetAddressArray(r2)     // Catch:{ MessagingException -> 0x017d }
            r0.setRecipients((javax.mail.Message.RecipientType) r1, (javax.mail.Address[]) r2)     // Catch:{ MessagingException -> 0x017d }
        L_0x010b:
            java.util.List<javax.mail.internet.InternetAddress> r0 = r4.replyList     // Catch:{ MessagingException -> 0x017d }
            int r0 = r0.size()     // Catch:{ MessagingException -> 0x017d }
            if (r0 <= 0) goto L_0x011e
            javax.mail.internet.MimeMessage r0 = r4.message     // Catch:{ MessagingException -> 0x017d }
            java.util.List<javax.mail.internet.InternetAddress> r1 = r4.replyList     // Catch:{ MessagingException -> 0x017d }
            javax.mail.internet.InternetAddress[] r1 = r4.toInternetAddressArray(r1)     // Catch:{ MessagingException -> 0x017d }
            r0.setReplyTo(r1)     // Catch:{ MessagingException -> 0x017d }
        L_0x011e:
            java.util.Map<java.lang.String, java.lang.String> r0 = r4.headers     // Catch:{ MessagingException -> 0x017d }
            int r0 = r0.size()     // Catch:{ MessagingException -> 0x017d }
            if (r0 <= 0) goto L_0x0156
            java.util.Map<java.lang.String, java.lang.String> r0 = r4.headers     // Catch:{ MessagingException -> 0x017d }
            java.util.Set r0 = r0.entrySet()     // Catch:{ MessagingException -> 0x017d }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ MessagingException -> 0x017d }
        L_0x0130:
            boolean r1 = r0.hasNext()     // Catch:{ MessagingException -> 0x017d }
            if (r1 == 0) goto L_0x0156
            java.lang.Object r1 = r0.next()     // Catch:{ MessagingException -> 0x017d }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ MessagingException -> 0x017d }
            java.lang.Object r2 = r1.getKey()     // Catch:{ MessagingException -> 0x017d }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ MessagingException -> 0x017d }
            java.lang.Object r3 = r1.getValue()     // Catch:{ MessagingException -> 0x017d }
            java.lang.String r2 = r4.createFoldedHeaderValue(r2, r3)     // Catch:{ MessagingException -> 0x017d }
            javax.mail.internet.MimeMessage r3 = r4.message     // Catch:{ MessagingException -> 0x017d }
            java.lang.Object r1 = r1.getKey()     // Catch:{ MessagingException -> 0x017d }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ MessagingException -> 0x017d }
            r3.addHeader(r1, r2)     // Catch:{ MessagingException -> 0x017d }
            goto L_0x0130
        L_0x0156:
            javax.mail.internet.MimeMessage r0 = r4.message     // Catch:{ MessagingException -> 0x017d }
            java.util.Date r0 = r0.getSentDate()     // Catch:{ MessagingException -> 0x017d }
            if (r0 != 0) goto L_0x0167
            javax.mail.internet.MimeMessage r0 = r4.message     // Catch:{ MessagingException -> 0x017d }
            java.util.Date r1 = r4.getSentDate()     // Catch:{ MessagingException -> 0x017d }
            r0.setSentDate(r1)     // Catch:{ MessagingException -> 0x017d }
        L_0x0167:
            boolean r0 = r4.popBeforeSmtp     // Catch:{ MessagingException -> 0x017d }
            if (r0 == 0) goto L_0x017c
            javax.mail.Session r0 = r4.session     // Catch:{ MessagingException -> 0x017d }
            java.lang.String r1 = "pop3"
            javax.mail.Store r0 = r0.getStore((java.lang.String) r1)     // Catch:{ MessagingException -> 0x017d }
            java.lang.String r1 = r4.popHost     // Catch:{ MessagingException -> 0x017d }
            java.lang.String r2 = r4.popUsername     // Catch:{ MessagingException -> 0x017d }
            java.lang.String r3 = r4.popPassword     // Catch:{ MessagingException -> 0x017d }
            r0.connect(r1, r2, r3)     // Catch:{ MessagingException -> 0x017d }
        L_0x017c:
            return
        L_0x017d:
            r0 = move-exception
            org.apache.commons.mail.EmailException r1 = new org.apache.commons.mail.EmailException
            r1.<init>((java.lang.Throwable) r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.mail.Email.buildMimeMessage():void");
    }

    /* access modifiers changed from: protected */
    public MimeMessage createMimeMessage(Session session2) {
        return new MimeMessage(session2);
    }

    public List<InternetAddress> getBccAddresses() {
        return this.bccList;
    }

    public String getBounceAddress() {
        return this.bounceAddress;
    }

    public List<InternetAddress> getCcAddresses() {
        return this.ccList;
    }

    public InternetAddress getFromAddress() {
        return this.fromAddress;
    }

    public String getHostName() {
        if (this.session != null) {
            return this.session.getProperty("mail.smtp.host");
        }
        if (EmailUtils.isNotEmpty(this.hostName)) {
            return this.hostName;
        }
        return null;
    }

    public Session getMailSession() throws EmailException {
        if (this.session == null) {
            Properties properties = new Properties(System.getProperties());
            properties.setProperty("mail.transport.protocol", "smtp");
            if (EmailUtils.isEmpty(this.hostName)) {
                this.hostName = properties.getProperty("mail.smtp.host");
            }
            if (EmailUtils.isEmpty(this.hostName)) {
                throw new EmailException("Cannot find valid hostname for mail session");
            }
            properties.setProperty("mail.smtp.port", this.smtpPort);
            properties.setProperty("mail.smtp.host", this.hostName);
            properties.setProperty("mail.debug", String.valueOf(this.debug));
            properties.setProperty("mail.smtp.starttls.enable", isStartTLSEnabled() ? "true" : "false");
            properties.setProperty(EmailConstants.MAIL_TRANSPORT_STARTTLS_REQUIRED, isStartTLSRequired() ? "true" : "false");
            properties.setProperty(EmailConstants.MAIL_SMTP_SEND_PARTIAL, isSendPartial() ? "true" : "false");
            properties.setProperty(EmailConstants.MAIL_SMTPS_SEND_PARTIAL, isSendPartial() ? "true" : "false");
            if (this.authenticator != null) {
                properties.setProperty("mail.smtp.auth", "true");
            }
            if (isSSLOnConnect()) {
                properties.setProperty("mail.smtp.port", this.sslSmtpPort);
                properties.setProperty("mail.smtp.socketFactory.port", this.sslSmtpPort);
                properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                properties.setProperty("mail.smtp.socketFactory.fallback", "false");
            }
            if ((isSSLOnConnect() || isStartTLSEnabled()) && isSSLCheckServerIdentity()) {
                properties.setProperty(EmailConstants.MAIL_SMTP_SSL_CHECKSERVERIDENTITY, "true");
            }
            if (this.bounceAddress != null) {
                properties.setProperty("mail.smtp.from", this.bounceAddress);
            }
            if (this.socketTimeout > 0) {
                properties.setProperty("mail.smtp.timeout", Integer.toString(this.socketTimeout));
            }
            if (this.socketConnectionTimeout > 0) {
                properties.setProperty("mail.smtp.connectiontimeout", Integer.toString(this.socketConnectionTimeout));
            }
            this.session = Session.getInstance(properties, this.authenticator);
        }
        return this.session;
    }

    public MimeMessage getMimeMessage() {
        return this.message;
    }

    public List<InternetAddress> getReplyToAddresses() {
        return this.replyList;
    }

    public Date getSentDate() {
        return this.sentDate == null ? new Date() : new Date(this.sentDate.getTime());
    }

    public String getSmtpPort() {
        if (this.session != null) {
            return this.session.getProperty("mail.smtp.port");
        }
        if (EmailUtils.isNotEmpty(this.smtpPort)) {
            return this.smtpPort;
        }
        return null;
    }

    public int getSocketConnectionTimeout() {
        return this.socketConnectionTimeout;
    }

    public int getSocketTimeout() {
        return this.socketTimeout;
    }

    public String getSslSmtpPort() {
        if (this.session != null) {
            return this.session.getProperty("mail.smtp.socketFactory.port");
        }
        if (EmailUtils.isNotEmpty(this.sslSmtpPort)) {
            return this.sslSmtpPort;
        }
        return null;
    }

    public String getSubject() {
        return this.subject;
    }

    public List<InternetAddress> getToAddresses() {
        return this.toList;
    }

    @Deprecated
    public boolean isSSL() {
        return isSSLOnConnect();
    }

    public boolean isSSLCheckServerIdentity() {
        return this.sslCheckServerIdentity;
    }

    public boolean isSSLOnConnect() {
        return this.sslOnConnect || this.ssl;
    }

    public boolean isSendPartial() {
        return this.sendPartial;
    }

    public boolean isStartTLSEnabled() {
        return this.startTlsEnabled || this.tls;
    }

    public boolean isStartTLSRequired() {
        return this.startTlsRequired;
    }

    @Deprecated
    public boolean isTLS() {
        return isStartTLSEnabled();
    }

    public String send() throws EmailException {
        buildMimeMessage();
        return sendMimeMessage();
    }

    public String sendMimeMessage() throws EmailException {
        EmailUtils.notNull(this.message, "MimeMessage has not been created yet");
        try {
            Transport.send(this.message);
            return this.message.getMessageID();
        } catch (Throwable th) {
            throw new EmailException("Sending the email to the following server failed : " + getHostName() + ":" + getSmtpPort(), th);
        }
    }

    public void setAuthentication(String str, String str2) {
        setAuthenticator(new DefaultAuthenticator(str, str2));
    }

    public void setAuthenticator(Authenticator authenticator2) {
        this.authenticator = authenticator2;
    }

    public Email setBcc(Collection<InternetAddress> collection) throws EmailException {
        if (collection == null || collection.isEmpty()) {
            throw new EmailException("Address List provided was invalid");
        }
        this.bccList = new ArrayList(collection);
        return this;
    }

    public Email setBounceAddress(String str) {
        checkSessionAlreadyInitialized();
        this.bounceAddress = str;
        return this;
    }

    public Email setCc(Collection<InternetAddress> collection) throws EmailException {
        if (collection == null || collection.isEmpty()) {
            throw new EmailException("Address List provided was invalid");
        }
        this.ccList = new ArrayList(collection);
        return this;
    }

    public void setCharset(String str) {
        this.charset = Charset.forName(str).name();
    }

    public void setContent(Object obj, String str) {
        this.content = obj;
        updateContentType(str);
    }

    public void setContent(MimeMultipart mimeMultipart) {
        this.emailBody = mimeMultipart;
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public Email setFrom(String str) throws EmailException {
        return setFrom(str, (String) null);
    }

    public Email setFrom(String str, String str2) throws EmailException {
        return setFrom(str, str2, this.charset);
    }

    public Email setFrom(String str, String str2, String str3) throws EmailException {
        this.fromAddress = createInternetAddress(str, str2, str3);
        return this;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers.clear();
        for (Map.Entry next : map.entrySet()) {
            addHeader((String) next.getKey(), (String) next.getValue());
        }
    }

    public void setHostName(String str) {
        checkSessionAlreadyInitialized();
        this.hostName = str;
    }

    public void setMailSession(Session session2) {
        EmailUtils.notNull(session2, "no mail session supplied");
        Properties properties = session2.getProperties();
        if ("true".equalsIgnoreCase(properties.getProperty("mail.smtp.auth"))) {
            String property = properties.getProperty("mail.smtp.user");
            String property2 = properties.getProperty("mail.smtp.password");
            if (!EmailUtils.isNotEmpty(property) || !EmailUtils.isNotEmpty(property2)) {
                this.session = session2;
                return;
            }
            this.authenticator = new DefaultAuthenticator(property, property2);
            this.session = Session.getInstance(properties, this.authenticator);
            return;
        }
        this.session = session2;
    }

    public void setMailSessionFromJNDI(String str) throws NamingException {
        if (EmailUtils.isEmpty(str)) {
            throw new IllegalArgumentException("JNDI name missing");
        }
        setMailSession((Session) (str.startsWith("java:") ? new InitialContext() : (Context) new InitialContext().lookup("java:comp/env")).lookup(str));
    }

    public abstract Email setMsg(String str) throws EmailException;

    public void setPopBeforeSmtp(boolean z, String str, String str2, String str3) {
        this.popBeforeSmtp = z;
        this.popHost = str;
        this.popUsername = str2;
        this.popPassword = str3;
    }

    public Email setReplyTo(Collection<InternetAddress> collection) throws EmailException {
        if (collection == null || collection.isEmpty()) {
            throw new EmailException("Address List provided was invalid");
        }
        this.replyList = new ArrayList(collection);
        return this;
    }

    @Deprecated
    public void setSSL(boolean z) {
        setSSLOnConnect(z);
    }

    public Email setSSLCheckServerIdentity(boolean z) {
        checkSessionAlreadyInitialized();
        this.sslCheckServerIdentity = z;
        return this;
    }

    public Email setSSLOnConnect(boolean z) {
        checkSessionAlreadyInitialized();
        this.sslOnConnect = z;
        this.ssl = z;
        return this;
    }

    public Email setSendPartial(boolean z) {
        checkSessionAlreadyInitialized();
        this.sendPartial = z;
        return this;
    }

    public void setSentDate(Date date) {
        if (date != null) {
            this.sentDate = new Date(date.getTime());
        }
    }

    public void setSmtpPort(int i) {
        checkSessionAlreadyInitialized();
        if (i <= 0) {
            throw new IllegalArgumentException("Cannot connect to a port number that is less than 1 ( " + i + " )");
        }
        this.smtpPort = Integer.toString(i);
    }

    public void setSocketConnectionTimeout(int i) {
        checkSessionAlreadyInitialized();
        this.socketConnectionTimeout = i;
    }

    public void setSocketTimeout(int i) {
        checkSessionAlreadyInitialized();
        this.socketTimeout = i;
    }

    public void setSslSmtpPort(String str) {
        checkSessionAlreadyInitialized();
        this.sslSmtpPort = str;
    }

    public Email setStartTLSEnabled(boolean z) {
        checkSessionAlreadyInitialized();
        this.startTlsEnabled = z;
        this.tls = z;
        return this;
    }

    public Email setStartTLSRequired(boolean z) {
        checkSessionAlreadyInitialized();
        this.startTlsRequired = z;
        return this;
    }

    public Email setSubject(String str) {
        this.subject = str;
        return this;
    }

    @Deprecated
    public void setTLS(boolean z) {
        setStartTLSEnabled(z);
    }

    public Email setTo(Collection<InternetAddress> collection) throws EmailException {
        if (collection == null || collection.isEmpty()) {
            throw new EmailException("Address List provided was invalid");
        }
        this.toList = new ArrayList(collection);
        return this;
    }

    /* access modifiers changed from: protected */
    public InternetAddress[] toInternetAddressArray(List<InternetAddress> list) {
        return (InternetAddress[]) list.toArray(new InternetAddress[list.size()]);
    }

    public void updateContentType(String str) {
        if (EmailUtils.isEmpty(str)) {
            this.contentType = null;
            return;
        }
        this.contentType = str;
        int indexOf = str.toLowerCase().indexOf("; charset=");
        if (indexOf != -1) {
            int i = indexOf + 10;
            int indexOf2 = str.toLowerCase().indexOf(s.a.f1696a, i);
            if (indexOf2 != -1) {
                this.charset = str.substring(i, indexOf2);
            } else {
                this.charset = str.substring(i);
            }
        } else if (this.contentType.startsWith("text/") && EmailUtils.isNotEmpty(this.charset)) {
            StringBuffer stringBuffer = new StringBuffer(this.contentType);
            stringBuffer.append("; charset=");
            stringBuffer.append(this.charset);
            this.contentType = stringBuffer.toString();
        }
    }
}
