package com.cyjh.mobileanjian.ipc.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import com.cyjh.mqsdk.R;
import java.io.File;
import java.io.FileInputStream;

public final class b {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public WindowManager f2734a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public View f2735b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f2736c;
    private Context d;
    private Handler.Callback e = new Handler.Callback() {
        public final boolean handleMessage(Message message) {
            b.this.f2734a.removeView(b.this.f2735b);
            return false;
        }
    };

    public b(Context context) {
        this.d = context;
        this.f2734a = (WindowManager) context.getSystemService("window");
    }

    public final void a(int i, int i2, String str) {
        Bitmap decodeStream;
        try {
            if (new File(str).exists() && (decodeStream = BitmapFactory.decodeStream(new FileInputStream(str))) != null) {
                int width = decodeStream.getWidth();
                int height = decodeStream.getHeight();
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                if (Build.VERSION.SDK_INT >= 26) {
                    layoutParams.type = 2038;
                } else {
                    layoutParams.type = 2002;
                }
                layoutParams.format = 1;
                layoutParams.gravity = 51;
                layoutParams.flags = 792;
                layoutParams.width = width;
                layoutParams.height = height;
                layoutParams.x = i - (width / 2);
                layoutParams.y = i2 - (height / 2);
                this.f2736c = new Handler(this.d.getMainLooper(), this.e);
                this.f2735b = LayoutInflater.from(this.d).inflate(R.layout.ui_show_image, (ViewGroup) null);
                ((ImageView) this.f2735b.findViewById(R.id.tap_imageview)).setImageBitmap(decodeStream);
                this.f2734a.addView(this.f2735b, layoutParams);
                this.f2736c.sendEmptyMessageDelayed(0, 1000);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
