package com.android.volley.toolbox;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.android.volley.toolbox.k;
import com.android.volley.toolbox.l;

public class NetworkImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private String f511a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f512b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f513c;
    private k d;
    private a e;
    private l.a f;
    private k.c g;

    public interface a {
        String a();
    }

    public NetworkImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void a() {
        if (this.f512b != 0) {
            setImageResource(this.f512b);
        } else {
            setImageBitmap((Bitmap) null);
        }
    }

    private void a(String str, k kVar) {
        this.f511a = str;
        this.d = kVar;
        this.e = null;
        a(false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(final boolean r10) {
        /*
            r9 = this;
            int r0 = r9.getWidth()
            int r1 = r9.getHeight()
            android.widget.ImageView$ScaleType r7 = r9.getScaleType()
            android.view.ViewGroup$LayoutParams r2 = r9.getLayoutParams()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x002a
            android.view.ViewGroup$LayoutParams r2 = r9.getLayoutParams()
            int r2 = r2.width
            r5 = -2
            if (r2 != r5) goto L_0x001f
            r2 = 1
            goto L_0x0020
        L_0x001f:
            r2 = 0
        L_0x0020:
            android.view.ViewGroup$LayoutParams r6 = r9.getLayoutParams()
            int r6 = r6.height
            if (r6 != r5) goto L_0x002b
            r5 = 1
            goto L_0x002c
        L_0x002a:
            r2 = 0
        L_0x002b:
            r5 = 0
        L_0x002c:
            if (r2 == 0) goto L_0x0031
            if (r5 == 0) goto L_0x0031
            goto L_0x0032
        L_0x0031:
            r3 = 0
        L_0x0032:
            if (r0 != 0) goto L_0x0039
            if (r1 != 0) goto L_0x0039
            if (r3 != 0) goto L_0x0039
            return
        L_0x0039:
            java.lang.String r3 = r9.f511a
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x0051
            com.android.volley.toolbox.k$c r10 = r9.g
            if (r10 == 0) goto L_0x004d
            com.android.volley.toolbox.k$c r10 = r9.g
            r10.a()
            r10 = 0
            r9.g = r10
        L_0x004d:
            r9.a()
            return
        L_0x0051:
            if (r2 == 0) goto L_0x0054
            r0 = 0
        L_0x0054:
            if (r5 == 0) goto L_0x0058
            r6 = 0
            goto L_0x0059
        L_0x0058:
            r6 = r1
        L_0x0059:
            java.lang.String r1 = r9.f511a
            com.android.volley.toolbox.NetworkImageView$a r2 = r9.e
            if (r2 == 0) goto L_0x006f
            com.android.volley.toolbox.NetworkImageView$a r1 = r9.e
            r9.getScaleType()
            android.content.Context r2 = r9.getContext()
            r2.getApplicationContext()
            java.lang.String r1 = r1.a()
        L_0x006f:
            r3 = r1
            com.android.volley.toolbox.k$c r1 = r9.g
            if (r1 == 0) goto L_0x008d
            com.android.volley.toolbox.k$c r1 = r9.g
            java.lang.String r1 = r1.f556c
            if (r1 == 0) goto L_0x008d
            com.android.volley.toolbox.k$c r1 = r9.g
            java.lang.String r1 = r1.f556c
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0085
            return
        L_0x0085:
            com.android.volley.toolbox.k$c r1 = r9.g
            r1.a()
            r9.a()
        L_0x008d:
            com.android.volley.toolbox.k r2 = r9.d
            com.android.volley.toolbox.NetworkImageView$1 r4 = new com.android.volley.toolbox.NetworkImageView$1
            r4.<init>(r10)
            com.android.volley.toolbox.l$a r8 = r9.f
            r5 = r0
            com.android.volley.toolbox.k$c r10 = r2.a((java.lang.String) r3, (com.android.volley.toolbox.k.d) r4, (int) r5, (int) r6, (android.widget.ImageView.ScaleType) r7, (com.android.volley.toolbox.l.a) r8)
            r9.g = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.NetworkImageView.a(boolean):void");
    }

    private void b(String str, k kVar) {
        this.f511a = str;
        this.d = kVar;
        this.e = null;
        a(false);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (this.g != null) {
            this.g.a();
            setImageBitmap((Bitmap) null);
            this.g = null;
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        a(true);
    }

    public void setDefaultImageResId(int i) {
        this.f512b = i;
    }

    public void setErrorImageResId(int i) {
        this.f513c = i;
    }

    public void setTransformation(l.a aVar) {
        this.f = aVar;
    }
}
