package com.iflytek.collector.a.a;

import com.iflytek.collector.a.a.g;
import com.iflytek.voiceads.config.SDKLogger;

class j implements g.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f3505a;

    j(i iVar) {
        this.f3505a = iVar;
    }

    public void a(g gVar, byte[] bArr) {
        if (bArr != null) {
            try {
                String str = new String(bArr, "utf-8");
                if (!g.a(str)) {
                    SDKLogger.d("Collector", "upload success");
                    this.f3505a.a(str);
                }
            } catch (Throwable th) {
                a(new Exception(th));
            }
        }
    }

    public void a(Exception exc) {
        SDKLogger.e("Collector", "update error:" + exc);
    }
}
