package com.didi.virtualapk.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Reflector {
    public static final String LOG_TAG = "VA.Reflector";
    protected Object mCaller;
    protected Constructor mConstructor;
    protected Field mField;
    protected Method mMethod;
    protected Class<?> mType;

    public static class QuietReflector extends Reflector {
        protected Throwable mIgnored;

        protected QuietReflector() {
        }

        public static QuietReflector on(@Nullable Class<?> cls) {
            return on(cls, (Throwable) cls == null ? new ReflectedException("Type was null!") : null);
        }

        private static QuietReflector on(@Nullable Class<?> cls, @Nullable Throwable th) {
            QuietReflector quietReflector = new QuietReflector();
            quietReflector.mType = cls;
            quietReflector.mIgnored = th;
            return quietReflector;
        }

        public static QuietReflector on(@NonNull String str) {
            return on(str, true, QuietReflector.class.getClassLoader());
        }

        public static QuietReflector on(@NonNull String str, boolean z) {
            return on(str, z, QuietReflector.class.getClassLoader());
        }

        public static QuietReflector on(@NonNull String str, boolean z, @Nullable ClassLoader classLoader) {
            Class<?> cls;
            try {
                cls = Class.forName(str, z, classLoader);
                try {
                    return on(cls, (Throwable) null);
                } catch (Throwable th) {
                    th = th;
                    return on(cls, th);
                }
            } catch (Throwable th2) {
                th = th2;
                cls = null;
                return on(cls, th);
            }
        }

        public static QuietReflector with(@Nullable Object obj) {
            return obj == null ? on((Class<?>) null) : on(obj.getClass()).bind(obj);
        }

        public QuietReflector bind(@Nullable Object obj) {
            if (skipAlways()) {
                return this;
            }
            try {
                this.mIgnored = null;
                Reflector.super.bind(obj);
                return this;
            } catch (Throwable th) {
                this.mIgnored = th;
                return this;
            }
        }

        public <R> R call(@Nullable Object... objArr) {
            if (skip()) {
                return null;
            }
            try {
                this.mIgnored = null;
                return Reflector.super.call(objArr);
            } catch (Throwable th) {
                this.mIgnored = th;
                return null;
            }
        }

        public <R> R callByCaller(@Nullable Object obj, @Nullable Object... objArr) {
            if (skip()) {
                return null;
            }
            try {
                this.mIgnored = null;
                return Reflector.super.callByCaller(obj, objArr);
            } catch (Throwable th) {
                this.mIgnored = th;
                return null;
            }
        }

        public QuietReflector constructor(@Nullable Class<?>... clsArr) {
            if (skipAlways()) {
                return this;
            }
            try {
                this.mIgnored = null;
                Reflector.super.constructor(clsArr);
                return this;
            } catch (Throwable th) {
                this.mIgnored = th;
                return this;
            }
        }

        public QuietReflector field(@NonNull String str) {
            if (skipAlways()) {
                return this;
            }
            try {
                this.mIgnored = null;
                Reflector.super.field(str);
                return this;
            } catch (Throwable th) {
                this.mIgnored = th;
                return this;
            }
        }

        public <R> R get() {
            if (skip()) {
                return null;
            }
            try {
                this.mIgnored = null;
                return Reflector.super.get();
            } catch (Throwable th) {
                this.mIgnored = th;
                return null;
            }
        }

        public <R> R get(@Nullable Object obj) {
            if (skip()) {
                return null;
            }
            try {
                this.mIgnored = null;
                return Reflector.super.get(obj);
            } catch (Throwable th) {
                this.mIgnored = th;
                return null;
            }
        }

        public Throwable getIgnored() {
            return this.mIgnored;
        }

        public QuietReflector method(@NonNull String str, @Nullable Class<?>... clsArr) {
            if (skipAlways()) {
                return this;
            }
            try {
                this.mIgnored = null;
                Reflector.super.method(str, clsArr);
                return this;
            } catch (Throwable th) {
                this.mIgnored = th;
                return this;
            }
        }

        public <R> R newInstance(@Nullable Object... objArr) {
            if (skip()) {
                return null;
            }
            try {
                this.mIgnored = null;
                return Reflector.super.newInstance(objArr);
            } catch (Throwable th) {
                this.mIgnored = th;
                return null;
            }
        }

        public QuietReflector set(@Nullable Object obj) {
            if (skip()) {
                return this;
            }
            try {
                this.mIgnored = null;
                Reflector.super.set(obj);
                return this;
            } catch (Throwable th) {
                this.mIgnored = th;
                return this;
            }
        }

        public QuietReflector set(@Nullable Object obj, @Nullable Object obj2) {
            if (skip()) {
                return this;
            }
            try {
                this.mIgnored = null;
                Reflector.super.set(obj, obj2);
                return this;
            } catch (Throwable th) {
                this.mIgnored = th;
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public boolean skip() {
            return skipAlways() || this.mIgnored != null;
        }

        /* access modifiers changed from: protected */
        public boolean skipAlways() {
            return this.mType == null;
        }

        public QuietReflector unbind() {
            Reflector.super.unbind();
            return this;
        }
    }

    public static class ReflectedException extends Exception {
        public ReflectedException(String str) {
            super(str);
        }

        public ReflectedException(String str, Throwable th) {
            super(str, th);
        }
    }

    protected Reflector() {
    }

    public static Reflector on(@NonNull Class<?> cls) {
        Reflector reflector = new Reflector();
        reflector.mType = cls;
        return reflector;
    }

    public static Reflector on(@NonNull String str) throws ReflectedException {
        return on(str, true, Reflector.class.getClassLoader());
    }

    public static Reflector on(@NonNull String str, boolean z) throws ReflectedException {
        return on(str, z, Reflector.class.getClassLoader());
    }

    public static Reflector on(@NonNull String str, boolean z, @Nullable ClassLoader classLoader) throws ReflectedException {
        try {
            return on(Class.forName(str, z, classLoader));
        } catch (Throwable th) {
            throw new ReflectedException("Oops!", th);
        }
    }

    public static Reflector with(@NonNull Object obj) throws ReflectedException {
        return on(obj.getClass()).bind(obj);
    }

    public Reflector bind(@Nullable Object obj) throws ReflectedException {
        this.mCaller = checked(obj);
        return this;
    }

    public <R> R call(@Nullable Object... objArr) throws ReflectedException {
        return callByCaller(this.mCaller, objArr);
    }

    public <R> R callByCaller(@Nullable Object obj, @Nullable Object... objArr) throws ReflectedException {
        check(obj, this.mMethod, "Method");
        try {
            return this.mMethod.invoke(obj, objArr);
        } catch (InvocationTargetException e) {
            throw new ReflectedException("Oops!", e.getTargetException());
        } catch (Throwable th) {
            throw new ReflectedException("Oops!", th);
        }
    }

    /* access modifiers changed from: protected */
    public void check(@Nullable Object obj, @Nullable Member member, @NonNull String str) throws ReflectedException {
        if (member == null) {
            throw new ReflectedException(str + " was null!");
        } else if (obj != null || Modifier.isStatic(member.getModifiers())) {
            checked(obj);
        } else {
            throw new ReflectedException("Need a caller!");
        }
    }

    /* access modifiers changed from: protected */
    public Object checked(@Nullable Object obj) throws ReflectedException {
        if (obj == null || this.mType.isInstance(obj)) {
            return obj;
        }
        throw new ReflectedException("Caller [" + obj + "] is not a instance of type [" + this.mType + "]!");
    }

    public Reflector constructor(@Nullable Class<?>... clsArr) throws ReflectedException {
        try {
            this.mConstructor = this.mType.getDeclaredConstructor(clsArr);
            this.mConstructor.setAccessible(true);
            this.mField = null;
            this.mMethod = null;
            return this;
        } catch (Throwable th) {
            throw new ReflectedException("Oops!", th);
        }
    }

    public Reflector field(@NonNull String str) throws ReflectedException {
        try {
            this.mField = findField(str);
            this.mField.setAccessible(true);
            this.mConstructor = null;
            this.mMethod = null;
            return this;
        } catch (Throwable th) {
            throw new ReflectedException("Oops!", th);
        }
    }

    /* access modifiers changed from: protected */
    public Field findField(@NonNull String str) throws NoSuchFieldException {
        try {
            return this.mType.getField(str);
        } catch (NoSuchFieldException e) {
            Class cls = this.mType;
            while (cls != null) {
                try {
                    return cls.getDeclaredField(str);
                } catch (NoSuchFieldException unused) {
                    cls = cls.getSuperclass();
                }
            }
            throw e;
        }
    }

    /* access modifiers changed from: protected */
    public Method findMethod(@NonNull String str, @Nullable Class<?>... clsArr) throws NoSuchMethodException {
        try {
            return this.mType.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            Class cls = this.mType;
            while (cls != null) {
                try {
                    return cls.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException unused) {
                    cls = cls.getSuperclass();
                }
            }
            throw e;
        }
    }

    public <R> R get() throws ReflectedException {
        return get(this.mCaller);
    }

    public <R> R get(@Nullable Object obj) throws ReflectedException {
        check(obj, this.mField, "Field");
        try {
            return this.mField.get(obj);
        } catch (Throwable th) {
            throw new ReflectedException("Oops!", th);
        }
    }

    public Reflector method(@NonNull String str, @Nullable Class<?>... clsArr) throws ReflectedException {
        try {
            this.mMethod = findMethod(str, clsArr);
            this.mMethod.setAccessible(true);
            this.mConstructor = null;
            this.mField = null;
            return this;
        } catch (NoSuchMethodException e) {
            throw new ReflectedException("Oops!", e);
        }
    }

    public <R> R newInstance(@Nullable Object... objArr) throws ReflectedException {
        if (this.mConstructor == null) {
            throw new ReflectedException("Constructor was null!");
        }
        try {
            return this.mConstructor.newInstance(objArr);
        } catch (InvocationTargetException e) {
            throw new ReflectedException("Oops!", e.getTargetException());
        } catch (Throwable th) {
            throw new ReflectedException("Oops!", th);
        }
    }

    public Reflector set(@Nullable Object obj) throws ReflectedException {
        return set(this.mCaller, obj);
    }

    public Reflector set(@Nullable Object obj, @Nullable Object obj2) throws ReflectedException {
        check(obj, this.mField, "Field");
        try {
            this.mField.set(obj, obj2);
            return this;
        } catch (Throwable th) {
            throw new ReflectedException("Oops!", th);
        }
    }

    public Reflector unbind() {
        this.mCaller = null;
        return this;
    }
}
