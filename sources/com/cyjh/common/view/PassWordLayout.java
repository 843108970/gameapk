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

public class PassWordLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    int f1810a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public int f1811b;

    /* renamed from: c  reason: collision with root package name */
    List<String> f1812c;
    c d;
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
        public List<String> f1815a;

        private SavedState(Parcel parcel) {
            super(parcel);
            parcel.readStringList(this.f1815a);
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
            parcel.writeList(this.f1815a);
        }
    }

    class a implements View.OnKeyListener {
        a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0081, code lost:
            if (r4 != null) goto L_0x0092;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0090, code lost:
            if (r4 != null) goto L_0x0092;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onKey(android.view.View r3, int r4, android.view.KeyEvent r5) {
            /*
                r2 = this;
                int r3 = r5.getAction()
                r0 = 0
                if (r3 != 0) goto L_0x00c3
                boolean r3 = r5.isShiftPressed()
                if (r3 == 0) goto L_0x000e
                return r0
            L_0x000e:
                r3 = 7
                r5 = 1
                if (r4 < r3) goto L_0x004b
                r1 = 16
                if (r4 > r1) goto L_0x004b
                com.cyjh.common.view.PassWordLayout r0 = com.cyjh.common.view.PassWordLayout.this
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                int r4 = r4 - r3
                r1.append(r4)
                java.lang.String r3 = r1.toString()
                java.util.List<java.lang.String> r4 = r0.f1812c
                if (r4 == 0) goto L_0x003b
                java.util.List<java.lang.String> r4 = r0.f1812c
                int r4 = r4.size()
                int r1 = r0.f1810a
                if (r4 >= r1) goto L_0x003b
                java.util.List<java.lang.String> r4 = r0.f1812c
                r4.add(r3)
                r0.setNextInput(r3)
            L_0x003b:
                com.cyjh.common.view.PassWordLayout$c r3 = r0.d
                if (r3 == 0) goto L_0x004a
                java.util.List<java.lang.String> r3 = r0.f1812c
                int r3 = r3.size()
                int r4 = r0.f1810a
                r0.getPassString()
            L_0x004a:
                return r5
            L_0x004b:
                r3 = 67
                if (r4 != r3) goto L_0x00aa
                com.cyjh.common.view.PassWordLayout r3 = com.cyjh.common.view.PassWordLayout.this
                java.util.List<java.lang.String> r4 = r3.f1812c
                if (r4 == 0) goto L_0x009a
                java.util.List<java.lang.String> r4 = r3.f1812c
                int r4 = r4.size()
                if (r4 <= 0) goto L_0x009a
                java.util.List<java.lang.String> r4 = r3.f1812c
                java.util.List<java.lang.String> r1 = r3.f1812c
                int r1 = r1.size()
                int r1 = r1 - r5
                r4.remove(r1)
                int r4 = r3.f1811b
                if (r4 <= 0) goto L_0x0084
                int r4 = r3.f1811b
                java.lang.String r1 = ""
                r3.a(r4, r0, r1)
                int r4 = r3.f1811b
                int r4 = r4 - r5
                r3.f1811b = r4
                int r4 = r3.f1811b
                android.view.View r4 = r3.getChildAt(r4)
                com.cyjh.common.view.PassWordView r4 = (com.cyjh.common.view.PassWordView) r4
                if (r4 == 0) goto L_0x009a
                goto L_0x0092
            L_0x0084:
                int r4 = r3.f1811b
                if (r4 != 0) goto L_0x009a
                int r4 = r3.f1811b
                android.view.View r4 = r3.getChildAt(r4)
                com.cyjh.common.view.PassWordView r4 = (com.cyjh.common.view.PassWordView) r4
                if (r4 == 0) goto L_0x009a
            L_0x0092:
                java.lang.String r0 = ""
                r4.setmPassText(r0)
                r4.a()
            L_0x009a:
                com.cyjh.common.view.PassWordLayout$c r4 = r3.d
                if (r4 == 0) goto L_0x00a9
                java.util.List<java.lang.String> r4 = r3.f1812c
                int r4 = r4.size()
                if (r4 <= 0) goto L_0x00a9
                r3.getPassString()
            L_0x00a9:
                return r5
            L_0x00aa:
                com.cyjh.common.view.PassWordLayout r3 = com.cyjh.common.view.PassWordLayout.this
                android.content.Context r3 = r3.e
                java.lang.String r4 = "input_method"
                java.lang.Object r3 = r3.getSystemService(r4)
                android.view.inputmethod.InputMethodManager r3 = (android.view.inputmethod.InputMethodManager) r3
                com.cyjh.common.view.PassWordLayout r4 = com.cyjh.common.view.PassWordLayout.this
                android.os.IBinder r4 = r4.getWindowToken()
                r0 = 2
                r3.hideSoftInputFromWindow(r4, r0)
                return r5
            L_0x00c3:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cyjh.common.view.PassWordLayout.a.onKey(android.view.View, int, android.view.KeyEvent):boolean");
        }
    }

    private class b extends BaseInputConnection {
        public b(View view) {
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

    public interface c {
        void a();

        void b();

        void c();
    }

    public PassWordLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public PassWordLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PassWordLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1810a = 6;
        this.f1811b = 0;
        this.e = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PassWordLayoutStyle);
        this.g = obtainStyledAttributes.getResourceId(R.styleable.PassWordLayoutStyle_box_input_color, R.color.pass_view_rect_input);
        this.h = obtainStyledAttributes.getResourceId(R.styleable.PassWordLayoutStyle_box_no_input_color, R.color.regi_line_color);
        this.i = obtainStyledAttributes.getResourceId(R.styleable.PassWordLayoutStyle_input_line_color, R.color.pass_view_rect_input);
        this.j = obtainStyledAttributes.getResourceId(R.styleable.PassWordLayoutStyle_text_input_color, R.color.pass_view_rect_input);
        this.k = obtainStyledAttributes.getInt(R.styleable.PassWordLayoutStyle_box_draw_type, 0);
        this.l = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.PassWordLayoutStyle_interval_width, 4);
        this.f1810a = obtainStyledAttributes.getInt(R.styleable.PassWordLayoutStyle_pass_leng, 6);
        this.m = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.PassWordLayoutStyle_item_width, 40);
        this.n = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.PassWordLayoutStyle_item_height, 40);
        this.o = obtainStyledAttributes.getInt(R.styleable.PassWordLayoutStyle_pass_inputed_type, 0);
        this.p = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.PassWordLayoutStyle_draw_txt_size, 18);
        this.q = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.PassWordLayoutStyle_draw_box_line_size, 4);
        this.f = obtainStyledAttributes.getBoolean(R.styleable.PassWordLayoutStyle_is_show_input_line, true);
        obtainStyledAttributes.recycle();
        this.f1812c = new ArrayList();
        setOrientation(0);
        setGravity(17);
        setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PassWordLayout.this.setFocusable(true);
                PassWordLayout.this.setFocusableInTouchMode(true);
                PassWordLayout.this.requestFocus();
                ((InputMethodManager) PassWordLayout.this.getContext().getSystemService("input_method")).showSoftInput(PassWordLayout.this, 1);
            }
        });
        setOnKeyListener(new a());
        setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    PassWordView passWordView = (PassWordView) PassWordLayout.this.getChildAt(PassWordLayout.this.f1811b);
                    if (passWordView != null) {
                        passWordView.setmIsShowRemindLine(PassWordLayout.this.f);
                        passWordView.a();
                        return;
                    }
                    return;
                }
                PassWordView passWordView2 = (PassWordView) PassWordLayout.this.getChildAt(PassWordLayout.this.f1811b);
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
            java.util.List<java.lang.String> r0 = r3.f1812c
            if (r0 == 0) goto L_0x004c
            java.util.List<java.lang.String> r0 = r3.f1812c
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x004c
            java.util.List<java.lang.String> r0 = r3.f1812c
            java.util.List<java.lang.String> r1 = r3.f1812c
            int r1 = r1.size()
            int r1 = r1 + -1
            r0.remove(r1)
            int r0 = r3.f1811b
            if (r0 <= 0) goto L_0x0036
            int r0 = r3.f1811b
            r1 = 0
            java.lang.String r2 = ""
            r3.a(r0, r1, r2)
            int r0 = r3.f1811b
            int r0 = r0 + -1
            r3.f1811b = r0
            int r0 = r3.f1811b
            android.view.View r0 = r3.getChildAt(r0)
            com.cyjh.common.view.PassWordView r0 = (com.cyjh.common.view.PassWordView) r0
            if (r0 == 0) goto L_0x004c
            goto L_0x0044
        L_0x0036:
            int r0 = r3.f1811b
            if (r0 != 0) goto L_0x004c
            int r0 = r3.f1811b
            android.view.View r0 = r3.getChildAt(r0)
            com.cyjh.common.view.PassWordView r0 = (com.cyjh.common.view.PassWordView) r0
            if (r0 == 0) goto L_0x004c
        L_0x0044:
            java.lang.String r1 = ""
            r0.setmPassText(r1)
            r0.a()
        L_0x004c:
            com.cyjh.common.view.PassWordLayout$c r0 = r3.d
            if (r0 == 0) goto L_0x005b
            java.util.List<java.lang.String> r0 = r3.f1812c
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x005b
            r3.getPassString()
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.common.view.PassWordLayout.a():void");
    }

    private void a(Context context) {
        for (int i2 = 0; i2 < this.f1810a; i2++) {
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
        this.f1810a = obtainStyledAttributes.getInt(R.styleable.PassWordLayoutStyle_pass_leng, 6);
        this.m = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.PassWordLayoutStyle_item_width, 40);
        this.n = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.PassWordLayoutStyle_item_height, 40);
        this.o = obtainStyledAttributes.getInt(R.styleable.PassWordLayoutStyle_pass_inputed_type, 0);
        this.p = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.PassWordLayoutStyle_draw_txt_size, 18);
        this.q = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.PassWordLayoutStyle_draw_box_line_size, 4);
        this.f = obtainStyledAttributes.getBoolean(R.styleable.PassWordLayoutStyle_is_show_input_line, true);
        obtainStyledAttributes.recycle();
        this.f1812c = new ArrayList();
        setOrientation(0);
        setGravity(17);
        setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PassWordLayout.this.setFocusable(true);
                PassWordLayout.this.setFocusableInTouchMode(true);
                PassWordLayout.this.requestFocus();
                ((InputMethodManager) PassWordLayout.this.getContext().getSystemService("input_method")).showSoftInput(PassWordLayout.this, 1);
            }
        });
        setOnKeyListener(new a());
        setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    PassWordView passWordView = (PassWordView) PassWordLayout.this.getChildAt(PassWordLayout.this.f1811b);
                    if (passWordView != null) {
                        passWordView.setmIsShowRemindLine(PassWordLayout.this.f);
                        passWordView.a();
                        return;
                    }
                    return;
                }
                PassWordView passWordView2 = (PassWordView) PassWordLayout.this.getChildAt(PassWordLayout.this.f1811b);
                if (passWordView2 != null) {
                    passWordView2.setmIsShowRemindLine(false);
                    passWordView2.a(false);
                }
            }
        });
    }

    private void a(String str) {
        if (this.f1812c != null && this.f1812c.size() < this.f1810a) {
            this.f1812c.add(str);
            setNextInput(str);
        }
        if (this.d == null) {
            return;
        }
        if (this.f1812c.size() < this.f1810a) {
            getPassString();
        } else {
            getPassString();
        }
    }

    private void b() {
        PassWordView passWordView;
        if (this.f1812c != null) {
            for (int size = this.f1812c.size(); size >= 0; size--) {
                if (size > 0) {
                    a(size, false, "");
                } else if (size == 0 && (passWordView = (PassWordView) getChildAt(size)) != null) {
                    passWordView.setmPassText("");
                    passWordView.a();
                }
            }
            this.f1812c.clear();
            this.f1811b = 0;
        }
    }

    private void c() {
        PassWordView passWordView;
        if (this.f1811b > 0) {
            a(this.f1811b, false, "");
            this.f1811b--;
            PassWordView passWordView2 = (PassWordView) getChildAt(this.f1811b);
            if (passWordView2 != null) {
                passWordView2.setmPassText("");
                passWordView2.a();
            }
        } else if (this.f1811b == 0 && (passWordView = (PassWordView) getChildAt(this.f1811b)) != null) {
            passWordView.setmPassText("");
            passWordView.a();
        }
    }

    public final void a(int i2, boolean z, String str) {
        PassWordView passWordView;
        if (i2 >= 0 && (passWordView = (PassWordView) getChildAt(i2)) != null) {
            passWordView.setmPassText(str);
            passWordView.a(z);
        }
    }

    public String getPassString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : this.f1812c) {
            stringBuffer.append(append);
        }
        return stringBuffer.toString();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        editorInfo.inputType = 2;
        editorInfo.imeOptions = 268435456;
        return new b(this);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (getChildCount() == 0) {
            if ((this.f1810a * this.m) + ((this.f1810a - 1) * this.l) > getMeasuredWidth()) {
                this.m = (getMeasuredWidth() - ((this.f1810a - 1) * this.l)) / this.f1810a;
                this.n = this.m;
            }
            Context context = getContext();
            for (int i4 = 0; i4 < this.f1810a; i4++) {
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
        this.f1812c = savedState.f1815a;
        this.f1811b = this.f1812c.size();
        if (!this.f1812c.isEmpty()) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                PassWordView passWordView = (PassWordView) getChildAt(i2);
                if (i2 <= this.f1812c.size() - 1) {
                    if (passWordView != null) {
                        passWordView.setmPassText(this.f1812c.get(i2));
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
        savedState.f1815a = this.f1812c;
        return savedState;
    }

    /* access modifiers changed from: package-private */
    public void setNextInput(String str) {
        if (this.f1811b < this.f1810a) {
            a(this.f1811b, true, str);
            this.f1811b++;
            PassWordView passWordView = (PassWordView) getChildAt(this.f1811b);
            if (passWordView != null) {
                passWordView.setmPassText(str);
                passWordView.a();
            }
        }
    }

    public void setPwdChangeListener(c cVar) {
        this.d = cVar;
    }
}
