package com.elfin.engin;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.cyjh.common.util.s;
import com.cyjh.elfin.util.IpcSwap;
import com.cyjh.mobileanjian.ipc.interfaces.RootProgressListener;
import com.cyjh.mobileanjian.ipc.uip.UisScriptRunner;
import com.cyjh.mq.sdk.MqBridge;
import com.cyjh.mq.sdk.entity.Script4Run;
import com.cyjh.mq.service.IpcService;
import com.elfin.engin.b.a.a;
import com.elfin.engin.b.b;
import com.elfin.engin.b.c;
import com.goldcoast.sdk.domain.AnalyseResult;
import com.goldcoast.sdk.domain.EntryPoint;
import java.io.File;

public final class d {
    public static a a(Context context, String str, String str2, String str3) {
        Log.e("a111111", "getScriptModel " + str2 + s.a.f1696a + str + s.a.f1696a + str3);
        File file = new File(str2);
        return (str2 == null || !file.exists() || file.length() <= 0) ? new b(context, str, str3) : new c(context, str2, str3);
    }

    private static void a(int i) {
        b bVar;
        c a2 = c.a();
        a2.f2903c = i;
        if (a2.f2903c == 0) {
            if (a2.d == null) {
                a2.d = new f();
            }
            bVar = a2.d;
        } else {
            if (a2.e == null) {
                a2.e = new g();
            }
            bVar = a2.e;
        }
        a2.f2902b = bVar;
    }

    private static void a(Application application) {
        c a2 = c.a();
        EntryPoint.init(application, "", (AnalyseResult) null, 10, (byte) 0);
        a2.d = new f();
        a2.f2902b = a2.d;
    }

    private static void a(Application application, String str, String str2, e eVar) {
        c a2 = c.a();
        a2.f = eVar;
        MqBridge.init(application, str, str2, a2.g, new RootProgressListener(application) {
            public final void onRootProgress(
/*
Method generation error in method: com.elfin.engin.c.7.onRootProgress(java.lang.String, int):void, dex: classes.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.elfin.engin.c.7.onRootProgress(java.lang.String, int):void, class status: UNLOADED
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
        }, a2.h);
        a2.f2902b.a(a2.k);
        b bVar = a2.f2902b;
        bVar.a().setOnScriptListener(a2.i);
    }

    public static void a(Context context) {
        context.stopService(new Intent(context, IpcService.class));
    }

    public static void a(String str) {
        c a2 = c.a();
        if (a2.f2902b != null) {
            a2.f2902b.a(str);
        }
    }

    public static void a(String str, String str2) {
        Log.e("zzz", "runScript--startLoop:" + str + ", scriptEncryptKey:" + str2);
        UisScriptRunner.getInstance().startLoop(str, str2);
    }

    private static void a(String str, String str2, String str3) {
        c a2 = c.a();
        a2.f2902b.a(str, str2, str3, a2.j);
    }

    private static void a(String str, String str2, String str3, int i, long j, String str4, String str5, String str6) {
        c a2 = c.a();
        Script4Run script4Run = new Script4Run();
        script4Run.setLcPath(str);
        script4Run.setAtcPath(str2);
        script4Run.setConfigPath(str3);
        script4Run.setScriptEncryptKey(str4);
        script4Run.trialTime = i;
        script4Run.encryptKey = j;
        Log.e("zzz", "runScript--script4Run.scripyEncryptKey:" + script4Run.getScriptEncryptKey());
        script4Run.appId = str5;
        script4Run.username = str6;
        script4Run.encrypt = true;
        if (a2.f2902b != null) {
            a2.f2902b.a(script4Run);
        }
    }

    private static void a(String str, String str2, String str3, String str4) {
        c a2 = c.a();
        Script4Run script4Run = new Script4Run();
        script4Run.setLcPath(str);
        script4Run.setAtcPath(str2);
        script4Run.setConfigPath(str3);
        script4Run.setScriptEncryptKey(str4);
        if (a2.f2902b != null) {
            a2.f2902b.a(script4Run);
        }
    }

    public static void a(boolean z, int i, int i2, int i3, int i4) {
        c a2 = c.a();
        if (a2.f2902b != null) {
            a2.f2902b.a(z, i, i2, i3, i4);
        }
    }

    public static boolean a() {
        c a2 = c.a();
        if (a2.f2902b != null) {
            return a2.f2902b.a().isScriptStarted();
        }
        return false;
    }

    private static String b(String str) {
        return IpcSwap.checkTemplateReq(str);
    }

    private static void b() {
        c a2 = c.a();
        if (a2.f2902b != null) {
            a2.f2902b.a(a2.k);
            a2.f2902b.a().start();
        }
    }

    private static String c(String str) {
        return IpcSwap.startAppReq(str);
    }

    private static void c() {
        c a2 = c.a();
        if (a2.f2902b != null) {
            a2.f2902b.a().pause();
        }
    }

    private static void d() {
        c a2 = c.a();
        if (a2.f2902b != null) {
            a2.f2902b.a().resume();
        }
    }

    private static void e() {
        c a2 = c.a();
        if (a2.f2902b != null) {
            a2.f2902b.a().stop();
        }
    }

    private static boolean f() {
        return c.a().f2901a;
    }

    private static void g() {
        c.a().f2901a = false;
    }

    private static void h() {
        UisScriptRunner.getInstance().stopLoop();
    }

    private static void i() {
        MqBridge.exit();
    }
}
