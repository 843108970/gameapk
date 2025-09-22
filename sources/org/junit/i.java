package org.junit;

public final class i extends AssertionError {
    private static final int MAX_CONTEXT_LENGTH = 20;
    private static final long serialVersionUID = 1;
    private String fActual;
    private String fExpected;

    private static class a {
        private static final String d = "...";
        private static final String e = "]";
        private static final String f = "[";
        /* access modifiers changed from: package-private */

        /* renamed from: a  reason: collision with root package name */
        public final int f4597a = 20;
        /* access modifiers changed from: package-private */

        /* renamed from: b  reason: collision with root package name */
        public final String f4598b;
        /* access modifiers changed from: package-private */

        /* renamed from: c  reason: collision with root package name */
        public final String f4599c;

        /* renamed from: org.junit.i$a$a  reason: collision with other inner class name */
        private class C0071a {

            /* renamed from: a  reason: collision with root package name */
            final String f4600a;

            /* renamed from: b  reason: collision with root package name */
            final String f4601b;

            private C0071a() {
                this.f4600a = a.a((a) a.this);
                this.f4601b = a.a(a.this, this.f4600a);
            }

            /* synthetic */ C0071a(a aVar, byte b2) {
                this();
            }

            private String a() {
                return a(a.this.f4598b);
            }

            private String b() {
                return a(a.this.f4599c);
            }

            private String c() {
                if (this.f4600a.length() <= a.this.f4597a) {
                    return this.f4600a;
                }
                return a.d + this.f4600a.substring(this.f4600a.length() - a.this.f4597a);
            }

            private String d() {
                if (this.f4601b.length() <= a.this.f4597a) {
                    return this.f4601b;
                }
                return this.f4601b.substring(0, a.this.f4597a) + a.d;
            }

            /* access modifiers changed from: package-private */
            public final String a(String str) {
                return a.f + str.substring(this.f4600a.length(), str.length() - this.f4601b.length()) + a.e;
            }
        }

        public a(String str, String str2) {
            this.f4598b = str;
            this.f4599c = str2;
        }

        private String a() {
            int min = Math.min(this.f4598b.length(), this.f4599c.length());
            for (int i = 0; i < min; i++) {
                if (this.f4598b.charAt(i) != this.f4599c.charAt(i)) {
                    return this.f4598b.substring(0, i);
                }
            }
            return this.f4598b.substring(0, min);
        }

        private String a(String str) {
            String str2;
            String str3;
            if (this.f4598b == null || this.f4599c == null || this.f4598b.equals(this.f4599c)) {
                return c.a(str, (Object) this.f4598b, (Object) this.f4599c);
            }
            C0071a aVar = new C0071a(this, (byte) 0);
            if (aVar.f4600a.length() <= a.this.f4597a) {
                str2 = aVar.f4600a;
            } else {
                str2 = d + aVar.f4600a.substring(aVar.f4600a.length() - a.this.f4597a);
            }
            if (aVar.f4601b.length() <= a.this.f4597a) {
                str3 = aVar.f4601b;
            } else {
                str3 = aVar.f4601b.substring(0, a.this.f4597a) + d;
            }
            return c.a(str, (Object) str2 + aVar.a(a.this.f4598b) + str3, (Object) str2 + aVar.a(a.this.f4599c) + str3);
        }

        static /* synthetic */ String a(a aVar) {
            int min = Math.min(aVar.f4598b.length(), aVar.f4599c.length());
            for (int i = 0; i < min; i++) {
                if (aVar.f4598b.charAt(i) != aVar.f4599c.charAt(i)) {
                    return aVar.f4598b.substring(0, i);
                }
            }
            return aVar.f4598b.substring(0, min);
        }

        static /* synthetic */ String a(a aVar, String str) {
            int min = Math.min(aVar.f4598b.length() - str.length(), aVar.f4599c.length() - str.length()) - 1;
            int i = 0;
            while (i <= min && aVar.f4598b.charAt((aVar.f4598b.length() - 1) - i) == aVar.f4599c.charAt((aVar.f4599c.length() - 1) - i)) {
                i++;
            }
            return aVar.f4598b.substring(aVar.f4598b.length() - i);
        }

        private String b(String str) {
            int min = Math.min(this.f4598b.length() - str.length(), this.f4599c.length() - str.length()) - 1;
            int i = 0;
            while (i <= min && this.f4598b.charAt((this.f4598b.length() - 1) - i) == this.f4599c.charAt((this.f4599c.length() - 1) - i)) {
                i++;
            }
            return this.f4598b.substring(this.f4598b.length() - i);
        }
    }

    public i(String str, String str2, String str3) {
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
        a aVar = new a(this.fExpected, this.fActual);
        String message = super.getMessage();
        if (aVar.f4598b == null || aVar.f4599c == null || aVar.f4598b.equals(aVar.f4599c)) {
            return c.a(message, (Object) aVar.f4598b, (Object) aVar.f4599c);
        }
        a.C0071a aVar2 = new a.C0071a(aVar, (byte) 0);
        if (aVar2.f4600a.length() <= a.this.f4597a) {
            str = aVar2.f4600a;
        } else {
            str = "..." + aVar2.f4600a.substring(aVar2.f4600a.length() - a.this.f4597a);
        }
        if (aVar2.f4601b.length() <= a.this.f4597a) {
            str2 = aVar2.f4601b;
        } else {
            str2 = aVar2.f4601b.substring(0, a.this.f4597a) + "...";
        }
        return c.a(message, (Object) str + aVar2.a(a.this.f4598b) + str2, (Object) str + aVar2.a(a.this.f4599c) + str2);
    }
}
