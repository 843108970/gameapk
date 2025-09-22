package com.lidroid.xutils.http.client.util;

import android.text.TextUtils;
import com.lidroid.xutils.util.LogUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Marker;

public class URIBuilder {
    private String encodedAuthority;
    private String encodedFragment;
    private String encodedPath;
    private String encodedQuery;
    private String encodedSchemeSpecificPart;
    private String encodedUserInfo;
    private String fragment;
    private String host;
    private String path;
    private int port;
    private List<NameValuePair> queryParams;
    private String scheme;
    private String userInfo;

    public URIBuilder() {
        this.port = -1;
    }

    public URIBuilder(String str) {
        try {
            digestURI(new URI(str));
        } catch (URISyntaxException e) {
            LogUtils.e(e.getMessage(), e);
        }
    }

    public URIBuilder(URI uri) {
        digestURI(uri);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String buildString(java.nio.charset.Charset r3) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r2.scheme
            if (r1 == 0) goto L_0x0013
            java.lang.String r1 = r2.scheme
            r0.append(r1)
            r1 = 58
            r0.append(r1)
        L_0x0013:
            java.lang.String r1 = r2.encodedSchemeSpecificPart
            if (r1 == 0) goto L_0x001e
            java.lang.String r1 = r2.encodedSchemeSpecificPart
        L_0x0019:
            r0.append(r1)
            goto L_0x00b4
        L_0x001e:
            java.lang.String r1 = r2.encodedAuthority
            if (r1 == 0) goto L_0x002d
            java.lang.String r1 = "//"
            r0.append(r1)
            java.lang.String r1 = r2.encodedAuthority
            r0.append(r1)
            goto L_0x0079
        L_0x002d:
            java.lang.String r1 = r2.host
            if (r1 == 0) goto L_0x0079
            java.lang.String r1 = "//"
            r0.append(r1)
            java.lang.String r1 = r2.encodedUserInfo
            if (r1 == 0) goto L_0x0045
            java.lang.String r1 = r2.encodedUserInfo
        L_0x003c:
            r0.append(r1)
            java.lang.String r1 = "@"
            r0.append(r1)
            goto L_0x0050
        L_0x0045:
            java.lang.String r1 = r2.userInfo
            if (r1 == 0) goto L_0x0050
            java.lang.String r1 = r2.userInfo
            java.lang.String r1 = r2.encodeUserInfo(r1, r3)
            goto L_0x003c
        L_0x0050:
            java.lang.String r1 = r2.host
            boolean r1 = org.apache.http.conn.util.InetAddressUtils.isIPv6Address(r1)
            if (r1 == 0) goto L_0x0068
            java.lang.String r1 = "["
            r0.append(r1)
            java.lang.String r1 = r2.host
            r0.append(r1)
            java.lang.String r1 = "]"
        L_0x0064:
            r0.append(r1)
            goto L_0x006b
        L_0x0068:
            java.lang.String r1 = r2.host
            goto L_0x0064
        L_0x006b:
            int r1 = r2.port
            if (r1 < 0) goto L_0x0079
            java.lang.String r1 = ":"
            r0.append(r1)
            int r1 = r2.port
            r0.append(r1)
        L_0x0079:
            java.lang.String r1 = r2.encodedPath
            if (r1 == 0) goto L_0x0087
            java.lang.String r1 = r2.encodedPath
            java.lang.String r1 = normalizePath(r1)
        L_0x0083:
            r0.append(r1)
            goto L_0x0096
        L_0x0087:
            java.lang.String r1 = r2.path
            if (r1 == 0) goto L_0x0096
            java.lang.String r1 = r2.path
            java.lang.String r1 = normalizePath(r1)
            java.lang.String r1 = r2.encodePath(r1, r3)
            goto L_0x0083
        L_0x0096:
            java.lang.String r1 = r2.encodedQuery
            if (r1 == 0) goto L_0x00a3
            java.lang.String r1 = "?"
            r0.append(r1)
            java.lang.String r1 = r2.encodedQuery
            goto L_0x0019
        L_0x00a3:
            java.util.List<org.apache.http.NameValuePair> r1 = r2.queryParams
            if (r1 == 0) goto L_0x00b4
            java.lang.String r1 = "?"
            r0.append(r1)
            java.util.List<org.apache.http.NameValuePair> r1 = r2.queryParams
            java.lang.String r1 = r2.encodeQuery(r1, r3)
            goto L_0x0019
        L_0x00b4:
            java.lang.String r1 = r2.encodedFragment
            if (r1 == 0) goto L_0x00c3
            java.lang.String r3 = "#"
            r0.append(r3)
            java.lang.String r3 = r2.encodedFragment
        L_0x00bf:
            r0.append(r3)
            goto L_0x00d3
        L_0x00c3:
            java.lang.String r1 = r2.fragment
            if (r1 == 0) goto L_0x00d3
            java.lang.String r1 = "#"
            r0.append(r1)
            java.lang.String r1 = r2.fragment
            java.lang.String r3 = r2.encodeFragment(r1, r3)
            goto L_0x00bf
        L_0x00d3:
            java.lang.String r3 = r0.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.http.client.util.URIBuilder.buildString(java.nio.charset.Charset):java.lang.String");
    }

    private void digestURI(URI uri) {
        this.scheme = uri.getScheme();
        this.encodedSchemeSpecificPart = uri.getRawSchemeSpecificPart();
        this.encodedAuthority = uri.getRawAuthority();
        this.host = uri.getHost();
        this.port = uri.getPort();
        this.encodedUserInfo = uri.getRawUserInfo();
        this.userInfo = uri.getUserInfo();
        this.encodedPath = uri.getRawPath();
        this.path = uri.getPath();
        this.encodedQuery = uri.getRawQuery();
        this.queryParams = parseQuery(uri.getRawQuery());
        this.encodedFragment = uri.getRawFragment();
        this.fragment = uri.getFragment();
    }

    private String encodeFragment(String str, Charset charset) {
        return URLEncodedUtils.encFragment(str, charset);
    }

    private String encodePath(String str, Charset charset) {
        return URLEncodedUtils.encPath(str, charset).replace(Marker.ANY_NON_NULL_MARKER, "20%");
    }

    private String encodeQuery(List<NameValuePair> list, Charset charset) {
        return URLEncodedUtils.format((Iterable<? extends NameValuePair>) list, charset);
    }

    private String encodeUserInfo(String str, Charset charset) {
        return URLEncodedUtils.encUserInfo(str, charset);
    }

    private static String normalizePath(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        while (i < str.length() && str.charAt(i) == '/') {
            i++;
        }
        return i > 1 ? str.substring(i - 1) : str;
    }

    private List<NameValuePair> parseQuery(String str) {
        if (!TextUtils.isEmpty(str)) {
            return URLEncodedUtils.parse(str);
        }
        return null;
    }

    public URIBuilder addParameter(String str, String str2) {
        if (this.queryParams == null) {
            this.queryParams = new ArrayList();
        }
        this.queryParams.add(new BasicNameValuePair(str, str2));
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    public URI build(Charset charset) throws URISyntaxException {
        return new URI(buildString(charset));
    }

    public String getFragment() {
        return this.fragment;
    }

    public String getHost() {
        return this.host;
    }

    public String getPath() {
        return this.path;
    }

    public int getPort() {
        return this.port;
    }

    public List<NameValuePair> getQueryParams() {
        return this.queryParams != null ? new ArrayList(this.queryParams) : new ArrayList();
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getUserInfo() {
        return this.userInfo;
    }

    public URIBuilder setFragment(String str) {
        this.fragment = str;
        this.encodedFragment = null;
        return this;
    }

    public URIBuilder setHost(String str) {
        this.host = str;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        return this;
    }

    public URIBuilder setParameter(String str, String str2) {
        if (this.queryParams == null) {
            this.queryParams = new ArrayList();
        }
        if (!this.queryParams.isEmpty()) {
            Iterator<NameValuePair> it = this.queryParams.iterator();
            while (it.hasNext()) {
                if (it.next().getName().equals(str)) {
                    it.remove();
                }
            }
        }
        this.queryParams.add(new BasicNameValuePair(str, str2));
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    public URIBuilder setPath(String str) {
        this.path = str;
        this.encodedSchemeSpecificPart = null;
        this.encodedPath = null;
        return this;
    }

    public URIBuilder setPort(int i) {
        if (i < 0) {
            i = -1;
        }
        this.port = i;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        return this;
    }

    public URIBuilder setQuery(String str) {
        this.queryParams = parseQuery(str);
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    public URIBuilder setScheme(String str) {
        this.scheme = str;
        return this;
    }

    public URIBuilder setUserInfo(String str) {
        this.userInfo = str;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        this.encodedUserInfo = null;
        return this;
    }

    public URIBuilder setUserInfo(String str, String str2) {
        return setUserInfo(String.valueOf(str) + ':' + str2);
    }
}
