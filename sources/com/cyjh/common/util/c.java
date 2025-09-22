package com.cyjh.common.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Properties f1668a = new Properties();

    private c() throws IOException {
        this.f1668a.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
    }

    private String a(String str) {
        return this.f1668a.getProperty(str);
    }

    private String a(String str, String str2) {
        return this.f1668a.getProperty(str, str2);
    }

    private Set<Map.Entry<Object, Object>> a() {
        return this.f1668a.entrySet();
    }

    private boolean a(Object obj) {
        return this.f1668a.containsKey(obj);
    }

    private boolean b() {
        return this.f1668a.isEmpty();
    }

    private boolean b(Object obj) {
        return this.f1668a.containsValue(obj);
    }

    private Enumeration<Object> c() {
        return this.f1668a.keys();
    }

    private Set<Object> d() {
        return this.f1668a.keySet();
    }

    private int e() {
        return this.f1668a.size();
    }

    private Collection<Object> f() {
        return this.f1668a.values();
    }

    private static c g() throws IOException {
        return new c();
    }
}
