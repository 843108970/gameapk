package org.junit.a.a;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.a.a.a;

public final class f extends c {

    private static class a extends a.C0068a {
        public a(List<Class<?>> list) {
            this((Set<Class<?>>) new HashSet(list));
        }

        private a(Set<Class<?>> set) {
            super(true, set, true, (Set<Class<?>>) null);
        }

        public final String a() {
            return "includes " + super.a();
        }
    }

    /* access modifiers changed from: protected */
    public final org.junit.runner.a.a a(List<Class<?>> list) {
        return new a(list);
    }
}
