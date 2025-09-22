package org.junit.e.a;

import java.lang.annotation.Annotation;

public interface a {
    <T extends Annotation> T a(Class<T> cls);

    Annotation[] a();
}
