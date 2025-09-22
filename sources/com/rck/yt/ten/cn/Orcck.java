package com.rck.yt.ten.cn;

public class Orcck {
    static {
        System.loadLibrary("orcck");
    }

    public static native void init();

    public static native void test();
}
