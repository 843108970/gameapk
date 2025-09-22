package com.c.c;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.text.Editable;
import android.text.Html;
import com.c.b.b;
import com.c.b.c;
import java.util.Locale;
import net.grandcentrix.tray.provider.ContentProviderStorage;
import org.apache.commons.mail.EmailConstants;
import org.json.JSONObject;
import org.xml.sax.XMLReader;

public final class a {
    public static final int k = 0;
    public static final int l = 1;
    public static final int m = 2;
    private static ApplicationInfo q = null;
    private static PackageInfo r = null;
    private static final String s = "aqs.skip";
    private static final String t = "•";
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public Activity f1554a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public com.c.a f1555b;

    /* renamed from: c  reason: collision with root package name */
    C0024a f1556c;
    /* access modifiers changed from: package-private */
    public String d;
    /* access modifiers changed from: package-private */
    public String e;
    boolean f;
    /* access modifiers changed from: package-private */
    public int g;
    /* access modifiers changed from: package-private */
    public String h;
    /* access modifiers changed from: package-private */
    public boolean i;
    /* access modifiers changed from: package-private */
    public boolean j;
    private String n;
    private long o = 720000;
    private int p = 0;

    /* renamed from: com.c.c.a$a  reason: collision with other inner class name */
    private class C0024a implements DialogInterface.OnClickListener, Html.TagHandler {
        private C0024a() {
        }

        /* synthetic */ C0024a(a aVar, byte b2) {
            this();
        }

        private void a(String str) {
            if (str != null && str.length() > 1000) {
                String c2 = a.this.c();
                b bVar = new b();
                bVar.f1539c = c2;
                b bVar2 = bVar;
                bVar2.f1538b = JSONObject.class;
                bVar2.b((Object) this, "marketCb");
                bVar.a(EmailConstants.TEXT_SUBTYPE_HTML, (Object) str);
                ((com.c.a) a.this.f1555b.a(a.this.g)).a(bVar);
            }
        }

        private void a(JSONObject jSONObject) {
            if (!a.this.j) {
                a.this.j = true;
                a.this.g = 0;
                a aVar = a.this;
                if (jSONObject != null) {
                    String optString = jSONObject.optString(ContentProviderStorage.VERSION, "0");
                    int optInt = jSONObject.optInt("code", 0);
                    com.c.d.a.b((Object) ContentProviderStorage.VERSION, (Object) String.valueOf(aVar.b().versionName) + "->" + optString + ":" + aVar.b().versionCode + "->" + optInt);
                    com.c.d.a.b((Object) "outdated", (Object) Boolean.valueOf(aVar.a(optString, optInt)));
                    if ((aVar.f || aVar.a(optString, optInt)) && jSONObject != null && aVar.h == null && (true ^ aVar.f1554a.isFinishing())) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("dialog");
                        String optString2 = optJSONObject.optString("update", "Update");
                        String optString3 = optJSONObject.optString("skip", "Skip");
                        String optString4 = optJSONObject.optString("rate", "Rate");
                        String optString5 = optJSONObject.optString("wbody", "");
                        String optString6 = optJSONObject.optString("title", "Update Available");
                        com.c.d.a.b((Object) "wbody", (Object) optString5);
                        aVar.h = jSONObject.optString(ContentProviderStorage.VERSION, (String) null);
                        AlertDialog create = new AlertDialog.Builder(aVar.f1554a).setIcon(aVar.a().loadIcon(aVar.f1554a.getPackageManager())).setTitle(optString6).setPositiveButton(optString4, aVar.f1556c).setNeutralButton(optString3, aVar.f1556c).setNegativeButton(optString2, aVar.f1556c).create();
                        create.setMessage(Html.fromHtml("<small>" + optString5 + "</small>", (Html.ImageGetter) null, aVar.f1556c));
                        aVar.f1555b.a((Dialog) create);
                    }
                }
            }
        }

        private void a(JSONObject jSONObject, c cVar) {
            if (!a.this.f1554a.isFinishing()) {
                if (jSONObject != null) {
                    String optString = jSONObject.optString(NotificationCompat.CATEGORY_STATUS);
                    if ("1".equals(optString)) {
                        if (jSONObject.has("dialog")) {
                            a(jSONObject);
                        }
                        if (!a.this.i && jSONObject.optBoolean("fetch", false) && cVar.r == 1) {
                            a.this.i = true;
                            String optString2 = jSONObject.optString("marketUrl", (String) null);
                            b bVar = new b();
                            bVar.f1539c = optString2;
                            b bVar2 = bVar;
                            bVar2.f1538b = String.class;
                            bVar2.b((Object) this, "detailCb");
                            ((com.c.a) a.this.f1555b.a(a.this.g)).a(bVar);
                        }
                    } else if ("0".equals(optString)) {
                        cVar.u = true;
                    } else {
                        a(jSONObject);
                    }
                } else {
                    a(jSONObject);
                }
            }
        }

        public final void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
            if (!"li".equals(str)) {
                return;
            }
            if (z) {
                editable.append("  ");
                editable.append(a.t);
                editable.append("  ");
                return;
            }
            editable.append("\n");
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            Activity activity;
            String str;
            switch (i) {
                case -3:
                    Activity activity2 = a.this.f1554a;
                    PreferenceManager.getDefaultSharedPreferences(activity2).edit().putString(a.s, a.this.h).commit();
                    return;
                case -2:
                    activity = a.this.f1554a;
                    str = a.this.e;
                    break;
                case -1:
                    activity = a.this.f1554a;
                    str = a.this.d;
                    break;
                default:
                    return;
            }
            a.a(activity, str);
        }
    }

    private a(Activity activity) {
        this.f1554a = activity;
        this.f1555b = new com.c.a(activity);
        this.f1556c = new C0024a(this, (byte) 0);
        this.n = Locale.getDefault().toString();
        String str = a().packageName;
        this.d = "market://details?id=" + str;
        this.e = this.d;
    }

    private a a(int i2) {
        this.p = i2;
        return this;
    }

    private a a(long j2) {
        this.o = j2;
        return this;
    }

    private a a(String str) {
        this.d = str;
        return this;
    }

    private a a(boolean z) {
        this.f = z;
        return this;
    }

    private static String a(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(s, (String) null);
    }

    private static void a(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(s, str).commit();
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString(ContentProviderStorage.VERSION, "0");
            int optInt = jSONObject.optInt("code", 0);
            com.c.d.a.b((Object) ContentProviderStorage.VERSION, (Object) String.valueOf(b().versionName) + "->" + optString + ":" + b().versionCode + "->" + optInt);
            com.c.d.a.b((Object) "outdated", (Object) Boolean.valueOf(a(optString, optInt)));
            if ((this.f || a(optString, optInt)) && jSONObject != null && this.h == null && (!this.f1554a.isFinishing())) {
                JSONObject optJSONObject = jSONObject.optJSONObject("dialog");
                String optString2 = optJSONObject.optString("update", "Update");
                String optString3 = optJSONObject.optString("skip", "Skip");
                String optString4 = optJSONObject.optString("rate", "Rate");
                String optString5 = optJSONObject.optString("wbody", "");
                String optString6 = optJSONObject.optString("title", "Update Available");
                com.c.d.a.b((Object) "wbody", (Object) optString5);
                this.h = jSONObject.optString(ContentProviderStorage.VERSION, (String) null);
                AlertDialog create = new AlertDialog.Builder(this.f1554a).setIcon(a().loadIcon(this.f1554a.getPackageManager())).setTitle(optString6).setPositiveButton(optString4, this.f1556c).setNeutralButton(optString3, this.f1556c).setNegativeButton(optString2, this.f1556c).create();
                create.setMessage(Html.fromHtml("<small>" + optString5 + "</small>", (Html.ImageGetter) null, this.f1556c));
                this.f1555b.a((Dialog) create);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static boolean a(Activity activity, String str) {
        if (str == null) {
            return false;
        }
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean a(String str, String str2, int i2) {
        if (str.equals(str2)) {
            return false;
        }
        try {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            if (split.length < 3 || split2.length < 3) {
                return true;
            }
            switch (i2) {
                case 0:
                    if (!split[split.length - 1].equals(split2[split2.length - 1])) {
                        return true;
                    }
                    break;
                case 1:
                    break;
                case 2:
                    break;
                default:
                    return true;
            }
            if (!split[split.length - 2].equals(split2[split2.length - 2])) {
                return true;
            }
            return !split[split.length - 3].equals(split2[split2.length - 3]);
        } catch (Exception e2) {
            com.c.d.a.b((Throwable) e2);
            return true;
        }
    }

    private a b(int i2) {
        this.g = i2;
        return this;
    }

    private a b(String str) {
        this.e = str;
        return this;
    }

    private void b(JSONObject jSONObject) {
        if (jSONObject != null && this.h == null && (!this.f1554a.isFinishing())) {
            JSONObject optJSONObject = jSONObject.optJSONObject("dialog");
            String optString = optJSONObject.optString("update", "Update");
            String optString2 = optJSONObject.optString("skip", "Skip");
            String optString3 = optJSONObject.optString("rate", "Rate");
            String optString4 = optJSONObject.optString("wbody", "");
            String optString5 = optJSONObject.optString("title", "Update Available");
            com.c.d.a.b((Object) "wbody", (Object) optString4);
            this.h = jSONObject.optString(ContentProviderStorage.VERSION, (String) null);
            AlertDialog create = new AlertDialog.Builder(this.f1554a).setIcon(a().loadIcon(this.f1554a.getPackageManager())).setTitle(optString5).setPositiveButton(optString3, this.f1556c).setNeutralButton(optString2, this.f1556c).setNegativeButton(optString, this.f1556c).create();
            create.setMessage(Html.fromHtml("<small>" + optString4 + "</small>", (Html.ImageGetter) null, this.f1556c));
            this.f1555b.a((Dialog) create);
        }
    }

    private a c(String str) {
        this.n = str;
        return this;
    }

    private static String d() {
        return "https://androidquery.appspot.com";
    }

    private static String d(String str) {
        return "<small>" + str + "</small>";
    }

    private String e() {
        return a().packageName;
    }

    private Drawable f() {
        return a().loadIcon(this.f1554a.getPackageManager());
    }

    private String g() {
        return b().versionName;
    }

    private int h() {
        return b().versionCode;
    }

    private void i() {
        String c2 = c();
        b bVar = new b();
        bVar.f1539c = c2;
        b bVar2 = bVar;
        bVar2.f1538b = JSONObject.class;
        ((b) ((b) bVar2.b((Object) this.f1556c, "marketCb")).a(!this.f)).p = this.o;
        ((com.c.a) this.f1555b.a(this.g)).a(bVar);
    }

    private String j() {
        String str = a().packageName;
        return "market://details?id=" + str;
    }

    private boolean k() {
        return !this.f1554a.isFinishing();
    }

    /* access modifiers changed from: package-private */
    public final ApplicationInfo a() {
        if (q == null) {
            q = this.f1554a.getApplicationInfo();
        }
        return q;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(String str, int i2) {
        if (str.equals(PreferenceManager.getDefaultSharedPreferences(this.f1554a).getString(s, (String) null))) {
            return false;
        }
        String str2 = b().versionName;
        int i3 = b().versionCode;
        if (str2.equals(str) || i3 > i2) {
            return false;
        }
        return a(str2, str, this.p);
    }

    /* access modifiers changed from: package-private */
    public final PackageInfo b() {
        if (r == null) {
            try {
                r = this.f1554a.getPackageManager().getPackageInfo(a().packageName, 0);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return r;
    }

    /* access modifiers changed from: package-private */
    public final String c() {
        String str = String.valueOf("https://androidquery.appspot.com") + "/api/market?app=" + a().packageName + "&locale=" + this.n + "&version=" + b().versionName + "&code=" + b().versionCode + "&aq=0.26.7";
        if (!this.f) {
            return str;
        }
        return String.valueOf(str) + "&force=true";
    }
}
