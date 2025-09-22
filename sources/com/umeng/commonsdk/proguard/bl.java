package com.umeng.commonsdk.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class bl extends bn {

    /* renamed from: a  reason: collision with root package name */
    protected InputStream f3751a = null;

    /* renamed from: b  reason: collision with root package name */
    protected OutputStream f3752b = null;

    protected bl() {
    }

    public bl(InputStream inputStream) {
        this.f3751a = inputStream;
    }

    public bl(InputStream inputStream, OutputStream outputStream) {
        this.f3751a = inputStream;
        this.f3752b = outputStream;
    }

    public bl(OutputStream outputStream) {
        this.f3752b = outputStream;
    }

    public int a(byte[] bArr, int i, int i2) throws bo {
        if (this.f3751a == null) {
            throw new bo(1, "Cannot read from null inputStream");
        }
        try {
            int read = this.f3751a.read(bArr, i, i2);
            if (read >= 0) {
                return read;
            }
            throw new bo(4);
        } catch (IOException e) {
            throw new bo(0, (Throwable) e);
        }
    }

    public boolean a() {
        return true;
    }

    public void b() throws bo {
    }

    public void b(byte[] bArr, int i, int i2) throws bo {
        if (this.f3752b == null) {
            throw new bo(1, "Cannot write to null outputStream");
        }
        try {
            this.f3752b.write(bArr, i, i2);
        } catch (IOException e) {
            throw new bo(0, (Throwable) e);
        }
    }

    public void c() {
        if (this.f3751a != null) {
            try {
                this.f3751a.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.f3751a = null;
        }
        if (this.f3752b != null) {
            try {
                this.f3752b.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f3752b = null;
        }
    }

    public void d() throws bo {
        if (this.f3752b == null) {
            throw new bo(1, "Cannot flush null outputStream");
        }
        try {
            this.f3752b.flush();
        } catch (IOException e) {
            throw new bo(0, (Throwable) e);
        }
    }
}
