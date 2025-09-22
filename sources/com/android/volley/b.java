package com.android.volley;

import java.util.Collections;
import java.util.Map;

public interface b {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f463a;

        /* renamed from: b  reason: collision with root package name */
        public String f464b;

        /* renamed from: c  reason: collision with root package name */
        public long f465c;
        public long d;
        public long e;
        public long f;
        public Map<String, String> g = Collections.emptyMap();

        private boolean a() {
            return this.e < System.currentTimeMillis();
        }

        private boolean b() {
            return this.f < System.currentTimeMillis();
        }
    }

    a a(String str);

    void a();

    void a(String str, a aVar);

    void a(String str, boolean z);

    void b();

    void b(String str);
}
