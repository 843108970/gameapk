package com.cyjh.mobileanjian.ipc.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.cyjh.mobileanjian.ipc.share.proto.UiMessage;
import com.cyjh.mq.sdk.MqRunner;
import com.cyjh.mqsdk.R;

public final class j extends RelativeLayout {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public WindowManager f2645a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public WindowManager.LayoutParams f2646b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f2647c;
    boolean d = false;
    boolean e = false;
    int f = Color.parseColor("#FFFFFF");
    float g = 0.0f;
    int h = 100;
    String i = "";
    private Context j;
    private g k;
    /* access modifiers changed from: private */
    public Handler l = new Handler();

    public j(Context context, String str, int i2, int i3, int i4, int i5) {
        super(context);
        WindowManager.LayoutParams layoutParams;
        int i6;
        this.j = context;
        this.k = g.a(context);
        this.f2645a = (WindowManager) this.j.getSystemService("window");
        this.f2646b = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams = this.f2646b;
            i6 = 2038;
        } else if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 24) {
            layoutParams = this.f2646b;
            i6 = 2002;
        } else {
            layoutParams = this.f2646b;
            i6 = 2005;
        }
        layoutParams.type = i6;
        this.f2646b.format = 1;
        this.f2646b.flags = 1320;
        this.f2646b.systemUiVisibility = 2;
        this.f2646b.gravity = 51;
        this.f2646b.x = i2;
        this.f2646b.y = i3;
        this.f2646b.alpha = 1.0f;
        this.j.getResources().getDisplayMetrics();
        this.f2647c = (RelativeLayout) LayoutInflater.from(this.j).inflate(R.layout.ui_show_float, (ViewGroup) null);
        this.f2646b.width = i4;
        this.f2646b.height = i5;
        setTag(str);
    }

    private void a(int i2, int i3) {
        WindowManager.LayoutParams layoutParams;
        int i4;
        this.f2645a = (WindowManager) this.j.getSystemService("window");
        this.f2646b = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams = this.f2646b;
            i4 = 2038;
        } else if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 24) {
            layoutParams = this.f2646b;
            i4 = 2002;
        } else {
            layoutParams = this.f2646b;
            i4 = 2005;
        }
        layoutParams.type = i4;
        this.f2646b.format = 1;
        this.f2646b.flags = 1320;
        this.f2646b.systemUiVisibility = 2;
        this.f2646b.gravity = 51;
        this.f2646b.x = i2;
        this.f2646b.y = i3;
        this.f2646b.alpha = 1.0f;
    }

    private void a(boolean z) {
        this.e = z;
    }

    private void b(int i2, int i3) {
        this.j.getResources().getDisplayMetrics();
        this.f2647c = (RelativeLayout) LayoutInflater.from(this.j).inflate(R.layout.ui_show_float, (ViewGroup) null);
        this.f2646b.width = i2;
        this.f2646b.height = i3;
    }

    private void b(String str) {
        this.i = str;
        Bitmap decodeFile = BitmapFactory.decodeFile(this.i);
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2647c.setBackground(new BitmapDrawable(decodeFile));
        }
        this.f2647c.getBackground().setAlpha((this.h * 255) / 100);
    }

    private static void b(String str, UiMessage.ControlEvent.Event_Type event_Type) {
        MqRunner.getInstance().c(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setEvent(UiMessage.ControlEvent.newBuilder().setControlId(str).setType(event_Type).build()).setIsSuccess(true).build().toByteString());
    }

    private int c(int i2) {
        return (int) (((float) i2) * (((float) this.j.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    private boolean f() {
        return this.e;
    }

    private void g() {
        if (this.f2647c != null && this.d) {
            this.f2645a.removeView(this.f2647c);
            this.f2645a.addView(this.f2647c, this.f2646b);
        }
    }

    public final View a(String str) {
        return this.f2647c.findViewWithTag(str);
    }

    public final void a() {
        final String str = (String) getTag();
        if (this.i == null || this.i.length() <= 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadii(new float[]{this.g, this.g, this.g, this.g, this.g, this.g, this.g, this.g});
            try {
                gradientDrawable.setColor(this.f);
            } catch (Exception unused) {
            }
            if (Build.VERSION.SDK_INT >= 16) {
                this.f2647c.setBackground(gradientDrawable);
            }
        } else {
            Bitmap decodeFile = BitmapFactory.decodeFile(this.i);
            if (Build.VERSION.SDK_INT >= 16) {
                this.f2647c.setBackground(new BitmapDrawable(decodeFile));
            }
        }
        this.d = true;
        this.f2647c.setOnTouchListener(new View.OnTouchListener() {

            /* renamed from: a  reason: collision with root package name */
            int f2648a;

            /* renamed from: b  reason: collision with root package name */
            int f2649b;

            /* renamed from: c  reason: collision with root package name */
            int f2650c;
            int d;
            long e;
            long f;
            Runnable g = new Runnable() {
                public final void run() {
                    MqRunner.getInstance().c(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setEvent(UiMessage.ControlEvent.newBuilder().setControlId(str).setType(UiMessage.ControlEvent.Event_Type.ON_TOUCH).build()).setIsSuccess(true).build().toByteString());
                }
            };

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                UiMessage.ControlEvent.Event_Type event_Type;
                String str;
                switch (motionEvent.getAction()) {
                    case 0:
                        this.f2648a = (int) motionEvent.getRawX();
                        this.f2649b = (int) motionEvent.getRawY();
                        this.f2650c = j.this.f2646b.x;
                        this.d = j.this.f2646b.y;
                        this.e = System.currentTimeMillis();
                        this.f = this.e;
                        MqRunner.getInstance().c(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setEvent(UiMessage.ControlEvent.newBuilder().setControlId(str).setType(UiMessage.ControlEvent.Event_Type.ON_TOUCH_DOWN).build()).setIsSuccess(true).build().toByteString());
                        new StringBuilder("ACTION_DOWN ").append(System.currentTimeMillis());
                        j.this.l.postDelayed(this.g, 501);
                        return true;
                    case 1:
                        if (this.g != null) {
                            j.this.l.removeCallbacks(this.g);
                        }
                        new StringBuilder("ACTION_UP ").append(System.currentTimeMillis());
                        if (Math.abs(motionEvent.getRawX() - ((float) this.f2648a)) >= 30.0f || Math.abs(motionEvent.getRawY() - ((float) this.f2649b)) >= 30.0f || System.currentTimeMillis() - this.e >= 500) {
                            str = str;
                            event_Type = UiMessage.ControlEvent.Event_Type.ON_TOUCH_UP;
                        } else {
                            str = str;
                            event_Type = UiMessage.ControlEvent.Event_Type.ON_CLICK;
                        }
                        MqRunner.getInstance().c(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setEvent(UiMessage.ControlEvent.newBuilder().setControlId(str).setType(event_Type).build()).setIsSuccess(true).build().toByteString());
                        return true;
                    case 2:
                        new StringBuilder("ACTION_MOVE ").append(System.currentTimeMillis());
                        if (j.this.e) {
                            int rawX = ((int) motionEvent.getRawX()) - this.f2648a;
                            int rawY = ((int) motionEvent.getRawY()) - this.f2649b;
                            j.this.f2646b.x = this.f2650c + rawX;
                            j.this.f2646b.y = this.d + rawY;
                            j.this.f2645a.updateViewLayout(j.this.f2647c, j.this.f2646b);
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        if ((Math.abs(motionEvent.getRawX() - ((float) this.f2648a)) == 5.0f && Math.abs(motionEvent.getRawY() - ((float) this.f2649b)) == 5.0f) || currentTimeMillis - this.f <= 50) {
                            return true;
                        }
                        MqRunner.getInstance().c(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setEvent(UiMessage.ControlEvent.newBuilder().setControlId(str).setType(UiMessage.ControlEvent.Event_Type.ON_TOUCH_MOVE).build()).setIsSuccess(true).build().toByteString());
                        this.f = currentTimeMillis;
                        return true;
                    default:
                        return true;
                }
            }
        });
        this.f2645a.addView(this.f2647c, this.f2646b);
        this.f2647c.getBackground().setAlpha((this.h * 255) / 100);
    }

    public final void a(int i2) {
        this.g = (float) i2;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(new float[]{this.g, this.g, this.g, this.g, this.g, this.g, this.g, this.g});
        try {
            gradientDrawable.setColor(this.f);
        } catch (Exception unused) {
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2647c.setBackground(gradientDrawable);
        }
        this.f2647c.getBackground().setAlpha((this.h * 255) / 100);
    }

    public final void a(View view) {
        final String str = (String) view.getTag();
        if (!(view instanceof Button)) {
            view.setOnTouchListener(new View.OnTouchListener() {

                /* renamed from: a  reason: collision with root package name */
                int f2652a;

                /* renamed from: b  reason: collision with root package name */
                int f2653b;

                /* renamed from: c  reason: collision with root package name */
                int f2654c;
                int d;
                long e;
                long f;
                Runnable g = new Runnable() {
                    public final void run() {
                        MqRunner.getInstance().c(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setEvent(UiMessage.ControlEvent.newBuilder().setControlId(str).setType(UiMessage.ControlEvent.Event_Type.ON_TOUCH).build()).setIsSuccess(true).build().toByteString());
                    }
                };

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    UiMessage.ControlEvent.Event_Type event_Type;
                    String str;
                    switch (motionEvent.getAction()) {
                        case 0:
                            this.f2652a = (int) motionEvent.getRawX();
                            this.f2653b = (int) motionEvent.getRawY();
                            this.f2654c = j.this.f2646b.x;
                            this.d = j.this.f2646b.y;
                            this.e = System.currentTimeMillis();
                            this.f = this.e;
                            MqRunner.getInstance().c(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setEvent(UiMessage.ControlEvent.newBuilder().setControlId(str).setType(UiMessage.ControlEvent.Event_Type.ON_TOUCH_DOWN).build()).setIsSuccess(true).build().toByteString());
                            new StringBuilder("ACTION_DOWN ").append(System.currentTimeMillis());
                            j.this.l.postDelayed(this.g, 501);
                            return true;
                        case 1:
                            j.this.l.removeCallbacks(this.g);
                            new StringBuilder("ACTION_UP ").append(System.currentTimeMillis());
                            if (Math.abs(motionEvent.getRawX() - ((float) this.f2652a)) >= 30.0f || Math.abs(motionEvent.getRawY() - ((float) this.f2653b)) >= 30.0f || System.currentTimeMillis() - this.e >= 500) {
                                str = str;
                                event_Type = UiMessage.ControlEvent.Event_Type.ON_TOUCH_UP;
                            } else {
                                str = str;
                                event_Type = UiMessage.ControlEvent.Event_Type.ON_CLICK;
                            }
                            MqRunner.getInstance().c(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setEvent(UiMessage.ControlEvent.newBuilder().setControlId(str).setType(event_Type).build()).setIsSuccess(true).build().toByteString());
                            return true;
                        case 2:
                            new StringBuilder("ACTION_MOVE ").append(System.currentTimeMillis());
                            if (j.this.e) {
                                int rawX = ((int) motionEvent.getRawX()) - this.f2652a;
                                int rawY = ((int) motionEvent.getRawY()) - this.f2653b;
                                j.this.f2646b.x = this.f2654c + rawX;
                                j.this.f2646b.y = this.d + rawY;
                                j.this.f2645a.updateViewLayout(j.this.f2647c, j.this.f2646b);
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - this.e > 501) {
                                MqRunner.getInstance().c(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setEvent(UiMessage.ControlEvent.newBuilder().setControlId(str).setType(UiMessage.ControlEvent.Event_Type.ON_TOUCH).build()).setIsSuccess(true).build().toByteString());
                            }
                            if ((Math.abs(motionEvent.getRawX() - ((float) this.f2652a)) == 5.0f && Math.abs(motionEvent.getRawY() - ((float) this.f2653b)) == 5.0f) || currentTimeMillis - this.f <= 50) {
                                return true;
                            }
                            MqRunner.getInstance().c(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setEvent(UiMessage.ControlEvent.newBuilder().setControlId(str).setType(UiMessage.ControlEvent.Event_Type.ON_TOUCH_MOVE).build()).setIsSuccess(true).build().toByteString());
                            this.f = currentTimeMillis;
                            return true;
                        default:
                            return true;
                    }
                }
            });
        }
        this.f2647c.addView(view);
    }

    public final void b() {
        this.d = false;
        try {
            this.f2645a.removeView(this.f2647c);
        } catch (Exception unused) {
        }
    }

    public final void b(int i2) {
        this.f = i2;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(new float[]{this.g, this.g, this.g, this.g, this.g, this.g, this.g, this.g});
        try {
            gradientDrawable.setColor(this.f);
        } catch (Exception unused) {
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2647c.setBackground(gradientDrawable);
        }
        this.f2647c.getBackground().setAlpha((this.h * 255) / 100);
    }

    public final void c() {
        if (this.d) {
            b();
        }
    }

    public final boolean d() {
        return this.d;
    }

    public final void e() {
        if (this.f2647c != null && this.d) {
            this.f2645a.updateViewLayout(this.f2647c, this.f2646b);
        }
    }

    public final int getOpacity() {
        return this.h;
    }

    public final WindowManager.LayoutParams getParams() {
        return this.f2646b;
    }

    public final void setFloatHeight(int i2) {
        WindowManager.LayoutParams params = getParams();
        StringBuilder sb = new StringBuilder("setFloatHeight wLayoutParams[ ");
        sb.append(params.width);
        sb.append(",");
        sb.append(params.height);
        sb.append("]");
        this.f2646b.width = params.width;
        this.f2646b.height = i2;
        if (this.d) {
            this.f2645a.updateViewLayout(this.f2647c, this.f2646b);
        }
    }

    public final void setFloatLeft(int i2) {
        WindowManager.LayoutParams params = getParams();
        StringBuilder sb = new StringBuilder("setFloatLeft wLayoutParams[ ");
        sb.append(params.x);
        sb.append(",");
        sb.append(params.y);
        sb.append("]");
        params.x = i2;
        if (this.d) {
            this.f2645a.updateViewLayout(this.f2647c, params);
        }
    }

    public final void setFloatTop(int i2) {
        WindowManager.LayoutParams params = getParams();
        StringBuilder sb = new StringBuilder("setFloatTop wLayoutParams[ ");
        sb.append(params.x);
        sb.append(",");
        sb.append(params.y);
        sb.append("]");
        params.y = i2;
        if (this.d) {
            this.f2645a.updateViewLayout(this.f2647c, params);
        }
    }

    public final void setFloatWidth(int i2) {
        WindowManager.LayoutParams params = getParams();
        StringBuilder sb = new StringBuilder("setFloatWidth wLayoutParams[ ");
        sb.append(params.width);
        sb.append(",");
        sb.append(params.height);
        sb.append("]");
        this.f2646b.width = i2;
        this.f2646b.height = params.height;
        if (this.d) {
            this.f2645a.updateViewLayout(this.f2647c, this.f2646b);
        }
    }

    public final void setOpacity(int i2) {
        this.f2647c.getBackground().setAlpha((i2 * 255) / 100);
        this.h = i2;
    }
}
