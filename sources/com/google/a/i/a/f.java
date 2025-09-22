package com.google.a.i.a;

public enum f {
    L(1),
    M(0),
    Q(3),
    H(2);
    
    private static final f[] FOR_BITS = null;
    private final int bits;

    static {
        FOR_BITS = new f[]{M, L, H, Q};
    }

    private f(int i) {
        this.bits = i;
    }

    public static f forBits(int i) {
        if (i >= 0 && i < FOR_BITS.length) {
            return FOR_BITS[i];
        }
        throw new IllegalArgumentException();
    }

    public final int getBits() {
        return this.bits;
    }
}
