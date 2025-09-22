package org.junit.runner.b;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.runner.c;
import org.junit.runner.i;

public class b {

    @Documented
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
    }

    public void a(a aVar) throws Exception {
    }

    public void a(c cVar) throws Exception {
    }

    public void a(i iVar) throws Exception {
    }

    public void b(a aVar) {
    }

    public void b(c cVar) throws Exception {
    }

    public void c(c cVar) throws Exception {
    }

    public void d(c cVar) throws Exception {
    }
}
