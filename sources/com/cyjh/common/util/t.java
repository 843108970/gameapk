package com.cyjh.common.util;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public final class t {
    private static t f = null;
    private static final int g = 1;
    private static final int h = 0;
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public Context f1699a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public a f1700b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f1701c;
    /* access modifiers changed from: package-private */
    public String d;
    /* access modifiers changed from: package-private */
    public Handler e = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (t.this.f1700b != null) {
                int i = message.what;
                if (message.what == 0) {
                    message.obj.toString();
                }
            }
        }
    };

    public interface a {
        void a();

        void b();
    }

    private t(Context context) {
        this.f1699a = context;
    }

    public static t a(Context context) {
        if (f == null) {
            f = new t(context);
        }
        return f;
    }

    private void a(a aVar) {
        this.f1700b = aVar;
    }

    public final t a(final String str, final String str2) {
        new Thread(new Runnable() {
            public final void run() {
                t.this.a(t.this.f1699a, str, str2);
                (t.this.f1701c ? t.this.e.obtainMessage(1) : t.this.e.obtainMessage(0, t.this.d)).sendToTarget();
            }
        }).start();
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void a(Context context, String str, String str2) {
        try {
            String[] list = context.getAssets().list(str);
            if (list.length > 0) {
                File file = new File(Environment.getExternalStorageDirectory(), str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                for (String str3 : list) {
                    if (!str.equals("")) {
                        a(context, str + File.separator + str3, str2 + File.separator + str3);
                    } else {
                        a(context, str3, str2 + File.separator + str3);
                    }
                }
            } else {
                File file2 = new File(Environment.getExternalStorageDirectory(), str2);
                InputStream open = context.getAssets().open(str);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                open.close();
                fileOutputStream.close();
            }
            this.f1701c = true;
        } catch (Exception e2) {
            e2.printStackTrace();
            this.d = e2.getMessage();
            this.f1701c = false;
        }
    }
}
