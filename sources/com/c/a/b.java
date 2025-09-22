package com.c.a;

import android.net.Uri;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.c.b.a;
import com.c.b.c;
import java.net.HttpURLConnection;
import org.apache.http.HttpRequest;

public final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private String f1515a;

    /* renamed from: b  reason: collision with root package name */
    private String f1516b;

    private b(String str, String str2) {
        this.f1515a = str;
        this.f1516b = str2;
    }

    public final void a(a<?, ?> aVar, HttpURLConnection httpURLConnection) {
        byte[] bytes = (String.valueOf(this.f1515a) + ":" + this.f1516b).getBytes();
        StringBuilder sb = new StringBuilder("Basic ");
        sb.append(new String(com.c.d.a.a(bytes, bytes.length)));
        String sb2 = sb.toString();
        httpURLConnection.setRequestProperty(HttpHeaders.HOST, Uri.parse(aVar.f1539c).getHost());
        httpURLConnection.setRequestProperty("Authorization", sb2);
    }

    public final void a(a<?, ?> aVar, HttpRequest httpRequest) {
        byte[] bytes = (String.valueOf(this.f1515a) + ":" + this.f1516b).getBytes();
        StringBuilder sb = new StringBuilder("Basic ");
        sb.append(new String(com.c.d.a.a(bytes, bytes.length)));
        String sb2 = sb.toString();
        httpRequest.addHeader(HttpHeaders.HOST, Uri.parse(aVar.f1539c).getHost());
        httpRequest.addHeader("Authorization", sb2);
    }

    public final boolean a() {
        return true;
    }

    public final boolean a(a<?, ?> aVar, c cVar) {
        return false;
    }

    /* access modifiers changed from: protected */
    public final void b() {
    }

    public final boolean b(a<?, ?> aVar) {
        return false;
    }
}
