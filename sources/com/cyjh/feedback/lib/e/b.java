package com.cyjh.feedback.lib.e;

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
    private final Properties f2413a = new Properties();

    b() throws IOException {
        this.f2413a.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
    }

    private Set<Map.Entry<Object, Object>> a() {
        return this.f2413a.entrySet();
    }

    private boolean a(Object obj) {
        return this.f2413a.containsKey(obj);
    }

    private String b(String str) {
        return this.f2413a.getProperty(str);
    }

    private boolean b() {
        return this.f2413a.isEmpty();
    }

    private boolean b(Object obj) {
        return this.f2413a.containsValue(obj);
    }

    private Enumeration<Object> c() {
        return this.f2413a.keys();
    }

    private Set<Object> d() {
        return this.f2413a.keySet();
    }

    private int e() {
        return this.f2413a.size();
    }

    private Collection<Object> f() {
        return this.f2413a.values();
    }

    private static b g() throws IOException {
        return new b();
    }

    public final String a(String str) {
        return this.f2413a.getProperty(str, (String) null);
    }
}
