package com.umeng.commonsdk.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import com.umeng.commonsdk.framework.a;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.e;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class q {

    /* renamed from: b  reason: collision with root package name */
    private static final String f3805b = "/.um/.umm.dat";

    /* renamed from: c  reason: collision with root package name */
    private static final String f3806c = "/.uxx/.cca.dat";
    private static final String d = "/.cc/.adfwe.dat";
    private static final String e = "/.a.dat";
    private static final String f = "umdat";

    /* renamed from: a  reason: collision with root package name */
    private Context f3807a;

    public q(Context context) {
        this.f3807a = context;
    }

    private void a(String str, String str2) {
        if (DeviceConfig.checkPermission(this.f3807a, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            try {
                String externalStorageState = Environment.getExternalStorageState();
                if (externalStorageState != null && externalStorageState.equalsIgnoreCase("mounted")) {
                    String b2 = b(str2);
                    if (b2 == null || !b2.equals(str)) {
                        File file = new File(Environment.getExternalStorageDirectory() + str2);
                        if (file.getParentFile() != null && !file.getParentFile().exists()) {
                            file.getParentFile().mkdir();
                        }
                        RandomAccessFile randomAccessFile = new RandomAccessFile(Environment.getExternalStorageDirectory() + str2, "rw");
                        randomAccessFile.setLength((long) str.getBytes().length);
                        FileChannel channel = randomAccessFile.getChannel();
                        FileLock tryLock = channel.tryLock();
                        ByteBuffer allocate = ByteBuffer.allocate(1024);
                        allocate.clear();
                        allocate.put(str.getBytes());
                        allocate.flip();
                        while (allocate.hasRemaining()) {
                            channel.write(allocate);
                        }
                        channel.force(true);
                        if (tryLock != null) {
                            tryLock.release();
                        }
                        channel.close();
                    }
                }
            } catch (Exception e2) {
                e.e("saveFileUmtt:" + e2.getMessage());
            }
        }
    }

    private String b(String str) {
        String externalStorageState;
        try {
            if (DeviceConfig.checkPermission(this.f3807a, "android.permission.READ_EXTERNAL_STORAGE") && (externalStorageState = Environment.getExternalStorageState()) != null && externalStorageState.equalsIgnoreCase("mounted")) {
                if (!new File(Environment.getExternalStorageDirectory() + str).exists()) {
                    return null;
                }
                FileChannel channel = new RandomAccessFile(Environment.getExternalStorageDirectory() + str, "rw").getChannel();
                FileLock tryLock = channel.tryLock();
                StringBuilder sb = new StringBuilder();
                ByteBuffer allocate = ByteBuffer.allocate(1024);
                while (true) {
                    allocate.clear();
                    if (channel.read(allocate) == -1) {
                        break;
                    }
                    byte[] bArr = new byte[allocate.position()];
                    for (int i = 0; i < allocate.position(); i++) {
                        bArr[i] = allocate.get(i);
                    }
                    sb.append(new String(bArr));
                }
                if (channel != null) {
                    tryLock.release();
                }
                channel.close();
                return sb.toString();
            }
        } catch (Exception e2) {
            e.e("getFileUmtt:" + e2.getMessage());
        }
        return null;
    }

    private void c(String str) {
        SharedPreferences sharedPreferences = this.f3807a.getApplicationContext().getSharedPreferences(f, 0);
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("u", (String) null);
            if (string == null || !string.equals(str)) {
                sharedPreferences.edit().putString("u", str).commit();
            }
        }
    }

    private String h() {
        return a.a(this.f3807a, v.d, (String) null);
    }

    private String i() {
        SharedPreferences sharedPreferences = this.f3807a.getApplicationContext().getSharedPreferences(f, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("u", (String) null);
        }
        return null;
    }

    public String a() {
        String b2 = b();
        if (b2 == null || b2.equals("")) {
            b2 = g();
        }
        if (b2 == null || b2.equals("")) {
            b2 = c();
        }
        if (b2 == null || b2.equals("")) {
            b2 = d();
        }
        if (b2 == null || b2.equals("")) {
            b2 = e();
        }
        return (b2 == null || b2.equals("")) ? f() : b2;
    }

    public void a(String str) {
        a(str, f3805b);
        a(str, f3806c);
        a(str, d);
        a(str, e);
        c(str);
    }

    public String b() {
        return h();
    }

    public String c() {
        return b(f3805b);
    }

    public String d() {
        return b(f3806c);
    }

    public String e() {
        return b(d);
    }

    public String f() {
        return b(e);
    }

    public String g() {
        return i();
    }
}
