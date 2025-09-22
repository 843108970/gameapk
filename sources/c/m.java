package c;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class m extends h {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final MessageDigest f401a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Mac f402b;

    private m(x xVar, f fVar, String str) {
        super(xVar);
        try {
            this.f402b = Mac.getInstance(str);
            this.f402b.init(new SecretKeySpec(fVar.toByteArray(), str));
            this.f401a = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private m(x xVar, String str) {
        super(xVar);
        try {
            this.f401a = MessageDigest.getInstance(str);
            this.f402b = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private f a() {
        return f.of(this.f401a != null ? this.f401a.digest() : this.f402b.doFinal());
    }

    private static m a(x xVar) {
        return new m(xVar, "MD5");
    }

    private static m a(x xVar, f fVar) {
        return new m(xVar, fVar, "HmacSHA1");
    }

    private static m b(x xVar) {
        return new m(xVar, "SHA-1");
    }

    private static m b(x xVar, f fVar) {
        return new m(xVar, fVar, "HmacSHA256");
    }

    private static m c(x xVar) {
        return new m(xVar, "SHA-256");
    }

    private static m c(x xVar, f fVar) {
        return new m(xVar, fVar, "HmacSHA512");
    }

    private static m d(x xVar) {
        return new m(xVar, "SHA-512");
    }

    public final void a(c cVar, long j) throws IOException {
        ab.a(cVar.f387c, 0, j);
        u uVar = cVar.f386b;
        long j2 = 0;
        while (j2 < j) {
            int min = (int) Math.min(j - j2, (long) (uVar.e - uVar.d));
            if (this.f401a != null) {
                this.f401a.update(uVar.f432c, uVar.d, min);
            } else {
                this.f402b.update(uVar.f432c, uVar.d, min);
            }
            uVar = uVar.h;
            j2 += (long) min;
        }
        super.a(cVar, j);
    }
}
