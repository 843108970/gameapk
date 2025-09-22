package org.litepal.f.c;

public final class d extends f {
    public final String a(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("float") || str.equals("java.lang.Float") || str.equals("double") || str.equals("java.lang.Double")) {
            return "real";
        }
        return null;
    }
}
