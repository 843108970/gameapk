package com.bumptech.glide.f;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.g;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class c implements g {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final String f954c;
    private final long d;
    private final int e;

    private c(@Nullable String str, long j, int i) {
        this.f954c = str == null ? "" : str;
        this.d = j;
        this.e = i;
    }

    public final void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.d).putInt(this.e).array());
        messageDigest.update(this.f954c.getBytes(f1387b));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.d == cVar.d && this.e == cVar.e && this.f954c.equals(cVar.f954c);
    }

    public final int hashCode() {
        return (((this.f954c.hashCode() * 31) + ((int) (this.d ^ (this.d >>> 32)))) * 31) + this.e;
    }
}
