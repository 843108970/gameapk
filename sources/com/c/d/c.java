package com.c.d;

import android.app.Activity;
import android.app.Dialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Gallery;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.c.a;
import com.c.b.d;
import java.io.File;
import java.util.Comparator;

public final class c implements TextWatcher, View.OnClickListener, View.OnLongClickListener, AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener, Runnable, Comparator<File> {

    /* renamed from: a  reason: collision with root package name */
    protected static final int f1568a = 1;

    /* renamed from: b  reason: collision with root package name */
    protected static final int f1569b = 2;

    /* renamed from: c  reason: collision with root package name */
    public AbsListView.OnScrollListener f1570c;
    private Object d;
    private String e;
    private Object[] f;
    private boolean g;
    private Class<?>[] h;
    private int i;
    private int j = 0;
    private int k;
    private AdapterView.OnItemSelectedListener l;
    private boolean m = false;

    private int a() {
        return this.j;
    }

    private static int a(File file, File file2) {
        long lastModified = file.lastModified();
        long lastModified2 = file2.lastModified();
        if (lastModified2 > lastModified) {
            return 1;
        }
        return lastModified2 == lastModified ? 0 : -1;
    }

    private Object a(Object... objArr) {
        if (this.e != null) {
            if (this.f != null) {
                objArr = this.f;
            }
            Object[] objArr2 = objArr;
            Object obj = this.d;
            return a.a(obj == null ? this : obj, this.e, this.g, true, this.h, objArr2);
        } else if (this.i == 0) {
            return null;
        } else {
            switch (this.i) {
                case 1:
                    a.b((File) this.f[0], (byte[]) this.f[1]);
                    return null;
                case 2:
                    a.a((File) this.f[0], ((Long) this.f[1]).longValue(), ((Long) this.f[2]).longValue());
                    return null;
                default:
                    return null;
            }
        }
    }

    private void a(AbsListView.OnScrollListener onScrollListener) {
        this.f1570c = onScrollListener;
    }

    private void a(AbsListView absListView, int i2) {
        int count = absListView.getCount();
        int lastVisiblePosition = absListView.getLastVisiblePosition();
        if (i2 != 0 || count != lastVisiblePosition + 1) {
            this.k = -1;
        } else if (lastVisiblePosition != this.k) {
            this.k = lastVisiblePosition;
            a(absListView, Integer.valueOf(i2));
        }
    }

    private static void a(ExpandableListView expandableListView, int i2) {
        expandableListView.setTag(d.B, Integer.valueOf(i2));
        if (i2 == 0) {
            int firstVisiblePosition = expandableListView.getFirstVisiblePosition();
            int lastVisiblePosition = expandableListView.getLastVisiblePosition() - firstVisiblePosition;
            ExpandableListAdapter expandableListAdapter = expandableListView.getExpandableListAdapter();
            for (int i3 = 0; i3 <= lastVisiblePosition; i3++) {
                long expandableListPosition = expandableListView.getExpandableListPosition(i3 + firstVisiblePosition);
                int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListPosition);
                int packedPositionChild = ExpandableListView.getPackedPositionChild(expandableListPosition);
                if (packedPositionGroup >= 0) {
                    View childAt = expandableListView.getChildAt(i3);
                    Long l2 = (Long) childAt.getTag(d.B);
                    if (l2 != null && l2.longValue() == expandableListPosition) {
                        if (packedPositionChild == -1) {
                            expandableListAdapter.getGroupView(packedPositionGroup, expandableListView.isGroupExpanded(packedPositionGroup), childAt, expandableListView);
                        } else {
                            expandableListAdapter.getChildView(packedPositionGroup, packedPositionChild, packedPositionChild == expandableListAdapter.getChildrenCount(packedPositionGroup) - 1, childAt, expandableListView);
                        }
                        childAt.setTag(d.B, (Object) null);
                    }
                }
            }
        }
    }

    private void a(Gallery gallery) {
        this.l = gallery.getOnItemSelectedListener();
        this.m = true;
        gallery.setOnItemSelectedListener(this);
    }

    public static void a(Object obj, String str, boolean z) {
        if (obj == null) {
            return;
        }
        if (obj instanceof View) {
            View view = (View) obj;
            ProgressBar progressBar = obj instanceof ProgressBar ? (ProgressBar) obj : null;
            if (z) {
                view.setTag(d.y, str);
                view.setVisibility(0);
                if (progressBar != null) {
                    progressBar.setProgress(0);
                    progressBar.setMax(100);
                    return;
                }
                return;
            }
            Object tag = view.getTag(d.y);
            if (tag == null || tag.equals(str)) {
                view.setTag(d.y, (Object) null);
                if (progressBar == null || progressBar.isIndeterminate()) {
                    view.setVisibility(8);
                }
            }
        } else if (obj instanceof Dialog) {
            Dialog dialog = (Dialog) obj;
            a aVar = new a(dialog.getContext());
            if (z) {
                aVar.a(dialog);
            } else {
                aVar.b(dialog);
            }
        } else if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            activity.setProgressBarIndeterminateVisibility(z);
            activity.setProgressBarVisibility(z);
            if (z) {
                activity.setProgress(0);
            }
        }
    }

    public static boolean a(int i2, int i3, View view, ViewGroup viewGroup, String str) {
        if (str == null || d.d(str)) {
            return false;
        }
        AbsListView absListView = (AbsListView) viewGroup;
        if (((AbsListView.OnScrollListener) viewGroup.getTag(d.z)) == null) {
            c cVar = new c();
            absListView.setOnScrollListener(cVar);
            viewGroup.setTag(d.z, cVar);
        }
        Integer num = (Integer) absListView.getTag(d.B);
        if (num == null || num.intValue() == 0 || num.intValue() == 1) {
            return false;
        }
        long j2 = (long) i3;
        if (viewGroup instanceof ExpandableListView) {
            j2 = ExpandableListView.getPackedPositionForChild(i2, i3);
        }
        view.setTag(d.B, Long.valueOf(j2));
        return true;
    }

    public static boolean a(int i2, View view, ViewGroup viewGroup, String str) {
        if (!(viewGroup instanceof Gallery)) {
            return a(-2, i2, view, viewGroup, str);
        }
        if (str == null || d.d(str)) {
            return false;
        }
        Gallery gallery = (Gallery) viewGroup;
        Integer num = (Integer) gallery.getTag(d.B);
        if (num == null) {
            num = 0;
            gallery.setTag(d.B, 0);
            gallery.setCallbackDuringFling(false);
            c cVar = new c();
            cVar.l = gallery.getOnItemSelectedListener();
            cVar.m = true;
            gallery.setOnItemSelectedListener(cVar);
        }
        int lastVisiblePosition = ((gallery.getLastVisiblePosition() - gallery.getFirstVisiblePosition()) / 2) + 1;
        int intValue = num.intValue() - lastVisiblePosition;
        int intValue2 = num.intValue() + lastVisiblePosition;
        if (intValue < 0) {
            intValue2 -= intValue;
            intValue = 0;
        }
        if (i2 < intValue || i2 > intValue2) {
            view.setTag(d.B, (Object) null);
            return true;
        }
        view.setTag(d.B, Integer.valueOf(i2));
        return false;
    }

    public static boolean a(View view, ViewGroup viewGroup, String str) {
        return a(-1, view, viewGroup, str);
    }

    private static void b(AbsListView absListView, int i2) {
        absListView.setTag(d.B, Integer.valueOf(i2));
        if (i2 == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            int lastVisiblePosition = absListView.getLastVisiblePosition() - firstVisiblePosition;
            ListAdapter listAdapter = (ListAdapter) absListView.getAdapter();
            for (int i3 = 0; i3 <= lastVisiblePosition; i3++) {
                long j2 = (long) (i3 + firstVisiblePosition);
                View childAt = absListView.getChildAt(i3);
                if (((Number) childAt.getTag(d.B)) != null) {
                    listAdapter.getView((int) j2, childAt, absListView);
                    childAt.setTag(d.B, (Object) null);
                }
            }
        }
    }

    private static boolean b(int i2, View view, ViewGroup viewGroup, String str) {
        if (str == null || d.d(str)) {
            return false;
        }
        Gallery gallery = (Gallery) viewGroup;
        Integer num = (Integer) gallery.getTag(d.B);
        if (num == null) {
            num = 0;
            gallery.setTag(d.B, 0);
            gallery.setCallbackDuringFling(false);
            c cVar = new c();
            cVar.l = gallery.getOnItemSelectedListener();
            cVar.m = true;
            gallery.setOnItemSelectedListener(cVar);
        }
        int lastVisiblePosition = ((gallery.getLastVisiblePosition() - gallery.getFirstVisiblePosition()) / 2) + 1;
        int intValue = num.intValue() - lastVisiblePosition;
        int intValue2 = num.intValue() + lastVisiblePosition;
        if (intValue < 0) {
            intValue2 -= intValue;
            intValue = 0;
        }
        if (i2 < intValue || i2 > intValue2) {
            view.setTag(d.B, (Object) null);
            return true;
        }
        view.setTag(d.B, Integer.valueOf(i2));
        return false;
    }

    public final c a(int i2, Object... objArr) {
        this.i = i2;
        this.f = objArr;
        return this;
    }

    public final c a(Object obj, String str, Class<?>[] clsArr) {
        this.d = obj;
        this.e = str;
        this.g = true;
        this.h = clsArr;
        return this;
    }

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        long lastModified = ((File) obj).lastModified();
        long lastModified2 = ((File) obj2).lastModified();
        if (lastModified2 > lastModified) {
            return 1;
        }
        return lastModified2 == lastModified ? 0 : -1;
    }

    public final void onClick(View view) {
        a(view);
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        a(adapterView, view, Integer.valueOf(i2), Long.valueOf(j2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: android.widget.Adapter} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onItemSelected(android.widget.AdapterView<?> r9, android.view.View r10, int r11, long r12) {
        /*
            r8 = this;
            r0 = 4
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            r0[r1] = r9
            r2 = 1
            r0[r2] = r10
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)
            r3 = 2
            r0[r3] = r2
            java.lang.Long r2 = java.lang.Long.valueOf(r12)
            r3 = 3
            r0[r3] = r2
            r8.a((java.lang.Object[]) r0)
            android.widget.AdapterView$OnItemSelectedListener r0 = r8.l
            if (r0 == 0) goto L_0x0027
            android.widget.AdapterView$OnItemSelectedListener r2 = r8.l
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r2.onItemSelected(r3, r4, r5, r6)
        L_0x0027:
            boolean r10 = r8.m
            if (r10 == 0) goto L_0x006a
            r10 = 1090453508(0x40ff0004, float:7.968752)
            java.lang.Object r12 = r9.getTag(r10)
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            if (r12 == r11) goto L_0x006a
            android.widget.Adapter r12 = r9.getAdapter()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r9.setTag(r10, r11)
            int r11 = r9.getChildCount()
            int r13 = r9.getFirstVisiblePosition()
        L_0x004d:
            if (r1 < r11) goto L_0x0050
            return
        L_0x0050:
            android.view.View r0 = r9.getChildAt(r1)
            int r2 = r13 + r1
            java.lang.Object r3 = r0.getTag(r10)
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L_0x0064
            int r3 = r3.intValue()
            if (r3 == r2) goto L_0x0067
        L_0x0064:
            r12.getView(r2, r0, r9)
        L_0x0067:
            int r1 = r1 + 1
            goto L_0x004d
        L_0x006a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.d.c.onItemSelected(android.widget.AdapterView, android.view.View, int, long):void");
    }

    public final boolean onLongClick(View view) {
        Object a2 = a(view);
        if (a2 instanceof Boolean) {
            return ((Boolean) a2).booleanValue();
        }
        return false;
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
        if (this.l != null) {
            this.l.onNothingSelected(adapterView);
        }
    }

    public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        a(absListView, this.j);
        if (this.f1570c != null) {
            this.f1570c.onScroll(absListView, i2, i3, i4);
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i2) {
        int i3;
        View view;
        AbsListView absListView2 = absListView;
        int i4 = i2;
        this.j = i4;
        a(absListView, i2);
        if (absListView2 instanceof ExpandableListView) {
            ExpandableListView expandableListView = (ExpandableListView) absListView2;
            expandableListView.setTag(d.B, Integer.valueOf(i2));
            if (i4 == 0) {
                int firstVisiblePosition = expandableListView.getFirstVisiblePosition();
                int lastVisiblePosition = expandableListView.getLastVisiblePosition() - firstVisiblePosition;
                ExpandableListAdapter expandableListAdapter = expandableListView.getExpandableListAdapter();
                int i5 = 0;
                while (i5 <= lastVisiblePosition) {
                    long expandableListPosition = expandableListView.getExpandableListPosition(i5 + firstVisiblePosition);
                    int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListPosition);
                    int packedPositionChild = ExpandableListView.getPackedPositionChild(expandableListPosition);
                    if (packedPositionGroup >= 0) {
                        View childAt = expandableListView.getChildAt(i5);
                        Long l2 = (Long) childAt.getTag(d.B);
                        if (l2 != null && l2.longValue() == expandableListPosition) {
                            if (packedPositionChild == -1) {
                                expandableListAdapter.getGroupView(packedPositionGroup, expandableListView.isGroupExpanded(packedPositionGroup), childAt, expandableListView);
                                view = childAt;
                                i3 = i5;
                            } else {
                                boolean z = packedPositionChild == expandableListAdapter.getChildrenCount(packedPositionGroup) - 1;
                                int i6 = packedPositionGroup;
                                int i7 = packedPositionChild;
                                boolean z2 = z;
                                view = childAt;
                                i3 = i5;
                                expandableListAdapter.getChildView(i6, i7, z2, childAt, expandableListView);
                            }
                            view.setTag(d.B, (Object) null);
                            i5 = i3 + 1;
                        }
                    }
                    i3 = i5;
                    i5 = i3 + 1;
                }
            }
        } else {
            absListView2.setTag(d.B, Integer.valueOf(i2));
            if (i4 == 0) {
                int firstVisiblePosition2 = absListView.getFirstVisiblePosition();
                int lastVisiblePosition2 = absListView.getLastVisiblePosition() - firstVisiblePosition2;
                ListAdapter listAdapter = (ListAdapter) absListView.getAdapter();
                for (int i8 = 0; i8 <= lastVisiblePosition2; i8++) {
                    long j2 = (long) (i8 + firstVisiblePosition2);
                    View childAt2 = absListView2.getChildAt(i8);
                    if (((Number) childAt2.getTag(d.B)) != null) {
                        listAdapter.getView((int) j2, childAt2, absListView2);
                        childAt2.setTag(d.B, (Object) null);
                    }
                }
            }
        }
        if (this.f1570c != null) {
            this.f1570c.onScrollStateChanged(absListView2, i4);
        }
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        a(charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    public final void run() {
        a(new Object[0]);
    }
}
