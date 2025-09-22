package com.cyjh.mobileanjian.ipc.utils;

import com.cyjh.mobileanjian.ipc.share.proto.Ipc;
import java.util.HashMap;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, Ipc.FundType> f2715a = new HashMap<String, Ipc.FundType>() {
        {
            put("void", Ipc.FundType.VOID);
            put("boolean", Ipc.FundType.BOOLEAN);
            put("int", Ipc.FundType.INT);
            put("long", Ipc.FundType.LONG);
            put("float", Ipc.FundType.FLOAT);
            put("double", Ipc.FundType.DOUBLE);
            put("String", Ipc.FundType.STRING);
        }
    };

    public static Ipc.FundType a(String str) {
        return p.a(str) ? Ipc.FundType.VOID : f2715a.get(str);
    }
}
