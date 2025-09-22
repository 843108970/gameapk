package com.cyjh.mobileanjian.ipc.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
import com.cyjh.mqsdk.R;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    LayoutInflater f2618a = LayoutInflater.from(this.f2619b);

    /* renamed from: b  reason: collision with root package name */
    private Context f2619b;

    private g(Context context) {
        this.f2619b = context;
    }

    private int a(float f) {
        return (int) (((double) (this.f2619b.getResources().getDisplayMetrics().density * f)) + 0.5d);
    }

    private int a(int i) {
        return (int) (((float) i) * (((float) this.f2619b.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    private LinearLayout.LayoutParams a(int i, int i2) {
        return b(i, i2);
    }

    private LinearLayout a(int i, String str) {
        LinearLayout linearLayout = (LinearLayout) this.f2618a.inflate(R.layout.ui_show_tab_layout, (ViewGroup) null);
        linearLayout.setId(i);
        linearLayout.setTag(str);
        return linearLayout;
    }

    private TextView a(String str, String str2) {
        return a(str, str2, -2, -2);
    }

    public static g a(Context context) {
        return new g(context);
    }

    private k a(String str) {
        return a(str, -1, -2);
    }

    private int b(float f) {
        return (int) (((double) (f / this.f2619b.getResources().getDisplayMetrics().density)) + 0.5d);
    }

    private Button b(String str, String str2) {
        return b(str, str2, -2, -2);
    }

    private LinearLayout.LayoutParams b(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (!(i == -2 || i2 == -2)) {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
        layoutParams.setMargins(0, 0, a(8), 0);
        return layoutParams;
    }

    private EditText c(String str, String str2) {
        return d(str, str2, -2, -2);
    }

    private TextView e(String str, String str2, int i, int i2) {
        TextView textView = (TextView) this.f2618a.inflate(R.layout.ui_show_text_view, (ViewGroup) null);
        textView.setTag(str);
        textView.setText(str2);
        textView.setLayoutParams(b(i, i2));
        return textView;
    }

    private TextView f(String str, String str2, int i, int i2) {
        TextView textView = (TextView) this.f2618a.inflate(R.layout.ui_float_text_view, (ViewGroup) null);
        textView.setTag(str);
        textView.setText(str2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (!(i == -2 || i2 == -2)) {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    private Button g(String str, String str2, int i, int i2) {
        Button button = (Button) this.f2618a.inflate(R.layout.ui_show_button, (ViewGroup) null);
        button.setTag(str);
        button.setText(str2);
        button.setAllCaps(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i2);
        layoutParams.setMargins(0, 0, a(8), 0);
        button.setLayoutParams(layoutParams);
        button.setBackgroundResource(R.drawable.bg_default_button);
        return button;
    }

    private Button h(String str, String str2, int i, int i2) {
        Button button = (Button) this.f2618a.inflate(R.layout.ui_float_button, (ViewGroup) null);
        button.setTag(str);
        button.setText(str2);
        button.setAllCaps(false);
        button.setLayoutParams((i == 0 && i2 == 0) ? new RelativeLayout.LayoutParams(-1, 100) : new RelativeLayout.LayoutParams(i, i2));
        return button;
    }

    public final WebView a(String str, int i, int i2, String str2) {
        if (!str2.startsWith("http://") && !str2.startsWith("https://")) {
            str2 = "http://" + str2;
        }
        WebView webView = new WebView(this.f2619b);
        webView.setTag(str);
        webView.setLayoutParams(new LinearLayout.LayoutParams(i, i2));
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(str2);
        webView.setWebViewClient(new WebViewClient() {
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
        return webView;
    }

    public final CheckBox a(String str, String str2, int i, int i2, boolean z) {
        CheckBox checkBox = (CheckBox) LayoutInflater.from(this.f2619b).inflate(R.layout.ui_show_checkbox, (ViewGroup) null);
        checkBox.setTag(str);
        checkBox.setText(str2);
        checkBox.setChecked(z);
        checkBox.setLayoutParams(b(i, i2));
        checkBox.setPadding(0, 0, 0, 0);
        return checkBox;
    }

    public final ImageView a(int i, String str, int i2, int i3, String str2) {
        ImageView imageView = new ImageView(this.f2619b);
        imageView.setId(i);
        imageView.setTag(str);
        imageView.setLayoutParams(b(i2, i3));
        imageView.setImageURI(Uri.fromFile(new File(str2)));
        return imageView;
    }

    public final RadioGroup a(String str, List<String> list, int i, int i2, int i3) {
        RadioGroup radioGroup = new RadioGroup(this.f2619b);
        radioGroup.setTag(str);
        radioGroup.setLayoutParams(b(i2, i3));
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            RadioButton radioButton = (RadioButton) this.f2618a.inflate(R.layout.ui_show_radio_button, (ViewGroup) null);
            radioButton.setId(i5);
            radioButton.setText(list.get(i5));
            radioButton.setLayoutParams(b(-2, -2));
            radioButton.setPadding(0, a(5), 0, a(5));
            radioGroup.addView(radioButton);
            if (i5 >= 100) {
                break;
            }
        }
        radioGroup.clearCheck();
        if (i < radioGroup.getChildCount()) {
            i4 = i;
        }
        radioGroup.check(i4);
        return radioGroup;
    }

    public final Spinner a(String str, List<String> list, int i) {
        Spinner spinner = (Spinner) this.f2618a.inflate(R.layout.ui_show_spinner, (ViewGroup) null);
        spinner.setTag(str);
        spinner.setLayoutParams(b(-2, -2));
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.f2619b, R.layout.ui_show_spinner_dropdown_item, list);
        spinner.setAdapter(arrayAdapter);
        if (i >= arrayAdapter.getCount()) {
            i = 0;
        }
        spinner.setSelection(i);
        return spinner;
    }

    public final TextView a(String str, String str2, int i, int i2) {
        TextView textView = (TextView) this.f2618a.inflate(R.layout.ui_show_text_view, (ViewGroup) null);
        textView.setTag(str);
        textView.setText(str2);
        textView.setLayoutParams(b(i, i2));
        return textView;
    }

    public final j a(String str, int i, int i2, int i3, int i4) {
        return new j(this.f2619b, str, i, i2, i3, i4);
    }

    public final k a(String str, int i, int i2) {
        return new k(this.f2619b, str, i, i2);
    }

    public final Button b(String str, String str2, int i, int i2) {
        Button button = (Button) this.f2618a.inflate(R.layout.ui_show_button, (ViewGroup) null);
        button.setTag(str);
        button.setText(str2);
        button.setAllCaps(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i2);
        layoutParams.setMargins(0, 0, a(8), 0);
        button.setLayoutParams(layoutParams);
        button.setBackgroundResource(R.drawable.bg_default_button);
        return button;
    }

    public final LinearLayout b(String str, int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.f2619b);
        linearLayout.setTag(str);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-16777216);
        if (i == -1) {
            i = 3000;
        }
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(i, i2));
        return linearLayout;
    }

    public final ImageView c(String str, String str2, int i, int i2) {
        Bitmap bitmap;
        ImageView imageView = (ImageView) this.f2618a.inflate(R.layout.ui_show_image_view, (ViewGroup) null);
        imageView.setTag(str);
        try {
            bitmap = BitmapFactory.decodeStream(new FileInputStream(str2));
        } catch (Exception e) {
            e.printStackTrace();
            bitmap = null;
        }
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (!(i == -2 || i2 == -2)) {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public final LinearLayout c(String str, int i, int i2) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f2619b).inflate(R.layout.ui_show_row, (ViewGroup) null);
        linearLayout.setOrientation(0);
        linearLayout.setTag(str);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(i, i2));
        return linearLayout;
    }

    public final EditText d(String str, String str2, int i, int i2) {
        EditText editText = (EditText) this.f2618a.inflate(R.layout.ui_show_edit_text, (ViewGroup) null);
        editText.setTag(str);
        editText.setText(str2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i2);
        layoutParams.setMargins(0, 0, a(8), 0);
        editText.setLayoutParams(layoutParams);
        editText.setBackgroundResource(R.drawable.bg_edit_text);
        return editText;
    }
}
