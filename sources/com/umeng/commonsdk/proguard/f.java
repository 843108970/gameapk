package com.umeng.commonsdk.proguard;

import java.io.PrintWriter;
import java.io.StringWriter;

public class f {
    public static String a(Throwable th) {
        if (th == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            while (true) {
                th.printStackTrace(printWriter);
                th = th.getCause();
                if (th == null) {
                    String obj = stringWriter.toString();
                    try {
                        printWriter.close();
                        stringWriter.close();
                        return obj;
                    } catch (Exception unused) {
                        return obj;
                    }
                }
            }
        } catch (Exception unused2) {
            return null;
        }
    }
}
