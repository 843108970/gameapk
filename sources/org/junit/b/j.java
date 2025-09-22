package org.junit.b;

import com.umeng.commonsdk.proguard.v;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.junit.runner.b.a;
import org.junit.runner.b.b;
import org.junit.runner.c;
import org.junit.runner.i;

public final class j extends b {

    /* renamed from: a  reason: collision with root package name */
    private final PrintStream f4527a;

    public j(PrintStream printStream) {
        this.f4527a = printStream;
    }

    public j(g gVar) {
        this(gVar.a());
    }

    private PrintStream a() {
        return this.f4527a;
    }

    private void a(long j) {
        this.f4527a.println();
        PrintStream printStream = this.f4527a;
        printStream.println("Time: " + NumberFormat.getInstance().format(((double) j) / 1000.0d));
    }

    private void a(a aVar, String str) {
        PrintStream printStream = this.f4527a;
        printStream.println(str + ") " + aVar.getTestHeader());
        this.f4527a.print(aVar.getTrace());
    }

    private static String b(long j) {
        return NumberFormat.getInstance().format(((double) j) / 1000.0d);
    }

    private void b(i iVar) {
        PrintStream printStream;
        StringBuilder sb;
        String str;
        List<a> failures = iVar.getFailures();
        if (failures.size() != 0) {
            int i = 1;
            if (failures.size() == 1) {
                printStream = this.f4527a;
                sb = new StringBuilder("There was ");
                sb.append(failures.size());
                str = " failure:";
            } else {
                printStream = this.f4527a;
                sb = new StringBuilder("There were ");
                sb.append(failures.size());
                str = " failures:";
            }
            sb.append(str);
            printStream.println(sb.toString());
            for (a next : failures) {
                StringBuilder sb2 = new StringBuilder();
                int i2 = i + 1;
                sb2.append(i);
                String sb3 = sb2.toString();
                PrintStream printStream2 = this.f4527a;
                printStream2.println(sb3 + ") " + next.getTestHeader());
                this.f4527a.print(next.getTrace());
                i = i2;
            }
        }
    }

    private void c(i iVar) {
        StringBuilder sb;
        PrintStream printStream;
        if (iVar.wasSuccessful()) {
            this.f4527a.println();
            this.f4527a.print("OK");
            printStream = this.f4527a;
            sb = new StringBuilder(" (");
            sb.append(iVar.getRunCount());
            sb.append(" test");
            sb.append(iVar.getRunCount() == 1 ? "" : v.al);
            sb.append(")");
        } else {
            this.f4527a.println();
            this.f4527a.println("FAILURES!!!");
            printStream = this.f4527a;
            sb = new StringBuilder("Tests run: ");
            sb.append(iVar.getRunCount());
            sb.append(",  Failures: ");
            sb.append(iVar.getFailureCount());
        }
        printStream.println(sb.toString());
        this.f4527a.println();
    }

    public final void a(a aVar) {
        this.f4527a.append('E');
    }

    public final void a(i iVar) {
        StringBuilder sb;
        PrintStream printStream;
        long runTime = iVar.getRunTime();
        this.f4527a.println();
        PrintStream printStream2 = this.f4527a;
        printStream2.println("Time: " + NumberFormat.getInstance().format(((double) runTime) / 1000.0d));
        b(iVar);
        if (iVar.wasSuccessful()) {
            this.f4527a.println();
            this.f4527a.print("OK");
            printStream = this.f4527a;
            sb = new StringBuilder(" (");
            sb.append(iVar.getRunCount());
            sb.append(" test");
            sb.append(iVar.getRunCount() == 1 ? "" : v.al);
            sb.append(")");
        } else {
            this.f4527a.println();
            this.f4527a.println("FAILURES!!!");
            printStream = this.f4527a;
            sb = new StringBuilder("Tests run: ");
            sb.append(iVar.getRunCount());
            sb.append(",  Failures: ");
            sb.append(iVar.getFailureCount());
        }
        printStream.println(sb.toString());
        this.f4527a.println();
    }

    public final void b(c cVar) {
        this.f4527a.append(FilenameUtils.EXTENSION_SEPARATOR);
    }

    public final void c(c cVar) {
        this.f4527a.append('I');
    }
}
