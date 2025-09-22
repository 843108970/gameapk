package com.goldcoast.sdk.domain;

import android.text.TextUtils;
import com.goldcoast.sdk.c.h;
import org.json.JSONArray;

final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EntryPoint f2970a;

    i(EntryPoint entryPoint) {
        this.f2970a = entryPoint;
    }

    public final void run() {
        h.a();
        String a2 = h.a("refer");
        if (!TextUtils.isEmpty(a2)) {
            try {
                JSONArray jSONArray = new JSONArray(a2);
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.f2970a.a(jSONArray.get(i).toString(), i, 2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
