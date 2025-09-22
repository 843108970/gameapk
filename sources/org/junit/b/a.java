package org.junit.b;

import java.util.ArrayList;
import java.util.List;

public final class a extends AssertionError {
    private static final long serialVersionUID = 1;
    private final List<Integer> fIndices = new ArrayList();
    private final String fMessage;

    public a(String str, AssertionError assertionError, int i) {
        this.fMessage = str;
        initCause(assertionError);
        addDimension(i);
    }

    public final void addDimension(int i) {
        this.fIndices.add(0, Integer.valueOf(i));
    }

    public final String getMessage() {
        StringBuilder sb = new StringBuilder();
        if (this.fMessage != null) {
            sb.append(this.fMessage);
        }
        sb.append("arrays first differed at element ");
        for (Integer intValue : this.fIndices) {
            int intValue2 = intValue.intValue();
            sb.append("[");
            sb.append(intValue2);
            sb.append("]");
        }
        sb.append("; ");
        sb.append(getCause().getMessage());
        return sb.toString();
    }

    public final String toString() {
        return getMessage();
    }
}
