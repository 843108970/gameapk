package com.cyjh.http.e;

import b.ac;
import b.e;
import b.f;
import b.z;
import com.cyjh.common.util.ad;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.TimeUnit;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f2524a = "b";
    private static b d;

    /* renamed from: b  reason: collision with root package name */
    public final z f2525b = new z.a().a(60, TimeUnit.SECONDS).b(60, TimeUnit.SECONDS).c(60, TimeUnit.SECONDS).e();

    /* renamed from: c  reason: collision with root package name */
    public e f2526c;
    private RandomAccessFile e;
    /* access modifiers changed from: private */
    public int f;

    public interface a {
        void a(int i);

        void a(File file);

        void a(Exception exc);
    }

    private b() {
    }

    public static b a() {
        if (d == null) {
            d = new b();
        }
        return d;
    }

    private void a(String str, final String str2, final String str3, final a aVar) {
        String str4 = f2524a;
        ad.c(str4, "download 1 --> destFileDir=" + str2 + ",destFileName=" + str3);
        this.f2526c = this.f2525b.a(new ac.a().a(str).d());
        this.f2526c.a(new f() {
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(b.e r12, b.ae r13) {
                /*
                    r11 = this;
                    r12 = 2048(0x800, float:2.87E-42)
                    byte[] r12 = new byte[r12]
                    java.io.File r0 = new java.io.File
                    java.lang.String r1 = r5
                    r0.<init>(r1)
                    boolean r1 = r0.exists()
                    if (r1 != 0) goto L_0x0014
                    r0.mkdirs()
                L_0x0014:
                    java.io.File r1 = new java.io.File
                    java.lang.String r2 = r6
                    r1.<init>(r0, r2)
                    r0 = 0
                    b.af r2 = r13.g     // Catch:{ Exception -> 0x009c, all -> 0x0098 }
                    java.io.InputStream r2 = r2.byteStream()     // Catch:{ Exception -> 0x009c, all -> 0x0098 }
                    b.af r13 = r13.g     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                    long r3 = r13.contentLength()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                    java.io.FileOutputStream r13 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                    r13.<init>(r1)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                    r5 = 0
                L_0x002f:
                    int r0 = r2.read(r12)     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    r7 = -1
                    r8 = 0
                    if (r0 == r7) goto L_0x005c
                    r13.write(r12, r8, r0)     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    long r7 = (long) r0     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    long r9 = r5 + r7
                    com.cyjh.http.e.b r5 = com.cyjh.http.e.b.this     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    com.cyjh.http.e.b r6 = com.cyjh.http.e.b.this     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    int r6 = r6.f     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    int r6 = r6 + r0
                    int unused = r5.f = r6     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    float r0 = (float) r9     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    r5 = 1065353216(0x3f800000, float:1.0)
                    float r0 = r0 * r5
                    float r5 = (float) r3     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    float r0 = r0 / r5
                    r5 = 1120403456(0x42c80000, float:100.0)
                    float r0 = r0 * r5
                    int r0 = (int) r0     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    com.cyjh.http.e.b$a r5 = r7     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    r5.a((int) r0)     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    r5 = r9
                    goto L_0x002f
                L_0x005c:
                    r13.flush()     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    com.cyjh.http.e.b$a r12 = r7     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    r12.a((java.io.File) r1)     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    com.cyjh.http.e.b r12 = com.cyjh.http.e.b.this     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    int unused = r12.f = r8     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    if (r2 == 0) goto L_0x006e
                    r2.close()     // Catch:{ IOException -> 0x008c }
                L_0x006e:
                    r13.close()     // Catch:{ IOException -> 0x008c }
                    java.lang.String r12 = com.cyjh.http.e.b.f2524a     // Catch:{ IOException -> 0x008c }
                    java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x008c }
                    java.lang.String r0 = "download 3 --> downLoadLength="
                    r13.<init>(r0)     // Catch:{ IOException -> 0x008c }
                    com.cyjh.http.e.b r0 = com.cyjh.http.e.b.this     // Catch:{ IOException -> 0x008c }
                    int r0 = r0.f     // Catch:{ IOException -> 0x008c }
                    r13.append(r0)     // Catch:{ IOException -> 0x008c }
                    java.lang.String r13 = r13.toString()     // Catch:{ IOException -> 0x008c }
                    com.cyjh.common.util.ad.c(r12, r13)     // Catch:{ IOException -> 0x008c }
                L_0x008c:
                    return
                L_0x008d:
                    r12 = move-exception
                    goto L_0x00cb
                L_0x008f:
                    r12 = move-exception
                    goto L_0x0096
                L_0x0091:
                    r12 = move-exception
                    r13 = r0
                    goto L_0x00cb
                L_0x0094:
                    r12 = move-exception
                    r13 = r0
                L_0x0096:
                    r0 = r2
                    goto L_0x009e
                L_0x0098:
                    r12 = move-exception
                    r13 = r0
                    r2 = r13
                    goto L_0x00cb
                L_0x009c:
                    r12 = move-exception
                    r13 = r0
                L_0x009e:
                    com.cyjh.http.e.b$a r1 = r7     // Catch:{ all -> 0x00c9 }
                    r1.a((java.lang.Exception) r12)     // Catch:{ all -> 0x00c9 }
                    if (r0 == 0) goto L_0x00a8
                    r0.close()     // Catch:{ IOException -> 0x00c8 }
                L_0x00a8:
                    if (r13 == 0) goto L_0x00ad
                    r13.close()     // Catch:{ IOException -> 0x00c8 }
                L_0x00ad:
                    java.lang.String r12 = com.cyjh.http.e.b.f2524a     // Catch:{ IOException -> 0x00c8 }
                    java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c8 }
                    java.lang.String r0 = "download 3 --> downLoadLength="
                    r13.<init>(r0)     // Catch:{ IOException -> 0x00c8 }
                    com.cyjh.http.e.b r0 = com.cyjh.http.e.b.this     // Catch:{ IOException -> 0x00c8 }
                    int r0 = r0.f     // Catch:{ IOException -> 0x00c8 }
                    r13.append(r0)     // Catch:{ IOException -> 0x00c8 }
                    java.lang.String r13 = r13.toString()     // Catch:{ IOException -> 0x00c8 }
                    com.cyjh.common.util.ad.c(r12, r13)     // Catch:{ IOException -> 0x00c8 }
                L_0x00c8:
                    return
                L_0x00c9:
                    r12 = move-exception
                    r2 = r0
                L_0x00cb:
                    if (r2 == 0) goto L_0x00d0
                    r2.close()     // Catch:{ IOException -> 0x00f0 }
                L_0x00d0:
                    if (r13 == 0) goto L_0x00d5
                    r13.close()     // Catch:{ IOException -> 0x00f0 }
                L_0x00d5:
                    java.lang.String r13 = com.cyjh.http.e.b.f2524a     // Catch:{ IOException -> 0x00f0 }
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00f0 }
                    java.lang.String r1 = "download 3 --> downLoadLength="
                    r0.<init>(r1)     // Catch:{ IOException -> 0x00f0 }
                    com.cyjh.http.e.b r1 = com.cyjh.http.e.b.this     // Catch:{ IOException -> 0x00f0 }
                    int r1 = r1.f     // Catch:{ IOException -> 0x00f0 }
                    r0.append(r1)     // Catch:{ IOException -> 0x00f0 }
                    java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x00f0 }
                    com.cyjh.common.util.ad.c(r13, r0)     // Catch:{ IOException -> 0x00f0 }
                L_0x00f0:
                    throw r12
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cyjh.http.e.b.AnonymousClass1.a(b.e, b.ae):void");
            }

            public final void a(IOException iOException) {
                aVar.a((Exception) iOException);
            }
        });
    }

    private void c() {
        if (this.f2526c != null) {
            this.f2526c.c();
        }
    }

    public final void a(String str, final String str2, final String str3, int i, final a aVar) {
        String str4 = f2524a;
        ad.c(str4, "download 1 --> downLoadLength=" + this.f + ",contentLength=" + i);
        this.f2526c = this.f2525b.a(new ac.a().a(str).d());
        this.f2526c.a(new f() {
            /* JADX WARNING: Removed duplicated region for block: B:33:0x00a5 A[SYNTHETIC, Splitter:B:33:0x00a5] */
            /* JADX WARNING: Removed duplicated region for block: B:36:0x00aa A[Catch:{ IOException -> 0x00c8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:42:0x00cd A[SYNTHETIC, Splitter:B:42:0x00cd] */
            /* JADX WARNING: Removed duplicated region for block: B:45:0x00d2 A[Catch:{ IOException -> 0x00f0 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(b.e r12, b.ae r13) throws java.io.IOException {
                /*
                    r11 = this;
                    r12 = 2048(0x800, float:2.87E-42)
                    byte[] r12 = new byte[r12]
                    java.io.File r0 = new java.io.File
                    java.lang.String r1 = r5
                    r0.<init>(r1)
                    boolean r1 = r0.exists()
                    if (r1 != 0) goto L_0x0014
                    r0.mkdirs()
                L_0x0014:
                    java.io.File r1 = new java.io.File
                    java.lang.String r2 = r6
                    r1.<init>(r0, r2)
                    r0 = 0
                    b.af r2 = r13.g     // Catch:{ Exception -> 0x009c, all -> 0x0098 }
                    java.io.InputStream r2 = r2.byteStream()     // Catch:{ Exception -> 0x009c, all -> 0x0098 }
                    b.af r13 = r13.g     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                    long r3 = r13.contentLength()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                    java.io.FileOutputStream r13 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                    r13.<init>(r1)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
                    r5 = 0
                L_0x002f:
                    int r0 = r2.read(r12)     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    r7 = -1
                    r8 = 0
                    if (r0 == r7) goto L_0x005c
                    r13.write(r12, r8, r0)     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    long r7 = (long) r0     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    long r9 = r5 + r7
                    com.cyjh.http.e.b r5 = com.cyjh.http.e.b.this     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    com.cyjh.http.e.b r6 = com.cyjh.http.e.b.this     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    int r6 = r6.f     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    int r6 = r6 + r0
                    int unused = r5.f = r6     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    float r0 = (float) r9     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    r5 = 1065353216(0x3f800000, float:1.0)
                    float r0 = r0 * r5
                    float r5 = (float) r3     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    float r0 = r0 / r5
                    r5 = 1120403456(0x42c80000, float:100.0)
                    float r0 = r0 * r5
                    int r0 = (int) r0     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    com.cyjh.http.e.b$a r5 = r8     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    r5.a((int) r0)     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    r5 = r9
                    goto L_0x002f
                L_0x005c:
                    r13.flush()     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    com.cyjh.http.e.b$a r12 = r8     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    r12.a((java.io.File) r1)     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    com.cyjh.http.e.b r12 = com.cyjh.http.e.b.this     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    int unused = r12.f = r8     // Catch:{ Exception -> 0x008f, all -> 0x008d }
                    if (r2 == 0) goto L_0x006e
                    r2.close()     // Catch:{ IOException -> 0x008c }
                L_0x006e:
                    r13.close()     // Catch:{ IOException -> 0x008c }
                    java.lang.String r12 = com.cyjh.http.e.b.f2524a     // Catch:{ IOException -> 0x008c }
                    java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x008c }
                    java.lang.String r0 = "download 3 --> downLoadLength="
                    r13.<init>(r0)     // Catch:{ IOException -> 0x008c }
                    com.cyjh.http.e.b r0 = com.cyjh.http.e.b.this     // Catch:{ IOException -> 0x008c }
                    int r0 = r0.f     // Catch:{ IOException -> 0x008c }
                    r13.append(r0)     // Catch:{ IOException -> 0x008c }
                    java.lang.String r13 = r13.toString()     // Catch:{ IOException -> 0x008c }
                    com.cyjh.common.util.ad.c(r12, r13)     // Catch:{ IOException -> 0x008c }
                L_0x008c:
                    return
                L_0x008d:
                    r12 = move-exception
                    goto L_0x00cb
                L_0x008f:
                    r12 = move-exception
                    goto L_0x0096
                L_0x0091:
                    r12 = move-exception
                    r13 = r0
                    goto L_0x00cb
                L_0x0094:
                    r12 = move-exception
                    r13 = r0
                L_0x0096:
                    r0 = r2
                    goto L_0x009e
                L_0x0098:
                    r12 = move-exception
                    r13 = r0
                    r2 = r13
                    goto L_0x00cb
                L_0x009c:
                    r12 = move-exception
                    r13 = r0
                L_0x009e:
                    com.cyjh.http.e.b$a r1 = r8     // Catch:{ all -> 0x00c9 }
                    r1.a((java.lang.Exception) r12)     // Catch:{ all -> 0x00c9 }
                    if (r0 == 0) goto L_0x00a8
                    r0.close()     // Catch:{ IOException -> 0x00c8 }
                L_0x00a8:
                    if (r13 == 0) goto L_0x00ad
                    r13.close()     // Catch:{ IOException -> 0x00c8 }
                L_0x00ad:
                    java.lang.String r12 = com.cyjh.http.e.b.f2524a     // Catch:{ IOException -> 0x00c8 }
                    java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c8 }
                    java.lang.String r0 = "download 3 --> downLoadLength="
                    r13.<init>(r0)     // Catch:{ IOException -> 0x00c8 }
                    com.cyjh.http.e.b r0 = com.cyjh.http.e.b.this     // Catch:{ IOException -> 0x00c8 }
                    int r0 = r0.f     // Catch:{ IOException -> 0x00c8 }
                    r13.append(r0)     // Catch:{ IOException -> 0x00c8 }
                    java.lang.String r13 = r13.toString()     // Catch:{ IOException -> 0x00c8 }
                    com.cyjh.common.util.ad.c(r12, r13)     // Catch:{ IOException -> 0x00c8 }
                L_0x00c8:
                    return
                L_0x00c9:
                    r12 = move-exception
                    r2 = r0
                L_0x00cb:
                    if (r2 == 0) goto L_0x00d0
                    r2.close()     // Catch:{ IOException -> 0x00f0 }
                L_0x00d0:
                    if (r13 == 0) goto L_0x00d5
                    r13.close()     // Catch:{ IOException -> 0x00f0 }
                L_0x00d5:
                    java.lang.String r13 = com.cyjh.http.e.b.f2524a     // Catch:{ IOException -> 0x00f0 }
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00f0 }
                    java.lang.String r1 = "download 3 --> downLoadLength="
                    r0.<init>(r1)     // Catch:{ IOException -> 0x00f0 }
                    com.cyjh.http.e.b r1 = com.cyjh.http.e.b.this     // Catch:{ IOException -> 0x00f0 }
                    int r1 = r1.f     // Catch:{ IOException -> 0x00f0 }
                    r0.append(r1)     // Catch:{ IOException -> 0x00f0 }
                    java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x00f0 }
                    com.cyjh.common.util.ad.c(r13, r0)     // Catch:{ IOException -> 0x00f0 }
                L_0x00f0:
                    throw r12
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cyjh.http.e.b.AnonymousClass2.a(b.e, b.ae):void");
            }

            public final void a(IOException iOException) {
                aVar.a((Exception) iOException);
            }
        });
    }
}
