package org.litepal.f.b;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public String f4821a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f4822b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public String f4823c;

    private String a() {
        return this.f4821a;
    }

    private String b() {
        return this.f4823c;
    }

    private List<b> c() {
        return this.f4822b;
    }

    private void c(String str) {
        this.f4821a = str;
    }

    private void d(String str) {
        this.f4823c = str;
    }

    private b e(String str) {
        for (b next : this.f4822b) {
            if (next.f4815a.equalsIgnoreCase(str)) {
                return next;
            }
        }
        return null;
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            int i = 0;
            while (true) {
                if (i >= this.f4822b.size()) {
                    i = -1;
                    break;
                } else if (str.equalsIgnoreCase(this.f4822b.get(i).f4815a)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                this.f4822b.remove(i);
            }
        }
    }

    public final void a(b bVar) {
        this.f4822b.add(bVar);
    }

    public final boolean b(String str) {
        for (int i = 0; i < this.f4822b.size(); i++) {
            if (str.equalsIgnoreCase(this.f4822b.get(i).f4815a)) {
                return true;
            }
        }
        return false;
    }
}
