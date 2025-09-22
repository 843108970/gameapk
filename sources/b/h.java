package b;

import javax.annotation.Nullable;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final String f314a;

    /* renamed from: b  reason: collision with root package name */
    private final String f315b;

    public h(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        } else if (str2 == null) {
            throw new NullPointerException("realm == null");
        } else {
            this.f314a = str;
            this.f315b = str2;
        }
    }

    private String a() {
        return this.f314a;
    }

    private String b() {
        return this.f315b;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return hVar.f314a.equals(this.f314a) && hVar.f315b.equals(this.f315b);
    }

    public final int hashCode() {
        return ((this.f315b.hashCode() + 899) * 31) + this.f314a.hashCode();
    }

    public final String toString() {
        return this.f314a + " realm=\"" + this.f315b + "\"";
    }
}
