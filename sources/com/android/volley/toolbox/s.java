package com.android.volley.toolbox;

import com.android.volley.i;
import com.android.volley.l;
import com.android.volley.n;
import java.io.UnsupportedEncodingException;

public class s extends l<String> {
    private final n.b<String> m;

    public s(String str, n.b<String> bVar, n.a aVar) {
        super(0, str, aVar);
        this.m = bVar;
    }

    private s(String str, n.b<String> bVar, n.a aVar, byte b2) {
        this(str, bVar, aVar);
    }

    private void c(String str) {
        this.m.a(str);
    }

    /* access modifiers changed from: protected */
    public final n<String> a(i iVar) {
        String str;
        try {
            str = new String(iVar.f484b, h.a(iVar.f485c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(iVar.f484b);
        }
        return n.a(str, h.a(iVar));
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.m.a((String) obj);
    }
}
