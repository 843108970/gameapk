package org.junit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface m {

    public static class a extends Throwable {
        private static final long serialVersionUID = 1;

        private a() {
        }
    }

    Class<? extends Throwable> a() default a.class;

    long b() default 0;
}
