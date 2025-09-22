package mobi.oneway.export.f.a;

import mobi.oneway.export.b.b.d;
import mobi.oneway.export.enums.AdType;
import mobi.oneway.export.enums.EventType;
import mobi.oneway.export.enums.OnewaySdkError;
import mobi.oneway.export.f.e;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected int f4182a;

    /* renamed from: b  reason: collision with root package name */
    protected String f4183b;

    /* renamed from: c  reason: collision with root package name */
    protected String f4184c;
    protected e d;
    protected d e;

    public a(mobi.oneway.export.f.a aVar) {
        this.f4182a = aVar.a();
        this.f4183b = aVar.f();
        this.f4184c = aVar.g();
        this.d = new e(c(), aVar);
    }

    /* access modifiers changed from: protected */
    public String a() {
        return this.f4183b;
    }

    public void a(d dVar) {
        this.e = dVar;
    }

    /* access modifiers changed from: protected */
    public void a(EventType eventType) {
        this.d.a(eventType, (String) null);
    }

    /* access modifiers changed from: protected */
    public void a(OnewaySdkError onewaySdkError, String str) {
        this.d.a(EventType.adFail, onewaySdkError, str);
    }

    /* access modifiers changed from: protected */
    public String b() {
        return this.f4184c;
    }

    public void b(OnewaySdkError onewaySdkError, String str) {
        if (this.e != null) {
            this.e.a(this.f4183b, onewaySdkError, str);
        }
    }

    /* access modifiers changed from: protected */
    public abstract AdType c();
}
