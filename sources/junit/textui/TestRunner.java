package junit.textui;

import java.io.PrintStream;
import junit.b.i;
import junit.b.j;
import junit.b.l;
import junit.b.m;
import junit.b.n;
import junit.runner.Version;
import junit.runner.a;

public class TestRunner extends a {
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    private a h;

    public TestRunner() {
        this(System.out);
    }

    private TestRunner(PrintStream printStream) {
        this(new a(printStream));
    }

    private TestRunner(a aVar) {
        this.h = aVar;
    }

    private m a(String str, String str2, boolean z) throws Exception {
        return a(n.a((Class<?>) Class.forName(str).asSubclass(j.class), str2), z);
    }

    private m a(i iVar, boolean z) {
        m mVar = new m();
        mVar.a((l) this.h);
        long currentTimeMillis = System.currentTimeMillis();
        iVar.a(mVar);
        this.h.a(mVar, System.currentTimeMillis() - currentTimeMillis);
        if (z) {
            a aVar = this.h;
            aVar.f4048a.println();
            aVar.f4048a.println("<RETURN> to continue");
            try {
                System.in.read();
            } catch (Exception unused) {
            }
        }
        return mVar;
    }

    private m a(String[] strArr) throws Exception {
        String str = "";
        boolean z = false;
        String str2 = "";
        int i = 0;
        while (i < strArr.length) {
            if (strArr[i].equals("-wait")) {
                z = true;
            } else if (strArr[i].equals("-c")) {
                i++;
                str2 = b(strArr[i]);
            } else if (strArr[i].equals("-m")) {
                i++;
                String str3 = strArr[i];
                int lastIndexOf = str3.lastIndexOf(46);
                String substring = str3.substring(0, lastIndexOf);
                str = str3.substring(lastIndexOf + 1);
                str2 = substring;
            } else if (strArr[i].equals("-v")) {
                PrintStream printStream = System.err;
                printStream.println("JUnit " + Version.a() + " by Kent Beck and Erich Gamma");
            } else {
                str2 = strArr[i];
            }
            i++;
        }
        if (str2.equals("")) {
            throw new Exception("Usage: TestRunner [-wait] testCaseName, where name is the name of the TestCase class");
        }
        try {
            return !str.equals("") ? a(n.a((Class<?>) Class.forName(str2).asSubclass(j.class), str), z) : a(a(str2), z);
        } catch (Exception e2) {
            throw new Exception("Could not create and run test suite: " + e2);
        }
    }

    private static void a(Class<? extends j> cls) {
        new TestRunner().a(new n((Class<?>) cls), false);
    }

    private void a(a aVar) {
        this.h = aVar;
    }

    private void a(boolean z) {
        if (z) {
            a aVar = this.h;
            aVar.f4048a.println();
            aVar.f4048a.println("<RETURN> to continue");
            try {
                System.in.read();
            } catch (Exception unused) {
            }
        }
    }

    private static m c(i iVar) {
        return new TestRunner().a(iVar, false);
    }

    private static m d() {
        return new m();
    }

    private static void d(i iVar) {
        new TestRunner().a(iVar, true);
    }

    private m e(i iVar) {
        return a(iVar, false);
    }

    public static void main(String[] strArr) {
        try {
            if (!new TestRunner().a(strArr).g()) {
                System.exit(1);
            }
            System.exit(0);
        } catch (Exception e2) {
            System.err.println(e2.getMessage());
            System.exit(2);
        }
    }

    public final void a() {
    }

    public final void b() {
    }

    public final void c() {
    }

    /* access modifiers changed from: protected */
    public final void c(String str) {
        System.err.println(str);
        System.exit(1);
    }
}
