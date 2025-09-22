package com.cyjh.mobileanjian.ipc.utils;

import android.os.Environment;
import android.text.format.DateFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private File f2710a;

    /* renamed from: b  reason: collision with root package name */
    private FileWriter f2711b;

    private f(String str) {
        this.f2710a = new File(Environment.getExternalStorageDirectory(), str);
        try {
            this.f2711b = new FileWriter(this.f2710a);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void a(String str) {
        if (this.f2711b != null) {
            String charSequence = DateFormat.format("yyyy-MM-hh HH:mm:ss", System.currentTimeMillis()).toString();
            try {
                FileWriter fileWriter = this.f2711b;
                fileWriter.write(charSequence + "  " + str + "\n");
                this.f2711b.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
