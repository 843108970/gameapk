package javax.mail;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Date;
import javax.mail.Flags;
import javax.mail.search.SearchTerm;

public abstract class Message implements Part {
    protected boolean expunged = false;
    protected Folder folder = null;
    protected int msgnum = 0;
    protected Session session = null;

    public static class RecipientType implements Serializable {
        public static final RecipientType BCC = new RecipientType("Bcc");
        public static final RecipientType CC = new RecipientType("Cc");
        public static final RecipientType TO = new RecipientType("To");
        private static final long serialVersionUID = -7479791750606340008L;
        protected String type;

        protected RecipientType(String str) {
            this.type = str;
        }

        /* access modifiers changed from: protected */
        public Object readResolve() throws ObjectStreamException {
            if (this.type.equals("To")) {
                return TO;
            }
            if (this.type.equals("Cc")) {
                return CC;
            }
            if (this.type.equals("Bcc")) {
                return BCC;
            }
            throw new InvalidObjectException("Attempt to resolve unknown RecipientType: " + this.type);
        }

        public String toString() {
            return this.type;
        }
    }

    protected Message() {
    }

    protected Message(Folder folder2, int i) {
        this.folder = folder2;
        this.msgnum = i;
        this.session = folder2.store.session;
    }

    protected Message(Session session2) {
        this.session = session2;
    }

    public abstract void addFrom(Address[] addressArr) throws MessagingException;

    public void addRecipient(RecipientType recipientType, Address address) throws MessagingException {
        addRecipients(recipientType, new Address[]{address});
    }

    public abstract void addRecipients(RecipientType recipientType, Address[] addressArr) throws MessagingException;

    public Address[] getAllRecipients() throws MessagingException {
        int i;
        Address[] recipients = getRecipients(RecipientType.TO);
        Address[] recipients2 = getRecipients(RecipientType.CC);
        Address[] recipients3 = getRecipients(RecipientType.BCC);
        if (recipients2 == null && recipients3 == null) {
            return recipients;
        }
        Address[] addressArr = new Address[((recipients != null ? recipients.length : 0) + (recipients2 != null ? recipients2.length : 0) + (recipients3 != null ? recipients3.length : 0))];
        if (recipients != null) {
            System.arraycopy(recipients, 0, addressArr, 0, recipients.length);
            i = recipients.length + 0;
        } else {
            i = 0;
        }
        if (recipients2 != null) {
            System.arraycopy(recipients2, 0, addressArr, i, recipients2.length);
            i += recipients2.length;
        }
        if (recipients3 != null) {
            System.arraycopy(recipients3, 0, addressArr, i, recipients3.length);
        }
        return addressArr;
    }

    public abstract Flags getFlags() throws MessagingException;

    public Folder getFolder() {
        return this.folder;
    }

    public abstract Address[] getFrom() throws MessagingException;

    public int getMessageNumber() {
        return this.msgnum;
    }

    public abstract Date getReceivedDate() throws MessagingException;

    public abstract Address[] getRecipients(RecipientType recipientType) throws MessagingException;

    public Address[] getReplyTo() throws MessagingException {
        return getFrom();
    }

    public abstract Date getSentDate() throws MessagingException;

    public abstract String getSubject() throws MessagingException;

    public boolean isExpunged() {
        return this.expunged;
    }

    public boolean isSet(Flags.Flag flag) throws MessagingException {
        return getFlags().contains(flag);
    }

    public boolean match(SearchTerm searchTerm) throws MessagingException {
        return searchTerm.match(this);
    }

    public abstract Message reply(boolean z) throws MessagingException;

    public abstract void saveChanges() throws MessagingException;

    /* access modifiers changed from: protected */
    public void setExpunged(boolean z) {
        this.expunged = z;
    }

    public void setFlag(Flags.Flag flag, boolean z) throws MessagingException {
        setFlags(new Flags(flag), z);
    }

    public abstract void setFlags(Flags flags, boolean z) throws MessagingException;

    public abstract void setFrom() throws MessagingException;

    public abstract void setFrom(Address address) throws MessagingException;

    /* access modifiers changed from: protected */
    public void setMessageNumber(int i) {
        this.msgnum = i;
    }

    public void setRecipient(RecipientType recipientType, Address address) throws MessagingException {
        setRecipients(recipientType, new Address[]{address});
    }

    public abstract void setRecipients(RecipientType recipientType, Address[] addressArr) throws MessagingException;

    public void setReplyTo(Address[] addressArr) throws MessagingException {
        throw new MethodNotSupportedException("setReplyTo not supported");
    }

    public abstract void setSentDate(Date date) throws MessagingException;

    public abstract void setSubject(String str) throws MessagingException;
}
