package junit.b;

public final class c {
    private static final String e = "...";
    private static final String f = "]";
    private static final String g = "[";

    /* renamed from: a  reason: collision with root package name */
    String f4023a;

    /* renamed from: b  reason: collision with root package name */
    String f4024b;

    /* renamed from: c  reason: collision with root package name */
    int f4025c;
    int d;
    private int h = 20;

    public c(String str, String str2) {
        this.f4023a = str;
        this.f4024b = str2;
    }

    private void a() {
        this.f4025c = 0;
        int min = Math.min(this.f4023a.length(), this.f4024b.length());
        while (this.f4025c < min && this.f4023a.charAt(this.f4025c) == this.f4024b.charAt(this.f4025c)) {
            this.f4025c++;
        }
    }

    private String b(String str) {
        String str2;
        String str3;
        if (this.f4023a == null || this.f4024b == null || this.f4023a.equals(this.f4024b)) {
            str2 = this.f4023a;
            str3 = this.f4024b;
        } else {
            this.f4025c = 0;
            int min = Math.min(this.f4023a.length(), this.f4024b.length());
            while (this.f4025c < min && this.f4023a.charAt(this.f4025c) == this.f4024b.charAt(this.f4025c)) {
                this.f4025c++;
            }
            int length = this.f4023a.length() - 1;
            int length2 = this.f4024b.length() - 1;
            while (length2 >= this.f4025c && length >= this.f4025c && this.f4023a.charAt(length) == this.f4024b.charAt(length2)) {
                length2--;
                length--;
            }
            this.d = this.f4023a.length() - length;
            str2 = a(this.f4023a);
            str3 = a(this.f4024b);
        }
        return a.f(str, str2, str3);
    }

    private void b() {
        int length = this.f4023a.length() - 1;
        int length2 = this.f4024b.length() - 1;
        while (length2 >= this.f4025c && length >= this.f4025c && this.f4023a.charAt(length) == this.f4024b.charAt(length2)) {
            length2--;
            length--;
        }
        this.d = this.f4023a.length() - length;
    }

    private String c() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4025c > this.h ? e : "");
        sb.append(this.f4023a.substring(Math.max(0, this.f4025c - this.h), this.f4025c));
        return sb.toString();
    }

    private String d() {
        int min = Math.min((this.f4023a.length() - this.d) + 1 + this.h, this.f4023a.length());
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4023a.substring((this.f4023a.length() - this.d) + 1, min));
        sb.append((this.f4023a.length() - this.d) + 1 < this.f4023a.length() - this.h ? e : "");
        return sb.toString();
    }

    private boolean e() {
        return this.f4023a.equals(this.f4024b);
    }

    /* access modifiers changed from: package-private */
    public final String a(String str) {
        String str2 = g + str.substring(this.f4025c, (str.length() - this.d) + 1) + f;
        if (this.f4025c > 0) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f4025c > this.h ? e : "");
            sb2.append(this.f4023a.substring(Math.max(0, this.f4025c - this.h), this.f4025c));
            sb.append(sb2.toString());
            sb.append(str2);
            str2 = sb.toString();
        }
        if (this.d <= 0) {
            return str2;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str2);
        int min = Math.min((this.f4023a.length() - this.d) + 1 + this.h, this.f4023a.length());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f4023a.substring((this.f4023a.length() - this.d) + 1, min));
        sb4.append((this.f4023a.length() - this.d) + 1 < this.f4023a.length() - this.h ? e : "");
        sb3.append(sb4.toString());
        return sb3.toString();
    }
}
