package com.a.a.a;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public final class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedReader f460a;

    /* renamed from: b  reason: collision with root package name */
    private List<String> f461b;

    /* renamed from: c  reason: collision with root package name */
    private d f462c;

    public c(InputStream inputStream, List<String> list) {
        this.f460a = new BufferedReader(new InputStreamReader(inputStream));
        this.f461b = list;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0014 */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014 A[SYNTHETIC, Splitter:B:7:0x0014] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r2 = this;
        L_0x0000:
            java.io.BufferedReader r0 = r2.f460a     // Catch:{ IOException -> 0x0014 }
            java.lang.String r0 = r0.readLine()     // Catch:{ IOException -> 0x0014 }
            if (r0 == 0) goto L_0x0014
            java.util.List<java.lang.String> r1 = r2.f461b     // Catch:{ IOException -> 0x0014 }
            if (r1 == 0) goto L_0x0011
            java.util.List<java.lang.String> r1 = r2.f461b     // Catch:{ IOException -> 0x0014 }
            r1.add(r0)     // Catch:{ IOException -> 0x0014 }
        L_0x0011:
            com.a.a.a.d r0 = r2.f462c     // Catch:{ IOException -> 0x0014 }
            goto L_0x0000
        L_0x0014:
            java.io.BufferedReader r0 = r2.f460a     // Catch:{ IOException -> 0x0019 }
            r0.close()     // Catch:{ IOException -> 0x0019 }
        L_0x0019:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.c.run():void");
    }
}
