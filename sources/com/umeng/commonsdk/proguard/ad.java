package com.umeng.commonsdk.proguard;

import com.umeng.commonsdk.proguard.at;
import java.nio.ByteBuffer;

public class ad {

    /* renamed from: a  reason: collision with root package name */
    private final az f3687a;

    /* renamed from: b  reason: collision with root package name */
    private final bm f3688b;

    public ad() {
        this(new at.a());
    }

    public ad(bb bbVar) {
        this.f3688b = new bm();
        this.f3687a = bbVar.a(this.f3688b);
    }

    private Object a(byte b2, byte[] bArr, ah ahVar, ah... ahVarArr) throws ag {
        try {
            au j = j(bArr, ahVar, ahVarArr);
            if (j != null) {
                if (b2 != 6) {
                    if (b2 != 8) {
                        if (b2 != 100) {
                            switch (b2) {
                                case 2:
                                    if (j.f3725b == 2) {
                                        Boolean valueOf = Boolean.valueOf(this.f3687a.t());
                                        this.f3688b.e();
                                        this.f3687a.B();
                                        return valueOf;
                                    }
                                    break;
                                case 3:
                                    if (j.f3725b == 3) {
                                        Byte valueOf2 = Byte.valueOf(this.f3687a.u());
                                        this.f3688b.e();
                                        this.f3687a.B();
                                        return valueOf2;
                                    }
                                    break;
                                case 4:
                                    if (j.f3725b == 4) {
                                        Double valueOf3 = Double.valueOf(this.f3687a.y());
                                        this.f3688b.e();
                                        this.f3687a.B();
                                        return valueOf3;
                                    }
                                    break;
                                default:
                                    switch (b2) {
                                        case 10:
                                            if (j.f3725b == 10) {
                                                Long valueOf4 = Long.valueOf(this.f3687a.x());
                                                this.f3688b.e();
                                                this.f3687a.B();
                                                return valueOf4;
                                            }
                                            break;
                                        case 11:
                                            if (j.f3725b == 11) {
                                                String z = this.f3687a.z();
                                                this.f3688b.e();
                                                this.f3687a.B();
                                                return z;
                                            }
                                            break;
                                    }
                            }
                        } else if (j.f3725b == 11) {
                            ByteBuffer A = this.f3687a.A();
                            this.f3688b.e();
                            this.f3687a.B();
                            return A;
                        }
                    } else if (j.f3725b == 8) {
                        Integer valueOf5 = Integer.valueOf(this.f3687a.w());
                        this.f3688b.e();
                        this.f3687a.B();
                        return valueOf5;
                    }
                } else if (j.f3725b == 6) {
                    Short valueOf6 = Short.valueOf(this.f3687a.v());
                    this.f3688b.e();
                    this.f3687a.B();
                    return valueOf6;
                }
            }
            this.f3688b.e();
            this.f3687a.B();
            return null;
        } catch (Exception e) {
            throw new ag((Throwable) e);
        } catch (Throwable th) {
            this.f3688b.e();
            this.f3687a.B();
            throw th;
        }
    }

    private au j(byte[] bArr, ah ahVar, ah... ahVarArr) throws ag {
        this.f3688b.a(bArr);
        ah[] ahVarArr2 = new ah[(ahVarArr.length + 1)];
        int i = 0;
        ahVarArr2[0] = ahVar;
        int i2 = 0;
        while (i2 < ahVarArr.length) {
            int i3 = i2 + 1;
            ahVarArr2[i3] = ahVarArr[i2];
            i2 = i3;
        }
        this.f3687a.j();
        au auVar = null;
        while (i < ahVarArr2.length) {
            auVar = this.f3687a.l();
            if (auVar.f3725b == 0 || auVar.f3726c > ahVarArr2[i].a()) {
                return null;
            }
            if (auVar.f3726c != ahVarArr2[i].a()) {
                bc.a(this.f3687a, auVar.f3725b);
                this.f3687a.m();
            } else {
                i++;
                if (i < ahVarArr2.length) {
                    this.f3687a.j();
                }
            }
        }
        return auVar;
    }

    public Boolean a(byte[] bArr, ah ahVar, ah... ahVarArr) throws ag {
        return (Boolean) a((byte) 2, bArr, ahVar, ahVarArr);
    }

    public void a(aa aaVar, String str) throws ag {
        a(aaVar, str.getBytes());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:5|6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0022, code lost:
        throw new com.umeng.commonsdk.proguard.ag("JVM DOES NOT SUPPORT ENCODING: " + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        r1.f3687a.B();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        throw r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.umeng.commonsdk.proguard.aa r2, java.lang.String r3, java.lang.String r4) throws com.umeng.commonsdk.proguard.ag {
        /*
            r1 = this;
            byte[] r3 = r3.getBytes(r4)     // Catch:{ UnsupportedEncodingException -> 0x000f }
            r1.a((com.umeng.commonsdk.proguard.aa) r2, (byte[]) r3)     // Catch:{ UnsupportedEncodingException -> 0x000f }
            com.umeng.commonsdk.proguard.az r2 = r1.f3687a
            r2.B()
            return
        L_0x000d:
            r2 = move-exception
            goto L_0x0023
        L_0x000f:
            com.umeng.commonsdk.proguard.ag r2 = new com.umeng.commonsdk.proguard.ag     // Catch:{ all -> 0x000d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x000d }
            java.lang.String r0 = "JVM DOES NOT SUPPORT ENCODING: "
            r3.<init>(r0)     // Catch:{ all -> 0x000d }
            r3.append(r4)     // Catch:{ all -> 0x000d }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x000d }
            r2.<init>((java.lang.String) r3)     // Catch:{ all -> 0x000d }
            throw r2     // Catch:{ all -> 0x000d }
        L_0x0023:
            com.umeng.commonsdk.proguard.az r3 = r1.f3687a
            r3.B()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.proguard.ad.a(com.umeng.commonsdk.proguard.aa, java.lang.String, java.lang.String):void");
    }

    public void a(aa aaVar, byte[] bArr) throws ag {
        try {
            this.f3688b.a(bArr);
            aaVar.read(this.f3687a);
        } finally {
            this.f3688b.e();
            this.f3687a.B();
        }
    }

    public void a(aa aaVar, byte[] bArr, ah ahVar, ah... ahVarArr) throws ag {
        try {
            if (j(bArr, ahVar, ahVarArr) != null) {
                aaVar.read(this.f3687a);
            }
            this.f3688b.e();
            this.f3687a.B();
        } catch (Exception e) {
            throw new ag((Throwable) e);
        } catch (Throwable th) {
            this.f3688b.e();
            this.f3687a.B();
            throw th;
        }
    }

    public Byte b(byte[] bArr, ah ahVar, ah... ahVarArr) throws ag {
        return (Byte) a((byte) 3, bArr, ahVar, ahVarArr);
    }

    public Double c(byte[] bArr, ah ahVar, ah... ahVarArr) throws ag {
        return (Double) a((byte) 4, bArr, ahVar, ahVarArr);
    }

    public Short d(byte[] bArr, ah ahVar, ah... ahVarArr) throws ag {
        return (Short) a((byte) 6, bArr, ahVar, ahVarArr);
    }

    public Integer e(byte[] bArr, ah ahVar, ah... ahVarArr) throws ag {
        return (Integer) a((byte) 8, bArr, ahVar, ahVarArr);
    }

    public Long f(byte[] bArr, ah ahVar, ah... ahVarArr) throws ag {
        return (Long) a((byte) 10, bArr, ahVar, ahVarArr);
    }

    public String g(byte[] bArr, ah ahVar, ah... ahVarArr) throws ag {
        return (String) a((byte) 11, bArr, ahVar, ahVarArr);
    }

    public ByteBuffer h(byte[] bArr, ah ahVar, ah... ahVarArr) throws ag {
        return (ByteBuffer) a((byte) 100, bArr, ahVar, ahVarArr);
    }

    public Short i(byte[] bArr, ah ahVar, ah... ahVarArr) throws ag {
        try {
            if (j(bArr, ahVar, ahVarArr) != null) {
                this.f3687a.j();
                Short valueOf = Short.valueOf(this.f3687a.l().f3726c);
                this.f3688b.e();
                this.f3687a.B();
                return valueOf;
            }
            this.f3688b.e();
            this.f3687a.B();
            return null;
        } catch (Exception e) {
            throw new ag((Throwable) e);
        } catch (Throwable th) {
            this.f3688b.e();
            this.f3687a.B();
            throw th;
        }
    }
}
