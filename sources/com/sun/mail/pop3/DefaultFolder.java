package com.sun.mail.pop3;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.MethodNotSupportedException;
import org.apache.commons.io.IOUtils;

public class DefaultFolder extends Folder {
    DefaultFolder(POP3Store pOP3Store) {
        super(pOP3Store);
    }

    public void appendMessages(Message[] messageArr) throws MessagingException {
        throw new MethodNotSupportedException("Append not supported");
    }

    public void close(boolean z) throws MessagingException {
        throw new MethodNotSupportedException("close");
    }

    public boolean create(int i) throws MessagingException {
        return false;
    }

    public boolean delete(boolean z) throws MessagingException {
        throw new MethodNotSupportedException(RequestParameters.SUBRESOURCE_DELETE);
    }

    public boolean exists() {
        return true;
    }

    public Message[] expunge() throws MessagingException {
        throw new MethodNotSupportedException("expunge");
    }

    public Folder getFolder(String str) throws MessagingException {
        if (str.equalsIgnoreCase("INBOX")) {
            return getInbox();
        }
        throw new MessagingException("only INBOX supported");
    }

    public String getFullName() {
        return "";
    }

    /* access modifiers changed from: protected */
    public Folder getInbox() throws MessagingException {
        return getStore().getFolder("INBOX");
    }

    public Message getMessage(int i) throws MessagingException {
        throw new MethodNotSupportedException("getMessage");
    }

    public int getMessageCount() throws MessagingException {
        return 0;
    }

    public String getName() {
        return "";
    }

    public Folder getParent() {
        return null;
    }

    public Flags getPermanentFlags() {
        return new Flags();
    }

    public char getSeparator() {
        return IOUtils.DIR_SEPARATOR_UNIX;
    }

    public int getType() {
        return 2;
    }

    public boolean hasNewMessages() throws MessagingException {
        return false;
    }

    public boolean isOpen() {
        return false;
    }

    public Folder[] list(String str) throws MessagingException {
        return new Folder[]{getInbox()};
    }

    public void open(int i) throws MessagingException {
        throw new MethodNotSupportedException("open");
    }

    public boolean renameTo(Folder folder) throws MessagingException {
        throw new MethodNotSupportedException("renameTo");
    }
}
