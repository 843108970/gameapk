package com.cyjh.mobileanjian.ipc.uip;

import android.os.Handler;
import android.os.Process;
import com.google.protobuf.ByteString;
import java.util.concurrent.ArrayBlockingQueue;

public class UipEventStub {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f2671a;

    /* renamed from: b  reason: collision with root package name */
    private static ArrayBlockingQueue<ByteString> f2672b = new ArrayBlockingQueue<>(1);

    /* renamed from: c  reason: collision with root package name */
    private static ArrayBlockingQueue<ByteString> f2673c = new ArrayBlockingQueue<>(256);

    public static byte[] GetUiEvent() {
        if (!a()) {
            return null;
        }
        try {
            return f2673c.take().toByteArray();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] SendUiRequest(byte[] bArr) {
        if (!a()) {
            return null;
        }
        f2671a.obtainMessage(0, ByteString.copyFrom(bArr)).sendToTarget();
        try {
            return f2672b.take().toByteArray();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void UiRequestReturn(ByteString byteString) {
        try {
            f2672b.put(byteString);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static boolean a() {
        return (Process.myUid() == 0 || Process.myUid() == 2000) ? false : true;
    }

    public static void clear() {
        f2673c.clear();
    }

    public static void hasEvent(ByteString byteString) {
        try {
            if (f2673c.size() < 256) {
                f2673c.put(byteString);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void registerHandler(Handler handler) {
        f2671a = handler;
    }
}
