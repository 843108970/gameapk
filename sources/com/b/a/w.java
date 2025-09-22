package com.b.a;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

final class w implements v {
    w() {
    }

    public final List<InetAddress> a(String str) {
        if (str != null) {
            return Arrays.asList(InetAddress.getAllByName(str));
        }
        throw new UnknownHostException("hostname == null");
    }
}
