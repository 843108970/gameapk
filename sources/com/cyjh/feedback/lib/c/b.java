package com.cyjh.feedback.lib.c;

import android.text.TextUtils;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f2400a;

    /* renamed from: b  reason: collision with root package name */
    public String f2401b;

    /* renamed from: c  reason: collision with root package name */
    public String f2402c;
    public int d;
    private boolean e;

    private String a() {
        return this.f2400a;
    }

    private void a(int i) {
        this.d = i;
    }

    private void a(boolean z) {
        this.e = z;
    }

    private void b(String str) {
        this.f2402c = str;
    }

    private boolean b() {
        return this.e;
    }

    private int c() {
        return this.d;
    }

    private void c(String str) {
        this.f2401b = str;
    }

    private String d() {
        return this.f2402c;
    }

    private String e() {
        return this.f2401b;
    }

    public final void a(String str) {
        this.f2400a = str;
        if (TextUtils.isEmpty(this.f2401b)) {
            this.f2401b = str.substring(str.lastIndexOf("/") + 1);
        }
    }

    public final String toString() {
        return "FolderBean{dirPath='" + this.f2400a + '\'' + ", dirName='" + this.f2401b + '\'' + ", firstImgPath='" + this.f2402c + '\'' + ", dirCount=" + this.d + ", isSelect=" + this.e + '}';
    }
}
