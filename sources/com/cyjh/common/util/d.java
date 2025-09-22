package com.cyjh.common.util;

import java.util.Collection;

public final class d {
    private static boolean a(Collection<? extends Object> collection) {
        return collection == null || collection.isEmpty();
    }

    private static boolean b(Collection<? extends Object> collection) {
        return collection != null && collection.size() > 0;
    }
}
