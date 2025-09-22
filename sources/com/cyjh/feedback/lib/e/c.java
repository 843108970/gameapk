package com.cyjh.feedback.lib.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int f2414a = 3;

    /* renamed from: b  reason: collision with root package name */
    private static final int f2415b = 272;

    /* renamed from: c  reason: collision with root package name */
    private static c f2416c;
    private LruCache<String, Bitmap> d;
    /* access modifiers changed from: private */
    public ExecutorService e;
    private LinkedList<Runnable> f;
    private Thread g;
    /* access modifiers changed from: private */
    public Handler h;
    private Handler i;
    private int j;
    /* access modifiers changed from: private */
    public Semaphore k = new Semaphore(0);
    /* access modifiers changed from: private */
    public Semaphore l;

    class a {

        /* renamed from: a  reason: collision with root package name */
        ImageView f2424a;

        /* renamed from: b  reason: collision with root package name */
        String f2425b;

        /* renamed from: c  reason: collision with root package name */
        Bitmap f2426c;

        a() {
        }
    }

    class b {

        /* renamed from: a  reason: collision with root package name */
        int f2427a;

        /* renamed from: b  reason: collision with root package name */
        int f2428b;

        b() {
        }
    }

    /* renamed from: com.cyjh.feedback.lib.e.c$c  reason: collision with other inner class name */
    public enum C0037c {
        ;
        
        public static final int FIFO$789f335a = 1;
        public static final int FILO$789f335a = 2;

        static {
            $VALUES$3b0acc75 = new int[]{FIFO$789f335a, FILO$789f335a};
        }

        public static int[] values$69fec954() {
            return (int[]) $VALUES$3b0acc75.clone();
        }
    }

    private c(int i2) {
        this.j = i2;
        this.l = new Semaphore(3);
        this.g = new Thread() {
            public final void run() {
                super.run();
                Looper.prepare();
                Handler unused = c.this.h = new Handler() {
                    public final void handleMessage(Message message) {
                        c.this.e.execute(c.a(c.this));
                        try {
                            c.this.l.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                c.this.k.release();
                Looper.loop();
            }
        };
        this.g.start();
        this.d = new LruCache<String, Bitmap>(((int) Runtime.getRuntime().maxMemory()) / 8) {
            private static int a(Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ int sizeOf(Object obj, Object obj2) {
                Bitmap bitmap = (Bitmap) obj2;
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        };
        this.f = new LinkedList<>();
        this.e = Executors.newFixedThreadPool(3);
    }

    private static int a(BitmapFactory.Options options, b bVar) {
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        if (i2 > bVar.f2427a || i3 > bVar.f2428b) {
            return Math.max(Math.round((((float) i2) * 1.0f) / ((float) bVar.f2427a)), Math.round((((float) i3) * 1.0f) / ((float) bVar.f2428b)));
        }
        return 1;
    }

    private static int a(Object obj, String str) {
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int i2 = declaredField.getInt(obj);
            if (i2 > 0 && i2 < Integer.MAX_VALUE) {
                return i2;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return 0;
    }

    private Bitmap a(String str) {
        return this.d.get(str);
    }

    static /* synthetic */ Bitmap a(String str, b bVar) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i2 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i3 > bVar.f2427a || i4 > bVar.f2428b) {
            i2 = Math.max(Math.round((((float) i3) * 1.0f) / ((float) bVar.f2427a)), Math.round((((float) i4) * 1.0f) / ((float) bVar.f2428b)));
        }
        options.inSampleSize = i2;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    private b a(ImageView imageView) {
        DisplayMetrics displayMetrics = imageView.getContext().getResources().getDisplayMetrics();
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int width = imageView.getWidth();
        if (width <= 0) {
            width = layoutParams.width;
        }
        if (width <= 0) {
            width = a((Object) imageView, "mMaxWidth");
        }
        if (width <= 0) {
            width = displayMetrics.widthPixels;
        }
        int height = imageView.getHeight();
        if (height <= 0) {
            height = layoutParams.height;
        }
        if (height <= 0) {
            height = a((Object) imageView, "mMaxHeight");
        }
        if (height <= 0) {
            height = displayMetrics.heightPixels;
        }
        b bVar = new b();
        bVar.f2427a = width;
        bVar.f2428b = height;
        return bVar;
    }

    static /* synthetic */ b a(c cVar, ImageView imageView) {
        DisplayMetrics displayMetrics = imageView.getContext().getResources().getDisplayMetrics();
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int width = imageView.getWidth();
        if (width <= 0) {
            width = layoutParams.width;
        }
        if (width <= 0) {
            width = a((Object) imageView, "mMaxWidth");
        }
        if (width <= 0) {
            width = displayMetrics.widthPixels;
        }
        int height = imageView.getHeight();
        if (height <= 0) {
            height = layoutParams.height;
        }
        if (height <= 0) {
            height = a((Object) imageView, "mMaxHeight");
        }
        if (height <= 0) {
            height = displayMetrics.heightPixels;
        }
        b bVar = new b();
        bVar.f2427a = width;
        bVar.f2428b = height;
        return bVar;
    }

    public static c a() {
        if (f2416c == null) {
            synchronized (c.class) {
                if (f2416c == null) {
                    f2416c = new c(C0037c.FILO$789f335a);
                }
            }
        }
        return f2416c;
    }

    public static c a(int i2) {
        if (f2416c == null) {
            synchronized (c.class) {
                if (f2416c == null) {
                    f2416c = new c(i2);
                }
            }
        }
        return f2416c;
    }

    static /* synthetic */ Runnable a(c cVar) {
        Object removeLast;
        if (C0037c.FIFO$789f335a == cVar.j) {
            removeLast = cVar.f.removeFirst();
        } else if (C0037c.FILO$789f335a != cVar.j) {
            return null;
        } else {
            removeLast = cVar.f.removeLast();
        }
        return (Runnable) removeLast;
    }

    private void a(int i2, int i3) {
        this.j = i2;
        this.l = new Semaphore(i3);
        this.g = new Thread() {
            public final void run() {
                super.run();
                Looper.prepare();
                Handler unused = c.this.h = new Handler() {
                    public final void handleMessage(Message message) {
                        c.this.e.execute(c.a(c.this));
                        try {
                            c.this.l.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                c.this.k.release();
                Looper.loop();
            }
        };
        this.g.start();
        this.d = new LruCache<String, Bitmap>(((int) Runtime.getRuntime().maxMemory()) / 8) {
            private static int a(Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ int sizeOf(Object obj, Object obj2) {
                Bitmap bitmap = (Bitmap) obj2;
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        };
        this.f = new LinkedList<>();
        this.e = Executors.newFixedThreadPool(i3);
    }

    private void a(Bitmap bitmap, String str) {
        if (a(str) == null && bitmap != null) {
            this.d.put(str, bitmap);
        }
    }

    /* access modifiers changed from: private */
    public void a(Bitmap bitmap, String str, ImageView imageView) {
        a aVar = new a();
        aVar.f2426c = bitmap;
        aVar.f2425b = str;
        aVar.f2424a = imageView;
        Message obtainMessage = this.i.obtainMessage();
        obtainMessage.obj = aVar;
        this.i.sendMessage(obtainMessage);
    }

    static /* synthetic */ void a(c cVar, Bitmap bitmap, String str) {
        if (cVar.a(str) == null && bitmap != null) {
            cVar.d.put(str, bitmap);
        }
    }

    private synchronized void a(Runnable runnable) {
        this.f.add(runnable);
        try {
            if (this.h == null) {
                this.k.acquire();
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        this.h.sendEmptyMessage(272);
    }

    private static Bitmap b(String str, b bVar) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i2 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i3 > bVar.f2427a || i4 > bVar.f2428b) {
            i2 = Math.max(Math.round((((float) i3) * 1.0f) / ((float) bVar.f2427a)), Math.round((((float) i4) * 1.0f) / ((float) bVar.f2428b)));
        }
        options.inSampleSize = i2;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    private Runnable b() {
        Object removeLast;
        if (C0037c.FIFO$789f335a == this.j) {
            removeLast = this.f.removeFirst();
        } else if (C0037c.FILO$789f335a != this.j) {
            return null;
        } else {
            removeLast = this.f.removeLast();
        }
        return (Runnable) removeLast;
    }

    public final void a(final String str, final ImageView imageView) {
        imageView.setTag(str);
        if (this.i == null) {
            this.i = new Handler() {
                public final void handleMessage(Message message) {
                    a aVar = (a) message.obj;
                    Bitmap bitmap = aVar.f2426c;
                    String str = aVar.f2425b;
                    ImageView imageView = aVar.f2424a;
                    if (imageView.getTag().toString().equals(str)) {
                        imageView.setImageBitmap(bitmap);
                    }
                }
            };
        }
        Bitmap a2 = a(str);
        if (a2 != null) {
            a(a2, str, imageView);
        } else {
            a((Runnable) new Runnable() {
                public final void run() {
                    Bitmap a2 = c.a(str, c.a(c.this, imageView));
                    c.a(c.this, a2, str);
                    c.this.a(a2, str, imageView);
                    c.this.l.release();
                }
            });
        }
    }
}
