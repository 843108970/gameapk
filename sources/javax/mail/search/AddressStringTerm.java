package javax.mail.search;

import javax.mail.Address;
import javax.mail.internet.InternetAddress;

public abstract class AddressStringTerm extends StringTerm {
    private static final long serialVersionUID = 3086821234204980368L;

    protected AddressStringTerm(String str) {
        super(str, true);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AddressStringTerm)) {
            return false;
        }
        return super.equals(obj);
    }

    /* access modifiers changed from: protected */
    public boolean match(Address address) {
        return super.match(address instanceof InternetAddress ? ((InternetAddress) address).toUnicodeString() : address.toString());
    }
}
