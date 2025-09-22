package com.b.a;

import java.util.Arrays;
import java.util.Collections;

public final class aa {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f747a;

    aa(ab abVar) {
        this.f747a = (String[]) abVar.f748a.toArray(new String[abVar.f748a.size()]);
    }

    public final int a() {
        return this.f747a.length / 2;
    }

    public final String a(int i) {
        return this.f747a[i * 2];
    }

    public final String a(String str) {
        String[] strArr = this.f747a;
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public final ab b() {
        ab abVar = new ab();
        Collections.addAll(abVar.f748a, this.f747a);
        return abVar;
    }

    public final String b(int i) {
        return this.f747a[(i * 2) + 1];
    }

    public final boolean equals(Object obj) {
        return (obj instanceof aa) && Arrays.equals(((aa) obj).f747a, this.f747a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f747a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int length = this.f747a.length / 2;
        for (int i = 0; i < length; i++) {
            sb.append(a(i));
            sb.append(": ");
            sb.append(b(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}
