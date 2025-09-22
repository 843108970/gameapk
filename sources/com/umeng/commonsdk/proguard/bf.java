package com.umeng.commonsdk.proguard;

import java.util.BitSet;

public final class bf extends at {

    public static class a implements bb {
        public az a(bn bnVar) {
            return new bf(bnVar);
        }
    }

    public bf(bn bnVar) {
        super(bnVar);
    }

    public static BitSet a(byte[] bArr) {
        BitSet bitSet = new BitSet();
        for (int i = 0; i < bArr.length * 8; i++) {
            if ((bArr[(bArr.length - (i / 8)) - 1] & (1 << (i % 8))) > 0) {
                bitSet.set(i);
            }
        }
        return bitSet;
    }

    public static byte[] b(BitSet bitSet, int i) {
        byte[] bArr = new byte[((int) Math.ceil(((double) i) / 8.0d))];
        for (int i2 = 0; i2 < bitSet.length(); i2++) {
            if (bitSet.get(i2)) {
                int length = (bArr.length - (i2 / 8)) - 1;
                bArr[length] = (byte) ((1 << (i2 % 8)) | bArr[length]);
            }
        }
        return bArr;
    }

    public final Class<? extends bh> D() {
        return bk.class;
    }

    public final void a(BitSet bitSet, int i) throws ag {
        for (byte a2 : b(bitSet, i)) {
            a(a2);
        }
    }

    public final BitSet b(int i) throws ag {
        int ceil = (int) Math.ceil(((double) i) / 8.0d);
        byte[] bArr = new byte[ceil];
        for (int i2 = 0; i2 < ceil; i2++) {
            bArr[i2] = u();
        }
        return a(bArr);
    }
}
