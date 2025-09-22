package org.litepal.f;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.litepal.b.c.a;
import org.litepal.f.b.b;
import org.litepal.f.b.d;
import org.litepal.g.c;

public final class h extends b {
    protected d h;
    protected d i;
    private boolean j;

    private String a(b bVar) {
        return a(this.h.f4821a, bVar);
    }

    private List<String> b(List<b> list) {
        ArrayList arrayList = new ArrayList();
        for (b a2 : list) {
            arrayList.add(a(this.h.f4821a, a2));
        }
        return arrayList;
    }

    private void c() {
        boolean z;
        b bVar;
        Iterator<b> it = this.h.f4822b.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            b next = it.next();
            d dVar = this.i;
            String str = next.f4815a;
            Iterator<b> it2 = dVar.f4822b.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    bVar = null;
                    break;
                }
                bVar = it2.next();
                if (bVar.f4815a.equalsIgnoreCase(str)) {
                    break;
                }
            }
            if ((!next.d || (bVar != null && bVar.d)) && (bVar == null || next.f4817c || !bVar.f4817c)) {
            }
        }
        z = true;
        if (z) {
            a(this.h, this.e, true);
            for (a next2 : b(this.h.f4823c)) {
                if ((next2.f == 2 || next2.f == 1) && next2.f4697c.equalsIgnoreCase(this.h.f4823c)) {
                    a(this.h.f4821a, c.a(next2.f4696b), this.h.f4821a, this.e);
                }
            }
            return;
        }
        this.j = false;
        String str2 = this.h.f4821a;
        ArrayList arrayList = new ArrayList();
        for (b bVar2 : this.i.f4822b) {
            String str3 = bVar2.f4815a;
            if ((this.h.b(str3) ^ true) && !e(str3) && !a(this.h, str3)) {
                arrayList.add(str3);
            }
        }
        org.litepal.g.d.a(b.d, "remove columns from " + str2 + " >> " + arrayList);
        c(arrayList);
        d(e());
        e(g());
        if (this.j) {
            org.litepal.g.d.a(b.d, "do changeColumnsConstraints");
            b(i(), this.e);
        }
    }

    private void c(List<String> list) {
        org.litepal.g.d.a(b.d, "do removeColumns " + list);
        a((Collection<String>) list, this.h.f4821a);
        for (String a2 : list) {
            this.i.a(a2);
        }
    }

    private void d(List<b> list) {
        org.litepal.g.d.a(b.d, "do addColumn");
        ArrayList arrayList = new ArrayList();
        for (b a2 : list) {
            arrayList.add(a(this.h.f4821a, a2));
        }
        b((List<String>) arrayList, this.e);
        for (b a3 : list) {
            this.i.a(a3);
        }
    }

    private boolean d() {
        b bVar;
        for (b next : this.h.f4822b) {
            d dVar = this.i;
            String str = next.f4815a;
            Iterator<b> it = dVar.f4822b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bVar = null;
                    break;
                }
                bVar = it.next();
                if (bVar.f4815a.equalsIgnoreCase(str)) {
                    break;
                }
            }
            if (next.d && (bVar == null || !bVar.d)) {
                return true;
            }
            if (bVar != null && !next.f4817c && bVar.f4817c) {
                return true;
            }
        }
        return false;
    }

    private List<b> e() {
        ArrayList arrayList = new ArrayList();
        for (b next : this.h.f4822b) {
            if (!this.i.b(next.f4815a)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private void e(List<b> list) {
        org.litepal.g.d.a(b.d, "do changeColumnsType");
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (b bVar : list) {
                arrayList.add(bVar.f4815a);
            }
        }
        c(arrayList);
        d(list);
    }

    private List<String> f() {
        String str = this.h.f4821a;
        ArrayList arrayList = new ArrayList();
        for (b bVar : this.i.f4822b) {
            String str2 = bVar.f4815a;
            boolean z = true;
            if (!(!this.h.b(str2)) || e(str2) || a(this.h, str2)) {
                z = false;
            }
            if (z) {
                arrayList.add(str2);
            }
        }
        org.litepal.g.d.a(b.d, "remove columns from " + str + " >> " + arrayList);
        return arrayList;
    }

    private List<b> g() {
        ArrayList arrayList = new ArrayList();
        for (b next : this.i.f4822b) {
            for (b next2 : this.h.f4822b) {
                if (next.f4815a.equalsIgnoreCase(next2.f4815a)) {
                    if (!next.f4816b.equalsIgnoreCase(next2.f4816b) && (!next2.f4816b.equalsIgnoreCase("blob") || !TextUtils.isEmpty(next.f4816b))) {
                        arrayList.add(next2);
                    }
                    if (!this.j) {
                        org.litepal.g.d.a(b.d, "default value db is:" + next.e + ", default value is:" + next2.e);
                        if (next.f4817c != next2.f4817c || !next.e.equalsIgnoreCase(next2.e) || (next.d && !next2.d)) {
                            this.j = true;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private void h() {
        if (this.j) {
            org.litepal.g.d.a(b.d, "do changeColumnsConstraints");
            String i2 = i(this.h.f4821a);
            String c2 = c(this.h);
            ArrayList arrayList = new ArrayList();
            for (String next : a(this.h)) {
                if (!this.h.b(next)) {
                    b bVar = new b();
                    bVar.f4815a = next;
                    bVar.f4816b = "integer";
                    arrayList.add(a(this.h.f4821a, bVar));
                }
            }
            String b2 = b(this.i);
            String j2 = j(this.h.f4821a);
            ArrayList<String> arrayList2 = new ArrayList<>();
            arrayList2.add(i2);
            arrayList2.add(c2);
            arrayList2.addAll(arrayList);
            arrayList2.add(b2);
            arrayList2.add(j2);
            org.litepal.g.d.a(b.d, "generateChangeConstraintSQL >> ");
            for (String a2 : arrayList2) {
                org.litepal.g.d.a(b.d, a2);
            }
            org.litepal.g.d.a(b.d, "<< generateChangeConstraintSQL");
            b((List<String>) arrayList2, this.e);
        }
    }

    private List<String> i() {
        String i2 = i(this.h.f4821a);
        String c2 = c(this.h);
        ArrayList arrayList = new ArrayList();
        for (String next : a(this.h)) {
            if (!this.h.b(next)) {
                b bVar = new b();
                bVar.f4815a = next;
                bVar.f4816b = "integer";
                arrayList.add(a(this.h.f4821a, bVar));
            }
        }
        String b2 = b(this.i);
        String j2 = j(this.h.f4821a);
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add(i2);
        arrayList2.add(c2);
        arrayList2.addAll(arrayList);
        arrayList2.add(b2);
        arrayList2.add(j2);
        org.litepal.g.d.a(b.d, "generateChangeConstraintSQL >> ");
        for (String a2 : arrayList2) {
            org.litepal.g.d.a(b.d, a2);
        }
        org.litepal.g.d.a(b.d, "<< generateChangeConstraintSQL");
        return arrayList2;
    }

    private List<String> j() {
        ArrayList arrayList = new ArrayList();
        for (String next : a(this.h)) {
            if (!this.h.b(next)) {
                b bVar = new b();
                bVar.f4815a = next;
                bVar.f4816b = "integer";
                arrayList.add(a(this.h.f4821a, bVar));
            }
        }
        return arrayList;
    }

    private boolean k(String str) {
        return (this.h.b(str) ^ true) && !e(str) && !a(this.h, str);
    }

    private boolean l(String str) {
        return !this.h.b(str);
    }

    /* access modifiers changed from: protected */
    public final void a(SQLiteDatabase sQLiteDatabase, boolean z) {
        this.e = sQLiteDatabase;
        for (d next : a()) {
            this.h = next;
            this.i = h(next.f4821a);
            org.litepal.g.d.a(b.d, "createOrUpgradeTable: model is " + this.h.f4821a);
            c();
        }
    }
}
