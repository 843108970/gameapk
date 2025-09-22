package com.goldcoast.sdk.domain;

import android.os.ConditionVariable;
import android.text.TextUtils;
import com.b.a.as;
import com.goldcoast.sdk.c.a;
import com.goldcoast.sdk.c.g;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

final class h implements com.b.a.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f2967a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f2968b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ConditionVariable f2969c;
    final /* synthetic */ int d;
    final /* synthetic */ EntryPoint e;

    h(EntryPoint entryPoint, int i, String str, ConditionVariable conditionVariable, int i2) {
        this.e = entryPoint;
        this.f2967a = i;
        this.f2968b = str;
        this.f2969c = conditionVariable;
        this.d = i2;
    }

    public final void a(as asVar) {
        String str;
        String d2 = asVar.e().d();
        HashMap hashMap = new HashMap();
        g.a();
        g.b("######\n" + String.format("<feedBackP.Enc>:%s\n", new Object[]{d2}));
        if (!TextUtils.isEmpty(d2) || this.f2967a != 1) {
            try {
                str = a.b(new JSONObject(d2).optString("body", ""));
            } catch (JSONException e2) {
                hashMap.put("message", this.e.getStackString(e2));
                str = null;
            }
            if (!TextUtils.isEmpty(str) || asVar.b() == 200 || this.f2967a != 1) {
                try {
                    if (new JSONObject(str).optString("code", "").equals("200")) {
                        if (this.f2967a == 2) {
                            EntryPoint.a(this.d);
                        }
                    } else if (this.f2967a == 1) {
                        EntryPoint.a(this.f2968b);
                        hashMap.put("message", "code not equals 200");
                    }
                } catch (Exception e3) {
                    hashMap.put("stack", this.e.getStackString(e3));
                }
                this.f2969c.open();
            }
        } else {
            hashMap.put("message", "response is null");
        }
        EntryPoint.a(this.f2968b);
        this.f2969c.open();
    }

    public final void a(IOException iOException) {
        new HashMap();
        if (this.f2967a == 1) {
            EntryPoint.a(this.f2968b);
        }
        this.e.b(this.e.getStackString(iOException), 3);
        this.f2969c.open();
    }
}
