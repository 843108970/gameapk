package a.a.a;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;

public final class c extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private OutputStream f3a;

    /* renamed from: b  reason: collision with root package name */
    private int f4b;

    /* renamed from: c  reason: collision with root package name */
    private int f5c;
    private int d;
    private int e;

    private c(OutputStream outputStream) {
        this(outputStream, 76);
    }

    public c(OutputStream outputStream, int i) {
        this.f3a = null;
        this.f4b = 0;
        this.f5c = 0;
        this.d = 0;
        this.e = 0;
        this.f3a = outputStream;
        this.e = i;
    }

    /* access modifiers changed from: protected */
    public final void a() throws IOException {
        if (this.f5c > 0) {
            if (this.e > 0 && this.d == this.e) {
                this.f3a.write(IOUtils.LINE_SEPARATOR_WINDOWS.getBytes());
                this.d = 0;
            }
            char charAt = d.f6a.charAt((this.f4b << 8) >>> 26);
            char charAt2 = d.f6a.charAt((this.f4b << 14) >>> 26);
            char charAt3 = this.f5c < 2 ? d.f7b : d.f6a.charAt((this.f4b << 20) >>> 26);
            char charAt4 = this.f5c < 3 ? d.f7b : d.f6a.charAt((this.f4b << 26) >>> 26);
            this.f3a.write(charAt);
            this.f3a.write(charAt2);
            this.f3a.write(charAt3);
            this.f3a.write(charAt4);
            this.d += 4;
            this.f5c = 0;
            this.f4b = 0;
        }
    }

    public final void close() throws IOException {
        a();
        this.f3a.close();
    }

    public final void write(int i) throws IOException {
        this.f4b = ((i & 255) << (16 - (this.f5c * 8))) | this.f4b;
        this.f5c++;
        if (this.f5c == 3) {
            a();
        }
    }
}
