package com.google.a.h.a;

import com.google.a.t;

final class h extends g {

    /* renamed from: c  reason: collision with root package name */
    final boolean f3261c;

    h(c cVar, boolean z) {
        super(cVar);
        this.f3261c = z;
    }

    private void a(a aVar) {
        d[] dVarArr = this.f3260b;
        for (d dVar : this.f3260b) {
            if (dVar != null) {
                dVar.b();
            }
        }
        a(dVarArr, aVar);
        c cVar = this.f3259a;
        t tVar = this.f3261c ? cVar.f3246b : cVar.d;
        t tVar2 = this.f3261c ? cVar.f3247c : cVar.e;
        int b2 = b((int) tVar.f3357b);
        int b3 = b((int) tVar2.f3357b);
        int i = -1;
        int i2 = 0;
        int i3 = 1;
        while (b2 < b3) {
            if (dVarArr[b2] != null) {
                d dVar2 = dVarArr[b2];
                int i4 = dVar2.e - i;
                if (i4 == 0) {
                    i2++;
                } else {
                    if (i4 == 1) {
                        i3 = Math.max(i3, i2);
                        i = dVar2.e;
                    } else if (i4 < 0 || dVar2.e >= aVar.e || i4 > b2) {
                        dVarArr[b2] = null;
                    } else {
                        if (i3 > 2) {
                            i4 *= i3 - 2;
                        }
                        boolean z = i4 >= b2;
                        for (int i5 = 1; i5 <= i4 && !z; i5++) {
                            z = dVarArr[b2 - i5] != null;
                        }
                        if (z) {
                            dVarArr[b2] = null;
                        } else {
                            i = dVar2.e;
                        }
                    }
                    i2 = 1;
                }
            }
            b2++;
        }
    }

    private void b() {
        for (d dVar : this.f3260b) {
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    private void b(a aVar) {
        c cVar = this.f3259a;
        t tVar = this.f3261c ? cVar.f3246b : cVar.d;
        t tVar2 = this.f3261c ? cVar.f3247c : cVar.e;
        int b2 = b((int) tVar2.f3357b);
        d[] dVarArr = this.f3260b;
        int i = -1;
        int i2 = 0;
        int i3 = 1;
        for (int b3 = b((int) tVar.f3357b); b3 < b2; b3++) {
            if (dVarArr[b3] != null) {
                d dVar = dVarArr[b3];
                dVar.b();
                int i4 = dVar.e - i;
                if (i4 == 0) {
                    i2++;
                } else {
                    if (i4 == 1) {
                        i3 = Math.max(i3, i2);
                        i = dVar.e;
                    } else if (dVar.e >= aVar.e) {
                        dVarArr[b3] = null;
                    } else {
                        i = dVar.e;
                    }
                    i2 = 1;
                }
            }
        }
    }

    private int[] c() {
        int i;
        a a2 = a();
        if (a2 == null) {
            return null;
        }
        c cVar = this.f3259a;
        t tVar = this.f3261c ? cVar.f3246b : cVar.d;
        int b2 = b((int) (this.f3261c ? cVar.f3247c : cVar.e).f3357b);
        d[] dVarArr = this.f3260b;
        int i2 = -1;
        int i3 = 0;
        int i4 = 1;
        for (int b3 = b((int) tVar.f3357b); b3 < b2; b3++) {
            if (dVarArr[b3] != null) {
                d dVar = dVarArr[b3];
                dVar.b();
                int i5 = dVar.e - i2;
                if (i5 == 0) {
                    i3++;
                } else {
                    if (i5 == 1) {
                        i4 = Math.max(i4, i3);
                        i2 = dVar.e;
                    } else if (dVar.e >= a2.e) {
                        dVarArr[b3] = null;
                    } else {
                        i2 = dVar.e;
                    }
                    i3 = 1;
                }
            }
        }
        int[] iArr = new int[a2.e];
        for (d dVar2 : this.f3260b) {
            if (dVar2 != null && (i = dVar2.e) < iArr.length) {
                iArr[i] = iArr[i] + 1;
            }
        }
        return iArr;
    }

    private boolean d() {
        return this.f3261c;
    }

    /* access modifiers changed from: package-private */
    public final a a() {
        d[] dVarArr = this.f3260b;
        b bVar = new b();
        b bVar2 = new b();
        b bVar3 = new b();
        b bVar4 = new b();
        for (d dVar : dVarArr) {
            if (dVar != null) {
                dVar.b();
                int i = dVar.d % 30;
                int i2 = dVar.e;
                if (!this.f3261c) {
                    i2 += 2;
                }
                switch (i2 % 3) {
                    case 0:
                        bVar2.a((i * 3) + 1);
                        break;
                    case 1:
                        bVar4.a(i / 3);
                        bVar3.a(i % 3);
                        break;
                    case 2:
                        bVar.a(i + 1);
                        break;
                }
            }
        }
        if (bVar.a().length == 0 || bVar2.a().length == 0 || bVar3.a().length == 0 || bVar4.a().length == 0 || bVar.a()[0] <= 0 || bVar2.a()[0] + bVar3.a()[0] < 3 || bVar2.a()[0] + bVar3.a()[0] > 90) {
            return null;
        }
        a aVar = new a(bVar.a()[0], bVar2.a()[0], bVar3.a()[0], bVar4.a()[0]);
        a(dVarArr, aVar);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(d[] dVarArr, a aVar) {
        for (int i = 0; i < dVarArr.length; i++) {
            d dVar = dVarArr[i];
            if (dVarArr[i] != null) {
                int i2 = dVar.d % 30;
                int i3 = dVar.e;
                if (i3 <= aVar.e) {
                    if (!this.f3261c) {
                        i3 += 2;
                    }
                    switch (i3 % 3) {
                        case 0:
                            if ((i2 * 3) + 1 == aVar.f3237c) {
                                break;
                            } else {
                                dVarArr[i] = null;
                                break;
                            }
                        case 1:
                            if (i2 / 3 != aVar.f3236b || i2 % 3 != aVar.d) {
                                dVarArr[i] = null;
                                break;
                            } else {
                                break;
                            }
                            break;
                        case 2:
                            if (i2 + 1 == aVar.f3235a) {
                                break;
                            } else {
                                dVarArr[i] = null;
                                break;
                            }
                    }
                } else {
                    dVarArr[i] = null;
                }
            }
        }
    }

    public final String toString() {
        return "IsLeft: " + this.f3261c + 10 + super.toString();
    }
}
