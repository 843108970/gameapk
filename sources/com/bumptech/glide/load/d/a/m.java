package com.bumptech.glide.load.d.a;

import android.support.annotation.NonNull;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.util.i;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class m implements ImageHeaderParser {

    /* renamed from: b  reason: collision with root package name */
    static final int f1306b = 65496;

    /* renamed from: c  reason: collision with root package name */
    static final byte[] f1307c = k.getBytes(Charset.forName("UTF-8"));
    static final int d = 255;
    static final int e = 225;
    private static final String f = "DfltImageHeaderParser";
    private static final int g = 4671814;
    private static final int h = -1991225785;
    private static final int i = 19789;
    private static final int j = 18761;
    private static final String k = "Exif\u0000\u0000";
    private static final int l = 218;
    private static final int m = 217;
    private static final int n = 274;
    private static final int[] o = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    private static final int p = 1380533830;
    private static final int q = 1464156752;
    private static final int r = 1448097792;
    private static final int s = -256;
    private static final int t = 255;
    private static final int u = 88;
    private static final int v = 76;
    private static final int w = 16;
    private static final int x = 8;

    private static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f1308a;

        a(ByteBuffer byteBuffer) {
            this.f1308a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public final int a() {
            return ((c() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (c() & 255);
        }

        public final int a(byte[] bArr, int i) {
            int min = Math.min(i, this.f1308a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f1308a.get(bArr, 0, min);
            return min;
        }

        public final long a(long j) {
            int min = (int) Math.min((long) this.f1308a.remaining(), j);
            this.f1308a.position(this.f1308a.position() + min);
            return (long) min;
        }

        public final short b() {
            return (short) (c() & 255);
        }

        public final int c() {
            if (this.f1308a.remaining() <= 0) {
                return -1;
            }
            return this.f1308a.get();
        }
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        final ByteBuffer f1309a;

        b(byte[] bArr, int i) {
            this.f1309a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        private int a() {
            return this.f1309a.remaining();
        }

        private void a(ByteOrder byteOrder) {
            this.f1309a.order(byteOrder);
        }

        private boolean a(int i, int i2) {
            return this.f1309a.remaining() - i >= i2;
        }

        /* access modifiers changed from: package-private */
        public final int a(int i) {
            if (a(i, 4)) {
                return this.f1309a.getInt(i);
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public final short b(int i) {
            if (a(i, 2)) {
                return this.f1309a.getShort(i);
            }
            return -1;
        }
    }

    private interface c {
        int a() throws IOException;

        int a(byte[] bArr, int i) throws IOException;

        long a(long j) throws IOException;

        short b() throws IOException;

        int c() throws IOException;
    }

    private static final class d implements c {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f1310a;

        d(InputStream inputStream) {
            this.f1310a = inputStream;
        }

        public final int a() throws IOException {
            return ((this.f1310a.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (this.f1310a.read() & 255);
        }

        public final int a(byte[] bArr, int i) throws IOException {
            int i2 = i;
            while (i2 > 0) {
                int read = this.f1310a.read(bArr, i - i2, i2);
                if (read == -1) {
                    break;
                }
                i2 -= read;
            }
            return i - i2;
        }

        public final long a(long j) throws IOException {
            if (j < 0) {
                return 0;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f1310a.skip(j2);
                if (skip <= 0) {
                    if (this.f1310a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }

        public final short b() throws IOException {
            return (short) (this.f1310a.read() & 255);
        }

        public final int c() throws IOException {
            return this.f1310a.read();
        }
    }

    private static int a(int i2, int i3) {
        return i2 + 2 + (i3 * 12);
    }

    private static int a(b bVar) {
        ByteOrder byteOrder;
        String str;
        String str2;
        StringBuilder sb;
        short b2 = bVar.b(6);
        if (b2 != j) {
            if (b2 != i && Log.isLoggable(f, 3)) {
                Log.d(f, "Unknown endianness = " + b2);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        bVar.f1309a.order(byteOrder);
        int a2 = bVar.a(10) + 6;
        short b3 = bVar.b(a2);
        for (int i2 = 0; i2 < b3; i2++) {
            int i3 = a2 + 2 + (i2 * 12);
            short b4 = bVar.b(i3);
            if (b4 == 274) {
                short b5 = bVar.b(i3 + 2);
                if (b5 > 0 && b5 <= 12) {
                    int a3 = bVar.a(i3 + 4);
                    if (a3 >= 0) {
                        if (Log.isLoggable(f, 3)) {
                            Log.d(f, "Got tagIndex=" + i2 + " tagType=" + b4 + " formatCode=" + b5 + " componentCount=" + a3);
                        }
                        int i4 = a3 + o[b5];
                        if (i4 <= 4) {
                            int i5 = i3 + 8;
                            if (i5 < 0 || i5 > bVar.f1309a.remaining()) {
                                if (Log.isLoggable(f, 3)) {
                                    Log.d(f, "Illegal tagValueOffset=" + i5 + " tagType=" + b4);
                                }
                            } else if (i4 >= 0 && i4 + i5 <= bVar.f1309a.remaining()) {
                                return bVar.b(i5);
                            } else {
                                if (Log.isLoggable(f, 3)) {
                                    str2 = f;
                                    str = "Illegal number of bytes for TI tag data tagType=" + b4;
                                    Log.d(str2, str);
                                }
                            }
                        } else if (Log.isLoggable(f, 3)) {
                            str2 = f;
                            sb = new StringBuilder("Got byte count > 4, not orientation, continuing, formatCode=");
                        }
                    } else if (Log.isLoggable(f, 3)) {
                        str2 = f;
                        str = "Negative tiff component count";
                        Log.d(str2, str);
                    }
                } else if (Log.isLoggable(f, 3)) {
                    str2 = f;
                    sb = new StringBuilder("Got invalid format code = ");
                }
                sb.append(b5);
                str = sb.toString();
                Log.d(str2, str);
            }
        }
        return -1;
    }

    private static int a(c cVar, com.bumptech.glide.load.b.a.b bVar) throws IOException {
        int a2 = cVar.a();
        int i2 = -1;
        if (!((a2 & f1306b) == f1306b || a2 == i || a2 == j)) {
            if (Log.isLoggable(f, 3)) {
                Log.d(f, "Parser doesn't handle magic number: " + a2);
            }
            return -1;
        }
        int b2 = b(cVar);
        if (b2 == -1) {
            if (Log.isLoggable(f, 3)) {
                Log.d(f, "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        byte[] bArr = (byte[]) bVar.a(b2, byte[].class);
        try {
            int a3 = cVar.a(bArr, b2);
            if (a3 != b2) {
                if (Log.isLoggable(f, 3)) {
                    Log.d(f, "Unable to read exif segment data, length: " + b2 + ", actually read: " + a3);
                }
            } else if (a(bArr, b2)) {
                i2 = a(new b(bArr, b2));
            } else if (Log.isLoggable(f, 3)) {
                Log.d(f, "Missing jpeg exif preamble");
            }
            return i2;
        } finally {
            bVar.b(bArr);
        }
    }

    private static int a(c cVar, byte[] bArr, int i2) throws IOException {
        int a2 = cVar.a(bArr, i2);
        if (a2 != i2) {
            if (Log.isLoggable(f, 3)) {
                Log.d(f, "Unable to read exif segment data, length: " + i2 + ", actually read: " + a2);
            }
            return -1;
        } else if (a(bArr, i2)) {
            return a(new b(bArr, i2));
        } else {
            if (Log.isLoggable(f, 3)) {
                Log.d(f, "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    @NonNull
    private static ImageHeaderParser.ImageType a(c cVar) throws IOException {
        int a2 = cVar.a();
        if (a2 == f1306b) {
            return ImageHeaderParser.ImageType.JPEG;
        }
        int a3 = ((a2 << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & 65535);
        if (a3 == h) {
            cVar.a(21);
            return cVar.c() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
        } else if ((a3 >> 8) == g) {
            return ImageHeaderParser.ImageType.GIF;
        } else {
            if (a3 != p) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            cVar.a(4);
            if ((((cVar.a() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & 65535)) != q) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int a4 = ((cVar.a() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & 65535);
            if ((a4 & -256) != r) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i2 = a4 & 255;
            if (i2 == 88) {
                cVar.a(4);
                return (cVar.c() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            } else if (i2 != 76) {
                return ImageHeaderParser.ImageType.WEBP;
            } else {
                cVar.a(4);
                return (cVar.c() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            }
        }
    }

    private static boolean a(int i2) {
        return (i2 & f1306b) == f1306b || i2 == i || i2 == j;
    }

    private static boolean a(byte[] bArr, int i2) {
        boolean z = bArr != null && i2 > f1307c.length;
        if (z) {
            for (int i3 = 0; i3 < f1307c.length; i3++) {
                if (bArr[i3] != f1307c[i3]) {
                    return false;
                }
            }
        }
        return z;
    }

    private static int b(c cVar) throws IOException {
        short b2;
        int a2;
        long j2;
        long a3;
        do {
            short b3 = cVar.b();
            if (b3 != 255) {
                if (Log.isLoggable(f, 3)) {
                    Log.d(f, "Unknown segmentId=" + b3);
                }
                return -1;
            }
            b2 = cVar.b();
            if (b2 == l) {
                return -1;
            }
            if (b2 == 217) {
                if (Log.isLoggable(f, 3)) {
                    Log.d(f, "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            a2 = cVar.a() - 2;
            if (b2 == e) {
                return a2;
            }
            j2 = (long) a2;
            a3 = cVar.a(j2);
        } while (a3 == j2);
        if (Log.isLoggable(f, 3)) {
            Log.d(f, "Unable to skip enough data, type: " + b2 + ", wanted to skip: " + a2 + ", but actually skipped: " + a3);
        }
        return -1;
    }

    public final int a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.b.a.b bVar) throws IOException {
        return a((c) new d((InputStream) i.a(inputStream, "Argument must not be null")), (com.bumptech.glide.load.b.a.b) i.a(bVar, "Argument must not be null"));
    }

    public final int a(@NonNull ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.b.a.b bVar) throws IOException {
        return a((c) new a((ByteBuffer) i.a(byteBuffer, "Argument must not be null")), (com.bumptech.glide.load.b.a.b) i.a(bVar, "Argument must not be null"));
    }

    @NonNull
    public final ImageHeaderParser.ImageType a(@NonNull InputStream inputStream) throws IOException {
        return a((c) new d((InputStream) i.a(inputStream, "Argument must not be null")));
    }

    @NonNull
    public final ImageHeaderParser.ImageType a(@NonNull ByteBuffer byteBuffer) throws IOException {
        return a((c) new a((ByteBuffer) i.a(byteBuffer, "Argument must not be null")));
    }
}
