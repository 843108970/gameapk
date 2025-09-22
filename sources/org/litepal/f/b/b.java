package org.litepal.f.b;

import android.text.TextUtils;
import net.grandcentrix.tray.provider.TrayContract;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f4815a;

    /* renamed from: b  reason: collision with root package name */
    public String f4816b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4817c = true;
    public boolean d = false;
    public String e = "";

    private String a() {
        return this.f4815a;
    }

    private void a(boolean z) {
        this.f4817c = z;
    }

    private String b() {
        return this.f4816b;
    }

    private void b(String str) {
        this.f4815a = str;
    }

    private void b(boolean z) {
        this.d = z;
    }

    private void c(String str) {
        this.f4816b = str;
    }

    private boolean c() {
        return this.f4817c;
    }

    private boolean d() {
        return this.d;
    }

    private String e() {
        return this.e;
    }

    private boolean f() {
        return TrayContract.Preferences.Columns.ID.equalsIgnoreCase(this.f4815a) || "id".equalsIgnoreCase(this.f4815a);
    }

    public final void a(String str) {
        if (!"text".equalsIgnoreCase(this.f4816b)) {
            this.e = str;
        } else if (!TextUtils.isEmpty(str)) {
            this.e = "'" + str + "'";
        }
    }
}
