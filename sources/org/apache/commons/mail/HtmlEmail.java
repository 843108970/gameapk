package org.apache.commons.mail;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.URLDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;

public class HtmlEmail extends MultiPartEmail {
    public static final int CID_LENGTH = 10;
    private static final String HTML_MESSAGE_END = "</pre></body></html>";
    private static final String HTML_MESSAGE_START = "<html><body><pre>";
    protected String html;
    protected Map<String, InlineImage> inlineEmbeds = new HashMap();
    @Deprecated
    protected List<InlineImage> inlineImages;
    protected String text;

    private static class InlineImage {
        private final String cid;
        private final DataSource dataSource;
        private final MimeBodyPart mbp;

        public InlineImage(String str, DataSource dataSource2, MimeBodyPart mimeBodyPart) {
            this.cid = str;
            this.dataSource = dataSource2;
            this.mbp = mimeBodyPart;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InlineImage)) {
                return false;
            }
            return this.cid.equals(((InlineImage) obj).cid);
        }

        public String getCid() {
            return this.cid;
        }

        public DataSource getDataSource() {
            return this.dataSource;
        }

        public MimeBodyPart getMbp() {
            return this.mbp;
        }

        public int hashCode() {
            return this.cid.hashCode();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void build() throws javax.mail.MessagingException, org.apache.commons.mail.EmailException {
        /*
            r8 = this;
            javax.mail.internet.MimeMultipart r0 = r8.getContainer()
            java.lang.String r1 = "mixed"
            r0.setSubType(r1)
            java.lang.String r1 = r8.html
            boolean r1 = org.apache.commons.mail.EmailUtils.isNotEmpty(r1)
            r2 = 0
            if (r1 == 0) goto L_0x0045
            java.util.Map<java.lang.String, org.apache.commons.mail.HtmlEmail$InlineImage> r1 = r8.inlineEmbeds
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0045
            javax.mail.internet.MimeMultipart r0 = new javax.mail.internet.MimeMultipart
            java.lang.String r1 = "related"
            r0.<init>((java.lang.String) r1)
            r8.addPart((javax.mail.internet.MimeMultipart) r0, (int) r2)
            java.lang.String r1 = r8.text
            boolean r1 = org.apache.commons.mail.EmailUtils.isNotEmpty(r1)
            if (r1 == 0) goto L_0x0078
            javax.mail.internet.MimeMultipart r1 = new javax.mail.internet.MimeMultipart
            java.lang.String r3 = "alternative"
            r1.<init>((java.lang.String) r3)
            javax.mail.BodyPart r3 = r8.createBodyPart()
            r3.setContent(r1)     // Catch:{ MessagingException -> 0x003e }
            r0.addBodyPart(r3, r2)     // Catch:{ MessagingException -> 0x003e }
            goto L_0x0074
        L_0x003e:
            r0 = move-exception
            org.apache.commons.mail.EmailException r1 = new org.apache.commons.mail.EmailException
            r1.<init>((java.lang.Throwable) r0)
            throw r1
        L_0x0045:
            java.lang.String r1 = r8.text
            boolean r1 = org.apache.commons.mail.EmailUtils.isNotEmpty(r1)
            if (r1 == 0) goto L_0x0078
            java.lang.String r1 = r8.html
            boolean r1 = org.apache.commons.mail.EmailUtils.isNotEmpty(r1)
            if (r1 == 0) goto L_0x0078
            java.util.Map<java.lang.String, org.apache.commons.mail.HtmlEmail$InlineImage> r1 = r8.inlineEmbeds
            int r1 = r1.size()
            if (r1 > 0) goto L_0x006a
            boolean r1 = r8.isBoolHasAttachments()
            if (r1 == 0) goto L_0x0064
            goto L_0x006a
        L_0x0064:
            java.lang.String r1 = "alternative"
            r0.setSubType(r1)
            goto L_0x0078
        L_0x006a:
            javax.mail.internet.MimeMultipart r1 = new javax.mail.internet.MimeMultipart
            java.lang.String r3 = "alternative"
            r1.<init>((java.lang.String) r3)
            r8.addPart((javax.mail.internet.MimeMultipart) r1, (int) r2)
        L_0x0074:
            r7 = r1
            r1 = r0
            r0 = r7
            goto L_0x0079
        L_0x0078:
            r1 = r0
        L_0x0079:
            java.lang.String r3 = r8.html
            boolean r3 = org.apache.commons.mail.EmailUtils.isNotEmpty(r3)
            if (r3 == 0) goto L_0x00e1
            javax.mail.internet.MimeBodyPart r3 = new javax.mail.internet.MimeBodyPart
            r3.<init>()
            r0.addBodyPart(r3, r2)
            java.lang.String r4 = r8.html
            java.lang.String r5 = r8.charset
            java.lang.String r6 = "html"
            r3.setText(r4, r5, r6)
            java.lang.String r4 = r3.getContentType()
            if (r4 == 0) goto L_0x00a0
            java.lang.String r5 = "text/html"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00c3
        L_0x00a0:
            java.lang.String r4 = r8.charset
            boolean r4 = org.apache.commons.mail.EmailUtils.isNotEmpty(r4)
            if (r4 == 0) goto L_0x00be
            java.lang.String r4 = r8.html
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "text/html; charset="
            r5.<init>(r6)
            java.lang.String r6 = r8.charset
            r5.append(r6)
            java.lang.String r5 = r5.toString()
        L_0x00ba:
            r3.setContent(r4, r5)
            goto L_0x00c3
        L_0x00be:
            java.lang.String r4 = r8.html
            java.lang.String r5 = "text/html"
            goto L_0x00ba
        L_0x00c3:
            java.util.Map<java.lang.String, org.apache.commons.mail.HtmlEmail$InlineImage> r3 = r8.inlineEmbeds
            java.util.Collection r3 = r3.values()
            java.util.Iterator r3 = r3.iterator()
        L_0x00cd:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00e1
            java.lang.Object r4 = r3.next()
            org.apache.commons.mail.HtmlEmail$InlineImage r4 = (org.apache.commons.mail.HtmlEmail.InlineImage) r4
            javax.mail.internet.MimeBodyPart r4 = r4.getMbp()
            r1.addBodyPart(r4)
            goto L_0x00cd
        L_0x00e1:
            java.lang.String r1 = r8.text
            boolean r1 = org.apache.commons.mail.EmailUtils.isNotEmpty(r1)
            if (r1 == 0) goto L_0x00f8
            javax.mail.internet.MimeBodyPart r1 = new javax.mail.internet.MimeBodyPart
            r1.<init>()
            r0.addBodyPart(r1, r2)
            java.lang.String r0 = r8.text
            java.lang.String r2 = r8.charset
            r1.setText(r0, r2)
        L_0x00f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.mail.HtmlEmail.build():void");
    }

    public void buildMimeMessage() throws EmailException {
        try {
            build();
            super.buildMimeMessage();
        } catch (MessagingException e) {
            throw new EmailException((Throwable) e);
        }
    }

    public String embed(File file) throws EmailException {
        return embed(file, EmailUtils.randomAlphabetic(10).toLowerCase(Locale.ENGLISH));
    }

    public String embed(File file, String str) throws EmailException {
        if (EmailUtils.isEmpty(file.getName())) {
            throw new EmailException("file name cannot be null or empty");
        }
        try {
            String canonicalPath = file.getCanonicalPath();
            if (this.inlineEmbeds.containsKey(file.getName())) {
                InlineImage inlineImage = this.inlineEmbeds.get(file.getName());
                FileDataSource fileDataSource = (FileDataSource) inlineImage.getDataSource();
                try {
                    String canonicalPath2 = fileDataSource.getFile().getCanonicalPath();
                    if (canonicalPath.equals(canonicalPath2)) {
                        return inlineImage.getCid();
                    }
                    throw new EmailException("embedded name '" + file.getName() + "' is already bound to file " + canonicalPath2 + "; existing names cannot be rebound");
                } catch (IOException e) {
                    throw new EmailException("couldn't get canonical path for file " + fileDataSource.getFile().getName() + "which has already been embedded", e);
                }
            } else if (!file.exists()) {
                throw new EmailException("file " + canonicalPath + " doesn't exist");
            } else if (!file.isFile()) {
                throw new EmailException("file " + canonicalPath + " isn't a normal file");
            } else if (file.canRead()) {
                return embed(new FileDataSource(file), file.getName(), str);
            } else {
                throw new EmailException("file " + canonicalPath + " isn't readable");
            }
        } catch (IOException e2) {
            throw new EmailException("couldn't get canonical path for " + file.getName(), e2);
        }
    }

    public String embed(String str, String str2) throws EmailException {
        try {
            return embed(new URL(str), str2);
        } catch (MalformedURLException e) {
            throw new EmailException("Invalid URL", e);
        }
    }

    public String embed(URL url, String str) throws EmailException {
        if (EmailUtils.isEmpty(str)) {
            throw new EmailException("name cannot be null or empty");
        } else if (this.inlineEmbeds.containsKey(str)) {
            InlineImage inlineImage = this.inlineEmbeds.get(str);
            URLDataSource uRLDataSource = (URLDataSource) inlineImage.getDataSource();
            if (url.toExternalForm().equals(uRLDataSource.getURL().toExternalForm())) {
                return inlineImage.getCid();
            }
            throw new EmailException("embedded name '" + str + "' is already bound to URL " + uRLDataSource.getURL() + "; existing names cannot be rebound");
        } else {
            try {
                InputStream openStream = url.openStream();
                if (openStream != null) {
                    try {
                        openStream.close();
                    } catch (IOException unused) {
                    }
                }
                return embed((DataSource) new URLDataSource(url), str);
            } catch (IOException e) {
                throw new EmailException("Invalid URL", e);
            }
        }
    }

    public String embed(DataSource dataSource, String str) throws EmailException {
        if (!this.inlineEmbeds.containsKey(str)) {
            return embed(dataSource, str, EmailUtils.randomAlphabetic(10).toLowerCase());
        }
        InlineImage inlineImage = this.inlineEmbeds.get(str);
        if (dataSource.equals(inlineImage.getDataSource())) {
            return inlineImage.getCid();
        }
        throw new EmailException("embedded DataSource '" + str + "' is already bound to name " + inlineImage.getDataSource().toString() + "; existing names cannot be rebound");
    }

    public String embed(DataSource dataSource, String str, String str2) throws EmailException {
        if (EmailUtils.isEmpty(str)) {
            throw new EmailException("name cannot be null or empty");
        }
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        try {
            String encodeUrl = EmailUtils.encodeUrl(str2);
            mimeBodyPart.setDataHandler(new DataHandler(dataSource));
            mimeBodyPart.setFileName(str);
            mimeBodyPart.setDisposition("inline");
            mimeBodyPart.setContentID("<" + encodeUrl + ">");
            this.inlineEmbeds.put(str, new InlineImage(encodeUrl, dataSource, mimeBodyPart));
            return encodeUrl;
        } catch (MessagingException e) {
            throw new EmailException((Throwable) e);
        } catch (UnsupportedEncodingException e2) {
            throw new EmailException((Throwable) e2);
        }
    }

    public HtmlEmail setHtmlMsg(String str) throws EmailException {
        if (EmailUtils.isEmpty(str)) {
            throw new EmailException("Invalid message supplied");
        }
        this.html = str;
        return this;
    }

    public Email setMsg(String str) throws EmailException {
        if (EmailUtils.isEmpty(str)) {
            throw new EmailException("Invalid message supplied");
        }
        setTextMsg(str);
        StringBuffer stringBuffer = new StringBuffer(str.length() + 17 + 20);
        stringBuffer.append(HTML_MESSAGE_START);
        stringBuffer.append(str);
        stringBuffer.append(HTML_MESSAGE_END);
        setHtmlMsg(stringBuffer.toString());
        return this;
    }

    public HtmlEmail setTextMsg(String str) throws EmailException {
        if (EmailUtils.isEmpty(str)) {
            throw new EmailException("Invalid message supplied");
        }
        this.text = str;
        return this;
    }
}
