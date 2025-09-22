package com.cyjh.mobileanjian.ipc.uip;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.JsonReader;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TableLayout;
import com.cyjh.mobileanjian.ipc.share.proto.UiMessage;
import com.cyjh.mobileanjian.ipc.ui.SlidingTabLayout;
import com.cyjh.mqsdk.R;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class UipHelper implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    public static final int UIP_MESSAGE = 0;

    /* renamed from: a  reason: collision with root package name */
    private static final String f2674a = new File(Environment.getExternalStorageDirectory(), ".uip.config.json").getAbsolutePath();

    /* renamed from: b  reason: collision with root package name */
    private Context f2675b;

    /* renamed from: c  reason: collision with root package name */
    private SlidingTabLayout f2676c;
    private a d;
    private c e;
    private List<ScrollView> f;
    private boolean g;
    private Handler h = new Handler() {
        public final void handleMessage(Message message) {
            if (message.what == 0) {
                try {
                    UiMessage.CommandToUip parseFrom = UiMessage.CommandToUip.parseFrom((ByteString) message.obj);
                    UiMessage.CommandToUip.Command_Type command = parseFrom.getCommand();
                    String controlId = parseFrom.getControlId();
                    new StringBuilder("GET UIP Command -->").append(parseFrom);
                    if (command == UiMessage.CommandToUip.Command_Type.GET_UIP_ATTRIBUTE) {
                        UipHelper.a(UipHelper.this, controlId);
                    } else if (command == UiMessage.CommandToUip.Command_Type.SET_UIP_ATTRIBUTE) {
                        UipHelper.a(UipHelper.this, controlId, parseFrom.getUipAttributeData());
                    }
                } catch (InvalidProtocolBufferException e) {
                    e.printStackTrace();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    };
    private JSONObject i;

    public UipHelper(Context context) {
        this.f2675b = context;
    }

    private LinearLayout a(String str, IUipJsonParser iUipJsonParser) {
        View parseSpinner;
        if (iUipJsonParser == null) {
            iUipJsonParser = new DefaultUipJsonParser(this.f2675b);
        }
        LinearLayout linearLayout = new LinearLayout(this.f2675b);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        ViewPager viewPager = new ViewPager(this.f2675b);
        TableLayout.LayoutParams layoutParams2 = new TableLayout.LayoutParams(-1, -1);
        layoutParams2.weight = 1.0f;
        viewPager.setLayoutParams(layoutParams2);
        linearLayout.addView(viewPager);
        this.d = new a(this.f2675b);
        this.d.setLayoutParams(new LinearLayout.LayoutParams(-2, this.d.a(20.0f)));
        this.d.setPadding(0, this.d.a(10.0f), 0, 0);
        linearLayout.addView(this.d);
        ArrayList arrayList = new ArrayList(32);
        ArrayList arrayList2 = new ArrayList(32);
        JsonReader jsonReader = new JsonReader(new StringReader(str));
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext() && jsonReader.nextName().startsWith(this.f2675b.getString(R.string.ui_activity))) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    LinearLayout linearLayout2 = new LinearLayout(this.f2675b);
                    linearLayout2.setOrientation(1);
                    linearLayout2.setLayoutParams(layoutParams);
                    ScrollView scrollView = new ScrollView(this.f2675b);
                    scrollView.setTag(nextName);
                    scrollView.setLayoutParams(layoutParams);
                    scrollView.addView(linearLayout2);
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        if (nextName2.equalsIgnoreCase(this.f2675b.getString(R.string.ui_linearlayout))) {
                            parseSpinner = iUipJsonParser.parseHorizontalLinearLayout(jsonReader);
                        } else if (nextName2.equalsIgnoreCase(this.f2675b.getString(R.string.ui_textview))) {
                            parseSpinner = iUipJsonParser.parseTextView(jsonReader);
                        } else if (nextName2.equalsIgnoreCase(this.f2675b.getString(R.string.ui_button))) {
                            parseSpinner = iUipJsonParser.parseButton(jsonReader);
                        } else if (nextName2.equalsIgnoreCase(this.f2675b.getString(R.string.ui_edittext))) {
                            parseSpinner = iUipJsonParser.parseEditText(jsonReader);
                        } else if (nextName2.equalsIgnoreCase(this.f2675b.getString(R.string.ui_checkbox))) {
                            parseSpinner = iUipJsonParser.parseCheckBox(jsonReader);
                        } else if (nextName2.equalsIgnoreCase(this.f2675b.getString(R.string.ui_spinner))) {
                            parseSpinner = iUipJsonParser.parseSpinner(jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                        linearLayout2.addView(parseSpinner);
                    }
                    jsonReader.endObject();
                    if (arrayList.size() < 32) {
                        arrayList2.add(nextName);
                        arrayList.add(scrollView);
                    }
                }
                jsonReader.endObject();
            }
            jsonReader.endObject();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (IllegalStateException e3) {
            e3.printStackTrace();
        }
        viewPager.setAdapter(new f(arrayList, arrayList2));
        this.d.setViewPager(viewPager);
        bindEvent(arrayList);
        saveToConfigFile(f2674a);
        return linearLayout;
    }

    private void a(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof b) || (childAt instanceof LinearLayout)) {
                a((ViewGroup) childAt);
            } else if (!TextUtils.isEmpty((CharSequence) childAt.getTag(R.id.uip_function_key))) {
                if (childAt instanceof Spinner) {
                    ((Spinner) childAt).setOnItemSelectedListener(this);
                } else if (childAt instanceof CheckBox) {
                    ((CheckBox) childAt).setOnClickListener(this);
                } else if (childAt instanceof Button) {
                    ((Button) childAt).setOnClickListener(this);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0084, code lost:
        r0.put(r5, r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.cyjh.mobileanjian.ipc.uip.UipHelper r5, java.lang.String r6) throws org.json.JSONException {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.util.List<android.widget.ScrollView> r1 = r5.f
            java.util.Iterator r1 = r1.iterator()
        L_0x000b:
            boolean r2 = r1.hasNext()
            r3 = 1
            if (r2 == 0) goto L_0x00e0
            java.lang.Object r2 = r1.next()
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            android.view.View r2 = r2.findViewWithTag(r6)
            boolean r4 = r2 instanceof android.widget.Spinner
            if (r4 == 0) goto L_0x005f
            android.widget.Spinner r2 = (android.widget.Spinner) r2
            android.content.Context r6 = r5.f2675b
            int r1 = com.cyjh.mqsdk.R.string.ui_spinner_defaultitem
            java.lang.String r6 = r6.getString(r1)
            int r1 = r2.getSelectedItemPosition()
            r0.put(r6, r1)
            android.widget.SpinnerAdapter r6 = r2.getAdapter()
            com.cyjh.mobileanjian.ipc.uip.e r6 = (com.cyjh.mobileanjian.ipc.uip.e) r6
            java.util.List<java.lang.String> r6 = r6.f2700a
            org.json.JSONArray r1 = new org.json.JSONArray
            r1.<init>()
            java.util.Iterator r6 = r6.iterator()
        L_0x0042:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L_0x0052
            java.lang.Object r2 = r6.next()
            java.lang.String r2 = (java.lang.String) r2
            r1.put(r2)
            goto L_0x0042
        L_0x0052:
            android.content.Context r5 = r5.f2675b
            int r6 = com.cyjh.mqsdk.R.string.ui_spinner_items
            java.lang.String r5 = r5.getString(r6)
            r0.put(r5, r1)
            goto L_0x00e0
        L_0x005f:
            boolean r4 = r2 instanceof android.widget.CheckBox
            if (r4 == 0) goto L_0x0088
            android.widget.CheckBox r2 = (android.widget.CheckBox) r2
            android.content.Context r6 = r5.f2675b
            int r1 = com.cyjh.mqsdk.R.string.ui_checkbox_hintcontent
            java.lang.String r6 = r6.getString(r1)
            java.lang.CharSequence r1 = r2.getText()
            java.lang.String r1 = r1.toString()
            r0.put(r6, r1)
            android.content.Context r5 = r5.f2675b
            int r6 = com.cyjh.mqsdk.R.string.ui_checkbox_checked
            java.lang.String r5 = r5.getString(r6)
            boolean r6 = r2.isChecked()
        L_0x0084:
            r0.put(r5, r6)
            goto L_0x00e0
        L_0x0088:
            boolean r4 = r2 instanceof android.widget.Button
            if (r4 == 0) goto L_0x00a2
            android.widget.Button r2 = (android.widget.Button) r2
            android.content.Context r5 = r5.f2675b
            int r6 = com.cyjh.mqsdk.R.string.ui_textview_textcontent
            java.lang.String r5 = r5.getString(r6)
            java.lang.CharSequence r6 = r2.getText()
        L_0x009a:
            java.lang.String r6 = r6.toString()
            r0.put(r5, r6)
            goto L_0x00e0
        L_0x00a2:
            boolean r4 = r2 instanceof android.widget.EditText
            if (r4 == 0) goto L_0x00cd
            android.widget.EditText r2 = (android.widget.EditText) r2
            android.content.Context r5 = r5.f2675b
            int r6 = com.cyjh.mqsdk.R.string.ui_edittext_defaultcontent
            java.lang.String r5 = r5.getString(r6)
            android.text.Editable r6 = r2.getText()
            java.lang.String r6 = r6.toString()
            r0.put(r5, r6)
            android.text.method.TransformationMethod r5 = r2.getTransformationMethod()
            boolean r5 = r5 instanceof android.text.method.PasswordTransformationMethod
            if (r5 == 0) goto L_0x00c9
            java.lang.String r5 = "密码"
            r0.put(r5, r3)
            goto L_0x00e0
        L_0x00c9:
            java.lang.String r5 = "密码"
            r6 = 0
            goto L_0x0084
        L_0x00cd:
            boolean r4 = r2 instanceof android.widget.TextView
            if (r4 == 0) goto L_0x000b
            android.widget.TextView r2 = (android.widget.TextView) r2
            android.content.Context r5 = r5.f2675b
            int r6 = com.cyjh.mqsdk.R.string.ui_textview_textcontent
            java.lang.String r5 = r5.getString(r6)
            java.lang.CharSequence r6 = r2.getText()
            goto L_0x009a
        L_0x00e0:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "rtnJson:"
            r5.<init>(r6)
            r5.append(r0)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UipToCommand$Builder r5 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UipToCommand.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UipToCommand$Command_Type r6 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UipToCommand.Command_Type.RSP_MSG
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UipToCommand$Builder r5 = r5.setCommand(r6)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UipToCommand$Builder r5 = r5.setIsSuccess(r3)
            java.lang.String r6 = r0.toString()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UipToCommand$Builder r5 = r5.setUipAttributeData(r6)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UipToCommand r5 = r5.build()
            com.google.protobuf.ByteString r5 = r5.toByteString()
            com.cyjh.mobileanjian.ipc.uip.UipEventStub.UiRequestReturn(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.uip.UipHelper.a(com.cyjh.mobileanjian.ipc.uip.UipHelper, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010f, code lost:
        r1 = (android.widget.EditText) r1;
        r0.beginObject();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0118, code lost:
        if (r0.hasNext() == false) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x011a, code lost:
        r6 = r0.nextName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x012a, code lost:
        if (r6.equalsIgnoreCase(r5.f2675b.getString(com.cyjh.mqsdk.R.string.ui_edittext_defaultcontent)) == false) goto L_0x0134;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x012c, code lost:
        r1.setText(r0.nextString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x013a, code lost:
        if (r6.equalsIgnoreCase("密码") == false) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x013c, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0141, code lost:
        r6 = r0.nextBoolean();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0151, code lost:
        r0.skipValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.cyjh.mobileanjian.ipc.uip.UipHelper r5, java.lang.String r6, java.lang.String r7) {
        /*
            android.util.JsonReader r0 = new android.util.JsonReader
            java.io.StringReader r1 = new java.io.StringReader
            r1.<init>(r7)
            r0.<init>(r1)
            java.util.List<android.widget.ScrollView> r7 = r5.f     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
        L_0x0010:
            boolean r1 = r7.hasNext()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r1 == 0) goto L_0x018b
            java.lang.Object r1 = r7.next()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            android.view.View r1 = r1.findViewWithTag(r6)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            boolean r2 = r1 instanceof android.widget.Spinner     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r2 == 0) goto L_0x0096
            android.widget.Spinner r1 = (android.widget.Spinner) r1     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r6 = -1
            r7 = 0
            r0.beginObject()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
        L_0x002b:
            boolean r2 = r0.hasNext()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r2 == 0) goto L_0x0074
            java.lang.String r2 = r0.nextName()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            android.content.Context r3 = r5.f2675b     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            int r4 = com.cyjh.mqsdk.R.string.ui_spinner_defaultitem     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            java.lang.String r3 = r3.getString(r4)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            boolean r3 = r2.equalsIgnoreCase(r3)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r3 == 0) goto L_0x0048
            int r6 = r0.nextInt()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x002b
        L_0x0048:
            android.content.Context r3 = r5.f2675b     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            int r4 = com.cyjh.mqsdk.R.string.ui_spinner_items     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            java.lang.String r3 = r3.getString(r4)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r2 == 0) goto L_0x0070
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r7.<init>()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r0.beginArray()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
        L_0x005e:
            boolean r2 = r0.hasNext()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r2 == 0) goto L_0x006c
            java.lang.String r2 = r0.nextString()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r7.add(r2)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x005e
        L_0x006c:
            r0.endArray()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x002b
        L_0x0070:
            r0.skipValue()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x002b
        L_0x0074:
            r0.endObject()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r7 == 0) goto L_0x0089
            com.cyjh.mobileanjian.ipc.uip.e r0 = new com.cyjh.mobileanjian.ipc.uip.e     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            android.content.Context r5 = r5.f2675b     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r0.<init>(r5, r7)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r5 = 17367049(0x1090009, float:2.516295E-38)
            r0.setDropDownViewResource(r5)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r1.setAdapter(r0)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
        L_0x0089:
            if (r6 < 0) goto L_0x018b
            int r5 = r1.getCount()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r6 >= r5) goto L_0x018b
            r1.setSelection(r6)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x018b
        L_0x0096:
            boolean r2 = r1 instanceof android.widget.CheckBox     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r2 == 0) goto L_0x00de
            android.widget.CheckBox r1 = (android.widget.CheckBox) r1     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r0.beginObject()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
        L_0x009f:
            boolean r6 = r0.hasNext()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r6 == 0) goto L_0x00d9
            java.lang.String r6 = r0.nextName()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            android.content.Context r7 = r5.f2675b     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            int r2 = com.cyjh.mqsdk.R.string.ui_checkbox_hintcontent     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            java.lang.String r7 = r7.getString(r2)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            boolean r7 = r6.equalsIgnoreCase(r7)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r7 == 0) goto L_0x00bf
            java.lang.String r6 = r0.nextString()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r1.setText(r6)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x009f
        L_0x00bf:
            android.content.Context r7 = r5.f2675b     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            int r2 = com.cyjh.mqsdk.R.string.ui_checkbox_checked     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            java.lang.String r7 = r7.getString(r2)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            boolean r6 = r6.equalsIgnoreCase(r7)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r6 == 0) goto L_0x00d5
            boolean r6 = r0.nextBoolean()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r1.setChecked(r6)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x009f
        L_0x00d5:
            r0.skipValue()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x009f
        L_0x00d9:
            r0.endObject()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x018b
        L_0x00de:
            boolean r2 = r1 instanceof android.widget.Button     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r2 == 0) goto L_0x010b
            android.widget.Button r1 = (android.widget.Button) r1     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r0.beginObject()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
        L_0x00e7:
            boolean r6 = r0.hasNext()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r6 == 0) goto L_0x00d9
            java.lang.String r6 = r0.nextName()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            android.content.Context r7 = r5.f2675b     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            int r2 = com.cyjh.mqsdk.R.string.ui_textview_textcontent     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            java.lang.String r7 = r7.getString(r2)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            boolean r6 = r6.equalsIgnoreCase(r7)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r6 == 0) goto L_0x0107
            java.lang.String r6 = r0.nextString()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r1.setText(r6)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x00e7
        L_0x0107:
            r0.skipValue()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x00e7
        L_0x010b:
            boolean r2 = r1 instanceof android.widget.EditText     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r2 == 0) goto L_0x0155
            android.widget.EditText r1 = (android.widget.EditText) r1     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r0.beginObject()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
        L_0x0114:
            boolean r6 = r0.hasNext()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r6 == 0) goto L_0x00d9
            java.lang.String r6 = r0.nextName()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            android.content.Context r7 = r5.f2675b     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            int r2 = com.cyjh.mqsdk.R.string.ui_edittext_defaultcontent     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            java.lang.String r7 = r7.getString(r2)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            boolean r7 = r6.equalsIgnoreCase(r7)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r7 == 0) goto L_0x0134
            java.lang.String r6 = r0.nextString()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r1.setText(r6)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x0114
        L_0x0134:
            java.lang.String r7 = "密码"
            boolean r6 = r6.equalsIgnoreCase(r7)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r6 == 0) goto L_0x0151
            r6 = 0
            boolean r7 = r0.nextBoolean()     // Catch:{ Exception -> 0x0142 }
            r6 = r7
        L_0x0142:
            if (r6 == 0) goto L_0x014c
            android.text.method.PasswordTransformationMethod r6 = android.text.method.PasswordTransformationMethod.getInstance()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
        L_0x0148:
            r1.setTransformationMethod(r6)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x0114
        L_0x014c:
            android.text.method.HideReturnsTransformationMethod r6 = android.text.method.HideReturnsTransformationMethod.getInstance()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x0148
        L_0x0151:
            r0.skipValue()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x0114
        L_0x0155:
            boolean r2 = r1 instanceof android.widget.TextView     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r2 == 0) goto L_0x0010
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r0.beginObject()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
        L_0x015e:
            boolean r6 = r0.hasNext()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r6 == 0) goto L_0x00d9
            java.lang.String r6 = r0.nextName()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            android.content.Context r7 = r5.f2675b     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            int r2 = com.cyjh.mqsdk.R.string.ui_textview_textcontent     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            java.lang.String r7 = r7.getString(r2)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            boolean r6 = r6.equalsIgnoreCase(r7)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r6 == 0) goto L_0x017e
            java.lang.String r6 = r0.nextString()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r1.setText(r6)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x015e
        L_0x017e:
            r0.skipValue()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x015e
        L_0x0182:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x018b
        L_0x0187:
            r5 = move-exception
            r5.printStackTrace()
        L_0x018b:
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UipToCommand$Builder r5 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UipToCommand.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UipToCommand$Command_Type r6 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UipToCommand.Command_Type.RSP_MSG
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UipToCommand$Builder r5 = r5.setCommand(r6)
            r6 = 1
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UipToCommand$Builder r5 = r5.setIsSuccess(r6)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UipToCommand r5 = r5.build()
            com.google.protobuf.ByteString r5 = r5.toByteString()
            com.cyjh.mobileanjian.ipc.uip.UipEventStub.UiRequestReturn(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.uip.UipHelper.a(com.cyjh.mobileanjian.ipc.uip.UipHelper, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0084, code lost:
        r0.put(r6, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x009a, code lost:
        r1 = r1.toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r6) throws org.json.JSONException {
        /*
            r5 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.util.List<android.widget.ScrollView> r1 = r5.f
            java.util.Iterator r1 = r1.iterator()
        L_0x000b:
            boolean r2 = r1.hasNext()
            r3 = 1
            if (r2 == 0) goto L_0x00dd
            java.lang.Object r2 = r1.next()
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            android.view.View r2 = r2.findViewWithTag(r6)
            boolean r4 = r2 instanceof android.widget.Spinner
            if (r4 == 0) goto L_0x005f
            android.widget.Spinner r2 = (android.widget.Spinner) r2
            android.content.Context r6 = r5.f2675b
            int r1 = com.cyjh.mqsdk.R.string.ui_spinner_defaultitem
            java.lang.String r6 = r6.getString(r1)
            int r1 = r2.getSelectedItemPosition()
            r0.put(r6, r1)
            android.widget.SpinnerAdapter r6 = r2.getAdapter()
            com.cyjh.mobileanjian.ipc.uip.e r6 = (com.cyjh.mobileanjian.ipc.uip.e) r6
            java.util.List<java.lang.String> r6 = r6.f2700a
            org.json.JSONArray r1 = new org.json.JSONArray
            r1.<init>()
            java.util.Iterator r6 = r6.iterator()
        L_0x0042:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L_0x0052
            java.lang.Object r2 = r6.next()
            java.lang.String r2 = (java.lang.String) r2
            r1.put(r2)
            goto L_0x0042
        L_0x0052:
            android.content.Context r6 = r5.f2675b
            int r2 = com.cyjh.mqsdk.R.string.ui_spinner_items
            java.lang.String r6 = r6.getString(r2)
        L_0x005a:
            r0.put(r6, r1)
            goto L_0x00dd
        L_0x005f:
            boolean r4 = r2 instanceof android.widget.CheckBox
            if (r4 == 0) goto L_0x0088
            android.widget.CheckBox r2 = (android.widget.CheckBox) r2
            android.content.Context r6 = r5.f2675b
            int r1 = com.cyjh.mqsdk.R.string.ui_checkbox_hintcontent
            java.lang.String r6 = r6.getString(r1)
            java.lang.CharSequence r1 = r2.getText()
            java.lang.String r1 = r1.toString()
            r0.put(r6, r1)
            android.content.Context r6 = r5.f2675b
            int r1 = com.cyjh.mqsdk.R.string.ui_checkbox_checked
            java.lang.String r6 = r6.getString(r1)
            boolean r1 = r2.isChecked()
        L_0x0084:
            r0.put(r6, r1)
            goto L_0x00dd
        L_0x0088:
            boolean r4 = r2 instanceof android.widget.Button
            if (r4 == 0) goto L_0x009f
            android.widget.Button r2 = (android.widget.Button) r2
            android.content.Context r6 = r5.f2675b
            int r1 = com.cyjh.mqsdk.R.string.ui_textview_textcontent
            java.lang.String r6 = r6.getString(r1)
            java.lang.CharSequence r1 = r2.getText()
        L_0x009a:
            java.lang.String r1 = r1.toString()
            goto L_0x005a
        L_0x009f:
            boolean r4 = r2 instanceof android.widget.EditText
            if (r4 == 0) goto L_0x00ca
            android.widget.EditText r2 = (android.widget.EditText) r2
            android.content.Context r6 = r5.f2675b
            int r1 = com.cyjh.mqsdk.R.string.ui_edittext_defaultcontent
            java.lang.String r6 = r6.getString(r1)
            android.text.Editable r1 = r2.getText()
            java.lang.String r1 = r1.toString()
            r0.put(r6, r1)
            android.text.method.TransformationMethod r6 = r2.getTransformationMethod()
            boolean r6 = r6 instanceof android.text.method.PasswordTransformationMethod
            if (r6 == 0) goto L_0x00c6
            java.lang.String r6 = "密码"
            r0.put(r6, r3)
            goto L_0x00dd
        L_0x00c6:
            java.lang.String r6 = "密码"
            r1 = 0
            goto L_0x0084
        L_0x00ca:
            boolean r4 = r2 instanceof android.widget.TextView
            if (r4 == 0) goto L_0x000b
            android.widget.TextView r2 = (android.widget.TextView) r2
            android.content.Context r6 = r5.f2675b
            int r1 = com.cyjh.mqsdk.R.string.ui_textview_textcontent
            java.lang.String r6 = r6.getString(r1)
            java.lang.CharSequence r1 = r2.getText()
            goto L_0x009a
        L_0x00dd:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r1 = "rtnJson:"
            r6.<init>(r1)
            r6.append(r0)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UipToCommand$Builder r6 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UipToCommand.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UipToCommand$Command_Type r1 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UipToCommand.Command_Type.RSP_MSG
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UipToCommand$Builder r6 = r6.setCommand(r1)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UipToCommand$Builder r6 = r6.setIsSuccess(r3)
            java.lang.String r0 = r0.toString()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UipToCommand$Builder r6 = r6.setUipAttributeData(r0)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UipToCommand r6 = r6.build()
            com.google.protobuf.ByteString r6 = r6.toByteString()
            com.cyjh.mobileanjian.ipc.uip.UipEventStub.UiRequestReturn(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.uip.UipHelper.a(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010f, code lost:
        r1 = (android.widget.EditText) r1;
        r0.beginObject();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0118, code lost:
        if (r0.hasNext() == false) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x011a, code lost:
        r6 = r0.nextName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x012a, code lost:
        if (r6.equalsIgnoreCase(r5.f2675b.getString(com.cyjh.mqsdk.R.string.ui_edittext_defaultcontent)) == false) goto L_0x0134;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x012c, code lost:
        r1.setText(r0.nextString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x013a, code lost:
        if (r6.equalsIgnoreCase("密码") == false) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x013c, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0141, code lost:
        r6 = r0.nextBoolean();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0151, code lost:
        r0.skipValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            android.util.JsonReader r0 = new android.util.JsonReader
            java.io.StringReader r1 = new java.io.StringReader
            r1.<init>(r7)
            r0.<init>(r1)
            java.util.List<android.widget.ScrollView> r7 = r5.f     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
        L_0x0010:
            boolean r1 = r7.hasNext()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r1 == 0) goto L_0x018b
            java.lang.Object r1 = r7.next()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            android.view.View r1 = r1.findViewWithTag(r6)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            boolean r2 = r1 instanceof android.widget.Spinner     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r2 == 0) goto L_0x0096
            android.widget.Spinner r1 = (android.widget.Spinner) r1     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r6 = -1
            r7 = 0
            r0.beginObject()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
        L_0x002b:
            boolean r2 = r0.hasNext()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r2 == 0) goto L_0x0074
            java.lang.String r2 = r0.nextName()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            android.content.Context r3 = r5.f2675b     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            int r4 = com.cyjh.mqsdk.R.string.ui_spinner_defaultitem     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            java.lang.String r3 = r3.getString(r4)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            boolean r3 = r2.equalsIgnoreCase(r3)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r3 == 0) goto L_0x0048
            int r6 = r0.nextInt()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x002b
        L_0x0048:
            android.content.Context r3 = r5.f2675b     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            int r4 = com.cyjh.mqsdk.R.string.ui_spinner_items     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            java.lang.String r3 = r3.getString(r4)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r2 == 0) goto L_0x0070
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r7.<init>()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r0.beginArray()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
        L_0x005e:
            boolean r2 = r0.hasNext()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r2 == 0) goto L_0x006c
            java.lang.String r2 = r0.nextString()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r7.add(r2)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x005e
        L_0x006c:
            r0.endArray()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x002b
        L_0x0070:
            r0.skipValue()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x002b
        L_0x0074:
            r0.endObject()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r7 == 0) goto L_0x0089
            com.cyjh.mobileanjian.ipc.uip.e r0 = new com.cyjh.mobileanjian.ipc.uip.e     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            android.content.Context r2 = r5.f2675b     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r0.<init>(r2, r7)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r7 = 17367049(0x1090009, float:2.516295E-38)
            r0.setDropDownViewResource(r7)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r1.setAdapter(r0)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
        L_0x0089:
            if (r6 < 0) goto L_0x018b
            int r7 = r1.getCount()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r6 >= r7) goto L_0x018b
            r1.setSelection(r6)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x018b
        L_0x0096:
            boolean r2 = r1 instanceof android.widget.CheckBox     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r2 == 0) goto L_0x00de
            android.widget.CheckBox r1 = (android.widget.CheckBox) r1     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r0.beginObject()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
        L_0x009f:
            boolean r6 = r0.hasNext()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r6 == 0) goto L_0x00d9
            java.lang.String r6 = r0.nextName()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            android.content.Context r7 = r5.f2675b     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            int r2 = com.cyjh.mqsdk.R.string.ui_checkbox_hintcontent     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            java.lang.String r7 = r7.getString(r2)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            boolean r7 = r6.equalsIgnoreCase(r7)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r7 == 0) goto L_0x00bf
            java.lang.String r6 = r0.nextString()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r1.setText(r6)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x009f
        L_0x00bf:
            android.content.Context r7 = r5.f2675b     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            int r2 = com.cyjh.mqsdk.R.string.ui_checkbox_checked     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            java.lang.String r7 = r7.getString(r2)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            boolean r6 = r6.equalsIgnoreCase(r7)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r6 == 0) goto L_0x00d5
            boolean r6 = r0.nextBoolean()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r1.setChecked(r6)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x009f
        L_0x00d5:
            r0.skipValue()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x009f
        L_0x00d9:
            r0.endObject()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x018b
        L_0x00de:
            boolean r2 = r1 instanceof android.widget.Button     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r2 == 0) goto L_0x010b
            android.widget.Button r1 = (android.widget.Button) r1     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r0.beginObject()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
        L_0x00e7:
            boolean r6 = r0.hasNext()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r6 == 0) goto L_0x00d9
            java.lang.String r6 = r0.nextName()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            android.content.Context r7 = r5.f2675b     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            int r2 = com.cyjh.mqsdk.R.string.ui_textview_textcontent     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            java.lang.String r7 = r7.getString(r2)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            boolean r6 = r6.equalsIgnoreCase(r7)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r6 == 0) goto L_0x0107
            java.lang.String r6 = r0.nextString()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r1.setText(r6)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x00e7
        L_0x0107:
            r0.skipValue()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x00e7
        L_0x010b:
            boolean r2 = r1 instanceof android.widget.EditText     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r2 == 0) goto L_0x0155
            android.widget.EditText r1 = (android.widget.EditText) r1     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r0.beginObject()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
        L_0x0114:
            boolean r6 = r0.hasNext()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r6 == 0) goto L_0x00d9
            java.lang.String r6 = r0.nextName()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            android.content.Context r7 = r5.f2675b     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            int r2 = com.cyjh.mqsdk.R.string.ui_edittext_defaultcontent     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            java.lang.String r7 = r7.getString(r2)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            boolean r7 = r6.equalsIgnoreCase(r7)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r7 == 0) goto L_0x0134
            java.lang.String r6 = r0.nextString()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r1.setText(r6)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x0114
        L_0x0134:
            java.lang.String r7 = "密码"
            boolean r6 = r6.equalsIgnoreCase(r7)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r6 == 0) goto L_0x0151
            r6 = 0
            boolean r7 = r0.nextBoolean()     // Catch:{ Exception -> 0x0142 }
            r6 = r7
        L_0x0142:
            if (r6 == 0) goto L_0x014c
            android.text.method.PasswordTransformationMethod r6 = android.text.method.PasswordTransformationMethod.getInstance()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
        L_0x0148:
            r1.setTransformationMethod(r6)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x0114
        L_0x014c:
            android.text.method.HideReturnsTransformationMethod r6 = android.text.method.HideReturnsTransformationMethod.getInstance()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x0148
        L_0x0151:
            r0.skipValue()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x0114
        L_0x0155:
            boolean r2 = r1 instanceof android.widget.TextView     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r2 == 0) goto L_0x0010
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r0.beginObject()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
        L_0x015e:
            boolean r6 = r0.hasNext()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r6 == 0) goto L_0x00d9
            java.lang.String r6 = r0.nextName()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            android.content.Context r7 = r5.f2675b     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            int r2 = com.cyjh.mqsdk.R.string.ui_textview_textcontent     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            java.lang.String r7 = r7.getString(r2)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            boolean r6 = r6.equalsIgnoreCase(r7)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            if (r6 == 0) goto L_0x017e
            java.lang.String r6 = r0.nextString()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            r1.setText(r6)     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x015e
        L_0x017e:
            r0.skipValue()     // Catch:{ IllegalStateException -> 0x0187, IOException -> 0x0182 }
            goto L_0x015e
        L_0x0182:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x018b
        L_0x0187:
            r6 = move-exception
            r6.printStackTrace()
        L_0x018b:
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UipToCommand$Builder r6 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UipToCommand.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UipToCommand$Command_Type r7 = com.cyjh.mobileanjian.ipc.share.proto.UiMessage.UipToCommand.Command_Type.RSP_MSG
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UipToCommand$Builder r6 = r6.setCommand(r7)
            r7 = 1
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UipToCommand$Builder r6 = r6.setIsSuccess(r7)
            com.cyjh.mobileanjian.ipc.share.proto.UiMessage$UipToCommand r6 = r6.build()
            com.google.protobuf.ByteString r6 = r6.toByteString()
            com.cyjh.mobileanjian.ipc.uip.UipEventStub.UiRequestReturn(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.uip.UipHelper.a(java.lang.String, java.lang.String):void");
    }

    private LinearLayout b(String str, IUipJsonParser iUipJsonParser) {
        View parseSpinner;
        if (iUipJsonParser == null) {
            iUipJsonParser = new DefaultUipJsonParser(this.f2675b);
        }
        LinearLayout linearLayout = new LinearLayout(this.f2675b);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        this.f2676c = new SlidingTabLayout(this.f2675b);
        this.f2676c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f2676c.setSelectedIndicatorColors(this.f2675b.getResources().getColor(R.color.ui_show_blue));
        this.f2676c.setDistributeEvenly(true);
        linearLayout.addView(this.f2676c);
        ViewPager viewPager = new ViewPager(this.f2675b);
        TableLayout.LayoutParams layoutParams2 = new TableLayout.LayoutParams(-1, -1);
        layoutParams2.weight = 1.0f;
        viewPager.setLayoutParams(layoutParams2);
        linearLayout.addView(viewPager);
        ArrayList arrayList = new ArrayList(32);
        ArrayList arrayList2 = new ArrayList(32);
        JsonReader jsonReader = new JsonReader(new StringReader(str));
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext() && jsonReader.nextName().startsWith(this.f2675b.getString(R.string.ui_activity))) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    LinearLayout linearLayout2 = new LinearLayout(this.f2675b);
                    linearLayout2.setOrientation(1);
                    linearLayout2.setLayoutParams(layoutParams);
                    ScrollView scrollView = new ScrollView(this.f2675b);
                    scrollView.setTag(nextName);
                    scrollView.setLayoutParams(layoutParams);
                    scrollView.addView(linearLayout2);
                    scrollView.setDescendantFocusability(131072);
                    scrollView.setFocusable(true);
                    scrollView.setFocusableInTouchMode(true);
                    scrollView.setOnTouchListener(new View.OnTouchListener() {
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            view.requestFocusFromTouch();
                            return false;
                        }
                    });
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        if (nextName2.equalsIgnoreCase(this.f2675b.getString(R.string.ui_linearlayout))) {
                            parseSpinner = iUipJsonParser.parseHorizontalLinearLayout(jsonReader);
                        } else if (nextName2.equalsIgnoreCase(this.f2675b.getString(R.string.ui_textview))) {
                            parseSpinner = iUipJsonParser.parseTextView(jsonReader);
                        } else if (nextName2.equalsIgnoreCase(this.f2675b.getString(R.string.ui_button))) {
                            parseSpinner = iUipJsonParser.parseButton(jsonReader);
                        } else if (nextName2.equalsIgnoreCase(this.f2675b.getString(R.string.ui_edittext))) {
                            parseSpinner = iUipJsonParser.parseEditText(jsonReader);
                        } else if (nextName2.equalsIgnoreCase(this.f2675b.getString(R.string.ui_checkbox))) {
                            parseSpinner = iUipJsonParser.parseCheckBox(jsonReader);
                        } else if (nextName2.equalsIgnoreCase(this.f2675b.getString(R.string.ui_spinner))) {
                            parseSpinner = iUipJsonParser.parseSpinner(jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                        linearLayout2.addView(parseSpinner);
                    }
                    jsonReader.endObject();
                    if (arrayList.size() < 32) {
                        arrayList2.add(nextName);
                        arrayList.add(scrollView);
                    }
                }
                jsonReader.endObject();
            }
            jsonReader.endObject();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (IllegalStateException e3) {
            e3.printStackTrace();
        }
        viewPager.setAdapter(new f(arrayList, arrayList2));
        this.f2676c.setViewPager(viewPager);
        bindEvent(arrayList);
        saveToConfigFile(f2674a);
        return linearLayout;
    }

    private void b(ViewGroup viewGroup) throws JSONException {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            String str = (String) childAt.getTag();
            if ((childAt instanceof LinearLayout) || (childAt instanceof b)) {
                b((ViewGroup) childAt);
            } else if (childAt instanceof CheckBox) {
                this.i.put(str, ((CheckBox) childAt).isChecked());
            } else if (childAt instanceof Spinner) {
                this.i.put(str, ((Spinner) childAt).getSelectedItemPosition());
            } else if (childAt instanceof EditText) {
                this.i.put(str, ((EditText) childAt).getText().toString());
            }
        }
    }

    private LinearLayout c(String str, IUipJsonParser iUipJsonParser) {
        View parseSpinner;
        c cVar;
        if (iUipJsonParser == null) {
            iUipJsonParser = new DefaultUipJsonParser(this.f2675b);
        }
        this.e = new c(this.f2675b);
        JsonReader jsonReader = new JsonReader(new StringReader(str));
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext() && jsonReader.nextName().startsWith(this.f2675b.getString(R.string.ui_activity))) {
                jsonReader.beginObject();
                for (int i2 = 0; i2 < 32 && jsonReader.hasNext(); i2++) {
                    String nextName = jsonReader.nextName();
                    c cVar2 = this.e;
                    RadioButton radioButton = new RadioButton(cVar2.getContext());
                    radioButton.setId(c.f2695a[cVar2.g]);
                    radioButton.setPadding(0, 0, 0, cVar2.d);
                    radioButton.setButtonDrawable(new BitmapDrawable((Bitmap) null));
                    radioButton.setTextColor(cVar2.getResources().getColorStateList(R.color.selector_tab));
                    radioButton.setText(nextName);
                    radioButton.setLines(1);
                    radioButton.setEllipsize(TextUtils.TruncateAt.END);
                    cVar2.f2696b.addView(radioButton);
                    cVar2.f = new ScrollView(cVar2.getContext());
                    cVar2.f.setDescendantFocusability(131072);
                    cVar2.f.setFocusable(true);
                    cVar2.f.setFocusableInTouchMode(true);
                    cVar2.f.setOnTouchListener(new View.OnTouchListener() {
                        public final boolean onTouch(
/*
Method generation error in method: com.cyjh.mobileanjian.ipc.uip.c.1.onTouch(android.view.View, android.view.MotionEvent):boolean, dex: classes.dex
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.cyjh.mobileanjian.ipc.uip.c.1.onTouch(android.view.View, android.view.MotionEvent):boolean, class status: UNLOADED
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
                        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:250)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
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
                    cVar2.f.setTag(nextName);
                    cVar2.f.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                    LinearLayout linearLayout = new LinearLayout(cVar2.getContext());
                    linearLayout.setOrientation(1);
                    linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                    cVar2.e = linearLayout;
                    cVar2.f.addView(cVar2.e);
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        if (nextName2.equalsIgnoreCase(this.f2675b.getString(R.string.ui_linearlayout))) {
                            parseSpinner = iUipJsonParser.parseHorizontalLinearLayout(jsonReader);
                            cVar = this.e;
                        } else if (nextName2.equalsIgnoreCase(this.f2675b.getString(R.string.ui_textview))) {
                            parseSpinner = iUipJsonParser.parseTextView(jsonReader);
                            cVar = this.e;
                        } else if (nextName2.equalsIgnoreCase(this.f2675b.getString(R.string.ui_button))) {
                            parseSpinner = iUipJsonParser.parseButton(jsonReader);
                            cVar = this.e;
                        } else if (nextName2.equalsIgnoreCase(this.f2675b.getString(R.string.ui_edittext))) {
                            parseSpinner = iUipJsonParser.parseEditText(jsonReader);
                            cVar = this.e;
                        } else if (nextName2.equalsIgnoreCase(this.f2675b.getString(R.string.ui_checkbox))) {
                            parseSpinner = iUipJsonParser.parseCheckBox(jsonReader);
                            cVar = this.e;
                        } else if (nextName2.equalsIgnoreCase(this.f2675b.getString(R.string.ui_spinner))) {
                            parseSpinner = iUipJsonParser.parseSpinner(jsonReader);
                            cVar = this.e;
                        } else {
                            jsonReader.skipValue();
                        }
                        cVar.a(parseSpinner);
                    }
                    jsonReader.endObject();
                    c cVar3 = this.e;
                    cVar3.f2697c.add(cVar3.f);
                    cVar3.g++;
                }
                jsonReader.endObject();
            }
            jsonReader.endObject();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (IllegalStateException e3) {
            e3.printStackTrace();
        }
        this.e.setSelectTab(0);
        bindEvent(this.e.getScrollViewList());
        saveToConfigFile(f2674a);
        return this.e;
    }

    public void bindEvent(List<ScrollView> list) {
        UipEventStub.registerHandler(this.h);
        this.f = list;
        for (ScrollView a2 : list) {
            a((ViewGroup) a2);
        }
    }

    public void configViewFromFile(String str) {
        try {
            configViewFromJson(FileUtils.readFileToString(new File(str)));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void configViewFromJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.g = true;
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    for (ScrollView findViewWithTag : this.f) {
                        View findViewWithTag2 = findViewWithTag.findViewWithTag(next);
                        if (findViewWithTag2 != null) {
                            if (findViewWithTag2 instanceof CheckBox) {
                                ((CheckBox) findViewWithTag2).setChecked(jSONObject.getBoolean(next));
                            } else if (findViewWithTag2 instanceof Spinner) {
                                Spinner spinner = (Spinner) findViewWithTag2;
                                spinner.setSelection(jSONObject.getInt(next) < spinner.getAdapter().getCount() ? jSONObject.getInt(next) : 0);
                            } else if (findViewWithTag2 instanceof EditText) {
                                ((EditText) findViewWithTag2).setText(jSONObject.getString(next));
                            }
                        }
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.g = false;
        }
    }

    public void onClick(View view) {
        if (!this.g) {
            UipEventStub.hasEvent(UiMessage.UipToCommand.newBuilder().setCommand(UiMessage.UipToCommand.Command_Type.EVENT).setIsSuccess(true).setEvent(UiMessage.ControlEvent.newBuilder().setControlId((String) view.getTag()).setType(UiMessage.ControlEvent.Event_Type.ON_CLICK).setEventFunctionName((String) view.getTag(R.id.uip_function_key)).build()).build().toByteString());
            new StringBuilder("onClick Function Name: ").append((String) view.getTag(R.id.uip_function_key));
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
        new StringBuilder("isCodeEvent: ").append(this.g);
        if (!this.g) {
            UiMessage.ControlEvent build = UiMessage.ControlEvent.newBuilder().setControlId((String) adapterView.getTag()).setType(UiMessage.ControlEvent.Event_Type.ON_CLICK).setEventArgs(String.valueOf(i2)).setEventFunctionName((String) adapterView.getTag(R.id.uip_function_key)).build();
            UipEventStub.hasEvent(UiMessage.UipToCommand.newBuilder().setCommand(UiMessage.UipToCommand.Command_Type.EVENT).setIsSuccess(true).setEvent(build).build().toByteString());
            new StringBuilder("onItemSelected: ").append(build);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public LinearLayout parseLayoutFromJson(String str, IUipJsonParser iUipJsonParser) {
        return this.f2675b.getResources().getConfiguration().orientation == 2 ? c(str, iUipJsonParser) : b(str, iUipJsonParser);
    }

    public void restoreConfig() {
        configViewFromFile(f2674a);
    }

    public String saveConfigToJson() {
        this.i = new JSONObject();
        for (ScrollView childAt : this.f) {
            try {
                b((LinearLayout) childAt.getChildAt(0));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return this.i.toString();
    }

    public void saveToConfigFile(String str) {
        try {
            FileUtils.writeStringToFile(new File(str), saveConfigToJson());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public View transform(int i2) {
        for (ScrollView next : this.f) {
            ViewParent parent = next.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(next);
            }
            new StringBuilder("childCount of scrollview: ").append(((ViewGroup) next.getChildAt(0)).getChildCount());
        }
        if (i2 == 2) {
            this.e = new c(this.f2675b);
            this.e.a(this.f);
            this.e.setSelectTab(this.f2676c.getViewPager().getCurrentItem());
            return this.e;
        }
        ArrayList arrayList = new ArrayList();
        for (ScrollView tag : this.f) {
            arrayList.add((String) tag.getTag());
        }
        LinearLayout linearLayout = new LinearLayout(this.f2675b);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        this.f2676c = new SlidingTabLayout(this.f2675b);
        this.f2676c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f2676c.setSelectedIndicatorColors(this.f2675b.getResources().getColor(R.color.ui_show_blue));
        this.f2676c.setDistributeEvenly(true);
        linearLayout.addView(this.f2676c);
        ViewPager viewPager = new ViewPager(this.f2675b);
        TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        viewPager.setLayoutParams(layoutParams);
        linearLayout.addView(viewPager);
        viewPager.setAdapter(new f(this.f, arrayList));
        viewPager.setCurrentItem(this.e.getCurrentItem());
        this.f2676c.setViewPager(viewPager);
        return linearLayout;
    }
}
