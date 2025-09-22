package org.apache.commons.mail.a;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.activation.DataSource;
import javax.activation.URLDataSource;

public final class e extends a {

    /* renamed from: b  reason: collision with root package name */
    private final URL f4285b;

    private e(URL url) {
        this.f4285b = url;
    }

    private e(URL url, boolean z) {
        super(z);
        this.f4285b = url;
    }

    private URL a() {
        return this.f4285b;
    }

    private URL b(String str) throws MalformedURLException {
        if (this.f4285b == null) {
            return new URL(str);
        }
        if (str != null && str.length() != 0) {
            return (str.startsWith("file:/") || a(str)) ? new URL(str) : new URL(this.f4285b, str.replaceAll("&amp;", "&"));
        }
        throw new IllegalArgumentException("No resource defined");
    }

    public final DataSource resolve(String str) throws IOException {
        return resolve(str, this.f4281a);
    }

    public final DataSource resolve(String str, boolean z) throws IOException {
        URL url;
        try {
            if (str.startsWith("cid:")) {
                return null;
            }
            if (this.f4285b == null) {
                url = new URL(str);
            } else {
                if (str != null) {
                    if (str.length() != 0) {
                        if (!str.startsWith("file:/")) {
                            if (!a(str)) {
                                url = new URL(this.f4285b, str.replaceAll("&amp;", "&"));
                            }
                        }
                        url = new URL(str);
                    }
                }
                throw new IllegalArgumentException("No resource defined");
            }
            URLDataSource uRLDataSource = new URLDataSource(url);
            uRLDataSource.getInputStream();
            return uRLDataSource;
        } catch (IOException e) {
            if (z) {
                return null;
            }
            throw e;
        }
    }
}
