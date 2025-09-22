package com.cyjh.elfin.floatingwindowprocess.d;

import android.content.Context;
import android.text.TextUtils;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.ae;
import com.cyjh.common.util.af;
import com.cyjh.common.util.ag;
import com.cyjh.common.util.e;
import com.cyjh.common.util.r;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.e.c.f;
import com.cyjh.elfin.e.c.k;
import com.cyjh.elfin.e.c.l;
import com.cyjh.elfin.e.c.n;
import com.cyjh.elfin.entity.ParamsWrap;
import com.cyjh.http.bean.request.UpdateRequestInfo;
import com.cyjh.http.bean.response.ScriptStartRunResponse;
import com.cyjh.http.bean.response.VersionUpdateInfo;
import com.cyjh.http.c.b.a;
import com.cyjh.http.c.c.c;
import com.ywfzjbcy.R;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2021a = "ScriptRunHelper";

    /* renamed from: com.cyjh.elfin.floatingwindowprocess.d.a$a  reason: collision with other inner class name */
    public interface C0028a {
        void a();

        void b();
    }

    private static void a() {
        c a2 = c.a();
        a2.f2487c = new c.b() {
            public final void a() {
                ad.c(a.f2021a, "runScriptOperate --> onCallbackFail");
            }

            public final void a(Object obj) {
                ad.c(a.f2021a, "runScriptOperate --> onCallbackSuc");
                String str = (String) obj;
                f.a();
                AppContext a2 = AppContext.a();
                f.a(a2, "ElfinFloatView onCallbackSuc --> data=" + str);
                if (!TextUtils.isEmpty(str)) {
                    ScriptStartRunResponse scriptStartRunResponse = (ScriptStartRunResponse) r.a(str, ScriptStartRunResponse.class);
                    if (scriptStartRunResponse != null && scriptStartRunResponse.Code == 200 && !TextUtils.isEmpty(scriptStartRunResponse.Data.ScriptEncryptKey)) {
                        ParamsWrap.getParamsWrap().setScriptEncryptKey(scriptStartRunResponse.Data.ScriptEncryptKey);
                        k.a(scriptStartRunResponse.Data.ScriptEncryptKey);
                        return;
                    }
                    return;
                }
                f.a();
                AppContext a3 = AppContext.a();
                f.a(a3, "ElfinFloatView onCallbackFail --> " + AppContext.a().getString(R.string.json_data_null));
            }
        };
        a2.a((Context) AppContext.a(), com.cyjh.elfin.d.c.a().b(), com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getId(), com.cyjh.common.b.a.S);
    }

    public static void a(final com.cyjh.common.f.a<Boolean> aVar) {
        c a2 = c.a();
        a2.f2487c = new c.b() {
            public final void a() {
            }

            /* JADX WARNING: Code restructure failed: missing block: B:31:0x00be, code lost:
                if (com.cyjh.elfin.floatingwindowprocess.d.b.b() != false) goto L_0x00d4;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(java.lang.Object r5) {
                /*
                    r4 = this;
                    java.lang.String r5 = (java.lang.String) r5
                    boolean r0 = android.text.TextUtils.isEmpty(r5)
                    r1 = 1
                    if (r0 != 0) goto L_0x00c1
                    java.lang.Class<com.cyjh.http.bean.response.ScriptStartRunResponse> r0 = com.cyjh.http.bean.response.ScriptStartRunResponse.class
                    java.lang.Object r5 = com.cyjh.common.util.r.a(r5, r0)
                    com.cyjh.http.bean.response.ScriptStartRunResponse r5 = (com.cyjh.http.bean.response.ScriptStartRunResponse) r5
                    int r0 = r5.Code
                    r2 = 200(0xc8, float:2.8E-43)
                    if (r0 != r2) goto L_0x002b
                    com.cyjh.common.f.a r0 = r4
                    r1 = 0
                    java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                    r0.a(r1)
                    com.cyjh.elfin.entity.ParamsWrap r0 = com.cyjh.elfin.entity.ParamsWrap.getParamsWrap()
                    com.cyjh.http.bean.response.ScriptStartRunInfo r5 = r5.Data
                    r0.mStartRunResponseInfo = r5
                    goto L_0x00da
                L_0x002b:
                    com.cyjh.common.f.a r0 = r4
                    java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)
                    r0.a(r2)
                    if (r5 == 0) goto L_0x00ad
                    java.lang.String r0 = "zzz"
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    java.lang.String r3 = "AppContext--onStartScript message:"
                    r2.<init>(r3)
                    java.lang.String r3 = r5.Message
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.e(r0, r2)
                    int r0 = r5.Code
                    java.lang.String r2 = r5.Message
                    r3 = 1100(0x44c, float:1.541E-42)
                    if (r3 == r0) goto L_0x0072
                    r3 = 1200(0x4b0, float:1.682E-42)
                    if (r3 == r0) goto L_0x0072
                    r3 = 1201(0x4b1, float:1.683E-42)
                    if (r3 == r0) goto L_0x0072
                    r3 = 1202(0x4b2, float:1.684E-42)
                    if (r3 == r0) goto L_0x0072
                    r3 = 1203(0x4b3, float:1.686E-42)
                    if (r3 == r0) goto L_0x0072
                    r3 = 1300(0x514, float:1.822E-42)
                    if (r3 != r0) goto L_0x0068
                    goto L_0x0072
                L_0x0068:
                    com.cyjh.elfin.base.AppContext r0 = com.cyjh.elfin.base.AppContext.a()
                    java.lang.String r5 = r5.Message
                    com.cyjh.common.util.ag.b((android.content.Context) r0, (java.lang.String) r5)
                    goto L_0x00b7
                L_0x0072:
                    boolean r5 = com.cyjh.elfin.ui.a.g.f2117a
                    if (r5 == 0) goto L_0x0088
                    boolean r5 = com.cyjh.elfin.ui.a.g.f2118c
                    if (r5 != 0) goto L_0x0088
                    org.greenrobot.eventbus.c r5 = org.greenrobot.eventbus.c.a()
                    com.cyjh.elfin.entity.MsgItem r0 = new com.cyjh.elfin.entity.MsgItem
                    r3 = 1005(0x3ed, float:1.408E-42)
                    r0.<init>(r3)
                    r5.c((java.lang.Object) r0)
                L_0x0088:
                    boolean r5 = com.cyjh.elfin.ui.a.g.f2117a
                    if (r5 != 0) goto L_0x00a0
                    com.cyjh.elfin.ui.a.g r5 = new com.cyjh.elfin.ui.a.g
                    com.cyjh.elfin.base.AppContext r0 = com.cyjh.elfin.base.AppContext.a()
                    r5.<init>(r0, r1, r2)
                    com.cyjh.elfin.floatingwindowprocess.d.a$4$1 r0 = new com.cyjh.elfin.floatingwindowprocess.d.a$4$1
                    r0.<init>(r5)
                    r5.f2119b = r0
                    r5.show()
                    goto L_0x00b7
                L_0x00a0:
                    org.greenrobot.eventbus.c r5 = org.greenrobot.eventbus.c.a()
                    com.cyjh.elfin.entity.MsgItem$UpdateMessageToDialog r0 = new com.cyjh.elfin.entity.MsgItem$UpdateMessageToDialog
                    r0.<init>(r2)
                    r5.c((java.lang.Object) r0)
                    goto L_0x00b7
                L_0x00ad:
                    com.cyjh.elfin.base.AppContext r5 = com.cyjh.elfin.base.AppContext.a()
                    r0 = 2131296452(0x7f0900c4, float:1.8210821E38)
                    com.cyjh.common.util.ag.b((android.content.Context) r5, (int) r0)
                L_0x00b7:
                    com.cyjh.elfin.floatingwindowprocess.d.b.j()
                    boolean r5 = com.cyjh.elfin.floatingwindowprocess.d.b.b()
                    if (r5 == 0) goto L_0x00da
                    goto L_0x00d4
                L_0x00c1:
                    com.cyjh.common.f.a r5 = r4
                    java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
                    r5.a(r0)
                    com.cyjh.elfin.base.AppContext r5 = com.cyjh.elfin.base.AppContext.a()
                    r0 = 2131296451(0x7f0900c3, float:1.821082E38)
                    com.cyjh.common.util.ag.b((android.content.Context) r5, (int) r0)
                L_0x00d4:
                    com.cyjh.elfin.floatingwindowprocess.d.b.j()
                    com.cyjh.elfin.floatingwindowprocess.d.b.d()
                L_0x00da:
                    com.cyjh.http.c.c.c r5 = com.cyjh.http.c.c.c.a()
                    r5.d()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cyjh.elfin.floatingwindowprocess.d.a.AnonymousClass4.a(java.lang.Object):void");
            }
        };
        a2.a((Context) AppContext.a(), com.cyjh.elfin.d.c.a().b(), com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getId(), com.cyjh.common.b.a.R);
    }

    public static void a(final C0028a aVar) {
        f.a();
        f.a(AppContext.a(), "updateVersionRequest --> ");
        String a2 = l.a(AppContext.a(), com.cyjh.elfin.a.a.u);
        String a3 = e.a((Context) AppContext.a());
        UpdateRequestInfo updateRequestInfo = new UpdateRequestInfo();
        updateRequestInfo.ScriptId = com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getId();
        updateRequestInfo.DeviceName = a3;
        updateRequestInfo.ScriptVersion = Integer.parseInt(a2);
        updateRequestInfo.IsScriptHotUpgrade = 1;
        updateRequestInfo.AppVersion = e.b();
        ad.c(f2021a, "updateVersionRequest --> 1 ScriptId=" + updateRequestInfo.ScriptId + ",DeviceName=" + updateRequestInfo.DeviceName + " AppVersion:" + updateRequestInfo.AppVersion);
        com.cyjh.http.c.b.a a4 = com.cyjh.http.c.b.a.a();
        a4.f2481c = new a.C0039a() {
            public final void a(VersionUpdateInfo versionUpdateInfo) {
                ad.c(a.f2021a, "onUpdateHas");
                if (versionUpdateInfo == null) {
                    a.b(r4);
                    return;
                }
                f.a();
                AppContext a2 = AppContext.a();
                f.a(a2, "updateVersionRequest onUpdateHas --> versionUpdateInfo.UpgradeMode=" + versionUpdateInfo.UpgradeMode);
                if (versionUpdateInfo.UpgradeMode == 2 && (5 == versionUpdateInfo.UpdateType || 3 == versionUpdateInfo.UpdateType)) {
                    af.a().a(versionUpdateInfo.AppVersion);
                    int i = n.e;
                    if (3 == versionUpdateInfo.UpdateType) {
                        i = n.d;
                    }
                    n.a().a(AppContext.a(), com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getId(), i).a(versionUpdateInfo.UpdateUrl);
                    return;
                }
                a.b(r4);
            }

            public final void b(VersionUpdateInfo versionUpdateInfo) {
                ad.c(a.f2021a, "onConnectStudioSocket");
            }

            public final void c(VersionUpdateInfo versionUpdateInfo) {
                ad.c(a.f2021a, "onUpdateOtherInfo");
            }
        };
        a4.a(false, AppContext.a(), updateRequestInfo);
    }

    public static void a(c.a aVar) {
        c a2 = c.a();
        a2.f2486b = aVar;
        a2.a(AppContext.a(), ParamsWrap.getParamsWrap().mStartRunResponseInfo.RunGuid);
    }

    static /* synthetic */ void b(final C0028a aVar) {
        c a2 = c.a();
        a2.f2487c = new c.b() {
            public final void a() {
                ad.c(a.f2021a, "runScriptOperate --> onCallbackFail");
                f.a();
                f.a(AppContext.a(), "ElfinFloatView onCallbackFail --> ");
                ae.b((Context) AppContext.a(), "runScriptOperate --> 准备工作失败");
                if (r4 != null) {
                    r4.a();
                }
            }

            public final void a(Object obj) {
                AppContext appContext;
                StringBuilder sb;
                int i;
                ad.c(a.f2021a, "runScriptOperate --> onCallbackSuc");
                ae.b((Context) AppContext.a(), "runScriptOperate --> 准备启动引擎");
                if (r4 != null) {
                    C0028a aVar = r4;
                    Boolean.valueOf(true);
                    aVar.b();
                }
                String str = (String) obj;
                f.a();
                AppContext a2 = AppContext.a();
                f.a(a2, "ElfinFloatView onCallbackSuc --> data=" + str);
                if (!TextUtils.isEmpty(str)) {
                    ScriptStartRunResponse scriptStartRunResponse = (ScriptStartRunResponse) r.a(str, ScriptStartRunResponse.class);
                    if (scriptStartRunResponse == null || scriptStartRunResponse.Code != 200) {
                        if (scriptStartRunResponse.Code == 1401 || 1400 == scriptStartRunResponse.Code) {
                            com.cyjh.elfin.d.c.a().f1864a = "";
                            com.cyjh.http.e.a.b(com.cyjh.common.b.a.ay + com.cyjh.common.a.a.c(), (Context) AppContext.a());
                        }
                        if (scriptStartRunResponse != null) {
                            ag.b((Context) AppContext.a(), scriptStartRunResponse.Message);
                            f.a();
                            AppContext a3 = AppContext.a();
                            f.a(a3, "ElfinFloatView onCallbackSuc --> " + scriptStartRunResponse.Message);
                            c.a().d();
                        }
                        AppContext a4 = AppContext.a();
                        i = R.string.json_parse_exception;
                        ag.b((Context) a4, (int) R.string.json_parse_exception);
                        f.a();
                        appContext = AppContext.a();
                        sb = new StringBuilder("ElfinFloatView onCallbackSuc --> ");
                    } else {
                        if (!TextUtils.isEmpty(scriptStartRunResponse.Data.ScriptEncryptKey)) {
                            ParamsWrap.getParamsWrap().setScriptEncryptKey(scriptStartRunResponse.Data.ScriptEncryptKey);
                        }
                        if (!TextUtils.isEmpty(scriptStartRunResponse.Data.ExpireTime)) {
                            try {
                                com.cyjh.elfin.d.c.a().f1865b = Long.parseLong(scriptStartRunResponse.Data.ExpireTime);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 1) {
                            f.a();
                            f.a(AppContext.a(), "ElfinFloatView onCallbackSuc --> runScript");
                            b.j();
                            b.c();
                        }
                        c.a().d();
                    }
                } else {
                    AppContext a5 = AppContext.a();
                    i = R.string.json_data_null;
                    ag.b((Context) a5, (int) R.string.json_data_null);
                    f.a();
                    appContext = AppContext.a();
                    sb = new StringBuilder("ElfinFloatView onCallbackFail --> ");
                }
                sb.append(AppContext.a().getString(i));
                f.a(appContext, sb.toString());
                c.a().d();
            }
        };
        a2.a((Context) AppContext.a(), com.cyjh.elfin.d.c.a().b(), com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getId(), com.cyjh.common.b.a.S);
    }

    private static void c(final C0028a aVar) {
        f.a();
        f.a(AppContext.a(), "updateVersionRequest --> ");
        String a2 = l.a(AppContext.a(), com.cyjh.elfin.a.a.u);
        String a3 = e.a((Context) AppContext.a());
        UpdateRequestInfo updateRequestInfo = new UpdateRequestInfo();
        updateRequestInfo.ScriptId = com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getId();
        updateRequestInfo.DeviceName = a3;
        updateRequestInfo.ScriptVersion = Integer.parseInt(a2);
        updateRequestInfo.IsScriptHotUpgrade = 1;
        updateRequestInfo.AppVersion = e.b();
        ad.c(f2021a, "updateVersionRequest --> 1 ScriptId=" + updateRequestInfo.ScriptId + ",DeviceName=" + updateRequestInfo.DeviceName + " AppVersion:" + updateRequestInfo.AppVersion);
        com.cyjh.http.c.b.a a4 = com.cyjh.http.c.b.a.a();
        a4.f2481c = new a.C0039a() {
            public final void a(VersionUpdateInfo versionUpdateInfo) {
                ad.c(a.f2021a, "onUpdateHas");
                if (versionUpdateInfo == null) {
                    a.b(aVar);
                    return;
                }
                f.a();
                AppContext a2 = AppContext.a();
                f.a(a2, "updateVersionRequest onUpdateHas --> versionUpdateInfo.UpgradeMode=" + versionUpdateInfo.UpgradeMode);
                if (versionUpdateInfo.UpgradeMode == 2 && (5 == versionUpdateInfo.UpdateType || 3 == versionUpdateInfo.UpdateType)) {
                    af.a().a(versionUpdateInfo.AppVersion);
                    int i = n.e;
                    if (3 == versionUpdateInfo.UpdateType) {
                        i = n.d;
                    }
                    n.a().a(AppContext.a(), com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getId(), i).a(versionUpdateInfo.UpdateUrl);
                    return;
                }
                a.b(aVar);
            }

            public final void b(VersionUpdateInfo versionUpdateInfo) {
                ad.c(a.f2021a, "onConnectStudioSocket");
            }

            public final void c(VersionUpdateInfo versionUpdateInfo) {
                ad.c(a.f2021a, "onUpdateOtherInfo");
            }
        };
        a4.a(false, AppContext.a(), updateRequestInfo);
    }

    private static void d(final C0028a aVar) {
        c a2 = c.a();
        a2.f2487c = new c.b() {
            public final void a() {
                ad.c(a.f2021a, "runScriptOperate --> onCallbackFail");
                f.a();
                f.a(AppContext.a(), "ElfinFloatView onCallbackFail --> ");
                ae.b((Context) AppContext.a(), "runScriptOperate --> 准备工作失败");
                if (aVar != null) {
                    aVar.a();
                }
            }

            public final void a(Object obj) {
                AppContext appContext;
                StringBuilder sb;
                int i;
                ad.c(a.f2021a, "runScriptOperate --> onCallbackSuc");
                ae.b((Context) AppContext.a(), "runScriptOperate --> 准备启动引擎");
                if (aVar != null) {
                    C0028a aVar = aVar;
                    Boolean.valueOf(true);
                    aVar.b();
                }
                String str = (String) obj;
                f.a();
                AppContext a2 = AppContext.a();
                f.a(a2, "ElfinFloatView onCallbackSuc --> data=" + str);
                if (!TextUtils.isEmpty(str)) {
                    ScriptStartRunResponse scriptStartRunResponse = (ScriptStartRunResponse) r.a(str, ScriptStartRunResponse.class);
                    if (scriptStartRunResponse == null || scriptStartRunResponse.Code != 200) {
                        if (scriptStartRunResponse.Code == 1401 || 1400 == scriptStartRunResponse.Code) {
                            com.cyjh.elfin.d.c.a().f1864a = "";
                            com.cyjh.http.e.a.b(com.cyjh.common.b.a.ay + com.cyjh.common.a.a.c(), (Context) AppContext.a());
                        }
                        if (scriptStartRunResponse != null) {
                            ag.b((Context) AppContext.a(), scriptStartRunResponse.Message);
                            f.a();
                            AppContext a3 = AppContext.a();
                            f.a(a3, "ElfinFloatView onCallbackSuc --> " + scriptStartRunResponse.Message);
                            c.a().d();
                        }
                        AppContext a4 = AppContext.a();
                        i = R.string.json_parse_exception;
                        ag.b((Context) a4, (int) R.string.json_parse_exception);
                        f.a();
                        appContext = AppContext.a();
                        sb = new StringBuilder("ElfinFloatView onCallbackSuc --> ");
                    } else {
                        if (!TextUtils.isEmpty(scriptStartRunResponse.Data.ScriptEncryptKey)) {
                            ParamsWrap.getParamsWrap().setScriptEncryptKey(scriptStartRunResponse.Data.ScriptEncryptKey);
                        }
                        if (!TextUtils.isEmpty(scriptStartRunResponse.Data.ExpireTime)) {
                            try {
                                com.cyjh.elfin.d.c.a().f1865b = Long.parseLong(scriptStartRunResponse.Data.ExpireTime);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 1) {
                            f.a();
                            f.a(AppContext.a(), "ElfinFloatView onCallbackSuc --> runScript");
                            b.j();
                            b.c();
                        }
                        c.a().d();
                    }
                } else {
                    AppContext a5 = AppContext.a();
                    i = R.string.json_data_null;
                    ag.b((Context) a5, (int) R.string.json_data_null);
                    f.a();
                    appContext = AppContext.a();
                    sb = new StringBuilder("ElfinFloatView onCallbackFail --> ");
                }
                sb.append(AppContext.a().getString(i));
                f.a(appContext, sb.toString());
                c.a().d();
            }
        };
        a2.a((Context) AppContext.a(), com.cyjh.elfin.d.c.a().b(), com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getId(), com.cyjh.common.b.a.S);
    }
}
