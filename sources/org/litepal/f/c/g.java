package org.litepal.f.c;

public final class g extends f {
    public final String a(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("char") || str.equals("java.lang.Character") || str.equals("java.lang.String")) {
            return "text";
        }
        return null;
    }
}
