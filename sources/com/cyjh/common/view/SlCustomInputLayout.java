package com.cyjh.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import com.cyjh.common.R;
import java.util.ArrayList;
import java.util.List;

public class SlCustomInputLayout extends LinearLayout {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public int f1829a;

    /* renamed from: b  reason: collision with root package name */
    List<String> f1830b;

    /* renamed from: c  reason: collision with root package name */
    a f1831c;
    private int d;
    /* access modifiers changed from: private */
    public Context e;
    /* access modifiers changed from: private */
    public boolean f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            private static SavedState a(Parcel parcel) {
                return new SavedState(parcel, (byte) 0);
            }

            private static SavedState[] a(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (byte) 0);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public List<String> f1834a;

        private SavedState(Parcel parcel) {
            super(parcel);
            parcel.readStringList(this.f1834a);
        }

        /* synthetic */ SavedState(Parcel parcel, byte b2) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.f1834a);
        }
    }

    public interface a {
        void a();

        void b();

        void c();
    }

    class b implements View.OnKeyListener {
        b() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ba, code lost:
            if (r5 != null) goto L_0x00cb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c9, code lost:
            if (r5 != null) goto L_0x00cb;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onKey(android.view.View r4, int r5, android.view.KeyEvent r6) {
            /*
                r3 = this;
                int r4 = r6.getAction()
                r0 = 0
                if (r4 != 0) goto L_0x00fc
                java.lang.String r4 = "key"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "keyCode="
                r1.<init>(r2)
                r1.append(r5)
                java.lang.String r1 = r1.toString()
                com.cyjh.common.util.ad.c(r4, r1)
                boolean r4 = r6.isShiftPressed()
                if (r4 == 0) goto L_0x0021
                return r0
            L_0x0021:
                r4 = 7
                r6 = 1
                if (r5 < r4) goto L_0x003c
                r1 = 16
                if (r5 > r1) goto L_0x003c
                com.cyjh.common.view.SlCustomInputLayout r0 = com.cyjh.common.view.SlCustomInputLayout.this
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                int r5 = r5 - r4
                r1.append(r5)
                java.lang.String r4 = r1.toString()
                r0.a((java.lang.String) r4)
                return r6
            L_0x003c:
                r4 = 29
                r1 = 54
                if (r5 < r4) goto L_0x0061
                if (r5 > r1) goto L_0x0061
                java.lang.String r4 = "key"
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = " 小写字母 keyCode="
                r0.<init>(r1)
                r0.append(r5)
                java.lang.String r0 = r0.toString()
                com.cyjh.common.util.ad.c(r4, r0)
                com.cyjh.common.view.SlCustomInputLayout r4 = com.cyjh.common.view.SlCustomInputLayout.this
                java.lang.String r5 = java.lang.String.valueOf(r5)
                r4.a((java.lang.String) r5)
                return r6
            L_0x0061:
                r4 = 159(0x9f, float:2.23E-43)
                if (r5 < r4) goto L_0x0084
                if (r5 > r1) goto L_0x0084
                java.lang.String r4 = "key"
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = " 小写字母 keyCode="
                r0.<init>(r1)
                r0.append(r5)
                java.lang.String r0 = r0.toString()
                com.cyjh.common.util.ad.c(r4, r0)
                com.cyjh.common.view.SlCustomInputLayout r4 = com.cyjh.common.view.SlCustomInputLayout.this
                java.lang.String r5 = java.lang.String.valueOf(r5)
                r4.a((java.lang.String) r5)
                return r6
            L_0x0084:
                r4 = 67
                if (r5 != r4) goto L_0x00e3
                com.cyjh.common.view.SlCustomInputLayout r4 = com.cyjh.common.view.SlCustomInputLayout.this
                java.util.List<java.lang.String> r5 = r4.f1830b
                if (r5 == 0) goto L_0x00d3
                java.util.List<java.lang.String> r5 = r4.f1830b
                int r5 = r5.size()
                if (r5 <= 0) goto L_0x00d3
                java.util.List<java.lang.String> r5 = r4.f1830b
                java.util.List<java.lang.String> r1 = r4.f1830b
                int r1 = r1.size()
                int r1 = r1 - r6
                r5.remove(r1)
                int r5 = r4.f1829a
                if (r5 <= 0) goto L_0x00bd
                int r5 = r4.f1829a
                java.lang.String r1 = ""
                r4.a(r5, r0, r1)
                int r5 = r4.f1829a
                int r5 = r5 - r6
                r4.f1829a = r5
                int r5 = r4.f1829a
                android.view.View r5 = r4.getChildAt(r5)
                com.cyjh.common.view.PassWordView r5 = (com.cyjh.common.view.PassWordView) r5
                if (r5 == 0) goto L_0x00d3
                goto L_0x00cb
            L_0x00bd:
                int r5 = r4.f1829a
                if (r5 != 0) goto L_0x00d3
                int r5 = r4.f1829a
                android.view.View r5 = r4.getChildAt(r5)
                com.cyjh.common.view.PassWordView r5 = (com.cyjh.common.view.PassWordView) r5
                if (r5 == 0) goto L_0x00d3
            L_0x00cb:
                java.lang.String r0 = ""
                r5.setmPassText(r0)
                r5.a()
            L_0x00d3:
                com.cyjh.common.view.SlCustomInputLayout$a r5 = r4.f1831c
                if (r5 == 0) goto L_0x00e2
                java.util.List<java.lang.String> r5 = r4.f1830b
                int r5 = r5.size()
                if (r5 <= 0) goto L_0x00e2
                r4.getPassString()
            L_0x00e2:
                return r6
            L_0x00e3:
                com.cyjh.common.view.SlCustomInputLayout r4 = com.cyjh.common.view.SlCustomInputLayout.this
                android.content.Context r4 = r4.e
                java.lang.String r5 = "input_method"
                java.lang.Object r4 = r4.getSystemService(r5)
                android.view.inputmethod.InputMethodManager r4 = (android.view.inputmethod.InputMethodManager) r4
                com.cyjh.common.view.SlCustomInputLayout r5 = com.cyjh.common.view.SlCustomInputLayout.this
                android.os.IBinder r5 = r5.getWindowToken()
                r0 = 2
                r4.hideSoftInputFromWindow(r5, r0)
                return r6
            L_0x00fc:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cyjh.common.view.SlCustomInputLayout.b.onKey(android.view.View, int, android.view.KeyEvent):boolean");
        }
    }

    private class c extends BaseInputConnection {
        public c(View view) {
            super(view, false);
        }

        public final boolean commitText(CharSequence charSequence, int i) {
            return super.commitText(charSequence, i);
        }

        public final boolean deleteSurroundingText(int i, int i2) {
            return (i == 1 && i2 == 0) ? sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67)) : super.deleteSurroundingText(i, i2);
        }

        public final boolean sendKeyEvent(KeyEvent keyEvent) {
            return super.sendKeyEvent(keyEvent);
        }
    }

    public SlCustomInputLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SlCustomInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlCustomInputLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.d = 6;
        this.f1829a = 0;
        this.e = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PassWordLayoutStyle);
        this.g = obtainStyledAttributes.getResourceId(R.styleable.PassWordLayoutStyle_box_input_color, R.color.pass_view_rect_input);
        this.h = obtainStyledAttributes.getResourceId(R.styleable.PassWordLayoutStyle_box_no_input_color, R.color.regi_line_color);
        this.i = obtainStyledAttributes.getResourceId(R.styleable.PassWordLayoutStyle_input_line_color, R.color.pass_view_rect_input);
        this.j = obtainStyledAttributes.getResourceId(R.styleable.PassWordLayoutStyle_text_input_color, R.color.pass_view_rect_input);
        this.k = obtainStyledAttributes.getInt(R.styleable.PassWordLayoutStyle_box_draw_type, 0);
        this.l = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.PassWordLayoutStyle_interval_width, 4);
        this.d = obtainStyledAttributes.getInt(R.styleable.PassWordLayoutStyle_pass_leng, 6);
        this.m = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.PassWordLayoutStyle_item_width, 40);
        this.n = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.PassWordLayoutStyle_item_height, 40);
        this.o = obtainStyledAttributes.getInt(R.styleable.PassWordLayoutStyle_pass_inputed_type, 0);
        this.p = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.PassWordLayoutStyle_draw_txt_size, 18);
        this.q = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.PassWordLayoutStyle_draw_box_line_size, 4);
        this.f = obtainStyledAttributes.getBoolean(R.styleable.PassWordLayoutStyle_is_show_input_line, true);
        obtainStyledAttributes.recycle();
        this.f1830b = new ArrayList();
        setOrientation(0);
        setGravity(17);
        setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SlCustomInputLayout.this.setFocusable(true);
                SlCustomInputLayout.this.setFocusableInTouchMode(true);
                SlCustomInputLayout.this.requestFocus();
                ((InputMethodManager) SlCustomInputLayout.this.getContext().getSystemService("input_method")).showSoftInput(SlCustomInputLayout.this, 1);
            }
        });
        setOnKeyListener(new b());
        setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    PassWordView passWordView = (PassWordView) SlCustomInputLayout.this.getChildAt(SlCustomInputLayout.this.f1829a);
                    if (passWordView != null) {
                        passWordView.setmIsShowRemindLine(SlCustomInputLayout.this.f);
                        passWordView.a();
                        return;
                    }
                    return;
                }
                PassWordView passWordView2 = (PassWordView) SlCustomInputLayout.this.getChildAt(SlCustomInputLayout.this.f1829a);
                if (passWordView2 != null) {
                    passWordView2.setmIsShowRemindLine(false);
                    passWordView2.a(false);
                }
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0042, code lost:
        if (r0 != null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0033, code lost:
        if (r0 != null) goto L_0x0044;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r3 = this;
            java.util.List<java.lang.String> r0 = r3.f1830b
            if (r0 == 0) goto L_0x004c
            java.util.List<java.lang.String> r0 = r3.f1830b
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x004c
            java.util.List<java.lang.String> r0 = r3.f1830b
            java.util.List<java.lang.String> r1 = r3.f1830b
            int r1 = r1.size()
            int r1 = r1 + -1
            r0.remove(r1)
            int r0 = r3.f1829a
            if (r0 <= 0) goto L_0x0036
            int r0 = r3.f1829a
            r1 = 0
            java.lang.String r2 = ""
            r3.a(r0, r1, r2)
            int r0 = r3.f1829a
            int r0 = r0 + -1
            r3.f1829a = r0
            int r0 = r3.f1829a
            android.view.View r0 = r3.getChildAt(r0)
            com.cyjh.common.view.PassWordView r0 = (com.cyjh.common.view.PassWordView) r0
            if (r0 == 0) goto L_0x004c
            goto L_0x0044
        L_0x0036:
            int r0 = r3.f1829a
            if (r0 != 0) goto L_0x004c
            int r0 = r3.f1829a
            android.view.View r0 = r3.getChildAt(r0)
            com.cyjh.common.view.PassWordView r0 = (com.cyjh.common.view.PassWordView) r0
            if (r0 == 0) goto L_0x004c
        L_0x0044:
            java.lang.String r1 = ""
            r0.setmPassText(r1)
            r0.a()
        L_0x004c:
            com.cyjh.common.view.SlCustomInputLayout$a r0 = r3.f1831c
            if (r0 == 0) goto L_0x005b
            java.util.List<java.lang.String> r0 = r3.f1830b
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x005b
            r3.getPassString()
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.common.view.SlCustomInputLayout.a():void");
    }

    private void a(Context context) {
        for (int i2 = 0; i2 < this.d; i2++) {
            PassWordView passWordView = new PassWordView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.m, this.n);
            if (i2 > 0) {
                layoutParams.leftMargin = this.l;
            }
            passWordView.setInputStateColor(this.g);
            passWordView.setNoinputColor(this.h);
            passWordView.setInputStateTextColor(this.j);
            passWordView.setRemindLineColor(this.i);
            passWordView.setmBoxDrawType(this.k);
            passWordView.setmShowPassType(this.o);
            passWordView.setmDrawTxtSize(this.p);
            passWordView.setmDrawBoxLineSize(this.q);
            passWordView.setmIsShowRemindLine(this.f);
            addView(passWordView, layoutParams);
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.e = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PassWordLayoutStyle);
        this.g = obtainStyledAttributes.getResourceId(R.styleable.PassWordLayoutStyle_box_input_color, R.color.pass_view_rect_input);
        this.h = obtainStyledAttributes.getResourceId(R.styleable.PassWordLayoutStyle_box_no_input_color, R.color.regi_line_color);
        this.i = obtainStyledAttributes.getResourceId(R.styleable.PassWordLayoutStyle_input_line_color, R.color.pass_view_rect_input);
        this.j = obtainStyledAttributes.getResourceId(R.styleable.PassWordLayoutStyle_text_input_color, R.color.pass_view_rect_input);
        this.k = obtainStyledAttributes.getInt(R.styleable.PassWordLayoutStyle_box_draw_type, 0);
        this.l = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.PassWordLayoutStyle_interval_width, 4);
        this.d = obtainStyledAttributes.getInt(R.styleable.PassWordLayoutStyle_pass_leng, 6);
        this.m = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.PassWordLayoutStyle_item_width, 40);
        this.n = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.PassWordLayoutStyle_item_height, 40);
        this.o = obtainStyledAttributes.getInt(R.styleable.PassWordLayoutStyle_pass_inputed_type, 0);
        this.p = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.PassWordLayoutStyle_draw_txt_size, 18);
        this.q = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.PassWordLayoutStyle_draw_box_line_size, 4);
        this.f = obtainStyledAttributes.getBoolean(R.styleable.PassWordLayoutStyle_is_show_input_line, true);
        obtainStyledAttributes.recycle();
        this.f1830b = new ArrayList();
        setOrientation(0);
        setGravity(17);
        setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SlCustomInputLayout.this.setFocusable(true);
                SlCustomInputLayout.this.setFocusableInTouchMode(true);
                SlCustomInputLayout.this.requestFocus();
                ((InputMethodManager) SlCustomInputLayout.this.getContext().getSystemService("input_method")).showSoftInput(SlCustomInputLayout.this, 1);
            }
        });
        setOnKeyListener(new b());
        setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    PassWordView passWordView = (PassWordView) SlCustomInputLayout.this.getChildAt(SlCustomInputLayout.this.f1829a);
                    if (passWordView != null) {
                        passWordView.setmIsShowRemindLine(SlCustomInputLayout.this.f);
                        passWordView.a();
                        return;
                    }
                    return;
                }
                PassWordView passWordView2 = (PassWordView) SlCustomInputLayout.this.getChildAt(SlCustomInputLayout.this.f1829a);
                if (passWordView2 != null) {
                    passWordView2.setmIsShowRemindLine(false);
                    passWordView2.a(false);
                }
            }
        });
    }

    private void b() {
        PassWordView passWordView;
        if (this.f1830b != null) {
            for (int size = this.f1830b.size(); size >= 0; size--) {
                if (size > 0) {
                    a(size, false, "");
                } else if (size == 0 && (passWordView = (PassWordView) getChildAt(size)) != null) {
                    passWordView.setmPassText("");
                    passWordView.a();
                }
            }
            this.f1830b.clear();
            this.f1829a = 0;
        }
    }

    private void c() {
        PassWordView passWordView;
        if (this.f1829a > 0) {
            a(this.f1829a, false, "");
            this.f1829a--;
            PassWordView passWordView2 = (PassWordView) getChildAt(this.f1829a);
            if (passWordView2 != null) {
                passWordView2.setmPassText("");
                passWordView2.a();
            }
        } else if (this.f1829a == 0 && (passWordView = (PassWordView) getChildAt(this.f1829a)) != null) {
            passWordView.setmPassText("");
            passWordView.a();
        }
    }

    private void setNextInput(String str) {
        if (this.f1829a < this.d) {
            a(this.f1829a, true, str);
            this.f1829a++;
            PassWordView passWordView = (PassWordView) getChildAt(this.f1829a);
            if (passWordView != null) {
                passWordView.setmPassText(str);
                passWordView.a();
            }
        }
    }

    public final void a(int i2, boolean z, String str) {
        PassWordView passWordView;
        if (i2 >= 0 && (passWordView = (PassWordView) getChildAt(i2)) != null) {
            passWordView.setmPassText(str);
            passWordView.a(z);
        }
    }

    public final void a(String str) {
        if (this.f1830b != null && this.f1830b.size() < this.d) {
            this.f1830b.add(str);
            setNextInput(str);
        }
        if (this.f1831c == null) {
            return;
        }
        if (this.f1830b.size() < this.d) {
            getPassString();
        } else {
            getPassString();
        }
    }

    public String getPassString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : this.f1830b) {
            stringBuffer.append(append);
        }
        return stringBuffer.toString();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        editorInfo.inputType = 2;
        editorInfo.imeOptions = 268435456;
        return new c(this);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (getChildCount() == 0) {
            if ((this.d * this.m) + ((this.d - 1) * this.l) > getMeasuredWidth()) {
                this.m = (getMeasuredWidth() - ((this.d - 1) * this.l)) / this.d;
                this.n = this.m;
            }
            Context context = getContext();
            for (int i4 = 0; i4 < this.d; i4++) {
                PassWordView passWordView = new PassWordView(context);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.m, this.n);
                if (i4 > 0) {
                    layoutParams.leftMargin = this.l;
                }
                passWordView.setInputStateColor(this.g);
                passWordView.setNoinputColor(this.h);
                passWordView.setInputStateTextColor(this.j);
                passWordView.setRemindLineColor(this.i);
                passWordView.setmBoxDrawType(this.k);
                passWordView.setmShowPassType(this.o);
                passWordView.setmDrawTxtSize(this.p);
                passWordView.setmDrawBoxLineSize(this.q);
                passWordView.setmIsShowRemindLine(this.f);
                addView(passWordView, layoutParams);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f1830b = savedState.f1834a;
        this.f1829a = this.f1830b.size();
        if (!this.f1830b.isEmpty()) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                PassWordView passWordView = (PassWordView) getChildAt(i2);
                if (i2 <= this.f1830b.size() - 1) {
                    if (passWordView != null) {
                        passWordView.setmPassText(this.f1830b.get(i2));
                        passWordView.a(true);
                    }
                    i2++;
                } else if (passWordView != null) {
                    passWordView.setmIsShowRemindLine(false);
                    passWordView.a(false);
                    return;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1834a = this.f1830b;
        return savedState;
    }

    public void setPwdChangeListener(a aVar) {
        this.f1831c = aVar;
    }
}
