package com.cyjh.http.d.b;

import android.content.Context;
import com.android.volley.n;
import com.cyjh.http.d.a.a;
import java.util.Map;

public abstract class b implements n.a, n.b<Object> {
    private d a(String str, a aVar) {
        return new d(str, this, this, aVar);
    }

    private d a(String str, Map<String, String> map, a aVar) {
        return new d(str, map, (n.b<Object>) this, (n.a) this, aVar);
    }

    private void a(Context context, Object obj, String str, a aVar) {
        c.a().a(context, obj, new d(str, this, this, aVar));
    }

    private void a(Context context, Object obj, String str, Map<String, String> map, a aVar) {
        c.a().a(context, obj, new d(str, map, (n.b<Object>) this, (n.a) this, aVar));
    }
}
