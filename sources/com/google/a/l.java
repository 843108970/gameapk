package com.google.a;

import com.google.a.a.c;
import com.google.a.c.b;
import com.google.a.g.ab;
import com.google.a.g.d;
import com.google.a.g.f;
import com.google.a.g.h;
import com.google.a.g.j;
import com.google.a.g.o;
import com.google.a.g.u;
import java.util.Map;

public final class l implements v {
    public final b a(String str, a aVar, int i, int i2) throws w {
        return a(str, aVar, i, i2, (Map<g, ?>) null);
    }

    public final b a(String str, a aVar, int i, int i2, Map<g, ?> map) throws w {
        v vVar;
        switch (aVar) {
            case EAN_8:
                vVar = new com.google.a.g.l();
                break;
            case UPC_E:
                vVar = new ab();
                break;
            case EAN_13:
                vVar = new j();
                break;
            case UPC_A:
                vVar = new u();
                break;
            case QR_CODE:
                vVar = new com.google.a.i.b();
                break;
            case CODE_39:
                vVar = new f();
                break;
            case CODE_93:
                vVar = new h();
                break;
            case CODE_128:
                vVar = new d();
                break;
            case ITF:
                vVar = new o();
                break;
            case PDF_417:
                vVar = new com.google.a.h.d();
                break;
            case CODABAR:
                vVar = new com.google.a.g.b();
                break;
            case DATA_MATRIX:
                vVar = new com.google.a.d.b();
                break;
            case AZTEC:
                vVar = new c();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format ".concat(String.valueOf(aVar)));
        }
        return vVar.a(str, aVar, i, i2, map);
    }
}
