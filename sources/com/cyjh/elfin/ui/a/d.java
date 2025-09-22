package com.cyjh.elfin.ui.a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.ywfzjbcy.R;

public final class d extends a {

    /* renamed from: a  reason: collision with root package name */
    private Button f2111a;

    public d(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_no_root);
        a(0.8f, 0.4f);
        a(0.5f);
        setCanceledOnTouchOutside(false);
        this.f2111a = (Button) findViewById(R.id.id_btn_sure);
        this.f2111a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.dismiss();
            }
        });
    }
}
