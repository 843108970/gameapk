package org.a.a;

import com.cyjh.common.util.s;
import org.a.g;
import org.a.p;

public abstract class r extends p<String> {

    /* renamed from: a  reason: collision with root package name */
    protected final String f4259a;

    protected r(String str) {
        this.f4259a = str;
    }

    private static void a(String str, g gVar) {
        gVar.a("was \"").a(str).a("\"");
    }

    private boolean b(String str) {
        return b(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean b(String str);

    /* access modifiers changed from: protected */
    public abstract String b();

    public final /* synthetic */ void b(Object obj, g gVar) {
        gVar.a("was \"").a((String) obj).a("\"");
    }

    public void describeTo(g gVar) {
        gVar.a("a string ").a(b()).a(s.a.f1696a).a((Object) this.f4259a);
    }
}
