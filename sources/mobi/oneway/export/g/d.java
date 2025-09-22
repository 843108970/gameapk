package mobi.oneway.export.g;

import java.io.OutputStream;
import org.apache.commons.io.IOUtils;

public class d extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private OutputStream f4212a;

    /* renamed from: b  reason: collision with root package name */
    private int f4213b;

    /* renamed from: c  reason: collision with root package name */
    private int f4214c;
    private int d;
    private int e;

    public d(OutputStream outputStream) {
        this(outputStream, 76);
    }

    public d(OutputStream outputStream, int i) {
        this.f4212a = null;
        this.f4213b = 0;
        this.f4214c = 0;
        this.d = 0;
        this.e = 0;
        this.f4212a = outputStream;
        this.e = i;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.f4214c > 0) {
            if (this.e > 0 && this.d == this.e) {
                this.f4212a.write(IOUtils.LINE_SEPARATOR_WINDOWS.getBytes("UTF-8"));
                this.d = 0;
            }
            char charAt = q.f4229a.charAt((this.f4213b << 8) >>> 26);
            char charAt2 = q.f4229a.charAt((this.f4213b << 14) >>> 26);
            char charAt3 = this.f4214c < 2 ? q.f4230b : q.f4229a.charAt((this.f4213b << 20) >>> 26);
            char charAt4 = this.f4214c < 3 ? q.f4230b : q.f4229a.charAt((this.f4213b << 26) >>> 26);
            this.f4212a.write(charAt);
            this.f4212a.write(charAt2);
            this.f4212a.write(charAt3);
            this.f4212a.write(charAt4);
            this.d += 4;
            this.f4214c = 0;
            this.f4213b = 0;
        }
    }

    public void close() {
        a();
        this.f4212a.close();
    }

    public void write(int i) {
        this.f4213b = ((i & 255) << (16 - (this.f4214c * 8))) | this.f4213b;
        this.f4214c++;
        if (this.f4214c == 3) {
            a();
        }
    }
}
