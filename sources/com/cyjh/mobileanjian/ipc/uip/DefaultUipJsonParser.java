package com.cyjh.mobileanjian.ipc.uip;

import android.content.Context;
import android.text.InputFilter;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.JsonReader;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.cyjh.mobileanjian.ipc.uip.b;
import com.cyjh.mqsdk.R;
import java.io.IOException;
import java.util.ArrayList;

public class DefaultUipJsonParser implements IUipJsonParser {
    protected Context mContext;
    private b.a mDefaultFlowLayoutChildLayoutParams = new b.a(-2, -2);

    public DefaultUipJsonParser(Context context) {
        this.mContext = context;
        this.mDefaultFlowLayoutChildLayoutParams.f2694a = 17;
    }

    public Button parseButton(JsonReader jsonReader) throws IOException, IllegalStateException {
        Button button = new Button(this.mContext);
        button.setGravity(17);
        button.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        button.setTextSize((float) this.mContext.getResources().getInteger(R.integer.ui_textSize_normal));
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (this.mContext.getString(R.string.ui_name).equalsIgnoreCase(nextName)) {
                button.setTag(jsonReader.nextString());
            } else if (this.mContext.getString(R.string.ui_textview_textcontent).equalsIgnoreCase(nextName)) {
                button.setText(jsonReader.nextString());
            } else if (this.mContext.getString(R.string.ui_onclick).equalsIgnoreCase(nextName)) {
                button.setTag(R.id.uip_function_key, jsonReader.nextString());
            } else if (this.mContext.getString(R.string.ui_textsize).equalsIgnoreCase(nextName)) {
                int nextInt = jsonReader.nextInt();
                if (nextInt <= this.mContext.getResources().getInteger(R.integer.ui_textsize_min)) {
                    if (nextInt != this.mContext.getResources().getInteger(R.integer.ui_textSize_default)) {
                        nextInt = this.mContext.getResources().getInteger(R.integer.ui_textsize_min);
                    }
                }
                button.setTextSize((float) nextInt);
            } else if (this.mContext.getString(R.string.ui_layout_height).equalsIgnoreCase(nextName)) {
                int nextInt2 = jsonReader.nextInt();
                if (nextInt2 > this.mContext.getResources().getInteger(R.integer.ui_default_height)) {
                    button.setHeight(nextInt2);
                }
            } else if (this.mContext.getString(R.string.ui_layout_width).equalsIgnoreCase(nextName)) {
                int nextInt3 = jsonReader.nextInt();
                if (nextInt3 > this.mContext.getResources().getInteger(R.integer.ui_default_width)) {
                    button.setWidth(nextInt3);
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return button;
    }

    public CheckBox parseCheckBox(JsonReader jsonReader) throws IOException, IllegalStateException {
        CheckBox checkBox = new CheckBox(this.mContext);
        checkBox.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        checkBox.setTextSize((float) this.mContext.getResources().getInteger(R.integer.ui_textSize_normal));
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (this.mContext.getString(R.string.ui_name).equalsIgnoreCase(nextName)) {
                checkBox.setTag(jsonReader.nextString());
            } else if (this.mContext.getString(R.string.ui_onclick).equalsIgnoreCase(nextName)) {
                checkBox.setTag(R.id.uip_function_key, jsonReader.nextString());
            } else if (this.mContext.getString(R.string.ui_checkbox_hintcontent).equalsIgnoreCase(nextName)) {
                checkBox.setText(jsonReader.nextString());
            } else if (this.mContext.getString(R.string.ui_checkbox_checked).equalsIgnoreCase(nextName)) {
                checkBox.setChecked(jsonReader.nextBoolean());
            } else if (this.mContext.getString(R.string.ui_textsize).equalsIgnoreCase(nextName)) {
                int nextInt = jsonReader.nextInt();
                if (nextInt <= this.mContext.getResources().getInteger(R.integer.ui_textsize_min)) {
                    if (nextInt != this.mContext.getResources().getInteger(R.integer.ui_textSize_default)) {
                        nextInt = this.mContext.getResources().getInteger(R.integer.ui_textsize_min);
                    }
                }
                checkBox.setTextSize((float) nextInt);
            } else if (this.mContext.getString(R.string.ui_layout_height).equalsIgnoreCase(nextName)) {
                int nextInt2 = jsonReader.nextInt();
                if (nextInt2 > this.mContext.getResources().getInteger(R.integer.ui_default_height)) {
                    checkBox.setHeight(nextInt2);
                }
            } else if (this.mContext.getString(R.string.ui_layout_width).equalsIgnoreCase(nextName)) {
                int nextInt3 = jsonReader.nextInt();
                if (nextInt3 > this.mContext.getResources().getInteger(R.integer.ui_default_width)) {
                    checkBox.setWidth(nextInt3);
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return checkBox;
    }

    public EditText parseEditText(JsonReader jsonReader) throws IOException, IllegalStateException {
        boolean z;
        boolean z2;
        EditText editText = new EditText(this.mContext);
        editText.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        editText.setTextSize((float) this.mContext.getResources().getInteger(R.integer.ui_textSize_normal));
        editText.setSingleLine(true);
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (this.mContext.getString(R.string.ui_name).equalsIgnoreCase(nextName)) {
                editText.setTag(jsonReader.nextString());
            } else if (this.mContext.getString(R.string.ui_edittext_hintcontent).equalsIgnoreCase(nextName)) {
                editText.setHint(jsonReader.nextString());
            } else if (this.mContext.getString(R.string.ui_textsize).equalsIgnoreCase(nextName)) {
                int nextInt = jsonReader.nextInt();
                if (nextInt <= this.mContext.getResources().getInteger(R.integer.ui_textsize_min)) {
                    if (nextInt != this.mContext.getResources().getInteger(R.integer.ui_textSize_default)) {
                        nextInt = this.mContext.getResources().getInteger(R.integer.ui_textsize_min);
                    }
                }
                editText.setTextSize((float) nextInt);
            } else if (this.mContext.getString(R.string.ui_layout_height).equalsIgnoreCase(nextName)) {
                int nextInt2 = jsonReader.nextInt();
                if (nextInt2 > this.mContext.getResources().getInteger(R.integer.ui_default_height)) {
                    editText.setHeight(nextInt2);
                }
            } else if (this.mContext.getString(R.string.ui_layout_width).equalsIgnoreCase(nextName)) {
                int nextInt3 = jsonReader.nextInt();
                if (nextInt3 > this.mContext.getResources().getInteger(R.integer.ui_default_width)) {
                    editText.setWidth(nextInt3);
                }
            } else if (this.mContext.getString(R.string.ui_edittext_maxlength).equalsIgnoreCase(nextName)) {
                int nextInt4 = jsonReader.nextInt();
                if (nextInt4 > 0) {
                    editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(nextInt4)});
                }
            } else if (this.mContext.getString(R.string.ui_edittext_inputnumber).equalsIgnoreCase(nextName)) {
                try {
                    z2 = jsonReader.nextBoolean();
                } catch (Exception unused) {
                    z2 = false;
                }
                if (z2) {
                    editText.setInputType(2);
                }
            } else if ("密码".equalsIgnoreCase(nextName)) {
                try {
                    z = jsonReader.nextBoolean();
                } catch (Exception unused2) {
                    z = false;
                }
                editText.setTransformationMethod(z ? PasswordTransformationMethod.getInstance() : HideReturnsTransformationMethod.getInstance());
            } else if (this.mContext.getString(R.string.ui_edittext_defaultcontent).equalsIgnoreCase(nextName)) {
                editText.setText(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        editText.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
            }
        });
        editText.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            public final void onDestroyActionMode(ActionMode actionMode) {
            }

            public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
        return editText;
    }

    public b parseHorizontalLinearLayout(JsonReader jsonReader) throws IOException, IllegalStateException {
        View parseButton;
        b bVar = new b(this.mContext);
        bVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        bVar.setGravity(16);
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (this.mContext.getString(R.string.ui_linearlayout).equalsIgnoreCase(nextName)) {
                bVar.addView(parseHorizontalLinearLayout(jsonReader));
            } else {
                if (this.mContext.getString(R.string.ui_textview).equalsIgnoreCase(nextName)) {
                    parseButton = parseTextView(jsonReader);
                } else if (this.mContext.getString(R.string.ui_edittext).equalsIgnoreCase(nextName)) {
                    parseButton = parseEditText(jsonReader);
                } else if (this.mContext.getString(R.string.ui_checkbox).equals(nextName)) {
                    parseButton = parseCheckBox(jsonReader);
                } else if (this.mContext.getString(R.string.ui_spinner).equalsIgnoreCase(nextName)) {
                    parseButton = parseSpinner(jsonReader);
                } else if (this.mContext.getString(R.string.ui_button).equalsIgnoreCase(nextName)) {
                    parseButton = parseButton(jsonReader);
                } else {
                    jsonReader.skipValue();
                }
                bVar.addView(parseButton, this.mDefaultFlowLayoutChildLayoutParams);
            }
        }
        jsonReader.endObject();
        return bVar;
    }

    public Spinner parseSpinner(JsonReader jsonReader) throws IOException, IllegalStateException {
        Spinner spinner = new Spinner(this.mContext);
        spinner.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        spinner.setBackgroundResource(R.drawable.spinner_bg);
        spinner.setPadding(0, 0, 5, 0);
        spinner.setGravity(3);
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            ArrayList arrayList = new ArrayList();
            if (this.mContext.getString(R.string.ui_name).equalsIgnoreCase(nextName)) {
                spinner.setTag(jsonReader.nextString());
            } else if (this.mContext.getString(R.string.ui_onSelect).equalsIgnoreCase(nextName)) {
                spinner.setTag(R.id.uip_function_key, jsonReader.nextString());
            } else if (this.mContext.getString(R.string.ui_spinner_items).equalsIgnoreCase(nextName)) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(jsonReader.nextString());
                }
                jsonReader.endArray();
                e eVar = new e(this.mContext, arrayList);
                eVar.setDropDownViewResource(17367049);
                spinner.setAdapter(eVar);
            } else if (this.mContext.getString(R.string.ui_spinner_defaultitem).equalsIgnoreCase(nextName)) {
                int nextInt = jsonReader.nextInt();
                if (nextInt >= spinner.getAdapter().getCount()) {
                    nextInt = 0;
                }
                spinner.setSelection(nextInt);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return spinner;
    }

    public TextView parseTextView(JsonReader jsonReader) throws IOException, IllegalStateException {
        TextView textView = new TextView(this.mContext);
        textView.setGravity(17);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setTextSize((float) this.mContext.getResources().getInteger(R.integer.ui_textSize_normal));
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (this.mContext.getString(R.string.ui_name).equalsIgnoreCase(nextName)) {
                textView.setTag(jsonReader.nextString());
            } else if (this.mContext.getString(R.string.ui_textview_textcontent).equalsIgnoreCase(nextName)) {
                textView.setText(jsonReader.nextString());
            } else if (this.mContext.getString(R.string.ui_textsize).equalsIgnoreCase(nextName)) {
                int nextInt = jsonReader.nextInt();
                if (nextInt <= this.mContext.getResources().getInteger(R.integer.ui_textsize_min)) {
                    if (nextInt != this.mContext.getResources().getInteger(R.integer.ui_textSize_default)) {
                        nextInt = this.mContext.getResources().getInteger(R.integer.ui_textsize_min);
                    }
                }
                textView.setTextSize((float) nextInt);
            } else if (this.mContext.getString(R.string.ui_layout_height).equalsIgnoreCase(nextName)) {
                int nextInt2 = jsonReader.nextInt();
                if (nextInt2 > this.mContext.getResources().getInteger(R.integer.ui_default_height)) {
                    textView.setHeight(nextInt2);
                }
            } else if (this.mContext.getString(R.string.ui_layout_width).equalsIgnoreCase(nextName)) {
                int nextInt3 = jsonReader.nextInt();
                if (nextInt3 > this.mContext.getResources().getInteger(R.integer.ui_default_width)) {
                    textView.setWidth(nextInt3);
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return textView;
    }
}
