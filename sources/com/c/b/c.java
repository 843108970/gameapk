package com.c.b;

import com.c.d.a;
import java.io.Closeable;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f1543a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f1544b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final int f1545c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = -101;
    public static final int g = -102;
    public static final int h = -103;
    public int i = 200;
    String j = "OK";
    String k;
    byte[] l;
    File m;
    Date n = new Date();
    boolean o;
    DefaultHttpClient p;
    long q;
    public int r = 1;
    long s = System.currentTimeMillis();
    boolean t;
    public boolean u;
    boolean v;
    public String w;
    HttpContext x;
    Header[] y;
    Closeable z;

    public c() {
    }

    private c(int i2, String str) {
        this.i = i2;
        this.j = str;
    }

    private c a(int i2) {
        this.r = i2;
        return this;
    }

    private c a(File file) {
        this.m = file;
        return this;
    }

    private c a(Date date) {
        this.n = date;
        return this;
    }

    private c a(DefaultHttpClient defaultHttpClient) {
        this.p = defaultHttpClient;
        return this;
    }

    private c a(HttpContext httpContext) {
        this.x = httpContext;
        return this;
    }

    private c a(boolean z2) {
        this.o = z2;
        return this;
    }

    private c a(byte[] bArr) {
        this.l = bArr;
        return this;
    }

    private c a(Header[] headerArr) {
        this.y = headerArr;
        return this;
    }

    private void a(Closeable closeable) {
        this.z = closeable;
    }

    private boolean a(long j2) {
        return System.currentTimeMillis() - this.n.getTime() > j2 && this.r != 1;
    }

    private c b(int i2) {
        this.i = i2;
        return this;
    }

    private c b(String str) {
        this.w = str;
        return this;
    }

    private c c() {
        this.v = true;
        return this;
    }

    private c c(String str) {
        this.j = str;
        return this;
    }

    private c d() {
        this.q = System.currentTimeMillis() - this.s;
        this.t = false;
        b();
        return this;
    }

    private c d(String str) {
        this.k = str;
        return this;
    }

    private c e() {
        this.u = true;
        return this;
    }

    private boolean f() {
        return this.t;
    }

    private boolean g() {
        return this.v;
    }

    private boolean h() {
        return this.u;
    }

    private int i() {
        return this.i;
    }

    private String j() {
        return this.j;
    }

    private String k() {
        return this.k;
    }

    private byte[] l() {
        return this.l;
    }

    private File m() {
        return this.m;
    }

    private Date n() {
        return this.n;
    }

    private boolean o() {
        return this.o;
    }

    private DefaultHttpClient p() {
        return this.p;
    }

    private long q() {
        return this.q;
    }

    private int r() {
        return this.r;
    }

    private String s() {
        return this.w;
    }

    private List<Cookie> t() {
        if (this.x == null) {
            return Collections.emptyList();
        }
        CookieStore cookieStore = (CookieStore) this.x.getAttribute("http.cookie-store");
        return cookieStore == null ? Collections.emptyList() : cookieStore.getCookies();
    }

    private List<Header> u() {
        return this.y == null ? Collections.emptyList() : Arrays.asList(this.y);
    }

    public final c a() {
        this.q = System.currentTimeMillis() - this.s;
        this.t = true;
        this.v = false;
        return this;
    }

    public final String a(String str) {
        if (this.y == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.y.length; i2++) {
            if (str.equalsIgnoreCase(this.y[i2].getName())) {
                return this.y[i2].getValue();
            }
        }
        return null;
    }

    public final void b() {
        a.a(this.z);
        this.z = null;
    }
}
