package com.cyjh.elfin.ui.a;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.cyjh.elfin.ui.b.a;
import com.ywfzjbcy.R;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f2107a;

    /* renamed from: b  reason: collision with root package name */
    private ProgressDialog f2108b;

    private b() {
    }

    public static AlertDialog a(Context context, int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.Theme_Dialog);
        builder.setView(LayoutInflater.from(context).inflate(i, (ViewGroup) null));
        AlertDialog create = builder.create();
        Window window = create.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.6f;
        window.setAttributes(attributes);
        window.addFlags(2);
        return create;
    }

    public static b a() {
        if (f2107a == null) {
            f2107a = new b();
        }
        return f2107a;
    }

    private static void a(int i, String str, Context context, a aVar) {
        AlertDialog a2 = a(context, (int) R.layout.dialog_version_inspection);
        a2.setCancelable(false);
        a2.show();
        ((TextView) a2.findViewById(R.id.id_tv_message)).setText(str);
        aVar.f2248b = a2;
        aVar.f2249c = i;
        ((TextView) a2.findViewById(R.id.id_tv_known)).setOnClickListener(aVar);
    }

    private static void a(AlertDialog alertDialog) {
        Window window = alertDialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.6f;
        window.setAttributes(attributes);
        window.addFlags(2);
    }

    private void a(Context context, String str) {
        if (this.f2108b == null) {
            this.f2108b = new ProgressDialog(context);
        }
        this.f2108b.setMessage(str);
        this.f2108b.show();
    }

    private void b() {
        if (this.f2108b != null && this.f2108b.isShowing()) {
            this.f2108b.dismiss();
            this.f2108b = null;
        }
    }

    private void b(Context context, int i) {
        String string = context.getString(i);
        if (this.f2108b == null) {
            this.f2108b = new ProgressDialog(context);
        }
        this.f2108b.setMessage(string);
        this.f2108b.show();
    }
}
