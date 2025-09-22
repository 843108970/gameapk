package com.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.c.a.a;
import com.c.b;
import com.c.b.e;
import com.c.b.h;
import com.c.d.c;
import com.c.d.d;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Constructor;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.http.HttpHost;

public abstract class b<T extends b<T>> implements d {
    private static final Class<?>[] Y = {View.class};
    private static Class<?>[] Z = {AdapterView.class, View.class, Integer.TYPE, Long.TYPE};
    private static Class<?>[] aa = {AbsListView.class, Integer.TYPE};
    private static final Class<?>[] ab = {CharSequence.class, Integer.TYPE, Integer.TYPE, Integer.TYPE};
    private static Class<?>[] ac = {Integer.TYPE, Integer.TYPE};
    private static final Class<?>[] ad = {Integer.TYPE};
    private static Class<?>[] ae = {Integer.TYPE, Paint.class};
    private static WeakHashMap<Dialog, Void> af = new WeakHashMap<>();
    private View R;
    private Activity S;
    private Context T;
    private h U;
    private int V = 0;
    private HttpHost W;
    private Constructor<T> X;

    /* renamed from: a  reason: collision with root package name */
    protected View f1534a;

    /* renamed from: b  reason: collision with root package name */
    protected Object f1535b;

    /* renamed from: c  reason: collision with root package name */
    protected a f1536c;

    public b(Activity activity) {
        this.S = activity;
    }

    public b(Activity activity, View view) {
        this.R = view;
        this.f1534a = view;
        this.S = activity;
    }

    public b(Context context) {
        this.T = context;
    }

    public b(View view) {
        this.R = view;
        this.f1534a = view;
    }

    private Object A() {
        if (this.f1534a instanceof AdapterView) {
            return ((AdapterView) this.f1534a).getSelectedItem();
        }
        return null;
    }

    private int B() {
        if (this.f1534a instanceof AdapterView) {
            return ((AdapterView) this.f1534a).getSelectedItemPosition();
        }
        return -1;
    }

    private c C() {
        AbsListView absListView = (AbsListView) this.f1534a;
        c cVar = (c) absListView.getTag(d.z);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        absListView.setOnScrollListener(cVar2);
        absListView.setTag(d.z, cVar2);
        com.c.d.a.a((Object) "set scroll listenr");
        return cVar2;
    }

    private T D() {
        if (this.f1534a != null) {
            com.c.d.a.a((Object) this.f1534a, "setLayerType", false, false, ae, 1, null);
        }
        return this;
    }

    private T E() {
        if (this.S != null) {
            this.S.getWindow().setFlags(16777216, 16777216);
        }
        return this;
    }

    private T F() {
        if (this.f1534a != null) {
            if (this.f1534a instanceof ImageView) {
                ImageView imageView = (ImageView) this.f1534a;
                imageView.setImageBitmap((Bitmap) null);
                imageView.setTag(d.y, (Object) null);
                return this;
            } else if (this.f1534a instanceof WebView) {
                WebView webView = (WebView) this.f1534a;
                webView.stopLoading();
                webView.clearView();
                webView.setTag(d.y, (Object) null);
                return this;
            } else if (this.f1534a instanceof TextView) {
                ((TextView) this.f1534a).setText("");
            }
        }
        return this;
    }

    private Context G() {
        return this.S != null ? this.S : this.R != null ? this.R.getContext() : this.T;
    }

    private void H() {
        this.f1536c = null;
        this.f1535b = null;
        this.U = null;
        this.V = 0;
        this.W = null;
    }

    private T I() {
        com.c.b.b.c();
        return this;
    }

    private T J() {
        if (this.f1534a != null) {
            this.f1534a.performClick();
        }
        return this;
    }

    private T K() {
        if (this.f1534a != null) {
            this.f1534a.performLongClick();
        }
        return this;
    }

    private T L() {
        Iterator<Dialog> it = af.keySet().iterator();
        while (it.hasNext()) {
            try {
                it.next().dismiss();
            } catch (Exception unused) {
            }
            it.remove();
        }
        return this;
    }

    private View a(View view, int i, ViewGroup viewGroup) {
        Integer num;
        if (view != null && (num = (Integer) view.getTag(d.A)) != null && num.intValue() == i) {
            return view;
        }
        View inflate = (this.S != null ? this.S.getLayoutInflater() : (LayoutInflater) G().getSystemService("layout_inflater")).inflate(i, viewGroup, false);
        inflate.setTag(d.A, Integer.valueOf(i));
        return inflate;
    }

    private View a(String str) {
        View childAt;
        if (this.R != null) {
            childAt = this.R;
        } else if (this.S == null || (childAt = ((ViewGroup) this.S.findViewById(16908290)).getChildAt(0)) == null) {
            return null;
        }
        return childAt.findViewWithTag(str);
    }

    private View a(int... iArr) {
        View b2 = b(iArr[0]);
        for (int i = 1; i < iArr.length && b2 != null; i++) {
            b2 = b2.findViewById(iArr[i]);
        }
        return b2;
    }

    private T a(float f) {
        if (this.f1534a instanceof RatingBar) {
            ((RatingBar) this.f1534a).setRating(f);
        }
        return this;
    }

    private T a(float f, float f2, float f3, float f4) {
        if (this.f1534a != null) {
            ViewGroup.LayoutParams layoutParams = this.f1534a.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                Context G = G();
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(com.c.d.a.a(G, f), com.c.d.a.a(G, f2), com.c.d.a.a(G, f3), com.c.d.a.a(G, f4));
                this.f1534a.setLayoutParams(layoutParams);
            }
        }
        return this;
    }

    private T a(int i, int i2) {
        if (this.S != null) {
            com.c.d.a.a((Object) this.S, "overridePendingTransition", false, false, ac, Integer.valueOf(i), Integer.valueOf(i2));
        }
        return this;
    }

    private T a(int i, Object obj) {
        if (this.f1534a != null) {
            this.f1534a.setTag(i, obj);
        }
        return this;
    }

    private T a(int i, boolean z) {
        a(true, i, z);
        return this;
    }

    private T a(int i, Object... objArr) {
        Context G = G();
        if (G != null) {
            a((CharSequence) G.getString(i, objArr));
        }
        return this;
    }

    private T a(Bitmap bitmap) {
        if (this.f1534a instanceof ImageView) {
            ImageView imageView = (ImageView) this.f1534a;
            imageView.setTag(d.y, (Object) null);
            imageView.setImageBitmap(bitmap);
        }
        return this;
    }

    private T a(Bitmap bitmap, float f) {
        com.c.b.d dVar = new com.c.b.d();
        dVar.y = f;
        dVar.x = bitmap;
        return a(dVar);
    }

    private T a(Typeface typeface) {
        if (this.f1534a instanceof TextView) {
            ((TextView) this.f1534a).setTypeface(typeface);
        }
        return this;
    }

    private T a(Drawable drawable) {
        if (this.f1534a instanceof ImageView) {
            ImageView imageView = (ImageView) this.f1534a;
            imageView.setTag(d.y, (Object) null);
            imageView.setImageDrawable(drawable);
        }
        return this;
    }

    private T a(Spanned spanned) {
        if (this.f1534a instanceof TextView) {
            ((TextView) this.f1534a).setText(spanned);
        }
        return this;
    }

    private T a(View.OnClickListener onClickListener) {
        if (this.f1534a != null) {
            this.f1534a.setOnClickListener(onClickListener);
        }
        return this;
    }

    private T a(View.OnLongClickListener onLongClickListener) {
        if (this.f1534a != null) {
            this.f1534a.setOnLongClickListener(onLongClickListener);
        }
        return this;
    }

    private T a(View view) {
        T t = null;
        try {
            T t2 = (b) a().newInstance(new Object[]{view});
            try {
                t2.S = this.S;
                return t2;
            } catch (Exception e) {
                Exception exc = e;
                t = t2;
                e = exc;
                e.printStackTrace();
                return t;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return t;
        }
    }

    private T a(Animation animation) {
        if (!(this.f1534a == null || animation == null)) {
            this.f1534a.startAnimation(animation);
        }
        return this;
    }

    private T a(AbsListView.OnScrollListener onScrollListener) {
        if (this.f1534a instanceof AbsListView) {
            C().f1570c = onScrollListener;
        }
        return this;
    }

    private T a(Adapter adapter) {
        if (this.f1534a instanceof AdapterView) {
            ((AdapterView) this.f1534a).setAdapter(adapter);
        }
        return this;
    }

    private T a(AdapterView.OnItemClickListener onItemClickListener) {
        if (this.f1534a instanceof AdapterView) {
            ((AdapterView) this.f1534a).setOnItemClickListener(onItemClickListener);
        }
        return this;
    }

    private T a(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (this.f1534a instanceof AdapterView) {
            ((AdapterView) this.f1534a).setOnItemSelectedListener(onItemSelectedListener);
        }
        return this;
    }

    private T a(ExpandableListAdapter expandableListAdapter) {
        if (this.f1534a instanceof ExpandableListView) {
            ((ExpandableListView) this.f1534a).setAdapter(expandableListAdapter);
        }
        return this;
    }

    private <K> T a(com.c.b.a<?, K> aVar) {
        if (this.f1536c != null) {
            aVar.a(this.f1536c);
        }
        if (this.f1535b != null) {
            aVar.a(this.f1535b);
        }
        if (this.U != null) {
            aVar.h = this.U;
        }
        aVar.j = this.V;
        if (this.W != null) {
            aVar.a(this.W.getHostName(), this.W.getPort());
        }
        if (this.S != null) {
            aVar.a(this.S);
        } else {
            aVar.a(G());
        }
        H();
        return this;
    }

    private T a(com.c.b.d dVar) {
        if (this.f1534a instanceof ImageView) {
            dVar.a((ImageView) this.f1534a);
            a(dVar);
        }
        return this;
    }

    private T a(h hVar) {
        this.U = hVar;
        return this;
    }

    private T a(File file, int i) {
        com.c.b.d dVar = new com.c.b.d();
        dVar.w = file;
        String absolutePath = file != null ? file.getAbsolutePath() : null;
        dVar.u = i;
        dVar.v = 0;
        dVar.f1539c = absolutePath;
        ((com.c.b.d) dVar.b(true)).a(true);
        return a(dVar);
    }

    private T a(CharSequence charSequence) {
        if (this.f1534a instanceof TextView) {
            ((TextView) this.f1534a).setText(charSequence);
        }
        return this;
    }

    private T a(CharSequence charSequence, boolean z) {
        return (!z || !(charSequence == null || charSequence.length() == 0)) ? a(charSequence) : k(8);
    }

    private T a(Object obj) {
        this.f1535b = obj;
        return this;
    }

    private T a(Object obj, String str) {
        c a2 = new c().a(obj, str, Y);
        if (this.f1534a != null) {
            this.f1534a.setOnClickListener(a2);
        }
        return this;
    }

    private T a(String str, int i) {
        this.W = new HttpHost(str, i);
        return this;
    }

    private T a(String str, long j) {
        Class cls = byte[].class;
        com.c.b.b bVar = new com.c.b.b();
        bVar.f1538b = cls;
        ((com.c.b.b) ((com.c.b.b) bVar.a((Object) null, (String) null)).a(true)).p = j;
        return b(str, cls, bVar);
    }

    private T a(String str, e eVar) {
        if (this.f1534a instanceof ImageView) {
            com.c.b.d.a(this.S, G(), (ImageView) this.f1534a, str, this.f1535b, this.f1536c, eVar, this.W);
            H();
        }
        return this;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.c.b.a, com.c.b.b<java.io.File>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private T a(java.lang.String r2, java.io.File r3, com.c.b.b<java.io.File> r4) {
        /*
            r1 = this;
            r4.f1539c = r2
            r2 = r4
            com.c.b.b r2 = (com.c.b.b) r2
            java.lang.Class<java.io.File> r0 = java.io.File.class
            r2.f1538b = r0
            com.c.b.b r2 = (com.c.b.b) r2
            r2.k = r3
            com.c.b r2 = r1.a(r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.a(java.lang.String, java.io.File, com.c.b.b):com.c.b");
    }

    private T a(String str, File file, Object obj, String str2) {
        com.c.b.b bVar = new com.c.b.b();
        bVar.a(obj, str2);
        bVar.f1539c = str;
        com.c.b.b bVar2 = bVar;
        bVar2.f1538b = File.class;
        bVar2.k = file;
        return a(bVar);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Class<K>, java.lang.Class, java.lang.Class<T>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <K> T a(java.lang.String r4, java.lang.Class<K> r5, long r6) {
        /*
            r3 = this;
            com.c.b.b r0 = new com.c.b.b
            r0.<init>()
            r0.f1538b = r5
            r1 = r0
            com.c.b.b r1 = (com.c.b.b) r1
            r2 = 0
            java.lang.Object r1 = r1.a((java.lang.Object) r2, (java.lang.String) r2)
            com.c.b.b r1 = (com.c.b.b) r1
            r2 = 1
            java.lang.Object r1 = r1.a((boolean) r2)
            com.c.b.b r1 = (com.c.b.b) r1
            r1.p = r6
            com.c.b r4 = r3.b((java.lang.String) r4, r5, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.a(java.lang.String, java.lang.Class, long):com.c.b");
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Class<K>, java.lang.Class, java.lang.Class<T>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <K> T a(java.lang.String r3, java.lang.Class<K> r4, java.lang.Object r5, java.lang.String r6) {
        /*
            r2 = this;
            com.c.b.b r0 = new com.c.b.b
            r0.<init>()
            r0.f1538b = r4
            r1 = r0
            com.c.b.b r1 = (com.c.b.b) r1
            r1.a((java.lang.Object) r5, (java.lang.String) r6)
            com.c.b r3 = r2.b((java.lang.String) r3, r4, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.a(java.lang.String, java.lang.Class, java.lang.Object, java.lang.String):com.c.b");
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.c.b.a, com.c.b.b<K>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <K> T a(java.lang.String r1, java.lang.String r2, org.apache.http.HttpEntity r3, java.lang.Class<K> r4, com.c.b.b<K> r5) {
        /*
            r0 = this;
            r5.f1539c = r1
            r1 = r5
            com.c.b.b r1 = (com.c.b.b) r1
            r1.f1538b = r4
            com.c.b.b r1 = (com.c.b.b) r1
            r4 = 3
            r1.q = r4
            com.c.b.b r1 = (com.c.b.b) r1
            java.lang.String r4 = "Content-Type"
            java.lang.Object r1 = r1.a((java.lang.String) r4, (java.lang.String) r2)
            com.c.b.b r1 = (com.c.b.b) r1
            java.lang.String r2 = "%entity"
            r1.a((java.lang.String) r2, (java.lang.Object) r3)
            com.c.b r1 = r0.a(r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.a(java.lang.String, java.lang.String, org.apache.http.HttpEntity, java.lang.Class, com.c.b.b):com.c.b");
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.c.b.a, com.c.b.b<K>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <K> T a(java.lang.String r1, java.util.Map<java.lang.String, ?> r2, java.lang.Class<K> r3, com.c.b.b<K> r4) {
        /*
            r0 = this;
            r4.f1538b = r3
            r3 = r4
            com.c.b.b r3 = (com.c.b.b) r3
            r3.f1539c = r1
            com.c.b.b r3 = (com.c.b.b) r3
            r3.a((java.util.Map<java.lang.String, ?>) r2)
            com.c.b r1 = r0.a(r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.a(java.lang.String, java.util.Map, java.lang.Class, com.c.b.b):com.c.b");
    }

    private <K> T a(String str, Map<String, ?> map, Class<K> cls, Object obj, String str2) {
        com.c.b.b bVar = new com.c.b.b();
        bVar.f1538b = cls;
        com.c.b.b bVar2 = bVar;
        bVar2.a(obj, str2);
        bVar.f1538b = cls;
        bVar2.f1539c = str;
        bVar2.a(map);
        return a(bVar);
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [com.c.b.a, com.c.b.b<K>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <K> T a(java.lang.String r3, org.json.JSONObject r4, java.lang.Class<K> r5, com.c.b.b<K> r6) {
        /*
            r2 = this;
            org.apache.http.entity.StringEntity r0 = new org.apache.http.entity.StringEntity     // Catch:{ UnsupportedEncodingException -> 0x002d }
            java.lang.String r4 = r4.toString()     // Catch:{ UnsupportedEncodingException -> 0x002d }
            java.lang.String r1 = "UTF-8"
            r0.<init>(r4, r1)     // Catch:{ UnsupportedEncodingException -> 0x002d }
            java.lang.String r4 = "application/json"
            r6.f1539c = r3     // Catch:{ UnsupportedEncodingException -> 0x002d }
            r3 = r6
            com.c.b.b r3 = (com.c.b.b) r3     // Catch:{ UnsupportedEncodingException -> 0x002d }
            r3.f1538b = r5     // Catch:{ UnsupportedEncodingException -> 0x002d }
            com.c.b.b r3 = (com.c.b.b) r3     // Catch:{ UnsupportedEncodingException -> 0x002d }
            r5 = 1
            r3.q = r5     // Catch:{ UnsupportedEncodingException -> 0x002d }
            com.c.b.b r3 = (com.c.b.b) r3     // Catch:{ UnsupportedEncodingException -> 0x002d }
            java.lang.String r5 = "Content-Type"
            java.lang.Object r3 = r3.a((java.lang.String) r5, (java.lang.String) r4)     // Catch:{ UnsupportedEncodingException -> 0x002d }
            com.c.b.b r3 = (com.c.b.b) r3     // Catch:{ UnsupportedEncodingException -> 0x002d }
            java.lang.String r4 = "%entity"
            r3.a((java.lang.String) r4, (java.lang.Object) r0)     // Catch:{ UnsupportedEncodingException -> 0x002d }
            com.c.b r3 = r2.a(r6)     // Catch:{ UnsupportedEncodingException -> 0x002d }
            return r3
        L_0x002d:
            r3 = move-exception
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.a(java.lang.String, org.json.JSONObject, java.lang.Class, com.c.b.b):com.c.b");
    }

    private T a(String str, boolean z, int i, com.c.b.d dVar) {
        dVar.u = i;
        dVar.v = 0;
        dVar.f1539c = str;
        ((com.c.b.d) dVar.b(z)).a(true);
        return a(dVar);
    }

    private T a(String str, boolean z, boolean z2) {
        return b(str, z, z2);
    }

    private T a(String str, boolean z, boolean z2, int i, int i2) {
        if (this.f1534a instanceof ImageView) {
            com.c.b.d.a(this.S, G(), (ImageView) this.f1534a, str, z, z2, i, i2, (Bitmap) null, 0, 0.0f, Float.MAX_VALUE, this.f1535b, this.f1536c, this.V, 0, this.W);
            H();
        }
        return this;
    }

    private T a(String str, boolean z, boolean z2, int i, int i2, Bitmap bitmap, int i3) {
        if (this.f1534a instanceof ImageView) {
            com.c.b.d.a(this.S, G(), (ImageView) this.f1534a, str, z, z2, i, i2, bitmap, i3, 0.0f, Float.MAX_VALUE, this.f1535b, this.f1536c, this.V, 0, this.W);
            H();
        }
        return this;
    }

    private T a(String str, boolean z, boolean z2, int i, int i2, Bitmap bitmap, int i3, float f) {
        if (this.f1534a instanceof ImageView) {
            com.c.b.d.a(this.S, G(), (ImageView) this.f1534a, str, z, z2, i, i2, bitmap, i3, f, Float.MAX_VALUE, this.f1535b, this.f1536c, this.V, 0, this.W);
            H();
        }
        return this;
    }

    private T a(boolean z) {
        if (this.f1534a != null) {
            com.c.d.a.a(this.f1534a, z);
        }
        return this;
    }

    private File a(String str, String str2) {
        File c2;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileChannel channel;
        FileChannel channel2;
        File file = null;
        try {
            File d = d(str);
            if (!(d == null || (c2 = com.c.d.a.c()) == null)) {
                File file2 = new File(c2, str2);
                try {
                    file2.createNewFile();
                    fileInputStream = new FileInputStream(d);
                    fileOutputStream = new FileOutputStream(file2);
                    channel = fileInputStream.getChannel();
                    channel2 = fileOutputStream.getChannel();
                    channel.transferTo(0, channel.size(), channel2);
                    com.c.d.a.a((Closeable) fileInputStream);
                    com.c.d.a.a((Closeable) fileOutputStream);
                    com.c.d.a.a((Closeable) channel);
                    com.c.d.a.a((Closeable) channel2);
                    return file2;
                } catch (Exception e) {
                    e = e;
                    file = file2;
                    com.c.d.a.a((Throwable) e);
                    return file;
                } catch (Throwable th) {
                    com.c.d.a.a((Closeable) fileInputStream);
                    com.c.d.a.a((Closeable) fileOutputStream);
                    com.c.d.a.a((Closeable) channel);
                    com.c.d.a.a((Closeable) channel2);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            com.c.d.a.a((Throwable) e);
            return file;
        }
        return file;
    }

    private Object a(String str, Class<?>[] clsArr, Object... objArr) {
        Object obj = this.f1534a;
        if (obj == null) {
            obj = this.S;
        }
        return com.c.d.a.a(obj, str, false, false, clsArr, objArr);
    }

    private Constructor<T> a() {
        if (this.X == null) {
            try {
                this.X = getClass().getConstructor(new Class[]{View.class});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.X;
    }

    private void a(boolean z, int i, boolean z2) {
        if (this.f1534a != null) {
            ViewGroup.LayoutParams layoutParams = this.f1534a.getLayoutParams();
            Context G = G();
            if (i > 0 && z2) {
                i = com.c.d.a.a(G, (float) i);
            }
            if (z) {
                layoutParams.width = i;
            } else {
                layoutParams.height = i;
            }
            this.f1534a.setLayoutParams(layoutParams);
        }
    }

    private static boolean a(int i, int i2, View view, ViewGroup viewGroup, String str) {
        return c.a(i, i2, view, viewGroup, str);
    }

    private static boolean a(int i, View view, ViewGroup viewGroup, String str) {
        return c.a(i, -1, view, viewGroup, str);
    }

    @Deprecated
    private static boolean a(View view, ViewGroup viewGroup, String str) {
        return c.a(view, viewGroup, str);
    }

    private View b(int i) {
        if (this.R != null) {
            return this.R.findViewById(i);
        }
        if (this.S != null) {
            return this.S.findViewById(i);
        }
        return null;
    }

    private T b() {
        return this;
    }

    private T b(float f) {
        if (this.f1534a instanceof TextView) {
            ((TextView) this.f1534a).setTextSize(f);
        }
        return this;
    }

    private T b(int i, boolean z) {
        a(false, i, z);
        return this;
    }

    private T b(View view) {
        this.R = view;
        this.f1534a = view;
        H();
        this.T = null;
        return this;
    }

    private <K> T b(com.c.b.b<K> bVar) {
        a(bVar);
        if (com.c.d.a.b()) {
            throw new IllegalStateException("Cannot block UI thread.");
        }
        if (!bVar.r) {
            try {
                synchronized (bVar) {
                    bVar.s = true;
                    bVar.wait((long) (com.c.b.a.f1537a + com.hlzn.socketclient.b.a.t));
                }
                return this;
            } catch (Exception unused) {
            }
        }
        return this;
    }

    private T b(File file, int i) {
        com.c.b.d dVar = new com.c.b.d();
        dVar.w = file;
        String absolutePath = file != null ? file.getAbsolutePath() : null;
        dVar.u = i;
        dVar.v = 0;
        dVar.f1539c = absolutePath;
        ((com.c.b.d) dVar.b(true)).a(true);
        return a(dVar);
    }

    private T b(Object obj) {
        if (this.f1534a != null) {
            this.f1534a.setTag(obj);
        }
        return this;
    }

    private T b(Object obj, String str) {
        c a2 = new c().a(obj, str, Y);
        if (this.f1534a != null) {
            this.f1534a.setOnLongClickListener(a2);
        }
        return this;
    }

    private T b(String str) {
        View view;
        View childAt;
        if (this.R != null) {
            childAt = this.R;
        } else if (this.S == null || (childAt = ((ViewGroup) this.S.findViewById(16908290)).getChildAt(0)) == null) {
            view = null;
            return c(view);
        }
        view = childAt.findViewWithTag(str);
        return c(view);
    }

    private T b(String str, e eVar) {
        if (this.f1534a instanceof ImageView) {
            com.c.b.d.a(this.S, G(), (ImageView) this.f1534a, str, this.f1535b, this.f1536c, eVar, this.W);
            H();
        }
        return this;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.c.b.a, com.c.b.b<K>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <K> T b(java.lang.String r1, java.lang.Class<K> r2, com.c.b.b<K> r3) {
        /*
            r0 = this;
            r3.f1538b = r2
            r2 = r3
            com.c.b.b r2 = (com.c.b.b) r2
            r2.f1539c = r1
            com.c.b r1 = r0.a(r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.b(java.lang.String, java.lang.Class, com.c.b.b):com.c.b");
    }

    private <K> T b(String str, Class<K> cls, Object obj, String str2) {
        com.c.b.b bVar = new com.c.b.b();
        bVar.a(obj, str2);
        bVar.f1539c = str;
        com.c.b.b bVar2 = bVar;
        bVar2.f1538b = cls;
        bVar2.q = 2;
        return a(bVar);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.c.b.a, com.c.b.b<K>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <K> T b(java.lang.String r1, java.lang.String r2, org.apache.http.HttpEntity r3, java.lang.Class<K> r4, com.c.b.b<K> r5) {
        /*
            r0 = this;
            r5.f1539c = r1
            r1 = r5
            com.c.b.b r1 = (com.c.b.b) r1
            r1.f1538b = r4
            com.c.b.b r1 = (com.c.b.b) r1
            r4 = 1
            r1.q = r4
            com.c.b.b r1 = (com.c.b.b) r1
            java.lang.String r4 = "Content-Type"
            java.lang.Object r1 = r1.a((java.lang.String) r4, (java.lang.String) r2)
            com.c.b.b r1 = (com.c.b.b) r1
            java.lang.String r2 = "%entity"
            r1.a((java.lang.String) r2, (java.lang.Object) r3)
            com.c.b r1 = r0.a(r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.b(java.lang.String, java.lang.String, org.apache.http.HttpEntity, java.lang.Class, com.c.b.b):com.c.b");
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [com.c.b.a, com.c.b.b<K>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <K> T b(java.lang.String r3, org.json.JSONObject r4, java.lang.Class<K> r5, com.c.b.b<K> r6) {
        /*
            r2 = this;
            org.apache.http.entity.StringEntity r0 = new org.apache.http.entity.StringEntity     // Catch:{ UnsupportedEncodingException -> 0x002d }
            java.lang.String r4 = r4.toString()     // Catch:{ UnsupportedEncodingException -> 0x002d }
            java.lang.String r1 = "UTF-8"
            r0.<init>(r4, r1)     // Catch:{ UnsupportedEncodingException -> 0x002d }
            java.lang.String r4 = "application/json"
            r6.f1539c = r3     // Catch:{ UnsupportedEncodingException -> 0x002d }
            r3 = r6
            com.c.b.b r3 = (com.c.b.b) r3     // Catch:{ UnsupportedEncodingException -> 0x002d }
            r3.f1538b = r5     // Catch:{ UnsupportedEncodingException -> 0x002d }
            com.c.b.b r3 = (com.c.b.b) r3     // Catch:{ UnsupportedEncodingException -> 0x002d }
            r5 = 3
            r3.q = r5     // Catch:{ UnsupportedEncodingException -> 0x002d }
            com.c.b.b r3 = (com.c.b.b) r3     // Catch:{ UnsupportedEncodingException -> 0x002d }
            java.lang.String r5 = "Content-Type"
            java.lang.Object r3 = r3.a((java.lang.String) r5, (java.lang.String) r4)     // Catch:{ UnsupportedEncodingException -> 0x002d }
            com.c.b.b r3 = (com.c.b.b) r3     // Catch:{ UnsupportedEncodingException -> 0x002d }
            java.lang.String r4 = "%entity"
            r3.a((java.lang.String) r4, (java.lang.Object) r0)     // Catch:{ UnsupportedEncodingException -> 0x002d }
            com.c.b r3 = r2.a(r6)     // Catch:{ UnsupportedEncodingException -> 0x002d }
            return r3
        L_0x002d:
            r3 = move-exception
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.b(java.lang.String, org.json.JSONObject, java.lang.Class, com.c.b.b):com.c.b");
    }

    private T b(String str, boolean z, boolean z2) {
        if (this.f1534a instanceof ImageView) {
            com.c.b.d.a(this.S, G(), (ImageView) this.f1534a, str, z, z2, 0, 0, (Bitmap) null, 0, 0.0f, Float.MAX_VALUE, this.f1535b, this.f1536c, this.V, 0, this.W);
            H();
        }
        return this;
    }

    private T b(boolean z) {
        if (this.f1534a != null) {
            this.f1534a.setEnabled(z);
        }
        return this;
    }

    private T b(int... iArr) {
        View b2 = b(iArr[0]);
        for (int i = 1; i < iArr.length && b2 != null; i++) {
            b2 = b2.findViewById(iArr[i]);
        }
        return c(b2);
    }

    private static boolean b(int i, View view, ViewGroup viewGroup, String str) {
        if (!(viewGroup instanceof ExpandableListView)) {
            return c.a(i, view, viewGroup, str);
        }
        throw new IllegalArgumentException("Please use the other shouldDelay methods for expandable list.");
    }

    @Deprecated
    private static boolean b(View view, ViewGroup viewGroup, String str) {
        return c.a(view, viewGroup, str);
    }

    private View c() {
        return this.f1534a;
    }

    private T c(int i) {
        return a(b(i));
    }

    private T c(int i, boolean z) {
        if (this.f1534a instanceof ExpandableListView) {
            ExpandableListView expandableListView = (ExpandableListView) this.f1534a;
            if (z) {
                expandableListView.expandGroup(i);
                return this;
            }
            expandableListView.collapseGroup(i);
        }
        return this;
    }

    private T c(Dialog dialog) {
        this.f1535b = dialog;
        return this;
    }

    private T c(View view) {
        this.f1534a = view;
        H();
        return this;
    }

    private T c(Object obj, String str) {
        c a2 = new c().a(obj, str, Z);
        if (this.f1534a instanceof AdapterView) {
            ((AdapterView) this.f1534a).setOnItemClickListener(a2);
        }
        return this;
    }

    private T c(String str) {
        return b(str, true, true);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.c.b.a, com.c.b.b<K>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <K> T c(java.lang.String r1, java.lang.Class<K> r2, com.c.b.b<K> r3) {
        /*
            r0 = this;
            r3.f1539c = r1
            r1 = r3
            com.c.b.b r1 = (com.c.b.b) r1
            r1.f1538b = r2
            com.c.b.b r1 = (com.c.b.b) r1
            r2 = 2
            r1.q = r2
            com.c.b r1 = r0.a(r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.c(java.lang.String, java.lang.Class, com.c.b.b):com.c.b");
    }

    private T c(boolean z) {
        if (this.f1534a instanceof CompoundButton) {
            ((CompoundButton) this.f1534a).setChecked(z);
        }
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r0 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private T d(int r3) {
        /*
            r2 = this;
            android.view.View r0 = r2.f1534a
        L_0x0002:
            if (r0 != 0) goto L_0x0005
            goto L_0x0017
        L_0x0005:
            int r1 = r0.getId()
            if (r1 != r3) goto L_0x000c
            goto L_0x0018
        L_0x000c:
            android.view.ViewParent r0 = r0.getParent()
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L_0x0017
            android.view.View r0 = (android.view.View) r0
            goto L_0x0002
        L_0x0017:
            r0 = 0
        L_0x0018:
            com.c.b r3 = r2.a((android.view.View) r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.d(int):com.c.b");
    }

    private T d(Object obj, String str) {
        c a2 = new c().a(obj, str, Z);
        if (this.f1534a instanceof AdapterView) {
            ((AdapterView) this.f1534a).setOnItemSelectedListener(a2);
        }
        return this;
    }

    private T d(boolean z) {
        if (this.f1534a != null) {
            this.f1534a.setClickable(z);
        }
        return this;
    }

    private File d(String str) {
        File b2 = com.c.d.a.b(com.c.d.a.a(G(), 1), str);
        return b2 == null ? com.c.d.a.b(com.c.d.a.a(G(), 0), str) : b2;
    }

    private boolean d() {
        if (this.f1534a instanceof CompoundButton) {
            return ((CompoundButton) this.f1534a).isChecked();
        }
        return false;
    }

    private T e() {
        return k(8);
    }

    private T e(int i) {
        return c(b(i));
    }

    private T e(Object obj, String str) {
        if (this.f1534a instanceof AbsListView) {
            C().a(obj, str, aa);
        }
        return this;
    }

    private T e(String str) {
        File d = d(str);
        if (d != null) {
            d.delete();
        }
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = (android.widget.ExpandableListView) r3.f1534a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private T e(boolean r4) {
        /*
            r3 = this;
            android.view.View r0 = r3.f1534a
            boolean r0 = r0 instanceof android.widget.ExpandableListView
            if (r0 == 0) goto L_0x0024
            android.view.View r0 = r3.f1534a
            android.widget.ExpandableListView r0 = (android.widget.ExpandableListView) r0
            android.widget.ExpandableListAdapter r1 = r0.getExpandableListAdapter()
            if (r1 == 0) goto L_0x0024
            int r1 = r1.getGroupCount()
            r2 = 0
        L_0x0015:
            if (r2 < r1) goto L_0x0018
            return r3
        L_0x0018:
            if (r4 == 0) goto L_0x001e
            r0.expandGroup(r2)
            goto L_0x0021
        L_0x001e:
            r0.collapseGroup(r2)
        L_0x0021:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0024:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.e(boolean):com.c.b");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r2 = d(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap f(java.lang.String r2) {
        /*
            r1 = this;
            android.graphics.Bitmap r0 = com.c.b.d.e((java.lang.String) r2)
            if (r0 != 0) goto L_0x0014
            java.io.File r2 = r1.d((java.lang.String) r2)
            if (r2 == 0) goto L_0x0014
            java.lang.String r2 = r2.getAbsolutePath()
            android.graphics.Bitmap r0 = com.c.b.d.c((java.lang.String) r2)
        L_0x0014:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.f(java.lang.String):android.graphics.Bitmap");
    }

    private T f() {
        return k(4);
    }

    private T f(int i) {
        this.V = i;
        return this;
    }

    private T f(Object obj, String str) {
        if (this.f1534a instanceof TextView) {
            ((TextView) this.f1534a).addTextChangedListener(new c().a(obj, str, ab));
        }
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r2 = d(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap g(java.lang.String r2) {
        /*
            r1 = this;
            android.graphics.Bitmap r0 = com.c.b.d.e((java.lang.String) r2)
            if (r0 != 0) goto L_0x0014
            java.io.File r2 = r1.d((java.lang.String) r2)
            if (r2 == 0) goto L_0x0014
            java.lang.String r2 = r2.getAbsolutePath()
            android.graphics.Bitmap r0 = com.c.b.d.c((java.lang.String) r2)
        L_0x0014:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.g(java.lang.String):android.graphics.Bitmap");
    }

    private T g() {
        return k(0);
    }

    private T g(int i) {
        if (this.f1534a instanceof TextView) {
            ((TextView) this.f1534a).setText(i);
        }
        return this;
    }

    private T h() {
        if (this.f1534a instanceof AdapterView) {
            Adapter adapter = ((AdapterView) this.f1534a).getAdapter();
            if (adapter instanceof BaseAdapter) {
                ((BaseAdapter) adapter).notifyDataSetChanged();
            }
        }
        return this;
    }

    private T h(int i) {
        if (this.f1534a instanceof TextView) {
            ((TextView) this.f1534a).setTextColor(i);
        }
        return this;
    }

    private T h(String str) {
        if (this.f1534a instanceof WebView) {
            if (this.f1534a != null) {
                com.c.d.a.a((Object) this.f1534a, "setLayerType", false, false, ae, 1, null);
            }
            com.c.d.h hVar = new com.c.d.h((WebView) this.f1534a, str, this.f1535b);
            if (!hVar.f1579c.equals(hVar.f1578b.getTag(d.y))) {
                hVar.f1578b.setTag(d.y, hVar.f1579c);
                if (Build.VERSION.SDK_INT <= 10) {
                    hVar.f1578b.setDrawingCacheEnabled(true);
                }
                com.c.d.h.a(hVar.f1578b.getContext());
                WebSettings settings = hVar.f1578b.getSettings();
                settings.setSupportZoom(hVar.d);
                settings.setBuiltInZoomControls(hVar.d);
                if (!hVar.e) {
                    com.c.d.h.a(hVar.f1578b);
                }
                settings.setJavaScriptEnabled(true);
                hVar.f1578b.setBackgroundColor(hVar.f);
                if (hVar.f1577a != null) {
                    c.a(hVar.f1577a, hVar.f1579c, true);
                }
                if (hVar.f1578b.getWidth() > 0) {
                    hVar.a();
                } else {
                    hVar.f1578b.setPictureListener(new WebView.PictureListener() {
                        public final void onNewPicture(WebView webView, Picture picture) {
                            h.this.f1578b.setPictureListener((WebView.PictureListener) null);
                            h.this.a();
                        }
                    });
                    hVar.f1578b.loadData("<html></html>", "text/html", "utf-8");
                    hVar.f1578b.setBackgroundColor(hVar.f);
                }
            }
            this.f1535b = null;
        }
        return this;
    }

    private T i(int i) {
        int color = G().getResources().getColor(i);
        if (this.f1534a instanceof TextView) {
            ((TextView) this.f1534a).setTextColor(color);
        }
        return this;
    }

    private T i(String str) {
        if (this.f1534a instanceof WebView) {
            if (this.f1534a != null) {
                com.c.d.a.a((Object) this.f1534a, "setLayerType", false, false, ae, 1, null);
            }
            com.c.d.h hVar = new com.c.d.h((WebView) this.f1534a, str, this.f1535b);
            if (!hVar.f1579c.equals(hVar.f1578b.getTag(d.y))) {
                hVar.f1578b.setTag(d.y, hVar.f1579c);
                if (Build.VERSION.SDK_INT <= 10) {
                    hVar.f1578b.setDrawingCacheEnabled(true);
                }
                com.c.d.h.a(hVar.f1578b.getContext());
                WebSettings settings = hVar.f1578b.getSettings();
                settings.setSupportZoom(hVar.d);
                settings.setBuiltInZoomControls(hVar.d);
                if (!hVar.e) {
                    com.c.d.h.a(hVar.f1578b);
                }
                settings.setJavaScriptEnabled(true);
                hVar.f1578b.setBackgroundColor(hVar.f);
                if (hVar.f1577a != null) {
                    c.a(hVar.f1577a, hVar.f1579c, true);
                }
                if (hVar.f1578b.getWidth() > 0) {
                    hVar.a();
                } else {
                    hVar.f1578b.setPictureListener(new WebView.PictureListener() {
                        public final void onNewPicture(
/*
Method generation error in method: com.c.d.h.1.onNewPicture(android.webkit.WebView, android.graphics.Picture):void, dex: classes.dex
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.c.d.h.1.onNewPicture(android.webkit.WebView, android.graphics.Picture):void, class status: UNLOADED
                        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        
*/
                    });
                    hVar.f1578b.loadData("<html></html>", "text/html", "utf-8");
                    hVar.f1578b.setBackgroundColor(hVar.f);
                }
            }
            this.f1535b = null;
        }
        return this;
    }

    private boolean i() {
        return this.f1534a != null;
    }

    private T j(int i) {
        if (this.f1534a instanceof ImageView) {
            ImageView imageView = (ImageView) this.f1534a;
            imageView.setTag(d.y, (Object) null);
            if (i == 0) {
                imageView.setImageBitmap((Bitmap) null);
                return this;
            }
            imageView.setImageResource(i);
        }
        return this;
    }

    private Object j() {
        if (this.f1534a != null) {
            return this.f1534a.getTag();
        }
        return null;
    }

    private ImageView k() {
        return (ImageView) this.f1534a;
    }

    private T k(int i) {
        if (!(this.f1534a == null || this.f1534a.getVisibility() == i)) {
            this.f1534a.setVisibility(i);
        }
        return this;
    }

    private Gallery l() {
        return (Gallery) this.f1534a;
    }

    private T l(int i) {
        if (this.f1534a != null) {
            if (i != 0) {
                this.f1534a.setBackgroundResource(i);
                return this;
            }
            this.f1534a.setBackgroundDrawable((Drawable) null);
        }
        return this;
    }

    private TextView m() {
        return (TextView) this.f1534a;
    }

    private T m(int i) {
        if (this.f1534a != null) {
            this.f1534a.setBackgroundColor(i);
        }
        return this;
    }

    private EditText n() {
        return (EditText) this.f1534a;
    }

    private T n(int i) {
        if (this.f1534a != null) {
            this.f1534a.setBackgroundColor(G().getResources().getColor(i));
        }
        return this;
    }

    private ProgressBar o() {
        return (ProgressBar) this.f1534a;
    }

    private Object o(int i) {
        if (this.f1534a != null) {
            return this.f1534a.getTag(i);
        }
        return null;
    }

    private SeekBar p() {
        return (SeekBar) this.f1534a;
    }

    private T p(int i) {
        if (this.f1534a instanceof AdapterView) {
            ((AdapterView) this.f1534a).setSelection(i);
        }
        return this;
    }

    private Button q() {
        return (Button) this.f1534a;
    }

    private T q(int i) {
        if (this.f1534a instanceof AbsListView) {
            com.c.d.a.a((Object) this.f1534a, "setOverScrollMode", false, false, ad, Integer.valueOf(i));
        }
        return this;
    }

    private CheckBox r() {
        return (CheckBox) this.f1534a;
    }

    private T r(int i) {
        a(true, i, true);
        return this;
    }

    private ListView s() {
        return (ListView) this.f1534a;
    }

    private T s(int i) {
        a(false, i, true);
        return this;
    }

    private Bitmap t(int i) {
        return com.c.b.d.a(G(), i);
    }

    private ExpandableListView t() {
        return (ExpandableListView) this.f1534a;
    }

    private GridView u() {
        return (GridView) this.f1534a;
    }

    private T u(int i) {
        Animation loadAnimation = AnimationUtils.loadAnimation(G(), i);
        loadAnimation.setAnimationListener((Animation.AnimationListener) null);
        if (!(this.f1534a == null || loadAnimation == null)) {
            this.f1534a.startAnimation(loadAnimation);
        }
        return this;
    }

    private RatingBar v() {
        return (RatingBar) this.f1534a;
    }

    private T v(int i) {
        Animation loadAnimation = AnimationUtils.loadAnimation(G(), i);
        loadAnimation.setAnimationListener((Animation.AnimationListener) null);
        if (!(this.f1534a == null || loadAnimation == null)) {
            this.f1534a.startAnimation(loadAnimation);
        }
        return this;
    }

    private WebView w() {
        return (WebView) this.f1534a;
    }

    private Spinner x() {
        return (Spinner) this.f1534a;
    }

    private Editable y() {
        if (this.f1534a instanceof EditText) {
            return ((EditText) this.f1534a).getEditableText();
        }
        return null;
    }

    private CharSequence z() {
        if (this.f1534a instanceof TextView) {
            return ((TextView) this.f1534a).getText();
        }
        return null;
    }

    public final T a(int i) {
        this.f1535b = b(i);
        return this;
    }

    public final T a(Dialog dialog) {
        if (dialog != null) {
            try {
                dialog.show();
                af.put(dialog, (Object) null);
            } catch (Exception unused) {
            }
        }
        return this;
    }

    public final T a(a aVar) {
        this.f1536c = aVar;
        return this;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.c.b.a, com.c.b.b<K>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K> T a(com.c.b.b<K> r1) {
        /*
            r0 = this;
            com.c.b r1 = r0.a(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.a(com.c.b.b):com.c.b");
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.c.b.a, com.c.b.b<K>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K> T a(java.lang.String r3, java.lang.Class<K> r4, com.c.b.b<K> r5) {
        /*
            r2 = this;
            r5.f1538b = r4
            r4 = r5
            com.c.b.b r4 = (com.c.b.b) r4
            r4.f1539c = r3
            com.c.b.b r4 = (com.c.b.b) r4
            r3 = 1
            java.lang.Object r3 = r4.a((boolean) r3)
            com.c.b.b r3 = (com.c.b.b) r3
            r0 = 0
            r3.p = r0
            com.c.b r3 = r2.a(r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.a(java.lang.String, java.lang.Class, com.c.b.b):com.c.b");
    }

    public final T b(Dialog dialog) {
        if (dialog != null) {
            try {
                af.remove(dialog);
                dialog.dismiss();
            } catch (Exception unused) {
            }
        }
        return this;
    }
}
