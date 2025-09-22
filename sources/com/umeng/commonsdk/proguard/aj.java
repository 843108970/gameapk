package com.umeng.commonsdk.proguard;

import com.umeng.commonsdk.proguard.at;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class aj {

    /* renamed from: a  reason: collision with root package name */
    private final ByteArrayOutputStream f3693a;

    /* renamed from: b  reason: collision with root package name */
    private final bl f3694b;

    /* renamed from: c  reason: collision with root package name */
    private az f3695c;

    public aj() {
        this(new at.a());
    }

    public aj(bb bbVar) {
        this.f3693a = new ByteArrayOutputStream();
        this.f3694b = new bl((OutputStream) this.f3693a);
        this.f3695c = bbVar.a(this.f3694b);
    }

    public String a(aa aaVar, String str) throws ag {
        try {
            return new String(a(aaVar), str);
        } catch (UnsupportedEncodingException unused) {
            throw new ag("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }

    public byte[] a(aa aaVar) throws ag {
        this.f3693a.reset();
        aaVar.write(this.f3695c);
        return this.f3693a.toByteArray();
    }

    public String b(aa aaVar) throws ag {
        return new String(a(aaVar));
    }
}
