package com.cyjh.elfin.ui.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.cyjh.elfin.entity.MsgItem;
import com.ywfzjbcy.R;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.j;

public final class g extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2117a = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f2118c = true;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f2119b;
    private String d;
    private TextView e;

    public g(Context context, boolean z, String str) {
        super(context, R.style.Theme_Dialog);
        Window window;
        int i;
        if (z) {
            if (Build.VERSION.SDK_INT >= 26) {
                window = getWindow();
                i = 2038;
            } else if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 24) {
                window = getWindow();
                i = 2002;
            } else {
                window = getWindow();
                i = 2005;
            }
            window.setType(i);
        }
        this.d = str;
        f2118c = z;
    }

    private static void a(Dialog dialog) {
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.6f;
        window.setAttributes(attributes);
        window.addFlags(2);
    }

    private void a(View.OnClickListener onClickListener) {
        this.f2119b = onClickListener;
    }

    private void a(String str) {
        this.e.setText(str);
    }

    public final void dismiss() {
        super.dismiss();
        c.a().b((Object) this);
        f2117a = false;
        f2118c = true;
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_version_inspection);
        c.a().a((Object) this);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.6f;
        window.setAttributes(attributes);
        window.addFlags(2);
        this.e = (TextView) findViewById(R.id.id_tv_message);
        this.e.setText(this.d);
        ((TextView) findViewById(R.id.id_tv_known)).setOnClickListener(this.f2119b);
        setCancelable(false);
    }

    @j(a = ThreadMode.MAIN)
    public final void onMessageMainThread(MsgItem.UpdateMessageToDialog updateMessageToDialog) {
        if (!TextUtils.isEmpty(updateMessageToDialog.getMessage())) {
            this.e.setText(updateMessageToDialog.getMessage());
        }
    }

    @j(a = ThreadMode.MAIN)
    public final void onMessageMainThread(MsgItem msgItem) {
        if (msgItem.getMsgType() == 1005) {
            dismiss();
        }
    }

    public final void show() {
        super.show();
        f2117a = true;
    }
}
