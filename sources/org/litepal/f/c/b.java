package org.litepal.f.c;

public final class b extends f {
    public final String a(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("boolean") || str.equals("java.lang.Boolean")) {
            return "integer";
        }
        return null;
    }
}
