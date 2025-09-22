package javax.mail.search;

import javax.mail.Message;

public final class SubjectTerm extends StringTerm {
    private static final long serialVersionUID = 7481568618055573432L;

    public SubjectTerm(String str) {
        super(str);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SubjectTerm)) {
            return false;
        }
        return super.equals(obj);
    }

    public final boolean match(Message message) {
        try {
            String subject = message.getSubject();
            if (subject == null) {
                return false;
            }
            return super.match(subject);
        } catch (Exception unused) {
            return false;
        }
    }
}
