package com.goldcoast.sdk.domain;

import android.os.ConditionVariable;
import android.text.TextUtils;
import com.b.a.as;
import com.b.a.h;
import java.io.IOException;
import java.util.HashMap;

final class e implements h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ConditionVariable f2960a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean[] f2961b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ EntryPoint f2962c;

    e(EntryPoint entryPoint, ConditionVariable conditionVariable, boolean[] zArr) {
        this.f2962c = entryPoint;
        this.f2960a = conditionVariable;
        this.f2961b = zArr;
    }

    public final void a(as asVar) {
        String d = asVar.e().d();
        if (!TextUtils.isEmpty(d)) {
            try {
                EntryPoint.a(this.f2962c, d);
            } catch (Exception e) {
                int i = 3;
                String format = String.format("Exception:\n %s\n", new Object[]{e.getMessage()});
                if (this.f2962c.r == 4) {
                    format = String.format("Exception:\n %s\n$$$ failed", new Object[]{e.getMessage()});
                    i = 1;
                }
                this.f2962c.b(format, i);
            }
        }
        this.f2960a.open();
    }

    public final void a(IOException iOException) {
        EntryPoint entryPoint;
        String stackString;
        new HashMap().put("stack", this.f2962c.getStackString(iOException));
        int i = 1;
        this.f2961b[0] = true;
        if (this.f2962c.r == 4) {
            entryPoint = this.f2962c;
            stackString = this.f2962c.getStackString(iOException) + "\n$$$ failed\n";
        } else {
            entryPoint = this.f2962c;
            stackString = this.f2962c.getStackString(iOException);
            i = 3;
        }
        entryPoint.b(stackString, i);
        this.f2960a.open();
    }
}
