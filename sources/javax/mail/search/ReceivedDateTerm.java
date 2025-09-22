package javax.mail.search;

import java.util.Date;
import javax.mail.Message;

public final class ReceivedDateTerm extends DateTerm {
    private static final long serialVersionUID = -2756695246195503170L;

    public ReceivedDateTerm(int i, Date date) {
        super(i, date);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ReceivedDateTerm)) {
            return false;
        }
        return super.equals(obj);
    }

    public final boolean match(Message message) {
        try {
            Date receivedDate = message.getReceivedDate();
            if (receivedDate == null) {
                return false;
            }
            return super.match(receivedDate);
        } catch (Exception unused) {
            return false;
        }
    }
}
