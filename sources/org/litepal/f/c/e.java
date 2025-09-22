package org.litepal.f.c;

public final class e extends f {
    public final String a(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("int") || str.equals("java.lang.Integer") || str.equals("long") || str.equals("java.lang.Long") || str.equals("short") || str.equals("java.lang.Short")) {
            return "integer";
        }
        return null;
    }
}
