package com.sun.mail.util;

import android.support.v7.widget.ActivityChooserView;
import java.io.OutputStream;

public class BEncoderStream extends BASE64EncoderStream {
    public BEncoderStream(OutputStream outputStream) {
        super(outputStream, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public static int encodedLength(byte[] bArr) {
        return ((bArr.length + 2) / 3) * 4;
    }
}
