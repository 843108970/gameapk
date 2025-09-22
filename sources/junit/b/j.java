package junit.b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class j extends a implements i {

    /* renamed from: a  reason: collision with root package name */
    public String f4032a;

    public j() {
        this.f4032a = null;
    }

    public j(String str) {
        this.f4032a = str;
    }

    private static void a(byte b2, byte b3) {
        a.a((String) null, b2, b3);
    }

    private static void a(char c2, char c3) {
        a.a((String) null, c2, c3);
    }

    private static void a(double d, double d2, double d3) {
        a.a((String) null, d, d2, d3);
    }

    private static void a(float f, float f2, float f3) {
        a.a((String) null, f, f2, f3);
    }

    private static void a(int i, int i2) {
        a.a((String) null, i, i2);
    }

    private static void a(long j, long j2) {
        a.a((String) null, j, j2);
    }

    private static void a(Object obj) {
        a.a((String) null, obj);
    }

    private static void a(Object obj, Object obj2) {
        a.a((String) null, obj, obj2);
    }

    private static void a(String str, String str2) {
        a.a((String) null, str, str2);
    }

    private static void a(short s, short s2) {
        a.a((String) null, s, s2);
    }

    private static void a(boolean z) {
        a.a((String) null, z);
    }

    private static void a(boolean z, boolean z2) {
        a.a((String) null, z, z2);
    }

    private static void b(Object obj) {
        if (obj != null) {
            a.b("Expected: <null> but was: " + obj.toString(), obj);
        }
    }

    private static void b(Object obj, Object obj2) {
        a.b((String) null, obj, obj2);
    }

    private static void b(String str, byte b2, byte b3) {
        a.a(str, b2, b3);
    }

    private static void b(String str, char c2, char c3) {
        a.a(str, c2, c3);
    }

    private static void b(String str, double d, double d2, double d3) {
        a.a(str, d, d2, d3);
    }

    private static void b(String str, float f, float f2, float f3) {
        a.a(str, f, f2, f3);
    }

    private static void b(String str, int i, int i2) {
        a.a(str, i, i2);
    }

    private static void b(String str, long j, long j2) {
        a.a(str, j, j2);
    }

    private static void b(String str, String str2, String str3) {
        a.a(str, str2, str3);
    }

    private static void b(String str, short s, short s2) {
        a.a(str, s, s2);
    }

    private static void b(String str, boolean z, boolean z2) {
        a.a(str, z, z2);
    }

    private static void b(boolean z) {
        a.b((String) null, z);
    }

    private static void c(Object obj, Object obj2) {
        a.c((String) null, obj, obj2);
    }

    private static void c(String str) {
        a.a(str);
    }

    private static void c(String str, Object obj) {
        a.a(str, obj);
    }

    private static void c(String str, boolean z) {
        a.a(str, z);
    }

    private static m d() {
        return new m();
    }

    private static void d(String str) {
        a.b(str);
    }

    private static void d(String str, Object obj) {
        a.b(str, obj);
    }

    private static void d(String str, boolean z) {
        a.b(str, z);
    }

    private m e() {
        m mVar = new m();
        a(mVar);
        return mVar;
    }

    private void e(String str) {
        this.f4032a = str;
    }

    private static void f() {
        a.a((String) null);
    }

    private static void g() throws Exception {
    }

    private static void g(String str, Object obj, Object obj2) {
        a.a(str, obj, obj2);
    }

    private static void h() throws Exception {
    }

    private static void h(String str, Object obj, Object obj2) {
        a.b(str, obj, obj2);
    }

    private String i() {
        return this.f4032a;
    }

    private static void i(String str, Object obj, Object obj2) {
        a.c(str, obj, obj2);
    }

    private static void j(String str, Object obj, Object obj2) {
        a.d(str, obj, obj2);
    }

    private static void k(String str, Object obj, Object obj2) {
        a.e(str, obj, obj2);
    }

    private static String l(String str, Object obj, Object obj2) {
        return a.f(str, obj, obj2);
    }

    public final int a() {
        return 1;
    }

    public final void a(m mVar) {
        mVar.b((i) this);
        mVar.a((i) this, (h) new h(this) {
            public final void a(
/*
Method generation error in method: junit.b.m.1.a():void, dex: classes.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: junit.b.m.1.a():void, class status: UNLOADED
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
        mVar.a((i) this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0007, code lost:
        r0 = th;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() throws java.lang.Throwable {
        /*
            r1 = this;
            r1.c()     // Catch:{ Throwable -> 0x0007, all -> 0x0005 }
            r0 = 0
            goto L_0x0008
        L_0x0005:
            r0 = move-exception
            throw r0
        L_0x0007:
            r0 = move-exception
        L_0x0008:
            if (r0 == 0) goto L_0x000b
            throw r0
        L_0x000b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: junit.b.j.b():void");
    }

    /* access modifiers changed from: protected */
    public void c() throws Throwable {
        a.a("TestCase.fName cannot be null", (Object) this.f4032a);
        Method method = null;
        try {
            method = getClass().getMethod(this.f4032a, (Class[]) null);
        } catch (NoSuchMethodException unused) {
            a.a("Method \"" + this.f4032a + "\" not found");
        }
        if (!Modifier.isPublic(method.getModifiers())) {
            a.a("Method \"" + this.f4032a + "\" should be public");
        }
        try {
            method.invoke(this, new Object[0]);
        } catch (InvocationTargetException e) {
            e.fillInStackTrace();
            throw e.getTargetException();
        } catch (IllegalAccessException e2) {
            e2.fillInStackTrace();
            throw e2;
        }
    }

    public String toString() {
        return this.f4032a + "(" + getClass().getName() + ")";
    }
}
