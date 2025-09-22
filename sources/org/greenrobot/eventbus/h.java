package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;

final class h {
    private static final List<h> d = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    Object f4317a;

    /* renamed from: b  reason: collision with root package name */
    n f4318b;

    /* renamed from: c  reason: collision with root package name */
    h f4319c;

    private h(Object obj, n nVar) {
        this.f4317a = obj;
        this.f4318b = nVar;
    }

    static h a(n nVar, Object obj) {
        synchronized (d) {
            int size = d.size();
            if (size <= 0) {
                return new h(obj, nVar);
            }
            h remove = d.remove(size - 1);
            remove.f4317a = obj;
            remove.f4318b = nVar;
            remove.f4319c = null;
            return remove;
        }
    }

    static void a(h hVar) {
        hVar.f4317a = null;
        hVar.f4318b = null;
        hVar.f4319c = null;
        synchronized (d) {
            if (d.size() < 10000) {
                d.add(hVar);
            }
        }
    }
}
