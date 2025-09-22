package com.umeng.commonsdk.framework;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.umeng.analytics.pro.b;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import org.json.JSONObject;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static HandlerThread f3680a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Handler f3681b = null;

    /* renamed from: c  reason: collision with root package name */
    private static d f3682c = null;
    private static final int d = 768;
    private static final int e = 769;
    private static final int f = 770;

    private e() {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0030: MOVE  (r2v2 java.lang.String) = (r2v1 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    private static org.json.JSONObject a(org.json.JSONObject r4, org.json.JSONObject r5, java.lang.String r6) {
        /*
            android.content.Context r0 = com.umeng.commonsdk.framework.c.a()
            if (r4 == 0) goto L_0x004b
            if (r5 == 0) goto L_0x004b
            java.lang.Object r1 = r4.opt(r6)     // Catch:{ Throwable -> 0x0047 }
            if (r1 == 0) goto L_0x004b
            java.lang.Object r1 = r4.opt(r6)     // Catch:{ Throwable -> 0x0047 }
            boolean r1 = r1 instanceof org.json.JSONObject     // Catch:{ Throwable -> 0x0047 }
            if (r1 == 0) goto L_0x004b
            java.lang.Object r6 = r4.opt(r6)     // Catch:{ Throwable -> 0x0047 }
            org.json.JSONObject r6 = (org.json.JSONObject) r6     // Catch:{ Throwable -> 0x0047 }
            java.util.Iterator r1 = r5.keys()     // Catch:{ Throwable -> 0x0047 }
        L_0x0020:
            boolean r2 = r1.hasNext()     // Catch:{ Throwable -> 0x0047 }
            if (r2 == 0) goto L_0x004b
            java.lang.Object r2 = r1.next()     // Catch:{ Throwable -> 0x0047 }
            if (r2 == 0) goto L_0x0020
            boolean r3 = r2 instanceof java.lang.String     // Catch:{ Throwable -> 0x0047 }
            if (r3 == 0) goto L_0x0020
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Throwable -> 0x0047 }
            if (r2 == 0) goto L_0x0020
            java.lang.Object r3 = r5.opt(r2)     // Catch:{ Throwable -> 0x0047 }
            if (r3 == 0) goto L_0x0020
            java.lang.Object r3 = r5.opt(r2)     // Catch:{ Exception -> 0x0042 }
            r6.put(r2, r3)     // Catch:{ Exception -> 0x0042 }
            goto L_0x0020
        L_0x0042:
            r2 = move-exception
            com.umeng.commonsdk.proguard.e.a(r0, r2)     // Catch:{ Throwable -> 0x0047 }
            goto L_0x0020
        L_0x0047:
            r5 = move-exception
            com.umeng.commonsdk.proguard.e.a(r0, r5)
        L_0x004b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.e.a(org.json.JSONObject, org.json.JSONObject, java.lang.String):org.json.JSONObject");
    }

    public static void a() {
        if (f3681b != null) {
            Message obtainMessage = f3681b.obtainMessage();
            obtainMessage.what = f;
            f3681b.sendMessage(obtainMessage);
        }
    }

    public static void a(Context context, int i, UMLogDataProtocol uMLogDataProtocol, Object obj) {
        if (context == null || uMLogDataProtocol == null) {
            com.umeng.commonsdk.statistics.common.e.b("--->>> Context or UMLogDataProtocol parameter cannot be null!");
            return;
        }
        c.a(context.getApplicationContext());
        if (c.a(i, uMLogDataProtocol)) {
            if (f3680a == null || f3681b == null) {
                e();
            }
            if (f3681b != null) {
                if (f3682c == null) {
                    b.f(context);
                    f3682c = new d(context, f3681b);
                }
                Message obtainMessage = f3681b.obtainMessage();
                obtainMessage.what = d;
                obtainMessage.arg1 = i;
                obtainMessage.obj = obj;
                f3681b.sendMessage(obtainMessage);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(Message message) {
        int i = message.arg1;
        Object obj = message.obj;
        UMLogDataProtocol a2 = c.a(c.a(i));
        if (a2 != null) {
            com.umeng.commonsdk.statistics.common.e.b("--->>> dispatch:handleEvent: call back workEvent with msg type [ 0x" + Integer.toHexString(i) + "]");
            a2.workEvent(obj, i);
        }
    }

    /* access modifiers changed from: private */
    public static void d() {
        com.umeng.commonsdk.statistics.common.e.b("--->>> autoProcess Enter...");
        Context a2 = c.a();
        if (a2 != null) {
            long maxDataSpace = UMEnvelopeBuild.maxDataSpace(a2);
            UMLogDataProtocol a3 = c.a("analytics");
            JSONObject jSONObject = null;
            int i = 0;
            try {
                if (!(!UMEnvelopeBuild.isReadyBuild(a2, UMLogDataProtocol.UMBusinessType.U_DPLUS) || a3 == null || (jSONObject = a3.setupReportData(maxDataSpace)) == null)) {
                    i = jSONObject.toString().getBytes().length;
                }
                if (jSONObject != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("header", new JSONObject());
                    jSONObject2.put(b.W, new JSONObject());
                    if (jSONObject != null && i > 0) {
                        jSONObject2 = a(a(jSONObject2, jSONObject.optJSONObject("header"), "header"), jSONObject.optJSONObject(b.W), b.W);
                    }
                    if (jSONObject2 != null && UMEnvelopeBuild.buildEnvelopeWithExtHeader(a2, jSONObject2.optJSONObject("header"), jSONObject2.optJSONObject(b.W)) != null && jSONObject != null) {
                        a3.removeCacheData(jSONObject);
                    }
                }
            } catch (Throwable th) {
                com.umeng.commonsdk.proguard.e.a(a2, th);
            }
        }
    }

    private static void e() {
        com.umeng.commonsdk.statistics.common.e.b("--->>> Dispatch: init Enter...");
        if (f3680a == null) {
            HandlerThread handlerThread = new HandlerThread("work_thread");
            f3680a = handlerThread;
            handlerThread.start();
            if (f3681b == null) {
                f3681b = new Handler(f3680a.getLooper()) {
                    public final void handleMessage(Message message) {
                        switch (message.what) {
                            case e.d /*768*/:
                                e.b(message);
                                return;
                            case e.e /*769*/:
                                e.d();
                                return;
                            case e.f /*770*/:
                                e.g();
                                return;
                            default:
                                return;
                        }
                    }
                };
            }
        }
    }

    private static void f() {
        if (f3680a != null) {
            f3680a = null;
        }
        if (f3681b != null) {
            f3681b = null;
        }
        if (f3682c != null) {
            f3682c = null;
        }
    }

    /* access modifiers changed from: private */
    public static void g() {
        if (f3682c != null && f3680a != null) {
            d.a();
            com.umeng.commonsdk.statistics.common.e.b("--->>> handleQuit: Quit dispatch thread.");
            f3680a.quit();
            f();
        }
    }
}
