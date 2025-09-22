package org.junit.e.a;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.List;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final Method f4570a;

    public g(Method method) {
        this.f4570a = method;
    }

    private void a(GenericArrayType genericArrayType, List<Throwable> list) {
        a(genericArrayType.getGenericComponentType(), list);
    }

    private void a(ParameterizedType parameterizedType, List<Throwable> list) {
        for (Type a2 : parameterizedType.getActualTypeArguments()) {
            a(a2, list);
        }
    }

    private void a(WildcardType wildcardType, List<Throwable> list) {
        for (Type a2 : wildcardType.getUpperBounds()) {
            a(a2, list);
        }
        for (Type a3 : wildcardType.getLowerBounds()) {
            a(a3, list);
        }
    }

    private void a(List<Throwable> list) {
        for (Type a2 : this.f4570a.getGenericParameterTypes()) {
            a(a2, list);
        }
    }

    public final void a(Type type, List<Throwable> list) {
        while (!(type instanceof TypeVariable)) {
            if (type instanceof ParameterizedType) {
                a((ParameterizedType) type, list);
                return;
            } else if (type instanceof WildcardType) {
                a((WildcardType) type, list);
                return;
            } else if (type instanceof GenericArrayType) {
                type = ((GenericArrayType) type).getGenericComponentType();
            } else {
                return;
            }
        }
        list.add(new Exception("Method " + this.f4570a.getName() + "() contains unresolved type variable " + type));
    }
}
