package c;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class n extends i {

    /* renamed from: a  reason: collision with root package name */
    private final MessageDigest f403a;

    /* renamed from: b  reason: collision with root package name */
    private final Mac f404b;

    private n(y yVar, f fVar, String str) {
        super(yVar);
        try {
            this.f404b = Mac.getInstance(str);
            this.f404b.init(new SecretKeySpec(fVar.toByteArray(), str));
            this.f403a = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private n(y yVar, String str) {
        super(yVar);
        try {
            this.f403a = MessageDigest.getInstance(str);
            this.f404b = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private f a() {
        return f.of(this.f403a != null ? this.f403a.digest() : this.f404b.doFinal());
    }

    private static n a(y yVar) {
        return new n(yVar, "MD5");
    }

    private static n a(y yVar, f fVar) {
        return new n(yVar, fVar, "HmacSHA1");
    }

    private static n b(y yVar) {
        return new n(yVar, "SHA-1");
    }

    private static n b(y yVar, f fVar) {
        return new n(yVar, fVar, "HmacSHA256");
    }

    private static n c(y yVar) {
        return new n(yVar, "SHA-256");
    }

    public final long read(c cVar, long j) throws IOException {
        long read = super.read(cVar, j);
        if (read != -1) {
            long j2 = cVar.f387c - read;
            long j3 = cVar.f387c;
            u uVar = cVar.f386b;
            while (j3 > j2) {
                uVar = uVar.i;
                j3 -= (long) (uVar.e - uVar.d);
            }
            while (j3 < cVar.f387c) {
                int i = (int) ((((long) uVar.d) + j2) - j3);
                if (this.f403a != null) {
                    this.f403a.update(uVar.f432c, i, uVar.e - i);
                } else {
                    this.f404b.update(uVar.f432c, i, uVar.e - i);
                }
                uVar = uVar.h;
                j3 += (long) (uVar.e - uVar.d);
                j2 = j3;
            }
        }
        return read;
    }
}
