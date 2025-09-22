package com.cyjh.elfin.sweepcode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.e.c.q;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import net.sourceforge.zbar.Image;
import net.sourceforge.zbar.ImageScanner;
import net.sourceforge.zbar.Symbol;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public ImageScanner f2097a;

    /* renamed from: b  reason: collision with root package name */
    public b f2098b;

    public interface a {
        void a();

        void a(String str);
    }

    class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2102a;

        /* renamed from: c  reason: collision with root package name */
        private final Image f2104c;
        private final a d;

        public b(Image image, a aVar) {
            this.f2104c = image;
            this.d = aVar;
        }

        public final void run() {
            super.run();
            try {
                this.f2102a = true;
                d.a(d.this, this.f2104c, this.d);
            } catch (Exception e) {
                e.printStackTrace();
                if (this.d != null) {
                    this.d.a();
                }
            } finally {
                this.f2102a = false;
            }
        }
    }

    static {
        System.loadLibrary("iconv");
    }

    static /* synthetic */ String a(d dVar, Image image) {
        if (dVar.f2097a.scanImage(image) == 0) {
            return null;
        }
        Iterator<Symbol> it = dVar.f2097a.getResults().iterator();
        while (it.hasNext()) {
            Symbol next = it.next();
            if (next.getType() != 0) {
                String str = Build.VERSION.SDK_INT >= 19 ? new String(next.getDataBytes(), StandardCharsets.UTF_8) : next.getData();
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
        }
        return null;
    }

    private String a(Image image) {
        if (this.f2097a.scanImage(image) == 0) {
            return null;
        }
        Iterator<Symbol> it = this.f2097a.getResults().iterator();
        while (it.hasNext()) {
            Symbol next = it.next();
            if (next.getType() != 0) {
                String str = Build.VERSION.SDK_INT >= 19 ? new String(next.getDataBytes(), StandardCharsets.UTF_8) : next.getData();
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
        }
        return null;
    }

    private void a() {
        this.f2097a = new ImageScanner();
        this.f2097a.setConfig(0, 256, 3);
        this.f2097a.setConfig(0, 257, 3);
    }

    static /* synthetic */ void a(d dVar, Image image, a aVar) throws Exception {
        if (dVar.f2097a.scanImage(image) != 0) {
            Iterator<Symbol> it = dVar.f2097a.getResults().iterator();
            if (it.hasNext()) {
                Symbol next = it.next();
                if (aVar != null) {
                    aVar.a(next.getData().trim());
                    return;
                }
                return;
            }
        }
        if (aVar != null) {
            aVar.a();
        }
    }

    private void a(final String str, final a aVar) {
        q.a(new q.b<String>() {
            private void a(String str) {
                if (TextUtils.isEmpty(str)) {
                    aVar.a();
                } else {
                    aVar.a(str);
                }
            }

            private String e() throws Throwable {
                Bitmap a2 = d.b(str);
                if (a2 == null) {
                    return null;
                }
                int width = a2.getWidth();
                int height = a2.getHeight();
                Image image = new Image(width, height, "RGB4");
                int[] iArr = new int[(width * height)];
                a2.getPixels(iArr, 0, width, 0, 0, width, height);
                image.setData(iArr);
                return d.a(d.this, image.convert("Y800"));
            }

            public final /* synthetic */ Object a() throws Throwable {
                Bitmap a2 = d.b(str);
                if (a2 == null) {
                    return null;
                }
                int width = a2.getWidth();
                int height = a2.getHeight();
                Image image = new Image(width, height, "RGB4");
                int[] iArr = new int[(width * height)];
                a2.getPixels(iArr, 0, width, 0, 0, width, height);
                image.setData(iArr);
                return d.a(d.this, image.convert("Y800"));
            }

            public final /* synthetic */ void a(Object obj) {
                String str = (String) obj;
                if (TextUtils.isEmpty(str)) {
                    aVar.a();
                } else {
                    aVar.a(str);
                }
            }
        });
    }

    private void a(Image image, a aVar) throws Exception {
        if (this.f2097a.scanImage(image) != 0) {
            Iterator<Symbol> it = this.f2097a.getResults().iterator();
            if (it.hasNext()) {
                Symbol next = it.next();
                if (aVar != null) {
                    aVar.a(next.getData().trim());
                    return;
                }
                return;
            }
        }
        if (aVar != null) {
            aVar.a();
        }
    }

    private void a(byte[] bArr, Camera camera, View view, a aVar) {
        try {
            if (this.f2098b == null || !this.f2098b.f2102a) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                Image image = new Image(previewSize.width, previewSize.height, "Y800");
                int a2 = c.a(AppContext.a());
                c.b(AppContext.a());
                float f = (float) ((((double) a2) * 1.0d) / ((double) previewSize.height));
                image.setData(bArr);
                image.setCrop((int) (((float) view.getTop()) / f), (int) (((float) view.getLeft()) / f), (int) (((float) view.getBottom()) / f), (int) (((float) view.getRight()) / f));
                this.f2098b = new b(image, aVar);
                this.f2098b.start();
                return;
            }
            throw new Exception();
        } catch (Exception unused) {
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    /* access modifiers changed from: private */
    public static Bitmap b(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i2 = options.outHeight / 400;
            if (i2 > 0) {
                i = i2;
            }
            options.inSampleSize = i;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
