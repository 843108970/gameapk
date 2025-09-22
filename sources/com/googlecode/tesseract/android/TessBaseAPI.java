package com.googlecode.tesseract.android;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.googlecode.leptonica.android.Pix;
import com.googlecode.leptonica.android.Pixa;
import com.googlecode.leptonica.android.ReadFile;
import java.io.File;

public class TessBaseAPI {

    /* renamed from: b  reason: collision with root package name */
    public static final String f3402b = "tessedit_char_whitelist";

    /* renamed from: c  reason: collision with root package name */
    public static final String f3403c = "tessedit_char_blacklist";
    public static final String d = "save_blob_choices";
    public static final String e = "T";
    public static final String f = "F";
    public static final int g = 0;
    @Deprecated
    public static final int h = 1;
    @Deprecated
    public static final int i = 2;
    public static final int j = 3;

    /* renamed from: a  reason: collision with root package name */
    long f3404a;
    private c k;
    private boolean l;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f3405a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static final int f3406b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f3407c = 2;
        public static final int d = 3;
        public static final int e = 4;
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final int f3408a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static final int f3409b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f3410c = 2;
        public static final int d = 3;
        public static final int e = 4;
        public static final int f = 5;
        public static final int g = 6;
        public static final int h = 7;
        public static final int i = 8;
        public static final int j = 9;
        public static final int k = 10;
        public static final int l = 11;
        public static final int m = 12;
        public static final int n = 13;
    }

    public interface c {
        void a();
    }

    public class d {

        /* renamed from: b  reason: collision with root package name */
        private final int f3412b;

        /* renamed from: c  reason: collision with root package name */
        private final Rect f3413c;
        private final Rect d;

        public d(int i, Rect rect, Rect rect2) {
            this.f3412b = i;
            this.f3413c = rect;
            this.d = rect2;
        }

        private int a() {
            return this.f3412b;
        }

        private Rect b() {
            return this.f3413c;
        }

        private Rect c() {
            return this.d;
        }
    }

    static {
        System.loadLibrary("jpgt");
        System.loadLibrary("pngt");
        System.loadLibrary("lept");
        System.loadLibrary("tess");
        nativeClassInit();
    }

    public TessBaseAPI() {
        this.f3404a = nativeConstruct();
        if (this.f3404a == 0) {
            throw new RuntimeException("Can't create TessBaseApi object");
        }
        this.l = false;
    }

    private TessBaseAPI(c cVar) {
        this();
        this.k = cVar;
    }

    private void a(int i2) {
        if (this.l) {
            throw new IllegalStateException();
        }
        nativeSetPageSegMode(this.f3404a, i2);
    }

    private void a(int i2, int i3, int i4, int i5) {
        if (this.l) {
            throw new IllegalStateException();
        }
        nativeSetRectangle(this.f3404a, i2, i3, i4, i5);
    }

    private void a(Rect rect) {
        if (this.l) {
            throw new IllegalStateException();
        }
        int i2 = rect.left;
        int i3 = rect.top;
        int width = rect.width();
        int height = rect.height();
        if (this.l) {
            throw new IllegalStateException();
        }
        nativeSetRectangle(this.f3404a, i2, i3, width, height);
    }

    private void a(Pix pix) {
        if (this.l) {
            throw new IllegalStateException();
        }
        nativeSetImagePix(this.f3404a, pix.a());
    }

    private void a(File file) {
        if (this.l) {
            throw new IllegalStateException();
        }
        Pix a2 = ReadFile.a(file);
        if (a2 == null) {
            throw new RuntimeException("Failed to read image file");
        }
        nativeSetImagePix(this.f3404a, a2.a());
        a2.b();
    }

    private void a(String str) {
        if (this.l) {
            throw new IllegalStateException();
        }
        nativeSetInputName(this.f3404a, str);
    }

    private void a(boolean z) {
        if (this.l) {
            throw new IllegalStateException();
        }
        nativeSetDebug(this.f3404a, z);
    }

    private void a(byte[] bArr, int i2, int i3, int i4, int i5) {
        if (this.l) {
            throw new IllegalStateException();
        }
        nativeSetImageBytes(this.f3404a, bArr, i2, i3, i4, i5);
    }

    private boolean a(Pix pix, String str, TessPdfRenderer tessPdfRenderer) {
        return nativeAddPageToDocument(this.f3404a, pix.a(), str, tessPdfRenderer.a());
    }

    private boolean a(TessPdfRenderer tessPdfRenderer) {
        return nativeBeginDocument(tessPdfRenderer.a(), "");
    }

    private boolean a(TessPdfRenderer tessPdfRenderer, String str) {
        return nativeBeginDocument(tessPdfRenderer.a(), str);
    }

    private String b() {
        if (!this.l) {
            return nativeGetInitLanguagesAsString(this.f3404a);
        }
        throw new IllegalStateException();
    }

    private String b(int i2) {
        if (!this.l) {
            return nativeGetHOCRText(this.f3404a, i2);
        }
        throw new IllegalStateException();
    }

    private void b(String str) {
        if (this.l) {
            throw new IllegalStateException();
        }
        nativeSetOutputName(this.f3404a, str);
    }

    private boolean b(TessPdfRenderer tessPdfRenderer) {
        return nativeEndDocument(tessPdfRenderer.a());
    }

    private boolean b(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Data path must not be null!");
        }
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        String str3 = str;
        if (!new File(str3).exists()) {
            throw new IllegalArgumentException("Data path does not exist!");
        }
        File file = new File(str3 + com.cyjh.common.b.a.aO);
        if (!file.exists() || !file.isDirectory()) {
            throw new IllegalArgumentException("Data path must contain subfolder tessdata!");
        }
        for (String str4 : str2.split("\\+")) {
            if (!str4.startsWith("~")) {
                File file2 = new File(file + File.separator + str4 + ".traineddata");
                if (!file2.exists()) {
                    throw new IllegalArgumentException("Data file not found at " + file2);
                }
            }
        }
        boolean nativeInitOem = nativeInitOem(this.f3404a, str3, str2, 3);
        if (nativeInitOem) {
            this.l = false;
        }
        return nativeInitOem;
    }

    private String c(int i2) {
        if (!this.l) {
            return nativeGetBoxText(this.f3404a, i2);
        }
        throw new IllegalStateException();
    }

    private void c() {
        if (this.l) {
            throw new IllegalStateException();
        }
        nativeClear(this.f3404a);
    }

    private void c(String str) {
        if (this.l) {
            throw new IllegalStateException();
        }
        nativeReadConfigFile(this.f3404a, str);
    }

    private boolean c(String str, String str2) {
        if (!this.l) {
            return nativeSetVariable(this.f3404a, str, str2);
        }
        throw new IllegalStateException();
    }

    private void d() {
        if (!this.l) {
            nativeEnd(this.f3404a);
            this.l = true;
        }
    }

    private int e() {
        if (!this.l) {
            return nativeGetPageSegMode(this.f3404a);
        }
        throw new IllegalStateException();
    }

    private int f() {
        if (!this.l) {
            return nativeMeanConfidence(this.f3404a);
        }
        throw new IllegalStateException();
    }

    private int[] g() {
        if (this.l) {
            throw new IllegalStateException();
        }
        int[] nativeWordConfidences = nativeWordConfidences(this.f3404a);
        return nativeWordConfidences == null ? new int[0] : nativeWordConfidences;
    }

    private Pix h() {
        if (!this.l) {
            return new Pix(nativeGetThresholdedImage(this.f3404a));
        }
        throw new IllegalStateException();
    }

    private Pixa i() {
        if (!this.l) {
            return new Pixa(nativeGetRegions(this.f3404a), 0, 0);
        }
        throw new IllegalStateException();
    }

    private Pixa j() {
        if (!this.l) {
            return new Pixa(nativeGetTextlines(this.f3404a), 0, 0);
        }
        throw new IllegalStateException();
    }

    private Pixa k() {
        if (!this.l) {
            return new Pixa(nativeGetStrips(this.f3404a), 0, 0);
        }
        throw new IllegalStateException();
    }

    private Pixa l() {
        if (!this.l) {
            return new Pixa(nativeGetWords(this.f3404a), 0, 0);
        }
        throw new IllegalStateException();
    }

    private Pixa m() {
        if (!this.l) {
            return new Pixa(nativeGetConnectedComponents(this.f3404a), 0, 0);
        }
        throw new IllegalStateException();
    }

    private ResultIterator n() {
        if (this.l) {
            throw new IllegalStateException();
        }
        long nativeGetResultIterator = nativeGetResultIterator(this.f3404a);
        if (nativeGetResultIterator == 0) {
            return null;
        }
        return new ResultIterator(nativeGetResultIterator);
    }

    private native boolean nativeAddPageToDocument(long j2, long j3, String str, long j4);

    private native boolean nativeBeginDocument(long j2, String str);

    private static native void nativeClassInit();

    private native void nativeClear(long j2);

    private native long nativeConstruct();

    private native void nativeEnd(long j2);

    private native boolean nativeEndDocument(long j2);

    private native String nativeGetBoxText(long j2, int i2);

    private native long nativeGetConnectedComponents(long j2);

    private native String nativeGetHOCRText(long j2, int i2);

    private native String nativeGetInitLanguagesAsString(long j2);

    private native int nativeGetPageSegMode(long j2);

    private native long nativeGetRegions(long j2);

    private native long nativeGetResultIterator(long j2);

    private native long nativeGetStrips(long j2);

    private native long nativeGetTextlines(long j2);

    private native long nativeGetThresholdedImage(long j2);

    private native String nativeGetUTF8Text(long j2);

    private native String nativeGetVersion(long j2);

    private native long nativeGetWords(long j2);

    private native boolean nativeInit(long j2, String str, String str2);

    private native boolean nativeInitOem(long j2, String str, String str2, int i2);

    private native int nativeMeanConfidence(long j2);

    private native void nativeReadConfigFile(long j2, String str);

    private native void nativeSetDebug(long j2, boolean z);

    private native void nativeSetImageBytes(long j2, byte[] bArr, int i2, int i3, int i4, int i5);

    private native void nativeSetImagePix(long j2, long j3);

    private native void nativeSetInputName(long j2, String str);

    private native void nativeSetOutputName(long j2, String str);

    private native void nativeSetPageSegMode(long j2, int i2);

    private native void nativeSetRectangle(long j2, int i2, int i3, int i4, int i5);

    private native boolean nativeSetVariable(long j2, String str, String str2);

    private native void nativeStop(long j2);

    private native int[] nativeWordConfidences(long j2);

    private String o() {
        return nativeGetVersion(this.f3404a);
    }

    private void p() {
        if (this.l) {
            throw new IllegalStateException();
        }
        nativeStop(this.f3404a);
    }

    private long q() {
        return this.f3404a;
    }

    public final String a() {
        if (this.l) {
            throw new IllegalStateException();
        }
        String nativeGetUTF8Text = nativeGetUTF8Text(this.f3404a);
        if (nativeGetUTF8Text != null) {
            return nativeGetUTF8Text.trim();
        }
        return null;
    }

    public final void a(Bitmap bitmap) {
        if (this.l) {
            throw new IllegalStateException();
        }
        Pix a2 = ReadFile.a(bitmap);
        if (a2 == null) {
            throw new RuntimeException("Failed to read bitmap");
        }
        nativeSetImagePix(this.f3404a, a2.a());
        a2.b();
    }

    public final boolean a(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Data path must not be null!");
        }
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        String str3 = str;
        if (!new File(str3).exists()) {
            throw new IllegalArgumentException("Data path does not exist!");
        }
        File file = new File(str3 + com.cyjh.common.b.a.aO);
        if (!file.exists() || !file.isDirectory()) {
            throw new IllegalArgumentException("Data path must contain subfolder tessdata!");
        }
        for (String str4 : str2.split("\\+")) {
            if (!str4.startsWith("~")) {
                File file2 = new File(file + File.separator + str4 + ".traineddata");
                if (!file2.exists()) {
                    throw new IllegalArgumentException("Data file not found at " + file2);
                }
            }
        }
        boolean nativeInitOem = nativeInitOem(this.f3404a, str3, str2, 3);
        if (nativeInitOem) {
            this.l = false;
        }
        return nativeInitOem;
    }

    /* access modifiers changed from: protected */
    public void onProgressValues(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        if (this.k != null) {
            new d(i2, new Rect(i3, i9 - i5, i4, i9 - i6), new Rect(i7, i10, i8, i9));
        }
    }
}
