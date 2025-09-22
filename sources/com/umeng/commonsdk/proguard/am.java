package com.umeng.commonsdk.proguard;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class am implements Serializable {
    private static Map<Class<? extends aa>, Map<? extends ah, am>> d = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final String f3700a;

    /* renamed from: b  reason: collision with root package name */
    public final byte f3701b;

    /* renamed from: c  reason: collision with root package name */
    public final an f3702c;

    public am(String str, byte b2, an anVar) {
        this.f3700a = str;
        this.f3701b = b2;
        this.f3702c = anVar;
    }

    public static Map<? extends ah, am> a(Class<? extends aa> cls) {
        if (!d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e.getMessage());
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e2.getMessage());
            }
        }
        return d.get(cls);
    }

    public static void a(Class<? extends aa> cls, Map<? extends ah, am> map) {
        d.put(cls, map);
    }
}
