package com.cyjh.mobileanjian.ipc.utils;

import java.util.HashMap;

public class h {

    /* renamed from: c  reason: collision with root package name */
    private static final long f2712c = 2749416527681438711L;

    /* renamed from: a  reason: collision with root package name */
    HashMap<String, Integer> f2713a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    HashMap<Class, Integer> f2714b = new HashMap<>();
    private HashMap<String, Class> d = new HashMap<>();

    private int a(Class cls) {
        return this.f2714b.get(cls).intValue();
    }

    private int b(String str) {
        return this.f2713a.get(str).intValue();
    }

    public final Class a(String str) {
        return this.d.get(str);
    }

    public final void a(String str, Class cls, Integer num) {
        this.d.put(str, cls);
        this.f2713a.put(str, num);
        this.f2714b.put(cls, num);
    }
}
