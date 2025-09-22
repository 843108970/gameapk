package com.cyjh.elfin.ui.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.cyjh.common.util.ab;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.ag;
import com.cyjh.common.util.e;
import com.cyjh.common.util.r;
import com.cyjh.common.util.x;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.e.c.l;
import com.cyjh.feedback.lib.d.b;
import com.cyjh.http.bean.NotifyMsgBean;
import com.cyjh.http.bean.request.UpdateRequestInfo;
import com.cyjh.http.bean.response.RegCodeStatusInfo;
import com.cyjh.http.bean.response.VersionUpdateInfo;
import com.cyjh.http.c.b.a;
import com.cyjh.http.c.c.c;
import com.cyjh.http.c.c.m;
import com.cyjh.http.c.d.f;
import com.cyjh.http.e.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.litepal.g.b;

public class ElfinModel extends AndroidViewModel implements f {

    /* renamed from: a  reason: collision with root package name */
    public static final int f2269a = 1006;

    /* renamed from: b  reason: collision with root package name */
    public static final int f2270b = 1007;

    /* renamed from: c  reason: collision with root package name */
    public static final int f2271c = 1008;
    private static final String i = "ElfinModel";
    public ArrayList<NotifyMsgBean> d = new ArrayList<>();
    public MutableLiveData<VersionUpdateInfo> e = new MutableLiveData<>();
    public MutableLiveData<NotifyMsgBean> f = new MutableLiveData<>();
    public MutableLiveData<Integer> g = new MutableLiveData<>();
    public MutableLiveData<Boolean> h = new MutableLiveData<>();
    private ArrayList<NotifyMsgBean> j = new ArrayList<>();
    private List<String> k = new ArrayList();
    private ScheduledExecutorService l = new ScheduledThreadPoolExecutor(1);
    private ScheduledFuture<?> m;
    private m n = new m(this);

    public ElfinModel(@NonNull Application application) {
        super(application);
    }

    static /* synthetic */ void a(ElfinModel elfinModel, ArrayList arrayList) {
        elfinModel.d.clear();
        elfinModel.k.clear();
        elfinModel.d.addAll(arrayList);
        Iterator<NotifyMsgBean> it = elfinModel.d.iterator();
        while (it.hasNext()) {
            elfinModel.k.add(it.next().ID);
        }
    }

    private void a(ArrayList<NotifyMsgBean> arrayList) {
        this.d.clear();
        this.k.clear();
        this.d.addAll(arrayList);
        Iterator<NotifyMsgBean> it = this.d.iterator();
        while (it.hasNext()) {
            this.k.add(it.next().ID);
        }
    }

    private MutableLiveData<NotifyMsgBean> c() {
        return this.f;
    }

    private ArrayList<NotifyMsgBean> d() {
        return this.d;
    }

    private MutableLiveData<Boolean> e() {
        return this.h;
    }

    private MutableLiveData<VersionUpdateInfo> f() {
        return this.e;
    }

    private MutableLiveData<Integer> g() {
        return this.g;
    }

    private void h() {
        b.a().a(new Runnable() {
            public final void run() {
                String a2 = a.a(com.cyjh.common.b.a.O, (Context) ElfinModel.this.getApplication());
                boolean z = !TextUtils.isEmpty(a2) && a2.compareTo(a.a(System.currentTimeMillis() / 1000, a.f2523b)) >= 0;
                String a3 = a.a(System.currentTimeMillis() / 1000, a.f2523b);
                if (!z) {
                    c.a().a((Context) ElfinModel.this.getApplication(), 5, 0, 0);
                    a.a(com.cyjh.common.b.a.O, (Context) ElfinModel.this.getApplication(), a3);
                }
                ElfinModel.this.a((a.a(a3) - System.currentTimeMillis()) / 1000);
            }
        });
    }

    private void i() {
        com.cyjh.elfin.e.c.f.a();
        com.cyjh.elfin.e.c.f.a(AppContext.a(), "updateVersionRequest --> ");
        String a2 = l.a(getApplication(), com.cyjh.elfin.a.a.u);
        String a3 = e.a((Context) getApplication());
        UpdateRequestInfo updateRequestInfo = new UpdateRequestInfo();
        updateRequestInfo.ScriptId = com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getId();
        updateRequestInfo.DeviceName = a3;
        updateRequestInfo.ScriptVersion = Integer.parseInt(a2);
        updateRequestInfo.IsScriptHotUpgrade = 1;
        updateRequestInfo.AppVersion = e.b();
        ad.c("TAG", "updateVersionRequest --> 1 ScriptId=" + updateRequestInfo.ScriptId + ",DeviceName=" + updateRequestInfo.DeviceName);
        com.cyjh.http.c.b.a a4 = com.cyjh.http.c.b.a.a();
        a4.f2481c = new a.C0039a() {
            public final void a(VersionUpdateInfo versionUpdateInfo) {
                if (versionUpdateInfo == null) {
                    ElfinModel.this.e.postValue(null);
                    return;
                }
                com.cyjh.elfin.e.c.f.a();
                AppContext a2 = AppContext.a();
                com.cyjh.elfin.e.c.f.a(a2, "updateVersionRequest onUpdateHas --> versionUpdateInfo.UpgradeMode=" + versionUpdateInfo.UpgradeMode);
                ElfinModel.this.e.postValue(versionUpdateInfo);
            }

            public final void b(VersionUpdateInfo versionUpdateInfo) {
                ad.c(ElfinModel.i, "onConnectStudioSocket IS_SERVICE_START:" + com.hlzn.socketclient.b.a.v);
                if (!com.hlzn.socketclient.b.a.v) {
                    AppContext.a().e = versionUpdateInfo.StudioProjectKey;
                    e.a((Context) AppContext.a(), versionUpdateInfo.DeviceName);
                    ElfinModel.this.g.postValue(1007);
                }
            }

            public final void c(VersionUpdateInfo versionUpdateInfo) {
                if (versionUpdateInfo.InstanceDataUploadInterval != 0) {
                    com.cyjh.elfin.a.b.av = versionUpdateInfo.InstanceDataUploadInterval;
                }
            }
        };
        a4.a(false, getApplication(), updateRequestInfo);
    }

    private void j() {
        c.a().a((Context) getApplication(), 5, 0, 0);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        a((com.cyjh.http.e.a.a(com.cyjh.http.e.a.a(currentTimeMillis, com.cyjh.http.e.a.f2523b)) / 1000) - currentTimeMillis);
    }

    private void k() {
        b.a().a(new Runnable(new com.cyjh.common.f.a() {
            public final void a() {
            }

            public final void a(Object obj) {
                ArrayList arrayList = (ArrayList) obj;
                if (arrayList != null) {
                    ElfinModel.a(ElfinModel.this, arrayList);
                }
            }
        }) {
            public final void run(
/*
Method generation error in method: com.cyjh.elfin.b.b.1.run():void, dex: classes.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.cyjh.elfin.b.b.1.run():void, class status: UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            
*/
        });
    }

    private void l() {
        this.f.postValue(this.j.get(0));
        ab.a().a(com.cyjh.elfin.a.b.e, (Boolean) true);
        com.cyjh.elfin.b.b a2 = com.cyjh.elfin.b.b.a();
        ArrayList<NotifyMsgBean> arrayList = this.j;
        SQLiteDatabase writableDatabase = a2.f1851a.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            NotifyMsgBean notifyMsgBean = arrayList.get(size);
            contentValues.clear();
            contentValues.put("number", notifyMsgBean.ID);
            contentValues.put("title", notifyMsgBean.NoticeTitle);
            contentValues.put("time", notifyMsgBean.NoticeTime);
            contentValues.put(com.umeng.analytics.pro.b.W, notifyMsgBean.NoticeContent);
            contentValues.put("description", notifyMsgBean.NoticeDescription);
            contentValues.put(b.c.f4839c, notifyMsgBean.DescriptionType);
            writableDatabase.insert(com.cyjh.elfin.a.b.d, (String) null, contentValues);
        }
        writableDatabase.close();
    }

    private void m() {
        this.d.clear();
        com.cyjh.elfin.b.b.a().f1851a.getWritableDatabase().delete(com.cyjh.elfin.a.b.d, (String) null, (String[]) null);
    }

    private void n() {
        com.cyjh.feedback.lib.d.b.a().a(new Runnable() {
            public final void run() {
                String a2 = com.cyjh.http.e.a.a(com.cyjh.common.b.a.ax + com.cyjh.common.a.a.c(), (Context) AppContext.a());
                String a3 = com.cyjh.http.e.a.a(com.cyjh.common.b.a.ay + com.cyjh.common.a.a.c(), (Context) AppContext.a());
                ad.a("qureyRegCode", "oldFileRegCode:" + a2);
                ad.a("qureyRegCode", "json:" + a3);
                if (TextUtils.isEmpty(a3)) {
                    Log.e("zzz", "ElfinPayActivity:statusInfo旧的--");
                    com.cyjh.elfin.d.c.a().f1864a = a2;
                    if (TextUtils.isEmpty(a2)) {
                        return;
                    }
                } else {
                    Log.e("zzz", "ElfinPayActivity:statusInfo新的--");
                    RegCodeStatusInfo regCodeStatusInfo = (RegCodeStatusInfo) r.a(a3, RegCodeStatusInfo.class);
                    Log.e("qureyRegCode", "ElfinPayActivity:statusInfo新的--");
                    if (regCodeStatusInfo != null) {
                        com.cyjh.elfin.d.c.a().f1864a = regCodeStatusInfo.regCode;
                        if (!TextUtils.isEmpty(regCodeStatusInfo.regCode) && regCodeStatusInfo.status == 1) {
                            ElfinModel.this.g.postValue(1006);
                            return;
                        }
                        return;
                    } else if (TextUtils.isEmpty(com.cyjh.elfin.d.c.a().b())) {
                        return;
                    }
                }
                ElfinModel.this.g.postValue(1006);
            }
        });
    }

    private void o() {
        this.h.postValue(true);
        com.cyjh.elfin.floatingwindowprocess.d.a.a((com.cyjh.common.f.a<Boolean>) new com.cyjh.common.f.a<Boolean>() {
            private void b() {
                ElfinModel.this.h.postValue(true);
            }

            public final void a() {
                ElfinModel.this.h.postValue(false);
            }

            public final /* synthetic */ void a(Object obj) {
                ElfinModel.this.h.postValue(true);
            }
        });
    }

    private static void p() {
    }

    public final void a() {
        ad.c("TAG", "updateVersionRequestJudgeOperate --> ");
        com.cyjh.elfin.e.c.f.a();
        com.cyjh.elfin.e.c.f.a(AppContext.a(), "updateVersionRequestJudgeOperate --> ");
        if (x.a(getApplication())) {
            com.cyjh.elfin.e.c.f.a();
            com.cyjh.elfin.e.c.f.a(AppContext.a(), "updateVersionRequest --> ");
            String a2 = l.a(getApplication(), com.cyjh.elfin.a.a.u);
            String a3 = e.a((Context) getApplication());
            UpdateRequestInfo updateRequestInfo = new UpdateRequestInfo();
            updateRequestInfo.ScriptId = com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getId();
            updateRequestInfo.DeviceName = a3;
            updateRequestInfo.ScriptVersion = Integer.parseInt(a2);
            updateRequestInfo.IsScriptHotUpgrade = 1;
            updateRequestInfo.AppVersion = e.b();
            ad.c("TAG", "updateVersionRequest --> 1 ScriptId=" + updateRequestInfo.ScriptId + ",DeviceName=" + updateRequestInfo.DeviceName);
            com.cyjh.http.c.b.a a4 = com.cyjh.http.c.b.a.a();
            a4.f2481c = new a.C0039a() {
                public final void a(VersionUpdateInfo versionUpdateInfo) {
                    if (versionUpdateInfo == null) {
                        ElfinModel.this.e.postValue(null);
                        return;
                    }
                    com.cyjh.elfin.e.c.f.a();
                    AppContext a2 = AppContext.a();
                    com.cyjh.elfin.e.c.f.a(a2, "updateVersionRequest onUpdateHas --> versionUpdateInfo.UpgradeMode=" + versionUpdateInfo.UpgradeMode);
                    ElfinModel.this.e.postValue(versionUpdateInfo);
                }

                public final void b(VersionUpdateInfo versionUpdateInfo) {
                    ad.c(ElfinModel.i, "onConnectStudioSocket IS_SERVICE_START:" + com.hlzn.socketclient.b.a.v);
                    if (!com.hlzn.socketclient.b.a.v) {
                        AppContext.a().e = versionUpdateInfo.StudioProjectKey;
                        e.a((Context) AppContext.a(), versionUpdateInfo.DeviceName);
                        ElfinModel.this.g.postValue(1007);
                    }
                }

                public final void c(VersionUpdateInfo versionUpdateInfo) {
                    if (versionUpdateInfo.InstanceDataUploadInterval != 0) {
                        com.cyjh.elfin.a.b.av = versionUpdateInfo.InstanceDataUploadInterval;
                    }
                }
            };
            a4.a(false, getApplication(), updateRequestInfo);
            return;
        }
        ag.a((Context) getApplication(), "当前网络无法访问，请检查网络设置……");
    }

    /* access modifiers changed from: package-private */
    public final void a(long j2) {
        if (j2 > 0) {
            if (this.m != null) {
                this.m.cancel(false);
                this.m = null;
            }
            this.m = this.l.schedule(new Runnable() {
                public final void run() {
                    try {
                        com.cyjh.http.e.a.a(com.cyjh.common.b.a.O, (Context) ElfinModel.this.getApplication(), com.cyjh.http.e.a.a(System.currentTimeMillis() / 1000, com.cyjh.http.e.a.f2523b));
                        ElfinModel elfinModel = ElfinModel.this;
                        c.a().a((Context) elfinModel.getApplication(), 5, 0, 0);
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        elfinModel.a((com.cyjh.http.e.a.a(com.cyjh.http.e.a.a(currentTimeMillis, com.cyjh.http.e.a.f2523b)) / 1000) - currentTimeMillis);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                        Log.e("zzz", "ElfinFreeActivity--" + e.getMessage());
                    }
                }
            }, j2 + ((long) (new Random().nextInt(18600) + 600)), TimeUnit.SECONDS);
        }
    }

    public final void a(List<NotifyMsgBean> list) {
        this.j.clear();
        this.j.addAll(list);
        if (!this.k.contains(this.j.get(0).ID)) {
            this.d.addAll(0, this.j);
            this.f.postValue(this.j.get(0));
            ab.a().a(com.cyjh.elfin.a.b.e, (Boolean) true);
            com.cyjh.elfin.b.b a2 = com.cyjh.elfin.b.b.a();
            ArrayList<NotifyMsgBean> arrayList = this.j;
            SQLiteDatabase writableDatabase = a2.f1851a.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                NotifyMsgBean notifyMsgBean = arrayList.get(size);
                contentValues.clear();
                contentValues.put("number", notifyMsgBean.ID);
                contentValues.put("title", notifyMsgBean.NoticeTitle);
                contentValues.put("time", notifyMsgBean.NoticeTime);
                contentValues.put(com.umeng.analytics.pro.b.W, notifyMsgBean.NoticeContent);
                contentValues.put("description", notifyMsgBean.NoticeDescription);
                contentValues.put(b.c.f4839c, notifyMsgBean.DescriptionType);
                writableDatabase.insert(com.cyjh.elfin.a.b.d, (String) null, contentValues);
            }
            writableDatabase.close();
        }
    }

    public final void b() {
        this.n.a((Context) getApplication());
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        this.n.a();
        com.cyjh.http.c.b.a.a().d();
        c.a().c();
        if (this.m != null) {
            this.m.cancel(false);
        }
    }
}
