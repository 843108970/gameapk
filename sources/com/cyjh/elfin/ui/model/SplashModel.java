package com.cyjh.elfin.ui.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import b.ac;
import b.f;
import com.core.a.b;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.n;
import com.cyjh.common.util.r;
import com.cyjh.common.util.x;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.e.c.k;
import com.cyjh.elfin.entity.ParamsWrap;
import com.cyjh.elfin.floatingwindowprocess.service.FloatingWindowService;
import com.cyjh.elfin.util.IpcSwap;
import com.cyjh.http.bean.request.BaseRequestValueInfo;
import com.cyjh.http.bean.request.StartAppRequestInfo;
import com.cyjh.http.bean.response.AppRelatedInfo;
import com.cyjh.http.bean.response.AppStartupResponse;
import com.cyjh.http.bean.response.AuthorRelatedInfo;
import com.cyjh.http.bean.response.DomainResult;
import com.cyjh.http.bean.response.PhoneConfig;
import com.cyjh.http.bean.response.ScriptStartRunResponse;
import com.cyjh.http.bean.response.TemplateResponse;
import com.cyjh.http.c.c.a;
import com.cyjh.http.c.c.c;
import com.cyjh.http.e.b;
import com.ywfzjbcy.R;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class SplashModel extends AndroidViewModel {

    /* renamed from: a  reason: collision with root package name */
    public static final int f2292a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f2293b = 19;

    /* renamed from: c  reason: collision with root package name */
    public static final int f2294c = 20;
    public static final int d = 21;
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 3;
    private static final String k = "SplashModel";
    public MutableLiveData<a> i = new MutableLiveData<>();
    public MutableLiveData<PhoneConfig> j = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public long l = 0;
    /* access modifiers changed from: private */
    public long m = 0;
    /* access modifiers changed from: private */
    public int n = 0;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f2302a;

        /* renamed from: b  reason: collision with root package name */
        public String f2303b;

        /* renamed from: c  reason: collision with root package name */
        public int f2304c;

        public a(int i) {
            this.f2302a = i;
        }

        public a(int i, int i2, String str) {
            this.f2302a = i;
            this.f2303b = str;
            this.f2304c = i2;
        }

        public a(int i, String str) {
            this.f2302a = i;
            this.f2303b = str;
        }

        public final String toString() {
            return "AcquireData{code=" + this.f2302a + ", message='" + this.f2303b + '\'' + ", status=" + this.f2304c + '}';
        }
    }

    public SplashModel(@NonNull Application application) {
        super(application);
    }

    static /* synthetic */ int a(SplashModel splashModel) {
        int i2 = splashModel.n;
        splashModel.n = i2 + 1;
        return i2;
    }

    private void a(int i2, String str) {
        TemplateResponse templateResponse;
        while (true) {
            switch (i2) {
                case 19:
                    templateResponse = (TemplateResponse) r.a(str, TemplateResponse.class);
                    if (templateResponse == null) {
                        b(0, "模板无数据");
                        return;
                    } else if (this.l == templateResponse.ClientTimestamp) {
                        com.cyjh.http.b.a.a().e = templateResponse.TemplateType;
                        if (templateResponse.Status == 0 || templateResponse.Status == 2) {
                            this.i.postValue(new a(templateResponse.Status, templateResponse.Remark));
                            break;
                        } else if (templateResponse.Status == 1) {
                            i2 = 21;
                            str = null;
                        } else {
                            b(0, "templateVerifySuccess - fail");
                            return;
                        }
                    } else {
                        a(templateResponse.ClientTimestamp);
                        return;
                    }
                    break;
                case 20:
                    AppStartupResponse appStartupResponse = (AppStartupResponse) r.a(str, AppStartupResponse.class);
                    if (appStartupResponse == null) {
                        b(0, "startupResponse - startup - fail");
                        return;
                    } else if (this.m == appStartupResponse.ClientTimestamp) {
                        AuthorRelatedInfo authorRelatedInfo = appStartupResponse.AuthorInfo;
                        if (authorRelatedInfo.ServicePackStatus == 0) {
                            b(authorRelatedInfo.ServicePackStatus, authorRelatedInfo.ServicePackPrompt);
                            return;
                        }
                        ParamsWrap.getParamsWrap().engineToken = authorRelatedInfo.EngineToken;
                        AppRelatedInfo appRelatedInfo = appStartupResponse.AppInfo;
                        ParamsWrap.getParamsWrap().dailyTryTimes = appRelatedInfo.DailyTryTimes;
                        ParamsWrap.getParamsWrap().feedbackTips = appRelatedInfo.FeedbackTips;
                        ParamsWrap.getParamsWrap().onceTryMinute = appRelatedInfo.OnceTryMinute;
                        ParamsWrap.getParamsWrap().unbindDeductHours = appRelatedInfo.UnbindDeductHours;
                        com.elfin.ad.e.a.a().d = authorRelatedInfo.IsFreeAd;
                        if (!TextUtils.isEmpty(appRelatedInfo.ScriptKey)) {
                            try {
                                long parseLong = Long.parseLong(appRelatedInfo.ScriptKey);
                                AppContext a2 = AppContext.a();
                                Intent intent = new Intent(a2, FloatingWindowService.class);
                                intent.putExtra(b.g, 202);
                                intent.putExtra("tokenKey", parseLong);
                                if (Build.VERSION.SDK_INT >= 26) {
                                    a2.startForegroundService(intent);
                                } else {
                                    a2.startService(intent);
                                }
                            } catch (NumberFormatException e2) {
                                e2.printStackTrace();
                            }
                        }
                        ParamsWrap.getParamsWrap().crateCollect();
                        if (appRelatedInfo.BuyRegCodeConfig != null) {
                            ParamsWrap.getParamsWrap().mBuyRegCodeConfigInfos.addAll(appRelatedInfo.BuyRegCodeConfig);
                        }
                        if (appRelatedInfo.FlySetting != null) {
                            com.elfin.ad.e.a.a().f2864c.addAll(appRelatedInfo.FlySetting);
                        }
                        if (appRelatedInfo.RecommendSetting != null) {
                            ParamsWrap.getParamsWrap().mRecommendSettingInfos.addAll(appRelatedInfo.RecommendSetting);
                        }
                        if (authorRelatedInfo.AdList != null) {
                            com.elfin.ad.e.a.a().f2862a.addAll(authorRelatedInfo.AdList);
                        }
                        if (authorRelatedInfo.ServicePackStatus == 1) {
                            c a3 = c.a();
                            a3.f2487c = new c.b() {
                                public final void a() {
                                    SplashModel.this.i.postValue(new a(1));
                                }

                                public final void a(Object obj) {
                                    ad.c(SplashModel.k, "runScriptOperate --> onCallbackSuc");
                                    String str = (String) obj;
                                    if (!TextUtils.isEmpty(str)) {
                                        ScriptStartRunResponse scriptStartRunResponse = (ScriptStartRunResponse) r.a(str, ScriptStartRunResponse.class);
                                        if (scriptStartRunResponse != null && !TextUtils.isEmpty(scriptStartRunResponse.Data.ScriptEncryptKey)) {
                                            ParamsWrap.getParamsWrap().setScriptEncryptKey(scriptStartRunResponse.Data.ScriptEncryptKey);
                                            k.a(scriptStartRunResponse.Data.ScriptEncryptKey);
                                            com.cyjh.elfin.floatingwindowprocess.c.c.f().a();
                                        }
                                        SplashModel.this.i.postValue(new a(1));
                                    }
                                    c.a().d();
                                }
                            };
                            a3.a((Context) AppContext.a(), com.cyjh.elfin.d.c.a().b(), com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getId(), com.cyjh.common.b.a.S);
                            return;
                        } else if (authorRelatedInfo.ServicePackStatus == 2) {
                            this.i.postValue(new a(3, authorRelatedInfo.ServicePackStatus, authorRelatedInfo.ServicePackPrompt));
                            return;
                        } else {
                            return;
                        }
                    } else {
                        a(appStartupResponse.ClientTimestamp);
                        return;
                    }
                case 21:
                    com.cyjh.feedback.lib.d.b.a().a(new Runnable() {
                        public final void run() {
                            try {
                                BaseRequestValueInfo b2 = com.cyjh.http.b.a.a().b(SplashModel.this.getApplication());
                                long unused = SplashModel.this.m = com.cyjh.http.b.a.f2475b;
                                StartAppRequestInfo startAppRequestInfo = new StartAppRequestInfo(b2);
                                startAppRequestInfo.CloudPhoneType = com.cyjh.http.a.c.a().e;
                                SplashModel.a(SplashModel.this, IpcSwap.startAppReq(r.a((Object) startAppRequestInfo)), 20);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    return;
                default:
                    return;
            }
        }
        this.i.postValue(new a(templateResponse.Status, templateResponse.Remark));
    }

    private void a(long j2) {
        if (this.l != j2 && this.l != 0) {
            b(0, getApplication().getString(R.string.check_sign_fail));
        }
    }

    static /* synthetic */ void a(SplashModel splashModel, final PhoneConfig phoneConfig) {
        String imageUrl = phoneConfig.getImageUrl();
        final String str = splashModel.getApplication().getCacheDir() + File.separator + n.b(phoneConfig.getImageUrl());
        ad.c(k, "ddyGuideImagePreLoad --> imageUrl=" + phoneConfig.getImageUrl());
        com.cyjh.http.e.b a2 = com.cyjh.http.e.b.a();
        String absolutePath = splashModel.getApplication().getCacheDir().getAbsolutePath();
        String b2 = n.b(phoneConfig.getImageUrl());
        AnonymousClass2 r5 = new b.a() {
            public final void a(int i) {
            }

            public final void a(File file) {
                ad.c(SplashModel.k, "ddyGuideImagePreLoad --> onDownloadSuccess --> file=" + file.getAbsolutePath());
                r8.setImageUrl(r1);
                SplashModel.this.j.postValue(r8);
            }

            public final void a(Exception exc) {
                ad.c(SplashModel.k, "ddyGuideImagePreLoad --> onDownloadFailed --> ex=" + exc.getMessage());
                SplashModel.this.j.postValue(null);
            }
        };
        ad.c(com.cyjh.http.e.b.f2524a, "download 1 --> destFileDir=" + absolutePath + ",destFileName=" + b2);
        a2.f2526c = a2.f2525b.a(new ac.a().a(imageUrl).d());
        a2.f2526c.a(new f(r5, absolutePath, b2) {
            /* JADX WARNING: Removed duplicated region for block: B:33:0x00a5 A[SYNTHETIC, Splitter:B:33:0x00a5] */
            /* JADX WARNING: Removed duplicated region for block: B:36:0x00aa A[Catch:{ IOException -> 0x00c8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:42:0x00cd A[SYNTHETIC, Splitter:B:42:0x00cd] */
            /* JADX WARNING: Removed duplicated region for block: B:45:0x00d2 A[Catch:{ IOException -> 0x00f0 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(b.e r12, b.ae r13) throws java.io.IOException {
                /*
                    r11 = this;
                    r12 = 2048(0x800, float:2.87E-42)
                    byte[] r12 = new byte[r12]
                    java.io.File r0 = new java.io.File
                    java.lang.String r1 = r5
                    r0.<init>(r1)
                    boolean r1 = r0.exists()
                    if (r1 != 0) goto L_0x0014
                    r0.mkdirs()
                L_0x0014:
                    java.io.File r1 = new java.io.File
                    java.lang.String r2 = r6
                    r1.<init>(r0, r2)
                    r0 = 0
                    b.af r2 = r13.g     // Catch:{ Exception -> 0x009c, all -> 0x0098 }
                    java.io.InputStream r2 = r2.byteStream()     // Catch:{ Exception -> 0x009c, all -> 0x0098 }
                    b.af r13 = r13.g     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                    long r3 = r13.contentLength()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                    java.io.FileOutputStream r13 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                    r13.<init>(r1)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                    r5 = 0
                L_0x002f:
                    int r0 = r2.read(r12)     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    r7 = -1
                    r8 = 0
                    if (r0 == r7) goto L_0x005c
                    r13.write(r12, r8, r0)     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    long r7 = (long) r0     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    long r9 = r5 + r7
                    com.cyjh.http.e.b r5 = com.cyjh.http.e.b.this     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    com.cyjh.http.e.b r6 = com.cyjh.http.e.b.this     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    int r6 = r6.f     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    int r6 = r6 + r0
                    int unused = r5.f = r6     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    float r0 = (float) r9     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    r5 = 1065353216(0x3f800000, float:1.0)
                    float r0 = r0 * r5
                    float r5 = (float) r3     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    float r0 = r0 / r5
                    r5 = 1120403456(0x42c80000, float:100.0)
                    float r0 = r0 * r5
                    int r0 = (int) r0     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    com.cyjh.http.e.b$a r5 = r7     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    r5.a((int) r0)     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    r5 = r9
                    goto L_0x002f
                L_0x005c:
                    r13.flush()     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    com.cyjh.http.e.b$a r12 = r7     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    r12.a((java.io.File) r1)     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    com.cyjh.http.e.b r12 = com.cyjh.http.e.b.this     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    int unused = r12.f = r8     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    if (r2 == 0) goto L_0x006e
                    r2.close()     // Catch:{ IOException -> 0x008c }
                L_0x006e:
                    r13.close()     // Catch:{ IOException -> 0x008c }
                    java.lang.String r12 = com.cyjh.http.e.b.f2524a     // Catch:{ IOException -> 0x008c }
                    java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x008c }
                    java.lang.String r0 = "download 3 --> downLoadLength="
                    r13.<init>(r0)     // Catch:{ IOException -> 0x008c }
                    com.cyjh.http.e.b r0 = com.cyjh.http.e.b.this     // Catch:{ IOException -> 0x008c }
                    int r0 = r0.f     // Catch:{ IOException -> 0x008c }
                    r13.append(r0)     // Catch:{ IOException -> 0x008c }
                    java.lang.String r13 = r13.toString()     // Catch:{ IOException -> 0x008c }
                    com.cyjh.common.util.ad.c(r12, r13)     // Catch:{ IOException -> 0x008c }
                L_0x008c:
                    return
                L_0x008d:
                    r12 = move-exception
                    goto L_0x00cb
                L_0x008f:
                    r12 = move-exception
                    goto L_0x0096
                L_0x0091:
                    r12 = move-exception
                    r13 = r0
                    goto L_0x00cb
                L_0x0094:
                    r12 = move-exception
                    r13 = r0
                L_0x0096:
                    r0 = r2
                    goto L_0x009e
                L_0x0098:
                    r12 = move-exception
                    r13 = r0
                    r2 = r13
                    goto L_0x00cb
                L_0x009c:
                    r12 = move-exception
                    r13 = r0
                L_0x009e:
                    com.cyjh.http.e.b$a r1 = r7     // Catch:{ all -> 0x00c9 }
                    r1.a((java.lang.Exception) r12)     // Catch:{ all -> 0x00c9 }
                    if (r0 == 0) goto L_0x00a8
                    r0.close()     // Catch:{ IOException -> 0x00c8 }
                L_0x00a8:
                    if (r13 == 0) goto L_0x00ad
                    r13.close()     // Catch:{ IOException -> 0x00c8 }
                L_0x00ad:
                    java.lang.String r12 = com.cyjh.http.e.b.f2524a     // Catch:{ IOException -> 0x00c8 }
                    java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c8 }
                    java.lang.String r0 = "download 3 --> downLoadLength="
                    r13.<init>(r0)     // Catch:{ IOException -> 0x00c8 }
                    com.cyjh.http.e.b r0 = com.cyjh.http.e.b.this     // Catch:{ IOException -> 0x00c8 }
                    int r0 = r0.f     // Catch:{ IOException -> 0x00c8 }
                    r13.append(r0)     // Catch:{ IOException -> 0x00c8 }
                    java.lang.String r13 = r13.toString()     // Catch:{ IOException -> 0x00c8 }
                    com.cyjh.common.util.ad.c(r12, r13)     // Catch:{ IOException -> 0x00c8 }
                L_0x00c8:
                    return
                L_0x00c9:
                    r12 = move-exception
                    r2 = r0
                L_0x00cb:
                    if (r2 == 0) goto L_0x00d0
                    r2.close()     // Catch:{ IOException -> 0x00f0 }
                L_0x00d0:
                    if (r13 == 0) goto L_0x00d5
                    r13.close()     // Catch:{ IOException -> 0x00f0 }
                L_0x00d5:
                    java.lang.String r13 = com.cyjh.http.e.b.f2524a     // Catch:{ IOException -> 0x00f0 }
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00f0 }
                    java.lang.String r1 = "download 3 --> downLoadLength="
                    r0.<init>(r1)     // Catch:{ IOException -> 0x00f0 }
                    com.cyjh.http.e.b r1 = com.cyjh.http.e.b.this     // Catch:{ IOException -> 0x00f0 }
                    int r1 = r1.f     // Catch:{ IOException -> 0x00f0 }
                    r0.append(r1)     // Catch:{ IOException -> 0x00f0 }
                    java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x00f0 }
                    com.cyjh.common.util.ad.c(r13, r0)     // Catch:{ IOException -> 0x00f0 }
                L_0x00f0:
                    throw r12
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cyjh.http.e.b.AnonymousClass1.a(b.e, b.ae):void");
            }

            public final void a(IOException iOException) {
                r7.a((Exception) iOException);
            }
        });
    }

    static /* synthetic */ void a(SplashModel splashModel, String str, int i2) throws JSONException {
        ad.c(k, "parseJson --> templateResponse=" + str + ",messageNotify=" + i2);
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("Data");
            int i3 = jSONObject.getInt("Code");
            String string = jSONObject.getString(com.cyjh.elfin.a.b.d);
            if ((i3 != 200 || TextUtils.isEmpty(jSONObject2.toString())) && (i3 == 1100 || i3 == 1200 || i3 == 1300 || i3 == 604 || i3 == 602)) {
                splashModel.b(0, string);
            } else {
                splashModel.a(i2, jSONObject2.toString());
            }
        } else {
            splashModel.i.postValue(null);
        }
    }

    private void a(AppStartupResponse appStartupResponse) {
        AuthorRelatedInfo authorRelatedInfo = appStartupResponse.AuthorInfo;
        if (authorRelatedInfo.ServicePackStatus == 0) {
            b(authorRelatedInfo.ServicePackStatus, authorRelatedInfo.ServicePackPrompt);
            return;
        }
        ParamsWrap.getParamsWrap().engineToken = authorRelatedInfo.EngineToken;
        AppRelatedInfo appRelatedInfo = appStartupResponse.AppInfo;
        ParamsWrap.getParamsWrap().dailyTryTimes = appRelatedInfo.DailyTryTimes;
        ParamsWrap.getParamsWrap().feedbackTips = appRelatedInfo.FeedbackTips;
        ParamsWrap.getParamsWrap().onceTryMinute = appRelatedInfo.OnceTryMinute;
        ParamsWrap.getParamsWrap().unbindDeductHours = appRelatedInfo.UnbindDeductHours;
        com.elfin.ad.e.a.a().d = authorRelatedInfo.IsFreeAd;
        if (!TextUtils.isEmpty(appRelatedInfo.ScriptKey)) {
            try {
                long parseLong = Long.parseLong(appRelatedInfo.ScriptKey);
                AppContext a2 = AppContext.a();
                Intent intent = new Intent(a2, FloatingWindowService.class);
                intent.putExtra(com.core.a.b.g, 202);
                intent.putExtra("tokenKey", parseLong);
                if (Build.VERSION.SDK_INT >= 26) {
                    a2.startForegroundService(intent);
                } else {
                    a2.startService(intent);
                }
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        }
        ParamsWrap.getParamsWrap().crateCollect();
        if (appRelatedInfo.BuyRegCodeConfig != null) {
            ParamsWrap.getParamsWrap().mBuyRegCodeConfigInfos.addAll(appRelatedInfo.BuyRegCodeConfig);
        }
        if (appRelatedInfo.FlySetting != null) {
            com.elfin.ad.e.a.a().f2864c.addAll(appRelatedInfo.FlySetting);
        }
        if (appRelatedInfo.RecommendSetting != null) {
            ParamsWrap.getParamsWrap().mRecommendSettingInfos.addAll(appRelatedInfo.RecommendSetting);
        }
        if (authorRelatedInfo.AdList != null) {
            com.elfin.ad.e.a.a().f2862a.addAll(authorRelatedInfo.AdList);
        }
        if (authorRelatedInfo.ServicePackStatus == 1) {
            c a3 = c.a();
            a3.f2487c = new c.b() {
                public final void a() {
                    SplashModel.this.i.postValue(new a(1));
                }

                public final void a(Object obj) {
                    ad.c(SplashModel.k, "runScriptOperate --> onCallbackSuc");
                    String str = (String) obj;
                    if (!TextUtils.isEmpty(str)) {
                        ScriptStartRunResponse scriptStartRunResponse = (ScriptStartRunResponse) r.a(str, ScriptStartRunResponse.class);
                        if (scriptStartRunResponse != null && !TextUtils.isEmpty(scriptStartRunResponse.Data.ScriptEncryptKey)) {
                            ParamsWrap.getParamsWrap().setScriptEncryptKey(scriptStartRunResponse.Data.ScriptEncryptKey);
                            k.a(scriptStartRunResponse.Data.ScriptEncryptKey);
                            com.cyjh.elfin.floatingwindowprocess.c.c.f().a();
                        }
                        SplashModel.this.i.postValue(new a(1));
                    }
                    c.a().d();
                }
            };
            a3.a((Context) AppContext.a(), com.cyjh.elfin.d.c.a().b(), com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getId(), com.cyjh.common.b.a.S);
        } else if (authorRelatedInfo.ServicePackStatus == 2) {
            this.i.postValue(new a(3, authorRelatedInfo.ServicePackStatus, authorRelatedInfo.ServicePackPrompt));
        }
    }

    private void a(final PhoneConfig phoneConfig) {
        String imageUrl = phoneConfig.getImageUrl();
        final String str = getApplication().getCacheDir() + File.separator + n.b(phoneConfig.getImageUrl());
        ad.c(k, "ddyGuideImagePreLoad --> imageUrl=" + phoneConfig.getImageUrl());
        com.cyjh.http.e.b a2 = com.cyjh.http.e.b.a();
        String absolutePath = getApplication().getCacheDir().getAbsolutePath();
        String b2 = n.b(phoneConfig.getImageUrl());
        AnonymousClass2 r5 = new b.a() {
            public final void a(int i) {
            }

            public final void a(File file) {
                ad.c(SplashModel.k, "ddyGuideImagePreLoad --> onDownloadSuccess --> file=" + file.getAbsolutePath());
                phoneConfig.setImageUrl(str);
                SplashModel.this.j.postValue(phoneConfig);
            }

            public final void a(Exception exc) {
                ad.c(SplashModel.k, "ddyGuideImagePreLoad --> onDownloadFailed --> ex=" + exc.getMessage());
                SplashModel.this.j.postValue(null);
            }
        };
        ad.c(com.cyjh.http.e.b.f2524a, "download 1 --> destFileDir=" + absolutePath + ",destFileName=" + b2);
        a2.f2526c = a2.f2525b.a(new ac.a().a(imageUrl).d());
        a2.f2526c.a(new f(r5, absolutePath, b2) {
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(b.e r12, b.ae r13) {
                /*
                    r11 = this;
                    r12 = 2048(0x800, float:2.87E-42)
                    byte[] r12 = new byte[r12]
                    java.io.File r0 = new java.io.File
                    java.lang.String r1 = r5
                    r0.<init>(r1)
                    boolean r1 = r0.exists()
                    if (r1 != 0) goto L_0x0014
                    r0.mkdirs()
                L_0x0014:
                    java.io.File r1 = new java.io.File
                    java.lang.String r2 = r6
                    r1.<init>(r0, r2)
                    r0 = 0
                    b.af r2 = r13.g     // Catch:{ Exception -> 0x009c, all -> 0x0098 }
                    java.io.InputStream r2 = r2.byteStream()     // Catch:{ Exception -> 0x009c, all -> 0x0098 }
                    b.af r13 = r13.g     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                    long r3 = r13.contentLength()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                    java.io.FileOutputStream r13 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                    r13.<init>(r1)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                    r5 = 0
                L_0x002f:
                    int r0 = r2.read(r12)     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    r7 = -1
                    r8 = 0
                    if (r0 == r7) goto L_0x005c
                    r13.write(r12, r8, r0)     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    long r7 = (long) r0     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    long r9 = r5 + r7
                    com.cyjh.http.e.b r5 = com.cyjh.http.e.b.this     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    com.cyjh.http.e.b r6 = com.cyjh.http.e.b.this     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    int r6 = r6.f     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    int r6 = r6 + r0
                    int unused = r5.f = r6     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    float r0 = (float) r9     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    r5 = 1065353216(0x3f800000, float:1.0)
                    float r0 = r0 * r5
                    float r5 = (float) r3     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    float r0 = r0 / r5
                    r5 = 1120403456(0x42c80000, float:100.0)
                    float r0 = r0 * r5
                    int r0 = (int) r0     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    com.cyjh.http.e.b$a r5 = r7     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    r5.a((int) r0)     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    r5 = r9
                    goto L_0x002f
                L_0x005c:
                    r13.flush()     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    com.cyjh.http.e.b$a r12 = r7     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    r12.a((java.io.File) r1)     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    com.cyjh.http.e.b r12 = com.cyjh.http.e.b.this     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    int unused = r12.f = r8     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    if (r2 == 0) goto L_0x006e
                    r2.close()     // Catch:{ IOException -> 0x008c }
                L_0x006e:
                    r13.close()     // Catch:{ IOException -> 0x008c }
                    java.lang.String r12 = com.cyjh.http.e.b.f2524a     // Catch:{ IOException -> 0x008c }
                    java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x008c }
                    java.lang.String r0 = "download 3 --> downLoadLength="
                    r13.<init>(r0)     // Catch:{ IOException -> 0x008c }
                    com.cyjh.http.e.b r0 = com.cyjh.http.e.b.this     // Catch:{ IOException -> 0x008c }
                    int r0 = r0.f     // Catch:{ IOException -> 0x008c }
                    r13.append(r0)     // Catch:{ IOException -> 0x008c }
                    java.lang.String r13 = r13.toString()     // Catch:{ IOException -> 0x008c }
                    com.cyjh.common.util.ad.c(r12, r13)     // Catch:{ IOException -> 0x008c }
                L_0x008c:
                    return
                L_0x008d:
                    r12 = move-exception
                    goto L_0x00cb
                L_0x008f:
                    r12 = move-exception
                    goto L_0x0096
                L_0x0091:
                    r12 = move-exception
                    r13 = r0
                    goto L_0x00cb
                L_0x0094:
                    r12 = move-exception
                    r13 = r0
                L_0x0096:
                    r0 = r2
                    goto L_0x009e
                L_0x0098:
                    r12 = move-exception
                    r13 = r0
                    r2 = r13
                    goto L_0x00cb
                L_0x009c:
                    r12 = move-exception
                    r13 = r0
                L_0x009e:
                    com.cyjh.http.e.b$a r1 = r7     // Catch:{ all -> 0x00c9 }
                    r1.a((java.lang.Exception) r12)     // Catch:{ all -> 0x00c9 }
                    if (r0 == 0) goto L_0x00a8
                    r0.close()     // Catch:{ IOException -> 0x00c8 }
                L_0x00a8:
                    if (r13 == 0) goto L_0x00ad
                    r13.close()     // Catch:{ IOException -> 0x00c8 }
                L_0x00ad:
                    java.lang.String r12 = com.cyjh.http.e.b.f2524a     // Catch:{ IOException -> 0x00c8 }
                    java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c8 }
                    java.lang.String r0 = "download 3 --> downLoadLength="
                    r13.<init>(r0)     // Catch:{ IOException -> 0x00c8 }
                    com.cyjh.http.e.b r0 = com.cyjh.http.e.b.this     // Catch:{ IOException -> 0x00c8 }
                    int r0 = r0.f     // Catch:{ IOException -> 0x00c8 }
                    r13.append(r0)     // Catch:{ IOException -> 0x00c8 }
                    java.lang.String r13 = r13.toString()     // Catch:{ IOException -> 0x00c8 }
                    com.cyjh.common.util.ad.c(r12, r13)     // Catch:{ IOException -> 0x00c8 }
                L_0x00c8:
                    return
                L_0x00c9:
                    r12 = move-exception
                    r2 = r0
                L_0x00cb:
                    if (r2 == 0) goto L_0x00d0
                    r2.close()     // Catch:{ IOException -> 0x00f0 }
                L_0x00d0:
                    if (r13 == 0) goto L_0x00d5
                    r13.close()     // Catch:{ IOException -> 0x00f0 }
                L_0x00d5:
                    java.lang.String r13 = com.cyjh.http.e.b.f2524a     // Catch:{ IOException -> 0x00f0 }
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00f0 }
                    java.lang.String r1 = "download 3 --> downLoadLength="
                    r0.<init>(r1)     // Catch:{ IOException -> 0x00f0 }
                    com.cyjh.http.e.b r1 = com.cyjh.http.e.b.this     // Catch:{ IOException -> 0x00f0 }
                    int r1 = r1.f     // Catch:{ IOException -> 0x00f0 }
                    r0.append(r1)     // Catch:{ IOException -> 0x00f0 }
                    java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x00f0 }
                    com.cyjh.common.util.ad.c(r13, r0)     // Catch:{ IOException -> 0x00f0 }
                L_0x00f0:
                    throw r12
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cyjh.http.e.b.AnonymousClass1.a(b.e, b.ae):void");
            }

            public final void a(IOException iOException) {
                r7.a((Exception) iOException);
            }
        });
    }

    private void a(TemplateResponse templateResponse) {
        com.cyjh.http.b.a.a().e = templateResponse.TemplateType;
        if (templateResponse.Status == 0 || templateResponse.Status == 2) {
            this.i.postValue(new a(templateResponse.Status, templateResponse.Remark));
        } else if (templateResponse.Status == 1) {
            a(21, (String) null);
        } else {
            b(0, "templateVerifySuccess - fail");
        }
    }

    private void a(String str) {
        TemplateResponse templateResponse = (TemplateResponse) r.a(str, TemplateResponse.class);
        if (templateResponse == null) {
            b(0, "模板无数据");
        } else if (this.l == templateResponse.ClientTimestamp) {
            com.cyjh.http.b.a.a().e = templateResponse.TemplateType;
            if (templateResponse.Status == 0 || templateResponse.Status == 2) {
                this.i.postValue(new a(templateResponse.Status, templateResponse.Remark));
            } else if (templateResponse.Status == 1) {
                a(21, (String) null);
            } else {
                b(0, "templateVerifySuccess - fail");
            }
        } else {
            a(templateResponse.ClientTimestamp);
        }
    }

    private void a(String str, int i2) throws JSONException {
        ad.c(k, "parseJson --> templateResponse=" + str + ",messageNotify=" + i2);
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("Data");
            int i3 = jSONObject.getInt("Code");
            String string = jSONObject.getString(com.cyjh.elfin.a.b.d);
            if ((i3 != 200 || TextUtils.isEmpty(jSONObject2.toString())) && (i3 == 1100 || i3 == 1200 || i3 == 1300 || i3 == 604 || i3 == 602)) {
                b(0, string);
            } else {
                a(i2, jSONObject2.toString());
            }
        } else {
            this.i.postValue(null);
        }
    }

    /* access modifiers changed from: private */
    public void b(int i2, String str) {
        this.i.postValue(new a(0, i2, str));
    }

    private void b(String str) {
        AppStartupResponse appStartupResponse = (AppStartupResponse) r.a(str, AppStartupResponse.class);
        if (appStartupResponse == null) {
            b(0, "startupResponse - startup - fail");
        } else if (this.m == appStartupResponse.ClientTimestamp) {
            AuthorRelatedInfo authorRelatedInfo = appStartupResponse.AuthorInfo;
            if (authorRelatedInfo.ServicePackStatus == 0) {
                b(authorRelatedInfo.ServicePackStatus, authorRelatedInfo.ServicePackPrompt);
                return;
            }
            ParamsWrap.getParamsWrap().engineToken = authorRelatedInfo.EngineToken;
            AppRelatedInfo appRelatedInfo = appStartupResponse.AppInfo;
            ParamsWrap.getParamsWrap().dailyTryTimes = appRelatedInfo.DailyTryTimes;
            ParamsWrap.getParamsWrap().feedbackTips = appRelatedInfo.FeedbackTips;
            ParamsWrap.getParamsWrap().onceTryMinute = appRelatedInfo.OnceTryMinute;
            ParamsWrap.getParamsWrap().unbindDeductHours = appRelatedInfo.UnbindDeductHours;
            com.elfin.ad.e.a.a().d = authorRelatedInfo.IsFreeAd;
            if (!TextUtils.isEmpty(appRelatedInfo.ScriptKey)) {
                try {
                    long parseLong = Long.parseLong(appRelatedInfo.ScriptKey);
                    AppContext a2 = AppContext.a();
                    Intent intent = new Intent(a2, FloatingWindowService.class);
                    intent.putExtra(com.core.a.b.g, 202);
                    intent.putExtra("tokenKey", parseLong);
                    if (Build.VERSION.SDK_INT >= 26) {
                        a2.startForegroundService(intent);
                    } else {
                        a2.startService(intent);
                    }
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            ParamsWrap.getParamsWrap().crateCollect();
            if (appRelatedInfo.BuyRegCodeConfig != null) {
                ParamsWrap.getParamsWrap().mBuyRegCodeConfigInfos.addAll(appRelatedInfo.BuyRegCodeConfig);
            }
            if (appRelatedInfo.FlySetting != null) {
                com.elfin.ad.e.a.a().f2864c.addAll(appRelatedInfo.FlySetting);
            }
            if (appRelatedInfo.RecommendSetting != null) {
                ParamsWrap.getParamsWrap().mRecommendSettingInfos.addAll(appRelatedInfo.RecommendSetting);
            }
            if (authorRelatedInfo.AdList != null) {
                com.elfin.ad.e.a.a().f2862a.addAll(authorRelatedInfo.AdList);
            }
            if (authorRelatedInfo.ServicePackStatus == 1) {
                c a3 = c.a();
                a3.f2487c = new c.b() {
                    public final void a() {
                        SplashModel.this.i.postValue(new a(1));
                    }

                    public final void a(Object obj) {
                        ad.c(SplashModel.k, "runScriptOperate --> onCallbackSuc");
                        String str = (String) obj;
                        if (!TextUtils.isEmpty(str)) {
                            ScriptStartRunResponse scriptStartRunResponse = (ScriptStartRunResponse) r.a(str, ScriptStartRunResponse.class);
                            if (scriptStartRunResponse != null && !TextUtils.isEmpty(scriptStartRunResponse.Data.ScriptEncryptKey)) {
                                ParamsWrap.getParamsWrap().setScriptEncryptKey(scriptStartRunResponse.Data.ScriptEncryptKey);
                                k.a(scriptStartRunResponse.Data.ScriptEncryptKey);
                                com.cyjh.elfin.floatingwindowprocess.c.c.f().a();
                            }
                            SplashModel.this.i.postValue(new a(1));
                        }
                        c.a().d();
                    }
                };
                a3.a((Context) AppContext.a(), com.cyjh.elfin.d.c.a().b(), com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getId(), com.cyjh.common.b.a.S);
            } else if (authorRelatedInfo.ServicePackStatus == 2) {
                this.i.postValue(new a(3, authorRelatedInfo.ServicePackStatus, authorRelatedInfo.ServicePackPrompt));
            }
        } else {
            a(appStartupResponse.ClientTimestamp);
        }
    }

    private LiveData<a> c() {
        return this.i;
    }

    private MutableLiveData<PhoneConfig> d() {
        return this.j;
    }

    private void e() {
        if (x.a(getApplication())) {
            a();
        } else {
            this.i.postValue(new a(-1));
        }
    }

    private void f() {
        c a2 = c.a();
        a2.f2487c = new c.b() {
            public final void a() {
                SplashModel.this.i.postValue(new a(1));
            }

            public final void a(Object obj) {
                ad.c(SplashModel.k, "runScriptOperate --> onCallbackSuc");
                String str = (String) obj;
                if (!TextUtils.isEmpty(str)) {
                    ScriptStartRunResponse scriptStartRunResponse = (ScriptStartRunResponse) r.a(str, ScriptStartRunResponse.class);
                    if (scriptStartRunResponse != null && !TextUtils.isEmpty(scriptStartRunResponse.Data.ScriptEncryptKey)) {
                        ParamsWrap.getParamsWrap().setScriptEncryptKey(scriptStartRunResponse.Data.ScriptEncryptKey);
                        k.a(scriptStartRunResponse.Data.ScriptEncryptKey);
                        com.cyjh.elfin.floatingwindowprocess.c.c.f().a();
                    }
                    SplashModel.this.i.postValue(new a(1));
                }
                c.a().d();
            }
        };
        a2.a((Context) AppContext.a(), com.cyjh.elfin.d.c.a().b(), com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getId(), com.cyjh.common.b.a.S);
    }

    private void g() {
        com.cyjh.feedback.lib.d.b.a().a(new Runnable() {
            public final void run() {
                try {
                    BaseRequestValueInfo b2 = com.cyjh.http.b.a.a().b(SplashModel.this.getApplication());
                    long unused = SplashModel.this.m = com.cyjh.http.b.a.f2475b;
                    StartAppRequestInfo startAppRequestInfo = new StartAppRequestInfo(b2);
                    startAppRequestInfo.CloudPhoneType = com.cyjh.http.a.c.a().e;
                    SplashModel.a(SplashModel.this, IpcSwap.startAppReq(r.a((Object) startAppRequestInfo)), 20);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void h() {
    }

    public final void a() {
        com.cyjh.http.c.c.a.a().a(getApplication(), this.n, new a.C0040a() {
            public final void a(int i, String str) {
                ad.c(SplashModel.k, "getDomainNameFirst onFailure-->  code=" + i + ",message=" + str);
                com.cyjh.http.c.c.a.a().f2483b = null;
                if (i == 1100 || i == 1200 || i == 1300 || i == 604 || i == 602) {
                    SplashModel.this.b(0, str);
                    return;
                }
                SplashModel.a(SplashModel.this);
                if (SplashModel.this.n < 2) {
                    SplashModel.this.a();
                } else {
                    SplashModel.this.b();
                }
            }

            public final void a(DomainResult domainResult) {
                ad.c(SplashModel.k, "getDomainNameFirst --> onSuccess domainName=" + domainResult.getAppDomainName() + ",domain2Name=" + domainResult.getApp2DomainName());
                com.cyjh.common.a.a.f1619b = domainResult.getApiVersionV();
                com.cyjh.common.a.a.d = domainResult.getApiDescKeys();
                com.cyjh.common.a.a.f1620c = domainResult.getAuthDescKeys();
                com.cyjh.elfin.a.c.f1844a = domainResult.getAppDomainName();
                com.cyjh.elfin.a.c.f1845b = domainResult.getAppDomainName();
                com.cyjh.elfin.a.c.f = domainResult.getAppDomainName();
                com.cyjh.common.a.a.a(domainResult.getAppDomainName());
                com.cyjh.common.a.a.c(domainResult.getApp2DomainName());
                com.cyjh.common.a.a.d(domainResult.getAppDomainName());
                String str = com.cyjh.common.a.a.f1619b;
                String[] strArr = com.cyjh.common.a.a.f1620c;
                AppContext a2 = AppContext.a();
                Intent intent = new Intent(a2, FloatingWindowService.class);
                intent.putExtra(com.core.a.b.g, 2);
                Bundle bundle = new Bundle();
                bundle.putInt(FloatingWindowService.k, 0);
                bundle.putString(FloatingWindowService.o, com.cyjh.common.a.a.h());
                bundle.putString(FloatingWindowService.j, str);
                bundle.putStringArray(FloatingWindowService.p, strArr);
                intent.putExtra(FloatingWindowService.i, bundle);
                if (Build.VERSION.SDK_INT >= 26) {
                    a2.startForegroundService(intent);
                } else {
                    a2.startService(intent);
                }
                PhoneConfig a3 = com.cyjh.http.a.c.a().a(SplashModel.this.getApplication(), domainResult.getPhoneConfig());
                if (a3 != null) {
                    SplashModel.a(SplashModel.this, a3);
                    return;
                }
                com.cyjh.http.c.c.a.a().f2483b = null;
                SplashModel.this.b();
            }
        });
    }

    public final void b() {
        if (x.a(getApplication())) {
            ad.c(k, "初始化参数，checkTemplateReq验证模版，需要初始化参数");
            com.cyjh.elfin.floatingwindowprocess.d.b.j();
            String e2 = com.cyjh.elfin.floatingwindowprocess.c.c.f().e();
            com.cyjh.elfin.floatingwindowprocess.c.c.f();
            String c2 = com.cyjh.elfin.floatingwindowprocess.c.c.c();
            com.cyjh.elfin.floatingwindowprocess.c.c.f();
            com.cyjh.elfin.floatingwindowprocess.d.b.a(e2, c2, com.cyjh.elfin.floatingwindowprocess.c.c.d());
            com.cyjh.feedback.lib.d.b.a().a(new Runnable() {
                public final void run() {
                    try {
                        BaseRequestValueInfo b2 = com.cyjh.http.b.a.a().b(SplashModel.this.getApplication());
                        long unused = SplashModel.this.l = com.cyjh.http.b.a.f2475b;
                        String a2 = r.a((Object) b2);
                        ad.c(SplashModel.k, "acquireAppData --> jsonParams=" + a2);
                        SplashModel.a(SplashModel.this, IpcSwap.checkTemplateReq(a2), 19);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e("zzz", "SplashActivity---initAfter()---4" + e.getMessage());
                    }
                }
            });
            return;
        }
        this.i.postValue(new a(-1));
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
    }
}
