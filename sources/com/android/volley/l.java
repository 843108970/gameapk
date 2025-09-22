package com.android.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.volley.b;
import com.android.volley.m;
import com.android.volley.n;
import com.android.volley.t;
import com.cyjh.common.util.s;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

public abstract class l<T> implements Comparable<l<T>> {
    private static final String m = "UTF-8";
    private static final long p = 3000;

    /* renamed from: a  reason: collision with root package name */
    public final int f486a;

    /* renamed from: b  reason: collision with root package name */
    public final String f487b;

    /* renamed from: c  reason: collision with root package name */
    final int f488c;
    final n.a d;
    Integer e;
    m f;
    protected boolean g;
    public boolean h;
    boolean i;
    public p j;
    public b.a k;
    public Object l;
    /* access modifiers changed from: private */
    public final t.a n;
    private long o;

    public interface a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f492a = -1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f493b = 0;

        /* renamed from: c  reason: collision with root package name */
        public static final int f494c = 1;
        public static final int d = 2;
        public static final int e = 3;
        public static final int f = 4;
        public static final int g = 5;
        public static final int h = 6;
        public static final int i = 7;
    }

    public enum b {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public l(int i2, String str, n.a aVar) {
        Uri parse;
        String host;
        this.n = t.a.f505a ? new t.a() : null;
        this.g = true;
        int i3 = 0;
        this.h = false;
        this.i = false;
        this.o = 0;
        this.k = null;
        this.f486a = i2;
        this.f487b = str;
        this.d = aVar;
        this.j = new d();
        if (!(TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null)) {
            i3 = host.hashCode();
        }
        this.f488c = i3;
    }

    @Deprecated
    private l(String str, n.a aVar) {
        this(-1, str, aVar);
    }

    private l<?> a(int i2) {
        this.e = Integer.valueOf(i2);
        return this;
    }

    private l<?> a(b.a aVar) {
        this.k = aVar;
        return this;
    }

    private l<?> a(m mVar) {
        this.f = mVar;
        return this;
    }

    private l<?> a(p pVar) {
        this.j = pVar;
        return this;
    }

    protected static s a(s sVar) {
        return sVar;
    }

    private static byte[] a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry next : map.entrySet()) {
                sb.append(URLEncoder.encode((String) next.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode((String) next.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Encoding not supported: " + str, e2);
        }
    }

    private int b(l<T> lVar) {
        b h2 = h();
        b h3 = lVar.h();
        return h2 == h3 ? this.e.intValue() - lVar.e.intValue() : h3.ordinal() - h2.ordinal();
    }

    private l<?> b(Object obj) {
        this.l = obj;
        return this;
    }

    private void b(s sVar) {
        if (this.d != null) {
            this.d.a(sVar);
        }
    }

    private static int c(String str) {
        Uri parse;
        String host;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    private int j() {
        return this.f486a;
    }

    private Object k() {
        return this.l;
    }

    private n.a l() {
        return this.d;
    }

    private int m() {
        return this.f488c;
    }

    private int n() {
        if (this.e != null) {
            return this.e.intValue();
        }
        throw new IllegalStateException("getSequence called before setSequence");
    }

    private String o() {
        return this.f487b;
    }

    private String p() {
        return this.f487b;
    }

    private b.a q() {
        return this.k;
    }

    private void r() {
        this.h = true;
    }

    @Deprecated
    private Map<String, String> s() throws a {
        return e();
    }

    @Deprecated
    private static String t() {
        return "UTF-8";
    }

    private static String u() {
        return "UTF-8";
    }

    private l<?> v() {
        this.g = false;
        return this;
    }

    private boolean w() {
        return this.g;
    }

    private p x() {
        return this.j;
    }

    private void y() {
        this.i = true;
    }

    private boolean z() {
        return this.i;
    }

    public abstract n<T> a(i iVar);

    public abstract void a(T t);

    public final void a(String str) {
        if (t.a.f505a) {
            this.n.a(str, Thread.currentThread().getId());
        } else if (this.o == 0) {
            this.o = SystemClock.elapsedRealtime();
        }
    }

    public boolean a() {
        return this.h;
    }

    public Map<String, String> b() throws a {
        return Collections.emptyMap();
    }

    /* access modifiers changed from: package-private */
    public final void b(final String str) {
        if (this.f != null) {
            m mVar = this.f;
            synchronized (mVar.f496b) {
                mVar.f496b.remove(this);
            }
            synchronized (mVar.d) {
                Iterator<m.b> it = mVar.d.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
            if (this.g) {
                synchronized (mVar.f495a) {
                    String str2 = this.f487b;
                    Queue remove = mVar.f495a.remove(str2);
                    if (remove != null) {
                        if (t.f504b) {
                            t.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), str2);
                        }
                        mVar.f497c.addAll(remove);
                    }
                }
            }
        }
        if (t.a.f505a) {
            final long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        l.this.n.a(str, id);
                        l.this.n.a(toString());
                    }
                });
                return;
            }
            this.n.a(str, id);
            this.n.a(toString());
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.o;
        if (elapsedRealtime >= p) {
            t.b("%d ms: %s", Long.valueOf(elapsedRealtime), toString());
        }
    }

    @Deprecated
    public String c() {
        return f();
    }

    public /* synthetic */ int compareTo(Object obj) {
        l lVar = (l) obj;
        b h2 = h();
        b h3 = lVar.h();
        return h2 == h3 ? this.e.intValue() - lVar.e.intValue() : h3.ordinal() - h2.ordinal();
    }

    @Deprecated
    public byte[] d() throws a {
        Map<String, String> e2 = e();
        if (e2 == null || e2.size() <= 0) {
            return null;
        }
        return a(e2, "UTF-8");
    }

    /* access modifiers changed from: protected */
    public Map<String, String> e() throws a {
        return null;
    }

    public String f() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    public byte[] g() throws a {
        Map<String, String> e2 = e();
        if (e2 == null || e2.size() <= 0) {
            return null;
        }
        return a(e2, "UTF-8");
    }

    public b h() {
        return b.NORMAL;
    }

    public final int i() {
        return this.j.a();
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(this.f488c);
        StringBuilder sb = new StringBuilder();
        sb.append(this.h ? "[X] " : "[ ] ");
        sb.append(this.f487b);
        sb.append(s.a.f1696a);
        sb.append(str);
        sb.append(s.a.f1696a);
        sb.append(h());
        sb.append(s.a.f1696a);
        sb.append(this.e);
        return sb.toString();
    }
}
