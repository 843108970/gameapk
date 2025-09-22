package com.b.a.a.h;

import com.b.a.a.c;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Marker;

public final class d implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public static final d f743a = new d();

    private d() {
    }

    public static List<String> a(X509Certificate x509Certificate) {
        List<String> a2 = a(x509Certificate, 7);
        List<String> a3 = a(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(a2.size() + a3.size());
        arrayList.addAll(a2);
        arrayList.addAll(a3);
        return arrayList;
    }

    private static List<String> a(X509Certificate x509Certificate, int i) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List next : subjectAlternativeNames) {
                if (!(next == null || next.size() < 2 || (num = (Integer) next.get(0)) == null || num.intValue() != i || (str = (String) next.get(1)) == null)) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    private static boolean a(String str, String str2) {
        if (str == null || str.length() == 0 || str.startsWith(".") || str.endsWith("..") || str2 == null || str2.length() == 0 || str2.startsWith(".") || str2.endsWith("..")) {
            return false;
        }
        if (!str.endsWith(".")) {
            str = str + FilenameUtils.EXTENSION_SEPARATOR;
        }
        if (!str2.endsWith(".")) {
            str2 = str2 + FilenameUtils.EXTENSION_SEPARATOR;
        }
        String lowerCase = str2.toLowerCase(Locale.US);
        if (!lowerCase.contains(Marker.ANY_MARKER)) {
            return str.equals(lowerCase);
        }
        if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
            return false;
        }
        String substring = lowerCase.substring(1);
        if (!str.endsWith(substring)) {
            return false;
        }
        int length = str.length() - substring.length();
        return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        String a2;
        try {
            X509Certificate x509Certificate = (X509Certificate) sSLSession.getPeerCertificates()[0];
            if (c.c(str)) {
                List<String> a3 = a(x509Certificate, 7);
                int size = a3.size();
                for (int i = 0; i < size; i++) {
                    if (str.equalsIgnoreCase(a3.get(i))) {
                        return true;
                    }
                }
                return false;
            }
            String lowerCase = str.toLowerCase(Locale.US);
            List<String> a4 = a(x509Certificate, 2);
            int size2 = a4.size();
            int i2 = 0;
            boolean z = false;
            while (i2 < size2) {
                if (a(lowerCase, a4.get(i2))) {
                    return true;
                }
                i2++;
                z = true;
            }
            if (!z && (a2 = new c(x509Certificate.getSubjectX500Principal()).a("cn")) != null) {
                return a(lowerCase, a2);
            }
            return false;
        } catch (SSLException unused) {
        }
    }
}
