package com.cyjh.mobileanjian.ipc;

import com.cyjh.mobileanjian.ipc.interfaces.OnRootApplyCallback;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static d f2554a = null;
    private static final String h = "echo \"rootOK\"\n";
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public OnRootApplyCallback f2555b = null;

    /* renamed from: c  reason: collision with root package name */
    public a f2556c = null;
    public boolean d = false;
    public DataOutputStream e = null;
    /* access modifiers changed from: package-private */
    public InputStream f = null;
    /* access modifiers changed from: package-private */
    public Process g = null;

    private class a extends Thread {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b2) {
            this();
        }

        public final void run() {
            try {
                d.this.g = Runtime.getRuntime().exec("su");
                d.this.e = new DataOutputStream(d.this.g.getOutputStream());
                d.this.f = d.this.g.getInputStream();
                d.this.e.writeBytes(d.h);
                d.this.e.flush();
                d dVar = d.this;
                new Thread("", d.this.g) {
                    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0029 */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        /*
                            r2 = this;
                            java.io.InputStreamReader r0 = new java.io.InputStreamReader
                            java.lang.Process r1 = r3
                            java.io.InputStream r1 = r1.getErrorStream()
                            r0.<init>(r1)
                            java.io.BufferedReader r1 = new java.io.BufferedReader
                            r1.<init>(r0)
                        L_0x0010:
                            java.lang.String r0 = r1.readLine()     // Catch:{ IOException -> 0x0029, all -> 0x001f }
                            if (r0 != 0) goto L_0x0010
                            r1.close()     // Catch:{ IOException -> 0x001a }
                            return
                        L_0x001a:
                            r0 = move-exception
                            r0.printStackTrace()
                            return
                        L_0x001f:
                            r0 = move-exception
                            r1.close()     // Catch:{ IOException -> 0x0024 }
                            goto L_0x0028
                        L_0x0024:
                            r1 = move-exception
                            r1.printStackTrace()
                        L_0x0028:
                            throw r0
                        L_0x0029:
                            r1.close()     // Catch:{ IOException -> 0x002d }
                            return
                        L_0x002d:
                            r0 = move-exception
                            r0.printStackTrace()
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.d.AnonymousClass1.run():void");
                    }
                };
                AnonymousClass2 r1 = new Thread("", false) {
                    public final void run() {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(d.this.f));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine != null) {
                                    if (readLine.equals("rootOK")) {
                                        d.this.d = true;
                                        if (d.this.f2555b != null) {
                                            d.this.f2555b.onObtained();
                                        }
                                        if (false) {
                                        }
                                    }
                                }
                                try {
                                    bufferedReader.close();
                                    return;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    return;
                                }
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                try {
                                    bufferedReader.close();
                                    return;
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            } catch (Throwable th) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                                throw th;
                            }
                        }
                    }
                };
                r1.start();
                try {
                    r1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new StringBuilder("go straight here, mRoot = ").append(dVar.d);
                if (!dVar.d) {
                    dVar.g.destroy();
                    if (dVar.f2555b != null) {
                        dVar.f2555b.onRefused();
                    }
                    try {
                        dVar.e.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (IOException e3) {
                if (d.this.g != null) {
                    d.this.g.destroy();
                }
                if (d.this.f2555b != null) {
                    d.this.f2555b.onRefused();
                }
                e3.printStackTrace();
            }
        }
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f2554a == null) {
                f2554a = new d();
            }
            dVar = f2554a;
        }
        return dVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:5|6|7|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        r3.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(final java.lang.Process r3, final boolean r4) {
        /*
            r2 = this;
            com.cyjh.mobileanjian.ipc.d$1 r0 = new com.cyjh.mobileanjian.ipc.d$1
            java.lang.String r1 = ""
            r0.<init>(r1, r3)
            com.cyjh.mobileanjian.ipc.d$2 r3 = new com.cyjh.mobileanjian.ipc.d$2
            java.lang.String r1 = ""
            r3.<init>(r1, r4)
            if (r4 == 0) goto L_0x0013
            r0.start()
        L_0x0013:
            r3.start()
            if (r4 == 0) goto L_0x001f
            r0.join()     // Catch:{ InterruptedException -> 0x001b }
        L_0x001b:
            r3.join()     // Catch:{ InterruptedException -> 0x0023 }
            goto L_0x0027
        L_0x001f:
            r3.join()     // Catch:{ InterruptedException -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0027:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "go straight here, mRoot = "
            r3.<init>(r4)
            boolean r4 = r2.d
            r3.append(r4)
            boolean r3 = r2.d
            if (r3 != 0) goto L_0x004f
            java.lang.Process r3 = r2.g
            r3.destroy()
            com.cyjh.mobileanjian.ipc.interfaces.OnRootApplyCallback r3 = r2.f2555b
            if (r3 == 0) goto L_0x0045
            com.cyjh.mobileanjian.ipc.interfaces.OnRootApplyCallback r3 = r2.f2555b
            r3.onRefused()
        L_0x0045:
            java.io.DataOutputStream r3 = r2.e     // Catch:{ IOException -> 0x004b }
            r3.close()     // Catch:{ IOException -> 0x004b }
            return
        L_0x004b:
            r3 = move-exception
            r3.printStackTrace()
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.d.a(java.lang.Process, boolean):void");
    }

    private static /* synthetic */ void b(d dVar, final Process process) {
        new Thread("") {
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r2 = this;
                    java.io.InputStreamReader r0 = new java.io.InputStreamReader
                    java.lang.Process r1 = r3
                    java.io.InputStream r1 = r1.getErrorStream()
                    r0.<init>(r1)
                    java.io.BufferedReader r1 = new java.io.BufferedReader
                    r1.<init>(r0)
                L_0x0010:
                    java.lang.String r0 = r1.readLine()     // Catch:{ IOException -> 0x0029, all -> 0x001f }
                    if (r0 != 0) goto L_0x0010
                    r1.close()     // Catch:{ IOException -> 0x001a }
                    return
                L_0x001a:
                    r0 = move-exception
                    r0.printStackTrace()
                    return
                L_0x001f:
                    r0 = move-exception
                    r1.close()     // Catch:{ IOException -> 0x0024 }
                    goto L_0x0028
                L_0x0024:
                    r1 = move-exception
                    r1.printStackTrace()
                L_0x0028:
                    throw r0
                L_0x0029:
                    r1.close()     // Catch:{ IOException -> 0x002d }
                    return
                L_0x002d:
                    r0 = move-exception
                    r0.printStackTrace()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.d.AnonymousClass1.run():void");
            }
        };
        AnonymousClass2 r3 = new Thread("", false) {
            public final void run() {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(d.this.f));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            if (readLine.equals("rootOK")) {
                                d.this.d = true;
                                if (d.this.f2555b != null) {
                                    d.this.f2555b.onObtained();
                                }
                                if (false) {
                                }
                            }
                        }
                        try {
                            bufferedReader.close();
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return;
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        try {
                            bufferedReader.close();
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return;
                        }
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        throw th;
                    }
                }
            }
        };
        r3.start();
        try {
            r3.join();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        new StringBuilder("go straight here, mRoot = ").append(dVar.d);
        if (!dVar.d) {
            dVar.g.destroy();
            if (dVar.f2555b != null) {
                dVar.f2555b.onRefused();
            }
            try {
                dVar.e.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    private boolean b() {
        return this.d;
    }

    private void c() {
        if (this.d) {
            a("exit");
            if (this.f2556c.isAlive()) {
                this.f2556c.interrupt();
            }
            try {
                this.e.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        f2554a = null;
    }

    private void d() {
        this.f2556c = new a(this, (byte) 0);
        this.f2556c.start();
    }

    public final void a(OnRootApplyCallback onRootApplyCallback) {
        if (this.d) {
            onRootApplyCallback.onObtained();
            return;
        }
        this.f2555b = onRootApplyCallback;
        this.f2556c = new a(this, (byte) 0);
        this.f2556c.start();
    }

    public final boolean a(String str) {
        if (!this.d) {
            return false;
        }
        try {
            this.e.write(str.getBytes());
            this.e.write("\n".getBytes());
            this.e.flush();
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            return true;
        }
    }
}
