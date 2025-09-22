package javax.mail.search;

import java.util.Date;
import javax.mail.Message;

public final class SentDateTerm extends DateTerm {
    private static final long serialVersionUID = 5647755030530907263L;

    public SentDateTerm(int i, Date date) {
        super(i, date);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SentDateTerm)) {
            return false;
        }
        return super.equals(obj);
    }

    public final boolean match(Message message) {
        try {
            Date sentDate = message.getSentDate();
            if (sentDate == null) {
                return false;
            }
            return super.match(sentDate);
        } catch (Exception unused) {
            return false;
        }
    }
}
