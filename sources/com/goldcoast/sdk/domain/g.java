package com.goldcoast.sdk.domain;

import android.os.ConditionVariable;
import android.text.TextUtils;
import com.b.a.as;
import com.b.a.h;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

final class g implements h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f2964a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ConditionVariable f2965b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ EntryPoint f2966c;

    g(EntryPoint entryPoint, List list, ConditionVariable conditionVariable) {
        this.f2966c = entryPoint;
        this.f2964a = list;
        this.f2965b = conditionVariable;
    }

    public final void a(as asVar) {
        String d = asVar.e().d();
        if (!TextUtils.isEmpty(d)) {
            try {
                EntryPoint.a(this.f2966c, d, this.f2964a);
            } catch (Exception e) {
                int i = 3;
                String format = String.format("Exception:\n %s\n", new Object[]{e.getMessage()});
                if (this.f2966c.r == 4) {
                    format = String.format("Exception:\n %s\n$$$ failed", new Object[]{e.getMessage()});
                    i = 1;
                }
                this.f2966c.b(format, i);
            }
        }
        this.f2965b.open();
    }

    public final void a(IOException iOException) {
        EntryPoint entryPoint;
        String stackString;
        int i;
        new HashMap().put("stack", this.f2966c.getStackString(iOException));
        if (this.f2966c.r == 4) {
            entryPoint = this.f2966c;
            stackString = this.f2966c.getStackString(iOException) + "\n$$$ failed\n";
            i = 1;
        } else {
            entryPoint = this.f2966c;
            stackString = this.f2966c.getStackString(iOException);
            i = 3;
        }
        entryPoint.b(stackString, i);
        this.f2965b.open();
    }
}
