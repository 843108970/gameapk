package com.android.volley.toolbox;

import com.android.volley.l;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public final class g implements i {

    /* renamed from: b  reason: collision with root package name */
    private static final String f534b = "Content-Type";

    /* renamed from: a  reason: collision with root package name */
    protected final HttpClient f535a;

    public static final class a extends HttpEntityEnclosingRequestBase {

        /* renamed from: a  reason: collision with root package name */
        public static final String f536a = "PATCH";

        public a() {
        }

        public a(String str) {
            setURI(URI.create(str));
        }

        private a(URI uri) {
            setURI(uri);
        }

        public final String getMethod() {
            return f536a;
        }
    }

    public g(HttpClient httpClient) {
        this.f535a = httpClient;
    }

    private static List<NameValuePair> a(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (String next : map.keySet()) {
            arrayList.add(new BasicNameValuePair(next, map.get(next)));
        }
        return arrayList;
    }

    private static HttpUriRequest a(l<?> lVar) throws com.android.volley.a {
        switch (lVar.f486a) {
            case -1:
                byte[] d = lVar.d();
                if (d == null) {
                    return new HttpGet(lVar.f487b);
                }
                HttpPost httpPost = new HttpPost(lVar.f487b);
                httpPost.addHeader("Content-Type", lVar.c());
                httpPost.setEntity(new ByteArrayEntity(d));
                return httpPost;
            case 0:
                return new HttpGet(lVar.f487b);
            case 1:
                HttpPost httpPost2 = new HttpPost(lVar.f487b);
                httpPost2.addHeader("Content-Type", lVar.f());
                a((HttpEntityEnclosingRequestBase) httpPost2, lVar);
                return httpPost2;
            case 2:
                HttpPut httpPut = new HttpPut(lVar.f487b);
                httpPut.addHeader("Content-Type", lVar.f());
                a((HttpEntityEnclosingRequestBase) httpPut, lVar);
                return httpPut;
            case 3:
                return new HttpDelete(lVar.f487b);
            case 4:
                return new HttpHead(lVar.f487b);
            case 5:
                return new HttpOptions(lVar.f487b);
            case 6:
                return new HttpTrace(lVar.f487b);
            case 7:
                a aVar = new a(lVar.f487b);
                aVar.addHeader("Content-Type", lVar.f());
                a((HttpEntityEnclosingRequestBase) aVar, lVar);
                return aVar;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    private static void a() throws IOException {
    }

    private static void a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, l<?> lVar) throws com.android.volley.a {
        byte[] g = lVar.g();
        if (g != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(g));
        }
    }

    private static void a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String next : map.keySet()) {
            httpUriRequest.setHeader(next, map.get(next));
        }
    }

    public final HttpResponse a(l<?> lVar, Map<String, String> map) throws IOException, com.android.volley.a {
        a aVar;
        switch (lVar.f486a) {
            case -1:
                byte[] d = lVar.d();
                if (d == null) {
                    aVar = new HttpGet(lVar.f487b);
                    break;
                } else {
                    a httpPost = new HttpPost(lVar.f487b);
                    httpPost.addHeader("Content-Type", lVar.c());
                    httpPost.setEntity(new ByteArrayEntity(d));
                    aVar = httpPost;
                    break;
                }
            case 0:
                aVar = new HttpGet(lVar.f487b);
                break;
            case 1:
                aVar = new HttpPost(lVar.f487b);
                aVar.addHeader("Content-Type", lVar.f());
                break;
            case 2:
                aVar = new HttpPut(lVar.f487b);
                aVar.addHeader("Content-Type", lVar.f());
                break;
            case 3:
                aVar = new HttpDelete(lVar.f487b);
                break;
            case 4:
                aVar = new HttpHead(lVar.f487b);
                break;
            case 5:
                aVar = new HttpOptions(lVar.f487b);
                break;
            case 6:
                aVar = new HttpTrace(lVar.f487b);
                break;
            case 7:
                aVar = new a(lVar.f487b);
                aVar.addHeader("Content-Type", lVar.f());
                break;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
        a((HttpEntityEnclosingRequestBase) aVar, lVar);
        a((HttpUriRequest) aVar, map);
        a((HttpUriRequest) aVar, lVar.b());
        HttpParams params = aVar.getParams();
        int i = lVar.i();
        HttpConnectionParams.setConnectionTimeout(params, com.hlzn.socketclient.b.a.t);
        HttpConnectionParams.setSoTimeout(params, i);
        return this.f535a.execute(aVar);
    }
}
