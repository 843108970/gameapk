package com.sun.mail.dsn;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.activation.DataHandler;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeMessage;

public class MessageHeaders extends MimeMessage {
    public MessageHeaders() throws MessagingException {
        super((Session) null);
        this.content = new byte[0];
    }

    public MessageHeaders(InputStream inputStream) throws MessagingException {
        super((Session) null, inputStream);
        this.content = new byte[0];
    }

    public MessageHeaders(InternetHeaders internetHeaders) throws MessagingException {
        super((Session) null);
        this.headers = internetHeaders;
        this.content = new byte[0];
    }

    /* access modifiers changed from: protected */
    public InputStream getContentStream() {
        return new ByteArrayInputStream(this.content);
    }

    public InputStream getInputStream() {
        return new ByteArrayInputStream(this.content);
    }

    public int getSize() {
        return 0;
    }

    public void setDataHandler(DataHandler dataHandler) throws MessagingException {
        throw new MessagingException("Can't set content for MessageHeaders");
    }
}
