package junit.textui;

import com.cyjh.common.util.s;
import com.googlecode.tesseract.android.TessBaseAPI;
import com.umeng.analytics.pro.b;
import com.umeng.commonsdk.proguard.v;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.Enumeration;
import junit.b.i;
import junit.b.k;
import junit.b.l;
import junit.b.m;

public final class a implements l {

    /* renamed from: a  reason: collision with root package name */
    PrintStream f4048a;

    /* renamed from: b  reason: collision with root package name */
    int f4049b = 0;

    public a(PrintStream printStream) {
        this.f4048a = printStream;
    }

    private void a() {
        this.f4048a.println();
        this.f4048a.println("<RETURN> to continue");
    }

    private void a(long j) {
        this.f4048a.println();
        PrintStream printStream = this.f4048a;
        printStream.println("Time: " + NumberFormat.getInstance().format(((double) j) / 1000.0d));
    }

    private void a(Enumeration<k> enumeration, int i, String str) {
        PrintStream printStream;
        StringBuilder sb;
        String str2;
        if (i != 0) {
            if (i == 1) {
                printStream = this.f4048a;
                sb = new StringBuilder("There was ");
                sb.append(i);
                sb.append(s.a.f1696a);
                sb.append(str);
                str2 = ":";
            } else {
                printStream = this.f4048a;
                sb = new StringBuilder("There were ");
                sb.append(i);
                sb.append(s.a.f1696a);
                sb.append(str);
                str2 = "s:";
            }
            sb.append(str2);
            printStream.println(sb.toString());
            int i2 = 1;
            while (enumeration.hasMoreElements()) {
                k nextElement = enumeration.nextElement();
                PrintStream printStream2 = this.f4048a;
                printStream2.print(i2 + ") " + nextElement.a());
                this.f4048a.print(junit.runner.a.d(nextElement.b()));
                i2++;
            }
        }
    }

    private void a(k kVar) {
        this.f4048a.print(junit.runner.a.d(kVar.b()));
    }

    private void a(k kVar, int i) {
        PrintStream printStream = this.f4048a;
        printStream.print(i + ") " + kVar.a());
        this.f4048a.print(junit.runner.a.d(kVar.b()));
    }

    private void a(m mVar) {
        a(mVar.b(), mVar.a(), b.J);
    }

    private PrintStream b() {
        return this.f4048a;
    }

    private static String b(long j) {
        return NumberFormat.getInstance().format(((double) j) / 1000.0d);
    }

    private void b(k kVar, int i) {
        PrintStream printStream = this.f4048a;
        printStream.print(i + ") " + kVar.a());
    }

    private void b(m mVar) {
        a(mVar.d(), mVar.c(), "failure");
    }

    private void c(m mVar) {
        StringBuilder sb;
        PrintStream printStream;
        if (mVar.g()) {
            this.f4048a.println();
            this.f4048a.print("OK");
            printStream = this.f4048a;
            sb = new StringBuilder(" (");
            sb.append(mVar.e());
            sb.append(" test");
            sb.append(mVar.e() == 1 ? "" : v.al);
            sb.append(")");
        } else {
            this.f4048a.println();
            this.f4048a.println("FAILURES!!!");
            printStream = this.f4048a;
            sb = new StringBuilder("Tests run: ");
            sb.append(mVar.e());
            sb.append(",  Failures: ");
            sb.append(mVar.c());
            sb.append(",  Errors: ");
            sb.append(mVar.a());
        }
        printStream.println(sb.toString());
        this.f4048a.println();
    }

    public final void a(i iVar) {
    }

    public final void a(i iVar, Throwable th) {
        this.f4048a.print("E");
    }

    public final void a(i iVar, junit.b.b bVar) {
        this.f4048a.print(TessBaseAPI.f);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(m mVar, long j) {
        PrintStream printStream;
        String str;
        this.f4048a.println();
        this.f4048a.println("Time: " + NumberFormat.getInstance().format(((double) j) / 1000.0d));
        a(mVar.b(), mVar.a(), b.J);
        a(mVar.d(), mVar.c(), "failure");
        if (mVar.g()) {
            this.f4048a.println();
            this.f4048a.print("OK");
            printStream = this.f4048a;
            StringBuilder sb = new StringBuilder(" (");
            sb.append(mVar.e());
            sb.append(" test");
            sb.append(mVar.e() == 1 ? "" : v.al);
            sb.append(")");
            str = sb.toString();
        } else {
            this.f4048a.println();
            this.f4048a.println("FAILURES!!!");
            printStream = this.f4048a;
            str = "Tests run: " + mVar.e() + ",  Failures: " + mVar.c() + ",  Errors: " + mVar.a();
        }
        printStream.println(str);
        this.f4048a.println();
    }

    public final void b(i iVar) {
        this.f4048a.print(".");
        int i = this.f4049b;
        this.f4049b = i + 1;
        if (i >= 40) {
            this.f4048a.println();
            this.f4049b = 0;
        }
    }
}
