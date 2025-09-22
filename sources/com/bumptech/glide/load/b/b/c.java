package com.bumptech.glide.load.b.b;

import com.bumptech.glide.util.i;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class c {

    /* renamed from: a  reason: collision with root package name */
    final Map<String, a> f1056a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    final b f1057b = new b();

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        final Lock f1058a = new ReentrantLock();

        /* renamed from: b  reason: collision with root package name */
        int f1059b;

        a() {
        }
    }

    private static class b {

        /* renamed from: b  reason: collision with root package name */
        private static final int f1060b = 10;

        /* renamed from: a  reason: collision with root package name */
        final Queue<a> f1061a = new ArrayDeque();

        b() {
        }

        private void a(a aVar) {
            synchronized (this.f1061a) {
                if (this.f1061a.size() < 10) {
                    this.f1061a.offer(aVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final a a() {
            a poll;
            synchronized (this.f1061a) {
                poll = this.f1061a.poll();
            }
            return poll == null ? new a() : poll;
        }
    }

    c() {
    }

    private void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.f1056a.get(str);
            if (aVar == null) {
                aVar = this.f1057b.a();
                this.f1056a.put(str, aVar);
            }
            aVar.f1059b++;
        }
        aVar.f1058a.lock();
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) i.a(this.f1056a.get(str), "Argument must not be null");
            if (aVar.f1059b <= 0) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f1059b);
            }
            aVar.f1059b--;
            if (aVar.f1059b == 0) {
                a remove = this.f1056a.remove(str);
                if (!remove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                }
                b bVar = this.f1057b;
                synchronized (bVar.f1061a) {
                    if (bVar.f1061a.size() < 10) {
                        bVar.f1061a.offer(remove);
                    }
                }
            }
        }
        aVar.f1058a.unlock();
    }
}
