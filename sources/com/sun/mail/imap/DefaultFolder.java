package com.sun.mail.imap;

import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.imap.protocol.ListInfo;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.MethodNotSupportedException;

public class DefaultFolder extends IMAPFolder {
    protected DefaultFolder(IMAPStore iMAPStore) {
        super("", 65535, iMAPStore);
        this.exists = true;
        this.type = 2;
    }

    public void appendMessages(Message[] messageArr) throws MessagingException {
        throw new MethodNotSupportedException("Cannot append to Default Folder");
    }

    public boolean delete(boolean z) throws MessagingException {
        throw new MethodNotSupportedException("Cannot delete Default Folder");
    }

    public Message[] expunge() throws MessagingException {
        throw new MethodNotSupportedException("Cannot expunge Default Folder");
    }

    public Folder getFolder(String str) throws MessagingException {
        return new IMAPFolder(str, 65535, (IMAPStore) this.store);
    }

    public String getName() {
        return this.fullName;
    }

    public Folder getParent() {
        return null;
    }

    public boolean hasNewMessages() throws MessagingException {
        return false;
    }

    public Folder[] list(final String str) throws MessagingException {
        ListInfo[] listInfoArr = (ListInfo[]) doCommand(new IMAPFolder.ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                return iMAPProtocol.list("", str);
            }
        });
        if (listInfoArr == null) {
            return new Folder[0];
        }
        IMAPFolder[] iMAPFolderArr = new IMAPFolder[listInfoArr.length];
        for (int i = 0; i < iMAPFolderArr.length; i++) {
            iMAPFolderArr[i] = new IMAPFolder(listInfoArr[i], (IMAPStore) this.store);
        }
        return iMAPFolderArr;
    }

    public Folder[] listSubscribed(final String str) throws MessagingException {
        ListInfo[] listInfoArr = (ListInfo[]) doCommand(new IMAPFolder.ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                return iMAPProtocol.lsub("", str);
            }
        });
        if (listInfoArr == null) {
            return new Folder[0];
        }
        IMAPFolder[] iMAPFolderArr = new IMAPFolder[listInfoArr.length];
        for (int i = 0; i < iMAPFolderArr.length; i++) {
            iMAPFolderArr[i] = new IMAPFolder(listInfoArr[i], (IMAPStore) this.store);
        }
        return iMAPFolderArr;
    }

    public boolean renameTo(Folder folder) throws MessagingException {
        throw new MethodNotSupportedException("Cannot rename Default Folder");
    }
}
