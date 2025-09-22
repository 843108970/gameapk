package com.cyjh.elfin.floatingwindowprocess.a;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import com.ywfzjbcy.R;

public final class a extends com.cyjh.elfin.ui.a.a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public b f1975a;

    /* renamed from: b  reason: collision with root package name */
    public C0026a f1976b;

    /* renamed from: c  reason: collision with root package name */
    private Button f1977c;
    private Button e;

    /* renamed from: com.cyjh.elfin.floatingwindowprocess.a.a$a  reason: collision with other inner class name */
    public interface C0026a {
        void a();
    }

    public interface b {
        void a();
    }

    public a(Context context) {
        super(context);
        Window window;
        int i;
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

    private void a() {
        this.f1977c = (Button) findViewById(R.id.hidefw_button_ok);
        this.e = (Button) findViewById(R.id.hidefw_button_cancel);
        this.f1977c.setOnClickListener(this);
        this.e.setOnClickListener(this);
    }

    private void a(C0026a aVar) {
        this.f1976b = aVar;
    }

    private void a(b bVar) {
        this.f1975a = bVar;
    }

    public final void onClick(View view) {
        switch (view.getId()) {
            case R.id.hidefw_button_cancel /*2131755339*/:
                if (this.f1976b != null) {
                    this.f1976b.a();
                    break;
                }
                break;
            case R.id.hidefw_button_ok /*2131755340*/:
                if (this.f1975a != null) {
                    this.f1975a.a();
                    break;
                }
                break;
        }
        dismiss();
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_hidefw);
        a(0.1f);
        a(0.8f, 0.3f);
        this.f1977c = (Button) findViewById(R.id.hidefw_button_ok);
        this.e = (Button) findViewById(R.id.hidefw_button_cancel);
        this.f1977c.setOnClickListener(this);
        this.e.setOnClickListener(this);
    }
}
