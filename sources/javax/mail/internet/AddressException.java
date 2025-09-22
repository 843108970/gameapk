package javax.mail.internet;

public class AddressException extends ParseException {
    private static final long serialVersionUID = 9134583443539323120L;
    protected int pos = -1;
    protected String ref = null;

    public AddressException() {
    }

    public AddressException(String str) {
        super(str);
    }

    public AddressException(String str, String str2) {
        super(str);
        this.ref = str2;
    }

    public AddressException(String str, String str2, int i) {
        super(str);
        this.ref = str2;
        this.pos = i;
    }

    public int getPos() {
        return this.pos;
    }

    public String getRef() {
        return this.ref;
    }

    public String toString() {
        String parseException = super.toString();
        if (this.ref == null) {
            return parseException;
        }
        String str = String.valueOf(parseException) + " in string ``" + this.ref + "''";
        if (this.pos < 0) {
            return str;
        }
        return String.valueOf(str) + " at position " + this.pos;
    }
}
