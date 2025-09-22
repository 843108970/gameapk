package com.cyjh.common.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.bumptech.glide.f;
import com.bumptech.glide.l;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.b.i;
import com.bumptech.glide.load.b.p;
import com.bumptech.glide.load.m;
import com.bumptech.glide.n;
import com.bumptech.glide.request.g;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.cyjh.common.R;
import com.cyjh.common.f.b;
import java.io.File;

public final class q {
    private q() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static g a() {
        return new g().a(R.drawable.bg_normal_pic).c(R.drawable.bg_normal_pic).a(l.NORMAL);
    }

    private static void a(Context context, int i, ImageView imageView) {
        if (a(context)) {
            f.c(context).a(Integer.valueOf(i)).a(a()).a(imageView);
        }
    }

    private static void a(Context context, int i, ImageView imageView, g gVar) {
        if (a(context)) {
            f.c(context).a(Integer.valueOf(i)).a(gVar).a(imageView);
        }
    }

    private static void a(Context context, File file, ImageView imageView) {
        if (a(context)) {
            f.c(context).a(file).a(a()).a(imageView);
        }
    }

    private static void a(Context context, String str, ImageView imageView) {
        if (a(context)) {
            f.c(context).b().a(str).a(imageView);
        }
    }

    private static void a(Context context, String str, ImageView imageView, m mVar) {
        if (a(context)) {
            f.c(context).a(str).a(new g().a(R.drawable.bg_normal_pic).c(R.drawable.bg_normal_pic).a(l.NORMAL).a((m<Bitmap>) mVar)).a(imageView);
        }
    }

    public static void a(Context context, String str, ImageView imageView, g gVar) {
        if (a(context)) {
            f.c(context).b().a(str).a(gVar).a(imageView);
        }
    }

    @SuppressLint({"CheckResult"})
    private static void a(Context context, String str, final com.bumptech.glide.request.f<File> fVar) {
        if (a(context)) {
            n<File> d = f.c(context).d();
            d.a(str);
            d.a((com.bumptech.glide.request.f<File>) new com.bumptech.glide.request.f<File>() {
                private boolean a(File file, Object obj, Target<File> target, a aVar, boolean z) {
                    if (fVar != null) {
                        return fVar.a(file, obj, target, aVar, z);
                    }
                    return false;
                }

                public final boolean a(@Nullable p pVar, Object obj, Target<File> target, boolean z) {
                    if (fVar != null) {
                        return fVar.a(pVar, obj, target, z);
                    }
                    return false;
                }

                public final /* bridge */ /* synthetic */ boolean a(Object obj, Object obj2, Target target, a aVar, boolean z) {
                    File file = (File) obj;
                    if (fVar != null) {
                        return fVar.a(file, obj2, target, aVar, z);
                    }
                    return false;
                }
            });
            d.c();
        }
    }

    private static void a(Context context, String str, g gVar, final b bVar) {
        if (a(context)) {
            f.c(context).a().a(str).a(gVar).a(new SimpleTarget<Bitmap>() {
                private static void a() {
                }

                public final /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object obj, @Nullable com.bumptech.glide.request.a.f fVar) {
                }
            });
        }
    }

    private static void a(Context context, byte[] bArr, ImageView imageView) {
        if (a(context)) {
            f.c(context).a(bArr).a(new g().a(R.drawable.bg_normal_pic).c(R.drawable.bg_normal_pic).a(l.HIGH).b(i.f1142a)).a(imageView);
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        return Build.VERSION.SDK_INT >= 17 ? !activity.isDestroyed() && !activity.isFinishing() : !activity.isFinishing();
    }

    private static g b() {
        return new g().e().a(R.drawable.bg_normal_pic).c(R.drawable.bg_normal_pic).a(l.NORMAL);
    }

    private static void b(Context context, String str, ImageView imageView) {
        if (a(context)) {
            f.c(context).a(str).a(a()).a(imageView);
        }
    }

    public static void b(Context context, String str, ImageView imageView, g gVar) {
        if (a(context)) {
            f.c(context).a(str).a(gVar).a(imageView);
        }
    }

    private static void c(Context context, String str, ImageView imageView) {
        if (str.endsWith(".gif")) {
            g a2 = a();
            a2.b(i.f1144c);
            a(context, str, imageView, a2);
            return;
        }
        g a3 = a();
        a3.b(i.f1143b);
        b(context, str, imageView, a3);
    }
}
