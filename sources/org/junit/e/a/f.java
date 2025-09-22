package org.junit.e.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.b.d.a.b;

public class f extends Exception {
    private static final long serialVersionUID = 1;
    private final List<Throwable> fErrors;

    public f(List<Throwable> list) {
        this.fErrors = new ArrayList(list);
    }

    public static void assertEmpty(List<Throwable> list) throws Exception {
        if (!list.isEmpty()) {
            if (list.size() == 1) {
                throw list.get(0);
            }
            throw new b(list);
        }
    }

    public List<Throwable> getFailures() {
        return Collections.unmodifiableList(this.fErrors);
    }

    public String getMessage() {
        StringBuilder sb = new StringBuilder(String.format("There were %d errors:", new Object[]{Integer.valueOf(this.fErrors.size())}));
        for (Throwable next : this.fErrors) {
            sb.append(String.format("\n  %s(%s)", new Object[]{next.getClass().getName(), next.getMessage()}));
        }
        return sb.toString();
    }
}
