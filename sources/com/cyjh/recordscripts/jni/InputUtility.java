package com.cyjh.recordscripts.jni;

public class InputUtility {
    public native void Cancel();

    public native void CloseInput();

    public native int GetInput(int[] iArr);
}
