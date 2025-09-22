package javax.mail.search;

import javax.mail.Message;

public final class MessageIDTerm extends StringTerm {
    private static final long serialVersionUID = -2121096296454691963L;

    public MessageIDTerm(String str) {
        super(str);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof MessageIDTerm)) {
            return false;
        }
        return super.equals(obj);
    }

    public final boolean match(Message message) {
        try {
            String[] header = message.getHeader("Message-ID");
            if (header == null) {
                return false;
            }
            for (String match : header) {
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
