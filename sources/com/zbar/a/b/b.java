package com.zbar.a.b;

import android.graphics.Bitmap;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.cyjh.elfin.ui.activity.SweepCodeActivity;
import com.ywfzjbcy.R;
import com.zbar.a.c.c;
import com.zbar.lib.ZbarManager;
import java.io.File;
import java.io.FileOutputStream;

final class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    SweepCodeActivity f4003a = null;

    b(SweepCodeActivity sweepCodeActivity) {
        this.f4003a = sweepCodeActivity;
    }

    private void a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                bArr2[(((i4 * i2) + i2) - i3) - 1] = bArr[(i3 * i) + i4];
            }
        }
        String decode = new ZbarManager().decode(bArr2, i2, i, true, this.f4003a.j, this.f4003a.k, this.f4003a.l, this.f4003a.m);
        if (decode != null) {
            if (this.f4003a.f) {
                c cVar = new c(bArr2, i2, i, this.f4003a.j, this.f4003a.k, this.f4003a.l, this.f4003a.m);
                int i5 = cVar.f4012a / 2;
                int i6 = cVar.f4013b / 2;
                int[] iArr = new int[(i5 * i6)];
                byte[] bArr3 = cVar.f4014c;
                int i7 = (cVar.f * cVar.d) + cVar.e;
                for (int i8 = 0; i8 < i6; i8++) {
                    int i9 = i8 * i5;
                    for (int i10 = 0; i10 < i5; i10++) {
                        iArr[i9 + i10] = ((bArr3[(i10 * 2) + i7] & 255) * 65793) | -16777216;
                    }
                    i7 += cVar.d * 2;
                }
                int i11 = cVar.f4012a / 2;
                Bitmap createBitmap = Bitmap.createBitmap(iArr, 0, i11, i11, cVar.f4013b / 2, Bitmap.Config.ARGB_8888);
                try {
                    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Qrcode/";
                    File file = new File(str);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(str + "Qrcode.jpg");
                    if (file2.exists()) {
                        file2.delete();
                    }
                    file2.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.f4003a.d != null) {
                Message message = new Message();
                message.obj = decode;
                message.what = R.id.decode_succeeded;
                this.f4003a.d.sendMessage(message);
            }
        } else if (this.f4003a.d != null) {
            this.f4003a.d.sendEmptyMessage(R.id.decode_failed);
        }
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == R.id.decode) {
            byte[] bArr = (byte[]) message.obj;
            int i2 = message.arg1;
            int i3 = message.arg2;
            byte[] bArr2 = new byte[bArr.length];
            for (int i4 = 0; i4 < i3; i4++) {
                for (int i5 = 0; i5 < i2; i5++) {
                    bArr2[(((i5 * i3) + i3) - i4) - 1] = bArr[(i4 * i2) + i5];
                }
            }
            String decode = new ZbarManager().decode(bArr2, i3, i2, true, this.f4003a.j, this.f4003a.k, this.f4003a.l, this.f4003a.m);
            if (decode != null) {
                if (this.f4003a.f) {
                    c cVar = new c(bArr2, i3, i2, this.f4003a.j, this.f4003a.k, this.f4003a.l, this.f4003a.m);
                    int i6 = cVar.f4012a / 2;
                    int i7 = cVar.f4013b / 2;
                    int[] iArr = new int[(i6 * i7)];
                    byte[] bArr3 = cVar.f4014c;
                    int i8 = (cVar.f * cVar.d) + cVar.e;
                    for (int i9 = 0; i9 < i7; i9++) {
                        int i10 = i9 * i6;
                        for (int i11 = 0; i11 < i6; i11++) {
                            iArr[i10 + i11] = ((bArr3[(i11 * 2) + i8] & 255) * 65793) | -16777216;
                        }
                        i8 += cVar.d * 2;
                    }
                    int i12 = cVar.f4012a / 2;
                    Bitmap createBitmap = Bitmap.createBitmap(iArr, 0, i12, i12, cVar.f4013b / 2, Bitmap.Config.ARGB_8888);
                    try {
                        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Qrcode/";
                        File file = new File(str);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        File file2 = new File(str + "Qrcode.jpg");
                        if (file2.exists()) {
                            file2.delete();
                        }
                        file2.createNewFile();
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (this.f4003a.d != null) {
                    Message message2 = new Message();
                    message2.obj = decode;
                    message2.what = R.id.decode_succeeded;
                    this.f4003a.d.sendMessage(message2);
                }
            } else if (this.f4003a.d != null) {
                this.f4003a.d.sendEmptyMessage(R.id.decode_failed);
            }
        } else if (i == R.id.quit) {
            Looper.myLooper().quit();
        }
    }
}
