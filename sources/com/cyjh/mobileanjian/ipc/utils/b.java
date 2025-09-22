package com.cyjh.mobileanjian.ipc.utils;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Properties f2705a = new Properties();

    b() {
        try {
            this.f2705a.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        } catch (IOException unused) {
        }
    }

    private Set<Map.Entry<Object, Object>> a() {
        return this.f2705a.entrySet();
    }

    private boolean b() {
        return this.f2705a.isEmpty();
    }

    private boolean b(Object obj) {
        return this.f2705a.containsValue(obj);
    }

    private Enumeration<Object> c() {
        return this.f2705a.keys();
    }

    private Set<Object> d() {
        return this.f2705a.keySet();
    }

    private int e() {
        return this.f2705a.size();
    }

    private Collection<Object> f() {
        return this.f2705a.values();
    }

    private static b g() {
        return new b();
    }

    public final String a(String str) {
        return this.f2705a.getProperty(str);
    }

    public final String a(String str, String str2) {
        return this.f2705a.getProperty(str, str2);
    }

    public final boolean a(Object obj) {
        return this.f2705a.containsKey(obj);
    }
}
