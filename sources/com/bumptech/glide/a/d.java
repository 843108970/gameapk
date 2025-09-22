package com.bumptech.glide.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface d {

    /* renamed from: a  reason: collision with root package name */
    public static final int f890a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f891b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f892c = 2;

    int a() default 0;

    String b() default "";

    boolean c() default false;

    boolean d() default false;
}
