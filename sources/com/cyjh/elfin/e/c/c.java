package com.cyjh.elfin.e.c;

import java.util.Collection;

public final class c {
    private static boolean a(Collection<? extends Object> collection) {
        return collection == null || collection.isEmpty();
    }

    private static boolean b(Collection<? extends Object> collection) {
        return collection != null && collection.size() > 0;
    }
}
