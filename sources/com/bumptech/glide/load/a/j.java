package com.bumptech.glide.load.a;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.l;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c.g;
import com.bumptech.glide.load.e;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public final class j implements d<InputStream> {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    static final b f995a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final String f996b = "HttpUrlFetcher";

    /* renamed from: c  reason: collision with root package name */
    private static final int f997c = 5;
    private static final int d = -1;
    private final g e;
    private final int f;
    private final b g;
    private HttpURLConnection h;
    private InputStream i;
    private volatile boolean j;

    private static class a implements b {
        a() {
        }

        public final HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public j(g gVar, int i2) {
        this(gVar, i2, f995a);
    }

    @VisibleForTesting
    private j(g gVar, int i2, b bVar) {
        this.e = gVar;
        this.f = i2;
        this.g = bVar;
    }

    private InputStream a(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream;
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            inputStream = com.bumptech.glide.util.b.a(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable(f996b, 3)) {
                Log.d(f996b, "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            inputStream = httpURLConnection.getInputStream();
        }
        this.i = inputStream;
        return this.i;
    }

    private InputStream a(URL url, int i2, URL url2, Map<String, String> map) throws IOException {
        InputStream inputStream;
        while (i2 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new e("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.h = this.g.a(url);
            for (Map.Entry next : map.entrySet()) {
                this.h.addRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            this.h.setConnectTimeout(this.f);
            this.h.setReadTimeout(this.f);
            boolean z = false;
            this.h.setUseCaches(false);
            this.h.setDoInput(true);
            this.h.setInstanceFollowRedirects(false);
            this.h.connect();
            this.i = this.h.getInputStream();
            if (this.j) {
                return null;
            }
            int responseCode = this.h.getResponseCode();
            int i3 = responseCode / 100;
            if (i3 == 2) {
                HttpURLConnection httpURLConnection = this.h;
                if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                    inputStream = com.bumptech.glide.util.b.a(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
                } else {
                    if (Log.isLoggable(f996b, 3)) {
                        Log.d(f996b, "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                    }
                    inputStream = httpURLConnection.getInputStream();
                }
                this.i = inputStream;
                return this.i;
            }
            if (i3 == 3) {
                z = true;
            }
            if (z) {
                String headerField = this.h.getHeaderField("Location");
                if (TextUtils.isEmpty(headerField)) {
                    throw new e("Received empty or null redirect url");
                }
                URL url3 = new URL(url, headerField);
                b();
                i2++;
                url2 = url;
                url = url3;
            } else if (responseCode == -1) {
                throw new e(responseCode);
            } else {
                throw new e(this.h.getResponseMessage(), responseCode);
            }
        }
        throw new e("Too many (> 5) redirects!");
    }

    private static boolean a(int i2) {
        return i2 / 100 == 2;
    }

    private static boolean b(int i2) {
        return i2 / 100 == 3;
    }

    @NonNull
    public final Class<InputStream> a() {
        return InputStream.class;
    }

    public final void a(@NonNull l lVar, @NonNull d.a<? super InputStream> aVar) {
        String str;
        StringBuilder sb;
        long a2 = com.bumptech.glide.util.e.a();
        try {
            g gVar = this.e;
            if (gVar.d == null) {
                gVar.d = new URL(gVar.a());
            }
            aVar.a(a(gVar.d, 0, (URL) null, this.e.f1227c.a()));
            if (Log.isLoggable(f996b, 2)) {
                str = f996b;
                sb = new StringBuilder("Finished http url fetcher fetch in ");
                sb.append(com.bumptech.glide.util.e.a(a2));
                Log.v(str, sb.toString());
            }
        } catch (IOException e2) {
            if (Log.isLoggable(f996b, 3)) {
                Log.d(f996b, "Failed to load data for url", e2);
            }
            aVar.a((Exception) e2);
            if (Log.isLoggable(f996b, 2)) {
                str = f996b;
                sb = new StringBuilder("Finished http url fetcher fetch in ");
            }
        } catch (Throwable th) {
            if (Log.isLoggable(f996b, 2)) {
                Log.v(f996b, "Finished http url fetcher fetch in " + com.bumptech.glide.util.e.a(a2));
            }
            throw th;
        }
    }

    public final void b() {
        if (this.i != null) {
            try {
                this.i.close();
            } catch (IOException unused) {
            }
        }
        if (this.h != null) {
            this.h.disconnect();
        }
        this.h = null;
    }

    public final void c() {
        this.j = true;
    }

    @NonNull
    public final com.bumptech.glide.load.a d() {
        return com.bumptech.glide.load.a.REMOTE;
    }
}
