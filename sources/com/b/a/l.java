package com.b.a;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class l {
    public static final l A = a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA");
    public static final l B = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5");
    public static final l C = a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5");
    public static final l D = a("TLS_RSA_WITH_AES_128_CBC_SHA");
    public static final l E = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA");
    public static final l F = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA");
    public static final l G = a("TLS_DH_anon_WITH_AES_128_CBC_SHA");
    public static final l H = a("TLS_RSA_WITH_AES_256_CBC_SHA");
    public static final l I = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA");
    public static final l J = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA");
    public static final l K = a("TLS_DH_anon_WITH_AES_256_CBC_SHA");
    public static final l L = a("TLS_RSA_WITH_NULL_SHA256");
    public static final l M = a("TLS_RSA_WITH_AES_128_CBC_SHA256");
    public static final l N = a("TLS_RSA_WITH_AES_256_CBC_SHA256");
    public static final l O = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256");
    public static final l P = a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA");
    public static final l Q = a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA");
    public static final l R = a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA");
    public static final l S = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256");
    public static final l T = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256");
    public static final l U = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256");
    public static final l V = a("TLS_DH_anon_WITH_AES_128_CBC_SHA256");
    public static final l W = a("TLS_DH_anon_WITH_AES_256_CBC_SHA256");
    public static final l X = a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA");
    public static final l Y = a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA");
    public static final l Z = a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA");

    /* renamed from: a  reason: collision with root package name */
    public static final l f815a = a("SSL_RSA_WITH_NULL_MD5");
    public static final l aA = a("TLS_ECDH_RSA_WITH_RC4_128_SHA");
    public static final l aB = a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA");
    public static final l aC = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA");
    public static final l aD = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA");
    public static final l aE = a("TLS_ECDHE_RSA_WITH_NULL_SHA");
    public static final l aF = a("TLS_ECDHE_RSA_WITH_RC4_128_SHA");
    public static final l aG = a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA");
    public static final l aH = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
    public static final l aI = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");
    public static final l aJ = a("TLS_ECDH_anon_WITH_NULL_SHA");
    public static final l aK = a("TLS_ECDH_anon_WITH_RC4_128_SHA");
    public static final l aL = a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA");
    public static final l aM = a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA");
    public static final l aN = a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA");
    public static final l aO = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256");
    public static final l aP = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384");
    public static final l aQ = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256");
    public static final l aR = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384");
    public static final l aS = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");
    public static final l aT = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");
    public static final l aU = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256");
    public static final l aV = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384");
    public static final l aW = a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");
    public static final l aX = a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");
    public static final l aY = a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256");
    public static final l aZ = a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384");
    public static final l aa = a("TLS_PSK_WITH_RC4_128_SHA");
    public static final l ab = a("TLS_PSK_WITH_3DES_EDE_CBC_SHA");
    public static final l ac = a("TLS_PSK_WITH_AES_128_CBC_SHA");
    public static final l ad = a("TLS_PSK_WITH_AES_256_CBC_SHA");
    public static final l ae = a("TLS_RSA_WITH_SEED_CBC_SHA");
    public static final l af = a("TLS_RSA_WITH_AES_128_GCM_SHA256");
    public static final l ag = a("TLS_RSA_WITH_AES_256_GCM_SHA384");
    public static final l ah = a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256");
    public static final l ai = a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384");
    public static final l aj = a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256");
    public static final l ak = a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384");
    public static final l al = a("TLS_DH_anon_WITH_AES_128_GCM_SHA256");
    public static final l am = a("TLS_DH_anon_WITH_AES_256_GCM_SHA384");
    public static final l an = a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV");
    public static final l ao = a("TLS_FALLBACK_SCSV");
    public static final l ap = a("TLS_ECDH_ECDSA_WITH_NULL_SHA");
    public static final l aq = a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA");
    public static final l ar = a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA");
    public static final l as = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA");
    public static final l at = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA");
    public static final l au = a("TLS_ECDHE_ECDSA_WITH_NULL_SHA");
    public static final l av = a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA");
    public static final l aw = a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA");
    public static final l ax = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA");
    public static final l ay = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA");
    public static final l az = a("TLS_ECDH_RSA_WITH_NULL_SHA");

    /* renamed from: b  reason: collision with root package name */
    public static final l f816b = a("SSL_RSA_WITH_NULL_SHA");
    public static final l ba = a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
    public static final l bb = a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");
    public static final l bc = a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256");
    public static final l bd = a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384");
    public static final l be = a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA");
    public static final l bf = a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA");
    public static final l bg = a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
    public static final l bh = a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256");
    private static final ConcurrentMap<String, l> bj = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public static final l f817c = a("SSL_RSA_EXPORT_WITH_RC4_40_MD5");
    public static final l d = a("SSL_RSA_WITH_RC4_128_MD5");
    public static final l e = a("SSL_RSA_WITH_RC4_128_SHA");
    public static final l f = a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA");
    public static final l g = a("SSL_RSA_WITH_DES_CBC_SHA");
    public static final l h = a("SSL_RSA_WITH_3DES_EDE_CBC_SHA");
    public static final l i = a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA");
    public static final l j = a("SSL_DHE_DSS_WITH_DES_CBC_SHA");
    public static final l k = a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA");
    public static final l l = a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA");
    public static final l m = a("SSL_DHE_RSA_WITH_DES_CBC_SHA");
    public static final l n = a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA");
    public static final l o = a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5");
    public static final l p = a("SSL_DH_anon_WITH_RC4_128_MD5");
    public static final l q = a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA");
    public static final l r = a("SSL_DH_anon_WITH_DES_CBC_SHA");
    public static final l s = a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA");
    public static final l t = a("TLS_KRB5_WITH_DES_CBC_SHA");
    public static final l u = a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA");
    public static final l v = a("TLS_KRB5_WITH_RC4_128_SHA");
    public static final l w = a("TLS_KRB5_WITH_DES_CBC_MD5");
    public static final l x = a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5");
    public static final l y = a("TLS_KRB5_WITH_RC4_128_MD5");
    public static final l z = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA");
    final String bi;

    private l(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.bi = str;
    }

    public static l a(String str) {
        l lVar = (l) bj.get(str);
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(str);
        l putIfAbsent = bj.putIfAbsent(str, lVar2);
        return putIfAbsent == null ? lVar2 : putIfAbsent;
    }

    public final String toString() {
        return this.bi;
    }
}
