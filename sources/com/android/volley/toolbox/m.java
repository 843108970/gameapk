package com.android.volley.toolbox;

import com.android.volley.i;
import com.android.volley.k;
import com.android.volley.n;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;

public final class m extends o<JSONArray> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private m(int i, String str, JSONArray jSONArray, n.b<JSONArray> bVar, n.a aVar) {
        super(i, str, jSONArray == null ? null : jSONArray.toString(), bVar, aVar);
    }

    private m(String str, n.b<JSONArray> bVar, n.a aVar) {
        super(0, str, (String) null, bVar, aVar);
    }

    /* access modifiers changed from: protected */
    public final n<JSONArray> a(i iVar) {
        k kVar;
        try {
            return n.a(new JSONArray(new String(iVar.f484b, h.a(iVar.f485c, "utf-8"))), h.a(iVar));
        } catch (UnsupportedEncodingException e) {
            kVar = new k((Throwable) e);
            return n.a(kVar);
        } catch (JSONException e2) {
            kVar = new k((Throwable) e2);
            return n.a(kVar);
        }
    }
}
