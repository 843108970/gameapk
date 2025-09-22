package com.google.a.d.c;

import java.util.Arrays;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final int f3113a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f3114b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence f3115c;
    private final int d;

    public e(CharSequence charSequence, int i, int i2) {
        this.f3115c = charSequence;
        this.f3113a = i;
        this.d = i2;
        this.f3114b = new byte[(i * i2)];
        Arrays.fill(this.f3114b, (byte) -1);
    }

    private void a(int i) {
        a(this.d - 1, 0, i, 1);
        a(this.d - 1, 1, i, 2);
        a(this.d - 1, 2, i, 3);
        a(0, this.f3113a - 2, i, 4);
        a(0, this.f3113a - 1, i, 5);
        a(1, this.f3113a - 1, i, 6);
        a(2, this.f3113a - 1, i, 7);
        a(3, this.f3113a - 1, i, 8);
    }

    private void a(int i, int i2, int i3) {
        int i4 = i - 2;
        int i5 = i2 - 2;
        a(i4, i5, i3, 1);
        int i6 = i2 - 1;
        a(i4, i6, i3, 2);
        int i7 = i - 1;
        a(i7, i5, i3, 3);
        a(i7, i6, i3, 4);
        a(i7, i2, i3, 5);
        a(i, i5, i3, 6);
        a(i, i6, i3, 7);
        a(i, i2, i3, 8);
    }

    private void a(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i += this.d;
            i2 += 4 - ((this.d + 4) % 8);
        }
        if (i2 < 0) {
            i2 += this.f3113a;
            i += 4 - ((this.f3113a + 4) % 8);
        }
        boolean z = true;
        if ((this.f3115c.charAt(i3) & (1 << (8 - i4))) == 0) {
            z = false;
        }
        a(i2, i, z);
    }

    private void a(int i, int i2, boolean z) {
        this.f3114b[(i2 * this.f3113a) + i] = z ? (byte) 1 : 0;
    }

    private boolean a(int i, int i2) {
        return this.f3114b[(i2 * this.f3113a) + i] == 1;
    }

    private int b() {
        return this.d;
    }

    private void b(int i) {
        a(this.d - 3, 0, i, 1);
        a(this.d - 2, 0, i, 2);
        a(this.d - 1, 0, i, 3);
        a(0, this.f3113a - 4, i, 4);
        a(0, this.f3113a - 3, i, 5);
        a(0, this.f3113a - 2, i, 6);
        a(0, this.f3113a - 1, i, 7);
        a(1, this.f3113a - 1, i, 8);
    }

    private boolean b(int i, int i2) {
        return this.f3114b[(i2 * this.f3113a) + i] >= 0;
    }

    private int c() {
        return this.f3113a;
    }

    private void c(int i) {
        a(this.d - 3, 0, i, 1);
        a(this.d - 2, 0, i, 2);
        a(this.d - 1, 0, i, 3);
        a(0, this.f3113a - 2, i, 4);
        a(0, this.f3113a - 1, i, 5);
        a(1, this.f3113a - 1, i, 6);
        a(2, this.f3113a - 1, i, 7);
        a(3, this.f3113a - 1, i, 8);
    }

    private void d(int i) {
        a(this.d - 1, 0, i, 1);
        a(this.d - 1, this.f3113a - 1, i, 2);
        a(0, this.f3113a - 3, i, 3);
        a(0, this.f3113a - 2, i, 4);
        a(0, this.f3113a - 1, i, 5);
        a(1, this.f3113a - 3, i, 6);
        a(1, this.f3113a - 2, i, 7);
        a(1, this.f3113a - 1, i, 8);
    }

    private byte[] d() {
        return this.f3114b;
    }

    public final void a() {
        int i = 4;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i == this.d && i2 == 0) {
                a(this.d - 1, 0, i3, 1);
                a(this.d - 1, 1, i3, 2);
                a(this.d - 1, 2, i3, 3);
                a(0, this.f3113a - 2, i3, 4);
                a(0, this.f3113a - 1, i3, 5);
                a(1, this.f3113a - 1, i3, 6);
                a(2, this.f3113a - 1, i3, 7);
                a(3, this.f3113a - 1, i3, 8);
                i3++;
            }
            if (i == this.d - 2 && i2 == 0 && this.f3113a % 4 != 0) {
                a(this.d - 3, 0, i3, 1);
                a(this.d - 2, 0, i3, 2);
                a(this.d - 1, 0, i3, 3);
                a(0, this.f3113a - 4, i3, 4);
                a(0, this.f3113a - 3, i3, 5);
                a(0, this.f3113a - 2, i3, 6);
                a(0, this.f3113a - 1, i3, 7);
                a(1, this.f3113a - 1, i3, 8);
                i3++;
            }
            if (i == this.d - 2 && i2 == 0 && this.f3113a % 8 == 4) {
                a(this.d - 3, 0, i3, 1);
                a(this.d - 2, 0, i3, 2);
                a(this.d - 1, 0, i3, 3);
                a(0, this.f3113a - 2, i3, 4);
                a(0, this.f3113a - 1, i3, 5);
                a(1, this.f3113a - 1, i3, 6);
                a(2, this.f3113a - 1, i3, 7);
                a(3, this.f3113a - 1, i3, 8);
                i3++;
            }
            if (i == this.d + 4 && i2 == 2 && this.f3113a % 8 == 0) {
                a(this.d - 1, 0, i3, 1);
                a(this.d - 1, this.f3113a - 1, i3, 2);
                a(0, this.f3113a - 3, i3, 3);
                a(0, this.f3113a - 2, i3, 4);
                a(0, this.f3113a - 1, i3, 5);
                a(1, this.f3113a - 3, i3, 6);
                a(1, this.f3113a - 2, i3, 7);
                a(1, this.f3113a - 1, i3, 8);
                i3++;
            }
            do {
                if (i < this.d && i2 >= 0 && !b(i2, i)) {
                    a(i, i2, i3);
                    i3++;
                }
                i -= 2;
                i2 += 2;
                if (i < 0 || i2 >= this.f3113a) {
                    int i4 = i + 1;
                    int i5 = i2 + 3;
                }
                a(i, i2, i3);
                i3++;
                i -= 2;
                i2 += 2;
                break;
            } while (i2 >= this.f3113a);
            int i42 = i + 1;
            int i52 = i2 + 3;
            do {
                if (i42 >= 0 && i52 < this.f3113a && !b(i52, i42)) {
                    a(i42, i52, i3);
                    i3++;
                }
                i42 += 2;
                i52 -= 2;
                if (i42 >= this.d) {
                    break;
                }
            } while (i52 >= 0);
            i = i42 + 3;
            i2 = i52 + 1;
            if (i >= this.d && i2 >= this.f3113a) {
                break;
            }
        }
        if (!b(this.f3113a - 1, this.d - 1)) {
            a(this.f3113a - 1, this.d - 1, true);
            a(this.f3113a - 2, this.d - 2, true);
        }
    }
}
