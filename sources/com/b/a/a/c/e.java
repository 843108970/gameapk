package com.b.a.a.c;

import com.b.a.a.c;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

final class e extends ThreadLocal<DateFormat> {
    e() {
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object initialValue() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setLenient(false);
        simpleDateFormat.setTimeZone(c.f);
        return simpleDateFormat;
    }
}
