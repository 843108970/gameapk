package com.cyjh.mq.sdk.inf;

import com.cyjh.mobileanjian.ipc.interfaces.OnRequestCallback;
import com.google.protobuf.ByteString;

public interface c {
    OnRequestCallback a();

    void a(ByteString byteString);

    OnElfCallback b();

    void b(ByteString byteString);

    void c(ByteString byteString);

    void c(String str);
}
