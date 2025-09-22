package javax.mail.search;

import javax.mail.Address;

public abstract class AddressTerm extends SearchTerm {
    private static final long serialVersionUID = 2005405551929769980L;
    protected Address address;

    protected AddressTerm(Address address2) {
        this.address = address2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AddressTerm)) {
            return false;
        }
        return ((AddressTerm) obj).address.equals(this.address);
    }

    public Address getAddress() {
        return this.address;
    }

    public int hashCode() {
        return this.address.hashCode();
    }

    /* access modifiers changed from: protected */
    public boolean match(Address address2) {
        return address2.equals(this.address);
    }
}
