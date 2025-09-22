package com.elfin.engin.b;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.cyjh.mqm.MiscUtilities;
import com.elfin.engin.b.a.a;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    protected ArrayList<CheckBox> f2895a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    protected ArrayList<Spinner> f2896b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    protected ArrayList<EditText> f2897c = new ArrayList<>();
    private Context d;
    private File e;
    private File f;
    private String g;

    private b(Context context) {
        this.d = context;
    }

    public b(Context context, String str, String str2) {
        this.e = new File(str);
        this.f = new File(str2);
        this.d = context;
        Log.e("a111111", "ScriptUiModel " + str);
    }

    private int a(int i) {
        return this.d.getResources().getInteger(i);
    }

    private LinearLayout a(JsonReader jsonReader) throws IOException {
        View f2;
        LinearLayout linearLayout = new LinearLayout(this.d);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_linearlayout")).equalsIgnoreCase(nextName)) {
                f2 = b(jsonReader);
            } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_textview")).equalsIgnoreCase(nextName)) {
                f2 = c(jsonReader);
            } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_edittext")).equalsIgnoreCase(nextName)) {
                f2 = d(jsonReader);
            } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_checkbox")).equals(nextName)) {
                f2 = e(jsonReader);
            } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_spinner")).equalsIgnoreCase(nextName)) {
                f2 = f(jsonReader);
            }
            linearLayout.addView(f2);
        }
        jsonReader.endObject();
        return linearLayout;
    }

    private void a(File file) throws JSONException {
        String str;
        if (file != null && file.exists() && !file.isDirectory() && file.length() != 0) {
            try {
                str = TextUtils.isEmpty(this.g) ? FileUtils.readFileToString(file, "UTF-8") : this.g;
            } catch (IOException e2) {
                e2.printStackTrace();
                str = null;
            }
            JSONObject jSONObject = new JSONObject(str);
            Iterator<Spinner> it = this.f2896b.iterator();
            while (it.hasNext()) {
                Spinner next = it.next();
                try {
                    int i = jSONObject.getInt(next.getTag().toString());
                    if (i >= next.getCount()) {
                        next.setSelection(0);
                    } else {
                        next.setSelection(i);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            Iterator<CheckBox> it2 = this.f2895a.iterator();
            while (it2.hasNext()) {
                CheckBox next2 = it2.next();
                try {
                    next2.setChecked(jSONObject.getBoolean(next2.getTag().toString()));
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            Iterator<EditText> it3 = this.f2897c.iterator();
            while (it3.hasNext()) {
                EditText next3 = it3.next();
                try {
                    next3.setText(jSONObject.getString(next3.getTag().toString()));
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    private LinearLayout b(JsonReader jsonReader) throws IOException {
        View f2;
        LinearLayout linearLayout = new LinearLayout(this.d);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_linearlayout")).equalsIgnoreCase(nextName)) {
                f2 = b(jsonReader);
            } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_textview")).equalsIgnoreCase(nextName)) {
                f2 = c(jsonReader);
            } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_edittext")).equalsIgnoreCase(nextName)) {
                f2 = d(jsonReader);
            } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_checkbox")).equals(nextName)) {
                f2 = e(jsonReader);
            } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_spinner")).equalsIgnoreCase(nextName)) {
                f2 = f(jsonReader);
            } else {
                jsonReader.skipValue();
            }
            linearLayout.addView(f2);
        }
        jsonReader.endObject();
        return linearLayout;
    }

    private String b(File file) throws Exception {
        if (file == null || file.isDirectory()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        Iterator<CheckBox> it = this.f2895a.iterator();
        while (it.hasNext()) {
            CheckBox next = it.next();
            try {
                jSONObject.put(next.getTag().toString(), next.isChecked());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        Iterator<Spinner> it2 = this.f2896b.iterator();
        while (it2.hasNext()) {
            Spinner next2 = it2.next();
            try {
                jSONObject.put(next2.getTag().toString(), next2.getSelectedItemPosition());
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        Iterator<EditText> it3 = this.f2897c.iterator();
        while (it3.hasNext()) {
            EditText next3 = it3.next();
            try {
                jSONObject.put(next3.getTag().toString(), next3.getText().toString());
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        FileUtils.writeStringToFile(file, jSONObject.toString(), "UTF-8");
        return jSONObject.toString();
    }

    private LinearLayout c(String str) {
        JsonReader jsonReader = new JsonReader(new StringReader(str));
        LinearLayout linearLayout = new LinearLayout(this.d);
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.nextName().startsWith(this.d.getString(com.elfin.engin.c.a.a("string", "ui_activity")))) {
                    linearLayout = a(jsonReader);
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            jsonReader.close();
        } catch (Exception unused) {
        }
        return linearLayout;
    }

    private TextView c(JsonReader jsonReader) throws IOException {
        TextView textView = new TextView(this.d);
        textView.setGravity(17);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setTextSize((float) a(com.elfin.engin.c.a.a("integer", "ui_textSize_normal")));
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_name")).equalsIgnoreCase(nextName)) {
                textView.setTag(jsonReader.nextString());
            } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_textview_textcontent")).equalsIgnoreCase(nextName)) {
                textView.setText(jsonReader.nextString());
            } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_textsize")).equalsIgnoreCase(nextName)) {
                int nextInt = jsonReader.nextInt();
                if (nextInt <= a(com.elfin.engin.c.a.a("integer", "ui_textsize_min"))) {
                    if (nextInt != a(com.elfin.engin.c.a.a("integer", "ui_textSize_default"))) {
                        nextInt = a(com.elfin.engin.c.a.a("integer", "ui_textsize_min"));
                    }
                }
                textView.setTextSize((float) nextInt);
            } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_layout_height")).equalsIgnoreCase(nextName)) {
                int nextInt2 = jsonReader.nextInt();
                if (nextInt2 > a(com.elfin.engin.c.a.a("integer", "ui_default_height"))) {
                    textView.setHeight(nextInt2);
                }
            } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_layout_width")).equalsIgnoreCase(nextName)) {
                int nextInt3 = jsonReader.nextInt();
                if (nextInt3 > a(com.elfin.engin.c.a.a("integer", "ui_default_width"))) {
                    textView.setWidth(nextInt3);
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return textView;
    }

    private EditText d(JsonReader jsonReader) throws IOException {
        boolean z;
        EditText editText = new EditText(this.d);
        editText.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        editText.setTextSize((float) a(com.elfin.engin.c.a.a("integer", "ui_textSize_normal")));
        editText.setSingleLine(true);
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_name")).equalsIgnoreCase(nextName)) {
                editText.setTag(jsonReader.nextString());
            } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_edittext_hintcontent")).equalsIgnoreCase(nextName)) {
                editText.setHint(jsonReader.nextString());
            } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_textsize")).equalsIgnoreCase(nextName)) {
                int nextInt = jsonReader.nextInt();
                if (nextInt <= a(com.elfin.engin.c.a.a("integer", "ui_textsize_min"))) {
                    if (nextInt != a(com.elfin.engin.c.a.a("integer", "ui_textSize_default"))) {
                        nextInt = a(com.elfin.engin.c.a.a("integer", "ui_textsize_min"));
                    }
                }
                editText.setTextSize((float) nextInt);
            } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_layout_height")).equalsIgnoreCase(nextName)) {
                int nextInt2 = jsonReader.nextInt();
                if (nextInt2 > a(com.elfin.engin.c.a.a("integer", "ui_default_height"))) {
                    editText.setHeight(nextInt2);
                }
            } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_layout_width")).equalsIgnoreCase(nextName)) {
                int nextInt3 = jsonReader.nextInt();
                if (nextInt3 > a(com.elfin.engin.c.a.a("integer", "ui_default_width"))) {
                    editText.setWidth(nextInt3);
                }
            } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_edittext_maxlength")).equalsIgnoreCase(nextName)) {
                int nextInt4 = jsonReader.nextInt();
                if (nextInt4 > 0) {
                    editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(nextInt4)});
                }
            } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_edittext_inputnumber")).equalsIgnoreCase(nextName)) {
                try {
                    z = jsonReader.nextBoolean();
                } catch (Exception unused) {
                    z = false;
                }
                if (z) {
                    editText.setInputType(2);
                }
            } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_edittext_defaultcontent")).equalsIgnoreCase(nextName)) {
                editText.setText(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        this.f2897c.add(editText);
        jsonReader.endObject();
        return editText;
    }

    private CheckBox e(JsonReader jsonReader) throws IOException {
        CheckBox checkBox = new CheckBox(this.d);
        checkBox.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        checkBox.setTextSize((float) a(com.elfin.engin.c.a.a("integer", "ui_textSize_normal")));
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_name")).equalsIgnoreCase(nextName)) {
                checkBox.setTag(jsonReader.nextString());
            } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_checkbox_hintcontent")).equalsIgnoreCase(nextName)) {
                checkBox.setText(jsonReader.nextString());
            } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_checkbox_checked")).equalsIgnoreCase(nextName)) {
                checkBox.setChecked(jsonReader.nextBoolean());
            } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_textsize")).equalsIgnoreCase(nextName)) {
                int nextInt = jsonReader.nextInt();
                if (nextInt <= a(com.elfin.engin.c.a.a("integer", "ui_textsize_min"))) {
                    if (nextInt != a(com.elfin.engin.c.a.a("integer", "ui_textSize_default"))) {
                        nextInt = a(com.elfin.engin.c.a.a("integer", "ui_textsize_min"));
                    }
                }
                checkBox.setTextSize((float) nextInt);
            } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_layout_height")).equalsIgnoreCase(nextName)) {
                int nextInt2 = jsonReader.nextInt();
                if (nextInt2 > a(com.elfin.engin.c.a.a("integer", "ui_default_height"))) {
                    checkBox.setHeight(nextInt2);
                }
            } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_layout_width")).equalsIgnoreCase(nextName)) {
                int nextInt3 = jsonReader.nextInt();
                if (nextInt3 > a(com.elfin.engin.c.a.a("integer", "ui_default_width"))) {
                    checkBox.setWidth(nextInt3);
                }
            } else {
                jsonReader.skipValue();
            }
        }
        this.f2895a.add(checkBox);
        jsonReader.endObject();
        return checkBox;
    }

    private Spinner f(JsonReader jsonReader) throws IOException {
        Spinner spinner = new Spinner(this.d);
        spinner.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            try {
                String nextName = jsonReader.nextName();
                ArrayList arrayList = new ArrayList();
                if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_name")).equalsIgnoreCase(nextName)) {
                    spinner.setTag(jsonReader.nextString());
                } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_spinner_items")).equalsIgnoreCase(nextName)) {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        try {
                            arrayList.add(jsonReader.nextString());
                        } catch (Exception unused) {
                        }
                    }
                    jsonReader.endArray();
                    ArrayAdapter arrayAdapter = new ArrayAdapter(this.d, 17367048, arrayList);
                    arrayAdapter.setDropDownViewResource(17367049);
                    spinner.setAdapter(arrayAdapter);
                } else if (this.d.getString(com.elfin.engin.c.a.a("string", "ui_spinner_defaultitem")).equalsIgnoreCase(nextName)) {
                    try {
                        spinner.setSelection(jsonReader.nextInt(), true);
                    } catch (Exception unused2) {
                        spinner.setSelection(0);
                    }
                } else {
                    jsonReader.skipValue();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        jsonReader.endObject();
        this.f2896b.add(spinner);
        return spinner;
    }

    public final LinearLayout a() throws Exception {
        if (!this.e.exists()) {
            return new LinearLayout(this.d);
        }
        String LoadUIFile = new MiscUtilities().LoadUIFile(this.e.getAbsolutePath(), true);
        Log.e("a111111", "ScriptUiModel parseui begin");
        LinearLayout c2 = c(LoadUIFile);
        Log.e("a111111", "ScriptUiModel end");
        return c2;
    }

    public final void a(String str) {
        this.g = str;
    }

    public final String b() {
        return null;
    }

    public final void b(String str) {
    }

    public final void c() throws JSONException {
        String str;
        try {
            File file = this.f;
            if (file != null && file.exists() && !file.isDirectory() && file.length() != 0) {
                try {
                    str = TextUtils.isEmpty(this.g) ? FileUtils.readFileToString(file, "UTF-8") : this.g;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    str = null;
                }
                JSONObject jSONObject = new JSONObject(str);
                Iterator<Spinner> it = this.f2896b.iterator();
                while (it.hasNext()) {
                    Spinner next = it.next();
                    try {
                        int i = jSONObject.getInt(next.getTag().toString());
                        if (i >= next.getCount()) {
                            next.setSelection(0);
                        } else {
                            next.setSelection(i);
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                Iterator<CheckBox> it2 = this.f2895a.iterator();
                while (it2.hasNext()) {
                    CheckBox next2 = it2.next();
                    try {
                        next2.setChecked(jSONObject.getBoolean(next2.getTag().toString()));
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                Iterator<EditText> it3 = this.f2897c.iterator();
                while (it3.hasNext()) {
                    EditText next3 = it3.next();
                    try {
                        next3.setText(jSONObject.getString(next3.getTag().toString()));
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public final String d() throws Exception {
        return b(this.f);
    }
}
