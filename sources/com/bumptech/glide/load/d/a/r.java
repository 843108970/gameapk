package com.bumptech.glide.load.d.a;

import android.media.ExifInterface;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.util.a;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

@RequiresApi(27)
public final class r implements ImageHeaderParser {
    public final int a(@NonNull InputStream inputStream, @NonNull b bVar) throws IOException {
        int attributeInt = new ExifInterface(inputStream).getAttributeInt("Orientation", 1);
        if (attributeInt == 0) {
            return -1;
        }
        return attributeInt;
    }

    public final int a(@NonNull ByteBuffer byteBuffer, @NonNull b bVar) throws IOException {
        return a(a.b(byteBuffer), bVar);
    }

    @NonNull
    public final ImageHeaderParser.ImageType a(@NonNull InputStream inputStream) throws IOException {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @NonNull
    public final ImageHeaderParser.ImageType a(@NonNull ByteBuffer byteBuffer) throws IOException {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
