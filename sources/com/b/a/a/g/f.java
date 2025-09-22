package com.b.a.a.g;

import com.b.a.a.c;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

final class f implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    boolean f731a;

    /* renamed from: b  reason: collision with root package name */
    String f732b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f733c;

    public f(List<String> list) {
        this.f733c = list;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        Object obj2;
        String name = method.getName();
        Class<?> returnType = method.getReturnType();
        if (objArr == null) {
            objArr = c.f604b;
        }
        if (name.equals("supports") && Boolean.TYPE == returnType) {
            return true;
        }
        if (name.equals("unsupported") && Void.TYPE == returnType) {
            this.f731a = true;
            return null;
        } else if (name.equals("protocols") && objArr.length == 0) {
            return this.f733c;
        } else {
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                List list = (List) objArr[0];
                int size = list.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        obj2 = this.f733c.get(0);
                        break;
                    } else if (this.f733c.contains(list.get(i))) {
                        obj2 = list.get(i);
                        break;
                    } else {
                        i++;
                    }
                }
                String str = (String) obj2;
                this.f732b = str;
                return str;
            } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            } else {
                this.f732b = (String) objArr[0];
                return null;
            }
        }
    }
}
