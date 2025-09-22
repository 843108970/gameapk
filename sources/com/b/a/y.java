package com.b.a;

import java.util.ArrayList;
import java.util.List;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f839a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f840b = new ArrayList();

    public final x a() {
        return new x(this.f839a, this.f840b);
    }

    public final y a(String str, String str2) {
        this.f839a.add(ac.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
        this.f840b.add(ac.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
        return this;
    }
}
