package com.cyjh.mobileanjian.ipc.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
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
import android.view.WindowManager;
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
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.cyjh.mobileanjian.ipc.share.proto.UiMessage;
import com.cyjh.mobileanjian.ipc.utils.c;
import com.cyjh.mobileanjian.ipc.view.ExToast;
import com.cyjh.mq.sdk.MqRunner;
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

public final class h implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private static final String j = "^#*([0-9A-Fa-f]{6})|([0-9A-Fa-f]{3})";
    private static final int k = 32;

    /* renamed from: a  reason: collision with root package name */
    public k[] f2621a = new k[32];

    /* renamed from: b  reason: collision with root package name */
    public int f2622b = 0;

    /* renamed from: c  reason: collision with root package name */
    public HashMap[] f2623c = new HashMap[32];
    public j[] d = new j[32];
    public int e = 0;
    public HashMap<String, Integer> f = new HashMap<>();
    public HashMap<String, m> g = new HashMap<>();
    public HashMap<String, String> h = new HashMap<>();
    public int i = 1;
    private Context l;
    private g m;
    private HashMap<String, Integer> n = new HashMap<>();
    private LinearLayout o;

    private class a implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        private String f2633b;

        public a(String str) {
            this.f2633b = str;
        }

        private String a() {
            return this.f2633b;
        }

        public final void afterTextChanged(Editable editable) {
            MqRunner.getInstance().b(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setEvent(UiMessage.ControlEvent.newBuilder().setControlId(this.f2633b).setType(UiMessage.ControlEvent.Event_Type.ON_CHANGE).build()).setIsSuccess(true).build().toByteString());
            h.this.f2621a[h.this.f2622b].b();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public h(Context context) {
        this.l = context;
        this.m = g.a(context);
    }

    private void a(int i2, Object... objArr) {
        ExToast.makeText(this.l, (CharSequence) String.format(this.l.getString(i2), objArr), (int) ExToast.LENGTH_LONG).show();
    }

    private void a(String str) {
        if (this.n.get(str) != null) {
            a(true);
        } else if (this.f2623c[this.f2622b].get(str) == null) {
            a(false);
        } else {
            View b2 = this.f2621a[this.f2622b].b(str);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b2.getLayoutParams();
            layoutParams.width = -1;
            b2.setLayoutParams(layoutParams);
        }
    }

    private void a(String str, int i2) {
        boolean z = true;
        if (this.f.get(str) == null) {
            z = false;
            a(R.string.ui_show_not_found_float, str);
        } else {
            this.d[this.f.get(str).intValue()].setOpacity(i2);
        }
        a(z);
    }

    private void a(final String str, int i2, int i3) {
        this.f2622b++;
        this.f2621a[this.f2622b] = this.m.a(str, i2, i3);
        this.n.put(str, Integer.valueOf(this.f2622b));
        this.f2623c[this.f2622b] = new HashMap();
        this.f2621a[this.f2622b].f2657b = new View.OnClickListener() {
            public final void onClick(View view) {
                MqRunner.getInstance().b(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setIsSuccess(true).setEvent(UiMessage.ControlEvent.newBuilder().setControlId(r6).setType(UiMessage.ControlEvent.Event_Type.ON_CLOSE_CONTINUE).build()).build().toByteString());
            }
        };
        this.f2621a[this.f2622b].f2656a = new View.OnClickListener() {
            public final void onClick(View view) {
                for (int i = 31; i > 0; i--) {
                    if (h.this.f2621a[i] != null) {
                        UiMessage.UiToCommand build = UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setEvent(UiMessage.ControlEvent.newBuilder().setControlId(r6).setType(UiMessage.ControlEvent.Event_Type.ON_CLOSE_EXIT).build()).setIsSuccess(true).build();
                        MqRunner.getInstance().b(build.toByteString());
                        new StringBuilder("exit event: ").append(build);
                    }
                }
            }
        };
    }

    private void a(String str, int i2, int i3, int i4, int i5) {
        if (this.f.get(str) != null) {
            if (this.d[this.f.get(str).intValue()].d) {
                this.d[this.f.get(str).intValue()].b();
            }
            Iterator<Map.Entry<String, String>> it = this.h.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                String str2 = (String) next.getKey();
                String str3 = (String) next.getValue();
                StringBuilder sb = new StringBuilder("doNewFloat key:");
                sb.append(str2);
                sb.append(" parentTag:");
                sb.append(str3);
                sb.append(" tag:");
                sb.append(str);
                if (str3.compareTo(str) == 0) {
                    it.remove();
                    this.g.remove(str2);
                }
            }
            this.d[this.f.get(str).intValue()] = this.m.a(str, i2, i3, i4, i5);
            return;
        }
        this.e++;
        this.d[this.e] = this.m.a(str, i2, i3, i4, i5);
        this.f.put(str, Integer.valueOf(this.e));
    }

    public static void a(String str, UiMessage.ControlEvent.Event_Type event_Type) {
        MqRunner.getInstance().c(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setEvent(UiMessage.ControlEvent.newBuilder().setControlId(str).setType(event_Type).build()).setIsSuccess(true).build().toByteString());
    }

    private void a(String str, boolean z) {
        boolean z2 = true;
        if (this.f.get(str) == null) {
            z2 = false;
            a(R.string.ui_show_not_found_float, str);
        } else {
            this.d[this.f.get(str).intValue()].e = z;
        }
        a(z2);
    }

    private static void a(boolean z) {
        MqRunner.getInstance().a(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.RSP_MSG).setIsSuccess(z).build().toByteString());
    }

    private boolean a(String str, String str2) {
        if (this.n.get(str) == null) {
            a(R.string.ui_show_not_found_ui, str);
            return false;
        }
        this.f2621a[this.n.get(str).intValue()].a(str2);
        return true;
    }

    private int b() {
        int i2 = this.i + 1;
        this.i = i2;
        return i2;
    }

    private void b(String str) {
        if (this.f2621a[this.f2622b] == null) {
            a(false);
            return;
        }
        View b2 = this.f2621a[this.f2622b].b(str);
        if (b2 == null) {
            a(false);
            return;
        }
        boolean isEnabled = b2.isEnabled();
        if (this.f2623c[this.f2622b].get(str) == m.EDIT_TEXT) {
            isEnabled = ((EditText) b2).isFocusable();
        }
        MqRunner.getInstance().a(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.RSP_MSG).setIsSuccess(true).addVarTable(UiMessage.ControlVar.newBuilder().setControlId(str).setType(UiMessage.ControlVar.Data_Type.BOOL).setBoolValue(isEnabled).build()).build().toByteString());
    }

    private void b(String str, int i2) {
        if (this.f.get(str) == null) {
            a(R.string.ui_show_not_found_float, str);
            a(false);
            return;
        }
        j jVar = this.d[this.f.get(str).intValue()];
        jVar.g = (float) i2;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(new float[]{jVar.g, jVar.g, jVar.g, jVar.g, jVar.g, jVar.g, jVar.g, jVar.g});
        try {
            gradientDrawable.setColor(jVar.f);
        } catch (Exception unused) {
        }
        if (Build.VERSION.SDK_INT >= 16) {
            jVar.f2647c.setBackground(gradientDrawable);
        }
        jVar.f2647c.getBackground().setAlpha((jVar.h * 255) / 100);
        this.d[this.f.get(str).intValue()].e();
        a(true);
    }

    private void b(String str, String str2) {
        if (!str2.matches(j)) {
            a(R.string.ui_show_invalid_color_value, new Object[0]);
            a(false);
            return;
        }
        if (!str2.startsWith("#")) {
            str2 = "#" + str2;
        }
        int a2 = c.a(Color.parseColor(str2));
        if (this.f.get(str) != null) {
            j jVar = this.d[this.f.get(str).intValue()];
            jVar.f = a2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadii(new float[]{jVar.g, jVar.g, jVar.g, jVar.g, jVar.g, jVar.g, jVar.g, jVar.g});
            try {
                gradientDrawable.setColor(jVar.f);
            } catch (Exception unused) {
            }
            if (Build.VERSION.SDK_INT >= 16) {
                jVar.f2647c.setBackground(gradientDrawable);
            }
            jVar.f2647c.getBackground().setAlpha((jVar.h * 255) / 100);
            this.d[this.f.get(str).intValue()].e();
        } else {
            String str3 = this.h.get(str);
            if (str3 == null) {
                a(false);
                return;
            }
            View a3 = this.d[this.f.get(str3).intValue()].a(str);
            if (a3 == null) {
                a(false);
                return;
            } else if (this.g.get(str) == m.BUTTON) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadii(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f});
                gradientDrawable2.setColor(a2);
                a3.setBackground(gradientDrawable2);
            } else if (this.g.get(str) != m.SPINNER) {
                a3.setBackgroundColor(a2);
            }
        }
        a(true);
    }

    private boolean b(UiMessage.CommandToUi commandToUi) {
        int i2;
        int i3 = 0;
        if (this.f2621a[this.f2622b] == null) {
            return false;
        }
        String controlId = commandToUi.getControlId();
        View b2 = this.f2621a[this.f2622b].b(controlId);
        if (b2 == null) {
            a(R.string.ui_show_not_found_widget, controlId);
            return false;
        }
        switch (commandToUi.getCommand()) {
            case SET_TEXT_VIEW:
                if (this.f2623c[this.f2622b].get(controlId) == m.TEXT_VIEW) {
                    TextView textView = (TextView) b2;
                    textView.setText(commandToUi.getText());
                    textView.setLayoutParams(new LinearLayout.LayoutParams(commandToUi.getWidth(), commandToUi.getHeight()));
                    break;
                } else {
                    return false;
                }
            case SET_EDIT_TEXT:
                if (this.f2623c[this.f2622b].get(controlId) != m.EDIT_TEXT) {
                    return false;
                }
                EditText editText = (EditText) b2;
                editText.setText(commandToUi.getText());
                editText.setLayoutParams(new LinearLayout.LayoutParams(commandToUi.getWidth(), commandToUi.getHeight()));
                return true;
            case SET_BOTTON:
                if (this.f2623c[this.f2622b].get(controlId) != m.BUTTON) {
                    return false;
                }
                Button button = (Button) b2;
                button.setText(commandToUi.getText());
                button.setLayoutParams(new LinearLayout.LayoutParams(commandToUi.getWidth(), commandToUi.getHeight()));
                return true;
            case SET_CHECK_BOX:
                if (this.f2623c[this.f2622b].get(controlId) != m.CHECK_BOX) {
                    return false;
                }
                CheckBox checkBox = (CheckBox) b2;
                checkBox.setChecked(commandToUi.getDefaultCheckStatus());
                checkBox.setText(commandToUi.getText());
                checkBox.getLayoutParams().width = commandToUi.getWidth();
                checkBox.getLayoutParams().height = commandToUi.getHeight();
                return true;
            case SET_IMAGE_VIEW:
                if (this.f2623c[this.f2622b].get(controlId) != m.IMAGE_VIEW) {
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
                if (this.f2623c[this.f2622b].get(controlId) != m.WEB_VIEW) {
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
                if (this.f2623c[this.f2622b].get(controlId) != m.RADIIO_GROUP) {
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
                    RadioButton radioButton = (RadioButton) LayoutInflater.from(this.l).inflate(R.layout.ui_show_radio_button, (ViewGroup) null);
                    radioButton.setId(i4);
                    radioButton.setText(itemTextList.get(i4));
                    radioButton.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                    radioButton.setPadding(0, c(), 0, c());
                    radioGroup.addView(radioButton);
                }
                if (commandToUi.getDefaultItemIndex() < radioGroup.getChildCount()) {
                    i3 = commandToUi.getDefaultItemIndex();
                }
                ((RadioButton) radioGroup.findViewById(i3)).setChecked(true);
                return true;
            case SET_SPINNER:
                if (this.f2623c[this.f2622b].get(controlId) != m.SPINNER) {
                    return false;
                }
                Spinner spinner = (Spinner) b2;
                ArrayAdapter arrayAdapter = new ArrayAdapter(this.l, R.layout.ui_show_spinner_dropdown_item, commandToUi.getItemTextList());
                spinner.setAdapter(arrayAdapter);
                if (commandToUi.getDefaultItemIndex() < arrayAdapter.getCount()) {
                    i3 = commandToUi.getDefaultItemIndex();
                }
                spinner.setSelection(i3);
                return true;
            case SET_ENABLED:
                if (this.f2623c[this.f2622b].get(controlId) == m.RADIIO_GROUP) {
                    b2.setEnabled(commandToUi.getEnabledStatus());
                    RadioGroup radioGroup2 = (RadioGroup) b2;
                    while (i3 < radioGroup2.getChildCount()) {
                        radioGroup2.getChildAt(i3).setEnabled(commandToUi.getEnabledStatus());
                        i3++;
                    }
                    break;
                } else if (this.f2623c[this.f2622b].get(controlId) == m.EDIT_TEXT) {
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
                if (this.f2623c[this.f2622b].get(controlId) != m.LINE) {
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

    private int c() {
        return (int) ((((float) this.l.getResources().getDisplayMetrics().densityDpi) / 160.0f) * 5.0f);
    }

    private void c(UiMessage.CommandToUi commandToUi) {
        if (this.f2621a[this.f2622b] == null) {
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
        if (this.n.get(controlId) == null || this.f2621a[this.n.get(controlId).intValue()] == null) {
            View b2 = this.f2621a[this.f2622b].b(controlId);
            if (b2 == null) {
                a(false);
            } else if (this.f2623c[this.f2622b].get(controlId) == null) {
                a(false);
            } else {
                switch ((m) this.f2623c[this.f2622b].get(controlId)) {
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
            this.f2621a[this.n.get(controlId).intValue()].a(create, fontSize);
            a(true);
        }
    }

    private void c(String str) {
        int i2;
        if (this.f2621a[this.f2622b] == null) {
            a(false);
            return;
        }
        View b2 = this.f2621a[this.f2622b].b(str);
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
            MqRunner.getInstance().a(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.RSP_MSG).setIsSuccess(true).addVarTable(UiMessage.ControlVar.newBuilder().setControlId(str).setType(UiMessage.ControlVar.Data_Type.INT).setIntValue(i2).build()).build().toByteString());
        }
        i2 = 1;
        MqRunner.getInstance().a(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.RSP_MSG).setIsSuccess(true).addVarTable(UiMessage.ControlVar.newBuilder().setControlId(str).setType(UiMessage.ControlVar.Data_Type.INT).setIntValue(i2).build()).build().toByteString());
    }

    private boolean c(String str, String str2) {
        View a2;
        if (this.f.get(str) != null) {
            j jVar = this.d[this.f.get(str).intValue()];
            jVar.i = str2;
            Bitmap decodeFile = BitmapFactory.decodeFile(jVar.i);
            if (Build.VERSION.SDK_INT >= 16) {
                jVar.f2647c.setBackground(new BitmapDrawable(decodeFile));
            }
            jVar.f2647c.getBackground().setAlpha((jVar.h * 255) / 100);
            this.d[this.f.get(str).intValue()].e();
            return true;
        }
        String str3 = this.h.get(str);
        if (str3 == null || (a2 = this.d[this.f.get(str3).intValue()].a(str)) == null) {
            return false;
        }
        if (this.g.get(str) == m.IMAGE_VIEW) {
            ((ImageView) a2).setImageURI(Uri.fromFile(new File(str2)));
        }
        return true;
    }

    private void d() {
        this.f.clear();
        this.g.clear();
        this.h.clear();
        a();
        this.f2622b = 0;
        this.i = 1;
        for (int i2 = 0; i2 < 32; i2++) {
            this.f2621a[i2] = null;
            if (this.f2623c[i2] != null) {
                this.f2623c[i2].clear();
            }
        }
        this.d = new j[32];
        this.e = 0;
    }

    private void d(UiMessage.CommandToUi commandToUi) {
        if (this.f2621a[this.f2622b] == null) {
            a(false);
            return;
        }
        String controlId = commandToUi.getControlId();
        commandToUi.getText();
        View b2 = this.f2621a[this.f2622b].b(controlId);
        if (b2 == null) {
            a(false);
        } else if (this.f2623c[this.f2622b].get(controlId) != m.EDIT_TEXT) {
            a(false);
        } else {
            ((EditText) b2).setInputType(commandToUi.getEditInputType());
            a(true);
        }
    }

    private void d(String str) {
        if (this.f2621a[this.f2622b] == null) {
            a(false);
            return;
        }
        View b2 = this.f2621a[this.f2622b].b(str);
        if (b2 == null) {
            a(false);
            return;
        }
        int a2 = c.a(b2.getSolidColor());
        MqRunner.getInstance().a(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.RSP_MSG).setIsSuccess(true).addVarTable(UiMessage.ControlVar.newBuilder().setControlId(str).setType(UiMessage.ControlVar.Data_Type.STRING).setStringValue("#" + Integer.toHexString(a2 & ViewCompat.MEASURED_SIZE_MASK)).build()).build().toByteString());
    }

    private void e(UiMessage.CommandToUi commandToUi) {
        if (this.f2621a[this.f2622b] == null) {
            a(false);
            return;
        }
        String controlId = commandToUi.getControlId();
        String text = commandToUi.getText();
        View b2 = this.f2621a[this.f2622b].b(controlId);
        if (b2 == null) {
            a(false);
        } else if (this.f2623c[this.f2622b].get(controlId) == null) {
            a(false);
        } else {
            switch ((m) this.f2623c[this.f2622b].get(controlId)) {
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
                        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this.l, R.layout.ui_show_spinner_dropdown_item, arrayList);
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

    private void e(String str) throws JSONException, IOException {
        if (this.f2621a[this.f2622b] != null) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : this.f2623c[this.f2622b].entrySet()) {
                String str2 = (String) entry.getKey();
                int i2 = AnonymousClass4.f2631b[((m) entry.getValue()).ordinal()];
                if (i2 != 2) {
                    switch (i2) {
                        case 4:
                            jSONObject.put(str2, ((CheckBox) this.f2621a[this.f2622b].b(str2)).isChecked());
                            break;
                        case 5:
                            jSONObject.put(str2, ((RadioGroup) this.f2621a[this.f2622b].b(str2)).getCheckedRadioButtonId());
                            break;
                        case 6:
                            jSONObject.put(str2, ((Spinner) this.f2621a[this.f2622b].b(str2)).getSelectedItemId());
                            break;
                    }
                } else {
                    jSONObject.put(str2, ((EditText) this.f2621a[this.f2622b].b(str2)).getText().toString());
                }
            }
            FileUtils.writeStringToFile(new File(str), jSONObject.toString());
        }
    }

    private void f(UiMessage.CommandToUi commandToUi) {
        if (this.f2621a[this.f2622b] == null) {
            a(false);
            return;
        }
        String controlId = commandToUi.getControlId();
        String color = commandToUi.getColor();
        if (!color.matches(j)) {
            a(R.string.ui_show_invalid_color_value, new Object[0]);
            a(false);
            return;
        }
        if (!color.startsWith("#")) {
            color = "#" + color;
        }
        int a2 = c.a(Color.parseColor(color));
        if (this.n.get(controlId) != null) {
            this.f2621a[this.n.get(controlId).intValue()].a(a2);
            a(true);
            return;
        }
        View b2 = this.f2621a[this.f2622b].b(controlId);
        if (b2 == null) {
            a(false);
            return;
        }
        switch ((m) this.f2623c[this.f2622b].get(controlId)) {
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

    private void f(String str) throws IOException, JSONException {
        if (this.f2623c[this.f2622b] != null) {
            JSONObject jSONObject = new JSONObject(FileUtils.readFileToString(new File(str)));
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (this.f2623c[this.f2622b].get(next) != null) {
                    int i2 = AnonymousClass4.f2631b[((m) this.f2623c[this.f2622b].get(next)).ordinal()];
                    if (i2 != 2) {
                        switch (i2) {
                            case 4:
                                ((CheckBox) this.f2621a[this.f2622b].b(next)).setChecked(jSONObject.getBoolean(next));
                                break;
                            case 5:
                                RadioGroup radioGroup = (RadioGroup) this.f2621a[this.f2622b].b(next);
                                if (jSONObject.getInt(next) >= radioGroup.getChildCount()) {
                                    break;
                                } else {
                                    ((RadioButton) radioGroup.findViewById(jSONObject.getInt(next))).setChecked(true);
                                    break;
                                }
                            case 6:
                                Spinner spinner = (Spinner) this.f2621a[this.f2622b].b(next);
                                if (jSONObject.getInt(next) >= spinner.getCount()) {
                                    break;
                                } else {
                                    spinner.setSelection(jSONObject.getInt(next));
                                    break;
                                }
                        }
                    } else {
                        ((EditText) this.f2621a[this.f2622b].b(next)).setText(jSONObject.getString(next));
                    }
                }
            }
        }
    }

    private void g(UiMessage.CommandToUi commandToUi) {
        if (this.f2621a[this.f2622b] == null) {
            a(false);
            return;
        }
        String controlId = commandToUi.getControlId();
        View b2 = this.f2621a[this.f2622b].b(controlId);
        if (b2 == null) {
            a(false);
            return;
        }
        String color = commandToUi.getColor();
        if (!color.matches(j)) {
            a(R.string.ui_show_invalid_color_value, new Object[0]);
            a(false);
            return;
        }
        if (!color.startsWith("#")) {
            color = "#" + color;
        }
        int a2 = c.a(Color.parseColor(color));
        if (this.f2623c[this.f2622b].get(controlId) == m.BUTTON) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(a2);
            gradientDrawable.setCornerRadius((float) c());
            b2.setBackground(gradientDrawable);
            a(true);
            return;
        }
        if (this.f2623c[this.f2622b].get(controlId) != m.SPINNER) {
            b2.setBackgroundColor(a2);
        }
        a(true);
    }

    private void g(String str) {
        if (this.n.get(str) == null) {
            a(R.string.ui_show_not_found_ui, str);
            a(false);
        } else if (this.f2621a[this.n.get(str).intValue()].f2658c) {
            a(false);
        } else {
            this.f2621a[this.n.get(str).intValue()].c();
            a(true);
            MqRunner.getInstance().b(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setIsSuccess(true).setEvent(UiMessage.ControlEvent.newBuilder().setControlId(str).setType(UiMessage.ControlEvent.Event_Type.ON_SHOW).build()).build().toByteString());
        }
    }

    private void h(UiMessage.CommandToUi commandToUi) {
        if (this.f2621a[this.f2622b] == null) {
            a(false);
            return;
        }
        View b2 = this.f2621a[this.f2622b].b(commandToUi.getControlId());
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
        if (this.n.get(str) == null) {
            a(R.string.ui_show_not_found_ui, str);
            a(false);
            return;
        }
        MqRunner.getInstance().a(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.RSP_MSG).setIsSuccess(true).addVarTable(UiMessage.ControlVar.newBuilder().setControlId(str).setType(UiMessage.ControlVar.Data_Type.STRING).setStringValue(this.f2621a[this.n.get(str).intValue()].a()).build()).build().toByteString());
    }

    private void i(UiMessage.CommandToUi commandToUi) {
        if (this.f2621a[this.f2622b] == null) {
            a(false);
            return;
        }
        View b2 = this.f2621a[this.f2622b].b(commandToUi.getControlId());
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
        j(str);
        MqRunner.getInstance().b(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setIsSuccess(true).setEvent(UiMessage.ControlEvent.newBuilder().setControlId(str).setType(UiMessage.ControlEvent.Event_Type.ON_CLOSE_CONTINUE).build()).build().toByteString());
    }

    private void j(UiMessage.CommandToUi commandToUi) {
        TextPaint textPaint;
        if (this.f2621a[this.f2622b] == null) {
            a(false);
            return;
        }
        String controlId = commandToUi.getControlId();
        if (this.f2623c[this.f2622b].get(controlId) == null) {
            a(false);
            return;
        }
        switch ((m) this.f2623c[this.f2622b].get(controlId)) {
            case TEXT_VIEW:
            case EDIT_TEXT:
            case BUTTON:
                textPaint = ((TextView) this.f2621a[this.f2622b].b(controlId)).getPaint();
                break;
            case CHECK_BOX:
                textPaint = ((CheckBox) this.f2621a[this.f2622b].b(controlId)).getPaint();
                break;
            case RADIIO_GROUP:
                RadioButton radioButton = (RadioButton) ((RadioGroup) this.f2621a[this.f2622b].b(controlId)).findViewById(commandToUi.getItemIndex());
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
        MqRunner.getInstance().a(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.RSP_MSG).setIsSuccess(true).addVarTable(UiMessage.ControlVar.newBuilder().setControlId(controlId).setType(UiMessage.ControlVar.Data_Type.STRING).setStringValue(String.format("%02X%02X%02X", new Object[]{Integer.valueOf(Color.blue(color)), Integer.valueOf(Color.green(color)), Integer.valueOf(Color.red(color))})).build()).build().toByteString());
    }

    private boolean j(String str) {
        if (this.n.get(str) == null) {
            a(R.string.ui_show_not_found_ui, str);
            return false;
        } else if (!this.f2621a[this.n.get(str).intValue()].f2658c) {
            return false;
        } else {
            this.f2621a[this.n.get(str).intValue()].e();
            if (this.n.get(str).intValue() == this.f2622b) {
                do {
                    this.f2622b--;
                    if (this.f2622b <= 0 || this.f2621a[this.f2622b] != null) {
                    }
                    this.f2622b--;
                    break;
                } while (this.f2621a[this.f2622b] != null);
                if (this.f2622b < 0) {
                    this.f2622b = 0;
                }
            }
            return true;
        }
    }

    private void k(UiMessage.CommandToUi commandToUi) {
        String str;
        CharSequence charSequence;
        if (this.f2621a[this.f2622b] == null) {
            a(false);
            return;
        }
        String controlId = commandToUi.getControlId();
        if (this.f2623c[this.f2622b].get(controlId) == null) {
            a(false);
            return;
        }
        switch ((m) this.f2623c[this.f2622b].get(controlId)) {
            case TEXT_VIEW:
            case EDIT_TEXT:
            case BUTTON:
                charSequence = ((TextView) this.f2621a[this.f2622b].b(controlId)).getText();
                break;
            case CHECK_BOX:
                charSequence = ((CheckBox) this.f2621a[this.f2622b].b(controlId)).getText();
                break;
            case RADIIO_GROUP:
                RadioButton radioButton = (RadioButton) ((RadioGroup) this.f2621a[this.f2622b].b(controlId)).findViewById(commandToUi.getItemIndex());
                if (radioButton != null) {
                    charSequence = radioButton.getText();
                    break;
                } else {
                    a(false);
                    return;
                }
            case SPINNER:
                Spinner spinner = (Spinner) this.f2621a[this.f2622b].b(controlId);
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
        MqRunner.getInstance().a(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.RSP_MSG).setIsSuccess(true).addVarTable(UiMessage.ControlVar.newBuilder().setControlId(controlId).setType(UiMessage.ControlVar.Data_Type.STRING).setStringValue(str).build()).build().toByteString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x009f, code lost:
        r1.setIntValue(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00d6, code lost:
        r0.addVarTable(r2.build());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00dd, code lost:
        new java.lang.StringBuilder("Ui.getValue result: ").append(r0.build());
        r9 = com.cyjh.mq.sdk.MqRunner.getInstance();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void k(java.lang.String r9) {
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
            java.util.HashMap[] r6 = r8.f2623c
            r6 = r6[r4]
            if (r6 == 0) goto L_0x0032
            java.util.HashMap[] r5 = r8.f2623c
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
            if (r5 != 0) goto L_0x0067
            int r2 = com.cyjh.mqsdk.R.string.ui_show_not_found_widget
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r3] = r9
            r8.a((int) r2, (java.lang.Object[]) r1)
            com.cyjh.mq.sdk.MqRunner r9 = com.cyjh.mq.sdk.MqRunner.getInstance()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r3)
        L_0x005b:
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r0 = r0.build()
            com.google.protobuf.ByteString r0 = r0.toByteString()
            r9.a((com.google.protobuf.ByteString) r0)
            return
        L_0x0067:
            int[] r1 = com.cyjh.mobileanjian.ipc.ui.h.AnonymousClass4.f2631b
            int r5 = r5.ordinal()
            r1 = r1[r5]
            switch(r1) {
                case 1: goto L_0x00bb;
                case 2: goto L_0x00bb;
                case 3: goto L_0x00bb;
                case 4: goto L_0x00a3;
                case 5: goto L_0x008b;
                case 6: goto L_0x0076;
                default: goto L_0x0072;
            }
        L_0x0072:
            r0.setIsSuccess(r3)
            goto L_0x00dd
        L_0x0076:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2621a
            r1 = r1[r4]
            android.view.View r9 = r1.b((java.lang.String) r9)
            android.widget.Spinner r9 = (android.widget.Spinner) r9
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.INT
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r1 = r2.setType(r1)
            int r9 = r9.getSelectedItemPosition()
            goto L_0x009f
        L_0x008b:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2621a
            r1 = r1[r4]
            android.view.View r9 = r1.b((java.lang.String) r9)
            android.widget.RadioGroup r9 = (android.widget.RadioGroup) r9
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.INT
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r1 = r2.setType(r1)
            int r9 = r9.getCheckedRadioButtonId()
        L_0x009f:
            r1.setIntValue(r9)
            goto L_0x00d6
        L_0x00a3:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2621a
            r1 = r1[r4]
            android.view.View r9 = r1.b((java.lang.String) r9)
            android.widget.CheckBox r9 = (android.widget.CheckBox) r9
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.BOOL
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r1 = r2.setType(r1)
            boolean r9 = r9.isChecked()
            r1.setBoolValue(r9)
            goto L_0x00d6
        L_0x00bb:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r8.f2621a
            r1 = r1[r4]
            android.view.View r9 = r1.b((java.lang.String) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.STRING
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r1 = r2.setType(r1)
            java.lang.CharSequence r9 = r9.getText()
            java.lang.String r9 = r9.toString()
            r1.setStringValue(r9)
        L_0x00d6:
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar r9 = r2.build()
            r0.addVarTable((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar) r9)
        L_0x00dd:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r1 = "Ui.getValue result: "
            r9.<init>(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r1 = r0.build()
            r9.append(r1)
            com.cyjh.mq.sdk.MqRunner r9 = com.cyjh.mq.sdk.MqRunner.getInstance()
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.ui.h.k(java.lang.String):void");
    }

    private void l(UiMessage.CommandToUi commandToUi) {
        String controlId = commandToUi.getControlId();
        String color = commandToUi.getColor();
        if (this.n.get(controlId) == null) {
            a(R.string.ui_show_not_found_ui, controlId);
            a(false);
        } else if (!color.matches(j)) {
            a(R.string.ui_show_invalid_color_value, new Object[0]);
            a(false);
        } else {
            if (!color.startsWith("#")) {
                color = "#" + color;
            }
            this.f2621a[this.n.get(controlId).intValue()].b(c.a(Color.parseColor(color)));
            a(true);
        }
    }

    private void l(String str) {
        if (this.f.get(str) == null) {
            a(R.string.ui_show_not_found_float, str);
            a(false);
        } else if (this.d[this.f.get(str).intValue()].d) {
            a(false);
        } else {
            j jVar = this.d[this.f.get(str).intValue()];
            String str2 = (String) jVar.getTag();
            if (jVar.i == null || jVar.i.length() <= 0) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadii(new float[]{jVar.g, jVar.g, jVar.g, jVar.g, jVar.g, jVar.g, jVar.g, jVar.g});
                try {
                    gradientDrawable.setColor(jVar.f);
                } catch (Exception unused) {
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    jVar.f2647c.setBackground(gradientDrawable);
                }
            } else {
                Bitmap decodeFile = BitmapFactory.decodeFile(jVar.i);
                if (Build.VERSION.SDK_INT >= 16) {
                    jVar.f2647c.setBackground(new BitmapDrawable(decodeFile));
                }
            }
            jVar.d = true;
            jVar.f2647c.setOnTouchListener(new View.OnTouchListener(str2) {

                /* renamed from: a */
                int f2648a;

                /* renamed from: b */
                int f2649b;

                /* renamed from: c */
                int f2650c;
                int d;
                long e;
                long f;
                Runnable g;

                public final boolean onTouch(
/*
Method generation error in method: com.cyjh.mobileanjian.ipc.ui.j.1.onTouch(android.view.View, android.view.MotionEvent):boolean, dex: classes.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.cyjh.mobileanjian.ipc.ui.j.1.onTouch(android.view.View, android.view.MotionEvent):boolean, class status: UNLOADED
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
                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
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
            jVar.f2645a.addView(jVar.f2647c, jVar.f2646b);
            jVar.f2647c.getBackground().setAlpha((jVar.h * 255) / 100);
            a(true);
            a(str, UiMessage.ControlEvent.Event_Type.ON_SHOW);
        }
    }

    private void m(UiMessage.CommandToUi commandToUi) {
        String controlId = commandToUi.getControlId();
        String strParam = commandToUi.getStrParam();
        if (!strParam.matches(j)) {
            a(R.string.ui_show_invalid_color_value, new Object[0]);
            a(false);
            return;
        }
        if (!strParam.startsWith("#")) {
            strParam = "#" + strParam;
        }
        int a2 = c.a(Color.parseColor(strParam));
        String str = this.h.get(controlId);
        if (str == null) {
            a(false);
            return;
        }
        View a3 = this.d[this.f.get(str).intValue()].a(controlId);
        if (a3 == null) {
            a(false);
            return;
        }
        if (this.g.get(controlId) == m.BUTTON) {
            ((Button) a3).setTextColor(a2);
        }
        if (this.g.get(controlId) == m.TEXT_VIEW) {
            ((TextView) a3).setTextColor(a2);
        }
        this.d[this.f.get(str).intValue()].e();
        a(true);
    }

    private void m(String str) {
        if (this.f.get(str) == null) {
            a(R.string.ui_show_not_found_float, str);
            a(false);
        } else if (!this.d[this.f.get(str).intValue()].d) {
            a(true);
        } else {
            j jVar = this.d[this.f.get(str).intValue()];
            if (jVar.f2647c != null && jVar.d) {
                jVar.f2645a.removeView(jVar.f2647c);
                jVar.f2645a.addView(jVar.f2647c, jVar.f2646b);
            }
            a(true);
        }
    }

    private void n(String str) {
        if (this.f.get(str) == null) {
            a(R.string.ui_show_not_found_float, str);
            a(false);
        } else if (!this.d[this.f.get(str).intValue()].d) {
            a(false);
        } else {
            this.d[this.f.get(str).intValue()].b();
            a(true);
        }
    }

    private boolean n(UiMessage.CommandToUi commandToUi) {
        String controlId = commandToUi.getControlId();
        String str = this.h.get(controlId);
        new StringBuilder("doReSetView value: ").append(commandToUi.getCommand().toString());
        if (str == null) {
            a(false);
            return false;
        }
        new StringBuilder("doReSetView value: ").append(commandToUi.getCommand().toString());
        View a2 = this.d[this.f.get(str).intValue()].a(controlId);
        if (a2 == null) {
            a(false);
            return false;
        }
        new StringBuilder("doReSetView value: ").append(commandToUi.getCommand().toString());
        switch (commandToUi.getCommand()) {
            case SET_FW_BUTTON:
                if (this.g.get(controlId) == m.BUTTON) {
                    Button button = (Button) a2;
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) a2.getLayoutParams();
                    layoutParams.width = commandToUi.getWidth();
                    layoutParams.height = commandToUi.getHeight();
                    button.setLayoutParams(layoutParams);
                    button.setText(commandToUi.getText());
                    button.setX((float) commandToUi.getLeft());
                    button.setY((float) commandToUi.getTop());
                    break;
                }
                break;
            case SET_FW_TEXT_VIEW:
                if (this.g.get(controlId) == m.TEXT_VIEW) {
                    TextView textView = (TextView) a2;
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) a2.getLayoutParams();
                    layoutParams2.width = commandToUi.getWidth();
                    layoutParams2.height = commandToUi.getHeight();
                    textView.setLayoutParams(layoutParams2);
                    textView.setText(commandToUi.getText());
                    textView.setX((float) commandToUi.getLeft());
                    textView.setY((float) commandToUi.getTop());
                    break;
                }
                break;
            case SET_FW_IMAGE_VIEW:
                if (this.g.get(controlId) == m.IMAGE_VIEW) {
                    ImageView imageView = (ImageView) a2;
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                    layoutParams3.width = commandToUi.getWidth();
                    layoutParams3.height = commandToUi.getHeight();
                    imageView.setLayoutParams(layoutParams3);
                    imageView.setX((float) commandToUi.getLeft());
                    imageView.setY((float) commandToUi.getTop());
                    imageView.setImageURI(Uri.fromFile(new File(commandToUi.getText())));
                    break;
                }
                break;
        }
        this.d[this.f.get(str).intValue()].e();
        a(true);
        return true;
    }

    private void o(String str) {
        if (this.f.get(str) == null) {
            a(R.string.ui_show_not_found_float, str);
            a(false);
            return;
        }
        this.d[this.f.get(str).intValue()].c();
        this.f.remove(str);
        a(str, UiMessage.ControlEvent.Event_Type.ON_CLOSE);
        a(true);
    }

    private boolean o(UiMessage.CommandToUi commandToUi) {
        View a2;
        String controlId = commandToUi.getControlId();
        String str = this.h.get(controlId);
        boolean z = false;
        if (str == null) {
            return false;
        }
        try {
            j jVar = this.d[this.f.get(str).intValue()];
            if (jVar == null || (a2 = jVar.a(controlId)) == null) {
                return false;
            }
            int i2 = AnonymousClass4.f2631b[this.g.get(controlId).ordinal()];
            z = true;
            if (i2 == 1 || i2 == 3) {
                new StringBuilder("setFloatTextSize value: ").append(commandToUi.getFontSize());
                ((TextView) a2).setTextSize(2, (float) commandToUi.getFontSize());
            }
            jVar.e();
            return z;
        } catch (Exception unused) {
        }
    }

    private void p(String str) {
        JSONObject jSONObject = new JSONObject();
        if (this.f.get(str) != null) {
            try {
                WindowManager.LayoutParams params = this.d[this.f.get(str).intValue()].getParams();
                jSONObject.put("Left", params.x);
                jSONObject.put("Top", params.y);
                jSONObject.put("Width", params.width);
                jSONObject.put("Height", params.height);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            new StringBuilder("FWGetValue json: ").append(jSONObject.toString());
        } else {
            String str2 = this.h.get(str);
            m mVar = this.g.get(str);
            if (mVar == null) {
                a(R.string.ui_show_not_found_widget, str);
            } else {
                int i2 = AnonymousClass4.f2631b[mVar.ordinal()];
                if (i2 == 1) {
                    TextView textView = (TextView) this.d[this.f.get(str2).intValue()].a(str);
                    jSONObject.put("Left", textView.getLeft());
                    jSONObject.put("Top", textView.getTop());
                    jSONObject.put("Text", textView.getText());
                    jSONObject.put("Width", textView.getWidth());
                    jSONObject.put("Height", textView.getHeight());
                    new StringBuilder("FWGetValue json: ").append(jSONObject.toString());
                } else if (i2 != 3) {
                    if (i2 == 7) {
                        ImageView imageView = (ImageView) this.d[this.f.get(str2).intValue()].a(str);
                        jSONObject.put("Left", imageView.getLeft());
                        jSONObject.put("Top", imageView.getTop());
                        jSONObject.put("Width", imageView.getWidth());
                        jSONObject.put("Height", imageView.getHeight());
                    }
                    new StringBuilder("FWGetValue json: ").append(jSONObject.toString());
                } else {
                    Button button = (Button) this.d[this.f.get(str2).intValue()].a(str);
                    jSONObject.put("Left", button.getLeft());
                    jSONObject.put("Top", button.getTop());
                    jSONObject.put("Text", button.getText());
                    jSONObject.put("Width", button.getWidth());
                    jSONObject.put("Height", button.getHeight());
                    new StringBuilder("FWGetValue json: ").append(jSONObject.toString());
                }
            }
        }
        MqRunner.getInstance().c(jSONObject.toString());
    }

    private boolean p(UiMessage.CommandToUi commandToUi) {
        View a2;
        String controlId = commandToUi.getControlId();
        String str = this.h.get(controlId);
        if (str == null) {
            return false;
        }
        try {
            j jVar = this.d[this.f.get(str).intValue()];
            if (jVar == null || (a2 = jVar.a(controlId)) == null) {
                return false;
            }
            switch (commandToUi.getCommand()) {
                case SET_FW_ENABLE:
                    new StringBuilder("doFloatSetStatus ").append(commandToUi.getEnabledStatus());
                    a2.setEnabled(commandToUi.getEnabledStatus());
                    break;
                case SET_FW_VISIBLE:
                    new StringBuilder("doFloatSetStatus ").append(commandToUi.getVisibleStatus());
                    if (commandToUi.getVisibleStatus() == 0) {
                        a2.setVisibility(8);
                        break;
                    } else {
                        a2.setVisibility(0);
                        break;
                    }
            }
            jVar.e();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        if (r1.getVisibility() == 0) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0077, code lost:
        if (r1.isEnabled() != false) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0079, code lost:
        r3 = "true";
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean q(com.cyjh.mobileanjian.ipc.share.proto.UiMessage.CommandToUi r6) {
        /*
            r5 = this;
            java.lang.String r0 = r6.getControlId()
            java.util.HashMap<java.lang.String, java.lang.String> r1 = r5.h
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            r2 = 0
            if (r1 != 0) goto L_0x0010
            return r2
        L_0x0010:
            com.cyjh.mobileanjian.ipc.ui.j[] r3 = r5.d     // Catch:{ Exception -> 0x0083 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r4 = r5.f     // Catch:{ Exception -> 0x0083 }
            java.lang.Object r1 = r4.get(r1)     // Catch:{ Exception -> 0x0083 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x0083 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x0083 }
            r1 = r3[r1]     // Catch:{ Exception -> 0x0083 }
            if (r1 != 0) goto L_0x0023
            return r2
        L_0x0023:
            android.view.View r1 = r1.a((java.lang.String) r0)
            if (r1 != 0) goto L_0x002a
            return r2
        L_0x002a:
            java.lang.String r3 = "false"
            int[] r4 = com.cyjh.mobileanjian.ipc.ui.h.AnonymousClass4.f2630a
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$CommandToUi$Command_Type r6 = r6.getCommand()
            int r6 = r6.ordinal()
            r6 = r4[r6]
            r4 = 1
            switch(r6) {
                case 70: goto L_0x0073;
                case 71: goto L_0x0044;
                case 72: goto L_0x003d;
                default: goto L_0x003c;
            }
        L_0x003c:
            goto L_0x007b
        L_0x003d:
            int r6 = r1.getVisibility()
            if (r6 != 0) goto L_0x007b
            goto L_0x0079
        L_0x0044:
            java.util.HashMap<java.lang.String, com.cyjh.mobileanjian.ipc.ui.m> r6 = r5.g
            java.lang.Object r6 = r6.get(r0)
            com.cyjh.mobileanjian.ipc.ui.m r0 = com.cyjh.mobileanjian.ipc.ui.m.IMAGE_VIEW
            if (r6 == r0) goto L_0x007b
            android.widget.TextView r1 = (android.widget.TextView) r1
            int r6 = r1.getCurrentTextColor()
            int r6 = com.cyjh.mobileanjian.ipc.utils.c.a(r6)
            java.lang.String r0 = "%6s"
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r3 = 16777215(0xffffff, float:2.3509886E-38)
            r6 = r6 & r3
            java.lang.String r6 = java.lang.Integer.toHexString(r6)
            r1[r2] = r6
            java.lang.String r6 = java.lang.String.format(r0, r1)
            java.lang.String r0 = " "
            java.lang.String r1 = "0"
            java.lang.String r3 = r6.replace(r0, r1)
            goto L_0x007b
        L_0x0073:
            boolean r6 = r1.isEnabled()
            if (r6 == 0) goto L_0x007b
        L_0x0079:
            java.lang.String r3 = "true"
        L_0x007b:
            com.cyjh.mq.sdk.MqRunner r6 = com.cyjh.mq.sdk.MqRunner.getInstance()
            r6.c((java.lang.String) r3)
            return r4
        L_0x0083:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.ui.h.q(com.cyjh.mobileanjian.ipc.share.proto.UiMessage$CommandToUi):boolean");
    }

    private boolean r(UiMessage.CommandToUi commandToUi) {
        View a2;
        String controlId = commandToUi.getControlId();
        if (this.f.get(controlId) != null) {
            this.d[this.f.get(controlId).intValue()].setFloatLeft(commandToUi.getIntParam());
            return true;
        }
        String str = this.h.get(controlId);
        if (str == null || (a2 = this.d[this.f.get(str).intValue()].a(controlId)) == null) {
            return false;
        }
        if (this.g.get(controlId) != m.BUTTON && this.g.get(controlId) != m.TEXT_VIEW && this.g.get(controlId) != m.IMAGE_VIEW) {
            return true;
        }
        new StringBuilder("view.setX ").append(commandToUi.getIntParam());
        a2.setX((float) commandToUi.getIntParam());
        return true;
    }

    private boolean s(UiMessage.CommandToUi commandToUi) {
        View a2;
        String controlId = commandToUi.getControlId();
        if (this.f.get(controlId) != null) {
            this.d[this.f.get(controlId).intValue()].setFloatTop(commandToUi.getIntParam());
            return true;
        }
        String str = this.h.get(controlId);
        if (str == null || (a2 = this.d[this.f.get(str).intValue()].a(controlId)) == null) {
            return false;
        }
        if (this.g.get(controlId) != m.BUTTON && this.g.get(controlId) != m.TEXT_VIEW && this.g.get(controlId) != m.IMAGE_VIEW) {
            return true;
        }
        new StringBuilder("view.setY ").append(commandToUi.getIntParam());
        a2.setY((float) commandToUi.getIntParam());
        return true;
    }

    private boolean t(UiMessage.CommandToUi commandToUi) {
        View a2;
        String controlId = commandToUi.getControlId();
        if (this.f.get(controlId) != null) {
            this.d[this.f.get(controlId).intValue()].setFloatWidth(commandToUi.getIntParam());
            return true;
        }
        String str = this.h.get(controlId);
        if (str == null || (a2 = this.d[this.f.get(str).intValue()].a(controlId)) == null) {
            return false;
        }
        if (this.g.get(controlId) != m.BUTTON && this.g.get(controlId) != m.TEXT_VIEW && this.g.get(controlId) != m.IMAGE_VIEW) {
            return true;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) a2.getLayoutParams();
        layoutParams.width = commandToUi.getIntParam();
        a2.setLayoutParams(layoutParams);
        return true;
    }

    private boolean u(UiMessage.CommandToUi commandToUi) {
        View a2;
        String controlId = commandToUi.getControlId();
        if (this.f.get(controlId) != null) {
            this.d[this.f.get(controlId).intValue()].setFloatHeight(commandToUi.getIntParam());
            return true;
        }
        String str = this.h.get(controlId);
        if (str == null || (a2 = this.d[this.f.get(str).intValue()].a(controlId)) == null) {
            return false;
        }
        if (this.g.get(controlId) != m.BUTTON && this.g.get(controlId) != m.TEXT_VIEW && this.g.get(controlId) != m.IMAGE_VIEW) {
            return true;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) a2.getLayoutParams();
        layoutParams.height = commandToUi.getIntParam();
        a2.setLayoutParams(layoutParams);
        return true;
    }

    private boolean v(UiMessage.CommandToUi commandToUi) {
        View a2;
        String controlId = commandToUi.getControlId();
        new StringBuilder("setFloatText : ").append(commandToUi.getStrParam());
        String str = this.h.get(controlId);
        boolean z = false;
        if (str == null) {
            return false;
        }
        try {
            j jVar = this.d[this.f.get(str).intValue()];
            if (jVar == null || (a2 = jVar.a(controlId)) == null) {
                return false;
            }
            int i2 = AnonymousClass4.f2631b[this.g.get(controlId).ordinal()];
            z = true;
            if (i2 == 1) {
                ((TextView) a2).setText(commandToUi.getStrParam());
            } else if (i2 == 3) {
                ((Button) a2).setText(commandToUi.getStrParam());
            }
            jVar.e();
            return z;
        } catch (Exception unused) {
        }
    }

    public final void a() {
        for (int i2 = 31; i2 > 0; i2--) {
            k kVar = this.f2621a[i2];
            if (kVar != null && kVar.f2658c) {
                kVar.e();
            }
            j jVar = this.d[i2];
            if (jVar != null && jVar.d) {
                jVar.c();
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0070, code lost:
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:406:0x0e8b, code lost:
        r1.a(r0, r13.getParentId());
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.cyjh.mobileanjian.ipc.share.proto.UiMessage.CommandToUi r13) {
        /*
            r12 = this;
            java.lang.String r6 = r13.getControlId()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$CommandToUi$Command_Type r0 = r13.getCommand()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "command: "
            r1.<init>(r2)
            r1.append(r13)
            int[] r1 = com.cyjh.mobileanjian.ipc.ui.h.AnonymousClass4.f2630a
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 2
            r2 = 8
            r3 = 100
            r4 = -1
            r5 = 0
            r7 = 3
            r8 = 1
            r9 = 0
            switch(r0) {
                case 1: goto L_0x10b8;
                case 2: goto L_0x10b0;
                case 3: goto L_0x1064;
                case 4: goto L_0x0feb;
                case 5: goto L_0x0fb3;
                case 6: goto L_0x0fad;
                case 7: goto L_0x0fa8;
                case 8: goto L_0x0f86;
                case 9: goto L_0x0f5a;
                case 10: goto L_0x0ef9;
                case 11: goto L_0x0e94;
                case 12: goto L_0x0e61;
                case 13: goto L_0x0e32;
                case 14: goto L_0x0df3;
                case 15: goto L_0x0dc0;
                case 16: goto L_0x0d8b;
                case 17: goto L_0x0d56;
                case 18: goto L_0x0d21;
                case 19: goto L_0x0cf1;
                case 20: goto L_0x0cb5;
                case 21: goto L_0x0c9a;
                case 22: goto L_0x0c76;
                case 23: goto L_0x0c70;
                case 24: goto L_0x0c70;
                case 25: goto L_0x0c70;
                case 26: goto L_0x0c70;
                case 27: goto L_0x0c70;
                case 28: goto L_0x0c70;
                case 29: goto L_0x0c70;
                case 30: goto L_0x0c70;
                case 31: goto L_0x0c70;
                case 32: goto L_0x0c70;
                case 33: goto L_0x0c70;
                case 34: goto L_0x0c3b;
                case 35: goto L_0x0c37;
                case 36: goto L_0x0c33;
                case 37: goto L_0x0bf1;
                case 38: goto L_0x0b01;
                case 39: goto L_0x0a40;
                case 40: goto L_0x09b4;
                case 41: goto L_0x09b0;
                case 42: goto L_0x0944;
                case 43: goto L_0x08e2;
                case 44: goto L_0x0803;
                case 45: goto L_0x10c9;
                case 46: goto L_0x07c6;
                case 47: goto L_0x10c9;
                case 48: goto L_0x0753;
                case 49: goto L_0x073c;
                case 50: goto L_0x06f1;
                case 51: goto L_0x06c2;
                case 52: goto L_0x067c;
                case 53: goto L_0x0646;
                case 54: goto L_0x0616;
                case 55: goto L_0x05d3;
                case 56: goto L_0x0518;
                case 57: goto L_0x0483;
                case 58: goto L_0x03f8;
                case 59: goto L_0x0379;
                case 60: goto L_0x0317;
                case 61: goto L_0x02be;
                case 62: goto L_0x0227;
                case 63: goto L_0x00d6;
                case 64: goto L_0x00d2;
                case 65: goto L_0x00d2;
                case 66: goto L_0x00d2;
                case 67: goto L_0x00cc;
                case 68: goto L_0x00c6;
                case 69: goto L_0x00c6;
                case 70: goto L_0x00c0;
                case 71: goto L_0x00c0;
                case 72: goto L_0x00c0;
                case 73: goto L_0x0041;
                case 74: goto L_0x003b;
                case 75: goto L_0x0035;
                case 76: goto L_0x002f;
                case 77: goto L_0x0029;
                default: goto L_0x0027;
            }
        L_0x0027:
            goto L_0x10c9
        L_0x0029:
            boolean r8 = r12.v(r13)
            goto L_0x10c9
        L_0x002f:
            boolean r8 = r12.u(r13)
            goto L_0x10c9
        L_0x0035:
            boolean r8 = r12.t(r13)
            goto L_0x10c9
        L_0x003b:
            boolean r8 = r12.s(r13)
            goto L_0x10c9
        L_0x0041:
            java.lang.String r0 = r13.getControlId()
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r12.f
            java.lang.Object r1 = r1.get(r0)
            if (r1 == 0) goto L_0x0066
            com.cyjh.mobileanjian.ipc.ui.j[] r1 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r12.f
            java.lang.Object r0 = r2.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r0 = r1[r0]
            int r13 = r13.getIntParam()
            r0.setFloatLeft(r13)
            goto L_0x10c9
        L_0x0066:
            java.util.HashMap<java.lang.String, java.lang.String> r1 = r12.h
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x0073
        L_0x0070:
            r8 = 0
            goto L_0x10c9
        L_0x0073:
            com.cyjh.mobileanjian.ipc.ui.j[] r2 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r3 = r12.f
            java.lang.Object r1 = r3.get(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r1 = r2[r1]
            android.view.View r1 = r1.a((java.lang.String) r0)
            if (r1 != 0) goto L_0x008a
            goto L_0x0070
        L_0x008a:
            java.util.HashMap<java.lang.String, com.cyjh.mobileanjian.ipc.ui.m> r2 = r12.g
            java.lang.Object r2 = r2.get(r0)
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.BUTTON
            if (r2 == r3) goto L_0x00a8
            java.util.HashMap<java.lang.String, com.cyjh.mobileanjian.ipc.ui.m> r2 = r12.g
            java.lang.Object r2 = r2.get(r0)
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.TEXT_VIEW
            if (r2 == r3) goto L_0x00a8
            java.util.HashMap<java.lang.String, com.cyjh.mobileanjian.ipc.ui.m> r2 = r12.g
            java.lang.Object r0 = r2.get(r0)
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.IMAGE_VIEW
            if (r0 != r2) goto L_0x10c9
        L_0x00a8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "view.setX "
            r0.<init>(r2)
            int r2 = r13.getIntParam()
            r0.append(r2)
            int r13 = r13.getIntParam()
            float r13 = (float) r13
            r1.setX(r13)
            goto L_0x10c9
        L_0x00c0:
            boolean r8 = r12.q(r13)
            goto L_0x10c9
        L_0x00c6:
            boolean r8 = r12.p((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.CommandToUi) r13)
            goto L_0x10c9
        L_0x00cc:
            boolean r8 = r12.o((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.CommandToUi) r13)
            goto L_0x10c9
        L_0x00d2:
            r12.n((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.CommandToUi) r13)
            return
        L_0x00d6:
            org.json.JSONObject r13 = new org.json.JSONObject
            r13.<init>()
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r12.f
            java.lang.Object r0 = r0.get(r6)
            if (r0 == 0) goto L_0x011b
            com.cyjh.mobileanjian.ipc.ui.j[] r0 = r12.d     // Catch:{ JSONException -> 0x0115 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r12.f     // Catch:{ JSONException -> 0x0115 }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ JSONException -> 0x0115 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ JSONException -> 0x0115 }
            int r1 = r1.intValue()     // Catch:{ JSONException -> 0x0115 }
            r0 = r0[r1]     // Catch:{ JSONException -> 0x0115 }
            android.view.WindowManager$LayoutParams r0 = r0.getParams()     // Catch:{ JSONException -> 0x0115 }
            java.lang.String r1 = "Left"
            int r2 = r0.x     // Catch:{ JSONException -> 0x0115 }
            r13.put(r1, r2)     // Catch:{ JSONException -> 0x0115 }
            java.lang.String r1 = "Top"
            int r2 = r0.y     // Catch:{ JSONException -> 0x0115 }
            r13.put(r1, r2)     // Catch:{ JSONException -> 0x0115 }
            java.lang.String r1 = "Width"
            int r2 = r0.width     // Catch:{ JSONException -> 0x0115 }
            r13.put(r1, r2)     // Catch:{ JSONException -> 0x0115 }
            java.lang.String r1 = "Height"
            int r0 = r0.height     // Catch:{ JSONException -> 0x0115 }
            r13.put(r1, r0)     // Catch:{ JSONException -> 0x0115 }
            goto L_0x0217
        L_0x0115:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0217
        L_0x011b:
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r12.h
            java.lang.Object r0 = r0.get(r6)
            java.lang.String r0 = (java.lang.String) r0
            java.util.HashMap<java.lang.String, com.cyjh.mobileanjian.ipc.ui.m> r1 = r12.g
            java.lang.Object r1 = r1.get(r6)
            com.cyjh.mobileanjian.ipc.ui.m r1 = (com.cyjh.mobileanjian.ipc.ui.m) r1
            if (r1 != 0) goto L_0x0143
            int r0 = com.cyjh.mqsdk.R.string.ui_show_not_found_widget
            java.lang.Object[] r1 = new java.lang.Object[r8]
            r1[r9] = r6
            r12.a((int) r0, (java.lang.Object[]) r1)
        L_0x0136:
            com.cyjh.mq.sdk.MqRunner r0 = com.cyjh.mq.sdk.MqRunner.getInstance()
            java.lang.String r13 = r13.toString()
            r0.c((java.lang.String) r13)
            goto L_0x10c9
        L_0x0143:
            int[] r2 = com.cyjh.mobileanjian.ipc.ui.h.AnonymousClass4.f2631b
            int r1 = r1.ordinal()
            r1 = r2[r1]
            if (r1 == r8) goto L_0x01d4
            if (r1 == r7) goto L_0x0190
            r2 = 7
            if (r1 == r2) goto L_0x0154
            goto L_0x0217
        L_0x0154:
            com.cyjh.mobileanjian.ipc.ui.j[] r1 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r12.f
            java.lang.Object r0 = r2.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r0 = r1[r0]
            android.view.View r0 = r0.a((java.lang.String) r6)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            java.lang.String r1 = "Left"
            int r2 = r0.getLeft()     // Catch:{ JSONException -> 0x0115 }
            r13.put(r1, r2)     // Catch:{ JSONException -> 0x0115 }
            java.lang.String r1 = "Top"
            int r2 = r0.getTop()     // Catch:{ JSONException -> 0x0115 }
            r13.put(r1, r2)     // Catch:{ JSONException -> 0x0115 }
            java.lang.String r1 = "Width"
            int r2 = r0.getWidth()     // Catch:{ JSONException -> 0x0115 }
            r13.put(r1, r2)     // Catch:{ JSONException -> 0x0115 }
            java.lang.String r1 = "Height"
            int r0 = r0.getHeight()     // Catch:{ JSONException -> 0x0115 }
            r13.put(r1, r0)     // Catch:{ JSONException -> 0x0115 }
            goto L_0x0217
        L_0x0190:
            com.cyjh.mobileanjian.ipc.ui.j[] r1 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r12.f
            java.lang.Object r0 = r2.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r0 = r1[r0]
            android.view.View r0 = r0.a((java.lang.String) r6)
            android.widget.Button r0 = (android.widget.Button) r0
            java.lang.String r1 = "Left"
            int r2 = r0.getLeft()     // Catch:{ JSONException -> 0x0115 }
            r13.put(r1, r2)     // Catch:{ JSONException -> 0x0115 }
            java.lang.String r1 = "Top"
            int r2 = r0.getTop()     // Catch:{ JSONException -> 0x0115 }
            r13.put(r1, r2)     // Catch:{ JSONException -> 0x0115 }
            java.lang.String r1 = "Text"
            java.lang.CharSequence r2 = r0.getText()     // Catch:{ JSONException -> 0x0115 }
            r13.put(r1, r2)     // Catch:{ JSONException -> 0x0115 }
            java.lang.String r1 = "Width"
            int r2 = r0.getWidth()     // Catch:{ JSONException -> 0x0115 }
            r13.put(r1, r2)     // Catch:{ JSONException -> 0x0115 }
            java.lang.String r1 = "Height"
            int r0 = r0.getHeight()     // Catch:{ JSONException -> 0x0115 }
            r13.put(r1, r0)     // Catch:{ JSONException -> 0x0115 }
            goto L_0x0217
        L_0x01d4:
            com.cyjh.mobileanjian.ipc.ui.j[] r1 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r12.f
            java.lang.Object r0 = r2.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r0 = r1[r0]
            android.view.View r0 = r0.a((java.lang.String) r6)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "Left"
            int r2 = r0.getLeft()     // Catch:{ JSONException -> 0x0115 }
            r13.put(r1, r2)     // Catch:{ JSONException -> 0x0115 }
            java.lang.String r1 = "Top"
            int r2 = r0.getTop()     // Catch:{ JSONException -> 0x0115 }
            r13.put(r1, r2)     // Catch:{ JSONException -> 0x0115 }
            java.lang.String r1 = "Text"
            java.lang.CharSequence r2 = r0.getText()     // Catch:{ JSONException -> 0x0115 }
            r13.put(r1, r2)     // Catch:{ JSONException -> 0x0115 }
            java.lang.String r1 = "Width"
            int r2 = r0.getWidth()     // Catch:{ JSONException -> 0x0115 }
            r13.put(r1, r2)     // Catch:{ JSONException -> 0x0115 }
            java.lang.String r1 = "Height"
            int r0 = r0.getHeight()     // Catch:{ JSONException -> 0x0115 }
            r13.put(r1, r0)     // Catch:{ JSONException -> 0x0115 }
        L_0x0217:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "FWGetValue json: "
            r0.<init>(r1)
            java.lang.String r1 = r13.toString()
            r0.append(r1)
            goto L_0x0136
        L_0x0227:
            java.lang.String r0 = r13.getControlId()
            java.lang.String r13 = r13.getStrParam()
            java.lang.String r1 = "^#*([0-9A-Fa-f]{6})|([0-9A-Fa-f]{3})"
            boolean r1 = r13.matches(r1)
            if (r1 != 0) goto L_0x0242
            int r13 = com.cyjh.mqsdk.R.string.ui_show_invalid_color_value
            java.lang.Object[] r0 = new java.lang.Object[r9]
            r12.a((int) r13, (java.lang.Object[]) r0)
            a((boolean) r9)
            return
        L_0x0242:
            java.lang.String r1 = "#"
            boolean r1 = r13.startsWith(r1)
            if (r1 != 0) goto L_0x0258
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "#"
            r1.<init>(r2)
            r1.append(r13)
            java.lang.String r13 = r1.toString()
        L_0x0258:
            int r13 = android.graphics.Color.parseColor(r13)
            int r13 = com.cyjh.mobileanjian.ipc.utils.c.a(r13)
            java.util.HashMap<java.lang.String, java.lang.String> r1 = r12.h
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x026e
            a((boolean) r9)
            return
        L_0x026e:
            com.cyjh.mobileanjian.ipc.ui.j[] r2 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r3 = r12.f
            java.lang.Object r3 = r3.get(r1)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r2 = r2[r3]
            android.view.View r2 = r2.a((java.lang.String) r0)
            if (r2 != 0) goto L_0x0288
            a((boolean) r9)
            return
        L_0x0288:
            java.util.HashMap<java.lang.String, com.cyjh.mobileanjian.ipc.ui.m> r3 = r12.g
            java.lang.Object r3 = r3.get(r0)
            com.cyjh.mobileanjian.ipc.ui.m r4 = com.cyjh.mobileanjian.ipc.ui.m.BUTTON
            if (r3 != r4) goto L_0x0298
            r3 = r2
            android.widget.Button r3 = (android.widget.Button) r3
            r3.setTextColor(r13)
        L_0x0298:
            java.util.HashMap<java.lang.String, com.cyjh.mobileanjian.ipc.ui.m> r3 = r12.g
            java.lang.Object r0 = r3.get(r0)
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.TEXT_VIEW
            if (r0 != r3) goto L_0x02a7
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setTextColor(r13)
        L_0x02a7:
            com.cyjh.mobileanjian.ipc.ui.j[] r13 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r12.f
            java.lang.Object r0 = r0.get(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r13 = r13[r0]
            r13.e()
            a((boolean) r8)
            return
        L_0x02be:
            java.util.HashMap<java.lang.String, java.lang.Integer> r13 = r12.f
            java.lang.Object r13 = r13.get(r6)
            if (r13 != 0) goto L_0x02d3
            int r13 = com.cyjh.mqsdk.R.string.ui_show_not_found_float
            java.lang.Object[] r0 = new java.lang.Object[r8]
            r0[r9] = r6
            r12.a((int) r13, (java.lang.Object[]) r0)
            a((boolean) r9)
            return
        L_0x02d3:
            com.cyjh.mobileanjian.ipc.ui.j[] r13 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r12.f
            java.lang.Object r0 = r0.get(r6)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r13 = r13[r0]
            boolean r13 = r13.d()
            if (r13 == 0) goto L_0x0313
            com.cyjh.mobileanjian.ipc.ui.j[] r13 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r12.f
            java.lang.Object r0 = r0.get(r6)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r13 = r13[r0]
            android.widget.RelativeLayout r0 = r13.f2647c
            if (r0 == 0) goto L_0x0313
            boolean r0 = r13.d()
            if (r0 == 0) goto L_0x0313
            android.view.WindowManager r0 = r13.f2645a
            android.widget.RelativeLayout r1 = r13.f2647c
            r0.removeView(r1)
            android.view.WindowManager r0 = r13.f2645a
            android.widget.RelativeLayout r1 = r13.f2647c
            android.view.WindowManager$LayoutParams r13 = r13.f2646b
            r0.addView(r1, r13)
        L_0x0313:
            a((boolean) r8)
            return
        L_0x0317:
            java.lang.String r0 = r13.getParentId()
            com.cyjh.mobileanjian.ipc.ui.j[] r1 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r12.f
            java.lang.Object r2 = r2.get(r0)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r1 = r1[r2]
            if (r1 == 0) goto L_0x10c9
            com.cyjh.mobileanjian.ipc.ui.g r1 = r12.m
            r12.b()
            java.lang.String r2 = r13.getText()
            int r3 = r13.getWidth()
            int r4 = r13.getHeight()
            r13.getLeft()
            r13.getTop()
            android.widget.ImageView r1 = r1.c(r6, r2, r3, r4)
            java.util.HashMap<java.lang.String, com.cyjh.mobileanjian.ipc.ui.m> r2 = r12.g
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.IMAGE_VIEW
            r2.put(r6, r3)
            com.cyjh.mobileanjian.ipc.ui.j[] r2 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r3 = r12.f
            java.lang.Object r3 = r3.get(r0)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r2 = r2[r3]
            r2.a((android.view.View) r1)
            java.util.HashMap<java.lang.String, java.lang.String> r2 = r12.h
            r2.put(r6, r0)
            int r0 = r13.getLeft()
            float r0 = (float) r0
            r1.setX(r0)
            int r13 = r13.getTop()
            float r13 = (float) r13
            r1.setY(r13)
            goto L_0x10c9
        L_0x0379:
            java.lang.String r0 = r13.getParentId()
            com.cyjh.mobileanjian.ipc.ui.j[] r1 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r12.f
            java.lang.Object r2 = r2.get(r0)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r1 = r1[r2]
            if (r1 == 0) goto L_0x10c9
            com.cyjh.mobileanjian.ipc.ui.g r1 = r12.m
            r12.b()
            java.lang.String r2 = r13.getText()
            int r3 = r13.getWidth()
            int r4 = r13.getHeight()
            r13.getLeft()
            r13.getTop()
            android.view.LayoutInflater r1 = r1.f2618a
            int r7 = com.cyjh.mqsdk.R.layout.ui_float_text_view
            android.view.View r1 = r1.inflate(r7, r5)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r1.setTag(r6)
            r1.setText(r2)
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams
            r5 = -2
            r2.<init>(r5, r5)
            if (r3 == r5) goto L_0x03c4
            if (r4 == r5) goto L_0x03c4
            r2.width = r3
            r2.height = r4
        L_0x03c4:
            r1.setLayoutParams(r2)
            java.util.HashMap<java.lang.String, com.cyjh.mobileanjian.ipc.ui.m> r2 = r12.g
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.TEXT_VIEW
            r2.put(r6, r3)
            com.cyjh.mobileanjian.ipc.ui.j[] r2 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r3 = r12.f
            java.lang.Object r3 = r3.get(r0)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r2 = r2[r3]
            r2.a((android.view.View) r1)
            java.util.HashMap<java.lang.String, java.lang.String> r2 = r12.h
            r2.put(r6, r0)
            int r0 = r13.getLeft()
            float r0 = (float) r0
            r1.setX(r0)
            int r13 = r13.getTop()
            float r13 = (float) r13
            r1.setY(r13)
            goto L_0x10c9
        L_0x03f8:
            java.lang.String r0 = r13.getParentId()
            com.cyjh.mobileanjian.ipc.ui.j[] r1 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r12.f
            java.lang.Object r2 = r2.get(r0)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r1 = r1[r2]
            if (r1 == 0) goto L_0x10c9
            com.cyjh.mobileanjian.ipc.ui.g r1 = r12.m
            r12.b()
            java.lang.String r2 = r13.getText()
            int r7 = r13.getWidth()
            int r10 = r13.getHeight()
            r13.getLeft()
            r13.getTop()
            android.view.LayoutInflater r1 = r1.f2618a
            int r11 = com.cyjh.mqsdk.R.layout.ui_float_button
            android.view.View r1 = r1.inflate(r11, r5)
            android.widget.Button r1 = (android.widget.Button) r1
            r1.setTag(r6)
            r1.setText(r2)
            r1.setAllCaps(r9)
            if (r7 != 0) goto L_0x0442
            if (r10 != 0) goto L_0x0442
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams
            r2.<init>(r4, r3)
            goto L_0x0447
        L_0x0442:
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams
            r2.<init>(r7, r10)
        L_0x0447:
            r1.setLayoutParams(r2)
            java.util.HashMap<java.lang.String, com.cyjh.mobileanjian.ipc.ui.m> r2 = r12.g
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.BUTTON
            r2.put(r6, r3)
            com.cyjh.mobileanjian.ipc.ui.h$1 r2 = new com.cyjh.mobileanjian.ipc.ui.h$1
            r2.<init>(r6)
            r1.setOnClickListener(r2)
            com.cyjh.mobileanjian.ipc.ui.j[] r2 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r3 = r12.f
            java.lang.Object r3 = r3.get(r0)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r2 = r2[r3]
            r2.a((android.view.View) r1)
            java.util.HashMap<java.lang.String, java.lang.String> r2 = r12.h
            r2.put(r6, r0)
            int r0 = r13.getLeft()
            float r0 = (float) r0
            r1.setX(r0)
            int r13 = r13.getTop()
            float r13 = (float) r13
            r1.setY(r13)
            goto L_0x10c9
        L_0x0483:
            java.lang.String r13 = r13.getStrParam()
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r12.f
            java.lang.Object r0 = r0.get(r6)
            if (r0 == 0) goto L_0x04da
            com.cyjh.mobileanjian.ipc.ui.j[] r0 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r12.f
            java.lang.Object r1 = r1.get(r6)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r0 = r0[r1]
            r0.i = r13
            java.lang.String r13 = r0.i
            android.graphics.Bitmap r13 = android.graphics.BitmapFactory.decodeFile(r13)
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 16
            if (r1 < r2) goto L_0x04b7
            android.widget.RelativeLayout r1 = r0.f2647c
            android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable
            r2.<init>(r13)
            r1.setBackground(r2)
        L_0x04b7:
            android.widget.RelativeLayout r13 = r0.f2647c
            android.graphics.drawable.Drawable r13 = r13.getBackground()
            int r0 = r0.h
            int r0 = r0 * 255
            int r0 = r0 / r3
            r13.setAlpha(r0)
            com.cyjh.mobileanjian.ipc.ui.j[] r13 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r12.f
            java.lang.Object r0 = r0.get(r6)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r13 = r13[r0]
            r13.e()
            goto L_0x10c9
        L_0x04da:
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r12.h
            java.lang.Object r0 = r0.get(r6)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x04e6
            goto L_0x0070
        L_0x04e6:
            com.cyjh.mobileanjian.ipc.ui.j[] r1 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r12.f
            java.lang.Object r0 = r2.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r0 = r1[r0]
            android.view.View r0 = r0.a((java.lang.String) r6)
            if (r0 != 0) goto L_0x04fe
            goto L_0x0070
        L_0x04fe:
            java.util.HashMap<java.lang.String, com.cyjh.mobileanjian.ipc.ui.m> r1 = r12.g
            java.lang.Object r1 = r1.get(r6)
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.IMAGE_VIEW
            if (r1 != r2) goto L_0x10c9
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            java.io.File r1 = new java.io.File
            r1.<init>(r13)
            android.net.Uri r13 = android.net.Uri.fromFile(r1)
            r0.setImageURI(r13)
            goto L_0x10c9
        L_0x0518:
            java.lang.String r13 = r13.getStrParam()
            java.lang.String r0 = "^#*([0-9A-Fa-f]{6})|([0-9A-Fa-f]{3})"
            boolean r0 = r13.matches(r0)
            if (r0 != 0) goto L_0x052f
            int r13 = com.cyjh.mqsdk.R.string.ui_show_invalid_color_value
            java.lang.Object[] r0 = new java.lang.Object[r9]
            r12.a((int) r13, (java.lang.Object[]) r0)
            a((boolean) r9)
            return
        L_0x052f:
            java.lang.String r0 = "#"
            boolean r0 = r13.startsWith(r0)
            if (r0 != 0) goto L_0x0545
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "#"
            r0.<init>(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
        L_0x0545:
            int r13 = android.graphics.Color.parseColor(r13)
            int r13 = com.cyjh.mobileanjian.ipc.utils.c.a(r13)
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r12.f
            java.lang.Object r0 = r0.get(r6)
            if (r0 == 0) goto L_0x057c
            com.cyjh.mobileanjian.ipc.ui.j[] r0 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r12.f
            java.lang.Object r1 = r1.get(r6)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r0 = r0[r1]
            r0.b((int) r13)
            com.cyjh.mobileanjian.ipc.ui.j[] r13 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r12.f
            java.lang.Object r0 = r0.get(r6)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r13 = r13[r0]
            r13.e()
            goto L_0x05cf
        L_0x057c:
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r12.h
            java.lang.Object r0 = r0.get(r6)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x058a
            a((boolean) r9)
            return
        L_0x058a:
            com.cyjh.mobileanjian.ipc.ui.j[] r1 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r3 = r12.f
            java.lang.Object r0 = r3.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r0 = r1[r0]
            android.view.View r0 = r0.a((java.lang.String) r6)
            if (r0 != 0) goto L_0x05a4
            a((boolean) r9)
            return
        L_0x05a4:
            java.util.HashMap<java.lang.String, com.cyjh.mobileanjian.ipc.ui.m> r1 = r12.g
            java.lang.Object r1 = r1.get(r6)
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.BUTTON
            if (r1 != r3) goto L_0x05c2
            android.graphics.drawable.GradientDrawable r1 = new android.graphics.drawable.GradientDrawable
            r1.<init>()
            float[] r2 = new float[r2]
            r2 = {1084227584, 1084227584, 1084227584, 1084227584, 1084227584, 1084227584, 1084227584, 1084227584} // fill-array
            r1.setCornerRadii(r2)
            r1.setColor(r13)
            r0.setBackground(r1)
            goto L_0x05cf
        L_0x05c2:
            java.util.HashMap<java.lang.String, com.cyjh.mobileanjian.ipc.ui.m> r1 = r12.g
            java.lang.Object r1 = r1.get(r6)
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.SPINNER
            if (r1 == r2) goto L_0x05cf
            r0.setBackgroundColor(r13)
        L_0x05cf:
            a((boolean) r8)
            return
        L_0x05d3:
            int r13 = r13.getIntParam()
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r12.f
            java.lang.Object r0 = r0.get(r6)
            if (r0 != 0) goto L_0x05ec
            int r13 = com.cyjh.mqsdk.R.string.ui_show_not_found_float
            java.lang.Object[] r0 = new java.lang.Object[r8]
            r0[r9] = r6
            r12.a((int) r13, (java.lang.Object[]) r0)
            a((boolean) r9)
            return
        L_0x05ec:
            com.cyjh.mobileanjian.ipc.ui.j[] r0 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r12.f
            java.lang.Object r1 = r1.get(r6)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r0 = r0[r1]
            r0.a((int) r13)
            com.cyjh.mobileanjian.ipc.ui.j[] r13 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r12.f
            java.lang.Object r0 = r0.get(r6)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r13 = r13[r0]
            r13.e()
            a((boolean) r8)
            return
        L_0x0616:
            int r13 = r13.getIntParam()
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r12.f
            java.lang.Object r0 = r0.get(r6)
            if (r0 != 0) goto L_0x062f
            int r13 = com.cyjh.mqsdk.R.string.ui_show_not_found_float
            java.lang.Object[] r0 = new java.lang.Object[r8]
            r0[r9] = r6
            r12.a((int) r13, (java.lang.Object[]) r0)
            a((boolean) r9)
            return
        L_0x062f:
            com.cyjh.mobileanjian.ipc.ui.j[] r0 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r12.f
            java.lang.Object r1 = r1.get(r6)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r0 = r0[r1]
            r0.setOpacity(r13)
            a((boolean) r8)
            return
        L_0x0646:
            java.util.HashMap<java.lang.String, java.lang.Integer> r13 = r12.f
            java.lang.Object r13 = r13.get(r6)
            if (r13 != 0) goto L_0x065b
            int r13 = com.cyjh.mqsdk.R.string.ui_show_not_found_float
            java.lang.Object[] r0 = new java.lang.Object[r8]
            r0[r9] = r6
            r12.a((int) r13, (java.lang.Object[]) r0)
            a((boolean) r9)
            return
        L_0x065b:
            com.cyjh.mobileanjian.ipc.ui.j[] r13 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r12.f
            java.lang.Object r0 = r0.get(r6)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r13 = r13[r0]
            r13.c()
            java.util.HashMap<java.lang.String, java.lang.Integer> r13 = r12.f
            r13.remove(r6)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Event_Type r13 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlEvent.Event_Type.ON_CLOSE
            a((java.lang.String) r6, (com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlEvent.Event_Type) r13)
            a((boolean) r8)
            return
        L_0x067c:
            java.util.HashMap<java.lang.String, java.lang.Integer> r13 = r12.f
            java.lang.Object r13 = r13.get(r6)
            if (r13 != 0) goto L_0x0691
            int r13 = com.cyjh.mqsdk.R.string.ui_show_not_found_float
            java.lang.Object[] r0 = new java.lang.Object[r8]
            r0[r9] = r6
            r12.a((int) r13, (java.lang.Object[]) r0)
            a((boolean) r9)
            return
        L_0x0691:
            com.cyjh.mobileanjian.ipc.ui.j[] r13 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r12.f
            java.lang.Object r0 = r0.get(r6)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r13 = r13[r0]
            boolean r13 = r13.d()
            if (r13 != 0) goto L_0x06ab
            a((boolean) r9)
            return
        L_0x06ab:
            com.cyjh.mobileanjian.ipc.ui.j[] r13 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r12.f
            java.lang.Object r0 = r0.get(r6)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r13 = r13[r0]
            r13.b()
            a((boolean) r8)
            return
        L_0x06c2:
            boolean r13 = r13.getBoolParam()
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r12.f
            java.lang.Object r0 = r0.get(r6)
            if (r0 != 0) goto L_0x06db
            int r13 = com.cyjh.mqsdk.R.string.ui_show_not_found_float
            java.lang.Object[] r0 = new java.lang.Object[r8]
            r0[r9] = r6
            r12.a((int) r13, (java.lang.Object[]) r0)
            a((boolean) r9)
            return
        L_0x06db:
            com.cyjh.mobileanjian.ipc.ui.j[] r0 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r12.f
            java.lang.Object r1 = r1.get(r6)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r0 = r0[r1]
            r0.e = r13
            a((boolean) r8)
            return
        L_0x06f1:
            java.util.HashMap<java.lang.String, java.lang.Integer> r13 = r12.f
            java.lang.Object r13 = r13.get(r6)
            if (r13 != 0) goto L_0x0706
            int r13 = com.cyjh.mqsdk.R.string.ui_show_not_found_float
            java.lang.Object[] r0 = new java.lang.Object[r8]
            r0[r9] = r6
            r12.a((int) r13, (java.lang.Object[]) r0)
            a((boolean) r9)
            return
        L_0x0706:
            com.cyjh.mobileanjian.ipc.ui.j[] r13 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r12.f
            java.lang.Object r0 = r0.get(r6)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r13 = r13[r0]
            boolean r13 = r13.d()
            if (r13 == 0) goto L_0x0720
            a((boolean) r9)
            return
        L_0x0720:
            com.cyjh.mobileanjian.ipc.ui.j[] r13 = r12.d
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r12.f
            java.lang.Object r0 = r0.get(r6)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r13 = r13[r0]
            r13.a()
            a((boolean) r8)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Event_Type r13 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlEvent.Event_Type.ON_SHOW
            a((java.lang.String) r6, (com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlEvent.Event_Type) r13)
            return
        L_0x073c:
            int r2 = r13.getLeft()
            int r3 = r13.getTop()
            int r4 = r13.getWidth()
            int r5 = r13.getHeight()
            r0 = r12
            r1 = r6
            r0.a(r1, r2, r3, r4, r5)
            goto L_0x10c9
        L_0x0753:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r12.f2621a
            int r1 = r12.f2622b
            r0 = r0[r1]
            if (r0 != 0) goto L_0x075f
            a((boolean) r9)
            return
        L_0x075f:
            java.lang.String r0 = r13.getControlId()
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r12.f2621a
            int r2 = r12.f2622b
            r1 = r1[r2]
            android.view.View r0 = r1.b((java.lang.String) r0)
            if (r0 != 0) goto L_0x0773
            a((boolean) r9)
            return
        L_0x0773:
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$Padding_Var r13 = r13.getPadding()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "padding: "
            r1.<init>(r2)
            int r2 = r13.getLeft()
            r1.append(r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "padding: "
            r1.<init>(r2)
            int r2 = r13.getTop()
            r1.append(r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "padding: "
            r1.<init>(r2)
            int r2 = r13.getRight()
            r1.append(r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "padding: "
            r1.<init>(r2)
            int r2 = r13.getBottom()
            r1.append(r2)
            int r1 = r13.getLeft()
            int r2 = r13.getTop()
            int r3 = r13.getRight()
            int r13 = r13.getBottom()
            r0.setPadding(r1, r2, r3, r13)
            a((boolean) r8)
            return
        L_0x07c6:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r12.f2621a
            int r1 = r12.f2622b
            r0 = r0[r1]
            if (r0 != 0) goto L_0x07d2
            a((boolean) r9)
            return
        L_0x07d2:
            java.lang.String r0 = r13.getControlId()
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r12.f2621a
            int r2 = r12.f2622b
            r1 = r1[r2]
            android.view.View r0 = r1.b((java.lang.String) r0)
            if (r0 != 0) goto L_0x07e6
            a((boolean) r9)
            return
        L_0x07e6:
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r1 = (android.widget.LinearLayout.LayoutParams) r1
            int r13 = r13.getAlignType()
            r1.gravity = r13
            r0.setLayoutParams(r1)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r0 = "set gravity ok; "
            r13.<init>(r0)
            r13.append(r1)
            a((boolean) r8)
            return
        L_0x0803:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r12.f2621a
            int r2 = r12.f2622b
            r0 = r0[r2]
            if (r0 != 0) goto L_0x080f
            a((boolean) r9)
            return
        L_0x080f:
            java.lang.String r0 = r13.getControlId()
            java.util.HashMap[] r2 = r12.f2623c
            int r3 = r12.f2622b
            r2 = r2[r3]
            java.lang.Object r2 = r2.get(r0)
            if (r2 != 0) goto L_0x0823
            a((boolean) r9)
            return
        L_0x0823:
            int[] r2 = com.cyjh.mobileanjian.ipc.ui.h.AnonymousClass4.f2631b
            java.util.HashMap[] r3 = r12.f2623c
            int r4 = r12.f2622b
            r3 = r3[r4]
            java.lang.Object r3 = r3.get(r0)
            com.cyjh.mobileanjian.ipc.ui.m r3 = (com.cyjh.mobileanjian.ipc.ui.m) r3
            int r3 = r3.ordinal()
            r2 = r2[r3]
            switch(r2) {
                case 1: goto L_0x0870;
                case 2: goto L_0x0870;
                case 3: goto L_0x0870;
                case 4: goto L_0x085f;
                case 5: goto L_0x083e;
                default: goto L_0x083a;
            }
        L_0x083a:
            a((boolean) r9)
            return
        L_0x083e:
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r12.f2621a
            int r3 = r12.f2622b
            r2 = r2[r3]
            android.view.View r2 = r2.b((java.lang.String) r0)
            android.widget.RadioGroup r2 = (android.widget.RadioGroup) r2
            int r13 = r13.getItemIndex()
            android.view.View r13 = r2.findViewById(r13)
            android.widget.RadioButton r13 = (android.widget.RadioButton) r13
            if (r13 != 0) goto L_0x085a
            a((boolean) r9)
            return
        L_0x085a:
            android.text.TextPaint r13 = r13.getPaint()
            goto L_0x0880
        L_0x085f:
            com.cyjh.mobileanjian.ipc.ui.k[] r13 = r12.f2621a
            int r2 = r12.f2622b
            r13 = r13[r2]
            android.view.View r13 = r13.b((java.lang.String) r0)
            android.widget.CheckBox r13 = (android.widget.CheckBox) r13
            android.text.TextPaint r13 = r13.getPaint()
            goto L_0x0880
        L_0x0870:
            com.cyjh.mobileanjian.ipc.ui.k[] r13 = r12.f2621a
            int r2 = r12.f2622b
            r13 = r13[r2]
            android.view.View r13 = r13.b((java.lang.String) r0)
            android.widget.TextView r13 = (android.widget.TextView) r13
            android.text.TextPaint r13 = r13.getPaint()
        L_0x0880:
            int r13 = r13.getColor()
            java.lang.String r2 = "%02X%02X%02X"
            java.lang.Object[] r3 = new java.lang.Object[r7]
            int r4 = android.graphics.Color.blue(r13)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r9] = r4
            int r4 = android.graphics.Color.green(r13)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r8] = r4
            int r13 = android.graphics.Color.red(r13)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r3[r1] = r13
            java.lang.String r13 = java.lang.String.format(r2, r3)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = r1.setControlId(r0)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.STRING
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = r0.setType(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r13 = r0.setStringValue(r13)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar r13 = r13.build()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.RSP_MSG
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r8)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r13 = r0.addVarTable((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar) r13)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r13 = r13.build()
            com.cyjh.mq.sdk.MqRunner r0 = com.cyjh.mq.sdk.MqRunner.getInstance()
            com.google.protobuf.ByteString r13 = r13.toByteString()
            r0.a((com.google.protobuf.ByteString) r13)
            return
        L_0x08e2:
            com.cyjh.mobileanjian.ipc.ui.k[] r13 = r12.f2621a
            int r0 = r12.f2622b
            r13 = r13[r0]
            if (r13 != 0) goto L_0x08ee
            a((boolean) r9)
            return
        L_0x08ee:
            com.cyjh.mobileanjian.ipc.ui.k[] r13 = r12.f2621a
            int r0 = r12.f2622b
            r13 = r13[r0]
            android.view.View r13 = r13.b((java.lang.String) r6)
            if (r13 != 0) goto L_0x08fe
            a((boolean) r9)
            return
        L_0x08fe:
            int r13 = r13.getVisibility()
            if (r13 == 0) goto L_0x0909
            r0 = 4
            if (r13 == r0) goto L_0x090c
            if (r13 == r2) goto L_0x090b
        L_0x0909:
            r1 = 1
            goto L_0x090c
        L_0x090b:
            r1 = 3
        L_0x090c:
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r13 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r13 = r13.setControlId(r6)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.INT
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r13 = r13.setType(r0)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r13 = r13.setIntValue(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar r13 = r13.build()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.RSP_MSG
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r8)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r13 = r0.addVarTable((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar) r13)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r13 = r13.build()
            com.cyjh.mq.sdk.MqRunner r0 = com.cyjh.mq.sdk.MqRunner.getInstance()
            com.google.protobuf.ByteString r13 = r13.toByteString()
            r0.a((com.google.protobuf.ByteString) r13)
            return
        L_0x0944:
            com.cyjh.mobileanjian.ipc.ui.k[] r13 = r12.f2621a
            int r0 = r12.f2622b
            r13 = r13[r0]
            if (r13 != 0) goto L_0x0950
            a((boolean) r9)
            return
        L_0x0950:
            com.cyjh.mobileanjian.ipc.ui.k[] r13 = r12.f2621a
            int r0 = r12.f2622b
            r13 = r13[r0]
            android.view.View r13 = r13.b((java.lang.String) r6)
            if (r13 != 0) goto L_0x0960
            a((boolean) r9)
            return
        L_0x0960:
            boolean r0 = r13.isEnabled()
            java.util.HashMap[] r1 = r12.f2623c
            int r2 = r12.f2622b
            r1 = r1[r2]
            java.lang.Object r1 = r1.get(r6)
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.EDIT_TEXT
            if (r1 != r2) goto L_0x0978
            android.widget.EditText r13 = (android.widget.EditText) r13
            boolean r0 = r13.isFocusable()
        L_0x0978:
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r13 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r13 = r13.setControlId(r6)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.BOOL
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r13 = r13.setType(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r13 = r13.setBoolValue(r0)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar r13 = r13.build()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.RSP_MSG
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r8)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r13 = r0.addVarTable((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar) r13)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r13 = r13.build()
            com.cyjh.mq.sdk.MqRunner r0 = com.cyjh.mq.sdk.MqRunner.getInstance()
            com.google.protobuf.ByteString r13 = r13.toByteString()
            r0.a((com.google.protobuf.ByteString) r13)
            return
        L_0x09b0:
            r12.k((java.lang.String) r6)
            return
        L_0x09b4:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r12.f2621a
            int r1 = r12.f2622b
            r0 = r0[r1]
            if (r0 != 0) goto L_0x09c0
            a((boolean) r9)
            return
        L_0x09c0:
            java.lang.String r0 = r13.getControlId()
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r12.f2621a
            int r2 = r12.f2622b
            r1 = r1[r2]
            android.view.View r1 = r1.b((java.lang.String) r0)
            if (r1 != 0) goto L_0x09d4
            a((boolean) r9)
            return
        L_0x09d4:
            java.lang.String r13 = r13.getColor()
            java.lang.String r2 = "^#*([0-9A-Fa-f]{6})|([0-9A-Fa-f]{3})"
            boolean r2 = r13.matches(r2)
            if (r2 != 0) goto L_0x09eb
            int r13 = com.cyjh.mqsdk.R.string.ui_show_invalid_color_value
            java.lang.Object[] r0 = new java.lang.Object[r9]
            r12.a((int) r13, (java.lang.Object[]) r0)
            a((boolean) r9)
            return
        L_0x09eb:
            java.lang.String r2 = "#"
            boolean r2 = r13.startsWith(r2)
            if (r2 != 0) goto L_0x0a01
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "#"
            r2.<init>(r3)
            r2.append(r13)
            java.lang.String r13 = r2.toString()
        L_0x0a01:
            int r13 = android.graphics.Color.parseColor(r13)
            int r13 = com.cyjh.mobileanjian.ipc.utils.c.a(r13)
            java.util.HashMap[] r2 = r12.f2623c
            int r3 = r12.f2622b
            r2 = r2[r3]
            java.lang.Object r2 = r2.get(r0)
            com.cyjh.mobileanjian.ipc.ui.m r3 = com.cyjh.mobileanjian.ipc.ui.m.BUTTON
            if (r2 != r3) goto L_0x0a2b
            android.graphics.drawable.GradientDrawable r0 = new android.graphics.drawable.GradientDrawable
            r0.<init>()
            r0.setColor(r13)
            int r13 = r12.c()
            float r13 = (float) r13
            r0.setCornerRadius(r13)
            r1.setBackground(r0)
            goto L_0x0a3c
        L_0x0a2b:
            java.util.HashMap[] r2 = r12.f2623c
            int r3 = r12.f2622b
            r2 = r2[r3]
            java.lang.Object r0 = r2.get(r0)
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.SPINNER
            if (r0 == r2) goto L_0x0a3c
            r1.setBackgroundColor(r13)
        L_0x0a3c:
            a((boolean) r8)
            return
        L_0x0a40:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r12.f2621a
            int r1 = r12.f2622b
            r0 = r0[r1]
            if (r0 != 0) goto L_0x0a4c
            a((boolean) r9)
            return
        L_0x0a4c:
            java.lang.String r0 = r13.getControlId()
            java.lang.String r1 = r13.getColor()
            java.lang.String r2 = "^#*([0-9A-Fa-f]{6})|([0-9A-Fa-f]{3})"
            boolean r2 = r1.matches(r2)
            if (r2 != 0) goto L_0x0a67
            int r13 = com.cyjh.mqsdk.R.string.ui_show_invalid_color_value
            java.lang.Object[] r0 = new java.lang.Object[r9]
            r12.a((int) r13, (java.lang.Object[]) r0)
            a((boolean) r9)
            return
        L_0x0a67:
            java.lang.String r2 = "#"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x0a7d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "#"
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
        L_0x0a7d:
            int r1 = android.graphics.Color.parseColor(r1)
            int r1 = com.cyjh.mobileanjian.ipc.utils.c.a(r1)
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r12.n
            java.lang.Object r2 = r2.get(r0)
            if (r2 == 0) goto L_0x0aa1
            com.cyjh.mobileanjian.ipc.ui.k[] r13 = r12.f2621a
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = r12.n
            java.lang.Object r0 = r2.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r13 = r13[r0]
            r13.a((int) r1)
            goto L_0x0afd
        L_0x0aa1:
            com.cyjh.mobileanjian.ipc.ui.k[] r2 = r12.f2621a
            int r3 = r12.f2622b
            r2 = r2[r3]
            android.view.View r2 = r2.b((java.lang.String) r0)
            if (r2 != 0) goto L_0x0ab1
            a((boolean) r9)
            return
        L_0x0ab1:
            int[] r3 = com.cyjh.mobileanjian.ipc.ui.h.AnonymousClass4.f2631b
            java.util.HashMap[] r4 = r12.f2623c
            int r5 = r12.f2622b
            r4 = r4[r5]
            java.lang.Object r0 = r4.get(r0)
            com.cyjh.mobileanjian.ipc.ui.m r0 = (com.cyjh.mobileanjian.ipc.ui.m) r0
            int r0 = r0.ordinal()
            r0 = r3[r0]
            switch(r0) {
                case 1: goto L_0x0af8;
                case 2: goto L_0x0af8;
                case 3: goto L_0x0af8;
                case 4: goto L_0x0af2;
                case 5: goto L_0x0adc;
                case 6: goto L_0x0acc;
                default: goto L_0x0ac8;
            }
        L_0x0ac8:
            a((boolean) r9)
            return
        L_0x0acc:
            android.widget.Spinner r2 = (android.widget.Spinner) r2
            int r13 = r13.getItemIndex()
            int r0 = r2.getCount()
            if (r13 < r0) goto L_0x0afd
            a((boolean) r9)
            return
        L_0x0adc:
            android.widget.RadioGroup r2 = (android.widget.RadioGroup) r2
            int r13 = r13.getItemIndex()
            android.view.View r13 = r2.findViewById(r13)
            android.widget.RadioButton r13 = (android.widget.RadioButton) r13
            if (r13 != 0) goto L_0x0aee
            a((boolean) r9)
            return
        L_0x0aee:
            r13.setTextColor(r1)
            goto L_0x0afd
        L_0x0af2:
            android.widget.CheckBox r2 = (android.widget.CheckBox) r2
            r2.setTextColor(r1)
            goto L_0x0afd
        L_0x0af8:
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setTextColor(r1)
        L_0x0afd:
            a((boolean) r8)
            return
        L_0x0b01:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r12.f2621a
            int r1 = r12.f2622b
            r0 = r0[r1]
            if (r0 != 0) goto L_0x0b0d
            a((boolean) r9)
            return
        L_0x0b0d:
            java.lang.String r0 = r13.getControlId()
            java.util.HashMap[] r1 = r12.f2623c
            int r2 = r12.f2622b
            r1 = r1[r2]
            java.lang.Object r1 = r1.get(r0)
            if (r1 != 0) goto L_0x0b21
            a((boolean) r9)
            return
        L_0x0b21:
            int[] r1 = com.cyjh.mobileanjian.ipc.ui.h.AnonymousClass4.f2631b
            java.util.HashMap[] r2 = r12.f2623c
            int r3 = r12.f2622b
            r2 = r2[r3]
            java.lang.Object r2 = r2.get(r0)
            com.cyjh.mobileanjian.ipc.ui.m r2 = (com.cyjh.mobileanjian.ipc.ui.m) r2
            int r2 = r2.ordinal()
            r1 = r1[r2]
            switch(r1) {
                case 1: goto L_0x0ba5;
                case 2: goto L_0x0ba5;
                case 3: goto L_0x0ba5;
                case 4: goto L_0x0b94;
                case 5: goto L_0x0b73;
                case 6: goto L_0x0b3c;
                default: goto L_0x0b38;
            }
        L_0x0b38:
            a((boolean) r9)
            return
        L_0x0b3c:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r12.f2621a
            int r2 = r12.f2622b
            r1 = r1[r2]
            android.view.View r1 = r1.b((java.lang.String) r0)
            android.widget.Spinner r1 = (android.widget.Spinner) r1
            int r2 = r13.getItemIndex()
            int r3 = r1.getCount()
            if (r2 < r3) goto L_0x0b56
            a((boolean) r9)
            return
        L_0x0b56:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Spinner Get pos: "
            r2.<init>(r3)
            int r3 = r13.getItemIndex()
            java.lang.Object r3 = r1.getItemAtPosition(r3)
            r2.append(r3)
            int r13 = r13.getItemIndex()
            java.lang.Object r13 = r1.getItemAtPosition(r13)
            java.lang.String r13 = (java.lang.String) r13
            goto L_0x0bb9
        L_0x0b73:
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r12.f2621a
            int r2 = r12.f2622b
            r1 = r1[r2]
            android.view.View r1 = r1.b((java.lang.String) r0)
            android.widget.RadioGroup r1 = (android.widget.RadioGroup) r1
            int r13 = r13.getItemIndex()
            android.view.View r13 = r1.findViewById(r13)
            android.widget.RadioButton r13 = (android.widget.RadioButton) r13
            if (r13 != 0) goto L_0x0b8f
            a((boolean) r9)
            return
        L_0x0b8f:
            java.lang.CharSequence r13 = r13.getText()
            goto L_0x0bb5
        L_0x0b94:
            com.cyjh.mobileanjian.ipc.ui.k[] r13 = r12.f2621a
            int r1 = r12.f2622b
            r13 = r13[r1]
            android.view.View r13 = r13.b((java.lang.String) r0)
            android.widget.CheckBox r13 = (android.widget.CheckBox) r13
            java.lang.CharSequence r13 = r13.getText()
            goto L_0x0bb5
        L_0x0ba5:
            com.cyjh.mobileanjian.ipc.ui.k[] r13 = r12.f2621a
            int r1 = r12.f2622b
            r13 = r13[r1]
            android.view.View r13 = r13.b((java.lang.String) r0)
            android.widget.TextView r13 = (android.widget.TextView) r13
            java.lang.CharSequence r13 = r13.getText()
        L_0x0bb5:
            java.lang.String r13 = r13.toString()
        L_0x0bb9:
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = r1.setControlId(r0)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.STRING
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = r0.setType(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r13 = r0.setStringValue(r13)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar r13 = r13.build()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.RSP_MSG
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r8)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r13 = r0.addVarTable((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar) r13)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r13 = r13.build()
            com.cyjh.mq.sdk.MqRunner r0 = com.cyjh.mq.sdk.MqRunner.getInstance()
            com.google.protobuf.ByteString r13 = r13.toByteString()
            r0.a((com.google.protobuf.ByteString) r13)
            return
        L_0x0bf1:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r12.f2621a
            int r1 = r12.f2622b
            r0 = r0[r1]
            if (r0 != 0) goto L_0x0bfd
            a((boolean) r9)
            return
        L_0x0bfd:
            java.lang.String r0 = r13.getControlId()
            r13.getText()
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r12.f2621a
            int r2 = r12.f2622b
            r1 = r1[r2]
            android.view.View r1 = r1.b((java.lang.String) r0)
            if (r1 != 0) goto L_0x0c14
            a((boolean) r9)
            return
        L_0x0c14:
            java.util.HashMap[] r2 = r12.f2623c
            int r3 = r12.f2622b
            r2 = r2[r3]
            java.lang.Object r0 = r2.get(r0)
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.EDIT_TEXT
            if (r0 == r2) goto L_0x0c26
            a((boolean) r9)
            return
        L_0x0c26:
            android.widget.EditText r1 = (android.widget.EditText) r1
            int r13 = r13.getEditInputType()
            r1.setInputType(r13)
            a((boolean) r8)
            return
        L_0x0c33:
            r12.c((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.CommandToUi) r13)
            return
        L_0x0c37:
            r12.e((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.CommandToUi) r13)
            return
        L_0x0c3b:
            java.util.HashMap<java.lang.String, java.lang.Integer> r13 = r12.n
            java.lang.Object r13 = r13.get(r6)
            if (r13 == 0) goto L_0x0c48
            a((boolean) r8)
            goto L_0x10c9
        L_0x0c48:
            java.util.HashMap[] r13 = r12.f2623c
            int r0 = r12.f2622b
            r13 = r13[r0]
            java.lang.Object r13 = r13.get(r6)
            if (r13 != 0) goto L_0x0c59
            a((boolean) r9)
            goto L_0x10c9
        L_0x0c59:
            com.cyjh.mobileanjian.ipc.ui.k[] r13 = r12.f2621a
            int r0 = r12.f2622b
            r13 = r13[r0]
            android.view.View r13 = r13.b((java.lang.String) r6)
            android.view.ViewGroup$LayoutParams r0 = r13.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            r0.width = r4
            r13.setLayoutParams(r0)
            goto L_0x10c9
        L_0x0c70:
            boolean r8 = r12.b((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.CommandToUi) r13)
            goto L_0x10c9
        L_0x0c76:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r12.f2621a
            int r1 = r12.f2622b
            r0 = r0[r1]
            if (r0 == 0) goto L_0x10c9
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r12.f2621a
            int r1 = r12.f2622b
            r0 = r0[r1]
            int r1 = r12.b()
            java.lang.String r2 = r13.getControlId()
            java.lang.String r3 = r13.getParentId()
            java.lang.String r13 = r13.getText()
            boolean r8 = r0.a((int) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r13)
            goto L_0x10c9
        L_0x0c9a:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r12.f2621a
            int r1 = r12.f2622b
            r0 = r0[r1]
            if (r0 == 0) goto L_0x10c9
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r12.f2621a
            int r1 = r12.f2622b
            r0 = r0[r1]
            java.lang.String r1 = r13.getControlId()
            int r13 = r13.getHeight()
            r0.a((java.lang.String) r1, (int) r13)
            goto L_0x10c9
        L_0x0cb5:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r12.f2621a
            int r1 = r12.f2622b
            r0 = r0[r1]
            if (r0 == 0) goto L_0x10c9
            com.cyjh.mobileanjian.ipc.ui.g r0 = r12.m
            r12.b()
            java.util.List r1 = r13.getItemTextList()
            int r2 = r13.getDefaultItemIndex()
            r13.getWidth()
            r13.getHeight()
            android.widget.Spinner r0 = r0.a((java.lang.String) r6, (java.util.List<java.lang.String>) r1, (int) r2)
            java.util.HashMap[] r1 = r12.f2623c
            int r2 = r12.f2622b
            r1 = r1[r2]
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.SPINNER
            r1.put(r6, r2)
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r12.f2621a
            int r2 = r12.f2622b
            r1 = r1[r2]
            java.lang.String r13 = r13.getParentId()
            r1.a((android.view.View) r0, (java.lang.String) r13)
            r0.setOnItemSelectedListener(r12)
            goto L_0x10c9
        L_0x0cf1:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r12.f2621a
            int r1 = r12.f2622b
            r0 = r0[r1]
            if (r0 == 0) goto L_0x10c9
            com.cyjh.mobileanjian.ipc.ui.g r0 = r12.m
            r12.b()
            int r1 = r13.getWidth()
            int r2 = r13.getHeight()
            java.lang.String r3 = r13.getUrl()
            android.webkit.WebView r0 = r0.a((java.lang.String) r6, (int) r1, (int) r2, (java.lang.String) r3)
            java.util.HashMap[] r1 = r12.f2623c
            int r2 = r12.f2622b
            r1 = r1[r2]
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.WEB_VIEW
            r1.put(r6, r2)
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r12.f2621a
            int r2 = r12.f2622b
            r1 = r1[r2]
            goto L_0x0e8b
        L_0x0d21:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r12.f2621a
            int r1 = r12.f2622b
            r0 = r0[r1]
            if (r0 == 0) goto L_0x10c9
            com.cyjh.mobileanjian.ipc.ui.g r0 = r12.m
            int r1 = r12.b()
            int r3 = r13.getWidth()
            int r4 = r13.getHeight()
            java.lang.String r5 = r13.getPath()
            r2 = r6
            android.widget.ImageView r0 = r0.a((int) r1, (java.lang.String) r2, (int) r3, (int) r4, (java.lang.String) r5)
            java.util.HashMap[] r1 = r12.f2623c
            int r2 = r12.f2622b
            r1 = r1[r2]
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.IMAGE_VIEW
            r1.put(r6, r2)
            r0.setOnClickListener(r12)
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r12.f2621a
            int r2 = r12.f2622b
            r1 = r1[r2]
            goto L_0x0e8b
        L_0x0d56:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r12.f2621a
            int r1 = r12.f2622b
            r0 = r0[r1]
            if (r0 == 0) goto L_0x10c9
            com.cyjh.mobileanjian.ipc.ui.g r0 = r12.m
            r12.b()
            java.lang.String r2 = r13.getText()
            int r3 = r13.getWidth()
            int r4 = r13.getHeight()
            boolean r5 = r13.getDefaultCheckStatus()
            r1 = r6
            android.widget.CheckBox r0 = r0.a((java.lang.String) r1, (java.lang.String) r2, (int) r3, (int) r4, (boolean) r5)
            java.util.HashMap[] r1 = r12.f2623c
            int r2 = r12.f2622b
            r1 = r1[r2]
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.CHECK_BOX
            r1.put(r6, r2)
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r12.f2621a
            int r2 = r12.f2622b
            r1 = r1[r2]
            goto L_0x0e8b
        L_0x0d8b:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r12.f2621a
            int r1 = r12.f2622b
            r0 = r0[r1]
            if (r0 == 0) goto L_0x10c9
            com.cyjh.mobileanjian.ipc.ui.g r0 = r12.m
            r12.b()
            java.util.List r2 = r13.getItemTextList()
            int r3 = r13.getDefaultItemIndex()
            int r4 = r13.getWidth()
            int r5 = r13.getHeight()
            r1 = r6
            android.widget.RadioGroup r0 = r0.a((java.lang.String) r1, (java.util.List<java.lang.String>) r2, (int) r3, (int) r4, (int) r5)
            java.util.HashMap[] r1 = r12.f2623c
            int r2 = r12.f2622b
            r1 = r1[r2]
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.RADIIO_GROUP
            r1.put(r6, r2)
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r12.f2621a
            int r2 = r12.f2622b
            r1 = r1[r2]
            goto L_0x0e8b
        L_0x0dc0:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r12.f2621a
            int r1 = r12.f2622b
            r0 = r0[r1]
            if (r0 == 0) goto L_0x10c9
            com.cyjh.mobileanjian.ipc.ui.g r0 = r12.m
            r12.b()
            java.lang.String r1 = r13.getText()
            int r2 = r13.getWidth()
            int r3 = r13.getHeight()
            android.widget.Button r0 = r0.b(r6, r1, r2, r3)
            java.util.HashMap[] r1 = r12.f2623c
            int r2 = r12.f2622b
            r1 = r1[r2]
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.BUTTON
            r1.put(r6, r2)
            r0.setOnClickListener(r12)
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r12.f2621a
            int r2 = r12.f2622b
            r1 = r1[r2]
            goto L_0x0e8b
        L_0x0df3:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r12.f2621a
            int r1 = r12.f2622b
            r0 = r0[r1]
            if (r0 == 0) goto L_0x10c9
            com.cyjh.mobileanjian.ipc.ui.g r0 = r12.m
            r12.b()
            java.lang.String r1 = r13.getText()
            int r2 = r13.getWidth()
            int r3 = r13.getHeight()
            android.widget.EditText r0 = r0.d(r6, r1, r2, r3)
            java.util.HashMap[] r1 = r12.f2623c
            int r2 = r12.f2622b
            r1 = r1[r2]
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.EDIT_TEXT
            r1.put(r6, r2)
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r12.f2621a
            int r2 = r12.f2622b
            r1 = r1[r2]
            java.lang.String r13 = r13.getParentId()
            r1.a((android.view.View) r0, (java.lang.String) r13)
            com.cyjh.mobileanjian.ipc.ui.h$a r13 = new com.cyjh.mobileanjian.ipc.ui.h$a
            r13.<init>(r6)
            r0.addTextChangedListener(r13)
            goto L_0x10c9
        L_0x0e32:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r12.f2621a
            int r1 = r12.f2622b
            r0 = r0[r1]
            if (r0 == 0) goto L_0x10c9
            com.cyjh.mobileanjian.ipc.ui.g r0 = r12.m
            r12.b()
            java.lang.String r1 = r13.getText()
            int r2 = r13.getWidth()
            int r3 = r13.getHeight()
            android.widget.TextView r0 = r0.a((java.lang.String) r6, (java.lang.String) r1, (int) r2, (int) r3)
            java.util.HashMap[] r1 = r12.f2623c
            int r2 = r12.f2622b
            r1 = r1[r2]
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.TEXT_VIEW
            r1.put(r6, r2)
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r12.f2621a
            int r2 = r12.f2622b
            r1 = r1[r2]
            goto L_0x0e8b
        L_0x0e61:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r12.f2621a
            int r1 = r12.f2622b
            r0 = r0[r1]
            if (r0 == 0) goto L_0x10c9
            com.cyjh.mobileanjian.ipc.ui.g r0 = r12.m
            r12.b()
            int r1 = r13.getWidth()
            int r2 = r13.getHeight()
            android.widget.LinearLayout r0 = r0.b(r6, r1, r2)
            java.util.HashMap[] r1 = r12.f2623c
            int r2 = r12.f2622b
            r1 = r1[r2]
            com.cyjh.mobileanjian.ipc.ui.m r2 = com.cyjh.mobileanjian.ipc.ui.m.LINE
            r1.put(r6, r2)
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r12.f2621a
            int r2 = r12.f2622b
            r1 = r1[r2]
        L_0x0e8b:
            java.lang.String r13 = r13.getParentId()
            r1.a((android.view.View) r0, (java.lang.String) r13)
            goto L_0x10c9
        L_0x0e94:
            java.lang.String r0 = r13.getControlId()
            java.lang.String r13 = r13.getColor()
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r12.n
            java.lang.Object r1 = r1.get(r0)
            if (r1 != 0) goto L_0x0eb1
            int r13 = com.cyjh.mqsdk.R.string.ui_show_not_found_ui
            java.lang.Object[] r1 = new java.lang.Object[r8]
            r1[r9] = r0
            r12.a((int) r13, (java.lang.Object[]) r1)
            a((boolean) r9)
            return
        L_0x0eb1:
            java.lang.String r1 = "^#*([0-9A-Fa-f]{6})|([0-9A-Fa-f]{3})"
            boolean r1 = r13.matches(r1)
            if (r1 != 0) goto L_0x0ec4
            int r13 = com.cyjh.mqsdk.R.string.ui_show_invalid_color_value
            java.lang.Object[] r0 = new java.lang.Object[r9]
            r12.a((int) r13, (java.lang.Object[]) r0)
            a((boolean) r9)
            return
        L_0x0ec4:
            java.lang.String r1 = "#"
            boolean r1 = r13.startsWith(r1)
            if (r1 != 0) goto L_0x0eda
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "#"
            r1.<init>(r2)
            r1.append(r13)
            java.lang.String r13 = r1.toString()
        L_0x0eda:
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r12.n
            java.lang.Object r0 = r1.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r13 = android.graphics.Color.parseColor(r13)
            int r13 = com.cyjh.mobileanjian.ipc.utils.c.a(r13)
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r12.f2621a
            r0 = r1[r0]
            r0.b((int) r13)
            a((boolean) r8)
            return
        L_0x0ef9:
            java.util.HashMap<java.lang.String, java.lang.Integer> r13 = r12.n
            java.lang.Object r13 = r13.get(r6)
            if (r13 != 0) goto L_0x0f0e
            int r13 = com.cyjh.mqsdk.R.string.ui_show_not_found_ui
            java.lang.Object[] r0 = new java.lang.Object[r8]
            r0[r9] = r6
            r12.a((int) r13, (java.lang.Object[]) r0)
            a((boolean) r9)
            return
        L_0x0f0e:
            com.cyjh.mobileanjian.ipc.ui.k[] r13 = r12.f2621a
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r12.n
            java.lang.Object r0 = r0.get(r6)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r13 = r13[r0]
            java.lang.String r13 = r13.a()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = r0.setControlId(r6)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Data_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar.Data_Type.STRING
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r0 = r0.setType(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar$Builder r13 = r0.setStringValue(r13)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlVar r13 = r13.build()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.RSP_MSG
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r8)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r13 = r0.addVarTable((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlVar) r13)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r13 = r13.build()
            com.cyjh.mq.sdk.MqRunner r0 = com.cyjh.mq.sdk.MqRunner.getInstance()
            com.google.protobuf.ByteString r13 = r13.toByteString()
            r0.a((com.google.protobuf.ByteString) r13)
            return
        L_0x0f5a:
            java.lang.String r13 = r13.getText()
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r12.n
            java.lang.Object r0 = r0.get(r6)
            if (r0 != 0) goto L_0x0f71
            int r13 = com.cyjh.mqsdk.R.string.ui_show_not_found_ui
            java.lang.Object[] r0 = new java.lang.Object[r8]
            r0[r9] = r6
            r12.a((int) r13, (java.lang.Object[]) r0)
            goto L_0x0070
        L_0x0f71:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r12.f2621a
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r12.n
            java.lang.Object r1 = r1.get(r6)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r0 = r0[r1]
            r0.a((java.lang.String) r13)
            goto L_0x10c9
        L_0x0f86:
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r12.f2621a
            int r1 = r12.f2622b
            r0 = r0[r1]
            if (r0 == 0) goto L_0x10c9
            com.cyjh.mobileanjian.ipc.ui.k[] r0 = r12.f2621a
            int r1 = r12.f2622b
            r0 = r0[r1]
            r12.b()
            java.lang.String r1 = r13.getParentId()
            int r2 = r13.getWidth()
            int r13 = r13.getHeight()
            r0.a((java.lang.String) r6, (java.lang.String) r1, (int) r2, (int) r13)
            goto L_0x10c9
        L_0x0fa8:
            r12.a()
            goto L_0x10c9
        L_0x0fad:
            boolean r8 = r12.j((java.lang.String) r6)
            goto L_0x10c9
        L_0x0fb3:
            r12.j((java.lang.String) r6)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Builder r13 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlEvent.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Builder r13 = r13.setControlId(r6)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Event_Type r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlEvent.Event_Type.ON_CLOSE_CONTINUE
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Builder r13 = r13.setType(r0)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent r13 = r13.build()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.EVENT
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r8)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r13 = r0.setEvent((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlEvent) r13)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r13 = r13.build()
            com.cyjh.mq.sdk.MqRunner r0 = com.cyjh.mq.sdk.MqRunner.getInstance()
            com.google.protobuf.ByteString r13 = r13.toByteString()
            r0.b(r13)
            goto L_0x10c9
        L_0x0feb:
            java.util.HashMap<java.lang.String, java.lang.Integer> r13 = r12.n
            java.lang.Object r13 = r13.get(r6)
            if (r13 != 0) goto L_0x1000
            int r13 = com.cyjh.mqsdk.R.string.ui_show_not_found_ui
            java.lang.Object[] r0 = new java.lang.Object[r8]
            r0[r9] = r6
            r12.a((int) r13, (java.lang.Object[]) r0)
            a((boolean) r9)
            return
        L_0x1000:
            com.cyjh.mobileanjian.ipc.ui.k[] r13 = r12.f2621a
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r12.n
            java.lang.Object r0 = r0.get(r6)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r13 = r13[r0]
            boolean r13 = r13.d()
            if (r13 == 0) goto L_0x101a
            a((boolean) r9)
            return
        L_0x101a:
            com.cyjh.mobileanjian.ipc.ui.k[] r13 = r12.f2621a
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r12.n
            java.lang.Object r0 = r0.get(r6)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r13 = r13[r0]
            r13.c()
            a((boolean) r8)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Builder r13 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlEvent.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Builder r13 = r13.setControlId(r6)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Event_Type r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlEvent.Event_Type.ON_SHOW
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent$Builder r13 = r13.setType(r0)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$ControlEvent r13 = r13.build()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UiToCommand.Command_Type.EVENT
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setCommand(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r0 = r0.setIsSuccess(r8)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand$Builder r13 = r0.setEvent((com.cyjh.mobileanjian.ipc.share.proto.UiMessage.ControlEvent) r13)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UiToCommand r13 = r13.build()
            com.cyjh.mq.sdk.MqRunner r0 = com.cyjh.mq.sdk.MqRunner.getInstance()
            com.google.protobuf.ByteString r13 = r13.toByteString()
            r0.b(r13)
            return
        L_0x1064:
            int r0 = r13.getWidth()
            int r13 = r13.getHeight()
            int r1 = r12.f2622b
            int r1 = r1 + r8
            r12.f2622b = r1
            com.cyjh.mobileanjian.ipc.ui.k[] r1 = r12.f2621a
            int r2 = r12.f2622b
            com.cyjh.mobileanjian.ipc.ui.g r3 = r12.m
            com.cyjh.mobileanjian.ipc.ui.k r13 = r3.a((java.lang.String) r6, (int) r0, (int) r13)
            r1[r2] = r13
            java.util.HashMap<java.lang.String, java.lang.Integer> r13 = r12.n
            int r0 = r12.f2622b
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r13.put(r6, r0)
            java.util.HashMap[] r13 = r12.f2623c
            int r0 = r12.f2622b
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r13[r0] = r1
            com.cyjh.mobileanjian.ipc.ui.k[] r13 = r12.f2621a
            int r0 = r12.f2622b
            r13 = r13[r0]
            com.cyjh.mobileanjian.ipc.ui.h$2 r0 = new com.cyjh.mobileanjian.ipc.ui.h$2
            r0.<init>(r6)
            r13.b((android.view.View.OnClickListener) r0)
            com.cyjh.mobileanjian.ipc.ui.k[] r13 = r12.f2621a
            int r0 = r12.f2622b
            r13 = r13[r0]
            com.cyjh.mobileanjian.ipc.ui.h$3 r0 = new com.cyjh.mobileanjian.ipc.ui.h$3
            r0.<init>(r6)
            r13.a((android.view.View.OnClickListener) r0)
            goto L_0x10c9
        L_0x10b0:
            java.lang.String r13 = r13.getPath()     // Catch:{ IOException -> 0x10c0, JSONException -> 0x10c5 }
            r12.f((java.lang.String) r13)     // Catch:{ IOException -> 0x10c0, JSONException -> 0x10c5 }
            goto L_0x10c9
        L_0x10b8:
            java.lang.String r13 = r13.getPath()     // Catch:{  }
            r12.e((java.lang.String) r13)     // Catch:{  }
            goto L_0x10c9
        L_0x10c0:
            r13 = move-exception
            r13.printStackTrace()
            goto L_0x10c9
        L_0x10c5:
            r13 = move-exception
            r13.printStackTrace()
        L_0x10c9:
            a((boolean) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.ui.h.a(com.cyjh.mobileanjian.ipc.share.proto.UiMessage$CommandToUi):void");
    }

    public final void onClick(View view) {
        MqRunner.getInstance().b(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setEvent(UiMessage.ControlEvent.newBuilder().setControlId((String) view.getTag()).setType(UiMessage.ControlEvent.Event_Type.ON_CLICK).build()).setIsSuccess(true).build().toByteString());
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        MqRunner.getInstance().b(UiMessage.UiToCommand.newBuilder().setCommand(UiMessage.UiToCommand.Command_Type.EVENT).setEvent(UiMessage.ControlEvent.newBuilder().setControlId((String) adapterView.getTag()).setEventArgs(String.valueOf(i2)).setType(UiMessage.ControlEvent.Event_Type.ON_CLICK).build()).setIsSuccess(true).build().toByteString());
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
