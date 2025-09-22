package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.android.volley.l;
import com.android.volley.m;
import com.android.volley.n;
import com.android.volley.s;
import com.android.volley.toolbox.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class k {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, a> f540a = new HashMap<>();
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, a> f541b = new HashMap<>();
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public Runnable f542c;
    private final m d;
    private int e = 100;
    private final b f;
    private final Handler g = new Handler(Looper.getMainLooper());

    private class a {
        /* access modifiers changed from: package-private */

        /* renamed from: a  reason: collision with root package name */
        public Bitmap f551a;

        /* renamed from: b  reason: collision with root package name */
        s f552b;
        /* access modifiers changed from: package-private */

        /* renamed from: c  reason: collision with root package name */
        public final LinkedList<c> f553c = new LinkedList<>();
        private final l<?> e;

        public a(l<?> lVar, c cVar) {
            this.e = lVar;
            this.f553c.add(cVar);
        }

        private s a() {
            return this.f552b;
        }

        private void a(s sVar) {
            this.f552b = sVar;
        }

        private void b(c cVar) {
            this.f553c.add(cVar);
        }

        public final boolean a(c cVar) {
            this.f553c.remove(cVar);
            if (this.f553c.size() != 0) {
                return false;
            }
            this.e.h = true;
            return true;
        }
    }

    public interface b {
        Bitmap a();

        void b();
    }

    public class c {
        /* access modifiers changed from: package-private */

        /* renamed from: a  reason: collision with root package name */
        public Bitmap f554a;
        /* access modifiers changed from: package-private */

        /* renamed from: b  reason: collision with root package name */
        public final d f555b;

        /* renamed from: c  reason: collision with root package name */
        final String f556c;
        private final String e;

        public c(Bitmap bitmap, String str, String str2, d dVar) {
            this.f554a = bitmap;
            this.f556c = str;
            this.e = str2;
            this.f555b = dVar;
        }

        private Bitmap b() {
            return this.f554a;
        }

        private String c() {
            return this.f556c;
        }

        public final void a() {
            if (this.f555b != null) {
                a aVar = k.this.f540a.get(this.e);
                if (aVar == null) {
                    a aVar2 = k.this.f541b.get(this.e);
                    if (aVar2 != null) {
                        aVar2.a(this);
                        if (aVar2.f553c.size() == 0) {
                            k.this.f541b.remove(this.e);
                        }
                    }
                } else if (aVar.a(this)) {
                    k.this.f540a.remove(this.e);
                }
            }
        }
    }

    public interface d extends n.a {
        void a(c cVar, boolean z);
    }

    private k(m mVar, b bVar) {
        this.d = mVar;
        this.f = bVar;
    }

    private l<Bitmap> a(String str, int i, int i2, ImageView.ScaleType scaleType, String str2, l.a aVar) {
        final String str3 = str2;
        return new l(str, new n.b<Bitmap>() {
            private void a(Bitmap bitmap) {
                k kVar = k.this;
                String str = r15;
                a remove = kVar.f540a.remove(str);
                if (remove != null) {
                    remove.f551a = bitmap;
                    kVar.a(str, remove);
                }
            }

            public final /* synthetic */ void a(Object obj) {
                Bitmap bitmap = (Bitmap) obj;
                k kVar = k.this;
                String str = r15;
                a remove = kVar.f540a.remove(str);
                if (remove != null) {
                    remove.f551a = bitmap;
                    kVar.a(str, remove);
                }
            }
        }, i, i2, scaleType, Bitmap.Config.RGB_565, aVar, new n.a() {
            public final void a(s sVar) {
                k kVar = k.this;
                String str = r15;
                a remove = kVar.f540a.remove(str);
                if (remove != null) {
                    remove.f552b = sVar;
                    kVar.a(str, remove);
                }
            }
        });
    }

    private c a(String str, d dVar) {
        return a(str, dVar, 0, 0, ImageView.ScaleType.CENTER_INSIDE, (l.a) null);
    }

    private c a(String str, d dVar, int i, int i2) {
        return a(str, dVar, i, i2, ImageView.ScaleType.CENTER_INSIDE, (l.a) null);
    }

    private c a(String str, d dVar, ImageView.ScaleType scaleType) {
        return a(str, dVar, 0, 0, scaleType, (l.a) null);
    }

    private static d a(final ImageView imageView, final int i, final int i2) {
        return new d() {
            public final void a(s sVar) {
                if (i2 != 0) {
                    imageView.setImageResource(i2);
                }
            }

            public final void a(c cVar, boolean z) {
                if (cVar.f554a != null) {
                    imageView.setImageBitmap(cVar.f554a);
                } else if (i != 0) {
                    imageView.setImageResource(i);
                }
            }
        };
    }

    private static String a(String str, int i, int i2, ImageView.ScaleType scaleType, l.a aVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("#W");
        sb.append(i);
        sb.append("#H");
        sb.append(i2);
        sb.append("#S");
        sb.append(scaleType.toString());
        if (aVar != null) {
            sb.append("#T");
            sb.append(aVar.b());
        }
        return sb.toString();
    }

    private static void a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
        }
    }

    private void a(int i) {
        this.e = i;
    }

    private void a(String str, Bitmap bitmap) {
        a remove = this.f540a.remove(str);
        if (remove != null) {
            remove.f551a = bitmap;
            a(str, remove);
        }
    }

    private void a(String str, s sVar) {
        a remove = this.f540a.remove(str);
        if (remove != null) {
            remove.f552b = sVar;
            a(str, remove);
        }
    }

    private boolean a(String str, int i, int i2) {
        return b(str, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    private boolean a(String str, int i, int i2, ImageView.ScaleType scaleType) {
        return b(str, i, i2, scaleType);
    }

    private boolean b(String str, int i, int i2, ImageView.ScaleType scaleType) {
        a();
        a(str, i, i2, scaleType, (l.a) null);
        return this.f.a() != null;
    }

    public final c a(String str, d dVar, int i, int i2, ImageView.ScaleType scaleType, l.a aVar) {
        d dVar2 = dVar;
        a();
        String str2 = str;
        int i3 = i;
        int i4 = i2;
        ImageView.ScaleType scaleType2 = scaleType;
        l.a aVar2 = aVar;
        final String a2 = a(str2, i3, i4, scaleType2, aVar2);
        Bitmap a3 = this.f.a();
        if (a3 != null) {
            c cVar = new c(a3, str2, (String) null, (d) null);
            dVar2.a(cVar, true);
            return cVar;
        }
        c cVar2 = new c((Bitmap) null, str2, a2, dVar2);
        dVar2.a(cVar2, true);
        a aVar3 = this.f540a.get(a2);
        if (aVar3 != null) {
            aVar3.f553c.add(cVar2);
            return cVar2;
        }
        AnonymousClass2 r9 = new n.b<Bitmap>() {
            private void a(Bitmap bitmap) {
                k kVar = k.this;
                String str = a2;
                a remove = kVar.f540a.remove(str);
                if (remove != null) {
                    remove.f551a = bitmap;
                    kVar.a(str, remove);
                }
            }

            public final /* synthetic */ void a(Object obj) {
                Bitmap bitmap = (Bitmap) obj;
                k kVar = k.this;
                String str = a2;
                a remove = kVar.f540a.remove(str);
                if (remove != null) {
                    remove.f551a = bitmap;
                    kVar.a(str, remove);
                }
            }
        };
        c cVar3 = cVar2;
        Bitmap.Config config = Bitmap.Config.RGB_565;
        l lVar = new l(str2, r9, i3, i4, scaleType2, config, aVar2, new n.a() {
            public final void a(s sVar) {
                k kVar = k.this;
                String str = a2;
                a remove = kVar.f540a.remove(str);
                if (remove != null) {
                    remove.f552b = sVar;
                    kVar.a(str, remove);
                }
            }
        });
        this.d.a(lVar);
        this.f540a.put(a2, new a(lVar, cVar3));
        return cVar3;
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, a aVar) {
        this.f541b.put(str, aVar);
        if (this.f542c == null) {
            this.f542c = new Runnable() {
                public final void run() {
                    for (a next : k.this.f541b.values()) {
                        Iterator it = next.f553c.iterator();
                        while (it.hasNext()) {
                            c cVar = (c) it.next();
                            if (cVar.f555b != null) {
                                if (next.f552b == null) {
                                    cVar.f554a = next.f551a;
                                    cVar.f555b.a(cVar, false);
                                } else {
                                    cVar.f555b.a(next.f552b);
                                }
                            }
                        }
                    }
                    k.this.f541b.clear();
                    k.this.f542c = null;
                }
            };
            this.g.postDelayed(this.f542c, (long) this.e);
        }
    }
}
