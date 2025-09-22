package junit.b;

public class b extends AssertionError {
    private static final long serialVersionUID = 1;

    public b() {
    }

    public b(String str) {
        super(defaultString(str));
    }

    private static String defaultString(String str) {
        return str == null ? "" : str;
    }
}
