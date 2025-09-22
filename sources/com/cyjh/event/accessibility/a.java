package com.cyjh.event.accessibility;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T> {

    /* renamed from: c  reason: collision with root package name */
    public static Rect f2362c = new Rect();
    public static final String d = "android.view.View";
    public static final String e = "android.widget.TextView";
    public static final String f = "android.widget.ImageView";
    public static final String g = "android.widget.Button";
    public static final String h = "android.widget.ImageButton";
    public static final String i = "android.widget.EditText";
    public static final String j = "android.widget.ListView";
    public static final String k = "android.widget.LinearLayout";
    public static final String l = "android.view.ViewGroup";
    public static final String m = "com.android.systemui";

    /* renamed from: a  reason: collision with root package name */
    protected final boolean f2363a;

    /* renamed from: b  reason: collision with root package name */
    protected final T f2364b;

    /* renamed from: com.cyjh.event.accessibility.a$a  reason: collision with other inner class name */
    private static class C0033a extends a<String> {
        public C0033a(@NonNull String str, boolean z) {
            super(str, z, (byte) 0);
        }

        @RequiresApi(api = 14)
        public final boolean a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return this.f2363a ? accessibilityNodeInfo.getClassName().toString().equals(this.f2364b) : accessibilityNodeInfo.getClassName().toString().contains((CharSequence) this.f2364b);
        }
    }

    private static class b extends a<String> {
        private b(@NonNull String str, boolean z) {
            super(str, z, (byte) 0);
        }

        /* synthetic */ b(String str, boolean z, byte b2) {
            this(str, z);
        }

        @RequiresApi(api = 14)
        public final boolean a(AccessibilityNodeInfo accessibilityNodeInfo) {
            CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
            return this.f2363a ? contentDescription != null && contentDescription.toString().equals(this.f2364b) : contentDescription != null && contentDescription.toString().contains((CharSequence) this.f2364b);
        }
    }

    private static class c extends a<String> implements d {
        private c(@NonNull String str) {
            super(str, true, (byte) 0);
        }

        /* synthetic */ c(String str, byte b2) {
            this(str);
        }

        public final boolean a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return true;
        }

        @Nullable
        @RequiresApi(api = 18)
        public final AccessibilityNodeInfo b(AccessibilityNodeInfo accessibilityNodeInfo) {
            List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId((String) this.f2364b);
            if (findAccessibilityNodeInfosByViewId == null || findAccessibilityNodeInfosByViewId.size() == 0) {
                return null;
            }
            for (int i = 1; i < findAccessibilityNodeInfosByViewId.size(); i++) {
                findAccessibilityNodeInfosByViewId.get(i).recycle();
            }
            return findAccessibilityNodeInfosByViewId.get(0);
        }

        @Nullable
        @RequiresApi(api = 18)
        public final List<AccessibilityNodeInfo> c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.findAccessibilityNodeInfosByViewId((String) this.f2364b);
        }
    }

    public interface d {
        @Nullable
        AccessibilityNodeInfo b(AccessibilityNodeInfo accessibilityNodeInfo);

        @Nullable
        List<AccessibilityNodeInfo> c(AccessibilityNodeInfo accessibilityNodeInfo);
    }

    private static class e extends a<Rect> {
        public e(@NonNull Rect rect) {
            super(rect, true, (byte) 0);
        }

        @RequiresApi(api = 14)
        public final boolean a(AccessibilityNodeInfo accessibilityNodeInfo) {
            accessibilityNodeInfo.getBoundsInScreen(f2362c);
            return ((Rect) this.f2364b).contains(f2362c);
        }
    }

    private static class f extends a<String> implements d {
        private f(@NonNull String str, boolean z) {
            super(str, z, (byte) 0);
        }

        /* synthetic */ f(String str, boolean z, byte b2) {
            this(str, z);
        }

        public final boolean a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return true;
        }

        @Nullable
        @RequiresApi(api = 14)
        public final AccessibilityNodeInfo b(AccessibilityNodeInfo accessibilityNodeInfo) {
            List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = accessibilityNodeInfo.findAccessibilityNodeInfosByText((String) this.f2364b);
            AccessibilityNodeInfo accessibilityNodeInfo2 = null;
            if (findAccessibilityNodeInfosByText == null || findAccessibilityNodeInfosByText.size() == 0) {
                return null;
            }
            if (!this.f2363a) {
                return findAccessibilityNodeInfosByText.get(0);
            }
            for (AccessibilityNodeInfo next : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo2 != null || next.getText() == null || !((String) this.f2364b).equals(next.getText().toString())) {
                    next.recycle();
                } else {
                    accessibilityNodeInfo2 = next;
                }
            }
            return accessibilityNodeInfo2;
        }

        @Nullable
        @RequiresApi(api = 14)
        public final List<AccessibilityNodeInfo> c(AccessibilityNodeInfo accessibilityNodeInfo) {
            List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = accessibilityNodeInfo.findAccessibilityNodeInfosByText((String) this.f2364b);
            if (findAccessibilityNodeInfosByText == null || findAccessibilityNodeInfosByText.size() == 0) {
                return null;
            }
            if (!this.f2363a) {
                return findAccessibilityNodeInfosByText;
            }
            ArrayList arrayList = new ArrayList();
            for (AccessibilityNodeInfo next : findAccessibilityNodeInfosByText) {
                if (next.getText() == null || !((String) this.f2364b).equals(next.getText().toString())) {
                    next.recycle();
                } else {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }
    }

    private static class g extends a<String> {
        private g(@NonNull String str, boolean z) {
            super(str, z, (byte) 0);
        }

        /* synthetic */ g(String str, boolean z, byte b2) {
            this(str, z);
        }

        @RequiresApi(api = 14)
        public final boolean a(AccessibilityNodeInfo accessibilityNodeInfo) {
            CharSequence text = accessibilityNodeInfo.getText();
            return this.f2363a ? text != null && text.toString().equals(this.f2364b) : text != null && text.toString().contains((CharSequence) this.f2364b);
        }
    }

    private a(@NonNull T t, boolean z) {
        this.f2364b = t;
        this.f2363a = z;
    }

    /* synthetic */ a(Object obj, boolean z, byte b2) {
        this(obj, z);
    }

    private static a a(@NonNull Rect rect) {
        return new e(rect);
    }

    private static a a(@NonNull String str) {
        return new c(str, (byte) 0);
    }

    private static a a(String str, String str2) {
        return new c(str + ":id/" + str2, (byte) 0);
    }

    private static a a(@NonNull String str, boolean z) {
        return new f(str, z, (byte) 0);
    }

    private static a b(@NonNull String str) {
        return new C0033a(str, true);
    }

    private static a b(@NonNull String str, boolean z) {
        return new g(str, z, (byte) 0);
    }

    private static a c(@NonNull String str, boolean z) {
        return new b(str, z, (byte) 0);
    }

    private static a d(@NonNull String str, boolean z) {
        return new C0033a(str, z);
    }

    public abstract boolean a(AccessibilityNodeInfo accessibilityNodeInfo);
}
