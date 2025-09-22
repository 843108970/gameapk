package junit.b;

public final class d extends b {
    private static final int MAX_CONTEXT_LENGTH = 20;
    private static final long serialVersionUID = 1;
    private String fActual;
    private String fExpected;

    public d(String str, String str2, String str3) {
        super(str);
        this.fExpected = str2;
        this.fActual = str3;
    }

    public final String getActual() {
        return this.fActual;
    }

    public final String getExpected() {
        return this.fExpected;
    }

    public final String getMessage() {
        String str;
        String str2;
        c cVar = new c(this.fExpected, this.fActual);
        String message = super.getMessage();
        if (cVar.f4023a == null || cVar.f4024b == null || cVar.f4023a.equals(cVar.f4024b)) {
            str = cVar.f4023a;
            str2 = cVar.f4024b;
        } else {
            cVar.f4025c = 0;
            int min = Math.min(cVar.f4023a.length(), cVar.f4024b.length());
            while (cVar.f4025c < min && cVar.f4023a.charAt(cVar.f4025c) == cVar.f4024b.charAt(cVar.f4025c)) {
                cVar.f4025c++;
            }
            int length = cVar.f4023a.length() - 1;
            int length2 = cVar.f4024b.length() - 1;
            while (length2 >= cVar.f4025c && length >= cVar.f4025c && cVar.f4023a.charAt(length) == cVar.f4024b.charAt(length2)) {
                length2--;
                length--;
            }
            cVar.d = cVar.f4023a.length() - length;
            str = cVar.a(cVar.f4023a);
            str2 = cVar.a(cVar.f4024b);
        }
        return a.f(message, str, str2);
    }
}
