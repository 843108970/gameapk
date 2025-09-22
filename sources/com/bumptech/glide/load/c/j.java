package com.bumptech.glide.load.c;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j implements h {

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, List<i>> f1230c;
    private volatile Map<String, String> d;

    public static final class a {

        /* renamed from: c  reason: collision with root package name */
        private static final String f1231c = "User-Agent";
        private static final String d;
        private static final Map<String, List<i>> e;

        /* renamed from: a  reason: collision with root package name */
        boolean f1232a = true;

        /* renamed from: b  reason: collision with root package name */
        Map<String, List<i>> f1233b = e;
        private boolean f = true;

        static {
            String property = System.getProperty("http.agent");
            if (!TextUtils.isEmpty(property)) {
                int length = property.length();
                StringBuilder sb = new StringBuilder(property.length());
                for (int i = 0; i < length; i++) {
                    char charAt = property.charAt(i);
                    if ((charAt <= 31 && charAt != 9) || charAt >= 127) {
                        charAt = '?';
                    }
                    sb.append(charAt);
                }
                property = sb.toString();
            }
            d = property;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(d)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(d)));
            }
            e = Collections.unmodifiableMap(hashMap);
        }

        private a a(String str, i iVar) {
            if (this.f && "User-Agent".equalsIgnoreCase(str)) {
                return b(str, iVar);
            }
            a();
            a(str).add(iVar);
            return this;
        }

        private a a(String str, String str2) {
            b bVar = new b(str2);
            if (this.f && "User-Agent".equalsIgnoreCase(str)) {
                return b(str, (i) bVar);
            }
            a();
            a(str).add(bVar);
            return this;
        }

        private List<i> a(String str) {
            List<i> list = this.f1233b.get(str);
            if (list != null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            this.f1233b.put(str, arrayList);
            return arrayList;
        }

        private void a() {
            if (this.f1232a) {
                this.f1232a = false;
                HashMap hashMap = new HashMap(this.f1233b.size());
                for (Map.Entry next : this.f1233b.entrySet()) {
                    hashMap.put(next.getKey(), new ArrayList((Collection) next.getValue()));
                }
                this.f1233b = hashMap;
            }
        }

        private a b(String str, i iVar) {
            a();
            if (iVar == null) {
                this.f1233b.remove(str);
            } else {
                List<i> a2 = a(str);
                a2.clear();
                a2.add(iVar);
            }
            if (this.f && "User-Agent".equalsIgnoreCase(str)) {
                this.f = false;
            }
            return this;
        }

        private a b(String str, String str2) {
            return b(str, (i) str2 == null ? null : new b(str2));
        }

        private j b() {
            this.f1232a = true;
            return new j(this.f1233b);
        }

        private Map<String, List<i>> c() {
            HashMap hashMap = new HashMap(this.f1233b.size());
            for (Map.Entry next : this.f1233b.entrySet()) {
                hashMap.put(next.getKey(), new ArrayList((Collection) next.getValue()));
            }
            return hashMap;
        }

        @VisibleForTesting
        private static String d() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char charAt = property.charAt(i);
                if ((charAt <= 31 && charAt != 9) || charAt >= 127) {
                    charAt = '?';
                }
                sb.append(charAt);
            }
            return sb.toString();
        }
    }

    static final class b implements i {

        /* renamed from: a  reason: collision with root package name */
        private final String f1234a;

        b(String str) {
            this.f1234a = str;
        }

        public final String a() {
            return this.f1234a;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f1234a.equals(((b) obj).f1234a);
            }
            return false;
        }

        public final int hashCode() {
            return this.f1234a.hashCode();
        }

        public final String toString() {
            return "StringHeaderFactory{value='" + this.f1234a + '\'' + '}';
        }
    }

    j(Map<String, List<i>> map) {
        this.f1230c = Collections.unmodifiableMap(map);
    }

    @NonNull
    private static String a(@NonNull List<i> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String a2 = list.get(i).a();
            if (!TextUtils.isEmpty(a2)) {
                sb.append(a2);
                if (i != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f1230c.entrySet()) {
            String a2 = a((List) next.getValue());
            if (!TextUtils.isEmpty(a2)) {
                hashMap.put(next.getKey(), a2);
            }
        }
        return hashMap;
    }

    public final Map<String, String> a() {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry next : this.f1230c.entrySet()) {
                        String a2 = a((List) next.getValue());
                        if (!TextUtils.isEmpty(a2)) {
                            hashMap.put(next.getKey(), a2);
                        }
                    }
                    this.d = Collections.unmodifiableMap(hashMap);
                }
            }
        }
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f1230c.equals(((j) obj).f1230c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1230c.hashCode();
    }

    public final String toString() {
        return "LazyHeaders{headers=" + this.f1230c + '}';
    }
}
