package com.cyjh.mq.c;

import android.net.LocalSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f2755a = 4096;

    /* renamed from: b  reason: collision with root package name */
    private Socket f2756b = null;

    /* renamed from: c  reason: collision with root package name */
    private LocalSocket f2757c = null;
    private InputStream d = null;
    private OutputStream e = null;

    public a(LocalSocket localSocket) {
        this.f2757c = localSocket;
        try {
            this.d = this.f2757c.getInputStream();
            this.e = this.f2757c.getOutputStream();
        } catch (IOException e2) {
            new StringBuilder("BaseSocketConnection(LocalSocket localSocket) e").append(e2.toString());
            e2.printStackTrace();
        }
    }

    public a(Socket socket) {
        this.f2756b = socket;
        try {
            this.d = this.f2756b.getInputStream();
            this.e = this.f2756b.getOutputStream();
        } catch (IOException e2) {
            new StringBuilder("BaseSocketConnection(Socket socket) e").append(e2.toString());
            e2.printStackTrace();
        }
    }

    private void b(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
    }

    /* access modifiers changed from: protected */
    public final int a(byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            try {
                i2 = this.d.read(bArr, i, length - i);
                if (i2 < 0) {
                    return -1;
                }
                i += i2;
            } catch (IOException e2) {
                e2.printStackTrace();
                new StringBuilder("receiveData e").append(e2.toString());
                return -1;
            }
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public void a() {
        try {
            if (this.f2756b != null) {
                this.f2756b.close();
            }
            if (this.f2757c != null) {
                this.f2757c.close();
            }
            if (this.d != null) {
                this.d.close();
            }
            if (this.e != null) {
                this.e.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(ByteBuffer byteBuffer) {
        try {
            byte[] bArr = new byte[4096];
            while (byteBuffer.hasRemaining()) {
                if (byteBuffer.remaining() < 4096) {
                    bArr = new byte[byteBuffer.remaining()];
                }
                byteBuffer.get(bArr);
                this.e.write(bArr);
            }
            this.e.flush();
        } catch (IOException e2) {
            e2.printStackTrace();
            new StringBuilder("sendData e").append(e2.toString());
        }
    }
}
