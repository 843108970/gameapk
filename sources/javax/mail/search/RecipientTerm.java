package javax.mail.search;

import javax.mail.Address;
import javax.mail.Message;

public final class RecipientTerm extends AddressTerm {
    private static final long serialVersionUID = 6548700653122680468L;
    protected Message.RecipientType type;

    public RecipientTerm(Message.RecipientType recipientType, Address address) {
        super(address);
        this.type = recipientType;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof RecipientTerm) && ((RecipientTerm) obj).type.equals(this.type) && super.equals(obj);
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
