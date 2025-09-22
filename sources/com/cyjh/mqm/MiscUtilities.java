package com.cyjh.mqm;

public class MiscUtilities {
    static {
        System.loadLibrary("mqm");
    }

    public native String LoadUIFile(String str, boolean z);
}
