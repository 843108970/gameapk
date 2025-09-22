package com.bumptech.glide.load.c;

import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.j;
import com.bumptech.glide.util.a;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class c implements d<ByteBuffer> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1210a = "ByteBufferEncoder";

    private static boolean a(@NonNull ByteBuffer byteBuffer, @NonNull File file) {
        try {
            a.a(byteBuffer, file);
            return true;
        } catch (IOException e) {
            if (!Log.isLoggable(f1210a, 3)) {
                return false;
            }
            Log.d(f1210a, "Failed to write data", e);
            return false;
        }
    }

    public final /* bridge */ /* synthetic */ boolean a(@NonNull Object obj, @NonNull File file, @NonNull j jVar) {
        return a((ByteBuffer) obj, file);
    }
}
