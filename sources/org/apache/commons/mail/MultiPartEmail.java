package org.apache.commons.mail;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.URLDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimePart;
import javax.mail.internet.MimeUtility;

public class MultiPartEmail extends Email {
    private boolean boolHasAttachments;
    private MimeMultipart container;
    private boolean initialized;
    private BodyPart primaryBodyPart;
    private String subType;

    public Email addPart(String str, String str2) throws EmailException {
        BodyPart createBodyPart = createBodyPart();
        try {
            createBodyPart.setContent(str, str2);
            getContainer().addBodyPart(createBodyPart);
            return this;
        } catch (MessagingException e) {
            throw new EmailException((Throwable) e);
        }
    }

    public Email addPart(MimeMultipart mimeMultipart) throws EmailException {
        try {
            return addPart(mimeMultipart, getContainer().getCount());
        } catch (MessagingException e) {
            throw new EmailException((Throwable) e);
        }
    }

    public Email addPart(MimeMultipart mimeMultipart, int i) throws EmailException {
        BodyPart createBodyPart = createBodyPart();
        try {
            createBodyPart.setContent(mimeMultipart);
            getContainer().addBodyPart(createBodyPart, i);
            return this;
        } catch (MessagingException e) {
            throw new EmailException((Throwable) e);
        }
    }

    public MultiPartEmail attach(File file) throws EmailException {
        String absolutePath = file.getAbsolutePath();
        try {
            if (file.exists()) {
                return attach((DataSource) new FileDataSource(file), file.getName(), (String) null, "attachment");
            }
            throw new IOException("\"" + absolutePath + "\" does not exist");
        } catch (IOException e) {
            throw new EmailException("Cannot attach file \"" + absolutePath + "\"", e);
        }
    }

    public MultiPartEmail attach(URL url, String str, String str2) throws EmailException {
        return attach(url, str, str2, "attachment");
    }

    public MultiPartEmail attach(URL url, String str, String str2, String str3) throws EmailException {
        try {
            url.openStream().close();
            return attach((DataSource) new URLDataSource(url), str, str2, str3);
        } catch (IOException e) {
            throw new EmailException("Invalid URL set:" + url, e);
        }
    }

    public MultiPartEmail attach(DataSource dataSource, String str, String str2) throws EmailException {
        InputStream inputStream;
        if (dataSource != null) {
            try {
                inputStream = dataSource.getInputStream();
            } catch (IOException e) {
                throw new EmailException("Invalid Datasource", e);
            }
        } else {
            inputStream = null;
        }
        if (inputStream != null) {
            inputStream.close();
        }
        if (inputStream != null) {
            return attach(dataSource, str, str2, "attachment");
        }
        throw new EmailException("Invalid Datasource");
    }

    public MultiPartEmail attach(DataSource dataSource, String str, String str2, String str3) throws EmailException {
        if (EmailUtils.isEmpty(str)) {
            str = dataSource.getName();
        }
        BodyPart createBodyPart = createBodyPart();
        try {
            createBodyPart.setDisposition(str3);
            createBodyPart.setFileName(MimeUtility.encodeText(str));
            createBodyPart.setDescription(str2);
            createBodyPart.setDataHandler(new DataHandler(dataSource));
            getContainer().addBodyPart(createBodyPart);
            setBoolHasAttachments(true);
            return this;
        } catch (UnsupportedEncodingException e) {
            throw new EmailException((Throwable) e);
        } catch (MessagingException e2) {
            throw new EmailException((Throwable) e2);
        }
    }

    public MultiPartEmail attach(EmailAttachment emailAttachment) throws EmailException {
        String str;
        if (emailAttachment == null) {
            throw new EmailException("Invalid attachment supplied");
        }
        URL url = emailAttachment.getURL();
        if (url != null) {
            return attach(url, emailAttachment.getName(), emailAttachment.getDescription(), emailAttachment.getDisposition());
        }
        try {
            str = emailAttachment.getPath();
            try {
                File file = new File(str);
                if (file.exists()) {
                    return attach((DataSource) new FileDataSource(file), emailAttachment.getName(), emailAttachment.getDescription(), emailAttachment.getDisposition());
                }
                throw new IOException("\"" + str + "\" does not exist");
            } catch (IOException e) {
                e = e;
                throw new EmailException("Cannot attach file \"" + str + "\"", e);
            }
        } catch (IOException e2) {
            e = e2;
            str = null;
            throw new EmailException("Cannot attach file \"" + str + "\"", e);
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000b */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x000f A[Catch:{ MessagingException -> 0x001c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void buildMimeMessage() throws org.apache.commons.mail.EmailException {
        /*
            r2 = this;
            javax.mail.BodyPart r0 = r2.primaryBodyPart     // Catch:{ MessagingException -> 0x001c }
            if (r0 == 0) goto L_0x000b
            javax.mail.BodyPart r0 = r2.getPrimaryBodyPart()     // Catch:{ MessagingException -> 0x001c }
            r0.getContent()     // Catch:{ IOException -> 0x000b }
        L_0x000b:
            java.lang.String r0 = r2.subType     // Catch:{ MessagingException -> 0x001c }
            if (r0 == 0) goto L_0x0018
            javax.mail.internet.MimeMultipart r0 = r2.getContainer()     // Catch:{ MessagingException -> 0x001c }
            java.lang.String r1 = r2.subType     // Catch:{ MessagingException -> 0x001c }
            r0.setSubType(r1)     // Catch:{ MessagingException -> 0x001c }
        L_0x0018:
            super.buildMimeMessage()     // Catch:{ MessagingException -> 0x001c }
            return
        L_0x001c:
            r0 = move-exception
            org.apache.commons.mail.EmailException r1 = new org.apache.commons.mail.EmailException
            r1.<init>((java.lang.Throwable) r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.mail.MultiPartEmail.buildMimeMessage():void");
    }

    /* access modifiers changed from: protected */
    public BodyPart createBodyPart() {
        return new MimeBodyPart();
    }

    /* access modifiers changed from: protected */
    public MimeMultipart createMimeMultipart() {
        return new MimeMultipart();
    }

    /* access modifiers changed from: protected */
    public MimeMultipart getContainer() {
        if (!this.initialized) {
            init();
        }
        return this.container;
    }

    /* access modifiers changed from: protected */
    public BodyPart getPrimaryBodyPart() throws MessagingException {
        if (!this.initialized) {
            init();
        }
        if (this.primaryBodyPart == null) {
            this.primaryBodyPart = createBodyPart();
            getContainer().addBodyPart(this.primaryBodyPart, 0);
        }
        return this.primaryBodyPart;
    }

    public String getSubType() {
        return this.subType;
    }

    /* access modifiers changed from: protected */
    public void init() {
        if (this.initialized) {
            throw new IllegalStateException("Already initialized");
        }
        this.container = createMimeMultipart();
        super.setContent(this.container);
        this.initialized = true;
    }

    public boolean isBoolHasAttachments() {
        return this.boolHasAttachments;
    }

    /* access modifiers changed from: protected */
    public boolean isInitialized() {
        return this.initialized;
    }

    public void setBoolHasAttachments(boolean z) {
        this.boolHasAttachments = z;
    }

    /* access modifiers changed from: protected */
    public void setInitialized(boolean z) {
        this.initialized = z;
    }

    public Email setMsg(String str) throws EmailException {
        if (EmailUtils.isEmpty(str)) {
            throw new EmailException("Invalid message supplied");
        }
        try {
            BodyPart primaryBodyPart2 = getPrimaryBodyPart();
            if (!(primaryBodyPart2 instanceof MimePart) || !EmailUtils.isNotEmpty(this.charset)) {
                primaryBodyPart2.setText(str);
                return this;
            }
            ((MimePart) primaryBodyPart2).setText(str, this.charset);
            return this;
        } catch (MessagingException e) {
            throw new EmailException((Throwable) e);
        }
    }

    public void setSubType(String str) {
        this.subType = str;
    }
}
