package com.cyjh.mobileanjian.ipc.interfaces;

import com.google.protobuf.ByteString;

public interface OnScriptMessageCallback {
    void onDebugMessage(ByteString byteString);

    void onTracePrint(String str);
}
