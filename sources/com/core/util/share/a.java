package com.core.util.share;

import android.os.Bundle;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

final class a {

    /* renamed from: a  reason: collision with root package name */
    static final int f1598a = 1;

    /* renamed from: b  reason: collision with root package name */
    static final int f1599b = 2;

    /* renamed from: c  reason: collision with root package name */
    static final int f1600c = 3;
    static final int d = 4;
    static final int e = 5;
    static final int f = 6;
    static final int g = 1;
    static final int h = 2;
    static final int i = 3;
    static final int j = 4;
    static final int k = 5;
    static final int l = 6;
    static final String m = "key_key";
    static final String n = "key_value";
    static final String o = "key_value_type";
    static final String p = "key_op_type";
    @NonNull
    Bundle q;

    a() {
        this.q = new Bundle();
    }

    public a(@NonNull Bundle bundle) {
        this.q = bundle;
    }

    private String a() {
        return this.q.getString(m, (String) null);
    }

    private int b() {
        return this.q.getInt(o, 0);
    }

    private long b(long j2) {
        return this.q.getLong(n, j2);
    }

    private boolean b(boolean z) {
        return this.q.getBoolean(n, z);
    }

    private int c() {
        return this.q.getInt(p, 0);
    }

    private a c(int i2) {
        this.q.putInt(o, i2);
        return this;
    }

    static a c(String str) {
        return new a().a(str).a(1);
    }

    private float d() {
        return this.q.getFloat(n);
    }

    private int d(int i2) {
        return this.q.getInt(n, i2);
    }

    static a d(String str) {
        return new a().a(str).a(2);
    }

    private String e(String str) {
        return this.q.getString(n, str);
    }

    private Set<String> e() {
        ArrayList<String> stringArrayList = this.q.getStringArrayList(n);
        if (stringArrayList == null) {
            return null;
        }
        return new HashSet(stringArrayList);
    }

    private Bundle f() {
        return this.q;
    }

    private static a f(String str) {
        return new a().a(str).a(4);
    }

    private static a g() {
        return new a().a(3);
    }

    public final a a(float f2) {
        this.q.putInt(o, 4);
        this.q.putFloat(n, f2);
        return this;
    }

    public final a a(int i2) {
        this.q.putInt(p, i2);
        return this;
    }

    public final a a(long j2) {
        this.q.putInt(o, 3);
        this.q.putLong(n, j2);
        return this;
    }

    public final a a(String str) {
        this.q.putString(m, str);
        return this;
    }

    public final a a(Set<String> set) {
        this.q.putInt(o, 6);
        this.q.putStringArrayList(n, set == null ? null : new ArrayList(set));
        return this;
    }

    public final a a(boolean z) {
        this.q.putInt(o, 5);
        this.q.putBoolean(n, z);
        return this;
    }

    public final a b(int i2) {
        this.q.putInt(o, 2);
        this.q.putInt(n, i2);
        return this;
    }

    public final a b(String str) {
        this.q.putInt(o, 1);
        this.q.putString(n, str);
        return this;
    }
}
