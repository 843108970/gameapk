package com.cyjh.mobileanjian.ipc.utils;

public class m {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2716a = "m";

    /* renamed from: b  reason: collision with root package name */
    public static final int f2717b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static final int f2718c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static final int f = 4;
    public static final int g = 5;
    public static final int h = 6;
    public static final int i = 7;

    private static String a(int i2) {
        return m.class.getFields()[i2].getName();
    }

    private static void b(int i2) {
        StringBuilder sb = new StringBuilder("errno=");
        sb.append(i2);
        sb.append("; ");
        sb.append(m.class.getFields()[i2].getName());
    }
}
