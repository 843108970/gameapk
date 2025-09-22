package com.googlecode.leptonica.android;

import android.graphics.Rect;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class Pixa implements Iterable<Pix> {
    private static final String e = "Pixa";

    /* renamed from: a  reason: collision with root package name */
    final long f3383a;

    /* renamed from: b  reason: collision with root package name */
    final int f3384b;

    /* renamed from: c  reason: collision with root package name */
    final int f3385c;
    boolean d = false;

    private class a implements Iterator<Pix> {

        /* renamed from: b  reason: collision with root package name */
        private int f3387b;

        private a() {
            this.f3387b = 0;
        }

        /* synthetic */ a(Pixa pixa, byte b2) {
            this();
        }

        private Pix a() {
            Pixa pixa = Pixa.this;
            int i = this.f3387b;
            this.f3387b = i + 1;
            if (pixa.d) {
                throw new IllegalStateException();
            }
            long nativeGetPix = Pixa.nativeGetPix(pixa.f3383a, i);
            if (nativeGetPix == 0) {
                return null;
            }
            return new Pix(nativeGetPix);
        }

        public final boolean hasNext() {
            Pixa pixa = Pixa.this;
            if (pixa.d) {
                throw new IllegalStateException();
            }
            int nativeGetCount = Pixa.nativeGetCount(pixa.f3383a);
            return nativeGetCount > 0 && this.f3387b < nativeGetCount;
        }

        public final /* synthetic */ Object next() {
            Pixa pixa = Pixa.this;
            int i = this.f3387b;
            this.f3387b = i + 1;
            if (pixa.d) {
                throw new IllegalStateException();
            }
            long nativeGetPix = Pixa.nativeGetPix(pixa.f3383a, i);
            if (nativeGetPix == 0) {
                return null;
            }
            return new Pix(nativeGetPix);
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static {
        System.loadLibrary("jpgt");
        System.loadLibrary("pngt");
        System.loadLibrary("lept");
    }

    public Pixa(long j, int i, int i2) {
        this.f3383a = j;
        this.f3384b = i;
        this.f3385c = i2;
    }

    private long a() {
        if (!this.d) {
            return this.f3383a;
        }
        throw new IllegalStateException();
    }

    private static Pixa a(int i) {
        long nativeCreate = (long) nativeCreate(i);
        if (nativeCreate != 0) {
            return new Pixa(nativeCreate, 0, 0);
        }
        throw new OutOfMemoryError();
    }

    private Pixa a(int i, int i2) {
        if (this.d) {
            throw new IllegalStateException();
        }
        int nativeSort = nativeSort(this.f3383a, i, i2);
        if (nativeSort != 0) {
            return new Pixa((long) nativeSort, this.f3384b, this.f3385c);
        }
        throw new OutOfMemoryError();
    }

    private void a(int i, Pix pix, Box box) {
        if (this.d) {
            throw new IllegalStateException();
        }
        nativeReplacePix(this.f3383a, i, pix.a(), box.a());
    }

    private void a(Box box, int i) {
        if (this.d) {
            throw new IllegalStateException();
        }
        nativeAddBox(this.f3383a, box.a(), i);
    }

    private void a(Pix pix, int i) {
        if (this.d) {
            throw new IllegalStateException();
        }
        nativeAddPix(this.f3383a, pix.a(), i);
    }

    private void a(Pix pix, Box box, int i) {
        if (this.d) {
            throw new IllegalStateException();
        }
        nativeAdd(this.f3383a, pix.a(), box.a(), i);
    }

    private boolean a(int i, int[] iArr) {
        if (!this.d) {
            return nativeGetBoxGeometry(this.f3383a, i, iArr);
        }
        throw new IllegalStateException();
    }

    private boolean a(Pixa pixa) {
        if (!this.d) {
            return nativeJoin(this.f3383a, pixa.f3383a);
        }
        throw new IllegalStateException();
    }

    private boolean a(File file) {
        if (!this.d) {
            return nativeWriteToFileRandomCmap(this.f3383a, file.getAbsolutePath(), this.f3384b, this.f3385c);
        }
        throw new IllegalStateException();
    }

    private Pixa b() {
        if (this.d) {
            throw new IllegalStateException();
        }
        int nativeCopy = nativeCopy(this.f3383a);
        if (nativeCopy != 0) {
            return new Pixa((long) nativeCopy, this.f3384b, this.f3385c);
        }
        throw new OutOfMemoryError();
    }

    private static Pixa b(int i) {
        long nativeCreate = (long) nativeCreate(i);
        if (nativeCreate != 0) {
            return new Pixa(nativeCreate, 0, 0);
        }
        throw new OutOfMemoryError();
    }

    private void b(int i, int i2) {
        if (this.d) {
            throw new IllegalStateException();
        }
        nativeMergeAndReplacePix(this.f3383a, i, i2);
    }

    private int c() {
        if (!this.d) {
            return nativeGetCount(this.f3383a);
        }
        throw new IllegalStateException();
    }

    private Box c(int i) {
        if (this.d) {
            throw new IllegalStateException();
        }
        long nativeGetBox = nativeGetBox(this.f3383a, i);
        if (nativeGetBox == 0) {
            return null;
        }
        return new Box(nativeGetBox);
    }

    private Pix d(int i) {
        if (this.d) {
            throw new IllegalStateException();
        }
        long nativeGetPix = nativeGetPix(this.f3383a, i);
        if (nativeGetPix == 0) {
            return null;
        }
        return new Pix(nativeGetPix);
    }

    private synchronized void d() {
        if (!this.d) {
            nativeDestroy(this.f3383a);
            this.d = true;
        }
    }

    private int e() {
        if (!this.d) {
            return this.f3384b;
        }
        throw new IllegalStateException();
    }

    private int[] e(int i) {
        if (this.d) {
            throw new IllegalStateException();
        }
        int[] iArr = new int[4];
        if (a(i, iArr)) {
            return iArr;
        }
        return null;
    }

    private int f() {
        if (!this.d) {
            return this.f3385c;
        }
        throw new IllegalStateException();
    }

    private Rect f(int i) {
        if (this.d) {
            throw new IllegalStateException();
        }
        int[] iArr = new int[4];
        if (!a(i, iArr)) {
            iArr = null;
        }
        if (iArr == null) {
            return null;
        }
        int i2 = iArr[0];
        int i3 = iArr[1];
        return new Rect(i2, i3, iArr[2] + i2, iArr[3] + i3);
    }

    private Rect g() {
        if (!this.d) {
            return new Rect(0, 0, this.f3384b, this.f3385c);
        }
        throw new IllegalStateException();
    }

    private ArrayList<Rect> h() {
        if (this.d) {
            throw new IllegalStateException();
        }
        int nativeGetCount = nativeGetCount(this.f3383a);
        int[] iArr = new int[4];
        ArrayList<Rect> arrayList = new ArrayList<>(nativeGetCount);
        for (int i = 0; i < nativeGetCount; i++) {
            a(i, iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            arrayList.add(new Rect(i2, i3, iArr[2] + i2, iArr[3] + i3));
        }
        return arrayList;
    }

    private static native void nativeAdd(long j, long j2, long j3, int i);

    private static native void nativeAddBox(long j, long j2, int i);

    private static native void nativeAddPix(long j, long j2, int i);

    private static native int nativeCopy(long j);

    private static native int nativeCreate(int i);

    private static native void nativeDestroy(long j);

    private static native long nativeGetBox(long j, int i);

    private static native boolean nativeGetBoxGeometry(long j, int i, int[] iArr);

    static native int nativeGetCount(long j);

    static native long nativeGetPix(long j, int i);

    private static native boolean nativeJoin(long j, long j2);

    private static native void nativeMergeAndReplacePix(long j, int i, int i2);

    private static native void nativeReplacePix(long j, int i, long j2, long j3);

    private static native int nativeSort(long j, int i, int i2);

    private static native boolean nativeWriteToFileRandomCmap(long j, String str, int i, int i2);

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (!this.d) {
                Log.w(e, "Pixa was not terminated using recycle()");
                d();
            }
        } finally {
            super.finalize();
        }
    }

    public Iterator<Pix> iterator() {
        return new a(this, (byte) 0);
    }
}
