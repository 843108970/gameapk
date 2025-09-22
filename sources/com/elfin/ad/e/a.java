package com.elfin.ad.e;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.cyjh.common.util.ag;
import com.cyjh.http.bean.response.BackgroundSetAdInfo;
import com.cyjh.http.bean.response.FlySettingInfo;
import com.elfin.ad.R;
import com.elfin.ad.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class a {
    private static a e = null;
    private static final int f = 32;

    /* renamed from: a  reason: collision with root package name */
    public List<BackgroundSetAdInfo> f2862a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public BackgroundSetAdInfo f2863b;

    /* renamed from: c  reason: collision with root package name */
    public List<FlySettingInfo> f2864c = new ArrayList();
    public int d;
    private FlySettingInfo g;

    private a() {
    }

    public static a a() {
        if (e == null) {
            synchronized (a.class) {
                if (e == null) {
                    e = new a();
                }
            }
        }
        return e;
    }

    public final b a(int i, String str) {
        b bVar = new b();
        boolean z = true;
        if (this.f2864c == null || this.f2864c.size() <= 0) {
            bVar.f2849a = true;
            bVar.f2850b = str;
            return bVar;
        }
        Iterator<FlySettingInfo> it = this.f2864c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            FlySettingInfo next = it.next();
            if (i == next.AdType) {
                this.g = next;
                break;
            }
        }
        int nextInt = new Random().nextInt(100) + 1;
        if (this.g.Active != 1 || ((double) nextInt) >= this.g.Probability) {
            z = false;
        }
        bVar.f2849a = z;
        String str2 = this.g.FlyKey;
        if (TextUtils.isEmpty(str2) && str2.length() != 32) {
            str2 = str;
        }
        bVar.f2850b = str2;
        return bVar;
    }

    public final void a(Context context) {
        String str = this.f2863b.LinkUrl;
        int i = this.f2863b.OpenMethod;
        String str2 = this.f2863b.Title;
        if (i != 3) {
            try {
                Intent intent = new Intent(context, Class.forName("com.cyjh.elfin.ui.activity.H5LinkJumpPageActivity"));
                intent.addFlags(268435456);
                intent.putExtra("com.cyjh.elfin.ui.activity.H5LinkJumpPageActivity", str2);
                intent.putExtra("H5LinkJumpPageActivity", str);
                context.startActivity(intent);
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
        } else if (TextUtils.isEmpty(str) || !str.startsWith("http")) {
            ag.b(com.elfin.ad.a.a().f2831a, com.elfin.ad.a.a().f2831a.getResources().getString(R.string.link_url_error));
        } else {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent2.addFlags(268435456);
            context.startActivity(intent2);
        }
    }

    public final boolean a(int i) {
        if (this.f2862a == null || this.f2862a.size() <= 0) {
            return false;
        }
        Iterator<BackgroundSetAdInfo> it = this.f2862a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            BackgroundSetAdInfo next = it.next();
            if (next.AdType == i) {
                this.f2863b = next;
                if (((double) (new Random().nextInt(100) + 1)) < this.f2863b.Probability) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean b() {
        return this.d == 1;
    }
}
