package mobi.oneway.export.d;

import java.io.File;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private f f4149a;

    /* renamed from: b  reason: collision with root package name */
    private int f4150b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f4151c;
    private Map<String, List<String>> d;
    private Throwable e;
    private long f;
    private File g;

    b(f fVar) {
        a(fVar);
    }

    public String a() {
        return h().f();
    }

    public String a(String str) {
        List list;
        if (this.d == null || (list = this.d.get(str)) == null || list.isEmpty()) {
            return null;
        }
        return (String) list.get(0);
    }

    public b a(Throwable th) {
        this.e = th;
        return this;
    }

    public void a(int i) {
        this.f4150b = i;
    }

    public void a(long j) {
        this.f = j;
    }

    public void a(File file) {
        this.g = file;
    }

    public void a(Map<String, List<String>> map) {
        this.d = map;
    }

    public void a(f fVar) {
        this.f4149a = fVar;
    }

    public void a(byte[] bArr) {
        this.f4151c = bArr;
    }

    public boolean b() {
        return this.e == null;
    }

    public byte[] c() {
        return this.f4151c;
    }

    public String d() {
        if (this.f4151c == null) {
            return null;
        }
        return new String(this.f4151c);
    }

    public JSONObject e() {
        return new JSONObject(d());
    }

    public long f() {
        if (this.f4151c != null) {
            return (long) this.f4151c.length;
        }
        if (this.g != null) {
            return this.g.length();
        }
        return -1;
    }

    public File g() {
        return this.g;
    }

    public f h() {
        return this.f4149a;
    }

    public Map<String, List<String>> i() {
        return this.d;
    }

    public long j() {
        return this.f;
    }

    public boolean k() {
        return this.f4149a != null && this.f4149a.e();
    }

    public int l() {
        return this.f4150b;
    }

    public Throwable m() {
        return this.e;
    }
}
