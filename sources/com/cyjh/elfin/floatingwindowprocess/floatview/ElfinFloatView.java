package com.cyjh.elfin.floatingwindowprocess.floatview;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.ae;
import com.cyjh.common.util.ag;
import com.cyjh.common.util.x;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.e.c.f;
import com.cyjh.elfin.e.c.o;
import com.cyjh.elfin.entity.ElfinFloatViewEvent;
import com.cyjh.elfin.entity.MsgItem;
import com.cyjh.elfin.entity.ParamsWrap;
import com.cyjh.elfin.floatingwindowprocess.a.a;
import com.cyjh.elfin.floatingwindowprocess.a.c;
import com.cyjh.elfin.floatingwindowprocess.d.a;
import com.cyjh.elfin.services.PhoneStateService;
import com.cyjh.http.a.e;
import com.cyjh.http.c.c.c;
import com.cyjh.mq.sdk.MqBridge;
import com.cyjh.mq.sdk.MqRunner;
import com.ywfzjbcy.R;
import java.lang.ref.WeakReference;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.j;

public class ElfinFloatView extends LinearLayout implements View.OnClickListener {
    private static final int G = 1;
    private static final int H = 2;
    private static final int I = 3;
    private static final int J = 4;
    private static final int K = 60;
    private static final int L = 2;
    private static final int M = 5000;
    private static final int N = 2000;
    private static final int O = 1000;
    private static final int R = 5;

    /* renamed from: a  reason: collision with root package name */
    public static final String f2041a = "ElfinFloatView";

    /* renamed from: b  reason: collision with root package name */
    public static final int f2042b = 3000;
    private static final int p = 1000;
    private static final int q = 1001;
    private LinearLayout A;
    private LinearLayout B;
    private LinearLayout C;
    private c D;
    private com.cyjh.elfin.floatingwindowprocess.a.b E;
    private boolean F = true;
    private b P = new b(this, (byte) 0);
    private int Q;
    private final View.OnTouchListener S = new View.OnTouchListener() {

        /* renamed from: b  reason: collision with root package name */
        private static final int f2046b = 5;

        /* renamed from: c  reason: collision with root package name */
        private a f2048c = new a(ElfinFloatView.this, (byte) 0);
        private GestureDetector d = new GestureDetector(ElfinFloatView.this.getContext(), this.f2048c);

        private static float a(float f, float f2, float f3, float f4) {
            return (float) Math.sqrt(Math.pow((double) (f - f3), 2.0d) + Math.pow((double) (f2 - f4), 2.0d));
        }

        /* JADX WARNING: Removed duplicated region for block: B:34:0x010e  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x011f  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x013e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onTouch(android.view.View r10, android.view.MotionEvent r11) {
            /*
                r9 = this;
                android.view.GestureDetector r10 = r9.d
                boolean r10 = r10.onTouchEvent(r11)
                r0 = 1
                if (r10 == 0) goto L_0x000a
                return r0
            L_0x000a:
                int r10 = r11.getAction()
                r1 = 0
                r2 = 8
                switch(r10) {
                    case 0: goto L_0x01b9;
                    case 1: goto L_0x0148;
                    case 2: goto L_0x0015;
                    default: goto L_0x0014;
                }
            L_0x0014:
                return r1
            L_0x0015:
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                android.widget.LinearLayout r10 = r10.e
                int r10 = r10.getVisibility()
                if (r10 != 0) goto L_0x0022
                return r0
            L_0x0022:
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r3 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                float r3 = r3.u
                float unused = r10.y = r3
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r3 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                float r3 = r3.v
                float unused = r10.z = r3
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                float r3 = r11.getRawX()
                float unused = r10.u = r3
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                float r11 = r11.getRawY()
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r3 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                android.content.Context r3 = r3.getContext()
                int r3 = com.cyjh.common.util.a.d(r3)
                float r3 = (float) r3
                float r11 = r11 - r3
                float unused = r10.v = r11
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                float r10 = r10.y
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r11 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                float r11 = r11.z
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r3 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                float r3 = r3.u
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r4 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                float r4 = r4.v
                float r10 = r10 - r3
                double r5 = (double) r10
                r7 = 4611686018427387904(0x4000000000000000, double:2.0)
                double r5 = java.lang.Math.pow(r5, r7)
                float r11 = r11 - r4
                double r10 = (double) r11
                double r10 = java.lang.Math.pow(r10, r7)
                double r5 = r5 + r10
                double r10 = java.lang.Math.sqrt(r5)
                float r10 = (float) r10
                r11 = 1084227584(0x40a00000, float:5.0)
                int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
                if (r10 > 0) goto L_0x0089
                return r0
            L_0x0089:
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                float r10 = r10.v
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r11 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                float r11 = r11.z
                float r10 = r10 - r11
                double r10 = (double) r10
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r3 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                float r3 = r3.u
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r4 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                float r4 = r4.y
                float r3 = r3 - r4
                double r3 = (double) r3
                double r10 = java.lang.Math.atan2(r10, r3)
                double r10 = java.lang.Math.toDegrees(r10)
                r3 = -4589730970243956736(0xc04e000000000000, double:-60.0)
                int r5 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                r6 = -4585227370616586240(0xc05e000000000000, double:-120.0)
                if (r5 >= 0) goto L_0x00bb
                int r5 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r5 <= 0) goto L_0x00bb
            L_0x00b9:
                r10 = 1
                goto L_0x00dc
            L_0x00bb:
                int r5 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                r3 = 4633641066610819072(0x404e000000000000, double:60.0)
                if (r5 < 0) goto L_0x00c7
                int r5 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                if (r5 > 0) goto L_0x00c7
                r10 = 2
                goto L_0x00dc
            L_0x00c7:
                int r5 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                r3 = 4638144666238189568(0x405e000000000000, double:120.0)
                if (r5 <= 0) goto L_0x00d3
                int r5 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                if (r5 >= 0) goto L_0x00d3
                r10 = 3
                goto L_0x00dc
            L_0x00d3:
                int r5 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                if (r5 >= 0) goto L_0x00db
                int r3 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r3 > 0) goto L_0x00b9
            L_0x00db:
                r10 = 4
            L_0x00dc:
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r11 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                r11.a((int) r10)
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r11 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                float r11 = r11.u
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r3 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                float r3 = r3.w
                float r11 = r11 - r3
                int r11 = (int) r11
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r3 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                float r3 = r3.v
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r4 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                float r4 = r4.x
                float r3 = r3 - r4
                int r3 = (int) r3
                r10.a((int) r11, (int) r3)
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                com.cyjh.elfin.floatingwindowprocess.floatview.DeleteFloatView r10 = r10.k
                int r10 = r10.getVisibility()
                if (r10 != r2) goto L_0x0117
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                com.cyjh.elfin.floatingwindowprocess.floatview.DeleteFloatView r10 = r10.k
                r10.setVisibility(r1)
            L_0x0117:
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                boolean r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.n(r10)
                if (r10 == 0) goto L_0x013e
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                com.cyjh.elfin.floatingwindowprocess.floatview.DeleteFloatView r10 = r10.k
                android.widget.ImageView r11 = r10.f2040c
                r1 = 2130837667(0x7f0200a3, float:1.7280295E38)
                r11.setImageResource(r1)
                android.widget.TextView r11 = r10.f2039b
                android.content.res.Resources r10 = r10.getResources()
                r1 = 2131624042(0x7f0e006a, float:1.8875253E38)
                int r10 = r10.getColor(r1)
                r11.setTextColor(r10)
                return r0
            L_0x013e:
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                com.cyjh.elfin.floatingwindowprocess.floatview.DeleteFloatView r10 = r10.k
                r10.a()
                return r0
            L_0x0148:
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                float r0 = r11.getRawX()
                float unused = r10.u = r0
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                float r11 = r11.getRawY()
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r0 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                android.content.Context r0 = r0.getContext()
                int r0 = com.cyjh.common.util.a.d(r0)
                float r0 = (float) r0
                float r11 = r11 - r0
                float unused = r10.v = r11
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                boolean r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.n(r10)
                if (r10 == 0) goto L_0x0195
                com.cyjh.elfin.floatingwindowprocess.a.a r10 = new com.cyjh.elfin.floatingwindowprocess.a.a
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r11 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                android.content.Context r11 = r11.getContext()
                r10.<init>(r11)
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r11 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                com.cyjh.elfin.floatingwindowprocess.a.a$b r11 = r11.T
                r10.f1975a = r11
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r11 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                com.cyjh.elfin.floatingwindowprocess.a.a$a r11 = r11.U
                r10.f1976b = r11
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView$3$1 r11 = new com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView$3$1
                r11.<init>()
                r10.setOnCancelListener(r11)
                r10.show()
                return r1
            L_0x0195:
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                android.widget.LinearLayout r10 = r10.e
                int r10 = r10.getVisibility()
                if (r10 != r2) goto L_0x01a6
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.q(r10)
            L_0x01a6:
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                com.cyjh.elfin.floatingwindowprocess.floatview.DeleteFloatView r10 = r10.k
                r10.setVisibility(r2)
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                android.os.CountDownTimer r10 = r10.m
                r10.start()
                return r1
            L_0x01b9:
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                r10.b()
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                float r0 = r11.getRawX()
                float unused = r10.u = r0
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                float r0 = r11.getRawY()
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r2 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                android.content.Context r2 = r2.getContext()
                int r2 = com.cyjh.common.util.a.d(r2)
                float r2 = (float) r2
                float r0 = r0 - r2
                float unused = r10.v = r0
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                float r0 = r11.getX()
                float unused = r10.w = r0
                com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r10 = com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.this
                float r11 = r11.getY()
                float unused = r10.x = r11
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView.AnonymousClass3.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    };
    /* access modifiers changed from: private */
    public a.b T = new a.b() {
        public final void a() {
            ElfinFloatView.this.d();
        }
    };
    /* access modifiers changed from: private */
    public a.C0026a U = new a.C0026a() {
        public final void a() {
            ElfinFloatView.q(ElfinFloatView.this);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public ImageView f2043c;
    public LinearLayout d;
    public LinearLayout e;
    public TextView f;
    public ImageView g;
    public TextView h;
    public ImageView i;
    public boolean j = true;
    public DeleteFloatView k;
    /* access modifiers changed from: package-private */
    public boolean l = false;
    public CountDownTimer m = new CountDownTimer() {
        public final void onFinish() {
            ImageView c2;
            int i;
            int[] iArr = new int[2];
            ElfinFloatView.this.f2043c.getLocationOnScreen(iArr);
            if (((float) iArr[0]) >= (((float) com.cyjh.common.util.a.a(ElfinFloatView.this.getContext()).x) - ElfinFloatView.this.w) / 2.0f) {
                if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 2 || com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 4) {
                    c2 = ElfinFloatView.this.f2043c;
                    i = R.drawable.elfin_run_left_edge;
                } else if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 3) {
                    c2 = ElfinFloatView.this.f2043c;
                    i = R.drawable.elfin_pause_left_edge;
                } else {
                    c2 = ElfinFloatView.this.f2043c;
                    i = R.drawable.elfin_normal_left_edge;
                }
            } else if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 2 || com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 4) {
                c2 = ElfinFloatView.this.f2043c;
                i = R.drawable.elfin_run_right_edge;
            } else if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 3) {
                c2 = ElfinFloatView.this.f2043c;
                i = R.drawable.elfin_pause_right_edge;
            } else {
                c2 = ElfinFloatView.this.f2043c;
                i = R.drawable.elfin_normal_right_edge;
            }
            c2.setImageResource(i);
        }

        public final void onTick(long j) {
            if (j <= 3000 && j > 2000) {
                ElfinFloatView.this.f2043c.setAlpha(0.5f);
                ElfinFloatView.this.a(false);
            }
        }
    };
    public int n;
    c.a o = new c.a() {
        public final void a() {
            ElfinFloatView.this.o();
        }
    };
    private WindowManager r;
    private WindowManager.LayoutParams s;
    private Context t;
    /* access modifiers changed from: private */
    public float u;
    /* access modifiers changed from: private */
    public float v;
    /* access modifiers changed from: private */
    public float w;
    /* access modifiers changed from: private */
    public float x;
    /* access modifiers changed from: private */
    public float y;
    /* access modifiers changed from: private */
    public float z;

    private class a implements GestureDetector.OnGestureListener {
        private a() {
        }

        /* synthetic */ a(ElfinFloatView elfinFloatView, byte b2) {
            this();
        }

        public final boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        public final void onLongPress(MotionEvent motionEvent) {
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        public final void onShowPress(MotionEvent motionEvent) {
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            if (ElfinFloatView.this.k.getVisibility() == 0) {
                ElfinFloatView.this.k.setVisibility(8);
            }
            if (ElfinFloatView.this.e.getVisibility() == 0) {
                ElfinFloatView.this.a(false);
            } else {
                ElfinFloatView.this.a(true);
            }
            ElfinFloatView.this.m.start();
            return true;
        }
    }

    private static class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<ElfinFloatView> f2056a;

        private b(ElfinFloatView elfinFloatView) {
            this.f2056a = new WeakReference<>(elfinFloatView);
        }

        /* synthetic */ b(ElfinFloatView elfinFloatView, byte b2) {
            this(elfinFloatView);
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            ElfinFloatView elfinFloatView = (ElfinFloatView) this.f2056a.get();
            switch (message.what) {
                case 1000:
                    f.a();
                    AppContext a2 = AppContext.a();
                    f.a(a2, "ElfinFloatView handleMessage --> isScriptStopRunning=" + AppContext.a().i);
                    elfinFloatView.m();
                    return;
                case 1001:
                    elfinFloatView.o();
                    return;
                default:
                    return;
            }
        }
    }

    public ElfinFloatView(Context context, DeleteFloatView deleteFloatView) {
        super(context);
        WindowManager.LayoutParams layoutParams;
        int i2;
        this.t = context;
        LayoutInflater.from(getContext()).inflate(R.layout.floatview_elfin, this);
        this.d = (LinearLayout) findViewById(R.id.floatview_elfin_liearlayout_elfin);
        this.e = (LinearLayout) findViewById(R.id.floatview_elfin_liearlayout_tools);
        this.A = (LinearLayout) findViewById(R.id.floatview_linearlayout_run);
        this.B = (LinearLayout) findViewById(R.id.floatview_linearlayout_info);
        this.C = (LinearLayout) findViewById(R.id.floatview_linearlayout_setting);
        this.f = (TextView) findViewById(R.id.id_tv_run_and_pause);
        this.g = (ImageView) findViewById(R.id.floatview_imageview_run_and_pause);
        this.h = (TextView) findViewById(R.id.id_tv_setting_and_stop);
        this.i = (ImageView) findViewById(R.id.floatview_imageview_setting);
        this.A.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.C.setOnClickListener(this);
        findViewById(R.id.floatview_linearlayout_exit).setOnClickListener(this);
        this.f2043c = (ImageView) findViewById(R.id.floatview_elfin_imageview_elfin);
        a();
        this.f2043c.setOnClickListener((View.OnClickListener) null);
        this.f2043c.setOnTouchListener(this.S);
        this.r = (WindowManager) getContext().getSystemService("window");
        this.s = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams = this.s;
            i2 = 2038;
        } else if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 24) {
            layoutParams = this.s;
            i2 = 2002;
        } else {
            layoutParams = this.s;
            i2 = 2005;
        }
        layoutParams.type = i2;
        this.s.format = 1;
        this.s.flags = 40;
        this.s.gravity = 51;
        this.s.x = com.cyjh.common.util.a.a(getContext()).x - this.d.getLayoutParams().width;
        this.s.y = com.cyjh.common.util.a.a(getContext()).y / 4;
        this.v = (float) (com.cyjh.common.util.a.a(getContext()).y / 4);
        this.s.width = this.d.getLayoutParams().width;
        this.s.height = this.d.getLayoutParams().height;
        this.k = deleteFloatView;
        this.m.start();
        org.greenrobot.eventbus.c.a().a((Object) this);
        ad.c(f2041a, "ElfinFloatView EventBus register");
    }

    private void a(float f2, int i2, int i3) {
        ImageView imageView;
        int i4;
        String str = f2041a;
        ad.c(str, "posControlBar --> position=" + f2 + ",lockState=" + i2 + ",isRight=" + i3);
        this.n = i2;
        if (this.n != 0) {
            this.f2043c.setOnTouchListener((View.OnTouchListener) null);
        }
        if (this.k.getVisibility() == 0) {
            this.k.setVisibility(8);
            this.k.a();
        }
        a(i3 == 0 ? 0 : com.cyjh.common.util.a.a(getContext()).x, (int) ((((float) com.cyjh.common.util.a.a(getContext()).y) * f2) - ((float) getHeight())));
        this.d.removeView(this.e);
        this.d.addView(this.e, 0);
        if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 2) {
            imageView = this.f2043c;
            i4 = R.drawable.elfin_run1;
        } else if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 3) {
            imageView = this.f2043c;
            i4 = R.drawable.elfin_pause1;
        } else {
            imageView = this.f2043c;
            i4 = R.drawable.elfin_normal1;
        }
        imageView.setImageResource(i4);
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        ImageView imageView;
        int i3;
        switch (i2) {
            case 1:
                if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d != 2 && com.cyjh.elfin.floatingwindowprocess.c.c.f().d != 4) {
                    if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d != 3) {
                        imageView = this.f2043c;
                        i3 = R.drawable.elfin_normal1;
                        break;
                    } else {
                        imageView = this.f2043c;
                        i3 = R.drawable.elfin_pause1;
                        break;
                    }
                } else {
                    imageView = this.f2043c;
                    i3 = R.drawable.elfin_run1;
                    break;
                }
                break;
            case 2:
                if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d != 2 && com.cyjh.elfin.floatingwindowprocess.c.c.f().d != 4) {
                    if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d != 3) {
                        imageView = this.f2043c;
                        i3 = R.drawable.elfin_normal_right_up;
                        break;
                    } else {
                        imageView = this.f2043c;
                        i3 = R.drawable.elfin_pause_right_up;
                        break;
                    }
                } else {
                    imageView = this.f2043c;
                    i3 = R.drawable.elfin_run_right_up;
                    break;
                }
                break;
            case 3:
                if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d != 2 && com.cyjh.elfin.floatingwindowprocess.c.c.f().d != 4) {
                    if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d != 3) {
                        imageView = this.f2043c;
                        i3 = R.drawable.elfin_normal_down;
                        break;
                    } else {
                        imageView = this.f2043c;
                        i3 = R.drawable.elfin_pause_down;
                        break;
                    }
                } else {
                    imageView = this.f2043c;
                    i3 = R.drawable.elfin_run_down;
                    break;
                }
            case 4:
                if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 2 || com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 4) {
                    imageView = this.f2043c;
                    i3 = R.drawable.elfin_run_left_up;
                    break;
                } else if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 3) {
                    imageView = this.f2043c;
                    i3 = R.drawable.elfin_pause_left_up;
                    break;
                } else {
                    this.f2043c.setImageResource(R.drawable.elfin_normal_left_up);
                    return;
                }
            default:
                return;
        }
        imageView.setImageResource(i3);
    }

    private void b(boolean z2) {
        if (z2) {
            if (MqRunner.getInstance().isScriptStarted()) {
                com.cyjh.elfin.floatingwindowprocess.service.a.a().a(5, 1001, "脚本正在运行中……");
            } else if (!this.l) {
                this.l = true;
                if (!x.a(getContext())) {
                    ag.b(getContext(), getContext().getString(R.string.network_off));
                    this.l = false;
                    com.cyjh.elfin.floatingwindowprocess.service.a.a().a(5, 1001, getContext().getString(R.string.network_off));
                    return;
                }
                com.cyjh.elfin.floatingwindowprocess.d.a.a((a.C0028a) new a.C0028a() {
                    public final void a() {
                        boolean unused = ElfinFloatView.this.l = false;
                    }

                    public final void b() {
                        boolean unused = ElfinFloatView.this.l = false;
                    }
                });
            }
        } else if (MqRunner.getInstance().isScriptStarted()) {
            MqRunner.getInstance().stop();
            this.l = false;
            com.cyjh.elfin.floatingwindowprocess.service.a.a().a(6, 1002, "脚本停止运行！");
        } else {
            com.cyjh.elfin.floatingwindowprocess.service.a.a().a(5, 1002, "脚本未在运行状态！");
        }
    }

    private void e() {
        LayoutInflater.from(getContext()).inflate(R.layout.floatview_elfin, this);
        this.d = (LinearLayout) findViewById(R.id.floatview_elfin_liearlayout_elfin);
        this.e = (LinearLayout) findViewById(R.id.floatview_elfin_liearlayout_tools);
        this.A = (LinearLayout) findViewById(R.id.floatview_linearlayout_run);
        this.B = (LinearLayout) findViewById(R.id.floatview_linearlayout_info);
        this.C = (LinearLayout) findViewById(R.id.floatview_linearlayout_setting);
        this.f = (TextView) findViewById(R.id.id_tv_run_and_pause);
        this.g = (ImageView) findViewById(R.id.floatview_imageview_run_and_pause);
        this.h = (TextView) findViewById(R.id.id_tv_setting_and_stop);
        this.i = (ImageView) findViewById(R.id.floatview_imageview_setting);
        this.A.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.C.setOnClickListener(this);
        findViewById(R.id.floatview_linearlayout_exit).setOnClickListener(this);
        this.f2043c = (ImageView) findViewById(R.id.floatview_elfin_imageview_elfin);
        a();
        this.f2043c.setOnClickListener((View.OnClickListener) null);
        this.f2043c.setOnTouchListener(this.S);
    }

    private void f() {
        this.f2043c = (ImageView) findViewById(R.id.floatview_elfin_imageview_elfin);
        a();
        this.f2043c.setOnClickListener((View.OnClickListener) null);
        this.f2043c.setOnTouchListener(this.S);
    }

    private void g() {
        WindowManager.LayoutParams layoutParams;
        int i2;
        this.r = (WindowManager) getContext().getSystemService("window");
        this.s = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams = this.s;
            i2 = 2038;
        } else if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 24) {
            layoutParams = this.s;
            i2 = 2002;
        } else {
            layoutParams = this.s;
            i2 = 2005;
        }
        layoutParams.type = i2;
        this.s.format = 1;
        this.s.flags = 40;
        this.s.gravity = 51;
        this.s.x = com.cyjh.common.util.a.a(getContext()).x - this.d.getLayoutParams().width;
        this.s.y = com.cyjh.common.util.a.a(getContext()).y / 4;
        this.v = (float) (com.cyjh.common.util.a.a(getContext()).y / 4);
        this.s.width = this.d.getLayoutParams().width;
        this.s.height = this.d.getLayoutParams().height;
    }

    private void h() {
        ImageView imageView;
        int i2;
        if (this.k.getVisibility() == 0) {
            this.k.setVisibility(8);
            this.k.a();
        }
        int[] iArr = new int[2];
        this.f2043c.getLocationOnScreen(iArr);
        if (((float) iArr[0]) >= (((float) com.cyjh.common.util.a.a(getContext()).x) - this.w) / 2.0f) {
            a(com.cyjh.common.util.a.a(getContext()).x, (int) (this.v - this.x));
            this.d.removeView(this.e);
            this.d.addView(this.e, 0);
        } else {
            a(0, (int) (this.v - this.x));
            this.d.removeView(this.e);
            this.d.addView(this.e, 1);
        }
        if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 2 || com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 4) {
            imageView = this.f2043c;
            i2 = R.drawable.elfin_run1;
        } else if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 3) {
            imageView = this.f2043c;
            i2 = R.drawable.elfin_pause1;
        } else {
            imageView = this.f2043c;
            i2 = R.drawable.elfin_normal1;
        }
        imageView.setImageResource(i2);
    }

    private void i() {
        ImageView imageView;
        int i2;
        if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 2) {
            imageView = this.f2043c;
            i2 = R.drawable.elfin_run1;
        } else if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 3) {
            imageView = this.f2043c;
            i2 = R.drawable.elfin_pause1;
        } else {
            imageView = this.f2043c;
            i2 = R.drawable.elfin_normal1;
        }
        imageView.setImageResource(i2);
        b();
        this.m.start();
    }

    private boolean j() {
        int[] iArr = new int[2];
        this.f2043c.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        this.k.getLocationOnScreen(iArr2);
        return iArr[0] > iArr2[0] && iArr[0] < iArr2[0] + this.k.d.getLayoutParams().width && iArr[1] > iArr2[1];
    }

    private void k() {
        f.a();
        AppContext a2 = AppContext.a();
        f.a(a2, "ElfinFloatView runScriptOperate --> isPreventRepeatedClick=" + this.l);
        String str = f2041a;
        ad.c(str, "runScriptOperate --> 1 isPreventRepeatedClick=" + this.l);
        if (AppContext.a().f) {
            ag.a((Context) AppContext.a(), (int) R.string.version_too_low);
            f.a();
            f.a(AppContext.a(), "ElfinFloatView runScriptOperate --> 当前版本过低，请更新至最新版本！");
            return;
        }
        if (com.cyjh.http.e.a.a((Context) AppContext.a(), com.cyjh.common.b.a.aw) && e.a().f2474a == 1) {
            ag.a((Context) AppContext.a(), (int) R.string.environment_init_failure);
            return;
        }
        com.cyjh.elfin.floatingwindowprocess.c.c f2 = com.cyjh.elfin.floatingwindowprocess.c.c.f();
        if ((f2.f2011a != null && !TextUtils.isEmpty(f2.f2011a.getAppId())) || (f2.f2011a != null && TextUtils.isEmpty(f2.f2011a.getVersion()))) {
            if (!o.c(AppContext.a(), com.cyjh.elfin.floatingwindowprocess.c.c.f().f2012c)) {
                ag.a((Context) AppContext.a(), (int) R.string.script_file_verify_failure);
                return;
            }
        }
        if (!this.l) {
            this.l = true;
            com.cyjh.elfin.floatingwindowprocess.d.b.j();
            if (com.cyjh.elfin.floatingwindowprocess.d.b.b()) {
                ad.c(f2041a, "runScriptOperate --> 2");
                ae.b(getContext(), "runScriptOperate -->　停止引擎");
                com.cyjh.elfin.floatingwindowprocess.d.b.j();
                com.cyjh.elfin.floatingwindowprocess.d.b.d();
                this.l = false;
                f.a();
                f.a(AppContext.a(), "ElfinFloatView runScriptOperate --> 停止引擎");
            } else {
                ad.c(f2041a, "runScriptOperate --> 3");
                if (!x.a(getContext())) {
                    ag.b(getContext(), getContext().getString(R.string.network_off));
                    this.l = false;
                    f.a();
                    f.a(AppContext.a(), "ElfinFloatView runScriptOperate --> 当前网络异常，请检查网络设置");
                    return;
                }
                com.cyjh.elfin.floatingwindowprocess.d.a.a((a.C0028a) new a.C0028a() {
                    public final void a() {
                        boolean unused = ElfinFloatView.this.l = false;
                    }

                    public final void b() {
                        boolean unused = ElfinFloatView.this.l = false;
                    }
                });
            }
            if (this.P == null) {
                this.P = new b(this, (byte) 0);
            }
            this.P.removeCallbacksAndMessages((Object) null);
            this.P.postDelayed(new a(this), 3000);
        }
    }

    private void l() {
        a(false);
        com.cyjh.elfin.floatingwindowprocess.d.b.j();
        com.cyjh.elfin.floatingwindowprocess.d.b.c();
    }

    /* access modifiers changed from: private */
    public void m() {
        ad.c(f2041a, "judgeEngineStatus --> ");
        f.a();
        f.a(AppContext.a(), "ElfinFloatView judgeEngineStatus --> isScriptStopRunning=" + AppContext.a().i);
        if (this.Q >= 5) {
            com.cyjh.elfin.floatingwindowprocess.d.b.j();
            com.cyjh.elfin.floatingwindowprocess.d.b.d();
            this.Q = 1;
            f.a();
            f.a(AppContext.a(), "ElfinFloatView judgeEngineStatus --> ScriptRunnerManager.getInstance().stop()");
        }
        if (this.P == null) {
            this.P = new b(this, (byte) 0);
        }
        if (AppContext.a().i) {
            this.P.removeMessages(1000);
            k();
            return;
        }
        this.Q++;
        if (this.P.hasMessages(1000)) {
            this.P.removeMessages(1000);
        }
        this.P.sendEmptyMessageDelayed(1000, 3000);
    }

    private void n() {
        if (ParamsWrap.getParamsWrap().mStartRunResponseInfo == null) {
            o();
            return;
        }
        com.cyjh.elfin.floatingwindowprocess.d.a.a(this.o);
        this.P.sendEmptyMessageDelayed(1001, 3000);
    }

    static /* synthetic */ boolean n(ElfinFloatView elfinFloatView) {
        int[] iArr = new int[2];
        elfinFloatView.f2043c.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        elfinFloatView.k.getLocationOnScreen(iArr2);
        return iArr[0] > iArr2[0] && iArr[0] < iArr2[0] + elfinFloatView.k.d.getLayoutParams().width && iArr[1] > iArr2[1];
    }

    /* access modifiers changed from: private */
    public void o() {
        this.P.removeMessages(1001);
        ad.c(f2041a, "exitEngine --> ");
        getContext().stopService(new Intent(getContext(), PhoneStateService.class));
        MqBridge.exit();
        Process.killProcess(Process.myPid());
        ActivityManager activityManager = (ActivityManager) getContext().getSystemService("activity");
        if (activityManager != null) {
            activityManager.killBackgroundProcesses("com.cyjh.elfin:download_server");
        }
        org.greenrobot.eventbus.c.a().b((Object) this);
        ad.c(f2041a, "ElfinFloatView EventBus unregister");
    }

    private /* synthetic */ void p() {
        this.l = false;
    }

    static /* synthetic */ void q(ElfinFloatView elfinFloatView) {
        ImageView imageView;
        int i2;
        if (elfinFloatView.k.getVisibility() == 0) {
            elfinFloatView.k.setVisibility(8);
            elfinFloatView.k.a();
        }
        int[] iArr = new int[2];
        elfinFloatView.f2043c.getLocationOnScreen(iArr);
        if (((float) iArr[0]) >= (((float) com.cyjh.common.util.a.a(elfinFloatView.getContext()).x) - elfinFloatView.w) / 2.0f) {
            elfinFloatView.a(com.cyjh.common.util.a.a(elfinFloatView.getContext()).x, (int) (elfinFloatView.v - elfinFloatView.x));
            elfinFloatView.d.removeView(elfinFloatView.e);
            elfinFloatView.d.addView(elfinFloatView.e, 0);
        } else {
            elfinFloatView.a(0, (int) (elfinFloatView.v - elfinFloatView.x));
            elfinFloatView.d.removeView(elfinFloatView.e);
            elfinFloatView.d.addView(elfinFloatView.e, 1);
        }
        if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 2 || com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 4) {
            imageView = elfinFloatView.f2043c;
            i2 = R.drawable.elfin_run1;
        } else if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 3) {
            imageView = elfinFloatView.f2043c;
            i2 = R.drawable.elfin_pause1;
        } else {
            imageView = elfinFloatView.f2043c;
            i2 = R.drawable.elfin_normal1;
        }
        imageView.setImageResource(i2);
    }

    public final void a() {
        ImageView imageView;
        int i2 = com.cyjh.elfin.floatingwindowprocess.c.c.f().d;
        int i3 = R.drawable.floatview_elfin_stop;
        if (i2 == 2) {
            this.f2043c.setImageResource(R.drawable.elfin_pause1);
            this.f.setText(getContext().getString(R.string.floatview_elfin_pause));
            this.g.setImageResource(R.drawable.floatview_elfin_pause);
        } else if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 3) {
            this.f2043c.setImageResource(R.drawable.elfin_normal1);
            this.f.setText(getContext().getString(R.string.floatview_elfin_run));
            this.g.setImageResource(R.drawable.floatview_elfin_run);
        } else {
            this.f2043c.setImageResource(R.drawable.elfin_normal1);
            this.f.setText(getContext().getString(R.string.floatview_elfin_run));
            this.g.setImageResource(R.drawable.floatview_elfin_run);
            this.h.setText(getContext().getString(R.string.floatview_elfin_setting));
            imageView = this.i;
            i3 = R.drawable.floatview_elfin_setting;
            imageView.setImageResource(i3);
        }
        this.h.setText(getContext().getString(R.string.floatview_elfin_stop));
        imageView = this.i;
        imageView.setImageResource(i3);
    }

    public final void a(int i2, int i3) {
        this.s.x = i2;
        this.s.y = i3;
        this.r.updateViewLayout(this, this.s);
    }

    public final void a(boolean z2) {
        a(1);
        if (z2) {
            if (this.e.getVisibility() == 8) {
                this.e.setVisibility(0);
            }
        } else if (this.e.getVisibility() == 0) {
            this.e.setVisibility(8);
        }
    }

    public final void b() {
        this.m.cancel();
        this.f2043c.setAlpha(1.0f);
    }

    public final void c() {
        b();
        this.m.start();
        a(1);
        this.s.x = com.cyjh.common.util.a.a(getContext()).x - this.d.getLayoutParams().width;
        this.s.y = com.cyjh.common.util.a.a(getContext()).y / 4;
        this.r.updateViewLayout(this, this.s);
        DeleteFloatView deleteFloatView = this.k;
        deleteFloatView.f2038a.x = (com.cyjh.common.util.a.a(deleteFloatView.getContext()).x - deleteFloatView.d.getLayoutParams().width) / 2;
        deleteFloatView.f2038a.y = com.cyjh.common.util.a.a(deleteFloatView.getContext()).y;
        ((WindowManager) deleteFloatView.getContext().getSystemService("window")).updateViewLayout(deleteFloatView, deleteFloatView.f2038a);
    }

    public final void d() {
        b();
        int i2 = 0;
        if (getVisibility() == 0) {
            a(false);
            i2 = 8;
            this.k.setVisibility(8);
        } else {
            this.m.start();
            a(com.cyjh.common.util.a.a(getContext()).x, com.cyjh.common.util.a.a(getContext()).y / 4);
        }
        setVisibility(i2);
    }

    public WindowManager.LayoutParams getLayoutParams() {
        return this.s;
    }

    public void onClick(View view) {
        b();
        int id = view.getId();
        if (id != R.id.floatview_linearlayout_run) {
            if (id != R.id.floatview_linearlayout_setting) {
                if (id == R.id.floatview_linearlayout_info) {
                    this.E = new com.cyjh.elfin.floatingwindowprocess.a.b(getContext());
                    this.E.show();
                } else if (id == R.id.floatview_linearlayout_exit) {
                    if (ParamsWrap.getParamsWrap().mStartRunResponseInfo == null) {
                        o();
                    } else {
                        com.cyjh.elfin.floatingwindowprocess.d.a.a(this.o);
                        this.P.sendEmptyMessageDelayed(1001, 3000);
                    }
                }
            } else if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 3 || com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 2 || com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 4) {
                ad.c(f2041a, "runScriptOperate --> 2");
                ae.b(getContext(), "runScriptOperate -->　停止引擎");
                com.cyjh.elfin.floatingwindowprocess.d.b.j();
                com.cyjh.elfin.floatingwindowprocess.d.b.d();
                this.l = false;
                f.a();
                f.a(AppContext.a(), "ElfinFloatView runScriptOperate --> 停止引擎");
            } else {
                this.D = new com.cyjh.elfin.floatingwindowprocess.a.c(getContext());
                this.D.f1984a = this.t;
                this.D.show();
            }
        } else if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d != 4) {
            if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 3) {
                com.cyjh.elfin.floatingwindowprocess.d.b.j();
                com.cyjh.elfin.floatingwindowprocess.d.b.f();
            } else if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 2) {
                com.cyjh.elfin.floatingwindowprocess.d.b.j();
                com.cyjh.elfin.floatingwindowprocess.d.b.e();
            } else {
                k();
            }
        } else {
            return;
        }
        this.m.start();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (this.P != null) {
            this.P.removeCallbacksAndMessages((Object) null);
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    @j(a = ThreadMode.MAIN)
    public void onMessageMainThread(MsgItem msgItem) {
        switch (msgItem.getMsgType()) {
            case 2000:
                ad.c(f2041a, "SCRIPT_NEED_UPGRADE");
                com.cyjh.elfin.floatingwindowprocess.d.a.a((a.C0028a) null);
                return;
            case MsgItem.SCRIPT_NEED_START:
                this.P.postDelayed(new Runnable() {
                    public final void run() {
                        com.cyjh.elfin.floatingwindowprocess.d.a.a((a.C0028a) null);
                    }
                }, 2000);
                return;
            default:
                return;
        }
    }

    @j(a = ThreadMode.MAIN)
    public void onReceiveElfinFloatViewEvent(ElfinFloatViewEvent elfinFloatViewEvent) {
        ad.c(f2041a, "onReceiveElfinFloatViewEvent");
        int type = elfinFloatViewEvent.getType();
        if (type == 4) {
            ad.c(f2041a, "onReceiveSocketMessage --> 服务端命令:脚本设置更新");
            m();
        } else if (type == 10101) {
            ad.c(f2041a, "服务端命令:脚本启动");
            b(true);
        } else if (type == 10103) {
            b(false);
            ad.c(f2041a, "onReceiveSocketMessage --> 服务端命令:脚本停止");
        } else if (type == 10105) {
            ad.c(f2041a, "onReceiveSocketMessage --> 服务端命令:脚本更新");
        } else if (type == 10107) {
            ad.c(f2041a, "onReceiveSocketMessage --> 服务端命令:脚本设置更新");
        }
    }

    public void setControlbarVisiable(int i2) {
        setVisibility(i2 == 1 ? 0 : 8);
    }
}
