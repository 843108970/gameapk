package com.bumptech.glide.load.b.b;

import com.bumptech.glide.load.b.b.a;
import java.io.File;

public class d implements a.C0012a {

    /* renamed from: c  reason: collision with root package name */
    private final long f1062c;
    private final a d;

    public interface a {
        File a();
    }

    public d(a aVar, long j) {
        this.f1062c = j;
        this.d = aVar;
    }

    private d(final String str, long j) {
        this((a) new a() {
            public final File a() {
                return new File(str);
            }
        }, j);
    }

    private d(final String str, final String str2, long j) {
        this((a) new a() {
            public final File a() {
                return new File(str, str2);
            }
        }, j);
    }

    public final a a() {
        File a2 = this.d.a();
        if (a2 == null) {
            return null;
        }
        if (a2.mkdirs() || (a2.exists() && a2.isDirectory())) {
            return new e(a2, this.f1062c);
        }
        return null;
    }
}
