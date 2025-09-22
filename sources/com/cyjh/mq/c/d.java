package com.cyjh.mq.c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.FileUtils;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.view.inputmethod.InputConnection;
import android.widget.Toast;
import com.cyjh.event.Injector;
import com.cyjh.mobileanjian.ipc.a;
import com.cyjh.mobileanjian.ipc.interfaces.OnKeyEventListener;
import com.cyjh.mobileanjian.ipc.interfaces.OnRecordScriptCallback;
import com.cyjh.mobileanjian.ipc.interfaces.OnScreenShotCallback;
import com.cyjh.mobileanjian.ipc.interfaces.OnScriptMessageCallback;
import com.cyjh.mobileanjian.ipc.interfaces.OnUiElementCallback;
import com.cyjh.mobileanjian.ipc.rpc.Invocator;
import com.cyjh.mobileanjian.ipc.share.proto.Ipc;
import com.cyjh.mobileanjian.ipc.share.proto.UiMessage;
import com.cyjh.mobileanjian.ipc.ui.b;
import com.cyjh.mobileanjian.ipc.ui.c;
import com.cyjh.mobileanjian.ipc.ui.h;
import com.cyjh.mobileanjian.ipc.ui.j;
import com.cyjh.mobileanjian.ipc.view.ExToast;
import com.cyjh.mq.b.a;
import com.cyjh.mqsdk.R;
import com.google.a.g;
import com.google.a.i.a.f;
import com.google.a.w;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UninitializedMessageException;
import com.googlecode.tesseract.android.TessBaseAPI;
import com.ime.input.InputKb;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.UUID;

public final class d {
    private static final int h = 1;
    private static final int i = 2;
    private static final int j = 3;
    private static final int k = 4;
    private static final int l = 5;
    private static final int m = 10;
    private static final int n = 6;
    private static final int o = 7;
    private static final int p = 8;
    private static final int q = 9;
    private static final int r = 16;
    private static final int s = 17;
    private static final int t = 18;
    private static final int u = 19;
    private static final int v = 20;
    private static final int w = 21;
    private static final int x = 22;
    private static final int y = 23;
    private static final int z = 24;
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public Context f2768a;

    /* renamed from: b  reason: collision with root package name */
    a f2769b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public b f2770c = null;
    /* access modifiers changed from: package-private */
    public h d;
    Handler e = new Handler(Looper.getMainLooper()) {

        /* renamed from: b  reason: collision with root package name */
        private ExToast f2772b = null;

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            switch (i) {
                case 1:
                    if (this.f2772b == null) {
                        this.f2772b = new ExToast(d.this.f2768a);
                    }
                    Ipc.IpcMessage ipcMessage = (Ipc.IpcMessage) message.obj;
                    this.f2772b.show(ipcMessage.getArg2(0), ipcMessage.getArg1(0), ipcMessage.getArg1(1), ipcMessage.getArg1(2));
                    return;
                case 2:
                    if (d.this.f2770c.k != null) {
                        d.this.f2770c.k.onStartScript();
                    }
                    if (d.this.f2770c.l != null) {
                        d.this.f2770c.l.onStartScript();
                        return;
                    }
                    return;
                case 3:
                    Log.d("JAVA_RUNNER", "ScriptRunnerLite WHAT_STOP SCRIPT_STOPPED");
                    h hVar = d.this.d;
                    hVar.f.clear();
                    hVar.g.clear();
                    hVar.h.clear();
                    hVar.a();
                    hVar.f2622b = 0;
                    hVar.i = 1;
                    for (int i2 = 0; i2 < 32; i2++) {
                        hVar.f2621a[i2] = null;
                        if (hVar.f2623c[i2] != null) {
                            hVar.f2623c[i2].clear();
                        }
                    }
                    hVar.d = new j[32];
                    hVar.e = 0;
                    if (this.f2772b != null) {
                        this.f2772b.hide();
                    }
                    if (d.this.f2770c.k != null) {
                        Log.d("JAVA_RUNNER", "ScriptRunnerLite WHAT_STOP mConnection.getBasicScriptListener()");
                        d.this.f2770c.k.onStopScript(message.arg1, (String) message.obj);
                    }
                    if (d.this.f2770c.l != null) {
                        Log.d("JAVA_RUNNER", "ScriptRunnerLite WHAT_STOP mConnection.getOnScriptListener() != null");
                        d.this.f2770c.l.onStopScript(message.arg1, (String) message.obj);
                        return;
                    }
                    return;
                case 4:
                    if (d.this.f2770c.k != null) {
                        d.this.f2770c.k.onScriptIsRunning();
                    }
                    if (d.this.f2770c.l != null) {
                        d.this.f2770c.l.onScriptIsRunning();
                        return;
                    }
                    return;
                case 5:
                    if (message.obj == null) {
                        Toast.makeText(d.this.f2768a, message.arg1, 0).show();
                        return;
                    } else {
                        Toast.makeText(d.this.f2768a, (CharSequence) message.obj, 0).show();
                        return;
                    }
                case 6:
                    Ipc.IpcMessage ipcMessage2 = (Ipc.IpcMessage) message.obj;
                    String arg2 = ipcMessage2.getArg2(0);
                    int arg1 = ipcMessage2.getArg1(0);
                    ipcMessage2.getArg1(0);
                    ipcMessage2.getArg1(0);
                    new b(d.this.f2768a, arg2, arg1, new b.a() {
                        public final void a(int i) {
                            d.this.f2770c.a(Ipc.IpcMessage.newBuilder().setCmd(66).addArg1(i).build());
                        }
                    }).a();
                    return;
                case 7:
                    Ipc.IpcMessage ipcMessage3 = (Ipc.IpcMessage) message.obj;
                    String arg22 = ipcMessage3.getArg2(0);
                    ipcMessage3.getArg1(0);
                    ipcMessage3.getArg1(0);
                    new c(d.this.f2768a, arg22, new c.a() {
                        public final void a(String str) {
                            d.this.f2770c.a(Ipc.IpcMessage.newBuilder().setCmd(67).addArg2(str).build());
                        }
                    }).a();
                    return;
                case 8:
                    if (d.this.f2770c.k != null) {
                        d.this.f2770c.k.onPause();
                    }
                    if (d.this.f2770c.l != null) {
                        d.this.f2770c.l.onPause();
                        return;
                    }
                    return;
                case 9:
                    if (d.this.f2770c.k != null) {
                        d.this.f2770c.k.onResume();
                    }
                    if (d.this.f2770c.l != null) {
                        d.this.f2770c.l.onResume();
                        return;
                    }
                    return;
                case 10:
                    if (this.f2772b != null) {
                        this.f2772b.hide();
                        return;
                    }
                    return;
                default:
                    switch (i) {
                        case 16:
                            if (d.this.f2770c.l != null) {
                                d.this.f2770c.l.onUpdateControlBarPos(((float) message.arg1) / 100.0f, message.arg2, ((Integer) message.obj).intValue());
                                return;
                            }
                            return;
                        case 17:
                            OnKeyEventListener onKeyEventListener = com.cyjh.mq.a.a.h;
                            if (onKeyEventListener != null) {
                                onKeyEventListener.onKeyEvent(message.arg1);
                                return;
                            }
                            return;
                        case 18:
                            try {
                                UiMessage.CommandToUi parseFrom = UiMessage.CommandToUi.parseFrom((ByteString) message.obj);
                                if (parseFrom != null) {
                                    d.this.d.a(parseFrom);
                                    return;
                                }
                                return;
                            } catch (InvalidProtocolBufferException e) {
                                e.printStackTrace();
                                return;
                            }
                        case 19:
                            if (d.this.f2770c.m != null) {
                                d.this.f2770c.m.onCallback(message.arg1, (String) message.obj);
                                return;
                            }
                            return;
                        case 20:
                            if (d.this.f2770c.n != null) {
                                d.this.f2770c.n.callback((String) message.obj);
                                return;
                            }
                            return;
                        case 21:
                            if (d.this.f2770c.o != null) {
                                d.this.f2770c.o.callback(message.arg1, (String) message.obj);
                                return;
                            }
                            return;
                        case 22:
                            if (d.this.f2770c.q != null) {
                                d.this.f2770c.q.doSpecialFuction(message.arg1, (String) message.obj);
                                return;
                            }
                            return;
                        case 23:
                            com.cyjh.mobileanjian.ipc.view.b bVar = new com.cyjh.mobileanjian.ipc.view.b(d.this.f2768a);
                            Ipc.IpcMessage ipcMessage4 = (Ipc.IpcMessage) message.obj;
                            bVar.a(ipcMessage4.getArg1(0), ipcMessage4.getArg1(1), ipcMessage4.getArg2(0));
                            return;
                        case 24:
                            if (d.this.f2770c.l != null) {
                                d.this.f2770c.l.onSetControlBarVisiable(message.arg1);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
            }
        }
    };
    private TessBaseAPI f = null;
    private boolean g = false;

    public d(Context context, b bVar) {
        this.f2768a = context;
        this.d = new h(this.f2768a);
        this.f2769b = new a(this.f2768a);
        this.f2770c = bVar;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f2768a.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.densityDpi;
        int i3 = displayMetrics.widthPixels;
        int i4 = displayMetrics.heightPixels;
        String d2 = this.f2769b.d();
        String c2 = this.f2769b.c();
        String b2 = this.f2769b.b();
        String str = this.f2768a.getPackageName() + "/" + InputKb.class.getName();
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String str2 = UUID.randomUUID().toString() + ".tmp";
        d2 = d2 == null ? "UNKNOW" : d2;
        c2 = c2 == null ? "UNKNOW" : c2;
        File file = new File(absolutePath, str2);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        Ipc.IpcMessage.Builder cmd = Ipc.IpcMessage.newBuilder().setCmd(14);
        cmd.addArg1(i2).addArg1(i3).addArg1(i4).addArg2(d2).addArg2(c2).addArg2(b2).addArg2(str).addArg2(str2).addArg2(absolutePath).addArg2(this.f2768a.getPackageName());
        this.f2770c.a(cmd.build());
    }

    private void a(Ipc.IpcMessage ipcMessage) {
        InputConnection currentInputConnection;
        Ipc.IpcMessage ipcMessage2;
        Ipc.IpcMessage ipcMessage3 = ipcMessage;
        if (ipcMessage3 != null) {
            new StringBuilder("handMessage msg.getCmd() -> ").append(ipcMessage.getCmd());
            OnRecordScriptCallback onRecordScriptCallback = this.f2770c.h;
            int cmd = ipcMessage.getCmd();
            boolean z2 = true;
            int i2 = 0;
            switch (cmd) {
                case 4:
                    this.f2770c.e = true;
                    a(R.string.toast_on_start_script);
                    this.e.sendEmptyMessage(2);
                    return;
                case 5:
                    this.e.sendEmptyMessage(4);
                    return;
                case 6:
                    this.f2769b.a();
                    a.f();
                    int arg1 = ipcMessage3.getArg1(0);
                    this.f2770c.e = false;
                    if (arg1 == 105 || arg1 == 0) {
                        a(R.string.toast_on_stop_script);
                    }
                    this.e.obtainMessage(3, arg1, 0, ipcMessage3.getArg2(0)).sendToTarget();
                    return;
                default:
                    switch (cmd) {
                        case 27:
                            OnUiElementCallback onUiElementCallback = this.f2770c.p;
                            if (onUiElementCallback != null) {
                                onUiElementCallback.onUiElementback(ipcMessage3.getArg2(0));
                                return;
                            }
                            return;
                        case 28:
                            String valueOf = String.valueOf((ipcMessage3.getArg1(0) << 16) | ipcMessage3.getArg1(1));
                            OnUiElementCallback onUiElementCallback2 = this.f2770c.p;
                            if (onUiElementCallback2 != null) {
                                onUiElementCallback2.onScreenShotDone(valueOf, ipcMessage.getFileData());
                                return;
                            }
                            return;
                        default:
                            switch (cmd) {
                                case 32:
                                    OnScriptMessageCallback onScriptMessageCallback = this.f2770c.j;
                                    if (onScriptMessageCallback != null) {
                                        onScriptMessageCallback.onTracePrint(ipcMessage3.getArg2(0));
                                        return;
                                    }
                                    return;
                                case 33:
                                    this.e.obtainMessage(1, ipcMessage3).sendToTarget();
                                    return;
                                case 34:
                                    this.f2769b.a(ipcMessage3.getArg1(0));
                                    return;
                                case 35:
                                    a.c(ipcMessage3.getArg2(0));
                                    return;
                                case 36:
                                    this.f2769b.a(ipcMessage3.getArg2(0));
                                    return;
                                case 37:
                                    this.f2769b.b(ipcMessage3.getArg1(0));
                                    return;
                                case 38:
                                    a aVar = this.f2769b;
                                    String arg2 = ipcMessage3.getArg2(0);
                                    com.ime.input.a aVar2 = aVar.f2535b;
                                    if (!(aVar2.f3525a == null || (currentInputConnection = aVar2.f3525a.getCurrentInputConnection()) == null)) {
                                        currentInputConnection.commitText(arg2, arg2.length());
                                    }
                                    this.f2770c.a(com.cyjh.mobileanjian.ipc.share.proto.b.a(38));
                                    return;
                                case 39:
                                    this.f2769b.b(ipcMessage3.getArg2(0));
                                    return;
                                case 40:
                                    this.e.obtainMessage(16, (int) (ipcMessage3.getArg3(0) * 100.0f), ipcMessage3.getArg1(0), Integer.valueOf(ipcMessage3.getArg1(1))).sendToTarget();
                                    return;
                                case 41:
                                    this.f2769b.e();
                                    return;
                                case 42:
                                    this.e.sendEmptyMessage(8);
                                    return;
                                case 43:
                                    this.e.sendEmptyMessage(9);
                                    return;
                                case 44:
                                    this.e.obtainMessage(24, Integer.valueOf(ipcMessage3.getArg1(0))).sendToTarget();
                                    return;
                                default:
                                    switch (cmd) {
                                        case 50:
                                            this.f2770c.s.onRpcReturn(ipcMessage3.getArg2(0));
                                            return;
                                        case 51:
                                            a.f();
                                            return;
                                        case 52:
                                            com.cyjh.mobileanjian.ipc.utils.d.a(this.f2768a, ipcMessage3.getArg2(0), ipcMessage3.getArg2(1), ipcMessage3.getArg2(2));
                                            return;
                                        case 53:
                                            com.cyjh.mobileanjian.ipc.utils.d.a(this.f2768a, ipcMessage3.getArg2(0));
                                            return;
                                        case 54:
                                            com.cyjh.mobileanjian.ipc.utils.d.a(this.f2768a);
                                            return;
                                        case 55:
                                            this.f2769b.g();
                                            return;
                                        case 56:
                                            this.f2769b.h();
                                            return;
                                        case 57:
                                            this.f2769b.c(ipcMessage3.getArg1(0));
                                            return;
                                        case 58:
                                            this.f2769b.d(ipcMessage3.getArg1(0));
                                            return;
                                        case 59:
                                            this.f2769b.e(ipcMessage3.getArg1(0));
                                            return;
                                        default:
                                            switch (cmd) {
                                                case 64:
                                                    this.e.obtainMessage(18, ipcMessage.getFileData()).sendToTarget();
                                                    return;
                                                case 65:
                                                    return;
                                                case 66:
                                                    this.e.obtainMessage(6, ipcMessage3).sendToTarget();
                                                    return;
                                                case 67:
                                                    this.e.obtainMessage(7, ipcMessage3).sendToTarget();
                                                    return;
                                                default:
                                                    switch (cmd) {
                                                        case 98:
                                                            this.e.obtainMessage(20, ipcMessage3.getArg2(0)).sendToTarget();
                                                            return;
                                                        case 99:
                                                            this.e.obtainMessage(22, ipcMessage3.getArg1(0), 0, ipcMessage3.getArg2(0)).sendToTarget();
                                                            return;
                                                        case 100:
                                                            String arg22 = ipcMessage3.getArg2(0);
                                                            String arg23 = ipcMessage3.getArg2(1);
                                                            Log.e("InsertImageToGallery", "InsertImageToGallery:" + arg22 + "|" + arg23);
                                                            File file = new File(arg22);
                                                            if (Build.VERSION.SDK_INT < 29) {
                                                                try {
                                                                    MediaStore.Images.Media.insertImage(this.f2768a.getContentResolver(), file.getAbsolutePath(), file.getName(), (String) null);
                                                                } catch (FileNotFoundException e2) {
                                                                    e2.printStackTrace();
                                                                }
                                                            } else {
                                                                ContentValues contentValues = new ContentValues();
                                                                contentValues.put("_display_name", arg23);
                                                                contentValues.put("mime_type", "image/jpeg");
                                                                contentValues.put("relative_path", Environment.DIRECTORY_DCIM);
                                                                ContentResolver contentResolver = this.f2768a.getContentResolver();
                                                                Uri insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                                                                if (insert == null) {
                                                                    Log.e("InsertImageToGallery", "图片保存失败:" + arg22 + "|" + arg23);
                                                                    return;
                                                                }
                                                                try {
                                                                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                                                                    OutputStream openOutputStream = contentResolver.openOutputStream(insert);
                                                                    FileUtils.copy(bufferedInputStream, openOutputStream);
                                                                    bufferedInputStream.close();
                                                                    openOutputStream.close();
                                                                    file.delete();
                                                                } catch (IOException e3) {
                                                                    e3.printStackTrace();
                                                                }
                                                            }
                                                            if (Build.VERSION.SDK_INT >= 19) {
                                                                MediaScannerConnection.scanFile(this.f2768a, new String[]{file.getAbsolutePath()}, (String[]) null, (MediaScannerConnection.OnScanCompletedListener) null);
                                                                return;
                                                            }
                                                            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                                                            intent.setData(Uri.fromFile(file));
                                                            this.f2768a.sendBroadcast(intent);
                                                            return;
                                                        case 101:
                                                            String arg24 = ipcMessage3.getArg2(0);
                                                            ipcMessage3.getArg2(1);
                                                            File file2 = new File(arg24);
                                                            ContentResolver contentResolver2 = this.f2768a.getContentResolver();
                                                            ContentValues contentValues2 = new ContentValues();
                                                            contentValues2.put("title", file2.getName());
                                                            contentValues2.put("_display_name", file2.getName());
                                                            contentValues2.put("mime_type", "video/3gp");
                                                            contentValues2.put("datetaken", Long.valueOf(System.currentTimeMillis()));
                                                            contentValues2.put("date_modified", Long.valueOf(System.currentTimeMillis()));
                                                            contentValues2.put("date_added", Long.valueOf(System.currentTimeMillis()));
                                                            contentValues2.put("_data", file2.getAbsolutePath());
                                                            contentValues2.put("_size", Long.valueOf(file2.length()));
                                                            this.f2768a.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", contentResolver2.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues2)));
                                                            return;
                                                        case 102:
                                                            String str = "_data like \"" + ipcMessage3.getArg2(0) + "%\"";
                                                            this.f2768a.getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, str, (String[]) null);
                                                            this.f2768a.getContentResolver().delete(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, str, (String[]) null);
                                                            return;
                                                        case 103:
                                                            if (ipcMessage3.getArg1(0) != 1) {
                                                                z2 = false;
                                                            }
                                                            ((WifiManager) this.f2768a.getSystemService("wifi")).setWifiEnabled(z2);
                                                            return;
                                                        case 104:
                                                            if (ipcMessage3.getArg1(0) == 1) {
                                                                i2 = 1;
                                                            }
                                                            Settings.System.putInt(this.f2769b.f2534a.getContentResolver(), "accelerometer_rotation", i2 ^ 1);
                                                            return;
                                                        case 105:
                                                            if (ipcMessage3.getArg1(0) != 1) {
                                                                z2 = false;
                                                            }
                                                            a aVar3 = this.f2769b;
                                                            Settings.System.putInt(aVar3.f2534a.getContentResolver(), "airplane_mode_on", z2 ? 1 : 0);
                                                            Intent intent2 = new Intent("android.intent.action.AIRPLANE_MODE");
                                                            intent2.putExtra("state", z2);
                                                            aVar3.f2534a.sendBroadcast(intent2);
                                                            return;
                                                        case 106:
                                                            this.f2770c.a(Ipc.IpcMessage.newBuilder().setCmd(106).addArg2(this.f2769b.i()).build());
                                                            return;
                                                        case 107:
                                                            this.f2770c.a(Ipc.IpcMessage.newBuilder().setCmd(107).addArg2(this.f2769b.d(ipcMessage3.getArg2(0))).build());
                                                            return;
                                                        case 108:
                                                            this.f2770c.a(Ipc.IpcMessage.newBuilder().setCmd(108).addArg2(this.f2769b.j()).build());
                                                            return;
                                                        case 109:
                                                            String a2 = a(ipcMessage3.getArg2Bytes(0), ipcMessage3.getArg1(0), ipcMessage3.getArg1(1), ipcMessage3.getArg1(2));
                                                            Log.e("GET_OCR_TEXT", "strOrcText:" + a2);
                                                            this.f2770c.a(Ipc.IpcMessage.newBuilder().setCmd(109).addArg2(a2).build());
                                                            return;
                                                        case 110:
                                                            this.e.obtainMessage(23, ipcMessage3).sendToTarget();
                                                            return;
                                                        case 111:
                                                            ipcMessage3.getArg1(0);
                                                            this.f2769b.k();
                                                            return;
                                                        case 112:
                                                            a(ipcMessage3.getArg2(0), ipcMessage3.getArg2(1), ipcMessage3.getArg1(0));
                                                            return;
                                                        case 113:
                                                            if (ipcMessage3.getArg1(0) == 1) {
                                                                com.cyjh.mq.d.c.a(this.f2768a);
                                                                return;
                                                            }
                                                            return;
                                                        default:
                                                            switch (cmd) {
                                                                case 272:
                                                                    Injector.KeyPressAB(ipcMessage3.getArg1(0));
                                                                    return;
                                                                case 273:
                                                                    Injector.dispatchGestureMoveAB(ipcMessage3.getArg2(0));
                                                                    break;
                                                                case com.cyjh.mobileanjian.ipc.share.proto.a.aQ:
                                                                    break;
                                                                case com.cyjh.mobileanjian.ipc.share.proto.a.aR:
                                                                    Injector.SwipeAB(ipcMessage3.getArg3(0), ipcMessage3.getArg3(1), ipcMessage3.getArg3(2), ipcMessage3.getArg3(3), ipcMessage3.getArg1(0));
                                                                    return;
                                                                case com.cyjh.mobileanjian.ipc.share.proto.a.aS:
                                                                    Injector.TapAB(ipcMessage3.getArg3(0), ipcMessage3.getArg3(1), ipcMessage3.getArg1(0));
                                                                    return;
                                                                default:
                                                                    switch (cmd) {
                                                                        case 14:
                                                                            a.C0045a aVar4 = new a.C0045a();
                                                                            aVar4.f2752a = ipcMessage3.getArg1(0);
                                                                            aVar4.f2753b = ipcMessage3.getArg1(1);
                                                                            if (ipcMessage3.getArg1(2) == 0) {
                                                                                z2 = false;
                                                                            }
                                                                            aVar4.f2754c = z2;
                                                                            this.f2770c.f = new com.cyjh.mq.b.a(aVar4, (byte) 0);
                                                                            new Thread() {
                                                                                public final void run(
/*
Method generation error in method: com.cyjh.mq.c.b.2.run():void, dex: classes.dex
                                                                                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.cyjh.mq.c.b.2.run():void, class status: UNLOADED
                                                                                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                                                                                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                                                                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                                                                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                                                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                                                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                                                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                                                                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                                                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                                                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                                                                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                                                                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                                                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                                                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                                                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                                                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                                                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                                                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                                                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                                                                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:91)
                                                                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:697)
                                                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                                                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                                                	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:298)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                                                	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:302)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                                                	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:302)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                                                	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:302)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                                                	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:302)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                                                	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:302)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                                                	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:302)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                                                	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:302)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                                                                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                                                                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                                                                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                                                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                                                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                                                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                                                                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                                                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                                                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                                                                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                                                                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                                                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                                                                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                                                                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                                                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                                                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                                                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                                                                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                                                                                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                                                                                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                                                                                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                                                                                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                                                                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                                                                                
*/
                                                                            }.start();
                                                                            return;
                                                                        case 19:
                                                                            if (onRecordScriptCallback != null) {
                                                                                onRecordScriptCallback.onOpenRecord();
                                                                                return;
                                                                            }
                                                                            return;
                                                                        case 21:
                                                                            int arg12 = ipcMessage3.getArg1(0);
                                                                            if (onRecordScriptCallback != null) {
                                                                                onRecordScriptCallback.onStartRecord(arg12);
                                                                                return;
                                                                            }
                                                                            return;
                                                                        case 23:
                                                                            String arg25 = ipcMessage3.getArg2(0);
                                                                            if (onRecordScriptCallback != null) {
                                                                                onRecordScriptCallback.onFinishRecord(arg25);
                                                                                return;
                                                                            }
                                                                            return;
                                                                        case 25:
                                                                            int arg13 = ipcMessage3.getArg1(0);
                                                                            int arg14 = ipcMessage3.getArg1(1);
                                                                            int arg15 = ipcMessage3.getArg1(2);
                                                                            String valueOf2 = String.valueOf((arg13 << 16) | arg14);
                                                                            OnScreenShotCallback onScreenShotCallback = this.f2770c.i;
                                                                            if (arg15 == 0) {
                                                                                this.f2770c.d = false;
                                                                            }
                                                                            if (onScreenShotCallback != null) {
                                                                                onScreenShotCallback.onScreenShotDone(valueOf2, ipcMessage.getFileData());
                                                                                return;
                                                                            }
                                                                            return;
                                                                        case 48:
                                                                            Object invoke = Invocator.invoke(ipcMessage.getPkgName(), ipcMessage.getClassName(), ipcMessage.getMethodName(), ipcMessage.getTypesList(), ipcMessage.getParamsList(), 0);
                                                                            new StringBuilder("retObj = ").append(invoke);
                                                                            if (ipcMessage.getIsSyncCall()) {
                                                                                Ipc.FundType type = ipcMessage.getRetValue().getType();
                                                                                Ipc.ReturnValue.Builder type2 = Ipc.ReturnValue.newBuilder().setType(type);
                                                                                Ipc.IpcMessage.Builder waitId = Ipc.IpcMessage.newBuilder().setCmd(ipcMessage.getCmd()).setIsSyncCall(true).setWaitId(ipcMessage.getWaitId());
                                                                                try {
                                                                                    switch (type) {
                                                                                        case BOOLEAN:
                                                                                            type2.setValBoolean(((Boolean) invoke).booleanValue());
                                                                                            break;
                                                                                        case INT:
                                                                                            type2.setValInt(((Integer) invoke).intValue());
                                                                                            break;
                                                                                        case LONG:
                                                                                            type2.setValLong(((Long) invoke).longValue());
                                                                                            break;
                                                                                        case FLOAT:
                                                                                            type2.setValFloat(((Float) invoke).floatValue());
                                                                                            break;
                                                                                        case DOUBLE:
                                                                                            type2.setValDouble(((Double) invoke).doubleValue());
                                                                                            break;
                                                                                        case STRING:
                                                                                            type2.setValString(invoke == null ? "" : (String) invoke);
                                                                                            break;
                                                                                    }
                                                                                } catch (Throwable th) {
                                                                                    th.printStackTrace();
                                                                                }
                                                                                if (type != Ipc.FundType.VOID) {
                                                                                    waitId.setRetValue(type2.build());
                                                                                }
                                                                                try {
                                                                                    ipcMessage2 = waitId.build();
                                                                                } catch (UninitializedMessageException e4) {
                                                                                    e4.printStackTrace();
                                                                                    ipcMessage2 = null;
                                                                                }
                                                                                if (ipcMessage2 != null) {
                                                                                    this.f2770c.a(ipcMessage2);
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            }
                                                                            return;
                                                                        case 81:
                                                                            this.e.obtainMessage(21, ipcMessage3.getArg1(0), 0, ipcMessage3.getArg2(0)).sendToTarget();
                                                                            return;
                                                                        case 96:
                                                                            this.e.obtainMessage(19, ipcMessage3.getArg1(0), 0, ipcMessage3.getArg2(0)).sendToTarget();
                                                                            return;
                                                                        case com.cyjh.mobileanjian.ipc.share.proto.a.aG:
                                                                            this.e.obtainMessage(17, ipcMessage3.getArg1(0), 0).sendToTarget();
                                                                            return;
                                                                        case 257:
                                                                            OnScriptMessageCallback onScriptMessageCallback2 = this.f2770c.j;
                                                                            if (onScriptMessageCallback2 != null) {
                                                                                onScriptMessageCallback2.onDebugMessage(ipcMessage.getFileData());
                                                                                return;
                                                                            }
                                                                            return;
                                                                        case 65535:
                                                                            this.f2770c.c();
                                                                            return;
                                                                        default:
                                                                            return;
                                                                    }
                                                            }
                                                            Injector.sendTextAB(ipcMessage3.getArg2(0));
                                                            return;
                                                    }
                                            }
                                    }
                            }
                    }
            }
        }
    }

    private void a(String str) {
        this.e.obtainMessage(5, str).sendToTarget();
    }

    private void a(String str, String str2) {
        Log.e("InsertImageToGallery", "InsertImageToGallery:" + str + "|" + str2);
        File file = new File(str);
        if (Build.VERSION.SDK_INT < 29) {
            try {
                MediaStore.Images.Media.insertImage(this.f2768a.getContentResolver(), file.getAbsolutePath(), file.getName(), (String) null);
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", str2);
            contentValues.put("mime_type", "image/jpeg");
            contentValues.put("relative_path", Environment.DIRECTORY_DCIM);
            ContentResolver contentResolver = this.f2768a.getContentResolver();
            Uri insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            if (insert == null) {
                Log.e("InsertImageToGallery", "图片保存失败:" + str + "|" + str2);
                return;
            }
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                OutputStream openOutputStream = contentResolver.openOutputStream(insert);
                FileUtils.copy(bufferedInputStream, openOutputStream);
                bufferedInputStream.close();
                openOutputStream.close();
                file.delete();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        if (Build.VERSION.SDK_INT >= 19) {
            MediaScannerConnection.scanFile(this.f2768a, new String[]{file.getAbsolutePath()}, (String[]) null, (MediaScannerConnection.OnScanCompletedListener) null);
            return;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(file));
        this.f2768a.sendBroadcast(intent);
    }

    public static void a(String str, String str2, int i2) {
        com.google.a.c.b bVar;
        com.google.a.i.b bVar2 = new com.google.a.i.b();
        HashMap hashMap = new HashMap();
        hashMap.put(g.CHARACTER_SET, "utf-8");
        hashMap.put(g.ERROR_CORRECTION, f.M);
        hashMap.put(g.MARGIN, 2);
        try {
            bVar = bVar2.a(str2, com.google.a.a.QR_CODE, i2, i2, hashMap);
        } catch (w e2) {
            e2.printStackTrace();
            bVar = null;
        }
        int[] iArr = new int[(i2 * i2)];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (bVar.a(i3, i4)) {
                    iArr[(i3 * i2) + i4] = -16777216;
                } else {
                    iArr[(i3 * i2) + i4] = -1;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr, i2, i2, Bitmap.Config.RGB_565);
        if (createBitmap != null) {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                createBitmap.compress(str.endsWith(".png") ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException e3) {
                Log.e("RootIpcDex", "ImageQREnCode IOException" + e3.toString());
            }
        }
    }

    private void a(boolean z2) {
        ((WifiManager) this.f2768a.getSystemService("wifi")).setWifiEnabled(z2);
    }

    private boolean a() {
        File file = new File(this.f2768a.getFilesDir().getAbsolutePath() + "/tessdata/", com.cyjh.common.b.a.aQ);
        File file2 = new File(this.f2768a.getFilesDir().getAbsolutePath() + "/tessdata/", com.cyjh.common.b.a.aP);
        if (!file.exists() || !file2.exists()) {
            return false;
        }
        this.f = new TessBaseAPI();
        boolean a2 = this.f.a(this.f2768a.getFilesDir().getAbsolutePath(), "chi_sim+eng");
        Log.d("MqmHandler", "initTessBass: init ret=" + a2);
        return a2;
    }

    private void b() {
        this.f2770c.e = true;
        a(R.string.toast_on_start_script);
        this.e.sendEmptyMessage(2);
    }

    private void b(int i2) {
        if (i2 == 1) {
            com.cyjh.mq.d.c.a(this.f2768a);
        }
    }

    private void b(Ipc.IpcMessage ipcMessage) {
        a.C0045a aVar = new a.C0045a();
        aVar.f2752a = ipcMessage.getArg1(0);
        boolean z2 = true;
        aVar.f2753b = ipcMessage.getArg1(1);
        if (ipcMessage.getArg1(2) == 0) {
            z2 = false;
        }
        aVar.f2754c = z2;
        this.f2770c.f = new com.cyjh.mq.b.a(aVar, (byte) 0);
    }

    private void b(String str) {
        File file = new File(str);
        ContentResolver contentResolver = this.f2768a.getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", file.getName());
        contentValues.put("_display_name", file.getName());
        contentValues.put("mime_type", "video/3gp");
        contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("date_modified", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("date_added", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("_data", file.getAbsolutePath());
        contentValues.put("_size", Long.valueOf(file.length()));
        this.f2768a.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues)));
    }

    private void c() {
        this.e.sendEmptyMessage(8);
    }

    private void c(Ipc.IpcMessage ipcMessage) {
        this.f2769b.a();
        com.cyjh.mobileanjian.ipc.a.f();
        int arg1 = ipcMessage.getArg1(0);
        this.f2770c.e = false;
        if (arg1 == 105 || arg1 == 0) {
            a(R.string.toast_on_stop_script);
        }
        this.e.obtainMessage(3, arg1, 0, ipcMessage.getArg2(0)).sendToTarget();
    }

    private void c(String str) {
        String str2 = "_data like \"" + str + "%\"";
        this.f2768a.getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, str2, (String[]) null);
        this.f2768a.getContentResolver().delete(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, str2, (String[]) null);
    }

    private void d() {
        this.e.sendEmptyMessage(9);
    }

    private void d(Ipc.IpcMessage ipcMessage) {
        OnScriptMessageCallback onScriptMessageCallback = this.f2770c.j;
        if (onScriptMessageCallback != null) {
            onScriptMessageCallback.onTracePrint(ipcMessage.getArg2(0));
        }
    }

    private void e() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f2768a.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.densityDpi;
        int i3 = displayMetrics.widthPixels;
        int i4 = displayMetrics.heightPixels;
        String d2 = this.f2769b.d();
        String c2 = this.f2769b.c();
        String b2 = this.f2769b.b();
        String str = this.f2768a.getPackageName() + "/" + InputKb.class.getName();
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String str2 = UUID.randomUUID().toString() + ".tmp";
        if (d2 == null) {
            d2 = "UNKNOW";
        }
        if (c2 == null) {
            c2 = "UNKNOW";
        }
        File file = new File(absolutePath, str2);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        Ipc.IpcMessage.Builder cmd = Ipc.IpcMessage.newBuilder().setCmd(14);
        cmd.addArg1(i2).addArg1(i3).addArg1(i4).addArg2(d2).addArg2(c2).addArg2(b2).addArg2(str).addArg2(str2).addArg2(absolutePath).addArg2(this.f2768a.getPackageName());
        this.f2770c.a(cmd.build());
    }

    private void e(Ipc.IpcMessage ipcMessage) {
        OnScriptMessageCallback onScriptMessageCallback = this.f2770c.j;
        if (onScriptMessageCallback != null) {
            onScriptMessageCallback.onDebugMessage(ipcMessage.getFileData());
        }
    }

    private void f() {
        this.e.sendEmptyMessage(10);
    }

    private void f(Ipc.IpcMessage ipcMessage) {
        int arg1 = ipcMessage.getArg1(0);
        int arg12 = ipcMessage.getArg1(1);
        int arg13 = ipcMessage.getArg1(2);
        String valueOf = String.valueOf((arg1 << 16) | arg12);
        OnScreenShotCallback onScreenShotCallback = this.f2770c.i;
        if (arg13 == 0) {
            this.f2770c.d = false;
        }
        if (onScreenShotCallback != null) {
            onScreenShotCallback.onScreenShotDone(valueOf, ipcMessage.getFileData());
        }
    }

    private void g(Ipc.IpcMessage ipcMessage) {
        String valueOf = String.valueOf((ipcMessage.getArg1(0) << 16) | ipcMessage.getArg1(1));
        OnUiElementCallback onUiElementCallback = this.f2770c.p;
        if (onUiElementCallback != null) {
            onUiElementCallback.onScreenShotDone(valueOf, ipcMessage.getFileData());
        }
    }

    private void h(Ipc.IpcMessage ipcMessage) {
        OnUiElementCallback onUiElementCallback = this.f2770c.p;
        if (onUiElementCallback != null) {
            onUiElementCallback.onUiElementback(ipcMessage.getArg2(0));
        }
    }

    public final String a(ByteString byteString, int i2, int i3, int i4) {
        Log.e("TAG", "GetOrcText: width=" + i2 + " hight=" + i3 + " size=" + i4);
        byte[] byteArray = byteString.toByteArray();
        int i5 = i4 / 4;
        int[] iArr = new int[i5];
        boolean z2 = false;
        for (int i6 = 0; i6 < i5; i6++) {
            for (int i7 = 0; i7 < 4; i7++) {
                iArr[i6] = iArr[i6] + ((byteArray[(i6 * 4) + i7] & 255) << ((3 - i7) * 8));
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr, i2, i3, Bitmap.Config.ARGB_8888);
        if (!this.g) {
            File file = new File(this.f2768a.getFilesDir().getAbsolutePath() + "/tessdata/", com.cyjh.common.b.a.aQ);
            File file2 = new File(this.f2768a.getFilesDir().getAbsolutePath() + "/tessdata/", com.cyjh.common.b.a.aP);
            if (file.exists() && file2.exists()) {
                this.f = new TessBaseAPI();
                z2 = this.f.a(this.f2768a.getFilesDir().getAbsolutePath(), "chi_sim+eng");
                Log.d("MqmHandler", "initTessBass: init ret=" + z2);
            }
            this.g = z2;
        }
        if (!this.g) {
            return "";
        }
        this.f.a(createBitmap);
        String a2 = this.f.a();
        createBitmap.recycle();
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        Message obtainMessage = this.e.obtainMessage(5);
        obtainMessage.arg1 = i2;
        obtainMessage.sendToTarget();
    }
}
