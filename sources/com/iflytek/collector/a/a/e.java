package com.iflytek.collector.a.a;

import com.iflytek.collector.a.a.g;
import com.iflytek.voiceads.config.SDKLogger;
import org.json.JSONObject;

class e implements g.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f3499a;

    e(d dVar) {
        this.f3499a = dVar;
    }

    public void a(g gVar, byte[] bArr) {
        if (bArr != null) {
            try {
                this.f3499a.a(new JSONObject(new String(bArr, "utf-8")));
            } catch (Exception e) {
                a(e);
            }
        }
    }

    public void a(Exception exc) {
        SDKLogger.e("Collector", "update dex error:" + exc);
    }
}
