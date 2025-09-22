package com.goldcoast.sdk.domain;

import android.annotation.TargetApi;
import android.util.Pair;
import com.a.a.a.a;
import com.a.a.a.b;
import com.goldcoast.sdk.a.d;
import com.goldcoast.sdk.c.g;
import java.io.File;

final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f2971a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ EntryPoint f2972b;

    j(EntryPoint entryPoint, d dVar) {
        this.f2972b = entryPoint;
        this.f2971a = dVar;
    }

    @TargetApi(5)
    public final void run() {
        boolean unused = this.f2972b.D = true;
        if (this.f2972b.F != null) {
            Pair unused2 = this.f2972b.F = null;
        }
        EntryPoint.f(this.f2972b);
        g.a();
        g.b("######\n" + String.format("In <<<<<< %d  >>>>>> \n", new Object[]{Integer.valueOf(this.f2972b.s)}));
        this.f2972b.b(String.format("正在计算第  <%d>  个$$$方案 请等待...", new Object[]{Integer.valueOf(this.f2972b.s)}), 2);
        this.f2972b.b(String.format("key:%s\norder:%d name: %s", new Object[]{this.f2971a.e(), Integer.valueOf(this.f2971a.d()), this.f2971a.a()}), 2);
        StringBuilder sb = new StringBuilder();
        this.f2971a.b(this.f2971a.b().replace("\n", ""));
        try {
            a a2 = b.a("sh", String.format("%s %d %s\n", new Object[]{EntryPoint.a(this.f2971a.a(), this.f2971a.c()), 2, this.f2971a.b()}));
            g.a();
            g.a(a2.a());
            Thread.sleep(6000);
        } catch (Exception e) {
            this.f2972b.b(String.format("A9DDDF2A4F7D94594EC2EA98407A410E1 exception: %s", new Object[]{e.getMessage()}), 2);
        }
        File file = new File(EntryPoint.extractDir.getAbsolutePath() + File.separator + this.f2971a.a());
        if (file.exists() && file.delete()) {
            g.a();
            g.a("delete file");
        }
        Pair unused3 = this.f2972b.F = new Pair("no", sb.toString());
        boolean unused4 = this.f2972b.D = false;
        boolean unused5 = this.f2972b.C = false;
    }
}
