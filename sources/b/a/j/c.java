package b.a.j;

import javax.security.auth.x500.X500Principal;

final class c {

    /* renamed from: a  reason: collision with root package name */
    final String f206a;

    /* renamed from: b  reason: collision with root package name */
    final int f207b = this.f206a.length();

    /* renamed from: c  reason: collision with root package name */
    int f208c;
    int d;
    int e;
    int f;
    char[] g;

    c(X500Principal x500Principal) {
        this.f206a = x500Principal.getName("RFC2253");
    }

    private int a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 >= this.f207b) {
            throw new IllegalStateException("Malformed DN: " + this.f206a);
        }
        char c2 = this.g[i];
        if (c2 >= '0' && c2 <= '9') {
            i2 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i2 = c2 - 'W';
        } else if (c2 < 'A' || c2 > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.f206a);
        } else {
            i2 = c2 - '7';
        }
        char c3 = this.g[i4];
        if (c3 >= '0' && c3 <= '9') {
            i3 = c3 - '0';
        } else if (c3 >= 'a' && c3 <= 'f') {
            i3 = c3 - 'W';
        } else if (c3 < 'A' || c3 > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.f206a);
        } else {
            i3 = c3 - '7';
        }
        return (i2 << 4) + i3;
    }

    private String a(String str) {
        this.f208c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = this.f206a.toCharArray();
        String a2 = a();
        if (a2 == null) {
            return null;
        }
        do {
            String str2 = "";
            if (this.f208c == this.f207b) {
                return null;
            }
            switch (this.g[this.f208c]) {
                case '\"':
                    this.f208c++;
                    this.d = this.f208c;
                    int i = this.d;
                    while (true) {
                        this.e = i;
                        if (this.f208c == this.f207b) {
                            throw new IllegalStateException("Unexpected end of DN: " + this.f206a);
                        } else if (this.g[this.f208c] == '\"') {
                            do {
                                this.f208c++;
                                if (this.f208c >= this.f207b || this.g[this.f208c] != ' ') {
                                    str2 = new String(this.g, this.d, this.e - this.d);
                                    break;
                                }
                                this.f208c++;
                                str2 = new String(this.g, this.d, this.e - this.d);
                            } while (this.g[this.f208c] != ' ');
                            str2 = new String(this.g, this.d, this.e - this.d);
                        } else {
                            if (this.g[this.f208c] == '\\') {
                                this.g[this.e] = d();
                            } else {
                                this.g[this.e] = this.g[this.f208c];
                            }
                            this.f208c++;
                            i = this.e + 1;
                        }
                    }
                case '#':
                    str2 = b();
                    break;
                case '+':
                case ',':
                case ';':
                    break;
                default:
                    str2 = c();
                    break;
            }
            if (str.equalsIgnoreCase(a2)) {
                return str2;
            }
            if (this.f208c >= this.f207b) {
                return null;
            }
            if (this.g[this.f208c] == ',' || this.g[this.f208c] == ';' || this.g[this.f208c] == '+') {
                this.f208c++;
                a2 = a();
            } else {
                throw new IllegalStateException("Malformed DN: " + this.f206a);
            }
        } while (a2 != null);
        throw new IllegalStateException("Malformed DN: " + this.f206a);
    }

    private String e() {
        this.f208c++;
        this.d = this.f208c;
        int i = this.d;
        while (true) {
            this.e = i;
            if (this.f208c == this.f207b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f206a);
            } else if (this.g[this.f208c] == '\"') {
                do {
                    this.f208c++;
                    if (this.f208c >= this.f207b || this.g[this.f208c] != ' ') {
                    }
                    this.f208c++;
                    break;
                } while (this.g[this.f208c] != ' ');
                return new String(this.g, this.d, this.e - this.d);
            } else {
                if (this.g[this.f208c] == '\\') {
                    this.g[this.e] = d();
                } else {
                    this.g[this.e] = this.g[this.f208c];
                }
                this.f208c++;
                i = this.e + 1;
            }
        }
    }

    private char f() {
        int i;
        int i2;
        int a2 = a(this.f208c);
        this.f208c++;
        if (a2 < 128) {
            return (char) a2;
        }
        if (a2 < 192 || a2 > 247) {
            return '?';
        }
        if (a2 <= 223) {
            i2 = a2 & 31;
            i = 1;
        } else if (a2 <= 239) {
            i = 2;
            i2 = a2 & 15;
        } else {
            i = 3;
            i2 = a2 & 7;
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.f208c++;
            if (this.f208c == this.f207b || this.g[this.f208c] != '\\') {
                return '?';
            }
            this.f208c++;
            int a3 = a(this.f208c);
            this.f208c++;
            if ((a3 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (a3 & 63);
        }
        return (char) i2;
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        while (this.f208c < this.f207b && this.g[this.f208c] == ' ') {
            this.f208c++;
        }
        if (this.f208c == this.f207b) {
            return null;
        }
        this.d = this.f208c;
        do {
            this.f208c++;
            if (this.f208c >= this.f207b || this.g[this.f208c] == '=' || this.g[this.f208c] == ' ') {
            }
            this.f208c++;
            break;
        } while (this.g[this.f208c] == ' ');
        if (this.f208c >= this.f207b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f206a);
        }
        this.e = this.f208c;
        if (this.g[this.f208c] == ' ') {
            while (this.f208c < this.f207b && this.g[this.f208c] != '=' && this.g[this.f208c] == ' ') {
                this.f208c++;
            }
            if (this.g[this.f208c] != '=' || this.f208c == this.f207b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f206a);
            }
        }
        do {
            this.f208c++;
            if (this.f208c >= this.f207b || this.g[this.f208c] != ' ') {
            }
            this.f208c++;
            break;
        } while (this.g[this.f208c] != ' ');
        if (this.e - this.d > 4 && this.g[this.d + 3] == '.' && ((this.g[this.d] == 'O' || this.g[this.d] == 'o') && ((this.g[this.d + 1] == 'I' || this.g[this.d + 1] == 'i') && (this.g[this.d + 2] == 'D' || this.g[this.d + 2] == 'd')))) {
            this.d += 4;
        }
        return new String(this.g, this.d, this.e - this.d);
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        if (this.f208c + 4 >= this.f207b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f206a);
        }
        this.d = this.f208c;
        int i = this.f208c;
        while (true) {
            this.f208c = i + 1;
            if (this.f208c == this.f207b || this.g[this.f208c] == '+' || this.g[this.f208c] == ',' || this.g[this.f208c] == ';') {
                this.e = this.f208c;
            } else if (this.g[this.f208c] == ' ') {
                this.e = this.f208c;
                do {
                    this.f208c++;
                    if (this.f208c >= this.f207b) {
                        break;
                    }
                } while (this.g[this.f208c] != ' ');
            } else {
                if (this.g[this.f208c] >= 'A' && this.g[this.f208c] <= 'F') {
                    char[] cArr = this.g;
                    int i2 = this.f208c;
                    cArr[i2] = (char) (cArr[i2] + ' ');
                }
                i = this.f208c;
            }
        }
        this.e = this.f208c;
        int i3 = this.e - this.d;
        if (i3 < 5 || (i3 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f206a);
        }
        byte[] bArr = new byte[(i3 / 2)];
        int i4 = this.d + 1;
        for (int i5 = 0; i5 < bArr.length; i5++) {
            bArr[i5] = (byte) a(i4);
            i4 += 2;
        }
        return new String(this.g, this.d, i3);
    }

    /* access modifiers changed from: package-private */
    public final String c() {
        this.d = this.f208c;
        this.e = this.f208c;
        while (this.f208c < this.f207b) {
            char c2 = this.g[this.f208c];
            if (c2 != ' ') {
                if (c2 != ';') {
                    if (c2 != '\\') {
                        switch (c2) {
                            case '+':
                            case ',':
                                break;
                            default:
                                char[] cArr = this.g;
                                int i = this.e;
                                this.e = i + 1;
                                cArr[i] = this.g[this.f208c];
                                break;
                        }
                    } else {
                        char[] cArr2 = this.g;
                        int i2 = this.e;
                        this.e = i2 + 1;
                        cArr2[i2] = d();
                    }
                    this.f208c++;
                }
                return new String(this.g, this.d, this.e - this.d);
            }
            this.f = this.e;
            this.f208c++;
            char[] cArr3 = this.g;
            int i3 = this.e;
            this.e = i3 + 1;
            cArr3[i3] = ' ';
            while (this.f208c < this.f207b && this.g[this.f208c] == ' ') {
                char[] cArr4 = this.g;
                int i4 = this.e;
                this.e = i4 + 1;
                cArr4[i4] = ' ';
                this.f208c++;
            }
            if (this.f208c == this.f207b || this.g[this.f208c] == ',' || this.g[this.f208c] == '+' || this.g[this.f208c] == ';') {
                return new String(this.g, this.d, this.f - this.d);
            }
        }
        return new String(this.g, this.d, this.e - this.d);
    }

    /* access modifiers changed from: package-private */
    public final char d() {
        this.f208c++;
        if (this.f208c == this.f207b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f206a);
        }
        char c2 = this.g[this.f208c];
        if (!(c2 == ' ' || c2 == '%' || c2 == '\\' || c2 == '_')) {
            switch (c2) {
                case '\"':
                case '#':
                    break;
                default:
                    switch (c2) {
                        case '*':
                        case '+':
                        case ',':
                            break;
                        default:
                            switch (c2) {
                                case ';':
                                case '<':
                                case '=':
                                case '>':
                                    break;
                                default:
                                    return f();
                            }
                    }
            }
        }
        return this.g[this.f208c];
    }
}
