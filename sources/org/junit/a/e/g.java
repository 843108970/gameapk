package org.junit.a.e;

public abstract class g {

    public static class a extends Exception {
        private static final long serialVersionUID = 1;

        public a() {
        }

        public a(Throwable th) {
            super(th);
        }
    }

    public static g a(final String str, final Object obj) {
        return new g() {
            public final Object a() {
                return obj;
            }

            public final String b() {
                String str;
                if (obj == null) {
                    str = "null";
                } else {
                    try {
                        str = String.format("\"%s\"", new Object[]{obj});
                    } catch (Throwable th) {
                        str = String.format("[toString() threw %s: %s]", new Object[]{th.getClass().getSimpleName(), th.getMessage()});
                    }
                }
                return String.format("%s <from %s>", new Object[]{str, str});
            }

            public final String toString() {
                return String.format("[%s]", new Object[]{obj});
            }
        };
    }

    public abstract Object a() throws a;

    public abstract String b() throws a;
}
