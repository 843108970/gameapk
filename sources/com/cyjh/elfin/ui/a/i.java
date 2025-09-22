package com.cyjh.elfin.ui.a;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.cyjh.common.util.ad;
import java.io.File;

final /* synthetic */ class i implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final h f2126a;

    i(h hVar) {
        this.f2126a = hVar;
    }

    public final boolean handleMessage(Message message) {
        h hVar = this.f2126a;
        switch (message.what) {
            case 1000:
                File file = (File) message.obj;
                if (hVar.f) {
                    return false;
                }
                ad.c(h.f2120a, "afterDownloadSuccess --> 1 ");
                hVar.d(file);
                hVar.f2122c.setText("安装");
                hVar.f2122c.setOnClickListener(new j(hVar, file));
                return false;
            case 1001:
                int intValue = ((Integer) message.obj).intValue();
                TextView textView = hVar.f2121b;
                textView.setText(intValue + "%");
                hVar.e.setProgress(intValue);
                return false;
            case 1002:
                hVar.i = true;
                hVar.a();
                return false;
            default:
                return false;
        }
    }
}
