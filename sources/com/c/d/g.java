package com.c.d;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

public final class g extends BitmapDrawable {

    /* renamed from: a  reason: collision with root package name */
    private float f1574a;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<ImageView> f1575b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1576c;
    private Matrix d;
    private int e;
    private float f;

    public g(Resources resources, Bitmap bitmap, ImageView imageView, float f2, float f3) {
        super(resources, bitmap);
        this.f1575b = new WeakReference<>(imageView);
        this.f1574a = f2;
        this.f = f3;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        imageView.setImageMatrix(new Matrix());
        a(imageView, bitmap, false);
    }

    private float a(int i, int i2) {
        return this.f != Float.MAX_VALUE ? (1.0f - this.f) / 2.0f : ((1.5f - Math.max(1.0f, Math.min(1.5f, ((float) i2) / ((float) i)))) / 2.0f) + 0.25f;
    }

    private int a(int i, int i2, int i3) {
        float f2 = this.f1574a;
        if (this.f1574a == Float.MAX_VALUE) {
            f2 = ((float) i2) / ((float) i);
        }
        return (int) (((float) i3) * f2);
    }

    private static int a(ImageView imageView) {
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int i = layoutParams != null ? layoutParams.width : 0;
        if (i <= 0) {
            i = imageView.getWidth();
        }
        return i > 0 ? (i - imageView.getPaddingLeft()) - imageView.getPaddingRight() : i;
    }

    private Matrix a(ImageView imageView, Bitmap bitmap) {
        float f2;
        float f3;
        int width = bitmap.getWidth();
        if (this.d != null && width == this.e) {
            return this.d;
        }
        int height = bitmap.getHeight();
        int a2 = a(imageView);
        int a3 = a(width, height, a2);
        if (width <= 0 || height <= 0 || a2 <= 0 || a3 <= 0) {
            return null;
        }
        if (this.d == null || width != this.e) {
            this.d = new Matrix();
            float f4 = 0.0f;
            if (width * a3 >= a2 * height) {
                float f5 = ((float) a3) / ((float) height);
                f4 = (((float) a2) - (((float) width) * f5)) * 0.5f;
                f3 = f5;
                f2 = 0.0f;
            } else {
                float f6 = (float) width;
                f3 = ((float) a2) / f6;
                f2 = (((float) a3) - (((float) height) * f3)) * (this.f != Float.MAX_VALUE ? (1.0f - this.f) / 2.0f : 0.25f + ((1.5f - Math.max(1.0f, Math.min(1.5f, ((float) height) / f6))) / 2.0f));
            }
            this.d.setScale(f3, f3);
            this.d.postTranslate(f4, f2);
            this.e = width;
        }
        return this.d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.graphics.Canvas r10, android.widget.ImageView r11, android.graphics.Bitmap r12) {
        /*
            r9 = this;
            int r0 = r12.getWidth()
            android.graphics.Matrix r1 = r9.d
            if (r1 == 0) goto L_0x000c
            int r1 = r9.e
            if (r0 == r1) goto L_0x0080
        L_0x000c:
            int r1 = r12.getHeight()
            int r2 = a(r11)
            int r3 = r9.a((int) r0, (int) r1, (int) r2)
            if (r0 <= 0) goto L_0x0083
            if (r1 <= 0) goto L_0x0083
            if (r2 <= 0) goto L_0x0083
            if (r3 > 0) goto L_0x0021
            goto L_0x0083
        L_0x0021:
            android.graphics.Matrix r4 = r9.d
            if (r4 == 0) goto L_0x0029
            int r4 = r9.e
            if (r0 == r4) goto L_0x0080
        L_0x0029:
            android.graphics.Matrix r4 = new android.graphics.Matrix
            r4.<init>()
            r9.d = r4
            int r4 = r0 * r3
            int r5 = r2 * r1
            r6 = 0
            if (r4 < r5) goto L_0x0045
            float r3 = (float) r3
            float r1 = (float) r1
            float r3 = r3 / r1
            float r1 = (float) r2
            float r2 = (float) r0
            float r2 = r2 * r3
            float r1 = r1 - r2
            r2 = 1056964608(0x3f000000, float:0.5)
            float r1 = r1 * r2
            r2 = r3
            goto L_0x0074
        L_0x0045:
            float r2 = (float) r2
            float r4 = (float) r0
            float r2 = r2 / r4
            float r5 = r9.f
            r7 = 2139095039(0x7f7fffff, float:3.4028235E38)
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            r7 = 1073741824(0x40000000, float:2.0)
            r8 = 1065353216(0x3f800000, float:1.0)
            if (r5 == 0) goto L_0x005a
            float r4 = r9.f
            float r8 = r8 - r4
            float r8 = r8 / r7
            goto L_0x006b
        L_0x005a:
            float r5 = (float) r1
            float r5 = r5 / r4
            r4 = 1069547520(0x3fc00000, float:1.5)
            float r5 = java.lang.Math.min(r4, r5)
            float r5 = java.lang.Math.max(r8, r5)
            r8 = 1048576000(0x3e800000, float:0.25)
            float r4 = r4 - r5
            float r4 = r4 / r7
            float r8 = r8 + r4
        L_0x006b:
            float r3 = (float) r3
            float r1 = (float) r1
            float r1 = r1 * r2
            float r3 = r3 - r1
            float r1 = r3 * r8
            r6 = r1
            r1 = 0
        L_0x0074:
            android.graphics.Matrix r3 = r9.d
            r3.setScale(r2, r2)
            android.graphics.Matrix r2 = r9.d
            r2.postTranslate(r1, r6)
            r9.e = r0
        L_0x0080:
            android.graphics.Matrix r0 = r9.d
            goto L_0x0084
        L_0x0083:
            r0 = 0
        L_0x0084:
            if (r0 == 0) goto L_0x00b1
            int r1 = r11.getPaddingTop()
            int r2 = r11.getPaddingBottom()
            int r1 = r1 + r2
            int r2 = r11.getPaddingLeft()
            int r3 = r11.getPaddingRight()
            int r2 = r2 + r3
            if (r1 > 0) goto L_0x009c
            if (r2 <= 0) goto L_0x00aa
        L_0x009c:
            int r3 = r11.getWidth()
            int r3 = r3 - r2
            int r2 = r11.getHeight()
            int r2 = r2 - r1
            r1 = 0
            r10.clipRect(r1, r1, r3, r2)
        L_0x00aa:
            android.graphics.Paint r1 = r9.getPaint()
            r10.drawBitmap(r12, r0, r1)
        L_0x00b1:
            boolean r10 = r9.f1576c
            if (r10 != 0) goto L_0x00b9
            r10 = 1
            r9.a((android.widget.ImageView) r11, (android.graphics.Bitmap) r12, (boolean) r10)
        L_0x00b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.d.g.a(android.graphics.Canvas, android.widget.ImageView, android.graphics.Bitmap):void");
    }

    private void a(ImageView imageView, Bitmap bitmap, boolean z) {
        int a2 = a(imageView);
        if (a2 > 0) {
            int a3 = a(bitmap.getWidth(), bitmap.getHeight(), a2) + imageView.getPaddingTop() + imageView.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (layoutParams != null) {
                if (a3 != layoutParams.height) {
                    layoutParams.height = a3;
                    imageView.setLayoutParams(layoutParams);
                }
                if (z) {
                    this.f1576c = true;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void draw(android.graphics.Canvas r12) {
        /*
            r11 = this;
            java.lang.ref.WeakReference<android.widget.ImageView> r0 = r11.f1575b
            r1 = 0
            if (r0 == 0) goto L_0x000e
            java.lang.ref.WeakReference<android.widget.ImageView> r0 = r11.f1575b
            java.lang.Object r0 = r0.get()
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            float r2 = r11.f1574a
            r3 = 0
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x00d4
            if (r0 != 0) goto L_0x001a
            goto L_0x00d4
        L_0x001a:
            android.graphics.Bitmap r2 = r11.getBitmap()
            int r4 = r2.getWidth()
            android.graphics.Matrix r5 = r11.d
            if (r5 == 0) goto L_0x002a
            int r5 = r11.e
            if (r4 == r5) goto L_0x009c
        L_0x002a:
            int r5 = r2.getHeight()
            int r6 = a(r0)
            int r7 = r11.a((int) r4, (int) r5, (int) r6)
            if (r4 <= 0) goto L_0x009e
            if (r5 <= 0) goto L_0x009e
            if (r6 <= 0) goto L_0x009e
            if (r7 > 0) goto L_0x003f
            goto L_0x009e
        L_0x003f:
            android.graphics.Matrix r1 = r11.d
            if (r1 == 0) goto L_0x0047
            int r1 = r11.e
            if (r4 == r1) goto L_0x009c
        L_0x0047:
            android.graphics.Matrix r1 = new android.graphics.Matrix
            r1.<init>()
            r11.d = r1
            int r1 = r4 * r7
            int r8 = r6 * r5
            if (r1 < r8) goto L_0x0063
            float r1 = (float) r7
            float r5 = (float) r5
            float r1 = r1 / r5
            float r5 = (float) r6
            float r6 = (float) r4
            float r6 = r6 * r1
            float r5 = r5 - r6
            r6 = 1056964608(0x3f000000, float:0.5)
            float r5 = r5 * r6
            r3 = r5
            r5 = 0
            goto L_0x0090
        L_0x0063:
            float r1 = (float) r6
            float r6 = (float) r4
            float r1 = r1 / r6
            float r8 = r11.f
            r9 = 2139095039(0x7f7fffff, float:3.4028235E38)
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            r9 = 1073741824(0x40000000, float:2.0)
            r10 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x0078
            float r6 = r11.f
            float r10 = r10 - r6
            float r10 = r10 / r9
            goto L_0x0089
        L_0x0078:
            float r8 = (float) r5
            float r8 = r8 / r6
            r6 = 1069547520(0x3fc00000, float:1.5)
            float r8 = java.lang.Math.min(r6, r8)
            float r8 = java.lang.Math.max(r10, r8)
            r10 = 1048576000(0x3e800000, float:0.25)
            float r6 = r6 - r8
            float r6 = r6 / r9
            float r10 = r10 + r6
        L_0x0089:
            float r6 = (float) r7
            float r5 = (float) r5
            float r5 = r5 * r1
            float r6 = r6 - r5
            float r5 = r6 * r10
        L_0x0090:
            android.graphics.Matrix r6 = r11.d
            r6.setScale(r1, r1)
            android.graphics.Matrix r1 = r11.d
            r1.postTranslate(r3, r5)
            r11.e = r4
        L_0x009c:
            android.graphics.Matrix r1 = r11.d
        L_0x009e:
            if (r1 == 0) goto L_0x00cb
            int r3 = r0.getPaddingTop()
            int r4 = r0.getPaddingBottom()
            int r3 = r3 + r4
            int r4 = r0.getPaddingLeft()
            int r5 = r0.getPaddingRight()
            int r4 = r4 + r5
            if (r3 > 0) goto L_0x00b6
            if (r4 <= 0) goto L_0x00c4
        L_0x00b6:
            int r5 = r0.getWidth()
            int r5 = r5 - r4
            int r4 = r0.getHeight()
            int r4 = r4 - r3
            r3 = 0
            r12.clipRect(r3, r3, r5, r4)
        L_0x00c4:
            android.graphics.Paint r3 = r11.getPaint()
            r12.drawBitmap(r2, r1, r3)
        L_0x00cb:
            boolean r12 = r11.f1576c
            if (r12 != 0) goto L_0x00d3
            r12 = 1
            r11.a((android.widget.ImageView) r0, (android.graphics.Bitmap) r2, (boolean) r12)
        L_0x00d3:
            return
        L_0x00d4:
            super.draw(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.d.g.draw(android.graphics.Canvas):void");
    }
}
