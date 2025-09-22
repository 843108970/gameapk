package com.a.a.a;

import android.support.annotation.NonNull;
import java.util.List;

public final class a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f456a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f457b;

    /* renamed from: c  reason: collision with root package name */
    public final int f458c;

    public a(@NonNull List<String> list, @NonNull List<String> list2, int i) {
        this.f456a = list;
        this.f457b = list2;
        this.f458c = i;
    }

    public final String a() {
        List<String> list = this.f456a;
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            String str = "";
            for (String append : list) {
                sb.append(str);
                sb.append(append);
                str = "\n";
            }
        }
        return sb.toString();
    }

    public final String toString() {
        return a();
    }
}
