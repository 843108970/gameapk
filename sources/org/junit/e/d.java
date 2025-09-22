package org.junit.e;

import java.lang.reflect.Method;
import java.util.Comparator;
import org.junit.b.h;

public enum d {
    NAME_ASCENDING(h.f4526b),
    JVM((String) null),
    DEFAULT(h.f4525a);
    
    private final Comparator<Method> comparator;

    private d(Comparator<Method> comparator2) {
        this.comparator = comparator2;
    }

    public final Comparator<Method> getComparator() {
        return this.comparator;
    }
}
