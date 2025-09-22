package com.bumptech.glide.load;

import android.support.annotation.Nullable;
import java.io.IOException;

public final class e extends IOException {
    public static final int UNKNOWN = -1;
    private static final long serialVersionUID = 1;
    private final int statusCode;

    public e(int i) {
        this("Http request failed with status code: " + i, i);
    }

    public e(String str) {
        this(str, -1);
    }

    public e(String str, int i) {
        this(str, i, (Throwable) null);
    }

    public e(String str, int i, @Nullable Throwable th) {
        super(str, th);
        this.statusCode = i;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }
}
