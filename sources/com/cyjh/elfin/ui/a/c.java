package com.cyjh.elfin.ui.a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.ywfzjbcy.R;

public final class c extends a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public a f2109a;

    /* renamed from: b  reason: collision with root package name */
    private Button f2110b;

    public interface a {
        void a();
    }

    public c(Context context) {
        super(context);
    }

    private void a() {
        this.f2110b = (Button) findViewById(R.id.dialog_miuiguide_button_open);
        this.f2110b.setOnClickListener(this);
    }

    private void a(a aVar) {
        this.f2109a = aVar;
    }

    public final void onClick(View view) {
        if (view.getId() == R.id.dialog_miuiguide_button_open && this.f2109a != null) {
            this.f2109a.a();
        }
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_float_guide);
        a(0.8f, 0.4f);
        this.f2110b = (Button) findViewById(R.id.dialog_miuiguide_button_open);
        this.f2110b.setOnClickListener(this);
    }
}
