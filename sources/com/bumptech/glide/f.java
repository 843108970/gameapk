package com.bumptech.glide;

import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a.e;
import com.bumptech.glide.load.a.k;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.b.l;
import com.bumptech.glide.load.b.d.d;
import com.bumptech.glide.load.b.j;
import com.bumptech.glide.load.c.a;
import com.bumptech.glide.load.c.a.b;
import com.bumptech.glide.load.c.a.c;
import com.bumptech.glide.load.c.a.d;
import com.bumptech.glide.load.c.a.e;
import com.bumptech.glide.load.c.a.f;
import com.bumptech.glide.load.c.b;
import com.bumptech.glide.load.c.c;
import com.bumptech.glide.load.c.d;
import com.bumptech.glide.load.c.e;
import com.bumptech.glide.load.c.f;
import com.bumptech.glide.load.c.k;
import com.bumptech.glide.load.c.s;
import com.bumptech.glide.load.c.t;
import com.bumptech.glide.load.c.u;
import com.bumptech.glide.load.c.v;
import com.bumptech.glide.load.c.w;
import com.bumptech.glide.load.c.x;
import com.bumptech.glide.load.d.a.aa;
import com.bumptech.glide.load.d.a.ac;
import com.bumptech.glide.load.d.a.i;
import com.bumptech.glide.load.d.a.m;
import com.bumptech.glide.load.d.a.o;
import com.bumptech.glide.load.d.a.r;
import com.bumptech.glide.load.d.a.w;
import com.bumptech.glide.load.d.a.y;
import com.bumptech.glide.load.d.b.a;
import com.bumptech.glide.load.d.e.a;
import com.bumptech.glide.load.d.e.h;
import com.bumptech.glide.manager.d;
import com.bumptech.glide.manager.k;
import com.bumptech.glide.request.g;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class f implements ComponentCallbacks2 {
    private static final String h = "image_manager_disk_cache";
    private static final String i = "Glide";
    private static volatile f j;
    private static volatile boolean k;

    /* renamed from: a  reason: collision with root package name */
    public final e f948a;

    /* renamed from: b  reason: collision with root package name */
    public final h f949b;

    /* renamed from: c  reason: collision with root package name */
    public final m f950c;
    public final b d;
    public final k e;
    final d f;
    final List<o> g = new ArrayList();
    private final j l;
    private final com.bumptech.glide.load.b.b.j m;
    private final com.bumptech.glide.load.b.d.b n;
    private j o = j.NORMAL;

    f(@NonNull Context context, @NonNull j jVar, @NonNull com.bumptech.glide.load.b.b.j jVar2, @NonNull e eVar, @NonNull b bVar, @NonNull k kVar, @NonNull d dVar, int i2, @NonNull g gVar, @NonNull Map<Class<?>, p<?, ?>> map) {
        Context context2 = context;
        com.bumptech.glide.load.b.b.j jVar3 = jVar2;
        e eVar2 = eVar;
        b bVar2 = bVar;
        this.l = jVar;
        this.f948a = eVar2;
        this.d = bVar2;
        this.m = jVar3;
        this.e = kVar;
        this.f = dVar;
        this.n = new com.bumptech.glide.load.b.d.b(jVar3, eVar2, (com.bumptech.glide.load.b) gVar.p.a(o.f1315b));
        Resources resources = context.getResources();
        this.f950c = new m();
        if (Build.VERSION.SDK_INT >= 27) {
            this.f950c.a((ImageHeaderParser) new r());
        }
        this.f950c.a((ImageHeaderParser) new m());
        o oVar = new o(this.f950c.a(), resources.getDisplayMetrics(), eVar2, bVar2);
        a aVar = new a(context2, this.f950c.a(), eVar2, bVar2);
        com.bumptech.glide.load.k<ParcelFileDescriptor, Bitmap> b2 = ac.b(eVar);
        i iVar = new i(oVar);
        y yVar = new y(oVar, bVar2);
        com.bumptech.glide.load.d.c.e eVar3 = new com.bumptech.glide.load.d.c.e(context2);
        s.c cVar = new s.c(resources);
        s.d dVar2 = new s.d(resources);
        s.b bVar3 = new s.b(resources);
        s.a aVar2 = new s.a(resources);
        com.bumptech.glide.load.d.a.e eVar4 = new com.bumptech.glide.load.d.a.e(bVar2);
        com.bumptech.glide.load.d.f.a aVar3 = new com.bumptech.glide.load.d.f.a();
        com.bumptech.glide.load.d.f.d dVar3 = new com.bumptech.glide.load.d.f.d();
        s.c cVar2 = cVar;
        s.b bVar4 = bVar3;
        s.d dVar4 = dVar2;
        s.a aVar4 = aVar2;
        Context context3 = context;
        ContentResolver contentResolver = context.getContentResolver();
        com.bumptech.glide.load.d.f.a aVar5 = aVar3;
        com.bumptech.glide.load.d.f.d dVar5 = dVar3;
        this.f950c.a(ByteBuffer.class, new c()).a(InputStream.class, new t(bVar2)).a(m.f1394b, ByteBuffer.class, Bitmap.class, iVar).a(m.f1394b, InputStream.class, Bitmap.class, yVar).a(m.f1394b, ParcelFileDescriptor.class, Bitmap.class, b2).a(m.f1394b, AssetFileDescriptor.class, Bitmap.class, ac.a(eVar)).a(Bitmap.class, Bitmap.class, v.a.b()).a(m.f1394b, Bitmap.class, Bitmap.class, new aa()).a(Bitmap.class, eVar4).a(m.f1395c, ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.d.a.a(resources, iVar, (byte) 0)).a(m.f1395c, InputStream.class, BitmapDrawable.class, new com.bumptech.glide.load.d.a.a(resources, yVar, (byte) 0)).a(m.f1395c, ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.load.d.a.a(resources, b2, (byte) 0)).a(BitmapDrawable.class, new com.bumptech.glide.load.d.a.b(eVar2, eVar4)).a(m.f1393a, InputStream.class, com.bumptech.glide.load.d.e.c.class, new com.bumptech.glide.load.d.e.j(this.f950c.a(), aVar, bVar2)).a(m.f1393a, ByteBuffer.class, com.bumptech.glide.load.d.e.c.class, aVar).a(com.bumptech.glide.load.d.e.c.class, new com.bumptech.glide.load.d.e.d()).a(com.bumptech.glide.c.b.class, com.bumptech.glide.c.b.class, v.a.b()).a(m.f1394b, com.bumptech.glide.c.b.class, Bitmap.class, new h(eVar2)).a(Uri.class, Drawable.class, eVar3).a(Uri.class, Bitmap.class, new w(eVar3, eVar2)).a((e.a<?>) new a.C0019a()).a(File.class, ByteBuffer.class, new d.b()).a(File.class, InputStream.class, new f.e()).a(File.class, File.class, new com.bumptech.glide.load.d.d.a()).a(File.class, ParcelFileDescriptor.class, new f.b()).a(File.class, File.class, v.a.b()).a((e.a<?>) new k.a(bVar2)).a(Integer.TYPE, InputStream.class, cVar2).a(Integer.TYPE, ParcelFileDescriptor.class, bVar4).a(Integer.class, InputStream.class, cVar2).a(Integer.class, ParcelFileDescriptor.class, bVar4).a(Integer.class, Uri.class, dVar4).a(Integer.TYPE, AssetFileDescriptor.class, aVar4).a(Integer.class, AssetFileDescriptor.class, aVar4).a(Integer.TYPE, Uri.class, dVar4).a(String.class, InputStream.class, new e.c()).a(Uri.class, InputStream.class, new e.c()).a(String.class, InputStream.class, new u.c()).a(String.class, ParcelFileDescriptor.class, new u.b()).a(String.class, AssetFileDescriptor.class, new u.a()).a(Uri.class, InputStream.class, new c.a()).a(Uri.class, InputStream.class, new a.c(context.getAssets())).a(Uri.class, ParcelFileDescriptor.class, new a.b(context.getAssets())).a(Uri.class, InputStream.class, new d.a(context3)).a(Uri.class, InputStream.class, new e.a(context3)).a(Uri.class, InputStream.class, new w.d(contentResolver)).a(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver)).a(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver)).a(Uri.class, InputStream.class, new x.a()).a(URL.class, InputStream.class, new f.a()).a(Uri.class, File.class, new k.a(context3)).a(com.bumptech.glide.load.c.g.class, InputStream.class, new b.a()).a(byte[].class, ByteBuffer.class, new b.a()).a(byte[].class, InputStream.class, new b.d()).a(Uri.class, Uri.class, v.a.b()).a(Drawable.class, Drawable.class, v.a.b()).a(Drawable.class, Drawable.class, new com.bumptech.glide.load.d.c.f()).a(Bitmap.class, BitmapDrawable.class, new com.bumptech.glide.load.d.f.b(resources, (byte) 0)).a(Bitmap.class, byte[].class, aVar5).a(Drawable.class, byte[].class, new com.bumptech.glide.load.d.f.c(eVar2, aVar5, dVar5)).a(com.bumptech.glide.load.d.e.c.class, byte[].class, dVar5);
        this.f949b = new h(context3, bVar2, this.f950c, new ImageViewTargetFactory(), gVar, map, jVar, i2);
    }

    @NonNull
    private j a(@NonNull j jVar) {
        com.bumptech.glide.util.k.a();
        this.m.a(jVar.getMultiplier());
        this.f948a.a(jVar.getMultiplier());
        j jVar2 = this.o;
        this.o = jVar;
        return jVar2;
    }

    @NonNull
    public static o a(@NonNull Activity activity) {
        return f(activity).a(activity);
    }

    @Deprecated
    @NonNull
    public static o a(@NonNull Fragment fragment) {
        return f(fragment.getActivity()).a(fragment);
    }

    @NonNull
    public static o a(@NonNull android.support.v4.app.Fragment fragment) {
        return f(fragment.getActivity()).a(fragment);
    }

    @NonNull
    public static o a(@NonNull FragmentActivity fragmentActivity) {
        return f(fragmentActivity).a(fragmentActivity);
    }

    /* JADX WARNING: type inference failed for: r4v6, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r4v8, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: type inference failed for: r4v14 */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0075, code lost:
        r4 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0075, code lost:
        r4 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b8, code lost:
        r4 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b8, code lost:
        r4 = r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    @android.support.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.bumptech.glide.o a(@android.support.annotation.NonNull android.view.View r7) {
        /*
            android.content.Context r0 = r7.getContext()
            com.bumptech.glide.manager.k r0 = f(r0)
            boolean r1 = com.bumptech.glide.util.k.d()
            if (r1 == 0) goto L_0x001b
        L_0x000e:
            android.content.Context r7 = r7.getContext()
            android.content.Context r7 = r7.getApplicationContext()
            com.bumptech.glide.o r7 = r0.a((android.content.Context) r7)
            return r7
        L_0x001b:
            java.lang.String r1 = "Argument must not be null"
            com.bumptech.glide.util.i.a(r7, (java.lang.String) r1)
            android.content.Context r1 = r7.getContext()
            java.lang.String r2 = "Unable to obtain a request manager for a view without a Context"
            com.bumptech.glide.util.i.a(r1, (java.lang.String) r2)
            android.content.Context r1 = r7.getContext()
            android.app.Activity r1 = com.bumptech.glide.manager.k.b((android.content.Context) r1)
            if (r1 != 0) goto L_0x0034
            goto L_0x000e
        L_0x0034:
            boolean r2 = r1 instanceof android.support.v4.app.FragmentActivity
            r3 = 16908290(0x1020002, float:2.3877235E-38)
            r4 = 0
            if (r2 == 0) goto L_0x0086
            r2 = r1
            android.support.v4.app.FragmentActivity r2 = (android.support.v4.app.FragmentActivity) r2
            android.support.v4.util.ArrayMap<android.view.View, android.support.v4.app.Fragment> r5 = r0.d
            r5.clear()
            android.support.v4.app.FragmentManager r5 = r2.getSupportFragmentManager()
            java.util.List r5 = r5.getFragments()
            android.support.v4.util.ArrayMap<android.view.View, android.support.v4.app.Fragment> r6 = r0.d
            com.bumptech.glide.manager.k.a((java.util.Collection<android.support.v4.app.Fragment>) r5, (java.util.Map<android.view.View, android.support.v4.app.Fragment>) r6)
            android.view.View r2 = r2.findViewById(r3)
        L_0x0055:
            boolean r3 = r7.equals(r2)
            if (r3 != 0) goto L_0x0075
            android.support.v4.util.ArrayMap<android.view.View, android.support.v4.app.Fragment> r3 = r0.d
            java.lang.Object r3 = r3.get(r7)
            r4 = r3
            android.support.v4.app.Fragment r4 = (android.support.v4.app.Fragment) r4
            if (r4 != 0) goto L_0x0075
            android.view.ViewParent r3 = r7.getParent()
            boolean r3 = r3 instanceof android.view.View
            if (r3 == 0) goto L_0x0075
            android.view.ViewParent r7 = r7.getParent()
            android.view.View r7 = (android.view.View) r7
            goto L_0x0055
        L_0x0075:
            android.support.v4.util.ArrayMap<android.view.View, android.support.v4.app.Fragment> r7 = r0.d
            r7.clear()
            if (r4 == 0) goto L_0x0081
            com.bumptech.glide.o r7 = r0.a((android.support.v4.app.Fragment) r4)
            return r7
        L_0x0081:
            com.bumptech.glide.o r7 = r0.a((android.app.Activity) r1)
            return r7
        L_0x0086:
            android.support.v4.util.ArrayMap<android.view.View, android.app.Fragment> r2 = r0.e
            r2.clear()
            android.app.FragmentManager r2 = r1.getFragmentManager()
            android.support.v4.util.ArrayMap<android.view.View, android.app.Fragment> r5 = r0.e
            r0.a((android.app.FragmentManager) r2, (android.support.v4.util.ArrayMap<android.view.View, android.app.Fragment>) r5)
            android.view.View r2 = r1.findViewById(r3)
        L_0x0098:
            boolean r3 = r7.equals(r2)
            if (r3 != 0) goto L_0x00b8
            android.support.v4.util.ArrayMap<android.view.View, android.app.Fragment> r3 = r0.e
            java.lang.Object r3 = r3.get(r7)
            r4 = r3
            android.app.Fragment r4 = (android.app.Fragment) r4
            if (r4 != 0) goto L_0x00b8
            android.view.ViewParent r3 = r7.getParent()
            boolean r3 = r3 instanceof android.view.View
            if (r3 == 0) goto L_0x00b8
            android.view.ViewParent r7 = r7.getParent()
            android.view.View r7 = (android.view.View) r7
            goto L_0x0098
        L_0x00b8:
            android.support.v4.util.ArrayMap<android.view.View, android.app.Fragment> r7 = r0.e
            r7.clear()
            if (r4 != 0) goto L_0x00c4
            com.bumptech.glide.o r7 = r0.a((android.app.Activity) r1)
            return r7
        L_0x00c4:
            com.bumptech.glide.o r7 = r0.a((android.app.Fragment) r4)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.f.a(android.view.View):com.bumptech.glide.o");
    }

    @Nullable
    public static File a(@NonNull Context context) {
        return a(context, "image_manager_disk_cache");
    }

    @Nullable
    public static File a(@NonNull Context context, @NonNull String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            File file = new File(cacheDir, str);
            if (file.mkdirs() || (file.exists() && file.isDirectory())) {
                return file;
            }
            return null;
        }
        if (Log.isLoggable(i, 6)) {
            Log.e(i, "default disk cache dir is null");
        }
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:13|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0062 */
    @android.support.annotation.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a() {
        /*
            java.lang.Class<com.bumptech.glide.f> r0 = com.bumptech.glide.f.class
            monitor-enter(r0)
            com.bumptech.glide.f r1 = j     // Catch:{ all -> 0x006e }
            if (r1 == 0) goto L_0x0069
            com.bumptech.glide.f r1 = j     // Catch:{ all -> 0x006e }
            com.bumptech.glide.h r1 = r1.f949b     // Catch:{ all -> 0x006e }
            android.content.Context r1 = r1.getBaseContext()     // Catch:{ all -> 0x006e }
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ all -> 0x006e }
            com.bumptech.glide.f r2 = j     // Catch:{ all -> 0x006e }
            r1.unregisterComponentCallbacks(r2)     // Catch:{ all -> 0x006e }
            com.bumptech.glide.f r1 = j     // Catch:{ all -> 0x006e }
            com.bumptech.glide.load.b.j r1 = r1.l     // Catch:{ all -> 0x006e }
            com.bumptech.glide.load.b.j$b r2 = r1.d     // Catch:{ all -> 0x006e }
            com.bumptech.glide.load.b.c.a r3 = r2.f1152a     // Catch:{ all -> 0x006e }
            com.bumptech.glide.load.b.j.b.a(r3)     // Catch:{ all -> 0x006e }
            com.bumptech.glide.load.b.c.a r3 = r2.f1153b     // Catch:{ all -> 0x006e }
            com.bumptech.glide.load.b.j.b.a(r3)     // Catch:{ all -> 0x006e }
            com.bumptech.glide.load.b.c.a r3 = r2.f1154c     // Catch:{ all -> 0x006e }
            com.bumptech.glide.load.b.j.b.a(r3)     // Catch:{ all -> 0x006e }
            com.bumptech.glide.load.b.c.a r2 = r2.d     // Catch:{ all -> 0x006e }
            com.bumptech.glide.load.b.j.b.a(r2)     // Catch:{ all -> 0x006e }
            com.bumptech.glide.load.b.j$c r2 = r1.e     // Catch:{ all -> 0x006e }
            r2.b()     // Catch:{ all -> 0x006e }
            com.bumptech.glide.load.b.a r1 = r1.g     // Catch:{ all -> 0x006e }
            r2 = 1
            r1.f = r2     // Catch:{ all -> 0x006e }
            java.lang.Thread r2 = r1.e     // Catch:{ all -> 0x006e }
            if (r2 == 0) goto L_0x0069
            java.lang.Thread r2 = r1.e     // Catch:{ all -> 0x006e }
            r2.interrupt()     // Catch:{ all -> 0x006e }
            java.lang.Thread r2 = r1.e     // Catch:{ InterruptedException -> 0x0062 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x0062 }
            r4 = 5
            long r3 = r3.toMillis(r4)     // Catch:{ InterruptedException -> 0x0062 }
            r2.join(r3)     // Catch:{ InterruptedException -> 0x0062 }
            java.lang.Thread r1 = r1.e     // Catch:{ InterruptedException -> 0x0062 }
            boolean r1 = r1.isAlive()     // Catch:{ InterruptedException -> 0x0062 }
            if (r1 == 0) goto L_0x0069
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ InterruptedException -> 0x0062 }
            java.lang.String r2 = "Failed to join in time"
            r1.<init>(r2)     // Catch:{ InterruptedException -> 0x0062 }
            throw r1     // Catch:{ InterruptedException -> 0x0062 }
        L_0x0062:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x006e }
            r1.interrupt()     // Catch:{ all -> 0x006e }
        L_0x0069:
            r1 = 0
            j = r1     // Catch:{ all -> 0x006e }
            monitor-exit(r0)
            return
        L_0x006e:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.f.a():void");
    }

    private void a(int i2) {
        com.bumptech.glide.util.k.a();
        this.m.a(i2);
        this.f948a.a(i2);
        this.d.a(i2);
    }

    @VisibleForTesting
    public static synchronized void a(@NonNull Context context, @NonNull g gVar) {
        synchronized (f.class) {
            if (j != null) {
                a();
            }
            b(context, gVar);
        }
    }

    @VisibleForTesting
    @Deprecated
    public static synchronized void a(f fVar) {
        synchronized (f.class) {
            if (j != null) {
                a();
            }
            j = fVar;
        }
    }

    private void a(o oVar) {
        synchronized (this.g) {
            if (this.g.contains(oVar)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            this.g.add(oVar);
        }
    }

    private static void a(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    private void a(@NonNull d.a... aVarArr) {
        com.bumptech.glide.load.b.d.b bVar = this.n;
        if (bVar.e != null) {
            bVar.e.f = true;
        }
        com.bumptech.glide.load.b.d.d[] dVarArr = new com.bumptech.glide.load.b.d.d[aVarArr.length];
        for (int i2 = 0; i2 < aVarArr.length; i2++) {
            d.a aVar = aVarArr[i2];
            if (aVar.f1121c == null) {
                aVar.f1121c = bVar.f1112c == com.bumptech.glide.load.b.PREFER_ARGB_8888 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            }
            dVarArr[i2] = new com.bumptech.glide.load.b.d.d(aVar.f1119a, aVar.f1120b, aVar.f1121c, aVar.d);
        }
        long b2 = (bVar.f1110a.b() - bVar.f1110a.a()) + bVar.f1111b.a();
        int i3 = 0;
        for (com.bumptech.glide.load.b.d.d dVar : dVarArr) {
            i3 += dVar.e;
        }
        float f2 = ((float) b2) / ((float) i3);
        HashMap hashMap = new HashMap();
        for (com.bumptech.glide.load.b.d.d dVar2 : dVarArr) {
            hashMap.put(dVar2, Integer.valueOf(Math.round(((float) dVar2.e) * f2) / com.bumptech.glide.util.k.a(dVar2.f1117b, dVar2.f1118c, dVar2.d)));
        }
        bVar.e = new com.bumptech.glide.load.b.d.a(bVar.f1111b, bVar.f1110a, new com.bumptech.glide.load.b.d.c(hashMap));
        bVar.d.post(bVar.e);
    }

    @Nullable
    private static b b() {
        try {
            return (b) Class.forName("com.bumptech.glide.c").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException unused) {
            if (!Log.isLoggable(i, 5)) {
                return null;
            }
            Log.w(i, "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            return null;
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            a((Exception) e2);
            return null;
        }
    }

    @NonNull
    public static f b(@NonNull Context context) {
        if (j == null) {
            synchronized (f.class) {
                if (j == null) {
                    if (k) {
                        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
                    }
                    k = true;
                    b(context, new g());
                    k = false;
                }
            }
        }
        return j;
    }

    private static void b(@NonNull Context context, @NonNull g gVar) {
        Context applicationContext = context.getApplicationContext();
        b b2 = b();
        List<com.bumptech.glide.d.c> emptyList = Collections.emptyList();
        if (b2 == null || b2.d()) {
            emptyList = new com.bumptech.glide.d.e(applicationContext).a();
        }
        List<com.bumptech.glide.d.c> list = emptyList;
        if (b2 != null && !b2.a().isEmpty()) {
            Set<Class<?>> a2 = b2.a();
            Iterator<com.bumptech.glide.d.c> it = list.iterator();
            while (it.hasNext()) {
                com.bumptech.glide.d.c next = it.next();
                if (a2.contains(next.getClass())) {
                    if (Log.isLoggable(i, 3)) {
                        Log.d(i, "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable(i, 3)) {
            for (com.bumptech.glide.d.c cVar : list) {
                Log.d(i, "Discovered GlideModule from manifest: " + cVar.getClass());
            }
        }
        gVar.m = b2 != null ? b2.b() : null;
        for (com.bumptech.glide.d.c a3 : list) {
            a3.a(applicationContext, gVar);
        }
        if (b2 != null) {
            b2.a(applicationContext, gVar);
        }
        if (gVar.f == null) {
            gVar.f = com.bumptech.glide.load.b.c.a.b();
        }
        if (gVar.g == null) {
            gVar.g = com.bumptech.glide.load.b.c.a.a();
        }
        if (gVar.n == null) {
            gVar.n = com.bumptech.glide.load.b.c.a.d();
        }
        if (gVar.i == null) {
            gVar.i = new l.a(applicationContext).a();
        }
        if (gVar.j == null) {
            gVar.j = new com.bumptech.glide.manager.f();
        }
        if (gVar.f958c == null) {
            int i2 = gVar.i.f1078b;
            if (i2 > 0) {
                gVar.f958c = new com.bumptech.glide.load.b.a.k((long) i2);
            } else {
                gVar.f958c = new com.bumptech.glide.load.b.a.f();
            }
        }
        if (gVar.d == null) {
            gVar.d = new com.bumptech.glide.load.b.a.j(gVar.i.d);
        }
        if (gVar.e == null) {
            gVar.e = new com.bumptech.glide.load.b.b.i((long) gVar.i.f1079c);
        }
        if (gVar.h == null) {
            gVar.h = new com.bumptech.glide.load.b.b.h(applicationContext);
        }
        if (gVar.f957b == null) {
            gVar.f957b = new j(gVar.e, gVar.h, gVar.g, gVar.f, com.bumptech.glide.load.b.c.a.c(), com.bumptech.glide.load.b.c.a.d(), gVar.o);
        }
        f fVar = new f(applicationContext, gVar.f957b, gVar.e, gVar.f958c, gVar.d, new com.bumptech.glide.manager.k(gVar.m), gVar.j, gVar.k, gVar.l.n(), gVar.f956a);
        Iterator<com.bumptech.glide.d.c> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
        applicationContext.registerComponentCallbacks(fVar);
        j = fVar;
    }

    private void b(o oVar) {
        synchronized (this.g) {
            if (!this.g.contains(oVar)) {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
            this.g.remove(oVar);
        }
    }

    @NonNull
    private com.bumptech.glide.load.b.a.e c() {
        return this.f948a;
    }

    @NonNull
    public static o c(@NonNull Context context) {
        return f(context).a(context);
    }

    @NonNull
    private com.bumptech.glide.load.b.a.b d() {
        return this.d;
    }

    private static void d(@NonNull Context context) {
        if (k) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        k = true;
        b(context, new g());
        k = false;
    }

    @NonNull
    private Context e() {
        return this.f949b.getBaseContext();
    }

    private static void e(@NonNull Context context) {
        b(context, new g());
    }

    private com.bumptech.glide.manager.d f() {
        return this.f;
    }

    @NonNull
    private static com.bumptech.glide.manager.k f(@Nullable Context context) {
        com.bumptech.glide.util.i.a(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return b(context).e;
    }

    @NonNull
    private h g() {
        return this.f949b;
    }

    private void h() {
        com.bumptech.glide.util.k.a();
        this.m.c();
        this.f948a.b();
        this.d.a();
    }

    private void i() {
        com.bumptech.glide.util.k.b();
        this.l.e.a().a();
    }

    @NonNull
    private com.bumptech.glide.manager.k j() {
        return this.e;
    }

    @NonNull
    private m k() {
        return this.f950c;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(@NonNull Target<?> target) {
        synchronized (this.g) {
            for (o b2 : this.g) {
                if (b2.b(target)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        com.bumptech.glide.util.k.a();
        this.m.c();
        this.f948a.b();
        this.d.a();
    }

    public void onTrimMemory(int i2) {
        com.bumptech.glide.util.k.a();
        this.m.a(i2);
        this.f948a.a(i2);
        this.d.a(i2);
    }
}
