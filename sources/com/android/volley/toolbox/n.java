package com.android.volley.toolbox;

import com.android.volley.i;
import com.android.volley.k;
import com.android.volley.n;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class n extends o<JSONObject> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(int i, String str, JSONObject jSONObject, n.b<JSONObject> bVar, n.a aVar) {
        super(i, str, jSONObject == null ? null : jSONObject.toString(), bVar, aVar);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private n(String str, JSONObject jSONObject, n.b<JSONObject> bVar, n.a aVar) {
        this(jSONObject == null ? 0 : 1, str, jSONObject, bVar, aVar);
    }

    /* access modifiers changed from: protected */
    public final com.android.volley.n<JSONObject> a(i iVar) {
        k kVar;
        try {
            return com.android.volley.n.a(new JSONObject(new String(iVar.f484b, h.a(iVar.f485c, "utf-8"))), h.a(iVar));
        } catch (UnsupportedEncodingException e) {
            kVar = new k((Throwable) e);
            return com.android.volley.n.a(kVar);
        } catch (JSONException e2) {
            kVar = new k((Throwable) e2);
            return com.android.volley.n.a(kVar);
        }
    }
}
