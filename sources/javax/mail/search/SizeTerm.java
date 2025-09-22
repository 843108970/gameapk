package javax.mail.search;

import javax.mail.Message;

public final class SizeTerm extends IntegerComparisonTerm {
    private static final long serialVersionUID = -2556219451005103709L;

    public SizeTerm(int i, int i2) {
        super(i, i2);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SizeTerm)) {
            return false;
        }
        return super.equals(obj);
    }

    public final boolean match(Message message) {
        try {
            int size = message.getSize();
            if (size == -1) {
                return false;
            }
            return super.match(size);
        } catch (Exception unused) {
            return false;
        }
    }
}
