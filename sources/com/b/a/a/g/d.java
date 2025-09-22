package com.b.a.a.g;

import com.b.a.al;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

final class d extends h {

    /* renamed from: a  reason: collision with root package name */
    final Method f726a;

    /* renamed from: b  reason: collision with root package name */
    final Method f727b;

    private d(Method method, Method method2) {
        this.f726a = method;
        this.f727b = method2;
    }

    public static d a() {
        try {
            return new d(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final String a(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f727b.invoke(sSLSocket, new Object[0]);
            if (str == null || str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            throw new AssertionError();
        }
    }

    public final void a(SSLSocket sSLSocket, String str, List<al> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> a2 = a(list);
            this.f726a.invoke(sSLParameters, new Object[]{a2.toArray(new String[a2.size()])});
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            throw new AssertionError();
        }
    }
}
