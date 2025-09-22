package com.cyjh.mobileanjian.ipc.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import com.cyjh.event.c;
import com.cyjh.mobileanjian.ipc.share.proto.UiMessage;
import com.cyjh.mobileanjian.ipc.view.ExToast;
import com.cyjh.mqsdk.R;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class i implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private static final String g = "^#*([0-9A-Fa-f]{6})|([0-9A-Fa-f]{3})";
    private static final int h = 32;

    /* renamed from: a  reason: collision with root package name */
    public k[] f2634a = new k[32];

    /* renamed from: b  reason: collision with root package name */
    public int f2635b = 0;

    /* renamed from: c  reason: collision with root package name */
    public g f2636c;
    public HashMap<String, Integer> d = new HashMap<>();
    public HashMap[] e = new HashMap[32];
    public int f = 1;
    private Context i;

    private class a implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        private String f2644b;

        public a(String str) {
            this.f2644b = str;
        }

        private String a() {
            return this.f2644b;
        }

        public final void afterTextChanged(Editable editable) {
            c.b(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setEvent(UiMessage.ControlEvent.newBuilder().setControlId(this.f2644b).setType(UiMessage.ControlEvent.Event_Type.ON_CHANGE).build()).setIsSuccess(true).build().toByteString());
            i.this.f2634a[i.this.f2635b].b();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public i(Context context) {
        this.i = context;
        this.f2636c = g.a(context);
    }

    private void a(final String str, int i2, int i3) {
        this.f2635b++;
        this.f2634a[this.f2635b] = this.f2636c.a(str, i2, i3);
        this.d.put(str, Integer.valueOf(this.f2635b));
        this.e[this.f2635b] = new HashMap();
        this.f2634a[this.f2635b].f2657b = new View.OnClickListener() {
            public final void onClick(View view) {
                c.b(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setIsSuccess(true).setEvent(UiMessage.ControlEvent.newBuilder().setControlId(r6).setType(UiMessage.ControlEvent.Event_Type.ON_CLOSE_CONTINUE).build()).build().toByteString());
            }
        };
        this.f2634a[this.f2635b].f2656a = new View.OnClickListener() {
            public final void onClick(View view) {
                UiMessage.UiToCommand build = UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setEvent(UiMessage.ControlEvent.newBuilder().setControlId(r6).setType(UiMessage.ControlEvent.Event_Type.ON_CLOSE_EXIT).build()).setIsSuccess(true).build();
                c.b(build.toByteString());
                new StringBuilder("exit event: ").append(build);
            }
        };
    }

    public static void a(boolean z) {
        c.a(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.RSP_MSG).setIsSuccess(z).build().toByteString());
    }

    private boolean a(String str, String str2) {
        if (this.d.get(str) == null) {
            a(R.string.ui_show_not_found_ui, str);
            return false;
        }
        this.f2634a[this.d.get(str).intValue()].a(str2);
        return true;
    }

    public static void c(String str) {
        c.b(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setIsSuccess(true).setEvent(UiMessage.ControlEvent.newBuilder().setControlId(str).setType(UiMessage.ControlEvent.Event_Type.ON_CLOSE_CONTINUE).build()).build().toByteString());
    }

    private void d() {
        c();
        this.f2635b = 0;
        this.f = 1;
        for (int i2 = 0; i2 < 32; i2++) {
            this.f2634a[i2] = null;
            if (this.e[i2] != null) {
                this.e[i2].clear();
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x075b, code lost:
        r1.a(r0, r9.getParentId());
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(com.cyjh.mobileanjian.ipc.share.proto.UiMessage.CommandToUi r9) {
        /*
            r8 = this;
            java.lang.String r6 = r9.getControlId()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$CommandToUi$Command_Type r0 = r9.getCommand()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "command: "
            r1.<init>(r2)
            r1.append(r9)
            int[] r1 = com.cyjh.mobileanjian.ipc.ui.i.AnonymousClass3.f2641a
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 2
            r2 = 3
            r7 = 1
            r3 = 0
            switch(r0) {
                case 1: goto L_0x0976;
                case 2: goto L_0x096e;
                case 3: goto L_0x0924;
                case 4: goto L_0x08b1;
                case 5: goto L_0x0880;
                case 6: goto L_0x087a;
                case 7: goto L_0x0875;
                case 8: goto L_0x0853;
                case 9: goto L_0x0826;
                case 10: goto L_0x07c9;
                case 11: goto L_0x0764;
                case 12: goto L_0x0731;
                case 13: goto L_0x0702;
                case 14: goto L_0x06c3;
                case 15: goto L_0x0690;
                case 16: goto L_0x065b;
                case 17: goto L_0x0626;
                case 18: goto L_0x05f1;
                case 19: goto L_0x05c1;
                case 20: goto L_0x0585;
                case 21: goto L_0x056a;
                case 22: goto L_0x0546;
                case 23: goto L_0x0540;
                case 24: goto L_0x0540;
                case 25: goto L_0x0540;
                case 26: goto L_0x0540;
                case 27: goto L_0x0540;
                case 28: goto L_0x0540;
                case 29: goto L_0x0540;
                case 30: goto L_0x0540;
                case 31: goto L_0x0540;
                case 32: goto L_0x0540;
                case 33: goto L_0x0540;
                case 34: goto L_0x050a;
                case 35: goto L_0x0506;
                case 36: goto L_0x0502;
                case 37: goto L_0x04c0;
                case 38: goto L_0x03d4;
                case 39: goto L_0x0313;
                case 40: goto L_0x027a;
                case 41: goto L_0x0276;
                case 42: goto L_0x020e;
                case 43: goto L_0x01ae;
                case 44: goto L_0x00d3;
                case 45: goto L_0x0987;
                case 46: goto L_0x0096;
                case 47: goto L_0x0987;
                case 48: goto L_0x0023;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x0987
        L_0x0023:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r8.f2634a
            int r1 = r8.f2635b
            r0 = r0[r1]
            if (r0 != 0) goto L_0x002f
            a((boolean) r3)
            return
        L_0x002f:
            java.lang.String r0 = r9.getControlId()
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2634a
            int r2 = r8.f2635b
            r1 = r1[r2]
            android.view.View r0 = r1.b((java.lang.String) r0)
            if (r0 != 0) goto L_0x0043
            a((boolean) r3)
            return
        L_0x0043:
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$Padding_Var r9 = r9.getPadding()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "padding: "
            r1.<init>(r2)
            int r2 = r9.getLeft()
            r1.append(r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "padding: "
            r1.<init>(r2)
            int r2 = r9.getTop()
            r1.append(r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "padding: "
            r1.<init>(r2)
            int r2 = r9.getRight()
            r1.append(r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "padding: "
            r1.<init>(r2)
            int r2 = r9.getBottom()
            r1.append(r2)
            int r1 = r9.getLeft()
            int r2 = r9.getTop()
            int r3 = r9.getRight()
            int r9 = r9.getBottom()
            r0.setPadding(r1, r2, r3, r9)
            a((boolean) r7)
            return
        L_0x0096:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r8.f2634a
            int r1 = r8.f2635b
            r0 = r0[r1]
            if (r0 != 0) goto L_0x00a2
            a((boolean) r3)
            return
        L_0x00a2:
            java.lang.String r0 = r9.getControlId()
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2634a
            int r2 = r8.f2635b
            r1 = r1[r2]
            android.view.View r0 = r1.b((java.lang.String) r0)
            if (r0 != 0) goto L_0x00b6
            a((boolean) r3)
            return
        L_0x00b6:
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r1 = (android.widget.LinearLayout.LayoutParams) r1
            int r9 = r9.getAlignType()
            r1.gravity = r9
            r0.setLayoutParams(r1)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "set gravity ok; "
            r9.<init>(r0)
            r9.append(r1)
            a((boolean) r7)
            return
        L_0x00d3:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r8.f2634a
            int r4 = r8.f2635b
            r0 = r0[r4]
            if (r0 != 0) goto L_0x00df
            a((boolean) r3)
            return
        L_0x00df:
            java.lang.String r0 = r9.getControlId()
            java.util.HashMap[] r4 = r8.e
            int r5 = r8.f2635b
            r4 = r4[r5]
            java.lang.Object r4 = r4.get(r0)
            if (r4 != 0) goto L_0x00f3
            a((boolean) r3)
            return
        L_0x00f3:
            int[] r4 = com.cyjh.mobileanjian.ipc.ui.i.AnonymousClass3.f2642b
            java.util.HashMap[] r5 = r8.e
            int r6 = r8.f2635b
            r5 = r5[r6]
            java.lang.Object r5 = r5.get(r0)
            com.cyjh.mobileanjian.ipc.ui.m r5 = (com.cyjh.mobileanjian.ipc.ui.m) r5
            int r5 = r5.ordinal()
            r4 = r4[r5]
            switch(r4) {
                case 1: goto L_0x0140;
                case 2: goto L_0x0140;
                case 3: goto L_0x0140;
                case 4: goto L_0x012f;
                case 5: goto L_0x010e;
                default: goto L_0x010a;
            }
        L_0x010a:
            a((boolean) r3)
            return
        L_0x010e:
            com.cyjh.mobileanjian.ipc.ui.k[] r4 = r8.f2634a
            int r5 = r8.f2635b
            r4 = r4[r5]
            android.view.View r4 = r4.b((java.lang.String) r0)
            android.widget.RadioGroup r4 = (android.widget.RadioGroup) r4
            int r9 = r9.getItemIndex()
            android.view.View r9 = r4.findViewById(r9)
            android.widget.RadioButton r9 = (android.widget.RadioButton) r9
            if (r9 != 0) goto L_0x012a
            a((boolean) r3)
            return
        L_0x012a:
            android.text.TextPaint r9 = r9.getPaint()
            goto L_0x0150
        L_0x012f:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r8.f2634a
            int r4 = r8.f2635b
            r9 = r9[r4]
            android.view.View r9 = r9.b((java.lang.String) r0)
            android.widget.CheckBox r9 = (android.widget.CheckBox) r9
            android.text.TextPaint r9 = r9.getPaint()
            goto L_0x0150
        L_0x0140:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r8.f2634a
            int r4 = r8.f2635b
            r9 = r9[r4]
            android.view.View r9 = r9.b((java.lang.String) r0)
            android.widget.TextView r9 = (android.widget.TextView) r9
            android.text.TextPaint r9 = r9.getPaint()
        L_0x0150:
            int r9 = r9.getColor()
            java.lang.String r4 = "%02X%02X%02X"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            int r5 = android.graphics.Color.blue(r9)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r2[r3] = r5
            int r3 = android.graphics.Color.green(r9)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2[r7] = r3
            int r9 = android.graphics.Color.red(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r2[r1] = r9
            java.lang.String r9 = java.lang.String.format(r4, r2)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = r1.setControlId(r0)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.STRING
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = r0.setType(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r0.setStringValue(r9)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar r9 = r9.build()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.RSP_MSG
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r7)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r9 = r0.addVarTable((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar) r9)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r9 = r9.build()
            com.google.protobuf.ByteString r9 = r9.toByteString()
            com.cyjh.event.c.a(r9)
            return
        L_0x01ae:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r8.f2634a
            int r0 = r8.f2635b
            r9 = r9[r0]
            if (r9 != 0) goto L_0x01ba
            a((boolean) r3)
            return
        L_0x01ba:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r8.f2634a
            int r0 = r8.f2635b
            r9 = r9[r0]
            android.view.View r9 = r9.b((java.lang.String) r6)
            if (r9 != 0) goto L_0x01ca
            a((boolean) r3)
            return
        L_0x01ca:
            int r9 = r9.getVisibility()
            if (r9 == 0) goto L_0x01d7
            r0 = 4
            if (r9 == r0) goto L_0x01da
            r0 = 8
            if (r9 == r0) goto L_0x01d9
        L_0x01d7:
            r1 = 1
            goto L_0x01da
        L_0x01d9:
            r1 = 3
        L_0x01da:
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r9.setControlId(r6)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.INT
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r9.setType(r0)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r9.setIntValue(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar r9 = r9.build()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.RSP_MSG
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r7)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r9 = r0.addVarTable((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar) r9)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r9 = r9.build()
            com.google.protobuf.ByteString r9 = r9.toByteString()
            com.cyjh.event.c.a(r9)
            return
        L_0x020e:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r8.f2634a
            int r0 = r8.f2635b
            r9 = r9[r0]
            if (r9 != 0) goto L_0x021a
            a((boolean) r3)
            return
        L_0x021a:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r8.f2634a
            int r0 = r8.f2635b
            r9 = r9[r0]
            android.view.View r9 = r9.b((java.lang.String) r6)
            if (r9 != 0) goto L_0x022a
            a((boolean) r3)
            return
        L_0x022a:
            boolean r0 = r9.isEnabled()
            java.util.HashMap[] r1 = r8.e
            int r2 = r8.f2635b
            r1 = r1[r2]
            java.lang.Object r1 = r1.get(r6)
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.EDIT_TEXT
            if (r1 != r2) goto L_0x0242
            android.widget.EditText r9 = (android.widget.EditText) r9
            boolean r0 = r9.isFocusable()
        L_0x0242:
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r9.setControlId(r6)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.BOOL
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r9.setType(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r9.setBoolValue(r0)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar r9 = r9.build()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.RSP_MSG
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r7)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r9 = r0.addVarTable((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar) r9)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r9 = r9.build()
            com.google.protobuf.ByteString r9 = r9.toByteString()
            com.cyjh.event.c.a(r9)
            return
        L_0x0276:
            r8.e((java.lang.String) r6)
            return
        L_0x027a:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r8.f2634a
            int r1 = r8.f2635b
            r0 = r0[r1]
            if (r0 != 0) goto L_0x0286
            a((boolean) r3)
            return
        L_0x0286:
            java.lang.String r0 = r9.getControlId()
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2634a
            int r2 = r8.f2635b
            r1 = r1[r2]
            android.view.View r1 = r1.b((java.lang.String) r0)
            if (r1 != 0) goto L_0x029a
            a((boolean) r3)
            return
        L_0x029a:
            java.lang.String r9 = r9.getColor()
            java.lang.String r2 = "^#*([0-9A-Fa-f]{6})|([0-9A-Fa-f]{3})"
            boolean r2 = r9.matches(r2)
            if (r2 != 0) goto L_0x02b1
            int r9 = com.cyjh.mqsdk.R.string.ui_show_invalid_color_value
            java.lang.Object[] r0 = new java.lang.Object[r3]
            r8.a((int) r9, (java.lang.Object[]) r0)
            a((boolean) r3)
            return
        L_0x02b1:
            java.lang.String r2 = "#"
            boolean r2 = r9.startsWith(r2)
            if (r2 != 0) goto L_0x02c7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "#"
            r2.<init>(r3)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
        L_0x02c7:
            int r9 = android.graphics.Color.parseColor(r9)
            int r9 = com.cyjh.mobileanjian.ipc.utils.c.a(r9)
            java.util.HashMap[] r2 = r8.e
            int r3 = r8.f2635b
            r2 = r2[r3]
            java.lang.Object r2 = r2.get(r0)
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.BUTTON
            if (r2 != r3) goto L_0x02fe
            android.graphics.drawable.GradientDrawable r0 = new android.graphics.drawable.GradientDrawable
            r0.<init>()
            r0.setColor(r9)
            int r9 = r8.b()
            float r9 = (float) r9
            r0.setCornerRadius(r9)
            int r9 = android.os.Build.VERSION.SDK_INT
            r2 = 16
            if (r9 < r2) goto L_0x02f7
            r1.setBackground(r0)
            goto L_0x02fa
        L_0x02f7:
            r1.setBackgroundDrawable(r0)
        L_0x02fa:
            a((boolean) r7)
            return
        L_0x02fe:
            java.util.HashMap[] r2 = r8.e
            int r3 = r8.f2635b
            r2 = r2[r3]
            java.lang.Object r0 = r2.get(r0)
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.SPINNER
            if (r0 == r2) goto L_0x030f
            r1.setBackgroundColor(r9)
        L_0x030f:
            a((boolean) r7)
            return
        L_0x0313:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r8.f2634a
            int r1 = r8.f2635b
            r0 = r0[r1]
            if (r0 != 0) goto L_0x031f
            a((boolean) r3)
            return
        L_0x031f:
            java.lang.String r0 = r9.getControlId()
            java.lang.String r1 = r9.getColor()
            java.lang.String r2 = "^#*([0-9A-Fa-f]{6})|([0-9A-Fa-f]{3})"
            boolean r2 = r1.matches(r2)
            if (r2 != 0) goto L_0x033a
            int r9 = com.cyjh.mqsdk.R.string.ui_show_invalid_color_value
            java.lang.Object[] r0 = new java.lang.Object[r3]
            r8.a((int) r9, (java.lang.Object[]) r0)
            a((boolean) r3)
            return
        L_0x033a:
            java.lang.String r2 = "#"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x0350
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "#"
            r2.<init>(r4)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
        L_0x0350:
            int r1 = android.graphics.Color.parseColor(r1)
            int r1 = com.cyjh.mobileanjian.ipc.utils.c.a(r1)
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r8.d
            java.lang.Object r2 = r2.get(r0)
            if (r2 == 0) goto L_0x0374
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r8.f2634a
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r8.d
            java.lang.Object r0 = r2.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r9 = r9[r0]
            r9.a((int) r1)
            goto L_0x03d0
        L_0x0374:
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r8.f2634a
            int r4 = r8.f2635b
            r2 = r2[r4]
            android.view.View r2 = r2.b((java.lang.String) r0)
            if (r2 != 0) goto L_0x0384
            a((boolean) r3)
            return
        L_0x0384:
            int[] r4 = com.cyjh.mobileanjian.ipc.ui.i.AnonymousClass3.f2642b
            java.util.HashMap[] r5 = r8.e
            int r6 = r8.f2635b
            r5 = r5[r6]
            java.lang.Object r0 = r5.get(r0)
            com.cyjh.mobileanjian.ipc.ui.m r0 = (com.cyjh.mobileanjian.ipc.ui.m) r0
            int r0 = r0.ordinal()
            r0 = r4[r0]
            switch(r0) {
                case 1: goto L_0x03cb;
                case 2: goto L_0x03cb;
                case 3: goto L_0x03cb;
                case 4: goto L_0x03c5;
                case 5: goto L_0x03af;
                case 6: goto L_0x039f;
                default: goto L_0x039b;
            }
        L_0x039b:
            a((boolean) r3)
            return
        L_0x039f:
            android.widget.Spinner r2 = (android.widget.Spinner) r2
            int r9 = r9.getItemIndex()
            int r0 = r2.getCount()
            if (r9 < r0) goto L_0x03d0
            a((boolean) r3)
            return
        L_0x03af:
            android.widget.RadioGroup r2 = (android.widget.RadioGroup) r2
            int r9 = r9.getItemIndex()
            android.view.View r9 = r2.findViewById(r9)
            android.widget.RadioButton r9 = (android.widget.RadioButton) r9
            if (r9 != 0) goto L_0x03c1
            a((boolean) r3)
            return
        L_0x03c1:
            r9.setTextColor(r1)
            goto L_0x03d0
        L_0x03c5:
            android.widget.CheckBox r2 = (android.widget.CheckBox) r2
            r2.setTextColor(r1)
            goto L_0x03d0
        L_0x03cb:
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setTextColor(r1)
        L_0x03d0:
            a((boolean) r7)
            return
        L_0x03d4:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r8.f2634a
            int r1 = r8.f2635b
            r0 = r0[r1]
            if (r0 != 0) goto L_0x03e0
            a((boolean) r3)
            return
        L_0x03e0:
            java.lang.String r0 = r9.getControlId()
            java.util.HashMap[] r1 = r8.e
            int r2 = r8.f2635b
            r1 = r1[r2]
            java.lang.Object r1 = r1.get(r0)
            if (r1 != 0) goto L_0x03f4
            a((boolean) r3)
            return
        L_0x03f4:
            int[] r1 = com.cyjh.mobileanjian.ipc.ui.i.AnonymousClass3.f2642b
            java.util.HashMap[] r2 = r8.e
            int r4 = r8.f2635b
            r2 = r2[r4]
            java.lang.Object r2 = r2.get(r0)
            com.cyjh.mobileanjian.ipc.ui.m r2 = (com.cyjh.mobileanjian.ipc.ui.m) r2
            int r2 = r2.ordinal()
            r1 = r1[r2]
            switch(r1) {
                case 1: goto L_0x0478;
                case 2: goto L_0x0478;
                case 3: goto L_0x0478;
                case 4: goto L_0x0467;
                case 5: goto L_0x0446;
                case 6: goto L_0x040f;
                default: goto L_0x040b;
            }
        L_0x040b:
            a((boolean) r3)
            return
        L_0x040f:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2634a
            int r2 = r8.f2635b
            r1 = r1[r2]
            android.view.View r1 = r1.b((java.lang.String) r0)
            android.widget.Spinner r1 = (android.widget.Spinner) r1
            int r2 = r9.getItemIndex()
            int r4 = r1.getCount()
            if (r2 < r4) goto L_0x0429
            a((boolean) r3)
            return
        L_0x0429:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Spinner Get pos: "
            r2.<init>(r3)
            int r3 = r9.getItemIndex()
            java.lang.Object r3 = r1.getItemAtPosition(r3)
            r2.append(r3)
            int r9 = r9.getItemIndex()
            java.lang.Object r9 = r1.getItemAtPosition(r9)
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x048c
        L_0x0446:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2634a
            int r2 = r8.f2635b
            r1 = r1[r2]
            android.view.View r1 = r1.b((java.lang.String) r0)
            android.widget.RadioGroup r1 = (android.widget.RadioGroup) r1
            int r9 = r9.getItemIndex()
            android.view.View r9 = r1.findViewById(r9)
            android.widget.RadioButton r9 = (android.widget.RadioButton) r9
            if (r9 != 0) goto L_0x0462
            a((boolean) r3)
            return
        L_0x0462:
            java.lang.CharSequence r9 = r9.getText()
            goto L_0x0488
        L_0x0467:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r8.f2634a
            int r1 = r8.f2635b
            r9 = r9[r1]
            android.view.View r9 = r9.b((java.lang.String) r0)
            android.widget.CheckBox r9 = (android.widget.CheckBox) r9
            java.lang.CharSequence r9 = r9.getText()
            goto L_0x0488
        L_0x0478:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r8.f2634a
            int r1 = r8.f2635b
            r9 = r9[r1]
            android.view.View r9 = r9.b((java.lang.String) r0)
            android.widget.TextView r9 = (android.widget.TextView) r9
            java.lang.CharSequence r9 = r9.getText()
        L_0x0488:
            java.lang.String r9 = r9.toString()
        L_0x048c:
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = r1.setControlId(r0)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.STRING
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = r0.setType(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r0.setStringValue(r9)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar r9 = r9.build()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.RSP_MSG
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r7)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r9 = r0.addVarTable((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar) r9)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r9 = r9.build()
            com.google.protobuf.ByteString r9 = r9.toByteString()
            com.cyjh.event.c.a(r9)
            return
        L_0x04c0:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r8.f2634a
            int r1 = r8.f2635b
            r0 = r0[r1]
            if (r0 != 0) goto L_0x04cc
            a((boolean) r3)
            return
        L_0x04cc:
            java.lang.String r0 = r9.getControlId()
            r9.getText()
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2634a
            int r2 = r8.f2635b
            r1 = r1[r2]
            android.view.View r1 = r1.b((java.lang.String) r0)
            if (r1 != 0) goto L_0x04e3
            a((boolean) r3)
            return
        L_0x04e3:
            java.util.HashMap[] r2 = r8.e
            int r4 = r8.f2635b
            r2 = r2[r4]
            java.lang.Object r0 = r2.get(r0)
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.EDIT_TEXT
            if (r0 == r2) goto L_0x04f5
            a((boolean) r3)
            return
        L_0x04f5:
            android.widget.EditText r1 = (android.widget.EditText) r1
            int r9 = r9.getEditInputType()
            r1.setInputType(r9)
            a((boolean) r7)
            return
        L_0x0502:
            r8.b((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.CommandToUi) r9)
            return
        L_0x0506:
            r8.c((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.CommandToUi) r9)
            return
        L_0x050a:
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r8.d
            java.lang.Object r9 = r9.get(r6)
            if (r9 == 0) goto L_0x0517
            a((boolean) r7)
            goto L_0x0987
        L_0x0517:
            java.util.HashMap[] r9 = r8.e
            int r0 = r8.f2635b
            r9 = r9[r0]
            java.lang.Object r9 = r9.get(r6)
            if (r9 != 0) goto L_0x0528
            a((boolean) r3)
            goto L_0x0987
        L_0x0528:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r8.f2634a
            int r0 = r8.f2635b
            r9 = r9[r0]
            android.view.View r9 = r9.b((java.lang.String) r6)
            android.view.ViewGroup$LayoutParams r0 = r9.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            r1 = -1
            r0.width = r1
            r9.setLayoutParams(r0)
            goto L_0x0987
        L_0x0540:
            boolean r7 = r8.a((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.CommandToUi) r9)
            goto L_0x0987
        L_0x0546:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r8.f2634a
            int r1 = r8.f2635b
            r0 = r0[r1]
            if (r0 == 0) goto L_0x0987
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r8.f2634a
            int r1 = r8.f2635b
            r0 = r0[r1]
            int r1 = r8.a()
            java.lang.String r2 = r9.getControlId()
            java.lang.String r3 = r9.getParentId()
            java.lang.String r9 = r9.getText()
            boolean r7 = r0.a((int) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r9)
            goto L_0x0987
        L_0x056a:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r8.f2634a
            int r1 = r8.f2635b
            r0 = r0[r1]
            if (r0 == 0) goto L_0x0987
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r8.f2634a
            int r1 = r8.f2635b
            r0 = r0[r1]
            java.lang.String r1 = r9.getControlId()
            int r9 = r9.getHeight()
            r0.a((java.lang.String) r1, (int) r9)
            goto L_0x0987
        L_0x0585:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r8.f2634a
            int r1 = r8.f2635b
            r0 = r0[r1]
            if (r0 == 0) goto L_0x0987
            com.cyjh.mobileanjian.ipc.ui.g r0 = r8.f2636c
            r8.a()
            java.util.List r1 = r9.getItemTextList()
            int r2 = r9.getDefaultItemIndex()
            r9.getWidth()
            r9.getHeight()
            android.widget.Spinner r0 = r0.a((java.lang.String) r6, (java.util.List<java.lang.String>) r1, (int) r2)
            java.util.HashMap[] r1 = r8.e
            int r2 = r8.f2635b
            r1 = r1[r2]
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.SPINNER
            r1.put(r6, r2)
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2634a
            int r2 = r8.f2635b
            r1 = r1[r2]
            java.lang.String r9 = r9.getParentId()
            r1.a((android.view.View) r0, (java.lang.String) r9)
            r0.setOnItemSelectedListener(r8)
            goto L_0x0987
        L_0x05c1:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r8.f2634a
            int r1 = r8.f2635b
            r0 = r0[r1]
            if (r0 == 0) goto L_0x0987
            com.cyjh.mobileanjian.ipc.ui.g r0 = r8.f2636c
            r8.a()
            int r1 = r9.getWidth()
            int r2 = r9.getHeight()
            java.lang.String r3 = r9.getUrl()
            android.webkit.WebView r0 = r0.a((java.lang.String) r6, (int) r1, (int) r2, (java.lang.String) r3)
            java.util.HashMap[] r1 = r8.e
            int r2 = r8.f2635b
            r1 = r1[r2]
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.WEB_VIEW
            r1.put(r6, r2)
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2634a
            int r2 = r8.f2635b
            r1 = r1[r2]
            goto L_0x075b
        L_0x05f1:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r8.f2634a
            int r1 = r8.f2635b
            r0 = r0[r1]
            if (r0 == 0) goto L_0x0987
            com.cyjh.mobileanjian.ipc.ui.g r0 = r8.f2636c
            int r1 = r8.a()
            int r3 = r9.getWidth()
            int r4 = r9.getHeight()
            java.lang.String r5 = r9.getPath()
            r2 = r6
            android.widget.ImageView r0 = r0.a((int) r1, (java.lang.String) r2, (int) r3, (int) r4, (java.lang.String) r5)
            java.util.HashMap[] r1 = r8.e
            int r2 = r8.f2635b
            r1 = r1[r2]
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.IMAGE_VIEW
            r1.put(r6, r2)
            r0.setOnClickListener(r8)
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2634a
            int r2 = r8.f2635b
            r1 = r1[r2]
            goto L_0x075b
        L_0x0626:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r8.f2634a
            int r1 = r8.f2635b
            r0 = r0[r1]
            if (r0 == 0) goto L_0x0987
            com.cyjh.mobileanjian.ipc.ui.g r0 = r8.f2636c
            r8.a()
            java.lang.String r2 = r9.getText()
            int r3 = r9.getWidth()
            int r4 = r9.getHeight()
            boolean r5 = r9.getDefaultCheckStatus()
            r1 = r6
            android.widget.CheckBox r0 = r0.a((java.lang.String) r1, (java.lang.String) r2, (int) r3, (int) r4, (boolean) r5)
            java.util.HashMap[] r1 = r8.e
            int r2 = r8.f2635b
            r1 = r1[r2]
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.CHECK_BOX
            r1.put(r6, r2)
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2634a
            int r2 = r8.f2635b
            r1 = r1[r2]
            goto L_0x075b
        L_0x065b:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r8.f2634a
            int r1 = r8.f2635b
            r0 = r0[r1]
            if (r0 == 0) goto L_0x0987
            com.cyjh.mobileanjian.ipc.ui.g r0 = r8.f2636c
            r8.a()
            java.util.List r2 = r9.getItemTextList()
            int r3 = r9.getDefaultItemIndex()
            int r4 = r9.getWidth()
            int r5 = r9.getHeight()
            r1 = r6
            android.widget.RadioGroup r0 = r0.a((java.lang.String) r1, (java.util.List<java.lang.String>) r2, (int) r3, (int) r4, (int) r5)
            java.util.HashMap[] r1 = r8.e
            int r2 = r8.f2635b
            r1 = r1[r2]
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.RADIIO_GROUP
            r1.put(r6, r2)
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2634a
            int r2 = r8.f2635b
            r1 = r1[r2]
            goto L_0x075b
        L_0x0690:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r8.f2634a
            int r1 = r8.f2635b
            r0 = r0[r1]
            if (r0 == 0) goto L_0x0987
            com.cyjh.mobileanjian.ipc.ui.g r0 = r8.f2636c
            r8.a()
            java.lang.String r1 = r9.getText()
            int r2 = r9.getWidth()
            int r3 = r9.getHeight()
            android.widget.Button r0 = r0.b(r6, r1, r2, r3)
            java.util.HashMap[] r1 = r8.e
            int r2 = r8.f2635b
            r1 = r1[r2]
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.BUTTON
            r1.put(r6, r2)
            r0.setOnClickListener(r8)
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2634a
            int r2 = r8.f2635b
            r1 = r1[r2]
            goto L_0x075b
        L_0x06c3:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r8.f2634a
            int r1 = r8.f2635b
            r0 = r0[r1]
            if (r0 == 0) goto L_0x0987
            com.cyjh.mobileanjian.ipc.ui.g r0 = r8.f2636c
            r8.a()
            java.lang.String r1 = r9.getText()
            int r2 = r9.getWidth()
            int r3 = r9.getHeight()
            android.widget.EditText r0 = r0.d(r6, r1, r2, r3)
            java.util.HashMap[] r1 = r8.e
            int r2 = r8.f2635b
            r1 = r1[r2]
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.EDIT_TEXT
            r1.put(r6, r2)
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2634a
            int r2 = r8.f2635b
            r1 = r1[r2]
            java.lang.String r9 = r9.getParentId()
            r1.a((android.view.View) r0, (java.lang.String) r9)
            com.cyjh.mobileanjian.ipc.ui.i$a r9 = new com.cyjh.mobileanjian.ipc.ui.i$a
            r9.<init>(r6)
            r0.addTextChangedListener(r9)
            goto L_0x0987
        L_0x0702:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r8.f2634a
            int r1 = r8.f2635b
            r0 = r0[r1]
            if (r0 == 0) goto L_0x0987
            com.cyjh.mobileanjian.ipc.ui.g r0 = r8.f2636c
            r8.a()
            java.lang.String r1 = r9.getText()
            int r2 = r9.getWidth()
            int r3 = r9.getHeight()
            android.widget.TextView r0 = r0.a((java.lang.String) r6, (java.lang.String) r1, (int) r2, (int) r3)
            java.util.HashMap[] r1 = r8.e
            int r2 = r8.f2635b
            r1 = r1[r2]
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.TEXT_VIEW
            r1.put(r6, r2)
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2634a
            int r2 = r8.f2635b
            r1 = r1[r2]
            goto L_0x075b
        L_0x0731:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r8.f2634a
            int r1 = r8.f2635b
            r0 = r0[r1]
            if (r0 == 0) goto L_0x0987
            com.cyjh.mobileanjian.ipc.ui.g r0 = r8.f2636c
            r8.a()
            int r1 = r9.getWidth()
            int r2 = r9.getHeight()
            android.widget.LinearLayout r0 = r0.b(r6, r1, r2)
            java.util.HashMap[] r1 = r8.e
            int r2 = r8.f2635b
            r1 = r1[r2]
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.LINE
            r1.put(r6, r2)
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2634a
            int r2 = r8.f2635b
            r1 = r1[r2]
        L_0x075b:
            java.lang.String r9 = r9.getParentId()
            r1.a((android.view.View) r0, (java.lang.String) r9)
            goto L_0x0987
        L_0x0764:
            java.lang.String r0 = r9.getControlId()
            java.lang.String r9 = r9.getColor()
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r8.d
            java.lang.Object r1 = r1.get(r0)
            if (r1 != 0) goto L_0x0781
            int r9 = com.cyjh.mqsdk.R.string.ui_show_not_found_ui
            java.lang.Object[] r1 = new java.lang.Object[r7]
            r1[r3] = r0
            r8.a((int) r9, (java.lang.Object[]) r1)
            a((boolean) r3)
            return
        L_0x0781:
            java.lang.String r1 = "^#*([0-9A-Fa-f]{6})|([0-9A-Fa-f]{3})"
            boolean r1 = r9.matches(r1)
            if (r1 != 0) goto L_0x0794
            int r9 = com.cyjh.mqsdk.R.string.ui_show_invalid_color_value
            java.lang.Object[] r0 = new java.lang.Object[r3]
            r8.a((int) r9, (java.lang.Object[]) r0)
            a((boolean) r3)
            return
        L_0x0794:
            java.lang.String r1 = "#"
            boolean r1 = r9.startsWith(r1)
            if (r1 != 0) goto L_0x07aa
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "#"
            r1.<init>(r2)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
        L_0x07aa:
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r8.d
            java.lang.Object r0 = r1.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r9 = android.graphics.Color.parseColor(r9)
            int r9 = com.cyjh.mobileanjian.ipc.utils.c.a(r9)
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2634a
            r0 = r1[r0]
            r0.b((int) r9)
            a((boolean) r7)
            return
        L_0x07c9:
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r8.d
            java.lang.Object r9 = r9.get(r6)
            if (r9 != 0) goto L_0x07de
            int r9 = com.cyjh.mqsdk.R.string.ui_show_not_found_ui
            java.lang.Object[] r0 = new java.lang.Object[r7]
            r0[r3] = r6
            r8.a((int) r9, (java.lang.Object[]) r0)
            a((boolean) r3)
            return
        L_0x07de:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r8.f2634a
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r8.d
            java.lang.Object r0 = r0.get(r6)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r9 = r9[r0]
            java.lang.String r9 = r9.a()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = r0.setControlId(r6)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.STRING
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = r0.setType(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r9 = r0.setStringValue(r9)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar r9 = r9.build()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.RSP_MSG
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r7)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r9 = r0.addVarTable((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar) r9)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r9 = r9.build()
            com.google.protobuf.ByteString r9 = r9.toByteString()
            com.cyjh.event.c.a(r9)
            return
        L_0x0826:
            java.lang.String r9 = r9.getText()
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r8.d
            java.lang.Object r0 = r0.get(r6)
            if (r0 != 0) goto L_0x083e
            int r9 = com.cyjh.mqsdk.R.string.ui_show_not_found_ui
            java.lang.Object[] r0 = new java.lang.Object[r7]
            r0[r3] = r6
            r8.a((int) r9, (java.lang.Object[]) r0)
            r7 = 0
            goto L_0x0987
        L_0x083e:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r8.f2634a
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r8.d
            java.lang.Object r1 = r1.get(r6)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r0 = r0[r1]
            r0.a((java.lang.String) r9)
            goto L_0x0987
        L_0x0853:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r8.f2634a
            int r1 = r8.f2635b
            r0 = r0[r1]
            if (r0 == 0) goto L_0x0987
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r8.f2634a
            int r1 = r8.f2635b
            r0 = r0[r1]
            r8.a()
            java.lang.String r1 = r9.getParentId()
            int r2 = r9.getWidth()
            int r9 = r9.getHeight()
            r0.a((java.lang.String) r6, (java.lang.String) r1, (int) r2, (int) r9)
            goto L_0x0987
        L_0x0875:
            r8.c()
            goto L_0x0987
        L_0x087a:
            boolean r7 = r8.d((java.lang.String) r6)
            goto L_0x0987
        L_0x0880:
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Builder r9 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlEvent.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Builder r9 = r9.setControlId(r6)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Event_Type r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlEvent.Event_Type.ON_CLOSE_CONTINUE
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Builder r9 = r9.setType(r0)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent r9 = r9.build()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.EVENT
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r7)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r9 = r0.setEvent((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlEvent) r9)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r9 = r9.build()
            com.google.protobuf.ByteString r9 = r9.toByteString()
            com.cyjh.event.c.b(r9)
            goto L_0x0987
        L_0x08b1:
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r8.d
            java.lang.Object r9 = r9.get(r6)
            if (r9 != 0) goto L_0x08c6
            int r9 = com.cyjh.mqsdk.R.string.ui_show_not_found_ui
            java.lang.Object[] r0 = new java.lang.Object[r7]
            r0[r3] = r6
            r8.a((int) r9, (java.lang.Object[]) r0)
            a((boolean) r3)
            return
        L_0x08c6:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r8.f2634a
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r8.d
            java.lang.Object r0 = r0.get(r6)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r9 = r9[r0]
            boolean r9 = r9.f2658c
            if (r9 == 0) goto L_0x08de
            a((boolean) r3)
            return
        L_0x08de:
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r8.f2634a
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r8.d
            java.lang.Object r0 = r0.get(r6)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r9 = r9[r0]
            r9.c()
            a((boolean) r7)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Builder r9 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlEvent.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Builder r9 = r9.setControlId(r6)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Event_Type r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlEvent.Event_Type.ON_SHOW
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Builder r9 = r9.setType(r0)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent r9 = r9.build()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.EVENT
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r7)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r9 = r0.setEvent((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlEvent) r9)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r9 = r9.build()
            com.google.protobuf.ByteString r9 = r9.toByteString()
            com.cyjh.event.c.b(r9)
            return
        L_0x0924:
            int r0 = r9.getWidth()
            int r9 = r9.getHeight()
            int r1 = r8.f2635b
            int r1 = r1 + r7
            r8.f2635b = r1
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2634a
            int r2 = r8.f2635b
            com.cyjh.mobileanjian.ipc.ui.g r3 = r8.f2636c
            com.cyjh.mobileanjian.ipc.ui.k r9 = r3.a((java.lang.String) r6, (int) r0, (int) r9)
            r1[r2] = r9
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r8.d
            int r0 = r8.f2635b
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9.put(r6, r0)
            java.util.HashMap[] r9 = r8.e
            int r0 = r8.f2635b
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r9[r0] = r1
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r8.f2634a
            int r0 = r8.f2635b
            r9 = r9[r0]
            com.cyjh.mobileanjian.ipc.ui.i$1 r0 = new com.cyjh.mobileanjian.ipc.ui.i$1
            r0.<init>(r6)
            r9.f2657b = r0
            com.cyjh.mobileanjian.ipc.ui.k[] r9 = r8.f2634a
            int r0 = r8.f2635b
            r9 = r9[r0]
            com.cyjh.mobileanjian.ipc.ui.i$2 r0 = new com.cyjh.mobileanjian.ipc.ui.i$2
            r0.<init>(r6)
            r9.f2656a = r0
            goto L_0x0987
        L_0x096e:
            java.lang.String r9 = r9.getPath()     // Catch:{ IOException -> 0x097e, JSONException -> 0x0983 }
            r8.b((java.lang.String) r9)     // Catch:{ IOException -> 0x097e, JSONException -> 0x0983 }
            goto L_0x0987
        L_0x0976:
            java.lang.String r9 = r9.getPath()     // Catch:{  }
            r8.a((java.lang.String) r9)     // Catch:{  }
            goto L_0x0987
        L_0x097e:
            r9 = move-exception
            r9.printStackTrace()
            goto L_0x0987
        L_0x0983:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0987:
            a((boolean) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.ui.i.d(com.cyjh.mobileanjian.ipc.share.proto.UiMessage$CommandToUi):void");
    }

    private void e(UiMessage.CommandToUi commandToUi) {
        if (this.f2634a[this.f2635b] == null) {
            a(false);
            return;
        }
        String controlId = commandToUi.getControlId();
        commandToUi.getText();
        View b2 = this.f2634a[this.f2635b].b(controlId);
        if (b2 == null) {
            a(false);
        } else if (this.e[this.f2635b].get(controlId) != m.EDIT_TEXT) {
            a(false);
        } else {
            ((EditText) b2).setInputType(commandToUi.getEditInputType());
            a(true);
        }
    }

    private void f(UiMessage.CommandToUi commandToUi) {
        if (this.f2634a[this.f2635b] == null) {
            a(false);
            return;
        }
        String controlId = commandToUi.getControlId();
        String color = commandToUi.getColor();
        if (!color.matches(g)) {
            a(R.string.ui_show_invalid_color_value, new Object[0]);
            a(false);
            return;
        }
        if (!color.startsWith("#")) {
            color = "#" + color;
        }
        int a2 = com.cyjh.mobileanjian.ipc.utils.c.a(Color.parseColor(color));
        if (this.d.get(controlId) != null) {
            this.f2634a[this.d.get(controlId).intValue()].a(a2);
            a(true);
            return;
        }
        View b2 = this.f2634a[this.f2635b].b(controlId);
        if (b2 == null) {
            a(false);
            return;
        }
        switch ((m) this.e[this.f2635b].get(controlId)) {
            case TEXT_VIEW:
            case EDIT_TEXT:
            case BUTTON:
                ((TextView) b2).setTextColor(a2);
                break;
            case CHECK_BOX:
                ((CheckBox) b2).setTextColor(a2);
                break;
            case RADIIO_GROUP:
                RadioButton radioButton = (RadioButton) ((RadioGroup) b2).findViewById(commandToUi.getItemIndex());
                if (radioButton != null) {
                    radioButton.setTextColor(a2);
                    break;
                } else {
                    a(false);
                    return;
                }
            case SPINNER:
                if (commandToUi.getItemIndex() >= ((Spinner) b2).getCount()) {
                    a(false);
                    return;
                }
                break;
            default:
                a(false);
                return;
        }
        a(true);
    }

    private void f(String str) {
        if (this.d.get(str) != null) {
            a(true);
        } else if (this.e[this.f2635b].get(str) == null) {
            a(false);
        } else {
            View b2 = this.f2634a[this.f2635b].b(str);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b2.getLayoutParams();
            layoutParams.width = -1;
            b2.setLayoutParams(layoutParams);
        }
    }

    private void g(UiMessage.CommandToUi commandToUi) {
        if (this.f2634a[this.f2635b] == null) {
            a(false);
            return;
        }
        String controlId = commandToUi.getControlId();
        View b2 = this.f2634a[this.f2635b].b(controlId);
        if (b2 == null) {
            a(false);
            return;
        }
        String color = commandToUi.getColor();
        if (!color.matches(g)) {
            a(R.string.ui_show_invalid_color_value, new Object[0]);
            a(false);
            return;
        }
        if (!color.startsWith("#")) {
            color = "#" + color;
        }
        int a2 = com.cyjh.mobileanjian.ipc.utils.c.a(Color.parseColor(color));
        if (this.e[this.f2635b].get(controlId) == m.BUTTON) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(a2);
            gradientDrawable.setCornerRadius((float) b());
            if (Build.VERSION.SDK_INT >= 16) {
                b2.setBackground(gradientDrawable);
            } else {
                b2.setBackgroundDrawable(gradientDrawable);
            }
            a(true);
            return;
        }
        if (this.e[this.f2635b].get(controlId) != m.SPINNER) {
            b2.setBackgroundColor(a2);
        }
        a(true);
    }

    private void g(String str) {
        if (this.f2634a[this.f2635b] == null) {
            a(false);
            return;
        }
        View b2 = this.f2634a[this.f2635b].b(str);
        if (b2 == null) {
            a(false);
            return;
        }
        boolean isEnabled = b2.isEnabled();
        if (this.e[this.f2635b].get(str) == m.EDIT_TEXT) {
            isEnabled = ((EditText) b2).isFocusable();
        }
        c.a(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.RSP_MSG).setIsSuccess(true).addVarTable(UiMessage.ControlVar.newBuilder().setControlId(str).setType(UiMessage.ControlVar.Data_Type.BOOL).setBoolValue(isEnabled).build()).build().toByteString());
    }

    private void h(UiMessage.CommandToUi commandToUi) {
        if (this.f2634a[this.f2635b] == null) {
            a(false);
            return;
        }
        View b2 = this.f2634a[this.f2635b].b(commandToUi.getControlId());
        if (b2 == null) {
            a(false);
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b2.getLayoutParams();
        layoutParams.gravity = commandToUi.getAlignType();
        b2.setLayoutParams(layoutParams);
        new StringBuilder("set gravity ok; ").append(layoutParams);
        a(true);
    }

    private void h(String str) {
        int i2;
        if (this.f2634a[this.f2635b] == null) {
            a(false);
            return;
        }
        View b2 = this.f2634a[this.f2635b].b(str);
        if (b2 == null) {
            a(false);
            return;
        }
        int visibility = b2.getVisibility();
        if (visibility != 0) {
            if (visibility == 4) {
                i2 = 2;
            } else if (visibility == 8) {
                i2 = 3;
            }
            c.a(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.RSP_MSG).setIsSuccess(true).addVarTable(UiMessage.ControlVar.newBuilder().setControlId(str).setType(UiMessage.ControlVar.Data_Type.INT).setIntValue(i2).build()).build().toByteString());
        }
        i2 = 1;
        c.a(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.RSP_MSG).setIsSuccess(true).addVarTable(UiMessage.ControlVar.newBuilder().setControlId(str).setType(UiMessage.ControlVar.Data_Type.INT).setIntValue(i2).build()).build().toByteString());
    }

    private void i(UiMessage.CommandToUi commandToUi) {
        if (this.f2634a[this.f2635b] == null) {
            a(false);
            return;
        }
        View b2 = this.f2634a[this.f2635b].b(commandToUi.getControlId());
        if (b2 == null) {
            a(false);
            return;
        }
        UiMessage.Padding_Var padding = commandToUi.getPadding();
        new StringBuilder("padding: ").append(padding.getLeft());
        new StringBuilder("padding: ").append(padding.getTop());
        new StringBuilder("padding: ").append(padding.getRight());
        new StringBuilder("padding: ").append(padding.getBottom());
        b2.setPadding(padding.getLeft(), padding.getTop(), padding.getRight(), padding.getBottom());
        a(true);
    }

    private void i(String str) {
        if (this.f2634a[this.f2635b] == null) {
            a(false);
            return;
        }
        View b2 = this.f2634a[this.f2635b].b(str);
        if (b2 == null) {
            a(false);
            return;
        }
        int a2 = com.cyjh.mobileanjian.ipc.utils.c.a(b2.getSolidColor());
        c.a(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.RSP_MSG).setIsSuccess(true).addVarTable(UiMessage.ControlVar.newBuilder().setControlId(str).setType(UiMessage.ControlVar.Data_Type.STRING).setStringValue("#" + Integer.toHexString(a2 & ViewCompat.MEASURED_SIZE_MASK)).build()).build().toByteString());
    }

    private void j(UiMessage.CommandToUi commandToUi) {
        TextPaint textPaint;
        if (this.f2634a[this.f2635b] == null) {
            a(false);
            return;
        }
        String controlId = commandToUi.getControlId();
        if (this.e[this.f2635b].get(controlId) == null) {
            a(false);
            return;
        }
        switch ((m) this.e[this.f2635b].get(controlId)) {
            case TEXT_VIEW:
            case EDIT_TEXT:
            case BUTTON:
                textPaint = ((TextView) this.f2634a[this.f2635b].b(controlId)).getPaint();
                break;
            case CHECK_BOX:
                textPaint = ((CheckBox) this.f2634a[this.f2635b].b(controlId)).getPaint();
                break;
            case RADIIO_GROUP:
                RadioButton radioButton = (RadioButton) ((RadioGroup) this.f2634a[this.f2635b].b(controlId)).findViewById(commandToUi.getItemIndex());
                if (radioButton != null) {
                    textPaint = radioButton.getPaint();
                    break;
                } else {
                    a(false);
                    return;
                }
            default:
                a(false);
                return;
        }
        int color = textPaint.getColor();
        c.a(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.RSP_MSG).setIsSuccess(true).addVarTable(UiMessage.ControlVar.newBuilder().setControlId(controlId).setType(UiMessage.ControlVar.Data_Type.STRING).setStringValue(String.format("%02X%02X%02X", new Object[]{Integer.valueOf(Color.blue(color)), Integer.valueOf(Color.green(color)), Integer.valueOf(Color.red(color))})).build()).build().toByteString());
    }

    private void j(String str) {
        if (this.d.get(str) == null) {
            a(R.string.ui_show_not_found_ui, str);
            a(false);
        } else if (this.f2634a[this.d.get(str).intValue()].f2658c) {
            a(false);
        } else {
            this.f2634a[this.d.get(str).intValue()].c();
            a(true);
            c.b(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setIsSuccess(true).setEvent(UiMessage.ControlEvent.newBuilder().setControlId(str).setType(UiMessage.ControlEvent.Event_Type.ON_SHOW).build()).build().toByteString());
        }
    }

    private void k(UiMessage.CommandToUi commandToUi) {
        String str;
        CharSequence charSequence;
        if (this.f2634a[this.f2635b] == null) {
            a(false);
            return;
        }
        String controlId = commandToUi.getControlId();
        if (this.e[this.f2635b].get(controlId) == null) {
            a(false);
            return;
        }
        switch ((m) this.e[this.f2635b].get(controlId)) {
            case TEXT_VIEW:
            case EDIT_TEXT:
            case BUTTON:
                charSequence = ((TextView) this.f2634a[this.f2635b].b(controlId)).getText();
                break;
            case CHECK_BOX:
                charSequence = ((CheckBox) this.f2634a[this.f2635b].b(controlId)).getText();
                break;
            case RADIIO_GROUP:
                RadioButton radioButton = (RadioButton) ((RadioGroup) this.f2634a[this.f2635b].b(controlId)).findViewById(commandToUi.getItemIndex());
                if (radioButton != null) {
                    charSequence = radioButton.getText();
                    break;
                } else {
                    a(false);
                    return;
                }
            case SPINNER:
                Spinner spinner = (Spinner) this.f2634a[this.f2635b].b(controlId);
                if (commandToUi.getItemIndex() < spinner.getCount()) {
                    new StringBuilder("Spinner Get pos: ").append(spinner.getItemAtPosition(commandToUi.getItemIndex()));
                    str = (String) spinner.getItemAtPosition(commandToUi.getItemIndex());
                    break;
                } else {
                    a(false);
                    return;
                }
            default:
                a(false);
                return;
        }
        str = charSequence.toString();
        c.a(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.RSP_MSG).setIsSuccess(true).addVarTable(UiMessage.ControlVar.newBuilder().setControlId(controlId).setType(UiMessage.ControlVar.Data_Type.STRING).setStringValue(str).build()).build().toByteString());
    }

    private void k(String str) {
        if (this.d.get(str) == null) {
            a(R.string.ui_show_not_found_ui, str);
            a(false);
            return;
        }
        c.a(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.RSP_MSG).setIsSuccess(true).addVarTable(UiMessage.ControlVar.newBuilder().setControlId(str).setType(UiMessage.ControlVar.Data_Type.STRING).setStringValue(this.f2634a[this.d.get(str).intValue()].a()).build()).build().toByteString());
    }

    private void l(UiMessage.CommandToUi commandToUi) {
        String controlId = commandToUi.getControlId();
        String color = commandToUi.getColor();
        if (this.d.get(controlId) == null) {
            a(R.string.ui_show_not_found_ui, controlId);
            a(false);
        } else if (!color.matches(g)) {
            a(R.string.ui_show_invalid_color_value, new Object[0]);
            a(false);
        } else {
            if (!color.startsWith("#")) {
                color = "#" + color;
            }
            this.f2634a[this.d.get(controlId).intValue()].b(com.cyjh.mobileanjian.ipc.utils.c.a(Color.parseColor(color)));
            a(true);
        }
    }

    public final int a() {
        int i2 = this.f + 1;
        this.f = i2;
        return i2;
    }

    public final void a(int i2, Object... objArr) {
        ExToast.makeText(this.i, (CharSequence) String.format(this.i.getString(i2), objArr), (int) ExToast.LENGTH_LONG).show();
    }

    public final void a(String str) throws JSONException, IOException {
        if (this.f2634a[this.f2635b] != null) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : this.e[this.f2635b].entrySet()) {
                String str2 = (String) entry.getKey();
                int i2 = AnonymousClass3.f2642b[((m) entry.getValue()).ordinal()];
                if (i2 != 2) {
                    switch (i2) {
                        case 4:
                            jSONObject.put(str2, ((CheckBox) this.f2634a[this.f2635b].b(str2)).isChecked());
                            break;
                        case 5:
                            jSONObject.put(str2, ((RadioGroup) this.f2634a[this.f2635b].b(str2)).getCheckedRadioButtonId());
                            break;
                        case 6:
                            jSONObject.put(str2, ((Spinner) this.f2634a[this.f2635b].b(str2)).getSelectedItemId());
                            break;
                    }
                } else {
                    jSONObject.put(str2, ((EditText) this.f2634a[this.f2635b].b(str2)).getText().toString());
                }
            }
            FileUtils.writeStringToFile(new File(str), jSONObject.toString());
        }
    }

    public final boolean a(UiMessage.CommandToUi commandToUi) {
        int i2;
        int i3 = 0;
        if (this.f2634a[this.f2635b] == null) {
            return false;
        }
        String controlId = commandToUi.getControlId();
        View b2 = this.f2634a[this.f2635b].b(controlId);
        if (b2 == null) {
            a(R.string.ui_show_not_found_widget, controlId);
            return false;
        }
        switch (commandToUi.getCommand()) {
            case SET_TEXT_VIEW:
                if (this.e[this.f2635b].get(controlId) == m.TEXT_VIEW) {
                    TextView textView = (TextView) b2;
                    textView.setText(commandToUi.getText());
                    textView.setLayoutParams(new LinearLayout.LayoutParams(commandToUi.getWidth(), commandToUi.getHeight()));
                    break;
                } else {
                    return false;
                }
            case SET_EDIT_TEXT:
                if (this.e[this.f2635b].get(controlId) != m.EDIT_TEXT) {
                    return false;
                }
                EditText editText = (EditText) b2;
                editText.setText(commandToUi.getText());
                editText.setLayoutParams(new LinearLayout.LayoutParams(commandToUi.getWidth(), commandToUi.getHeight()));
                return true;
            case SET_BOTTON:
                if (this.e[this.f2635b].get(controlId) != m.BUTTON) {
                    return false;
                }
                Button button = (Button) b2;
                button.setText(commandToUi.getText());
                button.setLayoutParams(new LinearLayout.LayoutParams(commandToUi.getWidth(), commandToUi.getHeight()));
                return true;
            case SET_CHECK_BOX:
                if (this.e[this.f2635b].get(controlId) != m.CHECK_BOX) {
                    return false;
                }
                CheckBox checkBox = (CheckBox) b2;
                checkBox.setChecked(commandToUi.getDefaultCheckStatus());
                checkBox.setText(commandToUi.getText());
                checkBox.getLayoutParams().width = commandToUi.getWidth();
                checkBox.getLayoutParams().height = commandToUi.getHeight();
                return true;
            case SET_IMAGE_VIEW:
                if (this.e[this.f2635b].get(controlId) != m.IMAGE_VIEW) {
                    return false;
                }
                ImageView imageView = (ImageView) b2;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b2.getLayoutParams();
                layoutParams.width = commandToUi.getWidth();
                layoutParams.height = commandToUi.getHeight();
                imageView.setLayoutParams(layoutParams);
                imageView.setImageURI(Uri.fromFile(new File(commandToUi.getPath())));
                return true;
            case SET_WEB_VIEW:
                if (this.e[this.f2635b].get(controlId) != m.WEB_VIEW) {
                    return false;
                }
                String url = commandToUi.getUrl();
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    url = "http://" + url;
                }
                WebView webView = (WebView) b2;
                webView.loadUrl(url);
                webView.setLayoutParams(new LinearLayout.LayoutParams(commandToUi.getWidth(), commandToUi.getHeight()));
                return true;
            case SET_RADIO_GROUP:
                if (this.e[this.f2635b].get(controlId) != m.RADIIO_GROUP) {
                    return false;
                }
                RadioGroup radioGroup = (RadioGroup) b2;
                radioGroup.clearCheck();
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) b2.getLayoutParams();
                layoutParams2.weight = (float) commandToUi.getWidth();
                layoutParams2.height = commandToUi.getHeight();
                radioGroup.setLayoutParams(layoutParams2);
                radioGroup.removeAllViews();
                List<String> itemTextList = commandToUi.getItemTextList();
                for (int i4 = 0; i4 < itemTextList.size(); i4++) {
                    RadioButton radioButton = (RadioButton) LayoutInflater.from(this.i).inflate(R.layout.ui_show_radio_button, (ViewGroup) null);
                    radioButton.setId(i4);
                    radioButton.setText(itemTextList.get(i4));
                    radioButton.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                    radioButton.setPadding(0, b(), 0, b());
                    radioGroup.addView(radioButton);
                }
                if (commandToUi.getDefaultItemIndex() < radioGroup.getChildCount()) {
                    i3 = commandToUi.getDefaultItemIndex();
                }
                ((RadioButton) radioGroup.findViewById(i3)).setChecked(true);
                return true;
            case SET_SPINNER:
                if (this.e[this.f2635b].get(controlId) != m.SPINNER) {
                    return false;
                }
                Spinner spinner = (Spinner) b2;
                ArrayAdapter arrayAdapter = new ArrayAdapter(this.i, R.layout.ui_show_spinner_dropdown_item, commandToUi.getItemTextList());
                spinner.setAdapter(arrayAdapter);
                if (commandToUi.getDefaultItemIndex() < arrayAdapter.getCount()) {
                    i3 = commandToUi.getDefaultItemIndex();
                }
                spinner.setSelection(i3);
                return true;
            case SET_ENABLED:
                if (this.e[this.f2635b].get(controlId) == m.RADIIO_GROUP) {
                    b2.setEnabled(commandToUi.getEnabledStatus());
                    RadioGroup radioGroup2 = (RadioGroup) b2;
                    while (i3 < radioGroup2.getChildCount()) {
                        radioGroup2.getChildAt(i3).setEnabled(commandToUi.getEnabledStatus());
                        i3++;
                    }
                    break;
                } else if (this.e[this.f2635b].get(controlId) == m.EDIT_TEXT) {
                    new StringBuilder("set edittext enabled. ").append(commandToUi.getEnabledStatus());
                    EditText editText2 = (EditText) b2;
                    editText2.setFocusable(commandToUi.getEnabledStatus());
                    editText2.setFocusableInTouchMode(commandToUi.getEnabledStatus());
                    return true;
                } else {
                    b2.setEnabled(commandToUi.getEnabledStatus());
                    return true;
                }
            case SET_LINE:
                if (this.e[this.f2635b].get(controlId) != m.LINE) {
                    return false;
                }
                ((LinearLayout) b2).setLayoutParams(new LinearLayout.LayoutParams(commandToUi.getWidth(), commandToUi.getHeight()));
                return true;
            case SET_VISIBLE:
                switch (commandToUi.getVisibleStatus()) {
                    case 2:
                        i2 = 4;
                        break;
                    case 3:
                        i2 = 8;
                        break;
                    default:
                        b2.setVisibility(0);
                        return true;
                }
                b2.setVisibility(i2);
                return true;
            default:
                return true;
        }
        return true;
    }

    public final int b() {
        return (int) ((((float) this.i.getResources().getDisplayMetrics().densityDpi) / 160.0f) * 5.0f);
    }

    public final void b(UiMessage.CommandToUi commandToUi) {
        if (this.f2634a[this.f2635b] == null) {
            a(false);
            return;
        }
        new StringBuilder("SET FONT type: ").append(commandToUi.getFontType());
        String controlId = commandToUi.getControlId();
        Typeface create = Typeface.create(commandToUi.getFontType(), 0);
        if (create == null) {
            a(false);
            return;
        }
        int fontSize = commandToUi.getFontSize() < 0 ? 14 : commandToUi.getFontSize();
        if (this.d.get(controlId) == null || this.f2634a[this.d.get(controlId).intValue()] == null) {
            View b2 = this.f2634a[this.f2635b].b(controlId);
            if (b2 == null) {
                a(false);
            } else if (this.e[this.f2635b].get(controlId) == null) {
                a(false);
            } else {
                switch ((m) this.e[this.f2635b].get(controlId)) {
                    case TEXT_VIEW:
                    case EDIT_TEXT:
                    case BUTTON:
                        TextView textView = (TextView) b2;
                        textView.setTypeface(create);
                        textView.setTextSize(2, (float) fontSize);
                        break;
                    case CHECK_BOX:
                        CheckBox checkBox = (CheckBox) b2;
                        checkBox.setTypeface(create);
                        checkBox.setTextSize(2, (float) fontSize);
                        break;
                    case RADIIO_GROUP:
                        RadioGroup radioGroup = (RadioGroup) b2;
                        radioGroup.findViewById(commandToUi.getItemIndex());
                        for (int i2 = 0; i2 < radioGroup.getChildCount(); i2++) {
                            RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i2);
                            radioButton.setTypeface(create);
                            radioButton.setTextSize(2, (float) fontSize);
                        }
                        break;
                    default:
                        a(false);
                        return;
                }
                a(true);
            }
        } else {
            this.f2634a[this.d.get(controlId).intValue()].a(create, fontSize);
            a(true);
        }
    }

    public final void b(String str) throws IOException, JSONException {
        if (this.e[this.f2635b] != null) {
            JSONObject jSONObject = new JSONObject(FileUtils.readFileToString(new File(str)));
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (this.e[this.f2635b].get(next) != null) {
                    int i2 = AnonymousClass3.f2642b[((m) this.e[this.f2635b].get(next)).ordinal()];
                    if (i2 != 2) {
                        switch (i2) {
                            case 4:
                                ((CheckBox) this.f2634a[this.f2635b].b(next)).setChecked(jSONObject.getBoolean(next));
                                break;
                            case 5:
                                RadioGroup radioGroup = (RadioGroup) this.f2634a[this.f2635b].b(next);
                                if (jSONObject.getInt(next) >= radioGroup.getChildCount()) {
                                    break;
                                } else {
                                    ((RadioButton) radioGroup.findViewById(jSONObject.getInt(next))).setChecked(true);
                                    break;
                                }
                            case 6:
                                Spinner spinner = (Spinner) this.f2634a[this.f2635b].b(next);
                                if (jSONObject.getInt(next) >= spinner.getCount()) {
                                    break;
                                } else {
                                    spinner.setSelection(jSONObject.getInt(next));
                                    break;
                                }
                        }
                    } else {
                        ((EditText) this.f2634a[this.f2635b].b(next)).setText(jSONObject.getString(next));
                    }
                }
            }
        }
    }

    public final void c() {
        for (int i2 = 31; i2 > 0; i2--) {
            k kVar = this.f2634a[i2];
            if (kVar != null && kVar.f2658c) {
                kVar.e();
            }
        }
    }

    public final void c(UiMessage.CommandToUi commandToUi) {
        if (this.f2634a[this.f2635b] == null) {
            a(false);
            return;
        }
        String controlId = commandToUi.getControlId();
        String text = commandToUi.getText();
        View b2 = this.f2634a[this.f2635b].b(controlId);
        if (b2 == null) {
            a(false);
        } else if (this.e[this.f2635b].get(controlId) == null) {
            a(false);
        } else {
            switch ((m) this.e[this.f2635b].get(controlId)) {
                case TEXT_VIEW:
                case EDIT_TEXT:
                case BUTTON:
                    ((TextView) b2).setText(text);
                    break;
                case CHECK_BOX:
                    ((CheckBox) b2).setText(text);
                    break;
                case RADIIO_GROUP:
                    RadioButton radioButton = (RadioButton) ((RadioGroup) b2).findViewById(commandToUi.getItemIndex());
                    if (radioButton != null) {
                        radioButton.setText(text);
                        break;
                    } else {
                        a(false);
                        return;
                    }
                case SPINNER:
                    Spinner spinner = (Spinner) b2;
                    if (commandToUi.getItemIndex() < spinner.getCount()) {
                        ArrayAdapter arrayAdapter = (ArrayAdapter) spinner.getAdapter();
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < arrayAdapter.getCount(); i2++) {
                            arrayList.add(arrayAdapter.getItem(i2));
                        }
                        arrayList.set(commandToUi.getItemIndex(), text);
                        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this.i, R.layout.ui_show_spinner_dropdown_item, arrayList);
                        spinner.setAdapter(arrayAdapter2);
                        arrayAdapter2.notifyDataSetChanged();
                        break;
                    } else {
                        a(false);
                        return;
                    }
                default:
                    a(false);
                    return;
            }
            a(true);
        }
    }

    public final boolean d(String str) {
        if (this.d.get(str) == null) {
            a(R.string.ui_show_not_found_ui, str);
            return false;
        } else if (!this.f2634a[this.d.get(str).intValue()].f2658c) {
            return false;
        } else {
            this.f2634a[this.d.get(str).intValue()].e();
            if (this.d.get(str).intValue() == this.f2635b) {
                do {
                    this.f2635b--;
                    if (this.f2635b <= 0 || this.f2634a[this.f2635b] != null) {
                    }
                    this.f2635b--;
                    break;
                } while (this.f2634a[this.f2635b] != null);
                if (this.f2635b < 0) {
                    this.f2635b = 0;
                }
            }
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x009b, code lost:
        r1.setIntValue(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00d2, code lost:
        r0.addVarTable(r2.build());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d9, code lost:
        new java.lang.StringBuilder("Ui.getValue result: ").append(r0.build());
        r9 = r0.build();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(java.lang.String r9) {
        /*
            r8 = this;
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.RSP_MSG
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)
            r1 = 1
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r2 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r2 = r2.setControlId(r9)
            r3 = 0
            r4 = 0
            r5 = r4
            r4 = 0
        L_0x001b:
            r6 = 32
            if (r4 >= r6) goto L_0x0035
            java.util.HashMap[] r6 = r8.e
            r6 = r6[r4]
            if (r6 == 0) goto L_0x0032
            java.util.HashMap[] r5 = r8.e
            r5 = r5[r4]
            java.lang.Object r5 = r5.get(r9)
            com.cyjh.mobileanjian.ipc.ui.m r5 = (com.cyjh.mobileanjian.ipc.ui.m) r5
            if (r5 == 0) goto L_0x0032
            goto L_0x0036
        L_0x0032:
            int r4 = r4 + 1
            goto L_0x001b
        L_0x0035:
            r4 = 0
        L_0x0036:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "type="
            r6.<init>(r7)
            r6.append(r5)
            java.lang.String r7 = "; tempIndex="
            r6.append(r7)
            r6.append(r4)
            if (r5 != 0) goto L_0x0063
            int r2 = com.cyjh.mqsdk.R.string.ui_show_not_found_widget
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r3] = r9
            r8.a((int) r2, (java.lang.Object[]) r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r9 = r0.setIsSuccess(r3)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r9 = r9.build()
        L_0x005b:
            com.google.protobuf.ByteString r9 = r9.toByteString()
            com.cyjh.event.c.a(r9)
            return
        L_0x0063:
            int[] r1 = com.cyjh.mobileanjian.ipc.ui.i.AnonymousClass3.f2642b
            int r5 = r5.ordinal()
            r1 = r1[r5]
            switch(r1) {
                case 1: goto L_0x00b7;
                case 2: goto L_0x00b7;
                case 3: goto L_0x00b7;
                case 4: goto L_0x009f;
                case 5: goto L_0x0087;
                case 6: goto L_0x0072;
                default: goto L_0x006e;
            }
        L_0x006e:
            r0.setIsSuccess(r3)
            goto L_0x00d9
        L_0x0072:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2634a
            r1 = r1[r4]
            android.view.View r9 = r1.b((java.lang.String) r9)
            android.widget.Spinner r9 = (android.widget.Spinner) r9
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.INT
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r1 = r2.setType(r1)
            int r9 = r9.getSelectedItemPosition()
            goto L_0x009b
        L_0x0087:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2634a
            r1 = r1[r4]
            android.view.View r9 = r1.b((java.lang.String) r9)
            android.widget.RadioGroup r9 = (android.widget.RadioGroup) r9
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.INT
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r1 = r2.setType(r1)
            int r9 = r9.getCheckedRadioButtonId()
        L_0x009b:
            r1.setIntValue(r9)
            goto L_0x00d2
        L_0x009f:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2634a
            r1 = r1[r4]
            android.view.View r9 = r1.b((java.lang.String) r9)
            android.widget.CheckBox r9 = (android.widget.CheckBox) r9
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.BOOL
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r1 = r2.setType(r1)
            boolean r9 = r9.isChecked()
            r1.setBoolValue(r9)
            goto L_0x00d2
        L_0x00b7:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2634a
            r1 = r1[r4]
            android.view.View r9 = r1.b((java.lang.String) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.STRING
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r1 = r2.setType(r1)
            java.lang.CharSequence r9 = r9.getText()
            java.lang.String r9 = r9.toString()
            r1.setStringValue(r9)
        L_0x00d2:
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar r9 = r2.build()
            r0.addVarTable((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar) r9)
        L_0x00d9:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r1 = "Ui.getValue result: "
            r9.<init>(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r1 = r0.build()
            r9.append(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r9 = r0.build()
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.ui.i.e(java.lang.String):void");
    }

    public final void onClick(View view) {
        c.b(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setEvent(UiMessage.ControlEvent.newBuilder().setControlId((String) view.getTag()).setType(UiMessage.ControlEvent.Event_Type.ON_CLICK).build()).setIsSuccess(true).build().toByteString());
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
        c.b(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setEvent(UiMessage.ControlEvent.newBuilder().setControlId((String) adapterView.getTag()).setEventArgs(String.valueOf(i2)).setType(UiMessage.ControlEvent.Event_Type.ON_CLICK).build()).setIsSuccess(true).build().toByteString());
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
