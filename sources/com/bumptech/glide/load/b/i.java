package com.bumptech.glide.load.b;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.c;

public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f1142a = new i() {
        public final boolean a() {
            return true;
        }

        public final boolean a(a aVar) {
            return aVar == a.REMOTE;
        }

        public final boolean a(boolean z, a aVar, c cVar) {
            return (aVar == a.RESOURCE_DISK_CACHE || aVar == a.MEMORY_CACHE) ? false : true;
        }

        public final boolean b() {
            return true;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final i f1143b = new i() {
        public final boolean a() {
            return false;
        }

        public final boolean a(a aVar) {
            return false;
        }

        public final boolean a(boolean z, a aVar, c cVar) {
            return false;
        }

        public final boolean b() {
            return false;
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final i f1144c = new i() {
        public final boolean a() {
            return false;
        }

        public final boolean a(a aVar) {
            return (aVar == a.DATA_DISK_CACHE || aVar == a.MEMORY_CACHE) ? false : true;
        }

        public final boolean a(boolean z, a aVar, c cVar) {
            return false;
        }

        public final boolean b() {
            return true;
        }
    };
    public static final i d = new i() {
        public final boolean a() {
            return true;
        }

        public final boolean a(a aVar) {
            return false;
        }

        public final boolean a(boolean z, a aVar, c cVar) {
            return (aVar == a.RESOURCE_DISK_CACHE || aVar == a.MEMORY_CACHE) ? false : true;
        }

        public final boolean b() {
            return false;
        }
    };
    public static final i e = new i() {
        public final boolean a() {
            return true;
        }

        public final boolean a(a aVar) {
            return aVar == a.REMOTE;
        }

        public final boolean a(boolean z, a aVar, c cVar) {
            return ((z && aVar == a.DATA_DISK_CACHE) || aVar == a.LOCAL) && cVar == c.TRANSFORMED;
        }

        public final boolean b() {
            return true;
        }
    };

    public abstract boolean a();

    public abstract boolean a(a aVar);

    public abstract boolean a(boolean z, a aVar, c cVar);

    public abstract boolean b();
}
