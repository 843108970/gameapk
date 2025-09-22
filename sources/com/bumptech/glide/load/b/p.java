package com.bumptech.glide.load.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.bumptech.glide.load.g;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class p extends Exception {
    private static final StackTraceElement[] EMPTY_ELEMENTS = new StackTraceElement[0];
    private static final long serialVersionUID = 1;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private com.bumptech.glide.load.a dataSource;
    private String detailMessage;
    private g key;

    private static final class a implements Appendable {

        /* renamed from: a  reason: collision with root package name */
        private static final String f1167a = "";

        /* renamed from: b  reason: collision with root package name */
        private static final String f1168b = "  ";

        /* renamed from: c  reason: collision with root package name */
        private final Appendable f1169c;
        private boolean d = true;

        a(Appendable appendable) {
            this.f1169c = appendable;
        }

        @NonNull
        private static CharSequence a(@Nullable CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        public final Appendable append(char c2) throws IOException {
            boolean z = false;
            if (this.d) {
                this.d = false;
                this.f1169c.append(f1168b);
            }
            if (c2 == 10) {
                z = true;
            }
            this.d = z;
            this.f1169c.append(c2);
            return this;
        }

        public final Appendable append(@Nullable CharSequence charSequence) throws IOException {
            CharSequence a2 = a(charSequence);
            return append(a2, 0, a2.length());
        }

        public final Appendable append(@Nullable CharSequence charSequence, int i, int i2) throws IOException {
            CharSequence a2 = a(charSequence);
            boolean z = false;
            if (this.d) {
                this.d = false;
                this.f1169c.append(f1168b);
            }
            if (a2.length() > 0 && a2.charAt(i2 - 1) == 10) {
                z = true;
            }
            this.d = z;
            this.f1169c.append(a2, i, i2);
            return this;
        }
    }

    public p(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    public p(String str, Throwable th) {
        this(str, (List<Throwable>) Collections.singletonList(th));
    }

    public p(String str, List<Throwable> list) {
        this.detailMessage = str;
        setStackTrace(EMPTY_ELEMENTS);
        this.causes = list;
    }

    private void addRootCauses(Throwable th, List<Throwable> list) {
        if (th instanceof p) {
            for (Throwable addRootCauses : ((p) th).getCauses()) {
                addRootCauses(addRootCauses, list);
            }
            return;
        }
        list.add(th);
    }

    private static void appendCauses(List<Throwable> list, Appendable appendable) {
        try {
            appendCausesWrapped(list, appendable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void appendCausesWrapped(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            appendable.append("Cause (").append(String.valueOf(i2)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i);
            if (th instanceof p) {
                ((p) th).printStackTrace(appendable);
            } else {
                appendExceptionMessage(th, appendable);
            }
            i = i2;
        }
    }

    private static void appendExceptionMessage(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append(10);
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private void printStackTrace(Appendable appendable) {
        appendExceptionMessage(this, appendable);
        appendCauses(getCauses(), new a(appendable));
    }

    public final Throwable fillInStackTrace() {
        return this;
    }

    public final List<Throwable> getCauses() {
        return this.causes;
    }

    public final String getMessage() {
        String str;
        String str2;
        String str3;
        String str4;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.detailMessage);
        if (this.dataClass != null) {
            str = ", " + this.dataClass;
        } else {
            str = "";
        }
        sb.append(str);
        if (this.dataSource != null) {
            str2 = ", " + this.dataSource;
        } else {
            str2 = "";
        }
        sb.append(str2);
        if (this.key != null) {
            str3 = ", " + this.key;
        } else {
            str3 = "";
        }
        sb.append(str3);
        List<Throwable> rootCauses = getRootCauses();
        if (rootCauses.isEmpty()) {
            return sb.toString();
        }
        if (rootCauses.size() == 1) {
            str4 = "\nThere was 1 cause:";
        } else {
            sb.append("\nThere were ");
            sb.append(rootCauses.size());
            str4 = " causes:";
        }
        sb.append(str4);
        for (Throwable next : rootCauses) {
            sb.append(10);
            sb.append(next.getClass().getName());
            sb.append('(');
            sb.append(next.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    public final List<Throwable> getRootCauses() {
        ArrayList arrayList = new ArrayList();
        addRootCauses(this, arrayList);
        return arrayList;
    }

    public final void logRootCauses(String str) {
        List<Throwable> rootCauses = getRootCauses();
        int size = rootCauses.size();
        int i = 0;
        while (i < size) {
            StringBuilder sb = new StringBuilder("Root cause (");
            int i2 = i + 1;
            sb.append(i2);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i(str, sb.toString(), rootCauses.get(i));
            i = i2;
        }
    }

    public final void printStackTrace() {
        printStackTrace(System.err);
    }

    public final void printStackTrace(PrintStream printStream) {
        printStackTrace((Appendable) printStream);
    }

    public final void printStackTrace(PrintWriter printWriter) {
        printStackTrace((Appendable) printWriter);
    }

    /* access modifiers changed from: package-private */
    public final void setLoggingDetails(g gVar, com.bumptech.glide.load.a aVar) {
        setLoggingDetails(gVar, aVar, (Class<?>) null);
    }

    /* access modifiers changed from: package-private */
    public final void setLoggingDetails(g gVar, com.bumptech.glide.load.a aVar, Class<?> cls) {
        this.key = gVar;
        this.dataSource = aVar;
        this.dataClass = cls;
    }
}
