package b.a.c;

import b.a.d.g;
import b.ac;
import b.ae;
import b.w;
import b.z;
import com.github.kevinsawicki.http.HttpRequest;
import java.io.IOException;

public final class a implements w {

    /* renamed from: a  reason: collision with root package name */
    public final z f56a;

    public a(z zVar) {
        this.f56a = zVar;
    }

    public final ae intercept(w.a aVar) throws IOException {
        g gVar = (g) aVar;
        ac acVar = gVar.d;
        g gVar2 = gVar.f82a;
        return gVar.a(acVar, gVar2, gVar2.a(this.f56a, !acVar.f248b.equals(HttpRequest.METHOD_GET)), gVar2.b());
    }
}
