package javax.mail.search;

import javax.mail.Address;
import javax.mail.Message;

public final class RecipientStringTerm extends AddressStringTerm {
    private static final long serialVersionUID = -8293562089611618849L;
    private Message.RecipientType type;

    public RecipientStringTerm(Message.RecipientType recipientType, String str) {
        super(str);
        this.type = recipientType;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof RecipientStringTerm) && ((RecipientStringTerm) obj).type.equals(this.type) && super.equals(obj);
    }

    public final Message.RecipientType getRecipientType() {
        return this.type;
    }

    public final int hashCode() {
        return this.type.hashCode() + super.hashCode();
    }

    public final boolean match(Message message) {
        try {
            Address[] recipients = message.getRecipients(this.type);
            if (recipients == null) {
                return false;
            }
            for (Address match : recipients) {
                if (super.match(match)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
