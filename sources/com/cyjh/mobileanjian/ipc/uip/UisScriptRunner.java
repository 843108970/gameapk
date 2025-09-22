package com.cyjh.mobileanjian.ipc.uip;

import com.cyjh.mobileanjian.ipc.share.proto.UiMessage;
import com.cyjh.mqm.MQUipStub;

public class UisScriptRunner {

    /* renamed from: a  reason: collision with root package name */
    private static UisScriptRunner f2679a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static boolean f2680b = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public MQUipStub f2681c = new MQUipStub();

    private UisScriptRunner() {
    }

    private static void a() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static UisScriptRunner getInstance() {
        if (f2679a == null) {
            f2679a = new UisScriptRunner();
        }
        return f2679a;
    }

    public void startLoop(final String str, final String str2) {
        if (f2680b) {
            stopLoop();
            while (f2680b) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        new Thread() {
            public final void run() {
                super.run();
                boolean unused = UisScriptRunner.f2680b = true;
                UisScriptRunner.this.f2681c.StartLoop(str, 0, str2);
                boolean unused2 = UisScriptRunner.f2680b = false;
            }
        }.start();
    }

    public void stopLoop() {
        if (f2680b) {
            this.f2681c.StopLoop();
            UipEventStub.hasEvent(UiMessage.UipToCommand.newBuilder().setCommand(UiMessage.UipToCommand.Command_Type.EVENT).setIsSuccess(true).setEvent(UiMessage.ControlEvent.newBuilder().setControlId("stop_id").setType(UiMessage.ControlEvent.Event_Type.ON_CLOSE_EXIT).build()).build().toByteString());
        }
    }
}
